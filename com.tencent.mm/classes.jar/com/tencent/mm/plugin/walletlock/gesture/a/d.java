package com.tencent.mm.plugin.walletlock.gesture.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.protocal.protobuf.diz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.io.IOException;

public final class d
{
  private static long Ppf = -1L;
  
  public static void Ts(long paramLong)
  {
    Ppf = paramLong;
  }
  
  public static void a(diy paramdiy)
  {
    AppMethodBeat.i(129772);
    ao localao = h.aHG().aHp();
    if (localao != null) {
      try
      {
        localao.i(339989, Base64.encodeToString(paramdiy.toByteArray(), 2));
        localao.hxT();
        Log.v("MicroMsg.GestureGuardInfoManager", "alvinluo savePatternBuffer isUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(e.gNB()) });
        AppMethodBeat.o(129772);
        return;
      }
      catch (IOException paramdiy)
      {
        Log.printErrStackTrace("MicroMsg.GestureGuardInfoManager", paramdiy, "", new Object[0]);
      }
    }
    AppMethodBeat.o(129772);
  }
  
  public static void a(diz paramdiz)
  {
    AppMethodBeat.i(129774);
    if (paramdiz != null) {
      Log.i("MicroMsg.GestureGuardInfoManager", "alvinluo saveSyncedPatternInfo version: %d, status: %d", new Object[] { Integer.valueOf(paramdiz.TQv), Integer.valueOf(paramdiz.TQx) });
    }
    ao localao = h.aHG().aHp();
    if (localao != null) {
      try
      {
        localao.i(339990, Base64.encodeToString(paramdiz.toByteArray(), 2));
        localao.hxT();
        AppMethodBeat.o(129774);
        return;
      }
      catch (IOException paramdiz)
      {
        Log.printErrStackTrace("MicroMsg.GestureGuardInfoManager", paramdiz, "", new Object[0]);
      }
    }
    AppMethodBeat.o(129774);
  }
  
  public static void aR(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(129766);
    ao localao = h.aHG().aHp();
    if (localao != null)
    {
      g localg = new g();
      localg.PpG = paramLong1;
      localg.PpH = paramLong2;
      localao.i(339969, e.cK(localg.toByteArray()));
      localao.hxT();
    }
    AppMethodBeat.o(129766);
  }
  
  public static void aS(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(129769);
    ao localao = h.aHG().aHp();
    if (localao != null)
    {
      g localg = new g();
      localg.PpG = paramLong1;
      localg.PpH = paramLong2;
      localao.i(339971, e.cK(localg.toByteArray()));
      localao.hxT();
    }
    AppMethodBeat.o(129769);
  }
  
  public static void amP(int paramInt)
  {
    AppMethodBeat.i(129776);
    ao localao = h.aHG().aHp();
    if (localao != null)
    {
      localao.i(339972, Integer.valueOf(paramInt));
      localao.hxT();
    }
    AppMethodBeat.o(129776);
  }
  
  public static g gND()
  {
    AppMethodBeat.i(129765);
    Object localObject = h.aHG().aHp();
    if (localObject == null)
    {
      localObject = new g();
      AppMethodBeat.o(129765);
      return localObject;
    }
    localObject = ((ao)localObject).b(339969, null);
    if (localObject == null)
    {
      localObject = new g();
      AppMethodBeat.o(129765);
      return localObject;
    }
    localObject = new g().cL(e.stringToBytes((String)localObject));
    AppMethodBeat.o(129765);
    return localObject;
  }
  
  public static void gNE()
  {
    AppMethodBeat.i(129767);
    ao localao = h.aHG().aHp();
    if (localao != null)
    {
      localao.i(339969, null);
      localao.hxT();
    }
    AppMethodBeat.o(129767);
  }
  
  public static g gNF()
  {
    AppMethodBeat.i(129768);
    Object localObject = h.aHG().aHp();
    if (localObject == null)
    {
      localObject = new g();
      AppMethodBeat.o(129768);
      return localObject;
    }
    localObject = ((ao)localObject).b(339971, null);
    if (localObject == null)
    {
      localObject = new g();
      AppMethodBeat.o(129768);
      return localObject;
    }
    localObject = new g().cL(e.stringToBytes((String)localObject));
    AppMethodBeat.o(129768);
    return localObject;
  }
  
  public static void gNG()
  {
    AppMethodBeat.i(129770);
    ao localao = h.aHG().aHp();
    if (localao != null)
    {
      localao.i(339971, null);
      localao.hxT();
    }
    AppMethodBeat.o(129770);
  }
  
  public static diy gNH()
  {
    AppMethodBeat.i(129771);
    Object localObject = h.aHG().aHp();
    if (localObject == null)
    {
      AppMethodBeat.o(129771);
      return null;
    }
    localObject = (String)((ao)localObject).b(339989, null);
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(129771);
      return null;
    }
    try
    {
      localObject = Base64.decode((String)localObject, 2);
      localObject = (diy)new diy().parseFrom((byte[])localObject);
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
  
  public static diz gNI()
  {
    AppMethodBeat.i(129773);
    Object localObject = h.aHG().aHp();
    if (localObject == null)
    {
      Log.e("MicroMsg.GestureGuardInfoManager", "alvinluo configstg is null");
      AppMethodBeat.o(129773);
      return null;
    }
    localObject = (String)((ao)localObject).b(339990, null);
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(129773);
      return null;
    }
    try
    {
      localObject = Base64.decode((String)localObject, 2);
      localObject = (diz)new diz().parseFrom((byte[])localObject);
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
  
  public static int gNJ()
  {
    AppMethodBeat.i(129775);
    Object localObject = h.aHG().aHp();
    if (localObject == null)
    {
      AppMethodBeat.o(129775);
      return -1;
    }
    localObject = ((ao)localObject).b(339972, null);
    if (localObject == null)
    {
      AppMethodBeat.o(129775);
      return -1;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(129775);
    return i;
  }
  
  public static void gNK()
  {
    AppMethodBeat.i(129777);
    ao localao = h.aHG().aHp();
    if (localao != null)
    {
      localao.i(339972, null);
      localao.hxT();
    }
    AppMethodBeat.o(129777);
  }
  
  public static void gNs()
  {
    Ppf = -1L;
  }
  
  public static long gNt()
  {
    return Ppf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.d
 * JD-Core Version:    0.7.0.1
 */