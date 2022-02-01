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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.pn;
import com.tencent.mm.g.b.a.go;
import com.tencent.mm.g.c.fx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.scanner.PluginScanTranslation;
import com.tencent.mm.plugin.scanner.model.aj;
import com.tencent.mm.plugin.scanner.model.m;
import com.tencent.mm.plugin.scanner.util.k;
import com.tencent.mm.plugin.scanner.util.k.b;
import com.tencent.mm.plugin.scanner.util.p.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.MMGestureGallery;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class ScanTranslationCaptureUI
  extends MMActivity
  implements Camera.PreviewCallback, TextureView.SurfaceTextureListener, i, k.b
{
  private View CMA;
  private View CMB;
  private View CMC;
  private ImageView CMD;
  private View CME;
  private View CMF;
  private View CMG;
  private TextView CMH;
  private Bitmap CMI;
  private Bitmap CMJ;
  private String CMK;
  private a CML;
  private MMGestureGallery CMM;
  private ValueAnimator CMN;
  private int CMO;
  private String CMP;
  private boolean CMQ;
  private int CMR;
  private go CMS;
  private long[] CMT;
  private IListener<pn> CMU;
  private MMTextureView CMw;
  private com.tencent.mm.plugin.scanner.a.a CMx;
  private View CMy;
  private View CMz;
  private int iOu;
  private int ijt;
  private View jWj;
  private String jrK;
  private boolean kgv;
  private int mEY;
  private int source;
  private SurfaceTexture surfaceTexture;
  private ImageView tgP;
  private ValueAnimator tgS;
  private com.tencent.mm.network.p tgU;
  private String xCU;
  
  public ScanTranslationCaptureUI()
  {
    AppMethodBeat.i(120893);
    this.kgv = true;
    this.CMR = 0;
    this.source = 0;
    this.ijt = 0;
    this.CMS = new go();
    this.CMT = new long[2];
    this.CMU = new IListener() {};
    this.tgU = new com.tencent.mm.network.p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(120878);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(120877);
            if ((g.azz().aYS() != 6) && (g.azz().aYS() != 4) && (ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) == 1))
            {
              h.c(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(2131764951), "", true);
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
  
  private void KD()
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
  
  private void aPK()
  {
    AppMethodBeat.i(120905);
    try
    {
      stopPreview();
      this.CMx.close();
      AppMethodBeat.o(120905);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ScanTranslationCaptureUI", localException.getMessage());
      AppMethodBeat.o(120905);
    }
  }
  
  private void an(Bitmap paramBitmap)
  {
    AppMethodBeat.i(120920);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(120920);
      return;
    }
    this.CML.bitmap = paramBitmap;
    this.CML.notifyDataSetChanged();
    AppMethodBeat.o(120920);
  }
  
  private void cWg()
  {
    AppMethodBeat.i(120913);
    stopPreview();
    if ((g.azz().aYS() != 6) && (g.azz().aYS() != 4))
    {
      h.c(this, getString(2131764951), "", true);
      eQU();
      AppMethodBeat.o(120913);
      return;
    }
    this.CMS.eEt = 2L;
    this.CMO = ((int)(z.aTY().hashCode() + System.currentTimeMillis() & 0xFFFFFFFF));
    this.iOu = 1;
    showTitleView();
    eQT();
    eQP();
    if (this.CMP.equalsIgnoreCase("zh_CN"))
    {
      this.CMD.setImageResource(2131691667);
      this.CMF.setVisibility(0);
      this.CMG.setVisibility(0);
      this.CMC.setVisibility(8);
      this.tgP.setVisibility(0);
      this.CMB.setVisibility(8);
      this.CMM.setVisibility(0);
      this.CMH.setVisibility(8);
      this.tgS.setRepeatMode(1);
      this.tgS.setRepeatCount(-1);
      this.tgS.start();
    }
    try
    {
      if ((Util.isNullOrNil(this.jrK)) || (this.CMI == null)) {
        break label368;
      }
      this.xCU = com.tencent.mm.plugin.scanner.util.p.aMv(this.jrK);
      str2 = this.jrK;
      if (this.source != 0) {
        break label398;
      }
      l = System.currentTimeMillis();
      BitmapUtil.saveBitmapToImage(this.CMI, 80, Bitmap.CompressFormat.JPEG, this.jrK, false);
      Log.i("MicroMsg.ScanTranslationCaptureUI", "save img cost %d", new Object[] { Integer.valueOf((int)(System.currentTimeMillis() - l)) });
      Log.i("MicroMsg.ScanTranslationCaptureUI", "fileSize %d", new Object[] { Long.valueOf(com.tencent.mm.vfs.s.boW(this.jrK)) });
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
        Log.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", localException, "", new Object[0]);
        label398:
        continue;
        Log.w("MicroMsg.ScanTranslationCaptureUI", "can not find old translation result!");
        String str1 = str2;
        if (this.ijt != 0)
        {
          l = System.currentTimeMillis();
          str1 = ((com.tencent.mm.plugin.scanner.f)g.ah(com.tencent.mm.plugin.scanner.f.class)).genScanTmpImgPath("jpg");
          BitmapUtil.saveBitmapToImage(this.CMI, 80, Bitmap.CompressFormat.JPEG, str1, false);
          Log.i("MicroMsg.ScanTranslationCaptureUI", "save img cost %d", new Object[] { Integer.valueOf((int)(System.currentTimeMillis() - l)) });
          Log.i("MicroMsg.ScanTranslationCaptureUI", "fileSize %d", new Object[] { Long.valueOf(com.tencent.mm.vfs.s.boW(str1)) });
        }
      }
    }
    this.CMT[1] = System.currentTimeMillis();
    ((com.tencent.mm.plugin.scanner.f)g.ah(com.tencent.mm.plugin.scanner.f.class)).getScanCdnService().a(this.xCU, (String)localObject, com.tencent.mm.i.a.MediaType_IMAGE, new com.tencent.mm.plugin.scanner.util.p.a()
    {
      public final void a(String paramAnonymousString, p.b paramAnonymousb)
      {
        AppMethodBeat.i(120873);
        if ((!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(ScanTranslationCaptureUI.w(ScanTranslationCaptureUI.this))))
        {
          ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).eJU = ((int)(System.currentTimeMillis() - ScanTranslationCaptureUI.i(ScanTranslationCaptureUI.this)[1]));
          Log.i("MicroMsg.ScanTranslationCaptureUI", "upload img cost %d", new Object[] { Long.valueOf(ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).eJU) });
          ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).uq(paramAnonymousb.fileId);
          ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).ur(paramAnonymousb.aeskey);
          switch (paramAnonymousb.errCode)
          {
          }
        }
        for (;;)
        {
          if ((ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) == 1) && (ScanTranslationCaptureUI.y(ScanTranslationCaptureUI.this) != 0))
          {
            Log.i("delete tmp path %s", this.CzP);
            com.tencent.mm.vfs.s.deleteFile(this.CzP);
          }
          AppMethodBeat.o(120873);
          return;
          if (!Util.isNullOrNil(new String[] { paramAnonymousb.fileId, paramAnonymousb.aeskey }))
          {
            Log.i("MicroMsg.ScanTranslationCaptureUI", "fileId %s", new Object[] { paramAnonymousb.fileId });
            paramAnonymousString = new m(ScanTranslationCaptureUI.x(ScanTranslationCaptureUI.this), (int)com.tencent.mm.vfs.s.boW(this.CzP), paramAnonymousb.fileId, paramAnonymousb.aeskey);
            g.azz().a(paramAnonymousString, 0);
          }
          else
          {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(120870);
                ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).eEt = 3L;
                h.cD(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(2131764991));
                AppMethodBeat.o(120870);
              }
            });
            continue;
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(120872);
                h.d(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(2131759383), ScanTranslationCaptureUI.this.getString(2131755998), new DialogInterface.OnClickListener()
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
            ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).eEt = 3L;
          }
        }
      }
    });
    for (;;)
    {
      g.azz().a(294, this);
      AppMethodBeat.o(120913);
      return;
      this.CMD.setImageResource(2131691670);
      break;
      localObject = str2;
      if (this.source != 1) {
        break label325;
      }
      localObject = MD5Util.getMD5String(this.jrK + com.tencent.mm.vfs.s.boX(this.jrK));
      localObject = ((PluginScanTranslation)g.ah(PluginScanTranslation.class)).getTranslationResultStorage().aMG((String)localObject);
      if (localObject == null) {
        break label544;
      }
      Log.i("MicroMsg.ScanTranslationCaptureUI", "already has translation result");
      this.CMK = ((fx)localObject).field_resultFile;
      this.CMJ = BitmapUtil.decodeFile(this.CMK, new BitmapFactory.Options());
      if (this.CMJ == null) {
        break label536;
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
  
  private void cWj()
  {
    AppMethodBeat.i(120916);
    this.tgS.setRepeatMode(1);
    this.tgS.setRepeatCount(0);
    this.tgS.end();
    AppMethodBeat.o(120916);
  }
  
  private void eHs()
  {
    AppMethodBeat.i(120903);
    if (!com.tencent.mm.compatible.e.b.apj())
    {
      h.a(this, getString(2131755992), getString(2131755911), getString(2131755912), true, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(120875);
          com.tencent.mm.compatible.e.b.cw(ScanTranslationCaptureUI.this);
          ScanTranslationCaptureUI.this.finish();
          AppMethodBeat.o(120875);
        }
      });
      AppMethodBeat.o(120903);
      return;
    }
    eQS();
    AppMethodBeat.o(120903);
  }
  
  private void eQP()
  {
    AppMethodBeat.i(120896);
    LocaleUtil.getApplicationLanguage().equalsIgnoreCase("zh_CN");
    this.CMP = LocaleUtil.getCurrentLanguage(this);
    Log.i("MicroMsg.ScanTranslationCaptureUI", "targetLang %s", new Object[] { this.CMP });
    AppMethodBeat.o(120896);
  }
  
  private void eQQ()
  {
    AppMethodBeat.i(120904);
    try
    {
      if (!this.CMx.isOpen())
      {
        long l = System.currentTimeMillis();
        this.CMx.aqD(getWindowManager().getDefaultDisplay().getRotation());
        this.CMx.a(new Camera.PreviewCallback()
        {
          public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera) {}
        });
        Log.i("MicroMsg.ScanTranslationCaptureUI", "open camera cost %s, failed count %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(this.CMR) });
        this.CMx.ePB();
        Rect localRect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
        this.CMx.p(new Point(localRect.width(), localRect.height()));
        if (this.iOu == 0) {
          eQU();
        }
        this.CMR = 0;
      }
      AppMethodBeat.o(120904);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ScanTranslationCaptureUI", localException.getMessage());
      this.CMR += 1;
      if (this.CMR >= 5)
      {
        eQR();
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
  
  private void eQR()
  {
    AppMethodBeat.i(120908);
    h.a(this, getString(2131764962), getString(2131755998), false, new DialogInterface.OnClickListener()
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
  
  private void eQS()
  {
    AppMethodBeat.i(120909);
    Log.i("MicroMsg.ScanTranslationCaptureUI", "curState %d", new Object[] { Integer.valueOf(this.iOu) });
    if (!this.CMx.isOpen()) {
      eQQ();
    }
    if ((this.iOu == 0) && (this.CMx.isOpen())) {
      eQU();
    }
    AppMethodBeat.o(120909);
  }
  
  private void eQT()
  {
    AppMethodBeat.i(120912);
    getController().setNavigationbarColor(getResources().getColor(2131101287));
    getWindow().getDecorView().setSystemUiVisibility(1796);
    AppMethodBeat.o(120912);
  }
  
  private void eQU()
  {
    AppMethodBeat.i(120914);
    KD();
    startPreview();
    hideTitleView();
    this.CMT[0] = System.currentTimeMillis();
    if ((this.source == 0) && (!Util.isNullOrNil(this.jrK))) {
      com.tencent.mm.vfs.s.deleteFile(this.jrK);
    }
    this.iOu = 0;
    this.source = 0;
    this.jrK = null;
    this.CMK = null;
    this.CMI = null;
    this.CMJ = null;
    this.ijt = 0;
    this.CMF.setVisibility(8);
    this.CMG.setVisibility(8);
    this.CMB.setVisibility(0);
    this.CMC.setVisibility(8);
    this.CMM.setVisibility(8);
    this.CMw.setVisibility(0);
    this.CMH.setVisibility(0);
    this.tgP.setVisibility(8);
    cWj();
    g.azz().b(294, this);
    AppMethodBeat.o(120914);
  }
  
  private void eQV()
  {
    AppMethodBeat.i(120915);
    eQT();
    this.iOu = 3;
    this.CMC.setVisibility(0);
    if (this.CMP.equalsIgnoreCase("zh_CN")) {
      this.CMD.setImageResource(2131235352);
    }
    for (;;)
    {
      this.tgP.setVisibility(8);
      cWj();
      if ((this.source != 1) || (!Util.isNullOrNil(this.CMK))) {
        break label234;
      }
      this.CMK = ((PluginScanTranslation)g.ah(PluginScanTranslation.class)).genTranslationResultImgPath("jpg");
      try
      {
        BitmapUtil.saveBitmapToImage(this.CMJ, 80, Bitmap.CompressFormat.JPEG, this.CMK, false);
        aj localaj = new aj();
        localaj.field_originMD5 = MD5Util.getMD5String(this.jrK + com.tencent.mm.vfs.s.boX(this.jrK));
        localaj.field_resultFile = this.CMK;
        Log.i("MicroMsg.ScanTranslationCaptureUI", "insert translate result %s", new Object[] { this.CMK });
        ((PluginScanTranslation)g.ah(PluginScanTranslation.class)).getTranslationResultStorage().a(localaj);
        AppMethodBeat.o(120915);
        return;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", localIOException, "save translate result file error", new Object[0]);
      }
      this.CMD.setImageResource(2131235354);
    }
    label234:
    AppMethodBeat.o(120915);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(120902);
    ((PluginScanTranslation)g.ah(PluginScanTranslation.class)).getTranslationRender().eRW();
    if (this.iOu == 0)
    {
      if (this.CMQ)
      {
        Log.i("MicroMsg.ScanTranslationCaptureUI", "is playing animation");
        AppMethodBeat.o(120902);
        return;
      }
      this.CMN.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(120874);
          paramAnonymousAnimator = new pn();
          paramAnonymousAnimator.dVF.action = 3;
          EventCenter.instance.publish(paramAnonymousAnimator);
          ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, false);
          ScanTranslationCaptureUI.z(ScanTranslationCaptureUI.this);
          ScanTranslationCaptureUI.this.finish();
          AppMethodBeat.o(120874);
        }
      });
      this.CMN.reverse();
      this.CMQ = true;
      AppMethodBeat.o(120902);
      return;
    }
    if ((this.iOu == 1) || (this.iOu == 2) || (this.iOu == 3))
    {
      if (this.iOu == 1) {
        this.CMS.eJW = ((int)(System.currentTimeMillis() - this.CMT[1]));
      }
      if (this.CMS.eEt != 0L) {
        this.CMS.bfK();
      }
      eQU();
    }
    AppMethodBeat.o(120902);
  }
  
  private void startPreview()
  {
    AppMethodBeat.i(120907);
    try
    {
      if ((this.surfaceTexture != null) && (this.CMx.isOpen()) && (!this.CMx.dEO()))
      {
        Log.i("MicroMsg.ScanTranslationCaptureUI", "start preview");
        this.CMx.r(this.surfaceTexture);
        this.CMz.setEnabled(true);
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
      eQR();
      AppMethodBeat.o(120907);
    }
  }
  
  private void stopPreview()
  {
    AppMethodBeat.i(120906);
    try
    {
      if (this.CMx.dEO()) {
        this.CMx.stopPreview();
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
  
  public final void d(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(120921);
    if ((paramBitmap != null) && (paramInt == this.CMO))
    {
      this.CMS.eJW = ((int)(System.currentTimeMillis() - this.CMT[1]));
      this.CMJ = paramBitmap;
      eQV();
      an(this.CMJ);
    }
    AppMethodBeat.o(120921);
  }
  
  public int getLayoutId()
  {
    return 2131496156;
  }
  
  public void initView()
  {
    AppMethodBeat.i(120895);
    this.jWj = findViewById(2131307160);
    this.jWj.setAlpha(0.0F);
    this.CMw = ((MMTextureView)findViewById(2131309402));
    this.CMw.setOpaque(false);
    this.CMw.setSurfaceTextureListener(this);
    this.CMM = ((MMGestureGallery)findViewById(2131309404));
    this.CML = new a((byte)0);
    this.CMM.setAdapter(this.CML);
    this.CMB = findViewById(2131297995);
    this.CMy = findViewById(2131307272);
    this.CMy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120884);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        ScanTranslationCaptureUI.g(ScanTranslationCaptureUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120884);
      }
    });
    this.CMz = findViewById(2131307235);
    this.CMz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120885);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        ScanTranslationCaptureUI.h(ScanTranslationCaptureUI.this).a(ScanTranslationCaptureUI.this);
        ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).eJT = ((int)(System.currentTimeMillis() - ScanTranslationCaptureUI.i(ScanTranslationCaptureUI.this)[0]));
        ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).eDV = 1L;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120885);
      }
    });
    this.CMz.setEnabled(false);
    this.CMH = ((TextView)findViewById(2131307236));
    this.CMA = findViewById(2131307273);
    this.CMA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120886);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        com.tencent.mm.pluginsdk.ui.tools.s.a(ScanTranslationCaptureUI.this, 561, 1, 0, 1, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120886);
      }
    });
    this.CMC = findViewById(2131307217);
    this.CMD = ((ImageView)this.CMC.findViewById(2131309409));
    this.CMD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120887);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) == 3)
        {
          if (ScanTranslationCaptureUI.k(ScanTranslationCaptureUI.this) != null) {
            ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.k(ScanTranslationCaptureUI.this));
          }
          if (ScanTranslationCaptureUI.l(ScanTranslationCaptureUI.this).equalsIgnoreCase("zh_CN"))
          {
            ScanTranslationCaptureUI.m(ScanTranslationCaptureUI.this).setImageResource(2131691668);
            ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, 2);
            ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).eJX += 1L;
          }
        }
        while (ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) != 2) {
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(120887);
            return;
            ScanTranslationCaptureUI.m(ScanTranslationCaptureUI.this).setImageResource(2131691671);
          }
        }
        if (ScanTranslationCaptureUI.n(ScanTranslationCaptureUI.this) != null) {
          ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.n(ScanTranslationCaptureUI.this));
        }
        if (ScanTranslationCaptureUI.l(ScanTranslationCaptureUI.this).equalsIgnoreCase("zh_CN")) {
          ScanTranslationCaptureUI.m(ScanTranslationCaptureUI.this).setImageResource(2131235352);
        }
        for (;;)
        {
          ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, 3);
          break;
          ScanTranslationCaptureUI.m(ScanTranslationCaptureUI.this).setImageResource(2131235354);
        }
      }
    });
    this.CMF = findViewById(2131309408);
    this.CMG = findViewById(2131309401);
    hideTitleView();
    setMMTitle(2131764905);
    setActionbarColor(getResources().getColor(2131101287));
    this.tgP = ((ImageView)findViewById(2131307243));
    this.CME = this.CMC.findViewById(2131309403);
    this.CME.setOnClickListener(new View.OnClickListener()
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
        //   15: invokevirtual 44	com/tencent/mm/hellhoundlib/b/b:bm	(Ljava/lang/Object;)V
        //   18: ldc 46
        //   20: ldc 47
        //   22: ldc 48
        //   24: ldc 49
        //   26: aload_0
        //   27: aload_3
        //   28: invokevirtual 53	com/tencent/mm/hellhoundlib/b/b:axR	()[Ljava/lang/Object;
        //   31: invokestatic 59	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V
        //   34: aload_0
        //   35: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:CMV	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   38: invokestatic 63	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:e	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)I
        //   41: iconst_2
        //   42: if_icmpne +70 -> 112
        //   45: aload_0
        //   46: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:CMV	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   49: invokestatic 67	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:j	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)Lcom/tencent/mm/g/b/a/go;
        //   52: lconst_1
        //   53: putfield 73	com/tencent/mm/g/b/a/go:eJZ	J
        //   56: aload_0
        //   57: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:CMV	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   60: aload_0
        //   61: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:CMV	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
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
        //   106: invokestatic 101	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   109: goto -31 -> 78
        //   112: aload_0
        //   113: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:CMV	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   116: invokestatic 63	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:e	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)I
        //   119: iconst_3
        //   120: if_icmpne -42 -> 78
        //   123: aload_0
        //   124: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:CMV	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   127: invokestatic 67	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:j	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)Lcom/tencent/mm/g/b/a/go;
        //   130: lconst_1
        //   131: putfield 104	com/tencent/mm/g/b/a/go:eJY	J
        //   134: aload_0
        //   135: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:CMV	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   138: invokestatic 107	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:p	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)I
        //   141: istore_2
        //   142: iload_2
        //   143: ifne +48 -> 191
        //   146: aload_0
        //   147: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:CMV	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   150: ldc 109
        //   152: invokestatic 115	com/tencent/mm/kernel/g:ah	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
        //   155: checkcast 109	com/tencent/mm/plugin/scanner/PluginScanTranslation
        //   158: ldc 117
        //   160: invokevirtual 121	com/tencent/mm/plugin/scanner/PluginScanTranslation:genTranslationResultImgPath	(Ljava/lang/String;)Ljava/lang/String;
        //   163: invokestatic 124	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:a	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;Ljava/lang/String;)Ljava/lang/String;
        //   166: pop
        //   167: aload_0
        //   168: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:CMV	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   171: invokestatic 128	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:n	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)Landroid/graphics/Bitmap;
        //   174: bipush 80
        //   176: getstatic 134	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
        //   179: aload_0
        //   180: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:CMV	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   183: invokestatic 137	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:q	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)Ljava/lang/String;
        //   186: iconst_0
        //   187: invokestatic 143	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
        //   190: pop
        //   191: aload_0
        //   192: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:CMV	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   195: aload_0
        //   196: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:CMV	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   199: invokestatic 137	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:q	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)Ljava/lang/String;
        //   202: new 15	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22$2
        //   205: dup
        //   206: aload_0
        //   207: invokespecial 144	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22$2:<init>	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22;)V
        //   210: invokestatic 86	com/tencent/mm/platformtools/p:a	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/platformtools/p$a;)V
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
    this.mEY = getWindowManager().getDefaultDisplay().getHeight();
    this.tgS = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.tgS.addListener(new AnimatorListenerAdapter()
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
    this.tgS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    Object localObject = (RelativeLayout.LayoutParams)this.CMC.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin += ao.aD(this);
    this.CMC.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.tgS.setDuration(5000L);
    com.tencent.mm.ui.base.b.a(this, null);
    this.jWj.setOnTouchListener(new View.OnTouchListener()
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
                ScanTranslationCaptureUI.h(ScanTranslationCaptureUI.this).cancelAutoFocus();
                ScanTranslationCaptureUI.h(ScanTranslationCaptureUI.this).ePB();
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
    eQP();
    this.CMN = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.CMN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    this.CMN.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(120868);
        ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, false);
        ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this).setVisibility(8);
        AppMethodBeat.o(120868);
      }
    });
    this.CMN.setDuration(300L);
    localObject = new pn();
    ((pn)localObject).dVF.action = 1;
    EventCenter.instance.publish((IEvent)localObject);
    AppMethodBeat.o(120895);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(120922);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 561) && (paramInt2 == -1))
    {
      paramIntent = com.tencent.mm.ui.tools.a.i(this, paramIntent, d.aSY());
      Log.i("MicroMsg.ScanTranslationCaptureUI", "select: [%s]", new Object[] { paramIntent });
      if (!Util.isNullOrNil(paramIntent))
      {
        this.jrK = paramIntent;
        this.source = 1;
        this.CMS.eDV = 2L;
        this.ijt = Exif.fromFile(paramIntent).getOrientationInDegree();
        Log.i("MicroMsg.ScanTranslationCaptureUI", "degree %s", new Object[] { Integer.valueOf(this.ijt) });
        paramIntent = BitmapUtil.decodeFileWithSample(paramIntent);
        if (paramIntent != null)
        {
          this.CMI = BitmapUtil.rotate(paramIntent, this.ijt);
          cWg();
          an(this.CMI);
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
    this.CMx = new com.tencent.mm.plugin.scanner.a.a();
    initView();
    EventCenter.instance.addListener(this.CMU);
    this.CMS.eDV = 3L;
    AppMethodBeat.o(120894);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(120901);
    super.onDestroy();
    this.CMN.removeAllUpdateListeners();
    this.tgS.removeAllUpdateListeners();
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
    Log.i("MicroMsg.ScanTranslationCaptureUI", "get preview frame success, length %d", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
    if (paramArrayOfByte != null) {}
    try
    {
      if (paramArrayOfByte.length > 0)
      {
        this.CMI = null;
        long l = System.currentTimeMillis();
        paramCamera = this.CMx.hkU();
        paramArrayOfByte = new YuvImage(paramArrayOfByte, 17, paramCamera.x, paramCamera.y, null);
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        paramArrayOfByte.compressToJpeg(new Rect(0, 0, paramCamera.x, paramCamera.y), 100, localByteArrayOutputStream);
        paramArrayOfByte = BitmapUtil.decodeByteArray(localByteArrayOutputStream.toByteArray());
        int i = (int)(System.currentTimeMillis() - l);
        if (paramArrayOfByte != null)
        {
          l = System.currentTimeMillis();
          this.CMI = BitmapUtil.rotate(paramArrayOfByte, this.CMx.getCameraRotation());
          Log.i("MicroMsg.ScanTranslationCaptureUI", "decode cost %d, rotate cost %d", new Object[] { Integer.valueOf(i), Integer.valueOf((int)(System.currentTimeMillis() - l)) });
          if (this.CMI != null)
          {
            this.jrK = ((com.tencent.mm.plugin.scanner.f)g.ah(com.tencent.mm.plugin.scanner.f.class)).genScanCaptureImgPath("jpg");
            cWg();
            an(this.CMI);
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
        eHs();
        AppMethodBeat.o(120910);
        return;
      }
      this.kgv = false;
      h.a(this, getString(2131763864), getString(2131763890), getString(2131762043), getString(2131755761), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(120880);
          paramAnonymousDialogInterface = ScanTranslationCaptureUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$21", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
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
    KD();
    g.azz().a(294, this);
    g.aAg().a(this.tgU);
    if (this.kgv)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null);
      Log.i("MicroMsg.ScanTranslationCaptureUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(120897);
        return;
      }
      eHs();
      AppMethodBeat.o(120897);
      return;
    }
    eQS();
    AppMethodBeat.o(120897);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(120919);
    Log.i("MicroMsg.ScanTranslationCaptureUI", "errType %s, errCode %s, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((m)paramq).CFD;
      if ((paramString != null) && (((m)paramq).dEb == this.CMO))
      {
        this.CMS.eJV = ((int)(System.currentTimeMillis() - ((m)paramq).CFE));
        Log.i("MicroMsg.ScanTranslationCaptureUI", "angle %f, translationInfos length %d", new Object[] { Float.valueOf(((m)paramq).angle), Integer.valueOf(paramString.size()) });
        if (paramString.size() > 0)
        {
          this.CMS.eEt = 1L;
          ((PluginScanTranslation)g.ah(PluginScanTranslation.class)).getTranslationRender().a(this.CMO, paramString, ((m)paramq).angle, this.CMI, this);
          if (!Util.isNullOrNil(((m)paramq).ePR()))
          {
            this.CMP = ((m)paramq).ePR();
            AppMethodBeat.o(120919);
          }
        }
        else
        {
          this.CMS.eJW = ((int)(System.currentTimeMillis() - this.CMT[1]));
          h.a(this, getString(2131764991), "", false, new DialogInterface.OnClickListener()
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
    this.CMS.eEt = 5L;
    this.CMS.eJW = ((int)(System.currentTimeMillis() - this.CMT[1]));
    paramq = getString(2131764991);
    if (!Util.isNullOrNil(paramString)) {}
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
      paramString = paramq;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(120900);
    super.onStop();
    aPK();
    g.azz().b(294, this);
    EventCenter.instance.removeListener(this.CMU);
    g.aAg().b(this.tgU);
    AppMethodBeat.o(120900);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(120917);
    Log.i("MicroMsg.ScanTranslationCaptureUI", "surface texture available");
    this.CMw.gLi();
    this.surfaceTexture = paramSurfaceTexture;
    if (this.kgv)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null);
      Log.i("MicroMsg.ScanTranslationCaptureUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(120917);
        return;
      }
      eHs();
      AppMethodBeat.o(120917);
      return;
    }
    if (!this.CMx.isOpen())
    {
      eQQ();
      AppMethodBeat.o(120917);
      return;
    }
    eQU();
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
          paramView.cN(this.bitmap.getWidth(), this.bitmap.getHeight());
          paramView.gKy();
        }
        AppMethodBeat.o(120892);
        return paramView;
        paramView = (MultiTouchImageView)paramView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI
 * JD-Core Version:    0.7.0.1
 */