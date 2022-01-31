package com.tencent.soter.a.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.f.d.a;
import com.tencent.soter.core.c.c;
import com.tencent.soter.core.c.h;
import com.tencent.soter.core.c.h.a;
import java.nio.charset.Charset;

public class j
  extends d
{
  private static final String Boi;
  private String BnA;
  private int[] BnB;
  private com.tencent.soter.a.f.d Bnz;
  private boolean Boj;
  private String Bok;
  private h.a Bol;
  
  static
  {
    AppMethodBeat.i(10558);
    Boi = "soter_triggered_oom" + com.tencent.soter.core.c.g.w(com.tencent.soter.core.a.dVi().getBytes(Charset.forName("UTF-8")));
    AppMethodBeat.o(10558);
  }
  
  public j(Context paramContext, e parame)
  {
    AppMethodBeat.i(10553);
    this.Boj = false;
    this.BnA = "";
    this.Bok = "";
    this.Bol = new j.1(this);
    Object localObject = parame.BnC;
    if (localObject != null) {
      com.tencent.soter.core.c.d.a((c)localObject);
    }
    localObject = com.tencent.soter.a.c.a.dVu();
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("soter_status", 0);
    try
    {
      ((com.tencent.soter.a.c.a)localObject).Bna = localSharedPreferences;
      h.a(this.Bol);
      com.tencent.soter.core.a.dUX();
      com.tencent.soter.core.a.jf(paramContext);
      com.tencent.soter.core.a.bNv();
      boolean bool1 = bool2;
      if (com.tencent.soter.core.a.dVc()) {
        if (!com.tencent.soter.core.a.jg(paramContext))
        {
          bool1 = bool2;
          if (!com.tencent.soter.core.a.jh(paramContext)) {}
        }
        else
        {
          bool1 = true;
        }
      }
      this.Boj = bool1;
      this.Bnz = parame.Bnz;
      this.BnB = parame.BnB;
      this.BnA = parame.BnA;
      this.Bok = parame.BnD;
      AppMethodBeat.o(10553);
      return;
    }
    finally
    {
      AppMethodBeat.o(10553);
    }
  }
  
  private static boolean Sq(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 1);
  }
  
  @SuppressLint({"DefaultLocale"})
  protected void b(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(10556);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      String str = String.format("%suid%d_%s_scene%d", new Object[] { "Wechat", Integer.valueOf(Process.myUid()), com.tencent.soter.core.c.g.nullAsNil(paramString), Integer.valueOf(k) });
      com.tencent.soter.a.c.a.dVu().dVw().put(k, str);
      i += 1;
    }
    AppMethodBeat.o(10556);
  }
  
  final boolean dVB()
  {
    AppMethodBeat.i(10554);
    Object localObject = this.BnB;
    if ((localObject == null) || (localObject.length <= 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      com.tencent.soter.core.c.d.e("Soter.TaskInit", "soter: the salt string used to distinguish is longer than 24", new Object[0]);
      b(new com.tencent.soter.a.b.d(27, "no business scene provided"));
      AppMethodBeat.o(10554);
      return true;
    }
    if (com.tencent.soter.core.c.g.nullAsNil(this.BnA).length() > 16)
    {
      com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: the salt string used to distinguish is longer than 24. soter will try to make it compat", new Object[0]);
      localObject = com.tencent.soter.core.c.g.w(this.BnA.getBytes(Charset.forName("UTF-8")));
      if ((!com.tencent.soter.core.c.g.isNullOrNil((String)localObject)) && (((String)localObject).length() >= 16)) {}
      for (localObject = ((String)localObject).substring(0, 16); com.tencent.soter.core.c.g.isNullOrNil((String)localObject); localObject = null)
      {
        com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: saltlen compat failed!!", new Object[0]);
        b(new com.tencent.soter.a.b.d(28, "the account salt length is too long"));
        AppMethodBeat.o(10554);
        return true;
      }
      this.BnA = ((String)localObject);
    }
    if ((!com.tencent.soter.core.c.g.isNullOrNil(this.Bok)) && (this.Bok.length() > 24))
    {
      com.tencent.soter.core.c.d.e("Soter.TaskInit", "soter: the passed ask name is too long (larger than 24).", new Object[0]);
      b(new com.tencent.soter.a.b.d(29, "the passed ask name is too long (larger than 24)"));
      AppMethodBeat.o(10554);
      return true;
    }
    if (this.Bnz == null) {
      com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: it is strongly recommended to check device support from server, so you'd better provider a net wrapper to check it", new Object[0]);
    }
    if (!com.tencent.soter.core.c.g.isNullOrNil(this.Bok))
    {
      com.tencent.soter.core.c.d.i("Soter.TaskInit", "soter: provided valid ASK name", new Object[0]);
      com.tencent.soter.core.c.e.dVl().Bmr = this.Bok;
    }
    g.dVG().O(new j.2(this));
    AppMethodBeat.o(10554);
    return false;
  }
  
  final void dVC() {}
  
  final void execute()
  {
    AppMethodBeat.i(10555);
    if (this.Boj)
    {
      if (this.Bnz == null)
      {
        com.tencent.soter.a.c.a.dVu().rW(true);
        com.tencent.soter.a.c.a.dVu().dVv();
        b(new com.tencent.soter.a.b.d(0));
        AppMethodBeat.o(10555);
        return;
      }
      String str = com.tencent.soter.core.a.dVi();
      this.Bnz.bK(new d.a(str));
      this.Bnz.a(new j.3(this));
      this.Bnz.execute();
      AppMethodBeat.o(10555);
      return;
    }
    com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: TaskInit check isNativeSupport[" + this.Boj + "]", new Object[0]);
    b(new com.tencent.soter.a.b.d(2));
    try
    {
      com.tencent.soter.a.c.a.dVu().rW(false);
      com.tencent.soter.a.c.a.dVu().dVv();
      return;
    }
    finally
    {
      AppMethodBeat.o(10555);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.soter.a.g.j
 * JD-Core Version:    0.7.0.1
 */