package com.tencent.mm.plugin.sns.model.a;

import android.util.SparseArray;
import com.tencent.mars.cdn.CdnLogic.BatchSnsReqImageData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.i.g.a;
import com.tencent.mm.modelsns.m;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.plugin.sns.model.c.c;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.bp;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

public abstract class c
  extends com.tencent.mm.pluginsdk.model.n<String, Integer, Integer>
{
  private static HashSet<String> DPK = new HashSet();
  int DPM = 0;
  protected SparseArray<com.tencent.mm.memory.n> DPN = new SparseArray();
  protected a DPr;
  protected com.tencent.mm.memory.n DPs = null;
  protected a DPt = null;
  private long dnsCostTime = -1L;
  protected cnb ebR = null;
  private String host = "";
  private int jDL = -1;
  
  public c(a parama, a parama1)
  {
    this.DPr = parama;
    this.DPt = parama1;
    if (parama1 == null) {
      return;
    }
    this.ebR = parama1.DIq;
    DPK.add(parama1.DIp);
    parama1.init();
  }
  
  private boolean a(com.tencent.mm.i.e parame, boolean paramBoolean, String paramString)
  {
    for (;;)
    {
      try
      {
        this.host = new URL(this.DPt.url).getHost();
        ArrayList localArrayList1 = new ArrayList();
        this.jDL = com.tencent.mm.network.d.a(this.host, false, localArrayList1);
        ArrayList localArrayList2 = new ArrayList();
        int j = com.tencent.mm.network.d.a(this.host, true, localArrayList2);
        Object localObject;
        if (9 == this.DPt.DPo)
        {
          parame.field_mediaId = (this.DPt.dRS + "_" + this.DPt.DPo);
          if ((parame instanceof com.tencent.mm.i.f))
          {
            com.tencent.mm.i.f localf = (com.tencent.mm.i.f)parame;
            localf.dRS = this.DPt.dRS;
            localf.gqv = this.DPt.size;
            localf.gqw = this.DPt.DEw.size();
            localf.gqo = new CdnLogic.BatchSnsReqImageData[localf.gqw];
            int i = 0;
            if (i < localf.gqw)
            {
              int k = this.DPt.DEw.keyAt(i);
              cnb localcnb = (cnb)this.DPt.DEw.get(k);
              CdnLogic.BatchSnsReqImageData localBatchSnsReqImageData = new CdnLogic.BatchSnsReqImageData();
              String str = localcnb.Msz;
              localObject = str;
              if (Util.isNullOrNil(str))
              {
                localObject = str;
                if (localcnb.oUv == 2) {
                  localObject = localcnb.Url;
                }
              }
              localBatchSnsReqImageData.url = b((String)localObject, localcnb);
              localBatchSnsReqImageData.picIndex = k;
              localBatchSnsReqImageData.totalFileSize = 0;
              localBatchSnsReqImageData.decryptKey = localcnb.MsR;
              localObject = new StringBuilder();
              str = localcnb.Id;
              localBatchSnsReqImageData.imageCachePath = s.k(ar.ki(aj.getAccSnsPath(), str) + r.n(localcnb), false);
              localBatchSnsReqImageData.fileKey = (localcnb.Id + "_" + this.DPt.DPo);
              localf.gqo[i] = localBatchSnsReqImageData;
              i += 1;
              continue;
            }
          }
        }
        else
        {
          parame.field_mediaId = (this.DPt.mediaId + "_" + this.DPt.DPo);
          parame.gqq = (this.DPt.getPath() + this.DPt.fbV());
          if (this.DPt.DIq != null)
          {
            if (!this.DPt.DPm) {
              continue;
            }
            localObject = this.DPt.DIq.MsR;
            parame.snsCipherKey = ((String)localObject);
          }
        }
        parame.url = this.DPt.url;
        parame.host = this.host;
        parame.referer = paramString;
        parame.gqr = ef(localArrayList1);
        parame.gqs = ef(localArrayList2);
        parame.gqt = this.jDL;
        parame.gqu = j;
        parame.isColdSnsData = paramBoolean;
        parame.signalQuality = NetStatusUtil.getStrength(MMApplicationContext.getContext());
        parame.snsScene = this.DPt.DPp.tag;
        if (this.DPt.DPo == 8)
        {
          parame.fuQ = 3;
          parame.appType = 109;
          parame.fileType = 20204;
          Log.i("MicroMsg.SnsCdnDownloadBase", "attachSnsImgTaskInfo reqDownType:%d taskInfo:%s", new Object[] { Integer.valueOf(this.DPt.DPo), parame });
          return true;
          localObject = this.DPt.DIq.MsO;
          continue;
        }
        if ((this.DPt.DPo == 6) || (this.DPt.DPo == 4))
        {
          parame.fuQ = 3;
          parame.appType = 105;
          parame.fileType = 20210;
          continue;
        }
        if (this.DPt.DPo != 5) {
          break label810;
        }
      }
      catch (MalformedURLException parame)
      {
        Log.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", parame, "", new Object[0]);
        Log.w("MicroMsg.SnsCdnDownloadBase", "attachSnsImgTaskInfo fail:".concat(String.valueOf(parame)));
        return false;
      }
      parame.fuQ = 3;
      parame.appType = 150;
      parame.fileType = 20250;
      continue;
      label810:
      if ((this.DPt.DPo == 2) || (this.DPt.DPo == 1) || (this.DPt.DPo == 3) || (this.DPt.DPo == 9))
      {
        parame.fuQ = 3;
        parame.appType = 100;
        parame.fileType = 20201;
        if ((this.DPt.DPo == 1) && ((this.DPt.url.startsWith("http://wxapp.tc.qq.com")) || (this.DPt.url.startsWith("https://wxapp.tc.qq.com"))) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sdK, 1) == 1))
        {
          parame.fuQ = 3;
          parame.appType = 150;
          parame.fileType = 20201;
        }
      }
    }
  }
  
  public static boolean aPK(String paramString)
  {
    if (DPK.contains(r.cr(1, paramString))) {}
    while (DPK.contains(r.cr(5, paramString))) {
      return true;
    }
    return false;
  }
  
  private static String[] ef(List<String> paramList)
  {
    String[] arrayOfString = new String[paramList.size()];
    int i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = ((String)paramList.get(i));
      i += 1;
    }
    return arrayOfString;
  }
  
  public boolean YM(int paramInt)
  {
    return false;
  }
  
  public final void YN(int paramInt)
  {
    if (aj.isInValid()) {
      return;
    }
    Object localObject = (com.tencent.mm.plugin.sns.data.n)this.DPt.DDI.get(paramInt);
    cnb localcnb = (cnb)this.DPt.DEw.get(paramInt);
    Log.i("MicroMsg.SnsCdnDownloadBase", "thumbAddDecode index: %d decodeType: %d.", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((com.tencent.mm.plugin.sns.data.n)localObject).DEs) });
    aj.faL().a(localcnb.Id, (com.tencent.mm.memory.n)this.DPN.get(paramInt), ((com.tencent.mm.plugin.sns.data.n)localObject).DEs);
    if (((com.tencent.mm.plugin.sns.data.n)localObject).DEs == 0) {}
    for (localObject = r.cq(0, ((com.tencent.mm.plugin.sns.data.n)localObject).dPI);; localObject = null)
    {
      Log.i("MicroMsg.SnsCdnDownloadBase", "thumbAddDecode cacheName: %s.", new Object[] { localObject });
      aj.faL().aOY((String)localObject);
      return;
    }
  }
  
  public boolean a(bp parambp, String paramString1, long paramLong, String paramString2)
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
  
  public String b(String paramString, cnb paramcnb)
  {
    return paramString;
  }
  
  protected final void c(com.tencent.mm.i.d paramd)
  {
    int k = getMediaType();
    String str = "";
    Object localObject1;
    label46:
    Object localObject2;
    int i;
    switch (k)
    {
    default: 
      return;
    case 1: 
      localObject1 = "100105";
      localObject2 = com.tencent.mm.model.c.d.aXu().Fu((String)localObject1);
      if (((com.tencent.mm.storage.c)localObject2).isValid())
      {
        i = Util.getInt((String)((com.tencent.mm.storage.c)localObject2).gzz().get("needUploadData"), 1);
        str = ((com.tencent.mm.storage.c)localObject2).field_expId;
      }
      break;
    }
    while (i != 0)
    {
      if (this.DPt.DPo == 8) {
        i = 1;
      }
      for (;;)
      {
        label110:
        localObject2 = new m();
        ((m)localObject2).n("20ImgSize", paramd.field_fileLength + ",");
        StringBuilder localStringBuilder = new StringBuilder();
        int j;
        if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
        {
          j = 1;
          label170:
          ((m)localObject2).n("21NetType", j + ",");
          ((m)localObject2).n("22DelayTime", paramd.field_delayTime + ",");
          ((m)localObject2).n("23RetCode", paramd.field_retCode + ",");
          ((m)localObject2).n("24DnsCostTime", paramd.field_dnsCostTime + ",");
          ((m)localObject2).n("25ConnectCostTime", paramd.field_connectCostTime + ",");
          ((m)localObject2).n("26SendCostTime", ",");
          ((m)localObject2).n("27WaitResponseCostTime", paramd.field_waitResponseCostTime + ",");
          ((m)localObject2).n("28ReceiveCostTime", paramd.field_receiveCostTime + ",");
          ((m)localObject2).n("29ClientAddrIP(uint)", paramd.field_clientHostIP + ",");
          ((m)localObject2).n("30ServerAddrIP(uint)", paramd.field_serverHostIP + ",");
          ((m)localObject2).n("31dnstype", this.jDL + ",");
          ((m)localObject2).n("32signal(int)", NetStatusUtil.getStrength(MMApplicationContext.getContext()) + ",");
          ((m)localObject2).n("33host(string)", this.host + ",");
          ((m)localObject2).n("34MediaType", k + ",");
          ((m)localObject2).n("35X_Errno(string)", paramd.field_xErrorNo + ",");
          ((m)localObject2).n("36MaxPackageSize", ",");
          ((m)localObject2).n("37MaxPackageTimeStamp", ",");
          ((m)localObject2).n("38PackageRecordList", ",");
          ((m)localObject2).n("39ExpLayerId", (String)localObject1 + ",");
          ((m)localObject2).n("40ExpId", str + ",");
          ((m)localObject2).n("41FeedId", ",");
          ((m)localObject2).n("42BizType", i + ",");
          ((m)localObject2).n("43CSeqCheck(uint)", paramd.field_cSeqCheck + ",");
          localObject1 = new StringBuilder();
          if (!paramd.field_usePrivateProtocol) {
            break label993;
          }
        }
        label993:
        for (i = 1;; i = 0)
        {
          ((m)localObject2).n("44isPrivate(uint)", i + ",");
          Log.i("MicroMsg.SnsCdnDownloadBase", "report logbuffer(13480 TLMediaFielDownloadRecord): " + ((m)localObject2).abW());
          com.tencent.mm.plugin.report.service.h.CyF.a(13480, new Object[] { localObject2 });
          if ((paramd.field_retCode == 200) || (paramd.field_retCode == 0)) {
            break;
          }
          com.tencent.mm.plugin.report.service.h.CyF.a(14071, new Object[] { localObject2 });
          return;
          localObject1 = "100106";
          break label46;
          localObject1 = "100100";
          break label46;
          if ((this.DPt.DPo == 6) || (this.DPt.DPo == 4))
          {
            i = 2;
            break label110;
          }
          if (this.DPt.DPo == 5)
          {
            i = 4;
            break label110;
          }
          if ((this.DPt.DPo != 2) && (this.DPt.DPo != 1) && (this.DPt.DPo != 3)) {
            break label998;
          }
          i = 0;
          break label110;
          j = 0;
          break label170;
        }
        label998:
        i = 5;
      }
      i = 0;
    }
  }
  
  public ExecutorService eGk()
  {
    return aj.fay();
  }
  
  public boolean fbW()
  {
    return true;
  }
  
  public abstract boolean fbX();
  
  public Integer fbZ()
  {
    com.tencent.mm.kernel.g.aAi();
    if ((!com.tencent.mm.kernel.g.aAh().isSDCardAvailable()) || (this.DPt == null)) {
      return Integer.valueOf(2);
    }
    Object localObject1;
    Object localObject3;
    Object localObject4;
    if (fbW())
    {
      if (9 == this.DPt.DPo)
      {
        i = 0;
        while (i < this.DPt.DEw.size())
        {
          localObject1 = (cnb)this.DPt.DEw.valueAt(i);
          localObject3 = new StringBuilder();
          localObject4 = ((cnb)localObject1).Id;
          localObject1 = ar.ki(aj.getAccSnsPath(), (String)localObject4) + r.n((cnb)localObject1);
          Log.i("MicroMsg.SnsCdnDownloadBase", "pennqin, delete sns thumb: [%s].", new Object[] { localObject1 });
          s.deleteFile((String)localObject1);
          i += 1;
        }
      }
      localObject1 = this.DPt.DIl + this.DPt.fbV();
      Log.i("MicroMsg.SnsCdnDownloadBase", "[tomys] delete img: %s", new Object[] { localObject1 });
      s.deleteFile((String)localObject1);
    }
    final long l3 = System.currentTimeMillis();
    String str;
    boolean bool;
    for (;;)
    {
      try
      {
        localObject1 = aj.faJ();
        localObject3 = this.DPt.mediaId;
        if (Util.isNullOrNil((String)localObject3)) {
          continue;
        }
        localObject1 = (c.c)((com.tencent.mm.plugin.sns.model.c)localObject1).DGP.get(localObject3);
        if ((localObject1 != null) && (!((c.c)localObject1).DGU)) {
          ((c.c)localObject1).setStartTime(l3);
        }
      }
      catch (Exception localException)
      {
        long l2;
        long l1;
        Log.e("MicroMsg.SnsCdnDownloadBase", "exception msg: %s.", new Object[] { localException.getMessage() });
        continue;
        if (!((bp)localObject4).equals(bp.Oqm)) {
          continue;
        }
        localObject2 = "album_friend";
        continue;
        if (!((bp)localObject4).equals(bp.Oqn)) {
          continue;
        }
        localObject2 = "album_self";
        continue;
        if (!((bp)localObject4).equals(bp.Oqo)) {
          continue;
        }
        localObject2 = "album_stranger";
        continue;
        if (!((bp)localObject4).equals(bp.Oqp)) {
          continue;
        }
        localObject2 = "profile_friend";
        continue;
        if (!((bp)localObject4).equals(bp.Oqq)) {
          continue;
        }
        localObject2 = "profile_stranger";
        continue;
        if (!((bp)localObject4).equals(bp.Oqr)) {
          continue;
        }
        localObject2 = "comment";
        continue;
        if (!((bp)localObject4).equals(bp.Oql)) {
          continue;
        }
        localObject2 = "timeline";
        continue;
        this.DPt.url = aPI(this.DPt.url);
        continue;
        localObject2 = "SnsAlbumDomainList";
        continue;
        localObject3 = "SnsAlbumMainStandbyIpSwitchTime";
        continue;
      }
      i = 0;
      if (this.DPt.DEw != null) {
        i = this.DPt.DEw.size();
      }
      Log.d("MicroMsg.SnsCdnDownloadBase", "to downloadBitmap pack.mediaId: " + this.DPt.mediaId + " pack.mediaObjs.size: " + i + " pack.snsId: " + this.DPt.dRS + " pack.isthumb: " + this.DPt.DPm + " type: " + this.DPt.DPo);
      localObject4 = this.DPt.DPp;
      localObject1 = "";
      if (localObject4 != null) {
        continue;
      }
      localObject1 = "";
      localObject3 = localObject1;
      if (!Util.isNullOrNil((String)localObject1)) {
        localObject3 = "&scene=".concat(String.valueOf(localObject1));
      }
      str = String.format("https://" + WeChatHosts.domainString(2131761749) + "/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.KyO), p.getString(aj.fav()), Integer.valueOf(NetStatusUtil.getNetTypeForStat(MMApplicationContext.getContext())), Integer.valueOf(NetStatusUtil.getStrength(MMApplicationContext.getContext())), localObject3 });
      if (9 != this.DPt.DPo) {
        continue;
      }
      this.DPt.url = b(this.DPt.url, (cnb)this.DPt.DEw.get(0));
      this.dnsCostTime = Util.nowMilliSecond();
      if (!this.DPt.DPn) {
        continue;
      }
      localObject1 = "SnsSightDomainList";
      if (!this.DPt.DPn) {
        continue;
      }
      localObject3 = "SnsSightMainStandbyIpSwitchTime";
      localObject1 = com.tencent.mm.n.h.aqJ().getValue((String)localObject1);
      l2 = com.tencent.mm.n.h.aqJ().getInt((String)localObject3, 0);
      Log.i("MicroMsg.SnsCdnDownloadBase", "pack.isAlbum %s pack.isthumb %s hostvalue %s dcipTime %s", new Object[] { Boolean.valueOf(this.DPt.DPn), Boolean.valueOf(this.DPt.DPm), localObject1, Long.valueOf(l2) });
      l1 = l2;
      if (l2 <= 0L) {
        l1 = 259200L;
      }
      bool = a((bp)localObject4, this.DPt.url, l1, (String)localObject1);
      this.dnsCostTime = Util.milliSecondsToNow(this.dnsCostTime);
      if (9 != this.DPt.DPo) {
        break label1075;
      }
      localObject1 = new com.tencent.mm.i.f();
      ((com.tencent.mm.i.e)localObject1).taskName = "task_SnsCdnDownloadBase_1";
      i = 0;
      if (i >= this.DPt.DEw.size()) {
        break label991;
      }
      localObject3 = ((cnb)this.DPt.DEw.valueAt(i)).Id;
      s.boN(ar.ki(aj.getAccSnsPath(), (String)localObject3));
      i += 1;
      continue;
      localObject1 = null;
    }
    Object localObject2;
    label991:
    if (a((com.tencent.mm.i.e)localObject2, bool, str))
    {
      if ((this.DPt != null) && (this.DPt.DPn)) {
        com.tencent.mm.plugin.sns.ad.e.b.a((com.tencent.mm.i.e)localObject2, this.ebR);
      }
      ((com.tencent.mm.i.e)localObject2).gqy = new g.a()
      {
        public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(96067);
          if (c.this.DPt == null)
          {
            Log.e("MicroMsg.SnsCdnDownloadBase", "pack is null.");
            AppMethodBeat.o(96067);
            return 0;
          }
          int j;
          final int i;
          Object localObject;
          int k;
          com.tencent.mm.plugin.sns.data.n localn;
          if (paramAnonymousd != null) {
            if (paramAnonymousd.field_retCode != 0)
            {
              Log.e("MicroMsg.SnsCdnDownloadBase", "download err, retCode: %d reqDownType: %d.", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(c.this.DPt.DPo) });
              com.tencent.mm.network.d.reportFailIp(paramAnonymousd.field_serverIP);
              if (9 != c.this.DPt.DPo) {
                break label1210;
              }
              paramAnonymousString = paramAnonymousd.gqo;
              if ((paramAnonymousString != null) && (paramAnonymousString.length > 0))
              {
                com.tencent.mm.plugin.report.service.h.CyF.dN(1040, 12);
                paramAnonymousc = (com.tencent.mm.i.f)this.DPO;
                Log.e("MicroMsg.SnsCdnDownloadBase", "download err, taskInfo2 need inc counter, before: %d, inc: %d, count: %d.", new Object[] { Integer.valueOf(paramAnonymousc.cBY), Integer.valueOf(paramAnonymousString.length), Integer.valueOf(paramAnonymousc.gqw) });
                paramAnonymousc.cBY += paramAnonymousString.length;
                j = paramAnonymousString.length;
                i = 0;
                while (i < j)
                {
                  localObject = paramAnonymousString[i];
                  if (((CdnLogic.BatchSnsReqImageData)localObject).retry)
                  {
                    k = ((CdnLogic.BatchSnsReqImageData)localObject).picIndex;
                    localObject = (cnb)c.this.DPt.DEw.get(k);
                    localn = (com.tencent.mm.plugin.sns.data.n)c.this.DPt.DDI.get(k);
                    aj.faJ().a((cnb)localObject, 1, localn, c.this.DPt.DPp, paramAnonymousc.dRS);
                    Log.i("MicroMsg.SnsCdnDownloadBase", "group download err, retry single download. index: %d.", new Object[] { Integer.valueOf(k) });
                  }
                  i += 1;
                }
                i = 2;
              }
            }
          }
          for (;;)
          {
            c.this.c(paramAnonymousd);
            paramAnonymousString = c.this.DPt;
            if (paramAnonymousString != null) {}
            try
            {
              if ((paramAnonymousString.DIq != null) && (paramAnonymousString.DIq.isAd))
              {
                j = k.aOe(paramAnonymousString.DIp);
                Log.i("SnsAdUtil", "reportAdPicCDNDownload, result=" + paramAnonymousd.field_retCode + ", requestKey=" + paramAnonymousString.DIp + ", reqDownType=" + paramAnonymousString.DPo + ", url=" + paramAnonymousString.url);
                if ((j == 1) || (j == 5))
                {
                  if (paramAnonymousd.field_retCode != 0) {
                    break label1060;
                  }
                  k.c(0, 0, 1, paramAnonymousString.url);
                }
              }
            }
            catch (Throwable paramAnonymousString)
            {
              for (;;)
              {
                label457:
                Log.e("SnsAdUtil", "reportAdPicCDNDownload, exp=" + paramAnonymousString.toString());
              }
            }
            aj.dRd().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96066);
                if (9 == c.this.DPt.DPo)
                {
                  if (((com.tencent.mm.i.f)c.1.this.DPO).alN()) {
                    c.fcc().remove(c.this.DPt.DIp);
                  }
                  Log.i("MicroMsg.SnsCdnDownloadBase", "download done result: %d, url:%s, mediaID:%s, totalSize: %d, runningTasksSize: %d", new Object[] { Integer.valueOf(i), c.this.DPt.url, c.this.DPt.mediaId, Long.valueOf(paramAnonymousd.field_fileLength), Integer.valueOf(c.fcc().size()) });
                  if ((!c.this.DPt.DPm) || (i == 2)) {
                    break label553;
                  }
                  if (9 != c.this.DPt.DPo) {
                    break label511;
                  }
                  bd.fF(((cnb)c.this.DPt.DEw.get(paramAnonymousd.index)).Id, c.this.DPt.mediaType);
                  c.this.YN(paramAnonymousd.index);
                }
                Object localObject1;
                Object localObject2;
                long l;
                for (;;)
                {
                  if (9 != c.this.DPt.DPo) {
                    break label671;
                  }
                  localObject1 = (cnb)c.this.DPt.DEw.get(paramAnonymousd.index);
                  localObject2 = (com.tencent.mm.i.f)c.1.this.DPO;
                  if ((((com.tencent.mm.i.f)localObject2).alN()) && (!((com.tencent.mm.i.f)localObject2).gqx))
                  {
                    ((com.tencent.mm.i.f)localObject2).gqx = true;
                    l = Util.milliSecondsToNow(c.1.this.DPP);
                    Log.d("MicroMsg.SnsCdnDownloadBase", "group download, feed cost: %d.", new Object[] { Long.valueOf(l) });
                    com.tencent.mm.plugin.report.service.h.CyF.n(1040L, 3L, l);
                    com.tencent.mm.plugin.report.service.h.CyF.dN(1040, 4);
                    com.tencent.mm.plugin.report.service.h.CyF.n(1040L, 9L, l);
                    com.tencent.mm.plugin.report.service.h.CyF.n(1040L, 10L, ((com.tencent.mm.i.f)localObject2).gqw);
                  }
                  c.this.DPr.a(i, (cnb)localObject1, c.this.DPt.DPo, c.this.DPt.DPm, c.this.DPt.DIp, (int)paramAnonymousd.field_fileLength, paramAnonymousd.index, ((com.tencent.mm.i.f)localObject2).alN());
                  AppMethodBeat.o(96066);
                  return;
                  c.fcc().remove(c.this.DPt.DIp);
                  break;
                  label511:
                  bd.fF(c.this.DPt.mediaId, c.this.DPt.mediaType);
                  c.this.fca();
                  continue;
                  label553:
                  if ((!c.this.DPt.DPm) && ((c.this.DPt.DPo == 4) || (c.this.DPt.DPo == 6)))
                  {
                    localObject1 = c.this.DPt.getPath() + r.j(c.this.ebR);
                    aj.faL().kf(c.this.DPt.mediaId, (String)localObject1);
                  }
                }
                label671:
                if (1 == c.this.DPt.DPo)
                {
                  localObject1 = aj.faJ();
                  localObject2 = c.this.DPt.mediaId;
                  if (((com.tencent.mm.plugin.sns.model.c)localObject1).DGQ.remove(localObject2))
                  {
                    l = Util.milliSecondsToNow(c.1.this.DPP);
                    Log.d("MicroMsg.SnsCdnDownloadBase", "single download cost: %d.", new Object[] { Long.valueOf(l) });
                    com.tencent.mm.plugin.report.service.h.CyF.n(1040L, 6L, l);
                    com.tencent.mm.plugin.report.service.h.CyF.dN(1040, 7);
                  }
                }
                if (c.this.DPt.DPo == 4) {
                  Log.i("MicroMsg.SnsCdnDownloadBase", "sight download cost=" + Util.milliSecondsToNow(c.1.this.DPP) + ", mediaId=" + c.this.DPt.mediaId);
                }
                c.this.DPr.a(i, c.this.ebR, c.this.DPt.DPo, c.this.DPt.DPm, c.this.DPt.DIp, (int)paramAnonymousd.field_fileLength, -1, true);
                AppMethodBeat.o(96066);
              }
            });
            for (;;)
            {
              if (paramAnonymousInt == 0) {
                break label1203;
              }
              Log.e("MicroMsg.SnsCdnDownloadBase", "task build error! startRet: %d, type: %d.", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(c.this.DPt.DPo) });
              if (9 != c.this.DPt.DPo) {
                break label1203;
              }
              com.tencent.mm.plugin.report.service.h.CyF.dN(1040, 13);
              c.fcc().remove(c.this.DPt.DIp);
              c.this.DPr.a(2, null, c.this.DPt.DPo, c.this.DPt.DPm, c.this.DPt.DIp, -1, -1, true);
              paramAnonymousString = (com.tencent.mm.i.f)this.DPO;
              paramAnonymousc = paramAnonymousString.gqo;
              i = paramAnonymousc.length;
              paramAnonymousInt = 0;
              while (paramAnonymousInt < i)
              {
                j = paramAnonymousc[paramAnonymousInt].picIndex;
                paramAnonymousd = (cnb)c.this.DPt.DEw.get(j);
                localObject = (com.tencent.mm.plugin.sns.data.n)c.this.DPt.DDI.get(j);
                aj.faJ().a(paramAnonymousd, 1, (com.tencent.mm.plugin.sns.data.n)localObject, c.this.DPt.DPp, paramAnonymousString.dRS);
                Log.i("MicroMsg.SnsCdnDownloadBase", "group download err, retry single download. index: %d.", new Object[] { Integer.valueOf(j) });
                paramAnonymousInt += 1;
              }
              com.tencent.mm.plugin.report.service.h.CyF.dN(1040, 14);
              Log.e("MicroMsg.SnsCdnDownloadBase", "download error, totally re-download by single.");
              paramAnonymousString = (com.tencent.mm.i.f)this.DPO;
              paramAnonymousString.cBY = paramAnonymousString.gqw;
              paramAnonymousc = paramAnonymousString.gqo;
              j = paramAnonymousc.length;
              i = 0;
              while (i < j)
              {
                k = paramAnonymousc[i].picIndex;
                localObject = (cnb)c.this.DPt.DEw.get(k);
                localn = (com.tencent.mm.plugin.sns.data.n)c.this.DPt.DDI.get(k);
                aj.faJ().a((cnb)localObject, 1, localn, c.this.DPt.DPp, paramAnonymousString.dRS);
                Log.i("MicroMsg.SnsCdnDownloadBase", "group download err, retry single download. index: %d.", new Object[] { Integer.valueOf(k) });
                i += 1;
              }
              i = 2;
              break;
              Log.d("MicroMsg.SnsCdnDownloadBase", "download succ, type: %d.", new Object[] { Integer.valueOf(c.this.DPt.DPo) });
              c.this.DPM = ((int)paramAnonymousd.field_fileLength);
              if (9 == c.this.DPt.DPo)
              {
                paramAnonymousString = (com.tencent.mm.i.f)this.DPO;
                paramAnonymousString.cBY += 1;
                Log.d("MicroMsg.SnsCdnDownloadBase", "download succ, counter++, res: %d, count: %d.", new Object[] { Integer.valueOf(paramAnonymousString.cBY), Integer.valueOf(paramAnonymousString.gqw) });
              }
              for (paramAnonymousBoolean = c.this.YM(paramAnonymousd.index);; paramAnonymousBoolean = c.this.fbX())
              {
                if (paramAnonymousBoolean) {
                  break label1035;
                }
                i = 2;
                break;
              }
              label1035:
              if (c.this.DPt.DPm)
              {
                i = 3;
                break;
              }
              i = 1;
              break;
              label1060:
              k.c(1, 0, 1, paramAnonymousString.url);
              break label457;
              if (paramAnonymousc != null)
              {
                float f = (float)paramAnonymousc.field_finishedLength / (float)paramAnonymousc.field_toltalLength;
                if (c.this.DPt.DPq < f)
                {
                  c.this.DPt.DPq = f;
                  Log.d("MicroMsg.SnsCdnDownloadBase", "Download sns image type: %d, mediaId: %s, progress: %f, url: %s", new Object[] { Integer.valueOf(c.this.DPt.DPo), paramAnonymousString, Float.valueOf(f), c.this.DPt.url });
                }
              }
            }
            label1203:
            AppMethodBeat.o(96067);
            return 0;
            label1210:
            i = 2;
          }
        }
        
        public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
        
        public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
        {
          return new byte[0];
        }
      };
      if (com.tencent.mm.an.f.baQ().b((com.tencent.mm.i.g)localObject2, -1)) {
        Log.i("MicroMsg.SnsCdnDownloadBase", "SubCoreCdnTransport addRecvTask suc");
      }
    }
    for (int i = 1;; i = 2)
    {
      return Integer.valueOf(i);
      label1075:
      s.boN(this.DPt.getPath());
      localObject2 = new com.tencent.mm.i.e();
      ((com.tencent.mm.i.e)localObject2).taskName = "task_SnsCdnDownloadBase_2";
      break;
      Log.w("MicroMsg.SnsCdnDownloadBase", "SubCoreCdnTransport addRecvTask failed");
    }
  }
  
  public void fca()
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
      label133:
      localObject1 = null;
      if (this.DPt.DDH.DEs != 0) {
        break label597;
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
        break label133;
      }
      if (this.DPt.DDH.list.size() <= 1)
      {
        aj.faL().a(this.DPt.mediaId, this.DPs, this.DPt.DDH.DEs);
        break label133;
      }
      aj.faL().a(this.DPt.mediaId, this.DPs, 0);
      localObject1 = new LinkedList();
      int i = 0;
      for (;;)
      {
        if ((i >= this.DPt.DDH.list.size()) || (i >= 4)) {
          break label504;
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
      label504:
      this.DPs = com.tencent.mm.memory.n.H(r.z((List)localObject1, aj.fbb()));
      Log.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap " + this.DPt.DDH.dPI + " " + this.DPs);
      aj.faL().a(this.DPt.DDH.dPI, this.DPs, this.DPt.DDH.DEs);
      break label133;
      label597:
      if (this.DPt.DDH.DEs == 1) {
        localObject1 = "1-" + this.DPt.DDH.dPI;
      } else if (this.DPt.DDH.DEs == 4) {
        localObject1 = "4-" + this.DPt.DDH.dPI;
      } else if (this.DPt.DDH.DEs == 5) {
        localObject1 = "5-" + this.DPt.DDH.dPI;
      } else if (this.DPt.DDH.DEs == 3) {
        localObject1 = r.cq(3, this.DPt.DDH.dPI);
      }
    }
  }
  
  public final void fcb()
  {
    if (this.DPt != null) {
      Log.i("MicroMsg.SnsCdnDownloadBase", "checkCdnPath: %s", new Object[] { Boolean.valueOf(s.boN(this.DPt.getPath())) });
    }
  }
  
  protected abstract int getMediaType();
  
  public void onPostExecute(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, cnb paramcnb, int paramInt2, boolean paramBoolean1, String paramString, int paramInt3, int paramInt4, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.c
 * JD-Core Version:    0.7.0.1
 */