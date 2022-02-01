package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vg;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sns.j.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g
{
  private static int[] DFW = { 50, 66, 68, 88, 99, 121, 123, 166, 168, 188, 199, 233, 266, 268, 288, 299, 369, 419, 520, 666, 1024 };
  private static String DFq;
  private static g DFr = null;
  public String DFA;
  public String DFB;
  public String DFC;
  public String DFD;
  public String DFE;
  public String DFF;
  public String DFG;
  public String DFH;
  public String DFI;
  public String DFJ;
  public String DFK;
  public String DFL;
  public String DFM;
  public String DFN;
  public String DFO;
  public String DFP;
  public String DFQ;
  public String DFR;
  public int DFS;
  public String DFT;
  private List<List<Integer>> DFU;
  private List<Integer> DFV;
  private LinkedList<c> DFX;
  public String DFo;
  public String DFs;
  public int DFt;
  public int DFu;
  public long DFv;
  public long DFw;
  public String DFx;
  public long DFy;
  public long DFz;
  public long jfo;
  public long oUH;
  private StringBuffer sb;
  
  static
  {
    DFq = "";
  }
  
  public g()
  {
    AppMethodBeat.i(95180);
    this.jfo = 0L;
    this.oUH = 0L;
    this.DFs = "";
    this.DFt = 0;
    this.DFu = 0;
    this.DFo = "";
    this.DFv = 0L;
    this.DFw = 0L;
    this.DFx = "";
    this.DFy = 0L;
    this.DFz = 0L;
    this.DFA = "";
    this.DFB = "";
    this.DFC = "";
    this.DFD = "";
    this.DFE = "";
    this.DFF = "";
    this.DFG = "";
    this.DFH = "";
    this.DFI = "";
    this.DFJ = "";
    this.DFK = "";
    this.DFL = "";
    this.DFM = "";
    this.DFN = "";
    this.DFO = "";
    this.DFP = "";
    this.DFQ = "";
    this.DFR = "";
    this.DFS = -1;
    this.DFT = "";
    this.DFU = new LinkedList();
    this.DFV = new LinkedList();
    this.DFX = new LinkedList();
    this.sb = new StringBuffer();
    AppMethodBeat.o(95180);
  }
  
  public static g eZK()
  {
    AppMethodBeat.i(95181);
    com.tencent.mm.kernel.g.aAi();
    if (!com.tencent.mm.kernel.g.aAf().azp())
    {
      localObject1 = new g();
      AppMethodBeat.o(95181);
      return localObject1;
    }
    Object localObject3 = com.tencent.mm.model.c.d.aXu().Fu("100068");
    Object localObject2 = ((com.tencent.mm.storage.c)localObject3).field_rawXML;
    Object localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2)) {
      localObject1 = "";
    }
    String str = com.tencent.mm.b.g.getMessageDigest(((String)localObject1).getBytes());
    if ((DFr == null) || (!str.equals(DFq)))
    {
      Log.i("MicroMsg.NewYearSnsCtrlV2", "create newYearSnsCtrl");
      DFr = new g();
    }
    for (;;)
    {
      try
      {
        localObject2 = ((com.tencent.mm.storage.c)localObject3).gzz();
        localObject1 = "";
        if (localObject2 != null) {
          localObject1 = (String)((Map)localObject2).get("SnsHBConfig");
        }
        localObject2 = localObject1;
        if (Util.isNullOrNil((String)localObject1)) {
          localObject2 = "";
        }
        localObject1 = URLDecoder.decode((String)localObject2, "UTF-8");
        localObject2 = DFr;
        ((g)localObject2).sb = new StringBuffer();
        ((g)localObject2).DFX.clear();
        localObject3 = XmlParser.parseXml((String)localObject1, "sysmsg", null);
        if (localObject3 != null) {
          continue;
        }
        Log.i("MicroMsg.NewYearSnsCtrlV2", "errr for paser %s", new Object[] { localObject1 });
        DFq = str;
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
      localObject1 = DFr;
      AppMethodBeat.o(95181);
      return localObject1;
      ((g)localObject2).jfo = Util.safeParseLong((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.BeginTime"));
      ((g)localObject2).sb.append("BeginTime:" + ((g)localObject2).jfo + ";");
      ((g)localObject2).oUH = Util.safeParseLong((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.EndTime"));
      ((g)localObject2).sb.append("EndTime:" + ((g)localObject2).oUH + ";\n");
      ((g)localObject2).DFt = Util.safeParseInt((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMin"));
      ((g)localObject2).DFu = Util.safeParseInt((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMax"));
      ((g)localObject2).sb.append("SvrDownReqLimitLevelMin:" + ((g)localObject2).DFt + " SvrDownReqLimitLevelMax: " + ((g)localObject2).DFu + ";\n");
      ((g)localObject2).DFy = Util.safeParseLong((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseBeginTime"));
      ((g)localObject2).DFz = Util.safeParseLong((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseEndTime"));
      ((g)localObject2).DFA = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenTitle"), "");
      ((g)localObject2).DFB = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenDescription"), "");
      ((g)localObject2).DFC = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenQueryTips"), "");
      ((g)localObject2).DFD = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenAcceptButtonText"), "");
      ((g)localObject2).DFE = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenRejectButtonText"), "");
      ((g)localObject2).DFF = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenTips"), "");
      ((g)localObject2).DFH = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenSuccTips"), "");
      ((g)localObject2).DFI = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenFailTips"), "");
      ((g)localObject2).DFG = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseTips"), "");
      ((g)localObject2).DFJ = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseSuccTips"), "");
      ((g)localObject2).DFK = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseFailTips"), "");
      ((g)localObject2).DFR = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedID"), "");
      ((g)localObject2).DFS = Util.safeParseInt((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedCount"));
      ((g)localObject2).DFT = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenID"), "");
      if (((g)localObject2).DFS <= 0)
      {
        Log.i("MicroMsg.NewYearSnsCtrlV2", "svr MaxPostFeedCount error " + ((g)localObject2).DFS);
        ((g)localObject2).DFS = 1;
      }
      ((g)localObject2).sb.append("FullScreenID:" + ((g)localObject2).DFT + " BrowseBeginTime:" + ((g)localObject2).DFy + " BrowseEndTime:" + ((g)localObject2).DFz + " FullScreenTitle:" + ((g)localObject2).DFA + " FullScreenDescription:" + ((g)localObject2).DFB + " FullScreenQueryTips:" + ((g)localObject2).DFC + " FullScreenAcceptButtonText: " + ((g)localObject2).DFD);
      ((g)localObject2).sb.append("FullScreenRejectButtonText:" + ((g)localObject2).DFE + " ActionSheetOpenTips:" + ((g)localObject2).DFF + " ActionSheetOpenSuccTips:" + ((g)localObject2).DFH + " ActionSheetOpenFailTips:" + ((g)localObject2).DFI + " ActionSheetCloseTips:" + ((g)localObject2).DFG + " ActionSheetCloseSuccTips: " + ((g)localObject2).DFJ + " ActionSheetCloseFailTips: " + ((g)localObject2).DFK + "MaxPostFeedID: " + ((g)localObject2).DFR + " MaxPostFeedCount:" + ((g)localObject2).DFS);
      ((g)localObject2).DFL = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForHasUsed"), "");
      ((g)localObject2).DFM = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForObtainUsedRight"), "");
      ((g)localObject2).DFN = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForClosedBrowseSwitch"), "");
      ((g)localObject2).DFO = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertButtonText"), "");
      ((g)localObject2).DFP = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTip"), "");
      ((g)localObject2).DFQ = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTipID"), "");
      ((g)localObject2).sb.append("AlertTipForHasUsed:" + ((g)localObject2).DFL + " AlertTipForObtainUsedRight:" + ((g)localObject2).DFM + " AlertTipForClosedBrowseSwitch:" + ((g)localObject2).DFN + " AlertButtonText:" + ((g)localObject2).DFO + " GoldenCameraTip:" + ((g)localObject2).DFP + " GoldenCameraTipID:" + ((g)localObject2).DFQ);
      i = 0;
      if (i == 0)
      {
        localObject1 = "";
        ((g)localObject2).DFo = Util.nullAs((String)((Map)localObject3).get(String.format(".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s", new Object[] { localObject1, "RedPointID" })), "");
        ((g)localObject2).sb.append("RedPointID:" + ((g)localObject2).DFo + ";");
        if (Util.isNullOrNil(((g)localObject2).DFo)) {
          continue;
        }
        if (i == 0)
        {
          localObject1 = "";
          ((g)localObject2).DFv = Util.safeParseLong((String)((Map)localObject3).get(String.format(".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s", new Object[] { localObject1, "BeginTime" })));
          ((g)localObject2).sb.append("RedPointID_BeginTime:" + ((g)localObject2).DFv + ";");
          if (i != 0) {
            continue;
          }
          localObject1 = "";
          ((g)localObject2).DFw = Util.safeParseLong((String)((Map)localObject3).get(String.format(".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s", new Object[] { localObject1, "EndTime" })));
          ((g)localObject2).sb.append("RedPointID_EndTime:" + ((g)localObject2).DFw + ";\n");
          localObject1 = new c();
          ((c)localObject1).DFo = ((g)localObject2).DFo;
          ((c)localObject1).jfo = ((g)localObject2).DFv;
          ((c)localObject1).oUH = ((g)localObject2).DFw;
          ((g)localObject2).DFX.add(localObject1);
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
      ((g)localObject2).DFx = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.PostTips"), "");
      ((g)localObject2).sb.append("PostTips:" + ((g)localObject2).DFx + ";");
      ((g)localObject2).DFs = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.EntranceTips"), "");
      ((g)localObject2).sb.append("EntranceTips:" + ((g)localObject2).DFs + ";");
      ((g)localObject2).DFU.clear();
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
          ((g)localObject2).DFU.add(localLinkedList);
          i += 1;
        }
      }
      else
      {
        Log.i("MicroMsg.NewYearSnsCtrlV2", "dumpinfo " + ((g)localObject2).sb.toString());
      }
    }
  }
  
  public static boolean eZL()
  {
    AppMethodBeat.i(95182);
    com.tencent.mm.kernel.g.aAi();
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NWK, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(95182);
    return bool;
  }
  
  public final void eZM()
  {
    AppMethodBeat.i(95183);
    Object localObject = k.h(ar.a.NWO);
    if ((((i)localObject).DRX == null) || (Util.isNullOrNil(((i)localObject).DRX.postId)))
    {
      ((i)localObject).DRX = new com.tencent.mm.plugin.sns.j.g();
      ((i)localObject).DRX.postId = this.DFR;
      ((i)localObject).DRX.DRV = 0;
    }
    if ((!Util.isNullOrNil(((i)localObject).DRX.postId)) && (((i)localObject).DRX.postId.equals(this.DFR)))
    {
      com.tencent.mm.plugin.sns.j.g localg = ((i)localObject).DRX;
      localg.DRV -= 1;
      if (((i)localObject).DRX.DRV < 0) {
        ((i)localObject).DRX.DRV = 0;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.NewYearSnsCtrlV2", "minusPostCountV2 " + ((i)localObject).DRX.DRV + " postId: " + this.DFR + " " + Util.getStack().toString());
      try
      {
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NWO, new String(((i)localObject).toByteArray(), Charset.forName("ISO-8859-1")));
        localObject = new vg();
        EventCenter.instance.publish((IEvent)localObject);
        AppMethodBeat.o(95183);
        return;
        ((i)localObject).DRX = new com.tencent.mm.plugin.sns.j.g();
        ((i)localObject).DRX.postId = this.DFR;
        ((i)localObject).DRX.DRV = 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.g
 * JD-Core Version:    0.7.0.1
 */