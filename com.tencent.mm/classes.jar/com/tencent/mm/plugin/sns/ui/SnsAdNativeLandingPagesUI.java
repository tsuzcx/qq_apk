package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.ViewPager.f;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.x;
import com.tencent.mm.g.a.oj;
import com.tencent.mm.g.a.oj.a;
import com.tencent.mm.g.a.ub;
import com.tencent.mm.g.a.ue;
import com.tencent.mm.g.a.uh;
import com.tencent.mm.plugin.fav.a.v;
import com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.FloatJumpCompHelper;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.model.AdlandingRemoteServiceConnectedReceiver;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ao;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aj;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdlandingDummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a;
import com.tencent.mm.plugin.sns.storage.b.b;
import com.tencent.mm.plugin.sns.storage.b.l;
import com.tencent.mm.plugin.sns.storage.b.m;
import com.tencent.mm.plugin.sns.ui.helper.FloatWebViewHelper;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.djc;
import com.tencent.mm.protocal.protobuf.djd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bi.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.b.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.snackbar.a.b;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
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
  public LinkedList<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g> AcY;
  public ac AoJ;
  private ImageView AoK;
  private TextView AoL;
  Bundle AoM;
  private boolean AoN;
  private boolean AoO;
  private String AoP;
  private String AoQ;
  private String AoR;
  private String AoS;
  private String AoT;
  private ImageView AoU;
  String AoV;
  String AoW;
  private boolean AoX;
  com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k AoY;
  private volatile boolean AoZ;
  Collection<String> ApA;
  private volatile boolean ApB;
  private volatile boolean ApC;
  private volatile boolean ApD;
  private aq ApE;
  private FloatWebViewHelper ApF;
  private com.tencent.mm.ui.widget.a.e ApG;
  private BroadcastReceiver ApH;
  private BroadcastReceiver ApI;
  private ContentFragment.a ApJ;
  private ViewPager.OnPageChangeListener ApK;
  private AdLandingPagesProxy.e ApL;
  private com.tencent.mm.sdk.b.c<oj> ApM;
  private com.tencent.mm.sdk.b.c<ub> ApN;
  private Runnable ApO;
  private bi.a ApP;
  private Map<Integer, ContentFragment> ApQ;
  public b.a ApR;
  private BroadcastReceiver ApS;
  private n ApT;
  private com.tencent.mm.ui.base.p ApU;
  public FloatJumpCompHelper ApV;
  boolean Apa;
  private int Apb;
  private boolean Apc;
  private String Apd;
  private String Ape;
  private String Apf;
  private String Apg;
  private AdlandingDummyViewPager Aph;
  private int Api;
  private int Apj;
  private aq Apk;
  private FrameLayout Apl;
  private View Apm;
  private View Apn;
  private boolean Apo;
  private List<m> App;
  private com.tencent.mm.plugin.sns.ui.b.c Apq;
  private com.tencent.mm.plugin.sns.ui.b.d Apr;
  private volatile boolean Aps;
  private boolean Apt;
  private Map<String, SnsAdLandingPageFloatView> Apu;
  private com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.a Apv;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d Apw;
  private boolean Apx;
  public boolean Apy;
  private boolean Apz;
  private boolean aMx;
  private String aQj;
  private int bizId;
  String dAg;
  private long dCI;
  private String dGD;
  private int doj;
  private long enterTime;
  private ImageView hai;
  private ImageView iXI;
  private volatile boolean isVisible;
  private String jWi;
  private String kwE;
  private int lxZ;
  private int lya;
  private int oMR;
  private int oMS;
  private int oMT;
  private int oMU;
  String qlv;
  String qlw;
  private long startTime;
  protected a.b ufz;
  private String uin;
  String uly;
  private Map<String, String> values;
  private ImageView xQh;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af zAi;
  private int zMQ;
  private String zMk;
  private String zMl;
  private int zNm;
  private int zRN;
  private String zRP;
  private String zRR;
  private Map<String, String> zRS;
  private ao zZV;
  private com.tencent.mm.plugin.sns.storage.p znm;
  
  public SnsAdNativeLandingPagesUI()
  {
    AppMethodBeat.i(98362);
    this.AcY = new LinkedList();
    this.oMR = 0;
    this.oMS = 0;
    this.oMT = 0;
    this.oMU = 0;
    this.AoN = false;
    this.AoO = false;
    this.AoX = false;
    this.dCI = 0L;
    this.enterTime = 0L;
    this.zRS = new HashMap();
    this.AoY = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k();
    this.AoZ = false;
    this.Apa = false;
    this.Apb = 0;
    this.Apc = false;
    this.Apk = new aq();
    this.Apo = true;
    this.aMx = false;
    this.Apu = new HashMap();
    this.Apx = false;
    this.Apy = false;
    this.Apz = false;
    this.ApA = new HashSet();
    this.isVisible = false;
    this.ApB = false;
    this.ApC = false;
    this.ApD = false;
    this.ApE = new aq();
    this.ApH = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        boolean bool = true;
        AppMethodBeat.i(98324);
        int i = com.tencent.mm.plugin.sns.ad.f.e.getIntExtra(paramAnonymousIntent, "show", 0);
        if ((SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this) == null) || (!(SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getAdapter() instanceof android.support.v4.app.i)))
        {
          ae.w("MicroMsg.SnsAdNativeLandingPagesUI", "videoProgressbarStatusChangeReceiver called ,but the viewpager or adapter is null!!");
          AppMethodBeat.o(98324);
          return;
        }
        paramAnonymousContext = (android.support.v4.app.i)SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getAdapter();
        int j = SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getCurrentItem();
        int k = paramAnonymousContext.getCount();
        if (j >= k)
        {
          ae.w("MicroMsg.SnsAdNativeLandingPagesUI", "videoProgressbarStatusChangeReceiver called ,current index is larger than item count!!!");
          AppMethodBeat.o(98324);
          return;
        }
        ae.d("MicroMsg.SnsAdNativeLandingPagesUI", "recv videoProgressbarStatusChangeReceiver show " + i + "the index is " + j + " the count is " + k);
        paramAnonymousContext = (ContentFragment)paramAnonymousContext.getItem(j);
        if (i == 1) {}
        for (;;)
        {
          SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this, bool);
          SnsAdNativeLandingPagesUI.this.Av(500L);
          paramAnonymousContext.rN(bool);
          AppMethodBeat.o(98324);
          return;
          bool = false;
        }
      }
    };
    this.ApI = new SnsAdNativeLandingPagesUI.12(this);
    this.ApJ = new ContentFragment.a()
    {
      public final void q(final ContentFragment paramAnonymousContentFragment)
      {
        AppMethodBeat.i(98351);
        paramAnonymousContentFragment = paramAnonymousContentFragment.getRecyclerView();
        if (paramAnonymousContentFragment != null) {
          paramAnonymousContentFragment.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(98350);
              ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "onPreDraw %d, %d", new Object[] { Integer.valueOf(SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).getHeight()), Integer.valueOf(SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this)) });
              Object localObject1 = null;
              Object localObject2 = SnsAdNativeLandingPagesUI.d(SnsAdNativeLandingPagesUI.this);
              int i;
              if (localObject2 != null)
              {
                localObject1 = ((ah)localObject2).eaR();
                if (localObject1 != null)
                {
                  localObject1 = ((t)localObject1).zOU;
                  localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.jI((String)localObject1, "scene_ad_landing");
                  localObject2 = new StringBuilder("onPreDraw, fullscreen, container.size=").append(SnsAdNativeLandingPagesUI.e(SnsAdNativeLandingPagesUI.this).getWidth()).append(", ").append(SnsAdNativeLandingPagesUI.e(SnsAdNativeLandingPagesUI.this).getHeight()).append(", shootImg.w=");
                  if (localObject1 == null) {
                    break label235;
                  }
                  i = ((Bitmap)localObject1).getWidth();
                  label150:
                  localObject2 = ((StringBuilder)localObject2).append(i).append(", shootImg.h=");
                  if (localObject1 == null) {
                    break label240;
                  }
                  i = ((Bitmap)localObject1).getHeight();
                  label170:
                  ae.i("SphereImageView.SnsAdNativeLandingPagesUI", i);
                }
              }
              else
              {
                if (!SnsAdNativeLandingPagesUI.f(SnsAdNativeLandingPagesUI.this)) {
                  break label245;
                }
                com.tencent.mm.sdk.platformtools.ar.o(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(98349);
                    Bitmap localBitmap;
                    if (this.Aqe != null) {
                      localBitmap = this.Aqe;
                    }
                    while (localBitmap != null)
                    {
                      SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).setAlpha(1.0F);
                      SnsAdNativeLandingPagesUI.h(SnsAdNativeLandingPagesUI.this).setImageBitmap(localBitmap);
                      SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this, SnsAdNativeLandingPagesUI.20.1.this.nfI, localBitmap.getWidth(), localBitmap.getHeight());
                      AppMethodBeat.o(98349);
                      return;
                      if (SnsAdNativeLandingPagesUI.g(SnsAdNativeLandingPagesUI.this))
                      {
                        localBitmap = com.tencent.mm.sdk.platformtools.h.fZ(SnsAdNativeLandingPagesUI.20.1.this.nfI.getChildAt(0));
                        SnsAdNativeLandingPagesUI.h(SnsAdNativeLandingPagesUI.this).setScaleType(ImageView.ScaleType.CENTER_CROP);
                      }
                      else
                      {
                        localBitmap = com.tencent.mm.sdk.platformtools.h.fZ(SnsAdNativeLandingPagesUI.e(SnsAdNativeLandingPagesUI.this));
                        SnsAdNativeLandingPagesUI.h(SnsAdNativeLandingPagesUI.this).setScaleType(ImageView.ScaleType.CENTER_CROP);
                      }
                    }
                    SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).setAlpha(1.0F);
                    AppMethodBeat.o(98349);
                  }
                }, 50L);
              }
              for (;;)
              {
                paramAnonymousContentFragment.getViewTreeObserver().removeOnPreDrawListener(this);
                AppMethodBeat.o(98350);
                return false;
                localObject1 = "";
                break;
                label235:
                i = 0;
                break label150;
                label240:
                i = 0;
                break label170;
                label245:
                SnsAdNativeLandingPagesUI.i(SnsAdNativeLandingPagesUI.this).setVisibility(0);
                SnsAdNativeLandingPagesUI.this.Av(300L);
              }
            }
          });
        }
        AppMethodBeat.o(98351);
      }
    };
    this.ApK = new ViewPager.f()
    {
      public final void onPageScrollStateChanged(int paramAnonymousInt)
      {
        AppMethodBeat.i(98353);
        super.onPageScrollStateChanged(paramAnonymousInt);
        SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this).Aad = paramAnonymousInt;
        Object localObject;
        if (paramAnonymousInt == 1)
        {
          paramAnonymousInt = 0;
          while (paramAnonymousInt < SnsAdNativeLandingPagesUI.this.AcY.size())
          {
            localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)SnsAdNativeLandingPagesUI.this.AcY.get(paramAnonymousInt);
            localObject = (Fragment)SnsAdNativeLandingPagesUI.k(SnsAdNativeLandingPagesUI.this).get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject).id));
            if (localObject != null) {
              ((ContentFragment)localObject).ebn();
            }
            paramAnonymousInt += 1;
          }
          an.gq(SnsAdNativeLandingPagesUI.this.getContext());
          AppMethodBeat.o(98353);
          return;
        }
        if (paramAnonymousInt == 0)
        {
          localObject = (Fragment)SnsAdNativeLandingPagesUI.k(SnsAdNativeLandingPagesUI.this).get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)SnsAdNativeLandingPagesUI.this.AcY.get(SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getCurrentItem())).id));
          if (localObject != null) {
            SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this, (ContentFragment)localObject);
          }
        }
        AppMethodBeat.o(98353);
      }
      
      public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
      {
        AppMethodBeat.i(98352);
        super.onPageScrolled(paramAnonymousInt1, paramAnonymousFloat, paramAnonymousInt2);
        if (SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this) != null)
        {
          ContentFragment localContentFragment = SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this);
          if ((localContentFragment.cCq) && (localContentFragment.zZT != null)) {
            localContentFragment.zZT.ebc();
          }
        }
        if (SnsAdNativeLandingPagesUI.this.keyboardState() == 1) {
          SnsAdNativeLandingPagesUI.this.hideVKB();
        }
        AppMethodBeat.o(98352);
      }
      
      public final void onPageSelected(int paramAnonymousInt)
      {
        AppMethodBeat.i(98354);
        super.onPageSelected(paramAnonymousInt);
        SnsAdNativeLandingPagesUI.this.hideVKB();
        int i = 0;
        if (i < SnsAdNativeLandingPagesUI.this.AcY.size())
        {
          Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)SnsAdNativeLandingPagesUI.this.AcY.get(i);
          localObject = (Fragment)SnsAdNativeLandingPagesUI.k(SnsAdNativeLandingPagesUI.this).get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject).id));
          if (localObject != null)
          {
            if (i != paramAnonymousInt) {
              break label98;
            }
            SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this, (ContentFragment)localObject);
          }
          for (;;)
          {
            i += 1;
            break;
            label98:
            ((ContentFragment)localObject).ebn();
          }
        }
        SnsAdNativeLandingPagesUI.this.Av(300L);
        AppMethodBeat.o(98354);
      }
    };
    this.ApL = new AdLandingPagesProxy.e()
    {
      public final void be(final Object paramAnonymousObject)
      {
        AppMethodBeat.i(98357);
        SnsAdNativeLandingPagesUI.l(SnsAdNativeLandingPagesUI.this).removeCallbacksAndMessages(null);
        SnsAdNativeLandingPagesUI.l(SnsAdNativeLandingPagesUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98356);
            Object localObject = SnsAdNativeLandingPagesUI.m(SnsAdNativeLandingPagesUI.this);
            SnsAdNativeLandingPagesUI.n(SnsAdNativeLandingPagesUI.this);
            String str = (String)paramAnonymousObject;
            SnsAdNativeLandingPagesUI.o(SnsAdNativeLandingPagesUI.this);
            SnsAdNativeLandingPagesUI.p(SnsAdNativeLandingPagesUI.this);
            localObject = new i.a(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.jR((String)localObject, str), SnsAdNativeLandingPagesUI.n(SnsAdNativeLandingPagesUI.this));
            SnsAdNativeLandingPagesUI.this.AcY = ((i.a)localObject).AcY;
            SnsAdNativeLandingPagesUI.this.AoJ = ((i.a)localObject).AcZ;
            com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(98355);
                SnsAdNativeLandingPagesUI.q(SnsAdNativeLandingPagesUI.this);
                AppMethodBeat.o(98355);
              }
            });
            AppMethodBeat.o(98356);
          }
        });
        AppMethodBeat.o(98357);
      }
      
      public final void h(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject) {}
    };
    this.ApM = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(oj paramAnonymousoj)
      {
        AppMethodBeat.i(176294);
        Object localObject1;
        SnsAdLandingPageFloatView localSnsAdLandingPageFloatView;
        Object localObject2;
        int i;
        String str1;
        String str2;
        String str3;
        if ((SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this).zZP.AcR != null) && (SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this).zZP.AcR.containsKey(paramAnonymousoj.dDo.dDp)) && (!SnsAdNativeLandingPagesUI.r(SnsAdNativeLandingPagesUI.this).containsKey(paramAnonymousoj.dDo.dDp)))
        {
          SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this).onPause();
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("sns_landing_pages_xml", SnsAdNativeLandingPagesUI.m(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putString("sns_float_component_id", paramAnonymousoj.dDo.dDp);
          ((Bundle)localObject1).putInt("sns_landing_page_index", SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this).zZP.id);
          ((Bundle)localObject1).putString("sns_landing_page_snsId", SnsAdNativeLandingPagesUI.this.dAg);
          ((Bundle)localObject1).putString("sns_landing_pages_rawSnsId", SnsAdNativeLandingPagesUI.this.AoW);
          ((Bundle)localObject1).putString("sns_landing_pages_ux_info", SnsAdNativeLandingPagesUI.s(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putString("sns_landing_pages_aid", SnsAdNativeLandingPagesUI.o(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putInt("sns_landing_pages_biz_id", SnsAdNativeLandingPagesUI.t(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putString("sns_landing_pages_traceid", SnsAdNativeLandingPagesUI.p(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putInt("sns_landig_pages_from_source", SnsAdNativeLandingPagesUI.u(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putString("sns_landing_pages_xml_prefix", SnsAdNativeLandingPagesUI.n(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putBoolean("sns_landing_is_native_sight_ad", SnsAdNativeLandingPagesUI.v(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putString("sns_landing_pages_canvas_ext", SnsAdNativeLandingPagesUI.w(SnsAdNativeLandingPagesUI.this));
          localSnsAdLandingPageFloatView = new SnsAdLandingPageFloatView(SnsAdNativeLandingPagesUI.this);
          localObject2 = ((Bundle)localObject1).getString("sns_landing_pages_xml");
          localSnsAdLandingPageFloatView.dDp = ((Bundle)localObject1).getString("sns_float_component_id");
          i = ((Bundle)localObject1).getInt("sns_landing_page_index", -1);
          str1 = ((Bundle)localObject1).getString("sns_landing_pages_ux_info");
          str2 = ((Bundle)localObject1).getString("sns_landing_pages_aid");
          str3 = ((Bundle)localObject1).getString("sns_landing_pages_traceid");
          localSnsAdLandingPageFloatView.zMl = ((Bundle)localObject1).getString("sns_landing_pages_canvas_ext");
          if ((!bu.V(new String[] { localObject2, localSnsAdLandingPageFloatView.dDp })) && (i != -1)) {
            break label490;
          }
          ae.e("MicroMsg.SnsAdLandingPageFloatView", "invalid landing float page data!");
        }
        for (;;)
        {
          localSnsAdLandingPageFloatView.setBackgroundColor(SnsAdNativeLandingPagesUI.this.getResources().getColor(2131100893));
          SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).addView(localSnsAdLandingPageFloatView, SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).getChildCount() - 1, new FrameLayout.LayoutParams(-1, -1));
          localSnsAdLandingPageFloatView.eiB();
          SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this).ebn();
          SnsAdNativeLandingPagesUI.this.j(false, 0L);
          SnsAdNativeLandingPagesUI.r(SnsAdNativeLandingPagesUI.this).put(paramAnonymousoj.dDo.dDp, localSnsAdLandingPageFloatView);
          AppMethodBeat.o(176294);
          return false;
          label490:
          localObject1 = new i.a((String)localObject2, bu.bI(((Bundle)localObject1).getString("sns_landing_pages_xml_prefix"), "adxml")).AcY;
          if ((localObject1 != null) && (((LinkedList)localObject1).size() > i))
          {
            localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)((LinkedList)localObject1).get(i);
            localSnsAdLandingPageFloatView.ATG = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g();
            localSnsAdLandingPageFloatView.ATG.jZm = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject1).jZm;
            localObject2 = (y)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject1).AcR.get(localSnsAdLandingPageFloatView.dDp);
            if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.Ro(((y)localObject2).type))
            {
              localSnsAdLandingPageFloatView.ATF = ((w)localObject2);
              localSnsAdLandingPageFloatView.ATG.AcQ.add(localSnsAdLandingPageFloatView.ATF);
              localSnsAdLandingPageFloatView.ATG.AcR.putAll(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject1).AcR);
            }
            localSnsAdLandingPageFloatView.ATG.id = 0;
            localSnsAdLandingPageFloatView.ATG.AcS = true;
          }
          ae.i("MicroMsg.SnsAdLandingPageFloatView", "[reportInfo] aid %s,traceId %s,uxInfo %s,adCanvasExtXml %s", new Object[] { str2, str3, str1, localSnsAdLandingPageFloatView.zMl });
          localSnsAdLandingPageFloatView.initView();
        }
      }
    };
    this.ApN = new com.tencent.mm.sdk.b.c() {};
    this.ApO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98329);
        SnsAdNativeLandingPagesUI.L(SnsAdNativeLandingPagesUI.this);
        if ((!SnsAdNativeLandingPagesUI.M(SnsAdNativeLandingPagesUI.this)) && (SnsAdNativeLandingPagesUI.N(SnsAdNativeLandingPagesUI.this))) {
          SnsAdNativeLandingPagesUI.O(SnsAdNativeLandingPagesUI.this);
        }
        AppMethodBeat.o(98329);
      }
    };
    this.ApP = new SnsAdNativeLandingPagesUI.5(this);
    this.ApQ = new HashMap();
    this.ufz = new SnsAdNativeLandingPagesUI.14(this);
    this.ApR = new b.a()
    {
      public final void bu(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(219810);
        SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this, paramAnonymousBoolean);
        ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "onKeyboardStateChanged, visiable=".concat(String.valueOf(paramAnonymousBoolean)));
        SnsAdNativeLandingPagesUI.this.Av(300L);
        AppMethodBeat.o(219810);
      }
    };
    this.ApS = new SnsAdNativeLandingPagesUI.17(this);
    this.ApT = null;
    this.ApU = null;
    AppMethodBeat.o(98362);
  }
  
  private void AK(long paramLong)
  {
    AppMethodBeat.i(98401);
    if (this.Apw != null)
    {
      ae.d("MicroMsg.SnsAdNativeLandingPagesUI", "showFloatBarView");
      this.Apw.At(paramLong);
      ContentFragment localContentFragment = eeT();
      if (localContentFragment != null) {
        localContentFragment.ebn();
      }
    }
    AppMethodBeat.o(98401);
  }
  
  public static boolean RJ(int paramInt)
  {
    AppMethodBeat.i(219820);
    if ((paramInt == 3) || (paramInt == 5) || (paramInt == 4)) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "isNeedUpdateUxinfo, source=" + paramInt + ", ret=" + bool);
      AppMethodBeat.o(219820);
      return bool;
    }
  }
  
  private void Zm()
  {
    long l2 = 0L;
    AppMethodBeat.i(98374);
    this.znm = AdLandingPagesProxy.getInstance().getSnsInfo(this.dAg);
    AdLandingPagesProxy.getInstance().asyncCacheXml(this.dAg);
    if (this.values == null)
    {
      ae.e("MicroMsg.SnsAdNativeLandingPagesUI", "parse landingpagexml is error,landingpagexml is " + this.AoP);
      AppMethodBeat.o(98374);
      return;
    }
    long l1;
    if ((this.doj == 1) || (this.doj == 2) || (this.doj == 16) || (this.doj == 14) || (this.doj == 9) || (this.doj == 10))
    {
      if (this.znm == null) {
        break label2850;
      }
      l1 = this.znm.field_snsId;
      this.zMk = AdLandingPagesProxy.getInstance().getSnsAid(this.dAg);
      this.jWi = AdLandingPagesProxy.getInstance().getSnsTraceid(this.dAg);
      this.zMQ = AdLandingPagesProxy.getInstance().getSnsAdType(this.dAg);
      this.dGD = AdLandingPagesProxy.getInstance().getSnsUxInfo(this.dAg);
      this.zMl = AdLandingPagesProxy.getInstance().getSnsAdCanvasExtXml(this.dAg);
    }
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      label625:
      int i;
      if (this.AoW != null)
      {
        localObject1 = this.AoW;
        this.values.put("." + this.AoQ + ".originSnsId", localObject1);
        this.values.put("." + this.AoQ + ".originUxInfo", this.dGD);
        localObject2 = "<" + this.AoQ + ">";
        localObject2 = (String)localObject2 + String.format("<originSnsId>%s</originSnsId>", new Object[] { localObject1 });
        localObject2 = (String)localObject2 + String.format("<originUxInfo>%s</originUxInfo>", new Object[] { this.dGD });
        localObject2 = (String)localObject2 + String.format("<originAdType>%d</originAdType>", new Object[] { Integer.valueOf(this.zMQ) });
        localObject2 = (String)localObject2 + String.format("<originAid>%s</originAid>", new Object[] { this.zMk });
        localObject3 = (String)localObject2 + String.format("<originTraceId>%s</originTraceId>", new Object[] { this.jWi });
        localObject2 = localObject3;
        if (!bu.isNullOrNil(this.zMl)) {
          localObject2 = (String)localObject3 + String.format("<originAdCanvasExt>%s</originAdCanvasExt>", new Object[] { this.zMl });
        }
        this.AoP = this.AoP.replace("<" + this.AoQ + ">", (CharSequence)localObject2);
        this.AoY.dGD = this.dGD;
        this.AoY.dAg = ((String)localObject1);
        ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "reportInfo aid [%s],traceId [%s],adType [%s],uxInfo [%s],adCanvasExtXml [%s]", new Object[] { this.zMk, this.jWi, Integer.valueOf(this.zMQ), this.dGD, this.zMl });
        if (bu.isNullOrNil(this.zMl)) {
          break label1408;
        }
        localObject2 = bx.M(this.zMl, "adCardItemList");
        if (localObject2 == null) {
          break label1408;
        }
        i = 0;
        label705:
        if (i <= 0) {
          break label2842;
        }
      }
      label1408:
      label2831:
      label2842:
      for (Object localObject1 = ".adCardItemList.cardItem" + i;; localObject1 = ".adCardItemList.cardItem")
      {
        if (((Map)localObject2).containsKey((String)localObject1 + ".cardTpId"))
        {
          localObject3 = bu.bI((String)((Map)localObject2).get((String)localObject1 + ".cardTpId"), "");
          localObject1 = bu.bI((String)((Map)localObject2).get((String)localObject1 + ".cardExt"), "");
          if ((!bu.isNullOrNil((String)localObject3)) && (!bu.isNullOrNil((String)localObject1))) {
            this.zRS.put(localObject3, localObject1);
          }
          i += 1;
          break label705;
          localObject1 = String.valueOf(l1);
          break;
          this.AoY.dAg = ((String)this.values.get("." + this.AoQ + ".originSnsId"));
          this.AoY.dGD = ((String)this.values.get("." + this.AoQ + ".originUxInfo"));
          this.dGD = this.AoY.dGD;
          this.AoW = this.AoY.dAg;
          this.zMQ = bu.aSB((String)this.values.get("." + this.AoQ + ".originAdType"));
          this.zMk = ((String)this.values.get("." + this.AoQ + ".originAid"));
          this.jWi = ((String)this.values.get("." + this.AoQ + ".originTraceId"));
          if (!bu.isNullOrNil(this.kwE))
          {
            localObject1 = bx.M(this.kwE, "ADInfo");
            ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "adInfoXml %s", new Object[] { this.kwE });
            if (localObject1 != null)
            {
              this.dGD = bu.bI((String)((Map)localObject1).get(".ADInfo.uxInfo"), "");
              this.AoY.dGD = this.dGD;
              this.zMk = bu.bI((String)((Map)localObject1).get(".ADInfo.session_data.aid"), "");
              this.jWi = bu.bI((String)((Map)localObject1).get(".ADInfo.session_data.trace_id"), "");
              this.aQj = bu.bI((String)((Map)localObject1).get(".ADInfo.viewid"), "");
              this.zRR = bu.bI((String)((Map)localObject1).get(".ADInfo.commInfo"), "");
              ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "viewId = " + this.aQj + ", commInfo = " + this.zRR + ", uxInfo = " + this.dGD);
            }
          }
          localObject1 = Pattern.compile("<originAdCanvasExt>[\\s\\S]*</originAdCanvasExt>").matcher(this.AoP);
          if (!((Matcher)localObject1).find()) {
            break label625;
          }
          localObject1 = ((Matcher)localObject1).group();
          if (bu.isNullOrNil((String)localObject1)) {
            break label625;
          }
          this.zMl = ((String)localObject1).replaceAll("</?originAdCanvasExt>", "");
          break label625;
        }
        this.AoY.Adw = AdLandingPagesProxy.getInstance().getSnsStatExtBySnsId(bu.aSC(this.AoY.dAg));
        this.qlw = bu.bI((String)this.values.get("." + this.AoQ + ".adCanvasInfo.shareTitle"), "");
        this.qlv = bu.bI((String)this.values.get("." + this.AoQ + ".adCanvasInfo.shareWebUrl"), "");
        this.uly = bu.bI((String)this.values.get("." + this.AoQ + ".adCanvasInfo.shareDesc"), "");
        this.bizId = bu.aSB(bu.bI((String)this.values.get("." + this.AoQ + ".adCanvasInfo.bizId"), ""));
        this.Apd = bu.bI((String)this.values.get("." + this.AoQ + ".adCanvasInfo.shareAppId"), "");
        this.Ape = bu.bI((String)this.values.get("." + this.AoQ + ".adCanvasInfo.shareType"), "");
        this.Apf = bu.bI((String)this.values.get("." + this.AoQ + ".adCanvasInfo.userInfo"), "");
        this.Api = bu.aSB(bu.bI((String)this.values.get("." + this.AoQ + ".adCanvasInfo.disableShareBitSet"), ""));
        this.Apj = bu.aSB(bu.bI((String)this.values.get("." + this.AoQ + ".adCanvasInfo.statusBarStyle"), ""));
        z(this.values, "." + this.AoQ);
        this.uin = AdLandingPagesProxy.getInstance().getUin();
        this.Apg = bu.bI((String)this.values.get("." + this.AoQ + ".adCanvasInfo.officialSyncBuffer"), "");
        getIntent().putExtra("sns_landing_pages_adType", this.zMQ);
        getIntent().putExtra("sns_landing_pages_rawSnsId", this.AoY.dAg);
        if (bu.isNullOrNil(this.zMk)) {
          this.zMk = bu.bI((String)this.values.get("." + this.AoQ + ".originAid"), "");
        }
        if (bu.isNullOrNil(this.jWi)) {
          this.jWi = bu.bI((String)this.values.get("." + this.AoQ + ".originTraceId"), "");
        }
        localObject1 = new i.a(this.AoP, this.AoQ);
        this.AcY = ((i.a)localObject1).AcY;
        this.AoJ = ((i.a)localObject1).AcZ;
        efa();
        b((i.a)localObject1);
        c((i.a)localObject1);
        d((i.a)localObject1);
        if (this.AcY.size() > 0)
        {
          localObject2 = "";
          localObject3 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.AcY.get(0);
          localObject1 = localObject2;
          l1 = l2;
          if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject3).AcQ.size() > 0)
          {
            localObject3 = (y)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject3).AcQ.get(0);
            if (!(localObject3 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)) {
              break label2619;
            }
            this.AoV = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)localObject3).zQK;
            l1 = l2;
            localObject1 = localObject2;
          }
          if (this.znm != null)
          {
            localObject2 = this.znm.ebP();
            if ((localObject2 != null) && (((TimeLineObject)localObject2).HUG != null) && (((TimeLineObject)localObject2).HUG.Gtx != null) && (!((TimeLineObject)localObject2).HUG.Gtx.isEmpty()))
            {
              localObject3 = (bzh)((TimeLineObject)localObject2).HUG.Gtx.getFirst();
              localObject2 = ap.jv(AdLandingPagesProxy.getInstance().getAccSnsPath(), ((bzh)localObject3).Id) + com.tencent.mm.plugin.sns.data.r.i((bzh)localObject3);
              localObject3 = ((bzh)localObject3).Url;
              if (((String)localObject1).equals(localObject3))
              {
                localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jM("adId", (String)localObject3);
                if ((!com.tencent.mm.vfs.o.fB((String)localObject1)) && (com.tencent.mm.vfs.o.fB((String)localObject2)))
                {
                  ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "copy outsideFiel:%s->%s", new Object[] { localObject2, localObject1 });
                  if (!com.tencent.mm.plugin.sns.ad.timeline.a.a.j(this.znm)) {
                    break label2831;
                  }
                  if (com.tencent.mm.vfs.o.aZR((String)localObject2) != l1) {
                    break label2812;
                  }
                  com.tencent.mm.vfs.o.mF((String)localObject2, (String)localObject1);
                  ae.d("MicroMsg.SnsAdNativeLandingPagesUI", "online video play, it is to copy!!");
                  com.tencent.mm.plugin.sns.ad.f.h.a(com.tencent.mm.plugin.sns.ad.f.i.Ql(1));
                }
              }
            }
          }
        }
        for (;;)
        {
          this.AoR = bu.bI((String)this.values.get("." + this.AoQ + ".adCanvasInfo.rightBarTitle"), "");
          this.AoS = bu.bI((String)this.values.get("." + this.AoQ + ".adCanvasInfo.rightBarCanvasId"), "");
          this.AoT = bu.bI((String)this.values.get("." + this.AoQ + ".adCanvasInfo.rightBarCanvasExt"), "");
          AppMethodBeat.o(98374);
          return;
          label2619:
          if ((localObject3 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r))
          {
            this.AoV = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)localObject3).zQK;
            localObject1 = localObject2;
            l1 = l2;
            break;
          }
          if ((localObject3 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u))
          {
            this.AoV = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)localObject3).zQQ;
            localObject1 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)localObject3).zQP;
            l1 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)localObject3).zQZ;
            break;
          }
          localObject1 = localObject2;
          l1 = l2;
          if (!(localObject3 instanceof ai)) {
            break;
          }
          localObject3 = (ai)localObject3;
          localObject1 = localObject2;
          l1 = l2;
          if (((ai)localObject3).zQI.isEmpty()) {
            break;
          }
          localObject3 = (q)((ai)localObject3).zQI.getFirst();
          localObject1 = localObject2;
          l1 = l2;
          if (((q)localObject3).zQI.isEmpty()) {
            break;
          }
          localObject3 = (y)((q)localObject3).zQI.getFirst();
          localObject1 = localObject2;
          l1 = l2;
          if (!(localObject3 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)) {
            break;
          }
          this.AoV = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)localObject3).zQK;
          localObject1 = localObject2;
          l1 = l2;
          break;
          label2812:
          ae.w("MicroMsg.SnsAdNativeLandingPagesUI", "online play, but it isn't to copy, because file size is invalid");
          com.tencent.mm.plugin.sns.ad.f.h.a(com.tencent.mm.plugin.sns.ad.f.i.Ql(0));
          continue;
          com.tencent.mm.vfs.o.mF((String)localObject2, (String)localObject1);
        }
      }
      label2850:
      l1 = 0L;
    }
  }
  
  private String aCe(String paramString)
  {
    AppMethodBeat.i(98389);
    String str = bu.bI((String)this.values.get("." + this.AoQ + ".adCanvasInfo.shareThumbUrl"), "");
    if (!bu.isNullOrNil(str))
    {
      AppMethodBeat.o(98389);
      return str;
    }
    AppMethodBeat.o(98389);
    return paramString;
  }
  
  private void aTR()
  {
    AppMethodBeat.i(98378);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.Aph.getAdapter();
    if (localb == null)
    {
      localb = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b(getSupportFragmentManager(), new ArrayList());
      this.Aph.setAdapter(localb);
    }
    for (;;)
    {
      List localList = eeL();
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g localg;
      ContentFragment localContentFragment;
      if (localList.size() > 0)
      {
        localg = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localList.get(0);
        ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "loadFirstPage load id %s", new Object[] { Integer.valueOf(localg.id) });
        localContentFragment = (ContentFragment)this.ApQ.get(Integer.valueOf(localg.id));
        if (localContentFragment != null) {
          break label362;
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("pageInfo", localg);
        localHashMap.put("pageCount", Integer.valueOf(localList.size()));
        localHashMap.put("viewPager", this.Aph);
        localHashMap.put("pageDownIconInfo", this.zZV);
        localHashMap.put("is_first_show_page", Boolean.TRUE);
        if (localList.size() == 1) {
          localHashMap.put("is_last_shown_page", Boolean.TRUE);
        }
        localHashMap.put("needEnterAnimation", Boolean.valueOf(this.AoN));
        localHashMap.put("needDirectionAnimation", Boolean.valueOf(eeO()));
        localHashMap.put("groupListCompShowIndex", Integer.valueOf(this.Apb));
        localContentFragment = new ContentFragment();
        localContentFragment.xqN = localHashMap;
        localContentFragment.Aae = this.ApJ;
        this.ApQ.put(Integer.valueOf(localg.id), localContentFragment);
      }
      for (;;)
      {
        if (localContentFragment != null) {
          localb.c(localContentFragment, 0);
        }
        localb.notifyDataSetChanged();
        this.Aph.setOffscreenPageLimit(localList.size());
        AppMethodBeat.o(98378);
        return;
        label362:
        localContentFragment.a(localg);
      }
    }
  }
  
  private void b(i.a parama)
  {
    AppMethodBeat.i(219825);
    try
    {
      if ((parama.Ada != null) && (this.Apn != null))
      {
        this.ApF = FloatWebViewHelper.a(parama.Ada, (ViewGroup)this.Apn);
        getLifecycle().addObserver(this.ApF);
      }
      AppMethodBeat.o(219825);
      return;
    }
    catch (Throwable parama)
    {
      AppMethodBeat.o(219825);
    }
  }
  
  private void c(i.a parama)
  {
    AppMethodBeat.i(219826);
    try
    {
      eeZ();
      if (this.Apv != null)
      {
        parama = this.Apv.a(parama);
        if (parama != null)
        {
          parama.v((ViewGroup)this.Apn);
          parama.dUS();
        }
      }
      AppMethodBeat.o(219826);
      return;
    }
    catch (Throwable parama)
    {
      AppMethodBeat.o(219826);
    }
  }
  
  private void d(i.a parama)
  {
    AppMethodBeat.i(219827);
    try
    {
      eeZ();
      if ((parama.Adb != null) && (this.Apn != null) && (this.Apv != null))
      {
        FloatJumpCompHelper localFloatJumpCompHelper = this.Apv.a(parama.Adb, (ViewGroup)this.Apn);
        if (localFloatJumpCompHelper != null)
        {
          this.ApV = localFloatJumpCompHelper;
          getLifecycle().addObserver(localFloatJumpCompHelper);
          if (parama.Adb.znJ != null)
          {
            parama = parama.Adb.znJ.zQs;
            if (!TextUtils.isEmpty(parama)) {
              this.ApA.add(parama);
            }
          }
        }
      }
      AppMethodBeat.o(219827);
      return;
    }
    catch (Throwable parama)
    {
      AppMethodBeat.o(219827);
    }
  }
  
  private void eeB()
  {
    AppMethodBeat.i(98364);
    AdlandingRemoteServiceConnectedReceiver.a(android.support.v4.content.d.V(this));
    Zm();
    if (this.AoN) {
      aTR();
    }
    for (;;)
    {
      refreshView();
      eeG();
      eeH();
      rT(true);
      this.aMx = true;
      eeC();
      AppMethodBeat.o(98364);
      return;
      eeM();
    }
  }
  
  private void eeC()
  {
    AppMethodBeat.i(219818);
    if ((RJ(this.doj)) && (!TextUtils.isEmpty(this.dGD)))
    {
      ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "doUpdateUxInfoScene, uxInfo=" + this.dGD);
      AdLandingPagesProxy.getInstance().doUpdateUxInfoScene(this.dGD, new SnsAdNativeLandingPagesUI.26(this));
      eeD();
    }
    AppMethodBeat.o(219818);
  }
  
  private void eeD()
  {
    AppMethodBeat.i(219819);
    try
    {
      ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "checkPreloadScanRes, uxinfo=" + this.dGD);
      com.tencent.mm.plugin.sns.ad.timeline.a.d.a(b.b.t(this.values, ".adxml.adScanInfo"), this.dGD);
      AppMethodBeat.o(219819);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.SnsAdNativeLandingPagesUI", "checkPreloadScanRes exp=" + localException.toString());
      AppMethodBeat.o(219819);
    }
  }
  
  private void eeE()
  {
    AppMethodBeat.i(219821);
    try
    {
      if ((this.ApG != null) && (this.ApG.isShowing())) {
        this.ApG.bqD();
      }
      AppMethodBeat.o(219821);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.SnsAdNativeLandingPagesUI", "hideMoreOptionMenu exp=" + localException.toString());
      AppMethodBeat.o(219821);
    }
  }
  
  private void eeF()
  {
    AppMethodBeat.i(98367);
    Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.Aph.getAdapter();
    if (localObject == null)
    {
      AppMethodBeat.o(98367);
      return;
    }
    localObject = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)localObject).fragments.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ContentFragment localContentFragment = (ContentFragment)((Iterator)localObject).next();
      if ((localContentFragment.zZT != null) && (localContentFragment.getUserVisibleHint())) {
        localContentFragment.zZT.ebd();
      }
    }
    if (this.Apw != null) {
      this.Apw.dUL();
    }
    AppMethodBeat.o(98367);
  }
  
  private void eeG()
  {
    AppMethodBeat.i(98369);
    com.tencent.mm.plugin.report.service.g localg;
    String str2;
    if (this.zNm != 2)
    {
      localg = com.tencent.mm.plugin.report.service.g.yxI;
      str2 = com.tencent.mm.plugin.sns.data.r.zV(com.tencent.mm.plugin.sns.data.r.azz(this.AoY.dAg));
      if (this.dGD != null) {
        break label127;
      }
    }
    label127:
    for (String str1 = "";; str1 = this.dGD)
    {
      localg.f(14655, new Object[] { str2, str1, Integer.valueOf(this.AoY.gnM), Integer.valueOf(this.AoY.pWb), Long.valueOf(this.enterTime), Integer.valueOf(this.zRN), this.AoY.kwD });
      AppMethodBeat.o(98369);
      return;
    }
  }
  
  private void eeH()
  {
    AppMethodBeat.i(179185);
    try
    {
      if (!bu.V(new String[] { this.aQj, this.zRR }))
      {
        if (!this.ApB) {
          eeI();
        }
        if ((!this.ApC) && (this.ApE != null))
        {
          ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "execute mValidExposureRunnable onCreate");
          this.ApE.removeCallbacks(this.ApO);
          this.ApE.postDelayed(this.ApO, 1000L);
        }
      }
      AppMethodBeat.o(179185);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("MicroMsg.SnsAdNativeLandingPagesUI", localThrowable.toString());
      AppMethodBeat.o(179185);
    }
  }
  
  private void eeI()
  {
    AppMethodBeat.i(179186);
    ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "reportOriginalExposure viewId = " + this.aQj + ", commInfo = " + this.zRR + ", uxInfo = " + this.dGD + ", exposureType = 0");
    this.ApB = true;
    g(this.aQj, this.zRR, this.dGD, 0);
    AppMethodBeat.o(179186);
  }
  
  private void eeJ()
  {
    AppMethodBeat.i(179187);
    ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "reportValidExposure viewId = " + this.aQj + ", commInfo = " + this.zRR + ", uxInfo = " + this.dGD + ", exposureType = 1");
    this.ApC = true;
    g(this.aQj, this.zRR, this.dGD, 1);
    AppMethodBeat.o(179187);
  }
  
  private boolean eeK()
  {
    AppMethodBeat.i(98370);
    int j = this.Apl.getChildCount();
    int i = 0;
    while (i < j)
    {
      if ((this.Apl.getChildAt(i) instanceof SnsAdLandingPageFloatView))
      {
        AppMethodBeat.o(98370);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(98370);
    return false;
  }
  
  private List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g> eeL()
  {
    AppMethodBeat.i(98376);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.AcY.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g localg = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localIterator.next();
      if (localg.AcS) {
        localArrayList.add(localg);
      }
    }
    ge(localArrayList);
    AppMethodBeat.o(98376);
    return localArrayList;
  }
  
  private void eeM()
  {
    AppMethodBeat.i(98379);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.Aph.getAdapter();
    if (localb == null)
    {
      localb = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b(getSupportFragmentManager(), new ArrayList());
      this.Aph.setAdapter(localb);
    }
    for (;;)
    {
      List localList = eeL();
      int i = 0;
      if (i < localList.size())
      {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g localg = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.AcY.get(i);
        ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "loadLandingPages load id %s", new Object[] { Integer.valueOf(localg.id) });
        ContentFragment localContentFragment = (ContentFragment)this.ApQ.get(Integer.valueOf(localg.id));
        boolean bool;
        label214:
        label244:
        int j;
        if (localContentFragment == null)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("pageInfo", localg);
          localHashMap.put("pageCount", Integer.valueOf(localList.size()));
          localHashMap.put("viewPager", this.Aph);
          localHashMap.put("pageDownIconInfo", this.zZV);
          if (i == 0)
          {
            bool = true;
            localHashMap.put("is_first_show_page", Boolean.valueOf(bool));
            if (i != localList.size() - 1) {
              break label393;
            }
            bool = true;
            localHashMap.put("is_last_shown_page", Boolean.valueOf(bool));
            localHashMap.put("needEnterAnimation", Boolean.valueOf(this.AoN));
            localHashMap.put("needDirectionAnimation", Boolean.valueOf(eeO()));
            if (i != 0) {
              break label398;
            }
            j = this.Apb;
            label304:
            localHashMap.put("groupListCompShowIndex", Integer.valueOf(j));
            localContentFragment = new ContentFragment();
            localContentFragment.xqN = localHashMap;
            if (i == 0) {
              localContentFragment.Aae = this.ApJ;
            }
            this.ApQ.put(Integer.valueOf(localg.id), localContentFragment);
          }
        }
        for (;;)
        {
          if (localContentFragment != null) {
            localb.c(localContentFragment, i);
          }
          i += 1;
          break;
          bool = false;
          break label214;
          label393:
          bool = false;
          break label244;
          label398:
          j = 0;
          break label304;
          localContentFragment.a(localg);
        }
      }
      localb.notifyDataSetChanged();
      this.Aph.setOffscreenPageLimit(localList.size());
      AppMethodBeat.o(98379);
      return;
    }
  }
  
  private boolean eeN()
  {
    AppMethodBeat.i(98382);
    if (this.Api != 0)
    {
      if (((this.Api & 0x4) == 0) || ((this.Api & 0x2) == 0) || ((eeR()) && (this.bizId == 2)) || ((this.Api & 0x1) == 0) || ((this.Api & 0x20) == 0))
      {
        AppMethodBeat.o(98382);
        return true;
      }
      AppMethodBeat.o(98382);
      return false;
    }
    AppMethodBeat.o(98382);
    return true;
  }
  
  private boolean eeO()
  {
    return (this.Api & 0x8) == 0;
  }
  
  private boolean eeP()
  {
    return this.Apj == 0;
  }
  
  private boolean eeQ()
  {
    AppMethodBeat.i(98383);
    if ((!bu.isNullOrNil(this.AoR)) && (!bu.isNullOrNil(this.AoS)))
    {
      AppMethodBeat.o(98383);
      return true;
    }
    AppMethodBeat.o(98383);
    return false;
  }
  
  private boolean eeR()
  {
    return (this.Api & 0x10) == 0;
  }
  
  private ah eeS()
  {
    AppMethodBeat.i(98385);
    Object localObject = eeT().ebh().iterator();
    while (((Iterator)localObject).hasNext())
    {
      m localm = (m)((Iterator)localObject).next();
      if ((localm instanceof ah))
      {
        localObject = (ah)localm;
        AppMethodBeat.o(98385);
        return localObject;
      }
    }
    AppMethodBeat.o(98385);
    return null;
  }
  
  private ContentFragment eeT()
  {
    AppMethodBeat.i(98387);
    ContentFragment localContentFragment = null;
    if (this.AcY.size() > 0) {
      localContentFragment = (ContentFragment)this.ApQ.get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.AcY.get(this.Aph.getCurrentItem())).id));
    }
    AppMethodBeat.o(98387);
    return localContentFragment;
  }
  
  private a eeU()
  {
    AppMethodBeat.i(98388);
    Object localObject = new com.tencent.mm.plugin.sns.storage.b(this.AoP);
    if (((com.tencent.mm.plugin.sns.storage.b)localObject).dZG())
    {
      int i = AdLandingPagesProxy.getInstance().getAdVoteIndex(((com.tencent.mm.plugin.sns.storage.b)localObject).zOe.zOZ, this.dGD, this.uin);
      if ((i > 0) && (i <= ((com.tencent.mm.plugin.sns.storage.b)localObject).zOe.zPb.size()))
      {
        localObject = (b.m)((com.tencent.mm.plugin.sns.storage.b)localObject).zOe.zPb.get(i - 1);
        a locala = new a((byte)0);
        if (!bu.isNullOrNil(((b.m)localObject).qlw))
        {
          locala.qlw = ((b.m)localObject).qlw;
          if (bu.isNullOrNil(((b.m)localObject).uly)) {
            break label165;
          }
          locala.uly = ((b.m)localObject).uly;
          label128:
          if (bu.isNullOrNil(((b.m)localObject).zPc)) {
            break label176;
          }
        }
        label165:
        label176:
        for (locala.zPc = ((b.m)localObject).zPc;; locala.zPc = this.AoV)
        {
          AppMethodBeat.o(98388);
          return locala;
          locala.qlw = this.qlw;
          break;
          locala.uly = this.uly;
          break label128;
        }
      }
    }
    AppMethodBeat.o(98388);
    return null;
  }
  
  private String eeV()
  {
    AppMethodBeat.i(98390);
    Object localObject = new djc();
    ((djc)localObject).HQJ = new djd();
    ((djc)localObject).HQJ.FEJ = this.AoY.dGD;
    ((djc)localObject).HQJ.HQM = this.AoY.dAg;
    ((djc)localObject).HQJ.zMQ = this.zMQ;
    try
    {
      localObject = Base64.encodeToString(((djc)localObject).toByteArray(), 2);
      AppMethodBeat.o(98390);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(98390);
    }
    return "";
  }
  
  private String eeW()
  {
    AppMethodBeat.i(98391);
    String str2 = this.AoP.replaceAll("(?s)<adCanvasInfoLeft[^>]*>.*?</adCanvasInfoLeft>", "").replaceAll("(?s)<adCanvasInfoRight[^>]*>.*?</adCanvasInfoRight>", "");
    String str1 = str2;
    if (str2.contains("<shareAdCanvasInfo>")) {
      str1 = str2.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replace("shareAdCanvasInfo", "adCanvasInfo");
    }
    AppMethodBeat.o(98391);
    return str1;
  }
  
  private void eeZ()
  {
    AppMethodBeat.i(219828);
    if (this.Apv == null) {
      this.Apv = new com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.a();
    }
    AppMethodBeat.o(219828);
  }
  
  private void efa()
  {
    AppMethodBeat.i(98398);
    if ((this.AoJ != null) && (this.Apl != null) && (this.Apw == null))
    {
      this.Apw = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d(this, this.AoJ, this.Apl);
      j(false, 0L);
      if ((this.AoJ.zRB instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p))
      {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p localp = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.AoJ.zRB;
        if (!TextUtils.isEmpty(localp.zQs)) {
          this.ApA.add(localp.zQs);
        }
      }
    }
    AppMethodBeat.o(98398);
  }
  
  private boolean efc()
  {
    AppMethodBeat.i(98404);
    if (this.AoJ != null)
    {
      if (this.AoJ.zRA == 1)
      {
        boolean bool = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u.QW(this.doj);
        AppMethodBeat.o(98404);
        return bool;
      }
      AppMethodBeat.o(98404);
      return true;
    }
    AppMethodBeat.o(98404);
    return false;
  }
  
  private static void g(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(179188);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("viewid", paramString1);
      localJSONObject.put("commInfo", paramString2);
      localJSONObject.put("uxinfo", paramString3);
      localJSONObject.put("exposureType", paramInt);
      com.tencent.mm.plugin.sns.data.k.jm("rewarded_canvas_exposure", localJSONObject.toString());
      AppMethodBeat.o(179188);
      return;
    }
    catch (Exception paramString1)
    {
      ae.e("MicroMsg.SnsAdNativeLandingPagesUI", "doCanvasExposureReport exp=" + paramString1.toString());
      AppMethodBeat.o(179188);
    }
  }
  
  private void ge(List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g> paramList)
  {
    AppMethodBeat.i(98377);
    Object localObject1;
    for (;;)
    {
      int j;
      int i;
      Object localObject2;
      try
      {
        localObject1 = new ArrayList();
        j = 0;
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        Iterator localIterator = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)paramList.next()).AcQ.iterator();
        i = j;
        j = i;
        if (!localIterator.hasNext()) {
          continue;
        }
        localObject2 = (y)localIterator.next();
        if ((localObject2 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b))
        {
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject2).zPP = i;
          j = i + 1;
          if ((localObject2 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p))
          {
            String str = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject2).zQs;
            if (!TextUtils.isEmpty(str)) {
              this.ApA.add(str);
            }
          }
          i = j;
          if (!(localObject2 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)) {
            continue;
          }
          localObject2 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject2).jumpUrl;
          i = j;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            continue;
          }
          this.ApA.add(localObject2);
          i = j;
          continue;
        }
        j = i;
      }
      catch (Exception paramList)
      {
        ae.e("MicroMsg.SnsAdNativeLandingPagesUI", "giveIdxForApkBtnInfo, exp=" + paramList.toString());
        AppMethodBeat.o(98377);
        return;
      }
      if ((localObject2 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k))
      {
        ((List)localObject1).add((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k)localObject2);
        j = i;
      }
    }
    if (!((List)localObject1).isEmpty()) {
      com.tencent.mm.plugin.sns.ad.c.c.fO((List)localObject1);
    }
    if (!com.tencent.mm.plugin.sns.ad.f.c.isEmpty(this.ApA))
    {
      localObject1 = com.tencent.mm.plugin.sns.ad.b.a.a.a(this.ApA, this.jWi, this.zMk, this.zRP, this.dGD);
      if (!com.tencent.mm.plugin.sns.ad.f.c.w((Object[])localObject1)) {
        if (!TextUtils.isEmpty(this.dAg)) {
          break label334;
        }
      }
    }
    label334:
    for (paramList = this.AoW;; paramList = this.dAg)
    {
      AdLandingPagesProxy.getInstance().prefetchH5Url(paramList, (String[])localObject1);
      AppMethodBeat.o(98377);
      return;
    }
  }
  
  private List<m> getAllComp()
  {
    AppMethodBeat.i(98380);
    this.App = new ArrayList();
    Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.Aph.getAdapter();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)localObject).fragments.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Fragment localFragment = (Fragment)((Iterator)localObject).next();
        this.App.addAll(((ContentFragment)localFragment).ebh());
      }
    }
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.fX(this.App);
    localObject = this.App;
    AppMethodBeat.o(98380);
    return localObject;
  }
  
  private void r(ContentFragment paramContentFragment)
  {
    AppMethodBeat.i(98399);
    if (!efb()) {
      paramContentFragment.ebm();
    }
    AppMethodBeat.o(98399);
  }
  
  private void refreshView()
  {
    AppMethodBeat.i(98365);
    Object localObject;
    if ((this.bizId == 2) && (!eeP()))
    {
      localObject = (FrameLayout.LayoutParams)this.Aph.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).setMargins(0, 0, 0, com.tencent.mm.ui.ar.en(this));
      this.Aph.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int i = 2131100892;
    if (!eeP())
    {
      i = getResources().getColor(2131100891);
      if ((this.AcY == null) || (this.AcY.size() <= 0) || (bu.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.AcY.getFirst()).jZm))) {
        break label365;
      }
      i = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.AcY.getFirst()).jZm);
    }
    label365:
    for (;;)
    {
      this.Apm.setBackgroundColor(i);
      i = 2131100891;
      localObject = this.hai.getDrawable();
      if (localObject != null)
      {
        android.support.v4.graphics.drawable.a.a((Drawable)localObject, android.support.v4.content.b.n(this, i));
        this.hai.setImageDrawable((Drawable)localObject);
      }
      localObject = this.xQh.getDrawable();
      if (localObject != null)
      {
        android.support.v4.graphics.drawable.a.a((Drawable)localObject, android.support.v4.content.b.n(this, i));
        this.xQh.setImageDrawable((Drawable)localObject);
      }
      if ((eeQ()) && (!eeR()) && (this.bizId == 2))
      {
        this.xQh.setVisibility(8);
        this.AoL.setVisibility(0);
        this.AoL.setText(this.AoR);
        this.AoL.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(98327);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            SnsAdNativeLandingPagesUI.this.F(SnsAdNativeLandingPagesUI.this, SnsAdNativeLandingPagesUI.y(SnsAdNativeLandingPagesUI.this), SnsAdNativeLandingPagesUI.z(SnsAdNativeLandingPagesUI.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98327);
          }
        });
        AppMethodBeat.o(98365);
        return;
      }
      if (eeN())
      {
        ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "canShowMenuBtn=true, disableShareBitSet=" + this.Api);
        this.xQh.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(219797);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            SnsAdNativeLandingPagesUI.A(SnsAdNativeLandingPagesUI.this);
            SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this, new com.tencent.mm.ui.widget.a.e(SnsAdNativeLandingPagesUI.this, 1, false));
            SnsAdNativeLandingPagesUI.G(SnsAdNativeLandingPagesUI.this).LfS = new n.d()
            {
              public final void onCreateMMMenu(l paramAnonymous2l)
              {
                AppMethodBeat.i(219795);
                if ((SnsAdNativeLandingPagesUI.B(SnsAdNativeLandingPagesUI.this) == 0) || ((SnsAdNativeLandingPagesUI.B(SnsAdNativeLandingPagesUI.this) & 0x2) == 0)) {
                  paramAnonymous2l.a(1, SnsAdNativeLandingPagesUI.this.getString(2131762566), 2131689831);
                }
                if ((SnsAdNativeLandingPagesUI.B(SnsAdNativeLandingPagesUI.this) == 0) || ((SnsAdNativeLandingPagesUI.B(SnsAdNativeLandingPagesUI.this) & 0x1) == 0)) {
                  paramAnonymous2l.a(2, SnsAdNativeLandingPagesUI.this.getString(2131763771), 2131689817);
                }
                if (((SnsAdNativeLandingPagesUI.B(SnsAdNativeLandingPagesUI.this) == 0) || ((SnsAdNativeLandingPagesUI.B(SnsAdNativeLandingPagesUI.this) & 0x4) == 0)) && (SnsAdNativeLandingPagesUI.u(SnsAdNativeLandingPagesUI.this) != 7)) {
                  paramAnonymous2l.a(3, SnsAdNativeLandingPagesUI.this.getString(2131757157), 2131689808);
                }
                if (((SnsAdNativeLandingPagesUI.B(SnsAdNativeLandingPagesUI.this) == 0) || (SnsAdNativeLandingPagesUI.C(SnsAdNativeLandingPagesUI.this))) && (SnsAdNativeLandingPagesUI.t(SnsAdNativeLandingPagesUI.this) == 2) && (SnsAdNativeLandingPagesUI.D(SnsAdNativeLandingPagesUI.this))) {
                  if (SnsAdNativeLandingPagesUI.E(SnsAdNativeLandingPagesUI.this) == null) {
                    break label332;
                  }
                }
                label332:
                for (String str = SnsAdNativeLandingPagesUI.E(SnsAdNativeLandingPagesUI.this);; str = "")
                {
                  paramAnonymous2l.a(4, str, 0);
                  if (((SnsAdNativeLandingPagesUI.B(SnsAdNativeLandingPagesUI.this) == 0) || ((SnsAdNativeLandingPagesUI.B(SnsAdNativeLandingPagesUI.this) & 0x20) == 0)) && (SnsAdNativeLandingPagesUI.F(SnsAdNativeLandingPagesUI.this) != null) && (SnsAdNativeLandingPagesUI.F(SnsAdNativeLandingPagesUI.this).AMd != null)) {
                    paramAnonymous2l.a(5, SnsAdNativeLandingPagesUI.this.getString(2131767280), 0);
                  }
                  AppMethodBeat.o(219795);
                  return;
                }
              }
            };
            SnsAdNativeLandingPagesUI.G(SnsAdNativeLandingPagesUI.this).lEf = true;
            SnsAdNativeLandingPagesUI.G(SnsAdNativeLandingPagesUI.this).LfT = new n.e()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(219796);
                an.aG(SnsAdNativeLandingPagesUI.this);
                if (paramAnonymous2MenuItem != null) {
                  switch (paramAnonymous2MenuItem.getItemId())
                  {
                  }
                }
                for (;;)
                {
                  AppMethodBeat.o(219796);
                  return;
                  SnsAdNativeLandingPagesUI.H(SnsAdNativeLandingPagesUI.this);
                  AppMethodBeat.o(219796);
                  return;
                  SnsAdNativeLandingPagesUI.I(SnsAdNativeLandingPagesUI.this);
                  AppMethodBeat.o(219796);
                  return;
                  SnsAdNativeLandingPagesUI.J(SnsAdNativeLandingPagesUI.this);
                  AppMethodBeat.o(219796);
                  return;
                  SnsAdNativeLandingPagesUI.this.F(SnsAdNativeLandingPagesUI.this, SnsAdNativeLandingPagesUI.y(SnsAdNativeLandingPagesUI.this), SnsAdNativeLandingPagesUI.z(SnsAdNativeLandingPagesUI.this));
                  AppMethodBeat.o(219796);
                  return;
                  SnsAdNativeLandingPagesUI.K(SnsAdNativeLandingPagesUI.this);
                }
              }
            };
            SnsAdNativeLandingPagesUI.this.hideVKB();
            SnsAdNativeLandingPagesUI.G(SnsAdNativeLandingPagesUI.this).cPF();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(219797);
          }
        });
        AppMethodBeat.o(98365);
        return;
      }
      ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "canShowMenuBtn=false, disableShareBitSet=" + this.Api);
      this.xQh.setVisibility(8);
      AppMethodBeat.o(98365);
      return;
    }
  }
  
  private void report()
  {
    AppMethodBeat.i(98368);
    Object localObject1 = getAllComp();
    Object localObject2 = this.Apu.values().iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).addAll(((SnsAdLandingPageFloatView)((Iterator)localObject2).next()).getAllComp());
    }
    if (this.Apw != null)
    {
      ((List)localObject1).add(this.Apw);
      localObject2 = this.Apw.ead();
      if (localObject2 != null)
      {
        this.Apw.eac();
        ((List)localObject1).add(localObject2);
      }
    }
    if (this.Apv != null)
    {
      localObject2 = this.Apv.dUP();
      if (com.tencent.mm.plugin.sns.ad.f.c.m((Collection)localObject2)) {
        ((List)localObject1).addAll((Collection)localObject2);
      }
    }
    this.dCI += System.currentTimeMillis() - this.startTime;
    this.AoY.Adu = ((int)this.dCI);
    this.AoY.Adt = ((List)localObject1).size();
    localObject2 = this.AoY;
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      m localm = (m)((Iterator)localObject1).next();
      if (!localm.eaw().zRp)
      {
        JSONObject localJSONObject = new JSONObject();
        if ((!localm.E(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject2).Adx)) && (localm.aQ(localJSONObject))) {
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject2).Adx.put(localJSONObject);
        }
      }
    }
    ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "landingPage report json %s", new Object[] { this.AoY.Adx });
    localObject1 = this.AoY.ebJ();
    if (this.bizId == 2)
    {
      AdLandingPagesProxy.getInstance().doCgiReportCanvasBrowseInfo(15041, (String)localObject1);
      ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "post cgi stat 15041 data: ".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(98368);
      return;
    }
    if (AdLandingPagesProxy.getInstance().isRecExpAd(this.AoY.dAg))
    {
      com.tencent.mm.plugin.report.service.g.yxI.kvStat(14650, (String)localObject1);
      ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 14650 data: ".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(98368);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.kvStat(13387, (String)localObject1);
    ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 13387 data: ".concat(String.valueOf(localObject1)));
    AppMethodBeat.o(98368);
  }
  
  private void z(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(98375);
    String str = (String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.iconUrl");
    if (TextUtils.isEmpty(str))
    {
      this.zZV = null;
      AppMethodBeat.o(98375);
      return;
    }
    if (this.zZV == null) {
      this.zZV = new ao();
    }
    this.zZV.iconUrl = str;
    int k = bu.aSB((String)paramMap.get(paramString + ".adCanvasInfo.sizeType"));
    int i = bu.aSB((String)paramMap.get(paramString + ".adCanvasInfo.basicRootFontSize"));
    int j = bu.aSB((String)paramMap.get(paramString + ".adCanvasInfo.basicWidth"));
    if ((i == 0) && (k == 1)) {
      i = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.AcW;
    }
    for (;;)
    {
      if ((j == 0) && (k == 1)) {
        j = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.AcV;
      }
      for (;;)
      {
        this.zZV.paddingBottom = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(bu.aSD((String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.paddingBottom")), k, j, i);
        this.zZV.width = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(bu.aSD((String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.layoutWidth")), k, j, i);
        this.zZV.height = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(bu.aSD((String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.layoutHeight")), k, j, i);
        AppMethodBeat.o(98375);
        return;
      }
    }
  }
  
  public final void Av(long paramLong)
  {
    AppMethodBeat.i(98403);
    if ((this.Apw == null) || (this.AoJ == null))
    {
      AppMethodBeat.o(98403);
      return;
    }
    ContentFragment localContentFragment = eeT();
    if (localContentFragment == null)
    {
      AppMethodBeat.o(98403);
      return;
    }
    boolean bool1 = efc();
    boolean bool2 = localContentFragment.ebk();
    boolean bool3 = this.Apy;
    boolean bool4 = localContentFragment.zZW;
    boolean bool5 = localContentFragment.iXY;
    boolean bool6 = localContentFragment.ebj();
    boolean bool7 = this.Apx;
    boolean bool8 = localContentFragment.ebq();
    boolean bool9 = localContentFragment.ebp();
    if ((bool4) && (bool8)) {
      this.Apz = true;
    }
    if (!bool4) {
      this.Apz = true;
    }
    ae.d("MicroMsg.SnsAdNativeLandingPagesUI", "toggleFloatBarView, isSourceAllow=" + bool1 + ", isForbid=" + bool2 + ", isKeybordShow=" + bool3 + ", isFirstPage=" + bool4 + ", isLastPage=" + bool5 + ", isCoverVideo=" + bool6 + ", isVideoCtrlBarShow=" + bool7 + ", isTopAppearOk=" + bool8 + ", isBottomAppearOk=" + bool9 + ", IsTopAppearChecked=" + this.Apz);
    if (!bool1)
    {
      j(false, 0L);
      AppMethodBeat.o(98403);
      return;
    }
    if (bool2)
    {
      j(true, 0L);
      AppMethodBeat.o(98403);
      return;
    }
    if (bool3)
    {
      j(false, 0L);
      AppMethodBeat.o(98403);
      return;
    }
    if ((bool6) && (bool7))
    {
      j(true, 200L);
      AppMethodBeat.o(98403);
      return;
    }
    if ((bool5) && (!bool9))
    {
      j(true, 0L);
      AppMethodBeat.o(98403);
      return;
    }
    if ((bool4) && (!bool8) && (!this.Apz))
    {
      AppMethodBeat.o(98403);
      return;
    }
    AK(paramLong);
    AppMethodBeat.o(98403);
  }
  
  public final void F(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(98396);
    Intent localIntent = new Intent();
    localIntent.putExtra("sns_landig_pages_from_source", 14);
    int i;
    String str2;
    String str1;
    JSONObject localJSONObject;
    if (this.zRN == 0)
    {
      i = this.doj;
      localIntent.putExtra("sns_landig_pages_origin_from_source", i);
      localIntent.putExtra("sns_landing_pages_canvasid", paramString1);
      localIntent.putExtra("sns_landing_pages_canvas_ext", paramString2);
      localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
      localIntent.putExtra("sns_landing_pages_no_store", 1);
      str2 = ((Activity)paramContext).getIntent().getStringExtra("sns_landing_pages_sessionId");
      paramString2 = ((Activity)paramContext).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
      if (!bu.isNullOrNil(str2))
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
        if (bu.isNullOrNil(paramString2)) {
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
      AppMethodBeat.o(98396);
      return;
      i = this.zRN;
      break;
      paramString1 = "";
    }
  }
  
  public final void a(final y paramy, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, final boolean paramBoolean3)
  {
    AppMethodBeat.i(98395);
    if ((this.ApT != null) && (!paramBoolean3))
    {
      ae.w("MicroMsg.SnsAdNativeLandingPagesUI", "bottom sheet appear several times");
      this.ApT.bqD();
      if (this.ApU != null)
      {
        this.ApU.dismiss();
        this.ApU = null;
      }
      AppMethodBeat.o(98395);
      return;
    }
    AdLandingPagesProxy.e local18 = new AdLandingPagesProxy.e()
    {
      public final void be(Object paramAnonymousObject) {}
      
      public final void h(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(219813);
        SnsAdNativeLandingPagesUI.this.rT(false);
        if (paramBoolean3)
        {
          if (SnsAdNativeLandingPagesUI.W(SnsAdNativeLandingPagesUI.this) != null) {
            SnsAdNativeLandingPagesUI.W(SnsAdNativeLandingPagesUI.this).bqD();
          }
          if (SnsAdNativeLandingPagesUI.X(SnsAdNativeLandingPagesUI.this) != null)
          {
            SnsAdNativeLandingPagesUI.X(SnsAdNativeLandingPagesUI.this).dismiss();
            SnsAdNativeLandingPagesUI.Y(SnsAdNativeLandingPagesUI.this);
          }
        }
        AppMethodBeat.o(219813);
      }
    };
    AppCompatActivity localAppCompatActivity;
    LinearLayout localLinearLayout;
    if (!paramBoolean3)
    {
      localAppCompatActivity = getContext();
      localLinearLayout = new LinearLayout(getContext());
      if (bu.isNullOrNil(paramy.zRl)) {
        break label223;
      }
    }
    label223:
    for (int i = Color.parseColor(paramy.zRl);; i = -1)
    {
      paramy = av.a(localAppCompatActivity, paramy, localLinearLayout, i);
      this.ApT = new n(getContext(), paramy, paramString1, paramString2, paramString3, paramBoolean1, paramBoolean2);
      paramy = paramy.getView();
      this.ApT.zUZ = new n.a()
      {
        private void onRemove()
        {
          AppMethodBeat.i(219816);
          if ((paramy != null) && (paramy.getParent() != null)) {
            ((ViewGroup)paramy.getParent()).removeView(paramy);
          }
          SnsAdNativeLandingPagesUI.Z(SnsAdNativeLandingPagesUI.this);
          AppMethodBeat.o(219816);
        }
        
        public final void eaE()
        {
          AppMethodBeat.i(219814);
          ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "onDismiss");
          onRemove();
          AppMethodBeat.o(219814);
        }
        
        public final void eaF()
        {
          AppMethodBeat.i(219815);
          ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "onCancel");
          onRemove();
          AppMethodBeat.o(219815);
        }
      };
      this.ApT.cPF();
      if (!bu.isNullOrNil(paramString1))
      {
        AdLandingPagesProxy.getInstance().doFavOfficialItemScene(paramString1, local18);
        if (paramBoolean3) {
          this.ApU = com.tencent.mm.ui.base.h.b(this, getString(2131763886), false, null);
        }
      }
      AppMethodBeat.o(98395);
      return;
    }
  }
  
  public final void bYa()
  {
    AppMethodBeat.i(98384);
    Object localObject;
    try
    {
      Iterator localIterator1 = this.Apu.values().iterator();
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
      ae.printErrStackTrace("MicroMsg.SnsAdNativeLandingPagesUI", localException, "play exit animation error", new Object[0]);
      finish();
      AppMethodBeat.o(98384);
      return;
    }
    eeE();
    eeF();
    report();
    this.Apa = true;
    this.Apm.setVisibility(8);
    if (!this.AoN)
    {
      finish();
      AppMethodBeat.o(98384);
      return;
    }
    if (this.Aps)
    {
      ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "is playing animation");
      AppMethodBeat.o(98384);
      return;
    }
    ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "run exit animation, %s", new Object[] { Boolean.valueOf(this.AoN) });
    this.Aps = true;
    if (isSupportNavigationSwipeBack()) {
      getSwipeBackLayout().setEnableGesture(false);
    }
    Iterator localIterator2 = eeT().ebh().iterator();
    while (localIterator2.hasNext())
    {
      localObject = (m)localIterator2.next();
      if ((localObject instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a))
      {
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject).dZN();
        ((m)localObject).eaB();
      }
    }
    com.tencent.mm.sdk.platformtools.ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98342);
        SnsAdNativeLandingPagesUI.U(SnsAdNativeLandingPagesUI.this);
        AppMethodBeat.o(98342);
      }
    }, 30L);
    AppMethodBeat.o(98384);
  }
  
  public boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  public final com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af eaD()
  {
    AppMethodBeat.i(219823);
    if (this.zAi == null) {
      this.zAi = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af();
    }
    Object localObject1 = this.zAi;
    int i;
    if (this.zRN == 0) {
      i = this.doj;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af)localObject1).zRN = i;
      this.zAi.doj = this.doj;
      this.zAi.zRO = this.AoX;
      this.zAi.dGD = this.dGD;
      this.zAi.zRP = this.zRP;
      this.zAi.uin = this.uin;
      this.zAi.bizId = this.bizId;
      this.zAi.zMk = this.zMk;
      this.zAi.jWi = this.jWi;
      localObject1 = this.zAi;
      Object localObject2 = this.zRS;
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af)localObject1).zRS.putAll((Map)localObject2);
      localObject2 = this.zAi;
      label182:
      boolean bool;
      if (this.AoY != null)
      {
        localObject1 = this.AoY.kwD;
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af)localObject2).kwD = ((String)localObject1);
        localObject1 = this.zAi;
        if (this.AoJ == null) {
          break label393;
        }
        bool = true;
        label204:
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af)localObject1).zRQ = bool;
      }
      try
      {
        localObject2 = this.zAi;
        if (bu.isNullOrNil(this.dAg)) {
          if (this.AoY != null)
          {
            localObject1 = String.valueOf(com.tencent.mm.plugin.sns.data.k.aze(this.AoY.dAg));
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af)localObject2).dAg = ((String)localObject1);
            if (!bu.V(new String[] { this.aQj, this.zRR }))
            {
              this.zAi.aQj = this.aQj;
              this.zAi.zRR = this.zRR;
            }
            localObject1 = this.values;
            if (localObject1 == null) {}
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          for (;;)
          {
            localObject1 = (String)((Map)localObject1).get("." + this.AoQ + ".adExtInfo");
            this.zAi.zsJ = com.tencent.mm.plugin.sns.data.i.azd((String)localObject1);
            localObject1 = this.zAi;
            AppMethodBeat.o(219823);
            return localObject1;
            i = this.zRN;
            break;
            localObject1 = "";
            break label182;
            label393:
            bool = false;
            break label204;
            localObject1 = "";
            continue;
            long l = com.tencent.mm.plugin.sns.data.k.aze(this.dAg);
            localObject1 = String.valueOf(l);
          }
          localThrowable1 = localThrowable1;
          ae.e("MicroMsg.SnsAdNativeLandingPagesUI", localThrowable1.toString());
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            ae.e("MicroMsg.SnsAdNativeLandingPagesUI", "there is something wrong in set ad ext info");
          }
        }
      }
    }
  }
  
  public final void eeX()
  {
    AppMethodBeat.i(219824);
    try
    {
      boolean bool = eeY();
      ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "jumpNextPage, hasNextPage=".concat(String.valueOf(bool)));
      if (bool) {
        this.Aph.setCurrentItem$2563266(this.Aph.getCurrentItem() + 1);
      }
      AppMethodBeat.o(219824);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.SnsAdNativeLandingPagesUI", "jumpNextPage exp:" + localException.toString());
      AppMethodBeat.o(219824);
    }
  }
  
  public final boolean eeY()
  {
    AppMethodBeat.i(98397);
    try
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.Aph.getAdapter();
      int i = this.Aph.getCurrentItem();
      ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "hasNextPage, curPage=" + i + ", pageCount=" + localb.getCount());
      if (i < localb.getCount() - 1)
      {
        AppMethodBeat.o(98397);
        return true;
      }
      AppMethodBeat.o(98397);
      return false;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.SnsAdNativeLandingPagesUI", "hasNextPage exp:" + localException.toString());
      AppMethodBeat.o(98397);
    }
    return true;
  }
  
  public final boolean efb()
  {
    AppMethodBeat.i(98400);
    if (this.Apw != null)
    {
      boolean bool = this.Apw.isShowing();
      AppMethodBeat.o(98400);
      return bool;
    }
    AppMethodBeat.o(98400);
    return false;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495516;
  }
  
  @TargetApi(16)
  public void initView()
  {
    AppMethodBeat.i(98381);
    super.initView();
    this.Apl = ((FrameLayout)findViewById(2131304239));
    this.Apn = findViewById(2131298752);
    this.Aph = ((AdlandingDummyViewPager)findViewById(2131306298));
    this.Apm = findViewById(2131302239);
    ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "before, assistActivity");
    if (al.aH(getContext()))
    {
      final int i = al.aG(this);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.Apl.getLayoutParams();
      localLayoutParams.height = (this.lya - i);
      localLayoutParams.topMargin = i;
      this.Apl.setLayoutParams(localLayoutParams);
      getController().setActionbarColor(getResources().getColor(2131099873));
      this.Apl.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(219799);
          try
          {
            paramAnonymousView = new Rect();
            SnsAdNativeLandingPagesUI.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(paramAnonymousView);
            paramAnonymousInt1 = paramAnonymousView.top;
            ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "rect=" + paramAnonymousView.toString() + ", screenH=" + SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this) + ", cutH=" + i + ", statusBarH=" + paramAnonymousInt1);
            if (paramAnonymousInt1 > 0)
            {
              if (paramAnonymousInt1 != i)
              {
                ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "cutH != statusBarH, reset height");
                paramAnonymousView = (FrameLayout.LayoutParams)SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).getLayoutParams();
                paramAnonymousView.height = (SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this) - paramAnonymousInt1);
                paramAnonymousView.topMargin = paramAnonymousInt1;
                SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).setLayoutParams(paramAnonymousView);
                j.b(j.ztR, "", i, paramAnonymousInt1, SnsAdNativeLandingPagesUI.Q(SnsAdNativeLandingPagesUI.this) + "|" + SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this));
              }
              SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).removeOnLayoutChangeListener(this);
            }
            AppMethodBeat.o(219799);
            return;
          }
          catch (Throwable paramAnonymousView)
          {
            ae.e("MicroMsg.SnsAdNativeLandingPagesUI", "onLayoutChange error:" + paramAnonymousView.toString());
            SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).removeOnLayoutChangeListener(this);
            AppMethodBeat.o(219799);
          }
        }
      });
      com.tencent.mm.sdk.platformtools.ar.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98336);
          ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "hasCutOut, assistActivity");
          com.tencent.mm.ui.b.a(SnsAdNativeLandingPagesUI.this, true, SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this), SnsAdNativeLandingPagesUI.this.ApR);
          AppMethodBeat.o(98336);
        }
      }, 1500L);
    }
    for (;;)
    {
      this.iXI = ((ImageView)findViewById(2131300336));
      this.AoK = ((ImageView)findViewById(2131296672));
      this.hai = ((ImageView)findViewById(2131304901));
      this.hai.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(219800);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (SnsAdNativeLandingPagesUI.this.keyboardState() == 1) {
            SnsAdNativeLandingPagesUI.this.hideVKB();
          }
          SnsAdNativeLandingPagesUI.this.bYa();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(219800);
        }
      });
      this.xQh = ((ImageView)findViewById(2131304918));
      this.AoL = ((TextView)findViewById(2131304919));
      this.AoU = ((ImageView)findViewById(2131305019));
      if (this.AoN)
      {
        this.Apl.setAlpha(0.0F);
        this.iXI.setAlpha(0.0F);
        com.tencent.mm.ui.base.b.a(this, null);
      }
      AppMethodBeat.o(98381);
      return;
      com.tencent.mm.sdk.platformtools.ar.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(179171);
          ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "noCutOut, assistActivity");
          com.tencent.mm.ui.b.a(SnsAdNativeLandingPagesUI.this, false, SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this), SnsAdNativeLandingPagesUI.this.ApR);
          AppMethodBeat.o(179171);
        }
      }, 1500L);
    }
  }
  
  public final void j(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(98402);
    if (this.Apw != null)
    {
      ae.d("MicroMsg.SnsAdNativeLandingPagesUI", "hideFloatBarView");
      this.Apw.i(paramBoolean, paramLong);
    }
    AppMethodBeat.o(98402);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(98392);
    String str;
    Object localObject3;
    if (paramInt1 == 2001) {
      if (paramInt2 == -1)
      {
        ae.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "share to timeLine success");
        str = bu.nullAsNil(this.dGD);
        localObject3 = bu.nullAsNil(this.AoY.kwD);
      }
    }
    for (;;)
    {
      try
      {
        str = com.tencent.mm.plugin.sns.a.b.w("3", "", str, (String)localObject3);
        ae.i("AntiCheatingReportUtils", "reportScreenShotParams = ".concat(String.valueOf(str)));
        com.tencent.mm.plugin.report.service.g.yxI.kvStat(19214, str);
        com.tencent.mm.ui.base.h.cm(getContext(), getContext().getString(2131755894));
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        AppMethodBeat.o(98392);
        return;
      }
      catch (Throwable localThrowable1)
      {
        ae.e("AntiCheatingReportUtils", localThrowable1.toString());
        continue;
      }
      if (paramInt1 == 2)
      {
        ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "handleOpenInBrowserResult, ret=".concat(String.valueOf(((x)com.tencent.mm.kernel.g.ab(x.class)).a(this, paramInt1, paramInt2, paramIntent))));
      }
      else
      {
        int i;
        if (paramInt1 == 2002)
        {
          if (com.tencent.mm.plugin.sns.ad.f.e.getBooleanExtra(paramIntent, "kfavorite", false))
          {
            i = AdLandingPagesProxy.getInstance().doFav(paramIntent, 42);
            ((v)com.tencent.mm.kernel.g.ab(v.class)).a(i, this, this.ufz);
          }
        }
        else
        {
          Object localObject4;
          int j;
          int k;
          if (paramInt1 == 2004)
          {
            try
            {
              Object localObject1 = paramIntent.getStringExtra("KComponentCid");
              localObject3 = getAllComp().iterator();
              do
              {
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
                localObject4 = (m)((Iterator)localObject3).next();
              } while (!((m)localObject4).eaz().equals(localObject1));
              localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.af)localObject4;
              i = paramIntent.getIntExtra("KStreamVideoPlayCount", 0);
              j = paramIntent.getIntExtra("KStreamVideoPlayCompleteCount", 0);
              k = paramIntent.getIntExtra("KStreamVideoTotalPlayTimeInMs", 0);
              ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.af)localObject1).zpJ = (i + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.af)localObject1).zpJ);
              ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.af)localObject1).zpK += j;
              ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.af)localObject1).zpL += k;
            }
            catch (Exception localException) {}
          }
          else
          {
            Object localObject2;
            if (paramInt1 == 2003)
            {
              localObject2 = new uh();
              ((uh)localObject2).dJQ.EN = 1;
              ((uh)localObject2).dJQ.requestCode = paramInt1;
              ((uh)localObject2).dJQ.bZU = paramInt2;
              ((uh)localObject2).dJQ.dyD = paramIntent;
              com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
            }
            else if (paramInt1 == 2000)
            {
              boolean bool1;
              boolean bool2;
              int m;
              int n;
              int i1;
              int i2;
              long l;
              boolean bool3;
              int i3;
              try
              {
                localObject2 = paramIntent.getStringExtra("KComponentCid");
                localObject4 = getAllComp().iterator();
                do
                {
                  if (!((Iterator)localObject4).hasNext()) {
                    break;
                  }
                  localObject3 = (m)((Iterator)localObject4).next();
                } while (!((m)localObject3).eaz().equals(localObject2));
                i = paramIntent.getIntExtra("KComponentVideoType", 0);
                j = paramIntent.getIntExtra("KComponentCurrentTime", 0);
                bool1 = paramIntent.getBooleanExtra("KComponentVoiceType", false);
                bool2 = paramIntent.getBooleanExtra("KComponentProgressType", false);
                k = paramIntent.getIntExtra("KComponentClickPlayControlCount", 0);
                m = paramIntent.getIntExtra("KComponentDoubleClickCount", 0);
                n = paramIntent.getIntExtra("KComponentClickVoiceControlCount", 0);
                i1 = paramIntent.getIntExtra("KComponentPlayCompletedCount", 0);
                i2 = paramIntent.getIntExtra("KComponentPlayCount", 0);
                l = paramIntent.getLongExtra("KComponentPlayTimeInterval", 0L);
                bool3 = paramIntent.getBooleanExtra("KComponentIsWaiting", false);
                i3 = paramIntent.getIntExtra("KComponentSeekTimeDueWaiting", 0);
                localObject4 = paramIntent.getStringExtra("KComponentFullVideoFloatBarReportInfo");
                ae.i("NonFullOrFullVideoType", "videoType = " + i + ", cid = " + (String)localObject2 + ", currPosSec = " + j + ", bNoVoice = " + bool1 + ", isPlaying = " + bool2 + ", clickPlayControlCount = " + k + ", doubleClickCount = " + m + ", clickVoiceControlCount = " + n + ", playCompletedCount = " + i1 + ", playCount = " + i2 + ", playTimeInterval = " + l + ", floatBarReportInfo = " + (String)localObject4);
                if (i != 0) {
                  break label831;
                }
                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.af)localObject3).a(j, bool1, bool2, k, m, n, i1, i2, l, (String)localObject4);
              }
              catch (Throwable localThrowable2)
              {
                ae.e("NonFullOrFullVideoType", localThrowable2.toString());
              }
              continue;
              label831:
              if (i == 1) {
                ((aj)localObject3).a(j, bool1, bool2, k, m, n, i1, i2, l, bool3, i3, (String)localObject4);
              }
            }
          }
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(98386);
    bYa();
    AppMethodBeat.o(98386);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98363);
    super.onCreate(paramBundle);
    this.startTime = System.currentTimeMillis();
    this.enterTime = System.currentTimeMillis();
    this.AoY.enterTime = this.enterTime;
    an.aG(this);
    Object localObject = an.gp(this);
    this.lxZ = localObject[0];
    this.lya = localObject[1];
    this.AoM = paramBundle;
    this.mController.hideTitleView();
    this.oMR = getIntent().getIntExtra("img_gallery_top", 0);
    if (al.aH(this))
    {
      int i = al.aG(this);
      this.oMR -= i;
      ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "hasCutOut, h=" + i + ", thumbTop=" + this.oMR);
    }
    this.oMS = getIntent().getIntExtra("img_gallery_left", 0);
    this.oMT = getIntent().getIntExtra("img_gallery_width", 0);
    this.oMU = getIntent().getIntExtra("img_gallery_height", 0);
    getWindow().addFlags(128);
    this.isVisible = false;
    this.ApB = false;
    this.ApC = false;
    this.ApD = false;
    if (this.ApE != null) {
      this.ApE.removeCallbacks(this.ApO);
    }
    this.doj = getIntent().getIntExtra("sns_landig_pages_from_source", 0);
    this.zRN = getIntent().getIntExtra("sns_landig_pages_origin_from_source", 0);
    ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "source=" + this.doj + ", originScene=" + this.zRN);
    this.AoP = getIntent().getStringExtra("sns_landing_pages_xml");
    paramBundle = getIntent().getStringExtra("sns_landing_pages_too_large_xml_path");
    if ((bu.isNullOrNil(this.AoP)) && (!bu.isNullOrNil(paramBundle))) {
      this.AoP = an.aBj(paramBundle);
    }
    if (bu.isNullOrNil(this.AoP))
    {
      finish();
      initView();
      if (AdLandingPagesProxy.getInstance().isConnected()) {
        break label1055;
      }
      ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "isConnected==false");
      AdLandingPagesProxy.getInstance().connect(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98360);
          ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "after Connected");
          SnsAdNativeLandingPagesUI.x(SnsAdNativeLandingPagesUI.this);
          AppMethodBeat.o(98360);
        }
      });
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.IvT.c(this.ApN);
      try
      {
        registerReceiver(this.ApS, new IntentFilter("android.intent.action.SCREEN_ON"));
        AppMethodBeat.o(98363);
        return;
      }
      catch (Exception paramBundle)
      {
        ae.e("MicroMsg.SnsAdNativeLandingPagesUI", "registerReceiver, exp=" + paramBundle.toString());
        AppMethodBeat.o(98363);
      }
      this.AoP = this.AoP.replaceAll("</*RecXml[\\s|\\S]*?>", "");
      this.AoY.zGS = getIntent().getStringExtra("sns_landing_pages_expid");
      this.AoQ = getIntent().getStringExtra("sns_landing_pages_xml_prefix");
      this.dAg = getIntent().getStringExtra("sns_landing_pages_share_sns_id");
      this.AoW = getIntent().getStringExtra("sns_landing_pages_rawSnsId");
      this.dGD = getIntent().getStringExtra("sns_landing_pages_ux_info");
      this.zMk = getIntent().getStringExtra("sns_landing_pages_aid");
      this.jWi = getIntent().getStringExtra("sns_landing_pages_traceid");
      paramBundle = getIntent().getStringExtra("sns_landing_pages_search_extra");
      localObject = this.AoY;
      if (!TextUtils.isEmpty(paramBundle))
      {
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra.length() > 0) {
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra += "&";
        }
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra = (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra + "searchextra=" + URLEncoder.encode(paramBundle));
      }
      paramBundle = getIntent().getStringExtra("sns_landing_pages_extra");
      localObject = this.AoY;
      if (!TextUtils.isEmpty(paramBundle)) {
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra = (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra + "&extra1=" + URLEncoder.encode(paramBundle));
      }
      this.AoX = getIntent().getBooleanExtra("sns_landing_is_native_sight_ad", false);
      this.zNm = getIntent().getIntExtra("sns_landing_pages_rec_src", 0);
      this.Apb = getIntent().getIntExtra("sns_landing_pages_from_outer_index", 0);
      this.kwE = getIntent().getStringExtra("sns_landing_pages_ad_info");
      this.AoN = getIntent().getBooleanExtra("sns_landing_pages_need_enter_and_exit_animation", false);
      this.AoO = getIntent().getBooleanExtra("sns_landing_pages_is_normal_ad_animation", false);
      if (this.AoN) {
        this.AoY.gnM = 0;
      }
      for (this.AoY.fHy = 0;; this.AoY.fHy = 1)
      {
        this.AoY.pWb = this.doj;
        this.AoY.Adp = 0;
        this.AoY.Adq = 0;
        this.AoY.Adr = 1;
        this.AoY.Ads = 0;
        this.AoY.zRN = this.zRN;
        if ((this.AoQ == null) || ("".equals(this.AoP))) {
          this.AoQ = "adxml";
        }
        if ((!bu.isNullOrNil(this.AoP)) && (!bu.isNullOrNil(this.AoQ))) {
          break label986;
        }
        ae.e("MicroMsg.SnsAdNativeLandingPagesUI", "landingPagesXml is " + this.AoP + ",landingPagesXmlPrex is " + this.AoQ);
        break;
        this.AoY.gnM = 1;
      }
      label986:
      this.values = bx.M(this.AoP, this.AoQ);
      this.AoY.kwD = bu.bI((String)this.values.get("." + this.AoQ + ".adCanvasInfo.id"), "");
      break;
      label1055:
      ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "isConnected==true");
      eeB();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98366);
    getWindow().clearFlags(128);
    if (this.ApE != null) {
      this.ApE.removeCallbacks(this.ApO);
    }
    if (this.Apw != null) {
      this.Apw.dUM();
    }
    if (this.aMx)
    {
      ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "the SnsAdNativeLadingPagesUI is destroy, bHandleExit=" + this.Apa);
      if (!this.Apa)
      {
        eeF();
        report();
      }
    }
    for (;;)
    {
      this.Apu.clear();
      Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.Aph.getAdapter();
      if (localObject != null) {
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)localObject).fragments.clear();
      }
      try
      {
        unregisterReceiver(this.ApS);
        com.tencent.mm.sdk.b.a.IvT.d(this.ApN);
      }
      catch (Exception localException)
      {
        try
        {
          localObject = new ue();
          ((ue)localObject).dJH.dJI = 5;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
          label172:
          AdLandingPagesProxy.getInstance().clearCallback();
          super.onDestroy();
          AppMethodBeat.o(98366);
          return;
          ae.e("MicroMsg.SnsAdNativeLandingPagesUI", "onDestroy, isConnected=false");
          continue;
          localException = localException;
          ae.e("MicroMsg.SnsAdNativeLandingPagesUI", "unregisterReceiver, exp=" + localException.toString());
        }
        catch (Throwable localThrowable)
        {
          break label172;
        }
      }
    }
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(98393);
    super.onKeyboardStateChanged();
    ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "onKeyboardStateChanged, state=" + keyboardState());
    if (this.Aph != null) {
      this.Aph.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(219811);
          if (SnsAdNativeLandingPagesUI.this.keyboardState() != 1) {
            an.aG(SnsAdNativeLandingPagesUI.this);
          }
          if (!SnsAdNativeLandingPagesUI.V(SnsAdNativeLandingPagesUI.this))
          {
            new ArrayList();
            Iterator localIterator = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getAdapter()).fragments.iterator();
            while (localIterator.hasNext())
            {
              ContentFragment localContentFragment = (ContentFragment)localIterator.next();
              SnsAdNativeLandingPagesUI.this.keyboardState();
              localContentFragment.ebi();
            }
          }
          AppMethodBeat.o(219811);
        }
      }, 500L);
    }
    AppMethodBeat.o(98393);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(98372);
    super.onPause();
    ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "onPause");
    this.Apt = true;
    if (this.aMx) {
      this.dCI += System.currentTimeMillis() - this.startTime;
    }
    try
    {
      bi.a(this, null);
      this.AoZ = false;
      if (eeK())
      {
        Iterator localIterator = this.Apu.values().iterator();
        while (localIterator.hasNext()) {
          ((SnsAdLandingPageFloatView)localIterator.next()).onPause();
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ae.e("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", localThrowable.toString());
      }
      AdlandingDummyViewPager localAdlandingDummyViewPager = this.Aph;
      ViewPager.OnPageChangeListener localOnPageChangeListener = this.ApK;
      localAdlandingDummyViewPager.zZJ.remove(localOnPageChangeListener);
      android.support.v4.content.d.V(this).unregisterReceiver(this.ApH);
      android.support.v4.content.d.V(this).unregisterReceiver(this.ApI);
      com.tencent.mm.sdk.b.a.IvT.d(this.ApM);
      if (this.ApT != null) {
        this.ApT.bqD();
      }
      if ((this.Apw != null) && (this.Apw.isShowing())) {
        this.Apw.dUL();
      }
      AppMethodBeat.o(98372);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98371);
    ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "onResume");
    super.onResume();
    try
    {
      if (!this.AoZ)
      {
        ae.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "onResume callback");
        bi.a(this, this.ApP);
        this.AoZ = true;
      }
      an.aG(this);
      if (eeK())
      {
        i = this.Apl.getChildCount() - 1;
        if (i >= 0)
        {
          Object localObject = this.Apl.getChildAt(i);
          if ((localObject instanceof SnsAdLandingPageFloatView))
          {
            localObject = (SnsAdLandingPageFloatView)localObject;
            ((SnsAdLandingPageFloatView)localObject).onResume();
            AppMethodBeat.o(98371);
            return;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        int i;
        ae.e("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", localThrowable.toString());
        continue;
        i -= 1;
        continue;
        localAdlandingDummyViewPager = null;
      }
      this.Apt = false;
      AdlandingDummyViewPager localAdlandingDummyViewPager = this.Aph;
      ViewPager.OnPageChangeListener localOnPageChangeListener = this.ApK;
      localAdlandingDummyViewPager.zZJ.add(localOnPageChangeListener);
      android.support.v4.content.d.V(this).a(this.ApH, new IntentFilter("com.tencent.mm.adlanding.video_progressbar_change"));
      android.support.v4.content.d.V(this).a(this.ApI, new IntentFilter("com.tencent.mm.adlanding.set_uioption"));
      if (this.aMx) {
        this.startTime = System.currentTimeMillis();
      }
      com.tencent.mm.sdk.b.a.IvT.c(this.ApM);
      if (this.Apc) {
        rT(false);
      }
      if ((this.Apw != null) && (this.Apw.isShowing())) {
        this.Apw.dUK();
      }
      AppMethodBeat.o(98371);
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(179183);
    super.onStart();
    this.isVisible = true;
    if (this.aMx) {
      try
      {
        if ((!bu.V(new String[] { this.aQj, this.zRR })) && (!this.ApC))
        {
          if (this.ApD)
          {
            ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "execute mValidExposure onStart immediately");
            eeJ();
            AppMethodBeat.o(179183);
            return;
          }
          if (this.ApE != null)
          {
            ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "execute mValidExposureRunnable onStart");
            this.ApE.removeCallbacks(this.ApO);
            this.ApE.postDelayed(this.ApO, 1000L);
          }
        }
        AppMethodBeat.o(179183);
        return;
      }
      catch (Throwable localThrowable)
      {
        ae.e("MicroMsg.SnsAdNativeLandingPagesUI", localThrowable.toString());
      }
    }
    AppMethodBeat.o(179183);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(179184);
    super.onStop();
    this.isVisible = false;
    if (this.ApE != null) {
      this.ApE.removeCallbacks(this.ApO);
    }
    AppMethodBeat.o(179184);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(98373);
    this.AoY.fHy = 2;
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k localk = this.AoY;
    localk.Ads += 1;
    super.onSwipeBack();
    try
    {
      hideVKB();
      AppMethodBeat.o(98373);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.SnsAdNativeLandingPagesUI", "onSwipeBack hideVKB exp=" + localException.toString());
      AppMethodBeat.o(98373);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(219822);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    ae.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean) {}
    try
    {
      bi.a(this, null);
      this.AoZ = false;
      AppMethodBeat.o(219822);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
      ae.e("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", localThrowable.toString());
      AppMethodBeat.o(219822);
    }
    if (!this.AoZ)
    {
      ae.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "onWindowFocusChanged callback");
      bi.a(this, this.ApP);
      this.AoZ = true;
    }
    AppMethodBeat.o(219822);
    return;
  }
  
  public final void rT(boolean paramBoolean)
  {
    AppMethodBeat.i(98394);
    if ((paramBoolean) && (this.bizId == 1)) {
      AdLandingPagesProxy.getInstance().doDynamicUpdateScene(this.Apd, this.Ape, this.Apf, this.ApL);
    }
    if ((this.bizId == 2) && (!bu.isNullOrNil(this.Apg))) {
      AdLandingPagesProxy.getInstance().doSearchDynamicUpdateScene(this.Apg, this.ApL);
    }
    this.Apc = true;
    AppMethodBeat.o(98394);
  }
  
  final class a
  {
    public String qlw = "";
    public String uly = "";
    public String zPc = "";
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI
 * JD-Core Version:    0.7.0.1
 */