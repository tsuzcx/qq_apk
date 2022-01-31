package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.media.ExifInterface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.lz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.plugin.scanner.util.n.a;
import com.tencent.mm.plugin.scanner.util.n.b;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.ui.s;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class ScanTranslationCaptureUI
  extends MMActivity
  implements Camera.PreviewCallback, TextureView.SurfaceTextureListener, com.tencent.mm.ah.f, n.b
{
  private SurfaceTexture aTk;
  private String eHd;
  private View eYe;
  private int egr;
  private boolean fht = true;
  private int[] fmY = new int[9];
  private int gHS;
  private ImageView nIL;
  private int nIO = 0;
  private com.tencent.mm.sdk.b.c<lz> nIW = new ScanTranslationCaptureUI.1(this);
  private com.tencent.mm.plugin.scanner.util.h nIo;
  private MMTextureView nMO;
  private View nMP;
  private View nMQ;
  private View nMR;
  private View nMS;
  private View nMT;
  private ImageView nMU;
  private View nMV;
  private ImageView nMW;
  private View nMX;
  private View nMY;
  private TextView nMZ;
  private Bitmap nNa;
  private Bitmap nNb;
  private String nNc;
  private String nNd;
  private ValueAnimator nNe;
  private ValueAnimator nNf;
  private int nNg;
  private String nNh;
  private float nNi = 1.0F;
  private boolean nNj;
  private boolean nNk;
  private long[] nNl = new long[3];
  
  private void aPC()
  {
    stopPreview();
    this.nIo.release();
  }
  
  private void akJ()
  {
    getWindow().addFlags(2097280);
    int i = 1542;
    if (Build.VERSION.SDK_INT >= 19) {
      i = 5638;
    }
    getWindow().getDecorView().setSystemUiVisibility(i);
  }
  
  private void b(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Matrix localMatrix = new Matrix(this.nMW.getImageMatrix());
      localMatrix.reset();
      this.nNi = 1.0F;
      localMatrix.setRectToRect(new RectF(0.0F, 0.0F, paramBitmap.getWidth(), paramBitmap.getHeight()), new RectF(0.0F, 0.0F, this.eYe.getWidth(), this.eYe.getHeight()), Matrix.ScaleToFit.FILL);
      this.nMW.setImageMatrix(localMatrix);
    }
    for (;;)
    {
      this.nMW.setImageBitmap(paramBitmap);
      return;
      this.nMW.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
  }
  
  private void buJ()
  {
    if (!com.tencent.mm.compatible.f.b.zB())
    {
      com.tencent.mm.ui.base.h.a(this, getString(R.l.app_special_no_open_camera_permission), getString(R.l.app_need_camera_title), getString(R.l.app_need_show_settings_button), true, new ScanTranslationCaptureUI.8(this));
      return;
    }
    bxY();
  }
  
  private void bxA()
  {
    com.tencent.mm.ui.base.h.a(this, getString(R.l.scan_open_camera_fail), getString(R.l.app_tip), false, new ScanTranslationCaptureUI.11(this));
  }
  
  private void bxW()
  {
    x.cqJ().equalsIgnoreCase("zh_CN");
    this.nNh = x.fB(this);
    y.i("MicroMsg.ScanTranslationCaptureUI", "targetLang %s", new Object[] { this.nNh });
  }
  
  private void bxX()
  {
    try
    {
      if (!this.nIo.isOpen())
      {
        long l = System.currentTimeMillis();
        this.nIo.open();
        this.nIo.a(new ScanTranslationCaptureUI.9(this));
        y.i("MicroMsg.ScanTranslationCaptureUI", "open camera cost %s, failed count %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(this.nIO) });
        this.nIo.byu();
        Rect localRect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
        this.nIo.g(new Point(localRect.width(), localRect.height()));
        if (this.egr == 0) {
          byb();
        }
        this.nIO = 0;
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.ScanTranslationCaptureUI", localException.getMessage());
      this.nIO += 1;
      if (this.nIO >= 5)
      {
        bxA();
        return;
      }
      ai.l(new ScanTranslationCaptureUI.10(this), 30L);
    }
  }
  
  private void bxY()
  {
    y.i("MicroMsg.ScanTranslationCaptureUI", "curState %d", new Object[] { Integer.valueOf(this.egr) });
    if (!this.nIo.isOpen()) {
      bxX();
    }
    if (this.egr == 0) {
      if (this.nIo.isOpen()) {
        byb();
      }
    }
    while (this.egr != 1) {
      return;
    }
    bya();
  }
  
  private void bxZ()
  {
    getWindow().getDecorView().setSystemUiVisibility(1028);
  }
  
  private void bya()
  {
    stopPreview();
    this.fmY[2] = 2;
    this.egr = 1;
    this.nNg = ((int)(q.Gj().hashCode() + System.currentTimeMillis() & 0xFFFFFFFF));
    try
    {
      if (this.nNa != null)
      {
        com.tencent.mm.vfs.e.aeW(r.byC());
        this.eHd = r.Ml("jpg");
        Object localObject = this.eHd;
        this.nNd = (q.Gj() + "_" + (String)localObject);
        long l = System.currentTimeMillis();
        com.tencent.mm.sdk.platformtools.c.a(this.nNa, 80, Bitmap.CompressFormat.JPEG, this.eHd, false);
        y.i("MicroMsg.ScanTranslationCaptureUI", "save img cost %d", new Object[] { Integer.valueOf((int)(System.currentTimeMillis() - l)) });
        this.nNl[1] = System.currentTimeMillis();
        localObject = com.tencent.mm.plugin.scanner.c.bxd().nGr;
        String str1 = this.nNd;
        String str2 = this.eHd;
        int i = com.tencent.mm.j.a.MediaType_IMAGE;
        ScanTranslationCaptureUI.6 local6 = new ScanTranslationCaptureUI.6(this);
        com.tencent.mm.j.f localf = new com.tencent.mm.j.f();
        localf.dlP = ((com.tencent.mm.plugin.scanner.util.p)localObject).epa;
        localf.field_mediaId = str1;
        localf.field_fullpath = str2;
        localf.field_fileType = i;
        localf.field_priority = com.tencent.mm.j.a.dlk;
        localf.field_needStorage = false;
        localf.field_isStreamMedia = false;
        localf.field_force_aeskeycdn = true;
        localf.field_trysafecdn = false;
        ((com.tencent.mm.plugin.scanner.util.p)localObject).hLB.put(str1, local6);
        com.tencent.mm.ak.f.Nd().c(localf);
      }
      this.mController.showTitleView();
      bxZ();
      bxW();
      if (this.nNh.equalsIgnoreCase("zh_CN"))
      {
        this.nMU.setImageResource(R.k.translation_result_chinese);
        this.nMX.setVisibility(0);
        this.nMY.setVisibility(0);
        this.nMT.setVisibility(8);
        this.nIL.setVisibility(0);
        this.nMS.setVisibility(8);
        this.nMW.setVisibility(0);
        this.nMZ.setVisibility(8);
        this.nNe.setRepeatMode(1);
        this.nNe.setRepeatCount(-1);
        this.nNe.start();
        g.Dk().a(294, this);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", localException, "", new Object[0]);
        continue;
        this.nMU.setImageResource(R.k.translation_result_english);
      }
    }
  }
  
  private void byb()
  {
    akJ();
    try
    {
      if ((this.aTk != null) && (this.nIo.isOpen()) && (!this.nIo.jOC))
      {
        y.i("MicroMsg.ScanTranslationCaptureUI", "start preview");
        this.nIo.j(this.aTk);
        this.nMQ.setEnabled(true);
      }
      for (;;)
      {
        this.mController.hideTitleView();
        this.nNl[0] = System.currentTimeMillis();
        this.nIo.cancelAutoFocus();
        this.egr = 0;
        this.nMX.setVisibility(8);
        this.nMY.setVisibility(8);
        this.nMS.setVisibility(0);
        this.nMT.setVisibility(8);
        this.nMW.setVisibility(8);
        this.nMO.setVisibility(0);
        this.nMZ.setVisibility(0);
        this.nIL.setVisibility(8);
        byc();
        g.Dk().b(294, this);
        return;
        y.i("MicroMsg.ScanTranslationCaptureUI", "can not start preview");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.ScanTranslationCaptureUI", localException.getMessage());
        bxA();
      }
    }
  }
  
  private void byc()
  {
    this.nNe.setRepeatMode(1);
    this.nNe.setRepeatCount(0);
    this.nNe.end();
  }
  
  private void goBack()
  {
    com.tencent.mm.plugin.scanner.c.bxd().nGs.ceJ();
    if (this.egr == 0)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(15435, new Object[] { Integer.valueOf(this.fmY[0]), Integer.valueOf(this.fmY[1]), Integer.valueOf(this.fmY[2]), Integer.valueOf(this.fmY[3]), Integer.valueOf(this.fmY[4]), Integer.valueOf(this.fmY[5]), Integer.valueOf(this.fmY[6]), Integer.valueOf(this.fmY[7]), Integer.valueOf(this.fmY[8]) });
      if (this.nNj) {
        y.i("MicroMsg.ScanTranslationCaptureUI", "is playing animation");
      }
    }
    while ((this.egr != 1) && (this.egr != 2) && (this.egr != 3))
    {
      return;
      this.nNf.addListener(new ScanTranslationCaptureUI.7(this));
      this.nNf.reverse();
      this.nNj = true;
      return;
    }
    byb();
  }
  
  private void stopPreview()
  {
    try
    {
      if (this.nIo.jOC)
      {
        com.tencent.mm.plugin.scanner.util.h localh = this.nIo;
        if (localh.dwJ != null)
        {
          localh.dwJ.stopPreview();
          localh.jOC = false;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.ScanTranslationCaptureUI", localException.getMessage());
      bxA();
    }
  }
  
  public final void D(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.fmY[5] = ((int)(System.currentTimeMillis() - this.nNl[1]));
      this.nNb = paramBitmap;
      bxZ();
      this.egr = 3;
      this.nMT.setVisibility(0);
      if (!this.nNh.equalsIgnoreCase("zh_CN")) {
        break label92;
      }
      this.nMU.setImageResource(R.g.translate_chinese_view_source_btn);
    }
    for (;;)
    {
      this.nIL.setVisibility(8);
      byc();
      b(this.nNb, this.nNk);
      return;
      label92:
      this.nMU.setImageResource(R.g.translate_english_view_source_btn);
    }
  }
  
  protected final int getLayoutId()
  {
    return R.i.scan_translate_capture_ui;
  }
  
  protected final void initView()
  {
    this.eYe = findViewById(R.h.root_container);
    this.eYe.setAlpha(0.0F);
    this.nMO = ((MMTextureView)findViewById(R.h.translate_capture_texture_view));
    this.nMO.setOpaque(false);
    this.nMO.setSurfaceTextureListener(this);
    this.nMW = ((ImageView)findViewById(R.h.translate_preivew_picture));
    this.nMS = findViewById(R.h.capture_btn_container);
    this.nMP = findViewById(R.h.scan_translate_close_btn);
    this.nMP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this);
      }
    });
    this.nMQ = findViewById(R.h.scan_capture_btn);
    this.nMQ.setOnClickListener(new ScanTranslationCaptureUI.18(this));
    this.nMQ.setEnabled(false);
    this.nMZ = ((TextView)findViewById(R.h.scan_capture_translate_tip));
    this.nMR = findViewById(R.h.scan_translate_gallery);
    this.nMR.setOnClickListener(new ScanTranslationCaptureUI.19(this));
    this.nMT = findViewById(R.h.save_translate_container);
    this.nMU = ((ImageView)this.nMT.findViewById(R.h.translate_view_source_btn));
    this.nMU.setOnClickListener(new ScanTranslationCaptureUI.20(this));
    this.nMX = findViewById(R.h.translate_top_bg);
    this.nMY = findViewById(R.h.translate_bottom_bg);
    this.mController.hideTitleView();
    setMMTitle(R.l.scan_entry_ocr);
    ta(getResources().getColor(R.e.transparent));
    this.nIL = ((ImageView)findViewById(R.h.scan_line));
    this.nMV = this.nMT.findViewById(R.h.translate_download_btn);
    this.nMV.setOnClickListener(new ScanTranslationCaptureUI.21(this));
    setBackBtn(new ScanTranslationCaptureUI.22(this));
    this.gHS = getWindowManager().getDefaultDisplay().getHeight();
    this.nNe = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.nNe.addListener(new ScanTranslationCaptureUI.23(this));
    this.nNe.addUpdateListener(new ScanTranslationCaptureUI.24(this));
    this.nNe.setDuration(5000L);
    com.tencent.mm.ui.base.b.a(this, null);
    this.eYe.setOnTouchListener(new ScanTranslationCaptureUI.2(this));
    this.nMW.setOnTouchListener(new ScanTranslationCaptureUI.5(this));
    bxW();
    this.nNf = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.nNf.addUpdateListener(new ScanTranslationCaptureUI.3(this));
    this.nNf.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, false);
        ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this).setVisibility(8);
      }
    });
    this.nNf.setDuration(300L);
    lz locallz = new lz();
    locallz.bVf.action = 1;
    com.tencent.mm.sdk.b.a.udP.m(locallz);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 561) && (paramInt2 == -1))
    {
      au.Hx();
      paramIntent = com.tencent.mm.ui.tools.a.g(this, paramIntent, com.tencent.mm.model.c.FG());
      y.i("MicroMsg.ScanTranslationCaptureUI", "select: [%s]", new Object[] { paramIntent });
      if (bk.bl(paramIntent)) {}
    }
    try
    {
      paramInt1 = new ExifInterface(paramIntent).getAttributeInt("Orientation", 1);
      this.eHd = paramIntent;
      this.fmY[0] = 2;
      paramIntent = new BitmapFactory.Options();
      paramIntent.inMutable = true;
      switch (paramInt1)
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        f = 0.0F;
        y.i("MicroMsg.ScanTranslationCaptureUI", "rotate %d, degree %s", new Object[] { Integer.valueOf(paramInt1), Float.valueOf(f) });
        paramIntent.outWidth = this.nMO.getWidth();
        paramIntent.outHeight = this.nMO.getHeight();
        paramIntent = com.tencent.mm.sdk.platformtools.c.decodeFile(this.eHd, paramIntent);
        if (paramIntent != null)
        {
          this.nNa = com.tencent.mm.sdk.platformtools.c.b(paramIntent, f);
          bya();
          this.nNk = false;
          b(this.nNa, false);
        }
        return;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", localIOException, "get exif error", new Object[0]);
        paramInt1 = 1;
        continue;
        float f = 90.0F;
        continue;
        f = 180.0F;
        continue;
        f = 270.0F;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.nIo = new com.tencent.mm.plugin.scanner.util.h(this, 3, false);
    initView();
    com.tencent.mm.sdk.b.a.udP.c(this.nIW);
    this.fmY[0] = 3;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      goBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    y.i("MicroMsg.ScanTranslationCaptureUI", "get preview frame success, length %d", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
    if (paramArrayOfByte != null) {}
    try
    {
      if (paramArrayOfByte.length > 0)
      {
        this.nNa = null;
        long l = System.currentTimeMillis();
        paramCamera = this.nIo.jOD;
        paramArrayOfByte = new YuvImage(paramArrayOfByte, 17, paramCamera.x, paramCamera.y, null);
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        paramArrayOfByte.compressToJpeg(new Rect(0, 0, paramCamera.x, paramCamera.y), 80, localByteArrayOutputStream);
        paramArrayOfByte = com.tencent.mm.sdk.platformtools.c.bu(localByteArrayOutputStream.toByteArray());
        int i = (int)(System.currentTimeMillis() - l);
        if (paramArrayOfByte != null)
        {
          l = System.currentTimeMillis();
          this.nNa = com.tencent.mm.sdk.platformtools.c.b(paramArrayOfByte, this.nIo.jOH);
          y.i("MicroMsg.ScanTranslationCaptureUI", "decode cost %d, rotate cost %d", new Object[] { Integer.valueOf(i), Integer.valueOf((int)(System.currentTimeMillis() - l)) });
          if (this.nNa != null)
          {
            bya();
            this.nNk = true;
            b(this.nNa, true);
          }
        }
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      y.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", paramArrayOfByte, "", new Object[0]);
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.ScanTranslationCaptureUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults len[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt.length), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    do
    {
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        buJ();
        return;
      }
      this.fht = false;
      com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_camera_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new ScanTranslationCaptureUI.13(this), new ScanTranslationCaptureUI.14(this));
      return;
    } while ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0));
    com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_location_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new ScanTranslationCaptureUI.15(this), null);
  }
  
  protected void onResume()
  {
    super.onResume();
    akJ();
    g.Dk().a(294, this);
    if (this.fht)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.CAMERA", 16, null, null);
      y.i("MicroMsg.ScanTranslationCaptureUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        return;
      }
      buJ();
      return;
    }
    bxY();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.ScanTranslationCaptureUI", "errType %s, errCode %s, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.scanner.a.e)paramm).nGT;
      if ((paramString != null) && (((com.tencent.mm.plugin.scanner.a.e)paramm).igH == this.nNg))
      {
        this.fmY[4] = ((int)(System.currentTimeMillis() - this.nNl[2]));
        y.i("MicroMsg.ScanTranslationCaptureUI", "angle %f, translationInfos length %d", new Object[] { Float.valueOf(((com.tencent.mm.plugin.scanner.a.e)paramm).bgU), Integer.valueOf(paramString.size()) });
        if (paramString.size() <= 0) {
          break label314;
        }
        this.fmY[2] = 1;
        n localn = com.tencent.mm.plugin.scanner.c.bxd().nGs;
        paramInt1 = this.nNg;
        float f = ((com.tencent.mm.plugin.scanner.a.e)paramm).bgU;
        Bitmap localBitmap = this.nNa;
        if ((paramInt1 != 0) && (paramString != null) && (paramString.size() > 0) && (this != null))
        {
          if ((localn.nPG != 0) && (paramInt1 != localn.nPG))
          {
            y.i("MicroMsg.ScanTranslationRender", "stop current session %d, start new session %d", new Object[] { Integer.valueOf(localn.nPG), Integer.valueOf(paramInt1) });
            localn.ceJ();
          }
          localn.nPG = paramInt1;
          localn.nPH = this;
          localn.nPI = new n.a(localn, paramInt1, paramString, f, localBitmap);
          localn.nPI.p(new Void[0]);
        }
        if (!bk.bl(((com.tencent.mm.plugin.scanner.a.e)paramm).bxg())) {
          this.nNh = ((com.tencent.mm.plugin.scanner.a.e)paramm).bxg();
        }
      }
      return;
      label314:
      com.tencent.mm.ui.base.h.a(this, getString(R.l.scan_translating_no_result), "", false, new ScanTranslationCaptureUI.16(this));
      return;
    }
    this.fmY[2] = 5;
    paramm = getString(R.l.scan_translating_no_result);
    if (!bk.bl(paramString)) {}
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(this, paramString, "", false, new ScanTranslationCaptureUI.17(this));
      return;
      paramString = paramm;
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    aPC();
    g.Dk().b(294, this);
    com.tencent.mm.sdk.b.a.udP.d(this.nIW);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.ScanTranslationCaptureUI", "surface texture available");
    this.nMO.cBe();
    this.aTk = paramSurfaceTexture;
    if (this.fht)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.CAMERA", 16, null, null);
      y.i("MicroMsg.ScanTranslationCaptureUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        return;
      }
      buJ();
      return;
    }
    if (!this.nIo.isOpen())
    {
      bxX();
      return;
    }
    byb();
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI
 * JD-Core Version:    0.7.0.1
 */