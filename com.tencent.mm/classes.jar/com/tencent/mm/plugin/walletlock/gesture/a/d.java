package com.tencent.mm.plugin.walletlock.gesture.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cjc;
import com.tencent.mm.protocal.protobuf.cjd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import java.io.IOException;

public final class d
{
  private static long DLL = -1L;
  
  public static void CG(long paramLong)
  {
    DLL = paramLong;
  }
  
  public static void Wv(int paramInt)
  {
    AppMethodBeat.i(129776);
    aj localaj = com.tencent.mm.kernel.g.ajR().ajA();
    if (localaj != null)
    {
      localaj.set(339972, Integer.valueOf(paramInt));
      localaj.fuc();
    }
    AppMethodBeat.o(129776);
  }
  
  public static void a(cjc paramcjc)
  {
    AppMethodBeat.i(129772);
    aj localaj = com.tencent.mm.kernel.g.ajR().ajA();
    if (localaj != null) {
      try
      {
        localaj.set(339989, Base64.encodeToString(paramcjc.toByteArray(), 2));
        localaj.fuc();
        ae.v("MicroMsg.GestureGuardInfoManager", "alvinluo savePatternBuffer isUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(e.eNm()) });
        AppMethodBeat.o(129772);
        return;
      }
      catch (IOException paramcjc)
      {
        ae.printErrStackTrace("MicroMsg.GestureGuardInfoManager", paramcjc, "", new Object[0]);
      }
    }
    AppMethodBeat.o(129772);
  }
  
  public static void a(cjd paramcjd)
  {
    AppMethodBeat.i(129774);
    if (paramcjd != null) {
      ae.i("MicroMsg.GestureGuardInfoManager", "alvinluo saveSyncedPatternInfo version: %d, status: %d", new Object[] { Integer.valueOf(paramcjd.HvK), Integer.valueOf(paramcjd.HvM) });
    }
    aj localaj = com.tencent.mm.kernel.g.ajR().ajA();
    if (localaj != null) {
      try
      {
        localaj.set(339990, Base64.encodeToString(paramcjd.toByteArray(), 2));
        localaj.fuc();
        AppMethodBeat.o(129774);
        return;
      }
      catch (IOException paramcjd)
      {
        ae.printErrStackTrace("MicroMsg.GestureGuardInfoManager", paramcjd, "", new Object[0]);
      }
    }
    AppMethodBeat.o(129774);
  }
  
  public static void au(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(129766);
    aj localaj = com.tencent.mm.kernel.g.ajR().ajA();
    if (localaj != null)
    {
      g localg = new g();
      localg.DMm = paramLong1;
      localg.DMn = paramLong2;
      localaj.set(339969, e.cc(localg.toByteArray()));
      localaj.fuc();
    }
    AppMethodBeat.o(129766);
  }
  
  public static void av(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(129769);
    aj localaj = com.tencent.mm.kernel.g.ajR().ajA();
    if (localaj != null)
    {
      g localg = new g();
      localg.DMm = paramLong1;
      localg.DMn = paramLong2;
      localaj.set(339971, e.cc(localg.toByteArray()));
      localaj.fuc();
    }
    AppMethodBeat.o(129769);
  }
  
  public static void eNd()
  {
    DLL = -1L;
  }
  
  public static long eNe()
  {
    return DLL;
  }
  
  public static g eNo()
  {
    AppMethodBeat.i(129765);
    Object localObject = com.tencent.mm.kernel.g.ajR().ajA();
    if (localObject == null)
    {
      localObject = new g();
      AppMethodBeat.o(129765);
      return localObject;
    }
    localObject = ((aj)localObject).get(339969, null);
    if (localObject == null)
    {
      localObject = new g();
      AppMethodBeat.o(129765);
      return localObject;
    }
    localObject = new g().cd(e.stringToBytes((String)localObject));
    AppMethodBeat.o(129765);
    return localObject;
  }
  
  public static void eNp()
  {
    AppMethodBeat.i(129767);
    aj localaj = com.tencent.mm.kernel.g.ajR().ajA();
    if (localaj != null)
    {
      localaj.set(339969, null);
      localaj.fuc();
    }
    AppMethodBeat.o(129767);
  }
  
  public static g eNq()
  {
    AppMethodBeat.i(129768);
    Object localObject = com.tencent.mm.kernel.g.ajR().ajA();
    if (localObject == null)
    {
      localObject = new g();
      AppMethodBeat.o(129768);
      return localObject;
    }
    localObject = ((aj)localObject).get(339971, null);
    if (localObject == null)
    {
      localObject = new g();
      AppMethodBeat.o(129768);
      return localObject;
    }
    localObject = new g().cd(e.stringToBytes((String)localObject));
    AppMethodBeat.o(129768);
    return localObject;
  }
  
  public static void eNr()
  {
    AppMethodBeat.i(129770);
    aj localaj = com.tencent.mm.kernel.g.ajR().ajA();
    if (localaj != null)
    {
      localaj.set(339971, null);
      localaj.fuc();
    }
    AppMethodBeat.o(129770);
  }
  
  public static cjc eNs()
  {
    AppMethodBeat.i(129771);
    Object localObject = com.tencent.mm.kernel.g.ajR().ajA();
    if (localObject == null)
    {
      AppMethodBeat.o(129771);
      return null;
    }
    localObject = (String)((aj)localObject).get(339989, null);
    if (bu.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(129771);
      return null;
    }
    try
    {
      localObject = Base64.decode((String)localObject, 2);
      localObject = (cjc)new cjc().parseFrom((byte[])localObject);
      AppMethodBeat.o(129771);
      return localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      ae.printErrStackTrace("MicroMsg.GestureGuardInfoManager", localIllegalArgumentException, "", new Object[0]);
      AppMethodBeat.o(129771);
      return null;
    }
    catch (IOException localIOException)
    {
      ae.printErrStackTrace("MicroMsg.GestureGuardInfoManager", localIOException, "", new Object[0]);
      AppMethodBeat.o(129771);
    }
    return null;
  }
  
  public static cjd eNt()
  {
    AppMethodBeat.i(129773);
    Object localObject = com.tencent.mm.kernel.g.ajR().ajA();
    if (localObject == null)
    {
      ae.e("MicroMsg.GestureGuardInfoManager", "alvinluo configstg is null");
      AppMethodBeat.o(129773);
      return null;
    }
    localObject = (String)((aj)localObject).get(339990, null);
    if (bu.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(129773);
      return null;
    }
    try
    {
      localObject = Base64.decode((String)localObject, 2);
      localObject = (cjd)new cjd().parseFrom((byte[])localObject);
      AppMethodBeat.o(129773);
      return localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      ae.printErrStackTrace("MicroMsg.GestureGuardInfoManager", localIllegalArgumentException, "", new Object[0]);
      AppMethodBeat.o(129773);
      return null;
    }
    catch (IOException localIOException)
    {
      ae.printErrStackTrace("MicroMsg.GestureGuardInfoManager", localIOException, "", new Object[0]);
      AppMethodBeat.o(129773);
    }
    return null;
  }
  
  public static int eNu()
  {
    AppMethodBeat.i(129775);
    Object localObject = com.tencent.mm.kernel.g.ajR().ajA();
    if (localObject == null)
    {
      AppMethodBeat.o(129775);
      return -1;
    }
    localObject = ((aj)localObject).get(339972, null);
    if (localObject == null)
    {
      AppMethodBeat.o(129775);
      return -1;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(129775);
    return i;
  }
  
  public static void eNv()
  {
    AppMethodBeat.i(129777);
    aj localaj = com.tencent.mm.kernel.g.ajR().ajA();
    if (localaj != null)
    {
      localaj.set(339972, null);
      localaj.fuc();
    }
    AppMethodBeat.o(129777);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.d
 * JD-Core Version:    0.7.0.1
 */