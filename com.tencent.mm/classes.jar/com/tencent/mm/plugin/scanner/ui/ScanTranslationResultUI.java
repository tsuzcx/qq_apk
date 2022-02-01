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
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SpinnerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.b.a.be;
import com.tencent.mm.g.c.fb;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.scanner.PluginScanTranslation;
import com.tencent.mm.plugin.scanner.model.aa;
import com.tencent.mm.plugin.scanner.model.z;
import com.tencent.mm.plugin.scanner.util.j;
import com.tencent.mm.plugin.scanner.util.j.b;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.scanner.util.m.a;
import com.tencent.mm.plugin.scanner.util.m.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import d.v;
import java.io.IOException;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/scanner/util/ScanTranslationRender$TranslationRenderCallback;", "()V", "bottomBgLayer", "Landroid/view/View;", "closeButton", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "curMediaId", "", "curSessionId", "", "curState", "gestureGallery", "Lcom/tencent/mm/ui/tools/MMGestureGallery;", "originalBitmap", "Landroid/graphics/Bitmap;", "originalPath", "reportData", "Lcom/tencent/mm/autogen/mmdata/rpt/OCRTranslateReportStruct;", "rootContainer", "rotateDegree", "saveContainer", "saveImgBtn", "scanLine", "Landroid/widget/ImageView;", "scanLineAnimator", "Landroid/animation/ValueAnimator;", "screenHeight", "source", "startTimeArray", "", "targetLang", "topBgLayer", "translateBitmap", "translateImageAdapter", "Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$TranslateImageAdapter;", "translationPath", "viewSourceBtn", "configNavigationBar", "", "doTranslation", "drawTranslationResult", "session", "newBitmap", "enterFullScreen", "enterPreviewStatus", "enterTranslateFinishStatus", "enterTranslateStatus", "finishActivity", "getLayoutId", "goBack", "init", "initData", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "resetTargetLang", "setPreviewBitmap", "bitmap", "startScanLineAnimation", "stopScanLineAnimation", "Companion", "TranslateImageAdapter", "scan-translation_release"})
public final class ScanTranslationResultUI
  extends MMActivity
  implements com.tencent.mm.al.g, j.b
{
  public static final ScanTranslationResultUI.a vUD;
  private int dep;
  private int gXt;
  private int guD;
  private String hzF;
  private View ics;
  private int kvo;
  private ImageView qgw;
  private ValueAnimator qgz;
  private String rTR;
  private WeImageView vUB;
  private ScanTranslationResultUI.b vUC;
  private View vUc;
  private ImageView vUd;
  private View vUe;
  private View vUf;
  private View vUg;
  private Bitmap vUi;
  private Bitmap vUj;
  private String vUk;
  private MMGestureGallery vUm;
  private int vUo;
  private String vUp;
  private final be vUs;
  private final long[] vUt;
  
  static
  {
    AppMethodBeat.i(121001);
    vUD = new ScanTranslationResultUI.a((byte)0);
    AppMethodBeat.o(121001);
  }
  
  public ScanTranslationResultUI()
  {
    AppMethodBeat.i(121000);
    this.qgz = new ValueAnimator();
    this.gXt = -1;
    this.vUs = new be();
    this.vUt = new long[2];
    AppMethodBeat.o(121000);
  }
  
  private final void ab(Bitmap paramBitmap)
  {
    AppMethodBeat.i(120997);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(120997);
      return;
    }
    ad.i("MicroMsg.ScanTranslationResultUI", "alvinluo setImageBitmap size: %s, %s", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
    ScanTranslationResultUI.b localb = this.vUC;
    if (localb != null) {
      localb.setImageBitmap(paramBitmap);
    }
    paramBitmap = this.vUC;
    if (paramBitmap != null)
    {
      paramBitmap.notifyDataSetChanged();
      AppMethodBeat.o(120997);
      return;
    }
    AppMethodBeat.o(120997);
  }
  
  private final void cjk()
  {
    AppMethodBeat.i(120992);
    this.vUs.eP(2L);
    this.vUo = ((int)(u.aqG().hashCode() + System.currentTimeMillis() & 0xFFFFFFFF));
    this.gXt = 1;
    dmi();
    Object localObject;
    if (d.n.n.I(this.vUp, "zh_CN", true))
    {
      localObject = this.vUd;
      if (localObject == null) {
        k.aPZ("viewSourceBtn");
      }
      ((ImageView)localObject).setImageResource(2131691335);
    }
    for (;;)
    {
      localObject = this.vUf;
      if (localObject == null) {
        k.aPZ("topBgLayer");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.vUg;
      if (localObject == null) {
        k.aPZ("bottomBgLayer");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.vUc;
      if (localObject == null) {
        k.aPZ("saveContainer");
      }
      ((View)localObject).setVisibility(8);
      localObject = this.qgw;
      if (localObject == null) {
        k.aPZ("scanLine");
      }
      ((ImageView)localObject).setVisibility(0);
      localObject = this.vUm;
      if (localObject == null) {
        k.aPZ("gestureGallery");
      }
      ((MMGestureGallery)localObject).setVisibility(0);
      cjm();
      dmp();
      AppMethodBeat.o(120992);
      return;
      localObject = this.vUd;
      if (localObject == null) {
        k.aPZ("viewSourceBtn");
      }
      ((ImageView)localObject).setImageResource(2131691338);
    }
  }
  
  private final void cjm()
  {
    AppMethodBeat.i(120994);
    this.qgz.setRepeatMode(1);
    this.qgz.setRepeatCount(-1);
    this.qgz.start();
    AppMethodBeat.o(120994);
  }
  
  private final void cjn()
  {
    AppMethodBeat.i(120995);
    this.qgz.setRepeatMode(1);
    this.qgz.setRepeatCount(0);
    this.qgz.end();
    AppMethodBeat.o(120995);
  }
  
  private final void dmi()
  {
    AppMethodBeat.i(120984);
    d.n.n.I(ac.eFu(), "zh_CN", true);
    this.vUp = ac.ir((Context)getContext());
    ad.i("MicroMsg.ScanTranslationResultUI", "targetLang %s", new Object[] { this.vUp });
    AppMethodBeat.o(120984);
  }
  
  private final void dmo()
  {
    AppMethodBeat.i(120993);
    ad.i("MicroMsg.ScanTranslationResultUI", "alvinluo enterTranslateFinishStatus");
    this.gXt = 3;
    Object localObject = this.vUc;
    if (localObject == null) {
      k.aPZ("saveContainer");
    }
    ((View)localObject).setVisibility(0);
    if (d.n.n.I(this.vUp, "zh_CN", true))
    {
      localObject = this.vUd;
      if (localObject == null) {
        k.aPZ("viewSourceBtn");
      }
      ((ImageView)localObject).setImageResource(2131234422);
    }
    for (;;)
    {
      localObject = this.qgw;
      if (localObject == null) {
        k.aPZ("scanLine");
      }
      ((ImageView)localObject).setVisibility(8);
      cjn();
      if ((this.dep != 1) || (!bt.isNullOrNil(this.vUk))) {
        break label289;
      }
      this.vUk = ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).genTranslationResultImgPath("jpg");
      try
      {
        com.tencent.mm.sdk.platformtools.f.a(this.vUj, 80, Bitmap.CompressFormat.JPEG, this.vUk, false);
        localObject = new aa();
        ((aa)localObject).field_originMD5 = com.tencent.mm.sdk.platformtools.ai.du(k.C(this.hzF, Long.valueOf(i.aMO(this.hzF))));
        ((aa)localObject).field_resultFile = this.vUk;
        ad.i("MicroMsg.ScanTranslationResultUI", "insert translate result %s", new Object[] { this.vUk });
        com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.ad(PluginScanTranslation.class);
        k.g(locala, "MMKernel.plugin(PluginScanTranslation::class.java)");
        ((PluginScanTranslation)locala).getTranslationResultStorage().a((aa)localObject);
        AppMethodBeat.o(120993);
        return;
      }
      catch (IOException localIOException)
      {
        ad.printErrStackTrace("MicroMsg.ScanTranslationResultUI", (Throwable)localIOException, "save translate result file error", new Object[0]);
      }
      localObject = this.vUd;
      if (localObject == null) {
        k.aPZ("viewSourceBtn");
      }
      ((ImageView)localObject).setImageResource(2131234424);
    }
    label289:
    AppMethodBeat.o(120993);
  }
  
  private final void dmp()
  {
    AppMethodBeat.i(120987);
    for (;;)
    {
      Object localObject3;
      long l;
      try
      {
        ad.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation");
        if ((!bt.isNullOrNil(this.hzF)) && (this.vUi != null))
        {
          this.rTR = m.amP(this.hzF);
          localObject3 = this.hzF;
          if (this.dep == 0)
          {
            l = System.currentTimeMillis();
            com.tencent.mm.sdk.platformtools.f.a(this.vUi, 80, Bitmap.CompressFormat.JPEG, this.hzF, false);
            ad.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation save img cost %d", new Object[] { Integer.valueOf((int)(System.currentTimeMillis() - l)) });
            ad.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation fileSize %d", new Object[] { Long.valueOf(i.aMN(this.hzF)) });
            localObject1 = localObject3;
            this.vUt[1] = System.currentTimeMillis();
            localObject3 = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.scanner.d.class);
            k.g(localObject3, "MMKernel.plugin(IPluginScanner::class.java)");
            ((com.tencent.mm.plugin.scanner.d)localObject3).getScanCdnService().a(this.rTR, (String)localObject1, com.tencent.mm.i.a.MediaType_IMAGE, (m.a)new d(this, (String)localObject1));
            AppMethodBeat.o(120987);
            return;
          }
          Object localObject1 = localObject3;
          if (this.dep != 1) {
            continue;
          }
          localObject1 = com.tencent.mm.sdk.platformtools.ai.du(k.C(this.hzF, Long.valueOf(i.aMO(this.hzF))));
          com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.ad(PluginScanTranslation.class);
          k.g(locala, "MMKernel.plugin(PluginScanTranslation::class.java)");
          localObject1 = ((PluginScanTranslation)locala).getTranslationResultStorage().amC((String)localObject1);
          if (localObject1 == null) {
            break label356;
          }
          ad.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation already has translation result");
          this.vUk = ((fb)localObject1).field_resultFile;
          this.vUj = com.tencent.mm.sdk.platformtools.f.decodeFile(this.vUk, new BitmapFactory.Options());
          if (this.vUj == null) {
            break label348;
          }
          aq.n((Runnable)new c(this), 500L);
          AppMethodBeat.o(120987);
        }
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.ScanTranslationResultUI", (Throwable)localException, "", new Object[0]);
        AppMethodBeat.o(120987);
        return;
      }
      label348:
      ad.w("MicroMsg.ScanTranslationResultUI", "can not find old translation result!");
      label356:
      Object localObject2 = localObject3;
      if (this.guD != 0)
      {
        l = System.currentTimeMillis();
        localObject2 = ((com.tencent.mm.plugin.scanner.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.scanner.d.class)).genScanTmpImgPath("jpg");
        com.tencent.mm.sdk.platformtools.f.a(this.vUi, 80, Bitmap.CompressFormat.JPEG, (String)localObject2, false);
        ad.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation save img cost %d", new Object[] { Integer.valueOf((int)(System.currentTimeMillis() - l)) });
        ad.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation fileSize %d", new Object[] { Long.valueOf(i.aMN((String)localObject2)) });
      }
    }
  }
  
  private final void dmq()
  {
    AppMethodBeat.i(120989);
    finish();
    overridePendingTransition(2130771986, 2130771986);
    AppMethodBeat.o(120989);
  }
  
  public final void c(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(120998);
    if ((paramBitmap != null) && (paramInt == this.vUo))
    {
      this.vUs.eS((int)(System.currentTimeMillis() - this.vUt[1]));
      this.vUj = paramBitmap;
      dmo();
      ab(this.vUj);
    }
    AppMethodBeat.o(120998);
  }
  
  public final int getLayoutId()
  {
    return 2131494570;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(120999);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 561) && (paramInt2 == -1))
    {
      paramIntent = com.tencent.mm.ui.tools.a.i((Context)getContext(), paramIntent, com.tencent.mm.plugin.image.d.apW());
      ad.i("MicroMsg.ScanTranslationResultUI", "select: [%s]", new Object[] { paramIntent });
      if (!bt.isNullOrNil(paramIntent))
      {
        this.hzF = paramIntent;
        this.dep = 1;
        this.vUs.eN(2L);
        Exif localExif = Exif.fromFile(paramIntent);
        k.g(localExif, "Exif.fromFile(filePath)");
        this.guD = localExif.getOrientationInDegree();
        ad.i("MicroMsg.ScanTranslationResultUI", "degree %s", new Object[] { Integer.valueOf(this.guD) });
        paramIntent = com.tencent.mm.sdk.platformtools.f.aFj(paramIntent);
        if (paramIntent != null)
        {
          this.vUi = com.tencent.mm.sdk.platformtools.f.a(paramIntent, this.guD);
          cjk();
          ab(this.vUi);
        }
      }
    }
    AppMethodBeat.o(120999);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(120983);
    super.onCreate(paramBundle);
    getController().setNavigationbarColor(getResources().getColor(2131099820));
    paramBundle = findViewById(2131304241);
    k.g(paramBundle, "findViewById(R.id.root_container)");
    this.ics = paramBundle;
    paramBundle = findViewById(2131306074);
    k.g(paramBundle, "findViewById(R.id.translate_gallery_view)");
    this.vUm = ((MMGestureGallery)paramBundle);
    this.vUC = new ScanTranslationResultUI.b(this);
    paramBundle = this.vUm;
    if (paramBundle == null) {
      k.aPZ("gestureGallery");
    }
    paramBundle.setAdapter((SpinnerAdapter)this.vUC);
    paramBundle = findViewById(2131304289);
    k.g(paramBundle, "findViewById(R.id.save_translate_container)");
    this.vUc = paramBundle;
    paramBundle = this.vUc;
    if (paramBundle == null) {
      k.aPZ("saveContainer");
    }
    paramBundle = paramBundle.findViewById(2131306078);
    k.g(paramBundle, "saveContainer.findViewBy…ranslate_view_source_btn)");
    this.vUd = ((ImageView)paramBundle);
    paramBundle = this.vUd;
    if (paramBundle == null) {
      k.aPZ("viewSourceBtn");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new e(this));
    paramBundle = findViewById(2131306077);
    k.g(paramBundle, "findViewById(R.id.translate_top_bg)");
    this.vUf = paramBundle;
    paramBundle = findViewById(2131306071);
    k.g(paramBundle, "findViewById(R.id.translate_bottom_bg)");
    this.vUg = paramBundle;
    hideTitleView();
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    paramBundle = findViewById(2131304314);
    k.g(paramBundle, "findViewById(R.id.scan_line)");
    this.qgw = ((ImageView)paramBundle);
    paramBundle = this.vUc;
    if (paramBundle == null) {
      k.aPZ("saveContainer");
    }
    paramBundle = paramBundle.findViewById(2131306073);
    k.g(paramBundle, "saveContainer.findViewBy…d.translate_download_btn)");
    this.vUe = paramBundle;
    paramBundle = this.vUe;
    if (paramBundle == null) {
      k.aPZ("saveImgBtn");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new f(this));
    paramBundle = findViewById(2131298365);
    k.g(paramBundle, "findViewById(R.id.close_button)");
    this.vUB = ((WeImageView)paramBundle);
    paramBundle = this.vUB;
    if (paramBundle == null) {
      k.aPZ("closeButton");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new ScanTranslationResultUI.g(this));
    this.kvo = com.tencent.mm.cd.a.hW((Context)getContext());
    this.qgz.setFloatValues(new float[] { 0.0F, 1.0F });
    this.qgz.addListener((Animator.AnimatorListener)new ScanTranslationResultUI.h(this));
    this.qgz.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new ScanTranslationResultUI.i(this));
    paramBundle = this.vUc;
    if (paramBundle == null) {
      k.aPZ("saveContainer");
    }
    paramBundle = paramBundle.getLayoutParams();
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(120983);
      throw paramBundle;
    }
    paramBundle = (RelativeLayout.LayoutParams)paramBundle;
    int i = paramBundle.bottomMargin;
    paramBundle.bottomMargin = (com.tencent.mm.ui.ai.eb((Context)getContext()) + i);
    Object localObject = this.vUc;
    if (localObject == null) {
      k.aPZ("saveContainer");
    }
    ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)paramBundle);
    this.qgz.setDuration(5000L);
    com.tencent.mm.ui.base.b.a((Activity)this, null);
    dmi();
    localObject = getIntent().getStringExtra("key_translation_origin_image_path");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.hzF = paramBundle;
    this.dep = getIntent().getIntExtra("key_translation_source", 0);
    if (this.dep == 0)
    {
      this.vUs.eO(getIntent().getLongExtra("key_translation_capture_time", 0L));
      this.vUs.eN(1L);
    }
    for (;;)
    {
      ad.i("MicroMsg.ScanTranslationResultUI", "alvinluo initData originPath: %s, source: %d", new Object[] { this.hzF, Integer.valueOf(this.dep) });
      paramBundle = this.hzF;
      if (paramBundle == null) {
        k.fvU();
      }
      this.vUi = z.amA(paramBundle);
      if (this.vUi != null)
      {
        paramBundle = this.vUi;
        if (paramBundle == null) {
          k.fvU();
        }
        if (!paramBundle.isRecycled())
        {
          paramBundle = this.vUi;
          if (paramBundle == null) {
            k.fvU();
          }
          i = paramBundle.getWidth();
          paramBundle = this.vUi;
          if (paramBundle == null) {
            k.fvU();
          }
          ad.i("MicroMsg.ScanTranslationResultUI", "alvinluo initData bitmap width: %d, height: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramBundle.getHeight()) });
        }
      }
      ab(this.vUi);
      AppMethodBeat.o(120983);
      return;
      if (this.dep == 1)
      {
        this.vUs.eO(0L);
        this.vUs.eN(2L);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(120991);
    super.onDestroy();
    this.qgz.removeAllListeners();
    this.qgz.removeAllUpdateListeners();
    this.qgz.cancel();
    z.clear();
    Object localObject = com.tencent.mm.kernel.g.ad(PluginScanTranslation.class);
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.PluginScanTranslation");
      AppMethodBeat.o(120991);
      throw ((Throwable)localObject);
    }
    ((PluginScanTranslation)localObject).getTranslationRender().dnk();
    AppMethodBeat.o(120991);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(120988);
    k.h(paramKeyEvent, "event");
    if (paramInt == 4)
    {
      paramKeyEvent = com.tencent.mm.kernel.g.ad(PluginScanTranslation.class);
      if (paramKeyEvent == null)
      {
        paramKeyEvent = new v("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.PluginScanTranslation");
        AppMethodBeat.o(120988);
        throw paramKeyEvent;
      }
      ((PluginScanTranslation)paramKeyEvent).getTranslationRender().dnk();
      if (this.gXt != 0)
      {
        if ((this.gXt != 1) && (this.gXt != 2) && (this.gXt != 3)) {
          break label141;
        }
        if (this.gXt == 1) {
          this.vUs.eS((int)(System.currentTimeMillis() - this.vUt[1]));
        }
        if (this.vUs.Qp() != 0L) {
          this.vUs.aBj();
        }
      }
      dmq();
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
    com.tencent.mm.kernel.g.aeS().b(294, (com.tencent.mm.al.g)this);
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
    if (com.tencent.mm.compatible.util.d.lf(19)) {
      getWindow().addFlags(67109888);
    }
    for (;;)
    {
      localObject = getWindow();
      k.g(localObject, "window");
      localObject = ((Window)localObject).getDecorView();
      k.g(localObject, "window.decorView");
      ((View)localObject).setSystemUiVisibility(1280);
      com.tencent.mm.plugin.ball.f.f.bAp();
      com.tencent.mm.kernel.g.aeS().a(294, (com.tencent.mm.al.g)this);
      ad.i("MicroMsg.ScanTranslationResultUI", "alvinluo onResume curState: %d", new Object[] { Integer.valueOf(this.gXt) });
      if (this.gXt == -1) {
        cjk();
      }
      AppMethodBeat.o(120985);
      return;
      getWindow().setFlags(1024, 1024);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(120996);
    ad.i("MicroMsg.ScanTranslationResultUI", "alvinluo scanTranslate onSceneEnd errType %s, errCode %s, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.model.NetSceneNewOCRTranslation");
        AppMethodBeat.o(120996);
        throw paramString;
      }
      paramString = ((com.tencent.mm.plugin.scanner.model.h)paramn).dls();
      if ((paramString != null) && (((com.tencent.mm.plugin.scanner.model.h)paramn).getSessionId() == this.vUo))
      {
        this.vUs.eR((int)(System.currentTimeMillis() - ((com.tencent.mm.plugin.scanner.model.h)paramn).dlu()));
        ad.i("MicroMsg.ScanTranslationResultUI", "alvinluo scanTranslate onSceneEnd angle %f, translationInfos length %d", new Object[] { Float.valueOf(((com.tencent.mm.plugin.scanner.model.h)paramn).dlr()), Integer.valueOf(paramString.size()) });
        if (paramString.size() > 0)
        {
          this.vUs.eP(1L);
          com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.ad(PluginScanTranslation.class);
          k.g(locala, "MMKernel.plugin(PluginScanTranslation::class.java)");
          ((PluginScanTranslation)locala).getTranslationRender().a(this.vUo, paramString, ((com.tencent.mm.plugin.scanner.model.h)paramn).dlr(), this.vUi, (j.b)this);
          if (!bt.isNullOrNil(((com.tencent.mm.plugin.scanner.model.h)paramn).dlt()))
          {
            this.vUp = ((com.tencent.mm.plugin.scanner.model.h)paramn).dlt();
            AppMethodBeat.o(120996);
          }
        }
        else
        {
          this.vUs.eS((int)(System.currentTimeMillis() - this.vUt[1]));
          paramString = getResources().getString(2131762880);
          com.tencent.mm.ui.base.h.a((Context)getContext(), paramString, "", false, (DialogInterface.OnClickListener)new ScanTranslationResultUI.j(this));
          AppMethodBeat.o(120996);
        }
      }
    }
    else
    {
      cjn();
      this.vUs.eP(5L);
      this.vUs.eS((int)(System.currentTimeMillis() - this.vUt[1]));
      paramn = getResources().getString(2131762880);
      if (bt.isNullOrNil(paramString)) {
        break label408;
      }
    }
    for (;;)
    {
      com.tencent.mm.ui.base.h.a((Context)getContext(), paramString, "", false, (DialogInterface.OnClickListener)new ScanTranslationResultUI.k(this));
      AppMethodBeat.o(120996);
      return;
      label408:
      paramString = paramn;
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(120990);
    super.onStop();
    com.tencent.mm.kernel.g.aeS().b(294, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(120990);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(ScanTranslationResultUI paramScanTranslationResultUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(120970);
      ScanTranslationResultUI.m(this.vUE);
      ScanTranslationResultUI.a(this.vUE, ScanTranslationResultUI.f(this.vUE));
      AppMethodBeat.o(120970);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "mediaId", "", "kotlin.jvm.PlatformType", "result", "Lcom/tencent/mm/plugin/scanner/util/ScannerCdnService$ScannerUploadCallbackResult;", "Lcom/tencent/mm/plugin/scanner/util/ScannerCdnService;", "onFinish"})
  static final class d
    implements m.a
  {
    d(ScanTranslationResultUI paramScanTranslationResultUI, String paramString) {}
    
    public final void a(String paramString, m.b paramb)
    {
      AppMethodBeat.i(120975);
      if ((!bt.isNullOrNil(paramString)) && (k.g(paramString, ScanTranslationResultUI.n(this.vUE))))
      {
        ScanTranslationResultUI.e(this.vUE).eQ((int)(System.currentTimeMillis() - ScanTranslationResultUI.o(this.vUE)[1]));
        ad.i("MicroMsg.ScanTranslationResultUI", "alvinluo scanTranslate upload img cost %d, errCode: %d", new Object[] { Long.valueOf(ScanTranslationResultUI.e(this.vUE).Qq()), Integer.valueOf(paramb.errCode) });
        switch (paramb.errCode)
        {
        }
      }
      for (;;)
      {
        if ((ScanTranslationResultUI.a(this.vUE) == 1) && (ScanTranslationResultUI.r(this.vUE) != 0))
        {
          ad.i("delete tmp path %s", this.vUF);
          i.deleteFile(this.vUF);
        }
        AppMethodBeat.o(120975);
        return;
        if (!bt.T(new String[] { paramb.fileId, paramb.aeskey }))
        {
          ad.i("MicroMsg.ScanTranslationResultUI", "fileId %s", new Object[] { paramb.fileId });
          paramString = new com.tencent.mm.plugin.scanner.model.h(ScanTranslationResultUI.p(this.vUE), (int)i.aMN(this.vUF), paramb.fileId, paramb.aeskey);
          com.tencent.mm.kernel.g.aeS().b((com.tencent.mm.al.n)paramString);
        }
        else
        {
          aq.f((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(120972);
              ScanTranslationResultUI.q(this.vUG.vUE);
              com.tencent.mm.ui.base.h.d((Context)this.vUG.vUE.getContext(), this.vUG.vUE.getResources().getString(2131762880), this.vUG.vUE.getResources().getString(2131755906), (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(120971);
                  ScanTranslationResultUI.j(this.vUH.vUG.vUE);
                  AppMethodBeat.o(120971);
                }
              });
              AppMethodBeat.o(120972);
            }
          });
          ScanTranslationResultUI.e(this.vUE).eP(3L);
          continue;
          aq.f((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(120974);
              ScanTranslationResultUI.q(this.vUG.vUE);
              com.tencent.mm.ui.base.h.d((Context)this.vUG.vUE.getContext(), this.vUG.vUE.getResources().getString(2131759055), this.vUG.vUE.getResources().getString(2131755906), (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(120973);
                  ScanTranslationResultUI.j(this.vUI.vUG.vUE);
                  AppMethodBeat.o(120973);
                }
              });
              AppMethodBeat.o(120974);
            }
          });
          ScanTranslationResultUI.e(this.vUE).eP(3L);
        }
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(ScanTranslationResultUI paramScanTranslationResultUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120976);
      if (ScanTranslationResultUI.a(this.vUE) == 3)
      {
        if (ScanTranslationResultUI.b(this.vUE) != null) {
          ScanTranslationResultUI.a(this.vUE, ScanTranslationResultUI.b(this.vUE));
        }
        paramView = ScanTranslationResultUI.c(this.vUE);
        if ((paramView != null) && (d.n.n.I(paramView, "zh_CN", false) == true)) {
          ScanTranslationResultUI.d(this.vUE).setImageResource(2131691336);
        }
        for (;;)
        {
          ScanTranslationResultUI.a(this.vUE, 2);
          ScanTranslationResultUI.e(this.vUE).eT(ScanTranslationResultUI.e(this.vUE).Qr() + 1L);
          AppMethodBeat.o(120976);
          return;
          ScanTranslationResultUI.d(this.vUE).setImageResource(2131691339);
        }
      }
      if (ScanTranslationResultUI.a(this.vUE) == 2)
      {
        if (ScanTranslationResultUI.f(this.vUE) != null) {
          ScanTranslationResultUI.a(this.vUE, ScanTranslationResultUI.f(this.vUE));
        }
        paramView = ScanTranslationResultUI.c(this.vUE);
        if ((paramView == null) || (d.n.n.I(paramView, "zh_CN", true) != true)) {
          break label211;
        }
        ScanTranslationResultUI.d(this.vUE).setImageResource(2131234422);
      }
      for (;;)
      {
        ScanTranslationResultUI.a(this.vUE, 3);
        AppMethodBeat.o(120976);
        return;
        label211:
        ScanTranslationResultUI.d(this.vUE).setImageResource(2131234424);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
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
      //   5: aload_0
      //   6: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:vUE	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   9: invokestatic 51	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:a	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)I
      //   12: iconst_2
      //   13: if_icmpne +85 -> 98
      //   16: aload_0
      //   17: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:vUE	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   20: invokestatic 55	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:e	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)Lcom/tencent/mm/g/b/a/be;
      //   23: invokevirtual 61	com/tencent/mm/g/b/a/be:Qt	()Lcom/tencent/mm/g/b/a/be;
      //   26: pop
      //   27: aload_0
      //   28: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:vUE	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   31: invokestatic 65	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:g	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)Ljava/lang/String;
      //   34: astore_1
      //   35: aload_1
      //   36: ifnull +34 -> 70
      //   39: aload_0
      //   40: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:vUE	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   43: invokevirtual 69	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:getContext	()Landroid/support/v7/app/AppCompatActivity;
      //   46: checkcast 71	android/content/Context
      //   49: aload_1
      //   50: new 10	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f$a
      //   53: dup
      //   54: aload_0
      //   55: invokespecial 74	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f$a:<init>	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f;)V
      //   58: checkcast 76	com/tencent/mm/platformtools/p$a
      //   61: invokestatic 81	com/tencent/mm/platformtools/p:a	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/platformtools/p$a;)V
      //   64: ldc 41
      //   66: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   69: return
      //   70: ldc 41
      //   72: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   75: return
      //   76: astore_1
      //   77: ldc 86
      //   79: aload_1
      //   80: checkcast 88	java/lang/Throwable
      //   83: ldc 90
      //   85: iconst_0
      //   86: anewarray 4	java/lang/Object
      //   89: invokestatic 96	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   92: ldc 41
      //   94: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   97: return
      //   98: aload_0
      //   99: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:vUE	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   102: invokestatic 51	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:a	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)I
      //   105: iconst_3
      //   106: if_icmpne +129 -> 235
      //   109: aload_0
      //   110: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:vUE	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   113: invokestatic 55	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:e	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)Lcom/tencent/mm/g/b/a/be;
      //   116: invokevirtual 99	com/tencent/mm/g/b/a/be:Qs	()Lcom/tencent/mm/g/b/a/be;
      //   119: pop
      //   120: aload_0
      //   121: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:vUE	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   124: invokestatic 102	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:h	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)I
      //   127: istore_2
      //   128: iload_2
      //   129: ifne +47 -> 176
      //   132: aload_0
      //   133: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:vUE	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   136: ldc 104
      //   138: invokestatic 110	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
      //   141: checkcast 104	com/tencent/mm/plugin/scanner/PluginScanTranslation
      //   144: ldc 112
      //   146: invokevirtual 116	com/tencent/mm/plugin/scanner/PluginScanTranslation:genTranslationResultImgPath	(Ljava/lang/String;)Ljava/lang/String;
      //   149: invokestatic 119	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:a	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;Ljava/lang/String;)V
      //   152: aload_0
      //   153: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:vUE	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   156: invokestatic 123	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:f	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)Landroid/graphics/Bitmap;
      //   159: bipush 80
      //   161: getstatic 129	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
      //   164: aload_0
      //   165: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:vUE	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   168: invokestatic 131	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:i	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)Ljava/lang/String;
      //   171: iconst_0
      //   172: invokestatic 136	com/tencent/mm/sdk/platformtools/f:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
      //   175: pop
      //   176: aload_0
      //   177: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:vUE	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   180: invokestatic 131	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:i	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)Ljava/lang/String;
      //   183: astore_1
      //   184: aload_1
      //   185: ifnull +75 -> 260
      //   188: aload_0
      //   189: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:vUE	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   192: invokevirtual 69	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:getContext	()Landroid/support/v7/app/AppCompatActivity;
      //   195: checkcast 71	android/content/Context
      //   198: aload_1
      //   199: new 12	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f$b
      //   202: dup
      //   203: aload_0
      //   204: invokespecial 137	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f$b:<init>	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f;)V
      //   207: checkcast 76	com/tencent/mm/platformtools/p$a
      //   210: invokestatic 81	com/tencent/mm/platformtools/p:a	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/platformtools/p$a;)V
      //   213: ldc 41
      //   215: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   218: return
      //   219: astore_1
      //   220: ldc 86
      //   222: aload_1
      //   223: checkcast 88	java/lang/Throwable
      //   226: ldc 139
      //   228: iconst_0
      //   229: anewarray 4	java/lang/Object
      //   232: invokestatic 96	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   235: ldc 41
      //   237: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   240: return
      //   241: astore_1
      //   242: ldc 86
      //   244: aload_1
      //   245: checkcast 88	java/lang/Throwable
      //   248: ldc 141
      //   250: iconst_0
      //   251: anewarray 4	java/lang/Object
      //   254: invokestatic 96	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   257: goto -81 -> 176
      //   260: ldc 41
      //   262: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   265: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	266	0	this	f
      //   0	266	1	paramView	View
      //   127	2	2	i	int
      // Exception table:
      //   from	to	target	type
      //   16	35	76	java/lang/Exception
      //   39	69	76	java/lang/Exception
      //   109	128	219	java/lang/Exception
      //   132	176	219	java/lang/Exception
      //   176	184	219	java/lang/Exception
      //   188	218	219	java/lang/Exception
      //   242	257	219	java/lang/Exception
      //   132	176	241	java/io/IOException
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$init$2$1$1", "Lcom/tencent/mm/platformtools/ExportFileUtil$ExportResultCallback;", "onExportFail", "", "srcPath", "", "destPath", "onExportSuccess", "scan-translation_release"})
    public static final class a
      implements p.a
    {
      a(ScanTranslationResultUI.f paramf) {}
      
      public final void bv(String paramString1, String paramString2)
      {
        AppMethodBeat.i(190944);
        k.h(paramString1, "srcPath");
        k.h(paramString2, "destPath");
        paramString1 = this.vUJ.vUE.getContext();
        if (paramString1 == null)
        {
          paramString1 = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(190944);
          throw paramString1;
        }
        com.tencent.mm.ui.widget.snackbar.b.n((Activity)paramString1, this.vUJ.vUE.getResources().getString(2131762883));
        AppMethodBeat.o(190944);
      }
      
      public final void bw(String paramString1, String paramString2)
      {
        AppMethodBeat.i(190945);
        k.h(paramString1, "srcPath");
        k.h(paramString2, "destPath");
        paramString1 = this.vUJ.vUE.getContext();
        if (paramString1 == null)
        {
          paramString1 = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(190945);
          throw paramString1;
        }
        com.tencent.mm.ui.widget.snackbar.b.n((Activity)paramString1, this.vUJ.vUE.getResources().getString(2131762779));
        AppMethodBeat.o(190945);
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$init$2$2$1", "Lcom/tencent/mm/platformtools/ExportFileUtil$ExportResultCallback;", "onExportFail", "", "srcPath", "", "destPath", "onExportSuccess", "scan-translation_release"})
    public static final class b
      implements p.a
    {
      b(ScanTranslationResultUI.f paramf) {}
      
      public final void bv(String paramString1, String paramString2)
      {
        AppMethodBeat.i(190946);
        k.h(paramString1, "srcPath");
        k.h(paramString2, "destPath");
        paramString1 = this.vUJ.vUE.getContext();
        if (paramString1 == null)
        {
          paramString1 = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(190946);
          throw paramString1;
        }
        com.tencent.mm.ui.widget.snackbar.b.n((Activity)paramString1, this.vUJ.vUE.getResources().getString(2131762883));
        AppMethodBeat.o(190946);
      }
      
      public final void bw(String paramString1, String paramString2)
      {
        AppMethodBeat.i(190947);
        k.h(paramString1, "srcPath");
        k.h(paramString2, "destPath");
        paramString1 = this.vUJ.vUE.getContext();
        if (paramString1 == null)
        {
          paramString1 = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(190947);
          throw paramString1;
        }
        com.tencent.mm.ui.widget.snackbar.b.n((Activity)paramString1, this.vUJ.vUE.getResources().getString(2131762779));
        AppMethodBeat.o(190947);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationResultUI
 * JD-Core Version:    0.7.0.1
 */