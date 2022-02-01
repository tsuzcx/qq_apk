package com.tencent.mm.plugin.voip.f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.systemservicecache.NetworkCache;
import java.io.BufferedOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

public final class g
{
  private static int JMX = 0;
  private static long UGt = 0L;
  public static boolean ULJ = false;
  private static long ULK;
  static BufferedOutputStream mOutputStream = null;
  
  static
  {
    ULK = 0L;
  }
  
  public static void Logd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(115514);
    Log.d(paramString1, "[" + Thread.currentThread().getId() + "]" + paramString2);
    writeLogToFile(paramString1 + ":" + paramString2 + " \n");
    AppMethodBeat.o(115514);
  }
  
  public static void Loge(String paramString1, String paramString2)
  {
    AppMethodBeat.i(115512);
    Log.e(paramString1, "[" + Thread.currentThread().getId() + "]" + paramString2);
    writeLogToFile(paramString1 + ":" + paramString2 + " \n");
    AppMethodBeat.o(115512);
  }
  
  public static void Logi(String paramString1, String paramString2)
  {
    AppMethodBeat.i(115513);
    Log.i(paramString1, "[" + Thread.currentThread().getId() + "]" + paramString2);
    writeLogToFile(paramString1 + ":" + paramString2 + " \n");
    AppMethodBeat.o(115513);
  }
  
  public static void Logw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(115515);
    Log.w(paramString1, "[" + Thread.currentThread().getId() + "]" + paramString2);
    writeLogToFile(paramString1 + ":" + paramString2 + " \n");
    AppMethodBeat.o(115515);
  }
  
  private static int a(NetworkInfo paramNetworkInfo)
  {
    int i = 4;
    AppMethodBeat.i(292528);
    if (paramNetworkInfo == null)
    {
      AppMethodBeat.o(292528);
      return 2;
    }
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.VoipHelper", "getNetType: %s %s", new Object[] { Integer.valueOf(paramNetworkInfo.getType()), Integer.valueOf(paramNetworkInfo.getSubtype()) });
        int j = paramNetworkInfo.getType();
        if (j == 1)
        {
          AppMethodBeat.o(292528);
          return 4;
        }
        j = paramNetworkInfo.getType();
        if (j == 9)
        {
          AppMethodBeat.o(292528);
          return 7;
        }
        j = paramNetworkInfo.getType();
        if (j != 0)
        {
          AppMethodBeat.o(292528);
          return 2;
        }
        j = paramNetworkInfo.getSubtype();
        switch (j)
        {
        case 0: 
          Log.i("MicroMsg.VoipHelper", "NEWEST type, use wifi as default!");
          Log.i("MicroMsg.VoipHelper", "steve: subType:%s, getMobileType(2G/3G/4G/...): %s ", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          AppMethodBeat.o(292528);
          return i;
        }
      }
      catch (NullPointerException paramNetworkInfo)
      {
        Log.printErrStackTrace("MicroMsg.VoipHelper", paramNetworkInfo, "", new Object[0]);
        AppMethodBeat.o(292528);
        return 2;
      }
      i = 2;
      continue;
      i = 1;
      continue;
      i = 3;
      continue;
      i = 5;
      continue;
      i = 6;
    }
  }
  
  public static void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(115522);
    Log.i("MicroMsg.VoipHelper", "before convert, beforeNetType:%s, afterNetType:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt5) });
    paramInt2 = arc(paramInt2);
    paramInt3 = arc(paramInt3);
    Log.i("MicroMsg.VoipHelper", "after convert, beforeNetType:%s, afterNetType:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt5) });
    h.OAn.a(16519, true, true, new Object[] { Long.valueOf(SubCoreVoip.hVp().hWC()), Integer.valueOf(SubCoreVoip.hVp().hYr()), Long.valueOf(SubCoreVoip.hVp().hVw()), Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6) });
    Log.i("MicroMsg.VoipHelper", "reportVoipNetChangeCost is memberIdx =" + paramInt1 + "|switchNetworkTimestamp " + paramLong + "|beforeNetType " + paramInt2 + "|afterNetType" + paramInt3 + "|beforeNetStrength" + paramInt4 + "|afterNetStrength" + paramInt5 + "|avgNetStrength" + paramInt6);
    AppMethodBeat.o(115522);
  }
  
  public static int aJE(String paramString)
  {
    AppMethodBeat.i(115519);
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
        Log.d("MicroMsg.VoipHelper", "ipAddressStrToInt, ip: %s, result: %d", new Object[] { paramString, Integer.valueOf(j) });
        AppMethodBeat.o(115519);
        return j;
      }
    }
    catch (UnknownHostException paramString)
    {
      Log.printErrStackTrace("MicroMsg.VoipHelper", paramString, "", new Object[0]);
      AppMethodBeat.o(115519);
    }
    return 0;
  }
  
  public static void ara(int paramInt)
  {
    AppMethodBeat.i(115517);
    long l = paramInt;
    try
    {
      Thread.sleep(l);
      AppMethodBeat.o(115517);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Log.printErrStackTrace("MicroMsg.VoipHelper", localInterruptedException, "", new Object[0]);
      AppMethodBeat.o(115517);
    }
  }
  
  public static void arb(int paramInt)
  {
    int i3 = 2;
    AppMethodBeat.i(115521);
    int j;
    int i;
    label32:
    h localh;
    int i4;
    long l1;
    long l2;
    int k;
    label69:
    int m;
    label78:
    int n;
    label87:
    int i1;
    if (d.rb(26)) {
      if (com.tencent.mm.k.b.aQT())
      {
        j = 1;
        if (!com.tencent.mm.k.b.aQU()) {
          break label238;
        }
        i = 1;
        localh = h.OAn;
        i4 = SubCoreVoip.hVp().hYr();
        l1 = SubCoreVoip.hVp().hVw();
        l2 = SubCoreVoip.hVp().hWC();
        if (!a.isActive()) {
          break label280;
        }
        k = 1;
        if (!com.tencent.mm.k.b.aQF()) {
          break label285;
        }
        m = 1;
        if (!com.tencent.mm.k.b.aQH()) {
          break label291;
        }
        n = 1;
        if (!com.tencent.mm.k.b.aQK()) {
          break label297;
        }
        i1 = 1;
        label96:
        if (!com.tencent.mm.k.b.aQM()) {
          break label303;
        }
      }
    }
    label271:
    label280:
    label285:
    label291:
    label297:
    label303:
    for (int i2 = 1;; i2 = 2)
    {
      if (com.tencent.mm.k.b.aQO()) {
        i3 = 1;
      }
      localh.a(16366, true, true, new Object[] { Integer.valueOf(i4), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(paramInt) });
      AppMethodBeat.o(115521);
      return;
      j = 2;
      break;
      label238:
      i = 2;
      break label32;
      if (com.tencent.mm.k.b.aQL()) {}
      for (i = 1;; i = 2)
      {
        if (!com.tencent.mm.k.b.aQN()) {
          break label271;
        }
        k = 1;
        j = i;
        i = k;
        break;
      }
      k = 2;
      j = i;
      i = k;
      break label32;
      k = 2;
      break label69;
      m = 2;
      break label78;
      n = 2;
      break label87;
      i1 = 2;
      break label96;
    }
  }
  
  private static int arc(int paramInt)
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
    case 5: 
      return 3;
    }
    return 6;
  }
  
  public static int bfN(String paramString)
  {
    AppMethodBeat.i(292594);
    int i = MultiProcessMMKV.getMMKV("static_cap_mmkv_key").getInt(paramString, 0);
    AppMethodBeat.o(292594);
    return i;
  }
  
  public static void c(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(115520);
    if ((SubCoreVoip.hVp().hYr() != 0) && (SubCoreVoip.hVp().hVw() != 0L))
    {
      ULK = SubCoreVoip.hVp().hWC();
      JMX = paramInt1;
      UGt = paramLong;
    }
    h.OAn.a(16516, true, true, new Object[] { Long.valueOf(ULK), Integer.valueOf(JMX), Long.valueOf(UGt), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Log.i("MicroMsg.VoipHelper", "room type " + ULK + "room id" + JMX + "room key" + UGt + "call type " + paramInt2 + "type " + paramInt3);
    AppMethodBeat.o(115520);
  }
  
  public static int cI(byte[] paramArrayOfByte)
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
  
  public static void flushLogFile()
  {
    AppMethodBeat.i(115511);
    if (mOutputStream == null)
    {
      AppMethodBeat.o(115511);
      return;
    }
    try
    {
      mOutputStream.flush();
      AppMethodBeat.o(115511);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.VoipHelper", localException, "", new Object[0]);
      AppMethodBeat.o(115511);
    }
  }
  
  public static void hA(String paramString, int paramInt)
  {
    AppMethodBeat.i(292580);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("static_cap_mmkv_key");
    localMultiProcessMMKV.putInt(paramString, paramInt);
    localMultiProcessMMKV.apply();
    AppMethodBeat.o(292580);
  }
  
  public static int ibq()
  {
    AppMethodBeat.i(292541);
    int i = a(((ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity")).getActiveNetworkInfo());
    AppMethodBeat.o(292541);
    return i;
  }
  
  public static int ibr()
  {
    AppMethodBeat.i(292552);
    int i = a(NetworkCache.INSTANCE.getActiveNetworkInfoFromCache(MMApplicationContext.getContext()));
    AppMethodBeat.o(292552);
    return i;
  }
  
  public static int ibs()
  {
    AppMethodBeat.i(292567);
    if (!com.tencent.mm.pluginsdk.permission.b.s(MMApplicationContext.getContext(), "android.permission.READ_PHONE_STATE"))
    {
      AppMethodBeat.o(292567);
      return 0;
    }
    for (;;)
    {
      try
      {
        TelephonyManager localTelephonyManager = (TelephonyManager)MMApplicationContext.getContext().getSystemService("phone");
        if (Build.VERSION.SDK_INT < 24) {
          continue;
        }
        int j = localTelephonyManager.getDataNetworkType();
        switch (j)
        {
        case 0: 
          Log.i("MicroMsg.VoipHelper", "ratioType:%s, getMobileType(2G/3G/4G/...): %s ", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          AppMethodBeat.o(292567);
          return i;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.VoipHelper", localException, "", new Object[0]);
        AppMethodBeat.o(292567);
        return 0;
      }
      int i = 0;
      continue;
      i = 1;
      continue;
      i = 3;
      continue;
      i = 5;
      continue;
      i = 6;
      continue;
      i = 0;
    }
  }
  
  public static void ibt() {}
  
  public static byte[] int2bytes(int paramInt)
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
  
  public static void outputJniLog(byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    AppMethodBeat.i(115516);
    byte[] arrayOfByte = paramArrayOfByte;
    if (Util.isNullOrNil(paramArrayOfByte)) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte = new String(arrayOfByte);
    if (paramInt == 4) {
      Log.e(paramString, paramArrayOfByte);
    }
    while (!paramString.equals("MicroMsg.v2Core"))
    {
      writeLogToFile(paramString + ":" + paramArrayOfByte + " \n");
      AppMethodBeat.o(115516);
      return;
      if (paramInt == 2) {
        Log.i(paramString, paramArrayOfByte);
      } else {
        Log.d(paramString, paramArrayOfByte);
      }
    }
    writeLogToFile(paramString + ":" + paramArrayOfByte);
    AppMethodBeat.o(115516);
  }
  
  private static void writeLogToFile(String paramString)
  {
    AppMethodBeat.i(115510);
    if (mOutputStream == null)
    {
      AppMethodBeat.o(115510);
      return;
    }
    try
    {
      mOutputStream.write(paramString.getBytes());
      AppMethodBeat.o(115510);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.VoipHelper", paramString, "", new Object[0]);
      AppMethodBeat.o(115510);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.f.g
 * JD-Core Version:    0.7.0.1
 */