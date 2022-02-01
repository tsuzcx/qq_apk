package com.tencent.mm.plugin.walletlock.gesture.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.czk;
import com.tencent.mm.protocal.protobuf.czl;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;
import java.util.List;

public final class e
{
  public static void a(g paramg)
  {
    AppMethodBeat.i(129783);
    if (paramg.IvB == -1L)
    {
      AppMethodBeat.o(129783);
      return;
    }
    long l = SystemClock.elapsedRealtime();
    if (l < paramg.IvB)
    {
      paramg.IvB = l;
      paramg.IvC += l;
      Log.d("MicroMsg.GestureUtil", String.format("Rebooted, need to add additional %d ms, now elapsed %d ms", new Object[] { Long.valueOf(l), Long.valueOf(paramg.IvC) }));
      AppMethodBeat.o(129783);
      return;
    }
    paramg.IvC = (l - paramg.IvB + paramg.IvC);
    paramg.IvB = l;
    AppMethodBeat.o(129783);
  }
  
  public static boolean b(czk paramczk)
  {
    AppMethodBeat.i(129778);
    if ((paramczk == null) || (paramczk.MEI == null) || (paramczk.MEI.getBuffer() == null))
    {
      AppMethodBeat.o(129778);
      return false;
    }
    byte[] arrayOfByte = paramczk.MEI.getBufferToBytes();
    if ((arrayOfByte.length == 0) || ((arrayOfByte.length & 0x1) != 0))
    {
      AppMethodBeat.o(129778);
      return false;
    }
    long l = new p(paramczk.uin).longValue();
    arrayOfByte = ct(arrayOfByte);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramczk.version);
    if (paramczk.MEG.hasBuffer()) {
      localStringBuilder.append(new String(paramczk.MEG.getBufferToBytes()));
    }
    localStringBuilder.append(l);
    int i = UtilsJni.doEcdsaVerify(a.Ivx, localStringBuilder.toString().getBytes(), arrayOfByte);
    Log.d("MicroMsg.GestureUtil", String.format("verifyPatternBuffer, ret:%d", new Object[] { Integer.valueOf(i) }));
    if (i == 1)
    {
      AppMethodBeat.o(129778);
      return true;
    }
    AppMethodBeat.o(129778);
    return false;
  }
  
  public static boolean b(czl paramczl)
  {
    AppMethodBeat.i(129779);
    if ((paramczl == null) || (paramczl.MEK == null) || (paramczl.MEK.getBuffer() == null))
    {
      AppMethodBeat.o(129779);
      return false;
    }
    byte[] arrayOfByte = paramczl.MEK.getBufferToBytes();
    if ((arrayOfByte.length == 0) || ((arrayOfByte.length & 0x1) != 0))
    {
      AppMethodBeat.o(129779);
      return false;
    }
    arrayOfByte = ct(arrayOfByte);
    com.tencent.mm.kernel.g.aAf();
    long l = new p(com.tencent.mm.kernel.a.getUin()).longValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramczl.MEJ);
    localStringBuilder.append(l);
    int i = UtilsJni.doEcdsaVerify(a.Ivx, localStringBuilder.toString().getBytes(), arrayOfByte);
    if (((i != 1) && (paramczl.MEL == 1)) || ((i == 1) && (paramczl.MEL == 0))) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.GestureUtil", String.format("verifyPatternInfo, verifyRes:%d ret:%b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) }));
      AppMethodBeat.o(129779);
      return bool;
    }
  }
  
  public static String bytesToString(byte[] paramArrayOfByte)
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
  
  private static byte[] ct(byte[] paramArrayOfByte)
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
  
  public static boolean fUV()
  {
    int k = -1;
    AppMethodBeat.i(129781);
    if ((!com.tencent.mm.kernel.g.aAc()) || (com.tencent.mm.kernel.a.azj()))
    {
      Log.w("MicroMsg.GestureUtil", "not login !!");
      AppMethodBeat.o(129781);
      return false;
    }
    czl localczl = d.fVc();
    czk localczk = d.fVb();
    int j;
    if (localczl == null) {
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
      if (localczk == null)
      {
        i = 1;
        if (j != 0) {
          break label241;
        }
        bool1 = b(localczl);
        if (localczl != null) {
          break label246;
        }
        j = -1;
        Log.i("MicroMsg.GestureUtil", "tom isUserSetWalletLock serverInfo:%s status:%d  svrinfoValid:%s", new Object[] { localczl, Integer.valueOf(j), Boolean.valueOf(bool1) });
        if (i != 0) {
          break label255;
        }
        bool2 = b(localczk);
        label115:
        if (localczk != null) {
          break label261;
        }
        i = k;
        label122:
        Log.i("MicroMsg.GestureUtil", "tom isUserSetWalletLock localBuff:%s status:%d  localBuffValid:%s", new Object[] { localczk, Integer.valueOf(i), Boolean.valueOf(bool2) });
        if ((bool1) && (!bool2)) {
          break label404;
        }
      }
      try
      {
        Log.i("MicroMsg.GestureUtil", "Both info & buff are valid, choose one to trust.");
        if (localczl.MEJ > localczk.version)
        {
          Log.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, srvInfo wins.", new Object[] { Integer.valueOf(localczl.MEJ), Integer.valueOf(localczk.version) });
          if (localczl.MEL == 1)
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
            j = localczl.MEL;
            break label74;
            label255:
            bool2 = false;
            break label115;
            label261:
            i = localczk.MEH;
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
          if (localczl.MEJ == localczk.version)
          {
            Log.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, draw.", new Object[] { Integer.valueOf(localczl.MEJ), Integer.valueOf(localczk.version) });
            if (localczl.MEL == 1)
            {
              AppMethodBeat.o(129781);
              return true;
            }
            AppMethodBeat.o(129781);
            return false;
          }
          Log.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, localBuff wins.", new Object[] { Integer.valueOf(localczl.MEJ), Integer.valueOf(localczk.version) });
          if (localczk.MEH == 1)
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
        Log.printErrStackTrace("MicroMsg.GestureUtil", localException, "isUserSetWalletLock throw an exception.", new Object[0]);
        AppMethodBeat.o(129781);
      }
    }
    Log.i("MicroMsg.GestureUtil", "Info is valid but buf is invalid, we trust info this time.");
    if (localczl.MEL == 1)
    {
      AppMethodBeat.o(129781);
      return true;
    }
    AppMethodBeat.o(129781);
    return false;
    if (bool2)
    {
      Log.i("MicroMsg.GestureUtil", "Info is invalid but buff is valid, we trust buff this time.");
      if (localczk.MEH == 1)
      {
        AppMethodBeat.o(129781);
        return true;
      }
      AppMethodBeat.o(129781);
      return false;
    }
    Log.w("MicroMsg.GestureUtil", "Both buff & info are invalid, do not activate this time and wait for next sync.");
    AppMethodBeat.o(129781);
    return false;
    return false;
  }
  
  public static byte[] jdMethod_if(List<f> paramList)
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
      int k = localf.Ivy;
      localObject[i] = ((byte)(localf.Ivz + k * 3 + 1));
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
    localObject = z.aTY();
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