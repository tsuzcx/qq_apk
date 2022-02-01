package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g
{
  private static String xOu = "";
  private static g xOv = null;
  private static int[] xPa = { 50, 66, 68, 88, 99, 121, 123, 166, 168, 188, 199, 233, 266, 268, 288, 299, 369, 419, 520, 666, 1024 };
  public long hOl;
  private StringBuffer mWO;
  public long ndU;
  public long xOA;
  public String xOB;
  public long xOC;
  public long xOD;
  public String xOE;
  public String xOF;
  public String xOG;
  public String xOH;
  public String xOI;
  public String xOJ;
  public String xOK;
  public String xOL;
  public String xOM;
  public String xON;
  public String xOO;
  public String xOP;
  public String xOQ;
  public String xOR;
  public String xOS;
  public String xOT;
  public String xOU;
  public String xOV;
  public int xOW;
  public String xOX;
  private List<List<Integer>> xOY;
  private List<Integer> xOZ;
  public String xOs;
  public String xOw;
  public int xOx;
  public int xOy;
  public long xOz;
  private LinkedList<c> xPb;
  
  public g()
  {
    AppMethodBeat.i(95180);
    this.hOl = 0L;
    this.ndU = 0L;
    this.xOw = "";
    this.xOx = 0;
    this.xOy = 0;
    this.xOs = "";
    this.xOz = 0L;
    this.xOA = 0L;
    this.xOB = "";
    this.xOC = 0L;
    this.xOD = 0L;
    this.xOE = "";
    this.xOF = "";
    this.xOG = "";
    this.xOH = "";
    this.xOI = "";
    this.xOJ = "";
    this.xOK = "";
    this.xOL = "";
    this.xOM = "";
    this.xON = "";
    this.xOO = "";
    this.xOP = "";
    this.xOQ = "";
    this.xOR = "";
    this.xOS = "";
    this.xOT = "";
    this.xOU = "";
    this.xOV = "";
    this.xOW = -1;
    this.xOX = "";
    this.xOY = new LinkedList();
    this.xOZ = new LinkedList();
    this.xPb = new LinkedList();
    this.mWO = new StringBuffer();
    AppMethodBeat.o(95180);
  }
  
  public static g dGP()
  {
    AppMethodBeat.i(95181);
    com.tencent.mm.kernel.g.agS();
    if (!com.tencent.mm.kernel.g.agP().afY())
    {
      localObject1 = new g();
      AppMethodBeat.o(95181);
      return localObject1;
    }
    Object localObject3 = com.tencent.mm.model.c.d.aAp().tJ("100068");
    Object localObject2 = ((com.tencent.mm.storage.c)localObject3).field_rawXML;
    Object localObject1 = localObject2;
    if (bs.isNullOrNil((String)localObject2)) {
      localObject1 = "";
    }
    String str = com.tencent.mm.b.g.getMessageDigest(((String)localObject1).getBytes());
    if ((xOv == null) || (!str.equals(xOu)))
    {
      ac.i("MicroMsg.NewYearSnsCtrlV2", "create newYearSnsCtrl");
      xOv = new g();
    }
    for (;;)
    {
      try
      {
        localObject2 = ((com.tencent.mm.storage.c)localObject3).eYV();
        localObject1 = "";
        if (localObject2 != null) {
          localObject1 = (String)((Map)localObject2).get("SnsHBConfig");
        }
        localObject2 = localObject1;
        if (bs.isNullOrNil((String)localObject1)) {
          localObject2 = "";
        }
        localObject1 = URLDecoder.decode((String)localObject2, "UTF-8");
        localObject2 = xOv;
        ((g)localObject2).mWO = new StringBuffer();
        ((g)localObject2).xPb.clear();
        localObject3 = bv.L((String)localObject1, "sysmsg");
        if (localObject3 != null) {
          continue;
        }
        ac.i("MicroMsg.NewYearSnsCtrlV2", "errr for paser %s", new Object[] { localObject1 });
        xOu = str;
      }
      catch (Exception localException)
      {
        int i;
        int k;
        LinkedList localLinkedList;
        int j;
        StringBuilder localStringBuilder;
        int m;
        ac.e("MicroMsg.NewYearSnsCtrlV2", "createctrl error " + localException.getMessage());
        continue;
      }
      localObject1 = xOv;
      AppMethodBeat.o(95181);
      return localObject1;
      ((g)localObject2).hOl = bs.aLz((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.BeginTime"));
      ((g)localObject2).mWO.append("BeginTime:" + ((g)localObject2).hOl + ";");
      ((g)localObject2).ndU = bs.aLz((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.EndTime"));
      ((g)localObject2).mWO.append("EndTime:" + ((g)localObject2).ndU + ";\n");
      ((g)localObject2).xOx = bs.aLy((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMin"));
      ((g)localObject2).xOy = bs.aLy((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMax"));
      ((g)localObject2).mWO.append("SvrDownReqLimitLevelMin:" + ((g)localObject2).xOx + " SvrDownReqLimitLevelMax: " + ((g)localObject2).xOy + ";\n");
      ((g)localObject2).xOC = bs.aLz((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseBeginTime"));
      ((g)localObject2).xOD = bs.aLz((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseEndTime"));
      ((g)localObject2).xOE = bs.bG((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenTitle"), "");
      ((g)localObject2).xOF = bs.bG((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenDescription"), "");
      ((g)localObject2).xOG = bs.bG((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenQueryTips"), "");
      ((g)localObject2).xOH = bs.bG((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenAcceptButtonText"), "");
      ((g)localObject2).xOI = bs.bG((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenRejectButtonText"), "");
      ((g)localObject2).xOJ = bs.bG((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenTips"), "");
      ((g)localObject2).xOL = bs.bG((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenSuccTips"), "");
      ((g)localObject2).xOM = bs.bG((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenFailTips"), "");
      ((g)localObject2).xOK = bs.bG((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseTips"), "");
      ((g)localObject2).xON = bs.bG((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseSuccTips"), "");
      ((g)localObject2).xOO = bs.bG((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseFailTips"), "");
      ((g)localObject2).xOV = bs.bG((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedID"), "");
      ((g)localObject2).xOW = bs.aLy((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedCount"));
      ((g)localObject2).xOX = bs.bG((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenID"), "");
      if (((g)localObject2).xOW <= 0)
      {
        ac.i("MicroMsg.NewYearSnsCtrlV2", "svr MaxPostFeedCount error " + ((g)localObject2).xOW);
        ((g)localObject2).xOW = 1;
      }
      ((g)localObject2).mWO.append("FullScreenID:" + ((g)localObject2).xOX + " BrowseBeginTime:" + ((g)localObject2).xOC + " BrowseEndTime:" + ((g)localObject2).xOD + " FullScreenTitle:" + ((g)localObject2).xOE + " FullScreenDescription:" + ((g)localObject2).xOF + " FullScreenQueryTips:" + ((g)localObject2).xOG + " FullScreenAcceptButtonText: " + ((g)localObject2).xOH);
      ((g)localObject2).mWO.append("FullScreenRejectButtonText:" + ((g)localObject2).xOI + " ActionSheetOpenTips:" + ((g)localObject2).xOJ + " ActionSheetOpenSuccTips:" + ((g)localObject2).xOL + " ActionSheetOpenFailTips:" + ((g)localObject2).xOM + " ActionSheetCloseTips:" + ((g)localObject2).xOK + " ActionSheetCloseSuccTips: " + ((g)localObject2).xON + " ActionSheetCloseFailTips: " + ((g)localObject2).xOO + "MaxPostFeedID: " + ((g)localObject2).xOV + " MaxPostFeedCount:" + ((g)localObject2).xOW);
      ((g)localObject2).xOP = bs.bG((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForHasUsed"), "");
      ((g)localObject2).xOQ = bs.bG((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForObtainUsedRight"), "");
      ((g)localObject2).xOR = bs.bG((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForClosedBrowseSwitch"), "");
      ((g)localObject2).xOS = bs.bG((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertButtonText"), "");
      ((g)localObject2).xOT = bs.bG((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTip"), "");
      ((g)localObject2).xOU = bs.bG((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTipID"), "");
      ((g)localObject2).mWO.append("AlertTipForHasUsed:" + ((g)localObject2).xOP + " AlertTipForObtainUsedRight:" + ((g)localObject2).xOQ + " AlertTipForClosedBrowseSwitch:" + ((g)localObject2).xOR + " AlertButtonText:" + ((g)localObject2).xOS + " GoldenCameraTip:" + ((g)localObject2).xOT + " GoldenCameraTipID:" + ((g)localObject2).xOU);
      i = 0;
      if (i == 0)
      {
        localObject1 = "";
        ((g)localObject2).xOs = bs.bG((String)((Map)localObject3).get(String.format(".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s", new Object[] { localObject1, "RedPointID" })), "");
        ((g)localObject2).mWO.append("RedPointID:" + ((g)localObject2).xOs + ";");
        if (bs.isNullOrNil(((g)localObject2).xOs)) {
          continue;
        }
        if (i == 0)
        {
          localObject1 = "";
          ((g)localObject2).xOz = bs.aLz((String)((Map)localObject3).get(String.format(".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s", new Object[] { localObject1, "BeginTime" })));
          ((g)localObject2).mWO.append("RedPointID_BeginTime:" + ((g)localObject2).xOz + ";");
          if (i != 0) {
            continue;
          }
          localObject1 = "";
          ((g)localObject2).xOA = bs.aLz((String)((Map)localObject3).get(String.format(".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s", new Object[] { localObject1, "EndTime" })));
          ((g)localObject2).mWO.append("RedPointID_EndTime:" + ((g)localObject2).xOA + ";\n");
          localObject1 = new c();
          ((c)localObject1).xOs = ((g)localObject2).xOs;
          ((c)localObject1).hOl = ((g)localObject2).xOz;
          ((c)localObject1).ndU = ((g)localObject2).xOA;
          ((g)localObject2).xPb.add(localObject1);
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
      ((g)localObject2).xOB = bs.bG((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.PostTips"), "");
      ((g)localObject2).mWO.append("PostTips:" + ((g)localObject2).xOB + ";");
      ((g)localObject2).xOw = bs.bG((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.EntranceTips"), "");
      ((g)localObject2).mWO.append("EntranceTips:" + ((g)localObject2).xOw + ";");
      ((g)localObject2).xOY.clear();
      i = 0;
      k = bs.aLy((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.AmountLevel" + i + ".Count"));
      ((g)localObject2).mWO.append("count: " + i + " | " + k + ";\n");
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
            m = bs.aLy((String)((Map)localObject3).get(localObject1));
            localLinkedList.add(Integer.valueOf(m));
            ((g)localObject2).mWO.append("AmountLevel : " + i + " index " + j + " val: " + m + ";");
            j += 1;
          }
          else
          {
            localObject1 = Integer.valueOf(j);
          }
        }
        else
        {
          ((g)localObject2).xOY.add(localLinkedList);
          i += 1;
        }
      }
      else
      {
        ac.i("MicroMsg.NewYearSnsCtrlV2", "dumpinfo " + ((g)localObject2).mWO.toString());
      }
    }
  }
  
  public static boolean dGQ()
  {
    AppMethodBeat.i(95182);
    com.tencent.mm.kernel.g.agS();
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GHT, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(95182);
    return bool;
  }
  
  public final void dGR()
  {
    AppMethodBeat.i(95183);
    Object localObject = k.h(ah.a.GHX);
    if ((((i)localObject).yaL == null) || (bs.isNullOrNil(((i)localObject).yaL.postId)))
    {
      ((i)localObject).yaL = new com.tencent.mm.plugin.sns.i.g();
      ((i)localObject).yaL.postId = this.xOV;
      ((i)localObject).yaL.yaJ = 0;
    }
    if ((!bs.isNullOrNil(((i)localObject).yaL.postId)) && (((i)localObject).yaL.postId.equals(this.xOV)))
    {
      com.tencent.mm.plugin.sns.i.g localg = ((i)localObject).yaL;
      localg.yaJ -= 1;
      if (((i)localObject).yaL.yaJ < 0) {
        ((i)localObject).yaL.yaJ = 0;
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.NewYearSnsCtrlV2", "minusPostCountV2 " + ((i)localObject).yaL.yaJ + " postId: " + this.xOV + " " + bs.eWi().toString());
      try
      {
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GHX, new String(((i)localObject).toByteArray(), Charset.forName("ISO-8859-1")));
        localObject = new tl();
        com.tencent.mm.sdk.b.a.GpY.l((b)localObject);
        AppMethodBeat.o(95183);
        return;
        ((i)localObject).yaL = new com.tencent.mm.plugin.sns.i.g();
        ((i)localObject).yaL.postId = this.xOV;
        ((i)localObject).yaL.yaJ = 0;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ac.w("MicroMsg.NewYearSnsCtrlV2", "minusPostCountV2 save exception:" + localIOException.getLocalizedMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.g
 * JD-Core Version:    0.7.0.1
 */