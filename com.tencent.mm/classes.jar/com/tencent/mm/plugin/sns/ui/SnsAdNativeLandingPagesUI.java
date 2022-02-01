package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.app.Activity;
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
import android.text.TextUtils;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
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
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import androidx.viewpager.widget.ViewPager.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.py;
import com.tencent.mm.f.a.py.a;
import com.tencent.mm.f.a.wd;
import com.tencent.mm.f.a.wg;
import com.tencent.mm.f.a.wj;
import com.tencent.mm.plugin.sns.ad.landingpage.b.a.1;
import com.tencent.mm.plugin.sns.ad.landingpage.component.view.AdLandingGeneralVideoWrapper;
import com.tencent.mm.plugin.sns.ad.landingpage.helper.a.c;
import com.tencent.mm.plugin.sns.ad.landingpage.helper.c.a.a;
import com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.FloatJumpCompHelper;
import com.tencent.mm.plugin.sns.ad.widget.advideo.AdLandingVideoPlayerToolBar;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView;
import com.tencent.mm.plugin.sns.data.l;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.model.AdlandingRemoteServiceConnectedReceiver;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.b;
import com.tencent.mm.plugin.sns.storage.ADXml.k;
import com.tencent.mm.plugin.sns.storage.ADXml.l;
import com.tencent.mm.plugin.sns.storage.ADXml.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ag;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ak;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ao;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdlandingDummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.helper.FloatWebViewHelper;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView;
import com.tencent.mm.protocal.protobuf.emp;
import com.tencent.mm.protocal.protobuf.emq;
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
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.c.a;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.lang.ref.WeakReference;
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
@com.tencent.mm.ui.widget.pulldown.c(0)
public class SnsAdNativeLandingPagesUI
  extends MMActivity
{
  protected com.tencent.mm.ui.widget.snackbar.a.b CBU;
  String CHR;
  private ImageView HMY;
  public AdLandingGeneralVideoWrapper JAK;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai JWV;
  private SnsInfo Jzk;
  private boolean KLA;
  com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k KLB;
  private volatile boolean KLC;
  boolean KLD;
  private int KLE;
  private boolean KLF;
  private String KLG;
  private String KLH;
  private String KLI;
  private String KLJ;
  private AdlandingDummyViewPager KLK;
  private int KLL;
  private int KLM;
  private MMHandler KLN;
  public FrameLayout KLO;
  private View KLP;
  private boolean KLQ;
  private List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m> KLR;
  private com.tencent.mm.plugin.sns.ui.b.c KLS;
  private com.tencent.mm.plugin.sns.ui.b.d KLT;
  public volatile boolean KLU;
  public boolean KLV;
  private Map<String, SnsAdLandingPageFloatView> KLW;
  private com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.a KLX;
  public com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d KLY;
  private boolean KLZ;
  public ae KLn;
  private ImageView KLo;
  private TextView KLp;
  private boolean KLq;
  private boolean KLr;
  public String KLs;
  public String KLt;
  private String KLu;
  private String KLv;
  private String KLw;
  private ImageView KLx;
  String KLy;
  public String KLz;
  public c.a KMA;
  private BroadcastReceiver KMB;
  private n KMC;
  private com.tencent.mm.ui.base.s KMD;
  public FloatJumpCompHelper KME;
  private View.OnClickListener KMF;
  private View.OnClickListener KMG;
  public boolean KMa;
  private boolean KMb;
  Collection<String> KMc;
  private volatile boolean KMd;
  private volatile boolean KMe;
  private volatile boolean KMf;
  private MMHandler KMg;
  private String KMh;
  private FloatWebViewHelper KMi;
  private com.tencent.mm.ui.widget.a.e KMj;
  public boolean KMk;
  private com.tencent.mm.plugin.sns.ad.landingpage.helper.a.a KMl;
  private boolean KMm;
  private a.c KMn;
  public BroadcastReceiver KMo;
  private BroadcastReceiver KMp;
  private final String KMq;
  private ContentFragment.a KMr;
  private ViewPager.OnPageChangeListener KMs;
  private AdLandingPagesProxy.e KMt;
  public IListener<py> KMu;
  private IListener<wd> KMv;
  private Runnable KMw;
  private ScreenShotUtil.ScreenShotCallback KMx;
  private Map<Integer, ContentFragment> KMy;
  private boolean KMz;
  private int Knp;
  private String Knr;
  private String Knt;
  private long Knu;
  private String Knv;
  private Map<String, String> Knw;
  public boolean KvC;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ar Kvt;
  public LinkedList<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g> Kyx;
  private String adCanvasExtXml;
  private String adExtInfo;
  private int adType;
  private String aid;
  private int bizId;
  private long enterTime;
  String fLp;
  private long fOa;
  public boolean forbiddenCustomAnimation;
  private volatile boolean isVisible;
  private ImageView kHA;
  private ImageView mLT;
  private String nTp;
  private String owf;
  private int pEj;
  private int pEk;
  private String pId;
  String pqW;
  private boolean preloadWeAppPkg;
  private boolean rNH;
  private int recSrc;
  Bundle savedInstanceState;
  private int source;
  private long startTime;
  private int twC;
  private int twD;
  private int twE;
  private int twF;
  private String uin;
  private String uxInfo;
  public Map<String, String> values;
  String vhY;
  private String viewId;
  private View xYJ;
  
  public SnsAdNativeLandingPagesUI()
  {
    AppMethodBeat.i(98362);
    this.Kyx = new LinkedList();
    this.twC = 0;
    this.twD = 0;
    this.twE = 0;
    this.twF = 0;
    this.KLq = false;
    this.KLr = false;
    this.KLA = false;
    this.fOa = 0L;
    this.enterTime = 0L;
    this.Knw = new HashMap();
    this.KLB = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k();
    this.KLC = false;
    this.KLD = false;
    this.KLE = 0;
    this.KLF = false;
    this.KLN = new MMHandler();
    this.KLQ = true;
    this.rNH = false;
    this.KLW = new HashMap();
    this.KLZ = false;
    this.KMa = false;
    this.KMb = false;
    this.KMc = new HashSet();
    this.isVisible = false;
    this.KMd = false;
    this.KMe = false;
    this.KMf = false;
    this.KMg = new MMHandler();
    this.KMh = "";
    this.adExtInfo = "";
    this.KMk = false;
    this.forbiddenCustomAnimation = false;
    this.preloadWeAppPkg = false;
    this.Knv = "";
    this.KMn = new a.c();
    this.pId = "";
    this.KMo = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        boolean bool = true;
        AppMethodBeat.i(98324);
        int i = com.tencent.mm.plugin.sns.ad.i.h.getIntExtra(paramAnonymousIntent, "show", 0);
        if ((SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this) == null) || (!(SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getAdapter() instanceof androidx.fragment.app.g)))
        {
          com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.SnsAdNativeLandingPagesUI", "videoProgressbarStatusChangeReceiver called ,but the viewpager or adapter is null!!");
          AppMethodBeat.o(98324);
          return;
        }
        paramAnonymousContext = (androidx.fragment.app.g)SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getAdapter();
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
          SnsAdNativeLandingPagesUI.this.QV(500L);
          paramAnonymousContext.yN(bool);
          AppMethodBeat.o(98324);
          return;
          bool = false;
        }
      }
    };
    this.KMp = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(98343);
        ao.aQ(SnsAdNativeLandingPagesUI.this);
        AppMethodBeat.o(98343);
      }
    };
    this.KMq = "huawei nxt-al10|mix 2s|sm-g9350";
    this.KMr = new ContentFragment.a()
    {
      public final void s(final ContentFragment paramAnonymousContentFragment)
      {
        AppMethodBeat.i(98351);
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SnsAdNativeLandingPagesUI.launch", "firstPage afterOnCreateView");
        Object localObject = SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this);
        if (((a.c)localObject).JCM == 0L) {
          ((a.c)localObject).JCM = System.currentTimeMillis();
        }
        localObject = paramAnonymousContentFragment.getRecyclerView();
        if (localObject != null) {
          ((RecyclerView)localObject).getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(98350);
              Object localObject1 = SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this);
              if (((a.c)localObject1).JCN == 0L) {
                ((a.c)localObject1).JCN = System.currentTimeMillis();
              }
              com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SnsAdNativeLandingPagesUI.launch", "firstPage onPreDraw");
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "onPreDraw %d, %d", new Object[] { Integer.valueOf(SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this).getHeight()), Integer.valueOf(SnsAdNativeLandingPagesUI.d(SnsAdNativeLandingPagesUI.this)) });
              SnsAdNativeLandingPagesUI.e(SnsAdNativeLandingPagesUI.this);
              if (SnsAdNativeLandingPagesUI.f(SnsAdNativeLandingPagesUI.this).a(paramAnonymousContentFragment))
              {
                this.KML.getViewTreeObserver().removeOnPreDrawListener(this);
                AppMethodBeat.o(98350);
                return false;
              }
              localObject1 = null;
              Object localObject2 = SnsAdNativeLandingPagesUI.g(SnsAdNativeLandingPagesUI.this);
              int i;
              if (localObject2 != null)
              {
                localObject1 = (v)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ai)localObject2).KqB;
                if (localObject1 != null)
                {
                  localObject1 = ((v)localObject1).KjX;
                  localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.kR((String)localObject1, "scene_ad_landing");
                  localObject2 = new StringBuilder("onPreDraw, fullscreen, container.size=").append(SnsAdNativeLandingPagesUI.h(SnsAdNativeLandingPagesUI.this).getWidth()).append(", ").append(SnsAdNativeLandingPagesUI.h(SnsAdNativeLandingPagesUI.this).getHeight()).append(", shootImg.w=");
                  if (localObject1 == null) {
                    break label320;
                  }
                  i = ((Bitmap)localObject1).getWidth();
                  label235:
                  localObject2 = ((StringBuilder)localObject2).append(i).append(", shootImg.h=");
                  if (localObject1 == null) {
                    break label325;
                  }
                  i = ((Bitmap)localObject1).getHeight();
                  label255:
                  com.tencent.mm.sdk.platformtools.Log.i("SphereImageView.SnsAdNativeLandingPagesUI", i);
                }
              }
              else
              {
                if (!SnsAdNativeLandingPagesUI.i(SnsAdNativeLandingPagesUI.this)) {
                  break label330;
                }
                MMHandlerThread.postToMainThreadDelayed(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(98349);
                    Bitmap localBitmap1 = null;
                    Object localObject;
                    if (this.KMS != null) {
                      localObject = this.KMS;
                    }
                    while (localObject != null)
                    {
                      SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this).setAlpha(1.0F);
                      SnsAdNativeLandingPagesUI.k(SnsAdNativeLandingPagesUI.this).setImageBitmap((Bitmap)localObject);
                      SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this, SnsAdNativeLandingPagesUI.23.1.this.KML, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
                      AppMethodBeat.o(98349);
                      return;
                      localObject = localBitmap1;
                      try
                      {
                        if (!SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this)) {
                          break label180;
                        }
                        localObject = localBitmap1;
                        localBitmap1 = BitmapUtil.getBitmapFromView(SnsAdNativeLandingPagesUI.23.1.this.KML.getChildAt(0));
                        localObject = localBitmap1;
                        SnsAdNativeLandingPagesUI.k(SnsAdNativeLandingPagesUI.this).setScaleType(ImageView.ScaleType.CENTER_CROP);
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
                      SnsAdNativeLandingPagesUI.k(SnsAdNativeLandingPagesUI.this).setScaleType(ImageView.ScaleType.CENTER_CROP);
                      localObject = localBitmap2;
                    }
                    SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this).setAlpha(1.0F);
                    AppMethodBeat.o(98349);
                  }
                }, 50L);
              }
              for (;;)
              {
                this.KML.getViewTreeObserver().removeOnPreDrawListener(this);
                AppMethodBeat.o(98350);
                return false;
                localObject1 = "";
                break;
                label320:
                i = 0;
                break label235;
                label325:
                i = 0;
                break label255;
                label330:
                SnsAdNativeLandingPagesUI.l(SnsAdNativeLandingPagesUI.this).setVisibility(0);
                SnsAdNativeLandingPagesUI.this.QV(300L);
              }
            }
          });
        }
        AppMethodBeat.o(98351);
      }
    };
    this.KMs = new ViewPager.f()
    {
      public final void onPageScrollStateChanged(int paramAnonymousInt)
      {
        AppMethodBeat.i(98353);
        super.onPageScrollStateChanged(paramAnonymousInt);
        SnsAdNativeLandingPagesUI.m(SnsAdNativeLandingPagesUI.this).KvB = paramAnonymousInt;
        Object localObject;
        if (paramAnonymousInt == 1)
        {
          paramAnonymousInt = 0;
          while (paramAnonymousInt < SnsAdNativeLandingPagesUI.this.Kyx.size())
          {
            localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)SnsAdNativeLandingPagesUI.this.Kyx.get(paramAnonymousInt);
            localObject = (Fragment)SnsAdNativeLandingPagesUI.n(SnsAdNativeLandingPagesUI.this).get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject).id));
            if (localObject != null) {
              ((ContentFragment)localObject).fRX();
            }
            paramAnonymousInt += 1;
          }
          ao.ic(SnsAdNativeLandingPagesUI.this.getContext());
          AppMethodBeat.o(98353);
          return;
        }
        if (paramAnonymousInt == 0)
        {
          localObject = (Fragment)SnsAdNativeLandingPagesUI.n(SnsAdNativeLandingPagesUI.this).get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)SnsAdNativeLandingPagesUI.this.Kyx.get(SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getCurrentItem())).id));
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
        if (SnsAdNativeLandingPagesUI.m(SnsAdNativeLandingPagesUI.this) != null)
        {
          ContentFragment localContentFragment = SnsAdNativeLandingPagesUI.m(SnsAdNativeLandingPagesUI.this);
          if ((localContentFragment.dgo) && (localContentFragment.Kvr != null)) {
            localContentFragment.Kvr.fRL();
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
        if (i < SnsAdNativeLandingPagesUI.this.Kyx.size())
        {
          Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)SnsAdNativeLandingPagesUI.this.Kyx.get(i);
          localObject = (Fragment)SnsAdNativeLandingPagesUI.n(SnsAdNativeLandingPagesUI.this).get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject).id));
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
            ((ContentFragment)localObject).fRX();
          }
        }
        SnsAdNativeLandingPagesUI.this.QV(300L);
        AppMethodBeat.o(98354);
      }
    };
    this.KMt = new AdLandingPagesProxy.e()
    {
      public final void aH(final Object paramAnonymousObject)
      {
        AppMethodBeat.i(98357);
        SnsAdNativeLandingPagesUI.o(SnsAdNativeLandingPagesUI.this).removeCallbacksAndMessages(null);
        SnsAdNativeLandingPagesUI.o(SnsAdNativeLandingPagesUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98356);
            Object localObject = SnsAdNativeLandingPagesUI.p(SnsAdNativeLandingPagesUI.this);
            SnsAdNativeLandingPagesUI.q(SnsAdNativeLandingPagesUI.this);
            String str = (String)paramAnonymousObject;
            SnsAdNativeLandingPagesUI.r(SnsAdNativeLandingPagesUI.this);
            SnsAdNativeLandingPagesUI.s(SnsAdNativeLandingPagesUI.this);
            localObject = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(i.lb((String)localObject, str), SnsAdNativeLandingPagesUI.q(SnsAdNativeLandingPagesUI.this));
            SnsAdNativeLandingPagesUI.this.Kyx = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a)localObject).Kyx;
            SnsAdNativeLandingPagesUI.this.KLn = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a)localObject).Kyy;
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(98355);
                SnsAdNativeLandingPagesUI.this.fVq();
                AppMethodBeat.o(98355);
              }
            });
            AppMethodBeat.o(98356);
          }
        });
        AppMethodBeat.o(98357);
      }
      
      public final void i(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject) {}
    };
    this.KMu = new IListener()
    {
      private boolean a(py paramAnonymouspy)
      {
        AppMethodBeat.i(176294);
        Object localObject1;
        SnsAdLandingPageFloatView localSnsAdLandingPageFloatView;
        Object localObject2;
        int i;
        String str1;
        String str2;
        String str3;
        if ((SnsAdNativeLandingPagesUI.m(SnsAdNativeLandingPagesUI.this).Kvn.Kyq != null) && (SnsAdNativeLandingPagesUI.m(SnsAdNativeLandingPagesUI.this).Kvn.Kyq.containsKey(paramAnonymouspy.fOF.fOG)) && (!SnsAdNativeLandingPagesUI.t(SnsAdNativeLandingPagesUI.this).containsKey(paramAnonymouspy.fOF.fOG)))
        {
          SnsAdNativeLandingPagesUI.m(SnsAdNativeLandingPagesUI.this).onPause();
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("sns_landing_pages_xml", SnsAdNativeLandingPagesUI.p(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putString("sns_float_component_id", paramAnonymouspy.fOF.fOG);
          ((Bundle)localObject1).putInt("sns_landing_page_index", SnsAdNativeLandingPagesUI.m(SnsAdNativeLandingPagesUI.this).Kvn.id);
          ((Bundle)localObject1).putString("sns_landing_page_snsId", SnsAdNativeLandingPagesUI.this.fLp);
          ((Bundle)localObject1).putString("sns_landing_pages_rawSnsId", SnsAdNativeLandingPagesUI.this.KLz);
          ((Bundle)localObject1).putString("sns_landing_pages_ux_info", SnsAdNativeLandingPagesUI.u(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putString("sns_landing_pages_aid", SnsAdNativeLandingPagesUI.r(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putInt("sns_landing_pages_biz_id", SnsAdNativeLandingPagesUI.v(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putString("sns_landing_pages_traceid", SnsAdNativeLandingPagesUI.s(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putInt("sns_landig_pages_from_source", SnsAdNativeLandingPagesUI.w(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putString("sns_landing_pages_xml_prefix", SnsAdNativeLandingPagesUI.q(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putBoolean("sns_landing_is_native_sight_ad", SnsAdNativeLandingPagesUI.x(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putString("sns_landing_pages_canvas_ext", SnsAdNativeLandingPagesUI.y(SnsAdNativeLandingPagesUI.this));
          localSnsAdLandingPageFloatView = new SnsAdLandingPageFloatView(SnsAdNativeLandingPagesUI.this);
          localObject2 = ((Bundle)localObject1).getString("sns_landing_pages_xml");
          localSnsAdLandingPageFloatView.fOG = ((Bundle)localObject1).getString("sns_float_component_id");
          i = ((Bundle)localObject1).getInt("sns_landing_page_index", -1);
          str1 = ((Bundle)localObject1).getString("sns_landing_pages_ux_info");
          str2 = ((Bundle)localObject1).getString("sns_landing_pages_aid");
          str3 = ((Bundle)localObject1).getString("sns_landing_pages_traceid");
          localSnsAdLandingPageFloatView.adCanvasExtXml = ((Bundle)localObject1).getString("sns_landing_pages_canvas_ext");
          if ((!Util.isNullOrNil(new String[] { localObject2, localSnsAdLandingPageFloatView.fOG })) && (i != -1)) {
            break label514;
          }
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdLandingPageFloatView", "invalid landing float page data!");
        }
        for (;;)
        {
          localSnsAdLandingPageFloatView.setBackgroundColor(SnsAdNativeLandingPagesUI.this.getResources().getColor(i.c.sns_ad_float_page_bg_color));
          SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this).addView(localSnsAdLandingPageFloatView, SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this).getChildCount() - 1, new FrameLayout.LayoutParams(-1, -1));
          localSnsAdLandingPageFloatView.fZu();
          SnsAdNativeLandingPagesUI.m(SnsAdNativeLandingPagesUI.this).fRX();
          if ((SnsAdNativeLandingPagesUI.z(SnsAdNativeLandingPagesUI.this) != null) && (!SnsAdNativeLandingPagesUI.z(SnsAdNativeLandingPagesUI.this).Kpr)) {
            SnsAdNativeLandingPagesUI.this.n(false, 0L);
          }
          SnsAdNativeLandingPagesUI.t(SnsAdNativeLandingPagesUI.this).put(paramAnonymouspy.fOF.fOG, localSnsAdLandingPageFloatView);
          AppMethodBeat.o(176294);
          return false;
          label514:
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a((String)localObject2, Util.nullAs(((Bundle)localObject1).getString("sns_landing_pages_xml_prefix"), "adxml")).Kyx;
          if ((localObject1 != null) && (((LinkedList)localObject1).size() > i))
          {
            localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)((LinkedList)localObject1).get(i);
            localSnsAdLandingPageFloatView.LsR = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g();
            localSnsAdLandingPageFloatView.LsR.nWx = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject1).nWx;
            localObject2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject1).Kyq.get(localSnsAdLandingPageFloatView.fOG);
            if (i.agD(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa)localObject2).type))
            {
              localSnsAdLandingPageFloatView.LsQ = ((y)localObject2);
              localSnsAdLandingPageFloatView.LsR.Kyp.add(localSnsAdLandingPageFloatView.LsQ);
              localSnsAdLandingPageFloatView.LsR.Kyq.putAll(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject1).Kyq);
            }
            localSnsAdLandingPageFloatView.LsR.id = 0;
            localSnsAdLandingPageFloatView.LsR.Kyr = true;
          }
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdLandingPageFloatView", "[reportInfo] aid %s,traceId %s,uxInfo %s,adCanvasExtXml %s", new Object[] { str2, str3, str1, localSnsAdLandingPageFloatView.adCanvasExtXml });
          localSnsAdLandingPageFloatView.initView();
        }
      }
    };
    this.KMv = new IListener() {};
    this.KMw = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98336);
        SnsAdNativeLandingPagesUI.M(SnsAdNativeLandingPagesUI.this);
        if ((!SnsAdNativeLandingPagesUI.N(SnsAdNativeLandingPagesUI.this)) && (SnsAdNativeLandingPagesUI.O(SnsAdNativeLandingPagesUI.this))) {
          SnsAdNativeLandingPagesUI.P(SnsAdNativeLandingPagesUI.this);
        }
        AppMethodBeat.o(98336);
      }
    };
    this.KMx = new ScreenShotUtil.ScreenShotCallback()
    {
      public final void onScreenShot(String paramAnonymousString, long paramAnonymousLong)
      {
        AppMethodBeat.i(269040);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "onScreenShot， path = " + paramAnonymousString + "， dateAdded = " + paramAnonymousLong);
        SnsAdNativeLandingPagesUI.Q(SnsAdNativeLandingPagesUI.this);
        AppMethodBeat.o(269040);
      }
    };
    this.KMy = new HashMap();
    this.KMz = false;
    this.CBU = new com.tencent.mm.ui.widget.snackbar.a.b()
    {
      public final void bPM()
      {
        AppMethodBeat.i(265914);
        try
        {
          AdLandingPagesProxy.getInstance().favEditTag();
          AppMethodBeat.o(265914);
          return;
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "favorite edittag fail, ex = " + localException.getMessage());
          AppMethodBeat.o(265914);
        }
      }
    };
    this.KMA = new c.a()
    {
      public final void ca(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(266200);
        SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this, paramAnonymousBoolean);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "onKeyboardStateChanged, visiable=".concat(String.valueOf(paramAnonymousBoolean)));
        SnsAdNativeLandingPagesUI.this.QV(300L);
        if ((SnsAdNativeLandingPagesUI.z(SnsAdNativeLandingPagesUI.this) != null) && (SnsAdNativeLandingPagesUI.z(SnsAdNativeLandingPagesUI.this).Kpr) && (!SnsAdNativeLandingPagesUI.z(SnsAdNativeLandingPagesUI.this).isFinishing))
        {
          if ((paramAnonymousBoolean) && (SnsAdNativeLandingPagesUI.z(SnsAdNativeLandingPagesUI.this).isShowing()))
          {
            SnsAdNativeLandingPagesUI.z(SnsAdNativeLandingPagesUI.this).fQO();
            AppMethodBeat.o(266200);
            return;
          }
          if (!paramAnonymousBoolean) {
            SnsAdNativeLandingPagesUI.z(SnsAdNativeLandingPagesUI.this).fQP();
          }
        }
        AppMethodBeat.o(266200);
      }
    };
    this.KMB = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(204316);
        if (paramAnonymousIntent.getAction().equals("android.intent.action.SCREEN_OFF"))
        {
          com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SnsAdNativeLandingPagesUI", "android.intent.action.SCREEN_OFF");
          AppMethodBeat.o(204316);
          return;
        }
        if (paramAnonymousIntent.getAction().equals("android.intent.action.SCREEN_ON"))
        {
          com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SnsAdNativeLandingPagesUI", "android.intent.action.SCREEN_ON");
          ao.aQ(SnsAdNativeLandingPagesUI.this);
        }
        AppMethodBeat.o(204316);
      }
    };
    this.KMC = null;
    this.KMD = null;
    this.KMF = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(220708);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "mOnCloseClickListener, onClick");
        if (SnsAdNativeLandingPagesUI.this.keyboardState() == 1) {
          SnsAdNativeLandingPagesUI.this.hideVKB();
        }
        SnsAdNativeLandingPagesUI.this.cJs();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(220708);
      }
    };
    this.KMG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(197696);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "mOnBackClickListener, onClick");
        if (SnsAdNativeLandingPagesUI.this.keyboardState() == 1) {
          SnsAdNativeLandingPagesUI.this.hideVKB();
        }
        SnsAdNativeLandingPagesUI.this.cJs();
        SnsAdNativeLandingPagesUI.ab(SnsAdNativeLandingPagesUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(197696);
      }
    };
    AppMethodBeat.o(98362);
  }
  
  private void Rj(long paramLong)
  {
    AppMethodBeat.i(98401);
    if (this.KLY != null)
    {
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SnsAdNativeLandingPagesUI", "showFloatBarView");
      this.KLY.QT(paramLong);
      ContentFragment localContentFragment = fVx();
      if (localContentFragment != null) {
        localContentFragment.fRX();
      }
    }
    AppMethodBeat.o(98401);
  }
  
  private void Z(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(98375);
    String str = (String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.iconUrl");
    if (TextUtils.isEmpty(str))
    {
      this.Kvt = null;
      AppMethodBeat.o(98375);
      return;
    }
    if (this.Kvt == null) {
      this.Kvt = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ar();
    }
    this.Kvt.iconUrl = str;
    int k = Util.safeParseInt((String)paramMap.get(paramString + ".adCanvasInfo.sizeType"));
    int i = Util.safeParseInt((String)paramMap.get(paramString + ".adCanvasInfo.basicRootFontSize"));
    int j = Util.safeParseInt((String)paramMap.get(paramString + ".adCanvasInfo.basicWidth"));
    if ((i == 0) && (k == 1)) {
      i = i.Kyv;
    }
    for (;;)
    {
      if ((j == 0) && (k == 1)) {
        j = i.Kyu;
      }
      for (;;)
      {
        this.Kvt.paddingBottom = i.a(Util.safeParseDouble((String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.paddingBottom")), k, j, i);
        this.Kvt.width = i.a(Util.safeParseDouble((String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.layoutWidth")), k, j, i);
        this.Kvt.height = i.a(Util.safeParseDouble((String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.layoutHeight")), k, j, i);
        AppMethodBeat.o(98375);
        return;
      }
    }
  }
  
  private static boolean aha(int paramInt)
  {
    AppMethodBeat.i(269213);
    if ((ahb(paramInt)) || (com.tencent.mm.plugin.sns.ad.h.a.aeP(paramInt)))
    {
      AppMethodBeat.o(269213);
      return true;
    }
    AppMethodBeat.o(269213);
    return false;
  }
  
  public static boolean ahb(int paramInt)
  {
    AppMethodBeat.i(269214);
    if ((paramInt == 3) || (paramInt == 5) || (paramInt == 4)) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "isFromShare, source=" + paramInt + ", ret=" + bool);
      AppMethodBeat.o(269214);
      return bool;
    }
  }
  
  private static boolean ahc(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(269220);
    boolean bool1 = bool2;
    if (paramInt != 1)
    {
      bool1 = bool2;
      if (paramInt != 2) {
        if (paramInt != 16) {
          break label71;
        }
      }
    }
    label71:
    for (bool1 = bool2;; bool1 = false)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "isFromTimeLine, source=" + paramInt + ", ret=" + bool1);
      AppMethodBeat.o(269220);
      return bool1;
    }
  }
  
  private void ata()
  {
    AppMethodBeat.i(98374);
    this.Jzk = AdLandingPagesProxy.getInstance().getSnsInfo(this.fLp);
    AdLandingPagesProxy.getInstance().asyncCacheXml(this.fLp);
    if (this.values == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "parse landingpagexml is error,landingpagexml is " + this.KLs);
      AppMethodBeat.o(98374);
      return;
    }
    long l;
    Object localObject3;
    String str1;
    label624:
    int i;
    if ((this.source == 1) || (this.source == 2) || (this.source == 16) || (this.source == 14) || (this.source == 9) || (this.source == 10))
    {
      l = 0L;
      if (this.Jzk != null)
      {
        l = this.Jzk.field_snsId;
        this.aid = AdLandingPagesProxy.getInstance().getSnsAid(this.fLp);
        this.nTp = AdLandingPagesProxy.getInstance().getSnsTraceid(this.fLp);
        this.adType = AdLandingPagesProxy.getInstance().getSnsAdType(this.fLp);
        this.uxInfo = AdLandingPagesProxy.getInstance().getSnsUxInfo(this.fLp);
        this.adCanvasExtXml = AdLandingPagesProxy.getInstance().getSnsAdCanvasExtXml(this.fLp);
      }
      if (this.KLz != null)
      {
        localObject1 = this.KLz;
        this.values.put("." + this.KLt + ".originSnsId", localObject1);
        this.values.put("." + this.KLt + ".originUxInfo", this.uxInfo);
        localObject3 = "<" + this.KLt + ">";
        localObject3 = (String)localObject3 + String.format("<originSnsId>%s</originSnsId>", new Object[] { localObject1 });
        localObject3 = (String)localObject3 + String.format("<originUxInfo>%s</originUxInfo>", new Object[] { this.uxInfo });
        localObject3 = (String)localObject3 + String.format("<originAdType>%d</originAdType>", new Object[] { Integer.valueOf(this.adType) });
        localObject3 = (String)localObject3 + String.format("<originAid>%s</originAid>", new Object[] { this.aid });
        str1 = (String)localObject3 + String.format("<originTraceId>%s</originTraceId>", new Object[] { this.nTp });
        localObject3 = str1;
        if (!Util.isNullOrNil(this.adCanvasExtXml)) {
          localObject3 = str1 + String.format("<originAdCanvasExt>%s</originAdCanvasExt>", new Object[] { this.adCanvasExtXml });
        }
        this.KLs = this.KLs.replace("<" + this.KLt + ">", (CharSequence)localObject3);
        this.KLB.uxInfo = this.uxInfo;
        this.KLB.fLp = ((String)localObject1);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "reportInfo aid [%s],traceId [%s],adType [%s],uxInfo [%s],adCanvasExtXml [%s]", new Object[] { this.aid, this.nTp, Integer.valueOf(this.adType), this.uxInfo, this.adCanvasExtXml });
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
          break label3033;
        }
      }
    }
    label1753:
    Object localObject2;
    label2901:
    label3033:
    for (Object localObject1 = ".adCardItemList.cardItem" + i;; localObject2 = ".adCardItemList.cardItem")
    {
      if (((Map)localObject3).containsKey((String)localObject1 + ".cardTpId"))
      {
        str1 = Util.nullAs((String)((Map)localObject3).get((String)localObject1 + ".cardTpId"), "");
        localObject1 = Util.nullAs((String)((Map)localObject3).get((String)localObject1 + ".cardExt"), "");
        if ((!Util.isNullOrNil(str1)) && (!Util.isNullOrNil((String)localObject1))) {
          this.Knw.put(str1, localObject1);
        }
        i += 1;
        break label705;
        localObject1 = String.valueOf(l);
        break;
        String str2 = "." + this.KLt + ".originTraceId";
        str1 = "." + this.KLt + ".originAid";
        String str3 = "." + this.KLt + ".originUxInfo";
        this.KLB.fLp = ((String)this.values.get("." + this.KLt + ".originSnsId"));
        this.KLB.uxInfo = ((String)this.values.get(str3));
        this.uxInfo = this.KLB.uxInfo;
        this.KLz = this.KLB.fLp;
        this.adType = Util.safeParseInt((String)this.values.get("." + this.KLt + ".originAdType"));
        this.aid = ((String)this.values.get(str1));
        this.nTp = ((String)this.values.get(str2));
        if (!Util.isNullOrNil(this.owf))
        {
          localObject1 = XmlParser.parseXml(this.owf, "ADInfo", null);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "adInfoXml %s", new Object[] { this.owf });
          if (localObject1 != null)
          {
            this.uxInfo = Util.nullAs((String)((Map)localObject1).get(".ADInfo.uxInfo"), "");
            this.KLB.uxInfo = this.uxInfo;
            this.aid = Util.nullAs((String)((Map)localObject1).get(".ADInfo.session_data.aid"), "");
            this.nTp = Util.nullAs((String)((Map)localObject1).get(".ADInfo.session_data.trace_id"), "");
            this.viewId = Util.nullAs((String)((Map)localObject1).get(".ADInfo.viewid"), "");
            this.Knt = Util.nullAs((String)((Map)localObject1).get(".ADInfo.commInfo"), "");
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "adInfoXml, aid = " + this.aid + ", uxInfo = " + this.uxInfo + ", commInfo = " + this.Knt + ", traceId=" + this.nTp + ", viewId=" + this.viewId);
          }
        }
        try
        {
          localObject3 = "<" + this.KLt + ">";
          localObject1 = localObject3;
          if (!TextUtils.isEmpty(this.uxInfo))
          {
            localObject1 = localObject3;
            if (!this.values.containsKey(str3)) {
              localObject1 = (String)localObject3 + String.format("<originUxInfo>%s</originUxInfo>", new Object[] { this.uxInfo });
            }
          }
          localObject3 = localObject1;
          if (!TextUtils.isEmpty(this.nTp))
          {
            localObject3 = localObject1;
            if (!this.values.containsKey(str2)) {
              localObject3 = (String)localObject1 + String.format("<originTraceId>%s</originTraceId>", new Object[] { this.nTp });
            }
          }
          localObject1 = localObject3;
          if (!TextUtils.isEmpty(this.aid))
          {
            localObject1 = localObject3;
            if (!this.values.containsKey(str1)) {
              localObject1 = (String)localObject3 + String.format("<originAid>%s</originAid>", new Object[] { this.aid });
            }
          }
          this.KLs = this.KLs.replace("<" + this.KLt + ">", (CharSequence)localObject1);
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "replace landingPagesXml exp=" + localThrowable.toString());
          }
        }
        localObject1 = Pattern.compile("<originAdCanvasExt>[\\s\\S]*</originAdCanvasExt>").matcher(this.KLs);
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
      this.KLB.Kzb = AdLandingPagesProxy.getInstance().getSnsStatExtBySnsId(Util.safeParseLong(this.KLB.fLp));
      this.pqW = Util.nullAs((String)this.values.get("." + this.KLt + ".adCanvasInfo.shareTitle"), "");
      this.vhY = Util.nullAs((String)this.values.get("." + this.KLt + ".adCanvasInfo.shareWebUrl"), "");
      this.CHR = Util.nullAs((String)this.values.get("." + this.KLt + ".adCanvasInfo.shareDesc"), "");
      this.bizId = Util.safeParseInt(Util.nullAs((String)this.values.get("." + this.KLt + ".adCanvasInfo.bizId"), ""));
      this.KLG = Util.nullAs((String)this.values.get("." + this.KLt + ".adCanvasInfo.shareAppId"), "");
      this.KLH = Util.nullAs((String)this.values.get("." + this.KLt + ".adCanvasInfo.shareType"), "");
      this.KLI = Util.nullAs((String)this.values.get("." + this.KLt + ".adCanvasInfo.userInfo"), "");
      this.KLL = Util.safeParseInt(Util.nullAs((String)this.values.get("." + this.KLt + ".adCanvasInfo.disableShareBitSet"), ""));
      this.KLM = Util.safeParseInt(Util.nullAs((String)this.values.get("." + this.KLt + ".adCanvasInfo.statusBarStyle"), ""));
      Z(this.values, "." + this.KLt);
      this.uin = AdLandingPagesProxy.getInstance().getUin();
      this.KLJ = Util.nullAs((String)this.values.get("." + this.KLt + ".adCanvasInfo.officialSyncBuffer"), "");
      getIntent().putExtra("sns_landing_pages_adType", this.adType);
      getIntent().putExtra("sns_landing_pages_rawSnsId", this.KLB.fLp);
      if (Util.isNullOrNil(this.aid)) {
        this.aid = Util.nullAs((String)this.values.get("." + this.KLt + ".originAid"), "");
      }
      if (Util.isNullOrNil(this.nTp)) {
        this.nTp = Util.nullAs((String)this.values.get("." + this.KLt + ".originTraceId"), "");
      }
      if (Util.isNullOrNil(this.aid))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "try get aid from uxinfo");
        this.aid = com.tencent.mm.plugin.sns.data.m.aYX(this.uxInfo);
      }
      if (Util.isNullOrNil(this.nTp))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "try get traceId from uxinfo");
        this.nTp = com.tencent.mm.plugin.sns.data.m.aYY(this.uxInfo);
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "aid=" + this.aid + ", traceId=" + this.nTp);
      this.pId = com.tencent.mm.plugin.sns.data.m.aYZ(this.uxInfo);
      localObject2 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.KLs, this.KLt);
      this.Kyx = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a)localObject2).Kyx;
      this.KLn = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a)localObject2).Kyy;
      fVE();
      b((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a)localObject2);
      c((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a)localObject2);
      d((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a)localObject2);
      localObject3 = new ArrayList();
      if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a)localObject2).Kyy != null) {
        com.tencent.mm.plugin.sns.ad.d.h.a(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a)localObject2).Kyy, (ArrayList)localObject3);
      }
      if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a)localObject2).KyA != null) {
        com.tencent.mm.plugin.sns.ad.d.h.a(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a)localObject2).KyA, (ArrayList)localObject3);
      }
      if (!((ArrayList)localObject3).isEmpty()) {
        com.tencent.mm.plugin.sns.ad.d.h.h((ArrayList)localObject3, this.preloadWeAppPkg);
      }
      if (this.Kyx.size() > 0)
      {
        localObject2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.Kyx.get(0);
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject2).Kyp.size() > 0)
        {
          localObject2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject2).Kyp.get(0);
          if (!(localObject2 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)) {
            break label2901;
          }
          this.KLy = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)localObject2).Kmf;
        }
      }
      for (;;)
      {
        this.KLu = Util.nullAs((String)this.values.get("." + this.KLt + ".adCanvasInfo.rightBarTitle"), "");
        this.KLv = Util.nullAs((String)this.values.get("." + this.KLt + ".adCanvasInfo.rightBarCanvasId"), "");
        this.KLw = Util.nullAs((String)this.values.get("." + this.KLt + ".adCanvasInfo.rightBarCanvasExt"), "");
        AppMethodBeat.o(98374);
        return;
        if ((localObject2 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t))
        {
          this.KLy = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t)localObject2).Kmf;
        }
        else if ((localObject2 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w))
        {
          this.KLy = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w)localObject2).Kmm;
        }
        else if ((localObject2 instanceof al))
        {
          localObject2 = (al)localObject2;
          if (!((al)localObject2).Kmd.isEmpty())
          {
            localObject2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)((al)localObject2).Kmd.getFirst();
            if (!((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)localObject2).Kmd.isEmpty())
            {
              localObject2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)localObject2).Kmd.getFirst();
              if ((localObject2 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)) {
                this.KLy = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)localObject2).Kmf;
              }
            }
          }
        }
      }
    }
  }
  
  private void b(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a parama)
  {
    AppMethodBeat.i(269233);
    try
    {
      if ((parama.Kyz != null) && (this.xYJ != null))
      {
        this.KMi = FloatWebViewHelper.a(parama.Kyz, (ViewGroup)this.xYJ);
        getLifecycle().a(this.KMi);
      }
      AppMethodBeat.o(269233);
      return;
    }
    catch (Throwable parama)
    {
      AppMethodBeat.o(269233);
    }
  }
  
  private String bbZ(String paramString)
  {
    AppMethodBeat.i(98389);
    String str = Util.nullAs((String)this.values.get("." + this.KLt + ".adCanvasInfo.shareThumbUrl"), "");
    if (!Util.isNullOrNil(str))
    {
      AppMethodBeat.o(98389);
      return str;
    }
    AppMethodBeat.o(98389);
    return paramString;
  }
  
  private void byM()
  {
    AppMethodBeat.i(98378);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.KLK.getAdapter();
    if (localb == null)
    {
      localb = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b(getSupportFragmentManager(), new ArrayList());
      this.KLK.setAdapter(localb);
    }
    for (;;)
    {
      List localList = fVm();
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g localg;
      ContentFragment localContentFragment;
      if (localList.size() > 0)
      {
        localg = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localList.get(0);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "loadFirstPage load id %s", new Object[] { Integer.valueOf(localg.id) });
        localContentFragment = (ContentFragment)this.KMy.get(Integer.valueOf(localg.id));
        if (localContentFragment != null) {
          break label362;
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("pageInfo", localg);
        localHashMap.put("pageCount", Integer.valueOf(localList.size()));
        localHashMap.put("viewPager", this.KLK);
        localHashMap.put("pageDownIconInfo", this.Kvt);
        localHashMap.put("is_first_show_page", Boolean.TRUE);
        if (localList.size() == 1) {
          localHashMap.put("is_last_shown_page", Boolean.TRUE);
        }
        localHashMap.put("needEnterAnimation", Boolean.valueOf(this.KLq));
        localHashMap.put("needDirectionAnimation", Boolean.valueOf(fVs()));
        localHashMap.put("groupListCompShowIndex", Integer.valueOf(this.KLE));
        localContentFragment = new ContentFragment();
        localContentFragment.params = localHashMap;
        localContentFragment.KvE = this.KMr;
        this.KMy.put(Integer.valueOf(localg.id), localContentFragment);
      }
      for (;;)
      {
        if (localContentFragment != null) {
          localb.c(localContentFragment, 0);
        }
        localb.notifyDataSetChanged();
        this.KLK.setOffscreenPageLimit(localList.size());
        AppMethodBeat.o(98378);
        return;
        label362:
        localContentFragment.a(localg);
      }
    }
  }
  
  private void c(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a parama)
  {
    AppMethodBeat.i(269234);
    try
    {
      fVD();
      if (this.KLX != null)
      {
        parama = this.KLX.a(parama);
        if (parama != null)
        {
          parama.I((ViewGroup)this.xYJ);
          parama.fKL();
        }
      }
      AppMethodBeat.o(269234);
      return;
    }
    catch (Throwable parama)
    {
      AppMethodBeat.o(269234);
    }
  }
  
  private void d(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a parama)
  {
    AppMethodBeat.i(269235);
    try
    {
      fVD();
      if ((parama.KyA != null) && (this.xYJ != null) && (this.KLX != null))
      {
        FloatJumpCompHelper localFloatJumpCompHelper = this.KLX.a(parama.KyA, (ViewGroup)this.xYJ);
        if (localFloatJumpCompHelper != null)
        {
          this.KME = localFloatJumpCompHelper;
          getLifecycle().a(localFloatJumpCompHelper);
          if (parama.KyA.JBO != null)
          {
            parama = parama.KyA.JBO.KlK;
            if (!TextUtils.isEmpty(parama)) {
              this.KMc.add(parama);
            }
          }
        }
      }
      AppMethodBeat.o(269235);
      return;
    }
    catch (Throwable parama)
    {
      AppMethodBeat.o(269235);
    }
  }
  
  private void fUY()
  {
    boolean bool2 = true;
    AppMethodBeat.i(269206);
    boolean bool3 = false;
    for (;;)
    {
      try
      {
        int i = getApplicationContext().getApplicationInfo().targetSdkVersion;
        bool1 = bool3;
        if (com.tencent.mm.compatible.util.d.qV(29))
        {
          if (com.tencent.mm.compatible.util.d.qV(30)) {
            break label200;
          }
          bool1 = bool3;
          if (i >= 29) {
            break label200;
          }
        }
        String str = Util.nullAsNil(Build.MODEL);
        if ((!bool1) && (!TextUtils.isEmpty(str)) && ("huawei nxt-al10|mix 2s|sm-g9350".contains(str.toLowerCase())))
        {
          bool1 = bool2;
          if (bool1) {
            com.tencent.mm.ui.base.b.a(this, null);
          }
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "fixActivityTranslucent, device=" + str + ", api=" + Build.VERSION.SDK_INT + ", targetSdkVer=" + i + ", needFix=" + bool1);
          AppMethodBeat.o(269206);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "fixActivityTranslucent exp=" + localThrowable.toString());
        AppMethodBeat.o(269206);
        return;
      }
      continue;
      label200:
      boolean bool1 = true;
    }
  }
  
  private String fVA()
  {
    AppMethodBeat.i(98391);
    try
    {
      Object localObject2 = this.KLs.replaceAll("(?s)<adCanvasInfoLeft[^>]*>.*?</adCanvasInfoLeft>", "").replaceAll("(?s)<adCanvasInfoRight[^>]*>.*?</adCanvasInfoRight>", "");
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
      localObject1 = localObject2;
      if (this.KMm)
      {
        localObject1 = localObject2;
        if (!((String)localObject2).contains("isInteractiveCanvas")) {
          localObject1 = ((String)localObject2).replace("<adCanvasInfo>", "<adCanvasInfo><isInteractiveCanvas>1</isInteractiveCanvas>");
        }
      }
      AppMethodBeat.o(98391);
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "genForwardXml, exp=" + localThrowable.toString());
      String str = this.KLs;
      AppMethodBeat.o(98391);
      return str;
    }
  }
  
  private void fVD()
  {
    AppMethodBeat.i(269236);
    if (this.KLX == null) {
      this.KLX = new com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.a();
    }
    AppMethodBeat.o(269236);
  }
  
  private void fVE()
  {
    AppMethodBeat.i(98398);
    if ((this.KLn != null) && (this.KLO != null) && (this.KLY == null))
    {
      this.KLY = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d(this, this.KLn, this.KLO);
      if (!this.KLY.Kpr) {
        n(false, 0L);
      }
      if ((this.KLn.Knc instanceof r))
      {
        r localr = (r)this.KLn.Knc;
        if (!TextUtils.isEmpty(localr.KlK)) {
          this.KMc.add(localr.KlK);
        }
      }
    }
    AppMethodBeat.o(98398);
  }
  
  private boolean fVG()
  {
    AppMethodBeat.i(98404);
    if (this.KLn != null)
    {
      if (this.KLn.Knb == 1)
      {
        boolean bool = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u.agl(this.source);
        AppMethodBeat.o(98404);
        return bool;
      }
      AppMethodBeat.o(98404);
      return true;
    }
    AppMethodBeat.o(98404);
    return false;
  }
  
  private void fVH()
  {
    AppMethodBeat.i(269237);
    String str = com.tencent.mm.plugin.sns.ad.h.a.aYC(this.Knv);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "doBackToThirdApp, appId=".concat(String.valueOf(str)));
    if (!TextUtils.isEmpty(str)) {
      AdLandingPagesProxy.getInstance().launchBackApp(str);
    }
    AppMethodBeat.o(269237);
  }
  
  private void fVa()
  {
    AppMethodBeat.i(98364);
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SnsAdNativeLandingPagesUI.launch", "initAfterConnectToMM");
    AdlandingRemoteServiceConnectedReceiver.a(androidx.h.a.a.V(this));
    ata();
    if (this.KLq) {
      byM();
    }
    for (;;)
    {
      refreshView();
      fVh();
      fVi();
      yT(true);
      this.rNH = true;
      fVb();
      fVc();
      AppMethodBeat.o(98364);
      return;
      fVq();
    }
  }
  
  private void fVb()
  {
    AppMethodBeat.i(269210);
    if ((aha(this.source)) && (!TextUtils.isEmpty(this.uxInfo)))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "doUpdateUxInfoScene, uxInfo=" + this.uxInfo + ", source=" + this.source);
      AdLandingPagesProxy.getInstance().doUpdateUxInfoScene(this.uxInfo, this.source, new AdLandingPagesProxy.e()
      {
        public final void aH(Object paramAnonymousObject) {}
        
        public final void i(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
        {
          AppMethodBeat.i(229589);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "doUpdateUxInfoScene end, errType=" + paramAnonymousInt1 + ", errNo=" + paramAnonymousInt2 + ", newUxInfo=" + paramAnonymousObject);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && ((paramAnonymousObject instanceof String))) {
            SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this, (String)paramAnonymousObject);
          }
          AppMethodBeat.o(229589);
        }
      });
      fVd();
    }
    AppMethodBeat.o(269210);
  }
  
  private void fVc()
  {
    AppMethodBeat.i(269211);
    AdLandingPagesProxy.getInstance().doAdNativeAntiAbuseScene(this.KLB.owd, this.uxInfo, this.source, this.adExtInfo, new SnsAdNativeLandingPagesUI.2(this));
    AppMethodBeat.o(269211);
  }
  
  private void fVd()
  {
    AppMethodBeat.i(269212);
    try
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "checkPreloadScanRes, uxinfo=" + this.uxInfo);
      com.tencent.mm.plugin.sns.ad.timeline.b.f.a(ADXml.b.Q(this.values, ".adxml.adScanInfo"), this.uxInfo);
      AppMethodBeat.o(269212);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "checkPreloadScanRes exp=" + localException.toString());
      AppMethodBeat.o(269212);
    }
  }
  
  private void fVe()
  {
    AppMethodBeat.i(269215);
    try
    {
      if ((this.KMj != null) && (this.KMj.isShowing())) {
        this.KMj.bYF();
      }
      AppMethodBeat.o(269215);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "hideMoreOptionMenu exp=" + localException.toString());
      AppMethodBeat.o(269215);
    }
  }
  
  private void fVg()
  {
    AppMethodBeat.i(98367);
    Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.KLK.getAdapter();
    if (localObject == null)
    {
      AppMethodBeat.o(98367);
      return;
    }
    localObject = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)localObject).fragments.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ContentFragment localContentFragment = (ContentFragment)((Iterator)localObject).next();
      if ((localContentFragment.Kvr != null) && (localContentFragment.getUserVisibleHint())) {
        localContentFragment.Kvr.fRM();
      }
    }
    if (this.KLY != null) {
      this.KLY.fKl();
    }
    AppMethodBeat.o(98367);
  }
  
  private void fVh()
  {
    AppMethodBeat.i(98369);
    com.tencent.mm.plugin.report.service.h localh;
    String str2;
    if (this.recSrc != 2)
    {
      localh = com.tencent.mm.plugin.report.service.h.IzE;
      str2 = com.tencent.mm.plugin.sns.data.t.Qu(com.tencent.mm.plugin.sns.data.t.aZs(this.KLB.fLp));
      if (this.uxInfo != null) {
        break label146;
      }
    }
    label146:
    for (String str1 = "";; str1 = this.uxInfo)
    {
      localh.a(14655, new Object[] { str2, str1, Integer.valueOf(this.KLB.jJH), Integer.valueOf(this.KLB.uQm), Long.valueOf(this.enterTime), Integer.valueOf(this.Knp), this.KLB.owd });
      if (com.tencent.mm.plugin.sns.ad.h.a.aeP(this.source)) {
        com.tencent.mm.plugin.sns.ad.h.a.fU(this.Knv, 8);
      }
      AppMethodBeat.o(98369);
      return;
    }
  }
  
  private void fVi()
  {
    AppMethodBeat.i(179185);
    try
    {
      if (!Util.isNullOrNil(new String[] { this.viewId, this.Knt }))
      {
        if (!this.KMd) {
          fVj();
        }
        if ((!this.KMe) && (this.KMg != null))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "execute mValidExposureRunnable onCreate");
          this.KMg.removeCallbacks(this.KMw);
          this.KMg.postDelayed(this.KMw, 1000L);
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
  
  private void fVj()
  {
    AppMethodBeat.i(179186);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "reportOriginalExposure viewId = " + this.viewId + ", commInfo = " + this.Knt + ", uxInfo = " + this.uxInfo + ", exposureType = 0");
    this.KMd = true;
    h(this.viewId, this.Knt, this.uxInfo, 0);
    AppMethodBeat.o(179186);
  }
  
  private void fVk()
  {
    AppMethodBeat.i(179187);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "reportValidExposure viewId = " + this.viewId + ", commInfo = " + this.Knt + ", uxInfo = " + this.uxInfo + ", exposureType = 1");
    this.KMe = true;
    h(this.viewId, this.Knt, this.uxInfo, 1);
    AppMethodBeat.o(179187);
  }
  
  private boolean fVl()
  {
    AppMethodBeat.i(98370);
    int j = this.KLO.getChildCount();
    int i = 0;
    while (i < j)
    {
      if ((this.KLO.getChildAt(i) instanceof SnsAdLandingPageFloatView))
      {
        AppMethodBeat.o(98370);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(98370);
    return false;
  }
  
  private List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g> fVm()
  {
    AppMethodBeat.i(98376);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Kyx.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g localg = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localIterator.next();
      if (localg.Kyr) {
        localArrayList.add(localg);
      }
    }
    hK(localArrayList);
    AppMethodBeat.o(98376);
    return localArrayList;
  }
  
  private void fVp()
  {
    AppMethodBeat.i(269225);
    androidx.h.a.a.V(this).a(this.KMo, new IntentFilter("com.tencent.mm.adlanding.video_progressbar_change"));
    EventCenter.instance.addListener(this.KMu);
    if ((this.KLY != null) && (this.KLY.isShowing())) {
      this.KLY.fKk();
    }
    fVx().fRR();
    AppMethodBeat.o(269225);
  }
  
  private boolean fVr()
  {
    AppMethodBeat.i(98382);
    if (this.KLL != 0)
    {
      if (((this.KLL & 0x4) == 0) || ((this.KLL & 0x2) == 0) || ((fVv()) && (this.bizId == 2)) || ((this.KLL & 0x1) == 0) || ((this.KLL & 0x20) == 0))
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
  
  private boolean fVs()
  {
    return (this.KLL & 0x8) == 0;
  }
  
  private boolean fVt()
  {
    return this.KLM == 0;
  }
  
  private boolean fVu()
  {
    AppMethodBeat.i(98383);
    if ((!Util.isNullOrNil(this.KLu)) && (!Util.isNullOrNil(this.KLv)))
    {
      AppMethodBeat.o(98383);
      return true;
    }
    AppMethodBeat.o(98383);
    return false;
  }
  
  private boolean fVv()
  {
    return (this.KLL & 0x10) == 0;
  }
  
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ai fVw()
  {
    AppMethodBeat.i(98385);
    Object localObject = fVx().fRQ().iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m localm = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m)((Iterator)localObject).next();
      if ((localm instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ai))
      {
        localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ai)localm;
        AppMethodBeat.o(98385);
        return localObject;
      }
    }
    AppMethodBeat.o(98385);
    return null;
  }
  
  private a fVy()
  {
    AppMethodBeat.i(98388);
    Object localObject = new ADXml(this.KLs);
    if (((ADXml)localObject).hasVoteInfo())
    {
      int i = AdLandingPagesProxy.getInstance().getAdVoteIndex(((ADXml)localObject).adVoteInfo.Kkg, this.uxInfo, this.uin);
      if ((i > 0) && (i <= ((ADXml)localObject).adVoteInfo.Kki.size()))
      {
        localObject = (ADXml.m)((ADXml)localObject).adVoteInfo.Kki.get(i - 1);
        a locala = new a((byte)0);
        if (!Util.isNullOrNil(((ADXml.m)localObject).pqW))
        {
          locala.pqW = ((ADXml.m)localObject).pqW;
          if (Util.isNullOrNil(((ADXml.m)localObject).CHR)) {
            break label165;
          }
          locala.CHR = ((ADXml.m)localObject).CHR;
          label128:
          if (Util.isNullOrNil(((ADXml.m)localObject).Kkj)) {
            break label176;
          }
        }
        label165:
        label176:
        for (locala.Kkj = ((ADXml.m)localObject).Kkj;; locala.Kkj = this.KLy)
        {
          AppMethodBeat.o(98388);
          return locala;
          locala.pqW = this.pqW;
          break;
          locala.CHR = this.CHR;
          break label128;
        }
      }
    }
    AppMethodBeat.o(98388);
    return null;
  }
  
  private String fVz()
  {
    AppMethodBeat.i(98390);
    Object localObject = new emp();
    ((emp)localObject).Upe = new emq();
    ((emp)localObject).Upe.RzC = this.KLB.uxInfo;
    ((emp)localObject).Upe.Uph = this.KLB.fLp;
    ((emp)localObject).Upe.adType = this.adType;
    try
    {
      localObject = Base64.encodeToString(((emp)localObject).toByteArray(), 2);
      AppMethodBeat.o(98390);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(98390);
    }
    return "";
  }
  
  private List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m> getAllComp()
  {
    AppMethodBeat.i(98380);
    this.KLR = new ArrayList();
    Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.KLK.getAdapter();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)localObject).fragments.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Fragment localFragment = (Fragment)((Iterator)localObject).next();
        this.KLR.addAll(((ContentFragment)localFragment).fRQ());
      }
    }
    i.hD(this.KLR);
    localObject = this.KLR;
    AppMethodBeat.o(98380);
    return localObject;
  }
  
  private static void h(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(179188);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("viewid", paramString1);
      localJSONObject.put("commInfo", paramString2);
      localJSONObject.put("uxinfo", paramString3);
      localJSONObject.put("exposureType", paramInt);
      com.tencent.mm.plugin.sns.data.m.ks("rewarded_canvas_exposure", localJSONObject.toString());
      AppMethodBeat.o(179188);
      return;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "doCanvasExposureReport exp=" + paramString1.toString());
      AppMethodBeat.o(179188);
    }
  }
  
  private void hK(List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g> paramList)
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
        Iterator localIterator = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)paramList.next()).Kyp.iterator();
        int i = j;
        for (;;)
        {
          j = i;
          if (!localIterator.hasNext()) {
            break;
          }
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa localaa = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa)localIterator.next();
          j = i;
          if ((localaa instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b))
          {
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localaa).KkW = i;
            j = i + 1;
          }
          String str;
          if ((localaa instanceof r))
          {
            str = ((r)localaa).KlK;
            if (!TextUtils.isEmpty(str)) {
              this.KMc.add(str);
            }
          }
          if ((localaa instanceof q))
          {
            str = ((q)localaa).jumpUrl;
            if (!TextUtils.isEmpty(str)) {
              this.KMc.add(str);
            }
          }
          i = j;
          if (!this.KMz)
          {
            com.tencent.mm.plugin.sns.ad.d.h.a(localaa, (ArrayList)localObject);
            i = j;
          }
        }
      }
      if (this.KMz) {
        break label260;
      }
    }
    catch (Exception paramList)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "giveIdxForApkBtnInfo, exp=" + paramList.toString());
      AppMethodBeat.o(98377);
      return;
    }
    this.KMz = true;
    if (!((ArrayList)localObject).isEmpty()) {
      com.tencent.mm.plugin.sns.ad.d.h.h((ArrayList)localObject, this.preloadWeAppPkg);
    }
    label260:
    if (!com.tencent.mm.plugin.sns.ad.i.d.isEmpty(this.KMc))
    {
      localObject = com.tencent.mm.plugin.sns.ad.c.a.a.a(this.KMc, this.nTp, this.aid, this.Knr, this.uxInfo);
      if (!com.tencent.mm.plugin.sns.ad.i.d.w((Object[])localObject)) {
        if (!TextUtils.isEmpty(this.fLp)) {
          break label334;
        }
      }
    }
    label334:
    for (paramList = this.KLz;; paramList = this.fLp)
    {
      AdLandingPagesProxy.getInstance().prefetchH5Url(paramList, (String[])localObject);
      AppMethodBeat.o(98377);
      return;
    }
  }
  
  private void refreshView()
  {
    AppMethodBeat.i(98365);
    Object localObject;
    if ((this.bizId == 2) && (!fVt()))
    {
      localObject = (FrameLayout.LayoutParams)this.KLK.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).setMargins(0, 0, 0, ax.aB(this));
      this.KLK.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int i = i.c.sns_ad_constant_white;
    if (!fVt())
    {
      i = getResources().getColor(i.c.sns_ad_constant_black);
      if ((this.Kyx == null) || (this.Kyx.size() <= 0) || (Util.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.Kyx.getFirst()).nWx))) {
        break label365;
      }
      i = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.Kyx.getFirst()).nWx);
    }
    label365:
    for (;;)
    {
      this.KLP.setBackgroundColor(i);
      i = i.c.sns_ad_constant_black;
      localObject = this.kHA.getDrawable();
      if (localObject != null)
      {
        androidx.core.graphics.drawable.a.a((Drawable)localObject, androidx.core.content.a.w(this, i));
        this.kHA.setImageDrawable((Drawable)localObject);
      }
      localObject = this.HMY.getDrawable();
      if (localObject != null)
      {
        androidx.core.graphics.drawable.a.a((Drawable)localObject, androidx.core.content.a.w(this, i));
        this.HMY.setImageDrawable((Drawable)localObject);
      }
      if ((fVu()) && (!fVv()) && (this.bizId == 2))
      {
        this.HMY.setVisibility(8);
        this.KLp.setVisibility(0);
        this.KLp.setText(this.KLu);
        this.KLp.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(223106);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            SnsAdNativeLandingPagesUI.this.Q(SnsAdNativeLandingPagesUI.this, SnsAdNativeLandingPagesUI.B(SnsAdNativeLandingPagesUI.this), SnsAdNativeLandingPagesUI.C(SnsAdNativeLandingPagesUI.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(223106);
          }
        });
        AppMethodBeat.o(98365);
        return;
      }
      if (fVr())
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "canShowMenuBtn=true, disableShareBitSet=" + this.KLL);
        this.HMY.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(268278);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            SnsAdNativeLandingPagesUI.this.fVf();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(268278);
          }
        });
        AppMethodBeat.o(98365);
        return;
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "canShowMenuBtn=false, disableShareBitSet=" + this.KLL);
      this.HMY.setVisibility(8);
      AppMethodBeat.o(98365);
      return;
    }
  }
  
  private void report()
  {
    AppMethodBeat.i(98368);
    Object localObject1 = getAllComp();
    Object localObject2 = this.KLW.values().iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).addAll(((SnsAdLandingPageFloatView)((Iterator)localObject2).next()).getAllComp());
    }
    if (this.KLY != null)
    {
      ((List)localObject1).add(this.KLY);
      localObject2 = this.KLY.fQR();
      if (localObject2 != null)
      {
        this.KLY.fQQ();
        ((List)localObject1).add(localObject2);
      }
    }
    if (this.KLX != null)
    {
      localObject2 = this.KLX.fKI();
      if (com.tencent.mm.plugin.sns.ad.i.d.n((Collection)localObject2)) {
        ((List)localObject1).addAll((Collection)localObject2);
      }
    }
    this.fOa += System.currentTimeMillis() - this.startTime;
    this.KLB.KyZ = ((int)this.fOa);
    this.KLB.KyY = ((List)localObject1).size();
    localObject2 = this.KLB;
    Iterator localIterator = ((List)localObject1).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m localm = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m)localIterator.next();
      if (!localm.KqB.KmK)
      {
        JSONObject localJSONObject = new JSONObject();
        if ((!localm.H(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject2).Kzc)) && (localm.by(localJSONObject))) {
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject2).Kzc.put(localJSONObject);
        }
      }
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "landingPage report json %s", new Object[] { this.KLB.Kzc });
    localObject2 = this.KLB.fSu();
    if (this.bizId == 2)
    {
      AdLandingPagesProxy.getInstance().doCgiReportCanvasBrowseInfo(15041, (String)localObject2);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "post cgi stat 15041 data: ".concat(String.valueOf(localObject2)));
    }
    for (;;)
    {
      localObject2 = this.KMn;
      long l1 = ((a.c)localObject2).JCI;
      long l2 = ((a.c)localObject2).JCH;
      long l3 = ((a.c)localObject2).JCM;
      long l4 = ((a.c)localObject2).JCH;
      long l5 = ((a.c)localObject2).JCN;
      long l6 = ((a.c)localObject2).JCH;
      ((a.c)localObject2).JCP = ("onCreateTime=" + (l1 - l2) + "|viewCreate=" + (l3 - l4) + "|firstFrame=" + (l5 - l6));
      int i = (int)(((a.c)localObject2).JCH - ((a.c)localObject2).mStartTime);
      int j = (int)(((a.c)localObject2).JCL - ((a.c)localObject2).JCK);
      com.tencent.mm.sdk.platformtools.Log.i("AdLandingPageStaticHelper", "reportTime, ipcConnTime=" + j + "|processTime=" + i + "|" + ((a.c)localObject2).JCP);
      l.a(l.JQT, String.valueOf(((a.c)localObject2).JCO), i, j, ((a.c)localObject2).JCP);
      localObject1 = new com.tencent.mm.plugin.sns.ad.landingpage.helper.a.b().hu((List)localObject1);
      try
      {
        l.a(l.JQU, String.valueOf(((com.tencent.mm.plugin.sns.ad.landingpage.helper.a.b)localObject1).JCF), ((com.tencent.mm.plugin.sns.ad.landingpage.helper.a.b)localObject1).JCD, ((com.tencent.mm.plugin.sns.ad.landingpage.helper.a.b)localObject1).JCE, String.valueOf(((com.tencent.mm.plugin.sns.ad.landingpage.helper.a.b)localObject1).JCG));
        com.tencent.mm.plugin.sns.ad.landingpage.helper.a.ax(1L, ((com.tencent.mm.plugin.sns.ad.landingpage.helper.a.b)localObject1).JCD);
        com.tencent.mm.plugin.sns.ad.landingpage.helper.a.ax(2L, ((com.tencent.mm.plugin.sns.ad.landingpage.helper.a.b)localObject1).JCE);
        com.tencent.mm.plugin.sns.ad.landingpage.helper.a.ax(3L, ((com.tencent.mm.plugin.sns.ad.landingpage.helper.a.b)localObject1).JCF);
        com.tencent.mm.plugin.sns.ad.landingpage.helper.a.ax(4L, ((com.tencent.mm.plugin.sns.ad.landingpage.helper.a.b)localObject1).JCG);
        com.tencent.mm.plugin.sns.ad.landingpage.helper.a.ax(5L, ((com.tencent.mm.plugin.sns.ad.landingpage.helper.a.b)localObject1).jlf);
        AppMethodBeat.o(98368);
        return;
      }
      catch (Throwable localThrowable)
      {
        com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageStaticHelper.ComponentStaticBuilder", "report exp=" + localThrowable.toString());
        AppMethodBeat.o(98368);
      }
      if (AdLandingPagesProxy.getInstance().isRecExpAd(this.KLB.fLp))
      {
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(14650, (String)localObject2);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 14650 data: ".concat(String.valueOf(localObject2)));
      }
      else
      {
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(13387, (String)localObject2);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 13387 data: ".concat(String.valueOf(localObject2)));
      }
    }
  }
  
  private void t(ContentFragment paramContentFragment)
  {
    AppMethodBeat.i(98399);
    if (!fVF()) {
      paramContentFragment.fRW();
    }
    AppMethodBeat.o(98399);
  }
  
  public final void Q(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(98396);
    Intent localIntent = new Intent();
    localIntent.putExtra("sns_landig_pages_from_source", 14);
    int i;
    String str2;
    String str1;
    JSONObject localJSONObject;
    if (this.Knp == 0)
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
      com.tencent.mm.by.c.b(paramContext, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
      AppMethodBeat.o(98396);
      return;
      i = this.Knp;
      break;
      paramString1 = "";
    }
  }
  
  public final void QV(long paramLong)
  {
    AppMethodBeat.i(98403);
    if ((this.KLY == null) || (this.KLn == null))
    {
      AppMethodBeat.o(98403);
      return;
    }
    if (this.KLY.Kpr)
    {
      AppMethodBeat.o(98403);
      return;
    }
    ContentFragment localContentFragment = fVx();
    if (localContentFragment == null)
    {
      AppMethodBeat.o(98403);
      return;
    }
    boolean bool1 = fVG();
    boolean bool2 = localContentFragment.fRU();
    boolean bool3 = this.KMa;
    boolean bool4 = localContentFragment.Kvu;
    boolean bool5 = localContentFragment.mMk;
    boolean bool6 = localContentFragment.fRT();
    boolean bool7 = this.KLZ;
    boolean bool8 = localContentFragment.fSb();
    boolean bool9 = localContentFragment.fSa();
    if ((bool4) && (bool8)) {
      this.KMb = true;
    }
    if (!bool4) {
      this.KMb = true;
    }
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SnsAdNativeLandingPagesUI", "toggleFloatBarView, isSourceAllow=" + bool1 + ", isForbid=" + bool2 + ", isKeybordShow=" + bool3 + ", isFirstPage=" + bool4 + ", isLastPage=" + bool5 + ", isCoverVideo=" + bool6 + ", isVideoCtrlBarShow=" + bool7 + ", isTopAppearOk=" + bool8 + ", isBottomAppearOk=" + bool9 + ", IsTopAppearChecked=" + this.KMb);
    if (!bool1)
    {
      n(false, 0L);
      AppMethodBeat.o(98403);
      return;
    }
    if (bool2)
    {
      n(true, 0L);
      AppMethodBeat.o(98403);
      return;
    }
    if (bool3)
    {
      n(false, 0L);
      AppMethodBeat.o(98403);
      return;
    }
    if ((bool6) && (bool7))
    {
      n(true, 200L);
      AppMethodBeat.o(98403);
      return;
    }
    if ((bool5) && (!bool9))
    {
      n(true, 0L);
      AppMethodBeat.o(98403);
      return;
    }
    if ((bool4) && (!bool8) && (!this.KMb))
    {
      AppMethodBeat.o(98403);
      return;
    }
    Rj(paramLong);
    AppMethodBeat.o(98403);
  }
  
  public final void a(final com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa paramaa, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, final boolean paramBoolean3)
  {
    AppMethodBeat.i(98395);
    if ((this.KMC != null) && (!paramBoolean3))
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.SnsAdNativeLandingPagesUI", "bottom sheet appear several times");
      this.KMC.bYF();
      if (this.KMD != null)
      {
        this.KMD.dismiss();
        this.KMD = null;
      }
      AppMethodBeat.o(98395);
      return;
    }
    AdLandingPagesProxy.e local21 = new AdLandingPagesProxy.e()
    {
      public final void aH(Object paramAnonymousObject) {}
      
      public final void i(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(201399);
        SnsAdNativeLandingPagesUI.this.yT(false);
        if (paramBoolean3)
        {
          if (SnsAdNativeLandingPagesUI.X(SnsAdNativeLandingPagesUI.this) != null) {
            SnsAdNativeLandingPagesUI.X(SnsAdNativeLandingPagesUI.this).bYF();
          }
          if (SnsAdNativeLandingPagesUI.Y(SnsAdNativeLandingPagesUI.this) != null)
          {
            SnsAdNativeLandingPagesUI.Y(SnsAdNativeLandingPagesUI.this).dismiss();
            SnsAdNativeLandingPagesUI.Z(SnsAdNativeLandingPagesUI.this);
          }
        }
        AppMethodBeat.o(201399);
      }
    };
    AppCompatActivity localAppCompatActivity;
    LinearLayout localLinearLayout;
    if (!paramBoolean3)
    {
      localAppCompatActivity = getContext();
      localLinearLayout = new LinearLayout(getContext());
      if (Util.isNullOrNil(paramaa.KmG)) {
        break label223;
      }
    }
    label223:
    for (int i = Color.parseColor(paramaa.KmG);; i = -1)
    {
      paramaa = ba.a(localAppCompatActivity, paramaa, localLinearLayout, i);
      this.KMC = new n(getContext(), paramaa, paramString1, paramString2, paramString3, paramBoolean1, paramBoolean2);
      paramaa = paramaa.getView();
      this.KMC.KqJ = new n.a()
      {
        private void onRemove()
        {
          AppMethodBeat.i(259895);
          if ((paramaa != null) && (paramaa.getParent() != null)) {
            ((ViewGroup)paramaa.getParent()).removeView(paramaa);
          }
          SnsAdNativeLandingPagesUI.aa(SnsAdNativeLandingPagesUI.this);
          AppMethodBeat.o(259895);
        }
        
        public final void fRq()
        {
          AppMethodBeat.i(259892);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "onDismiss");
          onRemove();
          AppMethodBeat.o(259892);
        }
        
        public final void fRr()
        {
          AppMethodBeat.i(259893);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "onCancel");
          onRemove();
          AppMethodBeat.o(259893);
        }
      };
      this.KMC.eik();
      if (!Util.isNullOrNil(paramString1))
      {
        AdLandingPagesProxy.getInstance().doFavOfficialItemScene(paramString1, local21);
        if (paramBoolean3) {
          this.KMD = com.tencent.mm.ui.base.h.a(this, getString(i.j.sns_loading), false, null);
        }
      }
      AppMethodBeat.o(98395);
      return;
    }
  }
  
  public final void cJs()
  {
    AppMethodBeat.i(98384);
    Object localObject;
    try
    {
      Iterator localIterator1 = this.KLW.values().iterator();
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
    fVe();
    fVg();
    report();
    this.KLD = true;
    this.KLP.setVisibility(8);
    if (!this.KLq)
    {
      finish();
      AppMethodBeat.o(98384);
      return;
    }
    if (this.KLU)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "is playing animation");
      AppMethodBeat.o(98384);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "run exit animation, %s", new Object[] { Boolean.valueOf(this.KLq) });
    this.KLU = true;
    if (isSupportNavigationSwipeBack()) {
      getSwipeBackLayout().setEnableGesture(false);
    }
    Iterator localIterator2 = fVx().fRQ().iterator();
    while (localIterator2.hasNext())
    {
      localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m)localIterator2.next();
      if ((localObject instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a))
      {
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject).fKr();
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m)localObject).fRn();
      }
    }
    fUY();
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193727);
        SnsAdNativeLandingPagesUI.V(SnsAdNativeLandingPagesUI.this);
        AppMethodBeat.o(193727);
      }
    }, 30L);
    AppMethodBeat.o(98384);
  }
  
  public boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  public final com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai fRp()
  {
    AppMethodBeat.i(269221);
    if (this.JWV == null) {
      this.JWV = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai();
    }
    Object localObject1 = this.JWV;
    int i;
    Object localObject2;
    label182:
    boolean bool;
    if (this.Knp == 0)
    {
      i = this.source;
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)localObject1).Knp = i;
      this.JWV.source = this.source;
      this.JWV.Knq = this.KLA;
      this.JWV.uxInfo = this.uxInfo;
      this.JWV.Knr = this.Knr;
      this.JWV.uin = this.uin;
      this.JWV.bizId = this.bizId;
      this.JWV.aid = this.aid;
      this.JWV.nTp = this.nTp;
      localObject1 = this.JWV;
      localObject2 = this.Knw;
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)localObject1).Knw.putAll((Map)localObject2);
      localObject2 = this.JWV;
      if (this.KLB == null) {
        break label368;
      }
      localObject1 = this.KLB.owd;
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)localObject2).owd = ((String)localObject1);
      localObject1 = this.JWV;
      if (this.KLn == null) {
        break label376;
      }
      bool = true;
      label204:
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)localObject1).Kns = bool;
      this.JWV.Knv = this.Knv;
    }
    for (;;)
    {
      try
      {
        localObject2 = this.JWV;
        if (!Util.isNullOrNil(this.fLp)) {
          continue;
        }
        if (this.KLB == null) {
          continue;
        }
        localObject1 = String.valueOf(com.tencent.mm.plugin.sns.data.m.aYS(this.KLB.fLp));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)localObject2).fLp = ((String)localObject1);
      }
      catch (Throwable localThrowable)
      {
        label368:
        label376:
        long l;
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", localThrowable.toString());
        continue;
      }
      if (!Util.isNullOrNil(new String[] { this.viewId, this.Knt }))
      {
        this.JWV.viewId = this.viewId;
        this.JWV.Knt = this.Knt;
      }
      this.JWV.adExtInfo = this.adExtInfo;
      this.JWV.Knu = this.Knu;
      this.JWV.pId = this.pId;
      localObject1 = this.JWV;
      AppMethodBeat.o(269221);
      return localObject1;
      i = this.Knp;
      break;
      localObject1 = "";
      break label182;
      bool = false;
      break label204;
      localObject1 = "";
      continue;
      l = com.tencent.mm.plugin.sns.data.m.aYS(this.fLp);
      localObject1 = String.valueOf(l);
    }
  }
  
  public final void fUZ()
  {
    AppMethodBeat.i(269208);
    if (this.Kyx == null)
    {
      AppMethodBeat.o(269208);
      return;
    }
    Iterator localIterator = this.Kyx.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localIterator.next();
      localObject = (ContentFragment)this.KMy.get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject).id));
      if (localObject != null) {
        ((ContentFragment)localObject).fRY();
      }
    }
    t((ContentFragment)this.KMy.get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.Kyx.getFirst()).id)));
    AppMethodBeat.o(269208);
  }
  
  public final void fVB()
  {
    AppMethodBeat.i(269232);
    try
    {
      boolean bool = fVC();
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "jumpNextPage, hasNextPage=".concat(String.valueOf(bool)));
      if (bool) {
        this.KLK.agw(this.KLK.getCurrentItem() + 1);
      }
      AppMethodBeat.o(269232);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "jumpNextPage exp:" + localException.toString());
      AppMethodBeat.o(269232);
    }
  }
  
  public final boolean fVC()
  {
    AppMethodBeat.i(98397);
    try
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.KLK.getAdapter();
      int i = this.KLK.getCurrentItem();
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
  
  public final boolean fVF()
  {
    AppMethodBeat.i(98400);
    if (this.KLY != null)
    {
      boolean bool = this.KLY.isShowing();
      AppMethodBeat.o(98400);
      return bool;
    }
    AppMethodBeat.o(98400);
    return false;
  }
  
  public final void fVf()
  {
    AppMethodBeat.i(269216);
    if (this.HMY.getVisibility() != 0)
    {
      AppMethodBeat.o(269216);
      return;
    }
    fVe();
    this.KMj = new com.tencent.mm.ui.widget.a.e(this, 1, false);
    this.KMj.ODT = new q.f()
    {
      public final void onCreateMMMenu(o paramAnonymouso)
      {
        AppMethodBeat.i(196896);
        if ((SnsAdNativeLandingPagesUI.D(SnsAdNativeLandingPagesUI.this) == 0) || ((SnsAdNativeLandingPagesUI.D(SnsAdNativeLandingPagesUI.this) & 0x2) == 0)) {
          paramAnonymouso.b(1, SnsAdNativeLandingPagesUI.this.getString(i.j.retransmits), i.i.bottomsheet_icon_transmit);
        }
        if ((SnsAdNativeLandingPagesUI.D(SnsAdNativeLandingPagesUI.this) == 0) || ((SnsAdNativeLandingPagesUI.D(SnsAdNativeLandingPagesUI.this) & 0x1) == 0)) {
          paramAnonymouso.b(2, SnsAdNativeLandingPagesUI.this.getString(i.j.sns_ad_video_right_menu_share_sns), i.i.bottomsheet_icon_moment);
        }
        if (((SnsAdNativeLandingPagesUI.D(SnsAdNativeLandingPagesUI.this) == 0) || ((SnsAdNativeLandingPagesUI.D(SnsAdNativeLandingPagesUI.this) & 0x4) == 0)) && (SnsAdNativeLandingPagesUI.w(SnsAdNativeLandingPagesUI.this) != 7)) {
          paramAnonymouso.b(3, SnsAdNativeLandingPagesUI.this.getString(i.j.chatting_fav), i.i.bottomsheet_icon_fav);
        }
        if (((SnsAdNativeLandingPagesUI.D(SnsAdNativeLandingPagesUI.this) == 0) || (SnsAdNativeLandingPagesUI.E(SnsAdNativeLandingPagesUI.this))) && (SnsAdNativeLandingPagesUI.v(SnsAdNativeLandingPagesUI.this) == 2) && (SnsAdNativeLandingPagesUI.F(SnsAdNativeLandingPagesUI.this))) {
          if (SnsAdNativeLandingPagesUI.G(SnsAdNativeLandingPagesUI.this) == null) {
            break label276;
          }
        }
        label276:
        for (String str = SnsAdNativeLandingPagesUI.G(SnsAdNativeLandingPagesUI.this);; str = "")
        {
          paramAnonymouso.b(4, str, 0);
          if (((SnsAdNativeLandingPagesUI.D(SnsAdNativeLandingPagesUI.this) == 0) || ((SnsAdNativeLandingPagesUI.D(SnsAdNativeLandingPagesUI.this) & 0x20) == 0)) && (SnsAdNativeLandingPagesUI.H(SnsAdNativeLandingPagesUI.this) != null) && (SnsAdNativeLandingPagesUI.H(SnsAdNativeLandingPagesUI.this).LkA != null)) {
            paramAnonymouso.b(5, SnsAdNativeLandingPagesUI.this.getString(i.j.sns_ad_video_right_menu_open_in_browser), 0);
          }
          AppMethodBeat.o(196896);
          return;
        }
      }
    };
    this.KMj.pMG = true;
    this.KMj.ODU = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(266892);
        ao.aQ(SnsAdNativeLandingPagesUI.this);
        if (paramAnonymousMenuItem != null) {
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(266892);
          return;
          SnsAdNativeLandingPagesUI.I(SnsAdNativeLandingPagesUI.this);
          AppMethodBeat.o(266892);
          return;
          SnsAdNativeLandingPagesUI.J(SnsAdNativeLandingPagesUI.this);
          AppMethodBeat.o(266892);
          return;
          SnsAdNativeLandingPagesUI.K(SnsAdNativeLandingPagesUI.this);
          AppMethodBeat.o(266892);
          return;
          SnsAdNativeLandingPagesUI.this.Q(SnsAdNativeLandingPagesUI.this, SnsAdNativeLandingPagesUI.B(SnsAdNativeLandingPagesUI.this), SnsAdNativeLandingPagesUI.C(SnsAdNativeLandingPagesUI.this));
          AppMethodBeat.o(266892);
          return;
          SnsAdNativeLandingPagesUI.L(SnsAdNativeLandingPagesUI.this);
        }
      }
    };
    hideVKB();
    this.KMj.eik();
    AppMethodBeat.o(269216);
  }
  
  public final void fVn()
  {
    AppMethodBeat.i(269222);
    Object localObject = getAllComp();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m)((List)localObject).get(0);
      if ((localObject instanceof ag))
      {
        ((ag)localObject).Ktq = true;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "snsId = " + this.fLp + ", adSightVideoSeekTime = " + this.Knu + ", isFirstSightVideoComp = true");
        AppMethodBeat.o(269222);
        return;
      }
      if ((localObject instanceof com.tencent.mm.plugin.sns.ad.landingpage.component.a.f))
      {
        ((com.tencent.mm.plugin.sns.ad.landingpage.component.a.f)localObject).JAU = true;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "snsId = " + this.fLp + ", adVideoSeekTime = " + this.Knu + ", isFirstVideoComp = true");
      }
    }
    AppMethodBeat.o(269222);
  }
  
  public final void fVo()
  {
    AppMethodBeat.i(269223);
    this.KvC = false;
    a.a.fKM().stop();
    if (this.JAK != null)
    {
      this.JAK.setFullScreen(this.KvC);
      this.JAK.fKz();
      ViewGroup localViewGroup = this.JAK.getVideoCompContainer();
      AdLandingVideoPlayerToolBar localAdLandingVideoPlayerToolBar = this.JAK.getToolBar();
      localAdLandingVideoPlayerToolBar.yt(false);
      this.JAK.setAnimImmediately(true);
      this.JAK.aeN(0);
      this.JAK.fKB();
      Object localObject = (ViewGroup)this.JAK.getParent();
      this.KLO.removeView((View)localObject);
      ((ViewGroup)localObject).removeView(this.JAK);
      ((ViewGroup)localObject).removeView(localAdLandingVideoPlayerToolBar);
      if (!this.KMk) {
        getSwipeBackLayout().setEnableGesture(true);
      }
      localViewGroup.addView(this.JAK);
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      localViewGroup.addView(localAdLandingVideoPlayerToolBar, (ViewGroup.LayoutParams)localObject);
      fVp();
    }
    AppMethodBeat.o(269223);
  }
  
  public final void fVq()
  {
    AppMethodBeat.i(98379);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.KLK.getAdapter();
    if (localb == null)
    {
      localb = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b(getSupportFragmentManager(), new ArrayList());
      this.KLK.setAdapter(localb);
    }
    for (;;)
    {
      List localList = fVm();
      int i = 0;
      if (i < localList.size())
      {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g localg = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.Kyx.get(i);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "loadLandingPages load id %s", new Object[] { Integer.valueOf(localg.id) });
        ContentFragment localContentFragment = (ContentFragment)this.KMy.get(Integer.valueOf(localg.id));
        boolean bool;
        label214:
        label244:
        int j;
        if (localContentFragment == null)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("pageInfo", localg);
          localHashMap.put("pageCount", Integer.valueOf(localList.size()));
          localHashMap.put("viewPager", this.KLK);
          localHashMap.put("pageDownIconInfo", this.Kvt);
          if (i == 0)
          {
            bool = true;
            localHashMap.put("is_first_show_page", Boolean.valueOf(bool));
            if (i != localList.size() - 1) {
              break label393;
            }
            bool = true;
            localHashMap.put("is_last_shown_page", Boolean.valueOf(bool));
            localHashMap.put("needEnterAnimation", Boolean.valueOf(this.KLq));
            localHashMap.put("needDirectionAnimation", Boolean.valueOf(fVs()));
            if (i != 0) {
              break label398;
            }
            j = this.KLE;
            label304:
            localHashMap.put("groupListCompShowIndex", Integer.valueOf(j));
            localContentFragment = new ContentFragment();
            localContentFragment.params = localHashMap;
            if (i == 0) {
              localContentFragment.KvE = this.KMr;
            }
            this.KMy.put(Integer.valueOf(localg.id), localContentFragment);
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
      this.KLK.setOffscreenPageLimit(localList.size());
      AppMethodBeat.o(98379);
      return;
    }
  }
  
  public final ContentFragment fVx()
  {
    AppMethodBeat.i(98387);
    ContentFragment localContentFragment = null;
    if (this.Kyx.size() > 0) {
      localContentFragment = (ContentFragment)this.KMy.get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.Kyx.get(this.KLK.getCurrentItem())).id));
    }
    AppMethodBeat.o(98387);
    return localContentFragment;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return i.g.sns_ad_native_landing_pages_ui;
  }
  
  @TargetApi(16)
  public void initView()
  {
    AppMethodBeat.i(98381);
    super.initView();
    this.KLO = ((FrameLayout)findViewById(i.f.root));
    this.xYJ = findViewById(i.f.content_container);
    this.KLK = ((AdlandingDummyViewPager)findViewById(i.f.vertical_viewpager));
    this.KLP = findViewById(i.f.menu_container);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "before, assistActivity");
    Object localObject1;
    Object localObject2;
    String str;
    if (com.tencent.mm.ui.ar.aN(getContext()))
    {
      final int i = com.tencent.mm.ui.ar.aM(this);
      localObject1 = (FrameLayout.LayoutParams)this.KLO.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject1).height = (this.pEk - i);
      ((FrameLayout.LayoutParams)localObject1).topMargin = i;
      this.KLO.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      getController().setActionbarColor(getResources().getColor(i.c.action_bar_color));
      this.KLO.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(196948);
          try
          {
            paramAnonymousView = new Rect();
            SnsAdNativeLandingPagesUI.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(paramAnonymousView);
            paramAnonymousInt1 = paramAnonymousView.top;
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "rect=" + paramAnonymousView.toString() + ", screenH=" + SnsAdNativeLandingPagesUI.d(SnsAdNativeLandingPagesUI.this) + ", cutH=" + i + ", statusBarH=" + paramAnonymousInt1);
            if (paramAnonymousInt1 > 0)
            {
              if (paramAnonymousInt1 != i)
              {
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "cutH != statusBarH, reset height");
                paramAnonymousView = (FrameLayout.LayoutParams)SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this).getLayoutParams();
                paramAnonymousView.height = (SnsAdNativeLandingPagesUI.d(SnsAdNativeLandingPagesUI.this) - paramAnonymousInt1);
                paramAnonymousView.topMargin = paramAnonymousInt1;
                SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this).setLayoutParams(paramAnonymousView);
                l.a(l.JQK, "", i, paramAnonymousInt1, SnsAdNativeLandingPagesUI.S(SnsAdNativeLandingPagesUI.this) + "|" + SnsAdNativeLandingPagesUI.d(SnsAdNativeLandingPagesUI.this));
              }
              SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this).removeOnLayoutChangeListener(this);
            }
            AppMethodBeat.o(196948);
            return;
          }
          catch (Throwable paramAnonymousView)
          {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "onLayoutChange error:" + paramAnonymousView.toString());
            SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this).removeOnLayoutChangeListener(this);
            AppMethodBeat.o(196948);
          }
        }
      });
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98342);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "hasCutOut, assistActivity");
          com.tencent.mm.ui.c.a(SnsAdNativeLandingPagesUI.this, true, SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this), SnsAdNativeLandingPagesUI.this.KMA);
          AppMethodBeat.o(98342);
        }
      }, 1500L);
      this.mLT = ((ImageView)findViewById(i.f.gallery_bg));
      this.KLo = ((ImageView)findViewById(i.f.anim_bg));
      this.kHA = ((ImageView)findViewById(i.f.sns_ad_native_landing_pages_close_img));
      localObject2 = (TextView)findViewById(i.f.sns_ad_native_landing_pages_left_bar_title);
      this.kHA.setOnClickListener(this.KMF);
      ((TextView)localObject2).setOnClickListener(this.KMG);
      if (!com.tencent.mm.plugin.sns.ad.h.a.aeP(this.source)) {
        break label430;
      }
      ((TextView)localObject2).setVisibility(0);
      this.kHA.setVisibility(8);
      this.KMk = true;
      this.KLq = false;
      str = this.Knv;
      localObject1 = com.tencent.mm.plugin.sns.ad.h.a.aYC(str);
      org.xwalk.core.Log.i("LandingPageOpenSdkBackHelper", "initBackLayout, extra=".concat(String.valueOf(str)));
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label392;
      }
      org.xwalk.core.Log.e("LandingPageOpenSdkBackHelper", "appId is empty");
    }
    for (;;)
    {
      this.HMY = ((ImageView)findViewById(i.f.sns_ad_native_landing_pages_more_img));
      this.KLp = ((TextView)findViewById(i.f.sns_ad_native_landing_pages_right_bar_title));
      this.KLx = ((ImageView)findViewById(i.f.sns_native_landing_first_screen_next_img));
      if (!this.KMl.fKD()) {
        break label447;
      }
      AppMethodBeat.o(98381);
      return;
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(179177);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "noCutOut, assistActivity");
          com.tencent.mm.ui.c.a(SnsAdNativeLandingPagesUI.this, false, SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this), SnsAdNativeLandingPagesUI.this.KMA);
          AppMethodBeat.o(179177);
        }
      }, 1500L);
      break;
      label392:
      str = getString(i.j.sns_ad_back);
      localObject2 = new WeakReference(localObject2);
      AdLandingPagesProxy.getInstance().getOpenSdkAppInfo((String)localObject1, new a.1((WeakReference)localObject2, str));
      continue;
      label430:
      ((TextView)localObject2).setVisibility(8);
      this.kHA.setVisibility(0);
    }
    label447:
    if (this.KLq)
    {
      this.KLO.setAlpha(0.0F);
      this.mLT.setAlpha(0.0F);
      com.tencent.mm.ui.base.b.a(this, null);
    }
    AppMethodBeat.o(98381);
  }
  
  public final void n(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(98402);
    if (this.KLY != null)
    {
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SnsAdNativeLandingPagesUI", "hideFloatBarView");
      this.KLY.m(paramBoolean, paramLong);
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
        localObject3 = Util.nullAsNil(this.KLB.owd);
      }
    }
    for (;;)
    {
      try
      {
        str = com.tencent.mm.plugin.sns.a.b.G("3", "", str, (String)localObject3);
        com.tencent.mm.sdk.platformtools.Log.i("AntiCheatingReportUtils", "reportScreenShotParams = ".concat(String.valueOf(str)));
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(19214, str);
        com.tencent.mm.ui.base.h.cO(getContext(), getContext().getString(i.j.app_shared));
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
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "handleOpenInBrowserResult, ret=".concat(String.valueOf(((com.tencent.mm.api.aa)com.tencent.mm.kernel.h.ae(com.tencent.mm.api.aa.class)).a(this, paramInt1, paramInt2, paramIntent))));
      }
      else
      {
        int i;
        if (paramInt1 == 2002)
        {
          if (com.tencent.mm.plugin.sns.ad.i.h.getBooleanExtra(paramIntent, "kfavorite", false))
          {
            i = AdLandingPagesProxy.getInstance().doFav(paramIntent, 42);
            ((com.tencent.mm.plugin.fav.a.w)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fav.a.w.class)).a(i, 42, this, this.CBU);
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
              } while (!((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m)localObject4).KqB.KmB.equals(localObject1));
              localObject1 = (ag)localObject4;
              i = paramIntent.getIntExtra("KStreamVideoPlayCount", 0);
              j = paramIntent.getIntExtra("KStreamVideoPlayCompleteCount", 0);
              k = paramIntent.getIntExtra("KStreamVideoTotalPlayTimeInMs", 0);
              ((ag)localObject1).JFq = (i + ((ag)localObject1).JFq);
              ((ag)localObject1).JFr += j;
              ((ag)localObject1).JFs += k;
            }
            catch (Exception localException) {}
          }
          else
          {
            Object localObject2;
            if (paramInt1 == 2003)
            {
              localObject2 = new wj();
              ((wj)localObject2).fVC.Vh = 1;
              ((wj)localObject2).fVC.requestCode = paramInt1;
              ((wj)localObject2).fVC.resultCode = paramInt2;
              ((wj)localObject2).fVC.fJJ = paramIntent;
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
                } while (!((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m)localObject3).KqB.KmB.equals(localObject2));
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
                this.fOa += l2;
                com.tencent.mm.sdk.platformtools.Log.i("VideoFullScreenActivity", "videoType = " + i + ", cid = " + (String)localObject2 + ", currPosSec = " + j + ", bNoVoice = " + bool1 + ", isPlaying = " + bool2 + ", clickPlayControlCount = " + k + ", doubleClickCount = " + m + ", clickVoiceControlCount = " + n + ", playCompletedCount = " + i1 + ", playCount = " + i2 + ", playTimeInterval = " + l1 + ", floatBarReportInfo = " + (String)localObject4 + ", fullScreenStayTime = " + l2);
                if (i != 0) {
                  break label873;
                }
                ((ag)localObject3).a(j, bool1, bool2, k, m, n, i1, i2, l1, (String)localObject4, l2);
              }
              catch (Throwable localThrowable2)
              {
                com.tencent.mm.sdk.platformtools.Log.e("VideoFullScreenActivity", localThrowable2.toString());
              }
              continue;
              label873:
              if (i == 1) {
                ((ak)localObject3).a(j, bool1, bool2, k, m, n, i1, i2, l1, bool3, i3, (String)localObject4, l2);
              }
            }
          }
        }
      }
    }
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(269217);
    super.onAttachedToWindow();
    fUY();
    AppMethodBeat.o(269217);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(98386);
    if (this.KvC)
    {
      fVo();
      AppMethodBeat.o(98386);
      return;
    }
    cJs();
    if (com.tencent.mm.plugin.sns.ad.h.a.aeP(this.source)) {
      fVH();
    }
    AppMethodBeat.o(98386);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool2 = true;
    AppMethodBeat.i(98363);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SnsAdNativeLandingPagesUI.launch", "onCreate");
    this.KMn.JCH = System.currentTimeMillis();
    this.KMl = new com.tencent.mm.plugin.sns.ad.landingpage.helper.a.a(this);
    this.startTime = System.currentTimeMillis();
    this.enterTime = System.currentTimeMillis();
    this.KLB.enterTime = this.enterTime;
    ao.aQ(this);
    Object localObject = ao.ib(this);
    this.pEj = localObject[0];
    this.pEk = localObject[1];
    this.savedInstanceState = paramBundle;
    this.mController.hideTitleView();
    this.twC = getIntent().getIntExtra("img_gallery_top", 0);
    if (com.tencent.mm.ui.ar.aN(this))
    {
      i = com.tencent.mm.ui.ar.aM(this);
      this.twC -= i;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "hasCutOut, h=" + i + ", thumbTop=" + this.twC);
    }
    this.twD = getIntent().getIntExtra("img_gallery_left", 0);
    this.twE = getIntent().getIntExtra("img_gallery_width", 0);
    this.twF = getIntent().getIntExtra("img_gallery_height", 0);
    long l = getIntent().getLongExtra("sns_landing_page_start_time", 0L);
    this.KMn.mStartTime = l;
    getWindow().addFlags(128);
    this.isVisible = false;
    this.KMd = false;
    this.KMe = false;
    this.KMf = false;
    if (this.KMg != null) {
      this.KMg.removeCallbacks(this.KMw);
    }
    this.source = getIntent().getIntExtra("sns_landig_pages_from_source", 0);
    this.Knp = getIntent().getIntExtra("sns_landig_pages_origin_from_source", 0);
    paramBundle = this.KMn;
    int i = this.source;
    paramBundle.JCO = i;
    switch (i)
    {
    default: 
      i = 14;
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.ad.landingpage.helper.a.aw(1673L, i);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "source=" + this.source + ", originScene=" + this.Knp);
      this.KLs = getIntent().getStringExtra("sns_landing_pages_xml");
      this.Knv = getIntent().getStringExtra("sns_landing_pages_extra_param");
      paramBundle = getIntent().getStringExtra("sns_landing_pages_too_large_xml_path");
      if ((Util.isNullOrNil(this.KLs)) && (!Util.isNullOrNil(paramBundle))) {
        this.KLs = ao.bbc(paramBundle);
      }
      if (Util.isNullOrNil(this.KLs))
      {
        finish();
        label560:
        initView();
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SnsAdNativeLandingPagesUI.launch", "before AdLandingPagesProxy connect");
        if (AdLandingPagesProxy.getInstance().isConnected()) {
          break label2307;
        }
        this.KMn.JCK = System.currentTimeMillis();
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "isConnected==false");
        AdLandingPagesProxy.getInstance().connect(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98360);
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "after Connected");
            SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).JCL = System.currentTimeMillis();
            SnsAdNativeLandingPagesUI.A(SnsAdNativeLandingPagesUI.this);
            AppMethodBeat.o(98360);
          }
        });
        EventCenter.instance.addListener(this.KMv);
      }
      try
      {
        registerReceiver(this.KMB, new IntentFilter("android.intent.action.SCREEN_ON"));
        this.KMn.JCI = System.currentTimeMillis();
        AppMethodBeat.o(98363);
        return;
        i = 6;
        continue;
        i = 7;
        continue;
        i = 8;
        continue;
        i = 9;
        continue;
        i = 10;
        continue;
        i = 11;
        continue;
        i = 12;
        continue;
        i = 13;
        continue;
        this.KLs = this.KLs.replaceAll("</*RecXml[\\s|\\S]*?>", "");
        this.KLB.KdZ = getIntent().getStringExtra("sns_landing_pages_expid");
        this.KLt = getIntent().getStringExtra("sns_landing_pages_xml_prefix");
        this.fLp = getIntent().getStringExtra("sns_landing_pages_share_sns_id");
        this.KLz = getIntent().getStringExtra("sns_landing_pages_rawSnsId");
        this.uxInfo = getIntent().getStringExtra("sns_landing_pages_ux_info");
        this.aid = getIntent().getStringExtra("sns_landing_pages_aid");
        this.nTp = getIntent().getStringExtra("sns_landing_pages_traceid");
        paramBundle = getIntent().getStringExtra("sns_landing_pages_search_extra");
        localObject = this.KLB;
        if (!TextUtils.isEmpty(paramBundle))
        {
          if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra.length() > 0) {
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra += "&";
          }
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra = (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra + "searchextra=" + URLEncoder.encode(paramBundle));
        }
        paramBundle = getIntent().getStringExtra("sns_landing_pages_extra");
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "initParams, extraData=".concat(String.valueOf(paramBundle)));
        localObject = this.KLB;
        if (!TextUtils.isEmpty(paramBundle))
        {
          if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra.length() > 0) {
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra += "&";
          }
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra += URLEncoder.encode(paramBundle);
        }
        this.KLA = getIntent().getBooleanExtra("sns_landing_is_native_sight_ad", false);
        this.recSrc = getIntent().getIntExtra("sns_landing_pages_rec_src", 0);
        this.KLE = getIntent().getIntExtra("sns_landing_pages_from_outer_index", 0);
        this.owf = getIntent().getStringExtra("sns_landing_pages_ad_info");
        this.KLq = getIntent().getBooleanExtra("sns_landing_pages_need_enter_and_exit_animation", false);
        this.KLr = getIntent().getBooleanExtra("sns_landing_pages_is_normal_ad_animation", false);
        this.KMm = getIntent().getBooleanExtra("sns_landing_page_is_interactive_canvas", false);
        this.Knu = getIntent().getLongExtra("sns_landing_page_sight_video_seek_time", 0L);
        this.KLB.uQm = this.source;
        this.KLB.KyU = 0;
        this.KLB.KyV = 0;
        this.KLB.KyW = 1;
        this.KLB.KyX = 0;
        this.KLB.Knp = this.Knp;
        if ((this.KLt == null) || ("".equals(this.KLs))) {
          this.KLt = "adxml";
        }
        if ((Util.isNullOrNil(this.KLs)) || (Util.isNullOrNil(this.KLt)))
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "landingPagesXml is " + this.KLs + ",landingPagesXmlPrex is " + this.KLt);
          break label560;
        }
        this.values = XmlParser.parseXml(this.KLs, this.KLt, null);
        label1480:
        label1532:
        String str2;
        label1537:
        label1577:
        boolean bool3;
        if (this.values != null)
        {
          this.KLB.owd = Util.nullAs((String)this.values.get("." + this.KLt + ".adCanvasInfo.id"), "");
          this.KMh = Util.nullAs((String)this.values.get("." + this.KLt + ".adExtInfo"), "");
          this.adExtInfo = com.tencent.mm.plugin.sns.data.k.aYR(this.KMh);
          if (Util.safeParseInt((String)this.values.get("." + this.KLt + ".forbiddenLeftSwipe")) == 1)
          {
            bool1 = true;
            this.KMk = bool1;
            if (Util.safeParseInt((String)this.values.get("." + this.KLt + ".forbiddenCustomAnimation")) != 1) {
              break label1991;
            }
            bool1 = true;
            this.forbiddenCustomAnimation = bool1;
            if (this.forbiddenCustomAnimation)
            {
              this.KLq = false;
              this.KLr = false;
            }
            if (!this.KLq) {
              break label2008;
            }
            this.KLB.jJH = 0;
            this.KLB.iQS = 0;
            paramBundle = this.KMl;
            paramBundle.JDg = paramBundle.JCQ.findViewById(i.f.gallery_bg);
            paramBundle.JDf = paramBundle.JCQ.findViewById(i.f.anim_bg);
            paramBundle.JDh = paramBundle.JCQ.findViewById(i.f.content_container);
            paramBundle.JDi = paramBundle.JCQ.findViewById(i.f.menu_container);
            paramBundle.JCY = paramBundle.JCQ.getIntent().getStringExtra("sns_landing_page_is_gesture_twist_card_id");
            i = paramBundle.JCQ.fRp().source;
            localObject = paramBundle.JCQ.values;
            String str1 = paramBundle.JCQ.KLt;
            str2 = paramBundle.JCQ.KLs;
            if (localObject != null)
            {
              paramBundle.JCS = ADXml.k.V((Map)localObject, "." + str1 + ".adTwistInfo");
              paramBundle.JDc = com.tencent.mm.plugin.sns.ad.widget.shakead.a.M((Map)localObject, "." + str1 + ".adShakeInfo");
            }
            bool1 = ADXml.isTwistAdCanvas(str2);
            bool3 = paramBundle.JCQ.getIntent().getBooleanExtra("sns_landing_page_is_gesture_twist_ad", false);
            if (paramBundle.JCS == null) {
              break label2070;
            }
            if (!bool1) {
              break label2047;
            }
            if (!bool3) {
              break label2027;
            }
            paramBundle.JCT = true;
            paramBundle.JCU = false;
            label1812:
            com.tencent.mm.sdk.platformtools.Log.i("AdLandingPageEggCardHelper", "isSharedTypeTwistAnim=" + paramBundle.JCU + ", isTwistAdAnim=" + paramBundle.JCT + ", intent twistCardId=" + paramBundle.JCY + ", isSimpleTwistAnim=" + paramBundle.JCV);
            if (!paramBundle.JCT) {
              break label2288;
            }
          }
        }
        try
        {
          if (paramBundle.JCR == null)
          {
            localObject = (ViewStub)paramBundle.JCQ.findViewById(i.f.twist_card_layout_stub);
            if (localObject != null) {
              paramBundle.JCR = ((TwistRoateCardsView)((ViewStub)localObject).inflate());
            }
          }
        }
        catch (Throwable paramBundle)
        {
          for (;;)
          {
            label1923:
            com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "inflateTwistCardView, exp=" + paramBundle.toString());
          }
        }
        if (this.values == null) {
          break label560;
        }
        if (Util.safeParseInt((String)this.values.get("." + this.KLt + ".preloadWeAppPkg")) == 1) {}
        for (boolean bool1 = bool2;; bool1 = false)
        {
          this.preloadWeAppPkg = bool1;
          break;
          bool1 = false;
          break label1480;
          label1991:
          bool1 = false;
          break label1532;
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "initParams, values is null");
          break label1537;
          label2008:
          this.KLB.jJH = 1;
          this.KLB.iQS = 1;
          break label1577;
          label2027:
          if (ahc(i)) {
            break label1812;
          }
          paramBundle.JCT = true;
          paramBundle.JCU = true;
          break label1812;
          label2047:
          if ((!bool3) || (!paramBundle.JCS.Kkf)) {
            break label1812;
          }
          paramBundle.JCV = true;
          break label1812;
          label2070:
          bool1 = ADXml.isShakeAdCanvas(str2);
          bool3 = paramBundle.JCQ.getIntent().getBooleanExtra("sns_landing_page_is_gesture_shake_ad", false);
          if (paramBundle.JDc != null)
          {
            if (!bool1) {
              break label2206;
            }
            if (!bool3) {
              break label2186;
            }
            paramBundle.JDb = true;
            paramBundle.JDe = false;
          }
          label2186:
          label2206:
          label2256:
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.Log.i("AdLandingPageEggCardHelper", "isSharedTypeShakeAnim=" + paramBundle.JDe + ", isShakeAdAnim=" + paramBundle.JDb + ", intent shakeCardId=" + paramBundle.JCY + ", isSimpleShakeAnim=" + paramBundle.JDd);
            break;
            if (!ahc(i))
            {
              paramBundle.JDb = true;
              paramBundle.JDe = true;
              continue;
              if (bool3)
              {
                localObject = paramBundle.JDc;
                if ((!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.ad.widget.shakead.a)localObject).JNy)) && (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.ad.widget.shakead.a)localObject).JNz))) {}
                for (i = 1;; i = 0)
                {
                  if (i == 0) {
                    break label2256;
                  }
                  paramBundle.JDd = true;
                  break;
                }
              }
            }
          }
          label2288:
          if (!paramBundle.JDb) {
            break label1923;
          }
          paramBundle.gEo();
          break label1923;
        }
        label2307:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "isConnected==true");
        fVa();
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "registerReceiver, exp=" + paramBundle.toString());
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98366);
    getWindow().clearFlags(128);
    if (this.KMg != null) {
      this.KMg.removeCallbacks(this.KMw);
    }
    if (this.KLY != null) {
      this.KLY.fKo();
    }
    Object localObject = this.KLW.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      SnsAdLandingPageFloatView localSnsAdLandingPageFloatView = (SnsAdLandingPageFloatView)((Iterator)localObject).next();
      localSnsAdLandingPageFloatView.onDestroy();
      localSnsAdLandingPageFloatView.setVisibility(8);
    }
    if (this.rNH)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "the SnsAdNativeLadingPagesUI is destroy, bHandleExit=" + this.KLD);
      if (!this.KLD)
      {
        fVg();
        report();
      }
    }
    for (;;)
    {
      localObject = a.a.fKM();
      ((com.tencent.mm.plugin.sns.ad.landingpage.helper.c.a)localObject).JDD.clear();
      ((com.tencent.mm.plugin.sns.ad.landingpage.helper.c.a)localObject).JDE = null;
      this.KLW.clear();
      localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.KLK.getAdapter();
      if (localObject != null) {
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)localObject).fragments.clear();
      }
      try
      {
        unregisterReceiver(this.KMB);
        EventCenter.instance.removeListener(this.KMv);
      }
      catch (Exception localException)
      {
        try
        {
          localObject = new wg();
          ((wg)localObject).fVt.fVu = 5;
          EventCenter.instance.publish((IEvent)localObject);
          label237:
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
          break label237;
        }
      }
    }
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(98393);
    super.onKeyboardStateChanged();
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "onKeyboardStateChanged, state=" + keyboardState());
    if (this.KLK != null) {
      this.KLK.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(204819);
          if (SnsAdNativeLandingPagesUI.this.keyboardState() != 1) {
            ao.aQ(SnsAdNativeLandingPagesUI.this);
          }
          if (!SnsAdNativeLandingPagesUI.W(SnsAdNativeLandingPagesUI.this))
          {
            new ArrayList();
            Iterator localIterator = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getAdapter()).fragments.iterator();
            while (localIterator.hasNext())
            {
              ContentFragment localContentFragment = (ContentFragment)localIterator.next();
              SnsAdNativeLandingPagesUI.this.keyboardState();
              localContentFragment.fRS();
            }
          }
          AppMethodBeat.o(204819);
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
    this.KLV = true;
    if (this.rNH) {
      this.fOa += System.currentTimeMillis() - this.startTime;
    }
    try
    {
      ScreenShotUtil.setScreenShotCallback(this, null);
      this.KLC = false;
      if (fVl())
      {
        Iterator localIterator = this.KLW.values().iterator();
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
      Object localObject = this.KLK;
      ViewPager.OnPageChangeListener localOnPageChangeListener = this.KMs;
      ((AdlandingDummyViewPager)localObject).Kvh.remove(localOnPageChangeListener);
      if (!this.KvC) {
        androidx.h.a.a.V(this).unregisterReceiver(this.KMo);
      }
      androidx.h.a.a.V(this).unregisterReceiver(this.KMp);
      if (!this.KvC) {
        EventCenter.instance.removeListener(this.KMu);
      }
      if (this.KMC != null) {
        this.KMC.bYF();
      }
      if ((!this.KvC) && (this.KLY != null) && (this.KLY.isShowing())) {
        this.KLY.fKl();
      }
      if ((this.KvC) && (this.JAK != null) && (this.JAK.fKA()))
      {
        localObject = this.JAK;
        if (((AdLandingGeneralVideoWrapper)localObject).JCx != null) {
          ((AdLandingGeneralVideoWrapper)localObject).JCx.fKl();
        }
      }
      AppMethodBeat.o(98372);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98371);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "onResume");
    super.onResume();
    Object localObject1 = this.KMn;
    if (((a.c)localObject1).JCJ == 0L) {
      ((a.c)localObject1).JCJ = System.currentTimeMillis();
    }
    if ((this.KMk) && (isSupportNavigationSwipeBack())) {
      getSwipeBackLayout().setEnableGesture(false);
    }
    try
    {
      if (!this.KLC)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "onResume callback");
        ScreenShotUtil.setScreenShotCallback(this, this.KMx);
        this.KLC = true;
      }
      ao.aQ(this);
      if (fVl())
      {
        i = this.KLO.getChildCount() - 1;
        if (i >= 0)
        {
          localObject1 = this.KLO.getChildAt(i);
          if ((localObject1 instanceof SnsAdLandingPageFloatView))
          {
            localObject1 = (SnsAdLandingPageFloatView)localObject1;
            ((SnsAdLandingPageFloatView)localObject1).onResume();
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
        localObject2 = null;
      }
      this.KLV = false;
      Object localObject2 = this.KLK;
      ViewPager.OnPageChangeListener localOnPageChangeListener = this.KMs;
      ((AdlandingDummyViewPager)localObject2).Kvh.add(localOnPageChangeListener);
      if (!this.KvC) {
        androidx.h.a.a.V(this).a(this.KMo, new IntentFilter("com.tencent.mm.adlanding.video_progressbar_change"));
      }
      androidx.h.a.a.V(this).a(this.KMp, new IntentFilter("com.tencent.mm.adlanding.set_uioption"));
      if (this.rNH) {
        this.startTime = System.currentTimeMillis();
      }
      if (!this.KvC) {
        EventCenter.instance.addListener(this.KMu);
      }
      if (this.KLF) {
        yT(false);
      }
      if ((!this.KvC) && (this.KLY != null) && (this.KLY.isShowing())) {
        this.KLY.fKk();
      }
      if ((this.KvC) && (this.JAK != null) && (this.JAK.fKA()))
      {
        localObject2 = this.JAK;
        if (((AdLandingGeneralVideoWrapper)localObject2).JCx != null) {
          ((AdLandingGeneralVideoWrapper)localObject2).JCx.fKk();
        }
      }
      AppMethodBeat.o(98371);
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(179183);
    super.onStart();
    this.isVisible = true;
    if (this.rNH) {
      try
      {
        if ((!Util.isNullOrNil(new String[] { this.viewId, this.Knt })) && (!this.KMe))
        {
          if (this.KMf)
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "execute mValidExposure onStart immediately");
            fVk();
            AppMethodBeat.o(179183);
            return;
          }
          if (this.KMg != null)
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "execute mValidExposureRunnable onStart");
            this.KMg.removeCallbacks(this.KMw);
            this.KMg.postDelayed(this.KMw, 1000L);
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
    if (this.KMg != null) {
      this.KMg.removeCallbacks(this.KMw);
    }
    AppMethodBeat.o(179184);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(98373);
    this.KLB.iQS = 2;
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k localk = this.KLB;
    localk.KyX += 1;
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
    AppMethodBeat.i(269218);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean) {}
    try
    {
      ScreenShotUtil.setScreenShotCallback(this, null);
      this.KLC = false;
      AppMethodBeat.o(269218);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", localThrowable.toString());
      AppMethodBeat.o(269218);
    }
    if (!this.KLC)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "onWindowFocusChanged callback");
      ScreenShotUtil.setScreenShotCallback(this, this.KMx);
      this.KLC = true;
    }
    AppMethodBeat.o(269218);
    return;
  }
  
  public final void yT(boolean paramBoolean)
  {
    AppMethodBeat.i(98394);
    if ((paramBoolean) && (this.bizId == 1)) {
      AdLandingPagesProxy.getInstance().doDynamicUpdateScene(this.KLG, this.KLH, this.KLI, this.KMt);
    }
    if ((this.bizId == 2) && (!Util.isNullOrNil(this.KLJ))) {
      AdLandingPagesProxy.getInstance().doSearchDynamicUpdateScene(this.KLJ, this.KMt);
    }
    this.KLF = true;
    AppMethodBeat.o(98394);
  }
  
  final class a
  {
    public String CHR = "";
    public String Kkj = "";
    public String pqW = "";
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI
 * JD-Core Version:    0.7.0.1
 */