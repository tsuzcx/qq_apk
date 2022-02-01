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
import com.tencent.mm.g.a.ol;
import com.tencent.mm.g.b.a.cr;
import com.tencent.mm.g.c.ff;
import com.tencent.mm.model.u;
import com.tencent.mm.network.n.a;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.scanner.PluginScanTranslation;
import com.tencent.mm.plugin.scanner.e;
import com.tencent.mm.plugin.scanner.util.j;
import com.tencent.mm.plugin.scanner.util.j.b;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.scanner.util.m.a;
import com.tencent.mm.plugin.scanner.util.m.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class ScanTranslationCaptureUI
  extends MMActivity
  implements Camera.PreviewCallback, TextureView.SurfaceTextureListener, com.tencent.mm.ak.g, j.b
{
  private int dbL;
  private int gVh;
  private int hxS;
  private View iCB;
  private boolean iMq;
  private String iag;
  private int kWC;
  private ImageView qOY;
  private ValueAnimator qPb;
  private com.tencent.mm.network.n qPd;
  private SurfaceTexture surfaceTexture;
  private String tbJ;
  private MMTextureView xeH;
  private com.tencent.mm.plugin.scanner.a.a xeI;
  private View xeJ;
  private View xeK;
  private View xeL;
  private View xeM;
  private View xeN;
  private ImageView xeO;
  private View xeP;
  private View xeQ;
  private View xeR;
  private TextView xeS;
  private Bitmap xeT;
  private Bitmap xeU;
  private String xeV;
  private a xeW;
  private MMGestureGallery xeX;
  private ValueAnimator xeY;
  private int xeZ;
  private String xfa;
  private boolean xfb;
  private int xfc;
  private cr xfd;
  private long[] xfe;
  private c<ol> xff;
  
  public ScanTranslationCaptureUI()
  {
    AppMethodBeat.i(120893);
    this.iMq = true;
    this.xfc = 0;
    this.dbL = 0;
    this.gVh = 0;
    this.xfd = new cr();
    this.xfe = new long[2];
    this.xff = new c() {};
    this.qPd = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(120878);
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(120877);
            if ((com.tencent.mm.kernel.g.agi().aBK() != 6) && (com.tencent.mm.kernel.g.agi().aBK() != 4) && (ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) == 1))
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
    this.xeW.bitmap = paramBitmap;
    this.xeW.notifyDataSetChanged();
    AppMethodBeat.o(120920);
  }
  
  private void auj()
  {
    AppMethodBeat.i(120905);
    try
    {
      stopPreview();
      this.xeI.close();
      AppMethodBeat.o(120905);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.ScanTranslationCaptureUI", localException.getMessage());
      AppMethodBeat.o(120905);
    }
  }
  
  private void bjx()
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
  
  private void cqR()
  {
    AppMethodBeat.i(120913);
    stopPreview();
    if ((com.tencent.mm.kernel.g.agi().aBK() != 6) && (com.tencent.mm.kernel.g.agi().aBK() != 4))
    {
      com.tencent.mm.ui.base.h.c(this, getString(2131762844), "", true);
      dAt();
      AppMethodBeat.o(120913);
      return;
    }
    this.xfd.dNi = 2L;
    this.xeZ = ((int)(u.axw().hashCode() + System.currentTimeMillis() & 0xFFFFFFFF));
    this.hxS = 1;
    showTitleView();
    dAs();
    dAo();
    if (this.xfa.equalsIgnoreCase("zh_CN"))
    {
      this.xeO.setImageResource(2131691335);
      this.xeQ.setVisibility(0);
      this.xeR.setVisibility(0);
      this.xeN.setVisibility(8);
      this.qOY.setVisibility(0);
      this.xeM.setVisibility(8);
      this.xeX.setVisibility(0);
      this.xeS.setVisibility(8);
      this.qPb.setRepeatMode(1);
      this.qPb.setRepeatCount(-1);
      this.qPb.start();
    }
    try
    {
      if ((bs.isNullOrNil(this.iag)) || (this.xeT == null)) {
        break label368;
      }
      this.tbJ = m.arY(this.iag);
      str2 = this.iag;
      if (this.dbL != 0) {
        break label398;
      }
      l = System.currentTimeMillis();
      com.tencent.mm.sdk.platformtools.f.a(this.xeT, 80, Bitmap.CompressFormat.JPEG, this.iag, false);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ScanTranslationCaptureUI", "save img cost %d", new Object[] { Integer.valueOf((int)(System.currentTimeMillis() - l)) });
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ScanTranslationCaptureUI", "fileSize %d", new Object[] { Long.valueOf(i.aSp(this.iag)) });
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
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", localException, "", new Object[0]);
        label398:
        continue;
        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.ScanTranslationCaptureUI", "can not find old translation result!");
        String str1 = str2;
        if (this.gVh != 0)
        {
          l = System.currentTimeMillis();
          str1 = ((e)com.tencent.mm.kernel.g.ad(e.class)).genScanTmpImgPath("jpg");
          com.tencent.mm.sdk.platformtools.f.a(this.xeT, 80, Bitmap.CompressFormat.JPEG, str1, false);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ScanTranslationCaptureUI", "save img cost %d", new Object[] { Integer.valueOf((int)(System.currentTimeMillis() - l)) });
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ScanTranslationCaptureUI", "fileSize %d", new Object[] { Long.valueOf(i.aSp(str1)) });
        }
      }
    }
    this.xfe[1] = System.currentTimeMillis();
    ((e)com.tencent.mm.kernel.g.ad(e.class)).getScanCdnService().a(this.tbJ, (String)localObject, com.tencent.mm.i.a.MediaType_IMAGE, new m.a()
    {
      public final void a(String paramAnonymousString, m.b paramAnonymousb)
      {
        AppMethodBeat.i(120873);
        if ((!bs.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(ScanTranslationCaptureUI.w(ScanTranslationCaptureUI.this))))
        {
          ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).dQq = ((int)(System.currentTimeMillis() - ScanTranslationCaptureUI.i(ScanTranslationCaptureUI.this)[1]));
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ScanTranslationCaptureUI", "upload img cost %d", new Object[] { Long.valueOf(ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).dQq) });
          switch (paramAnonymousb.errCode)
          {
          }
        }
        for (;;)
        {
          if ((ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) == 1) && (ScanTranslationCaptureUI.y(ScanTranslationCaptureUI.this) != 0))
          {
            com.tencent.mm.sdk.platformtools.ac.i("delete tmp path %s", this.wVw);
            i.deleteFile(this.wVw);
          }
          AppMethodBeat.o(120873);
          return;
          if (!bs.T(new String[] { paramAnonymousb.fileId, paramAnonymousb.aeskey }))
          {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ScanTranslationCaptureUI", "fileId %s", new Object[] { paramAnonymousb.fileId });
            paramAnonymousString = new com.tencent.mm.plugin.scanner.model.h(ScanTranslationCaptureUI.x(ScanTranslationCaptureUI.this), (int)i.aSp(this.wVw), paramAnonymousb.fileId, paramAnonymousb.aeskey);
            com.tencent.mm.kernel.g.agi().a(paramAnonymousString, 0);
          }
          else
          {
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(120870);
                ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).dNi = 3L;
                com.tencent.mm.ui.base.h.cg(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(2131762880));
                AppMethodBeat.o(120870);
              }
            });
            continue;
            ap.f(new Runnable()
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
            ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).dNi = 3L;
          }
        }
      }
    });
    for (;;)
    {
      com.tencent.mm.kernel.g.agi().a(294, this);
      AppMethodBeat.o(120913);
      return;
      this.xeO.setImageResource(2131691338);
      break;
      localObject = str2;
      if (this.dbL != 1) {
        break label325;
      }
      localObject = ah.dg(this.iag + i.aSq(this.iag));
      localObject = ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationResultStorage().arL((String)localObject);
      if (localObject == null) {
        break label544;
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ScanTranslationCaptureUI", "already has translation result");
      this.xeV = ((ff)localObject).field_resultFile;
      this.xeU = com.tencent.mm.sdk.platformtools.f.decodeFile(this.xeV, new BitmapFactory.Options());
      if (this.xeU == null) {
        break label536;
      }
      ap.n(new Runnable()
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
  
  private void cqU()
  {
    AppMethodBeat.i(120916);
    this.qPb.setRepeatMode(1);
    this.qPb.setRepeatCount(0);
    this.qPb.end();
    AppMethodBeat.o(120916);
  }
  
  private void dAo()
  {
    AppMethodBeat.i(120896);
    ab.eUO().equalsIgnoreCase("zh_CN");
    this.xfa = ab.iC(this);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ScanTranslationCaptureUI", "targetLang %s", new Object[] { this.xfa });
    AppMethodBeat.o(120896);
  }
  
  private void dAp()
  {
    AppMethodBeat.i(120904);
    try
    {
      if (!this.xeI.isOpen())
      {
        long l = System.currentTimeMillis();
        this.xeI.aeh(getWindowManager().getDefaultDisplay().getRotation());
        this.xeI.a(new Camera.PreviewCallback()
        {
          public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera) {}
        });
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ScanTranslationCaptureUI", "open camera cost %s, failed count %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(this.xfc) });
        this.xeI.dzi();
        Rect localRect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
        this.xeI.l(new Point(localRect.width(), localRect.height()));
        if (this.hxS == 0) {
          dAt();
        }
        this.xfc = 0;
      }
      AppMethodBeat.o(120904);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.ScanTranslationCaptureUI", localException.getMessage());
      this.xfc += 1;
      if (this.xfc >= 5)
      {
        dAq();
        AppMethodBeat.o(120904);
        return;
      }
      ap.n(new Runnable()
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
  
  private void dAq()
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
  
  private void dAr()
  {
    AppMethodBeat.i(120909);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ScanTranslationCaptureUI", "curState %d", new Object[] { Integer.valueOf(this.hxS) });
    if (!this.xeI.isOpen()) {
      dAp();
    }
    if ((this.hxS == 0) && (this.xeI.isOpen())) {
      dAt();
    }
    AppMethodBeat.o(120909);
  }
  
  private void dAs()
  {
    AppMethodBeat.i(120912);
    getController().setNavigationbarColor(getResources().getColor(2131101053));
    getWindow().getDecorView().setSystemUiVisibility(1796);
    AppMethodBeat.o(120912);
  }
  
  private void dAt()
  {
    AppMethodBeat.i(120914);
    bjx();
    startPreview();
    hideTitleView();
    this.xfe[0] = System.currentTimeMillis();
    if ((this.dbL == 0) && (!bs.isNullOrNil(this.iag))) {
      i.deleteFile(this.iag);
    }
    this.hxS = 0;
    this.dbL = 0;
    this.iag = null;
    this.xeV = null;
    this.xeT = null;
    this.xeU = null;
    this.gVh = 0;
    this.xeQ.setVisibility(8);
    this.xeR.setVisibility(8);
    this.xeM.setVisibility(0);
    this.xeN.setVisibility(8);
    this.xeX.setVisibility(8);
    this.xeH.setVisibility(0);
    this.xeS.setVisibility(0);
    this.qOY.setVisibility(8);
    cqU();
    com.tencent.mm.kernel.g.agi().b(294, this);
    AppMethodBeat.o(120914);
  }
  
  private void dAu()
  {
    AppMethodBeat.i(120915);
    dAs();
    this.hxS = 3;
    this.xeN.setVisibility(0);
    if (this.xfa.equalsIgnoreCase("zh_CN")) {
      this.xeO.setImageResource(2131234422);
    }
    for (;;)
    {
      this.qOY.setVisibility(8);
      cqU();
      if ((this.dbL != 1) || (!bs.isNullOrNil(this.xeV))) {
        break label234;
      }
      this.xeV = ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).genTranslationResultImgPath("jpg");
      try
      {
        com.tencent.mm.sdk.platformtools.f.a(this.xeU, 80, Bitmap.CompressFormat.JPEG, this.xeV, false);
        com.tencent.mm.plugin.scanner.model.ac localac = new com.tencent.mm.plugin.scanner.model.ac();
        localac.field_originMD5 = ah.dg(this.iag + i.aSq(this.iag));
        localac.field_resultFile = this.xeV;
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ScanTranslationCaptureUI", "insert translate result %s", new Object[] { this.xeV });
        ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationResultStorage().a(localac);
        AppMethodBeat.o(120915);
        return;
      }
      catch (IOException localIOException)
      {
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", localIOException, "save translate result file error", new Object[0]);
      }
      this.xeO.setImageResource(2131234424);
    }
    label234:
    AppMethodBeat.o(120915);
  }
  
  private void dsQ()
  {
    AppMethodBeat.i(120903);
    if (!com.tencent.mm.compatible.d.b.Yz())
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
    dAr();
    AppMethodBeat.o(120903);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(120902);
    ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationRender().dBs();
    if (this.hxS == 0)
    {
      if (this.xfb)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ScanTranslationCaptureUI", "is playing animation");
        AppMethodBeat.o(120902);
        return;
      }
      this.xeY.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(120874);
          paramAnonymousAnimator = new ol();
          paramAnonymousAnimator.dqV.action = 3;
          com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousAnimator);
          ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, false);
          ScanTranslationCaptureUI.z(ScanTranslationCaptureUI.this);
          ScanTranslationCaptureUI.this.finish();
          AppMethodBeat.o(120874);
        }
      });
      this.xeY.reverse();
      this.xfb = true;
      AppMethodBeat.o(120902);
      return;
    }
    if ((this.hxS == 1) || (this.hxS == 2) || (this.hxS == 3))
    {
      if (this.hxS == 1) {
        this.xfd.dQs = ((int)(System.currentTimeMillis() - this.xfe[1]));
      }
      if (this.xfd.dNi != 0L) {
        this.xfd.aHZ();
      }
      dAt();
    }
    AppMethodBeat.o(120902);
  }
  
  private void startPreview()
  {
    AppMethodBeat.i(120907);
    try
    {
      if ((this.surfaceTexture != null) && (this.xeI.isOpen()) && (!this.xeI.cDz()))
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ScanTranslationCaptureUI", "start preview");
        this.xeI.p(this.surfaceTexture);
        this.xeK.setEnabled(true);
        AppMethodBeat.o(120907);
        return;
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ScanTranslationCaptureUI", "can not start preview");
      AppMethodBeat.o(120907);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.ScanTranslationCaptureUI", localException.getMessage());
      dAq();
      AppMethodBeat.o(120907);
    }
  }
  
  private void stopPreview()
  {
    AppMethodBeat.i(120906);
    try
    {
      if (this.xeI.cDz()) {
        this.xeI.stopPreview();
      }
      AppMethodBeat.o(120906);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.ScanTranslationCaptureUI", localException.getMessage());
      AppMethodBeat.o(120906);
    }
  }
  
  public final void c(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(120921);
    if ((paramBitmap != null) && (paramInt == this.xeZ))
    {
      this.xfd.dQs = ((int)(System.currentTimeMillis() - this.xfe[1]));
      this.xeU = paramBitmap;
      dAu();
      ab(this.xeU);
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
    this.iCB = findViewById(2131304241);
    this.iCB.setAlpha(0.0F);
    this.xeH = ((MMTextureView)findViewById(2131306072));
    this.xeH.setOpaque(false);
    this.xeH.setSurfaceTextureListener(this);
    this.xeX = ((MMGestureGallery)findViewById(2131306074));
    this.xeW = new a((byte)0);
    this.xeX.setAdapter(this.xeW);
    this.xeM = findViewById(2131297700);
    this.xeJ = findViewById(2131304340);
    this.xeJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120884);
        ScanTranslationCaptureUI.g(ScanTranslationCaptureUI.this);
        AppMethodBeat.o(120884);
      }
    });
    this.xeK = findViewById(2131304307);
    this.xeK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120885);
        ScanTranslationCaptureUI.h(ScanTranslationCaptureUI.this).a(ScanTranslationCaptureUI.this);
        ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).dQp = ((int)(System.currentTimeMillis() - ScanTranslationCaptureUI.i(ScanTranslationCaptureUI.this)[0]));
        ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).dNc = 1L;
        AppMethodBeat.o(120885);
      }
    });
    this.xeK.setEnabled(false);
    this.xeS = ((TextView)findViewById(2131304308));
    this.xeL = findViewById(2131304341);
    this.xeL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120886);
        com.tencent.mm.pluginsdk.ui.tools.q.a(ScanTranslationCaptureUI.this, 561, 1, 0, 1, null);
        AppMethodBeat.o(120886);
      }
    });
    this.xeN = findViewById(2131304289);
    this.xeO = ((ImageView)this.xeN.findViewById(2131306078));
    this.xeO.setOnClickListener(new View.OnClickListener()
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
            ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).dQt += 1L;
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
    this.xeQ = findViewById(2131306077);
    this.xeR = findViewById(2131306071);
    hideTitleView();
    setMMTitle(2131762808);
    setActionbarColor(getResources().getColor(2131101053));
    this.qOY = ((ImageView)findViewById(2131304314));
    this.xeP = this.xeN.findViewById(2131306073);
    this.xeP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120888);
        if (ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) == 2) {
          try
          {
            ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).dQv = 1L;
            p.a(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.o(ScanTranslationCaptureUI.this), new p.a()
            {
              public final void bD(String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(208109);
                com.tencent.mm.ui.widget.snackbar.b.n(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(2131762883));
                AppMethodBeat.o(208109);
              }
              
              public final void bE(String paramAnonymous2String1, String paramAnonymous2String2) {}
            });
            AppMethodBeat.o(120888);
            return;
          }
          catch (Exception paramAnonymousView)
          {
            com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", paramAnonymousView, "copy to gallery error", new Object[0]);
            AppMethodBeat.o(120888);
            return;
          }
        }
        if (ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) == 3) {
          try
          {
            ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).dQu = 1L;
            int i = ScanTranslationCaptureUI.p(ScanTranslationCaptureUI.this);
            if (i == 0) {}
            try
            {
              ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).genTranslationResultImgPath("jpg"));
              com.tencent.mm.sdk.platformtools.f.a(ScanTranslationCaptureUI.n(ScanTranslationCaptureUI.this), 80, Bitmap.CompressFormat.JPEG, ScanTranslationCaptureUI.q(ScanTranslationCaptureUI.this), false);
              p.a(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.q(ScanTranslationCaptureUI.this), new p.a()
              {
                public final void bD(String paramAnonymous2String1, String paramAnonymous2String2)
                {
                  AppMethodBeat.i(208110);
                  com.tencent.mm.ui.widget.snackbar.b.n(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(2131762883));
                  AppMethodBeat.o(208110);
                }
                
                public final void bE(String paramAnonymous2String1, String paramAnonymous2String2) {}
              });
              AppMethodBeat.o(120888);
              return;
            }
            catch (IOException paramAnonymousView)
            {
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", paramAnonymousView, "save translate result file error", new Object[0]);
              }
            }
            AppMethodBeat.o(120888);
          }
          catch (Exception paramAnonymousView)
          {
            com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", paramAnonymousView, "save to gallery error", new Object[0]);
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
    this.kWC = getWindowManager().getDefaultDisplay().getHeight();
    this.qPb = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.qPb.addListener(new AnimatorListenerAdapter()
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
    this.qPb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    Object localObject = (RelativeLayout.LayoutParams)this.xeN.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin += aj.ej(this);
    this.xeN.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.qPb.setDuration(5000L);
    com.tencent.mm.ui.base.b.a(this, null);
    this.iCB.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(120866);
        if ((ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) == 0) && (paramAnonymousView == ScanTranslationCaptureUI.b(ScanTranslationCaptureUI.this)))
        {
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ScanTranslationCaptureUI", "event down, (%f, %f)", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getX()), Float.valueOf(paramAnonymousMotionEvent.getY()) });
            float f1 = paramAnonymousMotionEvent.getX() / ScanTranslationCaptureUI.b(ScanTranslationCaptureUI.this).getWidth();
            float f2 = paramAnonymousMotionEvent.getY() / ScanTranslationCaptureUI.b(ScanTranslationCaptureUI.this).getHeight();
            ScanTranslationCaptureUI.h(ScanTranslationCaptureUI.this).a(f1, f2, new Camera.AutoFocusCallback()
            {
              public final void onAutoFocus(boolean paramAnonymous2Boolean, Camera paramAnonymous2Camera)
              {
                AppMethodBeat.i(120865);
                com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ScanTranslationCaptureUI", "camera auto focus call back");
                ScanTranslationCaptureUI.h(ScanTranslationCaptureUI.this).cancelAutoFocus();
                ScanTranslationCaptureUI.h(ScanTranslationCaptureUI.this).dzi();
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
    dAo();
    this.xeY = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.xeY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    this.xeY.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(120868);
        ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, false);
        ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this).setVisibility(8);
        AppMethodBeat.o(120868);
      }
    });
    this.xeY.setDuration(300L);
    localObject = new ol();
    ((ol)localObject).dqV.action = 1;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    AppMethodBeat.o(120895);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(120922);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 561) && (paramInt2 == -1))
    {
      paramIntent = com.tencent.mm.ui.tools.a.i(this, paramIntent, d.awL());
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ScanTranslationCaptureUI", "select: [%s]", new Object[] { paramIntent });
      if (!bs.isNullOrNil(paramIntent))
      {
        this.iag = paramIntent;
        this.dbL = 1;
        this.xfd.dNc = 2L;
        this.gVh = Exif.fromFile(paramIntent).getOrientationInDegree();
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ScanTranslationCaptureUI", "degree %s", new Object[] { Integer.valueOf(this.gVh) });
        paramIntent = com.tencent.mm.sdk.platformtools.f.aKA(paramIntent);
        if (paramIntent != null)
        {
          this.xeT = com.tencent.mm.sdk.platformtools.f.a(paramIntent, this.gVh);
          cqR();
          ab(this.xeT);
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
    this.xeI = new com.tencent.mm.plugin.scanner.a.a();
    initView();
    com.tencent.mm.sdk.b.a.GpY.c(this.xff);
    this.xfd.dNc = 3L;
    AppMethodBeat.o(120894);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(120901);
    super.onDestroy();
    this.xeY.removeAllUpdateListeners();
    this.qPb.removeAllUpdateListeners();
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
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ScanTranslationCaptureUI", "get preview frame success, length %d", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
    if (paramArrayOfByte != null) {}
    try
    {
      if (paramArrayOfByte.length > 0)
      {
        this.xeT = null;
        long l = System.currentTimeMillis();
        paramCamera = this.xeI.fCS();
        paramArrayOfByte = new YuvImage(paramArrayOfByte, 17, paramCamera.x, paramCamera.y, null);
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        paramArrayOfByte.compressToJpeg(new Rect(0, 0, paramCamera.x, paramCamera.y), 100, localByteArrayOutputStream);
        paramArrayOfByte = com.tencent.mm.sdk.platformtools.f.ck(localByteArrayOutputStream.toByteArray());
        int i = (int)(System.currentTimeMillis() - l);
        if (paramArrayOfByte != null)
        {
          l = System.currentTimeMillis();
          this.xeT = com.tencent.mm.sdk.platformtools.f.a(paramArrayOfByte, this.xeI.getCameraRotation());
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ScanTranslationCaptureUI", "decode cost %d, rotate cost %d", new Object[] { Integer.valueOf(i), Integer.valueOf((int)(System.currentTimeMillis() - l)) });
          if (this.xeT != null)
          {
            this.iag = ((e)com.tencent.mm.kernel.g.ad(e.class)).genScanCaptureImgPath("jpg");
            cqR();
            ab(this.xeT);
          }
        }
      }
      AppMethodBeat.o(120918);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(120918);
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(120910);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ScanTranslationCaptureUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(120910);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ScanTranslationCaptureUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(120910);
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        dsQ();
        AppMethodBeat.o(120910);
        return;
      }
      this.iMq = false;
      com.tencent.mm.ui.base.h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(120880);
          paramAnonymousDialogInterface = ScanTranslationCaptureUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$21", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
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
    bjx();
    com.tencent.mm.kernel.g.agi().a(294, this);
    com.tencent.mm.kernel.g.agQ().a(this.qPd);
    if (this.iMq)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ScanTranslationCaptureUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(120897);
        return;
      }
      dsQ();
      AppMethodBeat.o(120897);
      return;
    }
    dAr();
    AppMethodBeat.o(120897);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(120919);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ScanTranslationCaptureUI", "errType %s, errCode %s, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.scanner.model.h)paramn).wYW;
      if ((paramString != null) && (((com.tencent.mm.plugin.scanner.model.h)paramn).daq == this.xeZ))
      {
        this.xfd.dQr = ((int)(System.currentTimeMillis() - ((com.tencent.mm.plugin.scanner.model.h)paramn).wYX));
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ScanTranslationCaptureUI", "angle %f, translationInfos length %d", new Object[] { Float.valueOf(((com.tencent.mm.plugin.scanner.model.h)paramn).angle), Integer.valueOf(paramString.size()) });
        if (paramString.size() > 0)
        {
          this.xfd.dNi = 1L;
          ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationRender().a(this.xeZ, paramString, ((com.tencent.mm.plugin.scanner.model.h)paramn).angle, this.xeT, this);
          if (!bs.isNullOrNil(((com.tencent.mm.plugin.scanner.model.h)paramn).dzv()))
          {
            this.xfa = ((com.tencent.mm.plugin.scanner.model.h)paramn).dzv();
            AppMethodBeat.o(120919);
          }
        }
        else
        {
          this.xfd.dQs = ((int)(System.currentTimeMillis() - this.xfe[1]));
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
    this.xfd.dNi = 5L;
    this.xfd.dQs = ((int)(System.currentTimeMillis() - this.xfe[1]));
    paramn = getString(2131762880);
    if (!bs.isNullOrNil(paramString)) {}
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
    auj();
    com.tencent.mm.kernel.g.agi().b(294, this);
    com.tencent.mm.sdk.b.a.GpY.d(this.xff);
    com.tencent.mm.kernel.g.agQ().b(this.qPd);
    AppMethodBeat.o(120900);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(120917);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ScanTranslationCaptureUI", "surface texture available");
    this.xeH.fiQ();
    this.surfaceTexture = paramSurfaceTexture;
    if (this.iMq)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ScanTranslationCaptureUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(120917);
        return;
      }
      dsQ();
      AppMethodBeat.o(120917);
      return;
    }
    if (!this.xeI.isOpen())
    {
      dAp();
      AppMethodBeat.o(120917);
      return;
    }
    dAt();
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
          paramView.cF(this.bitmap.getWidth(), this.bitmap.getHeight());
          paramView.fij();
        }
        AppMethodBeat.o(120892);
        return paramView;
        paramView = (MultiTouchImageView)paramView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI
 * JD-Core Version:    0.7.0.1
 */