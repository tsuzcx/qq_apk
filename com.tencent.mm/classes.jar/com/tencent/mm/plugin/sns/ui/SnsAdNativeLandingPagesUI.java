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
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.e;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.a.v;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a;
import com.tencent.mm.plugin.sns.model.AdlandingRemoteServiceConnectedReceiver;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j.4;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j.5;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdlandingDummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.plugin.sns.storage.b.f;
import com.tencent.mm.plugin.sns.storage.b.g;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bvo;
import com.tencent.mm.protocal.c.bvp;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.vfs.e;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
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

public class SnsAdNativeLandingPagesUI
  extends MMActivity
{
  public static boolean oUq = false;
  String bRV;
  private long diQ = 0L;
  public String fLi;
  private int gHR;
  private int gHS;
  private long gYS = 0L;
  private String ggB;
  private boolean hIf = false;
  private ImageView iaw;
  private int itB = 0;
  private int itC = 0;
  private int itD = 0;
  private int itE = 0;
  String jxR;
  String jxS;
  protected a.b kNz = new SnsAdNativeLandingPagesUI.5(this);
  private ImageView kgw;
  private View khn;
  private int oAE;
  public String oAl;
  private String oAm;
  String oBT;
  private int oBa;
  private int oDu;
  private int oDw;
  private int oGD = 1000;
  private int oGE = 700;
  private int oGF = 250;
  private z oJn;
  private AdlandingDummyViewPager oUA;
  private int oUB;
  private int oUC;
  private ah oUD = new ah();
  private View oUE;
  private View oUF;
  private boolean oUG = true;
  private com.tencent.mm.plugin.sns.storage.n oUH;
  private com.tencent.mm.plugin.sns.ui.a.b oUI;
  private com.tencent.mm.plugin.sns.ui.a.c oUJ;
  private volatile boolean oUK;
  private BroadcastReceiver oUL = new SnsAdNativeLandingPagesUI.1(this);
  private BroadcastReceiver oUM = new BroadcastReceiver()
  {
    public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this);
    }
  };
  private b.a oUN = new SnsAdNativeLandingPagesUI.11(this);
  private ViewPager.e oUO = new SnsAdNativeLandingPagesUI.12(this);
  private AdLandingPagesProxy.a oUP = new SnsAdNativeLandingPagesUI.13(this);
  private Map<Integer, Fragment> oUQ = new HashMap();
  private BroadcastReceiver oUR = new BroadcastReceiver()
  {
    public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getAction().equals("android.intent.action.SCREEN_OFF")) {
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsAdNativeLandingPagesUI", "android.intent.action.SCREEN_OFF");
      }
      while (!paramAnonymousIntent.getAction().equals("android.intent.action.SCREEN_ON")) {
        return;
      }
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsAdNativeLandingPagesUI", "android.intent.action.SCREEN_ON");
      SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this);
    }
  };
  private j oUS = null;
  private com.tencent.mm.ui.base.p oUT = null;
  public LinkedList<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g> oUb = new LinkedList();
  private ImageView oUc;
  private ImageView oUd;
  private ImageView oUe;
  private TextView oUf;
  Bundle oUg;
  private boolean oUh = false;
  private String oUi;
  private String oUj;
  private String oUk;
  private String oUl;
  private String oUm;
  private ImageView oUn;
  String oUo;
  String oUp;
  public Map<String, String> oUr = new HashMap();
  k oUs = new k();
  boolean oUt = false;
  private int oUu = 0;
  private boolean oUv = false;
  private String oUw;
  private String oUx;
  private String oUy;
  private String oUz;
  private String ovV;
  private int source;
  private long startTime;
  private String uin;
  private Map<String, String> values;
  
  private String Pl(String paramString)
  {
    String str = bk.aM((String)this.values.get("." + this.oUj + ".adCanvasInfo.shareThumbUrl"), "");
    if (!bk.bl(str)) {
      paramString = str;
    }
    return paramString;
  }
  
  private void bIb()
  {
    AdlandingRemoteServiceConnectedReceiver.b(android.support.v4.content.d.Q(this));
    this.oUH = AdLandingPagesProxy.getInstance().getSnsInfo(this.bRV);
    AdLandingPagesProxy.getInstance().asyncCacheXml(this.bRV);
    Object localObject1;
    Object localObject3;
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g localg;
    Object localObject2;
    label355:
    label1648:
    int k;
    label387:
    label427:
    label1963:
    label2502:
    int i;
    label678:
    int j;
    if (this.values == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SnsAdNativeLandingPagesUI", "parse landingpagexml is error,landingpagexml is " + this.oUi);
      if (!this.oUh) {
        break label2983;
      }
      bIe();
      localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c)this.oUA.getAdapter();
      if (localObject1 != null) {
        break label2999;
      }
      localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c(getSupportFragmentManager(), new ArrayList());
      this.oUA.setAdapter((android.support.v4.view.n)localObject1);
      localObject3 = bIf();
      if (((List)localObject3).size() > 0)
      {
        localg = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)((List)localObject3).get(0);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsAdNativeLandingPagesUI", "loadFirstPage load id %s", new Object[] { Integer.valueOf(localg.id) });
        localObject2 = (Fragment)this.oUQ.get(Integer.valueOf(localg.id));
        if (localObject2 == null)
        {
          localObject2 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b();
          Bundle localBundle = new Bundle();
          localBundle.putSerializable("pageInfo", localg);
          localBundle.putSerializable("viewPager", this.oUA);
          localBundle.putSerializable("pageDownIconInfo", this.oJn);
          localBundle.putBoolean("is_first_show_page", true);
          if (((List)localObject3).size() == 1) {
            localBundle.putBoolean("is_last_shown_page", true);
          }
          localBundle.putSerializable("lifecyleListener", this.oUN);
          localBundle.putBoolean("needEnterAnimation", this.oUh);
          localBundle.putBoolean("needDirectionAnimation", bIj());
          localBundle.putInt("groupListCompShowIndex", this.oUu);
          ((Fragment)localObject2).setArguments(localBundle);
          this.oUQ.put(Integer.valueOf(localg.id), localObject2);
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c)localObject1).a((Fragment)localObject2, 0);
          }
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c)localObject1).notifyDataSetChanged();
          this.oUA.setOffscreenPageLimit(((List)localObject3).size());
        }
      }
      else
      {
        if (this.oBa != 2)
        {
          localObject2 = com.tencent.mm.plugin.report.service.h.nFQ;
          localObject3 = com.tencent.mm.plugin.sns.data.i.fN(com.tencent.mm.plugin.sns.data.i.Ng(this.oUs.bRV));
          if (this.ovV != null) {
            break label2990;
          }
          localObject1 = "";
          ((com.tencent.mm.plugin.report.service.h)localObject2).f(14655, new Object[] { localObject3, localObject1, Integer.valueOf(this.oUs.oKO), Integer.valueOf(this.oUs.oKP), Long.valueOf(this.diQ), Integer.valueOf(this.oDu), this.oUs.ggA });
        }
        jt(true);
        this.hIf = true;
      }
    }
    else
    {
      long l;
      if ((this.source == 1) || (this.source == 2) || (this.source == 16) || (this.source == 14) || (this.source == 9) || (this.source == 10))
      {
        l = 0L;
        if (this.oUH != null)
        {
          l = this.oUH.field_snsId;
          if (TextUtils.isEmpty(this.oAl)) {
            this.oAl = AdLandingPagesProxy.getInstance().getSnsAid(this.bRV);
          }
          if (TextUtils.isEmpty(this.fLi)) {
            this.fLi = AdLandingPagesProxy.getInstance().getSnsTraceid(this.bRV);
          }
          this.oAE = AdLandingPagesProxy.getInstance().getSnsAdType(this.bRV);
          this.oAm = AdLandingPagesProxy.getInstance().getSnsAdCanvasExtXml(this.bRV);
        }
        if (this.oUp != null)
        {
          localObject1 = this.oUp;
          this.values.put("." + this.oUj + ".originSnsId", localObject1);
          this.values.put("." + this.oUj + ".originUxInfo", this.ovV);
          localObject2 = "<" + this.oUj + ">";
          localObject2 = (String)localObject2 + String.format("<originSnsId>%s</originSnsId>", new Object[] { localObject1 });
          localObject2 = (String)localObject2 + String.format("<originUxInfo>%s</originUxInfo>", new Object[] { this.ovV });
          localObject2 = (String)localObject2 + String.format("<originAdType>%d</originAdType>", new Object[] { Integer.valueOf(this.oAE) });
          localObject2 = (String)localObject2 + String.format("<originAid>%s</originAid>", new Object[] { this.oAl });
          localObject3 = (String)localObject2 + String.format("<originTraceId>%s</originTraceId>", new Object[] { this.fLi });
          localObject2 = localObject3;
          if (!bk.bl(this.oAm)) {
            localObject2 = (String)localObject3 + String.format("<originAdCanvasExt>%s</originAdCanvasExt>", new Object[] { this.oAm });
          }
          this.oUi = this.oUi.replace("<" + this.oUj + ">", (CharSequence)localObject2);
          this.oUs.ovV = this.ovV;
          this.oUs.bRV = ((String)localObject1);
        }
      }
      for (;;)
      {
        if (bk.bl(this.oUs.bRV)) {
          this.oUs.bRV = getIntent().getStringExtra("sns_landing_pages_rawSnsId");
        }
        this.oUs.oKX = AdLandingPagesProxy.getInstance().getSnsStatExtBySnsId(bk.ZS(this.oUs.bRV));
        this.jxS = bk.aM((String)this.values.get("." + this.oUj + ".adCanvasInfo.shareTitle"), "");
        this.jxR = bk.aM((String)this.values.get("." + this.oUj + ".adCanvasInfo.shareWebUrl"), "");
        this.oBT = bk.aM((String)this.values.get("." + this.oUj + ".adCanvasInfo.shareDesc"), "");
        this.oDw = bk.ZR(bk.aM((String)this.values.get("." + this.oUj + ".adCanvasInfo.bizId"), ""));
        this.oUw = bk.aM((String)this.values.get("." + this.oUj + ".adCanvasInfo.shareAppId"), "");
        this.oUx = bk.aM((String)this.values.get("." + this.oUj + ".adCanvasInfo.shareType"), "");
        this.oUy = bk.aM((String)this.values.get("." + this.oUj + ".adCanvasInfo.userInfo"), "");
        this.oUB = bk.ZR(bk.aM((String)this.values.get("." + this.oUj + ".adCanvasInfo.disableShareBitSet"), ""));
        this.oUC = bk.ZR(bk.aM((String)this.values.get("." + this.oUj + ".adCanvasInfo.statusBarStyle"), ""));
        localObject1 = this.values;
        localObject2 = "." + this.oUj;
        localObject3 = (String)((Map)localObject1).get((String)localObject2 + ".adCanvasInfo.arrowDownIconStyle.iconUrl");
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          break label2502;
        }
        this.oJn = null;
        this.uin = AdLandingPagesProxy.getInstance().getUin();
        this.oUz = bk.aM((String)this.values.get("." + this.oUj + ".adCanvasInfo.officialSyncBuffer"), "");
        bId();
        getIntent().putExtra("sns_landing_pages_adType", this.oAE);
        getIntent().putExtra("sns_landing_pages_rawSnsId", this.oUs.bRV);
        if (bk.bl(this.oAl)) {
          this.oAl = bk.aM((String)this.values.get("." + this.oUj + ".originAid"), "");
        }
        if (bk.bl(this.fLi)) {
          this.fLi = bk.aM((String)this.values.get("." + this.oUj + ".originTraceId"), "");
        }
        this.oUb = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.r(this.oUi, this.oUj, this.oAl, this.fLi);
        if (this.oUb.size() > 0)
        {
          localObject2 = "";
          localObject3 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.oUb.get(0);
          localObject1 = localObject2;
          if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject3).oKx.size() > 0)
          {
            localObject3 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject3).oKx.get(0);
            if (!(localObject3 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)) {
              break label2804;
            }
            this.oUo = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject3).oCV;
            localObject1 = localObject2;
          }
          if (this.oUH != null)
          {
            localObject2 = this.oUH.bGe();
            if ((localObject2 != null) && (((bxk)localObject2).tNr != null) && (((bxk)localObject2).tNr.sPJ != null) && (!((bxk)localObject2).tNr.sPJ.isEmpty()))
            {
              localObject3 = (awd)((bxk)localObject2).tNr.sPJ.getFirst();
              localObject2 = an.eJ(AdLandingPagesProxy.getInstance().getAccSnsPath(), ((awd)localObject3).lsK) + com.tencent.mm.plugin.sns.data.i.j((awd)localObject3);
              localObject3 = ((awd)localObject3).kSC;
              if (((String)localObject1).equals(localObject3))
              {
                localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.eT("adId", (String)localObject3);
                if ((!e.bK((String)localObject1)) && (e.bK((String)localObject2)))
                {
                  com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsAdNativeLandingPagesUI", "copy outsideFiel:%s->%s", new Object[] { localObject2, localObject1 });
                  e.r((String)localObject2, (String)localObject1);
                }
              }
            }
          }
        }
        this.oUk = bk.aM((String)this.values.get("." + this.oUj + ".adCanvasInfo.rightBarTitle"), "");
        this.oUl = bk.aM((String)this.values.get("." + this.oUj + ".adCanvasInfo.rightBarCanvasId"), "");
        this.oUm = bk.aM((String)this.values.get("." + this.oUj + ".adCanvasInfo.rightBarCanvasExt"), "");
        break;
        localObject1 = String.valueOf(l);
        break label678;
        this.oUs.bRV = ((String)this.values.get("." + this.oUj + ".originSnsId"));
        this.oUs.ovV = ((String)this.values.get("." + this.oUj + ".originUxInfo"));
        this.ovV = this.oUs.ovV;
        this.oAE = bk.ZR((String)this.values.get("." + this.oUj + ".originAdType"));
        localObject1 = Pattern.compile("<originAdCanvasExt>[\\s\\S]*</originAdCanvasExt>").matcher(this.oUi);
        if (((Matcher)localObject1).find())
        {
          localObject1 = ((Matcher)localObject1).group();
          if (!bk.bl((String)localObject1)) {
            this.oAm = ((String)localObject1).replaceAll("</?originAdCanvasExt>", "");
          }
        }
      }
      if (this.oJn == null) {
        this.oJn = new z();
      }
      this.oJn.iconUrl = ((String)localObject3);
      k = bk.ZR((String)((Map)localObject1).get((String)localObject2 + ".adCanvasInfo.sizeType"));
      i = bk.ZR((String)((Map)localObject1).get((String)localObject2 + ".adCanvasInfo.basicRootFontSize"));
      j = bk.ZR((String)((Map)localObject1).get((String)localObject2 + ".adCanvasInfo.basicWidth"));
      if ((i != 0) || (k != 1)) {
        break label3005;
      }
      i = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.oKB;
    }
    label2983:
    label2990:
    label2999:
    label3005:
    for (;;)
    {
      if ((j == 0) && (k == 1)) {
        j = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.oKA;
      }
      for (;;)
      {
        this.oJn.oDj = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(bk.ZT((String)((Map)localObject1).get((String)localObject2 + ".adCanvasInfo.arrowDownIconStyle.paddingBottom")), k, j, i);
        this.oJn.width = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(bk.ZT((String)((Map)localObject1).get((String)localObject2 + ".adCanvasInfo.arrowDownIconStyle.layoutWidth")), k, j, i);
        this.oJn.height = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(bk.ZT((String)((Map)localObject1).get((String)localObject2 + ".adCanvasInfo.arrowDownIconStyle.layoutHeight")), k, j, i);
        break label1648;
        label2804:
        if ((localObject3 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o))
        {
          this.oUo = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject3).oCV;
          localObject1 = localObject2;
          break label1963;
        }
        if ((localObject3 instanceof q))
        {
          this.oUo = ((q)localObject3).oCY;
          localObject1 = ((q)localObject3).oCX;
          break label1963;
        }
        localObject1 = localObject2;
        if (!(localObject3 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)) {
          break label1963;
        }
        localObject3 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)localObject3;
        localObject1 = localObject2;
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)localObject3).oCS.isEmpty()) {
          break label1963;
        }
        localObject3 = (m)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)localObject3).oCS.getFirst();
        localObject1 = localObject2;
        if (((m)localObject3).oCS.isEmpty()) {
          break label1963;
        }
        localObject3 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)((m)localObject3).oCS.getFirst();
        localObject1 = localObject2;
        if (!(localObject3 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)) {
          break label1963;
        }
        this.oUo = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject3).oCV;
        localObject1 = localObject2;
        break label1963;
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b)localObject2).a(localg);
        break label355;
        bIg();
        break label387;
        localObject1 = this.ovV;
        break label427;
        break;
      }
    }
  }
  
  private void bIc()
  {
    Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c)this.oUA.getAdapter();
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c)localObject).oJM.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b)((Iterator)localObject).next();
        if ((localb.oJm != null) && (localb.getUserVisibleHint())) {
          localb.oJm.bFI();
        }
      }
    }
  }
  
  private void bId()
  {
    if ((bk.bl(this.ggB)) && (!bk.bl(this.oAm))) {
      this.ggB = String.format("<ADInfo><adCanvasExt>%s</adCanvasExt></ADInfo>", new Object[] { this.oAm });
    }
    Map localMap;
    HashMap localHashMap;
    String str2;
    int i;
    if (!bk.bl(this.ggB))
    {
      localMap = bn.s(this.ggB, "ADInfo");
      this.ovV = bk.aM((String)localMap.get("." + "ADInfo" + ".uxInfo"), "");
      this.oUs.ovV = this.ovV;
      this.oAl = bk.aM((String)localMap.get("." + "ADInfo" + ".session_data.aid"), "");
      this.fLi = bk.aM((String)localMap.get("." + "ADInfo" + ".session_data.trace_id"), "");
      localHashMap = new HashMap();
      str2 = "." + "ADInfo" + ".adCanvasExt.adCardItemList.cardItem";
      i = 0;
      if (i <= 0) {
        break label860;
      }
    }
    label704:
    label860:
    for (String str1 = str2 + i;; str1 = str2)
    {
      if (localMap.containsKey(str1 + ".cardTpId"))
      {
        String str3 = bk.aM((String)localMap.get(str1 + ".cardTpId"), "");
        str1 = bk.aM((String)localMap.get(str1 + ".cardExt"), "");
        if ((!bk.bl(str3)) && (!bk.bl(str1))) {
          localHashMap.put(str3, str1);
        }
        i += 1;
        break;
      }
      this.oUr = localHashMap;
      str1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.r(this.oUi, localHashMap);
      if (!bk.bl(str1)) {
        this.oUi = str1;
      }
      if (!bk.bl(this.oAl))
      {
        if (this.oUi.contains("<originAid>")) {
          this.oUi = this.oUi.replaceFirst("<originAid>[\\s\\S]*</originAid>", "<originAid>" + this.oAl + "</originAid>");
        }
      }
      else if (!bk.bl(this.fLi)) {
        if (!this.oUi.contains("<originTraceId>")) {
          break label704;
        }
      }
      for (this.oUi = this.oUi.replaceFirst("<originTraceId>[\\s\\S]*</originTraceId>", "<originTraceId>" + this.fLi + "</originTraceId>");; this.oUi = this.oUi.replace("<" + this.oUj + ">", "<" + this.oUj + "><originTraceId>" + this.fLi + "</originTraceId>"))
      {
        if (!bk.bl(this.ovV))
        {
          if (!this.oUi.contains("<originUxInfo>")) {
            break label783;
          }
          this.oUi = this.oUi.replaceFirst("<originUxInfo>[\\s\\S]*</originUxInfo>", "<originUxInfo>" + this.ovV + "</originUxInfo>");
        }
        return;
        this.oUi = this.oUi.replace("<" + this.oUj + ">", "<" + this.oUj + "><originAid>" + this.oAl + "</originAid>");
        break;
      }
      this.oUi = this.oUi.replace("<" + this.oUj + ">", "<" + this.oUj + "><originUxInfo>" + this.ovV + "</originUxInfo>");
      return;
    }
  }
  
  private void bIe()
  {
    if (this.oUb != null)
    {
      Iterator localIterator = this.oUb.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localIterator.next()).oKx;
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          label48:
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s locals;
          if (((Iterator)localObject).hasNext())
          {
            locals = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)((Iterator)localObject).next();
            if (this.oDu != 0) {
              break label124;
            }
          }
          label124:
          for (int i = this.source;; i = this.oDu)
          {
            locals.yb(i);
            locals.jm(oUq);
            locals.On(this.ovV);
            locals.Oo(this.uin);
            locals.yc(this.oDw);
            break label48;
            break;
          }
        }
      }
    }
  }
  
  private List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g> bIf()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.oUb.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g localg = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localIterator.next();
      if (localg.oKy) {
        localArrayList.add(localg);
      }
    }
    return localArrayList;
  }
  
  private void bIg()
  {
    bIe();
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c localc = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c)this.oUA.getAdapter();
    if (localc == null)
    {
      localc = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c(getSupportFragmentManager(), new ArrayList());
      this.oUA.setAdapter(localc);
    }
    for (;;)
    {
      List localList = bIf();
      int i = 0;
      if (i < localList.size())
      {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g localg = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.oUb.get(i);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsAdNativeLandingPagesUI", "loadLandingPages load id %s", new Object[] { Integer.valueOf(localg.id) });
        Object localObject = (Fragment)this.oUQ.get(Integer.valueOf(localg.id));
        boolean bool;
        label190:
        label214:
        label233:
        int j;
        if (localObject == null)
        {
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b localb = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b();
          Bundle localBundle = new Bundle();
          localBundle.putSerializable("pageInfo", localg);
          localBundle.putSerializable("viewPager", this.oUA);
          localBundle.putSerializable("pageDownIconInfo", this.oJn);
          if (i == 0)
          {
            bool = true;
            localBundle.putBoolean("is_first_show_page", bool);
            if (i != localList.size() - 1) {
              break label341;
            }
            bool = true;
            localBundle.putBoolean("is_last_shown_page", bool);
            if (i != 0) {
              break label346;
            }
            localObject = this.oUN;
            localBundle.putSerializable("lifecyleListener", (Serializable)localObject);
            localBundle.putBoolean("needEnterAnimation", this.oUh);
            localBundle.putBoolean("needDirectionAnimation", bIj());
            if (i != 0) {
              break label352;
            }
            j = this.oUu;
            label276:
            localBundle.putInt("groupListCompShowIndex", j);
            localb.setArguments(localBundle);
            this.oUQ.put(Integer.valueOf(localg.id), localb);
            localObject = localb;
          }
        }
        for (;;)
        {
          if (localObject != null) {
            localc.a((Fragment)localObject, i);
          }
          i += 1;
          break;
          bool = false;
          break label190;
          label341:
          bool = false;
          break label214;
          label346:
          localObject = null;
          break label233;
          label352:
          j = 0;
          break label276;
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b)localObject).a(localg);
        }
      }
      localc.notifyDataSetChanged();
      this.oUA.setOffscreenPageLimit(localList.size());
      return;
    }
  }
  
  private List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i> bIh()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c)this.oUA.getAdapter();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c)localObject).oJM.iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.addAll(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b)((Iterator)localObject).next()).bFL());
      }
    }
    return localArrayList;
  }
  
  private void bIi()
  {
    int i;
    if (!bIk()) {
      if (Build.VERSION.SDK_INT >= 21)
      {
        i = getResources().getColor(i.c.white);
        if ((this.oUb == null) || (this.oUb.size() <= 0) || (bk.bl(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.oUb.getFirst()).fNR))) {
          break label157;
        }
        i = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.oUb.getFirst()).fNR);
      }
    }
    label157:
    for (;;)
    {
      getWindow().addFlags(-2147483648);
      getWindow().setStatusBarColor(i);
      int j = getWindow().getDecorView().getSystemUiVisibility();
      i = j;
      if (Build.VERSION.SDK_INT >= 16) {
        i = j & 0xFFFFF9F9;
      }
      j = i;
      if (Build.VERSION.SDK_INT >= 23) {
        j = i | 0x2000;
      }
      getWindow().getDecorView().setSystemUiVisibility(j);
      return;
      ad.N(this);
      return;
    }
  }
  
  private boolean bIj()
  {
    return (this.oUB & 0x8) == 0;
  }
  
  private boolean bIk()
  {
    return this.oUC == 0;
  }
  
  private boolean bIl()
  {
    return (!bk.bl(this.oUk)) && (!bk.bl(this.oUl));
  }
  
  private boolean bIm()
  {
    return (this.oUB & 0x10) == 0;
  }
  
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b bIn()
  {
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b localb = null;
    if (this.oUb.size() > 0) {
      localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b)this.oUQ.get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.oUb.get(this.oUA.getCurrentItem())).id));
    }
    return localb;
  }
  
  private SnsAdNativeLandingPagesUI.a bIo()
  {
    Object localObject = new com.tencent.mm.plugin.sns.storage.b(this.oUi);
    if (((com.tencent.mm.plugin.sns.storage.b)localObject).bEM())
    {
      int i = AdLandingPagesProxy.getInstance().getAdVoteIndex(((com.tencent.mm.plugin.sns.storage.b)localObject).oBH.oBR, this.ovV, this.uin);
      if ((i > 0) && (i <= ((com.tencent.mm.plugin.sns.storage.b)localObject).oBH.oBS.size()))
      {
        localObject = (b.g)((com.tencent.mm.plugin.sns.storage.b)localObject).oBH.oBS.get(i - 1);
        SnsAdNativeLandingPagesUI.a locala = new SnsAdNativeLandingPagesUI.a(this, (byte)0);
        if (!bk.bl(((b.g)localObject).jxS))
        {
          locala.jxS = ((b.g)localObject).jxS;
          if (bk.bl(((b.g)localObject).oBT)) {
            break label153;
          }
          locala.oBT = ((b.g)localObject).oBT;
          label122:
          if (bk.bl(((b.g)localObject).oBU)) {
            break label164;
          }
        }
        label153:
        label164:
        for (locala.oBU = ((b.g)localObject).oBU;; locala.oBU = this.oUo)
        {
          return locala;
          locala.jxS = this.jxS;
          break;
          locala.oBT = this.oBT;
          break label122;
        }
      }
    }
    return null;
  }
  
  private String bIp()
  {
    Object localObject = new bvo();
    ((bvo)localObject).tMm = new bvp();
    ((bvo)localObject).tMm.tMq = this.oUs.ovV;
    ((bvo)localObject).tMm.tMp = this.oUs.bRV;
    ((bvo)localObject).tMm.oAE = this.oAE;
    try
    {
      localObject = Base64.encodeToString(((bvo)localObject).toByteArray(), 2);
      return localObject;
    }
    catch (Exception localException) {}
    return "";
  }
  
  private String bIq()
  {
    return this.oUi.replaceAll("(?s)<adCanvasInfoLeft[^>]*>.*?</adCanvasInfoLeft>", "").replaceAll("(?s)<adCanvasInfoRight[^>]*>.*?</adCanvasInfoRight>", "");
  }
  
  private void wn()
  {
    Object localObject3 = bIh();
    this.gYS += System.currentTimeMillis() - this.startTime;
    this.oUs.oKV = ((int)this.gYS);
    Object localObject1 = this.oUs;
    int j;
    if (this.oUb == null)
    {
      j = 0;
      ((k)localObject1).oKU = j;
      localObject1 = this.oUs;
      localObject2 = new JSONArray();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i)((Iterator)localObject3).next();
        if (!((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i)localObject4).bFm().oDt)
        {
          JSONObject localJSONObject = new JSONObject();
          if (!((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i)localObject4).v((JSONArray)localObject2))
          {
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i)localObject4).ah(localJSONObject)) {
              ((JSONArray)localObject2).put(localJSONObject);
            }
            if ((localObject4 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o))
            {
              localObject4 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o)localObject4).bFx().iterator();
              while (((Iterator)localObject4).hasNext()) {
                ((JSONArray)localObject2).put((JSONObject)((Iterator)localObject4).next());
              }
            }
          }
        }
      }
    }
    Object localObject2 = this.oUb.iterator();
    for (int i = 0;; i = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)((Iterator)localObject2).next()).oKx.size() + i)
    {
      j = i;
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
    }
    ((k)localObject1).oKW = ((JSONArray)localObject2).toString();
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AdLandingPagesReportInfo", "componentsStatStr:%s", new Object[] { ((k)localObject1).oKW });
    if (!bk.bl(((k)localObject1).oKW)) {}
    try
    {
      ((k)localObject1).oKW = URLEncoder.encode(((k)localObject1).oKW, "UTF-8");
      localObject1 = this.oUs.bFW();
      if (this.oDw == 2)
      {
        AdLandingPagesProxy.getInstance().doCgiReportCanvasBrowseInfo(15041, (String)localObject1);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsAdNativeLandingPagesUI", "post cgi stat 15041 data: " + (String)localObject1);
        return;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AdLandingPagesReportInfo", "not support encode " + localUnsupportedEncodingException.toString());
      }
      if (AdLandingPagesProxy.getInstance().isRecExpAd(this.oUs.bRV))
      {
        com.tencent.mm.plugin.report.service.h.nFQ.aC(14650, localUnsupportedEncodingException);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 14650 data: " + localUnsupportedEncodingException);
        return;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.aC(13387, localUnsupportedEncodingException);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 13387 data: " + localUnsupportedEncodingException);
    }
  }
  
  public final void a(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s params, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, final boolean paramBoolean3)
  {
    if ((this.oUS != null) && (!paramBoolean3))
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.SnsAdNativeLandingPagesUI", "bottom sheet appear several times");
      this.oUS.bFp();
      if (this.oUT != null)
      {
        this.oUT.dismiss();
        this.oUT = null;
      }
    }
    label350:
    for (;;)
    {
      return;
      AdLandingPagesProxy.a local8 = new AdLandingPagesProxy.a()
      {
        public final void U(Object paramAnonymousObject) {}
        
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
        {
          SnsAdNativeLandingPagesUI.this.jt(false);
          if (paramBoolean3)
          {
            if (SnsAdNativeLandingPagesUI.J(SnsAdNativeLandingPagesUI.this) != null) {
              SnsAdNativeLandingPagesUI.J(SnsAdNativeLandingPagesUI.this).bFp();
            }
            if (SnsAdNativeLandingPagesUI.K(SnsAdNativeLandingPagesUI.this) != null)
            {
              SnsAdNativeLandingPagesUI.K(SnsAdNativeLandingPagesUI.this).dismiss();
              SnsAdNativeLandingPagesUI.L(SnsAdNativeLandingPagesUI.this);
            }
          }
        }
      };
      int i;
      if (!paramBoolean3)
      {
        AppCompatActivity localAppCompatActivity = this.mController.uMN;
        LinearLayout localLinearLayout = new LinearLayout(this.mController.uMN);
        com.tencent.mm.ui.y.gt(this.mController.uMN);
        if (bk.bl(params.oDp)) {
          break label236;
        }
        i = Color.parseColor(params.oDp);
        label119:
        params = al.a(localAppCompatActivity, params, localLinearLayout, i);
        this.oUS = new j(this.mController.uMN, params, paramString1, paramString2, paramString3, paramBoolean1, paramBoolean2);
        params = params.getView();
        this.oUS.oFO = new SnsAdNativeLandingPagesUI.9(this, params);
        params = this.oUS;
        if ((params.ipf != null) && (params.oFJ != null)) {
          break label242;
        }
      }
      for (;;)
      {
        if (bk.bl(paramString1)) {
          break label350;
        }
        AdLandingPagesProxy.getInstance().doFavOfficialItemScene(paramString1, local8);
        if (!paramBoolean3) {
          break;
        }
        this.oUT = com.tencent.mm.ui.base.h.b(this, getString(i.j.sns_loading), false, null);
        return;
        label236:
        i = -1;
        break label119;
        label242:
        params.oFJ.getWindow().setFlags(8, 8);
        params.oFJ.getWindow().addFlags(131200);
        if (params.oFO != null)
        {
          params.oFJ.setOnDismissListener(new j.4(params));
          params.oFJ.setOnCancelListener(new j.5(params));
        }
        params.oFJ.setContentView(params.ipf);
        BottomSheetBehavior.i((View)params.ipf.getParent()).u(ad.ed(params.mContext)[1]);
        params.oFJ.show();
      }
    }
  }
  
  public final void aBR()
  {
    bIc();
    wn();
    this.oUt = true;
    AdLandingPagesProxy.getInstance().clearDownloadCallback();
    if (!this.oUh)
    {
      finish();
      return;
    }
    if (this.oUK)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsAdNativeLandingPagesUI", "is playing animation");
      return;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsAdNativeLandingPagesUI", "run exit animation, %s", new Object[] { Boolean.valueOf(this.oUh) });
    this.oUK = true;
    if (isSupportNavigationSwipeBack()) {
      getSwipeBackLayout().setEnableGesture(false);
    }
    Iterator localIterator = bIn().bFL().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i locali = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i)localIterator.next();
      if ((locali instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a))
      {
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)locali).bER();
        locali.bFo();
      }
    }
    ai.l(new SnsAdNativeLandingPagesUI.3(this), 30L);
  }
  
  protected boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return i.g.sns_ad_native_landing_pages_ui;
  }
  
  @TargetApi(16)
  protected final void initView()
  {
    super.initView();
    this.khn = findViewById(i.f.root);
    this.oUF = findViewById(i.f.content_container);
    this.oUA = ((AdlandingDummyViewPager)findViewById(i.f.vertical_viewpager));
    this.oUE = findViewById(i.f.menu_container);
    this.oUd = ((ImageView)findViewById(i.f.sns_ad_native_landing_pages_close_mask_img));
    Object localObject = this.oUA;
    ViewPager.e locale = this.oUO;
    ((AdlandingDummyViewPager)localObject).oJa.add(locale);
    if ((this.oDw == 2) && (!bIk()))
    {
      localObject = (FrameLayout.LayoutParams)this.oUA.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).setMargins(0, 0, 0, aq.gv(this));
      this.oUA.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (ak.gC(this.mController.uMN))
    {
      localObject = (FrameLayout.LayoutParams)this.oUE.getLayoutParams();
      i = ((FrameLayout.LayoutParams)localObject).topMargin;
      int j = ak.gB(this.mController.uMN);
      ((FrameLayout.LayoutParams)localObject).setMargins(((FrameLayout.LayoutParams)localObject).leftMargin, i + j, ((FrameLayout.LayoutParams)localObject).rightMargin, ((FrameLayout.LayoutParams)localObject).bottomMargin);
      this.oUE.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (FrameLayout.LayoutParams)this.oUA.getLayoutParams();
      i = ((FrameLayout.LayoutParams)localObject).topMargin;
      j = ak.gB(this.mController.uMN);
      ((FrameLayout.LayoutParams)localObject).setMargins(((FrameLayout.LayoutParams)localObject).leftMargin, i + j, ((FrameLayout.LayoutParams)localObject).rightMargin, ((FrameLayout.LayoutParams)localObject).bottomMargin);
      this.oUA.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (FrameLayout.LayoutParams)this.oUd.getLayoutParams();
      i = ((FrameLayout.LayoutParams)localObject).topMargin;
      j = ak.gB(this.mController.uMN);
      ((FrameLayout.LayoutParams)localObject).setMargins(((FrameLayout.LayoutParams)localObject).leftMargin, i + j, ((FrameLayout.LayoutParams)localObject).rightMargin, ((FrameLayout.LayoutParams)localObject).bottomMargin);
      this.oUd.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.kgw = ((ImageView)findViewById(i.f.gallery_bg));
    this.oUe = ((ImageView)findViewById(i.f.anim_bg));
    this.iaw = ((ImageView)findViewById(i.f.sns_ad_native_landing_pages_close_img));
    this.iaw.setOnClickListener(new SnsAdNativeLandingPagesUI.15(this));
    this.oUc = ((ImageView)findViewById(i.f.sns_ad_native_landing_pages_more_img));
    int i = i.c.white;
    if (!bIk())
    {
      i = getResources().getColor(i.c.black);
      if ((this.oUb == null) || (this.oUb.size() <= 0) || (bk.bl(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.oUb.getFirst()).fNR))) {
        break label741;
      }
      i = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.oUb.getFirst()).fNR);
    }
    label729:
    label741:
    for (;;)
    {
      this.oUd.setBackgroundColor(i);
      i = i.c.black;
      localObject = this.iaw.getDrawable();
      if (localObject != null)
      {
        android.support.v4.a.a.a.a((Drawable)localObject, android.support.v4.content.b.i(this, i));
        this.iaw.setImageDrawable((Drawable)localObject);
      }
      localObject = this.oUc.getDrawable();
      if (localObject != null)
      {
        android.support.v4.a.a.a.a((Drawable)localObject, android.support.v4.content.b.i(this, i));
        this.oUc.setImageDrawable((Drawable)localObject);
      }
      this.oUf = ((TextView)findViewById(i.f.sns_ad_native_landing_pages_right_bar_title));
      if ((bIl()) && (!bIm()) && (this.oDw == 2))
      {
        this.oUc.setVisibility(8);
        this.oUf.setVisibility(0);
        this.oUf.setText(this.oUk);
        this.oUf.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            SnsAdNativeLandingPagesUI.this.r(SnsAdNativeLandingPagesUI.this, SnsAdNativeLandingPagesUI.r(SnsAdNativeLandingPagesUI.this), SnsAdNativeLandingPagesUI.s(SnsAdNativeLandingPagesUI.this));
          }
        });
      }
      for (;;)
      {
        this.oUn = ((ImageView)findViewById(i.f.sns_native_landing_first_screen_next_img));
        if (this.oUh)
        {
          this.khn.setAlpha(0.0F);
          this.kgw.setAlpha(0.0F);
          com.tencent.mm.ui.base.b.a(this, null);
        }
        return;
        if (this.oUB != 0) {
          if (((this.oUB & 0x4) == 0) || ((this.oUB & 0x2) == 0) || ((bIm()) && (this.oDw == 2)) || ((this.oUB & 0x1) == 0)) {
            i = 1;
          }
        }
        for (;;)
        {
          if (i == 0) {
            break label729;
          }
          this.oUc.setOnClickListener(new SnsAdNativeLandingPagesUI.17(this));
          break;
          i = 0;
          continue;
          i = 1;
        }
        this.oUc.setVisibility(8);
      }
    }
  }
  
  public final void jt(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.oDw == 1)) {
      AdLandingPagesProxy.getInstance().doDynamicUpdateScene(this.oUw, this.oUx, this.oUy, this.oUP);
    }
    if ((this.oDw == 2) && (!bk.bl(this.oUz))) {
      AdLandingPagesProxy.getInstance().doSearchDynamicUpdateScene(this.oUz, this.oUP);
    }
    this.oUv = true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1) {
      if (paramInt2 == -1) {
        com.tencent.mm.ui.base.h.bC(this.mController.uMN, this.mController.uMN.getString(i.j.app_shared));
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      int i;
      if (paramInt1 == 2)
      {
        if (paramIntent.getBooleanExtra("kfavorite", false))
        {
          i = AdLandingPagesProxy.getInstance().doFav(paramIntent, 42);
          ((v)com.tencent.mm.kernel.g.r(v.class)).a(i, this, this.kNz);
        }
      }
      else if (paramInt1 == x.oHT) {
        try
        {
          Object localObject = paramIntent.getStringExtra("KComponentCid");
          Iterator localIterator = bIh().iterator();
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i locali;
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            locali = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i)localIterator.next();
          } while (!locali.bFn().equals(localObject));
          localObject = (x)locali;
          i = paramIntent.getIntExtra("KStreamVideoPlayCount", 0);
          int j = paramIntent.getIntExtra("KStreamVideoPlayCompleteCount", 0);
          int k = paramIntent.getIntExtra("KStreamVideoTotalPlayTimeInMs", 0);
          ((x)localObject).olt = (i + ((x)localObject).olt);
          ((x)localObject).olu += j;
          ((x)localObject).olv += k;
        }
        catch (Exception localException) {}
      }
    }
  }
  
  public void onBackPressed()
  {
    aBR();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.startTime = System.currentTimeMillis();
    this.diQ = System.currentTimeMillis();
    this.oUs.diQ = this.diQ;
    new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.a(this);
    bIi();
    Object localObject = ad.ed(this);
    this.gHR = localObject[0];
    this.gHS = localObject[1];
    this.oUg = paramBundle;
    this.mController.hideTitleView();
    this.itB = getIntent().getIntExtra("img_gallery_top", 0);
    this.itC = getIntent().getIntExtra("img_gallery_left", 0);
    this.itD = getIntent().getIntExtra("img_gallery_width", 0);
    this.itE = getIntent().getIntExtra("img_gallery_height", 0);
    getWindow().addFlags(128);
    this.source = getIntent().getIntExtra("sns_landig_pages_from_source", 0);
    this.oDu = getIntent().getIntExtra("sns_landig_pages_origin_from_source", 0);
    this.oUi = getIntent().getStringExtra("sns_landing_pages_xml");
    paramBundle = getIntent().getStringExtra("sns_landing_pages_too_large_xml_path");
    if ((bk.bl(this.oUi)) && (!bk.bl(paramBundle))) {
      this.oUi = ad.Ou(paramBundle);
    }
    if (bk.bl(this.oUi)) {
      finish();
    }
    for (;;)
    {
      initView();
      if (AdLandingPagesProxy.getInstance().isConnected()) {
        break;
      }
      AdLandingPagesProxy.getInstance().clearDownloadCallback();
      AdLandingPagesProxy.getInstance().connect(new SnsAdNativeLandingPagesUI.14(this));
      return;
      this.oUi = this.oUi.replaceAll("</*RecXml[\\s|\\S]*?>", "");
      this.oUs.ovY = getIntent().getStringExtra("sns_landing_pages_expid");
      this.oUj = getIntent().getStringExtra("sns_landing_pages_xml_prefix");
      this.bRV = getIntent().getStringExtra("sns_landing_pages_share_sns_id");
      this.oUp = getIntent().getStringExtra("sns_landing_pages_rawSnsId");
      this.ovV = getIntent().getStringExtra("sns_landing_pages_ux_info");
      this.oAl = getIntent().getStringExtra("sns_landing_pages_aid");
      this.fLi = getIntent().getStringExtra("sns_landing_pages_traceid");
      paramBundle = getIntent().getStringExtra("sns_landing_pages_search_extra");
      localObject = this.oUs;
      if (!TextUtils.isEmpty(paramBundle))
      {
        if (((k)localObject).extra.length() > 0) {
          ((k)localObject).extra += "&";
        }
        ((k)localObject).extra = (((k)localObject).extra + "searchextra=" + URLEncoder.encode(paramBundle));
      }
      paramBundle = getIntent().getStringExtra("sns_landing_pages_extra");
      localObject = this.oUs;
      if (!TextUtils.isEmpty(paramBundle)) {
        ((k)localObject).extra = (((k)localObject).extra + "&extra1=" + URLEncoder.encode(paramBundle));
      }
      oUq = getIntent().getBooleanExtra("sns_landing_is_native_sight_ad", false);
      this.oBa = getIntent().getIntExtra("sns_landing_pages_rec_src", 0);
      this.oUu = getIntent().getIntExtra("sns_landing_pages_from_outer_index", 0);
      this.ggB = getIntent().getStringExtra("sns_landing_pages_ad_info");
      this.oUh = getIntent().getBooleanExtra("sns_landing_pages_need_enter_and_exit_animation", false);
      if (this.oUh) {
        this.oUs.oKO = 0;
      }
      for (this.oUs.dip = 0;; this.oUs.dip = 1)
      {
        this.oUs.oKP = this.source;
        this.oUs.oKQ = 0;
        this.oUs.oKR = 0;
        this.oUs.oKS = 1;
        this.oUs.oKT = 0;
        this.oUs.oDu = this.oDu;
        if ((this.oUj == null) || ("".equals(this.oUi))) {
          this.oUj = "adxml";
        }
        if ((!bk.bl(this.oUi)) && (!bk.bl(this.oUj))) {
          break label798;
        }
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SnsAdNativeLandingPagesUI", "landingPagesXml is " + this.oUi + ",landingPagesXmlPrex is " + this.oUj);
        break;
        this.oUs.oKO = 1;
      }
      label798:
      this.values = bn.s(this.oUi, this.oUj);
      this.oUs.ggA = bk.aM((String)this.values.get("." + this.oUj + ".adCanvasInfo.canvasId"), "");
    }
    bIb();
  }
  
  protected void onDestroy()
  {
    getWindow().clearFlags(128);
    if (this.hIf)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsAdNativeLandingPagesUI", "the SnsAdNativeLadingPagesUI is destroy");
      if (!this.oUt)
      {
        bIc();
        wn();
      }
    }
    unregisterReceiver(this.oUR);
    AdLandingPagesProxy.getInstance().clearDownloadCallback();
    super.onDestroy();
  }
  
  public final void onKeyboardStateChanged()
  {
    super.onKeyboardStateChanged();
    if (this.oUA != null) {
      this.oUA.postDelayed(new SnsAdNativeLandingPagesUI.6(this), 500L);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.hIf) {
      this.gYS += System.currentTimeMillis() - this.startTime;
    }
    android.support.v4.content.d.Q(this).unregisterReceiver(this.oUL);
    android.support.v4.content.d.Q(this).unregisterReceiver(this.oUM);
    if (this.oUS != null) {
      this.oUS.bFp();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsAdNativeLandingPagesUI", "onResume");
    android.support.v4.content.d.Q(this).a(this.oUL, new IntentFilter("com.tencent.mm.adlanding.video_progressbar_change"));
    android.support.v4.content.d.Q(this).a(this.oUM, new IntentFilter("com.tencent.mm.adlanding.set_uioption"));
    if (this.hIf) {
      this.startTime = System.currentTimeMillis();
    }
    registerReceiver(this.oUR, new IntentFilter("android.intent.action.SCREEN_ON"));
    if (this.oUv) {
      jt(false);
    }
  }
  
  public void onSwipeBack()
  {
    this.oUs.dip = 2;
    k localk = this.oUs;
    localk.oKT += 1;
    super.onSwipeBack();
  }
  
  public final void r(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("sns_landig_pages_from_source", 14);
    int i;
    String str2;
    String str1;
    JSONObject localJSONObject;
    if (this.oDu == 0)
    {
      i = this.source;
      localIntent.putExtra("sns_landig_pages_origin_from_source", i);
      localIntent.putExtra("sns_landing_pages_canvasid", paramString1);
      localIntent.putExtra("sns_landing_pages_canvas_ext", paramString2);
      localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
      localIntent.putExtra("sns_landing_pages_no_store", 1);
      str2 = ((Activity)paramContext).getIntent().getStringExtra("sns_landing_pages_sessionId");
      paramString2 = ((Activity)paramContext).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
      if (!bk.bl(str2))
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
        if (bk.bl(paramString2)) {
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
      com.tencent.mm.br.d.b(paramContext, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
      return;
      i = this.oDu;
      break;
      paramString1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI
 * JD-Core Version:    0.7.0.1
 */