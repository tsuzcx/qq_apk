package com.tencent.mm.plugin.sns.model.a;

import android.util.SparseArray;
import com.tencent.mars.cdn.CdnLogic.BatchSnsReqImageData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.e;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.bc;
import com.tencent.mm.plugin.sns.model.c.c;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.bp;
import com.tencent.mm.vfs.u;
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
  extends r<String, Integer, Integer>
{
  private static HashSet<String> KcR = new HashSet();
  protected a KcA = null;
  int KcT = 0;
  protected SparseArray<com.tencent.mm.memory.n> KcU = new SparseArray();
  protected a Kcy;
  protected com.tencent.mm.memory.n Kcz = null;
  private long dnsCostTime = -1L;
  protected cvt fVT = null;
  private String host = "";
  private int muo = -1;
  
  public c(a parama, a parama1)
  {
    this.Kcy = parama;
    this.KcA = parama1;
    if (parama1 == null) {
      return;
    }
    this.fVT = parama1.JVq;
    KcR.add(parama1.JVp);
    parama1.init();
  }
  
  private boolean a(e parame, boolean paramBoolean, String paramString)
  {
    for (;;)
    {
      try
      {
        this.host = new URL(this.KcA.url).getHost();
        ArrayList localArrayList1 = new ArrayList();
        this.muo = com.tencent.mm.network.d.a(this.host, false, localArrayList1);
        ArrayList localArrayList2 = new ArrayList();
        int j = com.tencent.mm.network.d.a(this.host, true, localArrayList2);
        Object localObject;
        if (9 == this.KcA.Kcv)
        {
          parame.field_mediaId = (this.KcA.fLp + "_" + this.KcA.Kcv);
          if ((parame instanceof com.tencent.mm.i.f))
          {
            com.tencent.mm.i.f localf = (com.tencent.mm.i.f)parame;
            localf.fLp = this.KcA.fLp;
            localf.iUD = this.KcA.size;
            localf.iUE = this.KcA.JRr.size();
            localf.iUw = new CdnLogic.BatchSnsReqImageData[localf.iUE];
            int i = 0;
            if (i < localf.iUE)
            {
              int k = this.KcA.JRr.keyAt(i);
              cvt localcvt = (cvt)this.KcA.JRr.get(k);
              CdnLogic.BatchSnsReqImageData localBatchSnsReqImageData = new CdnLogic.BatchSnsReqImageData();
              String str = localcvt.TDF;
              localObject = str;
              if (Util.isNullOrNil(str))
              {
                localObject = str;
                if (localcvt.rWu == 2) {
                  localObject = localcvt.Url;
                }
              }
              localBatchSnsReqImageData.url = b((String)localObject, localcvt);
              localBatchSnsReqImageData.picIndex = k;
              localBatchSnsReqImageData.totalFileSize = 0;
              localBatchSnsReqImageData.decryptKey = localcvt.TDX;
              localObject = new StringBuilder();
              str = localcvt.Id;
              localBatchSnsReqImageData.imageCachePath = u.n(aq.kD(aj.getAccSnsPath(), str) + t.m(localcvt), false);
              localBatchSnsReqImageData.fileKey = (localcvt.Id + "_" + this.KcA.Kcv);
              localf.iUw[i] = localBatchSnsReqImageData;
              i += 1;
              continue;
            }
          }
        }
        else
        {
          parame.field_mediaId = (this.KcA.mediaId + "_" + this.KcA.Kcv);
          parame.iUy = (this.KcA.getPath() + this.KcA.fPO());
          if (this.KcA.JVq != null)
          {
            if (!this.KcA.Kct) {
              continue;
            }
            localObject = this.KcA.JVq.TDX;
            parame.snsCipherKey = ((String)localObject);
          }
        }
        parame.url = this.KcA.url;
        parame.host = this.host;
        parame.referer = paramString;
        parame.iUz = ey(localArrayList1);
        parame.iUA = ey(localArrayList2);
        parame.iUB = this.muo;
        parame.iUC = j;
        parame.isColdSnsData = paramBoolean;
        parame.signalQuality = ConnectivityCompat.Companion.getCompatMixStrength();
        parame.snsScene = this.KcA.Kcw.tag;
        if (this.KcA.Kcv == 8)
        {
          parame.hDp = 3;
          parame.appType = 109;
          parame.fileType = 20204;
          Log.i("MicroMsg.SnsCdnDownloadBase", "attachSnsImgTaskInfo reqDownType:%d taskInfo:%s", new Object[] { Integer.valueOf(this.KcA.Kcv), parame });
          return true;
          localObject = this.KcA.JVq.TDU;
          continue;
        }
        if ((this.KcA.Kcv == 6) || (this.KcA.Kcv == 4))
        {
          parame.hDp = 3;
          parame.appType = 105;
          parame.fileType = 20210;
          continue;
        }
        if (this.KcA.Kcv != 5) {
          break label810;
        }
      }
      catch (MalformedURLException parame)
      {
        Log.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", parame, "", new Object[0]);
        Log.w("MicroMsg.SnsCdnDownloadBase", "attachSnsImgTaskInfo fail:".concat(String.valueOf(parame)));
        return false;
      }
      parame.hDp = 3;
      parame.appType = 150;
      parame.fileType = 20250;
      continue;
      label810:
      if ((this.KcA.Kcv == 2) || (this.KcA.Kcv == 1) || (this.KcA.Kcv == 3) || (this.KcA.Kcv == 9))
      {
        parame.hDp = 3;
        parame.appType = 100;
        parame.fileType = 20201;
        if ((this.KcA.Kcv == 1) && ((this.KcA.url.startsWith("http://wxapp.tc.qq.com")) || (this.KcA.url.startsWith("https://wxapp.tc.qq.com"))) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vNe, 1) == 1))
        {
          parame.hDp = 3;
          parame.appType = 150;
          parame.fileType = 20201;
        }
      }
    }
  }
  
  public static boolean baG(String paramString)
  {
    if (KcR.contains(t.cr(1, paramString))) {}
    while (KcR.contains(t.cr(5, paramString))) {
      return true;
    }
    return false;
  }
  
  private static String[] ey(List<String> paramList)
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
  
  public boolean a(bp parambp, String paramString1, long paramLong, String paramString2)
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
  
  public boolean agd(int paramInt)
  {
    return false;
  }
  
  public final void age(int paramInt)
  {
    if (aj.isInValid()) {
      return;
    }
    Object localObject = (com.tencent.mm.plugin.sns.data.p)this.KcA.JQn.get(paramInt);
    cvt localcvt = (cvt)this.KcA.JRr.get(paramInt);
    Log.i("MicroMsg.SnsCdnDownloadBase", "thumbAddDecode index: %d decodeType: %d.", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((com.tencent.mm.plugin.sns.data.p)localObject).JRn) });
    aj.fOF().a(localcvt.Id, (com.tencent.mm.memory.n)this.KcU.get(paramInt), ((com.tencent.mm.plugin.sns.data.p)localObject).JRn);
    if (((com.tencent.mm.plugin.sns.data.p)localObject).JRn == 0) {}
    for (localObject = t.cq(0, ((com.tencent.mm.plugin.sns.data.p)localObject).fIY);; localObject = null)
    {
      Log.i("MicroMsg.SnsCdnDownloadBase", "thumbAddDecode cacheName: %s.", new Object[] { localObject });
      aj.fOF().aZT((String)localObject);
      return;
    }
  }
  
  public String b(String paramString, cvt paramcvt)
  {
    return paramString;
  }
  
  public String baE(String paramString)
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
      localObject2 = com.tencent.mm.model.c.d.bgB().Mu((String)localObject1);
      if (((com.tencent.mm.storage.c)localObject2).isValid())
      {
        i = Util.getInt((String)((com.tencent.mm.storage.c)localObject2).hvz().get("needUploadData"), 1);
        str = ((com.tencent.mm.storage.c)localObject2).field_expId;
      }
      break;
    }
    while (i != 0)
    {
      if (this.KcA.Kcv == 8) {
        i = 1;
      }
      for (;;)
      {
        label110:
        localObject2 = new com.tencent.mm.modelsns.n();
        ((com.tencent.mm.modelsns.n)localObject2).m("20ImgSize", paramd.field_fileLength + ",");
        StringBuilder localStringBuilder = new StringBuilder();
        int j;
        if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
        {
          j = 1;
          label170:
          ((com.tencent.mm.modelsns.n)localObject2).m("21NetType", j + ",");
          ((com.tencent.mm.modelsns.n)localObject2).m("22DelayTime", paramd.field_delayTime + ",");
          ((com.tencent.mm.modelsns.n)localObject2).m("23RetCode", paramd.field_retCode + ",");
          ((com.tencent.mm.modelsns.n)localObject2).m("24DnsCostTime", paramd.field_dnsCostTime + ",");
          ((com.tencent.mm.modelsns.n)localObject2).m("25ConnectCostTime", paramd.field_connectCostTime + ",");
          ((com.tencent.mm.modelsns.n)localObject2).m("26SendCostTime", ",");
          ((com.tencent.mm.modelsns.n)localObject2).m("27WaitResponseCostTime", paramd.field_waitResponseCostTime + ",");
          ((com.tencent.mm.modelsns.n)localObject2).m("28ReceiveCostTime", paramd.field_receiveCostTime + ",");
          ((com.tencent.mm.modelsns.n)localObject2).m("29ClientAddrIP(uint)", paramd.field_clientHostIP + ",");
          ((com.tencent.mm.modelsns.n)localObject2).m("30ServerAddrIP(uint)", paramd.field_serverHostIP + ",");
          ((com.tencent.mm.modelsns.n)localObject2).m("31dnstype", this.muo + ",");
          ((com.tencent.mm.modelsns.n)localObject2).m("32signal(int)", ConnectivityCompat.Companion.getCompatMixStrength() + ",");
          ((com.tencent.mm.modelsns.n)localObject2).m("33host(string)", this.host + ",");
          ((com.tencent.mm.modelsns.n)localObject2).m("34MediaType", k + ",");
          ((com.tencent.mm.modelsns.n)localObject2).m("35X_Errno(string)", paramd.field_xErrorNo + ",");
          ((com.tencent.mm.modelsns.n)localObject2).m("36MaxPackageSize", ",");
          ((com.tencent.mm.modelsns.n)localObject2).m("37MaxPackageTimeStamp", ",");
          ((com.tencent.mm.modelsns.n)localObject2).m("38PackageRecordList", ",");
          ((com.tencent.mm.modelsns.n)localObject2).m("39ExpLayerId", (String)localObject1 + ",");
          ((com.tencent.mm.modelsns.n)localObject2).m("40ExpId", str + ",");
          ((com.tencent.mm.modelsns.n)localObject2).m("41FeedId", ",");
          ((com.tencent.mm.modelsns.n)localObject2).m("42BizType", i + ",");
          ((com.tencent.mm.modelsns.n)localObject2).m("43CSeqCheck(uint)", paramd.field_cSeqCheck + ",");
          localObject1 = new StringBuilder();
          if (!paramd.field_usePrivateProtocol) {
            break label993;
          }
        }
        label993:
        for (i = 1;; i = 0)
        {
          ((com.tencent.mm.modelsns.n)localObject2).m("44isPrivate(uint)", i + ",");
          Log.i("MicroMsg.SnsCdnDownloadBase", "report logbuffer(13480 TLMediaFielDownloadRecord): " + ((com.tencent.mm.modelsns.n)localObject2).agI());
          com.tencent.mm.plugin.report.service.h.IzE.a(13480, new Object[] { localObject2 });
          if ((paramd.field_retCode == 200) || (paramd.field_retCode == 0)) {
            break;
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(14071, new Object[] { localObject2 });
          return;
          localObject1 = "100106";
          break label46;
          localObject1 = "100100";
          break label46;
          if ((this.KcA.Kcv == 6) || (this.KcA.Kcv == 4))
          {
            i = 2;
            break label110;
          }
          if (this.KcA.Kcv == 5)
          {
            i = 4;
            break label110;
          }
          if ((this.KcA.Kcv != 2) && (this.KcA.Kcv != 1) && (this.KcA.Kcv != 3)) {
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
  
  public boolean fPP()
  {
    return true;
  }
  
  public abstract boolean fPQ();
  
  public Integer fPS()
  {
    com.tencent.mm.kernel.h.aHH();
    if ((!com.tencent.mm.kernel.h.aHG().isSDCardAvailable()) || (this.KcA == null)) {
      return Integer.valueOf(2);
    }
    Object localObject1;
    Object localObject3;
    Object localObject4;
    if (fPP())
    {
      if (9 == this.KcA.Kcv)
      {
        i = 0;
        while (i < this.KcA.JRr.size())
        {
          localObject1 = (cvt)this.KcA.JRr.valueAt(i);
          localObject3 = new StringBuilder();
          localObject4 = ((cvt)localObject1).Id;
          localObject1 = aq.kD(aj.getAccSnsPath(), (String)localObject4) + t.m((cvt)localObject1);
          Log.i("MicroMsg.SnsCdnDownloadBase", "pennqin, delete sns thumb: [%s].", new Object[] { localObject1 });
          u.deleteFile((String)localObject1);
          i += 1;
        }
      }
      localObject1 = this.KcA.JVl + this.KcA.fPO();
      Log.i("MicroMsg.SnsCdnDownloadBase", "[tomys] delete img: %s", new Object[] { localObject1 });
      u.deleteFile((String)localObject1);
    }
    final long l3 = System.currentTimeMillis();
    String str;
    boolean bool;
    for (;;)
    {
      try
      {
        localObject1 = aj.fOD();
        localObject3 = this.KcA.mediaId;
        if (Util.isNullOrNil((String)localObject3)) {
          continue;
        }
        localObject1 = (c.c)((com.tencent.mm.plugin.sns.model.c)localObject1).JTO.get(localObject3);
        if ((localObject1 != null) && (!((c.c)localObject1).JTT)) {
          ((c.c)localObject1).setStartTime(l3);
        }
      }
      catch (Exception localException)
      {
        long l2;
        long l1;
        Log.e("MicroMsg.SnsCdnDownloadBase", "exception msg: %s.", new Object[] { localException.getMessage() });
        continue;
        if (!((bp)localObject4).equals(bp.VGi)) {
          continue;
        }
        localObject2 = "album_friend";
        continue;
        if (!((bp)localObject4).equals(bp.VGj)) {
          continue;
        }
        localObject2 = "album_self";
        continue;
        if (!((bp)localObject4).equals(bp.VGk)) {
          continue;
        }
        localObject2 = "album_stranger";
        continue;
        if (!((bp)localObject4).equals(bp.VGl)) {
          continue;
        }
        localObject2 = "profile_friend";
        continue;
        if (!((bp)localObject4).equals(bp.VGm)) {
          continue;
        }
        localObject2 = "profile_stranger";
        continue;
        if (!((bp)localObject4).equals(bp.VGn)) {
          continue;
        }
        localObject2 = "comment";
        continue;
        if (!((bp)localObject4).equals(bp.VGh)) {
          continue;
        }
        localObject2 = "timeline";
        continue;
        this.KcA.url = baE(this.KcA.url);
        continue;
        localObject2 = "SnsAlbumDomainList";
        continue;
        localObject3 = "SnsAlbumMainStandbyIpSwitchTime";
        continue;
      }
      i = 0;
      if (this.KcA.JRr != null) {
        i = this.KcA.JRr.size();
      }
      Log.i("MicroMsg.SnsCdnDownloadBase", "to downloadBitmap pack.mediaId: " + this.KcA.mediaId + " pack.mediaObjs.size: " + i + " pack.snsId: " + this.KcA.fLp + " pack.isthumb: " + this.KcA.Kct + " type: " + this.KcA.Kcv);
      localObject4 = this.KcA.Kcw;
      localObject1 = "";
      if (localObject4 != null) {
        continue;
      }
      localObject1 = "";
      localObject3 = localObject1;
      if (!Util.isNullOrNil((String)localObject1)) {
        localObject3 = "&scene=".concat(String.valueOf(localObject1));
      }
      str = String.format("https://" + WeChatHosts.domainString(i.j.host_weixin_qq_com) + "/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.RAD), com.tencent.mm.b.p.getString(aj.fOp()), Integer.valueOf(NetStatusUtil.getNetTypeForStat(MMApplicationContext.getContext())), Integer.valueOf(ConnectivityCompat.Companion.getCompatMixStrength()), localObject3 });
      if (9 != this.KcA.Kcv) {
        continue;
      }
      this.KcA.url = b(this.KcA.url, (cvt)this.KcA.JRr.get(0));
      this.dnsCostTime = Util.nowMilliSecond();
      if (!this.KcA.Kcu) {
        continue;
      }
      localObject1 = "SnsSightDomainList";
      if (!this.KcA.Kcu) {
        continue;
      }
      localObject3 = "SnsSightMainStandbyIpSwitchTime";
      localObject1 = com.tencent.mm.n.h.axc().getValue((String)localObject1);
      l2 = com.tencent.mm.n.h.axc().getInt((String)localObject3, 0);
      Log.i("MicroMsg.SnsCdnDownloadBase", "pack.isAlbum %s pack.isthumb %s hostvalue %s dcipTime %s", new Object[] { Boolean.valueOf(this.KcA.Kcu), Boolean.valueOf(this.KcA.Kct), localObject1, Long.valueOf(l2) });
      l1 = l2;
      if (l2 <= 0L) {
        l1 = 259200L;
      }
      bool = a((bp)localObject4, this.KcA.url, l1, (String)localObject1);
      this.dnsCostTime = Util.milliSecondsToNow(this.dnsCostTime);
      if (9 != this.KcA.Kcv) {
        break label1087;
      }
      localObject1 = new com.tencent.mm.i.f();
      ((e)localObject1).taskName = "task_SnsCdnDownloadBase_1";
      i = 0;
      if (i >= this.KcA.JRr.size()) {
        break label991;
      }
      localObject3 = ((cvt)this.KcA.JRr.valueAt(i)).Id;
      u.bBD(aq.kD(aj.getAccSnsPath(), (String)localObject3));
      i += 1;
      continue;
      localObject1 = null;
    }
    Object localObject2;
    label991:
    if (a((e)localObject2, bool, str))
    {
      if ((this.KcA != null) && (this.KcA.Kcu)) {
        com.tencent.mm.plugin.sns.ad.d.d.a((e)localObject2, this.fVT);
      }
      ((e)localObject2).iUG = new g.a()
      {
        public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(96067);
          if (c.this.KcA == null)
          {
            Log.e("MicroMsg.SnsCdnDownloadBase", "pack is null.");
            AppMethodBeat.o(96067);
            return 0;
          }
          Object localObject;
          int j;
          final int i;
          cvt localcvt;
          int k;
          com.tencent.mm.plugin.sns.data.p localp;
          if (paramAnonymousd != null)
          {
            Log.i("MicroMsg.SnsCdnDownloadBase", "download callback mediaId:%s, startRet:%s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt) });
            if (paramAnonymousd.field_retCode != 0)
            {
              Log.e("MicroMsg.SnsCdnDownloadBase", "download err, retCode: %d reqDownType: %d.", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(c.this.KcA.Kcv) });
              com.tencent.mm.network.d.reportFailIp(paramAnonymousd.field_serverIP);
              if (9 != c.this.KcA.Kcv) {
                break label1289;
              }
              paramAnonymousc = paramAnonymousd.iUw;
              if ((paramAnonymousc != null) && (paramAnonymousc.length > 0))
              {
                com.tencent.mm.plugin.report.service.h.IzE.el(1040, 12);
                localObject = (com.tencent.mm.i.f)this.KcV;
                Log.e("MicroMsg.SnsCdnDownloadBase", "download err, taskInfo2 need inc counter, before: %d, inc: %d, count: %d.", new Object[] { Integer.valueOf(((com.tencent.mm.i.f)localObject).cCC), Integer.valueOf(paramAnonymousc.length), Integer.valueOf(((com.tencent.mm.i.f)localObject).iUE) });
                ((com.tencent.mm.i.f)localObject).cCC += paramAnonymousc.length;
                j = paramAnonymousc.length;
                i = 0;
                while (i < j)
                {
                  localcvt = paramAnonymousc[i];
                  if (localcvt.retry)
                  {
                    k = localcvt.picIndex;
                    localcvt = (cvt)c.this.KcA.JRr.get(k);
                    localp = (com.tencent.mm.plugin.sns.data.p)c.this.KcA.JQn.get(k);
                    aj.fOD().a(localcvt, 1, localp, c.this.KcA.Kcw, ((com.tencent.mm.i.f)localObject).fLp);
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
            paramAnonymousc = c.this.KcA;
            if (paramAnonymousc != null) {}
            try
            {
              if ((paramAnonymousc.JVq != null) && (paramAnonymousc.JVq.isAd))
              {
                j = m.aYW(paramAnonymousc.JVp);
                Log.i("SnsAdUtil", "reportAdPicCDNDownload, result=" + paramAnonymousd.field_retCode + ", requestKey=" + paramAnonymousc.JVp + ", reqDownType=" + paramAnonymousc.Kcv + ", url=" + paramAnonymousc.url);
                if ((j == 1) || (j == 5))
                {
                  if (paramAnonymousd.field_retCode != 0) {
                    break label1139;
                  }
                  m.b(0, 0, 1, paramAnonymousc.url);
                }
              }
            }
            catch (Throwable paramAnonymousc)
            {
              for (;;)
              {
                label485:
                Log.e("SnsAdUtil", "reportAdPicCDNDownload, exp=" + paramAnonymousc.toString());
              }
            }
            Log.i("MicroMsg.SnsCdnDownloadBase", "download succ start post to ui thread process, type: %d, mediaId:%s %s", new Object[] { Integer.valueOf(c.this.KcA.Kcv), paramAnonymousString, c.this.KcA.mediaId });
            aj.etE().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96066);
                if (9 == c.this.KcA.Kcv)
                {
                  if (((com.tencent.mm.i.f)c.1.this.KcV).arM()) {
                    c.fPV().remove(c.this.KcA.JVp);
                  }
                  Log.i("MicroMsg.SnsCdnDownloadBase", "download done result: %d, url:%s, mediaID:%s, totalSize: %d, runningTasksSize: %d", new Object[] { Integer.valueOf(i), c.this.KcA.url, c.this.KcA.mediaId, Long.valueOf(paramAnonymousd.field_fileLength), Integer.valueOf(c.fPV().size()) });
                  if ((!c.this.KcA.Kct) || (i == 2)) {
                    break label553;
                  }
                  if (9 != c.this.KcA.Kcv) {
                    break label511;
                  }
                  bc.gi(((cvt)c.this.KcA.JRr.get(paramAnonymousd.index)).Id, c.this.KcA.mediaType);
                  c.this.age(paramAnonymousd.index);
                }
                Object localObject1;
                Object localObject2;
                long l;
                for (;;)
                {
                  if (9 != c.this.KcA.Kcv) {
                    break label671;
                  }
                  localObject1 = (cvt)c.this.KcA.JRr.get(paramAnonymousd.index);
                  localObject2 = (com.tencent.mm.i.f)c.1.this.KcV;
                  if ((((com.tencent.mm.i.f)localObject2).arM()) && (!((com.tencent.mm.i.f)localObject2).iUF))
                  {
                    ((com.tencent.mm.i.f)localObject2).iUF = true;
                    l = Util.milliSecondsToNow(c.1.this.KcW);
                    Log.d("MicroMsg.SnsCdnDownloadBase", "group download, feed cost: %d.", new Object[] { Long.valueOf(l) });
                    com.tencent.mm.plugin.report.service.h.IzE.p(1040L, 3L, l);
                    com.tencent.mm.plugin.report.service.h.IzE.el(1040, 4);
                    com.tencent.mm.plugin.report.service.h.IzE.p(1040L, 9L, l);
                    com.tencent.mm.plugin.report.service.h.IzE.p(1040L, 10L, ((com.tencent.mm.i.f)localObject2).iUE);
                  }
                  c.this.Kcy.a(i, (cvt)localObject1, c.this.KcA.Kcv, c.this.KcA.Kct, c.this.KcA.JVp, (int)paramAnonymousd.field_fileLength, paramAnonymousd.index, ((com.tencent.mm.i.f)localObject2).arM());
                  AppMethodBeat.o(96066);
                  return;
                  c.fPV().remove(c.this.KcA.JVp);
                  break;
                  label511:
                  bc.gi(c.this.KcA.mediaId, c.this.KcA.mediaType);
                  c.this.fPT();
                  continue;
                  label553:
                  if ((!c.this.KcA.Kct) && ((c.this.KcA.Kcv == 4) || (c.this.KcA.Kcv == 6)))
                  {
                    localObject1 = c.this.KcA.getPath() + t.i(c.this.fVT);
                    aj.fOF().kA(c.this.KcA.mediaId, (String)localObject1);
                  }
                }
                label671:
                if (1 == c.this.KcA.Kcv)
                {
                  localObject1 = aj.fOD();
                  localObject2 = c.this.KcA.mediaId;
                  if (((com.tencent.mm.plugin.sns.model.c)localObject1).JTP.remove(localObject2))
                  {
                    l = Util.milliSecondsToNow(c.1.this.KcW);
                    Log.d("MicroMsg.SnsCdnDownloadBase", "single download cost: %d.", new Object[] { Long.valueOf(l) });
                    com.tencent.mm.plugin.report.service.h.IzE.p(1040L, 6L, l);
                    com.tencent.mm.plugin.report.service.h.IzE.el(1040, 7);
                  }
                }
                if (c.this.KcA.Kcv == 4) {
                  Log.i("MicroMsg.SnsCdnDownloadBase", "sight download cost=" + Util.milliSecondsToNow(c.1.this.KcW) + ", mediaId=" + c.this.KcA.mediaId);
                }
                c.this.Kcy.a(i, c.this.fVT, c.this.KcA.Kcv, c.this.KcA.Kct, c.this.KcA.JVp, (int)paramAnonymousd.field_fileLength, -1, true);
                AppMethodBeat.o(96066);
              }
            });
            for (;;)
            {
              if (paramAnonymousInt == 0) {
                break label1282;
              }
              Log.e("MicroMsg.SnsCdnDownloadBase", "task build error! startRet: %d, type: %d.", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(c.this.KcA.Kcv) });
              if (9 != c.this.KcA.Kcv) {
                break label1282;
              }
              com.tencent.mm.plugin.report.service.h.IzE.el(1040, 13);
              c.fPV().remove(c.this.KcA.JVp);
              c.this.Kcy.a(2, null, c.this.KcA.Kcv, c.this.KcA.Kct, c.this.KcA.JVp, -1, -1, true);
              paramAnonymousString = (com.tencent.mm.i.f)this.KcV;
              paramAnonymousc = paramAnonymousString.iUw;
              i = paramAnonymousc.length;
              paramAnonymousInt = 0;
              while (paramAnonymousInt < i)
              {
                j = paramAnonymousc[paramAnonymousInt].picIndex;
                paramAnonymousd = (cvt)c.this.KcA.JRr.get(j);
                localObject = (com.tencent.mm.plugin.sns.data.p)c.this.KcA.JQn.get(j);
                aj.fOD().a(paramAnonymousd, 1, (com.tencent.mm.plugin.sns.data.p)localObject, c.this.KcA.Kcw, paramAnonymousString.fLp);
                Log.i("MicroMsg.SnsCdnDownloadBase", "group download err, retry single download. index: %d.", new Object[] { Integer.valueOf(j) });
                paramAnonymousInt += 1;
              }
              com.tencent.mm.plugin.report.service.h.IzE.el(1040, 14);
              Log.e("MicroMsg.SnsCdnDownloadBase", "download error, totally re-download by single.");
              paramAnonymousc = (com.tencent.mm.i.f)this.KcV;
              paramAnonymousc.cCC = paramAnonymousc.iUE;
              localObject = paramAnonymousc.iUw;
              j = localObject.length;
              i = 0;
              while (i < j)
              {
                k = localObject[i].picIndex;
                localcvt = (cvt)c.this.KcA.JRr.get(k);
                localp = (com.tencent.mm.plugin.sns.data.p)c.this.KcA.JQn.get(k);
                aj.fOD().a(localcvt, 1, localp, c.this.KcA.Kcw, paramAnonymousc.fLp);
                Log.i("MicroMsg.SnsCdnDownloadBase", "group download err, retry single download. index: %d.", new Object[] { Integer.valueOf(k) });
                i += 1;
              }
              i = 2;
              break;
              Log.i("MicroMsg.SnsCdnDownloadBase", "download succ, type: %d, mediaId:%s", new Object[] { Integer.valueOf(c.this.KcA.Kcv), paramAnonymousString });
              c.this.KcT = ((int)paramAnonymousd.field_fileLength);
              if (9 == c.this.KcA.Kcv)
              {
                paramAnonymousc = (com.tencent.mm.i.f)this.KcV;
                paramAnonymousc.cCC += 1;
                Log.d("MicroMsg.SnsCdnDownloadBase", "download succ, counter++, res: %d, count: %d.", new Object[] { Integer.valueOf(paramAnonymousc.cCC), Integer.valueOf(paramAnonymousc.iUE) });
              }
              for (paramAnonymousBoolean = c.this.agd(paramAnonymousd.index);; paramAnonymousBoolean = c.this.fPQ())
              {
                if (paramAnonymousBoolean) {
                  break label1114;
                }
                i = 2;
                break;
              }
              label1114:
              if (c.this.KcA.Kct)
              {
                i = 3;
                break;
              }
              i = 1;
              break;
              label1139:
              m.b(1, 0, 1, paramAnonymousc.url);
              break label485;
              if (paramAnonymousc != null)
              {
                float f = (float)paramAnonymousc.field_finishedLength / (float)paramAnonymousc.field_toltalLength;
                if (c.this.KcA.Kcx < f)
                {
                  c.this.KcA.Kcx = f;
                  Log.d("MicroMsg.SnsCdnDownloadBase", "Download sns image type: %d, mediaId: %s, progress: %f, url: %s", new Object[] { Integer.valueOf(c.this.KcA.Kcv), paramAnonymousString, Float.valueOf(f), c.this.KcA.url });
                }
              }
            }
            label1282:
            AppMethodBeat.o(96067);
            return 0;
            label1289:
            i = 2;
          }
        }
        
        public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
        
        public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
        {
          return new byte[0];
        }
      };
      if (com.tencent.mm.aq.f.bkg().b((com.tencent.mm.i.g)localObject2, -1)) {
        Log.i("MicroMsg.SnsCdnDownloadBase", "SubCoreCdnTransport addRecvTask succ mediaId:%s", new Object[] { ((e)localObject2).field_mediaId });
      }
    }
    for (int i = 1;; i = 2)
    {
      return Integer.valueOf(i);
      label1087:
      u.bBD(this.KcA.getPath());
      localObject2 = new e();
      ((e)localObject2).taskName = "task_SnsCdnDownloadBase_2";
      break;
      Log.w("MicroMsg.SnsCdnDownloadBase", "SubCoreCdnTransport addRecvTask failed mediaId:%s", new Object[] { ((e)localObject2).field_mediaId });
    }
  }
  
  public void fPT()
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
      label133:
      localObject1 = null;
      if (this.KcA.JQm.JRn != 0) {
        break label597;
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
        break label133;
      }
      if (this.KcA.JQm.list.size() <= 1)
      {
        aj.fOF().a(this.KcA.mediaId, this.Kcz, this.KcA.JQm.JRn);
        break label133;
      }
      aj.fOF().a(this.KcA.mediaId, this.Kcz, 0);
      localObject1 = new LinkedList();
      int i = 0;
      for (;;)
      {
        if ((i >= this.KcA.JQm.list.size()) || (i >= 4)) {
          break label504;
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
      label504:
      this.Kcz = com.tencent.mm.memory.n.F(t.A((List)localObject1, aj.fOV()));
      Log.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap " + this.KcA.JQm.fIY + " " + this.Kcz);
      aj.fOF().a(this.KcA.JQm.fIY, this.Kcz, this.KcA.JQm.JRn);
      break label133;
      label597:
      if (this.KcA.JQm.JRn == 1) {
        localObject1 = "1-" + this.KcA.JQm.fIY;
      } else if (this.KcA.JQm.JRn == 4) {
        localObject1 = "4-" + this.KcA.JQm.fIY;
      } else if (this.KcA.JQm.JRn == 5) {
        localObject1 = "5-" + this.KcA.JQm.fIY;
      } else if (this.KcA.JQm.JRn == 3) {
        localObject1 = t.cq(3, this.KcA.JQm.fIY);
      }
    }
  }
  
  public final void fPU()
  {
    if (this.KcA != null) {
      Log.i("MicroMsg.SnsCdnDownloadBase", "checkCdnPath: %s", new Object[] { Boolean.valueOf(u.bBD(this.KcA.getPath())) });
    }
  }
  
  public ExecutorService fsl()
  {
    return aj.fOs();
  }
  
  protected abstract int getMediaType();
  
  public void onPostExecute(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, cvt paramcvt, int paramInt2, boolean paramBoolean1, String paramString, int paramInt3, int paramInt4, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.c
 * JD-Core Version:    0.7.0.1
 */