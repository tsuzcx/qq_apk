package com.tencent.mm.plugin.sns.storage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
{
  public static int rpb = 0;
  public static int rpc = 1;
  public String cBW;
  public String cFe;
  public String hpq;
  public String rpA;
  public String rpB;
  public String rpC;
  public boolean rpD;
  public String rpE;
  public boolean rpF;
  public int rpd;
  public long rpe;
  public long rpf;
  public int rpg;
  public String rph;
  public String rpi;
  public String rpj;
  public String rpk;
  public int rpl;
  public String rpm;
  public String rpn;
  public String rpo;
  public int rpp;
  public String rpq;
  public String rpr;
  public LinkedList<String> rps;
  boolean rpt;
  public String rpu;
  public String rpv;
  public String rpw;
  public HashMap<String, String> rpx;
  public a.a rpy;
  public a.b rpz;
  
  public a()
  {
    AppMethodBeat.i(36897);
    this.cBW = "";
    this.cFe = "";
    this.rpg = 0;
    this.rph = "";
    this.rpi = "";
    this.rpj = "";
    this.rpk = "";
    this.rpl = 0;
    this.rpm = "";
    this.rpn = "";
    this.rpo = "";
    this.rpp = rpb;
    this.rpq = "";
    this.rpr = "";
    this.rps = new LinkedList();
    this.rpw = "";
    this.rpz = new a.b();
    this.rpA = "";
    this.rpB = "";
    this.rpC = "";
    this.rpD = false;
    this.rpE = "";
    this.rpF = false;
    AppMethodBeat.o(36897);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(36898);
    this.cBW = "";
    this.cFe = "";
    this.rpg = 0;
    this.rph = "";
    this.rpi = "";
    this.rpj = "";
    this.rpk = "";
    this.rpl = 0;
    this.rpm = "";
    this.rpn = "";
    this.rpo = "";
    this.rpp = rpb;
    this.rpq = "";
    this.rpr = "";
    this.rps = new LinkedList();
    this.rpw = "";
    this.rpz = new a.b();
    this.rpA = "";
    this.rpB = "";
    this.rpC = "";
    this.rpD = false;
    this.rpE = "";
    this.rpF = false;
    this.rpt = false;
    abg(paramString);
    AppMethodBeat.o(36898);
  }
  
  private void abg(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(36899);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(36899);
      return;
    }
    ab.i("MicroMsg.ADInfo", "feed xml %s", new Object[] { paramString });
    Map localMap = br.F(paramString, "ADInfo");
    if (localMap == null)
    {
      AppMethodBeat.o(36899);
      return;
    }
    this.hpq = bo.bf((String)localMap.get(".ADInfo.viewid"), "");
    if (localMap.get(".ADInfo.ad_sns_pos") == null)
    {
      AppMethodBeat.o(36899);
      return;
    }
    this.rpd = bo.apV((String)localMap.get(".ADInfo.ad_sns_pos"));
    this.rpe = bo.apW((String)localMap.get(".ADInfo.noExposureExpireTime"));
    this.rpf = bo.apW((String)localMap.get(".ADInfo.exposureNoActionExpireTime"));
    this.cFe = bo.bf((String)localMap.get(".ADInfo.uxInfo"), "");
    this.rpg = bo.apV((String)localMap.get(".ADInfo.adActionType"));
    this.rph = bo.bf((String)localMap.get(".ADInfo.adActionCardTitle"), "");
    this.rpi = bo.bf((String)localMap.get(".ADInfo.adActionCardTpId"), "");
    this.rpj = bo.bf((String)localMap.get(".ADInfo.adActionCardExt"), "");
    this.rpk = bo.bf((String)localMap.get(".ADInfo.adActionLink"), "");
    this.rpl = bo.apV((String)localMap.get(".ADInfo.adActionExt.adActionExtPOI.POIType"));
    this.rpm = bo.bf((String)localMap.get(".ADInfo.adActionExt.adActionExtPOI.POIId"), "");
    this.rpn = bo.bf((String)localMap.get(".ADInfo.adActionExt.adActionExtPOI.POIName"), "");
    this.rpo = bo.bf((String)localMap.get(".ADInfo.adActionExt.adActionExtPOI.POILink"), "");
    String str2 = bo.bf((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.Wording"), "");
    this.rpp = bo.apV((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.WordingType"));
    this.rpr = bo.bf((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.WordingLink"), "");
    int i;
    label654:
    if (this.rpp == rpc)
    {
      String str3 = bo.bf((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.WordingRepAndroid"), "");
      this.rps.clear();
      i = 0;
      if (i == 0) {}
      for (str1 = bo.bf((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.UserNameList.UserName"), "");; str1 = bo.bf((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.UserNameList.UserName" + i), ""))
      {
        if (bo.isNullOrNil(str1)) {
          break label541;
        }
        this.rps.add(str1);
        i += 1;
        break;
      }
      label541:
      if (str3.indexOf("%s") >= 0)
      {
        i = 1;
        int j = str3.indexOf("%");
        int k = str3.lastIndexOf("%");
        if ((bo.isNullOrNil(str3)) || (i == 0) || (j != k)) {
          break label761;
        }
        this.rpq = str3;
        label594:
        this.rpt = localMap.containsKey(".ADInfo.adCanvasInfo");
        this.rpv = ((String)localMap.get(".ADInfo.session_data.aid"));
        this.rpu = ((String)localMap.get(".ADInfo.session_data.trace_id"));
        this.rpx = new HashMap();
        i = 0;
        if (i != 0) {
          break label793;
        }
      }
    }
    label793:
    for (String str1 = ".ADInfo.adCanvasExt.adCardItemList.cardItem";; str1 = ".ADInfo.adCanvasExt.adCardItemList.cardItem" + i)
    {
      str2 = (String)localMap.get(str1 + ".cardTpId");
      str1 = (String)localMap.get(str1 + ".cardExt");
      if (bo.isNullOrNil(str2)) {
        break label818;
      }
      this.rpx.put(str2, str1);
      i += 1;
      break label654;
      i = 0;
      break;
      label761:
      this.rpq = str2;
      this.rpp = rpb;
      break label594;
      this.rpq = str2;
      this.rpp = rpb;
      break label594;
    }
    label818:
    paramString = Pattern.compile("<adCanvasExt>[\\s\\S]*</adCanvasExt>").matcher(paramString);
    if (paramString.find())
    {
      paramString = paramString.group();
      if (!bo.isNullOrNil(paramString)) {
        this.rpw = paramString.replaceAll("</?adCanvasExt>", "");
      }
    }
    paramString = (String)localMap.get(".ADInfo.adActionExt.adActionExtWeApp.appUserName");
    if (!TextUtils.isEmpty(paramString))
    {
      this.rpy = new a.a();
      this.rpy.cvr = paramString;
      this.rpy.appVersion = ((String)localMap.get(".ADInfo.adActionExt.adActionExtWeApp.appVersion"));
      this.rpy.cmG = ((String)localMap.get(".ADInfo.adActionExt.adActionExtWeApp.relativePagePath"));
    }
    this.rpz = new a.b(localMap, ".ADInfo");
    this.rpA = bo.bf((String)localMap.get(".ADInfo.dislikeInfo.Title.zh"), "");
    this.rpC = bo.bf((String)localMap.get(".ADInfo.dislikeInfo.Title.tw"), "");
    this.rpB = bo.bf((String)localMap.get(".ADInfo.dislikeInfo.Title.en"), "");
    if (bo.apV((String)localMap.get(".ADInfo.dislikeInfo.forbidClick")) > 0)
    {
      bool1 = true;
      this.rpD = bool1;
      this.rpE = bo.bf((String)localMap.get(".ADInfo.adInfoSyncBuffer"), "");
      if (bo.apV((String)localMap.get(".ADInfo.adInfoSyncBuffer.$imm")) != 1) {
        break label1115;
      }
    }
    label1115:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.rpF = bool1;
      AppMethodBeat.o(36899);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final boolean cqi()
  {
    return (this.rpg == 4) && (this.rpy != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.a
 * JD-Core Version:    0.7.0.1
 */