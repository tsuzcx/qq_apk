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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.concurrent.ExecutorService;

public final class aa
{
  public static boolean vbB;
  public static char[] ziH;
  private ap handler;
  public boolean ziE;
  public long ziF;
  private int ziG;
  
  static
  {
    int i = 0;
    vbB = false;
    ziH = new char[36];
    int j = 48;
    while (j <= 57)
    {
      ziH[i] = ((char)j);
      j += 1;
      i += 1;
    }
    j = 97;
    while (j <= 122)
    {
      ziH[i] = ((char)j);
      j += 1;
      i += 1;
    }
  }
  
  public aa()
  {
    AppMethodBeat.i(95695);
    this.ziE = false;
    this.ziF = 0L;
    this.ziG = 0;
    this.handler = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(95689);
        super.handleMessage(paramAnonymousMessage);
        if ((aa.a(aa.this) >= 5) || (System.currentTimeMillis() - aa.b(aa.this) > 300000L))
        {
          ad.d("MicroMsg.RemoveSnsTask", "cleanCount: " + aa.a(aa.this));
          aa.vbB = false;
          AppMethodBeat.o(95689);
          return;
        }
        if (aa.c(aa.this))
        {
          AppMethodBeat.o(95689);
          return;
        }
        if (aa.vbB) {
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
    private String ziJ;
    PInt ziK;
    PInt ziL;
    private String ziM;
    
    public a()
    {
      AppMethodBeat.i(95690);
      this.sp = null;
      this.ziJ = "";
      this.key = "";
      this.ziK = new PInt();
      this.ziL = new PInt();
      this.sp = aj.getContext().getSharedPreferences("preferences_remove_task", 0);
      g.ajD();
      if (!g.ajA().aiK())
      {
        AppMethodBeat.o(95690);
        return;
      }
      this.username = u.aAm();
      this.ziJ = ("remove_key_base" + this.username);
      this.key = ("remove_key" + this.username);
      g.ajD();
      if (!g.ajA().aiK())
      {
        AppMethodBeat.o(95690);
        return;
      }
      if (ag.dTN())
      {
        AppMethodBeat.o(95690);
        return;
      }
      if (ag.getDataDB() == null)
      {
        AppMethodBeat.o(95690);
        return;
      }
      if (ag.dUi() == null)
      {
        AppMethodBeat.o(95690);
        return;
      }
      n localn = ag.dUi().aAf(this.username);
      if (localn != null) {
        this.ziM = localn.field_bgId;
      }
      ad.d("MicroMsg.RemoveSnsTask", "my bgid %s", new Object[] { this.ziM });
      aa.a(aa.this, true);
      AppMethodBeat.o(95690);
    }
    
    private Boolean dTx()
    {
      AppMethodBeat.i(95691);
      ad.d("MicroMsg.RemoveSnsTask", "simpleCleans sns");
      if (!aa.vbB)
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
      if (ag.dTN())
      {
        aa.vbB = false;
        localObject = Boolean.FALSE;
        AppMethodBeat.o(95691);
        return localObject;
      }
      this.ziK.value = this.sp.getInt(this.ziJ, 0);
      this.ziL.value = this.sp.getInt(this.key, 0);
      Object localObject = ag.getAccSnsPath();
      try
      {
        long l = System.currentTimeMillis();
        if (!aa.aB((String)localObject + aa.ziH[(this.ziK.value % 36)] + "/" + aa.ziH[(this.ziL.value % 36)], this.ziM, this.username))
        {
          localObject = Boolean.FALSE;
          AppMethodBeat.o(95691);
          return localObject;
        }
        ad.d("MicroMsg.RemoveSnsTask", "clean sns uses time : " + (System.currentTimeMillis() - l) + " " + this.ziK.value + " " + this.ziL.value);
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
    
    public final ExecutorService dCe()
    {
      AppMethodBeat.i(179088);
      ExecutorService localExecutorService = ag.dTQ();
      AppMethodBeat.o(179088);
      return localExecutorService;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aa
 * JD-Core Version:    0.7.0.1
 */