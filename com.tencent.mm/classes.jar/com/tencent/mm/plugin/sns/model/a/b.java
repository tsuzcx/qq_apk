package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.a.o;
import com.tencent.mm.memory.n;
import com.tencent.mm.network.b.b;
import com.tencent.mm.network.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  private static HashSet<String> ovg = new HashSet();
  protected awd bZK = null;
  private long dnsCostTime = -1L;
  private int eNz = -1;
  private String host = "";
  protected c.a ouM;
  protected n ouN = null;
  protected a ouO = null;
  private String ouP = "";
  private String ouQ = "";
  private String ouR = "";
  private int ouS = 0;
  protected int ouT = 0;
  private long ouU = -1L;
  protected long ouV = -1L;
  protected long ouW = -1L;
  protected long ouX = -1L;
  protected String ouY = "";
  protected PString ouZ = new PString();
  protected int ova;
  protected long ovb;
  protected long ovc;
  protected long ovd;
  private int ove = 0;
  protected int ovf = 0;
  private Map<String, List<String>> ovh;
  int ovi = 0;
  private int retCode = -1;
  
  public b(c.a parama, a parama1)
  {
    super(parama, parama1);
    this.ouM = parama;
    this.ouO = parama1;
    if (parama1 == null) {
      return;
    }
    this.bZK = parama1.oqa;
    ovg.add(parama1.opZ);
    parama1.init();
  }
  
  private static void K(Map<String, List<String>> paramMap)
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
      y.i("MicroMsg.SnsCdnDownloadBase", "header respone %s", new Object[] { localStringBuffer.toString() });
      return;
    }
    catch (Exception paramMap) {}
  }
  
  private static long Od(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return 0L;
    }
    try
    {
      paramString = paramString.split("\\.");
      long l1 = bk.getLong(paramString[0], 0L);
      long l2 = bk.getLong(paramString[1], 0L);
      long l3 = bk.getLong(paramString[2], 0L);
      long l4 = bk.getLong(paramString[3], 0L);
      return l4 + (16777216L * l1 + 65536L * l2 + 256L * l3);
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  private u a(b.b paramb, String paramString)
  {
    try
    {
      this.ouR = paramb.ip;
      this.eNz = paramb.eNz;
      this.ouV = bk.UY();
      paramb = com.tencent.mm.network.b.a(this.ouO.url, paramb);
      paramb.setRequestMethod("GET");
      paramb.setRequestProperty("referer", paramString);
      if (bk.getInt(com.tencent.mm.m.g.AA().getValue("SnsDownloadHttpKeep"), 0) > 0)
      {
        y.i("MicroMsg.SnsCdnDownloadBase", "header Connection close ");
        paramb.setRequestProperty("Connection", "close");
      }
      paramb.setConnectTimeout(25000);
      paramb.setReadTimeout(25000);
      paramb = b(paramb);
      this.ovh = paramb.getHeaderFields();
      paramString = (List)this.ovh.get("X-ClientIp");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.ouQ = ((String)paramString.get(0));
      }
      paramString = (List)this.ovh.get("X-ServerIp");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.ouP = ((String)paramString.get(0));
      }
      paramString = (List)this.ovh.get("X-ErrNo");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.ouS = bk.ZR((String)paramString.get(0));
      }
      paramString = (List)this.ovh.get("X-RtFlag");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.ouT = bk.ZR((String)paramString.get(0));
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
          K(paramb.getHeaderFields());
          if (this.ouO.ouI)
          {
            if ((this.retCode >= 400) && (this.retCode < 500))
            {
              h.nFQ.a(22L, 78L, 1L, true);
              if (this.ouO.ouH) {
                h.nFQ.a(150L, 14L, 1L, true);
              }
              y.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! mediaId : " + this.ouO.bUi + " " + this.ouO.url + " " + this.retCode);
              iV(false);
              return null;
            }
            if ((this.retCode < 500) || (this.retCode >= 600)) {
              continue;
            }
            h.nFQ.a(22L, 79L, 1L, true);
            continue;
          }
        }
        catch (SocketTimeoutException paramb)
        {
          this.retCode = 1;
          iV(false);
          paramb = paramb.getMessage();
          if (!this.ouO.ouI) {
            break label788;
          }
          h.nFQ.a(22L, 77L, 1L, true);
          if (this.ouO.ouH) {
            h.nFQ.a(150L, 14L, 1L, true);
          }
          y.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! socket timeout mediaId : " + this.ouO.bUi + " " + this.ouO.url + " msg:" + paramb);
          return null;
          if ((this.retCode >= 400) && (this.retCode < 500))
          {
            h.nFQ.a(22L, 56L, 1L, true);
            continue;
          }
        }
        catch (Exception paramb)
        {
          iV(false);
          paramb = paramb.getMessage();
          if (this.ouO.ouH) {
            h.nFQ.a(150L, 14L, 1L, true);
          }
          y.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! mediaId : " + this.ouO.bUi + " " + this.ouO.url + " msg:" + paramb);
          return null;
        }
        if ((this.retCode >= 500) && (this.retCode < 600))
        {
          h.nFQ.a(22L, 57L, 1L, true);
          continue;
          label788:
          h.nFQ.a(22L, 55L, 1L, true);
        }
      }
      K(paramb.getHeaderFields());
    }
    catch (Exception paramb)
    {
      y.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", paramb, "connect fail : " + paramb.getMessage(), new Object[0]);
      this.retCode = 2;
      iV(false);
      return null;
    }
    if (!d(paramb))
    {
      h.nFQ.a(22L, 62L, 1L, true);
      y.e("MicroMsg.SnsCdnDownloadBase", "checkHttpConnection failed! nocache mediaId : " + this.ouO.bUi);
      iV(false);
      return null;
    }
    this.ouV = bk.co(this.ouV);
    paramString = (List)this.ovh.get("Content-Length");
    if ((paramString != null) && (paramString.size() > 0)) {
      this.ovf = bk.ZR((String)paramString.get(0));
    }
    y.i("MicroMsg.SnsCdnDownloadBase", "ip: url %s client ip %s server ip %s svrlen %d %d", new Object[] { this.ouO.url, this.ouQ, this.ouP, Integer.valueOf(this.ovf), Integer.valueOf(this.ouS) });
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
  
  /* Error */
  private int c(u paramu)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokestatic 234	com/tencent/mm/sdk/platformtools/bk:UY	()J
    //   7: putfield 447	com/tencent/mm/plugin/sns/model/a/b:ovd	J
    //   10: aload_1
    //   11: invokevirtual 451	com/tencent/mm/network/u:getInputStream	()Ljava/io/InputStream;
    //   14: astore_3
    //   15: aload_0
    //   16: invokestatic 234	com/tencent/mm/sdk/platformtools/bk:UY	()J
    //   19: putfield 87	com/tencent/mm/plugin/sns/model/a/b:ouW	J
    //   22: aload_0
    //   23: aload_3
    //   24: invokevirtual 455	com/tencent/mm/plugin/sns/model/a/b:A	(Ljava/io/InputStream;)Z
    //   27: istore_2
    //   28: aload_3
    //   29: invokevirtual 459	java/io/InputStream:close	()V
    //   32: ldc 183
    //   34: new 162	java/lang/StringBuilder
    //   37: dup
    //   38: ldc_w 461
    //   41: invokespecial 358	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   44: iload_2
    //   45: invokevirtual 464	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   48: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 278	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: iload_2
    //   55: ifne +21 -> 76
    //   58: aload_0
    //   59: iconst_0
    //   60: invokespecial 373	com/tencent/mm/plugin/sns/model/a/b:iV	(Z)V
    //   63: aload_1
    //   64: ifnull +10 -> 74
    //   67: aload_1
    //   68: getfield 468	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
    //   71: invokevirtual 473	java/net/HttpURLConnection:disconnect	()V
    //   74: iconst_2
    //   75: ireturn
    //   76: aload_0
    //   77: aload_0
    //   78: getfield 87	com/tencent/mm/plugin/sns/model/a/b:ouW	J
    //   81: invokestatic 409	com/tencent/mm/sdk/platformtools/bk:co	(J)J
    //   84: putfield 87	com/tencent/mm/plugin/sns/model/a/b:ouW	J
    //   87: aload_0
    //   88: aload_0
    //   89: getfield 89	com/tencent/mm/plugin/sns/model/a/b:ouX	J
    //   92: invokestatic 409	com/tencent/mm/sdk/platformtools/bk:co	(J)J
    //   95: putfield 79	com/tencent/mm/plugin/sns/model/a/b:ouU	J
    //   98: aload_0
    //   99: invokevirtual 476	com/tencent/mm/plugin/sns/model/a/b:bEs	()Z
    //   102: istore_2
    //   103: ldc 183
    //   105: new 162	java/lang/StringBuilder
    //   108: dup
    //   109: ldc_w 478
    //   112: invokespecial 358	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   115: iload_2
    //   116: invokevirtual 464	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   119: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 278	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: iload_2
    //   126: ifne +26 -> 152
    //   129: aload_0
    //   130: iconst_3
    //   131: putfield 98	com/tencent/mm/plugin/sns/model/a/b:retCode	I
    //   134: aload_0
    //   135: iconst_0
    //   136: invokespecial 373	com/tencent/mm/plugin/sns/model/a/b:iV	(Z)V
    //   139: aload_1
    //   140: ifnull -66 -> 74
    //   143: aload_1
    //   144: getfield 468	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
    //   147: invokevirtual 473	java/net/HttpURLConnection:disconnect	()V
    //   150: iconst_2
    //   151: ireturn
    //   152: aload_1
    //   153: ifnull +10 -> 163
    //   156: aload_1
    //   157: getfield 468	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
    //   160: invokevirtual 473	java/net/HttpURLConnection:disconnect	()V
    //   163: aload_0
    //   164: iconst_1
    //   165: invokespecial 373	com/tencent/mm/plugin/sns/model/a/b:iV	(Z)V
    //   168: aload_0
    //   169: getfield 61	com/tencent/mm/plugin/sns/model/a/b:ouO	Lcom/tencent/mm/plugin/sns/model/a/a;
    //   172: getfield 350	com/tencent/mm/plugin/sns/model/a/a:ouH	Z
    //   175: ifeq +130 -> 305
    //   178: iconst_3
    //   179: ireturn
    //   180: astore 4
    //   182: aconst_null
    //   183: astore_3
    //   184: ldc 183
    //   186: aload 4
    //   188: new 162	java/lang/StringBuilder
    //   191: dup
    //   192: ldc_w 480
    //   195: invokespecial 358	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   198: aload 4
    //   200: invokevirtual 387	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   203: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: iconst_0
    //   210: anewarray 187	java/lang/Object
    //   213: invokestatic 397	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   216: aload_0
    //   217: iconst_4
    //   218: putfield 98	com/tencent/mm/plugin/sns/model/a/b:retCode	I
    //   221: aload_0
    //   222: iconst_0
    //   223: invokespecial 373	com/tencent/mm/plugin/sns/model/a/b:iV	(Z)V
    //   226: aload_3
    //   227: ifnull +7 -> 234
    //   230: aload_3
    //   231: invokevirtual 459	java/io/InputStream:close	()V
    //   234: aload_1
    //   235: ifnull -161 -> 74
    //   238: aload_1
    //   239: getfield 468	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
    //   242: invokevirtual 473	java/net/HttpURLConnection:disconnect	()V
    //   245: iconst_2
    //   246: ireturn
    //   247: astore_3
    //   248: ldc 183
    //   250: aload_3
    //   251: ldc 65
    //   253: iconst_0
    //   254: anewarray 187	java/lang/Object
    //   257: invokestatic 397	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: goto -26 -> 234
    //   263: astore_3
    //   264: aload 4
    //   266: ifnull +8 -> 274
    //   269: aload 4
    //   271: invokevirtual 459	java/io/InputStream:close	()V
    //   274: aload_1
    //   275: ifnull +10 -> 285
    //   278: aload_1
    //   279: getfield 468	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
    //   282: invokevirtual 473	java/net/HttpURLConnection:disconnect	()V
    //   285: aload_3
    //   286: athrow
    //   287: astore 4
    //   289: ldc 183
    //   291: aload 4
    //   293: ldc 65
    //   295: iconst_0
    //   296: anewarray 187	java/lang/Object
    //   299: invokestatic 397	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   302: goto -28 -> 274
    //   305: iconst_1
    //   306: ireturn
    //   307: astore 5
    //   309: aload_3
    //   310: astore 4
    //   312: aload 5
    //   314: astore_3
    //   315: goto -51 -> 264
    //   318: astore 5
    //   320: aload_3
    //   321: astore 4
    //   323: aload 5
    //   325: astore_3
    //   326: goto -62 -> 264
    //   329: astore 4
    //   331: goto -147 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	this	b
    //   0	334	1	paramu	u
    //   27	99	2	bool	boolean
    //   14	217	3	localInputStream	InputStream
    //   247	4	3	localIOException1	java.io.IOException
    //   263	47	3	localObject1	Object
    //   314	12	3	localObject2	Object
    //   1	1	4	localObject3	Object
    //   180	90	4	localException1	Exception
    //   287	5	4	localIOException2	java.io.IOException
    //   310	12	4	localObject4	Object
    //   329	1	4	localException2	Exception
    //   307	6	5	localObject5	Object
    //   318	6	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   3	15	180	java/lang/Exception
    //   32	54	180	java/lang/Exception
    //   58	63	180	java/lang/Exception
    //   76	125	180	java/lang/Exception
    //   129	139	180	java/lang/Exception
    //   230	234	247	java/io/IOException
    //   3	15	263	finally
    //   32	54	263	finally
    //   58	63	263	finally
    //   76	125	263	finally
    //   129	139	263	finally
    //   269	274	287	java/io/IOException
    //   15	32	307	finally
    //   184	226	318	finally
    //   15	32	329	java/lang/Exception
  }
  
  private static boolean d(u paramu)
  {
    try
    {
      paramu = (List)paramu.getHeaderFields().get("cache-control");
      if ((paramu != null) && (paramu.size() != 0))
      {
        if ((bk.bl(paramu.toString())) || (!paramu.toString().contains("no-cache"))) {
          break label94;
        }
        boolean bool = paramu.toString().contains("no-cache");
        return !bool;
      }
    }
    catch (Exception paramu)
    {
      y.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", paramu, "", new Object[0]);
      return false;
    }
    return true;
    label94:
    return true;
  }
  
  private void iV(boolean paramBoolean)
  {
    int j;
    label113:
    long l1;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    String str;
    if ((this.ouO != null) && (this.ouO.ouI)) {
      if (!paramBoolean)
      {
        h.nFQ.a(22L, 74L, 1L, true);
        h.nFQ.a(22L, 73L, 1L, true);
        if ((this.ouO != null) && (this.ouO.ouH) && (!paramBoolean) && (!i.b(this.ouN))) {
          h.nFQ.a(150L, 66L, 1L, true);
        }
        this.ove = this.ovi;
        if (!aq.isWifi(ae.getContext())) {
          break label788;
        }
        j = 1;
        int k = aq.getStrength(ae.getContext());
        i = this.eNz;
        l1 = this.dnsCostTime;
        long l2 = this.ouV;
        long l3 = this.ouW;
        long l4 = this.ouU;
        localObject1 = this.ouP;
        localObject2 = this.ouR;
        localObject3 = this.ouQ;
        if (this.ouO != null) {
          break label793;
        }
        str = "";
        label179:
        y.v("MicroMsg.SnsCdnDownloadBase", "report dns:%d wifi:%d signal:%d [%d,%d,%d]%d serverIp:[%s,%s] xclientip:%s url[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), localObject1, localObject2, localObject3, str });
        int m = aq.getNetType(ae.getContext());
        i = 0;
        if (this.ouO != null)
        {
          if (this.ouO.ouJ != 4) {
            break label805;
          }
          i = 1;
        }
        label301:
        y.i("MicroMsg.SnsCdnDownloadBase", "retCode :%d totalSize: %d net: %d downloadType %d xErrorNo %d", new Object[] { Integer.valueOf(this.retCode), Integer.valueOf(this.ove), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.ouS) });
        localObject1 = h.nFQ;
        if (this.ouO != null) {
          break label810;
        }
        str = "";
        label374:
        l2 = Od(this.ouR);
        if (!paramBoolean) {
          break label822;
        }
        l1 = this.ouU;
        label393:
        ((h)localObject1).f(10736, new Object[] { str, Long.valueOf(l2), Long.valueOf(l1), "", Integer.valueOf(j), Long.valueOf(this.dnsCostTime), Long.valueOf(this.ouV), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(this.ouW), Long.valueOf(Od(this.ouQ)), Long.valueOf(Od(this.ouP)), Integer.valueOf(this.eNz), Integer.valueOf(k), Integer.valueOf(this.retCode), Integer.valueOf(this.ove), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.ouS) });
        boolean bool = aq.isConnected(ae.getContext());
        y.d("MicroMsg.SnsCdnDownloadBase", "isConntected  " + bool + " urlIp: " + this.ouY);
        if ((!paramBoolean) && (!bk.bl(this.ouY)) && (bool)) {
          com.tencent.mm.network.b.reportFailIp(this.ouY);
        }
        y.i("MicroMsg.SnsCdnDownloadBase", "ready to report logbuffer(13346) packageRecordList:%s", new Object[] { this.ouZ.value });
        j = bEt();
        localObject1 = "";
      }
    }
    switch (j)
    {
    default: 
    case 1: 
      label788:
      label793:
      label805:
      label810:
      label822:
      label833:
      do
      {
        return;
        h.nFQ.a(22L, 75L, this.ouU, true);
        break;
        if (!paramBoolean) {
          h.nFQ.a(22L, 52L, 1L, true);
        }
        for (;;)
        {
          h.nFQ.a(22L, 51L, 1L, true);
          break;
          h.nFQ.a(22L, 53L, this.ouU, true);
        }
        j = 0;
        break label113;
        str = this.ouO.url;
        break label179;
        i = 0;
        break label301;
        str = this.ouO.url;
        break label374;
        l1 = 0L;
        break label393;
        str = "100105";
        localObject2 = com.tencent.mm.model.c.c.IX().fJ(str);
        i = 0;
        if (((com.tencent.mm.storage.c)localObject2).isValid())
        {
          i = bk.getInt((String)((com.tencent.mm.storage.c)localObject2).ctr().get("needUploadData"), 1);
          localObject1 = ((com.tencent.mm.storage.c)localObject2).field_expId;
        }
      } while (i == 0);
      localObject2 = new com.tencent.mm.modelsns.d();
      ((com.tencent.mm.modelsns.d)localObject2).j("20ImgSize", this.ovi + ",");
      localObject3 = new StringBuilder();
      if (!aq.isWifi(ae.getContext())) {
        break;
      }
    }
    for (int i = 1;; i = 0)
    {
      ((com.tencent.mm.modelsns.d)localObject2).j("21NetType", i + ",");
      ((com.tencent.mm.modelsns.d)localObject2).j("22DelayTime", this.ouU - this.ouV + ",");
      ((com.tencent.mm.modelsns.d)localObject2).j("23RetCode", this.retCode + ",");
      ((com.tencent.mm.modelsns.d)localObject2).j("24DnsCostTime", this.dnsCostTime + ",");
      ((com.tencent.mm.modelsns.d)localObject2).j("25ConnectCostTime", this.ouV + ",");
      ((com.tencent.mm.modelsns.d)localObject2).j("26SendCostTime", ",");
      ((com.tencent.mm.modelsns.d)localObject2).j("27WaitResponseCostTime", this.ovc + ",");
      ((com.tencent.mm.modelsns.d)localObject2).j("28ReceiveCostTime", this.ouW + ",");
      ((com.tencent.mm.modelsns.d)localObject2).j("29ClientAddrIP", this.ouQ + ",");
      ((com.tencent.mm.modelsns.d)localObject2).j("30ServerAddrIP", this.ouR + ",");
      ((com.tencent.mm.modelsns.d)localObject2).j("31dnstype", this.eNz + ",");
      ((com.tencent.mm.modelsns.d)localObject2).j("32signal", aq.getStrength(ae.getContext()) + ",");
      ((com.tencent.mm.modelsns.d)localObject2).j("33host", this.host + ",");
      ((com.tencent.mm.modelsns.d)localObject2).j("34MediaType", j + ",");
      ((com.tencent.mm.modelsns.d)localObject2).j("35X_Errno", this.ouS + ",");
      ((com.tencent.mm.modelsns.d)localObject2).j("36MaxPackageSize", this.ova + ",");
      ((com.tencent.mm.modelsns.d)localObject2).j("37MaxPackageTimeStamp", this.ovb + ",");
      ((com.tencent.mm.modelsns.d)localObject2).j("38PackageRecordList", this.ouZ.value + ",");
      ((com.tencent.mm.modelsns.d)localObject2).j("39ExpLayerId", str + ",");
      ((com.tencent.mm.modelsns.d)localObject2).j("40ExpId", (String)localObject1 + ",");
      ((com.tencent.mm.modelsns.d)localObject2).j("41FeedId", ",");
      y.i("MicroMsg.SnsCdnDownloadBase", "report logbuffer(13480 TLMediaFielDownloadRecord): " + ((com.tencent.mm.modelsns.d)localObject2).uJ());
      h.nFQ.f(13480, new Object[] { localObject2 });
      if (this.retCode == 200) {
        break;
      }
      h.nFQ.f(14071, new Object[] { localObject2 });
      return;
      str = "100106";
      break label833;
      str = "100100";
      break label833;
    }
  }
  
  public abstract boolean A(InputStream paramInputStream);
  
  public String Oc(String paramString)
  {
    return paramString;
  }
  
  public final boolean a(az paramaz, String paramString1, long paramLong, String paramString2)
  {
    if (paramString1 == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramString1 = new URL(paramString1);
        if ((paramaz != null) && (paramString2 != null) && (paramString2.indexOf(paramString1.getHost()) != -1) && (paramaz.time != 0))
        {
          long l = bk.cn(paramaz.time);
          if (l > paramLong) {
            return true;
          }
        }
      }
      catch (Exception paramaz)
      {
        y.e("MicroMsg.SnsCdnDownloadBase", "error for check dcip %s", new Object[] { paramaz.getMessage() });
      }
    }
    return false;
  }
  
  public u b(u paramu)
  {
    return paramu;
  }
  
  public boolean bEr()
  {
    return true;
  }
  
  public abstract boolean bEs();
  
  protected abstract int bEt();
  
  public final Integer bEu()
  {
    com.tencent.mm.kernel.g.DQ();
    if ((!com.tencent.mm.kernel.g.DP().isSDCardAvailable()) || (this.ouO == null))
    {
      iV(false);
      return Integer.valueOf(2);
    }
    if (bEr())
    {
      localObject1 = this.ouO.opV + this.ouO.bEq();
      y.i("MicroMsg.SnsCdnDownloadBase", "[tomys] delete img: %s", new Object[] { localObject1 });
      com.tencent.mm.vfs.e.deleteFile((String)localObject1);
    }
    long l3 = System.currentTimeMillis();
    this.ouX = System.currentTimeMillis();
    y.d("MicroMsg.SnsCdnDownloadBase", "to downloadBitmap " + this.ouO.bUi + " " + this.ouO.ouH + " type " + this.ouO.ouJ);
    com.tencent.mm.vfs.e.nb(this.ouO.getPath());
    Object localObject3 = this.ouO.ouK;
    Object localObject1 = "";
    Object localObject2;
    if (localObject3 == null)
    {
      localObject1 = "";
      localObject2 = az.uBK;
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (!bk.bl((String)localObject1)) {
        localObject3 = "&scene=" + (String)localObject1;
      }
      String str2 = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.spa), o.getString(af.bDm()), Integer.valueOf(aq.getNetTypeForStat(ae.getContext())), Integer.valueOf(aq.getStrength(ae.getContext())), localObject3 });
      this.ouO.url = Oc(this.ouO.url);
      this.dnsCostTime = bk.UY();
      label333:
      label348:
      boolean bool;
      if (this.ouO.ouI)
      {
        localObject1 = "SnsSightDomainList";
        if (!this.ouO.ouI) {
          break label941;
        }
        localObject3 = "SnsSightMainStandbyIpSwitchTime";
        localObject1 = com.tencent.mm.m.g.AA().getValue((String)localObject1);
        long l2 = com.tencent.mm.m.g.AA().getInt((String)localObject3, 0);
        y.i("MicroMsg.SnsCdnDownloadBase", "pack.isAlbum %s pack.isthumb %s hostvalue %s dcipTime %s", new Object[] { Boolean.valueOf(this.ouO.ouI), Boolean.valueOf(this.ouO.ouH), localObject1, Long.valueOf(l2) });
        long l1 = l2;
        if (l2 <= 0L) {
          l1 = 259200L;
        }
        bool = a((az)localObject2, this.ouO.url, l1, (String)localObject1);
        localObject3 = new b.b(this.ouO.url, bool);
        this.dnsCostTime = bk.co(this.dnsCostTime);
      }
      try
      {
        if (bk.bl(((b.b)localObject3).ip)) {}
        for (localObject1 = InetAddress.getByName(((b.b)localObject3).host).getHostAddress();; localObject1 = ((b.b)localObject3).ip)
        {
          y.i("MicroMsg.SnsCdnDownloadBase", "checkAndGetHttpConn[%s] [%s] [id:%s] host ip:%d[%s] [%s] download type[%d] isDcIp[%s] fromScene[%s]", new Object[] { str2, this.ouO.url, this.ouO.bUi, Integer.valueOf(((b.b)localObject3).eNz), localObject1, this.ouO.url, Integer.valueOf(this.ouO.ouJ), Boolean.valueOf(bool), ((az)localObject2).toString() });
          this.ouT = 1;
          localObject1 = a((b.b)localObject3, str2);
          localObject2 = ((b.b)localObject3).ip;
          if (localObject1 == null) {
            break label969;
          }
          bool = true;
          y.i("MicroMsg.SnsCdnDownloadBase", "[sns ip strategy]connect ip:%s, result:%b, canRetry(X-RtFlag):%d, isDC(cold ip):%b, url:%s", new Object[] { localObject2, Boolean.valueOf(bool), Integer.valueOf(this.ouT), Boolean.valueOf(((b.b)localObject3).eNC), ((b.b)localObject3).eNB });
          int i = 2;
          if (localObject1 != null) {
            i = c((u)localObject1);
          }
          y.i("MicroMsg.SnsCdnDownloadBase", "DOWN FIN time:%d down:%d mediaId:%s url[%s], size %d", new Object[] { Long.valueOf(bk.co(l3)), Long.valueOf(this.ouU), this.ouO.bUi, this.ouO.url, Integer.valueOf(this.ovi) });
          return Integer.valueOf(i);
          if (((az)localObject3).equals(az.uBD))
          {
            localObject1 = "album_friend";
            localObject2 = localObject3;
            break;
          }
          if (((az)localObject3).equals(az.uBE))
          {
            localObject1 = "album_self";
            localObject2 = localObject3;
            break;
          }
          if (((az)localObject3).equals(az.uBF))
          {
            localObject1 = "album_stranger";
            localObject2 = localObject3;
            break;
          }
          if (((az)localObject3).equals(az.uBG))
          {
            localObject1 = "profile_friend";
            localObject2 = localObject3;
            break;
          }
          if (((az)localObject3).equals(az.uBH))
          {
            localObject1 = "profile_stranger";
            localObject2 = localObject3;
            break;
          }
          if (((az)localObject3).equals(az.uBI))
          {
            localObject1 = "comment";
            localObject2 = localObject3;
            break;
          }
          localObject2 = localObject3;
          if (!((az)localObject3).equals(az.uBC)) {
            break;
          }
          localObject1 = "timeline";
          localObject2 = localObject3;
          break;
          localObject1 = "SnsAlbumDomainList";
          break label333;
          label941:
          localObject3 = "SnsAlbumMainStandbyIpSwitchTime";
          break label348;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str1 = "-";
          continue;
          label969:
          bool = false;
        }
      }
    }
  }
  
  public final void bEv()
  {
    if (af.bDo()) {
      return;
    }
    System.currentTimeMillis();
    Object localObject1;
    Object localObject2;
    if (this.ouO.omO.omU == 4)
    {
      y.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur thumb");
      localObject1 = i.e(this.bZK);
      localObject2 = i.g(this.bZK);
      this.ouN = com.tencent.mm.plugin.sns.lucky.a.a.eF(this.ouO.getPath() + (String)localObject1, this.ouO.getPath() + (String)localObject2);
      af.bDC().a(this.ouO.bUi, this.ouN, this.ouO.omO.omU);
      label132:
      localObject1 = null;
      if (this.ouO.omO.omU != 0) {
        break label593;
      }
      localObject1 = "0-" + this.ouO.omO.lJQ;
    }
    for (;;)
    {
      af.bDC().Ns((String)localObject1);
      return;
      if (this.ouO.omO.omU == 5)
      {
        y.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur grid");
        localObject1 = i.e(this.bZK);
        localObject2 = i.h(this.bZK);
        this.ouN = com.tencent.mm.plugin.sns.lucky.a.a.eF(this.ouO.getPath() + (String)localObject1, this.ouO.getPath() + (String)localObject2);
        af.bDC().a(this.ouO.bUi, this.ouN, this.ouO.omO.omU);
        break label132;
      }
      if (this.ouO.omO.list.size() <= 1)
      {
        af.bDC().a(this.ouO.bUi, this.ouN, this.ouO.omO.omU);
        break label132;
      }
      af.bDC().a(this.ouO.bUi, this.ouN, 0);
      localObject1 = new LinkedList();
      int i = 0;
      for (;;)
      {
        if ((i >= this.ouO.omO.list.size()) || (i >= 4)) {
          break label501;
        }
        localObject2 = (awd)this.ouO.omO.list.get(i);
        n localn = af.bDC().Nt(((awd)localObject2).lsK);
        if (!i.b(localn)) {
          break;
        }
        ((List)localObject1).add(localn);
        y.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap from " + localn + " " + ((awd)localObject2).lsK);
        i += 1;
      }
      label501:
      this.ouN = n.o(i.j((List)localObject1, af.bDN()));
      y.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap " + this.ouO.omO.lJQ + " " + this.ouN);
      af.bDC().a(this.ouO.omO.lJQ, this.ouN, this.ouO.omO.omU);
      break label132;
      label593:
      if (this.ouO.omO.omU == 1) {
        localObject1 = "1-" + this.ouO.omO.lJQ;
      } else if (this.ouO.omO.omU == 4) {
        localObject1 = "4-" + this.ouO.omO.lJQ;
      } else if (this.ouO.omO.omU == 5) {
        localObject1 = "5-" + this.ouO.omO.lJQ;
      }
    }
  }
  
  public final ah byB()
  {
    return af.bDq();
  }
  
  public final void onPostExecute(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    if (this.ouO == null) {
      return;
    }
    y.i("MicroMsg.SnsCdnDownloadBase", "download done result: %d, url:%s, mediaID:%s, totalSize: %d, runningTasksSize: %d", new Object[] { paramInteger, this.ouO.url, this.ouO.bUi, Integer.valueOf(this.ove), Integer.valueOf(ovg.size()) });
    ovg.remove(this.ouO.opZ);
    if ((this.ouO.ouH) && (paramInteger.intValue() != 2))
    {
      av.NO(this.ouO.bUi);
      bEv();
    }
    for (;;)
    {
      this.ouM.a(paramInteger.intValue(), this.bZK, this.ouO.ouJ, this.ouO.ouH, this.ouO.opZ, this.ove);
      return;
      if ((!this.ouO.ouH) && (this.ouO.ouJ == 4))
      {
        String str = this.ouO.getPath() + i.j(this.bZK);
        af.bDC().eH(this.ouO.bUi, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.b
 * JD-Core Version:    0.7.0.1
 */