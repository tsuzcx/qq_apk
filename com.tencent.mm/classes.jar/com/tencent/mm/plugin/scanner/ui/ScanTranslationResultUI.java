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
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SpinnerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.b.a.dm;
import com.tencent.mm.g.c.fp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.scanner.PluginScanTranslation;
import com.tencent.mm.plugin.scanner.model.af;
import com.tencent.mm.plugin.scanner.model.ag;
import com.tencent.mm.plugin.scanner.model.k;
import com.tencent.mm.plugin.scanner.util.j;
import com.tencent.mm.plugin.scanner.util.j.b;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.scanner.util.m.a;
import com.tencent.mm.plugin.scanner.util.m.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import java.io.IOException;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/scanner/util/ScanTranslationRender$TranslationRenderCallback;", "()V", "bottomBgLayer", "Landroid/view/View;", "closeButton", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "curMediaId", "", "curSessionId", "", "curState", "gestureGallery", "Lcom/tencent/mm/ui/tools/MMGestureGallery;", "originalBitmap", "Landroid/graphics/Bitmap;", "originalPath", "reportData", "Lcom/tencent/mm/autogen/mmdata/rpt/OCRTranslateReportStruct;", "rootContainer", "rotateDegree", "saveContainer", "saveImgBtn", "scanLine", "Landroid/widget/ImageView;", "scanLineAnimator", "Landroid/animation/ValueAnimator;", "screenHeight", "source", "startTimeArray", "", "targetLang", "topBgLayer", "translateBitmap", "translateImageAdapter", "Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$TranslateImageAdapter;", "translationPath", "viewSourceBtn", "configNavigationBar", "", "doTranslation", "drawTranslationResult", "session", "newBitmap", "enterFullScreen", "enterPreviewStatus", "enterTranslateFinishStatus", "enterTranslateStatus", "finishActivity", "getLayoutId", "goBack", "init", "initData", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "resetTargetLang", "setPreviewBitmap", "bitmap", "startScanLineAnimation", "stopScanLineAnimation", "Companion", "TranslateImageAdapter", "scan-translation_release"})
public final class ScanTranslationResultUI
  extends MMActivity
  implements com.tencent.mm.ak.f, j.b
{
  public static final ScanTranslationResultUI.a yJq;
  private int doj;
  private int hTf;
  private int hpY;
  private View iYE;
  private String iwv;
  private int lya;
  private ImageView rHi;
  private ValueAnimator rHl;
  private String ukB;
  private View yIP;
  private ImageView yIQ;
  private View yIR;
  private View yIS;
  private View yIT;
  private Bitmap yIV;
  private Bitmap yIW;
  private String yIX;
  private MMGestureGallery yIZ;
  private int yJb;
  private String yJc;
  private final dm yJf;
  private final long[] yJg;
  private WeImageView yJo;
  private b yJp;
  
  static
  {
    AppMethodBeat.i(121001);
    yJq = new ScanTranslationResultUI.a((byte)0);
    AppMethodBeat.o(121001);
  }
  
  public ScanTranslationResultUI()
  {
    AppMethodBeat.i(121000);
    this.rHl = new ValueAnimator();
    this.hTf = -1;
    this.yJf = new dm();
    this.yJg = new long[2];
    AppMethodBeat.o(121000);
  }
  
  private final void ac(Bitmap paramBitmap)
  {
    AppMethodBeat.i(120997);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(120997);
      return;
    }
    ae.i("MicroMsg.ScanTranslationResultUI", "alvinluo setImageBitmap size: %s, %s", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
    b localb = this.yJp;
    if (localb != null) {
      localb.setImageBitmap(paramBitmap);
    }
    paramBitmap = this.yJp;
    if (paramBitmap != null)
    {
      paramBitmap.notifyDataSetChanged();
      AppMethodBeat.o(120997);
      return;
    }
    AppMethodBeat.o(120997);
  }
  
  private final void cyc()
  {
    AppMethodBeat.i(120992);
    this.yJf.jY(2L);
    this.yJb = ((int)(com.tencent.mm.model.v.aAC().hashCode() + System.currentTimeMillis() & 0xFFFFFFFF));
    this.hTf = 1;
    dPf();
    Object localObject;
    if (d.n.n.H(this.yJc, "zh_CN", true))
    {
      localObject = this.yIQ;
      if (localObject == null) {
        p.bdF("viewSourceBtn");
      }
      ((ImageView)localObject).setImageResource(2131691335);
    }
    for (;;)
    {
      localObject = this.yIS;
      if (localObject == null) {
        p.bdF("topBgLayer");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.yIT;
      if (localObject == null) {
        p.bdF("bottomBgLayer");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.yIP;
      if (localObject == null) {
        p.bdF("saveContainer");
      }
      ((View)localObject).setVisibility(8);
      localObject = this.rHi;
      if (localObject == null) {
        p.bdF("scanLine");
      }
      ((ImageView)localObject).setVisibility(0);
      localObject = this.yIZ;
      if (localObject == null) {
        p.bdF("gestureGallery");
      }
      ((MMGestureGallery)localObject).setVisibility(0);
      cye();
      dPm();
      AppMethodBeat.o(120992);
      return;
      localObject = this.yIQ;
      if (localObject == null) {
        p.bdF("viewSourceBtn");
      }
      ((ImageView)localObject).setImageResource(2131691338);
    }
  }
  
  private final void cye()
  {
    AppMethodBeat.i(120994);
    this.rHl.setRepeatMode(1);
    this.rHl.setRepeatCount(-1);
    this.rHl.start();
    AppMethodBeat.o(120994);
  }
  
  private final void cyf()
  {
    AppMethodBeat.i(120995);
    this.rHl.setRepeatMode(1);
    this.rHl.setRepeatCount(0);
    this.rHl.end();
    AppMethodBeat.o(120995);
  }
  
  private final void dPf()
  {
    AppMethodBeat.i(120984);
    d.n.n.H(ad.fom(), "zh_CN", true);
    this.yJc = ad.iR((Context)getContext());
    ae.i("MicroMsg.ScanTranslationResultUI", "targetLang %s", new Object[] { this.yJc });
    AppMethodBeat.o(120984);
  }
  
  private final void dPl()
  {
    AppMethodBeat.i(120993);
    ae.i("MicroMsg.ScanTranslationResultUI", "alvinluo enterTranslateFinishStatus");
    this.hTf = 3;
    Object localObject = this.yIP;
    if (localObject == null) {
      p.bdF("saveContainer");
    }
    ((View)localObject).setVisibility(0);
    if (d.n.n.H(this.yJc, "zh_CN", true))
    {
      localObject = this.yIQ;
      if (localObject == null) {
        p.bdF("viewSourceBtn");
      }
      ((ImageView)localObject).setImageResource(2131234422);
    }
    for (;;)
    {
      localObject = this.rHi;
      if (localObject == null) {
        p.bdF("scanLine");
      }
      ((ImageView)localObject).setVisibility(8);
      cyf();
      if ((this.doj != 1) || (!bu.isNullOrNil(this.yIX))) {
        break label289;
      }
      this.yIX = ((PluginScanTranslation)g.ad(PluginScanTranslation.class)).genTranslationResultImgPath("jpg");
      try
      {
        com.tencent.mm.sdk.platformtools.h.a(this.yIW, 80, Bitmap.CompressFormat.JPEG, this.yIX, false);
        localObject = new ag();
        ((ag)localObject).field_originMD5 = aj.ej(p.C(this.iwv, Long.valueOf(o.aZS(this.iwv))));
        ((ag)localObject).field_resultFile = this.yIX;
        ae.i("MicroMsg.ScanTranslationResultUI", "insert translate result %s", new Object[] { this.yIX });
        com.tencent.mm.kernel.b.a locala = g.ad(PluginScanTranslation.class);
        p.g(locala, "MMKernel.plugin(PluginScanTranslation::class.java)");
        ((PluginScanTranslation)locala).getTranslationResultStorage().a((ag)localObject);
        AppMethodBeat.o(120993);
        return;
      }
      catch (IOException localIOException)
      {
        ae.printErrStackTrace("MicroMsg.ScanTranslationResultUI", (Throwable)localIOException, "save translate result file error", new Object[0]);
      }
      localObject = this.yIQ;
      if (localObject == null) {
        p.bdF("viewSourceBtn");
      }
      ((ImageView)localObject).setImageResource(2131234424);
    }
    label289:
    AppMethodBeat.o(120993);
  }
  
  private final void dPm()
  {
    AppMethodBeat.i(120987);
    for (;;)
    {
      Object localObject3;
      long l;
      try
      {
        ae.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation");
        if ((!bu.isNullOrNil(this.iwv)) && (this.yIV != null))
        {
          this.ukB = m.ayo(this.iwv);
          localObject3 = this.iwv;
          if (this.doj == 0)
          {
            l = System.currentTimeMillis();
            com.tencent.mm.sdk.platformtools.h.a(this.yIV, 80, Bitmap.CompressFormat.JPEG, this.iwv, false);
            ae.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation save img cost %d", new Object[] { Integer.valueOf((int)(System.currentTimeMillis() - l)) });
            ae.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation fileSize %d", new Object[] { Long.valueOf(o.aZR(this.iwv)) });
            localObject1 = localObject3;
            this.yJg[1] = System.currentTimeMillis();
            localObject3 = g.ad(com.tencent.mm.plugin.scanner.f.class);
            p.g(localObject3, "MMKernel.plugin(IPluginScanner::class.java)");
            ((com.tencent.mm.plugin.scanner.f)localObject3).getScanCdnService().a(this.ukB, (String)localObject1, com.tencent.mm.i.a.MediaType_IMAGE, (m.a)new d(this, (String)localObject1));
            AppMethodBeat.o(120987);
            return;
          }
          Object localObject1 = localObject3;
          if (this.doj != 1) {
            continue;
          }
          localObject1 = aj.ej(p.C(this.iwv, Long.valueOf(o.aZS(this.iwv))));
          com.tencent.mm.kernel.b.a locala = g.ad(PluginScanTranslation.class);
          p.g(locala, "MMKernel.plugin(PluginScanTranslation::class.java)");
          localObject1 = ((PluginScanTranslation)locala).getTranslationResultStorage().ayb((String)localObject1);
          if (localObject1 == null) {
            break label356;
          }
          ae.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation already has translation result");
          this.yIX = ((fp)localObject1).field_resultFile;
          this.yIW = com.tencent.mm.sdk.platformtools.h.decodeFile(this.yIX, new BitmapFactory.Options());
          if (this.yIW == null) {
            break label348;
          }
          ar.o((Runnable)new c(this), 500L);
          AppMethodBeat.o(120987);
        }
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.ScanTranslationResultUI", (Throwable)localException, "", new Object[0]);
        AppMethodBeat.o(120987);
        return;
      }
      label348:
      ae.w("MicroMsg.ScanTranslationResultUI", "can not find old translation result!");
      label356:
      Object localObject2 = localObject3;
      if (this.hpY != 0)
      {
        l = System.currentTimeMillis();
        localObject2 = ((com.tencent.mm.plugin.scanner.f)g.ad(com.tencent.mm.plugin.scanner.f.class)).genScanTmpImgPath("jpg");
        com.tencent.mm.sdk.platformtools.h.a(this.yIV, 80, Bitmap.CompressFormat.JPEG, (String)localObject2, false);
        ae.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation save img cost %d", new Object[] { Integer.valueOf((int)(System.currentTimeMillis() - l)) });
        ae.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation fileSize %d", new Object[] { Long.valueOf(o.aZR((String)localObject2)) });
      }
    }
  }
  
  private final void dPn()
  {
    AppMethodBeat.i(120989);
    finish();
    overridePendingTransition(2130771986, 2130771986);
    AppMethodBeat.o(120989);
  }
  
  public final void c(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(120998);
    if ((paramBitmap != null) && (paramInt == this.yJb))
    {
      this.yJf.kb((int)(System.currentTimeMillis() - this.yJg[1]));
      this.yIW = paramBitmap;
      dPl();
      ac(this.yIW);
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
      paramIntent = com.tencent.mm.ui.tools.a.j((Context)getContext(), paramIntent, com.tencent.mm.plugin.image.d.azQ());
      ae.i("MicroMsg.ScanTranslationResultUI", "select: [%s]", new Object[] { paramIntent });
      if (!bu.isNullOrNil(paramIntent))
      {
        this.iwv = paramIntent;
        this.doj = 1;
        this.yJf.jW(2L);
        Exif localExif = Exif.fromFile(paramIntent);
        p.g(localExif, "Exif.fromFile(filePath)");
        this.hpY = localExif.getOrientationInDegree();
        ae.i("MicroMsg.ScanTranslationResultUI", "degree %s", new Object[] { Integer.valueOf(this.hpY) });
        paramIntent = com.tencent.mm.sdk.platformtools.h.aRD(paramIntent);
        if (paramIntent != null)
        {
          this.yIV = com.tencent.mm.sdk.platformtools.h.a(paramIntent, this.hpY);
          cyc();
          ac(this.yIV);
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
    p.g(paramBundle, "findViewById(R.id.root_container)");
    this.iYE = paramBundle;
    paramBundle = findViewById(2131306074);
    p.g(paramBundle, "findViewById(R.id.translate_gallery_view)");
    this.yIZ = ((MMGestureGallery)paramBundle);
    this.yJp = new b();
    paramBundle = this.yIZ;
    if (paramBundle == null) {
      p.bdF("gestureGallery");
    }
    paramBundle.setAdapter((SpinnerAdapter)this.yJp);
    paramBundle = findViewById(2131304289);
    p.g(paramBundle, "findViewById(R.id.save_translate_container)");
    this.yIP = paramBundle;
    paramBundle = this.yIP;
    if (paramBundle == null) {
      p.bdF("saveContainer");
    }
    paramBundle = paramBundle.findViewById(2131306078);
    p.g(paramBundle, "saveContainer.findViewBy…ranslate_view_source_btn)");
    this.yIQ = ((ImageView)paramBundle);
    paramBundle = this.yIQ;
    if (paramBundle == null) {
      p.bdF("viewSourceBtn");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new e(this));
    paramBundle = findViewById(2131306077);
    p.g(paramBundle, "findViewById(R.id.translate_top_bg)");
    this.yIS = paramBundle;
    paramBundle = findViewById(2131306071);
    p.g(paramBundle, "findViewById(R.id.translate_bottom_bg)");
    this.yIT = paramBundle;
    hideTitleView();
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    paramBundle = findViewById(2131304314);
    p.g(paramBundle, "findViewById(R.id.scan_line)");
    this.rHi = ((ImageView)paramBundle);
    paramBundle = this.yIP;
    if (paramBundle == null) {
      p.bdF("saveContainer");
    }
    paramBundle = paramBundle.findViewById(2131306073);
    p.g(paramBundle, "saveContainer.findViewBy…d.translate_download_btn)");
    this.yIR = paramBundle;
    paramBundle = this.yIR;
    if (paramBundle == null) {
      p.bdF("saveImgBtn");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new f(this));
    paramBundle = findViewById(2131298365);
    p.g(paramBundle, "findViewById(R.id.close_button)");
    this.yJo = ((WeImageView)paramBundle);
    paramBundle = this.yJo;
    if (paramBundle == null) {
      p.bdF("closeButton");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new ScanTranslationResultUI.g(this));
    this.lya = com.tencent.mm.cb.a.iv((Context)getContext());
    this.rHl.setFloatValues(new float[] { 0.0F, 1.0F });
    this.rHl.addListener((Animator.AnimatorListener)new ScanTranslationResultUI.h(this));
    this.rHl.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new ScanTranslationResultUI.i(this));
    paramBundle = this.yIP;
    if (paramBundle == null) {
      p.bdF("saveContainer");
    }
    paramBundle = paramBundle.getLayoutParams();
    if (paramBundle == null)
    {
      paramBundle = new d.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(120983);
      throw paramBundle;
    }
    paramBundle = (RelativeLayout.LayoutParams)paramBundle;
    int i = paramBundle.bottomMargin;
    paramBundle.bottomMargin = (al.en((Context)getContext()) + i);
    Object localObject = this.yIP;
    if (localObject == null) {
      p.bdF("saveContainer");
    }
    ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)paramBundle);
    this.rHl.setDuration(5000L);
    com.tencent.mm.ui.base.b.a((Activity)this, null);
    dPf();
    localObject = getIntent().getStringExtra("key_translation_origin_image_path");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.iwv = paramBundle;
    this.doj = getIntent().getIntExtra("key_translation_source", 0);
    if (this.doj == 0)
    {
      this.yJf.jX(getIntent().getLongExtra("key_translation_capture_time", 0L));
      this.yJf.jW(1L);
    }
    for (;;)
    {
      ae.i("MicroMsg.ScanTranslationResultUI", "alvinluo initData originPath: %s, source: %d", new Object[] { this.iwv, Integer.valueOf(this.doj) });
      paramBundle = this.iwv;
      if (paramBundle == null) {
        p.gkB();
      }
      this.yIV = af.axZ(paramBundle);
      if (this.yIV != null)
      {
        paramBundle = this.yIV;
        if (paramBundle == null) {
          p.gkB();
        }
        if (!paramBundle.isRecycled())
        {
          paramBundle = this.yIV;
          if (paramBundle == null) {
            p.gkB();
          }
          i = paramBundle.getWidth();
          paramBundle = this.yIV;
          if (paramBundle == null) {
            p.gkB();
          }
          ae.i("MicroMsg.ScanTranslationResultUI", "alvinluo initData bitmap width: %d, height: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramBundle.getHeight()) });
        }
      }
      ac(this.yIV);
      AppMethodBeat.o(120983);
      return;
      if (this.doj == 1)
      {
        this.yJf.jX(0L);
        this.yJf.jW(2L);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(120991);
    super.onDestroy();
    this.rHl.removeAllListeners();
    this.rHl.removeAllUpdateListeners();
    this.rHl.cancel();
    af.clear();
    Object localObject = g.ad(PluginScanTranslation.class);
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.PluginScanTranslation");
      AppMethodBeat.o(120991);
      throw ((Throwable)localObject);
    }
    ((PluginScanTranslation)localObject).getTranslationRender().dQj();
    AppMethodBeat.o(120991);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(120988);
    p.h(paramKeyEvent, "event");
    if (paramInt == 4)
    {
      paramKeyEvent = g.ad(PluginScanTranslation.class);
      if (paramKeyEvent == null)
      {
        paramKeyEvent = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.PluginScanTranslation");
        AppMethodBeat.o(120988);
        throw paramKeyEvent;
      }
      ((PluginScanTranslation)paramKeyEvent).getTranslationRender().dQj();
      if (this.hTf != 0)
      {
        if ((this.hTf != 1) && (this.hTf != 2) && (this.hTf != 3)) {
          break label141;
        }
        if (this.hTf == 1) {
          this.yJf.kb((int)(System.currentTimeMillis() - this.yJg[1]));
        }
        if (this.yJf.Te() != 0L) {
          this.yJf.aLH();
        }
      }
      dPn();
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
    g.ajj().b(294, (com.tencent.mm.ak.f)this);
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
    if (com.tencent.mm.compatible.util.d.lA(19)) {
      getWindow().addFlags(67109888);
    }
    for (;;)
    {
      localObject = getWindow();
      p.g(localObject, "window");
      localObject = ((Window)localObject).getDecorView();
      p.g(localObject, "window.decorView");
      ((View)localObject).setSystemUiVisibility(1280);
      com.tencent.mm.plugin.ball.f.f.bMs();
      g.ajj().a(294, (com.tencent.mm.ak.f)this);
      ae.i("MicroMsg.ScanTranslationResultUI", "alvinluo onResume curState: %d", new Object[] { Integer.valueOf(this.hTf) });
      if (this.hTf == -1) {
        cyc();
      }
      AppMethodBeat.o(120985);
      return;
      getWindow().setFlags(1024, 1024);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(120996);
    ae.i("MicroMsg.ScanTranslationResultUI", "alvinluo scanTranslate onSceneEnd errType %s, errCode %s, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.model.NetSceneNewOCRTranslation");
        AppMethodBeat.o(120996);
        throw paramString;
      }
      paramString = ((k)paramn).dOk();
      if ((paramString != null) && (((k)paramn).getSessionId() == this.yJb))
      {
        this.yJf.ka((int)(System.currentTimeMillis() - ((k)paramn).dOm()));
        ae.i("MicroMsg.ScanTranslationResultUI", "alvinluo scanTranslate onSceneEnd angle %f, translationInfos length %d", new Object[] { Float.valueOf(((k)paramn).dOj()), Integer.valueOf(paramString.size()) });
        if (paramString.size() > 0)
        {
          this.yJf.jY(1L);
          com.tencent.mm.kernel.b.a locala = g.ad(PluginScanTranslation.class);
          p.g(locala, "MMKernel.plugin(PluginScanTranslation::class.java)");
          ((PluginScanTranslation)locala).getTranslationRender().a(this.yJb, paramString, ((k)paramn).dOj(), this.yIV, (j.b)this);
          if (!bu.isNullOrNil(((k)paramn).dOl()))
          {
            this.yJc = ((k)paramn).dOl();
            AppMethodBeat.o(120996);
          }
        }
        else
        {
          this.yJf.kb((int)(System.currentTimeMillis() - this.yJg[1]));
          paramString = getResources().getString(2131762880);
          com.tencent.mm.ui.base.h.a((Context)getContext(), paramString, "", false, (DialogInterface.OnClickListener)new ScanTranslationResultUI.j(this));
          AppMethodBeat.o(120996);
        }
      }
    }
    else
    {
      cyf();
      this.yJf.jY(5L);
      this.yJf.kb((int)(System.currentTimeMillis() - this.yJg[1]));
      paramn = getResources().getString(2131762880);
      if (bu.isNullOrNil(paramString)) {
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
    g.ajj().b(294, (com.tencent.mm.ak.f)this);
    AppMethodBeat.o(120990);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$TranslateImageAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)V", "bitmap", "Landroid/graphics/Bitmap;", "getCount", "", "getItem", "", "i", "getItemId", "", "getView", "Landroid/view/View;", "view", "viewGroup", "Landroid/view/ViewGroup;", "setImageBitmap", "", "scan-translation_release"})
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
      p.h(paramViewGroup, "viewGroup");
      if (paramView == null)
      {
        paramView = new MultiTouchImageView((Context)this.yJr.getContext(), 0, 0, (byte)0);
        paramView.setLayoutParams((ViewGroup.LayoutParams)new Gallery.LayoutParams(-1, -1));
      }
      for (;;)
      {
        if (this.bitmap != null)
        {
          paramView.setImageBitmap(this.bitmap);
          paramViewGroup = this.bitmap;
          if (paramViewGroup == null) {
            p.gkB();
          }
          paramInt = paramViewGroup.getWidth();
          paramViewGroup = this.bitmap;
          if (paramViewGroup == null) {
            p.gkB();
          }
          paramView.cH(paramInt, paramViewGroup.getHeight());
          paramView.fCA();
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
      p.h(paramBitmap, "bitmap");
      this.bitmap = paramBitmap;
      AppMethodBeat.o(120969);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(ScanTranslationResultUI paramScanTranslationResultUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(120970);
      ScanTranslationResultUI.m(this.yJr);
      ScanTranslationResultUI.a(this.yJr, ScanTranslationResultUI.f(this.yJr));
      AppMethodBeat.o(120970);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "mediaId", "", "kotlin.jvm.PlatformType", "result", "Lcom/tencent/mm/plugin/scanner/util/ScannerCdnService$ScannerUploadCallbackResult;", "Lcom/tencent/mm/plugin/scanner/util/ScannerCdnService;", "onFinish"})
  static final class d
    implements m.a
  {
    d(ScanTranslationResultUI paramScanTranslationResultUI, String paramString) {}
    
    public final void a(String paramString, m.b paramb)
    {
      AppMethodBeat.i(120975);
      if ((!bu.isNullOrNil(paramString)) && (p.i(paramString, ScanTranslationResultUI.n(this.yJr))))
      {
        ScanTranslationResultUI.e(this.yJr).jZ((int)(System.currentTimeMillis() - ScanTranslationResultUI.o(this.yJr)[1]));
        ae.i("MicroMsg.ScanTranslationResultUI", "alvinluo scanTranslate upload img cost %d, errCode: %d", new Object[] { Long.valueOf(ScanTranslationResultUI.e(this.yJr).Tf()), Integer.valueOf(paramb.errCode) });
        switch (paramb.errCode)
        {
        }
      }
      for (;;)
      {
        if ((ScanTranslationResultUI.a(this.yJr) == 1) && (ScanTranslationResultUI.r(this.yJr) != 0))
        {
          ae.i("delete tmp path %s", this.yJs);
          o.deleteFile(this.yJs);
        }
        AppMethodBeat.o(120975);
        return;
        if (!bu.V(new String[] { paramb.fileId, paramb.aeskey }))
        {
          ae.i("MicroMsg.ScanTranslationResultUI", "fileId %s", new Object[] { paramb.fileId });
          paramString = new k(ScanTranslationResultUI.p(this.yJr), (int)o.aZR(this.yJs), paramb.fileId, paramb.aeskey);
          g.ajj().b((com.tencent.mm.ak.n)paramString);
        }
        else
        {
          ar.f((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(120972);
              ScanTranslationResultUI.q(this.yJt.yJr);
              com.tencent.mm.ui.base.h.d((Context)this.yJt.yJr.getContext(), this.yJt.yJr.getResources().getString(2131762880), this.yJt.yJr.getResources().getString(2131755906), (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(120971);
                  ScanTranslationResultUI.j(this.yJu.yJt.yJr);
                  AppMethodBeat.o(120971);
                }
              });
              AppMethodBeat.o(120972);
            }
          });
          ScanTranslationResultUI.e(this.yJr).jY(3L);
          continue;
          ar.f((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(120974);
              ScanTranslationResultUI.q(this.yJt.yJr);
              com.tencent.mm.ui.base.h.d((Context)this.yJt.yJr.getContext(), this.yJt.yJr.getResources().getString(2131759055), this.yJt.yJr.getResources().getString(2131755906), (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(120973);
                  ScanTranslationResultUI.j(this.yJv.yJt.yJr);
                  AppMethodBeat.o(120973);
                }
              });
              AppMethodBeat.o(120974);
            }
          });
          ScanTranslationResultUI.e(this.yJr).jY(3L);
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(ScanTranslationResultUI paramScanTranslationResultUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120976);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      if (ScanTranslationResultUI.a(this.yJr) == 3)
      {
        if (ScanTranslationResultUI.b(this.yJr) != null) {
          ScanTranslationResultUI.a(this.yJr, ScanTranslationResultUI.b(this.yJr));
        }
        paramView = ScanTranslationResultUI.c(this.yJr);
        if ((paramView != null) && (d.n.n.H(paramView, "zh_CN", false) == true))
        {
          ScanTranslationResultUI.d(this.yJr).setImageResource(2131691336);
          ScanTranslationResultUI.a(this.yJr, 2);
          ScanTranslationResultUI.e(this.yJr).kc(ScanTranslationResultUI.e(this.yJr).Tg() + 1L);
        }
      }
      while (ScanTranslationResultUI.a(this.yJr) != 2) {
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(120976);
          return;
          ScanTranslationResultUI.d(this.yJr).setImageResource(2131691339);
        }
      }
      if (ScanTranslationResultUI.f(this.yJr) != null) {
        ScanTranslationResultUI.a(this.yJr, ScanTranslationResultUI.f(this.yJr));
      }
      paramView = ScanTranslationResultUI.c(this.yJr);
      if ((paramView != null) && (d.n.n.H(paramView, "zh_CN", true) == true)) {
        ScanTranslationResultUI.d(this.yJr).setImageResource(2131234422);
      }
      for (;;)
      {
        ScanTranslationResultUI.a(this.yJr, 3);
        break;
        ScanTranslationResultUI.d(this.yJr).setImageResource(2131234424);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
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
      //   15: invokevirtual 54	com/tencent/mm/hellhoundlib/b/b:bd	(Ljava/lang/Object;)V
      //   18: ldc 56
      //   20: ldc 57
      //   22: ldc 58
      //   24: ldc 59
      //   26: aload_0
      //   27: aload_3
      //   28: invokevirtual 63	com/tencent/mm/hellhoundlib/b/b:ahF	()[Ljava/lang/Object;
      //   31: invokestatic 69	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V
      //   34: aload_0
      //   35: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:yJr	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   38: invokestatic 73	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:a	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)I
      //   41: iconst_2
      //   42: if_icmpne +88 -> 130
      //   45: aload_0
      //   46: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:yJr	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   49: invokestatic 77	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:e	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)Lcom/tencent/mm/g/b/a/dm;
      //   52: invokevirtual 83	com/tencent/mm/g/b/a/dm:Ti	()Lcom/tencent/mm/g/b/a/dm;
      //   55: pop
      //   56: aload_0
      //   57: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:yJr	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   60: invokestatic 87	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:g	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)Ljava/lang/String;
      //   63: astore_1
      //   64: aload_1
      //   65: ifnull +28 -> 93
      //   68: aload_0
      //   69: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:yJr	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
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
      //   124: invokestatic 121	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   127: goto -34 -> 93
      //   130: aload_0
      //   131: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:yJr	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   134: invokestatic 73	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:a	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)I
      //   137: iconst_3
      //   138: if_icmpne -45 -> 93
      //   141: aload_0
      //   142: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:yJr	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   145: invokestatic 77	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:e	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)Lcom/tencent/mm/g/b/a/dm;
      //   148: invokevirtual 124	com/tencent/mm/g/b/a/dm:Th	()Lcom/tencent/mm/g/b/a/dm;
      //   151: pop
      //   152: aload_0
      //   153: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:yJr	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   156: invokestatic 127	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:h	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)I
      //   159: istore_2
      //   160: iload_2
      //   161: ifne +47 -> 208
      //   164: aload_0
      //   165: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:yJr	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   168: ldc 129
      //   170: invokestatic 135	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
      //   173: checkcast 129	com/tencent/mm/plugin/scanner/PluginScanTranslation
      //   176: ldc 137
      //   178: invokevirtual 141	com/tencent/mm/plugin/scanner/PluginScanTranslation:genTranslationResultImgPath	(Ljava/lang/String;)Ljava/lang/String;
      //   181: invokestatic 144	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:a	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;Ljava/lang/String;)V
      //   184: aload_0
      //   185: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:yJr	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   188: invokestatic 148	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:f	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)Landroid/graphics/Bitmap;
      //   191: bipush 80
      //   193: getstatic 154	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
      //   196: aload_0
      //   197: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:yJr	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   200: invokestatic 156	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:i	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)Ljava/lang/String;
      //   203: iconst_0
      //   204: invokestatic 161	com/tencent/mm/sdk/platformtools/h:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
      //   207: pop
      //   208: aload_0
      //   209: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:yJr	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   212: invokestatic 156	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:i	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)Ljava/lang/String;
      //   215: astore_1
      //   216: aload_1
      //   217: ifnull -124 -> 93
      //   220: aload_0
      //   221: getfield 31	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f:yJr	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;
      //   224: invokevirtual 91	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI:getContext	()Landroid/support/v7/app/AppCompatActivity;
      //   227: checkcast 93	android/content/Context
      //   230: aload_1
      //   231: new 12	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f$b
      //   234: dup
      //   235: aload_0
      //   236: invokespecial 162	com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f$b:<init>	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$f;)V
      //   239: checkcast 98	com/tencent/mm/platformtools/p$a
      //   242: invokestatic 103	com/tencent/mm/platformtools/p:a	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/platformtools/p$a;)V
      //   245: goto -152 -> 93
      //   248: astore_1
      //   249: ldc 111
      //   251: aload_1
      //   252: checkcast 113	java/lang/Throwable
      //   255: ldc 164
      //   257: iconst_0
      //   258: anewarray 4	java/lang/Object
      //   261: invokestatic 121	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   264: goto -171 -> 93
      //   267: astore_1
      //   268: ldc 111
      //   270: aload_1
      //   271: checkcast 113	java/lang/Throwable
      //   274: ldc 166
      //   276: iconst_0
      //   277: anewarray 4	java/lang/Object
      //   280: invokestatic 121	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$init$2$1$1", "Lcom/tencent/mm/platformtools/ExportFileUtil$ExportResultCallback;", "onExportFail", "", "srcPath", "", "destPath", "onExportSuccess", "scan-translation_release"})
    public static final class a
      implements p.a
    {
      a(ScanTranslationResultUI.f paramf) {}
      
      public final void bF(String paramString1, String paramString2)
      {
        AppMethodBeat.i(194119);
        p.h(paramString1, "srcPath");
        p.h(paramString2, "destPath");
        paramString1 = this.yJw.yJr.getContext();
        if (paramString1 == null)
        {
          paramString1 = new d.v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(194119);
          throw paramString1;
        }
        com.tencent.mm.ui.widget.snackbar.b.n((Activity)paramString1, this.yJw.yJr.getResources().getString(2131762883));
        AppMethodBeat.o(194119);
      }
      
      public final void bG(String paramString1, String paramString2)
      {
        AppMethodBeat.i(194120);
        p.h(paramString1, "srcPath");
        p.h(paramString2, "destPath");
        paramString1 = this.yJw.yJr.getContext();
        if (paramString1 == null)
        {
          paramString1 = new d.v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(194120);
          throw paramString1;
        }
        com.tencent.mm.ui.widget.snackbar.b.n((Activity)paramString1, this.yJw.yJr.getResources().getString(2131762779));
        AppMethodBeat.o(194120);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$init$2$2$1", "Lcom/tencent/mm/platformtools/ExportFileUtil$ExportResultCallback;", "onExportFail", "", "srcPath", "", "destPath", "onExportSuccess", "scan-translation_release"})
    public static final class b
      implements p.a
    {
      b(ScanTranslationResultUI.f paramf) {}
      
      public final void bF(String paramString1, String paramString2)
      {
        AppMethodBeat.i(194121);
        p.h(paramString1, "srcPath");
        p.h(paramString2, "destPath");
        paramString1 = this.yJw.yJr.getContext();
        if (paramString1 == null)
        {
          paramString1 = new d.v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(194121);
          throw paramString1;
        }
        com.tencent.mm.ui.widget.snackbar.b.n((Activity)paramString1, this.yJw.yJr.getResources().getString(2131762883));
        AppMethodBeat.o(194121);
      }
      
      public final void bG(String paramString1, String paramString2)
      {
        AppMethodBeat.i(194122);
        p.h(paramString1, "srcPath");
        p.h(paramString2, "destPath");
        paramString1 = this.yJw.yJr.getContext();
        if (paramString1 == null)
        {
          paramString1 = new d.v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(194122);
          throw paramString1;
        }
        com.tencent.mm.ui.widget.snackbar.b.n((Activity)paramString1, this.yJw.yJr.getResources().getString(2131762779));
        AppMethodBeat.o(194122);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationResultUI
 * JD-Core Version:    0.7.0.1
 */