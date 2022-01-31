package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sns.h.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.d;
import com.tencent.mm.storage.z;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g
{
  private static String rbJ = "";
  private static g rbK = null;
  private static int[] rcp = { 50, 66, 68, 88, 99, 121, 123, 166, 168, 188, 199, 233, 266, 268, 288, 299, 369, 419, 520, 666, 1024 };
  public long fKC;
  private StringBuffer jDt;
  public long jKE;
  public String rbH;
  public String rbL;
  public int rbM;
  public int rbN;
  public long rbO;
  public long rbP;
  public String rbQ;
  public long rbR;
  public long rbS;
  public String rbT;
  public String rbU;
  public String rbV;
  public String rbW;
  public String rbX;
  public String rbY;
  public String rbZ;
  public String rca;
  public String rcb;
  public String rcc;
  public String rcd;
  public String rce;
  public String rcf;
  public String rcg;
  public String rch;
  public String rci;
  public String rcj;
  public String rck;
  public int rcl;
  public String rcm;
  private List<List<Integer>> rcn;
  private List<Integer> rco;
  private LinkedList<c> rcq;
  
  public g()
  {
    AppMethodBeat.i(35883);
    this.fKC = 0L;
    this.jKE = 0L;
    this.rbL = "";
    this.rbM = 0;
    this.rbN = 0;
    this.rbH = "";
    this.rbO = 0L;
    this.rbP = 0L;
    this.rbQ = "";
    this.rbR = 0L;
    this.rbS = 0L;
    this.rbT = "";
    this.rbU = "";
    this.rbV = "";
    this.rbW = "";
    this.rbX = "";
    this.rbY = "";
    this.rbZ = "";
    this.rca = "";
    this.rcb = "";
    this.rcc = "";
    this.rcd = "";
    this.rce = "";
    this.rcf = "";
    this.rcg = "";
    this.rch = "";
    this.rci = "";
    this.rcj = "";
    this.rck = "";
    this.rcl = -1;
    this.rcm = "";
    this.rcn = new LinkedList();
    this.rco = new LinkedList();
    this.rcq = new LinkedList();
    this.jDt = new StringBuffer();
    AppMethodBeat.o(35883);
  }
  
  public static g cnW()
  {
    AppMethodBeat.i(35884);
    com.tencent.mm.kernel.g.RM();
    if (!com.tencent.mm.kernel.g.RJ().QU())
    {
      localObject1 = new g();
      AppMethodBeat.o(35884);
      return localObject1;
    }
    Object localObject3 = com.tencent.mm.model.c.c.abU().me("100068");
    Object localObject2 = ((com.tencent.mm.storage.c)localObject3).field_rawXML;
    Object localObject1 = localObject2;
    if (bo.isNullOrNil((String)localObject2)) {
      localObject1 = "";
    }
    String str = com.tencent.mm.a.g.w(((String)localObject1).getBytes());
    if ((rbK == null) || (!str.equals(rbJ)))
    {
      ab.i("MicroMsg.NewYearSnsCtrlV2", "create newYearSnsCtrl");
      rbK = new g();
    }
    for (;;)
    {
      try
      {
        localObject2 = ((com.tencent.mm.storage.c)localObject3).dvN();
        localObject1 = "";
        if (localObject2 != null) {
          localObject1 = (String)((Map)localObject2).get("SnsHBConfig");
        }
        localObject2 = localObject1;
        if (bo.isNullOrNil((String)localObject1)) {
          localObject2 = "";
        }
        localObject1 = URLDecoder.decode((String)localObject2, "UTF-8");
        localObject2 = rbK;
        ((g)localObject2).jDt = new StringBuffer();
        ((g)localObject2).rcq.clear();
        localObject3 = br.F((String)localObject1, "sysmsg");
        if (localObject3 != null) {
          continue;
        }
        ab.i("MicroMsg.NewYearSnsCtrlV2", "errr for paser %s", new Object[] { localObject1 });
        rbJ = str;
      }
      catch (Exception localException)
      {
        int i;
        int k;
        LinkedList localLinkedList;
        int j;
        StringBuilder localStringBuilder;
        int m;
        ab.e("MicroMsg.NewYearSnsCtrlV2", "createctrl error " + localException.getMessage());
        continue;
      }
      localObject1 = rbK;
      AppMethodBeat.o(35884);
      return localObject1;
      ((g)localObject2).fKC = bo.apW((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.BeginTime"));
      ((g)localObject2).jDt.append("BeginTime:" + ((g)localObject2).fKC + ";");
      ((g)localObject2).jKE = bo.apW((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.EndTime"));
      ((g)localObject2).jDt.append("EndTime:" + ((g)localObject2).jKE + ";\n");
      ((g)localObject2).rbM = bo.apV((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMin"));
      ((g)localObject2).rbN = bo.apV((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMax"));
      ((g)localObject2).jDt.append("SvrDownReqLimitLevelMin:" + ((g)localObject2).rbM + " SvrDownReqLimitLevelMax: " + ((g)localObject2).rbN + ";\n");
      ((g)localObject2).rbR = bo.apW((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseBeginTime"));
      ((g)localObject2).rbS = bo.apW((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseEndTime"));
      ((g)localObject2).rbT = bo.bf((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenTitle"), "");
      ((g)localObject2).rbU = bo.bf((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenDescription"), "");
      ((g)localObject2).rbV = bo.bf((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenQueryTips"), "");
      ((g)localObject2).rbW = bo.bf((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenAcceptButtonText"), "");
      ((g)localObject2).rbX = bo.bf((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenRejectButtonText"), "");
      ((g)localObject2).rbY = bo.bf((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenTips"), "");
      ((g)localObject2).rca = bo.bf((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenSuccTips"), "");
      ((g)localObject2).rcb = bo.bf((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenFailTips"), "");
      ((g)localObject2).rbZ = bo.bf((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseTips"), "");
      ((g)localObject2).rcc = bo.bf((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseSuccTips"), "");
      ((g)localObject2).rcd = bo.bf((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseFailTips"), "");
      ((g)localObject2).rck = bo.bf((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedID"), "");
      ((g)localObject2).rcl = bo.apV((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedCount"));
      ((g)localObject2).rcm = bo.bf((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenID"), "");
      if (((g)localObject2).rcl <= 0)
      {
        ab.i("MicroMsg.NewYearSnsCtrlV2", "svr MaxPostFeedCount error " + ((g)localObject2).rcl);
        ((g)localObject2).rcl = 1;
      }
      ((g)localObject2).jDt.append("FullScreenID:" + ((g)localObject2).rcm + " BrowseBeginTime:" + ((g)localObject2).rbR + " BrowseEndTime:" + ((g)localObject2).rbS + " FullScreenTitle:" + ((g)localObject2).rbT + " FullScreenDescription:" + ((g)localObject2).rbU + " FullScreenQueryTips:" + ((g)localObject2).rbV + " FullScreenAcceptButtonText: " + ((g)localObject2).rbW);
      ((g)localObject2).jDt.append("FullScreenRejectButtonText:" + ((g)localObject2).rbX + " ActionSheetOpenTips:" + ((g)localObject2).rbY + " ActionSheetOpenSuccTips:" + ((g)localObject2).rca + " ActionSheetOpenFailTips:" + ((g)localObject2).rcb + " ActionSheetCloseTips:" + ((g)localObject2).rbZ + " ActionSheetCloseSuccTips: " + ((g)localObject2).rcc + " ActionSheetCloseFailTips: " + ((g)localObject2).rcd + "MaxPostFeedID: " + ((g)localObject2).rck + " MaxPostFeedCount:" + ((g)localObject2).rcl);
      ((g)localObject2).rce = bo.bf((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForHasUsed"), "");
      ((g)localObject2).rcf = bo.bf((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForObtainUsedRight"), "");
      ((g)localObject2).rcg = bo.bf((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForClosedBrowseSwitch"), "");
      ((g)localObject2).rch = bo.bf((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertButtonText"), "");
      ((g)localObject2).rci = bo.bf((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTip"), "");
      ((g)localObject2).rcj = bo.bf((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTipID"), "");
      ((g)localObject2).jDt.append("AlertTipForHasUsed:" + ((g)localObject2).rce + " AlertTipForObtainUsedRight:" + ((g)localObject2).rcf + " AlertTipForClosedBrowseSwitch:" + ((g)localObject2).rcg + " AlertButtonText:" + ((g)localObject2).rch + " GoldenCameraTip:" + ((g)localObject2).rci + " GoldenCameraTipID:" + ((g)localObject2).rcj);
      i = 0;
      if (i == 0)
      {
        localObject1 = "";
        ((g)localObject2).rbH = bo.bf((String)((Map)localObject3).get(String.format(".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s", new Object[] { localObject1, "RedPointID" })), "");
        ((g)localObject2).jDt.append("RedPointID:" + ((g)localObject2).rbH + ";");
        if (bo.isNullOrNil(((g)localObject2).rbH)) {
          continue;
        }
        if (i == 0)
        {
          localObject1 = "";
          ((g)localObject2).rbO = bo.apW((String)((Map)localObject3).get(String.format(".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s", new Object[] { localObject1, "BeginTime" })));
          ((g)localObject2).jDt.append("RedPointID_BeginTime:" + ((g)localObject2).rbO + ";");
          if (i != 0) {
            continue;
          }
          localObject1 = "";
          ((g)localObject2).rbP = bo.apW((String)((Map)localObject3).get(String.format(".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s", new Object[] { localObject1, "EndTime" })));
          ((g)localObject2).jDt.append("RedPointID_EndTime:" + ((g)localObject2).rbP + ";\n");
          localObject1 = new c();
          ((c)localObject1).rbH = ((g)localObject2).rbH;
          ((c)localObject1).fKC = ((g)localObject2).rbO;
          ((c)localObject1).jKE = ((g)localObject2).rbP;
          ((g)localObject2).rcq.add(localObject1);
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
      ((g)localObject2).rbQ = bo.bf((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.PostTips"), "");
      ((g)localObject2).jDt.append("PostTips:" + ((g)localObject2).rbQ + ";");
      ((g)localObject2).rbL = bo.bf((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.EntranceTips"), "");
      ((g)localObject2).jDt.append("EntranceTips:" + ((g)localObject2).rbL + ";");
      ((g)localObject2).rcn.clear();
      i = 0;
      k = bo.apV((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.AmountLevel" + i + ".Count"));
      ((g)localObject2).jDt.append("count: " + i + " | " + k + ";\n");
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
            m = bo.apV((String)((Map)localObject3).get(localObject1));
            localLinkedList.add(Integer.valueOf(m));
            ((g)localObject2).jDt.append("AmountLevel : " + i + " index " + j + " val: " + m + ";");
            j += 1;
          }
          else
          {
            localObject1 = Integer.valueOf(j);
          }
        }
        else
        {
          ((g)localObject2).rcn.add(localLinkedList);
          i += 1;
        }
      }
      else
      {
        ab.i("MicroMsg.NewYearSnsCtrlV2", "dumpinfo " + ((g)localObject2).jDt.toString());
      }
    }
  }
  
  public static boolean cnX()
  {
    AppMethodBeat.i(35885);
    com.tencent.mm.kernel.g.RM();
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yBI, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(35885);
    return bool;
  }
  
  public final void cnY()
  {
    AppMethodBeat.i(35886);
    Object localObject = k.h(ac.a.yBM);
    if ((((i)localObject).rlY == null) || (bo.isNullOrNil(((i)localObject).rlY.postId)))
    {
      ((i)localObject).rlY = new com.tencent.mm.plugin.sns.h.g();
      ((i)localObject).rlY.postId = this.rck;
      ((i)localObject).rlY.rlW = 0;
    }
    if ((!bo.isNullOrNil(((i)localObject).rlY.postId)) && (((i)localObject).rlY.postId.equals(this.rck)))
    {
      com.tencent.mm.plugin.sns.h.g localg = ((i)localObject).rlY;
      localg.rlW -= 1;
      if (((i)localObject).rlY.rlW < 0) {
        ((i)localObject).rlY.rlW = 0;
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.NewYearSnsCtrlV2", "minusPostCountV2 " + ((i)localObject).rlY.rlW + " postId: " + this.rck + " " + bo.dtY().toString());
      try
      {
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yBM, new String(((i)localObject).toByteArray(), Charset.forName("ISO-8859-1")));
        localObject = new ri();
        com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
        AppMethodBeat.o(35886);
        return;
        ((i)localObject).rlY = new com.tencent.mm.plugin.sns.h.g();
        ((i)localObject).rlY.postId = this.rck;
        ((i)localObject).rlY.rlW = 0;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ab.w("MicroMsg.NewYearSnsCtrlV2", "minusPostCountV2 save exception:" + localIOException.getLocalizedMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.g
 * JD-Core Version:    0.7.0.1
 */