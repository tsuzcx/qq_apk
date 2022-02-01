package com.tencent.mm.plugin.sns.storage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
{
  private static HashMap<String, String> zuu;
  public static int zuv;
  public static int zuw;
  public String aQj;
  public String dBS;
  public String dFy;
  public int zuA;
  public String zuB;
  public String zuC;
  public String zuD;
  public String zuE;
  public int zuF;
  public String zuG;
  public String zuH;
  public String zuI;
  public int zuJ;
  public String zuK;
  public String zuL;
  public LinkedList<String> zuM;
  boolean zuN;
  public String zuO;
  public String zuP;
  public String zuQ;
  public HashMap<String, String> zuR;
  public b zuS;
  public c zuT;
  public String zuU;
  public String zuV;
  public String zuW;
  public boolean zuX;
  public String zuY;
  public boolean zuZ;
  public int zux;
  public long zuy;
  public long zuz;
  public d zva;
  public String zvb;
  public a zvc;
  public int zvd;
  
  static
  {
    AppMethodBeat.i(197878);
    zuu = new HashMap();
    zuv = 0;
    zuw = 1;
    AppMethodBeat.o(197878);
  }
  
  public a()
  {
    AppMethodBeat.i(96259);
    this.dBS = "";
    this.dFy = "";
    this.zuA = 0;
    this.zuB = "";
    this.zuC = "";
    this.zuD = "";
    this.zuE = "";
    this.zuF = 0;
    this.zuG = "";
    this.zuH = "";
    this.zuI = "";
    this.zuJ = zuv;
    this.zuK = "";
    this.zuL = "";
    this.zuM = new LinkedList();
    this.zuQ = "";
    this.zuT = new c();
    this.zuU = "";
    this.zuV = "";
    this.zuW = "";
    this.zuX = false;
    this.zuY = "";
    this.zuZ = false;
    AppMethodBeat.o(96259);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(96260);
    this.dBS = "";
    this.dFy = "";
    this.zuA = 0;
    this.zuB = "";
    this.zuC = "";
    this.zuD = "";
    this.zuE = "";
    this.zuF = 0;
    this.zuG = "";
    this.zuH = "";
    this.zuI = "";
    this.zuJ = zuv;
    this.zuK = "";
    this.zuL = "";
    this.zuM = new LinkedList();
    this.zuQ = "";
    this.zuT = new c();
    this.zuU = "";
    this.zuV = "";
    this.zuW = "";
    this.zuX = false;
    this.zuY = "";
    this.zuZ = false;
    this.zuN = false;
    azH(paramString);
    AppMethodBeat.o(96260);
  }
  
  private void azH(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(96261);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(96261);
      return;
    }
    ad.i("MicroMsg.ADInfo", "feed xml %s", new Object[] { paramString });
    Map localMap = bw.M(paramString, "ADInfo");
    if (localMap == null)
    {
      AppMethodBeat.o(96261);
      return;
    }
    this.aQj = bt.bI((String)localMap.get(".ADInfo.viewid"), "");
    if (localMap.get(".ADInfo.ad_sns_pos") == null)
    {
      AppMethodBeat.o(96261);
      return;
    }
    this.zux = bt.aRe((String)localMap.get(".ADInfo.ad_sns_pos"));
    this.zuy = bt.aRf((String)localMap.get(".ADInfo.noExposureExpireTime"));
    this.zuz = bt.aRf((String)localMap.get(".ADInfo.exposureNoActionExpireTime"));
    this.dFy = bt.bI((String)localMap.get(".ADInfo.uxInfo"), "");
    this.zuA = bt.aRe((String)localMap.get(".ADInfo.adActionType"));
    this.zuB = bt.bI((String)localMap.get(".ADInfo.adActionCardTitle"), "");
    this.zuC = bt.bI((String)localMap.get(".ADInfo.adActionCardTpId"), "");
    this.zuD = bt.bI((String)localMap.get(".ADInfo.adActionCardExt"), "");
    this.zuE = bt.bI((String)localMap.get(".ADInfo.adActionLink"), "");
    this.zuF = bt.aRe((String)localMap.get(".ADInfo.adActionExt.adActionExtPOI.POIType"));
    this.zuG = bt.bI((String)localMap.get(".ADInfo.adActionExt.adActionExtPOI.POIId"), "");
    this.zuH = bt.bI((String)localMap.get(".ADInfo.adActionExt.adActionExtPOI.POIName"), "");
    this.zuI = bt.bI((String)localMap.get(".ADInfo.adActionExt.adActionExtPOI.POILink"), "");
    String str1 = bt.bI((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.Wording"), "");
    this.zuJ = bt.aRe((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.WordingType"));
    this.zuL = bt.bI((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.WordingLink"), "");
    int i;
    label658:
    if (this.zuJ == zuw)
    {
      String str2 = bt.bI((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.WordingRepAndroid"), "");
      this.zuM.clear();
      i = 0;
      if (i == 0) {}
      for (??? = bt.bI((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.UserNameList.UserName"), "");; ??? = bt.bI((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.UserNameList.UserName" + i), ""))
      {
        if (bt.isNullOrNil((String)???)) {
          break label541;
        }
        this.zuM.add(???);
        i += 1;
        break;
      }
      label541:
      if (str2.indexOf("%s") >= 0)
      {
        i = 1;
        int j = str2.indexOf("%");
        int k = str2.lastIndexOf("%");
        if ((bt.isNullOrNil(str2)) || (i == 0) || (j != k)) {
          break label765;
        }
        this.zuK = str2;
        label597:
        this.zuN = localMap.containsKey(".ADInfo.adCanvasInfo");
        this.zuP = ((String)localMap.get(".ADInfo.session_data.aid"));
        this.zuO = ((String)localMap.get(".ADInfo.session_data.trace_id"));
        this.zuR = new HashMap();
        i = 0;
        if (i != 0) {
          break label797;
        }
      }
    }
    label797:
    for (??? = ".ADInfo.adCanvasExt.adCardItemList.cardItem";; ??? = ".ADInfo.adCanvasExt.adCardItemList.cardItem" + i)
    {
      str1 = (String)localMap.get((String)??? + ".cardTpId");
      ??? = (String)localMap.get((String)??? + ".cardExt");
      if (bt.isNullOrNil(str1)) {
        break label822;
      }
      this.zuR.put(str1, ???);
      i += 1;
      break label658;
      i = 0;
      break;
      label765:
      this.zuK = str1;
      this.zuJ = zuv;
      break label597;
      this.zuK = str1;
      this.zuJ = zuv;
      break label597;
    }
    label822:
    paramString = Pattern.compile("<adCanvasExt>[\\s\\S]*</adCanvasExt>").matcher(paramString);
    if (paramString.find())
    {
      paramString = paramString.group();
      if (!bt.isNullOrNil(paramString)) {
        this.zuQ = paramString.replaceAll("</?adCanvasExt>", "");
      }
    }
    paramString = (String)localMap.get(".ADInfo.adActionExt.adActionExtWeApp.appUserName");
    if (!TextUtils.isEmpty(paramString))
    {
      this.zuS = new b();
      this.zuS.dtE = paramString;
      this.zuS.appVersion = ((String)localMap.get(".ADInfo.adActionExt.adActionExtWeApp.appVersion"));
      this.zuS.dki = ((String)localMap.get(".ADInfo.adActionExt.adActionExtWeApp.relativePagePath"));
    }
    this.zuT = new c(localMap, ".ADInfo");
    this.zuU = bt.bI((String)localMap.get(".ADInfo.dislikeInfo.Title.zh"), "");
    this.zuW = bt.bI((String)localMap.get(".ADInfo.dislikeInfo.Title.tw"), "");
    this.zuV = bt.bI((String)localMap.get(".ADInfo.dislikeInfo.Title.en"), "");
    boolean bool1;
    if (bt.aRe((String)localMap.get(".ADInfo.dislikeInfo.forbidClick")) > 0) {
      bool1 = true;
    }
    for (;;)
    {
      this.zuX = bool1;
      this.zuY = bt.bI((String)localMap.get(".ADInfo.adInfoSyncBuffer"), "");
      if (bt.aRe((String)localMap.get(".ADInfo.adInfoSyncBuffer.$imm")) == 1)
      {
        bool1 = bool2;
        this.zuZ = bool1;
        this.zva = new d(localMap);
        this.zvb = bt.nullAsNil((String)localMap.get(".ADInfo.appWaid.pkg"));
        ??? = j.axO(this.dFy);
        paramString = (String)???;
        if (TextUtils.isEmpty((CharSequence)???))
        {
          ad.w("MicroMsg.ADInfo", "aid from uxinfo is empty, uxinfo=" + this.dFy + ", aid=" + this.zuP);
          paramString = this.zuP;
        }
      }
      synchronized (zuu)
      {
        if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.zvb)))
        {
          ad.i("MicroMsg.ADInfo", "cache waidPkg, key=" + paramString + ", value=" + this.zvb);
          zuu.put(paramString, this.zvb);
        }
        if (localMap.containsKey(".ADInfo.adActionExt.adActionSchemaJump"))
        {
          paramString = bt.bI((String)localMap.get(".ADInfo.adActionExt.adActionSchemaJump" + ".packageName"), "");
          ??? = bt.bI((String)localMap.get(".ADInfo.adActionExt.adActionSchemaJump" + ".openSdkAppIdAndroid"), "");
          if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty((CharSequence)???)))
          {
            this.zvc = new a();
            this.zvc.Lw = paramString;
            this.zvc.appId = ((String)???);
            this.zvc.zve = bt.bI((String)localMap.get(".ADInfo.adActionExt.adActionSchemaJump" + ".appPageUrlAndroid"), "");
            this.zvc.appName = bt.bI((String)localMap.get(".ADInfo.adActionExt.adActionSchemaJump" + ".appName"), "");
          }
        }
        this.zvd = bt.aRe((String)localMap.get(".ADInfo.adGroupEndTime"));
        AppMethodBeat.o(96261);
        return;
        bool1 = false;
        continue;
        bool1 = false;
      }
    }
  }
  
  public static String azI(String paramString)
  {
    AppMethodBeat.i(197877);
    ??? = "";
    String str = j.axO(paramString);
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      synchronized (zuu)
      {
        paramString = bt.nullAsNil((String)zuu.get(str));
        AppMethodBeat.o(197877);
        return paramString;
      }
      ad.e("MicroMsg.ADInfo", "getWaidPkgByUxInfo, aid is empty, uxinfo=".concat(String.valueOf(paramString)));
      paramString = (String)???;
    }
  }
  
  public final boolean dVQ()
  {
    return (this.zuA == 4) && (this.zuS != null);
  }
  
  public static final class a
  {
    public String Lw;
    public String appId;
    public String appName;
    public String zve;
    
    public final String toString()
    {
      AppMethodBeat.i(197875);
      String str = "appId=" + this.appId + ", pkg=" + this.Lw + ", appName=" + this.appName + ", pageUrl=" + this.zve;
      AppMethodBeat.o(197875);
      return str;
    }
  }
  
  public static final class b
  {
    public String appVersion;
    public String dki;
    public String dtE;
  }
  
  public static final class c
  {
    public int zvf;
    private List<a> zvg;
    public Map<String, List<a>> zvh;
    public String zvi;
    public String zvj;
    public String zvk;
    
    public c()
    {
      AppMethodBeat.i(96252);
      this.zvf = 0;
      this.zvg = new ArrayList();
      this.zvh = new HashMap();
      this.zvi = "";
      this.zvj = "";
      this.zvk = "";
      AppMethodBeat.o(96252);
    }
    
    public c(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(96253);
      this.zvf = 0;
      this.zvg = new ArrayList();
      this.zvh = new HashMap();
      this.zvi = "";
      this.zvj = "";
      this.zvk = "";
      String str2 = paramString + ".dislikeInfo.ReasonList";
      int i = 0;
      String str1 = str2 + ".Reason";
      if (i > 0) {
        str1 = str1 + i;
      }
      for (;;)
      {
        if (paramMap.get(str1 + ".ReasonId") != null)
        {
          this.zvg.add(new a(bt.bI((String)paramMap.get(str1 + ".Wording.zh"), ""), bt.bI((String)paramMap.get(str1 + ".Wording.tw"), ""), bt.bI((String)paramMap.get(str1 + ".Wording.en"), ""), bt.aRe((String)paramMap.get(str1 + ".ReasonId"))));
          i += 1;
          break;
        }
        this.zvf = bt.aRe((String)paramMap.get(paramString + ".dislikeInfo.unReceiveAdInterval"));
        this.zvi = bt.bI((String)paramMap.get(paramString + ".dislikeInfo.forbidClickReason.zh"), "");
        this.zvj = bt.bI((String)paramMap.get(paramString + ".dislikeInfo.forbidClickReason.tw"), "");
        this.zvk = bt.bI((String)paramMap.get(paramString + ".dislikeInfo.forbidClickReason.en"), "");
        AppMethodBeat.o(96253);
        return;
      }
    }
    
    public final List<a> dVR()
    {
      AppMethodBeat.i(96251);
      Object localObject = ac.iM(aj.getContext());
      if ((!"zh_CN".equals(localObject)) && (!"zh_TW".equals(localObject)) && (!"zh_HK".equals(localObject))) {
        localObject = "en";
      }
      for (;;)
      {
        if (!this.zvh.containsKey(localObject))
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = this.zvg.iterator();
          while (localIterator.hasNext())
          {
            a locala = (a)localIterator.next();
            if (("zh_CN".equals(localObject)) && (!bt.isNullOrNil(locala.zvm))) {
              localArrayList.add(locala);
            } else if ((("zh_TW".equals(localObject)) || ("zh_HK".equals(localObject))) && (!bt.isNullOrNil(locala.zvn))) {
              localArrayList.add(locala);
            } else if (("en".equals(localObject)) && (!bt.isNullOrNil(locala.zvo))) {
              localArrayList.add(locala);
            }
          }
          this.zvh.put(localObject, localArrayList);
        }
        localObject = (List)this.zvh.get(localObject);
        AppMethodBeat.o(96251);
        return localObject;
      }
    }
    
    public final boolean dVS()
    {
      AppMethodBeat.i(197876);
      if (dVR().size() > 0)
      {
        AppMethodBeat.o(197876);
        return true;
      }
      AppMethodBeat.o(197876);
      return false;
    }
    
    public static final class a
    {
      public static int zvl = 101;
      public long zcr = 0L;
      public String zvm = "";
      public String zvn = "";
      public String zvo = "";
      public int zvp = 0;
      public long zvq = 0L;
      
      public a() {}
      
      public a(String paramString1, String paramString2, String paramString3, int paramInt)
      {
        this.zvm = paramString1;
        this.zvn = paramString2;
        this.zvo = paramString3;
        this.zvp = paramInt;
      }
    }
  }
  
  public static final class d
  {
    public ArrayList<a.e> zvr;
    
    public d()
    {
      AppMethodBeat.i(96255);
      this.zvr = new ArrayList();
      AppMethodBeat.o(96255);
    }
    
    public d(Map<String, String> paramMap)
    {
      AppMethodBeat.i(96254);
      this.zvr = new ArrayList();
      int i = 0;
      for (;;)
      {
        String str;
        a.e locale;
        int j;
        if (i == 0)
        {
          localObject = ".ADInfo.adActionExt.adVoteInfoExt.voteItemList.voteResultInfo";
          str = bt.bI((String)paramMap.get((String)localObject + ".id"), "");
          if (TextUtils.isEmpty(str)) {
            break;
          }
          locale = new a.e();
          locale.id = str;
          locale.zvs = bt.aRe((String)paramMap.get((String)localObject + ".scoring"));
          locale.zvt = bt.aRe((String)paramMap.get((String)localObject + ".friends"));
          str = (String)localObject + ".friendsList.userName";
          j = 0;
          label188:
          if (j != 0) {
            break label264;
          }
        }
        label264:
        for (Object localObject = str;; localObject = str + j)
        {
          localObject = bt.bI((String)paramMap.get(localObject), "");
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label288;
          }
          locale.zvu.add(localObject);
          j += 1;
          break label188;
          localObject = ".ADInfo.adActionExt.adVoteInfoExt.voteItemList.voteResultInfo" + i;
          break;
        }
        label288:
        this.zvr.add(locale);
        i += 1;
      }
      AppMethodBeat.o(96254);
    }
    
    private a.e azJ(String paramString)
    {
      AppMethodBeat.i(96257);
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(96257);
        return null;
      }
      Iterator localIterator = this.zvr.iterator();
      while (localIterator.hasNext())
      {
        a.e locale = (a.e)localIterator.next();
        if (paramString.equals(locale.id))
        {
          AppMethodBeat.o(96257);
          return locale;
        }
      }
      AppMethodBeat.o(96257);
      return null;
    }
    
    public final int jx(String paramString1, String paramString2)
    {
      int j = 0;
      AppMethodBeat.i(96256);
      paramString1 = azJ(paramString1);
      paramString2 = azJ(paramString2);
      int i;
      if (paramString1 == null)
      {
        i = 0;
        if (paramString2 != null) {
          break label62;
        }
      }
      for (;;)
      {
        if (i + j <= 0) {
          break label71;
        }
        i = i * 100 / (j + i);
        AppMethodBeat.o(96256);
        return i;
        i = paramString1.zvs;
        break;
        label62:
        j = paramString2.zvs;
      }
      label71:
      AppMethodBeat.o(96256);
      return 50;
    }
  }
  
  public static final class e
  {
    public String id;
    public int zvs;
    public int zvt;
    public ArrayList<String> zvu;
    
    public e()
    {
      AppMethodBeat.i(96258);
      this.zvu = new ArrayList();
      AppMethodBeat.o(96258);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.a
 * JD-Core Version:    0.7.0.1
 */