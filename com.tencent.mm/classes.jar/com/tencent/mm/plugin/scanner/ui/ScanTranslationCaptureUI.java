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
import com.tencent.mm.g.a.ou;
import com.tencent.mm.g.b.a.dk;
import com.tencent.mm.g.c.fp;
import com.tencent.mm.model.u;
import com.tencent.mm.network.n.a;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.scanner.PluginScanTranslation;
import com.tencent.mm.plugin.scanner.e;
import com.tencent.mm.plugin.scanner.model.af;
import com.tencent.mm.plugin.scanner.util.j.b;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.scanner.util.m.a;
import com.tencent.mm.plugin.scanner.util.m.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class ScanTranslationCaptureUI
  extends MMActivity
  implements Camera.PreviewCallback, TextureView.SurfaceTextureListener, com.tencent.mm.al.f, j.b
{
  private int dnh;
  private int hQn;
  private int hnk;
  private View iVL;
  private String itB;
  private boolean jfA;
  private int ltB;
  private ImageView ryX;
  private ValueAnimator rza;
  private com.tencent.mm.network.n rzc;
  private SurfaceTexture surfaceTexture;
  private String tZz;
  private MMTextureView ysJ;
  private com.tencent.mm.plugin.scanner.a.a ysK;
  private View ysL;
  private View ysM;
  private View ysN;
  private View ysO;
  private View ysP;
  private ImageView ysQ;
  private View ysR;
  private View ysS;
  private View ysT;
  private TextView ysU;
  private Bitmap ysV;
  private Bitmap ysW;
  private String ysX;
  private a ysY;
  private MMGestureGallery ysZ;
  private ValueAnimator yta;
  private int ytb;
  private String ytc;
  private boolean ytd;
  private int yte;
  private dk ytf;
  private long[] ytg;
  private c<ou> yth;
  
  public ScanTranslationCaptureUI()
  {
    AppMethodBeat.i(120893);
    this.jfA = true;
    this.yte = 0;
    this.dnh = 0;
    this.hnk = 0;
    this.ytf = new dk();
    this.ytg = new long[2];
    this.yth = new c() {};
    this.rzc = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(120878);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(120877);
            if ((com.tencent.mm.kernel.g.aiU().aEN() != 6) && (com.tencent.mm.kernel.g.aiU().aEN() != 4) && (ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) == 1))
            {
              h.c(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(2131762844), "", true);
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
    this.ysY.bitmap = paramBitmap;
    this.ysY.notifyDataSetChanged();
    AppMethodBeat.o(120920);
  }
  
  private void awW()
  {
    AppMethodBeat.i(120905);
    try
    {
      stopPreview();
      this.ysK.close();
      AppMethodBeat.o(120905);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ScanTranslationCaptureUI", localException.getMessage());
      AppMethodBeat.o(120905);
    }
  }
  
  private void bnj()
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
  
  private void cwB()
  {
    AppMethodBeat.i(120913);
    stopPreview();
    if ((com.tencent.mm.kernel.g.aiU().aEN() != 6) && (com.tencent.mm.kernel.g.aiU().aEN() != 4))
    {
      h.c(this, getString(2131762844), "", true);
      dLR();
      AppMethodBeat.o(120913);
      return;
    }
    this.ytf.ecx = 2L;
    this.ytb = ((int)(u.aAm().hashCode() + System.currentTimeMillis() & 0xFFFFFFFF));
    this.hQn = 1;
    showTitleView();
    dLQ();
    dLM();
    if (this.ytc.equalsIgnoreCase("zh_CN"))
    {
      this.ysQ.setImageResource(2131691335);
      this.ysS.setVisibility(0);
      this.ysT.setVisibility(0);
      this.ysP.setVisibility(8);
      this.ryX.setVisibility(0);
      this.ysO.setVisibility(8);
      this.ysZ.setVisibility(0);
      this.ysU.setVisibility(8);
      this.rza.setRepeatMode(1);
      this.rza.setRepeatCount(-1);
      this.rza.start();
    }
    try
    {
      if ((bt.isNullOrNil(this.itB)) || (this.ysV == null)) {
        break label368;
      }
      this.tZz = m.awZ(this.itB);
      str2 = this.itB;
      if (this.dnh != 0) {
        break label398;
      }
      l = System.currentTimeMillis();
      com.tencent.mm.sdk.platformtools.g.a(this.ysV, 80, Bitmap.CompressFormat.JPEG, this.itB, false);
      ad.i("MicroMsg.ScanTranslationCaptureUI", "save img cost %d", new Object[] { Integer.valueOf((int)(System.currentTimeMillis() - l)) });
      ad.i("MicroMsg.ScanTranslationCaptureUI", "fileSize %d", new Object[] { Long.valueOf(i.aYo(this.itB)) });
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
        if (this.hnk != 0)
        {
          l = System.currentTimeMillis();
          str1 = ((e)com.tencent.mm.kernel.g.ad(e.class)).genScanTmpImgPath("jpg");
          com.tencent.mm.sdk.platformtools.g.a(this.ysV, 80, Bitmap.CompressFormat.JPEG, str1, false);
          ad.i("MicroMsg.ScanTranslationCaptureUI", "save img cost %d", new Object[] { Integer.valueOf((int)(System.currentTimeMillis() - l)) });
          ad.i("MicroMsg.ScanTranslationCaptureUI", "fileSize %d", new Object[] { Long.valueOf(i.aYo(str1)) });
        }
      }
    }
    this.ytg[1] = System.currentTimeMillis();
    ((e)com.tencent.mm.kernel.g.ad(e.class)).getScanCdnService().a(this.tZz, (String)localObject, com.tencent.mm.i.a.MediaType_IMAGE, new m.a()
    {
      public final void a(String paramAnonymousString, m.b paramAnonymousb)
      {
        AppMethodBeat.i(120873);
        if ((!bt.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(ScanTranslationCaptureUI.w(ScanTranslationCaptureUI.this))))
        {
          ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).efM = ((int)(System.currentTimeMillis() - ScanTranslationCaptureUI.i(ScanTranslationCaptureUI.this)[1]));
          ad.i("MicroMsg.ScanTranslationCaptureUI", "upload img cost %d", new Object[] { Long.valueOf(ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).efM) });
          switch (paramAnonymousb.errCode)
          {
          }
        }
        for (;;)
        {
          if ((ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) == 1) && (ScanTranslationCaptureUI.y(ScanTranslationCaptureUI.this) != 0))
          {
            ad.i("delete tmp path %s", this.yiZ);
            i.deleteFile(this.yiZ);
          }
          AppMethodBeat.o(120873);
          return;
          if (!bt.V(new String[] { paramAnonymousb.fileId, paramAnonymousb.aeskey }))
          {
            ad.i("MicroMsg.ScanTranslationCaptureUI", "fileId %s", new Object[] { paramAnonymousb.fileId });
            paramAnonymousString = new com.tencent.mm.plugin.scanner.model.j(ScanTranslationCaptureUI.x(ScanTranslationCaptureUI.this), (int)i.aYo(this.yiZ), paramAnonymousb.fileId, paramAnonymousb.aeskey);
            com.tencent.mm.kernel.g.aiU().a(paramAnonymousString, 0);
          }
          else
          {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(120870);
                ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).ecx = 3L;
                h.cl(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(2131762880));
                AppMethodBeat.o(120870);
              }
            });
            continue;
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(120872);
                h.d(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(2131759055), ScanTranslationCaptureUI.this.getString(2131755906), new DialogInterface.OnClickListener()
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
            ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).ecx = 3L;
          }
        }
      }
    });
    for (;;)
    {
      com.tencent.mm.kernel.g.aiU().a(294, this);
      AppMethodBeat.o(120913);
      return;
      this.ysQ.setImageResource(2131691338);
      break;
      localObject = str2;
      if (this.dnh != 1) {
        break label325;
      }
      localObject = ai.ee(this.itB + i.aYp(this.itB));
      localObject = ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationResultStorage().awM((String)localObject);
      if (localObject == null) {
        break label544;
      }
      ad.i("MicroMsg.ScanTranslationCaptureUI", "already has translation result");
      this.ysX = ((fp)localObject).field_resultFile;
      this.ysW = com.tencent.mm.sdk.platformtools.g.decodeFile(this.ysX, new BitmapFactory.Options());
      if (this.ysW == null) {
        break label536;
      }
      aq.o(new Runnable()
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
  
  private void cwE()
  {
    AppMethodBeat.i(120916);
    this.rza.setRepeatMode(1);
    this.rza.setRepeatCount(0);
    this.rza.end();
    AppMethodBeat.o(120916);
  }
  
  private void dDn()
  {
    AppMethodBeat.i(120903);
    if (!com.tencent.mm.compatible.d.b.abb())
    {
      h.a(this, getString(2131755900), getString(2131755825), getString(2131755826), true, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(120875);
          com.tencent.mm.compatible.d.b.bZ(ScanTranslationCaptureUI.this);
          ScanTranslationCaptureUI.this.finish();
          AppMethodBeat.o(120875);
        }
      });
      AppMethodBeat.o(120903);
      return;
    }
    dLP();
    AppMethodBeat.o(120903);
  }
  
  private void dLM()
  {
    AppMethodBeat.i(120896);
    ac.fks().equalsIgnoreCase("zh_CN");
    this.ytc = ac.iM(this);
    ad.i("MicroMsg.ScanTranslationCaptureUI", "targetLang %s", new Object[] { this.ytc });
    AppMethodBeat.o(120896);
  }
  
  private void dLN()
  {
    AppMethodBeat.i(120904);
    try
    {
      if (!this.ysK.isOpen())
      {
        long l = System.currentTimeMillis();
        this.ysK.agH(getWindowManager().getDefaultDisplay().getRotation());
        this.ysK.a(new Camera.PreviewCallback()
        {
          public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera) {}
        });
        ad.i("MicroMsg.ScanTranslationCaptureUI", "open camera cost %s, failed count %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(this.yte) });
        this.ysK.dKG();
        Rect localRect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
        this.ysK.l(new Point(localRect.width(), localRect.height()));
        if (this.hQn == 0) {
          dLR();
        }
        this.yte = 0;
      }
      AppMethodBeat.o(120904);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ScanTranslationCaptureUI", localException.getMessage());
      this.yte += 1;
      if (this.yte >= 5)
      {
        dLO();
        AppMethodBeat.o(120904);
        return;
      }
      aq.o(new Runnable()
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
  
  private void dLO()
  {
    AppMethodBeat.i(120908);
    h.a(this, getString(2131762855), getString(2131755906), false, new DialogInterface.OnClickListener()
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
  
  private void dLP()
  {
    AppMethodBeat.i(120909);
    ad.i("MicroMsg.ScanTranslationCaptureUI", "curState %d", new Object[] { Integer.valueOf(this.hQn) });
    if (!this.ysK.isOpen()) {
      dLN();
    }
    if ((this.hQn == 0) && (this.ysK.isOpen())) {
      dLR();
    }
    AppMethodBeat.o(120909);
  }
  
  private void dLQ()
  {
    AppMethodBeat.i(120912);
    getController().setNavigationbarColor(getResources().getColor(2131101053));
    getWindow().getDecorView().setSystemUiVisibility(1796);
    AppMethodBeat.o(120912);
  }
  
  private void dLR()
  {
    AppMethodBeat.i(120914);
    bnj();
    startPreview();
    hideTitleView();
    this.ytg[0] = System.currentTimeMillis();
    if ((this.dnh == 0) && (!bt.isNullOrNil(this.itB))) {
      i.deleteFile(this.itB);
    }
    this.hQn = 0;
    this.dnh = 0;
    this.itB = null;
    this.ysX = null;
    this.ysV = null;
    this.ysW = null;
    this.hnk = 0;
    this.ysS.setVisibility(8);
    this.ysT.setVisibility(8);
    this.ysO.setVisibility(0);
    this.ysP.setVisibility(8);
    this.ysZ.setVisibility(8);
    this.ysJ.setVisibility(0);
    this.ysU.setVisibility(0);
    this.ryX.setVisibility(8);
    cwE();
    com.tencent.mm.kernel.g.aiU().b(294, this);
    AppMethodBeat.o(120914);
  }
  
  private void dLS()
  {
    AppMethodBeat.i(120915);
    dLQ();
    this.hQn = 3;
    this.ysP.setVisibility(0);
    if (this.ytc.equalsIgnoreCase("zh_CN")) {
      this.ysQ.setImageResource(2131234422);
    }
    for (;;)
    {
      this.ryX.setVisibility(8);
      cwE();
      if ((this.dnh != 1) || (!bt.isNullOrNil(this.ysX))) {
        break label234;
      }
      this.ysX = ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).genTranslationResultImgPath("jpg");
      try
      {
        com.tencent.mm.sdk.platformtools.g.a(this.ysW, 80, Bitmap.CompressFormat.JPEG, this.ysX, false);
        af localaf = new af();
        localaf.field_originMD5 = ai.ee(this.itB + i.aYp(this.itB));
        localaf.field_resultFile = this.ysX;
        ad.i("MicroMsg.ScanTranslationCaptureUI", "insert translate result %s", new Object[] { this.ysX });
        ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationResultStorage().a(localaf);
        AppMethodBeat.o(120915);
        return;
      }
      catch (IOException localIOException)
      {
        ad.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", localIOException, "save translate result file error", new Object[0]);
      }
      this.ysQ.setImageResource(2131234424);
    }
    label234:
    AppMethodBeat.o(120915);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(120902);
    ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationRender().dMQ();
    if (this.hQn == 0)
    {
      if (this.ytd)
      {
        ad.i("MicroMsg.ScanTranslationCaptureUI", "is playing animation");
        AppMethodBeat.o(120902);
        return;
      }
      this.yta.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(120874);
          paramAnonymousAnimator = new ou();
          paramAnonymousAnimator.dCM.action = 3;
          com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousAnimator);
          ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, false);
          ScanTranslationCaptureUI.z(ScanTranslationCaptureUI.this);
          ScanTranslationCaptureUI.this.finish();
          AppMethodBeat.o(120874);
        }
      });
      this.yta.reverse();
      this.ytd = true;
      AppMethodBeat.o(120902);
      return;
    }
    if ((this.hQn == 1) || (this.hQn == 2) || (this.hQn == 3))
    {
      if (this.hQn == 1) {
        this.ytf.efO = ((int)(System.currentTimeMillis() - this.ytg[1]));
      }
      if (this.ytf.ecx != 0L) {
        this.ytf.aLk();
      }
      dLR();
    }
    AppMethodBeat.o(120902);
  }
  
  private void startPreview()
  {
    AppMethodBeat.i(120907);
    try
    {
      if ((this.surfaceTexture != null) && (this.ysK.isOpen()) && (!this.ysK.cLT()))
      {
        ad.i("MicroMsg.ScanTranslationCaptureUI", "start preview");
        this.ysK.p(this.surfaceTexture);
        this.ysM.setEnabled(true);
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
      dLO();
      AppMethodBeat.o(120907);
    }
  }
  
  private void stopPreview()
  {
    AppMethodBeat.i(120906);
    try
    {
      if (this.ysK.cLT()) {
        this.ysK.stopPreview();
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
    if ((paramBitmap != null) && (paramInt == this.ytb))
    {
      this.ytf.efO = ((int)(System.currentTimeMillis() - this.ytg[1]));
      this.ysW = paramBitmap;
      dLS();
      ab(this.ysW);
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
    this.iVL = findViewById(2131304241);
    this.iVL.setAlpha(0.0F);
    this.ysJ = ((MMTextureView)findViewById(2131306072));
    this.ysJ.setOpaque(false);
    this.ysJ.setSurfaceTextureListener(this);
    this.ysZ = ((MMGestureGallery)findViewById(2131306074));
    this.ysY = new a((byte)0);
    this.ysZ.setAdapter(this.ysY);
    this.ysO = findViewById(2131297700);
    this.ysL = findViewById(2131304340);
    this.ysL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120884);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ScanTranslationCaptureUI.g(ScanTranslationCaptureUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120884);
      }
    });
    this.ysM = findViewById(2131304307);
    this.ysM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120885);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ScanTranslationCaptureUI.h(ScanTranslationCaptureUI.this).a(ScanTranslationCaptureUI.this);
        ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).efL = ((int)(System.currentTimeMillis() - ScanTranslationCaptureUI.i(ScanTranslationCaptureUI.this)[0]));
        ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).eca = 1L;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120885);
      }
    });
    this.ysM.setEnabled(false);
    this.ysU = ((TextView)findViewById(2131304308));
    this.ysN = findViewById(2131304341);
    this.ysN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120886);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        com.tencent.mm.pluginsdk.ui.tools.q.a(ScanTranslationCaptureUI.this, 561, 1, 0, 1, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120886);
      }
    });
    this.ysP = findViewById(2131304289);
    this.ysQ = ((ImageView)this.ysP.findViewById(2131306078));
    this.ysQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120887);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) == 3)
        {
          if (ScanTranslationCaptureUI.k(ScanTranslationCaptureUI.this) != null) {
            ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.k(ScanTranslationCaptureUI.this));
          }
          if (ScanTranslationCaptureUI.l(ScanTranslationCaptureUI.this).equalsIgnoreCase("zh_CN"))
          {
            ScanTranslationCaptureUI.m(ScanTranslationCaptureUI.this).setImageResource(2131691336);
            ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, 2);
            ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).efP += 1L;
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
    this.ysS = findViewById(2131306077);
    this.ysT = findViewById(2131306071);
    hideTitleView();
    setMMTitle(2131762808);
    setActionbarColor(getResources().getColor(2131101053));
    this.ryX = ((ImageView)findViewById(2131304314));
    this.ysR = this.ysP.findViewById(2131306073);
    this.ysR.setOnClickListener(new View.OnClickListener()
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
        //   28: invokevirtual 53	com/tencent/mm/hellhoundlib/b/b:ahq	()[Ljava/lang/Object;
        //   31: invokestatic 59	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V
        //   34: aload_0
        //   35: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:yti	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   38: invokestatic 63	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:e	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)I
        //   41: iconst_2
        //   42: if_icmpne +70 -> 112
        //   45: aload_0
        //   46: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:yti	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   49: invokestatic 67	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:j	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)Lcom/tencent/mm/g/b/a/dk;
        //   52: lconst_1
        //   53: putfield 73	com/tencent/mm/g/b/a/dk:efR	J
        //   56: aload_0
        //   57: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:yti	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   60: aload_0
        //   61: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:yti	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
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
        //   106: invokestatic 101	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   109: goto -31 -> 78
        //   112: aload_0
        //   113: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:yti	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   116: invokestatic 63	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:e	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)I
        //   119: iconst_3
        //   120: if_icmpne -42 -> 78
        //   123: aload_0
        //   124: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:yti	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   127: invokestatic 67	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:j	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)Lcom/tencent/mm/g/b/a/dk;
        //   130: lconst_1
        //   131: putfield 104	com/tencent/mm/g/b/a/dk:efQ	J
        //   134: aload_0
        //   135: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:yti	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   138: invokestatic 107	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:p	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)I
        //   141: istore_2
        //   142: iload_2
        //   143: ifne +48 -> 191
        //   146: aload_0
        //   147: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:yti	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   150: ldc 109
        //   152: invokestatic 115	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
        //   155: checkcast 109	com/tencent/mm/plugin/scanner/PluginScanTranslation
        //   158: ldc 117
        //   160: invokevirtual 121	com/tencent/mm/plugin/scanner/PluginScanTranslation:genTranslationResultImgPath	(Ljava/lang/String;)Ljava/lang/String;
        //   163: invokestatic 124	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:a	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;Ljava/lang/String;)Ljava/lang/String;
        //   166: pop
        //   167: aload_0
        //   168: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:yti	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   171: invokestatic 128	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:n	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)Landroid/graphics/Bitmap;
        //   174: bipush 80
        //   176: getstatic 134	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
        //   179: aload_0
        //   180: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:yti	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   183: invokestatic 137	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:q	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)Ljava/lang/String;
        //   186: iconst_0
        //   187: invokestatic 142	com/tencent/mm/sdk/platformtools/g:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
        //   190: pop
        //   191: aload_0
        //   192: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:yti	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   195: aload_0
        //   196: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:yti	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
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
        //   226: invokestatic 101	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   229: goto -151 -> 78
        //   232: astore_1
        //   233: ldc 93
        //   235: aload_1
        //   236: ldc 147
        //   238: iconst_0
        //   239: anewarray 4	java/lang/Object
        //   242: invokestatic 101	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    this.ltB = getWindowManager().getDefaultDisplay().getHeight();
    this.rza = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.rza.addListener(new AnimatorListenerAdapter()
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
    this.rza.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    Object localObject = (RelativeLayout.LayoutParams)this.ysP.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin += al.ej(this);
    this.ysP.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.rza.setDuration(5000L);
    com.tencent.mm.ui.base.b.a(this, null);
    this.iVL.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(120866);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$11", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
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
                ScanTranslationCaptureUI.h(ScanTranslationCaptureUI.this).dKG();
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
    dLM();
    this.yta = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.yta.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    this.yta.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(120868);
        ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, false);
        ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this).setVisibility(8);
        AppMethodBeat.o(120868);
      }
    });
    this.yta.setDuration(300L);
    localObject = new ou();
    ((ou)localObject).dCM.action = 1;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    AppMethodBeat.o(120895);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(120922);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 561) && (paramInt2 == -1))
    {
      paramIntent = com.tencent.mm.ui.tools.a.j(this, paramIntent, d.azA());
      ad.i("MicroMsg.ScanTranslationCaptureUI", "select: [%s]", new Object[] { paramIntent });
      if (!bt.isNullOrNil(paramIntent))
      {
        this.itB = paramIntent;
        this.dnh = 1;
        this.ytf.eca = 2L;
        this.hnk = Exif.fromFile(paramIntent).getOrientationInDegree();
        ad.i("MicroMsg.ScanTranslationCaptureUI", "degree %s", new Object[] { Integer.valueOf(this.hnk) });
        paramIntent = com.tencent.mm.sdk.platformtools.g.aQg(paramIntent);
        if (paramIntent != null)
        {
          this.ysV = com.tencent.mm.sdk.platformtools.g.a(paramIntent, this.hnk);
          cwB();
          ab(this.ysV);
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
    this.ysK = new com.tencent.mm.plugin.scanner.a.a();
    initView();
    com.tencent.mm.sdk.b.a.IbL.c(this.yth);
    this.ytf.eca = 3L;
    AppMethodBeat.o(120894);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(120901);
    super.onDestroy();
    this.yta.removeAllUpdateListeners();
    this.rza.removeAllUpdateListeners();
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
    ad.i("MicroMsg.ScanTranslationCaptureUI", "get preview frame success, length %d", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
    if (paramArrayOfByte != null) {}
    try
    {
      if (paramArrayOfByte.length > 0)
      {
        this.ysV = null;
        long l = System.currentTimeMillis();
        paramCamera = this.ysK.fUk();
        paramArrayOfByte = new YuvImage(paramArrayOfByte, 17, paramCamera.x, paramCamera.y, null);
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        paramArrayOfByte.compressToJpeg(new Rect(0, 0, paramCamera.x, paramCamera.y), 100, localByteArrayOutputStream);
        paramArrayOfByte = com.tencent.mm.sdk.platformtools.g.cr(localByteArrayOutputStream.toByteArray());
        int i = (int)(System.currentTimeMillis() - l);
        if (paramArrayOfByte != null)
        {
          l = System.currentTimeMillis();
          this.ysV = com.tencent.mm.sdk.platformtools.g.a(paramArrayOfByte, this.ysK.getCameraRotation());
          ad.i("MicroMsg.ScanTranslationCaptureUI", "decode cost %d, rotate cost %d", new Object[] { Integer.valueOf(i), Integer.valueOf((int)(System.currentTimeMillis() - l)) });
          if (this.ysV != null)
          {
            this.itB = ((e)com.tencent.mm.kernel.g.ad(e.class)).genScanCaptureImgPath("jpg");
            cwB();
            ab(this.ysV);
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
        dDn();
        AppMethodBeat.o(120910);
        return;
      }
      this.jfA = false;
      h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(120880);
          paramAnonymousDialogInterface = ScanTranslationCaptureUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$21", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
    bnj();
    com.tencent.mm.kernel.g.aiU().a(294, this);
    com.tencent.mm.kernel.g.ajB().a(this.rzc);
    if (this.jfA)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null);
      ad.i("MicroMsg.ScanTranslationCaptureUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(120897);
        return;
      }
      dDn();
      AppMethodBeat.o(120897);
      return;
    }
    dLP();
    AppMethodBeat.o(120897);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(120919);
    ad.i("MicroMsg.ScanTranslationCaptureUI", "errType %s, errCode %s, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.scanner.model.j)paramn).ymP;
      if ((paramString != null) && (((com.tencent.mm.plugin.scanner.model.j)paramn).dlK == this.ytb))
      {
        this.ytf.efN = ((int)(System.currentTimeMillis() - ((com.tencent.mm.plugin.scanner.model.j)paramn).ymQ));
        ad.i("MicroMsg.ScanTranslationCaptureUI", "angle %f, translationInfos length %d", new Object[] { Float.valueOf(((com.tencent.mm.plugin.scanner.model.j)paramn).angle), Integer.valueOf(paramString.size()) });
        if (paramString.size() > 0)
        {
          this.ytf.ecx = 1L;
          ((PluginScanTranslation)com.tencent.mm.kernel.g.ad(PluginScanTranslation.class)).getTranslationRender().a(this.ytb, paramString, ((com.tencent.mm.plugin.scanner.model.j)paramn).angle, this.ysV, this);
          if (!bt.isNullOrNil(((com.tencent.mm.plugin.scanner.model.j)paramn).dKT()))
          {
            this.ytc = ((com.tencent.mm.plugin.scanner.model.j)paramn).dKT();
            AppMethodBeat.o(120919);
          }
        }
        else
        {
          this.ytf.efO = ((int)(System.currentTimeMillis() - this.ytg[1]));
          h.a(this, getString(2131762880), "", false, new DialogInterface.OnClickListener()
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
    this.ytf.ecx = 5L;
    this.ytf.efO = ((int)(System.currentTimeMillis() - this.ytg[1]));
    paramn = getString(2131762880);
    if (!bt.isNullOrNil(paramString)) {}
    for (;;)
    {
      h.a(this, paramString, "", false, new DialogInterface.OnClickListener()
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
    awW();
    com.tencent.mm.kernel.g.aiU().b(294, this);
    com.tencent.mm.sdk.b.a.IbL.d(this.yth);
    com.tencent.mm.kernel.g.ajB().b(this.rzc);
    AppMethodBeat.o(120900);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(120917);
    ad.i("MicroMsg.ScanTranslationCaptureUI", "surface texture available");
    this.ysJ.fzf();
    this.surfaceTexture = paramSurfaceTexture;
    if (this.jfA)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null);
      ad.i("MicroMsg.ScanTranslationCaptureUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(120917);
        return;
      }
      dDn();
      AppMethodBeat.o(120917);
      return;
    }
    if (!this.ysK.isOpen())
    {
      dLN();
      AppMethodBeat.o(120917);
      return;
    }
    dLR();
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
          paramView.fyy();
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