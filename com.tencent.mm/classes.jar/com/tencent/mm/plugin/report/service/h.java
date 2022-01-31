package com.tencent.mm.plugin.report.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.smc.IDKey;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.mv;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.ag;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.File;
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

public enum h
  implements com.tencent.mm.plugin.report.d
{
  private long qsV;
  private int qsW;
  private HashMap<String, Long> qsX;
  private int qsY;
  private int qsZ;
  private long qta;
  private volatile boolean qtb;
  private int uin;
  
  static
  {
    AppMethodBeat.i(72793);
    qsU = new h("INSTANCE");
    qtc = new h[] { qsU };
    AppMethodBeat.o(72793);
  }
  
  private h()
  {
    AppMethodBeat.i(72763);
    this.qsV = 0L;
    if (ah.brt())
    {
      com.tencent.mm.kernel.g.RO().ac(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(72751);
          h.a(h.this);
          AppMethodBeat.o(72751);
        }
      });
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(72752);
          h.b(h.this);
          AppMethodBeat.o(72752);
        }
      };
      com.tencent.mm.sdk.b.a.ymk.b(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.kernel.g.Rc().a(701, new com.tencent.mm.ai.f()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
        {
          AppMethodBeat.i(72755);
          if (paramAnonymousInt1 != 0)
          {
            AppMethodBeat.o(72755);
            return;
          }
          com.tencent.mm.kernel.g.RO().o(this.qte, 5000L);
          AppMethodBeat.o(72755);
        }
      });
    }
    AppMethodBeat.o(72763);
  }
  
  public static Object a(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(72764);
    paramArrayOfInt = com.tencent.mm.plugin.report.e.a(paramInt1, paramArrayOfInt, paramInt2, paramInt3);
    AppMethodBeat.o(72764);
    return paramArrayOfInt;
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(72767);
    KVReportDataInfo localKVReportDataInfo = new KVReportDataInfo();
    localKVReportDataInfo.qsF = paramInt1;
    localKVReportDataInfo.value = paramString;
    localKVReportDataInfo.cnw = paramInt2;
    localKVReportDataInfo.qsi = false;
    localKVReportDataInfo.qsG = paramBoolean1;
    localKVReportDataInfo.qsH = paramBoolean2;
    KVCommCrossProcessReceiver.a(localKVReportDataInfo);
    AppMethodBeat.o(72767);
  }
  
  private static void a(int paramInt, List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(72776);
    paramList = cQ(paramList);
    if (ah.brt())
    {
      e.a(paramInt, paramList, paramBoolean, false, false);
      AppMethodBeat.o(72776);
      return;
    }
    b(paramInt, paramList, paramBoolean, false);
    AppMethodBeat.o(72776);
  }
  
  private void a(final String paramString, final Callable<JSONArray> paramCallable)
  {
    AppMethodBeat.i(72788);
    final long l = System.currentTimeMillis();
    if (!aB(paramString, l))
    {
      AppMethodBeat.o(72788);
      return;
    }
    com.tencent.mm.sdk.g.d.post(new Runnable()
    {
      public final void run()
      {
        Object localObject1 = null;
        AppMethodBeat.i(72758);
        int i;
        if ((ah.brt()) && (com.tencent.mm.kernel.g.RG()))
        {
          com.tencent.mm.kernel.g.RJ();
          i = com.tencent.mm.kernel.a.getUin();
          if (com.tencent.mm.kernel.g.RL().Ru() != null) {}
        }
        try
        {
          for (;;)
          {
            localObject3 = ah.getContext().getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com");
            localObject2 = (JSONArray)paramCallable.call();
            int k = ((JSONArray)localObject2).length();
            j = 0;
            while (j < k)
            {
              localObject4 = ((JSONArray)localObject2).getJSONObject(j);
              ((JSONObject)localObject4).put("tag", paramString);
              ((JSONObject)localObject4).put("uin", i);
              j += 1;
            }
            localObject1 = com.tencent.mm.model.r.Zn();
            continue;
            localObject1 = null;
            i = 0;
          }
          Object localObject2 = new JSONObject().put("head", new JSONObject().put("protocol_ver", 1).put("phone", com.tencent.mm.protocal.d.DEVICE_NAME).put("os_ver", com.tencent.mm.protocal.d.eQs).put("report_time", l).put("revision", bo.nullAsNil(com.tencent.mm.sdk.platformtools.f.REV))).put("items", localObject2).toString().getBytes();
          int j = localObject2.length;
          Object localObject4 = com.tencent.mm.a.g.w(String.format("weixin#$()%d%d", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.whH), Integer.valueOf(j) }).getBytes()).toLowerCase();
          byte[] arrayOfByte = com.tencent.mm.a.r.compress((byte[])localObject2);
          localObject2 = new PByteArray();
          com.tencent.mm.a.c.a((PByteArray)localObject2, arrayOfByte, ((String)localObject4).getBytes());
          Object localObject3 = new StringBuilder(256).append("http://").append((String)localObject3).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(com.tencent.mm.protocal.d.whH)).append("&devicetype=").append(com.tencent.mm.protocal.d.eQs).append("&filelength=").append(j).append("&sum=").append((String)localObject4).append("&reporttype=1&NewReportType=110");
          if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
            ((StringBuilder)localObject3).append("&username=").append((String)localObject1);
          }
          if (i != 0) {
            ((StringBuilder)localObject3).append("&uin=").append(i);
          }
          localObject3 = ((StringBuilder)localObject3).toString();
          localObject1 = new DefaultHttpClient();
          localObject3 = new HttpPost((String)localObject3);
          localObject2 = new ByteArrayEntity(((PByteArray)localObject2).value);
          ((ByteArrayEntity)localObject2).setContentType("binary/octet-stream");
          ((HttpPost)localObject3).setEntity((HttpEntity)localObject2);
          ab.i("MicroMsg.cLog", "POST returned: ".concat(String.valueOf(bo.convertStreamToString(((HttpClient)localObject1).execute((HttpUriRequest)localObject3).getEntity().getContent()))));
          AppMethodBeat.o(72758);
          return;
        }
        catch (Exception localException)
        {
          ab.printErrStackTrace("MicroMsg.ReportManagerKvCheck", localException, "Failed to upload cLog.", new Object[0]);
          AppMethodBeat.o(72758);
        }
      }
    }, "ReportManager_cLog");
    AppMethodBeat.o(72788);
  }
  
  private boolean aB(String paramString, long paramLong)
  {
    AppMethodBeat.i(72790);
    if (bp.dud())
    {
      ab.d("MicroMsg.cLog", "[%s] Sampling hit: (debug)", new Object[] { paramString });
      AppMethodBeat.o(72790);
      return true;
    }
    Long localLong;
    boolean bool;
    if (this.qsX != null)
    {
      localLong = (Long)this.qsX.get(paramString);
      if (localLong == null) {
        break label333;
      }
      localObject = com.tencent.mm.a.g.x((paramString + this.uin + paramLong).getBytes());
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
      ab.d("MicroMsg.cLog", "[%s] Sampling %s: 0x%08x / 0x%08x", new Object[] { paramString, localObject, Long.valueOf(paramLong), localLong });
      AppMethodBeat.o(72790);
      return bool;
      localLong = null;
      break;
      bool = false;
      break label261;
    }
    label333:
    ab.d("MicroMsg.cLog", "[%s] Sampling hit: (default)", new Object[] { paramString });
    AppMethodBeat.o(72790);
    return true;
  }
  
  private static void b(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(72768);
    KVReportDataInfo localKVReportDataInfo = new KVReportDataInfo();
    localKVReportDataInfo.qsF = paramInt;
    localKVReportDataInfo.value = paramString;
    localKVReportDataInfo.cnw = 0L;
    localKVReportDataInfo.qsi = false;
    localKVReportDataInfo.qsG = paramBoolean1;
    localKVReportDataInfo.qsH = paramBoolean2;
    KVCommCrossProcessReceiver.a(localKVReportDataInfo);
    AppMethodBeat.o(72768);
  }
  
  public static void c(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(155834);
    if (ah.brt())
    {
      if (com.tencent.mm.plugin.report.a.c.qrL)
      {
        long l = paramInt;
        paramBoolean1 = com.tencent.mm.plugin.report.a.c.qrM;
        e.a(l, paramString, paramBoolean1, paramBoolean1, paramBoolean2);
        AppMethodBeat.o(155834);
        return;
      }
      e.a(paramInt, paramString, paramBoolean1, false, paramBoolean2);
      AppMethodBeat.o(155834);
      return;
    }
    b(paramInt, paramString, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(155834);
  }
  
  private static String cQ(List<String> paramList)
  {
    AppMethodBeat.i(72766);
    if ((paramList == null) || (paramList.isEmpty())) {
      ab.w("MicroMsg.ReportManagerKvCheck", "vals is null, use '' as value");
    }
    StringBuilder localStringBuilder;
    for (paramList = "";; paramList = localStringBuilder.toString())
    {
      AppMethodBeat.o(72766);
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
  
  public static void chS()
  {
    AppMethodBeat.i(72784);
    if (ah.brt())
    {
      BaseEvent.onSingalCrash(0);
      AppMethodBeat.o(72784);
      return;
    }
    KVCommCrossProcessReceiver.chM();
    AppMethodBeat.o(72784);
  }
  
  public static void g(int paramInt, List<String> paramList)
  {
    AppMethodBeat.i(72775);
    if (com.tencent.mm.plugin.report.a.c.qrL)
    {
      a(paramInt, paramList, com.tencent.mm.plugin.report.a.c.qrM);
      AppMethodBeat.o(72775);
      return;
    }
    a(paramInt, paramList, false);
    AppMethodBeat.o(72775);
  }
  
  private static void i(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(72769);
    StIDKeyDataInfo localStIDKeyDataInfo = new StIDKeyDataInfo();
    localStIDKeyDataInfo.ltw = paramLong1;
    localStIDKeyDataInfo.key = paramLong2;
    localStIDKeyDataInfo.value = paramLong3;
    localStIDKeyDataInfo.qsi = false;
    KVCommCrossProcessReceiver.a(localStIDKeyDataInfo);
    AppMethodBeat.o(72769);
  }
  
  public static String t(Object... paramVarArgs)
  {
    AppMethodBeat.i(72765);
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      ab.w("MicroMsg.ReportManagerKvCheck", "vals is null, use '' as value");
    }
    StringBuilder localStringBuilder;
    for (paramVarArgs = "";; paramVarArgs = localStringBuilder.toString())
    {
      AppMethodBeat.o(72765);
      return paramVarArgs;
      localStringBuilder = new StringBuilder();
      int j = paramVarArgs.length - 1;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(String.valueOf(paramVarArgs[i]).replace(',', ' ')).append(',');
        i += 1;
      }
      localStringBuilder.append(String.valueOf(paramVarArgs[j]));
    }
  }
  
  public final void B(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(156764);
    j(paramLong1, paramLong2, 1L);
    AppMethodBeat.o(156764);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
  {
    AppMethodBeat.i(72781);
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
    AppMethodBeat.o(72781);
  }
  
  public final void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(72771);
    if (ah.brt())
    {
      if (com.tencent.mm.plugin.report.a.c.qrL)
      {
        long l = paramInt;
        paramBoolean1 = com.tencent.mm.plugin.report.a.c.qrM;
        e.a(l, paramString, paramBoolean1, paramBoolean1, false);
        AppMethodBeat.o(72771);
        return;
      }
      e.a(paramInt, paramString, paramBoolean1, false, false);
      AppMethodBeat.o(72771);
      return;
    }
    b(paramInt, paramString, paramBoolean1, false);
    AppMethodBeat.o(72771);
  }
  
  public final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, Object... paramVarArgs)
  {
    AppMethodBeat.i(72773);
    paramVarArgs = t(paramVarArgs);
    if (b.dsf()) {
      ab.v("MicroMsg.ReportManagerKvCheck", "kvTypedStat id:%d [%b,%b] val:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.FALSE, paramVarArgs });
    }
    if (ah.brt())
    {
      e.a(paramInt, paramVarArgs, paramBoolean1, false, false);
      AppMethodBeat.o(72773);
      return;
    }
    b(paramInt, paramVarArgs, paramBoolean1, false);
    AppMethodBeat.o(72773);
  }
  
  public final void af(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(72783);
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
    AppMethodBeat.o(72783);
  }
  
  public final void b(ArrayList<IDKey> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(72780);
    if (paramArrayList == null)
    {
      ab.e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat lstIdKeyDataInfos == null return");
      AppMethodBeat.o(72780);
      return;
    }
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      IDKey localIDKey = (IDKey)localIterator.next();
      if (localIDKey == null)
      {
        ab.e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat info == null return");
        AppMethodBeat.o(72780);
        return;
      }
      if ((localIDKey.GetID() < 0L) || (localIDKey.GetKey() < 0L) || (localIDKey.GetValue() <= 0L))
      {
        ab.e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat ID %d, key %d, value %d <0", new Object[] { Long.valueOf(localIDKey.GetID()), Long.valueOf(localIDKey.GetKey()), Long.valueOf(localIDKey.GetValue()) });
        AppMethodBeat.o(72780);
        return;
      }
    }
    if (ah.brt())
    {
      e.e(paramArrayList, false);
      AppMethodBeat.o(72780);
      return;
    }
    KVCommCrossProcessReceiver.O(paramArrayList);
    AppMethodBeat.o(72780);
  }
  
  /* Error */
  public final boolean c(int paramInt, com.tencent.mm.bv.a parama)
  {
    // Byte code:
    //   0: ldc_w 585
    //   3: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: invokevirtual 589	java/lang/Object:getClass	()Ljava/lang/Class;
    //   10: ldc_w 591
    //   13: invokevirtual 597	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   16: aload_2
    //   17: ldc_w 598
    //   20: invokevirtual 604	java/lang/reflect/Field:setInt	(Ljava/lang/Object;I)V
    //   23: invokestatic 609	com/tencent/mm/sdk/platformtools/bo:aoy	()J
    //   26: lstore_3
    //   27: lload_3
    //   28: ldc2_w 610
    //   31: ldiv
    //   32: aload_0
    //   33: getfield 71	com/tencent/mm/plugin/report/service/h:qsV	J
    //   36: lcmp
    //   37: ifeq +35 -> 72
    //   40: new 613	java/text/SimpleDateFormat
    //   43: dup
    //   44: ldc_w 615
    //   47: invokespecial 616	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   50: astore 8
    //   52: aload_0
    //   53: aload 8
    //   55: new 618	java/util/Date
    //   58: dup
    //   59: invokespecial 619	java/util/Date:<init>	()V
    //   62: invokevirtual 623	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   65: iconst_0
    //   66: invokestatic 627	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   69: putfield 629	com/tencent/mm/plugin/report/service/h:qsW	I
    //   72: aload_2
    //   73: invokevirtual 589	java/lang/Object:getClass	()Ljava/lang/Class;
    //   76: ldc_w 631
    //   79: invokevirtual 597	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   82: aload_2
    //   83: aload_0
    //   84: getfield 629	com/tencent/mm/plugin/report/service/h:qsW	I
    //   87: invokevirtual 604	java/lang/reflect/Field:setInt	(Ljava/lang/Object;I)V
    //   90: aload_0
    //   91: getfield 345	com/tencent/mm/plugin/report/service/h:uin	I
    //   94: i2l
    //   95: lstore 5
    //   97: aload_2
    //   98: invokevirtual 589	java/lang/Object:getClass	()Ljava/lang/Class;
    //   101: ldc_w 633
    //   104: invokevirtual 597	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   107: aload_2
    //   108: lload 5
    //   110: ldc2_w 247
    //   113: land
    //   114: invokevirtual 637	java/lang/reflect/Field:setLong	(Ljava/lang/Object;J)V
    //   117: aload_2
    //   118: invokevirtual 589	java/lang/Object:getClass	()Ljava/lang/Class;
    //   121: ldc_w 639
    //   124: invokevirtual 597	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   127: aload_2
    //   128: iconst_2
    //   129: invokevirtual 604	java/lang/reflect/Field:setInt	(Ljava/lang/Object;I)V
    //   132: aload_2
    //   133: invokevirtual 589	java/lang/Object:getClass	()Ljava/lang/Class;
    //   136: ldc_w 641
    //   139: invokevirtual 597	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   142: aload_2
    //   143: getstatic 646	com/tencent/mm/protocal/d:whH	I
    //   146: invokevirtual 604	java/lang/reflect/Field:setInt	(Ljava/lang/Object;I)V
    //   149: aload_2
    //   150: invokevirtual 589	java/lang/Object:getClass	()Ljava/lang/Class;
    //   153: ldc_w 648
    //   156: invokevirtual 597	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   159: aload_2
    //   160: lload_3
    //   161: invokevirtual 637	java/lang/reflect/Field:setLong	(Ljava/lang/Object;J)V
    //   164: aload_2
    //   165: invokevirtual 653	com/tencent/mm/bv/a:toByteArray	()[B
    //   168: astore_2
    //   169: invokestatic 77	com/tencent/mm/sdk/platformtools/ah:brt	()Z
    //   172: ifeq +119 -> 291
    //   175: getstatic 409	com/tencent/mm/plugin/report/a/c:qrL	Z
    //   178: ifeq +64 -> 242
    //   181: iload_1
    //   182: i2l
    //   183: lstore_3
    //   184: getstatic 412	com/tencent/mm/plugin/report/a/c:qrM	Z
    //   187: istore 7
    //   189: lload_3
    //   190: aload_2
    //   191: iload 7
    //   193: iload 7
    //   195: invokestatic 656	com/tencent/mm/plugin/report/service/e:a	(J[BZZ)V
    //   198: ldc_w 585
    //   201: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   204: iconst_1
    //   205: ireturn
    //   206: astore_2
    //   207: ldc_w 389
    //   210: ldc_w 658
    //   213: iconst_2
    //   214: anewarray 267	java/lang/Object
    //   217: dup
    //   218: iconst_0
    //   219: iload_1
    //   220: invokestatic 272	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   223: aastore
    //   224: dup
    //   225: iconst_1
    //   226: aload_2
    //   227: invokevirtual 659	java/lang/Exception:toString	()Ljava/lang/String;
    //   230: aastore
    //   231: invokestatic 574	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: ldc_w 585
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
    //   249: invokestatic 656	com/tencent/mm/plugin/report/service/e:a	(J[BZZ)V
    //   252: goto -54 -> 198
    //   255: astore_2
    //   256: ldc_w 389
    //   259: ldc_w 661
    //   262: iconst_2
    //   263: anewarray 267	java/lang/Object
    //   266: dup
    //   267: iconst_0
    //   268: iload_1
    //   269: invokestatic 272	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   272: aastore
    //   273: dup
    //   274: iconst_1
    //   275: aload_2
    //   276: invokevirtual 662	java/io/IOException:toString	()Ljava/lang/String;
    //   279: aastore
    //   280: invokestatic 574	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   283: ldc_w 585
    //   286: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: iconst_0
    //   290: ireturn
    //   291: ldc_w 389
    //   294: ldc_w 664
    //   297: invokestatic 666	com/tencent/mm/sdk/platformtools/ab:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   300: goto -102 -> 198
    //   303: astore 8
    //   305: goto -233 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	this	h
    //   0	308	1	paramInt	int
    //   0	308	2	parama	com.tencent.mm.bv.a
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
  
  public final void cT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142695);
    j(paramInt1, paramInt2, 1L);
    AppMethodBeat.o(142695);
  }
  
  public final void d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(72782);
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
    AppMethodBeat.o(72782);
  }
  
  public final void e(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72772);
    if (com.tencent.mm.plugin.report.a.c.qrL)
    {
      boolean bool = com.tencent.mm.plugin.report.a.c.qrM;
      a(paramInt, bool, bool, paramVarArgs);
      AppMethodBeat.o(72772);
      return;
    }
    a(paramInt, false, false, paramVarArgs);
    AppMethodBeat.o(72772);
  }
  
  public final void g(String paramString1, final String paramString2, final Map<String, Object> paramMap)
  {
    AppMethodBeat.i(72786);
    a(paramString1, new Callable() {});
    AppMethodBeat.o(72786);
  }
  
  public final void ga(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156765);
    g(paramString1, paramString2, null);
    AppMethodBeat.o(156765);
  }
  
  public final void idkeyStat(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    AppMethodBeat.i(72779);
    if ((paramLong1 < 0L) || (paramLong2 < 0L) || (paramLong3 <= 0L))
    {
      ab.e("MicroMsg.ReportManagerKvCheck", "ID %d, key %d, value %d <0", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(72779);
      return;
    }
    if (ah.brt())
    {
      e.a(paramLong1, paramLong2, paramLong3, false);
      AppMethodBeat.o(72779);
      return;
    }
    i(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(72779);
  }
  
  public final void j(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(72778);
    idkeyStat(paramLong1, paramLong2, paramLong3, false);
    AppMethodBeat.o(72778);
  }
  
  public final void kvStat(int paramInt, String paramString)
  {
    AppMethodBeat.i(72770);
    if (com.tencent.mm.plugin.report.a.c.qrL)
    {
      boolean bool = com.tencent.mm.plugin.report.a.c.qrM;
      a(paramInt, paramString, bool, bool);
      AppMethodBeat.o(72770);
      return;
    }
    a(paramInt, paramString, false, false);
    AppMethodBeat.o(72770);
  }
  
  public final void r(String paramString, final List<String> paramList)
  {
    AppMethodBeat.i(72787);
    a(paramString, new Callable() {});
    AppMethodBeat.o(72787);
  }
  
  public final void setUin(int paramInt)
  {
    AppMethodBeat.i(72789);
    this.uin = paramInt;
    SmcLogic.setUin(paramInt);
    AppMethodBeat.o(72789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.h
 * JD-Core Version:    0.7.0.1
 */