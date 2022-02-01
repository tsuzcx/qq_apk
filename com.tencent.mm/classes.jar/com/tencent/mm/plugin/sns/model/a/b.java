package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.b.p;
import com.tencent.mm.memory.n;
import com.tencent.mm.network.b.b;
import com.tencent.mm.network.v;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bc;
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
  private static HashSet<String> wLQ = new HashSet();
  private int bVq = 0;
  private long dnsCostTime = -1L;
  protected bpi dyS = null;
  private int hKM = -1;
  private String host = "";
  private int retCode = -1;
  private String wLA = "";
  private String wLB = "";
  private String wLC = "";
  private int wLD = 0;
  protected int wLE = 0;
  private long wLF = -1L;
  protected long wLG = -1L;
  protected long wLH = -1L;
  protected long wLI = -1L;
  protected String wLJ = "";
  protected PString wLK = new PString();
  protected int wLL;
  protected long wLM;
  protected long wLN;
  protected long wLO;
  protected int wLP = 0;
  private Map<String, List<String>> wLR;
  int wLS = 0;
  protected c.a wLx;
  protected n wLy = null;
  protected a wLz = null;
  
  public b(c.a parama, a parama1)
  {
    super(parama, parama1);
    this.wLx = parama;
    this.wLz = parama1;
    if (parama1 == null) {
      return;
    }
    this.dyS = parama1.wFd;
    wLQ.add(parama1.wFc);
    parama1.init();
  }
  
  private v a(b.b paramb, String paramString)
  {
    try
    {
      this.wLC = paramb.ip;
      this.hKM = paramb.hKM;
      this.wLG = bt.eGO();
      paramb = com.tencent.mm.network.b.a(this.wLz.url, paramb);
      paramb.setRequestMethod("GET");
      paramb.setRequestProperty("referer", paramString);
      if (bt.getInt(com.tencent.mm.m.g.Zd().getValue("SnsDownloadHttpKeep"), 0) > 0)
      {
        ad.i("MicroMsg.SnsCdnDownloadBase", "header Connection close ");
        paramb.setRequestProperty("Connection", "close");
      }
      paramb.setConnectTimeout(25000);
      paramb.setReadTimeout(25000);
      paramb = a(paramb);
      this.wLR = paramb.getHeaderFields();
      paramString = (List)this.wLR.get("X-ClientIp");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.wLB = ((String)paramString.get(0));
      }
      paramString = (List)this.wLR.get("X-ServerIp");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.wLA = ((String)paramString.get(0));
      }
      paramString = (List)this.wLR.get("X-ErrNo");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.wLD = bt.aGh((String)paramString.get(0));
      }
      paramString = (List)this.wLR.get("X-RtFlag");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.wLE = bt.aGh((String)paramString.get(0));
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
          aA(paramb.getHeaderFields());
          if (this.wLz.wLt)
          {
            if ((this.retCode >= 400) && (this.retCode < 500))
            {
              h.vKh.idkeyStat(22L, 78L, 1L, true);
              if (this.wLz.wLs) {
                h.vKh.idkeyStat(150L, 14L, 1L, true);
              }
              ad.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! mediaId : " + this.wLz.mediaId + " " + this.wLz.url + " " + this.retCode);
              de(false);
              return null;
            }
            if ((this.retCode < 500) || (this.retCode >= 600)) {
              continue;
            }
            h.vKh.idkeyStat(22L, 79L, 1L, true);
            continue;
          }
        }
        catch (SocketTimeoutException paramb)
        {
          this.retCode = 1;
          de(false);
          paramb = paramb.getMessage();
          if (!this.wLz.wLt) {
            break label780;
          }
          h.vKh.idkeyStat(22L, 77L, 1L, true);
          if (this.wLz.wLs) {
            h.vKh.idkeyStat(150L, 14L, 1L, true);
          }
          ad.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! socket timeout mediaId : " + this.wLz.mediaId + " " + this.wLz.url + " msg:" + paramb);
          return null;
          if ((this.retCode >= 400) && (this.retCode < 500))
          {
            h.vKh.idkeyStat(22L, 56L, 1L, true);
            continue;
          }
        }
        catch (Exception paramb)
        {
          de(false);
          paramb = paramb.getMessage();
          if (this.wLz.wLs) {
            h.vKh.idkeyStat(150L, 14L, 1L, true);
          }
          ad.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! mediaId : " + this.wLz.mediaId + " " + this.wLz.url + " msg:" + paramb);
          return null;
        }
        if ((this.retCode >= 500) && (this.retCode < 600))
        {
          h.vKh.idkeyStat(22L, 57L, 1L, true);
          continue;
          label780:
          h.vKh.idkeyStat(22L, 55L, 1L, true);
        }
      }
      aA(paramb.getHeaderFields());
    }
    catch (Exception paramb)
    {
      ad.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", paramb, "connect fail : " + paramb.getMessage(), new Object[0]);
      this.retCode = 2;
      de(false);
      return null;
    }
    if (!c(paramb))
    {
      h.vKh.idkeyStat(22L, 62L, 1L, true);
      ad.e("MicroMsg.SnsCdnDownloadBase", "checkHttpConnection failed! nocache mediaId : " + this.wLz.mediaId);
      de(false);
      return null;
    }
    this.wLG = bt.vM(this.wLG);
    paramString = (List)this.wLR.get("Content-Length");
    if ((paramString != null) && (paramString.size() > 0)) {
      this.wLP = bt.aGh((String)paramString.get(0));
    }
    ad.i("MicroMsg.SnsCdnDownloadBase", "ip: url %s client ip %s server ip %s svrlen %d %d", new Object[] { this.wLz.url, this.wLB, this.wLA, Integer.valueOf(this.wLP), Integer.valueOf(this.wLD) });
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
  
  private static void aA(Map<String, List<String>> paramMap)
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
      ad.i("MicroMsg.SnsCdnDownloadBase", "header respone %s", new Object[] { localStringBuffer.toString() });
      return;
    }
    catch (Exception paramMap) {}
  }
  
  private static long ape(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return 0L;
    }
    try
    {
      paramString = paramString.split("\\.");
      long l1 = bt.getLong(paramString[0], 0L);
      long l2 = bt.getLong(paramString[1], 0L);
      long l3 = bt.getLong(paramString[2], 0L);
      long l4 = bt.getLong(paramString[3], 0L);
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
    //   4: invokestatic 142	com/tencent/mm/sdk/platformtools/bt:eGO	()J
    //   7: putfield 447	com/tencent/mm/plugin/sns/model/a/b:wLO	J
    //   10: aload_1
    //   11: invokevirtual 451	com/tencent/mm/network/v:getInputStream	()Ljava/io/InputStream;
    //   14: astore_3
    //   15: aload_0
    //   16: invokestatic 142	com/tencent/mm/sdk/platformtools/bt:eGO	()J
    //   19: putfield 87	com/tencent/mm/plugin/sns/model/a/b:wLH	J
    //   22: aload_0
    //   23: aload_3
    //   24: invokevirtual 454	com/tencent/mm/plugin/sns/model/a/b:J	(Ljava/io/InputStream;)Z
    //   27: istore_2
    //   28: aload_3
    //   29: invokevirtual 458	java/io/InputStream:close	()V
    //   32: ldc 184
    //   34: ldc_w 460
    //   37: iload_2
    //   38: invokestatic 463	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   41: invokevirtual 466	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   44: invokestatic 191	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: iload_2
    //   48: ifne +18 -> 66
    //   51: aload_0
    //   52: iconst_0
    //   53: invokespecial 309	com/tencent/mm/plugin/sns/model/a/b:de	(Z)V
    //   56: aload_1
    //   57: ifnull +7 -> 64
    //   60: aload_1
    //   61: invokevirtual 469	com/tencent/mm/network/v:disconnect	()V
    //   64: iconst_2
    //   65: ireturn
    //   66: aload_0
    //   67: aload_0
    //   68: getfield 87	com/tencent/mm/plugin/sns/model/a/b:wLH	J
    //   71: invokestatic 347	com/tencent/mm/sdk/platformtools/bt:vM	(J)J
    //   74: putfield 87	com/tencent/mm/plugin/sns/model/a/b:wLH	J
    //   77: aload_0
    //   78: aload_0
    //   79: getfield 89	com/tencent/mm/plugin/sns/model/a/b:wLI	J
    //   82: invokestatic 347	com/tencent/mm/sdk/platformtools/bt:vM	(J)J
    //   85: putfield 79	com/tencent/mm/plugin/sns/model/a/b:wLF	J
    //   88: aload_0
    //   89: invokevirtual 472	com/tencent/mm/plugin/sns/model/a/b:duv	()Z
    //   92: istore_2
    //   93: ldc 184
    //   95: ldc_w 474
    //   98: iload_2
    //   99: invokestatic 463	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   102: invokevirtual 466	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   105: invokestatic 191	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: iload_2
    //   109: ifne +23 -> 132
    //   112: aload_0
    //   113: iconst_3
    //   114: putfield 98	com/tencent/mm/plugin/sns/model/a/b:retCode	I
    //   117: aload_0
    //   118: iconst_0
    //   119: invokespecial 309	com/tencent/mm/plugin/sns/model/a/b:de	(Z)V
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
    //   142: invokespecial 309	com/tencent/mm/plugin/sns/model/a/b:de	(Z)V
    //   145: aload_0
    //   146: getfield 61	com/tencent/mm/plugin/sns/model/a/b:wLz	Lcom/tencent/mm/plugin/sns/model/a/a;
    //   149: getfield 277	com/tencent/mm/plugin/sns/model/a/a:wLs	Z
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
    //   190: invokestatic 335	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   193: aload_0
    //   194: iconst_4
    //   195: putfield 98	com/tencent/mm/plugin/sns/model/a/b:retCode	I
    //   198: aload_0
    //   199: iconst_0
    //   200: invokespecial 309	com/tencent/mm/plugin/sns/model/a/b:de	(Z)V
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
    //   231: invokestatic 335	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   270: invokestatic 335	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
        if ((bt.isNullOrNil(paramv.toString())) || (!paramv.toString().contains("no-cache"))) {
          break label94;
        }
        boolean bool = paramv.toString().contains("no-cache");
        return !bool;
      }
    }
    catch (Exception paramv)
    {
      ad.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", paramv, "", new Object[0]);
      return false;
    }
    return true;
    label94:
    return true;
  }
  
  private void de(boolean paramBoolean)
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
    if ((this.wLz != null) && (this.wLz.wLt)) {
      if (!paramBoolean)
      {
        h.vKh.idkeyStat(22L, 74L, 1L, true);
        h.vKh.idkeyStat(22L, 73L, 1L, true);
        if ((this.wLz != null) && (this.wLz.wLs) && (!paramBoolean) && (!q.b(this.wLy))) {
          h.vKh.idkeyStat(150L, 66L, 1L, true);
        }
        this.bVq = this.wLS;
        if (!com.tencent.mm.sdk.platformtools.ay.isWifi(aj.getContext())) {
          break label735;
        }
        j = 1;
        k = com.tencent.mm.sdk.platformtools.ay.getStrength(aj.getContext());
        i = this.hKM;
        l1 = this.dnsCostTime;
        l2 = this.wLG;
        long l3 = this.wLH;
        long l4 = this.wLF;
        localObject = this.wLA;
        String str2 = this.wLC;
        String str3 = this.wLB;
        if (this.wLz != null) {
          break label740;
        }
        str1 = "";
        ad.v("MicroMsg.SnsCdnDownloadBase", "report dns:%d wifi:%d signal:%d [%d,%d,%d]%d serverIp:[%s,%s] xclientip:%s url[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), localObject, str2, str3, str1 });
        m = com.tencent.mm.sdk.platformtools.ay.getNetType(aj.getContext());
        i = 0;
        if (this.wLz != null)
        {
          if (this.wLz.wLu != 4) {
            break label752;
          }
          i = 1;
        }
        label301:
        ad.i("MicroMsg.SnsCdnDownloadBase", "retCode :%d totalSize: %d net: %d downloadType %d xErrorNo %d", new Object[] { Integer.valueOf(this.retCode), Integer.valueOf(this.bVq), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.wLD) });
        localObject = h.vKh;
        if (this.wLz != null) {
          break label757;
        }
        str1 = "";
        label374:
        l2 = ape(this.wLC);
        if (!paramBoolean) {
          break label769;
        }
      }
    }
    label769:
    for (long l1 = this.wLF;; l1 = 0L)
    {
      ((h)localObject).f(10736, new Object[] { str1, Long.valueOf(l2), Long.valueOf(l1), "", Integer.valueOf(j), Long.valueOf(this.dnsCostTime), Long.valueOf(this.wLG), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(this.wLH), Long.valueOf(ape(this.wLB)), Long.valueOf(ape(this.wLA)), Integer.valueOf(this.hKM), Integer.valueOf(k), Integer.valueOf(this.retCode), Integer.valueOf(this.bVq), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.wLD) });
      boolean bool = com.tencent.mm.sdk.platformtools.ay.isConnected(aj.getContext());
      ad.d("MicroMsg.SnsCdnDownloadBase", "isConntected  " + bool + " urlIp: " + this.wLJ);
      if ((!paramBoolean) && (!bt.isNullOrNil(this.wLJ)) && (bool)) {
        com.tencent.mm.network.b.reportFailIp(this.wLJ);
      }
      duw();
      return;
      h.vKh.idkeyStat(22L, 75L, this.wLF, true);
      break;
      if (!paramBoolean) {
        h.vKh.idkeyStat(22L, 52L, 1L, true);
      }
      for (;;)
      {
        h.vKh.idkeyStat(22L, 51L, 1L, true);
        break;
        h.vKh.idkeyStat(22L, 53L, this.wLF, true);
      }
      label735:
      j = 0;
      break label113;
      label740:
      str1 = this.wLz.url;
      break label179;
      label752:
      i = 0;
      break label301;
      label757:
      str1 = this.wLz.url;
      break label374;
    }
  }
  
  private void duw()
  {
    ad.i("MicroMsg.SnsCdnDownloadBase", "ready to report logbuffer(13346) packageRecordList:%s", new Object[] { this.wLK.value });
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
      localObject = com.tencent.mm.model.c.d.aty().qu(str1);
      if (((com.tencent.mm.storage.c)localObject).isValid())
      {
        i = bt.getInt((String)((com.tencent.mm.storage.c)localObject).eJy().get("needUploadData"), 1);
        str2 = ((com.tencent.mm.storage.c)localObject).field_expId;
      }
      break;
    }
    while (i != 0)
    {
      localObject = new com.tencent.mm.modelsns.f();
      ((com.tencent.mm.modelsns.f)localObject).o("20ImgSize", this.wLS + ",");
      StringBuilder localStringBuilder = new StringBuilder();
      if (com.tencent.mm.sdk.platformtools.ay.isWifi(aj.getContext())) {}
      for (i = 1;; i = 0)
      {
        ((com.tencent.mm.modelsns.f)localObject).o("21NetType", i + ",");
        ((com.tencent.mm.modelsns.f)localObject).o("22DelayTime", this.wLF - this.wLG + ",");
        ((com.tencent.mm.modelsns.f)localObject).o("23RetCode", this.retCode + ",");
        ((com.tencent.mm.modelsns.f)localObject).o("24DnsCostTime", this.dnsCostTime + ",");
        ((com.tencent.mm.modelsns.f)localObject).o("25ConnectCostTime", this.wLG + ",");
        ((com.tencent.mm.modelsns.f)localObject).o("26SendCostTime", ",");
        ((com.tencent.mm.modelsns.f)localObject).o("27WaitResponseCostTime", this.wLN + ",");
        ((com.tencent.mm.modelsns.f)localObject).o("28ReceiveCostTime", this.wLH + ",");
        ((com.tencent.mm.modelsns.f)localObject).o("29ClientAddrIP", this.wLB + ",");
        ((com.tencent.mm.modelsns.f)localObject).o("30ServerAddrIP", this.wLC + ",");
        ((com.tencent.mm.modelsns.f)localObject).o("31dnstype", this.hKM + ",");
        ((com.tencent.mm.modelsns.f)localObject).o("32signal", com.tencent.mm.sdk.platformtools.ay.getStrength(aj.getContext()) + ",");
        ((com.tencent.mm.modelsns.f)localObject).o("33host", this.host + ",");
        ((com.tencent.mm.modelsns.f)localObject).o("34MediaType", j + ",");
        ((com.tencent.mm.modelsns.f)localObject).o("35X_Errno", this.wLD + ",");
        ((com.tencent.mm.modelsns.f)localObject).o("36MaxPackageSize", this.wLL + ",");
        ((com.tencent.mm.modelsns.f)localObject).o("37MaxPackageTimeStamp", this.wLM + ",");
        ((com.tencent.mm.modelsns.f)localObject).o("38PackageRecordList", this.wLK.value + ",");
        ((com.tencent.mm.modelsns.f)localObject).o("39ExpLayerId", str1 + ",");
        ((com.tencent.mm.modelsns.f)localObject).o("40ExpId", str2 + ",");
        ((com.tencent.mm.modelsns.f)localObject).o("41FeedId", ",");
        ad.i("MicroMsg.SnsCdnDownloadBase", "report logbuffer(13480 TLMediaFielDownloadRecord): " + ((com.tencent.mm.modelsns.f)localObject).PW());
        h.vKh.f(13480, new Object[] { localObject });
        if (this.retCode == 200) {
          break;
        }
        h.vKh.f(14071, new Object[] { localObject });
        return;
        str1 = "100106";
        break label65;
        str1 = "100100";
        break label65;
      }
      i = 0;
    }
  }
  
  public abstract boolean J(InputStream paramInputStream);
  
  public v a(v paramv)
  {
    return paramv;
  }
  
  public final boolean a(bc parambc, String paramString1, long paramLong, String paramString2)
  {
    if (paramString1 == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramString1 = new URL(paramString1);
        if ((parambc != null) && (paramString2 != null) && (paramString2.indexOf(paramString1.getHost()) != -1) && (parambc.tGD != 0))
        {
          long l = bt.lZ(parambc.tGD);
          if (l > paramLong) {
            return true;
          }
        }
      }
      catch (Exception parambc)
      {
        ad.e("MicroMsg.SnsCdnDownloadBase", "error for check dcip %s", new Object[] { parambc.getMessage() });
      }
    }
    return false;
  }
  
  public String apd(String paramString)
  {
    return paramString;
  }
  
  public final ExecutorService dnm()
  {
    return af.dte();
  }
  
  public boolean duu()
  {
    return true;
  }
  
  public abstract boolean duv();
  
  public final Integer dux()
  {
    com.tencent.mm.kernel.g.afC();
    if ((!com.tencent.mm.kernel.g.afB().isSDCardAvailable()) || (this.wLz == null))
    {
      de(false);
      return Integer.valueOf(2);
    }
    if (duu())
    {
      localObject1 = this.wLz.wEY + this.wLz.dut();
      ad.i("MicroMsg.SnsCdnDownloadBase", "[tomys] delete img: %s", new Object[] { localObject1 });
      i.deleteFile((String)localObject1);
    }
    long l3 = System.currentTimeMillis();
    this.wLI = System.currentTimeMillis();
    ad.d("MicroMsg.SnsCdnDownloadBase", "to downloadBitmap " + this.wLz.mediaId + " " + this.wLz.wLs + " type " + this.wLz.wLu);
    i.aMF(this.wLz.getPath());
    Object localObject3 = this.wLz.wLv;
    Object localObject1 = "";
    Object localObject2;
    if (localObject3 == null)
    {
      localObject1 = "";
      localObject2 = bc.FzF;
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (!bt.isNullOrNil((String)localObject1)) {
        localObject3 = "&scene=".concat(String.valueOf(localObject1));
      }
      String str2 = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.CpK), p.getString(af.dtb()), Integer.valueOf(com.tencent.mm.sdk.platformtools.ay.getNetTypeForStat(aj.getContext())), Integer.valueOf(com.tencent.mm.sdk.platformtools.ay.getStrength(aj.getContext())), localObject3 });
      this.wLz.url = apd(this.wLz.url);
      this.dnsCostTime = bt.eGO();
      label326:
      label341:
      boolean bool;
      if (this.wLz.wLt)
      {
        localObject1 = "SnsSightDomainList";
        if (!this.wLz.wLt) {
          break label934;
        }
        localObject3 = "SnsSightMainStandbyIpSwitchTime";
        localObject1 = com.tencent.mm.m.g.Zd().getValue((String)localObject1);
        long l2 = com.tencent.mm.m.g.Zd().getInt((String)localObject3, 0);
        ad.i("MicroMsg.SnsCdnDownloadBase", "pack.isAlbum %s pack.isthumb %s hostvalue %s dcipTime %s", new Object[] { Boolean.valueOf(this.wLz.wLt), Boolean.valueOf(this.wLz.wLs), localObject1, Long.valueOf(l2) });
        long l1 = l2;
        if (l2 <= 0L) {
          l1 = 259200L;
        }
        bool = a((bc)localObject2, this.wLz.url, l1, (String)localObject1);
        localObject3 = new b.b(this.wLz.url, bool);
        this.dnsCostTime = bt.vM(this.dnsCostTime);
      }
      try
      {
        if (bt.isNullOrNil(((b.b)localObject3).ip)) {}
        for (localObject1 = InetAddress.getByName(((b.b)localObject3).host).getHostAddress();; localObject1 = ((b.b)localObject3).ip)
        {
          ad.i("MicroMsg.SnsCdnDownloadBase", "checkAndGetHttpConn[%s] [%s] [id:%s] host ip:%d[%s] [%s] download type[%d] isDcIp[%s] fromScene[%s]", new Object[] { str2, this.wLz.url, this.wLz.mediaId, Integer.valueOf(((b.b)localObject3).hKM), localObject1, this.wLz.url, Integer.valueOf(this.wLz.wLu), Boolean.valueOf(bool), ((bc)localObject2).toString() });
          this.wLE = 1;
          localObject1 = a((b.b)localObject3, str2);
          localObject2 = ((b.b)localObject3).ip;
          if (localObject1 == null) {
            break label962;
          }
          bool = true;
          ad.i("MicroMsg.SnsCdnDownloadBase", "[sns ip strategy]connect ip:%s, result:%b, canRetry(X-RtFlag):%d, isDC(cold ip):%b, url:%s", new Object[] { localObject2, Boolean.valueOf(bool), Integer.valueOf(this.wLE), Boolean.valueOf(((b.b)localObject3).hKP), ((b.b)localObject3).hKO });
          int i = 2;
          if (localObject1 != null) {
            i = b((v)localObject1);
          }
          ad.i("MicroMsg.SnsCdnDownloadBase", "DOWN FIN time:%d down:%d mediaId:%s url[%s], size %d", new Object[] { Long.valueOf(bt.vM(l3)), Long.valueOf(this.wLF), this.wLz.mediaId, this.wLz.url, Integer.valueOf(this.wLS) });
          return Integer.valueOf(i);
          if (((bc)localObject3).equals(bc.Fzy))
          {
            localObject1 = "album_friend";
            localObject2 = localObject3;
            break;
          }
          if (((bc)localObject3).equals(bc.Fzz))
          {
            localObject1 = "album_self";
            localObject2 = localObject3;
            break;
          }
          if (((bc)localObject3).equals(bc.FzA))
          {
            localObject1 = "album_stranger";
            localObject2 = localObject3;
            break;
          }
          if (((bc)localObject3).equals(bc.FzB))
          {
            localObject1 = "profile_friend";
            localObject2 = localObject3;
            break;
          }
          if (((bc)localObject3).equals(bc.FzC))
          {
            localObject1 = "profile_stranger";
            localObject2 = localObject3;
            break;
          }
          if (((bc)localObject3).equals(bc.FzD))
          {
            localObject1 = "comment";
            localObject2 = localObject3;
            break;
          }
          localObject2 = localObject3;
          if (!((bc)localObject3).equals(bc.Fzx)) {
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
  
  public final void duy()
  {
    if (af.dtd()) {
      return;
    }
    System.currentTimeMillis();
    Object localObject1;
    Object localObject2;
    if (this.wLz.wAv.wBd == 4)
    {
      ad.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur thumb");
      localObject1 = q.d(this.dyS);
      localObject2 = q.f(this.dyS);
      this.wLy = com.tencent.mm.plugin.sns.lucky.a.a.iA(this.wLz.getPath() + (String)localObject1, this.wLz.getPath() + (String)localObject2);
      af.dtr().a(this.wLz.mediaId, this.wLy, this.wLz.wAv.wBd);
      label132:
      localObject1 = null;
      if (this.wLz.wAv.wBd != 0) {
        break label593;
      }
      localObject1 = "0-" + this.wLz.wAv.dnB;
    }
    for (;;)
    {
      af.dtr().aou((String)localObject1);
      return;
      if (this.wLz.wAv.wBd == 5)
      {
        ad.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur grid");
        localObject1 = q.d(this.dyS);
        localObject2 = q.g(this.dyS);
        this.wLy = com.tencent.mm.plugin.sns.lucky.a.a.iA(this.wLz.getPath() + (String)localObject1, this.wLz.getPath() + (String)localObject2);
        af.dtr().a(this.wLz.mediaId, this.wLy, this.wLz.wAv.wBd);
        break label132;
      }
      if (this.wLz.wAv.list.size() <= 1)
      {
        af.dtr().a(this.wLz.mediaId, this.wLy, this.wLz.wAv.wBd);
        break label132;
      }
      af.dtr().a(this.wLz.mediaId, this.wLy, 0);
      localObject1 = new LinkedList();
      int i = 0;
      for (;;)
      {
        if ((i >= this.wLz.wAv.list.size()) || (i >= 4)) {
          break label501;
        }
        localObject2 = (bpi)this.wLz.wAv.list.get(i);
        n localn = af.dtr().aov(((bpi)localObject2).Id);
        if (!q.b(localn)) {
          break;
        }
        ((List)localObject1).add(localn);
        ad.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap from " + localn + " " + ((bpi)localObject2).Id);
        i += 1;
      }
      label501:
      this.wLy = n.D(q.s((List)localObject1, af.dtE()));
      ad.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap " + this.wLz.wAv.dnB + " " + this.wLy);
      af.dtr().a(this.wLz.wAv.dnB, this.wLy, this.wLz.wAv.wBd);
      break label132;
      label593:
      if (this.wLz.wAv.wBd == 1) {
        localObject1 = "1-" + this.wLz.wAv.dnB;
      } else if (this.wLz.wAv.wBd == 4) {
        localObject1 = "4-" + this.wLz.wAv.dnB;
      } else if (this.wLz.wAv.wBd == 5) {
        localObject1 = "5-" + this.wLz.wAv.dnB;
      }
    }
  }
  
  protected abstract int getMediaType();
  
  public final void onPostExecute(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    if (this.wLz == null) {
      return;
    }
    ad.i("MicroMsg.SnsCdnDownloadBase", "download done result: %d, url:%s, mediaID:%s, totalSize: %d, runningTasksSize: %d", new Object[] { paramInteger, this.wLz.url, this.wLz.mediaId, Integer.valueOf(this.bVq), Integer.valueOf(wLQ.size()) });
    wLQ.remove(this.wLz.wFc);
    if ((this.wLz.wLs) && (paramInteger.intValue() != 2))
    {
      com.tencent.mm.plugin.sns.model.ay.ey(this.wLz.mediaId, this.wLz.mediaType);
      duy();
    }
    for (;;)
    {
      this.wLx.a(paramInteger.intValue(), this.dyS, this.wLz.wLu, this.wLz.wLs, this.wLz.wFc, this.bVq, -1, true);
      return;
      if ((!this.wLz.wLs) && (this.wLz.wLu == 4))
      {
        String str = this.wLz.getPath() + q.i(this.dyS);
        af.dtr().iC(this.wLz.mediaId, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.b
 * JD-Core Version:    0.7.0.1
 */