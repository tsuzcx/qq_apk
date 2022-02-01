package com.tencent.mm.plugin.walletlock.gesture.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.ebi;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import java.io.IOException;

public final class f
{
  private static long WfO = -1L;
  
  public static void a(ebi paramebi)
  {
    AppMethodBeat.i(129772);
    aq localaq = h.baE().ban();
    if (localaq != null) {
      try
      {
        localaq.B(339989, Base64.encodeToString(paramebi.toByteArray(), 2));
        localaq.iZy();
        Log.v("MicroMsg.GestureGuardInfoManager", "alvinluo savePatternBuffer isUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(g.imQ()) });
        AppMethodBeat.o(129772);
        return;
      }
      catch (IOException paramebi)
      {
        Log.printErrStackTrace("MicroMsg.GestureGuardInfoManager", paramebi, "", new Object[0]);
      }
    }
    AppMethodBeat.o(129772);
  }
  
  public static void a(ebj paramebj)
  {
    AppMethodBeat.i(129774);
    if (paramebj != null) {
      Log.i("MicroMsg.GestureGuardInfoManager", "alvinluo saveSyncedPatternInfo version: %d, status: %d", new Object[] { Integer.valueOf(paramebj.abgU), Integer.valueOf(paramebj.abgW) });
    }
    aq localaq = h.baE().ban();
    if (localaq != null) {
      try
      {
        localaq.B(339990, Base64.encodeToString(paramebj.toByteArray(), 2));
        localaq.iZy();
        AppMethodBeat.o(129774);
        return;
      }
      catch (IOException paramebj)
      {
        Log.printErrStackTrace("MicroMsg.GestureGuardInfoManager", paramebj, "", new Object[0]);
      }
    }
    AppMethodBeat.o(129774);
  }
  
  public static void asG(int paramInt)
  {
    AppMethodBeat.i(129776);
    aq localaq = h.baE().ban();
    if (localaq != null)
    {
      localaq.B(339972, Integer.valueOf(paramInt));
      localaq.iZy();
    }
    AppMethodBeat.o(129776);
  }
  
  public static void bD(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(129766);
    aq localaq = h.baE().ban();
    if (localaq != null)
    {
      i locali = new i();
      locali.Wgt = paramLong1;
      locali.Wgu = paramLong2;
      localaq.B(339969, g.cN(locali.toByteArray()));
      localaq.iZy();
    }
    AppMethodBeat.o(129766);
  }
  
  public static void bE(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(129769);
    aq localaq = h.baE().ban();
    if (localaq != null)
    {
      i locali = new i();
      locali.Wgt = paramLong1;
      locali.Wgu = paramLong2;
      localaq.B(339971, g.cN(locali.toByteArray()));
      localaq.iZy();
    }
    AppMethodBeat.o(129769);
  }
  
  public static void imH()
  {
    WfO = -1L;
  }
  
  public static long imI()
  {
    return WfO;
  }
  
  public static i imS()
  {
    AppMethodBeat.i(129765);
    Object localObject = h.baE().ban();
    if (localObject == null)
    {
      localObject = new i();
      AppMethodBeat.o(129765);
      return localObject;
    }
    localObject = ((aq)localObject).d(339969, null);
    if (localObject == null)
    {
      localObject = new i();
      AppMethodBeat.o(129765);
      return localObject;
    }
    localObject = new i().cO(g.stringToBytes((String)localObject));
    AppMethodBeat.o(129765);
    return localObject;
  }
  
  public static void imT()
  {
    AppMethodBeat.i(129767);
    aq localaq = h.baE().ban();
    if (localaq != null)
    {
      localaq.B(339969, null);
      localaq.iZy();
    }
    AppMethodBeat.o(129767);
  }
  
  public static i imU()
  {
    AppMethodBeat.i(129768);
    Object localObject = h.baE().ban();
    if (localObject == null)
    {
      localObject = new i();
      AppMethodBeat.o(129768);
      return localObject;
    }
    localObject = ((aq)localObject).d(339971, null);
    if (localObject == null)
    {
      localObject = new i();
      AppMethodBeat.o(129768);
      return localObject;
    }
    localObject = new i().cO(g.stringToBytes((String)localObject));
    AppMethodBeat.o(129768);
    return localObject;
  }
  
  public static void imV()
  {
    AppMethodBeat.i(129770);
    aq localaq = h.baE().ban();
    if (localaq != null)
    {
      localaq.B(339971, null);
      localaq.iZy();
    }
    AppMethodBeat.o(129770);
  }
  
  public static ebi imW()
  {
    AppMethodBeat.i(129771);
    Object localObject = h.baE().ban();
    if (localObject == null)
    {
      AppMethodBeat.o(129771);
      return null;
    }
    localObject = (String)((aq)localObject).d(339989, null);
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(129771);
      return null;
    }
    try
    {
      localObject = Base64.decode((String)localObject, 2);
      localObject = (ebi)new ebi().parseFrom((byte[])localObject);
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
  
  public static ebj imX()
  {
    AppMethodBeat.i(129773);
    Object localObject = h.baE().ban();
    if (localObject == null)
    {
      Log.e("MicroMsg.GestureGuardInfoManager", "alvinluo configstg is null");
      AppMethodBeat.o(129773);
      return null;
    }
    localObject = (String)((aq)localObject).d(339990, null);
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(129773);
      return null;
    }
    try
    {
      localObject = Base64.decode((String)localObject, 2);
      localObject = (ebj)new ebj().parseFrom((byte[])localObject);
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
  
  public static int imY()
  {
    AppMethodBeat.i(129775);
    Object localObject = h.baE().ban();
    if (localObject == null)
    {
      AppMethodBeat.o(129775);
      return -1;
    }
    localObject = ((aq)localObject).d(339972, null);
    if (localObject == null)
    {
      AppMethodBeat.o(129775);
      return -1;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(129775);
    return i;
  }
  
  public static void imZ()
  {
    AppMethodBeat.i(129777);
    aq localaq = h.baE().ban();
    if (localaq != null)
    {
      localaq.B(339972, null);
      localaq.iZy();
    }
    AppMethodBeat.o(129777);
  }
  
  public static void xB(long paramLong)
  {
    WfO = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.f
 * JD-Core Version:    0.7.0.1
 */