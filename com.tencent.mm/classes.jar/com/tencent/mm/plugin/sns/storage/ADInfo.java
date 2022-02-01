package com.tencent.mm.plugin.sns.storage;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Keep
public class ADInfo
{
  public static int ADChainStrengthenDefaultWording = 0;
  public static int ADChainStrengthenUserInfoFormatWording = 0;
  public static final int AD_ACTION_TYPE_FINDER = 9;
  public static final int AD_ACTION_TYPE_FINDER_FEEDS = 12;
  public static final int AD_ACTION_TYPE_FINDER_LIVE = 10;
  public static final int AD_ACTION_TYPE_FINDER_TOPIC = 11;
  public static final int AD_ACTION_TYPE_SCAN = 8;
  public static final int AD_ACTION_TYPE_WEAPP = 4;
  public static final String TAG = "MicroMsg.ADInfo";
  private static HashMap<String, String> waidPkgCache;
  public a actionExtAppJump;
  public b actionExtWeApp;
  public String adActionCardExt;
  public String adActionCardTitle;
  public String adActionCardTpId;
  public String adActionExtTailFormattedWording;
  public String adActionExtTailLink;
  public int adActionExtTailType;
  public String adActionExtTailUserDisplayName;
  public String adActionExtTailWording;
  public LinkedList<String> adActionExtUserList;
  public String adActionLink;
  public String adActionPOIId;
  public String adActionPOILink;
  public String adActionPOIName;
  public int adActionPOIType;
  public int adActionType;
  public String adCanvasExtXml;
  public int adChainType;
  public int adChainTypeExpireTime;
  public String adDislikeInfoTitle_cn;
  public String adDislikeInfoTitle_en;
  public String adDislikeInfoTitle_tw;
  public int adDupSnsIdDel;
  public String adExtTailWording;
  public int adExtTailWordingExchangeValue;
  public String adInfoSyncBuffer;
  public boolean adInfoSyncBufferImm;
  public c adUnlikeInfo;
  public d adVoteInfoExt;
  public int ad_sns_pos;
  public String aid;
  boolean bLandingPagesAd;
  public int contractAdEndTime;
  public long exposureNoActionExpireTime;
  public boolean forbidClick;
  public HashMap<String, String> mappedCanvasCardExt;
  public long noExposureExpireTime;
  public String pId;
  public String traceid;
  public String uxInfo;
  public String viewId;
  public String waidPkg;
  public String xml;
  
  static
  {
    AppMethodBeat.i(263159);
    waidPkgCache = new HashMap();
    ADChainStrengthenDefaultWording = 0;
    ADChainStrengthenUserInfoFormatWording = 1;
    AppMethodBeat.o(263159);
  }
  
  public ADInfo()
  {
    AppMethodBeat.i(96259);
    this.xml = "";
    this.uxInfo = "";
    this.adActionType = 0;
    this.adActionCardTitle = "";
    this.adActionCardTpId = "";
    this.adActionCardExt = "";
    this.adActionLink = "";
    this.adActionPOIType = 0;
    this.adActionPOIId = "";
    this.adActionPOIName = "";
    this.adActionPOILink = "";
    this.adActionExtTailType = ADChainStrengthenDefaultWording;
    this.adActionExtTailWording = "";
    this.adActionExtTailLink = "";
    this.adActionExtUserList = new LinkedList();
    this.adCanvasExtXml = "";
    this.adUnlikeInfo = new c();
    this.adDislikeInfoTitle_cn = "";
    this.adDislikeInfoTitle_en = "";
    this.adDislikeInfoTitle_tw = "";
    this.forbidClick = false;
    this.adInfoSyncBuffer = "";
    this.adInfoSyncBufferImm = false;
    this.pId = "";
    AppMethodBeat.o(96259);
  }
  
  public ADInfo(String paramString)
  {
    AppMethodBeat.i(96260);
    this.xml = "";
    this.uxInfo = "";
    this.adActionType = 0;
    this.adActionCardTitle = "";
    this.adActionCardTpId = "";
    this.adActionCardExt = "";
    this.adActionLink = "";
    this.adActionPOIType = 0;
    this.adActionPOIId = "";
    this.adActionPOIName = "";
    this.adActionPOILink = "";
    this.adActionExtTailType = ADChainStrengthenDefaultWording;
    this.adActionExtTailWording = "";
    this.adActionExtTailLink = "";
    this.adActionExtUserList = new LinkedList();
    this.adCanvasExtXml = "";
    this.adUnlikeInfo = new c();
    this.adDislikeInfoTitle_cn = "";
    this.adDislikeInfoTitle_en = "";
    this.adDislikeInfoTitle_tw = "";
    this.forbidClick = false;
    this.adInfoSyncBuffer = "";
    this.adInfoSyncBufferImm = false;
    this.pId = "";
    this.bLandingPagesAd = false;
    feed(paramString);
    AppMethodBeat.o(96260);
  }
  
  private void feed(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(96261);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(96261);
      return;
    }
    Log.i("MicroMsg.ADInfo", "feed xml %s", new Object[] { paramString });
    Map localMap = XmlParser.parseXml(paramString, "ADInfo", null);
    if (localMap == null)
    {
      AppMethodBeat.o(96261);
      return;
    }
    this.viewId = Util.nullAs((String)localMap.get(".ADInfo.viewid"), "");
    if (localMap.get(".ADInfo.ad_sns_pos") == null)
    {
      AppMethodBeat.o(96261);
      return;
    }
    this.ad_sns_pos = Util.safeParseInt((String)localMap.get(".ADInfo.ad_sns_pos"));
    this.noExposureExpireTime = Util.safeParseLong((String)localMap.get(".ADInfo.noExposureExpireTime"));
    this.exposureNoActionExpireTime = Util.safeParseLong((String)localMap.get(".ADInfo.exposureNoActionExpireTime"));
    this.uxInfo = Util.nullAs((String)localMap.get(".ADInfo.uxInfo"), "");
    this.adActionType = Util.safeParseInt((String)localMap.get(".ADInfo.adActionType"));
    this.adActionCardTitle = Util.nullAs((String)localMap.get(".ADInfo.adActionCardTitle"), "");
    this.adActionCardTpId = Util.nullAs((String)localMap.get(".ADInfo.adActionCardTpId"), "");
    this.adActionCardExt = Util.nullAs((String)localMap.get(".ADInfo.adActionCardExt"), "");
    this.adActionLink = Util.nullAs((String)localMap.get(".ADInfo.adActionLink"), "");
    this.adActionPOIType = Util.safeParseInt((String)localMap.get(".ADInfo.adActionExt.adActionExtPOI.POIType"));
    this.adActionPOIId = Util.nullAs((String)localMap.get(".ADInfo.adActionExt.adActionExtPOI.POIId"), "");
    this.adActionPOIName = Util.nullAs((String)localMap.get(".ADInfo.adActionExt.adActionExtPOI.POIName"), "");
    this.adActionPOILink = Util.nullAs((String)localMap.get(".ADInfo.adActionExt.adActionExtPOI.POILink"), "");
    this.adChainType = Util.safeParseInt((String)localMap.get(".ADInfo.adActionExt.adChainType"));
    this.adChainTypeExpireTime = Util.safeParseInt((String)localMap.get(".ADInfo.adActionExt.adChainTypeExpireTime"));
    this.adExtTailWording = Util.nullAs((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.WordingComplexString"), "");
    this.adExtTailWordingExchangeValue = Util.safeParseInt((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.WordingComplexExchangeValue"));
    String str1 = Util.nullAs((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.Wording"), "");
    this.adActionExtTailType = Util.safeParseInt((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.WordingType"));
    this.adActionExtTailLink = Util.nullAs((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.WordingLink"), "");
    int i;
    label690:
    label751:
    if (this.adActionExtTailType == ADChainStrengthenUserInfoFormatWording)
    {
      String str2 = Util.nullAs((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.WordingRepAndroid"), "");
      this.adActionExtUserList.clear();
      i = 0;
      if (i == 0) {}
      for (??? = Util.nullAs((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.UserNameList.UserName"), "");; ??? = Util.nullAs((String)localMap.get(".ADInfo.adActionExt.adChainStrengthen.UserNameList.UserName" + i), ""))
      {
        if (Util.isNullOrNil((String)???)) {
          break label634;
        }
        this.adActionExtUserList.add(???);
        i += 1;
        break;
      }
      label634:
      if (str2.indexOf("%s") >= 0)
      {
        i = 1;
        int j = str2.indexOf("%");
        int k = str2.lastIndexOf("%");
        if ((Util.isNullOrNil(str2)) || (i == 0) || (j != k)) {
          break label858;
        }
        this.adActionExtTailWording = str2;
        this.bLandingPagesAd = localMap.containsKey(".ADInfo.adCanvasInfo");
        this.aid = ((String)localMap.get(".ADInfo.session_data.aid"));
        this.traceid = ((String)localMap.get(".ADInfo.session_data.trace_id"));
        this.mappedCanvasCardExt = new HashMap();
        i = 0;
        if (i != 0) {
          break label890;
        }
      }
    }
    label858:
    label890:
    for (??? = ".ADInfo.adCanvasExt.adCardItemList.cardItem";; ??? = ".ADInfo.adCanvasExt.adCardItemList.cardItem" + i)
    {
      str1 = (String)localMap.get((String)??? + ".cardTpId");
      ??? = (String)localMap.get((String)??? + ".cardExt");
      if (Util.isNullOrNil(str1)) {
        break label915;
      }
      this.mappedCanvasCardExt.put(str1, ???);
      i += 1;
      break label751;
      i = 0;
      break;
      this.adActionExtTailWording = str1;
      this.adActionExtTailType = ADChainStrengthenDefaultWording;
      break label690;
      this.adActionExtTailWording = str1;
      this.adActionExtTailType = ADChainStrengthenDefaultWording;
      break label690;
    }
    label915:
    paramString = Pattern.compile("<adCanvasExt>[\\s\\S]*</adCanvasExt>").matcher(paramString);
    if (paramString.find())
    {
      paramString = paramString.group();
      if (!Util.isNullOrNil(paramString)) {
        this.adCanvasExtXml = paramString.replaceAll("</?adCanvasExt>", "");
      }
    }
    paramString = (String)localMap.get(".ADInfo.adActionExt.adActionExtWeApp.appUserName");
    if (!TextUtils.isEmpty(paramString))
    {
      this.actionExtWeApp = new b();
      this.actionExtWeApp.appUserName = paramString;
      this.actionExtWeApp.appVersion = ((String)localMap.get(".ADInfo.adActionExt.adActionExtWeApp.appVersion"));
      this.actionExtWeApp.fve = ((String)localMap.get(".ADInfo.adActionExt.adActionExtWeApp.relativePagePath"));
      this.actionExtWeApp.Jxz = Util.safeParseInt((String)localMap.get(".ADInfo.adActionExt.adActionExtWeApp.miniProgramType"));
    }
    this.adUnlikeInfo = new c(localMap, ".ADInfo");
    this.adDislikeInfoTitle_cn = Util.nullAs((String)localMap.get(".ADInfo.dislikeInfo.Title.zh"), "");
    this.adDislikeInfoTitle_tw = Util.nullAs((String)localMap.get(".ADInfo.dislikeInfo.Title.tw"), "");
    this.adDislikeInfoTitle_en = Util.nullAs((String)localMap.get(".ADInfo.dislikeInfo.Title.en"), "");
    boolean bool1;
    if (Util.safeParseInt((String)localMap.get(".ADInfo.dislikeInfo.forbidClick")) > 0) {
      bool1 = true;
    }
    for (;;)
    {
      this.forbidClick = bool1;
      this.adInfoSyncBuffer = Util.nullAs((String)localMap.get(".ADInfo.adInfoSyncBuffer"), "");
      if (Util.safeParseInt((String)localMap.get(".ADInfo.adInfoSyncBuffer.$imm")) == 1)
      {
        bool1 = bool2;
        this.adInfoSyncBufferImm = bool1;
        this.adVoteInfoExt = new d(localMap);
        this.waidPkg = Util.nullAsNil((String)localMap.get(".ADInfo.appWaid.pkg"));
        ??? = m.aYT(this.uxInfo);
        paramString = (String)???;
        if (TextUtils.isEmpty((CharSequence)???))
        {
          Log.w("MicroMsg.ADInfo", "aid from uxinfo is empty, uxinfo=" + this.uxInfo + ", aid=" + this.aid);
          paramString = this.aid;
        }
      }
      synchronized (waidPkgCache)
      {
        if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.waidPkg)))
        {
          Log.i("MicroMsg.ADInfo", "cache waidPkg, key=" + paramString + ", value=" + this.waidPkg);
          waidPkgCache.put(paramString, this.waidPkg);
        }
        if (localMap.containsKey(".ADInfo.adActionExt.adActionSchemaJump"))
        {
          paramString = Util.nullAs((String)localMap.get(".ADInfo.adActionExt.adActionSchemaJump" + ".packageName"), "");
          ??? = Util.nullAs((String)localMap.get(".ADInfo.adActionExt.adActionSchemaJump" + ".openSdkAppIdAndroid"), "");
          if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty((CharSequence)???)))
          {
            this.actionExtAppJump = new a();
            this.actionExtAppJump.abY = paramString;
            this.actionExtAppJump.appId = ((String)???);
            this.actionExtAppJump.JxO = Util.nullAs((String)localMap.get(".ADInfo.adActionExt.adActionSchemaJump" + ".appPageUrlAndroid"), "");
            this.actionExtAppJump.appName = Util.nullAs((String)localMap.get(".ADInfo.adActionExt.adActionSchemaJump" + ".appName"), "");
          }
        }
        this.contractAdEndTime = Util.safeParseInt((String)localMap.get(".ADInfo.adGroupEndTime"));
        this.adDupSnsIdDel = Util.safeParseInt((String)localMap.get(".ADInfo.adDupSnsIdDel"));
        this.pId = Util.nullAsNil(m.aYZ(this.uxInfo));
        AppMethodBeat.o(96261);
        return;
        bool1 = false;
        continue;
        bool1 = false;
      }
    }
  }
  
  public static String getWaidPkgByUxInfo(String paramString)
  {
    AppMethodBeat.i(263158);
    ??? = "";
    String str = m.aYT(paramString);
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      synchronized (waidPkgCache)
      {
        paramString = Util.nullAsNil((String)waidPkgCache.get(str));
        AppMethodBeat.o(263158);
        return paramString;
      }
      Log.e("MicroMsg.ADInfo", "getWaidPkgByUxInfo, aid is empty, uxinfo=".concat(String.valueOf(paramString)));
      paramString = (String)???;
    }
  }
  
  public boolean isWeApp(AdClickActionInfo paramAdClickActionInfo)
  {
    AppMethodBeat.i(263154);
    if (paramAdClickActionInfo == null)
    {
      AppMethodBeat.o(263154);
      return false;
    }
    if ((paramAdClickActionInfo.Jxx == 4) && (!Util.isNullOrNil(paramAdClickActionInfo.uMJ)))
    {
      AppMethodBeat.o(263154);
      return true;
    }
    AppMethodBeat.o(263154);
    return false;
  }
  
  public boolean isWeapp()
  {
    return (this.adActionType == 4) && (this.actionExtWeApp != null);
  }
  
  public static class a
  {
    public String JxO;
    public String abY;
    public String appId;
    public String appName;
    
    public String toString()
    {
      AppMethodBeat.i(196980);
      String str = "appId=" + this.appId + ", pkg=" + this.abY + ", appName=" + this.appName + ", pageUrl=" + this.JxO;
      AppMethodBeat.o(196980);
      return str;
    }
  }
  
  public static class b
  {
    public int Jxz;
    public String appUserName;
    public String appVersion;
    public String fve;
  }
  
  public static class c
  {
    public int Kjd;
    private List<a> Kje;
    public Map<String, List<a>> Kjf;
    public String Kjg;
    public String Kjh;
    public String Kji;
    
    public c()
    {
      AppMethodBeat.i(96252);
      this.Kjd = 0;
      this.Kje = new ArrayList();
      this.Kjf = new HashMap();
      this.Kjg = "";
      this.Kjh = "";
      this.Kji = "";
      AppMethodBeat.o(96252);
    }
    
    public c(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(96253);
      this.Kjd = 0;
      this.Kje = new ArrayList();
      this.Kjf = new HashMap();
      this.Kjg = "";
      this.Kjh = "";
      this.Kji = "";
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
          this.Kje.add(new a(Util.nullAs((String)paramMap.get(str1 + ".Wording.zh"), ""), Util.nullAs((String)paramMap.get(str1 + ".Wording.tw"), ""), Util.nullAs((String)paramMap.get(str1 + ".Wording.en"), ""), Util.safeParseInt((String)paramMap.get(str1 + ".ReasonId"))));
          i += 1;
          break;
        }
        this.Kjd = Util.safeParseInt((String)paramMap.get(paramString + ".dislikeInfo.unReceiveAdInterval"));
        this.Kjg = Util.nullAs((String)paramMap.get(paramString + ".dislikeInfo.forbidClickReason.zh"), "");
        this.Kjh = Util.nullAs((String)paramMap.get(paramString + ".dislikeInfo.forbidClickReason.tw"), "");
        this.Kji = Util.nullAs((String)paramMap.get(paramString + ".dislikeInfo.forbidClickReason.en"), "");
        AppMethodBeat.o(96253);
        return;
      }
    }
    
    public final List<a> fQA()
    {
      AppMethodBeat.i(96251);
      Object localObject = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
      if ((!"zh_CN".equals(localObject)) && (!"zh_TW".equals(localObject)) && (!"zh_HK".equals(localObject))) {
        localObject = "en";
      }
      for (;;)
      {
        if (!this.Kjf.containsKey(localObject))
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = this.Kje.iterator();
          while (localIterator.hasNext())
          {
            a locala = (a)localIterator.next();
            if (("zh_CN".equals(localObject)) && (!Util.isNullOrNil(locala.Kjk))) {
              localArrayList.add(locala);
            } else if ((("zh_TW".equals(localObject)) || ("zh_HK".equals(localObject))) && (!Util.isNullOrNil(locala.Kjl))) {
              localArrayList.add(locala);
            } else if (("en".equals(localObject)) && (!Util.isNullOrNil(locala.Kjm))) {
              localArrayList.add(locala);
            }
          }
          this.Kjf.put(localObject, localArrayList);
        }
        localObject = (List)this.Kjf.get(localObject);
        AppMethodBeat.o(96251);
        return localObject;
      }
    }
    
    public final boolean fQB()
    {
      AppMethodBeat.i(194647);
      if (fQA().size() > 0)
      {
        AppMethodBeat.o(194647);
        return true;
      }
      AppMethodBeat.o(194647);
      return false;
    }
    
    public static final class a
    {
      public static int Kjj = 101;
      public long JPX;
      public String Kjk;
      public String Kjl;
      public String Kjm;
      public int Kjn;
      public int Kjo;
      public LinkedList<Integer> Kjp;
      public long Kjq;
      
      public a()
      {
        AppMethodBeat.i(268991);
        this.Kjk = "";
        this.Kjl = "";
        this.Kjm = "";
        this.Kjn = 0;
        this.Kjp = new LinkedList();
        this.JPX = 0L;
        this.Kjq = 0L;
        AppMethodBeat.o(268991);
      }
      
      public a(String paramString1, String paramString2, String paramString3, int paramInt)
      {
        AppMethodBeat.i(268990);
        this.Kjk = "";
        this.Kjl = "";
        this.Kjm = "";
        this.Kjn = 0;
        this.Kjp = new LinkedList();
        this.JPX = 0L;
        this.Kjq = 0L;
        this.Kjk = paramString1;
        this.Kjl = paramString2;
        this.Kjm = paramString3;
        this.Kjn = paramInt;
        AppMethodBeat.o(268990);
      }
    }
  }
  
  public static class d
  {
    public ArrayList<ADInfo.e> Kjr;
    
    public d()
    {
      AppMethodBeat.i(96255);
      this.Kjr = new ArrayList();
      AppMethodBeat.o(96255);
    }
    
    public d(Map<String, String> paramMap)
    {
      AppMethodBeat.i(96254);
      this.Kjr = new ArrayList();
      int i = 0;
      for (;;)
      {
        String str;
        ADInfo.e locale;
        int j;
        if (i == 0)
        {
          localObject = ".ADInfo.adActionExt.adVoteInfoExt.voteItemList.voteResultInfo";
          str = Util.nullAs((String)paramMap.get((String)localObject + ".id"), "");
          if (TextUtils.isEmpty(str)) {
            break;
          }
          locale = new ADInfo.e();
          locale.id = str;
          locale.Kjs = Util.safeParseInt((String)paramMap.get((String)localObject + ".scoring"));
          locale.Kjt = Util.safeParseInt((String)paramMap.get((String)localObject + ".friends"));
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
          localObject = Util.nullAs((String)paramMap.get(localObject), "");
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label288;
          }
          locale.Kju.add(localObject);
          j += 1;
          break label188;
          localObject = ".ADInfo.adActionExt.adVoteInfoExt.voteItemList.voteResultInfo" + i;
          break;
        }
        label288:
        this.Kjr.add(locale);
        i += 1;
      }
      AppMethodBeat.o(96254);
    }
    
    private ADInfo.e baQ(String paramString)
    {
      AppMethodBeat.i(96257);
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(96257);
        return null;
      }
      Iterator localIterator = this.Kjr.iterator();
      while (localIterator.hasNext())
      {
        ADInfo.e locale = (ADInfo.e)localIterator.next();
        if (paramString.equals(locale.id))
        {
          AppMethodBeat.o(96257);
          return locale;
        }
      }
      AppMethodBeat.o(96257);
      return null;
    }
    
    public final int kM(String paramString1, String paramString2)
    {
      int j = 0;
      AppMethodBeat.i(96256);
      paramString1 = baQ(paramString1);
      paramString2 = baQ(paramString2);
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
        i = paramString1.Kjs;
        break;
        label62:
        j = paramString2.Kjs;
      }
      label71:
      AppMethodBeat.o(96256);
      return 50;
    }
  }
  
  public static final class e
  {
    public int Kjs;
    public int Kjt;
    public ArrayList<String> Kju;
    public String id;
    
    public e()
    {
      AppMethodBeat.i(96258);
      this.Kju = new ArrayList();
      AppMethodBeat.o(96258);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.ADInfo
 * JD-Core Version:    0.7.0.1
 */