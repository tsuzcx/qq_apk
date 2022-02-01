package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
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
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SpinnerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.b.a.go;
import com.tencent.mm.g.c.fx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.scanner.PluginScanTranslation;
import com.tencent.mm.plugin.scanner.model.ai;
import com.tencent.mm.plugin.scanner.model.aj;
import com.tencent.mm.plugin.scanner.model.m;
import com.tencent.mm.plugin.scanner.util.k;
import com.tencent.mm.plugin.scanner.util.k.b;
import com.tencent.mm.plugin.scanner.util.p.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.List;
import kotlin.l;
import kotlin.n.n;

@com.tencent.mm.ui.base.a(3)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/scanner/util/ScanTranslationRender$TranslationRenderCallback;", "()V", "bottomBgLayer", "Landroid/view/View;", "closeButton", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "curMediaId", "", "curSessionId", "", "curState", "gestureGallery", "Lcom/tencent/mm/ui/tools/MMGestureGallery;", "originalBitmap", "Landroid/graphics/Bitmap;", "originalPath", "reportData", "Lcom/tencent/mm/autogen/mmdata/rpt/OCRTranslateReportStruct;", "rootContainer", "rotateDegree", "saveContainer", "saveImgBtn", "scanLine", "Landroid/widget/ImageView;", "scanLineAnimator", "Landroid/animation/ValueAnimator;", "screenHeight", "source", "startTimeArray", "", "targetLang", "topBgLayer", "translateBitmap", "translateImageAdapter", "Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$TranslateImageAdapter;", "translationPath", "viewSourceBtn", "configNavigationBar", "", "doTranslation", "drawTranslationResult", "session", "newBitmap", "enterFullScreen", "enterPreviewStatus", "enterTranslateFinishStatus", "enterTranslateStatus", "finishActivity", "getLayoutId", "goBack", "init", "initData", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "resetTargetLang", "setPreviewBitmap", "bitmap", "startScanLineAnimation", "stopScanLineAnimation", "Companion", "TranslateImageAdapter", "scan-translation_release"})
public final class ScanTranslationResultUI
  extends MMActivity
  implements i, k.b
{
  public static final ScanTranslationResultUI.a CNc;
  private WeImageView AmD;
  private View CMC;
  private ImageView CMD;
  private View CME;
  private View CMF;
  private View CMG;
  private Bitmap CMI;
  private Bitmap CMJ;
  private String CMK;
  private MMGestureGallery CMM;
  private int CMO;
  private String CMP;
  private final go CMS;
  private final long[] CMT;
  private b CNb;
  private int iOu;
  private int ijt;
  private View jWj;
  private String jrK;
  private int mEY;
  private int source;
  private ImageView tgP;
  private ValueAnimator tgS;
  private String xCU;
  
  static
  {
    AppMethodBeat.i(121001);
    CNc = new ScanTranslationResultUI.a((byte)0);
    AppMethodBeat.o(121001);
  }
  
  public ScanTranslationResultUI()
  {
    AppMethodBeat.i(121000);
    this.tgS = new ValueAnimator();
    this.iOu = -1;
    this.CMS = new go();
    this.CMT = new long[2];
    AppMethodBeat.o(121000);
  }
  
  private final void an(Bitmap paramBitmap)
  {
    AppMethodBeat.i(120997);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(120997);
      return;
    }
    Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo setImageBitmap size: %s, %s", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
    b localb = this.CNb;
    if (localb != null) {
      localb.setImageBitmap(paramBitmap);
    }
    paramBitmap = this.CNb;
    if (paramBitmap != null)
    {
      paramBitmap.notifyDataSetChanged();
      AppMethodBeat.o(120997);
      return;
    }
    AppMethodBeat.o(120997);
  }
  
  private final void cWg()
  {
    AppMethodBeat.i(120992);
    this.CMS.qz(2L);
    this.CMO = ((int)(z.aTY().hashCode() + System.currentTimeMillis() & 0xFFFFFFFF));
    this.iOu = 1;
    eQP();
    Object localObject;
    if (n.I(this.CMP, "zh_CN", true))
    {
      localObject = this.CMD;
      if (localObject == null) {
        kotlin.g.b.p.btv("viewSourceBtn");
      }
      ((ImageView)localObject).setImageResource(2131691667);
    }
    for (;;)
    {
      localObject = this.CMF;
      if (localObject == null) {
        kotlin.g.b.p.btv("topBgLayer");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.CMG;
      if (localObject == null) {
        kotlin.g.b.p.btv("bottomBgLayer");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.CMC;
      if (localObject == null) {
        kotlin.g.b.p.btv("saveContainer");
      }
      ((View)localObject).setVisibility(8);
      localObject = this.tgP;
      if (localObject == null) {
        kotlin.g.b.p.btv("scanLine");
      }
      ((ImageView)localObject).setVisibility(0);
      localObject = this.CMM;
      if (localObject == null) {
        kotlin.g.b.p.btv("gestureGallery");
      }
      ((MMGestureGallery)localObject).setVisibility(0);
      cWi();
      eQW();
      AppMethodBeat.o(120992);
      return;
      localObject = this.CMD;
      if (localObject == null) {
        kotlin.g.b.p.btv("viewSourceBtn");
      }
      ((ImageView)localObject).setImageResource(2131691670);
    }
  }
  
  private final void cWi()
  {
    AppMethodBeat.i(120994);
    this.tgS.setRepeatMode(1);
    this.tgS.setRepeatCount(-1);
    this.tgS.start();
    AppMethodBeat.o(120994);
  }
  
  private final void cWj()
  {
    AppMethodBeat.i(120995);
    this.tgS.setRepeatMode(1);
    this.tgS.setRepeatCount(0);
    this.tgS.end();
    AppMethodBeat.o(120995);
  }
  
  private final void eQP()
  {
    AppMethodBeat.i(120984);
    n.I(LocaleUtil.getApplicationLanguage(), "zh_CN", true);
    this.CMP = LocaleUtil.getCurrentLanguage((Context)getContext());
    Log.i("MicroMsg.ScanTranslationResultUI", "targetLang %s", new Object[] { this.CMP });
    AppMethodBeat.o(120984);
  }
  
  private final void eQV()
  {
    AppMethodBeat.i(120993);
    Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo enterTranslateFinishStatus");
    this.iOu = 3;
    Object localObject = this.CMC;
    if (localObject == null) {
      kotlin.g.b.p.btv("saveContainer");
    }
    ((View)localObject).setVisibility(0);
    if (n.I(this.CMP, "zh_CN", true))
    {
      localObject = this.CMD;
      if (localObject == null) {
        kotlin.g.b.p.btv("viewSourceBtn");
      }
      ((ImageView)localObject).setImageResource(2131235352);
    }
    for (;;)
    {
      localObject = this.tgP;
      if (localObject == null) {
        kotlin.g.b.p.btv("scanLine");
      }
      ((ImageView)localObject).setVisibility(8);
      cWj();
      if ((this.source != 1) || (!Util.isNullOrNil(this.CMK))) {
        break label289;
      }
      this.CMK = ((PluginScanTranslation)g.ah(PluginScanTranslation.class)).genTranslationResultImgPath("jpg");
      try
      {
        BitmapUtil.saveBitmapToImage(this.CMJ, 80, Bitmap.CompressFormat.JPEG, this.CMK, false);
        localObject = new aj();
        ((aj)localObject).field_originMD5 = MD5Util.getMD5String(kotlin.g.b.p.I(this.jrK, Long.valueOf(s.boX(this.jrK))));
        ((aj)localObject).field_resultFile = this.CMK;
        Log.i("MicroMsg.ScanTranslationResultUI", "insert translate result %s", new Object[] { this.CMK });
        com.tencent.mm.kernel.b.a locala = g.ah(PluginScanTranslation.class);
        kotlin.g.b.p.g(locala, "MMKernel.plugin(PluginScanTranslation::class.java)");
        ((PluginScanTranslation)locala).getTranslationResultStorage().a((aj)localObject);
        AppMethodBeat.o(120993);
        return;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.ScanTranslationResultUI", (Throwable)localIOException, "save translate result file error", new Object[0]);
      }
      localObject = this.CMD;
      if (localObject == null) {
        kotlin.g.b.p.btv("viewSourceBtn");
      }
      ((ImageView)localObject).setImageResource(2131235354);
    }
    label289:
    AppMethodBeat.o(120993);
  }
  
  private final void eQW()
  {
    AppMethodBeat.i(120987);
    for (;;)
    {
      Object localObject3;
      long l;
      try
      {
        Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation");
        if ((!Util.isNullOrNil(this.jrK)) && (this.CMI != null))
        {
          this.xCU = com.tencent.mm.plugin.scanner.util.p.aMv(this.jrK);
          localObject3 = this.jrK;
          if (this.source == 0)
          {
            l = System.currentTimeMillis();
            BitmapUtil.saveBitmapToImage(this.CMI, 80, Bitmap.CompressFormat.JPEG, this.jrK, false);
            Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation save img cost %d", new Object[] { Integer.valueOf((int)(System.currentTimeMillis() - l)) });
            Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation fileSize %d", new Object[] { Long.valueOf(s.boW(this.jrK)) });
            localObject1 = localObject3;
            this.CMT[1] = System.currentTimeMillis();
            localObject3 = g.ah(com.tencent.mm.plugin.scanner.f.class);
            kotlin.g.b.p.g(localObject3, "MMKernel.plugin(IPluginScanner::class.java)");
            ((com.tencent.mm.plugin.scanner.f)localObject3).getScanCdnService().a(this.xCU, (String)localObject1, com.tencent.mm.i.a.MediaType_IMAGE, (com.tencent.mm.plugin.scanner.util.p.a)new d(this, (String)localObject1));
            AppMethodBeat.o(120987);
            return;
          }
          Object localObject1 = localObject3;
          if (this.source != 1) {
            continue;
          }
          localObject1 = MD5Util.getMD5String(kotlin.g.b.p.I(this.jrK, Long.valueOf(s.boX(this.jrK))));
          com.tencent.mm.kernel.b.a locala = g.ah(PluginScanTranslation.class);
          kotlin.g.b.p.g(locala, "MMKernel.plugin(PluginScanTranslation::class.java)");
          localObject1 = ((PluginScanTranslation)locala).getTranslationResultStorage().aMG((String)localObject1);
          if (localObject1 == null) {
            break label356;
          }
          Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation already has translation result");
          this.CMK = ((fx)localObject1).field_resultFile;
          this.CMJ = BitmapUtil.decodeFile(this.CMK, new BitmapFactory.Options());
          if (this.CMJ == null) {
            break label348;
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
      label348:
      Log.w("MicroMsg.ScanTranslationResultUI", "can not find old translation result!");
      label356:
      Object localObject2 = localObject3;
      if (this.ijt != 0)
      {
        l = System.currentTimeMillis();
        localObject2 = ((com.tencent.mm.plugin.scanner.f)g.ah(com.tencent.mm.plugin.scanner.f.class)).genScanTmpImgPath("jpg");
        BitmapUtil.saveBitmapToImage(this.CMI, 80, Bitmap.CompressFormat.JPEG, (String)localObject2, false);
        Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation save img cost %d", new Object[] { Integer.valueOf((int)(System.currentTimeMillis() - l)) });
        Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation fileSize %d", new Object[] { Long.valueOf(s.boW((String)localObject2)) });
      }
    }
  }
  
  private final void eQX()
  {
    AppMethodBeat.i(120989);
    finish();
    overridePendingTransition(2130771986, 2130771986);
    AppMethodBeat.o(120989);
  }
  
  public final void d(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(120998);
    if ((paramBitmap != null) && (paramInt == this.CMO))
    {
      this.CMS.qC((int)(System.currentTimeMillis() - this.CMT[1]));
      this.CMJ = paramBitmap;
      eQV();
      an(this.CMJ);
    }
    AppMethodBeat.o(120998);
  }
  
  public final int getLayoutId()
  {
    return 2131495192;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(120999);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 561) && (paramInt2 == -1))
    {
      paramIntent = com.tencent.mm.ui.tools.a.i((Context)getContext(), paramIntent, com.tencent.mm.plugin.image.d.aSY());
      Log.i("MicroMsg.ScanTranslationResultUI", "select: [%s]", new Object[] { paramIntent });
      if (!Util.isNullOrNil(paramIntent))
      {
        this.jrK = paramIntent;
        this.source = 1;
        this.CMS.qx(2L);
        Exif localExif = Exif.fromFile(paramIntent);
        kotlin.g.b.p.g(localExif, "Exif.fromFile(filePath)");
        this.ijt = localExif.getOrientationInDegree();
        Log.i("MicroMsg.ScanTranslationResultUI", "degree %s", new Object[] { Integer.valueOf(this.ijt) });
        paramIntent = BitmapUtil.decodeFileWithSample(paramIntent);
        if (paramIntent != null)
        {
          this.CMI = BitmapUtil.rotate(paramIntent, this.ijt);
          cWg();
          an(this.CMI);
        }
      }
    }
    AppMethodBeat.o(120999);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(120983);
    super.onCreate(paramBundle);
    getController().setNavigationbarColor(getResources().getColor(2131099836));
    paramBundle = findViewById(2131307160);
    kotlin.g.b.p.g(paramBundle, "findViewById(R.id.root_container)");
    this.jWj = paramBundle;
    paramBundle = findViewById(2131309404);
    kotlin.g.b.p.g(paramBundle, "findViewById(R.id.translate_gallery_view)");
    this.CMM = ((MMGestureGallery)paramBundle);
    this.CNb = new b();
    paramBundle = this.CMM;
    if (paramBundle == null) {
      kotlin.g.b.p.btv("gestureGallery");
    }
    paramBundle.setAdapter((SpinnerAdapter)this.CNb);
    paramBundle = findViewById(2131307217);
    kotlin.g.b.p.g(paramBundle, "findViewById(R.id.save_translate_container)");
    this.CMC = paramBundle;
    paramBundle = this.CMC;
    if (paramBundle == null) {
      kotlin.g.b.p.btv("saveContainer");
    }
    paramBundle = paramBundle.findViewById(2131309409);
    kotlin.g.b.p.g(paramBundle, "saveContainer.findViewBy…ranslate_view_source_btn)");
    this.CMD = ((ImageView)paramBundle);
    paramBundle = this.CMD;
    if (paramBundle == null) {
      kotlin.g.b.p.btv("viewSourceBtn");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new e(this));
    paramBundle = findViewById(2131309408);
    kotlin.g.b.p.g(paramBundle, "findViewById(R.id.translate_top_bg)");
    this.CMF = paramBundle;
    paramBundle = findViewById(2131309401);
    kotlin.g.b.p.g(paramBundle, "findViewById(R.id.translate_bottom_bg)");
    this.CMG = paramBundle;
    hideTitleView();
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    paramBundle = findViewById(2131307243);
    kotlin.g.b.p.g(paramBundle, "findViewById(R.id.scan_line)");
    this.tgP = ((ImageView)paramBundle);
    paramBundle = this.CMC;
    if (paramBundle == null) {
      kotlin.g.b.p.btv("saveContainer");
    }
    paramBundle = paramBundle.findViewById(2131309403);
    kotlin.g.b.p.g(paramBundle, "saveContainer.findViewBy…d.translate_download_btn)");
    this.CME = paramBundle;
    paramBundle = this.CME;
    if (paramBundle == null) {
      kotlin.g.b.p.btv("saveImgBtn");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new f(this));
    paramBundle = findViewById(2131298771);
    kotlin.g.b.p.g(paramBundle, "findViewById(R.id.close_button)");
    this.AmD = ((WeImageView)paramBundle);
    paramBundle = this.AmD;
    if (paramBundle == null) {
      kotlin.g.b.p.btv("closeButton");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new ScanTranslationResultUI.g(this));
    this.mEY = com.tencent.mm.cb.a.jo((Context)getContext());
    this.tgS.setFloatValues(new float[] { 0.0F, 1.0F });
    this.tgS.addListener((Animator.AnimatorListener)new h(this));
    this.tgS.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new i(this));
    paramBundle = this.CMC;
    if (paramBundle == null) {
      kotlin.g.b.p.btv("saveContainer");
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
    paramBundle.bottomMargin = (ao.aD((Context)getContext()) + i);
    Object localObject = this.CMC;
    if (localObject == null) {
      kotlin.g.b.p.btv("saveContainer");
    }
    ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)paramBundle);
    this.tgS.setDuration(5000L);
    com.tencent.mm.ui.base.b.a((Activity)this, null);
    eQP();
    localObject = getIntent().getStringExtra("key_translation_origin_image_path");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.jrK = paramBundle;
    this.source = getIntent().getIntExtra("key_translation_source", 0);
    if (this.source == 0)
    {
      this.CMS.qy(getIntent().getLongExtra("key_translation_capture_time", 0L));
      this.CMS.qx(1L);
    }
    for (;;)
    {
      Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo initData originPath: %s, source: %d", new Object[] { this.jrK, Integer.valueOf(this.source) });
      paramBundle = this.jrK;
      if (paramBundle == null) {
        kotlin.g.b.p.hyc();
      }
      this.CMI = ai.aMD(paramBundle);
      if (this.CMI != null)
      {
        paramBundle = this.CMI;
        if (paramBundle == null) {
          kotlin.g.b.p.hyc();
        }
        if (!paramBundle.isRecycled())
        {
          paramBundle = this.CMI;
          if (paramBundle == null) {
            kotlin.g.b.p.hyc();
          }
          i = paramBundle.getWidth();
          paramBundle = this.CMI;
          if (paramBundle == null) {
            kotlin.g.b.p.hyc();
          }
          Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo initData bitmap width: %d, height: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramBundle.getHeight()) });
        }
      }
      an(this.CMI);
      AppMethodBeat.o(120983);
      return;
      if (this.source == 1)
      {
        this.CMS.qy(0L);
        this.CMS.qx(2L);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(120991);
    super.onDestroy();
    this.tgS.removeAllListeners();
    this.tgS.removeAllUpdateListeners();
    this.tgS.cancel();
    ai.clear();
    Object localObject = g.ah(PluginScanTranslation.class);
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.PluginScanTranslation");
      AppMethodBeat.o(120991);
      throw ((Throwable)localObject);
    }
    ((PluginScanTranslation)localObject).getTranslationRender().eRW();
    AppMethodBeat.o(120991);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(120988);
    kotlin.g.b.p.h(paramKeyEvent, "event");
    if (paramInt == 4)
    {
      paramKeyEvent = g.ah(PluginScanTranslation.class);
      if (paramKeyEvent == null)
      {
        paramKeyEvent = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.PluginScanTranslation");
        AppMethodBeat.o(120988);
        throw paramKeyEvent;
      }
      ((PluginScanTranslation)paramKeyEvent).getTranslationRender().eRW();
      if (this.iOu != 0)
      {
        if ((this.iOu != 1) && (this.iOu != 2) && (this.iOu != 3)) {
          break label141;
        }
        if (this.iOu == 1) {
          this.CMS.qC((int)(System.currentTimeMillis() - this.CMT[1]));
        }
        if (this.CMS.agO() != 0L) {
          this.CMS.bfK();
        }
      }
      eQX();
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
    g.azz().b(294, (i)this);
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
    if (com.tencent.mm.compatible.util.d.oD(19)) {
      getWindow().addFlags(67109888);
    }
    for (;;)
    {
      localObject = getWindow();
      kotlin.g.b.p.g(localObject, "window");
      localObject = ((Window)localObject).getDecorView();
      kotlin.g.b.p.g(localObject, "window.decorView");
      ((View)localObject).setSystemUiVisibility(1280);
      com.tencent.mm.plugin.ball.f.f.cji();
      g.azz().a(294, (i)this);
      Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo onResume curState: %d", new Object[] { Integer.valueOf(this.iOu) });
      if (this.iOu == -1) {
        cWg();
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
      paramString = ((m)paramq).ePQ();
      if ((paramString != null) && (((m)paramq).getSessionId() == this.CMO))
      {
        this.CMS.qB((int)(System.currentTimeMillis() - ((m)paramq).ePS()));
        Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo scanTranslate onSceneEnd angle %f, translationInfos length %d", new Object[] { Float.valueOf(((m)paramq).getAngle()), Integer.valueOf(paramString.size()) });
        if (paramString.size() > 0)
        {
          this.CMS.qz(1L);
          com.tencent.mm.kernel.b.a locala = g.ah(PluginScanTranslation.class);
          kotlin.g.b.p.g(locala, "MMKernel.plugin(PluginScanTranslation::class.java)");
          ((PluginScanTranslation)locala).getTranslationRender().a(this.CMO, paramString, ((m)paramq).getAngle(), this.CMI, (k.b)this);
          if (!Util.isNullOrNil(((m)paramq).ePR()))
          {
            this.CMP = ((m)paramq).ePR();
            AppMethodBeat.o(120996);
          }
        }
        else
        {
          this.CMS.qC((int)(System.currentTimeMillis() - this.CMT[1]));
          paramString = getResources().getString(2131764991);
          kotlin.g.b.p.g(paramString, "resources.getString(R.st…an_translating_no_result)");
          h.a((Context)getContext(), paramString, "", false, (DialogInterface.OnClickListener)new ScanTranslationResultUI.j(this));
          AppMethodBeat.o(120996);
        }
      }
    }
    else
    {
      cWj();
      this.CMS.qz(5L);
      this.CMS.qC((int)(System.currentTimeMillis() - this.CMT[1]));
      paramq = getResources().getString(2131764991);
      kotlin.g.b.p.g(paramq, "resources.getString(R.st…an_translating_no_result)");
      if (Util.isNullOrNil(paramString)) {
        break label428;
      }
    }
    label428:
    for (paramString = String.valueOf(paramString);; paramString = paramq)
    {
      h.a((Context)getContext(), paramString, "", false, (DialogInterface.OnClickListener)new ScanTranslationResultUI.k(this));
      AppMethodBeat.o(120996);
      return;
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(120990);
    super.onStop();
    g.azz().b(294, (i)this);
    AppMethodBeat.o(120990);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$TranslateImageAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)V", "bitmap", "Landroid/graphics/Bitmap;", "getCount", "", "getItem", "", "i", "getItemId", "", "getView", "Landroid/view/View;", "view", "viewGroup", "Landroid/view/ViewGroup;", "setImageBitmap", "", "scan-translation_release"})
  final class b
    extends BaseAdapter
  {
    private Bitmap bitmap;
    
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
      kotlin.g.b.p.h(paramViewGroup, "viewGroup");
      if (paramView == null)
      {
        paramView = new MultiTouchImageView((Context)this.CNd.getContext(), 0, 0, (byte)0);
        paramView.setLayoutParams((ViewGroup.LayoutParams)new Gallery.LayoutParams(-1, -1));
      }
      for (;;)
      {
        if (this.bitmap != null)
        {
          paramView.setImageBitmap(this.bitmap);
          paramViewGroup = this.bitmap;
          if (paramViewGroup == null) {
            kotlin.g.b.p.hyc();
          }
          paramInt = paramViewGroup.getWidth();
          paramViewGroup = this.bitmap;
          if (paramViewGroup == null) {
            kotlin.g.b.p.hyc();
          }
          paramView.cN(paramInt, paramViewGroup.getHeight());
          paramView.gKy();
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
      kotlin.g.b.p.h(paramBitmap, "bitmap");
      this.bitmap = paramBitmap;
      AppMethodBeat.o(120969);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(ScanTranslationResultUI paramScanTranslationResultUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(120970);
      ScanTranslationResultUI.m(this.CNd);
      ScanTranslationResultUI.a(this.CNd, ScanTranslationResultUI.f(this.CNd));
      AppMethodBeat.o(120970);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "mediaId", "", "kotlin.jvm.PlatformType", "result", "Lcom/tencent/mm/plugin/scanner/util/ScannerCdnService$ScannerUploadCallbackResult;", "Lcom/tencent/mm/plugin/scanner/util/ScannerCdnService;", "onFinish"})
  static final class d
    implements com.tencent.mm.plugin.scanner.util.p.a
  {
    d(ScanTranslationResultUI paramScanTranslationResultUI, String paramString) {}
    
    public final void a(String paramString, p.b paramb)
    {
      AppMethodBeat.i(120975);
      if ((!Util.isNullOrNil(paramString)) && (kotlin.g.b.p.j(paramString, ScanTranslationResultUI.n(this.CNd))))
      {
        ScanTranslationResultUI.e(this.CNd).qA((int)(System.currentTimeMillis() - ScanTranslationResultUI.o(this.CNd)[1]));
        Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo scanTranslate upload img cost %d, errCode: %d", new Object[] { Long.valueOf(ScanTranslationResultUI.e(this.CNd).agP()), Integer.valueOf(paramb.errCode) });
        ScanTranslationResultUI.e(this.CNd).uq(paramb.fileId);
        ScanTranslationResultUI.e(this.CNd).ur(paramb.aeskey);
        switch (paramb.errCode)
        {
        }
      }
      for (;;)
      {
        if ((ScanTranslationResultUI.a(this.CNd) == 1) && (ScanTranslationResultUI.r(this.CNd) != 0))
        {
          Log.i("delete tmp path %s", this.CNe);
          s.deleteFile(this.CNe);
        }
        AppMethodBeat.o(120975);
        return;
        if (!Util.isNullOrNil(new String[] { paramb.fileId, paramb.aeskey }))
        {
          Log.i("MicroMsg.ScanTranslationResultUI", "fileId %s", new Object[] { paramb.fileId });
          paramString = new m(ScanTranslationResultUI.p(this.CNd), (int)s.boW(this.CNe), paramb.fileId, paramb.aeskey);
          g.azz().b((q)paramString);
        }
        else
        {
          MMHandlerThread.postToMainThread((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(120972);
              ScanTranslationResultUI.q(this.CNf.CNd);
              h.d((Context)this.CNf.CNd.getContext(), this.CNf.CNd.getResources().getString(2131764991), this.CNf.CNd.getResources().getString(2131755998), (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(120971);
                  ScanTranslationResultUI.j(this.CNg.CNf.CNd);
                  AppMethodBeat.o(120971);
                }
              });
              AppMethodBeat.o(120972);
            }
          });
          ScanTranslationResultUI.e(this.CNd).qz(3L);
          continue;
          MMHandlerThread.postToMainThread((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(120974);
              ScanTranslationResultUI.q(this.CNf.CNd);
              h.d((Context)this.CNf.CNd.getContext(), this.CNf.CNd.getResources().getString(2131759383), this.CNf.CNd.getResources().getString(2131755998), (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(120973);
                  ScanTranslationResultUI.j(this.CNh.CNf.CNd);
                  AppMethodBeat.o(120973);
                }
              });
              AppMethodBeat.o(120974);
            }
          });
          ScanTranslationResultUI.e(this.CNd).qz(3L);
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(ScanTranslationResultUI paramScanTranslationResultUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120976);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (ScanTranslationResultUI.a(this.CNd) == 3)
      {
        if (ScanTranslationResultUI.b(this.CNd) != null) {
          ScanTranslationResultUI.a(this.CNd, ScanTranslationResultUI.b(this.CNd));
        }
        paramView = ScanTranslationResultUI.c(this.CNd);
        if ((paramView != null) && (n.I(paramView, "zh_CN", false) == true))
        {
          ScanTranslationResultUI.d(this.CNd).setImageResource(2131691668);
          ScanTranslationResultUI.a(this.CNd, 2);
          ScanTranslationResultUI.e(this.CNd).qD(ScanTranslationResultUI.e(this.CNd).agQ() + 1L);
        }
      }
      while (ScanTranslationResultUI.a(this.CNd) != 2) {
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(120976);
          return;
          ScanTranslationResultUI.d(this.CNd).setImageResource(2131691671);
        }
      }
      if (ScanTranslationResultUI.f(this.CNd) != null) {
        ScanTranslationResultUI.a(this.CNd, ScanTranslationResultUI.f(this.CNd));
      }
      paramView = ScanTranslationResultUI.c(this.CNd);
      if ((paramView != null) && (n.I(paramView, "zh_CN", true) == true)) {
        ScanTranslationResultUI.d(this.CNd).setImageResource(2131235352);
      }
      for (;;)
      {
        ScanTranslationResultUI.a(this.CNd, 3);
        break;
        ScanTranslationResultUI.d(this.CNd).setImageResource(2131235354);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
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
      //   15: invokevirtual 54	com/tencent/mm/hellhoundlib/b/b:bm	(Ljava/lang/Object;)V
      //   18: ldc 56
      //   20: ldc 57
      //   22: ldc 58
      //   24: ldc 59
      //   26: aload_0
      //   27: aload_3
      //   28: invokevirtual 63	com/tencent/mm/hellhoundlib/b/b:axR	()[Ljava/lang/Object;
      //   31: invokestatic 69	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V
      //   34: aload_0
      //   35: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:CNd	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   38: invokestatic 73	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:a	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)I
      //   41: iconst_2
      //   42: if_icmpne +88 -> 130
      //   45: aload_0
      //   46: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:CNd	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   49: invokestatic 77	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:e	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)Lcom/tencent/mm/g/b/a/go;
      //   52: invokevirtual 83	com/tencent/mm/g/b/a/go:agS	()Lcom/tencent/mm/g/b/a/go;
      //   55: pop
      //   56: aload_0
      //   57: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:CNd	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   60: invokestatic 87	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:g	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)Ljava/lang/String;
      //   63: astore_1
      //   64: aload_1
      //   65: ifnull +28 -> 93
      //   68: aload_0
      //   69: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:CNd	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   72: invokevirtual 91	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:getContext	()Landroid/support/v7/app/AppCompatActivity;
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
      //   131: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:CNd	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   134: invokestatic 73	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:a	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)I
      //   137: iconst_3
      //   138: if_icmpne -45 -> 93
      //   141: aload_0
      //   142: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:CNd	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   145: invokestatic 77	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:e	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)Lcom/tencent/mm/g/b/a/go;
      //   148: invokevirtual 124	com/tencent/mm/g/b/a/go:agR	()Lcom/tencent/mm/g/b/a/go;
      //   151: pop
      //   152: aload_0
      //   153: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:CNd	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   156: invokestatic 127	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:h	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)I
      //   159: istore_2
      //   160: iload_2
      //   161: ifne +47 -> 208
      //   164: aload_0
      //   165: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:CNd	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   168: ldc 129
      //   170: invokestatic 135	com/tencent/mm/kernel/g:ah	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
      //   173: checkcast 129	com/tencent/mm/plugin/scanner/PluginScanTranslation
      //   176: ldc 137
      //   178: invokevirtual 141	com/tencent/mm/plugin/scanner/PluginScanTranslation:genTranslationResultImgPath	(Ljava/lang/String;)Ljava/lang/String;
      //   181: invokestatic 144	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:a	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;Ljava/lang/String;)V
      //   184: aload_0
      //   185: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:CNd	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   188: invokestatic 148	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:f	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)Landroid/graphics/Bitmap;
      //   191: bipush 80
      //   193: getstatic 154	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
      //   196: aload_0
      //   197: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:CNd	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   200: invokestatic 156	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:i	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)Ljava/lang/String;
      //   203: iconst_0
      //   204: invokestatic 162	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
      //   207: pop
      //   208: aload_0
      //   209: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:CNd	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   212: invokestatic 156	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:i	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)Ljava/lang/String;
      //   215: astore_1
      //   216: aload_1
      //   217: ifnull -124 -> 93
      //   220: aload_0
      //   221: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:CNd	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   224: invokevirtual 91	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:getContext	()Landroid/support/v7/app/AppCompatActivity;
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
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$init$2$1$1", "Lcom/tencent/mm/platformtools/ExportFileUtil$ExportResultCallback;", "onExportFail", "", "srcPath", "", "destPath", "onExportSuccess", "scan-translation_release"})
    public static final class a
      implements com.tencent.mm.platformtools.p.a
    {
      a(ScanTranslationResultUI.f paramf) {}
      
      public final void bP(String paramString1, String paramString2)
      {
        AppMethodBeat.i(200126);
        kotlin.g.b.p.h(paramString1, "srcPath");
        kotlin.g.b.p.h(paramString2, "destPath");
        paramString1 = this.CNi.CNd.getContext();
        if (paramString1 == null)
        {
          paramString1 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(200126);
          throw paramString1;
        }
        com.tencent.mm.ui.widget.snackbar.b.r((Activity)paramString1, this.CNi.CNd.getResources().getString(2131764994));
        AppMethodBeat.o(200126);
      }
      
      public final void bQ(String paramString1, String paramString2)
      {
        AppMethodBeat.i(200127);
        kotlin.g.b.p.h(paramString1, "srcPath");
        kotlin.g.b.p.h(paramString2, "destPath");
        paramString1 = this.CNi.CNd.getContext();
        if (paramString1 == null)
        {
          paramString1 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(200127);
          throw paramString1;
        }
        com.tencent.mm.ui.widget.snackbar.b.r((Activity)paramString1, this.CNi.CNd.getResources().getString(2131764864));
        AppMethodBeat.o(200127);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$init$2$2$1", "Lcom/tencent/mm/platformtools/ExportFileUtil$ExportResultCallback;", "onExportFail", "", "srcPath", "", "destPath", "onExportSuccess", "scan-translation_release"})
    public static final class b
      implements com.tencent.mm.platformtools.p.a
    {
      b(ScanTranslationResultUI.f paramf) {}
      
      public final void bP(String paramString1, String paramString2)
      {
        AppMethodBeat.i(200128);
        kotlin.g.b.p.h(paramString1, "srcPath");
        kotlin.g.b.p.h(paramString2, "destPath");
        paramString1 = this.CNi.CNd.getContext();
        if (paramString1 == null)
        {
          paramString1 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(200128);
          throw paramString1;
        }
        com.tencent.mm.ui.widget.snackbar.b.r((Activity)paramString1, this.CNi.CNd.getResources().getString(2131764994));
        AppMethodBeat.o(200128);
      }
      
      public final void bQ(String paramString1, String paramString2)
      {
        AppMethodBeat.i(200129);
        kotlin.g.b.p.h(paramString1, "srcPath");
        kotlin.g.b.p.h(paramString2, "destPath");
        paramString1 = this.CNi.CNd.getContext();
        if (paramString1 == null)
        {
          paramString1 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(200129);
          throw paramString1;
        }
        com.tencent.mm.ui.widget.snackbar.b.r((Activity)paramString1, this.CNi.CNd.getResources().getString(2131764864));
        AppMethodBeat.o(200129);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$init$4", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "scan-translation_release"})
  public static final class h
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(162356);
      ScanTranslationResultUI.k(this.CNd).setAlpha(0.0F);
      AppMethodBeat.o(162356);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(162355);
      ScanTranslationResultUI.k(this.CNd).setAlpha(0.0F);
      AppMethodBeat.o(162355);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class i
    implements ValueAnimator.AnimatorUpdateListener
  {
    i(ScanTranslationResultUI paramScanTranslationResultUI) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(162357);
      kotlin.g.b.p.g(paramValueAnimator, "valueAnimator");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new kotlin.t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(162357);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      if (f <= 0.1F) {
        ScanTranslationResultUI.k(this.CNd).setAlpha(f * 10.0F);
      }
      for (;;)
      {
        ScanTranslationResultUI.k(this.CNd).setTranslationY(f * (ScanTranslationResultUI.l(this.CNd) - ScanTranslationResultUI.k(this.CNd).getHeight()));
        AppMethodBeat.o(162357);
        return;
        if (f >= 0.9F) {
          ScanTranslationResultUI.k(this.CNd).setAlpha((1.0F - f) * 10.0F);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationResultUI
 * JD-Core Version:    0.7.0.1
 */