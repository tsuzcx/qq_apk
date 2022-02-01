package com.tencent.mm.plugin.sns.model.a;

import android.util.SparseArray;
import com.tencent.mars.cdn.CdnLogic.BatchSnsReqImageData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.i.g.a;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.b.c;
import com.tencent.mm.plugin.sns.model.ba;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bj;
import com.tencent.mm.vfs.i;
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
  extends com.tencent.mm.pluginsdk.model.m<String, Integer, Integer>
{
  private static HashSet<String> zov = new HashSet();
  protected byn dIQ = null;
  private long dnsCostTime = -1L;
  private String host = "";
  private int iEz = -1;
  protected a zoc;
  protected n zod = null;
  protected a zoe = null;
  int zox = 0;
  protected SparseArray<n> zoy = new SparseArray();
  
  public c(a parama, a parama1)
  {
    this.zoc = parama;
    this.zoe = parama1;
    if (parama1 == null) {
      return;
    }
    this.dIQ = parama1.zhs;
    zov.add(parama1.zhr);
    parama1.init();
  }
  
  private boolean a(com.tencent.mm.i.e parame, boolean paramBoolean, String paramString)
  {
    for (;;)
    {
      try
      {
        this.host = new URL(this.zoe.url).getHost();
        ArrayList localArrayList1 = new ArrayList();
        this.iEz = com.tencent.mm.network.b.a(this.host, false, localArrayList1);
        ArrayList localArrayList2 = new ArrayList();
        int j = com.tencent.mm.network.b.a(this.host, true, localArrayList2);
        Object localObject;
        if (9 == this.zoe.znZ)
        {
          parame.field_mediaId = (this.zoe.dzb + "_" + this.zoe.znZ);
          if ((parame instanceof com.tencent.mm.i.f))
          {
            com.tencent.mm.i.f localf = (com.tencent.mm.i.f)parame;
            localf.dzb = this.zoe.dzb;
            localf.fJe = this.zoe.size;
            localf.fJf = this.zoe.zdw.size();
            localf.fIX = new CdnLogic.BatchSnsReqImageData[localf.fJf];
            int i = 0;
            if (i < localf.fJf)
            {
              int k = this.zoe.zdw.keyAt(i);
              byn localbyn = (byn)this.zoe.zdw.get(k);
              CdnLogic.BatchSnsReqImageData localBatchSnsReqImageData = new CdnLogic.BatchSnsReqImageData();
              String str = localbyn.GSI;
              localObject = str;
              if (bt.isNullOrNil(str))
              {
                localObject = str;
                if (localbyn.nEf == 2) {
                  localObject = localbyn.Url;
                }
              }
              localBatchSnsReqImageData.url = b((String)localObject, localbyn);
              localBatchSnsReqImageData.picIndex = k;
              localBatchSnsReqImageData.totalFileSize = 0;
              localBatchSnsReqImageData.decryptKey = localbyn.GTc;
              localObject = new StringBuilder();
              str = localbyn.Id;
              localBatchSnsReqImageData.imageCachePath = i.k(ao.jo(ag.getAccSnsPath(), str) + q.m(localbyn), false);
              localBatchSnsReqImageData.fileKey = (localbyn.Id + "_" + this.zoe.znZ);
              localf.fIX[i] = localBatchSnsReqImageData;
              i += 1;
              continue;
            }
          }
        }
        else
        {
          parame.field_mediaId = (this.zoe.mediaId + "_" + this.zoe.znZ);
          parame.fIZ = (this.zoe.getPath() + this.zoe.dVg());
          if (this.zoe.zhs != null)
          {
            if (!this.zoe.znX) {
              continue;
            }
            localObject = this.zoe.zhs.GTc;
            parame.snsCipherKey = ((String)localObject);
          }
        }
        parame.url = this.zoe.url;
        parame.host = this.host;
        parame.referer = paramString;
        parame.fJa = dF(localArrayList1);
        parame.fJb = dF(localArrayList2);
        parame.fJc = this.iEz;
        parame.fJd = j;
        parame.isColdSnsData = paramBoolean;
        parame.signalQuality = ay.getStrength(aj.getContext());
        parame.snsScene = this.zoe.zoa.tag;
        if (this.zoe.znZ == 8)
        {
          parame.ePC = 3;
          parame.appType = 109;
          parame.fileType = 20204;
          ad.i("MicroMsg.SnsCdnDownloadBase", "attachSnsImgTaskInfo reqDownType:%d taskInfo:%s", new Object[] { Integer.valueOf(this.zoe.znZ), parame });
          return true;
          localObject = this.zoe.zhs.GSZ;
          continue;
        }
        if ((this.zoe.znZ == 6) || (this.zoe.znZ == 4))
        {
          parame.ePC = 3;
          parame.appType = 105;
          parame.fileType = 20210;
          continue;
        }
        if (this.zoe.znZ != 5) {
          break label810;
        }
      }
      catch (MalformedURLException parame)
      {
        ad.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", parame, "", new Object[0]);
        ad.w("MicroMsg.SnsCdnDownloadBase", "attachSnsImgTaskInfo fail:".concat(String.valueOf(parame)));
        return false;
      }
      parame.ePC = 3;
      parame.appType = 150;
      parame.fileType = 20250;
      continue;
      label810:
      if ((this.zoe.znZ == 2) || (this.zoe.znZ == 1) || (this.zoe.znZ == 3) || (this.zoe.znZ == 9))
      {
        parame.ePC = 3;
        parame.appType = 100;
        parame.fileType = 20201;
        if ((this.zoe.znZ == 1) && ((this.zoe.url.startsWith("http://wxapp.tc.qq.com")) || (this.zoe.url.startsWith("https://wxapp.tc.qq.com"))) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBk, 1) == 1))
        {
          parame.ePC = 3;
          parame.appType = 150;
          parame.fileType = 20201;
        }
      }
    }
  }
  
  public static boolean azx(String paramString)
  {
    if (zov.contains(q.ca(1, paramString))) {}
    while (zov.contains(q.ca(5, paramString))) {
      return true;
    }
    return false;
  }
  
  private static String[] dF(List<String> paramList)
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
  
  public boolean Qi(int paramInt)
  {
    return false;
  }
  
  public final void Qj(int paramInt)
  {
    if (ag.dTN()) {
      return;
    }
    Object localObject = (com.tencent.mm.plugin.sns.data.m)this.zoe.zcH.get(paramInt);
    byn localbyn = (byn)this.zoe.zdw.get(paramInt);
    ad.i("MicroMsg.SnsCdnDownloadBase", "thumbAddDecode index: %d decodeType: %d.", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((com.tencent.mm.plugin.sns.data.m)localObject).zds) });
    ag.dUb().a(localbyn.Id, (n)this.zoy.get(paramInt), ((com.tencent.mm.plugin.sns.data.m)localObject).zds);
    if (((com.tencent.mm.plugin.sns.data.m)localObject).zds == 0) {}
    for (localObject = q.bZ(0, ((com.tencent.mm.plugin.sns.data.m)localObject).dwW);; localObject = null)
    {
      ad.i("MicroMsg.SnsCdnDownloadBase", "thumbAddDecode cacheName: %s.", new Object[] { localObject });
      ag.dUb().ayL((String)localObject);
      return;
    }
  }
  
  public boolean a(bj parambj, String paramString1, long paramLong, String paramString2)
  {
    if (paramString1 == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramString1 = new URL(paramString1);
        if ((parambj != null) && (paramString2 != null) && (paramString2.indexOf(paramString1.getHost()) != -1) && (parambj.hbR != 0))
        {
          long l = bt.rM(parambj.hbR);
          if (l > paramLong) {
            return true;
          }
        }
      }
      catch (Exception parambj)
      {
        ad.e("MicroMsg.SnsCdnDownloadBase", "error for check dcip %s", new Object[] { parambj.getMessage() });
      }
    }
    return false;
  }
  
  public String azv(String paramString)
  {
    return paramString;
  }
  
  public String b(String paramString, byn parambyn)
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
      localObject2 = com.tencent.mm.model.c.d.aDs().wz((String)localObject1);
      if (((com.tencent.mm.storage.c)localObject2).isValid())
      {
        i = bt.getInt((String)((com.tencent.mm.storage.c)localObject2).foF().get("needUploadData"), 1);
        str = ((com.tencent.mm.storage.c)localObject2).field_expId;
      }
      break;
    }
    while (i != 0)
    {
      if (this.zoe.znZ == 8) {
        i = 1;
      }
      for (;;)
      {
        label110:
        localObject2 = new com.tencent.mm.modelsns.g();
        ((com.tencent.mm.modelsns.g)localObject2).m("20ImgSize", paramd.field_fileLength + ",");
        StringBuilder localStringBuilder = new StringBuilder();
        int j;
        if (ay.isWifi(aj.getContext()))
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
          ((com.tencent.mm.modelsns.g)localObject2).m("31dnstype", this.iEz + ",");
          ((com.tencent.mm.modelsns.g)localObject2).m("32signal(int)", ay.getStrength(aj.getContext()) + ",");
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
          ad.i("MicroMsg.SnsCdnDownloadBase", "report logbuffer(13480 TLMediaFielDownloadRecord): " + ((com.tencent.mm.modelsns.g)localObject2).RE());
          com.tencent.mm.plugin.report.service.g.yhR.f(13480, new Object[] { localObject2 });
          if ((paramd.field_retCode == 200) || (paramd.field_retCode == 0)) {
            break;
          }
          com.tencent.mm.plugin.report.service.g.yhR.f(14071, new Object[] { localObject2 });
          return;
          localObject1 = "100106";
          break label46;
          localObject1 = "100100";
          break label46;
          if ((this.zoe.znZ == 6) || (this.zoe.znZ == 4))
          {
            i = 2;
            break label110;
          }
          if (this.zoe.znZ == 5)
          {
            i = 4;
            break label110;
          }
          if ((this.zoe.znZ != 2) && (this.zoe.znZ != 1) && (this.zoe.znZ != 3)) {
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
  
  public ExecutorService dCe()
  {
    return ag.dTO();
  }
  
  public boolean dVh()
  {
    return true;
  }
  
  public abstract boolean dVi();
  
  public Integer dVk()
  {
    com.tencent.mm.kernel.g.ajD();
    if ((!com.tencent.mm.kernel.g.ajC().isSDCardAvailable()) || (this.zoe == null)) {
      return Integer.valueOf(2);
    }
    Object localObject1;
    Object localObject3;
    Object localObject4;
    if (dVh())
    {
      if (9 == this.zoe.znZ)
      {
        i = 0;
        while (i < this.zoe.zdw.size())
        {
          localObject1 = (byn)this.zoe.zdw.valueAt(i);
          localObject3 = new StringBuilder();
          localObject4 = ((byn)localObject1).Id;
          localObject1 = ao.jo(ag.getAccSnsPath(), (String)localObject4) + q.m((byn)localObject1);
          ad.i("MicroMsg.SnsCdnDownloadBase", "pennqin, delete sns thumb: [%s].", new Object[] { localObject1 });
          i.deleteFile((String)localObject1);
          i += 1;
        }
      }
      localObject1 = this.zoe.zhn + this.zoe.dVg();
      ad.i("MicroMsg.SnsCdnDownloadBase", "[tomys] delete img: %s", new Object[] { localObject1 });
      i.deleteFile((String)localObject1);
    }
    final long l3 = System.currentTimeMillis();
    String str;
    boolean bool;
    for (;;)
    {
      try
      {
        localObject1 = ag.dTZ();
        localObject3 = this.zoe.mediaId;
        if (bt.isNullOrNil((String)localObject3)) {
          continue;
        }
        localObject1 = (b.c)((com.tencent.mm.plugin.sns.model.b)localObject1).zfQ.get(localObject3);
        if ((localObject1 != null) && (!((b.c)localObject1).zfV)) {
          ((b.c)localObject1).setStartTime(l3);
        }
      }
      catch (Exception localException)
      {
        long l2;
        long l1;
        ad.e("MicroMsg.SnsCdnDownloadBase", "exception msg: %s.", new Object[] { localException.getMessage() });
        continue;
        if (!((bj)localObject4).equals(bj.ILO)) {
          continue;
        }
        localObject2 = "album_friend";
        continue;
        if (!((bj)localObject4).equals(bj.ILP)) {
          continue;
        }
        localObject2 = "album_self";
        continue;
        if (!((bj)localObject4).equals(bj.ILQ)) {
          continue;
        }
        localObject2 = "album_stranger";
        continue;
        if (!((bj)localObject4).equals(bj.ILR)) {
          continue;
        }
        localObject2 = "profile_friend";
        continue;
        if (!((bj)localObject4).equals(bj.ILS)) {
          continue;
        }
        localObject2 = "profile_stranger";
        continue;
        if (!((bj)localObject4).equals(bj.ILT)) {
          continue;
        }
        localObject2 = "comment";
        continue;
        if (!((bj)localObject4).equals(bj.ILN)) {
          continue;
        }
        localObject2 = "timeline";
        continue;
        this.zoe.url = azv(this.zoe.url);
        continue;
        localObject2 = "SnsAlbumDomainList";
        continue;
        localObject3 = "SnsAlbumMainStandbyIpSwitchTime";
        continue;
      }
      i = 0;
      if (this.zoe.zdw != null) {
        i = this.zoe.zdw.size();
      }
      ad.d("MicroMsg.SnsCdnDownloadBase", "to downloadBitmap pack.mediaId: " + this.zoe.mediaId + " pack.mediaObjs.size: " + i + " pack.snsId: " + this.zoe.dzb + " pack.isthumb: " + this.zoe.znX + " type: " + this.zoe.znZ);
      localObject4 = this.zoe.zoa;
      localObject1 = "";
      if (localObject4 != null) {
        continue;
      }
      localObject1 = "";
      localObject3 = localObject1;
      if (!bt.isNullOrNil((String)localObject1)) {
        localObject3 = "&scene=".concat(String.valueOf(localObject1));
      }
      str = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.Fnj), p.getString(ag.dTK()), Integer.valueOf(ay.getNetTypeForStat(aj.getContext())), Integer.valueOf(ay.getStrength(aj.getContext())), localObject3 });
      if (9 != this.zoe.znZ) {
        continue;
      }
      this.zoe.url = b(this.zoe.url, (byn)this.zoe.zdw.get(0));
      this.dnsCostTime = bt.flT();
      if (!this.zoe.znY) {
        continue;
      }
      localObject1 = "SnsSightDomainList";
      if (!this.zoe.znY) {
        continue;
      }
      localObject3 = "SnsSightMainStandbyIpSwitchTime";
      localObject1 = com.tencent.mm.n.g.acA().getValue((String)localObject1);
      l2 = com.tencent.mm.n.g.acA().getInt((String)localObject3, 0);
      ad.i("MicroMsg.SnsCdnDownloadBase", "pack.isAlbum %s pack.isthumb %s hostvalue %s dcipTime %s", new Object[] { Boolean.valueOf(this.zoe.znY), Boolean.valueOf(this.zoe.znX), localObject1, Long.valueOf(l2) });
      l1 = l2;
      if (l2 <= 0L) {
        l1 = 259200L;
      }
      bool = a((bj)localObject4, this.zoe.url, l1, (String)localObject1);
      this.dnsCostTime = bt.Df(this.dnsCostTime);
      if (9 != this.zoe.znZ) {
        break label1024;
      }
      localObject1 = new com.tencent.mm.i.f();
      ((com.tencent.mm.i.e)localObject1).fJi = "task_SnsCdnDownloadBase_1";
      i = 0;
      if (i >= this.zoe.zdw.size()) {
        break label966;
      }
      localObject3 = ((byn)this.zoe.zdw.valueAt(i)).Id;
      i.aYg(ao.jo(ag.getAccSnsPath(), (String)localObject3));
      i += 1;
      continue;
      localObject1 = null;
    }
    Object localObject2;
    label966:
    if (a((com.tencent.mm.i.e)localObject2, bool, str))
    {
      ((com.tencent.mm.i.e)localObject2).fJj = new g.a()
      {
        public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(96067);
          if (c.this.zoe == null)
          {
            ad.e("MicroMsg.SnsCdnDownloadBase", "pack is null.");
            AppMethodBeat.o(96067);
            return 0;
          }
          int j;
          final int i;
          Object localObject;
          int k;
          com.tencent.mm.plugin.sns.data.m localm;
          if (paramAnonymousd != null) {
            if (paramAnonymousd.field_retCode != 0)
            {
              ad.e("MicroMsg.SnsCdnDownloadBase", "download err, retCode: %d reqDownType: %d.", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(c.this.zoe.znZ) });
              com.tencent.mm.network.b.reportFailIp(paramAnonymousd.field_serverIP);
              if (9 != c.this.zoe.znZ) {
                break label1035;
              }
              paramAnonymousString = paramAnonymousd.fIX;
              if ((paramAnonymousString != null) && (paramAnonymousString.length > 0))
              {
                com.tencent.mm.plugin.report.service.g.yhR.dD(1040, 12);
                paramAnonymousc = (com.tencent.mm.i.f)this.zoz;
                ad.e("MicroMsg.SnsCdnDownloadBase", "download err, taskInfo2 need inc counter, before: %d, inc: %d, count: %d.", new Object[] { Integer.valueOf(paramAnonymousc.fJg), Integer.valueOf(paramAnonymousString.length), Integer.valueOf(paramAnonymousc.fJf) });
                paramAnonymousc.fJg += paramAnonymousString.length;
                j = paramAnonymousString.length;
                i = 0;
                while (i < j)
                {
                  localObject = paramAnonymousString[i];
                  if (((CdnLogic.BatchSnsReqImageData)localObject).retry)
                  {
                    k = ((CdnLogic.BatchSnsReqImageData)localObject).picIndex;
                    localObject = (byn)c.this.zoe.zdw.get(k);
                    localm = (com.tencent.mm.plugin.sns.data.m)c.this.zoe.zcH.get(k);
                    ag.dTZ().a((byn)localObject, 1, localm, c.this.zoe.zoa, paramAnonymousc.dzb);
                    ad.i("MicroMsg.SnsCdnDownloadBase", "group download err, retry single download. index: %d.", new Object[] { Integer.valueOf(k) });
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
            ag.cVf().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96066);
                if (9 == c.this.zoe.znZ)
                {
                  if (((com.tencent.mm.i.f)c.1.this.zoz).XQ()) {
                    c.dVn().remove(c.this.zoe.zhr);
                  }
                  ad.i("MicroMsg.SnsCdnDownloadBase", "download done result: %d, url:%s, mediaID:%s, totalSize: %d, runningTasksSize: %d", new Object[] { Integer.valueOf(i), c.this.zoe.url, c.this.zoe.mediaId, Long.valueOf(paramAnonymousd.field_fileLength), Integer.valueOf(c.dVn().size()) });
                  if ((!c.this.zoe.znX) || (i == 2)) {
                    break label553;
                  }
                  if (9 != c.this.zoe.znZ) {
                    break label511;
                  }
                  ba.eY(((byn)c.this.zoe.zdw.get(paramAnonymousd.index)).Id, c.this.zoe.mediaType);
                  c.this.Qj(paramAnonymousd.index);
                }
                Object localObject1;
                Object localObject2;
                long l;
                for (;;)
                {
                  if (9 != c.this.zoe.znZ) {
                    break label671;
                  }
                  localObject1 = (byn)c.this.zoe.zdw.get(paramAnonymousd.index);
                  localObject2 = (com.tencent.mm.i.f)c.1.this.zoz;
                  if ((((com.tencent.mm.i.f)localObject2).XQ()) && (!((com.tencent.mm.i.f)localObject2).fJh))
                  {
                    ((com.tencent.mm.i.f)localObject2).fJh = true;
                    l = bt.Df(c.1.this.zoA);
                    ad.d("MicroMsg.SnsCdnDownloadBase", "group download, feed cost: %d.", new Object[] { Long.valueOf(l) });
                    com.tencent.mm.plugin.report.service.g.yhR.n(1040L, 3L, l);
                    com.tencent.mm.plugin.report.service.g.yhR.dD(1040, 4);
                    com.tencent.mm.plugin.report.service.g.yhR.n(1040L, 9L, l);
                    com.tencent.mm.plugin.report.service.g.yhR.n(1040L, 10L, ((com.tencent.mm.i.f)localObject2).fJf);
                  }
                  c.this.zoc.a(i, (byn)localObject1, c.this.zoe.znZ, c.this.zoe.znX, c.this.zoe.zhr, (int)paramAnonymousd.field_fileLength, paramAnonymousd.index, ((com.tencent.mm.i.f)localObject2).XQ());
                  AppMethodBeat.o(96066);
                  return;
                  c.dVn().remove(c.this.zoe.zhr);
                  break;
                  label511:
                  ba.eY(c.this.zoe.mediaId, c.this.zoe.mediaType);
                  c.this.dVl();
                  continue;
                  label553:
                  if ((!c.this.zoe.znX) && ((c.this.zoe.znZ == 4) || (c.this.zoe.znZ == 6)))
                  {
                    localObject1 = c.this.zoe.getPath() + q.i(c.this.dIQ);
                    ag.dUb().jl(c.this.zoe.mediaId, (String)localObject1);
                  }
                }
                label671:
                if (1 == c.this.zoe.znZ)
                {
                  localObject1 = ag.dTZ();
                  localObject2 = c.this.zoe.mediaId;
                  if (((com.tencent.mm.plugin.sns.model.b)localObject1).zfR.remove(localObject2))
                  {
                    l = bt.Df(c.1.this.zoA);
                    ad.d("MicroMsg.SnsCdnDownloadBase", "single download cost: %d.", new Object[] { Long.valueOf(l) });
                    com.tencent.mm.plugin.report.service.g.yhR.n(1040L, 6L, l);
                    com.tencent.mm.plugin.report.service.g.yhR.dD(1040, 7);
                  }
                }
                if (c.this.zoe.znZ == 4) {
                  ad.i("MicroMsg.SnsCdnDownloadBase", "sight download cost=" + bt.Df(c.1.this.zoA) + ", mediaId=" + c.this.zoe.mediaId);
                }
                c.this.zoc.a(i, c.this.dIQ, c.this.zoe.znZ, c.this.zoe.znX, c.this.zoe.zhr, (int)paramAnonymousd.field_fileLength, -1, true);
                AppMethodBeat.o(96066);
              }
            });
            for (;;)
            {
              if (paramAnonymousInt == 0) {
                break label1028;
              }
              ad.e("MicroMsg.SnsCdnDownloadBase", "task build error! startRet: %d, type: %d.", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(c.this.zoe.znZ) });
              if (9 != c.this.zoe.znZ) {
                break label1028;
              }
              com.tencent.mm.plugin.report.service.g.yhR.dD(1040, 13);
              c.dVn().remove(c.this.zoe.zhr);
              c.this.zoc.a(2, null, c.this.zoe.znZ, c.this.zoe.znX, c.this.zoe.zhr, -1, -1, true);
              paramAnonymousString = (com.tencent.mm.i.f)this.zoz;
              paramAnonymousc = paramAnonymousString.fIX;
              i = paramAnonymousc.length;
              paramAnonymousInt = 0;
              while (paramAnonymousInt < i)
              {
                j = paramAnonymousc[paramAnonymousInt].picIndex;
                paramAnonymousd = (byn)c.this.zoe.zdw.get(j);
                localObject = (com.tencent.mm.plugin.sns.data.m)c.this.zoe.zcH.get(j);
                ag.dTZ().a(paramAnonymousd, 1, (com.tencent.mm.plugin.sns.data.m)localObject, c.this.zoe.zoa, paramAnonymousString.dzb);
                ad.i("MicroMsg.SnsCdnDownloadBase", "group download err, retry single download. index: %d.", new Object[] { Integer.valueOf(j) });
                paramAnonymousInt += 1;
              }
              com.tencent.mm.plugin.report.service.g.yhR.dD(1040, 14);
              ad.e("MicroMsg.SnsCdnDownloadBase", "download error, totally re-download by single.");
              paramAnonymousString = (com.tencent.mm.i.f)this.zoz;
              paramAnonymousString.fJg = paramAnonymousString.fJf;
              paramAnonymousc = paramAnonymousString.fIX;
              j = paramAnonymousc.length;
              i = 0;
              while (i < j)
              {
                k = paramAnonymousc[i].picIndex;
                localObject = (byn)c.this.zoe.zdw.get(k);
                localm = (com.tencent.mm.plugin.sns.data.m)c.this.zoe.zcH.get(k);
                ag.dTZ().a((byn)localObject, 1, localm, c.this.zoe.zoa, paramAnonymousString.dzb);
                ad.i("MicroMsg.SnsCdnDownloadBase", "group download err, retry single download. index: %d.", new Object[] { Integer.valueOf(k) });
                i += 1;
              }
              i = 2;
              break;
              ad.d("MicroMsg.SnsCdnDownloadBase", "download succ, type: %d.", new Object[] { Integer.valueOf(c.this.zoe.znZ) });
              c.this.zox = ((int)paramAnonymousd.field_fileLength);
              if (9 == c.this.zoe.znZ)
              {
                paramAnonymousString = (com.tencent.mm.i.f)this.zoz;
                paramAnonymousString.fJg += 1;
                ad.d("MicroMsg.SnsCdnDownloadBase", "download succ, counter++, res: %d, count: %d.", new Object[] { Integer.valueOf(paramAnonymousString.fJg), Integer.valueOf(paramAnonymousString.fJf) });
              }
              for (paramAnonymousBoolean = c.this.Qi(paramAnonymousd.index);; paramAnonymousBoolean = c.this.dVi())
              {
                if (paramAnonymousBoolean) {
                  break label903;
                }
                i = 2;
                break;
              }
              label903:
              if (c.this.zoe.znX)
              {
                i = 3;
                break;
              }
              i = 1;
              break;
              if (paramAnonymousc != null)
              {
                float f = (float)paramAnonymousc.field_finishedLength / (float)paramAnonymousc.field_toltalLength;
                if (c.this.zoe.zob < f)
                {
                  c.this.zoe.zob = f;
                  ad.d("MicroMsg.SnsCdnDownloadBase", "Download sns image type: %d, mediaId: %s, progress: %f, url: %s", new Object[] { Integer.valueOf(c.this.zoe.znZ), paramAnonymousString, Float.valueOf(f), c.this.zoe.url });
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
      if (com.tencent.mm.ao.f.aGI().b((com.tencent.mm.i.g)localObject2, -1)) {
        ad.i("MicroMsg.SnsCdnDownloadBase", "SubCoreCdnTransport addRecvTask suc");
      }
    }
    for (int i = 1;; i = 2)
    {
      return Integer.valueOf(i);
      label1024:
      i.aYg(this.zoe.getPath());
      localObject2 = new com.tencent.mm.i.e();
      ((com.tencent.mm.i.e)localObject2).fJi = "task_SnsCdnDownloadBase_2";
      break;
      ad.w("MicroMsg.SnsCdnDownloadBase", "SubCoreCdnTransport addRecvTask failed");
    }
  }
  
  public void dVl()
  {
    if (ag.dTN()) {
      return;
    }
    System.currentTimeMillis();
    Object localObject1;
    Object localObject2;
    if (this.zoe.zcG.zds == 4)
    {
      ad.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur thumb");
      localObject1 = q.d(this.dIQ);
      localObject2 = q.f(this.dIQ);
      this.zod = com.tencent.mm.plugin.sns.lucky.a.a.jj(this.zoe.getPath() + (String)localObject1, this.zoe.getPath() + (String)localObject2);
      ag.dUb().a(this.zoe.mediaId, this.zod, this.zoe.zcG.zds);
      label133:
      localObject1 = null;
      if (this.zoe.zcG.zds != 0) {
        break label597;
      }
      localObject1 = "0-" + this.zoe.zcG.dwW;
    }
    for (;;)
    {
      ag.dUb().ayL((String)localObject1);
      return;
      if (this.zoe.zcG.zds == 5)
      {
        ad.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur grid");
        localObject1 = q.d(this.dIQ);
        localObject2 = q.g(this.dIQ);
        this.zod = com.tencent.mm.plugin.sns.lucky.a.a.jj(this.zoe.getPath() + (String)localObject1, this.zoe.getPath() + (String)localObject2);
        ag.dUb().a(this.zoe.mediaId, this.zod, this.zoe.zcG.zds);
        break label133;
      }
      if (this.zoe.zcG.list.size() <= 1)
      {
        ag.dUb().a(this.zoe.mediaId, this.zod, this.zoe.zcG.zds);
        break label133;
      }
      ag.dUb().a(this.zoe.mediaId, this.zod, 0);
      localObject1 = new LinkedList();
      int i = 0;
      for (;;)
      {
        if ((i >= this.zoe.zcG.list.size()) || (i >= 4)) {
          break label504;
        }
        localObject2 = (byn)this.zoe.zcG.list.get(i);
        n localn = ag.dUb().ayM(((byn)localObject2).Id);
        if (!q.b(localn)) {
          break;
        }
        ((List)localObject1).add(localn);
        ad.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap from " + localn + " " + ((byn)localObject2).Id);
        i += 1;
      }
      label504:
      this.zod = n.D(q.u((List)localObject1, ag.dUp()));
      ad.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap " + this.zoe.zcG.dwW + " " + this.zod);
      ag.dUb().a(this.zoe.zcG.dwW, this.zod, this.zoe.zcG.zds);
      break label133;
      label597:
      if (this.zoe.zcG.zds == 1) {
        localObject1 = "1-" + this.zoe.zcG.dwW;
      } else if (this.zoe.zcG.zds == 4) {
        localObject1 = "4-" + this.zoe.zcG.dwW;
      } else if (this.zoe.zcG.zds == 5) {
        localObject1 = "5-" + this.zoe.zcG.dwW;
      } else if (this.zoe.zcG.zds == 3) {
        localObject1 = q.bZ(3, this.zoe.zcG.dwW);
      }
    }
  }
  
  public final void dVm()
  {
    if (this.zoe != null) {
      ad.i("MicroMsg.SnsCdnDownloadBase", "checkCdnPath: %s", new Object[] { Boolean.valueOf(i.aYg(this.zoe.getPath())) });
    }
  }
  
  protected abstract int getMediaType();
  
  public void onPostExecute(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, byn parambyn, int paramInt2, boolean paramBoolean1, String paramString, int paramInt3, int paramInt4, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.c
 * JD-Core Version:    0.7.0.1
 */