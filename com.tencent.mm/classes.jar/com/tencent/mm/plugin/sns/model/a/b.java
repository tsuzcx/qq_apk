package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.network.d.b;
import com.tencent.mm.network.x;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.bc;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.bp;
import com.tencent.mm.vfs.u;
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
  private static HashSet<String> KcR = new HashSet();
  protected a KcA = null;
  private String KcB = "";
  private String KcC = "";
  private String KcD = "";
  private int KcE = 0;
  protected int KcF = 0;
  private long KcG = -1L;
  protected long KcH = -1L;
  protected long KcI = -1L;
  protected long KcJ = -1L;
  protected String KcK = "";
  protected PString KcL = new PString();
  protected int KcM;
  protected long KcN;
  protected long KcO;
  protected long KcP;
  protected int KcQ = 0;
  private Map<String, List<String>> KcS;
  int KcT = 0;
  protected c.a Kcy;
  protected com.tencent.mm.memory.n Kcz = null;
  private int cjr = 0;
  private long dnsCostTime = -1L;
  protected cvt fVT = null;
  private String host = "";
  private int muo = -1;
  private int retCode = -1;
  
  public b(c.a parama, a parama1)
  {
    super(parama, parama1);
    this.Kcy = parama;
    this.KcA = parama1;
    if (parama1 == null) {
      return;
    }
    this.fVT = parama1.JVq;
    KcR.add(parama1.JVp);
    parama1.init();
  }
  
  private x a(d.b paramb, String paramString)
  {
    try
    {
      this.KcD = paramb.ip;
      this.muo = paramb.muo;
      this.KcH = Util.nowMilliSecond();
      paramb = com.tencent.mm.network.d.a(this.KcA.url, paramb);
      paramb.Zu("GET");
      paramb.bP("referer", paramString);
      if (Util.getInt(com.tencent.mm.n.h.axc().getValue("SnsDownloadHttpKeep"), 0) > 0)
      {
        Log.i("MicroMsg.SnsCdnDownloadBase", "header Connection close ");
        paramb.bP("Connection", "close");
      }
      paramb.xz(25000);
      paramb.xA(25000);
      paramb = a(paramb);
      this.KcS = paramb.btv();
      paramString = (List)this.KcS.get("X-ClientIp");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.KcC = ((String)paramString.get(0));
      }
      paramString = (List)this.KcS.get("X-ServerIp");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.KcB = ((String)paramString.get(0));
      }
      paramString = (List)this.KcS.get("X-ErrNo");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.KcE = Util.safeParseInt((String)paramString.get(0));
      }
      paramString = (List)this.KcS.get("X-RtFlag");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.KcF = Util.safeParseInt((String)paramString.get(0));
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
          aG(paramb.btv());
          if (this.KcA.Kcu)
          {
            if ((this.retCode >= 400) && (this.retCode < 500))
            {
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(22L, 78L, 1L, true);
              if (this.KcA.Kct) {
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(150L, 14L, 1L, true);
              }
              Log.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! mediaId : " + this.KcA.mediaId + " " + this.KcA.url + " " + this.retCode);
              eo(false);
              return null;
            }
            if ((this.retCode < 500) || (this.retCode >= 600)) {
              continue;
            }
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(22L, 79L, 1L, true);
            continue;
          }
        }
        catch (SocketTimeoutException paramb)
        {
          this.retCode = 1;
          eo(false);
          paramb = paramb.getMessage();
          if (!this.KcA.Kcu) {
            break label780;
          }
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(22L, 77L, 1L, true);
          if (this.KcA.Kct) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(150L, 14L, 1L, true);
          }
          Log.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! socket timeout mediaId : " + this.KcA.mediaId + " " + this.KcA.url + " msg:" + paramb);
          return null;
          if ((this.retCode >= 400) && (this.retCode < 500))
          {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(22L, 56L, 1L, true);
            continue;
          }
        }
        catch (Exception paramb)
        {
          eo(false);
          paramb = paramb.getMessage();
          if (this.KcA.Kct) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(150L, 14L, 1L, true);
          }
          Log.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! mediaId : " + this.KcA.mediaId + " " + this.KcA.url + " msg:" + paramb);
          return null;
        }
        if ((this.retCode >= 500) && (this.retCode < 600))
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(22L, 57L, 1L, true);
          continue;
          label780:
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(22L, 55L, 1L, true);
        }
      }
      aG(paramb.btv());
    }
    catch (Exception paramb)
    {
      Log.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", paramb, "connect fail : " + paramb.getMessage(), new Object[0]);
      this.retCode = 2;
      eo(false);
      return null;
    }
    if (!c(paramb))
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(22L, 62L, 1L, true);
      Log.e("MicroMsg.SnsCdnDownloadBase", "checkHttpConnection failed! nocache mediaId : " + this.KcA.mediaId);
      eo(false);
      return null;
    }
    this.KcH = Util.milliSecondsToNow(this.KcH);
    paramString = (List)this.KcS.get("Content-Length");
    if ((paramString != null) && (paramString.size() > 0)) {
      this.KcQ = Util.safeParseInt((String)paramString.get(0));
    }
    Log.i("MicroMsg.SnsCdnDownloadBase", "ip: url %s client ip %s server ip %s svrlen %d %d", new Object[] { this.KcA.url, this.KcC, this.KcB, Integer.valueOf(this.KcQ), Integer.valueOf(this.KcE) });
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
  
  private static void aG(Map<String, List<String>> paramMap)
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
  
  /* Error */
  private int b(x paramx)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokestatic 142	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   7: putfield 426	com/tencent/mm/plugin/sns/model/a/b:KcP	J
    //   10: aload_1
    //   11: invokevirtual 430	com/tencent/mm/network/x:getInputStream	()Ljava/io/InputStream;
    //   14: astore_3
    //   15: aload_0
    //   16: invokestatic 142	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   19: putfield 87	com/tencent/mm/plugin/sns/model/a/b:KcI	J
    //   22: aload_0
    //   23: aload_3
    //   24: invokevirtual 434	com/tencent/mm/plugin/sns/model/a/b:H	(Ljava/io/InputStream;)Z
    //   27: istore_2
    //   28: aload_3
    //   29: invokevirtual 438	java/io/InputStream:close	()V
    //   32: ldc 184
    //   34: ldc_w 440
    //   37: iload_2
    //   38: invokestatic 443	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   41: invokevirtual 446	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   44: invokestatic 191	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: iload_2
    //   48: ifne +18 -> 66
    //   51: aload_0
    //   52: iconst_0
    //   53: invokespecial 309	com/tencent/mm/plugin/sns/model/a/b:eo	(Z)V
    //   56: aload_1
    //   57: ifnull +7 -> 64
    //   60: aload_1
    //   61: invokevirtual 449	com/tencent/mm/network/x:disconnect	()V
    //   64: iconst_2
    //   65: ireturn
    //   66: aload_0
    //   67: aload_0
    //   68: getfield 87	com/tencent/mm/plugin/sns/model/a/b:KcI	J
    //   71: invokestatic 347	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   74: putfield 87	com/tencent/mm/plugin/sns/model/a/b:KcI	J
    //   77: aload_0
    //   78: aload_0
    //   79: getfield 89	com/tencent/mm/plugin/sns/model/a/b:KcJ	J
    //   82: invokestatic 347	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   85: putfield 79	com/tencent/mm/plugin/sns/model/a/b:KcG	J
    //   88: aload_0
    //   89: invokevirtual 452	com/tencent/mm/plugin/sns/model/a/b:fPQ	()Z
    //   92: istore_2
    //   93: ldc 184
    //   95: ldc_w 454
    //   98: iload_2
    //   99: invokestatic 443	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   102: invokevirtual 446	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   105: invokestatic 191	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: iload_2
    //   109: ifne +23 -> 132
    //   112: aload_0
    //   113: iconst_3
    //   114: putfield 98	com/tencent/mm/plugin/sns/model/a/b:retCode	I
    //   117: aload_0
    //   118: iconst_0
    //   119: invokespecial 309	com/tencent/mm/plugin/sns/model/a/b:eo	(Z)V
    //   122: aload_1
    //   123: ifnull -59 -> 64
    //   126: aload_1
    //   127: invokevirtual 449	com/tencent/mm/network/x:disconnect	()V
    //   130: iconst_2
    //   131: ireturn
    //   132: aload_1
    //   133: ifnull +7 -> 140
    //   136: aload_1
    //   137: invokevirtual 449	com/tencent/mm/network/x:disconnect	()V
    //   140: aload_0
    //   141: iconst_1
    //   142: invokespecial 309	com/tencent/mm/plugin/sns/model/a/b:eo	(Z)V
    //   145: aload_0
    //   146: getfield 61	com/tencent/mm/plugin/sns/model/a/b:KcA	Lcom/tencent/mm/plugin/sns/model/a/a;
    //   149: getfield 277	com/tencent/mm/plugin/sns/model/a/a:Kct	Z
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
    //   169: ldc_w 456
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
    //   200: invokespecial 309	com/tencent/mm/plugin/sns/model/a/b:eo	(Z)V
    //   203: aload_3
    //   204: ifnull +7 -> 211
    //   207: aload_3
    //   208: invokevirtual 438	java/io/InputStream:close	()V
    //   211: aload_1
    //   212: ifnull -148 -> 64
    //   215: aload_1
    //   216: invokevirtual 449	com/tencent/mm/network/x:disconnect	()V
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
    //   245: invokevirtual 438	java/io/InputStream:close	()V
    //   248: aload_1
    //   249: ifnull +7 -> 256
    //   252: aload_1
    //   253: invokevirtual 449	com/tencent/mm/network/x:disconnect	()V
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
    //   0	305	1	paramx	x
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
  
  private static long baF(String paramString)
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
  
  private static boolean c(x paramx)
  {
    try
    {
      paramx = (List)paramx.btv().get("cache-control");
      if ((paramx != null) && (paramx.size() != 0))
      {
        if ((Util.isNullOrNil(paramx.toString())) || (!paramx.toString().contains("no-cache"))) {
          break label94;
        }
        boolean bool = paramx.toString().contains("no-cache");
        return !bool;
      }
    }
    catch (Exception paramx)
    {
      Log.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", paramx, "", new Object[0]);
      return false;
    }
    return true;
    label94:
    return true;
  }
  
  private void eo(boolean paramBoolean)
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
    if ((this.KcA != null) && (this.KcA.Kcu)) {
      if (!paramBoolean)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(22L, 74L, 1L, true);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(22L, 73L, 1L, true);
        if ((this.KcA != null) && (this.KcA.Kct) && (!paramBoolean) && (!t.b(this.Kcz))) {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(150L, 66L, 1L, true);
        }
        this.cjr = this.KcT;
        if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
          break label735;
        }
        j = 1;
        k = ConnectivityCompat.Companion.getCompatMixStrength();
        i = this.muo;
        l1 = this.dnsCostTime;
        l2 = this.KcH;
        long l3 = this.KcI;
        long l4 = this.KcG;
        localObject = this.KcB;
        String str2 = this.KcD;
        String str3 = this.KcC;
        if (this.KcA != null) {
          break label740;
        }
        str1 = "";
        Log.v("MicroMsg.SnsCdnDownloadBase", "report dns:%d wifi:%d signal:%d [%d,%d,%d]%d serverIp:[%s,%s] xclientip:%s url[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), localObject, str2, str3, str1 });
        m = NetStatusUtil.getNetType(MMApplicationContext.getContext());
        i = 0;
        if (this.KcA != null)
        {
          if (this.KcA.Kcv != 4) {
            break label752;
          }
          i = 1;
        }
        label301:
        Log.i("MicroMsg.SnsCdnDownloadBase", "retCode :%d totalSize: %d net: %d downloadType %d xErrorNo %d", new Object[] { Integer.valueOf(this.retCode), Integer.valueOf(this.cjr), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.KcE) });
        localObject = com.tencent.mm.plugin.report.service.h.IzE;
        if (this.KcA != null) {
          break label757;
        }
        str1 = "";
        label374:
        l2 = baF(this.KcD);
        if (!paramBoolean) {
          break label769;
        }
      }
    }
    label769:
    for (long l1 = this.KcG;; l1 = 0L)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).a(10736, new Object[] { str1, Long.valueOf(l2), Long.valueOf(l1), "", Integer.valueOf(j), Long.valueOf(this.dnsCostTime), Long.valueOf(this.KcH), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(this.KcI), Long.valueOf(baF(this.KcC)), Long.valueOf(baF(this.KcB)), Integer.valueOf(this.muo), Integer.valueOf(k), Integer.valueOf(this.retCode), Integer.valueOf(this.cjr), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.KcE) });
      boolean bool = NetStatusUtil.isConnected(MMApplicationContext.getContext());
      Log.d("MicroMsg.SnsCdnDownloadBase", "isConntected  " + bool + " urlIp: " + this.KcK);
      if ((!paramBoolean) && (!Util.isNullOrNil(this.KcK)) && (bool)) {
        com.tencent.mm.network.d.reportFailIp(this.KcK);
      }
      fPR();
      return;
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(22L, 75L, this.KcG, true);
      break;
      if (!paramBoolean) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(22L, 52L, 1L, true);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(22L, 51L, 1L, true);
        break;
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(22L, 53L, this.KcG, true);
      }
      label735:
      j = 0;
      break label113;
      label740:
      str1 = this.KcA.url;
      break label179;
      label752:
      i = 0;
      break label301;
      label757:
      str1 = this.KcA.url;
      break label374;
    }
  }
  
  private void fPR()
  {
    Log.i("MicroMsg.SnsCdnDownloadBase", "ready to report logbuffer(13346) packageRecordList:%s", new Object[] { this.KcL.value });
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
      localObject = com.tencent.mm.model.c.d.bgB().Mu(str1);
      if (((com.tencent.mm.storage.c)localObject).isValid())
      {
        i = Util.getInt((String)((com.tencent.mm.storage.c)localObject).hvz().get("needUploadData"), 1);
        str2 = ((com.tencent.mm.storage.c)localObject).field_expId;
      }
      break;
    }
    while (i != 0)
    {
      localObject = new com.tencent.mm.modelsns.n();
      ((com.tencent.mm.modelsns.n)localObject).m("20ImgSize", this.KcT + ",");
      StringBuilder localStringBuilder = new StringBuilder();
      if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {}
      for (i = 1;; i = 0)
      {
        ((com.tencent.mm.modelsns.n)localObject).m("21NetType", i + ",");
        ((com.tencent.mm.modelsns.n)localObject).m("22DelayTime", this.KcG - this.KcH + ",");
        ((com.tencent.mm.modelsns.n)localObject).m("23RetCode", this.retCode + ",");
        ((com.tencent.mm.modelsns.n)localObject).m("24DnsCostTime", this.dnsCostTime + ",");
        ((com.tencent.mm.modelsns.n)localObject).m("25ConnectCostTime", this.KcH + ",");
        ((com.tencent.mm.modelsns.n)localObject).m("26SendCostTime", ",");
        ((com.tencent.mm.modelsns.n)localObject).m("27WaitResponseCostTime", this.KcO + ",");
        ((com.tencent.mm.modelsns.n)localObject).m("28ReceiveCostTime", this.KcI + ",");
        ((com.tencent.mm.modelsns.n)localObject).m("29ClientAddrIP", this.KcC + ",");
        ((com.tencent.mm.modelsns.n)localObject).m("30ServerAddrIP", this.KcD + ",");
        ((com.tencent.mm.modelsns.n)localObject).m("31dnstype", this.muo + ",");
        ((com.tencent.mm.modelsns.n)localObject).m("32signal", ConnectivityCompat.Companion.getCompatMixStrength() + ",");
        ((com.tencent.mm.modelsns.n)localObject).m("33host", this.host + ",");
        ((com.tencent.mm.modelsns.n)localObject).m("34MediaType", j + ",");
        ((com.tencent.mm.modelsns.n)localObject).m("35X_Errno", this.KcE + ",");
        ((com.tencent.mm.modelsns.n)localObject).m("36MaxPackageSize", this.KcM + ",");
        ((com.tencent.mm.modelsns.n)localObject).m("37MaxPackageTimeStamp", this.KcN + ",");
        ((com.tencent.mm.modelsns.n)localObject).m("38PackageRecordList", this.KcL.value + ",");
        ((com.tencent.mm.modelsns.n)localObject).m("39ExpLayerId", str1 + ",");
        ((com.tencent.mm.modelsns.n)localObject).m("40ExpId", str2 + ",");
        ((com.tencent.mm.modelsns.n)localObject).m("41FeedId", ",");
        Log.i("MicroMsg.SnsCdnDownloadBase", "report logbuffer(13480 TLMediaFielDownloadRecord): " + ((com.tencent.mm.modelsns.n)localObject).agI());
        com.tencent.mm.plugin.report.service.h.IzE.a(13480, new Object[] { localObject });
        if (this.retCode == 200) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.IzE.a(14071, new Object[] { localObject });
        return;
        str1 = "100106";
        break label65;
        str1 = "100100";
        break label65;
      }
      i = 0;
    }
  }
  
  public abstract boolean H(InputStream paramInputStream);
  
  public x a(x paramx)
  {
    return paramx;
  }
  
  public final boolean a(bp parambp, String paramString1, long paramLong, String paramString2)
  {
    if (paramString1 == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramString1 = new URL(paramString1);
        if ((parambp != null) && (paramString2 != null) && (paramString2.indexOf(paramString1.getHost()) != -1) && (parambp.time != 0))
        {
          long l = Util.secondsToNow(parambp.time);
          if (l > paramLong) {
            return true;
          }
        }
      }
      catch (Exception parambp)
      {
        Log.e("MicroMsg.SnsCdnDownloadBase", "error for check dcip %s", new Object[] { parambp.getMessage() });
      }
    }
    return false;
  }
  
  public String baE(String paramString)
  {
    return paramString;
  }
  
  public boolean fPP()
  {
    return true;
  }
  
  public abstract boolean fPQ();
  
  public final Integer fPS()
  {
    com.tencent.mm.kernel.h.aHH();
    if ((!com.tencent.mm.kernel.h.aHG().isSDCardAvailable()) || (this.KcA == null))
    {
      eo(false);
      return Integer.valueOf(2);
    }
    if (fPP())
    {
      localObject1 = this.KcA.JVl + this.KcA.fPO();
      Log.i("MicroMsg.SnsCdnDownloadBase", "[tomys] delete img: %s", new Object[] { localObject1 });
      u.deleteFile((String)localObject1);
    }
    long l3 = System.currentTimeMillis();
    this.KcJ = System.currentTimeMillis();
    Log.d("MicroMsg.SnsCdnDownloadBase", "to downloadBitmap " + this.KcA.mediaId + " " + this.KcA.Kct + " type " + this.KcA.Kcv);
    u.bBD(this.KcA.getPath());
    Object localObject3 = this.KcA.Kcw;
    Object localObject1 = "";
    Object localObject2;
    if (localObject3 == null)
    {
      localObject1 = "";
      localObject2 = bp.VGp;
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (!Util.isNullOrNil((String)localObject1)) {
        localObject3 = "&scene=".concat(String.valueOf(localObject1));
      }
      String str2 = String.format("https://" + WeChatHosts.domainString(i.j.host_weixin_qq_com) + "/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.RAD), com.tencent.mm.b.p.getString(aj.fOp()), Integer.valueOf(NetStatusUtil.getNetTypeForStat(MMApplicationContext.getContext())), Integer.valueOf(ConnectivityCompat.Companion.getCompatMixStrength()), localObject3 });
      this.KcA.url = baE(this.KcA.url);
      this.dnsCostTime = Util.nowMilliSecond();
      label351:
      label366:
      boolean bool;
      if (this.KcA.Kcu)
      {
        localObject1 = "SnsSightDomainList";
        if (!this.KcA.Kcu) {
          break label959;
        }
        localObject3 = "SnsSightMainStandbyIpSwitchTime";
        localObject1 = com.tencent.mm.n.h.axc().getValue((String)localObject1);
        long l2 = com.tencent.mm.n.h.axc().getInt((String)localObject3, 0);
        Log.i("MicroMsg.SnsCdnDownloadBase", "pack.isAlbum %s pack.isthumb %s hostvalue %s dcipTime %s", new Object[] { Boolean.valueOf(this.KcA.Kcu), Boolean.valueOf(this.KcA.Kct), localObject1, Long.valueOf(l2) });
        long l1 = l2;
        if (l2 <= 0L) {
          l1 = 259200L;
        }
        bool = a((bp)localObject2, this.KcA.url, l1, (String)localObject1);
        localObject3 = new d.b(this.KcA.url, bool);
        this.dnsCostTime = Util.milliSecondsToNow(this.dnsCostTime);
      }
      try
      {
        if (Util.isNullOrNil(((d.b)localObject3).ip)) {}
        for (localObject1 = InetAddress.getByName(((d.b)localObject3).host).getHostAddress();; localObject1 = ((d.b)localObject3).ip)
        {
          Log.i("MicroMsg.SnsCdnDownloadBase", "checkAndGetHttpConn[%s] [%s] [id:%s] host ip:%d[%s] [%s] download type[%d] isDcIp[%s] fromScene[%s]", new Object[] { str2, this.KcA.url, this.KcA.mediaId, Integer.valueOf(((d.b)localObject3).muo), localObject1, this.KcA.url, Integer.valueOf(this.KcA.Kcv), Boolean.valueOf(bool), ((bp)localObject2).toString() });
          this.KcF = 1;
          localObject1 = a((d.b)localObject3, str2);
          localObject2 = ((d.b)localObject3).ip;
          if (localObject1 == null) {
            break label987;
          }
          bool = true;
          Log.i("MicroMsg.SnsCdnDownloadBase", "[sns ip strategy]connect ip:%s, result:%b, canRetry(X-RtFlag):%d, isDC(cold ip):%b, url:%s", new Object[] { localObject2, Boolean.valueOf(bool), Integer.valueOf(this.KcF), Boolean.valueOf(((d.b)localObject3).mur), ((d.b)localObject3).muq });
          int i = 2;
          if (localObject1 != null) {
            i = b((x)localObject1);
          }
          Log.i("MicroMsg.SnsCdnDownloadBase", "DOWN FIN time:%d down:%d mediaId:%s url[%s], size %d", new Object[] { Long.valueOf(Util.milliSecondsToNow(l3)), Long.valueOf(this.KcG), this.KcA.mediaId, this.KcA.url, Integer.valueOf(this.KcT) });
          return Integer.valueOf(i);
          if (((bp)localObject3).equals(bp.VGi))
          {
            localObject1 = "album_friend";
            localObject2 = localObject3;
            break;
          }
          if (((bp)localObject3).equals(bp.VGj))
          {
            localObject1 = "album_self";
            localObject2 = localObject3;
            break;
          }
          if (((bp)localObject3).equals(bp.VGk))
          {
            localObject1 = "album_stranger";
            localObject2 = localObject3;
            break;
          }
          if (((bp)localObject3).equals(bp.VGl))
          {
            localObject1 = "profile_friend";
            localObject2 = localObject3;
            break;
          }
          if (((bp)localObject3).equals(bp.VGm))
          {
            localObject1 = "profile_stranger";
            localObject2 = localObject3;
            break;
          }
          if (((bp)localObject3).equals(bp.VGn))
          {
            localObject1 = "comment";
            localObject2 = localObject3;
            break;
          }
          localObject2 = localObject3;
          if (!((bp)localObject3).equals(bp.VGh)) {
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
  
  public final void fPT()
  {
    if (aj.isInValid()) {
      return;
    }
    System.currentTimeMillis();
    Object localObject1;
    Object localObject2;
    if (this.KcA.JQm.JRn == 4)
    {
      Log.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur thumb");
      localObject1 = t.d(this.fVT);
      localObject2 = t.f(this.fVT);
      this.Kcz = com.tencent.mm.plugin.sns.lucky.a.a.ky(this.KcA.getPath() + (String)localObject1, this.KcA.getPath() + (String)localObject2);
      aj.fOF().a(this.KcA.mediaId, this.Kcz, this.KcA.JQm.JRn);
      label132:
      localObject1 = null;
      if (this.KcA.JQm.JRn != 0) {
        break label593;
      }
      localObject1 = "0-" + this.KcA.JQm.fIY;
    }
    for (;;)
    {
      aj.fOF().aZT((String)localObject1);
      return;
      if (this.KcA.JQm.JRn == 5)
      {
        Log.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur grid");
        localObject1 = t.d(this.fVT);
        localObject2 = t.g(this.fVT);
        this.Kcz = com.tencent.mm.plugin.sns.lucky.a.a.ky(this.KcA.getPath() + (String)localObject1, this.KcA.getPath() + (String)localObject2);
        aj.fOF().a(this.KcA.mediaId, this.Kcz, this.KcA.JQm.JRn);
        break label132;
      }
      if (this.KcA.JQm.list.size() <= 1)
      {
        aj.fOF().a(this.KcA.mediaId, this.Kcz, this.KcA.JQm.JRn);
        break label132;
      }
      aj.fOF().a(this.KcA.mediaId, this.Kcz, 0);
      localObject1 = new LinkedList();
      int i = 0;
      for (;;)
      {
        if ((i >= this.KcA.JQm.list.size()) || (i >= 4)) {
          break label501;
        }
        localObject2 = (cvt)this.KcA.JQm.list.get(i);
        com.tencent.mm.memory.n localn = aj.fOF().aZU(((cvt)localObject2).Id);
        if (!t.b(localn)) {
          break;
        }
        ((List)localObject1).add(localn);
        Log.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap from " + localn + " " + ((cvt)localObject2).Id);
        i += 1;
      }
      label501:
      this.Kcz = com.tencent.mm.memory.n.F(t.A((List)localObject1, aj.fOV()));
      Log.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap " + this.KcA.JQm.fIY + " " + this.Kcz);
      aj.fOF().a(this.KcA.JQm.fIY, this.Kcz, this.KcA.JQm.JRn);
      break label132;
      label593:
      if (this.KcA.JQm.JRn == 1) {
        localObject1 = "1-" + this.KcA.JQm.fIY;
      } else if (this.KcA.JQm.JRn == 4) {
        localObject1 = "4-" + this.KcA.JQm.fIY;
      } else if (this.KcA.JQm.JRn == 5) {
        localObject1 = "5-" + this.KcA.JQm.fIY;
      }
    }
  }
  
  public final ExecutorService fsl()
  {
    return aj.fOs();
  }
  
  protected abstract int getMediaType();
  
  public final void onPostExecute(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    if (this.KcA == null) {
      return;
    }
    Log.i("MicroMsg.SnsCdnDownloadBase", "download done result: %d, url:%s, mediaID:%s, totalSize: %d, runningTasksSize: %d", new Object[] { paramInteger, this.KcA.url, this.KcA.mediaId, Integer.valueOf(this.cjr), Integer.valueOf(KcR.size()) });
    KcR.remove(this.KcA.JVp);
    if ((this.KcA.Kct) && (paramInteger.intValue() != 2))
    {
      bc.gi(this.KcA.mediaId, this.KcA.mediaType);
      fPT();
    }
    for (;;)
    {
      this.Kcy.a(paramInteger.intValue(), this.fVT, this.KcA.Kcv, this.KcA.Kct, this.KcA.JVp, this.cjr, -1, true);
      return;
      if ((!this.KcA.Kct) && (this.KcA.Kcv == 4))
      {
        String str = this.KcA.getPath() + t.i(this.fVT);
        aj.fOF().kA(this.KcA.mediaId, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.b
 * JD-Core Version:    0.7.0.1
 */