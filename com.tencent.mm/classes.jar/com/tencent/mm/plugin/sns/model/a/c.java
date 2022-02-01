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
import com.tencent.mm.plugin.sns.model.az;
import com.tencent.mm.plugin.sns.model.b.c;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bf;
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
  private static HashSet<String> xYw = new HashSet();
  private long dnsCostTime = -1L;
  protected btz dwE = null;
  private String host = "";
  private int ili = -1;
  protected a xYd;
  protected n xYe = null;
  protected a xYf = null;
  int xYy = 0;
  protected SparseArray<n> xYz = new SparseArray();
  
  public c(a parama, a parama1)
  {
    this.xYd = parama;
    this.xYf = parama1;
    if (parama1 == null) {
      return;
    }
    this.dwE = parama1.xRy;
    xYw.add(parama1.xRx);
    parama1.init();
  }
  
  private boolean a(com.tencent.mm.i.e parame, boolean paramBoolean, String paramString)
  {
    for (;;)
    {
      try
      {
        this.host = new URL(this.xYf.url).getHost();
        ArrayList localArrayList1 = new ArrayList();
        this.ili = com.tencent.mm.network.b.a(this.host, false, localArrayList1);
        ArrayList localArrayList2 = new ArrayList();
        int j = com.tencent.mm.network.b.a(this.host, true, localArrayList2);
        Object localObject;
        if (9 == this.xYf.xYa)
        {
          parame.field_mediaId = (this.xYf.dnn + "_" + this.xYf.xYa);
          if ((parame instanceof com.tencent.mm.i.f))
          {
            com.tencent.mm.i.f localf = (com.tencent.mm.i.f)parame;
            localf.dnn = this.xYf.dnn;
            localf.fqX = this.xYf.size;
            localf.fqY = this.xYf.xNC.size();
            localf.fqQ = new CdnLogic.BatchSnsReqImageData[localf.fqY];
            int i = 0;
            if (i < localf.fqY)
            {
              int k = this.xYf.xNC.keyAt(i);
              btz localbtz = (btz)this.xYf.xNC.get(k);
              CdnLogic.BatchSnsReqImageData localBatchSnsReqImageData = new CdnLogic.BatchSnsReqImageData();
              String str = localbtz.Fjh;
              localObject = str;
              if (bs.isNullOrNil(str))
              {
                localObject = str;
                if (localbtz.ndI == 2) {
                  localObject = localbtz.Url;
                }
              }
              localBatchSnsReqImageData.url = b((String)localObject, localbtz);
              localBatchSnsReqImageData.picIndex = k;
              localBatchSnsReqImageData.totalFileSize = 0;
              localBatchSnsReqImageData.decryptKey = localbtz.FjB;
              localObject = new StringBuilder();
              str = localbtz.Id;
              localBatchSnsReqImageData.imageCachePath = i.k(an.jc(af.getAccSnsPath(), str) + q.m(localbtz), false);
              localBatchSnsReqImageData.fileKey = (localbtz.Id + "_" + this.xYf.xYa);
              localf.fqQ[i] = localBatchSnsReqImageData;
              i += 1;
              continue;
            }
          }
        }
        else
        {
          parame.field_mediaId = (this.xYf.mediaId + "_" + this.xYf.xYa);
          parame.fqS = (this.xYf.getPath() + this.xYf.dIT());
          if (this.xYf.xRy != null)
          {
            if (!this.xYf.xXY) {
              continue;
            }
            localObject = this.xYf.xRy.FjB;
            parame.snsCipherKey = ((String)localObject);
          }
        }
        parame.url = this.xYf.url;
        parame.host = this.host;
        parame.referer = paramString;
        parame.fqT = dz(localArrayList1);
        parame.fqU = dz(localArrayList2);
        parame.fqV = this.ili;
        parame.fqW = j;
        parame.isColdSnsData = paramBoolean;
        parame.signalQuality = ax.getStrength(ai.getContext());
        parame.snsScene = this.xYf.xYb.tag;
        if (this.xYf.xYa == 8)
        {
          parame.eyd = 3;
          parame.appType = 109;
          parame.fileType = 20204;
          ac.i("MicroMsg.SnsCdnDownloadBase", "attachSnsImgTaskInfo reqDownType:%d taskInfo:%s", new Object[] { Integer.valueOf(this.xYf.xYa), parame });
          return true;
          localObject = this.xYf.xRy.Fjy;
          continue;
        }
        if ((this.xYf.xYa == 6) || (this.xYf.xYa == 4))
        {
          parame.eyd = 3;
          parame.appType = 105;
          parame.fileType = 20210;
          continue;
        }
        if (this.xYf.xYa != 5) {
          break label810;
        }
      }
      catch (MalformedURLException parame)
      {
        ac.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", parame, "", new Object[0]);
        ac.w("MicroMsg.SnsCdnDownloadBase", "attachSnsImgTaskInfo fail:".concat(String.valueOf(parame)));
        return false;
      }
      parame.eyd = 3;
      parame.appType = 150;
      parame.fileType = 20250;
      continue;
      label810:
      if ((this.xYf.xYa == 2) || (this.xYf.xYa == 1) || (this.xYf.xYa == 3) || (this.xYf.xYa == 9))
      {
        parame.eyd = 3;
        parame.appType = 100;
        parame.fileType = 20201;
        if ((this.xYf.xYa == 1) && ((this.xYf.url.startsWith("http://wxapp.tc.qq.com")) || (this.xYf.url.startsWith("https://wxapp.tc.qq.com"))) && (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pWq, 1) == 1))
        {
          parame.eyd = 3;
          parame.appType = 150;
          parame.fileType = 20201;
        }
      }
    }
  }
  
  public static boolean aur(String paramString)
  {
    if (xYw.contains(q.bT(1, paramString))) {}
    while (xYw.contains(q.bT(5, paramString))) {
      return true;
    }
    return false;
  }
  
  private static String[] dz(List<String> paramList)
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
  
  public boolean OA(int paramInt)
  {
    return false;
  }
  
  public final void OB(int paramInt)
  {
    if (af.dHA()) {
      return;
    }
    Object localObject = (com.tencent.mm.plugin.sns.data.m)this.xYf.xMP.get(paramInt);
    btz localbtz = (btz)this.xYf.xNC.get(paramInt);
    ac.i("MicroMsg.SnsCdnDownloadBase", "thumbAddDecode index: %d decodeType: %d.", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((com.tencent.mm.plugin.sns.data.m)localObject).xNy) });
    af.dHO().a(localbtz.Id, (n)this.xYz.get(paramInt), ((com.tencent.mm.plugin.sns.data.m)localObject).xNy);
    if (((com.tencent.mm.plugin.sns.data.m)localObject).xNy == 0) {}
    for (localObject = q.bS(0, ((com.tencent.mm.plugin.sns.data.m)localObject).dlj);; localObject = null)
    {
      ac.i("MicroMsg.SnsCdnDownloadBase", "thumbAddDecode cacheName: %s.", new Object[] { localObject });
      af.dHO().atG((String)localObject);
      return;
    }
  }
  
  public boolean a(bf parambf, String paramString1, long paramLong, String paramString2)
  {
    if (paramString1 == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramString1 = new URL(paramString1);
        if ((parambf != null) && (paramString2 != null) && (paramString2.indexOf(paramString1.getHost()) != -1) && (parambf.gIh != 0))
        {
          long l = bs.pN(parambf.gIh);
          if (l > paramLong) {
            return true;
          }
        }
      }
      catch (Exception parambf)
      {
        ac.e("MicroMsg.SnsCdnDownloadBase", "error for check dcip %s", new Object[] { parambf.getMessage() });
      }
    }
    return false;
  }
  
  public String aup(String paramString)
  {
    return paramString;
  }
  
  public String b(String paramString, btz parambtz)
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
      localObject2 = com.tencent.mm.model.c.d.aAp().tJ((String)localObject1);
      if (((com.tencent.mm.storage.c)localObject2).isValid())
      {
        i = bs.getInt((String)((com.tencent.mm.storage.c)localObject2).eYV().get("needUploadData"), 1);
        str = ((com.tencent.mm.storage.c)localObject2).field_expId;
      }
      break;
    }
    while (i != 0)
    {
      if (this.xYf.xYa == 8) {
        i = 1;
      }
      for (;;)
      {
        label110:
        localObject2 = new com.tencent.mm.modelsns.f();
        ((com.tencent.mm.modelsns.f)localObject2).n("20ImgSize", paramd.field_fileLength + ",");
        StringBuilder localStringBuilder = new StringBuilder();
        int j;
        if (ax.isWifi(ai.getContext()))
        {
          j = 1;
          label170:
          ((com.tencent.mm.modelsns.f)localObject2).n("21NetType", j + ",");
          ((com.tencent.mm.modelsns.f)localObject2).n("22DelayTime", paramd.field_delayTime + ",");
          ((com.tencent.mm.modelsns.f)localObject2).n("23RetCode", paramd.field_retCode + ",");
          ((com.tencent.mm.modelsns.f)localObject2).n("24DnsCostTime", paramd.field_dnsCostTime + ",");
          ((com.tencent.mm.modelsns.f)localObject2).n("25ConnectCostTime", paramd.field_connectCostTime + ",");
          ((com.tencent.mm.modelsns.f)localObject2).n("26SendCostTime", ",");
          ((com.tencent.mm.modelsns.f)localObject2).n("27WaitResponseCostTime", paramd.field_waitResponseCostTime + ",");
          ((com.tencent.mm.modelsns.f)localObject2).n("28ReceiveCostTime", paramd.field_receiveCostTime + ",");
          ((com.tencent.mm.modelsns.f)localObject2).n("29ClientAddrIP(uint)", paramd.field_clientHostIP + ",");
          ((com.tencent.mm.modelsns.f)localObject2).n("30ServerAddrIP(uint)", paramd.field_serverHostIP + ",");
          ((com.tencent.mm.modelsns.f)localObject2).n("31dnstype", this.ili + ",");
          ((com.tencent.mm.modelsns.f)localObject2).n("32signal(int)", ax.getStrength(ai.getContext()) + ",");
          ((com.tencent.mm.modelsns.f)localObject2).n("33host(string)", this.host + ",");
          ((com.tencent.mm.modelsns.f)localObject2).n("34MediaType", k + ",");
          ((com.tencent.mm.modelsns.f)localObject2).n("35X_Errno(string)", paramd.field_xErrorNo + ",");
          ((com.tencent.mm.modelsns.f)localObject2).n("36MaxPackageSize", ",");
          ((com.tencent.mm.modelsns.f)localObject2).n("37MaxPackageTimeStamp", ",");
          ((com.tencent.mm.modelsns.f)localObject2).n("38PackageRecordList", ",");
          ((com.tencent.mm.modelsns.f)localObject2).n("39ExpLayerId", (String)localObject1 + ",");
          ((com.tencent.mm.modelsns.f)localObject2).n("40ExpId", str + ",");
          ((com.tencent.mm.modelsns.f)localObject2).n("41FeedId", ",");
          ((com.tencent.mm.modelsns.f)localObject2).n("42BizType", i + ",");
          ((com.tencent.mm.modelsns.f)localObject2).n("43CSeqCheck(uint)", paramd.field_cSeqCheck + ",");
          localObject1 = new StringBuilder();
          if (!paramd.field_usePrivateProtocol) {
            break label993;
          }
        }
        label993:
        for (i = 1;; i = 0)
        {
          ((com.tencent.mm.modelsns.f)localObject2).n("44isPrivate(uint)", i + ",");
          ac.i("MicroMsg.SnsCdnDownloadBase", "report logbuffer(13480 TLMediaFielDownloadRecord): " + ((com.tencent.mm.modelsns.f)localObject2).PS());
          h.wUl.f(13480, new Object[] { localObject2 });
          if ((paramd.field_retCode == 200) || (paramd.field_retCode == 0)) {
            break;
          }
          h.wUl.f(14071, new Object[] { localObject2 });
          return;
          localObject1 = "100106";
          break label46;
          localObject1 = "100100";
          break label46;
          if ((this.xYf.xYa == 6) || (this.xYf.xYa == 4))
          {
            i = 2;
            break label110;
          }
          if (this.xYf.xYa == 5)
          {
            i = 4;
            break label110;
          }
          if ((this.xYf.xYa != 2) && (this.xYf.xYa != 1) && (this.xYf.xYa != 3)) {
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
  
  public ExecutorService dBu()
  {
    return af.dHB();
  }
  
  public boolean dIU()
  {
    return true;
  }
  
  public abstract boolean dIV();
  
  public Integer dIX()
  {
    com.tencent.mm.kernel.g.agS();
    if ((!com.tencent.mm.kernel.g.agR().isSDCardAvailable()) || (this.xYf == null)) {
      return Integer.valueOf(2);
    }
    Object localObject1;
    Object localObject3;
    Object localObject4;
    if (dIU())
    {
      if (9 == this.xYf.xYa)
      {
        i = 0;
        while (i < this.xYf.xNC.size())
        {
          localObject1 = (btz)this.xYf.xNC.valueAt(i);
          localObject3 = new StringBuilder();
          localObject4 = ((btz)localObject1).Id;
          localObject1 = an.jc(af.getAccSnsPath(), (String)localObject4) + q.m((btz)localObject1);
          ac.i("MicroMsg.SnsCdnDownloadBase", "pennqin, delete sns thumb: [%s].", new Object[] { localObject1 });
          i.deleteFile((String)localObject1);
          i += 1;
        }
      }
      localObject1 = this.xYf.xRt + this.xYf.dIT();
      ac.i("MicroMsg.SnsCdnDownloadBase", "[tomys] delete img: %s", new Object[] { localObject1 });
      i.deleteFile((String)localObject1);
    }
    final long l3 = System.currentTimeMillis();
    String str;
    boolean bool;
    for (;;)
    {
      try
      {
        localObject1 = af.dHM();
        localObject3 = this.xYf.mediaId;
        if (bs.isNullOrNil((String)localObject3)) {
          continue;
        }
        localObject1 = (b.c)((com.tencent.mm.plugin.sns.model.b)localObject1).xPW.get(localObject3);
        if ((localObject1 != null) && (!((b.c)localObject1).xQb)) {
          ((b.c)localObject1).setStartTime(l3);
        }
      }
      catch (Exception localException)
      {
        long l2;
        long l1;
        ac.e("MicroMsg.SnsCdnDownloadBase", "exception msg: %s.", new Object[] { localException.getMessage() });
        continue;
        if (!((bf)localObject4).equals(bf.GYA)) {
          continue;
        }
        localObject2 = "album_friend";
        continue;
        if (!((bf)localObject4).equals(bf.GYB)) {
          continue;
        }
        localObject2 = "album_self";
        continue;
        if (!((bf)localObject4).equals(bf.GYC)) {
          continue;
        }
        localObject2 = "album_stranger";
        continue;
        if (!((bf)localObject4).equals(bf.GYD)) {
          continue;
        }
        localObject2 = "profile_friend";
        continue;
        if (!((bf)localObject4).equals(bf.GYE)) {
          continue;
        }
        localObject2 = "profile_stranger";
        continue;
        if (!((bf)localObject4).equals(bf.GYF)) {
          continue;
        }
        localObject2 = "comment";
        continue;
        if (!((bf)localObject4).equals(bf.GYz)) {
          continue;
        }
        localObject2 = "timeline";
        continue;
        this.xYf.url = aup(this.xYf.url);
        continue;
        localObject2 = "SnsAlbumDomainList";
        continue;
        localObject3 = "SnsAlbumMainStandbyIpSwitchTime";
        continue;
      }
      i = 0;
      if (this.xYf.xNC != null) {
        i = this.xYf.xNC.size();
      }
      ac.d("MicroMsg.SnsCdnDownloadBase", "to downloadBitmap pack.mediaId: " + this.xYf.mediaId + " pack.mediaObjs.size: " + i + " pack.snsId: " + this.xYf.dnn + " pack.isthumb: " + this.xYf.xXY + " type: " + this.xYf.xYa);
      localObject4 = this.xYf.xYb;
      localObject1 = "";
      if (localObject4 != null) {
        continue;
      }
      localObject1 = "";
      localObject3 = localObject1;
      if (!bs.isNullOrNil((String)localObject1)) {
        localObject3 = "&scene=".concat(String.valueOf(localObject1));
      }
      str = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.DIc), p.getString(af.dHy()), Integer.valueOf(ax.getNetTypeForStat(ai.getContext())), Integer.valueOf(ax.getStrength(ai.getContext())), localObject3 });
      if (9 != this.xYf.xYa) {
        continue;
      }
      this.xYf.url = b(this.xYf.url, (btz)this.xYf.xNC.get(0));
      this.dnsCostTime = bs.eWj();
      if (!this.xYf.xXZ) {
        continue;
      }
      localObject1 = "SnsSightDomainList";
      if (!this.xYf.xXZ) {
        continue;
      }
      localObject3 = "SnsSightMainStandbyIpSwitchTime";
      localObject1 = com.tencent.mm.m.g.ZY().getValue((String)localObject1);
      l2 = com.tencent.mm.m.g.ZY().getInt((String)localObject3, 0);
      ac.i("MicroMsg.SnsCdnDownloadBase", "pack.isAlbum %s pack.isthumb %s hostvalue %s dcipTime %s", new Object[] { Boolean.valueOf(this.xYf.xXZ), Boolean.valueOf(this.xYf.xXY), localObject1, Long.valueOf(l2) });
      l1 = l2;
      if (l2 <= 0L) {
        l1 = 259200L;
      }
      bool = a((bf)localObject4, this.xYf.url, l1, (String)localObject1);
      this.dnsCostTime = bs.Ap(this.dnsCostTime);
      if (9 != this.xYf.xYa) {
        break label1016;
      }
      localObject1 = new com.tencent.mm.i.f();
      i = 0;
      if (i >= this.xYf.xNC.size()) {
        break label958;
      }
      localObject3 = ((btz)this.xYf.xNC.valueAt(i)).Id;
      i.aSh(an.jc(af.getAccSnsPath(), (String)localObject3));
      i += 1;
      continue;
      localObject1 = null;
    }
    Object localObject2;
    label958:
    if (a((com.tencent.mm.i.e)localObject2, bool, str))
    {
      ((com.tencent.mm.i.e)localObject2).frb = new g.a()
      {
        public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(96067);
          if (c.this.xYf == null)
          {
            ac.e("MicroMsg.SnsCdnDownloadBase", "pack is null.");
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
              ac.e("MicroMsg.SnsCdnDownloadBase", "download err, retCode: %d reqDownType: %d.", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(c.this.xYf.xYa) });
              com.tencent.mm.network.b.reportFailIp(paramAnonymousd.field_serverIP);
              if (9 != c.this.xYf.xYa) {
                break label1035;
              }
              paramAnonymousString = paramAnonymousd.fqQ;
              if ((paramAnonymousString != null) && (paramAnonymousString.length > 0))
              {
                h.wUl.dB(1040, 12);
                paramAnonymousc = (com.tencent.mm.i.f)this.xYA;
                ac.e("MicroMsg.SnsCdnDownloadBase", "download err, taskInfo2 need inc counter, before: %d, inc: %d, count: %d.", new Object[] { Integer.valueOf(paramAnonymousc.fqZ), Integer.valueOf(paramAnonymousString.length), Integer.valueOf(paramAnonymousc.fqY) });
                paramAnonymousc.fqZ += paramAnonymousString.length;
                j = paramAnonymousString.length;
                i = 0;
                while (i < j)
                {
                  localObject = paramAnonymousString[i];
                  if (((CdnLogic.BatchSnsReqImageData)localObject).retry)
                  {
                    k = ((CdnLogic.BatchSnsReqImageData)localObject).picIndex;
                    localObject = (btz)c.this.xYf.xNC.get(k);
                    localm = (com.tencent.mm.plugin.sns.data.m)c.this.xYf.xMP.get(k);
                    af.dHM().a((btz)localObject, 1, localm, c.this.xYf.xYb, paramAnonymousc.dnn);
                    ac.i("MicroMsg.SnsCdnDownloadBase", "group download err, retry single download. index: %d.", new Object[] { Integer.valueOf(k) });
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
            af.cMM().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96066);
                if (9 == c.this.xYf.xYa)
                {
                  if (((com.tencent.mm.i.f)c.1.this.xYA).Vz()) {
                    c.dJa().remove(c.this.xYf.xRx);
                  }
                  ac.i("MicroMsg.SnsCdnDownloadBase", "download done result: %d, url:%s, mediaID:%s, totalSize: %d, runningTasksSize: %d", new Object[] { Integer.valueOf(i), c.this.xYf.url, c.this.xYf.mediaId, Long.valueOf(paramAnonymousd.field_fileLength), Integer.valueOf(c.dJa().size()) });
                  if ((!c.this.xYf.xXY) || (i == 2)) {
                    break label553;
                  }
                  if (9 != c.this.xYf.xYa) {
                    break label511;
                  }
                  az.eG(((btz)c.this.xYf.xNC.get(paramAnonymousd.index)).Id, c.this.xYf.mediaType);
                  c.this.OB(paramAnonymousd.index);
                }
                Object localObject1;
                Object localObject2;
                long l;
                for (;;)
                {
                  if (9 != c.this.xYf.xYa) {
                    break label671;
                  }
                  localObject1 = (btz)c.this.xYf.xNC.get(paramAnonymousd.index);
                  localObject2 = (com.tencent.mm.i.f)c.1.this.xYA;
                  if ((((com.tencent.mm.i.f)localObject2).Vz()) && (!((com.tencent.mm.i.f)localObject2).fra))
                  {
                    ((com.tencent.mm.i.f)localObject2).fra = true;
                    l = bs.Ap(c.1.this.xYB);
                    ac.d("MicroMsg.SnsCdnDownloadBase", "group download, feed cost: %d.", new Object[] { Long.valueOf(l) });
                    h.wUl.n(1040L, 3L, l);
                    h.wUl.dB(1040, 4);
                    h.wUl.n(1040L, 9L, l);
                    h.wUl.n(1040L, 10L, ((com.tencent.mm.i.f)localObject2).fqY);
                  }
                  c.this.xYd.a(i, (btz)localObject1, c.this.xYf.xYa, c.this.xYf.xXY, c.this.xYf.xRx, (int)paramAnonymousd.field_fileLength, paramAnonymousd.index, ((com.tencent.mm.i.f)localObject2).Vz());
                  AppMethodBeat.o(96066);
                  return;
                  c.dJa().remove(c.this.xYf.xRx);
                  break;
                  label511:
                  az.eG(c.this.xYf.mediaId, c.this.xYf.mediaType);
                  c.this.dIY();
                  continue;
                  label553:
                  if ((!c.this.xYf.xXY) && ((c.this.xYf.xYa == 4) || (c.this.xYf.xYa == 6)))
                  {
                    localObject1 = c.this.xYf.getPath() + q.i(c.this.dwE);
                    af.dHO().iZ(c.this.xYf.mediaId, (String)localObject1);
                  }
                }
                label671:
                if (1 == c.this.xYf.xYa)
                {
                  localObject1 = af.dHM();
                  localObject2 = c.this.xYf.mediaId;
                  if (((com.tencent.mm.plugin.sns.model.b)localObject1).xPX.remove(localObject2))
                  {
                    l = bs.Ap(c.1.this.xYB);
                    ac.d("MicroMsg.SnsCdnDownloadBase", "single download cost: %d.", new Object[] { Long.valueOf(l) });
                    h.wUl.n(1040L, 6L, l);
                    h.wUl.dB(1040, 7);
                  }
                }
                if (c.this.xYf.xYa == 4) {
                  ac.i("MicroMsg.SnsCdnDownloadBase", "sight download cost=" + bs.Ap(c.1.this.xYB) + ", mediaId=" + c.this.xYf.mediaId);
                }
                c.this.xYd.a(i, c.this.dwE, c.this.xYf.xYa, c.this.xYf.xXY, c.this.xYf.xRx, (int)paramAnonymousd.field_fileLength, -1, true);
                AppMethodBeat.o(96066);
              }
            });
            for (;;)
            {
              if (paramAnonymousInt == 0) {
                break label1028;
              }
              ac.e("MicroMsg.SnsCdnDownloadBase", "task build error! startRet: %d, type: %d.", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(c.this.xYf.xYa) });
              if (9 != c.this.xYf.xYa) {
                break label1028;
              }
              h.wUl.dB(1040, 13);
              c.dJa().remove(c.this.xYf.xRx);
              c.this.xYd.a(2, null, c.this.xYf.xYa, c.this.xYf.xXY, c.this.xYf.xRx, -1, -1, true);
              paramAnonymousString = (com.tencent.mm.i.f)this.xYA;
              paramAnonymousc = paramAnonymousString.fqQ;
              i = paramAnonymousc.length;
              paramAnonymousInt = 0;
              while (paramAnonymousInt < i)
              {
                j = paramAnonymousc[paramAnonymousInt].picIndex;
                paramAnonymousd = (btz)c.this.xYf.xNC.get(j);
                localObject = (com.tencent.mm.plugin.sns.data.m)c.this.xYf.xMP.get(j);
                af.dHM().a(paramAnonymousd, 1, (com.tencent.mm.plugin.sns.data.m)localObject, c.this.xYf.xYb, paramAnonymousString.dnn);
                ac.i("MicroMsg.SnsCdnDownloadBase", "group download err, retry single download. index: %d.", new Object[] { Integer.valueOf(j) });
                paramAnonymousInt += 1;
              }
              h.wUl.dB(1040, 14);
              ac.e("MicroMsg.SnsCdnDownloadBase", "download error, totally re-download by single.");
              paramAnonymousString = (com.tencent.mm.i.f)this.xYA;
              paramAnonymousString.fqZ = paramAnonymousString.fqY;
              paramAnonymousc = paramAnonymousString.fqQ;
              j = paramAnonymousc.length;
              i = 0;
              while (i < j)
              {
                k = paramAnonymousc[i].picIndex;
                localObject = (btz)c.this.xYf.xNC.get(k);
                localm = (com.tencent.mm.plugin.sns.data.m)c.this.xYf.xMP.get(k);
                af.dHM().a((btz)localObject, 1, localm, c.this.xYf.xYb, paramAnonymousString.dnn);
                ac.i("MicroMsg.SnsCdnDownloadBase", "group download err, retry single download. index: %d.", new Object[] { Integer.valueOf(k) });
                i += 1;
              }
              i = 2;
              break;
              ac.d("MicroMsg.SnsCdnDownloadBase", "download succ, type: %d.", new Object[] { Integer.valueOf(c.this.xYf.xYa) });
              c.this.xYy = ((int)paramAnonymousd.field_fileLength);
              if (9 == c.this.xYf.xYa)
              {
                paramAnonymousString = (com.tencent.mm.i.f)this.xYA;
                paramAnonymousString.fqZ += 1;
                ac.d("MicroMsg.SnsCdnDownloadBase", "download succ, counter++, res: %d, count: %d.", new Object[] { Integer.valueOf(paramAnonymousString.fqZ), Integer.valueOf(paramAnonymousString.fqY) });
              }
              for (paramAnonymousBoolean = c.this.OA(paramAnonymousd.index);; paramAnonymousBoolean = c.this.dIV())
              {
                if (paramAnonymousBoolean) {
                  break label903;
                }
                i = 2;
                break;
              }
              label903:
              if (c.this.xYf.xXY)
              {
                i = 3;
                break;
              }
              i = 1;
              break;
              if (paramAnonymousc != null)
              {
                float f = (float)paramAnonymousc.field_finishedLength / (float)paramAnonymousc.field_toltalLength;
                if (c.this.xYf.xYc < f)
                {
                  c.this.xYf.xYc = f;
                  ac.d("MicroMsg.SnsCdnDownloadBase", "Download sns image type: %d, mediaId: %s, progress: %f, url: %s", new Object[] { Integer.valueOf(c.this.xYf.xYa), paramAnonymousString, Float.valueOf(f), c.this.xYf.url });
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
      if (com.tencent.mm.an.f.aDD().b((com.tencent.mm.i.g)localObject2, -1)) {
        ac.i("MicroMsg.SnsCdnDownloadBase", "SubCoreCdnTransport addRecvTask suc");
      }
    }
    for (int i = 1;; i = 2)
    {
      return Integer.valueOf(i);
      label1016:
      i.aSh(this.xYf.getPath());
      localObject2 = new com.tencent.mm.i.e();
      break;
      ac.w("MicroMsg.SnsCdnDownloadBase", "SubCoreCdnTransport addRecvTask failed");
    }
  }
  
  public void dIY()
  {
    if (af.dHA()) {
      return;
    }
    System.currentTimeMillis();
    Object localObject1;
    Object localObject2;
    if (this.xYf.xMO.xNy == 4)
    {
      ac.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur thumb");
      localObject1 = q.d(this.dwE);
      localObject2 = q.f(this.dwE);
      this.xYe = com.tencent.mm.plugin.sns.lucky.a.a.iX(this.xYf.getPath() + (String)localObject1, this.xYf.getPath() + (String)localObject2);
      af.dHO().a(this.xYf.mediaId, this.xYe, this.xYf.xMO.xNy);
      label133:
      localObject1 = null;
      if (this.xYf.xMO.xNy != 0) {
        break label597;
      }
      localObject1 = "0-" + this.xYf.xMO.dlj;
    }
    for (;;)
    {
      af.dHO().atG((String)localObject1);
      return;
      if (this.xYf.xMO.xNy == 5)
      {
        ac.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur grid");
        localObject1 = q.d(this.dwE);
        localObject2 = q.g(this.dwE);
        this.xYe = com.tencent.mm.plugin.sns.lucky.a.a.iX(this.xYf.getPath() + (String)localObject1, this.xYf.getPath() + (String)localObject2);
        af.dHO().a(this.xYf.mediaId, this.xYe, this.xYf.xMO.xNy);
        break label133;
      }
      if (this.xYf.xMO.list.size() <= 1)
      {
        af.dHO().a(this.xYf.mediaId, this.xYe, this.xYf.xMO.xNy);
        break label133;
      }
      af.dHO().a(this.xYf.mediaId, this.xYe, 0);
      localObject1 = new LinkedList();
      int i = 0;
      for (;;)
      {
        if ((i >= this.xYf.xMO.list.size()) || (i >= 4)) {
          break label504;
        }
        localObject2 = (btz)this.xYf.xMO.list.get(i);
        n localn = af.dHO().atH(((btz)localObject2).Id);
        if (!q.b(localn)) {
          break;
        }
        ((List)localObject1).add(localn);
        ac.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap from " + localn + " " + ((btz)localObject2).Id);
        i += 1;
      }
      label504:
      this.xYe = n.D(q.s((List)localObject1, af.dIc()));
      ac.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap " + this.xYf.xMO.dlj + " " + this.xYe);
      af.dHO().a(this.xYf.xMO.dlj, this.xYe, this.xYf.xMO.xNy);
      break label133;
      label597:
      if (this.xYf.xMO.xNy == 1) {
        localObject1 = "1-" + this.xYf.xMO.dlj;
      } else if (this.xYf.xMO.xNy == 4) {
        localObject1 = "4-" + this.xYf.xMO.dlj;
      } else if (this.xYf.xMO.xNy == 5) {
        localObject1 = "5-" + this.xYf.xMO.dlj;
      } else if (this.xYf.xMO.xNy == 3) {
        localObject1 = q.bS(3, this.xYf.xMO.dlj);
      }
    }
  }
  
  public final void dIZ()
  {
    if (this.xYf != null) {
      ac.i("MicroMsg.SnsCdnDownloadBase", "checkCdnPath: %s", new Object[] { Boolean.valueOf(i.aSh(this.xYf.getPath())) });
    }
  }
  
  protected abstract int getMediaType();
  
  public void onPostExecute(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, btz parambtz, int paramInt2, boolean paramBoolean1, String paramString, int paramInt3, int paramInt4, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.c
 * JD-Core Version:    0.7.0.1
 */