package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.ViewPager.f;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.g.a.rf;
import com.tencent.mm.plugin.fav.a.v;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.model.AdlandingRemoteServiceConnectedReceiver;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdlandingDummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.plugin.sns.storage.b.g;
import com.tencent.mm.plugin.sns.storage.b.h;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.cgh;
import com.tencent.mm.protocal.protobuf.cgi;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.vfs.e;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(32)
public class SnsAdNativeLandingPagesUI
  extends MMActivity
{
  public String cFe;
  public int cpt;
  String czw;
  private long eaj;
  public String heu;
  private String hyX;
  private long iHh;
  private int iiW;
  private int iiX;
  private boolean jBD;
  private int kuG;
  private int kuH;
  private int kuI;
  private int kuJ;
  String lHq;
  String lHr;
  private ImageView mBi;
  protected a.b nkf;
  private ImageView pdI;
  public LinkedList<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g> rLY;
  private ImageView rLZ;
  private View rMA;
  private View rMB;
  private boolean rMC;
  private com.tencent.mm.plugin.sns.storage.n rMD;
  private List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h> rME;
  private com.tencent.mm.plugin.sns.ui.b.b rMF;
  private com.tencent.mm.plugin.sns.ui.b.c rMG;
  private volatile boolean rMH;
  private boolean rMI;
  public com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x rMJ;
  private Map<String, SnsAdLandingPageFloatView> rMK;
  private BroadcastReceiver rML;
  private BroadcastReceiver rMM;
  private ContentFragment.a rMN;
  private ViewPager.OnPageChangeListener rMO;
  private AdLandingPagesProxy.e rMP;
  private com.tencent.mm.sdk.b.c<mf> rMQ;
  private com.tencent.mm.sdk.b.c<rf> rMR;
  private Map<Integer, ContentFragment> rMS;
  private BroadcastReceiver rMT;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i rMU;
  private p rMV;
  private ImageView rMa;
  private TextView rMb;
  Bundle rMc;
  private boolean rMd;
  private String rMe;
  private String rMf;
  private String rMg;
  private String rMh;
  private String rMi;
  private ImageView rMj;
  String rMk;
  String rMl;
  public boolean rMm;
  k rMn;
  boolean rMo;
  private int rMp;
  private boolean rMq;
  private String rMr;
  private String rMs;
  private String rMt;
  private String rMu;
  public AdlandingDummyViewPager rMv;
  private int rMw;
  private int rMx;
  private ak rMy;
  private FrameLayout rMz;
  private int rpO;
  public String rpv;
  private String rpw;
  private int rqk;
  String rrm;
  public int rtf;
  public int rth;
  public Map<String, String> rti;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae rzh;
  private long startTime;
  public String uin;
  private Map<String, String> values;
  
  public SnsAdNativeLandingPagesUI()
  {
    AppMethodBeat.i(38656);
    this.rLY = new LinkedList();
    this.kuG = 0;
    this.kuH = 0;
    this.kuI = 0;
    this.kuJ = 0;
    this.rMd = false;
    this.rMm = false;
    this.iHh = 0L;
    this.eaj = 0L;
    this.rti = new HashMap();
    this.rMn = new k();
    this.rMo = false;
    this.rMp = 0;
    this.rMq = false;
    this.rMy = new ak();
    this.rMC = true;
    this.jBD = false;
    this.rMK = new HashMap();
    this.rML = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        boolean bool = true;
        AppMethodBeat.i(38621);
        int i = paramAnonymousIntent.getIntExtra("show", 0);
        paramAnonymousContext = (ContentFragment)((android.support.v4.app.i)SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getAdapter()).getItem(SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getCurrentItem());
        ab.d("MicroMsg.SnsAdNativeLandingPagesUI", "recv videoProgressbarStatusChangeReceiver show %d", new Object[] { Integer.valueOf(i) });
        if (i == 1) {}
        for (;;)
        {
          paramAnonymousContext.lt(bool);
          AppMethodBeat.o(38621);
          return;
          bool = false;
        }
      }
    };
    this.rMM = new SnsAdNativeLandingPagesUI.12(this);
    this.rMN = new SnsAdNativeLandingPagesUI.15(this);
    this.rMO = new ViewPager.f()
    {
      public final void onPageScrollStateChanged(int paramAnonymousInt)
      {
        AppMethodBeat.i(38645);
        super.onPageScrollStateChanged(paramAnonymousInt);
        SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this).rzp = paramAnonymousInt;
        Object localObject;
        if (paramAnonymousInt == 1)
        {
          paramAnonymousInt = 0;
          while (paramAnonymousInt < SnsAdNativeLandingPagesUI.this.rLY.size())
          {
            localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)SnsAdNativeLandingPagesUI.this.rLY.get(paramAnonymousInt);
            localObject = (Fragment)SnsAdNativeLandingPagesUI.k(SnsAdNativeLandingPagesUI.this).get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject).id));
            if (localObject != null) {
              ((ContentFragment)localObject).crK();
            }
            paramAnonymousInt += 1;
          }
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae.eV(SnsAdNativeLandingPagesUI.this.getContext());
          AppMethodBeat.o(38645);
          return;
        }
        if (paramAnonymousInt == 0)
        {
          localObject = (Fragment)SnsAdNativeLandingPagesUI.k(SnsAdNativeLandingPagesUI.this).get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)SnsAdNativeLandingPagesUI.this.rLY.get(SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getCurrentItem())).id));
          if (localObject != null) {
            ((ContentFragment)localObject).crJ();
          }
        }
        AppMethodBeat.o(38645);
      }
      
      public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
      {
        AppMethodBeat.i(38644);
        super.onPageScrolled(paramAnonymousInt1, paramAnonymousFloat, paramAnonymousInt2);
        if (SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this) != null)
        {
          ContentFragment localContentFragment = SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this);
          if ((localContentFragment.bSe) && (localContentFragment.rzf != null)) {
            localContentFragment.rzf.crD();
          }
        }
        if (SnsAdNativeLandingPagesUI.this.keyboardState() == 1) {
          SnsAdNativeLandingPagesUI.this.hideVKB();
        }
        AppMethodBeat.o(38644);
      }
      
      public final void onPageSelected(int paramAnonymousInt)
      {
        AppMethodBeat.i(38646);
        super.onPageSelected(paramAnonymousInt);
        int i = 0;
        if (i < SnsAdNativeLandingPagesUI.this.rLY.size())
        {
          Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)SnsAdNativeLandingPagesUI.this.rLY.get(i);
          localObject = (Fragment)SnsAdNativeLandingPagesUI.k(SnsAdNativeLandingPagesUI.this).get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject).id));
          if (localObject != null)
          {
            if (i != paramAnonymousInt) {
              break label87;
            }
            ((ContentFragment)localObject).crJ();
          }
          for (;;)
          {
            i += 1;
            break;
            label87:
            ((ContentFragment)localObject).crK();
          }
        }
        AppMethodBeat.o(38646);
      }
    };
    this.rMP = new AdLandingPagesProxy.e()
    {
      public final void ad(Object paramAnonymousObject)
      {
        AppMethodBeat.i(38649);
        SnsAdNativeLandingPagesUI.l(SnsAdNativeLandingPagesUI.this).removeCallbacksAndMessages(null);
        SnsAdNativeLandingPagesUI.l(SnsAdNativeLandingPagesUI.this).post(new SnsAdNativeLandingPagesUI.17.1(this, paramAnonymousObject));
        AppMethodBeat.o(38649);
      }
      
      public final void h(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject) {}
    };
    this.rMQ = new com.tencent.mm.sdk.b.c() {};
    this.rMR = new SnsAdNativeLandingPagesUI.19(this);
    this.rMS = new HashMap();
    this.nkf = new SnsAdNativeLandingPagesUI.9(this);
    this.rMT = new SnsAdNativeLandingPagesUI.11(this);
    this.rMU = null;
    this.rMV = null;
    AppMethodBeat.o(38656);
  }
  
  private void IE()
  {
    AppMethodBeat.i(38662);
    Object localObject2 = getAllComp();
    Object localObject1 = this.rMK.values().iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((List)localObject2).addAll(((SnsAdLandingPageFloatView)((Iterator)localObject1).next()).getAllComp());
    }
    this.iHh += System.currentTimeMillis() - this.startTime;
    this.rMn.rCF = ((int)this.iHh);
    this.rMn.rCE = ((List)localObject2).size();
    localObject1 = this.rMn;
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h localh = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h)((Iterator)localObject2).next();
      if (!localh.cqV().rsR)
      {
        JSONObject localJSONObject = new JSONObject();
        if ((!localh.A(((k)localObject1).rCI)) && (localh.aq(localJSONObject))) {
          ((k)localObject1).rCI.put(localJSONObject);
        }
      }
    }
    ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "landingPage report json %s", new Object[] { this.rMn.rCI });
    localObject1 = this.rMn.crZ();
    if (this.rth == 2)
    {
      AdLandingPagesProxy.getInstance().doCgiReportCanvasBrowseInfo(15041, (String)localObject1);
      ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "post cgi stat 15041 data: ".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(38662);
      return;
    }
    if (AdLandingPagesProxy.getInstance().isRecExpAd(this.rMn.czw))
    {
      com.tencent.mm.plugin.report.service.h.qsU.kvStat(14650, (String)localObject1);
      ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 14650 data: ".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(38662);
      return;
    }
    com.tencent.mm.plugin.report.service.h.qsU.kvStat(13387, (String)localObject1);
    ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 13387 data: ".concat(String.valueOf(localObject1)));
    AppMethodBeat.o(38662);
  }
  
  private void Kc()
  {
    AppMethodBeat.i(38668);
    this.rMD = AdLandingPagesProxy.getInstance().getSnsInfo(this.czw);
    AdLandingPagesProxy.getInstance().asyncCacheXml(this.czw);
    if (this.values == null)
    {
      ab.e("MicroMsg.SnsAdNativeLandingPagesUI", "parse landingpagexml is error,landingpagexml is " + this.rMe);
      AppMethodBeat.o(38668);
      return;
    }
    long l;
    Object localObject2;
    Object localObject3;
    label624:
    int i;
    if ((this.cpt == 1) || (this.cpt == 2) || (this.cpt == 16) || (this.cpt == 14) || (this.cpt == 9) || (this.cpt == 10))
    {
      l = 0L;
      if (this.rMD != null)
      {
        l = this.rMD.field_snsId;
        this.rpv = AdLandingPagesProxy.getInstance().getSnsAid(this.czw);
        this.heu = AdLandingPagesProxy.getInstance().getSnsTraceid(this.czw);
        this.rpO = AdLandingPagesProxy.getInstance().getSnsAdType(this.czw);
        this.cFe = AdLandingPagesProxy.getInstance().getSnsUxInfo(this.czw);
        this.rpw = AdLandingPagesProxy.getInstance().getSnsAdCanvasExtXml(this.czw);
      }
      if (this.rMl != null)
      {
        localObject1 = this.rMl;
        this.values.put("." + this.rMf + ".originSnsId", localObject1);
        this.values.put("." + this.rMf + ".originUxInfo", this.cFe);
        localObject2 = "<" + this.rMf + ">";
        localObject2 = (String)localObject2 + String.format("<originSnsId>%s</originSnsId>", new Object[] { localObject1 });
        localObject2 = (String)localObject2 + String.format("<originUxInfo>%s</originUxInfo>", new Object[] { this.cFe });
        localObject2 = (String)localObject2 + String.format("<originAdType>%d</originAdType>", new Object[] { Integer.valueOf(this.rpO) });
        localObject2 = (String)localObject2 + String.format("<originAid>%s</originAid>", new Object[] { this.rpv });
        localObject3 = (String)localObject2 + String.format("<originTraceId>%s</originTraceId>", new Object[] { this.heu });
        localObject2 = localObject3;
        if (!bo.isNullOrNil(this.rpw)) {
          localObject2 = (String)localObject3 + String.format("<originAdCanvasExt>%s</originAdCanvasExt>", new Object[] { this.rpw });
        }
        this.rMe = this.rMe.replace("<" + this.rMf + ">", (CharSequence)localObject2);
        this.rMn.cFe = this.cFe;
        this.rMn.czw = ((String)localObject1);
        ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "reportInfo aid [%s],traceId [%s],adType [%s],uxInfo [%s],adCanvasExtXml [%s]", new Object[] { this.rpv, this.heu, Integer.valueOf(this.rpO), this.cFe, this.rpw });
        if (bo.isNullOrNil(this.rpw)) {
          break label1309;
        }
        localObject2 = br.F(this.rpw, "adCardItemList");
        if (localObject2 == null) {
          break label1309;
        }
        i = 0;
        label704:
        if (i <= 0) {
          break label2602;
        }
      }
    }
    label1309:
    label2602:
    for (Object localObject1 = ".adCardItemList.cardItem" + i;; localObject1 = ".adCardItemList.cardItem")
    {
      if (((Map)localObject2).containsKey((String)localObject1 + ".cardTpId"))
      {
        localObject3 = bo.bf((String)((Map)localObject2).get((String)localObject1 + ".cardTpId"), "");
        localObject1 = bo.bf((String)((Map)localObject2).get((String)localObject1 + ".cardExt"), "");
        if ((!bo.isNullOrNil((String)localObject3)) && (!bo.isNullOrNil((String)localObject1))) {
          this.rti.put(localObject3, localObject1);
        }
        i += 1;
        break label704;
        localObject1 = String.valueOf(l);
        break;
        this.rMn.czw = ((String)this.values.get("." + this.rMf + ".originSnsId"));
        this.rMn.cFe = ((String)this.values.get("." + this.rMf + ".originUxInfo"));
        this.cFe = this.rMn.cFe;
        this.rMl = this.rMn.czw;
        this.rpO = bo.apV((String)this.values.get("." + this.rMf + ".originAdType"));
        this.rpv = ((String)this.values.get("." + this.rMf + ".originAid"));
        this.heu = ((String)this.values.get("." + this.rMf + ".originTraceId"));
        if (!bo.isNullOrNil(this.hyX))
        {
          localObject1 = br.F(this.hyX, "ADInfo");
          ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "adInfoXml %s", new Object[] { this.hyX });
          if (localObject1 != null)
          {
            this.cFe = bo.bf((String)((Map)localObject1).get(".ADInfo.uxInfo"), "");
            this.rMn.cFe = this.cFe;
            this.rpv = bo.bf((String)((Map)localObject1).get(".ADInfo.session_data.aid"), "");
            this.heu = bo.bf((String)((Map)localObject1).get(".ADInfo.session_data.trace_id"), "");
          }
        }
        localObject1 = Pattern.compile("<originAdCanvasExt>[\\s\\S]*</originAdCanvasExt>").matcher(this.rMe);
        if (!((Matcher)localObject1).find()) {
          break label624;
        }
        localObject1 = ((Matcher)localObject1).group();
        if (bo.isNullOrNil((String)localObject1)) {
          break label624;
        }
        this.rpw = ((String)localObject1).replaceAll("</?originAdCanvasExt>", "");
        break label624;
      }
      this.rMn.rCH = AdLandingPagesProxy.getInstance().getSnsStatExtBySnsId(bo.apW(this.rMn.czw));
      this.lHr = bo.bf((String)this.values.get("." + this.rMf + ".adCanvasInfo.shareTitle"), "");
      this.lHq = bo.bf((String)this.values.get("." + this.rMf + ".adCanvasInfo.shareWebUrl"), "");
      this.rrm = bo.bf((String)this.values.get("." + this.rMf + ".adCanvasInfo.shareDesc"), "");
      this.rth = bo.apV(bo.bf((String)this.values.get("." + this.rMf + ".adCanvasInfo.bizId"), ""));
      this.rMr = bo.bf((String)this.values.get("." + this.rMf + ".adCanvasInfo.shareAppId"), "");
      this.rMs = bo.bf((String)this.values.get("." + this.rMf + ".adCanvasInfo.shareType"), "");
      this.rMt = bo.bf((String)this.values.get("." + this.rMf + ".adCanvasInfo.userInfo"), "");
      this.rMw = bo.apV(bo.bf((String)this.values.get("." + this.rMf + ".adCanvasInfo.disableShareBitSet"), ""));
      this.rMx = bo.apV(bo.bf((String)this.values.get("." + this.rMf + ".adCanvasInfo.statusBarStyle"), ""));
      s(this.values, "." + this.rMf);
      this.uin = AdLandingPagesProxy.getInstance().getUin();
      this.rMu = bo.bf((String)this.values.get("." + this.rMf + ".adCanvasInfo.officialSyncBuffer"), "");
      getIntent().putExtra("sns_landing_pages_adType", this.rpO);
      getIntent().putExtra("sns_landing_pages_rawSnsId", this.rMn.czw);
      if (bo.isNullOrNil(this.rpv)) {
        this.rpv = bo.bf((String)this.values.get("." + this.rMf + ".originAid"), "");
      }
      if (bo.isNullOrNil(this.heu)) {
        this.heu = bo.bf((String)this.values.get("." + this.rMf + ".originTraceId"), "");
      }
      this.rLY = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.gC(this.rMe, this.rMf);
      if (this.rLY.size() > 0)
      {
        localObject2 = "";
        localObject3 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.rLY.get(0);
        localObject1 = localObject2;
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject3).rCg.size() > 0)
        {
          localObject3 = (t)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject3).rCg.get(0);
          if (!(localObject3 instanceof o)) {
            break label2436;
          }
          this.rMk = ((o)localObject3).rsw;
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        if (this.rMD != null)
        {
          localObject2 = this.rMD.csh();
          if ((localObject2 != null) && (((TimeLineObject)localObject2).xTS != null) && (((TimeLineObject)localObject2).xTS.wOa != null) && (!((TimeLineObject)localObject2).xTS.wOa.isEmpty()))
          {
            localObject3 = (bcs)((TimeLineObject)localObject2).xTS.wOa.getFirst();
            localObject2 = ao.gl(AdLandingPagesProxy.getInstance().getAccSnsPath(), ((bcs)localObject3).Id) + com.tencent.mm.plugin.sns.data.i.j((bcs)localObject3);
            localObject3 = ((bcs)localObject3).Url;
            if (((String)localObject1).equals(localObject3))
            {
              localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.gz("adId", (String)localObject3);
              if ((!e.cN((String)localObject1)) && (e.cN((String)localObject2)))
              {
                ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "copy outsideFiel:%s->%s", new Object[] { localObject2, localObject1 });
                e.C((String)localObject2, (String)localObject1);
              }
            }
          }
        }
        this.rMg = bo.bf((String)this.values.get("." + this.rMf + ".adCanvasInfo.rightBarTitle"), "");
        this.rMh = bo.bf((String)this.values.get("." + this.rMf + ".adCanvasInfo.rightBarCanvasId"), "");
        this.rMi = bo.bf((String)this.values.get("." + this.rMf + ".adCanvasInfo.rightBarCanvasExt"), "");
        AppMethodBeat.o(38668);
        return;
        if ((localObject3 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n))
        {
          this.rMk = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)localObject3).rsw;
          localObject1 = localObject2;
        }
        else if ((localObject3 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q))
        {
          this.rMk = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)localObject3).rsA;
          localObject1 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)localObject3).rsz;
        }
        else
        {
          localObject1 = localObject2;
          if ((localObject3 instanceof z))
          {
            localObject3 = (z)localObject3;
            localObject1 = localObject2;
            if (!((z)localObject3).rsu.isEmpty())
            {
              localObject3 = (m)((z)localObject3).rsu.getFirst();
              localObject1 = localObject2;
              if (!((m)localObject3).rsu.isEmpty())
              {
                localObject3 = (t)((m)localObject3).rsu.getFirst();
                localObject1 = localObject2;
                if ((localObject3 instanceof o))
                {
                  this.rMk = ((o)localObject3).rsw;
                  localObject1 = localObject2;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private String acf(String paramString)
  {
    AppMethodBeat.i(38681);
    String str = bo.bf((String)this.values.get("." + this.rMf + ".adCanvasInfo.shareThumbUrl"), "");
    if (!bo.isNullOrNil(str))
    {
      AppMethodBeat.o(38681);
      return str;
    }
    AppMethodBeat.o(38681);
    return paramString;
  }
  
  private boolean cuA()
  {
    AppMethodBeat.i(38675);
    if (this.rMw != 0)
    {
      if (((this.rMw & 0x4) == 0) || ((this.rMw & 0x2) == 0) || ((cuE()) && (this.rth == 2)) || ((this.rMw & 0x1) == 0))
      {
        AppMethodBeat.o(38675);
        return true;
      }
      AppMethodBeat.o(38675);
      return false;
    }
    AppMethodBeat.o(38675);
    return true;
  }
  
  private boolean cuB()
  {
    return (this.rMw & 0x8) == 0;
  }
  
  private boolean cuC()
  {
    return this.rMx == 0;
  }
  
  private boolean cuD()
  {
    AppMethodBeat.i(38676);
    if ((!bo.isNullOrNil(this.rMg)) && (!bo.isNullOrNil(this.rMh)))
    {
      AppMethodBeat.o(38676);
      return true;
    }
    AppMethodBeat.o(38676);
    return false;
  }
  
  private boolean cuE()
  {
    return (this.rMw & 0x10) == 0;
  }
  
  private y cuF()
  {
    AppMethodBeat.i(145493);
    Object localObject = cuG().crG().iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h localh = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h)((Iterator)localObject).next();
      if ((localh instanceof y))
      {
        localObject = (y)localh;
        AppMethodBeat.o(145493);
        return localObject;
      }
    }
    AppMethodBeat.o(145493);
    return null;
  }
  
  private ContentFragment cuG()
  {
    AppMethodBeat.i(38679);
    ContentFragment localContentFragment = null;
    if (this.rLY.size() > 0) {
      localContentFragment = (ContentFragment)this.rMS.get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.rLY.get(this.rMv.getCurrentItem())).id));
    }
    AppMethodBeat.o(38679);
    return localContentFragment;
  }
  
  private SnsAdNativeLandingPagesUI.a cuH()
  {
    AppMethodBeat.i(38680);
    Object localObject = new com.tencent.mm.plugin.sns.storage.b(this.rMe);
    if (((com.tencent.mm.plugin.sns.storage.b)localObject).cqs())
    {
      int i = AdLandingPagesProxy.getInstance().getAdVoteIndex(((com.tencent.mm.plugin.sns.storage.b)localObject).rqS.rrk, this.cFe, this.uin);
      if ((i > 0) && (i <= ((com.tencent.mm.plugin.sns.storage.b)localObject).rqS.rrl.size()))
      {
        localObject = (b.h)((com.tencent.mm.plugin.sns.storage.b)localObject).rqS.rrl.get(i - 1);
        SnsAdNativeLandingPagesUI.a locala = new SnsAdNativeLandingPagesUI.a(this, (byte)0);
        if (!bo.isNullOrNil(((b.h)localObject).lHr))
        {
          locala.lHr = ((b.h)localObject).lHr;
          if (bo.isNullOrNil(((b.h)localObject).rrm)) {
            break label165;
          }
          locala.rrm = ((b.h)localObject).rrm;
          label128:
          if (bo.isNullOrNil(((b.h)localObject).rrn)) {
            break label176;
          }
        }
        label165:
        label176:
        for (locala.rrn = ((b.h)localObject).rrn;; locala.rrn = this.rMk)
        {
          AppMethodBeat.o(38680);
          return locala;
          locala.lHr = this.lHr;
          break;
          locala.rrm = this.rrm;
          break label128;
        }
      }
    }
    AppMethodBeat.o(38680);
    return null;
  }
  
  private String cuI()
  {
    AppMethodBeat.i(38682);
    Object localObject = new cgh();
    ((cgh)localObject).xQY = new cgi();
    ((cgh)localObject).xQY.xRc = this.rMn.cFe;
    ((cgh)localObject).xQY.xRb = this.rMn.czw;
    ((cgh)localObject).xQY.rpO = this.rpO;
    try
    {
      localObject = Base64.encodeToString(((cgh)localObject).toByteArray(), 2);
      AppMethodBeat.o(38682);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(38682);
    }
    return "";
  }
  
  private String cuJ()
  {
    AppMethodBeat.i(38683);
    String str = this.rMe.replaceAll("(?s)<adCanvasInfoLeft[^>]*>.*?</adCanvasInfoLeft>", "").replaceAll("(?s)<adCanvasInfoRight[^>]*>.*?</adCanvasInfoRight>", "");
    AppMethodBeat.o(38683);
    return str;
  }
  
  private void cut()
  {
    AppMethodBeat.i(38658);
    AdlandingRemoteServiceConnectedReceiver.a(android.support.v4.content.d.R(this));
    Kc();
    if (this.rMd) {
      cuy();
    }
    for (;;)
    {
      refreshView();
      cuv();
      lz(true);
      this.jBD = true;
      AppMethodBeat.o(38658);
      return;
      cuz();
    }
  }
  
  private void cuu()
  {
    AppMethodBeat.i(38661);
    Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.rMv.getAdapter();
    if (localObject == null)
    {
      AppMethodBeat.o(38661);
      return;
    }
    localObject = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)localObject).rzK.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ContentFragment localContentFragment = (ContentFragment)((Iterator)localObject).next();
      if ((localContentFragment.rzf != null) && (localContentFragment.getUserVisibleHint())) {
        localContentFragment.rzf.crE();
      }
    }
    AppMethodBeat.o(38661);
  }
  
  private void cuv()
  {
    AppMethodBeat.i(38663);
    com.tencent.mm.plugin.report.service.h localh;
    String str2;
    if (this.rqk != 2)
    {
      localh = com.tencent.mm.plugin.report.service.h.qsU;
      str2 = com.tencent.mm.plugin.sns.data.i.lq(com.tencent.mm.plugin.sns.data.i.ZN(this.rMn.czw));
      if (this.cFe != null) {
        break label127;
      }
    }
    label127:
    for (String str1 = "";; str1 = this.cFe)
    {
      localh.e(14655, new Object[] { str2, str1, Integer.valueOf(this.rMn.rCz), Integer.valueOf(this.rMn.lsc), Long.valueOf(this.eaj), Integer.valueOf(this.rtf), this.rMn.hyW });
      AppMethodBeat.o(38663);
      return;
    }
  }
  
  private boolean cuw()
  {
    AppMethodBeat.i(38664);
    if ((this.rMz.getChildAt(this.rMz.getChildCount() - 2) instanceof SnsAdLandingPageFloatView))
    {
      AppMethodBeat.o(38664);
      return true;
    }
    AppMethodBeat.o(38664);
    return false;
  }
  
  private List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g> cux()
  {
    AppMethodBeat.i(38670);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.rLY.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g localg = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localIterator.next();
      if (localg.rCi) {
        localArrayList.add(localg);
      }
    }
    AppMethodBeat.o(38670);
    return localArrayList;
  }
  
  private void cuy()
  {
    AppMethodBeat.i(38671);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.rMv.getAdapter();
    if (localb == null)
    {
      localb = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b(getSupportFragmentManager(), new ArrayList());
      this.rMv.setAdapter(localb);
    }
    for (;;)
    {
      List localList = cux();
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g localg;
      ContentFragment localContentFragment;
      if (localList.size() > 0)
      {
        localg = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localList.get(0);
        ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "loadFirstPage load id %s", new Object[] { Integer.valueOf(localg.id) });
        localContentFragment = (ContentFragment)this.rMS.get(Integer.valueOf(localg.id));
        if (localContentFragment != null) {
          break label342;
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("pageInfo", localg);
        localHashMap.put("viewPager", this.rMv);
        localHashMap.put("pageDownIconInfo", this.rzh);
        localHashMap.put("is_first_show_page", Boolean.TRUE);
        if (localList.size() == 1) {
          localHashMap.put("is_last_shown_page", Boolean.TRUE);
        }
        localHashMap.put("needEnterAnimation", Boolean.valueOf(this.rMd));
        localHashMap.put("needDirectionAnimation", Boolean.valueOf(cuB()));
        localHashMap.put("groupListCompShowIndex", Integer.valueOf(this.rMp));
        localContentFragment = new ContentFragment();
        localContentFragment.pJb = localHashMap;
        localContentFragment.rzr = this.rMN;
        this.rMS.put(Integer.valueOf(localg.id), localContentFragment);
      }
      for (;;)
      {
        if (localContentFragment != null) {
          localb.b(localContentFragment, 0);
        }
        localb.notifyDataSetChanged();
        this.rMv.setOffscreenPageLimit(localList.size());
        AppMethodBeat.o(38671);
        return;
        label342:
        localContentFragment.a(localg);
      }
    }
  }
  
  private void cuz()
  {
    AppMethodBeat.i(38672);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.rMv.getAdapter();
    if (localb == null)
    {
      localb = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b(getSupportFragmentManager(), new ArrayList());
      this.rMv.setAdapter(localb);
    }
    for (;;)
    {
      List localList = cux();
      int i = 0;
      if (i < localList.size())
      {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g localg = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.rLY.get(i);
        ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "loadLandingPages load id %s", new Object[] { Integer.valueOf(localg.id) });
        ContentFragment localContentFragment = (ContentFragment)this.rMS.get(Integer.valueOf(localg.id));
        boolean bool;
        label193:
        label223:
        int j;
        if (localContentFragment == null)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("pageInfo", localg);
          localHashMap.put("viewPager", this.rMv);
          localHashMap.put("pageDownIconInfo", this.rzh);
          if (i == 0)
          {
            bool = true;
            localHashMap.put("is_first_show_page", Boolean.valueOf(bool));
            if (i != localList.size() - 1) {
              break label372;
            }
            bool = true;
            localHashMap.put("is_last_shown_page", Boolean.valueOf(bool));
            localHashMap.put("needEnterAnimation", Boolean.valueOf(this.rMd));
            localHashMap.put("needDirectionAnimation", Boolean.valueOf(cuB()));
            if (i != 0) {
              break label377;
            }
            j = this.rMp;
            label283:
            localHashMap.put("groupListCompShowIndex", Integer.valueOf(j));
            localContentFragment = new ContentFragment();
            localContentFragment.pJb = localHashMap;
            if (i == 0) {
              localContentFragment.rzr = this.rMN;
            }
            this.rMS.put(Integer.valueOf(localg.id), localContentFragment);
          }
        }
        for (;;)
        {
          if (localContentFragment != null) {
            localb.b(localContentFragment, i);
          }
          i += 1;
          break;
          bool = false;
          break label193;
          label372:
          bool = false;
          break label223;
          label377:
          j = 0;
          break label283;
          localContentFragment.a(localg);
        }
      }
      localb.notifyDataSetChanged();
      this.rMv.setOffscreenPageLimit(localList.size());
      AppMethodBeat.o(38672);
      return;
    }
  }
  
  private List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h> getAllComp()
  {
    AppMethodBeat.i(38673);
    this.rME = new ArrayList();
    Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.rMv.getAdapter();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)localObject).rzK.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Fragment localFragment = (Fragment)((Iterator)localObject).next();
        this.rME.addAll(((ContentFragment)localFragment).crG());
      }
    }
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.df(this.rME);
    localObject = this.rME;
    AppMethodBeat.o(38673);
    return localObject;
  }
  
  private void refreshView()
  {
    AppMethodBeat.i(38659);
    Object localObject;
    if ((this.rth == 2) && (!cuC()))
    {
      localObject = (FrameLayout.LayoutParams)this.rMv.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).setMargins(0, 0, 0, am.fx(this));
      this.rMv.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int i = 2131690709;
    if (!cuC())
    {
      i = getResources().getColor(2131689763);
      if ((this.rLY == null) || (this.rLY.size() <= 0) || (bo.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.rLY.getFirst()).hhh))) {
        break label313;
      }
      i = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.rLY.getFirst()).hhh);
    }
    label313:
    for (;;)
    {
      this.rMA.setBackgroundColor(i);
      i = 2131689763;
      localObject = this.pdI.getDrawable();
      if (localObject != null)
      {
        android.support.v4.graphics.drawable.a.a((Drawable)localObject, android.support.v4.content.b.m(this, i));
        this.pdI.setImageDrawable((Drawable)localObject);
      }
      localObject = this.rLZ.getDrawable();
      if (localObject != null)
      {
        android.support.v4.graphics.drawable.a.a((Drawable)localObject, android.support.v4.content.b.m(this, i));
        this.rLZ.setImageDrawable((Drawable)localObject);
      }
      if ((cuD()) && (!cuE()) && (this.rth == 2))
      {
        this.rLZ.setVisibility(8);
        this.rMb.setVisibility(0);
        this.rMb.setText(this.rMg);
        this.rMb.setOnClickListener(new SnsAdNativeLandingPagesUI.21(this));
        AppMethodBeat.o(38659);
        return;
      }
      if (cuA())
      {
        this.rLZ.setOnClickListener(new SnsAdNativeLandingPagesUI.2(this));
        AppMethodBeat.o(38659);
        return;
      }
      this.rLZ.setVisibility(8);
      AppMethodBeat.o(38659);
      return;
    }
  }
  
  private void s(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(38669);
    String str = (String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.iconUrl");
    if (TextUtils.isEmpty(str))
    {
      this.rzh = null;
      AppMethodBeat.o(38669);
      return;
    }
    if (this.rzh == null) {
      this.rzh = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae();
    }
    this.rzh.iconUrl = str;
    int k = bo.apV((String)paramMap.get(paramString + ".adCanvasInfo.sizeType"));
    int i = bo.apV((String)paramMap.get(paramString + ".adCanvasInfo.basicRootFontSize"));
    int j = bo.apV((String)paramMap.get(paramString + ".adCanvasInfo.basicWidth"));
    if ((i == 0) && (k == 1)) {
      i = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.rCk;
    }
    for (;;)
    {
      if ((j == 0) && (k == 1)) {
        j = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.rCj;
      }
      for (;;)
      {
        this.rzh.paddingBottom = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(bo.apX((String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.paddingBottom")), k, j, i);
        this.rzh.width = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(bo.apX((String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.layoutWidth")), k, j, i);
        this.rzh.height = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(bo.apX((String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.layoutHeight")), k, j, i);
        AppMethodBeat.o(38669);
        return;
      }
    }
  }
  
  public final void a(t paramt, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(38687);
    if ((this.rMU != null) && (!paramBoolean3))
    {
      ab.w("MicroMsg.SnsAdNativeLandingPagesUI", "bottom sheet appear several times");
      this.rMU.cre();
      if (this.rMV != null)
      {
        this.rMV.dismiss();
        this.rMV = null;
      }
      AppMethodBeat.o(38687);
      return;
    }
    SnsAdNativeLandingPagesUI.13 local13 = new SnsAdNativeLandingPagesUI.13(this, paramBoolean3);
    AppCompatActivity localAppCompatActivity;
    LinearLayout localLinearLayout;
    if (!paramBoolean3)
    {
      localAppCompatActivity = getContext();
      localLinearLayout = new LinearLayout(getContext());
      if (bo.isNullOrNil(paramt.rsN)) {
        break label223;
      }
    }
    label223:
    for (int i = Color.parseColor(paramt.rsN);; i = -1)
    {
      paramt = al.a(localAppCompatActivity, paramt, localLinearLayout, i);
      this.rMU = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i(getContext(), paramt, paramString1, paramString2, paramString3, paramBoolean1, paramBoolean2);
      paramt = paramt.getView();
      this.rMU.rvo = new SnsAdNativeLandingPagesUI.14(this, paramt);
      this.rMU.crd();
      if (!bo.isNullOrNil(paramString1))
      {
        AdLandingPagesProxy.getInstance().doFavOfficialItemScene(paramString1, local13);
        if (paramBoolean3) {
          this.rMV = com.tencent.mm.ui.base.h.b(this, getString(2131303875), false, null);
        }
      }
      AppMethodBeat.o(38687);
      return;
    }
  }
  
  public final void bdV()
  {
    AppMethodBeat.i(38677);
    Object localObject;
    try
    {
      Iterator localIterator1 = this.rMK.values().iterator();
      while (localIterator1.hasNext())
      {
        localObject = (SnsAdLandingPageFloatView)localIterator1.next();
        ((SnsAdLandingPageFloatView)localObject).onPause();
        ((SnsAdLandingPageFloatView)localObject).setVisibility(8);
      }
      hideVKB();
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SnsAdNativeLandingPagesUI", localException, "play exit animation error", new Object[0]);
      finish();
      AppMethodBeat.o(38677);
      return;
    }
    cuu();
    IE();
    this.rMo = true;
    this.rMA.setVisibility(8);
    if (!this.rMd)
    {
      finish();
      AppMethodBeat.o(38677);
      return;
    }
    if (this.rMH)
    {
      ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "is playing animation");
      AppMethodBeat.o(38677);
      return;
    }
    ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "run exit animation, %s", new Object[] { Boolean.valueOf(this.rMd) });
    this.rMH = true;
    if (isSupportNavigationSwipeBack()) {
      getSwipeBackLayout().setEnableGesture(false);
    }
    Iterator localIterator2 = cuG().crG().iterator();
    while (localIterator2.hasNext())
    {
      localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h)localIterator2.next();
      if ((localObject instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a))
      {
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject).cqy();
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h)localObject).cra();
      }
    }
    com.tencent.mm.sdk.platformtools.al.p(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(154485);
        SnsAdNativeLandingPagesUI.K(SnsAdNativeLandingPagesUI.this);
        AppMethodBeat.o(154485);
      }
    }, 30L);
    AppMethodBeat.o(38677);
  }
  
  public boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  public final boolean cuK()
  {
    AppMethodBeat.i(145494);
    try
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.rMv.getAdapter();
      int i = this.rMv.getCurrentItem();
      ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "hasNextPage, curPage=" + i + ", pageCount=" + localb.getCount());
      if (i < localb.getCount() - 1)
      {
        AppMethodBeat.o(145494);
        return true;
      }
      AppMethodBeat.o(145494);
      return false;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.SnsAdNativeLandingPagesUI", "hasNextPage exp:" + localException.toString());
      AppMethodBeat.o(145494);
    }
    return true;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130970796;
  }
  
  @TargetApi(16)
  public void initView()
  {
    AppMethodBeat.i(38674);
    super.initView();
    this.rMz = ((FrameLayout)findViewById(2131821003));
    this.rMB = findViewById(2131827841);
    this.rMv = ((AdlandingDummyViewPager)findViewById(2131827884));
    this.rMA = findViewById(2131827842);
    ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "before, assistActivity");
    if (af.hW(getContext()))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.rMz.getLayoutParams();
      localLayoutParams.height = (this.iiX - af.hV(this));
      localLayoutParams.topMargin = af.hV(this);
      this.rMz.setLayoutParams(localLayoutParams);
      getController().setActionbarColor(getResources().getColor(2131689641));
      com.tencent.mm.sdk.platformtools.al.p(new SnsAdNativeLandingPagesUI.3(this), 1500L);
    }
    for (;;)
    {
      this.mBi = ((ImageView)findViewById(2131822135));
      this.rMa = ((ImageView)findViewById(2131827883));
      this.pdI = ((ImageView)findViewById(2131827843));
      this.pdI.setOnClickListener(new SnsAdNativeLandingPagesUI.5(this));
      this.rLZ = ((ImageView)findViewById(2131827844));
      this.rMb = ((TextView)findViewById(2131827886));
      this.rMj = ((ImageView)findViewById(2131827885));
      if (this.rMd)
      {
        this.rMz.setAlpha(0.0F);
        this.mBi.setAlpha(0.0F);
        com.tencent.mm.ui.base.b.a(this, null);
      }
      AppMethodBeat.o(38674);
      return;
      com.tencent.mm.sdk.platformtools.al.p(new SnsAdNativeLandingPagesUI.4(this), 1500L);
    }
  }
  
  public final void lz(boolean paramBoolean)
  {
    AppMethodBeat.i(38686);
    if ((paramBoolean) && (this.rth == 1)) {
      AdLandingPagesProxy.getInstance().doDynamicUpdateScene(this.rMr, this.rMs, this.rMt, this.rMP);
    }
    if ((this.rth == 2) && (!bo.isNullOrNil(this.rMu))) {
      AdLandingPagesProxy.getInstance().doSearchDynamicUpdateScene(this.rMu, this.rMP);
    }
    this.rMq = true;
    AppMethodBeat.o(38686);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(38684);
    if (paramInt1 == 1) {
      if (paramInt2 == -1) {
        com.tencent.mm.ui.base.h.bO(getContext(), getContext().getString(2131297076));
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(38684);
      return;
      int i;
      if (paramInt1 == 2)
      {
        if (paramIntent.getBooleanExtra("kfavorite", false))
        {
          i = AdLandingPagesProxy.getInstance().doFav(paramIntent, 42);
          ((v)com.tencent.mm.kernel.g.E(v.class)).a(i, this, this.nkf);
        }
      }
      else if (paramInt1 == com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x.rxF) {
        try
        {
          Object localObject = paramIntent.getStringExtra("KComponentCid");
          Iterator localIterator = getAllComp().iterator();
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h localh;
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localh = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h)localIterator.next();
          } while (!localh.cqY().equals(localObject));
          localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x)localh;
          i = paramIntent.getIntExtra("KStreamVideoPlayCount", 0);
          int j = paramIntent.getIntExtra("KStreamVideoPlayCompleteCount", 0);
          int k = paramIntent.getIntExtra("KStreamVideoTotalPlayTimeInMs", 0);
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x)localObject).qZF = (i + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x)localObject).qZF);
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x)localObject).qZG += j;
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x)localObject).qZH += k;
        }
        catch (Exception localException) {}
      }
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(38678);
    bdV();
    AppMethodBeat.o(38678);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38657);
    super.onCreate(paramBundle);
    this.startTime = System.currentTimeMillis();
    this.eaj = System.currentTimeMillis();
    this.rMn.eaj = this.eaj;
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae.ai(this);
    Object localObject = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae.eU(this);
    this.iiW = localObject[0];
    this.iiX = localObject[1];
    this.rMc = paramBundle;
    this.mController.hideTitleView();
    this.kuG = getIntent().getIntExtra("img_gallery_top", 0);
    this.kuH = getIntent().getIntExtra("img_gallery_left", 0);
    this.kuI = getIntent().getIntExtra("img_gallery_width", 0);
    this.kuJ = getIntent().getIntExtra("img_gallery_height", 0);
    getWindow().addFlags(128);
    this.cpt = getIntent().getIntExtra("sns_landig_pages_from_source", 0);
    this.rtf = getIntent().getIntExtra("sns_landig_pages_origin_from_source", 0);
    this.rMe = getIntent().getStringExtra("sns_landing_pages_xml");
    paramBundle = getIntent().getStringExtra("sns_landing_pages_too_large_xml_path");
    if ((bo.isNullOrNil(this.rMe)) && (!bo.isNullOrNil(paramBundle))) {
      this.rMe = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae.abn(paramBundle);
    }
    if (bo.isNullOrNil(this.rMe))
    {
      finish();
      initView();
      if (AdLandingPagesProxy.getInstance().isConnected()) {
        break label886;
      }
      ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "isConnected==false");
      AdLandingPagesProxy.getInstance().connect(new SnsAdNativeLandingPagesUI.20(this));
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.ymk.c(this.rMR);
      AppMethodBeat.o(38657);
      return;
      this.rMe = this.rMe.replaceAll("</*RecXml[\\s|\\S]*?>", "");
      this.rMn.rkS = getIntent().getStringExtra("sns_landing_pages_expid");
      this.rMf = getIntent().getStringExtra("sns_landing_pages_xml_prefix");
      this.czw = getIntent().getStringExtra("sns_landing_pages_share_sns_id");
      this.rMl = getIntent().getStringExtra("sns_landing_pages_rawSnsId");
      this.cFe = getIntent().getStringExtra("sns_landing_pages_ux_info");
      this.rpv = getIntent().getStringExtra("sns_landing_pages_aid");
      this.heu = getIntent().getStringExtra("sns_landing_pages_traceid");
      paramBundle = getIntent().getStringExtra("sns_landing_pages_search_extra");
      localObject = this.rMn;
      if (!TextUtils.isEmpty(paramBundle))
      {
        if (((k)localObject).extra.length() > 0) {
          ((k)localObject).extra += "&";
        }
        ((k)localObject).extra = (((k)localObject).extra + "searchextra=" + URLEncoder.encode(paramBundle));
      }
      paramBundle = getIntent().getStringExtra("sns_landing_pages_extra");
      localObject = this.rMn;
      if (!TextUtils.isEmpty(paramBundle)) {
        ((k)localObject).extra = (((k)localObject).extra + "&extra1=" + URLEncoder.encode(paramBundle));
      }
      this.rMm = getIntent().getBooleanExtra("sns_landing_is_native_sight_ad", false);
      this.rqk = getIntent().getIntExtra("sns_landing_pages_rec_src", 0);
      this.rMp = getIntent().getIntExtra("sns_landing_pages_from_outer_index", 0);
      this.hyX = getIntent().getStringExtra("sns_landing_pages_ad_info");
      this.rMd = getIntent().getBooleanExtra("sns_landing_pages_need_enter_and_exit_animation", false);
      if (this.rMd) {
        this.rMn.rCz = 0;
      }
      for (this.rMn.dZJ = 0;; this.rMn.dZJ = 1)
      {
        this.rMn.lsc = this.cpt;
        this.rMn.rCA = 0;
        this.rMn.rCB = 0;
        this.rMn.rCC = 1;
        this.rMn.rCD = 0;
        this.rMn.rtf = this.rtf;
        if ((this.rMf == null) || ("".equals(this.rMe))) {
          this.rMf = "adxml";
        }
        if ((!bo.isNullOrNil(this.rMe)) && (!bo.isNullOrNil(this.rMf))) {
          break label817;
        }
        ab.e("MicroMsg.SnsAdNativeLandingPagesUI", "landingPagesXml is " + this.rMe + ",landingPagesXmlPrex is " + this.rMf);
        break;
        this.rMn.rCz = 1;
      }
      label817:
      this.values = br.F(this.rMe, this.rMf);
      this.rMn.hyW = bo.bf((String)this.values.get("." + this.rMf + ".adCanvasInfo.canvasId"), "");
      break;
      label886:
      ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "isConnected==true");
      cut();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38660);
    getWindow().clearFlags(128);
    if (this.jBD)
    {
      ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "the SnsAdNativeLadingPagesUI is destroy, bHandleExit=" + this.rMo);
      if (!this.rMo)
      {
        cuu();
        IE();
      }
    }
    for (;;)
    {
      this.rMK.clear();
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.rMv.getAdapter();
      if (localb != null) {
        localb.rzK.clear();
      }
      unregisterReceiver(this.rMT);
      com.tencent.mm.sdk.b.a.ymk.d(this.rMR);
      AdLandingPagesProxy.getInstance().clearCallback();
      super.onDestroy();
      AppMethodBeat.o(38660);
      return;
      ab.e("MicroMsg.SnsAdNativeLandingPagesUI", "onDestroy, isConnected=false");
    }
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(38685);
    super.onKeyboardStateChanged();
    if (this.rMv != null) {
      this.rMv.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(154490);
          if (SnsAdNativeLandingPagesUI.this.keyboardState() != 1) {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae.ai(SnsAdNativeLandingPagesUI.this);
          }
          if (!SnsAdNativeLandingPagesUI.L(SnsAdNativeLandingPagesUI.this))
          {
            new ArrayList();
            Iterator localIterator = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getAdapter()).rzK.iterator();
            while (localIterator.hasNext())
            {
              ContentFragment localContentFragment = (ContentFragment)localIterator.next();
              SnsAdNativeLandingPagesUI.this.keyboardState();
              localContentFragment.crH();
            }
          }
          AppMethodBeat.o(154490);
        }
      }, 500L);
    }
    AppMethodBeat.o(38685);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(38666);
    super.onPause();
    ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "onPause");
    this.rMI = true;
    if (this.jBD) {
      this.iHh += System.currentTimeMillis() - this.startTime;
    }
    if (cuw())
    {
      localObject = this.rMK.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((SnsAdLandingPageFloatView)((Iterator)localObject).next()).onPause();
      }
    }
    Object localObject = this.rMv;
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.rMO;
    ((AdlandingDummyViewPager)localObject).ryV.remove(localOnPageChangeListener);
    android.support.v4.content.d.R(this).unregisterReceiver(this.rML);
    android.support.v4.content.d.R(this).unregisterReceiver(this.rMM);
    com.tencent.mm.sdk.b.a.ymk.d(this.rMQ);
    if (this.rMU != null) {
      this.rMU.cre();
    }
    AppMethodBeat.o(38666);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38665);
    ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "onResume");
    super.onResume();
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae.ai(this);
    if (cuw())
    {
      ((SnsAdLandingPageFloatView)this.rMz.getChildAt(this.rMz.getChildCount() - 2)).onResume();
      AppMethodBeat.o(38665);
      return;
    }
    this.rMI = false;
    AdlandingDummyViewPager localAdlandingDummyViewPager = this.rMv;
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.rMO;
    localAdlandingDummyViewPager.ryV.add(localOnPageChangeListener);
    android.support.v4.content.d.R(this).a(this.rML, new IntentFilter("com.tencent.mm.adlanding.video_progressbar_change"));
    android.support.v4.content.d.R(this).a(this.rMM, new IntentFilter("com.tencent.mm.adlanding.set_uioption"));
    if (this.jBD) {
      this.startTime = System.currentTimeMillis();
    }
    registerReceiver(this.rMT, new IntentFilter("android.intent.action.SCREEN_ON"));
    com.tencent.mm.sdk.b.a.ymk.c(this.rMQ);
    if (this.rMq) {
      lz(false);
    }
    AppMethodBeat.o(38665);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(38667);
    this.rMn.dZJ = 2;
    k localk = this.rMn;
    localk.rCD += 1;
    super.onSwipeBack();
    try
    {
      hideVKB();
      AppMethodBeat.o(38667);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.SnsAdNativeLandingPagesUI", "onSwipeBack hideVKB exp=" + localException.toString());
      AppMethodBeat.o(38667);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void w(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(38688);
    Intent localIntent = new Intent();
    localIntent.putExtra("sns_landig_pages_from_source", 14);
    int i;
    String str2;
    String str1;
    JSONObject localJSONObject;
    if (this.rtf == 0)
    {
      i = this.cpt;
      localIntent.putExtra("sns_landig_pages_origin_from_source", i);
      localIntent.putExtra("sns_landing_pages_canvasid", paramString1);
      localIntent.putExtra("sns_landing_pages_canvas_ext", paramString2);
      localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
      localIntent.putExtra("sns_landing_pages_no_store", 1);
      str2 = ((Activity)paramContext).getIntent().getStringExtra("sns_landing_pages_sessionId");
      paramString2 = ((Activity)paramContext).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
      if (!bo.isNullOrNil(str2))
      {
        str1 = String.valueOf(System.currentTimeMillis() / 1000L);
        localJSONObject = new JSONObject();
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("sessionId", str1);
        localJSONObject.put("cid", "");
        if (bo.isNullOrNil(paramString2)) {
          continue;
        }
        paramString1 = paramString2;
        localJSONObject.put("adBuffer", paramString1);
        localJSONObject.put("preSessionId", str2);
      }
      catch (Exception paramString1)
      {
        continue;
      }
      localIntent.putExtra("sns_landing_pages_search_extra", localJSONObject.toString());
      localIntent.putExtra("sns_landing_pages_sessionId", str1);
      localIntent.putExtra("sns_landing_pages_ad_buffer", paramString2);
      com.tencent.mm.bq.d.b(paramContext, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
      AppMethodBeat.o(38688);
      return;
      i = this.rtf;
      break;
      paramString1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI
 * JD-Core Version:    0.7.0.1
 */