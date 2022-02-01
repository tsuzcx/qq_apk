package com.tencent.mm.plugin.sns.model.a;

import android.util.SparseArray;
import com.tencent.mars.cdn.CdnLogic.BatchSnsReqImageData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.bb;
import com.tencent.mm.plugin.sns.model.c.c;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bk;
import com.tencent.mm.vfs.o;
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
  extends m<String, Integer, Integer>
{
  private static HashSet<String> zFK = new HashSet();
  protected bzh dKe = null;
  private long dnsCostTime = -1L;
  private String host = "";
  private int iHs = -1;
  int zFM = 0;
  protected SparseArray<com.tencent.mm.memory.n> zFN = new SparseArray();
  protected a zFr;
  protected com.tencent.mm.memory.n zFs = null;
  protected a zFt = null;
  
  public c(a parama, a parama1)
  {
    this.zFr = parama;
    this.zFt = parama1;
    if (parama1 == null) {
      return;
    }
    this.dKe = parama1.zyh;
    zFK.add(parama1.zyg);
    parama1.init();
  }
  
  private boolean a(com.tencent.mm.i.e parame, boolean paramBoolean, String paramString)
  {
    for (;;)
    {
      try
      {
        this.host = new URL(this.zFt.url).getHost();
        ArrayList localArrayList1 = new ArrayList();
        this.iHs = com.tencent.mm.network.b.a(this.host, false, localArrayList1);
        ArrayList localArrayList2 = new ArrayList();
        int j = com.tencent.mm.network.b.a(this.host, true, localArrayList2);
        Object localObject;
        if (9 == this.zFt.zFo)
        {
          parame.field_mediaId = (this.zFt.dAg + "_" + this.zFt.zFo);
          if ((parame instanceof com.tencent.mm.i.f))
          {
            com.tencent.mm.i.f localf = (com.tencent.mm.i.f)parame;
            localf.dAg = this.zFt.dAg;
            localf.fLi = this.zFt.size;
            localf.fLj = this.zFt.zum.size();
            localf.fLb = new CdnLogic.BatchSnsReqImageData[localf.fLj];
            int i = 0;
            if (i < localf.fLj)
            {
              int k = this.zFt.zum.keyAt(i);
              bzh localbzh = (bzh)this.zFt.zum.get(k);
              CdnLogic.BatchSnsReqImageData localBatchSnsReqImageData = new CdnLogic.BatchSnsReqImageData();
              String str = localbzh.Hmj;
              localObject = str;
              if (bu.isNullOrNil(str))
              {
                localObject = str;
                if (localbzh.nJA == 2) {
                  localObject = localbzh.Url;
                }
              }
              localBatchSnsReqImageData.url = b((String)localObject, localbzh);
              localBatchSnsReqImageData.picIndex = k;
              localBatchSnsReqImageData.totalFileSize = 0;
              localBatchSnsReqImageData.decryptKey = localbzh.HmD;
              localObject = new StringBuilder();
              str = localbzh.Id;
              localBatchSnsReqImageData.imageCachePath = o.k(ap.jv(ah.getAccSnsPath(), str) + r.m(localbzh), false);
              localBatchSnsReqImageData.fileKey = (localbzh.Id + "_" + this.zFt.zFo);
              localf.fLb[i] = localBatchSnsReqImageData;
              i += 1;
              continue;
            }
          }
        }
        else
        {
          parame.field_mediaId = (this.zFt.mediaId + "_" + this.zFt.zFo);
          parame.fLd = (this.zFt.getPath() + this.zFt.dYH());
          if (this.zFt.zyh != null)
          {
            if (!this.zFt.zFm) {
              continue;
            }
            localObject = this.zFt.zyh.HmD;
            parame.snsCipherKey = ((String)localObject);
          }
        }
        parame.url = this.zFt.url;
        parame.host = this.host;
        parame.referer = paramString;
        parame.fLe = dI(localArrayList1);
        parame.fLf = dI(localArrayList2);
        parame.fLg = this.iHs;
        parame.fLh = j;
        parame.isColdSnsData = paramBoolean;
        parame.signalQuality = az.getStrength(ak.getContext());
        parame.snsScene = this.zFt.zFp.tag;
        if (this.zFt.zFo == 8)
        {
          parame.eRn = 3;
          parame.appType = 109;
          parame.fileType = 20204;
          ae.i("MicroMsg.SnsCdnDownloadBase", "attachSnsImgTaskInfo reqDownType:%d taskInfo:%s", new Object[] { Integer.valueOf(this.zFt.zFo), parame });
          return true;
          localObject = this.zFt.zyh.HmA;
          continue;
        }
        if ((this.zFt.zFo == 6) || (this.zFt.zFo == 4))
        {
          parame.eRn = 3;
          parame.appType = 105;
          parame.fileType = 20210;
          continue;
        }
        if (this.zFt.zFo != 5) {
          break label810;
        }
      }
      catch (MalformedURLException parame)
      {
        ae.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", parame, "", new Object[0]);
        ae.w("MicroMsg.SnsCdnDownloadBase", "attachSnsImgTaskInfo fail:".concat(String.valueOf(parame)));
        return false;
      }
      parame.eRn = 3;
      parame.appType = 150;
      parame.fileType = 20250;
      continue;
      label810:
      if ((this.zFt.zFo == 2) || (this.zFt.zFo == 1) || (this.zFt.zFo == 3) || (this.zFt.zFo == 9))
      {
        parame.eRn = 3;
        parame.appType = 100;
        parame.fileType = 20201;
        if ((this.zFt.zFo == 1) && ((this.zFt.url.startsWith("http://wxapp.tc.qq.com")) || (this.zFt.url.startsWith("https://wxapp.tc.qq.com"))) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qID, 1) == 1))
        {
          parame.eRn = 3;
          parame.appType = 150;
          parame.fileType = 20201;
        }
      }
    }
  }
  
  public static boolean aAO(String paramString)
  {
    if (zFK.contains(r.ca(1, paramString))) {}
    while (zFK.contains(r.ca(5, paramString))) {
      return true;
    }
    return false;
  }
  
  private static String[] dI(List<String> paramList)
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
  
  public boolean QP(int paramInt)
  {
    return false;
  }
  
  public final void QQ(int paramInt)
  {
    if (ah.dXn()) {
      return;
    }
    Object localObject = (com.tencent.mm.plugin.sns.data.n)this.zFt.ztx.get(paramInt);
    bzh localbzh = (bzh)this.zFt.zum.get(paramInt);
    ae.i("MicroMsg.SnsCdnDownloadBase", "thumbAddDecode index: %d decodeType: %d.", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((com.tencent.mm.plugin.sns.data.n)localObject).zui) });
    ah.dXB().a(localbzh.Id, (com.tencent.mm.memory.n)this.zFN.get(paramInt), ((com.tencent.mm.plugin.sns.data.n)localObject).zui);
    if (((com.tencent.mm.plugin.sns.data.n)localObject).zui == 0) {}
    for (localObject = r.bZ(0, ((com.tencent.mm.plugin.sns.data.n)localObject).dyb);; localObject = null)
    {
      ae.i("MicroMsg.SnsCdnDownloadBase", "thumbAddDecode cacheName: %s.", new Object[] { localObject });
      ah.dXB().aAc((String)localObject);
      return;
    }
  }
  
  public boolean a(bk parambk, String paramString1, long paramLong, String paramString2)
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
  
  public String b(String paramString, bzh parambzh)
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
      localObject2 = com.tencent.mm.model.c.d.aDI().xi((String)localObject1);
      if (((com.tencent.mm.storage.c)localObject2).isValid())
      {
        i = bu.getInt((String)((com.tencent.mm.storage.c)localObject2).fsy().get("needUploadData"), 1);
        str = ((com.tencent.mm.storage.c)localObject2).field_expId;
      }
      break;
    }
    while (i != 0)
    {
      if (this.zFt.zFo == 8) {
        i = 1;
      }
      for (;;)
      {
        label110:
        localObject2 = new com.tencent.mm.modelsns.g();
        ((com.tencent.mm.modelsns.g)localObject2).m("20ImgSize", paramd.field_fileLength + ",");
        StringBuilder localStringBuilder = new StringBuilder();
        int j;
        if (az.isWifi(ak.getContext()))
        {
          j = 1;
          label170:
          ((com.tencent.mm.modelsns.g)localObject2).m("21NetType", j + ",");
          ((com.tencent.mm.modelsns.g)localObject2).m("22DelayTime", paramd.field_delayTime + ",");
          ((com.tencent.mm.modelsns.g)localObject2).m("23RetCode", paramd.field_retCode + ",");
          ((com.tencent.mm.modelsns.g)localObject2).m("24DnsCostTime", paramd.field_dnsCostTime + ",");
          ((com.tencent.mm.modelsns.g)localObject2).m("25ConnectCostTime", paramd.field_connectCostTime + ",");
          ((com.tencent.mm.modelsns.g)localObject2).m("26SendCostTime", ",");
          ((com.tencent.mm.modelsns.g)localObject2).m("27WaitResponseCostTime", paramd.field_waitResponseCostTime + ",");
          ((com.tencent.mm.modelsns.g)localObject2).m("28ReceiveCostTime", paramd.field_receiveCostTime + ",");
          ((com.tencent.mm.modelsns.g)localObject2).m("29ClientAddrIP(uint)", paramd.field_clientHostIP + ",");
          ((com.tencent.mm.modelsns.g)localObject2).m("30ServerAddrIP(uint)", paramd.field_serverHostIP + ",");
          ((com.tencent.mm.modelsns.g)localObject2).m("31dnstype", this.iHs + ",");
          ((com.tencent.mm.modelsns.g)localObject2).m("32signal(int)", az.getStrength(ak.getContext()) + ",");
          ((com.tencent.mm.modelsns.g)localObject2).m("33host(string)", this.host + ",");
          ((com.tencent.mm.modelsns.g)localObject2).m("34MediaType", k + ",");
          ((com.tencent.mm.modelsns.g)localObject2).m("35X_Errno(string)", paramd.field_xErrorNo + ",");
          ((com.tencent.mm.modelsns.g)localObject2).m("36MaxPackageSize", ",");
          ((com.tencent.mm.modelsns.g)localObject2).m("37MaxPackageTimeStamp", ",");
          ((com.tencent.mm.modelsns.g)localObject2).m("38PackageRecordList", ",");
          ((com.tencent.mm.modelsns.g)localObject2).m("39ExpLayerId", (String)localObject1 + ",");
          ((com.tencent.mm.modelsns.g)localObject2).m("40ExpId", str + ",");
          ((com.tencent.mm.modelsns.g)localObject2).m("41FeedId", ",");
          ((com.tencent.mm.modelsns.g)localObject2).m("42BizType", i + ",");
          ((com.tencent.mm.modelsns.g)localObject2).m("43CSeqCheck(uint)", paramd.field_cSeqCheck + ",");
          localObject1 = new StringBuilder();
          if (!paramd.field_usePrivateProtocol) {
            break label993;
          }
        }
        label993:
        for (i = 1;; i = 0)
        {
          ((com.tencent.mm.modelsns.g)localObject2).m("44isPrivate(uint)", i + ",");
          ae.i("MicroMsg.SnsCdnDownloadBase", "report logbuffer(13480 TLMediaFielDownloadRecord): " + ((com.tencent.mm.modelsns.g)localObject2).RD());
          com.tencent.mm.plugin.report.service.g.yxI.f(13480, new Object[] { localObject2 });
          if ((paramd.field_retCode == 200) || (paramd.field_retCode == 0)) {
            break;
          }
          com.tencent.mm.plugin.report.service.g.yxI.f(14071, new Object[] { localObject2 });
          return;
          localObject1 = "100106";
          break label46;
          localObject1 = "100100";
          break label46;
          if ((this.zFt.zFo == 6) || (this.zFt.zFo == 4))
          {
            i = 2;
            break label110;
          }
          if (this.zFt.zFo == 5)
          {
            i = 4;
            break label110;
          }
          if ((this.zFt.zFo != 2) && (this.zFt.zFo != 1) && (this.zFt.zFo != 3)) {
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
  
  public ExecutorService dFv()
  {
    return ah.dXo();
  }
  
  public boolean dYI()
  {
    return true;
  }
  
  public abstract boolean dYJ();
  
  public Integer dYL()
  {
    com.tencent.mm.kernel.g.ajS();
    if ((!com.tencent.mm.kernel.g.ajR().isSDCardAvailable()) || (this.zFt == null)) {
      return Integer.valueOf(2);
    }
    Object localObject1;
    Object localObject3;
    Object localObject4;
    if (dYI())
    {
      if (9 == this.zFt.zFo)
      {
        i = 0;
        while (i < this.zFt.zum.size())
        {
          localObject1 = (bzh)this.zFt.zum.valueAt(i);
          localObject3 = new StringBuilder();
          localObject4 = ((bzh)localObject1).Id;
          localObject1 = ap.jv(ah.getAccSnsPath(), (String)localObject4) + r.m((bzh)localObject1);
          ae.i("MicroMsg.SnsCdnDownloadBase", "pennqin, delete sns thumb: [%s].", new Object[] { localObject1 });
          o.deleteFile((String)localObject1);
          i += 1;
        }
      }
      localObject1 = this.zFt.zyc + this.zFt.dYH();
      ae.i("MicroMsg.SnsCdnDownloadBase", "[tomys] delete img: %s", new Object[] { localObject1 });
      o.deleteFile((String)localObject1);
    }
    final long l3 = System.currentTimeMillis();
    String str;
    boolean bool;
    for (;;)
    {
      try
      {
        localObject1 = ah.dXz();
        localObject3 = this.zFt.mediaId;
        if (bu.isNullOrNil((String)localObject3)) {
          continue;
        }
        localObject1 = (c.c)((com.tencent.mm.plugin.sns.model.c)localObject1).zwG.get(localObject3);
        if ((localObject1 != null) && (!((c.c)localObject1).zwL)) {
          ((c.c)localObject1).setStartTime(l3);
        }
      }
      catch (Exception localException)
      {
        long l2;
        long l1;
        ae.e("MicroMsg.SnsCdnDownloadBase", "exception msg: %s.", new Object[] { localException.getMessage() });
        continue;
        if (!((bk)localObject4).equals(bk.Jgv)) {
          continue;
        }
        localObject2 = "album_friend";
        continue;
        if (!((bk)localObject4).equals(bk.Jgw)) {
          continue;
        }
        localObject2 = "album_self";
        continue;
        if (!((bk)localObject4).equals(bk.Jgx)) {
          continue;
        }
        localObject2 = "album_stranger";
        continue;
        if (!((bk)localObject4).equals(bk.Jgy)) {
          continue;
        }
        localObject2 = "profile_friend";
        continue;
        if (!((bk)localObject4).equals(bk.Jgz)) {
          continue;
        }
        localObject2 = "profile_stranger";
        continue;
        if (!((bk)localObject4).equals(bk.JgA)) {
          continue;
        }
        localObject2 = "comment";
        continue;
        if (!((bk)localObject4).equals(bk.Jgu)) {
          continue;
        }
        localObject2 = "timeline";
        continue;
        this.zFt.url = aAM(this.zFt.url);
        continue;
        localObject2 = "SnsAlbumDomainList";
        continue;
        localObject3 = "SnsAlbumMainStandbyIpSwitchTime";
        continue;
      }
      i = 0;
      if (this.zFt.zum != null) {
        i = this.zFt.zum.size();
      }
      ae.d("MicroMsg.SnsCdnDownloadBase", "to downloadBitmap pack.mediaId: " + this.zFt.mediaId + " pack.mediaObjs.size: " + i + " pack.snsId: " + this.zFt.dAg + " pack.isthumb: " + this.zFt.zFm + " type: " + this.zFt.zFo);
      localObject4 = this.zFt.zFp;
      localObject1 = "";
      if (localObject4 != null) {
        continue;
      }
      localObject1 = "";
      localObject3 = localObject1;
      if (!bu.isNullOrNil((String)localObject1)) {
        localObject3 = "&scene=".concat(String.valueOf(localObject1));
      }
      str = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.FFH), p.getString(ah.dXk()), Integer.valueOf(az.getNetTypeForStat(ak.getContext())), Integer.valueOf(az.getStrength(ak.getContext())), localObject3 });
      if (9 != this.zFt.zFo) {
        continue;
      }
      this.zFt.url = b(this.zFt.url, (bzh)this.zFt.zum.get(0));
      this.dnsCostTime = bu.fpO();
      if (!this.zFt.zFn) {
        continue;
      }
      localObject1 = "SnsSightDomainList";
      if (!this.zFt.zFn) {
        continue;
      }
      localObject3 = "SnsSightMainStandbyIpSwitchTime";
      localObject1 = com.tencent.mm.n.g.acL().getValue((String)localObject1);
      l2 = com.tencent.mm.n.g.acL().getInt((String)localObject3, 0);
      ae.i("MicroMsg.SnsCdnDownloadBase", "pack.isAlbum %s pack.isthumb %s hostvalue %s dcipTime %s", new Object[] { Boolean.valueOf(this.zFt.zFn), Boolean.valueOf(this.zFt.zFm), localObject1, Long.valueOf(l2) });
      l1 = l2;
      if (l2 <= 0L) {
        l1 = 259200L;
      }
      bool = a((bk)localObject4, this.zFt.url, l1, (String)localObject1);
      this.dnsCostTime = bu.DD(this.dnsCostTime);
      if (9 != this.zFt.zFo) {
        break label1024;
      }
      localObject1 = new com.tencent.mm.i.f();
      ((com.tencent.mm.i.e)localObject1).fLl = "task_SnsCdnDownloadBase_1";
      i = 0;
      if (i >= this.zFt.zum.size()) {
        break label966;
      }
      localObject3 = ((bzh)this.zFt.zum.valueAt(i)).Id;
      o.aZI(ap.jv(ah.getAccSnsPath(), (String)localObject3));
      i += 1;
      continue;
      localObject1 = null;
    }
    Object localObject2;
    label966:
    if (a((com.tencent.mm.i.e)localObject2, bool, str))
    {
      ((com.tencent.mm.i.e)localObject2).fLm = new g.a()
      {
        public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(96067);
          if (c.this.zFt == null)
          {
            ae.e("MicroMsg.SnsCdnDownloadBase", "pack is null.");
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
              ae.e("MicroMsg.SnsCdnDownloadBase", "download err, retCode: %d reqDownType: %d.", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(c.this.zFt.zFo) });
              com.tencent.mm.network.b.reportFailIp(paramAnonymousd.field_serverIP);
              if (9 != c.this.zFt.zFo) {
                break label1035;
              }
              paramAnonymousString = paramAnonymousd.fLb;
              if ((paramAnonymousString != null) && (paramAnonymousString.length > 0))
              {
                com.tencent.mm.plugin.report.service.g.yxI.dD(1040, 12);
                paramAnonymousc = (com.tencent.mm.i.f)this.zFO;
                ae.e("MicroMsg.SnsCdnDownloadBase", "download err, taskInfo2 need inc counter, before: %d, inc: %d, count: %d.", new Object[] { Integer.valueOf(paramAnonymousc.cpF), Integer.valueOf(paramAnonymousString.length), Integer.valueOf(paramAnonymousc.fLj) });
                paramAnonymousc.cpF += paramAnonymousString.length;
                j = paramAnonymousString.length;
                i = 0;
                while (i < j)
                {
                  localObject = paramAnonymousString[i];
                  if (((CdnLogic.BatchSnsReqImageData)localObject).retry)
                  {
                    k = ((CdnLogic.BatchSnsReqImageData)localObject).picIndex;
                    localObject = (bzh)c.this.zFt.zum.get(k);
                    localn = (com.tencent.mm.plugin.sns.data.n)c.this.zFt.ztx.get(k);
                    ah.dXz().a((bzh)localObject, 1, localn, c.this.zFt.zFp, paramAnonymousc.dAg);
                    ae.i("MicroMsg.SnsCdnDownloadBase", "group download err, retry single download. index: %d.", new Object[] { Integer.valueOf(k) });
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
            ah.cXK().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96066);
                if (9 == c.this.zFt.zFo)
                {
                  if (((com.tencent.mm.i.f)c.1.this.zFO).Ya()) {
                    c.dYO().remove(c.this.zFt.zyg);
                  }
                  ae.i("MicroMsg.SnsCdnDownloadBase", "download done result: %d, url:%s, mediaID:%s, totalSize: %d, runningTasksSize: %d", new Object[] { Integer.valueOf(i), c.this.zFt.url, c.this.zFt.mediaId, Long.valueOf(paramAnonymousd.field_fileLength), Integer.valueOf(c.dYO().size()) });
                  if ((!c.this.zFt.zFm) || (i == 2)) {
                    break label553;
                  }
                  if (9 != c.this.zFt.zFo) {
                    break label511;
                  }
                  bb.fh(((bzh)c.this.zFt.zum.get(paramAnonymousd.index)).Id, c.this.zFt.mediaType);
                  c.this.QQ(paramAnonymousd.index);
                }
                Object localObject1;
                Object localObject2;
                long l;
                for (;;)
                {
                  if (9 != c.this.zFt.zFo) {
                    break label671;
                  }
                  localObject1 = (bzh)c.this.zFt.zum.get(paramAnonymousd.index);
                  localObject2 = (com.tencent.mm.i.f)c.1.this.zFO;
                  if ((((com.tencent.mm.i.f)localObject2).Ya()) && (!((com.tencent.mm.i.f)localObject2).fLk))
                  {
                    ((com.tencent.mm.i.f)localObject2).fLk = true;
                    l = bu.DD(c.1.this.zFP);
                    ae.d("MicroMsg.SnsCdnDownloadBase", "group download, feed cost: %d.", new Object[] { Long.valueOf(l) });
                    com.tencent.mm.plugin.report.service.g.yxI.n(1040L, 3L, l);
                    com.tencent.mm.plugin.report.service.g.yxI.dD(1040, 4);
                    com.tencent.mm.plugin.report.service.g.yxI.n(1040L, 9L, l);
                    com.tencent.mm.plugin.report.service.g.yxI.n(1040L, 10L, ((com.tencent.mm.i.f)localObject2).fLj);
                  }
                  c.this.zFr.a(i, (bzh)localObject1, c.this.zFt.zFo, c.this.zFt.zFm, c.this.zFt.zyg, (int)paramAnonymousd.field_fileLength, paramAnonymousd.index, ((com.tencent.mm.i.f)localObject2).Ya());
                  AppMethodBeat.o(96066);
                  return;
                  c.dYO().remove(c.this.zFt.zyg);
                  break;
                  label511:
                  bb.fh(c.this.zFt.mediaId, c.this.zFt.mediaType);
                  c.this.dYM();
                  continue;
                  label553:
                  if ((!c.this.zFt.zFm) && ((c.this.zFt.zFo == 4) || (c.this.zFt.zFo == 6)))
                  {
                    localObject1 = c.this.zFt.getPath() + r.i(c.this.dKe);
                    ah.dXB().js(c.this.zFt.mediaId, (String)localObject1);
                  }
                }
                label671:
                if (1 == c.this.zFt.zFo)
                {
                  localObject1 = ah.dXz();
                  localObject2 = c.this.zFt.mediaId;
                  if (((com.tencent.mm.plugin.sns.model.c)localObject1).zwH.remove(localObject2))
                  {
                    l = bu.DD(c.1.this.zFP);
                    ae.d("MicroMsg.SnsCdnDownloadBase", "single download cost: %d.", new Object[] { Long.valueOf(l) });
                    com.tencent.mm.plugin.report.service.g.yxI.n(1040L, 6L, l);
                    com.tencent.mm.plugin.report.service.g.yxI.dD(1040, 7);
                  }
                }
                if (c.this.zFt.zFo == 4) {
                  ae.i("MicroMsg.SnsCdnDownloadBase", "sight download cost=" + bu.DD(c.1.this.zFP) + ", mediaId=" + c.this.zFt.mediaId);
                }
                c.this.zFr.a(i, c.this.dKe, c.this.zFt.zFo, c.this.zFt.zFm, c.this.zFt.zyg, (int)paramAnonymousd.field_fileLength, -1, true);
                AppMethodBeat.o(96066);
              }
            });
            for (;;)
            {
              if (paramAnonymousInt == 0) {
                break label1028;
              }
              ae.e("MicroMsg.SnsCdnDownloadBase", "task build error! startRet: %d, type: %d.", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(c.this.zFt.zFo) });
              if (9 != c.this.zFt.zFo) {
                break label1028;
              }
              com.tencent.mm.plugin.report.service.g.yxI.dD(1040, 13);
              c.dYO().remove(c.this.zFt.zyg);
              c.this.zFr.a(2, null, c.this.zFt.zFo, c.this.zFt.zFm, c.this.zFt.zyg, -1, -1, true);
              paramAnonymousString = (com.tencent.mm.i.f)this.zFO;
              paramAnonymousc = paramAnonymousString.fLb;
              i = paramAnonymousc.length;
              paramAnonymousInt = 0;
              while (paramAnonymousInt < i)
              {
                j = paramAnonymousc[paramAnonymousInt].picIndex;
                paramAnonymousd = (bzh)c.this.zFt.zum.get(j);
                localObject = (com.tencent.mm.plugin.sns.data.n)c.this.zFt.ztx.get(j);
                ah.dXz().a(paramAnonymousd, 1, (com.tencent.mm.plugin.sns.data.n)localObject, c.this.zFt.zFp, paramAnonymousString.dAg);
                ae.i("MicroMsg.SnsCdnDownloadBase", "group download err, retry single download. index: %d.", new Object[] { Integer.valueOf(j) });
                paramAnonymousInt += 1;
              }
              com.tencent.mm.plugin.report.service.g.yxI.dD(1040, 14);
              ae.e("MicroMsg.SnsCdnDownloadBase", "download error, totally re-download by single.");
              paramAnonymousString = (com.tencent.mm.i.f)this.zFO;
              paramAnonymousString.cpF = paramAnonymousString.fLj;
              paramAnonymousc = paramAnonymousString.fLb;
              j = paramAnonymousc.length;
              i = 0;
              while (i < j)
              {
                k = paramAnonymousc[i].picIndex;
                localObject = (bzh)c.this.zFt.zum.get(k);
                localn = (com.tencent.mm.plugin.sns.data.n)c.this.zFt.ztx.get(k);
                ah.dXz().a((bzh)localObject, 1, localn, c.this.zFt.zFp, paramAnonymousString.dAg);
                ae.i("MicroMsg.SnsCdnDownloadBase", "group download err, retry single download. index: %d.", new Object[] { Integer.valueOf(k) });
                i += 1;
              }
              i = 2;
              break;
              ae.d("MicroMsg.SnsCdnDownloadBase", "download succ, type: %d.", new Object[] { Integer.valueOf(c.this.zFt.zFo) });
              c.this.zFM = ((int)paramAnonymousd.field_fileLength);
              if (9 == c.this.zFt.zFo)
              {
                paramAnonymousString = (com.tencent.mm.i.f)this.zFO;
                paramAnonymousString.cpF += 1;
                ae.d("MicroMsg.SnsCdnDownloadBase", "download succ, counter++, res: %d, count: %d.", new Object[] { Integer.valueOf(paramAnonymousString.cpF), Integer.valueOf(paramAnonymousString.fLj) });
              }
              for (paramAnonymousBoolean = c.this.QP(paramAnonymousd.index);; paramAnonymousBoolean = c.this.dYJ())
              {
                if (paramAnonymousBoolean) {
                  break label903;
                }
                i = 2;
                break;
              }
              label903:
              if (c.this.zFt.zFm)
              {
                i = 3;
                break;
              }
              i = 1;
              break;
              if (paramAnonymousc != null)
              {
                float f = (float)paramAnonymousc.field_finishedLength / (float)paramAnonymousc.field_toltalLength;
                if (c.this.zFt.zFq < f)
                {
                  c.this.zFt.zFq = f;
                  ae.d("MicroMsg.SnsCdnDownloadBase", "Download sns image type: %d, mediaId: %s, progress: %f, url: %s", new Object[] { Integer.valueOf(c.this.zFt.zFo), paramAnonymousString, Float.valueOf(f), c.this.zFt.url });
                }
              }
            }
            label1028:
            AppMethodBeat.o(96067);
            return 0;
            label1035:
            i = 2;
          }
        }
        
        public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
        
        public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
        {
          return new byte[0];
        }
      };
      if (com.tencent.mm.an.f.aGZ().b((com.tencent.mm.i.g)localObject2, -1)) {
        ae.i("MicroMsg.SnsCdnDownloadBase", "SubCoreCdnTransport addRecvTask suc");
      }
    }
    for (int i = 1;; i = 2)
    {
      return Integer.valueOf(i);
      label1024:
      o.aZI(this.zFt.getPath());
      localObject2 = new com.tencent.mm.i.e();
      ((com.tencent.mm.i.e)localObject2).fLl = "task_SnsCdnDownloadBase_2";
      break;
      ae.w("MicroMsg.SnsCdnDownloadBase", "SubCoreCdnTransport addRecvTask failed");
    }
  }
  
  public void dYM()
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
      label133:
      localObject1 = null;
      if (this.zFt.ztw.zui != 0) {
        break label597;
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
        break label133;
      }
      if (this.zFt.ztw.list.size() <= 1)
      {
        ah.dXB().a(this.zFt.mediaId, this.zFs, this.zFt.ztw.zui);
        break label133;
      }
      ah.dXB().a(this.zFt.mediaId, this.zFs, 0);
      localObject1 = new LinkedList();
      int i = 0;
      for (;;)
      {
        if ((i >= this.zFt.ztw.list.size()) || (i >= 4)) {
          break label504;
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
      label504:
      this.zFs = com.tencent.mm.memory.n.E(r.v((List)localObject1, ah.dXP()));
      ae.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap " + this.zFt.ztw.dyb + " " + this.zFs);
      ah.dXB().a(this.zFt.ztw.dyb, this.zFs, this.zFt.ztw.zui);
      break label133;
      label597:
      if (this.zFt.ztw.zui == 1) {
        localObject1 = "1-" + this.zFt.ztw.dyb;
      } else if (this.zFt.ztw.zui == 4) {
        localObject1 = "4-" + this.zFt.ztw.dyb;
      } else if (this.zFt.ztw.zui == 5) {
        localObject1 = "5-" + this.zFt.ztw.dyb;
      } else if (this.zFt.ztw.zui == 3) {
        localObject1 = r.bZ(3, this.zFt.ztw.dyb);
      }
    }
  }
  
  public final void dYN()
  {
    if (this.zFt != null) {
      ae.i("MicroMsg.SnsCdnDownloadBase", "checkCdnPath: %s", new Object[] { Boolean.valueOf(o.aZI(this.zFt.getPath())) });
    }
  }
  
  protected abstract int getMediaType();
  
  public void onPostExecute(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, bzh parambzh, int paramInt2, boolean paramBoolean1, String paramString, int paramInt3, int paramInt4, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.c
 * JD-Core Version:    0.7.0.1
 */