package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import org.json.JSONObject;

public final class ah
  extends m
{
  protected aq gNm;
  protected ProgressBar jtq;
  protected Context mContext;
  protected boolean ncj;
  protected boolean yKp;
  protected SphereImageView zYm;
  protected View zYn;
  protected ImageView zYo;
  protected a zYp;
  int zYq;
  protected boolean zYr;
  protected SphereImageView.b zYs;
  protected boolean zYt;
  
  public ah(Context paramContext, t paramt, ViewGroup paramViewGroup)
  {
    super(paramContext, paramt, paramViewGroup);
    AppMethodBeat.i(96749);
    this.yKp = true;
    this.ncj = false;
    this.zYr = false;
    this.gNm = new aq(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(96740);
        ah.this.aBf("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_none");
        ah.this.zYr = false;
        AppMethodBeat.o(96740);
      }
    };
    this.zYs = new SphereImageView.b()
    {
      public final void aBg(String paramAnonymousString)
      {
        final long l1 = 800L;
        AppMethodBeat.i(96748);
        ae.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "onUpdateImage, isFirstShow=" + ah.this.yKp);
        ah.this.stopLoading();
        if (ah.this.zYo.getVisibility() == 0)
        {
          paramAnonymousString = new AlphaAnimation(1.0F, 0.0F);
          paramAnonymousString.setDuration(300L);
          paramAnonymousString.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(96741);
              ah.this.zYo.setVisibility(8);
              ah.this.zYo.setImageDrawable(null);
              ah.this.zYn.setVisibility(0);
              paramAnonymous2Animation = ObjectAnimator.ofFloat(ah.this.zYn, "alpha", new float[] { 0.0F, 1.0F });
              paramAnonymous2Animation.setDuration(400L);
              paramAnonymous2Animation.start();
              AppMethodBeat.o(96741);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation) {}
          });
          ah.this.zYo.startAnimation(paramAnonymousString);
        }
        long l2;
        if (ah.this.yKp)
        {
          ah.this.yKp = false;
          ah.this.gNm.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96743);
              AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
              localAlphaAnimation.setDuration(300L);
              localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
              {
                public final void onAnimationEnd(Animation paramAnonymous3Animation)
                {
                  AppMethodBeat.i(96742);
                  ae.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "hide rollTipView");
                  ah.this.zYn.setVisibility(8);
                  ah.this.aBf("com.tencent.mm.adlanding.sphereimage.next_page_view_show");
                  ah.this.zYr = false;
                  AppMethodBeat.o(96742);
                }
                
                public final void onAnimationRepeat(Animation paramAnonymous3Animation) {}
                
                public final void onAnimationStart(Animation paramAnonymous3Animation) {}
              });
              ah.this.zYn.startAnimation(localAlphaAnimation);
              AppMethodBeat.o(96743);
            }
          }, 2500L);
          l2 = ah.this.eaR().zOT;
          if (l2 >= 800L) {
            break label209;
          }
        }
        for (;;)
        {
          ah.this.gNm.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96744);
              ah.this.zYm.ebD();
              ah.this.zYm.AaM.requestRender();
              String str = ah.this.eaR().zOU;
              if (!a.jJ(str, "scene_ad_landing"))
              {
                ae.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "do shoot");
                a.a(ah.this.zYm, str, "scene_ad_landing");
              }
              ae.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "enable sensor after shoot");
              ah.this.zYm.setSensorEnabled(true);
              ae.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "enable touch, delay=" + l1);
              ah.this.zYm.setTouchEnabled(true);
              AppMethodBeat.o(96744);
            }
          }, l1);
          AppMethodBeat.o(96748);
          return;
          ae.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "enable sensor, isFirstShow=false");
          ah.this.zYm.setSensorEnabled(true);
          AppMethodBeat.o(96748);
          return;
          label209:
          l1 = l2;
        }
      }
      
      public final void eaU()
      {
        AppMethodBeat.i(96745);
        if (!ah.this.zYr)
        {
          ah.this.aBf("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half");
          ah.this.zYr = true;
          ae.d("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "onAngleChange");
        }
        ah.this.gNm.removeMessages(1);
        ah.this.gNm.sendEmptyMessageDelayed(1, 3000L);
        AppMethodBeat.o(96745);
      }
      
      public final void eaV()
      {
        AppMethodBeat.i(96746);
        ae.d("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "onTouchBegin, isRoating=" + ah.this.zYr);
        if (!ah.this.zYr)
        {
          ah.this.aBf("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half");
          ah.this.zYr = true;
        }
        ah.this.gNm.removeMessages(1);
        AppMethodBeat.o(96746);
      }
      
      public final void eaW()
      {
        AppMethodBeat.i(96747);
        ae.d("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "onTouchEnd");
        ah.this.gNm.removeMessages(1);
        ah.this.gNm.sendEmptyMessageDelayed(1, 3000L);
        ah localah = ah.this;
        localah.zYq += 1;
        AppMethodBeat.o(96747);
      }
      
      public final void onDetachedFromWindow() {}
    };
    this.zYt = true;
    this.mContext = paramContext;
    AppMethodBeat.o(96749);
  }
  
  protected final void aBf(String paramString)
  {
    AppMethodBeat.i(96760);
    an.f(paramString, this.mContext);
    AppMethodBeat.o(96760);
  }
  
  public final boolean aQ(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96761);
    if (!super.aQ(paramJSONObject))
    {
      ae.e("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "setComponentKVReportData super failed");
      AppMethodBeat.o(96761);
      return false;
    }
    try
    {
      paramJSONObject.put("panCount", this.zYq);
      ae.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "setComponentKVReportData json=" + paramJSONObject.toString());
      AppMethodBeat.o(96761);
      return true;
    }
    catch (Exception paramJSONObject)
    {
      ae.e("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "setComponentKVReportData exp=" + paramJSONObject.toString());
      AppMethodBeat.o(96761);
    }
    return false;
  }
  
  public final void dUI()
  {
    AppMethodBeat.i(96750);
    this.zYm = ((SphereImageView)this.contentView.findViewById(2131305149));
    this.jtq = ((ProgressBar)this.contentView.findViewById(2131303535));
    this.zYn = this.contentView.findViewById(2131305874);
    this.zYo = ((ImageView)this.contentView.findViewById(2131302164));
    this.zYm.setEventListener(this.zYs);
    this.zYm.ag(2.0F, -4.0F);
    this.zYm.setTouchSensitivity(0.35F);
    this.zYm.setSensorEnabled(false);
    ae.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "createView, hash=" + this.zYm.hashCode());
    this.zYm.setTouchEnabled(false);
    ae.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "disable touch init");
    this.zYp = new a();
    this.zYp.a(new a.d()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString1, Bitmap paramAnonymousBitmap, String paramAnonymousString2)
      {
        AppMethodBeat.i(96739);
        ae.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "ImageLoader onFinish, isSucc=" + paramAnonymousBoolean + ", errInfo=" + paramAnonymousString1);
        ah.this.zYm.g(paramAnonymousBitmap, paramAnonymousString2);
        if (!paramAnonymousBoolean) {
          ah.this.stopLoading();
        }
        AppMethodBeat.o(96739);
      }
      
      public final void onStart(String paramAnonymousString)
      {
        AppMethodBeat.i(96738);
        ae.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "ImageLoader onStart");
        paramAnonymousString = a.jI(paramAnonymousString, "scene_ad_landing");
        if (paramAnonymousString != null)
        {
          ah.this.zYo.setImageBitmap(paramAnonymousString);
          ah.this.zYo.setVisibility(0);
          AppMethodBeat.o(96738);
          return;
        }
        ah.this.startLoading();
        AppMethodBeat.o(96738);
      }
    });
    AppMethodBeat.o(96750);
  }
  
  /* Error */
  protected final void dUJ()
  {
    // Byte code:
    //   0: ldc 216
    //   2: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 145	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah:contentView	Landroid/view/View;
    //   9: ifnull +17 -> 26
    //   12: aload_0
    //   13: getfield 156	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah:zYm	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   16: ifnull +10 -> 26
    //   19: aload_0
    //   20: getfield 161	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah:jtq	Landroid/widget/ProgressBar;
    //   23: ifnonnull +16 -> 39
    //   26: ldc 101
    //   28: ldc 218
    //   30: invokestatic 109	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: ldc 216
    //   35: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: return
    //   39: aload_0
    //   40: getfield 222	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah:zUP	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/y;
    //   43: checkcast 224	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t
    //   46: ifnonnull +16 -> 62
    //   49: ldc 101
    //   51: ldc 226
    //   53: invokestatic 109	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: ldc 216
    //   58: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: return
    //   62: aload_0
    //   63: getfield 222	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah:zUP	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/y;
    //   66: checkcast 224	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t
    //   69: getfield 230	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t:zOU	Ljava/lang/String;
    //   72: astore 5
    //   74: aload_0
    //   75: getfield 222	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah:zUP	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/y;
    //   78: checkcast 224	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t
    //   81: getfield 233	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t:zOW	Ljava/lang/String;
    //   84: astore 7
    //   86: aload_0
    //   87: getfield 222	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah:zUP	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/y;
    //   90: checkcast 224	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t
    //   93: getfield 237	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t:height	F
    //   96: fstore_2
    //   97: aload_0
    //   98: getfield 222	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah:zUP	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/y;
    //   101: checkcast 224	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t
    //   104: getfield 240	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t:width	F
    //   107: fstore_1
    //   108: aload_0
    //   109: getfield 222	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah:zUP	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/y;
    //   112: checkcast 224	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t
    //   115: getfield 243	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t:zQJ	Z
    //   118: istore 4
    //   120: aload_0
    //   121: iconst_0
    //   122: putfield 57	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah:ncj	Z
    //   125: ldc 101
    //   127: new 121	java/lang/StringBuilder
    //   130: dup
    //   131: ldc 245
    //   133: invokespecial 125	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   136: fload_1
    //   137: invokevirtual 248	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   140: ldc 250
    //   142: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: fload_2
    //   146: invokevirtual 248	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   149: ldc 252
    //   151: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_0
    //   155: getfield 255	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah:lxZ	I
    //   158: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   161: ldc 250
    //   163: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload_0
    //   167: getfield 258	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah:lya	I
    //   170: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   173: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 136	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: aload_0
    //   180: getfield 156	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah:zYm	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   183: invokevirtual 262	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   186: astore 6
    //   188: fload_2
    //   189: fconst_0
    //   190: fcmpl
    //   191: ifeq +219 -> 410
    //   194: fload_1
    //   195: fconst_0
    //   196: fcmpl
    //   197: ifeq +213 -> 410
    //   200: iload 4
    //   202: ifne +208 -> 410
    //   205: aload_0
    //   206: getfield 255	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah:lxZ	I
    //   209: aload_0
    //   210: getfield 222	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah:zUP	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/y;
    //   213: checkcast 224	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t
    //   216: getfield 265	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t:paddingLeft	F
    //   219: f2i
    //   220: isub
    //   221: aload_0
    //   222: getfield 222	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah:zUP	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/y;
    //   225: checkcast 224	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t
    //   228: getfield 268	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t:paddingRight	F
    //   231: f2i
    //   232: isub
    //   233: istore_3
    //   234: fload_1
    //   235: iload_3
    //   236: i2f
    //   237: fcmpg
    //   238: ifge +166 -> 404
    //   241: fload_1
    //   242: aload_0
    //   243: getfield 222	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah:zUP	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/y;
    //   246: checkcast 224	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t
    //   249: getfield 237	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t:height	F
    //   252: fmul
    //   253: aload_0
    //   254: getfield 222	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah:zUP	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/y;
    //   257: checkcast 224	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t
    //   260: getfield 240	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t:width	F
    //   263: fdiv
    //   264: fstore_2
    //   265: aload 6
    //   267: fload_1
    //   268: f2i
    //   269: putfield 272	android/view/ViewGroup$LayoutParams:width	I
    //   272: aload 6
    //   274: fload_2
    //   275: f2i
    //   276: putfield 274	android/view/ViewGroup$LayoutParams:height	I
    //   279: aload 6
    //   281: getfield 272	android/view/ViewGroup$LayoutParams:width	I
    //   284: aload_0
    //   285: getfield 255	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah:lxZ	I
    //   288: if_icmplt +20 -> 308
    //   291: aload 6
    //   293: getfield 274	android/view/ViewGroup$LayoutParams:height	I
    //   296: aload_0
    //   297: getfield 258	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah:lya	I
    //   300: if_icmplt +8 -> 308
    //   303: aload_0
    //   304: iconst_1
    //   305: putfield 57	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah:ncj	Z
    //   308: aload_0
    //   309: getfield 156	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah:zYm	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   312: aload 6
    //   314: invokevirtual 278	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   317: aload_0
    //   318: getfield 169	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah:zYo	Landroid/widget/ImageView;
    //   321: invokevirtual 279	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   324: astore 8
    //   326: aload 8
    //   328: aload 6
    //   330: getfield 272	android/view/ViewGroup$LayoutParams:width	I
    //   333: putfield 272	android/view/ViewGroup$LayoutParams:width	I
    //   336: aload 8
    //   338: aload 6
    //   340: getfield 274	android/view/ViewGroup$LayoutParams:height	I
    //   343: putfield 274	android/view/ViewGroup$LayoutParams:height	I
    //   346: aload_0
    //   347: getfield 169	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah:zYo	Landroid/widget/ImageView;
    //   350: aload 8
    //   352: invokevirtual 280	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   355: aload 7
    //   357: ifnull +25 -> 382
    //   360: aload 7
    //   362: invokevirtual 285	java/lang/String:length	()I
    //   365: istore_3
    //   366: iload_3
    //   367: ifle +15 -> 382
    //   370: aload_0
    //   371: getfield 145	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah:contentView	Landroid/view/View;
    //   374: aload 7
    //   376: invokestatic 291	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   379: invokevirtual 294	android/view/View:setBackgroundColor	(I)V
    //   382: aload 5
    //   384: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   387: ifeq +114 -> 501
    //   390: ldc 101
    //   392: ldc_w 302
    //   395: invokestatic 109	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   398: ldc 216
    //   400: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   403: return
    //   404: iload_3
    //   405: i2f
    //   406: fstore_1
    //   407: goto -166 -> 241
    //   410: aload 6
    //   412: aload_0
    //   413: getfield 255	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah:lxZ	I
    //   416: putfield 272	android/view/ViewGroup$LayoutParams:width	I
    //   419: aload 6
    //   421: aload_0
    //   422: getfield 258	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah:lya	I
    //   425: putfield 274	android/view/ViewGroup$LayoutParams:height	I
    //   428: aload_0
    //   429: iconst_1
    //   430: putfield 57	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah:ncj	Z
    //   433: goto -125 -> 308
    //   436: astore 5
    //   438: ldc 101
    //   440: new 121	java/lang/StringBuilder
    //   443: dup
    //   444: ldc_w 304
    //   447: invokespecial 125	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   450: aload 5
    //   452: invokevirtual 139	java/lang/Exception:toString	()Ljava/lang/String;
    //   455: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokestatic 109	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   464: ldc 216
    //   466: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   469: return
    //   470: astore 7
    //   472: ldc 101
    //   474: new 121	java/lang/StringBuilder
    //   477: dup
    //   478: ldc_w 306
    //   481: invokespecial 125	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   484: aload 7
    //   486: invokevirtual 139	java/lang/Exception:toString	()Ljava/lang/String;
    //   489: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: invokestatic 109	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   498: goto -116 -> 382
    //   501: ldc 101
    //   503: new 121	java/lang/StringBuilder
    //   506: dup
    //   507: ldc_w 308
    //   510: invokespecial 125	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   513: aload_0
    //   514: getfield 57	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah:ncj	Z
    //   517: invokevirtual 311	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   520: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: invokestatic 136	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   526: aload_0
    //   527: getfield 209	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah:zYp	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a;
    //   530: aload 5
    //   532: aload 6
    //   534: getfield 272	android/view/ViewGroup$LayoutParams:width	I
    //   537: aload 6
    //   539: getfield 274	android/view/ViewGroup$LayoutParams:height	I
    //   542: ldc_w 313
    //   545: invokevirtual 317	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a:l	(Ljava/lang/String;IILjava/lang/String;)V
    //   548: ldc 216
    //   550: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   553: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	554	0	this	ah
    //   107	300	1	f1	float
    //   96	179	2	f2	float
    //   233	172	3	i	int
    //   118	83	4	bool	boolean
    //   72	311	5	str1	String
    //   436	95	5	localException1	Exception
    //   186	352	6	localLayoutParams1	ViewGroup.LayoutParams
    //   84	291	7	str2	String
    //   470	15	7	localException2	Exception
    //   324	27	8	localLayoutParams2	ViewGroup.LayoutParams
    // Exception table:
    //   from	to	target	type
    //   5	26	436	java/lang/Exception
    //   26	33	436	java/lang/Exception
    //   39	56	436	java/lang/Exception
    //   62	188	436	java/lang/Exception
    //   205	234	436	java/lang/Exception
    //   241	308	436	java/lang/Exception
    //   308	355	436	java/lang/Exception
    //   360	366	436	java/lang/Exception
    //   382	398	436	java/lang/Exception
    //   410	433	436	java/lang/Exception
    //   472	498	436	java/lang/Exception
    //   501	548	436	java/lang/Exception
    //   370	382	470	java/lang/Exception
  }
  
  public final void dUK()
  {
    AppMethodBeat.i(96755);
    super.dUK();
    ae.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "viewWillAppear, isFirstApper=" + this.zYt);
    if (!this.zYt)
    {
      this.zYm.setSensorEnabled(true);
      if (!this.zYr)
      {
        aBf("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half");
        this.zYr = true;
      }
      this.gNm.removeMessages(1);
      this.gNm.sendEmptyMessageDelayed(1, 3000L);
      AppMethodBeat.o(96755);
      return;
    }
    this.zYt = false;
    AppMethodBeat.o(96755);
  }
  
  public final void dUL()
  {
    AppMethodBeat.i(96756);
    super.dUL();
    ae.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "viewWillDisappear, disable sensor");
    this.zYm.setSensorEnabled(false);
    AppMethodBeat.o(96756);
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(96757);
    super.dUM();
    ae.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "viewWillDestroy, disable sensor");
    this.zYm.setSensorEnabled(false);
    AppMethodBeat.o(96757);
  }
  
  public final t eaR()
  {
    return (t)this.zUP;
  }
  
  public final Bitmap eaS()
  {
    int j = 0;
    AppMethodBeat.i(96758);
    try
    {
      Bitmap localBitmap = this.zYm.getBitmap();
      StringBuilder localStringBuilder = new StringBuilder("getCurFrameBitmap, w=");
      if (localBitmap == null)
      {
        i = 0;
        localStringBuilder = localStringBuilder.append(i).append(", h=");
        if (localBitmap != null) {
          break label83;
        }
      }
      label83:
      for (int i = j;; i = localBitmap.getHeight())
      {
        ae.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", i);
        AppMethodBeat.o(96758);
        return localBitmap;
        i = localBitmap.getWidth();
        break;
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      ae.e("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "getCurFrameBitmap exp:" + localThrowable.toString());
      AppMethodBeat.o(96758);
    }
  }
  
  public final void eaT()
  {
    AppMethodBeat.i(96759);
    if (this.zYn.getVisibility() == 0)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.zYn, "alpha", new float[] { 1.0F, 0.0F });
      localObjectAnimator.setDuration(250L);
      localObjectAnimator.start();
    }
    aBf("com.tencent.mm.adlanding.sphereimage.next_page_view_hide");
    AppMethodBeat.o(96759);
  }
  
  protected final void eah()
  {
    AppMethodBeat.i(96751);
    Object localObject = this.contentView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).setMargins((int)((t)this.zUP).paddingLeft, (int)((t)this.zUP).paddingTop, (int)((t)this.zUP).paddingRight, (int)((t)this.zUP).paddingBottom);
      this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(96751);
  }
  
  protected final int getLayout()
  {
    return 2131495509;
  }
  
  public final void startLoading()
  {
    AppMethodBeat.i(96753);
    this.jtq.setVisibility(0);
    AppMethodBeat.o(96753);
  }
  
  public final void stopLoading()
  {
    AppMethodBeat.i(96754);
    this.jtq.setVisibility(8);
    AppMethodBeat.o(96754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah
 * JD-Core Version:    0.7.0.1
 */