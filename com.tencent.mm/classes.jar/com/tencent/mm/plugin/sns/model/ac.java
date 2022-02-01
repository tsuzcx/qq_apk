package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.concurrent.ExecutorService;

public final class ac
{
  public static boolean Elw;
  public static char[] JWJ;
  public boolean JWG;
  public long JWH;
  private int JWI;
  private MMHandler handler;
  
  static
  {
    int i = 0;
    Elw = false;
    JWJ = new char[36];
    int j = 48;
    while (j <= 57)
    {
      JWJ[i] = ((char)j);
      j += 1;
      i += 1;
    }
    j = 97;
    while (j <= 122)
    {
      JWJ[i] = ((char)j);
      j += 1;
      i += 1;
    }
  }
  
  public ac()
  {
    AppMethodBeat.i(95695);
    this.JWG = false;
    this.JWH = 0L;
    this.JWI = 0;
    this.handler = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(95689);
        super.handleMessage(paramAnonymousMessage);
        if ((ac.a(ac.this) >= 5) || (System.currentTimeMillis() - ac.b(ac.this) > 300000L))
        {
          Log.d("MicroMsg.RemoveSnsTask", "cleanCount: " + ac.a(ac.this));
          ac.Elw = false;
          AppMethodBeat.o(95689);
          return;
        }
        if (ac.c(ac.this))
        {
          AppMethodBeat.o(95689);
          return;
        }
        if (ac.Elw) {
          new ac.a(ac.this).y(new String[] { "" });
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
    extends r<String, String, Boolean>
  {
    private String JWL;
    PInt JWM;
    PInt JWN;
    private String JWO;
    private String key;
    private SharedPreferences sp;
    private String username;
    
    public a()
    {
      AppMethodBeat.i(95690);
      this.sp = null;
      this.JWL = "";
      this.key = "";
      this.JWM = new PInt();
      this.JWN = new PInt();
      this.sp = MMApplicationContext.getContext().getSharedPreferences("preferences_remove_task", 0);
      h.aHH();
      if (!h.aHE().aGM())
      {
        AppMethodBeat.o(95690);
        return;
      }
      this.username = z.bcZ();
      this.JWL = ("remove_key_base" + this.username);
      this.key = ("remove_key" + this.username);
      h.aHH();
      if (!h.aHE().aGM())
      {
        AppMethodBeat.o(95690);
        return;
      }
      if (aj.isInValid())
      {
        AppMethodBeat.o(95690);
        return;
      }
      if (aj.getDataDB() == null)
      {
        AppMethodBeat.o(95690);
        return;
      }
      if (aj.fOM() == null)
      {
        AppMethodBeat.o(95690);
        return;
      }
      l locall = aj.fOM().bbr(this.username);
      if (locall != null) {
        this.JWO = locall.field_bgId;
      }
      Log.d("MicroMsg.RemoveSnsTask", "my bgid %s", new Object[] { this.JWO });
      ac.a(ac.this, true);
      AppMethodBeat.o(95690);
    }
    
    private Boolean fOg()
    {
      AppMethodBeat.i(95691);
      Log.d("MicroMsg.RemoveSnsTask", "simpleCleans sns");
      if (!ac.Elw)
      {
        localObject = Boolean.FALSE;
        AppMethodBeat.o(95691);
        return localObject;
      }
      if (!ac.c(ac.this))
      {
        localObject = Boolean.FALSE;
        AppMethodBeat.o(95691);
        return localObject;
      }
      if (aj.isInValid())
      {
        ac.Elw = false;
        localObject = Boolean.FALSE;
        AppMethodBeat.o(95691);
        return localObject;
      }
      this.JWM.value = this.sp.getInt(this.JWL, 0);
      this.JWN.value = this.sp.getInt(this.key, 0);
      Object localObject = aj.getAccSnsPath();
      try
      {
        long l = System.currentTimeMillis();
        if (!ac.aG((String)localObject + ac.JWJ[(this.JWM.value % 36)] + "/" + ac.JWJ[(this.JWN.value % 36)], this.JWO, this.username))
        {
          localObject = Boolean.FALSE;
          AppMethodBeat.o(95691);
          return localObject;
        }
        Log.d("MicroMsg.RemoveSnsTask", "clean sns uses time : " + (System.currentTimeMillis() - l) + " " + this.JWM.value + " " + this.JWN.value);
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
    
    public final ExecutorService fsl()
    {
      AppMethodBeat.i(179088);
      ExecutorService localExecutorService = aj.fOu();
      AppMethodBeat.o(179088);
      return localExecutorService;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ac
 * JD-Core Version:    0.7.0.1
 */