package com.tencent.mm.plugin.sns.model.a;

import android.util.SparseArray;
import com.tencent.mars.cdn.CdnLogic.BatchSnsReqImageData;
import com.tencent.mm.a.p;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.b.c;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class c
  extends k<String, Integer, Integer>
{
  private static HashSet<String> rjY = new HashSet();
  protected bcs cIc = null;
  private long dnsCostTime = -1L;
  private int gdn = -1;
  private String host = "";
  protected a rjF;
  protected n rjG = null;
  protected a rjH = null;
  int rka = 0;
  protected SparseArray<n> rkb = new SparseArray();
  
  public c(a parama, a parama1)
  {
    this.rjF = parama;
    this.rjH = parama1;
    if (parama1 == null) {
      return;
    }
    this.cIc = parama1.reH;
    rjY.add(parama1.reG);
    parama1.init();
  }
  
  private boolean a(com.tencent.mm.i.e parame, boolean paramBoolean, String paramString)
  {
    for (;;)
    {
      try
      {
        this.host = new URL(this.rjH.url).getHost();
        ArrayList localArrayList1 = new ArrayList();
        this.gdn = com.tencent.mm.network.b.a(this.host, false, localArrayList1);
        ArrayList localArrayList2 = new ArrayList();
        int j = com.tencent.mm.network.b.a(this.host, true, localArrayList2);
        Object localObject;
        if (9 == this.rjH.rjC)
        {
          parame.field_mediaId = (this.rjH.czw + "_" + this.rjH.rjC);
          if ((parame instanceof com.tencent.mm.i.f))
          {
            com.tencent.mm.i.f localf = (com.tencent.mm.i.f)parame;
            localf.czw = this.rjH.czw;
            localf.edm = this.rjH.size;
            localf.edn = this.rjH.rbn.size();
            localf.ede = new CdnLogic.BatchSnsReqImageData[localf.edn];
            int i = 0;
            if (i < localf.edn)
            {
              int k = this.rjH.rbn.keyAt(i);
              bcs localbcs = (bcs)this.rjH.rbn.get(k);
              CdnLogic.BatchSnsReqImageData localBatchSnsReqImageData = new CdnLogic.BatchSnsReqImageData();
              String str = localbcs.xrS;
              localObject = str;
              if (bo.isNullOrNil(str))
              {
                localObject = str;
                if (localbcs.jKs == 2) {
                  localObject = localbcs.Url;
                }
              }
              localBatchSnsReqImageData.url = b((String)localObject, localbcs);
              localBatchSnsReqImageData.picIndex = k;
              localBatchSnsReqImageData.totalFileSize = 0;
              localBatchSnsReqImageData.decryptKey = localbcs.xsm;
              localObject = new StringBuilder();
              str = localbcs.Id;
              localBatchSnsReqImageData.imageCachePath = (ao.gl(ag.getAccSnsPath(), str) + i.n(localbcs));
              localBatchSnsReqImageData.fileKey = (localbcs.Id + "_" + this.rjH.rjC);
              localf.ede[i] = localBatchSnsReqImageData;
              i += 1;
              continue;
            }
          }
        }
        else
        {
          parame.field_mediaId = (this.rjH.cBO + "_" + this.rjH.rjC);
          parame.edg = (this.rjH.getPath() + this.rjH.cpP());
          if (this.rjH.reH != null)
          {
            if (!this.rjH.rjA) {
              continue;
            }
            localObject = this.rjH.reH.xsm;
            parame.snsCipherKey = ((String)localObject);
          }
        }
        parame.url = this.rjH.url;
        parame.host = this.host;
        parame.referer = paramString;
        parame.edh = de(localArrayList1);
        parame.edi = de(localArrayList2);
        parame.edj = this.gdn;
        parame.edk = j;
        parame.isColdSnsData = paramBoolean;
        parame.signalQuality = at.getStrength(ah.getContext());
        parame.snsScene = this.rjH.rjD.tag;
        if (this.rjH.rjC == 8)
        {
          parame.dqS = 3;
          parame.edl = 109;
          parame.fileType = 20204;
          ab.i("MicroMsg.SnsCdnDownloadBase", "attachSnsImgTaskInfo reqDownType:%d taskInfo:%s", new Object[] { Integer.valueOf(this.rjH.rjC), parame });
          return true;
          localObject = this.rjH.reH.xsj;
          continue;
        }
        if ((this.rjH.rjC == 6) || (this.rjH.rjC == 4))
        {
          parame.dqS = 3;
          parame.edl = 105;
          parame.fileType = 20210;
          continue;
        }
        if (this.rjH.rjC != 5) {
          break label806;
        }
      }
      catch (MalformedURLException parame)
      {
        ab.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", parame, "", new Object[0]);
        ab.w("MicroMsg.SnsCdnDownloadBase", "attachSnsImgTaskInfo fail:".concat(String.valueOf(parame)));
        return false;
      }
      parame.dqS = 3;
      parame.edl = 150;
      parame.fileType = 20250;
      continue;
      label806:
      if ((this.rjH.rjC == 2) || (this.rjH.rjC == 1) || (this.rjH.rjC == 3) || (this.rjH.rjC == 9))
      {
        parame.dqS = 3;
        parame.edl = 100;
        parame.fileType = 20201;
      }
    }
  }
  
  public static boolean aaY(String paramString)
  {
    if (rjY.contains(i.bd(1, paramString))) {}
    while (rjY.contains(i.bd(5, paramString))) {
      return true;
    }
    return false;
  }
  
  private static String[] de(List<String> paramList)
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
  
  public boolean DY(int paramInt)
  {
    return false;
  }
  
  public final void DZ(int paramInt)
  {
    if (ag.coN()) {
      return;
    }
    Object localObject = (com.tencent.mm.plugin.sns.data.e)this.rjH.rbd.get(paramInt);
    bcs localbcs = (bcs)this.rjH.rbn.get(paramInt);
    ab.i("MicroMsg.SnsCdnDownloadBase", "thumbAddDecode index: %d decodeType: %d.", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((com.tencent.mm.plugin.sns.data.e)localObject).rbj) });
    ag.cpc().a(localbcs.Id, (n)this.rkb.get(paramInt), ((com.tencent.mm.plugin.sns.data.e)localObject).rbj);
    if (((com.tencent.mm.plugin.sns.data.e)localObject).rbj == 0) {}
    for (localObject = i.bc(0, ((com.tencent.mm.plugin.sns.data.e)localObject).ohe);; localObject = null)
    {
      ab.i("MicroMsg.SnsCdnDownloadBase", "thumbAddDecode cacheName: %s.", new Object[] { localObject });
      ag.cpc().aal((String)localObject);
      return;
    }
  }
  
  public boolean a(az paramaz, String paramString1, long paramLong, String paramString2)
  {
    if (paramString1 == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramString1 = new URL(paramString1);
        if ((paramaz != null) && (paramString2 != null) && (paramString2.indexOf(paramString1.getHost()) != -1) && (paramaz.oLs != 0))
        {
          long l = bo.gz(paramaz.oLs);
          if (l > paramLong) {
            return true;
          }
        }
      }
      catch (Exception paramaz)
      {
        ab.e("MicroMsg.SnsCdnDownloadBase", "error for check dcip %s", new Object[] { paramaz.getMessage() });
      }
    }
    return false;
  }
  
  public String aaW(String paramString)
  {
    return paramString;
  }
  
  public String b(String paramString, bcs parambcs)
  {
    return paramString;
  }
  
  protected final void b(com.tencent.mm.i.d paramd)
  {
    int k = cpS();
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
      localObject2 = com.tencent.mm.model.c.c.abU().me((String)localObject1);
      if (((com.tencent.mm.storage.c)localObject2).isValid())
      {
        i = bo.getInt((String)((com.tencent.mm.storage.c)localObject2).dvN().get("needUploadData"), 1);
        str = ((com.tencent.mm.storage.c)localObject2).field_expId;
      }
      break;
    }
    while (i != 0)
    {
      if (this.rjH.rjC == 8) {
        i = 1;
      }
      for (;;)
      {
        label110:
        localObject2 = new com.tencent.mm.modelsns.d();
        ((com.tencent.mm.modelsns.d)localObject2).k("20ImgSize", paramd.field_fileLength + ",");
        StringBuilder localStringBuilder = new StringBuilder();
        int j;
        if (at.isWifi(ah.getContext()))
        {
          j = 1;
          label170:
          ((com.tencent.mm.modelsns.d)localObject2).k("21NetType", j + ",");
          ((com.tencent.mm.modelsns.d)localObject2).k("22DelayTime", paramd.field_delayTime + ",");
          ((com.tencent.mm.modelsns.d)localObject2).k("23RetCode", paramd.field_retCode + ",");
          ((com.tencent.mm.modelsns.d)localObject2).k("24DnsCostTime", paramd.field_dnsCostTime + ",");
          ((com.tencent.mm.modelsns.d)localObject2).k("25ConnectCostTime", paramd.field_connectCostTime + ",");
          ((com.tencent.mm.modelsns.d)localObject2).k("26SendCostTime", ",");
          ((com.tencent.mm.modelsns.d)localObject2).k("27WaitResponseCostTime", paramd.field_waitResponseCostTime + ",");
          ((com.tencent.mm.modelsns.d)localObject2).k("28ReceiveCostTime", paramd.field_receiveCostTime + ",");
          ((com.tencent.mm.modelsns.d)localObject2).k("29ClientAddrIP(uint)", paramd.field_clientHostIP + ",");
          ((com.tencent.mm.modelsns.d)localObject2).k("30ServerAddrIP(uint)", paramd.field_serverHostIP + ",");
          ((com.tencent.mm.modelsns.d)localObject2).k("31dnstype", this.gdn + ",");
          ((com.tencent.mm.modelsns.d)localObject2).k("32signal(int)", at.getStrength(ah.getContext()) + ",");
          ((com.tencent.mm.modelsns.d)localObject2).k("33host(string)", this.host + ",");
          ((com.tencent.mm.modelsns.d)localObject2).k("34MediaType", k + ",");
          ((com.tencent.mm.modelsns.d)localObject2).k("35X_Errno(string)", paramd.field_xErrorNo + ",");
          ((com.tencent.mm.modelsns.d)localObject2).k("36MaxPackageSize", ",");
          ((com.tencent.mm.modelsns.d)localObject2).k("37MaxPackageTimeStamp", ",");
          ((com.tencent.mm.modelsns.d)localObject2).k("38PackageRecordList", ",");
          ((com.tencent.mm.modelsns.d)localObject2).k("39ExpLayerId", (String)localObject1 + ",");
          ((com.tencent.mm.modelsns.d)localObject2).k("40ExpId", str + ",");
          ((com.tencent.mm.modelsns.d)localObject2).k("41FeedId", ",");
          ((com.tencent.mm.modelsns.d)localObject2).k("42BizType", i + ",");
          ((com.tencent.mm.modelsns.d)localObject2).k("43CSeqCheck(uint)", paramd.field_cSeqCheck + ",");
          localObject1 = new StringBuilder();
          if (!paramd.field_usePrivateProtocol) {
            break label993;
          }
        }
        label993:
        for (i = 1;; i = 0)
        {
          ((com.tencent.mm.modelsns.d)localObject2).k("44isPrivate(uint)", i + ",");
          ab.i("MicroMsg.SnsCdnDownloadBase", "report logbuffer(13480 TLMediaFielDownloadRecord): " + ((com.tencent.mm.modelsns.d)localObject2).Fg());
          h.qsU.e(13480, new Object[] { localObject2 });
          if ((paramd.field_retCode == 200) || (paramd.field_retCode == 0)) {
            break;
          }
          h.qsU.e(14071, new Object[] { localObject2 });
          return;
          localObject1 = "100106";
          break label46;
          localObject1 = "100100";
          break label46;
          if ((this.rjH.rjC == 6) || (this.rjH.rjC == 4))
          {
            i = 2;
            break label110;
          }
          if (this.rjH.rjC == 5)
          {
            i = 4;
            break label110;
          }
          if ((this.rjH.rjC != 2) && (this.rjH.rjC != 1) && (this.rjH.rjC != 3)) {
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
  
  public com.tencent.mm.sdk.g.b.a cjN()
  {
    return ag.coP();
  }
  
  public boolean cpQ()
  {
    return true;
  }
  
  public abstract boolean cpR();
  
  protected abstract int cpS();
  
  public Integer cpU()
  {
    com.tencent.mm.kernel.g.RM();
    if ((!com.tencent.mm.kernel.g.RL().isSDCardAvailable()) || (this.rjH == null)) {
      return Integer.valueOf(2);
    }
    Object localObject1;
    Object localObject3;
    Object localObject4;
    if (cpQ())
    {
      if (9 == this.rjH.rjC)
      {
        i = 0;
        while (i < this.rjH.rbn.size())
        {
          localObject1 = (bcs)this.rjH.rbn.valueAt(i);
          localObject3 = new StringBuilder();
          localObject4 = ((bcs)localObject1).Id;
          com.tencent.mm.vfs.e.deleteFile(ao.gl(ag.getAccSnsPath(), (String)localObject4) + i.n((bcs)localObject1));
          i += 1;
        }
      }
      localObject1 = this.rjH.reC + this.rjH.cpP();
      ab.i("MicroMsg.SnsCdnDownloadBase", "[tomys] delete img: %s", new Object[] { localObject1 });
      com.tencent.mm.vfs.e.deleteFile((String)localObject1);
    }
    long l3 = System.currentTimeMillis();
    String str;
    boolean bool;
    for (;;)
    {
      try
      {
        localObject1 = ag.cpa();
        localObject3 = this.rjH.cBO;
        if (bo.isNullOrNil((String)localObject3)) {
          continue;
        }
        localObject1 = (b.c)((com.tencent.mm.plugin.sns.model.b)localObject1).rdh.get(localObject3);
        if ((localObject1 != null) && (!((b.c)localObject1).rdm)) {
          ((b.c)localObject1).setStartTime(l3);
        }
      }
      catch (Exception localException)
      {
        long l2;
        long l1;
        ab.e("MicroMsg.SnsCdnDownloadBase", "exception msg: %s.", new Object[] { localException.getMessage() });
        continue;
        if (!((az)localObject4).equals(az.yNN)) {
          continue;
        }
        localObject2 = "album_friend";
        continue;
        if (!((az)localObject4).equals(az.yNO)) {
          continue;
        }
        localObject2 = "album_self";
        continue;
        if (!((az)localObject4).equals(az.yNP)) {
          continue;
        }
        localObject2 = "album_stranger";
        continue;
        if (!((az)localObject4).equals(az.yNQ)) {
          continue;
        }
        localObject2 = "profile_friend";
        continue;
        if (!((az)localObject4).equals(az.yNR)) {
          continue;
        }
        localObject2 = "profile_stranger";
        continue;
        if (!((az)localObject4).equals(az.yNS)) {
          continue;
        }
        localObject2 = "comment";
        continue;
        if (!((az)localObject4).equals(az.yNM)) {
          continue;
        }
        localObject2 = "timeline";
        continue;
        this.rjH.url = aaW(this.rjH.url);
        continue;
        localObject2 = "SnsAlbumDomainList";
        continue;
        localObject3 = "SnsAlbumMainStandbyIpSwitchTime";
        continue;
      }
      i = 0;
      if (this.rjH.rbn != null) {
        i = this.rjH.rbn.size();
      }
      ab.d("MicroMsg.SnsCdnDownloadBase", "to downloadBitmap pack.mediaId: " + this.rjH.cBO + " pack.mediaObjs.size: " + i + " pack.snsId: " + this.rjH.czw + " pack.isthumb: " + this.rjH.rjA + " type: " + this.rjH.rjC);
      localObject4 = this.rjH.rjD;
      localObject1 = "";
      if (localObject4 != null) {
        continue;
      }
      localObject1 = "";
      localObject3 = localObject1;
      if (!bo.isNullOrNil((String)localObject1)) {
        localObject3 = "&scene=".concat(String.valueOf(localObject1));
      }
      str = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.whH), p.getString(ag.coL()), Integer.valueOf(at.getNetTypeForStat(ah.getContext())), Integer.valueOf(at.getStrength(ah.getContext())), localObject3 });
      if (9 != this.rjH.rjC) {
        continue;
      }
      this.rjH.url = b(this.rjH.url, (bcs)this.rjH.rbn.get(0));
      this.dnsCostTime = bo.aoy();
      if (!this.rjH.rjB) {
        continue;
      }
      localObject1 = "SnsSightDomainList";
      if (!this.rjH.rjB) {
        continue;
      }
      localObject3 = "SnsSightMainStandbyIpSwitchTime";
      localObject1 = com.tencent.mm.m.g.Nq().getValue((String)localObject1);
      l2 = com.tencent.mm.m.g.Nq().getInt((String)localObject3, 0);
      ab.i("MicroMsg.SnsCdnDownloadBase", "pack.isAlbum %s pack.isthumb %s hostvalue %s dcipTime %s", new Object[] { Boolean.valueOf(this.rjH.rjB), Boolean.valueOf(this.rjH.rjA), localObject1, Long.valueOf(l2) });
      l1 = l2;
      if (l2 <= 0L) {
        l1 = 259200L;
      }
      bool = a((az)localObject4, this.rjH.url, l1, (String)localObject1);
      this.dnsCostTime = bo.hl(this.dnsCostTime);
      if (9 != this.rjH.rjC) {
        break label994;
      }
      localObject1 = new com.tencent.mm.i.f();
      i = 0;
      if (i >= this.rjH.rbn.size()) {
        break label936;
      }
      localObject3 = ((bcs)this.rjH.rbn.valueAt(i)).Id;
      com.tencent.mm.vfs.e.um(ao.gl(ag.getAccSnsPath(), (String)localObject3));
      i += 1;
      continue;
      localObject1 = null;
    }
    Object localObject2;
    label936:
    if (a((com.tencent.mm.i.e)localObject2, bool, str))
    {
      ((com.tencent.mm.i.e)localObject2).edp = new c.1(this, (com.tencent.mm.i.e)localObject2, l3);
      if (com.tencent.mm.al.f.afO().b((com.tencent.mm.i.g)localObject2, -1)) {
        ab.i("MicroMsg.SnsCdnDownloadBase", "SubCoreCdnTransport addRecvTask suc");
      }
    }
    for (int i = 1;; i = 2)
    {
      return Integer.valueOf(i);
      label994:
      com.tencent.mm.vfs.e.um(this.rjH.getPath());
      localObject2 = new com.tencent.mm.i.e();
      break;
      ab.w("MicroMsg.SnsCdnDownloadBase", "SubCoreCdnTransport addRecvTask failed");
    }
  }
  
  public void cpV()
  {
    if (ag.coN()) {
      return;
    }
    System.currentTimeMillis();
    Object localObject1;
    Object localObject2;
    if (this.rjH.rbc.rbj == 4)
    {
      ab.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur thumb");
      localObject1 = i.e(this.cIc);
      localObject2 = i.g(this.cIc);
      this.rjG = com.tencent.mm.plugin.sns.lucky.a.a.gh(this.rjH.getPath() + (String)localObject1, this.rjH.getPath() + (String)localObject2);
      ag.cpc().a(this.rjH.cBO, this.rjG, this.rjH.rbc.rbj);
      label133:
      localObject1 = null;
      if (this.rjH.rbc.rbj != 0) {
        break label597;
      }
      localObject1 = "0-" + this.rjH.rbc.ohe;
    }
    for (;;)
    {
      ag.cpc().aal((String)localObject1);
      return;
      if (this.rjH.rbc.rbj == 5)
      {
        ab.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur grid");
        localObject1 = i.e(this.cIc);
        localObject2 = i.h(this.cIc);
        this.rjG = com.tencent.mm.plugin.sns.lucky.a.a.gh(this.rjH.getPath() + (String)localObject1, this.rjH.getPath() + (String)localObject2);
        ag.cpc().a(this.rjH.cBO, this.rjG, this.rjH.rbc.rbj);
        break label133;
      }
      if (this.rjH.rbc.list.size() <= 1)
      {
        ag.cpc().a(this.rjH.cBO, this.rjG, this.rjH.rbc.rbj);
        break label133;
      }
      ag.cpc().a(this.rjH.cBO, this.rjG, 0);
      localObject1 = new LinkedList();
      int i = 0;
      for (;;)
      {
        if ((i >= this.rjH.rbc.list.size()) || (i >= 4)) {
          break label504;
        }
        localObject2 = (bcs)this.rjH.rbc.list.get(i);
        n localn = ag.cpc().aam(((bcs)localObject2).Id);
        if (!i.b(localn)) {
          break;
        }
        ((List)localObject1).add(localn);
        ab.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap from " + localn + " " + ((bcs)localObject2).Id);
        i += 1;
      }
      label504:
      this.rjG = n.v(i.o((List)localObject1, ag.cpn()));
      ab.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap " + this.rjH.rbc.ohe + " " + this.rjG);
      ag.cpc().a(this.rjH.rbc.ohe, this.rjG, this.rjH.rbc.rbj);
      break label133;
      label597:
      if (this.rjH.rbc.rbj == 1) {
        localObject1 = "1-" + this.rjH.rbc.ohe;
      } else if (this.rjH.rbc.rbj == 4) {
        localObject1 = "4-" + this.rjH.rbc.ohe;
      } else if (this.rjH.rbc.rbj == 5) {
        localObject1 = "5-" + this.rjH.rbc.ohe;
      } else if (this.rjH.rbc.rbj == 3) {
        localObject1 = i.bc(3, this.rjH.rbc.ohe);
      }
    }
  }
  
  public void onPostExecute(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, bcs parambcs, int paramInt2, boolean paramBoolean1, String paramString, int paramInt3, int paramInt4, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.c
 * JD-Core Version:    0.7.0.1
 */