package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ag;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(32)
public class VideoFullScreenActivity
  extends MMActivity
  implements com.tencent.mm.plugin.sns.ui.d.a
{
  private SightVideoFullScreenView AqV;
  private LongVideoFullScreenView AqW;
  private g AqX;
  public ag AqY;
  private boolean isWaiting;
  private int ism;
  private boolean lQV;
  private int ltA;
  private int ltB;
  private boolean zFJ;
  private int zHq;
  private String zSA;
  private int zSB;
  private String zSx;
  private int zSy;
  private int zSz;
  private FrameLayout zYa;
  private String zzR;
  
  private void a(ag paramag)
  {
    AppMethodBeat.i(198518);
    if ((paramag != null) && (this.zYa != null) && (this.AqX == null))
    {
      if ((bt.isNullOrNil(paramag.desc)) || (paramag.zAB == null))
      {
        AppMethodBeat.o(198518);
        return;
      }
      this.AqX = new g(this, paramag, this.zYa);
      if (getResources().getConfiguration().orientation != 1) {
        break label95;
      }
      this.AqX.dWL();
    }
    for (;;)
    {
      rX(false);
      AppMethodBeat.o(198518);
      return;
      label95:
      if (getResources().getConfiguration().orientation == 2) {
        this.AqX.dWK();
      }
    }
  }
  
  public static ae dWJ()
  {
    AppMethodBeat.i(198517);
    if (ac.ziT != null)
    {
      localae = ac.ziT;
      AppMethodBeat.o(198517);
      return localae;
    }
    ae localae = new ae();
    AppMethodBeat.o(198517);
    return localae;
  }
  
  private void rX(boolean paramBoolean)
  {
    AppMethodBeat.i(198519);
    if (this.AqX != null)
    {
      ad.d("NonFullOrFullVideoType", "hideFloatBarView");
      this.AqX.rC(paramBoolean);
    }
    AppMethodBeat.o(198519);
  }
  
  public void finish()
  {
    AppMethodBeat.i(198525);
    Intent localIntent = null;
    for (;;)
    {
      try
      {
        if (this.ism != 0) {
          continue;
        }
        localIntent = this.AqV.eaQ();
        if ((this.AqX != null) && (localIntent != null))
        {
          this.AqX.dRo();
          localIntent.putExtra("KComponentFullVideoFloatBarReportInfo", this.AqX.dWM());
        }
        setResult(SnsAdNativeLandingPagesUI.zYu, localIntent);
      }
      catch (Throwable localThrowable)
      {
        ad.e("NonFullOrFullVideoType", localThrowable.toString());
        continue;
      }
      super.finish();
      AppMethodBeat.o(198525);
      return;
      if (this.ism == 1) {
        localIntent = this.AqW.dZY();
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2131496133;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(198527);
    super.onConfigurationChanged(paramConfiguration);
    try
    {
      if (paramConfiguration.orientation == 2)
      {
        ad.i("NonFullOrFullVideoType", "ORIENTATION_LANDSCAPE");
        if (this.AqX != null)
        {
          this.AqX.dWK();
          AppMethodBeat.o(198527);
        }
      }
      else if (paramConfiguration.orientation == 1)
      {
        ad.i("NonFullOrFullVideoType", "ORIENTATION_PORTRAIT");
        if (this.AqX != null) {
          this.AqX.dWL();
        }
      }
      AppMethodBeat.o(198527);
      return;
    }
    catch (Throwable paramConfiguration)
    {
      ad.e("NonFullOrFullVideoType", paramConfiguration.toString());
      AppMethodBeat.o(198527);
    }
  }
  
  /* Error */
  public void onCreate(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc 197
    //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aload_1
    //   7: invokespecial 199	com/tencent/mm/ui/MMActivity:onCreate	(Landroid/os/Bundle;)V
    //   10: aload_0
    //   11: invokestatic 205	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/am:aG	(Landroid/app/Activity;)V
    //   14: aload_0
    //   15: getfield 209	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:mController	Lcom/tencent/mm/ui/s;
    //   18: invokevirtual 214	com/tencent/mm/ui/s:hideTitleView	()V
    //   21: aload_0
    //   22: aload_0
    //   23: invokevirtual 217	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   26: ldc 219
    //   28: iconst_0
    //   29: invokevirtual 223	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   32: putfield 133	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ism	I
    //   35: aload_0
    //   36: aload_0
    //   37: invokevirtual 217	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   40: ldc 225
    //   42: invokevirtual 229	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   45: putfield 231	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zSx	Ljava/lang/String;
    //   48: aload_0
    //   49: aload_0
    //   50: invokevirtual 217	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   53: ldc 233
    //   55: iconst_0
    //   56: invokevirtual 223	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   59: putfield 235	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zSy	I
    //   62: aload_0
    //   63: aload_0
    //   64: invokevirtual 217	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   67: ldc 237
    //   69: iconst_0
    //   70: invokevirtual 223	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   73: putfield 239	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zSz	I
    //   76: aload_0
    //   77: aload_0
    //   78: invokevirtual 217	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   81: ldc 241
    //   83: iconst_0
    //   84: invokevirtual 245	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   87: putfield 247	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zFJ	Z
    //   90: aload_0
    //   91: aload_0
    //   92: invokevirtual 217	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   95: ldc 249
    //   97: iconst_0
    //   98: invokevirtual 245	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   101: putfield 251	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:lQV	Z
    //   104: aload_0
    //   105: aload_0
    //   106: invokevirtual 217	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   109: ldc 253
    //   111: invokevirtual 229	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   114: putfield 255	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zzR	Ljava/lang/String;
    //   117: aload_0
    //   118: aload_0
    //   119: invokevirtual 217	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   122: ldc_w 257
    //   125: invokevirtual 229	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   128: putfield 259	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zSA	Ljava/lang/String;
    //   131: aload_0
    //   132: aload_0
    //   133: invokevirtual 217	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   136: ldc_w 261
    //   139: iconst_0
    //   140: invokevirtual 245	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   143: putfield 263	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:isWaiting	Z
    //   146: aload_0
    //   147: aload_0
    //   148: invokevirtual 217	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   151: ldc_w 265
    //   154: iconst_0
    //   155: invokevirtual 223	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   158: putfield 267	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zHq	I
    //   161: aload_0
    //   162: aload_0
    //   163: invokevirtual 217	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   166: ldc_w 269
    //   169: iconst_0
    //   170: invokevirtual 223	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   173: putfield 271	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zSB	I
    //   176: ldc 116
    //   178: new 273	java/lang/StringBuilder
    //   181: dup
    //   182: ldc_w 275
    //   185: invokespecial 278	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   188: aload_0
    //   189: getfield 133	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ism	I
    //   192: invokevirtual 282	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   195: ldc_w 284
    //   198: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_0
    //   202: getfield 231	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zSx	Ljava/lang/String;
    //   205: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: ldc_w 289
    //   211: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_0
    //   215: getfield 235	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zSy	I
    //   218: invokevirtual 282	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   221: ldc_w 291
    //   224: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload_0
    //   228: getfield 239	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zSz	I
    //   231: invokevirtual 282	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   234: ldc_w 293
    //   237: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload_0
    //   241: getfield 247	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zFJ	Z
    //   244: invokevirtual 296	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   247: ldc_w 298
    //   250: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload_0
    //   254: getfield 251	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:lQV	Z
    //   257: invokevirtual 296	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   260: ldc_w 300
    //   263: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload_0
    //   267: getfield 259	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zSA	Ljava/lang/String;
    //   270: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: ldc_w 302
    //   276: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: aload_0
    //   280: getfield 263	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:isWaiting	Z
    //   283: invokevirtual 296	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   286: ldc_w 304
    //   289: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload_0
    //   293: getfield 267	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zHq	I
    //   296: invokevirtual 282	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   299: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 192	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   305: aload_0
    //   306: invokestatic 309	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/am:gk	(Landroid/content/Context;)[I
    //   309: astore_1
    //   310: aload_0
    //   311: aload_1
    //   312: iconst_0
    //   313: iaload
    //   314: putfield 311	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ltA	I
    //   317: aload_0
    //   318: aload_1
    //   319: iconst_1
    //   320: iaload
    //   321: putfield 313	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ltB	I
    //   324: aload_0
    //   325: invokestatic 318	com/tencent/mm/ui/al:aG	(Landroid/content/Context;)Z
    //   328: ifeq +666 -> 994
    //   331: aload_0
    //   332: invokevirtual 80	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getResources	()Landroid/content/res/Resources;
    //   335: invokevirtual 86	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   338: getfield 91	android/content/res/Configuration:orientation	I
    //   341: iconst_1
    //   342: if_icmpne +652 -> 994
    //   345: aload_0
    //   346: aload_0
    //   347: getfield 313	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ltB	I
    //   350: aload_0
    //   351: invokestatic 322	com/tencent/mm/ui/al:aF	(Landroid/content/Context;)I
    //   354: isub
    //   355: putfield 313	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ltB	I
    //   358: ldc 116
    //   360: new 273	java/lang/StringBuilder
    //   363: dup
    //   364: ldc_w 324
    //   367: invokespecial 278	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   370: aload_0
    //   371: getfield 313	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ltB	I
    //   374: invokevirtual 282	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   377: ldc_w 326
    //   380: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: aload_0
    //   384: getfield 311	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ltA	I
    //   387: invokevirtual 282	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   390: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokestatic 192	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   396: aload_0
    //   397: getfield 133	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ism	I
    //   400: ifne +811 -> 1211
    //   403: aload_0
    //   404: aload_0
    //   405: ldc_w 327
    //   408: invokevirtual 331	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:findViewById	(I)Landroid/view/View;
    //   411: checkcast 333	android/widget/FrameLayout
    //   414: putfield 51	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zYa	Landroid/widget/FrameLayout;
    //   417: aload_0
    //   418: new 137	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView
    //   421: dup
    //   422: aload_0
    //   423: invokespecial 336	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:<init>	(Landroid/content/Context;)V
    //   426: putfield 135	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AqV	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   429: aload_0
    //   430: getfield 51	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zYa	Landroid/widget/FrameLayout;
    //   433: aload_0
    //   434: getfield 135	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AqV	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   437: invokevirtual 340	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   440: aload_0
    //   441: getfield 135	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AqV	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   444: astore_1
    //   445: aload_0
    //   446: getfield 311	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ltA	I
    //   449: istore_2
    //   450: aload_0
    //   451: getfield 313	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ltB	I
    //   454: istore_3
    //   455: iload_3
    //   456: iload_2
    //   457: if_icmplt +587 -> 1044
    //   460: aload_1
    //   461: iload_2
    //   462: putfield 341	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:ltA	I
    //   465: aload_1
    //   466: iload_3
    //   467: putfield 342	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:ltB	I
    //   470: aload_1
    //   471: aload_1
    //   472: getfield 346	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   475: bipush 32
    //   477: invokestatic 352	com/tencent/mm/cc/a:fromDPToPix	(Landroid/content/Context;I)I
    //   480: putfield 355	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:length	I
    //   483: aload_0
    //   484: getfield 135	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AqV	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   487: astore_1
    //   488: aload_0
    //   489: getfield 133	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ism	I
    //   492: istore_2
    //   493: aload_0
    //   494: getfield 231	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zSx	Ljava/lang/String;
    //   497: astore 10
    //   499: aload_0
    //   500: getfield 235	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zSy	I
    //   503: istore_3
    //   504: aload_0
    //   505: getfield 239	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zSz	I
    //   508: istore 4
    //   510: aload_0
    //   511: getfield 247	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zFJ	Z
    //   514: istore 7
    //   516: aload_0
    //   517: getfield 251	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:lQV	Z
    //   520: istore 8
    //   522: aload_0
    //   523: getfield 255	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zzR	Ljava/lang/String;
    //   526: astore 11
    //   528: aload_0
    //   529: getfield 259	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zSA	Ljava/lang/String;
    //   532: astore 12
    //   534: aload_1
    //   535: iconst_1
    //   536: putfield 358	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:cAX	Z
    //   539: aload_1
    //   540: iconst_1
    //   541: putfield 361	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:isFirst	Z
    //   544: aload_1
    //   545: iload_2
    //   546: putfield 362	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:ism	I
    //   549: aload_1
    //   550: aload 10
    //   552: putfield 363	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zSx	Ljava/lang/String;
    //   555: aload_1
    //   556: iload_3
    //   557: putfield 364	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zSy	I
    //   560: aload_1
    //   561: iload 4
    //   563: putfield 365	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zSz	I
    //   566: aload_1
    //   567: iload 7
    //   569: putfield 366	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zFJ	Z
    //   572: aload_1
    //   573: iload 8
    //   575: putfield 367	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:lQV	Z
    //   578: aload_1
    //   579: aload 11
    //   581: putfield 368	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zzR	Ljava/lang/String;
    //   584: aload_1
    //   585: aload 12
    //   587: putfield 369	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zSA	Ljava/lang/String;
    //   590: aload_0
    //   591: getfield 135	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AqV	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   594: astore_1
    //   595: aload_1
    //   596: aload_1
    //   597: getfield 346	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   600: invokestatic 375	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   603: ldc_w 376
    //   606: aload_1
    //   607: iconst_1
    //   608: invokevirtual 380	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   611: putfield 384	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   614: aload_1
    //   615: aload_1
    //   616: getfield 384	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   619: ldc_w 385
    //   622: invokevirtual 388	android/view/View:findViewById	(I)Landroid/view/View;
    //   625: checkcast 333	android/widget/FrameLayout
    //   628: putfield 391	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zSt	Landroid/widget/FrameLayout;
    //   631: aload_1
    //   632: aload_1
    //   633: getfield 384	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   636: ldc_w 392
    //   639: invokevirtual 388	android/view/View:findViewById	(I)Landroid/view/View;
    //   642: putfield 395	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zSu	Landroid/view/View;
    //   645: aload_1
    //   646: aload_1
    //   647: getfield 384	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   650: ldc_w 396
    //   653: invokevirtual 388	android/view/View:findViewById	(I)Landroid/view/View;
    //   656: putfield 399	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zSv	Landroid/view/View;
    //   659: aload_1
    //   660: aload_1
    //   661: getfield 384	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   664: ldc_w 400
    //   667: invokevirtual 388	android/view/View:findViewById	(I)Landroid/view/View;
    //   670: checkcast 402	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar
    //   673: putfield 406	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zFA	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   676: aload_1
    //   677: new 408	com/tencent/mm/plugin/sns/ui/OfflineVideoView
    //   680: dup
    //   681: aload_1
    //   682: getfield 346	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   685: invokespecial 409	com/tencent/mm/plugin/sns/ui/OfflineVideoView:<init>	(Landroid/content/Context;)V
    //   688: putfield 413	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zWt	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   691: aload_1
    //   692: getfield 413	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zWt	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   695: iconst_1
    //   696: invokevirtual 416	com/tencent/mm/plugin/sns/ui/OfflineVideoView:setClickable	(Z)V
    //   699: aload_1
    //   700: getfield 413	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zWt	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   703: aload_1
    //   704: invokevirtual 420	com/tencent/mm/plugin/sns/ui/OfflineVideoView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   707: aload_1
    //   708: getfield 391	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zSt	Landroid/widget/FrameLayout;
    //   711: aload_1
    //   712: getfield 413	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zWt	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   715: invokevirtual 340	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   718: aload_1
    //   719: getfield 406	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zFA	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   722: iconst_0
    //   723: invokevirtual 423	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setVisibility	(I)V
    //   726: aload_1
    //   727: getfield 406	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zFA	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   730: aload_1
    //   731: getfield 427	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zFW	Landroid/view/View$OnClickListener;
    //   734: invokevirtual 431	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setOnPlayButtonClickListener	(Landroid/view/View$OnClickListener;)V
    //   737: aload_1
    //   738: getfield 406	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zFA	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   741: aload_1
    //   742: getfield 435	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:rFm	Lcom/tencent/mm/plugin/sight/decode/ui/b;
    //   745: invokevirtual 439	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setIplaySeekCallback	(Lcom/tencent/mm/plugin/sight/decode/ui/b;)V
    //   748: aload_1
    //   749: aload_1
    //   750: ldc_w 440
    //   753: invokevirtual 441	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:findViewById	(I)Landroid/view/View;
    //   756: checkcast 443	android/widget/ImageView
    //   759: putfield 447	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zGG	Landroid/widget/ImageView;
    //   762: aload_1
    //   763: getfield 447	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zGG	Landroid/widget/ImageView;
    //   766: iconst_0
    //   767: invokevirtual 448	android/widget/ImageView:setVisibility	(I)V
    //   770: aload_1
    //   771: getfield 447	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zGG	Landroid/widget/ImageView;
    //   774: aload_1
    //   775: invokevirtual 451	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   778: aload_1
    //   779: aload_1
    //   780: ldc_w 452
    //   783: invokevirtual 441	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:findViewById	(I)Landroid/view/View;
    //   786: checkcast 443	android/widget/ImageView
    //   789: putfield 455	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zFB	Landroid/widget/ImageView;
    //   792: aload_1
    //   793: getfield 455	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zFB	Landroid/widget/ImageView;
    //   796: iconst_0
    //   797: invokevirtual 448	android/widget/ImageView:setVisibility	(I)V
    //   800: aload_1
    //   801: getfield 455	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zFB	Landroid/widget/ImageView;
    //   804: aload_1
    //   805: invokevirtual 451	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   808: aload_1
    //   809: aload_1
    //   810: getfield 384	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   813: ldc_w 456
    //   816: invokevirtual 388	android/view/View:findViewById	(I)Landroid/view/View;
    //   819: putfield 459	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zGH	Landroid/view/View;
    //   822: aload_1
    //   823: getfield 459	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zGH	Landroid/view/View;
    //   826: bipush 8
    //   828: invokevirtual 460	android/view/View:setVisibility	(I)V
    //   831: aload_1
    //   832: getfield 346	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   835: invokevirtual 463	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   838: invokevirtual 86	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   841: getfield 91	android/content/res/Configuration:orientation	I
    //   844: iconst_2
    //   845: if_icmpne +256 -> 1101
    //   848: ldc_w 465
    //   851: ldc 190
    //   853: invokestatic 192	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   856: aload_1
    //   857: invokevirtual 466	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:dWK	()V
    //   860: aload_1
    //   861: getfield 406	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zFA	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   864: invokevirtual 469	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:getVideoTotalTime	()I
    //   867: aload_1
    //   868: getfield 365	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zSz	I
    //   871: sipush 1000
    //   874: idiv
    //   875: if_icmpeq +18 -> 893
    //   878: aload_1
    //   879: getfield 406	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zFA	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   882: aload_1
    //   883: getfield 365	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zSz	I
    //   886: sipush 1000
    //   889: idiv
    //   890: invokevirtual 472	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setVideoTotalTime	(I)V
    //   893: aload_1
    //   894: getfield 406	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zFA	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   897: aload_1
    //   898: getfield 364	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zSy	I
    //   901: sipush 1000
    //   904: idiv
    //   905: invokevirtual 475	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:seek	(I)V
    //   908: aload_1
    //   909: aload_1
    //   910: getfield 367	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:lQV	Z
    //   913: invokevirtual 478	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:rE	(Z)V
    //   916: aload_1
    //   917: getfield 413	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zWt	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   920: new 480	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView$2
    //   923: dup
    //   924: aload_1
    //   925: invokespecial 483	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView$2:<init>	(Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;)V
    //   928: invokevirtual 487	com/tencent/mm/plugin/sns/ui/OfflineVideoView:setVideoCallback	(Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView$a;)V
    //   931: aload_1
    //   932: getfield 413	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zWt	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   935: invokevirtual 490	com/tencent/mm/plugin/sns/ui/OfflineVideoView:cxv	()V
    //   938: aload_1
    //   939: iconst_1
    //   940: invokevirtual 493	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:setFocus	(Z)V
    //   943: aload_0
    //   944: getfield 135	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AqV	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   947: aload_0
    //   948: invokevirtual 497	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:setProgressBarStatusListener	(Lcom/tencent/mm/plugin/sns/ui/d/a;)V
    //   951: getstatic 503	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ae$b:zGX	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u;
    //   954: ifnull +21 -> 975
    //   957: aload_0
    //   958: getstatic 503	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ae$b:zGX	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u;
    //   961: getfield 508	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:zAb	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ag;
    //   964: putfield 510	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AqY	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ag;
    //   967: aload_0
    //   968: aload_0
    //   969: getfield 510	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AqY	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ag;
    //   972: invokespecial 512	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:a	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ag;)V
    //   975: ldc 197
    //   977: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   980: return
    //   981: astore_1
    //   982: ldc 116
    //   984: aload_1
    //   985: invokevirtual 177	java/lang/Throwable:toString	()Ljava/lang/String;
    //   988: invokestatic 180	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   991: goto -686 -> 305
    //   994: aload_0
    //   995: invokestatic 318	com/tencent/mm/ui/al:aG	(Landroid/content/Context;)Z
    //   998: ifeq -640 -> 358
    //   1001: aload_0
    //   1002: invokevirtual 80	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getResources	()Landroid/content/res/Resources;
    //   1005: invokevirtual 86	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   1008: getfield 91	android/content/res/Configuration:orientation	I
    //   1011: iconst_2
    //   1012: if_icmpne -654 -> 358
    //   1015: aload_0
    //   1016: aload_0
    //   1017: getfield 311	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ltA	I
    //   1020: aload_0
    //   1021: invokestatic 322	com/tencent/mm/ui/al:aF	(Landroid/content/Context;)I
    //   1024: isub
    //   1025: putfield 311	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ltA	I
    //   1028: goto -670 -> 358
    //   1031: astore_1
    //   1032: ldc 116
    //   1034: aload_1
    //   1035: invokevirtual 177	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1038: invokestatic 180	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1041: goto -645 -> 396
    //   1044: aload_1
    //   1045: iload_2
    //   1046: putfield 342	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:ltB	I
    //   1049: aload_1
    //   1050: iload_3
    //   1051: putfield 341	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:ltA	I
    //   1054: goto -584 -> 470
    //   1057: astore_1
    //   1058: ldc_w 465
    //   1061: aload_1
    //   1062: invokevirtual 177	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1065: invokestatic 180	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1068: goto -585 -> 483
    //   1071: astore_1
    //   1072: ldc 116
    //   1074: aload_1
    //   1075: invokevirtual 177	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1078: invokestatic 180	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1081: ldc 197
    //   1083: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1086: return
    //   1087: astore_1
    //   1088: ldc_w 465
    //   1091: aload_1
    //   1092: invokevirtual 177	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1095: invokestatic 180	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1098: goto -508 -> 590
    //   1101: aload_1
    //   1102: getfield 346	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   1105: invokevirtual 463	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1108: invokevirtual 86	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   1111: getfield 91	android/content/res/Configuration:orientation	I
    //   1114: iconst_1
    //   1115: if_icmpne -255 -> 860
    //   1118: ldc_w 465
    //   1121: ldc 194
    //   1123: invokestatic 192	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1126: aload_1
    //   1127: invokevirtual 513	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:dWL	()V
    //   1130: goto -270 -> 860
    //   1133: astore 10
    //   1135: ldc_w 465
    //   1138: aload 10
    //   1140: invokevirtual 177	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1143: invokestatic 180	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1146: goto -286 -> 860
    //   1149: astore_1
    //   1150: ldc_w 465
    //   1153: aload_1
    //   1154: invokevirtual 177	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1157: invokestatic 180	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1160: goto -217 -> 943
    //   1163: astore 10
    //   1165: ldc_w 465
    //   1168: aload 10
    //   1170: invokevirtual 177	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1173: invokestatic 180	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1176: goto -260 -> 916
    //   1179: astore 10
    //   1181: ldc_w 465
    //   1184: aload 10
    //   1186: invokevirtual 177	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1189: invokestatic 180	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1192: goto -261 -> 931
    //   1195: astore_1
    //   1196: ldc 116
    //   1198: aload_1
    //   1199: invokevirtual 177	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1202: invokestatic 180	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1205: ldc 197
    //   1207: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1210: return
    //   1211: aload_0
    //   1212: getfield 133	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ism	I
    //   1215: iconst_1
    //   1216: if_icmpne +649 -> 1865
    //   1219: aload_0
    //   1220: aload_0
    //   1221: ldc_w 327
    //   1224: invokevirtual 331	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:findViewById	(I)Landroid/view/View;
    //   1227: checkcast 333	android/widget/FrameLayout
    //   1230: putfield 51	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zYa	Landroid/widget/FrameLayout;
    //   1233: aload_0
    //   1234: new 171	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView
    //   1237: dup
    //   1238: aload_0
    //   1239: invokespecial 514	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:<init>	(Landroid/content/Context;)V
    //   1242: putfield 169	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AqW	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1245: aload_0
    //   1246: getfield 51	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zYa	Landroid/widget/FrameLayout;
    //   1249: aload_0
    //   1250: getfield 169	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AqW	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1253: invokevirtual 340	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   1256: aload_0
    //   1257: getfield 169	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AqW	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1260: astore_1
    //   1261: aload_0
    //   1262: getfield 311	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ltA	I
    //   1265: istore_2
    //   1266: aload_0
    //   1267: getfield 313	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ltB	I
    //   1270: istore_3
    //   1271: iload_3
    //   1272: iload_2
    //   1273: if_icmplt +598 -> 1871
    //   1276: aload_1
    //   1277: iload_2
    //   1278: putfield 515	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:ltA	I
    //   1281: aload_1
    //   1282: iload_3
    //   1283: putfield 516	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:ltB	I
    //   1286: aload_1
    //   1287: aload_1
    //   1288: getfield 517	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mContext	Landroid/content/Context;
    //   1291: bipush 32
    //   1293: invokestatic 352	com/tencent/mm/cc/a:fromDPToPix	(Landroid/content/Context;I)I
    //   1296: putfield 518	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:length	I
    //   1299: aload_0
    //   1300: getfield 169	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AqW	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1303: astore_1
    //   1304: aload_0
    //   1305: getfield 133	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ism	I
    //   1308: istore_2
    //   1309: aload_0
    //   1310: getfield 231	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zSx	Ljava/lang/String;
    //   1313: astore 10
    //   1315: aload_0
    //   1316: getfield 235	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zSy	I
    //   1319: istore_3
    //   1320: aload_0
    //   1321: getfield 239	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zSz	I
    //   1324: istore 4
    //   1326: aload_0
    //   1327: getfield 247	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zFJ	Z
    //   1330: istore 7
    //   1332: aload_0
    //   1333: getfield 251	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:lQV	Z
    //   1336: istore 8
    //   1338: aload_0
    //   1339: getfield 255	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zzR	Ljava/lang/String;
    //   1342: astore 11
    //   1344: aload_0
    //   1345: getfield 259	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zSA	Ljava/lang/String;
    //   1348: astore 12
    //   1350: aload_0
    //   1351: getfield 263	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:isWaiting	Z
    //   1354: istore 9
    //   1356: aload_0
    //   1357: getfield 267	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zHq	I
    //   1360: istore 5
    //   1362: aload_0
    //   1363: getfield 271	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zSB	I
    //   1366: istore 6
    //   1368: aload_1
    //   1369: iconst_1
    //   1370: putfield 521	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:gEz	Z
    //   1373: aload_1
    //   1374: iconst_1
    //   1375: putfield 522	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:isFirst	Z
    //   1378: aload_1
    //   1379: iload_2
    //   1380: putfield 523	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:ism	I
    //   1383: aload_1
    //   1384: aload 10
    //   1386: putfield 524	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zSx	Ljava/lang/String;
    //   1389: aload_1
    //   1390: iload_3
    //   1391: putfield 525	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zSy	I
    //   1394: aload_1
    //   1395: iload 4
    //   1397: putfield 526	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zSz	I
    //   1400: aload_1
    //   1401: iload 7
    //   1403: putfield 527	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zFJ	Z
    //   1406: aload_1
    //   1407: iload 8
    //   1409: putfield 528	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:lQV	Z
    //   1412: aload_1
    //   1413: aload 11
    //   1415: putfield 529	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zzR	Ljava/lang/String;
    //   1418: aload_1
    //   1419: aload 12
    //   1421: putfield 530	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zSA	Ljava/lang/String;
    //   1424: aload_1
    //   1425: iload 9
    //   1427: putfield 531	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:isWaiting	Z
    //   1430: aload_1
    //   1431: iload 5
    //   1433: putfield 532	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zHq	I
    //   1436: aload_1
    //   1437: iload 6
    //   1439: putfield 533	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zSB	I
    //   1442: aload_0
    //   1443: getfield 169	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AqW	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1446: astore_1
    //   1447: aload_1
    //   1448: aload_1
    //   1449: getfield 517	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mContext	Landroid/content/Context;
    //   1452: invokestatic 375	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   1455: ldc_w 534
    //   1458: aload_1
    //   1459: iconst_1
    //   1460: invokevirtual 380	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   1463: putfield 535	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1466: aload_1
    //   1467: aload_1
    //   1468: getfield 535	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1471: ldc_w 385
    //   1474: invokevirtual 388	android/view/View:findViewById	(I)Landroid/view/View;
    //   1477: checkcast 333	android/widget/FrameLayout
    //   1480: putfield 536	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zSt	Landroid/widget/FrameLayout;
    //   1483: aload_1
    //   1484: new 538	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper
    //   1487: dup
    //   1488: aload_1
    //   1489: getfield 517	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mContext	Landroid/content/Context;
    //   1492: invokespecial 539	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:<init>	(Landroid/content/Context;)V
    //   1495: putfield 543	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zSw	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1498: aload_1
    //   1499: getfield 536	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zSt	Landroid/widget/FrameLayout;
    //   1502: aload_1
    //   1503: getfield 543	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zSw	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1506: invokevirtual 340	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   1509: aload_1
    //   1510: getfield 543	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zSw	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1513: aload_1
    //   1514: invokevirtual 547	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setIMMVideoViewCallback	(Lcom/tencent/mm/pluginsdk/ui/i$b;)V
    //   1517: aload_1
    //   1518: getfield 543	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zSw	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1521: iconst_1
    //   1522: invokevirtual 550	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setFullScreen	(Z)V
    //   1525: aload_1
    //   1526: getfield 543	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zSw	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1529: iconst_0
    //   1530: aload_1
    //   1531: getfield 530	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zSA	Ljava/lang/String;
    //   1534: iconst_0
    //   1535: invokevirtual 554	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:c	(ZLjava/lang/String;I)V
    //   1538: aload_1
    //   1539: getfield 543	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zSw	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1542: iconst_1
    //   1543: invokevirtual 555	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setClickable	(Z)V
    //   1546: aload_1
    //   1547: getfield 543	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zSw	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1550: aload_1
    //   1551: invokevirtual 556	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   1554: aload_1
    //   1555: getfield 543	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zSw	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1558: iconst_1
    //   1559: invokevirtual 559	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setLoop	(Z)V
    //   1562: aload_1
    //   1563: getfield 543	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zSw	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1566: aload_1
    //   1567: invokevirtual 563	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setLoopCompletionCallback	(Lcom/tencent/mm/pluginsdk/ui/i$d;)V
    //   1570: aload_1
    //   1571: aload_1
    //   1572: getfield 535	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1575: ldc_w 392
    //   1578: invokevirtual 388	android/view/View:findViewById	(I)Landroid/view/View;
    //   1581: putfield 564	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zSu	Landroid/view/View;
    //   1584: aload_1
    //   1585: aload_1
    //   1586: getfield 535	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1589: ldc_w 396
    //   1592: invokevirtual 388	android/view/View:findViewById	(I)Landroid/view/View;
    //   1595: putfield 565	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zSv	Landroid/view/View;
    //   1598: aload_1
    //   1599: aload_1
    //   1600: getfield 535	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1603: ldc_w 400
    //   1606: invokevirtual 388	android/view/View:findViewById	(I)Landroid/view/View;
    //   1609: checkcast 402	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar
    //   1612: putfield 566	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zFA	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1615: aload_1
    //   1616: getfield 566	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zFA	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1619: iconst_0
    //   1620: invokevirtual 423	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setVisibility	(I)V
    //   1623: aload_1
    //   1624: getfield 566	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zFA	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1627: aload_1
    //   1628: getfield 567	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zFW	Landroid/view/View$OnClickListener;
    //   1631: invokevirtual 431	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setOnPlayButtonClickListener	(Landroid/view/View$OnClickListener;)V
    //   1634: aload_1
    //   1635: getfield 566	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zFA	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1638: aload_1
    //   1639: getfield 568	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:rFm	Lcom/tencent/mm/plugin/sight/decode/ui/b;
    //   1642: invokevirtual 439	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setIplaySeekCallback	(Lcom/tencent/mm/plugin/sight/decode/ui/b;)V
    //   1645: aload_1
    //   1646: aload_1
    //   1647: ldc_w 440
    //   1650: invokevirtual 569	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:findViewById	(I)Landroid/view/View;
    //   1653: checkcast 443	android/widget/ImageView
    //   1656: putfield 570	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zGG	Landroid/widget/ImageView;
    //   1659: aload_1
    //   1660: getfield 570	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zGG	Landroid/widget/ImageView;
    //   1663: iconst_0
    //   1664: invokevirtual 448	android/widget/ImageView:setVisibility	(I)V
    //   1667: aload_1
    //   1668: getfield 570	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zGG	Landroid/widget/ImageView;
    //   1671: aload_1
    //   1672: invokevirtual 451	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1675: aload_1
    //   1676: aload_1
    //   1677: ldc_w 452
    //   1680: invokevirtual 569	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:findViewById	(I)Landroid/view/View;
    //   1683: checkcast 443	android/widget/ImageView
    //   1686: putfield 571	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zFB	Landroid/widget/ImageView;
    //   1689: aload_1
    //   1690: getfield 571	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zFB	Landroid/widget/ImageView;
    //   1693: iconst_0
    //   1694: invokevirtual 448	android/widget/ImageView:setVisibility	(I)V
    //   1697: aload_1
    //   1698: getfield 571	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zFB	Landroid/widget/ImageView;
    //   1701: aload_1
    //   1702: invokevirtual 451	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1705: aload_1
    //   1706: aload_1
    //   1707: getfield 535	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1710: ldc_w 456
    //   1713: invokevirtual 388	android/view/View:findViewById	(I)Landroid/view/View;
    //   1716: putfield 572	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zGH	Landroid/view/View;
    //   1719: aload_1
    //   1720: getfield 572	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zGH	Landroid/view/View;
    //   1723: bipush 8
    //   1725: invokevirtual 460	android/view/View:setVisibility	(I)V
    //   1728: aload_1
    //   1729: getfield 566	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zFA	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1732: invokevirtual 576	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:getParent	()Landroid/view/ViewParent;
    //   1735: astore 10
    //   1737: aload 10
    //   1739: instanceof 578
    //   1742: ifeq +15 -> 1757
    //   1745: aload 10
    //   1747: checkcast 578	android/view/ViewGroup
    //   1750: aload_1
    //   1751: getfield 566	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zFA	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1754: invokevirtual 581	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   1757: aload_1
    //   1758: getfield 543	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zSw	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1761: aload_1
    //   1762: getfield 566	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zFA	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1765: invokevirtual 585	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setVideoFooterView	(Lcom/tencent/mm/pluginsdk/ui/h;)V
    //   1768: aload_1
    //   1769: getfield 517	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mContext	Landroid/content/Context;
    //   1772: invokevirtual 463	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1775: invokevirtual 86	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   1778: getfield 91	android/content/res/Configuration:orientation	I
    //   1781: iconst_2
    //   1782: if_icmpne +160 -> 1942
    //   1785: ldc_w 587
    //   1788: ldc 190
    //   1790: invokestatic 192	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1793: aload_1
    //   1794: invokevirtual 588	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:dWK	()V
    //   1797: aload_1
    //   1798: getfield 527	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zFJ	Z
    //   1801: ifeq +189 -> 1990
    //   1804: aload_1
    //   1805: invokevirtual 591	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:dWl	()V
    //   1808: aload_1
    //   1809: invokevirtual 594	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:can	()V
    //   1812: aload_1
    //   1813: iconst_1
    //   1814: invokevirtual 595	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:setFocus	(Z)V
    //   1817: aload_0
    //   1818: getfield 169	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AqW	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1821: aload_0
    //   1822: invokevirtual 596	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:setProgressBarStatusListener	(Lcom/tencent/mm/plugin/sns/ui/d/a;)V
    //   1825: getstatic 602	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ai$a:zHv	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aj;
    //   1828: ifnull +21 -> 1849
    //   1831: aload_0
    //   1832: getstatic 602	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ai$a:zHv	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aj;
    //   1835: getfield 605	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aj:zAb	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ag;
    //   1838: putfield 510	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AqY	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ag;
    //   1841: aload_0
    //   1842: aload_0
    //   1843: getfield 510	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AqY	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ag;
    //   1846: invokespecial 512	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:a	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ag;)V
    //   1849: ldc 197
    //   1851: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1854: return
    //   1855: astore_1
    //   1856: ldc 116
    //   1858: aload_1
    //   1859: invokevirtual 177	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1862: invokestatic 180	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1865: ldc 197
    //   1867: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1870: return
    //   1871: aload_1
    //   1872: iload_2
    //   1873: putfield 516	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:ltB	I
    //   1876: aload_1
    //   1877: iload_3
    //   1878: putfield 515	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:ltA	I
    //   1881: goto -595 -> 1286
    //   1884: astore_1
    //   1885: ldc_w 587
    //   1888: aload_1
    //   1889: invokevirtual 177	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1892: invokestatic 180	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1895: goto -596 -> 1299
    //   1898: astore_1
    //   1899: ldc_w 587
    //   1902: aload_1
    //   1903: invokevirtual 177	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1906: invokestatic 180	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1909: goto -467 -> 1442
    //   1912: astore 10
    //   1914: ldc_w 587
    //   1917: aload 10
    //   1919: invokevirtual 177	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1922: invokestatic 180	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1925: goto -355 -> 1570
    //   1928: astore_1
    //   1929: ldc_w 587
    //   1932: aload_1
    //   1933: invokevirtual 177	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1936: invokestatic 180	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1939: goto -122 -> 1817
    //   1942: aload_1
    //   1943: getfield 517	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mContext	Landroid/content/Context;
    //   1946: invokevirtual 463	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1949: invokevirtual 86	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   1952: getfield 91	android/content/res/Configuration:orientation	I
    //   1955: iconst_1
    //   1956: if_icmpne -159 -> 1797
    //   1959: ldc_w 587
    //   1962: ldc 194
    //   1964: invokestatic 192	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1967: aload_1
    //   1968: invokevirtual 606	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:dWL	()V
    //   1971: goto -174 -> 1797
    //   1974: astore 10
    //   1976: ldc_w 587
    //   1979: aload 10
    //   1981: invokevirtual 177	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1984: invokestatic 180	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1987: goto -190 -> 1797
    //   1990: aload_1
    //   1991: invokevirtual 609	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:dWn	()V
    //   1994: goto -186 -> 1808
    //   1997: astore 10
    //   1999: ldc_w 587
    //   2002: aload 10
    //   2004: invokevirtual 177	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2007: invokestatic 180	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2010: goto -198 -> 1812
    //   2013: astore_1
    //   2014: ldc 116
    //   2016: aload_1
    //   2017: invokevirtual 177	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2020: invokestatic 180	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2023: ldc 197
    //   2025: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2028: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2029	0	this	VideoFullScreenActivity
    //   0	2029	1	paramBundle	android.os.Bundle
    //   449	1424	2	i	int
    //   454	1424	3	j	int
    //   508	888	4	k	int
    //   1360	72	5	m	int
    //   1366	72	6	n	int
    //   514	888	7	bool1	boolean
    //   520	888	8	bool2	boolean
    //   1354	72	9	bool3	boolean
    //   497	54	10	str1	String
    //   1133	6	10	localThrowable1	Throwable
    //   1163	6	10	localThrowable2	Throwable
    //   1179	6	10	localThrowable3	Throwable
    //   1313	433	10	localObject	java.lang.Object
    //   1912	6	10	localThrowable4	Throwable
    //   1974	6	10	localThrowable5	Throwable
    //   1997	6	10	localThrowable6	Throwable
    //   526	888	11	str2	String
    //   532	888	12	str3	String
    // Exception table:
    //   from	to	target	type
    //   21	305	981	java/lang/Throwable
    //   305	358	1031	java/lang/Throwable
    //   358	396	1031	java/lang/Throwable
    //   994	1028	1031	java/lang/Throwable
    //   460	470	1057	java/lang/Throwable
    //   470	483	1057	java/lang/Throwable
    //   1044	1054	1057	java/lang/Throwable
    //   403	455	1071	java/lang/Throwable
    //   483	534	1071	java/lang/Throwable
    //   590	595	1071	java/lang/Throwable
    //   943	951	1071	java/lang/Throwable
    //   975	980	1071	java/lang/Throwable
    //   1058	1068	1071	java/lang/Throwable
    //   1088	1098	1071	java/lang/Throwable
    //   1150	1160	1071	java/lang/Throwable
    //   1196	1205	1071	java/lang/Throwable
    //   534	590	1087	java/lang/Throwable
    //   595	860	1133	java/lang/Throwable
    //   1101	1130	1133	java/lang/Throwable
    //   931	943	1149	java/lang/Throwable
    //   1135	1146	1149	java/lang/Throwable
    //   1165	1176	1149	java/lang/Throwable
    //   1181	1192	1149	java/lang/Throwable
    //   860	893	1163	java/lang/Throwable
    //   893	916	1163	java/lang/Throwable
    //   916	931	1179	java/lang/Throwable
    //   951	975	1195	java/lang/Throwable
    //   1219	1271	1855	java/lang/Throwable
    //   1299	1368	1855	java/lang/Throwable
    //   1442	1447	1855	java/lang/Throwable
    //   1817	1825	1855	java/lang/Throwable
    //   1849	1854	1855	java/lang/Throwable
    //   1885	1895	1855	java/lang/Throwable
    //   1899	1909	1855	java/lang/Throwable
    //   1929	1939	1855	java/lang/Throwable
    //   2014	2023	1855	java/lang/Throwable
    //   1276	1286	1884	java/lang/Throwable
    //   1286	1299	1884	java/lang/Throwable
    //   1871	1881	1884	java/lang/Throwable
    //   1368	1442	1898	java/lang/Throwable
    //   1447	1570	1912	java/lang/Throwable
    //   1812	1817	1928	java/lang/Throwable
    //   1914	1925	1928	java/lang/Throwable
    //   1976	1987	1928	java/lang/Throwable
    //   1999	2010	1928	java/lang/Throwable
    //   1570	1757	1974	java/lang/Throwable
    //   1757	1797	1974	java/lang/Throwable
    //   1942	1971	1974	java/lang/Throwable
    //   1797	1808	1997	java/lang/Throwable
    //   1808	1812	1997	java/lang/Throwable
    //   1990	1994	1997	java/lang/Throwable
    //   1825	1849	2013	java/lang/Throwable
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(198524);
    for (;;)
    {
      try
      {
        ac.ziT = null;
        if (this.ism != 0) {
          continue;
        }
        localSightVideoFullScreenView = this.AqV;
      }
      catch (Throwable localThrowable2)
      {
        SightVideoFullScreenView localSightVideoFullScreenView;
        ad.e("NonFullOrFullVideoType", localThrowable2.toString());
        continue;
        if (this.ism != 1) {
          continue;
        }
        localLongVideoFullScreenView = this.AqW;
      }
      try
      {
        aq.aA(localSightVideoFullScreenView.zFF);
        aq.aA(localSightVideoFullScreenView.zGJ);
        localSightVideoFullScreenView.zWt.onDestroy();
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae.b.zGX = null;
        super.onDestroy();
        AppMethodBeat.o(198524);
        return;
      }
      catch (Throwable localThrowable1)
      {
        ad.e("SightVideoFullScreenView", localThrowable1.toString());
        continue;
      }
      try
      {
        LongVideoFullScreenView localLongVideoFullScreenView;
        aq.aA(localLongVideoFullScreenView.zFF);
        aq.aA(localLongVideoFullScreenView.zGJ);
        localLongVideoFullScreenView.zSw.onUIDestroy();
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ai.a.zHv = null;
      }
      catch (Throwable localThrowable3)
      {
        for (;;)
        {
          ad.e("LongVideoFullScreenView", localThrowable3.toString());
        }
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(198522);
    super.onPause();
    try
    {
      if (this.ism == 0)
      {
        SightVideoFullScreenView localSightVideoFullScreenView = this.AqV;
        try
        {
          localSightVideoFullScreenView.zxZ = false;
          aq.aA(localSightVideoFullScreenView.zFF);
          aq.aA(localSightVideoFullScreenView.zGJ);
          AppMethodBeat.o(198522);
          return;
        }
        catch (Throwable localThrowable1)
        {
          ad.e("SightVideoFullScreenView", localThrowable1.toString());
          AppMethodBeat.o(198522);
          return;
        }
      }
      if (this.ism != 1) {
        break label133;
      }
    }
    catch (Throwable localThrowable2)
    {
      ad.e("NonFullOrFullVideoType", localThrowable2.toString());
      AppMethodBeat.o(198522);
      return;
    }
    LongVideoFullScreenView localLongVideoFullScreenView = this.AqW;
    try
    {
      localLongVideoFullScreenView.zxZ = false;
      aq.aA(localLongVideoFullScreenView.zFF);
      aq.aA(localLongVideoFullScreenView.zGJ);
      AppMethodBeat.o(198522);
      return;
    }
    catch (Throwable localThrowable3)
    {
      ad.e("LongVideoFullScreenView", localThrowable3.toString());
    }
    label133:
    AppMethodBeat.o(198522);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(198521);
    super.onResume();
    try
    {
      am.aG(this);
      if (this.ism == 0)
      {
        this.AqV.zxZ = true;
        AppMethodBeat.o(198521);
        return;
      }
      if (this.ism == 1) {
        this.AqW.zxZ = true;
      }
      AppMethodBeat.o(198521);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("NonFullOrFullVideoType", localThrowable.toString());
      AppMethodBeat.o(198521);
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(198520);
    super.onStart();
    try
    {
      am.aG(this);
      if (this.ism == 0)
      {
        SightVideoFullScreenView localSightVideoFullScreenView = this.AqV;
        try
        {
          if ((!localSightVideoFullScreenView.isFirst) && (!localSightVideoFullScreenView.zWt.isPlaying()) && (localSightVideoFullScreenView.zSE))
          {
            localSightVideoFullScreenView.eaO();
            localSightVideoFullScreenView.zSE = false;
          }
          localSightVideoFullScreenView.isFirst = false;
          AppMethodBeat.o(198520);
          return;
        }
        catch (Throwable localThrowable1)
        {
          ad.e("SightVideoFullScreenView", localThrowable1.toString());
          AppMethodBeat.o(198520);
          return;
        }
      }
      if (this.ism != 1) {
        break label175;
      }
    }
    catch (Throwable localThrowable2)
    {
      ad.e("NonFullOrFullVideoType", localThrowable2.toString());
      AppMethodBeat.o(198520);
      return;
    }
    LongVideoFullScreenView localLongVideoFullScreenView = this.AqW;
    try
    {
      if ((!localLongVideoFullScreenView.isFirst) && (!localLongVideoFullScreenView.zSw.isPlaying()) && (localLongVideoFullScreenView.zSE))
      {
        localLongVideoFullScreenView.can();
        localLongVideoFullScreenView.zSE = false;
      }
      localLongVideoFullScreenView.isFirst = false;
      AppMethodBeat.o(198520);
      return;
    }
    catch (Throwable localThrowable3)
    {
      ad.e("LongVideoFullScreenView", localThrowable3.toString());
    }
    label175:
    AppMethodBeat.o(198520);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(198523);
    super.onStop();
    try
    {
      if (this.ism == 0)
      {
        SightVideoFullScreenView localSightVideoFullScreenView = this.AqV;
        try
        {
          localSightVideoFullScreenView.isFirst = false;
          if (localSightVideoFullScreenView.zWt.isPlaying())
          {
            localSightVideoFullScreenView.eaP();
            localSightVideoFullScreenView.zSE = true;
          }
          AppMethodBeat.o(198523);
          return;
        }
        catch (Throwable localThrowable1)
        {
          ad.e("SightVideoFullScreenView", localThrowable1.toString());
          AppMethodBeat.o(198523);
          return;
        }
      }
      if (this.ism != 1) {
        break label143;
      }
    }
    catch (Throwable localThrowable2)
    {
      ad.e("NonFullOrFullVideoType", localThrowable2.toString());
      AppMethodBeat.o(198523);
      return;
    }
    LongVideoFullScreenView localLongVideoFullScreenView = this.AqW;
    try
    {
      localLongVideoFullScreenView.isFirst = false;
      if (localLongVideoFullScreenView.zSw.isPlaying())
      {
        localLongVideoFullScreenView.cxw();
        localLongVideoFullScreenView.zSE = true;
      }
      AppMethodBeat.o(198523);
      return;
    }
    catch (Throwable localThrowable3)
    {
      ad.e("LongVideoFullScreenView", localThrowable3.toString());
    }
    label143:
    AppMethodBeat.o(198523);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rY(boolean paramBoolean)
  {
    AppMethodBeat.i(198526);
    ad.i("NonFullOrFullVideoType", "progressBarStatus visiblity = ".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      rX(true);
      AppMethodBeat.o(198526);
      return;
    }
    if (this.AqX != null)
    {
      ad.d("NonFullOrFullVideoType", "showFloatBarView");
      this.AqX.dWI();
    }
    AppMethodBeat.o(198526);
  }
  
  public void setMMOrientation() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.VideoFullScreenActivity
 * JD-Core Version:    0.7.0.1
 */