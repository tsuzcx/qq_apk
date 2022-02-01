package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ar;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(32)
public class VideoFullScreenActivity
  extends MMActivity
  implements com.tencent.mm.plugin.sns.ui.listener.a
{
  private boolean PQB;
  private g PSV;
  public al QJy;
  private String QKq;
  private int QSv;
  private SightVideoFullScreenView RGv;
  private LongVideoFullScreenView RGw;
  private boolean RGx;
  private String Rfi;
  private int Rfj;
  private int Rfk;
  private String Rfl;
  private int Rfm;
  private FrameLayout RlA;
  private boolean hLy;
  private long hTS = 0L;
  private boolean isWaiting;
  private int oYP;
  private int pvg;
  private int sJv;
  private long startTime = 0L;
  
  private void Er(boolean paramBoolean)
  {
    AppMethodBeat.i(307730);
    if (this.PSV != null)
    {
      Log.d("VideoFullScreenActivity", "hideFloatBarView");
      this.PSV.DU(paramBoolean);
    }
    AppMethodBeat.o(307730);
  }
  
  private void a(al paramal)
  {
    AppMethodBeat.i(307725);
    if ((paramal != null) && (this.RlA != null) && (this.PSV == null))
    {
      if ((Util.isNullOrNil(paramal.desc)) || (paramal.QLh == null))
      {
        AppMethodBeat.o(307725);
        return;
      }
      this.PSV = new g(this, paramal, this.RlA, 0);
      if (getResources().getConfiguration().orientation != 1) {
        break label96;
      }
      this.PSV.hiV();
    }
    for (;;)
    {
      Er(false);
      AppMethodBeat.o(307725);
      return;
      label96:
      if (getResources().getConfiguration().orientation == 2) {
        this.PSV.hiU();
      }
    }
  }
  
  public static ai hiS()
  {
    AppMethodBeat.i(307723);
    if (ag.Qud != null)
    {
      localai = ag.Qud;
      AppMethodBeat.o(307723);
      return localai;
    }
    ai localai = new ai();
    AppMethodBeat.o(307723);
    return localai;
  }
  
  public final void Es(boolean paramBoolean)
  {
    AppMethodBeat.i(307788);
    Log.i("VideoFullScreenActivity", "progressBarStatus visiblity = ".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      Er(true);
      AppMethodBeat.o(307788);
      return;
    }
    if (this.PSV != null)
    {
      Log.d("VideoFullScreenActivity", "showFloatBarView");
      this.PSV.hiR();
    }
    AppMethodBeat.o(307788);
  }
  
  public void finish()
  {
    AppMethodBeat.i(307786);
    Intent localIntent = null;
    for (;;)
    {
      try
      {
        if (this.oYP != 0) {
          continue;
        }
        localIntent = this.RGv.hnk();
        if (localIntent != null)
        {
          this.hTS += System.currentTimeMillis() - this.startTime;
          localIntent.putExtra("KComponentFullScreenStayTime", this.hTS);
          if (this.PSV != null)
          {
            this.PSV.has();
            localIntent.putExtra("KComponentFullVideoFloatBarReportInfo", this.PSV.hiW());
          }
        }
        setResult(1000, localIntent);
      }
      finally
      {
        Log.e("VideoFullScreenActivity", localObject.toString());
        continue;
      }
      super.finish();
      AppMethodBeat.o(307786);
      return;
      if (this.oYP == 1) {
        localIntent = this.RGw.hmm();
      }
    }
  }
  
  public int getLayoutId()
  {
    return b.g.activity_video_full_screen;
  }
  
  public void onCancel()
  {
    AppMethodBeat.i(307792);
    super.onCancel();
    setRequestedOrientation(4);
    AppMethodBeat.o(307792);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(307789);
    super.onConfigurationChanged(paramConfiguration);
    try
    {
      if (paramConfiguration.orientation == 2)
      {
        Log.i("VideoFullScreenActivity", "ORIENTATION_LANDSCAPE");
        if (this.PSV != null)
        {
          this.PSV.hiU();
          AppMethodBeat.o(307789);
        }
      }
      else if (paramConfiguration.orientation == 1)
      {
        Log.i("VideoFullScreenActivity", "ORIENTATION_PORTRAIT");
        if (this.PSV != null) {
          this.PSV.hiV();
        }
      }
      AppMethodBeat.o(307789);
      return;
    }
    finally
    {
      Log.e("VideoFullScreenActivity", paramConfiguration.toString());
      AppMethodBeat.o(307789);
    }
  }
  
  /* Error */
  public void onCreate(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc 243
    //   2: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aload_1
    //   7: invokespecial 245	com/tencent/mm/ui/MMActivity:onCreate	(Landroid/os/Bundle;)V
    //   10: aload_0
    //   11: invokestatic 176	java/lang/System:currentTimeMillis	()J
    //   14: putfield 47	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:startTime	J
    //   17: aload_0
    //   18: invokestatic 251	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ar:bt	(Landroid/app/Activity;)V
    //   21: aload_0
    //   22: getfield 255	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:mController	Lcom/tencent/mm/ui/y;
    //   25: invokevirtual 260	com/tencent/mm/ui/y:hideTitleView	()V
    //   28: aload_0
    //   29: aload_0
    //   30: invokevirtual 263	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   33: ldc_w 265
    //   36: iconst_0
    //   37: invokevirtual 269	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   40: putfield 162	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:oYP	I
    //   43: aload_0
    //   44: aload_0
    //   45: invokevirtual 263	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   48: ldc_w 271
    //   51: invokevirtual 274	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   54: putfield 276	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Rfi	Ljava/lang/String;
    //   57: aload_0
    //   58: aload_0
    //   59: invokevirtual 263	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   62: ldc_w 278
    //   65: iconst_0
    //   66: invokevirtual 269	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   69: putfield 280	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Rfj	I
    //   72: aload_0
    //   73: aload_0
    //   74: invokevirtual 263	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   77: ldc_w 282
    //   80: iconst_0
    //   81: invokevirtual 269	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   84: putfield 284	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Rfk	I
    //   87: aload_0
    //   88: aload_0
    //   89: invokevirtual 263	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   92: ldc_w 286
    //   95: iconst_0
    //   96: invokevirtual 290	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   99: putfield 292	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:PQB	Z
    //   102: aload_0
    //   103: aload_0
    //   104: invokevirtual 263	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   107: ldc_w 294
    //   110: iconst_0
    //   111: invokevirtual 290	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   114: putfield 296	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:hLy	Z
    //   117: aload_0
    //   118: aload_0
    //   119: invokevirtual 263	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   122: ldc_w 298
    //   125: invokevirtual 274	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   128: putfield 300	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:QKq	Ljava/lang/String;
    //   131: aload_0
    //   132: aload_0
    //   133: invokevirtual 263	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   136: ldc_w 302
    //   139: invokevirtual 274	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   142: putfield 304	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Rfl	Ljava/lang/String;
    //   145: aload_0
    //   146: aload_0
    //   147: invokevirtual 263	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   150: ldc_w 306
    //   153: iconst_0
    //   154: invokevirtual 290	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   157: putfield 308	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:isWaiting	Z
    //   160: aload_0
    //   161: aload_0
    //   162: invokevirtual 263	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   165: ldc_w 310
    //   168: iconst_0
    //   169: invokevirtual 269	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   172: putfield 312	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:QSv	I
    //   175: aload_0
    //   176: aload_0
    //   177: invokevirtual 263	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   180: ldc_w 314
    //   183: iconst_0
    //   184: invokevirtual 269	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   187: putfield 316	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Rfm	I
    //   190: aload_0
    //   191: aload_0
    //   192: invokevirtual 263	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   195: ldc_w 318
    //   198: iconst_0
    //   199: invokevirtual 290	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   202: putfield 320	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:RGx	Z
    //   205: ldc 63
    //   207: new 322	java/lang/StringBuilder
    //   210: dup
    //   211: ldc_w 324
    //   214: invokespecial 327	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   217: aload_0
    //   218: getfield 162	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:oYP	I
    //   221: invokevirtual 331	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   224: ldc_w 333
    //   227: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload_0
    //   231: getfield 276	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Rfi	Ljava/lang/String;
    //   234: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: ldc_w 338
    //   240: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload_0
    //   244: getfield 280	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Rfj	I
    //   247: invokevirtual 331	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   250: ldc_w 340
    //   253: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload_0
    //   257: getfield 284	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Rfk	I
    //   260: invokevirtual 331	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   263: ldc_w 342
    //   266: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload_0
    //   270: getfield 292	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:PQB	Z
    //   273: invokevirtual 345	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   276: ldc_w 347
    //   279: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload_0
    //   283: getfield 296	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:hLy	Z
    //   286: invokevirtual 345	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   289: ldc_w 349
    //   292: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload_0
    //   296: getfield 304	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Rfl	Ljava/lang/String;
    //   299: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: ldc_w 351
    //   305: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload_0
    //   309: getfield 308	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:isWaiting	Z
    //   312: invokevirtual 345	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   315: ldc_w 353
    //   318: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload_0
    //   322: getfield 312	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:QSv	I
    //   325: invokevirtual 331	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   328: ldc_w 355
    //   331: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: aload_0
    //   335: getfield 320	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:RGx	Z
    //   338: invokevirtual 345	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   341: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   347: aload_0
    //   348: getfield 162	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:oYP	I
    //   351: iconst_1
    //   352: if_icmpne +29 -> 381
    //   355: aload_0
    //   356: getfield 320	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:RGx	Z
    //   359: ifeq +22 -> 381
    //   362: aload_0
    //   363: iconst_0
    //   364: invokevirtual 231	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:setRequestedOrientation	(I)V
    //   367: new 8	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity$1
    //   370: dup
    //   371: aload_0
    //   372: invokespecial 359	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity$1:<init>	(Lcom/tencent/mm/plugin/sns/ui/VideoFullScreenActivity;)V
    //   375: ldc2_w 360
    //   378: invokestatic 367	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThreadDelayed	(Ljava/lang/Runnable;J)V
    //   381: aload_0
    //   382: invokestatic 371	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ar:jR	(Landroid/content/Context;)[I
    //   385: astore_1
    //   386: aload_0
    //   387: aload_1
    //   388: iconst_0
    //   389: iaload
    //   390: putfield 373	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:sJv	I
    //   393: aload_0
    //   394: aload_1
    //   395: iconst_1
    //   396: iaload
    //   397: putfield 375	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:pvg	I
    //   400: aload_0
    //   401: invokestatic 381	com/tencent/mm/ui/aw:bx	(Landroid/content/Context;)Z
    //   404: ifeq +674 -> 1078
    //   407: aload_0
    //   408: invokevirtual 106	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getResources	()Landroid/content/res/Resources;
    //   411: invokevirtual 112	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   414: getfield 117	android/content/res/Configuration:orientation	I
    //   417: iconst_1
    //   418: if_icmpne +660 -> 1078
    //   421: aload_0
    //   422: aload_0
    //   423: getfield 375	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:pvg	I
    //   426: aload_0
    //   427: invokestatic 385	com/tencent/mm/ui/aw:bw	(Landroid/content/Context;)I
    //   430: isub
    //   431: putfield 375	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:pvg	I
    //   434: ldc 63
    //   436: new 322	java/lang/StringBuilder
    //   439: dup
    //   440: ldc_w 387
    //   443: invokespecial 327	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   446: aload_0
    //   447: getfield 375	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:pvg	I
    //   450: invokevirtual 331	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   453: ldc_w 389
    //   456: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: aload_0
    //   460: getfield 373	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:sJv	I
    //   463: invokevirtual 331	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   466: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   472: aload_0
    //   473: getfield 162	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:oYP	I
    //   476: ifne +819 -> 1295
    //   479: aload_0
    //   480: aload_0
    //   481: getstatic 394	com/tencent/mm/plugin/sns/b$f:root	I
    //   484: invokevirtual 398	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:findViewById	(I)Landroid/view/View;
    //   487: checkcast 400	android/widget/FrameLayout
    //   490: putfield 84	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:RlA	Landroid/widget/FrameLayout;
    //   493: aload_0
    //   494: new 166	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView
    //   497: dup
    //   498: aload_0
    //   499: invokespecial 403	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:<init>	(Landroid/content/Context;)V
    //   502: putfield 164	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:RGv	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   505: aload_0
    //   506: getfield 84	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:RlA	Landroid/widget/FrameLayout;
    //   509: aload_0
    //   510: getfield 164	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:RGv	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   513: invokevirtual 407	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   516: aload_0
    //   517: getfield 164	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:RGv	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   520: astore_1
    //   521: aload_0
    //   522: getfield 373	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:sJv	I
    //   525: istore_2
    //   526: aload_0
    //   527: getfield 375	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:pvg	I
    //   530: istore_3
    //   531: iload_3
    //   532: iload_2
    //   533: if_icmplt +595 -> 1128
    //   536: aload_1
    //   537: iload_2
    //   538: putfield 408	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:sJv	I
    //   541: aload_1
    //   542: iload_3
    //   543: putfield 409	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:pvg	I
    //   546: aload_1
    //   547: aload_1
    //   548: getfield 413	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   551: bipush 32
    //   553: invokestatic 419	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   556: putfield 422	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:length	I
    //   559: aload_0
    //   560: getfield 164	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:RGv	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   563: astore_1
    //   564: aload_0
    //   565: getfield 162	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:oYP	I
    //   568: istore_2
    //   569: aload_0
    //   570: getfield 276	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Rfi	Ljava/lang/String;
    //   573: astore 10
    //   575: aload_0
    //   576: getfield 280	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Rfj	I
    //   579: istore_3
    //   580: aload_0
    //   581: getfield 284	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Rfk	I
    //   584: istore 4
    //   586: aload_0
    //   587: getfield 292	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:PQB	Z
    //   590: istore 7
    //   592: aload_0
    //   593: getfield 296	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:hLy	Z
    //   596: istore 8
    //   598: aload_0
    //   599: getfield 300	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:QKq	Ljava/lang/String;
    //   602: astore 11
    //   604: aload_0
    //   605: getfield 304	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Rfl	Ljava/lang/String;
    //   608: astore 12
    //   610: aload_1
    //   611: iconst_1
    //   612: putfield 425	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:isInit	Z
    //   615: aload_1
    //   616: iconst_1
    //   617: putfield 428	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:isFirst	Z
    //   620: aload_1
    //   621: iload_2
    //   622: putfield 429	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:oYP	I
    //   625: aload_1
    //   626: aload 10
    //   628: putfield 430	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Rfi	Ljava/lang/String;
    //   631: aload_1
    //   632: iload_3
    //   633: putfield 431	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Rfj	I
    //   636: aload_1
    //   637: iload 4
    //   639: putfield 432	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Rfk	I
    //   642: aload_1
    //   643: iload 7
    //   645: putfield 433	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:PQB	Z
    //   648: aload_1
    //   649: iload 8
    //   651: putfield 434	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:hLy	Z
    //   654: aload_1
    //   655: aload 11
    //   657: putfield 435	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:QKq	Ljava/lang/String;
    //   660: aload_1
    //   661: aload 12
    //   663: putfield 436	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Rfl	Ljava/lang/String;
    //   666: aload_0
    //   667: getfield 164	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:RGv	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   670: astore_1
    //   671: aload_1
    //   672: aload_1
    //   673: getfield 413	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   676: invokestatic 442	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   679: getstatic 445	com/tencent/mm/plugin/sns/b$g:sight_video_full_screen_view	I
    //   682: aload_1
    //   683: iconst_1
    //   684: invokevirtual 449	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   687: putfield 453	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   690: aload_1
    //   691: aload_1
    //   692: getfield 453	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   695: getstatic 456	com/tencent/mm/plugin/sns/b$f:videoContainer	I
    //   698: invokevirtual 459	android/view/View:findViewById	(I)Landroid/view/View;
    //   701: checkcast 400	android/widget/FrameLayout
    //   704: putfield 462	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Rfe	Landroid/widget/FrameLayout;
    //   707: aload_1
    //   708: aload_1
    //   709: getfield 453	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   712: getstatic 465	com/tencent/mm/plugin/sns/b$f:bottomToorBar	I
    //   715: invokevirtual 459	android/view/View:findViewById	(I)Landroid/view/View;
    //   718: putfield 468	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Rff	Landroid/view/View;
    //   721: aload_1
    //   722: aload_1
    //   723: getfield 453	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   726: getstatic 471	com/tencent/mm/plugin/sns/b$f:iconBar	I
    //   729: invokevirtual 459	android/view/View:findViewById	(I)Landroid/view/View;
    //   732: putfield 474	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Rfg	Landroid/view/View;
    //   735: aload_1
    //   736: aload_1
    //   737: getfield 453	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   740: getstatic 477	com/tencent/mm/plugin/sns/b$f:progress_bar	I
    //   743: invokevirtual 459	android/view/View:findViewById	(I)Landroid/view/View;
    //   746: checkcast 479	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar
    //   749: putfield 483	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   752: aload_1
    //   753: new 485	com/tencent/mm/plugin/sns/ui/OfflineVideoView
    //   756: dup
    //   757: aload_1
    //   758: getfield 413	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   761: invokespecial 486	com/tencent/mm/plugin/sns/ui/OfflineVideoView:<init>	(Landroid/content/Context;)V
    //   764: putfield 490	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:RjG	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   767: aload_1
    //   768: getfield 490	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:RjG	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   771: iconst_1
    //   772: invokevirtual 493	com/tencent/mm/plugin/sns/ui/OfflineVideoView:setClickable	(Z)V
    //   775: aload_1
    //   776: getfield 490	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:RjG	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   779: aload_1
    //   780: invokevirtual 497	com/tencent/mm/plugin/sns/ui/OfflineVideoView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   783: aload_1
    //   784: getfield 490	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:RjG	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   787: iconst_2
    //   788: invokevirtual 500	com/tencent/mm/plugin/sns/ui/OfflineVideoView:setSource	(I)V
    //   791: aload_1
    //   792: getfield 462	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Rfe	Landroid/widget/FrameLayout;
    //   795: aload_1
    //   796: getfield 490	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:RjG	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   799: invokevirtual 407	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   802: aload_1
    //   803: getfield 483	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   806: iconst_0
    //   807: invokevirtual 503	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setVisibility	(I)V
    //   810: aload_1
    //   811: getfield 483	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   814: aload_1
    //   815: getfield 507	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:QRM	Landroid/view/View$OnClickListener;
    //   818: invokevirtual 511	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setOnPlayButtonClickListener	(Landroid/view/View$OnClickListener;)V
    //   821: aload_1
    //   822: getfield 483	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   825: aload_1
    //   826: getfield 515	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Aqj	Lcom/tencent/mm/plugin/sight/decode/ui/b;
    //   829: invokevirtual 519	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setIplaySeekCallback	(Lcom/tencent/mm/plugin/sight/decode/ui/b;)V
    //   832: aload_1
    //   833: aload_1
    //   834: getstatic 522	com/tencent/mm/plugin/sns/b$f:sns_ad_native_landing_pages_sight_video_full_screen_btn	I
    //   837: invokevirtual 523	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:findViewById	(I)Landroid/view/View;
    //   840: checkcast 525	android/widget/ImageView
    //   843: putfield 529	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:QRI	Landroid/widget/ImageView;
    //   846: aload_1
    //   847: getfield 529	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:QRI	Landroid/widget/ImageView;
    //   850: iconst_0
    //   851: invokevirtual 530	android/widget/ImageView:setVisibility	(I)V
    //   854: aload_1
    //   855: getfield 529	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:QRI	Landroid/widget/ImageView;
    //   858: aload_1
    //   859: invokevirtual 533	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   862: aload_1
    //   863: aload_1
    //   864: getstatic 536	com/tencent/mm/plugin/sns/b$f:sns_ad_native_landing_pages_sight_voice_btn	I
    //   867: invokevirtual 523	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:findViewById	(I)Landroid/view/View;
    //   870: checkcast 525	android/widget/ImageView
    //   873: putfield 539	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:QRE	Landroid/widget/ImageView;
    //   876: aload_1
    //   877: getfield 539	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:QRE	Landroid/widget/ImageView;
    //   880: iconst_0
    //   881: invokevirtual 530	android/widget/ImageView:setVisibility	(I)V
    //   884: aload_1
    //   885: getfield 539	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:QRE	Landroid/widget/ImageView;
    //   888: aload_1
    //   889: invokevirtual 533	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   892: aload_1
    //   893: aload_1
    //   894: getfield 453	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   897: getstatic 542	com/tencent/mm/plugin/sns/b$f:pause_video_container	I
    //   900: invokevirtual 459	android/view/View:findViewById	(I)Landroid/view/View;
    //   903: putfield 545	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:QRJ	Landroid/view/View;
    //   906: aload_1
    //   907: getfield 545	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:QRJ	Landroid/view/View;
    //   910: bipush 8
    //   912: invokevirtual 546	android/view/View:setVisibility	(I)V
    //   915: aload_1
    //   916: getfield 413	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   919: invokevirtual 549	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   922: invokevirtual 112	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   925: getfield 117	android/content/res/Configuration:orientation	I
    //   928: iconst_2
    //   929: if_icmpne +256 -> 1185
    //   932: ldc_w 551
    //   935: ldc 238
    //   937: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   940: aload_1
    //   941: invokevirtual 552	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:hiU	()V
    //   944: aload_1
    //   945: getfield 483	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   948: invokevirtual 555	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:getVideoTotalTime	()I
    //   951: aload_1
    //   952: getfield 432	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Rfk	I
    //   955: sipush 1000
    //   958: idiv
    //   959: if_icmpeq +18 -> 977
    //   962: aload_1
    //   963: getfield 483	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   966: aload_1
    //   967: getfield 432	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Rfk	I
    //   970: sipush 1000
    //   973: idiv
    //   974: invokevirtual 558	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setVideoTotalTime	(I)V
    //   977: aload_1
    //   978: getfield 483	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   981: aload_1
    //   982: getfield 431	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:Rfj	I
    //   985: sipush 1000
    //   988: idiv
    //   989: invokevirtual 561	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:seek	(I)V
    //   992: aload_1
    //   993: aload_1
    //   994: getfield 434	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:hLy	Z
    //   997: invokevirtual 564	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:DV	(Z)V
    //   1000: aload_1
    //   1001: getfield 490	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:RjG	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   1004: new 566	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView$2
    //   1007: dup
    //   1008: aload_1
    //   1009: invokespecial 569	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView$2:<init>	(Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;)V
    //   1012: invokevirtual 573	com/tencent/mm/plugin/sns/ui/OfflineVideoView:setVideoCallback	(Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView$a;)V
    //   1015: aload_1
    //   1016: getfield 490	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:RjG	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   1019: invokevirtual 576	com/tencent/mm/plugin/sns/ui/OfflineVideoView:dSY	()V
    //   1022: aload_1
    //   1023: iconst_1
    //   1024: invokevirtual 579	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:setFocus	(Z)V
    //   1027: aload_0
    //   1028: getfield 164	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:RGv	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   1031: aload_0
    //   1032: invokevirtual 583	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:setProgressBarStatusListener	(Lcom/tencent/mm/plugin/sns/ui/listener/a;)V
    //   1035: getstatic 589	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj$b:QRY	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w;
    //   1038: ifnull +21 -> 1059
    //   1041: aload_0
    //   1042: getstatic 589	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj$b:QRY	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w;
    //   1045: getfield 594	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:QKz	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/al;
    //   1048: putfield 596	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:QJy	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/al;
    //   1051: aload_0
    //   1052: aload_0
    //   1053: getfield 596	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:QJy	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/al;
    //   1056: invokespecial 598	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:a	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/al;)V
    //   1059: ldc 243
    //   1061: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1064: return
    //   1065: astore_1
    //   1066: ldc 63
    //   1068: aload_1
    //   1069: invokevirtual 214	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1072: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1075: goto -728 -> 347
    //   1078: aload_0
    //   1079: invokestatic 381	com/tencent/mm/ui/aw:bx	(Landroid/content/Context;)Z
    //   1082: ifeq -648 -> 434
    //   1085: aload_0
    //   1086: invokevirtual 106	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getResources	()Landroid/content/res/Resources;
    //   1089: invokevirtual 112	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   1092: getfield 117	android/content/res/Configuration:orientation	I
    //   1095: iconst_2
    //   1096: if_icmpne -662 -> 434
    //   1099: aload_0
    //   1100: aload_0
    //   1101: getfield 373	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:sJv	I
    //   1104: aload_0
    //   1105: invokestatic 385	com/tencent/mm/ui/aw:bw	(Landroid/content/Context;)I
    //   1108: isub
    //   1109: putfield 373	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:sJv	I
    //   1112: goto -678 -> 434
    //   1115: astore_1
    //   1116: ldc 63
    //   1118: aload_1
    //   1119: invokevirtual 214	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1122: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1125: goto -653 -> 472
    //   1128: aload_1
    //   1129: iload_2
    //   1130: putfield 409	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:pvg	I
    //   1133: aload_1
    //   1134: iload_3
    //   1135: putfield 408	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:sJv	I
    //   1138: goto -592 -> 546
    //   1141: astore_1
    //   1142: ldc_w 551
    //   1145: aload_1
    //   1146: invokevirtual 214	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1149: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1152: goto -593 -> 559
    //   1155: astore_1
    //   1156: ldc 63
    //   1158: aload_1
    //   1159: invokevirtual 214	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1162: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1165: ldc 243
    //   1167: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1170: return
    //   1171: astore_1
    //   1172: ldc_w 551
    //   1175: aload_1
    //   1176: invokevirtual 214	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1179: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1182: goto -516 -> 666
    //   1185: aload_1
    //   1186: getfield 413	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   1189: invokevirtual 549	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1192: invokevirtual 112	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   1195: getfield 117	android/content/res/Configuration:orientation	I
    //   1198: iconst_1
    //   1199: if_icmpne -255 -> 944
    //   1202: ldc_w 551
    //   1205: ldc 240
    //   1207: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1210: aload_1
    //   1211: invokevirtual 599	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:hiV	()V
    //   1214: goto -270 -> 944
    //   1217: astore 10
    //   1219: ldc_w 551
    //   1222: aload 10
    //   1224: invokevirtual 214	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1227: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1230: goto -286 -> 944
    //   1233: astore_1
    //   1234: ldc_w 551
    //   1237: aload_1
    //   1238: invokevirtual 214	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1241: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1244: goto -217 -> 1027
    //   1247: astore 10
    //   1249: ldc_w 551
    //   1252: aload 10
    //   1254: invokevirtual 214	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1257: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1260: goto -260 -> 1000
    //   1263: astore 10
    //   1265: ldc_w 551
    //   1268: aload 10
    //   1270: invokevirtual 214	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1273: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1276: goto -261 -> 1015
    //   1279: astore_1
    //   1280: ldc 63
    //   1282: aload_1
    //   1283: invokevirtual 214	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1286: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1289: ldc 243
    //   1291: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1294: return
    //   1295: aload_0
    //   1296: getfield 162	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:oYP	I
    //   1299: iconst_1
    //   1300: if_icmpne +649 -> 1949
    //   1303: aload_0
    //   1304: aload_0
    //   1305: getstatic 394	com/tencent/mm/plugin/sns/b$f:root	I
    //   1308: invokevirtual 398	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:findViewById	(I)Landroid/view/View;
    //   1311: checkcast 400	android/widget/FrameLayout
    //   1314: putfield 84	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:RlA	Landroid/widget/FrameLayout;
    //   1317: aload_0
    //   1318: new 206	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView
    //   1321: dup
    //   1322: aload_0
    //   1323: invokespecial 600	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:<init>	(Landroid/content/Context;)V
    //   1326: putfield 204	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:RGw	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1329: aload_0
    //   1330: getfield 84	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:RlA	Landroid/widget/FrameLayout;
    //   1333: aload_0
    //   1334: getfield 204	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:RGw	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1337: invokevirtual 407	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   1340: aload_0
    //   1341: getfield 204	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:RGw	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1344: astore_1
    //   1345: aload_0
    //   1346: getfield 373	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:sJv	I
    //   1349: istore_2
    //   1350: aload_0
    //   1351: getfield 375	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:pvg	I
    //   1354: istore_3
    //   1355: iload_3
    //   1356: iload_2
    //   1357: if_icmplt +598 -> 1955
    //   1360: aload_1
    //   1361: iload_2
    //   1362: putfield 601	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:sJv	I
    //   1365: aload_1
    //   1366: iload_3
    //   1367: putfield 602	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:pvg	I
    //   1370: aload_1
    //   1371: aload_1
    //   1372: getfield 603	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mContext	Landroid/content/Context;
    //   1375: bipush 32
    //   1377: invokestatic 419	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   1380: putfield 604	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:length	I
    //   1383: aload_0
    //   1384: getfield 204	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:RGw	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1387: astore_1
    //   1388: aload_0
    //   1389: getfield 162	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:oYP	I
    //   1392: istore_2
    //   1393: aload_0
    //   1394: getfield 276	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Rfi	Ljava/lang/String;
    //   1397: astore 10
    //   1399: aload_0
    //   1400: getfield 280	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Rfj	I
    //   1403: istore_3
    //   1404: aload_0
    //   1405: getfield 284	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Rfk	I
    //   1408: istore 4
    //   1410: aload_0
    //   1411: getfield 292	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:PQB	Z
    //   1414: istore 7
    //   1416: aload_0
    //   1417: getfield 296	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:hLy	Z
    //   1420: istore 8
    //   1422: aload_0
    //   1423: getfield 300	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:QKq	Ljava/lang/String;
    //   1426: astore 11
    //   1428: aload_0
    //   1429: getfield 304	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Rfl	Ljava/lang/String;
    //   1432: astore 12
    //   1434: aload_0
    //   1435: getfield 308	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:isWaiting	Z
    //   1438: istore 9
    //   1440: aload_0
    //   1441: getfield 312	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:QSv	I
    //   1444: istore 5
    //   1446: aload_0
    //   1447: getfield 316	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:Rfm	I
    //   1450: istore 6
    //   1452: aload_1
    //   1453: iconst_1
    //   1454: putfield 607	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mGp	Z
    //   1457: aload_1
    //   1458: iconst_1
    //   1459: putfield 608	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:isFirst	Z
    //   1462: aload_1
    //   1463: iload_2
    //   1464: putfield 609	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:oYP	I
    //   1467: aload_1
    //   1468: aload 10
    //   1470: putfield 610	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Rfi	Ljava/lang/String;
    //   1473: aload_1
    //   1474: iload_3
    //   1475: putfield 611	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Rfj	I
    //   1478: aload_1
    //   1479: iload 4
    //   1481: putfield 612	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Rfk	I
    //   1484: aload_1
    //   1485: iload 7
    //   1487: putfield 613	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:PQB	Z
    //   1490: aload_1
    //   1491: iload 8
    //   1493: putfield 614	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:hLy	Z
    //   1496: aload_1
    //   1497: aload 11
    //   1499: putfield 615	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:QKq	Ljava/lang/String;
    //   1502: aload_1
    //   1503: aload 12
    //   1505: putfield 616	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Rfl	Ljava/lang/String;
    //   1508: aload_1
    //   1509: iload 9
    //   1511: putfield 617	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:isWaiting	Z
    //   1514: aload_1
    //   1515: iload 5
    //   1517: putfield 618	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:QSv	I
    //   1520: aload_1
    //   1521: iload 6
    //   1523: putfield 619	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Rfm	I
    //   1526: aload_0
    //   1527: getfield 204	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:RGw	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1530: astore_1
    //   1531: aload_1
    //   1532: aload_1
    //   1533: getfield 603	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mContext	Landroid/content/Context;
    //   1536: invokestatic 442	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   1539: getstatic 622	com/tencent/mm/plugin/sns/b$g:long_video_full_screen_view	I
    //   1542: aload_1
    //   1543: iconst_1
    //   1544: invokevirtual 449	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   1547: putfield 623	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1550: aload_1
    //   1551: aload_1
    //   1552: getfield 623	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1555: getstatic 456	com/tencent/mm/plugin/sns/b$f:videoContainer	I
    //   1558: invokevirtual 459	android/view/View:findViewById	(I)Landroid/view/View;
    //   1561: checkcast 400	android/widget/FrameLayout
    //   1564: putfield 624	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Rfe	Landroid/widget/FrameLayout;
    //   1567: aload_1
    //   1568: new 626	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper
    //   1571: dup
    //   1572: aload_1
    //   1573: getfield 603	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mContext	Landroid/content/Context;
    //   1576: invokespecial 627	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:<init>	(Landroid/content/Context;)V
    //   1579: putfield 631	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Rfh	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1582: aload_1
    //   1583: getfield 624	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Rfe	Landroid/widget/FrameLayout;
    //   1586: aload_1
    //   1587: getfield 631	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Rfh	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1590: invokevirtual 407	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   1593: aload_1
    //   1594: getfield 631	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Rfh	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1597: aload_1
    //   1598: invokevirtual 635	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setIMMVideoViewCallback	(Lcom/tencent/mm/pluginsdk/ui/i$b;)V
    //   1601: aload_1
    //   1602: getfield 631	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Rfh	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1605: iconst_1
    //   1606: invokevirtual 638	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setFullScreen	(Z)V
    //   1609: aload_1
    //   1610: getfield 631	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Rfh	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1613: iconst_0
    //   1614: aload_1
    //   1615: getfield 616	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Rfl	Ljava/lang/String;
    //   1618: iconst_0
    //   1619: invokevirtual 642	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:b	(ZLjava/lang/String;I)V
    //   1622: aload_1
    //   1623: getfield 631	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Rfh	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1626: iconst_1
    //   1627: invokevirtual 643	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setClickable	(Z)V
    //   1630: aload_1
    //   1631: getfield 631	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Rfh	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1634: aload_1
    //   1635: invokevirtual 644	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   1638: aload_1
    //   1639: getfield 631	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Rfh	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1642: iconst_1
    //   1643: invokevirtual 647	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setLoop	(Z)V
    //   1646: aload_1
    //   1647: getfield 631	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Rfh	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1650: aload_1
    //   1651: invokevirtual 651	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setLoopCompletionCallback	(Lcom/tencent/mm/pluginsdk/ui/i$d;)V
    //   1654: aload_1
    //   1655: aload_1
    //   1656: getfield 623	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1659: getstatic 465	com/tencent/mm/plugin/sns/b$f:bottomToorBar	I
    //   1662: invokevirtual 459	android/view/View:findViewById	(I)Landroid/view/View;
    //   1665: putfield 652	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Rff	Landroid/view/View;
    //   1668: aload_1
    //   1669: aload_1
    //   1670: getfield 623	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1673: getstatic 471	com/tencent/mm/plugin/sns/b$f:iconBar	I
    //   1676: invokevirtual 459	android/view/View:findViewById	(I)Landroid/view/View;
    //   1679: putfield 653	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Rfg	Landroid/view/View;
    //   1682: aload_1
    //   1683: aload_1
    //   1684: getfield 623	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1687: getstatic 477	com/tencent/mm/plugin/sns/b$f:progress_bar	I
    //   1690: invokevirtual 459	android/view/View:findViewById	(I)Landroid/view/View;
    //   1693: checkcast 479	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar
    //   1696: putfield 654	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1699: aload_1
    //   1700: getfield 654	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1703: iconst_0
    //   1704: invokevirtual 503	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setVisibility	(I)V
    //   1707: aload_1
    //   1708: getfield 654	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1711: aload_1
    //   1712: getfield 655	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:QRM	Landroid/view/View$OnClickListener;
    //   1715: invokevirtual 511	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setOnPlayButtonClickListener	(Landroid/view/View$OnClickListener;)V
    //   1718: aload_1
    //   1719: getfield 654	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1722: aload_1
    //   1723: getfield 656	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Aqj	Lcom/tencent/mm/plugin/sight/decode/ui/b;
    //   1726: invokevirtual 519	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setIplaySeekCallback	(Lcom/tencent/mm/plugin/sight/decode/ui/b;)V
    //   1729: aload_1
    //   1730: aload_1
    //   1731: getstatic 522	com/tencent/mm/plugin/sns/b$f:sns_ad_native_landing_pages_sight_video_full_screen_btn	I
    //   1734: invokevirtual 657	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:findViewById	(I)Landroid/view/View;
    //   1737: checkcast 525	android/widget/ImageView
    //   1740: putfield 658	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:QRI	Landroid/widget/ImageView;
    //   1743: aload_1
    //   1744: getfield 658	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:QRI	Landroid/widget/ImageView;
    //   1747: iconst_0
    //   1748: invokevirtual 530	android/widget/ImageView:setVisibility	(I)V
    //   1751: aload_1
    //   1752: getfield 658	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:QRI	Landroid/widget/ImageView;
    //   1755: aload_1
    //   1756: invokevirtual 533	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1759: aload_1
    //   1760: aload_1
    //   1761: getstatic 536	com/tencent/mm/plugin/sns/b$f:sns_ad_native_landing_pages_sight_voice_btn	I
    //   1764: invokevirtual 657	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:findViewById	(I)Landroid/view/View;
    //   1767: checkcast 525	android/widget/ImageView
    //   1770: putfield 659	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:QRE	Landroid/widget/ImageView;
    //   1773: aload_1
    //   1774: getfield 659	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:QRE	Landroid/widget/ImageView;
    //   1777: iconst_0
    //   1778: invokevirtual 530	android/widget/ImageView:setVisibility	(I)V
    //   1781: aload_1
    //   1782: getfield 659	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:QRE	Landroid/widget/ImageView;
    //   1785: aload_1
    //   1786: invokevirtual 533	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1789: aload_1
    //   1790: aload_1
    //   1791: getfield 623	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1794: getstatic 542	com/tencent/mm/plugin/sns/b$f:pause_video_container	I
    //   1797: invokevirtual 459	android/view/View:findViewById	(I)Landroid/view/View;
    //   1800: putfield 660	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:QRJ	Landroid/view/View;
    //   1803: aload_1
    //   1804: getfield 660	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:QRJ	Landroid/view/View;
    //   1807: bipush 8
    //   1809: invokevirtual 546	android/view/View:setVisibility	(I)V
    //   1812: aload_1
    //   1813: getfield 654	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1816: invokevirtual 664	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:getParent	()Landroid/view/ViewParent;
    //   1819: astore 10
    //   1821: aload 10
    //   1823: instanceof 666
    //   1826: ifeq +15 -> 1841
    //   1829: aload 10
    //   1831: checkcast 666	android/view/ViewGroup
    //   1834: aload_1
    //   1835: getfield 654	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1838: invokevirtual 669	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   1841: aload_1
    //   1842: getfield 631	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Rfh	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1845: aload_1
    //   1846: getfield 654	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1849: invokevirtual 673	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setVideoFooterView	(Lcom/tencent/mm/pluginsdk/ui/h;)V
    //   1852: aload_1
    //   1853: getfield 603	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mContext	Landroid/content/Context;
    //   1856: invokevirtual 549	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1859: invokevirtual 112	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   1862: getfield 117	android/content/res/Configuration:orientation	I
    //   1865: iconst_2
    //   1866: if_icmpne +160 -> 2026
    //   1869: ldc_w 675
    //   1872: ldc 238
    //   1874: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1877: aload_1
    //   1878: invokevirtual 676	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:hiU	()V
    //   1881: aload_1
    //   1882: getfield 613	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:PQB	Z
    //   1885: ifeq +189 -> 2074
    //   1888: aload_1
    //   1889: invokevirtual 679	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:haw	()V
    //   1892: aload_1
    //   1893: invokevirtual 682	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:drB	()V
    //   1896: aload_1
    //   1897: iconst_1
    //   1898: invokevirtual 683	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:setFocus	(Z)V
    //   1901: aload_0
    //   1902: getfield 204	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:RGw	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1905: aload_0
    //   1906: invokevirtual 684	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:setProgressBarStatusListener	(Lcom/tencent/mm/plugin/sns/ui/listener/a;)V
    //   1909: getstatic 690	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an$a:QSA	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap;
    //   1912: ifnull +21 -> 1933
    //   1915: aload_0
    //   1916: getstatic 690	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an$a:QSA	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap;
    //   1919: getfield 693	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap:QKz	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/al;
    //   1922: putfield 596	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:QJy	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/al;
    //   1925: aload_0
    //   1926: aload_0
    //   1927: getfield 596	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:QJy	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/al;
    //   1930: invokespecial 598	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:a	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/al;)V
    //   1933: ldc 243
    //   1935: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1938: return
    //   1939: astore_1
    //   1940: ldc 63
    //   1942: aload_1
    //   1943: invokevirtual 214	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1946: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1949: ldc 243
    //   1951: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1954: return
    //   1955: aload_1
    //   1956: iload_2
    //   1957: putfield 602	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:pvg	I
    //   1960: aload_1
    //   1961: iload_3
    //   1962: putfield 601	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:sJv	I
    //   1965: goto -595 -> 1370
    //   1968: astore_1
    //   1969: ldc_w 675
    //   1972: aload_1
    //   1973: invokevirtual 214	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1976: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1979: goto -596 -> 1383
    //   1982: astore_1
    //   1983: ldc_w 675
    //   1986: aload_1
    //   1987: invokevirtual 214	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1990: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1993: goto -467 -> 1526
    //   1996: astore 10
    //   1998: ldc_w 675
    //   2001: aload 10
    //   2003: invokevirtual 214	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2006: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2009: goto -355 -> 1654
    //   2012: astore_1
    //   2013: ldc_w 675
    //   2016: aload_1
    //   2017: invokevirtual 214	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2020: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2023: goto -122 -> 1901
    //   2026: aload_1
    //   2027: getfield 603	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mContext	Landroid/content/Context;
    //   2030: invokevirtual 549	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   2033: invokevirtual 112	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   2036: getfield 117	android/content/res/Configuration:orientation	I
    //   2039: iconst_1
    //   2040: if_icmpne -159 -> 1881
    //   2043: ldc_w 675
    //   2046: ldc 240
    //   2048: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2051: aload_1
    //   2052: invokevirtual 694	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:hiV	()V
    //   2055: goto -174 -> 1881
    //   2058: astore 10
    //   2060: ldc_w 675
    //   2063: aload 10
    //   2065: invokevirtual 214	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2068: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2071: goto -190 -> 1881
    //   2074: aload_1
    //   2075: invokevirtual 697	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:hax	()V
    //   2078: goto -186 -> 1892
    //   2081: astore 10
    //   2083: ldc_w 675
    //   2086: aload 10
    //   2088: invokevirtual 214	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2091: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2094: goto -198 -> 1896
    //   2097: astore_1
    //   2098: ldc 63
    //   2100: aload_1
    //   2101: invokevirtual 214	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2104: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2107: ldc 243
    //   2109: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2112: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2113	0	this	VideoFullScreenActivity
    //   0	2113	1	paramBundle	android.os.Bundle
    //   525	1432	2	i	int
    //   530	1432	3	j	int
    //   584	896	4	k	int
    //   1444	72	5	m	int
    //   1450	72	6	n	int
    //   590	896	7	bool1	boolean
    //   596	896	8	bool2	boolean
    //   1438	72	9	bool3	boolean
    //   573	54	10	str1	String
    //   1217	6	10	localObject1	Object
    //   1247	6	10	localObject2	Object
    //   1263	6	10	localObject3	Object
    //   1397	433	10	localObject4	Object
    //   1996	6	10	localObject5	Object
    //   2058	6	10	localObject6	Object
    //   2081	6	10	localObject7	Object
    //   602	896	11	str2	String
    //   608	896	12	str3	String
    // Exception table:
    //   from	to	target	type
    //   28	347	1065	finally
    //   381	434	1115	finally
    //   434	472	1115	finally
    //   1078	1112	1115	finally
    //   536	546	1141	finally
    //   546	559	1141	finally
    //   1128	1138	1141	finally
    //   479	531	1155	finally
    //   559	610	1155	finally
    //   666	671	1155	finally
    //   1027	1035	1155	finally
    //   1059	1064	1155	finally
    //   1142	1152	1155	finally
    //   1172	1182	1155	finally
    //   1234	1244	1155	finally
    //   1280	1289	1155	finally
    //   610	666	1171	finally
    //   671	944	1217	finally
    //   1185	1214	1217	finally
    //   1015	1027	1233	finally
    //   1219	1230	1233	finally
    //   1249	1260	1233	finally
    //   1265	1276	1233	finally
    //   944	977	1247	finally
    //   977	1000	1247	finally
    //   1000	1015	1263	finally
    //   1035	1059	1279	finally
    //   1303	1355	1939	finally
    //   1383	1452	1939	finally
    //   1526	1531	1939	finally
    //   1901	1909	1939	finally
    //   1933	1938	1939	finally
    //   1969	1979	1939	finally
    //   1983	1993	1939	finally
    //   2013	2023	1939	finally
    //   2098	2107	1939	finally
    //   1360	1370	1968	finally
    //   1370	1383	1968	finally
    //   1955	1965	1968	finally
    //   1452	1526	1982	finally
    //   1531	1654	1996	finally
    //   1896	1901	2012	finally
    //   1998	2009	2012	finally
    //   2060	2071	2012	finally
    //   2083	2094	2012	finally
    //   1654	1841	2058	finally
    //   1841	1881	2058	finally
    //   2026	2055	2058	finally
    //   1881	1892	2081	finally
    //   1892	1896	2081	finally
    //   2074	2078	2081	finally
    //   1909	1933	2097	finally
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: ldc_w 699
    //   3: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: putstatic 134	com/tencent/mm/plugin/sns/model/ag:Qud	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai;
    //   10: aload_0
    //   11: getfield 162	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:oYP	I
    //   14: ifne +142 -> 156
    //   17: aload_0
    //   18: getfield 164	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:RGv	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   21: astore_1
    //   22: aload_1
    //   23: getfield 413	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   26: ifnonnull +48 -> 74
    //   29: ldc_w 551
    //   32: ldc_w 701
    //   35: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload_1
    //   39: getfield 705	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:PQR	Ljava/lang/Runnable;
    //   42: invokestatic 709	com/tencent/mm/sdk/platformtools/MMHandlerThread:removeRunnable	(Ljava/lang/Runnable;)V
    //   45: aload_1
    //   46: getfield 712	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:QRL	Ljava/lang/Runnable;
    //   49: invokestatic 709	com/tencent/mm/sdk/platformtools/MMHandlerThread:removeRunnable	(Ljava/lang/Runnable;)V
    //   52: aload_1
    //   53: getfield 490	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:RjG	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   56: invokevirtual 714	com/tencent/mm/plugin/sns/ui/OfflineVideoView:onDestroy	()V
    //   59: aconst_null
    //   60: putstatic 589	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj$b:QRY	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w;
    //   63: aload_0
    //   64: invokespecial 715	com/tencent/mm/ui/MMActivity:onDestroy	()V
    //   67: ldc_w 699
    //   70: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: return
    //   74: aload_1
    //   75: getfield 719	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:RjH	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView$a;
    //   78: ifnull -40 -> 38
    //   81: aload_1
    //   82: getfield 413	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   85: ldc_w 721
    //   88: invokevirtual 725	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   91: checkcast 727	android/media/AudioManager
    //   94: astore_2
    //   95: aload_2
    //   96: ifnull -58 -> 38
    //   99: aload_2
    //   100: aload_1
    //   101: getfield 719	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:RjH	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView$a;
    //   104: invokevirtual 731	android/media/AudioManager:abandonAudioFocus	(Landroid/media/AudioManager$OnAudioFocusChangeListener;)I
    //   107: pop
    //   108: aload_1
    //   109: aconst_null
    //   110: putfield 719	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:RjH	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView$a;
    //   113: goto -75 -> 38
    //   116: astore_2
    //   117: ldc_w 551
    //   120: ldc_w 733
    //   123: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: goto -88 -> 38
    //   129: astore_1
    //   130: ldc_w 551
    //   133: aload_1
    //   134: invokevirtual 214	java/lang/Throwable:toString	()Ljava/lang/String;
    //   137: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: goto -81 -> 59
    //   143: astore_1
    //   144: ldc 63
    //   146: aload_1
    //   147: invokevirtual 214	java/lang/Throwable:toString	()Ljava/lang/String;
    //   150: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: goto -90 -> 63
    //   156: aload_0
    //   157: getfield 162	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:oYP	I
    //   160: iconst_1
    //   161: if_icmpne -98 -> 63
    //   164: aload_0
    //   165: getfield 204	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:RGw	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   168: astore_1
    //   169: aload_1
    //   170: getfield 631	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Rfh	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   173: getfield 737	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:QTh	Lcom/tencent/mm/sdk/platformtools/MTimerHandler;
    //   176: invokevirtual 742	com/tencent/mm/sdk/platformtools/MTimerHandler:stopTimer	()V
    //   179: aload_1
    //   180: getfield 743	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:PQR	Ljava/lang/Runnable;
    //   183: invokestatic 709	com/tencent/mm/sdk/platformtools/MMHandlerThread:removeRunnable	(Ljava/lang/Runnable;)V
    //   186: aload_1
    //   187: getfield 744	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:QRL	Ljava/lang/Runnable;
    //   190: invokestatic 709	com/tencent/mm/sdk/platformtools/MMHandlerThread:removeRunnable	(Ljava/lang/Runnable;)V
    //   193: aload_1
    //   194: invokevirtual 747	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:haH	()V
    //   197: getstatic 752	com/tencent/mm/plugin/sns/data/l:QnG	Ljava/lang/String;
    //   200: aload_1
    //   201: getfield 755	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:PSX	I
    //   204: invokestatic 758	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   207: iconst_2
    //   208: iconst_0
    //   209: ldc_w 760
    //   212: invokestatic 763	com/tencent/mm/plugin/sns/data/l:a	(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V
    //   215: aload_1
    //   216: getfield 631	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:Rfh	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   219: invokevirtual 766	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:onUIDestroy	()V
    //   222: aconst_null
    //   223: putstatic 690	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an$a:QSA	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap;
    //   226: goto -163 -> 63
    //   229: astore_1
    //   230: ldc_w 675
    //   233: aload_1
    //   234: invokevirtual 214	java/lang/Throwable:toString	()Ljava/lang/String;
    //   237: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: goto -18 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	VideoFullScreenActivity
    //   21	88	1	localSightVideoFullScreenView	SightVideoFullScreenView
    //   129	5	1	localObject1	Object
    //   143	4	1	localObject2	Object
    //   168	48	1	localLongVideoFullScreenView	LongVideoFullScreenView
    //   229	5	1	localObject3	Object
    //   94	6	2	localAudioManager	android.media.AudioManager
    //   116	1	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   22	38	116	finally
    //   74	95	116	finally
    //   99	113	116	finally
    //   38	59	129	finally
    //   117	126	129	finally
    //   6	22	143	finally
    //   59	63	143	finally
    //   130	140	143	finally
    //   156	169	143	finally
    //   222	226	143	finally
    //   230	240	143	finally
    //   169	222	229	finally
  }
  
  public void onPause()
  {
    AppMethodBeat.i(307773);
    super.onPause();
    try
    {
      this.hTS += System.currentTimeMillis() - this.startTime;
      if (this.oYP == 0)
      {
        SightVideoFullScreenView localSightVideoFullScreenView = this.RGv;
        try
        {
          localSightVideoFullScreenView.QIM = false;
          MMHandlerThread.removeRunnable(localSightVideoFullScreenView.PQR);
          MMHandlerThread.removeRunnable(localSightVideoFullScreenView.QRL);
          AppMethodBeat.o(307773);
          return;
        }
        finally {}
      }
      if (this.oYP != 1) {
        break label150;
      }
    }
    finally
    {
      Log.e("VideoFullScreenActivity", localObject2.toString());
      AppMethodBeat.o(307773);
      return;
    }
    LongVideoFullScreenView localLongVideoFullScreenView = this.RGw;
    try
    {
      localLongVideoFullScreenView.QIM = false;
      MMHandlerThread.removeRunnable(localLongVideoFullScreenView.PQR);
      MMHandlerThread.removeRunnable(localLongVideoFullScreenView.QRL);
      AppMethodBeat.o(307773);
      return;
    }
    finally
    {
      Log.e("LongVideoFullScreenView", localObject3.toString());
    }
    label150:
    AppMethodBeat.o(307773);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(307769);
    super.onResume();
    try
    {
      this.startTime = System.currentTimeMillis();
      ar.bt(this);
      if (this.oYP == 0)
      {
        this.RGv.QIM = true;
        AppMethodBeat.o(307769);
        return;
      }
      if (this.oYP == 1) {
        this.RGw.QIM = true;
      }
      AppMethodBeat.o(307769);
      return;
    }
    finally
    {
      Log.e("VideoFullScreenActivity", localObject.toString());
      AppMethodBeat.o(307769);
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(307764);
    super.onStart();
    try
    {
      ar.bt(this);
      if (this.oYP == 0)
      {
        SightVideoFullScreenView localSightVideoFullScreenView = this.RGv;
        try
        {
          if (!localSightVideoFullScreenView.isFirst) {
            if ((!localSightVideoFullScreenView.RjG.isPlaying()) && (localSightVideoFullScreenView.Rfp))
            {
              localSightVideoFullScreenView.hni();
              localSightVideoFullScreenView.Rfp = false;
            }
          }
          for (;;)
          {
            localSightVideoFullScreenView.isFirst = false;
            AppMethodBeat.o(307764);
            return;
            localSightVideoFullScreenView.bUf();
          }
          localObject2 = finally;
        }
        finally {}
      }
      if (this.oYP != 1) {
        break label182;
      }
    }
    finally
    {
      Log.e("VideoFullScreenActivity", localObject2.toString());
      AppMethodBeat.o(307764);
      return;
    }
    LongVideoFullScreenView localLongVideoFullScreenView = this.RGw;
    try
    {
      if ((!localLongVideoFullScreenView.isFirst) && (!localLongVideoFullScreenView.Rfh.isPlaying()) && (localLongVideoFullScreenView.Rfp))
      {
        localLongVideoFullScreenView.drB();
        localLongVideoFullScreenView.Rfp = false;
      }
      localLongVideoFullScreenView.isFirst = false;
      AppMethodBeat.o(307764);
      return;
    }
    finally
    {
      Log.e("LongVideoFullScreenView", localObject3.toString());
    }
    label182:
    AppMethodBeat.o(307764);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(307778);
    super.onStop();
    try
    {
      if (this.oYP == 0)
      {
        SightVideoFullScreenView localSightVideoFullScreenView = this.RGv;
        try
        {
          localSightVideoFullScreenView.isFirst = false;
          if (localSightVideoFullScreenView.RjG.isPlaying())
          {
            localSightVideoFullScreenView.hnj();
            localSightVideoFullScreenView.Rfp = true;
          }
          AppMethodBeat.o(307778);
          return;
        }
        finally {}
      }
      if (this.oYP != 1) {
        break label143;
      }
    }
    finally
    {
      Log.e("VideoFullScreenActivity", localObject2.toString());
      AppMethodBeat.o(307778);
      return;
    }
    LongVideoFullScreenView localLongVideoFullScreenView = this.RGw;
    try
    {
      localLongVideoFullScreenView.isFirst = false;
      if (localLongVideoFullScreenView.Rfh.isPlaying())
      {
        localLongVideoFullScreenView.bck();
        localLongVideoFullScreenView.Rfp = true;
      }
      AppMethodBeat.o(307778);
      return;
    }
    finally
    {
      Log.e("LongVideoFullScreenView", localObject3.toString());
    }
    label143:
    AppMethodBeat.o(307778);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setMMOrientation() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.VideoFullScreenActivity
 * JD-Core Version:    0.7.0.1
 */