package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.a.o;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.az;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public abstract class c
  extends k<String, Integer, Integer>
{
  private static HashSet<String> ovg = new HashSet();
  protected awd bZK = null;
  private long dnsCostTime = -1L;
  private int eNz = -1;
  private String host = "";
  protected a ouM;
  protected n ouN = null;
  protected a ouO = null;
  int ovi = 0;
  
  public c(a parama, a parama1)
  {
    this.ouM = parama;
    this.ouO = parama1;
    if (parama1 == null) {
      return;
    }
    this.bZK = parama1.oqa;
    ovg.add(parama1.opZ);
    parama1.init();
  }
  
  public static boolean Oe(String paramString)
  {
    if (ovg.contains(i.aH(1, paramString))) {}
    while (ovg.contains(i.aH(5, paramString))) {
      return true;
    }
    return false;
  }
  
  private boolean a(com.tencent.mm.j.e parame, boolean paramBoolean, String paramString)
  {
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    int i;
    try
    {
      this.host = new URL(this.ouO.url).getHost();
      localArrayList1 = new ArrayList();
      this.eNz = com.tencent.mm.network.b.a(this.host, false, localArrayList1);
      localArrayList2 = new ArrayList();
      i = com.tencent.mm.network.b.a(this.host, true, localArrayList2);
      Random localRandom = new Random();
      localRandom.setSeed(bk.UY());
      Collections.shuffle(localArrayList1, localRandom);
      Collections.shuffle(localArrayList2, localRandom);
      while (localArrayList1.size() > 2) {
        localArrayList1.remove(0);
      }
      if (localArrayList2.size() <= 2) {
        break label170;
      }
    }
    catch (MalformedURLException parame)
    {
      y.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", parame, "", new Object[0]);
      y.w("MicroMsg.SnsCdnDownloadBase", "attachSnsImgTaskInfo fail:" + parame);
      return false;
    }
    for (;;)
    {
      localArrayList2.remove(0);
    }
    label170:
    parame.field_mediaId = (this.ouO.bUi + "_" + this.ouO.ouJ);
    parame.url = this.ouO.url;
    parame.host = this.host;
    parame.referer = paramString;
    parame.dlJ = (this.ouO.getPath() + this.ouO.bEq());
    parame.dlK = cz(localArrayList1);
    parame.dlL = cz(localArrayList2);
    parame.dlM = this.eNz;
    parame.dlN = i;
    parame.isColdSnsData = paramBoolean;
    parame.signalQuality = aq.getStrength(ae.getContext());
    parame.snsScene = this.ouO.ouK.tag;
    if (this.ouO.oqa != null)
    {
      if (this.ouO.ouH)
      {
        paramString = this.ouO.oqa.tsj;
        parame.snsCipherKey = paramString;
      }
    }
    else
    {
      if (this.ouO.ouJ != 8) {
        break label452;
      }
      parame.cCI = 3;
      parame.dlO = 109;
      parame.fileType = 20204;
    }
    for (;;)
    {
      y.i("MicroMsg.SnsCdnDownloadBase", "attachSnsImgTaskInfo reqDownType:%d:%s", new Object[] { Integer.valueOf(this.ouO.ouJ), parame });
      return true;
      paramString = this.ouO.oqa.tsg;
      break;
      label452:
      if ((this.ouO.ouJ == 6) || (this.ouO.ouJ == 4))
      {
        parame.cCI = 3;
        parame.dlO = 105;
        parame.fileType = 20210;
      }
      else if (this.ouO.ouJ == 5)
      {
        parame.cCI = 3;
        parame.dlO = 150;
        parame.fileType = 20250;
      }
      else if ((this.ouO.ouJ == 2) || (this.ouO.ouJ == 1) || (this.ouO.ouJ == 3))
      {
        parame.cCI = 3;
        parame.dlO = 100;
        parame.fileType = 20201;
      }
    }
  }
  
  private static String[] cz(List<String> paramList)
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
  
  public String Oc(String paramString)
  {
    return paramString;
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
        if ((paramaz != null) && (paramString2 != null) && (paramString2.indexOf(paramString1.getHost()) != -1) && (paramaz.time != 0))
        {
          long l = bk.cn(paramaz.time);
          if (l > paramLong) {
            return true;
          }
        }
      }
      catch (Exception paramaz)
      {
        y.e("MicroMsg.SnsCdnDownloadBase", "error for check dcip %s", new Object[] { paramaz.getMessage() });
      }
    }
    return false;
  }
  
  protected final void b(com.tencent.mm.j.d paramd)
  {
    int k = bEt();
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
      localObject2 = com.tencent.mm.model.c.c.IX().fJ((String)localObject1);
      if (((com.tencent.mm.storage.c)localObject2).isValid())
      {
        i = bk.getInt((String)((com.tencent.mm.storage.c)localObject2).ctr().get("needUploadData"), 1);
        str = ((com.tencent.mm.storage.c)localObject2).field_expId;
      }
      break;
    }
    while (i != 0)
    {
      if (this.ouO.ouJ == 8) {
        i = 1;
      }
      for (;;)
      {
        label110:
        localObject2 = new com.tencent.mm.modelsns.d();
        ((com.tencent.mm.modelsns.d)localObject2).j("20ImgSize", paramd.field_fileLength + ",");
        StringBuilder localStringBuilder = new StringBuilder();
        int j;
        if (aq.isWifi(ae.getContext()))
        {
          j = 1;
          label170:
          ((com.tencent.mm.modelsns.d)localObject2).j("21NetType", j + ",");
          ((com.tencent.mm.modelsns.d)localObject2).j("22DelayTime", paramd.field_delayTime + ",");
          ((com.tencent.mm.modelsns.d)localObject2).j("23RetCode", paramd.field_retCode + ",");
          ((com.tencent.mm.modelsns.d)localObject2).j("24DnsCostTime", paramd.field_dnsCostTime + ",");
          ((com.tencent.mm.modelsns.d)localObject2).j("25ConnectCostTime", paramd.field_connectCostTime + ",");
          ((com.tencent.mm.modelsns.d)localObject2).j("26SendCostTime", ",");
          ((com.tencent.mm.modelsns.d)localObject2).j("27WaitResponseCostTime", paramd.field_waitResponseCostTime + ",");
          ((com.tencent.mm.modelsns.d)localObject2).j("28ReceiveCostTime", paramd.field_receiveCostTime + ",");
          ((com.tencent.mm.modelsns.d)localObject2).j("29ClientAddrIP(uint)", paramd.field_clientHostIP + ",");
          ((com.tencent.mm.modelsns.d)localObject2).j("30ServerAddrIP(uint)", paramd.field_serverHostIP + ",");
          ((com.tencent.mm.modelsns.d)localObject2).j("31dnstype", this.eNz + ",");
          ((com.tencent.mm.modelsns.d)localObject2).j("32signal(int)", aq.getStrength(ae.getContext()) + ",");
          ((com.tencent.mm.modelsns.d)localObject2).j("33host(string)", this.host + ",");
          ((com.tencent.mm.modelsns.d)localObject2).j("34MediaType", k + ",");
          ((com.tencent.mm.modelsns.d)localObject2).j("35X_Errno(string)", paramd.field_xErrorNo + ",");
          ((com.tencent.mm.modelsns.d)localObject2).j("36MaxPackageSize", ",");
          ((com.tencent.mm.modelsns.d)localObject2).j("37MaxPackageTimeStamp", ",");
          ((com.tencent.mm.modelsns.d)localObject2).j("38PackageRecordList", ",");
          ((com.tencent.mm.modelsns.d)localObject2).j("39ExpLayerId", (String)localObject1 + ",");
          ((com.tencent.mm.modelsns.d)localObject2).j("40ExpId", str + ",");
          ((com.tencent.mm.modelsns.d)localObject2).j("41FeedId", ",");
          ((com.tencent.mm.modelsns.d)localObject2).j("42BizType", i + ",");
          ((com.tencent.mm.modelsns.d)localObject2).j("43CSeqCheck(uint)", paramd.field_cSeqCheck + ",");
          localObject1 = new StringBuilder();
          if (!paramd.field_usePrivateProtocol) {
            break label992;
          }
        }
        label992:
        for (i = 1;; i = 0)
        {
          ((com.tencent.mm.modelsns.d)localObject2).j("44isPrivate(uint)", i + ",");
          y.i("MicroMsg.SnsCdnDownloadBase", "report logbuffer(13480 TLMediaFielDownloadRecord): " + ((com.tencent.mm.modelsns.d)localObject2).uJ());
          h.nFQ.f(13480, new Object[] { localObject2 });
          if ((paramd.field_retCode == 200) || (paramd.field_retCode == 0)) {
            break;
          }
          h.nFQ.f(14071, new Object[] { localObject2 });
          return;
          localObject1 = "100106";
          break label46;
          localObject1 = "100100";
          break label46;
          if ((this.ouO.ouJ == 6) || (this.ouO.ouJ == 4))
          {
            i = 2;
            break label110;
          }
          if (this.ouO.ouJ == 5)
          {
            i = 4;
            break label110;
          }
          if ((this.ouO.ouJ != 2) && (this.ouO.ouJ != 1) && (this.ouO.ouJ != 3)) {
            break label997;
          }
          i = 0;
          break label110;
          j = 0;
          break label170;
        }
        label997:
        i = 5;
      }
      i = 0;
    }
  }
  
  public boolean bEr()
  {
    return true;
  }
  
  public abstract boolean bEs();
  
  protected abstract int bEt();
  
  public Integer bEu()
  {
    com.tencent.mm.kernel.g.DQ();
    if ((!com.tencent.mm.kernel.g.DP().isSDCardAvailable()) || (this.ouO == null)) {
      return Integer.valueOf(2);
    }
    if (bEr())
    {
      localObject1 = this.ouO.opV + this.ouO.bEq();
      y.i("MicroMsg.SnsCdnDownloadBase", "[tomys] delete img: %s", new Object[] { localObject1 });
      com.tencent.mm.vfs.e.deleteFile((String)localObject1);
    }
    System.currentTimeMillis();
    y.d("MicroMsg.SnsCdnDownloadBase", "to downloadBitmap " + this.ouO.bUi + " " + this.ouO.ouH + " type " + this.ouO.ouJ);
    com.tencent.mm.vfs.e.nb(this.ouO.getPath());
    az localaz = this.ouO.ouK;
    Object localObject1 = "";
    Object localObject2;
    if (localaz == null)
    {
      localObject1 = "";
      localObject2 = localObject1;
      if (!bk.bl((String)localObject1)) {
        localObject2 = "&scene=" + (String)localObject1;
      }
      String str = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.spa), o.getString(af.bDm()), Integer.valueOf(aq.getNetTypeForStat(ae.getContext())), Integer.valueOf(aq.getStrength(ae.getContext())), localObject2 });
      this.ouO.url = Oc(this.ouO.url);
      this.dnsCostTime = bk.UY();
      if (!this.ouO.ouI) {
        break label641;
      }
      localObject1 = "SnsSightDomainList";
      label315:
      if (!this.ouO.ouI) {
        break label649;
      }
      localObject2 = "SnsSightMainStandbyIpSwitchTime";
      label330:
      localObject1 = com.tencent.mm.m.g.AA().getValue((String)localObject1);
      long l2 = com.tencent.mm.m.g.AA().getInt((String)localObject2, 0);
      y.i("MicroMsg.SnsCdnDownloadBase", "pack.isAlbum %s pack.isthumb %s hostvalue %s dcipTime %s", new Object[] { Boolean.valueOf(this.ouO.ouI), Boolean.valueOf(this.ouO.ouH), localObject1, Long.valueOf(l2) });
      long l1 = l2;
      if (l2 <= 0L) {
        l1 = 259200L;
      }
      boolean bool = a(localaz, this.ouO.url, l1, (String)localObject1);
      this.dnsCostTime = bk.co(this.dnsCostTime);
      localObject1 = new com.tencent.mm.j.e();
      if (!a((com.tencent.mm.j.e)localObject1, bool, str)) {
        break label665;
      }
      ((com.tencent.mm.j.e)localObject1).dlP = new c.1(this);
      if (!com.tencent.mm.ak.f.Nd().b((com.tencent.mm.j.f)localObject1, -1)) {
        break label657;
      }
      y.i("MicroMsg.SnsCdnDownloadBase", "SubCoreCdnTransport addRecvTask suc");
    }
    label641:
    label649:
    label657:
    label665:
    for (int i = 1;; i = 2)
    {
      return Integer.valueOf(i);
      if (localaz.equals(az.uBD))
      {
        localObject1 = "album_friend";
        break;
      }
      if (localaz.equals(az.uBE))
      {
        localObject1 = "album_self";
        break;
      }
      if (localaz.equals(az.uBF))
      {
        localObject1 = "album_stranger";
        break;
      }
      if (localaz.equals(az.uBG))
      {
        localObject1 = "profile_friend";
        break;
      }
      if (localaz.equals(az.uBH))
      {
        localObject1 = "profile_stranger";
        break;
      }
      if (localaz.equals(az.uBI))
      {
        localObject1 = "comment";
        break;
      }
      if (!localaz.equals(az.uBC)) {
        break;
      }
      localObject1 = "timeline";
      break;
      localObject1 = "SnsAlbumDomainList";
      break label315;
      localObject2 = "SnsAlbumMainStandbyIpSwitchTime";
      break label330;
      y.w("MicroMsg.SnsCdnDownloadBase", "SubCoreCdnTransport addRecvTask failed");
    }
  }
  
  public void bEv()
  {
    if (af.bDo()) {
      return;
    }
    System.currentTimeMillis();
    Object localObject1;
    Object localObject2;
    if (this.ouO.omO.omU == 4)
    {
      y.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur thumb");
      localObject1 = i.e(this.bZK);
      localObject2 = i.g(this.bZK);
      this.ouN = com.tencent.mm.plugin.sns.lucky.a.a.eF(this.ouO.getPath() + (String)localObject1, this.ouO.getPath() + (String)localObject2);
      af.bDC().a(this.ouO.bUi, this.ouN, this.ouO.omO.omU);
      label132:
      localObject1 = null;
      if (this.ouO.omO.omU != 0) {
        break label593;
      }
      localObject1 = "0-" + this.ouO.omO.lJQ;
    }
    for (;;)
    {
      af.bDC().Ns((String)localObject1);
      return;
      if (this.ouO.omO.omU == 5)
      {
        y.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur grid");
        localObject1 = i.e(this.bZK);
        localObject2 = i.h(this.bZK);
        this.ouN = com.tencent.mm.plugin.sns.lucky.a.a.eF(this.ouO.getPath() + (String)localObject1, this.ouO.getPath() + (String)localObject2);
        af.bDC().a(this.ouO.bUi, this.ouN, this.ouO.omO.omU);
        break label132;
      }
      if (this.ouO.omO.list.size() <= 1)
      {
        af.bDC().a(this.ouO.bUi, this.ouN, this.ouO.omO.omU);
        break label132;
      }
      af.bDC().a(this.ouO.bUi, this.ouN, 0);
      localObject1 = new LinkedList();
      int i = 0;
      for (;;)
      {
        if ((i >= this.ouO.omO.list.size()) || (i >= 4)) {
          break label501;
        }
        localObject2 = (awd)this.ouO.omO.list.get(i);
        n localn = af.bDC().Nt(((awd)localObject2).lsK);
        if (!i.b(localn)) {
          break;
        }
        ((List)localObject1).add(localn);
        y.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap from " + localn + " " + ((awd)localObject2).lsK);
        i += 1;
      }
      label501:
      this.ouN = n.o(i.j((List)localObject1, af.bDN()));
      y.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap " + this.ouO.omO.lJQ + " " + this.ouN);
      af.bDC().a(this.ouO.omO.lJQ, this.ouN, this.ouO.omO.omU);
      break label132;
      label593:
      if (this.ouO.omO.omU == 1) {
        localObject1 = "1-" + this.ouO.omO.lJQ;
      } else if (this.ouO.omO.omU == 4) {
        localObject1 = "4-" + this.ouO.omO.lJQ;
      } else if (this.ouO.omO.omU == 5) {
        localObject1 = "5-" + this.ouO.omO.lJQ;
      } else if (this.ouO.omO.omU == 3) {
        localObject1 = i.aG(3, this.ouO.omO.lJQ);
      }
    }
  }
  
  public ah byB()
  {
    return af.bDq();
  }
  
  public void onPostExecute(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, awd paramawd, int paramInt2, boolean paramBoolean, String paramString, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.c
 * JD-Core Version:    0.7.0.1
 */