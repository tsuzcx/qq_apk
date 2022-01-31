package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.a.p;
import com.tencent.mm.memory.n;
import com.tencent.mm.network.b.b;
import com.tencent.mm.network.v;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
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

public abstract class b
  extends c
{
  private static HashSet<String> rjY = new HashSet();
  protected bcs cIc = null;
  private long dnsCostTime = -1L;
  private int exB = 0;
  private int gdn = -1;
  private String host = "";
  private int retCode = -1;
  protected c.a rjF;
  protected n rjG = null;
  protected a rjH = null;
  private String rjI = "";
  private String rjJ = "";
  private String rjK = "";
  private int rjL = 0;
  protected int rjM = 0;
  private long rjN = -1L;
  protected long rjO = -1L;
  protected long rjP = -1L;
  protected long rjQ = -1L;
  protected String rjR = "";
  protected PString rjS = new PString();
  protected int rjT;
  protected long rjU;
  protected long rjV;
  protected long rjW;
  protected int rjX = 0;
  private Map<String, List<String>> rjZ;
  int rka = 0;
  
  public b(c.a parama, a parama1)
  {
    super(parama, parama1);
    this.rjF = parama;
    this.rjH = parama1;
    if (parama1 == null) {
      return;
    }
    this.cIc = parama1.reH;
    rjY.add(parama1.reG);
    parama1.init();
  }
  
  private v a(b.b paramb, String paramString)
  {
    try
    {
      this.rjK = paramb.ip;
      this.gdn = paramb.gdn;
      this.rjO = bo.aoy();
      paramb = com.tencent.mm.network.b.a(this.rjH.url, paramb);
      paramb.setRequestMethod("GET");
      paramb.setRequestProperty("referer", paramString);
      if (bo.getInt(com.tencent.mm.m.g.Nq().getValue("SnsDownloadHttpKeep"), 0) > 0)
      {
        ab.i("MicroMsg.SnsCdnDownloadBase", "header Connection close ");
        paramb.setRequestProperty("Connection", "close");
      }
      paramb.setConnectTimeout(25000);
      paramb.setReadTimeout(25000);
      paramb = b(paramb);
      this.rjZ = paramb.getHeaderFields();
      paramString = (List)this.rjZ.get("X-ClientIp");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.rjJ = ((String)paramString.get(0));
      }
      paramString = (List)this.rjZ.get("X-ServerIp");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.rjI = ((String)paramString.get(0));
      }
      paramString = (List)this.rjZ.get("X-ErrNo");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.rjL = bo.apV((String)paramString.get(0));
      }
      paramString = (List)this.rjZ.get("X-RtFlag");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.rjM = bo.apV((String)paramString.get(0));
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
          ac(paramb.getHeaderFields());
          if (this.rjH.rjB)
          {
            if ((this.retCode >= 400) && (this.retCode < 500))
            {
              h.qsU.idkeyStat(22L, 78L, 1L, true);
              if (this.rjH.rjA) {
                h.qsU.idkeyStat(150L, 14L, 1L, true);
              }
              ab.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! mediaId : " + this.rjH.cBO + " " + this.rjH.url + " " + this.retCode);
              ce(false);
              return null;
            }
            if ((this.retCode < 500) || (this.retCode >= 600)) {
              continue;
            }
            h.qsU.idkeyStat(22L, 79L, 1L, true);
            continue;
          }
        }
        catch (SocketTimeoutException paramb)
        {
          this.retCode = 1;
          ce(false);
          paramb = paramb.getMessage();
          if (!this.rjH.rjB) {
            break label780;
          }
          h.qsU.idkeyStat(22L, 77L, 1L, true);
          if (this.rjH.rjA) {
            h.qsU.idkeyStat(150L, 14L, 1L, true);
          }
          ab.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! socket timeout mediaId : " + this.rjH.cBO + " " + this.rjH.url + " msg:" + paramb);
          return null;
          if ((this.retCode >= 400) && (this.retCode < 500))
          {
            h.qsU.idkeyStat(22L, 56L, 1L, true);
            continue;
          }
        }
        catch (Exception paramb)
        {
          ce(false);
          paramb = paramb.getMessage();
          if (this.rjH.rjA) {
            h.qsU.idkeyStat(150L, 14L, 1L, true);
          }
          ab.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! mediaId : " + this.rjH.cBO + " " + this.rjH.url + " msg:" + paramb);
          return null;
        }
        if ((this.retCode >= 500) && (this.retCode < 600))
        {
          h.qsU.idkeyStat(22L, 57L, 1L, true);
          continue;
          label780:
          h.qsU.idkeyStat(22L, 55L, 1L, true);
        }
      }
      ac(paramb.getHeaderFields());
    }
    catch (Exception paramb)
    {
      ab.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", paramb, "connect fail : " + paramb.getMessage(), new Object[0]);
      this.retCode = 2;
      ce(false);
      return null;
    }
    if (!d(paramb))
    {
      h.qsU.idkeyStat(22L, 62L, 1L, true);
      ab.e("MicroMsg.SnsCdnDownloadBase", "checkHttpConnection failed! nocache mediaId : " + this.rjH.cBO);
      ce(false);
      return null;
    }
    this.rjO = bo.hl(this.rjO);
    paramString = (List)this.rjZ.get("Content-Length");
    if ((paramString != null) && (paramString.size() > 0)) {
      this.rjX = bo.apV((String)paramString.get(0));
    }
    ab.i("MicroMsg.SnsCdnDownloadBase", "ip: url %s client ip %s server ip %s svrlen %d %d", new Object[] { this.rjH.url, this.rjJ, this.rjI, Integer.valueOf(this.rjX), Integer.valueOf(this.rjL) });
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
  
  private static long aaX(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return 0L;
    }
    try
    {
      paramString = paramString.split("\\.");
      long l1 = bo.getLong(paramString[0], 0L);
      long l2 = bo.getLong(paramString[1], 0L);
      long l3 = bo.getLong(paramString[2], 0L);
      long l4 = bo.getLong(paramString[3], 0L);
      return l4 + (16777216L * l1 + 65536L * l2 + 256L * l3);
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  private static void ac(Map<String, List<String>> paramMap)
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
      ab.i("MicroMsg.SnsCdnDownloadBase", "header respone %s", new Object[] { localStringBuffer.toString() });
      return;
    }
    catch (Exception paramMap) {}
  }
  
  /* Error */
  private int c(v paramv)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokestatic 142	com/tencent/mm/sdk/platformtools/bo:aoy	()J
    //   7: putfield 448	com/tencent/mm/plugin/sns/model/a/b:rjW	J
    //   10: aload_1
    //   11: invokevirtual 452	com/tencent/mm/network/v:getInputStream	()Ljava/io/InputStream;
    //   14: astore_3
    //   15: aload_0
    //   16: invokestatic 142	com/tencent/mm/sdk/platformtools/bo:aoy	()J
    //   19: putfield 87	com/tencent/mm/plugin/sns/model/a/b:rjP	J
    //   22: aload_0
    //   23: aload_3
    //   24: invokevirtual 456	com/tencent/mm/plugin/sns/model/a/b:A	(Ljava/io/InputStream;)Z
    //   27: istore_2
    //   28: aload_3
    //   29: invokevirtual 460	java/io/InputStream:close	()V
    //   32: ldc 184
    //   34: ldc_w 462
    //   37: iload_2
    //   38: invokestatic 465	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   41: invokevirtual 468	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   44: invokestatic 191	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: iload_2
    //   48: ifne +18 -> 66
    //   51: aload_0
    //   52: iconst_0
    //   53: invokespecial 310	com/tencent/mm/plugin/sns/model/a/b:ce	(Z)V
    //   56: aload_1
    //   57: ifnull +7 -> 64
    //   60: aload_1
    //   61: invokevirtual 471	com/tencent/mm/network/v:disconnect	()V
    //   64: iconst_2
    //   65: ireturn
    //   66: aload_0
    //   67: aload_0
    //   68: getfield 87	com/tencent/mm/plugin/sns/model/a/b:rjP	J
    //   71: invokestatic 348	com/tencent/mm/sdk/platformtools/bo:hl	(J)J
    //   74: putfield 87	com/tencent/mm/plugin/sns/model/a/b:rjP	J
    //   77: aload_0
    //   78: aload_0
    //   79: getfield 89	com/tencent/mm/plugin/sns/model/a/b:rjQ	J
    //   82: invokestatic 348	com/tencent/mm/sdk/platformtools/bo:hl	(J)J
    //   85: putfield 79	com/tencent/mm/plugin/sns/model/a/b:rjN	J
    //   88: aload_0
    //   89: invokevirtual 474	com/tencent/mm/plugin/sns/model/a/b:cpR	()Z
    //   92: istore_2
    //   93: ldc 184
    //   95: ldc_w 476
    //   98: iload_2
    //   99: invokestatic 465	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   102: invokevirtual 468	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   105: invokestatic 191	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: iload_2
    //   109: ifne +23 -> 132
    //   112: aload_0
    //   113: iconst_3
    //   114: putfield 98	com/tencent/mm/plugin/sns/model/a/b:retCode	I
    //   117: aload_0
    //   118: iconst_0
    //   119: invokespecial 310	com/tencent/mm/plugin/sns/model/a/b:ce	(Z)V
    //   122: aload_1
    //   123: ifnull -59 -> 64
    //   126: aload_1
    //   127: invokevirtual 471	com/tencent/mm/network/v:disconnect	()V
    //   130: iconst_2
    //   131: ireturn
    //   132: aload_1
    //   133: ifnull +7 -> 140
    //   136: aload_1
    //   137: invokevirtual 471	com/tencent/mm/network/v:disconnect	()V
    //   140: aload_0
    //   141: iconst_1
    //   142: invokespecial 310	com/tencent/mm/plugin/sns/model/a/b:ce	(Z)V
    //   145: aload_0
    //   146: getfield 61	com/tencent/mm/plugin/sns/model/a/b:rjH	Lcom/tencent/mm/plugin/sns/model/a/a;
    //   149: getfield 278	com/tencent/mm/plugin/sns/model/a/a:rjA	Z
    //   152: ifeq +124 -> 276
    //   155: iconst_3
    //   156: ireturn
    //   157: astore 4
    //   159: aconst_null
    //   160: astore_3
    //   161: ldc 184
    //   163: aload 4
    //   165: new 284	java/lang/StringBuilder
    //   168: dup
    //   169: ldc_w 478
    //   172: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   175: aload 4
    //   177: invokevirtual 324	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   180: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: iconst_0
    //   187: anewarray 332	java/lang/Object
    //   190: invokestatic 336	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   193: aload_0
    //   194: iconst_4
    //   195: putfield 98	com/tencent/mm/plugin/sns/model/a/b:retCode	I
    //   198: aload_0
    //   199: iconst_0
    //   200: invokespecial 310	com/tencent/mm/plugin/sns/model/a/b:ce	(Z)V
    //   203: aload_3
    //   204: ifnull +7 -> 211
    //   207: aload_3
    //   208: invokevirtual 460	java/io/InputStream:close	()V
    //   211: aload_1
    //   212: ifnull -148 -> 64
    //   215: aload_1
    //   216: invokevirtual 471	com/tencent/mm/network/v:disconnect	()V
    //   219: iconst_2
    //   220: ireturn
    //   221: astore_3
    //   222: ldc 184
    //   224: aload_3
    //   225: ldc 65
    //   227: iconst_0
    //   228: anewarray 332	java/lang/Object
    //   231: invokestatic 336	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: goto -23 -> 211
    //   237: astore_3
    //   238: aload 4
    //   240: ifnull +8 -> 248
    //   243: aload 4
    //   245: invokevirtual 460	java/io/InputStream:close	()V
    //   248: aload_1
    //   249: ifnull +7 -> 256
    //   252: aload_1
    //   253: invokevirtual 471	com/tencent/mm/network/v:disconnect	()V
    //   256: aload_3
    //   257: athrow
    //   258: astore 4
    //   260: ldc 184
    //   262: aload 4
    //   264: ldc 65
    //   266: iconst_0
    //   267: anewarray 332	java/lang/Object
    //   270: invokestatic 336	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  private void ce(boolean paramBoolean)
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
    if ((this.rjH != null) && (this.rjH.rjB)) {
      if (!paramBoolean)
      {
        h.qsU.idkeyStat(22L, 74L, 1L, true);
        h.qsU.idkeyStat(22L, 73L, 1L, true);
        if ((this.rjH != null) && (this.rjH.rjA) && (!paramBoolean) && (!i.b(this.rjG))) {
          h.qsU.idkeyStat(150L, 66L, 1L, true);
        }
        this.exB = this.rka;
        if (!at.isWifi(ah.getContext())) {
          break label735;
        }
        j = 1;
        k = at.getStrength(ah.getContext());
        i = this.gdn;
        l1 = this.dnsCostTime;
        l2 = this.rjO;
        long l3 = this.rjP;
        long l4 = this.rjN;
        localObject = this.rjI;
        String str2 = this.rjK;
        String str3 = this.rjJ;
        if (this.rjH != null) {
          break label740;
        }
        str1 = "";
        ab.v("MicroMsg.SnsCdnDownloadBase", "report dns:%d wifi:%d signal:%d [%d,%d,%d]%d serverIp:[%s,%s] xclientip:%s url[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), localObject, str2, str3, str1 });
        m = at.getNetType(ah.getContext());
        i = 0;
        if (this.rjH != null)
        {
          if (this.rjH.rjC != 4) {
            break label752;
          }
          i = 1;
        }
        label301:
        ab.i("MicroMsg.SnsCdnDownloadBase", "retCode :%d totalSize: %d net: %d downloadType %d xErrorNo %d", new Object[] { Integer.valueOf(this.retCode), Integer.valueOf(this.exB), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.rjL) });
        localObject = h.qsU;
        if (this.rjH != null) {
          break label757;
        }
        str1 = "";
        label374:
        l2 = aaX(this.rjK);
        if (!paramBoolean) {
          break label769;
        }
      }
    }
    label769:
    for (long l1 = this.rjN;; l1 = 0L)
    {
      ((h)localObject).e(10736, new Object[] { str1, Long.valueOf(l2), Long.valueOf(l1), "", Integer.valueOf(j), Long.valueOf(this.dnsCostTime), Long.valueOf(this.rjO), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(this.rjP), Long.valueOf(aaX(this.rjJ)), Long.valueOf(aaX(this.rjI)), Integer.valueOf(this.gdn), Integer.valueOf(k), Integer.valueOf(this.retCode), Integer.valueOf(this.exB), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.rjL) });
      boolean bool = at.isConnected(ah.getContext());
      ab.d("MicroMsg.SnsCdnDownloadBase", "isConntected  " + bool + " urlIp: " + this.rjR);
      if ((!paramBoolean) && (!bo.isNullOrNil(this.rjR)) && (bool)) {
        com.tencent.mm.network.b.reportFailIp(this.rjR);
      }
      cpT();
      return;
      h.qsU.idkeyStat(22L, 75L, this.rjN, true);
      break;
      if (!paramBoolean) {
        h.qsU.idkeyStat(22L, 52L, 1L, true);
      }
      for (;;)
      {
        h.qsU.idkeyStat(22L, 51L, 1L, true);
        break;
        h.qsU.idkeyStat(22L, 53L, this.rjN, true);
      }
      label735:
      j = 0;
      break label113;
      label740:
      str1 = this.rjH.url;
      break label179;
      label752:
      i = 0;
      break label301;
      label757:
      str1 = this.rjH.url;
      break label374;
    }
  }
  
  private void cpT()
  {
    ab.i("MicroMsg.SnsCdnDownloadBase", "ready to report logbuffer(13346) packageRecordList:%s", new Object[] { this.rjS.value });
    int j = cpS();
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
      localObject = com.tencent.mm.model.c.c.abU().me(str1);
      if (((com.tencent.mm.storage.c)localObject).isValid())
      {
        i = bo.getInt((String)((com.tencent.mm.storage.c)localObject).dvN().get("needUploadData"), 1);
        str2 = ((com.tencent.mm.storage.c)localObject).field_expId;
      }
      break;
    }
    while (i != 0)
    {
      localObject = new com.tencent.mm.modelsns.d();
      ((com.tencent.mm.modelsns.d)localObject).k("20ImgSize", this.rka + ",");
      StringBuilder localStringBuilder = new StringBuilder();
      if (at.isWifi(ah.getContext())) {}
      for (i = 1;; i = 0)
      {
        ((com.tencent.mm.modelsns.d)localObject).k("21NetType", i + ",");
        ((com.tencent.mm.modelsns.d)localObject).k("22DelayTime", this.rjN - this.rjO + ",");
        ((com.tencent.mm.modelsns.d)localObject).k("23RetCode", this.retCode + ",");
        ((com.tencent.mm.modelsns.d)localObject).k("24DnsCostTime", this.dnsCostTime + ",");
        ((com.tencent.mm.modelsns.d)localObject).k("25ConnectCostTime", this.rjO + ",");
        ((com.tencent.mm.modelsns.d)localObject).k("26SendCostTime", ",");
        ((com.tencent.mm.modelsns.d)localObject).k("27WaitResponseCostTime", this.rjV + ",");
        ((com.tencent.mm.modelsns.d)localObject).k("28ReceiveCostTime", this.rjP + ",");
        ((com.tencent.mm.modelsns.d)localObject).k("29ClientAddrIP", this.rjJ + ",");
        ((com.tencent.mm.modelsns.d)localObject).k("30ServerAddrIP", this.rjK + ",");
        ((com.tencent.mm.modelsns.d)localObject).k("31dnstype", this.gdn + ",");
        ((com.tencent.mm.modelsns.d)localObject).k("32signal", at.getStrength(ah.getContext()) + ",");
        ((com.tencent.mm.modelsns.d)localObject).k("33host", this.host + ",");
        ((com.tencent.mm.modelsns.d)localObject).k("34MediaType", j + ",");
        ((com.tencent.mm.modelsns.d)localObject).k("35X_Errno", this.rjL + ",");
        ((com.tencent.mm.modelsns.d)localObject).k("36MaxPackageSize", this.rjT + ",");
        ((com.tencent.mm.modelsns.d)localObject).k("37MaxPackageTimeStamp", this.rjU + ",");
        ((com.tencent.mm.modelsns.d)localObject).k("38PackageRecordList", this.rjS.value + ",");
        ((com.tencent.mm.modelsns.d)localObject).k("39ExpLayerId", str1 + ",");
        ((com.tencent.mm.modelsns.d)localObject).k("40ExpId", str2 + ",");
        ((com.tencent.mm.modelsns.d)localObject).k("41FeedId", ",");
        ab.i("MicroMsg.SnsCdnDownloadBase", "report logbuffer(13480 TLMediaFielDownloadRecord): " + ((com.tencent.mm.modelsns.d)localObject).Fg());
        h.qsU.e(13480, new Object[] { localObject });
        if (this.retCode == 200) {
          break;
        }
        h.qsU.e(14071, new Object[] { localObject });
        return;
        str1 = "100106";
        break label65;
        str1 = "100100";
        break label65;
      }
      i = 0;
    }
  }
  
  private static boolean d(v paramv)
  {
    try
    {
      paramv = (List)paramv.getHeaderFields().get("cache-control");
      if ((paramv != null) && (paramv.size() != 0))
      {
        if ((bo.isNullOrNil(paramv.toString())) || (!paramv.toString().contains("no-cache"))) {
          break label94;
        }
        boolean bool = paramv.toString().contains("no-cache");
        return !bool;
      }
    }
    catch (Exception paramv)
    {
      ab.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", paramv, "", new Object[0]);
      return false;
    }
    return true;
    label94:
    return true;
  }
  
  public abstract boolean A(InputStream paramInputStream);
  
  public final boolean a(az paramaz, String paramString1, long paramLong, String paramString2)
  {
    if (paramString1 == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramString1 = new URL(paramString1);
        if ((paramaz != null) && (paramString2 != null) && (paramString2.indexOf(paramString1.getHost()) != -1) && (paramaz.oLs != 0))
        {
          long l = bo.gz(paramaz.oLs);
          if (l > paramLong) {
            return true;
          }
        }
      }
      catch (Exception paramaz)
      {
        ab.e("MicroMsg.SnsCdnDownloadBase", "error for check dcip %s", new Object[] { paramaz.getMessage() });
      }
    }
    return false;
  }
  
  public String aaW(String paramString)
  {
    return paramString;
  }
  
  public v b(v paramv)
  {
    return paramv;
  }
  
  public final com.tencent.mm.sdk.g.b.a cjN()
  {
    return ag.coP();
  }
  
  public boolean cpQ()
  {
    return true;
  }
  
  public abstract boolean cpR();
  
  protected abstract int cpS();
  
  public final Integer cpU()
  {
    com.tencent.mm.kernel.g.RM();
    if ((!com.tencent.mm.kernel.g.RL().isSDCardAvailable()) || (this.rjH == null))
    {
      ce(false);
      return Integer.valueOf(2);
    }
    if (cpQ())
    {
      localObject1 = this.rjH.reC + this.rjH.cpP();
      ab.i("MicroMsg.SnsCdnDownloadBase", "[tomys] delete img: %s", new Object[] { localObject1 });
      com.tencent.mm.vfs.e.deleteFile((String)localObject1);
    }
    long l3 = System.currentTimeMillis();
    this.rjQ = System.currentTimeMillis();
    ab.d("MicroMsg.SnsCdnDownloadBase", "to downloadBitmap " + this.rjH.cBO + " " + this.rjH.rjA + " type " + this.rjH.rjC);
    com.tencent.mm.vfs.e.um(this.rjH.getPath());
    Object localObject3 = this.rjH.rjD;
    Object localObject1 = "";
    Object localObject2;
    if (localObject3 == null)
    {
      localObject1 = "";
      localObject2 = az.yNU;
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (!bo.isNullOrNil((String)localObject1)) {
        localObject3 = "&scene=".concat(String.valueOf(localObject1));
      }
      String str2 = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.whH), p.getString(ag.coL()), Integer.valueOf(at.getNetTypeForStat(ah.getContext())), Integer.valueOf(at.getStrength(ah.getContext())), localObject3 });
      this.rjH.url = aaW(this.rjH.url);
      this.dnsCostTime = bo.aoy();
      label326:
      label341:
      boolean bool;
      if (this.rjH.rjB)
      {
        localObject1 = "SnsSightDomainList";
        if (!this.rjH.rjB) {
          break label934;
        }
        localObject3 = "SnsSightMainStandbyIpSwitchTime";
        localObject1 = com.tencent.mm.m.g.Nq().getValue((String)localObject1);
        long l2 = com.tencent.mm.m.g.Nq().getInt((String)localObject3, 0);
        ab.i("MicroMsg.SnsCdnDownloadBase", "pack.isAlbum %s pack.isthumb %s hostvalue %s dcipTime %s", new Object[] { Boolean.valueOf(this.rjH.rjB), Boolean.valueOf(this.rjH.rjA), localObject1, Long.valueOf(l2) });
        long l1 = l2;
        if (l2 <= 0L) {
          l1 = 259200L;
        }
        bool = a((az)localObject2, this.rjH.url, l1, (String)localObject1);
        localObject3 = new b.b(this.rjH.url, bool);
        this.dnsCostTime = bo.hl(this.dnsCostTime);
      }
      try
      {
        if (bo.isNullOrNil(((b.b)localObject3).ip)) {}
        for (localObject1 = InetAddress.getByName(((b.b)localObject3).host).getHostAddress();; localObject1 = ((b.b)localObject3).ip)
        {
          ab.i("MicroMsg.SnsCdnDownloadBase", "checkAndGetHttpConn[%s] [%s] [id:%s] host ip:%d[%s] [%s] download type[%d] isDcIp[%s] fromScene[%s]", new Object[] { str2, this.rjH.url, this.rjH.cBO, Integer.valueOf(((b.b)localObject3).gdn), localObject1, this.rjH.url, Integer.valueOf(this.rjH.rjC), Boolean.valueOf(bool), ((az)localObject2).toString() });
          this.rjM = 1;
          localObject1 = a((b.b)localObject3, str2);
          localObject2 = ((b.b)localObject3).ip;
          if (localObject1 == null) {
            break label962;
          }
          bool = true;
          ab.i("MicroMsg.SnsCdnDownloadBase", "[sns ip strategy]connect ip:%s, result:%b, canRetry(X-RtFlag):%d, isDC(cold ip):%b, url:%s", new Object[] { localObject2, Boolean.valueOf(bool), Integer.valueOf(this.rjM), Boolean.valueOf(((b.b)localObject3).gdq), ((b.b)localObject3).gdp });
          int i = 2;
          if (localObject1 != null) {
            i = c((v)localObject1);
          }
          ab.i("MicroMsg.SnsCdnDownloadBase", "DOWN FIN time:%d down:%d mediaId:%s url[%s], size %d", new Object[] { Long.valueOf(bo.hl(l3)), Long.valueOf(this.rjN), this.rjH.cBO, this.rjH.url, Integer.valueOf(this.rka) });
          return Integer.valueOf(i);
          if (((az)localObject3).equals(az.yNN))
          {
            localObject1 = "album_friend";
            localObject2 = localObject3;
            break;
          }
          if (((az)localObject3).equals(az.yNO))
          {
            localObject1 = "album_self";
            localObject2 = localObject3;
            break;
          }
          if (((az)localObject3).equals(az.yNP))
          {
            localObject1 = "album_stranger";
            localObject2 = localObject3;
            break;
          }
          if (((az)localObject3).equals(az.yNQ))
          {
            localObject1 = "profile_friend";
            localObject2 = localObject3;
            break;
          }
          if (((az)localObject3).equals(az.yNR))
          {
            localObject1 = "profile_stranger";
            localObject2 = localObject3;
            break;
          }
          if (((az)localObject3).equals(az.yNS))
          {
            localObject1 = "comment";
            localObject2 = localObject3;
            break;
          }
          localObject2 = localObject3;
          if (!((az)localObject3).equals(az.yNM)) {
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
  
  public final void cpV()
  {
    if (ag.coN()) {
      return;
    }
    System.currentTimeMillis();
    Object localObject1;
    Object localObject2;
    if (this.rjH.rbc.rbj == 4)
    {
      ab.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur thumb");
      localObject1 = i.e(this.cIc);
      localObject2 = i.g(this.cIc);
      this.rjG = com.tencent.mm.plugin.sns.lucky.a.a.gh(this.rjH.getPath() + (String)localObject1, this.rjH.getPath() + (String)localObject2);
      ag.cpc().a(this.rjH.cBO, this.rjG, this.rjH.rbc.rbj);
      label132:
      localObject1 = null;
      if (this.rjH.rbc.rbj != 0) {
        break label593;
      }
      localObject1 = "0-" + this.rjH.rbc.ohe;
    }
    for (;;)
    {
      ag.cpc().aal((String)localObject1);
      return;
      if (this.rjH.rbc.rbj == 5)
      {
        ab.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur grid");
        localObject1 = i.e(this.cIc);
        localObject2 = i.h(this.cIc);
        this.rjG = com.tencent.mm.plugin.sns.lucky.a.a.gh(this.rjH.getPath() + (String)localObject1, this.rjH.getPath() + (String)localObject2);
        ag.cpc().a(this.rjH.cBO, this.rjG, this.rjH.rbc.rbj);
        break label132;
      }
      if (this.rjH.rbc.list.size() <= 1)
      {
        ag.cpc().a(this.rjH.cBO, this.rjG, this.rjH.rbc.rbj);
        break label132;
      }
      ag.cpc().a(this.rjH.cBO, this.rjG, 0);
      localObject1 = new LinkedList();
      int i = 0;
      for (;;)
      {
        if ((i >= this.rjH.rbc.list.size()) || (i >= 4)) {
          break label501;
        }
        localObject2 = (bcs)this.rjH.rbc.list.get(i);
        n localn = ag.cpc().aam(((bcs)localObject2).Id);
        if (!i.b(localn)) {
          break;
        }
        ((List)localObject1).add(localn);
        ab.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap from " + localn + " " + ((bcs)localObject2).Id);
        i += 1;
      }
      label501:
      this.rjG = n.v(i.o((List)localObject1, ag.cpn()));
      ab.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap " + this.rjH.rbc.ohe + " " + this.rjG);
      ag.cpc().a(this.rjH.rbc.ohe, this.rjG, this.rjH.rbc.rbj);
      break label132;
      label593:
      if (this.rjH.rbc.rbj == 1) {
        localObject1 = "1-" + this.rjH.rbc.ohe;
      } else if (this.rjH.rbc.rbj == 4) {
        localObject1 = "4-" + this.rjH.rbc.ohe;
      } else if (this.rjH.rbc.rbj == 5) {
        localObject1 = "5-" + this.rjH.rbc.ohe;
      }
    }
  }
  
  public final void onPostExecute(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    if (this.rjH == null) {
      return;
    }
    ab.i("MicroMsg.SnsCdnDownloadBase", "download done result: %d, url:%s, mediaID:%s, totalSize: %d, runningTasksSize: %d", new Object[] { paramInteger, this.rjH.url, this.rjH.cBO, Integer.valueOf(this.exB), Integer.valueOf(rjY.size()) });
    rjY.remove(this.rjH.reG);
    if ((this.rjH.rjA) && (paramInteger.intValue() != 2))
    {
      aw.aaI(this.rjH.cBO);
      cpV();
    }
    for (;;)
    {
      this.rjF.a(paramInteger.intValue(), this.cIc, this.rjH.rjC, this.rjH.rjA, this.rjH.reG, this.exB, -1, true);
      return;
      if ((!this.rjH.rjA) && (this.rjH.rjC == 4))
      {
        String str = this.rjH.getPath() + i.j(this.cIc);
        ag.cpc().gj(this.rjH.cBO, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.b
 * JD-Core Version:    0.7.0.1
 */