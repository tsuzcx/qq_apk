package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.concurrent.ExecutorService;

public final class ac
{
  public static char[] DJH;
  public static boolean yHD;
  public boolean DJE;
  public long DJF;
  private int DJG;
  private MMHandler handler;
  
  static
  {
    int i = 0;
    yHD = false;
    DJH = new char[36];
    int j = 48;
    while (j <= 57)
    {
      DJH[i] = ((char)j);
      j += 1;
      i += 1;
    }
    j = 97;
    while (j <= 122)
    {
      DJH[i] = ((char)j);
      j += 1;
      i += 1;
    }
  }
  
  public ac()
  {
    AppMethodBeat.i(95695);
    this.DJE = false;
    this.DJF = 0L;
    this.DJG = 0;
    this.handler = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(95689);
        super.handleMessage(paramAnonymousMessage);
        if ((ac.a(ac.this) >= 5) || (System.currentTimeMillis() - ac.b(ac.this) > 300000L))
        {
          Log.d("MicroMsg.RemoveSnsTask", "cleanCount: " + ac.a(ac.this));
          ac.yHD = false;
          AppMethodBeat.o(95689);
          return;
        }
        if (ac.c(ac.this))
        {
          AppMethodBeat.o(95689);
          return;
        }
        if (ac.yHD) {
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
    extends n<String, String, Boolean>
  {
    private String DJJ;
    PInt DJK;
    PInt DJL;
    private String DJM;
    private String key;
    private SharedPreferences sp;
    private String username;
    
    public a()
    {
      AppMethodBeat.i(95690);
      this.sp = null;
      this.DJJ = "";
      this.key = "";
      this.DJK = new PInt();
      this.DJL = new PInt();
      this.sp = MMApplicationContext.getContext().getSharedPreferences("preferences_remove_task", 0);
      g.aAi();
      if (!g.aAf().azp())
      {
        AppMethodBeat.o(95690);
        return;
      }
      this.username = z.aTY();
      this.DJJ = ("remove_key_base" + this.username);
      this.key = ("remove_key" + this.username);
      g.aAi();
      if (!g.aAf().azp())
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
      if (aj.faS() == null)
      {
        AppMethodBeat.o(95690);
        return;
      }
      l locall = aj.faS().aQr(this.username);
      if (locall != null) {
        this.DJM = locall.field_bgId;
      }
      Log.d("MicroMsg.RemoveSnsTask", "my bgid %s", new Object[] { this.DJM });
      ac.a(ac.this, true);
      AppMethodBeat.o(95690);
    }
    
    private Boolean fag()
    {
      AppMethodBeat.i(95691);
      Log.d("MicroMsg.RemoveSnsTask", "simpleCleans sns");
      if (!ac.yHD)
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
        ac.yHD = false;
        localObject = Boolean.FALSE;
        AppMethodBeat.o(95691);
        return localObject;
      }
      this.DJK.value = this.sp.getInt(this.DJJ, 0);
      this.DJL.value = this.sp.getInt(this.key, 0);
      Object localObject = aj.getAccSnsPath();
      try
      {
        long l = System.currentTimeMillis();
        if (!ac.aM((String)localObject + ac.DJH[(this.DJK.value % 36)] + "/" + ac.DJH[(this.DJL.value % 36)], this.DJM, this.username))
        {
          localObject = Boolean.FALSE;
          AppMethodBeat.o(95691);
          return localObject;
        }
        Log.d("MicroMsg.RemoveSnsTask", "clean sns uses time : " + (System.currentTimeMillis() - l) + " " + this.DJK.value + " " + this.DJL.value);
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
    
    public final ExecutorService eGk()
    {
      AppMethodBeat.i(179088);
      ExecutorService localExecutorService = aj.faA();
      AppMethodBeat.o(179088);
      return localExecutorService;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ac
 * JD-Core Version:    0.7.0.1
 */