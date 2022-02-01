package com.tencent.soter.a;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.c;
import com.tencent.soter.a.g.h;
import com.tencent.soter.a.g.i;
import com.tencent.soter.a.g.j;
import com.tencent.soter.a.g.k;
import com.tencent.soter.a.g.l;
import com.tencent.soter.core.c.g;

public final class a
{
  public static void a(com.tencent.soter.a.b.b<com.tencent.soter.a.b.a> paramb, com.tencent.soter.a.g.b paramb1)
  {
    AppMethodBeat.i(4);
    com.tencent.soter.core.c.d.i("Soter.SoterWrapperApi", "soter: request authorize provide challenge. scene: %d", new Object[] { Integer.valueOf(paramb1.mScene) });
    if ((paramb1.JXB == 1) || (paramb1.JXB == 2))
    {
      paramb1 = new i(paramb1);
      paramb1.JXG = paramb;
      if (!com.tencent.soter.a.g.f.fDM().a(paramb1, new com.tencent.soter.a.b.a())) {
        com.tencent.soter.core.c.d.d("Soter.SoterWrapperApi", "soter: add 2.0 requestAuthorizeAndSign task failed.", new Object[0]);
      }
      AppMethodBeat.o(4);
      return;
    }
    paramb1 = new h(paramb1);
    paramb1.JXG = paramb;
    if (!com.tencent.soter.a.g.f.fDM().a(paramb1, new com.tencent.soter.a.b.a())) {
      com.tencent.soter.core.c.d.d("Soter.SoterWrapperApi", "soter: add 1.0 requestAuthorizeAndSign task failed.", new Object[0]);
    }
    AppMethodBeat.o(4);
  }
  
  public static void a(com.tencent.soter.a.b.b<c> paramb, boolean paramBoolean, int paramInt, com.tencent.soter.a.f.e parame1, com.tencent.soter.a.f.e parame2)
  {
    AppMethodBeat.i(3);
    com.tencent.soter.core.c.d.i("Soter.SoterWrapperApi", "soter: starting prepare auth key: %d", new Object[] { Integer.valueOf(paramInt) });
    parame1 = new l(paramInt, parame1, parame2, paramBoolean);
    parame1.JXG = paramb;
    if (!com.tencent.soter.a.g.f.fDM().a(parame1, new c())) {
      com.tencent.soter.core.c.d.d("Soter.SoterWrapperApi", "soter: add prepareAuthKey task failed.", new Object[0]);
    }
    AppMethodBeat.o(3);
  }
  
  public static void a(com.tencent.soter.a.b.b<c> paramb, boolean paramBoolean, com.tencent.soter.a.f.e parame)
  {
    AppMethodBeat.i(2);
    com.tencent.soter.core.c.d.i("Soter.SoterWrapperApi", "soter: starting prepare ask key. ", new Object[0]);
    parame = new k(parame, paramBoolean);
    parame.JXG = paramb;
    if (!com.tencent.soter.a.g.f.fDM().a(parame, new c())) {
      com.tencent.soter.core.c.d.d("Soter.SoterWrapperApi", "soter: add prepareAppSecureKey task failed.", new Object[0]);
    }
    AppMethodBeat.o(2);
  }
  
  public static boolean aeo(int paramInt)
  {
    AppMethodBeat.i(6);
    boolean bool = com.tencent.soter.a.c.b.fDE().isInit();
    String str = (String)com.tencent.soter.a.c.b.fDE().fDG().get(paramInt);
    if ((bool) && (!g.isNullOrNil(str)))
    {
      if (com.tencent.soter.core.a.db(str, false).errCode == 0)
      {
        AppMethodBeat.o(6);
        return true;
      }
      AppMethodBeat.o(6);
      return false;
    }
    if (!bool)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterWrapperApi", "soter: not initialized yet", new Object[0]);
      AppMethodBeat.o(6);
      return false;
    }
    com.tencent.soter.core.c.d.w("Soter.SoterWrapperApi", "soter: scene not registered in init. please make sure", new Object[0]);
    AppMethodBeat.o(6);
    return false;
  }
  
  public static boolean fDA()
  {
    AppMethodBeat.i(5);
    if ((com.tencent.soter.a.c.b.fDE().isInit()) && (com.tencent.soter.a.c.b.fDE().fDA()))
    {
      AppMethodBeat.o(5);
      return true;
    }
    AppMethodBeat.o(5);
    return false;
  }
  
  public static void fDB()
  {
    AppMethodBeat.i(175401);
    if ((com.tencent.soter.a.c.b.fDE().isInit()) && (!com.tencent.soter.core.a.fDf())) {
      com.tencent.soter.core.a.fDg();
    }
    AppMethodBeat.o(175401);
  }
  
  public static void fDC()
  {
    AppMethodBeat.i(7);
    SparseArray localSparseArray = com.tencent.soter.a.c.b.fDE().fDG();
    int j = localSparseArray.size();
    int i = 0;
    while (i < j)
    {
      com.tencent.soter.core.a.db((String)localSparseArray.valueAt(i), false);
      i += 1;
    }
    com.tencent.soter.core.a.fDj();
    AppMethodBeat.o(7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.a
 * JD-Core Version:    0.7.0.1
 */