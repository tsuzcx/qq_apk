package com.tencent.soter.a.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.f.d.a;
import com.tencent.soter.a.f.d.b;
import com.tencent.soter.core.a;
import com.tencent.soter.core.c.c;
import com.tencent.soter.core.c.h;
import com.tencent.soter.core.c.h.a;
import java.nio.charset.Charset;

public class j
  extends d
{
  private static final String Mpm;
  private static final String Mpn;
  private com.tencent.soter.a.f.d MoB;
  private String MoC;
  private int[] MoD;
  private boolean Mpo;
  private String Mpp;
  private h.a Mpq;
  
  static
  {
    AppMethodBeat.i(112);
    Mpm = "soter_triggered_oom" + com.tencent.soter.core.c.g.getMessageDigest(a.fZe().getBytes(Charset.forName("UTF-8")));
    Mpn = "soter_triggered_oom_count" + com.tencent.soter.core.c.g.getMessageDigest(a.fZe().getBytes(Charset.forName("UTF-8")));
    AppMethodBeat.o(112);
  }
  
  public j(Context paramContext, e parame)
  {
    AppMethodBeat.i(107);
    this.Mpo = false;
    this.MoC = "";
    this.Mpp = "";
    this.Mpq = new h.a()
    {
      public final boolean fZj()
      {
        AppMethodBeat.i(103);
        SharedPreferences localSharedPreferences = com.tencent.soter.a.c.b.fZv().fZy();
        if (localSharedPreferences != null)
        {
          int i = localSharedPreferences.getInt(j.Mpn, 0);
          com.tencent.soter.core.c.d.i("Soter.TaskInit", "soter: is triggered OOM: %b", new Object[] { Integer.valueOf(i) });
          if (i >= 10)
          {
            AppMethodBeat.o(103);
            return true;
          }
          AppMethodBeat.o(103);
          return false;
        }
        AppMethodBeat.o(103);
        return false;
      }
      
      @SuppressLint({"ApplySharedPref"})
      public final void fZk()
      {
        AppMethodBeat.i(102);
        com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: on trigger OOM, using wrapper implement", new Object[0]);
        SharedPreferences localSharedPreferences = com.tencent.soter.a.c.b.fZv().fZy();
        if (localSharedPreferences != null)
        {
          SharedPreferences.Editor localEditor = localSharedPreferences.edit();
          int i = localSharedPreferences.getInt(j.Mpn, 0);
          localEditor.putInt(j.Mpn, i + 1);
          localEditor.commit();
        }
        AppMethodBeat.o(102);
      }
      
      public final void reset()
      {
        AppMethodBeat.i(104);
        SharedPreferences localSharedPreferences = com.tencent.soter.a.c.b.fZv().fZy();
        if (localSharedPreferences != null) {
          localSharedPreferences.edit().putInt(j.Mpn, 0).apply();
        }
        AppMethodBeat.o(104);
      }
    };
    Object localObject1 = parame.MoE;
    if (localObject1 != null) {
      com.tencent.soter.core.c.d.a((c)localObject1);
    }
    localObject1 = parame.MoG;
    if (localObject1 != null)
    {
      localObject2 = g.fZG();
      if ((((g)localObject2).MoO != null) && (((g)localObject2).MoO.isAlive()))
      {
        com.tencent.soter.core.c.d.i("Soter.SoterTaskThread", "quit the previous thread", new Object[0]);
        ((g)localObject2).MoO.quit();
      }
      ((g)localObject2).MoO = ((HandlerThread)localObject1);
      ((g)localObject2).MoO.setName("SoterGenKeyHandlerThreadName");
      if (!((HandlerThread)localObject1).isAlive()) {
        ((HandlerThread)localObject1).start();
      }
      ((g)localObject2).MoP = new Handler(((g)localObject2).MoO.getLooper());
    }
    localObject1 = com.tencent.soter.a.c.b.fZv();
    Object localObject2 = paramContext.getSharedPreferences("soter_status", 0);
    try
    {
      ((com.tencent.soter.a.c.b)localObject1).Mob = ((SharedPreferences)localObject2);
      h.a(this.Mpq);
      a.fYT();
      a.lh(paramContext);
      a.dlu();
      boolean bool1 = bool2;
      if (a.fYY()) {
        if (!a.fi(paramContext))
        {
          bool1 = bool2;
          if (!a.aT(paramContext, 2)) {}
        }
        else
        {
          bool1 = true;
        }
      }
      this.Mpo = bool1;
      this.MoB = parame.MoB;
      this.MoD = parame.MoD;
      this.MoC = parame.MoC;
      this.Mpp = parame.MoF;
      AppMethodBeat.o(107);
      return;
    }
    finally
    {
      AppMethodBeat.o(107);
    }
  }
  
  final void b(com.tencent.soter.a.b.e parame) {}
  
  final void execute()
  {
    AppMethodBeat.i(109);
    if (this.Mpo)
    {
      if (this.MoB == null)
      {
        com.tencent.soter.a.c.b.fZv().zG(true);
        com.tencent.soter.a.c.b.fZv().fZw();
        c(new com.tencent.soter.a.b.d(0));
        AppMethodBeat.o(109);
        return;
      }
      String str = a.fZe();
      this.MoB.setRequest(new d.a(str));
      this.MoB.a(new com.tencent.soter.a.f.b() {});
      this.MoB.execute();
      AppMethodBeat.o(109);
      return;
    }
    com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: TaskInit check isNativeSupport[" + this.Mpo + "]", new Object[0]);
    c(new com.tencent.soter.a.b.d(2));
    try
    {
      com.tencent.soter.a.c.b.fZv().zG(false);
      com.tencent.soter.a.c.b.fZv().fZw();
      return;
    }
    finally
    {
      AppMethodBeat.o(109);
    }
  }
  
  @SuppressLint({"DefaultLocale"})
  protected void f(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(110);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      String str = String.format("%suid%d_%s_scene%d", new Object[] { "Wechat", Integer.valueOf(Process.myUid()), com.tencent.soter.core.c.g.nullAsNil(paramString), Integer.valueOf(k) });
      com.tencent.soter.a.c.b.fZv().fZx().put(k, str);
      i += 1;
    }
    AppMethodBeat.o(110);
  }
  
  final boolean fZB()
  {
    AppMethodBeat.i(108);
    if (com.tencent.soter.a.c.b.fZv().fZr())
    {
      com.tencent.soter.core.c.d.e("Soter.TaskInit", "soter: duplicate initialize soter", new Object[0]);
      c(new com.tencent.soter.a.b.d(1028, "soter already have initialized"));
      AppMethodBeat.o(108);
      return true;
    }
    Object localObject = this.MoD;
    if ((localObject == null) || (localObject.length <= 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      com.tencent.soter.core.c.d.e("Soter.TaskInit", "soter: the salt string used to distinguish is longer than 24", new Object[0]);
      c(new com.tencent.soter.a.b.d(1024, "no business scene provided"));
      AppMethodBeat.o(108);
      return true;
    }
    if (com.tencent.soter.core.c.g.nullAsNil(this.MoC).length() > 16)
    {
      com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: the salt string used to distinguish is longer than 24. soter will try to make it compat", new Object[0]);
      localObject = com.tencent.soter.core.c.g.getMessageDigest(this.MoC.getBytes(Charset.forName("UTF-8")));
      if ((!com.tencent.soter.core.c.g.isNullOrNil((String)localObject)) && (((String)localObject).length() >= 16)) {}
      for (localObject = ((String)localObject).substring(0, 16); com.tencent.soter.core.c.g.isNullOrNil((String)localObject); localObject = null)
      {
        com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: saltlen compat failed!!", new Object[0]);
        c(new com.tencent.soter.a.b.d(1025, "the account salt length is too long"));
        AppMethodBeat.o(108);
        return true;
      }
      this.MoC = ((String)localObject);
    }
    if ((!com.tencent.soter.core.c.g.isNullOrNil(this.Mpp)) && (this.Mpp.length() > 24))
    {
      com.tencent.soter.core.c.d.e("Soter.TaskInit", "soter: the passed ask name is too long (larger than 24).", new Object[0]);
      c(new com.tencent.soter.a.b.d(1026, "the passed ask name is too long (larger than 24)"));
      AppMethodBeat.o(108);
      return true;
    }
    if (this.MoB == null) {
      com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: it is strongly recommended to check device support from server, so you'd better provider a net wrapper to check it", new Object[0]);
    }
    if (!com.tencent.soter.core.c.g.isNullOrNil(this.Mpp))
    {
      com.tencent.soter.core.c.d.i("Soter.TaskInit", "soter: provided valid ASK name", new Object[0]);
      com.tencent.soter.core.c.e.fZh().Mnn = this.Mpp;
    }
    g.fZG().ad(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(105);
        j.this.f(j.a(j.this), j.b(j.this));
        j.c(j.this);
        AppMethodBeat.o(105);
      }
    });
    AppMethodBeat.o(108);
    return false;
  }
  
  final void fZC() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.a.g.j
 * JD-Core Version:    0.7.0.1
 */