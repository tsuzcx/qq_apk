package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.concurrent.ExecutorService;

public final class aa
{
  public static boolean tYS;
  public static char[] xSN;
  private ao handler;
  public boolean xSK;
  public long xSL;
  private int xSM;
  
  static
  {
    int i = 0;
    tYS = false;
    xSN = new char[36];
    int j = 48;
    while (j <= 57)
    {
      xSN[i] = ((char)j);
      j += 1;
      i += 1;
    }
    j = 97;
    while (j <= 122)
    {
      xSN[i] = ((char)j);
      j += 1;
      i += 1;
    }
  }
  
  public aa()
  {
    AppMethodBeat.i(95695);
    this.xSK = false;
    this.xSL = 0L;
    this.xSM = 0;
    this.handler = new ao(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(95689);
        super.handleMessage(paramAnonymousMessage);
        if ((aa.a(aa.this) >= 5) || (System.currentTimeMillis() - aa.b(aa.this) > 300000L))
        {
          ac.d("MicroMsg.RemoveSnsTask", "cleanCount: " + aa.a(aa.this));
          aa.tYS = false;
          AppMethodBeat.o(95689);
          return;
        }
        if (aa.c(aa.this))
        {
          AppMethodBeat.o(95689);
          return;
        }
        if (aa.tYS) {
          new aa.a(aa.this).x(new String[] { "" });
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
    private String xSP;
    PInt xSQ;
    PInt xSR;
    private String xSS;
    
    public a()
    {
      AppMethodBeat.i(95690);
      this.sp = null;
      this.xSP = "";
      this.key = "";
      this.xSQ = new PInt();
      this.xSR = new PInt();
      this.sp = ai.getContext().getSharedPreferences("preferences_remove_task", 0);
      g.agS();
      if (!g.agP().afY())
      {
        AppMethodBeat.o(95690);
        return;
      }
      this.username = u.axw();
      this.xSP = ("remove_key_base" + this.username);
      this.key = ("remove_key" + this.username);
      g.agS();
      if (!g.agP().afY())
      {
        AppMethodBeat.o(95690);
        return;
      }
      if (af.dHA())
      {
        AppMethodBeat.o(95690);
        return;
      }
      if (af.agw() == null)
      {
        AppMethodBeat.o(95690);
        return;
      }
      if (af.dHV() == null)
      {
        AppMethodBeat.o(95690);
        return;
      }
      n localn = af.dHV().auY(this.username);
      if (localn != null) {
        this.xSS = localn.field_bgId;
      }
      ac.d("MicroMsg.RemoveSnsTask", "my bgid %s", new Object[] { this.xSS });
      aa.a(aa.this, true);
      AppMethodBeat.o(95690);
    }
    
    private Boolean dHl()
    {
      AppMethodBeat.i(95691);
      ac.d("MicroMsg.RemoveSnsTask", "simpleCleans sns");
      if (!aa.tYS)
      {
        localObject = Boolean.FALSE;
        AppMethodBeat.o(95691);
        return localObject;
      }
      if (!aa.c(aa.this))
      {
        localObject = Boolean.FALSE;
        AppMethodBeat.o(95691);
        return localObject;
      }
      if (af.dHA())
      {
        aa.tYS = false;
        localObject = Boolean.FALSE;
        AppMethodBeat.o(95691);
        return localObject;
      }
      this.xSQ.value = this.sp.getInt(this.xSP, 0);
      this.xSR.value = this.sp.getInt(this.key, 0);
      Object localObject = af.getAccSnsPath();
      try
      {
        long l = System.currentTimeMillis();
        if (!aa.au((String)localObject + aa.xSN[(this.xSQ.value % 36)] + "/" + aa.xSN[(this.xSR.value % 36)], this.xSS, this.username))
        {
          localObject = Boolean.FALSE;
          AppMethodBeat.o(95691);
          return localObject;
        }
        ac.d("MicroMsg.RemoveSnsTask", "clean sns uses time : " + (System.currentTimeMillis() - l) + " " + this.xSQ.value + " " + this.xSR.value);
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
    
    public final ExecutorService dBu()
    {
      AppMethodBeat.i(179088);
      ExecutorService localExecutorService = af.dHD();
      AppMethodBeat.o(179088);
      return localExecutorService;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aa
 * JD-Core Version:    0.7.0.1
 */