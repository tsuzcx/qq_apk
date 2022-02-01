package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ue;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g
{
  private static int[] zeU = { 50, 66, 68, 88, 99, 121, 123, 166, 168, 188, 199, 233, 266, 268, 288, 299, 369, 419, 520, 666, 1024 };
  private static String zeo;
  private static g zep = null;
  public long ihz;
  public long nEr;
  private StringBuffer nxl;
  public String zeA;
  public String zeB;
  public String zeC;
  public String zeD;
  public String zeE;
  public String zeF;
  public String zeG;
  public String zeH;
  public String zeI;
  public String zeJ;
  public String zeK;
  public String zeL;
  public String zeM;
  public String zeN;
  public String zeO;
  public String zeP;
  public int zeQ;
  public String zeR;
  private List<List<Integer>> zeS;
  private List<Integer> zeT;
  private LinkedList<c> zeV;
  public String zem;
  public String zeq;
  public int zer;
  public int zes;
  public long zet;
  public long zeu;
  public String zev;
  public long zew;
  public long zex;
  public String zey;
  public String zez;
  
  static
  {
    zeo = "";
  }
  
  public g()
  {
    AppMethodBeat.i(95180);
    this.ihz = 0L;
    this.nEr = 0L;
    this.zeq = "";
    this.zer = 0;
    this.zes = 0;
    this.zem = "";
    this.zet = 0L;
    this.zeu = 0L;
    this.zev = "";
    this.zew = 0L;
    this.zex = 0L;
    this.zey = "";
    this.zez = "";
    this.zeA = "";
    this.zeB = "";
    this.zeC = "";
    this.zeD = "";
    this.zeE = "";
    this.zeF = "";
    this.zeG = "";
    this.zeH = "";
    this.zeI = "";
    this.zeJ = "";
    this.zeK = "";
    this.zeL = "";
    this.zeM = "";
    this.zeN = "";
    this.zeO = "";
    this.zeP = "";
    this.zeQ = -1;
    this.zeR = "";
    this.zeS = new LinkedList();
    this.zeT = new LinkedList();
    this.zeV = new LinkedList();
    this.nxl = new StringBuffer();
    AppMethodBeat.o(95180);
  }
  
  public static g dTc()
  {
    AppMethodBeat.i(95181);
    com.tencent.mm.kernel.g.ajD();
    if (!com.tencent.mm.kernel.g.ajA().aiK())
    {
      localObject1 = new g();
      AppMethodBeat.o(95181);
      return localObject1;
    }
    Object localObject3 = com.tencent.mm.model.c.d.aDs().wz("100068");
    Object localObject2 = ((com.tencent.mm.storage.c)localObject3).field_rawXML;
    Object localObject1 = localObject2;
    if (bt.isNullOrNil((String)localObject2)) {
      localObject1 = "";
    }
    String str = com.tencent.mm.b.g.getMessageDigest(((String)localObject1).getBytes());
    if ((zep == null) || (!str.equals(zeo)))
    {
      ad.i("MicroMsg.NewYearSnsCtrlV2", "create newYearSnsCtrl");
      zep = new g();
    }
    for (;;)
    {
      try
      {
        localObject2 = ((com.tencent.mm.storage.c)localObject3).foF();
        localObject1 = "";
        if (localObject2 != null) {
          localObject1 = (String)((Map)localObject2).get("SnsHBConfig");
        }
        localObject2 = localObject1;
        if (bt.isNullOrNil((String)localObject1)) {
          localObject2 = "";
        }
        localObject1 = URLDecoder.decode((String)localObject2, "UTF-8");
        localObject2 = zep;
        ((g)localObject2).nxl = new StringBuffer();
        ((g)localObject2).zeV.clear();
        localObject3 = bw.M((String)localObject1, "sysmsg");
        if (localObject3 != null) {
          continue;
        }
        ad.i("MicroMsg.NewYearSnsCtrlV2", "errr for paser %s", new Object[] { localObject1 });
        zeo = str;
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
      localObject1 = zep;
      AppMethodBeat.o(95181);
      return localObject1;
      ((g)localObject2).ihz = bt.aRf((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.BeginTime"));
      ((g)localObject2).nxl.append("BeginTime:" + ((g)localObject2).ihz + ";");
      ((g)localObject2).nEr = bt.aRf((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.EndTime"));
      ((g)localObject2).nxl.append("EndTime:" + ((g)localObject2).nEr + ";\n");
      ((g)localObject2).zer = bt.aRe((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMin"));
      ((g)localObject2).zes = bt.aRe((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMax"));
      ((g)localObject2).nxl.append("SvrDownReqLimitLevelMin:" + ((g)localObject2).zer + " SvrDownReqLimitLevelMax: " + ((g)localObject2).zes + ";\n");
      ((g)localObject2).zew = bt.aRf((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseBeginTime"));
      ((g)localObject2).zex = bt.aRf((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseEndTime"));
      ((g)localObject2).zey = bt.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenTitle"), "");
      ((g)localObject2).zez = bt.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenDescription"), "");
      ((g)localObject2).zeA = bt.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenQueryTips"), "");
      ((g)localObject2).zeB = bt.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenAcceptButtonText"), "");
      ((g)localObject2).zeC = bt.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenRejectButtonText"), "");
      ((g)localObject2).zeD = bt.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenTips"), "");
      ((g)localObject2).zeF = bt.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenSuccTips"), "");
      ((g)localObject2).zeG = bt.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenFailTips"), "");
      ((g)localObject2).zeE = bt.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseTips"), "");
      ((g)localObject2).zeH = bt.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseSuccTips"), "");
      ((g)localObject2).zeI = bt.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseFailTips"), "");
      ((g)localObject2).zeP = bt.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedID"), "");
      ((g)localObject2).zeQ = bt.aRe((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedCount"));
      ((g)localObject2).zeR = bt.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenID"), "");
      if (((g)localObject2).zeQ <= 0)
      {
        ad.i("MicroMsg.NewYearSnsCtrlV2", "svr MaxPostFeedCount error " + ((g)localObject2).zeQ);
        ((g)localObject2).zeQ = 1;
      }
      ((g)localObject2).nxl.append("FullScreenID:" + ((g)localObject2).zeR + " BrowseBeginTime:" + ((g)localObject2).zew + " BrowseEndTime:" + ((g)localObject2).zex + " FullScreenTitle:" + ((g)localObject2).zey + " FullScreenDescription:" + ((g)localObject2).zez + " FullScreenQueryTips:" + ((g)localObject2).zeA + " FullScreenAcceptButtonText: " + ((g)localObject2).zeB);
      ((g)localObject2).nxl.append("FullScreenRejectButtonText:" + ((g)localObject2).zeC + " ActionSheetOpenTips:" + ((g)localObject2).zeD + " ActionSheetOpenSuccTips:" + ((g)localObject2).zeF + " ActionSheetOpenFailTips:" + ((g)localObject2).zeG + " ActionSheetCloseTips:" + ((g)localObject2).zeE + " ActionSheetCloseSuccTips: " + ((g)localObject2).zeH + " ActionSheetCloseFailTips: " + ((g)localObject2).zeI + "MaxPostFeedID: " + ((g)localObject2).zeP + " MaxPostFeedCount:" + ((g)localObject2).zeQ);
      ((g)localObject2).zeJ = bt.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForHasUsed"), "");
      ((g)localObject2).zeK = bt.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForObtainUsedRight"), "");
      ((g)localObject2).zeL = bt.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForClosedBrowseSwitch"), "");
      ((g)localObject2).zeM = bt.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertButtonText"), "");
      ((g)localObject2).zeN = bt.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTip"), "");
      ((g)localObject2).zeO = bt.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTipID"), "");
      ((g)localObject2).nxl.append("AlertTipForHasUsed:" + ((g)localObject2).zeJ + " AlertTipForObtainUsedRight:" + ((g)localObject2).zeK + " AlertTipForClosedBrowseSwitch:" + ((g)localObject2).zeL + " AlertButtonText:" + ((g)localObject2).zeM + " GoldenCameraTip:" + ((g)localObject2).zeN + " GoldenCameraTipID:" + ((g)localObject2).zeO);
      i = 0;
      if (i == 0)
      {
        localObject1 = "";
        ((g)localObject2).zem = bt.bI((String)((Map)localObject3).get(String.format(".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s", new Object[] { localObject1, "RedPointID" })), "");
        ((g)localObject2).nxl.append("RedPointID:" + ((g)localObject2).zem + ";");
        if (bt.isNullOrNil(((g)localObject2).zem)) {
          continue;
        }
        if (i == 0)
        {
          localObject1 = "";
          ((g)localObject2).zet = bt.aRf((String)((Map)localObject3).get(String.format(".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s", new Object[] { localObject1, "BeginTime" })));
          ((g)localObject2).nxl.append("RedPointID_BeginTime:" + ((g)localObject2).zet + ";");
          if (i != 0) {
            continue;
          }
          localObject1 = "";
          ((g)localObject2).zeu = bt.aRf((String)((Map)localObject3).get(String.format(".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s", new Object[] { localObject1, "EndTime" })));
          ((g)localObject2).nxl.append("RedPointID_EndTime:" + ((g)localObject2).zeu + ";\n");
          localObject1 = new c();
          ((c)localObject1).zem = ((g)localObject2).zem;
          ((c)localObject1).ihz = ((g)localObject2).zet;
          ((c)localObject1).nEr = ((g)localObject2).zeu;
          ((g)localObject2).zeV.add(localObject1);
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
      ((g)localObject2).zev = bt.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.PostTips"), "");
      ((g)localObject2).nxl.append("PostTips:" + ((g)localObject2).zev + ";");
      ((g)localObject2).zeq = bt.bI((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.EntranceTips"), "");
      ((g)localObject2).nxl.append("EntranceTips:" + ((g)localObject2).zeq + ";");
      ((g)localObject2).zeS.clear();
      i = 0;
      k = bt.aRe((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.AmountLevel" + i + ".Count"));
      ((g)localObject2).nxl.append("count: " + i + " | " + k + ";\n");
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
            m = bt.aRe((String)((Map)localObject3).get(localObject1));
            localLinkedList.add(Integer.valueOf(m));
            ((g)localObject2).nxl.append("AmountLevel : " + i + " index " + j + " val: " + m + ";");
            j += 1;
          }
          else
          {
            localObject1 = Integer.valueOf(j);
          }
        }
        else
        {
          ((g)localObject2).zeS.add(localLinkedList);
          i += 1;
        }
      }
      else
      {
        ad.i("MicroMsg.NewYearSnsCtrlV2", "dumpinfo " + ((g)localObject2).nxl.toString());
      }
    }
  }
  
  public static boolean dTd()
  {
    AppMethodBeat.i(95182);
    com.tencent.mm.kernel.g.ajD();
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Iul, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(95182);
    return bool;
  }
  
  public final void dTe()
  {
    AppMethodBeat.i(95183);
    Object localObject = k.h(al.a.Iup);
    if ((((i)localObject).zqH == null) || (bt.isNullOrNil(((i)localObject).zqH.postId)))
    {
      ((i)localObject).zqH = new com.tencent.mm.plugin.sns.i.g();
      ((i)localObject).zqH.postId = this.zeP;
      ((i)localObject).zqH.zqF = 0;
    }
    if ((!bt.isNullOrNil(((i)localObject).zqH.postId)) && (((i)localObject).zqH.postId.equals(this.zeP)))
    {
      com.tencent.mm.plugin.sns.i.g localg = ((i)localObject).zqH;
      localg.zqF -= 1;
      if (((i)localObject).zqH.zqF < 0) {
        ((i)localObject).zqH.zqF = 0;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.NewYearSnsCtrlV2", "minusPostCountV2 " + ((i)localObject).zqH.zqF + " postId: " + this.zeP + " " + bt.flS().toString());
      try
      {
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iup, new String(((i)localObject).toByteArray(), Charset.forName("ISO-8859-1")));
        localObject = new ue();
        com.tencent.mm.sdk.b.a.IbL.l((b)localObject);
        AppMethodBeat.o(95183);
        return;
        ((i)localObject).zqH = new com.tencent.mm.plugin.sns.i.g();
        ((i)localObject).zqH.postId = this.zeP;
        ((i)localObject).zqH.zqF = 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.g
 * JD-Core Version:    0.7.0.1
 */