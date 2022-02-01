package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.gy;
import com.tencent.mm.autogen.mmdata.rpt.ld;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.ExportFileUtil.a;
import com.tencent.mm.plugin.am.a.a;
import com.tencent.mm.plugin.am.a.b;
import com.tencent.mm.plugin.am.a.c;
import com.tencent.mm.plugin.am.a.d;
import com.tencent.mm.plugin.am.a.e;
import com.tencent.mm.plugin.am.a.f;
import com.tencent.mm.plugin.am.a.g;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.scanner.PluginScanTranslation;
import com.tencent.mm.plugin.scanner.g;
import com.tencent.mm.plugin.scanner.model.ap;
import com.tencent.mm.plugin.scanner.model.aq;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.scanner.util.m.a;
import com.tencent.mm.plugin.scanner.util.m.b;
import com.tencent.mm.plugin.scanner.util.n.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;

@com.tencent.mm.ui.base.a(3)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/scanner/util/ScanTranslationRender$TranslationRenderCallback;", "()V", "bottomBgLayer", "Landroid/view/View;", "closeButton", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "curMediaId", "", "curSessionId", "", "curState", "gestureGallery", "Lcom/tencent/mm/ui/tools/MMGestureGallery;", "originalBitmap", "Landroid/graphics/Bitmap;", "originalPath", "reportData", "Lcom/tencent/mm/autogen/mmdata/rpt/OCRTranslateReportStruct;", "rootContainer", "rotateDegree", "saveContainer", "saveImgBtn", "scanLine", "Landroid/widget/ImageView;", "scanLineAnimator", "Landroid/animation/ValueAnimator;", "screenHeight", "source", "startTimeArray", "", "targetLang", "topBgLayer", "translateBitmap", "translateImageAdapter", "Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$TranslateImageAdapter;", "translationPath", "viewSourceBtn", "configNavigationBar", "", "doTranslation", "drawTranslationResult", "session", "newBitmap", "enterFullScreen", "enterPreviewStatus", "enterTranslateFinishStatus", "enterTranslateStatus", "finishActivity", "getLayoutId", "goBack", "init", "initData", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "onTranslateFailed", "resetTargetLang", "setPreviewBitmap", "bitmap", "startScanLineAnimation", "stopScanLineAnimation", "Companion", "TranslateImageAdapter", "scan-translation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ScanTranslationResultUI
  extends MMActivity
  implements com.tencent.mm.am.h, n.b
{
  public static final ScanTranslationResultUI.a Pbx;
  private ImageView AjC;
  private ValueAnimator AjF;
  private String IBe;
  private View PaX;
  private ImageView PaY;
  private View PaZ;
  private View Pba;
  private View Pbb;
  private Bitmap Pbd;
  private Bitmap Pbe;
  private String Pbf;
  private MMGestureGallery Pbh;
  private int Pbj;
  private String Pbk;
  private final ld Pbn;
  private final long[] Pbo;
  private b Pby;
  private int nDr;
  private int owq;
  private View pKd;
  private String pax;
  private WeImageView puG;
  private int pvg;
  private int source;
  
  static
  {
    AppMethodBeat.i(121001);
    Pbx = new ScanTranslationResultUI.a((byte)0);
    AppMethodBeat.o(121001);
  }
  
  public ScanTranslationResultUI()
  {
    AppMethodBeat.i(121000);
    this.AjF = new ValueAnimator();
    this.owq = -1;
    this.Pbn = new ld();
    this.Pbo = new long[2];
    AppMethodBeat.o(121000);
  }
  
  private static final void a(ScanTranslationResultUI paramScanTranslationResultUI)
  {
    AppMethodBeat.i(314616);
    kotlin.g.b.s.u(paramScanTranslationResultUI, "this$0");
    paramScanTranslationResultUI.gSJ();
    paramScanTranslationResultUI.ax(paramScanTranslationResultUI.Pbe);
    AppMethodBeat.o(314616);
  }
  
  private static final void a(ScanTranslationResultUI paramScanTranslationResultUI, ValueAnimator paramValueAnimator)
  {
    Object localObject = null;
    AppMethodBeat.i(314614);
    kotlin.g.b.s.u(paramScanTranslationResultUI, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramScanTranslationResultUI = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(314614);
      throw paramScanTranslationResultUI;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    ImageView localImageView;
    int i;
    if (f <= 0.1F)
    {
      localImageView = paramScanTranslationResultUI.AjC;
      paramValueAnimator = localImageView;
      if (localImageView == null)
      {
        kotlin.g.b.s.bIx("scanLine");
        paramValueAnimator = null;
      }
      paramValueAnimator.setAlpha(f * 10.0F);
      localImageView = paramScanTranslationResultUI.AjC;
      paramValueAnimator = localImageView;
      if (localImageView == null)
      {
        kotlin.g.b.s.bIx("scanLine");
        paramValueAnimator = null;
      }
      i = paramScanTranslationResultUI.pvg;
      paramScanTranslationResultUI = paramScanTranslationResultUI.AjC;
      if (paramScanTranslationResultUI != null) {
        break label194;
      }
      kotlin.g.b.s.bIx("scanLine");
      paramScanTranslationResultUI = localObject;
    }
    label194:
    for (;;)
    {
      paramValueAnimator.setTranslationY((i - paramScanTranslationResultUI.getHeight()) * f);
      AppMethodBeat.o(314614);
      return;
      if (f < 0.9F) {
        break;
      }
      localImageView = paramScanTranslationResultUI.AjC;
      paramValueAnimator = localImageView;
      if (localImageView == null)
      {
        kotlin.g.b.s.bIx("scanLine");
        paramValueAnimator = null;
      }
      paramValueAnimator.setAlpha((1.0F - f) * 10.0F);
      break;
    }
  }
  
  private static final void a(ScanTranslationResultUI paramScanTranslationResultUI, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(314618);
    kotlin.g.b.s.u(paramScanTranslationResultUI, "this$0");
    paramScanTranslationResultUI.gSL();
    AppMethodBeat.o(314618);
  }
  
  private static final void a(ScanTranslationResultUI paramScanTranslationResultUI, View paramView)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    ImageView localImageView = null;
    int i = 1;
    AppMethodBeat.i(314604);
    Object localObject3 = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramScanTranslationResultUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject3, localb.aYj());
    kotlin.g.b.s.u(paramScanTranslationResultUI, "this$0");
    if (paramScanTranslationResultUI.owq == 3)
    {
      if (paramScanTranslationResultUI.Pbd != null) {
        paramScanTranslationResultUI.ax(paramScanTranslationResultUI.Pbd);
      }
      paramView = paramScanTranslationResultUI.Pbk;
      if ((paramView != null) && (kotlin.n.n.T(paramView, "zh_CN", false) == true))
      {
        if (i == 0) {
          break label203;
        }
        localImageView = paramScanTranslationResultUI.PaY;
        paramView = localImageView;
        if (localImageView == null)
        {
          kotlin.g.b.s.bIx("viewSourceBtn");
          paramView = null;
        }
        paramView.setImageResource(a.f.translation_result_chinese_highlighted);
        paramScanTranslationResultUI.owq = 2;
        paramScanTranslationResultUI.Pbn.iYP += 1L;
      }
    }
    label203:
    while (paramScanTranslationResultUI.owq != 2)
    {
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(314604);
        return;
        i = 0;
      }
      paramView = paramScanTranslationResultUI.PaY;
      if (paramView == null)
      {
        kotlin.g.b.s.bIx("viewSourceBtn");
        paramView = localImageView;
      }
      for (;;)
      {
        paramView.setImageResource(a.f.translation_result_english_highlighted);
        break;
      }
    }
    if (paramScanTranslationResultUI.Pbe != null) {
      paramScanTranslationResultUI.ax(paramScanTranslationResultUI.Pbe);
    }
    paramView = paramScanTranslationResultUI.Pbk;
    if ((paramView != null) && (kotlin.n.n.T(paramView, "zh_CN", true) == true))
    {
      i = 1;
      label279:
      if (i == 0) {
        break label324;
      }
      paramView = paramScanTranslationResultUI.PaY;
      if (paramView != null) {
        break label321;
      }
      kotlin.g.b.s.bIx("viewSourceBtn");
      paramView = localObject1;
    }
    label321:
    for (;;)
    {
      paramView.setImageResource(a.c.translate_chinese_view_source_btn);
      paramScanTranslationResultUI.owq = 3;
      break;
      i = 0;
      break label279;
    }
    label324:
    paramView = paramScanTranslationResultUI.PaY;
    if (paramView == null)
    {
      kotlin.g.b.s.bIx("viewSourceBtn");
      paramView = localObject2;
    }
    for (;;)
    {
      paramView.setImageResource(a.c.translate_english_view_source_btn);
      break;
    }
  }
  
  private final void aVd(String paramString)
  {
    AppMethodBeat.i(314600);
    dSg();
    this.Pbn.iOQ = 5L;
    this.Pbn.iPP = ((int)(System.currentTimeMillis() - this.Pbo[1]));
    String str = getResources().getString(a.g.scan_translating_no_result);
    kotlin.g.b.s.s(str, "resources.getString(R.st…an_translating_no_result)");
    if (!Util.isNullOrNil(paramString)) {}
    for (paramString = String.valueOf(paramString);; paramString = str)
    {
      k.a((Context)getContext(), paramString, "", false, new ScanTranslationResultUI..ExternalSyntheticLambda1(this));
      AppMethodBeat.o(314600);
      return;
    }
  }
  
  private final void ax(Bitmap paramBitmap)
  {
    AppMethodBeat.i(120997);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(120997);
      return;
    }
    Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo setImageBitmap size: %s, %s", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
    b localb = this.Pby;
    if (localb != null) {
      localb.setImageBitmap(paramBitmap);
    }
    paramBitmap = this.Pby;
    if (paramBitmap != null) {
      paramBitmap.notifyDataSetChanged();
    }
    AppMethodBeat.o(120997);
  }
  
  private static final void b(ScanTranslationResultUI paramScanTranslationResultUI, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(314621);
    kotlin.g.b.s.u(paramScanTranslationResultUI, "this$0");
    paramScanTranslationResultUI.gSL();
    AppMethodBeat.o(314621);
  }
  
  /* Error */
  private static final void b(ScanTranslationResultUI paramScanTranslationResultUI, View paramView)
  {
    // Byte code:
    //   0: ldc_w 456
    //   3: invokestatic 156	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 283	java/lang/Object
    //   9: dup
    //   10: invokespecial 284	java/lang/Object:<init>	()V
    //   13: astore_3
    //   14: new 286	com/tencent/mm/hellhoundlib/b/b
    //   17: dup
    //   18: invokespecial 287	com/tencent/mm/hellhoundlib/b/b:<init>	()V
    //   21: astore 4
    //   23: aload 4
    //   25: aload_0
    //   26: invokevirtual 291	com/tencent/mm/hellhoundlib/b/b:cH	(Ljava/lang/Object;)V
    //   29: aload 4
    //   31: aload_1
    //   32: invokevirtual 291	com/tencent/mm/hellhoundlib/b/b:cH	(Ljava/lang/Object;)V
    //   35: ldc_w 292
    //   38: ldc_w 294
    //   41: ldc_w 296
    //   44: ldc_w 298
    //   47: aload_3
    //   48: aload 4
    //   50: invokevirtual 302	com/tencent/mm/hellhoundlib/b/b:aYj	()[Ljava/lang/Object;
    //   53: invokestatic 307	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V
    //   56: aload_0
    //   57: ldc 219
    //   59: invokestatic 225	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   62: aload_0
    //   63: getfield 209	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:owq	I
    //   66: iconst_2
    //   67: if_icmpne +92 -> 159
    //   70: aload_0
    //   71: getfield 214	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:Pbn	Lcom/tencent/mm/autogen/mmdata/rpt/ld;
    //   74: lconst_1
    //   75: putfield 459	com/tencent/mm/autogen/mmdata/rpt/ld:iYR	J
    //   78: aload_0
    //   79: getfield 461	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:pax	Ljava/lang/String;
    //   82: astore_1
    //   83: aload_1
    //   84: ifnull +25 -> 109
    //   87: aload_0
    //   88: invokevirtual 403	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   91: checkcast 405	android/content/Context
    //   94: aload_1
    //   95: new 17	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$d
    //   98: dup
    //   99: aload_0
    //   100: invokespecial 462	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$d:<init>	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)V
    //   103: checkcast 464	com/tencent/mm/platformtools/ExportFileUtil$a
    //   106: invokestatic 469	com/tencent/mm/platformtools/ExportFileUtil:a	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/platformtools/ExportFileUtil$a;)V
    //   109: new 283	java/lang/Object
    //   112: dup
    //   113: invokespecial 284	java/lang/Object:<init>	()V
    //   116: ldc_w 292
    //   119: ldc_w 294
    //   122: ldc_w 296
    //   125: ldc_w 298
    //   128: invokestatic 337	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   131: ldc_w 456
    //   134: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: return
    //   138: astore_0
    //   139: ldc_w 424
    //   142: aload_0
    //   143: checkcast 471	java/lang/Throwable
    //   146: ldc_w 473
    //   149: iconst_0
    //   150: anewarray 283	java/lang/Object
    //   153: invokestatic 477	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   156: goto -47 -> 109
    //   159: aload_0
    //   160: getfield 209	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:owq	I
    //   163: iconst_3
    //   164: if_icmpne -55 -> 109
    //   167: aload_0
    //   168: getfield 214	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:Pbn	Lcom/tencent/mm/autogen/mmdata/rpt/ld;
    //   171: lconst_1
    //   172: putfield 480	com/tencent/mm/autogen/mmdata/rpt/ld:iYQ	J
    //   175: aload_0
    //   176: getfield 482	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:source	I
    //   179: istore_2
    //   180: iload_2
    //   181: ifne +40 -> 221
    //   184: aload_0
    //   185: ldc_w 484
    //   188: invokestatic 490	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   191: checkcast 484	com/tencent/mm/plugin/scanner/PluginScanTranslation
    //   194: ldc_w 492
    //   197: invokevirtual 496	com/tencent/mm/plugin/scanner/PluginScanTranslation:genTranslationResultImgPath	(Ljava/lang/String;)Ljava/lang/String;
    //   200: putfield 498	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:Pbf	Ljava/lang/String;
    //   203: aload_0
    //   204: getfield 230	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:Pbe	Landroid/graphics/Bitmap;
    //   207: bipush 80
    //   209: getstatic 504	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   212: aload_0
    //   213: getfield 498	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:Pbf	Ljava/lang/String;
    //   216: iconst_0
    //   217: invokestatic 510	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   220: pop
    //   221: aload_0
    //   222: getfield 498	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:Pbf	Ljava/lang/String;
    //   225: astore_1
    //   226: aload_1
    //   227: ifnull -118 -> 109
    //   230: aload_0
    //   231: invokevirtual 403	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   234: checkcast 405	android/content/Context
    //   237: aload_1
    //   238: new 19	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$e
    //   241: dup
    //   242: aload_0
    //   243: invokespecial 511	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$e:<init>	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)V
    //   246: checkcast 464	com/tencent/mm/platformtools/ExportFileUtil$a
    //   249: invokestatic 469	com/tencent/mm/platformtools/ExportFileUtil:a	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/platformtools/ExportFileUtil$a;)V
    //   252: goto -143 -> 109
    //   255: astore_0
    //   256: ldc_w 424
    //   259: aload_0
    //   260: checkcast 471	java/lang/Throwable
    //   263: ldc_w 513
    //   266: iconst_0
    //   267: anewarray 283	java/lang/Object
    //   270: invokestatic 477	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   273: goto -164 -> 109
    //   276: astore_1
    //   277: ldc_w 424
    //   280: aload_1
    //   281: checkcast 471	java/lang/Throwable
    //   284: ldc_w 515
    //   287: iconst_0
    //   288: anewarray 283	java/lang/Object
    //   291: invokestatic 477	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   294: goto -73 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	paramScanTranslationResultUI	ScanTranslationResultUI
    //   0	297	1	paramView	View
    //   179	2	2	i	int
    //   13	35	3	localObject	Object
    //   21	28	4	localb	com.tencent.mm.hellhoundlib.b.b
    // Exception table:
    //   from	to	target	type
    //   70	83	138	java/lang/Exception
    //   87	109	138	java/lang/Exception
    //   167	180	255	java/lang/Exception
    //   184	221	255	java/lang/Exception
    //   221	226	255	java/lang/Exception
    //   230	252	255	java/lang/Exception
    //   277	294	255	java/lang/Exception
    //   184	221	276	java/io/IOException
  }
  
  private static final void c(ScanTranslationResultUI paramScanTranslationResultUI, View paramView)
  {
    AppMethodBeat.i(314611);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramScanTranslationResultUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramScanTranslationResultUI, "this$0");
    paramScanTranslationResultUI.gSL();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(314611);
  }
  
  private final void dSd()
  {
    Object localObject2 = null;
    AppMethodBeat.i(120992);
    this.Pbn.iOQ = 2L;
    this.Pbj = ((int)(z.bAM().hashCode() + System.currentTimeMillis() & 0xFFFFFFFF));
    this.owq = 1;
    gSE();
    Object localObject3;
    Object localObject1;
    if (kotlin.n.n.T(this.Pbk, "zh_CN", true))
    {
      localObject3 = this.PaY;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("viewSourceBtn");
        localObject1 = null;
      }
      ((ImageView)localObject1).setImageResource(a.f.translation_result_chinese);
      localObject3 = this.Pba;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("topBgLayer");
        localObject1 = null;
      }
      ((View)localObject1).setVisibility(0);
      localObject3 = this.Pbb;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("bottomBgLayer");
        localObject1 = null;
      }
      ((View)localObject1).setVisibility(0);
      localObject3 = this.PaX;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("saveContainer");
        localObject1 = null;
      }
      ((View)localObject1).setVisibility(8);
      localObject3 = this.AjC;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("scanLine");
        localObject1 = null;
      }
      ((ImageView)localObject1).setVisibility(0);
      localObject1 = this.Pbh;
      if (localObject1 != null) {
        break label250;
      }
      kotlin.g.b.s.bIx("gestureGallery");
      localObject1 = localObject2;
    }
    label250:
    for (;;)
    {
      ((MMGestureGallery)localObject1).setVisibility(0);
      dSf();
      gSK();
      AppMethodBeat.o(120992);
      return;
      localObject3 = this.PaY;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("viewSourceBtn");
        localObject1 = null;
      }
      ((ImageView)localObject1).setImageResource(a.f.translation_result_english);
      break;
    }
  }
  
  private final void dSf()
  {
    AppMethodBeat.i(120994);
    this.AjF.setRepeatMode(1);
    this.AjF.setRepeatCount(-1);
    this.AjF.start();
    AppMethodBeat.o(120994);
  }
  
  private final void dSg()
  {
    AppMethodBeat.i(120995);
    this.AjF.setRepeatMode(1);
    this.AjF.setRepeatCount(0);
    this.AjF.end();
    AppMethodBeat.o(120995);
  }
  
  private final void gSE()
  {
    AppMethodBeat.i(120984);
    kotlin.n.n.T(LocaleUtil.getApplicationLanguage(), "zh_CN", true);
    this.Pbk = LocaleUtil.getCurrentLanguage((Context)getContext());
    Log.i("MicroMsg.ScanTranslationResultUI", "targetLang %s", new Object[] { this.Pbk });
    AppMethodBeat.o(120984);
  }
  
  private final void gSJ()
  {
    Object localObject2 = null;
    AppMethodBeat.i(120993);
    Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo enterTranslateFinishStatus");
    this.owq = 3;
    Object localObject3 = this.PaX;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("saveContainer");
      localObject1 = null;
    }
    ((View)localObject1).setVisibility(0);
    if (kotlin.n.n.T(this.Pbk, "zh_CN", true))
    {
      localObject3 = this.PaY;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("viewSourceBtn");
        localObject1 = null;
      }
      ((ImageView)localObject1).setImageResource(a.c.translate_chinese_view_source_btn);
      localObject1 = this.AjC;
      if (localObject1 != null) {
        break label281;
      }
      kotlin.g.b.s.bIx("scanLine");
      localObject1 = localObject2;
    }
    label281:
    for (;;)
    {
      ((ImageView)localObject1).setVisibility(8);
      dSg();
      if ((this.source != 1) || (!Util.isNullOrNil(this.Pbf))) {
        break label302;
      }
      this.Pbf = ((PluginScanTranslation)com.tencent.mm.kernel.h.az(PluginScanTranslation.class)).genTranslationResultImgPath("jpg");
      try
      {
        BitmapUtil.saveBitmapToImage(this.Pbe, 80, Bitmap.CompressFormat.JPEG, this.Pbf, false);
        localObject1 = new aq();
        ((aq)localObject1).field_originMD5 = MD5Util.getMD5String(kotlin.g.b.s.X(this.pax, Long.valueOf(com.tencent.mm.vfs.y.bEm(this.pax))));
        ((aq)localObject1).field_resultFile = this.Pbf;
        Log.i("MicroMsg.ScanTranslationResultUI", "insert translate result %s", new Object[] { this.Pbf });
        ((PluginScanTranslation)com.tencent.mm.kernel.h.az(PluginScanTranslation.class)).getTranslationResultStorage().a((aq)localObject1);
        AppMethodBeat.o(120993);
        return;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.ScanTranslationResultUI", (Throwable)localIOException, "save translate result file error", new Object[0]);
      }
      localObject3 = this.PaY;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("viewSourceBtn");
        localObject1 = null;
      }
      ((ImageView)localObject1).setImageResource(a.c.translate_english_view_source_btn);
      break;
    }
    label302:
    AppMethodBeat.o(120993);
  }
  
  private final void gSK()
  {
    AppMethodBeat.i(120987);
    for (;;)
    {
      String str2;
      long l;
      String str3;
      try
      {
        Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation");
        if ((!Util.isNullOrNil(this.pax)) && (this.Pbd != null))
        {
          this.IBe = m.aVi(this.pax);
          str2 = this.pax;
          if (this.source == 0)
          {
            l = System.currentTimeMillis();
            BitmapUtil.saveBitmapToImage(this.Pbd, 80, Bitmap.CompressFormat.JPEG, this.pax, false);
            Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation save img cost %d", new Object[] { Integer.valueOf((int)(System.currentTimeMillis() - l)) });
            Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation fileSize %d", new Object[] { Long.valueOf(com.tencent.mm.vfs.y.bEl(this.pax)) });
            localObject = str2;
            this.Pbo[1] = System.currentTimeMillis();
            str2 = this.IBe;
            if (str2 != null) {
              break label437;
            }
            str2 = "";
            break label446;
            m.a(str2, str3, com.tencent.mm.g.a.MediaType_IMAGE, (m.a)new c(this, (String)localObject));
            AppMethodBeat.o(120987);
            return;
          }
          Object localObject = str2;
          if (this.source != 1) {
            continue;
          }
          localObject = MD5Util.getMD5String(kotlin.g.b.s.X(this.pax, Long.valueOf(com.tencent.mm.vfs.y.bEm(this.pax))));
          localObject = ((PluginScanTranslation)com.tencent.mm.kernel.h.az(PluginScanTranslation.class)).getTranslationResultStorage().aUV((String)localObject);
          if (localObject == null) {
            break label339;
          }
          Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation already has translation result");
          this.Pbf = ((gy)localObject).field_resultFile;
          this.Pbe = BitmapUtil.decodeFile(this.Pbf, new BitmapFactory.Options());
          if (this.Pbe == null) {
            break label330;
          }
          MMHandlerThread.postToMainThreadDelayed(new ScanTranslationResultUI..ExternalSyntheticLambda6(this), 500L);
          AppMethodBeat.o(120987);
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.ScanTranslationResultUI", (Throwable)localException, "", new Object[0]);
        AppMethodBeat.o(120987);
        return;
      }
      label330:
      Log.w("MicroMsg.ScanTranslationResultUI", "can not find old translation result!");
      label339:
      String str1 = str2;
      if (this.nDr != 0)
      {
        l = System.currentTimeMillis();
        str1 = ((g)com.tencent.mm.kernel.h.az(g.class)).genScanTmpImgPath("jpg");
        BitmapUtil.saveBitmapToImage(this.Pbd, 80, Bitmap.CompressFormat.JPEG, str1, false);
        Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation save img cost %d", new Object[] { Integer.valueOf((int)(System.currentTimeMillis() - l)) });
        Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation fileSize %d", new Object[] { Long.valueOf(com.tencent.mm.vfs.y.bEl(str1)) });
        continue;
        label437:
        label446:
        while (str1 != null)
        {
          str3 = str1;
          break;
        }
        str3 = "";
      }
    }
  }
  
  private final void gSL()
  {
    AppMethodBeat.i(120989);
    finish();
    int i = a.a.anim_not_change;
    overridePendingTransition(i, i);
    AppMethodBeat.o(120989);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void f(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(120998);
    if (paramInt == this.Pbj)
    {
      if (paramBitmap != null)
      {
        this.Pbn.iPP = ((int)(System.currentTimeMillis() - this.Pbo[1]));
        this.Pbe = paramBitmap;
        gSJ();
        ax(this.Pbe);
        AppMethodBeat.o(120998);
        return;
      }
      aVd(null);
    }
    AppMethodBeat.o(120998);
  }
  
  public final int getLayoutId()
  {
    return a.e.layout_scan_translation_result;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(120999);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 561) && (paramInt2 == -1))
    {
      paramIntent = com.tencent.mm.ui.tools.b.i((Context)getContext(), paramIntent, com.tencent.mm.plugin.image.d.bzL());
      Log.i("MicroMsg.ScanTranslationResultUI", "select: [%s]", new Object[] { paramIntent });
      if (!Util.isNullOrNil(paramIntent))
      {
        this.pax = paramIntent;
        this.source = 1;
        this.Pbn.iOd = 2L;
        this.nDr = Exif.fromFile(paramIntent).getOrientationInDegree();
        Log.i("MicroMsg.ScanTranslationResultUI", "degree %s", new Object[] { Integer.valueOf(this.nDr) });
        paramIntent = BitmapUtil.decodeFileWithSample(paramIntent);
        if (paramIntent != null)
        {
          this.Pbd = BitmapUtil.rotate(paramIntent, this.nDr);
          dSd();
          ax(this.Pbd);
        }
      }
    }
    AppMethodBeat.o(120999);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(120983);
    super.onCreate(paramBundle);
    getController().setNavigationbarColor(getResources().getColor(a.b.UN_BW_0_Alpha_0_9));
    paramBundle = findViewById(a.d.root_container);
    kotlin.g.b.s.s(paramBundle, "findViewById(R.id.root_container)");
    this.pKd = paramBundle;
    paramBundle = findViewById(a.d.translate_gallery_view);
    kotlin.g.b.s.s(paramBundle, "findViewById(R.id.translate_gallery_view)");
    this.Pbh = ((MMGestureGallery)paramBundle);
    this.Pby = new b();
    paramBundle = this.Pbh;
    if (paramBundle == null)
    {
      kotlin.g.b.s.bIx("gestureGallery");
      paramBundle = null;
    }
    for (;;)
    {
      paramBundle.setAdapter((SpinnerAdapter)this.Pby);
      paramBundle = findViewById(a.d.save_translate_container);
      kotlin.g.b.s.s(paramBundle, "findViewById(R.id.save_translate_container)");
      this.PaX = paramBundle;
      localObject = this.PaX;
      paramBundle = (Bundle)localObject;
      if (localObject == null)
      {
        kotlin.g.b.s.bIx("saveContainer");
        paramBundle = null;
      }
      paramBundle = paramBundle.findViewById(a.d.translate_view_source_btn);
      kotlin.g.b.s.s(paramBundle, "saveContainer.findViewBy…ranslate_view_source_btn)");
      this.PaY = ((ImageView)paramBundle);
      localObject = this.PaY;
      paramBundle = (Bundle)localObject;
      if (localObject == null)
      {
        kotlin.g.b.s.bIx("viewSourceBtn");
        paramBundle = null;
      }
      paramBundle.setOnClickListener(new ScanTranslationResultUI..ExternalSyntheticLambda5(this));
      paramBundle = findViewById(a.d.translate_top_bg);
      kotlin.g.b.s.s(paramBundle, "findViewById(R.id.translate_top_bg)");
      this.Pba = paramBundle;
      paramBundle = findViewById(a.d.translate_bottom_bg);
      kotlin.g.b.s.s(paramBundle, "findViewById(R.id.translate_bottom_bg)");
      this.Pbb = paramBundle;
      hideTitleView();
      paramBundle = getSupportActionBar();
      if (paramBundle != null) {
        paramBundle.hide();
      }
      paramBundle = findViewById(a.d.scan_line);
      kotlin.g.b.s.s(paramBundle, "findViewById(R.id.scan_line)");
      this.AjC = ((ImageView)paramBundle);
      localObject = this.PaX;
      paramBundle = (Bundle)localObject;
      if (localObject == null)
      {
        kotlin.g.b.s.bIx("saveContainer");
        paramBundle = null;
      }
      paramBundle = paramBundle.findViewById(a.d.translate_download_btn);
      kotlin.g.b.s.s(paramBundle, "saveContainer.findViewBy…d.translate_download_btn)");
      this.PaZ = paramBundle;
      localObject = this.PaZ;
      paramBundle = (Bundle)localObject;
      if (localObject == null)
      {
        kotlin.g.b.s.bIx("saveImgBtn");
        paramBundle = null;
      }
      paramBundle.setOnClickListener(new ScanTranslationResultUI..ExternalSyntheticLambda4(this));
      paramBundle = findViewById(a.d.close_button);
      kotlin.g.b.s.s(paramBundle, "findViewById(R.id.close_button)");
      this.puG = ((WeImageView)paramBundle);
      localObject = this.puG;
      paramBundle = (Bundle)localObject;
      if (localObject == null)
      {
        kotlin.g.b.s.bIx("closeButton");
        paramBundle = null;
      }
      paramBundle.setOnClickListener(new ScanTranslationResultUI..ExternalSyntheticLambda3(this));
      this.pvg = com.tencent.mm.cd.a.mt((Context)getContext());
      this.AjF.setFloatValues(new float[] { 0.0F, 1.0F });
      this.AjF.addListener((Animator.AnimatorListener)new f(this));
      this.AjF.addUpdateListener(new ScanTranslationResultUI..ExternalSyntheticLambda0(this));
      localObject = this.PaX;
      paramBundle = (Bundle)localObject;
      if (localObject == null)
      {
        kotlin.g.b.s.bIx("saveContainer");
        paramBundle = null;
      }
      paramBundle = paramBundle.getLayoutParams();
      if (paramBundle != null) {
        break;
      }
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(120983);
      throw paramBundle;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramBundle;
    int i = localLayoutParams.bottomMargin;
    localLayoutParams.bottomMargin = (aw.bk((Context)getContext()) + i);
    Object localObject = this.PaX;
    paramBundle = (Bundle)localObject;
    if (localObject == null)
    {
      kotlin.g.b.s.bIx("saveContainer");
      paramBundle = null;
    }
    paramBundle.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
    this.AjF.setDuration(5000L);
    com.tencent.mm.ui.base.b.a((Activity)this, null);
    gSE();
    localObject = getIntent().getStringExtra("key_translation_origin_image_path");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.pax = paramBundle;
    this.source = getIntent().getIntExtra("key_translation_source", 0);
    if (this.source == 0)
    {
      this.Pbn.iYM = getIntent().getLongExtra("key_translation_capture_time", 0L);
      this.Pbn.iOd = 1L;
    }
    for (;;)
    {
      Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo initData originPath: %s, source: %d", new Object[] { this.pax, Integer.valueOf(this.source) });
      paramBundle = this.pax;
      kotlin.g.b.s.checkNotNull(paramBundle);
      this.Pbd = ap.aUP(paramBundle);
      if (this.Pbd != null)
      {
        paramBundle = this.Pbd;
        kotlin.g.b.s.checkNotNull(paramBundle);
        if (!paramBundle.isRecycled())
        {
          paramBundle = this.Pbd;
          kotlin.g.b.s.checkNotNull(paramBundle);
          i = paramBundle.getWidth();
          paramBundle = this.Pbd;
          kotlin.g.b.s.checkNotNull(paramBundle);
          Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo initData bitmap width: %d, height: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramBundle.getHeight()) });
        }
      }
      ax(this.Pbd);
      AppMethodBeat.o(120983);
      return;
      if (this.source == 1)
      {
        this.Pbn.iYM = 0L;
        this.Pbn.iOd = 2L;
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(120991);
    super.onDestroy();
    this.AjF.removeAllListeners();
    this.AjF.removeAllUpdateListeners();
    this.AjF.cancel();
    ap.clear();
    Object localObject = com.tencent.mm.kernel.h.az(PluginScanTranslation.class);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.PluginScanTranslation");
      AppMethodBeat.o(120991);
      throw ((Throwable)localObject);
    }
    ((PluginScanTranslation)localObject).getTranslationRender().gUe();
    AppMethodBeat.o(120991);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(120988);
    kotlin.g.b.s.u(paramKeyEvent, "event");
    if (paramInt == 4)
    {
      paramKeyEvent = com.tencent.mm.kernel.h.az(PluginScanTranslation.class);
      if (paramKeyEvent == null)
      {
        paramKeyEvent = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.PluginScanTranslation");
        AppMethodBeat.o(120988);
        throw paramKeyEvent;
      }
      ((PluginScanTranslation)paramKeyEvent).getTranslationRender().gUe();
      if (this.owq != 0)
      {
        if ((this.owq != 1) && (this.owq != 2) && (this.owq != 3)) {
          break label140;
        }
        if (this.owq == 1) {
          this.Pbn.iPP = ((int)(System.currentTimeMillis() - this.Pbo[1]));
        }
        if (this.Pbn.iOQ != 0L) {
          this.Pbn.bMH();
        }
      }
      gSL();
      label140:
      AppMethodBeat.o(120988);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(120988);
    return bool;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(120986);
    super.onPause();
    com.tencent.mm.kernel.h.aZW().b(294, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(120986);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(120985);
    super.onResume();
    Window localWindow = getWindow();
    if (localWindow != null) {
      localWindow.addFlags(2097280);
    }
    if (com.tencent.mm.compatible.util.d.rb(19)) {
      getWindow().addFlags(67109888);
    }
    for (;;)
    {
      getWindow().getDecorView().setSystemUiVisibility(1280);
      f.d(false, true, true);
      com.tencent.mm.kernel.h.aZW().a(294, (com.tencent.mm.am.h)this);
      Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo onResume curState: %d", new Object[] { Integer.valueOf(this.owq) });
      if (this.owq == -1) {
        dSd();
      }
      AppMethodBeat.o(120985);
      return;
      getWindow().setFlags(1024, 1024);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(120996);
    Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo scanTranslate onSceneEnd errType %s, errCode %s, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramp == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.model.NetSceneNewOCRTranslation");
        AppMethodBeat.o(120996);
        throw paramString;
      }
      paramString = ((com.tencent.mm.plugin.scanner.model.s)paramp).ORL;
      if ((paramString != null) && (((com.tencent.mm.plugin.scanner.model.s)paramp).hBm == this.Pbj))
      {
        this.Pbn.iYO = ((int)(System.currentTimeMillis() - ((com.tencent.mm.plugin.scanner.model.s)paramp).ORM));
        Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo scanTranslate onSceneEnd angle %f, translationInfos length %d", new Object[] { Float.valueOf(((com.tencent.mm.plugin.scanner.model.s)paramp).angle), Integer.valueOf(paramString.size()) });
        if (paramString.size() > 0)
        {
          this.Pbn.iOQ = 1L;
          ((PluginScanTranslation)com.tencent.mm.kernel.h.az(PluginScanTranslation.class)).getTranslationRender().a(this.Pbj, paramString, ((com.tencent.mm.plugin.scanner.model.s)paramp).angle, this.Pbd, (n.b)this);
          if (!Util.isNullOrNil(((com.tencent.mm.plugin.scanner.model.s)paramp).gQU()))
          {
            this.Pbk = ((com.tencent.mm.plugin.scanner.model.s)paramp).gQU();
            AppMethodBeat.o(120996);
          }
        }
        else
        {
          this.Pbn.iPP = ((int)(System.currentTimeMillis() - this.Pbo[1]));
          paramString = getResources().getString(a.g.scan_translating_no_result);
          kotlin.g.b.s.s(paramString, "resources.getString(R.st…an_translating_no_result)");
          k.a((Context)getContext(), paramString, "", false, new ScanTranslationResultUI..ExternalSyntheticLambda2(this));
          AppMethodBeat.o(120996);
        }
      }
    }
    else
    {
      aVd(paramString);
    }
    AppMethodBeat.o(120996);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(120990);
    super.onStop();
    com.tencent.mm.kernel.h.aZW().b(294, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(120990);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$TranslateImageAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)V", "bitmap", "Landroid/graphics/Bitmap;", "getCount", "", "getItem", "", "i", "getItemId", "", "getView", "Landroid/view/View;", "view", "viewGroup", "Landroid/view/ViewGroup;", "setImageBitmap", "", "scan-translation_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class b
    extends BaseAdapter
  {
    private Bitmap bitmap;
    
    public b()
    {
      AppMethodBeat.i(314588);
      AppMethodBeat.o(314588);
    }
    
    public final int getCount()
    {
      return 1;
    }
    
    public final Object getItem(int paramInt)
    {
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(120968);
      kotlin.g.b.s.u(paramViewGroup, "viewGroup");
      if (paramView == null)
      {
        paramView = new MultiTouchImageView((Context)this.Pbz.getContext(), 0, 0, (byte)0);
        paramView.setLayoutParams((ViewGroup.LayoutParams)new Gallery.LayoutParams(-1, -1));
      }
      for (;;)
      {
        if (this.bitmap != null)
        {
          paramView.setImageBitmap(this.bitmap);
          paramViewGroup = this.bitmap;
          kotlin.g.b.s.checkNotNull(paramViewGroup);
          paramInt = paramViewGroup.getWidth();
          paramViewGroup = this.bitmap;
          kotlin.g.b.s.checkNotNull(paramViewGroup);
          paramView.dU(paramInt, paramViewGroup.getHeight());
          paramView.jma();
        }
        paramView = (View)paramView;
        AppMethodBeat.o(120968);
        return paramView;
        paramView = (MultiTouchImageView)paramView;
      }
    }
    
    public final void setImageBitmap(Bitmap paramBitmap)
    {
      AppMethodBeat.i(120969);
      kotlin.g.b.s.u(paramBitmap, "bitmap");
      this.bitmap = paramBitmap;
      AppMethodBeat.o(120969);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$doTranslation$2", "Lcom/tencent/mm/plugin/scanner/util/ScanTranslateCdnService$ScanTranslateUploadCallback;", "onFinish", "", "mediaId", "", "result", "Lcom/tencent/mm/plugin/scanner/util/ScanTranslateCdnService$ScanTranslateUploadCallbackResult;", "scan-translation_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements m.a
  {
    c(ScanTranslationResultUI paramScanTranslationResultUI, String paramString) {}
    
    private static final void c(ScanTranslationResultUI paramScanTranslationResultUI, DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(314566);
      kotlin.g.b.s.u(paramScanTranslationResultUI, "this$0");
      ScanTranslationResultUI.i(paramScanTranslationResultUI);
      AppMethodBeat.o(314566);
    }
    
    private static final void d(ScanTranslationResultUI paramScanTranslationResultUI, DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(314572);
      kotlin.g.b.s.u(paramScanTranslationResultUI, "this$0");
      ScanTranslationResultUI.i(paramScanTranslationResultUI);
      AppMethodBeat.o(314572);
    }
    
    private static final void e(ScanTranslationResultUI paramScanTranslationResultUI, DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(314577);
      kotlin.g.b.s.u(paramScanTranslationResultUI, "this$0");
      ScanTranslationResultUI.i(paramScanTranslationResultUI);
      AppMethodBeat.o(314577);
    }
    
    private static final void k(ScanTranslationResultUI paramScanTranslationResultUI)
    {
      AppMethodBeat.i(314569);
      kotlin.g.b.s.u(paramScanTranslationResultUI, "this$0");
      ScanTranslationResultUI.j(paramScanTranslationResultUI);
      k.d((Context)paramScanTranslationResultUI.getContext(), paramScanTranslationResultUI.getResources().getString(a.g.scan_translating_no_result), paramScanTranslationResultUI.getResources().getString(a.g.app_tip), new ScanTranslationResultUI.c..ExternalSyntheticLambda0(paramScanTranslationResultUI));
      AppMethodBeat.o(314569);
    }
    
    private static final void l(ScanTranslationResultUI paramScanTranslationResultUI)
    {
      AppMethodBeat.i(314574);
      kotlin.g.b.s.u(paramScanTranslationResultUI, "this$0");
      ScanTranslationResultUI.j(paramScanTranslationResultUI);
      k.d((Context)paramScanTranslationResultUI.getContext(), paramScanTranslationResultUI.getResources().getString(a.g.file_explorer_cannot_open_file), paramScanTranslationResultUI.getResources().getString(a.g.app_tip), new ScanTranslationResultUI.c..ExternalSyntheticLambda2(paramScanTranslationResultUI));
      AppMethodBeat.o(314574);
    }
    
    private static final void m(ScanTranslationResultUI paramScanTranslationResultUI)
    {
      AppMethodBeat.i(314578);
      kotlin.g.b.s.u(paramScanTranslationResultUI, "this$0");
      ScanTranslationResultUI.j(paramScanTranslationResultUI);
      k.d((Context)paramScanTranslationResultUI.getContext(), paramScanTranslationResultUI.getResources().getString(a.g.file_explorer_cannot_open_file), paramScanTranslationResultUI.getResources().getString(a.g.app_tip), new ScanTranslationResultUI.c..ExternalSyntheticLambda1(paramScanTranslationResultUI));
      AppMethodBeat.o(314578);
    }
    
    public final void a(String paramString, m.b paramb)
    {
      AppMethodBeat.i(314598);
      kotlin.g.b.s.u(paramb, "result");
      if ((!Util.isNullOrNil(paramString)) && (kotlin.g.b.s.p(paramString, ScanTranslationResultUI.c(this.Pbz))))
      {
        ScanTranslationResultUI.d(this.Pbz).iYN = ((int)(System.currentTimeMillis() - ScanTranslationResultUI.e(this.Pbz)[1]));
        Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo scanTranslate upload img cost %d, errCode: %d", new Object[] { Long.valueOf(ScanTranslationResultUI.d(this.Pbz).iYN), Integer.valueOf(paramb.errCode) });
        ScanTranslationResultUI.d(this.Pbz).ua(paramb.fileId);
        ScanTranslationResultUI.d(this.Pbz).ub(paramb.aeskey);
        switch (paramb.errCode)
        {
        default: 
          MMHandlerThread.postToMainThread(new ScanTranslationResultUI.c..ExternalSyntheticLambda5(this.Pbz));
          ScanTranslationResultUI.d(this.Pbz).iOQ = 3L;
        }
      }
      for (;;)
      {
        if ((ScanTranslationResultUI.g(this.Pbz) == 1) && (ScanTranslationResultUI.h(this.Pbz) != 0))
        {
          Log.i("delete tmp path %s", this.PbA);
          com.tencent.mm.vfs.y.deleteFile(this.PbA);
        }
        AppMethodBeat.o(314598);
        return;
        if (!Util.isNullOrNil(new String[] { paramb.fileId, paramb.aeskey }))
        {
          Log.i("MicroMsg.ScanTranslationResultUI", "fileId %s", new Object[] { paramb.fileId });
          paramString = new com.tencent.mm.plugin.scanner.model.s(ScanTranslationResultUI.f(this.Pbz), (int)com.tencent.mm.vfs.y.bEl(this.PbA), paramb.fileId, paramb.aeskey);
          com.tencent.mm.kernel.h.aZW().a((p)paramString, 0);
        }
        else
        {
          MMHandlerThread.postToMainThread(new ScanTranslationResultUI.c..ExternalSyntheticLambda3(this.Pbz));
          ScanTranslationResultUI.d(this.Pbz).iOQ = 3L;
          continue;
          MMHandlerThread.postToMainThread(new ScanTranslationResultUI.c..ExternalSyntheticLambda4(this.Pbz));
          ScanTranslationResultUI.d(this.Pbz).iOQ = 3L;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$init$2$1$1", "Lcom/tencent/mm/platformtools/ExportFileUtil$ExportResultCallback;", "onExportFail", "", "srcPath", "", "destPath", "onExportSuccess", "scan-translation_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements ExportFileUtil.a
  {
    d(ScanTranslationResultUI paramScanTranslationResultUI) {}
    
    public final void cg(String paramString1, String paramString2)
    {
      AppMethodBeat.i(314568);
      kotlin.g.b.s.u(paramString1, "srcPath");
      kotlin.g.b.s.u(paramString2, "destPath");
      paramString1 = this.Pbz.getContext();
      if (paramString1 == null)
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(314568);
        throw paramString1;
      }
      com.tencent.mm.ui.widget.snackbar.b.u((Activity)paramString1, this.Pbz.getResources().getString(a.g.scan_translation_save_to_gallery_success));
      AppMethodBeat.o(314568);
    }
    
    public final void ch(String paramString1, String paramString2)
    {
      AppMethodBeat.i(314571);
      kotlin.g.b.s.u(paramString1, "srcPath");
      kotlin.g.b.s.u(paramString2, "destPath");
      paramString1 = this.Pbz.getContext();
      if (paramString1 == null)
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(314571);
        throw paramString1;
      }
      com.tencent.mm.ui.widget.snackbar.b.u((Activity)paramString1, this.Pbz.getResources().getString(a.g.save_image_err));
      AppMethodBeat.o(314571);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$init$2$2$1", "Lcom/tencent/mm/platformtools/ExportFileUtil$ExportResultCallback;", "onExportFail", "", "srcPath", "", "destPath", "onExportSuccess", "scan-translation_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements ExportFileUtil.a
  {
    e(ScanTranslationResultUI paramScanTranslationResultUI) {}
    
    public final void cg(String paramString1, String paramString2)
    {
      AppMethodBeat.i(314567);
      kotlin.g.b.s.u(paramString1, "srcPath");
      kotlin.g.b.s.u(paramString2, "destPath");
      paramString1 = this.Pbz.getContext();
      if (paramString1 == null)
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(314567);
        throw paramString1;
      }
      com.tencent.mm.ui.widget.snackbar.b.u((Activity)paramString1, this.Pbz.getResources().getString(a.g.scan_translation_save_to_gallery_success));
      AppMethodBeat.o(314567);
    }
    
    public final void ch(String paramString1, String paramString2)
    {
      AppMethodBeat.i(314570);
      kotlin.g.b.s.u(paramString1, "srcPath");
      kotlin.g.b.s.u(paramString2, "destPath");
      paramString1 = this.Pbz.getContext();
      if (paramString1 == null)
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(314570);
        throw paramString1;
      }
      com.tencent.mm.ui.widget.snackbar.b.u((Activity)paramString1, this.Pbz.getResources().getString(a.g.save_image_err));
      AppMethodBeat.o(314570);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$init$4", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "scan-translation_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends AnimatorListenerAdapter
  {
    f(ScanTranslationResultUI paramScanTranslationResultUI) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(162356);
      ImageView localImageView = ScanTranslationResultUI.b(this.Pbz);
      paramAnimator = localImageView;
      if (localImageView == null)
      {
        kotlin.g.b.s.bIx("scanLine");
        paramAnimator = null;
      }
      paramAnimator.setAlpha(0.0F);
      AppMethodBeat.o(162356);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(162355);
      ImageView localImageView = ScanTranslationResultUI.b(this.Pbz);
      paramAnimator = localImageView;
      if (localImageView == null)
      {
        kotlin.g.b.s.bIx("scanLine");
        paramAnimator = null;
      }
      paramAnimator.setAlpha(0.0F);
      AppMethodBeat.o(162355);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationResultUI
 * JD-Core Version:    0.7.0.1
 */