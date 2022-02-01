package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g
{
  private static int[] zvJ = { 50, 66, 68, 88, 99, 121, 123, 166, 168, 188, 199, 233, 266, 268, 288, 299, 369, 419, 520, 666, 1024 };
  private static String zvd;
  private static g zve = null;
  public long iks;
  private StringBuffer nCG;
  public long nJM;
  public String zvA;
  public String zvB;
  public String zvC;
  public String zvD;
  public String zvE;
  public int zvF;
  public String zvG;
  private List<List<Integer>> zvH;
  private List<Integer> zvI;
  private LinkedList<c> zvK;
  public String zvb;
  public String zvf;
  public int zvg;
  public int zvh;
  public long zvi;
  public long zvj;
  public String zvk;
  public long zvl;
  public long zvm;
  public String zvn;
  public String zvo;
  public String zvp;
  public String zvq;
  public String zvr;
  public String zvs;
  public String zvt;
  public String zvu;
  public String zvv;
  public String zvw;
  public String zvx;
  public String zvy;
  public String zvz;
  
  static
  {
    zvd = "";
  }
  
  public g()
  {
    AppMethodBeat.i(95180);
    this.iks = 0L;
    this.nJM = 0L;
    this.zvf = "";
    this.zvg = 0;
    this.zvh = 0;
    this.zvb = "";
    this.zvi = 0L;
    this.zvj = 0L;
    this.zvk = "";
    this.zvl = 0L;
    this.zvm = 0L;
    this.zvn = "";
    this.zvo = "";
    this.zvp = "";
    this.zvq = "";
    this.zvr = "";
    this.zvs = "";
    this.zvt = "";
    this.zvu = "";
    this.zvv = "";
    this.zvw = "";
    this.zvx = "";
    this.zvy = "";
    this.zvz = "";
    this.zvA = "";
    this.zvB = "";
    this.zvC = "";
    this.zvD = "";
    this.zvE = "";
    this.zvF = -1;
    this.zvG = "";
    this.zvH = new LinkedList();
    this.zvI = new LinkedList();
    this.zvK = new LinkedList();
    this.nCG = new StringBuffer();
    AppMethodBeat.o(95180);
  }
  
  public static g dWC()
  {
    AppMethodBeat.i(95181);
    com.tencent.mm.kernel.g.ajS();
    if (!com.tencent.mm.kernel.g.ajP().aiZ())
    {
      localObject1 = new g();
      AppMethodBeat.o(95181);
      return localObject1;
    }
    Object localObject3 = com.tencent.mm.model.c.d.aDI().xi("100068");
    Object localObject2 = ((com.tencent.mm.storage.c)localObject3).field_rawXML;
    Object localObject1 = localObject2;
    if (bu.isNullOrNil((String)localObject2)) {
      localObject1 = "";
    }
    String str = com.tencent.mm.b.g.getMessageDigest(((String)localObject1).getBytes());
    if ((zve == null) || (!str.equals(zvd)))
    {
      ae.i("MicroMsg.NewYearSnsCtrlV2", "create newYearSnsCtrl");
      zve = new g();
    }
    for (;;)
    {
      try
      {
        localObject2 = ((com.tencent.mm.storage.c)localObject3).fsy();
        localObject1 = "";
        if (localObject2 != null) {
          localObject1 = (String)((Map)localObject2).get("SnsHBConfig");
        }
        localObject2 = localObject1;
        if (bu.isNullOrNil((String)localObject1)) {
          localObject2 = "";
        }
        localObject1 = URLDecoder.decode((String)localObject2, "UTF-8");
        localObject2 = zve;
        ((g)localObject2).nCG = new StringBuffer();
        ((g)localObject2).zvK.clear();
        localObject3 = bx.M((String)localObject1, "sysmsg");
        if (localObject3 != null) {
          continue;
        }
        ae.i("MicroMsg.NewYearSnsCtrlV2", "errr for paser %s", new Object[] { localObject1 });
        zvd = str;
      }
      catch (Exception localException)
      {
        int i;
        int k;
        LinkedList localLinkedList;
        int j;
        StringBuilder localStringBuilder;
        int m;
        ae.e("MicroMsg.NewYearSnsCtrlV2", "createctrl error " + localException.getMessage());
        continue;
      }
      localObject1 = zve;
      AppMethodBeat.o(95181);
      return localObject1;
      ((g)localObject2).iks = bu.aSC((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.BeginTime"));
      ((g)localObject2).nCG.append("BeginTime:" + ((g)localObject2).iks + ";");
      ((g)localObject2).nJM = bu.aSC((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.EndTime"));
      ((g)localObject2).nCG.append("EndTime:" + ((g)localObject2).nJM + ";\n");
      ((g)localObject2).zvg = bu.aSB((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMin"));
      ((g)localObject2).zvh = bu.aSB((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMax"));
      ((g)localObject2).nCG.append("SvrDownReqLimitLevelMin:" + ((g)localObject2).zvg + " SvrDownReqLimitLevelMax: " + ((g)localObject2).zvh + ";\n");
      ((g)localObject2).zvl = bu.aSC((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseBeginTime"));
      ((g)localObject2).zvm = bu.aSC((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseEndTime"));
      ((g)localObject2).zvn = bu.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenTitle"), "");
      ((g)localObject2).zvo = bu.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenDescription"), "");
      ((g)localObject2).zvp = bu.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenQueryTips"), "");
      ((g)localObject2).zvq = bu.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenAcceptButtonText"), "");
      ((g)localObject2).zvr = bu.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenRejectButtonText"), "");
      ((g)localObject2).zvs = bu.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenTips"), "");
      ((g)localObject2).zvu = bu.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenSuccTips"), "");
      ((g)localObject2).zvv = bu.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenFailTips"), "");
      ((g)localObject2).zvt = bu.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseTips"), "");
      ((g)localObject2).zvw = bu.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseSuccTips"), "");
      ((g)localObject2).zvx = bu.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseFailTips"), "");
      ((g)localObject2).zvE = bu.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedID"), "");
      ((g)localObject2).zvF = bu.aSB((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedCount"));
      ((g)localObject2).zvG = bu.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenID"), "");
      if (((g)localObject2).zvF <= 0)
      {
        ae.i("MicroMsg.NewYearSnsCtrlV2", "svr MaxPostFeedCount error " + ((g)localObject2).zvF);
        ((g)localObject2).zvF = 1;
      }
      ((g)localObject2).nCG.append("FullScreenID:" + ((g)localObject2).zvG + " BrowseBeginTime:" + ((g)localObject2).zvl + " BrowseEndTime:" + ((g)localObject2).zvm + " FullScreenTitle:" + ((g)localObject2).zvn + " FullScreenDescription:" + ((g)localObject2).zvo + " FullScreenQueryTips:" + ((g)localObject2).zvp + " FullScreenAcceptButtonText: " + ((g)localObject2).zvq);
      ((g)localObject2).nCG.append("FullScreenRejectButtonText:" + ((g)localObject2).zvr + " ActionSheetOpenTips:" + ((g)localObject2).zvs + " ActionSheetOpenSuccTips:" + ((g)localObject2).zvu + " ActionSheetOpenFailTips:" + ((g)localObject2).zvv + " ActionSheetCloseTips:" + ((g)localObject2).zvt + " ActionSheetCloseSuccTips: " + ((g)localObject2).zvw + " ActionSheetCloseFailTips: " + ((g)localObject2).zvx + "MaxPostFeedID: " + ((g)localObject2).zvE + " MaxPostFeedCount:" + ((g)localObject2).zvF);
      ((g)localObject2).zvy = bu.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForHasUsed"), "");
      ((g)localObject2).zvz = bu.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForObtainUsedRight"), "");
      ((g)localObject2).zvA = bu.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForClosedBrowseSwitch"), "");
      ((g)localObject2).zvB = bu.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertButtonText"), "");
      ((g)localObject2).zvC = bu.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTip"), "");
      ((g)localObject2).zvD = bu.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTipID"), "");
      ((g)localObject2).nCG.append("AlertTipForHasUsed:" + ((g)localObject2).zvy + " AlertTipForObtainUsedRight:" + ((g)localObject2).zvz + " AlertTipForClosedBrowseSwitch:" + ((g)localObject2).zvA + " AlertButtonText:" + ((g)localObject2).zvB + " GoldenCameraTip:" + ((g)localObject2).zvC + " GoldenCameraTipID:" + ((g)localObject2).zvD);
      i = 0;
      if (i == 0)
      {
        localObject1 = "";
        ((g)localObject2).zvb = bu.bI((String)((Map)localObject3).get(String.format(".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s", new Object[] { localObject1, "RedPointID" })), "");
        ((g)localObject2).nCG.append("RedPointID:" + ((g)localObject2).zvb + ";");
        if (bu.isNullOrNil(((g)localObject2).zvb)) {
          continue;
        }
        if (i == 0)
        {
          localObject1 = "";
          ((g)localObject2).zvi = bu.aSC((String)((Map)localObject3).get(String.format(".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s", new Object[] { localObject1, "BeginTime" })));
          ((g)localObject2).nCG.append("RedPointID_BeginTime:" + ((g)localObject2).zvi + ";");
          if (i != 0) {
            continue;
          }
          localObject1 = "";
          ((g)localObject2).zvj = bu.aSC((String)((Map)localObject3).get(String.format(".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s", new Object[] { localObject1, "EndTime" })));
          ((g)localObject2).nCG.append("RedPointID_EndTime:" + ((g)localObject2).zvj + ";\n");
          localObject1 = new c();
          ((c)localObject1).zvb = ((g)localObject2).zvb;
          ((c)localObject1).iks = ((g)localObject2).zvi;
          ((c)localObject1).nJM = ((g)localObject2).zvj;
          ((g)localObject2).zvK.add(localObject1);
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
      ((g)localObject2).zvk = bu.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.PostTips"), "");
      ((g)localObject2).nCG.append("PostTips:" + ((g)localObject2).zvk + ";");
      ((g)localObject2).zvf = bu.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.EntranceTips"), "");
      ((g)localObject2).nCG.append("EntranceTips:" + ((g)localObject2).zvf + ";");
      ((g)localObject2).zvH.clear();
      i = 0;
      k = bu.aSB((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.AmountLevel" + i + ".Count"));
      ((g)localObject2).nCG.append("count: " + i + " | " + k + ";\n");
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
            m = bu.aSB((String)((Map)localObject3).get(localObject1));
            localLinkedList.add(Integer.valueOf(m));
            ((g)localObject2).nCG.append("AmountLevel : " + i + " index " + j + " val: " + m + ";");
            j += 1;
          }
          else
          {
            localObject1 = Integer.valueOf(j);
          }
        }
        else
        {
          ((g)localObject2).zvH.add(localLinkedList);
          i += 1;
        }
      }
      else
      {
        ae.i("MicroMsg.NewYearSnsCtrlV2", "dumpinfo " + ((g)localObject2).nCG.toString());
      }
    }
  }
  
  public static boolean dWD()
  {
    AppMethodBeat.i(95182);
    com.tencent.mm.kernel.g.ajS();
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IOI, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(95182);
    return bool;
  }
  
  public final void dWE()
  {
    AppMethodBeat.i(95183);
    Object localObject = k.h(am.a.IOM);
    if ((((i)localObject).zHW == null) || (bu.isNullOrNil(((i)localObject).zHW.postId)))
    {
      ((i)localObject).zHW = new com.tencent.mm.plugin.sns.i.g();
      ((i)localObject).zHW.postId = this.zvE;
      ((i)localObject).zHW.zHU = 0;
    }
    if ((!bu.isNullOrNil(((i)localObject).zHW.postId)) && (((i)localObject).zHW.postId.equals(this.zvE)))
    {
      com.tencent.mm.plugin.sns.i.g localg = ((i)localObject).zHW;
      localg.zHU -= 1;
      if (((i)localObject).zHW.zHU < 0) {
        ((i)localObject).zHW.zHU = 0;
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.NewYearSnsCtrlV2", "minusPostCountV2 " + ((i)localObject).zHW.zHU + " postId: " + this.zvE + " " + bu.fpN().toString());
      try
      {
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IOM, new String(((i)localObject).toByteArray(), Charset.forName("ISO-8859-1")));
        localObject = new ui();
        com.tencent.mm.sdk.b.a.IvT.l((b)localObject);
        AppMethodBeat.o(95183);
        return;
        ((i)localObject).zHW = new com.tencent.mm.plugin.sns.i.g();
        ((i)localObject).zHW.postId = this.zvE;
        ((i)localObject).zHW.zHU = 0;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ae.w("MicroMsg.NewYearSnsCtrlV2", "minusPostCountV2 save exception:" + localIOException.getLocalizedMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.g
 * JD-Core Version:    0.7.0.1
 */