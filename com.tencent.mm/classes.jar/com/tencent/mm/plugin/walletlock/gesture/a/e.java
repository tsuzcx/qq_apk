package com.tencent.mm.plugin.walletlock.gesture.a;

import android.os.SystemClock;
import com.tencent.mm.a.o;
import com.tencent.mm.bv.b;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.model.q;
import com.tencent.mm.protocal.c.bcu;
import com.tencent.mm.protocal.c.bcv;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.util.List;

public final class e
{
  public static byte[] Rc(String paramString)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = 0;
    while (i < paramString.length())
    {
      localByteArrayOutputStream.write(Integer.parseInt(paramString.substring(i, i + 2), 16));
      i += 2;
    }
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static void a(g paramg)
  {
    if (paramg.qPE == -1L) {
      return;
    }
    long l = SystemClock.elapsedRealtime();
    if (l < paramg.qPE)
    {
      paramg.qPE = l;
      paramg.qPF += l;
      y.d("MicroMsg.GestureUtil", String.format("Rebooted, need to add additional %d ms, now elapsed %d ms", new Object[] { Long.valueOf(l), Long.valueOf(paramg.qPF) }));
      return;
    }
    paramg.qPF = (l - paramg.qPE + paramg.qPF);
    paramg.qPE = l;
  }
  
  private static byte[] aZ(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = 0;
    while (i < paramArrayOfByte.length - 1)
    {
      localByteArrayOutputStream.write("0123456789abcdef".indexOf(Character.toLowerCase(paramArrayOfByte[i])) << 4 | "0123456789abcdef".indexOf(Character.toLowerCase(paramArrayOfByte[(i + 1)])));
      i += 2;
    }
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static boolean b(bcu parambcu)
  {
    boolean bool = true;
    if ((parambcu == null) || (parambcu.tyf == null) || (parambcu.tyf.tFM == null)) {
      bool = false;
    }
    int i;
    do
    {
      return bool;
      byte[] arrayOfByte = parambcu.tyf.tFM.oY;
      if ((arrayOfByte.length == 0) || ((arrayOfByte.length & 0x1) != 0)) {
        return false;
      }
      long l = new o(parambcu.uin).longValue();
      arrayOfByte = aZ(arrayOfByte);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(parambcu.version);
      if (parambcu.tyd.tFN) {
        localStringBuilder.append(new String(parambcu.tyd.tFM.oY));
      }
      localStringBuilder.append(l);
      i = UtilsJni.doEcdsaVerify(a.qPA, localStringBuilder.toString().getBytes(), arrayOfByte);
      y.d("MicroMsg.GestureUtil", String.format("verifyPatternBuffer, ret:%d", new Object[] { Integer.valueOf(i) }));
    } while (i == 1);
    return false;
  }
  
  public static boolean b(bcv parambcv)
  {
    if ((parambcv == null) || (parambcv.tyh == null) || (parambcv.tyh.tFM == null)) {}
    do
    {
      return false;
      arrayOfByte = parambcv.tyh.tFM.oY;
    } while ((arrayOfByte.length == 0) || ((arrayOfByte.length & 0x1) != 0));
    byte[] arrayOfByte = aZ(arrayOfByte);
    com.tencent.mm.kernel.g.DN();
    long l = new o(com.tencent.mm.kernel.a.CK()).longValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(parambcv.tyg);
    localStringBuilder.append(l);
    int i = UtilsJni.doEcdsaVerify(a.qPA, localStringBuilder.toString().getBytes(), arrayOfByte);
    if (((i != 1) && (parambcv.tyi == 1)) || ((i == 1) && (parambcv.tyi == 0))) {}
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.GestureUtil", String.format("verifyPatternInfo, verifyRes:%d ret:%b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) }));
      return bool;
    }
  }
  
  public static boolean bYc()
  {
    int k = -1;
    if ((!com.tencent.mm.kernel.g.DK()) || (com.tencent.mm.kernel.a.CW())) {
      y.w("MicroMsg.GestureUtil", "not login !!");
    }
    label40:
    label47:
    label57:
    label64:
    label105:
    label112:
    label242:
    label248:
    do
    {
      do
      {
        for (;;)
        {
          return false;
          bcv localbcv = d.bYj();
          bcu localbcu = d.bYi();
          int j;
          int i;
          boolean bool1;
          boolean bool2;
          if (localbcv == null)
          {
            j = 1;
            if (localbcu != null) {
              break label223;
            }
            i = 1;
            if (j != 0) {
              break label228;
            }
            bool1 = b(localbcv);
            if (localbcv != null) {
              break label233;
            }
            j = -1;
            y.i("MicroMsg.GestureUtil", "tom isUserSetWalletLock serverInfo:%s status:%d  svrinfoValid:%s", new Object[] { localbcv, Integer.valueOf(j), Boolean.valueOf(bool1) });
            if (i != 0) {
              break label242;
            }
            bool2 = b(localbcu);
            if (localbcu != null) {
              break label248;
            }
            i = k;
            y.i("MicroMsg.GestureUtil", "tom isUserSetWalletLock localBuff:%s status:%d  localBuffValid:%s", new Object[] { localbcu, Integer.valueOf(i), Boolean.valueOf(bool2) });
            if ((bool1) && (!bool2)) {
              break label358;
            }
          }
          try
          {
            y.i("MicroMsg.GestureUtil", "Both info & buff are valid, choose one to trust.");
            if (localbcv.tyg > localbcu.version)
            {
              y.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, srvInfo wins.", new Object[] { Integer.valueOf(localbcv.tyg), Integer.valueOf(localbcu.version) });
              i = localbcv.tyi;
              if (i == 1)
              {
                return true;
                j = 0;
                break label40;
                i = 0;
                break label47;
                bool1 = false;
                break label57;
                j = localbcv.tyi;
                break label64;
                bool2 = false;
                break label105;
                i = localbcu.tye;
                break label112;
              }
            }
            else if (localbcv.tyg == localbcu.version)
            {
              y.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, draw.", new Object[] { Integer.valueOf(localbcv.tyg), Integer.valueOf(localbcu.version) });
              if (localbcv.tyi == 1) {
                return true;
              }
            }
            else
            {
              y.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, localBuff wins.", new Object[] { Integer.valueOf(localbcv.tyg), Integer.valueOf(localbcu.version) });
              if (localbcu.tye == 1) {
                return true;
              }
            }
          }
          catch (Exception localException)
          {
            y.printErrStackTrace("MicroMsg.GestureUtil", localException, "isUserSetWalletLock throw an exception.", new Object[0]);
          }
        }
        y.i("MicroMsg.GestureUtil", "Info is valid but buf is invalid, we trust info this time.");
      } while (localbcv.tyi != 1);
      return true;
      if (!bool2) {
        break;
      }
      y.i("MicroMsg.GestureUtil", "Info is invalid but buff is valid, we trust buff this time.");
    } while (localbcu.tye != 1);
    label223:
    label228:
    label233:
    return true;
    label358:
    y.w("MicroMsg.GestureUtil", "Both buff & info are invalid, do not activate this time and wait for next sync.");
    return false;
    return false;
  }
  
  public static String ba(byte[] paramArrayOfByte)
  {
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
    return localStringBuilder.toString();
  }
  
  public static byte[] cY(List<f> paramList)
  {
    if (paramList == null) {
      throw new IllegalArgumentException("pattern is null");
    }
    int j = paramList.size();
    Object localObject = new byte[j];
    int i = 0;
    while (i < j)
    {
      f localf = (f)paramList.get(i);
      int k = localf.qPB;
      localObject[i] = ((byte)(localf.qPC + k * 3 + 1));
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
    localObject = q.Gj();
    localObject = com.tencent.mm.a.g.o((com.tencent.mm.a.g.o(paramList.getBytes()) + (String)localObject).getBytes());
    return com.tencent.mm.a.g.o(((String)localObject + paramList).getBytes()).getBytes();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.e
 * JD-Core Version:    0.7.0.1
 */