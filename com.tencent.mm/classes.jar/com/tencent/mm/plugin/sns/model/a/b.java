package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.b.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelsns.m;
import com.tencent.mm.n.f;
import com.tencent.mm.network.d.b;
import com.tencent.mm.network.x;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.bp;
import com.tencent.mm.vfs.s;
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
  private static HashSet<String> DPK = new HashSet();
  protected long DPA = -1L;
  protected long DPB = -1L;
  protected long DPC = -1L;
  protected String DPD = "";
  protected PString DPE = new PString();
  protected int DPF;
  protected long DPG;
  protected long DPH;
  protected long DPI;
  protected int DPJ = 0;
  private Map<String, List<String>> DPL;
  int DPM = 0;
  protected c.a DPr;
  protected com.tencent.mm.memory.n DPs = null;
  protected a DPt = null;
  private String DPu = "";
  private String DPv = "";
  private String DPw = "";
  private int DPx = 0;
  protected int DPy = 0;
  private long DPz = -1L;
  private int cnR = 0;
  private long dnsCostTime = -1L;
  protected cnb ebR = null;
  private String host = "";
  private int jDL = -1;
  private int retCode = -1;
  
  public b(c.a parama, a parama1)
  {
    super(parama, parama1);
    this.DPr = parama;
    this.DPt = parama1;
    if (parama1 == null) {
      return;
    }
    this.ebR = parama1.DIq;
    DPK.add(parama1.DIp);
    parama1.init();
  }
  
  private x a(d.b paramb, String paramString)
  {
    try
    {
      this.DPw = paramb.ip;
      this.jDL = paramb.jDL;
      this.DPA = Util.nowMilliSecond();
      paramb = com.tencent.mm.network.d.a(this.DPt.url, paramb);
      paramb.setRequestMethod("GET");
      paramb.setRequestProperty("referer", paramString);
      if (Util.getInt(com.tencent.mm.n.h.aqJ().getValue("SnsDownloadHttpKeep"), 0) > 0)
      {
        Log.i("MicroMsg.SnsCdnDownloadBase", "header Connection close ");
        paramb.setRequestProperty("Connection", "close");
      }
      paramb.setConnectTimeout(25000);
      paramb.setReadTimeout(25000);
      paramb = a(paramb);
      this.DPL = paramb.getHeaderFields();
      paramString = (List)this.DPL.get("X-ClientIp");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.DPv = ((String)paramString.get(0));
      }
      paramString = (List)this.DPL.get("X-ServerIp");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.DPu = ((String)paramString.get(0));
      }
      paramString = (List)this.DPL.get("X-ErrNo");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.DPx = Util.safeParseInt((String)paramString.get(0));
      }
      paramString = (List)this.DPL.get("X-RtFlag");
      if ((paramString != null) && (paramString.size() > 0)) {
        this.DPy = Util.safeParseInt((String)paramString.get(0));
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
          aM(paramb.getHeaderFields());
          if (this.DPt.DPn)
          {
            if ((this.retCode >= 400) && (this.retCode < 500))
            {
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(22L, 78L, 1L, true);
              if (this.DPt.DPm) {
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(150L, 14L, 1L, true);
              }
              Log.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! mediaId : " + this.DPt.mediaId + " " + this.DPt.url + " " + this.retCode);
              dP(false);
              return null;
            }
            if ((this.retCode < 500) || (this.retCode >= 600)) {
              continue;
            }
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(22L, 79L, 1L, true);
            continue;
          }
        }
        catch (SocketTimeoutException paramb)
        {
          this.retCode = 1;
          dP(false);
          paramb = paramb.getMessage();
          if (!this.DPt.DPn) {
            break label780;
          }
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(22L, 77L, 1L, true);
          if (this.DPt.DPm) {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(150L, 14L, 1L, true);
          }
          Log.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! socket timeout mediaId : " + this.DPt.mediaId + " " + this.DPt.url + " msg:" + paramb);
          return null;
          if ((this.retCode >= 400) && (this.retCode < 500))
          {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(22L, 56L, 1L, true);
            continue;
          }
        }
        catch (Exception paramb)
        {
          dP(false);
          paramb = paramb.getMessage();
          if (this.DPt.DPm) {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(150L, 14L, 1L, true);
          }
          Log.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! mediaId : " + this.DPt.mediaId + " " + this.DPt.url + " msg:" + paramb);
          return null;
        }
        if ((this.retCode >= 500) && (this.retCode < 600))
        {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(22L, 57L, 1L, true);
          continue;
          label780:
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(22L, 55L, 1L, true);
        }
      }
      aM(paramb.getHeaderFields());
    }
    catch (Exception paramb)
    {
      Log.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", paramb, "connect fail : " + paramb.getMessage(), new Object[0]);
      this.retCode = 2;
      dP(false);
      return null;
    }
    if (!c(paramb))
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(22L, 62L, 1L, true);
      Log.e("MicroMsg.SnsCdnDownloadBase", "checkHttpConnection failed! nocache mediaId : " + this.DPt.mediaId);
      dP(false);
      return null;
    }
    this.DPA = Util.milliSecondsToNow(this.DPA);
    paramString = (List)this.DPL.get("Content-Length");
    if ((paramString != null) && (paramString.size() > 0)) {
      this.DPJ = Util.safeParseInt((String)paramString.get(0));
    }
    Log.i("MicroMsg.SnsCdnDownloadBase", "ip: url %s client ip %s server ip %s svrlen %d %d", new Object[] { this.DPt.url, this.DPv, this.DPu, Integer.valueOf(this.DPJ), Integer.valueOf(this.DPx) });
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
  
  private static void aM(Map<String, List<String>> paramMap)
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
  
  private static long aPJ(String paramString)
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
  private int b(x paramx)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokestatic 142	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   7: putfield 447	com/tencent/mm/plugin/sns/model/a/b:DPI	J
    //   10: aload_1
    //   11: invokevirtual 451	com/tencent/mm/network/x:getInputStream	()Ljava/io/InputStream;
    //   14: astore_3
    //   15: aload_0
    //   16: invokestatic 142	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   19: putfield 87	com/tencent/mm/plugin/sns/model/a/b:DPB	J
    //   22: aload_0
    //   23: aload_3
    //   24: invokevirtual 455	com/tencent/mm/plugin/sns/model/a/b:K	(Ljava/io/InputStream;)Z
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
    //   53: invokespecial 309	com/tencent/mm/plugin/sns/model/a/b:dP	(Z)V
    //   56: aload_1
    //   57: ifnull +7 -> 64
    //   60: aload_1
    //   61: invokevirtual 470	com/tencent/mm/network/x:disconnect	()V
    //   64: iconst_2
    //   65: ireturn
    //   66: aload_0
    //   67: aload_0
    //   68: getfield 87	com/tencent/mm/plugin/sns/model/a/b:DPB	J
    //   71: invokestatic 347	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   74: putfield 87	com/tencent/mm/plugin/sns/model/a/b:DPB	J
    //   77: aload_0
    //   78: aload_0
    //   79: getfield 89	com/tencent/mm/plugin/sns/model/a/b:DPC	J
    //   82: invokestatic 347	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   85: putfield 79	com/tencent/mm/plugin/sns/model/a/b:DPz	J
    //   88: aload_0
    //   89: invokevirtual 473	com/tencent/mm/plugin/sns/model/a/b:fbX	()Z
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
    //   119: invokespecial 309	com/tencent/mm/plugin/sns/model/a/b:dP	(Z)V
    //   122: aload_1
    //   123: ifnull -59 -> 64
    //   126: aload_1
    //   127: invokevirtual 470	com/tencent/mm/network/x:disconnect	()V
    //   130: iconst_2
    //   131: ireturn
    //   132: aload_1
    //   133: ifnull +7 -> 140
    //   136: aload_1
    //   137: invokevirtual 470	com/tencent/mm/network/x:disconnect	()V
    //   140: aload_0
    //   141: iconst_1
    //   142: invokespecial 309	com/tencent/mm/plugin/sns/model/a/b:dP	(Z)V
    //   145: aload_0
    //   146: getfield 61	com/tencent/mm/plugin/sns/model/a/b:DPt	Lcom/tencent/mm/plugin/sns/model/a/a;
    //   149: getfield 277	com/tencent/mm/plugin/sns/model/a/a:DPm	Z
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
    //   200: invokespecial 309	com/tencent/mm/plugin/sns/model/a/b:dP	(Z)V
    //   203: aload_3
    //   204: ifnull +7 -> 211
    //   207: aload_3
    //   208: invokevirtual 459	java/io/InputStream:close	()V
    //   211: aload_1
    //   212: ifnull -148 -> 64
    //   215: aload_1
    //   216: invokevirtual 470	com/tencent/mm/network/x:disconnect	()V
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
    //   253: invokevirtual 470	com/tencent/mm/network/x:disconnect	()V
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
  
  private static boolean c(x paramx)
  {
    try
    {
      paramx = (List)paramx.getHeaderFields().get("cache-control");
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
  
  private void dP(boolean paramBoolean)
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
    if ((this.DPt != null) && (this.DPt.DPn)) {
      if (!paramBoolean)
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(22L, 74L, 1L, true);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(22L, 73L, 1L, true);
        if ((this.DPt != null) && (this.DPt.DPm) && (!paramBoolean) && (!r.b(this.DPs))) {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(150L, 66L, 1L, true);
        }
        this.cnR = this.DPM;
        if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
          break label735;
        }
        j = 1;
        k = NetStatusUtil.getStrength(MMApplicationContext.getContext());
        i = this.jDL;
        l1 = this.dnsCostTime;
        l2 = this.DPA;
        long l3 = this.DPB;
        long l4 = this.DPz;
        localObject = this.DPu;
        String str2 = this.DPw;
        String str3 = this.DPv;
        if (this.DPt != null) {
          break label740;
        }
        str1 = "";
        Log.v("MicroMsg.SnsCdnDownloadBase", "report dns:%d wifi:%d signal:%d [%d,%d,%d]%d serverIp:[%s,%s] xclientip:%s url[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), localObject, str2, str3, str1 });
        m = NetStatusUtil.getNetType(MMApplicationContext.getContext());
        i = 0;
        if (this.DPt != null)
        {
          if (this.DPt.DPo != 4) {
            break label752;
          }
          i = 1;
        }
        label301:
        Log.i("MicroMsg.SnsCdnDownloadBase", "retCode :%d totalSize: %d net: %d downloadType %d xErrorNo %d", new Object[] { Integer.valueOf(this.retCode), Integer.valueOf(this.cnR), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.DPx) });
        localObject = com.tencent.mm.plugin.report.service.h.CyF;
        if (this.DPt != null) {
          break label757;
        }
        str1 = "";
        label374:
        l2 = aPJ(this.DPw);
        if (!paramBoolean) {
          break label769;
        }
      }
    }
    label769:
    for (long l1 = this.DPz;; l1 = 0L)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).a(10736, new Object[] { str1, Long.valueOf(l2), Long.valueOf(l1), "", Integer.valueOf(j), Long.valueOf(this.dnsCostTime), Long.valueOf(this.DPA), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(this.DPB), Long.valueOf(aPJ(this.DPv)), Long.valueOf(aPJ(this.DPu)), Integer.valueOf(this.jDL), Integer.valueOf(k), Integer.valueOf(this.retCode), Integer.valueOf(this.cnR), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.DPx) });
      boolean bool = NetStatusUtil.isConnected(MMApplicationContext.getContext());
      Log.d("MicroMsg.SnsCdnDownloadBase", "isConntected  " + bool + " urlIp: " + this.DPD);
      if ((!paramBoolean) && (!Util.isNullOrNil(this.DPD)) && (bool)) {
        com.tencent.mm.network.d.reportFailIp(this.DPD);
      }
      fbY();
      return;
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(22L, 75L, this.DPz, true);
      break;
      if (!paramBoolean) {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(22L, 52L, 1L, true);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(22L, 51L, 1L, true);
        break;
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(22L, 53L, this.DPz, true);
      }
      label735:
      j = 0;
      break label113;
      label740:
      str1 = this.DPt.url;
      break label179;
      label752:
      i = 0;
      break label301;
      label757:
      str1 = this.DPt.url;
      break label374;
    }
  }
  
  private void fbY()
  {
    Log.i("MicroMsg.SnsCdnDownloadBase", "ready to report logbuffer(13346) packageRecordList:%s", new Object[] { this.DPE.value });
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
      localObject = com.tencent.mm.model.c.d.aXu().Fu(str1);
      if (((com.tencent.mm.storage.c)localObject).isValid())
      {
        i = Util.getInt((String)((com.tencent.mm.storage.c)localObject).gzz().get("needUploadData"), 1);
        str2 = ((com.tencent.mm.storage.c)localObject).field_expId;
      }
      break;
    }
    while (i != 0)
    {
      localObject = new m();
      ((m)localObject).n("20ImgSize", this.DPM + ",");
      StringBuilder localStringBuilder = new StringBuilder();
      if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {}
      for (i = 1;; i = 0)
      {
        ((m)localObject).n("21NetType", i + ",");
        ((m)localObject).n("22DelayTime", this.DPz - this.DPA + ",");
        ((m)localObject).n("23RetCode", this.retCode + ",");
        ((m)localObject).n("24DnsCostTime", this.dnsCostTime + ",");
        ((m)localObject).n("25ConnectCostTime", this.DPA + ",");
        ((m)localObject).n("26SendCostTime", ",");
        ((m)localObject).n("27WaitResponseCostTime", this.DPH + ",");
        ((m)localObject).n("28ReceiveCostTime", this.DPB + ",");
        ((m)localObject).n("29ClientAddrIP", this.DPv + ",");
        ((m)localObject).n("30ServerAddrIP", this.DPw + ",");
        ((m)localObject).n("31dnstype", this.jDL + ",");
        ((m)localObject).n("32signal", NetStatusUtil.getStrength(MMApplicationContext.getContext()) + ",");
        ((m)localObject).n("33host", this.host + ",");
        ((m)localObject).n("34MediaType", j + ",");
        ((m)localObject).n("35X_Errno", this.DPx + ",");
        ((m)localObject).n("36MaxPackageSize", this.DPF + ",");
        ((m)localObject).n("37MaxPackageTimeStamp", this.DPG + ",");
        ((m)localObject).n("38PackageRecordList", this.DPE.value + ",");
        ((m)localObject).n("39ExpLayerId", str1 + ",");
        ((m)localObject).n("40ExpId", str2 + ",");
        ((m)localObject).n("41FeedId", ",");
        Log.i("MicroMsg.SnsCdnDownloadBase", "report logbuffer(13480 TLMediaFielDownloadRecord): " + ((m)localObject).abW());
        com.tencent.mm.plugin.report.service.h.CyF.a(13480, new Object[] { localObject });
        if (this.retCode == 200) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.CyF.a(14071, new Object[] { localObject });
        return;
        str1 = "100106";
        break label65;
        str1 = "100100";
        break label65;
      }
      i = 0;
    }
  }
  
  public abstract boolean K(InputStream paramInputStream);
  
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
        if ((parambp != null) && (paramString2 != null) && (paramString2.indexOf(paramString1.getHost()) != -1) && (parambp.hXs != 0))
        {
          long l = Util.secondsToNow(parambp.hXs);
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
  
  public String aPI(String paramString)
  {
    return paramString;
  }
  
  public final ExecutorService eGk()
  {
    return aj.fay();
  }
  
  public boolean fbW()
  {
    return true;
  }
  
  public abstract boolean fbX();
  
  public final Integer fbZ()
  {
    com.tencent.mm.kernel.g.aAi();
    if ((!com.tencent.mm.kernel.g.aAh().isSDCardAvailable()) || (this.DPt == null))
    {
      dP(false);
      return Integer.valueOf(2);
    }
    if (fbW())
    {
      localObject1 = this.DPt.DIl + this.DPt.fbV();
      Log.i("MicroMsg.SnsCdnDownloadBase", "[tomys] delete img: %s", new Object[] { localObject1 });
      s.deleteFile((String)localObject1);
    }
    long l3 = System.currentTimeMillis();
    this.DPC = System.currentTimeMillis();
    Log.d("MicroMsg.SnsCdnDownloadBase", "to downloadBitmap " + this.DPt.mediaId + " " + this.DPt.DPm + " type " + this.DPt.DPo);
    s.boN(this.DPt.getPath());
    Object localObject3 = this.DPt.DPp;
    Object localObject1 = "";
    Object localObject2;
    if (localObject3 == null)
    {
      localObject1 = "";
      localObject2 = bp.Oqt;
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (!Util.isNullOrNil((String)localObject1)) {
        localObject3 = "&scene=".concat(String.valueOf(localObject1));
      }
      String str2 = String.format("https://" + WeChatHosts.domainString(2131761749) + "/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.KyO), p.getString(aj.fav()), Integer.valueOf(NetStatusUtil.getNetTypeForStat(MMApplicationContext.getContext())), Integer.valueOf(NetStatusUtil.getStrength(MMApplicationContext.getContext())), localObject3 });
      this.DPt.url = aPI(this.DPt.url);
      this.dnsCostTime = Util.nowMilliSecond();
      label351:
      label366:
      boolean bool;
      if (this.DPt.DPn)
      {
        localObject1 = "SnsSightDomainList";
        if (!this.DPt.DPn) {
          break label959;
        }
        localObject3 = "SnsSightMainStandbyIpSwitchTime";
        localObject1 = com.tencent.mm.n.h.aqJ().getValue((String)localObject1);
        long l2 = com.tencent.mm.n.h.aqJ().getInt((String)localObject3, 0);
        Log.i("MicroMsg.SnsCdnDownloadBase", "pack.isAlbum %s pack.isthumb %s hostvalue %s dcipTime %s", new Object[] { Boolean.valueOf(this.DPt.DPn), Boolean.valueOf(this.DPt.DPm), localObject1, Long.valueOf(l2) });
        long l1 = l2;
        if (l2 <= 0L) {
          l1 = 259200L;
        }
        bool = a((bp)localObject2, this.DPt.url, l1, (String)localObject1);
        localObject3 = new d.b(this.DPt.url, bool);
        this.dnsCostTime = Util.milliSecondsToNow(this.dnsCostTime);
      }
      try
      {
        if (Util.isNullOrNil(((d.b)localObject3).ip)) {}
        for (localObject1 = InetAddress.getByName(((d.b)localObject3).host).getHostAddress();; localObject1 = ((d.b)localObject3).ip)
        {
          Log.i("MicroMsg.SnsCdnDownloadBase", "checkAndGetHttpConn[%s] [%s] [id:%s] host ip:%d[%s] [%s] download type[%d] isDcIp[%s] fromScene[%s]", new Object[] { str2, this.DPt.url, this.DPt.mediaId, Integer.valueOf(((d.b)localObject3).jDL), localObject1, this.DPt.url, Integer.valueOf(this.DPt.DPo), Boolean.valueOf(bool), ((bp)localObject2).toString() });
          this.DPy = 1;
          localObject1 = a((d.b)localObject3, str2);
          localObject2 = ((d.b)localObject3).ip;
          if (localObject1 == null) {
            break label987;
          }
          bool = true;
          Log.i("MicroMsg.SnsCdnDownloadBase", "[sns ip strategy]connect ip:%s, result:%b, canRetry(X-RtFlag):%d, isDC(cold ip):%b, url:%s", new Object[] { localObject2, Boolean.valueOf(bool), Integer.valueOf(this.DPy), Boolean.valueOf(((d.b)localObject3).jDO), ((d.b)localObject3).jDN });
          int i = 2;
          if (localObject1 != null) {
            i = b((x)localObject1);
          }
          Log.i("MicroMsg.SnsCdnDownloadBase", "DOWN FIN time:%d down:%d mediaId:%s url[%s], size %d", new Object[] { Long.valueOf(Util.milliSecondsToNow(l3)), Long.valueOf(this.DPz), this.DPt.mediaId, this.DPt.url, Integer.valueOf(this.DPM) });
          return Integer.valueOf(i);
          if (((bp)localObject3).equals(bp.Oqm))
          {
            localObject1 = "album_friend";
            localObject2 = localObject3;
            break;
          }
          if (((bp)localObject3).equals(bp.Oqn))
          {
            localObject1 = "album_self";
            localObject2 = localObject3;
            break;
          }
          if (((bp)localObject3).equals(bp.Oqo))
          {
            localObject1 = "album_stranger";
            localObject2 = localObject3;
            break;
          }
          if (((bp)localObject3).equals(bp.Oqp))
          {
            localObject1 = "profile_friend";
            localObject2 = localObject3;
            break;
          }
          if (((bp)localObject3).equals(bp.Oqq))
          {
            localObject1 = "profile_stranger";
            localObject2 = localObject3;
            break;
          }
          if (((bp)localObject3).equals(bp.Oqr))
          {
            localObject1 = "comment";
            localObject2 = localObject3;
            break;
          }
          localObject2 = localObject3;
          if (!((bp)localObject3).equals(bp.Oql)) {
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
  
  public final void fca()
  {
    if (aj.isInValid()) {
      return;
    }
    System.currentTimeMillis();
    Object localObject1;
    Object localObject2;
    if (this.DPt.DDH.DEs == 4)
    {
      Log.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur thumb");
      localObject1 = r.e(this.ebR);
      localObject2 = r.g(this.ebR);
      this.DPs = com.tencent.mm.plugin.sns.lucky.a.a.kd(this.DPt.getPath() + (String)localObject1, this.DPt.getPath() + (String)localObject2);
      aj.faL().a(this.DPt.mediaId, this.DPs, this.DPt.DDH.DEs);
      label132:
      localObject1 = null;
      if (this.DPt.DDH.DEs != 0) {
        break label593;
      }
      localObject1 = "0-" + this.DPt.DDH.dPI;
    }
    for (;;)
    {
      aj.faL().aOY((String)localObject1);
      return;
      if (this.DPt.DDH.DEs == 5)
      {
        Log.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur grid");
        localObject1 = r.e(this.ebR);
        localObject2 = r.h(this.ebR);
        this.DPs = com.tencent.mm.plugin.sns.lucky.a.a.kd(this.DPt.getPath() + (String)localObject1, this.DPt.getPath() + (String)localObject2);
        aj.faL().a(this.DPt.mediaId, this.DPs, this.DPt.DDH.DEs);
        break label132;
      }
      if (this.DPt.DDH.list.size() <= 1)
      {
        aj.faL().a(this.DPt.mediaId, this.DPs, this.DPt.DDH.DEs);
        break label132;
      }
      aj.faL().a(this.DPt.mediaId, this.DPs, 0);
      localObject1 = new LinkedList();
      int i = 0;
      for (;;)
      {
        if ((i >= this.DPt.DDH.list.size()) || (i >= 4)) {
          break label501;
        }
        localObject2 = (cnb)this.DPt.DDH.list.get(i);
        com.tencent.mm.memory.n localn = aj.faL().aOZ(((cnb)localObject2).Id);
        if (!r.b(localn)) {
          break;
        }
        ((List)localObject1).add(localn);
        Log.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap from " + localn + " " + ((cnb)localObject2).Id);
        i += 1;
      }
      label501:
      this.DPs = com.tencent.mm.memory.n.H(r.z((List)localObject1, aj.fbb()));
      Log.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap " + this.DPt.DDH.dPI + " " + this.DPs);
      aj.faL().a(this.DPt.DDH.dPI, this.DPs, this.DPt.DDH.DEs);
      break label132;
      label593:
      if (this.DPt.DDH.DEs == 1) {
        localObject1 = "1-" + this.DPt.DDH.dPI;
      } else if (this.DPt.DDH.DEs == 4) {
        localObject1 = "4-" + this.DPt.DDH.dPI;
      } else if (this.DPt.DDH.DEs == 5) {
        localObject1 = "5-" + this.DPt.DDH.dPI;
      }
    }
  }
  
  protected abstract int getMediaType();
  
  public final void onPostExecute(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    if (this.DPt == null) {
      return;
    }
    Log.i("MicroMsg.SnsCdnDownloadBase", "download done result: %d, url:%s, mediaID:%s, totalSize: %d, runningTasksSize: %d", new Object[] { paramInteger, this.DPt.url, this.DPt.mediaId, Integer.valueOf(this.cnR), Integer.valueOf(DPK.size()) });
    DPK.remove(this.DPt.DIp);
    if ((this.DPt.DPm) && (paramInteger.intValue() != 2))
    {
      bd.fF(this.DPt.mediaId, this.DPt.mediaType);
      fca();
    }
    for (;;)
    {
      this.DPr.a(paramInteger.intValue(), this.ebR, this.DPt.DPo, this.DPt.DPm, this.DPt.DIp, this.cnR, -1, true);
      return;
      if ((!this.DPt.DPm) && (this.DPt.DPo == 4))
      {
        String str = this.DPt.getPath() + r.j(this.ebR);
        aj.faL().kf(this.DPt.mediaId, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.b
 * JD-Core Version:    0.7.0.1
 */