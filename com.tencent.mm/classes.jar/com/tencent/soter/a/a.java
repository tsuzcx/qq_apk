package com.tencent.soter.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  public static boolean Sn(int paramInt)
  {
    AppMethodBeat.i(10458);
    boolean bool = com.tencent.soter.a.c.a.dVu().isInit();
    String str = (String)com.tencent.soter.a.c.a.dVu().dVw().get(paramInt);
    if ((bool) && (!g.isNullOrNil(str)))
    {
      if (com.tencent.soter.core.a.cu(str, false).errCode == 0)
      {
        AppMethodBeat.o(10458);
        return true;
      }
      AppMethodBeat.o(10458);
      return false;
    }
    if (!bool)
    {
      d.w("Soter.SoterWrapperApi", "soter: not initialized yet", new Object[0]);
      AppMethodBeat.o(10458);
      return false;
    }
    d.w("Soter.SoterWrapperApi", "soter: scene not registered in init. please make sure", new Object[0]);
    AppMethodBeat.o(10458);
    return false;
  }
  
  public static void a(com.tencent.soter.a.b.b<com.tencent.soter.a.b.a> paramb, com.tencent.soter.a.g.b paramb1)
  {
    AppMethodBeat.i(10456);
    d.i("Soter.SoterWrapperApi", "soter: request authorize provide challenge. scene: %d", new Object[] { Integer.valueOf(paramb1.mScene) });
    if ((paramb1.Bns == 1) || (paramb1.Bns == 2))
    {
      paramb1 = new i(paramb1);
      paramb1.Bnw = paramb;
      if (!com.tencent.soter.a.g.f.dVD().a(paramb1, new com.tencent.soter.a.b.a())) {
        d.d("Soter.SoterWrapperApi", "soter: add 2.0 requestAuthorizeAndSign task failed.", new Object[0]);
      }
      AppMethodBeat.o(10456);
      return;
    }
    paramb1 = new h(paramb1);
    paramb1.Bnw = paramb;
    if (!com.tencent.soter.a.g.f.dVD().a(paramb1, new com.tencent.soter.a.b.a())) {
      d.d("Soter.SoterWrapperApi", "soter: add 1.0 requestAuthorizeAndSign task failed.", new Object[0]);
    }
    AppMethodBeat.o(10456);
  }
  
  public static void a(com.tencent.soter.a.b.b<c> paramb, boolean paramBoolean, int paramInt, e parame1, e parame2)
  {
    AppMethodBeat.i(10455);
    d.i("Soter.SoterWrapperApi", "soter: starting prepare auth key: %d", new Object[] { Integer.valueOf(paramInt) });
    parame1 = new l(paramInt, parame1, parame2, paramBoolean);
    parame1.Bnw = paramb;
    if (!com.tencent.soter.a.g.f.dVD().a(parame1, new c())) {
      d.d("Soter.SoterWrapperApi", "soter: add prepareAuthKey task failed.", new Object[0]);
    }
    AppMethodBeat.o(10455);
  }
  
  public static void a(com.tencent.soter.a.b.b<c> paramb, boolean paramBoolean, e parame)
  {
    AppMethodBeat.i(10454);
    d.i("Soter.SoterWrapperApi", "soter: starting prepare ask key. ", new Object[0]);
    parame = new k(parame, paramBoolean);
    parame.Bnw = paramb;
    if (!com.tencent.soter.a.g.f.dVD().a(parame, new c())) {
      d.d("Soter.SoterWrapperApi", "soter: add prepareAppSecureKey task failed.", new Object[0]);
    }
    AppMethodBeat.o(10454);
  }
  
  public static boolean dVs()
  {
    AppMethodBeat.i(10457);
    if ((com.tencent.soter.a.c.a.dVu().isInit()) && (com.tencent.soter.a.c.a.dVu().dVs()))
    {
      AppMethodBeat.o(10457);
      return true;
    }
    AppMethodBeat.o(10457);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.soter.a.a
 * JD-Core Version:    0.7.0.1
 */