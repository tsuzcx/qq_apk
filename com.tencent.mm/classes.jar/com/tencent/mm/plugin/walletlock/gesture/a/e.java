package com.tencent.mm.plugin.walletlock.gesture.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.model.v;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cjc;
import com.tencent.mm.protocal.protobuf.cjd;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.ByteArrayOutputStream;
import java.util.List;

public final class e
{
  public static void a(g paramg)
  {
    AppMethodBeat.i(129783);
    if (paramg.DMm == -1L)
    {
      AppMethodBeat.o(129783);
      return;
    }
    long l = SystemClock.elapsedRealtime();
    if (l < paramg.DMm)
    {
      paramg.DMm = l;
      paramg.DMn += l;
      ae.d("MicroMsg.GestureUtil", String.format("Rebooted, need to add additional %d ms, now elapsed %d ms", new Object[] { Long.valueOf(l), Long.valueOf(paramg.DMn) }));
      AppMethodBeat.o(129783);
      return;
    }
    paramg.DMn = (l - paramg.DMm + paramg.DMn);
    paramg.DMm = l;
    AppMethodBeat.o(129783);
  }
  
  public static boolean b(cjc paramcjc)
  {
    AppMethodBeat.i(129778);
    if ((paramcjc == null) || (paramcjc.HvJ == null) || (paramcjc.HvJ.getBuffer() == null))
    {
      AppMethodBeat.o(129778);
      return false;
    }
    byte[] arrayOfByte = paramcjc.HvJ.getBufferToBytes();
    if ((arrayOfByte.length == 0) || ((arrayOfByte.length & 0x1) != 0))
    {
      AppMethodBeat.o(129778);
      return false;
    }
    long l = new p(paramcjc.uin).longValue();
    arrayOfByte = cb(arrayOfByte);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramcjc.version);
    if (paramcjc.HvH.hasBuffer()) {
      localStringBuilder.append(new String(paramcjc.HvH.getBufferToBytes()));
    }
    localStringBuilder.append(l);
    int i = UtilsJni.doEcdsaVerify(a.DMi, localStringBuilder.toString().getBytes(), arrayOfByte);
    ae.d("MicroMsg.GestureUtil", String.format("verifyPatternBuffer, ret:%d", new Object[] { Integer.valueOf(i) }));
    if (i == 1)
    {
      AppMethodBeat.o(129778);
      return true;
    }
    AppMethodBeat.o(129778);
    return false;
  }
  
  public static boolean b(cjd paramcjd)
  {
    AppMethodBeat.i(129779);
    if ((paramcjd == null) || (paramcjd.HvL == null) || (paramcjd.HvL.getBuffer() == null))
    {
      AppMethodBeat.o(129779);
      return false;
    }
    byte[] arrayOfByte = paramcjd.HvL.getBufferToBytes();
    if ((arrayOfByte.length == 0) || ((arrayOfByte.length & 0x1) != 0))
    {
      AppMethodBeat.o(129779);
      return false;
    }
    arrayOfByte = cb(arrayOfByte);
    com.tencent.mm.kernel.g.ajP();
    long l = new p(com.tencent.mm.kernel.a.getUin()).longValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramcjd.HvK);
    localStringBuilder.append(l);
    int i = UtilsJni.doEcdsaVerify(a.DMi, localStringBuilder.toString().getBytes(), arrayOfByte);
    if (((i != 1) && (paramcjd.HvM == 1)) || ((i == 1) && (paramcjd.HvM == 0))) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.GestureUtil", String.format("verifyPatternInfo, verifyRes:%d ret:%b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) }));
      AppMethodBeat.o(129779);
      return bool;
    }
  }
  
  private static byte[] cb(byte[] paramArrayOfByte)
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
  
  public static String cc(byte[] paramArrayOfByte)
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
  
  public static boolean eNm()
  {
    int k = -1;
    AppMethodBeat.i(129781);
    if ((!com.tencent.mm.kernel.g.ajM()) || (com.tencent.mm.kernel.a.aiT()))
    {
      ae.w("MicroMsg.GestureUtil", "not login !!");
      AppMethodBeat.o(129781);
      return false;
    }
    cjd localcjd = d.eNt();
    cjc localcjc = d.eNs();
    int j;
    if (localcjd == null) {
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
      if (localcjc == null)
      {
        i = 1;
        if (j != 0) {
          break label241;
        }
        bool1 = b(localcjd);
        if (localcjd != null) {
          break label246;
        }
        j = -1;
        ae.i("MicroMsg.GestureUtil", "tom isUserSetWalletLock serverInfo:%s status:%d  svrinfoValid:%s", new Object[] { localcjd, Integer.valueOf(j), Boolean.valueOf(bool1) });
        if (i != 0) {
          break label255;
        }
        bool2 = b(localcjc);
        label115:
        if (localcjc != null) {
          break label261;
        }
        i = k;
        label122:
        ae.i("MicroMsg.GestureUtil", "tom isUserSetWalletLock localBuff:%s status:%d  localBuffValid:%s", new Object[] { localcjc, Integer.valueOf(i), Boolean.valueOf(bool2) });
        if ((bool1) && (!bool2)) {
          break label404;
        }
      }
      try
      {
        ae.i("MicroMsg.GestureUtil", "Both info & buff are valid, choose one to trust.");
        if (localcjd.HvK > localcjc.version)
        {
          ae.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, srvInfo wins.", new Object[] { Integer.valueOf(localcjd.HvK), Integer.valueOf(localcjc.version) });
          if (localcjd.HvM == 1)
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
            j = localcjd.HvM;
            break label74;
            label255:
            bool2 = false;
            break label115;
            label261:
            i = localcjc.HvI;
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
          if (localcjd.HvK == localcjc.version)
          {
            ae.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, draw.", new Object[] { Integer.valueOf(localcjd.HvK), Integer.valueOf(localcjc.version) });
            if (localcjd.HvM == 1)
            {
              AppMethodBeat.o(129781);
              return true;
            }
            AppMethodBeat.o(129781);
            return false;
          }
          ae.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, localBuff wins.", new Object[] { Integer.valueOf(localcjd.HvK), Integer.valueOf(localcjc.version) });
          if (localcjc.HvI == 1)
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
        ae.printErrStackTrace("MicroMsg.GestureUtil", localException, "isUserSetWalletLock throw an exception.", new Object[0]);
        AppMethodBeat.o(129781);
      }
    }
    ae.i("MicroMsg.GestureUtil", "Info is valid but buf is invalid, we trust info this time.");
    if (localcjd.HvM == 1)
    {
      AppMethodBeat.o(129781);
      return true;
    }
    AppMethodBeat.o(129781);
    return false;
    if (bool2)
    {
      ae.i("MicroMsg.GestureUtil", "Info is invalid but buff is valid, we trust buff this time.");
      if (localcjc.HvI == 1)
      {
        AppMethodBeat.o(129781);
        return true;
      }
      AppMethodBeat.o(129781);
      return false;
    }
    ae.w("MicroMsg.GestureUtil", "Both buff & info are invalid, do not activate this time and wait for next sync.");
    AppMethodBeat.o(129781);
    return false;
    return false;
  }
  
  public static byte[] gZ(List<f> paramList)
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
      int k = localf.DMj;
      localObject[i] = ((byte)(localf.DMk + k * 3 + 1));
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
    localObject = v.aAC();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.e
 * JD-Core Version:    0.7.0.1
 */