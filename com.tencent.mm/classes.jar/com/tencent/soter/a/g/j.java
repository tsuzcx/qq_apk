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
  private static final String LSp;
  private static final String LSq;
  private com.tencent.soter.a.f.d LRE;
  private String LRF;
  private int[] LRG;
  private boolean LSr;
  private String LSs;
  private h.a LSt;
  
  static
  {
    AppMethodBeat.i(112);
    LSp = "soter_triggered_oom" + com.tencent.soter.core.c.g.getMessageDigest(a.fUF().getBytes(Charset.forName("UTF-8")));
    LSq = "soter_triggered_oom_count" + com.tencent.soter.core.c.g.getMessageDigest(a.fUF().getBytes(Charset.forName("UTF-8")));
    AppMethodBeat.o(112);
  }
  
  public j(Context paramContext, e parame)
  {
    AppMethodBeat.i(107);
    this.LSr = false;
    this.LRF = "";
    this.LSs = "";
    this.LSt = new h.a()
    {
      public final boolean fUK()
      {
        AppMethodBeat.i(103);
        SharedPreferences localSharedPreferences = com.tencent.soter.a.c.b.fUW().fUZ();
        if (localSharedPreferences != null)
        {
          int i = localSharedPreferences.getInt(j.LSq, 0);
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
      public final void fUL()
      {
        AppMethodBeat.i(102);
        com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: on trigger OOM, using wrapper implement", new Object[0]);
        SharedPreferences localSharedPreferences = com.tencent.soter.a.c.b.fUW().fUZ();
        if (localSharedPreferences != null)
        {
          SharedPreferences.Editor localEditor = localSharedPreferences.edit();
          int i = localSharedPreferences.getInt(j.LSq, 0);
          localEditor.putInt(j.LSq, i + 1);
          localEditor.commit();
        }
        AppMethodBeat.o(102);
      }
      
      public final void reset()
      {
        AppMethodBeat.i(104);
        SharedPreferences localSharedPreferences = com.tencent.soter.a.c.b.fUW().fUZ();
        if (localSharedPreferences != null) {
          localSharedPreferences.edit().putInt(j.LSq, 0).apply();
        }
        AppMethodBeat.o(104);
      }
    };
    Object localObject1 = parame.LRH;
    if (localObject1 != null) {
      com.tencent.soter.core.c.d.a((c)localObject1);
    }
    localObject1 = parame.LRJ;
    if (localObject1 != null)
    {
      localObject2 = g.fVh();
      if ((((g)localObject2).LRR != null) && (((g)localObject2).LRR.isAlive()))
      {
        com.tencent.soter.core.c.d.i("Soter.SoterTaskThread", "quit the previous thread", new Object[0]);
        ((g)localObject2).LRR.quit();
      }
      ((g)localObject2).LRR = ((HandlerThread)localObject1);
      ((g)localObject2).LRR.setName("SoterGenKeyHandlerThreadName");
      if (!((HandlerThread)localObject1).isAlive()) {
        ((HandlerThread)localObject1).start();
      }
      ((g)localObject2).LRS = new Handler(((g)localObject2).LRR.getLooper());
    }
    localObject1 = com.tencent.soter.a.c.b.fUW();
    Object localObject2 = paramContext.getSharedPreferences("soter_status", 0);
    try
    {
      ((com.tencent.soter.a.c.b)localObject1).LRe = ((SharedPreferences)localObject2);
      h.a(this.LSt);
      a.fUu();
      a.lb(paramContext);
      a.div();
      boolean bool1 = bool2;
      if (a.fUz()) {
        if (!a.fe(paramContext))
        {
          bool1 = bool2;
          if (!a.aT(paramContext, 2)) {}
        }
        else
        {
          bool1 = true;
        }
      }
      this.LSr = bool1;
      this.LRE = parame.LRE;
      this.LRG = parame.LRG;
      this.LRF = parame.LRF;
      this.LSs = parame.LRI;
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
    if (this.LSr)
    {
      if (this.LRE == null)
      {
        com.tencent.soter.a.c.b.fUW().zs(true);
        com.tencent.soter.a.c.b.fUW().fUX();
        c(new com.tencent.soter.a.b.d(0));
        AppMethodBeat.o(109);
        return;
      }
      String str = a.fUF();
      this.LRE.setRequest(new d.a(str));
      this.LRE.a(new com.tencent.soter.a.f.b() {});
      this.LRE.execute();
      AppMethodBeat.o(109);
      return;
    }
    com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: TaskInit check isNativeSupport[" + this.LSr + "]", new Object[0]);
    c(new com.tencent.soter.a.b.d(2));
    try
    {
      com.tencent.soter.a.c.b.fUW().zs(false);
      com.tencent.soter.a.c.b.fUW().fUX();
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
      com.tencent.soter.a.c.b.fUW().fUY().put(k, str);
      i += 1;
    }
    AppMethodBeat.o(110);
  }
  
  final boolean fVc()
  {
    AppMethodBeat.i(108);
    if (com.tencent.soter.a.c.b.fUW().fUS())
    {
      com.tencent.soter.core.c.d.e("Soter.TaskInit", "soter: duplicate initialize soter", new Object[0]);
      c(new com.tencent.soter.a.b.d(1028, "soter already have initialized"));
      AppMethodBeat.o(108);
      return true;
    }
    Object localObject = this.LRG;
    if ((localObject == null) || (localObject.length <= 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      com.tencent.soter.core.c.d.e("Soter.TaskInit", "soter: the salt string used to distinguish is longer than 24", new Object[0]);
      c(new com.tencent.soter.a.b.d(1024, "no business scene provided"));
      AppMethodBeat.o(108);
      return true;
    }
    if (com.tencent.soter.core.c.g.nullAsNil(this.LRF).length() > 16)
    {
      com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: the salt string used to distinguish is longer than 24. soter will try to make it compat", new Object[0]);
      localObject = com.tencent.soter.core.c.g.getMessageDigest(this.LRF.getBytes(Charset.forName("UTF-8")));
      if ((!com.tencent.soter.core.c.g.isNullOrNil((String)localObject)) && (((String)localObject).length() >= 16)) {}
      for (localObject = ((String)localObject).substring(0, 16); com.tencent.soter.core.c.g.isNullOrNil((String)localObject); localObject = null)
      {
        com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: saltlen compat failed!!", new Object[0]);
        c(new com.tencent.soter.a.b.d(1025, "the account salt length is too long"));
        AppMethodBeat.o(108);
        return true;
      }
      this.LRF = ((String)localObject);
    }
    if ((!com.tencent.soter.core.c.g.isNullOrNil(this.LSs)) && (this.LSs.length() > 24))
    {
      com.tencent.soter.core.c.d.e("Soter.TaskInit", "soter: the passed ask name is too long (larger than 24).", new Object[0]);
      c(new com.tencent.soter.a.b.d(1026, "the passed ask name is too long (larger than 24)"));
      AppMethodBeat.o(108);
      return true;
    }
    if (this.LRE == null) {
      com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: it is strongly recommended to check device support from server, so you'd better provider a net wrapper to check it", new Object[0]);
    }
    if (!com.tencent.soter.core.c.g.isNullOrNil(this.LSs))
    {
      com.tencent.soter.core.c.d.i("Soter.TaskInit", "soter: provided valid ASK name", new Object[0]);
      com.tencent.soter.core.c.e.fUI().LQq = this.LSs;
    }
    g.fVh().af(new Runnable()
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
  
  final void fVd() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.g.j
 * JD-Core Version:    0.7.0.1
 */