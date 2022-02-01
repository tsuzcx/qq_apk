package com.tencent.mm.plugin.walletlock.gesture.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.czk;
import com.tencent.mm.protocal.protobuf.czl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.io.IOException;

public final class d
{
  private static long Iva = -1L;
  
  public static void LU(long paramLong)
  {
    Iva = paramLong;
  }
  
  public static void a(czk paramczk)
  {
    AppMethodBeat.i(129772);
    ao localao = com.tencent.mm.kernel.g.aAh().azQ();
    if (localao != null) {
      try
      {
        localao.set(339989, Base64.encodeToString(paramczk.toByteArray(), 2));
        localao.gBI();
        Log.v("MicroMsg.GestureGuardInfoManager", "alvinluo savePatternBuffer isUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(e.fUV()) });
        AppMethodBeat.o(129772);
        return;
      }
      catch (IOException paramczk)
      {
        Log.printErrStackTrace("MicroMsg.GestureGuardInfoManager", paramczk, "", new Object[0]);
      }
    }
    AppMethodBeat.o(129772);
  }
  
  public static void a(czl paramczl)
  {
    AppMethodBeat.i(129774);
    if (paramczl != null) {
      Log.i("MicroMsg.GestureGuardInfoManager", "alvinluo saveSyncedPatternInfo version: %d, status: %d", new Object[] { Integer.valueOf(paramczl.MEJ), Integer.valueOf(paramczl.MEL) });
    }
    ao localao = com.tencent.mm.kernel.g.aAh().azQ();
    if (localao != null) {
      try
      {
        localao.set(339990, Base64.encodeToString(paramczl.toByteArray(), 2));
        localao.gBI();
        AppMethodBeat.o(129774);
        return;
      }
      catch (IOException paramczl)
      {
        Log.printErrStackTrace("MicroMsg.GestureGuardInfoManager", paramczl, "", new Object[0]);
      }
    }
    AppMethodBeat.o(129774);
  }
  
  public static void aB(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(129766);
    ao localao = com.tencent.mm.kernel.g.aAh().azQ();
    if (localao != null)
    {
      g localg = new g();
      localg.IvB = paramLong1;
      localg.IvC = paramLong2;
      localao.set(339969, e.bytesToString(localg.toByteArray()));
      localao.gBI();
    }
    AppMethodBeat.o(129766);
  }
  
  public static void aC(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(129769);
    ao localao = com.tencent.mm.kernel.g.aAh().azQ();
    if (localao != null)
    {
      g localg = new g();
      localg.IvB = paramLong1;
      localg.IvC = paramLong2;
      localao.set(339971, e.bytesToString(localg.toByteArray()));
      localao.gBI();
    }
    AppMethodBeat.o(129769);
  }
  
  public static void afb(int paramInt)
  {
    AppMethodBeat.i(129776);
    ao localao = com.tencent.mm.kernel.g.aAh().azQ();
    if (localao != null)
    {
      localao.set(339972, Integer.valueOf(paramInt));
      localao.gBI();
    }
    AppMethodBeat.o(129776);
  }
  
  public static void fUM()
  {
    Iva = -1L;
  }
  
  public static long fUN()
  {
    return Iva;
  }
  
  public static g fUX()
  {
    AppMethodBeat.i(129765);
    Object localObject = com.tencent.mm.kernel.g.aAh().azQ();
    if (localObject == null)
    {
      localObject = new g();
      AppMethodBeat.o(129765);
      return localObject;
    }
    localObject = ((ao)localObject).get(339969, null);
    if (localObject == null)
    {
      localObject = new g();
      AppMethodBeat.o(129765);
      return localObject;
    }
    localObject = new g().cu(e.stringToBytes((String)localObject));
    AppMethodBeat.o(129765);
    return localObject;
  }
  
  public static void fUY()
  {
    AppMethodBeat.i(129767);
    ao localao = com.tencent.mm.kernel.g.aAh().azQ();
    if (localao != null)
    {
      localao.set(339969, null);
      localao.gBI();
    }
    AppMethodBeat.o(129767);
  }
  
  public static g fUZ()
  {
    AppMethodBeat.i(129768);
    Object localObject = com.tencent.mm.kernel.g.aAh().azQ();
    if (localObject == null)
    {
      localObject = new g();
      AppMethodBeat.o(129768);
      return localObject;
    }
    localObject = ((ao)localObject).get(339971, null);
    if (localObject == null)
    {
      localObject = new g();
      AppMethodBeat.o(129768);
      return localObject;
    }
    localObject = new g().cu(e.stringToBytes((String)localObject));
    AppMethodBeat.o(129768);
    return localObject;
  }
  
  public static void fVa()
  {
    AppMethodBeat.i(129770);
    ao localao = com.tencent.mm.kernel.g.aAh().azQ();
    if (localao != null)
    {
      localao.set(339971, null);
      localao.gBI();
    }
    AppMethodBeat.o(129770);
  }
  
  public static czk fVb()
  {
    AppMethodBeat.i(129771);
    Object localObject = com.tencent.mm.kernel.g.aAh().azQ();
    if (localObject == null)
    {
      AppMethodBeat.o(129771);
      return null;
    }
    localObject = (String)((ao)localObject).get(339989, null);
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(129771);
      return null;
    }
    try
    {
      localObject = Base64.decode((String)localObject, 2);
      localObject = (czk)new czk().parseFrom((byte[])localObject);
      AppMethodBeat.o(129771);
      return localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Log.printErrStackTrace("MicroMsg.GestureGuardInfoManager", localIllegalArgumentException, "", new Object[0]);
      AppMethodBeat.o(129771);
      return null;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("MicroMsg.GestureGuardInfoManager", localIOException, "", new Object[0]);
      AppMethodBeat.o(129771);
    }
    return null;
  }
  
  public static czl fVc()
  {
    AppMethodBeat.i(129773);
    Object localObject = com.tencent.mm.kernel.g.aAh().azQ();
    if (localObject == null)
    {
      Log.e("MicroMsg.GestureGuardInfoManager", "alvinluo configstg is null");
      AppMethodBeat.o(129773);
      return null;
    }
    localObject = (String)((ao)localObject).get(339990, null);
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(129773);
      return null;
    }
    try
    {
      localObject = Base64.decode((String)localObject, 2);
      localObject = (czl)new czl().parseFrom((byte[])localObject);
      AppMethodBeat.o(129773);
      return localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Log.printErrStackTrace("MicroMsg.GestureGuardInfoManager", localIllegalArgumentException, "", new Object[0]);
      AppMethodBeat.o(129773);
      return null;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("MicroMsg.GestureGuardInfoManager", localIOException, "", new Object[0]);
      AppMethodBeat.o(129773);
    }
    return null;
  }
  
  public static int fVd()
  {
    AppMethodBeat.i(129775);
    Object localObject = com.tencent.mm.kernel.g.aAh().azQ();
    if (localObject == null)
    {
      AppMethodBeat.o(129775);
      return -1;
    }
    localObject = ((ao)localObject).get(339972, null);
    if (localObject == null)
    {
      AppMethodBeat.o(129775);
      return -1;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(129775);
    return i;
  }
  
  public static void fVe()
  {
    AppMethodBeat.i(129777);
    ao localao = com.tencent.mm.kernel.g.aAh().azQ();
    if (localao != null)
    {
      localao.set(339972, null);
      localao.gBI();
    }
    AppMethodBeat.o(129777);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.d
 * JD-Core Version:    0.7.0.1
 */