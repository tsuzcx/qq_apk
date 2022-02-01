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
import com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.FloatJumpCompHelper;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ao;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.DummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView;
import com.tencent.mm.plugin.sns.ui.widget.ad.OverScrollLinearout;
import com.tencent.mm.plugin.sns.ui.widget.ad.OverScrollLinearout.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
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
  private boolean Aaa;
  private ValueAnimator Aab;
  private int Aac;
  public int Aad;
  public a Aae;
  private b Aaf;
  private a Aag;
  private boolean Aah;
  protected final String Aai;
  protected boolean Aaj;
  protected boolean Aak;
  private BroadcastReceiver Aal;
  protected View.OnClickListener Aam;
  private View.OnClickListener Aan;
  private boolean Aao;
  private OverScrollLinearout.a Aap;
  private int bgColor;
  public boolean cCq;
  public boolean iXY;
  private int jdZ;
  private aq lVY;
  private int lxZ;
  private int lya;
  public Map<String, Object> xqN;
  private LinearLayoutManager zTo;
  private final Map<String, Bitmap> zWk;
  public g zZP;
  private int zZR;
  public c zZT;
  private int zZU;
  private ao zZV;
  public boolean zZW;
  private boolean zZX;
  private boolean zZY;
  public boolean zZZ;
  
  public ContentFragment()
  {
    AppMethodBeat.i(97093);
    this.zWk = new WeakHashMap();
    this.zZU = 1000;
    this.Aaa = false;
    this.Aai = "ContentFragmentSphereImageView";
    this.Aaj = false;
    this.Aak = false;
    this.Aal = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(97091);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        ae.i("ContentFragmentSphereImageView", "onReceive, action=" + paramAnonymousContext + ", isSphereCom=" + ContentFragment.this.Aaj + ", isFullScreen=" + ContentFragment.this.Aak);
        if ("com.tencent.mm.adlanding.sphereimage.next_page_view_show".equals(paramAnonymousContext))
        {
          paramAnonymousContext = ContentFragment.this.getActivity();
          if ((paramAnonymousContext instanceof SnsAdNativeLandingPagesUI))
          {
            boolean bool = ((SnsAdNativeLandingPagesUI)paramAnonymousContext).eeY();
            ae.i("ContentFragmentSphereImageView", "hasNextPage=".concat(String.valueOf(bool)));
            if (bool)
            {
              ContentFragment.a(ContentFragment.this).Aax.setVisibility(0);
              paramAnonymousContext = new AlphaAnimation(0.0F, 1.0F);
              paramAnonymousContext.setDuration(500L);
              ContentFragment.a(ContentFragment.this).Aax.startAnimation(paramAnonymousContext);
            }
          }
          AppMethodBeat.o(97091);
          return;
        }
        if ("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_none".equals(paramAnonymousContext))
        {
          if (ContentFragment.a(ContentFragment.this).Aax.getVisibility() == 0)
          {
            paramAnonymousContext = ObjectAnimator.ofFloat(ContentFragment.a(ContentFragment.this).Aax, "alpha", new float[] { 0.5F, 1.0F });
            paramAnonymousContext.setDuration(300L);
            paramAnonymousContext.start();
            AppMethodBeat.o(97091);
          }
        }
        else if ("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half".equals(paramAnonymousContext))
        {
          if (ContentFragment.a(ContentFragment.this).Aax.getVisibility() == 0)
          {
            paramAnonymousContext = ObjectAnimator.ofFloat(ContentFragment.a(ContentFragment.this).Aax, "alpha", new float[] { 1.0F, 0.5F });
            paramAnonymousContext.setDuration(300L);
            paramAnonymousContext.start();
            AppMethodBeat.o(97091);
          }
        }
        else if (("com.tencent.mm.adlanding.sphereimage.next_page_view_hide".equals(paramAnonymousContext)) && (ContentFragment.a(ContentFragment.this).Aax.getVisibility() == 0))
        {
          paramAnonymousContext = new AlphaAnimation(1.0F, 0.0F);
          paramAnonymousContext.setDuration(250L);
          paramAnonymousContext.setFillAfter(true);
          ContentFragment.a(ContentFragment.this).Aax.startAnimation(paramAnonymousContext);
        }
        AppMethodBeat.o(97091);
      }
    };
    this.Aam = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97092);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = ContentFragment.this.getActivity();
        if ((paramAnonymousView instanceof SnsAdNativeLandingPagesUI))
        {
          ae.i("ContentFragmentSphereImageView", "jumpNextPage");
          ((SnsAdNativeLandingPagesUI)paramAnonymousView).eeX();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97092);
      }
    };
    this.Aan = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(219605);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        for (;;)
        {
          try
          {
            paramAnonymousView = ContentFragment.this.getRecyclerView();
            if (paramAnonymousView == null)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(219605);
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
                AppMethodBeat.o(219605);
              }
            }
            else
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(219605);
              return;
            }
            int i = localLinearLayoutManager.ko();
            int j = localLinearLayoutManager.getItemCount();
            if ((i < 0) || (j <= 0))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(219605);
              return;
            }
            if (i == j - 1) {
              continue;
            }
            ae.i("ContentFragment.VideoPlay", "By recyclerView, can scrollVertically");
            paramAnonymousView.a(0, ContentFragment.f(ContentFragment.this), null);
          }
          catch (Throwable paramAnonymousView)
          {
            ae.e("ContentFragment.VideoPlay", paramAnonymousView.toString());
            continue;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(219605);
          return;
          ae.i("ContentFragment.VideoPlay", "By recyclerView, can not scrollVertically");
          if (((SnsAdNativeLandingPagesUI)localObject).eeY())
          {
            ae.i("ContentFragment.VideoPlay", "By viewPager, jumpNextPage");
            ((SnsAdNativeLandingPagesUI)localObject).eeX();
          }
        }
      }
    };
    this.Aao = false;
    this.Aap = new OverScrollLinearout.a()
    {
      public final void bB(float paramAnonymousFloat)
      {
        AppMethodBeat.i(219606);
        int i = (int)(paramAnonymousFloat * 0.8D);
        if ((ContentFragment.a(ContentFragment.this) == null) || (ContentFragment.a(ContentFragment.this).Aav == null) || (ContentFragment.a(ContentFragment.this).Aav.getScrollY() + i <= 0))
        {
          AppMethodBeat.o(219606);
          return;
        }
        int j = ContentFragment.this.ebt();
        if (j > 0)
        {
          int k = ContentFragment.a(ContentFragment.this).Aav.getScrollY();
          if (k < j)
          {
            i = Math.min(i, j - k);
            ContentFragment.a(ContentFragment.this).Aav.scrollBy(0, i);
          }
          AppMethodBeat.o(219606);
          return;
        }
        Object localObject = ContentFragment.m(ContentFragment.this).ebf();
        if (!(localObject instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o))
        {
          AppMethodBeat.o(219606);
          return;
        }
        localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o)localObject;
        if (ContentFragment.a(ContentFragment.this).Aav.getScrollY() + i < ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o)localObject).zVe)
        {
          ContentFragment.a(ContentFragment.this).Aav.scrollBy(0, i);
          AppMethodBeat.o(219606);
          return;
        }
        if (!ContentFragment.n(ContentFragment.this))
        {
          ContentFragment.a(ContentFragment.this, true);
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o)localObject).eaG();
        }
        AppMethodBeat.o(219606);
      }
      
      public final void eaV()
      {
        AppMethodBeat.i(219608);
        ContentFragment.a(ContentFragment.this, false);
        AppMethodBeat.o(219608);
      }
      
      public final boolean ebu()
      {
        AppMethodBeat.i(219607);
        int i = ContentFragment.this.ebt();
        int j = ContentFragment.o(ContentFragment.this).ko();
        boolean bool = ContentFragment.this.getRecyclerView().canScrollVertically(1);
        m localm = ContentFragment.m(ContentFragment.this).ebf();
        if ((ContentFragment.p(ContentFragment.this)) && (!bool) && (j == ContentFragment.m(ContentFragment.this).getItemCount() - 1) && ((i > 0) || ((localm instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o))))
        {
          AppMethodBeat.o(219607);
          return true;
        }
        AppMethodBeat.o(219607);
        return false;
      }
    };
    AppMethodBeat.o(97093);
  }
  
  private void amH()
  {
    AppMethodBeat.i(97103);
    if (this.Aaf == null)
    {
      AppMethodBeat.o(97103);
      return;
    }
    ebl();
    final String str;
    if ((this.zZP.AcO != null) && (this.zZP.AcO.length() > 0))
    {
      str = this.zZP.AcO;
      ae.i("ContentFragment", "bg need blur %b, url %s", new Object[] { Boolean.valueOf(this.zZP.AcP), str });
      if (this.zWk.containsKey(str))
      {
        ae.i("ContentFragment", "bg has cache bitmap");
        ao((Bitmap)this.zWk.get(str));
        if (this.Aag != null) {
          if ((this.zZP.AcO == null) || (this.zZP.AcO.length() <= 0)) {
            break label204;
          }
        }
      }
    }
    label204:
    for (this.Aag.bgColor = 0;; this.Aag.bgColor = this.bgColor)
    {
      this.Aag.a(this.zZP);
      AppMethodBeat.o(97103);
      return;
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.c("adId", str, false, 1000000001, new f.a()
      {
        public final void ayY(String paramAnonymousString)
        {
          AppMethodBeat.i(97081);
          ContentFragment.a(ContentFragment.this, paramAnonymousString, "adId", str);
          AppMethodBeat.o(97081);
        }
        
        public final void dVu() {}
        
        public final void dVv()
        {
          AppMethodBeat.i(97080);
          ae.i("ContentFragment", "download img fail %s", new Object[] { str });
          ContentFragment.c(ContentFragment.this);
          AppMethodBeat.o(97080);
        }
      });
      break;
      ebl();
      break;
    }
  }
  
  private void ao(Bitmap paramBitmap)
  {
    AppMethodBeat.i(97105);
    if (paramBitmap != null)
    {
      this.Aaf.fQH.setBackgroundColor(0);
      this.Aaf.Aau.setBackgroundColor(0);
      this.Aaf.Aav.setBackgroundColor(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.Aaf.Aau.getLayoutParams();
      if (localLayoutParams.height >= this.lya) {}
      for (int i = localLayoutParams.height;; i = this.lya)
      {
        localLayoutParams.height = i;
        this.Aaf.Aau.setLayoutParams(localLayoutParams);
        this.Aaf.Aau.setImageBitmap(paramBitmap);
        AppMethodBeat.o(97105);
        return;
      }
    }
    ebl();
    AppMethodBeat.o(97105);
  }
  
  private void b(g paramg)
  {
    AppMethodBeat.i(97111);
    this.Aaj = false;
    this.Aak = false;
    if ((paramg != null) && (paramg.AcQ != null))
    {
      paramg = paramg.AcQ.iterator();
      while (paramg.hasNext())
      {
        y localy = (y)paramg.next();
        if ((localy instanceof t))
        {
          paramg = (t)localy;
          if ((paramg.zQJ) || (paramg.width == 0.0F) || (paramg.height == 0.0F)) {
            this.Aak = true;
          }
          this.Aaj = true;
        }
      }
    }
    ae.i("ContentFragmentSphereImageView", "checkSphereImageComp, isSphereImageViewCompPage=" + this.Aaj + ", isFullScreen=" + this.Aak);
    AppMethodBeat.o(97111);
  }
  
  private void ebl()
  {
    AppMethodBeat.i(97104);
    if ((this.zZP.jZm != null) && (this.zZP.jZm.length() > 0)) {
      ae.i("ContentFragment", "setting bg color %s", new Object[] { this.zZP.jZm });
    }
    try
    {
      this.bgColor = Color.parseColor(this.zZP.jZm);
      this.Aaf.fQH.setBackgroundColor(this.bgColor);
      this.Aaf.Aau.setBackgroundColor(this.bgColor);
      this.Aaf.Aav.setBackgroundColor(this.bgColor);
      AppMethodBeat.o(97104);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("ContentFragment", "the color is error : " + this.zZP.jZm);
      }
    }
  }
  
  private boolean ebo()
  {
    boolean bool2 = true;
    AppMethodBeat.i(97109);
    if (!this.zZY)
    {
      AppMethodBeat.o(97109);
      return false;
    }
    if (this.Aac != 0)
    {
      AppMethodBeat.o(97109);
      return false;
    }
    if (this.Aad != 0)
    {
      AppMethodBeat.o(97109);
      return false;
    }
    if (this.Aaj)
    {
      AppMethodBeat.o(97109);
      return false;
    }
    SnsAdNativeLandingPagesUI localSnsAdNativeLandingPagesUI = ebr();
    if ((localSnsAdNativeLandingPagesUI != null) && ((localSnsAdNativeLandingPagesUI.efb()) || (localSnsAdNativeLandingPagesUI.Apy)))
    {
      AppMethodBeat.o(97109);
      return false;
    }
    int i = this.zTo.km();
    if ((i == this.zTo.ko()) && (i == -1))
    {
      AppMethodBeat.o(97109);
      return false;
    }
    boolean bool1 = bool2;
    if (this.iXY) {
      if (this.zTo.ko() == this.Aag.getItemCount() - 1) {
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
  
  private SnsAdNativeLandingPagesUI ebr()
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
  
  private ac ebs()
  {
    AppMethodBeat.i(97115);
    Object localObject = ebr();
    if (localObject != null)
    {
      localObject = ((SnsAdNativeLandingPagesUI)localObject).AoJ;
      AppMethodBeat.o(97115);
      return localObject;
    }
    AppMethodBeat.o(97115);
    return null;
  }
  
  public final void Av(long paramLong)
  {
    AppMethodBeat.i(97116);
    SnsAdNativeLandingPagesUI localSnsAdNativeLandingPagesUI = ebr();
    if (localSnsAdNativeLandingPagesUI != null) {
      localSnsAdNativeLandingPagesUI.Av(paramLong);
    }
    AppMethodBeat.o(97116);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(97102);
    if (this.zZP != paramg)
    {
      this.zZP = paramg;
      b(paramg);
      amH();
    }
    AppMethodBeat.o(97102);
  }
  
  public final Collection<m> ebh()
  {
    AppMethodBeat.i(97106);
    if (this.Aag == null)
    {
      localObject = Collections.EMPTY_LIST;
      AppMethodBeat.o(97106);
      return localObject;
    }
    Object localObject = this.Aag.ebh();
    AppMethodBeat.o(97106);
    return localObject;
  }
  
  public final void ebi()
  {
    AppMethodBeat.i(97100);
    if ((this.cCq) && (this.zZT != null)) {
      this.zZT.ebc();
    }
    AppMethodBeat.o(97100);
  }
  
  public final boolean ebj()
  {
    AppMethodBeat.i(97101);
    try
    {
      Object localObject1 = this.Aag.ebf();
      if ((localObject1 != null) && ((((m)localObject1).eaw().type == 62) || (((m)localObject1).eaw().type == 61)))
      {
        ae.i("ContentFragment", "isFloatBarCoverVideo, ret=true, lastComp is Video");
        AppMethodBeat.o(97101);
        return true;
      }
      Object localObject2 = this.Aag.ebg();
      if ((localObject2 != null) && ((((m)localObject2).eaw().type == 62) || (((m)localObject2).eaw().type == 61)) && (localObject1 != null))
      {
        localObject1 = ((m)localObject1).contentView;
        if (localObject1 != null)
        {
          localObject2 = new Rect();
          ((View)localObject1).getLocalVisibleRect((Rect)localObject2);
          int i = com.tencent.mm.cb.a.fromDPToPix(getContext(), 88);
          if ((((Rect)localObject2).bottom >= 0) && (((Rect)localObject2).bottom < i))
          {
            ae.i("ContentFragment", "isFloatBarCoverVideo, ret=true, lastComp.rect=" + ((Rect)localObject2).toShortString());
            AppMethodBeat.o(97101);
            return true;
          }
        }
      }
    }
    catch (Exception localException)
    {
      ae.e("ContentFragment", "isFloatBarCoverVideo, exp=" + localException.toString());
      ae.i("ContentFragment", "isFloatBarCoverVideo, ret=false");
      AppMethodBeat.o(97101);
    }
    return false;
  }
  
  public final boolean ebk()
  {
    return (this.zZP != null) && (this.zZP.AcU);
  }
  
  public final void ebm()
  {
    AppMethodBeat.i(97107);
    try
    {
      if ((ebo()) && (!this.Aaa))
      {
        boolean bool = this.Aaf.Aay;
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(97107);
        return;
      }
      this.Aaf.Aaw.setVisibility(0);
      this.Aaf.Aaw.setTranslationY(-com.tencent.mm.cb.a.fromDPToPix(getContext(), 20));
      this.Aab.setRepeatMode(2);
      this.Aab.setRepeatCount(-1);
      this.Aab.start();
      AppMethodBeat.o(97107);
      return;
    }
    catch (Exception localException)
    {
      ae.e("ContentFragment", "startDownAnimation, exp=" + localException.toString());
      AppMethodBeat.o(97107);
    }
  }
  
  public final void ebn()
  {
    AppMethodBeat.i(97108);
    try
    {
      this.Aaf.Aaw.setVisibility(4);
      this.Aaf.Aaw.setTranslationY(-com.tencent.mm.cb.a.fromDPToPix(getContext(), 20));
      this.Aab.setRepeatMode(2);
      this.Aab.setRepeatCount(0);
      this.Aab.end();
      AppMethodBeat.o(97108);
      return;
    }
    catch (Exception localException)
    {
      ae.e("ContentFragment", "stopDownAnimation, exp=" + localException.toString());
      AppMethodBeat.o(97108);
    }
  }
  
  public final boolean ebp()
  {
    AppMethodBeat.i(97112);
    try
    {
      ac localac = ebs();
      boolean bool = this.iXY;
      if ((!bool) || (localac == null))
      {
        AppMethodBeat.o(97112);
        return true;
      }
      if (this.Aaf.gpr != null)
      {
        int i = this.Aaf.gpr.computeVerticalScrollOffset();
        int j = this.Aaf.gpr.computeVerticalScrollExtent();
        j = this.Aaf.gpr.computeVerticalScrollRange() - i - j;
        ae.d("ContentFragment", "bottomDis=" + j + ", appearBottom=" + localac.zRz + ", topDis=" + i + ", appearTop=" + localac.zRy + ", height=" + com.tencent.mm.cb.a.iv(getContext()));
        if (localac.zRz > 0)
        {
          i = localac.zRz;
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
  
  public final boolean ebq()
  {
    AppMethodBeat.i(97113);
    try
    {
      ac localac = ebs();
      int i = this.Aaf.gpr.computeVerticalScrollOffset();
      if ((this.zZW) && (localac != null))
      {
        if ((localac.zRy == 0) || ((localac.zRy > 0) && (i >= localac.zRy)))
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
  
  protected final int ebt()
  {
    AppMethodBeat.i(219609);
    Object localObject = getActivity();
    if ((localObject instanceof SnsAdNativeLandingPagesUI))
    {
      localObject = ((SnsAdNativeLandingPagesUI)localObject).ApV;
      if (localObject != null)
      {
        int i = ((FloatJumpCompHelper)localObject).znQ;
        AppMethodBeat.o(219609);
        return i;
      }
      AppMethodBeat.o(219609);
      return -1;
    }
    AppMethodBeat.o(219609);
    return -1;
  }
  
  public final RecyclerView getRecyclerView()
  {
    if (this.Aaf != null) {
      return this.Aaf.gpr;
    }
    return null;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(97094);
    super.onCreate(paramBundle);
    paramBundle = this.xqN;
    int[] arrayOfInt = an.gp(getContext());
    this.lxZ = arrayOfInt[0];
    this.lya = arrayOfInt[1];
    if (this.zZP == null)
    {
      this.zZP = ((g)paramBundle.get("pageInfo"));
      b(this.zZP);
    }
    this.zZV = ((ao)paramBundle.get("pageDownIconInfo"));
    this.zZW = bu.o((Boolean)paramBundle.get("is_first_show_page"));
    this.iXY = bu.o((Boolean)paramBundle.get("is_last_shown_page"));
    this.zZX = bu.o((Boolean)paramBundle.get("needEnterAnimation"));
    this.zZY = bu.o((Boolean)paramBundle.get("needDirectionAnimation"));
    this.zZR = bu.m(paramBundle.get("groupListCompShowIndex"), 0);
    AppMethodBeat.o(97094);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(97095);
    paramLayoutInflater = paramLayoutInflater.inflate(2131492939, paramViewGroup, false);
    this.Aaf = new b((byte)0);
    this.Aaf.fQH = paramLayoutInflater;
    this.Aaf.Aau = ((ImageView)paramLayoutInflater.findViewById(2131304900));
    this.Aaf.Aav = ((OverScrollLinearout)paramLayoutInflater.findViewById(2131304922));
    if (this.iXY) {
      this.Aaf.Aav.setOnScrollActionListener(this.Aap);
    }
    this.Aaf.Aaw = ((ImageView)paramLayoutInflater.findViewById(2131305020));
    this.Aaf.Aax = paramLayoutInflater.findViewById(2131305021);
    this.Aaf.Aax.setOnClickListener(this.Aam);
    this.Aaf.Aaw.setOnClickListener(this.Aan);
    this.Aaf.gpr = ((RecyclerView)paramLayoutInflater.findViewById(2131298763));
    this.Aaf.Aaz = ((LinearLayout)paramLayoutInflater.findViewById(2131299754));
    paramViewGroup = this.Aaf.gpr;
    paramViewGroup.setOverScrollMode(0);
    int i = bu.m(this.xqN.get("pageCount"), 0);
    ae.d("ContentFragment", "initRecyclerView, pageCount=".concat(String.valueOf(i)));
    if (i > 1) {
      paramViewGroup.setOnTouchListener(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.b((DummyViewPager)this.xqN.get("viewPager")));
    }
    for (;;)
    {
      getActivity();
      this.zTo = new LinearLayoutManager();
      paramViewGroup.setLayoutManager(this.zTo);
      this.Aag = new a(this.zZP, this.bgColor, getActivity(), this.zTo);
      if (this.zZW) {
        this.Aag.zZR = this.zZR;
      }
      paramViewGroup.setAdapter(this.Aag);
      paramViewGroup.setDescendantFocusability(131072);
      this.zZT = new c(paramViewGroup);
      paramViewGroup.a(new RecyclerView.m()
      {
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(97078);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousRecyclerView);
          localb.mu(paramAnonymousInt1);
          localb.mu(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
          super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          if ((ContentFragment.a(ContentFragment.this).Aau != null) && (ContentFragment.a(ContentFragment.this).Aau.getVisibility() == 0)) {
            ContentFragment.a(ContentFragment.this).Aau.scrollBy(paramAnonymousInt1, paramAnonymousInt2);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(97078);
        }
        
        public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(97079);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousRecyclerView);
          localb.mu(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
          super.b(paramAnonymousRecyclerView, paramAnonymousInt);
          ContentFragment.a(ContentFragment.this, paramAnonymousInt);
          if (paramAnonymousInt == 0)
          {
            ContentFragment.this.Av(50L);
            if (ContentFragment.b(ContentFragment.this)) {
              ContentFragment.this.ebm();
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(97079);
            return;
            if (paramAnonymousInt == 1)
            {
              ContentFragment.this.ebn();
              an.gq(ContentFragment.this.getContext());
            }
          }
        }
      });
      paramLayoutInflater.setTag(this.Aaf);
      amH();
      this.Aab = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.Aab.setDuration(this.zZU);
      this.Aab.setInterpolator(new AccelerateDecelerateInterpolator());
      this.Aab.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(97084);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          ContentFragment.a(ContentFragment.this).Aaw.setTranslationY((int)(f * -com.tencent.mm.cb.a.fromDPToPix(ContentFragment.this.getContext(), 20)));
          AppMethodBeat.o(97084);
        }
      });
      this.Aab.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(97086);
          ae.d("ContentFragment", "onAnimationEnd show nextBtn");
          ContentFragment.a(ContentFragment.this).Aay = false;
          AppMethodBeat.o(97086);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(97085);
          ae.d("ContentFragment", "onAnimationStart show nextBtn");
          ContentFragment.a(ContentFragment.this).Aay = true;
          AppMethodBeat.o(97085);
        }
      });
      this.Aab.setRepeatCount(-1);
      this.Aab.setRepeatMode(2);
      if ((this.zZV != null) && (!this.zZV.equals(this.Aaf.Aaw.getTag())))
      {
        this.Aaf.Aaw.setTag(this.zZV);
        this.Aaf.Aaw.setVisibility(8);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(this.zZV.iconUrl, 1000000001, new f.a()
        {
          public final void ayY(String paramAnonymousString)
          {
            AppMethodBeat.i(97088);
            ae.d("ContentFragment", "onDownloaded nextBtn");
            ContentFragment.a(ContentFragment.this, paramAnonymousString, ContentFragment.a(ContentFragment.this).Aaw);
            ContentFragment.this.ebm();
            AppMethodBeat.o(97088);
          }
          
          public final void dVu() {}
          
          public final void dVv()
          {
            AppMethodBeat.i(97087);
            ae.d("ContentFragment", "onDownloadError nextBtn");
            AppMethodBeat.o(97087);
          }
        });
      }
      if (this.Aae != null) {
        this.Aae.q(this);
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
    if (this.zZT != null) {
      this.zZT.zZy.onDestroy();
    }
    ebn();
    AppMethodBeat.o(97098);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(97097);
    super.onPause();
    ae.i("ContentFragment", this + " onPause " + getUserVisibleHint());
    this.cCq = false;
    this.zZT.cCq = this.cCq;
    if ((this.zZT != null) && (getUserVisibleHint())) {
      this.zZT.ebd();
    }
    if (this.Aaj) {
      try
      {
        ae.d("ContentFragmentSphereImageView", "unRegisterSphereImageCompEventReceiver, hash=" + hashCode());
        d.V(getContext()).unregisterReceiver(this.Aal);
        AppMethodBeat.o(97097);
        return;
      }
      catch (Exception localException)
      {
        ae.e("ContentFragmentSphereImageView", "unRegisterSphereImageCompEventReceiver, exp:" + localException.toString());
      }
    }
    AppMethodBeat.o(97097);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(97096);
    super.onResume();
    ae.i("ContentFragment", this + " onResume " + getUserVisibleHint());
    this.cCq = true;
    Object localObject;
    if ((this.Aaf != null) && (this.Aaf.fQH != null))
    {
      for (localObject = (ViewGroup)this.Aaf.fQH.getParent(); (localObject != null) && ((localObject == null) || (((ViewGroup)localObject).getId() != 2131304239)); localObject = (ViewGroup)((ViewGroup)localObject).getParent()) {}
      if ((localObject instanceof FrameLayout))
      {
        int j = ((ViewGroup)localObject).getChildCount();
        int i = 0;
        while (i < j)
        {
          if ((((ViewGroup)localObject).getChildAt(i) instanceof SnsAdLandingPageFloatView)) {
            this.cCq = false;
          }
          i += 1;
        }
      }
    }
    this.zZT.cCq = this.cCq;
    if ((this.zZT != null) && (getUserVisibleHint())) {
      this.zZT.dZY();
    }
    if (this.Aaj) {
      try
      {
        ae.d("ContentFragmentSphereImageView", "registerSphereImageCompEventReceiver, hash=" + hashCode());
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_show");
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_none");
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half");
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_hide");
        d.V(getContext()).a(this.Aal, (IntentFilter)localObject);
        AppMethodBeat.o(97096);
        return;
      }
      catch (Exception localException)
      {
        ae.e("ContentFragmentSphereImageView", "registerSphereImageCompEventReceiver, exp:" + localException.toString());
      }
    }
    AppMethodBeat.o(97096);
  }
  
  public final void rN(boolean paramBoolean)
  {
    AppMethodBeat.i(97110);
    this.Aaa = paramBoolean;
    if ((ebo()) && (!paramBoolean))
    {
      ebm();
      AppMethodBeat.o(97110);
      return;
    }
    ebn();
    AppMethodBeat.o(97110);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    AppMethodBeat.i(97099);
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      if (this.zZT != null)
      {
        this.zZT.dZY();
        AppMethodBeat.o(97099);
      }
    }
    else if (this.zZT != null) {
      this.zZT.ebd();
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
    public ImageView Aau = null;
    public OverScrollLinearout Aav = null;
    public ImageView Aaw = null;
    public View Aax = null;
    public boolean Aay = false;
    LinearLayout Aaz;
    public View fQH;
    public RecyclerView gpr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment
 * JD-Core Version:    0.7.0.1
 */