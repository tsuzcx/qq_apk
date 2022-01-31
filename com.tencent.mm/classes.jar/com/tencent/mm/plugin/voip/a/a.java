package com.tencent.mm.plugin.voip.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mm.protocal.c.bvg;
import com.tencent.mm.protocal.c.ceb;
import com.tencent.mm.protocal.c.cec;
import com.tencent.mm.protocal.c.cfk;
import com.tencent.mm.protocal.c.cfw;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.BufferedOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedList;

public final class a
{
  static BufferedOutputStream mOutputStream = null;
  public static boolean pZF = false;
  
  public static byte[] Aq(int paramInt)
  {
    byte[] arrayOfByte = new byte[4];
    int i = 0;
    while (i < 4)
    {
      arrayOfByte[i] = ((byte)(paramInt >>> i * 8));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static void Ar(int paramInt)
  {
    long l = paramInt;
    try
    {
      Thread.sleep(l);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      y.printErrStackTrace("MicroMsg.Voip", localInterruptedException, "", new Object[0]);
    }
  }
  
  private static String As(int paramInt)
  {
    try
    {
      String str = InetAddress.getByAddress(new byte[] { (byte)(paramInt >>> 24 & 0xFF), (byte)(paramInt >>> 16 & 0xFF), (byte)(paramInt >>> 8 & 0xFF), (byte)(paramInt & 0xFF) }).getHostAddress();
      return str;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.Voip", localException, "", new Object[0]);
    }
    return null;
  }
  
  public static int Gh(String paramString)
  {
    try
    {
      byte[] arrayOfByte = InetAddress.getByName(paramString).getAddress();
      if (arrayOfByte != null)
      {
        int i = 0;
        int j = 0;
        while (i < arrayOfByte.length)
        {
          j = j << 8 | arrayOfByte[i] & 0xFF;
          i += 1;
        }
        y.d("MicroMsg.Voip", "ipAddressStrToInt, ip: %s, result: %d", new Object[] { paramString, Integer.valueOf(j) });
        return j;
      }
    }
    catch (UnknownHostException paramString)
    {
      y.printErrStackTrace("MicroMsg.Voip", paramString, "", new Object[0]);
    }
    return 0;
  }
  
  public static void Logd(String paramString1, String paramString2)
  {
    y.d(paramString1, "[" + Thread.currentThread().getId() + "]" + paramString2);
    writeLogToFile(paramString1 + ":" + paramString2 + " \n");
  }
  
  public static void Loge(String paramString1, String paramString2)
  {
    y.e(paramString1, "[" + Thread.currentThread().getId() + "]" + paramString2);
    writeLogToFile(paramString1 + ":" + paramString2 + " \n");
  }
  
  public static void Logi(String paramString1, String paramString2)
  {
    y.i(paramString1, "[" + Thread.currentThread().getId() + "]" + paramString2);
    writeLogToFile(paramString1 + ":" + paramString2 + " \n");
  }
  
  public static void Logw(String paramString1, String paramString2)
  {
    y.w(paramString1, "[" + Thread.currentThread().getId() + "]" + paramString2);
    writeLogToFile(paramString1 + ":" + paramString2 + " \n");
  }
  
  public static int[] a(cec paramcec)
  {
    y.d("MicroMsg.Voip", "convertSvrAddr: voipAddr.Cnt " + paramcec.tSS);
    if (3 >= paramcec.tSS) {}
    for (int i = paramcec.tSS;; i = 3)
    {
      y.d("MicroMsg.Voip", "convertSvrAddr: addrCnt " + i);
      int[] arrayOfInt = new int[i * 2];
      int j = 0;
      while (j < i)
      {
        arrayOfInt[(j * 2)] = ((ceb)paramcec.tST.get(j)).tNg;
        arrayOfInt[(j * 2 + 1)] = ((ceb)paramcec.tST.get(j)).tAA;
        y.d("MicroMsg.Voip", "convertSvrAddr: ip " + As(((ceb)paramcec.tST.get(j)).tNg) + " Port: " + ((ceb)paramcec.tST.get(j)).tAA);
        j += 1;
      }
      return arrayOfInt;
    }
  }
  
  public static int[] a(cfw paramcfw)
  {
    y.d("MicroMsg.Voip", "convertSpeedTestPara: testID= " + paramcfw.tUY + " SvrListCnt= " + paramcfw.tVd);
    if (3 >= paramcfw.tVd) {}
    for (int i = paramcfw.tVd;; i = 3)
    {
      int[] arrayOfInt = new int[i * 6];
      int j = 0;
      while (j < i)
      {
        arrayOfInt[(j * 6)] = ((bvg)paramcfw.tVe.get(j)).tLB.tNg;
        arrayOfInt[(j * 6 + 1)] = ((bvg)paramcfw.tVe.get(j)).tLB.tAA;
        arrayOfInt[(j * 6 + 2)] = ((bvg)paramcfw.tVe.get(j)).tLA;
        arrayOfInt[(j * 6 + 3)] = ((bvg)paramcfw.tVe.get(j)).tLW;
        arrayOfInt[(j * 6 + 4)] = ((bvg)paramcfw.tVe.get(j)).tLX;
        arrayOfInt[(j * 6 + 5)] = ((bvg)paramcfw.tVe.get(j)).tLY;
        y.d("MicroMsg.Voip", "convertSpeedTestPara: ip " + As(((bvg)paramcfw.tVe.get(j)).tLB.tNg) + " Port: " + ((bvg)paramcfw.tVe.get(j)).tLB.tAA + " TestCnt= " + ((bvg)paramcfw.tVe.get(j)).tLA + " TestGap= " + ((bvg)paramcfw.tVe.get(j)).tLW + " Timeout= " + ((bvg)paramcfw.tVe.get(j)).tLX + " PktSize= " + ((bvg)paramcfw.tVe.get(j)).tLY);
        j += 1;
      }
      return arrayOfInt;
    }
  }
  
  public static int aX(byte[] paramArrayOfByte)
  {
    int i = 0;
    int k;
    int m;
    for (int j = 0;; j = (m & 0xFF) << k * 8 | j)
    {
      k = i;
      if (k >= 4) {
        break;
      }
      m = paramArrayOfByte[k];
      i = k + 1;
    }
    return j;
  }
  
  public static int[] ap(LinkedList<cfk> paramLinkedList)
  {
    int[] arrayOfInt = new int[paramLinkedList.size() * 5];
    int i = 0;
    while (i < paramLinkedList.size())
    {
      arrayOfInt[(i * 5 + 0)] = ((ceb)((cfk)paramLinkedList.get(i)).tST.get(0)).tNg;
      arrayOfInt[(i * 5 + 1)] = ((ceb)((cfk)paramLinkedList.get(i)).tST.get(0)).tAA;
      arrayOfInt[(i * 5 + 2)] = ((ceb)((cfk)paramLinkedList.get(i)).tST.get(1)).tNg;
      arrayOfInt[(i * 5 + 3)] = ((ceb)((cfk)paramLinkedList.get(i)).tST.get(1)).tAA;
      arrayOfInt[(i * 5 + 4)] = ((ceb)((cfk)paramLinkedList.get(i)).tST.get(2)).tAA;
      i += 1;
    }
    return arrayOfInt;
  }
  
  public static void flushLogFile()
  {
    if (mOutputStream == null) {
      return;
    }
    try
    {
      mOutputStream.flush();
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.Voip", localException, "", new Object[0]);
    }
  }
  
  public static int getNetType(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null) {
        return 2;
      }
      y.i("MicroMsg.Voip", "getNetType: %s %s", new Object[] { Integer.valueOf(paramContext.getType()), Integer.valueOf(paramContext.getSubtype()) });
      if (paramContext.getType() == 1) {
        return 4;
      }
      if (paramContext.getType() != 0) {
        return 2;
      }
      if (paramContext.getSubtype() == 1) {
        return 1;
      }
      if (paramContext.getSubtype() == 2) {
        return 1;
      }
      if ((paramContext.getSubtype() != 13) && (paramContext.getSubtype() != 19))
      {
        if ((paramContext.getSubtype() < 3) || (paramContext.getSubtype() >= 13))
        {
          int i = paramContext.getSubtype();
          if (i <= 13) {}
        }
        else
        {
          return 3;
        }
        return 1;
      }
    }
    catch (NullPointerException paramContext)
    {
      y.printErrStackTrace("MicroMsg.Voip", paramContext, "", new Object[0]);
      return 2;
    }
    return 5;
  }
  
  public static void outputJniLog(byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (bk.bE(paramArrayOfByte)) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte = new String(arrayOfByte);
    if (paramInt == 4) {
      y.e(paramString, paramArrayOfByte);
    }
    while (!paramString.equals("MicroMsg.v2Core"))
    {
      writeLogToFile(paramString + ":" + paramArrayOfByte + " \n");
      return;
      if (paramInt == 2) {
        y.i(paramString, paramArrayOfByte);
      } else {
        y.d(paramString, paramArrayOfByte);
      }
    }
    writeLogToFile(paramString + ":" + paramArrayOfByte);
  }
  
  private static void writeLogToFile(String paramString)
  {
    if (mOutputStream == null) {
      return;
    }
    try
    {
      mOutputStream.write(paramString.getBytes());
      return;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.Voip", paramString, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.a.a
 * JD-Core Version:    0.7.0.1
 */