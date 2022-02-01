package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.wk;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
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
  private static int[] JSS = { 50, 66, 68, 88, 99, 121, 123, 166, 168, 188, 199, 233, 266, 268, 288, 299, 369, 419, 520, 666, 1024 };
  private static String JSm;
  private static g JSn = null;
  public String JSA;
  public String JSB;
  public String JSC;
  public String JSD;
  public String JSE;
  public String JSF;
  public String JSG;
  public String JSH;
  public String JSI;
  public String JSJ;
  public String JSK;
  public String JSL;
  public String JSM;
  public String JSN;
  public int JSO;
  public String JSP;
  private List<List<Integer>> JSQ;
  private List<Integer> JSR;
  private LinkedList<c> JST;
  public String JSk;
  public String JSo;
  public int JSp;
  public int JSq;
  public long JSr;
  public long JSs;
  public String JSt;
  public long JSu;
  public long JSv;
  public String JSw;
  public String JSx;
  public String JSy;
  public String JSz;
  public long lVM;
  public long rWG;
  private StringBuffer sb;
  
  static
  {
    JSm = "";
  }
  
  public g()
  {
    AppMethodBeat.i(95180);
    this.lVM = 0L;
    this.rWG = 0L;
    this.JSo = "";
    this.JSp = 0;
    this.JSq = 0;
    this.JSk = "";
    this.JSr = 0L;
    this.JSs = 0L;
    this.JSt = "";
    this.JSu = 0L;
    this.JSv = 0L;
    this.JSw = "";
    this.JSx = "";
    this.JSy = "";
    this.JSz = "";
    this.JSA = "";
    this.JSB = "";
    this.JSC = "";
    this.JSD = "";
    this.JSE = "";
    this.JSF = "";
    this.JSG = "";
    this.JSH = "";
    this.JSI = "";
    this.JSJ = "";
    this.JSK = "";
    this.JSL = "";
    this.JSM = "";
    this.JSN = "";
    this.JSO = -1;
    this.JSP = "";
    this.JSQ = new LinkedList();
    this.JSR = new LinkedList();
    this.JST = new LinkedList();
    this.sb = new StringBuffer();
    AppMethodBeat.o(95180);
  }
  
  public static g fNB()
  {
    AppMethodBeat.i(95181);
    h.aHH();
    if (!h.aHE().aGM())
    {
      localObject1 = new g();
      AppMethodBeat.o(95181);
      return localObject1;
    }
    Object localObject3 = com.tencent.mm.model.c.d.bgB().Mu("100068");
    Object localObject2 = ((com.tencent.mm.storage.c)localObject3).field_rawXML;
    Object localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2)) {
      localObject1 = "";
    }
    String str = com.tencent.mm.b.g.getMessageDigest(((String)localObject1).getBytes());
    if ((JSn == null) || (!str.equals(JSm)))
    {
      Log.i("MicroMsg.NewYearSnsCtrlV2", "create newYearSnsCtrl");
      JSn = new g();
    }
    for (;;)
    {
      try
      {
        localObject2 = ((com.tencent.mm.storage.c)localObject3).hvz();
        localObject1 = "";
        if (localObject2 != null) {
          localObject1 = (String)((Map)localObject2).get("SnsHBConfig");
        }
        localObject2 = localObject1;
        if (Util.isNullOrNil((String)localObject1)) {
          localObject2 = "";
        }
        localObject1 = URLDecoder.decode((String)localObject2, "UTF-8");
        localObject2 = JSn;
        ((g)localObject2).sb = new StringBuffer();
        ((g)localObject2).JST.clear();
        localObject3 = XmlParser.parseXml((String)localObject1, "sysmsg", null);
        if (localObject3 != null) {
          continue;
        }
        Log.i("MicroMsg.NewYearSnsCtrlV2", "errr for paser %s", new Object[] { localObject1 });
        JSm = str;
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
      localObject1 = JSn;
      AppMethodBeat.o(95181);
      return localObject1;
      ((g)localObject2).lVM = Util.safeParseLong((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.BeginTime"));
      ((g)localObject2).sb.append("BeginTime:" + ((g)localObject2).lVM + ";");
      ((g)localObject2).rWG = Util.safeParseLong((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.EndTime"));
      ((g)localObject2).sb.append("EndTime:" + ((g)localObject2).rWG + ";\n");
      ((g)localObject2).JSp = Util.safeParseInt((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMin"));
      ((g)localObject2).JSq = Util.safeParseInt((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMax"));
      ((g)localObject2).sb.append("SvrDownReqLimitLevelMin:" + ((g)localObject2).JSp + " SvrDownReqLimitLevelMax: " + ((g)localObject2).JSq + ";\n");
      ((g)localObject2).JSu = Util.safeParseLong((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseBeginTime"));
      ((g)localObject2).JSv = Util.safeParseLong((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseEndTime"));
      ((g)localObject2).JSw = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenTitle"), "");
      ((g)localObject2).JSx = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenDescription"), "");
      ((g)localObject2).JSy = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenQueryTips"), "");
      ((g)localObject2).JSz = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenAcceptButtonText"), "");
      ((g)localObject2).JSA = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenRejectButtonText"), "");
      ((g)localObject2).JSB = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenTips"), "");
      ((g)localObject2).JSD = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenSuccTips"), "");
      ((g)localObject2).JSE = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenFailTips"), "");
      ((g)localObject2).JSC = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseTips"), "");
      ((g)localObject2).JSF = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseSuccTips"), "");
      ((g)localObject2).JSG = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseFailTips"), "");
      ((g)localObject2).JSN = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedID"), "");
      ((g)localObject2).JSO = Util.safeParseInt((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedCount"));
      ((g)localObject2).JSP = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenID"), "");
      if (((g)localObject2).JSO <= 0)
      {
        Log.i("MicroMsg.NewYearSnsCtrlV2", "svr MaxPostFeedCount error " + ((g)localObject2).JSO);
        ((g)localObject2).JSO = 1;
      }
      ((g)localObject2).sb.append("FullScreenID:" + ((g)localObject2).JSP + " BrowseBeginTime:" + ((g)localObject2).JSu + " BrowseEndTime:" + ((g)localObject2).JSv + " FullScreenTitle:" + ((g)localObject2).JSw + " FullScreenDescription:" + ((g)localObject2).JSx + " FullScreenQueryTips:" + ((g)localObject2).JSy + " FullScreenAcceptButtonText: " + ((g)localObject2).JSz);
      ((g)localObject2).sb.append("FullScreenRejectButtonText:" + ((g)localObject2).JSA + " ActionSheetOpenTips:" + ((g)localObject2).JSB + " ActionSheetOpenSuccTips:" + ((g)localObject2).JSD + " ActionSheetOpenFailTips:" + ((g)localObject2).JSE + " ActionSheetCloseTips:" + ((g)localObject2).JSC + " ActionSheetCloseSuccTips: " + ((g)localObject2).JSF + " ActionSheetCloseFailTips: " + ((g)localObject2).JSG + "MaxPostFeedID: " + ((g)localObject2).JSN + " MaxPostFeedCount:" + ((g)localObject2).JSO);
      ((g)localObject2).JSH = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForHasUsed"), "");
      ((g)localObject2).JSI = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForObtainUsedRight"), "");
      ((g)localObject2).JSJ = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForClosedBrowseSwitch"), "");
      ((g)localObject2).JSK = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertButtonText"), "");
      ((g)localObject2).JSL = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTip"), "");
      ((g)localObject2).JSM = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTipID"), "");
      ((g)localObject2).sb.append("AlertTipForHasUsed:" + ((g)localObject2).JSH + " AlertTipForObtainUsedRight:" + ((g)localObject2).JSI + " AlertTipForClosedBrowseSwitch:" + ((g)localObject2).JSJ + " AlertButtonText:" + ((g)localObject2).JSK + " GoldenCameraTip:" + ((g)localObject2).JSL + " GoldenCameraTipID:" + ((g)localObject2).JSM);
      i = 0;
      if (i == 0)
      {
        localObject1 = "";
        ((g)localObject2).JSk = Util.nullAs((String)((Map)localObject3).get(String.format(".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s", new Object[] { localObject1, "RedPointID" })), "");
        ((g)localObject2).sb.append("RedPointID:" + ((g)localObject2).JSk + ";");
        if (Util.isNullOrNil(((g)localObject2).JSk)) {
          continue;
        }
        if (i == 0)
        {
          localObject1 = "";
          ((g)localObject2).JSr = Util.safeParseLong((String)((Map)localObject3).get(String.format(".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s", new Object[] { localObject1, "BeginTime" })));
          ((g)localObject2).sb.append("RedPointID_BeginTime:" + ((g)localObject2).JSr + ";");
          if (i != 0) {
            continue;
          }
          localObject1 = "";
          ((g)localObject2).JSs = Util.safeParseLong((String)((Map)localObject3).get(String.format(".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s", new Object[] { localObject1, "EndTime" })));
          ((g)localObject2).sb.append("RedPointID_EndTime:" + ((g)localObject2).JSs + ";\n");
          localObject1 = new c();
          ((c)localObject1).JSk = ((g)localObject2).JSk;
          ((c)localObject1).lVM = ((g)localObject2).JSr;
          ((c)localObject1).rWG = ((g)localObject2).JSs;
          ((g)localObject2).JST.add(localObject1);
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
      ((g)localObject2).JSt = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.PostTips"), "");
      ((g)localObject2).sb.append("PostTips:" + ((g)localObject2).JSt + ";");
      ((g)localObject2).JSo = Util.nullAs((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.EntranceTips"), "");
      ((g)localObject2).sb.append("EntranceTips:" + ((g)localObject2).JSo + ";");
      ((g)localObject2).JSQ.clear();
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
          ((g)localObject2).JSQ.add(localLinkedList);
          i += 1;
        }
      }
      else
      {
        Log.i("MicroMsg.NewYearSnsCtrlV2", "dumpinfo " + ((g)localObject2).sb.toString());
      }
    }
  }
  
  public static boolean fNC()
  {
    AppMethodBeat.i(95182);
    h.aHH();
    boolean bool = ((Boolean)h.aHG().aHp().get(ar.a.VkK, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(95182);
    return bool;
  }
  
  public final void fND()
  {
    AppMethodBeat.i(95183);
    Object localObject = k.i(ar.a.VkO);
    if ((((i)localObject).Kfe == null) || (Util.isNullOrNil(((i)localObject).Kfe.postId)))
    {
      ((i)localObject).Kfe = new com.tencent.mm.plugin.sns.j.g();
      ((i)localObject).Kfe.postId = this.JSN;
      ((i)localObject).Kfe.Kfc = 0;
    }
    if ((!Util.isNullOrNil(((i)localObject).Kfe.postId)) && (((i)localObject).Kfe.postId.equals(this.JSN)))
    {
      com.tencent.mm.plugin.sns.j.g localg = ((i)localObject).Kfe;
      localg.Kfc -= 1;
      if (((i)localObject).Kfe.Kfc < 0) {
        ((i)localObject).Kfe.Kfc = 0;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.NewYearSnsCtrlV2", "minusPostCountV2 " + ((i)localObject).Kfe.Kfc + " postId: " + this.JSN + " " + Util.getStack().toString());
      try
      {
        h.aHH();
        h.aHG().aHp().set(ar.a.VkO, new String(((i)localObject).toByteArray(), Charset.forName("ISO-8859-1")));
        localObject = new wk();
        EventCenter.instance.publish((IEvent)localObject);
        AppMethodBeat.o(95183);
        return;
        ((i)localObject).Kfe = new com.tencent.mm.plugin.sns.j.g();
        ((i)localObject).Kfe.postId = this.JSN;
        ((i)localObject).Kfe.Kfc = 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.g
 * JD-Core Version:    0.7.0.1
 */