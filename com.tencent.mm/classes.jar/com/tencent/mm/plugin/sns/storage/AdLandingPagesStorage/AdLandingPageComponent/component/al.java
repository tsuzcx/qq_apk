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
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import org.json.JSONObject;

public final class al
  extends n
{
  protected boolean Flq;
  protected boolean Pcx;
  protected SphereImageView QSc;
  protected View QSd;
  protected ImageView QSe;
  protected a QSf;
  int QSg;
  protected boolean QSh;
  protected SphereImageView.b QSi;
  protected boolean QSj;
  protected MMHandler eqE;
  protected Context mContext;
  protected ProgressBar qgC;
  
  public al(Context paramContext, v paramv, ViewGroup paramViewGroup)
  {
    super(paramContext, paramv, paramViewGroup);
    AppMethodBeat.i(96749);
    this.Pcx = true;
    this.Flq = false;
    this.QSh = false;
    this.eqE = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(96740);
        al.this.aZz("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_none");
        al.this.QSh = false;
        AppMethodBeat.o(96740);
      }
    };
    this.QSi = new SphereImageView.b()
    {
      public final void aZA(String paramAnonymousString)
      {
        AppMethodBeat.i(96748);
        Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "onUpdateImage, isFirstShow=" + al.this.Pcx);
        al.this.stopLoading();
        if (al.this.QSe.getVisibility() == 0)
        {
          paramAnonymousString = new AlphaAnimation(1.0F, 0.0F);
          paramAnonymousString.setDuration(300L);
          paramAnonymousString.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(96741);
              al.this.QSe.setVisibility(8);
              al.this.QSe.setImageDrawable(null);
              al.this.QSd.setVisibility(0);
              paramAnonymous2Animation = ObjectAnimator.ofFloat(al.this.QSd, "alpha", new float[] { 0.0F, 1.0F });
              paramAnonymous2Animation.setDuration(400L);
              paramAnonymous2Animation.start();
              AppMethodBeat.o(96741);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation) {}
          });
          al.this.QSe.startAnimation(paramAnonymousString);
        }
        if (al.this.Pcx)
        {
          al.this.Pcx = false;
          al.this.eqE.postDelayed(new Runnable()
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
                  Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "hide rollTipView");
                  al.this.QSd.setVisibility(8);
                  al.this.aZz("com.tencent.mm.adlanding.sphereimage.next_page_view_show");
                  al.this.QSh = false;
                  AppMethodBeat.o(96742);
                }
                
                public final void onAnimationRepeat(Animation paramAnonymous3Animation) {}
                
                public final void onAnimationStart(Animation paramAnonymous3Animation) {}
              });
              al.this.QSd.startAnimation(localAlphaAnimation);
              AppMethodBeat.o(96743);
            }
          }, 2500L);
          long l2 = ((v)al.this.QOV).QHU;
          final long l1 = l2;
          if (l2 < 800L) {
            l1 = 800L;
          }
          al.this.eqE.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96744);
              al.this.QSc.hkt();
              al.this.QSc.QUV.requestRender();
              String str = ((v)al.this.QOV).QHV;
              if (!a.mz(str, "scene_ad_landing"))
              {
                Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "do shoot");
                a.a(al.this.QSc, str, "scene_ad_landing");
              }
              Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "enable sensor after shoot");
              al.this.QSc.setSensorEnabled(true);
              Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "enable touch, delay=" + l1);
              al.this.QSc.setTouchEnabled(true);
              AppMethodBeat.o(96744);
            }
          }, l1);
          AppMethodBeat.o(96748);
          return;
        }
        Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "enable sensor, isFirstShow=false");
        al.this.QSc.setSensorEnabled(true);
        AppMethodBeat.o(96748);
      }
      
      public final void hjD()
      {
        AppMethodBeat.i(96745);
        if (!al.this.QSh)
        {
          al.this.aZz("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half");
          al.this.QSh = true;
          Log.d("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "onAngleChange");
        }
        al.this.eqE.removeMessages(1);
        al.this.eqE.sendEmptyMessageDelayed(1, 3000L);
        AppMethodBeat.o(96745);
      }
      
      public final void hjE()
      {
        AppMethodBeat.i(96746);
        Log.d("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "onTouchBegin, isRoating=" + al.this.QSh);
        if (!al.this.QSh)
        {
          al.this.aZz("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half");
          al.this.QSh = true;
        }
        al.this.eqE.removeMessages(1);
        AppMethodBeat.o(96746);
      }
      
      public final void hjF()
      {
        AppMethodBeat.i(96747);
        Log.d("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "onTouchEnd");
        al.this.eqE.removeMessages(1);
        al.this.eqE.sendEmptyMessageDelayed(1, 3000L);
        al localal = al.this;
        localal.QSg += 1;
        AppMethodBeat.o(96747);
      }
      
      public final void onDetachedFromWindow() {}
    };
    this.QSj = true;
    this.mContext = paramContext;
    AppMethodBeat.o(96749);
  }
  
  public final void Gs()
  {
    AppMethodBeat.i(96750);
    this.QSc = ((SphereImageView)this.contentView.findViewById(b.f.sphere_image));
    this.qgC = ((ProgressBar)this.contentView.findViewById(b.f.progressbar));
    this.QSd = this.contentView.findViewById(b.f.tip_layout);
    this.QSe = ((ImageView)this.contentView.findViewById(b.f.mask_img));
    this.QSc.setEventListener(this.QSi);
    this.QSc.aV(2.0F, -4.0F);
    this.QSc.setTouchSensitivity(0.35F);
    this.QSc.setSensorEnabled(false);
    Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "createView, hash=" + this.QSc.hashCode());
    this.QSc.setTouchEnabled(false);
    Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "disable touch init");
    this.QSf = new a();
    this.QSf.a(new a.d()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString1, Bitmap paramAnonymousBitmap, String paramAnonymousString2)
      {
        AppMethodBeat.i(96739);
        Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "ImageLoader onFinish, isSucc=" + paramAnonymousBoolean + ", errInfo=" + paramAnonymousString1);
        al.this.QSc.k(paramAnonymousBitmap, paramAnonymousString2);
        if (!paramAnonymousBoolean) {
          al.this.stopLoading();
        }
        AppMethodBeat.o(96739);
      }
      
      public final void aNZ(String paramAnonymousString)
      {
        AppMethodBeat.i(96738);
        Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "ImageLoader onStart");
        paramAnonymousString = a.my(paramAnonymousString, "scene_ad_landing");
        if (paramAnonymousString != null)
        {
          al.this.QSe.setImageBitmap(paramAnonymousString);
          al.this.QSe.setVisibility(0);
          AppMethodBeat.o(96738);
          return;
        }
        al.this.startLoading();
        AppMethodBeat.o(96738);
      }
    });
    AppMethodBeat.o(96750);
  }
  
  protected final void aZz(String paramString)
  {
    AppMethodBeat.i(96760);
    ar.i(paramString, this.mContext);
    AppMethodBeat.o(96760);
  }
  
  public final boolean bP(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96761);
    if (!super.bP(paramJSONObject))
    {
      Log.e("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "setComponentKVReportData super failed");
      AppMethodBeat.o(96761);
      return false;
    }
    try
    {
      paramJSONObject.put("panCount", this.QSg);
      Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "setComponentKVReportData json=" + paramJSONObject.toString());
      AppMethodBeat.o(96761);
      return true;
    }
    catch (Exception paramJSONObject)
    {
      Log.e("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "setComponentKVReportData exp=" + paramJSONObject.toString());
      AppMethodBeat.o(96761);
    }
    return false;
  }
  
  protected final int getLayout()
  {
    return b.g.sns_ad_native_landing_pages_item_sphere_image;
  }
  
  /* Error */
  protected final void had()
  {
    // Byte code:
    //   0: ldc 231
    //   2: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 89	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:contentView	Landroid/view/View;
    //   9: ifnull +17 -> 26
    //   12: aload_0
    //   13: getfield 104	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:QSc	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   16: ifnull +10 -> 26
    //   19: aload_0
    //   20: getfield 111	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:qgC	Landroid/widget/ProgressBar;
    //   23: ifnonnull +16 -> 39
    //   26: ldc 143
    //   28: ldc 233
    //   30: invokestatic 204	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: ldc 231
    //   35: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: return
    //   39: aload_0
    //   40: getfield 237	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   43: checkcast 239	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/v
    //   46: ifnonnull +16 -> 62
    //   49: ldc 143
    //   51: ldc 241
    //   53: invokestatic 204	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: ldc 231
    //   58: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: return
    //   62: aload_0
    //   63: getfield 237	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   66: checkcast 239	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/v
    //   69: getfield 245	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/v:QHV	Ljava/lang/String;
    //   72: astore 5
    //   74: aload_0
    //   75: getfield 237	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   78: checkcast 239	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/v
    //   81: getfield 248	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/v:bgColor	Ljava/lang/String;
    //   84: astore 7
    //   86: aload_0
    //   87: getfield 237	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   90: checkcast 239	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/v
    //   93: getfield 252	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/v:height	F
    //   96: fstore_2
    //   97: aload_0
    //   98: getfield 237	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   101: checkcast 239	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/v
    //   104: getfield 255	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/v:width	F
    //   107: fstore_1
    //   108: aload_0
    //   109: getfield 237	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   112: checkcast 239	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/v
    //   115: getfield 258	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/v:QKi	Z
    //   118: istore 4
    //   120: aload_0
    //   121: iconst_0
    //   122: putfield 57	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:Flq	Z
    //   125: ldc 143
    //   127: new 145	java/lang/StringBuilder
    //   130: dup
    //   131: ldc_w 260
    //   134: invokespecial 150	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   137: fload_1
    //   138: invokevirtual 263	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   141: ldc_w 265
    //   144: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: fload_2
    //   148: invokevirtual 263	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   151: ldc_w 267
    //   154: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_0
    //   158: getfield 270	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:sJv	I
    //   161: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   164: ldc_w 265
    //   167: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload_0
    //   171: getfield 273	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:pvg	I
    //   174: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   177: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 169	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: aload_0
    //   184: getfield 104	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:QSc	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   187: invokevirtual 277	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   190: astore 6
    //   192: fload_2
    //   193: fconst_0
    //   194: fcmpl
    //   195: ifeq +219 -> 414
    //   198: fload_1
    //   199: fconst_0
    //   200: fcmpl
    //   201: ifeq +213 -> 414
    //   204: iload 4
    //   206: ifne +208 -> 414
    //   209: aload_0
    //   210: getfield 270	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:sJv	I
    //   213: aload_0
    //   214: getfield 237	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   217: checkcast 239	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/v
    //   220: getfield 280	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/v:paddingLeft	F
    //   223: f2i
    //   224: isub
    //   225: aload_0
    //   226: getfield 237	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   229: checkcast 239	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/v
    //   232: getfield 283	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/v:paddingRight	F
    //   235: f2i
    //   236: isub
    //   237: istore_3
    //   238: fload_1
    //   239: iload_3
    //   240: i2f
    //   241: fcmpg
    //   242: ifge +166 -> 408
    //   245: fload_1
    //   246: aload_0
    //   247: getfield 237	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   250: checkcast 239	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/v
    //   253: getfield 252	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/v:height	F
    //   256: fmul
    //   257: aload_0
    //   258: getfield 237	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   261: checkcast 239	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/v
    //   264: getfield 255	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/v:width	F
    //   267: fdiv
    //   268: fstore_2
    //   269: aload 6
    //   271: fload_1
    //   272: f2i
    //   273: putfield 287	android/view/ViewGroup$LayoutParams:width	I
    //   276: aload 6
    //   278: fload_2
    //   279: f2i
    //   280: putfield 289	android/view/ViewGroup$LayoutParams:height	I
    //   283: aload 6
    //   285: getfield 287	android/view/ViewGroup$LayoutParams:width	I
    //   288: aload_0
    //   289: getfield 270	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:sJv	I
    //   292: if_icmplt +20 -> 312
    //   295: aload 6
    //   297: getfield 289	android/view/ViewGroup$LayoutParams:height	I
    //   300: aload_0
    //   301: getfield 273	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:pvg	I
    //   304: if_icmplt +8 -> 312
    //   307: aload_0
    //   308: iconst_1
    //   309: putfield 57	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:Flq	Z
    //   312: aload_0
    //   313: getfield 104	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:QSc	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   316: aload 6
    //   318: invokevirtual 293	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   321: aload_0
    //   322: getfield 123	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:QSe	Landroid/widget/ImageView;
    //   325: invokevirtual 294	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   328: astore 8
    //   330: aload 8
    //   332: aload 6
    //   334: getfield 287	android/view/ViewGroup$LayoutParams:width	I
    //   337: putfield 287	android/view/ViewGroup$LayoutParams:width	I
    //   340: aload 8
    //   342: aload 6
    //   344: getfield 289	android/view/ViewGroup$LayoutParams:height	I
    //   347: putfield 289	android/view/ViewGroup$LayoutParams:height	I
    //   350: aload_0
    //   351: getfield 123	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:QSe	Landroid/widget/ImageView;
    //   354: aload 8
    //   356: invokevirtual 295	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   359: aload 7
    //   361: ifnull +25 -> 386
    //   364: aload 7
    //   366: invokevirtual 300	java/lang/String:length	()I
    //   369: istore_3
    //   370: iload_3
    //   371: ifle +15 -> 386
    //   374: aload_0
    //   375: getfield 89	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:contentView	Landroid/view/View;
    //   378: aload 7
    //   380: invokestatic 306	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   383: invokevirtual 309	android/view/View:setBackgroundColor	(I)V
    //   386: aload 5
    //   388: invokestatic 315	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   391: ifeq +114 -> 505
    //   394: ldc 143
    //   396: ldc_w 317
    //   399: invokestatic 204	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   402: ldc 231
    //   404: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   407: return
    //   408: iload_3
    //   409: i2f
    //   410: fstore_1
    //   411: goto -166 -> 245
    //   414: aload 6
    //   416: aload_0
    //   417: getfield 270	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:sJv	I
    //   420: putfield 287	android/view/ViewGroup$LayoutParams:width	I
    //   423: aload 6
    //   425: aload_0
    //   426: getfield 273	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:pvg	I
    //   429: putfield 289	android/view/ViewGroup$LayoutParams:height	I
    //   432: aload_0
    //   433: iconst_1
    //   434: putfield 57	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:Flq	Z
    //   437: goto -125 -> 312
    //   440: astore 5
    //   442: ldc 143
    //   444: new 145	java/lang/StringBuilder
    //   447: dup
    //   448: ldc_w 319
    //   451: invokespecial 150	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   454: aload 5
    //   456: invokevirtual 223	java/lang/Exception:toString	()Ljava/lang/String;
    //   459: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: invokestatic 204	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   468: ldc 231
    //   470: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   473: return
    //   474: astore 7
    //   476: ldc 143
    //   478: new 145	java/lang/StringBuilder
    //   481: dup
    //   482: ldc_w 321
    //   485: invokespecial 150	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   488: aload 7
    //   490: invokevirtual 223	java/lang/Exception:toString	()Ljava/lang/String;
    //   493: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: invokestatic 204	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   502: goto -116 -> 386
    //   505: ldc 143
    //   507: new 145	java/lang/StringBuilder
    //   510: dup
    //   511: ldc_w 323
    //   514: invokespecial 150	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   517: aload_0
    //   518: getfield 57	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:Flq	Z
    //   521: invokevirtual 326	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   524: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   527: invokestatic 169	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   530: aload_0
    //   531: getfield 180	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:QSf	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a;
    //   534: aload 5
    //   536: aload 6
    //   538: getfield 287	android/view/ViewGroup$LayoutParams:width	I
    //   541: aload 6
    //   543: getfield 289	android/view/ViewGroup$LayoutParams:height	I
    //   546: ldc_w 328
    //   549: invokevirtual 332	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a:n	(Ljava/lang/String;IILjava/lang/String;)V
    //   552: ldc 231
    //   554: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   557: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	558	0	this	al
    //   107	304	1	f1	float
    //   96	183	2	f2	float
    //   237	172	3	i	int
    //   118	87	4	bool	boolean
    //   72	315	5	str1	String
    //   440	95	5	localException1	Exception
    //   190	352	6	localLayoutParams1	ViewGroup.LayoutParams
    //   84	295	7	str2	String
    //   474	15	7	localException2	Exception
    //   328	27	8	localLayoutParams2	ViewGroup.LayoutParams
    // Exception table:
    //   from	to	target	type
    //   5	26	440	java/lang/Exception
    //   26	33	440	java/lang/Exception
    //   39	56	440	java/lang/Exception
    //   62	192	440	java/lang/Exception
    //   209	238	440	java/lang/Exception
    //   245	312	440	java/lang/Exception
    //   312	359	440	java/lang/Exception
    //   364	370	440	java/lang/Exception
    //   386	402	440	java/lang/Exception
    //   414	437	440	java/lang/Exception
    //   476	502	440	java/lang/Exception
    //   505	552	440	java/lang/Exception
    //   374	386	474	java/lang/Exception
  }
  
  protected final void hal()
  {
    AppMethodBeat.i(96751);
    Object localObject = this.contentView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).setMargins((int)((v)this.QOV).paddingLeft, (int)((v)this.QOV).paddingTop, (int)((v)this.QOV).paddingRight, (int)((v)this.QOV).paddingBottom);
      this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(96751);
  }
  
  public final void hao()
  {
    AppMethodBeat.i(96755);
    super.hao();
    Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "viewWillAppear, isFirstApper=" + this.QSj);
    if (!this.QSj)
    {
      this.QSc.setSensorEnabled(true);
      if (!this.QSh)
      {
        aZz("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half");
        this.QSh = true;
      }
      this.eqE.removeMessages(1);
      this.eqE.sendEmptyMessageDelayed(1, 3000L);
      AppMethodBeat.o(96755);
      return;
    }
    this.QSj = false;
    AppMethodBeat.o(96755);
  }
  
  public final void hap()
  {
    AppMethodBeat.i(96756);
    super.hap();
    Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "viewWillDisappear, disable sensor");
    this.QSc.setSensorEnabled(false);
    AppMethodBeat.o(96756);
  }
  
  public final void has()
  {
    AppMethodBeat.i(96757);
    super.has();
    Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "viewWillDestroy, disable sensor");
    this.QSc.setSensorEnabled(false);
    AppMethodBeat.o(96757);
  }
  
  public final Bitmap hjB()
  {
    int j = 0;
    AppMethodBeat.i(96758);
    try
    {
      Bitmap localBitmap = this.QSc.getBitmap();
      StringBuilder localStringBuilder = new StringBuilder("getCurFrameBitmap, w=");
      if (localBitmap == null)
      {
        i = 0;
        localStringBuilder = localStringBuilder.append(i).append(", h=");
        if (localBitmap != null) {
          break label84;
        }
      }
      label84:
      for (int i = j;; i = localBitmap.getHeight())
      {
        Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", i);
        AppMethodBeat.o(96758);
        return localBitmap;
        i = localBitmap.getWidth();
        break;
      }
      return null;
    }
    finally
    {
      Log.e("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "getCurFrameBitmap exp:" + localObject.toString());
      AppMethodBeat.o(96758);
    }
  }
  
  public final void hjC()
  {
    AppMethodBeat.i(96759);
    if (this.QSd.getVisibility() == 0)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.QSd, "alpha", new float[] { 1.0F, 0.0F });
      localObjectAnimator.setDuration(250L);
      localObjectAnimator.start();
    }
    aZz("com.tencent.mm.adlanding.sphereimage.next_page_view_hide");
    AppMethodBeat.o(96759);
  }
  
  public final void startLoading()
  {
    AppMethodBeat.i(96753);
    this.qgC.setVisibility(0);
    AppMethodBeat.o(96753);
  }
  
  public final void stopLoading()
  {
    AppMethodBeat.i(96754);
    this.qgC.setVisibility(8);
    AppMethodBeat.o(96754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al
 * JD-Core Version:    0.7.0.1
 */