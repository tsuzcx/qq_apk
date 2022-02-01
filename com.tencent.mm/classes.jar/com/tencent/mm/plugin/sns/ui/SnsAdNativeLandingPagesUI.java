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
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.g.a.nr.a;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.g.a.tb;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.model.AdlandingRemoteServiceConnectedReceiver;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdlandingDummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a;
import com.tencent.mm.plugin.sns.storage.b.j;
import com.tencent.mm.plugin.sns.storage.b.k;
import com.tencent.mm.plugin.sns.ui.helper.FloatWebViewHelper;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView.1;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView.2;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView.3;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView.4;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView.5;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView.6;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.cxi;
import com.tencent.mm.protocal.protobuf.cxj;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bh.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
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
  public static int xuk = 1000;
  public static int xul = 1000;
  private boolean aJQ;
  private int bizId;
  private String dAM;
  private int dep;
  String dpC;
  private long dsf;
  private String dvK;
  private long enterTime;
  private String iYE;
  private volatile boolean isVisible;
  private String jyv;
  private int kvn;
  private int kvo;
  private int nzW;
  private int nzX;
  private int nzY;
  private int nzZ;
  String oYa;
  String oYb;
  private volatile boolean qFd;
  private ImageView qdk;
  protected a.b rPQ;
  String rUO;
  private long startTime;
  private ImageView ubf;
  private String uin;
  private Map<String, String> values;
  private ImageView vjH;
  private int wSJ;
  private String wSi;
  private String wSj;
  private int wTf;
  private int wXj;
  private String wXl;
  private String wXo;
  private Map<String, String> wXp;
  private com.tencent.mm.plugin.sns.storage.p wwP;
  private ak xeP;
  public LinkedList<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g> xhQ;
  private String xtA;
  private ImageView xtB;
  String xtC;
  String xtD;
  private boolean xtE;
  com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k xtF;
  private volatile boolean xtG;
  boolean xtH;
  private int xtI;
  private boolean xtJ;
  private String xtK;
  private String xtL;
  private String xtM;
  private String xtN;
  private AdlandingDummyViewPager xtO;
  private int xtP;
  private int xtQ;
  private com.tencent.mm.sdk.platformtools.ap xtR;
  private FrameLayout xtS;
  private View xtT;
  private View xtU;
  private boolean xtV;
  private List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k> xtW;
  private com.tencent.mm.plugin.sns.ui.b.c xtX;
  private com.tencent.mm.plugin.sns.ui.b.d xtY;
  private boolean xtZ;
  public aa xtq;
  private ImageView xtr;
  private TextView xts;
  Bundle xtt;
  private boolean xtu;
  private boolean xtv;
  private String xtw;
  private String xtx;
  private String xty;
  private String xtz;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad xua;
  private Map<String, SnsAdLandingPageFloatView> xub;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d xuc;
  private boolean xud;
  public boolean xue;
  private boolean xuf;
  private volatile boolean xug;
  private volatile boolean xuh;
  private volatile boolean xui;
  private com.tencent.mm.sdk.platformtools.ap xuj;
  private BroadcastReceiver xum;
  private BroadcastReceiver xun;
  private ContentFragment.a xuo;
  private ViewPager.OnPageChangeListener xup;
  private AdLandingPagesProxy.e xuq;
  private com.tencent.mm.sdk.b.c<nr> xur;
  private com.tencent.mm.sdk.b.c<sy> xus;
  private Runnable xut;
  private bh.a xuu;
  private Map<Integer, ContentFragment> xuv;
  public b.a xuw;
  private BroadcastReceiver xux;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l xuy;
  private com.tencent.mm.ui.base.p xuz;
  
  public SnsAdNativeLandingPagesUI()
  {
    AppMethodBeat.i(98362);
    this.xhQ = new LinkedList();
    this.nzW = 0;
    this.nzX = 0;
    this.nzY = 0;
    this.nzZ = 0;
    this.xtu = false;
    this.xtv = false;
    this.xtE = false;
    this.dsf = 0L;
    this.enterTime = 0L;
    this.wXp = new HashMap();
    this.xtF = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k();
    this.xtG = false;
    this.xtH = false;
    this.xtI = 0;
    this.xtJ = false;
    this.xtR = new com.tencent.mm.sdk.platformtools.ap();
    this.xtV = true;
    this.aJQ = false;
    this.xub = new HashMap();
    this.xud = false;
    this.xue = false;
    this.xuf = false;
    this.isVisible = false;
    this.xug = false;
    this.xuh = false;
    this.xui = false;
    this.xuj = new com.tencent.mm.sdk.platformtools.ap();
    this.xum = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        boolean bool = true;
        AppMethodBeat.i(98324);
        int i = paramAnonymousIntent.getIntExtra("show", 0);
        paramAnonymousContext = (ContentFragment)((android.support.v4.app.i)SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getAdapter()).getItem(SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getCurrentItem());
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsAdNativeLandingPagesUI", "recv videoProgressbarStatusChangeReceiver show %d", new Object[] { Integer.valueOf(i) });
        if (i == 1) {}
        for (;;)
        {
          SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this, bool);
          SnsAdNativeLandingPagesUI.this.sW(500L);
          paramAnonymousContext.qd(bool);
          AppMethodBeat.o(98324);
          return;
          bool = false;
        }
      }
    };
    this.xun = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(98343);
        al.aB(SnsAdNativeLandingPagesUI.this);
        AppMethodBeat.o(98343);
      }
    };
    this.xuo = new ContentFragment.a()
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
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "onPreDraw %d, %d", new Object[] { Integer.valueOf(SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).getHeight()), Integer.valueOf(SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this)) });
              Object localObject1 = null;
              Object localObject2 = SnsAdNativeLandingPagesUI.d(SnsAdNativeLandingPagesUI.this);
              int i;
              if (localObject2 != null)
              {
                localObject1 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.af)localObject2).dwy();
                if (localObject1 != null)
                {
                  localObject1 = ((t)localObject1).wUA;
                  localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.iR((String)localObject1, "scene_ad_landing");
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
                  com.tencent.mm.sdk.platformtools.ad.i("SphereImageView.SnsAdNativeLandingPagesUI", i);
                }
              }
              else
              {
                if (!SnsAdNativeLandingPagesUI.f(SnsAdNativeLandingPagesUI.this)) {
                  break label245;
                }
                aq.n(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(98349);
                    Bitmap localBitmap;
                    if (this.xuH != null) {
                      localBitmap = this.xuH;
                    }
                    while (localBitmap != null)
                    {
                      SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).setAlpha(1.0F);
                      SnsAdNativeLandingPagesUI.h(SnsAdNativeLandingPagesUI.this).setImageBitmap(localBitmap);
                      SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this, SnsAdNativeLandingPagesUI.19.1.this.lXQ, localBitmap.getWidth(), localBitmap.getHeight());
                      AppMethodBeat.o(98349);
                      return;
                      if (SnsAdNativeLandingPagesUI.g(SnsAdNativeLandingPagesUI.this))
                      {
                        localBitmap = f.fy(SnsAdNativeLandingPagesUI.19.1.this.lXQ.getChildAt(0));
                        SnsAdNativeLandingPagesUI.h(SnsAdNativeLandingPagesUI.this).setScaleType(ImageView.ScaleType.CENTER_CROP);
                      }
                      else
                      {
                        localBitmap = f.fy(SnsAdNativeLandingPagesUI.e(SnsAdNativeLandingPagesUI.this));
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
                SnsAdNativeLandingPagesUI.this.sW(300L);
              }
            }
          });
        }
        AppMethodBeat.o(98351);
      }
    };
    this.xup = new ViewPager.f()
    {
      public final void onPageScrollStateChanged(int paramAnonymousInt)
      {
        AppMethodBeat.i(98353);
        super.onPageScrollStateChanged(paramAnonymousInt);
        SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this).xeX = paramAnonymousInt;
        Object localObject;
        if (paramAnonymousInt == 1)
        {
          paramAnonymousInt = 0;
          while (paramAnonymousInt < SnsAdNativeLandingPagesUI.this.xhQ.size())
          {
            localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)SnsAdNativeLandingPagesUI.this.xhQ.get(paramAnonymousInt);
            localObject = (Fragment)SnsAdNativeLandingPagesUI.k(SnsAdNativeLandingPagesUI.this).get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject).id));
            if (localObject != null) {
              ((ContentFragment)localObject).dwU();
            }
            paramAnonymousInt += 1;
          }
          al.fV(SnsAdNativeLandingPagesUI.this.getContext());
          AppMethodBeat.o(98353);
          return;
        }
        if (paramAnonymousInt == 0)
        {
          localObject = (Fragment)SnsAdNativeLandingPagesUI.k(SnsAdNativeLandingPagesUI.this).get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)SnsAdNativeLandingPagesUI.this.xhQ.get(SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getCurrentItem())).id));
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
          if ((localContentFragment.ctF) && (localContentFragment.xeN != null)) {
            localContentFragment.xeN.dwJ();
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
        if (i < SnsAdNativeLandingPagesUI.this.xhQ.size())
        {
          Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)SnsAdNativeLandingPagesUI.this.xhQ.get(i);
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
            ((ContentFragment)localObject).dwU();
          }
        }
        SnsAdNativeLandingPagesUI.this.sW(300L);
        AppMethodBeat.o(98354);
      }
    };
    this.xuq = new AdLandingPagesProxy.e()
    {
      public final void bf(final Object paramAnonymousObject)
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
            localObject = new i.a(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.ja((String)localObject, str), SnsAdNativeLandingPagesUI.n(SnsAdNativeLandingPagesUI.this));
            SnsAdNativeLandingPagesUI.this.xhQ = ((i.a)localObject).xhQ;
            SnsAdNativeLandingPagesUI.this.xtq = ((i.a)localObject).xhR;
            aq.f(new Runnable()
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
    this.xur = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(nr paramAnonymousnr)
      {
        AppMethodBeat.i(176294);
        Object localObject1;
        SnsAdLandingPageFloatView localSnsAdLandingPageFloatView;
        if ((SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this).xeJ.xhJ != null) && (SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this).xeJ.xhJ.containsKey(paramAnonymousnr.dsM.dsN)) && (!SnsAdNativeLandingPagesUI.r(SnsAdNativeLandingPagesUI.this).containsKey(paramAnonymousnr.dsM.dsN)))
        {
          SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this).onPause();
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("sns_landing_pages_xml", SnsAdNativeLandingPagesUI.m(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putString("sns_float_component_id", paramAnonymousnr.dsM.dsN);
          ((Bundle)localObject1).putInt("sns_landing_page_index", SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this).xeJ.id);
          ((Bundle)localObject1).putString("sns_landing_page_snsId", SnsAdNativeLandingPagesUI.this.dpC);
          ((Bundle)localObject1).putString("sns_landing_pages_rawSnsId", SnsAdNativeLandingPagesUI.this.xtD);
          ((Bundle)localObject1).putString("sns_landing_pages_ux_info", SnsAdNativeLandingPagesUI.s(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putString("sns_landing_pages_aid", SnsAdNativeLandingPagesUI.o(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putInt("sns_landing_pages_biz_id", SnsAdNativeLandingPagesUI.t(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putString("sns_landing_pages_traceid", SnsAdNativeLandingPagesUI.p(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putInt("sns_landig_pages_from_source", SnsAdNativeLandingPagesUI.u(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putString("sns_landing_pages_xml_prefix", SnsAdNativeLandingPagesUI.n(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putBoolean("sns_landing_is_native_sight_ad", SnsAdNativeLandingPagesUI.v(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putString("sns_landing_pages_canvas_ext", SnsAdNativeLandingPagesUI.w(SnsAdNativeLandingPagesUI.this));
          localSnsAdLandingPageFloatView = new SnsAdLandingPageFloatView(SnsAdNativeLandingPagesUI.this);
          localSnsAdLandingPageFloatView.xtw = ((Bundle)localObject1).getString("sns_landing_pages_xml");
          localSnsAdLandingPageFloatView.dsN = ((Bundle)localObject1).getString("sns_float_component_id");
          localSnsAdLandingPageFloatView.xXi = ((Bundle)localObject1).getInt("sns_landing_page_index", -1);
          localSnsAdLandingPageFloatView.dvK = ((Bundle)localObject1).getString("sns_landing_pages_ux_info");
          localSnsAdLandingPageFloatView.xXk = ((Bundle)localObject1).getString("sns_landing_pages_aid");
          localSnsAdLandingPageFloatView.iYE = ((Bundle)localObject1).getString("sns_landing_pages_traceid");
          localSnsAdLandingPageFloatView.wSj = ((Bundle)localObject1).getString("sns_landing_pages_canvas_ext");
          if ((!bt.T(new String[] { localSnsAdLandingPageFloatView.xtw, localSnsAdLandingPageFloatView.dsN })) && (localSnsAdLandingPageFloatView.xXi != -1)) {
            break label521;
          }
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsAdLandingPageFloatView", "invalid landing float page data!");
        }
        for (;;)
        {
          localSnsAdLandingPageFloatView.setBackgroundColor(SnsAdNativeLandingPagesUI.this.getResources().getColor(2131100893));
          SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).addView(localSnsAdLandingPageFloatView, SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).getChildCount() - 1, new FrameLayout.LayoutParams(-1, -1));
          if (!localSnsAdLandingPageFloatView.xMz)
          {
            localSnsAdLandingPageFloatView.xXp.start();
            localSnsAdLandingPageFloatView.xMz = true;
          }
          SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this).dwU();
          SnsAdNativeLandingPagesUI.this.j(false, 0L);
          SnsAdNativeLandingPagesUI.r(SnsAdNativeLandingPagesUI.this).put(paramAnonymousnr.dsM.dsN, localSnsAdLandingPageFloatView);
          AppMethodBeat.o(176294);
          return false;
          label521:
          localSnsAdLandingPageFloatView.xXj = bt.by(((Bundle)localObject1).getString("sns_landing_pages_xml_prefix"), "adxml");
          localSnsAdLandingPageFloatView.xhQ = new i.a(localSnsAdLandingPageFloatView.xtw, localSnsAdLandingPageFloatView.xXj).xhQ;
          Object localObject2;
          if ((localSnsAdLandingPageFloatView.xhQ != null) && (localSnsAdLandingPageFloatView.xhQ.size() > localSnsAdLandingPageFloatView.xXi))
          {
            localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localSnsAdLandingPageFloatView.xhQ.get(localSnsAdLandingPageFloatView.xXi);
            localSnsAdLandingPageFloatView.xXm = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g();
            localSnsAdLandingPageFloatView.xXm.jbK = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject1).jbK;
            localObject2 = (x)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject1).xhJ.get(localSnsAdLandingPageFloatView.dsN);
            if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.MW(((x)localObject2).type))
            {
              localSnsAdLandingPageFloatView.xXl = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v)localObject2);
              localSnsAdLandingPageFloatView.xXm.xhI.add(localSnsAdLandingPageFloatView.xXl);
              localSnsAdLandingPageFloatView.xXm.xhJ.putAll(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject1).xhJ);
            }
            localSnsAdLandingPageFloatView.xXm.id = 0;
            localSnsAdLandingPageFloatView.xXm.xhK = true;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdLandingPageFloatView", "[reportInfo] aid %s,traceId %s,uxInfo %s,adCanvasExtXml %s", new Object[] { localSnsAdLandingPageFloatView.xXk, localSnsAdLandingPageFloatView.iYE, localSnsAdLandingPageFloatView.dvK, localSnsAdLandingPageFloatView.wSj });
          if (localSnsAdLandingPageFloatView.xXm == null) {
            continue;
          }
          if (localSnsAdLandingPageFloatView.xXl != null) {}
          try
          {
            i = Color.parseColor(localSnsAdLandingPageFloatView.xXm.jbK);
            localSnsAdLandingPageFloatView.xXn = as.a(localSnsAdLandingPageFloatView.getContext(), localSnsAdLandingPageFloatView.xXl, localSnsAdLandingPageFloatView, i);
            localSnsAdLandingPageFloatView.xXn.setBackgroundColor(i);
            localSnsAdLandingPageFloatView.xXo = localSnsAdLandingPageFloatView.xXn.getView();
            localSnsAdLandingPageFloatView.addView(localSnsAdLandingPageFloatView.xXo);
            localSnsAdLandingPageFloatView.xXn.dwf();
            localSnsAdLandingPageFloatView.setOnTouchListener(new SnsAdLandingPageFloatView.6(localSnsAdLandingPageFloatView));
            localSnsAdLandingPageFloatView.dEc();
            localObject1 = ValueAnimator.ofFloat(new float[] { 0.4F, 0.96F }).setDuration(200L);
            ((ValueAnimator)localObject1).setInterpolator(new OvershootInterpolator());
            localObject2 = ValueAnimator.ofFloat(new float[] { 0.96F, 1.0F }).setDuration(100L);
            ((ValueAnimator)localObject1).addUpdateListener(new SnsAdLandingPageFloatView.1(localSnsAdLandingPageFloatView));
            ((ValueAnimator)localObject2).addUpdateListener(new SnsAdLandingPageFloatView.2(localSnsAdLandingPageFloatView));
            localSnsAdLandingPageFloatView.xXp.playSequentially(new Animator[] { localObject1, localObject2 });
            localSnsAdLandingPageFloatView.xXp.addListener(new SnsAdLandingPageFloatView.3(localSnsAdLandingPageFloatView));
            localSnsAdLandingPageFloatView.tck.addUpdateListener(new SnsAdLandingPageFloatView.4(localSnsAdLandingPageFloatView));
            localSnsAdLandingPageFloatView.tck.addListener(new SnsAdLandingPageFloatView.5(localSnsAdLandingPageFloatView));
          }
          catch (Exception localException)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsAdLandingPageFloatView", "parseColor exp=" + localException.toString() + ", colorStr=" + localSnsAdLandingPageFloatView.xXm.jbK);
              int i = 0;
            }
          }
        }
      }
    };
    this.xus = new com.tencent.mm.sdk.b.c() {};
    this.xut = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98328);
        SnsAdNativeLandingPagesUI.H(SnsAdNativeLandingPagesUI.this);
        if ((!SnsAdNativeLandingPagesUI.I(SnsAdNativeLandingPagesUI.this)) && (SnsAdNativeLandingPagesUI.J(SnsAdNativeLandingPagesUI.this))) {
          SnsAdNativeLandingPagesUI.K(SnsAdNativeLandingPagesUI.this);
        }
        AppMethodBeat.o(98328);
      }
    };
    this.xuu = new bh.a()
    {
      public final void P(String paramAnonymousString, long paramAnonymousLong)
      {
        AppMethodBeat.i(187634);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "onScreenShot， path = " + paramAnonymousString + "， dateAdded = " + paramAnonymousLong);
        SnsAdNativeLandingPagesUI.L(SnsAdNativeLandingPagesUI.this);
        AppMethodBeat.o(187634);
      }
    };
    this.xuv = new HashMap();
    this.rPQ = new a.b()
    {
      public final void aXO()
      {
        AppMethodBeat.i(187644);
        try
        {
          AdLandingPagesProxy.getInstance().favEditTag();
          AppMethodBeat.o(187644);
          return;
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsAdNativeLandingPagesUI", "favorite edittag fail, ex = " + localException.getMessage());
          AppMethodBeat.o(187644);
        }
      }
    };
    this.xuw = new b.a()
    {
      public final void bu(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(187645);
        SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this, paramAnonymousBoolean);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "onKeyboardStateChanged, visiable=".concat(String.valueOf(paramAnonymousBoolean)));
        SnsAdNativeLandingPagesUI.this.sW(300L);
        AppMethodBeat.o(187645);
      }
    };
    this.xux = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(187647);
        if (paramAnonymousIntent.getAction().equals("android.intent.action.SCREEN_OFF"))
        {
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsAdNativeLandingPagesUI", "android.intent.action.SCREEN_OFF");
          AppMethodBeat.o(187647);
          return;
        }
        if (paramAnonymousIntent.getAction().equals("android.intent.action.SCREEN_ON"))
        {
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsAdNativeLandingPagesUI", "android.intent.action.SCREEN_ON");
          al.aB(SnsAdNativeLandingPagesUI.this);
        }
        AppMethodBeat.o(187647);
      }
    };
    this.xuy = null;
    this.xuz = null;
    AppMethodBeat.o(98362);
  }
  
  private void VL()
  {
    AppMethodBeat.i(98374);
    this.wwP = AdLandingPagesProxy.getInstance().getSnsInfo(this.dpC);
    AdLandingPagesProxy.getInstance().asyncCacheXml(this.dpC);
    if (this.values == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsAdNativeLandingPagesUI", "parse landingpagexml is error,landingpagexml is " + this.xtw);
      AppMethodBeat.o(98374);
      return;
    }
    long l;
    Object localObject2;
    Object localObject3;
    label624:
    int i;
    if ((this.dep == 1) || (this.dep == 2) || (this.dep == 16) || (this.dep == 14) || (this.dep == 9) || (this.dep == 10))
    {
      l = 0L;
      if (this.wwP != null)
      {
        l = this.wwP.field_snsId;
        this.wSi = AdLandingPagesProxy.getInstance().getSnsAid(this.dpC);
        this.iYE = AdLandingPagesProxy.getInstance().getSnsTraceid(this.dpC);
        this.wSJ = AdLandingPagesProxy.getInstance().getSnsAdType(this.dpC);
        this.dvK = AdLandingPagesProxy.getInstance().getSnsUxInfo(this.dpC);
        this.wSj = AdLandingPagesProxy.getInstance().getSnsAdCanvasExtXml(this.dpC);
      }
      if (this.xtD != null)
      {
        localObject1 = this.xtD;
        this.values.put("." + this.xtx + ".originSnsId", localObject1);
        this.values.put("." + this.xtx + ".originUxInfo", this.dvK);
        localObject2 = "<" + this.xtx + ">";
        localObject2 = (String)localObject2 + String.format("<originSnsId>%s</originSnsId>", new Object[] { localObject1 });
        localObject2 = (String)localObject2 + String.format("<originUxInfo>%s</originUxInfo>", new Object[] { this.dvK });
        localObject2 = (String)localObject2 + String.format("<originAdType>%d</originAdType>", new Object[] { Integer.valueOf(this.wSJ) });
        localObject2 = (String)localObject2 + String.format("<originAid>%s</originAid>", new Object[] { this.wSi });
        localObject3 = (String)localObject2 + String.format("<originTraceId>%s</originTraceId>", new Object[] { this.iYE });
        localObject2 = localObject3;
        if (!bt.isNullOrNil(this.wSj)) {
          localObject2 = (String)localObject3 + String.format("<originAdCanvasExt>%s</originAdCanvasExt>", new Object[] { this.wSj });
        }
        this.xtw = this.xtw.replace("<" + this.xtx + ">", (CharSequence)localObject2);
        this.xtF.dvK = this.dvK;
        this.xtF.dpC = ((String)localObject1);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "reportInfo aid [%s],traceId [%s],adType [%s],uxInfo [%s],adCanvasExtXml [%s]", new Object[] { this.wSi, this.iYE, Integer.valueOf(this.wSJ), this.dvK, this.wSj });
        if (bt.isNullOrNil(this.wSj)) {
          break label1407;
        }
        localObject2 = bw.K(this.wSj, "adCardItemList");
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
        localObject3 = bt.by((String)((Map)localObject2).get((String)localObject1 + ".cardTpId"), "");
        localObject1 = bt.by((String)((Map)localObject2).get((String)localObject1 + ".cardExt"), "");
        if ((!bt.isNullOrNil((String)localObject3)) && (!bt.isNullOrNil((String)localObject1))) {
          this.wXp.put(localObject3, localObject1);
        }
        i += 1;
        break label704;
        localObject1 = String.valueOf(l);
        break;
        this.xtF.dpC = ((String)this.values.get("." + this.xtx + ".originSnsId"));
        this.xtF.dvK = ((String)this.values.get("." + this.xtx + ".originUxInfo"));
        this.dvK = this.xtF.dvK;
        this.xtD = this.xtF.dpC;
        this.wSJ = bt.aGh((String)this.values.get("." + this.xtx + ".originAdType"));
        this.wSi = ((String)this.values.get("." + this.xtx + ".originAid"));
        this.iYE = ((String)this.values.get("." + this.xtx + ".originTraceId"));
        if (!bt.isNullOrNil(this.jyv))
        {
          localObject1 = bw.K(this.jyv, "ADInfo");
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "adInfoXml %s", new Object[] { this.jyv });
          if (localObject1 != null)
          {
            this.dvK = bt.by((String)((Map)localObject1).get(".ADInfo.uxInfo"), "");
            this.xtF.dvK = this.dvK;
            this.wSi = bt.by((String)((Map)localObject1).get(".ADInfo.session_data.aid"), "");
            this.iYE = bt.by((String)((Map)localObject1).get(".ADInfo.session_data.trace_id"), "");
            this.dAM = bt.by((String)((Map)localObject1).get(".ADInfo.viewid"), "");
            this.wXo = bt.by((String)((Map)localObject1).get(".ADInfo.commInfo"), "");
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "viewId = " + this.dAM + ", commInfo = " + this.wXo + ", uxInfo = " + this.dvK);
          }
        }
        localObject1 = Pattern.compile("<originAdCanvasExt>[\\s\\S]*</originAdCanvasExt>").matcher(this.xtw);
        if (!((Matcher)localObject1).find()) {
          break label624;
        }
        localObject1 = ((Matcher)localObject1).group();
        if (bt.isNullOrNil((String)localObject1)) {
          break label624;
        }
        this.wSj = ((String)localObject1).replaceAll("</?originAdCanvasExt>", "");
        break label624;
      }
      label1407:
      this.xtF.xin = AdLandingPagesProxy.getInstance().getSnsStatExtBySnsId(bt.aGi(this.xtF.dpC));
      this.oYb = bt.by((String)this.values.get("." + this.xtx + ".adCanvasInfo.shareTitle"), "");
      this.oYa = bt.by((String)this.values.get("." + this.xtx + ".adCanvasInfo.shareWebUrl"), "");
      this.rUO = bt.by((String)this.values.get("." + this.xtx + ".adCanvasInfo.shareDesc"), "");
      this.bizId = bt.aGh(bt.by((String)this.values.get("." + this.xtx + ".adCanvasInfo.bizId"), ""));
      this.xtK = bt.by((String)this.values.get("." + this.xtx + ".adCanvasInfo.shareAppId"), "");
      this.xtL = bt.by((String)this.values.get("." + this.xtx + ".adCanvasInfo.shareType"), "");
      this.xtM = bt.by((String)this.values.get("." + this.xtx + ".adCanvasInfo.userInfo"), "");
      this.xtP = bt.aGh(bt.by((String)this.values.get("." + this.xtx + ".adCanvasInfo.disableShareBitSet"), ""));
      this.xtQ = bt.aGh(bt.by((String)this.values.get("." + this.xtx + ".adCanvasInfo.statusBarStyle"), ""));
      v(this.values, "." + this.xtx);
      this.uin = AdLandingPagesProxy.getInstance().getUin();
      this.xtN = bt.by((String)this.values.get("." + this.xtx + ".adCanvasInfo.officialSyncBuffer"), "");
      getIntent().putExtra("sns_landing_pages_adType", this.wSJ);
      getIntent().putExtra("sns_landing_pages_rawSnsId", this.xtF.dpC);
      if (bt.isNullOrNil(this.wSi)) {
        this.wSi = bt.by((String)this.values.get("." + this.xtx + ".originAid"), "");
      }
      if (bt.isNullOrNil(this.iYE)) {
        this.iYE = bt.by((String)this.values.get("." + this.xtx + ".originTraceId"), "");
      }
      localObject1 = new i.a(this.xtw, this.xtx);
      this.xhQ = ((i.a)localObject1).xhQ;
      this.xtq = ((i.a)localObject1).xhR;
      dAF();
      a((i.a)localObject1);
      if (this.xhQ.size() > 0)
      {
        localObject2 = "";
        localObject3 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.xhQ.get(0);
        localObject1 = localObject2;
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject3).xhI.size() > 0)
        {
          localObject3 = (x)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject3).xhI.get(0);
          if (!(localObject3 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)) {
            break label2564;
          }
          this.xtC = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)localObject3).wWp;
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        if (this.wwP != null)
        {
          localObject2 = this.wwP.dxy();
          if ((localObject2 != null) && (((TimeLineObject)localObject2).Etm != null) && (((TimeLineObject)localObject2).Etm.DaC != null) && (!((TimeLineObject)localObject2).Etm.DaC.isEmpty()))
          {
            localObject3 = (bpi)((TimeLineObject)localObject2).Etm.DaC.getFirst();
            localObject2 = an.iF(AdLandingPagesProxy.getInstance().getAccSnsPath(), ((bpi)localObject3).Id) + com.tencent.mm.plugin.sns.data.q.i((bpi)localObject3);
            localObject3 = ((bpi)localObject3).Url;
            if (((String)localObject1).equals(localObject3))
            {
              localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.iV("adId", (String)localObject3);
              if ((!com.tencent.mm.vfs.i.eK((String)localObject1)) && (com.tencent.mm.vfs.i.eK((String)localObject2)))
              {
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "copy outsideFiel:%s->%s", new Object[] { localObject2, localObject1 });
                com.tencent.mm.vfs.i.lC((String)localObject2, (String)localObject1);
              }
            }
          }
        }
        this.xty = bt.by((String)this.values.get("." + this.xtx + ".adCanvasInfo.rightBarTitle"), "");
        this.xtz = bt.by((String)this.values.get("." + this.xtx + ".adCanvasInfo.rightBarCanvasId"), "");
        this.xtA = bt.by((String)this.values.get("." + this.xtx + ".adCanvasInfo.rightBarCanvasExt"), "");
        AppMethodBeat.o(98374);
        return;
        if ((localObject3 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r))
        {
          this.xtC = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)localObject3).wWp;
          localObject1 = localObject2;
        }
        else if ((localObject3 instanceof u))
        {
          this.xtC = ((u)localObject3).wWv;
          localObject1 = ((u)localObject3).wWu;
        }
        else
        {
          localObject1 = localObject2;
          if ((localObject3 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af))
          {
            localObject3 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af)localObject3;
            localObject1 = localObject2;
            if (!((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af)localObject3).wWn.isEmpty())
            {
              localObject3 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af)localObject3).wWn.getFirst();
              localObject1 = localObject2;
              if (!((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)localObject3).wWn.isEmpty())
              {
                localObject3 = (x)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)localObject3).wWn.getFirst();
                localObject1 = localObject2;
                if ((localObject3 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s))
                {
                  this.xtC = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)localObject3).wWp;
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
    AppMethodBeat.i(187655);
    try
    {
      if ((parama.xhS != null) && (this.xtU != null))
      {
        parama = FloatWebViewHelper.a(parama.xhS, (ViewGroup)this.xtU);
        getLifecycle().addObserver(parama);
      }
      AppMethodBeat.o(187655);
      return;
    }
    catch (Throwable parama)
    {
      AppMethodBeat.o(187655);
    }
  }
  
  private void aJp()
  {
    AppMethodBeat.i(98378);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.xtO.getAdapter();
    if (localb == null)
    {
      localb = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b(getSupportFragmentManager(), new ArrayList());
      this.xtO.setAdapter(localb);
    }
    for (;;)
    {
      List localList = dAr();
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g localg;
      ContentFragment localContentFragment;
      if (localList.size() > 0)
      {
        localg = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localList.get(0);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "loadFirstPage load id %s", new Object[] { Integer.valueOf(localg.id) });
        localContentFragment = (ContentFragment)this.xuv.get(Integer.valueOf(localg.id));
        if (localContentFragment != null) {
          break label362;
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("pageInfo", localg);
        localHashMap.put("pageCount", Integer.valueOf(localList.size()));
        localHashMap.put("viewPager", this.xtO);
        localHashMap.put("pageDownIconInfo", this.xeP);
        localHashMap.put("is_first_show_page", Boolean.TRUE);
        if (localList.size() == 1) {
          localHashMap.put("is_last_shown_page", Boolean.TRUE);
        }
        localHashMap.put("needEnterAnimation", Boolean.valueOf(this.xtu));
        localHashMap.put("needDirectionAnimation", Boolean.valueOf(dAu()));
        localHashMap.put("groupListCompShowIndex", Integer.valueOf(this.xtI));
        localContentFragment = new ContentFragment();
        localContentFragment.uLu = localHashMap;
        localContentFragment.xeY = this.xuo;
        this.xuv.put(Integer.valueOf(localg.id), localContentFragment);
      }
      for (;;)
      {
        if (localContentFragment != null) {
          localb.c(localContentFragment, 0);
        }
        localb.notifyDataSetChanged();
        this.xtO.setOffscreenPageLimit(localList.size());
        AppMethodBeat.o(98378);
        return;
        label362:
        localContentFragment.a(localg);
      }
    }
  }
  
  private String aqx(String paramString)
  {
    AppMethodBeat.i(98389);
    String str = bt.by((String)this.values.get("." + this.xtx + ".adCanvasInfo.shareThumbUrl"), "");
    if (!bt.isNullOrNil(str))
    {
      AppMethodBeat.o(98389);
      return str;
    }
    AppMethodBeat.o(98389);
    return paramString;
  }
  
  private a dAA()
  {
    AppMethodBeat.i(98388);
    Object localObject = new com.tencent.mm.plugin.sns.storage.b(this.xtw);
    if (((com.tencent.mm.plugin.sns.storage.b)localObject).dvq())
    {
      int i = AdLandingPagesProxy.getInstance().getAdVoteIndex(((com.tencent.mm.plugin.sns.storage.b)localObject).wTR.wUF, this.dvK, this.uin);
      if ((i > 0) && (i <= ((com.tencent.mm.plugin.sns.storage.b)localObject).wTR.wUH.size()))
      {
        localObject = (b.k)((com.tencent.mm.plugin.sns.storage.b)localObject).wTR.wUH.get(i - 1);
        a locala = new a((byte)0);
        if (!bt.isNullOrNil(((b.k)localObject).oYb))
        {
          locala.oYb = ((b.k)localObject).oYb;
          if (bt.isNullOrNil(((b.k)localObject).rUO)) {
            break label165;
          }
          locala.rUO = ((b.k)localObject).rUO;
          label128:
          if (bt.isNullOrNil(((b.k)localObject).wUI)) {
            break label176;
          }
        }
        label165:
        label176:
        for (locala.wUI = ((b.k)localObject).wUI;; locala.wUI = this.xtC)
        {
          AppMethodBeat.o(98388);
          return locala;
          locala.oYb = this.oYb;
          break;
          locala.rUO = this.rUO;
          break label128;
        }
      }
    }
    AppMethodBeat.o(98388);
    return null;
  }
  
  private String dAB()
  {
    AppMethodBeat.i(98390);
    Object localObject = new cxi();
    ((cxi)localObject).Ept = new cxj();
    ((cxi)localObject).Ept.CoM = this.xtF.dvK;
    ((cxi)localObject).Ept.Epw = this.xtF.dpC;
    ((cxi)localObject).Ept.wSJ = this.wSJ;
    try
    {
      localObject = Base64.encodeToString(((cxi)localObject).toByteArray(), 2);
      AppMethodBeat.o(98390);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(98390);
    }
    return "";
  }
  
  private String dAC()
  {
    AppMethodBeat.i(98391);
    String str2 = this.xtw.replaceAll("(?s)<adCanvasInfoLeft[^>]*>.*?</adCanvasInfoLeft>", "").replaceAll("(?s)<adCanvasInfoRight[^>]*>.*?</adCanvasInfoRight>", "");
    String str1 = str2;
    if (str2.contains("<shareAdCanvasInfo>")) {
      str1 = str2.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replace("shareAdCanvasInfo", "adCanvasInfo");
    }
    AppMethodBeat.o(98391);
    return str1;
  }
  
  private void dAF()
  {
    AppMethodBeat.i(98398);
    if ((this.xtq != null) && (this.xtS != null) && (this.xuc == null))
    {
      this.xuc = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d(this, this.xtq, this.xtS);
      j(false, 0L);
    }
    AppMethodBeat.o(98398);
  }
  
  private boolean dAH()
  {
    AppMethodBeat.i(98404);
    if (this.xtq != null)
    {
      if (this.xtq.wWW == 1)
      {
        boolean bool = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s.MF(this.dep);
        AppMethodBeat.o(98404);
        return bool;
      }
      AppMethodBeat.o(98404);
      return true;
    }
    AppMethodBeat.o(98404);
    return false;
  }
  
  private void dAk()
  {
    AppMethodBeat.i(98364);
    AdlandingRemoteServiceConnectedReceiver.a(android.support.v4.content.d.T(this));
    VL();
    if (this.xtu) {
      aJp();
    }
    for (;;)
    {
      refreshView();
      dAm();
      dAn();
      qj(true);
      this.aJQ = true;
      AppMethodBeat.o(98364);
      return;
      dAs();
    }
  }
  
  private void dAl()
  {
    AppMethodBeat.i(98367);
    Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.xtO.getAdapter();
    if (localObject == null)
    {
      AppMethodBeat.o(98367);
      return;
    }
    localObject = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)localObject).fragments.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ContentFragment localContentFragment = (ContentFragment)((Iterator)localObject).next();
      if ((localContentFragment.xeN != null) && (localContentFragment.getUserVisibleHint())) {
        localContentFragment.xeN.dwK();
      }
    }
    if (this.xuc != null) {
      this.xuc.dvA();
    }
    AppMethodBeat.o(98367);
  }
  
  private void dAm()
  {
    AppMethodBeat.i(98369);
    com.tencent.mm.plugin.report.service.h localh;
    String str2;
    if (this.wTf != 2)
    {
      localh = com.tencent.mm.plugin.report.service.h.vKh;
      str2 = com.tencent.mm.plugin.sns.data.q.st(com.tencent.mm.plugin.sns.data.q.anR(this.xtF.dpC));
      if (this.dvK != null) {
        break label127;
      }
    }
    label127:
    for (String str1 = "";; str1 = this.dvK)
    {
      localh.f(14655, new Object[] { str2, str1, Integer.valueOf(this.xtF.fOf), Integer.valueOf(this.xtF.oIw), Long.valueOf(this.enterTime), Integer.valueOf(this.wXj), this.xtF.jyu });
      AppMethodBeat.o(98369);
      return;
    }
  }
  
  private void dAn()
  {
    AppMethodBeat.i(179185);
    try
    {
      if (!bt.T(new String[] { this.dAM, this.wXo }))
      {
        if (!this.xug) {
          dAo();
        }
        if ((!this.xuh) && (this.xuj != null))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "execute mValidExposureRunnable onCreate");
          this.xuj.removeCallbacks(this.xut);
          this.xuj.postDelayed(this.xut, 1000L);
        }
      }
      AppMethodBeat.o(179185);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsAdNativeLandingPagesUI", localThrowable.toString());
      AppMethodBeat.o(179185);
    }
  }
  
  private void dAo()
  {
    AppMethodBeat.i(179186);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "reportOriginalExposure viewId = " + this.dAM + ", commInfo = " + this.wXo + ", uxInfo = " + this.dvK + ", exposureType = 0");
    this.xug = true;
    g(this.dAM, this.wXo, this.dvK, 0);
    AppMethodBeat.o(179186);
  }
  
  private void dAp()
  {
    AppMethodBeat.i(179187);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "reportValidExposure viewId = " + this.dAM + ", commInfo = " + this.wXo + ", uxInfo = " + this.dvK + ", exposureType = 1");
    this.xuh = true;
    g(this.dAM, this.wXo, this.dvK, 1);
    AppMethodBeat.o(179187);
  }
  
  private boolean dAq()
  {
    AppMethodBeat.i(98370);
    int j = this.xtS.getChildCount();
    int i = 0;
    while (i < j)
    {
      if ((this.xtS.getChildAt(i) instanceof SnsAdLandingPageFloatView))
      {
        AppMethodBeat.o(98370);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(98370);
    return false;
  }
  
  private List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g> dAr()
  {
    AppMethodBeat.i(98376);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.xhQ.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g localg = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localIterator.next();
      if (localg.xhK) {
        localArrayList.add(localg);
      }
    }
    fC(localArrayList);
    AppMethodBeat.o(98376);
    return localArrayList;
  }
  
  private void dAs()
  {
    AppMethodBeat.i(98379);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.xtO.getAdapter();
    if (localb == null)
    {
      localb = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b(getSupportFragmentManager(), new ArrayList());
      this.xtO.setAdapter(localb);
    }
    for (;;)
    {
      List localList = dAr();
      int i = 0;
      if (i < localList.size())
      {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g localg = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.xhQ.get(i);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "loadLandingPages load id %s", new Object[] { Integer.valueOf(localg.id) });
        ContentFragment localContentFragment = (ContentFragment)this.xuv.get(Integer.valueOf(localg.id));
        boolean bool;
        label214:
        label244:
        int j;
        if (localContentFragment == null)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("pageInfo", localg);
          localHashMap.put("pageCount", Integer.valueOf(localList.size()));
          localHashMap.put("viewPager", this.xtO);
          localHashMap.put("pageDownIconInfo", this.xeP);
          if (i == 0)
          {
            bool = true;
            localHashMap.put("is_first_show_page", Boolean.valueOf(bool));
            if (i != localList.size() - 1) {
              break label393;
            }
            bool = true;
            localHashMap.put("is_last_shown_page", Boolean.valueOf(bool));
            localHashMap.put("needEnterAnimation", Boolean.valueOf(this.xtu));
            localHashMap.put("needDirectionAnimation", Boolean.valueOf(dAu()));
            if (i != 0) {
              break label398;
            }
            j = this.xtI;
            label304:
            localHashMap.put("groupListCompShowIndex", Integer.valueOf(j));
            localContentFragment = new ContentFragment();
            localContentFragment.uLu = localHashMap;
            if (i == 0) {
              localContentFragment.xeY = this.xuo;
            }
            this.xuv.put(Integer.valueOf(localg.id), localContentFragment);
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
      this.xtO.setOffscreenPageLimit(localList.size());
      AppMethodBeat.o(98379);
      return;
    }
  }
  
  private boolean dAt()
  {
    AppMethodBeat.i(98382);
    if (this.xtP != 0)
    {
      if (((this.xtP & 0x4) == 0) || ((this.xtP & 0x2) == 0) || ((dAx()) && (this.bizId == 2)) || ((this.xtP & 0x1) == 0))
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
  
  private boolean dAu()
  {
    return (this.xtP & 0x8) == 0;
  }
  
  private boolean dAv()
  {
    return this.xtQ == 0;
  }
  
  private boolean dAw()
  {
    AppMethodBeat.i(98383);
    if ((!bt.isNullOrNil(this.xty)) && (!bt.isNullOrNil(this.xtz)))
    {
      AppMethodBeat.o(98383);
      return true;
    }
    AppMethodBeat.o(98383);
    return false;
  }
  
  private boolean dAx()
  {
    return (this.xtP & 0x10) == 0;
  }
  
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.af dAy()
  {
    AppMethodBeat.i(98385);
    Object localObject = dAz().dwO().iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k localk = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k)((Iterator)localObject).next();
      if ((localk instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.af))
      {
        localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.af)localk;
        AppMethodBeat.o(98385);
        return localObject;
      }
    }
    AppMethodBeat.o(98385);
    return null;
  }
  
  private ContentFragment dAz()
  {
    AppMethodBeat.i(98387);
    ContentFragment localContentFragment = null;
    if (this.xhQ.size() > 0) {
      localContentFragment = (ContentFragment)this.xuv.get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.xhQ.get(this.xtO.getCurrentItem())).id));
    }
    AppMethodBeat.o(98387);
    return localContentFragment;
  }
  
  private static void fC(List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g> paramList)
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
        Iterator localIterator = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)paramList.next()).xhI.iterator();
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
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localx).wVu = j;
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
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsAdNativeLandingPagesUI", "giveIdxForApkBtnInfo, exp=" + paramList.toString());
      AppMethodBeat.o(98377);
      return;
    }
    com.tencent.mm.plugin.sns.data.q.fm(localArrayList);
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
      j.ix("rewarded_canvas_exposure", localJSONObject.toString());
      AppMethodBeat.o(179188);
      return;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsAdNativeLandingPagesUI", "doCanvasExposureReport exp=" + paramString1.toString());
      AppMethodBeat.o(179188);
    }
  }
  
  private List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k> getAllComp()
  {
    AppMethodBeat.i(98380);
    this.xtW = new ArrayList();
    Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.xtO.getAdapter();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)localObject).fragments.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Fragment localFragment = (Fragment)((Iterator)localObject).next();
        this.xtW.addAll(((ContentFragment)localFragment).dwO());
      }
    }
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.fv(this.xtW);
    localObject = this.xtW;
    AppMethodBeat.o(98380);
    return localObject;
  }
  
  private void r(ContentFragment paramContentFragment)
  {
    AppMethodBeat.i(98399);
    if (!dAG()) {
      paramContentFragment.dwT();
    }
    AppMethodBeat.o(98399);
  }
  
  private void refreshView()
  {
    AppMethodBeat.i(98365);
    Object localObject;
    if ((this.bizId == 2) && (!dAv()))
    {
      localObject = (FrameLayout.LayoutParams)this.xtO.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).setMargins(0, 0, 0, com.tencent.mm.ui.ap.eb(this));
      this.xtO.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int i = 2131100892;
    if (!dAv())
    {
      i = getResources().getColor(2131100891);
      if ((this.xhQ == null) || (this.xhQ.size() <= 0) || (bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.xhQ.getFirst()).jbK))) {
        break label313;
      }
      i = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.xhQ.getFirst()).jbK);
    }
    label313:
    for (;;)
    {
      this.xtT.setBackgroundColor(i);
      i = 2131100891;
      localObject = this.ubf.getDrawable();
      if (localObject != null)
      {
        android.support.v4.graphics.drawable.a.a((Drawable)localObject, android.support.v4.content.b.n(this, i));
        this.ubf.setImageDrawable((Drawable)localObject);
      }
      localObject = this.vjH.getDrawable();
      if (localObject != null)
      {
        android.support.v4.graphics.drawable.a.a((Drawable)localObject, android.support.v4.content.b.n(this, i));
        this.vjH.setImageDrawable((Drawable)localObject);
      }
      if ((dAw()) && (!dAx()) && (this.bizId == 2))
      {
        this.vjH.setVisibility(8);
        this.xts.setVisibility(0);
        this.xts.setText(this.xty);
        this.xts.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(98361);
            SnsAdNativeLandingPagesUI.this.D(SnsAdNativeLandingPagesUI.this, SnsAdNativeLandingPagesUI.y(SnsAdNativeLandingPagesUI.this), SnsAdNativeLandingPagesUI.z(SnsAdNativeLandingPagesUI.this));
            AppMethodBeat.o(98361);
          }
        });
        AppMethodBeat.o(98365);
        return;
      }
      if (dAt())
      {
        this.vjH.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(98327);
            paramAnonymousView = new e(SnsAdNativeLandingPagesUI.this, 1, false);
            paramAnonymousView.HrX = new n.c()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
              {
                AppMethodBeat.i(98325);
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
                  AppMethodBeat.o(98325);
                  return;
                }
              }
            };
            paramAnonymousView.kBp = true;
            paramAnonymousView.HrY = new n.d()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(98326);
                al.aB(SnsAdNativeLandingPagesUI.this);
                if (paramAnonymous2MenuItem != null) {
                  switch (paramAnonymous2MenuItem.getItemId())
                  {
                  }
                }
                for (;;)
                {
                  AppMethodBeat.o(98326);
                  return;
                  SnsAdNativeLandingPagesUI.E(SnsAdNativeLandingPagesUI.this);
                  AppMethodBeat.o(98326);
                  return;
                  SnsAdNativeLandingPagesUI.F(SnsAdNativeLandingPagesUI.this);
                  AppMethodBeat.o(98326);
                  return;
                  SnsAdNativeLandingPagesUI.G(SnsAdNativeLandingPagesUI.this);
                  AppMethodBeat.o(98326);
                  return;
                  SnsAdNativeLandingPagesUI.this.D(SnsAdNativeLandingPagesUI.this, SnsAdNativeLandingPagesUI.y(SnsAdNativeLandingPagesUI.this), SnsAdNativeLandingPagesUI.z(SnsAdNativeLandingPagesUI.this));
                }
              }
            };
            SnsAdNativeLandingPagesUI.this.hideVKB();
            paramAnonymousView.csG();
            AppMethodBeat.o(98327);
          }
        });
        AppMethodBeat.o(98365);
        return;
      }
      this.vjH.setVisibility(8);
      AppMethodBeat.o(98365);
      return;
    }
  }
  
  private void report()
  {
    AppMethodBeat.i(98368);
    Object localObject2 = getAllComp();
    Object localObject1 = this.xub.values().iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((List)localObject2).addAll(((SnsAdLandingPageFloatView)((Iterator)localObject1).next()).getAllComp());
    }
    if (this.xuc != null)
    {
      ((List)localObject2).add(this.xuc);
      localObject1 = this.xuc.dvP();
      if (localObject1 != null)
      {
        this.xuc.dvO();
        ((List)localObject2).add(localObject1);
      }
    }
    this.dsf += System.currentTimeMillis() - this.startTime;
    this.xtF.xil = ((int)this.dsf);
    this.xtF.xik = ((List)localObject2).size();
    localObject1 = this.xtF;
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k localk = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k)((Iterator)localObject2).next();
      if (!localk.dwb().wWN)
      {
        JSONObject localJSONObject = new JSONObject();
        if ((!localk.C(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject1).xio)) && (localk.aG(localJSONObject))) {
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject1).xio.put(localJSONObject);
        }
      }
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "landingPage report json %s", new Object[] { this.xtF.xio });
    localObject1 = this.xtF.dxq();
    if (this.bizId == 2)
    {
      AdLandingPagesProxy.getInstance().doCgiReportCanvasBrowseInfo(15041, (String)localObject1);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "post cgi stat 15041 data: ".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(98368);
      return;
    }
    if (AdLandingPagesProxy.getInstance().isRecExpAd(this.xtF.dpC))
    {
      com.tencent.mm.plugin.report.service.h.vKh.kvStat(14650, (String)localObject1);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 14650 data: ".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(98368);
      return;
    }
    com.tencent.mm.plugin.report.service.h.vKh.kvStat(13387, (String)localObject1);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 13387 data: ".concat(String.valueOf(localObject1)));
    AppMethodBeat.o(98368);
  }
  
  private void tl(long paramLong)
  {
    AppMethodBeat.i(98401);
    if (this.xuc != null)
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsAdNativeLandingPagesUI", "showFloatBarView");
      this.xuc.sU(paramLong);
      ContentFragment localContentFragment = dAz();
      if (localContentFragment != null) {
        localContentFragment.dwU();
      }
    }
    AppMethodBeat.o(98401);
  }
  
  private void v(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(98375);
    String str = (String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.iconUrl");
    if (TextUtils.isEmpty(str))
    {
      this.xeP = null;
      AppMethodBeat.o(98375);
      return;
    }
    if (this.xeP == null) {
      this.xeP = new ak();
    }
    this.xeP.iconUrl = str;
    int k = bt.aGh((String)paramMap.get(paramString + ".adCanvasInfo.sizeType"));
    int i = bt.aGh((String)paramMap.get(paramString + ".adCanvasInfo.basicRootFontSize"));
    int j = bt.aGh((String)paramMap.get(paramString + ".adCanvasInfo.basicWidth"));
    if ((i == 0) && (k == 1)) {
      i = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.xhO;
    }
    for (;;)
    {
      if ((j == 0) && (k == 1)) {
        j = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.xhN;
      }
      for (;;)
      {
        this.xeP.paddingBottom = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(bt.aGj((String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.paddingBottom")), k, j, i);
        this.xeP.width = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(bt.aGj((String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.layoutWidth")), k, j, i);
        this.xeP.height = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(bt.aGj((String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.layoutHeight")), k, j, i);
        AppMethodBeat.o(98375);
        return;
      }
    }
  }
  
  public final void D(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(98396);
    Intent localIntent = new Intent();
    localIntent.putExtra("sns_landig_pages_from_source", 14);
    int i;
    String str2;
    String str1;
    JSONObject localJSONObject;
    if (this.wXj == 0)
    {
      i = this.dep;
      localIntent.putExtra("sns_landig_pages_origin_from_source", i);
      localIntent.putExtra("sns_landing_pages_canvasid", paramString1);
      localIntent.putExtra("sns_landing_pages_canvas_ext", paramString2);
      localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
      localIntent.putExtra("sns_landing_pages_no_store", 1);
      str2 = ((Activity)paramContext).getIntent().getStringExtra("sns_landing_pages_sessionId");
      paramString2 = ((Activity)paramContext).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
      if (!bt.isNullOrNil(str2))
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
        if (bt.isNullOrNil(paramString2)) {
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
      com.tencent.mm.bs.d.b(paramContext, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
      AppMethodBeat.o(98396);
      return;
      i = this.wXj;
      break;
      paramString1 = "";
    }
  }
  
  public final void a(final x paramx, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, final boolean paramBoolean3)
  {
    AppMethodBeat.i(98395);
    if ((this.xuy != null) && (!paramBoolean3))
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SnsAdNativeLandingPagesUI", "bottom sheet appear several times");
      this.xuy.bfo();
      if (this.xuz != null)
      {
        this.xuz.dismiss();
        this.xuz = null;
      }
      AppMethodBeat.o(98395);
      return;
    }
    AdLandingPagesProxy.e local17 = new AdLandingPagesProxy.e()
    {
      public final void bf(Object paramAnonymousObject) {}
      
      public final void h(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(187648);
        SnsAdNativeLandingPagesUI.this.qj(false);
        if (paramBoolean3)
        {
          if (SnsAdNativeLandingPagesUI.S(SnsAdNativeLandingPagesUI.this) != null) {
            SnsAdNativeLandingPagesUI.S(SnsAdNativeLandingPagesUI.this).bfo();
          }
          if (SnsAdNativeLandingPagesUI.T(SnsAdNativeLandingPagesUI.this) != null)
          {
            SnsAdNativeLandingPagesUI.T(SnsAdNativeLandingPagesUI.this).dismiss();
            SnsAdNativeLandingPagesUI.U(SnsAdNativeLandingPagesUI.this);
          }
        }
        AppMethodBeat.o(187648);
      }
    };
    AppCompatActivity localAppCompatActivity;
    LinearLayout localLinearLayout;
    if (!paramBoolean3)
    {
      localAppCompatActivity = getContext();
      localLinearLayout = new LinearLayout(getContext());
      if (bt.isNullOrNil(paramx.wWJ)) {
        break label223;
      }
    }
    label223:
    for (int i = Color.parseColor(paramx.wWJ);; i = -1)
    {
      paramx = as.a(localAppCompatActivity, paramx, localLinearLayout, i);
      this.xuy = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l(getContext(), paramx, paramString1, paramString2, paramString3, paramBoolean1, paramBoolean2);
      paramx = paramx.getView();
      this.xuy.xal = new l.a()
      {
        private void onRemove()
        {
          AppMethodBeat.i(187651);
          if ((paramx != null) && (paramx.getParent() != null)) {
            ((ViewGroup)paramx.getParent()).removeView(paramx);
          }
          SnsAdNativeLandingPagesUI.V(SnsAdNativeLandingPagesUI.this);
          AppMethodBeat.o(187651);
        }
        
        public final void dwj()
        {
          AppMethodBeat.i(187649);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "onDismiss");
          onRemove();
          AppMethodBeat.o(187649);
        }
        
        public final void dwk()
        {
          AppMethodBeat.i(187650);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "onCancel");
          onRemove();
          AppMethodBeat.o(187650);
        }
      };
      this.xuy.csG();
      if (!bt.isNullOrNil(paramString1))
      {
        AdLandingPagesProxy.getInstance().doFavOfficialItemScene(paramString1, local17);
        if (paramBoolean3) {
          this.xuz = com.tencent.mm.ui.base.h.b(this, getString(2131763886), false, null);
        }
      }
      AppMethodBeat.o(98395);
      return;
    }
  }
  
  public final void bKT()
  {
    AppMethodBeat.i(98384);
    Object localObject;
    try
    {
      Iterator localIterator1 = this.xub.values().iterator();
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
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.SnsAdNativeLandingPagesUI", localException, "play exit animation error", new Object[0]);
      finish();
      AppMethodBeat.o(98384);
      return;
    }
    dAl();
    report();
    this.xtH = true;
    this.xtT.setVisibility(8);
    if (!this.xtu)
    {
      finish();
      AppMethodBeat.o(98384);
      return;
    }
    if (this.qFd)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "is playing animation");
      AppMethodBeat.o(98384);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "run exit animation, %s", new Object[] { Boolean.valueOf(this.xtu) });
    this.qFd = true;
    if (isSupportNavigationSwipeBack()) {
      getSwipeBackLayout().setEnableGesture(false);
    }
    Iterator localIterator2 = dAz().dwO().iterator();
    while (localIterator2.hasNext())
    {
      localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k)localIterator2.next();
      if ((localObject instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a))
      {
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject).dvw();
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k)localObject).dwg();
      }
    }
    aq.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187640);
        SnsAdNativeLandingPagesUI.Q(SnsAdNativeLandingPagesUI.this);
        AppMethodBeat.o(187640);
      }
    }, 30L);
    AppMethodBeat.o(98384);
  }
  
  public boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  public final void dAD()
  {
    AppMethodBeat.i(187654);
    try
    {
      boolean bool = dAE();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "jumpNextPage, hasNextPage=".concat(String.valueOf(bool)));
      if (bool) {
        this.xtO.setCurrentItem$2563266(this.xtO.getCurrentItem() + 1);
      }
      AppMethodBeat.o(187654);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsAdNativeLandingPagesUI", "jumpNextPage exp:" + localException.toString());
      AppMethodBeat.o(187654);
    }
  }
  
  public final boolean dAE()
  {
    AppMethodBeat.i(98397);
    try
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.xtO.getAdapter();
      int i = this.xtO.getCurrentItem();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "hasNextPage, curPage=" + i + ", pageCount=" + localb.getCount());
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
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsAdNativeLandingPagesUI", "hasNextPage exp:" + localException.toString());
      AppMethodBeat.o(98397);
    }
    return true;
  }
  
  public final boolean dAG()
  {
    AppMethodBeat.i(98400);
    if (this.xuc != null)
    {
      boolean bool = this.xuc.isShowing();
      AppMethodBeat.o(98400);
      return bool;
    }
    AppMethodBeat.o(98400);
    return false;
  }
  
  public final com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad dwi()
  {
    AppMethodBeat.i(187653);
    if (this.xua == null) {
      this.xua = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad();
    }
    Object localObject1 = this.xua;
    int i;
    if (this.wXj == 0) {
      i = this.dep;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)localObject1).wXj = i;
      this.xua.dep = this.dep;
      this.xua.wXk = this.xtE;
      this.xua.dvK = this.dvK;
      this.xua.wXl = this.wXl;
      this.xua.uin = this.uin;
      this.xua.bizId = this.bizId;
      this.xua.wSi = this.wSi;
      this.xua.iYE = this.iYE;
      localObject1 = this.xua;
      Object localObject2 = this.wXp;
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)localObject1).wXp.putAll((Map)localObject2);
      localObject2 = this.xua;
      label182:
      boolean bool;
      if (this.xtF != null)
      {
        localObject1 = this.xtF.jyu;
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)localObject2).jyu = ((String)localObject1);
        localObject1 = this.xua;
        if (this.xtq == null) {
          break label393;
        }
        bool = true;
        label204:
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)localObject1).wXn = bool;
      }
      try
      {
        localObject2 = this.xua;
        if (bt.isNullOrNil(this.dpC)) {
          if (this.xtF != null)
          {
            localObject1 = String.valueOf(j.anz(this.xtF.dpC));
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)localObject2).dpC = ((String)localObject1);
            if (!bt.T(new String[] { this.dAM, this.wXo }))
            {
              this.xua.dAM = this.dAM;
              this.xua.wXo = this.wXo;
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
            localObject1 = (String)((Map)localObject1).get("." + this.xtx + ".adExtInfo");
            this.xua.wBR = com.tencent.mm.plugin.sns.data.h.any((String)localObject1);
            localObject1 = this.xua;
            AppMethodBeat.o(187653);
            return localObject1;
            i = this.wXj;
            break;
            localObject1 = "";
            break label182;
            label393:
            bool = false;
            break label204;
            localObject1 = "";
            continue;
            long l = j.anz(this.dpC);
            localObject1 = String.valueOf(l);
          }
          localThrowable1 = localThrowable1;
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsAdNativeLandingPagesUI", localThrowable1.toString());
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsAdNativeLandingPagesUI", "there is something wrong in set ad ext info");
          }
        }
      }
    }
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
    this.xtS = ((FrameLayout)findViewById(2131304239));
    this.xtU = findViewById(2131298752);
    this.xtO = ((AdlandingDummyViewPager)findViewById(2131306298));
    this.xtT = findViewById(2131302239);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "before, assistActivity");
    if (ai.aF(getContext()))
    {
      this.xtS.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(187635);
          try
          {
            paramAnonymousView = new Rect();
            SnsAdNativeLandingPagesUI.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(paramAnonymousView);
            paramAnonymousInt1 = paramAnonymousView.top;
            paramAnonymousInt2 = ai.aE(SnsAdNativeLandingPagesUI.this);
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsAdNativeLandingPagesUI", "onLayoutChange:".concat(String.valueOf(paramAnonymousInt1)));
            if (paramAnonymousInt1 > 0)
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "rect=" + paramAnonymousView.toString() + ", screenH=" + SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this) + ", cutH=" + paramAnonymousInt2 + ", statusBarH=" + paramAnonymousInt1);
              paramAnonymousView = (FrameLayout.LayoutParams)SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).getLayoutParams();
              paramAnonymousView.height = (SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this) - paramAnonymousInt1);
              paramAnonymousView.topMargin = paramAnonymousInt1;
              SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).setLayoutParams(paramAnonymousView);
              if (paramAnonymousInt1 != paramAnonymousInt2) {
                com.tencent.mm.plugin.sns.data.i.b(com.tencent.mm.plugin.sns.data.i.wAO, "", paramAnonymousInt2, paramAnonymousInt1, SnsAdNativeLandingPagesUI.M(SnsAdNativeLandingPagesUI.this) + "|" + SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this));
              }
              SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).removeOnLayoutChangeListener(this);
            }
            AppMethodBeat.o(187635);
            return;
          }
          catch (Throwable paramAnonymousView)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsAdNativeLandingPagesUI", "onLayoutChange error:" + paramAnonymousView.toString());
            SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).removeOnLayoutChangeListener(this);
            AppMethodBeat.o(187635);
          }
        }
      });
      getController().setActionbarColor(getResources().getColor(2131099873));
      aq.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187636);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "hasCutOut, assistActivity");
          com.tencent.mm.ui.b.a(SnsAdNativeLandingPagesUI.this, true, SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this), SnsAdNativeLandingPagesUI.this.xuw);
          AppMethodBeat.o(187636);
        }
      }, 1500L);
    }
    for (;;)
    {
      this.qdk = ((ImageView)findViewById(2131300336));
      this.xtr = ((ImageView)findViewById(2131296672));
      this.ubf = ((ImageView)findViewById(2131304901));
      this.ubf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(187637);
          if (SnsAdNativeLandingPagesUI.this.keyboardState() == 1) {
            SnsAdNativeLandingPagesUI.this.hideVKB();
          }
          SnsAdNativeLandingPagesUI.this.bKT();
          AppMethodBeat.o(187637);
        }
      });
      this.vjH = ((ImageView)findViewById(2131304918));
      this.xts = ((TextView)findViewById(2131304919));
      this.xtB = ((ImageView)findViewById(2131305019));
      if (this.xtu)
      {
        this.xtS.setAlpha(0.0F);
        this.qdk.setAlpha(0.0F);
        com.tencent.mm.ui.base.b.a(this, null);
      }
      AppMethodBeat.o(98381);
      return;
      aq.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98336);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "noCutOut, assistActivity");
          com.tencent.mm.ui.b.a(SnsAdNativeLandingPagesUI.this, false, SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this), SnsAdNativeLandingPagesUI.this.xuw);
          AppMethodBeat.o(98336);
        }
      }, 1500L);
    }
  }
  
  public final void j(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(98402);
    if (this.xuc != null)
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsAdNativeLandingPagesUI", "hideFloatBarView");
      this.xuc.i(paramBoolean, paramLong);
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
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "share to timeLine success");
        str = bt.nullAsNil(this.dvK);
        localObject3 = bt.nullAsNil(this.xtF.jyu);
      }
    }
    for (;;)
    {
      try
      {
        str = com.tencent.mm.plugin.sns.b.b.t("3", "", str, (String)localObject3);
        com.tencent.mm.sdk.platformtools.ad.i("AntiCheatingReportUtils", "reportScreenShotParams = ".concat(String.valueOf(str)));
        com.tencent.mm.plugin.report.service.h.vKh.kvStat(19214, str);
        com.tencent.mm.ui.base.h.cf(getContext(), getContext().getString(2131755894));
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        AppMethodBeat.o(98392);
        return;
      }
      catch (Throwable localThrowable1)
      {
        com.tencent.mm.sdk.platformtools.ad.e("AntiCheatingReportUtils", localThrowable1.toString());
        continue;
      }
      int i;
      if (paramInt1 == 2)
      {
        if (paramIntent.getBooleanExtra("kfavorite", false))
        {
          i = AdLandingPagesProxy.getInstance().doFav(paramIntent, 42);
          ((com.tencent.mm.plugin.fav.a.v)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fav.a.v.class)).a(i, this, this.rPQ);
        }
      }
      else
      {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k localk;
        int j;
        int k;
        if (paramInt1 == com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad.xcY)
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
            } while (!localk.dwe().equals(localObject1));
            localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad)localk;
            i = paramIntent.getIntExtra("KStreamVideoPlayCount", 0);
            j = paramIntent.getIntExtra("KStreamVideoPlayCompleteCount", 0);
            k = paramIntent.getIntExtra("KStreamVideoTotalPlayTimeInMs", 0);
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad)localObject1).wys = (i + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad)localObject1).wys);
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad)localObject1).wyt += j;
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad)localObject1).wyu += k;
          }
          catch (Exception localException) {}
        }
        else
        {
          Object localObject2;
          if (paramInt1 == 3)
          {
            localObject2 = new tb();
            ((tb)localObject2).dyE.BX = 1;
            ((tb)localObject2).dyE.requestCode = paramInt1;
            ((tb)localObject2).dyE.bRZ = paramInt2;
            ((tb)localObject2).dyE.doc = paramIntent;
            com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
          }
          else if (paramInt1 == xuk)
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
              } while (!localk.dwe().equals(localObject2));
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
              com.tencent.mm.sdk.platformtools.ad.i("NonFullOrFullVideoType", "videoType = " + i + ", cid = " + (String)localObject2 + ", currPosSec = " + j + ", bNoVoice = " + bool1 + ", isPlaying = " + bool2 + ", clickPlayControlCount = " + k + ", doubleClickCount = " + m + ", clickVoiceControlCount = " + n + ", playCompletedCount = " + i1 + ", playCount = " + i2 + ", playTimeInterval = " + l);
              if (i != 0) {
                break label762;
              }
              ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad)localk).a(j, bool1, bool2, k, m, n, i1, i2, l);
            }
            catch (Throwable localThrowable2)
            {
              com.tencent.mm.sdk.platformtools.ad.e("NonFullOrFullVideoType", localThrowable2.toString());
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
    bKT();
    AppMethodBeat.o(98386);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98363);
    super.onCreate(paramBundle);
    this.startTime = System.currentTimeMillis();
    this.enterTime = System.currentTimeMillis();
    this.xtF.enterTime = this.enterTime;
    al.aB(this);
    Object localObject = al.fU(this);
    this.kvn = localObject[0];
    this.kvo = localObject[1];
    this.xtt = paramBundle;
    this.mController.hideTitleView();
    this.nzW = getIntent().getIntExtra("img_gallery_top", 0);
    if (ai.aF(this))
    {
      int i = ai.aE(this);
      this.nzW -= i;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "hasCutOut, h=" + i + ", thumbTop=" + this.nzW);
    }
    this.nzX = getIntent().getIntExtra("img_gallery_left", 0);
    this.nzY = getIntent().getIntExtra("img_gallery_width", 0);
    this.nzZ = getIntent().getIntExtra("img_gallery_height", 0);
    getWindow().addFlags(128);
    this.isVisible = false;
    this.xug = false;
    this.xuh = false;
    this.xui = false;
    if (this.xuj != null) {
      this.xuj.removeCallbacks(this.xut);
    }
    this.dep = getIntent().getIntExtra("sns_landig_pages_from_source", 0);
    this.wXj = getIntent().getIntExtra("sns_landig_pages_origin_from_source", 0);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "source=" + this.dep + ", originScene=" + this.wXj);
    this.xtw = getIntent().getStringExtra("sns_landing_pages_xml");
    paramBundle = getIntent().getStringExtra("sns_landing_pages_too_large_xml_path");
    if ((bt.isNullOrNil(this.xtw)) && (!bt.isNullOrNil(paramBundle))) {
      this.xtw = al.apB(paramBundle);
    }
    if (bt.isNullOrNil(this.xtw))
    {
      finish();
      initView();
      if (AdLandingPagesProxy.getInstance().isConnected()) {
        break label1055;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "isConnected==false");
      AdLandingPagesProxy.getInstance().connect(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98360);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "after Connected");
          SnsAdNativeLandingPagesUI.x(SnsAdNativeLandingPagesUI.this);
          AppMethodBeat.o(98360);
        }
      });
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.ESL.c(this.xus);
      try
      {
        registerReceiver(this.xux, new IntentFilter("android.intent.action.SCREEN_ON"));
        AppMethodBeat.o(98363);
        return;
      }
      catch (Exception paramBundle)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsAdNativeLandingPagesUI", "registerReceiver, exp=" + paramBundle.toString());
        AppMethodBeat.o(98363);
      }
      this.xtw = this.xtw.replaceAll("</*RecXml[\\s|\\S]*?>", "");
      this.xtF.wMY = getIntent().getStringExtra("sns_landing_pages_expid");
      this.xtx = getIntent().getStringExtra("sns_landing_pages_xml_prefix");
      this.dpC = getIntent().getStringExtra("sns_landing_pages_share_sns_id");
      this.xtD = getIntent().getStringExtra("sns_landing_pages_rawSnsId");
      this.dvK = getIntent().getStringExtra("sns_landing_pages_ux_info");
      this.wSi = getIntent().getStringExtra("sns_landing_pages_aid");
      this.iYE = getIntent().getStringExtra("sns_landing_pages_traceid");
      paramBundle = getIntent().getStringExtra("sns_landing_pages_search_extra");
      localObject = this.xtF;
      if (!TextUtils.isEmpty(paramBundle))
      {
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra.length() > 0) {
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra += "&";
        }
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra = (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra + "searchextra=" + URLEncoder.encode(paramBundle));
      }
      paramBundle = getIntent().getStringExtra("sns_landing_pages_extra");
      localObject = this.xtF;
      if (!TextUtils.isEmpty(paramBundle)) {
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra = (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra + "&extra1=" + URLEncoder.encode(paramBundle));
      }
      this.xtE = getIntent().getBooleanExtra("sns_landing_is_native_sight_ad", false);
      this.wTf = getIntent().getIntExtra("sns_landing_pages_rec_src", 0);
      this.xtI = getIntent().getIntExtra("sns_landing_pages_from_outer_index", 0);
      this.jyv = getIntent().getStringExtra("sns_landing_pages_ad_info");
      this.xtu = getIntent().getBooleanExtra("sns_landing_pages_need_enter_and_exit_animation", false);
      this.xtv = getIntent().getBooleanExtra("sns_landing_pages_is_normal_ad_animation", false);
      if (this.xtu) {
        this.xtF.fOf = 0;
      }
      for (this.xtF.fjS = 0;; this.xtF.fjS = 1)
      {
        this.xtF.oIw = this.dep;
        this.xtF.xig = 0;
        this.xtF.xih = 0;
        this.xtF.xii = 1;
        this.xtF.xij = 0;
        this.xtF.wXj = this.wXj;
        if ((this.xtx == null) || ("".equals(this.xtw))) {
          this.xtx = "adxml";
        }
        if ((!bt.isNullOrNil(this.xtw)) && (!bt.isNullOrNil(this.xtx))) {
          break label986;
        }
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsAdNativeLandingPagesUI", "landingPagesXml is " + this.xtw + ",landingPagesXmlPrex is " + this.xtx);
        break;
        this.xtF.fOf = 1;
      }
      label986:
      this.values = bw.K(this.xtw, this.xtx);
      this.xtF.jyu = bt.by((String)this.values.get("." + this.xtx + ".adCanvasInfo.id"), "");
      break;
      label1055:
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "isConnected==true");
      dAk();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98366);
    getWindow().clearFlags(128);
    if (this.xuj != null) {
      this.xuj.removeCallbacks(this.xut);
    }
    if (this.aJQ)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "the SnsAdNativeLadingPagesUI is destroy, bHandleExit=" + this.xtH);
      if (!this.xtH)
      {
        dAl();
        report();
      }
    }
    for (;;)
    {
      this.xub.clear();
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.xtO.getAdapter();
      if (localb != null) {
        localb.fragments.clear();
      }
      try
      {
        unregisterReceiver(this.xux);
        com.tencent.mm.sdk.b.a.ESL.d(this.xus);
        AdLandingPagesProxy.getInstance().clearCallback();
        super.onDestroy();
        AppMethodBeat.o(98366);
        return;
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsAdNativeLandingPagesUI", "onDestroy, isConnected=false");
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsAdNativeLandingPagesUI", "unregisterReceiver, exp=" + localException.toString());
        }
      }
    }
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(98393);
    super.onKeyboardStateChanged();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "onKeyboardStateChanged, state=" + keyboardState());
    if (this.xtO != null) {
      this.xtO.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187646);
          if (SnsAdNativeLandingPagesUI.this.keyboardState() != 1) {
            al.aB(SnsAdNativeLandingPagesUI.this);
          }
          if (!SnsAdNativeLandingPagesUI.R(SnsAdNativeLandingPagesUI.this))
          {
            new ArrayList();
            Iterator localIterator = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getAdapter()).fragments.iterator();
            while (localIterator.hasNext())
            {
              ContentFragment localContentFragment = (ContentFragment)localIterator.next();
              SnsAdNativeLandingPagesUI.this.keyboardState();
              localContentFragment.dwP();
            }
          }
          AppMethodBeat.o(187646);
        }
      }, 500L);
    }
    AppMethodBeat.o(98393);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(98372);
    super.onPause();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "onPause");
    this.xtZ = true;
    if (this.aJQ) {
      this.dsf += System.currentTimeMillis() - this.startTime;
    }
    try
    {
      bh.a(this, null);
      this.xtG = false;
      if (dAq())
      {
        Iterator localIterator = this.xub.values().iterator();
        while (localIterator.hasNext()) {
          ((SnsAdLandingPageFloatView)localIterator.next()).onPause();
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", localThrowable.toString());
      }
      AdlandingDummyViewPager localAdlandingDummyViewPager = this.xtO;
      ViewPager.OnPageChangeListener localOnPageChangeListener = this.xup;
      localAdlandingDummyViewPager.xeD.remove(localOnPageChangeListener);
      android.support.v4.content.d.T(this).unregisterReceiver(this.xum);
      android.support.v4.content.d.T(this).unregisterReceiver(this.xun);
      com.tencent.mm.sdk.b.a.ESL.d(this.xur);
      if (this.xuy != null) {
        this.xuy.bfo();
      }
      if ((this.xuc != null) && (this.xuc.isShowing())) {
        this.xuc.dvA();
      }
      AppMethodBeat.o(98372);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98371);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "onResume");
    super.onResume();
    try
    {
      if (!this.xtG)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "onResume callback");
        bh.a(this, this.xuu);
        this.xtG = true;
      }
      al.aB(this);
      if (dAq())
      {
        i = this.xtS.getChildCount() - 1;
        if (i >= 0)
        {
          Object localObject = this.xtS.getChildAt(i);
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
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", localThrowable.toString());
        continue;
        i -= 1;
        continue;
        localAdlandingDummyViewPager = null;
      }
      this.xtZ = false;
      AdlandingDummyViewPager localAdlandingDummyViewPager = this.xtO;
      ViewPager.OnPageChangeListener localOnPageChangeListener = this.xup;
      localAdlandingDummyViewPager.xeD.add(localOnPageChangeListener);
      android.support.v4.content.d.T(this).a(this.xum, new IntentFilter("com.tencent.mm.adlanding.video_progressbar_change"));
      android.support.v4.content.d.T(this).a(this.xun, new IntentFilter("com.tencent.mm.adlanding.set_uioption"));
      if (this.aJQ) {
        this.startTime = System.currentTimeMillis();
      }
      com.tencent.mm.sdk.b.a.ESL.c(this.xur);
      if (this.xtJ) {
        qj(false);
      }
      if ((this.xuc != null) && (this.xuc.isShowing())) {
        this.xuc.dvz();
      }
      AppMethodBeat.o(98371);
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(179183);
    super.onStart();
    this.isVisible = true;
    if (this.aJQ) {
      try
      {
        if ((!bt.T(new String[] { this.dAM, this.wXo })) && (!this.xuh))
        {
          if (this.xui)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "execute mValidExposure onStart immediately");
            dAp();
            AppMethodBeat.o(179183);
            return;
          }
          if (this.xuj != null)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "execute mValidExposureRunnable onStart");
            this.xuj.removeCallbacks(this.xut);
            this.xuj.postDelayed(this.xut, 1000L);
          }
        }
        AppMethodBeat.o(179183);
        return;
      }
      catch (Throwable localThrowable)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsAdNativeLandingPagesUI", localThrowable.toString());
      }
    }
    AppMethodBeat.o(179183);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(179184);
    super.onStop();
    this.isVisible = false;
    if (this.xuj != null) {
      this.xuj.removeCallbacks(this.xut);
    }
    AppMethodBeat.o(179184);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(98373);
    this.xtF.fjS = 2;
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k localk = this.xtF;
    localk.xij += 1;
    super.onSwipeBack();
    try
    {
      hideVKB();
      AppMethodBeat.o(98373);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsAdNativeLandingPagesUI", "onSwipeBack hideVKB exp=" + localException.toString());
      AppMethodBeat.o(98373);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(187652);
    super.onWindowFocusChanged(paramBoolean);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean) {}
    try
    {
      bh.a(this, null);
      this.xtG = false;
      AppMethodBeat.at(this, paramBoolean);
      AppMethodBeat.o(187652);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", localThrowable.toString());
      AppMethodBeat.at(this, paramBoolean);
      AppMethodBeat.o(187652);
    }
    if (!this.xtG)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "onWindowFocusChanged callback");
      bh.a(this, this.xuu);
      this.xtG = true;
    }
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(187652);
    return;
  }
  
  public final void qj(boolean paramBoolean)
  {
    AppMethodBeat.i(98394);
    if ((paramBoolean) && (this.bizId == 1)) {
      AdLandingPagesProxy.getInstance().doDynamicUpdateScene(this.xtK, this.xtL, this.xtM, this.xuq);
    }
    if ((this.bizId == 2) && (!bt.isNullOrNil(this.xtN))) {
      AdLandingPagesProxy.getInstance().doSearchDynamicUpdateScene(this.xtN, this.xuq);
    }
    this.xtJ = true;
    AppMethodBeat.o(98394);
  }
  
  public final void sW(long paramLong)
  {
    AppMethodBeat.i(98403);
    if ((this.xuc == null) || (this.xtq == null))
    {
      AppMethodBeat.o(98403);
      return;
    }
    ContentFragment localContentFragment = dAz();
    if (localContentFragment == null)
    {
      AppMethodBeat.o(98403);
      return;
    }
    boolean bool1 = dAH();
    boolean bool2 = localContentFragment.dwR();
    boolean bool3 = this.xue;
    boolean bool4 = localContentFragment.xeQ;
    boolean bool5 = localContentFragment.ibO;
    boolean bool6 = localContentFragment.dwQ();
    boolean bool7 = this.xud;
    boolean bool8 = localContentFragment.dwX();
    boolean bool9 = localContentFragment.dwW();
    if ((bool4) && (bool8)) {
      this.xuf = true;
    }
    if (!bool4) {
      this.xuf = true;
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsAdNativeLandingPagesUI", "toggleFloatBarView, isSourceAllow=" + bool1 + ", isForbid=" + bool2 + ", isKeybordShow=" + bool3 + ", isFirstPage=" + bool4 + ", isLastPage=" + bool5 + ", isCoverVideo=" + bool6 + ", isVideoCtrlBarShow=" + bool7 + ", isTopAppearOk=" + bool8 + ", isBottomAppearOk=" + bool9 + ", IsTopAppearChecked=" + this.xuf);
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
    if ((bool4) && (!bool8) && (!this.xuf))
    {
      AppMethodBeat.o(98403);
      return;
    }
    tl(paramLong);
    AppMethodBeat.o(98403);
  }
  
  final class a
  {
    public String oYb = "";
    public String rUO = "";
    public String wUI = "";
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI
 * JD-Core Version:    0.7.0.1
 */