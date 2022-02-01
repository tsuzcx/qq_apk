package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.d;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.DummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.as;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView;
import com.tencent.mm.plugin.sns.ui.widget.ad.OverScrollLinearout;
import com.tencent.mm.plugin.sns.ui.widget.ad.OverScrollLinearout.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.i;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.WeakHashMap;

public class ContentFragment
  extends Fragment
{
  private int bgColor;
  public boolean ctF;
  public boolean ibO;
  private int ihP;
  private ap kQO;
  private int kvn;
  private int kvo;
  public Map<String, Object> uLu;
  private LinearLayoutManager wYJ;
  private final Map<String, Bitmap> xbu;
  public g xeJ;
  private int xeL;
  public c xeN;
  private int xeO;
  private ak xeP;
  public boolean xeQ;
  private boolean xeR;
  private boolean xeS;
  public boolean xeT;
  private boolean xeU;
  private ValueAnimator xeV;
  private int xeW;
  public int xeX;
  public a xeY;
  private b xeZ;
  private a xfa;
  private boolean xfb;
  protected final String xfc;
  protected boolean xfd;
  protected boolean xfe;
  private BroadcastReceiver xff;
  protected View.OnClickListener xfg;
  private View.OnClickListener xfh;
  private boolean xfi;
  private OverScrollLinearout.a xfj;
  
  public ContentFragment()
  {
    AppMethodBeat.i(97093);
    this.xbu = new WeakHashMap();
    this.xeO = 1000;
    this.xeU = false;
    this.xfc = "ContentFragmentSphereImageView";
    this.xfd = false;
    this.xfe = false;
    this.xff = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(97091);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        ad.i("ContentFragmentSphereImageView", "onReceive, action=" + paramAnonymousContext + ", isSphereCom=" + ContentFragment.this.xfd + ", isFullScreen=" + ContentFragment.this.xfe);
        if ("com.tencent.mm.adlanding.sphereimage.next_page_view_show".equals(paramAnonymousContext))
        {
          paramAnonymousContext = ContentFragment.this.getActivity();
          if ((paramAnonymousContext instanceof SnsAdNativeLandingPagesUI))
          {
            boolean bool = ((SnsAdNativeLandingPagesUI)paramAnonymousContext).dAE();
            ad.i("ContentFragmentSphereImageView", "hasNextPage=".concat(String.valueOf(bool)));
            if (bool)
            {
              ContentFragment.a(ContentFragment.this).xfr.setVisibility(0);
              paramAnonymousContext = new AlphaAnimation(0.0F, 1.0F);
              paramAnonymousContext.setDuration(500L);
              ContentFragment.a(ContentFragment.this).xfr.startAnimation(paramAnonymousContext);
            }
          }
          AppMethodBeat.o(97091);
          return;
        }
        if ("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_none".equals(paramAnonymousContext))
        {
          if (ContentFragment.a(ContentFragment.this).xfr.getVisibility() == 0)
          {
            paramAnonymousContext = ObjectAnimator.ofFloat(ContentFragment.a(ContentFragment.this).xfr, "alpha", new float[] { 0.5F, 1.0F });
            paramAnonymousContext.setDuration(300L);
            paramAnonymousContext.start();
            AppMethodBeat.o(97091);
          }
        }
        else if ("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half".equals(paramAnonymousContext))
        {
          if (ContentFragment.a(ContentFragment.this).xfr.getVisibility() == 0)
          {
            paramAnonymousContext = ObjectAnimator.ofFloat(ContentFragment.a(ContentFragment.this).xfr, "alpha", new float[] { 1.0F, 0.5F });
            paramAnonymousContext.setDuration(300L);
            paramAnonymousContext.start();
            AppMethodBeat.o(97091);
          }
        }
        else if (("com.tencent.mm.adlanding.sphereimage.next_page_view_hide".equals(paramAnonymousContext)) && (ContentFragment.a(ContentFragment.this).xfr.getVisibility() == 0))
        {
          paramAnonymousContext = new AlphaAnimation(1.0F, 0.0F);
          paramAnonymousContext.setDuration(250L);
          paramAnonymousContext.setFillAfter(true);
          ContentFragment.a(ContentFragment.this).xfr.startAnimation(paramAnonymousContext);
        }
        AppMethodBeat.o(97091);
      }
    };
    this.xfg = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97092);
        paramAnonymousView = ContentFragment.this.getActivity();
        if ((paramAnonymousView instanceof SnsAdNativeLandingPagesUI))
        {
          ad.i("ContentFragmentSphereImageView", "jumpNextPage");
          ((SnsAdNativeLandingPagesUI)paramAnonymousView).dAD();
        }
        AppMethodBeat.o(97092);
      }
    };
    this.xfh = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187503);
        Object localObject;
        try
        {
          paramAnonymousView = ContentFragment.this.getRecyclerView();
          if (paramAnonymousView == null)
          {
            AppMethodBeat.o(187503);
            return;
          }
          localObject = ContentFragment.this.getActivity();
          LinearLayoutManager localLinearLayoutManager;
          if ((localObject instanceof SnsAdNativeLandingPagesUI))
          {
            localObject = (SnsAdNativeLandingPagesUI)localObject;
            localLinearLayoutManager = (LinearLayoutManager)paramAnonymousView.getLayoutManager();
            if (localLinearLayoutManager == null) {
              AppMethodBeat.o(187503);
            }
          }
          else
          {
            AppMethodBeat.o(187503);
            return;
          }
          int i = localLinearLayoutManager.jQ();
          int j = localLinearLayoutManager.getItemCount();
          if ((i < 0) || (j <= 0))
          {
            AppMethodBeat.o(187503);
            return;
          }
          if (i != j - 1)
          {
            ad.i("ContentFragment.VideoPlay", "By recyclerView, can scrollVertically");
            paramAnonymousView.a(0, ContentFragment.f(ContentFragment.this), null);
            AppMethodBeat.o(187503);
            return;
          }
        }
        catch (Throwable paramAnonymousView)
        {
          ad.e("ContentFragment.VideoPlay", paramAnonymousView.toString());
          AppMethodBeat.o(187503);
          return;
        }
        ad.i("ContentFragment.VideoPlay", "By recyclerView, can not scrollVertically");
        if (((SnsAdNativeLandingPagesUI)localObject).dAE())
        {
          ad.i("ContentFragment.VideoPlay", "By viewPager, jumpNextPage");
          ((SnsAdNativeLandingPagesUI)localObject).dAD();
        }
        AppMethodBeat.o(187503);
      }
    };
    this.xfi = false;
    this.xfj = new OverScrollLinearout.a()
    {
      public final void bs(float paramAnonymousFloat)
      {
        AppMethodBeat.i(187504);
        int i = (int)(paramAnonymousFloat * 0.8D);
        if (ContentFragment.a(ContentFragment.this).xfp.getScrollY() + i <= 0)
        {
          AppMethodBeat.o(187504);
          return;
        }
        Object localObject = ContentFragment.m(ContentFragment.this).dwM();
        if (!(localObject instanceof m))
        {
          AppMethodBeat.o(187504);
          return;
        }
        localObject = (m)localObject;
        if (ContentFragment.a(ContentFragment.this).xfp.getScrollY() + i < ((m)localObject).xaq)
        {
          ContentFragment.a(ContentFragment.this).xfp.scrollBy(0, i);
          AppMethodBeat.o(187504);
          return;
        }
        if (!ContentFragment.n(ContentFragment.this))
        {
          ContentFragment.a(ContentFragment.this, true);
          ((m)localObject).dwl();
        }
        AppMethodBeat.o(187504);
      }
      
      public final void dwC()
      {
        AppMethodBeat.i(187506);
        ContentFragment.a(ContentFragment.this, false);
        AppMethodBeat.o(187506);
      }
      
      public final boolean dxa()
      {
        AppMethodBeat.i(187505);
        int i = ContentFragment.o(ContentFragment.this).jQ();
        boolean bool = ContentFragment.this.getRecyclerView().canScrollVertically(1);
        k localk = ContentFragment.m(ContentFragment.this).dwM();
        if ((ContentFragment.p(ContentFragment.this)) && (!bool) && (i == ContentFragment.m(ContentFragment.this).getItemCount() - 1) && ((localk instanceof m)))
        {
          AppMethodBeat.o(187505);
          return true;
        }
        AppMethodBeat.o(187505);
        return false;
      }
    };
    AppMethodBeat.o(97093);
  }
  
  private void ak(Bitmap paramBitmap)
  {
    AppMethodBeat.i(97105);
    if (paramBitmap != null)
    {
      this.xeZ.frN.setBackgroundColor(0);
      this.xeZ.xfo.setBackgroundColor(0);
      this.xeZ.xfp.setBackgroundColor(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.xeZ.xfo.getLayoutParams();
      if (localLayoutParams.height >= this.kvo) {}
      for (int i = localLayoutParams.height;; i = this.kvo)
      {
        localLayoutParams.height = i;
        this.xeZ.xfo.setLayoutParams(localLayoutParams);
        this.xeZ.xfo.setImageBitmap(paramBitmap);
        AppMethodBeat.o(97105);
        return;
      }
    }
    dwS();
    AppMethodBeat.o(97105);
  }
  
  private void akk()
  {
    AppMethodBeat.i(97103);
    if (this.xeZ == null)
    {
      AppMethodBeat.o(97103);
      return;
    }
    dwS();
    final String str;
    if ((this.xeJ.xhG != null) && (this.xeJ.xhG.length() > 0))
    {
      str = this.xeJ.xhG;
      ad.i("ContentFragment", "bg need blur %b, url %s", new Object[] { Boolean.valueOf(this.xeJ.xhH), str });
      if (this.xbu.containsKey(str))
      {
        ad.i("ContentFragment", "bg has cache bitmap");
        ak((Bitmap)this.xbu.get(str));
        if (this.xfa != null) {
          if ((this.xeJ.xhG == null) || (this.xeJ.xhG.length() <= 0)) {
            break label205;
          }
        }
      }
    }
    label205:
    for (this.xfa.bgColor = 0;; this.xfa.bgColor = this.bgColor)
    {
      this.xfa.a(this.xeJ);
      AppMethodBeat.o(97103);
      return;
      h.c("adId", str, false, 1000000001, new f.a()
      {
        public final void apm(String paramAnonymousString)
        {
          AppMethodBeat.i(97081);
          ContentFragment.a(ContentFragment.this, paramAnonymousString, "adId", str);
          AppMethodBeat.o(97081);
        }
        
        public final void dsA()
        {
          AppMethodBeat.i(97080);
          ad.i("ContentFragment", "download img fail %s", new Object[] { str });
          ContentFragment.c(ContentFragment.this);
          AppMethodBeat.o(97080);
        }
        
        public final void duP() {}
      });
      break;
      dwS();
      break;
    }
  }
  
  private void b(g paramg)
  {
    AppMethodBeat.i(97111);
    this.xfd = false;
    this.xfe = false;
    if ((paramg != null) && (paramg.xhI != null))
    {
      paramg = paramg.xhI.iterator();
      while (paramg.hasNext())
      {
        x localx = (x)paramg.next();
        if ((localx instanceof t))
        {
          paramg = (t)localx;
          if ((paramg.wWo) || (paramg.width == 0.0F) || (paramg.height == 0.0F)) {
            this.xfe = true;
          }
          this.xfd = true;
        }
      }
    }
    ad.i("ContentFragmentSphereImageView", "checkSphereImageComp, isSphereImageViewCompPage=" + this.xfd + ", isFullScreen=" + this.xfe);
    AppMethodBeat.o(97111);
  }
  
  private void dwS()
  {
    AppMethodBeat.i(97104);
    if ((this.xeJ.jbK != null) && (this.xeJ.jbK.length() > 0)) {
      ad.i("ContentFragment", "setting bg color %s", new Object[] { this.xeJ.jbK });
    }
    try
    {
      this.bgColor = Color.parseColor(this.xeJ.jbK);
      this.xeZ.frN.setBackgroundColor(this.bgColor);
      this.xeZ.xfo.setBackgroundColor(this.bgColor);
      this.xeZ.xfp.setBackgroundColor(this.bgColor);
      AppMethodBeat.o(97104);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("ContentFragment", "the color is error : " + this.xeJ.jbK);
      }
    }
  }
  
  private boolean dwV()
  {
    boolean bool2 = true;
    AppMethodBeat.i(97109);
    if (!this.xeS)
    {
      AppMethodBeat.o(97109);
      return false;
    }
    if (this.xeW != 0)
    {
      AppMethodBeat.o(97109);
      return false;
    }
    if (this.xeX != 0)
    {
      AppMethodBeat.o(97109);
      return false;
    }
    if (this.xfd)
    {
      AppMethodBeat.o(97109);
      return false;
    }
    SnsAdNativeLandingPagesUI localSnsAdNativeLandingPagesUI = dwY();
    if ((localSnsAdNativeLandingPagesUI != null) && ((localSnsAdNativeLandingPagesUI.dAG()) || (localSnsAdNativeLandingPagesUI.xue)))
    {
      AppMethodBeat.o(97109);
      return false;
    }
    int i = this.wYJ.jO();
    if ((i == this.wYJ.jQ()) && (i == -1))
    {
      AppMethodBeat.o(97109);
      return false;
    }
    boolean bool1 = bool2;
    if (this.ibO) {
      if (this.wYJ.jQ() == this.xfa.getItemCount() - 1) {
        break label173;
      }
    }
    label173:
    for (bool1 = bool2;; bool1 = false)
    {
      AppMethodBeat.o(97109);
      return bool1;
    }
  }
  
  private SnsAdNativeLandingPagesUI dwY()
  {
    AppMethodBeat.i(97114);
    Object localObject = getActivity();
    if ((localObject instanceof SnsAdNativeLandingPagesUI))
    {
      localObject = (SnsAdNativeLandingPagesUI)localObject;
      AppMethodBeat.o(97114);
      return localObject;
    }
    AppMethodBeat.o(97114);
    return null;
  }
  
  private aa dwZ()
  {
    AppMethodBeat.i(97115);
    Object localObject = dwY();
    if (localObject != null)
    {
      localObject = ((SnsAdNativeLandingPagesUI)localObject).xtq;
      AppMethodBeat.o(97115);
      return localObject;
    }
    AppMethodBeat.o(97115);
    return null;
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(97102);
    if (this.xeJ != paramg)
    {
      this.xeJ = paramg;
      b(paramg);
      akk();
    }
    AppMethodBeat.o(97102);
  }
  
  public final Collection<k> dwO()
  {
    AppMethodBeat.i(97106);
    if (this.xfa == null)
    {
      localObject = Collections.EMPTY_LIST;
      AppMethodBeat.o(97106);
      return localObject;
    }
    Object localObject = this.xfa.dwO();
    AppMethodBeat.o(97106);
    return localObject;
  }
  
  public final void dwP()
  {
    AppMethodBeat.i(97100);
    if ((this.ctF) && (this.xeN != null)) {
      this.xeN.dwJ();
    }
    AppMethodBeat.o(97100);
  }
  
  public final boolean dwQ()
  {
    AppMethodBeat.i(97101);
    try
    {
      Object localObject1 = this.xfa.dwM();
      if ((localObject1 != null) && (((k)localObject1).dwb().type == 62))
      {
        ad.i("ContentFragment", "isFloatBarCoverVideo, ret=true, lastComp is Video");
        AppMethodBeat.o(97101);
        return true;
      }
      Object localObject2 = this.xfa.dwN();
      if ((localObject2 != null) && (((k)localObject2).dwb().type == 62) && (localObject1 != null))
      {
        localObject1 = ((k)localObject1).getContentView();
        if (localObject1 != null)
        {
          localObject2 = new Rect();
          ((View)localObject1).getLocalVisibleRect((Rect)localObject2);
          int i = com.tencent.mm.cd.a.fromDPToPix(getContext(), 88);
          if ((((Rect)localObject2).bottom >= 0) && (((Rect)localObject2).bottom < i))
          {
            ad.i("ContentFragment", "isFloatBarCoverVideo, ret=true, lastComp.rect=" + ((Rect)localObject2).toShortString());
            AppMethodBeat.o(97101);
            return true;
          }
        }
      }
    }
    catch (Exception localException)
    {
      ad.e("ContentFragment", "isFloatBarCoverVideo, exp=" + localException.toString());
      ad.i("ContentFragment", "isFloatBarCoverVideo, ret=false");
      AppMethodBeat.o(97101);
    }
    return false;
  }
  
  public final boolean dwR()
  {
    return (this.xeJ != null) && (this.xeJ.xhM);
  }
  
  public final void dwT()
  {
    AppMethodBeat.i(97107);
    try
    {
      if ((dwV()) && (!this.xeU))
      {
        boolean bool = this.xeZ.xfs;
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(97107);
        return;
      }
      this.xeZ.xfq.setVisibility(0);
      this.xeZ.xfq.setTranslationY(-com.tencent.mm.cd.a.fromDPToPix(getContext(), 20));
      this.xeV.setRepeatMode(2);
      this.xeV.setRepeatCount(-1);
      this.xeV.start();
      AppMethodBeat.o(97107);
      return;
    }
    catch (Exception localException)
    {
      ad.e("ContentFragment", "startDownAnimation, exp=" + localException.toString());
      AppMethodBeat.o(97107);
    }
  }
  
  public final void dwU()
  {
    AppMethodBeat.i(97108);
    try
    {
      this.xeZ.xfq.setVisibility(4);
      this.xeZ.xfq.setTranslationY(-com.tencent.mm.cd.a.fromDPToPix(getContext(), 20));
      this.xeV.setRepeatMode(2);
      this.xeV.setRepeatCount(0);
      this.xeV.end();
      AppMethodBeat.o(97108);
      return;
    }
    catch (Exception localException)
    {
      ad.e("ContentFragment", "stopDownAnimation, exp=" + localException.toString());
      AppMethodBeat.o(97108);
    }
  }
  
  public final boolean dwW()
  {
    AppMethodBeat.i(97112);
    try
    {
      aa localaa = dwZ();
      boolean bool = this.ibO;
      if ((!bool) || (localaa == null))
      {
        AppMethodBeat.o(97112);
        return true;
      }
      if (this.xeZ.fPw != null)
      {
        int i = this.xeZ.fPw.computeVerticalScrollOffset();
        int j = this.xeZ.fPw.computeVerticalScrollExtent();
        j = this.xeZ.fPw.computeVerticalScrollRange() - i - j;
        ad.d("ContentFragment", "bottomDis=" + j + ", appearBottom=" + localaa.wWV + ", topDis=" + i + ", appearTop=" + localaa.wWU + ", height=" + com.tencent.mm.cd.a.hW(getContext()));
        if (localaa.wWV > 0)
        {
          i = localaa.wWV;
          if (j < i)
          {
            AppMethodBeat.o(97112);
            return false;
          }
        }
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(97112);
    }
    return true;
  }
  
  public final boolean dwX()
  {
    AppMethodBeat.i(97113);
    try
    {
      aa localaa = dwZ();
      int i = this.xeZ.fPw.computeVerticalScrollOffset();
      if ((this.xeQ) && (localaa != null))
      {
        if ((localaa.wWU == 0) || ((localaa.wWU > 0) && (i >= localaa.wWU)))
        {
          AppMethodBeat.o(97113);
          return true;
        }
        AppMethodBeat.o(97113);
        return false;
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(97113);
    }
    return true;
  }
  
  public final RecyclerView getRecyclerView()
  {
    if (this.xeZ != null) {
      return this.xeZ.fPw;
    }
    return null;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(97094);
    super.onCreate(paramBundle);
    paramBundle = this.uLu;
    int[] arrayOfInt = al.fU(getContext());
    this.kvn = arrayOfInt[0];
    this.kvo = arrayOfInt[1];
    if (this.xeJ == null)
    {
      this.xeJ = ((g)paramBundle.get("pageInfo"));
      b(this.xeJ);
    }
    this.xeP = ((ak)paramBundle.get("pageDownIconInfo"));
    this.xeQ = bt.l((Boolean)paramBundle.get("is_first_show_page"));
    this.ibO = bt.l((Boolean)paramBundle.get("is_last_shown_page"));
    this.xeR = bt.l((Boolean)paramBundle.get("needEnterAnimation"));
    this.xeS = bt.l((Boolean)paramBundle.get("needDirectionAnimation"));
    this.xeL = bt.i(paramBundle.get("groupListCompShowIndex"), 0);
    AppMethodBeat.o(97094);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(97095);
    paramLayoutInflater = paramLayoutInflater.inflate(2131492939, paramViewGroup, false);
    this.xeZ = new b((byte)0);
    this.xeZ.frN = paramLayoutInflater;
    this.xeZ.xfo = ((ImageView)paramLayoutInflater.findViewById(2131304900));
    this.xeZ.xfp = ((OverScrollLinearout)paramLayoutInflater.findViewById(2131304922));
    if (this.ibO) {
      this.xeZ.xfp.setOnScrollActionListener(this.xfj);
    }
    this.xeZ.xfq = ((ImageView)paramLayoutInflater.findViewById(2131305020));
    this.xeZ.xfr = paramLayoutInflater.findViewById(2131305021);
    this.xeZ.xfr.setOnClickListener(this.xfg);
    this.xeZ.xfq.setOnClickListener(this.xfh);
    this.xeZ.fPw = ((RecyclerView)paramLayoutInflater.findViewById(2131298763));
    this.xeZ.xft = ((LinearLayout)paramLayoutInflater.findViewById(2131299754));
    paramViewGroup = this.xeZ.fPw;
    paramViewGroup.setOverScrollMode(0);
    int i = bt.i(this.uLu.get("pageCount"), 0);
    ad.d("ContentFragment", "initRecyclerView, pageCount=".concat(String.valueOf(i)));
    if (i > 1) {
      paramViewGroup.setOnTouchListener(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.b((DummyViewPager)this.uLu.get("viewPager")));
    }
    for (;;)
    {
      getActivity();
      this.wYJ = new LinearLayoutManager();
      paramViewGroup.setLayoutManager(this.wYJ);
      this.xfa = new a(this.xeJ, this.bgColor, getActivity(), this.wYJ);
      if (this.xeQ) {
        this.xfa.xeL = this.xeL;
      }
      paramViewGroup.setAdapter(this.xfa);
      paramViewGroup.setDescendantFocusability(131072);
      this.xeN = new c(paramViewGroup);
      paramViewGroup.a(new RecyclerView.m()
      {
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(97078);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.be(paramAnonymousRecyclerView);
          localb.lT(paramAnonymousInt1);
          localb.lT(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
          super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          if ((ContentFragment.a(ContentFragment.this).xfo != null) && (ContentFragment.a(ContentFragment.this).xfo.getVisibility() == 0)) {
            ContentFragment.a(ContentFragment.this).xfo.scrollBy(paramAnonymousInt1, paramAnonymousInt2);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(97078);
        }
        
        public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(97079);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.be(paramAnonymousRecyclerView);
          localb.lT(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
          super.b(paramAnonymousRecyclerView, paramAnonymousInt);
          ContentFragment.a(ContentFragment.this, paramAnonymousInt);
          if (paramAnonymousInt == 0)
          {
            ContentFragment.this.sW(50L);
            if (ContentFragment.b(ContentFragment.this)) {
              ContentFragment.this.dwT();
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(97079);
            return;
            if (paramAnonymousInt == 1)
            {
              ContentFragment.this.dwU();
              al.fV(ContentFragment.this.getContext());
            }
          }
        }
      });
      paramLayoutInflater.setTag(this.xeZ);
      akk();
      this.xeV = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.xeV.setDuration(this.xeO);
      this.xeV.setInterpolator(new AccelerateDecelerateInterpolator());
      this.xeV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(97084);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          ContentFragment.a(ContentFragment.this).xfq.setTranslationY((int)(f * -com.tencent.mm.cd.a.fromDPToPix(ContentFragment.this.getContext(), 20)));
          AppMethodBeat.o(97084);
        }
      });
      this.xeV.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(97086);
          ad.d("ContentFragment", "onAnimationEnd show nextBtn");
          ContentFragment.a(ContentFragment.this).xfs = false;
          AppMethodBeat.o(97086);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(97085);
          ad.d("ContentFragment", "onAnimationStart show nextBtn");
          ContentFragment.a(ContentFragment.this).xfs = true;
          AppMethodBeat.o(97085);
        }
      });
      this.xeV.setRepeatCount(-1);
      this.xeV.setRepeatMode(2);
      if ((this.xeP != null) && (!this.xeP.equals(this.xeZ.xfq.getTag())))
      {
        this.xeZ.xfq.setTag(this.xeP);
        this.xeZ.xfq.setVisibility(8);
        h.a(this.xeP.iconUrl, 1000000001, new f.a()
        {
          public final void apm(String paramAnonymousString)
          {
            AppMethodBeat.i(97088);
            ad.d("ContentFragment", "onDownloaded nextBtn");
            ContentFragment.a(ContentFragment.this, paramAnonymousString, ContentFragment.a(ContentFragment.this).xfq);
            ContentFragment.this.dwT();
            AppMethodBeat.o(97088);
          }
          
          public final void dsA()
          {
            AppMethodBeat.i(97087);
            ad.d("ContentFragment", "onDownloadError nextBtn");
            AppMethodBeat.o(97087);
          }
          
          public final void duP() {}
        });
      }
      if (this.xeY != null) {
        this.xeY.q(this);
      }
      AppMethodBeat.o(97095);
      return paramLayoutInflater;
      paramViewGroup.setOnTouchListener(null);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(97098);
    super.onDestroy();
    if (this.xeN != null) {
      this.xeN.xes.onDestroy();
    }
    dwU();
    AppMethodBeat.o(97098);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(97097);
    super.onPause();
    ad.i("ContentFragment", this + " onPause " + getUserVisibleHint());
    this.ctF = false;
    this.xeN.ctF = this.ctF;
    if ((this.xeN != null) && (getUserVisibleHint())) {
      this.xeN.dwK();
    }
    if (this.xfd) {
      try
      {
        ad.d("ContentFragmentSphereImageView", "unRegisterSphereImageCompEventReceiver, hash=" + hashCode());
        d.T(getContext()).unregisterReceiver(this.xff);
        AppMethodBeat.o(97097);
        return;
      }
      catch (Exception localException)
      {
        ad.e("ContentFragmentSphereImageView", "unRegisterSphereImageCompEventReceiver, exp:" + localException.toString());
      }
    }
    AppMethodBeat.o(97097);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(97096);
    super.onResume();
    ad.i("ContentFragment", this + " onResume " + getUserVisibleHint());
    this.ctF = true;
    Object localObject;
    if ((this.xeZ != null) && (this.xeZ.frN != null))
    {
      for (localObject = (ViewGroup)this.xeZ.frN.getParent(); (localObject != null) && ((localObject == null) || (((ViewGroup)localObject).getId() != 2131304239)); localObject = (ViewGroup)((ViewGroup)localObject).getParent()) {}
      if ((localObject instanceof FrameLayout))
      {
        int j = ((ViewGroup)localObject).getChildCount();
        int i = 0;
        while (i < j)
        {
          if ((((ViewGroup)localObject).getChildAt(i) instanceof SnsAdLandingPageFloatView)) {
            this.ctF = false;
          }
          i += 1;
        }
      }
    }
    this.xeN.ctF = this.ctF;
    if ((this.xeN != null) && (getUserVisibleHint())) {
      this.xeN.dvJ();
    }
    if (this.xfd) {
      try
      {
        ad.d("ContentFragmentSphereImageView", "registerSphereImageCompEventReceiver, hash=" + hashCode());
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_show");
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_none");
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half");
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_hide");
        d.T(getContext()).a(this.xff, (IntentFilter)localObject);
        AppMethodBeat.o(97096);
        return;
      }
      catch (Exception localException)
      {
        ad.e("ContentFragmentSphereImageView", "registerSphereImageCompEventReceiver, exp:" + localException.toString());
      }
    }
    AppMethodBeat.o(97096);
  }
  
  public final void qd(boolean paramBoolean)
  {
    AppMethodBeat.i(97110);
    this.xeU = paramBoolean;
    if ((dwV()) && (!paramBoolean))
    {
      dwT();
      AppMethodBeat.o(97110);
      return;
    }
    dwU();
    AppMethodBeat.o(97110);
  }
  
  public final void sW(long paramLong)
  {
    AppMethodBeat.i(97116);
    SnsAdNativeLandingPagesUI localSnsAdNativeLandingPagesUI = dwY();
    if (localSnsAdNativeLandingPagesUI != null) {
      localSnsAdNativeLandingPagesUI.sW(paramLong);
    }
    AppMethodBeat.o(97116);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    AppMethodBeat.i(97099);
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      if (this.xeN != null)
      {
        this.xeN.dvJ();
        AppMethodBeat.o(97099);
      }
    }
    else if (this.xeN != null) {
      this.xeN.dwK();
    }
    AppMethodBeat.o(97099);
  }
  
  public static abstract interface a
    extends Serializable
  {
    public abstract void q(ContentFragment paramContentFragment);
  }
  
  static final class b
  {
    public RecyclerView fPw;
    public View frN;
    public ImageView xfo = null;
    public OverScrollLinearout xfp = null;
    public ImageView xfq = null;
    public View xfr = null;
    public boolean xfs = false;
    LinearLayout xft;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment
 * JD-Core Version:    0.7.0.1
 */