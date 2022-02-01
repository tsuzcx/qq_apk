package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.f.b.a.it;
import com.tencent.mm.f.c.ge;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.al.a.a;
import com.tencent.mm.plugin.al.a.b;
import com.tencent.mm.plugin.al.a.c;
import com.tencent.mm.plugin.al.a.d;
import com.tencent.mm.plugin.al.a.e;
import com.tencent.mm.plugin.al.a.f;
import com.tencent.mm.plugin.al.a.g;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.scanner.PluginScanTranslation;
import com.tencent.mm.plugin.scanner.g;
import com.tencent.mm.plugin.scanner.model.ag;
import com.tencent.mm.plugin.scanner.model.ah;
import com.tencent.mm.plugin.scanner.util.k.a;
import com.tencent.mm.plugin.scanner.util.k.b;
import com.tencent.mm.plugin.scanner.util.l.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.List;
import kotlin.g.b.p;
import kotlin.n.n;

@com.tencent.mm.ui.base.a(3)
@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/scanner/util/ScanTranslationRender$TranslationRenderCallback;", "()V", "bottomBgLayer", "Landroid/view/View;", "closeButton", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "curMediaId", "", "curSessionId", "", "curState", "gestureGallery", "Lcom/tencent/mm/ui/tools/MMGestureGallery;", "originalBitmap", "Landroid/graphics/Bitmap;", "originalPath", "reportData", "Lcom/tencent/mm/autogen/mmdata/rpt/OCRTranslateReportStruct;", "rootContainer", "rotateDegree", "saveContainer", "saveImgBtn", "scanLine", "Landroid/widget/ImageView;", "scanLineAnimator", "Landroid/animation/ValueAnimator;", "screenHeight", "source", "startTimeArray", "", "targetLang", "topBgLayer", "translateBitmap", "translateImageAdapter", "Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$TranslateImageAdapter;", "translationPath", "viewSourceBtn", "configNavigationBar", "", "doTranslation", "drawTranslationResult", "session", "newBitmap", "enterFullScreen", "enterPreviewStatus", "enterTranslateFinishStatus", "enterTranslateStatus", "finishActivity", "getLayoutId", "goBack", "init", "initData", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "resetTargetLang", "setPreviewBitmap", "bitmap", "startScanLineAnimation", "stopScanLineAnimation", "Companion", "TranslateImageAdapter", "scan-translation_release"})
public final class ScanTranslationResultUI
  extends MMActivity
  implements i, l.b
{
  public static final ScanTranslationResultUI.a ISD;
  private String CGU;
  private WeImageView FTK;
  private ScanTranslationResultUI.b ISC;
  private View ISc;
  private ImageView ISd;
  private View ISe;
  private View ISf;
  private View ISg;
  private Bitmap ISi;
  private Bitmap ISj;
  private String ISk;
  private MMGestureGallery ISm;
  private int ISo;
  private String ISp;
  private final it ISs;
  private final long[] ISt;
  private int kYg;
  private int lEK;
  private View mNv;
  private String mhn;
  private int pEk;
  private int source;
  private ImageView wNf;
  private ValueAnimator wNi;
  
  static
  {
    AppMethodBeat.i(121001);
    ISD = new ScanTranslationResultUI.a((byte)0);
    AppMethodBeat.o(121001);
  }
  
  public ScanTranslationResultUI()
  {
    AppMethodBeat.i(121000);
    this.wNi = new ValueAnimator();
    this.lEK = -1;
    this.ISs = new it();
    this.ISt = new long[2];
    AppMethodBeat.o(121000);
  }
  
  private final void ak(Bitmap paramBitmap)
  {
    AppMethodBeat.i(120997);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(120997);
      return;
    }
    Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo setImageBitmap size: %s, %s", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
    ScanTranslationResultUI.b localb = this.ISC;
    if (localb != null) {
      localb.setImageBitmap(paramBitmap);
    }
    paramBitmap = this.ISC;
    if (paramBitmap != null)
    {
      paramBitmap.notifyDataSetChanged();
      AppMethodBeat.o(120997);
      return;
    }
    AppMethodBeat.o(120997);
  }
  
  private final void dln()
  {
    AppMethodBeat.i(120992);
    this.ISs.ug(2L);
    this.ISo = ((int)(z.bcZ().hashCode() + System.currentTimeMillis() & 0xFFFFFFFF));
    this.lEK = 1;
    fDQ();
    Object localObject;
    if (n.L(this.ISp, "zh_CN", true))
    {
      localObject = this.ISd;
      if (localObject == null) {
        p.bGy("viewSourceBtn");
      }
      ((ImageView)localObject).setImageResource(a.f.translation_result_chinese);
    }
    for (;;)
    {
      localObject = this.ISf;
      if (localObject == null) {
        p.bGy("topBgLayer");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.ISg;
      if (localObject == null) {
        p.bGy("bottomBgLayer");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.ISc;
      if (localObject == null) {
        p.bGy("saveContainer");
      }
      ((View)localObject).setVisibility(8);
      localObject = this.wNf;
      if (localObject == null) {
        p.bGy("scanLine");
      }
      ((ImageView)localObject).setVisibility(0);
      localObject = this.ISm;
      if (localObject == null) {
        p.bGy("gestureGallery");
      }
      ((MMGestureGallery)localObject).setVisibility(0);
      dlp();
      fDW();
      AppMethodBeat.o(120992);
      return;
      localObject = this.ISd;
      if (localObject == null) {
        p.bGy("viewSourceBtn");
      }
      ((ImageView)localObject).setImageResource(a.f.translation_result_english);
    }
  }
  
  private final void dlp()
  {
    AppMethodBeat.i(120994);
    this.wNi.setRepeatMode(1);
    this.wNi.setRepeatCount(-1);
    this.wNi.start();
    AppMethodBeat.o(120994);
  }
  
  private final void dlq()
  {
    AppMethodBeat.i(120995);
    this.wNi.setRepeatMode(1);
    this.wNi.setRepeatCount(0);
    this.wNi.end();
    AppMethodBeat.o(120995);
  }
  
  private final void fDQ()
  {
    AppMethodBeat.i(120984);
    n.L(LocaleUtil.getApplicationLanguage(), "zh_CN", true);
    this.ISp = LocaleUtil.getCurrentLanguage((Context)getContext());
    Log.i("MicroMsg.ScanTranslationResultUI", "targetLang %s", new Object[] { this.ISp });
    AppMethodBeat.o(120984);
  }
  
  private final void fDV()
  {
    AppMethodBeat.i(120993);
    Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo enterTranslateFinishStatus");
    this.lEK = 3;
    Object localObject = this.ISc;
    if (localObject == null) {
      p.bGy("saveContainer");
    }
    ((View)localObject).setVisibility(0);
    if (n.L(this.ISp, "zh_CN", true))
    {
      localObject = this.ISd;
      if (localObject == null) {
        p.bGy("viewSourceBtn");
      }
      ((ImageView)localObject).setImageResource(a.c.translate_chinese_view_source_btn);
    }
    for (;;)
    {
      localObject = this.wNf;
      if (localObject == null) {
        p.bGy("scanLine");
      }
      ((ImageView)localObject).setVisibility(8);
      dlq();
      if ((this.source != 1) || (!Util.isNullOrNil(this.ISk))) {
        break label289;
      }
      this.ISk = ((PluginScanTranslation)com.tencent.mm.kernel.h.ag(PluginScanTranslation.class)).genTranslationResultImgPath("jpg");
      try
      {
        BitmapUtil.saveBitmapToImage(this.ISj, 80, Bitmap.CompressFormat.JPEG, this.ISk, false);
        localObject = new ah();
        ((ah)localObject).field_originMD5 = MD5Util.getMD5String(p.I(this.mhn, Long.valueOf(u.bBR(this.mhn))));
        ((ah)localObject).field_resultFile = this.ISk;
        Log.i("MicroMsg.ScanTranslationResultUI", "insert translate result %s", new Object[] { this.ISk });
        com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.h.ag(PluginScanTranslation.class);
        p.j(locala, "MMKernel.plugin(PluginScanTranslation::class.java)");
        ((PluginScanTranslation)locala).getTranslationResultStorage().a((ah)localObject);
        AppMethodBeat.o(120993);
        return;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.ScanTranslationResultUI", (Throwable)localIOException, "save translate result file error", new Object[0]);
      }
      localObject = this.ISd;
      if (localObject == null) {
        p.bGy("viewSourceBtn");
      }
      ((ImageView)localObject).setImageResource(a.c.translate_english_view_source_btn);
    }
    label289:
    AppMethodBeat.o(120993);
  }
  
  private final void fDW()
  {
    AppMethodBeat.i(120987);
    for (;;)
    {
      String str2;
      long l;
      Object localObject2;
      try
      {
        Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation");
        if ((!Util.isNullOrNil(this.mhn)) && (this.ISi != null))
        {
          this.CGU = com.tencent.mm.plugin.scanner.util.k.aXA(this.mhn);
          str2 = this.mhn;
          if (this.source == 0)
          {
            l = System.currentTimeMillis();
            BitmapUtil.saveBitmapToImage(this.ISi, 80, Bitmap.CompressFormat.JPEG, this.mhn, false);
            Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation save img cost %d", new Object[] { Integer.valueOf((int)(System.currentTimeMillis() - l)) });
            Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation fileSize %d", new Object[] { Long.valueOf(u.bBQ(this.mhn)) });
            localObject1 = str2;
            this.ISt[1] = System.currentTimeMillis();
            str2 = this.CGU;
            if (str2 != null) {
              break label450;
            }
            str2 = "";
            break label450;
            com.tencent.mm.plugin.scanner.util.k.a(str2, (String)localObject2, com.tencent.mm.i.a.MediaType_IMAGE, (k.a)new d(this, (String)localObject1));
            AppMethodBeat.o(120987);
            return;
          }
          Object localObject1 = str2;
          if (this.source != 1) {
            continue;
          }
          localObject1 = MD5Util.getMD5String(p.I(this.mhn, Long.valueOf(u.bBR(this.mhn))));
          localObject2 = com.tencent.mm.kernel.h.ag(PluginScanTranslation.class);
          p.j(localObject2, "MMKernel.plugin(PluginScanTranslation::class.java)");
          localObject1 = ((PluginScanTranslation)localObject2).getTranslationResultStorage().aXn((String)localObject1);
          if (localObject1 == null) {
            break label348;
          }
          Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation already has translation result");
          this.ISk = ((ge)localObject1).field_resultFile;
          this.ISj = BitmapUtil.decodeFile(this.ISk, new BitmapFactory.Options());
          if (this.ISj == null) {
            break label340;
          }
          MMHandlerThread.postToMainThreadDelayed((Runnable)new c(this), 500L);
          AppMethodBeat.o(120987);
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.ScanTranslationResultUI", (Throwable)localException, "", new Object[0]);
        AppMethodBeat.o(120987);
        return;
      }
      label340:
      Log.w("MicroMsg.ScanTranslationResultUI", "can not find old translation result!");
      label348:
      String str1 = str2;
      if (this.kYg != 0)
      {
        l = System.currentTimeMillis();
        str1 = ((g)com.tencent.mm.kernel.h.ag(g.class)).genScanTmpImgPath("jpg");
        BitmapUtil.saveBitmapToImage(this.ISi, 80, Bitmap.CompressFormat.JPEG, str1, false);
        Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation save img cost %d", new Object[] { Integer.valueOf((int)(System.currentTimeMillis() - l)) });
        Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation fileSize %d", new Object[] { Long.valueOf(u.bBQ(str1)) });
        continue;
        label450:
        do
        {
          localObject2 = str1;
          break;
        } while (str1 != null);
        localObject2 = "";
      }
    }
  }
  
  private final void fDX()
  {
    AppMethodBeat.i(120989);
    finish();
    int i = a.a.anim_not_change;
    overridePendingTransition(i, i);
    AppMethodBeat.o(120989);
  }
  
  public final void d(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(120998);
    if ((paramBitmap != null) && (paramInt == this.ISo))
    {
      this.ISs.uj((int)(System.currentTimeMillis() - this.ISt[1]));
      this.ISj = paramBitmap;
      fDV();
      ak(this.ISj);
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
      paramIntent = com.tencent.mm.ui.tools.b.h((Context)getContext(), paramIntent, com.tencent.mm.plugin.image.d.bbW());
      Log.i("MicroMsg.ScanTranslationResultUI", "select: [%s]", new Object[] { paramIntent });
      if (!Util.isNullOrNil(paramIntent))
      {
        this.mhn = paramIntent;
        this.source = 1;
        this.ISs.ue(2L);
        Exif localExif = Exif.fromFile(paramIntent);
        p.j(localExif, "Exif.fromFile(filePath)");
        this.kYg = localExif.getOrientationInDegree();
        Log.i("MicroMsg.ScanTranslationResultUI", "degree %s", new Object[] { Integer.valueOf(this.kYg) });
        paramIntent = BitmapUtil.decodeFileWithSample(paramIntent);
        if (paramIntent != null)
        {
          this.ISi = BitmapUtil.rotate(paramIntent, this.kYg);
          dln();
          ak(this.ISi);
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
    p.j(paramBundle, "findViewById(R.id.root_container)");
    this.mNv = paramBundle;
    paramBundle = findViewById(a.d.translate_gallery_view);
    p.j(paramBundle, "findViewById(R.id.translate_gallery_view)");
    this.ISm = ((MMGestureGallery)paramBundle);
    this.ISC = new ScanTranslationResultUI.b(this);
    paramBundle = this.ISm;
    if (paramBundle == null) {
      p.bGy("gestureGallery");
    }
    paramBundle.setAdapter((SpinnerAdapter)this.ISC);
    paramBundle = findViewById(a.d.save_translate_container);
    p.j(paramBundle, "findViewById(R.id.save_translate_container)");
    this.ISc = paramBundle;
    paramBundle = this.ISc;
    if (paramBundle == null) {
      p.bGy("saveContainer");
    }
    paramBundle = paramBundle.findViewById(a.d.translate_view_source_btn);
    p.j(paramBundle, "saveContainer.findViewBy…ranslate_view_source_btn)");
    this.ISd = ((ImageView)paramBundle);
    paramBundle = this.ISd;
    if (paramBundle == null) {
      p.bGy("viewSourceBtn");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new e(this));
    paramBundle = findViewById(a.d.translate_top_bg);
    p.j(paramBundle, "findViewById(R.id.translate_top_bg)");
    this.ISf = paramBundle;
    paramBundle = findViewById(a.d.translate_bottom_bg);
    p.j(paramBundle, "findViewById(R.id.translate_bottom_bg)");
    this.ISg = paramBundle;
    hideTitleView();
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    paramBundle = findViewById(a.d.scan_line);
    p.j(paramBundle, "findViewById(R.id.scan_line)");
    this.wNf = ((ImageView)paramBundle);
    paramBundle = this.ISc;
    if (paramBundle == null) {
      p.bGy("saveContainer");
    }
    paramBundle = paramBundle.findViewById(a.d.translate_download_btn);
    p.j(paramBundle, "saveContainer.findViewBy…d.translate_download_btn)");
    this.ISe = paramBundle;
    paramBundle = this.ISe;
    if (paramBundle == null) {
      p.bGy("saveImgBtn");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new f(this));
    paramBundle = findViewById(a.d.close_button);
    p.j(paramBundle, "findViewById(R.id.close_button)");
    this.FTK = ((WeImageView)paramBundle);
    paramBundle = this.FTK;
    if (paramBundle == null) {
      p.bGy("closeButton");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new ScanTranslationResultUI.g(this));
    this.pEk = com.tencent.mm.ci.a.ks((Context)getContext());
    this.wNi.setFloatValues(new float[] { 0.0F, 1.0F });
    this.wNi.addListener((Animator.AnimatorListener)new ScanTranslationResultUI.h(this));
    this.wNi.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new ScanTranslationResultUI.i(this));
    paramBundle = this.ISc;
    if (paramBundle == null) {
      p.bGy("saveContainer");
    }
    paramBundle = paramBundle.getLayoutParams();
    if (paramBundle == null)
    {
      paramBundle = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(120983);
      throw paramBundle;
    }
    paramBundle = (RelativeLayout.LayoutParams)paramBundle;
    int i = paramBundle.bottomMargin;
    paramBundle.bottomMargin = (ar.aB((Context)getContext()) + i);
    Object localObject = this.ISc;
    if (localObject == null) {
      p.bGy("saveContainer");
    }
    ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)paramBundle);
    this.wNi.setDuration(5000L);
    com.tencent.mm.ui.base.b.a((Activity)this, null);
    fDQ();
    localObject = getIntent().getStringExtra("key_translation_origin_image_path");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.mhn = paramBundle;
    this.source = getIntent().getIntExtra("key_translation_source", 0);
    if (this.source == 0)
    {
      this.ISs.uf(getIntent().getLongExtra("key_translation_capture_time", 0L));
      this.ISs.ue(1L);
    }
    for (;;)
    {
      Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo initData originPath: %s, source: %d", new Object[] { this.mhn, Integer.valueOf(this.source) });
      paramBundle = this.mhn;
      if (paramBundle == null) {
        p.iCn();
      }
      this.ISi = ag.aXk(paramBundle);
      if (this.ISi != null)
      {
        paramBundle = this.ISi;
        if (paramBundle == null) {
          p.iCn();
        }
        if (!paramBundle.isRecycled())
        {
          paramBundle = this.ISi;
          if (paramBundle == null) {
            p.iCn();
          }
          i = paramBundle.getWidth();
          paramBundle = this.ISi;
          if (paramBundle == null) {
            p.iCn();
          }
          Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo initData bitmap width: %d, height: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramBundle.getHeight()) });
        }
      }
      ak(this.ISi);
      AppMethodBeat.o(120983);
      return;
      if (this.source == 1)
      {
        this.ISs.uf(0L);
        this.ISs.ue(2L);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(120991);
    super.onDestroy();
    this.wNi.removeAllListeners();
    this.wNi.removeAllUpdateListeners();
    this.wNi.cancel();
    ag.clear();
    Object localObject = com.tencent.mm.kernel.h.ag(PluginScanTranslation.class);
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.PluginScanTranslation");
      AppMethodBeat.o(120991);
      throw ((Throwable)localObject);
    }
    ((PluginScanTranslation)localObject).getTranslationRender().fEV();
    AppMethodBeat.o(120991);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(120988);
    p.k(paramKeyEvent, "event");
    if (paramInt == 4)
    {
      paramKeyEvent = com.tencent.mm.kernel.h.ag(PluginScanTranslation.class);
      if (paramKeyEvent == null)
      {
        paramKeyEvent = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.PluginScanTranslation");
        AppMethodBeat.o(120988);
        throw paramKeyEvent;
      }
      ((PluginScanTranslation)paramKeyEvent).getTranslationRender().fEV();
      if (this.lEK != 0)
      {
        if ((this.lEK != 1) && (this.lEK != 2) && (this.lEK != 3)) {
          break label141;
        }
        if (this.lEK == 1) {
          this.ISs.uj((int)(System.currentTimeMillis() - this.ISt[1]));
        }
        if (this.ISs.alV() != 0L) {
          this.ISs.bpa();
        }
      }
      fDX();
      label141:
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
    com.tencent.mm.kernel.h.aGY().b(294, (i)this);
    AppMethodBeat.o(120986);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(120985);
    super.onResume();
    Object localObject = getWindow();
    if (localObject != null) {
      ((Window)localObject).addFlags(2097280);
    }
    if (com.tencent.mm.compatible.util.d.qV(19)) {
      getWindow().addFlags(67109888);
    }
    for (;;)
    {
      localObject = getWindow();
      p.j(localObject, "window");
      localObject = ((Window)localObject).getDecorView();
      p.j(localObject, "window.decorView");
      ((View)localObject).setSystemUiVisibility(1280);
      f.cwA();
      com.tencent.mm.kernel.h.aGY().a(294, (i)this);
      Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo onResume curState: %d", new Object[] { Integer.valueOf(this.lEK) });
      if (this.lEK == -1) {
        dln();
      }
      AppMethodBeat.o(120985);
      return;
      getWindow().setFlags(1024, 1024);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(120996);
    Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo scanTranslate onSceneEnd errType %s, errCode %s, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.model.NetSceneNewOCRTranslation");
        AppMethodBeat.o(120996);
        throw paramString;
      }
      paramString = ((com.tencent.mm.plugin.scanner.model.k)paramq).fCL();
      if ((paramString != null) && (((com.tencent.mm.plugin.scanner.model.k)paramq).getSessionId() == this.ISo))
      {
        this.ISs.ui((int)(System.currentTimeMillis() - ((com.tencent.mm.plugin.scanner.model.k)paramq).fCN()));
        Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo scanTranslate onSceneEnd angle %f, translationInfos length %d", new Object[] { Float.valueOf(((com.tencent.mm.plugin.scanner.model.k)paramq).getAngle()), Integer.valueOf(paramString.size()) });
        if (paramString.size() > 0)
        {
          this.ISs.ug(1L);
          com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.h.ag(PluginScanTranslation.class);
          p.j(locala, "MMKernel.plugin(PluginScanTranslation::class.java)");
          ((PluginScanTranslation)locala).getTranslationRender().a(this.ISo, paramString, ((com.tencent.mm.plugin.scanner.model.k)paramq).getAngle(), this.ISi, (l.b)this);
          if (!Util.isNullOrNil(((com.tencent.mm.plugin.scanner.model.k)paramq).fCM()))
          {
            this.ISp = ((com.tencent.mm.plugin.scanner.model.k)paramq).fCM();
            AppMethodBeat.o(120996);
          }
        }
        else
        {
          this.ISs.uj((int)(System.currentTimeMillis() - this.ISt[1]));
          paramString = getResources().getString(a.g.scan_translating_no_result);
          p.j(paramString, "resources.getString(R.st…an_translating_no_result)");
          com.tencent.mm.ui.base.h.a((Context)getContext(), paramString, "", false, (DialogInterface.OnClickListener)new ScanTranslationResultUI.j(this));
          AppMethodBeat.o(120996);
        }
      }
    }
    else
    {
      dlq();
      this.ISs.ug(5L);
      this.ISs.uj((int)(System.currentTimeMillis() - this.ISt[1]));
      paramq = getResources().getString(a.g.scan_translating_no_result);
      p.j(paramq, "resources.getString(R.st…an_translating_no_result)");
      if (Util.isNullOrNil(paramString)) {
        break label428;
      }
    }
    label428:
    for (paramString = String.valueOf(paramString);; paramString = paramq)
    {
      com.tencent.mm.ui.base.h.a((Context)getContext(), paramString, "", false, (DialogInterface.OnClickListener)new ScanTranslationResultUI.k(this));
      AppMethodBeat.o(120996);
      return;
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(120990);
    super.onStop();
    com.tencent.mm.kernel.h.aGY().b(294, (i)this);
    AppMethodBeat.o(120990);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(ScanTranslationResultUI paramScanTranslationResultUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(120970);
      ScanTranslationResultUI.m(this.ISE);
      ScanTranslationResultUI.a(this.ISE, ScanTranslationResultUI.f(this.ISE));
      AppMethodBeat.o(120970);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$doTranslation$2", "Lcom/tencent/mm/plugin/scanner/util/ScanTranslateCdnService$ScanTranslateUploadCallback;", "onFinish", "", "mediaId", "", "result", "Lcom/tencent/mm/plugin/scanner/util/ScanTranslateCdnService$ScanTranslateUploadCallbackResult;", "scan-translation_release"})
  public static final class d
    implements k.a
  {
    d(String paramString) {}
    
    public final void a(String paramString, k.b paramb)
    {
      AppMethodBeat.i(211796);
      p.k(paramb, "result");
      if ((!Util.isNullOrNil(paramString)) && (p.h(paramString, ScanTranslationResultUI.n(this.ISE))))
      {
        ScanTranslationResultUI.e(this.ISE).uh((int)(System.currentTimeMillis() - ScanTranslationResultUI.o(this.ISE)[1]));
        Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo scanTranslate upload img cost %d, errCode: %d", new Object[] { Long.valueOf(ScanTranslationResultUI.e(this.ISE).alW()), Integer.valueOf(paramb.errCode) });
        ScanTranslationResultUI.e(this.ISE).zP(paramb.fileId);
        ScanTranslationResultUI.e(this.ISE).zQ(paramb.aeskey);
        switch (paramb.errCode)
        {
        default: 
          MMHandlerThread.postToMainThread((Runnable)new c(this));
          ScanTranslationResultUI.e(this.ISE).ug(3L);
        }
      }
      for (;;)
      {
        if ((ScanTranslationResultUI.a(this.ISE) == 1) && (ScanTranslationResultUI.r(this.ISE) != 0))
        {
          Log.i("delete tmp path %s", this.ISF);
          u.deleteFile(this.ISF);
        }
        AppMethodBeat.o(211796);
        return;
        if (!Util.isNullOrNil(new String[] { paramb.fileId, paramb.aeskey }))
        {
          Log.i("MicroMsg.ScanTranslationResultUI", "fileId %s", new Object[] { paramb.fileId });
          paramString = new com.tencent.mm.plugin.scanner.model.k(ScanTranslationResultUI.p(this.ISE), (int)u.bBQ(this.ISF), paramb.fileId, paramb.aeskey);
          com.tencent.mm.kernel.h.aGY().b((q)paramString);
        }
        else
        {
          MMHandlerThread.postToMainThread((Runnable)new a(this));
          ScanTranslationResultUI.e(this.ISE).ug(3L);
          continue;
          MMHandlerThread.postToMainThread((Runnable)new b(this));
          ScanTranslationResultUI.e(this.ISE).ug(3L);
        }
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ScanTranslationResultUI.d paramd) {}
      
      public final void run()
      {
        AppMethodBeat.i(211988);
        ScanTranslationResultUI.q(this.ISG.ISE);
        com.tencent.mm.ui.base.h.d((Context)this.ISG.ISE.getContext(), this.ISG.ISE.getResources().getString(a.g.scan_translating_no_result), this.ISG.ISE.getResources().getString(a.g.app_tip), (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(211878);
            ScanTranslationResultUI.j(this.ISH.ISG.ISE);
            AppMethodBeat.o(211878);
          }
        });
        AppMethodBeat.o(211988);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(ScanTranslationResultUI.d paramd) {}
      
      public final void run()
      {
        AppMethodBeat.i(211949);
        ScanTranslationResultUI.q(this.ISG.ISE);
        com.tencent.mm.ui.base.h.d((Context)this.ISG.ISE.getContext(), this.ISG.ISE.getResources().getString(a.g.file_explorer_cannot_open_file), this.ISG.ISE.getResources().getString(a.g.app_tip), (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(212040);
            ScanTranslationResultUI.j(this.ISI.ISG.ISE);
            AppMethodBeat.o(212040);
          }
        });
        AppMethodBeat.o(211949);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class c
      implements Runnable
    {
      c(ScanTranslationResultUI.d paramd) {}
      
      public final void run()
      {
        AppMethodBeat.i(211638);
        ScanTranslationResultUI.q(this.ISG.ISE);
        com.tencent.mm.ui.base.h.d((Context)this.ISG.ISE.getContext(), this.ISG.ISE.getResources().getString(a.g.file_explorer_cannot_open_file), this.ISG.ISE.getResources().getString(a.g.app_tip), (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(211557);
            ScanTranslationResultUI.j(this.ISJ.ISG.ISE);
            AppMethodBeat.o(211557);
          }
        });
        AppMethodBeat.o(211638);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(ScanTranslationResultUI paramScanTranslationResultUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120976);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (ScanTranslationResultUI.a(this.ISE) == 3)
      {
        if (ScanTranslationResultUI.b(this.ISE) != null) {
          ScanTranslationResultUI.a(this.ISE, ScanTranslationResultUI.b(this.ISE));
        }
        paramView = ScanTranslationResultUI.c(this.ISE);
        if ((paramView != null) && (n.L(paramView, "zh_CN", false) == true))
        {
          ScanTranslationResultUI.d(this.ISE).setImageResource(a.f.translation_result_chinese_highlighted);
          ScanTranslationResultUI.a(this.ISE, 2);
          ScanTranslationResultUI.e(this.ISE).uk(ScanTranslationResultUI.e(this.ISE).alX() + 1L);
        }
      }
      while (ScanTranslationResultUI.a(this.ISE) != 2) {
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(120976);
          return;
          ScanTranslationResultUI.d(this.ISE).setImageResource(a.f.translation_result_english_highlighted);
        }
      }
      if (ScanTranslationResultUI.f(this.ISE) != null) {
        ScanTranslationResultUI.a(this.ISE, ScanTranslationResultUI.f(this.ISE));
      }
      paramView = ScanTranslationResultUI.c(this.ISE);
      if ((paramView != null) && (n.L(paramView, "zh_CN", true) == true)) {
        ScanTranslationResultUI.d(this.ISE).setImageResource(a.c.translate_chinese_view_source_btn);
      }
      for (;;)
      {
        ScanTranslationResultUI.a(this.ISE, 3);
        break;
        ScanTranslationResultUI.d(this.ISE).setImageResource(a.c.translate_english_view_source_btn);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(ScanTranslationResultUI paramScanTranslationResultUI) {}
    
    /* Error */
    public final void onClick(View paramView)
    {
      // Byte code:
      //   0: ldc 41
      //   2: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 49	com/tencent/mm/hellhoundlib/b/b
      //   8: dup
      //   9: invokespecial 50	com/tencent/mm/hellhoundlib/b/b:<init>	()V
      //   12: astore_3
      //   13: aload_3
      //   14: aload_1
      //   15: invokevirtual 54	com/tencent/mm/hellhoundlib/b/b:bn	(Ljava/lang/Object;)V
      //   18: ldc 56
      //   20: ldc 57
      //   22: ldc 58
      //   24: ldc 59
      //   26: aload_0
      //   27: aload_3
      //   28: invokevirtual 63	com/tencent/mm/hellhoundlib/b/b:aFi	()[Ljava/lang/Object;
      //   31: invokestatic 69	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V
      //   34: aload_0
      //   35: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:ISE	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   38: invokestatic 73	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:a	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)I
      //   41: iconst_2
      //   42: if_icmpne +88 -> 130
      //   45: aload_0
      //   46: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:ISE	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   49: invokestatic 77	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:e	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)Lcom/tencent/mm/f/b/a/it;
      //   52: invokevirtual 83	com/tencent/mm/f/b/a/it:alZ	()Lcom/tencent/mm/f/b/a/it;
      //   55: pop
      //   56: aload_0
      //   57: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:ISE	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   60: invokestatic 87	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:g	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)Ljava/lang/String;
      //   63: astore_1
      //   64: aload_1
      //   65: ifnull +28 -> 93
      //   68: aload_0
      //   69: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:ISE	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   72: invokevirtual 91	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
      //   75: checkcast 93	android/content/Context
      //   78: aload_1
      //   79: new 10	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f$a
      //   82: dup
      //   83: aload_0
      //   84: invokespecial 96	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f$a:<init>	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f;)V
      //   87: checkcast 98	com/tencent/mm/platformtools/p$a
      //   90: invokestatic 103	com/tencent/mm/platformtools/p:a	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/platformtools/p$a;)V
      //   93: aload_0
      //   94: ldc 56
      //   96: ldc 57
      //   98: ldc 58
      //   100: ldc 59
      //   102: invokestatic 106	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   105: ldc 41
      //   107: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   110: return
      //   111: astore_1
      //   112: ldc 111
      //   114: aload_1
      //   115: checkcast 113	java/lang/Throwable
      //   118: ldc 115
      //   120: iconst_0
      //   121: anewarray 4	java/lang/Object
      //   124: invokestatic 121	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   127: goto -34 -> 93
      //   130: aload_0
      //   131: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:ISE	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   134: invokestatic 73	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:a	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)I
      //   137: iconst_3
      //   138: if_icmpne -45 -> 93
      //   141: aload_0
      //   142: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:ISE	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   145: invokestatic 77	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:e	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)Lcom/tencent/mm/f/b/a/it;
      //   148: invokevirtual 124	com/tencent/mm/f/b/a/it:alY	()Lcom/tencent/mm/f/b/a/it;
      //   151: pop
      //   152: aload_0
      //   153: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:ISE	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   156: invokestatic 127	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:h	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)I
      //   159: istore_2
      //   160: iload_2
      //   161: ifne +47 -> 208
      //   164: aload_0
      //   165: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:ISE	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   168: ldc 129
      //   170: invokestatic 135	com/tencent/mm/kernel/h:ag	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
      //   173: checkcast 129	com/tencent/mm/plugin/scanner/PluginScanTranslation
      //   176: ldc 137
      //   178: invokevirtual 141	com/tencent/mm/plugin/scanner/PluginScanTranslation:genTranslationResultImgPath	(Ljava/lang/String;)Ljava/lang/String;
      //   181: invokestatic 144	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:a	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;Ljava/lang/String;)V
      //   184: aload_0
      //   185: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:ISE	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   188: invokestatic 148	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:f	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)Landroid/graphics/Bitmap;
      //   191: bipush 80
      //   193: getstatic 154	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
      //   196: aload_0
      //   197: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:ISE	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   200: invokestatic 156	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:i	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)Ljava/lang/String;
      //   203: iconst_0
      //   204: invokestatic 162	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
      //   207: pop
      //   208: aload_0
      //   209: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:ISE	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   212: invokestatic 156	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:i	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)Ljava/lang/String;
      //   215: astore_1
      //   216: aload_1
      //   217: ifnull -124 -> 93
      //   220: aload_0
      //   221: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:ISE	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   224: invokevirtual 91	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
      //   227: checkcast 93	android/content/Context
      //   230: aload_1
      //   231: new 12	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f$b
      //   234: dup
      //   235: aload_0
      //   236: invokespecial 163	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f$b:<init>	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f;)V
      //   239: checkcast 98	com/tencent/mm/platformtools/p$a
      //   242: invokestatic 103	com/tencent/mm/platformtools/p:a	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/platformtools/p$a;)V
      //   245: goto -152 -> 93
      //   248: astore_1
      //   249: ldc 111
      //   251: aload_1
      //   252: checkcast 113	java/lang/Throwable
      //   255: ldc 165
      //   257: iconst_0
      //   258: anewarray 4	java/lang/Object
      //   261: invokestatic 121	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   264: goto -171 -> 93
      //   267: astore_1
      //   268: ldc 111
      //   270: aload_1
      //   271: checkcast 113	java/lang/Throwable
      //   274: ldc 167
      //   276: iconst_0
      //   277: anewarray 4	java/lang/Object
      //   280: invokestatic 121	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   283: goto -75 -> 208
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	286	0	this	f
      //   0	286	1	paramView	View
      //   159	2	2	i	int
      //   12	16	3	localb	com.tencent.mm.hellhoundlib.b.b
      // Exception table:
      //   from	to	target	type
      //   45	64	111	java/lang/Exception
      //   68	93	111	java/lang/Exception
      //   141	160	248	java/lang/Exception
      //   164	208	248	java/lang/Exception
      //   208	216	248	java/lang/Exception
      //   220	245	248	java/lang/Exception
      //   268	283	248	java/lang/Exception
      //   164	208	267	java/io/IOException
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$init$2$1$1", "Lcom/tencent/mm/platformtools/ExportFileUtil$ExportResultCallback;", "onExportFail", "", "srcPath", "", "destPath", "onExportSuccess", "scan-translation_release"})
    public static final class a
      implements p.a
    {
      a(ScanTranslationResultUI.f paramf) {}
      
      public final void bT(String paramString1, String paramString2)
      {
        AppMethodBeat.i(211571);
        p.k(paramString1, "srcPath");
        p.k(paramString2, "destPath");
        paramString1 = this.ISK.ISE.getContext();
        if (paramString1 == null)
        {
          paramString1 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(211571);
          throw paramString1;
        }
        com.tencent.mm.ui.widget.snackbar.b.r((Activity)paramString1, this.ISK.ISE.getResources().getString(a.g.scan_translation_save_to_gallery_success));
        AppMethodBeat.o(211571);
      }
      
      public final void bU(String paramString1, String paramString2)
      {
        AppMethodBeat.i(211573);
        p.k(paramString1, "srcPath");
        p.k(paramString2, "destPath");
        paramString1 = this.ISK.ISE.getContext();
        if (paramString1 == null)
        {
          paramString1 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(211573);
          throw paramString1;
        }
        com.tencent.mm.ui.widget.snackbar.b.r((Activity)paramString1, this.ISK.ISE.getResources().getString(a.g.save_image_err));
        AppMethodBeat.o(211573);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$init$2$2$1", "Lcom/tencent/mm/platformtools/ExportFileUtil$ExportResultCallback;", "onExportFail", "", "srcPath", "", "destPath", "onExportSuccess", "scan-translation_release"})
    public static final class b
      implements p.a
    {
      b(ScanTranslationResultUI.f paramf) {}
      
      public final void bT(String paramString1, String paramString2)
      {
        AppMethodBeat.i(211891);
        p.k(paramString1, "srcPath");
        p.k(paramString2, "destPath");
        paramString1 = this.ISK.ISE.getContext();
        if (paramString1 == null)
        {
          paramString1 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(211891);
          throw paramString1;
        }
        com.tencent.mm.ui.widget.snackbar.b.r((Activity)paramString1, this.ISK.ISE.getResources().getString(a.g.scan_translation_save_to_gallery_success));
        AppMethodBeat.o(211891);
      }
      
      public final void bU(String paramString1, String paramString2)
      {
        AppMethodBeat.i(211892);
        p.k(paramString1, "srcPath");
        p.k(paramString2, "destPath");
        paramString1 = this.ISK.ISE.getContext();
        if (paramString1 == null)
        {
          paramString1 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(211892);
          throw paramString1;
        }
        com.tencent.mm.ui.widget.snackbar.b.r((Activity)paramString1, this.ISK.ISE.getResources().getString(a.g.save_image_err));
        AppMethodBeat.o(211892);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationResultUI
 * JD-Core Version:    0.7.0.1
 */