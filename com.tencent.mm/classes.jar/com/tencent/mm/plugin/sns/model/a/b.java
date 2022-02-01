package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.b.p;
import com.tencent.mm.memory.n;
import com.tencent.mm.network.b.b;
import com.tencent.mm.network.v;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.az;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bf;
import com.tencent.mm.vfs.i;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public abstract class b
  extends c
{
  private static HashSet<String> xYw = new HashSet();
  private int bSY = 0;
  private long dnsCostTime = -1L;
  protected btz dwE = null;
  private String host = "";
  private int ili = -1;
  private int retCode = -1;
  protected c.a xYd;
  protected n xYe = null;
  protected a xYf = null;
  private String xYg = "";
  private String xYh = "";
  private String xYi = "";
  private int xYj = 0;
  protected int xYk = 0;
  private long xYl = -1L;
  protected long xYm = -1L;
  protected long xYn = -1L;
  protected long xYo = -1L;
  protected String xYp = "";
  protected PString xYq = new PString();
  protected int xYr;
  protected long xYs;
  protected long xYt;
  protected long xYu;
  protected int xYv = 0;
  private Map<String, List<String>> xYx;
  int xYy = 0;
  
  public b(c.a parama, a parama1)
  {
    super(parama, parama1);
    this.xYd = parama;
    this.xYf = parama1;
    if (parama1 == null) {
      return;
    }
    this.dwE = parama1.xRy;
    xYw.add(parama1.xRx);
    parama1.init();
  }
  
  private v a(b.b paramb, String paramString)
  {
    try
    {
      this.xYi = paramb.ip;
      this.ili = paramb.ili;
      this.xYm = bs.eWj();
      paramb = com.tencent.mm.network.b.a(this.xYf.url, paramb);
      paramb.setRequestMethod("GET");
      paramb.setRequestProperty("referer", paramString);
      if (bs.getInt(com.tencent.mm.m.g.ZY().getValue("SnsDownloadHttpKeep"), 0) > 0)
      {
        ac.i("MicroMsg.SnsCdnDownloadBase", "header Connection close ");
        paramb.setRequestProperty("Connection", "close");
      }
      paramb.setConnectTimeout(25000);
      paramb.setReadTimeout(25000);
      paramb = a(paramb);
      this.xYx = paramb.getHeaderFields();
      paramString = (List)this.xYx.get("X-ClientIp");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.xYh = ((String)paramString.get(0));
      }
      paramString = (List)this.xYx.get("X-ServerIp");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.xYg = ((String)paramString.get(0));
      }
      paramString = (List)this.xYx.get("X-ErrNo");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.xYj = bs.aLy((String)paramString.get(0));
      }
      paramString = (List)this.xYx.get("X-RtFlag");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.xYk = bs.aLy((String)paramString.get(0));
      }
      for (;;)
      {
        try
        {
          this.retCode = paramb.getResponseCode();
          this.host = paramb.url.getHost();
          if ((this.retCode == 200) || (this.retCode == 206)) {
            break;
          }
          aE(paramb.getHeaderFields());
          if (this.xYf.xXZ)
          {
            if ((this.retCode >= 400) && (this.retCode < 500))
            {
              h.wUl.idkeyStat(22L, 78L, 1L, true);
              if (this.xYf.xXY) {
                h.wUl.idkeyStat(150L, 14L, 1L, true);
              }
              ac.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! mediaId : " + this.xYf.mediaId + " " + this.xYf.url + " " + this.retCode);
              dd(false);
              return null;
            }
            if ((this.retCode < 500) || (this.retCode >= 600)) {
              continue;
            }
            h.wUl.idkeyStat(22L, 79L, 1L, true);
            continue;
          }
        }
        catch (SocketTimeoutException paramb)
        {
          this.retCode = 1;
          dd(false);
          paramb = paramb.getMessage();
          if (!this.xYf.xXZ) {
            break label780;
          }
          h.wUl.idkeyStat(22L, 77L, 1L, true);
          if (this.xYf.xXY) {
            h.wUl.idkeyStat(150L, 14L, 1L, true);
          }
          ac.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! socket timeout mediaId : " + this.xYf.mediaId + " " + this.xYf.url + " msg:" + paramb);
          return null;
          if ((this.retCode >= 400) && (this.retCode < 500))
          {
            h.wUl.idkeyStat(22L, 56L, 1L, true);
            continue;
          }
        }
        catch (Exception paramb)
        {
          dd(false);
          paramb = paramb.getMessage();
          if (this.xYf.xXY) {
            h.wUl.idkeyStat(150L, 14L, 1L, true);
          }
          ac.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! mediaId : " + this.xYf.mediaId + " " + this.xYf.url + " msg:" + paramb);
          return null;
        }
        if ((this.retCode >= 500) && (this.retCode < 600))
        {
          h.wUl.idkeyStat(22L, 57L, 1L, true);
          continue;
          label780:
          h.wUl.idkeyStat(22L, 55L, 1L, true);
        }
      }
      aE(paramb.getHeaderFields());
    }
    catch (Exception paramb)
    {
      ac.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", paramb, "connect fail : " + paramb.getMessage(), new Object[0]);
      this.retCode = 2;
      dd(false);
      return null;
    }
    if (!c(paramb))
    {
      h.wUl.idkeyStat(22L, 62L, 1L, true);
      ac.e("MicroMsg.SnsCdnDownloadBase", "checkHttpConnection failed! nocache mediaId : " + this.xYf.mediaId);
      dd(false);
      return null;
    }
    this.xYm = bs.Ap(this.xYm);
    paramString = (List)this.xYx.get("Content-Length");
    if ((paramString != null) && (paramString.size() > 0)) {
      this.xYv = bs.aLy((String)paramString.get(0));
    }
    ac.i("MicroMsg.SnsCdnDownloadBase", "ip: url %s client ip %s server ip %s svrlen %d %d", new Object[] { this.xYf.url, this.xYh, this.xYg, Integer.valueOf(this.xYv), Integer.valueOf(this.xYj) });
    return paramb;
  }
  
  protected static boolean a(int paramInt, long paramLong, PString paramPString)
  {
    long l = System.currentTimeMillis();
    if (l - paramLong < 1000L) {
      return false;
    }
    paramPString.value += String.format("ts=%d&size=%d|", new Object[] { Long.valueOf(l / 1000L), Integer.valueOf(paramInt) });
    return true;
  }
  
  private static void aE(Map<String, List<String>> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (String)localIterator.next();
        Object localObject2 = (List)paramMap.get(localObject1);
        if (localObject2 != null)
        {
          localStringBuffer.append((String)localObject1 + ":");
          localObject1 = ((List)localObject2).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            localStringBuffer.append((String)localObject2 + "|");
          }
          localStringBuffer.append(";");
        }
      }
      ac.i("MicroMsg.SnsCdnDownloadBase", "header respone %s", new Object[] { localStringBuffer.toString() });
      return;
    }
    catch (Exception paramMap) {}
  }
  
  private static long auq(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return 0L;
    }
    try
    {
      paramString = paramString.split("\\.");
      long l1 = bs.getLong(paramString[0], 0L);
      long l2 = bs.getLong(paramString[1], 0L);
      long l3 = bs.getLong(paramString[2], 0L);
      long l4 = bs.getLong(paramString[3], 0L);
      return l4 + (16777216L * l1 + 65536L * l2 + 256L * l3);
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  /* Error */
  private int b(v paramv)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokestatic 142	com/tencent/mm/sdk/platformtools/bs:eWj	()J
    //   7: putfield 447	com/tencent/mm/plugin/sns/model/a/b:xYu	J
    //   10: aload_1
    //   11: invokevirtual 451	com/tencent/mm/network/v:getInputStream	()Ljava/io/InputStream;
    //   14: astore_3
    //   15: aload_0
    //   16: invokestatic 142	com/tencent/mm/sdk/platformtools/bs:eWj	()J
    //   19: putfield 87	com/tencent/mm/plugin/sns/model/a/b:xYn	J
    //   22: aload_0
    //   23: aload_3
    //   24: invokevirtual 454	com/tencent/mm/plugin/sns/model/a/b:I	(Ljava/io/InputStream;)Z
    //   27: istore_2
    //   28: aload_3
    //   29: invokevirtual 458	java/io/InputStream:close	()V
    //   32: ldc 184
    //   34: ldc_w 460
    //   37: iload_2
    //   38: invokestatic 463	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   41: invokevirtual 466	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   44: invokestatic 191	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: iload_2
    //   48: ifne +18 -> 66
    //   51: aload_0
    //   52: iconst_0
    //   53: invokespecial 309	com/tencent/mm/plugin/sns/model/a/b:dd	(Z)V
    //   56: aload_1
    //   57: ifnull +7 -> 64
    //   60: aload_1
    //   61: invokevirtual 469	com/tencent/mm/network/v:disconnect	()V
    //   64: iconst_2
    //   65: ireturn
    //   66: aload_0
    //   67: aload_0
    //   68: getfield 87	com/tencent/mm/plugin/sns/model/a/b:xYn	J
    //   71: invokestatic 347	com/tencent/mm/sdk/platformtools/bs:Ap	(J)J
    //   74: putfield 87	com/tencent/mm/plugin/sns/model/a/b:xYn	J
    //   77: aload_0
    //   78: aload_0
    //   79: getfield 89	com/tencent/mm/plugin/sns/model/a/b:xYo	J
    //   82: invokestatic 347	com/tencent/mm/sdk/platformtools/bs:Ap	(J)J
    //   85: putfield 79	com/tencent/mm/plugin/sns/model/a/b:xYl	J
    //   88: aload_0
    //   89: invokevirtual 472	com/tencent/mm/plugin/sns/model/a/b:dIV	()Z
    //   92: istore_2
    //   93: ldc 184
    //   95: ldc_w 474
    //   98: iload_2
    //   99: invokestatic 463	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   102: invokevirtual 466	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   105: invokestatic 191	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: iload_2
    //   109: ifne +23 -> 132
    //   112: aload_0
    //   113: iconst_3
    //   114: putfield 98	com/tencent/mm/plugin/sns/model/a/b:retCode	I
    //   117: aload_0
    //   118: iconst_0
    //   119: invokespecial 309	com/tencent/mm/plugin/sns/model/a/b:dd	(Z)V
    //   122: aload_1
    //   123: ifnull -59 -> 64
    //   126: aload_1
    //   127: invokevirtual 469	com/tencent/mm/network/v:disconnect	()V
    //   130: iconst_2
    //   131: ireturn
    //   132: aload_1
    //   133: ifnull +7 -> 140
    //   136: aload_1
    //   137: invokevirtual 469	com/tencent/mm/network/v:disconnect	()V
    //   140: aload_0
    //   141: iconst_1
    //   142: invokespecial 309	com/tencent/mm/plugin/sns/model/a/b:dd	(Z)V
    //   145: aload_0
    //   146: getfield 61	com/tencent/mm/plugin/sns/model/a/b:xYf	Lcom/tencent/mm/plugin/sns/model/a/a;
    //   149: getfield 277	com/tencent/mm/plugin/sns/model/a/a:xXY	Z
    //   152: ifeq +124 -> 276
    //   155: iconst_3
    //   156: ireturn
    //   157: astore 4
    //   159: aconst_null
    //   160: astore_3
    //   161: ldc 184
    //   163: aload 4
    //   165: new 283	java/lang/StringBuilder
    //   168: dup
    //   169: ldc_w 476
    //   172: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   175: aload 4
    //   177: invokevirtual 323	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   180: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: iconst_0
    //   187: anewarray 331	java/lang/Object
    //   190: invokestatic 335	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   193: aload_0
    //   194: iconst_4
    //   195: putfield 98	com/tencent/mm/plugin/sns/model/a/b:retCode	I
    //   198: aload_0
    //   199: iconst_0
    //   200: invokespecial 309	com/tencent/mm/plugin/sns/model/a/b:dd	(Z)V
    //   203: aload_3
    //   204: ifnull +7 -> 211
    //   207: aload_3
    //   208: invokevirtual 458	java/io/InputStream:close	()V
    //   211: aload_1
    //   212: ifnull -148 -> 64
    //   215: aload_1
    //   216: invokevirtual 469	com/tencent/mm/network/v:disconnect	()V
    //   219: iconst_2
    //   220: ireturn
    //   221: astore_3
    //   222: ldc 184
    //   224: aload_3
    //   225: ldc 65
    //   227: iconst_0
    //   228: anewarray 331	java/lang/Object
    //   231: invokestatic 335	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: goto -23 -> 211
    //   237: astore_3
    //   238: aload 4
    //   240: ifnull +8 -> 248
    //   243: aload 4
    //   245: invokevirtual 458	java/io/InputStream:close	()V
    //   248: aload_1
    //   249: ifnull +7 -> 256
    //   252: aload_1
    //   253: invokevirtual 469	com/tencent/mm/network/v:disconnect	()V
    //   256: aload_3
    //   257: athrow
    //   258: astore 4
    //   260: ldc 184
    //   262: aload 4
    //   264: ldc 65
    //   266: iconst_0
    //   267: anewarray 331	java/lang/Object
    //   270: invokestatic 335	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   273: goto -25 -> 248
    //   276: iconst_1
    //   277: ireturn
    //   278: astore 5
    //   280: aload_3
    //   281: astore 4
    //   283: aload 5
    //   285: astore_3
    //   286: goto -48 -> 238
    //   289: astore 5
    //   291: aload_3
    //   292: astore 4
    //   294: aload 5
    //   296: astore_3
    //   297: goto -59 -> 238
    //   300: astore 4
    //   302: goto -141 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	this	b
    //   0	305	1	paramv	v
    //   27	82	2	bool	boolean
    //   14	194	3	localInputStream	InputStream
    //   221	4	3	localIOException1	java.io.IOException
    //   237	44	3	localObject1	Object
    //   285	12	3	localObject2	Object
    //   1	1	4	localObject3	Object
    //   157	87	4	localException1	Exception
    //   258	5	4	localIOException2	java.io.IOException
    //   281	12	4	localObject4	Object
    //   300	1	4	localException2	Exception
    //   278	6	5	localObject5	Object
    //   289	6	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   3	15	157	java/lang/Exception
    //   32	47	157	java/lang/Exception
    //   51	56	157	java/lang/Exception
    //   66	108	157	java/lang/Exception
    //   112	122	157	java/lang/Exception
    //   207	211	221	java/io/IOException
    //   3	15	237	finally
    //   32	47	237	finally
    //   51	56	237	finally
    //   66	108	237	finally
    //   112	122	237	finally
    //   243	248	258	java/io/IOException
    //   15	32	278	finally
    //   161	203	289	finally
    //   15	32	300	java/lang/Exception
  }
  
  private static boolean c(v paramv)
  {
    try
    {
      paramv = (List)paramv.getHeaderFields().get("cache-control");
      if ((paramv != null) && (paramv.size() != 0))
      {
        if ((bs.isNullOrNil(paramv.toString())) || (!paramv.toString().contains("no-cache"))) {
          break label94;
        }
        boolean bool = paramv.toString().contains("no-cache");
        return !bool;
      }
    }
    catch (Exception paramv)
    {
      ac.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", paramv, "", new Object[0]);
      return false;
    }
    return true;
    label94:
    return true;
  }
  
  private void dIW()
  {
    ac.i("MicroMsg.SnsCdnDownloadBase", "ready to report logbuffer(13346) packageRecordList:%s", new Object[] { this.xYq.value });
    int j = getMediaType();
    String str2 = "";
    String str1;
    label65:
    Object localObject;
    int i;
    switch (j)
    {
    default: 
      return;
    case 1: 
      str1 = "100105";
      localObject = com.tencent.mm.model.c.d.aAp().tJ(str1);
      if (((com.tencent.mm.storage.c)localObject).isValid())
      {
        i = bs.getInt((String)((com.tencent.mm.storage.c)localObject).eYV().get("needUploadData"), 1);
        str2 = ((com.tencent.mm.storage.c)localObject).field_expId;
      }
      break;
    }
    while (i != 0)
    {
      localObject = new com.tencent.mm.modelsns.f();
      ((com.tencent.mm.modelsns.f)localObject).n("20ImgSize", this.xYy + ",");
      StringBuilder localStringBuilder = new StringBuilder();
      if (ax.isWifi(ai.getContext())) {}
      for (i = 1;; i = 0)
      {
        ((com.tencent.mm.modelsns.f)localObject).n("21NetType", i + ",");
        ((com.tencent.mm.modelsns.f)localObject).n("22DelayTime", this.xYl - this.xYm + ",");
        ((com.tencent.mm.modelsns.f)localObject).n("23RetCode", this.retCode + ",");
        ((com.tencent.mm.modelsns.f)localObject).n("24DnsCostTime", this.dnsCostTime + ",");
        ((com.tencent.mm.modelsns.f)localObject).n("25ConnectCostTime", this.xYm + ",");
        ((com.tencent.mm.modelsns.f)localObject).n("26SendCostTime", ",");
        ((com.tencent.mm.modelsns.f)localObject).n("27WaitResponseCostTime", this.xYt + ",");
        ((com.tencent.mm.modelsns.f)localObject).n("28ReceiveCostTime", this.xYn + ",");
        ((com.tencent.mm.modelsns.f)localObject).n("29ClientAddrIP", this.xYh + ",");
        ((com.tencent.mm.modelsns.f)localObject).n("30ServerAddrIP", this.xYi + ",");
        ((com.tencent.mm.modelsns.f)localObject).n("31dnstype", this.ili + ",");
        ((com.tencent.mm.modelsns.f)localObject).n("32signal", ax.getStrength(ai.getContext()) + ",");
        ((com.tencent.mm.modelsns.f)localObject).n("33host", this.host + ",");
        ((com.tencent.mm.modelsns.f)localObject).n("34MediaType", j + ",");
        ((com.tencent.mm.modelsns.f)localObject).n("35X_Errno", this.xYj + ",");
        ((com.tencent.mm.modelsns.f)localObject).n("36MaxPackageSize", this.xYr + ",");
        ((com.tencent.mm.modelsns.f)localObject).n("37MaxPackageTimeStamp", this.xYs + ",");
        ((com.tencent.mm.modelsns.f)localObject).n("38PackageRecordList", this.xYq.value + ",");
        ((com.tencent.mm.modelsns.f)localObject).n("39ExpLayerId", str1 + ",");
        ((com.tencent.mm.modelsns.f)localObject).n("40ExpId", str2 + ",");
        ((com.tencent.mm.modelsns.f)localObject).n("41FeedId", ",");
        ac.i("MicroMsg.SnsCdnDownloadBase", "report logbuffer(13480 TLMediaFielDownloadRecord): " + ((com.tencent.mm.modelsns.f)localObject).PS());
        h.wUl.f(13480, new Object[] { localObject });
        if (this.retCode == 200) {
          break;
        }
        h.wUl.f(14071, new Object[] { localObject });
        return;
        str1 = "100106";
        break label65;
        str1 = "100100";
        break label65;
      }
      i = 0;
    }
  }
  
  private void dd(boolean paramBoolean)
  {
    int j;
    label113:
    int k;
    int i;
    long l2;
    Object localObject;
    String str1;
    label179:
    int m;
    if ((this.xYf != null) && (this.xYf.xXZ)) {
      if (!paramBoolean)
      {
        h.wUl.idkeyStat(22L, 74L, 1L, true);
        h.wUl.idkeyStat(22L, 73L, 1L, true);
        if ((this.xYf != null) && (this.xYf.xXY) && (!paramBoolean) && (!q.b(this.xYe))) {
          h.wUl.idkeyStat(150L, 66L, 1L, true);
        }
        this.bSY = this.xYy;
        if (!ax.isWifi(ai.getContext())) {
          break label735;
        }
        j = 1;
        k = ax.getStrength(ai.getContext());
        i = this.ili;
        l1 = this.dnsCostTime;
        l2 = this.xYm;
        long l3 = this.xYn;
        long l4 = this.xYl;
        localObject = this.xYg;
        String str2 = this.xYi;
        String str3 = this.xYh;
        if (this.xYf != null) {
          break label740;
        }
        str1 = "";
        ac.v("MicroMsg.SnsCdnDownloadBase", "report dns:%d wifi:%d signal:%d [%d,%d,%d]%d serverIp:[%s,%s] xclientip:%s url[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), localObject, str2, str3, str1 });
        m = ax.getNetType(ai.getContext());
        i = 0;
        if (this.xYf != null)
        {
          if (this.xYf.xYa != 4) {
            break label752;
          }
          i = 1;
        }
        label301:
        ac.i("MicroMsg.SnsCdnDownloadBase", "retCode :%d totalSize: %d net: %d downloadType %d xErrorNo %d", new Object[] { Integer.valueOf(this.retCode), Integer.valueOf(this.bSY), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.xYj) });
        localObject = h.wUl;
        if (this.xYf != null) {
          break label757;
        }
        str1 = "";
        label374:
        l2 = auq(this.xYi);
        if (!paramBoolean) {
          break label769;
        }
      }
    }
    label769:
    for (long l1 = this.xYl;; l1 = 0L)
    {
      ((h)localObject).f(10736, new Object[] { str1, Long.valueOf(l2), Long.valueOf(l1), "", Integer.valueOf(j), Long.valueOf(this.dnsCostTime), Long.valueOf(this.xYm), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(this.xYn), Long.valueOf(auq(this.xYh)), Long.valueOf(auq(this.xYg)), Integer.valueOf(this.ili), Integer.valueOf(k), Integer.valueOf(this.retCode), Integer.valueOf(this.bSY), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.xYj) });
      boolean bool = ax.isConnected(ai.getContext());
      ac.d("MicroMsg.SnsCdnDownloadBase", "isConntected  " + bool + " urlIp: " + this.xYp);
      if ((!paramBoolean) && (!bs.isNullOrNil(this.xYp)) && (bool)) {
        com.tencent.mm.network.b.reportFailIp(this.xYp);
      }
      dIW();
      return;
      h.wUl.idkeyStat(22L, 75L, this.xYl, true);
      break;
      if (!paramBoolean) {
        h.wUl.idkeyStat(22L, 52L, 1L, true);
      }
      for (;;)
      {
        h.wUl.idkeyStat(22L, 51L, 1L, true);
        break;
        h.wUl.idkeyStat(22L, 53L, this.xYl, true);
      }
      label735:
      j = 0;
      break label113;
      label740:
      str1 = this.xYf.url;
      break label179;
      label752:
      i = 0;
      break label301;
      label757:
      str1 = this.xYf.url;
      break label374;
    }
  }
  
  public abstract boolean I(InputStream paramInputStream);
  
  public v a(v paramv)
  {
    return paramv;
  }
  
  public final boolean a(bf parambf, String paramString1, long paramLong, String paramString2)
  {
    if (paramString1 == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramString1 = new URL(paramString1);
        if ((parambf != null) && (paramString2 != null) && (paramString2.indexOf(paramString1.getHost()) != -1) && (parambf.gIh != 0))
        {
          long l = bs.pN(parambf.gIh);
          if (l > paramLong) {
            return true;
          }
        }
      }
      catch (Exception parambf)
      {
        ac.e("MicroMsg.SnsCdnDownloadBase", "error for check dcip %s", new Object[] { parambf.getMessage() });
      }
    }
    return false;
  }
  
  public String aup(String paramString)
  {
    return paramString;
  }
  
  public final ExecutorService dBu()
  {
    return af.dHB();
  }
  
  public boolean dIU()
  {
    return true;
  }
  
  public abstract boolean dIV();
  
  public final Integer dIX()
  {
    com.tencent.mm.kernel.g.agS();
    if ((!com.tencent.mm.kernel.g.agR().isSDCardAvailable()) || (this.xYf == null))
    {
      dd(false);
      return Integer.valueOf(2);
    }
    if (dIU())
    {
      localObject1 = this.xYf.xRt + this.xYf.dIT();
      ac.i("MicroMsg.SnsCdnDownloadBase", "[tomys] delete img: %s", new Object[] { localObject1 });
      i.deleteFile((String)localObject1);
    }
    long l3 = System.currentTimeMillis();
    this.xYo = System.currentTimeMillis();
    ac.d("MicroMsg.SnsCdnDownloadBase", "to downloadBitmap " + this.xYf.mediaId + " " + this.xYf.xXY + " type " + this.xYf.xYa);
    i.aSh(this.xYf.getPath());
    Object localObject3 = this.xYf.xYb;
    Object localObject1 = "";
    Object localObject2;
    if (localObject3 == null)
    {
      localObject1 = "";
      localObject2 = bf.GYH;
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (!bs.isNullOrNil((String)localObject1)) {
        localObject3 = "&scene=".concat(String.valueOf(localObject1));
      }
      String str2 = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.DIc), p.getString(af.dHy()), Integer.valueOf(ax.getNetTypeForStat(ai.getContext())), Integer.valueOf(ax.getStrength(ai.getContext())), localObject3 });
      this.xYf.url = aup(this.xYf.url);
      this.dnsCostTime = bs.eWj();
      label326:
      label341:
      boolean bool;
      if (this.xYf.xXZ)
      {
        localObject1 = "SnsSightDomainList";
        if (!this.xYf.xXZ) {
          break label934;
        }
        localObject3 = "SnsSightMainStandbyIpSwitchTime";
        localObject1 = com.tencent.mm.m.g.ZY().getValue((String)localObject1);
        long l2 = com.tencent.mm.m.g.ZY().getInt((String)localObject3, 0);
        ac.i("MicroMsg.SnsCdnDownloadBase", "pack.isAlbum %s pack.isthumb %s hostvalue %s dcipTime %s", new Object[] { Boolean.valueOf(this.xYf.xXZ), Boolean.valueOf(this.xYf.xXY), localObject1, Long.valueOf(l2) });
        long l1 = l2;
        if (l2 <= 0L) {
          l1 = 259200L;
        }
        bool = a((bf)localObject2, this.xYf.url, l1, (String)localObject1);
        localObject3 = new b.b(this.xYf.url, bool);
        this.dnsCostTime = bs.Ap(this.dnsCostTime);
      }
      try
      {
        if (bs.isNullOrNil(((b.b)localObject3).ip)) {}
        for (localObject1 = InetAddress.getByName(((b.b)localObject3).host).getHostAddress();; localObject1 = ((b.b)localObject3).ip)
        {
          ac.i("MicroMsg.SnsCdnDownloadBase", "checkAndGetHttpConn[%s] [%s] [id:%s] host ip:%d[%s] [%s] download type[%d] isDcIp[%s] fromScene[%s]", new Object[] { str2, this.xYf.url, this.xYf.mediaId, Integer.valueOf(((b.b)localObject3).ili), localObject1, this.xYf.url, Integer.valueOf(this.xYf.xYa), Boolean.valueOf(bool), ((bf)localObject2).toString() });
          this.xYk = 1;
          localObject1 = a((b.b)localObject3, str2);
          localObject2 = ((b.b)localObject3).ip;
          if (localObject1 == null) {
            break label962;
          }
          bool = true;
          ac.i("MicroMsg.SnsCdnDownloadBase", "[sns ip strategy]connect ip:%s, result:%b, canRetry(X-RtFlag):%d, isDC(cold ip):%b, url:%s", new Object[] { localObject2, Boolean.valueOf(bool), Integer.valueOf(this.xYk), Boolean.valueOf(((b.b)localObject3).ill), ((b.b)localObject3).ilk });
          int i = 2;
          if (localObject1 != null) {
            i = b((v)localObject1);
          }
          ac.i("MicroMsg.SnsCdnDownloadBase", "DOWN FIN time:%d down:%d mediaId:%s url[%s], size %d", new Object[] { Long.valueOf(bs.Ap(l3)), Long.valueOf(this.xYl), this.xYf.mediaId, this.xYf.url, Integer.valueOf(this.xYy) });
          return Integer.valueOf(i);
          if (((bf)localObject3).equals(bf.GYA))
          {
            localObject1 = "album_friend";
            localObject2 = localObject3;
            break;
          }
          if (((bf)localObject3).equals(bf.GYB))
          {
            localObject1 = "album_self";
            localObject2 = localObject3;
            break;
          }
          if (((bf)localObject3).equals(bf.GYC))
          {
            localObject1 = "album_stranger";
            localObject2 = localObject3;
            break;
          }
          if (((bf)localObject3).equals(bf.GYD))
          {
            localObject1 = "profile_friend";
            localObject2 = localObject3;
            break;
          }
          if (((bf)localObject3).equals(bf.GYE))
          {
            localObject1 = "profile_stranger";
            localObject2 = localObject3;
            break;
          }
          if (((bf)localObject3).equals(bf.GYF))
          {
            localObject1 = "comment";
            localObject2 = localObject3;
            break;
          }
          localObject2 = localObject3;
          if (!((bf)localObject3).equals(bf.GYz)) {
            break;
          }
          localObject1 = "timeline";
          localObject2 = localObject3;
          break;
          localObject1 = "SnsAlbumDomainList";
          break label326;
          label934:
          localObject3 = "SnsAlbumMainStandbyIpSwitchTime";
          break label341;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str1 = "-";
          continue;
          label962:
          bool = false;
        }
      }
    }
  }
  
  public final void dIY()
  {
    if (af.dHA()) {
      return;
    }
    System.currentTimeMillis();
    Object localObject1;
    Object localObject2;
    if (this.xYf.xMO.xNy == 4)
    {
      ac.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur thumb");
      localObject1 = q.d(this.dwE);
      localObject2 = q.f(this.dwE);
      this.xYe = com.tencent.mm.plugin.sns.lucky.a.a.iX(this.xYf.getPath() + (String)localObject1, this.xYf.getPath() + (String)localObject2);
      af.dHO().a(this.xYf.mediaId, this.xYe, this.xYf.xMO.xNy);
      label132:
      localObject1 = null;
      if (this.xYf.xMO.xNy != 0) {
        break label593;
      }
      localObject1 = "0-" + this.xYf.xMO.dlj;
    }
    for (;;)
    {
      af.dHO().atG((String)localObject1);
      return;
      if (this.xYf.xMO.xNy == 5)
      {
        ac.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur grid");
        localObject1 = q.d(this.dwE);
        localObject2 = q.g(this.dwE);
        this.xYe = com.tencent.mm.plugin.sns.lucky.a.a.iX(this.xYf.getPath() + (String)localObject1, this.xYf.getPath() + (String)localObject2);
        af.dHO().a(this.xYf.mediaId, this.xYe, this.xYf.xMO.xNy);
        break label132;
      }
      if (this.xYf.xMO.list.size() <= 1)
      {
        af.dHO().a(this.xYf.mediaId, this.xYe, this.xYf.xMO.xNy);
        break label132;
      }
      af.dHO().a(this.xYf.mediaId, this.xYe, 0);
      localObject1 = new LinkedList();
      int i = 0;
      for (;;)
      {
        if ((i >= this.xYf.xMO.list.size()) || (i >= 4)) {
          break label501;
        }
        localObject2 = (btz)this.xYf.xMO.list.get(i);
        n localn = af.dHO().atH(((btz)localObject2).Id);
        if (!q.b(localn)) {
          break;
        }
        ((List)localObject1).add(localn);
        ac.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap from " + localn + " " + ((btz)localObject2).Id);
        i += 1;
      }
      label501:
      this.xYe = n.D(q.s((List)localObject1, af.dIc()));
      ac.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap " + this.xYf.xMO.dlj + " " + this.xYe);
      af.dHO().a(this.xYf.xMO.dlj, this.xYe, this.xYf.xMO.xNy);
      break label132;
      label593:
      if (this.xYf.xMO.xNy == 1) {
        localObject1 = "1-" + this.xYf.xMO.dlj;
      } else if (this.xYf.xMO.xNy == 4) {
        localObject1 = "4-" + this.xYf.xMO.dlj;
      } else if (this.xYf.xMO.xNy == 5) {
        localObject1 = "5-" + this.xYf.xMO.dlj;
      }
    }
  }
  
  protected abstract int getMediaType();
  
  public final void onPostExecute(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    if (this.xYf == null) {
      return;
    }
    ac.i("MicroMsg.SnsCdnDownloadBase", "download done result: %d, url:%s, mediaID:%s, totalSize: %d, runningTasksSize: %d", new Object[] { paramInteger, this.xYf.url, this.xYf.mediaId, Integer.valueOf(this.bSY), Integer.valueOf(xYw.size()) });
    xYw.remove(this.xYf.xRx);
    if ((this.xYf.xXY) && (paramInteger.intValue() != 2))
    {
      az.eG(this.xYf.mediaId, this.xYf.mediaType);
      dIY();
    }
    for (;;)
    {
      this.xYd.a(paramInteger.intValue(), this.dwE, this.xYf.xYa, this.xYf.xXY, this.xYf.xRx, this.bSY, -1, true);
      return;
      if ((!this.xYf.xXY) && (this.xYf.xYa == 4))
      {
        String str = this.xYf.getPath() + q.i(this.dwE);
        af.dHO().iZ(this.xYf.mediaId, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.b
 * JD-Core Version:    0.7.0.1
 */