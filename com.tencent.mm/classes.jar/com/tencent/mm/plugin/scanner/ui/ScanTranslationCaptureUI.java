package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.PreviewCallback;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.g.b.a.be;
import com.tencent.mm.g.c.fb;
import com.tencent.mm.model.u;
import com.tencent.mm.network.n.a;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.scanner.PluginScanTranslation;
import com.tencent.mm.plugin.scanner.model.aa;
import com.tencent.mm.plugin.scanner.util.j;
import com.tencent.mm.plugin.scanner.util.j.b;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.scanner.util.m.a;
import com.tencent.mm.plugin.scanner.util.m.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class ScanTranslationCaptureUI
  extends MMActivity
  implements Camera.PreviewCallback, TextureView.SurfaceTextureListener, com.tencent.mm.al.g, j.b
{
  private int dep;
  private int gXt;
  private int guD;
  private String hzF;
  private View ics;
  private boolean imk;
  private int kvo;
  private com.tencent.mm.network.n qgB;
  private ImageView qgw;
  private ValueAnimator qgz;
  private String rTR;
  private SurfaceTexture surfaceTexture;
  private MMTextureView vTW;
  private com.tencent.mm.plugin.scanner.a.a vTX;
  private View vTY;
  private View vTZ;
  private View vUa;
  private View vUb;
  private View vUc;
  private ImageView vUd;
  private View vUe;
  private View vUf;
  private View vUg;
  private TextView vUh;
  private Bitmap vUi;
  private Bitmap vUj;
  private String vUk;
  private a vUl;
  private MMGestureGallery vUm;
  private ValueAnimator vUn;
  private int vUo;
  private String vUp;
  private boolean vUq;
  private int vUr;
  private be vUs;
  private long[] vUt;
  private c<oc> vUu;
  
  public ScanTranslationCaptureUI()
  {
    AppMethodBeat.i(120893);
    this.imk = true;
    this.vUr = 0;
    this.dep = 0;
    this.guD = 0;
    this.vUs = new be();
    this.vUt = new long[2];
    this.vUu = new c() {};
    this.qgB = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(120878);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(120877);
            if ((com.tencent.mm.kernel.g.aeS().auR() != 6) && (com.tencent.mm.kernel.g.aeS().auR() != 4) && (ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) == 1))
            {
              com.tencent.mm.ui.base.h.c(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(2131762844), "", true);
              ScanTranslationCaptureUI.f(ScanTranslationCaptureUI.this);
            }
            AppMethodBeat.o(120877);
          }
        });
        AppMethodBeat.o(120878);
      }
    };
    AppMethodBeat.o(120893);
  }
  
  private void ab(Bitmap paramBitmap)
  {
    AppMethodBeat.i(120920);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(120920);
      return;
    }
    this.vUl.bitmap = paramBitmap;
    this.vUl.notifyDataSetChanged();
    AppMethodBeat.o(120920);
  }
  
  private void anq()
  {
    AppMethodBeat.i(120905);
    try
    {
      stopPreview();
      this.vTX.close();
      AppMethodBeat.o(120905);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ScanTranslationCaptureUI", localException.getMessage());
      AppMethodBeat.o(120905);
    }
  }
  
  private void bcC()
  {
    AppMethodBeat.i(120911);
    getWindow().addFlags(2097280);
    int i = 1798;
    if (Build.VERSION.SDK_INT >= 19) {
      i = 5894;
    }
    getWindow().getDecorView().setSystemUiVisibility(i);
    AppMethodBeat.o(120911);
  }
  
  private void cjk()
  {
    AppMethodBeat.i(120913);
    stopPreview();
    if ((com.tencent.mm.kernel.g.aeS().auR() != 6) && (com.tencent.mm.kernel.g.aeS().auR() != 4))
    {
      com.tencent.mm.ui.base.h.c(this, getString(2131762844), "", true);
      dmn();
      AppMethodBeat.o(120913);
      return;
    }
    this.vUs.dMH = 2L;
    this.vUo = ((int)(u.aqG().hashCode() + System.currentTimeMillis() & 0xFFFFFFFF));
    this.gXt = 1;
    showTitleView();
    dmm();
    dmi();
    if (this.vUp.equalsIgnoreCase("zh_CN"))
    {
      this.vUd.setImageResource(2131691335);
      this.vUf.setVisibility(0);
      this.vUg.setVisibility(0);
      this.vUc.setVisibility(8);
      this.qgw.setVisibility(0);
      this.vUb.setVisibility(8);
      this.vUm.setVisibility(0);
      this.vUh.setVisibility(8);
      this.qgz.setRepeatMode(1);
      this.qgz.setRepeatCount(-1);
      this.qgz.start();
    }
    try
    {
      if ((bt.isNullOrNil(this.hzF)) || (this.vUi == null)) {
        break label368;
      }
      this.rTR = m.amP(this.hzF);
      str2 = this.hzF;
      if (this.dep != 0) {
        break label398;
      }
      l = System.currentTimeMillis();
      com.tencent.mm.sdk.platformtools.f.a(this.vUi, 80, Bitmap.CompressFormat.JPEG, this.hzF, false);
      ad.i("MicroMsg.ScanTranslationCaptureUI", "save img cost %d", new Object[] { Integer.valueOf((int)(System.currentTimeMillis() - l)) });
      ad.i("MicroMsg.ScanTranslationCaptureUI", "fileSize %d", new Object[] { Long.valueOf(i.aMN(this.hzF)) });
      localObject = str2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2;
        long l;
        Object localObject;
        label325:
        label368:
        ad.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", localException, "", new Object[0]);
        label398:
        continue;
        ad.w("MicroMsg.ScanTranslationCaptureUI", "can not find old translation result!");
        String str1 = str2;
        if (this.guD != 0)
        {
          l = System.currentTimeMillis();
          str1 = ((com.tencent.mm.plugin.scanner.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.scanner.d.class)).genScanTmpImgPath("jpg");
          com.tencent.mm.sdk.platformtools.f.a(this.vUi, 80, Bitmap.CompressFormat.JPEG, str1, false);
          ad.i("MicroMsg.ScanTranslationCaptureUI", "save img cost %d", new Object[] { Integer.valueOf((int)(System.currentTimeMillis() - l)) });
          ad.i("MicroMsg.ScanTranslationCaptureUI", "fileSize %d", new Object[] { Long.valueOf(i.aMN(str1)) });
        }
      }
    }
    this.vUt[1] = System.currentTimeMillis();
    ((com.tencent.mm.plugin.scanner.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.scanner.d.class)).getScanCdnService().a(this.rTR, (String)localObject, com.tencent.mm.i.a.MediaType_IMAGE, new m.a()
    {
      public final void a(String paramAnonymousString, m.b paramAnonymousb)
      {
        AppMethodBeat.i(120873);
        if ((!bt.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(ScanTranslationCaptureUI.w(ScanTranslationCaptureUI.this))))
        {
          ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).dOz = ((int)(System.currentTimeMillis() - ScanTranslationCaptureUI.i(ScanTranslationCaptureUI.this)[1]));
          ad.i("MicroMsg.ScanTranslationCaptureUI", "upload img cost %d", new Object[] { Long.valueOf(ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).dOz) });
          switch (paramAnonymousb.errCode)
          {
          }
        }
        for (;;)
        {
          if ((ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) == 1) && (ScanTranslationCaptureUI.y(ScanTranslationCaptureUI.this) != 0))
          {
            ad.i("delete tmp path %s", this.vLv);
            i.deleteFile(this.vLv);
          }
          AppMethodBeat.o(120873);
          return;
          if (!bt.T(new String[] { paramAnonymousb.fileId, paramAnonymousb.aeskey }))
          {
            ad.i("MicroMsg.ScanTranslationCaptureUI", "fileId %s", new Object[] { paramAnonymousb.fileId });
            paramAnonymousString = new com.tencent.mm.plugin.scanner.model.h(ScanTranslationCaptureUI.x(ScanTranslationCaptureUI.this), (int)i.aMN(this.vLv), paramAnonymousb.fileId, paramAnonymousb.aeskey);
            com.tencent.mm.kernel.g.aeS().a(paramAnonymousString, 0);
          }
          else
          {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(120870);
                ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).dMH = 3L;
                com.tencent.mm.ui.base.h.cf(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(2131762880));
                AppMethodBeat.o(120870);
              }
            });
            continue;
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(120872);
                com.tencent.mm.ui.base.h.d(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(2131759055), ScanTranslationCaptureUI.this.getString(2131755906), new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(120871);
                    ScanTranslationCaptureUI.f(ScanTranslationCaptureUI.this);
                    AppMethodBeat.o(120871);
                  }
                });
                AppMethodBeat.o(120872);
              }
            });
            ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).dMH = 3L;
          }
        }
      }
    });
    for (;;)
    {
      com.tencent.mm.kernel.g.aeS().a(294, this);
      AppMethodBeat.o(120913);
      return;
      this.vUd.setImageResource(2131691338);
      break;
      localObject = str2;
      if (this.dep != 1) {
        break label325;
      }
      localObject = com.tencent.mm.sdk.platformtools.ai.du(this.hzF + i.aMO(this.hzF));
      localObject = ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationResultStorage().amC((String)localObject);
      if (localObject == null) {
        break label544;
      }
      ad.i("MicroMsg.ScanTranslationCaptureUI", "already has translation result");
      this.vUk = ((fb)localObject).field_resultFile;
      this.vUj = com.tencent.mm.sdk.platformtools.f.decodeFile(this.vUk, new BitmapFactory.Options());
      if (this.vUj == null) {
        break label536;
      }
      aq.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(120869);
          ScanTranslationCaptureUI.v(ScanTranslationCaptureUI.this);
          ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.n(ScanTranslationCaptureUI.this));
          AppMethodBeat.o(120869);
        }
      }, 500L);
    }
  }
  
  private void cjn()
  {
    AppMethodBeat.i(120916);
    this.qgz.setRepeatMode(1);
    this.qgz.setRepeatCount(0);
    this.qgz.end();
    AppMethodBeat.o(120916);
  }
  
  private void dfj()
  {
    AppMethodBeat.i(120903);
    if (!com.tencent.mm.compatible.d.b.XC())
    {
      com.tencent.mm.ui.base.h.a(this, getString(2131755900), getString(2131755825), getString(2131755826), true, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(120875);
          com.tencent.mm.compatible.d.b.bY(ScanTranslationCaptureUI.this);
          ScanTranslationCaptureUI.this.finish();
          AppMethodBeat.o(120875);
        }
      });
      AppMethodBeat.o(120903);
      return;
    }
    dml();
    AppMethodBeat.o(120903);
  }
  
  private void dmi()
  {
    AppMethodBeat.i(120896);
    ac.eFu().equalsIgnoreCase("zh_CN");
    this.vUp = ac.ir(this);
    ad.i("MicroMsg.ScanTranslationCaptureUI", "targetLang %s", new Object[] { this.vUp });
    AppMethodBeat.o(120896);
  }
  
  private void dmj()
  {
    AppMethodBeat.i(120904);
    try
    {
      if (!this.vTX.isOpen())
      {
        long l = System.currentTimeMillis();
        this.vTX.abO(getWindowManager().getDefaultDisplay().getRotation());
        this.vTX.a(new Camera.PreviewCallback()
        {
          public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera) {}
        });
        ad.i("MicroMsg.ScanTranslationCaptureUI", "open camera cost %s, failed count %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(this.vUr) });
        this.vTX.dlg();
        Rect localRect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
        this.vTX.j(new Point(localRect.width(), localRect.height()));
        if (this.gXt == 0) {
          dmn();
        }
        this.vUr = 0;
      }
      AppMethodBeat.o(120904);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ScanTranslationCaptureUI", localException.getMessage());
      this.vUr += 1;
      if (this.vUr >= 5)
      {
        dmk();
        AppMethodBeat.o(120904);
        return;
      }
      aq.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(120876);
          ScanTranslationCaptureUI.A(ScanTranslationCaptureUI.this);
          AppMethodBeat.o(120876);
        }
      }, 30L);
      AppMethodBeat.o(120904);
    }
  }
  
  private void dmk()
  {
    AppMethodBeat.i(120908);
    com.tencent.mm.ui.base.h.a(this, getString(2131762855), getString(2131755906), false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(120879);
        ScanTranslationCaptureUI.z(ScanTranslationCaptureUI.this);
        ScanTranslationCaptureUI.this.finish();
        ScanTranslationCaptureUI.this.overridePendingTransition(0, 0);
        AppMethodBeat.o(120879);
      }
    });
    AppMethodBeat.o(120908);
  }
  
  private void dml()
  {
    AppMethodBeat.i(120909);
    ad.i("MicroMsg.ScanTranslationCaptureUI", "curState %d", new Object[] { Integer.valueOf(this.gXt) });
    if (!this.vTX.isOpen()) {
      dmj();
    }
    if ((this.gXt == 0) && (this.vTX.isOpen())) {
      dmn();
    }
    AppMethodBeat.o(120909);
  }
  
  private void dmm()
  {
    AppMethodBeat.i(120912);
    getController().setNavigationbarColor(getResources().getColor(2131101053));
    getWindow().getDecorView().setSystemUiVisibility(1796);
    AppMethodBeat.o(120912);
  }
  
  private void dmn()
  {
    AppMethodBeat.i(120914);
    bcC();
    startPreview();
    hideTitleView();
    this.vUt[0] = System.currentTimeMillis();
    if ((this.dep == 0) && (!bt.isNullOrNil(this.hzF))) {
      i.deleteFile(this.hzF);
    }
    this.gXt = 0;
    this.dep = 0;
    this.hzF = null;
    this.vUk = null;
    this.vUi = null;
    this.vUj = null;
    this.guD = 0;
    this.vUf.setVisibility(8);
    this.vUg.setVisibility(8);
    this.vUb.setVisibility(0);
    this.vUc.setVisibility(8);
    this.vUm.setVisibility(8);
    this.vTW.setVisibility(0);
    this.vUh.setVisibility(0);
    this.qgw.setVisibility(8);
    cjn();
    com.tencent.mm.kernel.g.aeS().b(294, this);
    AppMethodBeat.o(120914);
  }
  
  private void dmo()
  {
    AppMethodBeat.i(120915);
    dmm();
    this.gXt = 3;
    this.vUc.setVisibility(0);
    if (this.vUp.equalsIgnoreCase("zh_CN")) {
      this.vUd.setImageResource(2131234422);
    }
    for (;;)
    {
      this.qgw.setVisibility(8);
      cjn();
      if ((this.dep != 1) || (!bt.isNullOrNil(this.vUk))) {
        break label234;
      }
      this.vUk = ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).genTranslationResultImgPath("jpg");
      try
      {
        com.tencent.mm.sdk.platformtools.f.a(this.vUj, 80, Bitmap.CompressFormat.JPEG, this.vUk, false);
        aa localaa = new aa();
        localaa.field_originMD5 = com.tencent.mm.sdk.platformtools.ai.du(this.hzF + i.aMO(this.hzF));
        localaa.field_resultFile = this.vUk;
        ad.i("MicroMsg.ScanTranslationCaptureUI", "insert translate result %s", new Object[] { this.vUk });
        ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationResultStorage().a(localaa);
        AppMethodBeat.o(120915);
        return;
      }
      catch (IOException localIOException)
      {
        ad.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", localIOException, "save translate result file error", new Object[0]);
      }
      this.vUd.setImageResource(2131234424);
    }
    label234:
    AppMethodBeat.o(120915);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(120902);
    ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationRender().dnk();
    if (this.gXt == 0)
    {
      if (this.vUq)
      {
        ad.i("MicroMsg.ScanTranslationCaptureUI", "is playing animation");
        AppMethodBeat.o(120902);
        return;
      }
      this.vUn.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(120874);
          paramAnonymousAnimator = new oc();
          paramAnonymousAnimator.dtl.action = 3;
          com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousAnimator);
          ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, false);
          ScanTranslationCaptureUI.z(ScanTranslationCaptureUI.this);
          ScanTranslationCaptureUI.this.finish();
          AppMethodBeat.o(120874);
        }
      });
      this.vUn.reverse();
      this.vUq = true;
      AppMethodBeat.o(120902);
      return;
    }
    if ((this.gXt == 1) || (this.gXt == 2) || (this.gXt == 3))
    {
      if (this.gXt == 1) {
        this.vUs.dOB = ((int)(System.currentTimeMillis() - this.vUt[1]));
      }
      if (this.vUs.dMH != 0L) {
        this.vUs.aBj();
      }
      dmn();
    }
    AppMethodBeat.o(120902);
  }
  
  private void startPreview()
  {
    AppMethodBeat.i(120907);
    try
    {
      if ((this.surfaceTexture != null) && (this.vTX.isOpen()) && (!this.vTX.cPP()))
      {
        ad.i("MicroMsg.ScanTranslationCaptureUI", "start preview");
        this.vTX.p(this.surfaceTexture);
        this.vTZ.setEnabled(true);
        AppMethodBeat.o(120907);
        return;
      }
      ad.i("MicroMsg.ScanTranslationCaptureUI", "can not start preview");
      AppMethodBeat.o(120907);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ScanTranslationCaptureUI", localException.getMessage());
      dmk();
      AppMethodBeat.o(120907);
    }
  }
  
  private void stopPreview()
  {
    AppMethodBeat.i(120906);
    try
    {
      if (this.vTX.cPP()) {
        this.vTX.stopPreview();
      }
      AppMethodBeat.o(120906);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ScanTranslationCaptureUI", localException.getMessage());
      AppMethodBeat.o(120906);
    }
  }
  
  public final void c(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(120921);
    if ((paramBitmap != null) && (paramInt == this.vUo))
    {
      this.vUs.dOB = ((int)(System.currentTimeMillis() - this.vUt[1]));
      this.vUj = paramBitmap;
      dmo();
      ab(this.vUj);
    }
    AppMethodBeat.o(120921);
  }
  
  public int getLayoutId()
  {
    return 2131495306;
  }
  
  public void initView()
  {
    AppMethodBeat.i(120895);
    this.ics = findViewById(2131304241);
    this.ics.setAlpha(0.0F);
    this.vTW = ((MMTextureView)findViewById(2131306072));
    this.vTW.setOpaque(false);
    this.vTW.setSurfaceTextureListener(this);
    this.vUm = ((MMGestureGallery)findViewById(2131306074));
    this.vUl = new a((byte)0);
    this.vUm.setAdapter(this.vUl);
    this.vUb = findViewById(2131297700);
    this.vTY = findViewById(2131304340);
    this.vTY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120884);
        ScanTranslationCaptureUI.g(ScanTranslationCaptureUI.this);
        AppMethodBeat.o(120884);
      }
    });
    this.vTZ = findViewById(2131304307);
    this.vTZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120885);
        ScanTranslationCaptureUI.h(ScanTranslationCaptureUI.this).a(ScanTranslationCaptureUI.this);
        ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).dOy = ((int)(System.currentTimeMillis() - ScanTranslationCaptureUI.i(ScanTranslationCaptureUI.this)[0]));
        ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).dMB = 1L;
        AppMethodBeat.o(120885);
      }
    });
    this.vTZ.setEnabled(false);
    this.vUh = ((TextView)findViewById(2131304308));
    this.vUa = findViewById(2131304341);
    this.vUa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120886);
        com.tencent.mm.pluginsdk.ui.tools.q.a(ScanTranslationCaptureUI.this, 561, 1, 0, 1, null);
        AppMethodBeat.o(120886);
      }
    });
    this.vUc = findViewById(2131304289);
    this.vUd = ((ImageView)this.vUc.findViewById(2131306078));
    this.vUd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120887);
        if (ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) == 3)
        {
          if (ScanTranslationCaptureUI.k(ScanTranslationCaptureUI.this) != null) {
            ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.k(ScanTranslationCaptureUI.this));
          }
          if (ScanTranslationCaptureUI.l(ScanTranslationCaptureUI.this).equalsIgnoreCase("zh_CN")) {
            ScanTranslationCaptureUI.m(ScanTranslationCaptureUI.this).setImageResource(2131691336);
          }
          for (;;)
          {
            ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, 2);
            ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).dOC += 1L;
            AppMethodBeat.o(120887);
            return;
            ScanTranslationCaptureUI.m(ScanTranslationCaptureUI.this).setImageResource(2131691339);
          }
        }
        if (ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) == 2)
        {
          if (ScanTranslationCaptureUI.n(ScanTranslationCaptureUI.this) != null) {
            ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.n(ScanTranslationCaptureUI.this));
          }
          if (!ScanTranslationCaptureUI.l(ScanTranslationCaptureUI.this).equalsIgnoreCase("zh_CN")) {
            break label196;
          }
          ScanTranslationCaptureUI.m(ScanTranslationCaptureUI.this).setImageResource(2131234422);
        }
        for (;;)
        {
          ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, 3);
          AppMethodBeat.o(120887);
          return;
          label196:
          ScanTranslationCaptureUI.m(ScanTranslationCaptureUI.this).setImageResource(2131234424);
        }
      }
    });
    this.vUf = findViewById(2131306077);
    this.vUg = findViewById(2131306071);
    hideTitleView();
    setMMTitle(2131762808);
    setActionbarColor(getResources().getColor(2131101053));
    this.qgw = ((ImageView)findViewById(2131304314));
    this.vUe = this.vUc.findViewById(2131306073);
    this.vUe.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120888);
        if (ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) == 2) {
          try
          {
            ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).dOE = 1L;
            p.a(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.o(ScanTranslationCaptureUI.this), new p.a()
            {
              public final void bv(String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(190948);
                com.tencent.mm.ui.widget.snackbar.b.n(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(2131762883));
                AppMethodBeat.o(190948);
              }
              
              public final void bw(String paramAnonymous2String1, String paramAnonymous2String2) {}
            });
            AppMethodBeat.o(120888);
            return;
          }
          catch (Exception paramAnonymousView)
          {
            ad.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", paramAnonymousView, "copy to gallery error", new Object[0]);
            AppMethodBeat.o(120888);
            return;
          }
        }
        if (ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) == 3) {
          try
          {
            ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).dOD = 1L;
            int i = ScanTranslationCaptureUI.p(ScanTranslationCaptureUI.this);
            if (i == 0) {}
            try
            {
              ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).genTranslationResultImgPath("jpg"));
              com.tencent.mm.sdk.platformtools.f.a(ScanTranslationCaptureUI.n(ScanTranslationCaptureUI.this), 80, Bitmap.CompressFormat.JPEG, ScanTranslationCaptureUI.q(ScanTranslationCaptureUI.this), false);
              p.a(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.q(ScanTranslationCaptureUI.this), new p.a()
              {
                public final void bv(String paramAnonymous2String1, String paramAnonymous2String2)
                {
                  AppMethodBeat.i(190949);
                  com.tencent.mm.ui.widget.snackbar.b.n(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(2131762883));
                  AppMethodBeat.o(190949);
                }
                
                public final void bw(String paramAnonymous2String1, String paramAnonymous2String2) {}
              });
              AppMethodBeat.o(120888);
              return;
            }
            catch (IOException paramAnonymousView)
            {
              for (;;)
              {
                ad.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", paramAnonymousView, "save translate result file error", new Object[0]);
              }
            }
            AppMethodBeat.o(120888);
          }
          catch (Exception paramAnonymousView)
          {
            ad.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", paramAnonymousView, "save to gallery error", new Object[0]);
          }
        }
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(120889);
        ScanTranslationCaptureUI.g(ScanTranslationCaptureUI.this);
        AppMethodBeat.o(120889);
        return true;
      }
    });
    this.kvo = getWindowManager().getDefaultDisplay().getHeight();
    this.qgz = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.qgz.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(120891);
        ScanTranslationCaptureUI.r(ScanTranslationCaptureUI.this).setAlpha(0.0F);
        AppMethodBeat.o(120891);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(120890);
        ScanTranslationCaptureUI.r(ScanTranslationCaptureUI.this).setAlpha(0.0F);
        AppMethodBeat.o(120890);
      }
    });
    this.qgz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(120864);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f <= 0.1F) {
          ScanTranslationCaptureUI.r(ScanTranslationCaptureUI.this).setAlpha(f * 10.0F);
        }
        for (;;)
        {
          ScanTranslationCaptureUI.r(ScanTranslationCaptureUI.this).setTranslationY(f * (ScanTranslationCaptureUI.s(ScanTranslationCaptureUI.this) - ScanTranslationCaptureUI.r(ScanTranslationCaptureUI.this).getHeight()));
          AppMethodBeat.o(120864);
          return;
          if (f >= 0.9F) {
            ScanTranslationCaptureUI.r(ScanTranslationCaptureUI.this).setAlpha((1.0F - f) * 10.0F);
          }
        }
      }
    });
    Object localObject = (RelativeLayout.LayoutParams)this.vUc.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin += com.tencent.mm.ui.ai.eb(this);
    this.vUc.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.qgz.setDuration(5000L);
    com.tencent.mm.ui.base.b.a(this, null);
    this.ics.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(120866);
        if ((ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) == 0) && (paramAnonymousView == ScanTranslationCaptureUI.b(ScanTranslationCaptureUI.this)))
        {
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            ad.i("MicroMsg.ScanTranslationCaptureUI", "event down, (%f, %f)", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getX()), Float.valueOf(paramAnonymousMotionEvent.getY()) });
            float f1 = paramAnonymousMotionEvent.getX() / ScanTranslationCaptureUI.b(ScanTranslationCaptureUI.this).getWidth();
            float f2 = paramAnonymousMotionEvent.getY() / ScanTranslationCaptureUI.b(ScanTranslationCaptureUI.this).getHeight();
            ScanTranslationCaptureUI.h(ScanTranslationCaptureUI.this).a(f1, f2, new Camera.AutoFocusCallback()
            {
              public final void onAutoFocus(boolean paramAnonymous2Boolean, Camera paramAnonymous2Camera)
              {
                AppMethodBeat.i(120865);
                ad.i("MicroMsg.ScanTranslationCaptureUI", "camera auto focus call back");
                ScanTranslationCaptureUI.h(ScanTranslationCaptureUI.this).cancelAutoFocus();
                ScanTranslationCaptureUI.h(ScanTranslationCaptureUI.this).dlg();
                AppMethodBeat.o(120865);
              }
            });
          }
          AppMethodBeat.o(120866);
          return true;
        }
        AppMethodBeat.o(120866);
        return false;
      }
    });
    dmi();
    this.vUn = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.vUn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(120867);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        int i = ScanTranslationCaptureUI.t(ScanTranslationCaptureUI.this).getHeight();
        i = ((RelativeLayout.LayoutParams)ScanTranslationCaptureUI.t(ScanTranslationCaptureUI.this).getLayoutParams()).bottomMargin + i;
        ScanTranslationCaptureUI.t(ScanTranslationCaptureUI.this).setTranslationY(i * f);
        int j = ScanTranslationCaptureUI.u(ScanTranslationCaptureUI.this).getHeight();
        int k = ((RelativeLayout.LayoutParams)ScanTranslationCaptureUI.u(ScanTranslationCaptureUI.this).getLayoutParams()).bottomMargin;
        ScanTranslationCaptureUI.u(ScanTranslationCaptureUI.this).setTranslationY((k + (j + i)) * f);
        AppMethodBeat.o(120867);
      }
    });
    this.vUn.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(120868);
        ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, false);
        ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this).setVisibility(8);
        AppMethodBeat.o(120868);
      }
    });
    this.vUn.setDuration(300L);
    localObject = new oc();
    ((oc)localObject).dtl.action = 1;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    AppMethodBeat.o(120895);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(120922);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 561) && (paramInt2 == -1))
    {
      paramIntent = com.tencent.mm.ui.tools.a.i(this, paramIntent, com.tencent.mm.plugin.image.d.apW());
      ad.i("MicroMsg.ScanTranslationCaptureUI", "select: [%s]", new Object[] { paramIntent });
      if (!bt.isNullOrNil(paramIntent))
      {
        this.hzF = paramIntent;
        this.dep = 1;
        this.vUs.dMB = 2L;
        this.guD = Exif.fromFile(paramIntent).getOrientationInDegree();
        ad.i("MicroMsg.ScanTranslationCaptureUI", "degree %s", new Object[] { Integer.valueOf(this.guD) });
        paramIntent = com.tencent.mm.sdk.platformtools.f.aFj(paramIntent);
        if (paramIntent != null)
        {
          this.vUi = com.tencent.mm.sdk.platformtools.f.a(paramIntent, this.guD);
          cjk();
          ab(this.vUi);
        }
      }
    }
    AppMethodBeat.o(120922);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(120894);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    this.vTX = new com.tencent.mm.plugin.scanner.a.a();
    initView();
    com.tencent.mm.sdk.b.a.ESL.c(this.vUu);
    this.vUs.dMB = 3L;
    AppMethodBeat.o(120894);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(120901);
    super.onDestroy();
    this.vUn.removeAllUpdateListeners();
    this.qgz.removeAllUpdateListeners();
    AppMethodBeat.o(120901);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(120899);
    if (paramInt == 4)
    {
      goBack();
      AppMethodBeat.o(120899);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(120899);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(120898);
    super.onPause();
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    AppMethodBeat.o(120898);
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(120918);
    ad.i("MicroMsg.ScanTranslationCaptureUI", "get preview frame success, length %d", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
    if (paramArrayOfByte != null) {}
    try
    {
      if (paramArrayOfByte.length > 0)
      {
        this.vUi = null;
        long l = System.currentTimeMillis();
        paramCamera = this.vTX.fmC();
        paramArrayOfByte = new YuvImage(paramArrayOfByte, 17, paramCamera.x, paramCamera.y, null);
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        paramArrayOfByte.compressToJpeg(new Rect(0, 0, paramCamera.x, paramCamera.y), 100, localByteArrayOutputStream);
        paramArrayOfByte = com.tencent.mm.sdk.platformtools.f.cl(localByteArrayOutputStream.toByteArray());
        int i = (int)(System.currentTimeMillis() - l);
        if (paramArrayOfByte != null)
        {
          l = System.currentTimeMillis();
          this.vUi = com.tencent.mm.sdk.platformtools.f.a(paramArrayOfByte, this.vTX.getCameraRotation());
          ad.i("MicroMsg.ScanTranslationCaptureUI", "decode cost %d, rotate cost %d", new Object[] { Integer.valueOf(i), Integer.valueOf((int)(System.currentTimeMillis() - l)) });
          if (this.vUi != null)
          {
            this.hzF = ((com.tencent.mm.plugin.scanner.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.scanner.d.class)).genScanCaptureImgPath("jpg");
            cjk();
            ab(this.vUi);
          }
        }
      }
      AppMethodBeat.o(120918);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ad.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(120918);
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(120910);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ad.i("MicroMsg.ScanTranslationCaptureUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(120910);
      return;
    }
    ad.i("MicroMsg.ScanTranslationCaptureUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(120910);
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        dfj();
        AppMethodBeat.o(120910);
        return;
      }
      this.imk = false;
      com.tencent.mm.ui.base.h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(120880);
          paramAnonymousDialogInterface = ScanTranslationCaptureUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$21", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$21", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ScanTranslationCaptureUI.B(ScanTranslationCaptureUI.this);
          ScanTranslationCaptureUI.this.finish();
          AppMethodBeat.o(120880);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(120881);
          ScanTranslationCaptureUI.B(ScanTranslationCaptureUI.this);
          ScanTranslationCaptureUI.this.finish();
          AppMethodBeat.o(120881);
        }
      });
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(120897);
    super.onResume();
    com.tencent.mm.plugin.ball.f.f.d(true, true, true);
    bcC();
    com.tencent.mm.kernel.g.aeS().a(294, this);
    com.tencent.mm.kernel.g.afA().a(this.qgB);
    if (this.imk)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null);
      ad.i("MicroMsg.ScanTranslationCaptureUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(120897);
        return;
      }
      dfj();
      AppMethodBeat.o(120897);
      return;
    }
    dml();
    AppMethodBeat.o(120897);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(120919);
    ad.i("MicroMsg.ScanTranslationCaptureUI", "errType %s, errCode %s, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.scanner.model.h)paramn).vOA;
      if ((paramString != null) && (((com.tencent.mm.plugin.scanner.model.h)paramn).dcS == this.vUo))
      {
        this.vUs.dOA = ((int)(System.currentTimeMillis() - ((com.tencent.mm.plugin.scanner.model.h)paramn).vOB));
        ad.i("MicroMsg.ScanTranslationCaptureUI", "angle %f, translationInfos length %d", new Object[] { Float.valueOf(((com.tencent.mm.plugin.scanner.model.h)paramn).angle), Integer.valueOf(paramString.size()) });
        if (paramString.size() > 0)
        {
          this.vUs.dMH = 1L;
          ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationRender().a(this.vUo, paramString, ((com.tencent.mm.plugin.scanner.model.h)paramn).angle, this.vUi, this);
          if (!bt.isNullOrNil(((com.tencent.mm.plugin.scanner.model.h)paramn).dlt()))
          {
            this.vUp = ((com.tencent.mm.plugin.scanner.model.h)paramn).dlt();
            AppMethodBeat.o(120919);
          }
        }
        else
        {
          this.vUs.dOB = ((int)(System.currentTimeMillis() - this.vUt[1]));
          com.tencent.mm.ui.base.h.a(this, getString(2131762880), "", false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(120882);
              ScanTranslationCaptureUI.f(ScanTranslationCaptureUI.this);
              AppMethodBeat.o(120882);
            }
          });
        }
      }
      AppMethodBeat.o(120919);
      return;
    }
    this.vUs.dMH = 5L;
    this.vUs.dOB = ((int)(System.currentTimeMillis() - this.vUt[1]));
    paramn = getString(2131762880);
    if (!bt.isNullOrNil(paramString)) {}
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(this, paramString, "", false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(120883);
          ScanTranslationCaptureUI.f(ScanTranslationCaptureUI.this);
          AppMethodBeat.o(120883);
        }
      });
      AppMethodBeat.o(120919);
      return;
      paramString = paramn;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(120900);
    super.onStop();
    anq();
    com.tencent.mm.kernel.g.aeS().b(294, this);
    com.tencent.mm.sdk.b.a.ESL.d(this.vUu);
    com.tencent.mm.kernel.g.afA().b(this.qgB);
    AppMethodBeat.o(120900);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(120917);
    ad.i("MicroMsg.ScanTranslationCaptureUI", "surface texture available");
    this.vTW.eTg();
    this.surfaceTexture = paramSurfaceTexture;
    if (this.imk)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null);
      ad.i("MicroMsg.ScanTranslationCaptureUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(120917);
        return;
      }
      dfj();
      AppMethodBeat.o(120917);
      return;
    }
    if (!this.vTX.isOpen())
    {
      dmj();
      AppMethodBeat.o(120917);
      return;
    }
    dmn();
    AppMethodBeat.o(120917);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    Bitmap bitmap;
    
    private a() {}
    
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
      AppMethodBeat.i(120892);
      if (paramView == null)
      {
        paramView = new MultiTouchImageView(ScanTranslationCaptureUI.this, 0, 0, (byte)0);
        paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
      }
      for (;;)
      {
        if (this.bitmap != null)
        {
          paramView.setImageBitmap(this.bitmap);
          paramView.cH(this.bitmap.getWidth(), this.bitmap.getHeight());
          paramView.eSz();
        }
        AppMethodBeat.o(120892);
        return paramView;
        paramView = (MultiTouchImageView)paramView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI
 * JD-Core Version:    0.7.0.1
 */