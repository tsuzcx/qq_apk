package com.tencent.mm.plugin.sns.storage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
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
  private static HashMap<String, String> zLL;
  public static int zLM;
  public static int zLN;
  public String aQj;
  public String dCX;
  public String dGD;
  public int zLO;
  public long zLP;
  public long zLQ;
  public int zLR;
  public String zLS;
  public String zLT;
  public String zLU;
  public String zLV;
  public int zLW;
  public String zLX;
  public String zLY;
  public String zLZ;
  public int zMa;
  public String zMb;
  public String zMc;
  public LinkedList<String> zMd;
  public String zMe;
  public String zMf;
  public int zMg;
  public int zMh;
  boolean zMi;
  public String zMj;
  public String zMk;
  public String zMl;
  public HashMap<String, String> zMm;
  public b zMn;
  public c zMo;
  public String zMp;
  public String zMq;
  public String zMr;
  public boolean zMs;
  public String zMt;
  public boolean zMu;
  public d zMv;
  public String zMw;
  public a zMx;
  public int zMy;
  
  static
  {
    AppMethodBeat.i(219372);
    zLL = new HashMap();
    zLM = 0;
    zLN = 1;
    AppMethodBeat.o(219372);
  }
  
  public a()
  {
    AppMethodBeat.i(96259);
    this.dCX = "";
    this.dGD = "";
    this.zLR = 0;
    this.zLS = "";
    this.zLT = "";
    this.zLU = "";
    this.zLV = "";
    this.zLW = 0;
    this.zLX = "";
    this.zLY = "";
    this.zLZ = "";
    this.zMa = zLM;
    this.zMb = "";
    this.zMc = "";
    this.zMd = new LinkedList();
    this.zMl = "";
    this.zMo = new c();
    this.zMp = "";
    this.zMq = "";
    this.zMr = "";
    this.zMs = false;
    this.zMt = "";
    this.zMu = false;
    AppMethodBeat.o(96259);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(96260);
    this.dCX = "";
    this.dGD = "";
    this.zLR = 0;
    this.zLS = "";
    this.zLT = "";
    this.zLU = "";
    this.zLV = "";
    this.zLW = 0;
    this.zLX = "";
    this.zLY = "";
    this.zLZ = "";
    this.zMa = zLM;
    this.zMb = "";
    this.zMc = "";
    this.zMd = new LinkedList();
    this.zMl = "";
    this.zMo = new c();
    this.zMp = "";
    this.zMq = "";
    this.zMr = "";
    this.zMs = false;
    this.zMt = "";
    this.zMu = false;
    this.zMi = false;
    aAY(paramString);
    AppMethodBeat.o(96260);
  }
  
  private void aAY(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(96261);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(96261);
      return;
    }
    ae.i("MicroMsg.ADInfo", "feed xml %s", new Object[] { paramString });
    Map localMap = bx.M(paramString, "ADInfo");
    if (localMap == null)
    {
      AppMethodBeat.o(96261);
      return;
    }
    this.aQj = bu.bI((String)localMap.get(".ADInfo.viewid"), "");
    if (localMap.get(".ADInfo.ad_sns_pos") == null)
    {
      AppMethodBeat.o(96261);
      return;
    }
    this.zLO = bu.aSB((String)localMap.get(".ADInfo.ad_sns_pos"));
    this.zLP = bu.aSC((String)localMap.get(".ADInfo.noExposureExpireTime"));
    this.zLQ = bu.aSC((String)localMap.get(".ADInfo.exposureNoActionExpireTime"));
    this.dGD = bu.bI((String)localMap.get(".ADInfo.uxInfo"), "");
    this.zLR = bu.aSB((String)localMap.get(".ADInfo.adActionType"));
    this.zLS = bu.bI((String)localMap.get(".ADInfo.adActionCardTitle"), "");
    this.zLT = bu.bI((String)localMap.get(".ADInfo.adActionCardTpId"), "");
    this.zLU = bu.bI((String)localMap.get(".ADInfo.adActionCardExt"), "");
    this.zLV = bu.bI((String)localMap.get(".ADInfo.adActionLink"), "");
    this.zLW = bu.aSB((String)localMap.get(".ADInfo.adActionExt.adActionExtPOI.POIType"));
    this.zLX = bu.bI((String)localMap.get(".ADInfo.adActionExt.adActionExtPOI.POIId"), "");
    this.zLY = bu.bI((String)localMap.get(".ADInfo.adActionExt.adActionExtPOI.POIName"), "");
    this.zLZ = bu.bI((String)localMap.get(".ADInfo.adActionExt.adActionExtPOI.POILink"), "");
    this.zMg = bu.aSB((String)localMap.get(".ADInfo.adActionExt.adChainType"));
    this.zMh = bu.aSB((String)localMap.get(".ADInfo.adActionExt.adChainTypeExpireTime"));
    String str1 = bu.bI((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.Wording"), "");
    this.zMa = bu.aSB((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.WordingType"));
    this.zMc = bu.bI((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.WordingLink"), "");
    int i;
    label699:
    if (this.zMa == zLN)
    {
      String str2 = bu.bI((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.WordingRepAndroid"), "");
      this.zMd.clear();
      i = 0;
      if (i == 0) {}
      for (??? = bu.bI((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.UserNameList.UserName"), "");; ??? = bu.bI((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.UserNameList.UserName" + i), ""))
      {
        if (bu.isNullOrNil((String)???)) {
          break label582;
        }
        this.zMd.add(???);
        i += 1;
        break;
      }
      label582:
      if (str2.indexOf("%s") >= 0)
      {
        i = 1;
        int j = str2.indexOf("%");
        int k = str2.lastIndexOf("%");
        if ((bu.isNullOrNil(str2)) || (i == 0) || (j != k)) {
          break label806;
        }
        this.zMb = str2;
        label638:
        this.zMi = localMap.containsKey(".ADInfo.adCanvasInfo");
        this.zMk = ((String)localMap.get(".ADInfo.session_data.aid"));
        this.zMj = ((String)localMap.get(".ADInfo.session_data.trace_id"));
        this.zMm = new HashMap();
        i = 0;
        if (i != 0) {
          break label838;
        }
      }
    }
    label806:
    label838:
    for (??? = ".ADInfo.adCanvasExt.adCardItemList.cardItem";; ??? = ".ADInfo.adCanvasExt.adCardItemList.cardItem" + i)
    {
      str1 = (String)localMap.get((String)??? + ".cardTpId");
      ??? = (String)localMap.get((String)??? + ".cardExt");
      if (bu.isNullOrNil(str1)) {
        break label863;
      }
      this.zMm.put(str1, ???);
      i += 1;
      break label699;
      i = 0;
      break;
      this.zMb = str1;
      this.zMa = zLM;
      break label638;
      this.zMb = str1;
      this.zMa = zLM;
      break label638;
    }
    label863:
    paramString = Pattern.compile("<adCanvasExt>[\\s\\S]*</adCanvasExt>").matcher(paramString);
    if (paramString.find())
    {
      paramString = paramString.group();
      if (!bu.isNullOrNil(paramString)) {
        this.zMl = paramString.replaceAll("</?adCanvasExt>", "");
      }
    }
    paramString = (String)localMap.get(".ADInfo.adActionExt.adActionExtWeApp.appUserName");
    if (!TextUtils.isEmpty(paramString))
    {
      this.zMn = new b();
      this.zMn.duJ = paramString;
      this.zMn.appVersion = ((String)localMap.get(".ADInfo.adActionExt.adActionExtWeApp.appVersion"));
      this.zMn.dlk = ((String)localMap.get(".ADInfo.adActionExt.adActionExtWeApp.relativePagePath"));
    }
    this.zMo = new c(localMap, ".ADInfo");
    this.zMp = bu.bI((String)localMap.get(".ADInfo.dislikeInfo.Title.zh"), "");
    this.zMr = bu.bI((String)localMap.get(".ADInfo.dislikeInfo.Title.tw"), "");
    this.zMq = bu.bI((String)localMap.get(".ADInfo.dislikeInfo.Title.en"), "");
    boolean bool1;
    if (bu.aSB((String)localMap.get(".ADInfo.dislikeInfo.forbidClick")) > 0) {
      bool1 = true;
    }
    for (;;)
    {
      this.zMs = bool1;
      this.zMt = bu.bI((String)localMap.get(".ADInfo.adInfoSyncBuffer"), "");
      if (bu.aSB((String)localMap.get(".ADInfo.adInfoSyncBuffer.$imm")) == 1)
      {
        bool1 = bool2;
        this.zMu = bool1;
        this.zMv = new d(localMap);
        this.zMw = bu.nullAsNil((String)localMap.get(".ADInfo.appWaid.pkg"));
        ??? = k.azf(this.dGD);
        paramString = (String)???;
        if (TextUtils.isEmpty((CharSequence)???))
        {
          ae.w("MicroMsg.ADInfo", "aid from uxinfo is empty, uxinfo=" + this.dGD + ", aid=" + this.zMk);
          paramString = this.zMk;
        }
      }
      synchronized (zLL)
      {
        if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.zMw)))
        {
          ae.i("MicroMsg.ADInfo", "cache waidPkg, key=" + paramString + ", value=" + this.zMw);
          zLL.put(paramString, this.zMw);
        }
        if (localMap.containsKey(".ADInfo.adActionExt.adActionSchemaJump"))
        {
          paramString = bu.bI((String)localMap.get(".ADInfo.adActionExt.adActionSchemaJump" + ".packageName"), "");
          ??? = bu.bI((String)localMap.get(".ADInfo.adActionExt.adActionSchemaJump" + ".openSdkAppIdAndroid"), "");
          if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty((CharSequence)???)))
          {
            this.zMx = new a();
            this.zMx.Lw = paramString;
            this.zMx.appId = ((String)???);
            this.zMx.zMz = bu.bI((String)localMap.get(".ADInfo.adActionExt.adActionSchemaJump" + ".appPageUrlAndroid"), "");
            this.zMx.appName = bu.bI((String)localMap.get(".ADInfo.adActionExt.adActionSchemaJump" + ".appName"), "");
          }
        }
        this.zMy = bu.aSB((String)localMap.get(".ADInfo.adGroupEndTime"));
        AppMethodBeat.o(96261);
        return;
        bool1 = false;
        continue;
        bool1 = false;
      }
    }
  }
  
  public static String aAZ(String paramString)
  {
    AppMethodBeat.i(219371);
    ??? = "";
    String str = k.azf(paramString);
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      synchronized (zLL)
      {
        paramString = bu.nullAsNil((String)zLL.get(str));
        AppMethodBeat.o(219371);
        return paramString;
      }
      ae.e("MicroMsg.ADInfo", "getWaidPkgByUxInfo, aid is empty, uxinfo=".concat(String.valueOf(paramString)));
      paramString = (String)???;
    }
  }
  
  public final boolean dZr()
  {
    return (this.zLR == 4) && (this.zMn != null);
  }
  
  public static final class a
  {
    public String Lw;
    public String appId;
    public String appName;
    public String zMz;
    
    public final String toString()
    {
      AppMethodBeat.i(219369);
      String str = "appId=" + this.appId + ", pkg=" + this.Lw + ", appName=" + this.appName + ", pageUrl=" + this.zMz;
      AppMethodBeat.o(219369);
      return str;
    }
  }
  
  public static final class b
  {
    public String appVersion;
    public String dlk;
    public String duJ;
  }
  
  public static final class c
  {
    public int zMA;
    private List<a> zMB;
    public Map<String, List<a>> zMC;
    public String zMD;
    public String zME;
    public String zMF;
    
    public c()
    {
      AppMethodBeat.i(96252);
      this.zMA = 0;
      this.zMB = new ArrayList();
      this.zMC = new HashMap();
      this.zMD = "";
      this.zME = "";
      this.zMF = "";
      AppMethodBeat.o(96252);
    }
    
    public c(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(96253);
      this.zMA = 0;
      this.zMB = new ArrayList();
      this.zMC = new HashMap();
      this.zMD = "";
      this.zME = "";
      this.zMF = "";
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
          this.zMB.add(new a(bu.bI((String)paramMap.get(str1 + ".Wording.zh"), ""), bu.bI((String)paramMap.get(str1 + ".Wording.tw"), ""), bu.bI((String)paramMap.get(str1 + ".Wording.en"), ""), bu.aSB((String)paramMap.get(str1 + ".ReasonId"))));
          i += 1;
          break;
        }
        this.zMA = bu.aSB((String)paramMap.get(paramString + ".dislikeInfo.unReceiveAdInterval"));
        this.zMD = bu.bI((String)paramMap.get(paramString + ".dislikeInfo.forbidClickReason.zh"), "");
        this.zME = bu.bI((String)paramMap.get(paramString + ".dislikeInfo.forbidClickReason.tw"), "");
        this.zMF = bu.bI((String)paramMap.get(paramString + ".dislikeInfo.forbidClickReason.en"), "");
        AppMethodBeat.o(96253);
        return;
      }
    }
    
    public final List<a> dZs()
    {
      AppMethodBeat.i(96251);
      Object localObject = ad.iR(ak.getContext());
      if ((!"zh_CN".equals(localObject)) && (!"zh_TW".equals(localObject)) && (!"zh_HK".equals(localObject))) {
        localObject = "en";
      }
      for (;;)
      {
        if (!this.zMC.containsKey(localObject))
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = this.zMB.iterator();
          while (localIterator.hasNext())
          {
            a locala = (a)localIterator.next();
            if (("zh_CN".equals(localObject)) && (!bu.isNullOrNil(locala.zMH))) {
              localArrayList.add(locala);
            } else if ((("zh_TW".equals(localObject)) || ("zh_HK".equals(localObject))) && (!bu.isNullOrNil(locala.zMI))) {
              localArrayList.add(locala);
            } else if (("en".equals(localObject)) && (!bu.isNullOrNil(locala.zMJ))) {
              localArrayList.add(locala);
            }
          }
          this.zMC.put(localObject, localArrayList);
        }
        localObject = (List)this.zMC.get(localObject);
        AppMethodBeat.o(96251);
        return localObject;
      }
    }
    
    public final boolean dZt()
    {
      AppMethodBeat.i(219370);
      if (dZs().size() > 0)
      {
        AppMethodBeat.o(219370);
        return true;
      }
      AppMethodBeat.o(219370);
      return false;
    }
    
    public static final class a
    {
      public static int zMG = 101;
      public String zMH = "";
      public String zMI = "";
      public String zMJ = "";
      public int zMK = 0;
      public long zML = 0L;
      public long zte = 0L;
      
      public a() {}
      
      public a(String paramString1, String paramString2, String paramString3, int paramInt)
      {
        this.zMH = paramString1;
        this.zMI = paramString2;
        this.zMJ = paramString3;
        this.zMK = paramInt;
      }
    }
  }
  
  public static final class d
  {
    public ArrayList<a.e> zMM;
    
    public d()
    {
      AppMethodBeat.i(96255);
      this.zMM = new ArrayList();
      AppMethodBeat.o(96255);
    }
    
    public d(Map<String, String> paramMap)
    {
      AppMethodBeat.i(96254);
      this.zMM = new ArrayList();
      int i = 0;
      for (;;)
      {
        String str;
        a.e locale;
        int j;
        if (i == 0)
        {
          localObject = ".ADInfo.adActionExt.adVoteInfoExt.voteItemList.voteResultInfo";
          str = bu.bI((String)paramMap.get((String)localObject + ".id"), "");
          if (TextUtils.isEmpty(str)) {
            break;
          }
          locale = new a.e();
          locale.id = str;
          locale.zMN = bu.aSB((String)paramMap.get((String)localObject + ".scoring"));
          locale.zMO = bu.aSB((String)paramMap.get((String)localObject + ".friends"));
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
          localObject = bu.bI((String)paramMap.get(localObject), "");
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label288;
          }
          locale.zMP.add(localObject);
          j += 1;
          break label188;
          localObject = ".ADInfo.adActionExt.adVoteInfoExt.voteItemList.voteResultInfo" + i;
          break;
        }
        label288:
        this.zMM.add(locale);
        i += 1;
      }
      AppMethodBeat.o(96254);
    }
    
    private a.e aBa(String paramString)
    {
      AppMethodBeat.i(96257);
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(96257);
        return null;
      }
      Iterator localIterator = this.zMM.iterator();
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
    
    public final int jE(String paramString1, String paramString2)
    {
      int j = 0;
      AppMethodBeat.i(96256);
      paramString1 = aBa(paramString1);
      paramString2 = aBa(paramString2);
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
        i = paramString1.zMN;
        break;
        label62:
        j = paramString2.zMN;
      }
      label71:
      AppMethodBeat.o(96256);
      return 50;
    }
  }
  
  public static final class e
  {
    public String id;
    public int zMN;
    public int zMO;
    public ArrayList<String> zMP;
    
    public e()
    {
      AppMethodBeat.i(96258);
      this.zMP = new ArrayList();
      AppMethodBeat.o(96258);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.a
 * JD-Core Version:    0.7.0.1
 */