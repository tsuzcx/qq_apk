package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(32)
public class VideoFullScreenActivity
  extends MMActivity
  implements com.tencent.mm.plugin.sns.ui.d.a
{
  private SightVideoFullScreenView AIj;
  private LongVideoFullScreenView AIk;
  private g AIl;
  public ah AIm;
  private String AjE;
  private int AjF;
  private int AjG;
  private String AjH;
  private int AjI;
  private FrameLayout Apl;
  private boolean isWaiting;
  private int ivg;
  private boolean lVw;
  private int lxZ;
  private int lya;
  private String zQQ;
  private boolean zWP;
  private int zYx;
  
  private void a(ah paramah)
  {
    AppMethodBeat.i(220060);
    if ((paramah != null) && (this.Apl != null) && (this.AIl == null))
    {
      if ((bu.isNullOrNil(paramah.desc)) || (paramah.zRB == null))
      {
        AppMethodBeat.o(220060);
        return;
      }
      this.AIl = new g(this, paramah, this.Apl);
      if (getResources().getConfiguration().orientation != 1) {
        break label95;
      }
      this.AIl.ean();
    }
    for (;;)
    {
      se(false);
      AppMethodBeat.o(220060);
      return;
      label95:
      if (getResources().getConfiguration().orientation == 2) {
        this.AIl.eam();
      }
    }
  }
  
  public static af eal()
  {
    AppMethodBeat.i(220059);
    if (ad.zAi != null)
    {
      localaf = ad.zAi;
      AppMethodBeat.o(220059);
      return localaf;
    }
    af localaf = new af();
    AppMethodBeat.o(220059);
    return localaf;
  }
  
  private void se(boolean paramBoolean)
  {
    AppMethodBeat.i(220061);
    if (this.AIl != null)
    {
      ae.d("NonFullOrFullVideoType", "hideFloatBarView");
      this.AIl.rJ(paramBoolean);
    }
    AppMethodBeat.o(220061);
  }
  
  public void finish()
  {
    AppMethodBeat.i(220067);
    Intent localIntent = null;
    for (;;)
    {
      try
      {
        if (this.ivg != 0) {
          continue;
        }
        localIntent = this.AIj.eew();
        if ((this.AIl != null) && (localIntent != null))
        {
          this.AIl.dUM();
          localIntent.putExtra("KComponentFullVideoFloatBarReportInfo", this.AIl.eao());
        }
        setResult(1000, localIntent);
      }
      catch (Throwable localThrowable)
      {
        ae.e("NonFullOrFullVideoType", localThrowable.toString());
        continue;
      }
      super.finish();
      AppMethodBeat.o(220067);
      return;
      if (this.ivg == 1) {
        localIntent = this.AIk.edE();
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2131496133;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(220069);
    super.onConfigurationChanged(paramConfiguration);
    try
    {
      if (paramConfiguration.orientation == 2)
      {
        ae.i("NonFullOrFullVideoType", "ORIENTATION_LANDSCAPE");
        if (this.AIl != null)
        {
          this.AIl.eam();
          AppMethodBeat.o(220069);
        }
      }
      else if (paramConfiguration.orientation == 1)
      {
        ae.i("NonFullOrFullVideoType", "ORIENTATION_PORTRAIT");
        if (this.AIl != null) {
          this.AIl.ean();
        }
      }
      AppMethodBeat.o(220069);
      return;
    }
    catch (Throwable paramConfiguration)
    {
      ae.e("NonFullOrFullVideoType", paramConfiguration.toString());
      AppMethodBeat.o(220069);
    }
  }
  
  /* Error */
  public void onCreate(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc 192
    //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aload_1
    //   7: invokespecial 194	com/tencent/mm/ui/MMActivity:onCreate	(Landroid/os/Bundle;)V
    //   10: aload_0
    //   11: invokestatic 200	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:aH	(Landroid/app/Activity;)V
    //   14: aload_0
    //   15: getfield 204	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:mController	Lcom/tencent/mm/ui/s;
    //   18: invokevirtual 209	com/tencent/mm/ui/s:hideTitleView	()V
    //   21: aload_0
    //   22: aload_0
    //   23: invokevirtual 212	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   26: ldc 214
    //   28: iconst_0
    //   29: invokevirtual 218	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   32: putfield 133	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ivg	I
    //   35: aload_0
    //   36: aload_0
    //   37: invokevirtual 212	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   40: ldc 220
    //   42: invokevirtual 224	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   45: putfield 226	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AjE	Ljava/lang/String;
    //   48: aload_0
    //   49: aload_0
    //   50: invokevirtual 212	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   53: ldc 228
    //   55: iconst_0
    //   56: invokevirtual 218	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   59: putfield 230	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AjF	I
    //   62: aload_0
    //   63: aload_0
    //   64: invokevirtual 212	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   67: ldc 232
    //   69: iconst_0
    //   70: invokevirtual 218	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   73: putfield 234	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AjG	I
    //   76: aload_0
    //   77: aload_0
    //   78: invokevirtual 212	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   81: ldc 236
    //   83: iconst_0
    //   84: invokevirtual 240	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   87: putfield 242	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zWP	Z
    //   90: aload_0
    //   91: aload_0
    //   92: invokevirtual 212	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   95: ldc 244
    //   97: iconst_0
    //   98: invokevirtual 240	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   101: putfield 246	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:lVw	Z
    //   104: aload_0
    //   105: aload_0
    //   106: invokevirtual 212	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   109: ldc 248
    //   111: invokevirtual 224	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   114: putfield 250	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zQQ	Ljava/lang/String;
    //   117: aload_0
    //   118: aload_0
    //   119: invokevirtual 212	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   122: ldc 252
    //   124: invokevirtual 224	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   127: putfield 254	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AjH	Ljava/lang/String;
    //   130: aload_0
    //   131: aload_0
    //   132: invokevirtual 212	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   135: ldc_w 256
    //   138: iconst_0
    //   139: invokevirtual 240	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   142: putfield 258	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:isWaiting	Z
    //   145: aload_0
    //   146: aload_0
    //   147: invokevirtual 212	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   150: ldc_w 260
    //   153: iconst_0
    //   154: invokevirtual 218	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   157: putfield 262	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zYx	I
    //   160: aload_0
    //   161: aload_0
    //   162: invokevirtual 212	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   165: ldc_w 264
    //   168: iconst_0
    //   169: invokevirtual 218	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   172: putfield 266	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AjI	I
    //   175: ldc 116
    //   177: new 268	java/lang/StringBuilder
    //   180: dup
    //   181: ldc_w 270
    //   184: invokespecial 273	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   187: aload_0
    //   188: getfield 133	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ivg	I
    //   191: invokevirtual 277	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: ldc_w 279
    //   197: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload_0
    //   201: getfield 226	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AjE	Ljava/lang/String;
    //   204: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: ldc_w 284
    //   210: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_0
    //   214: getfield 230	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AjF	I
    //   217: invokevirtual 277	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   220: ldc_w 286
    //   223: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload_0
    //   227: getfield 234	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AjG	I
    //   230: invokevirtual 277	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   233: ldc_w 288
    //   236: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload_0
    //   240: getfield 242	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zWP	Z
    //   243: invokevirtual 291	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   246: ldc_w 293
    //   249: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload_0
    //   253: getfield 246	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:lVw	Z
    //   256: invokevirtual 291	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   259: ldc_w 295
    //   262: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload_0
    //   266: getfield 254	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AjH	Ljava/lang/String;
    //   269: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc_w 297
    //   275: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload_0
    //   279: getfield 258	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:isWaiting	Z
    //   282: invokevirtual 291	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   285: ldc_w 299
    //   288: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload_0
    //   292: getfield 262	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zYx	I
    //   295: invokevirtual 277	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   298: invokevirtual 300	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 187	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: aload_0
    //   305: invokestatic 304	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:gp	(Landroid/content/Context;)[I
    //   308: astore_1
    //   309: aload_0
    //   310: aload_1
    //   311: iconst_0
    //   312: iaload
    //   313: putfield 306	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:lxZ	I
    //   316: aload_0
    //   317: aload_1
    //   318: iconst_1
    //   319: iaload
    //   320: putfield 308	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:lya	I
    //   323: aload_0
    //   324: invokestatic 313	com/tencent/mm/ui/al:aH	(Landroid/content/Context;)Z
    //   327: ifeq +666 -> 993
    //   330: aload_0
    //   331: invokevirtual 80	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getResources	()Landroid/content/res/Resources;
    //   334: invokevirtual 86	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   337: getfield 91	android/content/res/Configuration:orientation	I
    //   340: iconst_1
    //   341: if_icmpne +652 -> 993
    //   344: aload_0
    //   345: aload_0
    //   346: getfield 308	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:lya	I
    //   349: aload_0
    //   350: invokestatic 317	com/tencent/mm/ui/al:aG	(Landroid/content/Context;)I
    //   353: isub
    //   354: putfield 308	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:lya	I
    //   357: ldc 116
    //   359: new 268	java/lang/StringBuilder
    //   362: dup
    //   363: ldc_w 319
    //   366: invokespecial 273	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   369: aload_0
    //   370: getfield 308	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:lya	I
    //   373: invokevirtual 277	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   376: ldc_w 321
    //   379: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: aload_0
    //   383: getfield 306	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:lxZ	I
    //   386: invokevirtual 277	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   389: invokevirtual 300	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 187	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   395: aload_0
    //   396: getfield 133	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ivg	I
    //   399: ifne +811 -> 1210
    //   402: aload_0
    //   403: aload_0
    //   404: ldc_w 322
    //   407: invokevirtual 326	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:findViewById	(I)Landroid/view/View;
    //   410: checkcast 328	android/widget/FrameLayout
    //   413: putfield 51	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Apl	Landroid/widget/FrameLayout;
    //   416: aload_0
    //   417: new 137	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView
    //   420: dup
    //   421: aload_0
    //   422: invokespecial 331	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:<init>	(Landroid/content/Context;)V
    //   425: putfield 135	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AIj	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   428: aload_0
    //   429: getfield 51	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Apl	Landroid/widget/FrameLayout;
    //   432: aload_0
    //   433: getfield 135	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AIj	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   436: invokevirtual 335	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   439: aload_0
    //   440: getfield 135	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AIj	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   443: astore_1
    //   444: aload_0
    //   445: getfield 306	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:lxZ	I
    //   448: istore_2
    //   449: aload_0
    //   450: getfield 308	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:lya	I
    //   453: istore_3
    //   454: iload_3
    //   455: iload_2
    //   456: if_icmplt +587 -> 1043
    //   459: aload_1
    //   460: iload_2
    //   461: putfield 336	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:lxZ	I
    //   464: aload_1
    //   465: iload_3
    //   466: putfield 337	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:lya	I
    //   469: aload_1
    //   470: aload_1
    //   471: getfield 341	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   474: bipush 32
    //   476: invokestatic 347	com/tencent/mm/cb/a:fromDPToPix	(Landroid/content/Context;I)I
    //   479: putfield 350	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:length	I
    //   482: aload_0
    //   483: getfield 135	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AIj	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   486: astore_1
    //   487: aload_0
    //   488: getfield 133	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ivg	I
    //   491: istore_2
    //   492: aload_0
    //   493: getfield 226	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AjE	Ljava/lang/String;
    //   496: astore 10
    //   498: aload_0
    //   499: getfield 230	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AjF	I
    //   502: istore_3
    //   503: aload_0
    //   504: getfield 234	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AjG	I
    //   507: istore 4
    //   509: aload_0
    //   510: getfield 242	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zWP	Z
    //   513: istore 7
    //   515: aload_0
    //   516: getfield 246	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:lVw	Z
    //   519: istore 8
    //   521: aload_0
    //   522: getfield 250	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zQQ	Ljava/lang/String;
    //   525: astore 11
    //   527: aload_0
    //   528: getfield 254	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AjH	Ljava/lang/String;
    //   531: astore 12
    //   533: aload_1
    //   534: iconst_1
    //   535: putfield 353	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:cBE	Z
    //   538: aload_1
    //   539: iconst_1
    //   540: putfield 356	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:isFirst	Z
    //   543: aload_1
    //   544: iload_2
    //   545: putfield 357	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:ivg	I
    //   548: aload_1
    //   549: aload 10
    //   551: putfield 358	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:AjE	Ljava/lang/String;
    //   554: aload_1
    //   555: iload_3
    //   556: putfield 359	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:AjF	I
    //   559: aload_1
    //   560: iload 4
    //   562: putfield 360	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:AjG	I
    //   565: aload_1
    //   566: iload 7
    //   568: putfield 361	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zWP	Z
    //   571: aload_1
    //   572: iload 8
    //   574: putfield 362	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:lVw	Z
    //   577: aload_1
    //   578: aload 11
    //   580: putfield 363	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zQQ	Ljava/lang/String;
    //   583: aload_1
    //   584: aload 12
    //   586: putfield 364	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:AjH	Ljava/lang/String;
    //   589: aload_0
    //   590: getfield 135	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AIj	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   593: astore_1
    //   594: aload_1
    //   595: aload_1
    //   596: getfield 341	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   599: invokestatic 370	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   602: ldc_w 371
    //   605: aload_1
    //   606: iconst_1
    //   607: invokevirtual 375	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   610: putfield 379	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   613: aload_1
    //   614: aload_1
    //   615: getfield 379	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   618: ldc_w 380
    //   621: invokevirtual 383	android/view/View:findViewById	(I)Landroid/view/View;
    //   624: checkcast 328	android/widget/FrameLayout
    //   627: putfield 386	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:AjA	Landroid/widget/FrameLayout;
    //   630: aload_1
    //   631: aload_1
    //   632: getfield 379	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   635: ldc_w 387
    //   638: invokevirtual 383	android/view/View:findViewById	(I)Landroid/view/View;
    //   641: putfield 390	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:AjB	Landroid/view/View;
    //   644: aload_1
    //   645: aload_1
    //   646: getfield 379	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   649: ldc_w 391
    //   652: invokevirtual 383	android/view/View:findViewById	(I)Landroid/view/View;
    //   655: putfield 394	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:AjC	Landroid/view/View;
    //   658: aload_1
    //   659: aload_1
    //   660: getfield 379	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   663: ldc_w 395
    //   666: invokevirtual 383	android/view/View:findViewById	(I)Landroid/view/View;
    //   669: checkcast 397	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar
    //   672: putfield 401	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zWG	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   675: aload_1
    //   676: new 403	com/tencent/mm/plugin/sns/ui/OfflineVideoView
    //   679: dup
    //   680: aload_1
    //   681: getfield 341	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   684: invokespecial 404	com/tencent/mm/plugin/sns/ui/OfflineVideoView:<init>	(Landroid/content/Context;)V
    //   687: putfield 408	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:AnC	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   690: aload_1
    //   691: getfield 408	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:AnC	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   694: iconst_1
    //   695: invokevirtual 411	com/tencent/mm/plugin/sns/ui/OfflineVideoView:setClickable	(Z)V
    //   698: aload_1
    //   699: getfield 408	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:AnC	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   702: aload_1
    //   703: invokevirtual 415	com/tencent/mm/plugin/sns/ui/OfflineVideoView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   706: aload_1
    //   707: getfield 386	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:AjA	Landroid/widget/FrameLayout;
    //   710: aload_1
    //   711: getfield 408	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:AnC	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   714: invokevirtual 335	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   717: aload_1
    //   718: getfield 401	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zWG	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   721: iconst_0
    //   722: invokevirtual 418	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setVisibility	(I)V
    //   725: aload_1
    //   726: getfield 401	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zWG	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   729: aload_1
    //   730: getfield 422	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zXc	Landroid/view/View$OnClickListener;
    //   733: invokevirtual 426	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setOnPlayButtonClickListener	(Landroid/view/View$OnClickListener;)V
    //   736: aload_1
    //   737: getfield 401	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zWG	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   740: aload_1
    //   741: getfield 430	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:rNx	Lcom/tencent/mm/plugin/sight/decode/ui/b;
    //   744: invokevirtual 434	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setIplaySeekCallback	(Lcom/tencent/mm/plugin/sight/decode/ui/b;)V
    //   747: aload_1
    //   748: aload_1
    //   749: ldc_w 435
    //   752: invokevirtual 436	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:findViewById	(I)Landroid/view/View;
    //   755: checkcast 438	android/widget/ImageView
    //   758: putfield 442	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zXO	Landroid/widget/ImageView;
    //   761: aload_1
    //   762: getfield 442	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zXO	Landroid/widget/ImageView;
    //   765: iconst_0
    //   766: invokevirtual 443	android/widget/ImageView:setVisibility	(I)V
    //   769: aload_1
    //   770: getfield 442	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zXO	Landroid/widget/ImageView;
    //   773: aload_1
    //   774: invokevirtual 446	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   777: aload_1
    //   778: aload_1
    //   779: ldc_w 447
    //   782: invokevirtual 436	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:findViewById	(I)Landroid/view/View;
    //   785: checkcast 438	android/widget/ImageView
    //   788: putfield 450	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zWH	Landroid/widget/ImageView;
    //   791: aload_1
    //   792: getfield 450	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zWH	Landroid/widget/ImageView;
    //   795: iconst_0
    //   796: invokevirtual 443	android/widget/ImageView:setVisibility	(I)V
    //   799: aload_1
    //   800: getfield 450	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zWH	Landroid/widget/ImageView;
    //   803: aload_1
    //   804: invokevirtual 446	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   807: aload_1
    //   808: aload_1
    //   809: getfield 379	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   812: ldc_w 451
    //   815: invokevirtual 383	android/view/View:findViewById	(I)Landroid/view/View;
    //   818: putfield 454	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zXP	Landroid/view/View;
    //   821: aload_1
    //   822: getfield 454	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zXP	Landroid/view/View;
    //   825: bipush 8
    //   827: invokevirtual 455	android/view/View:setVisibility	(I)V
    //   830: aload_1
    //   831: getfield 341	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   834: invokevirtual 458	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   837: invokevirtual 86	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   840: getfield 91	android/content/res/Configuration:orientation	I
    //   843: iconst_2
    //   844: if_icmpne +256 -> 1100
    //   847: ldc_w 460
    //   850: ldc 185
    //   852: invokestatic 187	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   855: aload_1
    //   856: invokevirtual 461	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:eam	()V
    //   859: aload_1
    //   860: getfield 401	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zWG	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   863: invokevirtual 464	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:getVideoTotalTime	()I
    //   866: aload_1
    //   867: getfield 360	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:AjG	I
    //   870: sipush 1000
    //   873: idiv
    //   874: if_icmpeq +18 -> 892
    //   877: aload_1
    //   878: getfield 401	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zWG	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   881: aload_1
    //   882: getfield 360	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:AjG	I
    //   885: sipush 1000
    //   888: idiv
    //   889: invokevirtual 467	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setVideoTotalTime	(I)V
    //   892: aload_1
    //   893: getfield 401	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:zWG	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   896: aload_1
    //   897: getfield 359	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:AjF	I
    //   900: sipush 1000
    //   903: idiv
    //   904: invokevirtual 470	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:seek	(I)V
    //   907: aload_1
    //   908: aload_1
    //   909: getfield 362	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:lVw	Z
    //   912: invokevirtual 473	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:rL	(Z)V
    //   915: aload_1
    //   916: getfield 408	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:AnC	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   919: new 475	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView$2
    //   922: dup
    //   923: aload_1
    //   924: invokespecial 478	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView$2:<init>	(Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;)V
    //   927: invokevirtual 482	com/tencent/mm/plugin/sns/ui/OfflineVideoView:setVideoCallback	(Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView$a;)V
    //   930: aload_1
    //   931: getfield 408	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:AnC	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   934: invokevirtual 485	com/tencent/mm/plugin/sns/ui/OfflineVideoView:cyW	()V
    //   937: aload_1
    //   938: iconst_1
    //   939: invokevirtual 488	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:setFocus	(Z)V
    //   942: aload_0
    //   943: getfield 135	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AIj	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   946: aload_0
    //   947: invokevirtual 492	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:setProgressBarStatusListener	(Lcom/tencent/mm/plugin/sns/ui/d/a;)V
    //   950: getstatic 498	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af$b:zYe	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u;
    //   953: ifnull +21 -> 974
    //   956: aload_0
    //   957: getstatic 498	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/af$b:zYe	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u;
    //   960: getfield 503	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:zRa	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ah;
    //   963: putfield 505	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AIm	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ah;
    //   966: aload_0
    //   967: aload_0
    //   968: getfield 505	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AIm	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ah;
    //   971: invokespecial 507	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:a	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ah;)V
    //   974: ldc 192
    //   976: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   979: return
    //   980: astore_1
    //   981: ldc 116
    //   983: aload_1
    //   984: invokevirtual 172	java/lang/Throwable:toString	()Ljava/lang/String;
    //   987: invokestatic 175	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   990: goto -686 -> 304
    //   993: aload_0
    //   994: invokestatic 313	com/tencent/mm/ui/al:aH	(Landroid/content/Context;)Z
    //   997: ifeq -640 -> 357
    //   1000: aload_0
    //   1001: invokevirtual 80	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getResources	()Landroid/content/res/Resources;
    //   1004: invokevirtual 86	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   1007: getfield 91	android/content/res/Configuration:orientation	I
    //   1010: iconst_2
    //   1011: if_icmpne -654 -> 357
    //   1014: aload_0
    //   1015: aload_0
    //   1016: getfield 306	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:lxZ	I
    //   1019: aload_0
    //   1020: invokestatic 317	com/tencent/mm/ui/al:aG	(Landroid/content/Context;)I
    //   1023: isub
    //   1024: putfield 306	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:lxZ	I
    //   1027: goto -670 -> 357
    //   1030: astore_1
    //   1031: ldc 116
    //   1033: aload_1
    //   1034: invokevirtual 172	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1037: invokestatic 175	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1040: goto -645 -> 395
    //   1043: aload_1
    //   1044: iload_2
    //   1045: putfield 337	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:lya	I
    //   1048: aload_1
    //   1049: iload_3
    //   1050: putfield 336	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:lxZ	I
    //   1053: goto -584 -> 469
    //   1056: astore_1
    //   1057: ldc_w 460
    //   1060: aload_1
    //   1061: invokevirtual 172	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1064: invokestatic 175	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1067: goto -585 -> 482
    //   1070: astore_1
    //   1071: ldc 116
    //   1073: aload_1
    //   1074: invokevirtual 172	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1077: invokestatic 175	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1080: ldc 192
    //   1082: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1085: return
    //   1086: astore_1
    //   1087: ldc_w 460
    //   1090: aload_1
    //   1091: invokevirtual 172	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1094: invokestatic 175	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1097: goto -508 -> 589
    //   1100: aload_1
    //   1101: getfield 341	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   1104: invokevirtual 458	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1107: invokevirtual 86	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   1110: getfield 91	android/content/res/Configuration:orientation	I
    //   1113: iconst_1
    //   1114: if_icmpne -255 -> 859
    //   1117: ldc_w 460
    //   1120: ldc 189
    //   1122: invokestatic 187	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1125: aload_1
    //   1126: invokevirtual 508	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:ean	()V
    //   1129: goto -270 -> 859
    //   1132: astore 10
    //   1134: ldc_w 460
    //   1137: aload 10
    //   1139: invokevirtual 172	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1142: invokestatic 175	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1145: goto -286 -> 859
    //   1148: astore_1
    //   1149: ldc_w 460
    //   1152: aload_1
    //   1153: invokevirtual 172	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1156: invokestatic 175	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1159: goto -217 -> 942
    //   1162: astore 10
    //   1164: ldc_w 460
    //   1167: aload 10
    //   1169: invokevirtual 172	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1172: invokestatic 175	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1175: goto -260 -> 915
    //   1178: astore 10
    //   1180: ldc_w 460
    //   1183: aload 10
    //   1185: invokevirtual 172	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1188: invokestatic 175	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1191: goto -261 -> 930
    //   1194: astore_1
    //   1195: ldc 116
    //   1197: aload_1
    //   1198: invokevirtual 172	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1201: invokestatic 175	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1204: ldc 192
    //   1206: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1209: return
    //   1210: aload_0
    //   1211: getfield 133	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ivg	I
    //   1214: iconst_1
    //   1215: if_icmpne +649 -> 1864
    //   1218: aload_0
    //   1219: aload_0
    //   1220: ldc_w 322
    //   1223: invokevirtual 326	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:findViewById	(I)Landroid/view/View;
    //   1226: checkcast 328	android/widget/FrameLayout
    //   1229: putfield 51	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Apl	Landroid/widget/FrameLayout;
    //   1232: aload_0
    //   1233: new 166	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView
    //   1236: dup
    //   1237: aload_0
    //   1238: invokespecial 509	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:<init>	(Landroid/content/Context;)V
    //   1241: putfield 164	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AIk	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1244: aload_0
    //   1245: getfield 51	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Apl	Landroid/widget/FrameLayout;
    //   1248: aload_0
    //   1249: getfield 164	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AIk	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1252: invokevirtual 335	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   1255: aload_0
    //   1256: getfield 164	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AIk	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1259: astore_1
    //   1260: aload_0
    //   1261: getfield 306	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:lxZ	I
    //   1264: istore_2
    //   1265: aload_0
    //   1266: getfield 308	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:lya	I
    //   1269: istore_3
    //   1270: iload_3
    //   1271: iload_2
    //   1272: if_icmplt +598 -> 1870
    //   1275: aload_1
    //   1276: iload_2
    //   1277: putfield 510	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:lxZ	I
    //   1280: aload_1
    //   1281: iload_3
    //   1282: putfield 511	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:lya	I
    //   1285: aload_1
    //   1286: aload_1
    //   1287: getfield 512	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mContext	Landroid/content/Context;
    //   1290: bipush 32
    //   1292: invokestatic 347	com/tencent/mm/cb/a:fromDPToPix	(Landroid/content/Context;I)I
    //   1295: putfield 513	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:length	I
    //   1298: aload_0
    //   1299: getfield 164	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AIk	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1302: astore_1
    //   1303: aload_0
    //   1304: getfield 133	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ivg	I
    //   1307: istore_2
    //   1308: aload_0
    //   1309: getfield 226	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AjE	Ljava/lang/String;
    //   1312: astore 10
    //   1314: aload_0
    //   1315: getfield 230	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AjF	I
    //   1318: istore_3
    //   1319: aload_0
    //   1320: getfield 234	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AjG	I
    //   1323: istore 4
    //   1325: aload_0
    //   1326: getfield 242	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zWP	Z
    //   1329: istore 7
    //   1331: aload_0
    //   1332: getfield 246	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:lVw	Z
    //   1335: istore 8
    //   1337: aload_0
    //   1338: getfield 250	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zQQ	Ljava/lang/String;
    //   1341: astore 11
    //   1343: aload_0
    //   1344: getfield 254	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AjH	Ljava/lang/String;
    //   1347: astore 12
    //   1349: aload_0
    //   1350: getfield 258	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:isWaiting	Z
    //   1353: istore 9
    //   1355: aload_0
    //   1356: getfield 262	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:zYx	I
    //   1359: istore 5
    //   1361: aload_0
    //   1362: getfield 266	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AjI	I
    //   1365: istore 6
    //   1367: aload_1
    //   1368: iconst_1
    //   1369: putfield 516	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:gHg	Z
    //   1372: aload_1
    //   1373: iconst_1
    //   1374: putfield 517	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:isFirst	Z
    //   1377: aload_1
    //   1378: iload_2
    //   1379: putfield 518	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:ivg	I
    //   1382: aload_1
    //   1383: aload 10
    //   1385: putfield 519	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:AjE	Ljava/lang/String;
    //   1388: aload_1
    //   1389: iload_3
    //   1390: putfield 520	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:AjF	I
    //   1393: aload_1
    //   1394: iload 4
    //   1396: putfield 521	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:AjG	I
    //   1399: aload_1
    //   1400: iload 7
    //   1402: putfield 522	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zWP	Z
    //   1405: aload_1
    //   1406: iload 8
    //   1408: putfield 523	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:lVw	Z
    //   1411: aload_1
    //   1412: aload 11
    //   1414: putfield 524	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zQQ	Ljava/lang/String;
    //   1417: aload_1
    //   1418: aload 12
    //   1420: putfield 525	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:AjH	Ljava/lang/String;
    //   1423: aload_1
    //   1424: iload 9
    //   1426: putfield 526	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:isWaiting	Z
    //   1429: aload_1
    //   1430: iload 5
    //   1432: putfield 527	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zYx	I
    //   1435: aload_1
    //   1436: iload 6
    //   1438: putfield 528	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:AjI	I
    //   1441: aload_0
    //   1442: getfield 164	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AIk	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1445: astore_1
    //   1446: aload_1
    //   1447: aload_1
    //   1448: getfield 512	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mContext	Landroid/content/Context;
    //   1451: invokestatic 370	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   1454: ldc_w 529
    //   1457: aload_1
    //   1458: iconst_1
    //   1459: invokevirtual 375	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   1462: putfield 530	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1465: aload_1
    //   1466: aload_1
    //   1467: getfield 530	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1470: ldc_w 380
    //   1473: invokevirtual 383	android/view/View:findViewById	(I)Landroid/view/View;
    //   1476: checkcast 328	android/widget/FrameLayout
    //   1479: putfield 531	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:AjA	Landroid/widget/FrameLayout;
    //   1482: aload_1
    //   1483: new 533	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper
    //   1486: dup
    //   1487: aload_1
    //   1488: getfield 512	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mContext	Landroid/content/Context;
    //   1491: invokespecial 534	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:<init>	(Landroid/content/Context;)V
    //   1494: putfield 538	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:AjD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1497: aload_1
    //   1498: getfield 531	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:AjA	Landroid/widget/FrameLayout;
    //   1501: aload_1
    //   1502: getfield 538	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:AjD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1505: invokevirtual 335	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   1508: aload_1
    //   1509: getfield 538	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:AjD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1512: aload_1
    //   1513: invokevirtual 542	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setIMMVideoViewCallback	(Lcom/tencent/mm/pluginsdk/ui/i$b;)V
    //   1516: aload_1
    //   1517: getfield 538	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:AjD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1520: iconst_1
    //   1521: invokevirtual 545	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setFullScreen	(Z)V
    //   1524: aload_1
    //   1525: getfield 538	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:AjD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1528: iconst_0
    //   1529: aload_1
    //   1530: getfield 525	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:AjH	Ljava/lang/String;
    //   1533: iconst_0
    //   1534: invokevirtual 549	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:c	(ZLjava/lang/String;I)V
    //   1537: aload_1
    //   1538: getfield 538	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:AjD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1541: iconst_1
    //   1542: invokevirtual 550	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setClickable	(Z)V
    //   1545: aload_1
    //   1546: getfield 538	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:AjD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1549: aload_1
    //   1550: invokevirtual 551	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   1553: aload_1
    //   1554: getfield 538	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:AjD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1557: iconst_1
    //   1558: invokevirtual 554	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setLoop	(Z)V
    //   1561: aload_1
    //   1562: getfield 538	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:AjD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1565: aload_1
    //   1566: invokevirtual 558	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setLoopCompletionCallback	(Lcom/tencent/mm/pluginsdk/ui/i$d;)V
    //   1569: aload_1
    //   1570: aload_1
    //   1571: getfield 530	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1574: ldc_w 387
    //   1577: invokevirtual 383	android/view/View:findViewById	(I)Landroid/view/View;
    //   1580: putfield 559	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:AjB	Landroid/view/View;
    //   1583: aload_1
    //   1584: aload_1
    //   1585: getfield 530	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1588: ldc_w 391
    //   1591: invokevirtual 383	android/view/View:findViewById	(I)Landroid/view/View;
    //   1594: putfield 560	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:AjC	Landroid/view/View;
    //   1597: aload_1
    //   1598: aload_1
    //   1599: getfield 530	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1602: ldc_w 395
    //   1605: invokevirtual 383	android/view/View:findViewById	(I)Landroid/view/View;
    //   1608: checkcast 397	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar
    //   1611: putfield 561	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zWG	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1614: aload_1
    //   1615: getfield 561	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zWG	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1618: iconst_0
    //   1619: invokevirtual 418	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setVisibility	(I)V
    //   1622: aload_1
    //   1623: getfield 561	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zWG	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1626: aload_1
    //   1627: getfield 562	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zXc	Landroid/view/View$OnClickListener;
    //   1630: invokevirtual 426	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setOnPlayButtonClickListener	(Landroid/view/View$OnClickListener;)V
    //   1633: aload_1
    //   1634: getfield 561	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zWG	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1637: aload_1
    //   1638: getfield 563	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:rNx	Lcom/tencent/mm/plugin/sight/decode/ui/b;
    //   1641: invokevirtual 434	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setIplaySeekCallback	(Lcom/tencent/mm/plugin/sight/decode/ui/b;)V
    //   1644: aload_1
    //   1645: aload_1
    //   1646: ldc_w 435
    //   1649: invokevirtual 564	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:findViewById	(I)Landroid/view/View;
    //   1652: checkcast 438	android/widget/ImageView
    //   1655: putfield 565	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zXO	Landroid/widget/ImageView;
    //   1658: aload_1
    //   1659: getfield 565	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zXO	Landroid/widget/ImageView;
    //   1662: iconst_0
    //   1663: invokevirtual 443	android/widget/ImageView:setVisibility	(I)V
    //   1666: aload_1
    //   1667: getfield 565	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zXO	Landroid/widget/ImageView;
    //   1670: aload_1
    //   1671: invokevirtual 446	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1674: aload_1
    //   1675: aload_1
    //   1676: ldc_w 447
    //   1679: invokevirtual 564	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:findViewById	(I)Landroid/view/View;
    //   1682: checkcast 438	android/widget/ImageView
    //   1685: putfield 566	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zWH	Landroid/widget/ImageView;
    //   1688: aload_1
    //   1689: getfield 566	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zWH	Landroid/widget/ImageView;
    //   1692: iconst_0
    //   1693: invokevirtual 443	android/widget/ImageView:setVisibility	(I)V
    //   1696: aload_1
    //   1697: getfield 566	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zWH	Landroid/widget/ImageView;
    //   1700: aload_1
    //   1701: invokevirtual 446	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1704: aload_1
    //   1705: aload_1
    //   1706: getfield 530	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1709: ldc_w 451
    //   1712: invokevirtual 383	android/view/View:findViewById	(I)Landroid/view/View;
    //   1715: putfield 567	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zXP	Landroid/view/View;
    //   1718: aload_1
    //   1719: getfield 567	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zXP	Landroid/view/View;
    //   1722: bipush 8
    //   1724: invokevirtual 455	android/view/View:setVisibility	(I)V
    //   1727: aload_1
    //   1728: getfield 561	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zWG	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1731: invokevirtual 571	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:getParent	()Landroid/view/ViewParent;
    //   1734: astore 10
    //   1736: aload 10
    //   1738: instanceof 573
    //   1741: ifeq +15 -> 1756
    //   1744: aload 10
    //   1746: checkcast 573	android/view/ViewGroup
    //   1749: aload_1
    //   1750: getfield 561	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zWG	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1753: invokevirtual 576	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   1756: aload_1
    //   1757: getfield 538	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:AjD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1760: aload_1
    //   1761: getfield 561	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zWG	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1764: invokevirtual 580	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setVideoFooterView	(Lcom/tencent/mm/pluginsdk/ui/h;)V
    //   1767: aload_1
    //   1768: getfield 512	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mContext	Landroid/content/Context;
    //   1771: invokevirtual 458	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1774: invokevirtual 86	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   1777: getfield 91	android/content/res/Configuration:orientation	I
    //   1780: iconst_2
    //   1781: if_icmpne +160 -> 1941
    //   1784: ldc_w 582
    //   1787: ldc 185
    //   1789: invokestatic 187	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1792: aload_1
    //   1793: invokevirtual 583	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:eam	()V
    //   1796: aload_1
    //   1797: getfield 522	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:zWP	Z
    //   1800: ifeq +189 -> 1989
    //   1803: aload_1
    //   1804: invokevirtual 586	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:dZN	()V
    //   1807: aload_1
    //   1808: invokevirtual 589	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:cbC	()V
    //   1811: aload_1
    //   1812: iconst_1
    //   1813: invokevirtual 590	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:setFocus	(Z)V
    //   1816: aload_0
    //   1817: getfield 164	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AIk	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1820: aload_0
    //   1821: invokevirtual 591	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:setProgressBarStatusListener	(Lcom/tencent/mm/plugin/sns/ui/d/a;)V
    //   1824: getstatic 597	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj$a:zYC	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ak;
    //   1827: ifnull +21 -> 1848
    //   1830: aload_0
    //   1831: getstatic 597	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj$a:zYC	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ak;
    //   1834: getfield 600	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ak:zRa	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ah;
    //   1837: putfield 505	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AIm	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ah;
    //   1840: aload_0
    //   1841: aload_0
    //   1842: getfield 505	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:AIm	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ah;
    //   1845: invokespecial 507	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:a	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ah;)V
    //   1848: ldc 192
    //   1850: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1853: return
    //   1854: astore_1
    //   1855: ldc 116
    //   1857: aload_1
    //   1858: invokevirtual 172	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1861: invokestatic 175	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1864: ldc 192
    //   1866: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1869: return
    //   1870: aload_1
    //   1871: iload_2
    //   1872: putfield 511	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:lya	I
    //   1875: aload_1
    //   1876: iload_3
    //   1877: putfield 510	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:lxZ	I
    //   1880: goto -595 -> 1285
    //   1883: astore_1
    //   1884: ldc_w 582
    //   1887: aload_1
    //   1888: invokevirtual 172	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1891: invokestatic 175	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1894: goto -596 -> 1298
    //   1897: astore_1
    //   1898: ldc_w 582
    //   1901: aload_1
    //   1902: invokevirtual 172	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1905: invokestatic 175	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1908: goto -467 -> 1441
    //   1911: astore 10
    //   1913: ldc_w 582
    //   1916: aload 10
    //   1918: invokevirtual 172	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1921: invokestatic 175	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1924: goto -355 -> 1569
    //   1927: astore_1
    //   1928: ldc_w 582
    //   1931: aload_1
    //   1932: invokevirtual 172	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1935: invokestatic 175	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1938: goto -122 -> 1816
    //   1941: aload_1
    //   1942: getfield 512	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mContext	Landroid/content/Context;
    //   1945: invokevirtual 458	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1948: invokevirtual 86	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   1951: getfield 91	android/content/res/Configuration:orientation	I
    //   1954: iconst_1
    //   1955: if_icmpne -159 -> 1796
    //   1958: ldc_w 582
    //   1961: ldc 189
    //   1963: invokestatic 187	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1966: aload_1
    //   1967: invokevirtual 601	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:ean	()V
    //   1970: goto -174 -> 1796
    //   1973: astore 10
    //   1975: ldc_w 582
    //   1978: aload 10
    //   1980: invokevirtual 172	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1983: invokestatic 175	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1986: goto -190 -> 1796
    //   1989: aload_1
    //   1990: invokevirtual 604	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:dZP	()V
    //   1993: goto -186 -> 1807
    //   1996: astore 10
    //   1998: ldc_w 582
    //   2001: aload 10
    //   2003: invokevirtual 172	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2006: invokestatic 175	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2009: goto -198 -> 1811
    //   2012: astore_1
    //   2013: ldc 116
    //   2015: aload_1
    //   2016: invokevirtual 172	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2019: invokestatic 175	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2022: ldc 192
    //   2024: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2027: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2028	0	this	VideoFullScreenActivity
    //   0	2028	1	paramBundle	android.os.Bundle
    //   448	1424	2	i	int
    //   453	1424	3	j	int
    //   507	888	4	k	int
    //   1359	72	5	m	int
    //   1365	72	6	n	int
    //   513	888	7	bool1	boolean
    //   519	888	8	bool2	boolean
    //   1353	72	9	bool3	boolean
    //   496	54	10	str1	String
    //   1132	6	10	localThrowable1	Throwable
    //   1162	6	10	localThrowable2	Throwable
    //   1178	6	10	localThrowable3	Throwable
    //   1312	433	10	localObject	java.lang.Object
    //   1911	6	10	localThrowable4	Throwable
    //   1973	6	10	localThrowable5	Throwable
    //   1996	6	10	localThrowable6	Throwable
    //   525	888	11	str2	String
    //   531	888	12	str3	String
    // Exception table:
    //   from	to	target	type
    //   21	304	980	java/lang/Throwable
    //   304	357	1030	java/lang/Throwable
    //   357	395	1030	java/lang/Throwable
    //   993	1027	1030	java/lang/Throwable
    //   459	469	1056	java/lang/Throwable
    //   469	482	1056	java/lang/Throwable
    //   1043	1053	1056	java/lang/Throwable
    //   402	454	1070	java/lang/Throwable
    //   482	533	1070	java/lang/Throwable
    //   589	594	1070	java/lang/Throwable
    //   942	950	1070	java/lang/Throwable
    //   974	979	1070	java/lang/Throwable
    //   1057	1067	1070	java/lang/Throwable
    //   1087	1097	1070	java/lang/Throwable
    //   1149	1159	1070	java/lang/Throwable
    //   1195	1204	1070	java/lang/Throwable
    //   533	589	1086	java/lang/Throwable
    //   594	859	1132	java/lang/Throwable
    //   1100	1129	1132	java/lang/Throwable
    //   930	942	1148	java/lang/Throwable
    //   1134	1145	1148	java/lang/Throwable
    //   1164	1175	1148	java/lang/Throwable
    //   1180	1191	1148	java/lang/Throwable
    //   859	892	1162	java/lang/Throwable
    //   892	915	1162	java/lang/Throwable
    //   915	930	1178	java/lang/Throwable
    //   950	974	1194	java/lang/Throwable
    //   1218	1270	1854	java/lang/Throwable
    //   1298	1367	1854	java/lang/Throwable
    //   1441	1446	1854	java/lang/Throwable
    //   1816	1824	1854	java/lang/Throwable
    //   1848	1853	1854	java/lang/Throwable
    //   1884	1894	1854	java/lang/Throwable
    //   1898	1908	1854	java/lang/Throwable
    //   1928	1938	1854	java/lang/Throwable
    //   2013	2022	1854	java/lang/Throwable
    //   1275	1285	1883	java/lang/Throwable
    //   1285	1298	1883	java/lang/Throwable
    //   1870	1880	1883	java/lang/Throwable
    //   1367	1441	1897	java/lang/Throwable
    //   1446	1569	1911	java/lang/Throwable
    //   1811	1816	1927	java/lang/Throwable
    //   1913	1924	1927	java/lang/Throwable
    //   1975	1986	1927	java/lang/Throwable
    //   1998	2009	1927	java/lang/Throwable
    //   1569	1756	1973	java/lang/Throwable
    //   1756	1796	1973	java/lang/Throwable
    //   1941	1970	1973	java/lang/Throwable
    //   1796	1807	1996	java/lang/Throwable
    //   1807	1811	1996	java/lang/Throwable
    //   1989	1993	1996	java/lang/Throwable
    //   1824	1848	2012	java/lang/Throwable
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(220066);
    for (;;)
    {
      try
      {
        ad.zAi = null;
        if (this.ivg != 0) {
          continue;
        }
        localSightVideoFullScreenView = this.AIj;
      }
      catch (Throwable localThrowable2)
      {
        SightVideoFullScreenView localSightVideoFullScreenView;
        ae.e("NonFullOrFullVideoType", localThrowable2.toString());
        continue;
        if (this.ivg != 1) {
          continue;
        }
        localLongVideoFullScreenView = this.AIk;
      }
      try
      {
        ar.ay(localSightVideoFullScreenView.zWL);
        ar.ay(localSightVideoFullScreenView.zXR);
        localSightVideoFullScreenView.AnC.onDestroy();
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.af.b.zYe = null;
        super.onDestroy();
        AppMethodBeat.o(220066);
        return;
      }
      catch (Throwable localThrowable1)
      {
        ae.e("SightVideoFullScreenView", localThrowable1.toString());
        continue;
      }
      try
      {
        LongVideoFullScreenView localLongVideoFullScreenView;
        ar.ay(localLongVideoFullScreenView.zWL);
        ar.ay(localLongVideoFullScreenView.zXR);
        localLongVideoFullScreenView.AjD.onUIDestroy();
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aj.a.zYC = null;
      }
      catch (Throwable localThrowable3)
      {
        for (;;)
        {
          ae.e("LongVideoFullScreenView", localThrowable3.toString());
        }
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(220064);
    super.onPause();
    try
    {
      if (this.ivg == 0)
      {
        SightVideoFullScreenView localSightVideoFullScreenView = this.AIj;
        try
        {
          localSightVideoFullScreenView.zPy = false;
          ar.ay(localSightVideoFullScreenView.zWL);
          ar.ay(localSightVideoFullScreenView.zXR);
          AppMethodBeat.o(220064);
          return;
        }
        catch (Throwable localThrowable1)
        {
          ae.e("SightVideoFullScreenView", localThrowable1.toString());
          AppMethodBeat.o(220064);
          return;
        }
      }
      if (this.ivg != 1) {
        break label133;
      }
    }
    catch (Throwable localThrowable2)
    {
      ae.e("NonFullOrFullVideoType", localThrowable2.toString());
      AppMethodBeat.o(220064);
      return;
    }
    LongVideoFullScreenView localLongVideoFullScreenView = this.AIk;
    try
    {
      localLongVideoFullScreenView.zPy = false;
      ar.ay(localLongVideoFullScreenView.zWL);
      ar.ay(localLongVideoFullScreenView.zXR);
      AppMethodBeat.o(220064);
      return;
    }
    catch (Throwable localThrowable3)
    {
      ae.e("LongVideoFullScreenView", localThrowable3.toString());
    }
    label133:
    AppMethodBeat.o(220064);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(220063);
    super.onResume();
    try
    {
      an.aH(this);
      if (this.ivg == 0)
      {
        this.AIj.zPy = true;
        AppMethodBeat.o(220063);
        return;
      }
      if (this.ivg == 1) {
        this.AIk.zPy = true;
      }
      AppMethodBeat.o(220063);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("NonFullOrFullVideoType", localThrowable.toString());
      AppMethodBeat.o(220063);
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(220062);
    super.onStart();
    try
    {
      an.aH(this);
      if (this.ivg == 0)
      {
        SightVideoFullScreenView localSightVideoFullScreenView = this.AIj;
        try
        {
          if ((!localSightVideoFullScreenView.isFirst) && (!localSightVideoFullScreenView.AnC.isPlaying()) && (localSightVideoFullScreenView.AjL))
          {
            localSightVideoFullScreenView.eeu();
            localSightVideoFullScreenView.AjL = false;
          }
          localSightVideoFullScreenView.isFirst = false;
          AppMethodBeat.o(220062);
          return;
        }
        catch (Throwable localThrowable1)
        {
          ae.e("SightVideoFullScreenView", localThrowable1.toString());
          AppMethodBeat.o(220062);
          return;
        }
      }
      if (this.ivg != 1) {
        break label175;
      }
    }
    catch (Throwable localThrowable2)
    {
      ae.e("NonFullOrFullVideoType", localThrowable2.toString());
      AppMethodBeat.o(220062);
      return;
    }
    LongVideoFullScreenView localLongVideoFullScreenView = this.AIk;
    try
    {
      if ((!localLongVideoFullScreenView.isFirst) && (!localLongVideoFullScreenView.AjD.isPlaying()) && (localLongVideoFullScreenView.AjL))
      {
        localLongVideoFullScreenView.cbC();
        localLongVideoFullScreenView.AjL = false;
      }
      localLongVideoFullScreenView.isFirst = false;
      AppMethodBeat.o(220062);
      return;
    }
    catch (Throwable localThrowable3)
    {
      ae.e("LongVideoFullScreenView", localThrowable3.toString());
    }
    label175:
    AppMethodBeat.o(220062);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(220065);
    super.onStop();
    try
    {
      if (this.ivg == 0)
      {
        SightVideoFullScreenView localSightVideoFullScreenView = this.AIj;
        try
        {
          localSightVideoFullScreenView.isFirst = false;
          if (localSightVideoFullScreenView.AnC.isPlaying())
          {
            localSightVideoFullScreenView.eev();
            localSightVideoFullScreenView.AjL = true;
          }
          AppMethodBeat.o(220065);
          return;
        }
        catch (Throwable localThrowable1)
        {
          ae.e("SightVideoFullScreenView", localThrowable1.toString());
          AppMethodBeat.o(220065);
          return;
        }
      }
      if (this.ivg != 1) {
        break label143;
      }
    }
    catch (Throwable localThrowable2)
    {
      ae.e("NonFullOrFullVideoType", localThrowable2.toString());
      AppMethodBeat.o(220065);
      return;
    }
    LongVideoFullScreenView localLongVideoFullScreenView = this.AIk;
    try
    {
      localLongVideoFullScreenView.isFirst = false;
      if (localLongVideoFullScreenView.AjD.isPlaying())
      {
        localLongVideoFullScreenView.cyX();
        localLongVideoFullScreenView.AjL = true;
      }
      AppMethodBeat.o(220065);
      return;
    }
    catch (Throwable localThrowable3)
    {
      ae.e("LongVideoFullScreenView", localThrowable3.toString());
    }
    label143:
    AppMethodBeat.o(220065);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setMMOrientation() {}
  
  public final void sf(boolean paramBoolean)
  {
    AppMethodBeat.i(220068);
    ae.i("NonFullOrFullVideoType", "progressBarStatus visiblity = ".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      se(true);
      AppMethodBeat.o(220068);
      return;
    }
    if (this.AIl != null)
    {
      ae.d("NonFullOrFullVideoType", "showFloatBarView");
      this.AIl.eak();
    }
    AppMethodBeat.o(220068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.VideoFullScreenActivity
 * JD-Core Version:    0.7.0.1
 */