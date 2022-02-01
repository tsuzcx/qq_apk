package com.tencent.mm.plugin.walletlock.gesture.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cdj;
import com.tencent.mm.protocal.protobuf.cdk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import java.io.IOException;

public final class d
{
  private static long BTM = -1L;
  
  public static void TW(int paramInt)
  {
    AppMethodBeat.i(129776);
    ae localae = com.tencent.mm.kernel.g.agR().agA();
    if (localae != null)
    {
      localae.set(339972, Integer.valueOf(paramInt));
      localae.faa();
    }
    AppMethodBeat.o(129776);
  }
  
  public static void a(cdj paramcdj)
  {
    AppMethodBeat.i(129772);
    ae localae = com.tencent.mm.kernel.g.agR().agA();
    if (localae != null) {
      try
      {
        localae.set(339989, Base64.encodeToString(paramcdj.toByteArray(), 2));
        localae.faa();
        ac.v("MicroMsg.GestureGuardInfoManager", "alvinluo savePatternBuffer isUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(e.evy()) });
        AppMethodBeat.o(129772);
        return;
      }
      catch (IOException paramcdj)
      {
        ac.printErrStackTrace("MicroMsg.GestureGuardInfoManager", paramcdj, "", new Object[0]);
      }
    }
    AppMethodBeat.o(129772);
  }
  
  public static void a(cdk paramcdk)
  {
    AppMethodBeat.i(129774);
    if (paramcdk != null) {
      ac.i("MicroMsg.GestureGuardInfoManager", "alvinluo saveSyncedPatternInfo version: %d, status: %d", new Object[] { Integer.valueOf(paramcdk.Fse), Integer.valueOf(paramcdk.Fsg) });
    }
    ae localae = com.tencent.mm.kernel.g.agR().agA();
    if (localae != null) {
      try
      {
        localae.set(339990, Base64.encodeToString(paramcdk.toByteArray(), 2));
        localae.faa();
        AppMethodBeat.o(129774);
        return;
      }
      catch (IOException paramcdk)
      {
        ac.printErrStackTrace("MicroMsg.GestureGuardInfoManager", paramcdk, "", new Object[0]);
      }
    }
    AppMethodBeat.o(129774);
  }
  
  public static void aq(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(129766);
    ae localae = com.tencent.mm.kernel.g.agR().agA();
    if (localae != null)
    {
      g localg = new g();
      localg.BUn = paramLong1;
      localg.BUo = paramLong2;
      localae.set(339969, e.bS(localg.toByteArray()));
      localae.faa();
    }
    AppMethodBeat.o(129766);
  }
  
  public static void ar(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(129769);
    ae localae = com.tencent.mm.kernel.g.agR().agA();
    if (localae != null)
    {
      g localg = new g();
      localg.BUn = paramLong1;
      localg.BUo = paramLong2;
      localae.set(339971, e.bS(localg.toByteArray()));
      localae.faa();
    }
    AppMethodBeat.o(129769);
  }
  
  public static g evA()
  {
    AppMethodBeat.i(129765);
    Object localObject = com.tencent.mm.kernel.g.agR().agA();
    if (localObject == null)
    {
      localObject = new g();
      AppMethodBeat.o(129765);
      return localObject;
    }
    localObject = ((ae)localObject).get(339969, null);
    if (localObject == null)
    {
      localObject = new g();
      AppMethodBeat.o(129765);
      return localObject;
    }
    localObject = new g().bT(e.stringToBytes((String)localObject));
    AppMethodBeat.o(129765);
    return localObject;
  }
  
  public static void evB()
  {
    AppMethodBeat.i(129767);
    ae localae = com.tencent.mm.kernel.g.agR().agA();
    if (localae != null)
    {
      localae.set(339969, null);
      localae.faa();
    }
    AppMethodBeat.o(129767);
  }
  
  public static g evC()
  {
    AppMethodBeat.i(129768);
    Object localObject = com.tencent.mm.kernel.g.agR().agA();
    if (localObject == null)
    {
      localObject = new g();
      AppMethodBeat.o(129768);
      return localObject;
    }
    localObject = ((ae)localObject).get(339971, null);
    if (localObject == null)
    {
      localObject = new g();
      AppMethodBeat.o(129768);
      return localObject;
    }
    localObject = new g().bT(e.stringToBytes((String)localObject));
    AppMethodBeat.o(129768);
    return localObject;
  }
  
  public static void evD()
  {
    AppMethodBeat.i(129770);
    ae localae = com.tencent.mm.kernel.g.agR().agA();
    if (localae != null)
    {
      localae.set(339971, null);
      localae.faa();
    }
    AppMethodBeat.o(129770);
  }
  
  public static cdj evE()
  {
    AppMethodBeat.i(129771);
    Object localObject = com.tencent.mm.kernel.g.agR().agA();
    if (localObject == null)
    {
      AppMethodBeat.o(129771);
      return null;
    }
    localObject = (String)((ae)localObject).get(339989, null);
    if (bs.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(129771);
      return null;
    }
    try
    {
      localObject = Base64.decode((String)localObject, 2);
      localObject = (cdj)new cdj().parseFrom((byte[])localObject);
      AppMethodBeat.o(129771);
      return localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      ac.printErrStackTrace("MicroMsg.GestureGuardInfoManager", localIllegalArgumentException, "", new Object[0]);
      AppMethodBeat.o(129771);
      return null;
    }
    catch (IOException localIOException)
    {
      ac.printErrStackTrace("MicroMsg.GestureGuardInfoManager", localIOException, "", new Object[0]);
      AppMethodBeat.o(129771);
    }
    return null;
  }
  
  public static cdk evF()
  {
    AppMethodBeat.i(129773);
    Object localObject = com.tencent.mm.kernel.g.agR().agA();
    if (localObject == null)
    {
      ac.e("MicroMsg.GestureGuardInfoManager", "alvinluo configstg is null");
      AppMethodBeat.o(129773);
      return null;
    }
    localObject = (String)((ae)localObject).get(339990, null);
    if (bs.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(129773);
      return null;
    }
    try
    {
      localObject = Base64.decode((String)localObject, 2);
      localObject = (cdk)new cdk().parseFrom((byte[])localObject);
      AppMethodBeat.o(129773);
      return localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      ac.printErrStackTrace("MicroMsg.GestureGuardInfoManager", localIllegalArgumentException, "", new Object[0]);
      AppMethodBeat.o(129773);
      return null;
    }
    catch (IOException localIOException)
    {
      ac.printErrStackTrace("MicroMsg.GestureGuardInfoManager", localIOException, "", new Object[0]);
      AppMethodBeat.o(129773);
    }
    return null;
  }
  
  public static int evG()
  {
    AppMethodBeat.i(129775);
    Object localObject = com.tencent.mm.kernel.g.agR().agA();
    if (localObject == null)
    {
      AppMethodBeat.o(129775);
      return -1;
    }
    localObject = ((ae)localObject).get(339972, null);
    if (localObject == null)
    {
      AppMethodBeat.o(129775);
      return -1;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(129775);
    return i;
  }
  
  public static void evH()
  {
    AppMethodBeat.i(129777);
    ae localae = com.tencent.mm.kernel.g.agR().agA();
    if (localae != null)
    {
      localae.set(339972, null);
      localae.faa();
    }
    AppMethodBeat.o(129777);
  }
  
  public static void evp()
  {
    BTM = -1L;
  }
  
  public static long evq()
  {
    return BTM;
  }
  
  public static void zw(long paramLong)
  {
    BTM = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.d
 * JD-Core Version:    0.7.0.1
 */