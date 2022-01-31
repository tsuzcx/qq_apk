package com.tencent.mm.plugin.sns.storage;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
{
  public String cBW;
  public String nickname;
  public int rpO;
  public String rpP;
  public int rpQ;
  public int rpR;
  public String rpS;
  public String rpT;
  public String rpU;
  public String rpV;
  public String rpW;
  public int rpX;
  public String rpY;
  public String rpZ;
  public String rpk;
  boolean rpt;
  public float rqA;
  public int rqB;
  public String rqC;
  public String rqD;
  public String rqE;
  public String rqF;
  public List<String> rqG;
  public b.f rqH;
  public b.c rqI;
  public b.e rqJ;
  public b.a rqK;
  public boolean rqL;
  public String rqM;
  public String rqN;
  public int rqO;
  public int rqP;
  public String rqQ;
  private b.d rqR;
  public b.g rqS;
  public int rqa;
  public String rqb;
  public int rqc;
  public String rqd;
  public String rqe;
  public String rqf;
  public String rqg;
  public String rqh;
  public String rqi;
  public int rqj;
  public int rqk;
  public int rql;
  public long rqm;
  public Map<String, String> rqn;
  boolean rqo;
  public int rqp;
  public int rqq;
  public float rqr;
  public float rqs;
  public int rqt;
  public int rqu;
  public int rqv;
  public String rqw;
  public float rqx;
  public float rqy;
  public float rqz;
  
  public b(String paramString)
  {
    AppMethodBeat.i(36907);
    this.cBW = "";
    this.rpQ = 0;
    this.rpR = 0;
    this.rpS = "";
    this.rpT = "";
    this.rpU = "";
    this.rpV = "";
    this.rpW = "";
    this.rpX = 0;
    this.rpY = "";
    this.rpZ = "";
    this.rqa = 0;
    this.rqb = "";
    this.rqc = 0;
    this.rqd = "";
    this.rqe = "";
    this.rqf = "";
    this.rqg = "";
    this.rqh = "";
    this.rqi = "";
    this.rqn = new HashMap();
    this.rqG = new ArrayList();
    if ((!bo.isNullOrNil(paramString)) && (paramString.trim().startsWith("<RecXml")))
    {
      paramString = al(paramString, ".RecXml", "RecXml");
      if ((paramString != null) && (!paramString.isEmpty()))
      {
        this.rqj = bo.apV((String)paramString.get(".RecXml.$type"));
        this.rqk = bo.apV((String)paramString.get(".RecXml.$source"));
        this.rql = bo.apV((String)paramString.get(".RecXml.$expId"));
        this.rqm = i.ZN((String)paramString.get(".RecXml.$expOriginSnsId"));
      }
      AppMethodBeat.o(36907);
      return;
    }
    al(paramString, "", "adxml");
    AppMethodBeat.o(36907);
  }
  
  private Map<String, String> al(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(36908);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString3)))
    {
      AppMethodBeat.o(36908);
      return null;
    }
    this.cBW = paramString1;
    ab.i("MicroMsg.ADXml", "feed xml %s, keyPrefix %s, tag %s", new Object[] { paramString1, paramString2, paramString3 });
    Map localMap = br.F(paramString1, paramString3);
    if (localMap == null)
    {
      AppMethodBeat.o(36908);
      return null;
    }
    this.rpO = bo.apV((String)localMap.get(paramString2 + ".adxml.adType"));
    this.rpP = bo.bf((String)localMap.get(paramString2 + ".adxml.adActionTitle"), "");
    this.rpk = bo.bf((String)localMap.get(paramString2 + ".adxml.adActionLink"), "");
    this.nickname = bo.bf((String)localMap.get(paramString2 + ".adxml.nickname"), "");
    this.rpQ = bo.apV((String)localMap.get(paramString2 + ".adxml.webviewRightBarShow"));
    this.rpR = bo.apV((String)localMap.get(paramString2 + ".adxml.adActionLinkHidden"));
    this.rpS = bo.bf((String)localMap.get(paramString2 + ".adxml.adActionLinkName"), "");
    this.rpT = bo.bf((String)localMap.get(paramString2 + ".adxml.adActionLinkIcon"), "");
    this.rpU = bo.bf((String)localMap.get(paramString2 + ".adxml.adActionLinkTitle.zh"), "");
    this.rpW = bo.bf((String)localMap.get(paramString2 + ".adxml.adActionLinkTitle.tw"), "");
    this.rpV = bo.bf((String)localMap.get(paramString2 + ".adxml.adActionLinkTitle.en"), "");
    this.rpY = bo.bf((String)localMap.get(paramString2 + ".adxml.attachShareLinkWording"), "");
    this.rpZ = bo.bf((String)localMap.get(paramString2 + ".adxml.attachShareLinkUrl"), "");
    this.rpX = bo.apV((String)localMap.get(paramString2 + ".adxml.attachShareLinkIsHidden"));
    if ((bo.isNullOrNil(this.rpY)) || (bo.isNullOrNil(this.rpZ))) {
      this.rpX = 1;
    }
    this.rqd = bo.bf((String)localMap.get(paramString2 + ".adxml.expandOutsideTitle.zh"), "");
    this.rqf = bo.bf((String)localMap.get(paramString2 + ".adxml.expandOutsideTitle.tw"), "");
    this.rqe = bo.bf((String)localMap.get(paramString2 + ".adxml.expandOutsideTitle.en"), "");
    this.rqg = bo.bf((String)localMap.get(paramString2 + ".adxml.expandInsideTitle.zh"), "");
    this.rqi = bo.bf((String)localMap.get(paramString2 + ".adxml.expandInsideTitle.tw"), "");
    this.rqh = bo.bf((String)localMap.get(paramString2 + ".adxml.expandInsideTitle.en"), "");
    this.rqa = bo.apV((String)localMap.get(paramString2 + ".adxml.headClickType"));
    this.rqb = bo.bf((String)localMap.get(paramString2 + ".adxml.headClickParam"), "");
    this.rqc = bo.apV((String)localMap.get(paramString2 + ".adxml.headClickRightBarShow"));
    int i = 0;
    paramString3 = new StringBuilder().append(paramString2).append(".adxml.adArgs.arg");
    label1011:
    Object localObject1;
    Object localObject2;
    if (i == 0)
    {
      paramString1 = "";
      paramString3 = paramString1 + ".key";
      localObject1 = (String)localMap.get(paramString3);
      if (localObject1 == null) {
        break label1195;
      }
      localObject2 = new StringBuilder().append(paramString2).append(".adxml.adArgs.arg");
      if (i != 0) {
        break label1186;
      }
    }
    label1186:
    for (paramString1 = "";; paramString1 = Integer.valueOf(i))
    {
      paramString1 = paramString1 + ".value";
      localObject2 = (String)localMap.get(paramString1);
      ab.i("MicroMsg.ADXml", "newKey " + paramString3 + " " + (String)localObject1 + " newValue : " + paramString1 + " " + (String)localObject2);
      this.rqn.put(localObject1, localObject2);
      i += 1;
      break;
      paramString1 = Integer.valueOf(i);
      break label1011;
    }
    label1195:
    this.rpt = localMap.containsKey(paramString2 + ".adxml.adCanvasInfo");
    boolean bool;
    if (bo.apV((String)localMap.get(paramString2 + ".adxml.usePreferedInfo")) == 1)
    {
      bool = true;
      this.rqL = bool;
      this.rqM = bo.nullAsNil((String)localMap.get(paramString2 + ".adxml.preferNickname"));
      this.rqN = bo.nullAsNil((String)localMap.get(paramString2 + ".adxml.preferAvatar"));
      this.rqp = bo.apV((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.contentDisplayType"));
      this.rqq = bo.apV((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaDisplayMode"));
      this.rqr = ((float)bo.apX((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaDisplayWidth")));
      this.rqs = ((float)bo.apX((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaDisplayHeight")));
      this.rqv = bo.apV((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.btnDisplayType"));
      this.rqw = bo.bf((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaIconUrl"), "");
      this.rqt = bo.apV((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.basicRemWidth"));
      this.rqu = bo.apV((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.basicRootFontSize"));
      this.rqx = ((float)bo.apX((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaIconWidth")));
      this.rqy = ((float)bo.apX((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaIconHeight")));
      this.rqz = ((float)bo.apX((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaIconPaddingRight")));
      this.rqA = ((float)bo.apX((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaIconPaddingBottom")));
      this.rqB = bo.apV((String)localMap.get(paramString2 + ".adxml.adContentStyle"));
      this.rqC = bo.bf((String)localMap.get(paramString2 + ".adxml.adCardInfo.title"), "");
      this.rqD = bo.bf((String)localMap.get(paramString2 + ".adxml.adCardInfo.description"), "");
      i = 0;
      label1916:
      paramString3 = new StringBuilder().append(paramString2).append(".adxml.adCardInfo.adRatingCardInfo.tagList.tag");
      if (i != 0) {
        break label2035;
      }
    }
    label2035:
    for (paramString1 = "";; paramString1 = Integer.valueOf(i))
    {
      paramString1 = paramString1;
      if (!localMap.containsKey(paramString1)) {
        break label2044;
      }
      ab.i("MicroMsg.ADXml", "card ad tag %s", new Object[] { localMap.get(paramString1) });
      if (!bo.isNullOrNil((String)localMap.get(paramString1))) {
        this.rqG.add(localMap.get(paramString1));
      }
      i += 1;
      break label1916;
      bool = false;
      break;
    }
    label2044:
    this.rqE = bo.nullAsNil((String)localMap.get(paramString2 + ".adxml.adCardInfo.adRatingCardInfo.headTitle"));
    this.rqF = bo.nullAsNil((String)localMap.get(paramString2 + ".adxml.adCardInfo.adRatingCardInfo.headUrl"));
    paramString1 = bo.bf((String)localMap.get(paramString2 + ".adxml.adSelectInfo.leftBtnTitle"), "");
    paramString3 = bo.bf((String)localMap.get(paramString2 + ".adxml.adSelectInfo.rightBtnTitle"), "");
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3)))
    {
      this.rqR = new b.d(this);
      this.rqR.rrb = paramString1;
      this.rqR.rrc = paramString3;
    }
    paramString1 = bo.bf((String)localMap.get(paramString2 + ".adxml.adVoteInfo.componentUrl"), "");
    if (!TextUtils.isEmpty(paramString1))
    {
      this.rqS = new b.g(this);
      this.rqS.rrk = paramString1;
      paramString3 = paramString2 + ".adxml.adVoteInfo.optionList.option";
      i = 0;
      if (i == 0) {
        break label3717;
      }
    }
    label3717:
    for (paramString1 = paramString3 + i;; paramString1 = paramString3)
    {
      if (!TextUtils.isEmpty(bo.bf((String)localMap.get(paramString1 + ".title"), "")))
      {
        localObject1 = new b.h(this);
        ((b.h)localObject1).title = bo.bf((String)localMap.get(paramString1 + ".title"), "");
        ((b.h)localObject1).lHr = bo.bf((String)localMap.get(paramString1 + ".shareTitle"), "");
        ((b.h)localObject1).rrm = bo.bf((String)localMap.get(paramString1 + ".shareDesc"), "");
        ((b.h)localObject1).rrn = bo.bf((String)localMap.get(paramString1 + ".shareThumb"), "");
        ((b.h)localObject1).rro = bo.bf((String)localMap.get(paramString1 + ".selectedTitle"), "");
        this.rqS.rrl.add(localObject1);
        i += 1;
        break;
      }
      this.rqo = localMap.containsKey(paramString2 + ".adxml.adTurnCanvasInfo");
      this.rqH = new b.f();
      this.rqH.r(localMap, paramString2);
      this.rqK = new b.a().q(localMap, paramString2);
      if (this.rqB == 3)
      {
        this.rqI = new b.c();
        paramString1 = paramString2 + ".adxml.adFullCardInfo";
        paramString3 = this.rqI;
        paramString3.rqV = bo.apV((String)localMap.get(paramString1 + ".displayType"));
        paramString3.title = bo.nullAsNil((String)localMap.get(paramString1 + ".title"));
        paramString3.description = bo.nullAsNil((String)localMap.get(paramString1 + ".description"));
        paramString3.rqW = bo.getInt((String)localMap.get(paramString1 + ".markMaxAlpha"), 30);
        paramString3.rqX = bo.apV((String)localMap.get(paramString1 + ".titlePosition"));
        if (!bo.isNullOrNil((String)localMap.get(paramString1 + ".adGestureInfo.points")))
        {
          paramString3.rqY = new b.c.a();
          paramString3.rqY.color = -1;
          paramString3.rqY.startTime = bo.apV((String)localMap.get(paramString1 + ".adGestureInfo.startTime"));
          paramString3.rqY.endTime = bo.apV((String)localMap.get(paramString1 + ".adGestureInfo.endTime"));
          paramString3.rqY.rqZ = bo.apY((String)localMap.get(paramString1 + ".adGestureInfo.distance"));
          paramString3.rqY.color = Color.parseColor(bo.nullAsNil((String)localMap.get(paramString1 + ".adGestureInfo.color")));
          paramString3.rqY.rra = bo.nullAsNil((String)localMap.get(paramString1 + ".adGestureInfo.points"));
        }
      }
      for (;;)
      {
        this.rqO = bo.apV((String)localMap.get(paramString2 + ".adxml.compatible.clientVersion.androidMin"));
        this.rqP = bo.apV((String)localMap.get(paramString2 + ".adxml.compatible.clientVersion.androidMax"));
        this.rqQ = bo.nullAsNil((String)localMap.get(paramString2 + ".adxml.compatible.jumpUrl"));
        AppMethodBeat.o(36908);
        return localMap;
        if (this.rqB == 4)
        {
          this.rqJ = new b.e();
          paramString1 = paramString2 + ".adxml.adSphereCardInfo";
          paramString3 = this.rqJ;
          paramString3.rqV = bo.apV((String)localMap.get(paramString1 + ".displayType"));
          paramString3.title = bo.nullAsNil((String)localMap.get(paramString1 + ".title"));
          paramString3.description = bo.nullAsNil((String)localMap.get(paramString1 + ".description"));
          paramString3.rqW = bo.getInt((String)localMap.get(paramString1 + ".markMaxAlpha"), 30);
          paramString3.rqX = bo.apV((String)localMap.get(paramString1 + ".titlePosition"));
          paramString3.rre = bo.apV((String)localMap.get(paramString1 + ".gestureDelayTime"));
          paramString3.rrg = bo.nullAsNil((String)localMap.get(paramString1 + ".sphereThumbUrl"));
          paramString3.rrh = bo.nullAsNil((String)localMap.get(paramString1 + ".bgColor"));
          paramString3.rri = bo.nullAsNil((String)localMap.get(paramString1 + ".bgColorAlpha"));
          paramString3.rrf = bo.nullAsNil((String)localMap.get(paramString1 + ".sphereImageUrl"));
        }
      }
    }
  }
  
  public final boolean cqk()
  {
    return (this.rpt) || (this.rqo);
  }
  
  public final String cql()
  {
    AppMethodBeat.i(36909);
    String str;
    if (cqr())
    {
      str = this.rqR.rrb;
      AppMethodBeat.o(36909);
      return str;
    }
    if (cqs())
    {
      str = ((b.h)this.rqS.rrl.get(0)).title;
      AppMethodBeat.o(36909);
      return str;
    }
    AppMethodBeat.o(36909);
    return "";
  }
  
  public final String cqm()
  {
    AppMethodBeat.i(36910);
    String str;
    if (cqr())
    {
      str = this.rqR.rrc;
      AppMethodBeat.o(36910);
      return str;
    }
    if (cqs())
    {
      str = ((b.h)this.rqS.rrl.get(1)).title;
      AppMethodBeat.o(36910);
      return str;
    }
    AppMethodBeat.o(36910);
    return "";
  }
  
  public final String cqn()
  {
    AppMethodBeat.i(36911);
    if (cqs())
    {
      String str = this.rqS.rrk;
      AppMethodBeat.o(36911);
      return str;
    }
    AppMethodBeat.o(36911);
    return "";
  }
  
  public final boolean cqo()
  {
    return this.rqB == 2;
  }
  
  public final boolean cqp()
  {
    return this.rqB == 1;
  }
  
  public final boolean cqq()
  {
    return this.rqB == 3;
  }
  
  public final boolean cqr()
  {
    return this.rqR != null;
  }
  
  public final boolean cqs()
  {
    AppMethodBeat.i(36912);
    if ((this.rqS != null) && (this.rqS.rrl.size() > 1))
    {
      AppMethodBeat.o(36912);
      return true;
    }
    AppMethodBeat.o(36912);
    return false;
  }
  
  public final String cqt()
  {
    AppMethodBeat.i(36913);
    String str2 = this.cBW;
    String str1 = str2;
    if (str2.contains("<adCanvasInfoLeft>")) {
      str1 = str2.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("(?s)<adCanvasInfoRight[^>]*>.*?</adCanvasInfoRight>", "").replaceAll("adCanvasInfoLeft", "adCanvasInfo");
    }
    AppMethodBeat.o(36913);
    return str1;
  }
  
  public final String cqu()
  {
    AppMethodBeat.i(36914);
    String str2 = this.cBW;
    String str1 = str2;
    if (str2.contains("<adCanvasInfoRight>")) {
      str1 = str2.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("(?s)<adCanvasInfoLeft[^>]*>.*?</adCanvasInfoLeft>", "").replaceAll("adCanvasInfoRight", "adCanvasInfo");
    }
    AppMethodBeat.o(36914);
    return str1;
  }
  
  public final String cqv()
  {
    AppMethodBeat.i(36915);
    String str2 = this.cBW;
    String str1 = str2;
    if (str2.contains("<adTurnCanvasInfo>")) {
      str1 = str2.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("adTurnCanvasInfo", "adCanvasInfo");
    }
    AppMethodBeat.o(36915);
    return str1;
  }
  
  public final String cqw()
  {
    AppMethodBeat.i(36916);
    String str = this.cBW;
    if ((this.rqI != null) && (str.contains("<adFullCardGestureCanvasInfo>"))) {}
    for (str = str.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("adFullCardGestureCanvasInfo", "adCanvasInfo");; str = "")
    {
      AppMethodBeat.o(36916);
      return str;
    }
  }
  
  public final boolean cqx()
  {
    return this.rqk == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.b
 * JD-Core Version:    0.7.0.1
 */