package com.tencent.mm.plugin.walletlock.gesture.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.byo;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.ByteArrayOutputStream;
import java.util.List;

public final class e
{
  public static void a(g paramg)
  {
    AppMethodBeat.i(129783);
    if (paramg.ABS == -1L)
    {
      AppMethodBeat.o(129783);
      return;
    }
    long l = SystemClock.elapsedRealtime();
    if (l < paramg.ABS)
    {
      paramg.ABS = l;
      paramg.ABT += l;
      ad.d("MicroMsg.GestureUtil", String.format("Rebooted, need to add additional %d ms, now elapsed %d ms", new Object[] { Long.valueOf(l), Long.valueOf(paramg.ABT) }));
      AppMethodBeat.o(129783);
      return;
    }
    paramg.ABT = (l - paramg.ABS + paramg.ABT);
    paramg.ABS = l;
    AppMethodBeat.o(129783);
  }
  
  public static boolean b(byn parambyn)
  {
    AppMethodBeat.i(129778);
    if ((parambyn == null) || (parambyn.DVp == null) || (parambyn.DVp.getBuffer() == null))
    {
      AppMethodBeat.o(129778);
      return false;
    }
    byte[] arrayOfByte = parambyn.DVp.getBufferToBytes();
    if ((arrayOfByte.length == 0) || ((arrayOfByte.length & 0x1) != 0))
    {
      AppMethodBeat.o(129778);
      return false;
    }
    long l = new p(parambyn.uin).longValue();
    arrayOfByte = bS(arrayOfByte);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(parambyn.version);
    if (parambyn.DVn.hasBuffer()) {
      localStringBuilder.append(new String(parambyn.DVn.getBufferToBytes()));
    }
    localStringBuilder.append(l);
    int i = UtilsJni.doEcdsaVerify(a.ABO, localStringBuilder.toString().getBytes(), arrayOfByte);
    ad.d("MicroMsg.GestureUtil", String.format("verifyPatternBuffer, ret:%d", new Object[] { Integer.valueOf(i) }));
    if (i == 1)
    {
      AppMethodBeat.o(129778);
      return true;
    }
    AppMethodBeat.o(129778);
    return false;
  }
  
  public static boolean b(byo parambyo)
  {
    AppMethodBeat.i(129779);
    if ((parambyo == null) || (parambyo.DVr == null) || (parambyo.DVr.getBuffer() == null))
    {
      AppMethodBeat.o(129779);
      return false;
    }
    byte[] arrayOfByte = parambyo.DVr.getBufferToBytes();
    if ((arrayOfByte.length == 0) || ((arrayOfByte.length & 0x1) != 0))
    {
      AppMethodBeat.o(129779);
      return false;
    }
    arrayOfByte = bS(arrayOfByte);
    com.tencent.mm.kernel.g.afz();
    long l = new p(com.tencent.mm.kernel.a.getUin()).longValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(parambyo.DVq);
    localStringBuilder.append(l);
    int i = UtilsJni.doEcdsaVerify(a.ABO, localStringBuilder.toString().getBytes(), arrayOfByte);
    if (((i != 1) && (parambyo.DVs == 1)) || ((i == 1) && (parambyo.DVs == 0))) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.GestureUtil", String.format("verifyPatternInfo, verifyRes:%d ret:%b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) }));
      AppMethodBeat.o(129779);
      return bool;
    }
  }
  
  private static byte[] bS(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(129780);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = 0;
    while (i < paramArrayOfByte.length - 1)
    {
      localByteArrayOutputStream.write("0123456789abcdef".indexOf(Character.toLowerCase(paramArrayOfByte[i])) << 4 | "0123456789abcdef".indexOf(Character.toLowerCase(paramArrayOfByte[(i + 1)])));
      i += 2;
    }
    paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(129780);
    return paramArrayOfByte;
  }
  
  public static String bT(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(129785);
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuilder.append('0');
      }
      localStringBuilder.append(str);
      i += 1;
    }
    paramArrayOfByte = localStringBuilder.toString();
    AppMethodBeat.o(129785);
    return paramArrayOfByte;
  }
  
  public static boolean ege()
  {
    int k = -1;
    AppMethodBeat.i(129781);
    if ((!com.tencent.mm.kernel.g.afw()) || (com.tencent.mm.kernel.a.aeC()))
    {
      ad.w("MicroMsg.GestureUtil", "not login !!");
      AppMethodBeat.o(129781);
      return false;
    }
    byo localbyo = d.egl();
    byn localbyn = d.egk();
    int j;
    if (localbyo == null) {
      j = 1;
    }
    for (;;)
    {
      int i;
      label57:
      boolean bool1;
      label67:
      label74:
      boolean bool2;
      if (localbyn == null)
      {
        i = 1;
        if (j != 0) {
          break label241;
        }
        bool1 = b(localbyo);
        if (localbyo != null) {
          break label246;
        }
        j = -1;
        ad.i("MicroMsg.GestureUtil", "tom isUserSetWalletLock serverInfo:%s status:%d  svrinfoValid:%s", new Object[] { localbyo, Integer.valueOf(j), Boolean.valueOf(bool1) });
        if (i != 0) {
          break label255;
        }
        bool2 = b(localbyn);
        label115:
        if (localbyn != null) {
          break label261;
        }
        i = k;
        label122:
        ad.i("MicroMsg.GestureUtil", "tom isUserSetWalletLock localBuff:%s status:%d  localBuffValid:%s", new Object[] { localbyn, Integer.valueOf(i), Boolean.valueOf(bool2) });
        if ((bool1) && (!bool2)) {
          break label404;
        }
      }
      try
      {
        ad.i("MicroMsg.GestureUtil", "Both info & buff are valid, choose one to trust.");
        if (localbyo.DVq > localbyn.version)
        {
          ad.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, srvInfo wins.", new Object[] { Integer.valueOf(localbyo.DVq), Integer.valueOf(localbyn.version) });
          if (localbyo.DVs == 1)
          {
            AppMethodBeat.o(129781);
            return true;
            j = 0;
            continue;
            i = 0;
            break label57;
            label241:
            bool1 = false;
            break label67;
            label246:
            j = localbyo.DVs;
            break label74;
            label255:
            bool2 = false;
            break label115;
            label261:
            i = localbyn.DVo;
            break label122;
          }
          else
          {
            AppMethodBeat.o(129781);
            return false;
          }
        }
        else
        {
          if (localbyo.DVq == localbyn.version)
          {
            ad.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, draw.", new Object[] { Integer.valueOf(localbyo.DVq), Integer.valueOf(localbyn.version) });
            if (localbyo.DVs == 1)
            {
              AppMethodBeat.o(129781);
              return true;
            }
            AppMethodBeat.o(129781);
            return false;
          }
          ad.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, localBuff wins.", new Object[] { Integer.valueOf(localbyo.DVq), Integer.valueOf(localbyn.version) });
          if (localbyn.DVo == 1)
          {
            AppMethodBeat.o(129781);
            return true;
          }
          AppMethodBeat.o(129781);
          return false;
        }
      }
      catch (Exception localException)
      {
        label404:
        ad.printErrStackTrace("MicroMsg.GestureUtil", localException, "isUserSetWalletLock throw an exception.", new Object[0]);
        AppMethodBeat.o(129781);
      }
    }
    ad.i("MicroMsg.GestureUtil", "Info is valid but buf is invalid, we trust info this time.");
    if (localbyo.DVs == 1)
    {
      AppMethodBeat.o(129781);
      return true;
    }
    AppMethodBeat.o(129781);
    return false;
    if (bool2)
    {
      ad.i("MicroMsg.GestureUtil", "Info is invalid but buff is valid, we trust buff this time.");
      if (localbyn.DVo == 1)
      {
        AppMethodBeat.o(129781);
        return true;
      }
      AppMethodBeat.o(129781);
      return false;
    }
    ad.w("MicroMsg.GestureUtil", "Both buff & info are invalid, do not activate this time and wait for next sync.");
    AppMethodBeat.o(129781);
    return false;
    return false;
  }
  
  public static byte[] gs(List<f> paramList)
  {
    AppMethodBeat.i(129782);
    if (paramList == null)
    {
      paramList = new IllegalArgumentException("pattern is null");
      AppMethodBeat.o(129782);
      throw paramList;
    }
    int j = paramList.size();
    Object localObject = new byte[j];
    int i = 0;
    while (i < j)
    {
      f localf = (f)paramList.get(i);
      int k = localf.ABP;
      localObject[i] = ((byte)(localf.ABQ + k * 3 + 1));
      i += 1;
    }
    paramList = new StringBuilder();
    i = 0;
    while (i < j)
    {
      paramList.append(localObject[i]);
      i += 1;
    }
    paramList = paramList.toString();
    localObject = u.aqG();
    localObject = com.tencent.mm.b.g.getMessageDigest((com.tencent.mm.b.g.getMessageDigest(paramList.getBytes()) + (String)localObject).getBytes());
    paramList = com.tencent.mm.b.g.getMessageDigest(((String)localObject + paramList).getBytes()).getBytes();
    AppMethodBeat.o(129782);
    return paramList;
  }
  
  public static byte[] stringToBytes(String paramString)
  {
    AppMethodBeat.i(129784);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = 0;
    while (i < paramString.length())
    {
      localByteArrayOutputStream.write(Integer.parseInt(paramString.substring(i, i + 2), 16));
      i += 2;
    }
    paramString = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(129784);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.e
 * JD-Core Version:    0.7.0.1
 */