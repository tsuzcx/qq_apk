package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(32)
public class VideoFullScreenActivity
  extends MMActivity
  implements com.tencent.mm.plugin.sns.ui.d.a
{
  private String DYR;
  private SightVideoFullScreenView ESg;
  private LongVideoFullScreenView ESh;
  private g ESi;
  public aj ESj;
  private boolean ESk;
  private boolean EeY;
  private int EgO;
  private String Esm;
  private int Esn;
  private int Eso;
  private String Esp;
  private int Esq;
  private FrameLayout ExV;
  private long dUy = 0L;
  private boolean gVd;
  private boolean isWaiting;
  private int jqs;
  private int mEX;
  private int mEY;
  private long startTime = 0L;
  
  private void a(aj paramaj)
  {
    AppMethodBeat.i(203849);
    if ((paramaj != null) && (this.ExV != null) && (this.ESi == null))
    {
      if ((Util.isNullOrNil(paramaj.desc)) || (paramaj.DZH == null))
      {
        AppMethodBeat.o(203849);
        return;
      }
      this.ESi = new g(this, paramaj, this.ExV);
      if (getResources().getConfiguration().orientation != 1) {
        break label95;
      }
      this.ESi.fdb();
    }
    for (;;)
    {
      vA(false);
      AppMethodBeat.o(203849);
      return;
      label95:
      if (getResources().getConfiguration().orientation == 2) {
        this.ESi.fda();
      }
    }
  }
  
  public static ah fcZ()
  {
    AppMethodBeat.i(203848);
    if (ae.DJT != null)
    {
      localah = ae.DJT;
      AppMethodBeat.o(203848);
      return localah;
    }
    ah localah = new ah();
    AppMethodBeat.o(203848);
    return localah;
  }
  
  private void vA(boolean paramBoolean)
  {
    AppMethodBeat.i(203850);
    if (this.ESi != null)
    {
      Log.d("VideoFullScreenActivity", "hideFloatBarView");
      this.ESi.vf(paramBoolean);
    }
    AppMethodBeat.o(203850);
  }
  
  public void finish()
  {
    AppMethodBeat.i(203856);
    Intent localIntent = null;
    for (;;)
    {
      try
      {
        if (this.jqs != 0) {
          continue;
        }
        localIntent = this.ESg.fgN();
        if (localIntent != null)
        {
          this.dUy += System.currentTimeMillis() - this.startTime;
          localIntent.putExtra("KComponentFullScreenStayTime", this.dUy);
          if (this.ESi != null)
          {
            this.ESi.eXd();
            localIntent.putExtra("KComponentFullVideoFloatBarReportInfo", this.ESi.fdc());
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
      AppMethodBeat.o(203856);
      return;
      if (this.jqs == 1) {
        localIntent = this.ESh.ffW();
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2131492964;
  }
  
  public void onCancel()
  {
    AppMethodBeat.i(203859);
    super.onCancel();
    setRequestedOrientation(4);
    AppMethodBeat.o(203859);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(203858);
    super.onConfigurationChanged(paramConfiguration);
    try
    {
      if (paramConfiguration.orientation == 2)
      {
        Log.i("VideoFullScreenActivity", "ORIENTATION_LANDSCAPE");
        if (this.ESi != null)
        {
          this.ESi.fda();
          AppMethodBeat.o(203858);
        }
      }
      else if (paramConfiguration.orientation == 1)
      {
        Log.i("VideoFullScreenActivity", "ORIENTATION_PORTRAIT");
        if (this.ESi != null) {
          this.ESi.fdb();
        }
      }
      AppMethodBeat.o(203858);
      return;
    }
    catch (Throwable paramConfiguration)
    {
      Log.e("VideoFullScreenActivity", paramConfiguration.toString());
      AppMethodBeat.o(203858);
    }
  }
  
  /* Error */
  public void onCreate(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc 220
    //   2: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aload_1
    //   7: invokespecial 222	com/tencent/mm/ui/MMActivity:onCreate	(Landroid/os/Bundle;)V
    //   10: aload_0
    //   11: invokestatic 157	java/lang/System:currentTimeMillis	()J
    //   14: putfield 47	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:startTime	J
    //   17: aload_0
    //   18: invokestatic 228	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ap:aL	(Landroid/app/Activity;)V
    //   21: aload_0
    //   22: getfield 232	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:mController	Lcom/tencent/mm/ui/t;
    //   25: invokevirtual 237	com/tencent/mm/ui/t:hideTitleView	()V
    //   28: aload_0
    //   29: aload_0
    //   30: invokevirtual 240	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   33: ldc 242
    //   35: iconst_0
    //   36: invokevirtual 246	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   39: putfield 143	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:jqs	I
    //   42: aload_0
    //   43: aload_0
    //   44: invokevirtual 240	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   47: ldc 248
    //   49: invokevirtual 252	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   52: putfield 254	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Esm	Ljava/lang/String;
    //   55: aload_0
    //   56: aload_0
    //   57: invokevirtual 240	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   60: ldc_w 256
    //   63: iconst_0
    //   64: invokevirtual 246	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   67: putfield 258	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Esn	I
    //   70: aload_0
    //   71: aload_0
    //   72: invokevirtual 240	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   75: ldc_w 260
    //   78: iconst_0
    //   79: invokevirtual 246	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   82: putfield 262	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Eso	I
    //   85: aload_0
    //   86: aload_0
    //   87: invokevirtual 240	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   90: ldc_w 264
    //   93: iconst_0
    //   94: invokevirtual 268	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   97: putfield 270	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:EeY	Z
    //   100: aload_0
    //   101: aload_0
    //   102: invokevirtual 240	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   105: ldc_w 272
    //   108: iconst_0
    //   109: invokevirtual 268	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   112: putfield 274	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:gVd	Z
    //   115: aload_0
    //   116: aload_0
    //   117: invokevirtual 240	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   120: ldc_w 276
    //   123: invokevirtual 252	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   126: putfield 278	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:DYR	Ljava/lang/String;
    //   129: aload_0
    //   130: aload_0
    //   131: invokevirtual 240	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   134: ldc_w 280
    //   137: invokevirtual 252	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   140: putfield 282	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Esp	Ljava/lang/String;
    //   143: aload_0
    //   144: aload_0
    //   145: invokevirtual 240	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   148: ldc_w 284
    //   151: iconst_0
    //   152: invokevirtual 268	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   155: putfield 286	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:isWaiting	Z
    //   158: aload_0
    //   159: aload_0
    //   160: invokevirtual 240	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   163: ldc_w 288
    //   166: iconst_0
    //   167: invokevirtual 246	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   170: putfield 290	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:EgO	I
    //   173: aload_0
    //   174: aload_0
    //   175: invokevirtual 240	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   178: ldc_w 292
    //   181: iconst_0
    //   182: invokevirtual 246	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   185: putfield 294	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Esq	I
    //   188: aload_0
    //   189: aload_0
    //   190: invokevirtual 240	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   193: ldc_w 296
    //   196: iconst_0
    //   197: invokevirtual 268	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   200: putfield 298	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ESk	Z
    //   203: ldc 126
    //   205: new 300	java/lang/StringBuilder
    //   208: dup
    //   209: ldc_w 302
    //   212: invokespecial 305	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   215: aload_0
    //   216: getfield 143	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:jqs	I
    //   219: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   222: ldc_w 311
    //   225: invokevirtual 314	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload_0
    //   229: getfield 254	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Esm	Ljava/lang/String;
    //   232: invokevirtual 314	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: ldc_w 316
    //   238: invokevirtual 314	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload_0
    //   242: getfield 258	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Esn	I
    //   245: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: ldc_w 318
    //   251: invokevirtual 314	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload_0
    //   255: getfield 262	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Eso	I
    //   258: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   261: ldc_w 320
    //   264: invokevirtual 314	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_0
    //   268: getfield 270	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:EeY	Z
    //   271: invokevirtual 323	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   274: ldc_w 325
    //   277: invokevirtual 314	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload_0
    //   281: getfield 274	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:gVd	Z
    //   284: invokevirtual 323	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   287: ldc_w 327
    //   290: invokevirtual 314	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload_0
    //   294: getfield 282	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Esp	Ljava/lang/String;
    //   297: invokevirtual 314	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: ldc_w 329
    //   303: invokevirtual 314	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload_0
    //   307: getfield 286	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:isWaiting	Z
    //   310: invokevirtual 323	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   313: ldc_w 331
    //   316: invokevirtual 314	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload_0
    //   320: getfield 290	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:EgO	I
    //   323: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   326: ldc_w 333
    //   329: invokevirtual 314	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload_0
    //   333: getfield 298	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ESk	Z
    //   336: invokevirtual 323	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   339: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 215	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: aload_0
    //   346: getfield 143	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:jqs	I
    //   349: iconst_1
    //   350: if_icmpne +29 -> 379
    //   353: aload_0
    //   354: getfield 298	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ESk	Z
    //   357: ifeq +22 -> 379
    //   360: aload_0
    //   361: iconst_0
    //   362: invokevirtual 206	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:setRequestedOrientation	(I)V
    //   365: new 8	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity$1
    //   368: dup
    //   369: aload_0
    //   370: invokespecial 337	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity$1:<init>	(Lcom/tencent/mm/plugin/sns/ui/VideoFullScreenActivity;)V
    //   373: ldc2_w 338
    //   376: invokestatic 345	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThreadDelayed	(Ljava/lang/Runnable;J)V
    //   379: aload_0
    //   380: invokestatic 349	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ap:ha	(Landroid/content/Context;)[I
    //   383: astore_1
    //   384: aload_0
    //   385: aload_1
    //   386: iconst_0
    //   387: iaload
    //   388: putfield 351	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:mEX	I
    //   391: aload_0
    //   392: aload_1
    //   393: iconst_1
    //   394: iaload
    //   395: putfield 353	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:mEY	I
    //   398: aload_0
    //   399: invokestatic 359	com/tencent/mm/ui/ao:aQ	(Landroid/content/Context;)Z
    //   402: ifeq +666 -> 1068
    //   405: aload_0
    //   406: invokevirtual 90	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getResources	()Landroid/content/res/Resources;
    //   409: invokevirtual 96	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   412: getfield 101	android/content/res/Configuration:orientation	I
    //   415: iconst_1
    //   416: if_icmpne +652 -> 1068
    //   419: aload_0
    //   420: aload_0
    //   421: getfield 353	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:mEY	I
    //   424: aload_0
    //   425: invokestatic 363	com/tencent/mm/ui/ao:aP	(Landroid/content/Context;)I
    //   428: isub
    //   429: putfield 353	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:mEY	I
    //   432: ldc 126
    //   434: new 300	java/lang/StringBuilder
    //   437: dup
    //   438: ldc_w 365
    //   441: invokespecial 305	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   444: aload_0
    //   445: getfield 353	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:mEY	I
    //   448: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   451: ldc_w 367
    //   454: invokevirtual 314	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: aload_0
    //   458: getfield 351	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:mEX	I
    //   461: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   464: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokestatic 215	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   470: aload_0
    //   471: getfield 143	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:jqs	I
    //   474: ifne +811 -> 1285
    //   477: aload_0
    //   478: aload_0
    //   479: ldc_w 368
    //   482: invokevirtual 372	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:findViewById	(I)Landroid/view/View;
    //   485: checkcast 374	android/widget/FrameLayout
    //   488: putfield 61	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ExV	Landroid/widget/FrameLayout;
    //   491: aload_0
    //   492: new 147	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView
    //   495: dup
    //   496: aload_0
    //   497: invokespecial 377	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:<init>	(Landroid/content/Context;)V
    //   500: putfield 145	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ESg	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   503: aload_0
    //   504: getfield 61	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ExV	Landroid/widget/FrameLayout;
    //   507: aload_0
    //   508: getfield 145	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ESg	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   511: invokevirtual 381	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   514: aload_0
    //   515: getfield 145	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ESg	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   518: astore_1
    //   519: aload_0
    //   520: getfield 351	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:mEX	I
    //   523: istore_2
    //   524: aload_0
    //   525: getfield 353	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:mEY	I
    //   528: istore_3
    //   529: iload_3
    //   530: iload_2
    //   531: if_icmplt +587 -> 1118
    //   534: aload_1
    //   535: iload_2
    //   536: putfield 382	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mEX	I
    //   539: aload_1
    //   540: iload_3
    //   541: putfield 383	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mEY	I
    //   544: aload_1
    //   545: aload_1
    //   546: getfield 387	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   549: bipush 32
    //   551: invokestatic 393	com/tencent/mm/cb/a:fromDPToPix	(Landroid/content/Context;I)I
    //   554: putfield 396	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:length	I
    //   557: aload_0
    //   558: getfield 145	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ESg	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   561: astore_1
    //   562: aload_0
    //   563: getfield 143	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:jqs	I
    //   566: istore_2
    //   567: aload_0
    //   568: getfield 254	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Esm	Ljava/lang/String;
    //   571: astore 10
    //   573: aload_0
    //   574: getfield 258	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Esn	I
    //   577: istore_3
    //   578: aload_0
    //   579: getfield 262	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Eso	I
    //   582: istore 4
    //   584: aload_0
    //   585: getfield 270	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:EeY	Z
    //   588: istore 7
    //   590: aload_0
    //   591: getfield 274	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:gVd	Z
    //   594: istore 8
    //   596: aload_0
    //   597: getfield 278	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:DYR	Ljava/lang/String;
    //   600: astore 11
    //   602: aload_0
    //   603: getfield 282	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Esp	Ljava/lang/String;
    //   606: astore 12
    //   608: aload_1
    //   609: iconst_1
    //   610: putfield 399	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:isInit	Z
    //   613: aload_1
    //   614: iconst_1
    //   615: putfield 402	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:isFirst	Z
    //   618: aload_1
    //   619: iload_2
    //   620: putfield 403	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:jqs	I
    //   623: aload_1
    //   624: aload 10
    //   626: putfield 404	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Esm	Ljava/lang/String;
    //   629: aload_1
    //   630: iload_3
    //   631: putfield 405	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Esn	I
    //   634: aload_1
    //   635: iload 4
    //   637: putfield 406	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Eso	I
    //   640: aload_1
    //   641: iload 7
    //   643: putfield 407	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:EeY	Z
    //   646: aload_1
    //   647: iload 8
    //   649: putfield 408	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:gVd	Z
    //   652: aload_1
    //   653: aload 11
    //   655: putfield 409	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:DYR	Ljava/lang/String;
    //   658: aload_1
    //   659: aload 12
    //   661: putfield 410	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Esp	Ljava/lang/String;
    //   664: aload_0
    //   665: getfield 145	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ESg	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   668: astore_1
    //   669: aload_1
    //   670: aload_1
    //   671: getfield 387	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   674: invokestatic 416	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   677: ldc_w 417
    //   680: aload_1
    //   681: iconst_1
    //   682: invokevirtual 421	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   685: putfield 425	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   688: aload_1
    //   689: aload_1
    //   690: getfield 425	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   693: ldc_w 426
    //   696: invokevirtual 429	android/view/View:findViewById	(I)Landroid/view/View;
    //   699: checkcast 374	android/widget/FrameLayout
    //   702: putfield 432	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Esi	Landroid/widget/FrameLayout;
    //   705: aload_1
    //   706: aload_1
    //   707: getfield 425	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   710: ldc_w 433
    //   713: invokevirtual 429	android/view/View:findViewById	(I)Landroid/view/View;
    //   716: putfield 436	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Esj	Landroid/view/View;
    //   719: aload_1
    //   720: aload_1
    //   721: getfield 425	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   724: ldc_w 437
    //   727: invokevirtual 429	android/view/View:findViewById	(I)Landroid/view/View;
    //   730: putfield 440	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Esk	Landroid/view/View;
    //   733: aload_1
    //   734: aload_1
    //   735: getfield 425	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   738: ldc_w 441
    //   741: invokevirtual 429	android/view/View:findViewById	(I)Landroid/view/View;
    //   744: checkcast 443	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar
    //   747: putfield 447	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:EeP	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   750: aload_1
    //   751: new 449	com/tencent/mm/plugin/sns/ui/OfflineVideoView
    //   754: dup
    //   755: aload_1
    //   756: getfield 387	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   759: invokespecial 450	com/tencent/mm/plugin/sns/ui/OfflineVideoView:<init>	(Landroid/content/Context;)V
    //   762: putfield 454	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Ewn	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   765: aload_1
    //   766: getfield 454	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Ewn	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   769: iconst_1
    //   770: invokevirtual 457	com/tencent/mm/plugin/sns/ui/OfflineVideoView:setClickable	(Z)V
    //   773: aload_1
    //   774: getfield 454	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Ewn	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   777: aload_1
    //   778: invokevirtual 461	com/tencent/mm/plugin/sns/ui/OfflineVideoView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   781: aload_1
    //   782: getfield 432	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Esi	Landroid/widget/FrameLayout;
    //   785: aload_1
    //   786: getfield 454	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Ewn	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   789: invokevirtual 381	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   792: aload_1
    //   793: getfield 447	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:EeP	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   796: iconst_0
    //   797: invokevirtual 464	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setVisibility	(I)V
    //   800: aload_1
    //   801: getfield 447	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:EeP	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   804: aload_1
    //   805: getfield 468	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Efl	Landroid/view/View$OnClickListener;
    //   808: invokevirtual 472	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setOnPlayButtonClickListener	(Landroid/view/View$OnClickListener;)V
    //   811: aload_1
    //   812: getfield 447	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:EeP	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   815: aload_1
    //   816: getfield 476	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:tni	Lcom/tencent/mm/plugin/sight/decode/ui/b;
    //   819: invokevirtual 480	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setIplaySeekCallback	(Lcom/tencent/mm/plugin/sight/decode/ui/b;)V
    //   822: aload_1
    //   823: aload_1
    //   824: ldc_w 481
    //   827: invokevirtual 482	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:findViewById	(I)Landroid/view/View;
    //   830: checkcast 484	android/widget/ImageView
    //   833: putfield 488	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Egd	Landroid/widget/ImageView;
    //   836: aload_1
    //   837: getfield 488	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Egd	Landroid/widget/ImageView;
    //   840: iconst_0
    //   841: invokevirtual 489	android/widget/ImageView:setVisibility	(I)V
    //   844: aload_1
    //   845: getfield 488	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Egd	Landroid/widget/ImageView;
    //   848: aload_1
    //   849: invokevirtual 492	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   852: aload_1
    //   853: aload_1
    //   854: ldc_w 493
    //   857: invokevirtual 482	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:findViewById	(I)Landroid/view/View;
    //   860: checkcast 484	android/widget/ImageView
    //   863: putfield 496	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:EeQ	Landroid/widget/ImageView;
    //   866: aload_1
    //   867: getfield 496	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:EeQ	Landroid/widget/ImageView;
    //   870: iconst_0
    //   871: invokevirtual 489	android/widget/ImageView:setVisibility	(I)V
    //   874: aload_1
    //   875: getfield 496	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:EeQ	Landroid/widget/ImageView;
    //   878: aload_1
    //   879: invokevirtual 492	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   882: aload_1
    //   883: aload_1
    //   884: getfield 425	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   887: ldc_w 497
    //   890: invokevirtual 429	android/view/View:findViewById	(I)Landroid/view/View;
    //   893: putfield 500	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Ege	Landroid/view/View;
    //   896: aload_1
    //   897: getfield 500	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Ege	Landroid/view/View;
    //   900: bipush 8
    //   902: invokevirtual 501	android/view/View:setVisibility	(I)V
    //   905: aload_1
    //   906: getfield 387	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   909: invokevirtual 504	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   912: invokevirtual 96	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   915: getfield 101	android/content/res/Configuration:orientation	I
    //   918: iconst_2
    //   919: if_icmpne +256 -> 1175
    //   922: ldc_w 506
    //   925: ldc 213
    //   927: invokestatic 215	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   930: aload_1
    //   931: invokevirtual 507	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:fda	()V
    //   934: aload_1
    //   935: getfield 447	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:EeP	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   938: invokevirtual 510	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:getVideoTotalTime	()I
    //   941: aload_1
    //   942: getfield 406	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Eso	I
    //   945: sipush 1000
    //   948: idiv
    //   949: if_icmpeq +18 -> 967
    //   952: aload_1
    //   953: getfield 447	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:EeP	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   956: aload_1
    //   957: getfield 406	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Eso	I
    //   960: sipush 1000
    //   963: idiv
    //   964: invokevirtual 513	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setVideoTotalTime	(I)V
    //   967: aload_1
    //   968: getfield 447	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:EeP	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   971: aload_1
    //   972: getfield 405	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Esn	I
    //   975: sipush 1000
    //   978: idiv
    //   979: invokevirtual 516	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:seek	(I)V
    //   982: aload_1
    //   983: aload_1
    //   984: getfield 408	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:gVd	Z
    //   987: invokevirtual 519	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:vh	(Z)V
    //   990: aload_1
    //   991: getfield 454	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Ewn	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   994: new 521	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView$2
    //   997: dup
    //   998: aload_1
    //   999: invokespecial 524	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView$2:<init>	(Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;)V
    //   1002: invokevirtual 528	com/tencent/mm/plugin/sns/ui/OfflineVideoView:setVideoCallback	(Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView$a;)V
    //   1005: aload_1
    //   1006: getfield 454	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Ewn	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   1009: invokevirtual 531	com/tencent/mm/plugin/sns/ui/OfflineVideoView:cWZ	()V
    //   1012: aload_1
    //   1013: iconst_1
    //   1014: invokevirtual 534	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:setFocus	(Z)V
    //   1017: aload_0
    //   1018: getfield 145	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ESg	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   1021: aload_0
    //   1022: invokevirtual 538	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:setProgressBarStatusListener	(Lcom/tencent/mm/plugin/sns/ui/d/a;)V
    //   1025: getstatic 544	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah$b:Egv	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/v;
    //   1028: ifnull +21 -> 1049
    //   1031: aload_0
    //   1032: getstatic 544	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ah$b:Egv	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/v;
    //   1035: getfield 549	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/v:DZc	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aj;
    //   1038: putfield 551	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ESj	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aj;
    //   1041: aload_0
    //   1042: aload_0
    //   1043: getfield 551	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ESj	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aj;
    //   1046: invokespecial 553	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:a	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aj;)V
    //   1049: ldc 220
    //   1051: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1054: return
    //   1055: astore_1
    //   1056: ldc 126
    //   1058: aload_1
    //   1059: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1062: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1065: goto -720 -> 345
    //   1068: aload_0
    //   1069: invokestatic 359	com/tencent/mm/ui/ao:aQ	(Landroid/content/Context;)Z
    //   1072: ifeq -640 -> 432
    //   1075: aload_0
    //   1076: invokevirtual 90	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getResources	()Landroid/content/res/Resources;
    //   1079: invokevirtual 96	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   1082: getfield 101	android/content/res/Configuration:orientation	I
    //   1085: iconst_2
    //   1086: if_icmpne -654 -> 432
    //   1089: aload_0
    //   1090: aload_0
    //   1091: getfield 351	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:mEX	I
    //   1094: aload_0
    //   1095: invokestatic 363	com/tencent/mm/ui/ao:aP	(Landroid/content/Context;)I
    //   1098: isub
    //   1099: putfield 351	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:mEX	I
    //   1102: goto -670 -> 432
    //   1105: astore_1
    //   1106: ldc 126
    //   1108: aload_1
    //   1109: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1112: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1115: goto -645 -> 470
    //   1118: aload_1
    //   1119: iload_2
    //   1120: putfield 383	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mEY	I
    //   1123: aload_1
    //   1124: iload_3
    //   1125: putfield 382	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mEX	I
    //   1128: goto -584 -> 544
    //   1131: astore_1
    //   1132: ldc_w 506
    //   1135: aload_1
    //   1136: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1139: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1142: goto -585 -> 557
    //   1145: astore_1
    //   1146: ldc 126
    //   1148: aload_1
    //   1149: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1152: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1155: ldc 220
    //   1157: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1160: return
    //   1161: astore_1
    //   1162: ldc_w 506
    //   1165: aload_1
    //   1166: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1169: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1172: goto -508 -> 664
    //   1175: aload_1
    //   1176: getfield 387	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   1179: invokevirtual 504	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1182: invokevirtual 96	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   1185: getfield 101	android/content/res/Configuration:orientation	I
    //   1188: iconst_1
    //   1189: if_icmpne -255 -> 934
    //   1192: ldc_w 506
    //   1195: ldc 217
    //   1197: invokestatic 215	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1200: aload_1
    //   1201: invokevirtual 554	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:fdb	()V
    //   1204: goto -270 -> 934
    //   1207: astore 10
    //   1209: ldc_w 506
    //   1212: aload 10
    //   1214: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1217: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1220: goto -286 -> 934
    //   1223: astore_1
    //   1224: ldc_w 506
    //   1227: aload_1
    //   1228: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1231: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1234: goto -217 -> 1017
    //   1237: astore 10
    //   1239: ldc_w 506
    //   1242: aload 10
    //   1244: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1247: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1250: goto -260 -> 990
    //   1253: astore 10
    //   1255: ldc_w 506
    //   1258: aload 10
    //   1260: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1263: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1266: goto -261 -> 1005
    //   1269: astore_1
    //   1270: ldc 126
    //   1272: aload_1
    //   1273: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1276: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1279: ldc 220
    //   1281: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1284: return
    //   1285: aload_0
    //   1286: getfield 143	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:jqs	I
    //   1289: iconst_1
    //   1290: if_icmpne +649 -> 1939
    //   1293: aload_0
    //   1294: aload_0
    //   1295: ldc_w 368
    //   1298: invokevirtual 372	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:findViewById	(I)Landroid/view/View;
    //   1301: checkcast 374	android/widget/FrameLayout
    //   1304: putfield 61	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ExV	Landroid/widget/FrameLayout;
    //   1307: aload_0
    //   1308: new 187	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView
    //   1311: dup
    //   1312: aload_0
    //   1313: invokespecial 555	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:<init>	(Landroid/content/Context;)V
    //   1316: putfield 185	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ESh	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1319: aload_0
    //   1320: getfield 61	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ExV	Landroid/widget/FrameLayout;
    //   1323: aload_0
    //   1324: getfield 185	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ESh	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1327: invokevirtual 381	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   1330: aload_0
    //   1331: getfield 185	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ESh	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1334: astore_1
    //   1335: aload_0
    //   1336: getfield 351	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:mEX	I
    //   1339: istore_2
    //   1340: aload_0
    //   1341: getfield 353	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:mEY	I
    //   1344: istore_3
    //   1345: iload_3
    //   1346: iload_2
    //   1347: if_icmplt +598 -> 1945
    //   1350: aload_1
    //   1351: iload_2
    //   1352: putfield 556	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mEX	I
    //   1355: aload_1
    //   1356: iload_3
    //   1357: putfield 557	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mEY	I
    //   1360: aload_1
    //   1361: aload_1
    //   1362: getfield 558	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mContext	Landroid/content/Context;
    //   1365: bipush 32
    //   1367: invokestatic 393	com/tencent/mm/cb/a:fromDPToPix	(Landroid/content/Context;I)I
    //   1370: putfield 559	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:length	I
    //   1373: aload_0
    //   1374: getfield 185	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ESh	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1377: astore_1
    //   1378: aload_0
    //   1379: getfield 143	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:jqs	I
    //   1382: istore_2
    //   1383: aload_0
    //   1384: getfield 254	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Esm	Ljava/lang/String;
    //   1387: astore 10
    //   1389: aload_0
    //   1390: getfield 258	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Esn	I
    //   1393: istore_3
    //   1394: aload_0
    //   1395: getfield 262	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Eso	I
    //   1398: istore 4
    //   1400: aload_0
    //   1401: getfield 270	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:EeY	Z
    //   1404: istore 7
    //   1406: aload_0
    //   1407: getfield 274	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:gVd	Z
    //   1410: istore 8
    //   1412: aload_0
    //   1413: getfield 278	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:DYR	Ljava/lang/String;
    //   1416: astore 11
    //   1418: aload_0
    //   1419: getfield 282	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Esp	Ljava/lang/String;
    //   1422: astore 12
    //   1424: aload_0
    //   1425: getfield 286	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:isWaiting	Z
    //   1428: istore 9
    //   1430: aload_0
    //   1431: getfield 290	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:EgO	I
    //   1434: istore 5
    //   1436: aload_0
    //   1437: getfield 294	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Esq	I
    //   1440: istore 6
    //   1442: aload_1
    //   1443: iconst_1
    //   1444: putfield 562	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:htU	Z
    //   1447: aload_1
    //   1448: iconst_1
    //   1449: putfield 563	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:isFirst	Z
    //   1452: aload_1
    //   1453: iload_2
    //   1454: putfield 564	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:jqs	I
    //   1457: aload_1
    //   1458: aload 10
    //   1460: putfield 565	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Esm	Ljava/lang/String;
    //   1463: aload_1
    //   1464: iload_3
    //   1465: putfield 566	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Esn	I
    //   1468: aload_1
    //   1469: iload 4
    //   1471: putfield 567	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Eso	I
    //   1474: aload_1
    //   1475: iload 7
    //   1477: putfield 568	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:EeY	Z
    //   1480: aload_1
    //   1481: iload 8
    //   1483: putfield 569	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:gVd	Z
    //   1486: aload_1
    //   1487: aload 11
    //   1489: putfield 570	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:DYR	Ljava/lang/String;
    //   1492: aload_1
    //   1493: aload 12
    //   1495: putfield 571	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Esp	Ljava/lang/String;
    //   1498: aload_1
    //   1499: iload 9
    //   1501: putfield 572	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:isWaiting	Z
    //   1504: aload_1
    //   1505: iload 5
    //   1507: putfield 573	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:EgO	I
    //   1510: aload_1
    //   1511: iload 6
    //   1513: putfield 574	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Esq	I
    //   1516: aload_0
    //   1517: getfield 185	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ESh	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1520: astore_1
    //   1521: aload_1
    //   1522: aload_1
    //   1523: getfield 558	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mContext	Landroid/content/Context;
    //   1526: invokestatic 416	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   1529: ldc_w 575
    //   1532: aload_1
    //   1533: iconst_1
    //   1534: invokevirtual 421	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   1537: putfield 576	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1540: aload_1
    //   1541: aload_1
    //   1542: getfield 576	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1545: ldc_w 426
    //   1548: invokevirtual 429	android/view/View:findViewById	(I)Landroid/view/View;
    //   1551: checkcast 374	android/widget/FrameLayout
    //   1554: putfield 577	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Esi	Landroid/widget/FrameLayout;
    //   1557: aload_1
    //   1558: new 579	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper
    //   1561: dup
    //   1562: aload_1
    //   1563: getfield 558	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mContext	Landroid/content/Context;
    //   1566: invokespecial 580	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:<init>	(Landroid/content/Context;)V
    //   1569: putfield 584	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Esl	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1572: aload_1
    //   1573: getfield 577	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Esi	Landroid/widget/FrameLayout;
    //   1576: aload_1
    //   1577: getfield 584	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Esl	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1580: invokevirtual 381	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   1583: aload_1
    //   1584: getfield 584	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Esl	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1587: aload_1
    //   1588: invokevirtual 588	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setIMMVideoViewCallback	(Lcom/tencent/mm/pluginsdk/ui/i$b;)V
    //   1591: aload_1
    //   1592: getfield 584	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Esl	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1595: iconst_1
    //   1596: invokevirtual 591	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setFullScreen	(Z)V
    //   1599: aload_1
    //   1600: getfield 584	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Esl	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1603: iconst_0
    //   1604: aload_1
    //   1605: getfield 571	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Esp	Ljava/lang/String;
    //   1608: iconst_0
    //   1609: invokevirtual 595	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:c	(ZLjava/lang/String;I)V
    //   1612: aload_1
    //   1613: getfield 584	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Esl	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1616: iconst_1
    //   1617: invokevirtual 596	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setClickable	(Z)V
    //   1620: aload_1
    //   1621: getfield 584	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Esl	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1624: aload_1
    //   1625: invokevirtual 597	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   1628: aload_1
    //   1629: getfield 584	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Esl	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1632: iconst_1
    //   1633: invokevirtual 600	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setLoop	(Z)V
    //   1636: aload_1
    //   1637: getfield 584	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Esl	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1640: aload_1
    //   1641: invokevirtual 604	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setLoopCompletionCallback	(Lcom/tencent/mm/pluginsdk/ui/i$d;)V
    //   1644: aload_1
    //   1645: aload_1
    //   1646: getfield 576	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1649: ldc_w 433
    //   1652: invokevirtual 429	android/view/View:findViewById	(I)Landroid/view/View;
    //   1655: putfield 605	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Esj	Landroid/view/View;
    //   1658: aload_1
    //   1659: aload_1
    //   1660: getfield 576	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1663: ldc_w 437
    //   1666: invokevirtual 429	android/view/View:findViewById	(I)Landroid/view/View;
    //   1669: putfield 606	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Esk	Landroid/view/View;
    //   1672: aload_1
    //   1673: aload_1
    //   1674: getfield 576	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1677: ldc_w 441
    //   1680: invokevirtual 429	android/view/View:findViewById	(I)Landroid/view/View;
    //   1683: checkcast 443	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar
    //   1686: putfield 607	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:EeP	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1689: aload_1
    //   1690: getfield 607	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:EeP	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1693: iconst_0
    //   1694: invokevirtual 464	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setVisibility	(I)V
    //   1697: aload_1
    //   1698: getfield 607	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:EeP	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1701: aload_1
    //   1702: getfield 608	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Efl	Landroid/view/View$OnClickListener;
    //   1705: invokevirtual 472	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setOnPlayButtonClickListener	(Landroid/view/View$OnClickListener;)V
    //   1708: aload_1
    //   1709: getfield 607	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:EeP	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1712: aload_1
    //   1713: getfield 609	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:tni	Lcom/tencent/mm/plugin/sight/decode/ui/b;
    //   1716: invokevirtual 480	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setIplaySeekCallback	(Lcom/tencent/mm/plugin/sight/decode/ui/b;)V
    //   1719: aload_1
    //   1720: aload_1
    //   1721: ldc_w 481
    //   1724: invokevirtual 610	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:findViewById	(I)Landroid/view/View;
    //   1727: checkcast 484	android/widget/ImageView
    //   1730: putfield 611	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Egd	Landroid/widget/ImageView;
    //   1733: aload_1
    //   1734: getfield 611	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Egd	Landroid/widget/ImageView;
    //   1737: iconst_0
    //   1738: invokevirtual 489	android/widget/ImageView:setVisibility	(I)V
    //   1741: aload_1
    //   1742: getfield 611	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Egd	Landroid/widget/ImageView;
    //   1745: aload_1
    //   1746: invokevirtual 492	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1749: aload_1
    //   1750: aload_1
    //   1751: ldc_w 493
    //   1754: invokevirtual 610	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:findViewById	(I)Landroid/view/View;
    //   1757: checkcast 484	android/widget/ImageView
    //   1760: putfield 612	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:EeQ	Landroid/widget/ImageView;
    //   1763: aload_1
    //   1764: getfield 612	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:EeQ	Landroid/widget/ImageView;
    //   1767: iconst_0
    //   1768: invokevirtual 489	android/widget/ImageView:setVisibility	(I)V
    //   1771: aload_1
    //   1772: getfield 612	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:EeQ	Landroid/widget/ImageView;
    //   1775: aload_1
    //   1776: invokevirtual 492	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1779: aload_1
    //   1780: aload_1
    //   1781: getfield 576	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1784: ldc_w 497
    //   1787: invokevirtual 429	android/view/View:findViewById	(I)Landroid/view/View;
    //   1790: putfield 613	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Ege	Landroid/view/View;
    //   1793: aload_1
    //   1794: getfield 613	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Ege	Landroid/view/View;
    //   1797: bipush 8
    //   1799: invokevirtual 501	android/view/View:setVisibility	(I)V
    //   1802: aload_1
    //   1803: getfield 607	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:EeP	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1806: invokevirtual 617	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:getParent	()Landroid/view/ViewParent;
    //   1809: astore 10
    //   1811: aload 10
    //   1813: instanceof 619
    //   1816: ifeq +15 -> 1831
    //   1819: aload 10
    //   1821: checkcast 619	android/view/ViewGroup
    //   1824: aload_1
    //   1825: getfield 607	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:EeP	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1828: invokevirtual 622	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   1831: aload_1
    //   1832: getfield 584	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Esl	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1835: aload_1
    //   1836: getfield 607	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:EeP	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1839: invokevirtual 626	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setVideoFooterView	(Lcom/tencent/mm/pluginsdk/ui/h;)V
    //   1842: aload_1
    //   1843: getfield 558	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mContext	Landroid/content/Context;
    //   1846: invokevirtual 504	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1849: invokevirtual 96	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   1852: getfield 101	android/content/res/Configuration:orientation	I
    //   1855: iconst_2
    //   1856: if_icmpne +160 -> 2016
    //   1859: ldc_w 628
    //   1862: ldc 213
    //   1864: invokestatic 215	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1867: aload_1
    //   1868: invokevirtual 629	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:fda	()V
    //   1871: aload_1
    //   1872: getfield 568	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:EeY	Z
    //   1875: ifeq +189 -> 2064
    //   1878: aload_1
    //   1879: invokevirtual 632	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:fcJ	()V
    //   1882: aload_1
    //   1883: invokevirtual 635	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:czw	()V
    //   1886: aload_1
    //   1887: iconst_1
    //   1888: invokevirtual 636	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:setFocus	(Z)V
    //   1891: aload_0
    //   1892: getfield 185	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ESh	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1895: aload_0
    //   1896: invokevirtual 637	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:setProgressBarStatusListener	(Lcom/tencent/mm/plugin/sns/ui/d/a;)V
    //   1899: getstatic 643	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al$a:EgT	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/am;
    //   1902: ifnull +21 -> 1923
    //   1905: aload_0
    //   1906: getstatic 643	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al$a:EgT	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/am;
    //   1909: getfield 646	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/am:DZc	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aj;
    //   1912: putfield 551	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ESj	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aj;
    //   1915: aload_0
    //   1916: aload_0
    //   1917: getfield 551	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:ESj	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aj;
    //   1920: invokespecial 553	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:a	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aj;)V
    //   1923: ldc 220
    //   1925: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1928: return
    //   1929: astore_1
    //   1930: ldc 126
    //   1932: aload_1
    //   1933: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1936: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1939: ldc 220
    //   1941: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1944: return
    //   1945: aload_1
    //   1946: iload_2
    //   1947: putfield 557	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mEY	I
    //   1950: aload_1
    //   1951: iload_3
    //   1952: putfield 556	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mEX	I
    //   1955: goto -595 -> 1360
    //   1958: astore_1
    //   1959: ldc_w 628
    //   1962: aload_1
    //   1963: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1966: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1969: goto -596 -> 1373
    //   1972: astore_1
    //   1973: ldc_w 628
    //   1976: aload_1
    //   1977: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1980: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1983: goto -467 -> 1516
    //   1986: astore 10
    //   1988: ldc_w 628
    //   1991: aload 10
    //   1993: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1996: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1999: goto -355 -> 1644
    //   2002: astore_1
    //   2003: ldc_w 628
    //   2006: aload_1
    //   2007: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2010: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2013: goto -122 -> 1891
    //   2016: aload_1
    //   2017: getfield 558	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mContext	Landroid/content/Context;
    //   2020: invokevirtual 504	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   2023: invokevirtual 96	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   2026: getfield 101	android/content/res/Configuration:orientation	I
    //   2029: iconst_1
    //   2030: if_icmpne -159 -> 1871
    //   2033: ldc_w 628
    //   2036: ldc 217
    //   2038: invokestatic 215	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2041: aload_1
    //   2042: invokevirtual 647	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:fdb	()V
    //   2045: goto -174 -> 1871
    //   2048: astore 10
    //   2050: ldc_w 628
    //   2053: aload 10
    //   2055: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2058: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2061: goto -190 -> 1871
    //   2064: aload_1
    //   2065: invokevirtual 650	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:fcK	()V
    //   2068: goto -186 -> 1882
    //   2071: astore 10
    //   2073: ldc_w 628
    //   2076: aload 10
    //   2078: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2081: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2084: goto -198 -> 1886
    //   2087: astore_1
    //   2088: ldc 126
    //   2090: aload_1
    //   2091: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2094: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2097: ldc 220
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
    AppMethodBeat.i(203855);
    for (;;)
    {
      try
      {
        ae.DJT = null;
        if (this.jqs != 0) {
          continue;
        }
        localSightVideoFullScreenView = this.ESg;
      }
      catch (Throwable localThrowable2)
      {
        SightVideoFullScreenView localSightVideoFullScreenView;
        Log.e("VideoFullScreenActivity", localThrowable2.toString());
        continue;
        if (this.jqs != 1) {
          continue;
        }
        localLongVideoFullScreenView = this.ESh;
      }
      try
      {
        MMHandlerThread.removeRunnable(localSightVideoFullScreenView.EeU);
        MMHandlerThread.removeRunnable(localSightVideoFullScreenView.Egg);
        localSightVideoFullScreenView.Ewn.onDestroy();
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah.b.Egv = null;
        super.onDestroy();
        AppMethodBeat.o(203855);
        return;
      }
      catch (Throwable localThrowable1)
      {
        Log.e("SightVideoFullScreenView", localThrowable1.toString());
        continue;
      }
      try
      {
        LongVideoFullScreenView localLongVideoFullScreenView;
        MMHandlerThread.removeRunnable(localLongVideoFullScreenView.EeU);
        MMHandlerThread.removeRunnable(localLongVideoFullScreenView.Egg);
        localLongVideoFullScreenView.Esl.onUIDestroy();
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al.a.EgT = null;
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
    AppMethodBeat.i(203853);
    super.onPause();
    try
    {
      this.dUy += System.currentTimeMillis() - this.startTime;
      if (this.jqs == 0)
      {
        SightVideoFullScreenView localSightVideoFullScreenView = this.ESg;
        try
        {
          localSightVideoFullScreenView.DXw = false;
          MMHandlerThread.removeRunnable(localSightVideoFullScreenView.EeU);
          MMHandlerThread.removeRunnable(localSightVideoFullScreenView.Egg);
          AppMethodBeat.o(203853);
          return;
        }
        catch (Throwable localThrowable1)
        {
          Log.e("SightVideoFullScreenView", localThrowable1.toString());
          AppMethodBeat.o(203853);
          return;
        }
      }
      if (this.jqs != 1) {
        break label150;
      }
    }
    catch (Throwable localThrowable2)
    {
      Log.e("VideoFullScreenActivity", localThrowable2.toString());
      AppMethodBeat.o(203853);
      return;
    }
    LongVideoFullScreenView localLongVideoFullScreenView = this.ESh;
    try
    {
      localLongVideoFullScreenView.DXw = false;
      MMHandlerThread.removeRunnable(localLongVideoFullScreenView.EeU);
      MMHandlerThread.removeRunnable(localLongVideoFullScreenView.Egg);
      AppMethodBeat.o(203853);
      return;
    }
    catch (Throwable localThrowable3)
    {
      Log.e("LongVideoFullScreenView", localThrowable3.toString());
    }
    label150:
    AppMethodBeat.o(203853);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(203852);
    super.onResume();
    try
    {
      this.startTime = System.currentTimeMillis();
      ap.aL(this);
      if (this.jqs == 0)
      {
        this.ESg.DXw = true;
        AppMethodBeat.o(203852);
        return;
      }
      if (this.jqs == 1) {
        this.ESh.DXw = true;
      }
      AppMethodBeat.o(203852);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("VideoFullScreenActivity", localThrowable.toString());
      AppMethodBeat.o(203852);
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(203851);
    super.onStart();
    try
    {
      ap.aL(this);
      if (this.jqs == 0)
      {
        SightVideoFullScreenView localSightVideoFullScreenView = this.ESg;
        try
        {
          if ((!localSightVideoFullScreenView.isFirst) && (!localSightVideoFullScreenView.Ewn.isPlaying()) && (localSightVideoFullScreenView.Est))
          {
            localSightVideoFullScreenView.fgL();
            localSightVideoFullScreenView.Est = false;
          }
          localSightVideoFullScreenView.isFirst = false;
          AppMethodBeat.o(203851);
          return;
        }
        catch (Throwable localThrowable1)
        {
          Log.e("SightVideoFullScreenView", localThrowable1.toString());
          AppMethodBeat.o(203851);
          return;
        }
      }
      if (this.jqs != 1) {
        break label175;
      }
    }
    catch (Throwable localThrowable2)
    {
      Log.e("VideoFullScreenActivity", localThrowable2.toString());
      AppMethodBeat.o(203851);
      return;
    }
    LongVideoFullScreenView localLongVideoFullScreenView = this.ESh;
    try
    {
      if ((!localLongVideoFullScreenView.isFirst) && (!localLongVideoFullScreenView.Esl.isPlaying()) && (localLongVideoFullScreenView.Est))
      {
        localLongVideoFullScreenView.czw();
        localLongVideoFullScreenView.Est = false;
      }
      localLongVideoFullScreenView.isFirst = false;
      AppMethodBeat.o(203851);
      return;
    }
    catch (Throwable localThrowable3)
    {
      Log.e("LongVideoFullScreenView", localThrowable3.toString());
    }
    label175:
    AppMethodBeat.o(203851);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(203854);
    super.onStop();
    try
    {
      if (this.jqs == 0)
      {
        SightVideoFullScreenView localSightVideoFullScreenView = this.ESg;
        try
        {
          localSightVideoFullScreenView.isFirst = false;
          if (localSightVideoFullScreenView.Ewn.isPlaying())
          {
            localSightVideoFullScreenView.fgM();
            localSightVideoFullScreenView.Est = true;
          }
          AppMethodBeat.o(203854);
          return;
        }
        catch (Throwable localThrowable1)
        {
          Log.e("SightVideoFullScreenView", localThrowable1.toString());
          AppMethodBeat.o(203854);
          return;
        }
      }
      if (this.jqs != 1) {
        break label143;
      }
    }
    catch (Throwable localThrowable2)
    {
      Log.e("VideoFullScreenActivity", localThrowable2.toString());
      AppMethodBeat.o(203854);
      return;
    }
    LongVideoFullScreenView localLongVideoFullScreenView = this.ESh;
    try
    {
      localLongVideoFullScreenView.isFirst = false;
      if (localLongVideoFullScreenView.Esl.isPlaying())
      {
        localLongVideoFullScreenView.cXa();
        localLongVideoFullScreenView.Est = true;
      }
      AppMethodBeat.o(203854);
      return;
    }
    catch (Throwable localThrowable3)
    {
      Log.e("LongVideoFullScreenView", localThrowable3.toString());
    }
    label143:
    AppMethodBeat.o(203854);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setMMOrientation() {}
  
  public final void vB(boolean paramBoolean)
  {
    AppMethodBeat.i(203857);
    Log.i("VideoFullScreenActivity", "progressBarStatus visiblity = ".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      vA(true);
      AppMethodBeat.o(203857);
      return;
    }
    if (this.ESi != null)
    {
      Log.d("VideoFullScreenActivity", "showFloatBarView");
      this.ESi.fcY();
    }
    AppMethodBeat.o(203857);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.VideoFullScreenActivity
 * JD-Core Version:    0.7.0.1
 */