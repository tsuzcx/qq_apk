package com.tencent.mm.plugin.sns.storage;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
{
  public static int ozR = 0;
  public static int ozS = 1;
  public String bUr = "";
  public String fVM;
  public String oAa = "";
  public int oAb = 0;
  public String oAc = "";
  public String oAd = "";
  public String oAe = "";
  public int oAf = ozR;
  public String oAg = "";
  public String oAh = "";
  public LinkedList<String> oAi = new LinkedList();
  boolean oAj;
  public String oAk;
  public String oAl;
  public String oAm = "";
  public HashMap<String, String> oAn;
  public a.a oAo;
  public a.b oAp = new a.b();
  public String oAq = "";
  public String oAr = "";
  public String oAs = "";
  public boolean oAt = false;
  public String oAu = "";
  public boolean oAv = false;
  public String ovV = "";
  public int ozT;
  public long ozU;
  public long ozV;
  public int ozW = 0;
  public String ozX = "";
  public String ozY = "";
  public String ozZ = "";
  
  public a() {}
  
  public a(String paramString)
  {
    this.oAj = false;
    Om(paramString);
  }
  
  private void Om(String paramString)
  {
    boolean bool2 = true;
    if (bk.bl(paramString)) {}
    Map localMap;
    do
    {
      do
      {
        return;
        y.i("MicroMsg.ADInfo", "feed xml %s", new Object[] { paramString });
        localMap = bn.s(paramString, "ADInfo");
      } while (localMap == null);
      this.fVM = bk.aM((String)localMap.get(".ADInfo.viewid"), "");
    } while (localMap.get(".ADInfo.ad_sns_pos") == null);
    this.ozT = bk.ZR((String)localMap.get(".ADInfo.ad_sns_pos"));
    this.ozU = bk.ZS((String)localMap.get(".ADInfo.noExposureExpireTime"));
    this.ozV = bk.ZS((String)localMap.get(".ADInfo.exposureNoActionExpireTime"));
    this.ovV = bk.aM((String)localMap.get(".ADInfo.uxInfo"), "");
    this.ozW = bk.ZR((String)localMap.get(".ADInfo.adActionType"));
    this.ozX = bk.aM((String)localMap.get(".ADInfo.adActionCardTitle"), "");
    this.ozY = bk.aM((String)localMap.get(".ADInfo.adActionCardTpId"), "");
    this.ozZ = bk.aM((String)localMap.get(".ADInfo.adActionCardExt"), "");
    this.oAa = bk.aM((String)localMap.get(".ADInfo.adActionLink"), "");
    this.oAb = bk.ZR((String)localMap.get(".ADInfo.adActionExt.adActionExtPOI.POIType"));
    this.oAc = bk.aM((String)localMap.get(".ADInfo.adActionExt.adActionExtPOI.POIId"), "");
    this.oAd = bk.aM((String)localMap.get(".ADInfo.adActionExt.adActionExtPOI.POIName"), "");
    this.oAe = bk.aM((String)localMap.get(".ADInfo.adActionExt.adActionExtPOI.POILink"), "");
    String str2 = bk.aM((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.Wording"), "");
    this.oAf = bk.ZR((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.WordingType"));
    this.oAh = bk.aM((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.WordingLink"), "");
    int i;
    if (this.oAf == ozS)
    {
      String str3 = bk.aM((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.WordingRepAndroid"), "");
      this.oAi.clear();
      i = 0;
      if (i == 0) {}
      for (str1 = bk.aM((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.UserNameList.UserName"), "");; str1 = bk.aM((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.UserNameList.UserName" + i), ""))
      {
        if (bk.bl(str1)) {
          break label519;
        }
        this.oAi.add(str1);
        i += 1;
        break;
      }
      label519:
      if (str3.indexOf("%s") >= 0)
      {
        i = 1;
        int j = str3.indexOf("%");
        int k = str3.lastIndexOf("%");
        if ((bk.bl(str3)) || (i == 0) || (j != k)) {
          break label737;
        }
        this.oAg = str3;
        label572:
        this.oAj = localMap.containsKey(".ADInfo.adCanvasInfo");
        this.oAl = ((String)localMap.get(".ADInfo.session_data.aid"));
        this.oAk = ((String)localMap.get(".ADInfo.session_data.trace_id"));
        this.oAn = new HashMap();
        i = 0;
        label630:
        if (i != 0) {
          break label769;
        }
      }
    }
    label769:
    for (String str1 = ".ADInfo.adCanvasExt.adCardItemList.cardItem";; str1 = ".ADInfo.adCanvasExt.adCardItemList.cardItem" + i)
    {
      str2 = (String)localMap.get(str1 + ".cardTpId");
      str1 = (String)localMap.get(str1 + ".cardExt");
      if (bk.bl(str2)) {
        break label794;
      }
      this.oAn.put(str2, str1);
      i += 1;
      break label630;
      i = 0;
      break;
      label737:
      this.oAg = str2;
      this.oAf = ozR;
      break label572;
      this.oAg = str2;
      this.oAf = ozR;
      break label572;
    }
    label794:
    paramString = Pattern.compile("<adCanvasExt>[\\s\\S]*</adCanvasExt>").matcher(paramString);
    if (paramString.find())
    {
      paramString = paramString.group();
      if (!bk.bl(paramString)) {
        this.oAm = paramString.replaceAll("</?adCanvasExt>", "");
      }
    }
    paramString = (String)localMap.get(".ADInfo.adActionExt.adActionExtWeApp.appUserName");
    if (!TextUtils.isEmpty(paramString))
    {
      this.oAo = new a.a();
      this.oAo.bNZ = paramString;
      this.oAo.bth = ((String)localMap.get(".ADInfo.adActionExt.adActionExtWeApp.appVersion"));
      this.oAo.bFw = ((String)localMap.get(".ADInfo.adActionExt.adActionExtWeApp.relativePagePath"));
    }
    this.oAp = new a.b(localMap, ".ADInfo");
    this.oAq = bk.aM((String)localMap.get(".ADInfo.dislikeInfo.Title.zh"), "");
    this.oAs = bk.aM((String)localMap.get(".ADInfo.dislikeInfo.Title.tw"), "");
    this.oAr = bk.aM((String)localMap.get(".ADInfo.dislikeInfo.Title.en"), "");
    if (bk.ZR((String)localMap.get(".ADInfo.dislikeInfo.forbidClick")) > 0)
    {
      bool1 = true;
      this.oAt = bool1;
      this.oAu = bk.aM((String)localMap.get(".ADInfo.adInfoSyncBuffer"), "");
      if (bk.ZR((String)localMap.get(".ADInfo.adInfoSyncBuffer.$imm")) != 1) {
        break label1086;
      }
    }
    label1086:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.oAv = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public final boolean bEC()
  {
    return (this.ozW == 4) && (this.oAo != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.a
 * JD-Core Version:    0.7.0.1
 */