package com.tencent.mm.plugin.walletlock.gesture.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.protocal.protobuf.cij;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import java.io.IOException;

public final class d
{
  private static long Dug = -1L;
  
  public static void Ci(long paramLong)
  {
    Dug = paramLong;
  }
  
  public static void VO(int paramInt)
  {
    AppMethodBeat.i(129776);
    ai localai = com.tencent.mm.kernel.g.ajC().ajl();
    if (localai != null)
    {
      localai.set(339972, Integer.valueOf(paramInt));
      localai.fqc();
    }
    AppMethodBeat.o(129776);
  }
  
  public static void a(cii paramcii)
  {
    AppMethodBeat.i(129772);
    ai localai = com.tencent.mm.kernel.g.ajC().ajl();
    if (localai != null) {
      try
      {
        localai.set(339989, Base64.encodeToString(paramcii.toByteArray(), 2));
        localai.fqc();
        ad.v("MicroMsg.GestureGuardInfoManager", "alvinluo savePatternBuffer isUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(e.eJE()) });
        AppMethodBeat.o(129772);
        return;
      }
      catch (IOException paramcii)
      {
        ad.printErrStackTrace("MicroMsg.GestureGuardInfoManager", paramcii, "", new Object[0]);
      }
    }
    AppMethodBeat.o(129772);
  }
  
  public static void a(cij paramcij)
  {
    AppMethodBeat.i(129774);
    if (paramcij != null) {
      ad.i("MicroMsg.GestureGuardInfoManager", "alvinluo saveSyncedPatternInfo version: %d, status: %d", new Object[] { Integer.valueOf(paramcij.Hck), Integer.valueOf(paramcij.Hcm) });
    }
    ai localai = com.tencent.mm.kernel.g.ajC().ajl();
    if (localai != null) {
      try
      {
        localai.set(339990, Base64.encodeToString(paramcij.toByteArray(), 2));
        localai.fqc();
        AppMethodBeat.o(129774);
        return;
      }
      catch (IOException paramcij)
      {
        ad.printErrStackTrace("MicroMsg.GestureGuardInfoManager", paramcij, "", new Object[0]);
      }
    }
    AppMethodBeat.o(129774);
  }
  
  public static void av(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(129766);
    ai localai = com.tencent.mm.kernel.g.ajC().ajl();
    if (localai != null)
    {
      g localg = new g();
      localg.DuH = paramLong1;
      localg.DuI = paramLong2;
      localai.set(339969, e.bZ(localg.toByteArray()));
      localai.fqc();
    }
    AppMethodBeat.o(129766);
  }
  
  public static void aw(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(129769);
    ai localai = com.tencent.mm.kernel.g.ajC().ajl();
    if (localai != null)
    {
      g localg = new g();
      localg.DuH = paramLong1;
      localg.DuI = paramLong2;
      localai.set(339971, e.bZ(localg.toByteArray()));
      localai.fqc();
    }
    AppMethodBeat.o(129769);
  }
  
  public static g eJG()
  {
    AppMethodBeat.i(129765);
    Object localObject = com.tencent.mm.kernel.g.ajC().ajl();
    if (localObject == null)
    {
      localObject = new g();
      AppMethodBeat.o(129765);
      return localObject;
    }
    localObject = ((ai)localObject).get(339969, null);
    if (localObject == null)
    {
      localObject = new g();
      AppMethodBeat.o(129765);
      return localObject;
    }
    localObject = new g().ca(e.stringToBytes((String)localObject));
    AppMethodBeat.o(129765);
    return localObject;
  }
  
  public static void eJH()
  {
    AppMethodBeat.i(129767);
    ai localai = com.tencent.mm.kernel.g.ajC().ajl();
    if (localai != null)
    {
      localai.set(339969, null);
      localai.fqc();
    }
    AppMethodBeat.o(129767);
  }
  
  public static g eJI()
  {
    AppMethodBeat.i(129768);
    Object localObject = com.tencent.mm.kernel.g.ajC().ajl();
    if (localObject == null)
    {
      localObject = new g();
      AppMethodBeat.o(129768);
      return localObject;
    }
    localObject = ((ai)localObject).get(339971, null);
    if (localObject == null)
    {
      localObject = new g();
      AppMethodBeat.o(129768);
      return localObject;
    }
    localObject = new g().ca(e.stringToBytes((String)localObject));
    AppMethodBeat.o(129768);
    return localObject;
  }
  
  public static void eJJ()
  {
    AppMethodBeat.i(129770);
    ai localai = com.tencent.mm.kernel.g.ajC().ajl();
    if (localai != null)
    {
      localai.set(339971, null);
      localai.fqc();
    }
    AppMethodBeat.o(129770);
  }
  
  public static cii eJK()
  {
    AppMethodBeat.i(129771);
    Object localObject = com.tencent.mm.kernel.g.ajC().ajl();
    if (localObject == null)
    {
      AppMethodBeat.o(129771);
      return null;
    }
    localObject = (String)((ai)localObject).get(339989, null);
    if (bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(129771);
      return null;
    }
    try
    {
      localObject = Base64.decode((String)localObject, 2);
      localObject = (cii)new cii().parseFrom((byte[])localObject);
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
  
  public static cij eJL()
  {
    AppMethodBeat.i(129773);
    Object localObject = com.tencent.mm.kernel.g.ajC().ajl();
    if (localObject == null)
    {
      ad.e("MicroMsg.GestureGuardInfoManager", "alvinluo configstg is null");
      AppMethodBeat.o(129773);
      return null;
    }
    localObject = (String)((ai)localObject).get(339990, null);
    if (bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(129773);
      return null;
    }
    try
    {
      localObject = Base64.decode((String)localObject, 2);
      localObject = (cij)new cij().parseFrom((byte[])localObject);
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
  
  public static int eJM()
  {
    AppMethodBeat.i(129775);
    Object localObject = com.tencent.mm.kernel.g.ajC().ajl();
    if (localObject == null)
    {
      AppMethodBeat.o(129775);
      return -1;
    }
    localObject = ((ai)localObject).get(339972, null);
    if (localObject == null)
    {
      AppMethodBeat.o(129775);
      return -1;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(129775);
    return i;
  }
  
  public static void eJN()
  {
    AppMethodBeat.i(129777);
    ai localai = com.tencent.mm.kernel.g.ajC().ajl();
    if (localai != null)
    {
      localai.set(339972, null);
      localai.fqc();
    }
    AppMethodBeat.o(129777);
  }
  
  public static void eJv()
  {
    Dug = -1L;
  }
  
  public static long eJw()
  {
    return Dug;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.d
 * JD-Core Version:    0.7.0.1
 */