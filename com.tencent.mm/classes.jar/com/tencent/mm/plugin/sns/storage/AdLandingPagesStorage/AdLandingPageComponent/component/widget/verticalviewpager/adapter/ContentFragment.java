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
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.m;
import com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.FloatJumpCompHelper;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.at;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ar;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.DummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.bb;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView;
import com.tencent.mm.plugin.sns.ui.widget.ad.OverScrollLinearout;
import com.tencent.mm.plugin.sns.ui.widget.ad.OverScrollLinearout.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
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
  private LinearLayoutManager AJH;
  private final Map<String, Bitmap> QQt;
  public h QTX;
  private int QTZ;
  public com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b QUb;
  private int QUc;
  private at QUd;
  public boolean QUe;
  private boolean QUf;
  private boolean QUg;
  private boolean QUh;
  private boolean QUi;
  private ValueAnimator QUj;
  private int QUk;
  public int QUl;
  public boolean QUm;
  public String QUn;
  public a QUo;
  private b QUp;
  private a QUq;
  private boolean QUr;
  protected final String QUs;
  protected boolean QUt;
  protected boolean QUu;
  private BroadcastReceiver QUv;
  protected View.OnClickListener QUw;
  private View.OnClickListener QUx;
  private boolean QUy;
  private OverScrollLinearout.a QUz;
  private int bgColor;
  public boolean ffv;
  public boolean pIS;
  private int pQi;
  public Map<String, Object> params;
  private int pvg;
  private int sJv;
  private MMHandler tiG;
  
  public ContentFragment()
  {
    AppMethodBeat.i(97093);
    this.QQt = new WeakHashMap();
    this.QUc = 1000;
    this.QUi = false;
    this.QUs = "ContentFragmentSphereImageView";
    this.QUt = false;
    this.QUu = false;
    this.QUv = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(97091);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        Log.i("ContentFragmentSphereImageView", "onReceive, action=" + paramAnonymousContext + ", isSphereCom=" + ContentFragment.this.QUt + ", isFullScreen=" + ContentFragment.this.QUu);
        if ("com.tencent.mm.adlanding.sphereimage.next_page_view_show".equals(paramAnonymousContext))
        {
          paramAnonymousContext = ContentFragment.this.getActivity();
          if ((paramAnonymousContext instanceof SnsAdNativeLandingPagesUI))
          {
            boolean bool = ((SnsAdNativeLandingPagesUI)paramAnonymousContext).hnR();
            Log.i("ContentFragmentSphereImageView", "hasNextPage=".concat(String.valueOf(bool)));
            if (bool)
            {
              ContentFragment.c(ContentFragment.this).QUG.setVisibility(0);
              paramAnonymousContext = new AlphaAnimation(0.0F, 1.0F);
              paramAnonymousContext.setDuration(500L);
              ContentFragment.c(ContentFragment.this).QUG.startAnimation(paramAnonymousContext);
            }
          }
          AppMethodBeat.o(97091);
          return;
        }
        if ("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_none".equals(paramAnonymousContext))
        {
          if (ContentFragment.c(ContentFragment.this).QUG.getVisibility() == 0)
          {
            paramAnonymousContext = ObjectAnimator.ofFloat(ContentFragment.c(ContentFragment.this).QUG, "alpha", new float[] { 0.5F, 1.0F });
            paramAnonymousContext.setDuration(300L);
            paramAnonymousContext.start();
            AppMethodBeat.o(97091);
          }
        }
        else if ("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half".equals(paramAnonymousContext))
        {
          if (ContentFragment.c(ContentFragment.this).QUG.getVisibility() == 0)
          {
            paramAnonymousContext = ObjectAnimator.ofFloat(ContentFragment.c(ContentFragment.this).QUG, "alpha", new float[] { 1.0F, 0.5F });
            paramAnonymousContext.setDuration(300L);
            paramAnonymousContext.start();
            AppMethodBeat.o(97091);
          }
        }
        else if (("com.tencent.mm.adlanding.sphereimage.next_page_view_hide".equals(paramAnonymousContext)) && (ContentFragment.c(ContentFragment.this).QUG.getVisibility() == 0))
        {
          paramAnonymousContext = new AlphaAnimation(1.0F, 0.0F);
          paramAnonymousContext.setDuration(250L);
          paramAnonymousContext.setFillAfter(true);
          ContentFragment.c(ContentFragment.this).QUG.startAnimation(paramAnonymousContext);
        }
        AppMethodBeat.o(97091);
      }
    };
    this.QUw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97092);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = ContentFragment.this.getActivity();
        if ((paramAnonymousView instanceof SnsAdNativeLandingPagesUI))
        {
          Log.i("ContentFragmentSphereImageView", "jumpNextPage");
          ((SnsAdNativeLandingPagesUI)paramAnonymousView).hnQ();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97092);
      }
    };
    this.QUx = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(307274);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        for (;;)
        {
          try
          {
            paramAnonymousView = ContentFragment.this.getRecyclerView();
            if (paramAnonymousView == null)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(307274);
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
                AppMethodBeat.o(307274);
              }
            }
            else
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(307274);
              return;
            }
            int i = localLinearLayoutManager.Jw();
            int j = localLinearLayoutManager.getItemCount();
            if ((i < 0) || (j <= 0))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(307274);
              return;
            }
            if (i == j - 1) {
              continue;
            }
            Log.i("ContentFragment.VideoPlay", "By recyclerView, can scrollVertically");
            paramAnonymousView.a(0, ContentFragment.h(ContentFragment.this), null);
          }
          finally
          {
            Log.e("ContentFragment.VideoPlay", paramAnonymousView.toString());
            continue;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(307274);
          return;
          Log.i("ContentFragment.VideoPlay", "By recyclerView, can not scrollVertically");
          if (((SnsAdNativeLandingPagesUI)localObject).hnR())
          {
            Log.i("ContentFragment.VideoPlay", "By viewPager, jumpNextPage");
            ((SnsAdNativeLandingPagesUI)localObject).hnQ();
          }
        }
      }
    };
    this.QUy = false;
    this.QUz = new OverScrollLinearout.a()
    {
      public final void dm(float paramAnonymousFloat)
      {
        AppMethodBeat.i(307275);
        int i = (int)(paramAnonymousFloat * 0.8D);
        if ((ContentFragment.c(ContentFragment.this) == null) || (ContentFragment.c(ContentFragment.this).QUE == null) || (ContentFragment.c(ContentFragment.this).QUE.getScrollY() + i <= 0))
        {
          AppMethodBeat.o(307275);
          return;
        }
        int j = ContentFragment.this.hkj();
        if (j > 0)
        {
          int k = ContentFragment.c(ContentFragment.this).QUE.getScrollY();
          if (k < j)
          {
            i = Math.min(i, j - k);
            ContentFragment.c(ContentFragment.this).QUE.scrollBy(0, i);
          }
          AppMethodBeat.o(307275);
          return;
        }
        Object localObject = ContentFragment.o(ContentFragment.this).hjT();
        if (!(localObject instanceof p))
        {
          AppMethodBeat.o(307275);
          return;
        }
        localObject = (p)localObject;
        if (ContentFragment.c(ContentFragment.this).QUE.getScrollY() + i < ((p)localObject).QPj)
        {
          ContentFragment.c(ContentFragment.this).QUE.scrollBy(0, i);
          AppMethodBeat.o(307275);
          return;
        }
        if (!ContentFragment.p(ContentFragment.this))
        {
          ContentFragment.c(ContentFragment.this, true);
          ((p)localObject).hjq();
        }
        AppMethodBeat.o(307275);
      }
      
      public final void hjE()
      {
        AppMethodBeat.i(307278);
        ContentFragment.c(ContentFragment.this, false);
        AppMethodBeat.o(307278);
      }
      
      public final boolean hkk()
      {
        AppMethodBeat.i(307277);
        int i = ContentFragment.this.hkj();
        int j = ContentFragment.q(ContentFragment.this).Jw();
        boolean bool = ContentFragment.this.getRecyclerView().canScrollVertically(1);
        n localn = ContentFragment.o(ContentFragment.this).hjT();
        if ((ContentFragment.r(ContentFragment.this)) && (!bool) && (j == ContentFragment.o(ContentFragment.this).getItemCount() - 1) && ((i > 0) || ((localn instanceof p))))
        {
          AppMethodBeat.o(307277);
          return true;
        }
        AppMethodBeat.o(307277);
        return false;
      }
    };
    AppMethodBeat.o(97093);
  }
  
  private void aO(Bitmap paramBitmap)
  {
    AppMethodBeat.i(97105);
    if (paramBitmap != null)
    {
      this.QUp.lBX.setBackgroundColor(0);
      this.QUp.CSN.setBackgroundColor(0);
      this.QUp.QUE.setBackgroundColor(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.QUp.CSN.getLayoutParams();
      if (localLayoutParams.height >= this.pvg) {}
      for (int i = localLayoutParams.height;; i = this.pvg)
      {
        localLayoutParams.height = i;
        this.QUp.CSN.setLayoutParams(localLayoutParams);
        this.QUp.CSN.setImageBitmap(paramBitmap);
        AppMethodBeat.o(97105);
        return;
      }
    }
    hka();
    AppMethodBeat.o(97105);
  }
  
  private void b(h paramh)
  {
    AppMethodBeat.i(97111);
    this.QUt = false;
    this.QUu = false;
    if ((paramh != null) && (paramh.QXi != null))
    {
      paramh = paramh.QXi.iterator();
      while (paramh.hasNext())
      {
        aa localaa = (aa)paramh.next();
        if ((localaa instanceof v))
        {
          paramh = (v)localaa;
          if ((paramh.QKi) || (paramh.width == 0.0F) || (paramh.height == 0.0F)) {
            this.QUu = true;
          }
          this.QUt = true;
        }
      }
    }
    Log.i("ContentFragmentSphereImageView", "checkSphereImageComp, isSphereImageViewCompPage=" + this.QUt + ", isFullScreen=" + this.QUu);
    AppMethodBeat.o(97111);
  }
  
  private void bgE()
  {
    AppMethodBeat.i(97103);
    if (this.QUp == null)
    {
      AppMethodBeat.o(97103);
      return;
    }
    hka();
    final String str;
    if ((this.QTX.QXg != null) && (this.QTX.QXg.length() > 0))
    {
      str = this.QTX.QXg;
      Log.i("ContentFragment", "bg need blur %b, url %s", new Object[] { Boolean.valueOf(this.QTX.QXh), str });
      if (this.QQt.containsKey(str))
      {
        Log.i("ContentFragment", "bg has cache bitmap");
        aO((Bitmap)this.QQt.get(str));
        if (this.QUq != null) {
          if ((this.QTX.QXg == null) || (this.QTX.QXg.length() <= 0)) {
            break label204;
          }
        }
      }
    }
    label204:
    for (this.QUq.bgColor = 0;; this.QUq.bgColor = this.bgColor)
    {
      this.QUq.a(this.QTX);
      AppMethodBeat.o(97103);
      return;
      k.b("adId", str, new g.a()
      {
        public final void aWn(String paramAnonymousString)
        {
          AppMethodBeat.i(97081);
          ContentFragment.a(ContentFragment.this, paramAnonymousString, "adId", str);
          AppMethodBeat.o(97081);
        }
        
        public final void gZM() {}
        
        public final void gZN()
        {
          AppMethodBeat.i(97080);
          Log.i("ContentFragment", "download img fail %s", new Object[] { str });
          ContentFragment.e(ContentFragment.this);
          AppMethodBeat.o(97080);
        }
      });
      break;
      hka();
      break;
    }
  }
  
  private void hka()
  {
    AppMethodBeat.i(97104);
    if ((this.QTX.qWk != null) && (this.QTX.qWk.length() > 0)) {
      Log.i("ContentFragment", "setting bg color %s", new Object[] { this.QTX.qWk });
    }
    try
    {
      this.bgColor = Color.parseColor(this.QTX.qWk);
      this.QUp.lBX.setBackgroundColor(this.bgColor);
      this.QUp.CSN.setBackgroundColor(this.bgColor);
      this.QUp.QUE.setBackgroundColor(this.bgColor);
      AppMethodBeat.o(97104);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("ContentFragment", "the color is error : " + this.QTX.qWk);
      }
    }
  }
  
  private boolean hke()
  {
    boolean bool2 = true;
    AppMethodBeat.i(97109);
    if (!this.QUg)
    {
      AppMethodBeat.o(97109);
      return false;
    }
    if (this.QUk != 0)
    {
      AppMethodBeat.o(97109);
      return false;
    }
    if (this.QUl != 0)
    {
      AppMethodBeat.o(97109);
      return false;
    }
    if (this.QUt)
    {
      AppMethodBeat.o(97109);
      return false;
    }
    SnsAdNativeLandingPagesUI localSnsAdNativeLandingPagesUI = hkh();
    if ((localSnsAdNativeLandingPagesUI != null) && ((localSnsAdNativeLandingPagesUI.hnU()) || (localSnsAdNativeLandingPagesUI.RlM)))
    {
      AppMethodBeat.o(97109);
      return false;
    }
    int i = this.AJH.Ju();
    if ((i == this.AJH.Jw()) && (i == -1))
    {
      AppMethodBeat.o(97109);
      return false;
    }
    boolean bool1 = bool2;
    if (this.pIS) {
      if (this.AJH.Jw() == this.QUq.getItemCount() - 1) {
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
  
  private SnsAdNativeLandingPagesUI hkh()
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
  
  private ae hki()
  {
    AppMethodBeat.i(97115);
    Object localObject = hkh();
    if (localObject != null)
    {
      localObject = ((SnsAdNativeLandingPagesUI)localObject).Rla;
      AppMethodBeat.o(97115);
      return localObject;
    }
    AppMethodBeat.o(97115);
    return null;
  }
  
  public final void DW(boolean paramBoolean)
  {
    AppMethodBeat.i(97110);
    this.QUi = paramBoolean;
    if ((hke()) && (!paramBoolean))
    {
      hkb();
      AppMethodBeat.o(97110);
      return;
    }
    hkc();
    AppMethodBeat.o(97110);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(97102);
    if (this.QTX != paramh)
    {
      this.QTX = paramh;
      b(paramh);
      bgE();
    }
    AppMethodBeat.o(97102);
  }
  
  public final RecyclerView getRecyclerView()
  {
    if (this.QUp != null) {
      return this.QUp.mkw;
    }
    return null;
  }
  
  public final Collection<n> hjV()
  {
    AppMethodBeat.i(97106);
    if (this.QUq == null)
    {
      localObject = Collections.EMPTY_LIST;
      AppMethodBeat.o(97106);
      return localObject;
    }
    Object localObject = this.QUq.hjV();
    AppMethodBeat.o(97106);
    return localObject;
  }
  
  public final void hjW()
  {
    AppMethodBeat.i(307521);
    this.QUm = false;
    this.ffv = true;
    Object localObject;
    int j;
    int i;
    if ((this.QUp != null) && (this.QUp.lBX != null))
    {
      for (localObject = (ViewGroup)this.QUp.lBX.getParent(); (localObject != null) && ((localObject == null) || (((ViewGroup)localObject).getId() != b.f.root)); localObject = (ViewGroup)((ViewGroup)localObject).getParent()) {}
      if ((localObject instanceof FrameLayout))
      {
        j = ((ViewGroup)localObject).getChildCount();
        i = 0;
        while (i < j)
        {
          if ((((ViewGroup)localObject).getChildAt(i) instanceof SnsAdLandingPageFloatView)) {
            this.ffv = false;
          }
          i += 1;
        }
      }
    }
    this.QUb.ffv = this.ffv;
    if ((this.QUb != null) && (getUserVisibleHint()))
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b localb = this.QUb;
      h localh = this.QTX;
      String str = this.QUn;
      if ((localb.ffv) && (localb.AJH != null))
      {
        i = localb.AJH.Ju();
        j = localb.AJH.Jw();
        Log.d("RecyclerViewExposureMgr", "appear [%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if ((i == j) && (i == -1))
        {
          Log.i("RecyclerViewExposureMgr", "no exposuring child");
          AppMethodBeat.o(307521);
          return;
        }
        if (i <= j)
        {
          if (!((aa)localh.QXi.get(i)).QKG.equals(str))
          {
            b.a locala = (b.a)localb.QMY.get(Integer.valueOf(i));
            localObject = locala;
            if (locala == null)
            {
              localObject = new b.a(localb, (byte)0);
              localb.QMY.put(Integer.valueOf(i), localObject);
            }
            if (localb.QTG.all(i))
            {
              if (((b.a)localObject).QIM) {
                break label375;
              }
              localb.QTG.a(i, localb);
              ((b.a)localObject).hiI();
            }
          }
          for (;;)
          {
            i += 1;
            break;
            label375:
            if (localb.QTG.alm(i)) {
              localb.QTG.aln(i);
            }
          }
        }
      }
    }
    AppMethodBeat.o(307521);
  }
  
  public final void hjX()
  {
    AppMethodBeat.i(97100);
    if ((this.ffv) && (this.QUb != null)) {
      this.QUb.hjQ();
    }
    AppMethodBeat.o(97100);
  }
  
  public final boolean hjY()
  {
    AppMethodBeat.i(97101);
    try
    {
      Object localObject1 = this.QUq.hjT();
      if ((localObject1 != null) && ((((n)localObject1).QOV.type == 62) || (((n)localObject1).QOV.type == 61) || (((n)localObject1).QOV.type == 142)))
      {
        Log.i("ContentFragment", "isFloatBarCoverVideo, ret=true, lastComp is Video");
        AppMethodBeat.o(97101);
        return true;
      }
      Object localObject2 = this.QUq.hjU();
      if ((localObject2 != null) && ((((n)localObject2).QOV.type == 62) || (((n)localObject2).QOV.type == 61) || (((n)localObject1).QOV.type == 142)) && (localObject1 != null))
      {
        localObject1 = ((n)localObject1).getContentView();
        if (localObject1 != null)
        {
          localObject2 = new Rect();
          ((View)localObject1).getLocalVisibleRect((Rect)localObject2);
          int i = com.tencent.mm.cd.a.fromDPToPix(getContext(), 88);
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
  
  public final boolean hjZ()
  {
    return (this.QTX != null) && (this.QTX.QXm);
  }
  
  public final void hkb()
  {
    AppMethodBeat.i(97107);
    try
    {
      if ((hke()) && (!this.QUi))
      {
        boolean bool = this.QUp.QUH;
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(97107);
        return;
      }
      this.QUp.QUF.setVisibility(0);
      this.QUp.QUF.setTranslationY(-com.tencent.mm.cd.a.fromDPToPix(getContext(), 20));
      this.QUj.setRepeatMode(2);
      this.QUj.setRepeatCount(-1);
      this.QUj.start();
      AppMethodBeat.o(97107);
      return;
    }
    catch (Exception localException)
    {
      Log.e("ContentFragment", "startDownAnimation, exp=" + localException.toString());
      AppMethodBeat.o(97107);
    }
  }
  
  public final void hkc()
  {
    AppMethodBeat.i(97108);
    try
    {
      this.QUp.QUF.setVisibility(4);
      this.QUp.QUF.setTranslationY(-com.tencent.mm.cd.a.fromDPToPix(getContext(), 20));
      this.QUj.setRepeatMode(2);
      this.QUj.setRepeatCount(0);
      this.QUj.end();
      AppMethodBeat.o(97108);
      return;
    }
    catch (Exception localException)
    {
      Log.e("ContentFragment", "stopDownAnimation, exp=" + localException.toString());
      AppMethodBeat.o(97108);
    }
  }
  
  public final void hkd()
  {
    AppMethodBeat.i(307548);
    this.QUh = true;
    vb(0L);
    AppMethodBeat.o(307548);
  }
  
  public final boolean hkf()
  {
    AppMethodBeat.i(97112);
    try
    {
      ae localae = hki();
      boolean bool = this.pIS;
      if ((!bool) || (localae == null))
      {
        AppMethodBeat.o(97112);
        return true;
      }
      if (this.QUp.mkw != null)
      {
        int i = this.QUp.mkw.computeVerticalScrollOffset();
        int j = this.QUp.mkw.computeVerticalScrollExtent();
        j = this.QUp.mkw.computeVerticalScrollRange() - i - j;
        Log.d("ContentFragment", "bottomDis=" + j + ", appearBottom=" + localae.QLf + ", topDis=" + i + ", appearTop=" + localae.QLe + ", height=" + com.tencent.mm.cd.a.mt(getContext()));
        if (localae.QLf > 0)
        {
          i = localae.QLf;
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
  
  public final boolean hkg()
  {
    AppMethodBeat.i(97113);
    try
    {
      ae localae = hki();
      int i = this.QUp.mkw.computeVerticalScrollOffset();
      if ((this.QUe) && (localae != null))
      {
        if ((localae.QLe == 0) || ((localae.QLe > 0) && (i >= localae.QLe)))
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
  
  protected final int hkj()
  {
    AppMethodBeat.i(307559);
    Object localObject = getActivity();
    if ((localObject instanceof SnsAdNativeLandingPagesUI))
    {
      localObject = ((SnsAdNativeLandingPagesUI)localObject).Rms;
      if (localObject != null)
      {
        int i = ((FloatJumpCompHelper)localObject).PUq;
        AppMethodBeat.o(307559);
        return i;
      }
      AppMethodBeat.o(307559);
      return -1;
    }
    AppMethodBeat.o(307559);
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(97094);
    super.onCreate(paramBundle);
    paramBundle = this.params;
    int[] arrayOfInt = ar.jR(getContext());
    this.sJv = arrayOfInt[0];
    this.pvg = arrayOfInt[1];
    if (this.QTX == null)
    {
      this.QTX = ((h)paramBundle.get("pageInfo"));
      b(this.QTX);
    }
    this.QUd = ((at)paramBundle.get("pageDownIconInfo"));
    this.QUe = Util.nullAsFalse((Boolean)paramBundle.get("is_first_show_page"));
    this.pIS = Util.nullAsFalse((Boolean)paramBundle.get("is_last_shown_page"));
    this.QUf = Util.nullAsFalse((Boolean)paramBundle.get("needEnterAnimation"));
    this.QUg = Util.nullAsFalse((Boolean)paramBundle.get("needDirectionAnimation"));
    this.QTZ = Util.nullAsInt(paramBundle.get("groupListCompShowIndex"), 0);
    AppMethodBeat.o(97094);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(97095);
    paramLayoutInflater = paramLayoutInflater.inflate(b.g.ad_landing_page_item, paramViewGroup, false);
    this.QUp = new b((byte)0);
    this.QUp.lBX = paramLayoutInflater;
    this.QUp.CSN = ((ImageView)paramLayoutInflater.findViewById(b.f.sns_ad_native_landing_pages_background_img));
    this.QUp.QUE = ((OverScrollLinearout)paramLayoutInflater.findViewById(b.f.sns_ad_native_landing_pages_sub_linear_layout));
    if (this.pIS) {
      this.QUp.QUE.setOnScrollActionListener(this.QUz);
    }
    this.QUp.QUF = ((ImageView)paramLayoutInflater.findViewById(b.f.sns_native_landing_pages_next_img));
    this.QUp.QUG = paramLayoutInflater.findViewById(b.f.sns_native_landing_pages_sphere_comp_next_page_layout);
    this.QUp.QUG.setOnClickListener(this.QUw);
    this.QUp.QUF.setOnClickListener(this.QUx);
    this.QUp.mkw = ((RecyclerView)paramLayoutInflater.findViewById(b.f.content_list));
    this.QUp.QUI = ((LinearLayout)paramLayoutInflater.findViewById(b.f.fake_container));
    paramViewGroup = this.QUp.mkw;
    paramViewGroup.setOverScrollMode(0);
    int i = Util.nullAsInt(this.params.get("pageCount"), 0);
    Log.d("ContentFragment", "initRecyclerView, pageCount=".concat(String.valueOf(i)));
    if (i > 1) {
      paramViewGroup.setOnTouchListener(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.b((DummyViewPager)this.params.get("viewPager")));
    }
    for (;;)
    {
      getActivity();
      this.AJH = new LinearLayoutManager();
      paramViewGroup.setLayoutManager(this.AJH);
      this.QUq = new a(this.QTX, this.bgColor, getActivity(), this.AJH);
      if (this.QUe) {
        this.QUq.QTZ = this.QTZ;
      }
      paramViewGroup.setAdapter(this.QUq);
      paramViewGroup.setDescendantFocusability(131072);
      this.QUb = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b(paramViewGroup);
      paramViewGroup.a(new RecyclerView.l()
      {
        public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(307276);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousRecyclerView);
          localb.sc(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
          super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
          ContentFragment.a(ContentFragment.this, paramAnonymousInt);
          if (paramAnonymousInt == 0)
          {
            ContentFragment.this.vb(50L);
            if (ContentFragment.d(ContentFragment.this)) {
              ContentFragment.this.hkb();
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
            AppMethodBeat.o(307276);
            return;
            if (paramAnonymousInt == 1)
            {
              ContentFragment.this.hkc();
              ar.jS(ContentFragment.this.getContext());
            }
          }
        }
        
        public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(307273);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousRecyclerView);
          localb.sc(paramAnonymousInt1);
          localb.sc(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
          super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          if ((ContentFragment.c(ContentFragment.this).CSN != null) && (ContentFragment.c(ContentFragment.this).CSN.getVisibility() == 0)) {
            ContentFragment.c(ContentFragment.this).CSN.scrollBy(paramAnonymousInt1, paramAnonymousInt2);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(307273);
        }
      });
      paramLayoutInflater.setTag(this.QUp);
      bgE();
      this.QUj = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.QUj.setDuration(this.QUc);
      this.QUj.setInterpolator(new AccelerateDecelerateInterpolator());
      this.QUj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(97084);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          ContentFragment.c(ContentFragment.this).QUF.setTranslationY((int)(f * -com.tencent.mm.cd.a.fromDPToPix(ContentFragment.this.getContext(), 20)));
          AppMethodBeat.o(97084);
        }
      });
      this.QUj.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(97086);
          Log.d("ContentFragment", "onAnimationEnd show nextBtn");
          ContentFragment.c(ContentFragment.this).QUH = false;
          AppMethodBeat.o(97086);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(97085);
          Log.d("ContentFragment", "onAnimationStart show nextBtn");
          ContentFragment.c(ContentFragment.this).QUH = true;
          AppMethodBeat.o(97085);
        }
      });
      this.QUj.setRepeatCount(-1);
      this.QUj.setRepeatMode(2);
      if ((this.QUd != null) && (!this.QUd.equals(this.QUp.QUF.getTag())))
      {
        this.QUp.QUF.setTag(this.QUd);
        this.QUp.QUF.setVisibility(8);
        k.b("adId", this.QUd.iconUrl, new g.a()
        {
          public final void aWn(String paramAnonymousString)
          {
            AppMethodBeat.i(97088);
            Log.d("ContentFragment", "onDownloaded nextBtn");
            ContentFragment.a(ContentFragment.this, paramAnonymousString, ContentFragment.c(ContentFragment.this).QUF);
            ContentFragment.this.hkb();
            AppMethodBeat.o(97088);
          }
          
          public final void gZM() {}
          
          public final void gZN()
          {
            AppMethodBeat.i(97087);
            Log.d("ContentFragment", "onDownloadError nextBtn");
            AppMethodBeat.o(97087);
          }
        });
      }
      if (this.QUo != null) {
        this.QUo.s(this);
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
    if (this.QUb != null) {
      this.QUb.QTG.onDestroy();
    }
    hkc();
    AppMethodBeat.o(97098);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(97097);
    super.onPause();
    Log.i("ContentFragment", this + " onPause " + getUserVisibleHint());
    this.ffv = false;
    this.QUb.ffv = this.ffv;
    if ((this.QUb != null) && (getUserVisibleHint())) {
      this.QUb.hjR();
    }
    if (this.QUt) {
      try
      {
        Log.d("ContentFragmentSphereImageView", "unRegisterSphereImageCompEventReceiver, hash=" + hashCode());
        androidx.i.a.a.al(getContext()).unregisterReceiver(this.QUv);
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
    this.ffv = true;
    Object localObject;
    if ((this.QUp != null) && (this.QUp.lBX != null))
    {
      for (localObject = (ViewGroup)this.QUp.lBX.getParent(); (localObject != null) && ((localObject == null) || (((ViewGroup)localObject).getId() != b.f.root)); localObject = (ViewGroup)((ViewGroup)localObject).getParent()) {}
      if ((localObject instanceof FrameLayout))
      {
        int j = ((ViewGroup)localObject).getChildCount();
        int i = 0;
        while (i < j)
        {
          if ((((ViewGroup)localObject).getChildAt(i) instanceof SnsAdLandingPageFloatView)) {
            this.ffv = false;
          }
          i += 1;
        }
      }
    }
    if ((this.QUm) && (!Util.isNullOrNil(this.QUn)))
    {
      this.ffv = false;
      if ((this.QUb != null) && (getUserVisibleHint())) {
        this.QUb.a(this.QTX, this.QUn);
      }
    }
    this.QUb.ffv = this.ffv;
    if ((this.QUb != null) && (getUserVisibleHint())) {
      this.QUb.hiH();
    }
    if (this.QUt) {
      try
      {
        Log.d("ContentFragmentSphereImageView", "registerSphereImageCompEventReceiver, hash=" + hashCode());
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_show");
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_none");
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half");
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_hide");
        androidx.i.a.a.al(getContext()).a(this.QUv, (IntentFilter)localObject);
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
      if (this.QUb != null)
      {
        this.QUb.hiH();
        AppMethodBeat.o(97099);
      }
    }
    else if (this.QUb != null) {
      this.QUb.hjR();
    }
    AppMethodBeat.o(97099);
  }
  
  public final void vb(long paramLong)
  {
    AppMethodBeat.i(97116);
    SnsAdNativeLandingPagesUI localSnsAdNativeLandingPagesUI = hkh();
    if (localSnsAdNativeLandingPagesUI != null) {
      localSnsAdNativeLandingPagesUI.vb(paramLong);
    }
    AppMethodBeat.o(97116);
  }
  
  public static abstract interface a
    extends Serializable
  {
    public abstract void s(ContentFragment paramContentFragment);
  }
  
  static final class b
  {
    public ImageView CSN = null;
    public OverScrollLinearout QUE = null;
    public ImageView QUF = null;
    public View QUG = null;
    public boolean QUH = false;
    LinearLayout QUI;
    public View lBX;
    public RecyclerView mkw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment
 * JD-Core Version:    0.7.0.1
 */