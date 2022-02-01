package com.tencent.mm.plugin.sns.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
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
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.g.a.oa.a;
import com.tencent.mm.g.a.th;
import com.tencent.mm.g.a.tk;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.model.AdlandingRemoteServiceConnectedReceiver;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ag;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdlandingDummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a;
import com.tencent.mm.plugin.sns.storage.b.k;
import com.tencent.mm.plugin.sns.storage.b.l;
import com.tencent.mm.plugin.sns.ui.helper.FloatWebViewHelper;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView.1;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView.2;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView.3;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView.4;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView.5;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView.6;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.dcu;
import com.tencent.mm.protocal.protobuf.dcv;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bg.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.b.a;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.snackbar.a.b;
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
  public static int yHa = 1000;
  public static int yHb = 1000;
  private boolean aKG;
  private int bizId;
  private int dbL;
  String dnn;
  private long dpQ;
  private String dtx;
  private String dyy;
  private long enterTime;
  private ImageView gDM;
  private ImageView iBF;
  private volatile boolean isVisible;
  private String jYS;
  private String jyU;
  private int kWB;
  private int kWC;
  private int ocW;
  private int ocX;
  private int ocY;
  private int ocZ;
  String pBl;
  String pBm;
  private volatile boolean rwO;
  protected a.b sXH;
  private long startTime;
  String tcG;
  private String uin;
  private Map<String, String> values;
  private ImageView wss;
  private com.tencent.mm.plugin.sns.storage.p xIq;
  private String yGA;
  private String yGB;
  private String yGC;
  private String yGD;
  private AdlandingDummyViewPager yGE;
  private int yGF;
  private int yGG;
  private ao yGH;
  private FrameLayout yGI;
  private View yGJ;
  private View yGK;
  private boolean yGL;
  private List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k> yGM;
  private com.tencent.mm.plugin.sns.ui.b.c yGN;
  private com.tencent.mm.plugin.sns.ui.b.d yGO;
  private boolean yGP;
  private ae yGQ;
  private Map<String, SnsAdLandingPageFloatView> yGR;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d yGS;
  private boolean yGT;
  public boolean yGU;
  private boolean yGV;
  private volatile boolean yGW;
  private volatile boolean yGX;
  private volatile boolean yGY;
  private ao yGZ;
  public ab yGg;
  private ImageView yGh;
  private TextView yGi;
  Bundle yGj;
  private boolean yGk;
  private boolean yGl;
  private String yGm;
  private String yGn;
  private String yGo;
  private String yGp;
  private String yGq;
  private ImageView yGr;
  String yGs;
  String yGt;
  private boolean yGu;
  com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k yGv;
  private volatile boolean yGw;
  boolean yGx;
  private int yGy;
  private boolean yGz;
  private BroadcastReceiver yHc;
  private BroadcastReceiver yHd;
  private ContentFragment.a yHe;
  private ViewPager.OnPageChangeListener yHf;
  private AdLandingPagesProxy.e yHg;
  private com.tencent.mm.sdk.b.c<oa> yHh;
  private com.tencent.mm.sdk.b.c<th> yHi;
  private Runnable yHj;
  private bg.a yHk;
  private Map<Integer, ContentFragment> yHl;
  public b.a yHm;
  private BroadcastReceiver yHn;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l yHo;
  private com.tencent.mm.ui.base.p yHp;
  private String yeO;
  private String yeP;
  private int yfP;
  private int yft;
  private int yjY;
  private String yka;
  private String ykc;
  private Map<String, String> ykd;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al yrE;
  public LinkedList<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g> yuE;
  
  public SnsAdNativeLandingPagesUI()
  {
    AppMethodBeat.i(98362);
    this.yuE = new LinkedList();
    this.ocW = 0;
    this.ocX = 0;
    this.ocY = 0;
    this.ocZ = 0;
    this.yGk = false;
    this.yGl = false;
    this.yGu = false;
    this.dpQ = 0L;
    this.enterTime = 0L;
    this.ykd = new HashMap();
    this.yGv = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k();
    this.yGw = false;
    this.yGx = false;
    this.yGy = 0;
    this.yGz = false;
    this.yGH = new ao();
    this.yGL = true;
    this.aKG = false;
    this.yGR = new HashMap();
    this.yGT = false;
    this.yGU = false;
    this.yGV = false;
    this.isVisible = false;
    this.yGW = false;
    this.yGX = false;
    this.yGY = false;
    this.yGZ = new ao();
    this.yHc = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        boolean bool = true;
        AppMethodBeat.i(98324);
        int i = paramAnonymousIntent.getIntExtra("show", 0);
        paramAnonymousContext = (ContentFragment)((android.support.v4.app.i)SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getAdapter()).getItem(SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getCurrentItem());
        ac.d("MicroMsg.SnsAdNativeLandingPagesUI", "recv videoProgressbarStatusChangeReceiver show %d", new Object[] { Integer.valueOf(i) });
        if (i == 1) {}
        for (;;)
        {
          SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this, bool);
          SnsAdNativeLandingPagesUI.this.xz(500L);
          paramAnonymousContext.rc(bool);
          AppMethodBeat.o(98324);
          return;
          bool = false;
        }
      }
    };
    this.yHd = new SnsAdNativeLandingPagesUI.12(this);
    this.yHe = new ContentFragment.a()
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
              ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "onPreDraw %d, %d", new Object[] { Integer.valueOf(SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).getHeight()), Integer.valueOf(SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this)) });
              Object localObject1 = null;
              Object localObject2 = SnsAdNativeLandingPagesUI.d(SnsAdNativeLandingPagesUI.this);
              int i;
              if (localObject2 != null)
              {
                localObject1 = ((af)localObject2).dKX();
                if (localObject1 != null)
                {
                  localObject1 = ((t)localObject1).yho;
                  localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.jp((String)localObject1, "scene_ad_landing");
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
                  ac.i("SphereImageView.SnsAdNativeLandingPagesUI", i);
                }
              }
              else
              {
                if (!SnsAdNativeLandingPagesUI.f(SnsAdNativeLandingPagesUI.this)) {
                  break label245;
                }
                com.tencent.mm.sdk.platformtools.ap.n(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(98349);
                    Bitmap localBitmap;
                    if (this.yHx != null) {
                      localBitmap = this.yHx;
                    }
                    while (localBitmap != null)
                    {
                      SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).setAlpha(1.0F);
                      SnsAdNativeLandingPagesUI.h(SnsAdNativeLandingPagesUI.this).setImageBitmap(localBitmap);
                      SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this, SnsAdNativeLandingPagesUI.20.1.this.mzS, localBitmap.getWidth(), localBitmap.getHeight());
                      AppMethodBeat.o(98349);
                      return;
                      if (SnsAdNativeLandingPagesUI.g(SnsAdNativeLandingPagesUI.this))
                      {
                        localBitmap = f.fL(SnsAdNativeLandingPagesUI.20.1.this.mzS.getChildAt(0));
                        SnsAdNativeLandingPagesUI.h(SnsAdNativeLandingPagesUI.this).setScaleType(ImageView.ScaleType.CENTER_CROP);
                      }
                      else
                      {
                        localBitmap = f.fL(SnsAdNativeLandingPagesUI.e(SnsAdNativeLandingPagesUI.this));
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
                SnsAdNativeLandingPagesUI.this.xz(300L);
              }
            }
          });
        }
        AppMethodBeat.o(98351);
      }
    };
    this.yHf = new ViewPager.f()
    {
      public final void onPageScrollStateChanged(int paramAnonymousInt)
      {
        AppMethodBeat.i(98353);
        super.onPageScrollStateChanged(paramAnonymousInt);
        SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this).yrM = paramAnonymousInt;
        Object localObject;
        if (paramAnonymousInt == 1)
        {
          paramAnonymousInt = 0;
          while (paramAnonymousInt < SnsAdNativeLandingPagesUI.this.yuE.size())
          {
            localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)SnsAdNativeLandingPagesUI.this.yuE.get(paramAnonymousInt);
            localObject = (Fragment)SnsAdNativeLandingPagesUI.k(SnsAdNativeLandingPagesUI.this).get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject).id));
            if (localObject != null) {
              ((ContentFragment)localObject).dLt();
            }
            paramAnonymousInt += 1;
          }
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al.gh(SnsAdNativeLandingPagesUI.this.getContext());
          AppMethodBeat.o(98353);
          return;
        }
        if (paramAnonymousInt == 0)
        {
          localObject = (Fragment)SnsAdNativeLandingPagesUI.k(SnsAdNativeLandingPagesUI.this).get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)SnsAdNativeLandingPagesUI.this.yuE.get(SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getCurrentItem())).id));
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
          if ((localContentFragment.cqM) && (localContentFragment.yrC != null)) {
            localContentFragment.yrC.dLi();
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
        if (i < SnsAdNativeLandingPagesUI.this.yuE.size())
        {
          Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)SnsAdNativeLandingPagesUI.this.yuE.get(i);
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
            ((ContentFragment)localObject).dLt();
          }
        }
        SnsAdNativeLandingPagesUI.this.xz(300L);
        AppMethodBeat.o(98354);
      }
    };
    this.yHg = new AdLandingPagesProxy.e()
    {
      public final void bc(final Object paramAnonymousObject)
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
            localObject = new i.a(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.jy((String)localObject, str), SnsAdNativeLandingPagesUI.n(SnsAdNativeLandingPagesUI.this));
            SnsAdNativeLandingPagesUI.this.yuE = ((i.a)localObject).yuE;
            SnsAdNativeLandingPagesUI.this.yGg = ((i.a)localObject).yuF;
            com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
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
    this.yHh = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(oa paramAnonymousoa)
      {
        AppMethodBeat.i(176294);
        Object localObject1;
        SnsAdLandingPageFloatView localSnsAdLandingPageFloatView;
        if ((SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this).yry.yux != null) && (SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this).yry.yux.containsKey(paramAnonymousoa.dqw.dqx)) && (!SnsAdNativeLandingPagesUI.r(SnsAdNativeLandingPagesUI.this).containsKey(paramAnonymousoa.dqw.dqx)))
        {
          SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this).onPause();
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("sns_landing_pages_xml", SnsAdNativeLandingPagesUI.m(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putString("sns_float_component_id", paramAnonymousoa.dqw.dqx);
          ((Bundle)localObject1).putInt("sns_landing_page_index", SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this).yry.id);
          ((Bundle)localObject1).putString("sns_landing_page_snsId", SnsAdNativeLandingPagesUI.this.dnn);
          ((Bundle)localObject1).putString("sns_landing_pages_rawSnsId", SnsAdNativeLandingPagesUI.this.yGt);
          ((Bundle)localObject1).putString("sns_landing_pages_ux_info", SnsAdNativeLandingPagesUI.s(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putString("sns_landing_pages_aid", SnsAdNativeLandingPagesUI.o(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putInt("sns_landing_pages_biz_id", SnsAdNativeLandingPagesUI.t(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putString("sns_landing_pages_traceid", SnsAdNativeLandingPagesUI.p(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putInt("sns_landig_pages_from_source", SnsAdNativeLandingPagesUI.u(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putString("sns_landing_pages_xml_prefix", SnsAdNativeLandingPagesUI.n(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putBoolean("sns_landing_is_native_sight_ad", SnsAdNativeLandingPagesUI.v(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putString("sns_landing_pages_canvas_ext", SnsAdNativeLandingPagesUI.w(SnsAdNativeLandingPagesUI.this));
          localSnsAdLandingPageFloatView = new SnsAdLandingPageFloatView(SnsAdNativeLandingPagesUI.this);
          localSnsAdLandingPageFloatView.yGm = ((Bundle)localObject1).getString("sns_landing_pages_xml");
          localSnsAdLandingPageFloatView.dqx = ((Bundle)localObject1).getString("sns_float_component_id");
          localSnsAdLandingPageFloatView.zkd = ((Bundle)localObject1).getInt("sns_landing_page_index", -1);
          localSnsAdLandingPageFloatView.dtx = ((Bundle)localObject1).getString("sns_landing_pages_ux_info");
          localSnsAdLandingPageFloatView.zkf = ((Bundle)localObject1).getString("sns_landing_pages_aid");
          localSnsAdLandingPageFloatView.jyU = ((Bundle)localObject1).getString("sns_landing_pages_traceid");
          localSnsAdLandingPageFloatView.yeP = ((Bundle)localObject1).getString("sns_landing_pages_canvas_ext");
          if ((!bs.T(new String[] { localSnsAdLandingPageFloatView.yGm, localSnsAdLandingPageFloatView.dqx })) && (localSnsAdLandingPageFloatView.zkd != -1)) {
            break label521;
          }
          ac.e("MicroMsg.SnsAdLandingPageFloatView", "invalid landing float page data!");
        }
        for (;;)
        {
          localSnsAdLandingPageFloatView.setBackgroundColor(SnsAdNativeLandingPagesUI.this.getResources().getColor(2131100893));
          SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).addView(localSnsAdLandingPageFloatView, SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).getChildCount() - 1, new FrameLayout.LayoutParams(-1, -1));
          if (!localSnsAdLandingPageFloatView.yZo)
          {
            localSnsAdLandingPageFloatView.zkk.start();
            localSnsAdLandingPageFloatView.yZo = true;
          }
          SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this).dLt();
          SnsAdNativeLandingPagesUI.this.j(false, 0L);
          SnsAdNativeLandingPagesUI.r(SnsAdNativeLandingPagesUI.this).put(paramAnonymousoa.dqw.dqx, localSnsAdLandingPageFloatView);
          AppMethodBeat.o(176294);
          return false;
          label521:
          localSnsAdLandingPageFloatView.zke = bs.bG(((Bundle)localObject1).getString("sns_landing_pages_xml_prefix"), "adxml");
          localSnsAdLandingPageFloatView.yuE = new i.a(localSnsAdLandingPageFloatView.yGm, localSnsAdLandingPageFloatView.zke).yuE;
          Object localObject2;
          if ((localSnsAdLandingPageFloatView.yuE != null) && (localSnsAdLandingPageFloatView.yuE.size() > localSnsAdLandingPageFloatView.zkd))
          {
            localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localSnsAdLandingPageFloatView.yuE.get(localSnsAdLandingPageFloatView.zkd);
            localSnsAdLandingPageFloatView.zkh = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g();
            localSnsAdLandingPageFloatView.zkh.jBX = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject1).jBX;
            localObject2 = (x)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject1).yux.get(localSnsAdLandingPageFloatView.dqx);
            if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.OZ(((x)localObject2).type))
            {
              localSnsAdLandingPageFloatView.zkg = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v)localObject2);
              localSnsAdLandingPageFloatView.zkh.yuw.add(localSnsAdLandingPageFloatView.zkg);
              localSnsAdLandingPageFloatView.zkh.yux.putAll(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject1).yux);
            }
            localSnsAdLandingPageFloatView.zkh.id = 0;
            localSnsAdLandingPageFloatView.zkh.yuy = true;
          }
          ac.i("MicroMsg.SnsAdLandingPageFloatView", "[reportInfo] aid %s,traceId %s,uxInfo %s,adCanvasExtXml %s", new Object[] { localSnsAdLandingPageFloatView.zkf, localSnsAdLandingPageFloatView.jyU, localSnsAdLandingPageFloatView.dtx, localSnsAdLandingPageFloatView.yeP });
          if (localSnsAdLandingPageFloatView.zkh == null) {
            continue;
          }
          if (localSnsAdLandingPageFloatView.zkg != null) {}
          try
          {
            i = Color.parseColor(localSnsAdLandingPageFloatView.zkh.jBX);
            localSnsAdLandingPageFloatView.zki = as.a(localSnsAdLandingPageFloatView.getContext(), localSnsAdLandingPageFloatView.zkg, localSnsAdLandingPageFloatView, i);
            localSnsAdLandingPageFloatView.zki.setBackgroundColor(i);
            localSnsAdLandingPageFloatView.zkj = localSnsAdLandingPageFloatView.zki.getView();
            localSnsAdLandingPageFloatView.addView(localSnsAdLandingPageFloatView.zkj);
            localSnsAdLandingPageFloatView.zki.dKE();
            localSnsAdLandingPageFloatView.setOnTouchListener(new SnsAdLandingPageFloatView.6(localSnsAdLandingPageFloatView));
            localSnsAdLandingPageFloatView.dSA();
            localObject1 = ValueAnimator.ofFloat(new float[] { 0.4F, 0.96F }).setDuration(200L);
            ((ValueAnimator)localObject1).setInterpolator(new OvershootInterpolator());
            localObject2 = ValueAnimator.ofFloat(new float[] { 0.96F, 1.0F }).setDuration(100L);
            ((ValueAnimator)localObject1).addUpdateListener(new SnsAdLandingPageFloatView.1(localSnsAdLandingPageFloatView));
            ((ValueAnimator)localObject2).addUpdateListener(new SnsAdLandingPageFloatView.2(localSnsAdLandingPageFloatView));
            localSnsAdLandingPageFloatView.zkk.playSequentially(new Animator[] { localObject1, localObject2 });
            localSnsAdLandingPageFloatView.zkk.addListener(new SnsAdLandingPageFloatView.3(localSnsAdLandingPageFloatView));
            localSnsAdLandingPageFloatView.ukz.addUpdateListener(new SnsAdLandingPageFloatView.4(localSnsAdLandingPageFloatView));
            localSnsAdLandingPageFloatView.ukz.addListener(new SnsAdLandingPageFloatView.5(localSnsAdLandingPageFloatView));
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ac.e("MicroMsg.SnsAdLandingPageFloatView", "parseColor exp=" + localException.toString() + ", colorStr=" + localSnsAdLandingPageFloatView.zkh.jBX);
              int i = 0;
            }
          }
        }
      }
    };
    this.yHi = new com.tencent.mm.sdk.b.c() {};
    this.yHj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98329);
        SnsAdNativeLandingPagesUI.H(SnsAdNativeLandingPagesUI.this);
        if ((!SnsAdNativeLandingPagesUI.I(SnsAdNativeLandingPagesUI.this)) && (SnsAdNativeLandingPagesUI.J(SnsAdNativeLandingPagesUI.this))) {
          SnsAdNativeLandingPagesUI.K(SnsAdNativeLandingPagesUI.this);
        }
        AppMethodBeat.o(98329);
      }
    };
    this.yHk = new SnsAdNativeLandingPagesUI.5(this);
    this.yHl = new HashMap();
    this.sXH = new SnsAdNativeLandingPagesUI.14(this);
    this.yHm = new b.a()
    {
      public final void bt(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(200455);
        SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this, paramAnonymousBoolean);
        ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "onKeyboardStateChanged, visiable=".concat(String.valueOf(paramAnonymousBoolean)));
        SnsAdNativeLandingPagesUI.this.xz(300L);
        AppMethodBeat.o(200455);
      }
    };
    this.yHn = new SnsAdNativeLandingPagesUI.17(this);
    this.yHo = null;
    this.yHp = null;
    AppMethodBeat.o(98362);
  }
  
  private static boolean Pt(int paramInt)
  {
    AppMethodBeat.i(200463);
    if ((paramInt == 3) || (paramInt == 5) || (paramInt == 4)) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "isNeedUpdateUxinfo, source=" + paramInt + ", ret=" + bool);
      AppMethodBeat.o(200463);
      return bool;
    }
  }
  
  private void WJ()
  {
    AppMethodBeat.i(98374);
    this.xIq = AdLandingPagesProxy.getInstance().getSnsInfo(this.dnn);
    AdLandingPagesProxy.getInstance().asyncCacheXml(this.dnn);
    if (this.values == null)
    {
      ac.e("MicroMsg.SnsAdNativeLandingPagesUI", "parse landingpagexml is error,landingpagexml is " + this.yGm);
      AppMethodBeat.o(98374);
      return;
    }
    long l;
    Object localObject2;
    Object localObject3;
    label624:
    int i;
    if ((this.dbL == 1) || (this.dbL == 2) || (this.dbL == 16) || (this.dbL == 14) || (this.dbL == 9) || (this.dbL == 10))
    {
      l = 0L;
      if (this.xIq != null)
      {
        l = this.xIq.field_snsId;
        this.yeO = AdLandingPagesProxy.getInstance().getSnsAid(this.dnn);
        this.jyU = AdLandingPagesProxy.getInstance().getSnsTraceid(this.dnn);
        this.yft = AdLandingPagesProxy.getInstance().getSnsAdType(this.dnn);
        this.dtx = AdLandingPagesProxy.getInstance().getSnsUxInfo(this.dnn);
        this.yeP = AdLandingPagesProxy.getInstance().getSnsAdCanvasExtXml(this.dnn);
      }
      if (this.yGt != null)
      {
        localObject1 = this.yGt;
        this.values.put("." + this.yGn + ".originSnsId", localObject1);
        this.values.put("." + this.yGn + ".originUxInfo", this.dtx);
        localObject2 = "<" + this.yGn + ">";
        localObject2 = (String)localObject2 + String.format("<originSnsId>%s</originSnsId>", new Object[] { localObject1 });
        localObject2 = (String)localObject2 + String.format("<originUxInfo>%s</originUxInfo>", new Object[] { this.dtx });
        localObject2 = (String)localObject2 + String.format("<originAdType>%d</originAdType>", new Object[] { Integer.valueOf(this.yft) });
        localObject2 = (String)localObject2 + String.format("<originAid>%s</originAid>", new Object[] { this.yeO });
        localObject3 = (String)localObject2 + String.format("<originTraceId>%s</originTraceId>", new Object[] { this.jyU });
        localObject2 = localObject3;
        if (!bs.isNullOrNil(this.yeP)) {
          localObject2 = (String)localObject3 + String.format("<originAdCanvasExt>%s</originAdCanvasExt>", new Object[] { this.yeP });
        }
        this.yGm = this.yGm.replace("<" + this.yGn + ">", (CharSequence)localObject2);
        this.yGv.dtx = this.dtx;
        this.yGv.dnn = ((String)localObject1);
        ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "reportInfo aid [%s],traceId [%s],adType [%s],uxInfo [%s],adCanvasExtXml [%s]", new Object[] { this.yeO, this.jyU, Integer.valueOf(this.yft), this.dtx, this.yeP });
        if (bs.isNullOrNil(this.yeP)) {
          break label1407;
        }
        localObject2 = bv.L(this.yeP, "adCardItemList");
        if (localObject2 == null) {
          break label1407;
        }
        i = 0;
        label704:
        if (i <= 0) {
          break label2730;
        }
      }
    }
    label2564:
    label2730:
    for (Object localObject1 = ".adCardItemList.cardItem" + i;; localObject1 = ".adCardItemList.cardItem")
    {
      if (((Map)localObject2).containsKey((String)localObject1 + ".cardTpId"))
      {
        localObject3 = bs.bG((String)((Map)localObject2).get((String)localObject1 + ".cardTpId"), "");
        localObject1 = bs.bG((String)((Map)localObject2).get((String)localObject1 + ".cardExt"), "");
        if ((!bs.isNullOrNil((String)localObject3)) && (!bs.isNullOrNil((String)localObject1))) {
          this.ykd.put(localObject3, localObject1);
        }
        i += 1;
        break label704;
        localObject1 = String.valueOf(l);
        break;
        this.yGv.dnn = ((String)this.values.get("." + this.yGn + ".originSnsId"));
        this.yGv.dtx = ((String)this.values.get("." + this.yGn + ".originUxInfo"));
        this.dtx = this.yGv.dtx;
        this.yGt = this.yGv.dnn;
        this.yft = bs.aLy((String)this.values.get("." + this.yGn + ".originAdType"));
        this.yeO = ((String)this.values.get("." + this.yGn + ".originAid"));
        this.jyU = ((String)this.values.get("." + this.yGn + ".originTraceId"));
        if (!bs.isNullOrNil(this.jYS))
        {
          localObject1 = bv.L(this.jYS, "ADInfo");
          ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "adInfoXml %s", new Object[] { this.jYS });
          if (localObject1 != null)
          {
            this.dtx = bs.bG((String)((Map)localObject1).get(".ADInfo.uxInfo"), "");
            this.yGv.dtx = this.dtx;
            this.yeO = bs.bG((String)((Map)localObject1).get(".ADInfo.session_data.aid"), "");
            this.jyU = bs.bG((String)((Map)localObject1).get(".ADInfo.session_data.trace_id"), "");
            this.dyy = bs.bG((String)((Map)localObject1).get(".ADInfo.viewid"), "");
            this.ykc = bs.bG((String)((Map)localObject1).get(".ADInfo.commInfo"), "");
            ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "viewId = " + this.dyy + ", commInfo = " + this.ykc + ", uxInfo = " + this.dtx);
          }
        }
        localObject1 = Pattern.compile("<originAdCanvasExt>[\\s\\S]*</originAdCanvasExt>").matcher(this.yGm);
        if (!((Matcher)localObject1).find()) {
          break label624;
        }
        localObject1 = ((Matcher)localObject1).group();
        if (bs.isNullOrNil((String)localObject1)) {
          break label624;
        }
        this.yeP = ((String)localObject1).replaceAll("</?originAdCanvasExt>", "");
        break label624;
      }
      label1407:
      this.yGv.yvb = AdLandingPagesProxy.getInstance().getSnsStatExtBySnsId(bs.aLz(this.yGv.dnn));
      this.pBm = bs.bG((String)this.values.get("." + this.yGn + ".adCanvasInfo.shareTitle"), "");
      this.pBl = bs.bG((String)this.values.get("." + this.yGn + ".adCanvasInfo.shareWebUrl"), "");
      this.tcG = bs.bG((String)this.values.get("." + this.yGn + ".adCanvasInfo.shareDesc"), "");
      this.bizId = bs.aLy(bs.bG((String)this.values.get("." + this.yGn + ".adCanvasInfo.bizId"), ""));
      this.yGA = bs.bG((String)this.values.get("." + this.yGn + ".adCanvasInfo.shareAppId"), "");
      this.yGB = bs.bG((String)this.values.get("." + this.yGn + ".adCanvasInfo.shareType"), "");
      this.yGC = bs.bG((String)this.values.get("." + this.yGn + ".adCanvasInfo.userInfo"), "");
      this.yGF = bs.aLy(bs.bG((String)this.values.get("." + this.yGn + ".adCanvasInfo.disableShareBitSet"), ""));
      this.yGG = bs.aLy(bs.bG((String)this.values.get("." + this.yGn + ".adCanvasInfo.statusBarStyle"), ""));
      w(this.values, "." + this.yGn);
      this.uin = AdLandingPagesProxy.getInstance().getUin();
      this.yGD = bs.bG((String)this.values.get("." + this.yGn + ".adCanvasInfo.officialSyncBuffer"), "");
      getIntent().putExtra("sns_landing_pages_adType", this.yft);
      getIntent().putExtra("sns_landing_pages_rawSnsId", this.yGv.dnn);
      if (bs.isNullOrNil(this.yeO)) {
        this.yeO = bs.bG((String)this.values.get("." + this.yGn + ".originAid"), "");
      }
      if (bs.isNullOrNil(this.jyU)) {
        this.jyU = bs.bG((String)this.values.get("." + this.yGn + ".originTraceId"), "");
      }
      localObject1 = new i.a(this.yGm, this.yGn);
      this.yuE = ((i.a)localObject1).yuE;
      this.yGg = ((i.a)localObject1).yuF;
      dPc();
      a((i.a)localObject1);
      if (this.yuE.size() > 0)
      {
        localObject2 = "";
        localObject3 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.yuE.get(0);
        localObject1 = localObject2;
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject3).yuw.size() > 0)
        {
          localObject3 = (x)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject3).yuw.get(0);
          if (!(localObject3 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)) {
            break label2564;
          }
          this.yGs = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)localObject3).yjd;
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        if (this.xIq != null)
        {
          localObject2 = this.xIq.dLV();
          if ((localObject2 != null) && (((TimeLineObject)localObject2).FQo != null) && (((TimeLineObject)localObject2).FQo.Etz != null) && (!((TimeLineObject)localObject2).FQo.Etz.isEmpty()))
          {
            localObject3 = (btz)((TimeLineObject)localObject2).FQo.Etz.getFirst();
            localObject2 = an.jc(AdLandingPagesProxy.getInstance().getAccSnsPath(), ((btz)localObject3).Id) + com.tencent.mm.plugin.sns.data.q.i((btz)localObject3);
            localObject3 = ((btz)localObject3).Url;
            if (((String)localObject1).equals(localObject3))
            {
              localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jt("adId", (String)localObject3);
              if ((!com.tencent.mm.vfs.i.eA((String)localObject1)) && (com.tencent.mm.vfs.i.eA((String)localObject2)))
              {
                ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "copy outsideFiel:%s->%s", new Object[] { localObject2, localObject1 });
                com.tencent.mm.vfs.i.lZ((String)localObject2, (String)localObject1);
              }
            }
          }
        }
        this.yGo = bs.bG((String)this.values.get("." + this.yGn + ".adCanvasInfo.rightBarTitle"), "");
        this.yGp = bs.bG((String)this.values.get("." + this.yGn + ".adCanvasInfo.rightBarCanvasId"), "");
        this.yGq = bs.bG((String)this.values.get("." + this.yGn + ".adCanvasInfo.rightBarCanvasExt"), "");
        AppMethodBeat.o(98374);
        return;
        if ((localObject3 instanceof r))
        {
          this.yGs = ((r)localObject3).yjd;
          localObject1 = localObject2;
        }
        else if ((localObject3 instanceof u))
        {
          this.yGs = ((u)localObject3).yjj;
          localObject1 = ((u)localObject3).yji;
        }
        else
        {
          localObject1 = localObject2;
          if ((localObject3 instanceof ag))
          {
            localObject3 = (ag)localObject3;
            localObject1 = localObject2;
            if (!((ag)localObject3).yjb.isEmpty())
            {
              localObject3 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)((ag)localObject3).yjb.getFirst();
              localObject1 = localObject2;
              if (!((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)localObject3).yjb.isEmpty())
              {
                localObject3 = (x)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)localObject3).yjb.getFirst();
                localObject1 = localObject2;
                if ((localObject3 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s))
                {
                  this.yGs = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)localObject3).yjd;
                  localObject1 = localObject2;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void a(i.a parama)
  {
    AppMethodBeat.i(200467);
    try
    {
      if ((parama.yuG != null) && (this.yGK != null))
      {
        parama = FloatWebViewHelper.a(parama.yuG, (ViewGroup)this.yGK);
        getLifecycle().addObserver(parama);
      }
      AppMethodBeat.o(200467);
      return;
    }
    catch (Throwable parama)
    {
      AppMethodBeat.o(200467);
    }
  }
  
  private void aQg()
  {
    AppMethodBeat.i(98378);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.yGE.getAdapter();
    if (localb == null)
    {
      localb = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b(getSupportFragmentManager(), new ArrayList());
      this.yGE.setAdapter(localb);
    }
    for (;;)
    {
      List localList = dOO();
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g localg;
      ContentFragment localContentFragment;
      if (localList.size() > 0)
      {
        localg = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localList.get(0);
        ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "loadFirstPage load id %s", new Object[] { Integer.valueOf(localg.id) });
        localContentFragment = (ContentFragment)this.yHl.get(Integer.valueOf(localg.id));
        if (localContentFragment != null) {
          break label362;
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("pageInfo", localg);
        localHashMap.put("pageCount", Integer.valueOf(localList.size()));
        localHashMap.put("viewPager", this.yGE);
        localHashMap.put("pageDownIconInfo", this.yrE);
        localHashMap.put("is_first_show_page", Boolean.TRUE);
        if (localList.size() == 1) {
          localHashMap.put("is_last_shown_page", Boolean.TRUE);
        }
        localHashMap.put("needEnterAnimation", Boolean.valueOf(this.yGk));
        localHashMap.put("needDirectionAnimation", Boolean.valueOf(dOR()));
        localHashMap.put("groupListCompShowIndex", Integer.valueOf(this.yGy));
        localContentFragment = new ContentFragment();
        localContentFragment.vUl = localHashMap;
        localContentFragment.yrN = this.yHe;
        this.yHl.put(Integer.valueOf(localg.id), localContentFragment);
      }
      for (;;)
      {
        if (localContentFragment != null) {
          localb.c(localContentFragment, 0);
        }
        localb.notifyDataSetChanged();
        this.yGE.setOffscreenPageLimit(localList.size());
        AppMethodBeat.o(98378);
        return;
        label362:
        localContentFragment.a(localg);
      }
    }
  }
  
  private String avG(String paramString)
  {
    AppMethodBeat.i(98389);
    String str = bs.bG((String)this.values.get("." + this.yGn + ".adCanvasInfo.shareThumbUrl"), "");
    if (!bs.isNullOrNil(str))
    {
      AppMethodBeat.o(98389);
      return str;
    }
    AppMethodBeat.o(98389);
    return paramString;
  }
  
  private void dOH()
  {
    AppMethodBeat.i(98364);
    AdlandingRemoteServiceConnectedReceiver.a(android.support.v4.content.d.U(this));
    WJ();
    if (this.yGk) {
      aQg();
    }
    for (;;)
    {
      refreshView();
      dOJ();
      dOK();
      ri(true);
      this.aKG = true;
      if ((Pt(this.dbL)) && (!TextUtils.isEmpty(this.dtx)))
      {
        ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "doUpdateUxInfoScene, uxInfo=" + this.dtx);
        AdLandingPagesProxy.getInstance().doUpdateUxInfoScene(this.dtx, new SnsAdNativeLandingPagesUI.26(this));
      }
      AppMethodBeat.o(98364);
      return;
      dOP();
    }
  }
  
  private void dOI()
  {
    AppMethodBeat.i(98367);
    Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.yGE.getAdapter();
    if (localObject == null)
    {
      AppMethodBeat.o(98367);
      return;
    }
    localObject = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)localObject).fragments.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ContentFragment localContentFragment = (ContentFragment)((Iterator)localObject).next();
      if ((localContentFragment.yrC != null) && (localContentFragment.getUserVisibleHint())) {
        localContentFragment.yrC.dLj();
      }
    }
    if (this.yGS != null) {
      this.yGS.dJZ();
    }
    AppMethodBeat.o(98367);
  }
  
  private void dOJ()
  {
    AppMethodBeat.i(98369);
    com.tencent.mm.plugin.report.service.h localh;
    String str2;
    if (this.yfP != 2)
    {
      localh = com.tencent.mm.plugin.report.service.h.wUl;
      str2 = com.tencent.mm.plugin.sns.data.q.wW(com.tencent.mm.plugin.sns.data.q.atd(this.yGv.dnn));
      if (this.dtx != null) {
        break label127;
      }
    }
    label127:
    for (String str1 = "";; str1 = this.dtx)
    {
      localh.f(14655, new Object[] { str2, str1, Integer.valueOf(this.yGv.fRQ), Integer.valueOf(this.yGv.plW), Long.valueOf(this.enterTime), Integer.valueOf(this.yjY), this.yGv.jYR });
      AppMethodBeat.o(98369);
      return;
    }
  }
  
  private void dOK()
  {
    AppMethodBeat.i(179185);
    try
    {
      if (!bs.T(new String[] { this.dyy, this.ykc }))
      {
        if (!this.yGW) {
          dOL();
        }
        if ((!this.yGX) && (this.yGZ != null))
        {
          ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "execute mValidExposureRunnable onCreate");
          this.yGZ.removeCallbacks(this.yHj);
          this.yGZ.postDelayed(this.yHj, 1000L);
        }
      }
      AppMethodBeat.o(179185);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.e("MicroMsg.SnsAdNativeLandingPagesUI", localThrowable.toString());
      AppMethodBeat.o(179185);
    }
  }
  
  private void dOL()
  {
    AppMethodBeat.i(179186);
    ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "reportOriginalExposure viewId = " + this.dyy + ", commInfo = " + this.ykc + ", uxInfo = " + this.dtx + ", exposureType = 0");
    this.yGW = true;
    g(this.dyy, this.ykc, this.dtx, 0);
    AppMethodBeat.o(179186);
  }
  
  private void dOM()
  {
    AppMethodBeat.i(179187);
    ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "reportValidExposure viewId = " + this.dyy + ", commInfo = " + this.ykc + ", uxInfo = " + this.dtx + ", exposureType = 1");
    this.yGX = true;
    g(this.dyy, this.ykc, this.dtx, 1);
    AppMethodBeat.o(179187);
  }
  
  private boolean dON()
  {
    AppMethodBeat.i(98370);
    int j = this.yGI.getChildCount();
    int i = 0;
    while (i < j)
    {
      if ((this.yGI.getChildAt(i) instanceof SnsAdLandingPageFloatView))
      {
        AppMethodBeat.o(98370);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(98370);
    return false;
  }
  
  private List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g> dOO()
  {
    AppMethodBeat.i(98376);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.yuE.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g localg = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localIterator.next();
      if (localg.yuy) {
        localArrayList.add(localg);
      }
    }
    fK(localArrayList);
    AppMethodBeat.o(98376);
    return localArrayList;
  }
  
  private void dOP()
  {
    AppMethodBeat.i(98379);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.yGE.getAdapter();
    if (localb == null)
    {
      localb = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b(getSupportFragmentManager(), new ArrayList());
      this.yGE.setAdapter(localb);
    }
    for (;;)
    {
      List localList = dOO();
      int i = 0;
      if (i < localList.size())
      {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g localg = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.yuE.get(i);
        ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "loadLandingPages load id %s", new Object[] { Integer.valueOf(localg.id) });
        ContentFragment localContentFragment = (ContentFragment)this.yHl.get(Integer.valueOf(localg.id));
        boolean bool;
        label214:
        label244:
        int j;
        if (localContentFragment == null)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("pageInfo", localg);
          localHashMap.put("pageCount", Integer.valueOf(localList.size()));
          localHashMap.put("viewPager", this.yGE);
          localHashMap.put("pageDownIconInfo", this.yrE);
          if (i == 0)
          {
            bool = true;
            localHashMap.put("is_first_show_page", Boolean.valueOf(bool));
            if (i != localList.size() - 1) {
              break label393;
            }
            bool = true;
            localHashMap.put("is_last_shown_page", Boolean.valueOf(bool));
            localHashMap.put("needEnterAnimation", Boolean.valueOf(this.yGk));
            localHashMap.put("needDirectionAnimation", Boolean.valueOf(dOR()));
            if (i != 0) {
              break label398;
            }
            j = this.yGy;
            label304:
            localHashMap.put("groupListCompShowIndex", Integer.valueOf(j));
            localContentFragment = new ContentFragment();
            localContentFragment.vUl = localHashMap;
            if (i == 0) {
              localContentFragment.yrN = this.yHe;
            }
            this.yHl.put(Integer.valueOf(localg.id), localContentFragment);
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
      this.yGE.setOffscreenPageLimit(localList.size());
      AppMethodBeat.o(98379);
      return;
    }
  }
  
  private boolean dOQ()
  {
    AppMethodBeat.i(98382);
    if (this.yGF != 0)
    {
      if (((this.yGF & 0x4) == 0) || ((this.yGF & 0x2) == 0) || ((dOU()) && (this.bizId == 2)) || ((this.yGF & 0x1) == 0))
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
  
  private boolean dOR()
  {
    return (this.yGF & 0x8) == 0;
  }
  
  private boolean dOS()
  {
    return this.yGG == 0;
  }
  
  private boolean dOT()
  {
    AppMethodBeat.i(98383);
    if ((!bs.isNullOrNil(this.yGo)) && (!bs.isNullOrNil(this.yGp)))
    {
      AppMethodBeat.o(98383);
      return true;
    }
    AppMethodBeat.o(98383);
    return false;
  }
  
  private boolean dOU()
  {
    return (this.yGF & 0x10) == 0;
  }
  
  private af dOV()
  {
    AppMethodBeat.i(98385);
    Object localObject = dOW().dLn().iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k localk = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k)((Iterator)localObject).next();
      if ((localk instanceof af))
      {
        localObject = (af)localk;
        AppMethodBeat.o(98385);
        return localObject;
      }
    }
    AppMethodBeat.o(98385);
    return null;
  }
  
  private ContentFragment dOW()
  {
    AppMethodBeat.i(98387);
    ContentFragment localContentFragment = null;
    if (this.yuE.size() > 0) {
      localContentFragment = (ContentFragment)this.yHl.get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.yuE.get(this.yGE.getCurrentItem())).id));
    }
    AppMethodBeat.o(98387);
    return localContentFragment;
  }
  
  private a dOX()
  {
    AppMethodBeat.i(98388);
    Object localObject = new com.tencent.mm.plugin.sns.storage.b(this.yGm);
    if (((com.tencent.mm.plugin.sns.storage.b)localObject).dJP())
    {
      int i = AdLandingPagesProxy.getInstance().getAdVoteIndex(((com.tencent.mm.plugin.sns.storage.b)localObject).ygC.yht, this.dtx, this.uin);
      if ((i > 0) && (i <= ((com.tencent.mm.plugin.sns.storage.b)localObject).ygC.yhv.size()))
      {
        localObject = (b.l)((com.tencent.mm.plugin.sns.storage.b)localObject).ygC.yhv.get(i - 1);
        a locala = new a((byte)0);
        if (!bs.isNullOrNil(((b.l)localObject).pBm))
        {
          locala.pBm = ((b.l)localObject).pBm;
          if (bs.isNullOrNil(((b.l)localObject).tcG)) {
            break label165;
          }
          locala.tcG = ((b.l)localObject).tcG;
          label128:
          if (bs.isNullOrNil(((b.l)localObject).yhw)) {
            break label176;
          }
        }
        label165:
        label176:
        for (locala.yhw = ((b.l)localObject).yhw;; locala.yhw = this.yGs)
        {
          AppMethodBeat.o(98388);
          return locala;
          locala.pBm = this.pBm;
          break;
          locala.tcG = this.tcG;
          break label128;
        }
      }
    }
    AppMethodBeat.o(98388);
    return null;
  }
  
  private String dOY()
  {
    AppMethodBeat.i(98390);
    Object localObject = new dcu();
    ((dcu)localObject).FMs = new dcv();
    ((dcu)localObject).FMs.DHe = this.yGv.dtx;
    ((dcu)localObject).FMs.FMv = this.yGv.dnn;
    ((dcu)localObject).FMs.yft = this.yft;
    try
    {
      localObject = Base64.encodeToString(((dcu)localObject).toByteArray(), 2);
      AppMethodBeat.o(98390);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(98390);
    }
    return "";
  }
  
  private String dOZ()
  {
    AppMethodBeat.i(98391);
    String str2 = this.yGm.replaceAll("(?s)<adCanvasInfoLeft[^>]*>.*?</adCanvasInfoLeft>", "").replaceAll("(?s)<adCanvasInfoRight[^>]*>.*?</adCanvasInfoRight>", "");
    String str1 = str2;
    if (str2.contains("<shareAdCanvasInfo>")) {
      str1 = str2.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replace("shareAdCanvasInfo", "adCanvasInfo");
    }
    AppMethodBeat.o(98391);
    return str1;
  }
  
  private void dPc()
  {
    AppMethodBeat.i(98398);
    if ((this.yGg != null) && (this.yGI != null) && (this.yGS == null))
    {
      this.yGS = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d(this, this.yGg, this.yGI);
      j(false, 0L);
    }
    AppMethodBeat.o(98398);
  }
  
  private boolean dPe()
  {
    AppMethodBeat.i(98404);
    if (this.yGg != null)
    {
      if (this.yGg.yjL == 1)
      {
        boolean bool = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s.OH(this.dbL);
        AppMethodBeat.o(98404);
        return bool;
      }
      AppMethodBeat.o(98404);
      return true;
    }
    AppMethodBeat.o(98404);
    return false;
  }
  
  private static void fK(List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g> paramList)
  {
    AppMethodBeat.i(98377);
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList();
      int i = 0;
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        Iterator localIterator = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)paramList.next()).yuw.iterator();
        int j = i;
        for (;;)
        {
          i = j;
          if (!localIterator.hasNext()) {
            break;
          }
          x localx = (x)localIterator.next();
          if ((localx instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b))
          {
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localx).yii = j;
            j += 1;
          }
          else if ((localx instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k))
          {
            localArrayList.add((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k)localx);
          }
        }
      }
      if (localArrayList.isEmpty()) {
        break label170;
      }
    }
    catch (Exception paramList)
    {
      ac.e("MicroMsg.SnsAdNativeLandingPagesUI", "giveIdxForApkBtnInfo, exp=" + paramList.toString());
      AppMethodBeat.o(98377);
      return;
    }
    com.tencent.mm.plugin.sns.data.q.fu(localArrayList);
    label170:
    AppMethodBeat.o(98377);
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
      j.iU("rewarded_canvas_exposure", localJSONObject.toString());
      AppMethodBeat.o(179188);
      return;
    }
    catch (Exception paramString1)
    {
      ac.e("MicroMsg.SnsAdNativeLandingPagesUI", "doCanvasExposureReport exp=" + paramString1.toString());
      AppMethodBeat.o(179188);
    }
  }
  
  private List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k> getAllComp()
  {
    AppMethodBeat.i(98380);
    this.yGM = new ArrayList();
    Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.yGE.getAdapter();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)localObject).fragments.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Fragment localFragment = (Fragment)((Iterator)localObject).next();
        this.yGM.addAll(((ContentFragment)localFragment).dLn());
      }
    }
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.fD(this.yGM);
    localObject = this.yGM;
    AppMethodBeat.o(98380);
    return localObject;
  }
  
  private void r(ContentFragment paramContentFragment)
  {
    AppMethodBeat.i(98399);
    if (!dPd()) {
      paramContentFragment.dLs();
    }
    AppMethodBeat.o(98399);
  }
  
  private void refreshView()
  {
    AppMethodBeat.i(98365);
    Object localObject;
    if ((this.bizId == 2) && (!dOS()))
    {
      localObject = (FrameLayout.LayoutParams)this.yGE.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).setMargins(0, 0, 0, com.tencent.mm.ui.ap.ej(this));
      this.yGE.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int i = 2131100892;
    if (!dOS())
    {
      i = getResources().getColor(2131100891);
      if ((this.yuE == null) || (this.yuE.size() <= 0) || (bs.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.yuE.getFirst()).jBX))) {
        break label313;
      }
      i = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.yuE.getFirst()).jBX);
    }
    label313:
    for (;;)
    {
      this.yGJ.setBackgroundColor(i);
      i = 2131100891;
      localObject = this.gDM.getDrawable();
      if (localObject != null)
      {
        android.support.v4.graphics.drawable.a.a((Drawable)localObject, android.support.v4.content.b.n(this, i));
        this.gDM.setImageDrawable((Drawable)localObject);
      }
      localObject = this.wss.getDrawable();
      if (localObject != null)
      {
        android.support.v4.graphics.drawable.a.a((Drawable)localObject, android.support.v4.content.b.n(this, i));
        this.wss.setImageDrawable((Drawable)localObject);
      }
      if ((dOT()) && (!dOU()) && (this.bizId == 2))
      {
        this.wss.setVisibility(8);
        this.yGi.setVisibility(0);
        this.yGi.setText(this.yGo);
        this.yGi.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(98327);
            SnsAdNativeLandingPagesUI.this.C(SnsAdNativeLandingPagesUI.this, SnsAdNativeLandingPagesUI.y(SnsAdNativeLandingPagesUI.this), SnsAdNativeLandingPagesUI.z(SnsAdNativeLandingPagesUI.this));
            AppMethodBeat.o(98327);
          }
        });
        AppMethodBeat.o(98365);
        return;
      }
      if (dOQ())
      {
        this.wss.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(200442);
            paramAnonymousView = new e(SnsAdNativeLandingPagesUI.this, 1, false);
            paramAnonymousView.ISu = new n.c()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
              {
                AppMethodBeat.i(200440);
                if ((SnsAdNativeLandingPagesUI.A(SnsAdNativeLandingPagesUI.this) == 0) || ((SnsAdNativeLandingPagesUI.A(SnsAdNativeLandingPagesUI.this) & 0x2) == 0)) {
                  paramAnonymous2l.a(1, SnsAdNativeLandingPagesUI.this.getString(2131762566), 2131689831);
                }
                if ((SnsAdNativeLandingPagesUI.A(SnsAdNativeLandingPagesUI.this) == 0) || ((SnsAdNativeLandingPagesUI.A(SnsAdNativeLandingPagesUI.this) & 0x1) == 0)) {
                  paramAnonymous2l.a(2, SnsAdNativeLandingPagesUI.this.getString(2131763771), 2131689817);
                }
                if (((SnsAdNativeLandingPagesUI.A(SnsAdNativeLandingPagesUI.this) == 0) || ((SnsAdNativeLandingPagesUI.A(SnsAdNativeLandingPagesUI.this) & 0x4) == 0)) && (SnsAdNativeLandingPagesUI.u(SnsAdNativeLandingPagesUI.this) != 7)) {
                  paramAnonymous2l.a(3, SnsAdNativeLandingPagesUI.this.getString(2131757157), 2131689808);
                }
                if (((SnsAdNativeLandingPagesUI.A(SnsAdNativeLandingPagesUI.this) == 0) || (SnsAdNativeLandingPagesUI.B(SnsAdNativeLandingPagesUI.this))) && (SnsAdNativeLandingPagesUI.t(SnsAdNativeLandingPagesUI.this) == 2) && (SnsAdNativeLandingPagesUI.C(SnsAdNativeLandingPagesUI.this))) {
                  if (SnsAdNativeLandingPagesUI.D(SnsAdNativeLandingPagesUI.this) == null) {
                    break label255;
                  }
                }
                label255:
                for (String str = SnsAdNativeLandingPagesUI.D(SnsAdNativeLandingPagesUI.this);; str = "")
                {
                  paramAnonymous2l.a(4, str, 0);
                  AppMethodBeat.o(200440);
                  return;
                }
              }
            };
            paramAnonymousView.lcH = true;
            paramAnonymousView.ISv = new n.d()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(200441);
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al.aF(SnsAdNativeLandingPagesUI.this);
                if (paramAnonymous2MenuItem != null) {
                  switch (paramAnonymous2MenuItem.getItemId())
                  {
                  }
                }
                for (;;)
                {
                  AppMethodBeat.o(200441);
                  return;
                  SnsAdNativeLandingPagesUI.E(SnsAdNativeLandingPagesUI.this);
                  AppMethodBeat.o(200441);
                  return;
                  SnsAdNativeLandingPagesUI.F(SnsAdNativeLandingPagesUI.this);
                  AppMethodBeat.o(200441);
                  return;
                  SnsAdNativeLandingPagesUI.G(SnsAdNativeLandingPagesUI.this);
                  AppMethodBeat.o(200441);
                  return;
                  SnsAdNativeLandingPagesUI.this.C(SnsAdNativeLandingPagesUI.this, SnsAdNativeLandingPagesUI.y(SnsAdNativeLandingPagesUI.this), SnsAdNativeLandingPagesUI.z(SnsAdNativeLandingPagesUI.this));
                }
              }
            };
            SnsAdNativeLandingPagesUI.this.hideVKB();
            paramAnonymousView.cED();
            AppMethodBeat.o(200442);
          }
        });
        AppMethodBeat.o(98365);
        return;
      }
      this.wss.setVisibility(8);
      AppMethodBeat.o(98365);
      return;
    }
  }
  
  private void report()
  {
    AppMethodBeat.i(98368);
    Object localObject2 = getAllComp();
    Object localObject1 = this.yGR.values().iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((List)localObject2).addAll(((SnsAdLandingPageFloatView)((Iterator)localObject1).next()).getAllComp());
    }
    if (this.yGS != null)
    {
      ((List)localObject2).add(this.yGS);
      localObject1 = this.yGS.dKo();
      if (localObject1 != null)
      {
        this.yGS.dKn();
        ((List)localObject2).add(localObject1);
      }
    }
    this.dpQ += System.currentTimeMillis() - this.startTime;
    this.yGv.yuZ = ((int)this.dpQ);
    this.yGv.yuY = ((List)localObject2).size();
    localObject1 = this.yGv;
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k localk = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k)((Iterator)localObject2).next();
      if (!localk.dKA().yjB)
      {
        JSONObject localJSONObject = new JSONObject();
        if ((!localk.C(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject1).yvc)) && (localk.aH(localJSONObject))) {
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject1).yvc.put(localJSONObject);
        }
      }
    }
    ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "landingPage report json %s", new Object[] { this.yGv.yvc });
    localObject1 = this.yGv.dLP();
    if (this.bizId == 2)
    {
      AdLandingPagesProxy.getInstance().doCgiReportCanvasBrowseInfo(15041, (String)localObject1);
      ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "post cgi stat 15041 data: ".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(98368);
      return;
    }
    if (AdLandingPagesProxy.getInstance().isRecExpAd(this.yGv.dnn))
    {
      com.tencent.mm.plugin.report.service.h.wUl.kvStat(14650, (String)localObject1);
      ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 14650 data: ".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(98368);
      return;
    }
    com.tencent.mm.plugin.report.service.h.wUl.kvStat(13387, (String)localObject1);
    ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 13387 data: ".concat(String.valueOf(localObject1)));
    AppMethodBeat.o(98368);
  }
  
  private void w(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(98375);
    String str = (String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.iconUrl");
    if (TextUtils.isEmpty(str))
    {
      this.yrE = null;
      AppMethodBeat.o(98375);
      return;
    }
    if (this.yrE == null) {
      this.yrE = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al();
    }
    this.yrE.iconUrl = str;
    int k = bs.aLy((String)paramMap.get(paramString + ".adCanvasInfo.sizeType"));
    int i = bs.aLy((String)paramMap.get(paramString + ".adCanvasInfo.basicRootFontSize"));
    int j = bs.aLy((String)paramMap.get(paramString + ".adCanvasInfo.basicWidth"));
    if ((i == 0) && (k == 1)) {
      i = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.yuC;
    }
    for (;;)
    {
      if ((j == 0) && (k == 1)) {
        j = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.yuB;
      }
      for (;;)
      {
        this.yrE.paddingBottom = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(bs.aLA((String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.paddingBottom")), k, j, i);
        this.yrE.width = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(bs.aLA((String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.layoutWidth")), k, j, i);
        this.yrE.height = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(bs.aLA((String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.layoutHeight")), k, j, i);
        AppMethodBeat.o(98375);
        return;
      }
    }
  }
  
  private void xO(long paramLong)
  {
    AppMethodBeat.i(98401);
    if (this.yGS != null)
    {
      ac.d("MicroMsg.SnsAdNativeLandingPagesUI", "showFloatBarView");
      this.yGS.xx(paramLong);
      ContentFragment localContentFragment = dOW();
      if (localContentFragment != null) {
        localContentFragment.dLt();
      }
    }
    AppMethodBeat.o(98401);
  }
  
  public final void C(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(98396);
    Intent localIntent = new Intent();
    localIntent.putExtra("sns_landig_pages_from_source", 14);
    int i;
    String str2;
    String str1;
    JSONObject localJSONObject;
    if (this.yjY == 0)
    {
      i = this.dbL;
      localIntent.putExtra("sns_landig_pages_origin_from_source", i);
      localIntent.putExtra("sns_landing_pages_canvasid", paramString1);
      localIntent.putExtra("sns_landing_pages_canvas_ext", paramString2);
      localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
      localIntent.putExtra("sns_landing_pages_no_store", 1);
      str2 = ((Activity)paramContext).getIntent().getStringExtra("sns_landing_pages_sessionId");
      paramString2 = ((Activity)paramContext).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
      if (!bs.isNullOrNil(str2))
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
        if (bs.isNullOrNil(paramString2)) {
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
      i = this.yjY;
      break;
      paramString1 = "";
    }
  }
  
  public final void a(final x paramx, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, final boolean paramBoolean3)
  {
    AppMethodBeat.i(98395);
    if ((this.yHo != null) && (!paramBoolean3))
    {
      ac.w("MicroMsg.SnsAdNativeLandingPagesUI", "bottom sheet appear several times");
      this.yHo.bmi();
      if (this.yHp != null)
      {
        this.yHp.dismiss();
        this.yHp = null;
      }
      AppMethodBeat.o(98395);
      return;
    }
    AdLandingPagesProxy.e local18 = new AdLandingPagesProxy.e()
    {
      public final void bc(Object paramAnonymousObject) {}
      
      public final void h(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(200458);
        SnsAdNativeLandingPagesUI.this.ri(false);
        if (paramBoolean3)
        {
          if (SnsAdNativeLandingPagesUI.S(SnsAdNativeLandingPagesUI.this) != null) {
            SnsAdNativeLandingPagesUI.S(SnsAdNativeLandingPagesUI.this).bmi();
          }
          if (SnsAdNativeLandingPagesUI.T(SnsAdNativeLandingPagesUI.this) != null)
          {
            SnsAdNativeLandingPagesUI.T(SnsAdNativeLandingPagesUI.this).dismiss();
            SnsAdNativeLandingPagesUI.U(SnsAdNativeLandingPagesUI.this);
          }
        }
        AppMethodBeat.o(200458);
      }
    };
    AppCompatActivity localAppCompatActivity;
    LinearLayout localLinearLayout;
    if (!paramBoolean3)
    {
      localAppCompatActivity = getContext();
      localLinearLayout = new LinearLayout(getContext());
      if (bs.isNullOrNil(paramx.yjx)) {
        break label223;
      }
    }
    label223:
    for (int i = Color.parseColor(paramx.yjx);; i = -1)
    {
      paramx = as.a(localAppCompatActivity, paramx, localLinearLayout, i);
      this.yHo = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l(getContext(), paramx, paramString1, paramString2, paramString3, paramBoolean1, paramBoolean2);
      paramx = paramx.getView();
      this.yHo.yna = new l.a()
      {
        private void onRemove()
        {
          AppMethodBeat.i(200461);
          if ((paramx != null) && (paramx.getParent() != null)) {
            ((ViewGroup)paramx.getParent()).removeView(paramx);
          }
          SnsAdNativeLandingPagesUI.V(SnsAdNativeLandingPagesUI.this);
          AppMethodBeat.o(200461);
        }
        
        public final void dKI()
        {
          AppMethodBeat.i(200459);
          ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "onDismiss");
          onRemove();
          AppMethodBeat.o(200459);
        }
        
        public final void dKJ()
        {
          AppMethodBeat.i(200460);
          ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "onCancel");
          onRemove();
          AppMethodBeat.o(200460);
        }
      };
      this.yHo.cED();
      if (!bs.isNullOrNil(paramString1))
      {
        AdLandingPagesProxy.getInstance().doFavOfficialItemScene(paramString1, local18);
        if (paramBoolean3) {
          this.yHp = com.tencent.mm.ui.base.h.b(this, getString(2131763886), false, null);
        }
      }
      AppMethodBeat.o(98395);
      return;
    }
  }
  
  public final void bSg()
  {
    AppMethodBeat.i(98384);
    Object localObject;
    try
    {
      Iterator localIterator1 = this.yGR.values().iterator();
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
      ac.printErrStackTrace("MicroMsg.SnsAdNativeLandingPagesUI", localException, "play exit animation error", new Object[0]);
      finish();
      AppMethodBeat.o(98384);
      return;
    }
    dOI();
    report();
    this.yGx = true;
    this.yGJ.setVisibility(8);
    if (!this.yGk)
    {
      finish();
      AppMethodBeat.o(98384);
      return;
    }
    if (this.rwO)
    {
      ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "is playing animation");
      AppMethodBeat.o(98384);
      return;
    }
    ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "run exit animation, %s", new Object[] { Boolean.valueOf(this.yGk) });
    this.rwO = true;
    if (isSupportNavigationSwipeBack()) {
      getSwipeBackLayout().setEnableGesture(false);
    }
    Iterator localIterator2 = dOW().dLn().iterator();
    while (localIterator2.hasNext())
    {
      localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k)localIterator2.next();
      if ((localObject instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a))
      {
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject).dJV();
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k)localObject).dKF();
      }
    }
    com.tencent.mm.sdk.platformtools.ap.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98342);
        SnsAdNativeLandingPagesUI.Q(SnsAdNativeLandingPagesUI.this);
        AppMethodBeat.o(98342);
      }
    }, 30L);
    AppMethodBeat.o(98384);
  }
  
  public boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  public final ae dKH()
  {
    AppMethodBeat.i(200465);
    if (this.yGQ == null) {
      this.yGQ = new ae();
    }
    Object localObject1 = this.yGQ;
    int i;
    if (this.yjY == 0) {
      i = this.dbL;
    }
    for (;;)
    {
      ((ae)localObject1).yjY = i;
      this.yGQ.dbL = this.dbL;
      this.yGQ.yjZ = this.yGu;
      this.yGQ.dtx = this.dtx;
      this.yGQ.yka = this.yka;
      this.yGQ.uin = this.uin;
      this.yGQ.bizId = this.bizId;
      this.yGQ.yeO = this.yeO;
      this.yGQ.jyU = this.jyU;
      localObject1 = this.yGQ;
      Object localObject2 = this.ykd;
      ((ae)localObject1).ykd.putAll((Map)localObject2);
      localObject2 = this.yGQ;
      label182:
      boolean bool;
      if (this.yGv != null)
      {
        localObject1 = this.yGv.jYR;
        ((ae)localObject2).jYR = ((String)localObject1);
        localObject1 = this.yGQ;
        if (this.yGg == null) {
          break label393;
        }
        bool = true;
        label204:
        ((ae)localObject1).ykb = bool;
      }
      try
      {
        localObject2 = this.yGQ;
        if (bs.isNullOrNil(this.dnn)) {
          if (this.yGv != null)
          {
            localObject1 = String.valueOf(j.asL(this.yGv.dnn));
            ((ae)localObject2).dnn = ((String)localObject1);
            if (!bs.T(new String[] { this.dyy, this.ykc }))
            {
              this.yGQ.dyy = this.dyy;
              this.yGQ.ykc = this.ykc;
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
            localObject1 = (String)((Map)localObject1).get("." + this.yGn + ".adExtInfo");
            this.yGQ.xOm = com.tencent.mm.plugin.sns.data.h.asK((String)localObject1);
            localObject1 = this.yGQ;
            AppMethodBeat.o(200465);
            return localObject1;
            i = this.yjY;
            break;
            localObject1 = "";
            break label182;
            label393:
            bool = false;
            break label204;
            localObject1 = "";
            continue;
            long l = j.asL(this.dnn);
            localObject1 = String.valueOf(l);
          }
          localThrowable1 = localThrowable1;
          ac.e("MicroMsg.SnsAdNativeLandingPagesUI", localThrowable1.toString());
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            ac.e("MicroMsg.SnsAdNativeLandingPagesUI", "there is something wrong in set ad ext info");
          }
        }
      }
    }
  }
  
  public final void dPa()
  {
    AppMethodBeat.i(200466);
    try
    {
      boolean bool = dPb();
      ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "jumpNextPage, hasNextPage=".concat(String.valueOf(bool)));
      if (bool) {
        this.yGE.setCurrentItem$2563266(this.yGE.getCurrentItem() + 1);
      }
      AppMethodBeat.o(200466);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.SnsAdNativeLandingPagesUI", "jumpNextPage exp:" + localException.toString());
      AppMethodBeat.o(200466);
    }
  }
  
  public final boolean dPb()
  {
    AppMethodBeat.i(98397);
    try
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.yGE.getAdapter();
      int i = this.yGE.getCurrentItem();
      ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "hasNextPage, curPage=" + i + ", pageCount=" + localb.getCount());
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
      ac.e("MicroMsg.SnsAdNativeLandingPagesUI", "hasNextPage exp:" + localException.toString());
      AppMethodBeat.o(98397);
    }
    return true;
  }
  
  public final boolean dPd()
  {
    AppMethodBeat.i(98400);
    if (this.yGS != null)
    {
      boolean bool = this.yGS.isShowing();
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
    this.yGI = ((FrameLayout)findViewById(2131304239));
    this.yGK = findViewById(2131298752);
    this.yGE = ((AdlandingDummyViewPager)findViewById(2131306298));
    this.yGJ = findViewById(2131302239);
    ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "before, assistActivity");
    if (aj.aG(getContext()))
    {
      int i = aj.aF(this);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.yGI.getLayoutParams();
      localLayoutParams.height = (this.kWC - i);
      localLayoutParams.topMargin = i;
      this.yGI.setLayoutParams(localLayoutParams);
      getController().setActionbarColor(getResources().getColor(2131099873));
      this.yGI.addOnLayoutChangeListener(new SnsAdNativeLandingPagesUI.6(this, i));
      com.tencent.mm.sdk.platformtools.ap.n(new SnsAdNativeLandingPagesUI.7(this), 1500L);
    }
    for (;;)
    {
      this.iBF = ((ImageView)findViewById(2131300336));
      this.yGh = ((ImageView)findViewById(2131296672));
      this.gDM = ((ImageView)findViewById(2131304901));
      this.gDM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(200445);
          if (SnsAdNativeLandingPagesUI.this.keyboardState() == 1) {
            SnsAdNativeLandingPagesUI.this.hideVKB();
          }
          SnsAdNativeLandingPagesUI.this.bSg();
          AppMethodBeat.o(200445);
        }
      });
      this.wss = ((ImageView)findViewById(2131304918));
      this.yGi = ((TextView)findViewById(2131304919));
      this.yGr = ((ImageView)findViewById(2131305019));
      if (this.yGk)
      {
        this.yGI.setAlpha(0.0F);
        this.iBF.setAlpha(0.0F);
        com.tencent.mm.ui.base.b.a(this, null);
      }
      AppMethodBeat.o(98381);
      return;
      com.tencent.mm.sdk.platformtools.ap.n(new SnsAdNativeLandingPagesUI.8(this), 1500L);
    }
  }
  
  public final void j(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(98402);
    if (this.yGS != null)
    {
      ac.d("MicroMsg.SnsAdNativeLandingPagesUI", "hideFloatBarView");
      this.yGS.i(paramBoolean, paramLong);
    }
    AppMethodBeat.o(98402);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(98392);
    String str;
    Object localObject3;
    if (paramInt1 == 1) {
      if (paramInt2 == -1)
      {
        ac.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "share to timeLine success");
        str = bs.nullAsNil(this.dtx);
        localObject3 = bs.nullAsNil(this.yGv.jYR);
      }
    }
    for (;;)
    {
      try
      {
        str = com.tencent.mm.plugin.sns.a.b.v("3", "", str, (String)localObject3);
        ac.i("AntiCheatingReportUtils", "reportScreenShotParams = ".concat(String.valueOf(str)));
        com.tencent.mm.plugin.report.service.h.wUl.kvStat(19214, str);
        com.tencent.mm.ui.base.h.cg(getContext(), getContext().getString(2131755894));
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        AppMethodBeat.o(98392);
        return;
      }
      catch (Throwable localThrowable1)
      {
        ac.e("AntiCheatingReportUtils", localThrowable1.toString());
        continue;
      }
      int i;
      if (paramInt1 == 2)
      {
        if (paramIntent.getBooleanExtra("kfavorite", false))
        {
          i = AdLandingPagesProxy.getInstance().doFav(paramIntent, 42);
          ((com.tencent.mm.plugin.fav.a.v)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fav.a.v.class)).a(i, this, this.sXH);
        }
      }
      else
      {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k localk;
        int j;
        int k;
        if (paramInt1 == ad.ypN)
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
              localk = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k)((Iterator)localObject3).next();
            } while (!localk.dKD().equals(localObject1));
            localObject1 = (ad)localk;
            i = paramIntent.getIntExtra("KStreamVideoPlayCount", 0);
            j = paramIntent.getIntExtra("KStreamVideoPlayCompleteCount", 0);
            k = paramIntent.getIntExtra("KStreamVideoTotalPlayTimeInMs", 0);
            ((ad)localObject1).xJT = (i + ((ad)localObject1).xJT);
            ((ad)localObject1).xJU += j;
            ((ad)localObject1).xJV += k;
          }
          catch (Exception localException) {}
        }
        else
        {
          Object localObject2;
          if (paramInt1 == 3)
          {
            localObject2 = new tk();
            ((tk)localObject2).dwq.CW = 1;
            ((tk)localObject2).dwq.requestCode = paramInt1;
            ((tk)localObject2).dwq.bPH = paramInt2;
            ((tk)localObject2).dwq.dlL = paramIntent;
            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
          }
          else if (paramInt1 == yHa)
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
              localObject3 = getAllComp().iterator();
              do
              {
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
                localk = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k)((Iterator)localObject3).next();
              } while (!localk.dKD().equals(localObject2));
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
              ac.i("NonFullOrFullVideoType", "videoType = " + i + ", cid = " + (String)localObject2 + ", currPosSec = " + j + ", bNoVoice = " + bool1 + ", isPlaying = " + bool2 + ", clickPlayControlCount = " + k + ", doubleClickCount = " + m + ", clickVoiceControlCount = " + n + ", playCompletedCount = " + i1 + ", playCount = " + i2 + ", playTimeInterval = " + l);
              if (i != 0) {
                break label762;
              }
              ((ad)localk).a(j, bool1, bool2, k, m, n, i1, i2, l);
            }
            catch (Throwable localThrowable2)
            {
              ac.e("NonFullOrFullVideoType", localThrowable2.toString());
            }
            continue;
            label762:
            if (i == 1) {
              ((ah)localk).a(j, bool1, bool2, k, m, n, i1, i2, l, bool3, i3);
            }
          }
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(98386);
    bSg();
    AppMethodBeat.o(98386);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98363);
    super.onCreate(paramBundle);
    this.startTime = System.currentTimeMillis();
    this.enterTime = System.currentTimeMillis();
    this.yGv.enterTime = this.enterTime;
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al.aF(this);
    Object localObject = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al.gg(this);
    this.kWB = localObject[0];
    this.kWC = localObject[1];
    this.yGj = paramBundle;
    this.mController.hideTitleView();
    this.ocW = getIntent().getIntExtra("img_gallery_top", 0);
    if (aj.aG(this))
    {
      int i = aj.aF(this);
      this.ocW -= i;
      ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "hasCutOut, h=" + i + ", thumbTop=" + this.ocW);
    }
    this.ocX = getIntent().getIntExtra("img_gallery_left", 0);
    this.ocY = getIntent().getIntExtra("img_gallery_width", 0);
    this.ocZ = getIntent().getIntExtra("img_gallery_height", 0);
    getWindow().addFlags(128);
    this.isVisible = false;
    this.yGW = false;
    this.yGX = false;
    this.yGY = false;
    if (this.yGZ != null) {
      this.yGZ.removeCallbacks(this.yHj);
    }
    this.dbL = getIntent().getIntExtra("sns_landig_pages_from_source", 0);
    this.yjY = getIntent().getIntExtra("sns_landig_pages_origin_from_source", 0);
    ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "source=" + this.dbL + ", originScene=" + this.yjY);
    this.yGm = getIntent().getStringExtra("sns_landing_pages_xml");
    paramBundle = getIntent().getStringExtra("sns_landing_pages_too_large_xml_path");
    if ((bs.isNullOrNil(this.yGm)) && (!bs.isNullOrNil(paramBundle))) {
      this.yGm = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al.auL(paramBundle);
    }
    if (bs.isNullOrNil(this.yGm))
    {
      finish();
      initView();
      if (AdLandingPagesProxy.getInstance().isConnected()) {
        break label1055;
      }
      ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "isConnected==false");
      AdLandingPagesProxy.getInstance().connect(new SnsAdNativeLandingPagesUI.25(this));
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.GpY.c(this.yHi);
      try
      {
        registerReceiver(this.yHn, new IntentFilter("android.intent.action.SCREEN_ON"));
        AppMethodBeat.o(98363);
        return;
      }
      catch (Exception paramBundle)
      {
        ac.e("MicroMsg.SnsAdNativeLandingPagesUI", "registerReceiver, exp=" + paramBundle.toString());
        AppMethodBeat.o(98363);
      }
      this.yGm = this.yGm.replaceAll("</*RecXml[\\s|\\S]*?>", "");
      this.yGv.xZE = getIntent().getStringExtra("sns_landing_pages_expid");
      this.yGn = getIntent().getStringExtra("sns_landing_pages_xml_prefix");
      this.dnn = getIntent().getStringExtra("sns_landing_pages_share_sns_id");
      this.yGt = getIntent().getStringExtra("sns_landing_pages_rawSnsId");
      this.dtx = getIntent().getStringExtra("sns_landing_pages_ux_info");
      this.yeO = getIntent().getStringExtra("sns_landing_pages_aid");
      this.jyU = getIntent().getStringExtra("sns_landing_pages_traceid");
      paramBundle = getIntent().getStringExtra("sns_landing_pages_search_extra");
      localObject = this.yGv;
      if (!TextUtils.isEmpty(paramBundle))
      {
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra.length() > 0) {
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra += "&";
        }
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra = (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra + "searchextra=" + URLEncoder.encode(paramBundle));
      }
      paramBundle = getIntent().getStringExtra("sns_landing_pages_extra");
      localObject = this.yGv;
      if (!TextUtils.isEmpty(paramBundle)) {
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra = (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra + "&extra1=" + URLEncoder.encode(paramBundle));
      }
      this.yGu = getIntent().getBooleanExtra("sns_landing_is_native_sight_ad", false);
      this.yfP = getIntent().getIntExtra("sns_landing_pages_rec_src", 0);
      this.yGy = getIntent().getIntExtra("sns_landing_pages_from_outer_index", 0);
      this.jYS = getIntent().getStringExtra("sns_landing_pages_ad_info");
      this.yGk = getIntent().getBooleanExtra("sns_landing_pages_need_enter_and_exit_animation", false);
      this.yGl = getIntent().getBooleanExtra("sns_landing_pages_is_normal_ad_animation", false);
      if (this.yGk) {
        this.yGv.fRQ = 0;
      }
      for (this.yGv.fnm = 0;; this.yGv.fnm = 1)
      {
        this.yGv.plW = this.dbL;
        this.yGv.yuU = 0;
        this.yGv.yuV = 0;
        this.yGv.yuW = 1;
        this.yGv.yuX = 0;
        this.yGv.yjY = this.yjY;
        if ((this.yGn == null) || ("".equals(this.yGm))) {
          this.yGn = "adxml";
        }
        if ((!bs.isNullOrNil(this.yGm)) && (!bs.isNullOrNil(this.yGn))) {
          break label986;
        }
        ac.e("MicroMsg.SnsAdNativeLandingPagesUI", "landingPagesXml is " + this.yGm + ",landingPagesXmlPrex is " + this.yGn);
        break;
        this.yGv.fRQ = 1;
      }
      label986:
      this.values = bv.L(this.yGm, this.yGn);
      this.yGv.jYR = bs.bG((String)this.values.get("." + this.yGn + ".adCanvasInfo.id"), "");
      break;
      label1055:
      ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "isConnected==true");
      dOH();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98366);
    getWindow().clearFlags(128);
    if (this.yGZ != null) {
      this.yGZ.removeCallbacks(this.yHj);
    }
    if (this.aKG)
    {
      ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "the SnsAdNativeLadingPagesUI is destroy, bHandleExit=" + this.yGx);
      if (!this.yGx)
      {
        dOI();
        report();
      }
    }
    for (;;)
    {
      this.yGR.clear();
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.yGE.getAdapter();
      if (localb != null) {
        localb.fragments.clear();
      }
      try
      {
        unregisterReceiver(this.yHn);
        com.tencent.mm.sdk.b.a.GpY.d(this.yHi);
        AdLandingPagesProxy.getInstance().clearCallback();
        super.onDestroy();
        AppMethodBeat.o(98366);
        return;
        ac.e("MicroMsg.SnsAdNativeLandingPagesUI", "onDestroy, isConnected=false");
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.e("MicroMsg.SnsAdNativeLandingPagesUI", "unregisterReceiver, exp=" + localException.toString());
        }
      }
    }
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(98393);
    super.onKeyboardStateChanged();
    ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "onKeyboardStateChanged, state=" + keyboardState());
    if (this.yGE != null) {
      this.yGE.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(200456);
          if (SnsAdNativeLandingPagesUI.this.keyboardState() != 1) {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al.aF(SnsAdNativeLandingPagesUI.this);
          }
          if (!SnsAdNativeLandingPagesUI.R(SnsAdNativeLandingPagesUI.this))
          {
            new ArrayList();
            Iterator localIterator = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getAdapter()).fragments.iterator();
            while (localIterator.hasNext())
            {
              ContentFragment localContentFragment = (ContentFragment)localIterator.next();
              SnsAdNativeLandingPagesUI.this.keyboardState();
              localContentFragment.dLo();
            }
          }
          AppMethodBeat.o(200456);
        }
      }, 500L);
    }
    AppMethodBeat.o(98393);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(98372);
    super.onPause();
    ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "onPause");
    this.yGP = true;
    if (this.aKG) {
      this.dpQ += System.currentTimeMillis() - this.startTime;
    }
    try
    {
      bg.a(this, null);
      this.yGw = false;
      if (dON())
      {
        Iterator localIterator = this.yGR.values().iterator();
        while (localIterator.hasNext()) {
          ((SnsAdLandingPageFloatView)localIterator.next()).onPause();
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ac.e("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", localThrowable.toString());
      }
      AdlandingDummyViewPager localAdlandingDummyViewPager = this.yGE;
      ViewPager.OnPageChangeListener localOnPageChangeListener = this.yHf;
      localAdlandingDummyViewPager.yrs.remove(localOnPageChangeListener);
      android.support.v4.content.d.U(this).unregisterReceiver(this.yHc);
      android.support.v4.content.d.U(this).unregisterReceiver(this.yHd);
      com.tencent.mm.sdk.b.a.GpY.d(this.yHh);
      if (this.yHo != null) {
        this.yHo.bmi();
      }
      if ((this.yGS != null) && (this.yGS.isShowing())) {
        this.yGS.dJZ();
      }
      AppMethodBeat.o(98372);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98371);
    ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "onResume");
    super.onResume();
    try
    {
      if (!this.yGw)
      {
        ac.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "onResume callback");
        bg.a(this, this.yHk);
        this.yGw = true;
      }
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al.aF(this);
      if (dON())
      {
        i = this.yGI.getChildCount() - 1;
        if (i >= 0)
        {
          Object localObject = this.yGI.getChildAt(i);
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
        ac.e("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", localThrowable.toString());
        continue;
        i -= 1;
        continue;
        localAdlandingDummyViewPager = null;
      }
      this.yGP = false;
      AdlandingDummyViewPager localAdlandingDummyViewPager = this.yGE;
      ViewPager.OnPageChangeListener localOnPageChangeListener = this.yHf;
      localAdlandingDummyViewPager.yrs.add(localOnPageChangeListener);
      android.support.v4.content.d.U(this).a(this.yHc, new IntentFilter("com.tencent.mm.adlanding.video_progressbar_change"));
      android.support.v4.content.d.U(this).a(this.yHd, new IntentFilter("com.tencent.mm.adlanding.set_uioption"));
      if (this.aKG) {
        this.startTime = System.currentTimeMillis();
      }
      com.tencent.mm.sdk.b.a.GpY.c(this.yHh);
      if (this.yGz) {
        ri(false);
      }
      if ((this.yGS != null) && (this.yGS.isShowing())) {
        this.yGS.dJY();
      }
      AppMethodBeat.o(98371);
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(179183);
    super.onStart();
    this.isVisible = true;
    if (this.aKG) {
      try
      {
        if ((!bs.T(new String[] { this.dyy, this.ykc })) && (!this.yGX))
        {
          if (this.yGY)
          {
            ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "execute mValidExposure onStart immediately");
            dOM();
            AppMethodBeat.o(179183);
            return;
          }
          if (this.yGZ != null)
          {
            ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "execute mValidExposureRunnable onStart");
            this.yGZ.removeCallbacks(this.yHj);
            this.yGZ.postDelayed(this.yHj, 1000L);
          }
        }
        AppMethodBeat.o(179183);
        return;
      }
      catch (Throwable localThrowable)
      {
        ac.e("MicroMsg.SnsAdNativeLandingPagesUI", localThrowable.toString());
      }
    }
    AppMethodBeat.o(179183);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(179184);
    super.onStop();
    this.isVisible = false;
    if (this.yGZ != null) {
      this.yGZ.removeCallbacks(this.yHj);
    }
    AppMethodBeat.o(179184);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(98373);
    this.yGv.fnm = 2;
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k localk = this.yGv;
    localk.yuX += 1;
    super.onSwipeBack();
    try
    {
      hideVKB();
      AppMethodBeat.o(98373);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.SnsAdNativeLandingPagesUI", "onSwipeBack hideVKB exp=" + localException.toString());
      AppMethodBeat.o(98373);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(200464);
    super.onWindowFocusChanged(paramBoolean);
    ac.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean) {}
    try
    {
      bg.a(this, null);
      this.yGw = false;
      AppMethodBeat.at(this, paramBoolean);
      AppMethodBeat.o(200464);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
      ac.e("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", localThrowable.toString());
      AppMethodBeat.at(this, paramBoolean);
      AppMethodBeat.o(200464);
    }
    if (!this.yGw)
    {
      ac.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "onWindowFocusChanged callback");
      bg.a(this, this.yHk);
      this.yGw = true;
    }
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(200464);
    return;
  }
  
  public final void ri(boolean paramBoolean)
  {
    AppMethodBeat.i(98394);
    if ((paramBoolean) && (this.bizId == 1)) {
      AdLandingPagesProxy.getInstance().doDynamicUpdateScene(this.yGA, this.yGB, this.yGC, this.yHg);
    }
    if ((this.bizId == 2) && (!bs.isNullOrNil(this.yGD))) {
      AdLandingPagesProxy.getInstance().doSearchDynamicUpdateScene(this.yGD, this.yHg);
    }
    this.yGz = true;
    AppMethodBeat.o(98394);
  }
  
  public final void xz(long paramLong)
  {
    AppMethodBeat.i(98403);
    if ((this.yGS == null) || (this.yGg == null))
    {
      AppMethodBeat.o(98403);
      return;
    }
    ContentFragment localContentFragment = dOW();
    if (localContentFragment == null)
    {
      AppMethodBeat.o(98403);
      return;
    }
    boolean bool1 = dPe();
    boolean bool2 = localContentFragment.dLq();
    boolean bool3 = this.yGU;
    boolean bool4 = localContentFragment.yrF;
    boolean bool5 = localContentFragment.iBV;
    boolean bool6 = localContentFragment.dLp();
    boolean bool7 = this.yGT;
    boolean bool8 = localContentFragment.dLw();
    boolean bool9 = localContentFragment.dLv();
    if ((bool4) && (bool8)) {
      this.yGV = true;
    }
    if (!bool4) {
      this.yGV = true;
    }
    ac.d("MicroMsg.SnsAdNativeLandingPagesUI", "toggleFloatBarView, isSourceAllow=" + bool1 + ", isForbid=" + bool2 + ", isKeybordShow=" + bool3 + ", isFirstPage=" + bool4 + ", isLastPage=" + bool5 + ", isCoverVideo=" + bool6 + ", isVideoCtrlBarShow=" + bool7 + ", isTopAppearOk=" + bool8 + ", isBottomAppearOk=" + bool9 + ", IsTopAppearChecked=" + this.yGV);
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
    if ((bool4) && (!bool8) && (!this.yGV))
    {
      AppMethodBeat.o(98403);
      return;
    }
    xO(paramLong);
    AppMethodBeat.o(98403);
  }
  
  final class a
  {
    public String pBm = "";
    public String tcG = "";
    public String yhw = "";
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI
 * JD-Core Version:    0.7.0.1
 */