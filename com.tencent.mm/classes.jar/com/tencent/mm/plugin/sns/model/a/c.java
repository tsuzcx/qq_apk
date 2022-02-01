package com.tencent.mm.plugin.sns.model.a;

import android.util.SparseArray;
import com.tencent.mars.cdn.CdnLogic.BatchSnsReqImageData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.g.a;
import com.tencent.mm.k.i;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.model.c.c;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.br;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

public abstract class c
  extends com.tencent.mm.pluginsdk.model.t<String, Integer, Integer>
{
  private static HashSet<String> QAj = new HashSet();
  int QAl = 0;
  protected SparseArray<com.tencent.mm.memory.m> QAm = new SparseArray();
  protected a QzQ;
  protected com.tencent.mm.memory.m QzR = null;
  protected a QzS = null;
  private long dnsCostTime = -1L;
  private String host = "";
  protected dmz ibT = null;
  private int pnI = -1;
  
  public c(a parama, a parama1)
  {
    this.QzQ = parama;
    this.QzS = parama1;
    if (parama1 == null) {
      return;
    }
    this.ibT = parama1.Qsr;
    QAj.add(parama1.Qsq);
    parama1.init();
  }
  
  private boolean a(com.tencent.mm.g.e parame, boolean paramBoolean, String paramString)
  {
    for (;;)
    {
      try
      {
        this.host = new URL(this.QzS.url).getHost();
        ArrayList localArrayList1 = new ArrayList();
        this.pnI = com.tencent.mm.network.d.a(this.host, false, localArrayList1);
        ArrayList localArrayList2 = new ArrayList();
        int j = com.tencent.mm.network.d.a(this.host, true, localArrayList2);
        Object localObject;
        if (9 == this.QzS.QzN)
        {
          parame.field_mediaId = (this.QzS.hQX + "_" + this.QzS.QzN);
          if ((parame instanceof com.tencent.mm.g.f))
          {
            com.tencent.mm.g.f localf = (com.tencent.mm.g.f)parame;
            localf.hQX = this.QzS.hQX;
            localf.lwI = this.QzS.size;
            localf.lwJ = this.QzS.Qoc.size();
            localf.lwB = new CdnLogic.BatchSnsReqImageData[localf.lwJ];
            int i = 0;
            if (i < localf.lwJ)
            {
              int k = this.QzS.Qoc.keyAt(i);
              dmz localdmz = (dmz)this.QzS.Qoc.get(k);
              CdnLogic.BatchSnsReqImageData localBatchSnsReqImageData = new CdnLogic.BatchSnsReqImageData();
              String str = localdmz.aaTl;
              localObject = str;
              if (Util.isNullOrNil(str))
              {
                localObject = str;
                if (localdmz.vhJ == 2) {
                  localObject = localdmz.Url;
                }
              }
              localBatchSnsReqImageData.url = b((String)localObject, localdmz);
              localBatchSnsReqImageData.picIndex = k;
              localBatchSnsReqImageData.totalFileSize = 0;
              localBatchSnsReqImageData.decryptKey = localdmz.aaTD;
              localObject = new StringBuilder();
              str = localdmz.Id;
              localBatchSnsReqImageData.imageCachePath = y.n(as.mg(al.getAccSnsPath(), str) + com.tencent.mm.plugin.sns.data.t.m(localdmz), false);
              localBatchSnsReqImageData.fileKey = (localdmz.Id + "_" + this.QzS.QzN);
              localf.lwB[i] = localBatchSnsReqImageData;
              i += 1;
              continue;
            }
          }
        }
        else
        {
          parame.field_mediaId = (this.QzS.mediaId + "_" + this.QzS.QzN);
          parame.lwD = (this.QzS.getPath() + this.QzS.hhG());
          parame.field_fullpath = parame.lwD;
          if (this.QzS.Qsr != null)
          {
            if (!this.QzS.QzL) {
              continue;
            }
            localObject = this.QzS.Qsr.aaTD;
            parame.snsCipherKey = ((String)localObject);
          }
        }
        parame.url = this.QzS.url;
        parame.host = this.host;
        parame.referer = paramString;
        parame.lwE = hb(localArrayList1);
        parame.lwF = hb(localArrayList2);
        parame.lwG = this.pnI;
        parame.lwH = j;
        parame.isColdSnsData = paramBoolean;
        parame.signalQuality = ConnectivityCompat.Companion.getCompatMixStrength();
        parame.snsScene = this.QzS.QzO.tag;
        if (this.QzS.QzN == 8)
        {
          parame.hyY = 3;
          parame.appType = 109;
          parame.fileType = 20204;
          Log.i("MicroMsg.SnsCdnDownloadBase", "attachSnsImgTaskInfo reqDownType:%d taskInfo:%s", new Object[] { Integer.valueOf(this.QzS.QzN), parame });
          return true;
          localObject = this.QzS.Qsr.aaTA;
          continue;
        }
        if ((this.QzS.QzN == 6) || (this.QzS.QzN == 4))
        {
          parame.hyY = 3;
          parame.appType = 105;
          parame.fileType = 20210;
          continue;
        }
        if (this.QzS.QzN != 5) {
          break label818;
        }
      }
      catch (MalformedURLException parame)
      {
        Log.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", parame, "", new Object[0]);
        Log.w("MicroMsg.SnsCdnDownloadBase", "attachSnsImgTaskInfo fail:".concat(String.valueOf(parame)));
        return false;
      }
      parame.hyY = 3;
      parame.appType = 150;
      parame.fileType = 20250;
      continue;
      label818:
      if ((this.QzS.QzN == 2) || (this.QzS.QzN == 1) || (this.QzS.QzN == 3) || (this.QzS.QzN == 9))
      {
        parame.hyY = 3;
        parame.appType = 100;
        parame.fileType = 20201;
        if ((this.QzS.QzN == 1) && ((this.QzS.url.startsWith("http://wxapp.tc.qq.com")) || (this.QzS.url.startsWith("https://wxapp.tc.qq.com"))) && (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zfd, 1) == 1))
        {
          parame.hyY = 3;
          parame.appType = 150;
          parame.fileType = 20201;
        }
        if ((this.QzS.QzN == 3) && (this.QzS.url.startsWith("https://wwfile.work.weixin.qq.com")))
        {
          parame.field_fileType = 19;
          parame.field_aesKey = this.QzS.aesKey;
          parame.field_authKey = this.QzS.authKey;
          parame.lwO = parame.url;
          parame.field_totalLen = 1;
        }
      }
    }
  }
  
  public static boolean aZa(String paramString)
  {
    if (QAj.contains(com.tencent.mm.plugin.sns.data.t.dc(1, paramString))) {}
    while (QAj.contains(com.tencent.mm.plugin.sns.data.t.dc(5, paramString))) {
      return true;
    }
    return false;
  }
  
  private static String[] hb(List<String> paramList)
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
  
  public boolean a(br parambr, String paramString1, long paramLong, String paramString2)
  {
    if (paramString1 == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramString1 = new URL(paramString1);
        if ((parambr != null) && (paramString2 != null) && (paramString2.indexOf(paramString1.getHost()) != -1) && (parambr.time != 0))
        {
          long l = Util.secondsToNow(parambr.time);
          if (l > paramLong) {
            return true;
          }
        }
      }
      catch (Exception parambr)
      {
        Log.e("MicroMsg.SnsCdnDownloadBase", "error for check dcip %s", new Object[] { parambr.getMessage() });
      }
    }
    return false;
  }
  
  public String aYY(String paramString)
  {
    return paramString;
  }
  
  public boolean akS(int paramInt)
  {
    return false;
  }
  
  public final void akT(int paramInt)
  {
    if (al.isInValid()) {
      return;
    }
    Object localObject = (com.tencent.mm.plugin.sns.data.p)this.QzS.QmU.get(paramInt);
    dmz localdmz = (dmz)this.QzS.Qoc.get(paramInt);
    Log.i("MicroMsg.SnsCdnDownloadBase", "thumbAddDecode index: %d decodeType: %d.", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((com.tencent.mm.plugin.sns.data.p)localObject).QnY) });
    al.hgy().a(localdmz.Id, (com.tencent.mm.memory.m)this.QAm.get(paramInt), ((com.tencent.mm.plugin.sns.data.p)localObject).QnY);
    if (((com.tencent.mm.plugin.sns.data.p)localObject).QnY == 0) {}
    for (localObject = com.tencent.mm.plugin.sns.data.t.db(0, ((com.tencent.mm.plugin.sns.data.p)localObject).hOG);; localObject = null)
    {
      Log.i("MicroMsg.SnsCdnDownloadBase", "thumbAddDecode cacheName: %s.", new Object[] { localObject });
      al.hgy().aYg((String)localObject);
      return;
    }
  }
  
  public String b(String paramString, dmz paramdmz)
  {
    return paramString;
  }
  
  protected final void c(com.tencent.mm.g.d paramd)
  {
    int i = 4;
    int m = getMediaType();
    if (this.QzS.QzN == 8) {
      i = 1;
    }
    for (;;)
    {
      int j;
      label74:
      n localn;
      StringBuilder localStringBuilder;
      int k;
      if ((paramd.field_recvedBytes > 0L) && (paramd.field_receiveCostTime > 0))
      {
        j = (int)((float)paramd.field_recvedBytes / 1024.0F / ((paramd.field_receiveCostTime + paramd.field_waitResponseCostTime + paramd.field_connectCostTime + paramd.field_dnsCostTime) / 1000.0F));
        localn = new n();
        localn.s("20ImgSize", paramd.field_fileLength + ",");
        localStringBuilder = new StringBuilder();
        if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
          break label945;
        }
        k = 1;
        label135:
        localn.s("21NetType", k + ",");
        localn.s("22DelayTime", paramd.field_delayTime + ",");
        localn.s("23RetCode", paramd.field_retCode + ",");
        localn.s("24DnsCostTime", paramd.field_dnsCostTime + ",");
        localn.s("25ConnectCostTime", paramd.field_connectCostTime + ",");
        localn.s("26SendCostTime", ",");
        localn.s("27WaitResponseCostTime", paramd.field_waitResponseCostTime + ",");
        localn.s("28ReceiveCostTime", paramd.field_receiveCostTime + ",");
        localn.s("29ClientAddrIP(uint)", paramd.field_clientHostIP + ",");
        localn.s("30ServerAddrIP(uint)", paramd.field_serverHostIP + ",");
        localn.s("31dnstype", this.pnI + ",");
        localn.s("32signal(int)", ConnectivityCompat.Companion.getCompatMixStrength() + ",");
        localn.s("33host(string)", this.host + ",");
        localn.s("34MediaType", m + ",");
        localn.s("35X_Errno(string)", paramd.field_xErrorNo + ",");
        localn.s("36MaxPackageSize", ",");
        localn.s("37MaxPackageTimeStamp", ",");
        localn.s("38PackageRecordList", ",");
        localn.s("39ExpLayerId", "0,");
        localn.s("40ExpId", "0,");
        localn.s("41FeedId", ",");
        localn.s("42BizType", i + ",");
        localn.s("43CSeqCheck(uint)", paramd.field_cSeqCheck + ",");
        localStringBuilder = new StringBuilder();
        if (!paramd.field_usePrivateProtocol) {
          break label951;
        }
      }
      label945:
      label951:
      for (i = 1;; i = 0)
      {
        localn.s("44isPrivate(uint)", i + ",");
        localn.s("45mediaId(string)", paramd.mediaId + ",");
        localn.s("46download_speed(uint)", Integer.valueOf(j));
        Log.i("MicroMsg.SnsCdnDownloadBase", "report logbuffer(13480 TLMediaFielDownloadRecord): " + localn.aIF());
        com.tencent.mm.plugin.report.service.h.OAn.b(13480, new Object[] { localn });
        if ((paramd.field_retCode != 200) && (paramd.field_retCode != 0)) {
          com.tencent.mm.plugin.report.service.h.OAn.b(14071, new Object[] { localn });
        }
        return;
        if ((this.QzS.QzN == 6) || (this.QzS.QzN == 4))
        {
          i = 2;
          break;
        }
        if (this.QzS.QzN == 5) {
          break;
        }
        if ((this.QzS.QzN != 2) && (this.QzS.QzN != 1) && (this.QzS.QzN != 3)) {
          break label956;
        }
        i = 0;
        break;
        j = 0;
        break label74;
        k = 0;
        break label135;
      }
      label956:
      i = 5;
    }
  }
  
  public ExecutorService gDT()
  {
    return al.hgl();
  }
  
  protected abstract int getMediaType();
  
  public boolean hhH()
  {
    return true;
  }
  
  public abstract boolean hhI();
  
  public Integer hhK()
  {
    com.tencent.mm.kernel.h.baF();
    if ((!com.tencent.mm.kernel.h.baE().isSDCardAvailable()) || (this.QzS == null)) {
      return Integer.valueOf(2);
    }
    Object localObject1;
    Object localObject3;
    Object localObject4;
    if (hhH())
    {
      if (9 == this.QzS.QzN)
      {
        i = 0;
        while (i < this.QzS.Qoc.size())
        {
          localObject1 = (dmz)this.QzS.Qoc.valueAt(i);
          localObject3 = new StringBuilder();
          localObject4 = ((dmz)localObject1).Id;
          localObject1 = as.mg(al.getAccSnsPath(), (String)localObject4) + com.tencent.mm.plugin.sns.data.t.m((dmz)localObject1);
          Log.i("MicroMsg.SnsCdnDownloadBase", "pennqin, delete sns thumb: [%s].", new Object[] { localObject1 });
          y.deleteFile((String)localObject1);
          i += 1;
        }
      }
      localObject1 = this.QzS.Qsm + this.QzS.hhG();
      Log.i("MicroMsg.SnsCdnDownloadBase", "[tomys] delete img: %s", new Object[] { localObject1 });
      y.deleteFile((String)localObject1);
    }
    final long l3 = System.currentTimeMillis();
    String str;
    boolean bool;
    for (;;)
    {
      try
      {
        localObject1 = al.hgw();
        localObject3 = this.QzS.mediaId;
        if (Util.isNullOrNil((String)localObject3)) {
          continue;
        }
        localObject1 = (c.c)((com.tencent.mm.plugin.sns.model.c)localObject1).QqR.get(localObject3);
        if ((localObject1 != null) && (!((c.c)localObject1).QqV)) {
          ((c.c)localObject1).setStartTime(l3);
        }
      }
      catch (Exception localException)
      {
        long l2;
        long l1;
        Log.e("MicroMsg.SnsCdnDownloadBase", "exception msg: %s.", new Object[] { localException.getMessage() });
        continue;
        if (!((br)localObject4).equals(br.adjW)) {
          continue;
        }
        localObject2 = "album_friend";
        continue;
        if (!((br)localObject4).equals(br.adjX)) {
          continue;
        }
        localObject2 = "album_self";
        continue;
        if (!((br)localObject4).equals(br.adjY)) {
          continue;
        }
        localObject2 = "album_stranger";
        continue;
        if (!((br)localObject4).equals(br.adjZ)) {
          continue;
        }
        localObject2 = "profile_friend";
        continue;
        if (!((br)localObject4).equals(br.adka)) {
          continue;
        }
        localObject2 = "profile_stranger";
        continue;
        if (!((br)localObject4).equals(br.adkb)) {
          continue;
        }
        localObject2 = "comment";
        continue;
        if (!((br)localObject4).equals(br.adjV)) {
          continue;
        }
        localObject2 = "timeline";
        continue;
        this.QzS.url = aYY(this.QzS.url);
        continue;
        localObject2 = "SnsAlbumDomainList";
        continue;
        localObject3 = "SnsAlbumMainStandbyIpSwitchTime";
        continue;
      }
      i = 0;
      if (this.QzS.Qoc != null) {
        i = this.QzS.Qoc.size();
      }
      Log.i("MicroMsg.SnsCdnDownloadBase", "to downloadBitmap pack.mediaId: " + this.QzS.mediaId + " pack.mediaObjs.size: " + i + " pack.snsId: " + this.QzS.hQX + " pack.isthumb: " + this.QzS.QzL + " type: " + this.QzS.QzN);
      localObject4 = this.QzS.QzO;
      localObject1 = "";
      if (localObject4 != null) {
        continue;
      }
      localObject1 = "";
      localObject3 = localObject1;
      if (!Util.isNullOrNil((String)localObject1)) {
        localObject3 = "&scene=".concat(String.valueOf(localObject1));
      }
      str = String.format("https://" + WeChatHosts.domainString(b.j.host_weixin_qq_com) + "/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.Yxh), com.tencent.mm.b.p.getString(al.hgh()), Integer.valueOf(NetStatusUtil.getNetTypeForStat(MMApplicationContext.getContext())), Integer.valueOf(ConnectivityCompat.Companion.getCompatMixStrength()), localObject3 });
      if (9 != this.QzS.QzN) {
        continue;
      }
      this.QzS.url = b(this.QzS.url, (dmz)this.QzS.Qoc.get(0));
      this.dnsCostTime = Util.nowMilliSecond();
      if (!this.QzS.QzM) {
        continue;
      }
      localObject1 = "SnsSightDomainList";
      if (!this.QzS.QzM) {
        continue;
      }
      localObject3 = "SnsSightMainStandbyIpSwitchTime";
      localObject1 = i.aRC().getValue((String)localObject1);
      l2 = i.aRC().getInt((String)localObject3, 0);
      Log.i("MicroMsg.SnsCdnDownloadBase", "pack.isAlbum %s pack.isthumb %s hostvalue %s dcipTime %s", new Object[] { Boolean.valueOf(this.QzS.QzM), Boolean.valueOf(this.QzS.QzL), localObject1, Long.valueOf(l2) });
      l1 = l2;
      if (l2 <= 0L) {
        l1 = 259200L;
      }
      bool = a((br)localObject4, this.QzS.url, l1, (String)localObject1);
      this.dnsCostTime = Util.milliSecondsToNow(this.dnsCostTime);
      if (9 != this.QzS.QzN) {
        break label1087;
      }
      localObject1 = new com.tencent.mm.g.f();
      ((com.tencent.mm.g.e)localObject1).taskName = "task_SnsCdnDownloadBase_1";
      i = 0;
      if (i >= this.QzS.Qoc.size()) {
        break label991;
      }
      localObject3 = ((dmz)this.QzS.Qoc.valueAt(i)).Id;
      y.bDX(as.mg(al.getAccSnsPath(), (String)localObject3));
      i += 1;
      continue;
      localObject1 = null;
    }
    Object localObject2;
    label991:
    if (a((com.tencent.mm.g.e)localObject2, bool, str))
    {
      if ((this.QzS != null) && (this.QzS.QzM)) {
        com.tencent.mm.plugin.sns.ad.d.e.a((com.tencent.mm.g.e)localObject2, this.ibT);
      }
      ((com.tencent.mm.g.e)localObject2).lwL = new g.a()
      {
        public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, final com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(96067);
          if (c.this.QzS == null)
          {
            Log.e("MicroMsg.SnsCdnDownloadBase", "pack is null.");
            AppMethodBeat.o(96067);
            return 0;
          }
          Object localObject;
          int j;
          final int i;
          dmz localdmz;
          int k;
          com.tencent.mm.plugin.sns.data.p localp;
          if (paramAnonymousd != null)
          {
            Log.i("MicroMsg.SnsCdnDownloadBase", "download callback mediaId:%s, startRet:%s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt) });
            if (paramAnonymousd.field_retCode != 0)
            {
              Log.e("MicroMsg.SnsCdnDownloadBase", "download err, retCode: %d reqDownType: %d.", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(c.this.QzS.QzN) });
              com.tencent.mm.network.d.reportFailIp(paramAnonymousd.field_serverIP);
              if (9 != c.this.QzS.QzN) {
                break label1289;
              }
              paramAnonymousc = paramAnonymousd.lwB;
              if ((paramAnonymousc != null) && (paramAnonymousc.length > 0))
              {
                com.tencent.mm.plugin.report.service.h.OAn.kJ(1040, 12);
                localObject = (com.tencent.mm.g.f)this.QAn;
                Log.e("MicroMsg.SnsCdnDownloadBase", "download err, taskInfo2 need inc counter, before: %d, inc: %d, count: %d.", new Object[] { Integer.valueOf(((com.tencent.mm.g.f)localObject).evg), Integer.valueOf(paramAnonymousc.length), Integer.valueOf(((com.tencent.mm.g.f)localObject).lwJ) });
                ((com.tencent.mm.g.f)localObject).evg += paramAnonymousc.length;
                j = paramAnonymousc.length;
                i = 0;
                while (i < j)
                {
                  localdmz = paramAnonymousc[i];
                  if (localdmz.retry)
                  {
                    k = localdmz.picIndex;
                    localdmz = (dmz)c.this.QzS.Qoc.get(k);
                    localp = (com.tencent.mm.plugin.sns.data.p)c.this.QzS.QmU.get(k);
                    al.hgw().a(localdmz, 1, localp, c.this.QzS.QzO, ((com.tencent.mm.g.f)localObject).hQX);
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
            paramAnonymousc = c.this.QzS;
            if (paramAnonymousc != null) {}
            try
            {
              if ((paramAnonymousc.Qsr != null) && (paramAnonymousc.Qsr.isAd))
              {
                j = com.tencent.mm.plugin.sns.data.m.aXh(paramAnonymousc.Qsq);
                Log.i("SnsAdUtil", "reportAdPicCDNDownload, result=" + paramAnonymousd.field_retCode + ", requestKey=" + paramAnonymousc.Qsq + ", reqDownType=" + paramAnonymousc.QzN + ", url=" + paramAnonymousc.url);
                if ((j == 1) || (j == 5))
                {
                  if (paramAnonymousd.field_retCode != 0) {
                    break label1139;
                  }
                  com.tencent.mm.plugin.sns.data.m.d(0, 0, 1, paramAnonymousc.url);
                }
              }
            }
            finally
            {
              for (;;)
              {
                label485:
                Log.e("SnsAdUtil", "reportAdPicCDNDownload, exp=" + paramAnonymousc.toString());
              }
            }
            Log.i("MicroMsg.SnsCdnDownloadBase", "download succ start post to ui thread process, type: %d, mediaId:%s %s", new Object[] { Integer.valueOf(c.this.QzS.QzN), paramAnonymousString, c.this.QzS.mediaId });
            al.fAG().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96066);
                if (9 == c.this.QzS.QzN)
                {
                  if (((com.tencent.mm.g.f)c.1.this.QAn).aLI()) {
                    c.hhN().remove(c.this.QzS.Qsq);
                  }
                  Log.i("MicroMsg.SnsCdnDownloadBase", "download done result: %d, url:%s, mediaID:%s, totalSize: %d, runningTasksSize: %d", new Object[] { Integer.valueOf(i), c.this.QzS.url, c.this.QzS.mediaId, Long.valueOf(paramAnonymousd.field_fileLength), Integer.valueOf(c.hhN().size()) });
                  if ((!c.this.QzS.QzL) || (i == 2)) {
                    break label553;
                  }
                  if (9 != c.this.QzS.QzN) {
                    break label511;
                  }
                  be.hc(((dmz)c.this.QzS.Qoc.get(paramAnonymousd.index)).Id, c.this.QzS.mediaType);
                  c.this.akT(paramAnonymousd.index);
                }
                Object localObject1;
                Object localObject2;
                long l;
                for (;;)
                {
                  if (9 != c.this.QzS.QzN) {
                    break label671;
                  }
                  localObject1 = (dmz)c.this.QzS.Qoc.get(paramAnonymousd.index);
                  localObject2 = (com.tencent.mm.g.f)c.1.this.QAn;
                  if ((((com.tencent.mm.g.f)localObject2).aLI()) && (!((com.tencent.mm.g.f)localObject2).lwK))
                  {
                    ((com.tencent.mm.g.f)localObject2).lwK = true;
                    l = Util.milliSecondsToNow(c.1.this.QAo);
                    Log.d("MicroMsg.SnsCdnDownloadBase", "group download, feed cost: %d.", new Object[] { Long.valueOf(l) });
                    com.tencent.mm.plugin.report.service.h.OAn.p(1040L, 3L, l);
                    com.tencent.mm.plugin.report.service.h.OAn.kJ(1040, 4);
                    com.tencent.mm.plugin.report.service.h.OAn.p(1040L, 9L, l);
                    com.tencent.mm.plugin.report.service.h.OAn.p(1040L, 10L, ((com.tencent.mm.g.f)localObject2).lwJ);
                  }
                  c.this.QzQ.a(i, (dmz)localObject1, c.this.QzS.QzN, c.this.QzS.QzL, c.this.QzS.Qsq, (int)paramAnonymousd.field_fileLength, paramAnonymousd.index, ((com.tencent.mm.g.f)localObject2).aLI());
                  AppMethodBeat.o(96066);
                  return;
                  c.hhN().remove(c.this.QzS.Qsq);
                  break;
                  label511:
                  be.hc(c.this.QzS.mediaId, c.this.QzS.mediaType);
                  c.this.hhL();
                  continue;
                  label553:
                  if ((!c.this.QzS.QzL) && ((c.this.QzS.QzN == 4) || (c.this.QzS.QzN == 6)))
                  {
                    localObject1 = c.this.QzS.getPath() + com.tencent.mm.plugin.sns.data.t.i(c.this.ibT);
                    al.hgy().md(c.this.QzS.mediaId, (String)localObject1);
                  }
                }
                label671:
                if (1 == c.this.QzS.QzN)
                {
                  localObject1 = al.hgw();
                  localObject2 = c.this.QzS.mediaId;
                  if (((com.tencent.mm.plugin.sns.model.c)localObject1).QqS.remove(localObject2))
                  {
                    l = Util.milliSecondsToNow(c.1.this.QAo);
                    Log.d("MicroMsg.SnsCdnDownloadBase", "single download cost: %d.", new Object[] { Long.valueOf(l) });
                    com.tencent.mm.plugin.report.service.h.OAn.p(1040L, 6L, l);
                    com.tencent.mm.plugin.report.service.h.OAn.kJ(1040, 7);
                  }
                }
                if (c.this.QzS.QzN == 4) {
                  Log.i("MicroMsg.SnsCdnDownloadBase", "sight download cost=" + Util.milliSecondsToNow(c.1.this.QAo) + ", mediaId=" + c.this.QzS.mediaId);
                }
                c.this.QzQ.a(i, c.this.ibT, c.this.QzS.QzN, c.this.QzS.QzL, c.this.QzS.Qsq, (int)paramAnonymousd.field_fileLength, -1, true);
                AppMethodBeat.o(96066);
              }
            });
            for (;;)
            {
              if (paramAnonymousInt == 0) {
                break label1282;
              }
              Log.e("MicroMsg.SnsCdnDownloadBase", "task build error! startRet: %d, type: %d.", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(c.this.QzS.QzN) });
              if (9 != c.this.QzS.QzN) {
                break label1282;
              }
              com.tencent.mm.plugin.report.service.h.OAn.kJ(1040, 13);
              c.hhN().remove(c.this.QzS.Qsq);
              c.this.QzQ.a(2, null, c.this.QzS.QzN, c.this.QzS.QzL, c.this.QzS.Qsq, -1, -1, true);
              paramAnonymousString = (com.tencent.mm.g.f)this.QAn;
              paramAnonymousc = paramAnonymousString.lwB;
              i = paramAnonymousc.length;
              paramAnonymousInt = 0;
              while (paramAnonymousInt < i)
              {
                j = paramAnonymousc[paramAnonymousInt].picIndex;
                paramAnonymousd = (dmz)c.this.QzS.Qoc.get(j);
                localObject = (com.tencent.mm.plugin.sns.data.p)c.this.QzS.QmU.get(j);
                al.hgw().a(paramAnonymousd, 1, (com.tencent.mm.plugin.sns.data.p)localObject, c.this.QzS.QzO, paramAnonymousString.hQX);
                Log.i("MicroMsg.SnsCdnDownloadBase", "group download err, retry single download. index: %d.", new Object[] { Integer.valueOf(j) });
                paramAnonymousInt += 1;
              }
              com.tencent.mm.plugin.report.service.h.OAn.kJ(1040, 14);
              Log.e("MicroMsg.SnsCdnDownloadBase", "download error, totally re-download by single.");
              paramAnonymousc = (com.tencent.mm.g.f)this.QAn;
              paramAnonymousc.evg = paramAnonymousc.lwJ;
              localObject = paramAnonymousc.lwB;
              j = localObject.length;
              i = 0;
              while (i < j)
              {
                k = localObject[i].picIndex;
                localdmz = (dmz)c.this.QzS.Qoc.get(k);
                localp = (com.tencent.mm.plugin.sns.data.p)c.this.QzS.QmU.get(k);
                al.hgw().a(localdmz, 1, localp, c.this.QzS.QzO, paramAnonymousc.hQX);
                Log.i("MicroMsg.SnsCdnDownloadBase", "group download err, retry single download. index: %d.", new Object[] { Integer.valueOf(k) });
                i += 1;
              }
              i = 2;
              break;
              Log.i("MicroMsg.SnsCdnDownloadBase", "download succ, type: %d, mediaId:%s", new Object[] { Integer.valueOf(c.this.QzS.QzN), paramAnonymousString });
              c.this.QAl = ((int)paramAnonymousd.field_fileLength);
              if (9 == c.this.QzS.QzN)
              {
                paramAnonymousc = (com.tencent.mm.g.f)this.QAn;
                paramAnonymousc.evg += 1;
                Log.d("MicroMsg.SnsCdnDownloadBase", "download succ, counter++, res: %d, count: %d.", new Object[] { Integer.valueOf(paramAnonymousc.evg), Integer.valueOf(paramAnonymousc.lwJ) });
              }
              for (paramAnonymousBoolean = c.this.akS(paramAnonymousd.index);; paramAnonymousBoolean = c.this.hhI())
              {
                if (paramAnonymousBoolean) {
                  break label1114;
                }
                i = 2;
                break;
              }
              label1114:
              if (c.this.QzS.QzL)
              {
                i = 3;
                break;
              }
              i = 1;
              break;
              label1139:
              com.tencent.mm.plugin.sns.data.m.d(1, 0, 1, paramAnonymousc.url);
              break label485;
              if (paramAnonymousc != null)
              {
                float f = (float)paramAnonymousc.field_finishedLength / (float)paramAnonymousc.field_toltalLength;
                if (c.this.QzS.QzP < f)
                {
                  c.this.QzS.QzP = f;
                  Log.d("MicroMsg.SnsCdnDownloadBase", "Download sns image type: %d, mediaId: %s, progress: %f, url: %s", new Object[] { Integer.valueOf(c.this.QzS.QzN), paramAnonymousString, Float.valueOf(f), c.this.QzS.url });
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
        
        public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
        {
          return new byte[0];
        }
      };
      if (k.bHW().b((com.tencent.mm.g.g)localObject2, -1)) {
        Log.i("MicroMsg.SnsCdnDownloadBase", "SubCoreCdnTransport addRecvTask succ mediaId:%s", new Object[] { ((com.tencent.mm.g.e)localObject2).field_mediaId });
      }
    }
    for (int i = 1;; i = 2)
    {
      return Integer.valueOf(i);
      label1087:
      y.bDX(this.QzS.getPath());
      localObject2 = new com.tencent.mm.g.e();
      ((com.tencent.mm.g.e)localObject2).taskName = "task_SnsCdnDownloadBase_2";
      break;
      Log.w("MicroMsg.SnsCdnDownloadBase", "SubCoreCdnTransport addRecvTask failed mediaId:%s", new Object[] { ((com.tencent.mm.g.e)localObject2).field_mediaId });
    }
  }
  
  public void hhL()
  {
    if (al.isInValid()) {
      return;
    }
    System.currentTimeMillis();
    Object localObject1;
    Object localObject2;
    if (this.QzS.QmT.QnY == 4)
    {
      Log.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur thumb");
      localObject1 = com.tencent.mm.plugin.sns.data.t.d(this.ibT);
      localObject2 = com.tencent.mm.plugin.sns.data.t.f(this.ibT);
      this.QzR = com.tencent.mm.plugin.sns.lucky.a.a.mb(this.QzS.getPath() + (String)localObject1, this.QzS.getPath() + (String)localObject2);
      al.hgy().a(this.QzS.mediaId, this.QzR, this.QzS.QmT.QnY);
      label133:
      localObject1 = null;
      if (this.QzS.QmT.QnY != 0) {
        break label597;
      }
      localObject1 = "0-" + this.QzS.QmT.hOG;
    }
    for (;;)
    {
      al.hgy().aYg((String)localObject1);
      return;
      if (this.QzS.QmT.QnY == 5)
      {
        Log.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur grid");
        localObject1 = com.tencent.mm.plugin.sns.data.t.d(this.ibT);
        localObject2 = com.tencent.mm.plugin.sns.data.t.g(this.ibT);
        this.QzR = com.tencent.mm.plugin.sns.lucky.a.a.mb(this.QzS.getPath() + (String)localObject1, this.QzS.getPath() + (String)localObject2);
        al.hgy().a(this.QzS.mediaId, this.QzR, this.QzS.QmT.QnY);
        break label133;
      }
      if (this.QzS.QmT.list.size() <= 1)
      {
        al.hgy().a(this.QzS.mediaId, this.QzR, this.QzS.QmT.QnY);
        break label133;
      }
      al.hgy().a(this.QzS.mediaId, this.QzR, 0);
      localObject1 = new LinkedList();
      int i = 0;
      for (;;)
      {
        if ((i >= this.QzS.QmT.list.size()) || (i >= 4)) {
          break label504;
        }
        localObject2 = (dmz)this.QzS.QmT.list.get(i);
        com.tencent.mm.memory.m localm = al.hgy().aYh(((dmz)localObject2).Id);
        if (!com.tencent.mm.plugin.sns.data.t.b(localm)) {
          break;
        }
        ((List)localObject1).add(localm);
        Log.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap from " + localm + " " + ((dmz)localObject2).Id);
        i += 1;
      }
      label504:
      this.QzR = com.tencent.mm.memory.m.O(com.tencent.mm.plugin.sns.data.t.T((List)localObject1, al.hgP()));
      Log.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap " + this.QzS.QmT.hOG + " " + this.QzR);
      al.hgy().a(this.QzS.QmT.hOG, this.QzR, this.QzS.QmT.QnY);
      break label133;
      label597:
      if (this.QzS.QmT.QnY == 1) {
        localObject1 = "1-" + this.QzS.QmT.hOG;
      } else if (this.QzS.QmT.QnY == 4) {
        localObject1 = "4-" + this.QzS.QmT.hOG;
      } else if (this.QzS.QmT.QnY == 5) {
        localObject1 = "5-" + this.QzS.QmT.hOG;
      } else if (this.QzS.QmT.QnY == 3) {
        localObject1 = com.tencent.mm.plugin.sns.data.t.db(3, this.QzS.QmT.hOG);
      }
    }
  }
  
  public final void hhM()
  {
    if (this.QzS != null) {
      Log.i("MicroMsg.SnsCdnDownloadBase", "checkCdnPath: %s", new Object[] { Boolean.valueOf(y.bDX(this.QzS.getPath())) });
    }
  }
  
  public void onPostExecute(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, dmz paramdmz, int paramInt2, boolean paramBoolean1, String paramString, int paramInt3, int paramInt4, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.c
 * JD-Core Version:    0.7.0.1
 */