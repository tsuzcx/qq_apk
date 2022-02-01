package com.tencent.mm.plugin.report.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mars.Mars;
import com.tencent.mars.smc.IDKey;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.s;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.model.v;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.ai;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

public enum g
  implements com.tencent.mm.plugin.report.d
{
  private int uin;
  private long yxJ;
  private int yxK;
  private HashMap<String, Long> yxL;
  private int yxM;
  private int yxN;
  private long yxO;
  private volatile boolean yxP;
  
  static
  {
    AppMethodBeat.i(143908);
    yxI = new g("INSTANCE");
    yxQ = new g[] { yxI };
    AppMethodBeat.o(143908);
  }
  
  private g()
  {
    AppMethodBeat.i(143875);
    this.yxJ = 0L;
    if (ak.cpe())
    {
      com.tencent.mm.kernel.g.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143864);
          g.a(g.this);
          AppMethodBeat.o(143864);
        }
      });
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143865);
          g.b(g.this);
          AppMethodBeat.o(143865);
        }
      };
      com.tencent.mm.sdk.b.a.IvT.b(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.kernel.g.ajj().a(701, new f()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(143867);
          if (paramAnonymousInt1 != 0)
          {
            AppMethodBeat.o(143867);
            return;
          }
          com.tencent.mm.kernel.g.ajU().n(this.yxS, 5000L);
          AppMethodBeat.o(143867);
        }
      });
    }
    AppMethodBeat.o(143875);
  }
  
  public static Object a(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(143876);
    paramArrayOfInt = com.tencent.mm.plugin.report.e.a(paramInt1, paramArrayOfInt, paramInt2, paramInt3);
    AppMethodBeat.o(143876);
    return paramArrayOfInt;
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(143879);
    KVReportDataInfo localKVReportDataInfo = new KVReportDataInfo();
    localKVReportDataInfo.dze = paramInt1;
    localKVReportDataInfo.value = paramString;
    localKVReportDataInfo.dmg = paramInt2;
    localKVReportDataInfo.yxc = false;
    localKVReportDataInfo.yxu = paramBoolean1;
    localKVReportDataInfo.yxv = paramBoolean2;
    KVCommCrossProcessReceiver.a(localKVReportDataInfo);
    AppMethodBeat.o(143879);
  }
  
  private void a(final String paramString, final Callable<JSONArray> paramCallable)
  {
    AppMethodBeat.i(143903);
    final long l = System.currentTimeMillis();
    if (!bj(paramString, l))
    {
      AppMethodBeat.o(143903);
      return;
    }
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        Object localObject7 = null;
        Object localObject6 = null;
        int j = 0;
        AppMethodBeat.i(143870);
        int i;
        Object localObject1;
        if ((ak.cpe()) && (com.tencent.mm.kernel.g.ajM()))
        {
          com.tencent.mm.kernel.g.ajP();
          i = com.tencent.mm.kernel.a.getUin();
          if (com.tencent.mm.kernel.g.ajR().ajA() == null) {
            localObject1 = null;
          }
        }
        for (;;)
        {
          Object localObject5 = localObject1;
          label49:
          Object localObject3 = localObject6;
          localObject1 = localObject7;
          try
          {
            Object localObject9 = ak.getContext().getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com");
            localObject3 = localObject6;
            localObject1 = localObject7;
            Object localObject8 = (JSONArray)paramCallable.call();
            localObject3 = localObject6;
            localObject1 = localObject7;
            int k = ((JSONArray)localObject8).length();
            for (;;)
            {
              if (j < k)
              {
                localObject3 = localObject6;
                localObject1 = localObject7;
                localObject10 = ((JSONArray)localObject8).getJSONObject(j);
                localObject3 = localObject6;
                localObject1 = localObject7;
                ((JSONObject)localObject10).put("tag", paramString);
                localObject3 = localObject6;
                localObject1 = localObject7;
                ((JSONObject)localObject10).put("uin", i);
                j += 1;
                continue;
                localObject1 = v.aAC();
                break;
                localObject5 = null;
                i = 0;
                break label49;
              }
            }
            localObject3 = localObject6;
            localObject1 = localObject7;
            localObject8 = new JSONObject().put("head", new JSONObject().put("protocol_ver", 1).put("phone", com.tencent.mm.protocal.d.DEVICE_NAME).put("os_ver", com.tencent.mm.protocal.d.hjv).put("report_time", l).put("revision", bu.nullAsNil(j.REV))).put("items", localObject8).toString().getBytes();
            localObject3 = localObject6;
            localObject1 = localObject7;
            j = localObject8.length;
            localObject3 = localObject6;
            localObject1 = localObject7;
            Object localObject10 = com.tencent.mm.b.g.getMessageDigest(String.format("weixin#$()%d%d", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.FFH), Integer.valueOf(j) }).getBytes()).toLowerCase();
            localObject3 = localObject6;
            localObject1 = localObject7;
            byte[] arrayOfByte = s.compress((byte[])localObject8);
            localObject3 = localObject6;
            localObject1 = localObject7;
            localObject8 = new PByteArray();
            localObject3 = localObject6;
            localObject1 = localObject7;
            com.tencent.mm.b.c.a((PByteArray)localObject8, arrayOfByte, ((String)localObject10).getBytes());
            localObject3 = localObject6;
            localObject1 = localObject7;
            localObject9 = new StringBuilder(256).append("https://").append((String)localObject9).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(com.tencent.mm.protocal.d.FFH)).append("&devicetype=").append(com.tencent.mm.protocal.d.hjv).append("&filelength=").append(j).append("&sum=").append((String)localObject10).append("&reporttype=1&NewReportType=110");
            if (localObject5 != null)
            {
              localObject3 = localObject6;
              localObject1 = localObject7;
              if (((String)localObject5).length() != 0)
              {
                localObject3 = localObject6;
                localObject1 = localObject7;
                ((StringBuilder)localObject9).append("&username=").append((String)localObject5);
              }
            }
            if (i != 0)
            {
              localObject3 = localObject6;
              localObject1 = localObject7;
              ((StringBuilder)localObject9).append("&uin=").append(i);
            }
            localObject3 = localObject6;
            localObject1 = localObject7;
            localObject9 = ((StringBuilder)localObject9).toString();
            localObject3 = localObject6;
            localObject1 = localObject7;
            localObject5 = new DefaultHttpClient();
            localObject3 = localObject6;
            localObject1 = localObject7;
            localObject9 = new HttpPost((String)localObject9);
            localObject3 = localObject6;
            localObject1 = localObject7;
            localObject8 = new ByteArrayEntity(((PByteArray)localObject8).value);
            localObject3 = localObject6;
            localObject1 = localObject7;
            ((ByteArrayEntity)localObject8).setContentType("binary/octet-stream");
            localObject3 = localObject6;
            localObject1 = localObject7;
            ((HttpPost)localObject9).setEntity((HttpEntity)localObject8);
            localObject3 = localObject6;
            localObject1 = localObject7;
            localObject5 = ((HttpClient)localObject5).execute((HttpUriRequest)localObject9).getEntity().getContent();
            localObject3 = localObject5;
            localObject1 = localObject5;
            ae.i("MicroMsg.cLog", "POST returned: ".concat(String.valueOf(bu.convertStreamToString((InputStream)localObject5))));
            if (localObject5 != null) {
              try
              {
                ((InputStream)localObject5).close();
                AppMethodBeat.o(143870);
                return;
              }
              catch (IOException localIOException1)
              {
                AppMethodBeat.o(143870);
                return;
              }
            }
            try
            {
              Object localObject2;
              localIOException2.close();
              AppMethodBeat.o(143870);
              throw localObject4;
              AppMethodBeat.o(143870);
              return;
            }
            catch (IOException localIOException3)
            {
              break label774;
            }
          }
          catch (Exception localException)
          {
            localObject2 = localObject3;
            ae.printErrStackTrace("MicroMsg.ReportManagerKvCheck", localException, "Failed to upload cLog.", new Object[0]);
            if (localObject3 != null) {
              try
              {
                localObject3.close();
                AppMethodBeat.o(143870);
                return;
              }
              catch (IOException localIOException2)
              {
                AppMethodBeat.o(143870);
                return;
              }
            }
          }
          finally
          {
            if (localIOException2 == null) {}
          }
        }
      }
    }, "ReportManager_cLog");
    AppMethodBeat.o(143903);
  }
  
  private static void b(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(143880);
    KVReportDataInfo localKVReportDataInfo = new KVReportDataInfo();
    localKVReportDataInfo.dze = paramInt;
    localKVReportDataInfo.value = paramString;
    localKVReportDataInfo.dmg = 0L;
    localKVReportDataInfo.yxc = false;
    localKVReportDataInfo.yxu = paramBoolean1;
    localKVReportDataInfo.yxv = paramBoolean2;
    KVCommCrossProcessReceiver.a(localKVReportDataInfo);
    AppMethodBeat.o(143880);
  }
  
  private static void b(int paramInt, List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(143890);
    paramList = fA(paramList);
    if (ak.cpe())
    {
      d.a(paramInt, paramList, paramBoolean, false, false);
      AppMethodBeat.o(143890);
      return;
    }
    b(paramInt, paramList, paramBoolean, false);
    AppMethodBeat.o(143890);
  }
  
  private boolean bj(String paramString, long paramLong)
  {
    AppMethodBeat.i(143905);
    if (bv.fpT())
    {
      ae.d("MicroMsg.cLog", "[%s] Sampling hit: (debug)", new Object[] { paramString });
      AppMethodBeat.o(143905);
      return true;
    }
    Long localLong;
    boolean bool;
    if (this.yxL != null)
    {
      localLong = (Long)this.yxL.get(paramString);
      if (localLong == null) {
        break label333;
      }
      localObject = com.tencent.mm.b.g.C((paramString + this.uin + paramLong).getBytes());
      if ((localObject == null) || (localObject.length != 16)) {
        break label333;
      }
      paramLong = localObject[0] + localObject[4] + localObject[8] + localObject[12];
      long l1 = localObject[1] + localObject[5] + localObject[9] + localObject[13];
      long l2 = localObject[2] + localObject[6] + localObject[10] + localObject[14];
      int i = localObject[3];
      int j = localObject[7];
      int k = localObject[11];
      paramLong = paramLong & 0xFF | (l1 & 0xFF) << 8 | (l2 & 0xFF) << 16 | (localObject[15] + (i + j + k) & 0xFF) << 24;
      if (paramLong >= localLong.longValue()) {
        break label319;
      }
      bool = true;
      label261:
      if (!bool) {
        break label325;
      }
    }
    label319:
    label325:
    for (Object localObject = "hit";; localObject = "miss")
    {
      ae.d("MicroMsg.cLog", "[%s] Sampling %s: 0x%08x / 0x%08x", new Object[] { paramString, localObject, Long.valueOf(paramLong), localLong });
      AppMethodBeat.o(143905);
      return bool;
      localLong = null;
      break;
      bool = false;
      break label261;
    }
    label333:
    ae.d("MicroMsg.cLog", "[%s] Sampling hit: (default)", new Object[] { paramString });
    AppMethodBeat.o(143905);
    return true;
  }
  
  public static void c(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(143884);
    if (ak.cpe())
    {
      if (com.tencent.mm.plugin.report.a.c.ywG)
      {
        long l = paramInt;
        paramBoolean1 = com.tencent.mm.plugin.report.a.c.ywH;
        d.a(l, paramString, paramBoolean1, paramBoolean1, paramBoolean2);
        AppMethodBeat.o(143884);
        return;
      }
      d.a(paramInt, paramString, paramBoolean1, false, paramBoolean2);
      AppMethodBeat.o(143884);
      return;
    }
    b(paramInt, paramString, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(143884);
  }
  
  public static void dNI()
  {
    AppMethodBeat.i(143899);
    if (ak.cpe()) {
      Mars.onSingalCrash(0);
    }
    AppMethodBeat.o(143899);
  }
  
  private static String fA(List<String> paramList)
  {
    AppMethodBeat.i(143878);
    if ((paramList == null) || (paramList.isEmpty())) {
      ae.w("MicroMsg.ReportManagerKvCheck", "vals is null, use '' as value");
    }
    StringBuilder localStringBuilder;
    for (paramList = "";; paramList = localStringBuilder.toString())
    {
      AppMethodBeat.o(143878);
      return paramList;
      localStringBuilder = new StringBuilder();
      int j = paramList.size() - 1;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append((String)paramList.get(i)).append(',');
        i += 1;
      }
      localStringBuilder.append((String)paramList.get(j));
    }
  }
  
  public static void m(int paramInt, List<String> paramList)
  {
    AppMethodBeat.i(143889);
    if (com.tencent.mm.plugin.report.a.c.ywG)
    {
      b(paramInt, paramList, com.tencent.mm.plugin.report.a.c.ywH);
      AppMethodBeat.o(143889);
      return;
    }
    b(paramInt, paramList, false);
    AppMethodBeat.o(143889);
  }
  
  private static void m(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(143881);
    StIDKeyDataInfo localStIDKeyDataInfo = new StIDKeyDataInfo();
    localStIDKeyDataInfo.pXC = paramLong1;
    localStIDKeyDataInfo.key = paramLong2;
    localStIDKeyDataInfo.value = paramLong3;
    localStIDKeyDataInfo.yxc = false;
    KVCommCrossProcessReceiver.a(localStIDKeyDataInfo);
    AppMethodBeat.o(143881);
  }
  
  public static String u(Object... paramVarArgs)
  {
    int i = 0;
    AppMethodBeat.i(143877);
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0))
    {
      ae.w("MicroMsg.ReportManagerKvCheck", "vals is null, use '' as value");
      paramVarArgs = "";
    }
    for (;;)
    {
      AppMethodBeat.o(143877);
      return paramVarArgs;
      if (paramVarArgs.length == 1)
      {
        paramVarArgs = String.valueOf(paramVarArgs[0]);
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        int j = paramVarArgs.length - 1;
        while (i < j)
        {
          localStringBuilder.append(String.valueOf(paramVarArgs[i]).replace(',', ' ')).append(',');
          i += 1;
        }
        localStringBuilder.append(String.valueOf(paramVarArgs[j]));
        paramVarArgs = localStringBuilder.toString();
      }
    }
  }
  
  public final void A(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(224445);
    n(paramLong1, paramLong2, 1L);
    AppMethodBeat.o(224445);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
  {
    AppMethodBeat.i(143896);
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(paramInt1);
    localIDKey1.SetKey(paramInt3);
    localIDKey1.SetValue(paramInt5);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(paramInt2);
    localIDKey2.SetKey(paramInt4);
    localIDKey2.SetValue(paramInt6);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localIDKey1);
    localArrayList.add(localIDKey2);
    b(localArrayList, paramBoolean);
    AppMethodBeat.o(143896);
  }
  
  public final void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(143883);
    if (ak.cpe())
    {
      if (com.tencent.mm.plugin.report.a.c.ywG)
      {
        long l = paramInt;
        paramBoolean1 = com.tencent.mm.plugin.report.a.c.ywH;
        d.a(l, paramString, paramBoolean1, paramBoolean1, false);
        AppMethodBeat.o(143883);
        return;
      }
      d.a(paramInt, paramString, paramBoolean1, false, false);
      AppMethodBeat.o(143883);
      return;
    }
    b(paramInt, paramString, paramBoolean1, false);
    AppMethodBeat.o(143883);
  }
  
  public final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Object... paramVarArgs)
  {
    AppMethodBeat.i(221078);
    c(paramInt, u(paramVarArgs), paramBoolean1, paramBoolean3);
    AppMethodBeat.o(221078);
  }
  
  public final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, Object... paramVarArgs)
  {
    AppMethodBeat.i(143887);
    paramVarArgs = u(paramVarArgs);
    if (com.tencent.mm.sdk.a.b.fnF()) {
      ae.v("MicroMsg.ReportManagerKvCheck", "kvTypedStat id:%d [%b,%b] val:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.FALSE, paramVarArgs });
    }
    if (ak.cpe())
    {
      d.a(paramInt, paramVarArgs, paramBoolean1, false, false);
      AppMethodBeat.o(143887);
      return;
    }
    b(paramInt, paramVarArgs, paramBoolean1, false);
    AppMethodBeat.o(143887);
  }
  
  public final void ar(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(143898);
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(paramInt1);
    localIDKey1.SetKey(paramInt2);
    localIDKey1.SetValue(1L);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(paramInt1);
    localIDKey2.SetKey(paramInt3);
    localIDKey2.SetValue(1L);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localIDKey1);
    localArrayList.add(localIDKey2);
    b(localArrayList, false);
    AppMethodBeat.o(143898);
  }
  
  public final void b(ArrayList<IDKey> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(143895);
    if (paramArrayList == null)
    {
      ae.e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat lstIdKeyDataInfos == null return");
      AppMethodBeat.o(143895);
      return;
    }
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      IDKey localIDKey = (IDKey)localIterator.next();
      if (localIDKey == null)
      {
        ae.e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat info == null return");
        AppMethodBeat.o(143895);
        return;
      }
      if ((localIDKey.GetID() < 0L) || (localIDKey.GetKey() < 0L) || (localIDKey.GetValue() <= 0L))
      {
        ae.e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat ID %d, key %d, value %d <0", new Object[] { Long.valueOf(localIDKey.GetID()), Long.valueOf(localIDKey.GetKey()), Long.valueOf(localIDKey.GetValue()) });
        AppMethodBeat.o(143895);
        return;
      }
    }
    if (ak.cpe())
    {
      d.d(paramArrayList, false);
      AppMethodBeat.o(143895);
      return;
    }
    KVCommCrossProcessReceiver.av(paramArrayList);
    AppMethodBeat.o(143895);
  }
  
  public final void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(143897);
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(paramInt1);
    localIDKey1.SetKey(paramInt2);
    localIDKey1.SetValue(paramInt4);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(paramInt1);
    localIDKey2.SetKey(paramInt3);
    localIDKey2.SetValue(1L);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localIDKey1);
    localArrayList.add(localIDKey2);
    b(localArrayList, false);
    AppMethodBeat.o(143897);
  }
  
  /* Error */
  public final boolean c(int paramInt, com.tencent.mm.bw.a parama)
  {
    // Byte code:
    //   0: ldc_w 599
    //   3: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: invokevirtual 603	java/lang/Object:getClass	()Ljava/lang/Class;
    //   10: ldc_w 605
    //   13: invokevirtual 611	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   16: aload_2
    //   17: ldc_w 612
    //   20: invokevirtual 618	java/lang/reflect/Field:setInt	(Ljava/lang/Object;I)V
    //   23: invokestatic 623	com/tencent/mm/sdk/platformtools/bu:fpO	()J
    //   26: lstore_3
    //   27: lload_3
    //   28: ldc2_w 624
    //   31: ldiv
    //   32: aload_0
    //   33: getfield 71	com/tencent/mm/plugin/report/service/g:yxJ	J
    //   36: lcmp
    //   37: ifeq +35 -> 72
    //   40: new 627	java/text/SimpleDateFormat
    //   43: dup
    //   44: ldc_w 629
    //   47: invokespecial 630	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   50: astore 8
    //   52: aload_0
    //   53: aload 8
    //   55: new 632	java/util/Date
    //   58: dup
    //   59: invokespecial 633	java/util/Date:<init>	()V
    //   62: invokevirtual 637	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   65: iconst_0
    //   66: invokestatic 641	com/tencent/mm/sdk/platformtools/bu:getInt	(Ljava/lang/String;I)I
    //   69: putfield 643	com/tencent/mm/plugin/report/service/g:yxK	I
    //   72: aload_2
    //   73: invokevirtual 603	java/lang/Object:getClass	()Ljava/lang/Class;
    //   76: ldc_w 645
    //   79: invokevirtual 611	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   82: aload_2
    //   83: aload_0
    //   84: getfield 643	com/tencent/mm/plugin/report/service/g:yxK	I
    //   87: invokevirtual 618	java/lang/reflect/Field:setInt	(Ljava/lang/Object;I)V
    //   90: aload_0
    //   91: getfield 378	com/tencent/mm/plugin/report/service/g:uin	I
    //   94: i2l
    //   95: lstore 5
    //   97: aload_2
    //   98: invokevirtual 603	java/lang/Object:getClass	()Ljava/lang/Class;
    //   101: ldc_w 647
    //   104: invokevirtual 611	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   107: aload_2
    //   108: lload 5
    //   110: ldc2_w 243
    //   113: land
    //   114: invokevirtual 651	java/lang/reflect/Field:setLong	(Ljava/lang/Object;J)V
    //   117: aload_2
    //   118: invokevirtual 603	java/lang/Object:getClass	()Ljava/lang/Class;
    //   121: ldc_w 653
    //   124: invokevirtual 611	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   127: aload_2
    //   128: iconst_2
    //   129: invokevirtual 618	java/lang/reflect/Field:setInt	(Ljava/lang/Object;I)V
    //   132: aload_2
    //   133: invokevirtual 603	java/lang/Object:getClass	()Ljava/lang/Class;
    //   136: ldc_w 655
    //   139: invokevirtual 611	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   142: aload_2
    //   143: getstatic 660	com/tencent/mm/protocal/d:FFH	I
    //   146: invokevirtual 618	java/lang/reflect/Field:setInt	(Ljava/lang/Object;I)V
    //   149: aload_2
    //   150: invokevirtual 603	java/lang/Object:getClass	()Ljava/lang/Class;
    //   153: ldc_w 662
    //   156: invokevirtual 611	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   159: aload_2
    //   160: lload_3
    //   161: invokevirtual 651	java/lang/reflect/Field:setLong	(Ljava/lang/Object;J)V
    //   164: aload_2
    //   165: invokevirtual 667	com/tencent/mm/bw/a:toByteArray	()[B
    //   168: astore_2
    //   169: invokestatic 77	com/tencent/mm/sdk/platformtools/ak:cpe	()Z
    //   172: ifeq +119 -> 291
    //   175: getstatic 420	com/tencent/mm/plugin/report/a/c:ywG	Z
    //   178: ifeq +64 -> 242
    //   181: iload_1
    //   182: i2l
    //   183: lstore_3
    //   184: getstatic 423	com/tencent/mm/plugin/report/a/c:ywH	Z
    //   187: istore 7
    //   189: lload_3
    //   190: aload_2
    //   191: iload 7
    //   193: iload 7
    //   195: invokestatic 670	com/tencent/mm/plugin/report/service/d:a	(J[BZZ)V
    //   198: ldc_w 599
    //   201: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   204: iconst_1
    //   205: ireturn
    //   206: astore_2
    //   207: ldc_w 342
    //   210: ldc_w 672
    //   213: iconst_2
    //   214: anewarray 263	java/lang/Object
    //   217: dup
    //   218: iconst_0
    //   219: iload_1
    //   220: invokestatic 268	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   223: aastore
    //   224: dup
    //   225: iconst_1
    //   226: aload_2
    //   227: invokevirtual 673	java/lang/Exception:toString	()Ljava/lang/String;
    //   230: aastore
    //   231: invokestatic 586	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: ldc_w 599
    //   237: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   240: iconst_0
    //   241: ireturn
    //   242: iload_1
    //   243: i2l
    //   244: lstore_3
    //   245: lload_3
    //   246: aload_2
    //   247: iconst_0
    //   248: iconst_0
    //   249: invokestatic 670	com/tencent/mm/plugin/report/service/d:a	(J[BZZ)V
    //   252: goto -54 -> 198
    //   255: astore_2
    //   256: ldc_w 342
    //   259: ldc_w 675
    //   262: iconst_2
    //   263: anewarray 263	java/lang/Object
    //   266: dup
    //   267: iconst_0
    //   268: iload_1
    //   269: invokestatic 268	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   272: aastore
    //   273: dup
    //   274: iconst_1
    //   275: aload_2
    //   276: invokevirtual 676	java/io/IOException:toString	()Ljava/lang/String;
    //   279: aastore
    //   280: invokestatic 586	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   283: ldc_w 599
    //   286: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: iconst_0
    //   290: ireturn
    //   291: ldc_w 342
    //   294: ldc_w 678
    //   297: invokestatic 680	com/tencent/mm/sdk/platformtools/ae:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   300: goto -102 -> 198
    //   303: astore 8
    //   305: goto -233 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	this	g
    //   0	308	1	paramInt	int
    //   0	308	2	parama	com.tencent.mm.bw.a
    //   26	220	3	l1	long
    //   95	14	5	l2	long
    //   187	7	7	bool	boolean
    //   50	4	8	localSimpleDateFormat	java.text.SimpleDateFormat
    //   303	1	8	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   6	52	206	java/lang/Exception
    //   72	164	206	java/lang/Exception
    //   164	181	255	java/io/IOException
    //   184	198	255	java/io/IOException
    //   245	252	255	java/io/IOException
    //   291	300	255	java/io/IOException
    //   52	72	303	java/lang/Exception
  }
  
  public final void dD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143893);
    n(paramInt1, paramInt2, 1L);
    AppMethodBeat.o(143893);
  }
  
  public final void f(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143886);
    if (com.tencent.mm.plugin.report.a.c.ywG)
    {
      boolean bool = com.tencent.mm.plugin.report.a.c.ywH;
      a(paramInt, bool, bool, paramVarArgs);
      AppMethodBeat.o(143886);
      return;
    }
    a(paramInt, false, false, paramVarArgs);
    AppMethodBeat.o(143886);
  }
  
  public final void g(String paramString1, final String paramString2, final Map<String, Object> paramMap)
  {
    AppMethodBeat.i(143901);
    a(paramString1, new Callable() {});
    AppMethodBeat.o(143901);
  }
  
  public final void idkeyStat(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    AppMethodBeat.i(143894);
    if ((paramLong1 < 0L) || (paramLong2 < 0L) || (paramLong3 <= 0L))
    {
      ae.e("MicroMsg.ReportManagerKvCheck", "ID %d, key %d, value %d <0", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(143894);
      return;
    }
    if (ak.cpe())
    {
      d.b(paramLong1, paramLong2, paramLong3, false);
      AppMethodBeat.o(143894);
      return;
    }
    m(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(143894);
  }
  
  public final void jd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224446);
    g(paramString1, paramString2, null);
    AppMethodBeat.o(224446);
  }
  
  public final void kvStat(int paramInt, String paramString)
  {
    AppMethodBeat.i(143882);
    if (com.tencent.mm.plugin.report.a.c.ywG)
    {
      boolean bool = com.tencent.mm.plugin.report.a.c.ywH;
      a(paramInt, paramString, bool, bool);
      AppMethodBeat.o(143882);
      return;
    }
    a(paramInt, paramString, false, false);
    AppMethodBeat.o(143882);
  }
  
  public final void n(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(143892);
    idkeyStat(paramLong1, paramLong2, paramLong3, false);
    AppMethodBeat.o(143892);
  }
  
  public final void setUin(int paramInt)
  {
    AppMethodBeat.i(143904);
    this.uin = paramInt;
    SmcLogic.setUin(paramInt);
    AppMethodBeat.o(143904);
  }
  
  public final void x(String paramString, final List<String> paramList)
  {
    AppMethodBeat.i(143902);
    a(paramString, new Callable() {});
    AppMethodBeat.o(143902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.g
 * JD-Core Version:    0.7.0.1
 */