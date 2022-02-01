package com.tencent.mm.plugin.walletlock.gesture.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.ebi;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;
import java.util.List;

public final class g
{
  public static void a(i parami)
  {
    AppMethodBeat.i(129783);
    if (parami.Wgt == -1L)
    {
      AppMethodBeat.o(129783);
      return;
    }
    long l = SystemClock.elapsedRealtime();
    if (l < parami.Wgt)
    {
      parami.Wgt = l;
      parami.Wgu += l;
      Log.d("MicroMsg.GestureUtil", String.format("Rebooted, need to add additional %d ms, now elapsed %d ms", new Object[] { Long.valueOf(l), Long.valueOf(parami.Wgu) }));
      AppMethodBeat.o(129783);
      return;
    }
    parami.Wgu = (l - parami.Wgt + parami.Wgu);
    parami.Wgt = l;
    AppMethodBeat.o(129783);
  }
  
  public static boolean b(ebi paramebi)
  {
    AppMethodBeat.i(129778);
    if ((paramebi == null) || (paramebi.abgT == null) || (paramebi.abgT.aaxD == null))
    {
      AppMethodBeat.o(129778);
      return false;
    }
    byte[] arrayOfByte = paramebi.abgT.aaxD.Op;
    if ((arrayOfByte.length == 0) || ((arrayOfByte.length & 0x1) != 0))
    {
      AppMethodBeat.o(129778);
      return false;
    }
    long l = new p(paramebi.uin).longValue();
    arrayOfByte = cM(arrayOfByte);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramebi.version);
    if (paramebi.abgR.aklm) {
      localStringBuilder.append(new String(paramebi.abgR.aaxD.Op));
    }
    localStringBuilder.append(l);
    int i = UtilsJni.doEcdsaVerify(b.Wgn, localStringBuilder.toString().getBytes(), arrayOfByte);
    Log.d("MicroMsg.GestureUtil", String.format("verifyPatternBuffer, ret:%d", new Object[] { Integer.valueOf(i) }));
    if (i == 1)
    {
      AppMethodBeat.o(129778);
      return true;
    }
    AppMethodBeat.o(129778);
    return false;
  }
  
  public static boolean b(ebj paramebj)
  {
    AppMethodBeat.i(129779);
    if ((paramebj == null) || (paramebj.abgV == null) || (paramebj.abgV.aaxD == null))
    {
      AppMethodBeat.o(129779);
      return false;
    }
    byte[] arrayOfByte = paramebj.abgV.aaxD.Op;
    if ((arrayOfByte.length == 0) || ((arrayOfByte.length & 0x1) != 0))
    {
      AppMethodBeat.o(129779);
      return false;
    }
    arrayOfByte = cM(arrayOfByte);
    com.tencent.mm.kernel.h.baC();
    long l = new p(com.tencent.mm.kernel.b.getUin()).longValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramebj.abgU);
    localStringBuilder.append(l);
    int i = UtilsJni.doEcdsaVerify(b.Wgn, localStringBuilder.toString().getBytes(), arrayOfByte);
    if (((i != 1) && (paramebj.abgW == 1)) || ((i == 1) && (paramebj.abgW == 0))) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.GestureUtil", String.format("verifyPatternInfo, verifyRes:%d ret:%b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) }));
      AppMethodBeat.o(129779);
      return bool;
    }
  }
  
  private static byte[] cM(byte[] paramArrayOfByte)
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
  
  public static String cN(byte[] paramArrayOfByte)
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
  
  public static boolean imQ()
  {
    int k = -1;
    AppMethodBeat.i(129781);
    if ((!com.tencent.mm.kernel.h.baz()) || (com.tencent.mm.kernel.b.aZG()))
    {
      Log.w("MicroMsg.GestureUtil", "not login !!");
      AppMethodBeat.o(129781);
      return false;
    }
    ebj localebj = f.imX();
    ebi localebi = f.imW();
    int j;
    if (localebj == null) {
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
      if (localebi == null)
      {
        i = 1;
        if (j != 0) {
          break label242;
        }
        bool1 = b(localebj);
        if (localebj != null) {
          break label247;
        }
        j = -1;
        Log.i("MicroMsg.GestureUtil", "tom isUserSetWalletLock serverInfo:%s status:%d  svrinfoValid:%s", new Object[] { localebj, Integer.valueOf(j), Boolean.valueOf(bool1) });
        if (i != 0) {
          break label256;
        }
        bool2 = b(localebi);
        label115:
        if (localebi != null) {
          break label262;
        }
        i = k;
        label122:
        Log.i("MicroMsg.GestureUtil", "tom isUserSetWalletLock localBuff:%s status:%d  localBuffValid:%s", new Object[] { localebi, Integer.valueOf(i), Boolean.valueOf(bool2) });
        if ((bool1) && (!bool2)) {
          break label405;
        }
      }
      try
      {
        Log.i("MicroMsg.GestureUtil", "Both info & buff are valid, choose one to trust.");
        if (localebj.abgU > localebi.version)
        {
          Log.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, srvInfo wins.", new Object[] { Integer.valueOf(localebj.abgU), Integer.valueOf(localebi.version) });
          if (localebj.abgW == 1)
          {
            AppMethodBeat.o(129781);
            return true;
            j = 0;
            continue;
            i = 0;
            break label57;
            label242:
            bool1 = false;
            break label67;
            label247:
            j = localebj.abgW;
            break label74;
            label256:
            bool2 = false;
            break label115;
            label262:
            i = localebi.abgS;
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
          if (localebj.abgU == localebi.version)
          {
            Log.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, draw.", new Object[] { Integer.valueOf(localebj.abgU), Integer.valueOf(localebi.version) });
            if (localebj.abgW == 1)
            {
              AppMethodBeat.o(129781);
              return true;
            }
            AppMethodBeat.o(129781);
            return false;
          }
          Log.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, localBuff wins.", new Object[] { Integer.valueOf(localebj.abgU), Integer.valueOf(localebi.version) });
          if (localebi.abgS == 1)
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
        label405:
        Log.printErrStackTrace("MicroMsg.GestureUtil", localException, "isUserSetWalletLock throw an exception.", new Object[0]);
        AppMethodBeat.o(129781);
      }
    }
    Log.i("MicroMsg.GestureUtil", "Info is valid but buf is invalid, we trust info this time.");
    if (localebj.abgW == 1)
    {
      AppMethodBeat.o(129781);
      return true;
    }
    AppMethodBeat.o(129781);
    return false;
    if (bool2)
    {
      Log.i("MicroMsg.GestureUtil", "Info is invalid but buff is valid, we trust buff this time.");
      if (localebi.abgS == 1)
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
  
  public static byte[] md(List<h> paramList)
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
      h localh = (h)paramList.get(i);
      int k = localh.Wgq;
      localObject[i] = ((byte)(localh.Wgr + k * 3 + 1));
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
    localObject = z.bAM();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.g
 * JD-Core Version:    0.7.0.1
 */