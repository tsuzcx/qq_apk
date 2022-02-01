package com.tencent.mm.plugin.sns.ui;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.ViewPager.f;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
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
import com.tencent.mm.api.aa;
import com.tencent.mm.g.a.pb;
import com.tencent.mm.g.a.pb.a;
import com.tencent.mm.g.a.uz;
import com.tencent.mm.g.a.vc;
import com.tencent.mm.g.a.vf;
import com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.FloatJumpCompHelper;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistCoverView;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView.2;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView.3;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView.4;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView.a;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.model.AdlandingRemoteServiceConnectedReceiver;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.b;
import com.tencent.mm.plugin.sns.storage.ADXml.k;
import com.tencent.mm.plugin.sns.storage.ADXml.l;
import com.tencent.mm.plugin.sns.storage.ADXml.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aq;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aj;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdlandingDummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.helper.FloatWebViewHelper;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.bq;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.eco;
import com.tencent.mm.protocal.protobuf.ecp;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.b.a;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
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
  private ImageView BQk;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah DJT;
  private int DZU;
  private String DZW;
  private String DZY;
  public long DZZ;
  private SnsInfo DsC;
  private Map<String, String> Eaa;
  private aq Eim;
  public LinkedList<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g> Elq;
  private String ExA;
  private String ExB;
  private String ExC;
  private String ExD;
  private ImageView ExE;
  String ExF;
  String ExG;
  private boolean ExH;
  com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k ExI;
  private volatile boolean ExJ;
  boolean ExK;
  private int ExL;
  private boolean ExM;
  private String ExN;
  private String ExO;
  private String ExP;
  private String ExQ;
  private AdlandingDummyViewPager ExR;
  private int ExS;
  private int ExT;
  private MMHandler ExU;
  private FrameLayout ExV;
  private View ExW;
  private View ExX;
  private boolean ExY;
  private List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m> ExZ;
  public ad Exu;
  private ImageView Exv;
  private TextView Exw;
  private boolean Exx;
  private boolean Exy;
  private String Exz;
  private com.tencent.mm.plugin.sns.ad.landingpage.component.a.b EyA;
  private String EyB;
  private BroadcastReceiver EyC;
  private BroadcastReceiver EyD;
  private final String EyE;
  private ContentFragment.a EyF;
  private ViewPager.OnPageChangeListener EyG;
  private AdLandingPagesProxy.e EyH;
  private IListener<pb> EyI;
  private IListener<uz> EyJ;
  private Runnable EyK;
  private ScreenShotUtil.ScreenShotCallback EyL;
  private Map<Integer, ContentFragment> EyM;
  private boolean EyN;
  public b.a EyO;
  private BroadcastReceiver EyP;
  private n EyQ;
  private com.tencent.mm.ui.base.q EyR;
  public FloatJumpCompHelper EyS;
  private com.tencent.mm.plugin.sns.ui.b.c Eya;
  private com.tencent.mm.plugin.sns.ui.b.e Eyb;
  private com.tencent.mm.plugin.sns.ui.b.d Eyc;
  private volatile boolean Eyd;
  private boolean Eye;
  private Map<String, SnsAdLandingPageFloatView> Eyf;
  private com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.a Eyg;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d Eyh;
  private boolean Eyi;
  public boolean Eyj;
  private boolean Eyk;
  Collection<String> Eyl;
  private volatile boolean Eym;
  private volatile boolean Eyn;
  private volatile boolean Eyo;
  private MMHandler Eyp;
  private String Eyq;
  private FloatWebViewHelper Eyr;
  private com.tencent.mm.ui.widget.a.e Eys;
  public boolean Eyt;
  private TwistRoateCardsView Eyu;
  private ADXml.k Eyv;
  private boolean Eyw;
  private boolean Eyx;
  private boolean Eyy;
  private View Eyz;
  private boolean aMp;
  private String adCanvasExtXml;
  private String adExtInfo;
  private int adType;
  private String aid;
  private int bizId;
  public String dRS;
  private long dUy;
  private long enterTime;
  public boolean forbiddenCustomAnimation;
  private ImageView hTd;
  private volatile boolean isVisible;
  private ImageView jUG;
  private String kZe;
  private String lAP;
  private int mEX;
  private int mEY;
  String msN;
  private boolean preloadWeAppPkg;
  private int qaF;
  private int qaG;
  private int qaH;
  private int qaI;
  String rCq;
  private int recSrc;
  Bundle savedInstanceState;
  private int source;
  private long startTime;
  private String uin;
  private String uxInfo;
  private Map<String, String> values;
  private String viewId;
  String xDQ;
  protected a.b xxK;
  
  public SnsAdNativeLandingPagesUI()
  {
    AppMethodBeat.i(98362);
    this.Elq = new LinkedList();
    this.qaF = 0;
    this.qaG = 0;
    this.qaH = 0;
    this.qaI = 0;
    this.Exx = false;
    this.Exy = false;
    this.ExH = false;
    this.dUy = 0L;
    this.enterTime = 0L;
    this.Eaa = new HashMap();
    this.ExI = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k();
    this.ExJ = false;
    this.ExK = false;
    this.ExL = 0;
    this.ExM = false;
    this.ExU = new MMHandler();
    this.ExY = true;
    this.aMp = false;
    this.Eyf = new HashMap();
    this.Eyi = false;
    this.Eyj = false;
    this.Eyk = false;
    this.Eyl = new HashSet();
    this.isVisible = false;
    this.Eym = false;
    this.Eyn = false;
    this.Eyo = false;
    this.Eyp = new MMHandler();
    this.Eyq = "";
    this.adExtInfo = "";
    this.Eyt = false;
    this.forbiddenCustomAnimation = false;
    this.Eyw = false;
    this.Eyx = false;
    this.Eyy = false;
    this.EyB = "";
    this.preloadWeAppPkg = false;
    this.EyC = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        boolean bool = true;
        AppMethodBeat.i(98324);
        int i = com.tencent.mm.plugin.sns.ad.i.g.getIntExtra(paramAnonymousIntent, "show", 0);
        if ((SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this) == null) || (!(SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getAdapter() instanceof android.support.v4.app.i)))
        {
          com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.SnsAdNativeLandingPagesUI", "videoProgressbarStatusChangeReceiver called ,but the viewpager or adapter is null!!");
          AppMethodBeat.o(98324);
          return;
        }
        paramAnonymousContext = (android.support.v4.app.i)SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getAdapter();
        int j = SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getCurrentItem();
        int k = paramAnonymousContext.getCount();
        if (j >= k)
        {
          com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.SnsAdNativeLandingPagesUI", "videoProgressbarStatusChangeReceiver called ,current index is larger than item count!!!");
          AppMethodBeat.o(98324);
          return;
        }
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SnsAdNativeLandingPagesUI", "recv videoProgressbarStatusChangeReceiver show " + i + "the index is " + j + " the count is " + k);
        paramAnonymousContext = (ContentFragment)paramAnonymousContext.getItem(j);
        if (i == 1) {}
        for (;;)
        {
          SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this, bool);
          SnsAdNativeLandingPagesUI.this.JC(500L);
          paramAnonymousContext.vj(bool);
          AppMethodBeat.o(98324);
          return;
          bool = false;
        }
      }
    };
    this.EyD = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(98343);
        ap.aK(SnsAdNativeLandingPagesUI.this);
        AppMethodBeat.o(98343);
      }
    };
    this.EyE = "huawei nxt-al10|mix 2s";
    this.EyF = new ContentFragment.a()
    {
      public final void q(final ContentFragment paramAnonymousContentFragment)
      {
        AppMethodBeat.i(98351);
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SnsAdNativeLandingPagesUI.launch", "firstPage afterOnCreateView");
        final RecyclerView localRecyclerView = paramAnonymousContentFragment.getRecyclerView();
        if (localRecyclerView != null) {
          localRecyclerView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(98350);
              com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SnsAdNativeLandingPagesUI.launch", "firstPage onPreDraw");
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "onPreDraw %d, %d", new Object[] { Integer.valueOf(SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).getHeight()), Integer.valueOf(SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this)) });
              SnsAdNativeLandingPagesUI.d(SnsAdNativeLandingPagesUI.this);
              if (SnsAdNativeLandingPagesUI.e(SnsAdNativeLandingPagesUI.this))
              {
                if (SnsAdNativeLandingPagesUI.f(SnsAdNativeLandingPagesUI.this))
                {
                  SnsAdNativeLandingPagesUI.g(SnsAdNativeLandingPagesUI.this).setVisibility(8);
                  localObject1 = ObjectAnimator.ofFloat(SnsAdNativeLandingPagesUI.h(SnsAdNativeLandingPagesUI.this), "alpha", new float[] { 0.0F, 1.0F });
                  ((ObjectAnimator)localObject1).setDuration(1000L);
                  ((ObjectAnimator)localObject1).start();
                }
                if (SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this, paramAnonymousContentFragment))
                {
                  localRecyclerView.getViewTreeObserver().removeOnPreDrawListener(this);
                  AppMethodBeat.o(98350);
                  return false;
                }
              }
              Object localObject1 = null;
              Object localObject2 = SnsAdNativeLandingPagesUI.i(SnsAdNativeLandingPagesUI.this);
              int i;
              if (localObject2 != null)
              {
                localObject1 = ((aj)localObject2).fdH();
                if (localObject1 != null)
                {
                  localObject1 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)localObject1).DWL;
                  localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.kw((String)localObject1, "scene_ad_landing");
                  localObject2 = new StringBuilder("onPreDraw, fullscreen, container.size=").append(SnsAdNativeLandingPagesUI.h(SnsAdNativeLandingPagesUI.this).getWidth()).append(", ").append(SnsAdNativeLandingPagesUI.h(SnsAdNativeLandingPagesUI.this).getHeight()).append(", shootImg.w=");
                  if (localObject1 == null) {
                    break label367;
                  }
                  i = ((Bitmap)localObject1).getWidth();
                  label282:
                  localObject2 = ((StringBuilder)localObject2).append(i).append(", shootImg.h=");
                  if (localObject1 == null) {
                    break label372;
                  }
                  i = ((Bitmap)localObject1).getHeight();
                  label302:
                  com.tencent.mm.sdk.platformtools.Log.i("SphereImageView.SnsAdNativeLandingPagesUI", i);
                }
              }
              else
              {
                if (!SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this)) {
                  break label377;
                }
                MMHandlerThread.postToMainThreadDelayed(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(98349);
                    Bitmap localBitmap1 = null;
                    Object localObject;
                    if (this.Eza != null) {
                      localObject = this.Eza;
                    }
                    while (localObject != null)
                    {
                      SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).setAlpha(1.0F);
                      SnsAdNativeLandingPagesUI.l(SnsAdNativeLandingPagesUI.this).setImageBitmap((Bitmap)localObject);
                      SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this, SnsAdNativeLandingPagesUI.23.1.this.opE, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
                      AppMethodBeat.o(98349);
                      return;
                      localObject = localBitmap1;
                      try
                      {
                        if (!SnsAdNativeLandingPagesUI.k(SnsAdNativeLandingPagesUI.this)) {
                          break label180;
                        }
                        localObject = localBitmap1;
                        localBitmap1 = BitmapUtil.getBitmapFromView(SnsAdNativeLandingPagesUI.23.1.this.opE.getChildAt(0));
                        localObject = localBitmap1;
                        SnsAdNativeLandingPagesUI.l(SnsAdNativeLandingPagesUI.this).setScaleType(ImageView.ScaleType.CENTER_CROP);
                        localObject = localBitmap1;
                      }
                      catch (Throwable localThrowable)
                      {
                        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "getBitmapFromView exp=" + localThrowable.toString());
                      }
                      continue;
                      label180:
                      localObject = localThrowable;
                      Bitmap localBitmap2 = BitmapUtil.getBitmapFromView(SnsAdNativeLandingPagesUI.h(SnsAdNativeLandingPagesUI.this));
                      localObject = localBitmap2;
                      SnsAdNativeLandingPagesUI.l(SnsAdNativeLandingPagesUI.this).setScaleType(ImageView.ScaleType.CENTER_CROP);
                      localObject = localBitmap2;
                    }
                    SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).setAlpha(1.0F);
                    AppMethodBeat.o(98349);
                  }
                }, 50L);
              }
              for (;;)
              {
                localRecyclerView.getViewTreeObserver().removeOnPreDrawListener(this);
                AppMethodBeat.o(98350);
                return false;
                localObject1 = "";
                break;
                label367:
                i = 0;
                break label282;
                label372:
                i = 0;
                break label302;
                label377:
                SnsAdNativeLandingPagesUI.m(SnsAdNativeLandingPagesUI.this).setVisibility(0);
                SnsAdNativeLandingPagesUI.this.JC(300L);
              }
            }
          });
        }
        AppMethodBeat.o(98351);
      }
    };
    this.EyG = new ViewPager.f()
    {
      public final void onPageScrollStateChanged(int paramAnonymousInt)
      {
        AppMethodBeat.i(98353);
        super.onPageScrollStateChanged(paramAnonymousInt);
        SnsAdNativeLandingPagesUI.n(SnsAdNativeLandingPagesUI.this).Eiu = paramAnonymousInt;
        Object localObject;
        if (paramAnonymousInt == 1)
        {
          paramAnonymousInt = 0;
          while (paramAnonymousInt < SnsAdNativeLandingPagesUI.this.Elq.size())
          {
            localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)SnsAdNativeLandingPagesUI.this.Elq.get(paramAnonymousInt);
            localObject = (Fragment)SnsAdNativeLandingPagesUI.o(SnsAdNativeLandingPagesUI.this).get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject).id));
            if (localObject != null) {
              ((ContentFragment)localObject).fee();
            }
            paramAnonymousInt += 1;
          }
          ap.hb(SnsAdNativeLandingPagesUI.this.getContext());
          AppMethodBeat.o(98353);
          return;
        }
        if (paramAnonymousInt == 0)
        {
          localObject = (Fragment)SnsAdNativeLandingPagesUI.o(SnsAdNativeLandingPagesUI.this).get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)SnsAdNativeLandingPagesUI.this.Elq.get(SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getCurrentItem())).id));
          if (localObject != null) {
            SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this, (ContentFragment)localObject);
          }
        }
        AppMethodBeat.o(98353);
      }
      
      public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
      {
        AppMethodBeat.i(98352);
        super.onPageScrolled(paramAnonymousInt1, paramAnonymousFloat, paramAnonymousInt2);
        if (SnsAdNativeLandingPagesUI.n(SnsAdNativeLandingPagesUI.this) != null)
        {
          ContentFragment localContentFragment = SnsAdNativeLandingPagesUI.n(SnsAdNativeLandingPagesUI.this);
          if ((localContentFragment.cQp) && (localContentFragment.Eik != null)) {
            localContentFragment.Eik.fdT();
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
        if (i < SnsAdNativeLandingPagesUI.this.Elq.size())
        {
          Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)SnsAdNativeLandingPagesUI.this.Elq.get(i);
          localObject = (Fragment)SnsAdNativeLandingPagesUI.o(SnsAdNativeLandingPagesUI.this).get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject).id));
          if (localObject != null)
          {
            if (i != paramAnonymousInt) {
              break label98;
            }
            SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this, (ContentFragment)localObject);
          }
          for (;;)
          {
            i += 1;
            break;
            label98:
            ((ContentFragment)localObject).fee();
          }
        }
        SnsAdNativeLandingPagesUI.this.JC(300L);
        AppMethodBeat.o(98354);
      }
    };
    this.EyH = new AdLandingPagesProxy.e()
    {
      public final void bn(final Object paramAnonymousObject)
      {
        AppMethodBeat.i(98357);
        SnsAdNativeLandingPagesUI.p(SnsAdNativeLandingPagesUI.this).removeCallbacksAndMessages(null);
        SnsAdNativeLandingPagesUI.p(SnsAdNativeLandingPagesUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98356);
            Object localObject = SnsAdNativeLandingPagesUI.q(SnsAdNativeLandingPagesUI.this);
            SnsAdNativeLandingPagesUI.r(SnsAdNativeLandingPagesUI.this);
            String str = (String)paramAnonymousObject;
            SnsAdNativeLandingPagesUI.s(SnsAdNativeLandingPagesUI.this);
            SnsAdNativeLandingPagesUI.t(SnsAdNativeLandingPagesUI.this);
            localObject = new i.a(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.kF((String)localObject, str), SnsAdNativeLandingPagesUI.r(SnsAdNativeLandingPagesUI.this));
            SnsAdNativeLandingPagesUI.this.Elq = ((i.a)localObject).Elq;
            SnsAdNativeLandingPagesUI.this.Exu = ((i.a)localObject).Elr;
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(98355);
                SnsAdNativeLandingPagesUI.u(SnsAdNativeLandingPagesUI.this);
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
    this.EyI = new IListener()
    {
      private boolean a(pb paramAnonymouspb)
      {
        AppMethodBeat.i(176294);
        Object localObject1;
        SnsAdLandingPageFloatView localSnsAdLandingPageFloatView;
        Object localObject2;
        int i;
        String str1;
        String str2;
        String str3;
        if ((SnsAdNativeLandingPagesUI.n(SnsAdNativeLandingPagesUI.this).Eig.Elj != null) && (SnsAdNativeLandingPagesUI.n(SnsAdNativeLandingPagesUI.this).Eig.Elj.containsKey(paramAnonymouspb.dVd.dVe)) && (!SnsAdNativeLandingPagesUI.v(SnsAdNativeLandingPagesUI.this).containsKey(paramAnonymouspb.dVd.dVe)))
        {
          SnsAdNativeLandingPagesUI.n(SnsAdNativeLandingPagesUI.this).onPause();
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("sns_landing_pages_xml", SnsAdNativeLandingPagesUI.q(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putString("sns_float_component_id", paramAnonymouspb.dVd.dVe);
          ((Bundle)localObject1).putInt("sns_landing_page_index", SnsAdNativeLandingPagesUI.n(SnsAdNativeLandingPagesUI.this).Eig.id);
          ((Bundle)localObject1).putString("sns_landing_page_snsId", SnsAdNativeLandingPagesUI.this.dRS);
          ((Bundle)localObject1).putString("sns_landing_pages_rawSnsId", SnsAdNativeLandingPagesUI.this.ExG);
          ((Bundle)localObject1).putString("sns_landing_pages_ux_info", SnsAdNativeLandingPagesUI.w(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putString("sns_landing_pages_aid", SnsAdNativeLandingPagesUI.s(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putInt("sns_landing_pages_biz_id", SnsAdNativeLandingPagesUI.x(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putString("sns_landing_pages_traceid", SnsAdNativeLandingPagesUI.t(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putInt("sns_landig_pages_from_source", SnsAdNativeLandingPagesUI.y(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putString("sns_landing_pages_xml_prefix", SnsAdNativeLandingPagesUI.r(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putBoolean("sns_landing_is_native_sight_ad", SnsAdNativeLandingPagesUI.z(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putString("sns_landing_pages_canvas_ext", SnsAdNativeLandingPagesUI.A(SnsAdNativeLandingPagesUI.this));
          localSnsAdLandingPageFloatView = new SnsAdLandingPageFloatView(SnsAdNativeLandingPagesUI.this);
          localObject2 = ((Bundle)localObject1).getString("sns_landing_pages_xml");
          localSnsAdLandingPageFloatView.dVe = ((Bundle)localObject1).getString("sns_float_component_id");
          i = ((Bundle)localObject1).getInt("sns_landing_page_index", -1);
          str1 = ((Bundle)localObject1).getString("sns_landing_pages_ux_info");
          str2 = ((Bundle)localObject1).getString("sns_landing_pages_aid");
          str3 = ((Bundle)localObject1).getString("sns_landing_pages_traceid");
          localSnsAdLandingPageFloatView.adCanvasExtXml = ((Bundle)localObject1).getString("sns_landing_pages_canvas_ext");
          if ((!Util.isNullOrNil(new String[] { localObject2, localSnsAdLandingPageFloatView.dVe })) && (i != -1)) {
            break label490;
          }
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdLandingPageFloatView", "invalid landing float page data!");
        }
        for (;;)
        {
          localSnsAdLandingPageFloatView.setBackgroundColor(SnsAdNativeLandingPagesUI.this.getResources().getColor(2131101098));
          SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).addView(localSnsAdLandingPageFloatView, SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).getChildCount() - 1, new FrameLayout.LayoutParams(-1, -1));
          localSnsAdLandingPageFloatView.flb();
          SnsAdNativeLandingPagesUI.n(SnsAdNativeLandingPagesUI.this).fee();
          SnsAdNativeLandingPagesUI.this.k(false, 0L);
          SnsAdNativeLandingPagesUI.v(SnsAdNativeLandingPagesUI.this).put(paramAnonymouspb.dVd.dVe, localSnsAdLandingPageFloatView);
          AppMethodBeat.o(176294);
          return false;
          label490:
          localObject1 = new i.a((String)localObject2, Util.nullAs(((Bundle)localObject1).getString("sns_landing_pages_xml_prefix"), "adxml")).Elq;
          if ((localObject1 != null) && (((LinkedList)localObject1).size() > i))
          {
            localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)((LinkedList)localObject1).get(i);
            localSnsAdLandingPageFloatView.Fem = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g();
            localSnsAdLandingPageFloatView.Fem.lco = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject1).lco;
            localObject2 = (z)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject1).Elj.get(localSnsAdLandingPageFloatView.dVe);
            if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.Zm(((z)localObject2).type))
            {
              localSnsAdLandingPageFloatView.Fel = ((x)localObject2);
              localSnsAdLandingPageFloatView.Fem.Eli.add(localSnsAdLandingPageFloatView.Fel);
              localSnsAdLandingPageFloatView.Fem.Elj.putAll(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject1).Elj);
            }
            localSnsAdLandingPageFloatView.Fem.id = 0;
            localSnsAdLandingPageFloatView.Fem.Elk = true;
          }
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdLandingPageFloatView", "[reportInfo] aid %s,traceId %s,uxInfo %s,adCanvasExtXml %s", new Object[] { str2, str3, str1, localSnsAdLandingPageFloatView.adCanvasExtXml });
          localSnsAdLandingPageFloatView.initView();
        }
      }
    };
    this.EyJ = new IListener() {};
    this.EyK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98336);
        SnsAdNativeLandingPagesUI.N(SnsAdNativeLandingPagesUI.this);
        if ((!SnsAdNativeLandingPagesUI.O(SnsAdNativeLandingPagesUI.this)) && (SnsAdNativeLandingPagesUI.P(SnsAdNativeLandingPagesUI.this))) {
          SnsAdNativeLandingPagesUI.Q(SnsAdNativeLandingPagesUI.this);
        }
        AppMethodBeat.o(98336);
      }
    };
    this.EyL = new ScreenShotUtil.ScreenShotCallback()
    {
      public final void onScreenShot(String paramAnonymousString, long paramAnonymousLong)
      {
        AppMethodBeat.i(203413);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "onScreenShot， path = " + paramAnonymousString + "， dateAdded = " + paramAnonymousLong);
        SnsAdNativeLandingPagesUI.R(SnsAdNativeLandingPagesUI.this);
        AppMethodBeat.o(203413);
      }
    };
    this.EyM = new HashMap();
    this.EyN = false;
    this.xxK = new a.b()
    {
      public final void bDZ()
      {
        AppMethodBeat.i(203431);
        try
        {
          AdLandingPagesProxy.getInstance().favEditTag();
          AppMethodBeat.o(203431);
          return;
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "favorite edittag fail, ex = " + localException.getMessage());
          AppMethodBeat.o(203431);
        }
      }
    };
    this.EyO = new b.a()
    {
      public final void bQ(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(203432);
        SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this, paramAnonymousBoolean);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "onKeyboardStateChanged, visiable=".concat(String.valueOf(paramAnonymousBoolean)));
        SnsAdNativeLandingPagesUI.this.JC(300L);
        AppMethodBeat.o(203432);
      }
    };
    this.EyP = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(203434);
        if (paramAnonymousIntent.getAction().equals("android.intent.action.SCREEN_OFF"))
        {
          com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SnsAdNativeLandingPagesUI", "android.intent.action.SCREEN_OFF");
          AppMethodBeat.o(203434);
          return;
        }
        if (paramAnonymousIntent.getAction().equals("android.intent.action.SCREEN_ON"))
        {
          com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SnsAdNativeLandingPagesUI", "android.intent.action.SCREEN_ON");
          ap.aK(SnsAdNativeLandingPagesUI.this);
        }
        AppMethodBeat.o(203434);
      }
    };
    this.EyQ = null;
    this.EyR = null;
    AppMethodBeat.o(98362);
  }
  
  private void JP(long paramLong)
  {
    AppMethodBeat.i(98401);
    if (this.Eyh != null)
    {
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SnsAdNativeLandingPagesUI", "showFloatBarView");
      this.Eyh.JA(paramLong);
      ContentFragment localContentFragment = fhn();
      if (localContentFragment != null) {
        localContentFragment.fee();
      }
    }
    AppMethodBeat.o(98401);
  }
  
  private void M(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(98375);
    String str = (String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.iconUrl");
    if (TextUtils.isEmpty(str))
    {
      this.Eim = null;
      AppMethodBeat.o(98375);
      return;
    }
    if (this.Eim == null) {
      this.Eim = new aq();
    }
    this.Eim.iconUrl = str;
    int k = Util.safeParseInt((String)paramMap.get(paramString + ".adCanvasInfo.sizeType"));
    int i = Util.safeParseInt((String)paramMap.get(paramString + ".adCanvasInfo.basicRootFontSize"));
    int j = Util.safeParseInt((String)paramMap.get(paramString + ".adCanvasInfo.basicWidth"));
    if ((i == 0) && (k == 1)) {
      i = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.Elo;
    }
    for (;;)
    {
      if ((j == 0) && (k == 1)) {
        j = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.Eln;
      }
      for (;;)
      {
        this.Eim.paddingBottom = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(Util.safeParseDouble((String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.paddingBottom")), k, j, i);
        this.Eim.width = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(Util.safeParseDouble((String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.layoutWidth")), k, j, i);
        this.Eim.height = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(Util.safeParseDouble((String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.layoutHeight")), k, j, i);
        AppMethodBeat.o(98375);
        return;
      }
    }
  }
  
  public static boolean ZF(int paramInt)
  {
    AppMethodBeat.i(203445);
    if ((paramInt == 3) || (paramInt == 5) || (paramInt == 4)) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "isNeedUpdateUxinfo, source=" + paramInt + ", ret=" + bool);
      AppMethodBeat.o(203445);
      return bool;
    }
  }
  
  private String aQZ(String paramString)
  {
    AppMethodBeat.i(98389);
    String str = Util.nullAs((String)this.values.get("." + this.ExA + ".adCanvasInfo.shareThumbUrl"), "");
    if (!Util.isNullOrNil(str))
    {
      AppMethodBeat.o(98389);
      return str;
    }
    AppMethodBeat.o(98389);
    return paramString;
  }
  
  private void amZ()
  {
    AppMethodBeat.i(98374);
    this.DsC = AdLandingPagesProxy.getInstance().getSnsInfo(this.dRS);
    AdLandingPagesProxy.getInstance().asyncCacheXml(this.dRS);
    if (this.values == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "parse landingpagexml is error,landingpagexml is " + this.Exz);
      AppMethodBeat.o(98374);
      return;
    }
    long l;
    Object localObject3;
    Object localObject4;
    label624:
    int i;
    if ((this.source == 1) || (this.source == 2) || (this.source == 16) || (this.source == 14) || (this.source == 9) || (this.source == 10))
    {
      l = 0L;
      if (this.DsC != null)
      {
        l = this.DsC.field_snsId;
        this.aid = AdLandingPagesProxy.getInstance().getSnsAid(this.dRS);
        this.kZe = AdLandingPagesProxy.getInstance().getSnsTraceid(this.dRS);
        this.adType = AdLandingPagesProxy.getInstance().getSnsAdType(this.dRS);
        this.uxInfo = AdLandingPagesProxy.getInstance().getSnsUxInfo(this.dRS);
        this.adCanvasExtXml = AdLandingPagesProxy.getInstance().getSnsAdCanvasExtXml(this.dRS);
      }
      if (this.ExG != null)
      {
        localObject1 = this.ExG;
        this.values.put("." + this.ExA + ".originSnsId", localObject1);
        this.values.put("." + this.ExA + ".originUxInfo", this.uxInfo);
        localObject3 = "<" + this.ExA + ">";
        localObject3 = (String)localObject3 + String.format("<originSnsId>%s</originSnsId>", new Object[] { localObject1 });
        localObject3 = (String)localObject3 + String.format("<originUxInfo>%s</originUxInfo>", new Object[] { this.uxInfo });
        localObject3 = (String)localObject3 + String.format("<originAdType>%d</originAdType>", new Object[] { Integer.valueOf(this.adType) });
        localObject3 = (String)localObject3 + String.format("<originAid>%s</originAid>", new Object[] { this.aid });
        localObject4 = (String)localObject3 + String.format("<originTraceId>%s</originTraceId>", new Object[] { this.kZe });
        localObject3 = localObject4;
        if (!Util.isNullOrNil(this.adCanvasExtXml)) {
          localObject3 = (String)localObject4 + String.format("<originAdCanvasExt>%s</originAdCanvasExt>", new Object[] { this.adCanvasExtXml });
        }
        this.Exz = this.Exz.replace("<" + this.ExA + ">", (CharSequence)localObject3);
        this.ExI.uxInfo = this.uxInfo;
        this.ExI.dRS = ((String)localObject1);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "reportInfo aid [%s],traceId [%s],adType [%s],uxInfo [%s],adCanvasExtXml [%s]", new Object[] { this.aid, this.kZe, Integer.valueOf(this.adType), this.uxInfo, this.adCanvasExtXml });
        if (Util.isNullOrNil(this.adCanvasExtXml)) {
          break label1753;
        }
        localObject3 = XmlParser.parseXml(this.adCanvasExtXml, "adCardItemList", null);
        if (localObject3 == null) {
          break label1753;
        }
        i = 0;
        label705:
        if (i <= 0) {
          break label3206;
        }
      }
    }
    label1753:
    Object localObject2;
    label3206:
    for (Object localObject1 = ".adCardItemList.cardItem" + i;; localObject2 = ".adCardItemList.cardItem")
    {
      if (((Map)localObject3).containsKey((String)localObject1 + ".cardTpId"))
      {
        localObject4 = Util.nullAs((String)((Map)localObject3).get((String)localObject1 + ".cardTpId"), "");
        localObject1 = Util.nullAs((String)((Map)localObject3).get((String)localObject1 + ".cardExt"), "");
        if ((!Util.isNullOrNil((String)localObject4)) && (!Util.isNullOrNil((String)localObject1))) {
          this.Eaa.put(localObject4, localObject1);
        }
        i += 1;
        break label705;
        localObject1 = String.valueOf(l);
        break;
        String str1 = "." + this.ExA + ".originTraceId";
        localObject4 = "." + this.ExA + ".originAid";
        String str2 = "." + this.ExA + ".originUxInfo";
        this.ExI.dRS = ((String)this.values.get("." + this.ExA + ".originSnsId"));
        this.ExI.uxInfo = ((String)this.values.get(str2));
        this.uxInfo = this.ExI.uxInfo;
        this.ExG = this.ExI.dRS;
        this.adType = Util.safeParseInt((String)this.values.get("." + this.ExA + ".originAdType"));
        this.aid = ((String)this.values.get(localObject4));
        this.kZe = ((String)this.values.get(str1));
        if (!Util.isNullOrNil(this.lAP))
        {
          localObject1 = XmlParser.parseXml(this.lAP, "ADInfo", null);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "adInfoXml %s", new Object[] { this.lAP });
          if (localObject1 != null)
          {
            this.uxInfo = Util.nullAs((String)((Map)localObject1).get(".ADInfo.uxInfo"), "");
            this.ExI.uxInfo = this.uxInfo;
            this.aid = Util.nullAs((String)((Map)localObject1).get(".ADInfo.session_data.aid"), "");
            this.kZe = Util.nullAs((String)((Map)localObject1).get(".ADInfo.session_data.trace_id"), "");
            this.viewId = Util.nullAs((String)((Map)localObject1).get(".ADInfo.viewid"), "");
            this.DZY = Util.nullAs((String)((Map)localObject1).get(".ADInfo.commInfo"), "");
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "adInfoXml, aid = " + this.aid + ", uxInfo = " + this.uxInfo + ", commInfo = " + this.DZY + ", traceId=" + this.kZe + ", viewId=" + this.viewId);
          }
        }
        try
        {
          localObject3 = "<" + this.ExA + ">";
          localObject1 = localObject3;
          if (!TextUtils.isEmpty(this.uxInfo))
          {
            localObject1 = localObject3;
            if (!this.values.containsKey(str2)) {
              localObject1 = (String)localObject3 + String.format("<originUxInfo>%s</originUxInfo>", new Object[] { this.uxInfo });
            }
          }
          localObject3 = localObject1;
          if (!TextUtils.isEmpty(this.kZe))
          {
            localObject3 = localObject1;
            if (!this.values.containsKey(str1)) {
              localObject3 = (String)localObject1 + String.format("<originTraceId>%s</originTraceId>", new Object[] { this.kZe });
            }
          }
          localObject1 = localObject3;
          if (!TextUtils.isEmpty(this.aid))
          {
            localObject1 = localObject3;
            if (!this.values.containsKey(localObject4)) {
              localObject1 = (String)localObject3 + String.format("<originAid>%s</originAid>", new Object[] { this.aid });
            }
          }
          this.Exz = this.Exz.replace("<" + this.ExA + ">", (CharSequence)localObject1);
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "replace landingPagesXml exp=" + localThrowable.toString());
          }
        }
        localObject1 = Pattern.compile("<originAdCanvasExt>[\\s\\S]*</originAdCanvasExt>").matcher(this.Exz);
        if (!((Matcher)localObject1).find()) {
          break label624;
        }
        localObject1 = ((Matcher)localObject1).group();
        if (Util.isNullOrNil((String)localObject1)) {
          break label624;
        }
        this.adCanvasExtXml = ((String)localObject1).replaceAll("</?originAdCanvasExt>", "");
        break label624;
      }
      this.ExI.ElT = AdLandingPagesProxy.getInstance().getSnsStatExtBySnsId(Util.safeParseLong(this.ExI.dRS));
      this.msN = Util.nullAs((String)this.values.get("." + this.ExA + ".adCanvasInfo.shareTitle"), "");
      this.rCq = Util.nullAs((String)this.values.get("." + this.ExA + ".adCanvasInfo.shareWebUrl"), "");
      this.xDQ = Util.nullAs((String)this.values.get("." + this.ExA + ".adCanvasInfo.shareDesc"), "");
      this.bizId = Util.safeParseInt(Util.nullAs((String)this.values.get("." + this.ExA + ".adCanvasInfo.bizId"), ""));
      this.ExN = Util.nullAs((String)this.values.get("." + this.ExA + ".adCanvasInfo.shareAppId"), "");
      this.ExO = Util.nullAs((String)this.values.get("." + this.ExA + ".adCanvasInfo.shareType"), "");
      this.ExP = Util.nullAs((String)this.values.get("." + this.ExA + ".adCanvasInfo.userInfo"), "");
      this.ExS = Util.safeParseInt(Util.nullAs((String)this.values.get("." + this.ExA + ".adCanvasInfo.disableShareBitSet"), ""));
      this.ExT = Util.safeParseInt(Util.nullAs((String)this.values.get("." + this.ExA + ".adCanvasInfo.statusBarStyle"), ""));
      M(this.values, "." + this.ExA);
      this.uin = AdLandingPagesProxy.getInstance().getUin();
      this.ExQ = Util.nullAs((String)this.values.get("." + this.ExA + ".adCanvasInfo.officialSyncBuffer"), "");
      getIntent().putExtra("sns_landing_pages_adType", this.adType);
      getIntent().putExtra("sns_landing_pages_rawSnsId", this.ExI.dRS);
      if (Util.isNullOrNil(this.aid)) {
        this.aid = Util.nullAs((String)this.values.get("." + this.ExA + ".originAid"), "");
      }
      if (Util.isNullOrNil(this.kZe)) {
        this.kZe = Util.nullAs((String)this.values.get("." + this.ExA + ".originTraceId"), "");
      }
      localObject2 = new i.a(this.Exz, this.ExA);
      this.Elq = ((i.a)localObject2).Elq;
      this.Exu = ((i.a)localObject2).Elr;
      fhu();
      b((i.a)localObject2);
      c((i.a)localObject2);
      d((i.a)localObject2);
      localObject3 = new ArrayList();
      if (((i.a)localObject2).Elr != null) {
        com.tencent.mm.plugin.sns.ad.e.e.a(((i.a)localObject2).Elr, (ArrayList)localObject3);
      }
      if (((i.a)localObject2).Elt != null) {
        com.tencent.mm.plugin.sns.ad.e.e.a(((i.a)localObject2).Elt, (ArrayList)localObject3);
      }
      if (!((ArrayList)localObject3).isEmpty()) {
        com.tencent.mm.plugin.sns.ad.e.e.g((ArrayList)localObject3, this.preloadWeAppPkg);
      }
      if (this.Elq.size() > 0)
      {
        l = 0L;
        localObject2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.Elq.get(0);
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject2).Eli.size() <= 0) {
          break label3168;
        }
        localObject3 = (z)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject2).Eli.get(0);
        if (!(localObject3 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t)) {
          break label3015;
        }
        this.ExF = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t)localObject3).DYK;
        localObject2 = "";
        if (this.DsC != null)
        {
          localObject3 = this.DsC.getTimeLine();
          if ((localObject3 != null) && (((TimeLineObject)localObject3).ContentObj != null) && (((TimeLineObject)localObject3).ContentObj.LoV != null) && (!((TimeLineObject)localObject3).ContentObj.LoV.isEmpty()))
          {
            localObject4 = (cnb)((TimeLineObject)localObject3).ContentObj.LoV.getFirst();
            localObject3 = ar.ki(AdLandingPagesProxy.getInstance().getAccSnsPath(), ((cnb)localObject4).Id) + com.tencent.mm.plugin.sns.data.r.j((cnb)localObject4);
            localObject4 = ((cnb)localObject4).Url;
            if (((String)localObject2).equals(localObject4))
            {
              localObject2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kA("adId", (String)localObject4);
              if ((!com.tencent.mm.vfs.s.YS((String)localObject2)) && (com.tencent.mm.vfs.s.YS((String)localObject3)))
              {
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "copy outsideFiel:%s->%s", new Object[] { localObject3, localObject2 });
                if (!com.tencent.mm.plugin.sns.ad.timeline.b.a.n(this.DsC)) {
                  break label3195;
                }
                if (com.tencent.mm.vfs.s.boW((String)localObject3) != l) {
                  break label3176;
                }
                com.tencent.mm.vfs.s.nw((String)localObject3, (String)localObject2);
                com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SnsAdNativeLandingPagesUI", "online video play, it is to copy!!");
                com.tencent.mm.plugin.sns.ad.i.k.a(com.tencent.mm.plugin.sns.ad.i.l.XV(1));
              }
            }
          }
        }
      }
      for (;;)
      {
        this.ExB = Util.nullAs((String)this.values.get("." + this.ExA + ".adCanvasInfo.rightBarTitle"), "");
        this.ExC = Util.nullAs((String)this.values.get("." + this.ExA + ".adCanvasInfo.rightBarCanvasId"), "");
        this.ExD = Util.nullAs((String)this.values.get("." + this.ExA + ".adCanvasInfo.rightBarCanvasExt"), "");
        AppMethodBeat.o(98374);
        return;
        label3015:
        if ((localObject3 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s))
        {
          this.ExF = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)localObject3).DYK;
          localObject2 = "";
          break;
        }
        if ((localObject3 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v))
        {
          this.ExF = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v)localObject3).DYR;
          localObject2 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v)localObject3).DYQ;
          l = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v)localObject3).DZb;
          break;
        }
        if ((localObject3 instanceof ak))
        {
          localObject2 = (ak)localObject3;
          if (!((ak)localObject2).DYI.isEmpty())
          {
            localObject2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)((ak)localObject2).DYI.getFirst();
            if (!((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)localObject2).DYI.isEmpty())
            {
              localObject2 = (z)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)localObject2).DYI.getFirst();
              if ((localObject2 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t)) {
                this.ExF = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t)localObject2).DYK;
              }
            }
          }
        }
        label3168:
        localObject2 = "";
        break;
        label3176:
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.SnsAdNativeLandingPagesUI", "online play, but it isn't to copy, because file size is invalid");
        com.tencent.mm.plugin.sns.ad.i.k.a(com.tencent.mm.plugin.sns.ad.i.l.XV(0));
        continue;
        label3195:
        com.tencent.mm.vfs.s.nw((String)localObject3, (String)localObject2);
      }
    }
  }
  
  private void b(i.a parama)
  {
    AppMethodBeat.i(203453);
    try
    {
      if ((parama.Els != null) && (this.ExX != null))
      {
        this.Eyr = FloatWebViewHelper.a(parama.Els, (ViewGroup)this.ExX);
        getLifecycle().addObserver(this.Eyr);
      }
      AppMethodBeat.o(203453);
      return;
    }
    catch (Throwable parama)
    {
      AppMethodBeat.o(203453);
    }
  }
  
  private void boD()
  {
    AppMethodBeat.i(98378);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.ExR.getAdapter();
    if (localb == null)
    {
      localb = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b(getSupportFragmentManager(), new ArrayList());
      this.ExR.setAdapter(localb);
    }
    for (;;)
    {
      List localList = fhf();
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g localg;
      ContentFragment localContentFragment;
      if (localList.size() > 0)
      {
        localg = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localList.get(0);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "loadFirstPage load id %s", new Object[] { Integer.valueOf(localg.id) });
        localContentFragment = (ContentFragment)this.EyM.get(Integer.valueOf(localg.id));
        if (localContentFragment != null) {
          break label362;
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("pageInfo", localg);
        localHashMap.put("pageCount", Integer.valueOf(localList.size()));
        localHashMap.put("viewPager", this.ExR);
        localHashMap.put("pageDownIconInfo", this.Eim);
        localHashMap.put("is_first_show_page", Boolean.TRUE);
        if (localList.size() == 1) {
          localHashMap.put("is_last_shown_page", Boolean.TRUE);
        }
        localHashMap.put("needEnterAnimation", Boolean.valueOf(this.Exx));
        localHashMap.put("needDirectionAnimation", Boolean.valueOf(fhi()));
        localHashMap.put("groupListCompShowIndex", Integer.valueOf(this.ExL));
        localContentFragment = new ContentFragment();
        localContentFragment.params = localHashMap;
        localContentFragment.Eiv = this.EyF;
        this.EyM.put(Integer.valueOf(localg.id), localContentFragment);
      }
      for (;;)
      {
        if (localContentFragment != null) {
          localb.c(localContentFragment, 0);
        }
        localb.notifyDataSetChanged();
        this.ExR.setOffscreenPageLimit(localList.size());
        AppMethodBeat.o(98378);
        return;
        label362:
        localContentFragment.a(localg);
      }
    }
  }
  
  private void c(i.a parama)
  {
    AppMethodBeat.i(203454);
    try
    {
      fht();
      if (this.Eyg != null)
      {
        parama = this.Eyg.a(parama);
        if (parama != null)
        {
          parama.C((ViewGroup)this.ExX);
          parama.eXl();
        }
      }
      AppMethodBeat.o(203454);
      return;
    }
    catch (Throwable parama)
    {
      AppMethodBeat.o(203454);
    }
  }
  
  private void d(i.a parama)
  {
    AppMethodBeat.i(203455);
    try
    {
      fht();
      if ((parama.Elt != null) && (this.ExX != null) && (this.Eyg != null))
      {
        FloatJumpCompHelper localFloatJumpCompHelper = this.Eyg.a(parama.Elt, (ViewGroup)this.ExX);
        if (localFloatJumpCompHelper != null)
        {
          this.EyS = localFloatJumpCompHelper;
          getLifecycle().addObserver(localFloatJumpCompHelper);
          if (parama.Elt.DtV != null)
          {
            parama = parama.Elt.DtV.DYr;
            if (!TextUtils.isEmpty(parama)) {
              this.Eyl.add(parama);
            }
          }
        }
      }
      AppMethodBeat.o(203455);
      return;
    }
    catch (Throwable parama)
    {
      AppMethodBeat.o(203455);
    }
  }
  
  private void fgS()
  {
    boolean bool2 = true;
    AppMethodBeat.i(203441);
    boolean bool3 = false;
    for (;;)
    {
      try
      {
        int i = getApplicationContext().getApplicationInfo().targetSdkVersion;
        bool1 = bool3;
        if (com.tencent.mm.compatible.util.d.oD(29))
        {
          if (com.tencent.mm.compatible.util.d.oD(30)) {
            break label200;
          }
          bool1 = bool3;
          if (i >= 29) {
            break label200;
          }
        }
        String str = Util.nullAsNil(Build.MODEL);
        if ((!bool1) && (!TextUtils.isEmpty(str)) && ("huawei nxt-al10|mix 2s".contains(str.toLowerCase())))
        {
          bool1 = bool2;
          if (bool1) {
            com.tencent.mm.ui.base.b.a(this, null);
          }
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "fixActivityTranslucent, device=" + str + ", api=" + Build.VERSION.SDK_INT + ", targetSdkVer=" + i + ", needFix=" + bool1);
          AppMethodBeat.o(203441);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "fixActivityTranslucent exp=" + localThrowable.toString());
        AppMethodBeat.o(203441);
        return;
      }
      continue;
      label200:
      boolean bool1 = true;
    }
  }
  
  private void fgT()
  {
    AppMethodBeat.i(98364);
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SnsAdNativeLandingPagesUI.launch", "initAfterConnectToMM");
    AdlandingRemoteServiceConnectedReceiver.a(android.support.v4.content.d.W(this));
    amZ();
    if (this.Exx) {
      boD();
    }
    for (;;)
    {
      refreshView();
      fha();
      fhb();
      vp(true);
      this.aMp = true;
      fgU();
      fgV();
      AppMethodBeat.o(98364);
      return;
      fhg();
    }
  }
  
  private void fgU()
  {
    AppMethodBeat.i(203442);
    if ((ZF(this.source)) && (!TextUtils.isEmpty(this.uxInfo)))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "doUpdateUxInfoScene, uxInfo=" + this.uxInfo);
      AdLandingPagesProxy.getInstance().doUpdateUxInfoScene(this.uxInfo, new AdLandingPagesProxy.e()
      {
        public final void bn(Object paramAnonymousObject) {}
        
        public final void h(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
        {
          AppMethodBeat.i(203440);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "doUpdateUxInfoScene end, errType=" + paramAnonymousInt1 + ", errNo=" + paramAnonymousInt2 + ", newUxInfo=" + paramAnonymousObject);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && ((paramAnonymousObject instanceof String))) {
            SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this, (String)paramAnonymousObject);
          }
          AppMethodBeat.o(203440);
        }
      });
      fgW();
    }
    AppMethodBeat.o(203442);
  }
  
  private void fgV()
  {
    AppMethodBeat.i(203443);
    AdLandingPagesProxy.getInstance().doAdNativeAntiAbuseScene(this.ExI.lAN, this.uxInfo, this.source, this.adExtInfo, new AdLandingPagesProxy.e()
    {
      public final void bn(Object paramAnonymousObject) {}
      
      public final void h(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(203408);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "doAdNativeAntiAbuseScene end, errType = " + paramAnonymousInt1 + ", errNo = " + paramAnonymousInt2 + ", canvasAuthFailed = " + paramAnonymousObject);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousObject != null)) {
          try
          {
            bq localbq = new bq();
            localbq.parseFrom((byte[])paramAnonymousObject);
            if (localbq.KFp != 0) {
              MMHandlerThread.postToMainThreadDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(203407);
                  Context localContext = SnsAdNativeLandingPagesUI.this.getApplicationContext();
                  if (localContext != null) {
                    com.tencent.mm.ui.base.u.cH(localContext, "广告无效，已为你关闭");
                  }
                  SnsAdNativeLandingPagesUI.this.cvQ();
                  AppMethodBeat.o(203407);
                }
              }, 500L);
            }
            AppMethodBeat.o(203408);
            return;
          }
          catch (Throwable paramAnonymousObject)
          {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", paramAnonymousObject.toString());
          }
        }
        AppMethodBeat.o(203408);
      }
    });
    AppMethodBeat.o(203443);
  }
  
  private void fgW()
  {
    AppMethodBeat.i(203444);
    try
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "checkPreloadScanRes, uxinfo=" + this.uxInfo);
      com.tencent.mm.plugin.sns.ad.timeline.b.e.a(ADXml.b.F(this.values, ".adxml.adScanInfo"), this.uxInfo);
      AppMethodBeat.o(203444);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "checkPreloadScanRes exp=" + localException.toString());
      AppMethodBeat.o(203444);
    }
  }
  
  private void fgX()
  {
    AppMethodBeat.i(203446);
    try
    {
      if ((this.Eys != null) && (this.Eys.isShowing())) {
        this.Eys.bMo();
      }
      AppMethodBeat.o(203446);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "hideMoreOptionMenu exp=" + localException.toString());
      AppMethodBeat.o(203446);
    }
  }
  
  private void fgZ()
  {
    AppMethodBeat.i(98367);
    Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.ExR.getAdapter();
    if (localObject == null)
    {
      AppMethodBeat.o(98367);
      return;
    }
    localObject = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)localObject).fragments.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ContentFragment localContentFragment = (ContentFragment)((Iterator)localObject).next();
      if ((localContentFragment.Eik != null) && (localContentFragment.getUserVisibleHint())) {
        localContentFragment.Eik.fdU();
      }
    }
    if (this.Eyh != null) {
      this.Eyh.eXa();
    }
    AppMethodBeat.o(98367);
  }
  
  private void fha()
  {
    AppMethodBeat.i(98369);
    com.tencent.mm.plugin.report.service.h localh;
    String str2;
    if (this.recSrc != 2)
    {
      localh = com.tencent.mm.plugin.report.service.h.CyF;
      str2 = com.tencent.mm.plugin.sns.data.r.Jb(com.tencent.mm.plugin.sns.data.r.aOw(this.ExI.dRS));
      if (this.uxInfo != null) {
        break label127;
      }
    }
    label127:
    for (String str1 = "";; str1 = this.uxInfo)
    {
      localh.a(14655, new Object[] { str2, str1, Integer.valueOf(this.ExI.gYH), Integer.valueOf(this.ExI.rna), Long.valueOf(this.enterTime), Integer.valueOf(this.DZU), this.ExI.lAN });
      AppMethodBeat.o(98369);
      return;
    }
  }
  
  private void fhb()
  {
    AppMethodBeat.i(179185);
    try
    {
      if (!Util.isNullOrNil(new String[] { this.viewId, this.DZY }))
      {
        if (!this.Eym) {
          fhc();
        }
        if ((!this.Eyn) && (this.Eyp != null))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "execute mValidExposureRunnable onCreate");
          this.Eyp.removeCallbacks(this.EyK);
          this.Eyp.postDelayed(this.EyK, 1000L);
        }
      }
      AppMethodBeat.o(179185);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", localThrowable.toString());
      AppMethodBeat.o(179185);
    }
  }
  
  private void fhc()
  {
    AppMethodBeat.i(179186);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "reportOriginalExposure viewId = " + this.viewId + ", commInfo = " + this.DZY + ", uxInfo = " + this.uxInfo + ", exposureType = 0");
    this.Eym = true;
    i(this.viewId, this.DZY, this.uxInfo, 0);
    AppMethodBeat.o(179186);
  }
  
  private void fhd()
  {
    AppMethodBeat.i(179187);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "reportValidExposure viewId = " + this.viewId + ", commInfo = " + this.DZY + ", uxInfo = " + this.uxInfo + ", exposureType = 1");
    this.Eyn = true;
    i(this.viewId, this.DZY, this.uxInfo, 1);
    AppMethodBeat.o(179187);
  }
  
  private boolean fhe()
  {
    AppMethodBeat.i(98370);
    int j = this.ExV.getChildCount();
    int i = 0;
    while (i < j)
    {
      if ((this.ExV.getChildAt(i) instanceof SnsAdLandingPageFloatView))
      {
        AppMethodBeat.o(98370);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(98370);
    return false;
  }
  
  private List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g> fhf()
  {
    AppMethodBeat.i(98376);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Elq.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g localg = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localIterator.next();
      if (localg.Elk) {
        localArrayList.add(localg);
      }
    }
    hb(localArrayList);
    AppMethodBeat.o(98376);
    return localArrayList;
  }
  
  private void fhg()
  {
    AppMethodBeat.i(98379);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.ExR.getAdapter();
    if (localb == null)
    {
      localb = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b(getSupportFragmentManager(), new ArrayList());
      this.ExR.setAdapter(localb);
    }
    for (;;)
    {
      List localList = fhf();
      int i = 0;
      if (i < localList.size())
      {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g localg = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.Elq.get(i);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "loadLandingPages load id %s", new Object[] { Integer.valueOf(localg.id) });
        ContentFragment localContentFragment = (ContentFragment)this.EyM.get(Integer.valueOf(localg.id));
        boolean bool;
        label214:
        label244:
        int j;
        if (localContentFragment == null)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("pageInfo", localg);
          localHashMap.put("pageCount", Integer.valueOf(localList.size()));
          localHashMap.put("viewPager", this.ExR);
          localHashMap.put("pageDownIconInfo", this.Eim);
          if (i == 0)
          {
            bool = true;
            localHashMap.put("is_first_show_page", Boolean.valueOf(bool));
            if (i != localList.size() - 1) {
              break label393;
            }
            bool = true;
            localHashMap.put("is_last_shown_page", Boolean.valueOf(bool));
            localHashMap.put("needEnterAnimation", Boolean.valueOf(this.Exx));
            localHashMap.put("needDirectionAnimation", Boolean.valueOf(fhi()));
            if (i != 0) {
              break label398;
            }
            j = this.ExL;
            label304:
            localHashMap.put("groupListCompShowIndex", Integer.valueOf(j));
            localContentFragment = new ContentFragment();
            localContentFragment.params = localHashMap;
            if (i == 0) {
              localContentFragment.Eiv = this.EyF;
            }
            this.EyM.put(Integer.valueOf(localg.id), localContentFragment);
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
      this.ExR.setOffscreenPageLimit(localList.size());
      AppMethodBeat.o(98379);
      return;
    }
  }
  
  private boolean fhh()
  {
    AppMethodBeat.i(98382);
    if (this.ExS != 0)
    {
      if (((this.ExS & 0x4) == 0) || ((this.ExS & 0x2) == 0) || ((fhl()) && (this.bizId == 2)) || ((this.ExS & 0x1) == 0) || ((this.ExS & 0x20) == 0))
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
  
  private boolean fhi()
  {
    return (this.ExS & 0x8) == 0;
  }
  
  private boolean fhj()
  {
    return this.ExT == 0;
  }
  
  private boolean fhk()
  {
    AppMethodBeat.i(98383);
    if ((!Util.isNullOrNil(this.ExB)) && (!Util.isNullOrNil(this.ExC)))
    {
      AppMethodBeat.o(98383);
      return true;
    }
    AppMethodBeat.o(98383);
    return false;
  }
  
  private boolean fhl()
  {
    return (this.ExS & 0x10) == 0;
  }
  
  private aj fhm()
  {
    AppMethodBeat.i(98385);
    Object localObject = fhn().fdY().iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m localm = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m)((Iterator)localObject).next();
      if ((localm instanceof aj))
      {
        localObject = (aj)localm;
        AppMethodBeat.o(98385);
        return localObject;
      }
    }
    AppMethodBeat.o(98385);
    return null;
  }
  
  private ContentFragment fhn()
  {
    AppMethodBeat.i(98387);
    ContentFragment localContentFragment = null;
    if (this.Elq.size() > 0) {
      localContentFragment = (ContentFragment)this.EyM.get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.Elq.get(this.ExR.getCurrentItem())).id));
    }
    AppMethodBeat.o(98387);
    return localContentFragment;
  }
  
  private a fho()
  {
    AppMethodBeat.i(98388);
    Object localObject = new ADXml(this.Exz);
    if (((ADXml)localObject).hasVoteInfo())
    {
      int i = AdLandingPagesProxy.getInstance().getAdVoteIndex(((ADXml)localObject).adVoteInfo.DWX, this.uxInfo, this.uin);
      if ((i > 0) && (i <= ((ADXml)localObject).adVoteInfo.DWZ.size()))
      {
        localObject = (ADXml.m)((ADXml)localObject).adVoteInfo.DWZ.get(i - 1);
        a locala = new a((byte)0);
        if (!Util.isNullOrNil(((ADXml.m)localObject).msN))
        {
          locala.msN = ((ADXml.m)localObject).msN;
          if (Util.isNullOrNil(((ADXml.m)localObject).xDQ)) {
            break label165;
          }
          locala.xDQ = ((ADXml.m)localObject).xDQ;
          label128:
          if (Util.isNullOrNil(((ADXml.m)localObject).DXa)) {
            break label176;
          }
        }
        label165:
        label176:
        for (locala.DXa = ((ADXml.m)localObject).DXa;; locala.DXa = this.ExF)
        {
          AppMethodBeat.o(98388);
          return locala;
          locala.msN = this.msN;
          break;
          locala.xDQ = this.xDQ;
          break label128;
        }
      }
    }
    AppMethodBeat.o(98388);
    return null;
  }
  
  private String fhp()
  {
    AppMethodBeat.i(98390);
    Object localObject = new eco();
    ((eco)localObject).NcH = new ecp();
    ((eco)localObject).NcH.KxO = this.ExI.uxInfo;
    ((eco)localObject).NcH.NcK = this.ExI.dRS;
    ((eco)localObject).NcH.adType = this.adType;
    try
    {
      localObject = Base64.encodeToString(((eco)localObject).toByteArray(), 2);
      AppMethodBeat.o(98390);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(98390);
    }
    return "";
  }
  
  private String fhq()
  {
    AppMethodBeat.i(98391);
    try
    {
      Object localObject2 = this.Exz.replaceAll("(?s)<adCanvasInfoLeft[^>]*>.*?</adCanvasInfoLeft>", "").replaceAll("(?s)<adCanvasInfoRight[^>]*>.*?</adCanvasInfoRight>", "");
      Object localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).contains("<adFullCardGestureCanvasInfo>")) {
          localObject1 = ((String)localObject2).replaceAll("(?s)<adFullCardGestureCanvasInfo[^>]*>.*?</adFullCardGestureCanvasInfo>", "");
        }
      }
      localObject2 = localObject1;
      if (((String)localObject1).contains("<shareAdCanvasInfo>")) {
        localObject2 = ((String)localObject1).replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replace("shareAdCanvasInfo", "adCanvasInfo");
      }
      AppMethodBeat.o(98391);
      return localObject2;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "genForwardXml, exp=" + localThrowable.toString());
      String str = this.Exz;
      AppMethodBeat.o(98391);
      return str;
    }
  }
  
  private void fht()
  {
    AppMethodBeat.i(203456);
    if (this.Eyg == null) {
      this.Eyg = new com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.a();
    }
    AppMethodBeat.o(203456);
  }
  
  private void fhu()
  {
    AppMethodBeat.i(98398);
    if ((this.Exu != null) && (this.ExV != null) && (this.Eyh == null))
    {
      this.Eyh = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d(this, this.Exu, this.ExV);
      k(false, 0L);
      if ((this.Exu.DZH instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q))
      {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q localq = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.Exu.DZH;
        if (!TextUtils.isEmpty(localq.DYr)) {
          this.Eyl.add(localq.DYr);
        }
      }
    }
    AppMethodBeat.o(98398);
  }
  
  private boolean fhw()
  {
    AppMethodBeat.i(98404);
    if (this.Exu != null)
    {
      if (this.Exu.DZG == 1)
      {
        boolean bool = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u.YU(this.source);
        AppMethodBeat.o(98404);
        return bool;
      }
      AppMethodBeat.o(98404);
      return true;
    }
    AppMethodBeat.o(98404);
    return false;
  }
  
  private void hb(List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g> paramList)
  {
    AppMethodBeat.i(98377);
    Object localObject;
    try
    {
      localObject = new ArrayList();
      int j = 0;
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        Iterator localIterator = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)paramList.next()).Eli.iterator();
        int i = j;
        for (;;)
        {
          j = i;
          if (!localIterator.hasNext()) {
            break;
          }
          z localz = (z)localIterator.next();
          j = i;
          if ((localz instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b))
          {
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localz).DXN = i;
            j = i + 1;
          }
          String str;
          if ((localz instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q))
          {
            str = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)localz).DYr;
            if (!TextUtils.isEmpty(str)) {
              this.Eyl.add(str);
            }
          }
          if ((localz instanceof p))
          {
            str = ((p)localz).jumpUrl;
            if (!TextUtils.isEmpty(str)) {
              this.Eyl.add(str);
            }
          }
          i = j;
          if (!this.EyN)
          {
            com.tencent.mm.plugin.sns.ad.e.e.a(localz, (ArrayList)localObject);
            i = j;
          }
        }
      }
      if (this.EyN) {
        break label260;
      }
    }
    catch (Exception paramList)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "giveIdxForApkBtnInfo, exp=" + paramList.toString());
      AppMethodBeat.o(98377);
      return;
    }
    this.EyN = true;
    if (!((ArrayList)localObject).isEmpty()) {
      com.tencent.mm.plugin.sns.ad.e.e.g((ArrayList)localObject, this.preloadWeAppPkg);
    }
    label260:
    if (!com.tencent.mm.plugin.sns.ad.i.c.isEmpty(this.Eyl))
    {
      localObject = com.tencent.mm.plugin.sns.ad.d.a.a.a(this.Eyl, this.kZe, this.aid, this.DZW, this.uxInfo);
      if (!com.tencent.mm.plugin.sns.ad.i.c.w((Object[])localObject)) {
        if (!TextUtils.isEmpty(this.dRS)) {
          break label334;
        }
      }
    }
    label334:
    for (paramList = this.ExG;; paramList = this.dRS)
    {
      AdLandingPagesProxy.getInstance().prefetchH5Url(paramList, (String[])localObject);
      AppMethodBeat.o(98377);
      return;
    }
  }
  
  private static void i(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(179188);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("viewid", paramString1);
      localJSONObject.put("commInfo", paramString2);
      localJSONObject.put("uxinfo", paramString3);
      localJSONObject.put("exposureType", paramInt);
      com.tencent.mm.plugin.sns.data.k.jY("rewarded_canvas_exposure", localJSONObject.toString());
      AppMethodBeat.o(179188);
      return;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "doCanvasExposureReport exp=" + paramString1.toString());
      AppMethodBeat.o(179188);
    }
  }
  
  private boolean r(ContentFragment paramContentFragment)
  {
    AppMethodBeat.i(203451);
    Object localObject1;
    if (this.EyA == null)
    {
      paramContentFragment = paramContentFragment.fdY().iterator();
      while (paramContentFragment.hasNext())
      {
        localObject1 = com.tencent.mm.plugin.sns.ad.landingpage.component.a.b.b((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m)paramContentFragment.next());
        if (localObject1 != null) {
          this.EyA = ((com.tencent.mm.plugin.sns.ad.landingpage.component.a.b)localObject1);
        }
      }
    }
    if ((this.EyA != null) && (this.Eyv != null))
    {
      if (TextUtils.isEmpty(this.EyB))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "start reqTwistCardId, source=" + this.source);
        final long l = System.currentTimeMillis();
        AdLandingPagesProxy.getInstance().getTwistAdCard(this.uxInfo, this.ExG, this.source, Util.nullAsNil(this.ExI.lAN), "", new AdLandingPagesProxy.e()
        {
          public final void bn(Object paramAnonymousObject) {}
          
          public final void h(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
          {
            AppMethodBeat.i(203439);
            SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this, f.i(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject));
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "reqTwistCardId rsp, errType=" + paramAnonymousInt1 + ", errNo=" + paramAnonymousInt2 + ", cardId=" + SnsAdNativeLandingPagesUI.W(SnsAdNativeLandingPagesUI.this) + ", timeCost=" + (System.currentTimeMillis() - l));
            AppMethodBeat.o(203439);
          }
        });
      }
      for (;;)
      {
        if (isSupportNavigationSwipeBack())
        {
          getSwipeBackLayout().setEnableGesture(false);
          getSwipeBackLayout().CV(true);
        }
        if (this.Eyx) {
          this.EyA.contentView.setVisibility(4);
        }
        this.Eyu.setVisibility(0);
        this.Eyu.setOnCardAnimListener(new TwistRoateCardsView.a()
        {
          public final void eYT()
          {
            AppMethodBeat.i(203417);
            if (!SnsAdNativeLandingPagesUI.f(SnsAdNativeLandingPagesUI.this))
            {
              localObjectAnimator = ObjectAnimator.ofFloat(SnsAdNativeLandingPagesUI.h(SnsAdNativeLandingPagesUI.this), "alpha", new float[] { 0.0F, 1.0F });
              localObjectAnimator.setDuration(500L);
              localObjectAnimator.start();
              localObjectAnimator = ObjectAnimator.ofFloat(SnsAdNativeLandingPagesUI.g(SnsAdNativeLandingPagesUI.this), "alpha", new float[] { SnsAdNativeLandingPagesUI.g(SnsAdNativeLandingPagesUI.this).getAlpha(), 0.0F });
              localObjectAnimator.setDuration(300L);
              localObjectAnimator.start();
            }
            SnsAdNativeLandingPagesUI.m(SnsAdNativeLandingPagesUI.this).setVisibility(0);
            ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(SnsAdNativeLandingPagesUI.m(SnsAdNativeLandingPagesUI.this), "alpha", new float[] { 0.0F, 1.0F });
            localObjectAnimator.setDuration(500L);
            localObjectAnimator.start();
            SnsAdNativeLandingPagesUI.T(SnsAdNativeLandingPagesUI.this).contentView.setVisibility(0);
            AppMethodBeat.o(203417);
          }
          
          public final void eYU()
          {
            AppMethodBeat.i(203418);
            if (SnsAdNativeLandingPagesUI.this.isSupportNavigationSwipeBack()) {
              SnsAdNativeLandingPagesUI.this.getSwipeBackLayout().setEnableGesture(true);
            }
            SnsAdNativeLandingPagesUI.u(SnsAdNativeLandingPagesUI.this);
            SnsAdNativeLandingPagesUI.U(SnsAdNativeLandingPagesUI.this);
            SnsAdNativeLandingPagesUI.V(SnsAdNativeLandingPagesUI.this).setVisibility(8);
            if (SnsAdNativeLandingPagesUI.T(SnsAdNativeLandingPagesUI.this) != null) {
              SnsAdNativeLandingPagesUI.T(SnsAdNativeLandingPagesUI.this).eXc();
            }
            AppMethodBeat.o(203418);
          }
          
          public final void eYV()
          {
            AppMethodBeat.i(203419);
            String str = SnsAdNativeLandingPagesUI.W(SnsAdNativeLandingPagesUI.this);
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "onPrepareCard, twistId=".concat(String.valueOf(str)));
            com.tencent.mm.plugin.sns.ad.landingpage.component.a.b localb = SnsAdNativeLandingPagesUI.T(SnsAdNativeLandingPagesUI.this);
            Object localObject1;
            if (!TextUtils.isEmpty(str))
            {
              Object localObject2 = localb.Dto.aQz.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject1 = (z)((Iterator)localObject2).next();
                if (str.equals(((z)localObject1).DZu))
                {
                  localObject2 = localObject1;
                  if (localObject1 == null) {
                    localObject2 = localb.eWV();
                  }
                  localObject1 = new ArrayList();
                  if (localObject2 != null) {
                    ((List)localObject1).add(localObject2);
                  }
                  if (localb.Dtq != null) {
                    break label245;
                  }
                  localb.Dtq = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l((List)localObject1, localb.context, (FrameLayout)localb.contentView);
                  localb.Dtq.layout();
                  localb.Dtp = localb.eWU();
                  label171:
                  if (!TextUtils.isEmpty(str)) {
                    break label257;
                  }
                  TwistCoverView.a(SnsAdNativeLandingPagesUI.this.fds(), 2);
                }
              }
            }
            for (;;)
            {
              SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this, com.tencent.mm.plugin.sns.ad.landingpage.component.a.b.a(SnsAdNativeLandingPagesUI.T(SnsAdNativeLandingPagesUI.this)));
              if (SnsAdNativeLandingPagesUI.X(SnsAdNativeLandingPagesUI.this) == null) {
                break label271;
              }
              SnsAdNativeLandingPagesUI.V(SnsAdNativeLandingPagesUI.this).setAnimCardView(SnsAdNativeLandingPagesUI.X(SnsAdNativeLandingPagesUI.this));
              AppMethodBeat.o(203419);
              return;
              localObject1 = null;
              break;
              label245:
              localb.Dtq.gV((List)localObject1);
              break label171;
              label257:
              TwistCoverView.a(SnsAdNativeLandingPagesUI.this.fds(), 1);
            }
            label271:
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "mTwistCardAnimView==null");
            AppMethodBeat.o(203419);
          }
        });
        localObject1 = this.EyA.eWW();
        paramContentFragment = this.Eyu;
        int i = ((Integer)((Pair)localObject1).first).intValue();
        int j = ((Integer)((Pair)localObject1).second).intValue();
        boolean bool = this.Eyv.DWV;
        localObject1 = this.EyA.Dto.DtQ;
        Object localObject2 = this.EyA.Dto.DtR;
        org.xwalk.core.Log.i("TwistRoateCardsView", "initData, defBgColor=" + (String)localObject2 + ", imgUrl=" + (String)localObject1);
        paramContentFragment.DCD = ((String)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
        try
        {
          paramContentFragment.DCE = Color.parseColor((String)localObject2);
          if ((i <= 0) || (j <= 0))
          {
            org.xwalk.core.Log.e("TwistRoateCardsView", "initData, size is 0, w=" + i + ", h=" + j);
            paramContentFragment.DCv = com.tencent.mm.cb.a.fromDPToPix(paramContentFragment.mContext, 221);
            paramContentFragment.DCw = com.tencent.mm.cb.a.fromDPToPix(paramContentFragment.mContext, 375);
            paramContentFragment.DCu = (com.tencent.mm.cb.a.fromDPToPix(paramContentFragment.mContext, 200) + paramContentFragment.DCw / 2);
            paramContentFragment.DsW = bool;
            if (!paramContentFragment.DsW) {
              break label723;
            }
            paramContentFragment.DCC = 3;
            paramContentFragment.removeAllViews();
            paramContentFragment.eYS();
            paramContentFragment = this.Eyu;
            localObject1 = ObjectAnimator.ofFloat(paramContentFragment, "alpha", new float[] { 0.0F, 1.0F });
            ((ObjectAnimator)localObject1).setDuration(1500L);
            if (!paramContentFragment.DsW) {
              break label732;
            }
            f = -180.0F;
            localObject2 = ValueAnimator.ofFloat(new float[] { f, 0.0F });
            ((ValueAnimator)localObject2).setDuration(1500L);
            ((ValueAnimator)localObject2).addUpdateListener(new TwistRoateCardsView.2(paramContentFragment));
            ((ValueAnimator)localObject2).addListener(new TwistRoateCardsView.3(paramContentFragment));
            ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.3F, 1.0F });
            localValueAnimator.setDuration(1500L);
            localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
            localValueAnimator.addUpdateListener(new TwistRoateCardsView.4(paramContentFragment));
            ((ValueAnimator)localObject2).start();
            localValueAnimator.start();
            ((ObjectAnimator)localObject1).start();
            AppMethodBeat.o(203451);
            return true;
            com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.SnsAdNativeLandingPagesUI", "skip reqTwistCardId, twistCardId=" + this.EyB);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            org.xwalk.core.Log.e("TwistRoateCardsView", "parseColor exp=" + localException.toString());
            continue;
            paramContentFragment.DCv = ((int)(i * 0.75F));
            paramContentFragment.DCw = ((int)(j * 0.75F));
            continue;
            label723:
            paramContentFragment.DCC = 9;
            continue;
            label732:
            float f = 180.0F;
          }
        }
      }
    }
    com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "mEggCardComponent==null");
    AppMethodBeat.o(203451);
    return false;
  }
  
  private void refreshView()
  {
    AppMethodBeat.i(98365);
    Object localObject;
    if ((this.bizId == 2) && (!fhj()))
    {
      localObject = (FrameLayout.LayoutParams)this.ExR.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).setMargins(0, 0, 0, au.aD(this));
      this.ExR.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int i = 2131101091;
    if (!fhj())
    {
      i = getResources().getColor(2131101090);
      if ((this.Elq == null) || (this.Elq.size() <= 0) || (Util.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.Elq.getFirst()).lco))) {
        break label365;
      }
      i = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.Elq.getFirst()).lco);
    }
    label365:
    for (;;)
    {
      this.ExW.setBackgroundColor(i);
      i = 2131101090;
      localObject = this.hTd.getDrawable();
      if (localObject != null)
      {
        android.support.v4.graphics.drawable.a.a((Drawable)localObject, android.support.v4.content.b.n(this, i));
        this.hTd.setImageDrawable((Drawable)localObject);
      }
      localObject = this.BQk.getDrawable();
      if (localObject != null)
      {
        android.support.v4.graphics.drawable.a.a((Drawable)localObject, android.support.v4.content.b.n(this, i));
        this.BQk.setImageDrawable((Drawable)localObject);
      }
      if ((fhk()) && (!fhl()) && (this.bizId == 2))
      {
        this.BQk.setVisibility(8);
        this.Exw.setVisibility(0);
        this.Exw.setText(this.ExB);
        this.Exw.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(203409);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            SnsAdNativeLandingPagesUI.this.J(SnsAdNativeLandingPagesUI.this, SnsAdNativeLandingPagesUI.C(SnsAdNativeLandingPagesUI.this), SnsAdNativeLandingPagesUI.D(SnsAdNativeLandingPagesUI.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(203409);
          }
        });
        AppMethodBeat.o(98365);
        return;
      }
      if (fhh())
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "canShowMenuBtn=true, disableShareBitSet=" + this.ExS);
        this.BQk.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(203410);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            SnsAdNativeLandingPagesUI.this.fgY();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(203410);
          }
        });
        AppMethodBeat.o(98365);
        return;
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "canShowMenuBtn=false, disableShareBitSet=" + this.ExS);
      this.BQk.setVisibility(8);
      AppMethodBeat.o(98365);
      return;
    }
  }
  
  private void report()
  {
    AppMethodBeat.i(98368);
    Object localObject1 = getAllComp();
    Object localObject2 = this.Eyf.values().iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).addAll(((SnsAdLandingPageFloatView)((Iterator)localObject2).next()).getAllComp());
    }
    if (this.Eyh != null)
    {
      ((List)localObject1).add(this.Eyh);
      localObject2 = this.Eyh.fcX();
      if (localObject2 != null)
      {
        this.Eyh.fcW();
        ((List)localObject1).add(localObject2);
      }
    }
    if (this.Eyg != null)
    {
      localObject2 = this.Eyg.eXi();
      if (com.tencent.mm.plugin.sns.ad.i.c.o((Collection)localObject2)) {
        ((List)localObject1).addAll((Collection)localObject2);
      }
    }
    this.dUy += System.currentTimeMillis() - this.startTime;
    this.ExI.ElR = ((int)this.dUy);
    this.ExI.ElQ = ((List)localObject1).size();
    localObject2 = this.ExI;
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m localm = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m)((Iterator)localObject1).next();
      if (!localm.fdk().DZr)
      {
        JSONObject localJSONObject = new JSONObject();
        if ((!localm.G(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject2).ElU)) && (localm.bp(localJSONObject))) {
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject2).ElU.put(localJSONObject);
        }
      }
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "landingPage report json %s", new Object[] { this.ExI.ElU });
    localObject1 = this.ExI.feA();
    if (this.bizId == 2)
    {
      AdLandingPagesProxy.getInstance().doCgiReportCanvasBrowseInfo(15041, (String)localObject1);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "post cgi stat 15041 data: ".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(98368);
      return;
    }
    if (AdLandingPagesProxy.getInstance().isRecExpAd(this.ExI.dRS))
    {
      com.tencent.mm.plugin.report.service.h.CyF.kvStat(14650, (String)localObject1);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 14650 data: ".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(98368);
      return;
    }
    com.tencent.mm.plugin.report.service.h.CyF.kvStat(13387, (String)localObject1);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 13387 data: ".concat(String.valueOf(localObject1)));
    AppMethodBeat.o(98368);
  }
  
  private void s(ContentFragment paramContentFragment)
  {
    AppMethodBeat.i(98399);
    if (!fhv()) {
      paramContentFragment.fed();
    }
    AppMethodBeat.o(98399);
  }
  
  public final void J(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(98396);
    Intent localIntent = new Intent();
    localIntent.putExtra("sns_landig_pages_from_source", 14);
    int i;
    String str2;
    String str1;
    JSONObject localJSONObject;
    if (this.DZU == 0)
    {
      i = this.source;
      localIntent.putExtra("sns_landig_pages_origin_from_source", i);
      localIntent.putExtra("sns_landing_pages_canvasid", paramString1);
      localIntent.putExtra("sns_landing_pages_canvas_ext", paramString2);
      localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
      localIntent.putExtra("sns_landing_pages_no_store", 1);
      str2 = ((Activity)paramContext).getIntent().getStringExtra("sns_landing_pages_sessionId");
      paramString2 = ((Activity)paramContext).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
      if (!Util.isNullOrNil(str2))
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
        if (Util.isNullOrNil(paramString2)) {
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
      com.tencent.mm.br.c.b(paramContext, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
      AppMethodBeat.o(98396);
      return;
      i = this.DZU;
      break;
      paramString1 = "";
    }
  }
  
  public final void JC(long paramLong)
  {
    AppMethodBeat.i(98403);
    if ((this.Eyh == null) || (this.Exu == null))
    {
      AppMethodBeat.o(98403);
      return;
    }
    ContentFragment localContentFragment = fhn();
    if (localContentFragment == null)
    {
      AppMethodBeat.o(98403);
      return;
    }
    boolean bool1 = fhw();
    boolean bool2 = localContentFragment.feb();
    boolean bool3 = this.Eyj;
    boolean bool4 = localContentFragment.Ein;
    boolean bool5 = localContentFragment.jUX;
    boolean bool6 = localContentFragment.fea();
    boolean bool7 = this.Eyi;
    boolean bool8 = localContentFragment.feh();
    boolean bool9 = localContentFragment.feg();
    if ((bool4) && (bool8)) {
      this.Eyk = true;
    }
    if (!bool4) {
      this.Eyk = true;
    }
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SnsAdNativeLandingPagesUI", "toggleFloatBarView, isSourceAllow=" + bool1 + ", isForbid=" + bool2 + ", isKeybordShow=" + bool3 + ", isFirstPage=" + bool4 + ", isLastPage=" + bool5 + ", isCoverVideo=" + bool6 + ", isVideoCtrlBarShow=" + bool7 + ", isTopAppearOk=" + bool8 + ", isBottomAppearOk=" + bool9 + ", IsTopAppearChecked=" + this.Eyk);
    if (!bool1)
    {
      k(false, 0L);
      AppMethodBeat.o(98403);
      return;
    }
    if (bool2)
    {
      k(true, 0L);
      AppMethodBeat.o(98403);
      return;
    }
    if (bool3)
    {
      k(false, 0L);
      AppMethodBeat.o(98403);
      return;
    }
    if ((bool6) && (bool7))
    {
      k(true, 200L);
      AppMethodBeat.o(98403);
      return;
    }
    if ((bool5) && (!bool9))
    {
      k(true, 0L);
      AppMethodBeat.o(98403);
      return;
    }
    if ((bool4) && (!bool8) && (!this.Eyk))
    {
      AppMethodBeat.o(98403);
      return;
    }
    JP(paramLong);
    AppMethodBeat.o(98403);
  }
  
  public final void a(final z paramz, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, final boolean paramBoolean3)
  {
    AppMethodBeat.i(98395);
    if ((this.EyQ != null) && (!paramBoolean3))
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.SnsAdNativeLandingPagesUI", "bottom sheet appear several times");
      this.EyQ.bMo();
      if (this.EyR != null)
      {
        this.EyR.dismiss();
        this.EyR = null;
      }
      AppMethodBeat.o(98395);
      return;
    }
    AdLandingPagesProxy.e local24 = new AdLandingPagesProxy.e()
    {
      public final void bn(Object paramAnonymousObject) {}
      
      public final void h(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(203435);
        SnsAdNativeLandingPagesUI.this.vp(false);
        if (paramBoolean3)
        {
          if (SnsAdNativeLandingPagesUI.ab(SnsAdNativeLandingPagesUI.this) != null) {
            SnsAdNativeLandingPagesUI.ab(SnsAdNativeLandingPagesUI.this).bMo();
          }
          if (SnsAdNativeLandingPagesUI.ac(SnsAdNativeLandingPagesUI.this) != null)
          {
            SnsAdNativeLandingPagesUI.ac(SnsAdNativeLandingPagesUI.this).dismiss();
            SnsAdNativeLandingPagesUI.ad(SnsAdNativeLandingPagesUI.this);
          }
        }
        AppMethodBeat.o(203435);
      }
    };
    AppCompatActivity localAppCompatActivity;
    LinearLayout localLinearLayout;
    if (!paramBoolean3)
    {
      localAppCompatActivity = getContext();
      localLinearLayout = new LinearLayout(getContext());
      if (Util.isNullOrNil(paramz.DZn)) {
        break label223;
      }
    }
    label223:
    for (int i = Color.parseColor(paramz.DZn);; i = -1)
    {
      paramz = ay.a(localAppCompatActivity, paramz, localLinearLayout, i);
      this.EyQ = new n(getContext(), paramz, paramString1, paramString2, paramString3, paramBoolean1, paramBoolean2);
      paramz = paramz.getView();
      this.EyQ.Edg = new n.a()
      {
        private void onRemove()
        {
          AppMethodBeat.i(203438);
          if ((paramz != null) && (paramz.getParent() != null)) {
            ((ViewGroup)paramz.getParent()).removeView(paramz);
          }
          SnsAdNativeLandingPagesUI.ae(SnsAdNativeLandingPagesUI.this);
          AppMethodBeat.o(203438);
        }
        
        public final void fdt()
        {
          AppMethodBeat.i(203436);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "onDismiss");
          onRemove();
          AppMethodBeat.o(203436);
        }
        
        public final void fdu()
        {
          AppMethodBeat.i(203437);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "onCancel");
          onRemove();
          AppMethodBeat.o(203437);
        }
      };
      this.EyQ.dGm();
      if (!Util.isNullOrNil(paramString1))
      {
        AdLandingPagesProxy.getInstance().doFavOfficialItemScene(paramString1, local24);
        if (paramBoolean3) {
          this.EyR = com.tencent.mm.ui.base.h.a(this, getString(2131766113), false, null);
        }
      }
      AppMethodBeat.o(98395);
      return;
    }
  }
  
  public boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  public final void cvQ()
  {
    AppMethodBeat.i(98384);
    Object localObject;
    try
    {
      Iterator localIterator1 = this.Eyf.values().iterator();
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
      com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.SnsAdNativeLandingPagesUI", localException, "play exit animation error", new Object[0]);
      finish();
      AppMethodBeat.o(98384);
      return;
    }
    fgX();
    fgZ();
    report();
    this.ExK = true;
    this.ExW.setVisibility(8);
    if (!this.Exx)
    {
      finish();
      AppMethodBeat.o(98384);
      return;
    }
    if (this.Eyd)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "is playing animation");
      AppMethodBeat.o(98384);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "run exit animation, %s", new Object[] { Boolean.valueOf(this.Exx) });
    this.Eyd = true;
    if (isSupportNavigationSwipeBack()) {
      getSwipeBackLayout().setEnableGesture(false);
    }
    Iterator localIterator2 = fhn().fdY().iterator();
    while (localIterator2.hasNext())
    {
      localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m)localIterator2.next();
      if ((localObject instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a))
      {
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject).fcJ();
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m)localObject).fdq();
      }
    }
    fgS();
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(203427);
        SnsAdNativeLandingPagesUI.Z(SnsAdNativeLandingPagesUI.this);
        AppMethodBeat.o(203427);
      }
    }, 30L);
    AppMethodBeat.o(98384);
  }
  
  public final com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah fds()
  {
    AppMethodBeat.i(203450);
    if (this.DJT == null) {
      this.DJT = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah();
    }
    Object localObject1 = this.DJT;
    int i;
    Object localObject2;
    label182:
    boolean bool;
    if (this.DZU == 0)
    {
      i = this.source;
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)localObject1).DZU = i;
      this.DJT.source = this.source;
      this.DJT.DZV = this.ExH;
      this.DJT.uxInfo = this.uxInfo;
      this.DJT.DZW = this.DZW;
      this.DJT.uin = this.uin;
      this.DJT.bizId = this.bizId;
      this.DJT.aid = this.aid;
      this.DJT.kZe = this.kZe;
      localObject1 = this.DJT;
      localObject2 = this.Eaa;
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)localObject1).Eaa.putAll((Map)localObject2);
      localObject2 = this.DJT;
      if (this.ExI == null) {
        break label346;
      }
      localObject1 = this.ExI.lAN;
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)localObject2).lAN = ((String)localObject1);
      localObject1 = this.DJT;
      if (this.Exu == null) {
        break label354;
      }
      bool = true;
      label204:
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)localObject1).DZX = bool;
    }
    for (;;)
    {
      try
      {
        localObject2 = this.DJT;
        if (!Util.isNullOrNil(this.dRS)) {
          continue;
        }
        if (this.ExI == null) {
          continue;
        }
        localObject1 = String.valueOf(com.tencent.mm.plugin.sns.data.k.aOa(this.ExI.dRS));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)localObject2).dRS = ((String)localObject1);
      }
      catch (Throwable localThrowable)
      {
        label346:
        label354:
        long l;
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", localThrowable.toString());
        continue;
      }
      if (!Util.isNullOrNil(new String[] { this.viewId, this.DZY }))
      {
        this.DJT.viewId = this.viewId;
        this.DJT.DZY = this.DZY;
      }
      this.DJT.adExtInfo = this.adExtInfo;
      this.DJT.DZZ = this.DZZ;
      localObject1 = this.DJT;
      AppMethodBeat.o(203450);
      return localObject1;
      i = this.DZU;
      break;
      localObject1 = "";
      break label182;
      bool = false;
      break label204;
      localObject1 = "";
      continue;
      l = com.tencent.mm.plugin.sns.data.k.aOa(this.dRS);
      localObject1 = String.valueOf(l);
    }
  }
  
  public final void fgY()
  {
    AppMethodBeat.i(203447);
    if (this.BQk.getVisibility() != 0)
    {
      AppMethodBeat.o(203447);
      return;
    }
    fgX();
    this.Eys = new com.tencent.mm.ui.widget.a.e(this, 1, false);
    this.Eys.HLX = new o.f()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
      {
        AppMethodBeat.i(203411);
        if ((SnsAdNativeLandingPagesUI.E(SnsAdNativeLandingPagesUI.this) == 0) || ((SnsAdNativeLandingPagesUI.E(SnsAdNativeLandingPagesUI.this) & 0x2) == 0)) {
          paramAnonymousm.b(1, SnsAdNativeLandingPagesUI.this.getString(2131764635), 2131689844);
        }
        if ((SnsAdNativeLandingPagesUI.E(SnsAdNativeLandingPagesUI.this) == 0) || ((SnsAdNativeLandingPagesUI.E(SnsAdNativeLandingPagesUI.this) & 0x1) == 0)) {
          paramAnonymousm.b(2, SnsAdNativeLandingPagesUI.this.getString(2131765993), 2131689830);
        }
        if (((SnsAdNativeLandingPagesUI.E(SnsAdNativeLandingPagesUI.this) == 0) || ((SnsAdNativeLandingPagesUI.E(SnsAdNativeLandingPagesUI.this) & 0x4) == 0)) && (SnsAdNativeLandingPagesUI.y(SnsAdNativeLandingPagesUI.this) != 7)) {
          paramAnonymousm.b(3, SnsAdNativeLandingPagesUI.this.getString(2131757361), 2131689821);
        }
        if (((SnsAdNativeLandingPagesUI.E(SnsAdNativeLandingPagesUI.this) == 0) || (SnsAdNativeLandingPagesUI.F(SnsAdNativeLandingPagesUI.this))) && (SnsAdNativeLandingPagesUI.x(SnsAdNativeLandingPagesUI.this) == 2) && (SnsAdNativeLandingPagesUI.G(SnsAdNativeLandingPagesUI.this))) {
          if (SnsAdNativeLandingPagesUI.H(SnsAdNativeLandingPagesUI.this) == null) {
            break label269;
          }
        }
        label269:
        for (String str = SnsAdNativeLandingPagesUI.H(SnsAdNativeLandingPagesUI.this);; str = "")
        {
          paramAnonymousm.b(4, str, 0);
          if (((SnsAdNativeLandingPagesUI.E(SnsAdNativeLandingPagesUI.this) == 0) || ((SnsAdNativeLandingPagesUI.E(SnsAdNativeLandingPagesUI.this) & 0x20) == 0)) && (SnsAdNativeLandingPagesUI.I(SnsAdNativeLandingPagesUI.this) != null) && (SnsAdNativeLandingPagesUI.I(SnsAdNativeLandingPagesUI.this).EWp != null)) {
            paramAnonymousm.b(5, SnsAdNativeLandingPagesUI.this.getString(2131765991), 0);
          }
          AppMethodBeat.o(203411);
          return;
        }
      }
    };
    this.Eys.mLO = true;
    this.Eys.HLY = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(203412);
        ap.aK(SnsAdNativeLandingPagesUI.this);
        if (paramAnonymousMenuItem != null) {
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(203412);
          return;
          SnsAdNativeLandingPagesUI.J(SnsAdNativeLandingPagesUI.this);
          AppMethodBeat.o(203412);
          return;
          SnsAdNativeLandingPagesUI.K(SnsAdNativeLandingPagesUI.this);
          AppMethodBeat.o(203412);
          return;
          SnsAdNativeLandingPagesUI.L(SnsAdNativeLandingPagesUI.this);
          AppMethodBeat.o(203412);
          return;
          SnsAdNativeLandingPagesUI.this.J(SnsAdNativeLandingPagesUI.this, SnsAdNativeLandingPagesUI.C(SnsAdNativeLandingPagesUI.this), SnsAdNativeLandingPagesUI.D(SnsAdNativeLandingPagesUI.this));
          AppMethodBeat.o(203412);
          return;
          SnsAdNativeLandingPagesUI.M(SnsAdNativeLandingPagesUI.this);
        }
      }
    };
    hideVKB();
    this.Eys.dGm();
    AppMethodBeat.o(203447);
  }
  
  public final void fhr()
  {
    AppMethodBeat.i(203452);
    try
    {
      boolean bool = fhs();
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "jumpNextPage, hasNextPage=".concat(String.valueOf(bool)));
      if (bool) {
        this.ExR.setCurrentItem$2563266(this.ExR.getCurrentItem() + 1);
      }
      AppMethodBeat.o(203452);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "jumpNextPage exp:" + localException.toString());
      AppMethodBeat.o(203452);
    }
  }
  
  public final boolean fhs()
  {
    AppMethodBeat.i(98397);
    try
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.ExR.getAdapter();
      int i = this.ExR.getCurrentItem();
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "hasNextPage, curPage=" + i + ", pageCount=" + localb.getCount());
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
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "hasNextPage exp:" + localException.toString());
      AppMethodBeat.o(98397);
    }
    return true;
  }
  
  public final boolean fhv()
  {
    AppMethodBeat.i(98400);
    if (this.Eyh != null)
    {
      boolean bool = this.Eyh.isShowing();
      AppMethodBeat.o(98400);
      return bool;
    }
    AppMethodBeat.o(98400);
    return false;
  }
  
  public final List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m> getAllComp()
  {
    AppMethodBeat.i(98380);
    this.ExZ = new ArrayList();
    Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.ExR.getAdapter();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)localObject).fragments.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Fragment localFragment = (Fragment)((Iterator)localObject).next();
        this.ExZ.addAll(((ContentFragment)localFragment).fdY());
      }
    }
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.gU(this.ExZ);
    localObject = this.ExZ;
    AppMethodBeat.o(98380);
    return localObject;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496402;
  }
  
  @TargetApi(16)
  public void initView()
  {
    AppMethodBeat.i(98381);
    super.initView();
    this.ExV = ((FrameLayout)findViewById(2131307157));
    this.ExX = findViewById(2131299195);
    this.ExR = ((AdlandingDummyViewPager)findViewById(2131309711));
    this.ExW = findViewById(2131304605);
    this.Eyu = ((TwistRoateCardsView)findViewById(2131309552));
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "before, assistActivity");
    Object localObject;
    if (ao.aQ(getContext()))
    {
      final int i = ao.aP(this);
      localObject = (FrameLayout.LayoutParams)this.ExV.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).height = (this.mEY - i);
      ((FrameLayout.LayoutParams)localObject).topMargin = i;
      this.ExV.setLayoutParams((ViewGroup.LayoutParams)localObject);
      getController().setActionbarColor(getResources().getColor(2131099891));
      this.ExV.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(203414);
          try
          {
            paramAnonymousView = new Rect();
            SnsAdNativeLandingPagesUI.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(paramAnonymousView);
            paramAnonymousInt1 = paramAnonymousView.top;
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "rect=" + paramAnonymousView.toString() + ", screenH=" + SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this) + ", cutH=" + i + ", statusBarH=" + paramAnonymousInt1);
            if (paramAnonymousInt1 > 0)
            {
              if (paramAnonymousInt1 != i)
              {
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "cutH != statusBarH, reset height");
                paramAnonymousView = (FrameLayout.LayoutParams)SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).getLayoutParams();
                paramAnonymousView.height = (SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this) - paramAnonymousInt1);
                paramAnonymousView.topMargin = paramAnonymousInt1;
                SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).setLayoutParams(paramAnonymousView);
                j.b(j.DEb, "", i, paramAnonymousInt1, SnsAdNativeLandingPagesUI.S(SnsAdNativeLandingPagesUI.this) + "|" + SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this));
              }
              SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).removeOnLayoutChangeListener(this);
            }
            AppMethodBeat.o(203414);
            return;
          }
          catch (Throwable paramAnonymousView)
          {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "onLayoutChange error:" + paramAnonymousView.toString());
            SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).removeOnLayoutChangeListener(this);
            AppMethodBeat.o(203414);
          }
        }
      });
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(203415);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "hasCutOut, assistActivity");
          com.tencent.mm.ui.b.a(SnsAdNativeLandingPagesUI.this, true, SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this), SnsAdNativeLandingPagesUI.this.EyO);
          AppMethodBeat.o(203415);
        }
      }, 1500L);
    }
    for (;;)
    {
      this.jUG = ((ImageView)findViewById(2131301854));
      this.Exv = ((ImageView)findViewById(2131296759));
      this.hTd = ((ImageView)findViewById(2131308037));
      this.hTd.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(203416);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (SnsAdNativeLandingPagesUI.this.keyboardState() == 1) {
            SnsAdNativeLandingPagesUI.this.hideVKB();
          }
          SnsAdNativeLandingPagesUI.this.cvQ();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203416);
        }
      });
      this.BQk = ((ImageView)findViewById(2131308054));
      this.Exw = ((TextView)findViewById(2131308055));
      this.ExE = ((ImageView)findViewById(2131308170));
      if (!this.Eyw) {
        break;
      }
      this.Exv.setVisibility(8);
      if (!this.Eyx)
      {
        localObject = ObjectAnimator.ofFloat(this.jUG, "alpha", new float[] { 0.0F, 0.2F });
        ((ObjectAnimator)localObject).setDuration(200L);
        ((ObjectAnimator)localObject).start();
        this.ExX.setAlpha(0.0F);
      }
      com.tencent.mm.ui.base.b.a(this, null);
      AppMethodBeat.o(98381);
      return;
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98342);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "noCutOut, assistActivity");
          com.tencent.mm.ui.b.a(SnsAdNativeLandingPagesUI.this, false, SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this), SnsAdNativeLandingPagesUI.this.EyO);
          AppMethodBeat.o(98342);
        }
      }, 1500L);
    }
    if (this.Exx)
    {
      this.ExV.setAlpha(0.0F);
      this.jUG.setAlpha(0.0F);
      com.tencent.mm.ui.base.b.a(this, null);
    }
    AppMethodBeat.o(98381);
  }
  
  public final void k(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(98402);
    if (this.Eyh != null)
    {
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SnsAdNativeLandingPagesUI", "hideFloatBarView");
      this.Eyh.j(paramBoolean, paramLong);
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
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "share to timeLine success");
        str = Util.nullAsNil(this.uxInfo);
        localObject3 = Util.nullAsNil(this.ExI.lAN);
      }
    }
    for (;;)
    {
      try
      {
        str = com.tencent.mm.plugin.sns.a.b.A("3", "", str, (String)localObject3);
        com.tencent.mm.sdk.platformtools.Log.i("AntiCheatingReportUtils", "reportScreenShotParams = ".concat(String.valueOf(str)));
        com.tencent.mm.plugin.report.service.h.CyF.kvStat(19214, str);
        com.tencent.mm.ui.base.h.cD(getContext(), getContext().getString(2131755986));
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        AppMethodBeat.o(98392);
        return;
      }
      catch (Throwable localThrowable1)
      {
        com.tencent.mm.sdk.platformtools.Log.e("AntiCheatingReportUtils", localThrowable1.toString());
        continue;
      }
      if (paramInt1 == 2)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "handleOpenInBrowserResult, ret=".concat(String.valueOf(((aa)com.tencent.mm.kernel.g.af(aa.class)).a(this, paramInt1, paramInt2, paramIntent))));
      }
      else
      {
        int i;
        if (paramInt1 == 2002)
        {
          if (com.tencent.mm.plugin.sns.ad.i.g.getBooleanExtra(paramIntent, "kfavorite", false))
          {
            i = AdLandingPagesProxy.getInstance().doFav(paramIntent, 42);
            ((com.tencent.mm.plugin.fav.a.v)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fav.a.v.class)).a(i, 42, this, this.xxK);
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
                localObject4 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m)((Iterator)localObject3).next();
              } while (!((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m)localObject4).fdn().equals(localObject1));
              localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah)localObject4;
              i = paramIntent.getIntExtra("KStreamVideoPlayCount", 0);
              j = paramIntent.getIntExtra("KStreamVideoPlayCompleteCount", 0);
              k = paramIntent.getIntExtra("KStreamVideoTotalPlayTimeInMs", 0);
              ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah)localObject1).DvS = (i + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah)localObject1).DvS);
              ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah)localObject1).DvT += j;
              ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah)localObject1).DvU += k;
            }
            catch (Exception localException) {}
          }
          else
          {
            Object localObject2;
            if (paramInt1 == 2003)
            {
              localObject2 = new vf();
              ((vf)localObject2).ebD.EX = 1;
              ((vf)localObject2).ebD.requestCode = paramInt1;
              ((vf)localObject2).ebD.resultCode = paramInt2;
              ((vf)localObject2).ebD.dQs = paramIntent;
              EventCenter.instance.publish((IEvent)localObject2);
            }
            else if (paramInt1 == 2000)
            {
              boolean bool1;
              boolean bool2;
              int m;
              int n;
              int i1;
              int i2;
              long l1;
              boolean bool3;
              int i3;
              long l2;
              try
              {
                localObject2 = paramIntent.getStringExtra("KComponentCid");
                localObject4 = getAllComp().iterator();
                do
                {
                  if (!((Iterator)localObject4).hasNext()) {
                    break;
                  }
                  localObject3 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m)((Iterator)localObject4).next();
                } while (!((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m)localObject3).fdn().equals(localObject2));
                i = paramIntent.getIntExtra("KComponentVideoType", 0);
                j = paramIntent.getIntExtra("KComponentCurrentTime", 0);
                bool1 = paramIntent.getBooleanExtra("KComponentVoiceType", false);
                bool2 = paramIntent.getBooleanExtra("KComponentProgressType", false);
                k = paramIntent.getIntExtra("KComponentClickPlayControlCount", 0);
                m = paramIntent.getIntExtra("KComponentDoubleClickCount", 0);
                n = paramIntent.getIntExtra("KComponentClickVoiceControlCount", 0);
                i1 = paramIntent.getIntExtra("KComponentPlayCompletedCount", 0);
                i2 = paramIntent.getIntExtra("KComponentPlayCount", 0);
                l1 = paramIntent.getLongExtra("KComponentPlayTimeInterval", 0L);
                bool3 = paramIntent.getBooleanExtra("KComponentIsWaiting", false);
                i3 = paramIntent.getIntExtra("KComponentSeekTimeDueWaiting", 0);
                localObject4 = paramIntent.getStringExtra("KComponentFullVideoFloatBarReportInfo");
                l2 = paramIntent.getLongExtra("KComponentFullScreenStayTime", 0L);
                this.dUy += l2;
                com.tencent.mm.sdk.platformtools.Log.i("VideoFullScreenActivity", "videoType = " + i + ", cid = " + (String)localObject2 + ", currPosSec = " + j + ", bNoVoice = " + bool1 + ", isPlaying = " + bool2 + ", clickPlayControlCount = " + k + ", doubleClickCount = " + m + ", clickVoiceControlCount = " + n + ", playCompletedCount = " + i1 + ", playCount = " + i2 + ", playTimeInterval = " + l1 + ", floatBarReportInfo = " + (String)localObject4 + ", fullScreenStayTime = " + l2);
                if (i != 0) {
                  break label867;
                }
                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah)localObject3).a(j, bool1, bool2, k, m, n, i1, i2, l1, (String)localObject4, l2);
              }
              catch (Throwable localThrowable2)
              {
                com.tencent.mm.sdk.platformtools.Log.e("VideoFullScreenActivity", localThrowable2.toString());
              }
              continue;
              label867:
              if (i == 1) {
                ((al)localObject3).a(j, bool1, bool2, k, m, n, i1, i2, l1, bool3, i3, (String)localObject4, l2);
              }
            }
          }
        }
      }
    }
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(203448);
    super.onAttachedToWindow();
    fgS();
    AppMethodBeat.o(203448);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(98386);
    cvQ();
    AppMethodBeat.o(98386);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool2 = true;
    AppMethodBeat.i(98363);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SnsAdNativeLandingPagesUI.launch", "onCreate");
    this.startTime = System.currentTimeMillis();
    this.enterTime = System.currentTimeMillis();
    this.ExI.enterTime = this.enterTime;
    ap.aK(this);
    Object localObject = ap.ha(this);
    this.mEX = localObject[0];
    this.mEY = localObject[1];
    this.savedInstanceState = paramBundle;
    this.mController.hideTitleView();
    this.qaF = getIntent().getIntExtra("img_gallery_top", 0);
    int i;
    if (ao.aQ(this))
    {
      i = ao.aP(this);
      this.qaF -= i;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "hasCutOut, h=" + i + ", thumbTop=" + this.qaF);
    }
    this.qaG = getIntent().getIntExtra("img_gallery_left", 0);
    this.qaH = getIntent().getIntExtra("img_gallery_width", 0);
    this.qaI = getIntent().getIntExtra("img_gallery_height", 0);
    getWindow().addFlags(128);
    this.isVisible = false;
    this.Eym = false;
    this.Eyn = false;
    this.Eyo = false;
    if (this.Eyp != null) {
      this.Eyp.removeCallbacks(this.EyK);
    }
    this.source = getIntent().getIntExtra("sns_landig_pages_from_source", 0);
    this.DZU = getIntent().getIntExtra("sns_landig_pages_origin_from_source", 0);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "source=" + this.source + ", originScene=" + this.DZU);
    this.Exz = getIntent().getStringExtra("sns_landing_pages_xml");
    paramBundle = getIntent().getStringExtra("sns_landing_pages_too_large_xml_path");
    if ((Util.isNullOrNil(this.Exz)) && (!Util.isNullOrNil(paramBundle))) {
      this.Exz = ap.aQd(paramBundle);
    }
    if (Util.isNullOrNil(this.Exz))
    {
      finish();
      initView();
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SnsAdNativeLandingPagesUI.launch", "before AdLandingPagesProxy connect");
      if (AdLandingPagesProxy.getInstance().isConnected()) {
        break label1699;
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "isConnected==false");
      AdLandingPagesProxy.getInstance().connect(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98360);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "after Connected");
          SnsAdNativeLandingPagesUI.B(SnsAdNativeLandingPagesUI.this);
          AppMethodBeat.o(98360);
        }
      });
    }
    for (;;)
    {
      EventCenter.instance.addListener(this.EyJ);
      try
      {
        registerReceiver(this.EyP, new IntentFilter("android.intent.action.SCREEN_ON"));
        AppMethodBeat.o(98363);
        return;
      }
      catch (Exception paramBundle)
      {
        boolean bool1;
        boolean bool3;
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "registerReceiver, exp=" + paramBundle.toString());
        AppMethodBeat.o(98363);
      }
      this.Exz = this.Exz.replaceAll("</*RecXml[\\s|\\S]*?>", "");
      this.ExI.DQS = getIntent().getStringExtra("sns_landing_pages_expid");
      this.ExA = getIntent().getStringExtra("sns_landing_pages_xml_prefix");
      this.dRS = getIntent().getStringExtra("sns_landing_pages_share_sns_id");
      this.ExG = getIntent().getStringExtra("sns_landing_pages_rawSnsId");
      this.uxInfo = getIntent().getStringExtra("sns_landing_pages_ux_info");
      this.aid = getIntent().getStringExtra("sns_landing_pages_aid");
      this.kZe = getIntent().getStringExtra("sns_landing_pages_traceid");
      paramBundle = getIntent().getStringExtra("sns_landing_pages_search_extra");
      localObject = this.ExI;
      if (!TextUtils.isEmpty(paramBundle))
      {
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra.length() > 0) {
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra += "&";
        }
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra = (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra + "searchextra=" + URLEncoder.encode(paramBundle));
      }
      paramBundle = getIntent().getStringExtra("sns_landing_pages_extra");
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "initParams, extraData=".concat(String.valueOf(paramBundle)));
      localObject = this.ExI;
      if (!TextUtils.isEmpty(paramBundle))
      {
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra.length() > 0) {
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra += "&";
        }
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra += URLEncoder.encode(paramBundle);
      }
      this.ExH = getIntent().getBooleanExtra("sns_landing_is_native_sight_ad", false);
      this.recSrc = getIntent().getIntExtra("sns_landing_pages_rec_src", 0);
      this.ExL = getIntent().getIntExtra("sns_landing_pages_from_outer_index", 0);
      this.lAP = getIntent().getStringExtra("sns_landing_pages_ad_info");
      this.Exx = getIntent().getBooleanExtra("sns_landing_pages_need_enter_and_exit_animation", false);
      this.Exy = getIntent().getBooleanExtra("sns_landing_pages_is_normal_ad_animation", false);
      this.DZZ = getIntent().getLongExtra("sns_landing_page_sight_video_seek_time", 0L);
      this.ExI.rna = this.source;
      this.ExI.ElM = 0;
      this.ExI.ElN = 0;
      this.ExI.ElO = 1;
      this.ExI.ElP = 0;
      this.ExI.DZU = this.DZU;
      if ((this.ExA == null) || ("".equals(this.Exz))) {
        this.ExA = "adxml";
      }
      if ((Util.isNullOrNil(this.Exz)) || (Util.isNullOrNil(this.ExA)))
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "landingPagesXml is " + this.Exz + ",landingPagesXmlPrex is " + this.ExA);
        break;
      }
      this.values = XmlParser.parseXml(this.Exz, this.ExA, null);
      if (this.values != null)
      {
        this.ExI.lAN = Util.nullAs((String)this.values.get("." + this.ExA + ".adCanvasInfo.id"), "");
        this.Eyq = Util.nullAs((String)this.values.get("." + this.ExA + ".adExtInfo"), "");
        this.adExtInfo = com.tencent.mm.plugin.sns.data.i.aNZ(this.Eyq);
        if (Util.safeParseInt((String)this.values.get("." + this.ExA + ".forbiddenLeftSwipe")) == 1)
        {
          bool1 = true;
          label1222:
          this.Eyt = bool1;
          if (Util.safeParseInt((String)this.values.get("." + this.ExA + ".forbiddenCustomAnimation")) != 1) {
            break label1557;
          }
          bool1 = true;
          label1274:
          this.forbiddenCustomAnimation = bool1;
          label1279:
          if (this.forbiddenCustomAnimation)
          {
            this.Exx = false;
            this.Exy = false;
          }
          if (!this.Exx) {
            break label1574;
          }
          this.ExI.gYH = 0;
          this.ExI.gmJ = 0;
          label1319:
          this.EyB = getIntent().getStringExtra("sns_landing_page_is_gesture_twist_card_id");
          if (this.values != null) {
            this.Eyv = ADXml.k.J(this.values, "." + this.ExA + ".adTwistInfo");
          }
          bool1 = ADXml.k.aPT(this.Exz);
          bool3 = getIntent().getBooleanExtra("sns_landing_page_is_gesture_twist_ad", false);
          if (this.Eyv != null)
          {
            if (!bool1) {
              break label1671;
            }
            if (!bool3) {
              break label1593;
            }
            this.Eyw = true;
            this.Eyx = false;
          }
          label1424:
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "isSharedTypeTwistAnim=" + this.Eyx + ", isTwistAdAnim=" + this.Eyw + ", intent twistCardId=" + this.EyB + ", isSimpleTwistAnim=" + this.Eyy);
          if (this.values == null) {
            break;
          }
          if (Util.safeParseInt((String)this.values.get("." + this.ExA + ".preloadWeAppPkg")) != 1) {
            break label1694;
          }
        }
      }
      label1557:
      label1694:
      for (bool1 = bool2;; bool1 = false)
      {
        this.preloadWeAppPkg = bool1;
        break;
        bool1 = false;
        break label1222;
        bool1 = false;
        break label1274;
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "initParams, values is null");
        break label1279;
        label1574:
        this.ExI.gYH = 1;
        this.ExI.gmJ = 1;
        break label1319;
        label1593:
        i = this.source;
        if ((i == 1) || (i == 2) || (i == 16)) {}
        for (bool1 = true;; bool1 = false)
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "isFromShare, source=" + i + ", ret=" + bool1);
          if (bool1) {
            break;
          }
          this.Eyw = true;
          this.Eyx = true;
          break;
        }
        if ((!bool3) || (!this.Eyv.DWW)) {
          break label1424;
        }
        this.Eyy = true;
        break label1424;
      }
      label1671:
      label1699:
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "isConnected==true");
      fgT();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98366);
    getWindow().clearFlags(128);
    if (this.Eyp != null) {
      this.Eyp.removeCallbacks(this.EyK);
    }
    if (this.Eyh != null) {
      this.Eyh.eXd();
    }
    if (this.aMp)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "the SnsAdNativeLadingPagesUI is destroy, bHandleExit=" + this.ExK);
      if (!this.ExK)
      {
        fgZ();
        report();
      }
    }
    for (;;)
    {
      this.Eyf.clear();
      Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.ExR.getAdapter();
      if (localObject != null) {
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)localObject).fragments.clear();
      }
      try
      {
        unregisterReceiver(this.EyP);
        EventCenter.instance.removeListener(this.EyJ);
      }
      catch (Exception localException)
      {
        try
        {
          localObject = new vc();
          ((vc)localObject).ebu.ebv = 5;
          EventCenter.instance.publish((IEvent)localObject);
          label172:
          AdLandingPagesProxy.getInstance().clearCallback();
          super.onDestroy();
          AppMethodBeat.o(98366);
          return;
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "onDestroy, isConnected=false");
          continue;
          localException = localException;
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "unregisterReceiver, exp=" + localException.toString());
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
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "onKeyboardStateChanged, state=" + keyboardState());
    if (this.ExR != null) {
      this.ExR.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(203433);
          if (SnsAdNativeLandingPagesUI.this.keyboardState() != 1) {
            ap.aK(SnsAdNativeLandingPagesUI.this);
          }
          if (!SnsAdNativeLandingPagesUI.aa(SnsAdNativeLandingPagesUI.this))
          {
            new ArrayList();
            Iterator localIterator = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getAdapter()).fragments.iterator();
            while (localIterator.hasNext())
            {
              ContentFragment localContentFragment = (ContentFragment)localIterator.next();
              SnsAdNativeLandingPagesUI.this.keyboardState();
              localContentFragment.fdZ();
            }
          }
          AppMethodBeat.o(203433);
        }
      }, 500L);
    }
    AppMethodBeat.o(98393);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(98372);
    super.onPause();
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "onPause");
    this.Eye = true;
    if (this.aMp) {
      this.dUy += System.currentTimeMillis() - this.startTime;
    }
    try
    {
      ScreenShotUtil.setScreenShotCallback(this, null);
      this.ExJ = false;
      if (fhe())
      {
        Iterator localIterator = this.Eyf.values().iterator();
        while (localIterator.hasNext()) {
          ((SnsAdLandingPageFloatView)localIterator.next()).onPause();
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", localThrowable.toString());
      }
      AdlandingDummyViewPager localAdlandingDummyViewPager = this.ExR;
      ViewPager.OnPageChangeListener localOnPageChangeListener = this.EyG;
      localAdlandingDummyViewPager.Eia.remove(localOnPageChangeListener);
      android.support.v4.content.d.W(this).unregisterReceiver(this.EyC);
      android.support.v4.content.d.W(this).unregisterReceiver(this.EyD);
      EventCenter.instance.removeListener(this.EyI);
      if (this.EyQ != null) {
        this.EyQ.bMo();
      }
      if ((this.Eyh != null) && (this.Eyh.isShowing())) {
        this.Eyh.eXa();
      }
      AppMethodBeat.o(98372);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98371);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "onResume");
    super.onResume();
    if ((this.Eyt) && (isSupportNavigationSwipeBack())) {
      getSwipeBackLayout().setEnableGesture(false);
    }
    try
    {
      if (!this.ExJ)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "onResume callback");
        ScreenShotUtil.setScreenShotCallback(this, this.EyL);
        this.ExJ = true;
      }
      ap.aK(this);
      if (fhe())
      {
        i = this.ExV.getChildCount() - 1;
        if (i >= 0)
        {
          Object localObject = this.ExV.getChildAt(i);
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
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", localThrowable.toString());
        continue;
        i -= 1;
        continue;
        localAdlandingDummyViewPager = null;
      }
      this.Eye = false;
      AdlandingDummyViewPager localAdlandingDummyViewPager = this.ExR;
      ViewPager.OnPageChangeListener localOnPageChangeListener = this.EyG;
      localAdlandingDummyViewPager.Eia.add(localOnPageChangeListener);
      android.support.v4.content.d.W(this).a(this.EyC, new IntentFilter("com.tencent.mm.adlanding.video_progressbar_change"));
      android.support.v4.content.d.W(this).a(this.EyD, new IntentFilter("com.tencent.mm.adlanding.set_uioption"));
      if (this.aMp) {
        this.startTime = System.currentTimeMillis();
      }
      EventCenter.instance.addListener(this.EyI);
      if (this.ExM) {
        vp(false);
      }
      if ((this.Eyh != null) && (this.Eyh.isShowing())) {
        this.Eyh.eWZ();
      }
      AppMethodBeat.o(98371);
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(179183);
    super.onStart();
    this.isVisible = true;
    if (this.aMp) {
      try
      {
        if ((!Util.isNullOrNil(new String[] { this.viewId, this.DZY })) && (!this.Eyn))
        {
          if (this.Eyo)
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "execute mValidExposure onStart immediately");
            fhd();
            AppMethodBeat.o(179183);
            return;
          }
          if (this.Eyp != null)
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "execute mValidExposureRunnable onStart");
            this.Eyp.removeCallbacks(this.EyK);
            this.Eyp.postDelayed(this.EyK, 1000L);
          }
        }
        AppMethodBeat.o(179183);
        return;
      }
      catch (Throwable localThrowable)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", localThrowable.toString());
      }
    }
    AppMethodBeat.o(179183);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(179184);
    super.onStop();
    this.isVisible = false;
    if (this.Eyp != null) {
      this.Eyp.removeCallbacks(this.EyK);
    }
    AppMethodBeat.o(179184);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(98373);
    this.ExI.gmJ = 2;
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k localk = this.ExI;
    localk.ElP += 1;
    super.onSwipeBack();
    try
    {
      hideVKB();
      AppMethodBeat.o(98373);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "onSwipeBack hideVKB exp=" + localException.toString());
      AppMethodBeat.o(98373);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(203449);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean) {}
    try
    {
      ScreenShotUtil.setScreenShotCallback(this, null);
      this.ExJ = false;
      AppMethodBeat.o(203449);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", localThrowable.toString());
      AppMethodBeat.o(203449);
    }
    if (!this.ExJ)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "onWindowFocusChanged callback");
      ScreenShotUtil.setScreenShotCallback(this, this.EyL);
      this.ExJ = true;
    }
    AppMethodBeat.o(203449);
    return;
  }
  
  public final void vp(boolean paramBoolean)
  {
    AppMethodBeat.i(98394);
    if ((paramBoolean) && (this.bizId == 1)) {
      AdLandingPagesProxy.getInstance().doDynamicUpdateScene(this.ExN, this.ExO, this.ExP, this.EyH);
    }
    if ((this.bizId == 2) && (!Util.isNullOrNil(this.ExQ))) {
      AdLandingPagesProxy.getInstance().doSearchDynamicUpdateScene(this.ExQ, this.EyH);
    }
    this.ExM = true;
    AppMethodBeat.o(98394);
  }
  
  final class a
  {
    public String DXa = "";
    public String msN = "";
    public String xDQ = "";
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI
 * JD-Core Version:    0.7.0.1
 */