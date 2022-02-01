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
  public static boolean sQF;
  public static char[] wGt;
  private ap handler;
  public boolean wGq;
  public long wGr;
  private int wGs;
  
  static
  {
    int i = 0;
    sQF = false;
    wGt = new char[36];
    int j = 48;
    while (j <= 57)
    {
      wGt[i] = ((char)j);
      j += 1;
      i += 1;
    }
    j = 97;
    while (j <= 122)
    {
      wGt[i] = ((char)j);
      j += 1;
      i += 1;
    }
  }
  
  public aa()
  {
    AppMethodBeat.i(95695);
    this.wGq = false;
    this.wGr = 0L;
    this.wGs = 0;
    this.handler = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(95689);
        super.handleMessage(paramAnonymousMessage);
        if ((aa.a(aa.this) >= 5) || (System.currentTimeMillis() - aa.b(aa.this) > 300000L))
        {
          ad.d("MicroMsg.RemoveSnsTask", "cleanCount: " + aa.a(aa.this));
          aa.sQF = false;
          AppMethodBeat.o(95689);
          return;
        }
        if (aa.c(aa.this))
        {
          AppMethodBeat.o(95689);
          return;
        }
        if (aa.sQF) {
          new aa.a(aa.this).v(new String[] { "" });
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
    private String wGv;
    PInt wGw;
    PInt wGx;
    private String wGy;
    
    public a()
    {
      AppMethodBeat.i(95690);
      this.sp = null;
      this.wGv = "";
      this.key = "";
      this.wGw = new PInt();
      this.wGx = new PInt();
      this.sp = aj.getContext().getSharedPreferences("preferences_remove_task", 0);
      g.afC();
      if (!g.afz().aeI())
      {
        AppMethodBeat.o(95690);
        return;
      }
      this.username = u.aqG();
      this.wGv = ("remove_key_base" + this.username);
      this.key = ("remove_key" + this.username);
      g.afC();
      if (!g.afz().aeI())
      {
        AppMethodBeat.o(95690);
        return;
      }
      if (af.dtd())
      {
        AppMethodBeat.o(95690);
        return;
      }
      if (af.afg() == null)
      {
        AppMethodBeat.o(95690);
        return;
      }
      if (af.dty() == null)
      {
        AppMethodBeat.o(95690);
        return;
      }
      n localn = af.dty().apP(this.username);
      if (localn != null) {
        this.wGy = localn.field_bgId;
      }
      ad.d("MicroMsg.RemoveSnsTask", "my bgid %s", new Object[] { this.wGy });
      aa.a(aa.this, true);
      AppMethodBeat.o(95690);
    }
    
    private Boolean dsN()
    {
      AppMethodBeat.i(95691);
      ad.d("MicroMsg.RemoveSnsTask", "simpleCleans sns");
      if (!aa.sQF)
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
      if (af.dtd())
      {
        aa.sQF = false;
        localObject = Boolean.FALSE;
        AppMethodBeat.o(95691);
        return localObject;
      }
      this.wGw.value = this.sp.getInt(this.wGv, 0);
      this.wGx.value = this.sp.getInt(this.key, 0);
      Object localObject = af.getAccSnsPath();
      try
      {
        long l = System.currentTimeMillis();
        if (!aa.as((String)localObject + aa.wGt[(this.wGw.value % 36)] + "/" + aa.wGt[(this.wGx.value % 36)], this.wGy, this.username))
        {
          localObject = Boolean.FALSE;
          AppMethodBeat.o(95691);
          return localObject;
        }
        ad.d("MicroMsg.RemoveSnsTask", "clean sns uses time : " + (System.currentTimeMillis() - l) + " " + this.wGw.value + " " + this.wGx.value);
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
    
    public final ExecutorService dnm()
    {
      AppMethodBeat.i(179088);
      ExecutorService localExecutorService = af.dtg();
      AppMethodBeat.o(179088);
      return localExecutorService;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aa
 * JD-Core Version:    0.7.0.1
 */