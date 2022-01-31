package com.tencent.mm.plugin.walletlock.gesture.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.protocal.protobuf.bko;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.io.IOException;

public final class d
{
  private static long uEk = -1L;
  
  public static void IN(int paramInt)
  {
    AppMethodBeat.i(51571);
    z localz = com.tencent.mm.kernel.g.RL().Ru();
    if (localz != null)
    {
      localz.set(339972, Integer.valueOf(paramInt));
      localz.dww();
    }
    AppMethodBeat.o(51571);
  }
  
  public static void a(bkn parambkn)
  {
    AppMethodBeat.i(51567);
    z localz = com.tencent.mm.kernel.g.RL().Ru();
    if (localz != null) {
      try
      {
        localz.set(339989, Base64.encodeToString(parambkn.toByteArray(), 2));
        localz.dww();
        ab.v("MicroMsg.GestureGuardInfoManager", "alvinluo savePatternBuffer isUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(e.cXK()) });
        AppMethodBeat.o(51567);
        return;
      }
      catch (IOException parambkn)
      {
        ab.printErrStackTrace("MicroMsg.GestureGuardInfoManager", parambkn, "", new Object[0]);
      }
    }
    AppMethodBeat.o(51567);
  }
  
  public static void a(bko parambko)
  {
    AppMethodBeat.i(51569);
    if (parambko != null) {
      ab.i("MicroMsg.GestureGuardInfoManager", "alvinluo saveSyncedPatternInfo version: %d, status: %d", new Object[] { Integer.valueOf(parambko.xzj), Integer.valueOf(parambko.xzl) });
    }
    z localz = com.tencent.mm.kernel.g.RL().Ru();
    if (localz != null) {
      try
      {
        localz.set(339990, Base64.encodeToString(parambko.toByteArray(), 2));
        localz.dww();
        AppMethodBeat.o(51569);
        return;
      }
      catch (IOException parambko)
      {
        ab.printErrStackTrace("MicroMsg.GestureGuardInfoManager", parambko, "", new Object[0]);
      }
    }
    AppMethodBeat.o(51569);
  }
  
  public static void ae(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(51561);
    z localz = com.tencent.mm.kernel.g.RL().Ru();
    if (localz != null)
    {
      g localg = new g();
      localg.uEM = paramLong1;
      localg.uEN = paramLong2;
      localz.set(339969, e.bB(localg.toByteArray()));
      localz.dww();
    }
    AppMethodBeat.o(51561);
  }
  
  public static void af(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(51564);
    z localz = com.tencent.mm.kernel.g.RL().Ru();
    if (localz != null)
    {
      g localg = new g();
      localg.uEM = paramLong1;
      localg.uEN = paramLong2;
      localz.set(339971, e.bB(localg.toByteArray()));
      localz.dww();
    }
    AppMethodBeat.o(51564);
  }
  
  public static void cXB()
  {
    uEk = -1L;
  }
  
  public static long cXC()
  {
    return uEk;
  }
  
  public static g cXM()
  {
    AppMethodBeat.i(51560);
    Object localObject = com.tencent.mm.kernel.g.RL().Ru();
    if (localObject == null)
    {
      localObject = new g();
      AppMethodBeat.o(51560);
      return localObject;
    }
    localObject = ((z)localObject).get(339969, null);
    if (localObject == null)
    {
      localObject = new g();
      AppMethodBeat.o(51560);
      return localObject;
    }
    localObject = new g().bC(e.stringToBytes((String)localObject));
    AppMethodBeat.o(51560);
    return localObject;
  }
  
  public static void cXN()
  {
    AppMethodBeat.i(51562);
    z localz = com.tencent.mm.kernel.g.RL().Ru();
    if (localz != null)
    {
      localz.set(339969, null);
      localz.dww();
    }
    AppMethodBeat.o(51562);
  }
  
  public static g cXO()
  {
    AppMethodBeat.i(51563);
    Object localObject = com.tencent.mm.kernel.g.RL().Ru();
    if (localObject == null)
    {
      localObject = new g();
      AppMethodBeat.o(51563);
      return localObject;
    }
    localObject = ((z)localObject).get(339971, null);
    if (localObject == null)
    {
      localObject = new g();
      AppMethodBeat.o(51563);
      return localObject;
    }
    localObject = new g().bC(e.stringToBytes((String)localObject));
    AppMethodBeat.o(51563);
    return localObject;
  }
  
  public static void cXP()
  {
    AppMethodBeat.i(51565);
    z localz = com.tencent.mm.kernel.g.RL().Ru();
    if (localz != null)
    {
      localz.set(339971, null);
      localz.dww();
    }
    AppMethodBeat.o(51565);
  }
  
  public static bkn cXQ()
  {
    AppMethodBeat.i(51566);
    Object localObject = com.tencent.mm.kernel.g.RL().Ru();
    if (localObject == null)
    {
      AppMethodBeat.o(51566);
      return null;
    }
    localObject = (String)((z)localObject).get(339989, null);
    if (bo.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(51566);
      return null;
    }
    try
    {
      localObject = Base64.decode((String)localObject, 2);
      localObject = (bkn)new bkn().parseFrom((byte[])localObject);
      AppMethodBeat.o(51566);
      return localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      ab.printErrStackTrace("MicroMsg.GestureGuardInfoManager", localIllegalArgumentException, "", new Object[0]);
      AppMethodBeat.o(51566);
      return null;
    }
    catch (IOException localIOException)
    {
      ab.printErrStackTrace("MicroMsg.GestureGuardInfoManager", localIOException, "", new Object[0]);
      AppMethodBeat.o(51566);
    }
    return null;
  }
  
  public static bko cXR()
  {
    AppMethodBeat.i(51568);
    Object localObject = com.tencent.mm.kernel.g.RL().Ru();
    if (localObject == null)
    {
      ab.e("MicroMsg.GestureGuardInfoManager", "alvinluo configstg is null");
      AppMethodBeat.o(51568);
      return null;
    }
    localObject = (String)((z)localObject).get(339990, null);
    if (bo.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(51568);
      return null;
    }
    try
    {
      localObject = Base64.decode((String)localObject, 2);
      localObject = (bko)new bko().parseFrom((byte[])localObject);
      AppMethodBeat.o(51568);
      return localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      ab.printErrStackTrace("MicroMsg.GestureGuardInfoManager", localIllegalArgumentException, "", new Object[0]);
      AppMethodBeat.o(51568);
      return null;
    }
    catch (IOException localIOException)
    {
      ab.printErrStackTrace("MicroMsg.GestureGuardInfoManager", localIOException, "", new Object[0]);
      AppMethodBeat.o(51568);
    }
    return null;
  }
  
  public static int cXS()
  {
    AppMethodBeat.i(51570);
    Object localObject = com.tencent.mm.kernel.g.RL().Ru();
    if (localObject == null)
    {
      AppMethodBeat.o(51570);
      return -1;
    }
    localObject = ((z)localObject).get(339972, null);
    if (localObject == null)
    {
      AppMethodBeat.o(51570);
      return -1;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(51570);
    return i;
  }
  
  public static void cXT()
  {
    AppMethodBeat.i(51572);
    z localz = com.tencent.mm.kernel.g.RL().Ru();
    if (localz != null)
    {
      localz.set(339972, null);
      localz.dww();
    }
    AppMethodBeat.o(51572);
  }
  
  public static void ni(long paramLong)
  {
    uEk = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.d
 * JD-Core Version:    0.7.0.1
 */