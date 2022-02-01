package com.tencent.mm.plugin.secinforeport;

import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.z;
import com.tencent.mm.autogen.a.ui;
import com.tencent.mm.autogen.a.uj;
import com.tencent.mm.autogen.a.uo;
import com.tencent.mm.autogen.a.up;
import com.tencent.mm.autogen.a.ur;
import com.tencent.mm.bx.b;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.normsg.c.p;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.acv;
import com.tencent.mm.protocal.protobuf.ae;
import com.tencent.mm.protocal.protobuf.dum;
import com.tencent.mm.protocal.protobuf.dun;
import com.tencent.mm.protocal.protobuf.epz;
import com.tencent.mm.protocal.protobuf.eqa;
import com.tencent.mm.protocal.protobuf.gdd;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
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
    PlT = new c("INSTANCE");
    PlU = new c[] { PlT };
    AppMethodBeat.o(89181);
  }
  
  private c() {}
  
  private static byte[] ad(byte[] paramArrayOfByte, int paramInt)
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
  
  public final void C(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(262015);
    if ((Util.isNullOrNil(paramString)) || (Util.isNullOrNil(paramArrayOfByte)))
    {
      Log.e("MicroMsg.SecInfoReporterImpl", "[-] behaviorID or data is null.");
      AppMethodBeat.o(262015);
      return;
    }
    try
    {
      gdd localgdd = new gdd();
      localgdd.acbc = new gol().df(paramString.getBytes());
      localgdd.acbd = new gol().df(paramArrayOfByte);
      t(540999687, localgdd.toByteArray());
      Log.i("MicroMsg.SecInfoReporterImpl", "[+] report sensor scene info through cgi, len: %d, type: sec", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
      return;
    }
    finally
    {
      AppMethodBeat.o(262015);
    }
  }
  
  /* Error */
  public final boolean aZ(int paramInt, long paramLong)
  {
    // Byte code:
    //   0: ldc 177
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: new 179	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 181
    //   13: invokespecial 182	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: invokevirtual 186	java/lang/StringBuilder:reverse	()Ljava/lang/StringBuilder;
    //   19: new 179	java/lang/StringBuilder
    //   22: dup
    //   23: ldc 188
    //   25: invokespecial 182	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   28: invokevirtual 186	java/lang/StringBuilder:reverse	()Ljava/lang/StringBuilder;
    //   31: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 202	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   43: astore 9
    //   45: aload 9
    //   47: ldc 204
    //   49: iconst_1
    //   50: anewarray 98	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: iload_1
    //   56: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   59: aastore
    //   60: invokestatic 208	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   63: lconst_0
    //   64: invokevirtual 212	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getLong	(Ljava/lang/String;J)J
    //   67: lstore 4
    //   69: invokestatic 218	java/lang/System:currentTimeMillis	()J
    //   72: lstore 6
    //   74: lload 4
    //   76: lconst_0
    //   77: lcmp
    //   78: ifeq +11 -> 89
    //   81: lload 6
    //   83: lload 4
    //   85: lcmp
    //   86: ifge +76 -> 162
    //   89: aload 9
    //   91: ldc 204
    //   93: iconst_1
    //   94: anewarray 98	java/lang/Object
    //   97: dup
    //   98: iconst_0
    //   99: iload_1
    //   100: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   103: aastore
    //   104: invokestatic 208	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   107: lload 6
    //   109: invokevirtual 222	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   112: invokeinterface 227 1 0
    //   117: lload 4
    //   119: lconst_0
    //   120: lcmp
    //   121: ifne +35 -> 156
    //   124: iconst_1
    //   125: istore 8
    //   127: ldc 94
    //   129: ldc 229
    //   131: iconst_1
    //   132: anewarray 98	java/lang/Object
    //   135: dup
    //   136: iconst_0
    //   137: iload 8
    //   139: invokestatic 234	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   142: aastore
    //   143: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: aload_0
    //   147: monitorexit
    //   148: ldc 177
    //   150: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: iload 8
    //   155: ireturn
    //   156: iconst_0
    //   157: istore 8
    //   159: goto -32 -> 127
    //   162: lload 6
    //   164: lload 4
    //   166: lsub
    //   167: lload_2
    //   168: lcmp
    //   169: ifle +37 -> 206
    //   172: aload 9
    //   174: ldc 204
    //   176: iconst_1
    //   177: anewarray 98	java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: iload_1
    //   183: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   186: aastore
    //   187: invokestatic 208	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   190: lload 6
    //   192: invokevirtual 222	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   195: invokeinterface 227 1 0
    //   200: iconst_1
    //   201: istore 8
    //   203: goto -76 -> 127
    //   206: iconst_0
    //   207: istore 8
    //   209: goto -82 -> 127
    //   212: astore 9
    //   214: aload_0
    //   215: monitorexit
    //   216: ldc 177
    //   218: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: aload 9
    //   223: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	c
    //   0	224	1	paramInt	int
    //   0	224	2	paramLong	long
    //   67	98	4	l1	long
    //   72	119	6	l2	long
    //   125	83	8	bool	boolean
    //   43	130	9	localMultiProcessMMKV	com.tencent.mm.sdk.platformtools.MultiProcessMMKV
    //   212	10	9	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	74	212	finally
    //   89	117	212	finally
    //   127	148	212	finally
    //   172	200	212	finally
  }
  
  public final void aiL(int paramInt)
  {
    AppMethodBeat.i(262001);
    byte[] arrayOfByte = c.p.aa(560, 0);
    if (arrayOfByte != null) {}
    try
    {
      gdd localgdd = new gdd();
      localgdd.acaX = new gol().df(arrayOfByte);
      Log.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] ccd data len = %d ctx=%d in finder", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(paramInt) }));
      t(paramInt, localgdd.toByteArray());
      label78:
      Log.i("MicroMsg.SecInfoReporterImpl", "[+] report finder through cgi, type: sec");
      AppMethodBeat.o(262001);
      return;
      Log.e("MicroMsg.SecInfoReporterImpl", "[-] data is null.");
      AppMethodBeat.o(262001);
      return;
    }
    finally
    {
      break label78;
    }
  }
  
  public final void aiM(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(89178);
    new StringBuilder();
    Object localObject1 = new ae();
    ((ae)localObject1).vhx = Build.MANUFACTURER;
    ((ae)localObject1).vgX = q.aPo();
    ((ae)localObject1).YAH = Build.VERSION.RELEASE;
    ((ae)localObject1).YAI = Build.VERSION.INCREMENTAL;
    ((ae)localObject1).YAJ = Build.DISPLAY;
    Object localObject3;
    if (paramInt == -2147483646)
    {
      ((ae)localObject1).YAK = Build.FINGERPRINT;
      localObject3 = d.MtP.Af(false);
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject3 = ((String)localObject3).split(",");
        if (localObject3 != null)
        {
          int j = localObject3.length;
          while (i < j)
          {
            Object localObject4 = localObject3[i];
            ((ae)localObject1).YAL.add(localObject4);
            i += 1;
          }
        }
      }
    }
    try
    {
      localObject3 = ((ae)localObject1).toByteArray();
      localObject1 = new acv();
      ((acv)localObject1).Zls = new b("".getBytes());
      ((acv)localObject1).type = 1;
      localObject3 = ad((byte[])localObject3, localObject3.length);
      if (localObject3 == null)
      {
        ((acv)localObject1).Zlt = new b("compress data failed".getBytes());
        ((acv)localObject1).dataType = 1;
        ((acv)localObject1).timestamp = (System.currentTimeMillis() / 1000L);
      }
      for (((acv)localObject1).status = 1;; ((acv)localObject1).status = 0)
      {
        localObject3 = new gdd();
        ((gdd)localObject3).acaZ = new gol().df(((acv)localObject1).toByteArray());
        localObject1 = ((gdd)localObject3).toByteArray();
        Log.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] report di info msg: len = %d \n", new Object[] { Integer.valueOf(localObject1.length) }));
        t(paramInt, (byte[])localObject1);
        return;
        if (localObject3.length > 5120)
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(633L, 4L, 1L, false);
          Log.d("MicroMsg.SecInfoReporterImpl", "compressed and base64 result is still too large with length " + localObject3.length);
        }
        ((acv)localObject1).Zlt = new b((byte[])localObject3);
        ((acv)localObject1).dataType = 4;
        ((acv)localObject1).timestamp = (System.currentTimeMillis() / 1000L);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(89178);
    }
  }
  
  public final void asyncReportNewInstallAppThroughCgi(Intent paramIntent)
  {
    AppMethodBeat.i(262014);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {}
    for (int i = 10; !a.la(8, i); i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ztk, 10))
    {
      AppMethodBeat.o(262014);
      return;
    }
    uo localuo = new uo();
    localuo.hYo.intent = paramIntent;
    localuo.publish();
    AppMethodBeat.o(262014);
  }
  
  public final void asyncReportPaySecurityInfoThroughCgi()
  {
    AppMethodBeat.i(89176);
    new uj().publish();
    AppMethodBeat.o(89176);
  }
  
  public final void asyncReportSensorSceneInfoThroughCgi(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(262009);
    if ((Util.isNullOrNil(paramString)) || (Util.isNullOrNil(paramArrayOfByte)))
    {
      AppMethodBeat.o(262009);
      return;
    }
    up localup = new up();
    localup.hYp.buffer = paramArrayOfByte;
    localup.hYp.hYq = paramString;
    localup.publish();
    AppMethodBeat.o(262009);
  }
  
  public final void asyncReportTuringOwnerThroughCgi(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(262011);
    if (Util.isNullOrNil(paramArrayOfByte))
    {
      AppMethodBeat.o(262011);
      return;
    }
    ur localur = new ur();
    localur.hYt.buffer = paramArrayOfByte;
    localur.publish();
    AppMethodBeat.o(262011);
  }
  
  public final boolean ba(int paramInt, long paramLong)
  {
    AppMethodBeat.i(261995);
    boolean bool = a.ba(paramInt, paramLong);
    Log.i("MicroMsg.SecInfoReporterImpl", "[+] isTimeToReportForRoutine called, res: %s, cycleTag:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt) });
    AppMethodBeat.o(261995);
    return bool;
  }
  
  public final void br(Intent paramIntent)
  {
    AppMethodBeat.i(262021);
    if (paramIntent == null)
    {
      AppMethodBeat.o(262021);
      return;
    }
    try
    {
      gdd localgdd = new gdd();
      gol localgol = new gol();
      if (paramIntent == null) {}
      for (paramIntent = new byte[0];; paramIntent = c.p.am(paramIntent))
      {
        localgdd.acbg = localgol.df(paramIntent);
        t(540999696, localgdd.toByteArray());
        AppMethodBeat.o(262021);
        return;
      }
      return;
    }
    finally
    {
      Log.w("MicroMsg.SecInfoReporterImpl", "report app info error + " + paramIntent.toString());
      AppMethodBeat.o(262021);
    }
  }
  
  public final void cs(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(262018);
    if (Util.isNullOrNil(paramArrayOfByte))
    {
      Log.w("MicroMsg.SecInfoReporterImpl", "[-] turingOwnerData is null.");
      AppMethodBeat.o(262018);
      return;
    }
    try
    {
      acv localacv = new acv();
      localacv.Zls = new b("".getBytes());
      localacv.type = 1;
      localacv.Zlt = new b(paramArrayOfByte);
      localacv.dataType = 2;
      localacv.timestamp = (System.currentTimeMillis() / 1000L);
      localacv.status = 0;
      gdd localgdd = new gdd();
      localgdd.acbe = new gol().df(localacv.toByteArray());
      t(0, localgdd.toByteArray());
      Log.i("MicroMsg.SecInfoReporterImpl", "[+] report turing owner through cgi, len: %d, type: sec", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
      AppMethodBeat.o(262018);
      return;
    }
    finally
    {
      Log.e("MicroMsg.SecInfoReporterImpl", "[-] report turing owner error");
      AppMethodBeat.o(262018);
    }
  }
  
  public final void gUC()
  {
    AppMethodBeat.i(89175);
    byte[] arrayOfByte = c.p.aa(32, 0);
    if (arrayOfByte != null) {}
    try
    {
      gdd localgdd = new gdd();
      localgdd.acaX = new gol().df(arrayOfByte);
      Log.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] ccd data len = %d in yap", new Object[] { Integer.valueOf(arrayOfByte.length) }));
      t(540999683, localgdd.toByteArray());
      label74:
      Log.i("MicroMsg.SecInfoReporterImpl", "[+] report yap through cgi, type: sec");
      AppMethodBeat.o(89175);
      return;
      Log.e("MicroMsg.SecInfoReporterImpl", "[-] data is null.");
      AppMethodBeat.o(89175);
      return;
    }
    finally
    {
      break label74;
    }
  }
  
  public final void kY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(262006);
    if (paramInt2 != 0)
    {
      boolean bool = a.la(paramInt2, 1);
      Log.i("MicroMsg.SecInfoReporterImpl", "[+] isTimeToReport called, res: %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(262006);
        return;
      }
    }
    ui localui = new ui();
    localui.hYc.hYd = paramInt1;
    localui.publish();
    AppMethodBeat.o(262006);
  }
  
  public final void kZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89177);
    byte[] arrayOfByte1 = c.p.aa(paramInt2, 0);
    byte[] arrayOfByte2 = d.MtP.gtF();
    if (arrayOfByte1 != null) {
      for (;;)
      {
        try
        {
          gdd localgdd = new gdd();
          if (arrayOfByte2 == null) {
            continue;
          }
          acv localacv = new acv();
          localacv.Zls = new b("".getBytes());
          localacv.type = 1;
          localacv.Zlt = new b(arrayOfByte2);
          localacv.dataType = 2;
          localacv.timestamp = (System.currentTimeMillis() / 1000L);
          localacv.status = 0;
          arrayOfByte2 = localacv.toByteArray();
          Log.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] tur ccd data len = %d", new Object[] { Integer.valueOf(arrayOfByte2.length) }));
          localgdd.acba = new gol().df(arrayOfByte2);
          localgdd.acaX = new gol().df(arrayOfByte1);
          Log.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] ccd data len = %d", new Object[] { Integer.valueOf(arrayOfByte1.length) }));
          t(paramInt1, localgdd.toByteArray());
        }
        finally
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
  
  public final void t(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89180);
    if (paramArrayOfByte == null)
    {
      Log.e("MicroMsg.SecInfoReporterImpl", "data is null.");
      AppMethodBeat.o(89180);
      return;
    }
    Object localObject = new com.tencent.mm.am.c.a();
    ((com.tencent.mm.am.c.a)localObject).uri = d.MtP.aQf("");
    ((com.tencent.mm.am.c.a)localObject).funcId = 771;
    ((com.tencent.mm.am.c.a)localObject).otE = new epz();
    ((com.tencent.mm.am.c.a)localObject).otF = new eqa();
    localObject = ((com.tencent.mm.am.c.a)localObject).bEF();
    epz localepz = (epz)c.b.b(((com.tencent.mm.am.c)localObject).otB);
    localepz.hYd = paramInt;
    localepz.abtY = new b("".getBytes());
    localepz.YKb = new gol().df(paramArrayOfByte);
    f.Ozc.idkeyStat(416L, 0L, 1L, false);
    z.a((com.tencent.mm.am.c)localObject, new c.1(this, paramInt), false);
    AppMethodBeat.o(89180);
  }
  
  static final class a
  {
    private static final Map<Integer, Long> PlW;
    private static dum PlX;
    
    static
    {
      AppMethodBeat.i(89170);
      PlW = new HashMap();
      PlX = null;
      AppMethodBeat.o(89170);
    }
    
    /* Error */
    private static void Td()
    {
      // Byte code:
      //   0: ldc 2
      //   2: monitorenter
      //   3: ldc 40
      //   5: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: getstatic 32	com/tencent/mm/plugin/secinforeport/c$a:PlX	Lcom/tencent/mm/protocal/protobuf/dum;
      //   11: ifnull +12 -> 23
      //   14: ldc 40
      //   16: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   19: ldc 2
      //   21: monitorexit
      //   22: return
      //   23: invokestatic 44	com/tencent/mm/plugin/secinforeport/c$a:gUD	()Lcom/tencent/mm/protocal/protobuf/dum;
      //   26: putstatic 32	com/tencent/mm/plugin/secinforeport/c$a:PlX	Lcom/tencent/mm/protocal/protobuf/dum;
      //   29: ldc 40
      //   31: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   34: goto -15 -> 19
      //   37: astore_0
      //   38: ldc 2
      //   40: monitorexit
      //   41: aload_0
      //   42: athrow
      //   43: astore_0
      //   44: invokestatic 47	com/tencent/mm/plugin/secinforeport/c$a:gUE	()Lcom/tencent/mm/protocal/protobuf/dum;
      //   47: putstatic 32	com/tencent/mm/plugin/secinforeport/c$a:PlX	Lcom/tencent/mm/protocal/protobuf/dum;
      //   50: ldc 40
      //   52: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   55: goto -36 -> 19
      //   58: astore_0
      //   59: new 49	com/tencent/mm/protocal/protobuf/dum
      //   62: dup
      //   63: invokespecial 50	com/tencent/mm/protocal/protobuf/dum:<init>	()V
      //   66: putstatic 32	com/tencent/mm/plugin/secinforeport/c$a:PlX	Lcom/tencent/mm/protocal/protobuf/dum;
      //   69: ldc 52
      //   71: ldc 54
      //   73: iconst_1
      //   74: anewarray 4	java/lang/Object
      //   77: dup
      //   78: iconst_0
      //   79: aload_0
      //   80: aastore
      //   81: invokestatic 60	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   84: ldc 40
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
    
    private static dun aiN(int paramInt)
    {
      AppMethodBeat.i(261993);
      if (PlX == null)
      {
        AppMethodBeat.o(261993);
        return null;
      }
      Iterator localIterator = PlX.abax.iterator();
      while (localIterator.hasNext())
      {
        dun localdun = (dun)localIterator.next();
        if (localdun.abay == paramInt)
        {
          AppMethodBeat.o(261993);
          return localdun;
        }
      }
      AppMethodBeat.o(261993);
      return null;
    }
    
    /* Error */
    static boolean ba(int paramInt, long paramLong)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore 5
      //   3: ldc 2
      //   5: monitorenter
      //   6: ldc 92
      //   8: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   11: lload_1
      //   12: lconst_0
      //   13: lcmp
      //   14: ifgt +32 -> 46
      //   17: ldc 52
      //   19: ldc 94
      //   21: iconst_1
      //   22: anewarray 4	java/lang/Object
      //   25: dup
      //   26: iconst_0
      //   27: lload_1
      //   28: invokestatic 100	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   31: aastore
      //   32: invokestatic 103	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   35: ldc 92
      //   37: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   40: ldc 2
      //   42: monitorexit
      //   43: iload 5
      //   45: ireturn
      //   46: getstatic 32	com/tencent/mm/plugin/secinforeport/c$a:PlX	Lcom/tencent/mm/protocal/protobuf/dum;
      //   49: ifnonnull +6 -> 55
      //   52: invokestatic 105	com/tencent/mm/plugin/secinforeport/c$a:Td	()V
      //   55: iload_0
      //   56: invokestatic 107	com/tencent/mm/plugin/secinforeport/c$a:aiN	(I)Lcom/tencent/mm/protocal/protobuf/dun;
      //   59: astore 7
      //   61: aload 7
      //   63: astore 6
      //   65: aload 7
      //   67: ifnonnull +36 -> 103
      //   70: new 85	com/tencent/mm/protocal/protobuf/dun
      //   73: dup
      //   74: invokespecial 108	com/tencent/mm/protocal/protobuf/dun:<init>	()V
      //   77: astore 6
      //   79: aload 6
      //   81: iload_0
      //   82: putfield 89	com/tencent/mm/protocal/protobuf/dun:abay	I
      //   85: aload 6
      //   87: lconst_0
      //   88: putfield 112	com/tencent/mm/protocal/protobuf/dun:lastReportTime	J
      //   91: getstatic 32	com/tencent/mm/plugin/secinforeport/c$a:PlX	Lcom/tencent/mm/protocal/protobuf/dum;
      //   94: getfield 67	com/tencent/mm/protocal/protobuf/dum:abax	Ljava/util/LinkedList;
      //   97: aload 6
      //   99: invokevirtual 116	java/util/LinkedList:add	(Ljava/lang/Object;)Z
      //   102: pop
      //   103: invokestatic 122	java/lang/System:currentTimeMillis	()J
      //   106: lstore_3
      //   107: lload_3
      //   108: aload 6
      //   110: getfield 112	com/tencent/mm/protocal/protobuf/dun:lastReportTime	J
      //   113: lcmp
      //   114: iflt +15 -> 129
      //   117: lload_3
      //   118: aload 6
      //   120: getfield 112	com/tencent/mm/protocal/protobuf/dun:lastReportTime	J
      //   123: lsub
      //   124: lload_1
      //   125: lcmp
      //   126: ifle +29 -> 155
      //   129: aload 6
      //   131: lload_3
      //   132: putfield 112	com/tencent/mm/protocal/protobuf/dun:lastReportTime	J
      //   135: aload 6
      //   137: iconst_1
      //   138: putfield 125	com/tencent/mm/protocal/protobuf/dun:abaz	I
      //   141: invokestatic 128	com/tencent/mm/plugin/secinforeport/c$a:sz	()V
      //   144: ldc 92
      //   146: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   149: iconst_1
      //   150: istore 5
      //   152: goto -112 -> 40
      //   155: ldc 92
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
      //   63	73	6	localdun1	dun
      //   163	6	6	localObject	Object
      //   59	7	7	localdun2	dun
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
    
    /* Error */
    private static dum gUD()
    {
      // Byte code:
      //   0: ldc 2
      //   2: monitorenter
      //   3: ldc 129
      //   5: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: new 49	com/tencent/mm/protocal/protobuf/dum
      //   11: dup
      //   12: invokespecial 50	com/tencent/mm/protocal/protobuf/dum:<init>	()V
      //   15: astore 4
      //   17: new 131	com/tencent/mm/vfs/u
      //   20: dup
      //   21: invokestatic 137	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
      //   24: getfield 143	com/tencent/mm/kernel/f:cachePath	Ljava/lang/String;
      //   27: getstatic 149	com/tencent/mm/plugin/normsg/a/d:MtP	Lcom/tencent/mm/plugin/normsg/a/d;
      //   30: ldc 151
      //   32: invokevirtual 155	com/tencent/mm/plugin/normsg/a/d:aQf	(Ljava/lang/String;)Ljava/lang/String;
      //   35: invokespecial 158	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   38: astore_1
      //   39: aload_1
      //   40: invokevirtual 161	com/tencent/mm/vfs/u:length	()J
      //   43: l2i
      //   44: istore_0
      //   45: iload_0
      //   46: ifne +14 -> 60
      //   49: ldc 129
      //   51: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   54: ldc 2
      //   56: monitorexit
      //   57: aload 4
      //   59: areturn
      //   60: iload_0
      //   61: newarray byte
      //   63: astore_3
      //   64: new 163	java/io/DataInputStream
      //   67: dup
      //   68: aload_1
      //   69: invokestatic 169	com/tencent/mm/vfs/y:ao	(Lcom/tencent/mm/vfs/u;)Ljava/io/InputStream;
      //   72: invokespecial 172	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
      //   75: astore_2
      //   76: aload_2
      //   77: astore_1
      //   78: aload_2
      //   79: aload_3
      //   80: invokevirtual 176	java/io/DataInputStream:read	([B)I
      //   83: pop
      //   84: aload_2
      //   85: invokevirtual 179	java/io/DataInputStream:close	()V
      //   88: aload 4
      //   90: aload_3
      //   91: invokevirtual 183	com/tencent/mm/protocal/protobuf/dum:parseFrom	([B)Lcom/tencent/mm/bx/a;
      //   94: pop
      //   95: ldc 52
      //   97: ldc 185
      //   99: invokestatic 187	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   102: ldc 129
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
      //   121: ldc 52
      //   123: ldc 54
      //   125: iconst_1
      //   126: anewarray 4	java/lang/Object
      //   129: dup
      //   130: iconst_0
      //   131: aload_3
      //   132: aastore
      //   133: invokestatic 60	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   136: aload_2
      //   137: ifnull +7 -> 144
      //   140: aload_2
      //   141: invokevirtual 179	java/io/DataInputStream:close	()V
      //   144: ldc 129
      //   146: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   149: goto -95 -> 54
      //   152: astore_2
      //   153: aconst_null
      //   154: astore_1
      //   155: aload_1
      //   156: ifnull +7 -> 163
      //   159: aload_1
      //   160: invokevirtual 179	java/io/DataInputStream:close	()V
      //   163: ldc 129
      //   165: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   168: aload_2
      //   169: athrow
      //   170: astore_1
      //   171: new 9	com/tencent/mm/plugin/secinforeport/c$a$a
      //   174: dup
      //   175: invokespecial 188	com/tencent/mm/plugin/secinforeport/c$a$a:<init>	()V
      //   178: astore_1
      //   179: ldc 129
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
      //   15	74	4	localdum	dum
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
    private static dum gUE()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_0
      //   2: ldc 2
      //   4: monitorenter
      //   5: ldc 189
      //   7: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   10: new 49	com/tencent/mm/protocal/protobuf/dum
      //   13: dup
      //   14: invokespecial 50	com/tencent/mm/protocal/protobuf/dum:<init>	()V
      //   17: astore 8
      //   19: new 131	com/tencent/mm/vfs/u
      //   22: dup
      //   23: invokestatic 137	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
      //   26: getfield 143	com/tencent/mm/kernel/f:cachePath	Ljava/lang/String;
      //   29: getstatic 149	com/tencent/mm/plugin/normsg/a/d:MtP	Lcom/tencent/mm/plugin/normsg/a/d;
      //   32: ldc 151
      //   34: invokevirtual 155	com/tencent/mm/plugin/normsg/a/d:aQf	(Ljava/lang/String;)Ljava/lang/String;
      //   37: invokespecial 158	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   40: astore 5
      //   42: new 163	java/io/DataInputStream
      //   45: dup
      //   46: aload 5
      //   48: invokestatic 169	com/tencent/mm/vfs/y:ao	(Lcom/tencent/mm/vfs/u;)Ljava/io/InputStream;
      //   51: invokespecial 172	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
      //   54: astore 6
      //   56: aload 6
      //   58: astore 5
      //   60: aload 6
      //   62: invokevirtual 193	java/io/DataInputStream:readShort	()S
      //   65: sipush -774
      //   68: if_icmpeq +77 -> 145
      //   71: aload 6
      //   73: astore 5
      //   75: new 195	java/lang/IllegalStateException
      //   78: dup
      //   79: ldc 197
      //   81: invokespecial 200	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
      //   84: astore 7
      //   86: aload 6
      //   88: astore 5
      //   90: ldc 189
      //   92: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   95: aload 6
      //   97: astore 5
      //   99: aload 7
      //   101: athrow
      //   102: astore 7
      //   104: aload 6
      //   106: astore 5
      //   108: ldc 52
      //   110: ldc 202
      //   112: iconst_1
      //   113: anewarray 4	java/lang/Object
      //   116: dup
      //   117: iconst_0
      //   118: aload 7
      //   120: aastore
      //   121: invokestatic 60	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   124: aload 6
      //   126: ifnull +8 -> 134
      //   129: aload 6
      //   131: invokevirtual 179	java/io/DataInputStream:close	()V
      //   134: ldc 189
      //   136: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   139: ldc 2
      //   141: monitorexit
      //   142: aload 8
      //   144: areturn
      //   145: aload 6
      //   147: astore 5
      //   149: aload 6
      //   151: invokevirtual 193	java/io/DataInputStream:readShort	()S
      //   154: pop
      //   155: aload 6
      //   157: astore 5
      //   159: aload 6
      //   161: invokevirtual 206	java/io/DataInputStream:readInt	()I
      //   164: istore_1
      //   165: iload_1
      //   166: ifge +70 -> 236
      //   169: aload 6
      //   171: astore 5
      //   173: new 195	java/lang/IllegalStateException
      //   176: dup
      //   177: ldc 208
      //   179: invokespecial 200	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
      //   182: astore 7
      //   184: aload 6
      //   186: astore 5
      //   188: ldc 189
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
      //   217: invokevirtual 179	java/io/DataInputStream:close	()V
      //   220: ldc 189
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
      //   247: invokevirtual 206	java/io/DataInputStream:readInt	()I
      //   250: istore_2
      //   251: aload 6
      //   253: astore 5
      //   255: aload 6
      //   257: invokevirtual 211	java/io/DataInputStream:readLong	()J
      //   260: lstore_3
      //   261: aload 6
      //   263: astore 5
      //   265: new 85	com/tencent/mm/protocal/protobuf/dun
      //   268: dup
      //   269: invokespecial 108	com/tencent/mm/protocal/protobuf/dun:<init>	()V
      //   272: astore 7
      //   274: aload 6
      //   276: astore 5
      //   278: aload 7
      //   280: iload_2
      //   281: putfield 89	com/tencent/mm/protocal/protobuf/dun:abay	I
      //   284: aload 6
      //   286: astore 5
      //   288: aload 7
      //   290: lload_3
      //   291: putfield 112	com/tencent/mm/protocal/protobuf/dun:lastReportTime	J
      //   294: aload 6
      //   296: astore 5
      //   298: aload 7
      //   300: iconst_1
      //   301: putfield 125	com/tencent/mm/protocal/protobuf/dun:abaz	I
      //   304: aload 6
      //   306: astore 5
      //   308: aload 8
      //   310: getfield 67	com/tencent/mm/protocal/protobuf/dum:abax	Ljava/util/LinkedList;
      //   313: aload 7
      //   315: invokevirtual 116	java/util/LinkedList:add	(Ljava/lang/Object;)Z
      //   318: pop
      //   319: iload_0
      //   320: iconst_1
      //   321: iadd
      //   322: istore_0
      //   323: goto -87 -> 236
      //   326: aload 6
      //   328: astore 5
      //   330: ldc 52
      //   332: ldc 185
      //   334: invokestatic 187	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   337: aload 6
      //   339: invokevirtual 179	java/io/DataInputStream:close	()V
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
      //   272	42	7	localdun	dun
      //   368	1	7	localException5	Exception
      //   17	292	8	localdum	dum
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
    
    static boolean la(int paramInt1, int paramInt2)
    {
      boolean bool = true;
      for (;;)
      {
        long l;
        try
        {
          AppMethodBeat.i(261985);
          if ((86400000L <= 0L) || (paramInt2 <= 0))
          {
            Log.w("MicroMsg.SecInfoReporterImpl", "bad interval: %s, %s", new Object[] { Long.valueOf(86400000L), Integer.valueOf(paramInt2) });
            AppMethodBeat.o(261985);
            bool = false;
            return bool;
          }
          if (PlX == null) {
            Td();
          }
          dun localdun2 = aiN(paramInt1);
          dun localdun1 = localdun2;
          if (localdun2 == null)
          {
            localdun1 = new dun();
            localdun1.abay = paramInt1;
            localdun1.lastReportTime = 0L;
            PlX.abax.add(localdun1);
          }
          l = System.currentTimeMillis();
          if ((l < localdun1.lastReportTime) || (l / 86400000L != localdun1.lastReportTime / 86400000L))
          {
            localdun1.lastReportTime = l;
            localdun1.abaz = 1;
            sz();
            AppMethodBeat.o(261985);
            continue;
          }
          if (localObject.abaz >= paramInt2) {
            break label219;
          }
        }
        finally {}
        localObject.lastReportTime = l;
        localObject.abaz += 1;
        sz();
        AppMethodBeat.o(261985);
        continue;
        label219:
        AppMethodBeat.o(261985);
        bool = false;
      }
    }
    
    /* Error */
    private static void sz()
    {
      // Byte code:
      //   0: ldc 2
      //   2: monitorenter
      //   3: ldc 224
      //   5: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: new 131	com/tencent/mm/vfs/u
      //   11: dup
      //   12: invokestatic 137	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
      //   15: getfield 143	com/tencent/mm/kernel/f:cachePath	Ljava/lang/String;
      //   18: getstatic 149	com/tencent/mm/plugin/normsg/a/d:MtP	Lcom/tencent/mm/plugin/normsg/a/d;
      //   21: ldc 151
      //   23: invokevirtual 155	com/tencent/mm/plugin/normsg/a/d:aQf	(Ljava/lang/String;)Ljava/lang/String;
      //   26: invokespecial 158	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   29: astore_0
      //   30: aload_0
      //   31: invokevirtual 227	com/tencent/mm/vfs/u:jKS	()Z
      //   34: ifne +11 -> 45
      //   37: aload_0
      //   38: invokevirtual 231	com/tencent/mm/vfs/u:jKP	()Lcom/tencent/mm/vfs/u;
      //   41: invokevirtual 234	com/tencent/mm/vfs/u:jKY	()Z
      //   44: pop
      //   45: new 236	java/io/DataOutputStream
      //   48: dup
      //   49: aload_0
      //   50: invokestatic 240	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
      //   53: invokespecial 243	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   56: astore_1
      //   57: aload_1
      //   58: astore_0
      //   59: getstatic 32	com/tencent/mm/plugin/secinforeport/c$a:PlX	Lcom/tencent/mm/protocal/protobuf/dum;
      //   62: ifnull +15 -> 77
      //   65: aload_1
      //   66: astore_0
      //   67: aload_1
      //   68: getstatic 32	com/tencent/mm/plugin/secinforeport/c$a:PlX	Lcom/tencent/mm/protocal/protobuf/dum;
      //   71: invokevirtual 247	com/tencent/mm/protocal/protobuf/dum:toByteArray	()[B
      //   74: invokevirtual 251	java/io/DataOutputStream:write	([B)V
      //   77: aload_1
      //   78: astore_0
      //   79: ldc 52
      //   81: ldc 253
      //   83: invokestatic 187	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   86: aload_1
      //   87: invokevirtual 254	java/io/DataOutputStream:close	()V
      //   90: ldc 224
      //   92: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   95: ldc 2
      //   97: monitorexit
      //   98: return
      //   99: astore_0
      //   100: ldc 224
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
      //   119: ldc 52
      //   121: ldc_w 256
      //   124: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   127: aload_1
      //   128: ifnull +42 -> 170
      //   131: aload_1
      //   132: invokevirtual 254	java/io/DataOutputStream:close	()V
      //   135: ldc 224
      //   137: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   140: goto -45 -> 95
      //   143: astore_0
      //   144: ldc 224
      //   146: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   149: goto -54 -> 95
      //   152: astore_0
      //   153: aconst_null
      //   154: astore_1
      //   155: aload_1
      //   156: ifnull +7 -> 163
      //   159: aload_1
      //   160: invokevirtual 254	java/io/DataOutputStream:close	()V
      //   163: ldc 224
      //   165: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   168: aload_0
      //   169: athrow
      //   170: ldc 224
      //   172: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   175: goto -80 -> 95
      //   178: astore_1
      //   179: goto -16 -> 163
      //   182: astore_1
      //   183: aload_0
      //   184: astore_2
      //   185: aload_1
      //   186: astore_0
      //   187: aload_2
      //   188: astore_1
      //   189: goto -34 -> 155
      //   192: astore_0
      //   193: goto -76 -> 117
      // Local variable table:
      //   start	length	slot	name	signature
      //   29	50	0	localObject1	Object
      //   99	1	0	localException1	Exception
      //   108	5	0	localObject2	Object
      //   114	1	0	localException2	Exception
      //   118	1	0	localObject3	Object
      //   143	1	0	localException3	Exception
      //   152	32	0	localObject4	Object
      //   186	1	0	localObject5	Object
      //   192	1	0	localException4	Exception
      //   56	104	1	localDataOutputStream	java.io.DataOutputStream
      //   178	1	1	localException5	Exception
      //   182	4	1	localObject6	Object
      //   188	1	1	localObject7	Object
      //   184	4	2	localObject8	Object
      // Exception table:
      //   from	to	target	type
      //   86	90	99	java/lang/Exception
      //   3	45	108	finally
      //   86	90	108	finally
      //   90	95	108	finally
      //   100	105	108	finally
      //   131	135	108	finally
      //   135	140	108	finally
      //   144	149	108	finally
      //   159	163	108	finally
      //   163	170	108	finally
      //   170	175	108	finally
      //   45	57	114	java/lang/Exception
      //   131	135	143	java/lang/Exception
      //   45	57	152	finally
      //   159	163	178	java/lang/Exception
      //   59	65	182	finally
      //   67	77	182	finally
      //   79	86	182	finally
      //   119	127	182	finally
      //   59	65	192	java/lang/Exception
      //   67	77	192	java/lang/Exception
      //   79	86	192	java/lang/Exception
    }
    
    static final class a
      extends Exception
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.c
 * JD-Core Version:    0.7.0.1
 */