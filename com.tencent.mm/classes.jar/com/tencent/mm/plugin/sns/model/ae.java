package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.pluginsdk.model.t;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.concurrent.ExecutorService;

public final class ae
{
  public static boolean Kef;
  public static char[] QtR;
  public boolean QtO;
  public long QtP;
  private int QtQ;
  private MMHandler handler;
  
  static
  {
    int i = 0;
    Kef = false;
    QtR = new char[36];
    int j = 48;
    while (j <= 57)
    {
      QtR[i] = ((char)j);
      j += 1;
      i += 1;
    }
    j = 97;
    while (j <= 122)
    {
      QtR[i] = ((char)j);
      j += 1;
      i += 1;
    }
  }
  
  public ae()
  {
    AppMethodBeat.i(95695);
    this.QtO = false;
    this.QtP = 0L;
    this.QtQ = 0;
    this.handler = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(95689);
        super.handleMessage(paramAnonymousMessage);
        if ((ae.a(ae.this) >= 5) || (System.currentTimeMillis() - ae.b(ae.this) > 300000L))
        {
          Log.d("MicroMsg.RemoveSnsTask", "cleanCount: " + ae.a(ae.this));
          ae.Kef = false;
          AppMethodBeat.o(95689);
          return;
        }
        if (ae.c(ae.this))
        {
          AppMethodBeat.o(95689);
          return;
        }
        if (ae.Kef) {
          new ae.a(ae.this).A(new String[] { "" });
        }
        AppMethodBeat.o(95689);
      }
    };
    AppMethodBeat.o(95695);
  }
  
  public static void b(PInt paramPInt1, PInt paramPInt2)
  {
    if (paramPInt2.value + 1 >= 36)
    {
      paramPInt2.value = 0;
      paramPInt1.value = ((paramPInt1.value + 1) % 36);
      return;
    }
    paramPInt2.value = ((paramPInt2.value + 1) % 36);
  }
  
  public final class a
    extends t<String, String, Boolean>
  {
    private String QtT;
    PInt QtU;
    PInt QtV;
    private String QtW;
    private String key;
    private SharedPreferences sp;
    private String username;
    
    public a()
    {
      AppMethodBeat.i(95690);
      this.sp = null;
      this.QtT = "";
      this.key = "";
      this.QtU = new PInt();
      this.QtV = new PInt();
      this.sp = MMApplicationContext.getContext().getSharedPreferences("preferences_remove_task", 0);
      h.baF();
      if (!h.baC().aZN())
      {
        AppMethodBeat.o(95690);
        return;
      }
      this.username = z.bAM();
      this.QtT = ("remove_key_base" + this.username);
      this.key = ("remove_key" + this.username);
      h.baF();
      if (!h.baC().aZN())
      {
        AppMethodBeat.o(95690);
        return;
      }
      if (al.isInValid())
      {
        AppMethodBeat.o(95690);
        return;
      }
      if (al.hgi() == null)
      {
        AppMethodBeat.o(95690);
        return;
      }
      if (al.hgF() == null)
      {
        AppMethodBeat.o(95690);
        return;
      }
      u localu = al.hgF().aZW(this.username);
      if (localu != null) {
        this.QtW = localu.field_bgId;
      }
      Log.d("MicroMsg.RemoveSnsTask", "my bgid %s", new Object[] { this.QtW });
      ae.a(ae.this, true);
      AppMethodBeat.o(95690);
    }
    
    private Boolean hfM()
    {
      AppMethodBeat.i(95691);
      Log.d("MicroMsg.RemoveSnsTask", "simpleCleans sns");
      if (!ae.Kef)
      {
        localObject = Boolean.FALSE;
        AppMethodBeat.o(95691);
        return localObject;
      }
      if (!ae.c(ae.this))
      {
        localObject = Boolean.FALSE;
        AppMethodBeat.o(95691);
        return localObject;
      }
      if (al.isInValid())
      {
        ae.Kef = false;
        localObject = Boolean.FALSE;
        AppMethodBeat.o(95691);
        return localObject;
      }
      this.QtU.value = this.sp.getInt(this.QtT, 0);
      this.QtV.value = this.sp.getInt(this.key, 0);
      Object localObject = al.getAccSnsPath();
      try
      {
        long l = System.currentTimeMillis();
        if (!ae.aW((String)localObject + ae.QtR[(this.QtU.value % 36)] + "/" + ae.QtR[(this.QtV.value % 36)], this.QtW, this.username))
        {
          localObject = Boolean.FALSE;
          AppMethodBeat.o(95691);
          return localObject;
        }
        Log.d("MicroMsg.RemoveSnsTask", "clean sns uses time : " + (System.currentTimeMillis() - l) + " " + this.QtU.value + " " + this.QtV.value);
      }
      catch (Exception localException)
      {
        label254:
        break label254;
      }
      localObject = Boolean.TRUE;
      AppMethodBeat.o(95691);
      return localObject;
    }
    
    public final ExecutorService gDT()
    {
      AppMethodBeat.i(179088);
      ExecutorService localExecutorService = al.hgn();
      AppMethodBeat.o(179088);
      return localExecutorService;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ae
 * JD-Core Version:    0.7.0.1
 */