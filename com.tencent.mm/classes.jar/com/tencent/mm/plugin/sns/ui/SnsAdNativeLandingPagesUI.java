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
import com.tencent.mm.g.a.oi;
import com.tencent.mm.g.a.oi.a;
import com.tencent.mm.g.a.tz;
import com.tencent.mm.g.a.ud;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.model.AdlandingRemoteServiceConnectedReceiver;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ag;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdlandingDummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a;
import com.tencent.mm.plugin.sns.storage.b.k;
import com.tencent.mm.plugin.sns.storage.b.l;
import com.tencent.mm.plugin.sns.ui.helper.FloatWebViewHelper;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.dih;
import com.tencent.mm.protocal.protobuf.dii;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bh.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
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
  public static int zYt = 1000;
  public static int zYu = 1000;
  private boolean aMx;
  private String aQj;
  private int bizId;
  private long dBD;
  private String dFy;
  private int dnh;
  String dzb;
  private long enterTime;
  private ImageView gXw;
  private ImageView iUP;
  private volatile boolean isVisible;
  private String jSR;
  private String kto;
  private int ltA;
  private int ltB;
  private int oGp;
  private int oGq;
  private int oGr;
  private int oGs;
  String qeQ;
  String qeR;
  private long startTime;
  protected a.b tUH;
  String uaw;
  private String uin;
  private Map<String, String> values;
  private ImageView xAl;
  private com.tencent.mm.plugin.sns.storage.p yXF;
  private int zAN;
  private String zAP;
  private String zAR;
  private Map<String, String> zAS;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am zIO;
  public LinkedList<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g> zLR;
  private TextView zXA;
  Bundle zXB;
  private boolean zXC;
  private boolean zXD;
  private String zXE;
  private String zXF;
  private String zXG;
  private String zXH;
  private String zXI;
  private ImageView zXJ;
  String zXK;
  String zXL;
  private boolean zXM;
  com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k zXN;
  private volatile boolean zXO;
  boolean zXP;
  private int zXQ;
  private boolean zXR;
  private String zXS;
  private String zXT;
  private String zXU;
  private String zXV;
  private AdlandingDummyViewPager zXW;
  private int zXX;
  private int zXY;
  private ap zXZ;
  public ab zXy;
  private ImageView zXz;
  private com.tencent.mm.sdk.b.c<oi> zYA;
  private com.tencent.mm.sdk.b.c<tz> zYB;
  private Runnable zYC;
  private bh.a zYD;
  private Map<Integer, ContentFragment> zYE;
  public com.tencent.mm.ui.b.a zYF;
  private BroadcastReceiver zYG;
  private m zYH;
  private com.tencent.mm.ui.base.p zYI;
  private FrameLayout zYa;
  private View zYb;
  private View zYc;
  private boolean zYd;
  private List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l> zYe;
  private com.tencent.mm.plugin.sns.ui.b.c zYf;
  private com.tencent.mm.plugin.sns.ui.b.d zYg;
  private volatile boolean zYh;
  private boolean zYi;
  private Map<String, SnsAdLandingPageFloatView> zYj;
  private com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.a zYk;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d zYl;
  private boolean zYm;
  public boolean zYn;
  private boolean zYo;
  private volatile boolean zYp;
  private volatile boolean zYq;
  private volatile boolean zYr;
  private ap zYs;
  private BroadcastReceiver zYv;
  private BroadcastReceiver zYw;
  private ContentFragment.a zYx;
  private ViewPager.OnPageChangeListener zYy;
  private AdLandingPagesProxy.e zYz;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae ziT;
  private String zuP;
  private String zuQ;
  private int zvR;
  private int zvv;
  
  public SnsAdNativeLandingPagesUI()
  {
    AppMethodBeat.i(98362);
    this.zLR = new LinkedList();
    this.oGp = 0;
    this.oGq = 0;
    this.oGr = 0;
    this.oGs = 0;
    this.zXC = false;
    this.zXD = false;
    this.zXM = false;
    this.dBD = 0L;
    this.enterTime = 0L;
    this.zAS = new HashMap();
    this.zXN = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k();
    this.zXO = false;
    this.zXP = false;
    this.zXQ = 0;
    this.zXR = false;
    this.zXZ = new ap();
    this.zYd = true;
    this.aMx = false;
    this.zYj = new HashMap();
    this.zYm = false;
    this.zYn = false;
    this.zYo = false;
    this.isVisible = false;
    this.zYp = false;
    this.zYq = false;
    this.zYr = false;
    this.zYs = new ap();
    this.zYv = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        boolean bool = true;
        AppMethodBeat.i(98324);
        int i = com.tencent.mm.plugin.sns.ad.e.d.getIntExtra(paramAnonymousIntent, "show", 0);
        if ((SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this) == null) || (!(SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getAdapter() instanceof android.support.v4.app.i)))
        {
          ad.w("MicroMsg.SnsAdNativeLandingPagesUI", "videoProgressbarStatusChangeReceiver called ,but the viewpager or adapter is null!!");
          AppMethodBeat.o(98324);
          return;
        }
        paramAnonymousContext = (android.support.v4.app.i)SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getAdapter();
        int j = SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getCurrentItem();
        int k = paramAnonymousContext.getCount();
        if (j >= k)
        {
          ad.w("MicroMsg.SnsAdNativeLandingPagesUI", "videoProgressbarStatusChangeReceiver called ,current index is larger than item count!!!");
          AppMethodBeat.o(98324);
          return;
        }
        ad.d("MicroMsg.SnsAdNativeLandingPagesUI", "recv videoProgressbarStatusChangeReceiver show " + i + "the index is " + j + " the count is " + k);
        paramAnonymousContext = (ContentFragment)paramAnonymousContext.getItem(j);
        if (i == 1) {}
        for (;;)
        {
          SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this, bool);
          SnsAdNativeLandingPagesUI.this.zX(500L);
          paramAnonymousContext.rG(bool);
          AppMethodBeat.o(98324);
          return;
          bool = false;
        }
      }
    };
    this.zYw = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(98343);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am.aF(SnsAdNativeLandingPagesUI.this);
        AppMethodBeat.o(98343);
      }
    };
    this.zYx = new ContentFragment.a()
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
              ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "onPreDraw %d, %d", new Object[] { Integer.valueOf(SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).getHeight()), Integer.valueOf(SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this)) });
              Object localObject1 = null;
              Object localObject2 = SnsAdNativeLandingPagesUI.d(SnsAdNativeLandingPagesUI.this);
              int i;
              if (localObject2 != null)
              {
                localObject1 = ((ag)localObject2).dXo();
                if (localObject1 != null)
                {
                  localObject1 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t)localObject1).zxv;
                  localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.jC((String)localObject1, "scene_ad_landing");
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
                  ad.i("SphereImageView.SnsAdNativeLandingPagesUI", i);
                }
              }
              else
              {
                if (!SnsAdNativeLandingPagesUI.f(SnsAdNativeLandingPagesUI.this)) {
                  break label245;
                }
                aq.o(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(98349);
                    Bitmap localBitmap;
                    if (this.zYR != null) {
                      localBitmap = this.zYR;
                    }
                    while (localBitmap != null)
                    {
                      SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).setAlpha(1.0F);
                      SnsAdNativeLandingPagesUI.h(SnsAdNativeLandingPagesUI.this).setImageBitmap(localBitmap);
                      SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this, SnsAdNativeLandingPagesUI.20.1.this.naA, localBitmap.getWidth(), localBitmap.getHeight());
                      AppMethodBeat.o(98349);
                      return;
                      if (SnsAdNativeLandingPagesUI.g(SnsAdNativeLandingPagesUI.this))
                      {
                        localBitmap = com.tencent.mm.sdk.platformtools.g.ga(SnsAdNativeLandingPagesUI.20.1.this.naA.getChildAt(0));
                        SnsAdNativeLandingPagesUI.h(SnsAdNativeLandingPagesUI.this).setScaleType(ImageView.ScaleType.CENTER_CROP);
                      }
                      else
                      {
                        localBitmap = com.tencent.mm.sdk.platformtools.g.ga(SnsAdNativeLandingPagesUI.e(SnsAdNativeLandingPagesUI.this));
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
                SnsAdNativeLandingPagesUI.this.zX(300L);
              }
            }
          });
        }
        AppMethodBeat.o(98351);
      }
    };
    this.zYy = new ViewPager.f()
    {
      public final void onPageScrollStateChanged(int paramAnonymousInt)
      {
        AppMethodBeat.i(98353);
        super.onPageScrollStateChanged(paramAnonymousInt);
        SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this).zIW = paramAnonymousInt;
        Object localObject;
        if (paramAnonymousInt == 1)
        {
          paramAnonymousInt = 0;
          while (paramAnonymousInt < SnsAdNativeLandingPagesUI.this.zLR.size())
          {
            localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)SnsAdNativeLandingPagesUI.this.zLR.get(paramAnonymousInt);
            localObject = (Fragment)SnsAdNativeLandingPagesUI.k(SnsAdNativeLandingPagesUI.this).get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject).id));
            if (localObject != null) {
              ((ContentFragment)localObject).dXK();
            }
            paramAnonymousInt += 1;
          }
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am.gl(SnsAdNativeLandingPagesUI.this.getContext());
          AppMethodBeat.o(98353);
          return;
        }
        if (paramAnonymousInt == 0)
        {
          localObject = (Fragment)SnsAdNativeLandingPagesUI.k(SnsAdNativeLandingPagesUI.this).get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)SnsAdNativeLandingPagesUI.this.zLR.get(SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getCurrentItem())).id));
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
          if ((localContentFragment.cBJ) && (localContentFragment.zIM != null)) {
            localContentFragment.zIM.dXz();
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
        if (i < SnsAdNativeLandingPagesUI.this.zLR.size())
        {
          Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)SnsAdNativeLandingPagesUI.this.zLR.get(i);
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
            ((ContentFragment)localObject).dXK();
          }
        }
        SnsAdNativeLandingPagesUI.this.zX(300L);
        AppMethodBeat.o(98354);
      }
    };
    this.zYz = new AdLandingPagesProxy.e()
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
            localObject = new i.a(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.jL((String)localObject, str), SnsAdNativeLandingPagesUI.n(SnsAdNativeLandingPagesUI.this));
            SnsAdNativeLandingPagesUI.this.zLR = ((i.a)localObject).zLR;
            SnsAdNativeLandingPagesUI.this.zXy = ((i.a)localObject).zLS;
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
    this.zYA = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(oi paramAnonymousoi)
      {
        AppMethodBeat.i(176294);
        Object localObject1;
        SnsAdLandingPageFloatView localSnsAdLandingPageFloatView;
        Object localObject2;
        int i;
        String str1;
        String str2;
        String str3;
        if ((SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this).zII.zLK != null) && (SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this).zII.zLK.containsKey(paramAnonymousoi.dCj.dCk)) && (!SnsAdNativeLandingPagesUI.r(SnsAdNativeLandingPagesUI.this).containsKey(paramAnonymousoi.dCj.dCk)))
        {
          SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this).onPause();
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("sns_landing_pages_xml", SnsAdNativeLandingPagesUI.m(SnsAdNativeLandingPagesUI.this));
          ((Bundle)localObject1).putString("sns_float_component_id", paramAnonymousoi.dCj.dCk);
          ((Bundle)localObject1).putInt("sns_landing_page_index", SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this).zII.id);
          ((Bundle)localObject1).putString("sns_landing_page_snsId", SnsAdNativeLandingPagesUI.this.dzb);
          ((Bundle)localObject1).putString("sns_landing_pages_rawSnsId", SnsAdNativeLandingPagesUI.this.zXL);
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
          localSnsAdLandingPageFloatView.dCk = ((Bundle)localObject1).getString("sns_float_component_id");
          i = ((Bundle)localObject1).getInt("sns_landing_page_index", -1);
          str1 = ((Bundle)localObject1).getString("sns_landing_pages_ux_info");
          str2 = ((Bundle)localObject1).getString("sns_landing_pages_aid");
          str3 = ((Bundle)localObject1).getString("sns_landing_pages_traceid");
          localSnsAdLandingPageFloatView.zuQ = ((Bundle)localObject1).getString("sns_landing_pages_canvas_ext");
          if ((!bt.V(new String[] { localObject2, localSnsAdLandingPageFloatView.dCk })) && (i != -1)) {
            break label490;
          }
          ad.e("MicroMsg.SnsAdLandingPageFloatView", "invalid landing float page data!");
        }
        for (;;)
        {
          localSnsAdLandingPageFloatView.setBackgroundColor(SnsAdNativeLandingPagesUI.this.getResources().getColor(2131100893));
          SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).addView(localSnsAdLandingPageFloatView, SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).getChildCount() - 1, new FrameLayout.LayoutParams(-1, -1));
          localSnsAdLandingPageFloatView.eeU();
          SnsAdNativeLandingPagesUI.j(SnsAdNativeLandingPagesUI.this).dXK();
          SnsAdNativeLandingPagesUI.this.j(false, 0L);
          SnsAdNativeLandingPagesUI.r(SnsAdNativeLandingPagesUI.this).put(paramAnonymousoi.dCj.dCk, localSnsAdLandingPageFloatView);
          AppMethodBeat.o(176294);
          return false;
          label490:
          localObject1 = new i.a((String)localObject2, bt.bI(((Bundle)localObject1).getString("sns_landing_pages_xml_prefix"), "adxml")).zLR;
          if ((localObject1 != null) && (((LinkedList)localObject1).size() > i))
          {
            localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)((LinkedList)localObject1).get(i);
            localSnsAdLandingPageFloatView.ACf = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g();
            localSnsAdLandingPageFloatView.ACf.jVX = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject1).jVX;
            localObject2 = (x)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject1).zLK.get(localSnsAdLandingPageFloatView.dCk);
            if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.QH(((x)localObject2).type))
            {
              localSnsAdLandingPageFloatView.ACe = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v)localObject2);
              localSnsAdLandingPageFloatView.ACf.zLJ.add(localSnsAdLandingPageFloatView.ACe);
              localSnsAdLandingPageFloatView.ACf.zLK.putAll(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject1).zLK);
            }
            localSnsAdLandingPageFloatView.ACf.id = 0;
            localSnsAdLandingPageFloatView.ACf.zLL = true;
          }
          ad.i("MicroMsg.SnsAdLandingPageFloatView", "[reportInfo] aid %s,traceId %s,uxInfo %s,adCanvasExtXml %s", new Object[] { str2, str3, str1, localSnsAdLandingPageFloatView.zuQ });
          localSnsAdLandingPageFloatView.initView();
        }
      }
    };
    this.zYB = new com.tencent.mm.sdk.b.c() {};
    this.zYC = new Runnable()
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
    this.zYD = new SnsAdNativeLandingPagesUI.5(this);
    this.zYE = new HashMap();
    this.tUH = new a.b()
    {
      public final void bip()
      {
        AppMethodBeat.i(198278);
        try
        {
          AdLandingPagesProxy.getInstance().favEditTag();
          AppMethodBeat.o(198278);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.SnsAdNativeLandingPagesUI", "favorite edittag fail, ex = " + localException.getMessage());
          AppMethodBeat.o(198278);
        }
      }
    };
    this.zYF = new com.tencent.mm.ui.b.a()
    {
      public final void bu(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(198279);
        SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this, paramAnonymousBoolean);
        ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "onKeyboardStateChanged, visiable=".concat(String.valueOf(paramAnonymousBoolean)));
        SnsAdNativeLandingPagesUI.this.zX(300L);
        AppMethodBeat.o(198279);
      }
    };
    this.zYG = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(198281);
        if (paramAnonymousIntent.getAction().equals("android.intent.action.SCREEN_OFF"))
        {
          ad.d("MicroMsg.SnsAdNativeLandingPagesUI", "android.intent.action.SCREEN_OFF");
          AppMethodBeat.o(198281);
          return;
        }
        if (paramAnonymousIntent.getAction().equals("android.intent.action.SCREEN_ON"))
        {
          ad.d("MicroMsg.SnsAdNativeLandingPagesUI", "android.intent.action.SCREEN_ON");
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am.aF(SnsAdNativeLandingPagesUI.this);
        }
        AppMethodBeat.o(198281);
      }
    };
    this.zYH = null;
    this.zYI = null;
    AppMethodBeat.o(98362);
  }
  
  private void Am(long paramLong)
  {
    AppMethodBeat.i(98401);
    if (this.zYl != null)
    {
      ad.d("MicroMsg.SnsAdNativeLandingPagesUI", "showFloatBarView");
      this.zYl.zV(paramLong);
      ContentFragment localContentFragment = ebm();
      if (localContentFragment != null) {
        localContentFragment.dXK();
      }
    }
    AppMethodBeat.o(98401);
  }
  
  private static boolean Rc(int paramInt)
  {
    AppMethodBeat.i(198289);
    if ((paramInt == 3) || (paramInt == 5) || (paramInt == 4)) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "isNeedUpdateUxinfo, source=" + paramInt + ", ret=" + bool);
      AppMethodBeat.o(198289);
      return bool;
    }
  }
  
  private void Zd()
  {
    long l2 = 0L;
    AppMethodBeat.i(98374);
    this.yXF = AdLandingPagesProxy.getInstance().getSnsInfo(this.dzb);
    AdLandingPagesProxy.getInstance().asyncCacheXml(this.dzb);
    if (this.values == null)
    {
      ad.e("MicroMsg.SnsAdNativeLandingPagesUI", "parse landingpagexml is error,landingpagexml is " + this.zXE);
      AppMethodBeat.o(98374);
      return;
    }
    long l1;
    if ((this.dnh == 1) || (this.dnh == 2) || (this.dnh == 16) || (this.dnh == 14) || (this.dnh == 9) || (this.dnh == 10))
    {
      if (this.yXF == null) {
        break label2850;
      }
      l1 = this.yXF.field_snsId;
      this.zuP = AdLandingPagesProxy.getInstance().getSnsAid(this.dzb);
      this.jSR = AdLandingPagesProxy.getInstance().getSnsTraceid(this.dzb);
      this.zvv = AdLandingPagesProxy.getInstance().getSnsAdType(this.dzb);
      this.dFy = AdLandingPagesProxy.getInstance().getSnsUxInfo(this.dzb);
      this.zuQ = AdLandingPagesProxy.getInstance().getSnsAdCanvasExtXml(this.dzb);
    }
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      label625:
      int i;
      if (this.zXL != null)
      {
        localObject1 = this.zXL;
        this.values.put("." + this.zXF + ".originSnsId", localObject1);
        this.values.put("." + this.zXF + ".originUxInfo", this.dFy);
        localObject2 = "<" + this.zXF + ">";
        localObject2 = (String)localObject2 + String.format("<originSnsId>%s</originSnsId>", new Object[] { localObject1 });
        localObject2 = (String)localObject2 + String.format("<originUxInfo>%s</originUxInfo>", new Object[] { this.dFy });
        localObject2 = (String)localObject2 + String.format("<originAdType>%d</originAdType>", new Object[] { Integer.valueOf(this.zvv) });
        localObject2 = (String)localObject2 + String.format("<originAid>%s</originAid>", new Object[] { this.zuP });
        localObject3 = (String)localObject2 + String.format("<originTraceId>%s</originTraceId>", new Object[] { this.jSR });
        localObject2 = localObject3;
        if (!bt.isNullOrNil(this.zuQ)) {
          localObject2 = (String)localObject3 + String.format("<originAdCanvasExt>%s</originAdCanvasExt>", new Object[] { this.zuQ });
        }
        this.zXE = this.zXE.replace("<" + this.zXF + ">", (CharSequence)localObject2);
        this.zXN.dFy = this.dFy;
        this.zXN.dzb = ((String)localObject1);
        ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "reportInfo aid [%s],traceId [%s],adType [%s],uxInfo [%s],adCanvasExtXml [%s]", new Object[] { this.zuP, this.jSR, Integer.valueOf(this.zvv), this.dFy, this.zuQ });
        if (bt.isNullOrNil(this.zuQ)) {
          break label1408;
        }
        localObject2 = bw.M(this.zuQ, "adCardItemList");
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
          localObject3 = bt.bI((String)((Map)localObject2).get((String)localObject1 + ".cardTpId"), "");
          localObject1 = bt.bI((String)((Map)localObject2).get((String)localObject1 + ".cardExt"), "");
          if ((!bt.isNullOrNil((String)localObject3)) && (!bt.isNullOrNil((String)localObject1))) {
            this.zAS.put(localObject3, localObject1);
          }
          i += 1;
          break label705;
          localObject1 = String.valueOf(l1);
          break;
          this.zXN.dzb = ((String)this.values.get("." + this.zXF + ".originSnsId"));
          this.zXN.dFy = ((String)this.values.get("." + this.zXF + ".originUxInfo"));
          this.dFy = this.zXN.dFy;
          this.zXL = this.zXN.dzb;
          this.zvv = bt.aRe((String)this.values.get("." + this.zXF + ".originAdType"));
          this.zuP = ((String)this.values.get("." + this.zXF + ".originAid"));
          this.jSR = ((String)this.values.get("." + this.zXF + ".originTraceId"));
          if (!bt.isNullOrNil(this.kto))
          {
            localObject1 = bw.M(this.kto, "ADInfo");
            ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "adInfoXml %s", new Object[] { this.kto });
            if (localObject1 != null)
            {
              this.dFy = bt.bI((String)((Map)localObject1).get(".ADInfo.uxInfo"), "");
              this.zXN.dFy = this.dFy;
              this.zuP = bt.bI((String)((Map)localObject1).get(".ADInfo.session_data.aid"), "");
              this.jSR = bt.bI((String)((Map)localObject1).get(".ADInfo.session_data.trace_id"), "");
              this.aQj = bt.bI((String)((Map)localObject1).get(".ADInfo.viewid"), "");
              this.zAR = bt.bI((String)((Map)localObject1).get(".ADInfo.commInfo"), "");
              ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "viewId = " + this.aQj + ", commInfo = " + this.zAR + ", uxInfo = " + this.dFy);
            }
          }
          localObject1 = Pattern.compile("<originAdCanvasExt>[\\s\\S]*</originAdCanvasExt>").matcher(this.zXE);
          if (!((Matcher)localObject1).find()) {
            break label625;
          }
          localObject1 = ((Matcher)localObject1).group();
          if (bt.isNullOrNil((String)localObject1)) {
            break label625;
          }
          this.zuQ = ((String)localObject1).replaceAll("</?originAdCanvasExt>", "");
          break label625;
        }
        this.zXN.zMp = AdLandingPagesProxy.getInstance().getSnsStatExtBySnsId(bt.aRf(this.zXN.dzb));
        this.qeR = bt.bI((String)this.values.get("." + this.zXF + ".adCanvasInfo.shareTitle"), "");
        this.qeQ = bt.bI((String)this.values.get("." + this.zXF + ".adCanvasInfo.shareWebUrl"), "");
        this.uaw = bt.bI((String)this.values.get("." + this.zXF + ".adCanvasInfo.shareDesc"), "");
        this.bizId = bt.aRe(bt.bI((String)this.values.get("." + this.zXF + ".adCanvasInfo.bizId"), ""));
        this.zXS = bt.bI((String)this.values.get("." + this.zXF + ".adCanvasInfo.shareAppId"), "");
        this.zXT = bt.bI((String)this.values.get("." + this.zXF + ".adCanvasInfo.shareType"), "");
        this.zXU = bt.bI((String)this.values.get("." + this.zXF + ".adCanvasInfo.userInfo"), "");
        this.zXX = bt.aRe(bt.bI((String)this.values.get("." + this.zXF + ".adCanvasInfo.disableShareBitSet"), ""));
        this.zXY = bt.aRe(bt.bI((String)this.values.get("." + this.zXF + ".adCanvasInfo.statusBarStyle"), ""));
        y(this.values, "." + this.zXF);
        this.uin = AdLandingPagesProxy.getInstance().getUin();
        this.zXV = bt.bI((String)this.values.get("." + this.zXF + ".adCanvasInfo.officialSyncBuffer"), "");
        getIntent().putExtra("sns_landing_pages_adType", this.zvv);
        getIntent().putExtra("sns_landing_pages_rawSnsId", this.zXN.dzb);
        if (bt.isNullOrNil(this.zuP)) {
          this.zuP = bt.bI((String)this.values.get("." + this.zXF + ".originAid"), "");
        }
        if (bt.isNullOrNil(this.jSR)) {
          this.jSR = bt.bI((String)this.values.get("." + this.zXF + ".originTraceId"), "");
        }
        localObject1 = new i.a(this.zXE, this.zXF);
        this.zLR = ((i.a)localObject1).zLR;
        this.zXy = ((i.a)localObject1).zLS;
        ebt();
        b((i.a)localObject1);
        c((i.a)localObject1);
        d((i.a)localObject1);
        if (this.zLR.size() > 0)
        {
          localObject2 = "";
          localObject3 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.zLR.get(0);
          localObject1 = localObject2;
          l1 = l2;
          if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject3).zLJ.size() > 0)
          {
            localObject3 = (x)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localObject3).zLJ.get(0);
            if (!(localObject3 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)) {
              break label2619;
            }
            this.zXK = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)localObject3).zzL;
            l1 = l2;
            localObject1 = localObject2;
          }
          if (this.yXF != null)
          {
            localObject2 = this.yXF.dYl();
            if ((localObject2 != null) && (((TimeLineObject)localObject2).HAT != null) && (((TimeLineObject)localObject2).HAT.GaQ != null) && (!((TimeLineObject)localObject2).HAT.GaQ.isEmpty()))
            {
              localObject3 = (byn)((TimeLineObject)localObject2).HAT.GaQ.getFirst();
              localObject2 = ao.jo(AdLandingPagesProxy.getInstance().getAccSnsPath(), ((byn)localObject3).Id) + com.tencent.mm.plugin.sns.data.q.i((byn)localObject3);
              localObject3 = ((byn)localObject3).Url;
              if (((String)localObject1).equals(localObject3))
              {
                localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jG("adId", (String)localObject3);
                if ((!com.tencent.mm.vfs.i.fv((String)localObject1)) && (com.tencent.mm.vfs.i.fv((String)localObject2)))
                {
                  ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "copy outsideFiel:%s->%s", new Object[] { localObject2, localObject1 });
                  if (!com.tencent.mm.plugin.sns.ad.timeline.a.a.i(this.yXF)) {
                    break label2831;
                  }
                  if (com.tencent.mm.vfs.i.aYo((String)localObject2) != l1) {
                    break label2812;
                  }
                  com.tencent.mm.vfs.i.mz((String)localObject2, (String)localObject1);
                  ad.d("MicroMsg.SnsAdNativeLandingPagesUI", "online video play, it is to copy!!");
                  com.tencent.mm.plugin.sns.ad.e.h.a(com.tencent.mm.plugin.sns.ad.e.i.PE(1));
                }
              }
            }
          }
        }
        for (;;)
        {
          this.zXG = bt.bI((String)this.values.get("." + this.zXF + ".adCanvasInfo.rightBarTitle"), "");
          this.zXH = bt.bI((String)this.values.get("." + this.zXF + ".adCanvasInfo.rightBarCanvasId"), "");
          this.zXI = bt.bI((String)this.values.get("." + this.zXF + ".adCanvasInfo.rightBarCanvasExt"), "");
          AppMethodBeat.o(98374);
          return;
          label2619:
          if ((localObject3 instanceof r))
          {
            this.zXK = ((r)localObject3).zzL;
            localObject1 = localObject2;
            l1 = l2;
            break;
          }
          if ((localObject3 instanceof u))
          {
            this.zXK = ((u)localObject3).zzR;
            localObject1 = ((u)localObject3).zzQ;
            l1 = ((u)localObject3).zAa;
            break;
          }
          localObject1 = localObject2;
          l1 = l2;
          if (!(localObject3 instanceof ah)) {
            break;
          }
          localObject3 = (ah)localObject3;
          localObject1 = localObject2;
          l1 = l2;
          if (((ah)localObject3).zzJ.isEmpty()) {
            break;
          }
          localObject3 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)((ah)localObject3).zzJ.getFirst();
          localObject1 = localObject2;
          l1 = l2;
          if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)localObject3).zzJ.isEmpty()) {
            break;
          }
          localObject3 = (x)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)localObject3).zzJ.getFirst();
          localObject1 = localObject2;
          l1 = l2;
          if (!(localObject3 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)) {
            break;
          }
          this.zXK = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)localObject3).zzL;
          localObject1 = localObject2;
          l1 = l2;
          break;
          label2812:
          ad.w("MicroMsg.SnsAdNativeLandingPagesUI", "online play, but it isn't to copy, because file size is invalid");
          com.tencent.mm.plugin.sns.ad.e.h.a(com.tencent.mm.plugin.sns.ad.e.i.PE(0));
          continue;
          com.tencent.mm.vfs.i.mz((String)localObject2, (String)localObject1);
        }
      }
      label2850:
      l1 = 0L;
    }
  }
  
  private String aAN(String paramString)
  {
    AppMethodBeat.i(98389);
    String str = bt.bI((String)this.values.get("." + this.zXF + ".adCanvasInfo.shareThumbUrl"), "");
    if (!bt.isNullOrNil(str))
    {
      AppMethodBeat.o(98389);
      return str;
    }
    AppMethodBeat.o(98389);
    return paramString;
  }
  
  private void aTs()
  {
    AppMethodBeat.i(98378);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.zXW.getAdapter();
    if (localb == null)
    {
      localb = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b(getSupportFragmentManager(), new ArrayList());
      this.zXW.setAdapter(localb);
    }
    for (;;)
    {
      List localList = ebe();
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g localg;
      ContentFragment localContentFragment;
      if (localList.size() > 0)
      {
        localg = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localList.get(0);
        ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "loadFirstPage load id %s", new Object[] { Integer.valueOf(localg.id) });
        localContentFragment = (ContentFragment)this.zYE.get(Integer.valueOf(localg.id));
        if (localContentFragment != null) {
          break label362;
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("pageInfo", localg);
        localHashMap.put("pageCount", Integer.valueOf(localList.size()));
        localHashMap.put("viewPager", this.zXW);
        localHashMap.put("pageDownIconInfo", this.zIO);
        localHashMap.put("is_first_show_page", Boolean.TRUE);
        if (localList.size() == 1) {
          localHashMap.put("is_last_shown_page", Boolean.TRUE);
        }
        localHashMap.put("needEnterAnimation", Boolean.valueOf(this.zXC));
        localHashMap.put("needDirectionAnimation", Boolean.valueOf(ebh()));
        localHashMap.put("groupListCompShowIndex", Integer.valueOf(this.zXQ));
        localContentFragment = new ContentFragment();
        localContentFragment.xaW = localHashMap;
        localContentFragment.zIX = this.zYx;
        this.zYE.put(Integer.valueOf(localg.id), localContentFragment);
      }
      for (;;)
      {
        if (localContentFragment != null) {
          localb.c(localContentFragment, 0);
        }
        localb.notifyDataSetChanged();
        this.zXW.setOffscreenPageLimit(localList.size());
        AppMethodBeat.o(98378);
        return;
        label362:
        localContentFragment.a(localg);
      }
    }
  }
  
  private void b(i.a parama)
  {
    AppMethodBeat.i(198293);
    try
    {
      if ((parama.zLT != null) && (this.zYc != null))
      {
        parama = FloatWebViewHelper.a(parama.zLT, (ViewGroup)this.zYc);
        getLifecycle().addObserver(parama);
      }
      AppMethodBeat.o(198293);
      return;
    }
    catch (Throwable parama)
    {
      AppMethodBeat.o(198293);
    }
  }
  
  private void c(i.a parama)
  {
    AppMethodBeat.i(198294);
    try
    {
      ebs();
      if (this.zYk != null)
      {
        parama = this.zYk.a(parama);
        if (parama != null)
        {
          parama.v((ViewGroup)this.zYc);
          parama.dRu();
        }
      }
      AppMethodBeat.o(198294);
      return;
    }
    catch (Throwable parama)
    {
      AppMethodBeat.o(198294);
    }
  }
  
  private void d(i.a parama)
  {
    AppMethodBeat.i(198295);
    try
    {
      ebs();
      if ((parama.zLU != null) && (this.zYc != null) && (this.zYk != null))
      {
        parama = this.zYk.a(parama.zLU, (ViewGroup)this.zYc);
        if (parama != null) {
          getLifecycle().addObserver(parama);
        }
      }
      AppMethodBeat.o(198295);
      return;
    }
    catch (Throwable parama)
    {
      AppMethodBeat.o(198295);
    }
  }
  
  private void eaV()
  {
    AppMethodBeat.i(98364);
    AdlandingRemoteServiceConnectedReceiver.a(android.support.v4.content.d.U(this));
    Zd();
    if (this.zXC) {
      aTs();
    }
    for (;;)
    {
      refreshView();
      eaZ();
      eba();
      rM(true);
      this.aMx = true;
      eaW();
      AppMethodBeat.o(98364);
      return;
      ebf();
    }
  }
  
  private void eaW()
  {
    AppMethodBeat.i(198287);
    if ((Rc(this.dnh)) && (!TextUtils.isEmpty(this.dFy)))
    {
      ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "doUpdateUxInfoScene, uxInfo=" + this.dFy);
      AdLandingPagesProxy.getInstance().doUpdateUxInfoScene(this.dFy, new AdLandingPagesProxy.e()
      {
        public final void be(Object paramAnonymousObject) {}
        
        public final void h(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
        {
          AppMethodBeat.i(198286);
          ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "doUpdateUxInfoScene end, errType=" + paramAnonymousInt1 + ", errNo=" + paramAnonymousInt2 + ", newUxInfo=" + paramAnonymousObject);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && ((paramAnonymousObject instanceof String))) {
            SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this, (String)paramAnonymousObject);
          }
          AppMethodBeat.o(198286);
        }
      });
      eaX();
    }
    AppMethodBeat.o(198287);
  }
  
  private void eaX()
  {
    AppMethodBeat.i(198288);
    try
    {
      ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "checkPreloadScanRes, uxinfo=" + this.dFy);
      com.tencent.mm.plugin.sns.ad.timeline.a.b.a(com.tencent.mm.plugin.sns.storage.b.a.t(this.values, ".adxml.adScanInfo"), this.dFy);
      AppMethodBeat.o(198288);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.SnsAdNativeLandingPagesUI", "checkPreloadScanRes exp=" + localException.toString());
      AppMethodBeat.o(198288);
    }
  }
  
  private void eaY()
  {
    AppMethodBeat.i(98367);
    Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.zXW.getAdapter();
    if (localObject == null)
    {
      AppMethodBeat.o(98367);
      return;
    }
    localObject = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)localObject).fragments.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ContentFragment localContentFragment = (ContentFragment)((Iterator)localObject).next();
      if ((localContentFragment.zIM != null) && (localContentFragment.getUserVisibleHint())) {
        localContentFragment.zIM.dXA();
      }
    }
    if (this.zYl != null) {
      this.zYl.dRn();
    }
    AppMethodBeat.o(98367);
  }
  
  private void eaZ()
  {
    AppMethodBeat.i(98369);
    com.tencent.mm.plugin.report.service.g localg;
    String str2;
    if (this.zvR != 2)
    {
      localg = com.tencent.mm.plugin.report.service.g.yhR;
      str2 = com.tencent.mm.plugin.sns.data.q.zw(com.tencent.mm.plugin.sns.data.q.ayi(this.zXN.dzb));
      if (this.dFy != null) {
        break label127;
      }
    }
    label127:
    for (String str1 = "";; str1 = this.dFy)
    {
      localg.f(14655, new Object[] { str2, str1, Integer.valueOf(this.zXN.glr), Integer.valueOf(this.zXN.pPw), Long.valueOf(this.enterTime), Integer.valueOf(this.zAN), this.zXN.ktn });
      AppMethodBeat.o(98369);
      return;
    }
  }
  
  private void eba()
  {
    AppMethodBeat.i(179185);
    try
    {
      if (!bt.V(new String[] { this.aQj, this.zAR }))
      {
        if (!this.zYp) {
          ebb();
        }
        if ((!this.zYq) && (this.zYs != null))
        {
          ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "execute mValidExposureRunnable onCreate");
          this.zYs.removeCallbacks(this.zYC);
          this.zYs.postDelayed(this.zYC, 1000L);
        }
      }
      AppMethodBeat.o(179185);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("MicroMsg.SnsAdNativeLandingPagesUI", localThrowable.toString());
      AppMethodBeat.o(179185);
    }
  }
  
  private void ebb()
  {
    AppMethodBeat.i(179186);
    ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "reportOriginalExposure viewId = " + this.aQj + ", commInfo = " + this.zAR + ", uxInfo = " + this.dFy + ", exposureType = 0");
    this.zYp = true;
    g(this.aQj, this.zAR, this.dFy, 0);
    AppMethodBeat.o(179186);
  }
  
  private void ebc()
  {
    AppMethodBeat.i(179187);
    ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "reportValidExposure viewId = " + this.aQj + ", commInfo = " + this.zAR + ", uxInfo = " + this.dFy + ", exposureType = 1");
    this.zYq = true;
    g(this.aQj, this.zAR, this.dFy, 1);
    AppMethodBeat.o(179187);
  }
  
  private boolean ebd()
  {
    AppMethodBeat.i(98370);
    int j = this.zYa.getChildCount();
    int i = 0;
    while (i < j)
    {
      if ((this.zYa.getChildAt(i) instanceof SnsAdLandingPageFloatView))
      {
        AppMethodBeat.o(98370);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(98370);
    return false;
  }
  
  private List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g> ebe()
  {
    AppMethodBeat.i(98376);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zLR.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g localg = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)localIterator.next();
      if (localg.zLL) {
        localArrayList.add(localg);
      }
    }
    fV(localArrayList);
    AppMethodBeat.o(98376);
    return localArrayList;
  }
  
  private void ebf()
  {
    AppMethodBeat.i(98379);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.zXW.getAdapter();
    if (localb == null)
    {
      localb = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b(getSupportFragmentManager(), new ArrayList());
      this.zXW.setAdapter(localb);
    }
    for (;;)
    {
      List localList = ebe();
      int i = 0;
      if (i < localList.size())
      {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g localg = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.zLR.get(i);
        ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "loadLandingPages load id %s", new Object[] { Integer.valueOf(localg.id) });
        ContentFragment localContentFragment = (ContentFragment)this.zYE.get(Integer.valueOf(localg.id));
        boolean bool;
        label214:
        label244:
        int j;
        if (localContentFragment == null)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("pageInfo", localg);
          localHashMap.put("pageCount", Integer.valueOf(localList.size()));
          localHashMap.put("viewPager", this.zXW);
          localHashMap.put("pageDownIconInfo", this.zIO);
          if (i == 0)
          {
            bool = true;
            localHashMap.put("is_first_show_page", Boolean.valueOf(bool));
            if (i != localList.size() - 1) {
              break label393;
            }
            bool = true;
            localHashMap.put("is_last_shown_page", Boolean.valueOf(bool));
            localHashMap.put("needEnterAnimation", Boolean.valueOf(this.zXC));
            localHashMap.put("needDirectionAnimation", Boolean.valueOf(ebh()));
            if (i != 0) {
              break label398;
            }
            j = this.zXQ;
            label304:
            localHashMap.put("groupListCompShowIndex", Integer.valueOf(j));
            localContentFragment = new ContentFragment();
            localContentFragment.xaW = localHashMap;
            if (i == 0) {
              localContentFragment.zIX = this.zYx;
            }
            this.zYE.put(Integer.valueOf(localg.id), localContentFragment);
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
      this.zXW.setOffscreenPageLimit(localList.size());
      AppMethodBeat.o(98379);
      return;
    }
  }
  
  private boolean ebg()
  {
    AppMethodBeat.i(98382);
    if (this.zXX != 0)
    {
      if (((this.zXX & 0x4) == 0) || ((this.zXX & 0x2) == 0) || ((ebk()) && (this.bizId == 2)) || ((this.zXX & 0x1) == 0))
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
  
  private boolean ebh()
  {
    return (this.zXX & 0x8) == 0;
  }
  
  private boolean ebi()
  {
    return this.zXY == 0;
  }
  
  private boolean ebj()
  {
    AppMethodBeat.i(98383);
    if ((!bt.isNullOrNil(this.zXG)) && (!bt.isNullOrNil(this.zXH)))
    {
      AppMethodBeat.o(98383);
      return true;
    }
    AppMethodBeat.o(98383);
    return false;
  }
  
  private boolean ebk()
  {
    return (this.zXX & 0x10) == 0;
  }
  
  private ag ebl()
  {
    AppMethodBeat.i(98385);
    Object localObject = ebm().dXE().iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l locall = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l)((Iterator)localObject).next();
      if ((locall instanceof ag))
      {
        localObject = (ag)locall;
        AppMethodBeat.o(98385);
        return localObject;
      }
    }
    AppMethodBeat.o(98385);
    return null;
  }
  
  private ContentFragment ebm()
  {
    AppMethodBeat.i(98387);
    ContentFragment localContentFragment = null;
    if (this.zLR.size() > 0) {
      localContentFragment = (ContentFragment)this.zYE.get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.zLR.get(this.zXW.getCurrentItem())).id));
    }
    AppMethodBeat.o(98387);
    return localContentFragment;
  }
  
  private a ebn()
  {
    AppMethodBeat.i(98388);
    Object localObject = new com.tencent.mm.plugin.sns.storage.b(this.zXE);
    if (((com.tencent.mm.plugin.sns.storage.b)localObject).dWf())
    {
      int i = AdLandingPagesProxy.getInstance().getAdVoteIndex(((com.tencent.mm.plugin.sns.storage.b)localObject).zwG.zxA, this.dFy, this.uin);
      if ((i > 0) && (i <= ((com.tencent.mm.plugin.sns.storage.b)localObject).zwG.zxC.size()))
      {
        localObject = (b.l)((com.tencent.mm.plugin.sns.storage.b)localObject).zwG.zxC.get(i - 1);
        a locala = new a((byte)0);
        if (!bt.isNullOrNil(((b.l)localObject).qeR))
        {
          locala.qeR = ((b.l)localObject).qeR;
          if (bt.isNullOrNil(((b.l)localObject).uaw)) {
            break label165;
          }
          locala.uaw = ((b.l)localObject).uaw;
          label128:
          if (bt.isNullOrNil(((b.l)localObject).zxD)) {
            break label176;
          }
        }
        label165:
        label176:
        for (locala.zxD = ((b.l)localObject).zxD;; locala.zxD = this.zXK)
        {
          AppMethodBeat.o(98388);
          return locala;
          locala.qeR = this.qeR;
          break;
          locala.uaw = this.uaw;
          break label128;
        }
      }
    }
    AppMethodBeat.o(98388);
    return null;
  }
  
  private String ebo()
  {
    AppMethodBeat.i(98390);
    Object localObject = new dih();
    ((dih)localObject).Hxa = new dii();
    ((dih)localObject).Hxa.Fml = this.zXN.dFy;
    ((dih)localObject).Hxa.Hxd = this.zXN.dzb;
    ((dih)localObject).Hxa.zvv = this.zvv;
    try
    {
      localObject = Base64.encodeToString(((dih)localObject).toByteArray(), 2);
      AppMethodBeat.o(98390);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(98390);
    }
    return "";
  }
  
  private String ebp()
  {
    AppMethodBeat.i(98391);
    String str2 = this.zXE.replaceAll("(?s)<adCanvasInfoLeft[^>]*>.*?</adCanvasInfoLeft>", "").replaceAll("(?s)<adCanvasInfoRight[^>]*>.*?</adCanvasInfoRight>", "");
    String str1 = str2;
    if (str2.contains("<shareAdCanvasInfo>")) {
      str1 = str2.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replace("shareAdCanvasInfo", "adCanvasInfo");
    }
    AppMethodBeat.o(98391);
    return str1;
  }
  
  private void ebs()
  {
    AppMethodBeat.i(198296);
    if (this.zYk == null) {
      this.zYk = new com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.a();
    }
    AppMethodBeat.o(198296);
  }
  
  private void ebt()
  {
    AppMethodBeat.i(98398);
    if ((this.zXy != null) && (this.zYa != null) && (this.zYl == null))
    {
      this.zYl = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d(this, this.zXy, this.zYa);
      j(false, 0L);
    }
    AppMethodBeat.o(98398);
  }
  
  private boolean ebv()
  {
    AppMethodBeat.i(98404);
    if (this.zXy != null)
    {
      if (this.zXy.zAA == 1)
      {
        boolean bool = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.t.Qp(this.dnh);
        AppMethodBeat.o(98404);
        return bool;
      }
      AppMethodBeat.o(98404);
      return true;
    }
    AppMethodBeat.o(98404);
    return false;
  }
  
  private static void fV(List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g> paramList)
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
        Iterator localIterator = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)paramList.next()).zLJ.iterator();
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
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localx).zyq = j;
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
      ad.e("MicroMsg.SnsAdNativeLandingPagesUI", "giveIdxForApkBtnInfo, exp=" + paramList.toString());
      AppMethodBeat.o(98377);
      return;
    }
    com.tencent.mm.plugin.sns.data.q.fH(localArrayList);
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
      j.jf("rewarded_canvas_exposure", localJSONObject.toString());
      AppMethodBeat.o(179188);
      return;
    }
    catch (Exception paramString1)
    {
      ad.e("MicroMsg.SnsAdNativeLandingPagesUI", "doCanvasExposureReport exp=" + paramString1.toString());
      AppMethodBeat.o(179188);
    }
  }
  
  private List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l> getAllComp()
  {
    AppMethodBeat.i(98380);
    this.zYe = new ArrayList();
    Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.zXW.getAdapter();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)localObject).fragments.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Fragment localFragment = (Fragment)((Iterator)localObject).next();
        this.zYe.addAll(((ContentFragment)localFragment).dXE());
      }
    }
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.fO(this.zYe);
    localObject = this.zYe;
    AppMethodBeat.o(98380);
    return localObject;
  }
  
  private void r(ContentFragment paramContentFragment)
  {
    AppMethodBeat.i(98399);
    if (!ebu()) {
      paramContentFragment.dXJ();
    }
    AppMethodBeat.o(98399);
  }
  
  private void refreshView()
  {
    AppMethodBeat.i(98365);
    Object localObject;
    if ((this.bizId == 2) && (!ebi()))
    {
      localObject = (FrameLayout.LayoutParams)this.zXW.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).setMargins(0, 0, 0, ar.ej(this));
      this.zXW.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int i = 2131100892;
    if (!ebi())
    {
      i = getResources().getColor(2131100891);
      if ((this.zLR == null) || (this.zLR.size() <= 0) || (bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.zLR.getFirst()).jVX))) {
        break label313;
      }
      i = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)this.zLR.getFirst()).jVX);
    }
    label313:
    for (;;)
    {
      this.zYb.setBackgroundColor(i);
      i = 2131100891;
      localObject = this.gXw.getDrawable();
      if (localObject != null)
      {
        android.support.v4.graphics.drawable.a.a((Drawable)localObject, android.support.v4.content.b.n(this, i));
        this.gXw.setImageDrawable((Drawable)localObject);
      }
      localObject = this.xAl.getDrawable();
      if (localObject != null)
      {
        android.support.v4.graphics.drawable.a.a((Drawable)localObject, android.support.v4.content.b.n(this, i));
        this.xAl.setImageDrawable((Drawable)localObject);
      }
      if ((ebj()) && (!ebk()) && (this.bizId == 2))
      {
        this.xAl.setVisibility(8);
        this.zXA.setVisibility(0);
        this.zXA.setText(this.zXG);
        this.zXA.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(98327);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            SnsAdNativeLandingPagesUI.this.F(SnsAdNativeLandingPagesUI.this, SnsAdNativeLandingPagesUI.y(SnsAdNativeLandingPagesUI.this), SnsAdNativeLandingPagesUI.z(SnsAdNativeLandingPagesUI.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98327);
          }
        });
        AppMethodBeat.o(98365);
        return;
      }
      if (ebg())
      {
        this.xAl.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(198266);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            paramAnonymousView = new e(SnsAdNativeLandingPagesUI.this, 1, false);
            paramAnonymousView.KJy = new n.d()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
              {
                AppMethodBeat.i(198264);
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
                  AppMethodBeat.o(198264);
                  return;
                }
              }
            };
            paramAnonymousView.lzH = true;
            paramAnonymousView.KJz = new n.e()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(198265);
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am.aF(SnsAdNativeLandingPagesUI.this);
                if (paramAnonymous2MenuItem != null) {
                  switch (paramAnonymous2MenuItem.getItemId())
                  {
                  }
                }
                for (;;)
                {
                  AppMethodBeat.o(198265);
                  return;
                  SnsAdNativeLandingPagesUI.E(SnsAdNativeLandingPagesUI.this);
                  AppMethodBeat.o(198265);
                  return;
                  SnsAdNativeLandingPagesUI.F(SnsAdNativeLandingPagesUI.this);
                  AppMethodBeat.o(198265);
                  return;
                  SnsAdNativeLandingPagesUI.G(SnsAdNativeLandingPagesUI.this);
                  AppMethodBeat.o(198265);
                  return;
                  SnsAdNativeLandingPagesUI.this.F(SnsAdNativeLandingPagesUI.this, SnsAdNativeLandingPagesUI.y(SnsAdNativeLandingPagesUI.this), SnsAdNativeLandingPagesUI.z(SnsAdNativeLandingPagesUI.this));
                }
              }
            };
            SnsAdNativeLandingPagesUI.this.hideVKB();
            paramAnonymousView.cMW();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(198266);
          }
        });
        AppMethodBeat.o(98365);
        return;
      }
      this.xAl.setVisibility(8);
      AppMethodBeat.o(98365);
      return;
    }
  }
  
  private void report()
  {
    AppMethodBeat.i(98368);
    Object localObject1 = getAllComp();
    Object localObject2 = this.zYj.values().iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).addAll(((SnsAdLandingPageFloatView)((Iterator)localObject2).next()).getAllComp());
    }
    if (this.zYl != null)
    {
      ((List)localObject1).add(this.zYl);
      localObject2 = this.zYl.dWB();
      if (localObject2 != null)
      {
        this.zYl.dWA();
        ((List)localObject1).add(localObject2);
      }
    }
    if (this.zYk != null)
    {
      localObject2 = this.zYk.dRr();
      if (com.tencent.mm.plugin.sns.ad.e.b.m((Collection)localObject2)) {
        ((List)localObject1).addAll((Collection)localObject2);
      }
    }
    this.dBD += System.currentTimeMillis() - this.startTime;
    this.zXN.zMn = ((int)this.dBD);
    this.zXN.zMm = ((List)localObject1).size();
    localObject2 = this.zXN;
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l locall = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l)((Iterator)localObject1).next();
      if (!locall.dWS().zAp)
      {
        JSONObject localJSONObject = new JSONObject();
        if ((!locall.D(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject2).zMq)) && (locall.aQ(localJSONObject))) {
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject2).zMq.put(localJSONObject);
        }
      }
    }
    ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "landingPage report json %s", new Object[] { this.zXN.zMq });
    localObject1 = this.zXN.dYf();
    if (this.bizId == 2)
    {
      AdLandingPagesProxy.getInstance().doCgiReportCanvasBrowseInfo(15041, (String)localObject1);
      ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "post cgi stat 15041 data: ".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(98368);
      return;
    }
    if (AdLandingPagesProxy.getInstance().isRecExpAd(this.zXN.dzb))
    {
      com.tencent.mm.plugin.report.service.g.yhR.kvStat(14650, (String)localObject1);
      ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 14650 data: ".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(98368);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yhR.kvStat(13387, (String)localObject1);
    ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 13387 data: ".concat(String.valueOf(localObject1)));
    AppMethodBeat.o(98368);
  }
  
  private void y(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(98375);
    String str = (String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.iconUrl");
    if (TextUtils.isEmpty(str))
    {
      this.zIO = null;
      AppMethodBeat.o(98375);
      return;
    }
    if (this.zIO == null) {
      this.zIO = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am();
    }
    this.zIO.iconUrl = str;
    int k = bt.aRe((String)paramMap.get(paramString + ".adCanvasInfo.sizeType"));
    int i = bt.aRe((String)paramMap.get(paramString + ".adCanvasInfo.basicRootFontSize"));
    int j = bt.aRe((String)paramMap.get(paramString + ".adCanvasInfo.basicWidth"));
    if ((i == 0) && (k == 1)) {
      i = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.zLP;
    }
    for (;;)
    {
      if ((j == 0) && (k == 1)) {
        j = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.zLO;
      }
      for (;;)
      {
        this.zIO.paddingBottom = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(bt.aRg((String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.paddingBottom")), k, j, i);
        this.zIO.width = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(bt.aRg((String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.layoutWidth")), k, j, i);
        this.zIO.height = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(bt.aRg((String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.layoutHeight")), k, j, i);
        AppMethodBeat.o(98375);
        return;
      }
    }
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
    if (this.zAN == 0)
    {
      i = this.dnh;
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
      i = this.zAN;
      break;
      paramString1 = "";
    }
  }
  
  public final void a(final x paramx, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, final boolean paramBoolean3)
  {
    AppMethodBeat.i(98395);
    if ((this.zYH != null) && (!paramBoolean3))
    {
      ad.w("MicroMsg.SnsAdNativeLandingPagesUI", "bottom sheet appear several times");
      this.zYH.bpT();
      if (this.zYI != null)
      {
        this.zYI.dismiss();
        this.zYI = null;
      }
      AppMethodBeat.o(98395);
      return;
    }
    AdLandingPagesProxy.e local18 = new AdLandingPagesProxy.e()
    {
      public final void be(Object paramAnonymousObject) {}
      
      public final void h(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(198282);
        SnsAdNativeLandingPagesUI.this.rM(false);
        if (paramBoolean3)
        {
          if (SnsAdNativeLandingPagesUI.S(SnsAdNativeLandingPagesUI.this) != null) {
            SnsAdNativeLandingPagesUI.S(SnsAdNativeLandingPagesUI.this).bpT();
          }
          if (SnsAdNativeLandingPagesUI.T(SnsAdNativeLandingPagesUI.this) != null)
          {
            SnsAdNativeLandingPagesUI.T(SnsAdNativeLandingPagesUI.this).dismiss();
            SnsAdNativeLandingPagesUI.U(SnsAdNativeLandingPagesUI.this);
          }
        }
        AppMethodBeat.o(198282);
      }
    };
    AppCompatActivity localAppCompatActivity;
    LinearLayout localLinearLayout;
    if (!paramBoolean3)
    {
      localAppCompatActivity = getContext();
      localLinearLayout = new LinearLayout(getContext());
      if (bt.isNullOrNil(paramx.zAl)) {
        break label223;
      }
    }
    label223:
    for (int i = Color.parseColor(paramx.zAl);; i = -1)
    {
      paramx = av.a(localAppCompatActivity, paramx, localLinearLayout, i);
      this.zYH = new m(getContext(), paramx, paramString1, paramString2, paramString3, paramBoolean1, paramBoolean2);
      paramx = paramx.getView();
      this.zYH.zDU = new m.a()
      {
        private void onRemove()
        {
          AppMethodBeat.i(198285);
          if ((paramx != null) && (paramx.getParent() != null)) {
            ((ViewGroup)paramx.getParent()).removeView(paramx);
          }
          SnsAdNativeLandingPagesUI.V(SnsAdNativeLandingPagesUI.this);
          AppMethodBeat.o(198285);
        }
        
        public final void dXa()
        {
          AppMethodBeat.i(198283);
          ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "onDismiss");
          onRemove();
          AppMethodBeat.o(198283);
        }
        
        public final void dXb()
        {
          AppMethodBeat.i(198284);
          ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "onCancel");
          onRemove();
          AppMethodBeat.o(198284);
        }
      };
      this.zYH.cMW();
      if (!bt.isNullOrNil(paramString1))
      {
        AdLandingPagesProxy.getInstance().doFavOfficialItemScene(paramString1, local18);
        if (paramBoolean3) {
          this.zYI = com.tencent.mm.ui.base.h.b(this, getString(2131763886), false, null);
        }
      }
      AppMethodBeat.o(98395);
      return;
    }
  }
  
  public final void bWL()
  {
    AppMethodBeat.i(98384);
    Object localObject;
    try
    {
      Iterator localIterator1 = this.zYj.values().iterator();
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
      ad.printErrStackTrace("MicroMsg.SnsAdNativeLandingPagesUI", localException, "play exit animation error", new Object[0]);
      finish();
      AppMethodBeat.o(98384);
      return;
    }
    eaY();
    report();
    this.zXP = true;
    this.zYb.setVisibility(8);
    if (!this.zXC)
    {
      finish();
      AppMethodBeat.o(98384);
      return;
    }
    if (this.zYh)
    {
      ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "is playing animation");
      AppMethodBeat.o(98384);
      return;
    }
    ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "run exit animation, %s", new Object[] { Boolean.valueOf(this.zXC) });
    this.zYh = true;
    if (isSupportNavigationSwipeBack()) {
      getSwipeBackLayout().setEnableGesture(false);
    }
    Iterator localIterator2 = ebm().dXE().iterator();
    while (localIterator2.hasNext())
    {
      localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l)localIterator2.next();
      if ((localObject instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a))
      {
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject).dWl();
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l)localObject).dWX();
      }
    }
    aq.o(new Runnable()
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
  
  public final com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae dWZ()
  {
    AppMethodBeat.i(198291);
    if (this.ziT == null) {
      this.ziT = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae();
    }
    Object localObject1 = this.ziT;
    int i;
    if (this.zAN == 0) {
      i = this.dnh;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)localObject1).zAN = i;
      this.ziT.dnh = this.dnh;
      this.ziT.zAO = this.zXM;
      this.ziT.dFy = this.dFy;
      this.ziT.zAP = this.zAP;
      this.ziT.uin = this.uin;
      this.ziT.bizId = this.bizId;
      this.ziT.zuP = this.zuP;
      this.ziT.jSR = this.jSR;
      localObject1 = this.ziT;
      Object localObject2 = this.zAS;
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)localObject1).zAS.putAll((Map)localObject2);
      localObject2 = this.ziT;
      label182:
      boolean bool;
      if (this.zXN != null)
      {
        localObject1 = this.zXN.ktn;
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)localObject2).ktn = ((String)localObject1);
        localObject1 = this.ziT;
        if (this.zXy == null) {
          break label393;
        }
        bool = true;
        label204:
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)localObject1).zAQ = bool;
      }
      try
      {
        localObject2 = this.ziT;
        if (bt.isNullOrNil(this.dzb)) {
          if (this.zXN != null)
          {
            localObject1 = String.valueOf(j.axN(this.zXN.dzb));
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)localObject2).dzb = ((String)localObject1);
            if (!bt.V(new String[] { this.aQj, this.zAR }))
            {
              this.ziT.aQj = this.aQj;
              this.ziT.zAR = this.zAR;
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
            localObject1 = (String)((Map)localObject1).get("." + this.zXF + ".adExtInfo");
            this.ziT.zeg = com.tencent.mm.plugin.sns.data.h.axM((String)localObject1);
            localObject1 = this.ziT;
            AppMethodBeat.o(198291);
            return localObject1;
            i = this.zAN;
            break;
            localObject1 = "";
            break label182;
            label393:
            bool = false;
            break label204;
            localObject1 = "";
            continue;
            long l = j.axN(this.dzb);
            localObject1 = String.valueOf(l);
          }
          localThrowable1 = localThrowable1;
          ad.e("MicroMsg.SnsAdNativeLandingPagesUI", localThrowable1.toString());
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            ad.e("MicroMsg.SnsAdNativeLandingPagesUI", "there is something wrong in set ad ext info");
          }
        }
      }
    }
  }
  
  public final void ebq()
  {
    AppMethodBeat.i(198292);
    try
    {
      boolean bool = ebr();
      ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "jumpNextPage, hasNextPage=".concat(String.valueOf(bool)));
      if (bool) {
        this.zXW.setCurrentItem$2563266(this.zXW.getCurrentItem() + 1);
      }
      AppMethodBeat.o(198292);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.SnsAdNativeLandingPagesUI", "jumpNextPage exp:" + localException.toString());
      AppMethodBeat.o(198292);
    }
  }
  
  public final boolean ebr()
  {
    AppMethodBeat.i(98397);
    try
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.zXW.getAdapter();
      int i = this.zXW.getCurrentItem();
      ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "hasNextPage, curPage=" + i + ", pageCount=" + localb.getCount());
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
      ad.e("MicroMsg.SnsAdNativeLandingPagesUI", "hasNextPage exp:" + localException.toString());
      AppMethodBeat.o(98397);
    }
    return true;
  }
  
  public final boolean ebu()
  {
    AppMethodBeat.i(98400);
    if (this.zYl != null)
    {
      boolean bool = this.zYl.isShowing();
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
    this.zYa = ((FrameLayout)findViewById(2131304239));
    this.zYc = findViewById(2131298752);
    this.zXW = ((AdlandingDummyViewPager)findViewById(2131306298));
    this.zYb = findViewById(2131302239);
    ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "before, assistActivity");
    if (al.aG(getContext()))
    {
      final int i = al.aF(this);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.zYa.getLayoutParams();
      localLayoutParams.height = (this.ltB - i);
      localLayoutParams.topMargin = i;
      this.zYa.setLayoutParams(localLayoutParams);
      getController().setActionbarColor(getResources().getColor(2131099873));
      this.zYa.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(198268);
          try
          {
            paramAnonymousView = new Rect();
            SnsAdNativeLandingPagesUI.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(paramAnonymousView);
            paramAnonymousInt1 = paramAnonymousView.top;
            ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "rect=" + paramAnonymousView.toString() + ", screenH=" + SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this) + ", cutH=" + i + ", statusBarH=" + paramAnonymousInt1);
            if (paramAnonymousInt1 > 0)
            {
              if (paramAnonymousInt1 != i)
              {
                ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "cutH != statusBarH, reset height");
                paramAnonymousView = (FrameLayout.LayoutParams)SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).getLayoutParams();
                paramAnonymousView.height = (SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this) - paramAnonymousInt1);
                paramAnonymousView.topMargin = paramAnonymousInt1;
                SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).setLayoutParams(paramAnonymousView);
                com.tencent.mm.plugin.sns.data.i.b(com.tencent.mm.plugin.sns.data.i.zdb, "", i, paramAnonymousInt1, SnsAdNativeLandingPagesUI.M(SnsAdNativeLandingPagesUI.this) + "|" + SnsAdNativeLandingPagesUI.c(SnsAdNativeLandingPagesUI.this));
              }
              SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).removeOnLayoutChangeListener(this);
            }
            AppMethodBeat.o(198268);
            return;
          }
          catch (Throwable paramAnonymousView)
          {
            ad.e("MicroMsg.SnsAdNativeLandingPagesUI", "onLayoutChange error:" + paramAnonymousView.toString());
            SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this).removeOnLayoutChangeListener(this);
            AppMethodBeat.o(198268);
          }
        }
      });
      aq.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98336);
          ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "hasCutOut, assistActivity");
          com.tencent.mm.ui.b.a(SnsAdNativeLandingPagesUI.this, true, SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this), SnsAdNativeLandingPagesUI.this.zYF);
          AppMethodBeat.o(98336);
        }
      }, 1500L);
    }
    for (;;)
    {
      this.iUP = ((ImageView)findViewById(2131300336));
      this.zXz = ((ImageView)findViewById(2131296672));
      this.gXw = ((ImageView)findViewById(2131304901));
      this.gXw.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(198269);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (SnsAdNativeLandingPagesUI.this.keyboardState() == 1) {
            SnsAdNativeLandingPagesUI.this.hideVKB();
          }
          SnsAdNativeLandingPagesUI.this.bWL();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198269);
        }
      });
      this.xAl = ((ImageView)findViewById(2131304918));
      this.zXA = ((TextView)findViewById(2131304919));
      this.zXJ = ((ImageView)findViewById(2131305019));
      if (this.zXC)
      {
        this.zYa.setAlpha(0.0F);
        this.iUP.setAlpha(0.0F);
        com.tencent.mm.ui.base.b.a(this, null);
      }
      AppMethodBeat.o(98381);
      return;
      aq.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(179171);
          ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "noCutOut, assistActivity");
          com.tencent.mm.ui.b.a(SnsAdNativeLandingPagesUI.this, false, SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this), SnsAdNativeLandingPagesUI.this.zYF);
          AppMethodBeat.o(179171);
        }
      }, 1500L);
    }
  }
  
  public final void j(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(98402);
    if (this.zYl != null)
    {
      ad.d("MicroMsg.SnsAdNativeLandingPagesUI", "hideFloatBarView");
      this.zYl.i(paramBoolean, paramLong);
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
        ad.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "share to timeLine success");
        str = bt.nullAsNil(this.dFy);
        localObject3 = bt.nullAsNil(this.zXN.ktn);
      }
    }
    for (;;)
    {
      try
      {
        str = com.tencent.mm.plugin.sns.a.b.w("3", "", str, (String)localObject3);
        ad.i("AntiCheatingReportUtils", "reportScreenShotParams = ".concat(String.valueOf(str)));
        com.tencent.mm.plugin.report.service.g.yhR.kvStat(19214, str);
        com.tencent.mm.ui.base.h.cl(getContext(), getContext().getString(2131755894));
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        AppMethodBeat.o(98392);
        return;
      }
      catch (Throwable localThrowable1)
      {
        ad.e("AntiCheatingReportUtils", localThrowable1.toString());
        continue;
      }
      int i;
      if (paramInt1 == 2)
      {
        if (com.tencent.mm.plugin.sns.ad.e.d.getBooleanExtra(paramIntent, "kfavorite", false))
        {
          i = AdLandingPagesProxy.getInstance().doFav(paramIntent, 42);
          ((com.tencent.mm.plugin.fav.a.v)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fav.a.v.class)).a(i, this, this.tUH);
        }
      }
      else
      {
        Object localObject4;
        int j;
        int k;
        if (paramInt1 == com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae.zGQ)
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
              localObject4 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l)((Iterator)localObject3).next();
            } while (!((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l)localObject4).dWV().equals(localObject1));
            localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae)localObject4;
            i = paramIntent.getIntExtra("KStreamVideoPlayCount", 0);
            j = paramIntent.getIntExtra("KStreamVideoPlayCompleteCount", 0);
            k = paramIntent.getIntExtra("KStreamVideoTotalPlayTimeInMs", 0);
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae)localObject1).yZi = (i + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae)localObject1).yZi);
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae)localObject1).yZj += j;
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae)localObject1).yZk += k;
          }
          catch (Exception localException) {}
        }
        else
        {
          Object localObject2;
          if (paramInt1 == 3)
          {
            localObject2 = new ud();
            ((ud)localObject2).dIC.EN = 1;
            ((ud)localObject2).dIC.requestCode = paramInt1;
            ((ud)localObject2).dIC.bZU = paramInt2;
            ((ud)localObject2).dIC.dxy = paramIntent;
            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
          }
          else if (paramInt1 == zYt)
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
                localObject3 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l)((Iterator)localObject4).next();
              } while (!((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l)localObject3).dWV().equals(localObject2));
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
              ad.i("NonFullOrFullVideoType", "videoType = " + i + ", cid = " + (String)localObject2 + ", currPosSec = " + j + ", bNoVoice = " + bool1 + ", isPlaying = " + bool2 + ", clickPlayControlCount = " + k + ", doubleClickCount = " + m + ", clickVoiceControlCount = " + n + ", playCompletedCount = " + i1 + ", playCount = " + i2 + ", playTimeInterval = " + l + ", floatBarReportInfo = " + (String)localObject4);
              if (i != 0) {
                break label784;
              }
              ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae)localObject3).a(j, bool1, bool2, k, m, n, i1, i2, l, (String)localObject4);
            }
            catch (Throwable localThrowable2)
            {
              ad.e("NonFullOrFullVideoType", localThrowable2.toString());
            }
            continue;
            label784:
            if (i == 1) {
              ((ai)localObject3).a(j, bool1, bool2, k, m, n, i1, i2, l, bool3, i3, (String)localObject4);
            }
          }
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(98386);
    bWL();
    AppMethodBeat.o(98386);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98363);
    super.onCreate(paramBundle);
    this.startTime = System.currentTimeMillis();
    this.enterTime = System.currentTimeMillis();
    this.zXN.enterTime = this.enterTime;
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am.aF(this);
    Object localObject = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am.gk(this);
    this.ltA = localObject[0];
    this.ltB = localObject[1];
    this.zXB = paramBundle;
    this.mController.hideTitleView();
    this.oGp = getIntent().getIntExtra("img_gallery_top", 0);
    if (al.aG(this))
    {
      int i = al.aF(this);
      this.oGp -= i;
      ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "hasCutOut, h=" + i + ", thumbTop=" + this.oGp);
    }
    this.oGq = getIntent().getIntExtra("img_gallery_left", 0);
    this.oGr = getIntent().getIntExtra("img_gallery_width", 0);
    this.oGs = getIntent().getIntExtra("img_gallery_height", 0);
    getWindow().addFlags(128);
    this.isVisible = false;
    this.zYp = false;
    this.zYq = false;
    this.zYr = false;
    if (this.zYs != null) {
      this.zYs.removeCallbacks(this.zYC);
    }
    this.dnh = getIntent().getIntExtra("sns_landig_pages_from_source", 0);
    this.zAN = getIntent().getIntExtra("sns_landig_pages_origin_from_source", 0);
    ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "source=" + this.dnh + ", originScene=" + this.zAN);
    this.zXE = getIntent().getStringExtra("sns_landing_pages_xml");
    paramBundle = getIntent().getStringExtra("sns_landing_pages_too_large_xml_path");
    if ((bt.isNullOrNil(this.zXE)) && (!bt.isNullOrNil(paramBundle))) {
      this.zXE = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am.azS(paramBundle);
    }
    if (bt.isNullOrNil(this.zXE))
    {
      finish();
      initView();
      if (AdLandingPagesProxy.getInstance().isConnected()) {
        break label1055;
      }
      ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "isConnected==false");
      AdLandingPagesProxy.getInstance().connect(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98360);
          ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "after Connected");
          SnsAdNativeLandingPagesUI.x(SnsAdNativeLandingPagesUI.this);
          AppMethodBeat.o(98360);
        }
      });
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.IbL.c(this.zYB);
      try
      {
        registerReceiver(this.zYG, new IntentFilter("android.intent.action.SCREEN_ON"));
        AppMethodBeat.o(98363);
        return;
      }
      catch (Exception paramBundle)
      {
        ad.e("MicroMsg.SnsAdNativeLandingPagesUI", "registerReceiver, exp=" + paramBundle.toString());
        AppMethodBeat.o(98363);
      }
      this.zXE = this.zXE.replaceAll("</*RecXml[\\s|\\S]*?>", "");
      this.zXN.zpD = getIntent().getStringExtra("sns_landing_pages_expid");
      this.zXF = getIntent().getStringExtra("sns_landing_pages_xml_prefix");
      this.dzb = getIntent().getStringExtra("sns_landing_pages_share_sns_id");
      this.zXL = getIntent().getStringExtra("sns_landing_pages_rawSnsId");
      this.dFy = getIntent().getStringExtra("sns_landing_pages_ux_info");
      this.zuP = getIntent().getStringExtra("sns_landing_pages_aid");
      this.jSR = getIntent().getStringExtra("sns_landing_pages_traceid");
      paramBundle = getIntent().getStringExtra("sns_landing_pages_search_extra");
      localObject = this.zXN;
      if (!TextUtils.isEmpty(paramBundle))
      {
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra.length() > 0) {
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra += "&";
        }
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra = (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra + "searchextra=" + URLEncoder.encode(paramBundle));
      }
      paramBundle = getIntent().getStringExtra("sns_landing_pages_extra");
      localObject = this.zXN;
      if (!TextUtils.isEmpty(paramBundle)) {
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra = (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k)localObject).extra + "&extra1=" + URLEncoder.encode(paramBundle));
      }
      this.zXM = getIntent().getBooleanExtra("sns_landing_is_native_sight_ad", false);
      this.zvR = getIntent().getIntExtra("sns_landing_pages_rec_src", 0);
      this.zXQ = getIntent().getIntExtra("sns_landing_pages_from_outer_index", 0);
      this.kto = getIntent().getStringExtra("sns_landing_pages_ad_info");
      this.zXC = getIntent().getBooleanExtra("sns_landing_pages_need_enter_and_exit_animation", false);
      this.zXD = getIntent().getBooleanExtra("sns_landing_pages_is_normal_ad_animation", false);
      if (this.zXC) {
        this.zXN.glr = 0;
      }
      for (this.zXN.fFu = 0;; this.zXN.fFu = 1)
      {
        this.zXN.pPw = this.dnh;
        this.zXN.zMi = 0;
        this.zXN.zMj = 0;
        this.zXN.zMk = 1;
        this.zXN.zMl = 0;
        this.zXN.zAN = this.zAN;
        if ((this.zXF == null) || ("".equals(this.zXE))) {
          this.zXF = "adxml";
        }
        if ((!bt.isNullOrNil(this.zXE)) && (!bt.isNullOrNil(this.zXF))) {
          break label986;
        }
        ad.e("MicroMsg.SnsAdNativeLandingPagesUI", "landingPagesXml is " + this.zXE + ",landingPagesXmlPrex is " + this.zXF);
        break;
        this.zXN.glr = 1;
      }
      label986:
      this.values = bw.M(this.zXE, this.zXF);
      this.zXN.ktn = bt.bI((String)this.values.get("." + this.zXF + ".adCanvasInfo.id"), "");
      break;
      label1055:
      ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "isConnected==true");
      eaV();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98366);
    getWindow().clearFlags(128);
    if (this.zYs != null) {
      this.zYs.removeCallbacks(this.zYC);
    }
    if (this.aMx)
    {
      ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "the SnsAdNativeLadingPagesUI is destroy, bHandleExit=" + this.zXP);
      if (!this.zXP)
      {
        eaY();
        report();
      }
    }
    for (;;)
    {
      this.zYj.clear();
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)this.zXW.getAdapter();
      if (localb != null) {
        localb.fragments.clear();
      }
      try
      {
        unregisterReceiver(this.zYG);
        com.tencent.mm.sdk.b.a.IbL.d(this.zYB);
        AdLandingPagesProxy.getInstance().clearCallback();
        super.onDestroy();
        AppMethodBeat.o(98366);
        return;
        ad.e("MicroMsg.SnsAdNativeLandingPagesUI", "onDestroy, isConnected=false");
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e("MicroMsg.SnsAdNativeLandingPagesUI", "unregisterReceiver, exp=" + localException.toString());
        }
      }
    }
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(98393);
    super.onKeyboardStateChanged();
    ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "onKeyboardStateChanged, state=" + keyboardState());
    if (this.zXW != null) {
      this.zXW.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(198280);
          if (SnsAdNativeLandingPagesUI.this.keyboardState() != 1) {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am.aF(SnsAdNativeLandingPagesUI.this);
          }
          if (!SnsAdNativeLandingPagesUI.R(SnsAdNativeLandingPagesUI.this))
          {
            new ArrayList();
            Iterator localIterator = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b)SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this).getAdapter()).fragments.iterator();
            while (localIterator.hasNext())
            {
              ContentFragment localContentFragment = (ContentFragment)localIterator.next();
              SnsAdNativeLandingPagesUI.this.keyboardState();
              localContentFragment.dXF();
            }
          }
          AppMethodBeat.o(198280);
        }
      }, 500L);
    }
    AppMethodBeat.o(98393);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(98372);
    super.onPause();
    ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "onPause");
    this.zYi = true;
    if (this.aMx) {
      this.dBD += System.currentTimeMillis() - this.startTime;
    }
    try
    {
      bh.a(this, null);
      this.zXO = false;
      if (ebd())
      {
        Iterator localIterator = this.zYj.values().iterator();
        while (localIterator.hasNext()) {
          ((SnsAdLandingPageFloatView)localIterator.next()).onPause();
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ad.e("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", localThrowable.toString());
      }
      AdlandingDummyViewPager localAdlandingDummyViewPager = this.zXW;
      ViewPager.OnPageChangeListener localOnPageChangeListener = this.zYy;
      localAdlandingDummyViewPager.zIC.remove(localOnPageChangeListener);
      android.support.v4.content.d.U(this).unregisterReceiver(this.zYv);
      android.support.v4.content.d.U(this).unregisterReceiver(this.zYw);
      com.tencent.mm.sdk.b.a.IbL.d(this.zYA);
      if (this.zYH != null) {
        this.zYH.bpT();
      }
      if ((this.zYl != null) && (this.zYl.isShowing())) {
        this.zYl.dRn();
      }
      AppMethodBeat.o(98372);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98371);
    ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "onResume");
    super.onResume();
    try
    {
      if (!this.zXO)
      {
        ad.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "onResume callback");
        bh.a(this, this.zYD);
        this.zXO = true;
      }
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am.aF(this);
      if (ebd())
      {
        i = this.zYa.getChildCount() - 1;
        if (i >= 0)
        {
          Object localObject = this.zYa.getChildAt(i);
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
        ad.e("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", localThrowable.toString());
        continue;
        i -= 1;
        continue;
        localAdlandingDummyViewPager = null;
      }
      this.zYi = false;
      AdlandingDummyViewPager localAdlandingDummyViewPager = this.zXW;
      ViewPager.OnPageChangeListener localOnPageChangeListener = this.zYy;
      localAdlandingDummyViewPager.zIC.add(localOnPageChangeListener);
      android.support.v4.content.d.U(this).a(this.zYv, new IntentFilter("com.tencent.mm.adlanding.video_progressbar_change"));
      android.support.v4.content.d.U(this).a(this.zYw, new IntentFilter("com.tencent.mm.adlanding.set_uioption"));
      if (this.aMx) {
        this.startTime = System.currentTimeMillis();
      }
      com.tencent.mm.sdk.b.a.IbL.c(this.zYA);
      if (this.zXR) {
        rM(false);
      }
      if ((this.zYl != null) && (this.zYl.isShowing())) {
        this.zYl.dRm();
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
        if ((!bt.V(new String[] { this.aQj, this.zAR })) && (!this.zYq))
        {
          if (this.zYr)
          {
            ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "execute mValidExposure onStart immediately");
            ebc();
            AppMethodBeat.o(179183);
            return;
          }
          if (this.zYs != null)
          {
            ad.i("MicroMsg.SnsAdNativeLandingPagesUI", "execute mValidExposureRunnable onStart");
            this.zYs.removeCallbacks(this.zYC);
            this.zYs.postDelayed(this.zYC, 1000L);
          }
        }
        AppMethodBeat.o(179183);
        return;
      }
      catch (Throwable localThrowable)
      {
        ad.e("MicroMsg.SnsAdNativeLandingPagesUI", localThrowable.toString());
      }
    }
    AppMethodBeat.o(179183);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(179184);
    super.onStop();
    this.isVisible = false;
    if (this.zYs != null) {
      this.zYs.removeCallbacks(this.zYC);
    }
    AppMethodBeat.o(179184);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(98373);
    this.zXN.fFu = 2;
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k localk = this.zXN;
    localk.zMl += 1;
    super.onSwipeBack();
    try
    {
      hideVKB();
      AppMethodBeat.o(98373);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.SnsAdNativeLandingPagesUI", "onSwipeBack hideVKB exp=" + localException.toString());
      AppMethodBeat.o(98373);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(198290);
    super.onWindowFocusChanged(paramBoolean);
    ad.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean) {}
    try
    {
      bh.a(this, null);
      this.zXO = false;
      AppMethodBeat.at(this, paramBoolean);
      AppMethodBeat.o(198290);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
      ad.e("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", localThrowable.toString());
      AppMethodBeat.at(this, paramBoolean);
      AppMethodBeat.o(198290);
    }
    if (!this.zXO)
    {
      ad.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "onWindowFocusChanged callback");
      bh.a(this, this.zYD);
      this.zXO = true;
    }
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(198290);
    return;
  }
  
  public final void rM(boolean paramBoolean)
  {
    AppMethodBeat.i(98394);
    if ((paramBoolean) && (this.bizId == 1)) {
      AdLandingPagesProxy.getInstance().doDynamicUpdateScene(this.zXS, this.zXT, this.zXU, this.zYz);
    }
    if ((this.bizId == 2) && (!bt.isNullOrNil(this.zXV))) {
      AdLandingPagesProxy.getInstance().doSearchDynamicUpdateScene(this.zXV, this.zYz);
    }
    this.zXR = true;
    AppMethodBeat.o(98394);
  }
  
  public final void zX(long paramLong)
  {
    AppMethodBeat.i(98403);
    if ((this.zYl == null) || (this.zXy == null))
    {
      AppMethodBeat.o(98403);
      return;
    }
    ContentFragment localContentFragment = ebm();
    if (localContentFragment == null)
    {
      AppMethodBeat.o(98403);
      return;
    }
    boolean bool1 = ebv();
    boolean bool2 = localContentFragment.dXH();
    boolean bool3 = this.zYn;
    boolean bool4 = localContentFragment.zIP;
    boolean bool5 = localContentFragment.iVf;
    boolean bool6 = localContentFragment.dXG();
    boolean bool7 = this.zYm;
    boolean bool8 = localContentFragment.dXN();
    boolean bool9 = localContentFragment.dXM();
    if ((bool4) && (bool8)) {
      this.zYo = true;
    }
    if (!bool4) {
      this.zYo = true;
    }
    ad.d("MicroMsg.SnsAdNativeLandingPagesUI", "toggleFloatBarView, isSourceAllow=" + bool1 + ", isForbid=" + bool2 + ", isKeybordShow=" + bool3 + ", isFirstPage=" + bool4 + ", isLastPage=" + bool5 + ", isCoverVideo=" + bool6 + ", isVideoCtrlBarShow=" + bool7 + ", isTopAppearOk=" + bool8 + ", isBottomAppearOk=" + bool9 + ", IsTopAppearChecked=" + this.zYo);
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
    if ((bool4) && (!bool8) && (!this.zYo))
    {
      AppMethodBeat.o(98403);
      return;
    }
    Am(paramLong);
    AppMethodBeat.o(98403);
  }
  
  final class a
  {
    public String qeR = "";
    public String uaw = "";
    public String zxD = "";
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI
 * JD-Core Version:    0.7.0.1
 */