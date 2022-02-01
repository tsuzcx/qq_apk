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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import org.json.JSONObject;

public final class aj
  extends m
{
  protected boolean COc;
  protected SphereImageView EgD;
  protected View EgE;
  protected ImageView EgF;
  protected a EgG;
  int EgH;
  protected boolean EgI;
  protected SphereImageView.b EgJ;
  protected boolean EgK;
  protected MMHandler czp;
  protected ProgressBar krF;
  protected Context mContext;
  protected boolean onr;
  
  public aj(Context paramContext, u paramu, ViewGroup paramViewGroup)
  {
    super(paramContext, paramu, paramViewGroup);
    AppMethodBeat.i(96749);
    this.COc = true;
    this.onr = false;
    this.EgI = false;
    this.czp = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(96740);
        aj.this.aPZ("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_none");
        aj.this.EgI = false;
        AppMethodBeat.o(96740);
      }
    };
    this.EgJ = new SphereImageView.b()
    {
      public final void aQa(String paramAnonymousString)
      {
        final long l1 = 800L;
        AppMethodBeat.i(96748);
        Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "onUpdateImage, isFirstShow=" + aj.this.COc);
        aj.this.stopLoading();
        if (aj.this.EgF.getVisibility() == 0)
        {
          paramAnonymousString = new AlphaAnimation(1.0F, 0.0F);
          paramAnonymousString.setDuration(300L);
          paramAnonymousString.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(96741);
              aj.this.EgF.setVisibility(8);
              aj.this.EgF.setImageDrawable(null);
              aj.this.EgE.setVisibility(0);
              paramAnonymous2Animation = ObjectAnimator.ofFloat(aj.this.EgE, "alpha", new float[] { 0.0F, 1.0F });
              paramAnonymous2Animation.setDuration(400L);
              paramAnonymous2Animation.start();
              AppMethodBeat.o(96741);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation) {}
          });
          aj.this.EgF.startAnimation(paramAnonymousString);
        }
        long l2;
        if (aj.this.COc)
        {
          aj.this.COc = false;
          aj.this.czp.postDelayed(new Runnable()
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
                  aj.this.EgE.setVisibility(8);
                  aj.this.aPZ("com.tencent.mm.adlanding.sphereimage.next_page_view_show");
                  aj.this.EgI = false;
                  AppMethodBeat.o(96742);
                }
                
                public final void onAnimationRepeat(Animation paramAnonymous3Animation) {}
                
                public final void onAnimationStart(Animation paramAnonymous3Animation) {}
              });
              aj.this.EgE.startAnimation(localAlphaAnimation);
              AppMethodBeat.o(96743);
            }
          }, 2500L);
          l2 = aj.this.fdH().DWK;
          if (l2 >= 800L) {
            break label209;
          }
        }
        for (;;)
        {
          aj.this.czp.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96744);
              aj.this.EgD.feu();
              aj.this.EgD.Ejd.requestRender();
              String str = aj.this.fdH().DWL;
              if (!a.kx(str, "scene_ad_landing"))
              {
                Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "do shoot");
                a.a(aj.this.EgD, str, "scene_ad_landing");
              }
              Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "enable sensor after shoot");
              aj.this.EgD.setSensorEnabled(true);
              Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "enable touch, delay=" + l1);
              aj.this.EgD.setTouchEnabled(true);
              AppMethodBeat.o(96744);
            }
          }, l1);
          AppMethodBeat.o(96748);
          return;
          Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "enable sensor, isFirstShow=false");
          aj.this.EgD.setSensorEnabled(true);
          AppMethodBeat.o(96748);
          return;
          label209:
          l1 = l2;
        }
      }
      
      public final void fdK()
      {
        AppMethodBeat.i(96745);
        if (!aj.this.EgI)
        {
          aj.this.aPZ("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half");
          aj.this.EgI = true;
          Log.d("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "onAngleChange");
        }
        aj.this.czp.removeMessages(1);
        aj.this.czp.sendEmptyMessageDelayed(1, 3000L);
        AppMethodBeat.o(96745);
      }
      
      public final void fdL()
      {
        AppMethodBeat.i(96746);
        Log.d("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "onTouchBegin, isRoating=" + aj.this.EgI);
        if (!aj.this.EgI)
        {
          aj.this.aPZ("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half");
          aj.this.EgI = true;
        }
        aj.this.czp.removeMessages(1);
        AppMethodBeat.o(96746);
      }
      
      public final void fdM()
      {
        AppMethodBeat.i(96747);
        Log.d("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "onTouchEnd");
        aj.this.czp.removeMessages(1);
        aj.this.czp.sendEmptyMessageDelayed(1, 3000L);
        aj localaj = aj.this;
        localaj.EgH += 1;
        AppMethodBeat.o(96747);
      }
      
      public final void onDetachedFromWindow() {}
    };
    this.EgK = true;
    this.mContext = paramContext;
    AppMethodBeat.o(96749);
  }
  
  protected final void aPZ(String paramString)
  {
    AppMethodBeat.i(96760);
    ap.h(paramString, this.mContext);
    AppMethodBeat.o(96760);
  }
  
  public final boolean bp(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96761);
    if (!super.bp(paramJSONObject))
    {
      Log.e("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "setComponentKVReportData super failed");
      AppMethodBeat.o(96761);
      return false;
    }
    try
    {
      paramJSONObject.put("panCount", this.EgH);
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
  
  /* Error */
  protected final void eWT()
  {
    // Byte code:
    //   0: ldc 142
    //   2: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 145	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:contentView	Landroid/view/View;
    //   9: ifnull +17 -> 26
    //   12: aload_0
    //   13: getfield 147	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:EgD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   16: ifnull +10 -> 26
    //   19: aload_0
    //   20: getfield 149	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:krF	Landroid/widget/ProgressBar;
    //   23: ifnonnull +16 -> 39
    //   26: ldc 101
    //   28: ldc 151
    //   30: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: ldc 142
    //   35: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: return
    //   39: aload_0
    //   40: getfield 155	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:EcX	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/z;
    //   43: checkcast 157	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u
    //   46: ifnonnull +16 -> 62
    //   49: ldc 101
    //   51: ldc 159
    //   53: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: ldc 142
    //   58: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: return
    //   62: aload_0
    //   63: getfield 155	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:EcX	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/z;
    //   66: checkcast 157	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u
    //   69: getfield 163	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:DWL	Ljava/lang/String;
    //   72: astore 5
    //   74: aload_0
    //   75: getfield 155	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:EcX	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/z;
    //   78: checkcast 157	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u
    //   81: getfield 166	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:DWN	Ljava/lang/String;
    //   84: astore 7
    //   86: aload_0
    //   87: getfield 155	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:EcX	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/z;
    //   90: checkcast 157	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u
    //   93: getfield 170	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:height	F
    //   96: fstore_2
    //   97: aload_0
    //   98: getfield 155	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:EcX	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/z;
    //   101: checkcast 157	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u
    //   104: getfield 173	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:width	F
    //   107: fstore_1
    //   108: aload_0
    //   109: getfield 155	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:EcX	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/z;
    //   112: checkcast 157	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u
    //   115: getfield 176	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:DYJ	Z
    //   118: istore 4
    //   120: aload_0
    //   121: iconst_0
    //   122: putfield 57	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:onr	Z
    //   125: ldc 101
    //   127: new 121	java/lang/StringBuilder
    //   130: dup
    //   131: ldc 178
    //   133: invokespecial 125	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   136: fload_1
    //   137: invokevirtual 181	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   140: ldc 183
    //   142: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: fload_2
    //   146: invokevirtual 181	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   149: ldc 185
    //   151: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_0
    //   155: getfield 188	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:mEX	I
    //   158: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   161: ldc 183
    //   163: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload_0
    //   167: getfield 194	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:mEY	I
    //   170: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   173: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 136	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: aload_0
    //   180: getfield 147	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:EgD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   183: invokevirtual 200	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   186: astore 6
    //   188: fload_2
    //   189: fconst_0
    //   190: fcmpl
    //   191: ifeq +218 -> 409
    //   194: fload_1
    //   195: fconst_0
    //   196: fcmpl
    //   197: ifeq +212 -> 409
    //   200: iload 4
    //   202: ifne +207 -> 409
    //   205: aload_0
    //   206: getfield 188	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:mEX	I
    //   209: aload_0
    //   210: getfield 155	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:EcX	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/z;
    //   213: checkcast 157	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u
    //   216: getfield 203	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:paddingLeft	F
    //   219: f2i
    //   220: isub
    //   221: aload_0
    //   222: getfield 155	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:EcX	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/z;
    //   225: checkcast 157	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u
    //   228: getfield 206	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:paddingRight	F
    //   231: f2i
    //   232: isub
    //   233: istore_3
    //   234: fload_1
    //   235: iload_3
    //   236: i2f
    //   237: fcmpg
    //   238: ifge +165 -> 403
    //   241: fload_1
    //   242: aload_0
    //   243: getfield 155	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:EcX	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/z;
    //   246: checkcast 157	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u
    //   249: getfield 170	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:height	F
    //   252: fmul
    //   253: aload_0
    //   254: getfield 155	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:EcX	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/z;
    //   257: checkcast 157	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u
    //   260: getfield 173	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:width	F
    //   263: fdiv
    //   264: fstore_2
    //   265: aload 6
    //   267: fload_1
    //   268: f2i
    //   269: putfield 210	android/view/ViewGroup$LayoutParams:width	I
    //   272: aload 6
    //   274: fload_2
    //   275: f2i
    //   276: putfield 212	android/view/ViewGroup$LayoutParams:height	I
    //   279: aload 6
    //   281: getfield 210	android/view/ViewGroup$LayoutParams:width	I
    //   284: aload_0
    //   285: getfield 188	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:mEX	I
    //   288: if_icmplt +20 -> 308
    //   291: aload 6
    //   293: getfield 212	android/view/ViewGroup$LayoutParams:height	I
    //   296: aload_0
    //   297: getfield 194	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:mEY	I
    //   300: if_icmplt +8 -> 308
    //   303: aload_0
    //   304: iconst_1
    //   305: putfield 57	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:onr	Z
    //   308: aload_0
    //   309: getfield 147	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:EgD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   312: aload 6
    //   314: invokevirtual 216	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   317: aload_0
    //   318: getfield 218	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:EgF	Landroid/widget/ImageView;
    //   321: invokevirtual 221	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   324: astore 8
    //   326: aload 8
    //   328: aload 6
    //   330: getfield 210	android/view/ViewGroup$LayoutParams:width	I
    //   333: putfield 210	android/view/ViewGroup$LayoutParams:width	I
    //   336: aload 8
    //   338: aload 6
    //   340: getfield 212	android/view/ViewGroup$LayoutParams:height	I
    //   343: putfield 212	android/view/ViewGroup$LayoutParams:height	I
    //   346: aload_0
    //   347: getfield 218	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:EgF	Landroid/widget/ImageView;
    //   350: aload 8
    //   352: invokevirtual 222	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   355: aload 7
    //   357: ifnull +25 -> 382
    //   360: aload 7
    //   362: invokevirtual 228	java/lang/String:length	()I
    //   365: istore_3
    //   366: iload_3
    //   367: ifle +15 -> 382
    //   370: aload_0
    //   371: getfield 145	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:contentView	Landroid/view/View;
    //   374: aload 7
    //   376: invokestatic 234	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   379: invokevirtual 239	android/view/View:setBackgroundColor	(I)V
    //   382: aload 5
    //   384: invokestatic 245	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   387: ifeq +111 -> 498
    //   390: ldc 101
    //   392: ldc 247
    //   394: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   397: ldc 142
    //   399: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   402: return
    //   403: iload_3
    //   404: i2f
    //   405: fstore_1
    //   406: goto -165 -> 241
    //   409: aload 6
    //   411: aload_0
    //   412: getfield 188	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:mEX	I
    //   415: putfield 210	android/view/ViewGroup$LayoutParams:width	I
    //   418: aload 6
    //   420: aload_0
    //   421: getfield 194	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:mEY	I
    //   424: putfield 212	android/view/ViewGroup$LayoutParams:height	I
    //   427: aload_0
    //   428: iconst_1
    //   429: putfield 57	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:onr	Z
    //   432: goto -124 -> 308
    //   435: astore 5
    //   437: ldc 101
    //   439: new 121	java/lang/StringBuilder
    //   442: dup
    //   443: ldc 249
    //   445: invokespecial 125	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   448: aload 5
    //   450: invokevirtual 139	java/lang/Exception:toString	()Ljava/lang/String;
    //   453: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   462: ldc 142
    //   464: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   467: return
    //   468: astore 7
    //   470: ldc 101
    //   472: new 121	java/lang/StringBuilder
    //   475: dup
    //   476: ldc 251
    //   478: invokespecial 125	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   481: aload 7
    //   483: invokevirtual 139	java/lang/Exception:toString	()Ljava/lang/String;
    //   486: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   495: goto -113 -> 382
    //   498: ldc 101
    //   500: new 121	java/lang/StringBuilder
    //   503: dup
    //   504: ldc 253
    //   506: invokespecial 125	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   509: aload_0
    //   510: getfield 57	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:onr	Z
    //   513: invokevirtual 256	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   516: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: invokestatic 136	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   522: aload_0
    //   523: getfield 258	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:EgG	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a;
    //   526: aload 5
    //   528: aload 6
    //   530: getfield 210	android/view/ViewGroup$LayoutParams:width	I
    //   533: aload 6
    //   535: getfield 212	android/view/ViewGroup$LayoutParams:height	I
    //   538: ldc_w 260
    //   541: invokevirtual 266	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a:l	(Ljava/lang/String;IILjava/lang/String;)V
    //   544: ldc 142
    //   546: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   549: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	550	0	this	aj
    //   107	299	1	f1	float
    //   96	179	2	f2	float
    //   233	171	3	i	int
    //   118	83	4	bool	boolean
    //   72	311	5	str1	String
    //   435	92	5	localException1	Exception
    //   186	348	6	localLayoutParams1	ViewGroup.LayoutParams
    //   84	291	7	str2	String
    //   468	14	7	localException2	Exception
    //   324	27	8	localLayoutParams2	ViewGroup.LayoutParams
    // Exception table:
    //   from	to	target	type
    //   5	26	435	java/lang/Exception
    //   26	33	435	java/lang/Exception
    //   39	56	435	java/lang/Exception
    //   62	188	435	java/lang/Exception
    //   205	234	435	java/lang/Exception
    //   241	308	435	java/lang/Exception
    //   308	355	435	java/lang/Exception
    //   360	366	435	java/lang/Exception
    //   382	397	435	java/lang/Exception
    //   409	432	435	java/lang/Exception
    //   470	495	435	java/lang/Exception
    //   498	544	435	java/lang/Exception
    //   370	382	468	java/lang/Exception
  }
  
  protected final void eWX()
  {
    AppMethodBeat.i(96751);
    Object localObject = this.contentView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).setMargins((int)((u)this.EcX).paddingLeft, (int)((u)this.EcX).paddingTop, (int)((u)this.EcX).paddingRight, (int)((u)this.EcX).paddingBottom);
      this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(96751);
  }
  
  public final void eWZ()
  {
    AppMethodBeat.i(96755);
    super.eWZ();
    Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "viewWillAppear, isFirstApper=" + this.EgK);
    if (!this.EgK)
    {
      this.EgD.setSensorEnabled(true);
      if (!this.EgI)
      {
        aPZ("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half");
        this.EgI = true;
      }
      this.czp.removeMessages(1);
      this.czp.sendEmptyMessageDelayed(1, 3000L);
      AppMethodBeat.o(96755);
      return;
    }
    this.EgK = false;
    AppMethodBeat.o(96755);
  }
  
  public final void eXa()
  {
    AppMethodBeat.i(96756);
    super.eXa();
    Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "viewWillDisappear, disable sensor");
    this.EgD.setSensorEnabled(false);
    AppMethodBeat.o(96756);
  }
  
  public final void eXd()
  {
    AppMethodBeat.i(96757);
    super.eXd();
    Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "viewWillDestroy, disable sensor");
    this.EgD.setSensorEnabled(false);
    AppMethodBeat.o(96757);
  }
  
  public final void eXe()
  {
    AppMethodBeat.i(96750);
    this.EgD = ((SphereImageView)this.contentView.findViewById(2131308331));
    this.krF = ((ProgressBar)this.contentView.findViewById(2131306302));
    this.EgE = this.contentView.findViewById(2131309156);
    this.EgF = ((ImageView)this.contentView.findViewById(2131304506));
    this.EgD.setEventListener(this.EgJ);
    this.EgD.an(2.0F, -4.0F);
    this.EgD.setTouchSensitivity(0.35F);
    this.EgD.setSensorEnabled(false);
    Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "createView, hash=" + this.EgD.hashCode());
    this.EgD.setTouchEnabled(false);
    Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "disable touch init");
    this.EgG = new a();
    this.EgG.a(new a.d()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString1, Bitmap paramAnonymousBitmap, String paramAnonymousString2)
      {
        AppMethodBeat.i(96739);
        Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "ImageLoader onFinish, isSucc=" + paramAnonymousBoolean + ", errInfo=" + paramAnonymousString1);
        aj.this.EgD.g(paramAnonymousBitmap, paramAnonymousString2);
        if (!paramAnonymousBoolean) {
          aj.this.stopLoading();
        }
        AppMethodBeat.o(96739);
      }
      
      public final void onStart(String paramAnonymousString)
      {
        AppMethodBeat.i(96738);
        Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "ImageLoader onStart");
        paramAnonymousString = a.kw(paramAnonymousString, "scene_ad_landing");
        if (paramAnonymousString != null)
        {
          aj.this.EgF.setImageBitmap(paramAnonymousString);
          aj.this.EgF.setVisibility(0);
          AppMethodBeat.o(96738);
          return;
        }
        aj.this.startLoading();
        AppMethodBeat.o(96738);
      }
    });
    AppMethodBeat.o(96750);
  }
  
  public final u fdH()
  {
    return (u)this.EcX;
  }
  
  public final Bitmap fdI()
  {
    int j = 0;
    AppMethodBeat.i(96758);
    try
    {
      Bitmap localBitmap = this.EgD.getBitmap();
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
        Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", i);
        AppMethodBeat.o(96758);
        return localBitmap;
        i = localBitmap.getWidth();
        break;
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "getCurFrameBitmap exp:" + localThrowable.toString());
      AppMethodBeat.o(96758);
    }
  }
  
  public final void fdJ()
  {
    AppMethodBeat.i(96759);
    if (this.EgE.getVisibility() == 0)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.EgE, "alpha", new float[] { 1.0F, 0.0F });
      localObjectAnimator.setDuration(250L);
      localObjectAnimator.start();
    }
    aPZ("com.tencent.mm.adlanding.sphereimage.next_page_view_hide");
    AppMethodBeat.o(96759);
  }
  
  protected final int getLayout()
  {
    return 2131496395;
  }
  
  public final void startLoading()
  {
    AppMethodBeat.i(96753);
    this.krF.setVisibility(0);
    AppMethodBeat.o(96753);
  }
  
  public final void stopLoading()
  {
    AppMethodBeat.i(96754);
    this.krF.setVisibility(8);
    AppMethodBeat.o(96754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aj
 * JD-Core Version:    0.7.0.1
 */