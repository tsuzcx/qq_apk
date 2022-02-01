package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.b.p;
import com.tencent.mm.network.b.b;
import com.tencent.mm.network.v;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.bb;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bk;
import com.tencent.mm.vfs.o;
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
  private static HashSet<String> zFK = new HashSet();
  private int cdl = 0;
  protected bzh dKe = null;
  private long dnsCostTime = -1L;
  private String host = "";
  private int iHs = -1;
  private int retCode = -1;
  protected long zFA = -1L;
  protected long zFB = -1L;
  protected long zFC = -1L;
  protected String zFD = "";
  protected PString zFE = new PString();
  protected int zFF;
  protected long zFG;
  protected long zFH;
  protected long zFI;
  protected int zFJ = 0;
  private Map<String, List<String>> zFL;
  int zFM = 0;
  protected c.a zFr;
  protected com.tencent.mm.memory.n zFs = null;
  protected a zFt = null;
  private String zFu = "";
  private String zFv = "";
  private String zFw = "";
  private int zFx = 0;
  protected int zFy = 0;
  private long zFz = -1L;
  
  public b(c.a parama, a parama1)
  {
    super(parama, parama1);
    this.zFr = parama;
    this.zFt = parama1;
    if (parama1 == null) {
      return;
    }
    this.dKe = parama1.zyh;
    zFK.add(parama1.zyg);
    parama1.init();
  }
  
  private v a(b.b paramb, String paramString)
  {
    try
    {
      this.zFw = paramb.ip;
      this.iHs = paramb.iHs;
      this.zFA = bu.fpO();
      paramb = com.tencent.mm.network.b.a(this.zFt.url, paramb);
      paramb.setRequestMethod("GET");
      paramb.setRequestProperty("referer", paramString);
      if (bu.getInt(com.tencent.mm.n.g.acL().getValue("SnsDownloadHttpKeep"), 0) > 0)
      {
        ae.i("MicroMsg.SnsCdnDownloadBase", "header Connection close ");
        paramb.setRequestProperty("Connection", "close");
      }
      paramb.setConnectTimeout(25000);
      paramb.setReadTimeout(25000);
      paramb = a(paramb);
      this.zFL = paramb.getHeaderFields();
      paramString = (List)this.zFL.get("X-ClientIp");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.zFv = ((String)paramString.get(0));
      }
      paramString = (List)this.zFL.get("X-ServerIp");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.zFu = ((String)paramString.get(0));
      }
      paramString = (List)this.zFL.get("X-ErrNo");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.zFx = bu.aSB((String)paramString.get(0));
      }
      paramString = (List)this.zFL.get("X-RtFlag");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.zFy = bu.aSB((String)paramString.get(0));
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
          aN(paramb.getHeaderFields());
          if (this.zFt.zFn)
          {
            if ((this.retCode >= 400) && (this.retCode < 500))
            {
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(22L, 78L, 1L, true);
              if (this.zFt.zFm) {
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(150L, 14L, 1L, true);
              }
              ae.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! mediaId : " + this.zFt.mediaId + " " + this.zFt.url + " " + this.retCode);
              df(false);
              return null;
            }
            if ((this.retCode < 500) || (this.retCode >= 600)) {
              continue;
            }
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(22L, 79L, 1L, true);
            continue;
          }
        }
        catch (SocketTimeoutException paramb)
        {
          this.retCode = 1;
          df(false);
          paramb = paramb.getMessage();
          if (!this.zFt.zFn) {
            break label780;
          }
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(22L, 77L, 1L, true);
          if (this.zFt.zFm) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(150L, 14L, 1L, true);
          }
          ae.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! socket timeout mediaId : " + this.zFt.mediaId + " " + this.zFt.url + " msg:" + paramb);
          return null;
          if ((this.retCode >= 400) && (this.retCode < 500))
          {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(22L, 56L, 1L, true);
            continue;
          }
        }
        catch (Exception paramb)
        {
          df(false);
          paramb = paramb.getMessage();
          if (this.zFt.zFm) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(150L, 14L, 1L, true);
          }
          ae.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! mediaId : " + this.zFt.mediaId + " " + this.zFt.url + " msg:" + paramb);
          return null;
        }
        if ((this.retCode >= 500) && (this.retCode < 600))
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(22L, 57L, 1L, true);
          continue;
          label780:
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(22L, 55L, 1L, true);
        }
      }
      aN(paramb.getHeaderFields());
    }
    catch (Exception paramb)
    {
      ae.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", paramb, "connect fail : " + paramb.getMessage(), new Object[0]);
      this.retCode = 2;
      df(false);
      return null;
    }
    if (!c(paramb))
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(22L, 62L, 1L, true);
      ae.e("MicroMsg.SnsCdnDownloadBase", "checkHttpConnection failed! nocache mediaId : " + this.zFt.mediaId);
      df(false);
      return null;
    }
    this.zFA = bu.DD(this.zFA);
    paramString = (List)this.zFL.get("Content-Length");
    if ((paramString != null) && (paramString.size() > 0)) {
      this.zFJ = bu.aSB((String)paramString.get(0));
    }
    ae.i("MicroMsg.SnsCdnDownloadBase", "ip: url %s client ip %s server ip %s svrlen %d %d", new Object[] { this.zFt.url, this.zFv, this.zFu, Integer.valueOf(this.zFJ), Integer.valueOf(this.zFx) });
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
  
  private static long aAN(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return 0L;
    }
    try
    {
      paramString = paramString.split("\\.");
      long l1 = bu.getLong(paramString[0], 0L);
      long l2 = bu.getLong(paramString[1], 0L);
      long l3 = bu.getLong(paramString[2], 0L);
      long l4 = bu.getLong(paramString[3], 0L);
      return l4 + (16777216L * l1 + 65536L * l2 + 256L * l3);
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  private static void aN(Map<String, List<String>> paramMap)
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
      ae.i("MicroMsg.SnsCdnDownloadBase", "header respone %s", new Object[] { localStringBuffer.toString() });
      return;
    }
    catch (Exception paramMap) {}
  }
  
  /* Error */
  private int b(v paramv)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokestatic 142	com/tencent/mm/sdk/platformtools/bu:fpO	()J
    //   7: putfield 447	com/tencent/mm/plugin/sns/model/a/b:zFI	J
    //   10: aload_1
    //   11: invokevirtual 451	com/tencent/mm/network/v:getInputStream	()Ljava/io/InputStream;
    //   14: astore_3
    //   15: aload_0
    //   16: invokestatic 142	com/tencent/mm/sdk/platformtools/bu:fpO	()J
    //   19: putfield 87	com/tencent/mm/plugin/sns/model/a/b:zFB	J
    //   22: aload_0
    //   23: aload_3
    //   24: invokevirtual 455	com/tencent/mm/plugin/sns/model/a/b:L	(Ljava/io/InputStream;)Z
    //   27: istore_2
    //   28: aload_3
    //   29: invokevirtual 459	java/io/InputStream:close	()V
    //   32: ldc 184
    //   34: ldc_w 461
    //   37: iload_2
    //   38: invokestatic 464	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   41: invokevirtual 467	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   44: invokestatic 191	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: iload_2
    //   48: ifne +18 -> 66
    //   51: aload_0
    //   52: iconst_0
    //   53: invokespecial 309	com/tencent/mm/plugin/sns/model/a/b:df	(Z)V
    //   56: aload_1
    //   57: ifnull +7 -> 64
    //   60: aload_1
    //   61: invokevirtual 470	com/tencent/mm/network/v:disconnect	()V
    //   64: iconst_2
    //   65: ireturn
    //   66: aload_0
    //   67: aload_0
    //   68: getfield 87	com/tencent/mm/plugin/sns/model/a/b:zFB	J
    //   71: invokestatic 347	com/tencent/mm/sdk/platformtools/bu:DD	(J)J
    //   74: putfield 87	com/tencent/mm/plugin/sns/model/a/b:zFB	J
    //   77: aload_0
    //   78: aload_0
    //   79: getfield 89	com/tencent/mm/plugin/sns/model/a/b:zFC	J
    //   82: invokestatic 347	com/tencent/mm/sdk/platformtools/bu:DD	(J)J
    //   85: putfield 79	com/tencent/mm/plugin/sns/model/a/b:zFz	J
    //   88: aload_0
    //   89: invokevirtual 473	com/tencent/mm/plugin/sns/model/a/b:dYJ	()Z
    //   92: istore_2
    //   93: ldc 184
    //   95: ldc_w 475
    //   98: iload_2
    //   99: invokestatic 464	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   102: invokevirtual 467	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   105: invokestatic 191	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: iload_2
    //   109: ifne +23 -> 132
    //   112: aload_0
    //   113: iconst_3
    //   114: putfield 98	com/tencent/mm/plugin/sns/model/a/b:retCode	I
    //   117: aload_0
    //   118: iconst_0
    //   119: invokespecial 309	com/tencent/mm/plugin/sns/model/a/b:df	(Z)V
    //   122: aload_1
    //   123: ifnull -59 -> 64
    //   126: aload_1
    //   127: invokevirtual 470	com/tencent/mm/network/v:disconnect	()V
    //   130: iconst_2
    //   131: ireturn
    //   132: aload_1
    //   133: ifnull +7 -> 140
    //   136: aload_1
    //   137: invokevirtual 470	com/tencent/mm/network/v:disconnect	()V
    //   140: aload_0
    //   141: iconst_1
    //   142: invokespecial 309	com/tencent/mm/plugin/sns/model/a/b:df	(Z)V
    //   145: aload_0
    //   146: getfield 61	com/tencent/mm/plugin/sns/model/a/b:zFt	Lcom/tencent/mm/plugin/sns/model/a/a;
    //   149: getfield 277	com/tencent/mm/plugin/sns/model/a/a:zFm	Z
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
    //   169: ldc_w 477
    //   172: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   175: aload 4
    //   177: invokevirtual 323	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   180: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: iconst_0
    //   187: anewarray 331	java/lang/Object
    //   190: invokestatic 335	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   193: aload_0
    //   194: iconst_4
    //   195: putfield 98	com/tencent/mm/plugin/sns/model/a/b:retCode	I
    //   198: aload_0
    //   199: iconst_0
    //   200: invokespecial 309	com/tencent/mm/plugin/sns/model/a/b:df	(Z)V
    //   203: aload_3
    //   204: ifnull +7 -> 211
    //   207: aload_3
    //   208: invokevirtual 459	java/io/InputStream:close	()V
    //   211: aload_1
    //   212: ifnull -148 -> 64
    //   215: aload_1
    //   216: invokevirtual 470	com/tencent/mm/network/v:disconnect	()V
    //   219: iconst_2
    //   220: ireturn
    //   221: astore_3
    //   222: ldc 184
    //   224: aload_3
    //   225: ldc 65
    //   227: iconst_0
    //   228: anewarray 331	java/lang/Object
    //   231: invokestatic 335	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: goto -23 -> 211
    //   237: astore_3
    //   238: aload 4
    //   240: ifnull +8 -> 248
    //   243: aload 4
    //   245: invokevirtual 459	java/io/InputStream:close	()V
    //   248: aload_1
    //   249: ifnull +7 -> 256
    //   252: aload_1
    //   253: invokevirtual 470	com/tencent/mm/network/v:disconnect	()V
    //   256: aload_3
    //   257: athrow
    //   258: astore 4
    //   260: ldc 184
    //   262: aload 4
    //   264: ldc 65
    //   266: iconst_0
    //   267: anewarray 331	java/lang/Object
    //   270: invokestatic 335	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
        if ((bu.isNullOrNil(paramv.toString())) || (!paramv.toString().contains("no-cache"))) {
          break label94;
        }
        boolean bool = paramv.toString().contains("no-cache");
        return !bool;
      }
    }
    catch (Exception paramv)
    {
      ae.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", paramv, "", new Object[0]);
      return false;
    }
    return true;
    label94:
    return true;
  }
  
  private void dYK()
  {
    ae.i("MicroMsg.SnsCdnDownloadBase", "ready to report logbuffer(13346) packageRecordList:%s", new Object[] { this.zFE.value });
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
      localObject = com.tencent.mm.model.c.d.aDI().xi(str1);
      if (((com.tencent.mm.storage.c)localObject).isValid())
      {
        i = bu.getInt((String)((com.tencent.mm.storage.c)localObject).fsy().get("needUploadData"), 1);
        str2 = ((com.tencent.mm.storage.c)localObject).field_expId;
      }
      break;
    }
    while (i != 0)
    {
      localObject = new com.tencent.mm.modelsns.g();
      ((com.tencent.mm.modelsns.g)localObject).m("20ImgSize", this.zFM + ",");
      StringBuilder localStringBuilder = new StringBuilder();
      if (az.isWifi(ak.getContext())) {}
      for (i = 1;; i = 0)
      {
        ((com.tencent.mm.modelsns.g)localObject).m("21NetType", i + ",");
        ((com.tencent.mm.modelsns.g)localObject).m("22DelayTime", this.zFz - this.zFA + ",");
        ((com.tencent.mm.modelsns.g)localObject).m("23RetCode", this.retCode + ",");
        ((com.tencent.mm.modelsns.g)localObject).m("24DnsCostTime", this.dnsCostTime + ",");
        ((com.tencent.mm.modelsns.g)localObject).m("25ConnectCostTime", this.zFA + ",");
        ((com.tencent.mm.modelsns.g)localObject).m("26SendCostTime", ",");
        ((com.tencent.mm.modelsns.g)localObject).m("27WaitResponseCostTime", this.zFH + ",");
        ((com.tencent.mm.modelsns.g)localObject).m("28ReceiveCostTime", this.zFB + ",");
        ((com.tencent.mm.modelsns.g)localObject).m("29ClientAddrIP", this.zFv + ",");
        ((com.tencent.mm.modelsns.g)localObject).m("30ServerAddrIP", this.zFw + ",");
        ((com.tencent.mm.modelsns.g)localObject).m("31dnstype", this.iHs + ",");
        ((com.tencent.mm.modelsns.g)localObject).m("32signal", az.getStrength(ak.getContext()) + ",");
        ((com.tencent.mm.modelsns.g)localObject).m("33host", this.host + ",");
        ((com.tencent.mm.modelsns.g)localObject).m("34MediaType", j + ",");
        ((com.tencent.mm.modelsns.g)localObject).m("35X_Errno", this.zFx + ",");
        ((com.tencent.mm.modelsns.g)localObject).m("36MaxPackageSize", this.zFF + ",");
        ((com.tencent.mm.modelsns.g)localObject).m("37MaxPackageTimeStamp", this.zFG + ",");
        ((com.tencent.mm.modelsns.g)localObject).m("38PackageRecordList", this.zFE.value + ",");
        ((com.tencent.mm.modelsns.g)localObject).m("39ExpLayerId", str1 + ",");
        ((com.tencent.mm.modelsns.g)localObject).m("40ExpId", str2 + ",");
        ((com.tencent.mm.modelsns.g)localObject).m("41FeedId", ",");
        ae.i("MicroMsg.SnsCdnDownloadBase", "report logbuffer(13480 TLMediaFielDownloadRecord): " + ((com.tencent.mm.modelsns.g)localObject).RD());
        com.tencent.mm.plugin.report.service.g.yxI.f(13480, new Object[] { localObject });
        if (this.retCode == 200) {
          break;
        }
        com.tencent.mm.plugin.report.service.g.yxI.f(14071, new Object[] { localObject });
        return;
        str1 = "100106";
        break label65;
        str1 = "100100";
        break label65;
      }
      i = 0;
    }
  }
  
  private void df(boolean paramBoolean)
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
    if ((this.zFt != null) && (this.zFt.zFn)) {
      if (!paramBoolean)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(22L, 74L, 1L, true);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(22L, 73L, 1L, true);
        if ((this.zFt != null) && (this.zFt.zFm) && (!paramBoolean) && (!r.b(this.zFs))) {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(150L, 66L, 1L, true);
        }
        this.cdl = this.zFM;
        if (!az.isWifi(ak.getContext())) {
          break label735;
        }
        j = 1;
        k = az.getStrength(ak.getContext());
        i = this.iHs;
        l1 = this.dnsCostTime;
        l2 = this.zFA;
        long l3 = this.zFB;
        long l4 = this.zFz;
        localObject = this.zFu;
        String str2 = this.zFw;
        String str3 = this.zFv;
        if (this.zFt != null) {
          break label740;
        }
        str1 = "";
        ae.v("MicroMsg.SnsCdnDownloadBase", "report dns:%d wifi:%d signal:%d [%d,%d,%d]%d serverIp:[%s,%s] xclientip:%s url[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), localObject, str2, str3, str1 });
        m = az.getNetType(ak.getContext());
        i = 0;
        if (this.zFt != null)
        {
          if (this.zFt.zFo != 4) {
            break label752;
          }
          i = 1;
        }
        label301:
        ae.i("MicroMsg.SnsCdnDownloadBase", "retCode :%d totalSize: %d net: %d downloadType %d xErrorNo %d", new Object[] { Integer.valueOf(this.retCode), Integer.valueOf(this.cdl), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.zFx) });
        localObject = com.tencent.mm.plugin.report.service.g.yxI;
        if (this.zFt != null) {
          break label757;
        }
        str1 = "";
        label374:
        l2 = aAN(this.zFw);
        if (!paramBoolean) {
          break label769;
        }
      }
    }
    label769:
    for (long l1 = this.zFz;; l1 = 0L)
    {
      ((com.tencent.mm.plugin.report.service.g)localObject).f(10736, new Object[] { str1, Long.valueOf(l2), Long.valueOf(l1), "", Integer.valueOf(j), Long.valueOf(this.dnsCostTime), Long.valueOf(this.zFA), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(this.zFB), Long.valueOf(aAN(this.zFv)), Long.valueOf(aAN(this.zFu)), Integer.valueOf(this.iHs), Integer.valueOf(k), Integer.valueOf(this.retCode), Integer.valueOf(this.cdl), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.zFx) });
      boolean bool = az.isConnected(ak.getContext());
      ae.d("MicroMsg.SnsCdnDownloadBase", "isConntected  " + bool + " urlIp: " + this.zFD);
      if ((!paramBoolean) && (!bu.isNullOrNil(this.zFD)) && (bool)) {
        com.tencent.mm.network.b.reportFailIp(this.zFD);
      }
      dYK();
      return;
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(22L, 75L, this.zFz, true);
      break;
      if (!paramBoolean) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(22L, 52L, 1L, true);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(22L, 51L, 1L, true);
        break;
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(22L, 53L, this.zFz, true);
      }
      label735:
      j = 0;
      break label113;
      label740:
      str1 = this.zFt.url;
      break label179;
      label752:
      i = 0;
      break label301;
      label757:
      str1 = this.zFt.url;
      break label374;
    }
  }
  
  public abstract boolean L(InputStream paramInputStream);
  
  public v a(v paramv)
  {
    return paramv;
  }
  
  public final boolean a(bk parambk, String paramString1, long paramLong, String paramString2)
  {
    if (paramString1 == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramString1 = new URL(paramString1);
        if ((parambk != null) && (paramString2 != null) && (paramString2.indexOf(paramString1.getHost()) != -1) && (parambk.heF != 0))
        {
          long l = bu.rZ(parambk.heF);
          if (l > paramLong) {
            return true;
          }
        }
      }
      catch (Exception parambk)
      {
        ae.e("MicroMsg.SnsCdnDownloadBase", "error for check dcip %s", new Object[] { parambk.getMessage() });
      }
    }
    return false;
  }
  
  public String aAM(String paramString)
  {
    return paramString;
  }
  
  public final ExecutorService dFv()
  {
    return ah.dXo();
  }
  
  public boolean dYI()
  {
    return true;
  }
  
  public abstract boolean dYJ();
  
  public final Integer dYL()
  {
    com.tencent.mm.kernel.g.ajS();
    if ((!com.tencent.mm.kernel.g.ajR().isSDCardAvailable()) || (this.zFt == null))
    {
      df(false);
      return Integer.valueOf(2);
    }
    if (dYI())
    {
      localObject1 = this.zFt.zyc + this.zFt.dYH();
      ae.i("MicroMsg.SnsCdnDownloadBase", "[tomys] delete img: %s", new Object[] { localObject1 });
      o.deleteFile((String)localObject1);
    }
    long l3 = System.currentTimeMillis();
    this.zFC = System.currentTimeMillis();
    ae.d("MicroMsg.SnsCdnDownloadBase", "to downloadBitmap " + this.zFt.mediaId + " " + this.zFt.zFm + " type " + this.zFt.zFo);
    o.aZI(this.zFt.getPath());
    Object localObject3 = this.zFt.zFp;
    Object localObject1 = "";
    Object localObject2;
    if (localObject3 == null)
    {
      localObject1 = "";
      localObject2 = bk.JgC;
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (!bu.isNullOrNil((String)localObject1)) {
        localObject3 = "&scene=".concat(String.valueOf(localObject1));
      }
      String str2 = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.FFH), p.getString(ah.dXk()), Integer.valueOf(az.getNetTypeForStat(ak.getContext())), Integer.valueOf(az.getStrength(ak.getContext())), localObject3 });
      this.zFt.url = aAM(this.zFt.url);
      this.dnsCostTime = bu.fpO();
      label326:
      label341:
      boolean bool;
      if (this.zFt.zFn)
      {
        localObject1 = "SnsSightDomainList";
        if (!this.zFt.zFn) {
          break label934;
        }
        localObject3 = "SnsSightMainStandbyIpSwitchTime";
        localObject1 = com.tencent.mm.n.g.acL().getValue((String)localObject1);
        long l2 = com.tencent.mm.n.g.acL().getInt((String)localObject3, 0);
        ae.i("MicroMsg.SnsCdnDownloadBase", "pack.isAlbum %s pack.isthumb %s hostvalue %s dcipTime %s", new Object[] { Boolean.valueOf(this.zFt.zFn), Boolean.valueOf(this.zFt.zFm), localObject1, Long.valueOf(l2) });
        long l1 = l2;
        if (l2 <= 0L) {
          l1 = 259200L;
        }
        bool = a((bk)localObject2, this.zFt.url, l1, (String)localObject1);
        localObject3 = new b.b(this.zFt.url, bool);
        this.dnsCostTime = bu.DD(this.dnsCostTime);
      }
      try
      {
        if (bu.isNullOrNil(((b.b)localObject3).ip)) {}
        for (localObject1 = InetAddress.getByName(((b.b)localObject3).host).getHostAddress();; localObject1 = ((b.b)localObject3).ip)
        {
          ae.i("MicroMsg.SnsCdnDownloadBase", "checkAndGetHttpConn[%s] [%s] [id:%s] host ip:%d[%s] [%s] download type[%d] isDcIp[%s] fromScene[%s]", new Object[] { str2, this.zFt.url, this.zFt.mediaId, Integer.valueOf(((b.b)localObject3).iHs), localObject1, this.zFt.url, Integer.valueOf(this.zFt.zFo), Boolean.valueOf(bool), ((bk)localObject2).toString() });
          this.zFy = 1;
          localObject1 = a((b.b)localObject3, str2);
          localObject2 = ((b.b)localObject3).ip;
          if (localObject1 == null) {
            break label962;
          }
          bool = true;
          ae.i("MicroMsg.SnsCdnDownloadBase", "[sns ip strategy]connect ip:%s, result:%b, canRetry(X-RtFlag):%d, isDC(cold ip):%b, url:%s", new Object[] { localObject2, Boolean.valueOf(bool), Integer.valueOf(this.zFy), Boolean.valueOf(((b.b)localObject3).iHv), ((b.b)localObject3).iHu });
          int i = 2;
          if (localObject1 != null) {
            i = b((v)localObject1);
          }
          ae.i("MicroMsg.SnsCdnDownloadBase", "DOWN FIN time:%d down:%d mediaId:%s url[%s], size %d", new Object[] { Long.valueOf(bu.DD(l3)), Long.valueOf(this.zFz), this.zFt.mediaId, this.zFt.url, Integer.valueOf(this.zFM) });
          return Integer.valueOf(i);
          if (((bk)localObject3).equals(bk.Jgv))
          {
            localObject1 = "album_friend";
            localObject2 = localObject3;
            break;
          }
          if (((bk)localObject3).equals(bk.Jgw))
          {
            localObject1 = "album_self";
            localObject2 = localObject3;
            break;
          }
          if (((bk)localObject3).equals(bk.Jgx))
          {
            localObject1 = "album_stranger";
            localObject2 = localObject3;
            break;
          }
          if (((bk)localObject3).equals(bk.Jgy))
          {
            localObject1 = "profile_friend";
            localObject2 = localObject3;
            break;
          }
          if (((bk)localObject3).equals(bk.Jgz))
          {
            localObject1 = "profile_stranger";
            localObject2 = localObject3;
            break;
          }
          if (((bk)localObject3).equals(bk.JgA))
          {
            localObject1 = "comment";
            localObject2 = localObject3;
            break;
          }
          localObject2 = localObject3;
          if (!((bk)localObject3).equals(bk.Jgu)) {
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
  
  public final void dYM()
  {
    if (ah.dXn()) {
      return;
    }
    System.currentTimeMillis();
    Object localObject1;
    Object localObject2;
    if (this.zFt.ztw.zui == 4)
    {
      ae.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur thumb");
      localObject1 = r.d(this.dKe);
      localObject2 = r.f(this.dKe);
      this.zFs = com.tencent.mm.plugin.sns.lucky.a.a.jq(this.zFt.getPath() + (String)localObject1, this.zFt.getPath() + (String)localObject2);
      ah.dXB().a(this.zFt.mediaId, this.zFs, this.zFt.ztw.zui);
      label132:
      localObject1 = null;
      if (this.zFt.ztw.zui != 0) {
        break label593;
      }
      localObject1 = "0-" + this.zFt.ztw.dyb;
    }
    for (;;)
    {
      ah.dXB().aAc((String)localObject1);
      return;
      if (this.zFt.ztw.zui == 5)
      {
        ae.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur grid");
        localObject1 = r.d(this.dKe);
        localObject2 = r.g(this.dKe);
        this.zFs = com.tencent.mm.plugin.sns.lucky.a.a.jq(this.zFt.getPath() + (String)localObject1, this.zFt.getPath() + (String)localObject2);
        ah.dXB().a(this.zFt.mediaId, this.zFs, this.zFt.ztw.zui);
        break label132;
      }
      if (this.zFt.ztw.list.size() <= 1)
      {
        ah.dXB().a(this.zFt.mediaId, this.zFs, this.zFt.ztw.zui);
        break label132;
      }
      ah.dXB().a(this.zFt.mediaId, this.zFs, 0);
      localObject1 = new LinkedList();
      int i = 0;
      for (;;)
      {
        if ((i >= this.zFt.ztw.list.size()) || (i >= 4)) {
          break label501;
        }
        localObject2 = (bzh)this.zFt.ztw.list.get(i);
        com.tencent.mm.memory.n localn = ah.dXB().aAd(((bzh)localObject2).Id);
        if (!r.b(localn)) {
          break;
        }
        ((List)localObject1).add(localn);
        ae.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap from " + localn + " " + ((bzh)localObject2).Id);
        i += 1;
      }
      label501:
      this.zFs = com.tencent.mm.memory.n.E(r.v((List)localObject1, ah.dXP()));
      ae.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap " + this.zFt.ztw.dyb + " " + this.zFs);
      ah.dXB().a(this.zFt.ztw.dyb, this.zFs, this.zFt.ztw.zui);
      break label132;
      label593:
      if (this.zFt.ztw.zui == 1) {
        localObject1 = "1-" + this.zFt.ztw.dyb;
      } else if (this.zFt.ztw.zui == 4) {
        localObject1 = "4-" + this.zFt.ztw.dyb;
      } else if (this.zFt.ztw.zui == 5) {
        localObject1 = "5-" + this.zFt.ztw.dyb;
      }
    }
  }
  
  protected abstract int getMediaType();
  
  public final void onPostExecute(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    if (this.zFt == null) {
      return;
    }
    ae.i("MicroMsg.SnsCdnDownloadBase", "download done result: %d, url:%s, mediaID:%s, totalSize: %d, runningTasksSize: %d", new Object[] { paramInteger, this.zFt.url, this.zFt.mediaId, Integer.valueOf(this.cdl), Integer.valueOf(zFK.size()) });
    zFK.remove(this.zFt.zyg);
    if ((this.zFt.zFm) && (paramInteger.intValue() != 2))
    {
      bb.fh(this.zFt.mediaId, this.zFt.mediaType);
      dYM();
    }
    for (;;)
    {
      this.zFr.a(paramInteger.intValue(), this.dKe, this.zFt.zFo, this.zFt.zFm, this.zFt.zyg, this.cdl, -1, true);
      return;
      if ((!this.zFt.zFm) && (this.zFt.zFo == 4))
      {
        String str = this.zFt.getPath() + r.i(this.dKe);
        ah.dXB().js(this.zFt.mediaId, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.b
 * JD-Core Version:    0.7.0.1
 */