package com.tencent.mm.plugin.sns.ad.landingpage.component.comp;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.xu;
import com.tencent.mm.plugin.sns.ad.j.c;
import com.tencent.mm.plugin.sns.ad.landingpage.component.info.b.a;
import com.tencent.mm.plugin.sns.ad.widget.shakead.ShakeCoverView.a;
import com.tencent.mm.plugin.sns.ad.widget.shakead.ShakeRandomEncoreView;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.q;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a
{
  public com.tencent.mm.plugin.sns.ad.landingpage.component.info.b PPG;
  private List<n> PPH;
  private q PPI;
  private int PPJ;
  ShakeRandomEncoreView PPK;
  public n PPL;
  public aa PPM;
  public boolean PPN;
  public AdLandingHBCardComponent PPO;
  
  public b(Context paramContext, com.tencent.mm.plugin.sns.ad.landingpage.component.info.b paramb, ViewGroup paramViewGroup)
  {
    super(paramContext, paramb, paramViewGroup);
    AppMethodBeat.i(310710);
    this.PPJ = 0;
    this.PPN = false;
    this.PPG = paramb;
    this.PPH = new ArrayList();
    AppMethodBeat.o(310710);
  }
  
  private h a(n paramn)
  {
    AppMethodBeat.i(310738);
    if (paramn == null)
    {
      AppMethodBeat.o(310738);
      return null;
    }
    if ((paramn instanceof h))
    {
      paramn = (h)paramn;
      AppMethodBeat.o(310738);
      return paramn;
    }
    try
    {
      if ((paramn instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a))
      {
        paramn = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a)paramn).hai().iterator();
        while (paramn.hasNext())
        {
          h localh = a((n)paramn.next());
          if (localh != null)
          {
            AppMethodBeat.o(310738);
            return localh;
          }
        }
      }
    }
    finally
    {
      Log.e("AdLandingEggCardComponent", "findSocialCardComp, exp=" + paramn.toString());
      AppMethodBeat.o(310738);
    }
    return null;
  }
  
  private static int aWv(String paramString)
  {
    AppMethodBeat.i(310720);
    try
    {
      int i = new JSONObject(paramString).optInt("cardType");
      AppMethodBeat.o(310720);
      return i;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(310720);
    }
    return 0;
  }
  
  public static View b(n paramn)
  {
    AppMethodBeat.i(310756);
    if ((paramn.QOV.QKQ) || (paramn.QOV.QKS))
    {
      paramn = paramn.getContentView();
      AppMethodBeat.o(310756);
      return paramn;
    }
    if ((paramn instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a))
    {
      paramn = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a)paramn).hai().iterator();
      while (paramn.hasNext())
      {
        View localView = b((n)paramn.next());
        if (localView != null)
        {
          AppMethodBeat.o(310756);
          return localView;
        }
      }
    }
    AppMethodBeat.o(310756);
    return null;
  }
  
  private com.tencent.mm.plugin.sns.ad.landingpage.component.info.h b(aa paramaa)
  {
    AppMethodBeat.i(310728);
    if (paramaa == null)
    {
      AppMethodBeat.o(310728);
      return null;
    }
    if ((paramaa instanceof com.tencent.mm.plugin.sns.ad.landingpage.component.info.h))
    {
      paramaa = (com.tencent.mm.plugin.sns.ad.landingpage.component.info.h)paramaa;
      AppMethodBeat.o(310728);
      return paramaa;
    }
    try
    {
      if (l.als(paramaa.type))
      {
        paramaa = paramaa.haE();
        if (paramaa != null)
        {
          paramaa = paramaa.iterator();
          while (paramaa.hasNext())
          {
            com.tencent.mm.plugin.sns.ad.landingpage.component.info.h localh = b((aa)paramaa.next());
            if (localh != null)
            {
              AppMethodBeat.o(310728);
              return localh;
            }
          }
        }
      }
    }
    finally
    {
      Log.e("AdLandingEggCardComponent", "findSocialCardInfo, exp=" + paramaa.toString());
      AppMethodBeat.o(310728);
    }
    return null;
  }
  
  public static b c(n paramn)
  {
    AppMethodBeat.i(310764);
    if ((paramn instanceof b))
    {
      paramn = (b)paramn;
      AppMethodBeat.o(310764);
      return paramn;
    }
    if ((paramn instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a))
    {
      paramn = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a)paramn).hai().iterator();
      while (paramn.hasNext())
      {
        b localb = c((n)paramn.next());
        if (localb != null)
        {
          AppMethodBeat.o(310764);
          return localb;
        }
      }
    }
    AppMethodBeat.o(310764);
    return null;
  }
  
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a d(n paramn)
  {
    AppMethodBeat.i(310781);
    if (paramn == null)
    {
      AppMethodBeat.o(310781);
      return null;
    }
    if ((paramn instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a))
    {
      paramn = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)paramn;
      AppMethodBeat.o(310781);
      return paramn;
    }
    try
    {
      if ((paramn instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a))
      {
        paramn = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a)paramn).hai().iterator();
        while (paramn.hasNext())
        {
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a locala = d((n)paramn.next());
          if (locala != null)
          {
            AppMethodBeat.o(310781);
            return locala;
          }
        }
      }
    }
    finally
    {
      Log.e("AdLandingEggCardComponent", "findSocialCardComp, exp=" + paramn.toString());
      AppMethodBeat.o(310781);
    }
    return null;
  }
  
  private aa haj()
  {
    AppMethodBeat.i(310748);
    Object localObject = this.PPG.aAO.iterator();
    while (((Iterator)localObject).hasNext())
    {
      aa localaa = (aa)((Iterator)localObject).next();
      if (localaa.QKR)
      {
        AppMethodBeat.o(310748);
        return localaa;
      }
    }
    if (this.PPG.aAO.size() > 0)
    {
      localObject = (aa)this.PPG.aAO.get(0);
      AppMethodBeat.o(310748);
      return localObject;
    }
    AppMethodBeat.o(310748);
    return null;
  }
  
  private String han()
  {
    AppMethodBeat.i(310771);
    if (this.PPL == null)
    {
      AppMethodBeat.o(310771);
      return "null";
    }
    String str = this.PPL.getClass().getSimpleName();
    AppMethodBeat.o(310771);
    return str;
  }
  
  public final void Dm(boolean paramBoolean)
  {
    AppMethodBeat.i(310840);
    if (this.PPK != null)
    {
      if (paramBoolean)
      {
        this.PPK.hdC();
        AppMethodBeat.o(310840);
        return;
      }
      this.PPK.hdA();
    }
    AppMethodBeat.o(310840);
  }
  
  public final void c(aa paramaa)
  {
    AppMethodBeat.i(310921);
    Log.d("AdLandingEggCardComponent", "updateDataSet, info=".concat(String.valueOf(paramaa)));
    if ((paramaa instanceof com.tencent.mm.plugin.sns.ad.landingpage.component.info.b)) {
      this.PPG = ((com.tencent.mm.plugin.sns.ad.landingpage.component.info.b)paramaa);
    }
    super.c(paramaa);
    AppMethodBeat.o(310921);
  }
  
  public final void had()
  {
    AppMethodBeat.i(310791);
    Log.d("AdLandingEggCardComponent", "fillItem");
    if (this.PPI == null)
    {
      this.PPI = new q(this.PPG.aAO, this.context, (FrameLayout)this.contentView);
      this.PPI.CY();
      this.PPH = hai();
    }
    Object localObject;
    for (;;)
    {
      localObject = this.PPH.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((n)((Iterator)localObject).next()).getContentView().setVisibility(8);
      }
      this.PPI.notify(this.PPG.aAO);
    }
    b.a locala;
    if (haf()) {
      if (this.PPK == null)
      {
        this.PPK = new ShakeRandomEncoreView(this.context);
        localObject = this.PPK;
        locala = this.PPG.PRQ;
        ((ShakeRandomEncoreView)localObject).QiU = locala;
        ((ShakeRandomEncoreView)localObject).QiC.setText(locala.title);
        if (TextUtils.isEmpty(locala.iconUrl)) {
          break label300;
        }
        c.a(locala.iconUrl, ((ShakeRandomEncoreView)localObject).QiT, 0.0F);
      }
    }
    for (;;)
    {
      if ((locala.PRR == 1) && (((ShakeRandomEncoreView)localObject).QiH == null)) {
        ((ShakeRandomEncoreView)localObject).QiH = new com.tencent.mm.plugin.sns.ad.widget.shakead.b();
      }
      localObject = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject).gravity = 81;
      ((FrameLayout.LayoutParams)localObject).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(this.context, 12);
      ((FrameLayout)this.contentView).addView(this.PPK, (ViewGroup.LayoutParams)localObject);
      this.PPK.setOnShakeListener(new ShakeCoverView.a()
      {
        public final void hat()
        {
          AppMethodBeat.i(310730);
          xu localxu = new xu();
          localxu.ibm.hQm = 1;
          localxu.publish();
          AppMethodBeat.o(310730);
        }
      });
      this.PPK.setVisibility(4);
      AppMethodBeat.o(310791);
      return;
      label300:
      ((ShakeRandomEncoreView)localObject).QiT.setVisibility(8);
    }
  }
  
  public final void hae()
  {
    AppMethodBeat.i(310797);
    if ((this.PPN) && (this.PPO != null))
    {
      Object localObject2 = this.PPO;
      if ((((AdLandingHBCardComponent)localObject2).PQY == 3) && (((AdLandingHBCardComponent)localObject2).PQW != null) && (((AdLandingHBCardComponent)localObject2).PQW.lBX != null))
      {
        Object localObject1 = ((AdLandingHBCardComponent)localObject2).PQW.lBX;
        if (localObject1 != null)
        {
          ((View)localObject1).setVisibility(0);
          Object localObject3 = new View(((AdLandingHBCardComponent)localObject2).context);
          ((AdLandingHBCardComponent)localObject2).PQX.addView((View)localObject3, 0, new FrameLayout.LayoutParams(-1, -1));
          ((View)localObject3).setBackgroundResource(b.e.ad_hb_card_splash_bg);
          ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject3, "alpha", new float[] { 0.0F, 1.0F });
          localObjectAnimator1.setDuration(200L);
          ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject3, "alpha", new float[] { 1.0F, 1.0F });
          localObjectAnimator2.setDuration(1000L);
          ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(localObject3, "alpha", new float[] { 1.0F, 0.0F });
          localObjectAnimator3.setDuration(200L);
          localObjectAnimator3.addListener(new AdLandingHBCardComponent.1((AdLandingHBCardComponent)localObject2, (View)localObject3));
          localObject2 = ObjectAnimator.ofFloat(localObject1, "Rotation", new float[] { 0.0F, 8.0F });
          ((ObjectAnimator)localObject2).setDuration(400L);
          localObject1 = ObjectAnimator.ofFloat(localObject1, "Rotation", new float[] { 8.0F, 5.0F });
          ((ObjectAnimator)localObject1).setDuration(200L);
          localObject3 = new AnimatorSet();
          ((AnimatorSet)localObject3).play((Animator)localObject2).after(localObjectAnimator1);
          ((AnimatorSet)localObject3).play((Animator)localObject1).after((Animator)localObject2);
          ((AnimatorSet)localObject3).play(localObjectAnimator2).after(localObjectAnimator1);
          ((AnimatorSet)localObject3).play(localObjectAnimator3).after(localObjectAnimator2);
          ((AnimatorSet)localObject3).start();
        }
      }
    }
    AppMethodBeat.o(310797);
  }
  
  public final boolean haf()
  {
    return (this.PPG != null) && (this.PPG.PRQ != null) && (this.PPG.PRQ.PRR == 1);
  }
  
  public final void hag()
  {
    AppMethodBeat.i(310847);
    if (this.PPK == null)
    {
      AppMethodBeat.o(310847);
      return;
    }
    if (this.PPK.getVisibility() == 0)
    {
      AppMethodBeat.o(310847);
      return;
    }
    this.PPK.setVisibility(0);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.PPK, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(400L);
    localObjectAnimator.start();
    AppMethodBeat.o(310847);
  }
  
  public final void hah()
  {
    AppMethodBeat.i(310852);
    if (this.PPK == null)
    {
      AppMethodBeat.o(310852);
      return;
    }
    if (this.PPK.getVisibility() != 0)
    {
      AppMethodBeat.o(310852);
      return;
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.PPK, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator.addListener(new com.tencent.mm.plugin.sns.ad.widget.b()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(310729);
        b.this.PPK.setVisibility(4);
        AppMethodBeat.o(310729);
      }
    });
    localObjectAnimator.setDuration(400L);
    localObjectAnimator.start();
    AppMethodBeat.o(310852);
  }
  
  public final List<n> hai()
  {
    AppMethodBeat.i(310859);
    if (this.PPI != null)
    {
      localArrayList = new ArrayList(this.PPI.hjV());
      AppMethodBeat.o(310859);
      return localArrayList;
    }
    ArrayList localArrayList = new ArrayList();
    AppMethodBeat.o(310859);
    return localArrayList;
  }
  
  public final Pair<Integer, Integer> hak()
  {
    AppMethodBeat.i(310870);
    Object localObject = haj();
    float f2;
    float f1;
    if (localObject != null)
    {
      f2 = ((aa)localObject).QKI;
      f1 = ((aa)localObject).QKJ;
    }
    for (;;)
    {
      if ((f2 <= 0.0F) || (f1 <= 0.0F)) {
        Log.e("AdLandingEggCardComponent", "default card size is 0, w=" + f2 + ", h=" + f1);
      }
      localObject = new Pair(Integer.valueOf((int)f2), Integer.valueOf((int)f1));
      AppMethodBeat.o(310870);
      return localObject;
      f1 = 0.0F;
      f2 = 0.0F;
    }
  }
  
  public final void hal()
  {
    AppMethodBeat.i(310878);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.QOV.paddingLeft, (int)this.QOV.paddingTop, (int)this.QOV.paddingRight, (int)this.QOV.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(310878);
  }
  
  public final View ham()
  {
    AppMethodBeat.i(310883);
    FrameLayout localFrameLayout = new FrameLayout(this.context);
    AppMethodBeat.o(310883);
    return localFrameLayout;
  }
  
  public final void hao()
  {
    AppMethodBeat.i(310890);
    Log.d("AdLandingEggCardComponent", "viewWillAppear, curComp=" + han());
    if ((this.PPL != null) && (this.PPL.hji())) {
      this.PPL.hao();
    }
    super.hao();
    AppMethodBeat.o(310890);
  }
  
  public final void hap()
  {
    AppMethodBeat.i(310898);
    Log.d("AdLandingEggCardComponent", "viewWillDisappear, curComp=" + han());
    if (this.PPL != null) {
      this.PPL.hap();
    }
    super.hap();
    AppMethodBeat.o(310898);
  }
  
  public final void haq()
  {
    AppMethodBeat.i(310903);
    Log.d("AdLandingEggCardComponent", "viewAppeared, curComp=" + han());
    if ((this.PPL != null) && (this.PPL.hji())) {
      this.PPL.haq();
    }
    super.haq();
    AppMethodBeat.o(310903);
  }
  
  public final void har()
  {
    AppMethodBeat.i(310909);
    Log.d("AdLandingEggCardComponent", "updateChildExposure, curComp=" + han());
    if (this.PPL != null)
    {
      if (this.PPL.hji())
      {
        this.PPL.hao();
        this.PPL.haq();
        AppMethodBeat.o(310909);
        return;
      }
      this.PPL.hap();
    }
    AppMethodBeat.o(310909);
  }
  
  public final void has()
  {
    AppMethodBeat.i(310915);
    Log.i("AdLandingEggCardComponent", "viewWillDestroy, curComp=" + han());
    super.has();
    Iterator localIterator = this.PPH.iterator();
    while (localIterator.hasNext()) {
      ((n)localIterator.next()).has();
    }
    AppMethodBeat.o(310915);
  }
  
  /* Error */
  public final void lM(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 569
    //   3: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: iconst_0
    //   8: putfield 43	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/b:PPN	Z
    //   11: aload_0
    //   12: aconst_null
    //   13: putfield 370	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/b:PPO	Lcom/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent;
    //   16: invokestatic 575	java/lang/System:currentTimeMillis	()J
    //   19: lstore 6
    //   21: aload_2
    //   22: invokestatic 577	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/b:aWv	(Ljava/lang/String;)I
    //   25: istore 4
    //   27: aload_1
    //   28: invokestatic 315	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   31: ifne +2148 -> 2179
    //   34: aload_0
    //   35: getfield 45	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/b:PPG	Lcom/tencent/mm/plugin/sns/ad/landingpage/component/info/b;
    //   38: getfield 184	com/tencent/mm/plugin/sns/ad/landingpage/component/info/b:aAO	Ljava/util/List;
    //   41: invokeinterface 71 1 0
    //   46: astore 10
    //   48: aload 10
    //   50: invokeinterface 77 1 0
    //   55: ifeq +2124 -> 2179
    //   58: aload 10
    //   60: invokeinterface 81 1 0
    //   65: checkcast 132	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa
    //   68: astore 9
    //   70: aload_1
    //   71: aload 9
    //   73: getfield 580	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa:PPh	Ljava/lang/String;
    //   76: invokevirtual 584	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   79: ifeq -31 -> 48
    //   82: aload 9
    //   84: astore 10
    //   86: aload 9
    //   88: ifnonnull +24 -> 112
    //   91: aload_0
    //   92: invokespecial 471	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/b:haj	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   95: astore 10
    //   97: ldc 87
    //   99: ldc_w 586
    //   102: aload_1
    //   103: invokestatic 235	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   106: invokevirtual 239	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   109: invokestatic 564	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: aload 10
    //   114: ifnull +2047 -> 2161
    //   117: iload 4
    //   119: iconst_1
    //   120: if_icmpne +751 -> 871
    //   123: aload_0
    //   124: aload 10
    //   126: invokespecial 162	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/b:b	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;)Lcom/tencent/mm/plugin/sns/ad/landingpage/component/info/h;
    //   129: astore 9
    //   131: aload 9
    //   133: ifnull +381 -> 514
    //   136: ldc 87
    //   138: ldc_w 588
    //   141: aload_1
    //   142: invokestatic 235	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   145: invokevirtual 239	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   148: invokestatic 564	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: ldc_w 590
    //   154: ldc_w 592
    //   157: aload_2
    //   158: invokestatic 235	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   161: invokevirtual 239	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   164: invokestatic 564	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: new 118	org/json/JSONObject
    //   170: dup
    //   171: aload_2
    //   172: invokespecial 119	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   175: astore 11
    //   177: aload 11
    //   179: ldc_w 594
    //   182: invokevirtual 597	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   185: astore 12
    //   187: aload 12
    //   189: invokestatic 315	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   192: ifne +10 -> 202
    //   195: aload 9
    //   197: aload 12
    //   199: putfield 600	com/tencent/mm/plugin/sns/ad/landingpage/component/info/h:PSl	Ljava/lang/String;
    //   202: aload 11
    //   204: ldc_w 602
    //   207: invokevirtual 597	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   210: astore 12
    //   212: aload 12
    //   214: invokestatic 315	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   217: ifne +10 -> 227
    //   220: aload 9
    //   222: aload 12
    //   224: putfield 605	com/tencent/mm/plugin/sns/ad/landingpage/component/info/h:PSm	Ljava/lang/String;
    //   227: aload 11
    //   229: ldc_w 607
    //   232: invokevirtual 597	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   235: astore 12
    //   237: aload 12
    //   239: invokestatic 315	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   242: ifne +10 -> 252
    //   245: aload 9
    //   247: aload 12
    //   249: putfield 610	com/tencent/mm/plugin/sns/ad/landingpage/component/info/h:PSn	Ljava/lang/String;
    //   252: aload 11
    //   254: ldc_w 612
    //   257: invokevirtual 597	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   260: astore 12
    //   262: aload 12
    //   264: invokestatic 315	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   267: ifne +10 -> 277
    //   270: aload 9
    //   272: aload 12
    //   274: putfield 614	com/tencent/mm/plugin/sns/ad/landingpage/component/info/h:desc	Ljava/lang/String;
    //   277: aload 11
    //   279: ldc_w 616
    //   282: invokevirtual 597	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   285: astore 12
    //   287: aload 12
    //   289: invokestatic 315	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   292: ifne +10 -> 302
    //   295: aload 9
    //   297: aload 12
    //   299: putfield 619	com/tencent/mm/plugin/sns/ad/landingpage/component/info/h:PSr	Ljava/lang/String;
    //   302: aload 11
    //   304: ldc_w 621
    //   307: invokevirtual 597	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   310: astore 12
    //   312: aload 12
    //   314: invokestatic 315	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   317: ifne +10 -> 327
    //   320: aload 9
    //   322: aload 12
    //   324: putfield 624	com/tencent/mm/plugin/sns/ad/landingpage/component/info/h:PSv	Ljava/lang/String;
    //   327: aload 11
    //   329: ldc_w 626
    //   332: invokevirtual 597	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   335: astore 12
    //   337: aload 12
    //   339: invokestatic 315	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   342: ifne +10 -> 352
    //   345: aload 9
    //   347: aload 12
    //   349: putfield 629	com/tencent/mm/plugin/sns/ad/landingpage/component/info/h:PSw	Ljava/lang/String;
    //   352: new 47	java/util/ArrayList
    //   355: dup
    //   356: invokespecial 50	java/util/ArrayList:<init>	()V
    //   359: astore 12
    //   361: aload 11
    //   363: ldc_w 631
    //   366: invokevirtual 635	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   369: astore 13
    //   371: aload 13
    //   373: ifnull +49 -> 422
    //   376: aload 13
    //   378: invokevirtual 640	org/json/JSONArray:length	()I
    //   381: ifle +41 -> 422
    //   384: iconst_0
    //   385: istore_3
    //   386: iload_3
    //   387: aload 13
    //   389: invokevirtual 640	org/json/JSONArray:length	()I
    //   392: if_icmpge +30 -> 422
    //   395: aload 13
    //   397: iload_3
    //   398: invokevirtual 643	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   401: astore 14
    //   403: aload 14
    //   405: invokestatic 315	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   408: ifne +1764 -> 2172
    //   411: aload 12
    //   413: aload 14
    //   415: invokevirtual 646	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   418: pop
    //   419: goto +1753 -> 2172
    //   422: aload 9
    //   424: aload 12
    //   426: putfield 650	com/tencent/mm/plugin/sns/ad/landingpage/component/info/h:PSt	Ljava/util/ArrayList;
    //   429: new 47	java/util/ArrayList
    //   432: dup
    //   433: invokespecial 50	java/util/ArrayList:<init>	()V
    //   436: astore 12
    //   438: aload 11
    //   440: ldc_w 652
    //   443: invokevirtual 635	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   446: astore 11
    //   448: aload 11
    //   450: ifnull +49 -> 499
    //   453: aload 11
    //   455: invokevirtual 640	org/json/JSONArray:length	()I
    //   458: ifle +41 -> 499
    //   461: iconst_0
    //   462: istore_3
    //   463: iload_3
    //   464: aload 11
    //   466: invokevirtual 640	org/json/JSONArray:length	()I
    //   469: if_icmpge +30 -> 499
    //   472: aload 11
    //   474: iload_3
    //   475: invokevirtual 643	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   478: astore 13
    //   480: aload 13
    //   482: invokestatic 315	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   485: ifne +1700 -> 2185
    //   488: aload 12
    //   490: aload 13
    //   492: invokevirtual 646	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   495: pop
    //   496: goto +1689 -> 2185
    //   499: aload 12
    //   501: invokevirtual 653	java/util/ArrayList:size	()I
    //   504: ifle +10 -> 514
    //   507: aload 9
    //   509: aload 12
    //   511: putfield 656	com/tencent/mm/plugin/sns/ad/landingpage/component/info/h:PSu	Ljava/util/ArrayList;
    //   514: aload_0
    //   515: getfield 217	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/b:PPK	Lcom/tencent/mm/plugin/sns/ad/widget/shakead/ShakeRandomEncoreView;
    //   518: ifnull +1674 -> 2192
    //   521: iconst_1
    //   522: istore_3
    //   523: aload_0
    //   524: getfield 52	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/b:PPH	Ljava/util/List;
    //   527: invokeinterface 71 1 0
    //   532: astore 13
    //   534: aload 13
    //   536: invokeinterface 77 1 0
    //   541: ifeq +1609 -> 2150
    //   544: aload 13
    //   546: invokeinterface 81 1 0
    //   551: checkcast 83	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/n
    //   554: astore 9
    //   556: aload 10
    //   558: getfield 659	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa:QKG	Ljava/lang/String;
    //   561: ifnull +1491 -> 2052
    //   564: aload 10
    //   566: getfield 659	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa:QKG	Ljava/lang/String;
    //   569: aload 9
    //   571: getfield 130	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/n:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   574: getfield 659	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa:QKG	Ljava/lang/String;
    //   577: invokevirtual 584	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   580: ifeq +1472 -> 2052
    //   583: aload 9
    //   585: invokevirtual 142	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/n:getContentView	()Landroid/view/View;
    //   588: iconst_0
    //   589: invokevirtual 273	android/view/View:setVisibility	(I)V
    //   592: aload_0
    //   593: aload_0
    //   594: getfield 199	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/b:PPL	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/n;
    //   597: invokespecial 176	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/b:d	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/n;)Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/a;
    //   600: astore 11
    //   602: ldc 87
    //   604: ldc_w 661
    //   607: aload 11
    //   609: invokestatic 235	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   612: invokevirtual 239	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   615: invokestatic 564	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   618: aload 11
    //   620: ifnull +8 -> 628
    //   623: aload 11
    //   625: invokevirtual 664	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/a:hav	()V
    //   628: aload_0
    //   629: aload 9
    //   631: putfield 199	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/b:PPL	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/n;
    //   634: aload_0
    //   635: aload 10
    //   637: putfield 666	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/b:PPM	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   640: iload 4
    //   642: iconst_1
    //   643: if_icmpne +275 -> 918
    //   646: aload_0
    //   647: aload_0
    //   648: getfield 199	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/b:PPL	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/n;
    //   651: invokespecial 85	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/b:a	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/n;)Lcom/tencent/mm/plugin/sns/ad/landingpage/component/comp/h;
    //   654: astore 9
    //   656: aload 9
    //   658: ifnull -124 -> 534
    //   661: ldc_w 668
    //   664: ldc_w 670
    //   667: invokestatic 564	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   670: aload 9
    //   672: getfield 671	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/h:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   675: checkcast 148	com/tencent/mm/plugin/sns/ad/landingpage/component/info/h
    //   678: astore 11
    //   680: aload 11
    //   682: ifnull -148 -> 534
    //   685: aload 9
    //   687: getfield 674	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/h:PRv	Landroid/widget/TextView;
    //   690: aload 11
    //   692: getfield 600	com/tencent/mm/plugin/sns/ad/landingpage/component/info/h:PSl	Ljava/lang/String;
    //   695: invokevirtual 306	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   698: aload 9
    //   700: getfield 677	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/h:PRw	Landroid/widget/TextView;
    //   703: aload 11
    //   705: getfield 605	com/tencent/mm/plugin/sns/ad/landingpage/component/info/h:PSm	Ljava/lang/String;
    //   708: invokevirtual 306	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   711: aload 9
    //   713: getfield 680	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/h:PRx	Landroid/widget/TextView;
    //   716: aload 11
    //   718: getfield 610	com/tencent/mm/plugin/sns/ad/landingpage/component/info/h:PSn	Ljava/lang/String;
    //   721: invokevirtual 306	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   724: aload 9
    //   726: getfield 683	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/h:KPG	Landroid/widget/TextView;
    //   729: aload 11
    //   731: getfield 614	com/tencent/mm/plugin/sns/ad/landingpage/component/info/h:desc	Ljava/lang/String;
    //   734: invokevirtual 306	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   737: aload 9
    //   739: getfield 686	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/h:PRB	Landroid/widget/TextView;
    //   742: aload 11
    //   744: getfield 619	com/tencent/mm/plugin/sns/ad/landingpage/component/info/h:PSr	Ljava/lang/String;
    //   747: invokevirtual 306	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   750: aload 9
    //   752: iconst_1
    //   753: putfield 689	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/h:PRF	I
    //   756: getstatic 695	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
    //   759: new 697	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/h$1
    //   762: dup
    //   763: aload 9
    //   765: aload 11
    //   767: invokespecial 700	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/h$1:<init>	(Lcom/tencent/mm/plugin/sns/ad/landingpage/component/comp/h;Lcom/tencent/mm/plugin/sns/ad/landingpage/component/info/h;)V
    //   770: invokeinterface 706 2 0
    //   775: pop
    //   776: goto -242 -> 534
    //   779: astore_1
    //   780: ldc 87
    //   782: new 89	java/lang/StringBuilder
    //   785: dup
    //   786: ldc_w 708
    //   789: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   792: aload_1
    //   793: invokevirtual 100	java/lang/Throwable:toString	()Ljava/lang/String;
    //   796: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   802: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   805: ldc 87
    //   807: new 89	java/lang/StringBuilder
    //   810: dup
    //   811: ldc_w 710
    //   814: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   817: invokestatic 575	java/lang/System:currentTimeMillis	()J
    //   820: lload 6
    //   822: lsub
    //   823: invokevirtual 713	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   826: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   829: invokestatic 564	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   832: ldc_w 569
    //   835: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   838: return
    //   839: astore 9
    //   841: ldc_w 590
    //   844: new 89	java/lang/StringBuilder
    //   847: dup
    //   848: ldc_w 715
    //   851: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   854: aload 9
    //   856: invokevirtual 100	java/lang/Throwable:toString	()Ljava/lang/String;
    //   859: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   865: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   868: goto -354 -> 514
    //   871: iload 4
    //   873: iconst_2
    //   874: if_icmpne -360 -> 514
    //   877: new 717	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i
    //   880: dup
    //   881: invokespecial 718	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i:<init>	()V
    //   884: aload_0
    //   885: getfield 45	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/b:PPG	Lcom/tencent/mm/plugin/sns/ad/landingpage/component/info/b;
    //   888: ldc_w 720
    //   891: invokevirtual 723	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i:a	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;Ljava/lang/Class;)Ljava/lang/Object;
    //   894: checkcast 720	com/tencent/mm/plugin/sns/ad/landingpage/component/info/g
    //   897: ifnull -383 -> 514
    //   900: ldc 87
    //   902: ldc_w 725
    //   905: aload_1
    //   906: invokestatic 235	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   909: invokevirtual 239	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   912: invokestatic 564	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   915: goto -401 -> 514
    //   918: iload 4
    //   920: iconst_2
    //   921: if_icmpne -387 -> 534
    //   924: aload_0
    //   925: getfield 199	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/b:PPL	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/n;
    //   928: astore 9
    //   930: new 727	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/b
    //   933: dup
    //   934: invokespecial 728	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/b:<init>	()V
    //   937: aload 9
    //   939: ldc_w 372
    //   942: invokevirtual 731	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/b:a	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/n;Ljava/lang/Class;)Ljava/lang/Object;
    //   945: checkcast 372	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent
    //   948: astore 14
    //   950: aload 14
    //   952: ifnull -418 -> 534
    //   955: aload_0
    //   956: aload 14
    //   958: putfield 370	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/b:PPO	Lcom/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent;
    //   961: ldc_w 733
    //   964: new 89	java/lang/StringBuilder
    //   967: dup
    //   968: ldc_w 735
    //   971: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   974: aload_1
    //   975: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   978: ldc_w 737
    //   981: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: aload_2
    //   985: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   988: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   991: invokestatic 564	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   994: new 118	org/json/JSONObject
    //   997: dup
    //   998: aload_2
    //   999: invokespecial 119	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1002: astore 9
    //   1004: aload 9
    //   1006: ldc_w 739
    //   1009: invokevirtual 124	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1012: istore 5
    //   1014: iload 5
    //   1016: iconst_4
    //   1017: if_icmpne +120 -> 1137
    //   1020: aload 14
    //   1022: aload_2
    //   1023: invokestatic 745	com/tencent/mm/plugin/sns/ad/d/a/c:aWt	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sns/ad/d/a/c;
    //   1026: putfield 749	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PRc	Lcom/tencent/mm/plugin/sns/ad/d/a/c;
    //   1029: aload 14
    //   1031: aload_1
    //   1032: putfield 752	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PQZ	Ljava/lang/String;
    //   1035: aload 14
    //   1037: aload 9
    //   1039: ldc_w 754
    //   1042: invokevirtual 597	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1045: putfield 757	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PRa	Ljava/lang/String;
    //   1048: aload 14
    //   1050: getfield 761	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:POK	Lcom/tencent/mm/plugin/sns/ad/landingpage/component/info/g;
    //   1053: aload 9
    //   1055: ldc_w 763
    //   1058: invokevirtual 597	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1061: putfield 766	com/tencent/mm/plugin/sns/ad/landingpage/component/info/g:POQ	Ljava/lang/String;
    //   1064: aload 14
    //   1066: getfield 761	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:POK	Lcom/tencent/mm/plugin/sns/ad/landingpage/component/info/g;
    //   1069: astore 9
    //   1071: iload 5
    //   1073: ifle +105 -> 1178
    //   1076: iload 5
    //   1078: iconst_4
    //   1079: if_icmpgt +99 -> 1178
    //   1082: aload 9
    //   1084: getfield 770	com/tencent/mm/plugin/sns/ad/landingpage/component/info/g:PSd	[Lcom/tencent/mm/plugin/sns/ad/landingpage/component/info/g$a;
    //   1087: iload 5
    //   1089: iconst_1
    //   1090: isub
    //   1091: aaload
    //   1092: astore 9
    //   1094: aload 9
    //   1096: ifnonnull +88 -> 1184
    //   1099: ldc_w 733
    //   1102: ldc_w 772
    //   1105: iload 5
    //   1107: invokestatic 774	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1110: invokevirtual 239	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1113: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1116: aload 14
    //   1118: getfield 375	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PQY	I
    //   1121: iconst_3
    //   1122: if_icmpne +924 -> 2046
    //   1125: iconst_1
    //   1126: istore 8
    //   1128: aload_0
    //   1129: iload 8
    //   1131: putfield 43	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/b:PPN	Z
    //   1134: goto -600 -> 534
    //   1137: aload 14
    //   1139: aconst_null
    //   1140: putfield 749	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PRc	Lcom/tencent/mm/plugin/sns/ad/d/a/c;
    //   1143: goto -114 -> 1029
    //   1146: astore 9
    //   1148: ldc_w 733
    //   1151: new 89	java/lang/StringBuilder
    //   1154: dup
    //   1155: ldc_w 776
    //   1158: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1161: aload 9
    //   1163: invokevirtual 100	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1166: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1169: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1172: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1175: goto -59 -> 1116
    //   1178: aconst_null
    //   1179: astore 9
    //   1181: goto -87 -> 1094
    //   1184: aload 14
    //   1186: iload 5
    //   1188: putfield 375	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PQY	I
    //   1191: aload 14
    //   1193: aload 9
    //   1195: putfield 780	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PRb	Lcom/tencent/mm/plugin/sns/ad/landingpage/component/info/g$a;
    //   1198: ldc_w 733
    //   1201: ldc_w 782
    //   1204: iload 5
    //   1206: invokestatic 774	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1209: invokevirtual 239	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1212: invokestatic 564	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1215: iload 5
    //   1217: tableswitch	default:+980 -> 2197, 1:+51->1268, 2:+139->1356, 3:+219->1436, 4:+381->1598
    //   1249: iconst_2
    //   1250: iconst_3
    //   1251: if_icmpeq +782 -> 2033
    //   1254: aload 14
    //   1256: getfield 786	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PRd	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   1259: iload 5
    //   1261: iconst_0
    //   1262: invokevirtual 792	com/tencent/mm/plugin/sns/ad/d/a/a:bA	(IZ)V
    //   1265: goto -149 -> 1116
    //   1268: aload 14
    //   1270: getfield 795	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PQV	Lcom/tencent/mm/plugin/sns/ad/d/a/b;
    //   1273: getfield 384	com/tencent/mm/plugin/sns/ad/d/a/b:lBX	Landroid/view/View;
    //   1276: iconst_0
    //   1277: invokevirtual 273	android/view/View:setVisibility	(I)V
    //   1280: aload 14
    //   1282: getfield 379	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PQW	Lcom/tencent/mm/plugin/sns/ad/d/a/b;
    //   1285: getfield 384	com/tencent/mm/plugin/sns/ad/d/a/b:lBX	Landroid/view/View;
    //   1288: bipush 8
    //   1290: invokevirtual 273	android/view/View:setVisibility	(I)V
    //   1293: aload 14
    //   1295: getfield 795	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PQV	Lcom/tencent/mm/plugin/sns/ad/d/a/b;
    //   1298: astore 11
    //   1300: aload 11
    //   1302: getfield 798	com/tencent/mm/plugin/sns/ad/d/a/b:POV	Landroid/view/View;
    //   1305: aload 14
    //   1307: getfield 802	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PRg	Landroid/view/View$OnClickListener;
    //   1310: invokevirtual 806	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1313: aload 11
    //   1315: getfield 809	com/tencent/mm/plugin/sns/ad/d/a/b:PPd	Landroid/view/View;
    //   1318: iconst_0
    //   1319: invokevirtual 273	android/view/View:setVisibility	(I)V
    //   1322: aload 11
    //   1324: getfield 809	com/tencent/mm/plugin/sns/ad/d/a/b:PPd	Landroid/view/View;
    //   1327: aload 14
    //   1329: getfield 812	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PRe	Landroid/view/View$OnClickListener;
    //   1332: invokevirtual 806	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1335: aload 11
    //   1337: aload 9
    //   1339: invokevirtual 815	com/tencent/mm/plugin/sns/ad/d/a/b:a	(Lcom/tencent/mm/plugin/sns/ad/landingpage/component/info/g$a;)V
    //   1342: aload 11
    //   1344: getfield 816	com/tencent/mm/plugin/sns/ad/d/a/b:contentView	Landroid/view/View;
    //   1347: getstatic 819	com/tencent/mm/plugin/sns/b$e:ad_hb_card_white_bg	I
    //   1350: invokevirtual 401	android/view/View:setBackgroundResource	(I)V
    //   1353: goto -105 -> 1248
    //   1356: aload 14
    //   1358: getfield 795	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PQV	Lcom/tencent/mm/plugin/sns/ad/d/a/b;
    //   1361: getfield 384	com/tencent/mm/plugin/sns/ad/d/a/b:lBX	Landroid/view/View;
    //   1364: bipush 8
    //   1366: invokevirtual 273	android/view/View:setVisibility	(I)V
    //   1369: aload 14
    //   1371: getfield 379	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PQW	Lcom/tencent/mm/plugin/sns/ad/d/a/b;
    //   1374: getfield 384	com/tencent/mm/plugin/sns/ad/d/a/b:lBX	Landroid/view/View;
    //   1377: iconst_0
    //   1378: invokevirtual 273	android/view/View:setVisibility	(I)V
    //   1381: aload 14
    //   1383: getfield 379	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PQW	Lcom/tencent/mm/plugin/sns/ad/d/a/b;
    //   1386: astore 11
    //   1388: aload 11
    //   1390: getfield 798	com/tencent/mm/plugin/sns/ad/d/a/b:POV	Landroid/view/View;
    //   1393: aload 14
    //   1395: getfield 822	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PRh	Landroid/view/View$OnClickListener;
    //   1398: invokevirtual 806	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1401: aload 11
    //   1403: getfield 825	com/tencent/mm/plugin/sns/ad/d/a/b:POX	Landroid/view/View;
    //   1406: bipush 8
    //   1408: invokevirtual 273	android/view/View:setVisibility	(I)V
    //   1411: aload 11
    //   1413: getfield 828	com/tencent/mm/plugin/sns/ad/d/a/b:POT	Landroid/widget/TextView;
    //   1416: iconst_0
    //   1417: invokevirtual 829	android/widget/TextView:setVisibility	(I)V
    //   1420: aload 11
    //   1422: iconst_0
    //   1423: invokevirtual 832	com/tencent/mm/plugin/sns/ad/d/a/b:ajt	(I)V
    //   1426: aload 11
    //   1428: aload 9
    //   1430: invokevirtual 815	com/tencent/mm/plugin/sns/ad/d/a/b:a	(Lcom/tencent/mm/plugin/sns/ad/landingpage/component/info/g$a;)V
    //   1433: goto -185 -> 1248
    //   1436: aload 14
    //   1438: getfield 795	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PQV	Lcom/tencent/mm/plugin/sns/ad/d/a/b;
    //   1441: getfield 384	com/tencent/mm/plugin/sns/ad/d/a/b:lBX	Landroid/view/View;
    //   1444: iconst_0
    //   1445: invokevirtual 273	android/view/View:setVisibility	(I)V
    //   1448: aload 14
    //   1450: getfield 795	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PQV	Lcom/tencent/mm/plugin/sns/ad/d/a/b;
    //   1453: getfield 798	com/tencent/mm/plugin/sns/ad/d/a/b:POV	Landroid/view/View;
    //   1456: aload 14
    //   1458: getfield 802	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PRg	Landroid/view/View$OnClickListener;
    //   1461: invokevirtual 806	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1464: aload 14
    //   1466: getfield 795	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PQV	Lcom/tencent/mm/plugin/sns/ad/d/a/b;
    //   1469: getfield 809	com/tencent/mm/plugin/sns/ad/d/a/b:PPd	Landroid/view/View;
    //   1472: iconst_0
    //   1473: invokevirtual 273	android/view/View:setVisibility	(I)V
    //   1476: aload 14
    //   1478: getfield 795	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PQV	Lcom/tencent/mm/plugin/sns/ad/d/a/b;
    //   1481: getfield 809	com/tencent/mm/plugin/sns/ad/d/a/b:PPd	Landroid/view/View;
    //   1484: aload 14
    //   1486: getfield 812	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PRe	Landroid/view/View$OnClickListener;
    //   1489: invokevirtual 806	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1492: aload 14
    //   1494: getfield 795	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PQV	Lcom/tencent/mm/plugin/sns/ad/d/a/b;
    //   1497: getfield 816	com/tencent/mm/plugin/sns/ad/d/a/b:contentView	Landroid/view/View;
    //   1500: getstatic 835	com/tencent/mm/plugin/sns/b$e:ad_hb_card_border_bg	I
    //   1503: invokevirtual 401	android/view/View:setBackgroundResource	(I)V
    //   1506: aload 14
    //   1508: getfield 379	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PQW	Lcom/tencent/mm/plugin/sns/ad/d/a/b;
    //   1511: getfield 384	com/tencent/mm/plugin/sns/ad/d/a/b:lBX	Landroid/view/View;
    //   1514: bipush 8
    //   1516: invokevirtual 273	android/view/View:setVisibility	(I)V
    //   1519: aload 14
    //   1521: getfield 379	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PQW	Lcom/tencent/mm/plugin/sns/ad/d/a/b;
    //   1524: getfield 798	com/tencent/mm/plugin/sns/ad/d/a/b:POV	Landroid/view/View;
    //   1527: aload 14
    //   1529: getfield 822	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PRh	Landroid/view/View$OnClickListener;
    //   1532: invokevirtual 806	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1535: aload 14
    //   1537: getfield 379	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PQW	Lcom/tencent/mm/plugin/sns/ad/d/a/b;
    //   1540: getfield 825	com/tencent/mm/plugin/sns/ad/d/a/b:POX	Landroid/view/View;
    //   1543: bipush 8
    //   1545: invokevirtual 273	android/view/View:setVisibility	(I)V
    //   1548: aload 14
    //   1550: getfield 379	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PQW	Lcom/tencent/mm/plugin/sns/ad/d/a/b;
    //   1553: getfield 828	com/tencent/mm/plugin/sns/ad/d/a/b:POT	Landroid/widget/TextView;
    //   1556: iconst_0
    //   1557: invokevirtual 829	android/widget/TextView:setVisibility	(I)V
    //   1560: aload 14
    //   1562: getfield 379	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PQW	Lcom/tencent/mm/plugin/sns/ad/d/a/b;
    //   1565: iconst_0
    //   1566: invokevirtual 832	com/tencent/mm/plugin/sns/ad/d/a/b:ajt	(I)V
    //   1569: aload 14
    //   1571: getfield 795	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PQV	Lcom/tencent/mm/plugin/sns/ad/d/a/b;
    //   1574: aload 9
    //   1576: getfield 840	com/tencent/mm/plugin/sns/ad/landingpage/component/info/g$a:PSj	Lcom/tencent/mm/plugin/sns/ad/landingpage/component/info/g$a;
    //   1579: invokevirtual 815	com/tencent/mm/plugin/sns/ad/d/a/b:a	(Lcom/tencent/mm/plugin/sns/ad/landingpage/component/info/g$a;)V
    //   1582: aload 14
    //   1584: getfield 379	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PQW	Lcom/tencent/mm/plugin/sns/ad/d/a/b;
    //   1587: aload 9
    //   1589: getfield 843	com/tencent/mm/plugin/sns/ad/landingpage/component/info/g$a:PSk	Lcom/tencent/mm/plugin/sns/ad/landingpage/component/info/g$a;
    //   1592: invokevirtual 815	com/tencent/mm/plugin/sns/ad/d/a/b:a	(Lcom/tencent/mm/plugin/sns/ad/landingpage/component/info/g$a;)V
    //   1595: goto -347 -> 1248
    //   1598: aload 14
    //   1600: getfield 795	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PQV	Lcom/tencent/mm/plugin/sns/ad/d/a/b;
    //   1603: getfield 384	com/tencent/mm/plugin/sns/ad/d/a/b:lBX	Landroid/view/View;
    //   1606: bipush 8
    //   1608: invokevirtual 273	android/view/View:setVisibility	(I)V
    //   1611: aload 14
    //   1613: getfield 379	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PQW	Lcom/tencent/mm/plugin/sns/ad/d/a/b;
    //   1616: getfield 384	com/tencent/mm/plugin/sns/ad/d/a/b:lBX	Landroid/view/View;
    //   1619: iconst_0
    //   1620: invokevirtual 273	android/view/View:setVisibility	(I)V
    //   1623: aload 14
    //   1625: getfield 379	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PQW	Lcom/tencent/mm/plugin/sns/ad/d/a/b;
    //   1628: astore 15
    //   1630: aload 15
    //   1632: getfield 798	com/tencent/mm/plugin/sns/ad/d/a/b:POV	Landroid/view/View;
    //   1635: aload 14
    //   1637: getfield 802	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PRg	Landroid/view/View$OnClickListener;
    //   1640: invokevirtual 806	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1643: aload 15
    //   1645: getfield 825	com/tencent/mm/plugin/sns/ad/d/a/b:POX	Landroid/view/View;
    //   1648: iconst_0
    //   1649: invokevirtual 273	android/view/View:setVisibility	(I)V
    //   1652: aload 15
    //   1654: getfield 828	com/tencent/mm/plugin/sns/ad/d/a/b:POT	Landroid/widget/TextView;
    //   1657: bipush 8
    //   1659: invokevirtual 829	android/widget/TextView:setVisibility	(I)V
    //   1662: aload 15
    //   1664: bipush 8
    //   1666: invokevirtual 832	com/tencent/mm/plugin/sns/ad/d/a/b:ajt	(I)V
    //   1669: aload 15
    //   1671: aload 9
    //   1673: invokevirtual 815	com/tencent/mm/plugin/sns/ad/d/a/b:a	(Lcom/tencent/mm/plugin/sns/ad/landingpage/component/info/g$a;)V
    //   1676: aload 14
    //   1678: getfield 749	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PRc	Lcom/tencent/mm/plugin/sns/ad/d/a/c;
    //   1681: ifnonnull +51 -> 1732
    //   1684: aload 15
    //   1686: getfield 825	com/tencent/mm/plugin/sns/ad/d/a/b:POX	Landroid/view/View;
    //   1689: bipush 8
    //   1691: invokevirtual 273	android/view/View:setVisibility	(I)V
    //   1694: ldc_w 733
    //   1697: ldc_w 845
    //   1700: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1703: aload 14
    //   1705: aload 9
    //   1707: invokevirtual 848	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:b	(Lcom/tencent/mm/plugin/sns/ad/landingpage/component/info/g$a;)Z
    //   1710: ifeq +307 -> 2017
    //   1713: aload 15
    //   1715: aload 9
    //   1717: getfield 851	com/tencent/mm/plugin/sns/ad/landingpage/component/info/g$a:PSh	Ljava/lang/String;
    //   1720: invokevirtual 854	com/tencent/mm/plugin/sns/ad/d/a/b:aWr	(Ljava/lang/String;)V
    //   1723: aload 15
    //   1725: iconst_0
    //   1726: invokevirtual 857	com/tencent/mm/plugin/sns/ad/d/a/b:Dl	(Z)V
    //   1729: goto -481 -> 1248
    //   1732: invokestatic 863	com/tencent/mm/plugin/sns/model/AdLandingPagesProxy:getInstance	()Lcom/tencent/mm/plugin/sns/model/AdLandingPagesProxy;
    //   1735: aload 14
    //   1737: getfield 749	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PRc	Lcom/tencent/mm/plugin/sns/ad/d/a/c;
    //   1740: getfield 866	com/tencent/mm/plugin/sns/ad/d/a/c:PPi	Ljava/lang/String;
    //   1743: invokevirtual 869	com/tencent/mm/plugin/sns/model/AdLandingPagesProxy:getDisplayName	(Ljava/lang/String;)Ljava/lang/String;
    //   1746: astore 12
    //   1748: aload 12
    //   1750: astore 11
    //   1752: aload 12
    //   1754: invokestatic 315	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1757: ifeq +54 -> 1811
    //   1760: ldc_w 733
    //   1763: new 89	java/lang/StringBuilder
    //   1766: dup
    //   1767: ldc_w 871
    //   1770: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1773: aload 12
    //   1775: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1778: ldc_w 873
    //   1781: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1784: aload 14
    //   1786: getfield 749	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PRc	Lcom/tencent/mm/plugin/sns/ad/d/a/c;
    //   1789: getfield 876	com/tencent/mm/plugin/sns/ad/d/a/c:JfB	Ljava/lang/String;
    //   1792: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1795: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1798: invokestatic 564	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1801: aload 14
    //   1803: getfield 749	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PRc	Lcom/tencent/mm/plugin/sns/ad/d/a/c;
    //   1806: getfield 876	com/tencent/mm/plugin/sns/ad/d/a/c:JfB	Ljava/lang/String;
    //   1809: astore 11
    //   1811: aload 11
    //   1813: invokestatic 315	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1816: ifne +188 -> 2004
    //   1819: aload 15
    //   1821: getfield 879	com/tencent/mm/plugin/sns/ad/d/a/b:POY	Landroid/widget/TextView;
    //   1824: aload 11
    //   1826: invokevirtual 306	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1829: aload 15
    //   1831: getfield 825	com/tencent/mm/plugin/sns/ad/d/a/b:POX	Landroid/view/View;
    //   1834: iconst_0
    //   1835: invokevirtual 273	android/view/View:setVisibility	(I)V
    //   1838: aload 14
    //   1840: getfield 749	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PRc	Lcom/tencent/mm/plugin/sns/ad/d/a/c;
    //   1843: getfield 866	com/tencent/mm/plugin/sns/ad/d/a/c:PPi	Ljava/lang/String;
    //   1846: astore 11
    //   1848: aload 15
    //   1850: getfield 882	com/tencent/mm/plugin/sns/ad/d/a/b:POZ	Landroid/widget/ImageView;
    //   1853: astore 12
    //   1855: ldc_w 733
    //   1858: ldc_w 884
    //   1861: aload 11
    //   1863: invokestatic 235	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1866: invokevirtual 239	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1869: invokestatic 564	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1872: aload 14
    //   1874: getfield 888	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:IYf	Landroid/graphics/Bitmap;
    //   1877: astore 16
    //   1879: aload 16
    //   1881: ifnonnull +41 -> 1922
    //   1884: invokestatic 894	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1887: invokevirtual 900	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   1890: ldc_w 902
    //   1893: invokevirtual 908	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1896: aconst_null
    //   1897: invokestatic 912	com/tencent/mm/cd/a:getDensity	(Landroid/content/Context;)F
    //   1900: invokestatic 918	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$BitmapFactory:decodeStream	(Ljava/io/InputStream;F)Landroid/graphics/Bitmap;
    //   1903: astore 16
    //   1905: aload 14
    //   1907: aload 16
    //   1909: iconst_0
    //   1910: aload 16
    //   1912: invokevirtual 923	android/graphics/Bitmap:getWidth	()I
    //   1915: i2f
    //   1916: invokestatic 929	com/tencent/mm/sdk/platformtools/BitmapUtil:getRoundedCornerBitmap	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   1919: putfield 888	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:IYf	Landroid/graphics/Bitmap;
    //   1922: aload 12
    //   1924: aload 14
    //   1926: getfield 888	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:IYf	Landroid/graphics/Bitmap;
    //   1929: invokevirtual 933	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   1932: aload 11
    //   1934: invokestatic 315	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1937: ifne -234 -> 1703
    //   1940: aload 12
    //   1942: aload 11
    //   1944: invokevirtual 937	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   1947: getstatic 695	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
    //   1950: new 939	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent$7
    //   1953: dup
    //   1954: aload 14
    //   1956: aload 11
    //   1958: aload 12
    //   1960: invokespecial 942	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent$7:<init>	(Lcom/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent;Ljava/lang/String;Landroid/widget/ImageView;)V
    //   1963: invokeinterface 706 2 0
    //   1968: pop
    //   1969: goto -266 -> 1703
    //   1972: astore 16
    //   1974: ldc_w 733
    //   1977: new 89	java/lang/StringBuilder
    //   1980: dup
    //   1981: ldc_w 944
    //   1984: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1987: aload 16
    //   1989: invokevirtual 100	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1992: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1995: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1998: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2001: goto -79 -> 1922
    //   2004: aload 15
    //   2006: getfield 825	com/tencent/mm/plugin/sns/ad/d/a/b:POX	Landroid/view/View;
    //   2009: bipush 8
    //   2011: invokevirtual 273	android/view/View:setVisibility	(I)V
    //   2014: goto -311 -> 1703
    //   2017: aload 14
    //   2019: aload 15
    //   2021: aload 14
    //   2023: getfield 780	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PRb	Lcom/tencent/mm/plugin/sns/ad/landingpage/component/info/g$a;
    //   2026: iconst_0
    //   2027: invokevirtual 947	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:a	(Lcom/tencent/mm/plugin/sns/ad/d/a/b;Lcom/tencent/mm/plugin/sns/ad/landingpage/component/info/g$a;I)V
    //   2030: goto -782 -> 1248
    //   2033: aload 14
    //   2035: getfield 786	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent:PRd	Lcom/tencent/mm/plugin/sns/ad/d/a/a;
    //   2038: iconst_1
    //   2039: iconst_1
    //   2040: invokevirtual 792	com/tencent/mm/plugin/sns/ad/d/a/a:bA	(IZ)V
    //   2043: goto -927 -> 1116
    //   2046: iconst_0
    //   2047: istore 8
    //   2049: goto -921 -> 1128
    //   2052: aload 9
    //   2054: invokevirtual 546	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/n:hap	()V
    //   2057: iload_3
    //   2058: ifeq +16 -> 2074
    //   2061: aload 9
    //   2063: invokevirtual 142	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/n:getContentView	()Landroid/view/View;
    //   2066: bipush 8
    //   2068: invokevirtual 273	android/view/View:setVisibility	(I)V
    //   2071: goto -1537 -> 534
    //   2074: aload_0
    //   2075: getfield 249	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/b:PPI	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/q;
    //   2078: astore 11
    //   2080: aload 11
    //   2082: getfield 951	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/q:QTY	Ljava/util/LinkedHashMap;
    //   2085: aload 9
    //   2087: getfield 130	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/n:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   2090: getfield 659	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa:QKG	Ljava/lang/String;
    //   2093: invokevirtual 957	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2096: pop
    //   2097: aload 11
    //   2099: getfield 961	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/q:CAj	Landroid/view/ViewGroup;
    //   2102: aload 9
    //   2104: invokevirtual 142	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/n:getContentView	()Landroid/view/View;
    //   2107: invokevirtual 967	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   2110: aload 9
    //   2112: invokevirtual 567	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/n:has	()V
    //   2115: goto -1581 -> 534
    //   2118: astore 11
    //   2120: ldc_w 969
    //   2123: new 89	java/lang/StringBuilder
    //   2126: dup
    //   2127: ldc_w 971
    //   2130: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2133: aload 11
    //   2135: invokevirtual 100	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2138: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2141: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2144: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2147: goto -37 -> 2110
    //   2150: aload_0
    //   2151: aload_0
    //   2152: invokevirtual 268	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/b:hai	()Ljava/util/List;
    //   2155: putfield 52	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/b:PPH	Ljava/util/List;
    //   2158: goto -1353 -> 805
    //   2161: ldc 87
    //   2163: ldc_w 973
    //   2166: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2169: goto -1364 -> 805
    //   2172: iload_3
    //   2173: iconst_1
    //   2174: iadd
    //   2175: istore_3
    //   2176: goto -1790 -> 386
    //   2179: aconst_null
    //   2180: astore 9
    //   2182: goto -2100 -> 82
    //   2185: iload_3
    //   2186: iconst_1
    //   2187: iadd
    //   2188: istore_3
    //   2189: goto -1726 -> 463
    //   2192: iconst_0
    //   2193: istore_3
    //   2194: goto -1671 -> 523
    //   2197: goto -949 -> 1248
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2200	0	this	b
    //   0	2200	1	paramString1	String
    //   0	2200	2	paramString2	String
    //   385	1809	3	i	int
    //   25	897	4	j	int
    //   1012	248	5	k	int
    //   19	802	6	l	long
    //   1126	922	8	bool	boolean
    //   68	696	9	localObject1	Object
    //   839	16	9	localObject2	Object
    //   928	167	9	localObject3	Object
    //   1146	16	9	localObject4	Object
    //   1179	1002	9	locala	com.tencent.mm.plugin.sns.ad.landingpage.component.info.g.a
    //   46	590	10	localObject5	Object
    //   175	1923	11	localObject6	Object
    //   2118	16	11	localObject7	Object
    //   185	1774	12	localObject8	Object
    //   369	176	13	localObject9	Object
    //   401	1633	14	localObject10	Object
    //   1628	392	15	localb	com.tencent.mm.plugin.sns.ad.d.a.b
    //   1877	34	16	localBitmap	android.graphics.Bitmap
    //   1972	16	16	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   21	48	779	finally
    //   48	82	779	finally
    //   91	112	779	finally
    //   123	131	779	finally
    //   136	167	779	finally
    //   514	521	779	finally
    //   523	534	779	finally
    //   534	618	779	finally
    //   623	628	779	finally
    //   628	640	779	finally
    //   646	656	779	finally
    //   661	680	779	finally
    //   685	776	779	finally
    //   841	868	779	finally
    //   877	915	779	finally
    //   924	950	779	finally
    //   955	961	779	finally
    //   1116	1125	779	finally
    //   1128	1134	779	finally
    //   1148	1175	779	finally
    //   2052	2057	779	finally
    //   2061	2071	779	finally
    //   2074	2080	779	finally
    //   2110	2115	779	finally
    //   2120	2147	779	finally
    //   2150	2158	779	finally
    //   2161	2169	779	finally
    //   167	202	839	finally
    //   202	227	839	finally
    //   227	252	839	finally
    //   252	277	839	finally
    //   277	302	839	finally
    //   302	327	839	finally
    //   327	352	839	finally
    //   352	371	839	finally
    //   376	384	839	finally
    //   386	419	839	finally
    //   422	448	839	finally
    //   453	461	839	finally
    //   463	496	839	finally
    //   499	514	839	finally
    //   961	1014	1146	finally
    //   1020	1029	1146	finally
    //   1029	1071	1146	finally
    //   1082	1094	1146	finally
    //   1099	1116	1146	finally
    //   1137	1143	1146	finally
    //   1184	1215	1146	finally
    //   1254	1265	1146	finally
    //   1268	1353	1146	finally
    //   1356	1433	1146	finally
    //   1436	1595	1146	finally
    //   1598	1703	1146	finally
    //   1703	1729	1146	finally
    //   1732	1748	1146	finally
    //   1752	1811	1146	finally
    //   1811	1879	1146	finally
    //   1922	1969	1146	finally
    //   1974	2001	1146	finally
    //   2004	2014	1146	finally
    //   2017	2030	1146	finally
    //   2033	2043	1146	finally
    //   1884	1922	1972	finally
    //   2080	2110	2118	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.comp.b
 * JD-Core Version:    0.7.0.1
 */