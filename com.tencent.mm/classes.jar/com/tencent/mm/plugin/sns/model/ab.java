package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.concurrent.ExecutorService;

public final class ab
{
  public static boolean vnM;
  public static char[] zzW;
  private aq handler;
  public boolean zzT;
  public long zzU;
  private int zzV;
  
  static
  {
    int i = 0;
    vnM = false;
    zzW = new char[36];
    int j = 48;
    while (j <= 57)
    {
      zzW[i] = ((char)j);
      j += 1;
      i += 1;
    }
    j = 97;
    while (j <= 122)
    {
      zzW[i] = ((char)j);
      j += 1;
      i += 1;
    }
  }
  
  public ab()
  {
    AppMethodBeat.i(95695);
    this.zzT = false;
    this.zzU = 0L;
    this.zzV = 0;
    this.handler = new aq(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(95689);
        super.handleMessage(paramAnonymousMessage);
        if ((ab.a(ab.this) >= 5) || (System.currentTimeMillis() - ab.b(ab.this) > 300000L))
        {
          ae.d("MicroMsg.RemoveSnsTask", "cleanCount: " + ab.a(ab.this));
          ab.vnM = false;
          AppMethodBeat.o(95689);
          return;
        }
        if (ab.c(ab.this))
        {
          AppMethodBeat.o(95689);
          return;
        }
        if (ab.vnM) {
          new ab.a(ab.this).x(new String[] { "" });
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
    extends m<String, String, Boolean>
  {
    private String key;
    private SharedPreferences sp;
    private String username;
    PInt zAa;
    private String zAb;
    private String zzY;
    PInt zzZ;
    
    public a()
    {
      AppMethodBeat.i(95690);
      this.sp = null;
      this.zzY = "";
      this.key = "";
      this.zzZ = new PInt();
      this.zAa = new PInt();
      this.sp = ak.getContext().getSharedPreferences("preferences_remove_task", 0);
      g.ajS();
      if (!g.ajP().aiZ())
      {
        AppMethodBeat.o(95690);
        return;
      }
      this.username = v.aAC();
      this.zzY = ("remove_key_base" + this.username);
      this.key = ("remove_key" + this.username);
      g.ajS();
      if (!g.ajP().aiZ())
      {
        AppMethodBeat.o(95690);
        return;
      }
      if (ah.dXn())
      {
        AppMethodBeat.o(95690);
        return;
      }
      if (ah.getDataDB() == null)
      {
        AppMethodBeat.o(95690);
        return;
      }
      if (ah.dXI() == null)
      {
        AppMethodBeat.o(95690);
        return;
      }
      n localn = ah.dXI().aBw(this.username);
      if (localn != null) {
        this.zAb = localn.field_bgId;
      }
      ae.d("MicroMsg.RemoveSnsTask", "my bgid %s", new Object[] { this.zAb });
      ab.a(ab.this, true);
      AppMethodBeat.o(95690);
    }
    
    private Boolean dWX()
    {
      AppMethodBeat.i(95691);
      ae.d("MicroMsg.RemoveSnsTask", "simpleCleans sns");
      if (!ab.vnM)
      {
        localObject = Boolean.FALSE;
        AppMethodBeat.o(95691);
        return localObject;
      }
      if (!ab.c(ab.this))
      {
        localObject = Boolean.FALSE;
        AppMethodBeat.o(95691);
        return localObject;
      }
      if (ah.dXn())
      {
        ab.vnM = false;
        localObject = Boolean.FALSE;
        AppMethodBeat.o(95691);
        return localObject;
      }
      this.zzZ.value = this.sp.getInt(this.zzY, 0);
      this.zAa.value = this.sp.getInt(this.key, 0);
      Object localObject = ah.getAccSnsPath();
      try
      {
        long l = System.currentTimeMillis();
        if (!ab.aB((String)localObject + ab.zzW[(this.zzZ.value % 36)] + "/" + ab.zzW[(this.zAa.value % 36)], this.zAb, this.username))
        {
          localObject = Boolean.FALSE;
          AppMethodBeat.o(95691);
          return localObject;
        }
        ae.d("MicroMsg.RemoveSnsTask", "clean sns uses time : " + (System.currentTimeMillis() - l) + " " + this.zzZ.value + " " + this.zAa.value);
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
    
    public final ExecutorService dFv()
    {
      AppMethodBeat.i(179088);
      ExecutorService localExecutorService = ah.dXq();
      AppMethodBeat.o(179088);
      return localExecutorService;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ab
 * JD-Core Version:    0.7.0.1
 */