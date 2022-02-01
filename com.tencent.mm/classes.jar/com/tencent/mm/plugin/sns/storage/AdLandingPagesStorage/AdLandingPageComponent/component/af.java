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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import org.json.JSONObject;

public final class af
  extends k
{
  protected ao gqT;
  protected ProgressBar iXo;
  protected Context mContext;
  protected boolean mwy;
  protected boolean xgn;
  protected SphereImageView ypX;
  protected View ypY;
  protected ImageView ypZ;
  protected a yqa;
  int yqb;
  protected boolean yqc;
  protected SphereImageView.b yqd;
  protected boolean yqe;
  
  public af(Context paramContext, t paramt, ViewGroup paramViewGroup)
  {
    super(paramContext, paramt, paramViewGroup);
    AppMethodBeat.i(96749);
    this.xgn = true;
    this.mwy = false;
    this.yqc = false;
    this.gqT = new ao(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(96740);
        af.this.auH("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_none");
        af.this.yqc = false;
        AppMethodBeat.o(96740);
      }
    };
    this.yqd = new SphereImageView.b()
    {
      public final void auI(String paramAnonymousString)
      {
        final long l1 = 800L;
        AppMethodBeat.i(96748);
        ac.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "onUpdateImage, isFirstShow=" + af.this.xgn);
        af.this.stopLoading();
        if (af.this.ypZ.getVisibility() == 0)
        {
          paramAnonymousString = new AlphaAnimation(1.0F, 0.0F);
          paramAnonymousString.setDuration(300L);
          paramAnonymousString.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(96741);
              af.this.ypZ.setVisibility(8);
              af.this.ypZ.setImageDrawable(null);
              af.this.ypY.setVisibility(0);
              paramAnonymous2Animation = ObjectAnimator.ofFloat(af.this.ypY, "alpha", new float[] { 0.0F, 1.0F });
              paramAnonymous2Animation.setDuration(400L);
              paramAnonymous2Animation.start();
              AppMethodBeat.o(96741);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation) {}
          });
          af.this.ypZ.startAnimation(paramAnonymousString);
        }
        long l2;
        if (af.this.xgn)
        {
          af.this.xgn = false;
          af.this.gqT.postDelayed(new Runnable()
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
                  ac.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "hide rollTipView");
                  af.this.ypY.setVisibility(8);
                  af.this.auH("com.tencent.mm.adlanding.sphereimage.next_page_view_show");
                  af.this.yqc = false;
                  AppMethodBeat.o(96742);
                }
                
                public final void onAnimationRepeat(Animation paramAnonymous3Animation) {}
                
                public final void onAnimationStart(Animation paramAnonymous3Animation) {}
              });
              af.this.ypY.startAnimation(localAlphaAnimation);
              AppMethodBeat.o(96743);
            }
          }, 2500L);
          l2 = af.this.dKX().yhn;
          if (l2 >= 800L) {
            break label209;
          }
        }
        for (;;)
        {
          af.this.gqT.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96744);
              af.this.ypX.dLJ();
              af.this.ypX.ysx.requestRender();
              String str = af.this.dKX().yho;
              if (!a.jq(str, "scene_ad_landing"))
              {
                ac.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "do shoot");
                a.a(af.this.ypX, str, "scene_ad_landing");
              }
              ac.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "enable sensor after shoot");
              af.this.ypX.setSensorEnabled(true);
              ac.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "enable touch, delay=" + l1);
              af.this.ypX.setTouchEnabled(true);
              AppMethodBeat.o(96744);
            }
          }, l1);
          AppMethodBeat.o(96748);
          return;
          ac.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "enable sensor, isFirstShow=false");
          af.this.ypX.setSensorEnabled(true);
          AppMethodBeat.o(96748);
          return;
          label209:
          l1 = l2;
        }
      }
      
      public final void dLa()
      {
        AppMethodBeat.i(96745);
        if (!af.this.yqc)
        {
          af.this.auH("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half");
          af.this.yqc = true;
          ac.d("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "onAngleChange");
        }
        af.this.gqT.removeMessages(1);
        af.this.gqT.sendEmptyMessageDelayed(1, 3000L);
        AppMethodBeat.o(96745);
      }
      
      public final void dLb()
      {
        AppMethodBeat.i(96746);
        ac.d("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "onTouchBegin, isRoating=" + af.this.yqc);
        if (!af.this.yqc)
        {
          af.this.auH("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half");
          af.this.yqc = true;
        }
        af.this.gqT.removeMessages(1);
        AppMethodBeat.o(96746);
      }
      
      public final void dLc()
      {
        AppMethodBeat.i(96747);
        ac.d("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "onTouchEnd");
        af.this.gqT.removeMessages(1);
        af.this.gqT.sendEmptyMessageDelayed(1, 3000L);
        af localaf = af.this;
        localaf.yqb += 1;
        AppMethodBeat.o(96747);
      }
      
      public final void onDetachedFromWindow() {}
    };
    this.yqe = true;
    this.mContext = paramContext;
    AppMethodBeat.o(96749);
  }
  
  public final boolean aH(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96761);
    if (!super.aH(paramJSONObject))
    {
      ac.e("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "setComponentKVReportData super failed");
      AppMethodBeat.o(96761);
      return false;
    }
    try
    {
      paramJSONObject.put("panCount", this.yqb);
      ac.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "setComponentKVReportData json=" + paramJSONObject.toString());
      AppMethodBeat.o(96761);
      return true;
    }
    catch (Exception paramJSONObject)
    {
      ac.e("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "setComponentKVReportData exp=" + paramJSONObject.toString());
      AppMethodBeat.o(96761);
    }
    return false;
  }
  
  protected final void auH(String paramString)
  {
    AppMethodBeat.i(96760);
    al.f(paramString, this.mContext);
    AppMethodBeat.o(96760);
  }
  
  public final void dJW()
  {
    AppMethodBeat.i(96750);
    this.ypX = ((SphereImageView)this.contentView.findViewById(2131305149));
    this.iXo = ((ProgressBar)this.contentView.findViewById(2131303535));
    this.ypY = this.contentView.findViewById(2131305874);
    this.ypZ = ((ImageView)this.contentView.findViewById(2131302164));
    this.ypX.setEventListener(this.yqd);
    this.ypX.ab(2.0F, -4.0F);
    this.ypX.setTouchSensitivity(0.35F);
    this.ypX.setSensorEnabled(false);
    ac.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "createView, hash=" + this.ypX.hashCode());
    this.ypX.setTouchEnabled(false);
    ac.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "disable touch init");
    this.yqa = new a();
    this.yqa.a(new a.d()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString1, Bitmap paramAnonymousBitmap, String paramAnonymousString2)
      {
        AppMethodBeat.i(96739);
        ac.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "ImageLoader onFinish, isSucc=" + paramAnonymousBoolean + ", errInfo=" + paramAnonymousString1);
        af.this.ypX.g(paramAnonymousBitmap, paramAnonymousString2);
        if (!paramAnonymousBoolean) {
          af.this.stopLoading();
        }
        AppMethodBeat.o(96739);
      }
      
      public final void onStart(String paramAnonymousString)
      {
        AppMethodBeat.i(96738);
        ac.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "ImageLoader onStart");
        paramAnonymousString = a.jp(paramAnonymousString, "scene_ad_landing");
        if (paramAnonymousString != null)
        {
          af.this.ypZ.setImageBitmap(paramAnonymousString);
          af.this.ypZ.setVisibility(0);
          AppMethodBeat.o(96738);
          return;
        }
        af.this.startLoading();
        AppMethodBeat.o(96738);
      }
    });
    AppMethodBeat.o(96750);
  }
  
  public final void dJX()
  {
    AppMethodBeat.i(96757);
    super.dJX();
    ac.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "viewWillDestroy, disable sensor");
    this.ypX.setSensorEnabled(false);
    AppMethodBeat.o(96757);
  }
  
  public final void dJY()
  {
    AppMethodBeat.i(96755);
    super.dJY();
    ac.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "viewWillAppear, isFirstApper=" + this.yqe);
    if (!this.yqe)
    {
      this.ypX.setSensorEnabled(true);
      if (!this.yqc)
      {
        auH("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half");
        this.yqc = true;
      }
      this.gqT.removeMessages(1);
      this.gqT.sendEmptyMessageDelayed(1, 3000L);
      AppMethodBeat.o(96755);
      return;
    }
    this.yqe = false;
    AppMethodBeat.o(96755);
  }
  
  public final void dJZ()
  {
    AppMethodBeat.i(96756);
    super.dJZ();
    ac.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "viewWillDisappear, disable sensor");
    this.ypX.setSensorEnabled(false);
    AppMethodBeat.o(96756);
  }
  
  public final t dKX()
  {
    return (t)this.ymQ;
  }
  
  public final Bitmap dKY()
  {
    int j = 0;
    AppMethodBeat.i(96758);
    try
    {
      Bitmap localBitmap = this.ypX.getBitmap();
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
        ac.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", i);
        AppMethodBeat.o(96758);
        return localBitmap;
        i = localBitmap.getWidth();
        break;
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      ac.e("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "getCurFrameBitmap exp:" + localThrowable.toString());
      AppMethodBeat.o(96758);
    }
  }
  
  public final void dKZ()
  {
    AppMethodBeat.i(96759);
    if (this.ypY.getVisibility() == 0)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.ypY, "alpha", new float[] { 1.0F, 0.0F });
      localObjectAnimator.setDuration(250L);
      localObjectAnimator.start();
    }
    auH("com.tencent.mm.adlanding.sphereimage.next_page_view_hide");
    AppMethodBeat.o(96759);
  }
  
  /* Error */
  protected final void dKm()
  {
    // Byte code:
    //   0: ldc_w 307
    //   3: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 145	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af:contentView	Landroid/view/View;
    //   10: ifnull +17 -> 27
    //   13: aload_0
    //   14: getfield 156	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af:ypX	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   17: ifnull +10 -> 27
    //   20: aload_0
    //   21: getfield 161	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af:iXo	Landroid/widget/ProgressBar;
    //   24: ifnonnull +18 -> 42
    //   27: ldc 92
    //   29: ldc_w 309
    //   32: invokestatic 100	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: ldc_w 307
    //   38: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: return
    //   42: aload_0
    //   43: getfield 256	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af:ymQ	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/x;
    //   46: checkcast 258	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t
    //   49: ifnonnull +18 -> 67
    //   52: ldc 92
    //   54: ldc_w 311
    //   57: invokestatic 100	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: ldc_w 307
    //   63: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: return
    //   67: aload_0
    //   68: getfield 256	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af:ymQ	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/x;
    //   71: checkcast 258	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t
    //   74: getfield 315	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t:yho	Ljava/lang/String;
    //   77: astore 5
    //   79: aload_0
    //   80: getfield 256	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af:ymQ	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/x;
    //   83: checkcast 258	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t
    //   86: getfield 318	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t:yhq	Ljava/lang/String;
    //   89: astore 7
    //   91: aload_0
    //   92: getfield 256	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af:ymQ	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/x;
    //   95: checkcast 258	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t
    //   98: getfield 322	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t:height	F
    //   101: fstore_2
    //   102: aload_0
    //   103: getfield 256	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af:ymQ	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/x;
    //   106: checkcast 258	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t
    //   109: getfield 325	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t:width	F
    //   112: fstore_1
    //   113: aload_0
    //   114: getfield 256	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af:ymQ	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/x;
    //   117: checkcast 258	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t
    //   120: getfield 328	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t:yjc	Z
    //   123: istore 4
    //   125: aload_0
    //   126: iconst_0
    //   127: putfield 57	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af:mwy	Z
    //   130: ldc 92
    //   132: new 112	java/lang/StringBuilder
    //   135: dup
    //   136: ldc_w 330
    //   139: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   142: fload_1
    //   143: invokevirtual 333	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   146: ldc_w 270
    //   149: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: fload_2
    //   153: invokevirtual 333	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   156: ldc_w 335
    //   159: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_0
    //   163: getfield 338	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af:kWB	I
    //   166: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   169: ldc_w 270
    //   172: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_0
    //   176: getfield 341	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af:kWC	I
    //   179: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   182: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 128	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: aload_0
    //   189: getfield 156	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af:ypX	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   192: invokevirtual 345	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   195: astore 6
    //   197: fload_2
    //   198: fconst_0
    //   199: fcmpl
    //   200: ifeq +220 -> 420
    //   203: fload_1
    //   204: fconst_0
    //   205: fcmpl
    //   206: ifeq +214 -> 420
    //   209: iload 4
    //   211: ifne +209 -> 420
    //   214: aload_0
    //   215: getfield 338	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af:kWB	I
    //   218: aload_0
    //   219: getfield 256	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af:ymQ	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/x;
    //   222: checkcast 258	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t
    //   225: getfield 348	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t:paddingLeft	F
    //   228: f2i
    //   229: isub
    //   230: aload_0
    //   231: getfield 256	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af:ymQ	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/x;
    //   234: checkcast 258	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t
    //   237: getfield 351	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t:paddingRight	F
    //   240: f2i
    //   241: isub
    //   242: istore_3
    //   243: fload_1
    //   244: iload_3
    //   245: i2f
    //   246: fcmpg
    //   247: ifge +167 -> 414
    //   250: fload_1
    //   251: aload_0
    //   252: getfield 256	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af:ymQ	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/x;
    //   255: checkcast 258	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t
    //   258: getfield 322	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t:height	F
    //   261: fmul
    //   262: aload_0
    //   263: getfield 256	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af:ymQ	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/x;
    //   266: checkcast 258	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t
    //   269: getfield 325	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t:width	F
    //   272: fdiv
    //   273: fstore_2
    //   274: aload 6
    //   276: fload_1
    //   277: f2i
    //   278: putfield 355	android/view/ViewGroup$LayoutParams:width	I
    //   281: aload 6
    //   283: fload_2
    //   284: f2i
    //   285: putfield 357	android/view/ViewGroup$LayoutParams:height	I
    //   288: aload 6
    //   290: getfield 355	android/view/ViewGroup$LayoutParams:width	I
    //   293: aload_0
    //   294: getfield 338	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af:kWB	I
    //   297: if_icmplt +20 -> 317
    //   300: aload 6
    //   302: getfield 357	android/view/ViewGroup$LayoutParams:height	I
    //   305: aload_0
    //   306: getfield 341	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af:kWC	I
    //   309: if_icmplt +8 -> 317
    //   312: aload_0
    //   313: iconst_1
    //   314: putfield 57	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af:mwy	Z
    //   317: aload_0
    //   318: getfield 156	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af:ypX	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   321: aload 6
    //   323: invokevirtual 361	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   326: aload_0
    //   327: getfield 169	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af:ypZ	Landroid/widget/ImageView;
    //   330: invokevirtual 362	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   333: astore 8
    //   335: aload 8
    //   337: aload 6
    //   339: getfield 355	android/view/ViewGroup$LayoutParams:width	I
    //   342: putfield 355	android/view/ViewGroup$LayoutParams:width	I
    //   345: aload 8
    //   347: aload 6
    //   349: getfield 357	android/view/ViewGroup$LayoutParams:height	I
    //   352: putfield 357	android/view/ViewGroup$LayoutParams:height	I
    //   355: aload_0
    //   356: getfield 169	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af:ypZ	Landroid/widget/ImageView;
    //   359: aload 8
    //   361: invokevirtual 363	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   364: aload 7
    //   366: ifnull +25 -> 391
    //   369: aload 7
    //   371: invokevirtual 368	java/lang/String:length	()I
    //   374: istore_3
    //   375: iload_3
    //   376: ifle +15 -> 391
    //   379: aload_0
    //   380: getfield 145	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af:contentView	Landroid/view/View;
    //   383: aload 7
    //   385: invokestatic 374	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   388: invokevirtual 377	android/view/View:setBackgroundColor	(I)V
    //   391: aload 5
    //   393: invokestatic 383	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   396: ifeq +116 -> 512
    //   399: ldc 92
    //   401: ldc_w 385
    //   404: invokestatic 100	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   407: ldc_w 307
    //   410: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   413: return
    //   414: iload_3
    //   415: i2f
    //   416: fstore_1
    //   417: goto -167 -> 250
    //   420: aload 6
    //   422: aload_0
    //   423: getfield 338	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af:kWB	I
    //   426: putfield 355	android/view/ViewGroup$LayoutParams:width	I
    //   429: aload 6
    //   431: aload_0
    //   432: getfield 341	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af:kWC	I
    //   435: putfield 357	android/view/ViewGroup$LayoutParams:height	I
    //   438: aload_0
    //   439: iconst_1
    //   440: putfield 57	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af:mwy	Z
    //   443: goto -126 -> 317
    //   446: astore 5
    //   448: ldc 92
    //   450: new 112	java/lang/StringBuilder
    //   453: dup
    //   454: ldc_w 387
    //   457: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   460: aload 5
    //   462: invokevirtual 131	java/lang/Exception:toString	()Ljava/lang/String;
    //   465: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   471: invokestatic 100	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   474: ldc_w 307
    //   477: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   480: return
    //   481: astore 7
    //   483: ldc 92
    //   485: new 112	java/lang/StringBuilder
    //   488: dup
    //   489: ldc_w 389
    //   492: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   495: aload 7
    //   497: invokevirtual 131	java/lang/Exception:toString	()Ljava/lang/String;
    //   500: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   506: invokestatic 100	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   509: goto -118 -> 391
    //   512: ldc 92
    //   514: new 112	java/lang/StringBuilder
    //   517: dup
    //   518: ldc_w 391
    //   521: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   524: aload_0
    //   525: getfield 57	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af:mwy	Z
    //   528: invokevirtual 229	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   531: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   534: invokestatic 128	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   537: aload_0
    //   538: getfield 209	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af:yqa	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a;
    //   541: aload 5
    //   543: aload 6
    //   545: getfield 355	android/view/ViewGroup$LayoutParams:width	I
    //   548: aload 6
    //   550: getfield 357	android/view/ViewGroup$LayoutParams:height	I
    //   553: ldc_w 393
    //   556: invokevirtual 397	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a:k	(Ljava/lang/String;IILjava/lang/String;)V
    //   559: ldc_w 307
    //   562: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   565: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	566	0	this	af
    //   112	305	1	f1	float
    //   101	183	2	f2	float
    //   242	173	3	i	int
    //   123	87	4	bool	boolean
    //   77	315	5	str1	String
    //   446	96	5	localException1	Exception
    //   195	354	6	localLayoutParams1	ViewGroup.LayoutParams
    //   89	295	7	str2	String
    //   481	15	7	localException2	Exception
    //   333	27	8	localLayoutParams2	ViewGroup.LayoutParams
    // Exception table:
    //   from	to	target	type
    //   6	27	446	java/lang/Exception
    //   27	35	446	java/lang/Exception
    //   42	60	446	java/lang/Exception
    //   67	197	446	java/lang/Exception
    //   214	243	446	java/lang/Exception
    //   250	317	446	java/lang/Exception
    //   317	364	446	java/lang/Exception
    //   369	375	446	java/lang/Exception
    //   391	407	446	java/lang/Exception
    //   420	443	446	java/lang/Exception
    //   483	509	446	java/lang/Exception
    //   512	559	446	java/lang/Exception
    //   379	391	481	java/lang/Exception
  }
  
  protected final void dKs()
  {
    AppMethodBeat.i(96751);
    Object localObject = this.contentView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).setMargins((int)((t)this.ymQ).paddingLeft, (int)((t)this.ymQ).paddingTop, (int)((t)this.ymQ).paddingRight, (int)((t)this.ymQ).paddingBottom);
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
    this.iXo.setVisibility(0);
    AppMethodBeat.o(96753);
  }
  
  public final void stopLoading()
  {
    AppMethodBeat.i(96754);
    this.iXo.setVisibility(8);
    AppMethodBeat.o(96754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.af
 * JD-Core Version:    0.7.0.1
 */