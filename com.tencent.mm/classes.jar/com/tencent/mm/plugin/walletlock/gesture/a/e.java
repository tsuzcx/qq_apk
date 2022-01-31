package com.tencent.mm.plugin.walletlock.gesture.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.model.r;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.protocal.protobuf.bko;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayOutputStream;
import java.util.List;

public final class e
{
  public static void a(g paramg)
  {
    AppMethodBeat.i(51578);
    if (paramg.uEM == -1L)
    {
      AppMethodBeat.o(51578);
      return;
    }
    long l = SystemClock.elapsedRealtime();
    if (l < paramg.uEM)
    {
      paramg.uEM = l;
      paramg.uEN += l;
      ab.d("MicroMsg.GestureUtil", String.format("Rebooted, need to add additional %d ms, now elapsed %d ms", new Object[] { Long.valueOf(l), Long.valueOf(paramg.uEN) }));
      AppMethodBeat.o(51578);
      return;
    }
    paramg.uEN = (l - paramg.uEM + paramg.uEN);
    paramg.uEM = l;
    AppMethodBeat.o(51578);
  }
  
  public static boolean b(bkn parambkn)
  {
    AppMethodBeat.i(51573);
    if ((parambkn == null) || (parambkn.xzi == null) || (parambkn.xzi.getBuffer() == null))
    {
      AppMethodBeat.o(51573);
      return false;
    }
    byte[] arrayOfByte = parambkn.xzi.getBufferToBytes();
    if ((arrayOfByte.length == 0) || ((arrayOfByte.length & 0x1) != 0))
    {
      AppMethodBeat.o(51573);
      return false;
    }
    long l = new p(parambkn.uin).longValue();
    arrayOfByte = bA(arrayOfByte);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(parambkn.version);
    if (parambkn.xzg.hasBuffer()) {
      localStringBuilder.append(new String(parambkn.xzg.getBufferToBytes()));
    }
    localStringBuilder.append(l);
    int i = UtilsJni.doEcdsaVerify(a.uEI, localStringBuilder.toString().getBytes(), arrayOfByte);
    ab.d("MicroMsg.GestureUtil", String.format("verifyPatternBuffer, ret:%d", new Object[] { Integer.valueOf(i) }));
    if (i == 1)
    {
      AppMethodBeat.o(51573);
      return true;
    }
    AppMethodBeat.o(51573);
    return false;
  }
  
  public static boolean b(bko parambko)
  {
    AppMethodBeat.i(51574);
    if ((parambko == null) || (parambko.xzk == null) || (parambko.xzk.getBuffer() == null))
    {
      AppMethodBeat.o(51574);
      return false;
    }
    byte[] arrayOfByte = parambko.xzk.getBufferToBytes();
    if ((arrayOfByte.length == 0) || ((arrayOfByte.length & 0x1) != 0))
    {
      AppMethodBeat.o(51574);
      return false;
    }
    arrayOfByte = bA(arrayOfByte);
    com.tencent.mm.kernel.g.RJ();
    long l = new p(com.tencent.mm.kernel.a.getUin()).longValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(parambko.xzj);
    localStringBuilder.append(l);
    int i = UtilsJni.doEcdsaVerify(a.uEI, localStringBuilder.toString().getBytes(), arrayOfByte);
    if (((i != 1) && (parambko.xzl == 1)) || ((i == 1) && (parambko.xzl == 0))) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.GestureUtil", String.format("verifyPatternInfo, verifyRes:%d ret:%b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) }));
      AppMethodBeat.o(51574);
      return bool;
    }
  }
  
  private static byte[] bA(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(51575);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = 0;
    while (i < paramArrayOfByte.length - 1)
    {
      localByteArrayOutputStream.write("0123456789abcdef".indexOf(Character.toLowerCase(paramArrayOfByte[i])) << 4 | "0123456789abcdef".indexOf(Character.toLowerCase(paramArrayOfByte[(i + 1)])));
      i += 2;
    }
    paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(51575);
    return paramArrayOfByte;
  }
  
  public static String bB(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(51580);
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
    AppMethodBeat.o(51580);
    return paramArrayOfByte;
  }
  
  public static boolean cXK()
  {
    int k = -1;
    AppMethodBeat.i(51576);
    if ((!com.tencent.mm.kernel.g.RG()) || (com.tencent.mm.kernel.a.QP()))
    {
      ab.w("MicroMsg.GestureUtil", "not login !!");
      AppMethodBeat.o(51576);
      return false;
    }
    bko localbko = d.cXR();
    bkn localbkn = d.cXQ();
    int j;
    if (localbko == null) {
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
      if (localbkn == null)
      {
        i = 1;
        if (j != 0) {
          break label241;
        }
        bool1 = b(localbko);
        if (localbko != null) {
          break label246;
        }
        j = -1;
        ab.i("MicroMsg.GestureUtil", "tom isUserSetWalletLock serverInfo:%s status:%d  svrinfoValid:%s", new Object[] { localbko, Integer.valueOf(j), Boolean.valueOf(bool1) });
        if (i != 0) {
          break label255;
        }
        bool2 = b(localbkn);
        label115:
        if (localbkn != null) {
          break label261;
        }
        i = k;
        label122:
        ab.i("MicroMsg.GestureUtil", "tom isUserSetWalletLock localBuff:%s status:%d  localBuffValid:%s", new Object[] { localbkn, Integer.valueOf(i), Boolean.valueOf(bool2) });
        if ((bool1) && (!bool2)) {
          break label404;
        }
      }
      try
      {
        ab.i("MicroMsg.GestureUtil", "Both info & buff are valid, choose one to trust.");
        if (localbko.xzj > localbkn.version)
        {
          ab.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, srvInfo wins.", new Object[] { Integer.valueOf(localbko.xzj), Integer.valueOf(localbkn.version) });
          if (localbko.xzl == 1)
          {
            AppMethodBeat.o(51576);
            return true;
            j = 0;
            continue;
            i = 0;
            break label57;
            label241:
            bool1 = false;
            break label67;
            label246:
            j = localbko.xzl;
            break label74;
            label255:
            bool2 = false;
            break label115;
            label261:
            i = localbkn.xzh;
            break label122;
          }
          else
          {
            AppMethodBeat.o(51576);
            return false;
          }
        }
        else
        {
          if (localbko.xzj == localbkn.version)
          {
            ab.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, draw.", new Object[] { Integer.valueOf(localbko.xzj), Integer.valueOf(localbkn.version) });
            if (localbko.xzl == 1)
            {
              AppMethodBeat.o(51576);
              return true;
            }
            AppMethodBeat.o(51576);
            return false;
          }
          ab.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, localBuff wins.", new Object[] { Integer.valueOf(localbko.xzj), Integer.valueOf(localbkn.version) });
          if (localbkn.xzh == 1)
          {
            AppMethodBeat.o(51576);
            return true;
          }
          AppMethodBeat.o(51576);
          return false;
        }
      }
      catch (Exception localException)
      {
        label404:
        ab.printErrStackTrace("MicroMsg.GestureUtil", localException, "isUserSetWalletLock throw an exception.", new Object[0]);
        AppMethodBeat.o(51576);
      }
    }
    ab.i("MicroMsg.GestureUtil", "Info is valid but buf is invalid, we trust info this time.");
    if (localbko.xzl == 1)
    {
      AppMethodBeat.o(51576);
      return true;
    }
    AppMethodBeat.o(51576);
    return false;
    if (bool2)
    {
      ab.i("MicroMsg.GestureUtil", "Info is invalid but buff is valid, we trust buff this time.");
      if (localbkn.xzh == 1)
      {
        AppMethodBeat.o(51576);
        return true;
      }
      AppMethodBeat.o(51576);
      return false;
    }
    ab.w("MicroMsg.GestureUtil", "Both buff & info are invalid, do not activate this time and wait for next sync.");
    AppMethodBeat.o(51576);
    return false;
    return false;
  }
  
  public static byte[] ec(List<f> paramList)
  {
    AppMethodBeat.i(51577);
    if (paramList == null)
    {
      paramList = new IllegalArgumentException("pattern is null");
      AppMethodBeat.o(51577);
      throw paramList;
    }
    int j = paramList.size();
    Object localObject = new byte[j];
    int i = 0;
    while (i < j)
    {
      f localf = (f)paramList.get(i);
      int k = localf.uEJ;
      localObject[i] = ((byte)(localf.uEK + k * 3 + 1));
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
    localObject = r.Zn();
    localObject = com.tencent.mm.a.g.w((com.tencent.mm.a.g.w(paramList.getBytes()) + (String)localObject).getBytes());
    paramList = com.tencent.mm.a.g.w(((String)localObject + paramList).getBytes()).getBytes();
    AppMethodBeat.o(51577);
    return paramList;
  }
  
  public static byte[] stringToBytes(String paramString)
  {
    AppMethodBeat.i(51579);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = 0;
    while (i < paramString.length())
    {
      localByteArrayOutputStream.write(Integer.parseInt(paramString.substring(i, i + 2), 16));
      i += 2;
    }
    paramString = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(51579);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.e
 * JD-Core Version:    0.7.0.1
 */