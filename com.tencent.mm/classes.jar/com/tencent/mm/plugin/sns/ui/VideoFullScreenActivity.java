package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ao;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(32)
public class VideoFullScreenActivity
  extends MMActivity
  implements com.tencent.mm.plugin.sns.ui.d.a
{
  private boolean JAS;
  private g JCx;
  private String KFI;
  private int KFJ;
  private int KFK;
  private String KFL;
  private int KFM;
  private FrameLayout KLO;
  public ak Klr;
  private String Kmm;
  private int KtV;
  private SightVideoFullScreenView Lgl;
  private LongVideoFullScreenView Lgm;
  private boolean Lgn;
  private boolean fGh;
  private long fOa = 0L;
  private boolean isWaiting;
  private int mfT;
  private int pEj;
  private int pEk;
  private long startTime = 0L;
  
  private void a(ak paramak)
  {
    AppMethodBeat.i(264666);
    if ((paramak != null) && (this.KLO != null) && (this.JCx == null))
    {
      if ((Util.isNullOrNil(paramak.desc)) || (paramak.Knc == null))
      {
        AppMethodBeat.o(264666);
        return;
      }
      this.JCx = new g(this, paramak, this.KLO, 0);
      if (getResources().getConfiguration().orientation != 1) {
        break label96;
      }
      this.JCx.fQX();
    }
    for (;;)
    {
      ze(false);
      AppMethodBeat.o(264666);
      return;
      label96:
      if (getResources().getConfiguration().orientation == 2) {
        this.JCx.fQW();
      }
    }
  }
  
  public static ai fQU()
  {
    AppMethodBeat.i(264665);
    if (ae.JWV != null)
    {
      localai = ae.JWV;
      AppMethodBeat.o(264665);
      return localai;
    }
    ai localai = new ai();
    AppMethodBeat.o(264665);
    return localai;
  }
  
  private void ze(boolean paramBoolean)
  {
    AppMethodBeat.i(264668);
    if (this.JCx != null)
    {
      Log.d("VideoFullScreenActivity", "hideFloatBarView");
      this.JCx.yL(paramBoolean);
    }
    AppMethodBeat.o(264668);
  }
  
  public void finish()
  {
    AppMethodBeat.i(264689);
    Intent localIntent = null;
    for (;;)
    {
      try
      {
        if (this.mfT != 0) {
          continue;
        }
        localIntent = this.Lgl.fUU();
        if (localIntent != null)
        {
          this.fOa += System.currentTimeMillis() - this.startTime;
          localIntent.putExtra("KComponentFullScreenStayTime", this.fOa);
          if (this.JCx != null)
          {
            this.JCx.fKo();
            localIntent.putExtra("KComponentFullVideoFloatBarReportInfo", this.JCx.fQY());
          }
        }
        setResult(1000, localIntent);
      }
      catch (Throwable localThrowable)
      {
        Log.e("VideoFullScreenActivity", localThrowable.toString());
        continue;
      }
      super.finish();
      AppMethodBeat.o(264689);
      return;
      if (this.mfT == 1) {
        localIntent = this.Lgm.fTT();
      }
    }
  }
  
  public int getLayoutId()
  {
    return i.g.activity_video_full_screen;
  }
  
  public void onCancel()
  {
    AppMethodBeat.i(264697);
    super.onCancel();
    setRequestedOrientation(4);
    AppMethodBeat.o(264697);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(264694);
    super.onConfigurationChanged(paramConfiguration);
    try
    {
      if (paramConfiguration.orientation == 2)
      {
        Log.i("VideoFullScreenActivity", "ORIENTATION_LANDSCAPE");
        if (this.JCx != null)
        {
          this.JCx.fQW();
          AppMethodBeat.o(264694);
        }
      }
      else if (paramConfiguration.orientation == 1)
      {
        Log.i("VideoFullScreenActivity", "ORIENTATION_PORTRAIT");
        if (this.JCx != null) {
          this.JCx.fQX();
        }
      }
      AppMethodBeat.o(264694);
      return;
    }
    catch (Throwable paramConfiguration)
    {
      Log.e("VideoFullScreenActivity", paramConfiguration.toString());
      AppMethodBeat.o(264694);
    }
  }
  
  /* Error */
  public void onCreate(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc 224
    //   2: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aload_1
    //   7: invokespecial 226	com/tencent/mm/ui/MMActivity:onCreate	(Landroid/os/Bundle;)V
    //   10: aload_0
    //   11: invokestatic 157	java/lang/System:currentTimeMillis	()J
    //   14: putfield 47	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:startTime	J
    //   17: aload_0
    //   18: invokestatic 232	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ao:aR	(Landroid/app/Activity;)V
    //   21: aload_0
    //   22: getfield 236	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:mController	Lcom/tencent/mm/ui/w;
    //   25: invokevirtual 241	com/tencent/mm/ui/w:hideTitleView	()V
    //   28: aload_0
    //   29: aload_0
    //   30: invokevirtual 244	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   33: ldc 246
    //   35: iconst_0
    //   36: invokevirtual 250	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   39: putfield 143	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:mfT	I
    //   42: aload_0
    //   43: aload_0
    //   44: invokevirtual 244	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   47: ldc 252
    //   49: invokevirtual 256	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   52: putfield 258	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:KFI	Ljava/lang/String;
    //   55: aload_0
    //   56: aload_0
    //   57: invokevirtual 244	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   60: ldc_w 260
    //   63: iconst_0
    //   64: invokevirtual 250	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   67: putfield 262	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:KFJ	I
    //   70: aload_0
    //   71: aload_0
    //   72: invokevirtual 244	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   75: ldc_w 264
    //   78: iconst_0
    //   79: invokevirtual 250	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   82: putfield 266	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:KFK	I
    //   85: aload_0
    //   86: aload_0
    //   87: invokevirtual 244	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   90: ldc_w 268
    //   93: iconst_0
    //   94: invokevirtual 272	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   97: putfield 274	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:JAS	Z
    //   100: aload_0
    //   101: aload_0
    //   102: invokevirtual 244	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   105: ldc_w 276
    //   108: iconst_0
    //   109: invokevirtual 272	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   112: putfield 278	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:fGh	Z
    //   115: aload_0
    //   116: aload_0
    //   117: invokevirtual 244	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   120: ldc_w 280
    //   123: invokevirtual 256	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   126: putfield 282	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Kmm	Ljava/lang/String;
    //   129: aload_0
    //   130: aload_0
    //   131: invokevirtual 244	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   134: ldc_w 284
    //   137: invokevirtual 256	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   140: putfield 286	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:KFL	Ljava/lang/String;
    //   143: aload_0
    //   144: aload_0
    //   145: invokevirtual 244	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   148: ldc_w 288
    //   151: iconst_0
    //   152: invokevirtual 272	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   155: putfield 290	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:isWaiting	Z
    //   158: aload_0
    //   159: aload_0
    //   160: invokevirtual 244	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   163: ldc_w 292
    //   166: iconst_0
    //   167: invokevirtual 250	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   170: putfield 294	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:KtV	I
    //   173: aload_0
    //   174: aload_0
    //   175: invokevirtual 244	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   178: ldc_w 296
    //   181: iconst_0
    //   182: invokevirtual 250	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   185: putfield 298	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:KFM	I
    //   188: aload_0
    //   189: aload_0
    //   190: invokevirtual 244	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   193: ldc_w 300
    //   196: iconst_0
    //   197: invokevirtual 272	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   200: putfield 302	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Lgn	Z
    //   203: ldc 126
    //   205: new 304	java/lang/StringBuilder
    //   208: dup
    //   209: ldc_w 306
    //   212: invokespecial 309	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   215: aload_0
    //   216: getfield 143	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:mfT	I
    //   219: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   222: ldc_w 315
    //   225: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload_0
    //   229: getfield 258	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:KFI	Ljava/lang/String;
    //   232: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: ldc_w 320
    //   238: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload_0
    //   242: getfield 262	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:KFJ	I
    //   245: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: ldc_w 322
    //   251: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload_0
    //   255: getfield 266	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:KFK	I
    //   258: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   261: ldc_w 324
    //   264: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_0
    //   268: getfield 274	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:JAS	Z
    //   271: invokevirtual 327	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   274: ldc_w 329
    //   277: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload_0
    //   281: getfield 278	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:fGh	Z
    //   284: invokevirtual 327	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   287: ldc_w 331
    //   290: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload_0
    //   294: getfield 286	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:KFL	Ljava/lang/String;
    //   297: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: ldc_w 333
    //   303: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload_0
    //   307: getfield 290	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:isWaiting	Z
    //   310: invokevirtual 327	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   313: ldc_w 335
    //   316: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload_0
    //   320: getfield 294	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:KtV	I
    //   323: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   326: ldc_w 337
    //   329: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload_0
    //   333: getfield 302	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Lgn	Z
    //   336: invokevirtual 327	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   339: invokevirtual 338	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 219	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: aload_0
    //   346: getfield 143	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:mfT	I
    //   349: iconst_1
    //   350: if_icmpne +29 -> 379
    //   353: aload_0
    //   354: getfield 302	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Lgn	Z
    //   357: ifeq +22 -> 379
    //   360: aload_0
    //   361: iconst_0
    //   362: invokevirtual 210	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:setRequestedOrientation	(I)V
    //   365: new 8	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity$1
    //   368: dup
    //   369: aload_0
    //   370: invokespecial 341	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity$1:<init>	(Lcom/tencent/mm/plugin/sns/ui/VideoFullScreenActivity;)V
    //   373: ldc2_w 342
    //   376: invokestatic 349	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThreadDelayed	(Ljava/lang/Runnable;J)V
    //   379: aload_0
    //   380: invokestatic 353	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ao:ib	(Landroid/content/Context;)[I
    //   383: astore_1
    //   384: aload_0
    //   385: aload_1
    //   386: iconst_0
    //   387: iaload
    //   388: putfield 355	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:pEj	I
    //   391: aload_0
    //   392: aload_1
    //   393: iconst_1
    //   394: iaload
    //   395: putfield 357	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:pEk	I
    //   398: aload_0
    //   399: invokestatic 363	com/tencent/mm/ui/ar:aN	(Landroid/content/Context;)Z
    //   402: ifeq +666 -> 1068
    //   405: aload_0
    //   406: invokevirtual 90	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getResources	()Landroid/content/res/Resources;
    //   409: invokevirtual 96	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   412: getfield 101	android/content/res/Configuration:orientation	I
    //   415: iconst_1
    //   416: if_icmpne +652 -> 1068
    //   419: aload_0
    //   420: aload_0
    //   421: getfield 357	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:pEk	I
    //   424: aload_0
    //   425: invokestatic 367	com/tencent/mm/ui/ar:aM	(Landroid/content/Context;)I
    //   428: isub
    //   429: putfield 357	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:pEk	I
    //   432: ldc 126
    //   434: new 304	java/lang/StringBuilder
    //   437: dup
    //   438: ldc_w 369
    //   441: invokespecial 309	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   444: aload_0
    //   445: getfield 357	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:pEk	I
    //   448: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   451: ldc_w 371
    //   454: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: aload_0
    //   458: getfield 355	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:pEj	I
    //   461: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   464: invokevirtual 338	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokestatic 219	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   470: aload_0
    //   471: getfield 143	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:mfT	I
    //   474: ifne +811 -> 1285
    //   477: aload_0
    //   478: aload_0
    //   479: getstatic 376	com/tencent/mm/plugin/sns/i$f:root	I
    //   482: invokevirtual 380	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:findViewById	(I)Landroid/view/View;
    //   485: checkcast 382	android/widget/FrameLayout
    //   488: putfield 61	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:KLO	Landroid/widget/FrameLayout;
    //   491: aload_0
    //   492: new 147	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView
    //   495: dup
    //   496: aload_0
    //   497: invokespecial 385	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:<init>	(Landroid/content/Context;)V
    //   500: putfield 145	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Lgl	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   503: aload_0
    //   504: getfield 61	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:KLO	Landroid/widget/FrameLayout;
    //   507: aload_0
    //   508: getfield 145	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Lgl	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   511: invokevirtual 389	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   514: aload_0
    //   515: getfield 145	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Lgl	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   518: astore_1
    //   519: aload_0
    //   520: getfield 355	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:pEj	I
    //   523: istore_2
    //   524: aload_0
    //   525: getfield 357	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:pEk	I
    //   528: istore_3
    //   529: iload_3
    //   530: iload_2
    //   531: if_icmplt +587 -> 1118
    //   534: aload_1
    //   535: iload_2
    //   536: putfield 390	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:pEj	I
    //   539: aload_1
    //   540: iload_3
    //   541: putfield 391	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:pEk	I
    //   544: aload_1
    //   545: aload_1
    //   546: getfield 395	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   549: bipush 32
    //   551: invokestatic 401	com/tencent/mm/ci/a:fromDPToPix	(Landroid/content/Context;I)I
    //   554: putfield 404	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:length	I
    //   557: aload_0
    //   558: getfield 145	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Lgl	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   561: astore_1
    //   562: aload_0
    //   563: getfield 143	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:mfT	I
    //   566: istore_2
    //   567: aload_0
    //   568: getfield 258	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:KFI	Ljava/lang/String;
    //   571: astore 10
    //   573: aload_0
    //   574: getfield 262	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:KFJ	I
    //   577: istore_3
    //   578: aload_0
    //   579: getfield 266	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:KFK	I
    //   582: istore 4
    //   584: aload_0
    //   585: getfield 274	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:JAS	Z
    //   588: istore 7
    //   590: aload_0
    //   591: getfield 278	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:fGh	Z
    //   594: istore 8
    //   596: aload_0
    //   597: getfield 282	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Kmm	Ljava/lang/String;
    //   600: astore 11
    //   602: aload_0
    //   603: getfield 286	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:KFL	Ljava/lang/String;
    //   606: astore 12
    //   608: aload_1
    //   609: iconst_1
    //   610: putfield 407	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:isInit	Z
    //   613: aload_1
    //   614: iconst_1
    //   615: putfield 410	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:isFirst	Z
    //   618: aload_1
    //   619: iload_2
    //   620: putfield 411	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mfT	I
    //   623: aload_1
    //   624: aload 10
    //   626: putfield 412	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:KFI	Ljava/lang/String;
    //   629: aload_1
    //   630: iload_3
    //   631: putfield 413	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:KFJ	I
    //   634: aload_1
    //   635: iload 4
    //   637: putfield 414	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:KFK	I
    //   640: aload_1
    //   641: iload 7
    //   643: putfield 415	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:JAS	Z
    //   646: aload_1
    //   647: iload 8
    //   649: putfield 416	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:fGh	Z
    //   652: aload_1
    //   653: aload 11
    //   655: putfield 417	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Kmm	Ljava/lang/String;
    //   658: aload_1
    //   659: aload 12
    //   661: putfield 418	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:KFL	Ljava/lang/String;
    //   664: aload_0
    //   665: getfield 145	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Lgl	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   668: astore_1
    //   669: aload_1
    //   670: aload_1
    //   671: getfield 395	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   674: invokestatic 424	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   677: getstatic 427	com/tencent/mm/plugin/sns/i$g:sight_video_full_screen_view	I
    //   680: aload_1
    //   681: iconst_1
    //   682: invokevirtual 431	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   685: putfield 435	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   688: aload_1
    //   689: aload_1
    //   690: getfield 435	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   693: getstatic 438	com/tencent/mm/plugin/sns/i$f:videoContainer	I
    //   696: invokevirtual 441	android/view/View:findViewById	(I)Landroid/view/View;
    //   699: checkcast 382	android/widget/FrameLayout
    //   702: putfield 444	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:KFE	Landroid/widget/FrameLayout;
    //   705: aload_1
    //   706: aload_1
    //   707: getfield 435	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   710: getstatic 447	com/tencent/mm/plugin/sns/i$f:bottomToorBar	I
    //   713: invokevirtual 441	android/view/View:findViewById	(I)Landroid/view/View;
    //   716: putfield 450	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:KFF	Landroid/view/View;
    //   719: aload_1
    //   720: aload_1
    //   721: getfield 435	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   724: getstatic 453	com/tencent/mm/plugin/sns/i$f:iconBar	I
    //   727: invokevirtual 441	android/view/View:findViewById	(I)Landroid/view/View;
    //   730: putfield 456	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:KFG	Landroid/view/View;
    //   733: aload_1
    //   734: aload_1
    //   735: getfield 435	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   738: getstatic 459	com/tencent/mm/plugin/sns/i$f:progress_bar	I
    //   741: invokevirtual 441	android/view/View:findViewById	(I)Landroid/view/View;
    //   744: checkcast 461	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar
    //   747: putfield 465	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Kth	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   750: aload_1
    //   751: new 467	com/tencent/mm/plugin/sns/ui/OfflineVideoView
    //   754: dup
    //   755: aload_1
    //   756: getfield 395	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   759: invokespecial 468	com/tencent/mm/plugin/sns/ui/OfflineVideoView:<init>	(Landroid/content/Context;)V
    //   762: putfield 472	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:KKe	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   765: aload_1
    //   766: getfield 472	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:KKe	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   769: iconst_1
    //   770: invokevirtual 475	com/tencent/mm/plugin/sns/ui/OfflineVideoView:setClickable	(Z)V
    //   773: aload_1
    //   774: getfield 472	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:KKe	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   777: aload_1
    //   778: invokevirtual 479	com/tencent/mm/plugin/sns/ui/OfflineVideoView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   781: aload_1
    //   782: getfield 444	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:KFE	Landroid/widget/FrameLayout;
    //   785: aload_1
    //   786: getfield 472	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:KKe	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   789: invokevirtual 389	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   792: aload_1
    //   793: getfield 465	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Kth	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   796: iconst_0
    //   797: invokevirtual 482	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setVisibility	(I)V
    //   800: aload_1
    //   801: getfield 465	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Kth	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   804: aload_1
    //   805: getfield 486	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Ktm	Landroid/view/View$OnClickListener;
    //   808: invokevirtual 490	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setOnPlayButtonClickListener	(Landroid/view/View$OnClickListener;)V
    //   811: aload_1
    //   812: getfield 465	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Kth	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   815: aload_1
    //   816: getfield 494	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:wTG	Lcom/tencent/mm/plugin/sight/decode/ui/b;
    //   819: invokevirtual 498	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setIplaySeekCallback	(Lcom/tencent/mm/plugin/sight/decode/ui/b;)V
    //   822: aload_1
    //   823: aload_1
    //   824: getstatic 501	com/tencent/mm/plugin/sns/i$f:sns_ad_native_landing_pages_sight_video_full_screen_btn	I
    //   827: invokevirtual 502	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:findViewById	(I)Landroid/view/View;
    //   830: checkcast 504	android/widget/ImageView
    //   833: putfield 508	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Kti	Landroid/widget/ImageView;
    //   836: aload_1
    //   837: getfield 508	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Kti	Landroid/widget/ImageView;
    //   840: iconst_0
    //   841: invokevirtual 509	android/widget/ImageView:setVisibility	(I)V
    //   844: aload_1
    //   845: getfield 508	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Kti	Landroid/widget/ImageView;
    //   848: aload_1
    //   849: invokevirtual 512	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   852: aload_1
    //   853: aload_1
    //   854: getstatic 515	com/tencent/mm/plugin/sns/i$f:sns_ad_native_landing_pages_sight_voice_btn	I
    //   857: invokevirtual 502	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:findViewById	(I)Landroid/view/View;
    //   860: checkcast 504	android/widget/ImageView
    //   863: putfield 518	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Kte	Landroid/widget/ImageView;
    //   866: aload_1
    //   867: getfield 518	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Kte	Landroid/widget/ImageView;
    //   870: iconst_0
    //   871: invokevirtual 509	android/widget/ImageView:setVisibility	(I)V
    //   874: aload_1
    //   875: getfield 518	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Kte	Landroid/widget/ImageView;
    //   878: aload_1
    //   879: invokevirtual 512	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   882: aload_1
    //   883: aload_1
    //   884: getfield 435	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   887: getstatic 521	com/tencent/mm/plugin/sns/i$f:pause_video_container	I
    //   890: invokevirtual 441	android/view/View:findViewById	(I)Landroid/view/View;
    //   893: putfield 524	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Ktj	Landroid/view/View;
    //   896: aload_1
    //   897: getfield 524	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Ktj	Landroid/view/View;
    //   900: bipush 8
    //   902: invokevirtual 525	android/view/View:setVisibility	(I)V
    //   905: aload_1
    //   906: getfield 395	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   909: invokevirtual 528	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   912: invokevirtual 96	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   915: getfield 101	android/content/res/Configuration:orientation	I
    //   918: iconst_2
    //   919: if_icmpne +256 -> 1175
    //   922: ldc_w 530
    //   925: ldc 217
    //   927: invokestatic 219	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   930: aload_1
    //   931: invokevirtual 531	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:fQW	()V
    //   934: aload_1
    //   935: getfield 465	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Kth	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   938: invokevirtual 534	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:getVideoTotalTime	()I
    //   941: aload_1
    //   942: getfield 414	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:KFK	I
    //   945: sipush 1000
    //   948: idiv
    //   949: if_icmpeq +18 -> 967
    //   952: aload_1
    //   953: getfield 465	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Kth	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   956: aload_1
    //   957: getfield 414	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:KFK	I
    //   960: sipush 1000
    //   963: idiv
    //   964: invokevirtual 537	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setVideoTotalTime	(I)V
    //   967: aload_1
    //   968: getfield 465	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Kth	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   971: aload_1
    //   972: getfield 413	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:KFJ	I
    //   975: sipush 1000
    //   978: idiv
    //   979: invokevirtual 540	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:seek	(I)V
    //   982: aload_1
    //   983: aload_1
    //   984: getfield 416	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:fGh	Z
    //   987: invokevirtual 543	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:yM	(Z)V
    //   990: aload_1
    //   991: getfield 472	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:KKe	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   994: new 545	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView$2
    //   997: dup
    //   998: aload_1
    //   999: invokespecial 548	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView$2:<init>	(Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;)V
    //   1002: invokevirtual 552	com/tencent/mm/plugin/sns/ui/OfflineVideoView:setVideoCallback	(Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView$a;)V
    //   1005: aload_1
    //   1006: getfield 472	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:KKe	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   1009: invokevirtual 555	com/tencent/mm/plugin/sns/ui/OfflineVideoView:dmh	()V
    //   1012: aload_1
    //   1013: iconst_1
    //   1014: invokevirtual 558	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:setFocus	(Z)V
    //   1017: aload_0
    //   1018: getfield 145	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Lgl	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   1021: aload_0
    //   1022: invokevirtual 562	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:setProgressBarStatusListener	(Lcom/tencent/mm/plugin/sns/ui/d/a;)V
    //   1025: getstatic 568	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag$b:Kty	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w;
    //   1028: ifnull +21 -> 1049
    //   1031: aload_0
    //   1032: getstatic 568	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag$b:Kty	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w;
    //   1035: getfield 573	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:Kmu	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ak;
    //   1038: putfield 575	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Klr	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ak;
    //   1041: aload_0
    //   1042: aload_0
    //   1043: getfield 575	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Klr	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ak;
    //   1046: invokespecial 577	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:a	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ak;)V
    //   1049: ldc 224
    //   1051: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1054: return
    //   1055: astore_1
    //   1056: ldc 126
    //   1058: aload_1
    //   1059: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1062: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1065: goto -720 -> 345
    //   1068: aload_0
    //   1069: invokestatic 363	com/tencent/mm/ui/ar:aN	(Landroid/content/Context;)Z
    //   1072: ifeq -640 -> 432
    //   1075: aload_0
    //   1076: invokevirtual 90	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getResources	()Landroid/content/res/Resources;
    //   1079: invokevirtual 96	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   1082: getfield 101	android/content/res/Configuration:orientation	I
    //   1085: iconst_2
    //   1086: if_icmpne -654 -> 432
    //   1089: aload_0
    //   1090: aload_0
    //   1091: getfield 355	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:pEj	I
    //   1094: aload_0
    //   1095: invokestatic 367	com/tencent/mm/ui/ar:aM	(Landroid/content/Context;)I
    //   1098: isub
    //   1099: putfield 355	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:pEj	I
    //   1102: goto -670 -> 432
    //   1105: astore_1
    //   1106: ldc 126
    //   1108: aload_1
    //   1109: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1112: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1115: goto -645 -> 470
    //   1118: aload_1
    //   1119: iload_2
    //   1120: putfield 391	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:pEk	I
    //   1123: aload_1
    //   1124: iload_3
    //   1125: putfield 390	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:pEj	I
    //   1128: goto -584 -> 544
    //   1131: astore_1
    //   1132: ldc_w 530
    //   1135: aload_1
    //   1136: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1139: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1142: goto -585 -> 557
    //   1145: astore_1
    //   1146: ldc 126
    //   1148: aload_1
    //   1149: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1152: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1155: ldc 224
    //   1157: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1160: return
    //   1161: astore_1
    //   1162: ldc_w 530
    //   1165: aload_1
    //   1166: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1169: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1172: goto -508 -> 664
    //   1175: aload_1
    //   1176: getfield 395	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   1179: invokevirtual 528	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1182: invokevirtual 96	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   1185: getfield 101	android/content/res/Configuration:orientation	I
    //   1188: iconst_1
    //   1189: if_icmpne -255 -> 934
    //   1192: ldc_w 530
    //   1195: ldc 221
    //   1197: invokestatic 219	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1200: aload_1
    //   1201: invokevirtual 578	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:fQX	()V
    //   1204: goto -270 -> 934
    //   1207: astore 10
    //   1209: ldc_w 530
    //   1212: aload 10
    //   1214: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1217: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1220: goto -286 -> 934
    //   1223: astore_1
    //   1224: ldc_w 530
    //   1227: aload_1
    //   1228: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1231: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1234: goto -217 -> 1017
    //   1237: astore 10
    //   1239: ldc_w 530
    //   1242: aload 10
    //   1244: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1247: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1250: goto -260 -> 990
    //   1253: astore 10
    //   1255: ldc_w 530
    //   1258: aload 10
    //   1260: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1263: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1266: goto -261 -> 1005
    //   1269: astore_1
    //   1270: ldc 126
    //   1272: aload_1
    //   1273: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1276: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1279: ldc 224
    //   1281: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1284: return
    //   1285: aload_0
    //   1286: getfield 143	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:mfT	I
    //   1289: iconst_1
    //   1290: if_icmpne +649 -> 1939
    //   1293: aload_0
    //   1294: aload_0
    //   1295: getstatic 376	com/tencent/mm/plugin/sns/i$f:root	I
    //   1298: invokevirtual 380	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:findViewById	(I)Landroid/view/View;
    //   1301: checkcast 382	android/widget/FrameLayout
    //   1304: putfield 61	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:KLO	Landroid/widget/FrameLayout;
    //   1307: aload_0
    //   1308: new 187	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView
    //   1311: dup
    //   1312: aload_0
    //   1313: invokespecial 579	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:<init>	(Landroid/content/Context;)V
    //   1316: putfield 185	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Lgm	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1319: aload_0
    //   1320: getfield 61	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:KLO	Landroid/widget/FrameLayout;
    //   1323: aload_0
    //   1324: getfield 185	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Lgm	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1327: invokevirtual 389	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   1330: aload_0
    //   1331: getfield 185	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Lgm	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1334: astore_1
    //   1335: aload_0
    //   1336: getfield 355	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:pEj	I
    //   1339: istore_2
    //   1340: aload_0
    //   1341: getfield 357	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:pEk	I
    //   1344: istore_3
    //   1345: iload_3
    //   1346: iload_2
    //   1347: if_icmplt +598 -> 1945
    //   1350: aload_1
    //   1351: iload_2
    //   1352: putfield 580	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:pEj	I
    //   1355: aload_1
    //   1356: iload_3
    //   1357: putfield 581	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:pEk	I
    //   1360: aload_1
    //   1361: aload_1
    //   1362: getfield 582	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mContext	Landroid/content/Context;
    //   1365: bipush 32
    //   1367: invokestatic 401	com/tencent/mm/ci/a:fromDPToPix	(Landroid/content/Context;I)I
    //   1370: putfield 583	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:length	I
    //   1373: aload_0
    //   1374: getfield 185	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Lgm	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1377: astore_1
    //   1378: aload_0
    //   1379: getfield 143	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:mfT	I
    //   1382: istore_2
    //   1383: aload_0
    //   1384: getfield 258	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:KFI	Ljava/lang/String;
    //   1387: astore 10
    //   1389: aload_0
    //   1390: getfield 262	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:KFJ	I
    //   1393: istore_3
    //   1394: aload_0
    //   1395: getfield 266	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:KFK	I
    //   1398: istore 4
    //   1400: aload_0
    //   1401: getfield 274	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:JAS	Z
    //   1404: istore 7
    //   1406: aload_0
    //   1407: getfield 278	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:fGh	Z
    //   1410: istore 8
    //   1412: aload_0
    //   1413: getfield 282	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Kmm	Ljava/lang/String;
    //   1416: astore 11
    //   1418: aload_0
    //   1419: getfield 286	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:KFL	Ljava/lang/String;
    //   1422: astore 12
    //   1424: aload_0
    //   1425: getfield 290	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:isWaiting	Z
    //   1428: istore 9
    //   1430: aload_0
    //   1431: getfield 294	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:KtV	I
    //   1434: istore 5
    //   1436: aload_0
    //   1437: getfield 298	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:KFM	I
    //   1440: istore 6
    //   1442: aload_1
    //   1443: iconst_1
    //   1444: putfield 586	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:kfR	Z
    //   1447: aload_1
    //   1448: iconst_1
    //   1449: putfield 587	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:isFirst	Z
    //   1452: aload_1
    //   1453: iload_2
    //   1454: putfield 588	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mfT	I
    //   1457: aload_1
    //   1458: aload 10
    //   1460: putfield 589	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:KFI	Ljava/lang/String;
    //   1463: aload_1
    //   1464: iload_3
    //   1465: putfield 590	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:KFJ	I
    //   1468: aload_1
    //   1469: iload 4
    //   1471: putfield 591	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:KFK	I
    //   1474: aload_1
    //   1475: iload 7
    //   1477: putfield 592	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:JAS	Z
    //   1480: aload_1
    //   1481: iload 8
    //   1483: putfield 593	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:fGh	Z
    //   1486: aload_1
    //   1487: aload 11
    //   1489: putfield 594	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Kmm	Ljava/lang/String;
    //   1492: aload_1
    //   1493: aload 12
    //   1495: putfield 595	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:KFL	Ljava/lang/String;
    //   1498: aload_1
    //   1499: iload 9
    //   1501: putfield 596	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:isWaiting	Z
    //   1504: aload_1
    //   1505: iload 5
    //   1507: putfield 597	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:KtV	I
    //   1510: aload_1
    //   1511: iload 6
    //   1513: putfield 598	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:KFM	I
    //   1516: aload_0
    //   1517: getfield 185	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Lgm	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1520: astore_1
    //   1521: aload_1
    //   1522: aload_1
    //   1523: getfield 582	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mContext	Landroid/content/Context;
    //   1526: invokestatic 424	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   1529: getstatic 601	com/tencent/mm/plugin/sns/i$g:long_video_full_screen_view	I
    //   1532: aload_1
    //   1533: iconst_1
    //   1534: invokevirtual 431	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   1537: putfield 602	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1540: aload_1
    //   1541: aload_1
    //   1542: getfield 602	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1545: getstatic 438	com/tencent/mm/plugin/sns/i$f:videoContainer	I
    //   1548: invokevirtual 441	android/view/View:findViewById	(I)Landroid/view/View;
    //   1551: checkcast 382	android/widget/FrameLayout
    //   1554: putfield 603	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:KFE	Landroid/widget/FrameLayout;
    //   1557: aload_1
    //   1558: new 605	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper
    //   1561: dup
    //   1562: aload_1
    //   1563: getfield 582	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mContext	Landroid/content/Context;
    //   1566: invokespecial 606	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:<init>	(Landroid/content/Context;)V
    //   1569: putfield 610	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:KFH	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1572: aload_1
    //   1573: getfield 603	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:KFE	Landroid/widget/FrameLayout;
    //   1576: aload_1
    //   1577: getfield 610	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:KFH	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1580: invokevirtual 389	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   1583: aload_1
    //   1584: getfield 610	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:KFH	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1587: aload_1
    //   1588: invokevirtual 614	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setIMMVideoViewCallback	(Lcom/tencent/mm/pluginsdk/ui/i$b;)V
    //   1591: aload_1
    //   1592: getfield 610	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:KFH	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1595: iconst_1
    //   1596: invokevirtual 617	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setFullScreen	(Z)V
    //   1599: aload_1
    //   1600: getfield 610	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:KFH	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1603: iconst_0
    //   1604: aload_1
    //   1605: getfield 595	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:KFL	Ljava/lang/String;
    //   1608: iconst_0
    //   1609: invokevirtual 621	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:c	(ZLjava/lang/String;I)V
    //   1612: aload_1
    //   1613: getfield 610	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:KFH	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1616: iconst_1
    //   1617: invokevirtual 622	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setClickable	(Z)V
    //   1620: aload_1
    //   1621: getfield 610	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:KFH	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1624: aload_1
    //   1625: invokevirtual 623	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   1628: aload_1
    //   1629: getfield 610	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:KFH	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1632: iconst_1
    //   1633: invokevirtual 626	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setLoop	(Z)V
    //   1636: aload_1
    //   1637: getfield 610	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:KFH	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1640: aload_1
    //   1641: invokevirtual 630	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setLoopCompletionCallback	(Lcom/tencent/mm/pluginsdk/ui/i$d;)V
    //   1644: aload_1
    //   1645: aload_1
    //   1646: getfield 602	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1649: getstatic 447	com/tencent/mm/plugin/sns/i$f:bottomToorBar	I
    //   1652: invokevirtual 441	android/view/View:findViewById	(I)Landroid/view/View;
    //   1655: putfield 631	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:KFF	Landroid/view/View;
    //   1658: aload_1
    //   1659: aload_1
    //   1660: getfield 602	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1663: getstatic 453	com/tencent/mm/plugin/sns/i$f:iconBar	I
    //   1666: invokevirtual 441	android/view/View:findViewById	(I)Landroid/view/View;
    //   1669: putfield 632	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:KFG	Landroid/view/View;
    //   1672: aload_1
    //   1673: aload_1
    //   1674: getfield 602	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1677: getstatic 459	com/tencent/mm/plugin/sns/i$f:progress_bar	I
    //   1680: invokevirtual 441	android/view/View:findViewById	(I)Landroid/view/View;
    //   1683: checkcast 461	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar
    //   1686: putfield 633	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Kth	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1689: aload_1
    //   1690: getfield 633	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Kth	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1693: iconst_0
    //   1694: invokevirtual 482	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setVisibility	(I)V
    //   1697: aload_1
    //   1698: getfield 633	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Kth	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1701: aload_1
    //   1702: getfield 634	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Ktm	Landroid/view/View$OnClickListener;
    //   1705: invokevirtual 490	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setOnPlayButtonClickListener	(Landroid/view/View$OnClickListener;)V
    //   1708: aload_1
    //   1709: getfield 633	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Kth	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1712: aload_1
    //   1713: getfield 635	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:wTG	Lcom/tencent/mm/plugin/sight/decode/ui/b;
    //   1716: invokevirtual 498	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setIplaySeekCallback	(Lcom/tencent/mm/plugin/sight/decode/ui/b;)V
    //   1719: aload_1
    //   1720: aload_1
    //   1721: getstatic 501	com/tencent/mm/plugin/sns/i$f:sns_ad_native_landing_pages_sight_video_full_screen_btn	I
    //   1724: invokevirtual 636	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:findViewById	(I)Landroid/view/View;
    //   1727: checkcast 504	android/widget/ImageView
    //   1730: putfield 637	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Kti	Landroid/widget/ImageView;
    //   1733: aload_1
    //   1734: getfield 637	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Kti	Landroid/widget/ImageView;
    //   1737: iconst_0
    //   1738: invokevirtual 509	android/widget/ImageView:setVisibility	(I)V
    //   1741: aload_1
    //   1742: getfield 637	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Kti	Landroid/widget/ImageView;
    //   1745: aload_1
    //   1746: invokevirtual 512	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1749: aload_1
    //   1750: aload_1
    //   1751: getstatic 515	com/tencent/mm/plugin/sns/i$f:sns_ad_native_landing_pages_sight_voice_btn	I
    //   1754: invokevirtual 636	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:findViewById	(I)Landroid/view/View;
    //   1757: checkcast 504	android/widget/ImageView
    //   1760: putfield 638	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Kte	Landroid/widget/ImageView;
    //   1763: aload_1
    //   1764: getfield 638	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Kte	Landroid/widget/ImageView;
    //   1767: iconst_0
    //   1768: invokevirtual 509	android/widget/ImageView:setVisibility	(I)V
    //   1771: aload_1
    //   1772: getfield 638	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Kte	Landroid/widget/ImageView;
    //   1775: aload_1
    //   1776: invokevirtual 512	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1779: aload_1
    //   1780: aload_1
    //   1781: getfield 602	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1784: getstatic 521	com/tencent/mm/plugin/sns/i$f:pause_video_container	I
    //   1787: invokevirtual 441	android/view/View:findViewById	(I)Landroid/view/View;
    //   1790: putfield 639	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Ktj	Landroid/view/View;
    //   1793: aload_1
    //   1794: getfield 639	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Ktj	Landroid/view/View;
    //   1797: bipush 8
    //   1799: invokevirtual 525	android/view/View:setVisibility	(I)V
    //   1802: aload_1
    //   1803: getfield 633	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Kth	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1806: invokevirtual 643	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:getParent	()Landroid/view/ViewParent;
    //   1809: astore 10
    //   1811: aload 10
    //   1813: instanceof 645
    //   1816: ifeq +15 -> 1831
    //   1819: aload 10
    //   1821: checkcast 645	android/view/ViewGroup
    //   1824: aload_1
    //   1825: getfield 633	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Kth	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1828: invokevirtual 648	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   1831: aload_1
    //   1832: getfield 610	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:KFH	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1835: aload_1
    //   1836: getfield 633	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Kth	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1839: invokevirtual 652	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setVideoFooterView	(Lcom/tencent/mm/pluginsdk/ui/h;)V
    //   1842: aload_1
    //   1843: getfield 582	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mContext	Landroid/content/Context;
    //   1846: invokevirtual 528	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1849: invokevirtual 96	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   1852: getfield 101	android/content/res/Configuration:orientation	I
    //   1855: iconst_2
    //   1856: if_icmpne +160 -> 2016
    //   1859: ldc_w 654
    //   1862: ldc 217
    //   1864: invokestatic 219	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1867: aload_1
    //   1868: invokevirtual 655	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:fQW	()V
    //   1871: aload_1
    //   1872: getfield 592	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:JAS	Z
    //   1875: ifeq +189 -> 2064
    //   1878: aload_1
    //   1879: invokevirtual 658	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:fKr	()V
    //   1882: aload_1
    //   1883: invokevirtual 661	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:cNW	()V
    //   1886: aload_1
    //   1887: iconst_1
    //   1888: invokevirtual 662	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:setFocus	(Z)V
    //   1891: aload_0
    //   1892: getfield 185	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Lgm	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1895: aload_0
    //   1896: invokevirtual 663	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:setProgressBarStatusListener	(Lcom/tencent/mm/plugin/sns/ui/d/a;)V
    //   1899: getstatic 669	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ak$a:Kua	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/an;
    //   1902: ifnull +21 -> 1923
    //   1905: aload_0
    //   1906: getstatic 669	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ak$a:Kua	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/an;
    //   1909: getfield 672	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/an:Kmu	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ak;
    //   1912: putfield 575	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Klr	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ak;
    //   1915: aload_0
    //   1916: aload_0
    //   1917: getfield 575	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Klr	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ak;
    //   1920: invokespecial 577	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:a	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ak;)V
    //   1923: ldc 224
    //   1925: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1928: return
    //   1929: astore_1
    //   1930: ldc 126
    //   1932: aload_1
    //   1933: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1936: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1939: ldc 224
    //   1941: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1944: return
    //   1945: aload_1
    //   1946: iload_2
    //   1947: putfield 581	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:pEk	I
    //   1950: aload_1
    //   1951: iload_3
    //   1952: putfield 580	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:pEj	I
    //   1955: goto -595 -> 1360
    //   1958: astore_1
    //   1959: ldc_w 654
    //   1962: aload_1
    //   1963: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1966: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1969: goto -596 -> 1373
    //   1972: astore_1
    //   1973: ldc_w 654
    //   1976: aload_1
    //   1977: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1980: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1983: goto -467 -> 1516
    //   1986: astore 10
    //   1988: ldc_w 654
    //   1991: aload 10
    //   1993: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1996: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1999: goto -355 -> 1644
    //   2002: astore_1
    //   2003: ldc_w 654
    //   2006: aload_1
    //   2007: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2010: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2013: goto -122 -> 1891
    //   2016: aload_1
    //   2017: getfield 582	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mContext	Landroid/content/Context;
    //   2020: invokevirtual 528	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   2023: invokevirtual 96	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   2026: getfield 101	android/content/res/Configuration:orientation	I
    //   2029: iconst_1
    //   2030: if_icmpne -159 -> 1871
    //   2033: ldc_w 654
    //   2036: ldc 221
    //   2038: invokestatic 219	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2041: aload_1
    //   2042: invokevirtual 673	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:fQX	()V
    //   2045: goto -174 -> 1871
    //   2048: astore 10
    //   2050: ldc_w 654
    //   2053: aload 10
    //   2055: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2058: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2061: goto -190 -> 1871
    //   2064: aload_1
    //   2065: invokevirtual 676	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:fKs	()V
    //   2068: goto -186 -> 1882
    //   2071: astore 10
    //   2073: ldc_w 654
    //   2076: aload 10
    //   2078: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2081: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2084: goto -198 -> 1886
    //   2087: astore_1
    //   2088: ldc 126
    //   2090: aload_1
    //   2091: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2094: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2097: ldc 224
    //   2099: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2102: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2103	0	this	VideoFullScreenActivity
    //   0	2103	1	paramBundle	android.os.Bundle
    //   523	1424	2	i	int
    //   528	1424	3	j	int
    //   582	888	4	k	int
    //   1434	72	5	m	int
    //   1440	72	6	n	int
    //   588	888	7	bool1	boolean
    //   594	888	8	bool2	boolean
    //   1428	72	9	bool3	boolean
    //   571	54	10	str1	String
    //   1207	6	10	localThrowable1	Throwable
    //   1237	6	10	localThrowable2	Throwable
    //   1253	6	10	localThrowable3	Throwable
    //   1387	433	10	localObject	Object
    //   1986	6	10	localThrowable4	Throwable
    //   2048	6	10	localThrowable5	Throwable
    //   2071	6	10	localThrowable6	Throwable
    //   600	888	11	str2	String
    //   606	888	12	str3	String
    // Exception table:
    //   from	to	target	type
    //   28	345	1055	java/lang/Throwable
    //   379	432	1105	java/lang/Throwable
    //   432	470	1105	java/lang/Throwable
    //   1068	1102	1105	java/lang/Throwable
    //   534	544	1131	java/lang/Throwable
    //   544	557	1131	java/lang/Throwable
    //   1118	1128	1131	java/lang/Throwable
    //   477	529	1145	java/lang/Throwable
    //   557	608	1145	java/lang/Throwable
    //   664	669	1145	java/lang/Throwable
    //   1017	1025	1145	java/lang/Throwable
    //   1049	1054	1145	java/lang/Throwable
    //   1132	1142	1145	java/lang/Throwable
    //   1162	1172	1145	java/lang/Throwable
    //   1224	1234	1145	java/lang/Throwable
    //   1270	1279	1145	java/lang/Throwable
    //   608	664	1161	java/lang/Throwable
    //   669	934	1207	java/lang/Throwable
    //   1175	1204	1207	java/lang/Throwable
    //   1005	1017	1223	java/lang/Throwable
    //   1209	1220	1223	java/lang/Throwable
    //   1239	1250	1223	java/lang/Throwable
    //   1255	1266	1223	java/lang/Throwable
    //   934	967	1237	java/lang/Throwable
    //   967	990	1237	java/lang/Throwable
    //   990	1005	1253	java/lang/Throwable
    //   1025	1049	1269	java/lang/Throwable
    //   1293	1345	1929	java/lang/Throwable
    //   1373	1442	1929	java/lang/Throwable
    //   1516	1521	1929	java/lang/Throwable
    //   1891	1899	1929	java/lang/Throwable
    //   1923	1928	1929	java/lang/Throwable
    //   1959	1969	1929	java/lang/Throwable
    //   1973	1983	1929	java/lang/Throwable
    //   2003	2013	1929	java/lang/Throwable
    //   2088	2097	1929	java/lang/Throwable
    //   1350	1360	1958	java/lang/Throwable
    //   1360	1373	1958	java/lang/Throwable
    //   1945	1955	1958	java/lang/Throwable
    //   1442	1516	1972	java/lang/Throwable
    //   1521	1644	1986	java/lang/Throwable
    //   1886	1891	2002	java/lang/Throwable
    //   1988	1999	2002	java/lang/Throwable
    //   2050	2061	2002	java/lang/Throwable
    //   2073	2084	2002	java/lang/Throwable
    //   1644	1831	2048	java/lang/Throwable
    //   1831	1871	2048	java/lang/Throwable
    //   2016	2045	2048	java/lang/Throwable
    //   1871	1882	2071	java/lang/Throwable
    //   1882	1886	2071	java/lang/Throwable
    //   2064	2068	2071	java/lang/Throwable
    //   1899	1923	2087	java/lang/Throwable
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(264687);
    for (;;)
    {
      try
      {
        ae.JWV = null;
        if (this.mfT != 0) {
          continue;
        }
        localSightVideoFullScreenView = this.Lgl;
      }
      catch (Throwable localThrowable2)
      {
        SightVideoFullScreenView localSightVideoFullScreenView;
        AudioManager localAudioManager;
        Log.e("VideoFullScreenActivity", localThrowable2.toString());
        continue;
        if (this.mfT != 1) {
          continue;
        }
        localLongVideoFullScreenView = this.Lgm;
      }
      try
      {
        if (localSightVideoFullScreenView.mContext == null) {
          Log.e("SightVideoFullScreenView", "context is null");
        }
      }
      catch (Throwable localThrowable4)
      {
        try
        {
          MMHandlerThread.removeRunnable(localSightVideoFullScreenView.JBl);
          MMHandlerThread.removeRunnable(localSightVideoFullScreenView.Ktl);
          localSightVideoFullScreenView.KKe.onDestroy();
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ag.b.Kty = null;
          super.onDestroy();
          AppMethodBeat.o(264687);
          return;
          if (localSightVideoFullScreenView.KKf == null) {
            continue;
          }
          localAudioManager = (AudioManager)localSightVideoFullScreenView.mContext.getSystemService("audio");
          if (localAudioManager == null) {
            continue;
          }
          localAudioManager.abandonAudioFocus(localSightVideoFullScreenView.KKf);
          localSightVideoFullScreenView.KKf = null;
          continue;
          localThrowable4 = localThrowable4;
          Log.e("SightVideoFullScreenView", "abandonAudioFocus has something wrong!");
          continue;
        }
        catch (Throwable localThrowable1)
        {
          Log.e("SightVideoFullScreenView", localThrowable1.toString());
          continue;
        }
      }
      try
      {
        LongVideoFullScreenView localLongVideoFullScreenView;
        localLongVideoFullScreenView.KFH.Kux.stopTimer();
        MMHandlerThread.removeRunnable(localLongVideoFullScreenView.JBl);
        MMHandlerThread.removeRunnable(localLongVideoFullScreenView.Ktl);
        localLongVideoFullScreenView.KFH.onUIDestroy();
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ak.a.Kua = null;
      }
      catch (Throwable localThrowable3)
      {
        for (;;)
        {
          Log.e("LongVideoFullScreenView", localThrowable3.toString());
        }
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(264677);
    super.onPause();
    try
    {
      this.fOa += System.currentTimeMillis() - this.startTime;
      if (this.mfT == 0)
      {
        SightVideoFullScreenView localSightVideoFullScreenView = this.Lgl;
        try
        {
          localSightVideoFullScreenView.KkF = false;
          MMHandlerThread.removeRunnable(localSightVideoFullScreenView.JBl);
          MMHandlerThread.removeRunnable(localSightVideoFullScreenView.Ktl);
          AppMethodBeat.o(264677);
          return;
        }
        catch (Throwable localThrowable1)
        {
          Log.e("SightVideoFullScreenView", localThrowable1.toString());
          AppMethodBeat.o(264677);
          return;
        }
      }
      if (this.mfT != 1) {
        break label150;
      }
    }
    catch (Throwable localThrowable2)
    {
      Log.e("VideoFullScreenActivity", localThrowable2.toString());
      AppMethodBeat.o(264677);
      return;
    }
    LongVideoFullScreenView localLongVideoFullScreenView = this.Lgm;
    try
    {
      localLongVideoFullScreenView.KkF = false;
      MMHandlerThread.removeRunnable(localLongVideoFullScreenView.JBl);
      MMHandlerThread.removeRunnable(localLongVideoFullScreenView.Ktl);
      AppMethodBeat.o(264677);
      return;
    }
    catch (Throwable localThrowable3)
    {
      Log.e("LongVideoFullScreenView", localThrowable3.toString());
    }
    label150:
    AppMethodBeat.o(264677);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(264674);
    super.onResume();
    try
    {
      this.startTime = System.currentTimeMillis();
      ao.aR(this);
      if (this.mfT == 0)
      {
        this.Lgl.KkF = true;
        AppMethodBeat.o(264674);
        return;
      }
      if (this.mfT == 1) {
        this.Lgm.KkF = true;
      }
      AppMethodBeat.o(264674);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("VideoFullScreenActivity", localThrowable.toString());
      AppMethodBeat.o(264674);
    }
  }
  
  /* Error */
  public void onStart()
  {
    // Byte code:
    //   0: ldc_w 740
    //   3: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 742	com/tencent/mm/ui/MMActivity:onStart	()V
    //   10: aload_0
    //   11: invokestatic 232	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ao:aR	(Landroid/app/Activity;)V
    //   14: aload_0
    //   15: getfield 143	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:mfT	I
    //   18: ifne +95 -> 113
    //   21: aload_0
    //   22: getfield 145	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Lgl	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   25: astore_1
    //   26: aload_1
    //   27: getfield 410	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:isFirst	Z
    //   30: ifne +41 -> 71
    //   33: aload_1
    //   34: getfield 472	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:KKe	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   37: invokevirtual 746	com/tencent/mm/plugin/sns/ui/OfflineVideoView:isPlaying	()Z
    //   40: ifne +19 -> 59
    //   43: aload_1
    //   44: getfield 749	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:KFP	Z
    //   47: ifeq +12 -> 59
    //   50: aload_1
    //   51: invokevirtual 752	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:fUS	()V
    //   54: aload_1
    //   55: iconst_0
    //   56: putfield 749	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:KFP	Z
    //   59: aload_1
    //   60: iconst_0
    //   61: putfield 410	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:isFirst	Z
    //   64: ldc_w 740
    //   67: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: return
    //   71: aload_1
    //   72: invokevirtual 755	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:requestAudioFocus	()V
    //   75: goto -16 -> 59
    //   78: astore_1
    //   79: ldc_w 530
    //   82: aload_1
    //   83: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   86: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: ldc_w 740
    //   92: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: return
    //   96: astore_1
    //   97: ldc 126
    //   99: aload_1
    //   100: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   103: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: ldc_w 740
    //   109: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: return
    //   113: aload_0
    //   114: getfield 143	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:mfT	I
    //   117: iconst_1
    //   118: if_icmpne +64 -> 182
    //   121: aload_0
    //   122: getfield 185	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Lgm	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   125: astore_1
    //   126: aload_1
    //   127: getfield 587	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:isFirst	Z
    //   130: ifne +29 -> 159
    //   133: aload_1
    //   134: getfield 610	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:KFH	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   137: invokevirtual 756	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:isPlaying	()Z
    //   140: ifne +19 -> 159
    //   143: aload_1
    //   144: getfield 757	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:KFP	Z
    //   147: ifeq +12 -> 159
    //   150: aload_1
    //   151: invokevirtual 661	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:cNW	()V
    //   154: aload_1
    //   155: iconst_0
    //   156: putfield 757	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:KFP	Z
    //   159: aload_1
    //   160: iconst_0
    //   161: putfield 587	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:isFirst	Z
    //   164: ldc_w 740
    //   167: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: return
    //   171: astore_1
    //   172: ldc_w 654
    //   175: aload_1
    //   176: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   179: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: ldc_w 740
    //   185: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	VideoFullScreenActivity
    //   25	47	1	localSightVideoFullScreenView	SightVideoFullScreenView
    //   78	5	1	localThrowable1	Throwable
    //   96	4	1	localThrowable2	Throwable
    //   125	35	1	localLongVideoFullScreenView	LongVideoFullScreenView
    //   171	5	1	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   26	59	78	java/lang/Throwable
    //   59	64	78	java/lang/Throwable
    //   71	75	78	java/lang/Throwable
    //   10	26	96	java/lang/Throwable
    //   64	70	96	java/lang/Throwable
    //   79	95	96	java/lang/Throwable
    //   113	126	96	java/lang/Throwable
    //   164	170	96	java/lang/Throwable
    //   172	182	96	java/lang/Throwable
    //   126	159	171	java/lang/Throwable
    //   159	164	171	java/lang/Throwable
  }
  
  public void onStop()
  {
    AppMethodBeat.i(264681);
    super.onStop();
    try
    {
      if (this.mfT == 0)
      {
        SightVideoFullScreenView localSightVideoFullScreenView = this.Lgl;
        try
        {
          localSightVideoFullScreenView.isFirst = false;
          if (localSightVideoFullScreenView.KKe.isPlaying())
          {
            localSightVideoFullScreenView.fUT();
            localSightVideoFullScreenView.KFP = true;
          }
          AppMethodBeat.o(264681);
          return;
        }
        catch (Throwable localThrowable1)
        {
          Log.e("SightVideoFullScreenView", localThrowable1.toString());
          AppMethodBeat.o(264681);
          return;
        }
      }
      if (this.mfT != 1) {
        break label143;
      }
    }
    catch (Throwable localThrowable2)
    {
      Log.e("VideoFullScreenActivity", localThrowable2.toString());
      AppMethodBeat.o(264681);
      return;
    }
    LongVideoFullScreenView localLongVideoFullScreenView = this.Lgm;
    try
    {
      localLongVideoFullScreenView.isFirst = false;
      if (localLongVideoFullScreenView.KFH.isPlaying())
      {
        localLongVideoFullScreenView.dmi();
        localLongVideoFullScreenView.KFP = true;
      }
      AppMethodBeat.o(264681);
      return;
    }
    catch (Throwable localThrowable3)
    {
      Log.e("LongVideoFullScreenView", localThrowable3.toString());
    }
    label143:
    AppMethodBeat.o(264681);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setMMOrientation() {}
  
  public final void zf(boolean paramBoolean)
  {
    AppMethodBeat.i(264691);
    Log.i("VideoFullScreenActivity", "progressBarStatus visiblity = ".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      ze(true);
      AppMethodBeat.o(264691);
      return;
    }
    if (this.JCx != null)
    {
      Log.d("VideoFullScreenActivity", "showFloatBarView");
      this.JCx.fQT();
    }
    AppMethodBeat.o(264691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.VideoFullScreenActivity
 * JD-Core Version:    0.7.0.1
 */