package com.tencent.mm.plugin.walletlock.gesture.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.byo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import java.io.IOException;

public final class d
{
  private static long ABr = -1L;
  
  public static void RM(int paramInt)
  {
    AppMethodBeat.i(129776);
    ab localab = com.tencent.mm.kernel.g.afB().afk();
    if (localab != null)
    {
      localab.set(339972, Integer.valueOf(paramInt));
      localab.eKy();
    }
    AppMethodBeat.o(129776);
  }
  
  public static void a(byn parambyn)
  {
    AppMethodBeat.i(129772);
    ab localab = com.tencent.mm.kernel.g.afB().afk();
    if (localab != null) {
      try
      {
        localab.set(339989, Base64.encodeToString(parambyn.toByteArray(), 2));
        localab.eKy();
        ad.v("MicroMsg.GestureGuardInfoManager", "alvinluo savePatternBuffer isUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(e.ege()) });
        AppMethodBeat.o(129772);
        return;
      }
      catch (IOException parambyn)
      {
        ad.printErrStackTrace("MicroMsg.GestureGuardInfoManager", parambyn, "", new Object[0]);
      }
    }
    AppMethodBeat.o(129772);
  }
  
  public static void a(byo parambyo)
  {
    AppMethodBeat.i(129774);
    if (parambyo != null) {
      ad.i("MicroMsg.GestureGuardInfoManager", "alvinluo saveSyncedPatternInfo version: %d, status: %d", new Object[] { Integer.valueOf(parambyo.DVq), Integer.valueOf(parambyo.DVs) });
    }
    ab localab = com.tencent.mm.kernel.g.afB().afk();
    if (localab != null) {
      try
      {
        localab.set(339990, Base64.encodeToString(parambyo.toByteArray(), 2));
        localab.eKy();
        AppMethodBeat.o(129774);
        return;
      }
      catch (IOException parambyo)
      {
        ad.printErrStackTrace("MicroMsg.GestureGuardInfoManager", parambyo, "", new Object[0]);
      }
    }
    AppMethodBeat.o(129774);
  }
  
  public static void ar(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(129766);
    ab localab = com.tencent.mm.kernel.g.afB().afk();
    if (localab != null)
    {
      g localg = new g();
      localg.ABS = paramLong1;
      localg.ABT = paramLong2;
      localab.set(339969, e.bT(localg.toByteArray()));
      localab.eKy();
    }
    AppMethodBeat.o(129766);
  }
  
  public static void as(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(129769);
    ab localab = com.tencent.mm.kernel.g.afB().afk();
    if (localab != null)
    {
      g localg = new g();
      localg.ABS = paramLong1;
      localg.ABT = paramLong2;
      localab.set(339971, e.bT(localg.toByteArray()));
      localab.eKy();
    }
    AppMethodBeat.o(129769);
  }
  
  public static void efV()
  {
    ABr = -1L;
  }
  
  public static long efW()
  {
    return ABr;
  }
  
  public static g egg()
  {
    AppMethodBeat.i(129765);
    Object localObject = com.tencent.mm.kernel.g.afB().afk();
    if (localObject == null)
    {
      localObject = new g();
      AppMethodBeat.o(129765);
      return localObject;
    }
    localObject = ((ab)localObject).get(339969, null);
    if (localObject == null)
    {
      localObject = new g();
      AppMethodBeat.o(129765);
      return localObject;
    }
    localObject = new g().bU(e.stringToBytes((String)localObject));
    AppMethodBeat.o(129765);
    return localObject;
  }
  
  public static void egh()
  {
    AppMethodBeat.i(129767);
    ab localab = com.tencent.mm.kernel.g.afB().afk();
    if (localab != null)
    {
      localab.set(339969, null);
      localab.eKy();
    }
    AppMethodBeat.o(129767);
  }
  
  public static g egi()
  {
    AppMethodBeat.i(129768);
    Object localObject = com.tencent.mm.kernel.g.afB().afk();
    if (localObject == null)
    {
      localObject = new g();
      AppMethodBeat.o(129768);
      return localObject;
    }
    localObject = ((ab)localObject).get(339971, null);
    if (localObject == null)
    {
      localObject = new g();
      AppMethodBeat.o(129768);
      return localObject;
    }
    localObject = new g().bU(e.stringToBytes((String)localObject));
    AppMethodBeat.o(129768);
    return localObject;
  }
  
  public static void egj()
  {
    AppMethodBeat.i(129770);
    ab localab = com.tencent.mm.kernel.g.afB().afk();
    if (localab != null)
    {
      localab.set(339971, null);
      localab.eKy();
    }
    AppMethodBeat.o(129770);
  }
  
  public static byn egk()
  {
    AppMethodBeat.i(129771);
    Object localObject = com.tencent.mm.kernel.g.afB().afk();
    if (localObject == null)
    {
      AppMethodBeat.o(129771);
      return null;
    }
    localObject = (String)((ab)localObject).get(339989, null);
    if (bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(129771);
      return null;
    }
    try
    {
      localObject = Base64.decode((String)localObject, 2);
      localObject = (byn)new byn().parseFrom((byte[])localObject);
      AppMethodBeat.o(129771);
      return localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      ad.printErrStackTrace("MicroMsg.GestureGuardInfoManager", localIllegalArgumentException, "", new Object[0]);
      AppMethodBeat.o(129771);
      return null;
    }
    catch (IOException localIOException)
    {
      ad.printErrStackTrace("MicroMsg.GestureGuardInfoManager", localIOException, "", new Object[0]);
      AppMethodBeat.o(129771);
    }
    return null;
  }
  
  public static byo egl()
  {
    AppMethodBeat.i(129773);
    Object localObject = com.tencent.mm.kernel.g.afB().afk();
    if (localObject == null)
    {
      ad.e("MicroMsg.GestureGuardInfoManager", "alvinluo configstg is null");
      AppMethodBeat.o(129773);
      return null;
    }
    localObject = (String)((ab)localObject).get(339990, null);
    if (bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(129773);
      return null;
    }
    try
    {
      localObject = Base64.decode((String)localObject, 2);
      localObject = (byo)new byo().parseFrom((byte[])localObject);
      AppMethodBeat.o(129773);
      return localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      ad.printErrStackTrace("MicroMsg.GestureGuardInfoManager", localIllegalArgumentException, "", new Object[0]);
      AppMethodBeat.o(129773);
      return null;
    }
    catch (IOException localIOException)
    {
      ad.printErrStackTrace("MicroMsg.GestureGuardInfoManager", localIOException, "", new Object[0]);
      AppMethodBeat.o(129773);
    }
    return null;
  }
  
  public static int egm()
  {
    AppMethodBeat.i(129775);
    Object localObject = com.tencent.mm.kernel.g.afB().afk();
    if (localObject == null)
    {
      AppMethodBeat.o(129775);
      return -1;
    }
    localObject = ((ab)localObject).get(339972, null);
    if (localObject == null)
    {
      AppMethodBeat.o(129775);
      return -1;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(129775);
    return i;
  }
  
  public static void egn()
  {
    AppMethodBeat.i(129777);
    ab localab = com.tencent.mm.kernel.g.afB().afk();
    if (localab != null)
    {
      localab.set(339972, null);
      localab.eKy();
    }
    AppMethodBeat.o(129777);
  }
  
  public static void uT(long paramLong)
  {
    ABr = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.d
 * JD-Core Version:    0.7.0.1
 */