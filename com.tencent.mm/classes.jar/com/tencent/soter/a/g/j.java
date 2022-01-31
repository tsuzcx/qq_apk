package com.tencent.soter.a.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import android.util.SparseArray;
import com.tencent.soter.a.f.d.a;
import com.tencent.soter.core.c.c;
import com.tencent.soter.core.c.h;
import com.tencent.soter.core.c.h.a;
import java.nio.charset.Charset;

public class j
  extends d
{
  private static final String wQI = "soter_triggered_oom" + com.tencent.soter.core.c.g.o(com.tencent.soter.core.a.cPn().getBytes(Charset.forName("UTF-8")));
  private com.tencent.soter.a.f.d wPZ;
  private boolean wQJ = false;
  private String wQK = "";
  private h.a wQL = new h.a()
  {
    public final boolean cPs()
    {
      SharedPreferences localSharedPreferences = com.tencent.soter.a.c.a.cPy().cPB();
      if (localSharedPreferences != null)
      {
        boolean bool = localSharedPreferences.getBoolean(j.wQI, false);
        com.tencent.soter.core.c.d.i("Soter.TaskInit", "soter: is triggered OOM: %b", new Object[] { Boolean.valueOf(bool) });
        return bool;
      }
      return false;
    }
    
    @SuppressLint({"ApplySharedPref"})
    public final void cPt()
    {
      com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: on trigger OOM, using wrapper implement", new Object[0]);
      Object localObject = com.tencent.soter.a.c.a.cPy().cPB();
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putBoolean(j.wQI, true);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  };
  private String wQa = "";
  private int[] wQb;
  
  public j(Context paramContext, e parame)
  {
    Object localObject = parame.wQc;
    if (localObject != null) {
      com.tencent.soter.core.c.d.a((c)localObject);
    }
    localObject = com.tencent.soter.a.c.a.cPy();
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("soter_status", 0);
    try
    {
      ((com.tencent.soter.a.c.a)localObject).wPA = localSharedPreferences;
      h.a(this.wQL);
      com.tencent.soter.core.a.cPe();
      com.tencent.soter.core.a.hE(paramContext);
      com.tencent.soter.core.a.setUp();
      boolean bool1 = bool2;
      if (com.tencent.soter.core.a.cPh()) {
        if (!com.tencent.soter.core.a.hF(paramContext))
        {
          bool1 = bool2;
          if (!com.tencent.soter.core.a.hG(paramContext)) {}
        }
        else
        {
          bool1 = true;
        }
      }
      this.wQJ = bool1;
      this.wPZ = parame.wPZ;
      this.wQb = parame.wQb;
      this.wQa = parame.wQa;
      this.wQK = parame.wQd;
      return;
    }
    finally {}
  }
  
  private static boolean Ju(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 1);
  }
  
  @SuppressLint({"DefaultLocale"})
  public void b(String paramString, int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      String str = String.format("%suid%d_%s_scene%d", new Object[] { "Wechat", Integer.valueOf(Process.myUid()), com.tencent.soter.core.c.g.pm(paramString), Integer.valueOf(k) });
      com.tencent.soter.a.c.a.cPy().cPA().put(k, str);
      i += 1;
    }
  }
  
  final boolean cPF()
  {
    Object localObject = this.wQb;
    if ((localObject == null) || (localObject.length <= 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      com.tencent.soter.core.c.d.e("Soter.TaskInit", "soter: the salt string used to distinguish is longer than 24", new Object[0]);
      b(new com.tencent.soter.a.b.d(27, "no business scene provided"));
      return true;
    }
    if (com.tencent.soter.core.c.g.pm(this.wQa).length() > 16)
    {
      com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: the salt string used to distinguish is longer than 24. soter will try to make it compat", new Object[0]);
      localObject = com.tencent.soter.core.c.g.o(this.wQa.getBytes(Charset.forName("UTF-8")));
      if ((!com.tencent.soter.core.c.g.bl((String)localObject)) && (((String)localObject).length() >= 16)) {}
      for (localObject = ((String)localObject).substring(0, 16); com.tencent.soter.core.c.g.bl((String)localObject); localObject = null)
      {
        com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: saltlen compat failed!!", new Object[0]);
        b(new com.tencent.soter.a.b.d(28, "the account salt length is too long"));
        return true;
      }
      this.wQa = ((String)localObject);
    }
    if ((!com.tencent.soter.core.c.g.bl(this.wQK)) && (this.wQK.length() > 24))
    {
      com.tencent.soter.core.c.d.e("Soter.TaskInit", "soter: the passed ask name is too long (larger than 24).", new Object[0]);
      b(new com.tencent.soter.a.b.d(29, "the passed ask name is too long (larger than 24)"));
      return true;
    }
    if (this.wPZ == null) {
      com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: it is strongly recommended to check device support from server, so you'd better provider a net wrapper to check it", new Object[0]);
    }
    if (!com.tencent.soter.core.c.g.bl(this.wQK))
    {
      com.tencent.soter.core.c.d.i("Soter.TaskInit", "soter: provided valid ASK name", new Object[0]);
      com.tencent.soter.core.c.e.cPq().wOT = this.wQK;
    }
    g.cPK().H(new Runnable()
    {
      public final void run()
      {
        j.this.b(j.a(j.this), j.b(j.this));
        j.c(j.this);
      }
    });
    return false;
  }
  
  final void cPG() {}
  
  final void execute()
  {
    if (this.wQJ)
    {
      if (this.wPZ == null)
      {
        com.tencent.soter.a.c.a.cPy().ok(true);
        com.tencent.soter.a.c.a.cPy().cPz();
        b(new com.tencent.soter.a.b.d(0));
        return;
      }
      String str = com.tencent.soter.core.a.cPn();
      this.wPZ.bj(new d.a(str));
      this.wPZ.a(new j.3(this));
      this.wPZ.execute();
      return;
    }
    com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: TaskInit check isNativeSupport[" + this.wQJ + "]", new Object[0]);
    b(new com.tencent.soter.a.b.d(2));
    try
    {
      com.tencent.soter.a.c.a.cPy().ok(false);
      com.tencent.soter.a.c.a.cPy().cPz();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.soter.a.g.j
 * JD-Core Version:    0.7.0.1
 */