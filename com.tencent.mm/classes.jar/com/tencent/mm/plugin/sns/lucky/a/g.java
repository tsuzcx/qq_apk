package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.yd;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.k.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g
{
  private static int[] QpU = { 50, 66, 68, 88, 99, 121, 123, 166, 168, 188, 199, 233, 266, 268, 288, 299, 369, 419, 520, 666, 1024 };
  private static String Qpo;
  private static g Qpp = null;
  public String QpA;
  public String QpB;
  public String QpC;
  public String QpD;
  public String QpE;
  public String QpF;
  public String QpG;
  public String QpH;
  public String QpI;
  public String QpJ;
  public String QpK;
  public String QpL;
  public String QpM;
  public String QpN;
  public String QpO;
  public String QpP;
  public int QpQ;
  public String QpR;
  private List<List<Integer>> QpS;
  private List<Integer> QpT;
  private LinkedList<c> QpV;
  public String Qpm;
  public String Qpq;
  public int Qpr;
  public int Qps;
  public long Qpt;
  public long Qpu;
  public String Qpv;
  public long Qpw;
  public long Qpx;
  public String Qpy;
  public String Qpz;
  public long oOO;
  private StringBuffer sb;
  public long vhV;
  
  static
  {
    Qpo = "";
  }
  
  public g()
  {
    AppMethodBeat.i(95180);
    this.oOO = 0L;
    this.vhV = 0L;
    this.Qpq = "";
    this.Qpr = 0;
    this.Qps = 0;
    this.Qpm = "";
    this.Qpt = 0L;
    this.Qpu = 0L;
    this.Qpv = "";
    this.Qpw = 0L;
    this.Qpx = 0L;
    this.Qpy = "";
    this.Qpz = "";
    this.QpA = "";
    this.QpB = "";
    this.QpC = "";
    this.QpD = "";
    this.QpE = "";
    this.QpF = "";
    this.QpG = "";
    this.QpH = "";
    this.QpI = "";
    this.QpJ = "";
    this.QpK = "";
    this.QpL = "";
    this.QpM = "";
    this.QpN = "";
    this.QpO = "";
    this.QpP = "";
    this.QpQ = -1;
    this.QpR = "";
    this.QpS = new LinkedList();
    this.QpT = new LinkedList();
    this.QpV = new LinkedList();
    this.sb = new StringBuffer();
    AppMethodBeat.o(95180);
  }
  
  public static g hfm()
  {
    AppMethodBeat.i(95181);
    h.baF();
    if (!h.baC().aZN())
    {
      localObject1 = new g();
      AppMethodBeat.o(95181);
      return localObject1;
    }
    Object localObject3 = com.tencent.mm.model.newabtest.d.bEt().Fd("100068");
    Object localObject2 = ((com.tencent.mm.storage.c)localObject3).field_rawXML;
    Object localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2)) {
      localObject1 = "";
    }
    String str = com.tencent.mm.b.g.getMessageDigest(((String)localObject1).getBytes());
    if ((Qpp == null) || (!str.equals(Qpo)))
    {
      Log.i("MicroMsg.NewYearSnsCtrlV2", "create newYearSnsCtrl");
      Qpp = new g();
    }
    for (;;)
    {
      try
      {
        localObject2 = ((com.tencent.mm.storage.c)localObject3).iWZ();
        localObject1 = "";
        if (localObject2 != null) {
          localObject1 = (String)((Map)localObject2).get("SnsHBConfig");
        }
        localObject2 = localObject1;
        if (Util.isNullOrNil((String)localObject1)) {
          localObject2 = "";
        }
        localObject1 = URLDecoder.decode((String)localObject2, "UTF-8");
        localObject2 = Qpp;
        ((g)localObject2).sb = new StringBuffer();
        ((g)localObject2).QpV.clear();
        localObject3 = XmlParser.parseXml((String)localObject1, "sysmsg", null);
        if (localObject3 != null) {
          continue;
        }
        Log.i("MicroMsg.NewYearSnsCtrlV2", "errr for paser %s", new Object[] { localObject1 });
        Qpo = str;
      }
      catch (Exception localException)
      {
        int i;
        int k;
        LinkedList localLinkedList;
        int j;
        StringBuilder localStringBuilder;
        int m;
        Log.e("MicroMsg.NewYearSnsCtrlV2", "createctrl error " + localException.getMessage());
        continue;
      }
      localObject1 = Qpp;
      AppMethodBeat.o(95181);
      return localObject1;
      ((g)localObject2).oOO = Util.safeParseLong((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.BeginTime"));
      ((g)localObject2).sb.append("BeginTime:" + ((g)localObject2).oOO + ";");
      ((g)localObject2).vhV = Util.safeParseLong((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.EndTime"));
      ((g)localObject2).sb.append("EndTime:" + ((g)localObject2).vhV + ";\n");
      ((g)localObject2).Qpr = Util.safeParseInt((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMin"));
      ((g)localObject2).Qps = Util.safeParseInt((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMax"));
      ((g)localObject2).sb.append("SvrDownReqLimitLevelMin:" + ((g)localObject2).Qpr + " SvrDownReqLimitLevelMax: " + ((g)localObject2).Qps + ";\n");
      ((g)localObject2).Qpw = Util.safeParseLong((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseBeginTime"));
      ((g)localObject2).Qpx = Util.safeParseLong((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseEndTime"));
      ((g)localObject2).Qpy = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenTitle"), "");
      ((g)localObject2).Qpz = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenDescription"), "");
      ((g)localObject2).QpA = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenQueryTips"), "");
      ((g)localObject2).QpB = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenAcceptButtonText"), "");
      ((g)localObject2).QpC = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenRejectButtonText"), "");
      ((g)localObject2).QpD = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenTips"), "");
      ((g)localObject2).QpF = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenSuccTips"), "");
      ((g)localObject2).QpG = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenFailTips"), "");
      ((g)localObject2).QpE = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseTips"), "");
      ((g)localObject2).QpH = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseSuccTips"), "");
      ((g)localObject2).QpI = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseFailTips"), "");
      ((g)localObject2).QpP = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedID"), "");
      ((g)localObject2).QpQ = Util.safeParseInt((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedCount"));
      ((g)localObject2).QpR = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenID"), "");
      if (((g)localObject2).QpQ <= 0)
      {
        Log.i("MicroMsg.NewYearSnsCtrlV2", "svr MaxPostFeedCount error " + ((g)localObject2).QpQ);
        ((g)localObject2).QpQ = 1;
      }
      ((g)localObject2).sb.append("FullScreenID:" + ((g)localObject2).QpR + " BrowseBeginTime:" + ((g)localObject2).Qpw + " BrowseEndTime:" + ((g)localObject2).Qpx + " FullScreenTitle:" + ((g)localObject2).Qpy + " FullScreenDescription:" + ((g)localObject2).Qpz + " FullScreenQueryTips:" + ((g)localObject2).QpA + " FullScreenAcceptButtonText: " + ((g)localObject2).QpB);
      ((g)localObject2).sb.append("FullScreenRejectButtonText:" + ((g)localObject2).QpC + " ActionSheetOpenTips:" + ((g)localObject2).QpD + " ActionSheetOpenSuccTips:" + ((g)localObject2).QpF + " ActionSheetOpenFailTips:" + ((g)localObject2).QpG + " ActionSheetCloseTips:" + ((g)localObject2).QpE + " ActionSheetCloseSuccTips: " + ((g)localObject2).QpH + " ActionSheetCloseFailTips: " + ((g)localObject2).QpI + "MaxPostFeedID: " + ((g)localObject2).QpP + " MaxPostFeedCount:" + ((g)localObject2).QpQ);
      ((g)localObject2).QpJ = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForHasUsed"), "");
      ((g)localObject2).QpK = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForObtainUsedRight"), "");
      ((g)localObject2).QpL = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForClosedBrowseSwitch"), "");
      ((g)localObject2).QpM = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertButtonText"), "");
      ((g)localObject2).QpN = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTip"), "");
      ((g)localObject2).QpO = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTipID"), "");
      ((g)localObject2).sb.append("AlertTipForHasUsed:" + ((g)localObject2).QpJ + " AlertTipForObtainUsedRight:" + ((g)localObject2).QpK + " AlertTipForClosedBrowseSwitch:" + ((g)localObject2).QpL + " AlertButtonText:" + ((g)localObject2).QpM + " GoldenCameraTip:" + ((g)localObject2).QpN + " GoldenCameraTipID:" + ((g)localObject2).QpO);
      i = 0;
      if (i == 0)
      {
        localObject1 = "";
        ((g)localObject2).Qpm = Util.nullAs((String)((Map)localObject3).get(String.format(".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s", new Object[] { localObject1, "RedPointID" })), "");
        ((g)localObject2).sb.append("RedPointID:" + ((g)localObject2).Qpm + ";");
        if (Util.isNullOrNil(((g)localObject2).Qpm)) {
          continue;
        }
        if (i == 0)
        {
          localObject1 = "";
          ((g)localObject2).Qpt = Util.safeParseLong((String)((Map)localObject3).get(String.format(".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s", new Object[] { localObject1, "BeginTime" })));
          ((g)localObject2).sb.append("RedPointID_BeginTime:" + ((g)localObject2).Qpt + ";");
          if (i != 0) {
            continue;
          }
          localObject1 = "";
          ((g)localObject2).Qpu = Util.safeParseLong((String)((Map)localObject3).get(String.format(".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s", new Object[] { localObject1, "EndTime" })));
          ((g)localObject2).sb.append("RedPointID_EndTime:" + ((g)localObject2).Qpu + ";\n");
          localObject1 = new c();
          ((c)localObject1).Qpm = ((g)localObject2).Qpm;
          ((c)localObject1).oOO = ((g)localObject2).Qpt;
          ((c)localObject1).vhV = ((g)localObject2).Qpu;
          ((g)localObject2).QpV.add(localObject1);
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
      ((g)localObject2).Qpv = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.PostTips"), "");
      ((g)localObject2).sb.append("PostTips:" + ((g)localObject2).Qpv + ";");
      ((g)localObject2).Qpq = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.EntranceTips"), "");
      ((g)localObject2).sb.append("EntranceTips:" + ((g)localObject2).Qpq + ";");
      ((g)localObject2).QpS.clear();
      i = 0;
      k = Util.safeParseInt((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.AmountLevel" + i + ".Count"));
      ((g)localObject2).sb.append("count: " + i + " | " + k + ";\n");
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
            m = Util.safeParseInt((String)((Map)localObject3).get(localObject1));
            localLinkedList.add(Integer.valueOf(m));
            ((g)localObject2).sb.append("AmountLevel : " + i + " index " + j + " val: " + m + ";");
            j += 1;
          }
          else
          {
            localObject1 = Integer.valueOf(j);
          }
        }
        else
        {
          ((g)localObject2).QpS.add(localLinkedList);
          i += 1;
        }
      }
      else
      {
        Log.i("MicroMsg.NewYearSnsCtrlV2", "dumpinfo " + ((g)localObject2).sb.toString());
      }
    }
  }
  
  public static boolean hfn()
  {
    AppMethodBeat.i(95182);
    h.baF();
    boolean bool = ((Boolean)h.baE().ban().get(at.a.acMe, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(95182);
    return bool;
  }
  
  public final void hfo()
  {
    AppMethodBeat.i(95183);
    i locali = k.j(at.a.acMi);
    if ((locali.QCL == null) || (Util.isNullOrNil(locali.QCL.postId)))
    {
      locali.QCL = new com.tencent.mm.plugin.sns.k.g();
      locali.QCL.postId = this.QpP;
      locali.QCL.QCJ = 0;
    }
    if ((!Util.isNullOrNil(locali.QCL.postId)) && (locali.QCL.postId.equals(this.QpP)))
    {
      com.tencent.mm.plugin.sns.k.g localg = locali.QCL;
      localg.QCJ -= 1;
      if (locali.QCL.QCJ < 0) {
        locali.QCL.QCJ = 0;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.NewYearSnsCtrlV2", "minusPostCountV2 " + locali.QCL.QCJ + " postId: " + this.QpP + " " + Util.getStack().toString());
      try
      {
        h.baF();
        h.baE().ban().set(at.a.acMi, new String(locali.toByteArray(), Charset.forName("ISO-8859-1")));
        new yd().publish();
        AppMethodBeat.o(95183);
        return;
        locali.QCL = new com.tencent.mm.plugin.sns.k.g();
        locali.QCL.postId = this.QpP;
        locali.QCL.QCJ = 0;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.w("MicroMsg.NewYearSnsCtrlV2", "minusPostCountV2 save exception:" + localIOException.getLocalizedMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.g
 * JD-Core Version:    0.7.0.1
 */