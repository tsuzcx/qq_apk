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
import android.support.v7.widget.RecyclerView.l;
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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aq;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.DummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView;
import com.tencent.mm.plugin.sns.ui.widget.ad.OverScrollLinearout;
import com.tencent.mm.plugin.sns.ui.widget.ad.OverScrollLinearout.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
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
  private final Map<String, Bitmap> Eer;
  protected boolean EiA;
  protected boolean EiB;
  private BroadcastReceiver EiC;
  protected View.OnClickListener EiD;
  private View.OnClickListener EiE;
  private boolean EiF;
  private OverScrollLinearout.a EiG;
  public g Eig;
  private int Eii;
  public c Eik;
  private int Eil;
  private aq Eim;
  public boolean Ein;
  private boolean Eio;
  private boolean Eip;
  public boolean Eiq;
  private boolean Eir;
  private ValueAnimator Eis;
  private int Eit;
  public int Eiu;
  public a Eiv;
  private b Eiw;
  private a Eix;
  private boolean Eiy;
  protected final String Eiz;
  private int bgColor;
  public boolean cQp;
  public boolean jUX;
  private int kcc;
  private int mEX;
  private int mEY;
  private MMHandler ndA;
  public Map<String, Object> params;
  private LinearLayoutManager vKp;
  
  public ContentFragment()
  {
    AppMethodBeat.i(97093);
    this.Eer = new WeakHashMap();
    this.Eil = 1000;
    this.Eir = false;
    this.Eiz = "ContentFragmentSphereImageView";
    this.EiA = false;
    this.EiB = false;
    this.EiC = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(97091);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        Log.i("ContentFragmentSphereImageView", "onReceive, action=" + paramAnonymousContext + ", isSphereCom=" + ContentFragment.this.EiA + ", isFullScreen=" + ContentFragment.this.EiB);
        if ("com.tencent.mm.adlanding.sphereimage.next_page_view_show".equals(paramAnonymousContext))
        {
          paramAnonymousContext = ContentFragment.this.getActivity();
          if ((paramAnonymousContext instanceof SnsAdNativeLandingPagesUI))
          {
            boolean bool = ((SnsAdNativeLandingPagesUI)paramAnonymousContext).fhs();
            Log.i("ContentFragmentSphereImageView", "hasNextPage=".concat(String.valueOf(bool)));
            if (bool)
            {
              ContentFragment.a(ContentFragment.this).EiO.setVisibility(0);
              paramAnonymousContext = new AlphaAnimation(0.0F, 1.0F);
              paramAnonymousContext.setDuration(500L);
              ContentFragment.a(ContentFragment.this).EiO.startAnimation(paramAnonymousContext);
            }
          }
          AppMethodBeat.o(97091);
          return;
        }
        if ("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_none".equals(paramAnonymousContext))
        {
          if (ContentFragment.a(ContentFragment.this).EiO.getVisibility() == 0)
          {
            paramAnonymousContext = ObjectAnimator.ofFloat(ContentFragment.a(ContentFragment.this).EiO, "alpha", new float[] { 0.5F, 1.0F });
            paramAnonymousContext.setDuration(300L);
            paramAnonymousContext.start();
            AppMethodBeat.o(97091);
          }
        }
        else if ("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half".equals(paramAnonymousContext))
        {
          if (ContentFragment.a(ContentFragment.this).EiO.getVisibility() == 0)
          {
            paramAnonymousContext = ObjectAnimator.ofFloat(ContentFragment.a(ContentFragment.this).EiO, "alpha", new float[] { 1.0F, 0.5F });
            paramAnonymousContext.setDuration(300L);
            paramAnonymousContext.start();
            AppMethodBeat.o(97091);
          }
        }
        else if (("com.tencent.mm.adlanding.sphereimage.next_page_view_hide".equals(paramAnonymousContext)) && (ContentFragment.a(ContentFragment.this).EiO.getVisibility() == 0))
        {
          paramAnonymousContext = new AlphaAnimation(1.0F, 0.0F);
          paramAnonymousContext.setDuration(250L);
          paramAnonymousContext.setFillAfter(true);
          ContentFragment.a(ContentFragment.this).EiO.startAnimation(paramAnonymousContext);
        }
        AppMethodBeat.o(97091);
      }
    };
    this.EiD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97092);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = ContentFragment.this.getActivity();
        if ((paramAnonymousView instanceof SnsAdNativeLandingPagesUI))
        {
          Log.i("ContentFragmentSphereImageView", "jumpNextPage");
          ((SnsAdNativeLandingPagesUI)paramAnonymousView).fhr();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97092);
      }
    };
    this.EiE = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203123);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        for (;;)
        {
          try
          {
            paramAnonymousView = ContentFragment.this.getRecyclerView();
            if (paramAnonymousView == null)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(203123);
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
                AppMethodBeat.o(203123);
              }
            }
            else
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(203123);
              return;
            }
            int i = localLinearLayoutManager.ku();
            int j = localLinearLayoutManager.getItemCount();
            if ((i < 0) || (j <= 0))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(203123);
              return;
            }
            if (i == j - 1) {
              continue;
            }
            Log.i("ContentFragment.VideoPlay", "By recyclerView, can scrollVertically");
            paramAnonymousView.a(0, ContentFragment.f(ContentFragment.this), null);
          }
          catch (Throwable paramAnonymousView)
          {
            Log.e("ContentFragment.VideoPlay", paramAnonymousView.toString());
            continue;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203123);
          return;
          Log.i("ContentFragment.VideoPlay", "By recyclerView, can not scrollVertically");
          if (((SnsAdNativeLandingPagesUI)localObject).fhs())
          {
            Log.i("ContentFragment.VideoPlay", "By viewPager, jumpNextPage");
            ((SnsAdNativeLandingPagesUI)localObject).fhr();
          }
        }
      }
    };
    this.EiF = false;
    this.EiG = new OverScrollLinearout.a()
    {
      public final void bV(float paramAnonymousFloat)
      {
        AppMethodBeat.i(203124);
        int i = (int)(paramAnonymousFloat * 0.8D);
        if ((ContentFragment.a(ContentFragment.this) == null) || (ContentFragment.a(ContentFragment.this).EiM == null) || (ContentFragment.a(ContentFragment.this).EiM.getScrollY() + i <= 0))
        {
          AppMethodBeat.o(203124);
          return;
        }
        int j = ContentFragment.this.fek();
        if (j > 0)
        {
          int k = ContentFragment.a(ContentFragment.this).EiM.getScrollY();
          if (k < j)
          {
            i = Math.min(i, j - k);
            ContentFragment.a(ContentFragment.this).EiM.scrollBy(0, i);
          }
          AppMethodBeat.o(203124);
          return;
        }
        Object localObject = ContentFragment.m(ContentFragment.this).fdW();
        if (!(localObject instanceof o))
        {
          AppMethodBeat.o(203124);
          return;
        }
        localObject = (o)localObject;
        if (ContentFragment.a(ContentFragment.this).EiM.getScrollY() + i < ((o)localObject).Edl)
        {
          ContentFragment.a(ContentFragment.this).EiM.scrollBy(0, i);
          AppMethodBeat.o(203124);
          return;
        }
        if (!ContentFragment.n(ContentFragment.this))
        {
          ContentFragment.a(ContentFragment.this, true);
          ((o)localObject).fdv();
        }
        AppMethodBeat.o(203124);
      }
      
      public final void fdL()
      {
        AppMethodBeat.i(203126);
        ContentFragment.a(ContentFragment.this, false);
        AppMethodBeat.o(203126);
      }
      
      public final boolean fel()
      {
        AppMethodBeat.i(203125);
        int i = ContentFragment.this.fek();
        int j = ContentFragment.o(ContentFragment.this).ku();
        boolean bool = ContentFragment.this.getRecyclerView().canScrollVertically(1);
        m localm = ContentFragment.m(ContentFragment.this).fdW();
        if ((ContentFragment.p(ContentFragment.this)) && (!bool) && (j == ContentFragment.m(ContentFragment.this).getItemCount() - 1) && ((i > 0) || ((localm instanceof o))))
        {
          AppMethodBeat.o(203125);
          return true;
        }
        AppMethodBeat.o(203125);
        return false;
      }
    };
    AppMethodBeat.o(97093);
  }
  
  private void aED()
  {
    AppMethodBeat.i(97103);
    if (this.Eiw == null)
    {
      AppMethodBeat.o(97103);
      return;
    }
    fec();
    final String str;
    if ((this.Eig.Elg != null) && (this.Eig.Elg.length() > 0))
    {
      str = this.Eig.Elg;
      Log.i("ContentFragment", "bg need blur %b, url %s", new Object[] { Boolean.valueOf(this.Eig.Elh), str });
      if (this.Eer.containsKey(str))
      {
        Log.i("ContentFragment", "bg has cache bitmap");
        az((Bitmap)this.Eer.get(str));
        if (this.Eix != null) {
          if ((this.Eig.Elg == null) || (this.Eig.Elg.length() <= 0)) {
            break label204;
          }
        }
      }
    }
    label204:
    for (this.Eix.bgColor = 0;; this.Eix.bgColor = this.bgColor)
    {
      this.Eix.a(this.Eig);
      AppMethodBeat.o(97103);
      return;
      h.a("adId", str, false, 1000000001, new f.a()
      {
        public final void aNH(String paramAnonymousString)
        {
          AppMethodBeat.i(97081);
          ContentFragment.a(ContentFragment.this, paramAnonymousString, "adId", str);
          AppMethodBeat.o(97081);
        }
        
        public final void eWN() {}
        
        public final void eWO()
        {
          AppMethodBeat.i(97080);
          Log.i("ContentFragment", "download img fail %s", new Object[] { str });
          ContentFragment.c(ContentFragment.this);
          AppMethodBeat.o(97080);
        }
      });
      break;
      fec();
      break;
    }
  }
  
  private void az(Bitmap paramBitmap)
  {
    AppMethodBeat.i(97105);
    if (paramBitmap != null)
    {
      this.Eiw.gvQ.setBackgroundColor(0);
      this.Eiw.EiL.setBackgroundColor(0);
      this.Eiw.EiM.setBackgroundColor(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.Eiw.EiL.getLayoutParams();
      if (localLayoutParams.height >= this.mEY) {}
      for (int i = localLayoutParams.height;; i = this.mEY)
      {
        localLayoutParams.height = i;
        this.Eiw.EiL.setLayoutParams(localLayoutParams);
        this.Eiw.EiL.setImageBitmap(paramBitmap);
        AppMethodBeat.o(97105);
        return;
      }
    }
    fec();
    AppMethodBeat.o(97105);
  }
  
  private void b(g paramg)
  {
    AppMethodBeat.i(97111);
    this.EiA = false;
    this.EiB = false;
    if ((paramg != null) && (paramg.Eli != null))
    {
      paramg = paramg.Eli.iterator();
      while (paramg.hasNext())
      {
        z localz = (z)paramg.next();
        if ((localz instanceof u))
        {
          paramg = (u)localz;
          if ((paramg.DYJ) || (paramg.width == 0.0F) || (paramg.height == 0.0F)) {
            this.EiB = true;
          }
          this.EiA = true;
        }
      }
    }
    Log.i("ContentFragmentSphereImageView", "checkSphereImageComp, isSphereImageViewCompPage=" + this.EiA + ", isFullScreen=" + this.EiB);
    AppMethodBeat.o(97111);
  }
  
  private void fec()
  {
    AppMethodBeat.i(97104);
    if ((this.Eig.lco != null) && (this.Eig.lco.length() > 0)) {
      Log.i("ContentFragment", "setting bg color %s", new Object[] { this.Eig.lco });
    }
    try
    {
      this.bgColor = Color.parseColor(this.Eig.lco);
      this.Eiw.gvQ.setBackgroundColor(this.bgColor);
      this.Eiw.EiL.setBackgroundColor(this.bgColor);
      this.Eiw.EiM.setBackgroundColor(this.bgColor);
      AppMethodBeat.o(97104);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("ContentFragment", "the color is error : " + this.Eig.lco);
      }
    }
  }
  
  private boolean fef()
  {
    boolean bool2 = true;
    AppMethodBeat.i(97109);
    if (!this.Eip)
    {
      AppMethodBeat.o(97109);
      return false;
    }
    if (this.Eit != 0)
    {
      AppMethodBeat.o(97109);
      return false;
    }
    if (this.Eiu != 0)
    {
      AppMethodBeat.o(97109);
      return false;
    }
    if (this.EiA)
    {
      AppMethodBeat.o(97109);
      return false;
    }
    SnsAdNativeLandingPagesUI localSnsAdNativeLandingPagesUI = fei();
    if ((localSnsAdNativeLandingPagesUI != null) && ((localSnsAdNativeLandingPagesUI.fhv()) || (localSnsAdNativeLandingPagesUI.Eyj)))
    {
      AppMethodBeat.o(97109);
      return false;
    }
    int i = this.vKp.ks();
    if ((i == this.vKp.ku()) && (i == -1))
    {
      AppMethodBeat.o(97109);
      return false;
    }
    boolean bool1 = bool2;
    if (this.jUX) {
      if (this.vKp.ku() == this.Eix.getItemCount() - 1) {
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
  
  private SnsAdNativeLandingPagesUI fei()
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
  
  private ad fej()
  {
    AppMethodBeat.i(97115);
    Object localObject = fei();
    if (localObject != null)
    {
      localObject = ((SnsAdNativeLandingPagesUI)localObject).Exu;
      AppMethodBeat.o(97115);
      return localObject;
    }
    AppMethodBeat.o(97115);
    return null;
  }
  
  public final void JC(long paramLong)
  {
    AppMethodBeat.i(97116);
    SnsAdNativeLandingPagesUI localSnsAdNativeLandingPagesUI = fei();
    if (localSnsAdNativeLandingPagesUI != null) {
      localSnsAdNativeLandingPagesUI.JC(paramLong);
    }
    AppMethodBeat.o(97116);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(97102);
    if (this.Eig != paramg)
    {
      this.Eig = paramg;
      b(paramg);
      aED();
    }
    AppMethodBeat.o(97102);
  }
  
  public final Collection<m> fdY()
  {
    AppMethodBeat.i(97106);
    if (this.Eix == null)
    {
      localObject = Collections.EMPTY_LIST;
      AppMethodBeat.o(97106);
      return localObject;
    }
    Object localObject = this.Eix.fdY();
    AppMethodBeat.o(97106);
    return localObject;
  }
  
  public final void fdZ()
  {
    AppMethodBeat.i(97100);
    if ((this.cQp) && (this.Eik != null)) {
      this.Eik.fdT();
    }
    AppMethodBeat.o(97100);
  }
  
  public final boolean fea()
  {
    AppMethodBeat.i(97101);
    try
    {
      Object localObject1 = this.Eix.fdW();
      if ((localObject1 != null) && ((((m)localObject1).fdk().type == 62) || (((m)localObject1).fdk().type == 61)))
      {
        Log.i("ContentFragment", "isFloatBarCoverVideo, ret=true, lastComp is Video");
        AppMethodBeat.o(97101);
        return true;
      }
      Object localObject2 = this.Eix.fdX();
      if ((localObject2 != null) && ((((m)localObject2).fdk().type == 62) || (((m)localObject2).fdk().type == 61)) && (localObject1 != null))
      {
        localObject1 = ((m)localObject1).contentView;
        if (localObject1 != null)
        {
          localObject2 = new Rect();
          ((View)localObject1).getLocalVisibleRect((Rect)localObject2);
          int i = com.tencent.mm.cb.a.fromDPToPix(getContext(), 88);
          if ((((Rect)localObject2).bottom >= 0) && (((Rect)localObject2).bottom < i))
          {
            Log.i("ContentFragment", "isFloatBarCoverVideo, ret=true, lastComp.rect=" + ((Rect)localObject2).toShortString());
            AppMethodBeat.o(97101);
            return true;
          }
        }
      }
    }
    catch (Exception localException)
    {
      Log.e("ContentFragment", "isFloatBarCoverVideo, exp=" + localException.toString());
      Log.i("ContentFragment", "isFloatBarCoverVideo, ret=false");
      AppMethodBeat.o(97101);
    }
    return false;
  }
  
  public final boolean feb()
  {
    return (this.Eig != null) && (this.Eig.Elm);
  }
  
  public final void fed()
  {
    AppMethodBeat.i(97107);
    try
    {
      if ((fef()) && (!this.Eir))
      {
        boolean bool = this.Eiw.EiP;
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(97107);
        return;
      }
      this.Eiw.EiN.setVisibility(0);
      this.Eiw.EiN.setTranslationY(-com.tencent.mm.cb.a.fromDPToPix(getContext(), 20));
      this.Eis.setRepeatMode(2);
      this.Eis.setRepeatCount(-1);
      this.Eis.start();
      AppMethodBeat.o(97107);
      return;
    }
    catch (Exception localException)
    {
      Log.e("ContentFragment", "startDownAnimation, exp=" + localException.toString());
      AppMethodBeat.o(97107);
    }
  }
  
  public final void fee()
  {
    AppMethodBeat.i(97108);
    try
    {
      this.Eiw.EiN.setVisibility(4);
      this.Eiw.EiN.setTranslationY(-com.tencent.mm.cb.a.fromDPToPix(getContext(), 20));
      this.Eis.setRepeatMode(2);
      this.Eis.setRepeatCount(0);
      this.Eis.end();
      AppMethodBeat.o(97108);
      return;
    }
    catch (Exception localException)
    {
      Log.e("ContentFragment", "stopDownAnimation, exp=" + localException.toString());
      AppMethodBeat.o(97108);
    }
  }
  
  public final boolean feg()
  {
    AppMethodBeat.i(97112);
    try
    {
      ad localad = fej();
      boolean bool = this.jUX;
      if ((!bool) || (localad == null))
      {
        AppMethodBeat.o(97112);
        return true;
      }
      if (this.Eiw.hak != null)
      {
        int i = this.Eiw.hak.computeVerticalScrollOffset();
        int j = this.Eiw.hak.computeVerticalScrollExtent();
        j = this.Eiw.hak.computeVerticalScrollRange() - i - j;
        Log.d("ContentFragment", "bottomDis=" + j + ", appearBottom=" + localad.DZF + ", topDis=" + i + ", appearTop=" + localad.DZE + ", height=" + com.tencent.mm.cb.a.jo(getContext()));
        if (localad.DZF > 0)
        {
          i = localad.DZF;
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
  
  public final boolean feh()
  {
    AppMethodBeat.i(97113);
    try
    {
      ad localad = fej();
      int i = this.Eiw.hak.computeVerticalScrollOffset();
      if ((this.Ein) && (localad != null))
      {
        if ((localad.DZE == 0) || ((localad.DZE > 0) && (i >= localad.DZE)))
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
  
  protected final int fek()
  {
    AppMethodBeat.i(203127);
    Object localObject = getActivity();
    if ((localObject instanceof SnsAdNativeLandingPagesUI))
    {
      localObject = ((SnsAdNativeLandingPagesUI)localObject).EyS;
      if (localObject != null)
      {
        int i = ((FloatJumpCompHelper)localObject).Duc;
        AppMethodBeat.o(203127);
        return i;
      }
      AppMethodBeat.o(203127);
      return -1;
    }
    AppMethodBeat.o(203127);
    return -1;
  }
  
  public final RecyclerView getRecyclerView()
  {
    if (this.Eiw != null) {
      return this.Eiw.hak;
    }
    return null;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(97094);
    super.onCreate(paramBundle);
    paramBundle = this.params;
    int[] arrayOfInt = ap.ha(getContext());
    this.mEX = arrayOfInt[0];
    this.mEY = arrayOfInt[1];
    if (this.Eig == null)
    {
      this.Eig = ((g)paramBundle.get("pageInfo"));
      b(this.Eig);
    }
    this.Eim = ((aq)paramBundle.get("pageDownIconInfo"));
    this.Ein = Util.nullAsFalse((Boolean)paramBundle.get("is_first_show_page"));
    this.jUX = Util.nullAsFalse((Boolean)paramBundle.get("is_last_shown_page"));
    this.Eio = Util.nullAsFalse((Boolean)paramBundle.get("needEnterAnimation"));
    this.Eip = Util.nullAsFalse((Boolean)paramBundle.get("needDirectionAnimation"));
    this.Eii = Util.nullAsInt(paramBundle.get("groupListCompShowIndex"), 0);
    AppMethodBeat.o(97094);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(97095);
    paramLayoutInflater = paramLayoutInflater.inflate(2131492970, paramViewGroup, false);
    this.Eiw = new b((byte)0);
    this.Eiw.gvQ = paramLayoutInflater;
    this.Eiw.EiL = ((ImageView)paramLayoutInflater.findViewById(2131308036));
    this.Eiw.EiM = ((OverScrollLinearout)paramLayoutInflater.findViewById(2131308059));
    if (this.jUX) {
      this.Eiw.EiM.setOnScrollActionListener(this.EiG);
    }
    this.Eiw.EiN = ((ImageView)paramLayoutInflater.findViewById(2131308171));
    this.Eiw.EiO = paramLayoutInflater.findViewById(2131308172);
    this.Eiw.EiO.setOnClickListener(this.EiD);
    this.Eiw.EiN.setOnClickListener(this.EiE);
    this.Eiw.hak = ((RecyclerView)paramLayoutInflater.findViewById(2131299207));
    this.Eiw.EiQ = ((LinearLayout)paramLayoutInflater.findViewById(2131300421));
    paramViewGroup = this.Eiw.hak;
    paramViewGroup.setOverScrollMode(0);
    int i = Util.nullAsInt(this.params.get("pageCount"), 0);
    Log.d("ContentFragment", "initRecyclerView, pageCount=".concat(String.valueOf(i)));
    if (i > 1) {
      paramViewGroup.setOnTouchListener(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.b((DummyViewPager)this.params.get("viewPager")));
    }
    for (;;)
    {
      getActivity();
      this.vKp = new LinearLayoutManager();
      paramViewGroup.setLayoutManager(this.vKp);
      this.Eix = new a(this.Eig, this.bgColor, getActivity(), this.vKp);
      if (this.Ein) {
        this.Eix.Eii = this.Eii;
      }
      paramViewGroup.setAdapter(this.Eix);
      paramViewGroup.setDescendantFocusability(131072);
      this.Eik = new c(paramViewGroup);
      paramViewGroup.a(new RecyclerView.l()
      {
        public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(97079);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousRecyclerView);
          localb.pH(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
          super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
          ContentFragment.a(ContentFragment.this, paramAnonymousInt);
          if (paramAnonymousInt == 0)
          {
            ContentFragment.this.JC(50L);
            if (ContentFragment.b(ContentFragment.this)) {
              ContentFragment.this.fed();
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(97079);
            return;
            if (paramAnonymousInt == 1)
            {
              ContentFragment.this.fee();
              ap.hb(ContentFragment.this.getContext());
            }
          }
        }
        
        public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(97078);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousRecyclerView);
          localb.pH(paramAnonymousInt1);
          localb.pH(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
          super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          if ((ContentFragment.a(ContentFragment.this).EiL != null) && (ContentFragment.a(ContentFragment.this).EiL.getVisibility() == 0)) {
            ContentFragment.a(ContentFragment.this).EiL.scrollBy(paramAnonymousInt1, paramAnonymousInt2);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(97078);
        }
      });
      paramLayoutInflater.setTag(this.Eiw);
      aED();
      this.Eis = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.Eis.setDuration(this.Eil);
      this.Eis.setInterpolator(new AccelerateDecelerateInterpolator());
      this.Eis.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(97084);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          ContentFragment.a(ContentFragment.this).EiN.setTranslationY((int)(f * -com.tencent.mm.cb.a.fromDPToPix(ContentFragment.this.getContext(), 20)));
          AppMethodBeat.o(97084);
        }
      });
      this.Eis.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(97086);
          Log.d("ContentFragment", "onAnimationEnd show nextBtn");
          ContentFragment.a(ContentFragment.this).EiP = false;
          AppMethodBeat.o(97086);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(97085);
          Log.d("ContentFragment", "onAnimationStart show nextBtn");
          ContentFragment.a(ContentFragment.this).EiP = true;
          AppMethodBeat.o(97085);
        }
      });
      this.Eis.setRepeatCount(-1);
      this.Eis.setRepeatMode(2);
      if ((this.Eim != null) && (!this.Eim.equals(this.Eiw.EiN.getTag())))
      {
        this.Eiw.EiN.setTag(this.Eim);
        this.Eiw.EiN.setVisibility(8);
        h.a(this.Eim.iconUrl, 1000000001, new f.a()
        {
          public final void aNH(String paramAnonymousString)
          {
            AppMethodBeat.i(97088);
            Log.d("ContentFragment", "onDownloaded nextBtn");
            ContentFragment.a(ContentFragment.this, paramAnonymousString, ContentFragment.a(ContentFragment.this).EiN);
            ContentFragment.this.fed();
            AppMethodBeat.o(97088);
          }
          
          public final void eWN() {}
          
          public final void eWO()
          {
            AppMethodBeat.i(97087);
            Log.d("ContentFragment", "onDownloadError nextBtn");
            AppMethodBeat.o(97087);
          }
        });
      }
      if (this.Eiv != null) {
        this.Eiv.q(this);
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
    if (this.Eik != null) {
      this.Eik.EhP.onDestroy();
    }
    fee();
    AppMethodBeat.o(97098);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(97097);
    super.onPause();
    Log.i("ContentFragment", this + " onPause " + getUserVisibleHint());
    this.cQp = false;
    this.Eik.cQp = this.cQp;
    if ((this.Eik != null) && (getUserVisibleHint())) {
      this.Eik.fdU();
    }
    if (this.EiA) {
      try
      {
        Log.d("ContentFragmentSphereImageView", "unRegisterSphereImageCompEventReceiver, hash=" + hashCode());
        d.W(getContext()).unregisterReceiver(this.EiC);
        AppMethodBeat.o(97097);
        return;
      }
      catch (Exception localException)
      {
        Log.e("ContentFragmentSphereImageView", "unRegisterSphereImageCompEventReceiver, exp:" + localException.toString());
      }
    }
    AppMethodBeat.o(97097);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(97096);
    super.onResume();
    Log.i("ContentFragment", this + " onResume " + getUserVisibleHint());
    this.cQp = true;
    Object localObject;
    if ((this.Eiw != null) && (this.Eiw.gvQ != null))
    {
      for (localObject = (ViewGroup)this.Eiw.gvQ.getParent(); (localObject != null) && ((localObject == null) || (((ViewGroup)localObject).getId() != 2131307157)); localObject = (ViewGroup)((ViewGroup)localObject).getParent()) {}
      if ((localObject instanceof FrameLayout))
      {
        int j = ((ViewGroup)localObject).getChildCount();
        int i = 0;
        while (i < j)
        {
          if ((((ViewGroup)localObject).getChildAt(i) instanceof SnsAdLandingPageFloatView)) {
            this.cQp = false;
          }
          i += 1;
        }
      }
    }
    this.Eik.cQp = this.cQp;
    if ((this.Eik != null) && (getUserVisibleHint())) {
      this.Eik.fcS();
    }
    if (this.EiA) {
      try
      {
        Log.d("ContentFragmentSphereImageView", "registerSphereImageCompEventReceiver, hash=" + hashCode());
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_show");
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_none");
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half");
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_hide");
        d.W(getContext()).a(this.EiC, (IntentFilter)localObject);
        AppMethodBeat.o(97096);
        return;
      }
      catch (Exception localException)
      {
        Log.e("ContentFragmentSphereImageView", "registerSphereImageCompEventReceiver, exp:" + localException.toString());
      }
    }
    AppMethodBeat.o(97096);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    AppMethodBeat.i(97099);
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      if (this.Eik != null)
      {
        this.Eik.fcS();
        AppMethodBeat.o(97099);
      }
    }
    else if (this.Eik != null) {
      this.Eik.fdU();
    }
    AppMethodBeat.o(97099);
  }
  
  public final void vj(boolean paramBoolean)
  {
    AppMethodBeat.i(97110);
    this.Eir = paramBoolean;
    if ((fef()) && (!paramBoolean))
    {
      fed();
      AppMethodBeat.o(97110);
      return;
    }
    fee();
    AppMethodBeat.o(97110);
  }
  
  public static abstract interface a
    extends Serializable
  {
    public abstract void q(ContentFragment paramContentFragment);
  }
  
  static final class b
  {
    public ImageView EiL = null;
    public OverScrollLinearout EiM = null;
    public ImageView EiN = null;
    public View EiO = null;
    public boolean EiP = false;
    LinearLayout EiQ;
    public View gvQ;
    public RecyclerView hak;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment
 * JD-Core Version:    0.7.0.1
 */