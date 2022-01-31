package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.mm.h.a.py;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sns.g.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
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
  private static int[] onY = { 50, 66, 68, 88, 99, 121, 123, 166, 168, 188, 199, 233, 266, 268, 288, 299, 369, 419, 520, 666, 1024 };
  private static String ons;
  private static g ont = null;
  public long euQ = 0L;
  private StringBuffer hJQ = new StringBuffer();
  public long hRd = 0L;
  public long onA = 0L;
  public long onB = 0L;
  public String onC = "";
  public String onD = "";
  public String onE = "";
  public String onF = "";
  public String onG = "";
  public String onH = "";
  public String onI = "";
  public String onJ = "";
  public String onK = "";
  public String onL = "";
  public String onM = "";
  public String onN = "";
  public String onO = "";
  public String onP = "";
  public String onQ = "";
  public String onR = "";
  public String onS = "";
  public String onT = "";
  public int onU = -1;
  public String onV = "";
  private List<List<Integer>> onW = new LinkedList();
  private List<Integer> onX = new LinkedList();
  private LinkedList<c> onZ = new LinkedList();
  public String onq = "";
  public String onu = "";
  public int onv = 0;
  public int onw = 0;
  public long onx = 0L;
  public long ony = 0L;
  public String onz = "";
  
  static
  {
    ons = "";
  }
  
  public static g bCu()
  {
    com.tencent.mm.kernel.g.DQ();
    if (!com.tencent.mm.kernel.g.DN().Dc()) {
      return new g();
    }
    Object localObject3 = com.tencent.mm.model.c.c.IX().fJ("100068");
    Object localObject2 = ((com.tencent.mm.storage.c)localObject3).field_rawXML;
    Object localObject1 = localObject2;
    if (bk.bl((String)localObject2)) {
      localObject1 = "";
    }
    String str = com.tencent.mm.a.g.o(((String)localObject1).getBytes());
    if ((ont == null) || (!str.equals(ons)))
    {
      y.i("MicroMsg.NewYearSnsCtrlV2", "create newYearSnsCtrl");
      ont = new g();
    }
    for (;;)
    {
      try
      {
        localObject2 = ((com.tencent.mm.storage.c)localObject3).ctr();
        localObject1 = "";
        if (localObject2 != null) {
          localObject1 = (String)((Map)localObject2).get("SnsHBConfig");
        }
        localObject2 = localObject1;
        if (bk.bl((String)localObject1)) {
          localObject2 = "";
        }
        localObject1 = URLDecoder.decode((String)localObject2, "UTF-8");
        localObject2 = ont;
        ((g)localObject2).hJQ = new StringBuffer();
        ((g)localObject2).onZ.clear();
        localObject3 = bn.s((String)localObject1, "sysmsg");
        if (localObject3 != null) {
          continue;
        }
        y.i("MicroMsg.NewYearSnsCtrlV2", "errr for paser %s", new Object[] { localObject1 });
        ons = str;
      }
      catch (Exception localException)
      {
        int i;
        int k;
        LinkedList localLinkedList;
        int j;
        StringBuilder localStringBuilder;
        int m;
        y.e("MicroMsg.NewYearSnsCtrlV2", "createctrl error " + localException.getMessage());
        continue;
      }
      return ont;
      ((g)localObject2).euQ = bk.ZS((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.BeginTime"));
      ((g)localObject2).hJQ.append("BeginTime:" + ((g)localObject2).euQ + ";");
      ((g)localObject2).hRd = bk.ZS((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.EndTime"));
      ((g)localObject2).hJQ.append("EndTime:" + ((g)localObject2).hRd + ";\n");
      ((g)localObject2).onv = bk.ZR((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMin"));
      ((g)localObject2).onw = bk.ZR((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMax"));
      ((g)localObject2).hJQ.append("SvrDownReqLimitLevelMin:" + ((g)localObject2).onv + " SvrDownReqLimitLevelMax: " + ((g)localObject2).onw + ";\n");
      ((g)localObject2).onA = bk.ZS((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseBeginTime"));
      ((g)localObject2).onB = bk.ZS((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseEndTime"));
      ((g)localObject2).onC = bk.aM((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenTitle"), "");
      ((g)localObject2).onD = bk.aM((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenDescription"), "");
      ((g)localObject2).onE = bk.aM((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenQueryTips"), "");
      ((g)localObject2).onF = bk.aM((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenAcceptButtonText"), "");
      ((g)localObject2).onG = bk.aM((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenRejectButtonText"), "");
      ((g)localObject2).onH = bk.aM((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenTips"), "");
      ((g)localObject2).onJ = bk.aM((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenSuccTips"), "");
      ((g)localObject2).onK = bk.aM((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenFailTips"), "");
      ((g)localObject2).onI = bk.aM((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseTips"), "");
      ((g)localObject2).onL = bk.aM((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseSuccTips"), "");
      ((g)localObject2).onM = bk.aM((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseFailTips"), "");
      ((g)localObject2).onT = bk.aM((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedID"), "");
      ((g)localObject2).onU = bk.ZR((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedCount"));
      ((g)localObject2).onV = bk.aM((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenID"), "");
      if (((g)localObject2).onU <= 0)
      {
        y.i("MicroMsg.NewYearSnsCtrlV2", "svr MaxPostFeedCount error " + ((g)localObject2).onU);
        ((g)localObject2).onU = 1;
      }
      ((g)localObject2).hJQ.append("FullScreenID:" + ((g)localObject2).onV + " BrowseBeginTime:" + ((g)localObject2).onA + " BrowseEndTime:" + ((g)localObject2).onB + " FullScreenTitle:" + ((g)localObject2).onC + " FullScreenDescription:" + ((g)localObject2).onD + " FullScreenQueryTips:" + ((g)localObject2).onE + " FullScreenAcceptButtonText: " + ((g)localObject2).onF);
      ((g)localObject2).hJQ.append("FullScreenRejectButtonText:" + ((g)localObject2).onG + " ActionSheetOpenTips:" + ((g)localObject2).onH + " ActionSheetOpenSuccTips:" + ((g)localObject2).onJ + " ActionSheetOpenFailTips:" + ((g)localObject2).onK + " ActionSheetCloseTips:" + ((g)localObject2).onI + " ActionSheetCloseSuccTips: " + ((g)localObject2).onL + " ActionSheetCloseFailTips: " + ((g)localObject2).onM + "MaxPostFeedID: " + ((g)localObject2).onT + " MaxPostFeedCount:" + ((g)localObject2).onU);
      ((g)localObject2).onN = bk.aM((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForHasUsed"), "");
      ((g)localObject2).onO = bk.aM((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForObtainUsedRight"), "");
      ((g)localObject2).onP = bk.aM((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForClosedBrowseSwitch"), "");
      ((g)localObject2).onQ = bk.aM((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertButtonText"), "");
      ((g)localObject2).onR = bk.aM((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTip"), "");
      ((g)localObject2).onS = bk.aM((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTipID"), "");
      ((g)localObject2).hJQ.append("AlertTipForHasUsed:" + ((g)localObject2).onN + " AlertTipForObtainUsedRight:" + ((g)localObject2).onO + " AlertTipForClosedBrowseSwitch:" + ((g)localObject2).onP + " AlertButtonText:" + ((g)localObject2).onQ + " GoldenCameraTip:" + ((g)localObject2).onR + " GoldenCameraTipID:" + ((g)localObject2).onS);
      i = 0;
      if (i == 0)
      {
        localObject1 = "";
        ((g)localObject2).onq = bk.aM((String)((Map)localObject3).get(String.format(".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s", new Object[] { localObject1, "RedPointID" })), "");
        ((g)localObject2).hJQ.append("RedPointID:" + ((g)localObject2).onq + ";");
        if (bk.bl(((g)localObject2).onq)) {
          continue;
        }
        if (i == 0)
        {
          localObject1 = "";
          ((g)localObject2).onx = bk.ZS((String)((Map)localObject3).get(String.format(".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s", new Object[] { localObject1, "BeginTime" })));
          ((g)localObject2).hJQ.append("RedPointID_BeginTime:" + ((g)localObject2).onx + ";");
          if (i != 0) {
            continue;
          }
          localObject1 = "";
          ((g)localObject2).ony = bk.ZS((String)((Map)localObject3).get(String.format(".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s", new Object[] { localObject1, "EndTime" })));
          ((g)localObject2).hJQ.append("RedPointID_EndTime:" + ((g)localObject2).ony + ";\n");
          localObject1 = new c();
          ((c)localObject1).onq = ((g)localObject2).onq;
          ((c)localObject1).euQ = ((g)localObject2).onx;
          ((c)localObject1).hRd = ((g)localObject2).ony;
          ((g)localObject2).onZ.add(localObject1);
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
      ((g)localObject2).onz = bk.aM((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.PostTips"), "");
      ((g)localObject2).hJQ.append("PostTips:" + ((g)localObject2).onz + ";");
      ((g)localObject2).onu = bk.aM((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.Entrance.EntranceTips"), "");
      ((g)localObject2).hJQ.append("EntranceTips:" + ((g)localObject2).onu + ";");
      ((g)localObject2).onW.clear();
      i = 0;
      k = bk.ZR((String)((Map)localObject3).get(".sysmsg.NewYearSNSCtrl2016.AmountLevel" + i + ".Count"));
      ((g)localObject2).hJQ.append("count: " + i + " | " + k + ";\n");
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
            m = bk.ZR((String)((Map)localObject3).get(localObject1));
            localLinkedList.add(Integer.valueOf(m));
            ((g)localObject2).hJQ.append("AmountLevel : " + i + " index " + j + " val: " + m + ";");
            j += 1;
          }
          else
          {
            localObject1 = Integer.valueOf(j);
          }
        }
        else
        {
          ((g)localObject2).onW.add(localLinkedList);
          i += 1;
        }
      }
      else
      {
        y.i("MicroMsg.NewYearSnsCtrlV2", "dumpinfo " + ((g)localObject2).hJQ.toString());
      }
    }
  }
  
  public static boolean bCv()
  {
    com.tencent.mm.kernel.g.DQ();
    return ((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.urI, Boolean.valueOf(true))).booleanValue();
  }
  
  public final void bCw()
  {
    Object localObject = k.h(ac.a.urM);
    if ((((i)localObject).oxf == null) || (bk.bl(((i)localObject).oxf.oxc)))
    {
      ((i)localObject).oxf = new com.tencent.mm.plugin.sns.g.g();
      ((i)localObject).oxf.oxc = this.onT;
      ((i)localObject).oxf.oxd = 0;
    }
    if ((!bk.bl(((i)localObject).oxf.oxc)) && (((i)localObject).oxf.oxc.equals(this.onT)))
    {
      com.tencent.mm.plugin.sns.g.g localg = ((i)localObject).oxf;
      localg.oxd -= 1;
      if (((i)localObject).oxf.oxd < 0) {
        ((i)localObject).oxf.oxd = 0;
      }
    }
    for (;;)
    {
      y.i("MicroMsg.NewYearSnsCtrlV2", "minusPostCountV2 " + ((i)localObject).oxf.oxd + " postId: " + this.onT + " " + bk.csb().toString());
      try
      {
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.urM, new String(((i)localObject).toByteArray(), Charset.forName("ISO-8859-1")));
        localObject = new py();
        com.tencent.mm.sdk.b.a.udP.m((b)localObject);
        return;
        ((i)localObject).oxf = new com.tencent.mm.plugin.sns.g.g();
        ((i)localObject).oxf.oxc = this.onT;
        ((i)localObject).oxf.oxd = 0;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          y.w("MicroMsg.NewYearSnsCtrlV2", "minusPostCountV2 save exception:" + localIOException.getLocalizedMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.g
 * JD-Core Version:    0.7.0.1
 */