package com.tencent.mm.plugin.sns.model.a;

import android.util.SparseArray;
import com.tencent.mars.cdn.CdnLogic.BatchSnsReqImageData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.i.g.a;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.b.c;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bc;
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
  private static HashSet<String> wLQ = new HashSet();
  private long dnsCostTime = -1L;
  protected bpi dyS = null;
  private int hKM = -1;
  private String host = "";
  int wLS = 0;
  protected SparseArray<n> wLT = new SparseArray();
  protected a wLx;
  protected n wLy = null;
  protected a wLz = null;
  
  public c(a parama, a parama1)
  {
    this.wLx = parama;
    this.wLz = parama1;
    if (parama1 == null) {
      return;
    }
    this.dyS = parama1.wFd;
    wLQ.add(parama1.wFc);
    parama1.init();
  }
  
  private boolean a(com.tencent.mm.i.e parame, boolean paramBoolean, String paramString)
  {
    for (;;)
    {
      try
      {
        this.host = new URL(this.wLz.url).getHost();
        ArrayList localArrayList1 = new ArrayList();
        this.hKM = com.tencent.mm.network.b.a(this.host, false, localArrayList1);
        ArrayList localArrayList2 = new ArrayList();
        int j = com.tencent.mm.network.b.a(this.host, true, localArrayList2);
        Object localObject;
        if (9 == this.wLz.wLu)
        {
          parame.field_mediaId = (this.wLz.dpC + "_" + this.wLz.wLu);
          if ((parame instanceof com.tencent.mm.i.f))
          {
            com.tencent.mm.i.f localf = (com.tencent.mm.i.f)parame;
            localf.dpC = this.wLz.dpC;
            localf.fnD = this.wLz.size;
            localf.fnE = this.wLz.wBh.size();
            localf.fnw = new CdnLogic.BatchSnsReqImageData[localf.fnE];
            int i = 0;
            if (i < localf.fnE)
            {
              int k = this.wLz.wBh.keyAt(i);
              bpi localbpi = (bpi)this.wLz.wBh.get(k);
              CdnLogic.BatchSnsReqImageData localBatchSnsReqImageData = new CdnLogic.BatchSnsReqImageData();
              String str = localbpi.DMQ;
              localObject = str;
              if (bt.isNullOrNil(str))
              {
                localObject = str;
                if (localbpi.mBH == 2) {
                  localObject = localbpi.Url;
                }
              }
              localBatchSnsReqImageData.url = b((String)localObject, localbpi);
              localBatchSnsReqImageData.picIndex = k;
              localBatchSnsReqImageData.totalFileSize = 0;
              localBatchSnsReqImageData.decryptKey = localbpi.DNk;
              localObject = new StringBuilder();
              str = localbpi.Id;
              localBatchSnsReqImageData.imageCachePath = i.k(an.iF(af.getAccSnsPath(), str) + q.m(localbpi), false);
              localBatchSnsReqImageData.fileKey = (localbpi.Id + "_" + this.wLz.wLu);
              localf.fnw[i] = localBatchSnsReqImageData;
              i += 1;
              continue;
            }
          }
        }
        else
        {
          parame.field_mediaId = (this.wLz.mediaId + "_" + this.wLz.wLu);
          parame.fny = (this.wLz.getPath() + this.wLz.dut());
          if (this.wLz.wFd != null)
          {
            if (!this.wLz.wLs) {
              continue;
            }
            localObject = this.wLz.wFd.DNk;
            parame.snsCipherKey = ((String)localObject);
          }
        }
        parame.url = this.wLz.url;
        parame.host = this.host;
        parame.referer = paramString;
        parame.fnz = dy(localArrayList1);
        parame.fnA = dy(localArrayList2);
        parame.fnB = this.hKM;
        parame.fnC = j;
        parame.isColdSnsData = paramBoolean;
        parame.signalQuality = com.tencent.mm.sdk.platformtools.ay.getStrength(aj.getContext());
        parame.snsScene = this.wLz.wLv.tag;
        if (this.wLz.wLu == 8)
        {
          parame.evH = 3;
          parame.appType = 109;
          parame.fileType = 20204;
          ad.i("MicroMsg.SnsCdnDownloadBase", "attachSnsImgTaskInfo reqDownType:%d taskInfo:%s", new Object[] { Integer.valueOf(this.wLz.wLu), parame });
          return true;
          localObject = this.wLz.wFd.DNh;
          continue;
        }
        if ((this.wLz.wLu == 6) || (this.wLz.wLu == 4))
        {
          parame.evH = 3;
          parame.appType = 105;
          parame.fileType = 20210;
          continue;
        }
        if (this.wLz.wLu != 5) {
          break label810;
        }
      }
      catch (MalformedURLException parame)
      {
        ad.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", parame, "", new Object[0]);
        ad.w("MicroMsg.SnsCdnDownloadBase", "attachSnsImgTaskInfo fail:".concat(String.valueOf(parame)));
        return false;
      }
      parame.evH = 3;
      parame.appType = 150;
      parame.fileType = 20250;
      continue;
      label810:
      if ((this.wLz.wLu == 2) || (this.wLz.wLu == 1) || (this.wLz.wLu == 3) || (this.wLz.wLu == 9))
      {
        parame.evH = 3;
        parame.appType = 100;
        parame.fileType = 20201;
        if ((this.wLz.wLu == 1) && ((this.wLz.url.startsWith("http://wxapp.tc.qq.com")) || (this.wLz.url.startsWith("https://wxapp.tc.qq.com"))) && (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.psl, 1) == 1))
        {
          parame.evH = 3;
          parame.appType = 150;
          parame.fileType = 20201;
        }
      }
    }
  }
  
  public static boolean apf(String paramString)
  {
    if (wLQ.contains(q.bP(1, paramString))) {}
    while (wLQ.contains(q.bP(5, paramString))) {
      return true;
    }
    return false;
  }
  
  private static String[] dy(List<String> paramList)
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
  
  public boolean My(int paramInt)
  {
    return false;
  }
  
  public final void Mz(int paramInt)
  {
    if (af.dtd()) {
      return;
    }
    Object localObject = (com.tencent.mm.plugin.sns.data.m)this.wLz.wAw.get(paramInt);
    bpi localbpi = (bpi)this.wLz.wBh.get(paramInt);
    ad.i("MicroMsg.SnsCdnDownloadBase", "thumbAddDecode index: %d decodeType: %d.", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((com.tencent.mm.plugin.sns.data.m)localObject).wBd) });
    af.dtr().a(localbpi.Id, (n)this.wLT.get(paramInt), ((com.tencent.mm.plugin.sns.data.m)localObject).wBd);
    if (((com.tencent.mm.plugin.sns.data.m)localObject).wBd == 0) {}
    for (localObject = q.bO(0, ((com.tencent.mm.plugin.sns.data.m)localObject).dnB);; localObject = null)
    {
      ad.i("MicroMsg.SnsCdnDownloadBase", "thumbAddDecode cacheName: %s.", new Object[] { localObject });
      af.dtr().aou((String)localObject);
      return;
    }
  }
  
  public boolean a(bc parambc, String paramString1, long paramLong, String paramString2)
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
  
  public String b(String paramString, bpi parambpi)
  {
    return paramString;
  }
  
  protected final void b(com.tencent.mm.i.d paramd)
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
      localObject2 = com.tencent.mm.model.c.d.aty().qu((String)localObject1);
      if (((com.tencent.mm.storage.c)localObject2).isValid())
      {
        i = bt.getInt((String)((com.tencent.mm.storage.c)localObject2).eJy().get("needUploadData"), 1);
        str = ((com.tencent.mm.storage.c)localObject2).field_expId;
      }
      break;
    }
    while (i != 0)
    {
      if (this.wLz.wLu == 8) {
        i = 1;
      }
      for (;;)
      {
        label110:
        localObject2 = new com.tencent.mm.modelsns.f();
        ((com.tencent.mm.modelsns.f)localObject2).o("20ImgSize", paramd.field_fileLength + ",");
        StringBuilder localStringBuilder = new StringBuilder();
        int j;
        if (com.tencent.mm.sdk.platformtools.ay.isWifi(aj.getContext()))
        {
          j = 1;
          label170:
          ((com.tencent.mm.modelsns.f)localObject2).o("21NetType", j + ",");
          ((com.tencent.mm.modelsns.f)localObject2).o("22DelayTime", paramd.field_delayTime + ",");
          ((com.tencent.mm.modelsns.f)localObject2).o("23RetCode", paramd.field_retCode + ",");
          ((com.tencent.mm.modelsns.f)localObject2).o("24DnsCostTime", paramd.field_dnsCostTime + ",");
          ((com.tencent.mm.modelsns.f)localObject2).o("25ConnectCostTime", paramd.field_connectCostTime + ",");
          ((com.tencent.mm.modelsns.f)localObject2).o("26SendCostTime", ",");
          ((com.tencent.mm.modelsns.f)localObject2).o("27WaitResponseCostTime", paramd.field_waitResponseCostTime + ",");
          ((com.tencent.mm.modelsns.f)localObject2).o("28ReceiveCostTime", paramd.field_receiveCostTime + ",");
          ((com.tencent.mm.modelsns.f)localObject2).o("29ClientAddrIP(uint)", paramd.field_clientHostIP + ",");
          ((com.tencent.mm.modelsns.f)localObject2).o("30ServerAddrIP(uint)", paramd.field_serverHostIP + ",");
          ((com.tencent.mm.modelsns.f)localObject2).o("31dnstype", this.hKM + ",");
          ((com.tencent.mm.modelsns.f)localObject2).o("32signal(int)", com.tencent.mm.sdk.platformtools.ay.getStrength(aj.getContext()) + ",");
          ((com.tencent.mm.modelsns.f)localObject2).o("33host(string)", this.host + ",");
          ((com.tencent.mm.modelsns.f)localObject2).o("34MediaType", k + ",");
          ((com.tencent.mm.modelsns.f)localObject2).o("35X_Errno(string)", paramd.field_xErrorNo + ",");
          ((com.tencent.mm.modelsns.f)localObject2).o("36MaxPackageSize", ",");
          ((com.tencent.mm.modelsns.f)localObject2).o("37MaxPackageTimeStamp", ",");
          ((com.tencent.mm.modelsns.f)localObject2).o("38PackageRecordList", ",");
          ((com.tencent.mm.modelsns.f)localObject2).o("39ExpLayerId", (String)localObject1 + ",");
          ((com.tencent.mm.modelsns.f)localObject2).o("40ExpId", str + ",");
          ((com.tencent.mm.modelsns.f)localObject2).o("41FeedId", ",");
          ((com.tencent.mm.modelsns.f)localObject2).o("42BizType", i + ",");
          ((com.tencent.mm.modelsns.f)localObject2).o("43CSeqCheck(uint)", paramd.field_cSeqCheck + ",");
          localObject1 = new StringBuilder();
          if (!paramd.field_usePrivateProtocol) {
            break label993;
          }
        }
        label993:
        for (i = 1;; i = 0)
        {
          ((com.tencent.mm.modelsns.f)localObject2).o("44isPrivate(uint)", i + ",");
          ad.i("MicroMsg.SnsCdnDownloadBase", "report logbuffer(13480 TLMediaFielDownloadRecord): " + ((com.tencent.mm.modelsns.f)localObject2).PW());
          h.vKh.f(13480, new Object[] { localObject2 });
          if ((paramd.field_retCode == 200) || (paramd.field_retCode == 0)) {
            break;
          }
          h.vKh.f(14071, new Object[] { localObject2 });
          return;
          localObject1 = "100106";
          break label46;
          localObject1 = "100100";
          break label46;
          if ((this.wLz.wLu == 6) || (this.wLz.wLu == 4))
          {
            i = 2;
            break label110;
          }
          if (this.wLz.wLu == 5)
          {
            i = 4;
            break label110;
          }
          if ((this.wLz.wLu != 2) && (this.wLz.wLu != 1) && (this.wLz.wLu != 3)) {
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
  
  public ExecutorService dnm()
  {
    return af.dte();
  }
  
  public boolean duu()
  {
    return true;
  }
  
  public abstract boolean duv();
  
  public Integer dux()
  {
    com.tencent.mm.kernel.g.afC();
    if ((!com.tencent.mm.kernel.g.afB().isSDCardAvailable()) || (this.wLz == null)) {
      return Integer.valueOf(2);
    }
    Object localObject1;
    Object localObject3;
    Object localObject4;
    if (duu())
    {
      if (9 == this.wLz.wLu)
      {
        i = 0;
        while (i < this.wLz.wBh.size())
        {
          localObject1 = (bpi)this.wLz.wBh.valueAt(i);
          localObject3 = new StringBuilder();
          localObject4 = ((bpi)localObject1).Id;
          localObject1 = an.iF(af.getAccSnsPath(), (String)localObject4) + q.m((bpi)localObject1);
          ad.i("MicroMsg.SnsCdnDownloadBase", "pennqin, delete sns thumb: [%s].", new Object[] { localObject1 });
          i.deleteFile((String)localObject1);
          i += 1;
        }
      }
      localObject1 = this.wLz.wEY + this.wLz.dut();
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
        localObject1 = af.dtp();
        localObject3 = this.wLz.mediaId;
        if (bt.isNullOrNil((String)localObject3)) {
          continue;
        }
        localObject1 = (b.c)((com.tencent.mm.plugin.sns.model.b)localObject1).wDB.get(localObject3);
        if ((localObject1 != null) && (!((b.c)localObject1).wDG)) {
          ((b.c)localObject1).setStartTime(l3);
        }
      }
      catch (Exception localException)
      {
        long l2;
        long l1;
        ad.e("MicroMsg.SnsCdnDownloadBase", "exception msg: %s.", new Object[] { localException.getMessage() });
        continue;
        if (!((bc)localObject4).equals(bc.Fzy)) {
          continue;
        }
        localObject2 = "album_friend";
        continue;
        if (!((bc)localObject4).equals(bc.Fzz)) {
          continue;
        }
        localObject2 = "album_self";
        continue;
        if (!((bc)localObject4).equals(bc.FzA)) {
          continue;
        }
        localObject2 = "album_stranger";
        continue;
        if (!((bc)localObject4).equals(bc.FzB)) {
          continue;
        }
        localObject2 = "profile_friend";
        continue;
        if (!((bc)localObject4).equals(bc.FzC)) {
          continue;
        }
        localObject2 = "profile_stranger";
        continue;
        if (!((bc)localObject4).equals(bc.FzD)) {
          continue;
        }
        localObject2 = "comment";
        continue;
        if (!((bc)localObject4).equals(bc.Fzx)) {
          continue;
        }
        localObject2 = "timeline";
        continue;
        this.wLz.url = apd(this.wLz.url);
        continue;
        localObject2 = "SnsAlbumDomainList";
        continue;
        localObject3 = "SnsAlbumMainStandbyIpSwitchTime";
        continue;
      }
      i = 0;
      if (this.wLz.wBh != null) {
        i = this.wLz.wBh.size();
      }
      ad.d("MicroMsg.SnsCdnDownloadBase", "to downloadBitmap pack.mediaId: " + this.wLz.mediaId + " pack.mediaObjs.size: " + i + " pack.snsId: " + this.wLz.dpC + " pack.isthumb: " + this.wLz.wLs + " type: " + this.wLz.wLu);
      localObject4 = this.wLz.wLv;
      localObject1 = "";
      if (localObject4 != null) {
        continue;
      }
      localObject1 = "";
      localObject3 = localObject1;
      if (!bt.isNullOrNil((String)localObject1)) {
        localObject3 = "&scene=".concat(String.valueOf(localObject1));
      }
      str = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.CpK), p.getString(af.dtb()), Integer.valueOf(com.tencent.mm.sdk.platformtools.ay.getNetTypeForStat(aj.getContext())), Integer.valueOf(com.tencent.mm.sdk.platformtools.ay.getStrength(aj.getContext())), localObject3 });
      if (9 != this.wLz.wLu) {
        continue;
      }
      this.wLz.url = b(this.wLz.url, (bpi)this.wLz.wBh.get(0));
      this.dnsCostTime = bt.eGO();
      if (!this.wLz.wLt) {
        continue;
      }
      localObject1 = "SnsSightDomainList";
      if (!this.wLz.wLt) {
        continue;
      }
      localObject3 = "SnsSightMainStandbyIpSwitchTime";
      localObject1 = com.tencent.mm.m.g.Zd().getValue((String)localObject1);
      l2 = com.tencent.mm.m.g.Zd().getInt((String)localObject3, 0);
      ad.i("MicroMsg.SnsCdnDownloadBase", "pack.isAlbum %s pack.isthumb %s hostvalue %s dcipTime %s", new Object[] { Boolean.valueOf(this.wLz.wLt), Boolean.valueOf(this.wLz.wLs), localObject1, Long.valueOf(l2) });
      l1 = l2;
      if (l2 <= 0L) {
        l1 = 259200L;
      }
      bool = a((bc)localObject4, this.wLz.url, l1, (String)localObject1);
      this.dnsCostTime = bt.vM(this.dnsCostTime);
      if (9 != this.wLz.wLu) {
        break label1016;
      }
      localObject1 = new com.tencent.mm.i.f();
      i = 0;
      if (i >= this.wLz.wBh.size()) {
        break label958;
      }
      localObject3 = ((bpi)this.wLz.wBh.valueAt(i)).Id;
      i.aMF(an.iF(af.getAccSnsPath(), (String)localObject3));
      i += 1;
      continue;
      localObject1 = null;
    }
    Object localObject2;
    label958:
    if (a((com.tencent.mm.i.e)localObject2, bool, str))
    {
      ((com.tencent.mm.i.e)localObject2).fnH = new g.a()
      {
        public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(96067);
          if (c.this.wLz == null)
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
              ad.e("MicroMsg.SnsCdnDownloadBase", "download err, retCode: %d reqDownType: %d.", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(c.this.wLz.wLu) });
              com.tencent.mm.network.b.reportFailIp(paramAnonymousd.field_serverIP);
              if (9 != c.this.wLz.wLu) {
                break label1035;
              }
              paramAnonymousString = paramAnonymousd.fnw;
              if ((paramAnonymousString != null) && (paramAnonymousString.length > 0))
              {
                h.vKh.dB(1040, 12);
                paramAnonymousc = (com.tencent.mm.i.f)this.wLU;
                ad.e("MicroMsg.SnsCdnDownloadBase", "download err, taskInfo2 need inc counter, before: %d, inc: %d, count: %d.", new Object[] { Integer.valueOf(paramAnonymousc.fnF), Integer.valueOf(paramAnonymousString.length), Integer.valueOf(paramAnonymousc.fnE) });
                paramAnonymousc.fnF += paramAnonymousString.length;
                j = paramAnonymousString.length;
                i = 0;
                while (i < j)
                {
                  localObject = paramAnonymousString[i];
                  if (((CdnLogic.BatchSnsReqImageData)localObject).retry)
                  {
                    k = ((CdnLogic.BatchSnsReqImageData)localObject).picIndex;
                    localObject = (bpi)c.this.wLz.wBh.get(k);
                    localm = (com.tencent.mm.plugin.sns.data.m)c.this.wLz.wAw.get(k);
                    af.dtp().a((bpi)localObject, 1, localm, c.this.wLz.wLv, paramAnonymousc.dpC);
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
            c.this.b(paramAnonymousd);
            af.czA().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96066);
                if (9 == c.this.wLz.wLu)
                {
                  if (((com.tencent.mm.i.f)c.1.this.wLU).UE()) {
                    c.duA().remove(c.this.wLz.wFc);
                  }
                  ad.i("MicroMsg.SnsCdnDownloadBase", "download done result: %d, url:%s, mediaID:%s, totalSize: %d, runningTasksSize: %d", new Object[] { Integer.valueOf(i), c.this.wLz.url, c.this.wLz.mediaId, Long.valueOf(paramAnonymousd.field_fileLength), Integer.valueOf(c.duA().size()) });
                  if ((!c.this.wLz.wLs) || (i == 2)) {
                    break label553;
                  }
                  if (9 != c.this.wLz.wLu) {
                    break label511;
                  }
                  com.tencent.mm.plugin.sns.model.ay.ey(((bpi)c.this.wLz.wBh.get(paramAnonymousd.index)).Id, c.this.wLz.mediaType);
                  c.this.Mz(paramAnonymousd.index);
                }
                Object localObject1;
                Object localObject2;
                long l;
                for (;;)
                {
                  if (9 != c.this.wLz.wLu) {
                    break label671;
                  }
                  localObject1 = (bpi)c.this.wLz.wBh.get(paramAnonymousd.index);
                  localObject2 = (com.tencent.mm.i.f)c.1.this.wLU;
                  if ((((com.tencent.mm.i.f)localObject2).UE()) && (!((com.tencent.mm.i.f)localObject2).fnG))
                  {
                    ((com.tencent.mm.i.f)localObject2).fnG = true;
                    l = bt.vM(c.1.this.wLV);
                    ad.d("MicroMsg.SnsCdnDownloadBase", "group download, feed cost: %d.", new Object[] { Long.valueOf(l) });
                    h.vKh.m(1040L, 3L, l);
                    h.vKh.dB(1040, 4);
                    h.vKh.m(1040L, 9L, l);
                    h.vKh.m(1040L, 10L, ((com.tencent.mm.i.f)localObject2).fnE);
                  }
                  c.this.wLx.a(i, (bpi)localObject1, c.this.wLz.wLu, c.this.wLz.wLs, c.this.wLz.wFc, (int)paramAnonymousd.field_fileLength, paramAnonymousd.index, ((com.tencent.mm.i.f)localObject2).UE());
                  AppMethodBeat.o(96066);
                  return;
                  c.duA().remove(c.this.wLz.wFc);
                  break;
                  label511:
                  com.tencent.mm.plugin.sns.model.ay.ey(c.this.wLz.mediaId, c.this.wLz.mediaType);
                  c.this.duy();
                  continue;
                  label553:
                  if ((!c.this.wLz.wLs) && ((c.this.wLz.wLu == 4) || (c.this.wLz.wLu == 6)))
                  {
                    localObject1 = c.this.wLz.getPath() + q.i(c.this.dyS);
                    af.dtr().iC(c.this.wLz.mediaId, (String)localObject1);
                  }
                }
                label671:
                if (1 == c.this.wLz.wLu)
                {
                  localObject1 = af.dtp();
                  localObject2 = c.this.wLz.mediaId;
                  if (((com.tencent.mm.plugin.sns.model.b)localObject1).wDC.remove(localObject2))
                  {
                    l = bt.vM(c.1.this.wLV);
                    ad.d("MicroMsg.SnsCdnDownloadBase", "single download cost: %d.", new Object[] { Long.valueOf(l) });
                    h.vKh.m(1040L, 6L, l);
                    h.vKh.dB(1040, 7);
                  }
                }
                if (c.this.wLz.wLu == 4) {
                  ad.i("MicroMsg.SnsCdnDownloadBase", "sight download cost=" + bt.vM(c.1.this.wLV) + ", mediaId=" + c.this.wLz.mediaId);
                }
                c.this.wLx.a(i, c.this.dyS, c.this.wLz.wLu, c.this.wLz.wLs, c.this.wLz.wFc, (int)paramAnonymousd.field_fileLength, -1, true);
                AppMethodBeat.o(96066);
              }
            });
            for (;;)
            {
              if (paramAnonymousInt == 0) {
                break label1028;
              }
              ad.e("MicroMsg.SnsCdnDownloadBase", "task build error! startRet: %d, type: %d.", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(c.this.wLz.wLu) });
              if (9 != c.this.wLz.wLu) {
                break label1028;
              }
              h.vKh.dB(1040, 13);
              c.duA().remove(c.this.wLz.wFc);
              c.this.wLx.a(2, null, c.this.wLz.wLu, c.this.wLz.wLs, c.this.wLz.wFc, -1, -1, true);
              paramAnonymousString = (com.tencent.mm.i.f)this.wLU;
              paramAnonymousc = paramAnonymousString.fnw;
              i = paramAnonymousc.length;
              paramAnonymousInt = 0;
              while (paramAnonymousInt < i)
              {
                j = paramAnonymousc[paramAnonymousInt].picIndex;
                paramAnonymousd = (bpi)c.this.wLz.wBh.get(j);
                localObject = (com.tencent.mm.plugin.sns.data.m)c.this.wLz.wAw.get(j);
                af.dtp().a(paramAnonymousd, 1, (com.tencent.mm.plugin.sns.data.m)localObject, c.this.wLz.wLv, paramAnonymousString.dpC);
                ad.i("MicroMsg.SnsCdnDownloadBase", "group download err, retry single download. index: %d.", new Object[] { Integer.valueOf(j) });
                paramAnonymousInt += 1;
              }
              h.vKh.dB(1040, 14);
              ad.e("MicroMsg.SnsCdnDownloadBase", "download error, totally re-download by single.");
              paramAnonymousString = (com.tencent.mm.i.f)this.wLU;
              paramAnonymousString.fnF = paramAnonymousString.fnE;
              paramAnonymousc = paramAnonymousString.fnw;
              j = paramAnonymousc.length;
              i = 0;
              while (i < j)
              {
                k = paramAnonymousc[i].picIndex;
                localObject = (bpi)c.this.wLz.wBh.get(k);
                localm = (com.tencent.mm.plugin.sns.data.m)c.this.wLz.wAw.get(k);
                af.dtp().a((bpi)localObject, 1, localm, c.this.wLz.wLv, paramAnonymousString.dpC);
                ad.i("MicroMsg.SnsCdnDownloadBase", "group download err, retry single download. index: %d.", new Object[] { Integer.valueOf(k) });
                i += 1;
              }
              i = 2;
              break;
              ad.d("MicroMsg.SnsCdnDownloadBase", "download succ, type: %d.", new Object[] { Integer.valueOf(c.this.wLz.wLu) });
              c.this.wLS = ((int)paramAnonymousd.field_fileLength);
              if (9 == c.this.wLz.wLu)
              {
                paramAnonymousString = (com.tencent.mm.i.f)this.wLU;
                paramAnonymousString.fnF += 1;
                ad.d("MicroMsg.SnsCdnDownloadBase", "download succ, counter++, res: %d, count: %d.", new Object[] { Integer.valueOf(paramAnonymousString.fnF), Integer.valueOf(paramAnonymousString.fnE) });
              }
              for (paramAnonymousBoolean = c.this.My(paramAnonymousd.index);; paramAnonymousBoolean = c.this.duv())
              {
                if (paramAnonymousBoolean) {
                  break label903;
                }
                i = 2;
                break;
              }
              label903:
              if (c.this.wLz.wLs)
              {
                i = 3;
                break;
              }
              i = 1;
              break;
              if (paramAnonymousc != null)
              {
                float f = (float)paramAnonymousc.field_finishedLength / (float)paramAnonymousc.field_toltalLength;
                if (c.this.wLz.wLw < f)
                {
                  c.this.wLz.wLw = f;
                  ad.d("MicroMsg.SnsCdnDownloadBase", "Download sns image type: %d, mediaId: %s, progress: %f, url: %s", new Object[] { Integer.valueOf(c.this.wLz.wLu), paramAnonymousString, Float.valueOf(f), c.this.wLz.url });
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
      if (com.tencent.mm.ao.f.awL().b((com.tencent.mm.i.g)localObject2, -1)) {
        ad.i("MicroMsg.SnsCdnDownloadBase", "SubCoreCdnTransport addRecvTask suc");
      }
    }
    for (int i = 1;; i = 2)
    {
      return Integer.valueOf(i);
      label1016:
      i.aMF(this.wLz.getPath());
      localObject2 = new com.tencent.mm.i.e();
      break;
      ad.w("MicroMsg.SnsCdnDownloadBase", "SubCoreCdnTransport addRecvTask failed");
    }
  }
  
  public void duy()
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
      label133:
      localObject1 = null;
      if (this.wLz.wAv.wBd != 0) {
        break label597;
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
        break label133;
      }
      if (this.wLz.wAv.list.size() <= 1)
      {
        af.dtr().a(this.wLz.mediaId, this.wLy, this.wLz.wAv.wBd);
        break label133;
      }
      af.dtr().a(this.wLz.mediaId, this.wLy, 0);
      localObject1 = new LinkedList();
      int i = 0;
      for (;;)
      {
        if ((i >= this.wLz.wAv.list.size()) || (i >= 4)) {
          break label504;
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
      label504:
      this.wLy = n.D(q.s((List)localObject1, af.dtE()));
      ad.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap " + this.wLz.wAv.dnB + " " + this.wLy);
      af.dtr().a(this.wLz.wAv.dnB, this.wLy, this.wLz.wAv.wBd);
      break label133;
      label597:
      if (this.wLz.wAv.wBd == 1) {
        localObject1 = "1-" + this.wLz.wAv.dnB;
      } else if (this.wLz.wAv.wBd == 4) {
        localObject1 = "4-" + this.wLz.wAv.dnB;
      } else if (this.wLz.wAv.wBd == 5) {
        localObject1 = "5-" + this.wLz.wAv.dnB;
      } else if (this.wLz.wAv.wBd == 3) {
        localObject1 = q.bO(3, this.wLz.wAv.dnB);
      }
    }
  }
  
  public final void duz()
  {
    if (this.wLz != null) {
      ad.i("MicroMsg.SnsCdnDownloadBase", "checkCdnPath: %s", new Object[] { Boolean.valueOf(i.aMF(this.wLz.getPath())) });
    }
  }
  
  protected abstract int getMediaType();
  
  public void onPostExecute(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, bpi parambpi, int paramInt2, boolean paramBoolean1, String paramString, int paramInt3, int paramInt4, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.c
 * JD-Core Version:    0.7.0.1
 */