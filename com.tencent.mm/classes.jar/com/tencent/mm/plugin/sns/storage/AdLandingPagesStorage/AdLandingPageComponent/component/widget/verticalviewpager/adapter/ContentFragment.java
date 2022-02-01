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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.DummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView;
import com.tencent.mm.plugin.sns.ui.widget.ad.OverScrollLinearout;
import com.tencent.mm.plugin.sns.ui.widget.ad.OverScrollLinearout.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
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
  public boolean cBJ;
  public boolean iVf;
  private int jbg;
  private ap lRx;
  private int ltA;
  private int ltB;
  public Map<String, Object> xaW;
  private LinearLayoutManager zCm;
  private final Map<String, Bitmap> zFe;
  public com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g zII;
  private int zIK;
  public c zIM;
  private int zIN;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am zIO;
  public boolean zIP;
  private boolean zIQ;
  private boolean zIR;
  public boolean zIS;
  private boolean zIT;
  private ValueAnimator zIU;
  private int zIV;
  public int zIW;
  public a zIX;
  private b zIY;
  private a zIZ;
  private boolean zJa;
  protected final String zJb;
  protected boolean zJc;
  protected boolean zJd;
  private BroadcastReceiver zJe;
  protected View.OnClickListener zJf;
  private View.OnClickListener zJg;
  private boolean zJh;
  private OverScrollLinearout.a zJi;
  
  public ContentFragment()
  {
    AppMethodBeat.i(97093);
    this.zFe = new WeakHashMap();
    this.zIN = 1000;
    this.zIT = false;
    this.zJb = "ContentFragmentSphereImageView";
    this.zJc = false;
    this.zJd = false;
    this.zJe = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(97091);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        ad.i("ContentFragmentSphereImageView", "onReceive, action=" + paramAnonymousContext + ", isSphereCom=" + ContentFragment.this.zJc + ", isFullScreen=" + ContentFragment.this.zJd);
        if ("com.tencent.mm.adlanding.sphereimage.next_page_view_show".equals(paramAnonymousContext))
        {
          paramAnonymousContext = ContentFragment.this.getActivity();
          if ((paramAnonymousContext instanceof SnsAdNativeLandingPagesUI))
          {
            boolean bool = ((SnsAdNativeLandingPagesUI)paramAnonymousContext).ebr();
            ad.i("ContentFragmentSphereImageView", "hasNextPage=".concat(String.valueOf(bool)));
            if (bool)
            {
              ContentFragment.a(ContentFragment.this).zJq.setVisibility(0);
              paramAnonymousContext = new AlphaAnimation(0.0F, 1.0F);
              paramAnonymousContext.setDuration(500L);
              ContentFragment.a(ContentFragment.this).zJq.startAnimation(paramAnonymousContext);
            }
          }
          AppMethodBeat.o(97091);
          return;
        }
        if ("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_none".equals(paramAnonymousContext))
        {
          if (ContentFragment.a(ContentFragment.this).zJq.getVisibility() == 0)
          {
            paramAnonymousContext = ObjectAnimator.ofFloat(ContentFragment.a(ContentFragment.this).zJq, "alpha", new float[] { 0.5F, 1.0F });
            paramAnonymousContext.setDuration(300L);
            paramAnonymousContext.start();
            AppMethodBeat.o(97091);
          }
        }
        else if ("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half".equals(paramAnonymousContext))
        {
          if (ContentFragment.a(ContentFragment.this).zJq.getVisibility() == 0)
          {
            paramAnonymousContext = ObjectAnimator.ofFloat(ContentFragment.a(ContentFragment.this).zJq, "alpha", new float[] { 1.0F, 0.5F });
            paramAnonymousContext.setDuration(300L);
            paramAnonymousContext.start();
            AppMethodBeat.o(97091);
          }
        }
        else if (("com.tencent.mm.adlanding.sphereimage.next_page_view_hide".equals(paramAnonymousContext)) && (ContentFragment.a(ContentFragment.this).zJq.getVisibility() == 0))
        {
          paramAnonymousContext = new AlphaAnimation(1.0F, 0.0F);
          paramAnonymousContext.setDuration(250L);
          paramAnonymousContext.setFillAfter(true);
          ContentFragment.a(ContentFragment.this).zJq.startAnimation(paramAnonymousContext);
        }
        AppMethodBeat.o(97091);
      }
    };
    this.zJf = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97092);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = ContentFragment.this.getActivity();
        if ((paramAnonymousView instanceof SnsAdNativeLandingPagesUI))
        {
          ad.i("ContentFragmentSphereImageView", "jumpNextPage");
          ((SnsAdNativeLandingPagesUI)paramAnonymousView).ebq();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97092);
      }
    };
    this.zJg = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198093);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        for (;;)
        {
          try
          {
            paramAnonymousView = ContentFragment.this.getRecyclerView();
            if (paramAnonymousView == null)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(198093);
              return;
            }
            localObject = ContentFragment.this.getActivity();
            LinearLayoutManager localLinearLayoutManager;
            if ((localObject instanceof SnsAdNativeLandingPagesUI))
            {
              localObject = (SnsAdNativeLandingPagesUI)localObject;
              localLinearLayoutManager = (LinearLayoutManager)paramAnonymousView.getLayoutManager();
              if (localLinearLayoutManager == null)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(198093);
              }
            }
            else
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(198093);
              return;
            }
            int i = localLinearLayoutManager.ko();
            int j = localLinearLayoutManager.getItemCount();
            if ((i < 0) || (j <= 0))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(198093);
              return;
            }
            if (i == j - 1) {
              continue;
            }
            ad.i("ContentFragment.VideoPlay", "By recyclerView, can scrollVertically");
            paramAnonymousView.a(0, ContentFragment.f(ContentFragment.this), null);
          }
          catch (Throwable paramAnonymousView)
          {
            ad.e("ContentFragment.VideoPlay", paramAnonymousView.toString());
            continue;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198093);
          return;
          ad.i("ContentFragment.VideoPlay", "By recyclerView, can not scrollVertically");
          if (((SnsAdNativeLandingPagesUI)localObject).ebr())
          {
            ad.i("ContentFragment.VideoPlay", "By viewPager, jumpNextPage");
            ((SnsAdNativeLandingPagesUI)localObject).ebq();
          }
        }
      }
    };
    this.zJh = false;
    this.zJi = new OverScrollLinearout.a()
    {
      public final void bD(float paramAnonymousFloat)
      {
        AppMethodBeat.i(198094);
        int i = (int)(paramAnonymousFloat * 0.8D);
        if (ContentFragment.a(ContentFragment.this).zJo.getScrollY() + i <= 0)
        {
          AppMethodBeat.o(198094);
          return;
        }
        Object localObject = ContentFragment.m(ContentFragment.this).dXC();
        if (!(localObject instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n))
        {
          AppMethodBeat.o(198094);
          return;
        }
        localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n)localObject;
        if (ContentFragment.a(ContentFragment.this).zJo.getScrollY() + i < ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n)localObject).zDZ)
        {
          ContentFragment.a(ContentFragment.this).zJo.scrollBy(0, i);
          AppMethodBeat.o(198094);
          return;
        }
        if (!ContentFragment.n(ContentFragment.this))
        {
          ContentFragment.a(ContentFragment.this, true);
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n)localObject).dXc();
        }
        AppMethodBeat.o(198094);
      }
      
      public final boolean dXQ()
      {
        AppMethodBeat.i(198095);
        int i = ContentFragment.o(ContentFragment.this).ko();
        boolean bool = ContentFragment.this.getRecyclerView().canScrollVertically(1);
        l locall = ContentFragment.m(ContentFragment.this).dXC();
        if ((ContentFragment.p(ContentFragment.this)) && (!bool) && (i == ContentFragment.m(ContentFragment.this).getItemCount() - 1) && ((locall instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n)))
        {
          AppMethodBeat.o(198095);
          return true;
        }
        AppMethodBeat.o(198095);
        return false;
      }
      
      public final void dXs()
      {
        AppMethodBeat.i(198096);
        ContentFragment.a(ContentFragment.this, false);
        AppMethodBeat.o(198096);
      }
    };
    AppMethodBeat.o(97093);
  }
  
  private void ams()
  {
    AppMethodBeat.i(97103);
    if (this.zIY == null)
    {
      AppMethodBeat.o(97103);
      return;
    }
    dXI();
    final String str;
    if ((this.zII.zLH != null) && (this.zII.zLH.length() > 0))
    {
      str = this.zII.zLH;
      ad.i("ContentFragment", "bg need blur %b, url %s", new Object[] { Boolean.valueOf(this.zII.zLI), str });
      if (this.zFe.containsKey(str))
      {
        ad.i("ContentFragment", "bg has cache bitmap");
        an((Bitmap)this.zFe.get(str));
        if (this.zIZ != null) {
          if ((this.zII.zLH == null) || (this.zII.zLH.length() <= 0)) {
            break label204;
          }
        }
      }
    }
    label204:
    for (this.zIZ.bgColor = 0;; this.zIZ.bgColor = this.bgColor)
    {
      this.zIZ.a(this.zII);
      AppMethodBeat.o(97103);
      return;
      h.c("adId", str, false, 1000000001, new f.a()
      {
        public final void axG(String paramAnonymousString)
        {
          AppMethodBeat.i(97081);
          ContentFragment.a(ContentFragment.this, paramAnonymousString, "adId", str);
          AppMethodBeat.o(97081);
        }
        
        public final void dRW() {}
        
        public final void dRX()
        {
          AppMethodBeat.i(97080);
          ad.i("ContentFragment", "download img fail %s", new Object[] { str });
          ContentFragment.c(ContentFragment.this);
          AppMethodBeat.o(97080);
        }
      });
      break;
      dXI();
      break;
    }
  }
  
  private void an(Bitmap paramBitmap)
  {
    AppMethodBeat.i(97105);
    if (paramBitmap != null)
    {
      this.zIY.fOB.setBackgroundColor(0);
      this.zIY.zJn.setBackgroundColor(0);
      this.zIY.zJo.setBackgroundColor(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.zIY.zJn.getLayoutParams();
      if (localLayoutParams.height >= this.ltB) {}
      for (int i = localLayoutParams.height;; i = this.ltB)
      {
        localLayoutParams.height = i;
        this.zIY.zJn.setLayoutParams(localLayoutParams);
        this.zIY.zJn.setImageBitmap(paramBitmap);
        AppMethodBeat.o(97105);
        return;
      }
    }
    dXI();
    AppMethodBeat.o(97105);
  }
  
  private void b(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g paramg)
  {
    AppMethodBeat.i(97111);
    this.zJc = false;
    this.zJd = false;
    if ((paramg != null) && (paramg.zLJ != null))
    {
      paramg = paramg.zLJ.iterator();
      while (paramg.hasNext())
      {
        x localx = (x)paramg.next();
        if ((localx instanceof t))
        {
          paramg = (t)localx;
          if ((paramg.zzK) || (paramg.width == 0.0F) || (paramg.height == 0.0F)) {
            this.zJd = true;
          }
          this.zJc = true;
        }
      }
    }
    ad.i("ContentFragmentSphereImageView", "checkSphereImageComp, isSphereImageViewCompPage=" + this.zJc + ", isFullScreen=" + this.zJd);
    AppMethodBeat.o(97111);
  }
  
  private void dXI()
  {
    AppMethodBeat.i(97104);
    if ((this.zII.jVX != null) && (this.zII.jVX.length() > 0)) {
      ad.i("ContentFragment", "setting bg color %s", new Object[] { this.zII.jVX });
    }
    try
    {
      this.bgColor = Color.parseColor(this.zII.jVX);
      this.zIY.fOB.setBackgroundColor(this.bgColor);
      this.zIY.zJn.setBackgroundColor(this.bgColor);
      this.zIY.zJo.setBackgroundColor(this.bgColor);
      AppMethodBeat.o(97104);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("ContentFragment", "the color is error : " + this.zII.jVX);
      }
    }
  }
  
  private boolean dXL()
  {
    boolean bool2 = true;
    AppMethodBeat.i(97109);
    if (!this.zIR)
    {
      AppMethodBeat.o(97109);
      return false;
    }
    if (this.zIV != 0)
    {
      AppMethodBeat.o(97109);
      return false;
    }
    if (this.zIW != 0)
    {
      AppMethodBeat.o(97109);
      return false;
    }
    if (this.zJc)
    {
      AppMethodBeat.o(97109);
      return false;
    }
    SnsAdNativeLandingPagesUI localSnsAdNativeLandingPagesUI = dXO();
    if ((localSnsAdNativeLandingPagesUI != null) && ((localSnsAdNativeLandingPagesUI.ebu()) || (localSnsAdNativeLandingPagesUI.zYn)))
    {
      AppMethodBeat.o(97109);
      return false;
    }
    int i = this.zCm.km();
    if ((i == this.zCm.ko()) && (i == -1))
    {
      AppMethodBeat.o(97109);
      return false;
    }
    boolean bool1 = bool2;
    if (this.iVf) {
      if (this.zCm.ko() == this.zIZ.getItemCount() - 1) {
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
  
  private SnsAdNativeLandingPagesUI dXO()
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
  
  private ab dXP()
  {
    AppMethodBeat.i(97115);
    Object localObject = dXO();
    if (localObject != null)
    {
      localObject = ((SnsAdNativeLandingPagesUI)localObject).zXy;
      AppMethodBeat.o(97115);
      return localObject;
    }
    AppMethodBeat.o(97115);
    return null;
  }
  
  public final void a(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g paramg)
  {
    AppMethodBeat.i(97102);
    if (this.zII != paramg)
    {
      this.zII = paramg;
      b(paramg);
      ams();
    }
    AppMethodBeat.o(97102);
  }
  
  public final Collection<l> dXE()
  {
    AppMethodBeat.i(97106);
    if (this.zIZ == null)
    {
      localObject = Collections.EMPTY_LIST;
      AppMethodBeat.o(97106);
      return localObject;
    }
    Object localObject = this.zIZ.dXE();
    AppMethodBeat.o(97106);
    return localObject;
  }
  
  public final void dXF()
  {
    AppMethodBeat.i(97100);
    if ((this.cBJ) && (this.zIM != null)) {
      this.zIM.dXz();
    }
    AppMethodBeat.o(97100);
  }
  
  public final boolean dXG()
  {
    AppMethodBeat.i(97101);
    try
    {
      Object localObject1 = this.zIZ.dXC();
      if ((localObject1 != null) && ((((l)localObject1).dWS().type == 62) || (((l)localObject1).dWS().type == 61)))
      {
        ad.i("ContentFragment", "isFloatBarCoverVideo, ret=true, lastComp is Video");
        AppMethodBeat.o(97101);
        return true;
      }
      Object localObject2 = this.zIZ.dXD();
      if ((localObject2 != null) && ((((l)localObject2).dWS().type == 62) || (((l)localObject2).dWS().type == 61)) && (localObject1 != null))
      {
        localObject1 = ((l)localObject1).contentView;
        if (localObject1 != null)
        {
          localObject2 = new Rect();
          ((View)localObject1).getLocalVisibleRect((Rect)localObject2);
          int i = com.tencent.mm.cc.a.fromDPToPix(getContext(), 88);
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
  
  public final boolean dXH()
  {
    return (this.zII != null) && (this.zII.zLN);
  }
  
  public final void dXJ()
  {
    AppMethodBeat.i(97107);
    try
    {
      if ((dXL()) && (!this.zIT))
      {
        boolean bool = this.zIY.zJr;
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(97107);
        return;
      }
      this.zIY.zJp.setVisibility(0);
      this.zIY.zJp.setTranslationY(-com.tencent.mm.cc.a.fromDPToPix(getContext(), 20));
      this.zIU.setRepeatMode(2);
      this.zIU.setRepeatCount(-1);
      this.zIU.start();
      AppMethodBeat.o(97107);
      return;
    }
    catch (Exception localException)
    {
      ad.e("ContentFragment", "startDownAnimation, exp=" + localException.toString());
      AppMethodBeat.o(97107);
    }
  }
  
  public final void dXK()
  {
    AppMethodBeat.i(97108);
    try
    {
      this.zIY.zJp.setVisibility(4);
      this.zIY.zJp.setTranslationY(-com.tencent.mm.cc.a.fromDPToPix(getContext(), 20));
      this.zIU.setRepeatMode(2);
      this.zIU.setRepeatCount(0);
      this.zIU.end();
      AppMethodBeat.o(97108);
      return;
    }
    catch (Exception localException)
    {
      ad.e("ContentFragment", "stopDownAnimation, exp=" + localException.toString());
      AppMethodBeat.o(97108);
    }
  }
  
  public final boolean dXM()
  {
    AppMethodBeat.i(97112);
    try
    {
      ab localab = dXP();
      boolean bool = this.iVf;
      if ((!bool) || (localab == null))
      {
        AppMethodBeat.o(97112);
        return true;
      }
      if (this.zIY.gmV != null)
      {
        int i = this.zIY.gmV.computeVerticalScrollOffset();
        int j = this.zIY.gmV.computeVerticalScrollExtent();
        j = this.zIY.gmV.computeVerticalScrollRange() - i - j;
        ad.d("ContentFragment", "bottomDis=" + j + ", appearBottom=" + localab.zAz + ", topDis=" + i + ", appearTop=" + localab.zAy + ", height=" + com.tencent.mm.cc.a.iq(getContext()));
        if (localab.zAz > 0)
        {
          i = localab.zAz;
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
  
  public final boolean dXN()
  {
    AppMethodBeat.i(97113);
    try
    {
      ab localab = dXP();
      int i = this.zIY.gmV.computeVerticalScrollOffset();
      if ((this.zIP) && (localab != null))
      {
        if ((localab.zAy == 0) || ((localab.zAy > 0) && (i >= localab.zAy)))
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
    if (this.zIY != null) {
      return this.zIY.gmV;
    }
    return null;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(97094);
    super.onCreate(paramBundle);
    paramBundle = this.xaW;
    int[] arrayOfInt = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am.gk(getContext());
    this.ltA = arrayOfInt[0];
    this.ltB = arrayOfInt[1];
    if (this.zII == null)
    {
      this.zII = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g)paramBundle.get("pageInfo"));
      b(this.zII);
    }
    this.zIO = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am)paramBundle.get("pageDownIconInfo"));
    this.zIP = bt.o((Boolean)paramBundle.get("is_first_show_page"));
    this.iVf = bt.o((Boolean)paramBundle.get("is_last_shown_page"));
    this.zIQ = bt.o((Boolean)paramBundle.get("needEnterAnimation"));
    this.zIR = bt.o((Boolean)paramBundle.get("needDirectionAnimation"));
    this.zIK = bt.m(paramBundle.get("groupListCompShowIndex"), 0);
    AppMethodBeat.o(97094);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(97095);
    paramLayoutInflater = paramLayoutInflater.inflate(2131492939, paramViewGroup, false);
    this.zIY = new b((byte)0);
    this.zIY.fOB = paramLayoutInflater;
    this.zIY.zJn = ((ImageView)paramLayoutInflater.findViewById(2131304900));
    this.zIY.zJo = ((OverScrollLinearout)paramLayoutInflater.findViewById(2131304922));
    if (this.iVf) {
      this.zIY.zJo.setOnScrollActionListener(this.zJi);
    }
    this.zIY.zJp = ((ImageView)paramLayoutInflater.findViewById(2131305020));
    this.zIY.zJq = paramLayoutInflater.findViewById(2131305021);
    this.zIY.zJq.setOnClickListener(this.zJf);
    this.zIY.zJp.setOnClickListener(this.zJg);
    this.zIY.gmV = ((RecyclerView)paramLayoutInflater.findViewById(2131298763));
    this.zIY.zJs = ((LinearLayout)paramLayoutInflater.findViewById(2131299754));
    paramViewGroup = this.zIY.gmV;
    paramViewGroup.setOverScrollMode(0);
    int i = bt.m(this.xaW.get("pageCount"), 0);
    ad.d("ContentFragment", "initRecyclerView, pageCount=".concat(String.valueOf(i)));
    if (i > 1) {
      paramViewGroup.setOnTouchListener(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.b((DummyViewPager)this.xaW.get("viewPager")));
    }
    for (;;)
    {
      getActivity();
      this.zCm = new LinearLayoutManager();
      paramViewGroup.setLayoutManager(this.zCm);
      this.zIZ = new a(this.zII, this.bgColor, getActivity(), this.zCm);
      if (this.zIP) {
        this.zIZ.zIK = this.zIK;
      }
      paramViewGroup.setAdapter(this.zIZ);
      paramViewGroup.setDescendantFocusability(131072);
      this.zIM = new c(paramViewGroup);
      paramViewGroup.a(new RecyclerView.m()
      {
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(97078);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousRecyclerView);
          localb.mr(paramAnonymousInt1);
          localb.mr(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
          super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          if ((ContentFragment.a(ContentFragment.this).zJn != null) && (ContentFragment.a(ContentFragment.this).zJn.getVisibility() == 0)) {
            ContentFragment.a(ContentFragment.this).zJn.scrollBy(paramAnonymousInt1, paramAnonymousInt2);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(97078);
        }
        
        public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(97079);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousRecyclerView);
          localb.mr(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
          super.b(paramAnonymousRecyclerView, paramAnonymousInt);
          ContentFragment.a(ContentFragment.this, paramAnonymousInt);
          if (paramAnonymousInt == 0)
          {
            ContentFragment.this.zX(50L);
            if (ContentFragment.b(ContentFragment.this)) {
              ContentFragment.this.dXJ();
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(97079);
            return;
            if (paramAnonymousInt == 1)
            {
              ContentFragment.this.dXK();
              com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am.gl(ContentFragment.this.getContext());
            }
          }
        }
      });
      paramLayoutInflater.setTag(this.zIY);
      ams();
      this.zIU = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.zIU.setDuration(this.zIN);
      this.zIU.setInterpolator(new AccelerateDecelerateInterpolator());
      this.zIU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(97084);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          ContentFragment.a(ContentFragment.this).zJp.setTranslationY((int)(f * -com.tencent.mm.cc.a.fromDPToPix(ContentFragment.this.getContext(), 20)));
          AppMethodBeat.o(97084);
        }
      });
      this.zIU.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(97086);
          ad.d("ContentFragment", "onAnimationEnd show nextBtn");
          ContentFragment.a(ContentFragment.this).zJr = false;
          AppMethodBeat.o(97086);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(97085);
          ad.d("ContentFragment", "onAnimationStart show nextBtn");
          ContentFragment.a(ContentFragment.this).zJr = true;
          AppMethodBeat.o(97085);
        }
      });
      this.zIU.setRepeatCount(-1);
      this.zIU.setRepeatMode(2);
      if ((this.zIO != null) && (!this.zIO.equals(this.zIY.zJp.getTag())))
      {
        this.zIY.zJp.setTag(this.zIO);
        this.zIY.zJp.setVisibility(8);
        h.a(this.zIO.iconUrl, 1000000001, new f.a()
        {
          public final void axG(String paramAnonymousString)
          {
            AppMethodBeat.i(97088);
            ad.d("ContentFragment", "onDownloaded nextBtn");
            ContentFragment.a(ContentFragment.this, paramAnonymousString, ContentFragment.a(ContentFragment.this).zJp);
            ContentFragment.this.dXJ();
            AppMethodBeat.o(97088);
          }
          
          public final void dRW() {}
          
          public final void dRX()
          {
            AppMethodBeat.i(97087);
            ad.d("ContentFragment", "onDownloadError nextBtn");
            AppMethodBeat.o(97087);
          }
        });
      }
      if (this.zIX != null) {
        this.zIX.q(this);
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
    if (this.zIM != null) {
      this.zIM.zIr.onDestroy();
    }
    dXK();
    AppMethodBeat.o(97098);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(97097);
    super.onPause();
    ad.i("ContentFragment", this + " onPause " + getUserVisibleHint());
    this.cBJ = false;
    this.zIM.cBJ = this.cBJ;
    if ((this.zIM != null) && (getUserVisibleHint())) {
      this.zIM.dXA();
    }
    if (this.zJc) {
      try
      {
        ad.d("ContentFragmentSphereImageView", "unRegisterSphereImageCompEventReceiver, hash=" + hashCode());
        d.U(getContext()).unregisterReceiver(this.zJe);
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
    this.cBJ = true;
    Object localObject;
    if ((this.zIY != null) && (this.zIY.fOB != null))
    {
      for (localObject = (ViewGroup)this.zIY.fOB.getParent(); (localObject != null) && ((localObject == null) || (((ViewGroup)localObject).getId() != 2131304239)); localObject = (ViewGroup)((ViewGroup)localObject).getParent()) {}
      if ((localObject instanceof FrameLayout))
      {
        int j = ((ViewGroup)localObject).getChildCount();
        int i = 0;
        while (i < j)
        {
          if ((((ViewGroup)localObject).getChildAt(i) instanceof SnsAdLandingPageFloatView)) {
            this.cBJ = false;
          }
          i += 1;
        }
      }
    }
    this.zIM.cBJ = this.cBJ;
    if ((this.zIM != null) && (getUserVisibleHint())) {
      this.zIM.dWw();
    }
    if (this.zJc) {
      try
      {
        ad.d("ContentFragmentSphereImageView", "registerSphereImageCompEventReceiver, hash=" + hashCode());
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_show");
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_none");
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half");
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_hide");
        d.U(getContext()).a(this.zJe, (IntentFilter)localObject);
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
  
  public final void rG(boolean paramBoolean)
  {
    AppMethodBeat.i(97110);
    this.zIT = paramBoolean;
    if ((dXL()) && (!paramBoolean))
    {
      dXJ();
      AppMethodBeat.o(97110);
      return;
    }
    dXK();
    AppMethodBeat.o(97110);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    AppMethodBeat.i(97099);
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      if (this.zIM != null)
      {
        this.zIM.dWw();
        AppMethodBeat.o(97099);
      }
    }
    else if (this.zIM != null) {
      this.zIM.dXA();
    }
    AppMethodBeat.o(97099);
  }
  
  public final void zX(long paramLong)
  {
    AppMethodBeat.i(97116);
    SnsAdNativeLandingPagesUI localSnsAdNativeLandingPagesUI = dXO();
    if (localSnsAdNativeLandingPagesUI != null) {
      localSnsAdNativeLandingPagesUI.zX(paramLong);
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
    public View fOB;
    public RecyclerView gmV;
    public ImageView zJn = null;
    public OverScrollLinearout zJo = null;
    public ImageView zJp = null;
    public View zJq = null;
    public boolean zJr = false;
    LinearLayout zJs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment
 * JD-Core Version:    0.7.0.1
 */