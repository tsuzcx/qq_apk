package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import org.json.JSONObject;

public final class y
  extends h
{
  protected ProgressBar gJE;
  protected boolean jew;
  protected ak loX;
  protected Context mContext;
  protected boolean qBd;
  protected SphereImageView rxI;
  protected View rxJ;
  protected ImageView rxK;
  protected a rxL;
  int rxM;
  protected boolean rxN;
  protected SphereImageView.b rxO;
  protected boolean rxP;
  
  public y(Context paramContext, p paramp, ViewGroup paramViewGroup)
  {
    super(paramContext, paramp, paramViewGroup);
    AppMethodBeat.i(145314);
    this.qBd = true;
    this.jew = false;
    this.rxN = false;
    this.loX = new y.2(this, Looper.getMainLooper());
    this.rxO = new SphereImageView.b()
    {
      public final void abk(String paramAnonymousString)
      {
        long l1 = 800L;
        AppMethodBeat.i(145313);
        ab.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "onUpdateImage, isFirstShow=" + y.this.qBd);
        y.this.stopLoading();
        if (y.this.rxK.getVisibility() == 0)
        {
          paramAnonymousString = new AlphaAnimation(1.0F, 0.0F);
          paramAnonymousString.setDuration(300L);
          paramAnonymousString.setAnimationListener(new y.3.1(this));
          y.this.rxK.startAnimation(paramAnonymousString);
        }
        long l2;
        if (y.this.qBd)
        {
          y.this.qBd = false;
          y.this.loX.postDelayed(new y.3.2(this), 2500L);
          l2 = y.this.crs().rre;
          if (l2 >= 800L) {
            break label209;
          }
        }
        for (;;)
        {
          y.this.loX.postDelayed(new y.3.3(this, l1), l1);
          AppMethodBeat.o(145313);
          return;
          ab.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "enable sensor, isFirstShow=false");
          y.this.rxI.setSensorEnabled(true);
          AppMethodBeat.o(145313);
          return;
          label209:
          l1 = l2;
        }
      }
      
      public final void crv()
      {
        AppMethodBeat.i(145310);
        if (!y.this.rxN)
        {
          y.this.abj("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half");
          y.this.rxN = true;
          ab.d("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "onAngleChange");
        }
        y.this.loX.removeMessages(1);
        y.this.loX.sendEmptyMessageDelayed(1, 3000L);
        AppMethodBeat.o(145310);
      }
      
      public final void crw()
      {
        AppMethodBeat.i(145311);
        ab.d("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "onTouchBegin, isRoating=" + y.this.rxN);
        if (!y.this.rxN)
        {
          y.this.abj("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half");
          y.this.rxN = true;
        }
        y.this.loX.removeMessages(1);
        AppMethodBeat.o(145311);
      }
      
      public final void crx()
      {
        AppMethodBeat.i(145312);
        ab.d("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "onTouchEnd");
        y.this.loX.removeMessages(1);
        y.this.loX.sendEmptyMessageDelayed(1, 3000L);
        y localy = y.this;
        localy.rxM += 1;
        AppMethodBeat.o(145312);
      }
      
      public final void onDetachedFromWindow() {}
    };
    this.rxP = true;
    this.mContext = paramContext;
    AppMethodBeat.o(145314);
  }
  
  protected final void abj(String paramString)
  {
    AppMethodBeat.i(145325);
    ae.g(paramString, this.mContext);
    AppMethodBeat.o(145325);
  }
  
  public final boolean aq(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145326);
    if (!super.aq(paramJSONObject))
    {
      ab.e("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "setComponentKVReportData super failed");
      AppMethodBeat.o(145326);
      return false;
    }
    try
    {
      paramJSONObject.put("panCount", this.rxM);
      ab.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "setComponentKVReportData json=" + paramJSONObject.toString());
      AppMethodBeat.o(145326);
      return true;
    }
    catch (Exception paramJSONObject)
    {
      ab.e("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "setComponentKVReportData exp=" + paramJSONObject.toString());
      AppMethodBeat.o(145326);
    }
    return false;
  }
  
  public final void cqA()
  {
    AppMethodBeat.i(145320);
    super.cqA();
    ab.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "viewWillAppear, isFirstApper=" + this.rxP);
    if (!this.rxP)
    {
      this.rxI.setSensorEnabled(true);
      if (!this.rxN)
      {
        abj("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half");
        this.rxN = true;
      }
      this.loX.removeMessages(1);
      this.loX.sendEmptyMessageDelayed(1, 3000L);
      AppMethodBeat.o(145320);
      return;
    }
    this.rxP = false;
    AppMethodBeat.o(145320);
  }
  
  public final void cqB()
  {
    AppMethodBeat.i(145321);
    super.cqB();
    ab.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "viewWillDisappear, disable sensor");
    this.rxI.setSensorEnabled(false);
    AppMethodBeat.o(145321);
  }
  
  public final void cqK()
  {
    AppMethodBeat.i(145315);
    this.rxI = ((SphereImageView)this.contentView.findViewById(2131827869));
    this.gJE = ((ProgressBar)this.contentView.findViewById(2131821246));
    this.rxJ = this.contentView.findViewById(2131827679);
    this.rxK = ((ImageView)this.contentView.findViewById(2131827870));
    this.rxI.setEventListener(this.rxO);
    this.rxI.ad(2.0F, -4.0F);
    this.rxI.setTouchSensitivity(0.35F);
    this.rxI.setSensorEnabled(false);
    ab.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "createView, hash=" + this.rxI.hashCode());
    this.rxI.setTouchEnabled(false);
    ab.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "disable touch init");
    this.rxL = new a();
    this.rxL.a(new y.1(this));
    AppMethodBeat.o(145315);
  }
  
  /* Error */
  protected final void cqP()
  {
    // Byte code:
    //   0: ldc 238
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 173	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/y:contentView	Landroid/view/View;
    //   9: ifnull +17 -> 26
    //   12: aload_0
    //   13: getfield 141	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/y:rxI	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   16: ifnull +10 -> 26
    //   19: aload_0
    //   20: getfield 185	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/y:gJE	Landroid/widget/ProgressBar;
    //   23: ifnonnull +16 -> 39
    //   26: ldc 91
    //   28: ldc 240
    //   30: invokestatic 99	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: ldc 238
    //   35: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: return
    //   39: aload_0
    //   40: getfield 244	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/y:rve	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t;
    //   43: checkcast 246	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/p
    //   46: ifnonnull +16 -> 62
    //   49: ldc 91
    //   51: ldc 248
    //   53: invokestatic 99	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: ldc 238
    //   58: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: return
    //   62: aload_0
    //   63: getfield 244	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/y:rve	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t;
    //   66: checkcast 246	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/p
    //   69: getfield 252	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/p:rrf	Ljava/lang/String;
    //   72: astore 5
    //   74: aload_0
    //   75: getfield 244	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/y:rve	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t;
    //   78: checkcast 246	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/p
    //   81: getfield 255	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/p:rrh	Ljava/lang/String;
    //   84: astore 7
    //   86: aload_0
    //   87: getfield 244	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/y:rve	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t;
    //   90: checkcast 246	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/p
    //   93: getfield 259	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/p:height	F
    //   96: fstore_2
    //   97: aload_0
    //   98: getfield 244	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/y:rve	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t;
    //   101: checkcast 246	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/p
    //   104: getfield 262	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/p:width	F
    //   107: fstore_1
    //   108: aload_0
    //   109: getfield 244	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/y:rve	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t;
    //   112: checkcast 246	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/p
    //   115: getfield 265	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/p:rsv	Z
    //   118: istore 4
    //   120: aload_0
    //   121: iconst_0
    //   122: putfield 45	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/y:jew	Z
    //   125: ldc 91
    //   127: new 111	java/lang/StringBuilder
    //   130: dup
    //   131: ldc_w 267
    //   134: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   137: fload_1
    //   138: invokevirtual 270	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   141: ldc_w 272
    //   144: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: fload_2
    //   148: invokevirtual 270	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   151: ldc_w 274
    //   154: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_0
    //   158: getfield 277	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/y:iiW	I
    //   161: invokevirtual 218	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   164: ldc_w 272
    //   167: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload_0
    //   171: getfield 280	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/y:iiX	I
    //   174: invokevirtual 218	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   177: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 126	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: aload_0
    //   184: getfield 141	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/y:rxI	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   187: invokevirtual 284	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
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
    //   210: getfield 277	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/y:iiW	I
    //   213: aload_0
    //   214: getfield 244	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/y:rve	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t;
    //   217: checkcast 246	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/p
    //   220: getfield 287	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/p:paddingLeft	F
    //   223: f2i
    //   224: isub
    //   225: aload_0
    //   226: getfield 244	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/y:rve	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t;
    //   229: checkcast 246	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/p
    //   232: getfield 290	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/p:paddingRight	F
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
    //   247: getfield 244	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/y:rve	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t;
    //   250: checkcast 246	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/p
    //   253: getfield 259	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/p:height	F
    //   256: fmul
    //   257: aload_0
    //   258: getfield 244	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/y:rve	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/t;
    //   261: checkcast 246	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/p
    //   264: getfield 262	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/p:width	F
    //   267: fdiv
    //   268: fstore_2
    //   269: aload 6
    //   271: fload_1
    //   272: f2i
    //   273: putfield 294	android/view/ViewGroup$LayoutParams:width	I
    //   276: aload 6
    //   278: fload_2
    //   279: f2i
    //   280: putfield 296	android/view/ViewGroup$LayoutParams:height	I
    //   283: aload 6
    //   285: getfield 294	android/view/ViewGroup$LayoutParams:width	I
    //   288: aload_0
    //   289: getfield 277	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/y:iiW	I
    //   292: if_icmplt +20 -> 312
    //   295: aload 6
    //   297: getfield 296	android/view/ViewGroup$LayoutParams:height	I
    //   300: aload_0
    //   301: getfield 280	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/y:iiX	I
    //   304: if_icmplt +8 -> 312
    //   307: aload_0
    //   308: iconst_1
    //   309: putfield 45	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/y:jew	Z
    //   312: aload_0
    //   313: getfield 141	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/y:rxI	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   316: aload 6
    //   318: invokevirtual 300	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   321: aload_0
    //   322: getfield 193	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/y:rxK	Landroid/widget/ImageView;
    //   325: invokevirtual 301	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   328: astore 8
    //   330: aload 8
    //   332: aload 6
    //   334: getfield 294	android/view/ViewGroup$LayoutParams:width	I
    //   337: putfield 294	android/view/ViewGroup$LayoutParams:width	I
    //   340: aload 8
    //   342: aload 6
    //   344: getfield 296	android/view/ViewGroup$LayoutParams:height	I
    //   347: putfield 296	android/view/ViewGroup$LayoutParams:height	I
    //   350: aload_0
    //   351: getfield 193	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/y:rxK	Landroid/widget/ImageView;
    //   354: aload 8
    //   356: invokevirtual 302	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   359: aload 7
    //   361: ifnull +25 -> 386
    //   364: aload 7
    //   366: invokevirtual 307	java/lang/String:length	()I
    //   369: istore_3
    //   370: iload_3
    //   371: ifle +15 -> 386
    //   374: aload_0
    //   375: getfield 173	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/y:contentView	Landroid/view/View;
    //   378: aload 7
    //   380: invokestatic 313	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   383: invokevirtual 316	android/view/View:setBackgroundColor	(I)V
    //   386: aload 5
    //   388: invokestatic 322	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   391: ifeq +114 -> 505
    //   394: ldc 91
    //   396: ldc_w 324
    //   399: invokestatic 99	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   402: ldc 238
    //   404: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   407: return
    //   408: iload_3
    //   409: i2f
    //   410: fstore_1
    //   411: goto -166 -> 245
    //   414: aload 6
    //   416: aload_0
    //   417: getfield 277	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/y:iiW	I
    //   420: putfield 294	android/view/ViewGroup$LayoutParams:width	I
    //   423: aload 6
    //   425: aload_0
    //   426: getfield 280	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/y:iiX	I
    //   429: putfield 296	android/view/ViewGroup$LayoutParams:height	I
    //   432: aload_0
    //   433: iconst_1
    //   434: putfield 45	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/y:jew	Z
    //   437: goto -125 -> 312
    //   440: astore 5
    //   442: ldc 91
    //   444: new 111	java/lang/StringBuilder
    //   447: dup
    //   448: ldc_w 326
    //   451: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   454: aload 5
    //   456: invokevirtual 129	java/lang/Exception:toString	()Ljava/lang/String;
    //   459: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: invokestatic 99	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   468: ldc 238
    //   470: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   473: return
    //   474: astore 7
    //   476: ldc 91
    //   478: new 111	java/lang/StringBuilder
    //   481: dup
    //   482: ldc_w 328
    //   485: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   488: aload 7
    //   490: invokevirtual 129	java/lang/Exception:toString	()Ljava/lang/String;
    //   493: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: invokestatic 99	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   502: goto -116 -> 386
    //   505: ldc 91
    //   507: new 111	java/lang/StringBuilder
    //   510: dup
    //   511: ldc_w 330
    //   514: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   517: aload_0
    //   518: getfield 45	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/y:jew	Z
    //   521: invokevirtual 139	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   524: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   527: invokestatic 126	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   530: aload_0
    //   531: getfield 229	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/y:rxL	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a;
    //   534: aload 5
    //   536: aload 6
    //   538: getfield 294	android/view/ViewGroup$LayoutParams:width	I
    //   541: aload 6
    //   543: getfield 296	android/view/ViewGroup$LayoutParams:height	I
    //   546: ldc_w 332
    //   549: invokevirtual 336	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a:j	(Ljava/lang/String;IILjava/lang/String;)V
    //   552: ldc 238
    //   554: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   557: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	558	0	this	y
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
  
  protected final void cqQ()
  {
    AppMethodBeat.i(145316);
    Object localObject = this.contentView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).setMargins((int)((p)this.rve).paddingLeft, (int)((p)this.rve).paddingTop, (int)((p)this.rve).paddingRight, (int)((p)this.rve).paddingBottom);
      this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(145316);
  }
  
  public final void cqz()
  {
    AppMethodBeat.i(145322);
    super.cqz();
    ab.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "viewWillDestroy, disable sensor");
    this.rxI.setSensorEnabled(false);
    AppMethodBeat.o(145322);
  }
  
  public final p crs()
  {
    return (p)this.rve;
  }
  
  public final Bitmap crt()
  {
    int j = 0;
    AppMethodBeat.i(145323);
    try
    {
      Bitmap localBitmap = this.rxI.getBitmap();
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
        ab.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", i);
        AppMethodBeat.o(145323);
        return localBitmap;
        i = localBitmap.getWidth();
        break;
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      ab.e("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "getCurFrameBitmap exp:" + localThrowable.toString());
      AppMethodBeat.o(145323);
    }
  }
  
  public final void cru()
  {
    AppMethodBeat.i(145324);
    if (this.rxJ.getVisibility() == 0)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.rxJ, "alpha", new float[] { 1.0F, 0.0F });
      localObjectAnimator.setDuration(250L);
      localObjectAnimator.start();
    }
    abj("com.tencent.mm.adlanding.sphereimage.next_page_view_hide");
    AppMethodBeat.o(145324);
  }
  
  protected final int getLayout()
  {
    return 2130970789;
  }
  
  public final void startLoading()
  {
    AppMethodBeat.i(145318);
    this.gJE.setVisibility(0);
    AppMethodBeat.o(145318);
  }
  
  public final void stopLoading()
  {
    AppMethodBeat.i(145319);
    this.gJE.setVisibility(8);
    AppMethodBeat.o(145319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y
 * JD-Core Version:    0.7.0.1
 */