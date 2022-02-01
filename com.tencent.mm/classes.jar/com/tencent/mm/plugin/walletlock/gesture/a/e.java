package com.tencent.mm.plugin.walletlock.gesture.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cdj;
import com.tencent.mm.protocal.protobuf.cdk;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.ByteArrayOutputStream;
import java.util.List;

public final class e
{
  public static void a(g paramg)
  {
    AppMethodBeat.i(129783);
    if (paramg.BUn == -1L)
    {
      AppMethodBeat.o(129783);
      return;
    }
    long l = SystemClock.elapsedRealtime();
    if (l < paramg.BUn)
    {
      paramg.BUn = l;
      paramg.BUo += l;
      ac.d("MicroMsg.GestureUtil", String.format("Rebooted, need to add additional %d ms, now elapsed %d ms", new Object[] { Long.valueOf(l), Long.valueOf(paramg.BUo) }));
      AppMethodBeat.o(129783);
      return;
    }
    paramg.BUo = (l - paramg.BUn + paramg.BUo);
    paramg.BUn = l;
    AppMethodBeat.o(129783);
  }
  
  public static boolean b(cdj paramcdj)
  {
    AppMethodBeat.i(129778);
    if ((paramcdj == null) || (paramcdj.Fsd == null) || (paramcdj.Fsd.getBuffer() == null))
    {
      AppMethodBeat.o(129778);
      return false;
    }
    byte[] arrayOfByte = paramcdj.Fsd.getBufferToBytes();
    if ((arrayOfByte.length == 0) || ((arrayOfByte.length & 0x1) != 0))
    {
      AppMethodBeat.o(129778);
      return false;
    }
    long l = new p(paramcdj.uin).longValue();
    arrayOfByte = bR(arrayOfByte);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramcdj.version);
    if (paramcdj.Fsb.hasBuffer()) {
      localStringBuilder.append(new String(paramcdj.Fsb.getBufferToBytes()));
    }
    localStringBuilder.append(l);
    int i = UtilsJni.doEcdsaVerify(a.BUj, localStringBuilder.toString().getBytes(), arrayOfByte);
    ac.d("MicroMsg.GestureUtil", String.format("verifyPatternBuffer, ret:%d", new Object[] { Integer.valueOf(i) }));
    if (i == 1)
    {
      AppMethodBeat.o(129778);
      return true;
    }
    AppMethodBeat.o(129778);
    return false;
  }
  
  public static boolean b(cdk paramcdk)
  {
    AppMethodBeat.i(129779);
    if ((paramcdk == null) || (paramcdk.Fsf == null) || (paramcdk.Fsf.getBuffer() == null))
    {
      AppMethodBeat.o(129779);
      return false;
    }
    byte[] arrayOfByte = paramcdk.Fsf.getBufferToBytes();
    if ((arrayOfByte.length == 0) || ((arrayOfByte.length & 0x1) != 0))
    {
      AppMethodBeat.o(129779);
      return false;
    }
    arrayOfByte = bR(arrayOfByte);
    com.tencent.mm.kernel.g.agP();
    long l = new p(com.tencent.mm.kernel.a.getUin()).longValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramcdk.Fse);
    localStringBuilder.append(l);
    int i = UtilsJni.doEcdsaVerify(a.BUj, localStringBuilder.toString().getBytes(), arrayOfByte);
    if (((i != 1) && (paramcdk.Fsg == 1)) || ((i == 1) && (paramcdk.Fsg == 0))) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.GestureUtil", String.format("verifyPatternInfo, verifyRes:%d ret:%b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) }));
      AppMethodBeat.o(129779);
      return bool;
    }
  }
  
  private static byte[] bR(byte[] paramArrayOfByte)
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
  
  public static String bS(byte[] paramArrayOfByte)
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
  
  public static boolean evy()
  {
    int k = -1;
    AppMethodBeat.i(129781);
    if ((!com.tencent.mm.kernel.g.agM()) || (com.tencent.mm.kernel.a.afS()))
    {
      ac.w("MicroMsg.GestureUtil", "not login !!");
      AppMethodBeat.o(129781);
      return false;
    }
    cdk localcdk = d.evF();
    cdj localcdj = d.evE();
    int j;
    if (localcdk == null) {
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
      if (localcdj == null)
      {
        i = 1;
        if (j != 0) {
          break label241;
        }
        bool1 = b(localcdk);
        if (localcdk != null) {
          break label246;
        }
        j = -1;
        ac.i("MicroMsg.GestureUtil", "tom isUserSetWalletLock serverInfo:%s status:%d  svrinfoValid:%s", new Object[] { localcdk, Integer.valueOf(j), Boolean.valueOf(bool1) });
        if (i != 0) {
          break label255;
        }
        bool2 = b(localcdj);
        label115:
        if (localcdj != null) {
          break label261;
        }
        i = k;
        label122:
        ac.i("MicroMsg.GestureUtil", "tom isUserSetWalletLock localBuff:%s status:%d  localBuffValid:%s", new Object[] { localcdj, Integer.valueOf(i), Boolean.valueOf(bool2) });
        if ((bool1) && (!bool2)) {
          break label404;
        }
      }
      try
      {
        ac.i("MicroMsg.GestureUtil", "Both info & buff are valid, choose one to trust.");
        if (localcdk.Fse > localcdj.version)
        {
          ac.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, srvInfo wins.", new Object[] { Integer.valueOf(localcdk.Fse), Integer.valueOf(localcdj.version) });
          if (localcdk.Fsg == 1)
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
            j = localcdk.Fsg;
            break label74;
            label255:
            bool2 = false;
            break label115;
            label261:
            i = localcdj.Fsc;
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
          if (localcdk.Fse == localcdj.version)
          {
            ac.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, draw.", new Object[] { Integer.valueOf(localcdk.Fse), Integer.valueOf(localcdj.version) });
            if (localcdk.Fsg == 1)
            {
              AppMethodBeat.o(129781);
              return true;
            }
            AppMethodBeat.o(129781);
            return false;
          }
          ac.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, localBuff wins.", new Object[] { Integer.valueOf(localcdk.Fse), Integer.valueOf(localcdj.version) });
          if (localcdj.Fsc == 1)
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
        ac.printErrStackTrace("MicroMsg.GestureUtil", localException, "isUserSetWalletLock throw an exception.", new Object[0]);
        AppMethodBeat.o(129781);
      }
    }
    ac.i("MicroMsg.GestureUtil", "Info is valid but buf is invalid, we trust info this time.");
    if (localcdk.Fsg == 1)
    {
      AppMethodBeat.o(129781);
      return true;
    }
    AppMethodBeat.o(129781);
    return false;
    if (bool2)
    {
      ac.i("MicroMsg.GestureUtil", "Info is invalid but buff is valid, we trust buff this time.");
      if (localcdj.Fsc == 1)
      {
        AppMethodBeat.o(129781);
        return true;
      }
      AppMethodBeat.o(129781);
      return false;
    }
    ac.w("MicroMsg.GestureUtil", "Both buff & info are invalid, do not activate this time and wait for next sync.");
    AppMethodBeat.o(129781);
    return false;
    return false;
  }
  
  public static byte[] gD(List<f> paramList)
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
      int k = localf.BUk;
      localObject[i] = ((byte)(localf.BUl + k * 3 + 1));
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
    localObject = u.axw();
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