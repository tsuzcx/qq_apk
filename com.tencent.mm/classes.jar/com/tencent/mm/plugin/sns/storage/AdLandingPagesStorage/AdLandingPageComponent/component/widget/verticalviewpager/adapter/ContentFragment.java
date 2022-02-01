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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  public boolean cqM;
  public boolean iBV;
  private int iHX;
  private int kWB;
  private int kWC;
  private ao lso;
  public Map<String, Object> vUl;
  private LinearLayoutManager ylx;
  private final Map<String, Bitmap> yoj;
  private int yrA;
  public c yrC;
  private int yrD;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al yrE;
  public boolean yrF;
  private boolean yrG;
  private boolean yrH;
  public boolean yrI;
  private boolean yrJ;
  private ValueAnimator yrK;
  private int yrL;
  public int yrM;
  public a yrN;
  private b yrO;
  private a yrP;
  private boolean yrQ;
  protected final String yrR;
  protected boolean yrS;
  protected boolean yrT;
  private BroadcastReceiver yrU;
  protected View.OnClickListener yrV;
  private View.OnClickListener yrW;
  private boolean yrX;
  private OverScrollLinearout.a yrY;
  public g yry;
  
  public ContentFragment()
  {
    AppMethodBeat.i(97093);
    this.yoj = new WeakHashMap();
    this.yrD = 1000;
    this.yrJ = false;
    this.yrR = "ContentFragmentSphereImageView";
    this.yrS = false;
    this.yrT = false;
    this.yrU = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(97091);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        ac.i("ContentFragmentSphereImageView", "onReceive, action=" + paramAnonymousContext + ", isSphereCom=" + ContentFragment.this.yrS + ", isFullScreen=" + ContentFragment.this.yrT);
        if ("com.tencent.mm.adlanding.sphereimage.next_page_view_show".equals(paramAnonymousContext))
        {
          paramAnonymousContext = ContentFragment.this.getActivity();
          if ((paramAnonymousContext instanceof SnsAdNativeLandingPagesUI))
          {
            boolean bool = ((SnsAdNativeLandingPagesUI)paramAnonymousContext).dPb();
            ac.i("ContentFragmentSphereImageView", "hasNextPage=".concat(String.valueOf(bool)));
            if (bool)
            {
              ContentFragment.a(ContentFragment.this).ysg.setVisibility(0);
              paramAnonymousContext = new AlphaAnimation(0.0F, 1.0F);
              paramAnonymousContext.setDuration(500L);
              ContentFragment.a(ContentFragment.this).ysg.startAnimation(paramAnonymousContext);
            }
          }
          AppMethodBeat.o(97091);
          return;
        }
        if ("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_none".equals(paramAnonymousContext))
        {
          if (ContentFragment.a(ContentFragment.this).ysg.getVisibility() == 0)
          {
            paramAnonymousContext = ObjectAnimator.ofFloat(ContentFragment.a(ContentFragment.this).ysg, "alpha", new float[] { 0.5F, 1.0F });
            paramAnonymousContext.setDuration(300L);
            paramAnonymousContext.start();
            AppMethodBeat.o(97091);
          }
        }
        else if ("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half".equals(paramAnonymousContext))
        {
          if (ContentFragment.a(ContentFragment.this).ysg.getVisibility() == 0)
          {
            paramAnonymousContext = ObjectAnimator.ofFloat(ContentFragment.a(ContentFragment.this).ysg, "alpha", new float[] { 1.0F, 0.5F });
            paramAnonymousContext.setDuration(300L);
            paramAnonymousContext.start();
            AppMethodBeat.o(97091);
          }
        }
        else if (("com.tencent.mm.adlanding.sphereimage.next_page_view_hide".equals(paramAnonymousContext)) && (ContentFragment.a(ContentFragment.this).ysg.getVisibility() == 0))
        {
          paramAnonymousContext = new AlphaAnimation(1.0F, 0.0F);
          paramAnonymousContext.setDuration(250L);
          paramAnonymousContext.setFillAfter(true);
          ContentFragment.a(ContentFragment.this).ysg.startAnimation(paramAnonymousContext);
        }
        AppMethodBeat.o(97091);
      }
    };
    this.yrV = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97092);
        paramAnonymousView = ContentFragment.this.getActivity();
        if ((paramAnonymousView instanceof SnsAdNativeLandingPagesUI))
        {
          ac.i("ContentFragmentSphereImageView", "jumpNextPage");
          ((SnsAdNativeLandingPagesUI)paramAnonymousView).dPa();
        }
        AppMethodBeat.o(97092);
      }
    };
    this.yrW = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(200308);
        Object localObject;
        try
        {
          paramAnonymousView = ContentFragment.this.getRecyclerView();
          if (paramAnonymousView == null)
          {
            AppMethodBeat.o(200308);
            return;
          }
          localObject = ContentFragment.this.getActivity();
          LinearLayoutManager localLinearLayoutManager;
          if ((localObject instanceof SnsAdNativeLandingPagesUI))
          {
            localObject = (SnsAdNativeLandingPagesUI)localObject;
            localLinearLayoutManager = (LinearLayoutManager)paramAnonymousView.getLayoutManager();
            if (localLinearLayoutManager == null) {
              AppMethodBeat.o(200308);
            }
          }
          else
          {
            AppMethodBeat.o(200308);
            return;
          }
          int i = localLinearLayoutManager.jY();
          int j = localLinearLayoutManager.getItemCount();
          if ((i < 0) || (j <= 0))
          {
            AppMethodBeat.o(200308);
            return;
          }
          if (i != j - 1)
          {
            ac.i("ContentFragment.VideoPlay", "By recyclerView, can scrollVertically");
            paramAnonymousView.a(0, ContentFragment.f(ContentFragment.this), null);
            AppMethodBeat.o(200308);
            return;
          }
        }
        catch (Throwable paramAnonymousView)
        {
          ac.e("ContentFragment.VideoPlay", paramAnonymousView.toString());
          AppMethodBeat.o(200308);
          return;
        }
        ac.i("ContentFragment.VideoPlay", "By recyclerView, can not scrollVertically");
        if (((SnsAdNativeLandingPagesUI)localObject).dPb())
        {
          ac.i("ContentFragment.VideoPlay", "By viewPager, jumpNextPage");
          ((SnsAdNativeLandingPagesUI)localObject).dPa();
        }
        AppMethodBeat.o(200308);
      }
    };
    this.yrX = false;
    this.yrY = new OverScrollLinearout.a()
    {
      public final void bA(float paramAnonymousFloat)
      {
        AppMethodBeat.i(200309);
        int i = (int)(paramAnonymousFloat * 0.8D);
        if (ContentFragment.a(ContentFragment.this).yse.getScrollY() + i <= 0)
        {
          AppMethodBeat.o(200309);
          return;
        }
        Object localObject = ContentFragment.m(ContentFragment.this).dLl();
        if (!(localObject instanceof m))
        {
          AppMethodBeat.o(200309);
          return;
        }
        localObject = (m)localObject;
        if (ContentFragment.a(ContentFragment.this).yse.getScrollY() + i < ((m)localObject).ynf)
        {
          ContentFragment.a(ContentFragment.this).yse.scrollBy(0, i);
          AppMethodBeat.o(200309);
          return;
        }
        if (!ContentFragment.n(ContentFragment.this))
        {
          ContentFragment.a(ContentFragment.this, true);
          ((m)localObject).dKK();
        }
        AppMethodBeat.o(200309);
      }
      
      public final void dLb()
      {
        AppMethodBeat.i(200311);
        ContentFragment.a(ContentFragment.this, false);
        AppMethodBeat.o(200311);
      }
      
      public final boolean dLz()
      {
        AppMethodBeat.i(200310);
        int i = ContentFragment.o(ContentFragment.this).jY();
        boolean bool = ContentFragment.this.getRecyclerView().canScrollVertically(1);
        k localk = ContentFragment.m(ContentFragment.this).dLl();
        if ((ContentFragment.p(ContentFragment.this)) && (!bool) && (i == ContentFragment.m(ContentFragment.this).getItemCount() - 1) && ((localk instanceof m)))
        {
          AppMethodBeat.o(200310);
          return true;
        }
        AppMethodBeat.o(200310);
        return false;
      }
    };
    AppMethodBeat.o(97093);
  }
  
  private void ajG()
  {
    AppMethodBeat.i(97103);
    if (this.yrO == null)
    {
      AppMethodBeat.o(97103);
      return;
    }
    dLr();
    final String str;
    if ((this.yry.yuu != null) && (this.yry.yuu.length() > 0))
    {
      str = this.yry.yuu;
      ac.i("ContentFragment", "bg need blur %b, url %s", new Object[] { Boolean.valueOf(this.yry.yuv), str });
      if (this.yoj.containsKey(str))
      {
        ac.i("ContentFragment", "bg has cache bitmap");
        al((Bitmap)this.yoj.get(str));
        if (this.yrP != null) {
          if ((this.yry.yuu == null) || (this.yry.yuu.length() <= 0)) {
            break label204;
          }
        }
      }
    }
    label204:
    for (this.yrP.bgColor = 0;; this.yrP.bgColor = this.bgColor)
    {
      this.yrP.a(this.yry);
      AppMethodBeat.o(97103);
      return;
      h.c("adId", str, false, 1000000001, new f.a()
      {
        public final void asD(String paramAnonymousString)
        {
          AppMethodBeat.i(97081);
          ContentFragment.a(ContentFragment.this, paramAnonymousString, "adId", str);
          AppMethodBeat.o(97081);
        }
        
        public final void dFC() {}
        
        public final void dFD()
        {
          AppMethodBeat.i(97080);
          ac.i("ContentFragment", "download img fail %s", new Object[] { str });
          ContentFragment.c(ContentFragment.this);
          AppMethodBeat.o(97080);
        }
      });
      break;
      dLr();
      break;
    }
  }
  
  private void al(Bitmap paramBitmap)
  {
    AppMethodBeat.i(97105);
    if (paramBitmap != null)
    {
      this.yrO.fvu.setBackgroundColor(0);
      this.yrO.ysd.setBackgroundColor(0);
      this.yrO.yse.setBackgroundColor(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.yrO.ysd.getLayoutParams();
      if (localLayoutParams.height >= this.kWC) {}
      for (int i = localLayoutParams.height;; i = this.kWC)
      {
        localLayoutParams.height = i;
        this.yrO.ysd.setLayoutParams(localLayoutParams);
        this.yrO.ysd.setImageBitmap(paramBitmap);
        AppMethodBeat.o(97105);
        return;
      }
    }
    dLr();
    AppMethodBeat.o(97105);
  }
  
  private void b(g paramg)
  {
    AppMethodBeat.i(97111);
    this.yrS = false;
    this.yrT = false;
    if ((paramg != null) && (paramg.yuw != null))
    {
      paramg = paramg.yuw.iterator();
      while (paramg.hasNext())
      {
        x localx = (x)paramg.next();
        if ((localx instanceof t))
        {
          paramg = (t)localx;
          if ((paramg.yjc) || (paramg.width == 0.0F) || (paramg.height == 0.0F)) {
            this.yrT = true;
          }
          this.yrS = true;
        }
      }
    }
    ac.i("ContentFragmentSphereImageView", "checkSphereImageComp, isSphereImageViewCompPage=" + this.yrS + ", isFullScreen=" + this.yrT);
    AppMethodBeat.o(97111);
  }
  
  private void dLr()
  {
    AppMethodBeat.i(97104);
    if ((this.yry.jBX != null) && (this.yry.jBX.length() > 0)) {
      ac.i("ContentFragment", "setting bg color %s", new Object[] { this.yry.jBX });
    }
    try
    {
      this.bgColor = Color.parseColor(this.yry.jBX);
      this.yrO.fvu.setBackgroundColor(this.bgColor);
      this.yrO.ysd.setBackgroundColor(this.bgColor);
      this.yrO.yse.setBackgroundColor(this.bgColor);
      AppMethodBeat.o(97104);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("ContentFragment", "the color is error : " + this.yry.jBX);
      }
    }
  }
  
  private boolean dLu()
  {
    boolean bool2 = true;
    AppMethodBeat.i(97109);
    if (!this.yrH)
    {
      AppMethodBeat.o(97109);
      return false;
    }
    if (this.yrL != 0)
    {
      AppMethodBeat.o(97109);
      return false;
    }
    if (this.yrM != 0)
    {
      AppMethodBeat.o(97109);
      return false;
    }
    if (this.yrS)
    {
      AppMethodBeat.o(97109);
      return false;
    }
    SnsAdNativeLandingPagesUI localSnsAdNativeLandingPagesUI = dLx();
    if ((localSnsAdNativeLandingPagesUI != null) && ((localSnsAdNativeLandingPagesUI.dPd()) || (localSnsAdNativeLandingPagesUI.yGU)))
    {
      AppMethodBeat.o(97109);
      return false;
    }
    int i = this.ylx.jW();
    if ((i == this.ylx.jY()) && (i == -1))
    {
      AppMethodBeat.o(97109);
      return false;
    }
    boolean bool1 = bool2;
    if (this.iBV) {
      if (this.ylx.jY() == this.yrP.getItemCount() - 1) {
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
  
  private SnsAdNativeLandingPagesUI dLx()
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
  
  private ab dLy()
  {
    AppMethodBeat.i(97115);
    Object localObject = dLx();
    if (localObject != null)
    {
      localObject = ((SnsAdNativeLandingPagesUI)localObject).yGg;
      AppMethodBeat.o(97115);
      return localObject;
    }
    AppMethodBeat.o(97115);
    return null;
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(97102);
    if (this.yry != paramg)
    {
      this.yry = paramg;
      b(paramg);
      ajG();
    }
    AppMethodBeat.o(97102);
  }
  
  public final Collection<k> dLn()
  {
    AppMethodBeat.i(97106);
    if (this.yrP == null)
    {
      localObject = Collections.EMPTY_LIST;
      AppMethodBeat.o(97106);
      return localObject;
    }
    Object localObject = this.yrP.dLn();
    AppMethodBeat.o(97106);
    return localObject;
  }
  
  public final void dLo()
  {
    AppMethodBeat.i(97100);
    if ((this.cqM) && (this.yrC != null)) {
      this.yrC.dLi();
    }
    AppMethodBeat.o(97100);
  }
  
  public final boolean dLp()
  {
    AppMethodBeat.i(97101);
    try
    {
      Object localObject1 = this.yrP.dLl();
      if ((localObject1 != null) && (((k)localObject1).dKA().type == 62))
      {
        ac.i("ContentFragment", "isFloatBarCoverVideo, ret=true, lastComp is Video");
        AppMethodBeat.o(97101);
        return true;
      }
      Object localObject2 = this.yrP.dLm();
      if ((localObject2 != null) && (((k)localObject2).dKA().type == 62) && (localObject1 != null))
      {
        localObject1 = ((k)localObject1).getContentView();
        if (localObject1 != null)
        {
          localObject2 = new Rect();
          ((View)localObject1).getLocalVisibleRect((Rect)localObject2);
          int i = com.tencent.mm.cc.a.fromDPToPix(getContext(), 88);
          if ((((Rect)localObject2).bottom >= 0) && (((Rect)localObject2).bottom < i))
          {
            ac.i("ContentFragment", "isFloatBarCoverVideo, ret=true, lastComp.rect=" + ((Rect)localObject2).toShortString());
            AppMethodBeat.o(97101);
            return true;
          }
        }
      }
    }
    catch (Exception localException)
    {
      ac.e("ContentFragment", "isFloatBarCoverVideo, exp=" + localException.toString());
      ac.i("ContentFragment", "isFloatBarCoverVideo, ret=false");
      AppMethodBeat.o(97101);
    }
    return false;
  }
  
  public final boolean dLq()
  {
    return (this.yry != null) && (this.yry.yuA);
  }
  
  public final void dLs()
  {
    AppMethodBeat.i(97107);
    try
    {
      if ((dLu()) && (!this.yrJ))
      {
        boolean bool = this.yrO.ysh;
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(97107);
        return;
      }
      this.yrO.ysf.setVisibility(0);
      this.yrO.ysf.setTranslationY(-com.tencent.mm.cc.a.fromDPToPix(getContext(), 20));
      this.yrK.setRepeatMode(2);
      this.yrK.setRepeatCount(-1);
      this.yrK.start();
      AppMethodBeat.o(97107);
      return;
    }
    catch (Exception localException)
    {
      ac.e("ContentFragment", "startDownAnimation, exp=" + localException.toString());
      AppMethodBeat.o(97107);
    }
  }
  
  public final void dLt()
  {
    AppMethodBeat.i(97108);
    try
    {
      this.yrO.ysf.setVisibility(4);
      this.yrO.ysf.setTranslationY(-com.tencent.mm.cc.a.fromDPToPix(getContext(), 20));
      this.yrK.setRepeatMode(2);
      this.yrK.setRepeatCount(0);
      this.yrK.end();
      AppMethodBeat.o(97108);
      return;
    }
    catch (Exception localException)
    {
      ac.e("ContentFragment", "stopDownAnimation, exp=" + localException.toString());
      AppMethodBeat.o(97108);
    }
  }
  
  public final boolean dLv()
  {
    AppMethodBeat.i(97112);
    try
    {
      ab localab = dLy();
      boolean bool = this.iBV;
      if ((!bool) || (localab == null))
      {
        AppMethodBeat.o(97112);
        return true;
      }
      if (this.yrO.fTr != null)
      {
        int i = this.yrO.fTr.computeVerticalScrollOffset();
        int j = this.yrO.fTr.computeVerticalScrollExtent();
        j = this.yrO.fTr.computeVerticalScrollRange() - i - j;
        ac.d("ContentFragment", "bottomDis=" + j + ", appearBottom=" + localab.yjK + ", topDis=" + i + ", appearTop=" + localab.yjJ + ", height=" + com.tencent.mm.cc.a.ih(getContext()));
        if (localab.yjK > 0)
        {
          i = localab.yjK;
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
  
  public final boolean dLw()
  {
    AppMethodBeat.i(97113);
    try
    {
      ab localab = dLy();
      int i = this.yrO.fTr.computeVerticalScrollOffset();
      if ((this.yrF) && (localab != null))
      {
        if ((localab.yjJ == 0) || ((localab.yjJ > 0) && (i >= localab.yjJ)))
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
    if (this.yrO != null) {
      return this.yrO.fTr;
    }
    return null;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(97094);
    super.onCreate(paramBundle);
    paramBundle = this.vUl;
    int[] arrayOfInt = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al.gg(getContext());
    this.kWB = arrayOfInt[0];
    this.kWC = arrayOfInt[1];
    if (this.yry == null)
    {
      this.yry = ((g)paramBundle.get("pageInfo"));
      b(this.yry);
    }
    this.yrE = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al)paramBundle.get("pageDownIconInfo"));
    this.yrF = bs.l((Boolean)paramBundle.get("is_first_show_page"));
    this.iBV = bs.l((Boolean)paramBundle.get("is_last_shown_page"));
    this.yrG = bs.l((Boolean)paramBundle.get("needEnterAnimation"));
    this.yrH = bs.l((Boolean)paramBundle.get("needDirectionAnimation"));
    this.yrA = bs.l(paramBundle.get("groupListCompShowIndex"), 0);
    AppMethodBeat.o(97094);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(97095);
    paramLayoutInflater = paramLayoutInflater.inflate(2131492939, paramViewGroup, false);
    this.yrO = new b((byte)0);
    this.yrO.fvu = paramLayoutInflater;
    this.yrO.ysd = ((ImageView)paramLayoutInflater.findViewById(2131304900));
    this.yrO.yse = ((OverScrollLinearout)paramLayoutInflater.findViewById(2131304922));
    if (this.iBV) {
      this.yrO.yse.setOnScrollActionListener(this.yrY);
    }
    this.yrO.ysf = ((ImageView)paramLayoutInflater.findViewById(2131305020));
    this.yrO.ysg = paramLayoutInflater.findViewById(2131305021);
    this.yrO.ysg.setOnClickListener(this.yrV);
    this.yrO.ysf.setOnClickListener(this.yrW);
    this.yrO.fTr = ((RecyclerView)paramLayoutInflater.findViewById(2131298763));
    this.yrO.ysi = ((LinearLayout)paramLayoutInflater.findViewById(2131299754));
    paramViewGroup = this.yrO.fTr;
    paramViewGroup.setOverScrollMode(0);
    int i = bs.l(this.vUl.get("pageCount"), 0);
    ac.d("ContentFragment", "initRecyclerView, pageCount=".concat(String.valueOf(i)));
    if (i > 1) {
      paramViewGroup.setOnTouchListener(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.b((DummyViewPager)this.vUl.get("viewPager")));
    }
    for (;;)
    {
      getActivity();
      this.ylx = new LinearLayoutManager();
      paramViewGroup.setLayoutManager(this.ylx);
      this.yrP = new a(this.yry, this.bgColor, getActivity(), this.ylx);
      if (this.yrF) {
        this.yrP.yrA = this.yrA;
      }
      paramViewGroup.setAdapter(this.yrP);
      paramViewGroup.setDescendantFocusability(131072);
      this.yrC = new c(paramViewGroup);
      paramViewGroup.a(new RecyclerView.m()
      {
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(97078);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bb(paramAnonymousRecyclerView);
          localb.lS(paramAnonymousInt1);
          localb.lS(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
          super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          if ((ContentFragment.a(ContentFragment.this).ysd != null) && (ContentFragment.a(ContentFragment.this).ysd.getVisibility() == 0)) {
            ContentFragment.a(ContentFragment.this).ysd.scrollBy(paramAnonymousInt1, paramAnonymousInt2);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(97078);
        }
        
        public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(97079);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bb(paramAnonymousRecyclerView);
          localb.lS(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
          super.b(paramAnonymousRecyclerView, paramAnonymousInt);
          ContentFragment.a(ContentFragment.this, paramAnonymousInt);
          if (paramAnonymousInt == 0)
          {
            ContentFragment.this.xz(50L);
            if (ContentFragment.b(ContentFragment.this)) {
              ContentFragment.this.dLs();
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(97079);
            return;
            if (paramAnonymousInt == 1)
            {
              ContentFragment.this.dLt();
              com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al.gh(ContentFragment.this.getContext());
            }
          }
        }
      });
      paramLayoutInflater.setTag(this.yrO);
      ajG();
      this.yrK = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.yrK.setDuration(this.yrD);
      this.yrK.setInterpolator(new AccelerateDecelerateInterpolator());
      this.yrK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(97084);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          ContentFragment.a(ContentFragment.this).ysf.setTranslationY((int)(f * -com.tencent.mm.cc.a.fromDPToPix(ContentFragment.this.getContext(), 20)));
          AppMethodBeat.o(97084);
        }
      });
      this.yrK.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(97086);
          ac.d("ContentFragment", "onAnimationEnd show nextBtn");
          ContentFragment.a(ContentFragment.this).ysh = false;
          AppMethodBeat.o(97086);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(97085);
          ac.d("ContentFragment", "onAnimationStart show nextBtn");
          ContentFragment.a(ContentFragment.this).ysh = true;
          AppMethodBeat.o(97085);
        }
      });
      this.yrK.setRepeatCount(-1);
      this.yrK.setRepeatMode(2);
      if ((this.yrE != null) && (!this.yrE.equals(this.yrO.ysf.getTag())))
      {
        this.yrO.ysf.setTag(this.yrE);
        this.yrO.ysf.setVisibility(8);
        h.a(this.yrE.iconUrl, 1000000001, new f.a()
        {
          public final void asD(String paramAnonymousString)
          {
            AppMethodBeat.i(97088);
            ac.d("ContentFragment", "onDownloaded nextBtn");
            ContentFragment.a(ContentFragment.this, paramAnonymousString, ContentFragment.a(ContentFragment.this).ysf);
            ContentFragment.this.dLs();
            AppMethodBeat.o(97088);
          }
          
          public final void dFC() {}
          
          public final void dFD()
          {
            AppMethodBeat.i(97087);
            ac.d("ContentFragment", "onDownloadError nextBtn");
            AppMethodBeat.o(97087);
          }
        });
      }
      if (this.yrN != null) {
        this.yrN.q(this);
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
    if (this.yrC != null) {
      this.yrC.yrh.onDestroy();
    }
    dLt();
    AppMethodBeat.o(97098);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(97097);
    super.onPause();
    ac.i("ContentFragment", this + " onPause " + getUserVisibleHint());
    this.cqM = false;
    this.yrC.cqM = this.cqM;
    if ((this.yrC != null) && (getUserVisibleHint())) {
      this.yrC.dLj();
    }
    if (this.yrS) {
      try
      {
        ac.d("ContentFragmentSphereImageView", "unRegisterSphereImageCompEventReceiver, hash=" + hashCode());
        d.U(getContext()).unregisterReceiver(this.yrU);
        AppMethodBeat.o(97097);
        return;
      }
      catch (Exception localException)
      {
        ac.e("ContentFragmentSphereImageView", "unRegisterSphereImageCompEventReceiver, exp:" + localException.toString());
      }
    }
    AppMethodBeat.o(97097);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(97096);
    super.onResume();
    ac.i("ContentFragment", this + " onResume " + getUserVisibleHint());
    this.cqM = true;
    Object localObject;
    if ((this.yrO != null) && (this.yrO.fvu != null))
    {
      for (localObject = (ViewGroup)this.yrO.fvu.getParent(); (localObject != null) && ((localObject == null) || (((ViewGroup)localObject).getId() != 2131304239)); localObject = (ViewGroup)((ViewGroup)localObject).getParent()) {}
      if ((localObject instanceof FrameLayout))
      {
        int j = ((ViewGroup)localObject).getChildCount();
        int i = 0;
        while (i < j)
        {
          if ((((ViewGroup)localObject).getChildAt(i) instanceof SnsAdLandingPageFloatView)) {
            this.cqM = false;
          }
          i += 1;
        }
      }
    }
    this.yrC.cqM = this.cqM;
    if ((this.yrC != null) && (getUserVisibleHint())) {
      this.yrC.dKi();
    }
    if (this.yrS) {
      try
      {
        ac.d("ContentFragmentSphereImageView", "registerSphereImageCompEventReceiver, hash=" + hashCode());
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_show");
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_none");
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half");
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_hide");
        d.U(getContext()).a(this.yrU, (IntentFilter)localObject);
        AppMethodBeat.o(97096);
        return;
      }
      catch (Exception localException)
      {
        ac.e("ContentFragmentSphereImageView", "registerSphereImageCompEventReceiver, exp:" + localException.toString());
      }
    }
    AppMethodBeat.o(97096);
  }
  
  public final void rc(boolean paramBoolean)
  {
    AppMethodBeat.i(97110);
    this.yrJ = paramBoolean;
    if ((dLu()) && (!paramBoolean))
    {
      dLs();
      AppMethodBeat.o(97110);
      return;
    }
    dLt();
    AppMethodBeat.o(97110);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    AppMethodBeat.i(97099);
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      if (this.yrC != null)
      {
        this.yrC.dKi();
        AppMethodBeat.o(97099);
      }
    }
    else if (this.yrC != null) {
      this.yrC.dLj();
    }
    AppMethodBeat.o(97099);
  }
  
  public final void xz(long paramLong)
  {
    AppMethodBeat.i(97116);
    SnsAdNativeLandingPagesUI localSnsAdNativeLandingPagesUI = dLx();
    if (localSnsAdNativeLandingPagesUI != null) {
      localSnsAdNativeLandingPagesUI.xz(paramLong);
    }
    AppMethodBeat.o(97116);
  }
  
  public static abstract interface a
    extends Serializable
  {
    public abstract void q(ContentFragment paramContentFragment);
  }
  
  static final class b
  {
    public RecyclerView fTr;
    public View fvu;
    public ImageView ysd = null;
    public OverScrollLinearout yse = null;
    public ImageView ysf = null;
    public View ysg = null;
    public boolean ysh = false;
    LinearLayout ysi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment
 * JD-Core Version:    0.7.0.1
 */