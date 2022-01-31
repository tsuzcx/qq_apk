package com.tencent.soter.a;

import android.util.SparseArray;
import com.tencent.soter.a.b.c;
import com.tencent.soter.a.f.e;
import com.tencent.soter.a.g.h;
import com.tencent.soter.a.g.i;
import com.tencent.soter.a.g.k;
import com.tencent.soter.a.g.l;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.g;

public final class a
{
  public static boolean Jr(int paramInt)
  {
    boolean bool = com.tencent.soter.a.c.a.cPy().isInit();
    String str = (String)com.tencent.soter.a.c.a.cPy().cPA().get(paramInt);
    if ((bool) && (!g.bl(str))) {
      return com.tencent.soter.core.a.bR(str, false).errCode == 0;
    }
    if (!bool)
    {
      d.w("Soter.SoterWrapperApi", "soter: not initialized yet", new Object[0]);
      return false;
    }
    d.w("Soter.SoterWrapperApi", "soter: scene not registered in init. please make sure", new Object[0]);
    return false;
  }
  
  public static void a(com.tencent.soter.a.b.b<com.tencent.soter.a.b.a> paramb, com.tencent.soter.a.g.b paramb1)
  {
    d.i("Soter.SoterWrapperApi", "soter: request authorize provide challenge. scene: %d", new Object[] { Integer.valueOf(paramb1.fzn) });
    if ((paramb1.wPS == 1) || (paramb1.wPS == 2))
    {
      paramb1 = new i(paramb1);
      paramb1.wPW = paramb;
      if (!com.tencent.soter.a.g.f.cPH().a(paramb1, new com.tencent.soter.a.b.a())) {
        d.d("Soter.SoterWrapperApi", "soter: add 2.0 requestAuthorizeAndSign task failed.", new Object[0]);
      }
    }
    do
    {
      return;
      paramb1 = new h(paramb1);
      paramb1.wPW = paramb;
    } while (com.tencent.soter.a.g.f.cPH().a(paramb1, new com.tencent.soter.a.b.a()));
    d.d("Soter.SoterWrapperApi", "soter: add 1.0 requestAuthorizeAndSign task failed.", new Object[0]);
  }
  
  public static void a(com.tencent.soter.a.b.b<c> paramb, boolean paramBoolean, int paramInt, e parame1, e parame2)
  {
    d.i("Soter.SoterWrapperApi", "soter: starting prepare auth key: %d", new Object[] { Integer.valueOf(paramInt) });
    parame1 = new l(paramInt, parame1, parame2, paramBoolean);
    parame1.wPW = paramb;
    if (!com.tencent.soter.a.g.f.cPH().a(parame1, new c())) {
      d.d("Soter.SoterWrapperApi", "soter: add prepareAuthKey task failed.", new Object[0]);
    }
  }
  
  public static void a(com.tencent.soter.a.b.b<c> paramb, boolean paramBoolean, e parame)
  {
    d.i("Soter.SoterWrapperApi", "soter: starting prepare ask key. ", new Object[0]);
    parame = new k(parame, paramBoolean);
    parame.wPW = paramb;
    if (!com.tencent.soter.a.g.f.cPH().a(parame, new c())) {
      d.d("Soter.SoterWrapperApi", "soter: add prepareAppSecureKey task failed.", new Object[0]);
    }
  }
  
  public static boolean cPw()
  {
    return (com.tencent.soter.a.c.a.cPy().isInit()) && (com.tencent.soter.a.c.a.cPy().cPw());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.soter.a.a
 * JD-Core Version:    0.7.0.1
 */