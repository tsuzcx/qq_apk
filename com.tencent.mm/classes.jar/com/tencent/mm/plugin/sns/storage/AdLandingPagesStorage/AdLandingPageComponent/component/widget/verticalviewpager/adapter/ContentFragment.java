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
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.FloatJumpCompHelper;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ar;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ao;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.DummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.ba;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView;
import com.tencent.mm.plugin.sns.ui.widget.ad.OverScrollLinearout;
import com.tencent.mm.plugin.sns.ui.widget.ad.OverScrollLinearout.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
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
  private LinearLayoutManager Arh;
  private final Map<String, Bitmap> KrX;
  private int KvA;
  public int KvB;
  public boolean KvC;
  public String KvD;
  public a KvE;
  private b KvF;
  private a KvG;
  private boolean KvH;
  protected final String KvI;
  protected boolean KvJ;
  protected boolean KvK;
  private BroadcastReceiver KvL;
  protected View.OnClickListener KvM;
  private View.OnClickListener KvN;
  private boolean KvO;
  private OverScrollLinearout.a KvP;
  public g Kvn;
  private int Kvp;
  public c Kvr;
  private int Kvs;
  private ar Kvt;
  public boolean Kvu;
  private boolean Kvv;
  private boolean Kvw;
  private boolean Kvx;
  private boolean Kvy;
  private ValueAnimator Kvz;
  private int bgColor;
  public boolean dgo;
  public boolean mMk;
  private int mTB;
  private int pEj;
  private int pEk;
  public Map<String, Object> params;
  private MMHandler qdR;
  
  public ContentFragment()
  {
    AppMethodBeat.i(97093);
    this.KrX = new WeakHashMap();
    this.Kvs = 1000;
    this.Kvy = false;
    this.KvI = "ContentFragmentSphereImageView";
    this.KvJ = false;
    this.KvK = false;
    this.KvL = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(97091);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        Log.i("ContentFragmentSphereImageView", "onReceive, action=" + paramAnonymousContext + ", isSphereCom=" + ContentFragment.this.KvJ + ", isFullScreen=" + ContentFragment.this.KvK);
        if ("com.tencent.mm.adlanding.sphereimage.next_page_view_show".equals(paramAnonymousContext))
        {
          paramAnonymousContext = ContentFragment.this.getActivity();
          if ((paramAnonymousContext instanceof SnsAdNativeLandingPagesUI))
          {
            boolean bool = ((SnsAdNativeLandingPagesUI)paramAnonymousContext).fVC();
            Log.i("ContentFragmentSphereImageView", "hasNextPage=".concat(String.valueOf(bool)));
            if (bool)
            {
              ContentFragment.c(ContentFragment.this).KvX.setVisibility(0);
              paramAnonymousContext = new AlphaAnimation(0.0F, 1.0F);
              paramAnonymousContext.setDuration(500L);
              ContentFragment.c(ContentFragment.this).KvX.startAnimation(paramAnonymousContext);
            }
          }
          AppMethodBeat.o(97091);
          return;
        }
        if ("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_none".equals(paramAnonymousContext))
        {
          if (ContentFragment.c(ContentFragment.this).KvX.getVisibility() == 0)
          {
            paramAnonymousContext = ObjectAnimator.ofFloat(ContentFragment.c(ContentFragment.this).KvX, "alpha", new float[] { 0.5F, 1.0F });
            paramAnonymousContext.setDuration(300L);
            paramAnonymousContext.start();
            AppMethodBeat.o(97091);
          }
        }
        else if ("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half".equals(paramAnonymousContext))
        {
          if (ContentFragment.c(ContentFragment.this).KvX.getVisibility() == 0)
          {
            paramAnonymousContext = ObjectAnimator.ofFloat(ContentFragment.c(ContentFragment.this).KvX, "alpha", new float[] { 1.0F, 0.5F });
            paramAnonymousContext.setDuration(300L);
            paramAnonymousContext.start();
            AppMethodBeat.o(97091);
          }
        }
        else if (("com.tencent.mm.adlanding.sphereimage.next_page_view_hide".equals(paramAnonymousContext)) && (ContentFragment.c(ContentFragment.this).KvX.getVisibility() == 0))
        {
          paramAnonymousContext = new AlphaAnimation(1.0F, 0.0F);
          paramAnonymousContext.setDuration(250L);
          paramAnonymousContext.setFillAfter(true);
          ContentFragment.c(ContentFragment.this).KvX.startAnimation(paramAnonymousContext);
        }
        AppMethodBeat.o(97091);
      }
    };
    this.KvM = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97092);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = ContentFragment.this.getActivity();
        if ((paramAnonymousView instanceof SnsAdNativeLandingPagesUI))
        {
          Log.i("ContentFragmentSphereImageView", "jumpNextPage");
          ((SnsAdNativeLandingPagesUI)paramAnonymousView).fVB();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97092);
      }
    };
    this.KvN = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(268492);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        for (;;)
        {
          try
          {
            paramAnonymousView = ContentFragment.this.getRecyclerView();
            if (paramAnonymousView == null)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(268492);
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
                AppMethodBeat.o(268492);
              }
            }
            else
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(268492);
              return;
            }
            int i = localLinearLayoutManager.kL();
            int j = localLinearLayoutManager.getItemCount();
            if ((i < 0) || (j <= 0))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(268492);
              return;
            }
            if (i == j - 1) {
              continue;
            }
            Log.i("ContentFragment.VideoPlay", "By recyclerView, can scrollVertically");
            paramAnonymousView.a(0, ContentFragment.h(ContentFragment.this), null);
          }
          catch (Throwable paramAnonymousView)
          {
            Log.e("ContentFragment.VideoPlay", paramAnonymousView.toString());
            continue;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(268492);
          return;
          Log.i("ContentFragment.VideoPlay", "By recyclerView, can not scrollVertically");
          if (((SnsAdNativeLandingPagesUI)localObject).fVC())
          {
            Log.i("ContentFragment.VideoPlay", "By viewPager, jumpNextPage");
            ((SnsAdNativeLandingPagesUI)localObject).fVB();
          }
        }
      }
    };
    this.KvO = false;
    this.KvP = new OverScrollLinearout.a()
    {
      public final void cd(float paramAnonymousFloat)
      {
        AppMethodBeat.i(248875);
        int i = (int)(paramAnonymousFloat * 0.8D);
        if ((ContentFragment.c(ContentFragment.this) == null) || (ContentFragment.c(ContentFragment.this).KvV == null) || (ContentFragment.c(ContentFragment.this).KvV.getScrollY() + i <= 0))
        {
          AppMethodBeat.o(248875);
          return;
        }
        int j = ContentFragment.this.fSe();
        if (j > 0)
        {
          int k = ContentFragment.c(ContentFragment.this).KvV.getScrollY();
          if (k < j)
          {
            i = Math.min(i, j - k);
            ContentFragment.c(ContentFragment.this).KvV.scrollBy(0, i);
          }
          AppMethodBeat.o(248875);
          return;
        }
        Object localObject = ContentFragment.o(ContentFragment.this).fRO();
        if (!(localObject instanceof o))
        {
          AppMethodBeat.o(248875);
          return;
        }
        localObject = (o)localObject;
        if (ContentFragment.c(ContentFragment.this).KvV.getScrollY() + i < ((o)localObject).KqO)
        {
          ContentFragment.c(ContentFragment.this).KvV.scrollBy(0, i);
          AppMethodBeat.o(248875);
          return;
        }
        if (!ContentFragment.p(ContentFragment.this))
        {
          ContentFragment.a(ContentFragment.this, true);
          ((o)localObject).fRs();
        }
        AppMethodBeat.o(248875);
      }
      
      public final void fRE()
      {
        AppMethodBeat.i(248879);
        ContentFragment.a(ContentFragment.this, false);
        AppMethodBeat.o(248879);
      }
      
      public final boolean fSf()
      {
        AppMethodBeat.i(248878);
        int i = ContentFragment.this.fSe();
        int j = ContentFragment.q(ContentFragment.this).kL();
        boolean bool = ContentFragment.this.getRecyclerView().canScrollVertically(1);
        m localm = ContentFragment.o(ContentFragment.this).fRO();
        if ((ContentFragment.r(ContentFragment.this)) && (!bool) && (j == ContentFragment.o(ContentFragment.this).getItemCount() - 1) && ((i > 0) || ((localm instanceof o))))
        {
          AppMethodBeat.o(248878);
          return true;
        }
        AppMethodBeat.o(248878);
        return false;
      }
    };
    AppMethodBeat.o(97093);
  }
  
  private void aMU()
  {
    AppMethodBeat.i(97103);
    if (this.KvF == null)
    {
      AppMethodBeat.o(97103);
      return;
    }
    fRV();
    final String str;
    if ((this.Kvn.Kyn != null) && (this.Kvn.Kyn.length() > 0))
    {
      str = this.Kvn.Kyn;
      Log.i("ContentFragment", "bg need blur %b, url %s", new Object[] { Boolean.valueOf(this.Kvn.Kyo), str });
      if (this.KrX.containsKey(str))
      {
        Log.i("ContentFragment", "bg has cache bitmap");
        aw((Bitmap)this.KrX.get(str));
        if (this.KvG != null) {
          if ((this.Kvn.Kyn == null) || (this.Kvn.Kyn.length() <= 0)) {
            break label200;
          }
        }
      }
    }
    label200:
    for (this.KvG.bgColor = 0;; this.KvG.bgColor = this.bgColor)
    {
      this.KvG.a(this.Kvn);
      AppMethodBeat.o(97103);
      return;
      h.a("adId", str, new f.a()
      {
        public final void aYs(String paramAnonymousString)
        {
          AppMethodBeat.i(97081);
          ContentFragment.a(ContentFragment.this, paramAnonymousString, "adId", str);
          AppMethodBeat.o(97081);
        }
        
        public final void fJU() {}
        
        public final void fJV()
        {
          AppMethodBeat.i(97080);
          Log.i("ContentFragment", "download img fail %s", new Object[] { str });
          ContentFragment.e(ContentFragment.this);
          AppMethodBeat.o(97080);
        }
      });
      break;
      fRV();
      break;
    }
  }
  
  private void aw(Bitmap paramBitmap)
  {
    AppMethodBeat.i(97105);
    if (paramBitmap != null)
    {
      this.KvF.jac.setBackgroundColor(0);
      this.KvF.KvU.setBackgroundColor(0);
      this.KvF.KvV.setBackgroundColor(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.KvF.KvU.getLayoutParams();
      if (localLayoutParams.height >= this.pEk) {}
      for (int i = localLayoutParams.height;; i = this.pEk)
      {
        localLayoutParams.height = i;
        this.KvF.KvU.setLayoutParams(localLayoutParams);
        this.KvF.KvU.setImageBitmap(paramBitmap);
        AppMethodBeat.o(97105);
        return;
      }
    }
    fRV();
    AppMethodBeat.o(97105);
  }
  
  private void b(g paramg)
  {
    AppMethodBeat.i(97111);
    this.KvJ = false;
    this.KvK = false;
    if ((paramg != null) && (paramg.Kyp != null))
    {
      paramg = paramg.Kyp.iterator();
      while (paramg.hasNext())
      {
        aa localaa = (aa)paramg.next();
        if ((localaa instanceof v))
        {
          paramg = (v)localaa;
          if ((paramg.Kme) || (paramg.width == 0.0F) || (paramg.height == 0.0F)) {
            this.KvK = true;
          }
          this.KvJ = true;
        }
      }
    }
    Log.i("ContentFragmentSphereImageView", "checkSphereImageComp, isSphereImageViewCompPage=" + this.KvJ + ", isFullScreen=" + this.KvK);
    AppMethodBeat.o(97111);
  }
  
  private void fRV()
  {
    AppMethodBeat.i(97104);
    if ((this.Kvn.nWx != null) && (this.Kvn.nWx.length() > 0)) {
      Log.i("ContentFragment", "setting bg color %s", new Object[] { this.Kvn.nWx });
    }
    try
    {
      this.bgColor = Color.parseColor(this.Kvn.nWx);
      this.KvF.jac.setBackgroundColor(this.bgColor);
      this.KvF.KvU.setBackgroundColor(this.bgColor);
      this.KvF.KvV.setBackgroundColor(this.bgColor);
      AppMethodBeat.o(97104);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("ContentFragment", "the color is error : " + this.Kvn.nWx);
      }
    }
  }
  
  private boolean fRZ()
  {
    boolean bool2 = true;
    AppMethodBeat.i(97109);
    if (!this.Kvw)
    {
      AppMethodBeat.o(97109);
      return false;
    }
    if (this.KvA != 0)
    {
      AppMethodBeat.o(97109);
      return false;
    }
    if (this.KvB != 0)
    {
      AppMethodBeat.o(97109);
      return false;
    }
    if (this.KvJ)
    {
      AppMethodBeat.o(97109);
      return false;
    }
    SnsAdNativeLandingPagesUI localSnsAdNativeLandingPagesUI = fSc();
    if ((localSnsAdNativeLandingPagesUI != null) && ((localSnsAdNativeLandingPagesUI.fVF()) || (localSnsAdNativeLandingPagesUI.KMa)))
    {
      AppMethodBeat.o(97109);
      return false;
    }
    int i = this.Arh.kJ();
    if ((i == this.Arh.kL()) && (i == -1))
    {
      AppMethodBeat.o(97109);
      return false;
    }
    boolean bool1 = bool2;
    if (this.mMk) {
      if (this.Arh.kL() == this.KvG.getItemCount() - 1) {
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
  
  private SnsAdNativeLandingPagesUI fSc()
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
  
  private ae fSd()
  {
    AppMethodBeat.i(97115);
    Object localObject = fSc();
    if (localObject != null)
    {
      localObject = ((SnsAdNativeLandingPagesUI)localObject).KLn;
      AppMethodBeat.o(97115);
      return localObject;
    }
    AppMethodBeat.o(97115);
    return null;
  }
  
  public final void QV(long paramLong)
  {
    AppMethodBeat.i(97116);
    SnsAdNativeLandingPagesUI localSnsAdNativeLandingPagesUI = fSc();
    if (localSnsAdNativeLandingPagesUI != null) {
      localSnsAdNativeLandingPagesUI.QV(paramLong);
    }
    AppMethodBeat.o(97116);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(97102);
    if (this.Kvn != paramg)
    {
      this.Kvn = paramg;
      b(paramg);
      aMU();
    }
    AppMethodBeat.o(97102);
  }
  
  public final Collection<m> fRQ()
  {
    AppMethodBeat.i(97106);
    if (this.KvG == null)
    {
      localObject = Collections.EMPTY_LIST;
      AppMethodBeat.o(97106);
      return localObject;
    }
    Object localObject = this.KvG.fRQ();
    AppMethodBeat.o(97106);
    return localObject;
  }
  
  public final void fRR()
  {
    AppMethodBeat.i(266863);
    this.KvC = false;
    this.dgo = true;
    Object localObject;
    int j;
    int i;
    if ((this.KvF != null) && (this.KvF.jac != null))
    {
      for (localObject = (ViewGroup)this.KvF.jac.getParent(); (localObject != null) && ((localObject == null) || (((ViewGroup)localObject).getId() != i.f.root)); localObject = (ViewGroup)((ViewGroup)localObject).getParent()) {}
      if ((localObject instanceof FrameLayout))
      {
        j = ((ViewGroup)localObject).getChildCount();
        i = 0;
        while (i < j)
        {
          if ((((ViewGroup)localObject).getChildAt(i) instanceof SnsAdLandingPageFloatView)) {
            this.dgo = false;
          }
          i += 1;
        }
      }
    }
    this.Kvr.dgo = this.dgo;
    if ((this.Kvr != null) && (getUserVisibleHint()))
    {
      c localc = this.Kvr;
      g localg = this.Kvn;
      String str = this.KvD;
      if ((localc.dgo) && (localc.Arh != null))
      {
        i = localc.Arh.kJ();
        j = localc.Arh.kL();
        Log.d("RecyclerViewExposureMgr", "appear [%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if ((i == j) && (i == -1))
        {
          Log.i("RecyclerViewExposureMgr", "no exposuring child");
          AppMethodBeat.o(266863);
          return;
        }
        if (i <= j)
        {
          if (!((aa)localg.Kyp.get(i)).KmB.equals(str))
          {
            c.a locala = (c.a)localc.KoR.get(Integer.valueOf(i));
            localObject = locala;
            if (locala == null)
            {
              localObject = new c.a(localc, (byte)0);
              localc.KoR.put(Integer.valueOf(i), localObject);
            }
            if (localc.KuW.agt(i))
            {
              if (((c.a)localObject).KkF) {
                break label375;
              }
              localc.KuW.a(i, localc);
              ((c.a)localObject).fQK();
            }
          }
          for (;;)
          {
            i += 1;
            break;
            label375:
            if (localc.KuW.agu(i)) {
              localc.KuW.agv(i);
            }
          }
        }
      }
    }
    AppMethodBeat.o(266863);
  }
  
  public final void fRS()
  {
    AppMethodBeat.i(97100);
    if ((this.dgo) && (this.Kvr != null)) {
      this.Kvr.fRL();
    }
    AppMethodBeat.o(97100);
  }
  
  public final boolean fRT()
  {
    AppMethodBeat.i(97101);
    try
    {
      Object localObject1 = this.KvG.fRO();
      if ((localObject1 != null) && ((((m)localObject1).KqB.type == 62) || (((m)localObject1).KqB.type == 61) || (((m)localObject1).KqB.type == 142)))
      {
        Log.i("ContentFragment", "isFloatBarCoverVideo, ret=true, lastComp is Video");
        AppMethodBeat.o(97101);
        return true;
      }
      Object localObject2 = this.KvG.fRP();
      if ((localObject2 != null) && ((((m)localObject2).KqB.type == 62) || (((m)localObject2).KqB.type == 61) || (((m)localObject1).KqB.type == 142)) && (localObject1 != null))
      {
        localObject1 = ((m)localObject1).getContentView();
        if (localObject1 != null)
        {
          localObject2 = new Rect();
          ((View)localObject1).getLocalVisibleRect((Rect)localObject2);
          int i = com.tencent.mm.ci.a.fromDPToPix(getContext(), 88);
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
  
  public final boolean fRU()
  {
    return (this.Kvn != null) && (this.Kvn.Kyt);
  }
  
  public final void fRW()
  {
    AppMethodBeat.i(97107);
    try
    {
      if ((fRZ()) && (!this.Kvy))
      {
        boolean bool = this.KvF.KvY;
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(97107);
        return;
      }
      this.KvF.KvW.setVisibility(0);
      this.KvF.KvW.setTranslationY(-com.tencent.mm.ci.a.fromDPToPix(getContext(), 20));
      this.Kvz.setRepeatMode(2);
      this.Kvz.setRepeatCount(-1);
      this.Kvz.start();
      AppMethodBeat.o(97107);
      return;
    }
    catch (Exception localException)
    {
      Log.e("ContentFragment", "startDownAnimation, exp=" + localException.toString());
      AppMethodBeat.o(97107);
    }
  }
  
  public final void fRX()
  {
    AppMethodBeat.i(97108);
    try
    {
      this.KvF.KvW.setVisibility(4);
      this.KvF.KvW.setTranslationY(-com.tencent.mm.ci.a.fromDPToPix(getContext(), 20));
      this.Kvz.setRepeatMode(2);
      this.Kvz.setRepeatCount(0);
      this.Kvz.end();
      AppMethodBeat.o(97108);
      return;
    }
    catch (Exception localException)
    {
      Log.e("ContentFragment", "stopDownAnimation, exp=" + localException.toString());
      AppMethodBeat.o(97108);
    }
  }
  
  public final void fRY()
  {
    AppMethodBeat.i(266869);
    this.Kvx = true;
    QV(0L);
    AppMethodBeat.o(266869);
  }
  
  public final boolean fSa()
  {
    AppMethodBeat.i(97112);
    try
    {
      ae localae = fSd();
      boolean bool = this.mMk;
      if ((!bool) || (localae == null))
      {
        AppMethodBeat.o(97112);
        return true;
      }
      if (this.KvF.jLl != null)
      {
        int i = this.KvF.jLl.computeVerticalScrollOffset();
        int j = this.KvF.jLl.computeVerticalScrollExtent();
        j = this.KvF.jLl.computeVerticalScrollRange() - i - j;
        Log.d("ContentFragment", "bottomDis=" + j + ", appearBottom=" + localae.Kna + ", topDis=" + i + ", appearTop=" + localae.KmZ + ", height=" + com.tencent.mm.ci.a.ks(getContext()));
        if (localae.Kna > 0)
        {
          i = localae.Kna;
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
  
  public final boolean fSb()
  {
    AppMethodBeat.i(97113);
    try
    {
      ae localae = fSd();
      int i = this.KvF.jLl.computeVerticalScrollOffset();
      if ((this.Kvu) && (localae != null))
      {
        if ((localae.KmZ == 0) || ((localae.KmZ > 0) && (i >= localae.KmZ)))
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
  
  protected final int fSe()
  {
    AppMethodBeat.i(266872);
    Object localObject = getActivity();
    if ((localObject instanceof SnsAdNativeLandingPagesUI))
    {
      localObject = ((SnsAdNativeLandingPagesUI)localObject).KME;
      if (localObject != null)
      {
        int i = ((FloatJumpCompHelper)localObject).JDr;
        AppMethodBeat.o(266872);
        return i;
      }
      AppMethodBeat.o(266872);
      return -1;
    }
    AppMethodBeat.o(266872);
    return -1;
  }
  
  public final RecyclerView getRecyclerView()
  {
    if (this.KvF != null) {
      return this.KvF.jLl;
    }
    return null;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(97094);
    super.onCreate(paramBundle);
    paramBundle = this.params;
    int[] arrayOfInt = ao.ib(getContext());
    this.pEj = arrayOfInt[0];
    this.pEk = arrayOfInt[1];
    if (this.Kvn == null)
    {
      this.Kvn = ((g)paramBundle.get("pageInfo"));
      b(this.Kvn);
    }
    this.Kvt = ((ar)paramBundle.get("pageDownIconInfo"));
    this.Kvu = Util.nullAsFalse((Boolean)paramBundle.get("is_first_show_page"));
    this.mMk = Util.nullAsFalse((Boolean)paramBundle.get("is_last_shown_page"));
    this.Kvv = Util.nullAsFalse((Boolean)paramBundle.get("needEnterAnimation"));
    this.Kvw = Util.nullAsFalse((Boolean)paramBundle.get("needDirectionAnimation"));
    this.Kvp = Util.nullAsInt(paramBundle.get("groupListCompShowIndex"), 0);
    AppMethodBeat.o(97094);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(97095);
    paramLayoutInflater = paramLayoutInflater.inflate(i.g.ad_landing_page_item, paramViewGroup, false);
    this.KvF = new b((byte)0);
    this.KvF.jac = paramLayoutInflater;
    this.KvF.KvU = ((ImageView)paramLayoutInflater.findViewById(i.f.sns_ad_native_landing_pages_background_img));
    this.KvF.KvV = ((OverScrollLinearout)paramLayoutInflater.findViewById(i.f.sns_ad_native_landing_pages_sub_linear_layout));
    if (this.mMk) {
      this.KvF.KvV.setOnScrollActionListener(this.KvP);
    }
    this.KvF.KvW = ((ImageView)paramLayoutInflater.findViewById(i.f.sns_native_landing_pages_next_img));
    this.KvF.KvX = paramLayoutInflater.findViewById(i.f.sns_native_landing_pages_sphere_comp_next_page_layout);
    this.KvF.KvX.setOnClickListener(this.KvM);
    this.KvF.KvW.setOnClickListener(this.KvN);
    this.KvF.jLl = ((RecyclerView)paramLayoutInflater.findViewById(i.f.content_list));
    this.KvF.KvZ = ((LinearLayout)paramLayoutInflater.findViewById(i.f.fake_container));
    paramViewGroup = this.KvF.jLl;
    paramViewGroup.setOverScrollMode(0);
    int i = Util.nullAsInt(this.params.get("pageCount"), 0);
    Log.d("ContentFragment", "initRecyclerView, pageCount=".concat(String.valueOf(i)));
    if (i > 1) {
      paramViewGroup.setOnTouchListener(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.b((DummyViewPager)this.params.get("viewPager")));
    }
    for (;;)
    {
      getActivity();
      this.Arh = new LinearLayoutManager();
      paramViewGroup.setLayoutManager(this.Arh);
      this.KvG = new a(this.Kvn, this.bgColor, getActivity(), this.Arh);
      if (this.Kvu) {
        this.KvG.Kvp = this.Kvp;
      }
      paramViewGroup.setAdapter(this.KvG);
      paramViewGroup.setDescendantFocusability(131072);
      this.Kvr = new c(paramViewGroup);
      paramViewGroup.a(new RecyclerView.l()
      {
        public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(202380);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousRecyclerView);
          localb.sg(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
          super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
          ContentFragment.a(ContentFragment.this, paramAnonymousInt);
          if (paramAnonymousInt == 0)
          {
            ContentFragment.this.QV(50L);
            if (ContentFragment.d(ContentFragment.this)) {
              ContentFragment.this.fRW();
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
            AppMethodBeat.o(202380);
            return;
            if (paramAnonymousInt == 1)
            {
              ContentFragment.this.fRX();
              ao.ic(ContentFragment.this.getContext());
            }
          }
        }
        
        public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(202375);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousRecyclerView);
          localb.sg(paramAnonymousInt1);
          localb.sg(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
          super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          if ((ContentFragment.c(ContentFragment.this).KvU != null) && (ContentFragment.c(ContentFragment.this).KvU.getVisibility() == 0)) {
            ContentFragment.c(ContentFragment.this).KvU.scrollBy(paramAnonymousInt1, paramAnonymousInt2);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/adapter/ContentFragment$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(202375);
        }
      });
      paramLayoutInflater.setTag(this.KvF);
      aMU();
      this.Kvz = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.Kvz.setDuration(this.Kvs);
      this.Kvz.setInterpolator(new AccelerateDecelerateInterpolator());
      this.Kvz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(97084);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          ContentFragment.c(ContentFragment.this).KvW.setTranslationY((int)(f * -com.tencent.mm.ci.a.fromDPToPix(ContentFragment.this.getContext(), 20)));
          AppMethodBeat.o(97084);
        }
      });
      this.Kvz.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(97086);
          Log.d("ContentFragment", "onAnimationEnd show nextBtn");
          ContentFragment.c(ContentFragment.this).KvY = false;
          AppMethodBeat.o(97086);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(97085);
          Log.d("ContentFragment", "onAnimationStart show nextBtn");
          ContentFragment.c(ContentFragment.this).KvY = true;
          AppMethodBeat.o(97085);
        }
      });
      this.Kvz.setRepeatCount(-1);
      this.Kvz.setRepeatMode(2);
      if ((this.Kvt != null) && (!this.Kvt.equals(this.KvF.KvW.getTag())))
      {
        this.KvF.KvW.setTag(this.Kvt);
        this.KvF.KvW.setVisibility(8);
        h.a("adId", this.Kvt.iconUrl, new f.a()
        {
          public final void aYs(String paramAnonymousString)
          {
            AppMethodBeat.i(97088);
            Log.d("ContentFragment", "onDownloaded nextBtn");
            ContentFragment.a(ContentFragment.this, paramAnonymousString, ContentFragment.c(ContentFragment.this).KvW);
            ContentFragment.this.fRW();
            AppMethodBeat.o(97088);
          }
          
          public final void fJU() {}
          
          public final void fJV()
          {
            AppMethodBeat.i(97087);
            Log.d("ContentFragment", "onDownloadError nextBtn");
            AppMethodBeat.o(97087);
          }
        });
      }
      if (this.KvE != null) {
        this.KvE.s(this);
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
    if (this.Kvr != null) {
      this.Kvr.KuW.onDestroy();
    }
    fRX();
    AppMethodBeat.o(97098);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(97097);
    super.onPause();
    Log.i("ContentFragment", this + " onPause " + getUserVisibleHint());
    this.dgo = false;
    this.Kvr.dgo = this.dgo;
    if ((this.Kvr != null) && (getUserVisibleHint())) {
      this.Kvr.fRM();
    }
    if (this.KvJ) {
      try
      {
        Log.d("ContentFragmentSphereImageView", "unRegisterSphereImageCompEventReceiver, hash=" + hashCode());
        androidx.h.a.a.V(getContext()).unregisterReceiver(this.KvL);
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
    this.dgo = true;
    Object localObject;
    if ((this.KvF != null) && (this.KvF.jac != null))
    {
      for (localObject = (ViewGroup)this.KvF.jac.getParent(); (localObject != null) && ((localObject == null) || (((ViewGroup)localObject).getId() != i.f.root)); localObject = (ViewGroup)((ViewGroup)localObject).getParent()) {}
      if ((localObject instanceof FrameLayout))
      {
        int j = ((ViewGroup)localObject).getChildCount();
        int i = 0;
        while (i < j)
        {
          if ((((ViewGroup)localObject).getChildAt(i) instanceof SnsAdLandingPageFloatView)) {
            this.dgo = false;
          }
          i += 1;
        }
      }
    }
    if ((this.KvC) && (!Util.isNullOrNil(this.KvD)))
    {
      this.dgo = false;
      if ((this.Kvr != null) && (getUserVisibleHint())) {
        this.Kvr.a(this.Kvn, this.KvD);
      }
    }
    this.Kvr.dgo = this.dgo;
    if ((this.Kvr != null) && (getUserVisibleHint())) {
      this.Kvr.fQJ();
    }
    if (this.KvJ) {
      try
      {
        Log.d("ContentFragmentSphereImageView", "registerSphereImageCompEventReceiver, hash=" + hashCode());
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_show");
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_none");
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half");
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_hide");
        androidx.h.a.a.V(getContext()).a(this.KvL, (IntentFilter)localObject);
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
      if (this.Kvr != null)
      {
        this.Kvr.fQJ();
        AppMethodBeat.o(97099);
      }
    }
    else if (this.Kvr != null) {
      this.Kvr.fRM();
    }
    AppMethodBeat.o(97099);
  }
  
  public final void yN(boolean paramBoolean)
  {
    AppMethodBeat.i(97110);
    this.Kvy = paramBoolean;
    if ((fRZ()) && (!paramBoolean))
    {
      fRW();
      AppMethodBeat.o(97110);
      return;
    }
    fRX();
    AppMethodBeat.o(97110);
  }
  
  public static abstract interface a
    extends Serializable
  {
    public abstract void s(ContentFragment paramContentFragment);
  }
  
  static final class b
  {
    public ImageView KvU = null;
    public OverScrollLinearout KvV = null;
    public ImageView KvW = null;
    public View KvX = null;
    public boolean KvY = false;
    LinearLayout KvZ;
    public RecyclerView jLl;
    public View jac;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment
 * JD-Core Version:    0.7.0.1
 */