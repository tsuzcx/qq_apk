package com.tencent.mm.plugin.sns.storage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  public static int wRO = 0;
  public static int wRP = 1;
  public String dAM;
  public String dsv;
  public String dvK;
  public int wRQ;
  public long wRR;
  public long wRS;
  public int wRT;
  public String wRU;
  public String wRV;
  public String wRW;
  public String wRX;
  public int wRY;
  public String wRZ;
  public String wSa;
  public String wSb;
  public int wSc;
  public String wSd;
  public String wSe;
  public LinkedList<String> wSf;
  boolean wSg;
  public String wSh;
  public String wSi;
  public String wSj;
  public HashMap<String, String> wSk;
  public b wSl;
  public c wSm;
  public String wSn;
  public String wSo;
  public String wSp;
  public boolean wSq;
  public String wSr;
  public boolean wSs;
  public d wSt;
  public String wSu;
  public a wSv;
  
  public a()
  {
    AppMethodBeat.i(96259);
    this.dsv = "";
    this.dvK = "";
    this.wRT = 0;
    this.wRU = "";
    this.wRV = "";
    this.wRW = "";
    this.wRX = "";
    this.wRY = 0;
    this.wRZ = "";
    this.wSa = "";
    this.wSb = "";
    this.wSc = wRO;
    this.wSd = "";
    this.wSe = "";
    this.wSf = new LinkedList();
    this.wSj = "";
    this.wSm = new c();
    this.wSn = "";
    this.wSo = "";
    this.wSp = "";
    this.wSq = false;
    this.wSr = "";
    this.wSs = false;
    AppMethodBeat.o(96259);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(96260);
    this.dsv = "";
    this.dvK = "";
    this.wRT = 0;
    this.wRU = "";
    this.wRV = "";
    this.wRW = "";
    this.wRX = "";
    this.wRY = 0;
    this.wRZ = "";
    this.wSa = "";
    this.wSb = "";
    this.wSc = wRO;
    this.wSd = "";
    this.wSe = "";
    this.wSf = new LinkedList();
    this.wSj = "";
    this.wSm = new c();
    this.wSn = "";
    this.wSo = "";
    this.wSp = "";
    this.wSq = false;
    this.wSr = "";
    this.wSs = false;
    this.wSg = false;
    apq(paramString);
    AppMethodBeat.o(96260);
  }
  
  private void apq(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(96261);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(96261);
      return;
    }
    ad.i("MicroMsg.ADInfo", "feed xml %s", new Object[] { paramString });
    Map localMap = bw.K(paramString, "ADInfo");
    if (localMap == null)
    {
      AppMethodBeat.o(96261);
      return;
    }
    this.dAM = bt.by((String)localMap.get(".ADInfo.viewid"), "");
    if (localMap.get(".ADInfo.ad_sns_pos") == null)
    {
      AppMethodBeat.o(96261);
      return;
    }
    this.wRQ = bt.aGh((String)localMap.get(".ADInfo.ad_sns_pos"));
    this.wRR = bt.aGi((String)localMap.get(".ADInfo.noExposureExpireTime"));
    this.wRS = bt.aGi((String)localMap.get(".ADInfo.exposureNoActionExpireTime"));
    this.dvK = bt.by((String)localMap.get(".ADInfo.uxInfo"), "");
    this.wRT = bt.aGh((String)localMap.get(".ADInfo.adActionType"));
    this.wRU = bt.by((String)localMap.get(".ADInfo.adActionCardTitle"), "");
    this.wRV = bt.by((String)localMap.get(".ADInfo.adActionCardTpId"), "");
    this.wRW = bt.by((String)localMap.get(".ADInfo.adActionCardExt"), "");
    this.wRX = bt.by((String)localMap.get(".ADInfo.adActionLink"), "");
    this.wRY = bt.aGh((String)localMap.get(".ADInfo.adActionExt.adActionExtPOI.POIType"));
    this.wRZ = bt.by((String)localMap.get(".ADInfo.adActionExt.adActionExtPOI.POIId"), "");
    this.wSa = bt.by((String)localMap.get(".ADInfo.adActionExt.adActionExtPOI.POIName"), "");
    this.wSb = bt.by((String)localMap.get(".ADInfo.adActionExt.adActionExtPOI.POILink"), "");
    String str2 = bt.by((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.Wording"), "");
    this.wSc = bt.aGh((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.WordingType"));
    this.wSe = bt.by((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.WordingLink"), "");
    int i;
    label658:
    if (this.wSc == wRP)
    {
      String str3 = bt.by((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.WordingRepAndroid"), "");
      this.wSf.clear();
      i = 0;
      if (i == 0) {}
      for (str1 = bt.by((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.UserNameList.UserName"), "");; str1 = bt.by((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.UserNameList.UserName" + i), ""))
      {
        if (bt.isNullOrNil(str1)) {
          break label541;
        }
        this.wSf.add(str1);
        i += 1;
        break;
      }
      label541:
      if (str3.indexOf("%s") >= 0)
      {
        i = 1;
        int j = str3.indexOf("%");
        int k = str3.lastIndexOf("%");
        if ((bt.isNullOrNil(str3)) || (i == 0) || (j != k)) {
          break label765;
        }
        this.wSd = str3;
        label597:
        this.wSg = localMap.containsKey(".ADInfo.adCanvasInfo");
        this.wSi = ((String)localMap.get(".ADInfo.session_data.aid"));
        this.wSh = ((String)localMap.get(".ADInfo.session_data.trace_id"));
        this.wSk = new HashMap();
        i = 0;
        if (i != 0) {
          break label797;
        }
      }
    }
    label797:
    for (String str1 = ".ADInfo.adCanvasExt.adCardItemList.cardItem";; str1 = ".ADInfo.adCanvasExt.adCardItemList.cardItem" + i)
    {
      str2 = (String)localMap.get(str1 + ".cardTpId");
      str1 = (String)localMap.get(str1 + ".cardExt");
      if (bt.isNullOrNil(str2)) {
        break label822;
      }
      this.wSk.put(str2, str1);
      i += 1;
      break label658;
      i = 0;
      break;
      label765:
      this.wSd = str2;
      this.wSc = wRO;
      break label597;
      this.wSd = str2;
      this.wSc = wRO;
      break label597;
    }
    label822:
    paramString = Pattern.compile("<adCanvasExt>[\\s\\S]*</adCanvasExt>").matcher(paramString);
    if (paramString.find())
    {
      paramString = paramString.group();
      if (!bt.isNullOrNil(paramString)) {
        this.wSj = paramString.replaceAll("</?adCanvasExt>", "");
      }
    }
    paramString = (String)localMap.get(".ADInfo.adActionExt.adActionExtWeApp.appUserName");
    if (!TextUtils.isEmpty(paramString))
    {
      this.wSl = new b();
      this.wSl.dkB = paramString;
      this.wSl.appVersion = ((String)localMap.get(".ADInfo.adActionExt.adActionExtWeApp.appVersion"));
      this.wSl.dbu = ((String)localMap.get(".ADInfo.adActionExt.adActionExtWeApp.relativePagePath"));
    }
    this.wSm = new c(localMap, ".ADInfo");
    this.wSn = bt.by((String)localMap.get(".ADInfo.dislikeInfo.Title.zh"), "");
    this.wSp = bt.by((String)localMap.get(".ADInfo.dislikeInfo.Title.tw"), "");
    this.wSo = bt.by((String)localMap.get(".ADInfo.dislikeInfo.Title.en"), "");
    if (bt.aGh((String)localMap.get(".ADInfo.dislikeInfo.forbidClick")) > 0)
    {
      bool1 = true;
      this.wSq = bool1;
      this.wSr = bt.by((String)localMap.get(".ADInfo.adInfoSyncBuffer"), "");
      if (bt.aGh((String)localMap.get(".ADInfo.adInfoSyncBuffer.$imm")) != 1) {
        break label1373;
      }
    }
    label1373:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.wSs = bool1;
      this.wSt = new d(localMap);
      this.wSu = bt.nullAsNil((String)localMap.get(".ADInfo.waid.appWaid.pkg"));
      if (localMap.containsKey(".ADInfo.adActionExt.adActionSchemaJump"))
      {
        paramString = bt.by((String)localMap.get(".ADInfo.adActionExt.adActionSchemaJump" + ".packageName"), "");
        str1 = bt.by((String)localMap.get(".ADInfo.adActionExt.adActionSchemaJump" + ".openSdkAppIdAndroid"), "");
        if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str1)))
        {
          this.wSv = new a();
          this.wSv.IK = paramString;
          this.wSv.appId = str1;
          this.wSv.wSw = bt.by((String)localMap.get(".ADInfo.adActionExt.adActionSchemaJump" + ".appPageUrlAndroid"), "");
          this.wSv.appName = bt.by((String)localMap.get(".ADInfo.adActionExt.adActionSchemaJump" + ".appName"), "");
        }
      }
      AppMethodBeat.o(96261);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final boolean dvd()
  {
    return (this.wRT == 4) && (this.wSl != null);
  }
  
  public static final class a
  {
    public String IK;
    public String appId;
    public String appName;
    public String wSw;
    
    public final String toString()
    {
      AppMethodBeat.i(187334);
      String str = "appId=" + this.appId + ", pkg=" + this.IK + ", appName=" + this.appName + ", pageUrl=" + this.wSw;
      AppMethodBeat.o(187334);
      return str;
    }
  }
  
  public static final class b
  {
    public String appVersion;
    public String dbu;
    public String dkB;
  }
  
  public static final class c
  {
    private List<a> wSx;
    public Map<String, List<a>> wSy;
    
    public c()
    {
      AppMethodBeat.i(96252);
      this.wSx = new ArrayList();
      this.wSy = new HashMap();
      AppMethodBeat.o(96252);
    }
    
    public c(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(96253);
      this.wSx = new ArrayList();
      this.wSy = new HashMap();
      String str = paramString + ".dislikeInfo.ReasonList";
      int i = 0;
      paramString = str + ".Reason";
      if (i > 0) {
        paramString = paramString + i;
      }
      for (;;)
      {
        if (paramMap.get(paramString + ".ReasonId") != null)
        {
          this.wSx.add(new a(bt.by((String)paramMap.get(paramString + ".Wording.zh"), ""), bt.by((String)paramMap.get(paramString + ".Wording.tw"), ""), bt.by((String)paramMap.get(paramString + ".Wording.en"), ""), bt.aGh((String)paramMap.get(paramString + ".ReasonId"))));
          i += 1;
          break;
        }
        AppMethodBeat.o(96253);
        return;
      }
    }
    
    public final List<a> dve()
    {
      AppMethodBeat.i(96251);
      Object localObject = ac.ir(aj.getContext());
      if ((!"zh_CN".equals(localObject)) && (!"zh_TW".equals(localObject)) && (!"zh_HK".equals(localObject))) {
        localObject = "en";
      }
      for (;;)
      {
        if (!this.wSy.containsKey(localObject))
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = this.wSx.iterator();
          while (localIterator.hasNext())
          {
            a locala = (a)localIterator.next();
            if (("zh_CN".equals(localObject)) && (!bt.isNullOrNil(locala.wSA))) {
              localArrayList.add(locala);
            } else if ((("zh_TW".equals(localObject)) || ("zh_HK".equals(localObject))) && (!bt.isNullOrNil(locala.wSB))) {
              localArrayList.add(locala);
            } else if (("en".equals(localObject)) && (!bt.isNullOrNil(locala.wSC))) {
              localArrayList.add(locala);
            }
          }
          this.wSy.put(localObject, localArrayList);
        }
        localObject = (List)this.wSy.get(localObject);
        AppMethodBeat.o(96251);
        return localObject;
      }
    }
    
    public final boolean dvf()
    {
      AppMethodBeat.i(187335);
      if (dve().size() > 0)
      {
        AppMethodBeat.o(187335);
        return true;
      }
      AppMethodBeat.o(187335);
      return false;
    }
    
    public static final class a
    {
      public static int wSz = 101;
      public long wAf = 0L;
      public String wSA = "";
      public String wSB = "";
      public String wSC = "";
      public int wSD = 0;
      public long wSE = 0L;
      
      public a() {}
      
      public a(String paramString1, String paramString2, String paramString3, int paramInt)
      {
        this.wSA = paramString1;
        this.wSB = paramString2;
        this.wSC = paramString3;
        this.wSD = paramInt;
      }
    }
  }
  
  public static final class d
  {
    public ArrayList<a.e> wSF;
    
    public d()
    {
      AppMethodBeat.i(96255);
      this.wSF = new ArrayList();
      AppMethodBeat.o(96255);
    }
    
    public d(Map<String, String> paramMap)
    {
      AppMethodBeat.i(96254);
      this.wSF = new ArrayList();
      int i = 0;
      for (;;)
      {
        String str;
        a.e locale;
        int j;
        if (i == 0)
        {
          localObject = ".ADInfo.adActionExt.adVoteInfoExt.voteItemList.voteResultInfo";
          str = bt.by((String)paramMap.get((String)localObject + ".id"), "");
          if (TextUtils.isEmpty(str)) {
            break;
          }
          locale = new a.e();
          locale.id = str;
          locale.wSG = bt.aGh((String)paramMap.get((String)localObject + ".scoring"));
          locale.wSH = bt.aGh((String)paramMap.get((String)localObject + ".friends"));
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
          localObject = bt.by((String)paramMap.get(localObject), "");
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label288;
          }
          locale.wSI.add(localObject);
          j += 1;
          break label188;
          localObject = ".ADInfo.adActionExt.adVoteInfoExt.voteItemList.voteResultInfo" + i;
          break;
        }
        label288:
        this.wSF.add(locale);
        i += 1;
      }
      AppMethodBeat.o(96254);
    }
    
    private a.e apr(String paramString)
    {
      AppMethodBeat.i(96257);
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(96257);
        return null;
      }
      Iterator localIterator = this.wSF.iterator();
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
    
    public final int iO(String paramString1, String paramString2)
    {
      int j = 0;
      AppMethodBeat.i(96256);
      paramString1 = apr(paramString1);
      paramString2 = apr(paramString2);
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
        i = paramString1.wSG;
        break;
        label62:
        j = paramString2.wSG;
      }
      label71:
      AppMethodBeat.o(96256);
      return 50;
    }
  }
  
  public static final class e
  {
    public String id;
    public int wSG;
    public int wSH;
    public ArrayList<String> wSI;
    
    public e()
    {
      AppMethodBeat.i(96258);
      this.wSI = new ArrayList();
      AppMethodBeat.o(96258);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.a
 * JD-Core Version:    0.7.0.1
 */