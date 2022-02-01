package com.tencent.mm.plugin.voip.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.BufferedOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

public final class f
{
  public static boolean CCS = false;
  private static long CCT;
  private static long CCU = 0L;
  static BufferedOutputStream mOutputStream = null;
  private static int vdk;
  
  static
  {
    CCT = 0L;
    vdk = 0;
  }
  
  public static void Logd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(115514);
    ae.d(paramString1, "[" + Thread.currentThread().getId() + "]" + paramString2);
    writeLogToFile(paramString1 + ":" + paramString2 + " \n");
    AppMethodBeat.o(115514);
  }
  
  public static void Loge(String paramString1, String paramString2)
  {
    AppMethodBeat.i(115512);
    ae.e(paramString1, "[" + Thread.currentThread().getId() + "]" + paramString2);
    writeLogToFile(paramString1 + ":" + paramString2 + " \n");
    AppMethodBeat.o(115512);
  }
  
  public static void Logi(String paramString1, String paramString2)
  {
    AppMethodBeat.i(115513);
    ae.i(paramString1, "[" + Thread.currentThread().getId() + "]" + paramString2);
    writeLogToFile(paramString1 + ":" + paramString2 + " \n");
    AppMethodBeat.o(115513);
  }
  
  public static void Logw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(115515);
    ae.w(paramString1, "[" + Thread.currentThread().getId() + "]" + paramString2);
    writeLogToFile(paramString1 + ":" + paramString2 + " \n");
    AppMethodBeat.o(115515);
  }
  
  public static byte[] Vj(int paramInt)
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
  
  public static void Vk(int paramInt)
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
      ae.printErrStackTrace("MicroMsg.VoipHelper", localInterruptedException, "", new Object[0]);
      AppMethodBeat.o(115517);
    }
  }
  
  public static void Vl(int paramInt)
  {
    int i3 = 2;
    AppMethodBeat.i(115521);
    int j;
    int i;
    label32:
    g localg;
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
    if (d.lC(28)) {
      if (com.tencent.mm.n.a.abU())
      {
        j = 1;
        if (!com.tencent.mm.n.a.abV()) {
          break label238;
        }
        i = 1;
        localg = g.yxI;
        i4 = c.eys().eBd();
        l1 = c.eys().eBe();
        l2 = c.eys().ezE();
        if (!com.tencent.mm.ap.a.isActive()) {
          break label309;
        }
        k = 1;
        if (!com.tencent.mm.n.a.abO()) {
          break label314;
        }
        m = 1;
        if (!com.tencent.mm.n.a.abQ()) {
          break label320;
        }
        n = 1;
        if (!com.tencent.mm.n.a.abR()) {
          break label326;
        }
        i1 = 1;
        label96:
        if (!com.tencent.mm.n.a.abT()) {
          break label332;
        }
      }
    }
    label275:
    label304:
    label309:
    label314:
    label320:
    label326:
    label332:
    for (int i2 = 1;; i2 = 2)
    {
      if (com.tencent.mm.n.a.abX()) {
        i3 = 1;
      }
      localg.a(16366, true, true, new Object[] { Integer.valueOf(i4), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(paramInt) });
      AppMethodBeat.o(115521);
      return;
      j = 2;
      break;
      label238:
      i = 2;
      break label32;
      if (d.lA(26))
      {
        if (com.tencent.mm.n.a.acb()) {}
        for (j = 1;; j = 2)
        {
          if (!com.tencent.mm.n.a.acc()) {
            break label275;
          }
          i = 1;
          break;
        }
        i = 2;
        break label32;
      }
      if (com.tencent.mm.n.a.abS()) {}
      for (j = 1;; j = 2)
      {
        if (!com.tencent.mm.n.a.abW()) {
          break label304;
        }
        i = 1;
        break;
      }
      i = 2;
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
  
  private static int Vm(int paramInt)
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
  
  public static void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(115522);
    ae.i("MicroMsg.VoipHelper", "before convert, beforeNetType:%s, afterNetType:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt5) });
    paramInt2 = Vm(paramInt2);
    paramInt3 = Vm(paramInt3);
    ae.i("MicroMsg.VoipHelper", "after convert, beforeNetType:%s, afterNetType:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt5) });
    g.yxI.a(16519, true, true, new Object[] { Long.valueOf(c.eys().ezE()), Integer.valueOf(c.eys().eBd()), Long.valueOf(c.eys().eBe()), Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6) });
    ae.i("MicroMsg.VoipHelper", "reportVoipNetChangeCost is memberIdx =" + paramInt1 + "|switchNetworkTimestamp " + paramLong + "|beforeNetType " + paramInt2 + "|afterNetType" + paramInt3 + "|beforeNetStrength" + paramInt4 + "|afterNetStrength" + paramInt5 + "|avgNetStrength" + paramInt6);
    AppMethodBeat.o(115522);
  }
  
  public static int apk(String paramString)
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
        ae.d("MicroMsg.VoipHelper", "ipAddressStrToInt, ip: %s, result: %d", new Object[] { paramString, Integer.valueOf(j) });
        AppMethodBeat.o(115519);
        return j;
      }
    }
    catch (UnknownHostException paramString)
    {
      ae.printErrStackTrace("MicroMsg.VoipHelper", paramString, "", new Object[0]);
      AppMethodBeat.o(115519);
    }
    return 0;
  }
  
  public static int bY(byte[] paramArrayOfByte)
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
    AppMethodBeat.i(115520);
    if ((c.eys().eBd() != 0) && (c.eys().eBe() != 0L))
    {
      CCT = c.eys().ezE();
      vdk = paramInt1;
      CCU = paramLong;
    }
    g.yxI.a(16516, true, true, new Object[] { Long.valueOf(CCT), Integer.valueOf(vdk), Long.valueOf(CCU), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    ae.i("MicroMsg.VoipHelper", "room type " + CCT + "room id" + vdk + "room key" + CCU + "call type " + paramInt2 + "type " + paramInt3);
    AppMethodBeat.o(115520);
  }
  
  public static void eDl() {}
  
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
      ae.printErrStackTrace("MicroMsg.VoipHelper", localException, "", new Object[0]);
      AppMethodBeat.o(115511);
    }
  }
  
  public static int getNetType(Context paramContext)
  {
    AppMethodBeat.i(115509);
    for (;;)
    {
      try
      {
        paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (paramContext == null)
        {
          AppMethodBeat.o(115509);
          return 2;
        }
        ae.i("MicroMsg.VoipHelper", "getNetType: %s %s", new Object[] { Integer.valueOf(paramContext.getType()), Integer.valueOf(paramContext.getSubtype()) });
        i = paramContext.getType();
        if (i == 1)
        {
          AppMethodBeat.o(115509);
          return 4;
        }
        i = paramContext.getType();
        if (i != 0)
        {
          AppMethodBeat.o(115509);
          return 2;
        }
        int j = paramContext.getSubtype();
        switch (j)
        {
        case 0: 
          ae.i("MicroMsg.VoipHelper", "NEWEST type, use wifi as default!");
          i = 4;
          ae.i("MicroMsg.VoipHelper", "steve: subType:%s, getMobileType(2G/3G/4G/...): %s ", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          AppMethodBeat.o(115509);
          return i;
        }
      }
      catch (NullPointerException paramContext)
      {
        int i;
        ae.printErrStackTrace("MicroMsg.VoipHelper", paramContext, "", new Object[0]);
        AppMethodBeat.o(115509);
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
      i = 5;
    }
  }
  
  public static void outputJniLog(byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    AppMethodBeat.i(115516);
    byte[] arrayOfByte = paramArrayOfByte;
    if (bu.cF(paramArrayOfByte)) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte = new String(arrayOfByte);
    if (paramInt == 4) {
      ae.e(paramString, paramArrayOfByte);
    }
    while (!paramString.equals("MicroMsg.v2Core"))
    {
      writeLogToFile(paramString + ":" + paramArrayOfByte + " \n");
      AppMethodBeat.o(115516);
      return;
      if (paramInt == 2) {
        ae.i(paramString, paramArrayOfByte);
      } else {
        ae.d(paramString, paramArrayOfByte);
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
      ae.printErrStackTrace("MicroMsg.VoipHelper", paramString, "", new Object[0]);
      AppMethodBeat.o(115510);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.f
 * JD-Core Version:    0.7.0.1
 */