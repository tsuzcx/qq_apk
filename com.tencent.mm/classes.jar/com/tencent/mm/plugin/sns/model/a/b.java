package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.k.i;
import com.tencent.mm.memory.m;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.network.d.b;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.br;
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
  private static HashSet<String> QAj = new HashSet();
  protected long QAa = -1L;
  protected long QAb = -1L;
  protected String QAc = "";
  protected PString QAd = new PString();
  protected int QAe;
  protected long QAf;
  protected long QAg;
  protected long QAh;
  protected int QAi = 0;
  private Map<String, List<String>> QAk;
  int QAl = 0;
  protected c.a QzQ;
  protected m QzR = null;
  protected a QzS = null;
  private String QzT = "";
  private String QzU = "";
  private String QzV = "";
  private int QzW = 0;
  protected int QzX = 0;
  private long QzY = -1L;
  protected long QzZ = -1L;
  private int aes = 0;
  private long dnsCostTime = -1L;
  private String host = "";
  protected dmz ibT = null;
  private int pnI = -1;
  private int retCode = -1;
  
  public b(c.a parama, a parama1)
  {
    super(parama, parama1);
    this.QzQ = parama;
    this.QzS = parama1;
    if (parama1 == null) {
      return;
    }
    this.ibT = parama1.Qsr;
    QAj.add(parama1.Qsq);
    parama1.init();
  }
  
  private com.tencent.mm.network.y a(d.b paramb, String paramString)
  {
    try
    {
      this.QzV = paramb.ip;
      this.pnI = paramb.pnI;
      this.QzZ = Util.nowMilliSecond();
      paramb = com.tencent.mm.network.d.a(this.QzS.url, paramb);
      paramb.Rx("GET");
      paramb.setRequestProperty("referer", paramString);
      if (Util.getInt(i.aRC().getValue("SnsDownloadHttpKeep"), 0) > 0)
      {
        Log.i("MicroMsg.SnsCdnDownloadBase", "header Connection close ");
        paramb.setRequestProperty("Connection", "close");
      }
      paramb.xx(25000);
      paramb.xy(25000);
      paramb = a(paramb);
      this.QAk = paramb.bRf();
      paramString = (List)this.QAk.get("X-ClientIp");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.QzU = ((String)paramString.get(0));
      }
      paramString = (List)this.QAk.get("X-ServerIp");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.QzT = ((String)paramString.get(0));
      }
      paramString = (List)this.QAk.get("X-ErrNo");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.QzW = Util.safeParseInt((String)paramString.get(0));
      }
      paramString = (List)this.QAk.get("X-RtFlag");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.QzX = Util.safeParseInt((String)paramString.get(0));
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
          aX(paramb.bRf());
          if (this.QzS.QzM)
          {
            if ((this.retCode >= 400) && (this.retCode < 500))
            {
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(22L, 78L, 1L, true);
              if (this.QzS.QzL) {
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(150L, 14L, 1L, true);
              }
              Log.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! mediaId : " + this.QzS.mediaId + " " + this.QzS.url + " " + this.retCode);
              fb(false);
              return null;
            }
            if ((this.retCode < 500) || (this.retCode >= 600)) {
              continue;
            }
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(22L, 79L, 1L, true);
            continue;
          }
        }
        catch (SocketTimeoutException paramb)
        {
          this.retCode = 1;
          fb(false);
          paramb = paramb.getMessage();
          if (!this.QzS.QzM) {
            break label780;
          }
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(22L, 77L, 1L, true);
          if (this.QzS.QzL) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(150L, 14L, 1L, true);
          }
          Log.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! socket timeout mediaId : " + this.QzS.mediaId + " " + this.QzS.url + " msg:" + paramb);
          return null;
          if ((this.retCode >= 400) && (this.retCode < 500))
          {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(22L, 56L, 1L, true);
            continue;
          }
        }
        catch (Exception paramb)
        {
          fb(false);
          paramb = paramb.getMessage();
          if (this.QzS.QzL) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(150L, 14L, 1L, true);
          }
          Log.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! mediaId : " + this.QzS.mediaId + " " + this.QzS.url + " msg:" + paramb);
          return null;
        }
        if ((this.retCode >= 500) && (this.retCode < 600))
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(22L, 57L, 1L, true);
          continue;
          label780:
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(22L, 55L, 1L, true);
        }
      }
      aX(paramb.bRf());
    }
    catch (Exception paramb)
    {
      Log.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", paramb, "connect fail : " + paramb.getMessage(), new Object[0]);
      this.retCode = 2;
      fb(false);
      return null;
    }
    if (!c(paramb))
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(22L, 62L, 1L, true);
      Log.e("MicroMsg.SnsCdnDownloadBase", "checkHttpConnection failed! nocache mediaId : " + this.QzS.mediaId);
      fb(false);
      return null;
    }
    this.QzZ = Util.milliSecondsToNow(this.QzZ);
    paramString = (List)this.QAk.get("Content-Length");
    if ((paramString != null) && (paramString.size() > 0)) {
      this.QAi = Util.safeParseInt((String)paramString.get(0));
    }
    Log.i("MicroMsg.SnsCdnDownloadBase", "ip: url %s client ip %s server ip %s svrlen %d %d", new Object[] { this.QzS.url, this.QzU, this.QzT, Integer.valueOf(this.QAi), Integer.valueOf(this.QzW) });
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
  
  private static void aX(Map<String, List<String>> paramMap)
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
      Log.i("MicroMsg.SnsCdnDownloadBase", "header respone %s", new Object[] { localStringBuffer.toString() });
      return;
    }
    catch (Exception paramMap) {}
  }
  
  private static long aYZ(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return 0L;
    }
    try
    {
      paramString = paramString.split("\\.");
      long l1 = Util.getLong(paramString[0], 0L);
      long l2 = Util.getLong(paramString[1], 0L);
      long l3 = Util.getLong(paramString[2], 0L);
      long l4 = Util.getLong(paramString[3], 0L);
      return l4 + (16777216L * l1 + 65536L * l2 + 256L * l3);
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  /* Error */
  private int b(com.tencent.mm.network.y paramy)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokestatic 142	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   7: putfield 447	com/tencent/mm/plugin/sns/model/a/b:QAh	J
    //   10: aload_1
    //   11: invokevirtual 451	com/tencent/mm/network/y:getInputStream	()Ljava/io/InputStream;
    //   14: astore_3
    //   15: aload_0
    //   16: invokestatic 142	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   19: putfield 87	com/tencent/mm/plugin/sns/model/a/b:QAa	J
    //   22: aload_0
    //   23: aload_3
    //   24: invokevirtual 455	com/tencent/mm/plugin/sns/model/a/b:V	(Ljava/io/InputStream;)Z
    //   27: istore_2
    //   28: aload_3
    //   29: invokevirtual 459	java/io/InputStream:close	()V
    //   32: ldc 184
    //   34: ldc_w 461
    //   37: iload_2
    //   38: invokestatic 464	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   41: invokevirtual 467	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   44: invokestatic 191	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: iload_2
    //   48: ifne +18 -> 66
    //   51: aload_0
    //   52: iconst_0
    //   53: invokespecial 309	com/tencent/mm/plugin/sns/model/a/b:fb	(Z)V
    //   56: aload_1
    //   57: ifnull +7 -> 64
    //   60: aload_1
    //   61: invokevirtual 470	com/tencent/mm/network/y:disconnect	()V
    //   64: iconst_2
    //   65: ireturn
    //   66: aload_0
    //   67: aload_0
    //   68: getfield 87	com/tencent/mm/plugin/sns/model/a/b:QAa	J
    //   71: invokestatic 347	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   74: putfield 87	com/tencent/mm/plugin/sns/model/a/b:QAa	J
    //   77: aload_0
    //   78: aload_0
    //   79: getfield 89	com/tencent/mm/plugin/sns/model/a/b:QAb	J
    //   82: invokestatic 347	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   85: putfield 79	com/tencent/mm/plugin/sns/model/a/b:QzY	J
    //   88: aload_0
    //   89: invokevirtual 473	com/tencent/mm/plugin/sns/model/a/b:hhI	()Z
    //   92: istore_2
    //   93: ldc 184
    //   95: ldc_w 475
    //   98: iload_2
    //   99: invokestatic 464	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   102: invokevirtual 467	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   105: invokestatic 191	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: iload_2
    //   109: ifne +23 -> 132
    //   112: aload_0
    //   113: iconst_3
    //   114: putfield 98	com/tencent/mm/plugin/sns/model/a/b:retCode	I
    //   117: aload_0
    //   118: iconst_0
    //   119: invokespecial 309	com/tencent/mm/plugin/sns/model/a/b:fb	(Z)V
    //   122: aload_1
    //   123: ifnull -59 -> 64
    //   126: aload_1
    //   127: invokevirtual 470	com/tencent/mm/network/y:disconnect	()V
    //   130: iconst_2
    //   131: ireturn
    //   132: aload_1
    //   133: ifnull +7 -> 140
    //   136: aload_1
    //   137: invokevirtual 470	com/tencent/mm/network/y:disconnect	()V
    //   140: aload_0
    //   141: iconst_1
    //   142: invokespecial 309	com/tencent/mm/plugin/sns/model/a/b:fb	(Z)V
    //   145: aload_0
    //   146: getfield 61	com/tencent/mm/plugin/sns/model/a/b:QzS	Lcom/tencent/mm/plugin/sns/model/a/a;
    //   149: getfield 277	com/tencent/mm/plugin/sns/model/a/a:QzL	Z
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
    //   190: invokestatic 335	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   193: aload_0
    //   194: iconst_4
    //   195: putfield 98	com/tencent/mm/plugin/sns/model/a/b:retCode	I
    //   198: aload_0
    //   199: iconst_0
    //   200: invokespecial 309	com/tencent/mm/plugin/sns/model/a/b:fb	(Z)V
    //   203: aload_3
    //   204: ifnull +7 -> 211
    //   207: aload_3
    //   208: invokevirtual 459	java/io/InputStream:close	()V
    //   211: aload_1
    //   212: ifnull -148 -> 64
    //   215: aload_1
    //   216: invokevirtual 470	com/tencent/mm/network/y:disconnect	()V
    //   219: iconst_2
    //   220: ireturn
    //   221: astore_3
    //   222: ldc 184
    //   224: aload_3
    //   225: ldc 65
    //   227: iconst_0
    //   228: anewarray 331	java/lang/Object
    //   231: invokestatic 335	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: goto -23 -> 211
    //   237: astore_3
    //   238: aload 4
    //   240: ifnull +8 -> 248
    //   243: aload 4
    //   245: invokevirtual 459	java/io/InputStream:close	()V
    //   248: aload_1
    //   249: ifnull +7 -> 256
    //   252: aload_1
    //   253: invokevirtual 470	com/tencent/mm/network/y:disconnect	()V
    //   256: aload_3
    //   257: athrow
    //   258: astore 4
    //   260: ldc 184
    //   262: aload 4
    //   264: ldc 65
    //   266: iconst_0
    //   267: anewarray 331	java/lang/Object
    //   270: invokestatic 335	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   0	305	1	paramy	com.tencent.mm.network.y
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
  
  private static boolean c(com.tencent.mm.network.y paramy)
  {
    try
    {
      paramy = (List)paramy.bRf().get("cache-control");
      if ((paramy != null) && (paramy.size() != 0))
      {
        if ((Util.isNullOrNil(paramy.toString())) || (!paramy.toString().contains("no-cache"))) {
          break label94;
        }
        boolean bool = paramy.toString().contains("no-cache");
        return !bool;
      }
    }
    catch (Exception paramy)
    {
      Log.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", paramy, "", new Object[0]);
      return false;
    }
    return true;
    label94:
    return true;
  }
  
  private void fb(boolean paramBoolean)
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
    if ((this.QzS != null) && (this.QzS.QzM)) {
      if (!paramBoolean)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(22L, 74L, 1L, true);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(22L, 73L, 1L, true);
        if ((this.QzS != null) && (this.QzS.QzL) && (!paramBoolean) && (!t.b(this.QzR))) {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(150L, 66L, 1L, true);
        }
        this.aes = this.QAl;
        if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
          break label735;
        }
        j = 1;
        k = ConnectivityCompat.Companion.getCompatMixStrength();
        i = this.pnI;
        l1 = this.dnsCostTime;
        l2 = this.QzZ;
        long l3 = this.QAa;
        long l4 = this.QzY;
        localObject = this.QzT;
        String str2 = this.QzV;
        String str3 = this.QzU;
        if (this.QzS != null) {
          break label740;
        }
        str1 = "";
        Log.v("MicroMsg.SnsCdnDownloadBase", "report dns:%d wifi:%d signal:%d [%d,%d,%d]%d serverIp:[%s,%s] xclientip:%s url[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), localObject, str2, str3, str1 });
        m = NetStatusUtil.getNetType(MMApplicationContext.getContext());
        i = 0;
        if (this.QzS != null)
        {
          if (this.QzS.QzN != 4) {
            break label752;
          }
          i = 1;
        }
        label301:
        Log.i("MicroMsg.SnsCdnDownloadBase", "retCode :%d totalSize: %d net: %d downloadType %d xErrorNo %d", new Object[] { Integer.valueOf(this.retCode), Integer.valueOf(this.aes), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.QzW) });
        localObject = com.tencent.mm.plugin.report.service.h.OAn;
        if (this.QzS != null) {
          break label757;
        }
        str1 = "";
        label374:
        l2 = aYZ(this.QzV);
        if (!paramBoolean) {
          break label769;
        }
      }
    }
    label769:
    for (long l1 = this.QzY;; l1 = 0L)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).b(10736, new Object[] { str1, Long.valueOf(l2), Long.valueOf(l1), "", Integer.valueOf(j), Long.valueOf(this.dnsCostTime), Long.valueOf(this.QzZ), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(this.QAa), Long.valueOf(aYZ(this.QzU)), Long.valueOf(aYZ(this.QzT)), Integer.valueOf(this.pnI), Integer.valueOf(k), Integer.valueOf(this.retCode), Integer.valueOf(this.aes), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.QzW) });
      boolean bool = NetStatusUtil.isConnected(MMApplicationContext.getContext());
      Log.d("MicroMsg.SnsCdnDownloadBase", "isConntected  " + bool + " urlIp: " + this.QAc);
      if ((!paramBoolean) && (!Util.isNullOrNil(this.QAc)) && (bool)) {
        com.tencent.mm.network.d.reportFailIp(this.QAc);
      }
      hhJ();
      return;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(22L, 75L, this.QzY, true);
      break;
      if (!paramBoolean) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(22L, 52L, 1L, true);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(22L, 51L, 1L, true);
        break;
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(22L, 53L, this.QzY, true);
      }
      label735:
      j = 0;
      break label113;
      label740:
      str1 = this.QzS.url;
      break label179;
      label752:
      i = 0;
      break label301;
      label757:
      str1 = this.QzS.url;
      break label374;
    }
  }
  
  private void hhJ()
  {
    Log.i("MicroMsg.SnsCdnDownloadBase", "ready to report logbuffer(13346) packageRecordList:%s", new Object[] { this.QAd.value });
    int j = getMediaType();
    n localn = new n();
    localn.s("20ImgSize", this.QAl + ",");
    StringBuilder localStringBuilder = new StringBuilder();
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {}
    for (int i = 1;; i = 0)
    {
      localn.s("21NetType", i + ",");
      localn.s("22DelayTime", this.QzY - this.QzZ + ",");
      localn.s("23RetCode", this.retCode + ",");
      localn.s("24DnsCostTime", this.dnsCostTime + ",");
      localn.s("25ConnectCostTime", this.QzZ + ",");
      localn.s("26SendCostTime", ",");
      localn.s("27WaitResponseCostTime", this.QAg + ",");
      localn.s("28ReceiveCostTime", this.QAa + ",");
      localn.s("29ClientAddrIP", this.QzU + ",");
      localn.s("30ServerAddrIP", this.QzV + ",");
      localn.s("31dnstype", this.pnI + ",");
      localn.s("32signal", ConnectivityCompat.Companion.getCompatMixStrength() + ",");
      localn.s("33host", this.host + ",");
      localn.s("34MediaType", j + ",");
      localn.s("35X_Errno", this.QzW + ",");
      localn.s("36MaxPackageSize", this.QAe + ",");
      localn.s("37MaxPackageTimeStamp", this.QAf + ",");
      localn.s("38PackageRecordList", this.QAd.value + ",");
      localn.s("39ExpLayerId", "0,");
      localn.s("40ExpId", "0,");
      localn.s("41FeedId", ",");
      Log.i("MicroMsg.SnsCdnDownloadBase", "report logbuffer(13480 TLMediaFielDownloadRecord): " + localn.aIF());
      com.tencent.mm.plugin.report.service.h.OAn.b(13480, new Object[] { localn });
      if (this.retCode != 200) {
        com.tencent.mm.plugin.report.service.h.OAn.b(14071, new Object[] { localn });
      }
      return;
    }
  }
  
  public abstract boolean V(InputStream paramInputStream);
  
  public com.tencent.mm.network.y a(com.tencent.mm.network.y paramy)
  {
    return paramy;
  }
  
  public final boolean a(br parambr, String paramString1, long paramLong, String paramString2)
  {
    if (paramString1 == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramString1 = new URL(paramString1);
        if ((parambr != null) && (paramString2 != null) && (paramString2.indexOf(paramString1.getHost()) != -1) && (parambr.time != 0))
        {
          long l = Util.secondsToNow(parambr.time);
          if (l > paramLong) {
            return true;
          }
        }
      }
      catch (Exception parambr)
      {
        Log.e("MicroMsg.SnsCdnDownloadBase", "error for check dcip %s", new Object[] { parambr.getMessage() });
      }
    }
    return false;
  }
  
  public String aYY(String paramString)
  {
    return paramString;
  }
  
  public final ExecutorService gDT()
  {
    return al.hgl();
  }
  
  protected abstract int getMediaType();
  
  public boolean hhH()
  {
    return true;
  }
  
  public abstract boolean hhI();
  
  public final Integer hhK()
  {
    com.tencent.mm.kernel.h.baF();
    if ((!com.tencent.mm.kernel.h.baE().isSDCardAvailable()) || (this.QzS == null))
    {
      fb(false);
      return Integer.valueOf(2);
    }
    if (hhH())
    {
      localObject1 = this.QzS.Qsm + this.QzS.hhG();
      Log.i("MicroMsg.SnsCdnDownloadBase", "[tomys] delete img: %s", new Object[] { localObject1 });
      com.tencent.mm.vfs.y.deleteFile((String)localObject1);
    }
    long l3 = System.currentTimeMillis();
    this.QAb = System.currentTimeMillis();
    Log.d("MicroMsg.SnsCdnDownloadBase", "to downloadBitmap " + this.QzS.mediaId + " " + this.QzS.QzL + " type " + this.QzS.QzN);
    com.tencent.mm.vfs.y.bDX(this.QzS.getPath());
    Object localObject3 = this.QzS.QzO;
    Object localObject1 = "";
    Object localObject2;
    if (localObject3 == null)
    {
      localObject1 = "";
      localObject2 = br.adkd;
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (!Util.isNullOrNil((String)localObject1)) {
        localObject3 = "&scene=".concat(String.valueOf(localObject1));
      }
      String str2 = String.format("https://" + WeChatHosts.domainString(b.j.host_weixin_qq_com) + "/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.Yxh), com.tencent.mm.b.p.getString(al.hgh()), Integer.valueOf(NetStatusUtil.getNetTypeForStat(MMApplicationContext.getContext())), Integer.valueOf(ConnectivityCompat.Companion.getCompatMixStrength()), localObject3 });
      this.QzS.url = aYY(this.QzS.url);
      this.dnsCostTime = Util.nowMilliSecond();
      label351:
      label366:
      boolean bool;
      if (this.QzS.QzM)
      {
        localObject1 = "SnsSightDomainList";
        if (!this.QzS.QzM) {
          break label959;
        }
        localObject3 = "SnsSightMainStandbyIpSwitchTime";
        localObject1 = i.aRC().getValue((String)localObject1);
        long l2 = i.aRC().getInt((String)localObject3, 0);
        Log.i("MicroMsg.SnsCdnDownloadBase", "pack.isAlbum %s pack.isthumb %s hostvalue %s dcipTime %s", new Object[] { Boolean.valueOf(this.QzS.QzM), Boolean.valueOf(this.QzS.QzL), localObject1, Long.valueOf(l2) });
        long l1 = l2;
        if (l2 <= 0L) {
          l1 = 259200L;
        }
        bool = a((br)localObject2, this.QzS.url, l1, (String)localObject1);
        localObject3 = new d.b(this.QzS.url, bool);
        this.dnsCostTime = Util.milliSecondsToNow(this.dnsCostTime);
      }
      try
      {
        if (Util.isNullOrNil(((d.b)localObject3).ip)) {}
        for (localObject1 = InetAddress.getByName(((d.b)localObject3).host).getHostAddress();; localObject1 = ((d.b)localObject3).ip)
        {
          Log.i("MicroMsg.SnsCdnDownloadBase", "checkAndGetHttpConn[%s] [%s] [id:%s] host ip:%d[%s] [%s] download type[%d] isDcIp[%s] fromScene[%s]", new Object[] { str2, this.QzS.url, this.QzS.mediaId, Integer.valueOf(((d.b)localObject3).pnI), localObject1, this.QzS.url, Integer.valueOf(this.QzS.QzN), Boolean.valueOf(bool), ((br)localObject2).toString() });
          this.QzX = 1;
          localObject1 = a((d.b)localObject3, str2);
          localObject2 = ((d.b)localObject3).ip;
          if (localObject1 == null) {
            break label987;
          }
          bool = true;
          Log.i("MicroMsg.SnsCdnDownloadBase", "[sns ip strategy]connect ip:%s, result:%b, canRetry(X-RtFlag):%d, isDC(cold ip):%b, url:%s", new Object[] { localObject2, Boolean.valueOf(bool), Integer.valueOf(this.QzX), Boolean.valueOf(((d.b)localObject3).pnL), ((d.b)localObject3).pnK });
          int i = 2;
          if (localObject1 != null) {
            i = b((com.tencent.mm.network.y)localObject1);
          }
          Log.i("MicroMsg.SnsCdnDownloadBase", "DOWN FIN time:%d down:%d mediaId:%s url[%s], size %d", new Object[] { Long.valueOf(Util.milliSecondsToNow(l3)), Long.valueOf(this.QzY), this.QzS.mediaId, this.QzS.url, Integer.valueOf(this.QAl) });
          return Integer.valueOf(i);
          if (((br)localObject3).equals(br.adjW))
          {
            localObject1 = "album_friend";
            localObject2 = localObject3;
            break;
          }
          if (((br)localObject3).equals(br.adjX))
          {
            localObject1 = "album_self";
            localObject2 = localObject3;
            break;
          }
          if (((br)localObject3).equals(br.adjY))
          {
            localObject1 = "album_stranger";
            localObject2 = localObject3;
            break;
          }
          if (((br)localObject3).equals(br.adjZ))
          {
            localObject1 = "profile_friend";
            localObject2 = localObject3;
            break;
          }
          if (((br)localObject3).equals(br.adka))
          {
            localObject1 = "profile_stranger";
            localObject2 = localObject3;
            break;
          }
          if (((br)localObject3).equals(br.adkb))
          {
            localObject1 = "comment";
            localObject2 = localObject3;
            break;
          }
          localObject2 = localObject3;
          if (!((br)localObject3).equals(br.adjV)) {
            break;
          }
          localObject1 = "timeline";
          localObject2 = localObject3;
          break;
          localObject1 = "SnsAlbumDomainList";
          break label351;
          label959:
          localObject3 = "SnsAlbumMainStandbyIpSwitchTime";
          break label366;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str1 = "-";
          continue;
          label987:
          bool = false;
        }
      }
    }
  }
  
  public final void hhL()
  {
    if (al.isInValid()) {
      return;
    }
    System.currentTimeMillis();
    Object localObject1;
    Object localObject2;
    if (this.QzS.QmT.QnY == 4)
    {
      Log.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur thumb");
      localObject1 = t.d(this.ibT);
      localObject2 = t.f(this.ibT);
      this.QzR = com.tencent.mm.plugin.sns.lucky.a.a.mb(this.QzS.getPath() + (String)localObject1, this.QzS.getPath() + (String)localObject2);
      al.hgy().a(this.QzS.mediaId, this.QzR, this.QzS.QmT.QnY);
      label132:
      localObject1 = null;
      if (this.QzS.QmT.QnY != 0) {
        break label593;
      }
      localObject1 = "0-" + this.QzS.QmT.hOG;
    }
    for (;;)
    {
      al.hgy().aYg((String)localObject1);
      return;
      if (this.QzS.QmT.QnY == 5)
      {
        Log.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur grid");
        localObject1 = t.d(this.ibT);
        localObject2 = t.g(this.ibT);
        this.QzR = com.tencent.mm.plugin.sns.lucky.a.a.mb(this.QzS.getPath() + (String)localObject1, this.QzS.getPath() + (String)localObject2);
        al.hgy().a(this.QzS.mediaId, this.QzR, this.QzS.QmT.QnY);
        break label132;
      }
      if (this.QzS.QmT.list.size() <= 1)
      {
        al.hgy().a(this.QzS.mediaId, this.QzR, this.QzS.QmT.QnY);
        break label132;
      }
      al.hgy().a(this.QzS.mediaId, this.QzR, 0);
      localObject1 = new LinkedList();
      int i = 0;
      for (;;)
      {
        if ((i >= this.QzS.QmT.list.size()) || (i >= 4)) {
          break label501;
        }
        localObject2 = (dmz)this.QzS.QmT.list.get(i);
        m localm = al.hgy().aYh(((dmz)localObject2).Id);
        if (!t.b(localm)) {
          break;
        }
        ((List)localObject1).add(localm);
        Log.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap from " + localm + " " + ((dmz)localObject2).Id);
        i += 1;
      }
      label501:
      this.QzR = m.O(t.T((List)localObject1, al.hgP()));
      Log.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap " + this.QzS.QmT.hOG + " " + this.QzR);
      al.hgy().a(this.QzS.QmT.hOG, this.QzR, this.QzS.QmT.QnY);
      break label132;
      label593:
      if (this.QzS.QmT.QnY == 1) {
        localObject1 = "1-" + this.QzS.QmT.hOG;
      } else if (this.QzS.QmT.QnY == 4) {
        localObject1 = "4-" + this.QzS.QmT.hOG;
      } else if (this.QzS.QmT.QnY == 5) {
        localObject1 = "5-" + this.QzS.QmT.hOG;
      }
    }
  }
  
  public final void onPostExecute(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    if (this.QzS == null) {
      return;
    }
    Log.i("MicroMsg.SnsCdnDownloadBase", "download done result: %d, url:%s, mediaID:%s, totalSize: %d, runningTasksSize: %d", new Object[] { paramInteger, this.QzS.url, this.QzS.mediaId, Integer.valueOf(this.aes), Integer.valueOf(QAj.size()) });
    QAj.remove(this.QzS.Qsq);
    if ((this.QzS.QzL) && (paramInteger.intValue() != 2))
    {
      be.hc(this.QzS.mediaId, this.QzS.mediaType);
      hhL();
    }
    for (;;)
    {
      this.QzQ.a(paramInteger.intValue(), this.ibT, this.QzS.QzN, this.QzS.QzL, this.QzS.Qsq, this.aes, -1, true);
      return;
      if ((!this.QzS.QzL) && (this.QzS.QzN == 4))
      {
        String str = this.QzS.getPath() + t.i(this.ibT);
        al.hgy().md(this.QzS.mediaId, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.b
 * JD-Core Version:    0.7.0.1
 */