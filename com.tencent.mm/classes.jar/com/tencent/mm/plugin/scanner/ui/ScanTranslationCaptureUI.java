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
import com.tencent.mm.g.a.ov;
import com.tencent.mm.g.b.a.dm;
import com.tencent.mm.g.c.fp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.network.n.a;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.scanner.PluginScanTranslation;
import com.tencent.mm.plugin.scanner.model.ag;
import com.tencent.mm.plugin.scanner.model.k;
import com.tencent.mm.plugin.scanner.util.j;
import com.tencent.mm.plugin.scanner.util.j.b;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.scanner.util.m.a;
import com.tencent.mm.plugin.scanner.util.m.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class ScanTranslationCaptureUI
  extends MMActivity
  implements Camera.PreviewCallback, TextureView.SurfaceTextureListener, com.tencent.mm.ak.f, j.b
{
  private int doj;
  private int hTf;
  private int hpY;
  private View iYE;
  private String iwv;
  private boolean jit;
  private int lya;
  private ImageView rHi;
  private ValueAnimator rHl;
  private com.tencent.mm.network.n rHn;
  private SurfaceTexture surfaceTexture;
  private String ukB;
  private MMTextureView yIJ;
  private com.tencent.mm.plugin.scanner.a.a yIK;
  private View yIL;
  private View yIM;
  private View yIN;
  private View yIO;
  private View yIP;
  private ImageView yIQ;
  private View yIR;
  private View yIS;
  private View yIT;
  private TextView yIU;
  private Bitmap yIV;
  private Bitmap yIW;
  private String yIX;
  private a yIY;
  private MMGestureGallery yIZ;
  private ValueAnimator yJa;
  private int yJb;
  private String yJc;
  private boolean yJd;
  private int yJe;
  private dm yJf;
  private long[] yJg;
  private c<ov> yJh;
  
  public ScanTranslationCaptureUI()
  {
    AppMethodBeat.i(120893);
    this.jit = true;
    this.yJe = 0;
    this.doj = 0;
    this.hpY = 0;
    this.yJf = new dm();
    this.yJg = new long[2];
    this.yJh = new c() {};
    this.rHn = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(120878);
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(120877);
            if ((g.ajj().aFd() != 6) && (g.ajj().aFd() != 4) && (ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) == 1))
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
  
  private void ac(Bitmap paramBitmap)
  {
    AppMethodBeat.i(120920);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(120920);
      return;
    }
    this.yIY.bitmap = paramBitmap;
    this.yIY.notifyDataSetChanged();
    AppMethodBeat.o(120920);
  }
  
  private void axl()
  {
    AppMethodBeat.i(120905);
    try
    {
      stopPreview();
      this.yIK.close();
      AppMethodBeat.o(120905);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.ScanTranslationCaptureUI", localException.getMessage());
      AppMethodBeat.o(120905);
    }
  }
  
  private void bnT()
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
  
  private void cyc()
  {
    AppMethodBeat.i(120913);
    stopPreview();
    if ((g.ajj().aFd() != 6) && (g.ajj().aFd() != 4))
    {
      com.tencent.mm.ui.base.h.c(this, getString(2131762844), "", true);
      dPk();
      AppMethodBeat.o(120913);
      return;
    }
    this.yJf.edS = 2L;
    this.yJb = ((int)(v.aAC().hashCode() + System.currentTimeMillis() & 0xFFFFFFFF));
    this.hTf = 1;
    showTitleView();
    dPj();
    dPf();
    if (this.yJc.equalsIgnoreCase("zh_CN"))
    {
      this.yIQ.setImageResource(2131691335);
      this.yIS.setVisibility(0);
      this.yIT.setVisibility(0);
      this.yIP.setVisibility(8);
      this.rHi.setVisibility(0);
      this.yIO.setVisibility(8);
      this.yIZ.setVisibility(0);
      this.yIU.setVisibility(8);
      this.rHl.setRepeatMode(1);
      this.rHl.setRepeatCount(-1);
      this.rHl.start();
    }
    try
    {
      if ((bu.isNullOrNil(this.iwv)) || (this.yIV == null)) {
        break label368;
      }
      this.ukB = m.ayo(this.iwv);
      str2 = this.iwv;
      if (this.doj != 0) {
        break label398;
      }
      l = System.currentTimeMillis();
      com.tencent.mm.sdk.platformtools.h.a(this.yIV, 80, Bitmap.CompressFormat.JPEG, this.iwv, false);
      ae.i("MicroMsg.ScanTranslationCaptureUI", "save img cost %d", new Object[] { Integer.valueOf((int)(System.currentTimeMillis() - l)) });
      ae.i("MicroMsg.ScanTranslationCaptureUI", "fileSize %d", new Object[] { Long.valueOf(o.aZR(this.iwv)) });
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
        ae.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", localException, "", new Object[0]);
        label398:
        continue;
        ae.w("MicroMsg.ScanTranslationCaptureUI", "can not find old translation result!");
        String str1 = str2;
        if (this.hpY != 0)
        {
          l = System.currentTimeMillis();
          str1 = ((com.tencent.mm.plugin.scanner.f)g.ad(com.tencent.mm.plugin.scanner.f.class)).genScanTmpImgPath("jpg");
          com.tencent.mm.sdk.platformtools.h.a(this.yIV, 80, Bitmap.CompressFormat.JPEG, str1, false);
          ae.i("MicroMsg.ScanTranslationCaptureUI", "save img cost %d", new Object[] { Integer.valueOf((int)(System.currentTimeMillis() - l)) });
          ae.i("MicroMsg.ScanTranslationCaptureUI", "fileSize %d", new Object[] { Long.valueOf(o.aZR(str1)) });
        }
      }
    }
    this.yJg[1] = System.currentTimeMillis();
    ((com.tencent.mm.plugin.scanner.f)g.ad(com.tencent.mm.plugin.scanner.f.class)).getScanCdnService().a(this.ukB, (String)localObject, com.tencent.mm.i.a.MediaType_IMAGE, new m.a()
    {
      public final void a(String paramAnonymousString, m.b paramAnonymousb)
      {
        AppMethodBeat.i(120873);
        if ((!bu.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(ScanTranslationCaptureUI.w(ScanTranslationCaptureUI.this))))
        {
          ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).ehx = ((int)(System.currentTimeMillis() - ScanTranslationCaptureUI.i(ScanTranslationCaptureUI.this)[1]));
          ae.i("MicroMsg.ScanTranslationCaptureUI", "upload img cost %d", new Object[] { Long.valueOf(ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).ehx) });
          switch (paramAnonymousb.errCode)
          {
          }
        }
        for (;;)
        {
          if ((ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) == 1) && (ScanTranslationCaptureUI.y(ScanTranslationCaptureUI.this) != 0))
          {
            ae.i("delete tmp path %s", this.yyR);
            o.deleteFile(this.yyR);
          }
          AppMethodBeat.o(120873);
          return;
          if (!bu.V(new String[] { paramAnonymousb.fileId, paramAnonymousb.aeskey }))
          {
            ae.i("MicroMsg.ScanTranslationCaptureUI", "fileId %s", new Object[] { paramAnonymousb.fileId });
            paramAnonymousString = new k(ScanTranslationCaptureUI.x(ScanTranslationCaptureUI.this), (int)o.aZR(this.yyR), paramAnonymousb.fileId, paramAnonymousb.aeskey);
            g.ajj().a(paramAnonymousString, 0);
          }
          else
          {
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(120870);
                ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).edS = 3L;
                com.tencent.mm.ui.base.h.cm(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(2131762880));
                AppMethodBeat.o(120870);
              }
            });
            continue;
            ar.f(new Runnable()
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
            ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).edS = 3L;
          }
        }
      }
    });
    for (;;)
    {
      g.ajj().a(294, this);
      AppMethodBeat.o(120913);
      return;
      this.yIQ.setImageResource(2131691338);
      break;
      localObject = str2;
      if (this.doj != 1) {
        break label325;
      }
      localObject = aj.ej(this.iwv + o.aZS(this.iwv));
      localObject = ((PluginScanTranslation)g.ad(PluginScanTranslation.class)).getTranslationResultStorage().ayb((String)localObject);
      if (localObject == null) {
        break label544;
      }
      ae.i("MicroMsg.ScanTranslationCaptureUI", "already has translation result");
      this.yIX = ((fp)localObject).field_resultFile;
      this.yIW = com.tencent.mm.sdk.platformtools.h.decodeFile(this.yIX, new BitmapFactory.Options());
      if (this.yIW == null) {
        break label536;
      }
      ar.o(new Runnable()
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
  
  private void cyf()
  {
    AppMethodBeat.i(120916);
    this.rHl.setRepeatMode(1);
    this.rHl.setRepeatCount(0);
    this.rHl.end();
    AppMethodBeat.o(120916);
  }
  
  private void dGE()
  {
    AppMethodBeat.i(120903);
    if (!com.tencent.mm.compatible.d.b.abk())
    {
      com.tencent.mm.ui.base.h.a(this, getString(2131755900), getString(2131755825), getString(2131755826), true, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(120875);
          com.tencent.mm.compatible.d.b.cb(ScanTranslationCaptureUI.this);
          ScanTranslationCaptureUI.this.finish();
          AppMethodBeat.o(120875);
        }
      });
      AppMethodBeat.o(120903);
      return;
    }
    dPi();
    AppMethodBeat.o(120903);
  }
  
  private void dPf()
  {
    AppMethodBeat.i(120896);
    ad.fom().equalsIgnoreCase("zh_CN");
    this.yJc = ad.iR(this);
    ae.i("MicroMsg.ScanTranslationCaptureUI", "targetLang %s", new Object[] { this.yJc });
    AppMethodBeat.o(120896);
  }
  
  private void dPg()
  {
    AppMethodBeat.i(120904);
    try
    {
      if (!this.yIK.isOpen())
      {
        long l = System.currentTimeMillis();
        this.yIK.ahq(getWindowManager().getDefaultDisplay().getRotation());
        this.yIK.a(new Camera.PreviewCallback()
        {
          public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera) {}
        });
        ae.i("MicroMsg.ScanTranslationCaptureUI", "open camera cost %s, failed count %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(this.yJe) });
        this.yIK.dNY();
        Rect localRect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
        this.yIK.m(new Point(localRect.width(), localRect.height()));
        if (this.hTf == 0) {
          dPk();
        }
        this.yJe = 0;
      }
      AppMethodBeat.o(120904);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.ScanTranslationCaptureUI", localException.getMessage());
      this.yJe += 1;
      if (this.yJe >= 5)
      {
        dPh();
        AppMethodBeat.o(120904);
        return;
      }
      ar.o(new Runnable()
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
  
  private void dPh()
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
  
  private void dPi()
  {
    AppMethodBeat.i(120909);
    ae.i("MicroMsg.ScanTranslationCaptureUI", "curState %d", new Object[] { Integer.valueOf(this.hTf) });
    if (!this.yIK.isOpen()) {
      dPg();
    }
    if ((this.hTf == 0) && (this.yIK.isOpen())) {
      dPk();
    }
    AppMethodBeat.o(120909);
  }
  
  private void dPj()
  {
    AppMethodBeat.i(120912);
    getController().setNavigationbarColor(getResources().getColor(2131101053));
    getWindow().getDecorView().setSystemUiVisibility(1796);
    AppMethodBeat.o(120912);
  }
  
  private void dPk()
  {
    AppMethodBeat.i(120914);
    bnT();
    startPreview();
    hideTitleView();
    this.yJg[0] = System.currentTimeMillis();
    if ((this.doj == 0) && (!bu.isNullOrNil(this.iwv))) {
      o.deleteFile(this.iwv);
    }
    this.hTf = 0;
    this.doj = 0;
    this.iwv = null;
    this.yIX = null;
    this.yIV = null;
    this.yIW = null;
    this.hpY = 0;
    this.yIS.setVisibility(8);
    this.yIT.setVisibility(8);
    this.yIO.setVisibility(0);
    this.yIP.setVisibility(8);
    this.yIZ.setVisibility(8);
    this.yIJ.setVisibility(0);
    this.yIU.setVisibility(0);
    this.rHi.setVisibility(8);
    cyf();
    g.ajj().b(294, this);
    AppMethodBeat.o(120914);
  }
  
  private void dPl()
  {
    AppMethodBeat.i(120915);
    dPj();
    this.hTf = 3;
    this.yIP.setVisibility(0);
    if (this.yJc.equalsIgnoreCase("zh_CN")) {
      this.yIQ.setImageResource(2131234422);
    }
    for (;;)
    {
      this.rHi.setVisibility(8);
      cyf();
      if ((this.doj != 1) || (!bu.isNullOrNil(this.yIX))) {
        break label234;
      }
      this.yIX = ((PluginScanTranslation)g.ad(PluginScanTranslation.class)).genTranslationResultImgPath("jpg");
      try
      {
        com.tencent.mm.sdk.platformtools.h.a(this.yIW, 80, Bitmap.CompressFormat.JPEG, this.yIX, false);
        ag localag = new ag();
        localag.field_originMD5 = aj.ej(this.iwv + o.aZS(this.iwv));
        localag.field_resultFile = this.yIX;
        ae.i("MicroMsg.ScanTranslationCaptureUI", "insert translate result %s", new Object[] { this.yIX });
        ((PluginScanTranslation)g.ad(PluginScanTranslation.class)).getTranslationResultStorage().a(localag);
        AppMethodBeat.o(120915);
        return;
      }
      catch (IOException localIOException)
      {
        ae.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", localIOException, "save translate result file error", new Object[0]);
      }
      this.yIQ.setImageResource(2131234424);
    }
    label234:
    AppMethodBeat.o(120915);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(120902);
    ((PluginScanTranslation)g.ad(PluginScanTranslation.class)).getTranslationRender().dQj();
    if (this.hTf == 0)
    {
      if (this.yJd)
      {
        ae.i("MicroMsg.ScanTranslationCaptureUI", "is playing animation");
        AppMethodBeat.o(120902);
        return;
      }
      this.yJa.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(120874);
          paramAnonymousAnimator = new ov();
          paramAnonymousAnimator.dDR.action = 3;
          com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousAnimator);
          ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, false);
          ScanTranslationCaptureUI.z(ScanTranslationCaptureUI.this);
          ScanTranslationCaptureUI.this.finish();
          AppMethodBeat.o(120874);
        }
      });
      this.yJa.reverse();
      this.yJd = true;
      AppMethodBeat.o(120902);
      return;
    }
    if ((this.hTf == 1) || (this.hTf == 2) || (this.hTf == 3))
    {
      if (this.hTf == 1) {
        this.yJf.ehz = ((int)(System.currentTimeMillis() - this.yJg[1]));
      }
      if (this.yJf.edS != 0L) {
        this.yJf.aLH();
      }
      dPk();
    }
    AppMethodBeat.o(120902);
  }
  
  private void startPreview()
  {
    AppMethodBeat.i(120907);
    try
    {
      if ((this.surfaceTexture != null) && (this.yIK.isOpen()) && (!this.yIK.cOB()))
      {
        ae.i("MicroMsg.ScanTranslationCaptureUI", "start preview");
        this.yIK.p(this.surfaceTexture);
        this.yIM.setEnabled(true);
        AppMethodBeat.o(120907);
        return;
      }
      ae.i("MicroMsg.ScanTranslationCaptureUI", "can not start preview");
      AppMethodBeat.o(120907);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.ScanTranslationCaptureUI", localException.getMessage());
      dPh();
      AppMethodBeat.o(120907);
    }
  }
  
  private void stopPreview()
  {
    AppMethodBeat.i(120906);
    try
    {
      if (this.yIK.cOB()) {
        this.yIK.stopPreview();
      }
      AppMethodBeat.o(120906);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.ScanTranslationCaptureUI", localException.getMessage());
      AppMethodBeat.o(120906);
    }
  }
  
  public final void c(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(120921);
    if ((paramBitmap != null) && (paramInt == this.yJb))
    {
      this.yJf.ehz = ((int)(System.currentTimeMillis() - this.yJg[1]));
      this.yIW = paramBitmap;
      dPl();
      ac(this.yIW);
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
    this.iYE = findViewById(2131304241);
    this.iYE.setAlpha(0.0F);
    this.yIJ = ((MMTextureView)findViewById(2131306072));
    this.yIJ.setOpaque(false);
    this.yIJ.setSurfaceTextureListener(this);
    this.yIZ = ((MMGestureGallery)findViewById(2131306074));
    this.yIY = new a((byte)0);
    this.yIZ.setAdapter(this.yIY);
    this.yIO = findViewById(2131297700);
    this.yIL = findViewById(2131304340);
    this.yIL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120884);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ScanTranslationCaptureUI.g(ScanTranslationCaptureUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120884);
      }
    });
    this.yIM = findViewById(2131304307);
    this.yIM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120885);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ScanTranslationCaptureUI.h(ScanTranslationCaptureUI.this).a(ScanTranslationCaptureUI.this);
        ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).ehw = ((int)(System.currentTimeMillis() - ScanTranslationCaptureUI.i(ScanTranslationCaptureUI.this)[0]));
        ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).edv = 1L;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120885);
      }
    });
    this.yIM.setEnabled(false);
    this.yIU = ((TextView)findViewById(2131304308));
    this.yIN = findViewById(2131304341);
    this.yIN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120886);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.pluginsdk.ui.tools.q.a(ScanTranslationCaptureUI.this, 561, 1, 0, 1, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120886);
      }
    });
    this.yIP = findViewById(2131304289);
    this.yIQ = ((ImageView)this.yIP.findViewById(2131306078));
    this.yIQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120887);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) == 3)
        {
          if (ScanTranslationCaptureUI.k(ScanTranslationCaptureUI.this) != null) {
            ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.k(ScanTranslationCaptureUI.this));
          }
          if (ScanTranslationCaptureUI.l(ScanTranslationCaptureUI.this).equalsIgnoreCase("zh_CN"))
          {
            ScanTranslationCaptureUI.m(ScanTranslationCaptureUI.this).setImageResource(2131691336);
            ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, 2);
            ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).ehA += 1L;
          }
        }
        while (ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) != 2) {
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(120887);
            return;
            ScanTranslationCaptureUI.m(ScanTranslationCaptureUI.this).setImageResource(2131691339);
          }
        }
        if (ScanTranslationCaptureUI.n(ScanTranslationCaptureUI.this) != null) {
          ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.n(ScanTranslationCaptureUI.this));
        }
        if (ScanTranslationCaptureUI.l(ScanTranslationCaptureUI.this).equalsIgnoreCase("zh_CN")) {
          ScanTranslationCaptureUI.m(ScanTranslationCaptureUI.this).setImageResource(2131234422);
        }
        for (;;)
        {
          ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, 3);
          break;
          ScanTranslationCaptureUI.m(ScanTranslationCaptureUI.this).setImageResource(2131234424);
        }
      }
    });
    this.yIS = findViewById(2131306077);
    this.yIT = findViewById(2131306071);
    hideTitleView();
    setMMTitle(2131762808);
    setActionbarColor(getResources().getColor(2131101053));
    this.rHi = ((ImageView)findViewById(2131304314));
    this.yIR = this.yIP.findViewById(2131306073);
    this.yIR.setOnClickListener(new View.OnClickListener()
    {
      /* Error */
      public final void onClick(View paramAnonymousView)
      {
        // Byte code:
        //   0: ldc 31
        //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: new 39	com/tencent/mm/hellhoundlib/b/b
        //   8: dup
        //   9: invokespecial 40	com/tencent/mm/hellhoundlib/b/b:<init>	()V
        //   12: astore_3
        //   13: aload_3
        //   14: aload_1
        //   15: invokevirtual 44	com/tencent/mm/hellhoundlib/b/b:bd	(Ljava/lang/Object;)V
        //   18: ldc 46
        //   20: ldc 47
        //   22: ldc 48
        //   24: ldc 49
        //   26: aload_0
        //   27: aload_3
        //   28: invokevirtual 53	com/tencent/mm/hellhoundlib/b/b:ahF	()[Ljava/lang/Object;
        //   31: invokestatic 59	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V
        //   34: aload_0
        //   35: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:yJi	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   38: invokestatic 63	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:e	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)I
        //   41: iconst_2
        //   42: if_icmpne +70 -> 112
        //   45: aload_0
        //   46: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:yJi	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   49: invokestatic 67	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:j	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)Lcom/tencent/mm/g/b/a/dm;
        //   52: lconst_1
        //   53: putfield 73	com/tencent/mm/g/b/a/dm:ehC	J
        //   56: aload_0
        //   57: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:yJi	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   60: aload_0
        //   61: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:yJi	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   64: invokestatic 77	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:o	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)Ljava/lang/String;
        //   67: new 13	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22$1
        //   70: dup
        //   71: aload_0
        //   72: invokespecial 80	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22$1:<init>	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22;)V
        //   75: invokestatic 86	com/tencent/mm/platformtools/p:a	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/platformtools/p$a;)V
        //   78: aload_0
        //   79: ldc 46
        //   81: ldc 47
        //   83: ldc 48
        //   85: ldc 49
        //   87: invokestatic 89	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   90: ldc 31
        //   92: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   95: return
        //   96: astore_1
        //   97: ldc 93
        //   99: aload_1
        //   100: ldc 95
        //   102: iconst_0
        //   103: anewarray 4	java/lang/Object
        //   106: invokestatic 101	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   109: goto -31 -> 78
        //   112: aload_0
        //   113: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:yJi	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   116: invokestatic 63	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:e	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)I
        //   119: iconst_3
        //   120: if_icmpne -42 -> 78
        //   123: aload_0
        //   124: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:yJi	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   127: invokestatic 67	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:j	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)Lcom/tencent/mm/g/b/a/dm;
        //   130: lconst_1
        //   131: putfield 104	com/tencent/mm/g/b/a/dm:ehB	J
        //   134: aload_0
        //   135: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:yJi	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   138: invokestatic 107	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:p	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)I
        //   141: istore_2
        //   142: iload_2
        //   143: ifne +48 -> 191
        //   146: aload_0
        //   147: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:yJi	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   150: ldc 109
        //   152: invokestatic 115	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
        //   155: checkcast 109	com/tencent/mm/plugin/scanner/PluginScanTranslation
        //   158: ldc 117
        //   160: invokevirtual 121	com/tencent/mm/plugin/scanner/PluginScanTranslation:genTranslationResultImgPath	(Ljava/lang/String;)Ljava/lang/String;
        //   163: invokestatic 124	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:a	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;Ljava/lang/String;)Ljava/lang/String;
        //   166: pop
        //   167: aload_0
        //   168: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:yJi	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   171: invokestatic 128	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:n	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)Landroid/graphics/Bitmap;
        //   174: bipush 80
        //   176: getstatic 134	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
        //   179: aload_0
        //   180: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:yJi	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   183: invokestatic 137	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:q	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)Ljava/lang/String;
        //   186: iconst_0
        //   187: invokestatic 142	com/tencent/mm/sdk/platformtools/h:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
        //   190: pop
        //   191: aload_0
        //   192: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:yJi	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   195: aload_0
        //   196: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:yJi	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   199: invokestatic 137	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:q	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)Ljava/lang/String;
        //   202: new 15	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22$2
        //   205: dup
        //   206: aload_0
        //   207: invokespecial 143	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22$2:<init>	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22;)V
        //   210: invokestatic 86	com/tencent/mm/platformtools/p:a	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/platformtools/p$a;)V
        //   213: goto -135 -> 78
        //   216: astore_1
        //   217: ldc 93
        //   219: aload_1
        //   220: ldc 145
        //   222: iconst_0
        //   223: anewarray 4	java/lang/Object
        //   226: invokestatic 101	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   229: goto -151 -> 78
        //   232: astore_1
        //   233: ldc 93
        //   235: aload_1
        //   236: ldc 147
        //   238: iconst_0
        //   239: anewarray 4	java/lang/Object
        //   242: invokestatic 101	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   245: goto -54 -> 191
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	248	0	this	22
        //   0	248	1	paramAnonymousView	View
        //   141	2	2	i	int
        //   12	16	3	localb	com.tencent.mm.hellhoundlib.b.b
        // Exception table:
        //   from	to	target	type
        //   45	78	96	java/lang/Exception
        //   123	142	216	java/lang/Exception
        //   146	191	216	java/lang/Exception
        //   191	213	216	java/lang/Exception
        //   233	245	216	java/lang/Exception
        //   146	191	232	java/io/IOException
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
    this.lya = getWindowManager().getDefaultDisplay().getHeight();
    this.rHl = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.rHl.addListener(new AnimatorListenerAdapter()
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
    this.rHl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    Object localObject = (RelativeLayout.LayoutParams)this.yIP.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin += al.en(this);
    this.yIP.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.rHl.setDuration(5000L);
    com.tencent.mm.ui.base.b.a(this, null);
    this.iYE.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(120866);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$11", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        if ((ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) == 0) && (paramAnonymousView == ScanTranslationCaptureUI.b(ScanTranslationCaptureUI.this)))
        {
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            ae.i("MicroMsg.ScanTranslationCaptureUI", "event down, (%f, %f)", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getX()), Float.valueOf(paramAnonymousMotionEvent.getY()) });
            float f1 = paramAnonymousMotionEvent.getX() / ScanTranslationCaptureUI.b(ScanTranslationCaptureUI.this).getWidth();
            float f2 = paramAnonymousMotionEvent.getY() / ScanTranslationCaptureUI.b(ScanTranslationCaptureUI.this).getHeight();
            ScanTranslationCaptureUI.h(ScanTranslationCaptureUI.this).a(f1, f2, new Camera.AutoFocusCallback()
            {
              public final void onAutoFocus(boolean paramAnonymous2Boolean, Camera paramAnonymous2Camera)
              {
                AppMethodBeat.i(120865);
                ae.i("MicroMsg.ScanTranslationCaptureUI", "camera auto focus call back");
                ScanTranslationCaptureUI.h(ScanTranslationCaptureUI.this).cancelAutoFocus();
                ScanTranslationCaptureUI.h(ScanTranslationCaptureUI.this).dNY();
                AppMethodBeat.o(120865);
              }
            });
          }
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$11", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(120866);
          return true;
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$11", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(120866);
        return false;
      }
    });
    dPf();
    this.yJa = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.yJa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    this.yJa.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(120868);
        ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, false);
        ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this).setVisibility(8);
        AppMethodBeat.o(120868);
      }
    });
    this.yJa.setDuration(300L);
    localObject = new ov();
    ((ov)localObject).dDR.action = 1;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    AppMethodBeat.o(120895);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(120922);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 561) && (paramInt2 == -1))
    {
      paramIntent = com.tencent.mm.ui.tools.a.j(this, paramIntent, d.azQ());
      ae.i("MicroMsg.ScanTranslationCaptureUI", "select: [%s]", new Object[] { paramIntent });
      if (!bu.isNullOrNil(paramIntent))
      {
        this.iwv = paramIntent;
        this.doj = 1;
        this.yJf.edv = 2L;
        this.hpY = Exif.fromFile(paramIntent).getOrientationInDegree();
        ae.i("MicroMsg.ScanTranslationCaptureUI", "degree %s", new Object[] { Integer.valueOf(this.hpY) });
        paramIntent = com.tencent.mm.sdk.platformtools.h.aRD(paramIntent);
        if (paramIntent != null)
        {
          this.yIV = com.tencent.mm.sdk.platformtools.h.a(paramIntent, this.hpY);
          cyc();
          ac(this.yIV);
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
    this.yIK = new com.tencent.mm.plugin.scanner.a.a();
    initView();
    com.tencent.mm.sdk.b.a.IvT.c(this.yJh);
    this.yJf.edv = 3L;
    AppMethodBeat.o(120894);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(120901);
    super.onDestroy();
    this.yJa.removeAllUpdateListeners();
    this.rHl.removeAllUpdateListeners();
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
    com.tencent.mm.plugin.ball.f.f.e(false, true, true);
    AppMethodBeat.o(120898);
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(120918);
    ae.i("MicroMsg.ScanTranslationCaptureUI", "get preview frame success, length %d", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
    if (paramArrayOfByte != null) {}
    try
    {
      if (paramArrayOfByte.length > 0)
      {
        this.yIV = null;
        long l = System.currentTimeMillis();
        paramCamera = this.yIK.fYJ();
        paramArrayOfByte = new YuvImage(paramArrayOfByte, 17, paramCamera.x, paramCamera.y, null);
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        paramArrayOfByte.compressToJpeg(new Rect(0, 0, paramCamera.x, paramCamera.y), 100, localByteArrayOutputStream);
        paramArrayOfByte = com.tencent.mm.sdk.platformtools.h.cu(localByteArrayOutputStream.toByteArray());
        int i = (int)(System.currentTimeMillis() - l);
        if (paramArrayOfByte != null)
        {
          l = System.currentTimeMillis();
          this.yIV = com.tencent.mm.sdk.platformtools.h.a(paramArrayOfByte, this.yIK.getCameraRotation());
          ae.i("MicroMsg.ScanTranslationCaptureUI", "decode cost %d, rotate cost %d", new Object[] { Integer.valueOf(i), Integer.valueOf((int)(System.currentTimeMillis() - l)) });
          if (this.yIV != null)
          {
            this.iwv = ((com.tencent.mm.plugin.scanner.f)g.ad(com.tencent.mm.plugin.scanner.f.class)).genScanCaptureImgPath("jpg");
            cyc();
            ac(this.yIV);
          }
        }
      }
      AppMethodBeat.o(120918);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ae.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(120918);
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(120910);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ae.i("MicroMsg.ScanTranslationCaptureUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(120910);
      return;
    }
    ae.i("MicroMsg.ScanTranslationCaptureUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(120910);
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        dGE();
        AppMethodBeat.o(120910);
        return;
      }
      this.jit = false;
      com.tencent.mm.ui.base.h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(120880);
          paramAnonymousDialogInterface = ScanTranslationCaptureUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$21", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
    com.tencent.mm.plugin.ball.f.f.e(true, true, true);
    bnT();
    g.ajj().a(294, this);
    g.ajQ().a(this.rHn);
    if (this.jit)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null);
      ae.i("MicroMsg.ScanTranslationCaptureUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(120897);
        return;
      }
      dGE();
      AppMethodBeat.o(120897);
      return;
    }
    dPi();
    AppMethodBeat.o(120897);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(120919);
    ae.i("MicroMsg.ScanTranslationCaptureUI", "errType %s, errCode %s, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((k)paramn).yCO;
      if ((paramString != null) && (((k)paramn).dmM == this.yJb))
      {
        this.yJf.ehy = ((int)(System.currentTimeMillis() - ((k)paramn).yCP));
        ae.i("MicroMsg.ScanTranslationCaptureUI", "angle %f, translationInfos length %d", new Object[] { Float.valueOf(((k)paramn).angle), Integer.valueOf(paramString.size()) });
        if (paramString.size() > 0)
        {
          this.yJf.edS = 1L;
          ((PluginScanTranslation)g.ad(PluginScanTranslation.class)).getTranslationRender().a(this.yJb, paramString, ((k)paramn).angle, this.yIV, this);
          if (!bu.isNullOrNil(((k)paramn).dOl()))
          {
            this.yJc = ((k)paramn).dOl();
            AppMethodBeat.o(120919);
          }
        }
        else
        {
          this.yJf.ehz = ((int)(System.currentTimeMillis() - this.yJg[1]));
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
    this.yJf.edS = 5L;
    this.yJf.ehz = ((int)(System.currentTimeMillis() - this.yJg[1]));
    paramn = getString(2131762880);
    if (!bu.isNullOrNil(paramString)) {}
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
    axl();
    g.ajj().b(294, this);
    com.tencent.mm.sdk.b.a.IvT.d(this.yJh);
    g.ajQ().b(this.rHn);
    AppMethodBeat.o(120900);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(120917);
    ae.i("MicroMsg.ScanTranslationCaptureUI", "surface texture available");
    this.yIJ.fDh();
    this.surfaceTexture = paramSurfaceTexture;
    if (this.jit)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null);
      ae.i("MicroMsg.ScanTranslationCaptureUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(120917);
        return;
      }
      dGE();
      AppMethodBeat.o(120917);
      return;
    }
    if (!this.yIK.isOpen())
    {
      dPg();
      AppMethodBeat.o(120917);
      return;
    }
    dPk();
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
          paramView.fCA();
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