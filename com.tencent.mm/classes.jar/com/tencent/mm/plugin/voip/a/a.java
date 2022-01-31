package com.tencent.mm.plugin.voip.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.protocal.protobuf.cfz;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.crn;
import com.tencent.mm.protocal.protobuf.csv;
import com.tencent.mm.protocal.protobuf.cth;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.BufferedOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedList;

public final class a
{
  static BufferedOutputStream mOutputStream;
  private static int nTj = 0;
  public static boolean tFf = false;
  private static long tFg;
  private static long tFh = 0L;
  
  static
  {
    mOutputStream = null;
    tFg = 0L;
  }
  
  public static byte[] HI(int paramInt)
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
  
  public static void HJ(int paramInt)
  {
    AppMethodBeat.i(4991);
    long l = paramInt;
    try
    {
      Thread.sleep(l);
      AppMethodBeat.o(4991);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      ab.printErrStackTrace("MicroMsg.VoipHelper", localInterruptedException, "", new Object[0]);
      AppMethodBeat.o(4991);
    }
  }
  
  private static String HK(int paramInt)
  {
    AppMethodBeat.i(4995);
    try
    {
      String str = InetAddress.getByAddress(new byte[] { (byte)(paramInt >>> 24 & 0xFF), (byte)(paramInt >>> 16 & 0xFF), (byte)(paramInt >>> 8 & 0xFF), (byte)(paramInt & 0xFF) }).getHostAddress();
      AppMethodBeat.o(4995);
      return str;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.VoipHelper", localException, "", new Object[0]);
      AppMethodBeat.o(4995);
    }
    return null;
  }
  
  public static void HL(int paramInt)
  {
    int i3 = 2;
    AppMethodBeat.i(4998);
    int j;
    int i;
    label33:
    h localh;
    int i4;
    long l1;
    long l2;
    int k;
    label70:
    int m;
    label79:
    int n;
    label88:
    int i1;
    if (com.tencent.luggage.g.b.fw(26)) {
      if (com.tencent.mm.m.a.MB())
      {
        j = 1;
        if (!com.tencent.mm.m.a.MD()) {
          break label240;
        }
        i = 1;
        localh = h.qsU;
        i4 = com.tencent.mm.plugin.voip.b.cLC().cNU();
        l1 = com.tencent.mm.plugin.voip.b.cLC().cNV();
        l2 = com.tencent.mm.plugin.voip.b.cLC().cMb();
        if (!com.tencent.mm.an.a.isActive()) {
          break label282;
        }
        k = 1;
        if (!com.tencent.mm.m.a.Mx()) {
          break label287;
        }
        m = 1;
        if (!com.tencent.mm.m.a.Mz()) {
          break label293;
        }
        n = 1;
        if (!com.tencent.mm.m.a.MA()) {
          break label299;
        }
        i1 = 1;
        label97:
        if (!com.tencent.mm.m.a.MC()) {
          break label305;
        }
      }
    }
    label273:
    label282:
    label287:
    label293:
    label299:
    label305:
    for (int i2 = 1;; i2 = 2)
    {
      if (com.tencent.mm.m.a.ME()) {
        i3 = 1;
      }
      localh.a(16366, true, true, new Object[] { Integer.valueOf(i4), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(paramInt) });
      AppMethodBeat.o(4998);
      return;
      j = 2;
      break;
      label240:
      i = 2;
      break label33;
      if (com.tencent.mm.m.a.MI()) {}
      for (i = 1;; i = 2)
      {
        if (!com.tencent.mm.m.a.MJ()) {
          break label273;
        }
        k = 1;
        j = i;
        i = k;
        break;
      }
      k = 2;
      j = i;
      i = k;
      break label33;
      k = 2;
      break label70;
      m = 2;
      break label79;
      n = 2;
      break label88;
      i1 = 2;
      break label97;
    }
  }
  
  private static int HM(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 2: 
      return 4;
    case 3: 
      return 2;
    case 4: 
      return 5;
    }
    return 3;
  }
  
  public static void Logd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(4988);
    ab.d(paramString1, "[" + Thread.currentThread().getId() + "]" + paramString2);
    writeLogToFile(paramString1 + ":" + paramString2 + " \n");
    AppMethodBeat.o(4988);
  }
  
  public static void Loge(String paramString1, String paramString2)
  {
    AppMethodBeat.i(4986);
    ab.e(paramString1, "[" + Thread.currentThread().getId() + "]" + paramString2);
    writeLogToFile(paramString1 + ":" + paramString2 + " \n");
    AppMethodBeat.o(4986);
  }
  
  public static void Logi(String paramString1, String paramString2)
  {
    AppMethodBeat.i(4987);
    ab.i(paramString1, "[" + Thread.currentThread().getId() + "]" + paramString2);
    writeLogToFile(paramString1 + ":" + paramString2 + " \n");
    AppMethodBeat.o(4987);
  }
  
  public static void Logw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(4989);
    ab.w(paramString1, "[" + Thread.currentThread().getId() + "]" + paramString2);
    writeLogToFile(paramString1 + ":" + paramString2 + " \n");
    AppMethodBeat.o(4989);
  }
  
  public static int RJ(String paramString)
  {
    AppMethodBeat.i(4996);
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
        ab.d("MicroMsg.VoipHelper", "ipAddressStrToInt, ip: %s, result: %d", new Object[] { paramString, Integer.valueOf(j) });
        AppMethodBeat.o(4996);
        return j;
      }
    }
    catch (UnknownHostException paramString)
    {
      ab.printErrStackTrace("MicroMsg.VoipHelper", paramString, "", new Object[0]);
      AppMethodBeat.o(4996);
    }
    return 0;
  }
  
  public static void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(4999);
    ab.i("MicroMsg.VoipHelper", "before convert, beforeNetType:%s, afterNetType:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt5) });
    paramInt2 = HM(paramInt2);
    paramInt3 = HM(paramInt3);
    ab.i("MicroMsg.VoipHelper", "after convert, beforeNetType:%s, afterNetType:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt5) });
    h.qsU.a(16519, true, true, new Object[] { Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().cMb()), Integer.valueOf(com.tencent.mm.plugin.voip.b.cLC().cNU()), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().cNV()), Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6) });
    ab.i("MicroMsg.VoipHelper", "reportVoipNetChangeCost is memberIdx =" + paramInt1 + "|switchNetworkTimestamp " + paramLong + "|beforeNetType " + paramInt2 + "|afterNetType" + paramInt3 + "|beforeNetStrength" + paramInt4 + "|afterNetStrength" + paramInt5 + "|avgNetStrength" + paramInt6);
    AppMethodBeat.o(4999);
  }
  
  public static int[] a(crn paramcrn)
  {
    AppMethodBeat.i(4992);
    ab.d("MicroMsg.VoipHelper", "convertSvrAddr: voipAddr.Cnt " + paramcrn.yak);
    if (3 >= paramcrn.yak) {}
    for (int i = paramcrn.yak;; i = 3)
    {
      ab.d("MicroMsg.VoipHelper", "convertSvrAddr: addrCnt ".concat(String.valueOf(i)));
      int[] arrayOfInt = new int[i * 2];
      int j = 0;
      while (j < i)
      {
        if (j < paramcrn.yal.size())
        {
          arrayOfInt[(j * 2)] = ((crm)paramcrn.yal.get(j)).xTC;
          arrayOfInt[(j * 2 + 1)] = ((crm)paramcrn.yal.get(j)).xCi;
          ab.d("MicroMsg.VoipHelper", "convertSvrAddr: ip " + HK(((crm)paramcrn.yal.get(j)).xTC) + " Port: " + ((crm)paramcrn.yal.get(j)).xCi);
        }
        j += 1;
      }
      AppMethodBeat.o(4992);
      return arrayOfInt;
    }
  }
  
  public static int[] a(cth paramcth)
  {
    AppMethodBeat.i(4994);
    ab.d("MicroMsg.VoipHelper", "convertSpeedTestPara: testID= " + paramcth.ycp + " SvrListCnt= " + paramcth.ycu);
    if (3 >= paramcth.ycu) {}
    for (int i = paramcth.ycu;; i = 3)
    {
      int[] arrayOfInt = new int[i * 6];
      int j = 0;
      while (j < i)
      {
        arrayOfInt[(j * 6)] = ((cfz)paramcth.ycv.get(j)).xQe.xTC;
        arrayOfInt[(j * 6 + 1)] = ((cfz)paramcth.ycv.get(j)).xQe.xCi;
        arrayOfInt[(j * 6 + 2)] = ((cfz)paramcth.ycv.get(j)).xQd;
        arrayOfInt[(j * 6 + 3)] = ((cfz)paramcth.ycv.get(j)).xQI;
        arrayOfInt[(j * 6 + 4)] = ((cfz)paramcth.ycv.get(j)).xQJ;
        arrayOfInt[(j * 6 + 5)] = ((cfz)paramcth.ycv.get(j)).xQK;
        ab.d("MicroMsg.VoipHelper", "convertSpeedTestPara: ip " + HK(((cfz)paramcth.ycv.get(j)).xQe.xTC) + " Port: " + ((cfz)paramcth.ycv.get(j)).xQe.xCi + " TestCnt= " + ((cfz)paramcth.ycv.get(j)).xQd + " TestGap= " + ((cfz)paramcth.ycv.get(j)).xQI + " Timeout= " + ((cfz)paramcth.ycv.get(j)).xQJ + " PktSize= " + ((cfz)paramcth.ycv.get(j)).xQK);
        j += 1;
      }
      AppMethodBeat.o(4994);
      return arrayOfInt;
    }
  }
  
  public static int[] ay(LinkedList<csv> paramLinkedList)
  {
    AppMethodBeat.i(4993);
    int[] arrayOfInt = new int[paramLinkedList.size() * 5];
    int i = 0;
    while (i < paramLinkedList.size())
    {
      arrayOfInt[(i * 5 + 0)] = ((crm)((csv)paramLinkedList.get(i)).yal.get(0)).xTC;
      arrayOfInt[(i * 5 + 1)] = ((crm)((csv)paramLinkedList.get(i)).yal.get(0)).xCi;
      arrayOfInt[(i * 5 + 2)] = ((crm)((csv)paramLinkedList.get(i)).yal.get(1)).xTC;
      arrayOfInt[(i * 5 + 3)] = ((crm)((csv)paramLinkedList.get(i)).yal.get(1)).xCi;
      arrayOfInt[(i * 5 + 4)] = ((crm)((csv)paramLinkedList.get(i)).yal.get(2)).xCi;
      i += 1;
    }
    AppMethodBeat.o(4993);
    return arrayOfInt;
  }
  
  public static int by(byte[] paramArrayOfByte)
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
  
  public static void c(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(4997);
    if ((com.tencent.mm.plugin.voip.b.cLC().cNU() != 0) && (com.tencent.mm.plugin.voip.b.cLC().cNV() != 0L))
    {
      tFg = com.tencent.mm.plugin.voip.b.cLC().cMb();
      nTj = paramInt1;
      tFh = paramLong;
    }
    h.qsU.a(16516, true, true, new Object[] { Long.valueOf(tFg), Integer.valueOf(nTj), Long.valueOf(tFh), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    ab.i("MicroMsg.VoipHelper", "room type " + tFg + "room id" + nTj + "room key" + tFh + "call type " + paramInt2 + "type " + paramInt3);
    AppMethodBeat.o(4997);
  }
  
  public static void cPq() {}
  
  public static void flushLogFile()
  {
    AppMethodBeat.i(4985);
    if (mOutputStream == null)
    {
      AppMethodBeat.o(4985);
      return;
    }
    try
    {
      mOutputStream.flush();
      AppMethodBeat.o(4985);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.VoipHelper", localException, "", new Object[0]);
      AppMethodBeat.o(4985);
    }
  }
  
  public static int getNetType(Context paramContext)
  {
    AppMethodBeat.i(4983);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(4983);
        return 2;
      }
      ab.i("MicroMsg.VoipHelper", "getNetType: %s %s", new Object[] { Integer.valueOf(paramContext.getType()), Integer.valueOf(paramContext.getSubtype()) });
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(4983);
        return 4;
      }
      i = paramContext.getType();
      if (i != 0)
      {
        AppMethodBeat.o(4983);
        return 2;
      }
      i = paramContext.getSubtype();
      if (i == 1)
      {
        AppMethodBeat.o(4983);
        return 1;
      }
      i = paramContext.getSubtype();
      if (i == 2)
      {
        AppMethodBeat.o(4983);
        return 1;
      }
      if (paramContext.getSubtype() != 13)
      {
        i = paramContext.getSubtype();
        if (i != 19) {}
      }
      else
      {
        AppMethodBeat.o(4983);
        return 5;
      }
      if ((paramContext.getSubtype() < 3) || (paramContext.getSubtype() >= 13))
      {
        i = paramContext.getSubtype();
        if (i <= 13) {}
      }
      else
      {
        AppMethodBeat.o(4983);
        return 3;
      }
      AppMethodBeat.o(4983);
      return 1;
    }
    catch (NullPointerException paramContext)
    {
      ab.printErrStackTrace("MicroMsg.VoipHelper", paramContext, "", new Object[0]);
      AppMethodBeat.o(4983);
    }
    return 2;
  }
  
  public static void outputJniLog(byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    AppMethodBeat.i(4990);
    byte[] arrayOfByte = paramArrayOfByte;
    if (bo.ce(paramArrayOfByte)) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte = new String(arrayOfByte);
    if (paramInt == 4) {
      ab.e(paramString, paramArrayOfByte);
    }
    while (!paramString.equals("MicroMsg.v2Core"))
    {
      writeLogToFile(paramString + ":" + paramArrayOfByte + " \n");
      AppMethodBeat.o(4990);
      return;
      if (paramInt == 2) {
        ab.i(paramString, paramArrayOfByte);
      } else {
        ab.d(paramString, paramArrayOfByte);
      }
    }
    writeLogToFile(paramString + ":" + paramArrayOfByte);
    AppMethodBeat.o(4990);
  }
  
  private static void writeLogToFile(String paramString)
  {
    AppMethodBeat.i(4984);
    if (mOutputStream == null)
    {
      AppMethodBeat.o(4984);
      return;
    }
    try
    {
      mOutputStream.write(paramString.getBytes());
      AppMethodBeat.o(4984);
      return;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.VoipHelper", paramString, "", new Object[0]);
      AppMethodBeat.o(4984);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.a.a
 * JD-Core Version:    0.7.0.1
 */