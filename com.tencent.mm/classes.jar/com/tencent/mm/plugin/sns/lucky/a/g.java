package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tc;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sns.j.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g
{
  private static String wBZ = "";
  private static int[] wCF = { 50, 66, 68, 88, 99, 121, 123, 166, 168, 188, 199, 233, 266, 268, 288, 299, 369, 419, 520, 666, 1024 };
  private static g wCa = null;
  public long hnI;
  public long mBT;
  private StringBuffer muN;
  public String wBX;
  public String wCA;
  public int wCB;
  public String wCC;
  private List<List<Integer>> wCD;
  private List<Integer> wCE;
  private LinkedList<c> wCG;
  public String wCb;
  public int wCc;
  public int wCd;
  public long wCe;
  public long wCf;
  public String wCg;
  public long wCh;
  public long wCi;
  public String wCj;
  public String wCk;
  public String wCl;
  public String wCm;
  public String wCn;
  public String wCo;
  public String wCp;
  public String wCq;
  public String wCr;
  public String wCs;
  public String wCt;
  public String wCu;
  public String wCv;
  public String wCw;
  public String wCx;
  public String wCy;
  public String wCz;
  
  public g()
  {
    AppMethodBeat.i(95180);
    this.hnI = 0L;
    this.mBT = 0L;
    this.wCb = "";
    this.wCc = 0;
    this.wCd = 0;
    this.wBX = "";
    this.wCe = 0L;
    this.wCf = 0L;
    this.wCg = "";
    this.wCh = 0L;
    this.wCi = 0L;
    this.wCj = "";
    this.wCk = "";
    this.wCl = "";
    this.wCm = "";
    this.wCn = "";
    this.wCo = "";
    this.wCp = "";
    this.wCq = "";
    this.wCr = "";
    this.wCs = "";
    this.wCt = "";
    this.wCu = "";
    this.wCv = "";
    this.wCw = "";
    this.wCx = "";
    this.wCy = "";
    this.wCz = "";
    this.wCA = "";
    this.wCB = -1;
    this.wCC = "";
    this.wCD = new LinkedList();
    this.wCE = new LinkedList();
    this.wCG = new LinkedList();
    this.muN = new StringBuffer();
    AppMethodBeat.o(95180);
  }
  
  public static g dsq()
  {
    AppMethodBeat.i(95181);
    com.tencent.mm.kernel.g.afC();
    if (!com.tencent.mm.kernel.g.afz().aeI())
    {
      localObject1 = new g();
      AppMethodBeat.o(95181);
      return localObject1;
    }
    Object localObject3 = com.tencent.mm.model.c.d.aty().qu("100068");
    Object localObject2 = ((com.tencent.mm.storage.c)localObject3).field_rawXML;
    Object localObject1 = localObject2;
    if (bt.isNullOrNil((String)localObject2)) {
      localObject1 = "";
    }
    String str = com.tencent.mm.b.g.getMessageDigest(((String)localObject1).getBytes());
    if ((wCa == null) || (!str.equals(wBZ)))
    {
      ad.i("MicroMsg.NewYearSnsCtrlV2", "create newYearSnsCtrl");
      wCa = new g();
    }
    for (;;)
    {
      try
      {
        localObject2 = ((com.tencent.mm.storage.c)localObject3).eJy();
        localObject1 = "";
        if (localObject2 != null) {
          localObject1 = (String)((Map)localObject2).get("SnsHBConfig");
        }
        localObject2 = localObject1;
        if (bt.isNullOrNil((String)localObject1)) {
          localObject2 = "";
        }
        localObject1 = URLDecoder.decode((String)localObject2, "UTF-8");
        localObject2 = wCa;
        ((g)localObject2).muN = new StringBuffer();
        ((g)localObject2).wCG.clear();
        localObject3 = bw.K((String)localObject1, "sysmsg");
        if (localObject3 != null) {
          continue;
        }
        ad.i("MicroMsg.NewYearSnsCtrlV2", "errr for paser %s", new Object[] { localObject1 });
        wBZ = str;
      }
      catch (Exception localException)
      {
        int i;
        int k;
        LinkedList localLinkedList;
        int j;
        StringBuilder localStringBuilder;
        int m;
        ad.e("MicroMsg.NewYearSnsCtrlV2", "createctrl error " + localException.getMessage());
        continue;
      }
      localObject1 = wCa;
      AppMethodBeat.o(95181);
      return localObject1;
      ((g)localObject2).hnI = bt.aGi((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.BeginTime"));
      ((g)localObject2).muN.append("BeginTime:" + ((g)localObject2).hnI + ";");
      ((g)localObject2).mBT = bt.aGi((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.EndTime"));
      ((g)localObject2).muN.append("EndTime:" + ((g)localObject2).mBT + ";\n");
      ((g)localObject2).wCc = bt.aGh((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMin"));
      ((g)localObject2).wCd = bt.aGh((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMax"));
      ((g)localObject2).muN.append("SvrDownReqLimitLevelMin:" + ((g)localObject2).wCc + " SvrDownReqLimitLevelMax: " + ((g)localObject2).wCd + ";\n");
      ((g)localObject2).wCh = bt.aGi((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseBeginTime"));
      ((g)localObject2).wCi = bt.aGi((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseEndTime"));
      ((g)localObject2).wCj = bt.by((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenTitle"), "");
      ((g)localObject2).wCk = bt.by((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenDescription"), "");
      ((g)localObject2).wCl = bt.by((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenQueryTips"), "");
      ((g)localObject2).wCm = bt.by((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenAcceptButtonText"), "");
      ((g)localObject2).wCn = bt.by((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenRejectButtonText"), "");
      ((g)localObject2).wCo = bt.by((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenTips"), "");
      ((g)localObject2).wCq = bt.by((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenSuccTips"), "");
      ((g)localObject2).wCr = bt.by((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenFailTips"), "");
      ((g)localObject2).wCp = bt.by((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseTips"), "");
      ((g)localObject2).wCs = bt.by((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseSuccTips"), "");
      ((g)localObject2).wCt = bt.by((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseFailTips"), "");
      ((g)localObject2).wCA = bt.by((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedID"), "");
      ((g)localObject2).wCB = bt.aGh((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedCount"));
      ((g)localObject2).wCC = bt.by((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenID"), "");
      if (((g)localObject2).wCB <= 0)
      {
        ad.i("MicroMsg.NewYearSnsCtrlV2", "svr MaxPostFeedCount error " + ((g)localObject2).wCB);
        ((g)localObject2).wCB = 1;
      }
      ((g)localObject2).muN.append("FullScreenID:" + ((g)localObject2).wCC + " BrowseBeginTime:" + ((g)localObject2).wCh + " BrowseEndTime:" + ((g)localObject2).wCi + " FullScreenTitle:" + ((g)localObject2).wCj + " FullScreenDescription:" + ((g)localObject2).wCk + " FullScreenQueryTips:" + ((g)localObject2).wCl + " FullScreenAcceptButtonText: " + ((g)localObject2).wCm);
      ((g)localObject2).muN.append("FullScreenRejectButtonText:" + ((g)localObject2).wCn + " ActionSheetOpenTips:" + ((g)localObject2).wCo + " ActionSheetOpenSuccTips:" + ((g)localObject2).wCq + " ActionSheetOpenFailTips:" + ((g)localObject2).wCr + " ActionSheetCloseTips:" + ((g)localObject2).wCp + " ActionSheetCloseSuccTips: " + ((g)localObject2).wCs + " ActionSheetCloseFailTips: " + ((g)localObject2).wCt + "MaxPostFeedID: " + ((g)localObject2).wCA + " MaxPostFeedCount:" + ((g)localObject2).wCB);
      ((g)localObject2).wCu = bt.by((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForHasUsed"), "");
      ((g)localObject2).wCv = bt.by((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForObtainUsedRight"), "");
      ((g)localObject2).wCw = bt.by((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForClosedBrowseSwitch"), "");
      ((g)localObject2).wCx = bt.by((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertButtonText"), "");
      ((g)localObject2).wCy = bt.by((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTip"), "");
      ((g)localObject2).wCz = bt.by((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTipID"), "");
      ((g)localObject2).muN.append("AlertTipForHasUsed:" + ((g)localObject2).wCu + " AlertTipForObtainUsedRight:" + ((g)localObject2).wCv + " AlertTipForClosedBrowseSwitch:" + ((g)localObject2).wCw + " AlertButtonText:" + ((g)localObject2).wCx + " GoldenCameraTip:" + ((g)localObject2).wCy + " GoldenCameraTipID:" + ((g)localObject2).wCz);
      i = 0;
      if (i == 0)
      {
        localObject1 = "";
        ((g)localObject2).wBX = bt.by((String)((Map)localObject3).get(String.format(".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s", new Object[] { localObject1, "RedPointID" })), "");
        ((g)localObject2).muN.append("RedPointID:" + ((g)localObject2).wBX + ";");
        if (bt.isNullOrNil(((g)localObject2).wBX)) {
          continue;
        }
        if (i == 0)
        {
          localObject1 = "";
          ((g)localObject2).wCe = bt.aGi((String)((Map)localObject3).get(String.format(".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s", new Object[] { localObject1, "BeginTime" })));
          ((g)localObject2).muN.append("RedPointID_BeginTime:" + ((g)localObject2).wCe + ";");
          if (i != 0) {
            continue;
          }
          localObject1 = "";
          ((g)localObject2).wCf = bt.aGi((String)((Map)localObject3).get(String.format(".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s", new Object[] { localObject1, "EndTime" })));
          ((g)localObject2).muN.append("RedPointID_EndTime:" + ((g)localObject2).wCf + ";\n");
          localObject1 = new c();
          ((c)localObject1).wBX = ((g)localObject2).wBX;
          ((c)localObject1).hnI = ((g)localObject2).wCe;
          ((c)localObject1).mBT = ((g)localObject2).wCf;
          ((g)localObject2).wCG.add(localObject1);
          i += 1;
        }
      }
      else
      {
        localObject1 = String.valueOf(i);
        continue;
      }
      localObject1 = String.valueOf(i);
      continue;
      localObject1 = String.valueOf(i);
      continue;
      ((g)localObject2).wCg = bt.by((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.PostTips"), "");
      ((g)localObject2).muN.append("PostTips:" + ((g)localObject2).wCg + ";");
      ((g)localObject2).wCb = bt.by((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.EntranceTips"), "");
      ((g)localObject2).muN.append("EntranceTips:" + ((g)localObject2).wCb + ";");
      ((g)localObject2).wCD.clear();
      i = 0;
      k = bt.aGh((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.AmountLevel" + i + ".Count"));
      ((g)localObject2).muN.append("count: " + i + " | " + k + ";\n");
      if (k != 0)
      {
        localLinkedList = new LinkedList();
        j = 0;
        if (j < k)
        {
          localStringBuilder = new StringBuilder(".sysmsg.NewYearSNSCtrl2016.AmountLevel").append(i).append(".Amount");
          if (j == 0)
          {
            localObject1 = "";
            m = bt.aGh((String)((Map)localObject3).get(localObject1));
            localLinkedList.add(Integer.valueOf(m));
            ((g)localObject2).muN.append("AmountLevel : " + i + " index " + j + " val: " + m + ";");
            j += 1;
          }
          else
          {
            localObject1 = Integer.valueOf(j);
          }
        }
        else
        {
          ((g)localObject2).wCD.add(localLinkedList);
          i += 1;
        }
      }
      else
      {
        ad.i("MicroMsg.NewYearSnsCtrlV2", "dumpinfo " + ((g)localObject2).muN.toString());
      }
    }
  }
  
  public static boolean dsr()
  {
    AppMethodBeat.i(95182);
    com.tencent.mm.kernel.g.afC();
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fke, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(95182);
    return bool;
  }
  
  public final void dss()
  {
    AppMethodBeat.i(95183);
    Object localObject = k.h(ae.a.Fki);
    if ((((i)localObject).wOe == null) || (bt.isNullOrNil(((i)localObject).wOe.postId)))
    {
      ((i)localObject).wOe = new com.tencent.mm.plugin.sns.j.g();
      ((i)localObject).wOe.postId = this.wCA;
      ((i)localObject).wOe.wOc = 0;
    }
    if ((!bt.isNullOrNil(((i)localObject).wOe.postId)) && (((i)localObject).wOe.postId.equals(this.wCA)))
    {
      com.tencent.mm.plugin.sns.j.g localg = ((i)localObject).wOe;
      localg.wOc -= 1;
      if (((i)localObject).wOe.wOc < 0) {
        ((i)localObject).wOe.wOc = 0;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.NewYearSnsCtrlV2", "minusPostCountV2 " + ((i)localObject).wOe.wOc + " postId: " + this.wCA + " " + bt.eGN().toString());
      try
      {
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fki, new String(((i)localObject).toByteArray(), Charset.forName("ISO-8859-1")));
        localObject = new tc();
        com.tencent.mm.sdk.b.a.ESL.l((b)localObject);
        AppMethodBeat.o(95183);
        return;
        ((i)localObject).wOe = new com.tencent.mm.plugin.sns.j.g();
        ((i)localObject).wOe.postId = this.wCA;
        ((i)localObject).wOe.wOc = 0;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ad.w("MicroMsg.NewYearSnsCtrlV2", "minusPostCountV2 save exception:" + localIOException.getLocalizedMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.g
 * JD-Core Version:    0.7.0.1
 */