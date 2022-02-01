package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
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
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ry;
import com.tencent.mm.autogen.b.gy;
import com.tencent.mm.autogen.mmdata.rpt.ld;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.z;
import com.tencent.mm.network.p.a;
import com.tencent.mm.platformtools.ExportFileUtil.a;
import com.tencent.mm.plugin.am.a.b;
import com.tencent.mm.plugin.am.a.c;
import com.tencent.mm.plugin.am.a.d;
import com.tencent.mm.plugin.am.a.e;
import com.tencent.mm.plugin.am.a.f;
import com.tencent.mm.plugin.am.a.g;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.scanner.PluginScanTranslation;
import com.tencent.mm.plugin.scanner.g;
import com.tencent.mm.plugin.scanner.model.aq;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.scanner.util.m.a;
import com.tencent.mm.plugin.scanner.util.m.b;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.plugin.scanner.util.n.b;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.tools.MMGestureGallery;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class ScanTranslationCaptureUI
  extends MMActivity
  implements Camera.PreviewCallback, TextureView.SurfaceTextureListener, com.tencent.mm.am.h, n.b
{
  private ImageView AjC;
  private ValueAnimator AjF;
  private com.tencent.mm.network.p AjH;
  private String IBe;
  private MMTextureView PaR;
  private com.tencent.mm.plugin.scanner.a.a PaS;
  private View PaT;
  private View PaU;
  private View PaV;
  private View PaW;
  private View PaX;
  private ImageView PaY;
  private View PaZ;
  private View Pba;
  private View Pbb;
  private TextView Pbc;
  private Bitmap Pbd;
  private Bitmap Pbe;
  private String Pbf;
  private a Pbg;
  private MMGestureGallery Pbh;
  private ValueAnimator Pbi;
  private int Pbj;
  private String Pbk;
  private boolean Pbl;
  private int Pbm;
  private ld Pbn;
  private long[] Pbo;
  private IListener<ry> Pbp;
  private int nDr;
  private int owq;
  private View pKd;
  private boolean pUC;
  private String pax;
  private int pvg;
  private int source;
  private SurfaceTexture surfaceTexture;
  
  public ScanTranslationCaptureUI()
  {
    AppMethodBeat.i(120893);
    this.pUC = true;
    this.Pbm = 0;
    this.source = 0;
    this.nDr = 0;
    this.Pbn = new ld();
    this.Pbo = new long[2];
    this.Pbp = new IListener(com.tencent.mm.app.f.hfK) {};
    this.AjH = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(120878);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(120877);
            if ((com.tencent.mm.kernel.h.aZW().bFQ() != 6) && (com.tencent.mm.kernel.h.aZW().bFQ() != 4) && (ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) == 1))
            {
              k.c(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(a.g.scan_no_network), "", true);
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
  
  private void aPz()
  {
    AppMethodBeat.i(120907);
    try
    {
      if ((this.surfaceTexture != null) && (this.PaS.isOpen()) && (!this.PaS.boa()))
      {
        Log.i("MicroMsg.ScanTranslationCaptureUI", "start preview");
        this.PaS.w(this.surfaceTexture);
        this.PaU.setEnabled(true);
        AppMethodBeat.o(120907);
        return;
      }
      Log.i("MicroMsg.ScanTranslationCaptureUI", "can not start preview");
      AppMethodBeat.o(120907);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ScanTranslationCaptureUI", localException.getMessage());
      gSF();
      AppMethodBeat.o(120907);
    }
  }
  
  private void aVd(String paramString)
  {
    AppMethodBeat.i(314557);
    this.Pbn.iOQ = 5L;
    this.Pbn.iPP = ((int)(System.currentTimeMillis() - this.Pbo[1]));
    String str = getString(a.g.scan_translating_no_result);
    if (!Util.isNullOrNil(paramString)) {}
    for (;;)
    {
      k.a(this, paramString, "", false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(120883);
          ScanTranslationCaptureUI.f(ScanTranslationCaptureUI.this);
          AppMethodBeat.o(120883);
        }
      });
      AppMethodBeat.o(314557);
      return;
      paramString = str;
    }
  }
  
  private void anJ()
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
  
  private void auq()
  {
    AppMethodBeat.i(120906);
    try
    {
      if (this.PaS.boa()) {
        this.PaS.auq();
      }
      AppMethodBeat.o(120906);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ScanTranslationCaptureUI", localException.getMessage());
      AppMethodBeat.o(120906);
    }
  }
  
  private void ax(Bitmap paramBitmap)
  {
    AppMethodBeat.i(120920);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(120920);
      return;
    }
    this.Pbg.bitmap = paramBitmap;
    this.Pbg.notifyDataSetChanged();
    AppMethodBeat.o(120920);
  }
  
  private void bty()
  {
    AppMethodBeat.i(120905);
    try
    {
      auq();
      this.PaS.close();
      AppMethodBeat.o(120905);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ScanTranslationCaptureUI", localException.getMessage());
      AppMethodBeat.o(120905);
    }
  }
  
  private void dSd()
  {
    AppMethodBeat.i(120913);
    auq();
    if ((com.tencent.mm.kernel.h.aZW().bFQ() != 6) && (com.tencent.mm.kernel.h.aZW().bFQ() != 4))
    {
      k.c(this, getString(a.g.scan_no_network), "", true);
      gSI();
      AppMethodBeat.o(120913);
      return;
    }
    this.Pbn.iOQ = 2L;
    this.Pbj = ((int)(z.bAM().hashCode() + System.currentTimeMillis() & 0xFFFFFFFF));
    this.owq = 1;
    showTitleView();
    gSH();
    gSE();
    if (this.Pbk.equalsIgnoreCase("zh_CN")) {
      this.PaY.setImageResource(a.f.translation_result_chinese);
    }
    for (;;)
    {
      this.Pba.setVisibility(0);
      this.Pbb.setVisibility(0);
      this.PaX.setVisibility(8);
      this.AjC.setVisibility(0);
      this.PaW.setVisibility(8);
      this.Pbh.setVisibility(0);
      this.Pbc.setVisibility(8);
      this.AjF.setRepeatMode(1);
      this.AjF.setRepeatCount(-1);
      this.AjF.start();
      try
      {
        if ((!Util.isNullOrNil(this.pax)) && (this.Pbd != null))
        {
          this.IBe = m.aVi(this.pax);
          final String str1 = this.pax;
          if (this.source != 0) {
            break label380;
          }
          l = System.currentTimeMillis();
          BitmapUtil.saveBitmapToImage(this.Pbd, 80, Bitmap.CompressFormat.JPEG, this.pax, false);
          Log.i("MicroMsg.ScanTranslationCaptureUI", "save img cost %d", new Object[] { Integer.valueOf((int)(System.currentTimeMillis() - l)) });
          Log.i("MicroMsg.ScanTranslationCaptureUI", "fileSize %d", new Object[] { Long.valueOf(com.tencent.mm.vfs.y.bEl(this.pax)) });
          this.Pbo[1] = System.currentTimeMillis();
          m.a(this.IBe, str1, com.tencent.mm.g.a.MediaType_IMAGE, new m.a()
          {
            public final void a(String paramAnonymousString, m.b paramAnonymousb)
            {
              AppMethodBeat.i(314518);
              if ((!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(ScanTranslationCaptureUI.w(ScanTranslationCaptureUI.this))))
              {
                ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).iYN = ((int)(System.currentTimeMillis() - ScanTranslationCaptureUI.i(ScanTranslationCaptureUI.this)[1]));
                Log.i("MicroMsg.ScanTranslationCaptureUI", "upload img cost %d", new Object[] { Long.valueOf(ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).iYN) });
                ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).ua(paramAnonymousb.fileId);
                ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).ub(paramAnonymousb.aeskey);
                switch (paramAnonymousb.errCode)
                {
                default: 
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(314490);
                      k.d(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(a.g.file_explorer_cannot_open_file), ScanTranslationCaptureUI.this.getString(a.g.app_tip), new DialogInterface.OnClickListener()
                      {
                        public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                        {
                          AppMethodBeat.i(314589);
                          ScanTranslationCaptureUI.f(ScanTranslationCaptureUI.this);
                          AppMethodBeat.o(314589);
                        }
                      });
                      AppMethodBeat.o(314490);
                    }
                  });
                  ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).iOQ = 3L;
                }
              }
              for (;;)
              {
                if ((ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) == 1) && (ScanTranslationCaptureUI.y(ScanTranslationCaptureUI.this) != 0))
                {
                  Log.i("delete tmp path %s", str1);
                  com.tencent.mm.vfs.y.deleteFile(str1);
                }
                AppMethodBeat.o(314518);
                return;
                if (!Util.isNullOrNil(new String[] { paramAnonymousb.fileId, paramAnonymousb.aeskey }))
                {
                  Log.i("MicroMsg.ScanTranslationCaptureUI", "fileId %s", new Object[] { paramAnonymousb.fileId });
                  paramAnonymousString = new com.tencent.mm.plugin.scanner.model.s(ScanTranslationCaptureUI.x(ScanTranslationCaptureUI.this), (int)com.tencent.mm.vfs.y.bEl(str1), paramAnonymousb.fileId, paramAnonymousb.aeskey);
                  com.tencent.mm.kernel.h.aZW().a(paramAnonymousString, 0);
                }
                else
                {
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(120870);
                      ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).iOQ = 3L;
                      k.cZ(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(a.g.scan_translating_no_result));
                      AppMethodBeat.o(120870);
                    }
                  });
                  continue;
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(120872);
                      k.d(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(a.g.file_explorer_cannot_open_file), ScanTranslationCaptureUI.this.getString(a.g.app_tip), new DialogInterface.OnClickListener()
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
                  ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).iOQ = 3L;
                }
              }
            }
          });
        }
        for (;;)
        {
          com.tencent.mm.kernel.h.aZW().a(294, this);
          AppMethodBeat.o(120913);
          return;
          this.PaY.setImageResource(a.f.translation_result_english);
          break;
          label380:
          if (this.source != 1) {
            break label621;
          }
          Object localObject = MD5Util.getMD5String(this.pax + com.tencent.mm.vfs.y.bEm(this.pax));
          localObject = ((PluginScanTranslation)com.tencent.mm.kernel.h.az(PluginScanTranslation.class)).getTranslationResultStorage().aUV((String)localObject);
          if (localObject == null) {
            break label528;
          }
          Log.i("MicroMsg.ScanTranslationCaptureUI", "already has translation result");
          this.Pbf = ((gy)localObject).field_resultFile;
          this.Pbe = BitmapUtil.decodeFile(this.Pbf, new BitmapFactory.Options());
          if (this.Pbe == null) {
            break label520;
          }
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
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
      catch (Exception localException)
      {
        label520:
        label528:
        label621:
        for (;;)
        {
          long l;
          Log.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", localException, "", new Object[0]);
          continue;
          Log.w("MicroMsg.ScanTranslationCaptureUI", "can not find old translation result!");
          if (this.nDr != 0)
          {
            l = System.currentTimeMillis();
            String str2 = ((g)com.tencent.mm.kernel.h.az(g.class)).genScanTmpImgPath("jpg");
            BitmapUtil.saveBitmapToImage(this.Pbd, 80, Bitmap.CompressFormat.JPEG, str2, false);
            Log.i("MicroMsg.ScanTranslationCaptureUI", "save img cost %d", new Object[] { Integer.valueOf((int)(System.currentTimeMillis() - l)) });
            Log.i("MicroMsg.ScanTranslationCaptureUI", "fileSize %d", new Object[] { Long.valueOf(com.tencent.mm.vfs.y.bEl(str2)) });
          }
        }
      }
    }
  }
  
  private void dSg()
  {
    AppMethodBeat.i(120916);
    this.AjF.setRepeatMode(1);
    this.AjF.setRepeatCount(0);
    this.AjF.end();
    AppMethodBeat.o(120916);
  }
  
  private void eoX()
  {
    AppMethodBeat.i(120904);
    try
    {
      if (!this.PaS.isOpen())
      {
        long l = System.currentTimeMillis();
        this.PaS.aHb(getWindowManager().getDefaultDisplay().getRotation());
        this.PaS.c(new Camera.PreviewCallback()
        {
          public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera) {}
        });
        Log.i("MicroMsg.ScanTranslationCaptureUI", "open camera cost %s, failed count %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(this.Pbm) });
        this.PaS.gQa();
        Rect localRect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
        this.PaS.q(new Point(localRect.width(), localRect.height()));
        if (this.owq == 0) {
          gSI();
        }
        this.Pbm = 0;
      }
      AppMethodBeat.o(120904);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ScanTranslationCaptureUI", localException.getMessage());
      this.Pbm += 1;
      if (this.Pbm >= 5)
      {
        gSF();
        AppMethodBeat.o(120904);
        return;
      }
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
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
  
  private void gFj()
  {
    AppMethodBeat.i(120903);
    if (!com.tencent.mm.compatible.e.b.aPP())
    {
      k.a(this, getString(a.g.app_special_no_open_camera_permission), getString(a.g.app_need_camera_title), getString(a.g.app_need_show_settings_button), true, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(120875);
          com.tencent.mm.compatible.e.b.dg(ScanTranslationCaptureUI.this);
          ScanTranslationCaptureUI.this.finish();
          AppMethodBeat.o(120875);
        }
      });
      AppMethodBeat.o(120903);
      return;
    }
    gSG();
    AppMethodBeat.o(120903);
  }
  
  private void gSE()
  {
    AppMethodBeat.i(120896);
    LocaleUtil.getApplicationLanguage().equalsIgnoreCase("zh_CN");
    this.Pbk = LocaleUtil.getCurrentLanguage(this);
    Log.i("MicroMsg.ScanTranslationCaptureUI", "targetLang %s", new Object[] { this.Pbk });
    AppMethodBeat.o(120896);
  }
  
  private void gSF()
  {
    AppMethodBeat.i(120908);
    k.a(this, getString(a.g.scan_open_camera_fail), getString(a.g.app_tip), false, new DialogInterface.OnClickListener()
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
  
  private void gSG()
  {
    AppMethodBeat.i(120909);
    Log.i("MicroMsg.ScanTranslationCaptureUI", "curState %d", new Object[] { Integer.valueOf(this.owq) });
    if (!this.PaS.isOpen()) {
      eoX();
    }
    if ((this.owq == 0) && (this.PaS.isOpen())) {
      gSI();
    }
    AppMethodBeat.o(120909);
  }
  
  private void gSH()
  {
    AppMethodBeat.i(120912);
    getController().setNavigationbarColor(getResources().getColor(a.b.transparent));
    getWindow().getDecorView().setSystemUiVisibility(1796);
    AppMethodBeat.o(120912);
  }
  
  private void gSI()
  {
    AppMethodBeat.i(120914);
    anJ();
    aPz();
    hideTitleView();
    this.Pbo[0] = System.currentTimeMillis();
    if ((this.source == 0) && (!Util.isNullOrNil(this.pax))) {
      com.tencent.mm.vfs.y.deleteFile(this.pax);
    }
    this.owq = 0;
    this.source = 0;
    this.pax = null;
    this.Pbf = null;
    this.Pbd = null;
    this.Pbe = null;
    this.nDr = 0;
    this.Pba.setVisibility(8);
    this.Pbb.setVisibility(8);
    this.PaW.setVisibility(0);
    this.PaX.setVisibility(8);
    this.Pbh.setVisibility(8);
    this.PaR.setVisibility(0);
    this.Pbc.setVisibility(0);
    this.AjC.setVisibility(8);
    dSg();
    com.tencent.mm.kernel.h.aZW().b(294, this);
    AppMethodBeat.o(120914);
  }
  
  private void gSJ()
  {
    AppMethodBeat.i(120915);
    gSH();
    this.owq = 3;
    this.PaX.setVisibility(0);
    if (this.Pbk.equalsIgnoreCase("zh_CN")) {
      this.PaY.setImageResource(a.c.translate_chinese_view_source_btn);
    }
    for (;;)
    {
      this.AjC.setVisibility(8);
      dSg();
      if ((this.source != 1) || (!Util.isNullOrNil(this.Pbf))) {
        break label234;
      }
      this.Pbf = ((PluginScanTranslation)com.tencent.mm.kernel.h.az(PluginScanTranslation.class)).genTranslationResultImgPath("jpg");
      try
      {
        BitmapUtil.saveBitmapToImage(this.Pbe, 80, Bitmap.CompressFormat.JPEG, this.Pbf, false);
        aq localaq = new aq();
        localaq.field_originMD5 = MD5Util.getMD5String(this.pax + com.tencent.mm.vfs.y.bEm(this.pax));
        localaq.field_resultFile = this.Pbf;
        Log.i("MicroMsg.ScanTranslationCaptureUI", "insert translate result %s", new Object[] { this.Pbf });
        ((PluginScanTranslation)com.tencent.mm.kernel.h.az(PluginScanTranslation.class)).getTranslationResultStorage().a(localaq);
        AppMethodBeat.o(120915);
        return;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", localIOException, "save translate result file error", new Object[0]);
      }
      this.PaY.setImageResource(a.c.translate_english_view_source_btn);
    }
    label234:
    AppMethodBeat.o(120915);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(120902);
    ((PluginScanTranslation)com.tencent.mm.kernel.h.az(PluginScanTranslation.class)).getTranslationRender().gUe();
    if (this.owq == 0)
    {
      if (this.Pbl)
      {
        Log.i("MicroMsg.ScanTranslationCaptureUI", "is playing animation");
        AppMethodBeat.o(120902);
        return;
      }
      this.Pbi.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(120874);
          paramAnonymousAnimator = new ry();
          paramAnonymousAnimator.hVb.action = 3;
          paramAnonymousAnimator.publish();
          ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, false);
          ScanTranslationCaptureUI.z(ScanTranslationCaptureUI.this);
          ScanTranslationCaptureUI.this.finish();
          AppMethodBeat.o(120874);
        }
      });
      this.Pbi.reverse();
      this.Pbl = true;
      AppMethodBeat.o(120902);
      return;
    }
    if ((this.owq == 1) || (this.owq == 2) || (this.owq == 3))
    {
      if (this.owq == 1) {
        this.Pbn.iPP = ((int)(System.currentTimeMillis() - this.Pbo[1]));
      }
      if (this.Pbn.iOQ != 0L) {
        this.Pbn.bMH();
      }
      gSI();
    }
    AppMethodBeat.o(120902);
  }
  
  public final void f(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(120921);
    if (paramInt == this.Pbj)
    {
      this.Pbn.iPP = ((int)(System.currentTimeMillis() - this.Pbo[1]));
      if (paramBitmap != null)
      {
        this.Pbe = paramBitmap;
        gSJ();
        ax(this.Pbe);
        AppMethodBeat.o(120921);
        return;
      }
      aVd(null);
    }
    AppMethodBeat.o(120921);
  }
  
  public int getLayoutId()
  {
    return a.e.scan_translate_capture_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(120895);
    this.pKd = findViewById(a.d.root_container);
    this.pKd.setAlpha(0.0F);
    this.PaR = ((MMTextureView)findViewById(a.d.translate_capture_texture_view));
    this.PaR.setOpaque(false);
    this.PaR.setSurfaceTextureListener(this);
    this.Pbh = ((MMGestureGallery)findViewById(a.d.translate_gallery_view));
    this.Pbg = new a((byte)0);
    this.Pbh.setAdapter(this.Pbg);
    this.PaW = findViewById(a.d.capture_btn_container);
    this.PaT = findViewById(a.d.scan_translate_close_btn);
    this.PaT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120884);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        ScanTranslationCaptureUI.g(ScanTranslationCaptureUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120884);
      }
    });
    this.PaU = findViewById(a.d.scan_capture_btn);
    this.PaU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120885);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        ScanTranslationCaptureUI.h(ScanTranslationCaptureUI.this).c(ScanTranslationCaptureUI.this);
        ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).iYM = ((int)(System.currentTimeMillis() - ScanTranslationCaptureUI.i(ScanTranslationCaptureUI.this)[0]));
        ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).iOd = 1L;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120885);
      }
    });
    this.PaU.setEnabled(false);
    this.Pbc = ((TextView)findViewById(a.d.scan_capture_translate_tip));
    this.PaV = findViewById(a.d.scan_translate_gallery);
    this.PaV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120886);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        t.a(ScanTranslationCaptureUI.this, 561, 1, 0, 1, false, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120886);
      }
    });
    this.PaX = findViewById(a.d.save_translate_container);
    this.PaY = ((ImageView)this.PaX.findViewById(a.d.translate_view_source_btn));
    this.PaY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120887);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) == 3)
        {
          if (ScanTranslationCaptureUI.k(ScanTranslationCaptureUI.this) != null) {
            ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.k(ScanTranslationCaptureUI.this));
          }
          if (ScanTranslationCaptureUI.l(ScanTranslationCaptureUI.this).equalsIgnoreCase("zh_CN"))
          {
            ScanTranslationCaptureUI.m(ScanTranslationCaptureUI.this).setImageResource(a.f.translation_result_chinese_highlighted);
            ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, 2);
            ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).iYP += 1L;
          }
        }
        while (ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) != 2) {
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(120887);
            return;
            ScanTranslationCaptureUI.m(ScanTranslationCaptureUI.this).setImageResource(a.f.translation_result_english_highlighted);
          }
        }
        if (ScanTranslationCaptureUI.n(ScanTranslationCaptureUI.this) != null) {
          ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.n(ScanTranslationCaptureUI.this));
        }
        if (ScanTranslationCaptureUI.l(ScanTranslationCaptureUI.this).equalsIgnoreCase("zh_CN")) {
          ScanTranslationCaptureUI.m(ScanTranslationCaptureUI.this).setImageResource(a.c.translate_chinese_view_source_btn);
        }
        for (;;)
        {
          ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, 3);
          break;
          ScanTranslationCaptureUI.m(ScanTranslationCaptureUI.this).setImageResource(a.c.translate_english_view_source_btn);
        }
      }
    });
    this.Pba = findViewById(a.d.translate_top_bg);
    this.Pbb = findViewById(a.d.translate_bottom_bg);
    hideTitleView();
    setMMTitle(a.g.scan_entry_ocr);
    setActionbarColor(getResources().getColor(a.b.transparent));
    this.AjC = ((ImageView)findViewById(a.d.scan_line));
    this.PaZ = this.PaX.findViewById(a.d.translate_download_btn);
    this.PaZ.setOnClickListener(new View.OnClickListener()
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
        //   15: invokevirtual 44	com/tencent/mm/hellhoundlib/b/b:cH	(Ljava/lang/Object;)V
        //   18: ldc 46
        //   20: ldc 47
        //   22: ldc 48
        //   24: ldc 49
        //   26: aload_0
        //   27: aload_3
        //   28: invokevirtual 53	com/tencent/mm/hellhoundlib/b/b:aYj	()[Ljava/lang/Object;
        //   31: invokestatic 59	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V
        //   34: aload_0
        //   35: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:Pbq	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   38: invokestatic 63	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:e	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)I
        //   41: iconst_2
        //   42: if_icmpne +70 -> 112
        //   45: aload_0
        //   46: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:Pbq	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   49: invokestatic 67	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:j	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)Lcom/tencent/mm/autogen/mmdata/rpt/ld;
        //   52: lconst_1
        //   53: putfield 73	com/tencent/mm/autogen/mmdata/rpt/ld:iYR	J
        //   56: aload_0
        //   57: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:Pbq	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   60: aload_0
        //   61: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:Pbq	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   64: invokestatic 77	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:o	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)Ljava/lang/String;
        //   67: new 13	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22$1
        //   70: dup
        //   71: aload_0
        //   72: invokespecial 80	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22$1:<init>	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22;)V
        //   75: invokestatic 86	com/tencent/mm/platformtools/ExportFileUtil:a	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/platformtools/ExportFileUtil$a;)V
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
        //   106: invokestatic 101	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   109: goto -31 -> 78
        //   112: aload_0
        //   113: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:Pbq	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   116: invokestatic 63	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:e	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)I
        //   119: iconst_3
        //   120: if_icmpne -42 -> 78
        //   123: aload_0
        //   124: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:Pbq	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   127: invokestatic 67	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:j	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)Lcom/tencent/mm/autogen/mmdata/rpt/ld;
        //   130: lconst_1
        //   131: putfield 104	com/tencent/mm/autogen/mmdata/rpt/ld:iYQ	J
        //   134: aload_0
        //   135: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:Pbq	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   138: invokestatic 107	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:p	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)I
        //   141: istore_2
        //   142: iload_2
        //   143: ifne +48 -> 191
        //   146: aload_0
        //   147: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:Pbq	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   150: ldc 109
        //   152: invokestatic 115	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
        //   155: checkcast 109	com/tencent/mm/plugin/scanner/PluginScanTranslation
        //   158: ldc 117
        //   160: invokevirtual 121	com/tencent/mm/plugin/scanner/PluginScanTranslation:genTranslationResultImgPath	(Ljava/lang/String;)Ljava/lang/String;
        //   163: invokestatic 124	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:a	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;Ljava/lang/String;)Ljava/lang/String;
        //   166: pop
        //   167: aload_0
        //   168: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:Pbq	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   171: invokestatic 128	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:n	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)Landroid/graphics/Bitmap;
        //   174: bipush 80
        //   176: getstatic 134	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
        //   179: aload_0
        //   180: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:Pbq	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   183: invokestatic 137	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:q	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)Ljava/lang/String;
        //   186: iconst_0
        //   187: invokestatic 143	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
        //   190: pop
        //   191: aload_0
        //   192: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:Pbq	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   195: aload_0
        //   196: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:Pbq	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   199: invokestatic 137	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:q	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)Ljava/lang/String;
        //   202: new 15	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22$2
        //   205: dup
        //   206: aload_0
        //   207: invokespecial 144	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22$2:<init>	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22;)V
        //   210: invokestatic 86	com/tencent/mm/platformtools/ExportFileUtil:a	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/platformtools/ExportFileUtil$a;)V
        //   213: goto -135 -> 78
        //   216: astore_1
        //   217: ldc 93
        //   219: aload_1
        //   220: ldc 146
        //   222: iconst_0
        //   223: anewarray 4	java/lang/Object
        //   226: invokestatic 101	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   229: goto -151 -> 78
        //   232: astore_1
        //   233: ldc 93
        //   235: aload_1
        //   236: ldc 148
        //   238: iconst_0
        //   239: anewarray 4	java/lang/Object
        //   242: invokestatic 101	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    this.pvg = getWindowManager().getDefaultDisplay().getHeight();
    this.AjF = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.AjF.addListener(new AnimatorListenerAdapter()
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
    this.AjF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    Object localObject = (RelativeLayout.LayoutParams)this.PaX.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin += aw.bk(this);
    this.PaX.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.AjF.setDuration(5000L);
    com.tencent.mm.ui.base.b.a(this, null);
    this.pKd.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(120866);
        if ((ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) == 0) && (paramAnonymousView == ScanTranslationCaptureUI.b(ScanTranslationCaptureUI.this)))
        {
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            Log.i("MicroMsg.ScanTranslationCaptureUI", "event down, (%f, %f)", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getX()), Float.valueOf(paramAnonymousMotionEvent.getY()) });
            float f1 = paramAnonymousMotionEvent.getX() / ScanTranslationCaptureUI.b(ScanTranslationCaptureUI.this).getWidth();
            float f2 = paramAnonymousMotionEvent.getY() / ScanTranslationCaptureUI.b(ScanTranslationCaptureUI.this).getHeight();
            ScanTranslationCaptureUI.h(ScanTranslationCaptureUI.this).a(f1, f2, new Camera.AutoFocusCallback()
            {
              public final void onAutoFocus(boolean paramAnonymous2Boolean, Camera paramAnonymous2Camera)
              {
                AppMethodBeat.i(120865);
                Log.i("MicroMsg.ScanTranslationCaptureUI", "camera auto focus call back");
                ScanTranslationCaptureUI.h(ScanTranslationCaptureUI.this).aPA();
                ScanTranslationCaptureUI.h(ScanTranslationCaptureUI.this).gQa();
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
    gSE();
    this.Pbi = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.Pbi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    this.Pbi.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(120868);
        ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, false);
        ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this).setVisibility(8);
        AppMethodBeat.o(120868);
      }
    });
    this.Pbi.setDuration(300L);
    localObject = new ry();
    ((ry)localObject).hVb.action = 1;
    ((ry)localObject).publish();
    AppMethodBeat.o(120895);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(120922);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 561) && (paramInt2 == -1))
    {
      paramIntent = com.tencent.mm.ui.tools.b.i(this, paramIntent, d.bzL());
      Log.i("MicroMsg.ScanTranslationCaptureUI", "select: [%s]", new Object[] { paramIntent });
      if (!Util.isNullOrNil(paramIntent))
      {
        this.pax = paramIntent;
        this.source = 1;
        this.Pbn.iOd = 2L;
        this.nDr = Exif.fromFile(paramIntent).getOrientationInDegree();
        Log.i("MicroMsg.ScanTranslationCaptureUI", "degree %s", new Object[] { Integer.valueOf(this.nDr) });
        paramIntent = BitmapUtil.decodeFileWithSample(paramIntent);
        if (paramIntent != null)
        {
          this.Pbd = BitmapUtil.rotate(paramIntent, this.nDr);
          dSd();
          ax(this.Pbd);
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
    this.PaS = new com.tencent.mm.plugin.scanner.a.a();
    initView();
    this.Pbp.alive();
    this.Pbn.iOd = 3L;
    AppMethodBeat.o(120894);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(120901);
    super.onDestroy();
    this.Pbi.removeAllUpdateListeners();
    this.AjF.removeAllUpdateListeners();
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
    Log.i("MicroMsg.ScanTranslationCaptureUI", "get preview frame success, length %d", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
    if (paramArrayOfByte != null) {}
    try
    {
      if (paramArrayOfByte.length > 0)
      {
        this.Pbd = null;
        long l = System.currentTimeMillis();
        paramCamera = this.PaS.jXF();
        paramArrayOfByte = new YuvImage(paramArrayOfByte, 17, paramCamera.x, paramCamera.y, null);
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        paramArrayOfByte.compressToJpeg(new Rect(0, 0, paramCamera.x, paramCamera.y), 100, localByteArrayOutputStream);
        paramArrayOfByte = BitmapUtil.decodeByteArray(localByteArrayOutputStream.toByteArray());
        int i = (int)(System.currentTimeMillis() - l);
        if (paramArrayOfByte != null)
        {
          l = System.currentTimeMillis();
          this.Pbd = BitmapUtil.rotate(paramArrayOfByte, this.PaS.getCameraRotation());
          Log.i("MicroMsg.ScanTranslationCaptureUI", "decode cost %d, rotate cost %d", new Object[] { Integer.valueOf(i), Integer.valueOf((int)(System.currentTimeMillis() - l)) });
          if (this.Pbd != null)
          {
            this.pax = ((g)com.tencent.mm.kernel.h.az(g.class)).genScanCaptureImgPath("jpg");
            dSd();
            ax(this.Pbd);
          }
        }
      }
      AppMethodBeat.o(120918);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(120918);
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(120910);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.ScanTranslationCaptureUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(120910);
      return;
    }
    Log.i("MicroMsg.ScanTranslationCaptureUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(120910);
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        gFj();
        AppMethodBeat.o(120910);
        return;
      }
      this.pUC = false;
      k.a(this, getString(a.g.permission_camera_request_again_msg), getString(a.g.permission_tips_title), getString(a.g.jump_to_settings), getString(a.g.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(120880);
          com.tencent.mm.pluginsdk.permission.b.lx(ScanTranslationCaptureUI.this.getContext());
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
    anJ();
    com.tencent.mm.kernel.h.aZW().a(294, this);
    com.tencent.mm.kernel.h.baD().a(this.AjH);
    if (this.pUC)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null);
      Log.i("MicroMsg.ScanTranslationCaptureUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(120897);
        return;
      }
      gFj();
      AppMethodBeat.o(120897);
      return;
    }
    gSG();
    AppMethodBeat.o(120897);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(120919);
    Log.i("MicroMsg.ScanTranslationCaptureUI", "errType %s, errCode %s, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.scanner.model.s)paramp).ORL;
      if ((paramString != null) && (((com.tencent.mm.plugin.scanner.model.s)paramp).hBm == this.Pbj))
      {
        this.Pbn.iYO = ((int)(System.currentTimeMillis() - ((com.tencent.mm.plugin.scanner.model.s)paramp).ORM));
        Log.i("MicroMsg.ScanTranslationCaptureUI", "angle %f, translationInfos length %d", new Object[] { Float.valueOf(((com.tencent.mm.plugin.scanner.model.s)paramp).angle), Integer.valueOf(paramString.size()) });
        if (paramString.size() > 0)
        {
          this.Pbn.iOQ = 1L;
          ((PluginScanTranslation)com.tencent.mm.kernel.h.az(PluginScanTranslation.class)).getTranslationRender().a(this.Pbj, paramString, ((com.tencent.mm.plugin.scanner.model.s)paramp).angle, this.Pbd, this);
          if (!Util.isNullOrNil(((com.tencent.mm.plugin.scanner.model.s)paramp).gQU()))
          {
            this.Pbk = ((com.tencent.mm.plugin.scanner.model.s)paramp).gQU();
            AppMethodBeat.o(120919);
          }
        }
        else
        {
          this.Pbn.iPP = ((int)(System.currentTimeMillis() - this.Pbo[1]));
          k.a(this, getString(a.g.scan_translating_no_result), "", false, new DialogInterface.OnClickListener()
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
    aVd(paramString);
    AppMethodBeat.o(120919);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(120900);
    super.onStop();
    bty();
    com.tencent.mm.kernel.h.aZW().b(294, this);
    this.Pbp.dead();
    com.tencent.mm.kernel.h.baD().b(this.AjH);
    AppMethodBeat.o(120900);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(120917);
    Log.i("MicroMsg.ScanTranslationCaptureUI", "surface texture available");
    this.PaR.jmM();
    this.surfaceTexture = paramSurfaceTexture;
    if (this.pUC)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null);
      Log.i("MicroMsg.ScanTranslationCaptureUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(120917);
        return;
      }
      gFj();
      AppMethodBeat.o(120917);
      return;
    }
    if (!this.PaS.isOpen())
    {
      eoX();
      AppMethodBeat.o(120917);
      return;
    }
    gSI();
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
          paramView.dU(this.bitmap.getWidth(), this.bitmap.getHeight());
          paramView.jma();
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