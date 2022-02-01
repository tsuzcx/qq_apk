package com.tencent.mm.plugin.secinforeport;

import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.f.a.st;
import com.tencent.mm.f.a.su;
import com.tencent.mm.f.a.sz;
import com.tencent.mm.f.a.ta;
import com.tencent.mm.f.a.tc;
import com.tencent.mm.normsg.c.p;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.aav;
import com.tencent.mm.protocal.protobuf.ae;
import com.tencent.mm.protocal.protobuf.dct;
import com.tencent.mm.protocal.protobuf.dcu;
import com.tencent.mm.protocal.protobuf.dwv;
import com.tencent.mm.protocal.protobuf.dww;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.fgr;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.zip.Deflater;

 enum c
  implements com.tencent.mm.plugin.secinforeport.a.c
{
  static
  {
    AppMethodBeat.i(89181);
    Jce = new c("INSTANCE");
    Jcf = new c[] { Jce };
    AppMethodBeat.o(89181);
  }
  
  private c() {}
  
  private static byte[] ac(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(89179);
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new IllegalArgumentException("dataIn is null.");
      AppMethodBeat.o(89179);
      throw paramArrayOfByte;
    }
    Deflater localDeflater = new Deflater();
    localDeflater.setLevel(9);
    localDeflater.setInput(paramArrayOfByte, 0, paramInt);
    paramArrayOfByte = new ByteArrayOutputStream(paramInt);
    localDeflater.finish();
    byte[] arrayOfByte = new byte[4096];
    while (!localDeflater.finished()) {
      paramArrayOfByte.write(arrayOfByte, 0, localDeflater.deflate(arrayOfByte));
    }
    localDeflater.end();
    try
    {
      paramArrayOfByte.close();
      paramArrayOfByte = paramArrayOfByte.toByteArray();
      AppMethodBeat.o(89179);
      return paramArrayOfByte;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.SecInfoReporterImpl", localIOException, "exception when compressing dump maps", new Object[0]);
      }
    }
  }
  
  public final boolean aS(int paramInt, long paramLong)
  {
    AppMethodBeat.i(89174);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(new StringBuilder("atadtsurt_").reverse().toString());
    long l1 = localMultiProcessMMKV.getLong(String.format("%s", new Object[] { Integer.valueOf(paramInt) }), 0L);
    long l2 = System.currentTimeMillis();
    boolean bool;
    if ((l1 == 0L) || (l2 < l1))
    {
      localMultiProcessMMKV.putLong(String.format("%s", new Object[] { Integer.valueOf(paramInt) }), l2).apply();
      if (l1 == 0L) {
        bool = true;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.SecInfoReporterImpl", "[+] isTimeToReport2 called, res: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(89174);
      return bool;
      bool = false;
      continue;
      if (l2 - l1 > paramLong)
      {
        localMultiProcessMMKV.putLong(String.format("%s", new Object[] { Integer.valueOf(paramInt) }), l2).apply();
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public final void aT(Intent paramIntent)
  {
    AppMethodBeat.i(249930);
    if (paramIntent == null)
    {
      AppMethodBeat.o(249930);
      return;
    }
    try
    {
      fgr localfgr = new fgr();
      eae localeae = new eae();
      if (paramIntent == null) {}
      for (paramIntent = new byte[0];; paramIntent = c.p.am(paramIntent))
      {
        localfgr.UGX = localeae.dc(paramIntent);
        s(540999696, localfgr.toByteArray());
        AppMethodBeat.o(249930);
        return;
      }
      return;
    }
    catch (Throwable paramIntent)
    {
      Log.w("MicroMsg.SecInfoReporterImpl", "report app info error + " + paramIntent.toString());
      AppMethodBeat.o(249930);
    }
  }
  
  public final boolean aT(int paramInt, long paramLong)
  {
    AppMethodBeat.i(249911);
    boolean bool = a.aT(paramInt, paramLong);
    Log.i("MicroMsg.SecInfoReporterImpl", "[+] isTimeToReportForRoutine called, res: %s, cycleTag:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt) });
    AppMethodBeat.o(249911);
    return bool;
  }
  
  public final void aeg(int paramInt)
  {
    AppMethodBeat.i(249912);
    byte[] arrayOfByte = c.p.aa(62, 0);
    if (arrayOfByte != null) {}
    try
    {
      fgr localfgr = new fgr();
      localfgr.UGO = new eae().dc(arrayOfByte);
      Log.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] ccd data len = %d ctx=%d in finder", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(paramInt) }));
      s(paramInt, localfgr.toByteArray());
      label77:
      Log.i("MicroMsg.SecInfoReporterImpl", "[+] report finder through cgi, type: sec");
      AppMethodBeat.o(249912);
      return;
      Log.e("MicroMsg.SecInfoReporterImpl", "[-] data is null.");
      AppMethodBeat.o(249912);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label77;
    }
  }
  
  public final void aeh(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(89178);
    new StringBuilder();
    Object localObject1 = new ae();
    ((ae)localObject1).rWh = Build.MANUFACTURER;
    ((ae)localObject1).rVH = Build.MODEL;
    ((ae)localObject1).REe = Build.VERSION.RELEASE;
    ((ae)localObject1).REf = Build.VERSION.INCREMENTAL;
    ((ae)localObject1).REg = Build.DISPLAY;
    Object localObject2;
    if (paramInt == -2147483646)
    {
      ((ae)localObject1).REh = Build.FINGERPRINT;
      localObject2 = com.tencent.mm.plugin.normsg.a.d.GxJ.vJ(false);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = ((String)localObject2).split(",");
        if (localObject2 != null)
        {
          int j = localObject2.length;
          while (i < j)
          {
            Object localObject3 = localObject2[i];
            ((ae)localObject1).REi.add(localObject3);
            i += 1;
          }
        }
      }
    }
    try
    {
      localObject2 = ((ae)localObject1).toByteArray();
      localObject1 = new aav();
      ((aav)localObject1).Sng = new com.tencent.mm.cd.b("".getBytes());
      ((aav)localObject1).type = 1;
      localObject2 = ac((byte[])localObject2, localObject2.length);
      if (localObject2 == null)
      {
        ((aav)localObject1).Snh = new com.tencent.mm.cd.b("compress data failed".getBytes());
        ((aav)localObject1).dataType = 1;
        ((aav)localObject1).timestamp = (System.currentTimeMillis() / 1000L);
      }
      for (((aav)localObject1).status = 1;; ((aav)localObject1).status = 0)
      {
        localObject2 = new fgr();
        ((fgr)localObject2).UGQ = new eae().dc(((aav)localObject1).toByteArray());
        localObject1 = ((fgr)localObject2).toByteArray();
        Log.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] report di info msg: len = %d \n", new Object[] { Integer.valueOf(localObject1.length) }));
        s(paramInt, (byte[])localObject1);
        AppMethodBeat.o(89178);
        return;
        if (localObject2.length > 5120)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(633L, 4L, 1L, false);
          Log.d("MicroMsg.SecInfoReporterImpl", "compressed and base64 result is still too large with length " + localObject2.length);
        }
        ((aav)localObject1).Snh = new com.tencent.mm.cd.b((byte[])localObject2);
        ((aav)localObject1).dataType = 4;
        ((aav)localObject1).timestamp = (System.currentTimeMillis() / 1000L);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(89178);
    }
  }
  
  public final void asyncReportNewInstallAppThroughCgi(Intent paramIntent)
  {
    AppMethodBeat.i(249923);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {}
    for (int i = 10; !a.js(8, i); i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vZJ, 10))
    {
      AppMethodBeat.o(249923);
      return;
    }
    sz localsz = new sz();
    localsz.fSr.intent = paramIntent;
    EventCenter.instance.publish(localsz);
    AppMethodBeat.o(249923);
  }
  
  public final void asyncReportPaySecurityInfoThroughCgi()
  {
    AppMethodBeat.i(89176);
    EventCenter.instance.publish(new su());
    AppMethodBeat.o(89176);
  }
  
  public final void asyncReportSensorSceneInfoThroughCgi(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(249918);
    if ((Util.isNullOrNil(paramString)) || (Util.isNullOrNil(paramArrayOfByte)))
    {
      AppMethodBeat.o(249918);
      return;
    }
    ta localta = new ta();
    localta.fSs.buffer = paramArrayOfByte;
    localta.fSs.fSt = paramString;
    EventCenter.instance.publish(localta);
    AppMethodBeat.o(249918);
  }
  
  public final void asyncReportTuringOwnerThroughCgi(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(249920);
    if (Util.isNullOrNil(paramArrayOfByte))
    {
      AppMethodBeat.o(249920);
      return;
    }
    tc localtc = new tc();
    localtc.fSw.buffer = paramArrayOfByte;
    EventCenter.instance.publish(localtc);
    AppMethodBeat.o(249920);
  }
  
  public final void cq(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(249927);
    if (Util.isNullOrNil(paramArrayOfByte))
    {
      Log.w("MicroMsg.SecInfoReporterImpl", "[-] turingOwnerData is null.");
      AppMethodBeat.o(249927);
      return;
    }
    try
    {
      aav localaav = new aav();
      localaav.Sng = new com.tencent.mm.cd.b("".getBytes());
      localaav.type = 1;
      localaav.Snh = new com.tencent.mm.cd.b(paramArrayOfByte);
      localaav.dataType = 2;
      localaav.timestamp = (System.currentTimeMillis() / 1000L);
      localaav.status = 0;
      fgr localfgr = new fgr();
      localfgr.UGV = new eae().dc(localaav.toByteArray());
      s(0, localfgr.toByteArray());
      Log.i("MicroMsg.SecInfoReporterImpl", "[+] report turing owner through cgi, len: %d, type: sec", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
      AppMethodBeat.o(249927);
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      Log.e("MicroMsg.SecInfoReporterImpl", "[-] report turing owner error");
      AppMethodBeat.o(249927);
    }
  }
  
  public final void fFu()
  {
    AppMethodBeat.i(89175);
    byte[] arrayOfByte = c.p.aa(40, 0);
    if (arrayOfByte != null) {}
    try
    {
      fgr localfgr = new fgr();
      localfgr.UGO = new eae().dc(arrayOfByte);
      Log.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] ccd data len = %d in yap", new Object[] { Integer.valueOf(arrayOfByte.length) }));
      s(540999683, localfgr.toByteArray());
      label74:
      Log.i("MicroMsg.SecInfoReporterImpl", "[+] report yap through cgi, type: sec");
      AppMethodBeat.o(89175);
      return;
      Log.e("MicroMsg.SecInfoReporterImpl", "[-] data is null.");
      AppMethodBeat.o(89175);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label74;
    }
  }
  
  public final void jq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(249916);
    if (paramInt2 != 0)
    {
      boolean bool = a.js(paramInt2, 1);
      Log.i("MicroMsg.SecInfoReporterImpl", "[+] isTimeToReport called, res: %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(249916);
        return;
      }
    }
    st localst = new st();
    localst.fSf.fSg = paramInt1;
    EventCenter.instance.publish(localst);
    AppMethodBeat.o(249916);
  }
  
  public final void jr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89177);
    byte[] arrayOfByte1 = c.p.aa(paramInt2, 0);
    byte[] arrayOfByte2 = com.tencent.mm.plugin.normsg.a.d.GxJ.fjo();
    if (arrayOfByte1 != null) {
      for (;;)
      {
        try
        {
          fgr localfgr = new fgr();
          if (arrayOfByte2 == null) {
            continue;
          }
          aav localaav = new aav();
          localaav.Sng = new com.tencent.mm.cd.b("".getBytes());
          localaav.type = 1;
          localaav.Snh = new com.tencent.mm.cd.b(arrayOfByte2);
          localaav.dataType = 2;
          localaav.timestamp = (System.currentTimeMillis() / 1000L);
          localaav.status = 0;
          arrayOfByte2 = localaav.toByteArray();
          Log.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] tur ccd data len = %d", new Object[] { Integer.valueOf(arrayOfByte2.length) }));
          localfgr.UGR = new eae().dc(arrayOfByte2);
          localfgr.UGO = new eae().dc(arrayOfByte1);
          Log.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] ccd data len = %d", new Object[] { Integer.valueOf(arrayOfByte1.length) }));
          s(paramInt1, localfgr.toByteArray());
        }
        catch (Throwable localThrowable)
        {
          continue;
        }
        Log.i("MicroMsg.SecInfoReporterImpl", "[+] report through cgi, type: sec, ctx: %s", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(89177);
        return;
        Log.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] tur ccd data is null ", new Object[0]));
      }
    }
    Log.e("MicroMsg.SecInfoReporterImpl", "[-] data is null.");
    AppMethodBeat.o(89177);
  }
  
  public final void s(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89180);
    if (paramArrayOfByte == null)
    {
      Log.e("MicroMsg.SecInfoReporterImpl", "data is null.");
      AppMethodBeat.o(89180);
      return;
    }
    Object localObject = new d.a();
    ((d.a)localObject).uri = com.tencent.mm.plugin.normsg.a.d.GxJ.aTf("");
    ((d.a)localObject).funcId = 771;
    ((d.a)localObject).lBU = new dwv();
    ((d.a)localObject).lBV = new dww();
    localObject = ((d.a)localObject).bgN();
    dwv localdwv = (dwv)d.b.b(((com.tencent.mm.an.d)localObject).lBR);
    localdwv.fSg = paramInt;
    localdwv.UcE = new com.tencent.mm.cd.b("".getBytes());
    localdwv.RMN = new eae().dc(paramArrayOfByte);
    f.Iyx.idkeyStat(416L, 0L, 1L, false);
    aa.a((com.tencent.mm.an.d)localObject, new c.1(this, paramInt), false);
    AppMethodBeat.o(89180);
  }
  
  public final void z(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(249925);
    if ((Util.isNullOrNil(paramString)) || (Util.isNullOrNil(paramArrayOfByte)))
    {
      Log.e("MicroMsg.SecInfoReporterImpl", "[-] behaviorID or data is null.");
      AppMethodBeat.o(249925);
      return;
    }
    try
    {
      fgr localfgr = new fgr();
      localfgr.UGT = new eae().dc(paramString.getBytes());
      localfgr.UGU = new eae().dc(paramArrayOfByte);
      s(540999687, localfgr.toByteArray());
      Log.i("MicroMsg.SecInfoReporterImpl", "[+] report sensor scene info through cgi, len: %d, type: sec", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
      AppMethodBeat.o(249925);
      return;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(249925);
    }
  }
  
  static final class a
  {
    private static final Map<Integer, Long> Jch;
    private static dct Jci;
    
    static
    {
      AppMethodBeat.i(89170);
      Jch = new HashMap();
      Jci = null;
      AppMethodBeat.o(89170);
    }
    
    /* Error */
    static boolean aT(int paramInt, long paramLong)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore 5
      //   3: ldc 2
      //   5: monitorenter
      //   6: ldc 39
      //   8: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   11: lload_1
      //   12: lconst_0
      //   13: lcmp
      //   14: ifgt +32 -> 46
      //   17: ldc 41
      //   19: ldc 43
      //   21: iconst_1
      //   22: anewarray 4	java/lang/Object
      //   25: dup
      //   26: iconst_0
      //   27: lload_1
      //   28: invokestatic 49	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   31: aastore
      //   32: invokestatic 55	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   35: ldc 39
      //   37: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   40: ldc 2
      //   42: monitorexit
      //   43: iload 5
      //   45: ireturn
      //   46: getstatic 32	com/tencent/mm/plugin/secinforeport/c$a:Jci	Lcom/tencent/mm/protocal/protobuf/dct;
      //   49: ifnonnull +6 -> 55
      //   52: invokestatic 58	com/tencent/mm/plugin/secinforeport/c$a:tA	()V
      //   55: iload_0
      //   56: invokestatic 62	com/tencent/mm/plugin/secinforeport/c$a:aei	(I)Lcom/tencent/mm/protocal/protobuf/dcu;
      //   59: astore 7
      //   61: aload 7
      //   63: astore 6
      //   65: aload 7
      //   67: ifnonnull +36 -> 103
      //   70: new 64	com/tencent/mm/protocal/protobuf/dcu
      //   73: dup
      //   74: invokespecial 65	com/tencent/mm/protocal/protobuf/dcu:<init>	()V
      //   77: astore 6
      //   79: aload 6
      //   81: iload_0
      //   82: putfield 69	com/tencent/mm/protocal/protobuf/dcu:TKF	I
      //   85: aload 6
      //   87: lconst_0
      //   88: putfield 73	com/tencent/mm/protocal/protobuf/dcu:lastReportTime	J
      //   91: getstatic 32	com/tencent/mm/plugin/secinforeport/c$a:Jci	Lcom/tencent/mm/protocal/protobuf/dct;
      //   94: getfield 79	com/tencent/mm/protocal/protobuf/dct:TKE	Ljava/util/LinkedList;
      //   97: aload 6
      //   99: invokevirtual 85	java/util/LinkedList:add	(Ljava/lang/Object;)Z
      //   102: pop
      //   103: invokestatic 91	java/lang/System:currentTimeMillis	()J
      //   106: lstore_3
      //   107: lload_3
      //   108: aload 6
      //   110: getfield 73	com/tencent/mm/protocal/protobuf/dcu:lastReportTime	J
      //   113: lcmp
      //   114: iflt +15 -> 129
      //   117: lload_3
      //   118: aload 6
      //   120: getfield 73	com/tencent/mm/protocal/protobuf/dcu:lastReportTime	J
      //   123: lsub
      //   124: lload_1
      //   125: lcmp
      //   126: ifle +29 -> 155
      //   129: aload 6
      //   131: lload_3
      //   132: putfield 73	com/tencent/mm/protocal/protobuf/dcu:lastReportTime	J
      //   135: aload 6
      //   137: iconst_1
      //   138: putfield 94	com/tencent/mm/protocal/protobuf/dcu:TKG	I
      //   141: invokestatic 97	com/tencent/mm/plugin/secinforeport/c$a:arg	()V
      //   144: ldc 39
      //   146: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   149: iconst_1
      //   150: istore 5
      //   152: goto -112 -> 40
      //   155: ldc 39
      //   157: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   160: goto -120 -> 40
      //   163: astore 6
      //   165: ldc 2
      //   167: monitorexit
      //   168: aload 6
      //   170: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	171	0	paramInt	int
      //   0	171	1	paramLong	long
      //   106	26	3	l	long
      //   1	150	5	bool	boolean
      //   63	73	6	localdcu1	dcu
      //   163	6	6	localObject	Object
      //   59	7	7	localdcu2	dcu
      // Exception table:
      //   from	to	target	type
      //   6	11	163	finally
      //   17	40	163	finally
      //   46	55	163	finally
      //   55	61	163	finally
      //   70	103	163	finally
      //   103	129	163	finally
      //   129	149	163	finally
      //   155	160	163	finally
    }
    
    private static dcu aei(int paramInt)
    {
      AppMethodBeat.i(249845);
      if (Jci == null)
      {
        AppMethodBeat.o(249845);
        return null;
      }
      Iterator localIterator = Jci.TKE.iterator();
      while (localIterator.hasNext())
      {
        dcu localdcu = (dcu)localIterator.next();
        if (localdcu.TKF == paramInt)
        {
          AppMethodBeat.o(249845);
          return localdcu;
        }
      }
      AppMethodBeat.o(249845);
      return null;
    }
    
    /* Error */
    private static void arg()
    {
      // Byte code:
      //   0: ldc 2
      //   2: monitorenter
      //   3: ldc 115
      //   5: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: new 117	com/tencent/mm/vfs/q
      //   11: dup
      //   12: invokestatic 123	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
      //   15: getfield 129	com/tencent/mm/kernel/f:cachePath	Ljava/lang/String;
      //   18: getstatic 135	com/tencent/mm/plugin/normsg/a/d:GxJ	Lcom/tencent/mm/plugin/normsg/a/d;
      //   21: ldc 137
      //   23: invokevirtual 141	com/tencent/mm/plugin/normsg/a/d:aTf	(Ljava/lang/String;)Ljava/lang/String;
      //   26: invokespecial 144	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   29: astore_0
      //   30: aload_0
      //   31: invokevirtual 147	com/tencent/mm/vfs/q:ifE	()Z
      //   34: ifne +11 -> 45
      //   37: aload_0
      //   38: invokevirtual 151	com/tencent/mm/vfs/q:ifB	()Lcom/tencent/mm/vfs/q;
      //   41: invokevirtual 154	com/tencent/mm/vfs/q:ifL	()Z
      //   44: pop
      //   45: new 156	java/io/DataOutputStream
      //   48: dup
      //   49: aload_0
      //   50: invokestatic 162	com/tencent/mm/vfs/u:an	(Lcom/tencent/mm/vfs/q;)Ljava/io/OutputStream;
      //   53: invokespecial 165	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   56: astore_1
      //   57: aload_1
      //   58: astore_0
      //   59: getstatic 32	com/tencent/mm/plugin/secinforeport/c$a:Jci	Lcom/tencent/mm/protocal/protobuf/dct;
      //   62: ifnull +15 -> 77
      //   65: aload_1
      //   66: astore_0
      //   67: aload_1
      //   68: getstatic 32	com/tencent/mm/plugin/secinforeport/c$a:Jci	Lcom/tencent/mm/protocal/protobuf/dct;
      //   71: invokevirtual 169	com/tencent/mm/protocal/protobuf/dct:toByteArray	()[B
      //   74: invokevirtual 173	java/io/DataOutputStream:write	([B)V
      //   77: aload_1
      //   78: astore_0
      //   79: ldc 41
      //   81: ldc 175
      //   83: invokestatic 177	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   86: aload_1
      //   87: invokevirtual 180	java/io/DataOutputStream:close	()V
      //   90: ldc 115
      //   92: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   95: ldc 2
      //   97: monitorexit
      //   98: return
      //   99: astore_0
      //   100: ldc 115
      //   102: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   105: goto -10 -> 95
      //   108: astore_0
      //   109: ldc 2
      //   111: monitorexit
      //   112: aload_0
      //   113: athrow
      //   114: astore_0
      //   115: aconst_null
      //   116: astore_1
      //   117: aload_1
      //   118: astore_0
      //   119: ldc 41
      //   121: ldc 182
      //   123: invokestatic 185	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   126: aload_1
      //   127: ifnull +42 -> 169
      //   130: aload_1
      //   131: invokevirtual 180	java/io/DataOutputStream:close	()V
      //   134: ldc 115
      //   136: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   139: goto -44 -> 95
      //   142: astore_0
      //   143: ldc 115
      //   145: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   148: goto -53 -> 95
      //   151: astore_0
      //   152: aconst_null
      //   153: astore_1
      //   154: aload_1
      //   155: ifnull +7 -> 162
      //   158: aload_1
      //   159: invokevirtual 180	java/io/DataOutputStream:close	()V
      //   162: ldc 115
      //   164: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   167: aload_0
      //   168: athrow
      //   169: ldc 115
      //   171: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   174: goto -79 -> 95
      //   177: astore_1
      //   178: goto -16 -> 162
      //   181: astore_1
      //   182: aload_0
      //   183: astore_2
      //   184: aload_1
      //   185: astore_0
      //   186: aload_2
      //   187: astore_1
      //   188: goto -34 -> 154
      //   191: astore_0
      //   192: goto -75 -> 117
      // Local variable table:
      //   start	length	slot	name	signature
      //   29	50	0	localObject1	Object
      //   99	1	0	localException1	Exception
      //   108	5	0	localObject2	Object
      //   114	1	0	localException2	Exception
      //   118	1	0	localObject3	Object
      //   142	1	0	localException3	Exception
      //   151	32	0	localObject4	Object
      //   185	1	0	localObject5	Object
      //   191	1	0	localException4	Exception
      //   56	103	1	localDataOutputStream	java.io.DataOutputStream
      //   177	1	1	localException5	Exception
      //   181	4	1	localObject6	Object
      //   187	1	1	localObject7	Object
      //   183	4	2	localObject8	Object
      // Exception table:
      //   from	to	target	type
      //   86	90	99	java/lang/Exception
      //   3	45	108	finally
      //   86	90	108	finally
      //   90	95	108	finally
      //   100	105	108	finally
      //   130	134	108	finally
      //   134	139	108	finally
      //   143	148	108	finally
      //   158	162	108	finally
      //   162	169	108	finally
      //   169	174	108	finally
      //   45	57	114	java/lang/Exception
      //   130	134	142	java/lang/Exception
      //   45	57	151	finally
      //   158	162	177	java/lang/Exception
      //   59	65	181	finally
      //   67	77	181	finally
      //   79	86	181	finally
      //   119	126	181	finally
      //   59	65	191	java/lang/Exception
      //   67	77	191	java/lang/Exception
      //   79	86	191	java/lang/Exception
    }
    
    /* Error */
    private static dct fFv()
    {
      // Byte code:
      //   0: ldc 2
      //   2: monitorenter
      //   3: ldc 188
      //   5: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: new 75	com/tencent/mm/protocal/protobuf/dct
      //   11: dup
      //   12: invokespecial 189	com/tencent/mm/protocal/protobuf/dct:<init>	()V
      //   15: astore 4
      //   17: new 117	com/tencent/mm/vfs/q
      //   20: dup
      //   21: invokestatic 123	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
      //   24: getfield 129	com/tencent/mm/kernel/f:cachePath	Ljava/lang/String;
      //   27: getstatic 135	com/tencent/mm/plugin/normsg/a/d:GxJ	Lcom/tencent/mm/plugin/normsg/a/d;
      //   30: ldc 137
      //   32: invokevirtual 141	com/tencent/mm/plugin/normsg/a/d:aTf	(Ljava/lang/String;)Ljava/lang/String;
      //   35: invokespecial 144	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   38: astore_1
      //   39: aload_1
      //   40: invokevirtual 192	com/tencent/mm/vfs/q:length	()J
      //   43: l2i
      //   44: istore_0
      //   45: iload_0
      //   46: ifne +14 -> 60
      //   49: ldc 188
      //   51: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   54: ldc 2
      //   56: monitorexit
      //   57: aload 4
      //   59: areturn
      //   60: iload_0
      //   61: newarray byte
      //   63: astore_3
      //   64: new 194	java/io/DataInputStream
      //   67: dup
      //   68: aload_1
      //   69: invokestatic 198	com/tencent/mm/vfs/u:al	(Lcom/tencent/mm/vfs/q;)Ljava/io/InputStream;
      //   72: invokespecial 201	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
      //   75: astore_2
      //   76: aload_2
      //   77: astore_1
      //   78: aload_2
      //   79: aload_3
      //   80: invokevirtual 205	java/io/DataInputStream:read	([B)I
      //   83: pop
      //   84: aload_2
      //   85: invokevirtual 206	java/io/DataInputStream:close	()V
      //   88: aload 4
      //   90: aload_3
      //   91: invokevirtual 210	com/tencent/mm/protocal/protobuf/dct:parseFrom	([B)Lcom/tencent/mm/cd/a;
      //   94: pop
      //   95: ldc 41
      //   97: ldc 212
      //   99: invokestatic 177	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   102: ldc 188
      //   104: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   107: goto -53 -> 54
      //   110: astore_1
      //   111: ldc 2
      //   113: monitorexit
      //   114: aload_1
      //   115: athrow
      //   116: astore_3
      //   117: aconst_null
      //   118: astore_2
      //   119: aload_2
      //   120: astore_1
      //   121: ldc 41
      //   123: ldc 214
      //   125: iconst_1
      //   126: anewarray 4	java/lang/Object
      //   129: dup
      //   130: iconst_0
      //   131: aload_3
      //   132: aastore
      //   133: invokestatic 216	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   136: aload_2
      //   137: ifnull +7 -> 144
      //   140: aload_2
      //   141: invokevirtual 206	java/io/DataInputStream:close	()V
      //   144: ldc 188
      //   146: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   149: goto -95 -> 54
      //   152: astore_2
      //   153: aconst_null
      //   154: astore_1
      //   155: aload_1
      //   156: ifnull +7 -> 163
      //   159: aload_1
      //   160: invokevirtual 206	java/io/DataInputStream:close	()V
      //   163: ldc 188
      //   165: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   168: aload_2
      //   169: athrow
      //   170: astore_1
      //   171: new 9	com/tencent/mm/plugin/secinforeport/c$a$a
      //   174: dup
      //   175: invokespecial 217	com/tencent/mm/plugin/secinforeport/c$a$a:<init>	()V
      //   178: astore_1
      //   179: ldc 188
      //   181: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   184: aload_1
      //   185: athrow
      //   186: astore_1
      //   187: goto -99 -> 88
      //   190: astore_1
      //   191: goto -47 -> 144
      //   194: astore_1
      //   195: goto -32 -> 163
      //   198: astore_2
      //   199: goto -44 -> 155
      //   202: astore_3
      //   203: goto -84 -> 119
      // Local variable table:
      //   start	length	slot	name	signature
      //   44	17	0	i	int
      //   38	40	1	localObject1	Object
      //   110	5	1	localObject2	Object
      //   120	40	1	localObject3	Object
      //   170	1	1	localException1	Exception
      //   178	7	1	locala	a
      //   186	1	1	localException2	Exception
      //   190	1	1	localException3	Exception
      //   194	1	1	localException4	Exception
      //   75	66	2	localDataInputStream	java.io.DataInputStream
      //   152	17	2	localObject4	Object
      //   198	1	2	localObject5	Object
      //   63	28	3	arrayOfByte	byte[]
      //   116	16	3	localException5	Exception
      //   202	1	3	localException6	Exception
      //   15	74	4	localdct	dct
      // Exception table:
      //   from	to	target	type
      //   3	45	110	finally
      //   49	54	110	finally
      //   60	64	110	finally
      //   84	88	110	finally
      //   88	95	110	finally
      //   95	107	110	finally
      //   140	144	110	finally
      //   144	149	110	finally
      //   159	163	110	finally
      //   163	170	110	finally
      //   171	186	110	finally
      //   64	76	116	java/lang/Exception
      //   64	76	152	finally
      //   88	95	170	java/lang/Exception
      //   84	88	186	java/lang/Exception
      //   140	144	190	java/lang/Exception
      //   159	163	194	java/lang/Exception
      //   78	84	198	finally
      //   121	136	198	finally
      //   78	84	202	java/lang/Exception
    }
    
    /* Error */
    private static dct fFw()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_0
      //   2: ldc 2
      //   4: monitorenter
      //   5: ldc 219
      //   7: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   10: new 75	com/tencent/mm/protocal/protobuf/dct
      //   13: dup
      //   14: invokespecial 189	com/tencent/mm/protocal/protobuf/dct:<init>	()V
      //   17: astore 8
      //   19: new 117	com/tencent/mm/vfs/q
      //   22: dup
      //   23: invokestatic 123	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
      //   26: getfield 129	com/tencent/mm/kernel/f:cachePath	Ljava/lang/String;
      //   29: getstatic 135	com/tencent/mm/plugin/normsg/a/d:GxJ	Lcom/tencent/mm/plugin/normsg/a/d;
      //   32: ldc 137
      //   34: invokevirtual 141	com/tencent/mm/plugin/normsg/a/d:aTf	(Ljava/lang/String;)Ljava/lang/String;
      //   37: invokespecial 144	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   40: astore 5
      //   42: new 194	java/io/DataInputStream
      //   45: dup
      //   46: aload 5
      //   48: invokestatic 198	com/tencent/mm/vfs/u:al	(Lcom/tencent/mm/vfs/q;)Ljava/io/InputStream;
      //   51: invokespecial 201	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
      //   54: astore 6
      //   56: aload 6
      //   58: astore 5
      //   60: aload 6
      //   62: invokevirtual 223	java/io/DataInputStream:readShort	()S
      //   65: sipush -774
      //   68: if_icmpeq +77 -> 145
      //   71: aload 6
      //   73: astore 5
      //   75: new 225	java/lang/IllegalStateException
      //   78: dup
      //   79: ldc 227
      //   81: invokespecial 230	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
      //   84: astore 7
      //   86: aload 6
      //   88: astore 5
      //   90: ldc 219
      //   92: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   95: aload 6
      //   97: astore 5
      //   99: aload 7
      //   101: athrow
      //   102: astore 7
      //   104: aload 6
      //   106: astore 5
      //   108: ldc 41
      //   110: ldc 232
      //   112: iconst_1
      //   113: anewarray 4	java/lang/Object
      //   116: dup
      //   117: iconst_0
      //   118: aload 7
      //   120: aastore
      //   121: invokestatic 216	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   124: aload 6
      //   126: ifnull +8 -> 134
      //   129: aload 6
      //   131: invokevirtual 206	java/io/DataInputStream:close	()V
      //   134: ldc 219
      //   136: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   139: ldc 2
      //   141: monitorexit
      //   142: aload 8
      //   144: areturn
      //   145: aload 6
      //   147: astore 5
      //   149: aload 6
      //   151: invokevirtual 223	java/io/DataInputStream:readShort	()S
      //   154: pop
      //   155: aload 6
      //   157: astore 5
      //   159: aload 6
      //   161: invokevirtual 236	java/io/DataInputStream:readInt	()I
      //   164: istore_1
      //   165: iload_1
      //   166: ifge +70 -> 236
      //   169: aload 6
      //   171: astore 5
      //   173: new 225	java/lang/IllegalStateException
      //   176: dup
      //   177: ldc 238
      //   179: invokespecial 230	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
      //   182: astore 7
      //   184: aload 6
      //   186: astore 5
      //   188: ldc 219
      //   190: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   193: aload 6
      //   195: astore 5
      //   197: aload 7
      //   199: athrow
      //   200: astore 7
      //   202: aload 5
      //   204: astore 6
      //   206: aload 7
      //   208: astore 5
      //   210: aload 6
      //   212: ifnull +8 -> 220
      //   215: aload 6
      //   217: invokevirtual 206	java/io/DataInputStream:close	()V
      //   220: ldc 219
      //   222: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   225: aload 5
      //   227: athrow
      //   228: astore 5
      //   230: ldc 2
      //   232: monitorexit
      //   233: aload 5
      //   235: athrow
      //   236: iload_0
      //   237: iload_1
      //   238: if_icmpge +88 -> 326
      //   241: aload 6
      //   243: astore 5
      //   245: aload 6
      //   247: invokevirtual 236	java/io/DataInputStream:readInt	()I
      //   250: istore_2
      //   251: aload 6
      //   253: astore 5
      //   255: aload 6
      //   257: invokevirtual 241	java/io/DataInputStream:readLong	()J
      //   260: lstore_3
      //   261: aload 6
      //   263: astore 5
      //   265: new 64	com/tencent/mm/protocal/protobuf/dcu
      //   268: dup
      //   269: invokespecial 65	com/tencent/mm/protocal/protobuf/dcu:<init>	()V
      //   272: astore 7
      //   274: aload 6
      //   276: astore 5
      //   278: aload 7
      //   280: iload_2
      //   281: putfield 69	com/tencent/mm/protocal/protobuf/dcu:TKF	I
      //   284: aload 6
      //   286: astore 5
      //   288: aload 7
      //   290: lload_3
      //   291: putfield 73	com/tencent/mm/protocal/protobuf/dcu:lastReportTime	J
      //   294: aload 6
      //   296: astore 5
      //   298: aload 7
      //   300: iconst_1
      //   301: putfield 94	com/tencent/mm/protocal/protobuf/dcu:TKG	I
      //   304: aload 6
      //   306: astore 5
      //   308: aload 8
      //   310: getfield 79	com/tencent/mm/protocal/protobuf/dct:TKE	Ljava/util/LinkedList;
      //   313: aload 7
      //   315: invokevirtual 85	java/util/LinkedList:add	(Ljava/lang/Object;)Z
      //   318: pop
      //   319: iload_0
      //   320: iconst_1
      //   321: iadd
      //   322: istore_0
      //   323: goto -87 -> 236
      //   326: aload 6
      //   328: astore 5
      //   330: ldc 41
      //   332: ldc 212
      //   334: invokestatic 177	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   337: aload 6
      //   339: invokevirtual 206	java/io/DataInputStream:close	()V
      //   342: goto -208 -> 134
      //   345: astore 5
      //   347: goto -213 -> 134
      //   350: astore 5
      //   352: goto -218 -> 134
      //   355: astore 6
      //   357: goto -137 -> 220
      //   360: astore 5
      //   362: aconst_null
      //   363: astore 6
      //   365: goto -155 -> 210
      //   368: astore 7
      //   370: aconst_null
      //   371: astore 6
      //   373: goto -269 -> 104
      // Local variable table:
      //   start	length	slot	name	signature
      //   1	322	0	i	int
      //   164	75	1	j	int
      //   250	31	2	k	int
      //   260	31	3	l	long
      //   40	186	5	localObject1	Object
      //   228	6	5	localObject2	Object
      //   243	86	5	localObject3	Object
      //   345	1	5	localException1	Exception
      //   350	1	5	localException2	Exception
      //   360	1	5	localObject4	Object
      //   54	284	6	localObject5	Object
      //   355	1	6	localException3	Exception
      //   363	9	6	localObject6	Object
      //   84	16	7	localIllegalStateException1	java.lang.IllegalStateException
      //   102	17	7	localException4	Exception
      //   182	16	7	localIllegalStateException2	java.lang.IllegalStateException
      //   200	7	7	localObject7	Object
      //   272	42	7	localdcu	dcu
      //   368	1	7	localException5	Exception
      //   17	292	8	localdct	dct
      // Exception table:
      //   from	to	target	type
      //   60	71	102	java/lang/Exception
      //   75	86	102	java/lang/Exception
      //   90	95	102	java/lang/Exception
      //   99	102	102	java/lang/Exception
      //   149	155	102	java/lang/Exception
      //   159	165	102	java/lang/Exception
      //   173	184	102	java/lang/Exception
      //   188	193	102	java/lang/Exception
      //   197	200	102	java/lang/Exception
      //   245	251	102	java/lang/Exception
      //   255	261	102	java/lang/Exception
      //   265	274	102	java/lang/Exception
      //   278	284	102	java/lang/Exception
      //   288	294	102	java/lang/Exception
      //   298	304	102	java/lang/Exception
      //   308	319	102	java/lang/Exception
      //   330	337	102	java/lang/Exception
      //   60	71	200	finally
      //   75	86	200	finally
      //   90	95	200	finally
      //   99	102	200	finally
      //   108	124	200	finally
      //   149	155	200	finally
      //   159	165	200	finally
      //   173	184	200	finally
      //   188	193	200	finally
      //   197	200	200	finally
      //   245	251	200	finally
      //   255	261	200	finally
      //   265	274	200	finally
      //   278	284	200	finally
      //   288	294	200	finally
      //   298	304	200	finally
      //   308	319	200	finally
      //   330	337	200	finally
      //   5	42	228	finally
      //   129	134	228	finally
      //   134	139	228	finally
      //   215	220	228	finally
      //   220	228	228	finally
      //   337	342	228	finally
      //   337	342	345	java/lang/Exception
      //   129	134	350	java/lang/Exception
      //   215	220	355	java/lang/Exception
      //   42	56	360	finally
      //   42	56	368	java/lang/Exception
    }
    
    static boolean js(int paramInt1, int paramInt2)
    {
      boolean bool = true;
      for (;;)
      {
        long l;
        try
        {
          AppMethodBeat.i(249842);
          if ((86400000L <= 0L) || (paramInt2 <= 0))
          {
            Log.w("MicroMsg.SecInfoReporterImpl", "bad interval: %s, %s", new Object[] { Long.valueOf(86400000L), Integer.valueOf(paramInt2) });
            AppMethodBeat.o(249842);
            bool = false;
            return bool;
          }
          if (Jci == null) {
            tA();
          }
          dcu localdcu2 = aei(paramInt1);
          dcu localdcu1 = localdcu2;
          if (localdcu2 == null)
          {
            localdcu1 = new dcu();
            localdcu1.TKF = paramInt1;
            localdcu1.lastReportTime = 0L;
            Jci.TKE.add(localdcu1);
          }
          l = System.currentTimeMillis();
          if ((l < localdcu1.lastReportTime) || (l / 86400000L != localdcu1.lastReportTime / 86400000L))
          {
            localdcu1.lastReportTime = l;
            localdcu1.TKG = 1;
            arg();
            AppMethodBeat.o(249842);
            continue;
          }
          if (localObject.TKG >= paramInt2) {
            break label219;
          }
        }
        finally {}
        localObject.lastReportTime = l;
        localObject.TKG += 1;
        arg();
        AppMethodBeat.o(249842);
        continue;
        label219:
        AppMethodBeat.o(249842);
        bool = false;
      }
    }
    
    /* Error */
    private static void tA()
    {
      // Byte code:
      //   0: ldc 2
      //   2: monitorenter
      //   3: ldc 254
      //   5: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: getstatic 32	com/tencent/mm/plugin/secinforeport/c$a:Jci	Lcom/tencent/mm/protocal/protobuf/dct;
      //   11: ifnull +12 -> 23
      //   14: ldc 254
      //   16: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   19: ldc 2
      //   21: monitorexit
      //   22: return
      //   23: invokestatic 256	com/tencent/mm/plugin/secinforeport/c$a:fFv	()Lcom/tencent/mm/protocal/protobuf/dct;
      //   26: putstatic 32	com/tencent/mm/plugin/secinforeport/c$a:Jci	Lcom/tencent/mm/protocal/protobuf/dct;
      //   29: ldc 254
      //   31: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   34: goto -15 -> 19
      //   37: astore_0
      //   38: ldc 2
      //   40: monitorexit
      //   41: aload_0
      //   42: athrow
      //   43: astore_0
      //   44: invokestatic 258	com/tencent/mm/plugin/secinforeport/c$a:fFw	()Lcom/tencent/mm/protocal/protobuf/dct;
      //   47: putstatic 32	com/tencent/mm/plugin/secinforeport/c$a:Jci	Lcom/tencent/mm/protocal/protobuf/dct;
      //   50: ldc 254
      //   52: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   55: goto -36 -> 19
      //   58: astore_0
      //   59: new 75	com/tencent/mm/protocal/protobuf/dct
      //   62: dup
      //   63: invokespecial 189	com/tencent/mm/protocal/protobuf/dct:<init>	()V
      //   66: putstatic 32	com/tencent/mm/plugin/secinforeport/c$a:Jci	Lcom/tencent/mm/protocal/protobuf/dct;
      //   69: ldc 41
      //   71: ldc 214
      //   73: iconst_1
      //   74: anewarray 4	java/lang/Object
      //   77: dup
      //   78: iconst_0
      //   79: aload_0
      //   80: aastore
      //   81: invokestatic 216	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   84: ldc 254
      //   86: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   89: goto -70 -> 19
      // Local variable table:
      //   start	length	slot	name	signature
      //   37	5	0	localObject	Object
      //   43	1	0	locala	a
      //   58	22	0	localException	Exception
      // Exception table:
      //   from	to	target	type
      //   3	19	37	finally
      //   23	29	37	finally
      //   29	34	37	finally
      //   44	55	37	finally
      //   59	89	37	finally
      //   23	29	43	com/tencent/mm/plugin/secinforeport/c$a$a
      //   23	29	58	java/lang/Exception
    }
    
    static final class a
      extends Exception
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.c
 * JD-Core Version:    0.7.0.1
 */