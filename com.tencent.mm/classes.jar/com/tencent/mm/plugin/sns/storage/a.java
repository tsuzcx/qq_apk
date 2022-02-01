package com.tencent.mm.plugin.sns.storage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
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
  public static int yeu = 0;
  public static int yev = 1;
  public String dqf;
  public String dtx;
  public String dyy;
  public String yeA;
  public String yeB;
  public String yeC;
  public String yeD;
  public int yeE;
  public String yeF;
  public String yeG;
  public String yeH;
  public int yeI;
  public String yeJ;
  public String yeK;
  public LinkedList<String> yeL;
  boolean yeM;
  public String yeN;
  public String yeO;
  public String yeP;
  public HashMap<String, String> yeQ;
  public b yeR;
  public c yeS;
  public String yeT;
  public String yeU;
  public String yeV;
  public boolean yeW;
  public String yeX;
  public boolean yeY;
  public d yeZ;
  public int yew;
  public long yex;
  public long yey;
  public int yez;
  public String yfa;
  public a yfb;
  
  public a()
  {
    AppMethodBeat.i(96259);
    this.dqf = "";
    this.dtx = "";
    this.yez = 0;
    this.yeA = "";
    this.yeB = "";
    this.yeC = "";
    this.yeD = "";
    this.yeE = 0;
    this.yeF = "";
    this.yeG = "";
    this.yeH = "";
    this.yeI = yeu;
    this.yeJ = "";
    this.yeK = "";
    this.yeL = new LinkedList();
    this.yeP = "";
    this.yeS = new c();
    this.yeT = "";
    this.yeU = "";
    this.yeV = "";
    this.yeW = false;
    this.yeX = "";
    this.yeY = false;
    AppMethodBeat.o(96259);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(96260);
    this.dqf = "";
    this.dtx = "";
    this.yez = 0;
    this.yeA = "";
    this.yeB = "";
    this.yeC = "";
    this.yeD = "";
    this.yeE = 0;
    this.yeF = "";
    this.yeG = "";
    this.yeH = "";
    this.yeI = yeu;
    this.yeJ = "";
    this.yeK = "";
    this.yeL = new LinkedList();
    this.yeP = "";
    this.yeS = new c();
    this.yeT = "";
    this.yeU = "";
    this.yeV = "";
    this.yeW = false;
    this.yeX = "";
    this.yeY = false;
    this.yeM = false;
    auB(paramString);
    AppMethodBeat.o(96260);
  }
  
  private void auB(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(96261);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(96261);
      return;
    }
    ac.i("MicroMsg.ADInfo", "feed xml %s", new Object[] { paramString });
    Map localMap = bv.L(paramString, "ADInfo");
    if (localMap == null)
    {
      AppMethodBeat.o(96261);
      return;
    }
    this.dyy = bs.bG((String)localMap.get(".ADInfo.viewid"), "");
    if (localMap.get(".ADInfo.ad_sns_pos") == null)
    {
      AppMethodBeat.o(96261);
      return;
    }
    this.yew = bs.aLy((String)localMap.get(".ADInfo.ad_sns_pos"));
    this.yex = bs.aLz((String)localMap.get(".ADInfo.noExposureExpireTime"));
    this.yey = bs.aLz((String)localMap.get(".ADInfo.exposureNoActionExpireTime"));
    this.dtx = bs.bG((String)localMap.get(".ADInfo.uxInfo"), "");
    this.yez = bs.aLy((String)localMap.get(".ADInfo.adActionType"));
    this.yeA = bs.bG((String)localMap.get(".ADInfo.adActionCardTitle"), "");
    this.yeB = bs.bG((String)localMap.get(".ADInfo.adActionCardTpId"), "");
    this.yeC = bs.bG((String)localMap.get(".ADInfo.adActionCardExt"), "");
    this.yeD = bs.bG((String)localMap.get(".ADInfo.adActionLink"), "");
    this.yeE = bs.aLy((String)localMap.get(".ADInfo.adActionExt.adActionExtPOI.POIType"));
    this.yeF = bs.bG((String)localMap.get(".ADInfo.adActionExt.adActionExtPOI.POIId"), "");
    this.yeG = bs.bG((String)localMap.get(".ADInfo.adActionExt.adActionExtPOI.POIName"), "");
    this.yeH = bs.bG((String)localMap.get(".ADInfo.adActionExt.adActionExtPOI.POILink"), "");
    String str2 = bs.bG((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.Wording"), "");
    this.yeI = bs.aLy((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.WordingType"));
    this.yeK = bs.bG((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.WordingLink"), "");
    int i;
    label658:
    if (this.yeI == yev)
    {
      String str3 = bs.bG((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.WordingRepAndroid"), "");
      this.yeL.clear();
      i = 0;
      if (i == 0) {}
      for (str1 = bs.bG((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.UserNameList.UserName"), "");; str1 = bs.bG((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.UserNameList.UserName" + i), ""))
      {
        if (bs.isNullOrNil(str1)) {
          break label541;
        }
        this.yeL.add(str1);
        i += 1;
        break;
      }
      label541:
      if (str3.indexOf("%s") >= 0)
      {
        i = 1;
        int j = str3.indexOf("%");
        int k = str3.lastIndexOf("%");
        if ((bs.isNullOrNil(str3)) || (i == 0) || (j != k)) {
          break label765;
        }
        this.yeJ = str3;
        label597:
        this.yeM = localMap.containsKey(".ADInfo.adCanvasInfo");
        this.yeO = ((String)localMap.get(".ADInfo.session_data.aid"));
        this.yeN = ((String)localMap.get(".ADInfo.session_data.trace_id"));
        this.yeQ = new HashMap();
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
      if (bs.isNullOrNil(str2)) {
        break label822;
      }
      this.yeQ.put(str2, str1);
      i += 1;
      break label658;
      i = 0;
      break;
      label765:
      this.yeJ = str2;
      this.yeI = yeu;
      break label597;
      this.yeJ = str2;
      this.yeI = yeu;
      break label597;
    }
    label822:
    paramString = Pattern.compile("<adCanvasExt>[\\s\\S]*</adCanvasExt>").matcher(paramString);
    if (paramString.find())
    {
      paramString = paramString.group();
      if (!bs.isNullOrNil(paramString)) {
        this.yeP = paramString.replaceAll("</?adCanvasExt>", "");
      }
    }
    paramString = (String)localMap.get(".ADInfo.adActionExt.adActionExtWeApp.appUserName");
    if (!TextUtils.isEmpty(paramString))
    {
      this.yeR = new b();
      this.yeR.dia = paramString;
      this.yeR.appVersion = ((String)localMap.get(".ADInfo.adActionExt.adActionExtWeApp.appVersion"));
      this.yeR.cYQ = ((String)localMap.get(".ADInfo.adActionExt.adActionExtWeApp.relativePagePath"));
    }
    this.yeS = new c(localMap, ".ADInfo");
    this.yeT = bs.bG((String)localMap.get(".ADInfo.dislikeInfo.Title.zh"), "");
    this.yeV = bs.bG((String)localMap.get(".ADInfo.dislikeInfo.Title.tw"), "");
    this.yeU = bs.bG((String)localMap.get(".ADInfo.dislikeInfo.Title.en"), "");
    if (bs.aLy((String)localMap.get(".ADInfo.dislikeInfo.forbidClick")) > 0)
    {
      bool1 = true;
      this.yeW = bool1;
      this.yeX = bs.bG((String)localMap.get(".ADInfo.adInfoSyncBuffer"), "");
      if (bs.aLy((String)localMap.get(".ADInfo.adInfoSyncBuffer.$imm")) != 1) {
        break label1373;
      }
    }
    label1373:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.yeY = bool1;
      this.yeZ = new d(localMap);
      this.yfa = bs.nullAsNil((String)localMap.get(".ADInfo.waid.appWaid.pkg"));
      if (localMap.containsKey(".ADInfo.adActionExt.adActionSchemaJump"))
      {
        paramString = bs.bG((String)localMap.get(".ADInfo.adActionExt.adActionSchemaJump" + ".packageName"), "");
        str1 = bs.bG((String)localMap.get(".ADInfo.adActionExt.adActionSchemaJump" + ".openSdkAppIdAndroid"), "");
        if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str1)))
        {
          this.yfb = new a();
          this.yfb.JG = paramString;
          this.yfb.appId = str1;
          this.yfb.yfc = bs.bG((String)localMap.get(".ADInfo.adActionExt.adActionSchemaJump" + ".appPageUrlAndroid"), "");
          this.yfb.appName = bs.bG((String)localMap.get(".ADInfo.adActionExt.adActionSchemaJump" + ".appName"), "");
        }
      }
      AppMethodBeat.o(96261);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final boolean dJC()
  {
    return (this.yez == 4) && (this.yeR != null);
  }
  
  public static final class a
  {
    public String JG;
    public String appId;
    public String appName;
    public String yfc;
    
    public final String toString()
    {
      AppMethodBeat.i(200130);
      String str = "appId=" + this.appId + ", pkg=" + this.JG + ", appName=" + this.appName + ", pageUrl=" + this.yfc;
      AppMethodBeat.o(200130);
      return str;
    }
  }
  
  public static final class b
  {
    public String appVersion;
    public String cYQ;
    public String dia;
  }
  
  public static final class c
  {
    public int yfd;
    private List<a> yfe;
    public Map<String, List<a>> yff;
    public String yfg;
    public String yfh;
    public String yfi;
    
    public c()
    {
      AppMethodBeat.i(96252);
      this.yfd = 0;
      this.yfe = new ArrayList();
      this.yff = new HashMap();
      this.yfg = "";
      this.yfh = "";
      this.yfi = "";
      AppMethodBeat.o(96252);
    }
    
    public c(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(96253);
      this.yfd = 0;
      this.yfe = new ArrayList();
      this.yff = new HashMap();
      this.yfg = "";
      this.yfh = "";
      this.yfi = "";
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
          this.yfe.add(new a(bs.bG((String)paramMap.get(str1 + ".Wording.zh"), ""), bs.bG((String)paramMap.get(str1 + ".Wording.tw"), ""), bs.bG((String)paramMap.get(str1 + ".Wording.en"), ""), bs.aLy((String)paramMap.get(str1 + ".ReasonId"))));
          i += 1;
          break;
        }
        this.yfd = bs.aLy((String)paramMap.get(paramString + ".dislikeInfo.unReceiveAdInterval"));
        this.yfg = bs.bG((String)paramMap.get(paramString + ".dislikeInfo.forbidClickReason.zh"), "");
        this.yfh = bs.bG((String)paramMap.get(paramString + ".dislikeInfo.forbidClickReason.tw"), "");
        this.yfi = bs.bG((String)paramMap.get(paramString + ".dislikeInfo.forbidClickReason.en"), "");
        AppMethodBeat.o(96253);
        return;
      }
    }
    
    public final List<a> dJD()
    {
      AppMethodBeat.i(96251);
      Object localObject = ab.iC(ai.getContext());
      if ((!"zh_CN".equals(localObject)) && (!"zh_TW".equals(localObject)) && (!"zh_HK".equals(localObject))) {
        localObject = "en";
      }
      for (;;)
      {
        if (!this.yff.containsKey(localObject))
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = this.yfe.iterator();
          while (localIterator.hasNext())
          {
            a locala = (a)localIterator.next();
            if (("zh_CN".equals(localObject)) && (!bs.isNullOrNil(locala.yfk))) {
              localArrayList.add(locala);
            } else if ((("zh_TW".equals(localObject)) || ("zh_HK".equals(localObject))) && (!bs.isNullOrNil(locala.yfl))) {
              localArrayList.add(locala);
            } else if (("en".equals(localObject)) && (!bs.isNullOrNil(locala.yfm))) {
              localArrayList.add(locala);
            }
          }
          this.yff.put(localObject, localArrayList);
        }
        localObject = (List)this.yff.get(localObject);
        AppMethodBeat.o(96251);
        return localObject;
      }
    }
    
    public final boolean dJE()
    {
      AppMethodBeat.i(200131);
      if (dJD().size() > 0)
      {
        AppMethodBeat.o(200131);
        return true;
      }
      AppMethodBeat.o(200131);
      return false;
    }
    
    public static final class a
    {
      public static int yfj = 101;
      public long xMz = 0L;
      public String yfk = "";
      public String yfl = "";
      public String yfm = "";
      public int yfn = 0;
      public long yfo = 0L;
      
      public a() {}
      
      public a(String paramString1, String paramString2, String paramString3, int paramInt)
      {
        this.yfk = paramString1;
        this.yfl = paramString2;
        this.yfm = paramString3;
        this.yfn = paramInt;
      }
    }
  }
  
  public static final class d
  {
    public ArrayList<a.e> yfp;
    
    public d()
    {
      AppMethodBeat.i(96255);
      this.yfp = new ArrayList();
      AppMethodBeat.o(96255);
    }
    
    public d(Map<String, String> paramMap)
    {
      AppMethodBeat.i(96254);
      this.yfp = new ArrayList();
      int i = 0;
      for (;;)
      {
        String str;
        a.e locale;
        int j;
        if (i == 0)
        {
          localObject = ".ADInfo.adActionExt.adVoteInfoExt.voteItemList.voteResultInfo";
          str = bs.bG((String)paramMap.get((String)localObject + ".id"), "");
          if (TextUtils.isEmpty(str)) {
            break;
          }
          locale = new a.e();
          locale.id = str;
          locale.yfq = bs.aLy((String)paramMap.get((String)localObject + ".scoring"));
          locale.yfr = bs.aLy((String)paramMap.get((String)localObject + ".friends"));
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
          localObject = bs.bG((String)paramMap.get(localObject), "");
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label288;
          }
          locale.yfs.add(localObject);
          j += 1;
          break label188;
          localObject = ".ADInfo.adActionExt.adVoteInfoExt.voteItemList.voteResultInfo" + i;
          break;
        }
        label288:
        this.yfp.add(locale);
        i += 1;
      }
      AppMethodBeat.o(96254);
    }
    
    private a.e auC(String paramString)
    {
      AppMethodBeat.i(96257);
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(96257);
        return null;
      }
      Iterator localIterator = this.yfp.iterator();
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
    
    public final int jl(String paramString1, String paramString2)
    {
      int j = 0;
      AppMethodBeat.i(96256);
      paramString1 = auC(paramString1);
      paramString2 = auC(paramString2);
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
        i = paramString1.yfq;
        break;
        label62:
        j = paramString2.yfq;
      }
      label71:
      AppMethodBeat.o(96256);
      return 50;
    }
  }
  
  public static final class e
  {
    public String id;
    public int yfq;
    public int yfr;
    public ArrayList<String> yfs;
    
    public e()
    {
      AppMethodBeat.i(96258);
      this.yfs = new ArrayList();
      AppMethodBeat.o(96258);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.a
 * JD-Core Version:    0.7.0.1
 */