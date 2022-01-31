package com.tencent.mm.plugin.walletlock.gesture.a;

import android.util.Base64;
import com.tencent.mm.protocal.c.bcu;
import com.tencent.mm.protocal.c.bcv;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.io.IOException;

public final class d
{
  private static long qPd = -1L;
  
  public static void Bb(int paramInt)
  {
    z localz = com.tencent.mm.kernel.g.DP().Dz();
    if (localz != null)
    {
      localz.o(339972, Integer.valueOf(paramInt));
      localz.mC(true);
    }
  }
  
  public static void Q(long paramLong1, long paramLong2)
  {
    z localz = com.tencent.mm.kernel.g.DP().Dz();
    if (localz != null)
    {
      g localg = new g();
      localg.qPE = paramLong1;
      localg.qPF = paramLong2;
      localz.o(339969, e.ba(localg.toByteArray()));
      localz.mC(true);
    }
  }
  
  public static void R(long paramLong1, long paramLong2)
  {
    z localz = com.tencent.mm.kernel.g.DP().Dz();
    if (localz != null)
    {
      g localg = new g();
      localg.qPE = paramLong1;
      localg.qPF = paramLong2;
      localz.o(339971, e.ba(localg.toByteArray()));
      localz.mC(true);
    }
  }
  
  public static void a(bcu parambcu)
  {
    z localz = com.tencent.mm.kernel.g.DP().Dz();
    if (localz != null) {}
    try
    {
      localz.o(339989, Base64.encodeToString(parambcu.toByteArray(), 2));
      localz.mC(true);
      y.v("MicroMsg.GestureGuardInfoManager", "alvinluo savePatternBuffer isUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(e.bYc()) });
      return;
    }
    catch (IOException parambcu)
    {
      y.printErrStackTrace("MicroMsg.GestureGuardInfoManager", parambcu, "", new Object[0]);
    }
  }
  
  public static void a(bcv parambcv)
  {
    if (parambcv != null) {
      y.i("MicroMsg.GestureGuardInfoManager", "alvinluo saveSyncedPatternInfo version: %d, status: %d", new Object[] { Integer.valueOf(parambcv.tyg), Integer.valueOf(parambcv.tyi) });
    }
    z localz = com.tencent.mm.kernel.g.DP().Dz();
    if (localz != null) {}
    try
    {
      localz.o(339990, Base64.encodeToString(parambcv.toByteArray(), 2));
      localz.mC(true);
      return;
    }
    catch (IOException parambcv)
    {
      y.printErrStackTrace("MicroMsg.GestureGuardInfoManager", parambcv, "", new Object[0]);
    }
  }
  
  public static void bXT()
  {
    qPd = -1L;
  }
  
  public static long bXU()
  {
    return qPd;
  }
  
  public static g bYe()
  {
    Object localObject = com.tencent.mm.kernel.g.DP().Dz();
    if (localObject == null) {
      return new g();
    }
    localObject = ((z)localObject).get(339969, null);
    if (localObject == null) {
      return new g();
    }
    return new g().bb(e.Rc((String)localObject));
  }
  
  public static void bYf()
  {
    z localz = com.tencent.mm.kernel.g.DP().Dz();
    if (localz != null)
    {
      localz.o(339969, null);
      localz.mC(true);
    }
  }
  
  public static g bYg()
  {
    Object localObject = com.tencent.mm.kernel.g.DP().Dz();
    if (localObject == null) {
      return new g();
    }
    localObject = ((z)localObject).get(339971, null);
    if (localObject == null) {
      return new g();
    }
    return new g().bb(e.Rc((String)localObject));
  }
  
  public static void bYh()
  {
    z localz = com.tencent.mm.kernel.g.DP().Dz();
    if (localz != null)
    {
      localz.o(339971, null);
      localz.mC(true);
    }
  }
  
  public static bcu bYi()
  {
    Object localObject = com.tencent.mm.kernel.g.DP().Dz();
    if (localObject == null) {
      return null;
    }
    localObject = (String)((z)localObject).get(339989, null);
    if (bk.bl((String)localObject)) {
      return null;
    }
    try
    {
      localObject = Base64.decode((String)localObject, 2);
      localObject = (bcu)new bcu().aH((byte[])localObject);
      return localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      y.printErrStackTrace("MicroMsg.GestureGuardInfoManager", localIllegalArgumentException, "", new Object[0]);
      return null;
    }
    catch (IOException localIOException)
    {
      y.printErrStackTrace("MicroMsg.GestureGuardInfoManager", localIOException, "", new Object[0]);
    }
    return null;
  }
  
  public static bcv bYj()
  {
    Object localObject = com.tencent.mm.kernel.g.DP().Dz();
    if (localObject == null)
    {
      y.e("MicroMsg.GestureGuardInfoManager", "alvinluo configstg is null");
      return null;
    }
    localObject = (String)((z)localObject).get(339990, null);
    if (bk.bl((String)localObject)) {
      return null;
    }
    try
    {
      localObject = Base64.decode((String)localObject, 2);
      localObject = (bcv)new bcv().aH((byte[])localObject);
      return localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      y.printErrStackTrace("MicroMsg.GestureGuardInfoManager", localIllegalArgumentException, "", new Object[0]);
      return null;
    }
    catch (IOException localIOException)
    {
      y.printErrStackTrace("MicroMsg.GestureGuardInfoManager", localIOException, "", new Object[0]);
    }
    return null;
  }
  
  public static int bYk()
  {
    Object localObject = com.tencent.mm.kernel.g.DP().Dz();
    if (localObject == null) {
      return -1;
    }
    localObject = ((z)localObject).get(339972, null);
    if (localObject == null) {
      return -1;
    }
    return ((Integer)localObject).intValue();
  }
  
  public static void bYl()
  {
    z localz = com.tencent.mm.kernel.g.DP().Dz();
    if (localz != null)
    {
      localz.o(339972, null);
      localz.mC(true);
    }
  }
  
  public static void gM(long paramLong)
  {
    qPd = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.d
 * JD-Core Version:    0.7.0.1
 */