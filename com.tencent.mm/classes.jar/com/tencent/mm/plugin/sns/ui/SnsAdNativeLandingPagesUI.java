package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.api.ab;
import com.tencent.mm.autogen.a.rl;
import com.tencent.mm.autogen.a.rl.a;
import com.tencent.mm.autogen.a.xv;
import com.tencent.mm.autogen.a.yc;
import com.tencent.mm.plugin.sns.ad.landingpage.b.a.1;
import com.tencent.mm.plugin.sns.ad.landingpage.component.view.AdLandingGeneralVideoWrapper;
import com.tencent.mm.plugin.sns.ad.landingpage.helper.a.b.1;
import com.tencent.mm.plugin.sns.ad.landingpage.helper.a.c;
import com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.FloatJumpCompHelper;
import com.tencent.mm.plugin.sns.ad.widget.advideo.AdLandingVideoPlayerToolBar;
import com.tencent.mm.plugin.sns.b.a;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.model.AdlandingRemoteServiceConnectedReceiver;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.b;
import com.tencent.mm.plugin.sns.storage.ADXml.l;
import com.tencent.mm.plugin.sns.storage.ADXml.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.at;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aj;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ar;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdlandingDummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.helper.FloatWebViewHelper;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView;
import com.tencent.mm.protocal.protobuf.by;
import com.tencent.mm.protocal.protobuf.fhn;
import com.tencent.mm.protocal.protobuf.fho;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
  private static List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa> Rmn;
  private View Cxb;
  String ICb;
  protected com.tencent.mm.ui.widget.snackbar.a.b IvJ;
  private ImageView NJV;
  private SnsInfo PNI;
  public AdLandingGeneralVideoWrapper PQt;
  public IListener<rl> PUc;
  private long QLA;
  private String QLB;
  private Map<String, String> QLC;
  private int QLu;
  private String QLw;
  public String QLy;
  private String QLz;
  private at QUd;
  public boolean QUm;
  public LinkedList<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h> QXz;
  private ai Qud;
  public FrameLayout RlA;
  private View RlB;
  private boolean RlC;
  private List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n> RlD;
  private com.tencent.mm.plugin.sns.ui.b.c RlE;
  private com.tencent.mm.plugin.sns.ui.b.d RlF;
  public volatile boolean RlG;
  public boolean RlH;
  private Map<String, SnsAdLandingPageFloatView> RlI;
  private com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.a RlJ;
  public com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d RlK;
  private boolean RlL;
  public boolean RlM;
  private boolean RlN;
  Collection<String> RlO;
  private volatile boolean RlP;
  private volatile boolean RlQ;
  private volatile boolean RlR;
  private MMHandler RlS;
  private String RlT;
  private FloatWebViewHelper RlU;
  private com.tencent.mm.ui.widget.a.f RlV;
  public boolean RlW;
  private com.tencent.mm.plugin.sns.ad.landingpage.helper.anim.a RlX;
  public boolean RlY;
  private a.c RlZ;
  public ae Rla;
  private ImageView Rlb;
  private TextView Rlc;
  public boolean Rld;
  private boolean Rle;
  public String Rlf;
  public String Rlg;
  private String Rlh;
  private String Rli;
  private String Rlj;
  private ImageView Rlk;
  String Rll;
  private boolean Rlm;
  public com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.n Rln;
  private volatile boolean Rlo;
  boolean Rlp;
  private int Rlq;
  private boolean Rlr;
  private String Rls;
  private String Rlt;
  private String Rlu;
  private String Rlv;
  private AdlandingDummyViewPager Rlw;
  private int Rlx;
  private int Rly;
  private MMHandler Rlz;
  public com.tencent.mm.plugin.sns.ad.landingpage.a Rma;
  public BroadcastReceiver Rmb;
  private BroadcastReceiver Rmc;
  private final String Rmd;
  private String Rme;
  private ContentFragment.a Rmf;
  private ViewPager.OnPageChangeListener Rmg;
  private AdLandingPagesProxy.e Rmh;
  private IListener<xv> Rmi;
  private Runnable Rmj;
  private ScreenShotUtil.ScreenShotCallback Rmk;
  private Map<Integer, ContentFragment> Rml;
  private boolean Rmm;
  public com.tencent.mm.ui.c.a Rmo;
  private BroadcastReceiver Rmp;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o Rmq;
  private com.tencent.mm.ui.base.w Rmr;
  public FloatJumpCompHelper Rms;
  private View.OnClickListener Rmt;
  private View.OnClickListener Rmu;
  private String adCanvasExtXml;
  private String adExtInfo;
  private int adType;
  private String aid;
  private int bizId;
  private long enterTime;
  public boolean forbiddenCustomAnimation;
  String hQX;
  private long hTS;
  private volatile boolean isVisible;
  private ImageView nkq;
  private ImageView pIB;
  private String pId;
  private boolean preloadWeAppPkg;
  private int pvg;
  private String qTb;
  private int recSrc;
  private String rzz;
  private int sJv;
  Bundle savedInstanceState;
  private int source;
  private long startTime;
  String svG;
  private boolean uYV;
  private String uin;
  public String uxInfo;
  public Map<String, String> values;
  private String viewId;
  private int wAZ;
  private int wBa;
  private int wBb;
  private int wBc;
  public String ytZ;
  
  static
  {
    AppMethodBeat.i(308139);
    Rmn = Collections.synchronizedList(new ArrayList());
    AppMethodBeat.o(308139);
  }
  
  public SnsAdNativeLandingPagesUI()
  {
    AppMethodBeat.i(98362);
    this.QXz = new LinkedList();
    this.wAZ = 0;
    this.wBa = 0;
    this.wBb = 0;
    this.wBc = 0;
    this.Rld = false;
    this.Rle = false;
    this.Rlm = false;
    this.hTS = 0L;
    this.enterTime = 0L;
    this.QLC = new HashMap();
    this.Rln = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.n();
    this.Rlo = false;
    this.Rlp = false;
    this.Rlq = 0;
    this.Rlr = false;
    this.Rlz = new MMHandler();
    this.RlC = true;
    this.uYV = false;
    this.RlI = new HashMap();
    this.RlL = false;
    this.RlM = false;
    this.RlN = false;
    this.RlO = new HashSet();
    this.isVisible = false;
    this.RlP = false;
    this.RlQ = false;
    this.RlR = false;
    this.RlS = new MMHandler();
    this.RlT = "";
    this.adExtInfo = "";
    this.RlW = false;
    this.forbiddenCustomAnimation = false;
    this.preloadWeAppPkg = false;
    this.QLB = "";
    this.RlZ = new a.c();
    this.pId = "";
    this.Rmb = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        boolean bool = true;
        AppMethodBeat.i(98324);
        int i = com.tencent.mm.plugin.sns.ad.j.h.getIntExtra(paramAnonymousIntent, "show", 0);
        if ((SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this) == null) || (!(SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getAdapter() instanceof androidx.fragment.app.m)))
        {
          com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.SnsAdNativeLandingPagesUI", "videoProgressbarStatusChangeReceiver called ,but the viewpager or adapter is null!!");
          AppMethodBeat.o(98324);
          return;
        }
        paramAnonymousContext = (androidx.fragment.app.m)SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getAdapter();
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
          SnsAdNativeLandingPagesUI.this.vb(500L);
          paramAnonymousContext.DW(bool);
          AppMethodBeat.o(98324);
          return;
          bool = false;
        }
      }
    };
    this.Rmc = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(98343);
        ar.bs(SnsAdNativeLandingPagesUI.this);
        AppMethodBeat.o(98343);
      }
    };
    this.Rmd = "huawei nxt-al10|mix 2s|sm-g9350";
    this.Rme = "";
    this.Rmf = new ContentFragment.a()
    {
      public final void s(final ContentFragment paramAnonymousContentFragment)
      {
        AppMethodBeat.i(98351);
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SnsAdNativeLandingPagesUI.launch", "firstPage afterOnCreateView");
        Object localObject = SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this);
        if (((a.c)localObject).PTu == 0L) {
          ((a.c)localObject).PTu = System.currentTimeMillis();
        }
        localObject = paramAnonymousContentFragment.getRecyclerView();
        if (localObject != null) {
          ((RecyclerView)localObject).getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(98350);
              Object localObject1 = SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this);
              if (((a.c)localObject1).PTv == 0L) {
                ((a.c)localObject1).PTv = System.currentTimeMillis();
              }
              com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SnsAdNativeLandingPagesUI.launch", "firstPage onPreDraw");
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "onPreDraw %d, %d", new Object[] { Integer.valueOf(SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this).getHeight()), Integer.valueOf(SnsAdNativeLandingPagesUI.d(SnsAdNativeLandingPagesUI.this)) });
              SnsAdNativeLandingPagesUI.this.hnp();
              if (SnsAdNativeLandingPagesUI.e(SnsAdNativeLandingPagesUI.this).a(paramAnonymousContentFragment))
              {
                this.uBj.getViewTreeObserver().removeOnPreDrawListener(this);
                AppMethodBeat.o(98350);
                return false;
              }
              localObject1 = null;
              Object localObject2 = SnsAdNativeLandingPagesUI.f(SnsAdNativeLandingPagesUI.this);
              int i;
              if (localObject2 != null)
              {
                localObject1 = (v)((al)localObject2).QOV;
                if (localObject1 != null)
                {
                  localObject1 = ((v)localObject1).QHV;
                  localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.my((String)localObject1, "scene_ad_landing");
                  localObject2 = new StringBuilder("onPreDraw, fullscreen, container.size=").append(SnsAdNativeLandingPagesUI.g(SnsAdNativeLandingPagesUI.this).getWidth()).append(", ").append(SnsAdNativeLandingPagesUI.g(SnsAdNativeLandingPagesUI.this).getHeight()).append(", shootImg.w=");
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
                if (!SnsAdNativeLandingPagesUI.h(SnsAdNativeLandingPagesUI.this)) {
                  break label330;
                }
                MMHandlerThread.postToMainThreadDelayed(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(98349);
                    Bitmap localBitmap1 = null;
                    Object localObject1;
                    if (this.RmE != null) {
                      localObject1 = this.RmE;
                    }
                    while (localObject1 != null)
                    {
                      SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this).setAlpha(1.0F);
                      SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this).setImageBitmap((Bitmap)localObject1);
                      SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this, SnsAdNativeLandingPagesUI.25.1.this.uBj, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
                      AppMethodBeat.o(98349);
                      return;
                      localObject1 = localBitmap1;
                      try
                      {
                        if (!SnsAdNativeLandingPagesUI.i(SnsAdNativeLandingPagesUI.this)) {
                          break label180;
                        }
                        localObject1 = localBitmap1;
                        localBitmap1 = BitmapUtil.getBitmapFromView(SnsAdNativeLandingPagesUI.25.1.this.uBj.getChildAt(0));
                        localObject1 = localBitmap1;
                        SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this).setScaleType(ImageView.ScaleType.CENTER_CROP);
                        localObject1 = localBitmap1;
                        continue;
                      }
                      finally
                      {
                        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "getBitmapFromView exp=" + localObject2.toString());
                      }
                      continue;
                      label180:
                      localObject1 = localObject2;
                      Bitmap localBitmap2 = BitmapUtil.getBitmapFromView(SnsAdNativeLandingPagesUI.g(SnsAdNativeLandingPagesUI.this));
                      localObject1 = localBitmap2;
                      SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this).setScaleType(ImageView.ScaleType.CENTER_CROP);
                      localObject1 = localBitmap2;
                    }
                    SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this).setAlpha(1.0F);
                    AppMethodBeat.o(98349);
                  }
                }, 50L);
              }
              for (;;)
              {
                this.uBj.getViewTreeObserver().removeOnPreDrawListener(this);
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
                SnsAdNativeLandingPagesUI.k(SnsAdNativeLandingPagesUI.this).setVisibility(0);
                SnsAdNativeLandingPagesUI.this.vb(300L);
              }
            }
          });
        }
        AppMethodBeat.o(98351);
      }
    };
    this.Rmg = new ViewPager.f()
    {
      public final void onPageScrollStateChanged(int paramAnonymousInt)
      {
        AppMethodBeat.i(98353);
        super.onPageScrollStateChanged(paramAnonymousInt);
        SnsAdNativeLandingPagesUI.l(SnsAdNativeLandingPagesUI.this).QUl = paramAnonymousInt;
        Object localObject;
        if (paramAnonymousInt == 1)
        {
          paramAnonymousInt = 0;
          while (paramAnonymousInt < SnsAdNativeLandingPagesUI.this.QXz.size())
          {
            localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h)SnsAdNativeLandingPagesUI.this.QXz.get(paramAnonymousInt);
            localObject = (Fragment)SnsAdNativeLandingPagesUI.m(SnsAdNativeLandingPagesUI.this).get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h)localObject).id));
            if (localObject != null) {
              ((ContentFragment)localObject).hkc();
            }
            paramAnonymousInt += 1;
          }
          ar.jS(SnsAdNativeLandingPagesUI.this.getContext());
          AppMethodBeat.o(98353);
          return;
        }
        if (paramAnonymousInt == 0)
        {
          localObject = (Fragment)SnsAdNativeLandingPagesUI.m(SnsAdNativeLandingPagesUI.this).get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h)SnsAdNativeLandingPagesUI.this.QXz.get(SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getCurrentItem())).id));
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
        if (SnsAdNativeLandingPagesUI.l(SnsAdNativeLandingPagesUI.this) != null)
        {
          ContentFragment localContentFragment = SnsAdNativeLandingPagesUI.l(SnsAdNativeLandingPagesUI.this);
          if ((localContentFragment.ffv) && (localContentFragment.QUb != null)) {
            localContentFragment.QUb.hjQ();
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
        if (i < SnsAdNativeLandingPagesUI.this.QXz.size())
        {
          Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h)SnsAdNativeLandingPagesUI.this.QXz.get(i);
          localObject = (Fragment)SnsAdNativeLandingPagesUI.m(SnsAdNativeLandingPagesUI.this).get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h)localObject).id));
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
            ((ContentFragment)localObject).hkc();
          }
        }
        SnsAdNativeLandingPagesUI.this.vb(300L);
        AppMethodBeat.o(98354);
      }
    };
    this.Rmh = new AdLandingPagesProxy.e()
    {
      public final void h(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject) {}
      
      public final void onCallback(final Object paramAnonymousObject)
      {
        AppMethodBeat.i(98357);
        SnsAdNativeLandingPagesUI.n(SnsAdNativeLandingPagesUI.this).removeCallbacksAndMessages(null);
        SnsAdNativeLandingPagesUI.n(SnsAdNativeLandingPagesUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98356);
            Object localObject = SnsAdNativeLandingPagesUI.o(SnsAdNativeLandingPagesUI.this);
            SnsAdNativeLandingPagesUI.p(SnsAdNativeLandingPagesUI.this);
            String str = (String)paramAnonymousObject;
            SnsAdNativeLandingPagesUI.q(SnsAdNativeLandingPagesUI.this);
            SnsAdNativeLandingPagesUI.r(SnsAdNativeLandingPagesUI.this);
            localObject = new l.a(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.mK((String)localObject, str), SnsAdNativeLandingPagesUI.p(SnsAdNativeLandingPagesUI.this));
            SnsAdNativeLandingPagesUI.this.QXz = ((l.a)localObject).QXz;
            SnsAdNativeLandingPagesUI.this.Rla = ((l.a)localObject).QXA;
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(98355);
                SnsAdNativeLandingPagesUI.this.hnG();
                AppMethodBeat.o(98355);
              }
            });
            AppMethodBeat.o(98356);
          }
        });
        AppMethodBeat.o(98357);
      }
    };
    this.PUc = new IListener(com.tencent.mm.app.f.hfK)
    {
      private boolean a(rl paramAnonymousrl)
      {
        AppMethodBeat.i(176294);
        Object localObject1;
        SnsAdLandingPageFloatView localSnsAdLandingPageFloatView;
        Object localObject2;
        int i;
        String str1;
        String str2;
        String str3;
        if ((SnsAdNativeLandingPagesUI.l(SnsAdNativeLandingPagesUI.this).QTX.QXj != null) && (SnsAdNativeLandingPagesUI.l(SnsAdNativeLandingPagesUI.this).QTX.QXj.containsKey(paramAnonymousrl.hUy.hUz)) && (!SnsAdNativeLandingPagesUI.s(SnsAdNativeLandingPagesUI.this).containsKey(paramAnonymousrl.hUy.hUz)))
        {
          SnsAdNativeLandingPagesUI.l(SnsAdNativeLandingPagesUI.this).onPause();
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("sns_landing_pages_xml", SnsAdNativeLandingPagesUI.o(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putString("sns_float_component_id", paramAnonymousrl.hUy.hUz);
          ((Bundle)localObject1).putInt("sns_landing_page_index", SnsAdNativeLandingPagesUI.l(SnsAdNativeLandingPagesUI.this).QTX.id);
          ((Bundle)localObject1).putString("sns_landing_page_snsId", SnsAdNativeLandingPagesUI.this.hQX);
          ((Bundle)localObject1).putString("sns_landing_pages_rawSnsId", SnsAdNativeLandingPagesUI.this.QLy);
          ((Bundle)localObject1).putString("sns_landing_pages_ux_info", SnsAdNativeLandingPagesUI.t(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putString("sns_landing_pages_aid", SnsAdNativeLandingPagesUI.q(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putInt("sns_landing_pages_biz_id", SnsAdNativeLandingPagesUI.u(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putString("sns_landing_pages_traceid", SnsAdNativeLandingPagesUI.r(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putInt("sns_landig_pages_from_source", SnsAdNativeLandingPagesUI.v(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putString("sns_landing_pages_xml_prefix", SnsAdNativeLandingPagesUI.p(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putBoolean("sns_landing_is_native_sight_ad", SnsAdNativeLandingPagesUI.w(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putString("sns_landing_pages_canvas_ext", SnsAdNativeLandingPagesUI.x(SnsAdNativeLandingPagesUI.this));
          localSnsAdLandingPageFloatView = new SnsAdLandingPageFloatView(SnsAdNativeLandingPagesUI.this);
          localObject2 = ((Bundle)localObject1).getString("sns_landing_pages_xml");
          localSnsAdLandingPageFloatView.hUz = ((Bundle)localObject1).getString("sns_float_component_id");
          i = ((Bundle)localObject1).getInt("sns_landing_page_index", -1);
          str1 = ((Bundle)localObject1).getString("sns_landing_pages_ux_info");
          str2 = ((Bundle)localObject1).getString("sns_landing_pages_aid");
          str3 = ((Bundle)localObject1).getString("sns_landing_pages_traceid");
          localSnsAdLandingPageFloatView.adCanvasExtXml = ((Bundle)localObject1).getString("sns_landing_pages_canvas_ext");
          if ((!Util.isNullOrNil(new String[] { localObject2, localSnsAdLandingPageFloatView.hUz })) && (i != -1)) {
            break label514;
          }
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdLandingPageFloatView", "invalid landing float page data!");
        }
        for (;;)
        {
          localSnsAdLandingPageFloatView.setBackgroundColor(SnsAdNativeLandingPagesUI.this.getResources().getColor(b.c.sns_ad_float_page_bg_color));
          SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this).addView(localSnsAdLandingPageFloatView, SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this).getChildCount() - 1, new FrameLayout.LayoutParams(-1, -1));
          localSnsAdLandingPageFloatView.hsJ();
          SnsAdNativeLandingPagesUI.l(SnsAdNativeLandingPagesUI.this).hkc();
          if ((SnsAdNativeLandingPagesUI.y(SnsAdNativeLandingPagesUI.this) != null) && (!SnsAdNativeLandingPagesUI.y(SnsAdNativeLandingPagesUI.this).QNy)) {
            SnsAdNativeLandingPagesUI.this.r(false, 0L);
          }
          SnsAdNativeLandingPagesUI.s(SnsAdNativeLandingPagesUI.this).put(paramAnonymousrl.hUy.hUz, localSnsAdLandingPageFloatView);
          AppMethodBeat.o(176294);
          return false;
          label514:
          localObject1 = new l.a((String)localObject2, Util.nullAs(((Bundle)localObject1).getString("sns_landing_pages_xml_prefix"), "adxml")).QXz;
          if ((localObject1 != null) && (((LinkedList)localObject1).size() > i))
          {
            localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h)((LinkedList)localObject1).get(i);
            localSnsAdLandingPageFloatView.RWh = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h();
            localSnsAdLandingPageFloatView.RWh.qWk = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h)localObject1).qWk;
            localObject2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h)localObject1).QXj.get(localSnsAdLandingPageFloatView.hUz);
            if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.alw(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa)localObject2).type))
            {
              localSnsAdLandingPageFloatView.RWg = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y)localObject2);
              localSnsAdLandingPageFloatView.RWh.QXi.add(localSnsAdLandingPageFloatView.RWg);
              localSnsAdLandingPageFloatView.RWh.QXj.putAll(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h)localObject1).QXj);
            }
            localSnsAdLandingPageFloatView.RWh.id = 0;
            localSnsAdLandingPageFloatView.RWh.QXk = true;
          }
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdLandingPageFloatView", "[reportInfo] aid %s,traceId %s,uxInfo %s,adCanvasExtXml %s", new Object[] { str2, str3, str1, localSnsAdLandingPageFloatView.adCanvasExtXml });
          localSnsAdLandingPageFloatView.initView();
        }
      }
    };
    this.Rmi = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Rmj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179171);
        SnsAdNativeLandingPagesUI.M(SnsAdNativeLandingPagesUI.this);
        if ((!SnsAdNativeLandingPagesUI.N(SnsAdNativeLandingPagesUI.this)) && (SnsAdNativeLandingPagesUI.O(SnsAdNativeLandingPagesUI.this))) {
          SnsAdNativeLandingPagesUI.P(SnsAdNativeLandingPagesUI.this);
        }
        AppMethodBeat.o(179171);
      }
    };
    this.Rmk = new ScreenShotUtil.ScreenShotCallback()
    {
      public final void onScreenShot(String paramAnonymousString, long paramAnonymousLong)
      {
        AppMethodBeat.i(308222);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "onScreenShot， path = " + paramAnonymousString + "， dateAdded = " + paramAnonymousLong);
        SnsAdNativeLandingPagesUI.Q(SnsAdNativeLandingPagesUI.this);
        AppMethodBeat.o(308222);
      }
    };
    this.Rml = new HashMap();
    this.Rmm = false;
    this.IvJ = new com.tencent.mm.ui.widget.snackbar.a.b()
    {
      public final void onMessageClick()
      {
        AppMethodBeat.i(308098);
        try
        {
          AdLandingPagesProxy.getInstance().favEditTag();
          AppMethodBeat.o(308098);
          return;
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "favorite edittag fail, ex = " + localException.getMessage());
          AppMethodBeat.o(308098);
        }
      }
    };
    this.Rmo = new com.tencent.mm.ui.c.a()
    {
      public final void cK(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(308058);
        SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this, paramAnonymousBoolean);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "onKeyboardStateChanged, visiable=".concat(String.valueOf(paramAnonymousBoolean)));
        SnsAdNativeLandingPagesUI.this.vb(300L);
        if ((SnsAdNativeLandingPagesUI.y(SnsAdNativeLandingPagesUI.this) != null) && (SnsAdNativeLandingPagesUI.y(SnsAdNativeLandingPagesUI.this).QNy) && (!SnsAdNativeLandingPagesUI.y(SnsAdNativeLandingPagesUI.this).isFinishing))
        {
          if ((paramAnonymousBoolean) && (SnsAdNativeLandingPagesUI.y(SnsAdNativeLandingPagesUI.this).isShowing()))
          {
            SnsAdNativeLandingPagesUI.y(SnsAdNativeLandingPagesUI.this).hiM();
            AppMethodBeat.o(308058);
            return;
          }
          if (!paramAnonymousBoolean) {
            SnsAdNativeLandingPagesUI.y(SnsAdNativeLandingPagesUI.this).hiN();
          }
        }
        AppMethodBeat.o(308058);
      }
    };
    this.Rmp = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(308074);
        try
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "screenOnReceiver:" + paramAnonymousIntent.getAction());
          if (paramAnonymousIntent.getAction().equals("android.intent.action.SCREEN_ON")) {
            ar.bs(SnsAdNativeLandingPagesUI.this);
          }
          AppMethodBeat.o(308074);
          return;
        }
        catch (Exception paramAnonymousContext)
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "screenOnReceiver, exp=" + paramAnonymousContext.toString());
          AppMethodBeat.o(308074);
        }
      }
    };
    this.Rmq = null;
    this.Rmr = null;
    this.Rmt = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(308042);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "mOnCloseClickListener, onClick");
        if (SnsAdNativeLandingPagesUI.this.keyboardState() == 1) {
          SnsAdNativeLandingPagesUI.this.hideVKB();
        }
        SnsAdNativeLandingPagesUI.this.dmJ();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(308042);
      }
    };
    this.Rmu = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(308023);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "mOnBackClickListener, onClick");
        if (SnsAdNativeLandingPagesUI.this.keyboardState() == 1) {
          SnsAdNativeLandingPagesUI.this.hideVKB();
        }
        SnsAdNativeLandingPagesUI.this.dmJ();
        SnsAdNativeLandingPagesUI.ab(SnsAdNativeLandingPagesUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(308023);
      }
    };
    AppMethodBeat.o(98362);
  }
  
  private void aNi()
  {
    AppMethodBeat.i(98374);
    this.PNI = AdLandingPagesProxy.getInstance().getSnsInfo(this.hQX);
    AdLandingPagesProxy.getInstance().asyncCacheXml(this.hQX);
    if (this.values == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "parse landingpagexml is error,landingpagexml is " + this.Rlf);
      AppMethodBeat.o(98374);
      return;
    }
    long l;
    Object localObject4;
    String str1;
    label624:
    int i;
    if ((this.source == 1) || (this.source == 2) || (this.source == 16) || (this.source == 14) || (this.source == 9) || (this.source == 10))
    {
      l = 0L;
      if (this.PNI != null)
      {
        l = this.PNI.field_snsId;
        this.aid = AdLandingPagesProxy.getInstance().getSnsAid(this.hQX);
        this.qTb = AdLandingPagesProxy.getInstance().getSnsTraceid(this.hQX);
        this.adType = AdLandingPagesProxy.getInstance().getSnsAdType(this.hQX);
        this.uxInfo = AdLandingPagesProxy.getInstance().getSnsUxInfo(this.hQX);
        this.adCanvasExtXml = AdLandingPagesProxy.getInstance().getSnsAdCanvasExtXml(this.hQX);
      }
      if (this.QLy != null)
      {
        localObject1 = this.QLy;
        this.values.put("." + this.Rlg + ".originSnsId", localObject1);
        this.values.put("." + this.Rlg + ".originUxInfo", this.uxInfo);
        localObject4 = "<" + this.Rlg + ">";
        localObject4 = (String)localObject4 + String.format("<originSnsId>%s</originSnsId>", new Object[] { localObject1 });
        localObject4 = (String)localObject4 + String.format("<originUxInfo>%s</originUxInfo>", new Object[] { this.uxInfo });
        localObject4 = (String)localObject4 + String.format("<originAdType>%d</originAdType>", new Object[] { Integer.valueOf(this.adType) });
        localObject4 = (String)localObject4 + String.format("<originAid>%s</originAid>", new Object[] { this.aid });
        str1 = (String)localObject4 + String.format("<originTraceId>%s</originTraceId>", new Object[] { this.qTb });
        localObject4 = str1;
        if (!Util.isNullOrNil(this.adCanvasExtXml)) {
          localObject4 = str1 + String.format("<originAdCanvasExt>%s</originAdCanvasExt>", new Object[] { this.adCanvasExtXml });
        }
        this.Rlf = this.Rlf.replace("<" + this.Rlg + ">", (CharSequence)localObject4);
        this.Rln.uxInfo = this.uxInfo;
        this.Rln.hQX = ((String)localObject1);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "reportInfo aid [%s],traceId [%s],adType [%s],uxInfo [%s],adCanvasExtXml [%s]", new Object[] { this.aid, this.qTb, Integer.valueOf(this.adType), this.uxInfo, this.adCanvasExtXml });
        if (Util.isNullOrNil(this.adCanvasExtXml)) {
          break label1753;
        }
        localObject4 = XmlParser.parseXml(this.adCanvasExtXml, "adCardItemList", null);
        if (localObject4 == null) {
          break label1753;
        }
        i = 0;
        label705:
        if (i <= 0) {
          break label3080;
        }
      }
    }
    label1753:
    Object localObject3;
    label2948:
    label3080:
    for (Object localObject1 = ".adCardItemList.cardItem" + i;; localObject3 = ".adCardItemList.cardItem")
    {
      if (((Map)localObject4).containsKey((String)localObject1 + ".cardTpId"))
      {
        str1 = Util.nullAs((String)((Map)localObject4).get((String)localObject1 + ".cardTpId"), "");
        localObject1 = Util.nullAs((String)((Map)localObject4).get((String)localObject1 + ".cardExt"), "");
        if ((!Util.isNullOrNil(str1)) && (!Util.isNullOrNil((String)localObject1))) {
          this.QLC.put(str1, localObject1);
        }
        i += 1;
        break label705;
        localObject1 = String.valueOf(l);
        break;
        String str2 = "." + this.Rlg + ".originTraceId";
        str1 = "." + this.Rlg + ".originAid";
        String str3 = "." + this.Rlg + ".originUxInfo";
        this.Rln.hQX = ((String)this.values.get("." + this.Rlg + ".originSnsId"));
        this.Rln.uxInfo = ((String)this.values.get(str3));
        this.uxInfo = this.Rln.uxInfo;
        this.QLy = this.Rln.hQX;
        this.adType = Util.safeParseInt((String)this.values.get("." + this.Rlg + ".originAdType"));
        this.aid = ((String)this.values.get(str1));
        this.qTb = ((String)this.values.get(str2));
        if (!Util.isNullOrNil(this.rzz))
        {
          localObject1 = XmlParser.parseXml(this.rzz, "ADInfo", null);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "adInfoXml %s", new Object[] { this.rzz });
          if (localObject1 != null)
          {
            this.uxInfo = Util.nullAs((String)((Map)localObject1).get(".ADInfo.uxInfo"), "");
            this.Rln.uxInfo = this.uxInfo;
            this.aid = Util.nullAs((String)((Map)localObject1).get(".ADInfo.session_data.aid"), "");
            this.qTb = Util.nullAs((String)((Map)localObject1).get(".ADInfo.session_data.trace_id"), "");
            this.viewId = Util.nullAs((String)((Map)localObject1).get(".ADInfo.viewid"), "");
            this.QLz = Util.nullAs((String)((Map)localObject1).get(".ADInfo.commInfo"), "");
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "adInfoXml, aid = " + this.aid + ", uxInfo = " + this.uxInfo + ", commInfo = " + this.QLz + ", traceId=" + this.qTb + ", viewId=" + this.viewId);
          }
        }
        try
        {
          localObject4 = "<" + this.Rlg + ">";
          localObject1 = localObject4;
          if (!TextUtils.isEmpty(this.uxInfo))
          {
            localObject1 = localObject4;
            if (!this.values.containsKey(str3)) {
              localObject1 = (String)localObject4 + String.format("<originUxInfo>%s</originUxInfo>", new Object[] { this.uxInfo });
            }
          }
          localObject4 = localObject1;
          if (!TextUtils.isEmpty(this.qTb))
          {
            localObject4 = localObject1;
            if (!this.values.containsKey(str2)) {
              localObject4 = (String)localObject1 + String.format("<originTraceId>%s</originTraceId>", new Object[] { this.qTb });
            }
          }
          localObject1 = localObject4;
          if (!TextUtils.isEmpty(this.aid))
          {
            localObject1 = localObject4;
            if (!this.values.containsKey(str1)) {
              localObject1 = (String)localObject4 + String.format("<originAid>%s</originAid>", new Object[] { this.aid });
            }
          }
          this.Rlf = this.Rlf.replace("<" + this.Rlg + ">", (CharSequence)localObject1);
        }
        finally
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "replace landingPagesXml exp=" + localObject2.toString());
          }
        }
        localObject1 = Pattern.compile("<originAdCanvasExt>[\\s\\S]*</originAdCanvasExt>").matcher(this.Rlf);
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
      this.Rln.QXS = AdLandingPagesProxy.getInstance().getSnsStatExtBySnsId(Util.safeParseLong(this.Rln.hQX));
      this.svG = Util.nullAs((String)this.values.get("." + this.Rlg + ".adCanvasInfo.shareTitle"), "");
      this.ytZ = Util.nullAs((String)this.values.get("." + this.Rlg + ".adCanvasInfo.shareWebUrl"), "");
      this.ICb = Util.nullAs((String)this.values.get("." + this.Rlg + ".adCanvasInfo.shareDesc"), "");
      this.bizId = Util.safeParseInt(Util.nullAs((String)this.values.get("." + this.Rlg + ".adCanvasInfo.bizId"), ""));
      this.Rls = Util.nullAs((String)this.values.get("." + this.Rlg + ".adCanvasInfo.shareAppId"), "");
      this.Rlt = Util.nullAs((String)this.values.get("." + this.Rlg + ".adCanvasInfo.shareType"), "");
      this.Rlu = Util.nullAs((String)this.values.get("." + this.Rlg + ".adCanvasInfo.userInfo"), "");
      this.Rlx = Util.safeParseInt(Util.nullAs((String)this.values.get("." + this.Rlg + ".adCanvasInfo.disableShareBitSet"), ""));
      this.Rly = Util.safeParseInt(Util.nullAs((String)this.values.get("." + this.Rlg + ".adCanvasInfo.statusBarStyle"), ""));
      at(this.values, "." + this.Rlg);
      this.uin = AdLandingPagesProxy.getInstance().getUin();
      this.Rlv = Util.nullAs((String)this.values.get("." + this.Rlg + ".adCanvasInfo.officialSyncBuffer"), "");
      getIntent().putExtra("sns_landing_pages_adType", this.adType);
      getIntent().putExtra("sns_landing_pages_rawSnsId", this.Rln.hQX);
      if (Util.isNullOrNil(this.aid)) {
        this.aid = Util.nullAs((String)this.values.get("." + this.Rlg + ".originAid"), "");
      }
      if (Util.isNullOrNil(this.qTb)) {
        this.qTb = Util.nullAs((String)this.values.get("." + this.Rlg + ".originTraceId"), "");
      }
      if (Util.isNullOrNil(this.aid))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "try get aid from uxinfo");
        this.aid = com.tencent.mm.plugin.sns.data.m.aXi(this.uxInfo);
      }
      if (Util.isNullOrNil(this.qTb))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "try get traceId from uxinfo");
        this.qTb = com.tencent.mm.plugin.sns.data.m.aXj(this.uxInfo);
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "aid=" + this.aid + ", traceId=" + this.qTb);
      this.pId = com.tencent.mm.plugin.sns.data.m.aXk(this.uxInfo);
      localObject3 = new l.a(this.Rlf, this.Rlg);
      this.QXz = ((l.a)localObject3).QXz;
      this.Rla = ((l.a)localObject3).QXA;
      hnT();
      b((l.a)localObject3);
      c((l.a)localObject3);
      d((l.a)localObject3);
      localObject4 = new ArrayList();
      if (((l.a)localObject3).QXA != null) {
        com.tencent.mm.plugin.sns.ad.d.j.a(((l.a)localObject3).QXA, (ArrayList)localObject4);
      }
      if (((l.a)localObject3).QXC != null) {
        com.tencent.mm.plugin.sns.ad.d.j.a(((l.a)localObject3).QXC, (ArrayList)localObject4);
      }
      if (!((ArrayList)localObject4).isEmpty()) {
        com.tencent.mm.plugin.sns.ad.d.j.i((ArrayList)localObject4, this.preloadWeAppPkg);
      }
      if (((l.a)localObject3).QXA != null) {
        com.tencent.mm.plugin.sns.ad.d.o.a(this.hQX, this.source, ((l.a)localObject3).QXA);
      }
      if (((l.a)localObject3).QXC != null) {
        com.tencent.mm.plugin.sns.ad.d.o.a(this.hQX, this.source, ((l.a)localObject3).QXC);
      }
      if (this.QXz.size() > 0)
      {
        localObject3 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h)this.QXz.get(0);
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h)localObject3).QXi.size() > 0)
        {
          localObject3 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h)localObject3).QXi.get(0);
          if (!(localObject3 instanceof u)) {
            break label2948;
          }
          this.Rll = ((u)localObject3).QKj;
        }
      }
      for (;;)
      {
        this.Rlh = Util.nullAs((String)this.values.get("." + this.Rlg + ".adCanvasInfo.rightBarTitle"), "");
        this.Rli = Util.nullAs((String)this.values.get("." + this.Rlg + ".adCanvasInfo.rightBarCanvasId"), "");
        this.Rlj = Util.nullAs((String)this.values.get("." + this.Rlg + ".adCanvasInfo.rightBarCanvasExt"), "");
        AppMethodBeat.o(98374);
        return;
        if ((localObject3 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t))
        {
          this.Rll = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t)localObject3).QKj;
        }
        else if ((localObject3 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w))
        {
          this.Rll = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w)localObject3).QKq;
        }
        else if ((localObject3 instanceof am))
        {
          localObject3 = (am)localObject3;
          if (!((am)localObject3).QKh.isEmpty())
          {
            localObject3 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)((am)localObject3).QKh.getFirst();
            if (!((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)localObject3).QKh.isEmpty())
            {
              localObject3 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)localObject3).QKh.getFirst();
              if ((localObject3 instanceof u)) {
                this.Rll = ((u)localObject3).QKj;
              }
            }
          }
        }
      }
    }
  }
  
  private static boolean alT(int paramInt)
  {
    AppMethodBeat.i(307743);
    if ((alU(paramInt)) || (com.tencent.mm.plugin.sns.ad.i.a.ajx(paramInt)) || (paramInt == 33))
    {
      AppMethodBeat.o(307743);
      return true;
    }
    AppMethodBeat.o(307743);
    return false;
  }
  
  public static boolean alU(int paramInt)
  {
    AppMethodBeat.i(307750);
    if ((paramInt == 3) || (paramInt == 5) || (paramInt == 4)) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "isFromShare, source=" + paramInt + ", ret=" + bool);
      AppMethodBeat.o(307750);
      return bool;
    }
  }
  
  private static boolean alV(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(307835);
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
      AppMethodBeat.o(307835);
      return bool1;
    }
  }
  
  private void at(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(98375);
    String str = (String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.iconUrl");
    if (TextUtils.isEmpty(str))
    {
      this.QUd = null;
      AppMethodBeat.o(98375);
      return;
    }
    if (this.QUd == null) {
      this.QUd = new at();
    }
    this.QUd.iconUrl = str;
    int k = Util.safeParseInt((String)paramMap.get(paramString + ".adCanvasInfo.sizeType"));
    int i = Util.safeParseInt((String)paramMap.get(paramString + ".adCanvasInfo.basicRootFontSize"));
    int j = Util.safeParseInt((String)paramMap.get(paramString + ".adCanvasInfo.basicWidth"));
    if ((i == 0) && (k == 1)) {
      i = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.QXx;
    }
    for (;;)
    {
      if ((j == 0) && (k == 1)) {
        j = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.QXw;
      }
      for (;;)
      {
        this.QUd.paddingBottom = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.a(Util.safeParseDouble((String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.paddingBottom")), k, j, i);
        this.QUd.width = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.a(Util.safeParseDouble((String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.layoutWidth")), k, j, i);
        this.QUd.height = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.a(Util.safeParseDouble((String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.layoutHeight")), k, j, i);
        AppMethodBeat.o(98375);
        return;
      }
    }
  }
  
  private void b(l.a parama)
  {
    AppMethodBeat.i(307895);
    try
    {
      if ((parama.QXB != null) && (this.Cxb != null))
      {
        this.RlU = FloatWebViewHelper.a(parama.QXB, (ViewGroup)this.Cxb);
        getLifecycle().addObserver(this.RlU);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(307895);
    }
  }
  
  private void bXA()
  {
    AppMethodBeat.i(98378);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.Rlw.getAdapter();
    if (localb == null)
    {
      localb = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b(getSupportFragmentManager(), new ArrayList());
      this.Rlw.setAdapter(localb);
    }
    for (;;)
    {
      List localList = hnC();
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h localh;
      ContentFragment localContentFragment;
      if (localList.size() > 0)
      {
        localh = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h)localList.get(0);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "loadFirstPage load id %s", new Object[] { Integer.valueOf(localh.id) });
        localContentFragment = (ContentFragment)this.Rml.get(Integer.valueOf(localh.id));
        if (localContentFragment != null) {
          break label362;
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("pageInfo", localh);
        localHashMap.put("pageCount", Integer.valueOf(localList.size()));
        localHashMap.put("viewPager", this.Rlw);
        localHashMap.put("pageDownIconInfo", this.QUd);
        localHashMap.put("is_first_show_page", Boolean.TRUE);
        if (localList.size() == 1) {
          localHashMap.put("is_last_shown_page", Boolean.TRUE);
        }
        localHashMap.put("needEnterAnimation", Boolean.valueOf(this.Rld));
        localHashMap.put("needDirectionAnimation", Boolean.valueOf(hnI()));
        localHashMap.put("groupListCompShowIndex", Integer.valueOf(this.Rlq));
        localContentFragment = new ContentFragment();
        localContentFragment.params = localHashMap;
        localContentFragment.QUo = this.Rmf;
        this.Rml.put(Integer.valueOf(localh.id), localContentFragment);
      }
      for (;;)
      {
        if (localContentFragment != null) {
          localb.c(localContentFragment, 0);
        }
        localb.notifyDataSetChanged();
        this.Rlw.setOffscreenPageLimit(localList.size());
        AppMethodBeat.o(98378);
        return;
        label362:
        localContentFragment.a(localh);
      }
    }
  }
  
  private String baD(String paramString)
  {
    AppMethodBeat.i(98389);
    String str = Util.nullAs((String)this.values.get("." + this.Rlg + ".adCanvasInfo.shareThumbUrl"), "");
    if (!Util.isNullOrNil(str))
    {
      AppMethodBeat.o(98389);
      return str;
    }
    AppMethodBeat.o(98389);
    return paramString;
  }
  
  private void c(l.a parama)
  {
    AppMethodBeat.i(307902);
    try
    {
      hnS();
      if (this.RlJ != null)
      {
        parama = this.RlJ.a(parama);
        if (parama != null)
        {
          parama.S((ViewGroup)this.Cxb);
          parama.hba();
        }
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(307902);
    }
  }
  
  private void d(l.a parama)
  {
    AppMethodBeat.i(307904);
    try
    {
      hnS();
      if ((parama.QXC != null) && (this.Cxb != null) && (this.RlJ != null))
      {
        FloatJumpCompHelper localFloatJumpCompHelper = this.RlJ.a(parama.QXC, (ViewGroup)this.Cxb);
        if (localFloatJumpCompHelper != null)
        {
          this.Rms = localFloatJumpCompHelper;
          getLifecycle().addObserver(localFloatJumpCompHelper);
          if (parama.QXC.PRW != null)
          {
            parama = parama.QXC.PRW.QJP;
            if (!TextUtils.isEmpty(parama)) {
              this.RlO.add(parama);
            }
          }
        }
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(307904);
    }
  }
  
  private void ewf()
  {
    AppMethodBeat.i(98369);
    com.tencent.mm.plugin.report.service.h localh;
    String str2;
    if (this.recSrc != 2)
    {
      localh = com.tencent.mm.plugin.report.service.h.OAn;
      str2 = com.tencent.mm.plugin.sns.data.t.uA(com.tencent.mm.plugin.sns.data.t.aXD(this.Rln.hQX));
      if (this.uxInfo != null) {
        break label146;
      }
    }
    label146:
    for (String str1 = "";; str1 = this.uxInfo)
    {
      localh.b(14655, new Object[] { str2, str1, Integer.valueOf(this.Rln.miZ), Integer.valueOf(this.Rln.xYX), Long.valueOf(this.enterTime), Integer.valueOf(this.QLu), this.Rln.rzx });
      if (com.tencent.mm.plugin.sns.ad.i.a.ajx(this.source)) {
        com.tencent.mm.plugin.sns.ad.i.a.gN(this.QLB, 8);
      }
      AppMethodBeat.o(98369);
      return;
    }
  }
  
  private List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n> getAllComp()
  {
    AppMethodBeat.i(98380);
    this.RlD = new ArrayList();
    Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.Rlw.getAdapter();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)localObject).fragments.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Fragment localFragment = (Fragment)((Iterator)localObject).next();
        this.RlD.addAll(((ContentFragment)localFragment).hjV());
      }
    }
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.kE(this.RlD);
    localObject = this.RlD;
    AppMethodBeat.o(98380);
    return localObject;
  }
  
  private void hnA()
  {
    AppMethodBeat.i(179187);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "reportValidExposure viewId = " + this.viewId + ", commInfo = " + this.QLz + ", uxInfo = " + this.uxInfo + ", exposureType = 1");
    this.RlQ = true;
    k(this.viewId, this.QLz, this.uxInfo, 1);
    AppMethodBeat.o(179187);
  }
  
  private boolean hnB()
  {
    AppMethodBeat.i(98370);
    int j = this.RlA.getChildCount();
    int i = 0;
    while (i < j)
    {
      if ((this.RlA.getChildAt(i) instanceof SnsAdLandingPageFloatView))
      {
        AppMethodBeat.o(98370);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(98370);
    return false;
  }
  
  private List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h> hnC()
  {
    AppMethodBeat.i(98376);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.QXz.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h localh = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h)localIterator.next();
      if (localh.QXk) {
        localArrayList.add(localh);
      }
    }
    kL(localArrayList);
    AppMethodBeat.o(98376);
    return localArrayList;
  }
  
  private void hnF()
  {
    AppMethodBeat.i(307851);
    androidx.i.a.a.al(this).a(this.Rmb, new IntentFilter("com.tencent.mm.adlanding.video_progressbar_change"));
    this.PUc.alive();
    if ((this.RlK != null) && (this.RlK.isShowing())) {
      this.RlK.hao();
    }
    hnN().hjW();
    AppMethodBeat.o(307851);
  }
  
  private boolean hnH()
  {
    AppMethodBeat.i(98382);
    if (this.Rlx != 0)
    {
      if (((this.Rlx & 0x4) == 0) || ((this.Rlx & 0x2) == 0) || ((hnL()) && (this.bizId == 2)) || ((this.Rlx & 0x1) == 0) || ((this.Rlx & 0x20) == 0))
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
  
  private boolean hnI()
  {
    return (this.Rlx & 0x8) == 0;
  }
  
  private boolean hnJ()
  {
    return this.Rly == 0;
  }
  
  private boolean hnK()
  {
    AppMethodBeat.i(98383);
    if ((!Util.isNullOrNil(this.Rlh)) && (!Util.isNullOrNil(this.Rli)))
    {
      AppMethodBeat.o(98383);
      return true;
    }
    AppMethodBeat.o(98383);
    return false;
  }
  
  private boolean hnL()
  {
    return (this.Rlx & 0x10) == 0;
  }
  
  private al hnM()
  {
    AppMethodBeat.i(98385);
    Object localObject = hnN().hjV().iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n localn = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n)((Iterator)localObject).next();
      if ((localn instanceof al))
      {
        localObject = (al)localn;
        AppMethodBeat.o(98385);
        return localObject;
      }
    }
    AppMethodBeat.o(98385);
    return null;
  }
  
  private a hnO()
  {
    AppMethodBeat.i(98388);
    Object localObject = new ADXml(this.Rlf);
    if (((ADXml)localObject).hasVoteInfo())
    {
      int i = AdLandingPagesProxy.getInstance().getAdVoteIndex(((ADXml)localObject).adVoteInfo.QIe, this.uxInfo, this.uin);
      if ((i > 0) && (i <= ((ADXml)localObject).adVoteInfo.QIg.size()))
      {
        localObject = (ADXml.m)((ADXml)localObject).adVoteInfo.QIg.get(i - 1);
        a locala = new a((byte)0);
        if (!Util.isNullOrNil(((ADXml.m)localObject).svG))
        {
          locala.svG = ((ADXml.m)localObject).svG;
          if (Util.isNullOrNil(((ADXml.m)localObject).ICb)) {
            break label165;
          }
          locala.ICb = ((ADXml.m)localObject).ICb;
          label128:
          if (Util.isNullOrNil(((ADXml.m)localObject).QIh)) {
            break label176;
          }
        }
        label165:
        label176:
        for (locala.QIh = ((ADXml.m)localObject).QIh;; locala.QIh = this.Rll)
        {
          AppMethodBeat.o(98388);
          return locala;
          locala.svG = this.svG;
          break;
          locala.ICb = this.ICb;
          break label128;
        }
      }
    }
    AppMethodBeat.o(98388);
    return null;
  }
  
  private void hnS()
  {
    AppMethodBeat.i(307906);
    if (this.RlJ == null) {
      this.RlJ = new com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.a();
    }
    AppMethodBeat.o(307906);
  }
  
  private void hnT()
  {
    AppMethodBeat.i(98398);
    if ((this.Rla != null) && (this.RlA != null) && (this.RlK == null))
    {
      this.RlK = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d(this, this.Rla, this.RlA);
      if (!this.RlK.QNy) {
        r(false, 0L);
      }
      if ((this.Rla.QLh instanceof r))
      {
        r localr = (r)this.Rla.QLh;
        if (!TextUtils.isEmpty(localr.QJP)) {
          this.RlO.add(localr.QJP);
        }
      }
    }
    AppMethodBeat.o(98398);
  }
  
  private boolean hnV()
  {
    AppMethodBeat.i(98404);
    if (this.Rla != null)
    {
      if (this.Rla.QLg == 1)
      {
        boolean bool = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.w.ald(this.source);
        AppMethodBeat.o(98404);
        return bool;
      }
      AppMethodBeat.o(98404);
      return true;
    }
    AppMethodBeat.o(98404);
    return false;
  }
  
  private void hnW()
  {
    AppMethodBeat.i(307922);
    String str = com.tencent.mm.plugin.sns.ad.i.a.aWG(this.QLB);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "doBackToThirdApp, appId=".concat(String.valueOf(str)));
    if (!TextUtils.isEmpty(str)) {
      AdLandingPagesProxy.getInstance().launchBackApp(str);
    }
    AppMethodBeat.o(307922);
  }
  
  private void hnr()
  {
    long l = 1000L;
    AppMethodBeat.i(98364);
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SnsAdNativeLandingPagesUI.launch", "initAfterConnectToMM");
    AdlandingRemoteServiceConnectedReceiver.a(androidx.i.a.a.al(this));
    aNi();
    if (this.Rld) {
      if (this.RlX.haO()) {
        if (this.RlX.PTL) {
          com.tencent.threadpool.h.ahAA.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(307928);
              SnsAdNativeLandingPagesUI.A(SnsAdNativeLandingPagesUI.this);
              AppMethodBeat.o(307928);
            }
          }, l);
        }
      }
    }
    for (;;)
    {
      refreshView();
      ewf();
      hny();
      Ef(true);
      this.uYV = true;
      hns();
      hnt();
      AppMethodBeat.o(98364);
      return;
      if (!this.RlX.PTN) {
        break;
      }
      l = this.RlX.haN();
      break;
      bXA();
      continue;
      hnG();
    }
  }
  
  private void hns()
  {
    AppMethodBeat.i(307726);
    if ((alT(this.source)) && (!TextUtils.isEmpty(this.uxInfo)))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "doUpdateUxInfoScene, uxInfo=" + this.uxInfo + ", source=" + this.source);
      AdLandingPagesProxy.getInstance().doUpdateUxInfoScene(this.uxInfo, this.source, new AdLandingPagesProxy.e()
      {
        public final void h(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
        {
          AppMethodBeat.i(308616);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "doUpdateUxInfoScene end, errType=" + paramAnonymousInt1 + ", errNo=" + paramAnonymousInt2 + ", newUxInfo=" + paramAnonymousObject);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && ((paramAnonymousObject instanceof String))) {
            SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this, (String)paramAnonymousObject);
          }
          AppMethodBeat.o(308616);
        }
        
        public final void onCallback(Object paramAnonymousObject) {}
      });
      hnu();
    }
    AppMethodBeat.o(307726);
  }
  
  private void hnt()
  {
    AppMethodBeat.i(307733);
    AdLandingPagesProxy.getInstance().doAdNativeAntiAbuseScene(this.Rln.rzx, this.uxInfo, this.source, this.adExtInfo, new AdLandingPagesProxy.e()
    {
      public final void h(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(308613);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "doAdNativeAntiAbuseScene end, errType = " + paramAnonymousInt1 + ", errNo = " + paramAnonymousInt2 + ", canvasAuthFailed = " + paramAnonymousObject);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousObject != null)) {
          try
          {
            by localby = new by();
            localby.parseFrom((byte[])paramAnonymousObject);
            if (localby.YDI != 0) {
              MMHandlerThread.postToMainThreadDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(308608);
                  Context localContext = SnsAdNativeLandingPagesUI.this.getApplicationContext();
                  if (localContext != null) {
                    com.tencent.mm.ui.base.aa.dc(localContext, "广告无效，已为你关闭");
                  }
                  SnsAdNativeLandingPagesUI.this.dmJ();
                  AppMethodBeat.o(308608);
                }
              }, 500L);
            }
            AppMethodBeat.o(308613);
            return;
          }
          finally
          {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", paramAnonymousObject.toString());
          }
        }
        AppMethodBeat.o(308613);
      }
      
      public final void onCallback(Object paramAnonymousObject) {}
    });
    AppMethodBeat.o(307733);
  }
  
  private void hnu()
  {
    AppMethodBeat.i(307739);
    try
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "checkPreloadScanRes, uxinfo=" + this.uxInfo);
      com.tencent.mm.plugin.sns.ad.timeline.helper.h.a(ADXml.b.ah(this.values, ".adxml.adScanInfo"), this.uxInfo);
      AppMethodBeat.o(307739);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "checkPreloadScanRes exp=" + localException.toString());
      AppMethodBeat.o(307739);
    }
  }
  
  private void hnv()
  {
    AppMethodBeat.i(307757);
    try
    {
      if ((this.RlV != null) && (this.RlV.isShowing())) {
        this.RlV.cyW();
      }
      AppMethodBeat.o(307757);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "hideMoreOptionMenu exp=" + localException.toString());
      AppMethodBeat.o(307757);
    }
  }
  
  private void hnx()
  {
    AppMethodBeat.i(98367);
    Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.Rlw.getAdapter();
    if (localObject == null)
    {
      AppMethodBeat.o(98367);
      return;
    }
    localObject = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)localObject).fragments.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ContentFragment localContentFragment = (ContentFragment)((Iterator)localObject).next();
      if ((localContentFragment.QUb != null) && (localContentFragment.getUserVisibleHint())) {
        localContentFragment.QUb.hjR();
      }
    }
    if (this.RlK != null) {
      this.RlK.hap();
    }
    AppMethodBeat.o(98367);
  }
  
  private void hny()
  {
    AppMethodBeat.i(179185);
    try
    {
      if (!Util.isNullOrNil(new String[] { this.viewId, this.QLz }))
      {
        if (!this.RlP) {
          hnz();
        }
        if ((!this.RlQ) && (this.RlS != null))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "execute mValidExposureRunnable onCreate");
          this.RlS.removeCallbacks(this.Rmj);
          this.RlS.postDelayed(this.Rmj, 1000L);
        }
      }
      AppMethodBeat.o(179185);
      return;
    }
    finally
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", localObject.toString());
      AppMethodBeat.o(179185);
    }
  }
  
  private void hnz()
  {
    AppMethodBeat.i(179186);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "reportOriginalExposure viewId = " + this.viewId + ", commInfo = " + this.QLz + ", uxInfo = " + this.uxInfo + ", exposureType = 0");
    this.RlP = true;
    k(this.viewId, this.QLz, this.uxInfo, 0);
    AppMethodBeat.o(179186);
  }
  
  private static void k(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(179188);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("viewid", paramString1);
      localJSONObject.put("commInfo", paramString2);
      localJSONObject.put("uxinfo", paramString3);
      localJSONObject.put("exposureType", paramInt);
      com.tencent.mm.plugin.sns.data.m.lU("rewarded_canvas_exposure", localJSONObject.toString());
      AppMethodBeat.o(179188);
      return;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "doCanvasExposureReport exp=" + paramString1.toString());
      AppMethodBeat.o(179188);
    }
  }
  
  private void kL(List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h> paramList)
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
        Iterator localIterator = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h)paramList.next()).QXi.iterator();
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
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localaa).QJd = i;
            j = i + 1;
          }
          String str;
          if ((localaa instanceof r))
          {
            str = ((r)localaa).QJP;
            if (!TextUtils.isEmpty(str)) {
              this.RlO.add(str);
            }
          }
          if ((localaa instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q))
          {
            str = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)localaa).jumpUrl;
            if (!TextUtils.isEmpty(str)) {
              this.RlO.add(str);
            }
          }
          if (!Rmn.contains(localaa))
          {
            Rmn.add(localaa);
            com.tencent.mm.plugin.sns.ad.d.o.a(this.hQX, this.source, localaa);
          }
          i = j;
          if (!this.Rmm)
          {
            com.tencent.mm.plugin.sns.ad.d.j.a(localaa, (ArrayList)localObject);
            i = j;
          }
        }
      }
      if (this.Rmm) {
        break label296;
      }
    }
    catch (Exception paramList)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "giveIdxForApkBtnInfo, exp=" + paramList.toString());
      AppMethodBeat.o(98377);
      return;
    }
    this.Rmm = true;
    if (!((ArrayList)localObject).isEmpty()) {
      com.tencent.mm.plugin.sns.ad.d.j.i((ArrayList)localObject, this.preloadWeAppPkg);
    }
    label296:
    if (!com.tencent.mm.plugin.sns.ad.j.d.isEmpty(this.RlO))
    {
      localObject = com.tencent.mm.plugin.sns.ad.c.a.a.a(this.RlO, this.qTb, this.aid, this.QLw, this.uxInfo);
      if (!com.tencent.mm.plugin.sns.ad.j.d.y((Object[])localObject)) {
        if (!TextUtils.isEmpty(this.hQX)) {
          break label370;
        }
      }
    }
    label370:
    for (paramList = this.QLy;; paramList = this.hQX)
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
    if ((this.bizId == 2) && (!hnJ()))
    {
      localObject = (FrameLayout.LayoutParams)this.Rlw.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).setMargins(0, 0, 0, bf.bk(this));
      this.Rlw.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int i = b.c.sns_ad_constant_white;
    if (!hnJ())
    {
      i = getResources().getColor(b.c.sns_ad_constant_black);
      if ((this.QXz == null) || (this.QXz.size() <= 0) || (Util.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h)this.QXz.getFirst()).qWk))) {
        break label365;
      }
      i = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h)this.QXz.getFirst()).qWk);
    }
    label365:
    for (;;)
    {
      this.RlB.setBackgroundColor(i);
      i = b.c.sns_ad_constant_black;
      localObject = this.nkq.getDrawable();
      if (localObject != null)
      {
        androidx.core.graphics.drawable.a.a((Drawable)localObject, androidx.core.content.a.w(this, i));
        this.nkq.setImageDrawable((Drawable)localObject);
      }
      localObject = this.NJV.getDrawable();
      if (localObject != null)
      {
        androidx.core.graphics.drawable.a.a((Drawable)localObject, androidx.core.content.a.w(this, i));
        this.NJV.setImageDrawable((Drawable)localObject);
      }
      if ((hnK()) && (!hnL()) && (this.bizId == 2))
      {
        this.NJV.setVisibility(8);
        this.Rlc.setVisibility(0);
        this.Rlc.setText(this.Rlh);
        this.Rlc.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(308619);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            SnsAdNativeLandingPagesUI.this.R(SnsAdNativeLandingPagesUI.this, SnsAdNativeLandingPagesUI.B(SnsAdNativeLandingPagesUI.this), SnsAdNativeLandingPagesUI.C(SnsAdNativeLandingPagesUI.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(308619);
          }
        });
        AppMethodBeat.o(98365);
        return;
      }
      if (hnH())
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "canShowMenuBtn=true, disableShareBitSet=" + this.Rlx);
        this.NJV.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(98330);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            SnsAdNativeLandingPagesUI.this.hnw();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98330);
          }
        });
        AppMethodBeat.o(98365);
        return;
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "canShowMenuBtn=false, disableShareBitSet=" + this.Rlx);
      this.NJV.setVisibility(8);
      AppMethodBeat.o(98365);
      return;
    }
  }
  
  private void report()
  {
    AppMethodBeat.i(98368);
    Object localObject1 = getAllComp();
    Object localObject2 = this.RlI.values().iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).addAll(((SnsAdLandingPageFloatView)((Iterator)localObject2).next()).getAllComp());
    }
    if (this.RlK != null)
    {
      ((List)localObject1).add(this.RlK);
      localObject2 = this.RlK.hiP();
      if (localObject2 != null)
      {
        this.RlK.hiO();
        ((List)localObject1).add(localObject2);
      }
    }
    if (this.RlJ != null)
    {
      localObject2 = this.RlJ.haX();
      if (com.tencent.mm.plugin.sns.ad.j.d.B((Collection)localObject2)) {
        ((List)localObject1).addAll((Collection)localObject2);
      }
    }
    this.hTS += System.currentTimeMillis() - this.startTime;
    this.Rln.QXQ = ((int)this.hTS);
    this.Rln.QXP = ((List)localObject1).size();
    localObject2 = this.Rln;
    Iterator localIterator = ((List)localObject1).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n localn = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n)localIterator.next();
      if (!localn.QOV.QKP)
      {
        JSONObject localJSONObject = new JSONObject();
        if ((!localn.M(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.n)localObject2).QXT)) && (localn.bP(localJSONObject))) {
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.n)localObject2).QXT.put(localJSONObject);
        }
      }
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "landingPage report json %s", new Object[] { this.Rln.QXT });
    localObject2 = this.Rln.hkE();
    if (this.bizId == 2)
    {
      AdLandingPagesProxy.getInstance().doCgiReportCanvasBrowseInfo(15041, (String)localObject2);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "post cgi stat 15041 data: ".concat(String.valueOf(localObject2)));
    }
    for (;;)
    {
      localObject2 = this.RlZ;
      long l1 = ((a.c)localObject2).PTq;
      long l2 = ((a.c)localObject2).PTp;
      long l3 = ((a.c)localObject2).PTu;
      long l4 = ((a.c)localObject2).PTp;
      long l5 = ((a.c)localObject2).PTv;
      long l6 = ((a.c)localObject2).PTp;
      ((a.c)localObject2).PTw = ("onCreateTime=" + (l1 - l2) + "|viewCreate=" + (l3 - l4) + "|firstFrame=" + (l5 - l6));
      int i = (int)(((a.c)localObject2).PTp - ((a.c)localObject2).mStartTime);
      int j = (int)(((a.c)localObject2).PTt - ((a.c)localObject2).PTs);
      com.tencent.mm.sdk.platformtools.Log.i("AdLandingPageStaticHelper", "reportTime, ipcConnTime=" + j + "|processTime=" + i + "|" + ((a.c)localObject2).PTw + ", clickStart=" + ((a.c)localObject2).mStartTime + ", source=" + ((a.c)localObject2).xOq);
      com.tencent.mm.plugin.sns.data.l.a(com.tencent.mm.plugin.sns.data.l.Qny, String.valueOf(((a.c)localObject2).xOq), i, j, ((a.c)localObject2).PTw);
      localObject1 = new com.tencent.mm.plugin.sns.ad.landingpage.helper.a.b().D((List)localObject1, this.uxInfo);
      com.tencent.threadpool.h.ahAA.bm(new a.b.1((com.tencent.mm.plugin.sns.ad.landingpage.helper.a.b)localObject1));
      AppMethodBeat.o(98368);
      return;
      if (AdLandingPagesProxy.getInstance().isRecExpAd(this.Rln.hQX))
      {
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(14650, (String)localObject2);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 14650 data: ".concat(String.valueOf(localObject2)));
      }
      else
      {
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(13387, (String)localObject2);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 13387 data: ".concat(String.valueOf(localObject2)));
      }
    }
  }
  
  private void t(ContentFragment paramContentFragment)
  {
    AppMethodBeat.i(98399);
    if (!hnU()) {
      paramContentFragment.hkb();
    }
    AppMethodBeat.o(98399);
  }
  
  private void vq(long paramLong)
  {
    AppMethodBeat.i(98401);
    if (this.RlK != null)
    {
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SnsAdNativeLandingPagesUI", "showFloatBarView");
      this.RlK.uZ(paramLong);
      ContentFragment localContentFragment = hnN();
      if (localContentFragment != null) {
        localContentFragment.hkc();
      }
    }
    AppMethodBeat.o(98401);
  }
  
  public final String Ee(boolean paramBoolean)
  {
    AppMethodBeat.i(308232);
    try
    {
      Object localObject3 = this.Rlf.replaceAll("(?s)<adCanvasInfoLeft[^>]*>.*?</adCanvasInfoLeft>", "").replaceAll("(?s)<adCanvasInfoRight[^>]*>.*?</adCanvasInfoRight>", "");
      Object localObject1 = localObject3;
      if (localObject3 != null)
      {
        localObject1 = localObject3;
        if (((String)localObject3).contains("<adFullCardGestureCanvasInfo>")) {
          localObject1 = ((String)localObject3).replaceAll("(?s)<adFullCardGestureCanvasInfo[^>]*>.*?</adFullCardGestureCanvasInfo>", "");
        }
      }
      localObject3 = localObject1;
      if (paramBoolean)
      {
        localObject3 = localObject1;
        if (((String)localObject1).contains("<shareAdCanvasInfo>")) {
          localObject3 = ((String)localObject1).replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replace("shareAdCanvasInfo", "adCanvasInfo");
        }
      }
      localObject1 = localObject3;
      if (((String)localObject3).contains("<giveHBCardInfo>")) {
        localObject1 = ((String)localObject3).replaceAll("(?s)<giveHBCardInfo[^>]*>.*?</giveHBCardInfo>", "");
      }
      localObject3 = localObject1;
      if (this.RlY)
      {
        localObject3 = localObject1;
        if (!((String)localObject1).contains("isInteractiveCanvas")) {
          localObject3 = ((String)localObject1).replace("<adCanvasInfo>", "<adCanvasInfo><isInteractiveCanvas>1</isInteractiveCanvas>");
        }
      }
      AppMethodBeat.o(308232);
      return localObject3;
    }
    finally
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "genForwardXml, exp=" + localObject2.toString());
      String str = this.Rlf;
      AppMethodBeat.o(308232);
      return str;
    }
  }
  
  public final void Ef(boolean paramBoolean)
  {
    AppMethodBeat.i(98394);
    if ((paramBoolean) && (this.bizId == 1)) {
      AdLandingPagesProxy.getInstance().doDynamicUpdateScene(this.Rls, this.Rlt, this.Rlu, this.Rmh);
    }
    if ((this.bizId == 2) && (!Util.isNullOrNil(this.Rlv))) {
      AdLandingPagesProxy.getInstance().doSearchDynamicUpdateScene(this.Rlv, this.Rmh);
    }
    this.Rlr = true;
    AppMethodBeat.o(98394);
  }
  
  public final void R(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(98396);
    Intent localIntent = new Intent();
    localIntent.putExtra("sns_landig_pages_from_source", 14);
    int i;
    String str2;
    String str1;
    JSONObject localJSONObject;
    if (this.QLu == 0)
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
      i = this.QLu;
      break;
      paramString1 = "";
    }
  }
  
  public final void a(final com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa paramaa, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, final boolean paramBoolean3)
  {
    AppMethodBeat.i(98395);
    if ((this.Rmq != null) && (!paramBoolean3))
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.SnsAdNativeLandingPagesUI", "bottom sheet appear several times");
      this.Rmq.cyW();
      if (this.Rmr != null)
      {
        this.Rmr.dismiss();
        this.Rmr = null;
      }
      AppMethodBeat.o(98395);
      return;
    }
    AdLandingPagesProxy.e local24 = new AdLandingPagesProxy.e()
    {
      public final void h(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(308064);
        SnsAdNativeLandingPagesUI.this.Ef(false);
        if (paramBoolean3)
        {
          if (SnsAdNativeLandingPagesUI.X(SnsAdNativeLandingPagesUI.this) != null) {
            SnsAdNativeLandingPagesUI.X(SnsAdNativeLandingPagesUI.this).cyW();
          }
          if (SnsAdNativeLandingPagesUI.Y(SnsAdNativeLandingPagesUI.this) != null)
          {
            SnsAdNativeLandingPagesUI.Y(SnsAdNativeLandingPagesUI.this).dismiss();
            SnsAdNativeLandingPagesUI.Z(SnsAdNativeLandingPagesUI.this);
          }
        }
        AppMethodBeat.o(308064);
      }
      
      public final void onCallback(Object paramAnonymousObject) {}
    };
    AppCompatActivity localAppCompatActivity;
    LinearLayout localLinearLayout;
    if (!paramBoolean3)
    {
      localAppCompatActivity = getContext();
      localLinearLayout = new LinearLayout(getContext());
      if (Util.isNullOrNil(paramaa.QKL)) {
        break label223;
      }
    }
    label223:
    for (int i = Color.parseColor(paramaa.QKL);; i = -1)
    {
      paramaa = bb.a(localAppCompatActivity, paramaa, localLinearLayout, i);
      this.Rmq = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o(getContext(), paramaa, paramString1, paramString2, paramString3, paramBoolean1, paramBoolean2);
      paramaa = paramaa.getView();
      this.Rmq.QPe = new o.a()
      {
        private void onRemove()
        {
          AppMethodBeat.i(307991);
          if ((paramaa != null) && (paramaa.getParent() != null)) {
            ((ViewGroup)paramaa.getParent()).removeView(paramaa);
          }
          SnsAdNativeLandingPagesUI.aa(SnsAdNativeLandingPagesUI.this);
          AppMethodBeat.o(307991);
        }
        
        public final void hjo()
        {
          AppMethodBeat.i(307992);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "onDismiss");
          onRemove();
          AppMethodBeat.o(307992);
        }
        
        public final void hjp()
        {
          AppMethodBeat.i(307994);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "onCancel");
          onRemove();
          AppMethodBeat.o(307994);
        }
      };
      this.Rmq.dDn();
      if (!Util.isNullOrNil(paramString1))
      {
        AdLandingPagesProxy.getInstance().doFavOfficialItemScene(paramString1, local24);
        if (paramBoolean3) {
          this.Rmr = k.a(this, getString(b.j.sns_loading), false, null);
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
  
  public final void dmJ()
  {
    AppMethodBeat.i(98384);
    Object localObject;
    try
    {
      Iterator localIterator1 = this.RlI.values().iterator();
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
    hnv();
    hnx();
    report();
    this.Rlp = true;
    this.RlB.setVisibility(8);
    if ((this.RlX != null) && (this.RlX.PTL) && (alU(this.source))) {
      this.Rld = false;
    }
    if (!this.Rld)
    {
      finish();
      AppMethodBeat.o(98384);
      return;
    }
    if (this.RlG)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "is playing animation");
      AppMethodBeat.o(98384);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "run exit animation, %s", new Object[] { Boolean.valueOf(this.Rld) });
    this.RlG = true;
    if (isSupportNavigationSwipeBack()) {
      getSwipeBackLayout().setEnableGesture(false);
    }
    Iterator localIterator2 = hnN().hjV().iterator();
    while (localIterator2.hasNext())
    {
      localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n)localIterator2.next();
      if ((localObject instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a))
      {
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject).haw();
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n)localObject).hjl();
      }
    }
    hnp();
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(308198);
        SnsAdNativeLandingPagesUI.V(SnsAdNativeLandingPagesUI.this);
        AppMethodBeat.o(308198);
      }
    }, 30L);
    AppMethodBeat.o(98384);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return b.g.sns_ad_native_landing_pages_ui;
  }
  
  public final ai hjn()
  {
    AppMethodBeat.i(308192);
    if (this.Qud == null) {
      this.Qud = new ai();
    }
    Object localObject1 = this.Qud;
    int i;
    Object localObject4;
    label182:
    boolean bool;
    if (this.QLu == 0)
    {
      i = this.source;
      ((ai)localObject1).QLu = i;
      this.Qud.source = this.source;
      this.Qud.QLv = this.Rlm;
      this.Qud.uxInfo = this.uxInfo;
      this.Qud.QLw = this.QLw;
      this.Qud.uin = this.uin;
      this.Qud.bizId = this.bizId;
      this.Qud.aid = this.aid;
      this.Qud.qTb = this.qTb;
      localObject1 = this.Qud;
      localObject4 = this.QLC;
      ((ai)localObject1).QLC.putAll((Map)localObject4);
      localObject4 = this.Qud;
      if (this.Rln == null) {
        break label438;
      }
      localObject1 = this.Rln.rzx;
      ((ai)localObject4).rzx = ((String)localObject1);
      localObject1 = this.Qud;
      if (this.Rla == null) {
        break label446;
      }
      bool = true;
      label204:
      ((ai)localObject1).QLx = bool;
      this.Qud.QLB = this.QLB;
    }
    for (;;)
    {
      try
      {
        localObject4 = this.Qud;
        if (Util.isNullOrNil(this.hQX)) {
          if (this.Rln != null)
          {
            localObject1 = String.valueOf(com.tencent.mm.plugin.sns.data.m.aXe(this.Rln.hQX));
            ((ai)localObject4).hQX = ((String)localObject1);
          }
        }
      }
      finally
      {
        label438:
        label446:
        long l;
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", localObject3.toString());
        continue;
      }
      try
      {
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).startsWith("-"))) {
          continue;
        }
        ((ai)localObject4).QLy = com.tencent.mm.plugin.sns.data.t.uA(Util.safeParseLong((String)localObject1));
        com.tencent.mm.sdk.platformtools.Log.i("AdLandingPageData", "setSnsId, snsId=" + (String)localObject1 + ", rawSnsId=" + ((ai)localObject4).QLy);
      }
      finally
      {
        continue;
      }
      if (!Util.isNullOrNil(new String[] { this.viewId, this.QLz }))
      {
        this.Qud.viewId = this.viewId;
        this.Qud.QLz = this.QLz;
      }
      this.Qud.adExtInfo = this.adExtInfo;
      this.Qud.QLA = this.QLA;
      this.Qud.pId = this.pId;
      localObject1 = this.Qud;
      AppMethodBeat.o(308192);
      return localObject1;
      i = this.QLu;
      break;
      localObject1 = "";
      break label182;
      bool = false;
      break label204;
      localObject1 = "";
      continue;
      l = com.tencent.mm.plugin.sns.data.m.aXe(this.hQX);
      localObject1 = String.valueOf(l);
      continue;
      ((ai)localObject4).QLy = ((String)localObject1);
    }
  }
  
  public final void hnD()
  {
    AppMethodBeat.i(308200);
    Object localObject = getAllComp();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n)((List)localObject).get(0);
      if ((localObject instanceof aj))
      {
        ((aj)localObject).QRQ = true;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "snsId = " + this.hQX + ", adSightVideoSeekTime = " + this.QLA + ", isFirstSightVideoComp = true");
        AppMethodBeat.o(308200);
        return;
      }
      if ((localObject instanceof com.tencent.mm.plugin.sns.ad.landingpage.component.comp.g))
      {
        ((com.tencent.mm.plugin.sns.ad.landingpage.component.comp.g)localObject).PQD = true;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "snsId = " + this.hQX + ", adVideoSeekTime = " + this.QLA + ", isFirstVideoComp = true");
      }
    }
    AppMethodBeat.o(308200);
  }
  
  public final void hnE()
  {
    AppMethodBeat.i(308207);
    this.QUm = false;
    com.tencent.mm.plugin.sns.ad.landingpage.helper.b.a.hbb().stop();
    if (this.PQt != null)
    {
      this.PQt.setFullScreen(this.QUm);
      this.PQt.haI();
      ViewGroup localViewGroup = this.PQt.getVideoCompContainer();
      AdLandingVideoPlayerToolBar localAdLandingVideoPlayerToolBar = this.PQt.getToolBar();
      localAdLandingVideoPlayerToolBar.Dy(false);
      this.PQt.setAnimImmediately(true);
      this.PQt.ajv(0);
      this.PQt.Dp(false);
      Object localObject = (ViewGroup)this.PQt.getParent();
      this.RlA.removeView((View)localObject);
      ((ViewGroup)localObject).removeView(this.PQt);
      ((ViewGroup)localObject).removeView(localAdLandingVideoPlayerToolBar);
      if (!this.RlW) {
        getSwipeBackLayout().setEnableGesture(true);
      }
      localViewGroup.addView(this.PQt);
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      localViewGroup.addView(localAdLandingVideoPlayerToolBar, (ViewGroup.LayoutParams)localObject);
      hnF();
    }
    AppMethodBeat.o(308207);
  }
  
  public final void hnG()
  {
    AppMethodBeat.i(98379);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.Rlw.getAdapter();
    if (localb == null)
    {
      localb = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b(getSupportFragmentManager(), new ArrayList());
      this.Rlw.setAdapter(localb);
    }
    for (;;)
    {
      List localList = hnC();
      int i = 0;
      if (i < localList.size())
      {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h localh = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h)this.QXz.get(i);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "loadLandingPages load id %s", new Object[] { Integer.valueOf(localh.id) });
        ContentFragment localContentFragment = (ContentFragment)this.Rml.get(Integer.valueOf(localh.id));
        boolean bool;
        label214:
        label244:
        int j;
        if (localContentFragment == null)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("pageInfo", localh);
          localHashMap.put("pageCount", Integer.valueOf(localList.size()));
          localHashMap.put("viewPager", this.Rlw);
          localHashMap.put("pageDownIconInfo", this.QUd);
          if (i == 0)
          {
            bool = true;
            localHashMap.put("is_first_show_page", Boolean.valueOf(bool));
            if (i != localList.size() - 1) {
              break label393;
            }
            bool = true;
            localHashMap.put("is_last_shown_page", Boolean.valueOf(bool));
            localHashMap.put("needEnterAnimation", Boolean.valueOf(this.Rld));
            localHashMap.put("needDirectionAnimation", Boolean.valueOf(hnI()));
            if (i != 0) {
              break label398;
            }
            j = this.Rlq;
            label304:
            localHashMap.put("groupListCompShowIndex", Integer.valueOf(j));
            localContentFragment = new ContentFragment();
            localContentFragment.params = localHashMap;
            if (i == 0) {
              localContentFragment.QUo = this.Rmf;
            }
            this.Rml.put(Integer.valueOf(localh.id), localContentFragment);
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
          localContentFragment.a(localh);
        }
      }
      localb.notifyDataSetChanged();
      this.Rlw.setOffscreenPageLimit(localList.size());
      AppMethodBeat.o(98379);
      return;
    }
  }
  
  public final ContentFragment hnN()
  {
    AppMethodBeat.i(98387);
    ContentFragment localContentFragment = null;
    if (this.QXz.size() > 0) {
      localContentFragment = (ContentFragment)this.Rml.get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h)this.QXz.get(this.Rlw.getCurrentItem())).id));
    }
    AppMethodBeat.o(98387);
    return localContentFragment;
  }
  
  public final String hnP()
  {
    AppMethodBeat.i(98390);
    Object localObject = new fhn();
    ((fhn)localObject).abIc = new fho();
    ((fhn)localObject).abIc.Ywb = this.Rln.uxInfo;
    ((fhn)localObject).abIc.abIf = this.Rln.hQX;
    ((fhn)localObject).abIc.adType = this.adType;
    try
    {
      localObject = Base64.encodeToString(((fhn)localObject).toByteArray(), 2);
      AppMethodBeat.o(98390);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(98390);
    }
    return "";
  }
  
  public final void hnQ()
  {
    AppMethodBeat.i(308260);
    try
    {
      boolean bool = hnR();
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "jumpNextPage, hasNextPage=".concat(String.valueOf(bool)));
      if (bool) {
        this.Rlw.alo(this.Rlw.getCurrentItem() + 1);
      }
      AppMethodBeat.o(308260);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "jumpNextPage exp:" + localException.toString());
      AppMethodBeat.o(308260);
    }
  }
  
  public final boolean hnR()
  {
    AppMethodBeat.i(98397);
    try
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.Rlw.getAdapter();
      int i = this.Rlw.getCurrentItem();
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
  
  public final boolean hnU()
  {
    AppMethodBeat.i(98400);
    if (this.RlK != null)
    {
      boolean bool = this.RlK.isShowing();
      AppMethodBeat.o(98400);
      return bool;
    }
    AppMethodBeat.o(98400);
    return false;
  }
  
  public final void hnp()
  {
    AppMethodBeat.i(308142);
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        int i = getApplicationContext().getApplicationInfo().targetSdkVersion;
        bool1 = bool2;
        if (com.tencent.mm.compatible.util.d.rb(29))
        {
          if (com.tencent.mm.compatible.util.d.rb(30)) {
            break label344;
          }
          bool1 = bool2;
          if (i >= 29) {
            break label344;
          }
        }
        String str1 = Util.nullAsNil(com.tencent.mm.compatible.deviceinfo.q.aPo());
        bool2 = bool1;
        if (!bool1)
        {
          bool2 = bool1;
          if (!TextUtils.isEmpty(str1))
          {
            bool2 = bool1;
            if ("huawei nxt-al10|mix 2s|sm-g9350".contains(str1.toLowerCase())) {
              bool2 = true;
            }
          }
        }
        if (!bool2)
        {
          bool1 = TextUtils.isEmpty(this.Rme);
          if (bool1) {}
          try
          {
            this.Rme = Util.nullAsNil(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yIs, "").toLowerCase());
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "initCfgBlackFixDevList, devList=" + this.Rme);
            String str2 = this.Rme;
            if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && (str2.contains(str1.toLowerCase())))
            {
              bool1 = true;
              if (bool1) {
                com.tencent.mm.ui.base.b.a(this, null);
              }
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "fixActivityTranslucent, device=" + str1 + ", api=" + Build.VERSION.SDK_INT + ", targetSdkVer=" + i + ", needFix=" + bool1);
              AppMethodBeat.o(308142);
              return;
            }
          }
          finally
          {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "initCfgBlackFixDevList, exp=" + localObject2.toString());
            continue;
          }
        }
        bool1 = bool2;
      }
      finally
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "fixActivityTranslucent exp=" + localObject1.toString());
        AppMethodBeat.o(308142);
        return;
      }
      continue;
      label344:
      boolean bool1 = true;
    }
  }
  
  public final void hnq()
  {
    AppMethodBeat.i(308143);
    if (this.QXz == null)
    {
      AppMethodBeat.o(308143);
      return;
    }
    Iterator localIterator = this.QXz.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h)localIterator.next();
      localObject = (ContentFragment)this.Rml.get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h)localObject).id));
      if (localObject != null) {
        ((ContentFragment)localObject).hkd();
      }
    }
    t((ContentFragment)this.Rml.get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h)this.QXz.getFirst()).id)));
    AppMethodBeat.o(308143);
  }
  
  public final void hnw()
  {
    AppMethodBeat.i(308156);
    if (this.NJV.getVisibility() != 0)
    {
      AppMethodBeat.o(308156);
      return;
    }
    hnv();
    this.RlV = new com.tencent.mm.ui.widget.a.f(this, 1, false);
    this.RlV.Vtg = new u.g()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
      {
        AppMethodBeat.i(309308);
        if ((SnsAdNativeLandingPagesUI.D(SnsAdNativeLandingPagesUI.this) == 0) || ((SnsAdNativeLandingPagesUI.D(SnsAdNativeLandingPagesUI.this) & 0x2) == 0)) {
          paramAnonymouss.a(1, SnsAdNativeLandingPagesUI.this.getString(b.j.retransmits), b.i.bottomsheet_icon_transmit);
        }
        if ((SnsAdNativeLandingPagesUI.D(SnsAdNativeLandingPagesUI.this) == 0) || ((SnsAdNativeLandingPagesUI.D(SnsAdNativeLandingPagesUI.this) & 0x1) == 0)) {
          paramAnonymouss.a(2, SnsAdNativeLandingPagesUI.this.getString(b.j.sns_ad_video_right_menu_share_sns), b.i.bottomsheet_icon_moment);
        }
        if (((SnsAdNativeLandingPagesUI.D(SnsAdNativeLandingPagesUI.this) == 0) || ((SnsAdNativeLandingPagesUI.D(SnsAdNativeLandingPagesUI.this) & 0x4) == 0)) && (SnsAdNativeLandingPagesUI.v(SnsAdNativeLandingPagesUI.this) != 7)) {
          paramAnonymouss.a(3, SnsAdNativeLandingPagesUI.this.getString(b.j.chatting_fav), b.i.bottomsheet_icon_fav);
        }
        if (((SnsAdNativeLandingPagesUI.D(SnsAdNativeLandingPagesUI.this) == 0) || (SnsAdNativeLandingPagesUI.E(SnsAdNativeLandingPagesUI.this))) && (SnsAdNativeLandingPagesUI.u(SnsAdNativeLandingPagesUI.this) == 2) && (SnsAdNativeLandingPagesUI.F(SnsAdNativeLandingPagesUI.this))) {
          if (SnsAdNativeLandingPagesUI.G(SnsAdNativeLandingPagesUI.this) == null) {
            break label276;
          }
        }
        label276:
        for (String str = SnsAdNativeLandingPagesUI.G(SnsAdNativeLandingPagesUI.this);; str = "")
        {
          paramAnonymouss.a(4, str, 0);
          if (((SnsAdNativeLandingPagesUI.D(SnsAdNativeLandingPagesUI.this) == 0) || ((SnsAdNativeLandingPagesUI.D(SnsAdNativeLandingPagesUI.this) & 0x20) == 0)) && (SnsAdNativeLandingPagesUI.H(SnsAdNativeLandingPagesUI.this) != null) && (SnsAdNativeLandingPagesUI.H(SnsAdNativeLandingPagesUI.this).RKp != null)) {
            paramAnonymouss.a(5, SnsAdNativeLandingPagesUI.this.getString(b.j.sns_ad_video_right_menu_open_in_browser), 0);
          }
          AppMethodBeat.o(309308);
          return;
        }
      }
    };
    this.RlV.sRz = true;
    this.RlV.GAC = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(309177);
        ar.bs(SnsAdNativeLandingPagesUI.this);
        if (paramAnonymousMenuItem != null) {
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(309177);
          return;
          SnsAdNativeLandingPagesUI.I(SnsAdNativeLandingPagesUI.this);
          AppMethodBeat.o(309177);
          return;
          SnsAdNativeLandingPagesUI.J(SnsAdNativeLandingPagesUI.this);
          AppMethodBeat.o(309177);
          return;
          SnsAdNativeLandingPagesUI.K(SnsAdNativeLandingPagesUI.this);
          AppMethodBeat.o(309177);
          return;
          SnsAdNativeLandingPagesUI.this.R(SnsAdNativeLandingPagesUI.this, SnsAdNativeLandingPagesUI.B(SnsAdNativeLandingPagesUI.this), SnsAdNativeLandingPagesUI.C(SnsAdNativeLandingPagesUI.this));
          AppMethodBeat.o(309177);
          return;
          SnsAdNativeLandingPagesUI.L(SnsAdNativeLandingPagesUI.this);
        }
      }
    };
    hideVKB();
    this.RlV.dDn();
    AppMethodBeat.o(308156);
  }
  
  public void initView()
  {
    AppMethodBeat.i(98381);
    super.initView();
    this.RlA = ((FrameLayout)findViewById(b.f.root));
    this.Cxb = findViewById(b.f.content_container);
    this.Rlw = ((AdlandingDummyViewPager)findViewById(b.f.vertical_viewpager));
    this.RlB = findViewById(b.f.menu_container);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "before, assistActivity");
    Object localObject1;
    Object localObject2;
    String str;
    if (aw.bx(getContext()))
    {
      final int i = aw.bw(this);
      localObject1 = (FrameLayout.LayoutParams)this.RlA.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject1).height = (this.pvg - i);
      ((FrameLayout.LayoutParams)localObject1).topMargin = i;
      this.RlA.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      getController().setActionbarColor(getResources().getColor(b.c.action_bar_color));
      this.RlA.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(308202);
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
                com.tencent.mm.plugin.sns.data.l.a(com.tencent.mm.plugin.sns.data.l.Qnp, "", i, paramAnonymousInt1, SnsAdNativeLandingPagesUI.S(SnsAdNativeLandingPagesUI.this) + "|" + SnsAdNativeLandingPagesUI.d(SnsAdNativeLandingPagesUI.this));
              }
              SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this).removeOnLayoutChangeListener(this);
            }
            AppMethodBeat.o(308202);
            return;
          }
          finally
          {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "onLayoutChange error:" + paramAnonymousView.toString());
            SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this).removeOnLayoutChangeListener(this);
            AppMethodBeat.o(308202);
          }
        }
      });
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(179177);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "hasCutOut, assistActivity");
          com.tencent.mm.ui.c.a(SnsAdNativeLandingPagesUI.this, true, SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this), SnsAdNativeLandingPagesUI.this.Rmo);
          AppMethodBeat.o(179177);
        }
      }, 1500L);
      this.pIB = ((ImageView)findViewById(b.f.gallery_bg));
      this.Rlb = ((ImageView)findViewById(b.f.anim_bg));
      this.nkq = ((ImageView)findViewById(b.f.sns_ad_native_landing_pages_close_img));
      localObject2 = (TextView)findViewById(b.f.sns_ad_native_landing_pages_left_bar_title);
      this.nkq.setOnClickListener(this.Rmt);
      ((TextView)localObject2).setOnClickListener(this.Rmu);
      if (!com.tencent.mm.plugin.sns.ad.i.a.ajx(this.source)) {
        break label430;
      }
      ((TextView)localObject2).setVisibility(0);
      this.nkq.setVisibility(8);
      this.RlW = true;
      this.Rld = false;
      str = this.QLB;
      localObject1 = com.tencent.mm.plugin.sns.ad.i.a.aWG(str);
      org.xwalk.core.Log.i("LandingPageOpenSdkBackHelper", "initBackLayout, extra=".concat(String.valueOf(str)));
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label392;
      }
      org.xwalk.core.Log.e("LandingPageOpenSdkBackHelper", "appId is empty");
    }
    for (;;)
    {
      this.NJV = ((ImageView)findViewById(b.f.sns_ad_native_landing_pages_more_img));
      this.Rlc = ((TextView)findViewById(b.f.sns_ad_native_landing_pages_right_bar_title));
      this.Rlk = ((ImageView)findViewById(b.f.sns_native_landing_first_screen_next_img));
      if (!this.RlX.haM()) {
        break label447;
      }
      AppMethodBeat.o(98381);
      return;
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(308180);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "noCutOut, assistActivity");
          com.tencent.mm.ui.c.a(SnsAdNativeLandingPagesUI.this, false, SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this), SnsAdNativeLandingPagesUI.this.Rmo);
          AppMethodBeat.o(308180);
        }
      }, 1500L);
      break;
      label392:
      str = getString(b.j.sns_ad_back);
      localObject2 = new WeakReference(localObject2);
      AdLandingPagesProxy.getInstance().getOpenSdkAppInfo((String)localObject1, new a.1((WeakReference)localObject2, str));
      continue;
      label430:
      ((TextView)localObject2).setVisibility(8);
      this.nkq.setVisibility(0);
    }
    label447:
    if (this.Rld)
    {
      this.RlA.setAlpha(0.0F);
      this.pIB.setAlpha(0.0F);
      com.tencent.mm.ui.base.b.a(this, null);
    }
    AppMethodBeat.o(98381);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(98392);
    String str;
    Object localObject5;
    if (paramInt1 == 2001) {
      if (paramInt2 == -1)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "share to timeLine success");
        str = Util.nullAsNil(this.uxInfo);
        localObject5 = Util.nullAsNil(this.Rln.rzx);
      }
    }
    for (;;)
    {
      try
      {
        str = com.tencent.mm.plugin.sns.b.b.I("3", "", str, (String)localObject5);
        com.tencent.mm.sdk.platformtools.Log.i("AntiCheatingReportUtils", "reportScreenShotParams = ".concat(String.valueOf(str)));
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(19214, str);
        k.cZ(getContext(), getContext().getString(b.j.app_shared));
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        AppMethodBeat.o(98392);
        return;
      }
      finally
      {
        com.tencent.mm.sdk.platformtools.Log.e("AntiCheatingReportUtils", localObject1.toString());
        continue;
      }
      if (paramInt1 == 202)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "handleOpenInBrowserResult, ret=".concat(String.valueOf(((ab)com.tencent.mm.kernel.h.ax(ab.class)).a(this, paramInt1, paramInt2, paramIntent))));
      }
      else
      {
        int i;
        if (paramInt1 == 2002)
        {
          if (com.tencent.mm.plugin.sns.ad.j.h.getBooleanExtra(paramIntent, "kfavorite", false))
          {
            i = AdLandingPagesProxy.getInstance().doFav(paramIntent, 42);
            ((com.tencent.mm.plugin.fav.a.w)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fav.a.w.class)).a(i, 42, this, this.IvJ);
          }
        }
        else
        {
          Object localObject6;
          int j;
          int k;
          if (paramInt1 == 2004)
          {
            try
            {
              Object localObject2 = paramIntent.getStringExtra("KComponentCid");
              localObject5 = getAllComp().iterator();
              do
              {
                if (!((Iterator)localObject5).hasNext()) {
                  break;
                }
                localObject6 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n)((Iterator)localObject5).next();
              } while (!((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n)localObject6).QOV.QKG.equals(localObject2));
              localObject2 = (aj)localObject6;
              i = paramIntent.getIntExtra("KStreamVideoPlayCount", 0);
              j = paramIntent.getIntExtra("KStreamVideoPlayCompleteCount", 0);
              k = paramIntent.getIntExtra("KStreamVideoTotalPlayTimeInMs", 0);
              ((aj)localObject2).PWr = (i + ((aj)localObject2).PWr);
              ((aj)localObject2).PWs += j;
              ((aj)localObject2).PWt += k;
            }
            catch (Exception localException) {}
          }
          else
          {
            Object localObject3;
            if (paramInt1 == 2003)
            {
              localObject3 = new yc();
              ((yc)localObject3).ibC.bUl = 1;
              ((yc)localObject3).ibC.hPm = paramInt1;
              ((yc)localObject3).ibC.resultCode = paramInt2;
              ((yc)localObject3).ibC.hPn = paramIntent;
              ((yc)localObject3).publish();
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
                localObject3 = paramIntent.getStringExtra("KComponentCid");
                localObject6 = getAllComp().iterator();
                do
                {
                  if (!((Iterator)localObject6).hasNext()) {
                    break;
                  }
                  localObject5 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n)((Iterator)localObject6).next();
                } while (!((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n)localObject5).QOV.QKG.equals(localObject3));
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
                localObject6 = paramIntent.getStringExtra("KComponentFullVideoFloatBarReportInfo");
                l2 = paramIntent.getLongExtra("KComponentFullScreenStayTime", 0L);
                this.hTS += l2;
                com.tencent.mm.sdk.platformtools.Log.i("VideoFullScreenActivity", "videoType = " + i + ", cid = " + (String)localObject3 + ", currPosSec = " + j + ", bNoVoice = " + bool1 + ", isPlaying = " + bool2 + ", clickPlayControlCount = " + k + ", doubleClickCount = " + m + ", clickVoiceControlCount = " + n + ", playCompletedCount = " + i1 + ", playCount = " + i2 + ", playTimeInterval = " + l1 + ", floatBarReportInfo = " + (String)localObject6 + ", fullScreenStayTime = " + l2);
                if (i != 0) {
                  break label872;
                }
                ((aj)localObject5).a(j, bool1, bool2, k, m, n, i1, i2, l1, (String)localObject6, l2);
                continue;
              }
              finally
              {
                com.tencent.mm.sdk.platformtools.Log.e("VideoFullScreenActivity", localObject4.toString());
              }
              continue;
              label872:
              if (i == 1) {
                ((an)localObject5).a(j, bool1, bool2, k, m, n, i1, i2, l1, bool3, i3, (String)localObject6, l2);
              }
            }
          }
        }
      }
    }
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(308168);
    super.onAttachedToWindow();
    hnp();
    AppMethodBeat.o(308168);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(98386);
    com.tencent.mm.plugin.sns.ad.landingpage.a locala = this.Rma;
    if ((locala.plc != null) && (locala.plc.getVisibility() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.Rma.hideLoading();
      AppMethodBeat.o(98386);
      return;
    }
    if (this.QUm)
    {
      hnE();
      AppMethodBeat.o(98386);
      return;
    }
    dmJ();
    if (com.tencent.mm.plugin.sns.ad.i.a.ajx(this.source)) {
      hnW();
    }
    AppMethodBeat.o(98386);
  }
  
  /* Error */
  public void onCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc_w 3131
    //   3: invokestatic 275	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial 3133	com/tencent/mm/ui/MMActivity:onCreate	(Landroid/os/Bundle;)V
    //   11: ldc_w 1884
    //   14: ldc_w 3134
    //   17: invokestatic 1888	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: aload_0
    //   21: getfield 386	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlZ	Lcom/tencent/mm/plugin/sns/ad/landingpage/helper/a$c;
    //   24: invokestatic 2220	java/lang/System:currentTimeMillis	()J
    //   27: putfield 2266	com/tencent/mm/plugin/sns/ad/landingpage/helper/a$c:PTp	J
    //   30: aload_0
    //   31: new 983	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 3135	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI;)V
    //   39: putfield 979	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlX	Lcom/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a;
    //   42: aload_0
    //   43: new 3118	com/tencent/mm/plugin/sns/ad/landingpage/a
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 3136	com/tencent/mm/plugin/sns/ad/landingpage/a:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI;)V
    //   51: putfield 3116	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rma	Lcom/tencent/mm/plugin/sns/ad/landingpage/a;
    //   54: aload_0
    //   55: invokestatic 2220	java/lang/System:currentTimeMillis	()J
    //   58: putfield 2222	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:startTime	J
    //   61: aload_0
    //   62: invokestatic 2220	java/lang/System:currentTimeMillis	()J
    //   65: putfield 317	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:enterTime	J
    //   68: aload_0
    //   69: getfield 327	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rln	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n;
    //   72: aload_0
    //   73: getfield 317	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:enterTime	J
    //   76: putfield 3137	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n:enterTime	J
    //   79: aload_0
    //   80: invokestatic 3143	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ar:bs	(Landroid/app/Activity;)V
    //   83: aload_0
    //   84: invokestatic 3147	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ar:jR	(Landroid/content/Context;)[I
    //   87: astore 7
    //   89: aload_0
    //   90: aload 7
    //   92: iconst_0
    //   93: iaload
    //   94: putfield 841	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:sJv	I
    //   97: aload_0
    //   98: aload 7
    //   100: iconst_1
    //   101: iaload
    //   102: putfield 1647	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:pvg	I
    //   105: aload_0
    //   106: aload_1
    //   107: putfield 3149	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:savedInstanceState	Landroid/os/Bundle;
    //   110: aload_0
    //   111: getfield 3153	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:mController	Lcom/tencent/mm/ui/y;
    //   114: invokevirtual 3156	com/tencent/mm/ui/y:hideTitleView	()V
    //   117: aload_0
    //   118: aload_0
    //   119: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   122: ldc_w 1016
    //   125: iconst_0
    //   126: invokevirtual 1020	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   129: putfield 301	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:wAZ	I
    //   132: aload_0
    //   133: invokestatic 1026	com/tencent/mm/ui/aw:bx	(Landroid/content/Context;)Z
    //   136: ifeq +54 -> 190
    //   139: aload_0
    //   140: invokestatic 1030	com/tencent/mm/ui/aw:bw	(Landroid/content/Context;)I
    //   143: istore_2
    //   144: aload_0
    //   145: aload_0
    //   146: getfield 301	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:wAZ	I
    //   149: iload_2
    //   150: isub
    //   151: putfield 301	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:wAZ	I
    //   154: ldc_w 496
    //   157: new 648	java/lang/StringBuilder
    //   160: dup
    //   161: ldc_w 1034
    //   164: invokespecial 651	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   167: iload_2
    //   168: invokevirtual 1037	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   171: ldc_w 1039
    //   174: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_0
    //   178: getfield 301	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:wAZ	I
    //   181: invokevirtual 1037	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   184: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 503	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: aload_0
    //   191: aload_0
    //   192: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   195: ldc_w 1041
    //   198: iconst_0
    //   199: invokevirtual 1020	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   202: putfield 303	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:wBa	I
    //   205: aload_0
    //   206: aload_0
    //   207: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   210: ldc_w 1043
    //   213: iconst_0
    //   214: invokevirtual 1020	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   217: putfield 305	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:wBb	I
    //   220: aload_0
    //   221: aload_0
    //   222: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   225: ldc_w 1045
    //   228: iconst_0
    //   229: invokevirtual 1020	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   232: putfield 307	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:wBc	I
    //   235: aload_0
    //   236: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   239: ldc_w 3158
    //   242: lconst_0
    //   243: invokevirtual 3064	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   246: lstore_3
    //   247: aload_0
    //   248: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   251: ldc_w 3158
    //   254: lconst_0
    //   255: invokevirtual 3161	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   258: pop
    //   259: aload_0
    //   260: getfield 386	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlZ	Lcom/tencent/mm/plugin/sns/ad/landingpage/helper/a$c;
    //   263: lload_3
    //   264: putfield 2287	com/tencent/mm/plugin/sns/ad/landingpage/helper/a$c:mStartTime	J
    //   267: aload_0
    //   268: invokevirtual 3165	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getWindow	()Landroid/view/Window;
    //   271: sipush 128
    //   274: invokevirtual 3170	android/view/Window:addFlags	(I)V
    //   277: aload_0
    //   278: iconst_0
    //   279: putfield 359	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:isVisible	Z
    //   282: aload_0
    //   283: iconst_0
    //   284: putfield 361	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlP	Z
    //   287: aload_0
    //   288: iconst_0
    //   289: putfield 363	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlQ	Z
    //   292: aload_0
    //   293: iconst_0
    //   294: putfield 365	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlR	Z
    //   297: aload_0
    //   298: getfield 367	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlS	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   301: ifnull +14 -> 315
    //   304: aload_0
    //   305: getfield 367	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlS	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   308: aload_0
    //   309: getfield 428	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rmj	Ljava/lang/Runnable;
    //   312: invokevirtual 2023	com/tencent/mm/sdk/platformtools/MMHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   315: aload_0
    //   316: aload_0
    //   317: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   320: ldc_w 2405
    //   323: iconst_0
    //   324: invokevirtual 1020	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   327: putfield 646	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:source	I
    //   330: aload_0
    //   331: aload_0
    //   332: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   335: ldc_w 2407
    //   338: iconst_0
    //   339: invokevirtual 1020	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   342: putfield 1693	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:QLu	I
    //   345: aload_0
    //   346: getfield 386	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlZ	Lcom/tencent/mm/plugin/sns/ad/landingpage/helper/a$c;
    //   349: astore_1
    //   350: aload_0
    //   351: getfield 646	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:source	I
    //   354: istore_2
    //   355: aload_1
    //   356: iload_2
    //   357: putfield 2306	com/tencent/mm/plugin/sns/ad/landingpage/helper/a$c:xOq	I
    //   360: iload_2
    //   361: lookupswitch	default:+99->460, 1:+349->710, 2:+373->734, 3:+361->722, 4:+373->734, 5:+355->716, 13:+385->746, 16:+367->728, 27:+385->746, 28:+379->740, 29:+391->752, 33:+397->758
    //   461: dconst_0
    //   462: istore_2
    //   463: ldc2_w 3171
    //   466: iload_2
    //   467: i2l
    //   468: invokestatic 3178	com/tencent/mm/plugin/sns/ad/landingpage/helper/a:bg	(JJ)V
    //   471: ldc_w 496
    //   474: new 648	java/lang/StringBuilder
    //   477: dup
    //   478: ldc_w 3180
    //   481: invokespecial 651	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   484: aload_0
    //   485: getfield 646	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:source	I
    //   488: invokevirtual 1037	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   491: ldc_w 3182
    //   494: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: aload_0
    //   498: getfield 1693	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:QLu	I
    //   501: invokevirtual 1037	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   504: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: invokestatic 503	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   510: aload_0
    //   511: aload_0
    //   512: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   515: ldc_w 3184
    //   518: invokevirtual 747	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   521: putfield 1109	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlf	Ljava/lang/String;
    //   524: aload_0
    //   525: aload_0
    //   526: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   529: ldc_w 3186
    //   532: invokevirtual 747	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   535: putfield 381	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:QLB	Ljava/lang/String;
    //   538: aload_0
    //   539: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   542: ldc_w 3188
    //   545: invokevirtual 747	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   548: astore_1
    //   549: aload_0
    //   550: getfield 1109	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlf	Ljava/lang/String;
    //   553: invokestatic 633	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   556: ifeq +18 -> 574
    //   559: aload_1
    //   560: invokestatic 633	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   563: ifne +11 -> 574
    //   566: aload_0
    //   567: aload_1
    //   568: invokestatic 3191	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ar:aZD	(Ljava/lang/String;)Ljava/lang/String;
    //   571: putfield 1109	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlf	Ljava/lang/String;
    //   574: aload_0
    //   575: getfield 1109	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlf	Ljava/lang/String;
    //   578: invokestatic 633	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   581: ifeq +183 -> 764
    //   584: aload_0
    //   585: invokevirtual 2515	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:finish	()V
    //   588: aload_0
    //   589: invokevirtual 3192	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:initView	()V
    //   592: ldc_w 1884
    //   595: ldc_w 3194
    //   598: invokestatic 1888	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   601: invokestatic 556	com/tencent/mm/plugin/sns/model/AdLandingPagesProxy:getInstance	()Lcom/tencent/mm/plugin/sns/model/AdLandingPagesProxy;
    //   604: invokevirtual 3197	com/tencent/mm/plugin/sns/model/AdLandingPagesProxy:isConnected	()Z
    //   607: ifne +3277 -> 3884
    //   610: aload_0
    //   611: getfield 386	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlZ	Lcom/tencent/mm/plugin/sns/ad/landingpage/helper/a$c;
    //   614: invokestatic 2220	java/lang/System:currentTimeMillis	()J
    //   617: putfield 2293	com/tencent/mm/plugin/sns/ad/landingpage/helper/a$c:PTs	J
    //   620: ldc_w 496
    //   623: ldc_w 3199
    //   626: invokestatic 503	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   629: invokestatic 556	com/tencent/mm/plugin/sns/model/AdLandingPagesProxy:getInstance	()Lcom/tencent/mm/plugin/sns/model/AdLandingPagesProxy;
    //   632: new 68	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$31
    //   635: dup
    //   636: aload_0
    //   637: invokespecial 3200	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$31:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI;)V
    //   640: invokevirtual 3203	com/tencent/mm/plugin/sns/model/AdLandingPagesProxy:connect	(Ljava/lang/Runnable;)V
    //   643: aload_0
    //   644: getfield 425	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rmi	Lcom/tencent/mm/sdk/event/IListener;
    //   647: invokevirtual 1792	com/tencent/mm/sdk/event/IListener:alive	()V
    //   650: invokestatic 3207	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   653: aload_0
    //   654: getfield 444	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rmp	Landroid/content/BroadcastReceiver;
    //   657: new 1781	android/content/IntentFilter
    //   660: dup
    //   661: ldc_w 3209
    //   664: invokespecial 1784	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   667: invokevirtual 3213	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   670: pop
    //   671: aload_0
    //   672: getfield 386	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlZ	Lcom/tencent/mm/plugin/sns/ad/landingpage/helper/a$c;
    //   675: astore_1
    //   676: aload_1
    //   677: invokestatic 2220	java/lang/System:currentTimeMillis	()J
    //   680: putfield 2263	com/tencent/mm/plugin/sns/ad/landingpage/helper/a$c:PTq	J
    //   683: getstatic 1907	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
    //   686: new 3215	com/tencent/mm/plugin/sns/ad/landingpage/helper/a$c$1
    //   689: dup
    //   690: aload_1
    //   691: invokespecial 3218	com/tencent/mm/plugin/sns/ad/landingpage/helper/a$c$1:<init>	(Lcom/tencent/mm/plugin/sns/ad/landingpage/helper/a$c;)V
    //   694: invokeinterface 2332 2 0
    //   699: pop
    //   700: invokestatic 3221	com/tencent/mm/plugin/sns/ad/landingpage/helper/c:report	()V
    //   703: ldc_w 3131
    //   706: invokestatic 291	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   709: return
    //   710: bipush 6
    //   712: istore_2
    //   713: goto -250 -> 463
    //   716: bipush 7
    //   718: istore_2
    //   719: goto -256 -> 463
    //   722: bipush 8
    //   724: istore_2
    //   725: goto -262 -> 463
    //   728: bipush 9
    //   730: istore_2
    //   731: goto -268 -> 463
    //   734: bipush 10
    //   736: istore_2
    //   737: goto -274 -> 463
    //   740: bipush 11
    //   742: istore_2
    //   743: goto -280 -> 463
    //   746: bipush 12
    //   748: istore_2
    //   749: goto -286 -> 463
    //   752: bipush 13
    //   754: istore_2
    //   755: goto -292 -> 463
    //   758: bipush 16
    //   760: istore_2
    //   761: goto -298 -> 463
    //   764: aload_0
    //   765: aload_0
    //   766: getfield 1109	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlf	Ljava/lang/String;
    //   769: ldc_w 3223
    //   772: ldc_w 369
    //   775: invokevirtual 1280	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   778: putfield 1109	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlf	Ljava/lang/String;
    //   781: aload_0
    //   782: getfield 327	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rln	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n;
    //   785: aload_0
    //   786: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   789: ldc_w 3225
    //   792: invokevirtual 747	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   795: putfield 3228	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n:QBF	Ljava/lang/String;
    //   798: aload_0
    //   799: aload_0
    //   800: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   803: ldc_w 3230
    //   806: invokevirtual 747	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   809: putfield 1142	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlg	Ljava/lang/String;
    //   812: aload_0
    //   813: aload_0
    //   814: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   817: ldc_w 3232
    //   820: invokevirtual 747	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   823: putfield 653	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:hQX	Ljava/lang/String;
    //   826: aload_0
    //   827: aload_0
    //   828: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   831: ldc_w 1337
    //   834: invokevirtual 747	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   837: putfield 1138	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:QLy	Ljava/lang/String;
    //   840: aload_0
    //   841: aload_0
    //   842: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   845: ldc_w 3234
    //   848: invokevirtual 747	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   851: putfield 518	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:uxInfo	Ljava/lang/String;
    //   854: aload_0
    //   855: aload_0
    //   856: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   859: ldc_w 3236
    //   862: invokevirtual 747	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   865: putfield 1117	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:aid	Ljava/lang/String;
    //   868: aload_0
    //   869: aload_0
    //   870: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   873: ldc_w 3238
    //   876: invokevirtual 747	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   879: putfield 1122	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:qTb	Ljava/lang/String;
    //   882: aload_0
    //   883: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   886: ldc_w 2432
    //   889: invokevirtual 747	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   892: astore_1
    //   893: aload_0
    //   894: getfield 327	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rln	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n;
    //   897: astore 7
    //   899: aload_1
    //   900: invokestatic 780	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   903: ifne +79 -> 982
    //   906: aload 7
    //   908: getfield 3241	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n:extra	Ljava/lang/String;
    //   911: invokevirtual 592	java/lang/String:length	()I
    //   914: ifle +32 -> 946
    //   917: aload 7
    //   919: new 648	java/lang/StringBuilder
    //   922: dup
    //   923: invokespecial 1157	java/lang/StringBuilder:<init>	()V
    //   926: aload 7
    //   928: getfield 3241	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n:extra	Ljava/lang/String;
    //   931: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: ldc_w 3243
    //   937: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   940: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   943: putfield 3241	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n:extra	Ljava/lang/String;
    //   946: aload 7
    //   948: new 648	java/lang/StringBuilder
    //   951: dup
    //   952: invokespecial 1157	java/lang/StringBuilder:<init>	()V
    //   955: aload 7
    //   957: getfield 3241	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n:extra	Ljava/lang/String;
    //   960: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   963: ldc_w 3245
    //   966: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   969: aload_1
    //   970: invokestatic 3250	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   973: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   979: putfield 3241	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n:extra	Ljava/lang/String;
    //   982: aload_0
    //   983: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   986: ldc_w 3252
    //   989: invokevirtual 747	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   992: astore_1
    //   993: ldc_w 496
    //   996: ldc_w 3254
    //   999: aload_1
    //   1000: invokestatic 546	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1003: invokevirtual 550	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1006: invokestatic 503	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1009: aload_0
    //   1010: getfield 327	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rln	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n;
    //   1013: astore 7
    //   1015: aload_1
    //   1016: invokestatic 780	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1019: ifne +73 -> 1092
    //   1022: aload 7
    //   1024: getfield 3241	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n:extra	Ljava/lang/String;
    //   1027: invokevirtual 592	java/lang/String:length	()I
    //   1030: ifle +32 -> 1062
    //   1033: aload 7
    //   1035: new 648	java/lang/StringBuilder
    //   1038: dup
    //   1039: invokespecial 1157	java/lang/StringBuilder:<init>	()V
    //   1042: aload 7
    //   1044: getfield 3241	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n:extra	Ljava/lang/String;
    //   1047: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: ldc_w 3243
    //   1053: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1056: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1059: putfield 3241	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n:extra	Ljava/lang/String;
    //   1062: aload 7
    //   1064: new 648	java/lang/StringBuilder
    //   1067: dup
    //   1068: invokespecial 1157	java/lang/StringBuilder:<init>	()V
    //   1071: aload 7
    //   1073: getfield 3241	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n:extra	Ljava/lang/String;
    //   1076: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1079: aload_1
    //   1080: invokestatic 3250	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   1083: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1086: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1089: putfield 3241	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n:extra	Ljava/lang/String;
    //   1092: aload_0
    //   1093: aload_0
    //   1094: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   1097: ldc_w 3256
    //   1100: iconst_0
    //   1101: invokevirtual 3047	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1104: putfield 313	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlm	Z
    //   1107: aload_0
    //   1108: aload_0
    //   1109: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   1112: ldc_w 3258
    //   1115: iconst_0
    //   1116: invokevirtual 1020	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1119: putfield 1674	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:recSrc	I
    //   1122: aload_0
    //   1123: aload_0
    //   1124: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   1127: ldc_w 3260
    //   1130: iconst_0
    //   1131: invokevirtual 1020	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1134: putfield 333	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlq	I
    //   1137: aload_0
    //   1138: aload_0
    //   1139: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   1142: ldc_w 3262
    //   1145: invokevirtual 747	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1148: putfield 1227	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:rzz	Ljava/lang/String;
    //   1151: aload_0
    //   1152: aload_0
    //   1153: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   1156: ldc_w 2413
    //   1159: iconst_0
    //   1160: invokevirtual 3047	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1163: putfield 309	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rld	Z
    //   1166: aload_0
    //   1167: aload_0
    //   1168: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   1171: ldc_w 3264
    //   1174: iconst_0
    //   1175: invokevirtual 3047	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1178: putfield 311	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rle	Z
    //   1181: aload_0
    //   1182: aload_0
    //   1183: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   1186: ldc_w 3266
    //   1189: iconst_0
    //   1190: invokevirtual 3047	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1193: putfield 534	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlY	Z
    //   1196: aload_0
    //   1197: aload_0
    //   1198: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   1201: ldc_w 3268
    //   1204: lconst_0
    //   1205: invokevirtual 3064	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   1208: putfield 2598	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:QLA	J
    //   1211: aload_0
    //   1212: getfield 327	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rln	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n;
    //   1215: aload_0
    //   1216: getfield 646	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:source	I
    //   1219: putfield 1686	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n:xYX	I
    //   1222: aload_0
    //   1223: getfield 327	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rln	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n;
    //   1226: iconst_0
    //   1227: putfield 3271	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n:QXL	I
    //   1230: aload_0
    //   1231: getfield 327	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rln	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n;
    //   1234: iconst_0
    //   1235: putfield 3274	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n:QXM	I
    //   1238: aload_0
    //   1239: getfield 327	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rln	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n;
    //   1242: iconst_1
    //   1243: putfield 3277	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n:QXN	I
    //   1246: aload_0
    //   1247: getfield 327	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rln	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n;
    //   1250: iconst_0
    //   1251: putfield 3280	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n:QXO	I
    //   1254: aload_0
    //   1255: getfield 327	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rln	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n;
    //   1258: aload_0
    //   1259: getfield 1693	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:QLu	I
    //   1262: putfield 3281	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n:QLu	I
    //   1265: aload_0
    //   1266: getfield 1142	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlg	Ljava/lang/String;
    //   1269: ifnull +16 -> 1285
    //   1272: ldc_w 369
    //   1275: aload_0
    //   1276: getfield 1109	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlf	Ljava/lang/String;
    //   1279: invokevirtual 2998	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1282: ifeq +10 -> 1292
    //   1285: aload_0
    //   1286: ldc_w 3283
    //   1289: putfield 1142	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlg	Ljava/lang/String;
    //   1292: aload_0
    //   1293: getfield 1109	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlf	Ljava/lang/String;
    //   1296: invokestatic 633	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1299: ifne +13 -> 1312
    //   1302: aload_0
    //   1303: getfield 1142	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlg	Ljava/lang/String;
    //   1306: invokestatic 633	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1309: ifeq +45 -> 1354
    //   1312: ldc_w 496
    //   1315: new 648	java/lang/StringBuilder
    //   1318: dup
    //   1319: ldc_w 3285
    //   1322: invokespecial 651	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1325: aload_0
    //   1326: getfield 1109	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlf	Ljava/lang/String;
    //   1329: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1332: ldc_w 3287
    //   1335: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1338: aload_0
    //   1339: getfield 1142	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlg	Ljava/lang/String;
    //   1342: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1345: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1348: invokestatic 597	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1351: goto -763 -> 588
    //   1354: aload_0
    //   1355: getfield 534	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlY	Z
    //   1358: ifne +21 -> 1379
    //   1361: aload_0
    //   1362: getfield 1109	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlf	Ljava/lang/String;
    //   1365: ldc_w 526
    //   1368: invokevirtual 532	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1371: ifeq +8 -> 1379
    //   1374: aload_0
    //   1375: iconst_1
    //   1376: putfield 534	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlY	Z
    //   1379: aload_0
    //   1380: aload_0
    //   1381: getfield 1109	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlf	Ljava/lang/String;
    //   1384: aload_0
    //   1385: getfield 1142	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlg	Ljava/lang/String;
    //   1388: aconst_null
    //   1389: invokestatic 1199	com/tencent/mm/sdk/platformtools/XmlParser:parseXml	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   1392: putfield 1105	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:values	Ljava/util/Map;
    //   1395: aload_0
    //   1396: getfield 1105	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:values	Ljava/util/Map;
    //   1399: ifnull +922 -> 2321
    //   1402: aload_0
    //   1403: getfield 327	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rln	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n;
    //   1406: aload_0
    //   1407: getfield 1105	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:values	Ljava/util/Map;
    //   1410: new 648	java/lang/StringBuilder
    //   1413: dup
    //   1414: ldc_w 1140
    //   1417: invokespecial 651	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1420: aload_0
    //   1421: getfield 1142	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlg	Ljava/lang/String;
    //   1424: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1427: ldc_w 3289
    //   1430: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1433: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1436: invokeinterface 1211 2 0
    //   1441: checkcast 528	java/lang/String
    //   1444: ldc_w 369
    //   1447: invokestatic 1214	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1450: putfield 574	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n:rzx	Ljava/lang/String;
    //   1453: aload_0
    //   1454: aload_0
    //   1455: getfield 1105	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:values	Ljava/util/Map;
    //   1458: new 648	java/lang/StringBuilder
    //   1461: dup
    //   1462: ldc_w 1140
    //   1465: invokespecial 651	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1468: aload_0
    //   1469: getfield 1142	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlg	Ljava/lang/String;
    //   1472: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1475: ldc_w 3291
    //   1478: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1481: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1484: invokeinterface 1211 2 0
    //   1489: checkcast 528	java/lang/String
    //   1492: ldc_w 369
    //   1495: invokestatic 1214	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1498: putfield 371	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlT	Ljava/lang/String;
    //   1501: aload_0
    //   1502: aload_0
    //   1503: getfield 371	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlT	Ljava/lang/String;
    //   1506: invokestatic 3296	com/tencent/mm/plugin/sns/data/k:aXd	(Ljava/lang/String;)Ljava/lang/String;
    //   1509: putfield 373	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:adExtInfo	Ljava/lang/String;
    //   1512: aload_0
    //   1513: getfield 1105	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:values	Ljava/util/Map;
    //   1516: new 648	java/lang/StringBuilder
    //   1519: dup
    //   1520: ldc_w 1140
    //   1523: invokespecial 651	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1526: aload_0
    //   1527: getfield 1142	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlg	Ljava/lang/String;
    //   1530: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1533: ldc_w 3298
    //   1536: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1539: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1542: invokeinterface 1211 2 0
    //   1547: checkcast 528	java/lang/String
    //   1550: invokestatic 1225	com/tencent/mm/sdk/platformtools/Util:safeParseInt	(Ljava/lang/String;)I
    //   1553: iconst_1
    //   1554: if_icmpne +749 -> 2303
    //   1557: iconst_1
    //   1558: istore 5
    //   1560: aload_0
    //   1561: iload 5
    //   1563: putfield 375	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlW	Z
    //   1566: aload_0
    //   1567: getfield 1105	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:values	Ljava/util/Map;
    //   1570: new 648	java/lang/StringBuilder
    //   1573: dup
    //   1574: ldc_w 1140
    //   1577: invokespecial 651	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1580: aload_0
    //   1581: getfield 1142	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlg	Ljava/lang/String;
    //   1584: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1587: ldc_w 3300
    //   1590: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1593: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1596: invokeinterface 1211 2 0
    //   1601: checkcast 528	java/lang/String
    //   1604: invokestatic 1225	com/tencent/mm/sdk/platformtools/Util:safeParseInt	(Ljava/lang/String;)I
    //   1607: iconst_1
    //   1608: if_icmpne +701 -> 2309
    //   1611: iconst_1
    //   1612: istore 5
    //   1614: aload_0
    //   1615: iload 5
    //   1617: putfield 377	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:forbiddenCustomAnimation	Z
    //   1620: new 648	java/lang/StringBuilder
    //   1623: dup
    //   1624: ldc_w 1140
    //   1627: invokespecial 651	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1630: aload_0
    //   1631: getfield 1142	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlg	Ljava/lang/String;
    //   1634: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1637: ldc_w 3302
    //   1640: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1643: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1646: astore_1
    //   1647: aload_0
    //   1648: getfield 1105	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:values	Ljava/util/Map;
    //   1651: aload_1
    //   1652: invokeinterface 1211 2 0
    //   1657: checkcast 528	java/lang/String
    //   1660: invokestatic 1225	com/tencent/mm/sdk/platformtools/Util:safeParseInt	(Ljava/lang/String;)I
    //   1663: iconst_1
    //   1664: if_icmpne +651 -> 2315
    //   1667: iconst_1
    //   1668: istore 5
    //   1670: ldc_w 496
    //   1673: new 648	java/lang/StringBuilder
    //   1676: dup
    //   1677: ldc_w 3304
    //   1680: invokespecial 651	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1683: iload 5
    //   1685: invokevirtual 1465	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1688: ldc_w 3306
    //   1691: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1694: aload_0
    //   1695: getfield 313	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlm	Z
    //   1698: invokevirtual 1465	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1701: ldc_w 1946
    //   1704: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1707: aload_0
    //   1708: getfield 646	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:source	I
    //   1711: invokevirtual 1037	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1714: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1717: invokestatic 503	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1720: iload 5
    //   1722: ifeq +8 -> 1730
    //   1725: aload_0
    //   1726: iconst_1
    //   1727: putfield 313	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlm	Z
    //   1730: aload_0
    //   1731: getfield 979	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlX	Lcom/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a;
    //   1734: astore 9
    //   1736: aload 9
    //   1738: aload 9
    //   1740: getfield 1014	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTA	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI;
    //   1743: getstatic 2896	com/tencent/mm/plugin/sns/b$f:gallery_bg	I
    //   1746: invokevirtual 2853	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:findViewById	(I)Landroid/view/View;
    //   1749: putfield 1010	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTQ	Landroid/view/View;
    //   1752: aload 9
    //   1754: aload 9
    //   1756: getfield 1014	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTA	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI;
    //   1759: getstatic 2899	com/tencent/mm/plugin/sns/b$f:anim_bg	I
    //   1762: invokevirtual 2853	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:findViewById	(I)Landroid/view/View;
    //   1765: putfield 1050	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTP	Landroid/view/View;
    //   1768: aload 9
    //   1770: aload 9
    //   1772: getfield 1014	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTA	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI;
    //   1775: getstatic 2856	com/tencent/mm/plugin/sns/b$f:content_container	I
    //   1778: invokevirtual 2853	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:findViewById	(I)Landroid/view/View;
    //   1781: putfield 997	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTR	Landroid/view/View;
    //   1784: aload 9
    //   1786: aload 9
    //   1788: getfield 1014	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTA	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI;
    //   1791: getstatic 2862	com/tencent/mm/plugin/sns/b$f:menu_container	I
    //   1794: invokevirtual 2853	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:findViewById	(I)Landroid/view/View;
    //   1797: putfield 1003	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTS	Landroid/view/View;
    //   1800: aload 9
    //   1802: invokestatic 3309	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:haQ	()Z
    //   1805: putfield 3312	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTT	Z
    //   1808: aload 9
    //   1810: aload 9
    //   1812: getfield 1014	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTA	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI;
    //   1815: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   1818: ldc_w 3314
    //   1821: invokevirtual 747	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1824: putfield 3317	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTH	Ljava/lang/String;
    //   1827: aload 9
    //   1829: getfield 1014	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTA	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI;
    //   1832: invokevirtual 784	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:hjn	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai;
    //   1835: getfield 2559	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai:source	I
    //   1838: istore_2
    //   1839: aload 9
    //   1841: iload_2
    //   1842: putfield 3318	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:xOq	I
    //   1845: aload 9
    //   1847: getfield 1014	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTA	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI;
    //   1850: getfield 1105	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:values	Ljava/util/Map;
    //   1853: astore 11
    //   1855: aload 9
    //   1857: getfield 1014	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTA	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI;
    //   1860: getfield 1142	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlg	Ljava/lang/String;
    //   1863: astore 12
    //   1865: aload 9
    //   1867: getfield 1014	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTA	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI;
    //   1870: getfield 1109	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlf	Ljava/lang/String;
    //   1873: astore 10
    //   1875: aload 11
    //   1877: ifnull +108 -> 1985
    //   1880: aload 9
    //   1882: aload 11
    //   1884: ldc_w 1140
    //   1887: aload 12
    //   1889: invokestatic 546	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1892: invokevirtual 550	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1895: getstatic 3321	com/tencent/mm/plugin/sns/ad/adxml/d:PMo	I
    //   1898: invokestatic 3324	com/tencent/mm/plugin/sns/ad/adxml/d:b	(Ljava/util/Map;Ljava/lang/String;I)Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   1901: putfield 1054	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTU	Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   1904: iload_2
    //   1905: iconst_5
    //   1906: if_icmpne +79 -> 1985
    //   1909: new 648	java/lang/StringBuilder
    //   1912: dup
    //   1913: ldc_w 1140
    //   1916: invokespecial 651	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1919: aload 12
    //   1921: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1924: ldc_w 3326
    //   1927: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1930: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1933: astore_1
    //   1934: aload 11
    //   1936: ifnull +20 -> 1956
    //   1939: aload 11
    //   1941: invokeinterface 3327 1 0
    //   1946: ifeq +10 -> 1956
    //   1949: aload_1
    //   1950: invokestatic 780	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1953: ifeq +380 -> 2333
    //   1956: aconst_null
    //   1957: astore_1
    //   1958: aload 9
    //   1960: aload_1
    //   1961: putfield 3331	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTY	Lcom/tencent/mm/plugin/sns/ad/d/a/c;
    //   1964: aload 9
    //   1966: getfield 3331	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTY	Lcom/tencent/mm/plugin/sns/ad/d/a/c;
    //   1969: ifnull +16 -> 1985
    //   1972: aload 9
    //   1974: aload 9
    //   1976: getfield 3331	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTY	Lcom/tencent/mm/plugin/sns/ad/d/a/c;
    //   1979: getfield 3336	com/tencent/mm/plugin/sns/ad/d/a/c:PPh	Ljava/lang/String;
    //   1982: putfield 3317	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTH	Ljava/lang/String;
    //   1985: aload 9
    //   1987: getfield 1054	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTU	Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   1990: ifnull +820 -> 2810
    //   1993: aload 9
    //   1995: aload 9
    //   1997: getfield 1014	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTA	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI;
    //   2000: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   2003: ldc_w 3266
    //   2006: iconst_0
    //   2007: invokevirtual 3047	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   2010: putfield 3339	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTV	Z
    //   2013: aload 9
    //   2015: getfield 1014	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTA	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI;
    //   2018: getfield 534	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlY	Z
    //   2021: ifne +54 -> 2075
    //   2024: aload 9
    //   2026: getfield 3318	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:xOq	I
    //   2029: istore_2
    //   2030: iload_2
    //   2031: bipush 26
    //   2033: if_icmplt +9 -> 2042
    //   2036: iload_2
    //   2037: bipush 33
    //   2039: if_icmple +30 -> 2069
    //   2042: iload_2
    //   2043: bipush 13
    //   2045: if_icmpeq +24 -> 2069
    //   2048: iload_2
    //   2049: iconst_5
    //   2050: if_icmpeq +19 -> 2069
    //   2053: iload_2
    //   2054: iconst_3
    //   2055: if_icmpeq +14 -> 2069
    //   2058: iload_2
    //   2059: iconst_4
    //   2060: if_icmpeq +9 -> 2069
    //   2063: iload_2
    //   2064: bipush 7
    //   2066: if_icmpne +545 -> 2611
    //   2069: iconst_1
    //   2070: istore_2
    //   2071: iload_2
    //   2072: ifeq +544 -> 2616
    //   2075: iconst_1
    //   2076: istore 5
    //   2078: aload 9
    //   2080: iload 5
    //   2082: putfield 3342	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTW	Z
    //   2085: aload 9
    //   2087: getfield 3339	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTV	Z
    //   2090: ifne +532 -> 2622
    //   2093: iconst_1
    //   2094: istore 5
    //   2096: aload 9
    //   2098: iload 5
    //   2100: putfield 3345	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTX	Z
    //   2103: aload 9
    //   2105: getfield 1054	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTU	Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   2108: getfield 3348	com/tencent/mm/plugin/sns/ad/adxml/d:oQU	I
    //   2111: tableswitch	default:+33 -> 2144, 1:+517->2628, 2:+545->2656, 3:+573->2684, 4:+601->2712, 5:+638->2749
    //   2145: lconst_0
    //   2146: getfield 3351	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTD	Z
    //   2149: ifeq +1602 -> 3751
    //   2152: aload 9
    //   2154: getfield 3312	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTT	Z
    //   2157: ifne +1524 -> 3681
    //   2160: aload 9
    //   2162: getfield 3355	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTB	Lcom/tencent/mm/plugin/sns/ad/widget/twistad/TwistRoateCardsView;
    //   2165: ifnonnull +34 -> 2199
    //   2168: aload 9
    //   2170: getfield 1014	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTA	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI;
    //   2173: getstatic 3358	com/tencent/mm/plugin/sns/b$f:twist_card_layout_stub	I
    //   2176: invokevirtual 2853	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:findViewById	(I)Landroid/view/View;
    //   2179: checkcast 3360	android/view/ViewStub
    //   2182: astore_1
    //   2183: aload_1
    //   2184: ifnull +15 -> 2199
    //   2187: aload 9
    //   2189: aload_1
    //   2190: invokevirtual 3363	android/view/ViewStub:inflate	()Landroid/view/View;
    //   2193: checkcast 3365	com/tencent/mm/plugin/sns/ad/widget/twistad/TwistRoateCardsView
    //   2196: putfield 3355	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTB	Lcom/tencent/mm/plugin/sns/ad/widget/twistad/TwistRoateCardsView;
    //   2199: aload_0
    //   2200: getfield 377	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:forbiddenCustomAnimation	Z
    //   2203: ifeq +13 -> 2216
    //   2206: aload_0
    //   2207: iconst_0
    //   2208: putfield 309	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rld	Z
    //   2211: aload_0
    //   2212: iconst_0
    //   2213: putfield 311	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rle	Z
    //   2216: aload_0
    //   2217: getfield 309	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rld	Z
    //   2220: ifeq +1639 -> 3859
    //   2223: aload_0
    //   2224: getfield 327	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rln	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n;
    //   2227: iconst_0
    //   2228: putfield 1683	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n:miZ	I
    //   2231: aload_0
    //   2232: getfield 327	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rln	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n;
    //   2235: iconst_0
    //   2236: putfield 3368	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n:lsO	I
    //   2239: aload_0
    //   2240: getfield 1105	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:values	Ljava/util/Map;
    //   2243: ifnull -1655 -> 588
    //   2246: aload_0
    //   2247: getfield 1105	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:values	Ljava/util/Map;
    //   2250: new 648	java/lang/StringBuilder
    //   2253: dup
    //   2254: ldc_w 1140
    //   2257: invokespecial 651	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2260: aload_0
    //   2261: getfield 1142	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlg	Ljava/lang/String;
    //   2264: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2267: ldc_w 3370
    //   2270: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2273: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2276: invokeinterface 1211 2 0
    //   2281: checkcast 528	java/lang/String
    //   2284: invokestatic 1225	com/tencent/mm/sdk/platformtools/Util:safeParseInt	(Ljava/lang/String;)I
    //   2287: iconst_1
    //   2288: if_icmpne +1590 -> 3878
    //   2291: iconst_1
    //   2292: istore 5
    //   2294: aload_0
    //   2295: iload 5
    //   2297: putfield 379	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:preloadWeAppPkg	Z
    //   2300: goto -1712 -> 588
    //   2303: iconst_0
    //   2304: istore 5
    //   2306: goto -746 -> 1560
    //   2309: iconst_0
    //   2310: istore 5
    //   2312: goto -698 -> 1614
    //   2315: iconst_0
    //   2316: istore 5
    //   2318: goto -648 -> 1670
    //   2321: ldc_w 496
    //   2324: ldc_w 3372
    //   2327: invokestatic 597	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2330: goto -600 -> 1730
    //   2333: new 648	java/lang/StringBuilder
    //   2336: dup
    //   2337: invokespecial 1157	java/lang/StringBuilder:<init>	()V
    //   2340: aload_1
    //   2341: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2344: ldc_w 3374
    //   2347: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2350: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2353: astore 7
    //   2355: aload 11
    //   2357: aload 7
    //   2359: invokeinterface 1207 2 0
    //   2364: ifne +8 -> 2372
    //   2367: aconst_null
    //   2368: astore_1
    //   2369: goto -411 -> 1958
    //   2372: new 3333	com/tencent/mm/plugin/sns/ad/d/a/c
    //   2375: dup
    //   2376: invokespecial 3375	com/tencent/mm/plugin/sns/ad/d/a/c:<init>	()V
    //   2379: astore_1
    //   2380: aload_1
    //   2381: aload 11
    //   2383: new 648	java/lang/StringBuilder
    //   2386: dup
    //   2387: invokespecial 1157	java/lang/StringBuilder:<init>	()V
    //   2390: aload 7
    //   2392: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2395: ldc_w 3377
    //   2398: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2401: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2404: invokeinterface 1211 2 0
    //   2409: checkcast 528	java/lang/String
    //   2412: invokestatic 571	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   2415: putfield 3336	com/tencent/mm/plugin/sns/ad/d/a/c:PPh	Ljava/lang/String;
    //   2418: aload_1
    //   2419: aload 11
    //   2421: new 648	java/lang/StringBuilder
    //   2424: dup
    //   2425: invokespecial 1157	java/lang/StringBuilder:<init>	()V
    //   2428: aload 7
    //   2430: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2433: ldc_w 3379
    //   2436: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2439: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2442: invokeinterface 1211 2 0
    //   2447: checkcast 528	java/lang/String
    //   2450: invokestatic 571	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   2453: putfield 3382	com/tencent/mm/plugin/sns/ad/d/a/c:POQ	Ljava/lang/String;
    //   2456: aload_1
    //   2457: aload 11
    //   2459: new 648	java/lang/StringBuilder
    //   2462: dup
    //   2463: invokespecial 1157	java/lang/StringBuilder:<init>	()V
    //   2466: aload 7
    //   2468: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2471: ldc_w 3384
    //   2474: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2477: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2480: invokeinterface 1211 2 0
    //   2485: checkcast 528	java/lang/String
    //   2488: invokestatic 571	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   2491: putfield 3387	com/tencent/mm/plugin/sns/ad/d/a/c:PPi	Ljava/lang/String;
    //   2494: aload_1
    //   2495: aload 11
    //   2497: new 648	java/lang/StringBuilder
    //   2500: dup
    //   2501: invokespecial 1157	java/lang/StringBuilder:<init>	()V
    //   2504: aload 7
    //   2506: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2509: ldc_w 3389
    //   2512: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2515: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2518: invokeinterface 1211 2 0
    //   2523: checkcast 528	java/lang/String
    //   2526: invokestatic 571	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   2529: putfield 3392	com/tencent/mm/plugin/sns/ad/d/a/c:JfB	Ljava/lang/String;
    //   2532: aload_1
    //   2533: aload 11
    //   2535: new 648	java/lang/StringBuilder
    //   2538: dup
    //   2539: invokespecial 1157	java/lang/StringBuilder:<init>	()V
    //   2542: aload 7
    //   2544: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2547: ldc_w 3394
    //   2550: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2553: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2556: invokeinterface 1211 2 0
    //   2561: checkcast 528	java/lang/String
    //   2564: invokestatic 1225	com/tencent/mm/sdk/platformtools/Util:safeParseInt	(Ljava/lang/String;)I
    //   2567: putfield 3397	com/tencent/mm/plugin/sns/ad/d/a/c:PPj	I
    //   2570: aload_1
    //   2571: aload 11
    //   2573: new 648	java/lang/StringBuilder
    //   2576: dup
    //   2577: invokespecial 1157	java/lang/StringBuilder:<init>	()V
    //   2580: aload 7
    //   2582: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2585: ldc_w 3399
    //   2588: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2591: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2594: invokeinterface 1211 2 0
    //   2599: checkcast 528	java/lang/String
    //   2602: invokestatic 1286	com/tencent/mm/sdk/platformtools/Util:safeParseLong	(Ljava/lang/String;)J
    //   2605: putfield 3402	com/tencent/mm/plugin/sns/ad/d/a/c:PPk	J
    //   2608: goto -650 -> 1958
    //   2611: iconst_0
    //   2612: istore_2
    //   2613: goto -542 -> 2071
    //   2616: iconst_0
    //   2617: istore 5
    //   2619: goto -541 -> 2078
    //   2622: iconst_0
    //   2623: istore 5
    //   2625: goto -529 -> 2096
    //   2628: aload 9
    //   2630: getfield 3342	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTW	Z
    //   2633: ifeq -489 -> 2144
    //   2636: aload 9
    //   2638: getfield 1054	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTU	Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   2641: getfield 3406	com/tencent/mm/plugin/sns/ad/adxml/d:PMi	Lcom/tencent/mm/plugin/sns/ad/adxml/d$e;
    //   2644: ifnull -500 -> 2144
    //   2647: aload 9
    //   2649: iconst_1
    //   2650: putfield 3351	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTD	Z
    //   2653: goto -509 -> 2144
    //   2656: aload 9
    //   2658: getfield 3339	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTV	Z
    //   2661: ifeq -517 -> 2144
    //   2664: aload 9
    //   2666: getfield 1054	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTU	Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   2669: getfield 1060	com/tencent/mm/plugin/sns/ad/adxml/d:PMj	Lcom/tencent/mm/plugin/sns/ad/adxml/d$d;
    //   2672: ifnull -528 -> 2144
    //   2675: aload 9
    //   2677: iconst_1
    //   2678: putfield 986	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTE	Z
    //   2681: goto -537 -> 2144
    //   2684: aload 9
    //   2686: getfield 3342	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTW	Z
    //   2689: ifeq -545 -> 2144
    //   2692: aload 9
    //   2694: getfield 1054	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTU	Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   2697: getfield 3410	com/tencent/mm/plugin/sns/ad/adxml/d:PMk	Lcom/tencent/mm/plugin/sns/ad/adxml/d$a;
    //   2700: ifnull -556 -> 2144
    //   2703: aload 9
    //   2705: iconst_1
    //   2706: putfield 3413	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTK	Z
    //   2709: goto -565 -> 2144
    //   2712: aload 9
    //   2714: getfield 3342	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTW	Z
    //   2717: ifeq -573 -> 2144
    //   2720: aload 9
    //   2722: getfield 1054	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTU	Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   2725: getfield 3417	com/tencent/mm/plugin/sns/ad/adxml/d:PMl	Lcom/tencent/mm/plugin/sns/ad/adxml/d$b;
    //   2728: ifnull -584 -> 2144
    //   2731: aload 9
    //   2733: iconst_1
    //   2734: putfield 1901	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTL	Z
    //   2737: aload 9
    //   2739: getfield 1014	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTA	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI;
    //   2742: iconst_1
    //   2743: putfield 309	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rld	Z
    //   2746: goto -602 -> 2144
    //   2749: aload 9
    //   2751: getfield 3342	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTW	Z
    //   2754: ifeq -610 -> 2144
    //   2757: aload 9
    //   2759: getfield 3339	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTV	Z
    //   2762: ifeq -618 -> 2144
    //   2765: aload 9
    //   2767: getfield 1054	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTU	Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   2770: getfield 3421	com/tencent/mm/plugin/sns/ad/adxml/d:PMm	Lcom/tencent/mm/plugin/sns/ad/adxml/d$c;
    //   2773: ifnull -629 -> 2144
    //   2776: aload 9
    //   2778: iconst_1
    //   2779: putfield 1933	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTN	Z
    //   2782: aload 9
    //   2784: aload 9
    //   2786: getfield 1054	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTU	Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   2789: getfield 3421	com/tencent/mm/plugin/sns/ad/adxml/d:PMm	Lcom/tencent/mm/plugin/sns/ad/adxml/d$c;
    //   2792: getfield 3426	com/tencent/mm/plugin/sns/ad/adxml/d$c:PMx	Ljava/lang/String;
    //   2795: invokevirtual 3429	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:aWC	(Ljava/lang/String;)Z
    //   2798: ifne -654 -> 2144
    //   2801: aload 9
    //   2803: iconst_0
    //   2804: putfield 1933	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTN	Z
    //   2807: goto -663 -> 2144
    //   2810: aconst_null
    //   2811: astore 7
    //   2813: aconst_null
    //   2814: astore 8
    //   2816: aconst_null
    //   2817: astore_1
    //   2818: aload 11
    //   2820: ifnull +95 -> 2915
    //   2823: aload 11
    //   2825: new 648	java/lang/StringBuilder
    //   2828: dup
    //   2829: ldc_w 1140
    //   2832: invokespecial 651	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2835: aload 12
    //   2837: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2840: ldc_w 3431
    //   2843: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2846: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2849: invokestatic 3437	com/tencent/mm/plugin/sns/storage/ADXml$k:am	(Ljava/util/Map;Ljava/lang/String;)Lcom/tencent/mm/plugin/sns/storage/ADXml$k;
    //   2852: astore 7
    //   2854: aload 11
    //   2856: new 648	java/lang/StringBuilder
    //   2859: dup
    //   2860: ldc_w 1140
    //   2863: invokespecial 651	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2866: aload 12
    //   2868: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2871: ldc_w 3439
    //   2874: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2877: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2880: invokestatic 3445	com/tencent/mm/plugin/sns/ad/widget/shakead/a:ad	(Ljava/util/Map;Ljava/lang/String;)Lcom/tencent/mm/plugin/sns/ad/widget/shakead/a;
    //   2883: astore 8
    //   2885: aload 11
    //   2887: new 648	java/lang/StringBuilder
    //   2890: dup
    //   2891: ldc_w 1140
    //   2894: invokespecial 651	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2897: aload 12
    //   2899: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2902: ldc_w 3447
    //   2905: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2908: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2911: invokestatic 3453	com/tencent/mm/plugin/sns/storage/ADXml$p:ao	(Ljava/util/Map;Ljava/lang/String;)Lcom/tencent/mm/plugin/sns/storage/ADXml$p;
    //   2914: astore_1
    //   2915: aload 10
    //   2917: invokestatic 3456	com/tencent/mm/plugin/sns/storage/ADXml:isTwistAdCanvas	(Ljava/lang/String;)Z
    //   2920: istore 5
    //   2922: aload 9
    //   2924: getfield 1014	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTA	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI;
    //   2927: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   2930: ldc_w 3458
    //   2933: iconst_0
    //   2934: invokevirtual 3047	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   2937: istore 6
    //   2939: aload 7
    //   2941: ifnull +245 -> 3186
    //   2944: iload 5
    //   2946: ifeq +166 -> 3112
    //   2949: iload 6
    //   2951: ifeq +139 -> 3090
    //   2954: aload 9
    //   2956: iconst_1
    //   2957: putfield 3351	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTD	Z
    //   2960: aload 9
    //   2962: iconst_0
    //   2963: putfield 3345	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTX	Z
    //   2966: aload 9
    //   2968: new 1056	com/tencent/mm/plugin/sns/ad/adxml/d
    //   2971: dup
    //   2972: invokespecial 3459	com/tencent/mm/plugin/sns/ad/adxml/d:<init>	()V
    //   2975: putfield 1054	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTU	Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   2978: aload 9
    //   2980: getfield 1054	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTU	Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   2983: iconst_1
    //   2984: putfield 3348	com/tencent/mm/plugin/sns/ad/adxml/d:oQU	I
    //   2987: aload 9
    //   2989: getfield 1054	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTU	Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   2992: new 3461	com/tencent/mm/plugin/sns/ad/adxml/d$e
    //   2995: dup
    //   2996: invokespecial 3462	com/tencent/mm/plugin/sns/ad/adxml/d$e:<init>	()V
    //   2999: putfield 3406	com/tencent/mm/plugin/sns/ad/adxml/d:PMi	Lcom/tencent/mm/plugin/sns/ad/adxml/d$e;
    //   3002: aload 9
    //   3004: getfield 1054	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTU	Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   3007: getfield 3406	com/tencent/mm/plugin/sns/ad/adxml/d:PMi	Lcom/tencent/mm/plugin/sns/ad/adxml/d$e;
    //   3010: aload 7
    //   3012: getfield 3465	com/tencent/mm/plugin/sns/storage/ADXml$k:QIc	Z
    //   3015: putfield 3466	com/tencent/mm/plugin/sns/ad/adxml/d$e:isClockwise	Z
    //   3018: ldc_w 1032
    //   3021: new 648	java/lang/StringBuilder
    //   3024: dup
    //   3025: ldc_w 3468
    //   3028: invokespecial 651	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3031: aload 9
    //   3033: getfield 3345	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTX	Z
    //   3036: invokevirtual 1465	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3039: ldc_w 3470
    //   3042: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3045: aload 9
    //   3047: getfield 3351	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTD	Z
    //   3050: invokevirtual 1465	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3053: ldc_w 3472
    //   3056: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3059: aload 9
    //   3061: getfield 3317	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTH	Ljava/lang/String;
    //   3064: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3067: ldc_w 3474
    //   3070: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3073: aload 9
    //   3075: getfield 986	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTE	Z
    //   3078: invokevirtual 1465	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3081: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3084: invokestatic 503	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3087: goto -943 -> 2144
    //   3090: iload_2
    //   3091: invokestatic 3476	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:alV	(I)Z
    //   3094: ifne -128 -> 2966
    //   3097: aload 9
    //   3099: iconst_1
    //   3100: putfield 3351	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTD	Z
    //   3103: aload 9
    //   3105: iconst_1
    //   3106: putfield 3345	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTX	Z
    //   3109: goto -143 -> 2966
    //   3112: iload 6
    //   3114: ifeq -96 -> 3018
    //   3117: aload 7
    //   3119: getfield 3479	com/tencent/mm/plugin/sns/storage/ADXml$k:QId	Z
    //   3122: ifeq -104 -> 3018
    //   3125: aload 9
    //   3127: iconst_1
    //   3128: putfield 986	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTE	Z
    //   3131: aload 9
    //   3133: new 1056	com/tencent/mm/plugin/sns/ad/adxml/d
    //   3136: dup
    //   3137: invokespecial 3459	com/tencent/mm/plugin/sns/ad/adxml/d:<init>	()V
    //   3140: putfield 1054	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTU	Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   3143: aload 9
    //   3145: getfield 1054	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTU	Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   3148: iconst_2
    //   3149: putfield 3348	com/tencent/mm/plugin/sns/ad/adxml/d:oQU	I
    //   3152: aload 9
    //   3154: getfield 1054	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTU	Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   3157: new 1062	com/tencent/mm/plugin/sns/ad/adxml/d$d
    //   3160: dup
    //   3161: invokespecial 3480	com/tencent/mm/plugin/sns/ad/adxml/d$d:<init>	()V
    //   3164: putfield 1060	com/tencent/mm/plugin/sns/ad/adxml/d:PMj	Lcom/tencent/mm/plugin/sns/ad/adxml/d$d;
    //   3167: aload 9
    //   3169: getfield 1054	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTU	Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   3172: getfield 1060	com/tencent/mm/plugin/sns/ad/adxml/d:PMj	Lcom/tencent/mm/plugin/sns/ad/adxml/d$d;
    //   3175: aload 7
    //   3177: getfield 3465	com/tencent/mm/plugin/sns/storage/ADXml$k:QIc	Z
    //   3180: putfield 1065	com/tencent/mm/plugin/sns/ad/adxml/d$d:isClockwise	Z
    //   3183: goto -165 -> 3018
    //   3186: aload 8
    //   3188: ifnull +306 -> 3494
    //   3191: aload 10
    //   3193: invokestatic 3483	com/tencent/mm/plugin/sns/storage/ADXml:isShakeAdCanvas	(Ljava/lang/String;)Z
    //   3196: istore 5
    //   3198: aload 9
    //   3200: getfield 1014	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTA	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI;
    //   3203: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   3206: ldc_w 3485
    //   3209: iconst_0
    //   3210: invokevirtual 3047	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   3213: istore 6
    //   3215: iload 5
    //   3217: ifeq +135 -> 3352
    //   3220: iload 6
    //   3222: ifeq +108 -> 3330
    //   3225: aload 9
    //   3227: iconst_1
    //   3228: putfield 3413	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTK	Z
    //   3231: aload 9
    //   3233: iconst_0
    //   3234: putfield 3345	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTX	Z
    //   3237: aload 9
    //   3239: new 1056	com/tencent/mm/plugin/sns/ad/adxml/d
    //   3242: dup
    //   3243: invokespecial 3459	com/tencent/mm/plugin/sns/ad/adxml/d:<init>	()V
    //   3246: putfield 1054	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTU	Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   3249: aload 9
    //   3251: getfield 1054	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTU	Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   3254: iconst_3
    //   3255: putfield 3348	com/tencent/mm/plugin/sns/ad/adxml/d:oQU	I
    //   3258: ldc_w 1032
    //   3261: new 648	java/lang/StringBuilder
    //   3264: dup
    //   3265: ldc_w 3468
    //   3268: invokespecial 651	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3271: aload 9
    //   3273: getfield 3345	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTX	Z
    //   3276: invokevirtual 1465	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3279: ldc_w 3487
    //   3282: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3285: aload 9
    //   3287: getfield 3413	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTK	Z
    //   3290: invokevirtual 1465	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3293: ldc_w 3489
    //   3296: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3299: aload 9
    //   3301: getfield 3317	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTH	Ljava/lang/String;
    //   3304: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3307: ldc_w 3491
    //   3310: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3313: aload 9
    //   3315: getfield 1901	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTL	Z
    //   3318: invokevirtual 1465	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3321: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3324: invokestatic 503	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3327: goto -1183 -> 2144
    //   3330: iload_2
    //   3331: invokestatic 3476	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:alV	(I)Z
    //   3334: ifne -97 -> 3237
    //   3337: aload 9
    //   3339: iconst_1
    //   3340: putfield 3413	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTK	Z
    //   3343: aload 9
    //   3345: iconst_1
    //   3346: putfield 3345	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTX	Z
    //   3349: goto -112 -> 3237
    //   3352: iload 6
    //   3354: ifne +10 -> 3364
    //   3357: iload_2
    //   3358: invokestatic 1452	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:alU	(I)Z
    //   3361: ifeq -103 -> 3258
    //   3364: aload 9
    //   3366: getfield 1014	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTA	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI;
    //   3369: getfield 534	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlY	Z
    //   3372: ifeq -114 -> 3258
    //   3375: aload 8
    //   3377: getfield 3494	com/tencent/mm/plugin/sns/ad/widget/shakead/a:QhY	Ljava/lang/String;
    //   3380: invokestatic 780	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3383: ifne +106 -> 3489
    //   3386: aload 8
    //   3388: getfield 3497	com/tencent/mm/plugin/sns/ad/widget/shakead/a:QhZ	Ljava/lang/String;
    //   3391: invokestatic 780	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3394: ifne +95 -> 3489
    //   3397: iconst_1
    //   3398: istore_2
    //   3399: iload_2
    //   3400: ifeq -142 -> 3258
    //   3403: aload 9
    //   3405: iconst_1
    //   3406: putfield 1901	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTL	Z
    //   3409: aload 9
    //   3411: getfield 1014	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTA	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI;
    //   3414: iconst_1
    //   3415: putfield 309	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rld	Z
    //   3418: aload 9
    //   3420: new 1056	com/tencent/mm/plugin/sns/ad/adxml/d
    //   3423: dup
    //   3424: invokespecial 3459	com/tencent/mm/plugin/sns/ad/adxml/d:<init>	()V
    //   3427: putfield 1054	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTU	Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   3430: aload 9
    //   3432: getfield 1054	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTU	Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   3435: iconst_4
    //   3436: putfield 3348	com/tencent/mm/plugin/sns/ad/adxml/d:oQU	I
    //   3439: aload 9
    //   3441: getfield 1054	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTU	Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   3444: new 3499	com/tencent/mm/plugin/sns/ad/adxml/d$b
    //   3447: dup
    //   3448: invokespecial 3500	com/tencent/mm/plugin/sns/ad/adxml/d$b:<init>	()V
    //   3451: putfield 3417	com/tencent/mm/plugin/sns/ad/adxml/d:PMl	Lcom/tencent/mm/plugin/sns/ad/adxml/d$b;
    //   3454: aload 9
    //   3456: getfield 1054	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTU	Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   3459: getfield 3417	com/tencent/mm/plugin/sns/ad/adxml/d:PMl	Lcom/tencent/mm/plugin/sns/ad/adxml/d$b;
    //   3462: aload 8
    //   3464: getfield 3494	com/tencent/mm/plugin/sns/ad/widget/shakead/a:QhY	Ljava/lang/String;
    //   3467: putfield 3503	com/tencent/mm/plugin/sns/ad/adxml/d$b:PMs	Ljava/lang/String;
    //   3470: aload 9
    //   3472: getfield 1054	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTU	Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   3475: getfield 3417	com/tencent/mm/plugin/sns/ad/adxml/d:PMl	Lcom/tencent/mm/plugin/sns/ad/adxml/d$b;
    //   3478: aload 8
    //   3480: getfield 3497	com/tencent/mm/plugin/sns/ad/widget/shakead/a:QhZ	Ljava/lang/String;
    //   3483: putfield 3506	com/tencent/mm/plugin/sns/ad/adxml/d$b:PMt	Ljava/lang/String;
    //   3486: goto -228 -> 3258
    //   3489: iconst_0
    //   3490: istore_2
    //   3491: goto -92 -> 3399
    //   3494: aload_1
    //   3495: ifnull -1351 -> 2144
    //   3498: aload 9
    //   3500: aload 9
    //   3502: getfield 1014	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTA	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI;
    //   3505: invokevirtual 704	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getIntent	()Landroid/content/Intent;
    //   3508: ldc_w 3508
    //   3511: iconst_0
    //   3512: invokevirtual 3047	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   3515: putfield 1933	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTN	Z
    //   3518: aload 9
    //   3520: getfield 1933	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTN	Z
    //   3523: ifeq -1379 -> 2144
    //   3526: aload 9
    //   3528: aload_1
    //   3529: getfield 3509	com/tencent/mm/plugin/sns/storage/ADXml$p:PMx	Ljava/lang/String;
    //   3532: invokevirtual 3429	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:aWC	(Ljava/lang/String;)Z
    //   3535: ifne +9 -> 3544
    //   3538: aload 9
    //   3540: iconst_0
    //   3541: putfield 1933	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTN	Z
    //   3544: aload 9
    //   3546: getfield 1933	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTN	Z
    //   3549: ifeq -1405 -> 2144
    //   3552: aload 9
    //   3554: new 1056	com/tencent/mm/plugin/sns/ad/adxml/d
    //   3557: dup
    //   3558: invokespecial 3459	com/tencent/mm/plugin/sns/ad/adxml/d:<init>	()V
    //   3561: putfield 1054	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTU	Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   3564: aload 9
    //   3566: getfield 1054	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTU	Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   3569: iconst_5
    //   3570: putfield 3348	com/tencent/mm/plugin/sns/ad/adxml/d:oQU	I
    //   3573: aload 9
    //   3575: getfield 1054	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTU	Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   3578: new 3423	com/tencent/mm/plugin/sns/ad/adxml/d$c
    //   3581: dup
    //   3582: invokespecial 3510	com/tencent/mm/plugin/sns/ad/adxml/d$c:<init>	()V
    //   3585: putfield 3421	com/tencent/mm/plugin/sns/ad/adxml/d:PMm	Lcom/tencent/mm/plugin/sns/ad/adxml/d$c;
    //   3588: aload 9
    //   3590: getfield 1054	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTU	Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   3593: getfield 3421	com/tencent/mm/plugin/sns/ad/adxml/d:PMm	Lcom/tencent/mm/plugin/sns/ad/adxml/d$c;
    //   3596: aload_1
    //   3597: getfield 3513	com/tencent/mm/plugin/sns/storage/ADXml$p:PMu	I
    //   3600: putfield 3514	com/tencent/mm/plugin/sns/ad/adxml/d$c:PMu	I
    //   3603: aload 9
    //   3605: getfield 1054	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTU	Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   3608: getfield 3421	com/tencent/mm/plugin/sns/ad/adxml/d:PMm	Lcom/tencent/mm/plugin/sns/ad/adxml/d$c;
    //   3611: aload_1
    //   3612: getfield 3517	com/tencent/mm/plugin/sns/storage/ADXml$p:PMw	I
    //   3615: putfield 3518	com/tencent/mm/plugin/sns/ad/adxml/d$c:PMw	I
    //   3618: aload 9
    //   3620: getfield 1054	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTU	Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   3623: getfield 3421	com/tencent/mm/plugin/sns/ad/adxml/d:PMm	Lcom/tencent/mm/plugin/sns/ad/adxml/d$c;
    //   3626: aload_1
    //   3627: getfield 3509	com/tencent/mm/plugin/sns/storage/ADXml$p:PMx	Ljava/lang/String;
    //   3630: putfield 3426	com/tencent/mm/plugin/sns/ad/adxml/d$c:PMx	Ljava/lang/String;
    //   3633: aload 9
    //   3635: getfield 1054	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTU	Lcom/tencent/mm/plugin/sns/ad/adxml/d;
    //   3638: getfield 3421	com/tencent/mm/plugin/sns/ad/adxml/d:PMm	Lcom/tencent/mm/plugin/sns/ad/adxml/d$c;
    //   3641: aload_1
    //   3642: getfield 3521	com/tencent/mm/plugin/sns/storage/ADXml$p:PMv	I
    //   3645: putfield 3522	com/tencent/mm/plugin/sns/ad/adxml/d$c:PMv	I
    //   3648: goto -1504 -> 2144
    //   3651: astore_1
    //   3652: ldc_w 1032
    //   3655: new 648	java/lang/StringBuilder
    //   3658: dup
    //   3659: ldc_w 3524
    //   3662: invokespecial 651	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3665: aload_1
    //   3666: invokevirtual 835	java/lang/Throwable:toString	()Ljava/lang/String;
    //   3669: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3672: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3675: invokestatic 597	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   3678: goto -1479 -> 2199
    //   3681: aload 9
    //   3683: getfield 3528	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTC	Lcom/tencent/mm/plugin/sns/ad/widget/twistad/GLTwistRoateCardsView;
    //   3686: ifnonnull -1487 -> 2199
    //   3689: aload 9
    //   3691: new 3530	com/tencent/mm/plugin/sns/ad/widget/twistad/GLTwistRoateCardsView
    //   3694: dup
    //   3695: aload 9
    //   3697: getfield 1014	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTA	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI;
    //   3700: invokespecial 3531	com/tencent/mm/plugin/sns/ad/widget/twistad/GLTwistRoateCardsView:<init>	(Landroid/content/Context;)V
    //   3703: putfield 3528	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTC	Lcom/tencent/mm/plugin/sns/ad/widget/twistad/GLTwistRoateCardsView;
    //   3706: aload 9
    //   3708: getfield 1014	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTA	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI;
    //   3711: getstatic 2850	com/tencent/mm/plugin/sns/b$f:root	I
    //   3714: invokevirtual 2853	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:findViewById	(I)Landroid/view/View;
    //   3717: checkcast 1752	android/widget/FrameLayout
    //   3720: aload 9
    //   3722: getfield 3528	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTC	Lcom/tencent/mm/plugin/sns/ad/widget/twistad/GLTwistRoateCardsView;
    //   3725: new 2111	android/widget/FrameLayout$LayoutParams
    //   3728: dup
    //   3729: iconst_m1
    //   3730: iconst_m1
    //   3731: invokespecial 3532	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   3734: invokevirtual 3533	android/widget/FrameLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   3737: getstatic 828	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   3740: sipush 1572
    //   3743: bipush 17
    //   3745: invokevirtual 3536	com/tencent/mm/plugin/report/service/h:kJ	(II)V
    //   3748: goto -1549 -> 2199
    //   3751: aload 9
    //   3753: getfield 3413	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTK	Z
    //   3756: ifeq +11 -> 3767
    //   3759: aload 9
    //   3761: invokevirtual 3539	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:haP	()V
    //   3764: goto -1565 -> 2199
    //   3767: aload 9
    //   3769: getfield 1933	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTN	Z
    //   3772: ifeq -1573 -> 2199
    //   3775: ldc_w 1032
    //   3778: ldc_w 3541
    //   3781: invokestatic 503	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3784: aload 9
    //   3786: getfield 3545	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTM	Lcom/tencent/mm/plugin/sns/ui/widget/SnsAdSphereAnimView;
    //   3789: ifnonnull -1590 -> 2199
    //   3792: aload 9
    //   3794: aload 9
    //   3796: getfield 1014	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTA	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI;
    //   3799: getstatic 3548	com/tencent/mm/plugin/sns/b$f:longpress_anim_layout_stub	I
    //   3802: invokevirtual 2853	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:findViewById	(I)Landroid/view/View;
    //   3805: checkcast 3360	android/view/ViewStub
    //   3808: invokevirtual 3363	android/view/ViewStub:inflate	()Landroid/view/View;
    //   3811: checkcast 3550	com/tencent/mm/plugin/sns/ui/widget/SnsAdSphereAnimView
    //   3814: putfield 3545	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTM	Lcom/tencent/mm/plugin/sns/ui/widget/SnsAdSphereAnimView;
    //   3817: aload 9
    //   3819: getfield 3545	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTM	Lcom/tencent/mm/plugin/sns/ui/widget/SnsAdSphereAnimView;
    //   3822: iconst_0
    //   3823: invokevirtual 3551	com/tencent/mm/plugin/sns/ui/widget/SnsAdSphereAnimView:setVisibility	(I)V
    //   3826: goto -1627 -> 2199
    //   3829: astore_1
    //   3830: ldc_w 1032
    //   3833: new 648	java/lang/StringBuilder
    //   3836: dup
    //   3837: ldc_w 3553
    //   3840: invokespecial 651	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3843: aload_1
    //   3844: invokevirtual 835	java/lang/Throwable:toString	()Ljava/lang/String;
    //   3847: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3850: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3853: invokestatic 597	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   3856: goto -1657 -> 2199
    //   3859: aload_0
    //   3860: getfield 327	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rln	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n;
    //   3863: iconst_1
    //   3864: putfield 1683	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n:miZ	I
    //   3867: aload_0
    //   3868: getfield 327	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rln	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n;
    //   3871: iconst_1
    //   3872: putfield 3368	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/n:lsO	I
    //   3875: goto -1636 -> 2239
    //   3878: iconst_0
    //   3879: istore 5
    //   3881: goto -1587 -> 2294
    //   3884: ldc_w 496
    //   3887: ldc_w 3555
    //   3890: invokestatic 503	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3893: aload_0
    //   3894: invokespecial 2365	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:hnr	()V
    //   3897: goto -3254 -> 643
    //   3900: astore_1
    //   3901: ldc_w 496
    //   3904: new 648	java/lang/StringBuilder
    //   3907: dup
    //   3908: ldc_w 3557
    //   3911: invokespecial 651	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3914: aload_1
    //   3915: invokevirtual 1981	java/lang/Exception:toString	()Ljava/lang/String;
    //   3918: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3921: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3924: invokestatic 597	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   3927: goto -3256 -> 671
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3930	0	this	SnsAdNativeLandingPagesUI
    //   0	3930	1	paramBundle	Bundle
    //   143	3348	2	i	int
    //   246	18	3	l	long
    //   1558	2322	5	bool1	boolean
    //   2937	416	6	bool2	boolean
    //   87	3089	7	localObject	Object
    //   2814	665	8	locala	com.tencent.mm.plugin.sns.ad.widget.shakead.a
    //   1734	2084	9	locala1	com.tencent.mm.plugin.sns.ad.landingpage.helper.anim.a
    //   1873	1319	10	str1	String
    //   1853	1033	11	localMap	Map
    //   1863	1035	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   2160	2183	3651	finally
    //   2187	2199	3651	finally
    //   3775	3826	3829	finally
    //   650	671	3900	java/lang/Exception
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: ldc_w 3559
    //   3: invokestatic 275	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 3165	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:getWindow	()Landroid/view/Window;
    //   10: sipush 128
    //   13: invokevirtual 3562	android/view/Window:clearFlags	(I)V
    //   16: aload_0
    //   17: getfield 367	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlS	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   20: ifnull +14 -> 34
    //   23: aload_0
    //   24: getfield 367	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlS	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   27: aload_0
    //   28: getfield 428	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rmj	Ljava/lang/Runnable;
    //   31: invokevirtual 2023	com/tencent/mm/sdk/platformtools/MMHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   34: aload_0
    //   35: getfield 900	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlK	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d;
    //   38: ifnull +10 -> 48
    //   41: aload_0
    //   42: getfield 900	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlK	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d;
    //   45: invokevirtual 3565	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:has	()V
    //   48: aload_0
    //   49: getfield 979	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlX	Lcom/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a;
    //   52: ifnull +54 -> 106
    //   55: aload_0
    //   56: getfield 979	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlX	Lcom/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a;
    //   59: astore_1
    //   60: ldc_w 1032
    //   63: ldc_w 3567
    //   66: invokestatic 503	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload_1
    //   70: getfield 3571	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PRJ	Landroid/os/Handler;
    //   73: aconst_null
    //   74: invokevirtual 3576	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   77: aload_1
    //   78: getfield 3577	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PUc	Lcom/tencent/mm/sdk/event/IListener;
    //   81: invokevirtual 3580	com/tencent/mm/sdk/event/IListener:dead	()V
    //   84: aload_1
    //   85: getfield 3584	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTG	Lcom/tencent/mm/plugin/sns/ad/landingpage/component/comp/b;
    //   88: iconst_0
    //   89: invokevirtual 3589	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/b:Dm	(Z)V
    //   92: aload_1
    //   93: getfield 3528	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTC	Lcom/tencent/mm/plugin/sns/ad/widget/twistad/GLTwistRoateCardsView;
    //   96: ifnull +10 -> 106
    //   99: aload_1
    //   100: getfield 3528	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PTC	Lcom/tencent/mm/plugin/sns/ad/widget/twistad/GLTwistRoateCardsView;
    //   103: invokevirtual 3591	com/tencent/mm/plugin/sns/ad/widget/twistad/GLTwistRoateCardsView:clear	()V
    //   106: aload_0
    //   107: getfield 346	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlI	Ljava/util/Map;
    //   110: invokeinterface 2201 1 0
    //   115: invokeinterface 1811 1 0
    //   120: astore_1
    //   121: aload_1
    //   122: invokeinterface 1720 1 0
    //   127: ifeq +56 -> 183
    //   130: aload_1
    //   131: invokeinterface 1723 1 0
    //   136: checkcast 1761	com/tencent/mm/plugin/sns/ui/widget/SnsAdLandingPageFloatView
    //   139: astore_2
    //   140: aload_2
    //   141: invokevirtual 3593	com/tencent/mm/plugin/sns/ui/widget/SnsAdLandingPageFloatView:onDestroy	()V
    //   144: aload_2
    //   145: bipush 8
    //   147: invokevirtual 2506	com/tencent/mm/plugin/sns/ui/widget/SnsAdLandingPageFloatView:setVisibility	(I)V
    //   150: goto -29 -> 121
    //   153: astore_1
    //   154: ldc_w 1032
    //   157: new 648	java/lang/StringBuilder
    //   160: dup
    //   161: ldc_w 3595
    //   164: invokespecial 651	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   167: aload_1
    //   168: invokevirtual 835	java/lang/Throwable:toString	()Ljava/lang/String;
    //   171: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 597	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: goto -74 -> 106
    //   183: aload_0
    //   184: getfield 344	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:uYV	Z
    //   187: ifeq +150 -> 337
    //   190: ldc_w 496
    //   193: new 648	java/lang/StringBuilder
    //   196: dup
    //   197: ldc_w 3597
    //   200: invokespecial 651	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   203: aload_0
    //   204: getfield 331	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlp	Z
    //   207: invokevirtual 1465	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   210: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 503	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: aload_0
    //   217: getfield 331	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlp	Z
    //   220: ifne +11 -> 231
    //   223: aload_0
    //   224: invokespecial 2522	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:hnx	()V
    //   227: aload_0
    //   228: invokespecial 2524	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:report	()V
    //   231: invokestatic 2630	com/tencent/mm/plugin/sns/ad/landingpage/helper/b/a:hbb	()Lcom/tencent/mm/plugin/sns/ad/landingpage/helper/b/a;
    //   234: astore_1
    //   235: aload_1
    //   236: getfield 3600	com/tencent/mm/plugin/sns/ad/landingpage/helper/b/a:PUC	Ljava/util/Map;
    //   239: invokeinterface 3601 1 0
    //   244: aload_1
    //   245: aconst_null
    //   246: putfield 3605	com/tencent/mm/plugin/sns/ad/landingpage/helper/b/a:PUE	Lcom/tencent/mm/plugin/mmsight/model/d;
    //   249: aload_0
    //   250: getfield 346	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlI	Ljava/util/Map;
    //   253: invokeinterface 3601 1 0
    //   258: aload_0
    //   259: getfield 954	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlw	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/AdlandingDummyViewPager;
    //   262: invokevirtual 1545	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/AdlandingDummyViewPager:getAdapter	()Landroidx/viewpager/widget/a;
    //   265: checkcast 1547	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/b
    //   268: astore_1
    //   269: aload_1
    //   270: ifnull +12 -> 282
    //   273: aload_1
    //   274: getfield 1711	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/b:fragments	Ljava/util/List;
    //   277: invokeinterface 3606 1 0
    //   282: invokestatic 3207	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   285: aload_0
    //   286: getfield 444	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rmp	Landroid/content/BroadcastReceiver;
    //   289: invokevirtual 3610	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   292: aload_0
    //   293: getfield 425	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rmi	Lcom/tencent/mm/sdk/event/IListener;
    //   296: invokevirtual 3580	com/tencent/mm/sdk/event/IListener:dead	()V
    //   299: new 3612	com/tencent/mm/autogen/a/xz
    //   302: dup
    //   303: invokespecial 3613	com/tencent/mm/autogen/a/xz:<init>	()V
    //   306: astore_1
    //   307: aload_1
    //   308: getfield 3617	com/tencent/mm/autogen/a/xz:ibt	Lcom/tencent/mm/autogen/a/xz$a;
    //   311: iconst_5
    //   312: putfield 3622	com/tencent/mm/autogen/a/xz$a:ibu	I
    //   315: aload_1
    //   316: invokevirtual 3623	com/tencent/mm/autogen/a/xz:publish	()Z
    //   319: pop
    //   320: invokestatic 556	com/tencent/mm/plugin/sns/model/AdLandingPagesProxy:getInstance	()Lcom/tencent/mm/plugin/sns/model/AdLandingPagesProxy;
    //   323: invokevirtual 3626	com/tencent/mm/plugin/sns/model/AdLandingPagesProxy:clearCallback	()V
    //   326: aload_0
    //   327: invokespecial 3627	com/tencent/mm/ui/MMActivity:onDestroy	()V
    //   330: ldc_w 3559
    //   333: invokestatic 291	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   336: return
    //   337: ldc_w 496
    //   340: ldc_w 3629
    //   343: invokestatic 597	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   346: goto -115 -> 231
    //   349: astore_1
    //   350: ldc_w 496
    //   353: new 648	java/lang/StringBuilder
    //   356: dup
    //   357: ldc_w 3631
    //   360: invokespecial 651	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   363: aload_1
    //   364: invokevirtual 1981	java/lang/Exception:toString	()Ljava/lang/String;
    //   367: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 660	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 597	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   376: goto -84 -> 292
    //   379: astore_1
    //   380: goto -60 -> 320
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	383	0	this	SnsAdNativeLandingPagesUI
    //   59	72	1	localObject1	Object
    //   153	15	1	localObject2	Object
    //   234	82	1	localObject3	Object
    //   349	15	1	localException	Exception
    //   379	1	1	localObject4	Object
    //   139	6	2	localSnsAdLandingPageFloatView	SnsAdLandingPageFloatView
    // Exception table:
    //   from	to	target	type
    //   60	106	153	finally
    //   282	292	349	java/lang/Exception
    //   299	320	379	finally
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(98393);
    super.onKeyboardStateChanged();
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "onKeyboardStateChanged, state=" + keyboardState());
    if (this.Rlw != null) {
      this.Rlw.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(308050);
          if (SnsAdNativeLandingPagesUI.this.keyboardState() != 1) {
            ar.bs(SnsAdNativeLandingPagesUI.this);
          }
          if (!SnsAdNativeLandingPagesUI.W(SnsAdNativeLandingPagesUI.this))
          {
            new ArrayList();
            Iterator localIterator = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getAdapter()).fragments.iterator();
            while (localIterator.hasNext())
            {
              ContentFragment localContentFragment = (ContentFragment)localIterator.next();
              SnsAdNativeLandingPagesUI.this.keyboardState();
              localContentFragment.hjX();
            }
          }
          AppMethodBeat.o(308050);
        }
      }, 500L);
    }
    AppMethodBeat.o(98393);
  }
  
  /* Error */
  public void onPause()
  {
    // Byte code:
    //   0: ldc_w 3645
    //   3: invokestatic 275	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 3646	com/tencent/mm/ui/MMActivity:onPause	()V
    //   10: ldc_w 496
    //   13: ldc_w 3647
    //   16: invokestatic 503	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_0
    //   20: iconst_1
    //   21: putfield 947	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlH	Z
    //   24: aload_0
    //   25: getfield 344	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:uYV	Z
    //   28: ifeq +20 -> 48
    //   31: aload_0
    //   32: aload_0
    //   33: getfield 315	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:hTS	J
    //   36: invokestatic 2220	java/lang/System:currentTimeMillis	()J
    //   39: aload_0
    //   40: getfield 2222	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:startTime	J
    //   43: lsub
    //   44: ladd
    //   45: putfield 315	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:hTS	J
    //   48: aload_0
    //   49: aconst_null
    //   50: invokestatic 3653	com/tencent/mm/sdk/platformtools/ScreenShotUtil:setScreenShotCallback	(Landroid/content/Context;Lcom/tencent/mm/sdk/platformtools/ScreenShotUtil$ScreenShotCallback;)V
    //   53: aload_0
    //   54: iconst_0
    //   55: putfield 329	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlo	Z
    //   58: aload_0
    //   59: invokespecial 3655	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:hnB	()Z
    //   62: ifeq +56 -> 118
    //   65: aload_0
    //   66: getfield 346	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlI	Ljava/util/Map;
    //   69: invokeinterface 2201 1 0
    //   74: invokeinterface 1811 1 0
    //   79: astore_1
    //   80: aload_1
    //   81: invokeinterface 1720 1 0
    //   86: ifeq +32 -> 118
    //   89: aload_1
    //   90: invokeinterface 1723 1 0
    //   95: checkcast 1761	com/tencent/mm/plugin/sns/ui/widget/SnsAdLandingPageFloatView
    //   98: invokevirtual 2505	com/tencent/mm/plugin/sns/ui/widget/SnsAdLandingPageFloatView:onPause	()V
    //   101: goto -21 -> 80
    //   104: astore_1
    //   105: ldc_w 809
    //   108: aload_1
    //   109: invokevirtual 835	java/lang/Throwable:toString	()Ljava/lang/String;
    //   112: invokestatic 597	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: goto -57 -> 58
    //   118: aload_0
    //   119: getfield 954	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rlw	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/AdlandingDummyViewPager;
    //   122: astore_1
    //   123: aload_0
    //   124: getfield 408	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rmg	Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;
    //   127: astore_2
    //   128: aload_1
    //   129: getfield 3659	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/AdlandingDummyViewPager:QTR	Ljava/util/Set;
    //   132: aload_2
    //   133: invokeinterface 3664 2 0
    //   138: pop
    //   139: aload_0
    //   140: getfield 838	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:QUm	Z
    //   143: ifne +14 -> 157
    //   146: aload_0
    //   147: invokestatic 1779	androidx/i/a/a:al	(Landroid/content/Context;)Landroidx/i/a/a;
    //   150: aload_0
    //   151: getfield 393	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rmb	Landroid/content/BroadcastReceiver;
    //   154: invokevirtual 3665	androidx/i/a/a:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   157: aload_0
    //   158: invokestatic 1779	androidx/i/a/a:al	(Landroid/content/Context;)Landroidx/i/a/a;
    //   161: aload_0
    //   162: getfield 396	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rmc	Landroid/content/BroadcastReceiver;
    //   165: invokevirtual 3665	androidx/i/a/a:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   168: aload_0
    //   169: getfield 838	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:QUm	Z
    //   172: ifne +10 -> 182
    //   175: aload_0
    //   176: getfield 422	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:PUc	Lcom/tencent/mm/sdk/event/IListener;
    //   179: invokevirtual 3580	com/tencent/mm/sdk/event/IListener:dead	()V
    //   182: aload_0
    //   183: getfield 446	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rmq	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/o;
    //   186: ifnull +10 -> 196
    //   189: aload_0
    //   190: getfield 446	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:Rmq	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/o;
    //   193: invokevirtual 2446	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/o:cyW	()V
    //   196: aload_0
    //   197: getfield 838	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:QUm	Z
    //   200: ifne +27 -> 227
    //   203: aload_0
    //   204: getfield 900	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlK	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d;
    //   207: ifnull +20 -> 227
    //   210: aload_0
    //   211: getfield 900	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlK	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d;
    //   214: invokevirtual 1795	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:isShowing	()Z
    //   217: ifeq +10 -> 227
    //   220: aload_0
    //   221: getfield 900	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlK	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d;
    //   224: invokevirtual 2010	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:hap	()V
    //   227: aload_0
    //   228: getfield 838	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:QUm	Z
    //   231: ifeq +39 -> 270
    //   234: aload_0
    //   235: getfield 2635	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:PQt	Lcom/tencent/mm/plugin/sns/ad/landingpage/component/view/AdLandingGeneralVideoWrapper;
    //   238: ifnull +32 -> 270
    //   241: aload_0
    //   242: getfield 2635	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:PQt	Lcom/tencent/mm/plugin/sns/ad/landingpage/component/view/AdLandingGeneralVideoWrapper;
    //   245: invokevirtual 3668	com/tencent/mm/plugin/sns/ad/landingpage/component/view/AdLandingGeneralVideoWrapper:haJ	()Z
    //   248: ifeq +22 -> 270
    //   251: aload_0
    //   252: getfield 2635	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:PQt	Lcom/tencent/mm/plugin/sns/ad/landingpage/component/view/AdLandingGeneralVideoWrapper;
    //   255: astore_1
    //   256: aload_1
    //   257: getfield 3672	com/tencent/mm/plugin/sns/ad/landingpage/component/view/AdLandingGeneralVideoWrapper:PSV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/g;
    //   260: ifnull +10 -> 270
    //   263: aload_1
    //   264: getfield 3672	com/tencent/mm/plugin/sns/ad/landingpage/component/view/AdLandingGeneralVideoWrapper:PSV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/g;
    //   267: invokevirtual 3675	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/g:hap	()V
    //   270: aload_0
    //   271: getfield 979	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlX	Lcom/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a;
    //   274: ifnull +13 -> 287
    //   277: aload_0
    //   278: getfield 979	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI:RlX	Lcom/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a;
    //   281: getfield 3577	com/tencent/mm/plugin/sns/ad/landingpage/helper/anim/a:PUc	Lcom/tencent/mm/sdk/event/IListener;
    //   284: invokevirtual 3580	com/tencent/mm/sdk/event/IListener:dead	()V
    //   287: ldc_w 3645
    //   290: invokestatic 291	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   293: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	this	SnsAdNativeLandingPagesUI
    //   79	11	1	localIterator	Iterator
    //   104	5	1	localObject1	Object
    //   122	142	1	localObject2	Object
    //   127	6	2	localOnPageChangeListener	ViewPager.OnPageChangeListener
    // Exception table:
    //   from	to	target	type
    //   48	58	104	finally
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98371);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "onResume");
    super.onResume();
    Object localObject1 = this.RlZ;
    if (((a.c)localObject1).PTr == 0L) {
      ((a.c)localObject1).PTr = System.currentTimeMillis();
    }
    if ((this.RlW) && (isSupportNavigationSwipeBack())) {
      getSwipeBackLayout().setEnableGesture(false);
    }
    try
    {
      if (!this.Rlo)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "onResume callback");
        ScreenShotUtil.setScreenShotCallback(this, this.Rmk);
        this.Rlo = true;
      }
      ar.bs(this);
      if (hnB())
      {
        i = this.RlA.getChildCount() - 1;
        if (i >= 0)
        {
          localObject1 = this.RlA.getChildAt(i);
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
    finally
    {
      for (;;)
      {
        int i;
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", localObject2.toString());
        continue;
        i -= 1;
        continue;
        localObject3 = null;
      }
      this.RlH = false;
      Object localObject3 = this.Rlw;
      ViewPager.OnPageChangeListener localOnPageChangeListener = this.Rmg;
      ((AdlandingDummyViewPager)localObject3).QTR.add(localOnPageChangeListener);
      if (!this.QUm) {
        androidx.i.a.a.al(this).a(this.Rmb, new IntentFilter("com.tencent.mm.adlanding.video_progressbar_change"));
      }
      androidx.i.a.a.al(this).a(this.Rmc, new IntentFilter("com.tencent.mm.adlanding.set_uioption"));
      if (this.uYV) {
        this.startTime = System.currentTimeMillis();
      }
      if (!this.QUm) {
        this.PUc.alive();
      }
      if (this.Rlr) {
        Ef(false);
      }
      if ((!this.QUm) && (this.RlK != null) && (this.RlK.isShowing())) {
        this.RlK.hao();
      }
      if ((this.QUm) && (this.PQt != null) && (this.PQt.haJ()))
      {
        localObject3 = this.PQt;
        if (((AdLandingGeneralVideoWrapper)localObject3).PSV != null) {
          ((AdLandingGeneralVideoWrapper)localObject3).PSV.hao();
        }
      }
      if (this.RlX != null)
      {
        localObject3 = this.RlX;
        if ((((com.tencent.mm.plugin.sns.ad.landingpage.helper.anim.a)localObject3).PTK) || (((com.tencent.mm.plugin.sns.ad.landingpage.helper.anim.a)localObject3).PTD)) {
          ((com.tencent.mm.plugin.sns.ad.landingpage.helper.anim.a)localObject3).PUc.alive();
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
    if (this.uYV) {
      try
      {
        if ((!Util.isNullOrNil(new String[] { this.viewId, this.QLz })) && (!this.RlQ))
        {
          if (this.RlR)
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "execute mValidExposure onStart immediately");
            hnA();
            AppMethodBeat.o(179183);
            return;
          }
          if (this.RlS != null)
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "execute mValidExposureRunnable onStart");
            this.RlS.removeCallbacks(this.Rmj);
            this.RlS.postDelayed(this.Rmj, 1000L);
          }
        }
        AppMethodBeat.o(179183);
        return;
      }
      finally
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI", localObject.toString());
      }
    }
    AppMethodBeat.o(179183);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(179184);
    super.onStop();
    this.isVisible = false;
    if (this.RlS != null) {
      this.RlS.removeCallbacks(this.Rmj);
    }
    AppMethodBeat.o(179184);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(98373);
    this.Rln.lsO = 2;
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.n localn = this.Rln;
    localn.QXO += 1;
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
    AppMethodBeat.i(308174);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean) {}
    try
    {
      ScreenShotUtil.setScreenShotCallback(this, null);
      this.Rlo = false;
      AppMethodBeat.o(308174);
      return;
    }
    finally
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", localObject.toString());
      AppMethodBeat.o(308174);
    }
    if (!this.Rlo)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "onWindowFocusChanged callback");
      ScreenShotUtil.setScreenShotCallback(this, this.Rmk);
      this.Rlo = true;
    }
    AppMethodBeat.o(308174);
    return;
  }
  
  public final void r(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(98402);
    if (this.RlK != null)
    {
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SnsAdNativeLandingPagesUI", "hideFloatBarView");
      this.RlK.q(paramBoolean, paramLong);
    }
    AppMethodBeat.o(98402);
  }
  
  public final void vb(long paramLong)
  {
    AppMethodBeat.i(98403);
    if ((this.RlK == null) || (this.Rla == null))
    {
      AppMethodBeat.o(98403);
      return;
    }
    if (this.RlK.QNy)
    {
      AppMethodBeat.o(98403);
      return;
    }
    ContentFragment localContentFragment = hnN();
    if (localContentFragment == null)
    {
      AppMethodBeat.o(98403);
      return;
    }
    boolean bool1 = hnV();
    boolean bool2 = localContentFragment.hjZ();
    boolean bool3 = this.RlM;
    boolean bool4 = localContentFragment.QUe;
    boolean bool5 = localContentFragment.pIS;
    boolean bool6 = localContentFragment.hjY();
    boolean bool7 = this.RlL;
    boolean bool8 = localContentFragment.hkg();
    boolean bool9 = localContentFragment.hkf();
    if ((bool4) && (bool8)) {
      this.RlN = true;
    }
    if (!bool4) {
      this.RlN = true;
    }
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SnsAdNativeLandingPagesUI", "toggleFloatBarView, isSourceAllow=" + bool1 + ", isForbid=" + bool2 + ", isKeybordShow=" + bool3 + ", isFirstPage=" + bool4 + ", isLastPage=" + bool5 + ", isCoverVideo=" + bool6 + ", isVideoCtrlBarShow=" + bool7 + ", isTopAppearOk=" + bool8 + ", isBottomAppearOk=" + bool9 + ", IsTopAppearChecked=" + this.RlN);
    if (!bool1)
    {
      r(false, 0L);
      AppMethodBeat.o(98403);
      return;
    }
    if (bool2)
    {
      r(true, 0L);
      AppMethodBeat.o(98403);
      return;
    }
    if (bool3)
    {
      r(false, 0L);
      AppMethodBeat.o(98403);
      return;
    }
    if ((bool6) && (bool7))
    {
      r(true, 200L);
      AppMethodBeat.o(98403);
      return;
    }
    if ((bool5) && (!bool9))
    {
      r(true, 0L);
      AppMethodBeat.o(98403);
      return;
    }
    if ((bool4) && (!bool8) && (!this.RlN))
    {
      AppMethodBeat.o(98403);
      return;
    }
    vq(paramLong);
    AppMethodBeat.o(98403);
  }
  
  final class a
  {
    public String ICb = "";
    public String QIh = "";
    public String svG = "";
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI
 * JD-Core Version:    0.7.0.1
 */