package com.tencent.mm.plugin.report.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.smc.IDKey;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.md;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.ah;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  private long nFR = 0L;
  private int nFS;
  private HashMap<String, Long> nFT;
  private int nFU;
  private int nFV;
  private long nFW;
  private volatile boolean nFX;
  private int uin;
  
  private h()
  {
    if (ae.cqV())
    {
      com.tencent.mm.kernel.g.DS().O(new Runnable()
      {
        public final void run()
        {
          h.a(h.this);
        }
      });
      localObject = new Runnable()
      {
        public final void run()
        {
          h.b(h.this);
        }
      };
      com.tencent.mm.sdk.b.a.udP.b(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.kernel.g.Dk().a(701, new com.tencent.mm.ah.f()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
        {
          if (paramAnonymousInt1 != 0) {
            return;
          }
          com.tencent.mm.kernel.g.DS().k(this.nGa, 5000L);
        }
      });
    }
  }
  
  public static Object a(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3)
  {
    return com.tencent.mm.plugin.report.f.a(paramInt1, paramArrayOfInt, paramInt2, paramInt3);
  }
  
  private static void a(int paramInt, List<String> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      y.w("MicroMsg.ReportManagerKvCheck", "vals is null, use '' as value");
    }
    StringBuilder localStringBuilder;
    for (paramList = ""; ae.cqV(); paramList = localStringBuilder.toString())
    {
      e.a(paramInt, paramList, paramBoolean, false);
      return;
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
    g(paramInt, paramList, paramBoolean);
  }
  
  private void a(final String paramString, final Callable<JSONArray> paramCallable)
  {
    final long l1 = System.currentTimeMillis();
    Long localLong;
    Object localObject;
    int i;
    if (this.nFT != null)
    {
      localLong = (Long)this.nFT.get(paramString);
      if (localLong == null) {
        break label299;
      }
      localObject = com.tencent.mm.a.g.p((paramString + this.uin + l1).getBytes());
      if ((localObject == null) || (localObject.length != 16)) {
        break label299;
      }
      long l2 = localObject[0] + localObject[4] + localObject[8] + localObject[12];
      long l3 = localObject[1] + localObject[5] + localObject[9] + localObject[13];
      long l4 = localObject[2] + localObject[6] + localObject[10] + localObject[14];
      i = localObject[3];
      int j = localObject[7];
      int k = localObject[11];
      l2 = l2 & 0xFF | (l3 & 0xFF) << 8 | (l4 & 0xFF) << 16 | (localObject[15] + (i + j + k) & 0xFF) << 24;
      if (l2 >= localLong.longValue()) {
        break label286;
      }
      i = 1;
      label232:
      if (i == 0) {
        break label291;
      }
      localObject = "hit";
      label241:
      y.d("MicroMsg.cLog", "[%s] Sampling %s: 0x%08x / 0x%08x", new Object[] { paramString, localObject, Long.valueOf(l2), localLong });
    }
    for (;;)
    {
      if (i != 0) {
        break label320;
      }
      return;
      localLong = null;
      break;
      label286:
      i = 0;
      break label232;
      label291:
      localObject = "miss";
      break label241;
      label299:
      y.d("MicroMsg.cLog", "[%s] Sampling hit: (default)", new Object[] { paramString });
      i = 1;
    }
    label320:
    com.tencent.mm.sdk.f.e.post(new Runnable()
    {
      public final void run()
      {
        Object localObject1 = null;
        int i;
        if ((ae.cqV()) && (com.tencent.mm.kernel.g.DK()))
        {
          com.tencent.mm.kernel.g.DN();
          i = com.tencent.mm.kernel.a.CK();
          if (com.tencent.mm.kernel.g.DP().Dz() != null) {}
        }
        try
        {
          for (;;)
          {
            localObject3 = ae.getContext().getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com");
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
            localObject1 = com.tencent.mm.model.q.Gj();
            continue;
            localObject1 = null;
            i = 0;
          }
          Object localObject2 = new JSONObject().put("head", new JSONObject().put("protocol_ver", 1).put("phone", com.tencent.mm.protocal.d.DEVICE_NAME).put("os_ver", com.tencent.mm.protocal.d.dOM).put("report_time", l1).put("revision", bk.pm(com.tencent.mm.sdk.platformtools.d.REV))).put("items", localObject2).toString().getBytes();
          int j = localObject2.length;
          Object localObject4 = com.tencent.mm.a.g.o(String.format("weixin#$()%d%d", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.spa), Integer.valueOf(j) }).getBytes()).toLowerCase();
          byte[] arrayOfByte = com.tencent.mm.a.q.l((byte[])localObject2);
          localObject2 = new PByteArray();
          com.tencent.mm.a.c.a((PByteArray)localObject2, arrayOfByte, ((String)localObject4).getBytes());
          Object localObject3 = new StringBuilder(256).append("http://").append((String)localObject3).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(com.tencent.mm.protocal.d.spa)).append("&devicetype=").append(com.tencent.mm.protocal.d.dOM).append("&filelength=").append(j).append("&sum=").append((String)localObject4).append("&reporttype=1&NewReportType=110");
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
          localObject1 = bk.convertStreamToString(((HttpClient)localObject1).execute((HttpUriRequest)localObject3).getEntity().getContent());
          y.i("MicroMsg.cLog", "POST returned: " + (String)localObject1);
          return;
        }
        catch (Exception localException)
        {
          y.printErrStackTrace("MicroMsg.ReportManagerKvCheck", localException, "Failed to upload cLog.", new Object[0]);
        }
      }
    }, "ReportManager_cLog");
  }
  
  public static void bwZ()
  {
    if (ae.cqV())
    {
      BaseEvent.onSingalCrash(0);
      return;
    }
    KVCommCrossProcessReceiver.bwT();
  }
  
  public static void d(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    if (ae.cqV())
    {
      if (com.tencent.mm.plugin.report.a.c.nEJ)
      {
        e.a(paramInt1, paramInt2, paramString, com.tencent.mm.plugin.report.a.c.nEK, com.tencent.mm.plugin.report.a.c.nEK);
        return;
      }
      e.a(paramInt1, paramInt2, paramString, paramBoolean, false);
      return;
    }
    KVReportDataInfo localKVReportDataInfo = new KVReportDataInfo();
    localKVReportDataInfo.nFC = paramInt1;
    localKVReportDataInfo.value = paramString;
    localKVReportDataInfo.bGn = paramInt2;
    localKVReportDataInfo.nFg = false;
    localKVReportDataInfo.nFD = paramBoolean;
    KVCommCrossProcessReceiver.a(localKVReportDataInfo);
  }
  
  public static void f(int paramInt, List<String> paramList)
  {
    if (com.tencent.mm.plugin.report.a.c.nEJ)
    {
      a(paramInt, paramList, com.tencent.mm.plugin.report.a.c.nEK);
      return;
    }
    a(paramInt, paramList, false);
  }
  
  private static void g(int paramInt, String paramString, boolean paramBoolean)
  {
    KVReportDataInfo localKVReportDataInfo = new KVReportDataInfo();
    localKVReportDataInfo.nFC = paramInt;
    localKVReportDataInfo.value = paramString;
    localKVReportDataInfo.bGn = 0L;
    localKVReportDataInfo.nFg = false;
    localKVReportDataInfo.nFD = paramBoolean;
    KVCommCrossProcessReceiver.a(localKVReportDataInfo);
  }
  
  public static String o(Object... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0))
    {
      y.w("MicroMsg.ReportManagerKvCheck", "vals is null, use '' as value");
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramVarArgs.length - 1;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(String.valueOf(paramVarArgs[i]).replace(',', ' ')).append(',');
      i += 1;
    }
    localStringBuilder.append(String.valueOf(paramVarArgs[j]));
    return localStringBuilder.toString();
  }
  
  public final void U(int paramInt1, int paramInt2, int paramInt3)
  {
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
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
  {
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
  }
  
  public final void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (ae.cqV())
    {
      if (com.tencent.mm.plugin.report.a.c.nEJ)
      {
        e.a(paramInt, paramString, com.tencent.mm.plugin.report.a.c.nEK, com.tencent.mm.plugin.report.a.c.nEK);
        return;
      }
      e.a(paramInt, paramString, paramBoolean1, false);
      return;
    }
    g(paramInt, paramString, paramBoolean1);
  }
  
  public final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, Object... paramVarArgs)
  {
    paramVarArgs = o(paramVarArgs);
    if (b.cqk()) {
      y.v("MicroMsg.ReportManagerKvCheck", "kvTypedStat id:%d [%b,%b] val:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.valueOf(false), paramVarArgs });
    }
    if (ae.cqV())
    {
      e.a(paramInt, paramVarArgs, paramBoolean1, false);
      return;
    }
    g(paramInt, paramVarArgs, paramBoolean1);
  }
  
  public final void a(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    if ((paramLong1 < 0L) || (paramLong2 < 0L) || (paramLong3 <= 0L))
    {
      y.e("MicroMsg.ReportManagerKvCheck", "ID %d, key %d, value %d <0", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      return;
    }
    if (ae.cqV())
    {
      e.b(paramLong1, paramLong2, paramLong3, false);
      return;
    }
    StIDKeyDataInfo localStIDKeyDataInfo = new StIDKeyDataInfo();
    localStIDKeyDataInfo.nGh = paramLong1;
    localStIDKeyDataInfo.key = paramLong2;
    localStIDKeyDataInfo.value = paramLong3;
    localStIDKeyDataInfo.nFg = false;
    KVCommCrossProcessReceiver.a(localStIDKeyDataInfo);
  }
  
  public final void aC(int paramInt, String paramString)
  {
    if (com.tencent.mm.plugin.report.a.c.nEJ)
    {
      a(paramInt, paramString, com.tencent.mm.plugin.report.a.c.nEK, com.tencent.mm.plugin.report.a.c.nEK);
      return;
    }
    a(paramInt, paramString, false, false);
  }
  
  public final void b(ArrayList<IDKey> paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList == null)
    {
      y.e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat lstIdKeyDataInfos == null return");
      return;
    }
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      IDKey localIDKey = (IDKey)localIterator.next();
      if (localIDKey == null)
      {
        y.e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat info == null return");
        return;
      }
      if ((localIDKey.GetID() < 0L) || (localIDKey.GetKey() < 0L) || (localIDKey.GetValue() <= 0L))
      {
        y.e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat ID %d, key %d, value %d <0", new Object[] { Long.valueOf(localIDKey.GetID()), Long.valueOf(localIDKey.GetKey()), Long.valueOf(localIDKey.GetValue()) });
        return;
      }
    }
    if (ae.cqV())
    {
      e.c(paramArrayList, false);
      return;
    }
    KVCommCrossProcessReceiver.M(paramArrayList);
  }
  
  /* Error */
  public final boolean c(int paramInt, com.tencent.mm.bv.a parama)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 540	java/lang/Object:getClass	()Ljava/lang/Class;
    //   4: ldc_w 542
    //   7: invokevirtual 548	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   10: aload_2
    //   11: ldc_w 549
    //   14: invokevirtual 555	java/lang/reflect/Field:setInt	(Ljava/lang/Object;I)V
    //   17: invokestatic 560	com/tencent/mm/sdk/platformtools/bk:UY	()J
    //   20: lstore_3
    //   21: lload_3
    //   22: ldc2_w 561
    //   25: ldiv
    //   26: aload_0
    //   27: getfield 60	com/tencent/mm/plugin/report/service/h:nFR	J
    //   30: lcmp
    //   31: ifeq +35 -> 66
    //   34: new 564	java/text/SimpleDateFormat
    //   37: dup
    //   38: ldc_w 566
    //   41: invokespecial 567	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   44: astore 7
    //   46: aload_0
    //   47: aload 7
    //   49: new 569	java/util/Date
    //   52: dup
    //   53: invokespecial 570	java/util/Date:<init>	()V
    //   56: invokevirtual 574	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   59: iconst_0
    //   60: invokestatic 578	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   63: putfield 580	com/tencent/mm/plugin/report/service/h:nFS	I
    //   66: aload_2
    //   67: invokevirtual 540	java/lang/Object:getClass	()Ljava/lang/Class;
    //   70: ldc_w 582
    //   73: invokevirtual 548	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   76: aload_2
    //   77: aload_0
    //   78: getfield 580	com/tencent/mm/plugin/report/service/h:nFS	I
    //   81: invokevirtual 555	java/lang/reflect/Field:setInt	(Ljava/lang/Object;I)V
    //   84: aload_0
    //   85: getfield 303	com/tencent/mm/plugin/report/service/h:uin	I
    //   88: i2l
    //   89: lstore 5
    //   91: aload_2
    //   92: invokevirtual 540	java/lang/Object:getClass	()Ljava/lang/Class;
    //   95: ldc_w 584
    //   98: invokevirtual 548	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   101: aload_2
    //   102: lload 5
    //   104: ldc2_w 240
    //   107: land
    //   108: invokevirtual 588	java/lang/reflect/Field:setLong	(Ljava/lang/Object;J)V
    //   111: aload_2
    //   112: invokevirtual 540	java/lang/Object:getClass	()Ljava/lang/Class;
    //   115: ldc_w 590
    //   118: invokevirtual 548	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   121: aload_2
    //   122: iconst_2
    //   123: invokevirtual 555	java/lang/reflect/Field:setInt	(Ljava/lang/Object;I)V
    //   126: aload_2
    //   127: invokevirtual 540	java/lang/Object:getClass	()Ljava/lang/Class;
    //   130: ldc_w 592
    //   133: invokevirtual 548	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   136: aload_2
    //   137: getstatic 597	com/tencent/mm/protocal/d:spa	I
    //   140: invokevirtual 555	java/lang/reflect/Field:setInt	(Ljava/lang/Object;I)V
    //   143: aload_2
    //   144: invokevirtual 540	java/lang/Object:getClass	()Ljava/lang/Class;
    //   147: ldc_w 599
    //   150: invokevirtual 548	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   153: aload_2
    //   154: lload_3
    //   155: invokevirtual 588	java/lang/reflect/Field:setLong	(Ljava/lang/Object;J)V
    //   158: aload_2
    //   159: invokevirtual 604	com/tencent/mm/bv/a:toByteArray	()[B
    //   162: astore_2
    //   163: invokestatic 66	com/tencent/mm/sdk/platformtools/ae:cqV	()Z
    //   166: ifeq +93 -> 259
    //   169: getstatic 383	com/tencent/mm/plugin/report/a/c:nEJ	Z
    //   172: ifeq +46 -> 218
    //   175: iload_1
    //   176: i2l
    //   177: aload_2
    //   178: getstatic 386	com/tencent/mm/plugin/report/a/c:nEK	Z
    //   181: getstatic 386	com/tencent/mm/plugin/report/a/c:nEK	Z
    //   184: invokestatic 607	com/tencent/mm/plugin/report/service/e:a	(J[BZZ)V
    //   187: iconst_1
    //   188: ireturn
    //   189: astore_2
    //   190: ldc 123
    //   192: ldc_w 609
    //   195: iconst_2
    //   196: anewarray 261	java/lang/Object
    //   199: dup
    //   200: iconst_0
    //   201: iload_1
    //   202: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   205: aastore
    //   206: dup
    //   207: iconst_1
    //   208: aload_2
    //   209: invokevirtual 610	java/lang/Exception:toString	()Ljava/lang/String;
    //   212: aastore
    //   213: invokestatic 487	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   216: iconst_0
    //   217: ireturn
    //   218: iload_1
    //   219: i2l
    //   220: lstore_3
    //   221: lload_3
    //   222: aload_2
    //   223: iconst_0
    //   224: iconst_0
    //   225: invokestatic 607	com/tencent/mm/plugin/report/service/e:a	(J[BZZ)V
    //   228: iconst_1
    //   229: ireturn
    //   230: astore_2
    //   231: ldc 123
    //   233: ldc_w 612
    //   236: iconst_2
    //   237: anewarray 261	java/lang/Object
    //   240: dup
    //   241: iconst_0
    //   242: iload_1
    //   243: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   246: aastore
    //   247: dup
    //   248: iconst_1
    //   249: aload_2
    //   250: invokevirtual 613	java/io/IOException:toString	()Ljava/lang/String;
    //   253: aastore
    //   254: invokestatic 487	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   257: iconst_0
    //   258: ireturn
    //   259: ldc 123
    //   261: ldc_w 615
    //   264: invokestatic 617	com/tencent/mm/sdk/platformtools/y:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   267: iconst_1
    //   268: ireturn
    //   269: astore 7
    //   271: goto -205 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	this	h
    //   0	274	1	paramInt	int
    //   0	274	2	parama	com.tencent.mm.bv.a
    //   20	202	3	l1	long
    //   89	14	5	l2	long
    //   44	4	7	localSimpleDateFormat	java.text.SimpleDateFormat
    //   269	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	46	189	java/lang/Exception
    //   66	158	189	java/lang/Exception
    //   158	187	230	java/io/IOException
    //   221	228	230	java/io/IOException
    //   259	267	230	java/io/IOException
    //   46	66	269	java/lang/Exception
  }
  
  public final void d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
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
  }
  
  public final void d(String paramString1, final String paramString2, final Map<String, Object> paramMap)
  {
    a(paramString1, new Callable() {});
  }
  
  public final void ez(String paramString1, String paramString2)
  {
    d(paramString1, paramString2, null);
  }
  
  public final void f(int paramInt, Object... paramVarArgs)
  {
    if (com.tencent.mm.plugin.report.a.c.nEJ)
    {
      a(paramInt, com.tencent.mm.plugin.report.a.c.nEK, com.tencent.mm.plugin.report.a.c.nEK, paramVarArgs);
      return;
    }
    a(paramInt, false, false, paramVarArgs);
  }
  
  public final void fn(int paramInt)
  {
    this.uin = paramInt;
    SmcLogic.setUin(paramInt);
  }
  
  public final void fy(long paramLong)
  {
    h(933L, paramLong, 1L);
  }
  
  public final void h(long paramLong1, long paramLong2, long paramLong3)
  {
    a(paramLong1, paramLong2, paramLong3, false);
  }
  
  public final void q(String paramString, final List<String> paramList)
  {
    a(paramString, new Callable() {});
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.h
 * JD-Core Version:    0.7.0.1
 */