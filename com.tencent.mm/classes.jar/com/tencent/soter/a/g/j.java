package com.tencent.soter.a.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.f.d.a;
import com.tencent.soter.core.a;
import com.tencent.soter.core.c.c;
import com.tencent.soter.core.c.h;
import com.tencent.soter.core.c.h.a;
import java.nio.charset.Charset;

public class j
  extends d
{
  private static final String ahzg;
  private static final String ahzh;
  private com.tencent.soter.a.f.d ahyw;
  private String ahyx;
  private int[] ahyy;
  private boolean ahzi;
  private String ahzj;
  private h.a ahzk;
  
  static
  {
    AppMethodBeat.i(112);
    ahzg = "soter_triggered_oom" + com.tencent.soter.core.c.g.getMessageDigest(a.jYb().getBytes(Charset.forName("UTF-8")));
    ahzh = "soter_triggered_oom_count" + com.tencent.soter.core.c.g.getMessageDigest(a.jYb().getBytes(Charset.forName("UTF-8")));
    AppMethodBeat.o(112);
  }
  
  public j(Context paramContext, e parame)
  {
    AppMethodBeat.i(107);
    this.ahzi = false;
    this.ahyx = "";
    this.ahzj = "";
    this.ahzk = new h.a()
    {
      public final boolean jYh()
      {
        AppMethodBeat.i(103);
        SharedPreferences localSharedPreferences = com.tencent.soter.a.c.b.jYt().jYw();
        if (localSharedPreferences != null)
        {
          int i = localSharedPreferences.getInt(j.ahzh, 0);
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
      
      public final void jYi()
      {
        AppMethodBeat.i(102);
        com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: on trigger OOM, using wrapper implement", new Object[0]);
        SharedPreferences localSharedPreferences = com.tencent.soter.a.c.b.jYt().jYw();
        if (localSharedPreferences != null)
        {
          SharedPreferences.Editor localEditor = localSharedPreferences.edit();
          int i = localSharedPreferences.getInt(j.ahzh, 0);
          localEditor.putInt(j.ahzh, i + 1);
          localEditor.commit();
        }
        AppMethodBeat.o(102);
      }
      
      public final void reset()
      {
        AppMethodBeat.i(104);
        SharedPreferences localSharedPreferences = com.tencent.soter.a.c.b.jYt().jYw();
        if (localSharedPreferences != null) {
          localSharedPreferences.edit().putInt(j.ahzh, 0).apply();
        }
        AppMethodBeat.o(104);
      }
    };
    Object localObject1 = parame.ahyz;
    if (localObject1 != null) {
      com.tencent.soter.core.c.d.a((c)localObject1);
    }
    localObject1 = parame.ahyB;
    if (localObject1 != null)
    {
      localObject2 = g.jYG();
      if ((((g)localObject2).ahyJ != null) && (((g)localObject2).ahyJ.isAlive()))
      {
        com.tencent.soter.core.c.d.i("Soter.SoterTaskThread", "quit the previous thread", new Object[0]);
        ((g)localObject2).ahyJ.quit();
      }
      ((g)localObject2).ahyJ = ((HandlerThread)localObject1);
      ((g)localObject2).ahyJ.setName("SoterGenKeyHandlerThreadName");
      if (!((HandlerThread)localObject1).isAlive()) {
        ((HandlerThread)localObject1).start();
      }
      ((g)localObject2).ahyK = new Handler(((g)localObject2).ahyJ.getLooper());
    }
    localObject1 = com.tencent.soter.a.c.b.jYt();
    Object localObject2 = paramContext.getSharedPreferences("soter_status", 0);
    try
    {
      ((com.tencent.soter.a.c.b)localObject1).ahxR = ((SharedPreferences)localObject2);
      h.a(this.ahzk);
      a.jXQ();
      a.on(paramContext);
      a.fXr();
      boolean bool1 = bool2;
      if (a.jXV()) {
        if (!a.hC(paramContext))
        {
          bool1 = bool2;
          if (!a.bH(paramContext, 2)) {}
        }
        else
        {
          bool1 = true;
        }
      }
      this.ahzi = bool1;
      this.ahyw = parame.ahyw;
      this.ahyy = parame.ahyy;
      this.ahyx = parame.ahyx;
      this.ahzj = parame.ahyA;
      AppMethodBeat.o(107);
      return;
    }
    finally
    {
      AppMethodBeat.o(107);
    }
  }
  
  final void b(com.tencent.soter.a.b.e parame) {}
  
  protected void e(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(110);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      String str = String.format("%suid%d_%s_scene%d", new Object[] { "Wechat", Integer.valueOf(Process.myUid()), com.tencent.soter.core.c.g.nullAsNil(paramString), Integer.valueOf(k) });
      com.tencent.soter.a.c.b.jYt().jYv().put(k, str);
      i += 1;
    }
    AppMethodBeat.o(110);
  }
  
  final void execute()
  {
    AppMethodBeat.i(109);
    if (this.ahzi)
    {
      if (this.ahyw == null)
      {
        com.tencent.soter.a.c.b.jYt().Ot(true);
        com.tencent.soter.a.c.b.jYt().jYu();
        c(new com.tencent.soter.a.b.d(0));
        AppMethodBeat.o(109);
        return;
      }
      String str = a.jYb();
      this.ahyw.setRequest(new d.a(str));
      this.ahyw.a(new com.tencent.soter.a.f.b() {});
      this.ahyw.execute();
      AppMethodBeat.o(109);
      return;
    }
    com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: TaskInit check isNativeSupport[" + this.ahzi + "]", new Object[0]);
    c(new com.tencent.soter.a.b.d(2));
    try
    {
      com.tencent.soter.a.c.b.jYt().Ot(false);
      com.tencent.soter.a.c.b.jYt().jYu();
      return;
    }
    finally
    {
      AppMethodBeat.o(109);
    }
  }
  
  final boolean jYA()
  {
    AppMethodBeat.i(108);
    if (com.tencent.soter.a.c.b.jYt().jYp())
    {
      com.tencent.soter.core.c.d.e("Soter.TaskInit", "soter: duplicate initialize soter", new Object[0]);
      c(new com.tencent.soter.a.b.d(1028, "soter already have initialized"));
      AppMethodBeat.o(108);
      return true;
    }
    Object localObject = this.ahyy;
    if ((localObject == null) || (localObject.length <= 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      com.tencent.soter.core.c.d.e("Soter.TaskInit", "soter: the salt string used to distinguish is longer than 24", new Object[0]);
      c(new com.tencent.soter.a.b.d(1024, "no business scene provided"));
      AppMethodBeat.o(108);
      return true;
    }
    if (com.tencent.soter.core.c.g.nullAsNil(this.ahyx).length() > 16)
    {
      com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: the salt string used to distinguish is longer than 24. soter will try to make it compat", new Object[0]);
      localObject = com.tencent.soter.core.c.g.getMessageDigest(this.ahyx.getBytes(Charset.forName("UTF-8")));
      if ((!com.tencent.soter.core.c.g.isNullOrNil((String)localObject)) && (((String)localObject).length() >= 16)) {}
      for (localObject = ((String)localObject).substring(0, 16); com.tencent.soter.core.c.g.isNullOrNil((String)localObject); localObject = null)
      {
        com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: saltlen compat failed!!", new Object[0]);
        c(new com.tencent.soter.a.b.d(1025, "the account salt length is too long"));
        AppMethodBeat.o(108);
        return true;
      }
      this.ahyx = ((String)localObject);
    }
    if ((!com.tencent.soter.core.c.g.isNullOrNil(this.ahzj)) && (this.ahzj.length() > 24))
    {
      com.tencent.soter.core.c.d.e("Soter.TaskInit", "soter: the passed ask name is too long (larger than 24).", new Object[0]);
      c(new com.tencent.soter.a.b.d(1026, "the passed ask name is too long (larger than 24)"));
      AppMethodBeat.o(108);
      return true;
    }
    if (this.ahyw == null) {
      com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: it is strongly recommended to check device support from server, so you'd better provider a net wrapper to check it", new Object[0]);
    }
    if (!com.tencent.soter.core.c.g.isNullOrNil(this.ahzj))
    {
      com.tencent.soter.core.c.d.i("Soter.TaskInit", "soter: provided valid ASK name", new Object[0]);
      com.tencent.soter.core.c.e.jYf().ahxe = this.ahzj;
    }
    g.jYG().au(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(105);
        j.this.e(j.a(j.this), j.b(j.this));
        j.c(j.this);
        AppMethodBeat.o(105);
      }
    });
    AppMethodBeat.o(108);
    return false;
  }
  
  final boolean jYB()
  {
    return true;
  }
  
  final void jYC() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.soter.a.g.j
 * JD-Core Version:    0.7.0.1
 */