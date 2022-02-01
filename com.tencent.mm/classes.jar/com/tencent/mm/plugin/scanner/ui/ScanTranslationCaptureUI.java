package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
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
import android.view.MotionEvent;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.f.a.ql;
import com.tencent.mm.f.b.a.it;
import com.tencent.mm.f.c.ge;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.z;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.al.a.b;
import com.tencent.mm.plugin.al.a.c;
import com.tencent.mm.plugin.al.a.d;
import com.tencent.mm.plugin.al.a.e;
import com.tencent.mm.plugin.al.a.f;
import com.tencent.mm.plugin.al.a.g;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.scanner.PluginScanTranslation;
import com.tencent.mm.plugin.scanner.g;
import com.tencent.mm.plugin.scanner.model.ah;
import com.tencent.mm.plugin.scanner.util.k.a;
import com.tencent.mm.plugin.scanner.util.k.b;
import com.tencent.mm.plugin.scanner.util.l;
import com.tencent.mm.plugin.scanner.util.l.b;
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
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.w;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class ScanTranslationCaptureUI
  extends MMActivity
  implements Camera.PreviewCallback, TextureView.SurfaceTextureListener, i, l.b
{
  private String CGU;
  private MMTextureView IRW;
  private com.tencent.mm.plugin.scanner.a.a IRX;
  private View IRY;
  private View IRZ;
  private View ISa;
  private View ISb;
  private View ISc;
  private ImageView ISd;
  private View ISe;
  private View ISf;
  private View ISg;
  private TextView ISh;
  private Bitmap ISi;
  private Bitmap ISj;
  private String ISk;
  private ScanTranslationCaptureUI.a ISl;
  private MMGestureGallery ISm;
  private ValueAnimator ISn;
  private int ISo;
  private String ISp;
  private boolean ISq;
  private int ISr;
  private it ISs;
  private long[] ISt;
  private IListener<ql> ISu;
  private int kYg;
  private int lEK;
  private View mNv;
  private boolean mXU;
  private String mhn;
  private int pEk;
  private int source;
  private SurfaceTexture surfaceTexture;
  private ImageView wNf;
  private ValueAnimator wNi;
  private p wNk;
  
  public ScanTranslationCaptureUI()
  {
    AppMethodBeat.i(120893);
    this.mXU = true;
    this.ISr = 0;
    this.source = 0;
    this.kYg = 0;
    this.ISs = new it();
    this.ISt = new long[2];
    this.ISu = new IListener() {};
    this.wNk = new com.tencent.mm.network.p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(120878);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(120877);
            if ((com.tencent.mm.kernel.h.aGY().bih() != 6) && (com.tencent.mm.kernel.h.aGY().bih() != 4) && (ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) == 1))
            {
              com.tencent.mm.ui.base.h.c(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(a.g.scan_no_network), "", true);
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
  
  private void Nq()
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
  
  private void TL()
  {
    AppMethodBeat.i(120906);
    try
    {
      if (this.IRX.egx()) {
        this.IRX.TL();
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
  
  private void aYA()
  {
    AppMethodBeat.i(120905);
    try
    {
      TL();
      this.IRX.close();
      AppMethodBeat.o(120905);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ScanTranslationCaptureUI", localException.getMessage());
      AppMethodBeat.o(120905);
    }
  }
  
  private void ak(Bitmap paramBitmap)
  {
    AppMethodBeat.i(120920);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(120920);
      return;
    }
    this.ISl.bitmap = paramBitmap;
    this.ISl.notifyDataSetChanged();
    AppMethodBeat.o(120920);
  }
  
  private void ave()
  {
    AppMethodBeat.i(120907);
    try
    {
      if ((this.surfaceTexture != null) && (this.IRX.isOpen()) && (!this.IRX.egx()))
      {
        Log.i("MicroMsg.ScanTranslationCaptureUI", "start preview");
        this.IRX.u(this.surfaceTexture);
        this.IRZ.setEnabled(true);
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
      fDR();
      AppMethodBeat.o(120907);
    }
  }
  
  private void dAz()
  {
    AppMethodBeat.i(120904);
    try
    {
      if (!this.IRX.isOpen())
      {
        long l = System.currentTimeMillis();
        this.IRX.aAq(getWindowManager().getDefaultDisplay().getRotation());
        this.IRX.c(new ScanTranslationCaptureUI.10(this));
        Log.i("MicroMsg.ScanTranslationCaptureUI", "open camera cost %s, failed count %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(this.ISr) });
        this.IRX.fCo();
        Rect localRect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
        this.IRX.o(new Point(localRect.width(), localRect.height()));
        if (this.lEK == 0) {
          fDU();
        }
        this.ISr = 0;
      }
      AppMethodBeat.o(120904);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ScanTranslationCaptureUI", localException.getMessage());
      this.ISr += 1;
      if (this.ISr >= 5)
      {
        fDR();
        AppMethodBeat.o(120904);
        return;
      }
      MMHandlerThread.postToMainThreadDelayed(new ScanTranslationCaptureUI.11(this), 30L);
      AppMethodBeat.o(120904);
    }
  }
  
  private void dln()
  {
    AppMethodBeat.i(120913);
    TL();
    if ((com.tencent.mm.kernel.h.aGY().bih() != 6) && (com.tencent.mm.kernel.h.aGY().bih() != 4))
    {
      com.tencent.mm.ui.base.h.c(this, getString(a.g.scan_no_network), "", true);
      fDU();
      AppMethodBeat.o(120913);
      return;
    }
    this.ISs.gBP = 2L;
    this.ISo = ((int)(z.bcZ().hashCode() + System.currentTimeMillis() & 0xFFFFFFFF));
    this.lEK = 1;
    showTitleView();
    fDT();
    fDQ();
    if (this.ISp.equalsIgnoreCase("zh_CN")) {
      this.ISd.setImageResource(a.f.translation_result_chinese);
    }
    for (;;)
    {
      this.ISf.setVisibility(0);
      this.ISg.setVisibility(0);
      this.ISc.setVisibility(8);
      this.wNf.setVisibility(0);
      this.ISb.setVisibility(8);
      this.ISm.setVisibility(0);
      this.ISh.setVisibility(8);
      this.wNi.setRepeatMode(1);
      this.wNi.setRepeatCount(-1);
      this.wNi.start();
      try
      {
        if ((!Util.isNullOrNil(this.mhn)) && (this.ISi != null))
        {
          this.CGU = com.tencent.mm.plugin.scanner.util.k.aXA(this.mhn);
          final String str1 = this.mhn;
          if (this.source != 0) {
            break label380;
          }
          l = System.currentTimeMillis();
          BitmapUtil.saveBitmapToImage(this.ISi, 80, Bitmap.CompressFormat.JPEG, this.mhn, false);
          Log.i("MicroMsg.ScanTranslationCaptureUI", "save img cost %d", new Object[] { Integer.valueOf((int)(System.currentTimeMillis() - l)) });
          Log.i("MicroMsg.ScanTranslationCaptureUI", "fileSize %d", new Object[] { Long.valueOf(u.bBQ(this.mhn)) });
          this.ISt[1] = System.currentTimeMillis();
          com.tencent.mm.plugin.scanner.util.k.a(this.CGU, str1, com.tencent.mm.i.a.MediaType_IMAGE, new k.a()
          {
            public final void a(String paramAnonymousString, k.b paramAnonymousb)
            {
              AppMethodBeat.i(211383);
              if ((!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(ScanTranslationCaptureUI.w(ScanTranslationCaptureUI.this))))
              {
                ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).gJx = ((int)(System.currentTimeMillis() - ScanTranslationCaptureUI.i(ScanTranslationCaptureUI.this)[1]));
                Log.i("MicroMsg.ScanTranslationCaptureUI", "upload img cost %d", new Object[] { Long.valueOf(ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).gJx) });
                ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).zP(paramAnonymousb.fileId);
                ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).zQ(paramAnonymousb.aeskey);
                switch (paramAnonymousb.errCode)
                {
                default: 
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(211863);
                      com.tencent.mm.ui.base.h.d(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(a.g.file_explorer_cannot_open_file), ScanTranslationCaptureUI.this.getString(a.g.app_tip), new DialogInterface.OnClickListener()
                      {
                        public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                        {
                          AppMethodBeat.i(211970);
                          ScanTranslationCaptureUI.f(ScanTranslationCaptureUI.this);
                          AppMethodBeat.o(211970);
                        }
                      });
                      AppMethodBeat.o(211863);
                    }
                  });
                  ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).gBP = 3L;
                }
              }
              for (;;)
              {
                if ((ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) == 1) && (ScanTranslationCaptureUI.y(ScanTranslationCaptureUI.this) != 0))
                {
                  Log.i("delete tmp path %s", str1);
                  u.deleteFile(str1);
                }
                AppMethodBeat.o(211383);
                return;
                if (!Util.isNullOrNil(new String[] { paramAnonymousb.fileId, paramAnonymousb.aeskey }))
                {
                  Log.i("MicroMsg.ScanTranslationCaptureUI", "fileId %s", new Object[] { paramAnonymousb.fileId });
                  paramAnonymousString = new com.tencent.mm.plugin.scanner.model.k(ScanTranslationCaptureUI.x(ScanTranslationCaptureUI.this), (int)u.bBQ(str1), paramAnonymousb.fileId, paramAnonymousb.aeskey);
                  com.tencent.mm.kernel.h.aGY().a(paramAnonymousString, 0);
                }
                else
                {
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(120870);
                      ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).gBP = 3L;
                      com.tencent.mm.ui.base.h.cO(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(a.g.scan_translating_no_result));
                      AppMethodBeat.o(120870);
                    }
                  });
                  continue;
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(120872);
                      com.tencent.mm.ui.base.h.d(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(a.g.file_explorer_cannot_open_file), ScanTranslationCaptureUI.this.getString(a.g.app_tip), new DialogInterface.OnClickListener()
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
                  ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).gBP = 3L;
                }
              }
            }
          });
        }
        for (;;)
        {
          com.tencent.mm.kernel.h.aGY().a(294, this);
          AppMethodBeat.o(120913);
          return;
          this.ISd.setImageResource(a.f.translation_result_english);
          break;
          label380:
          if (this.source != 1) {
            break label621;
          }
          Object localObject = MD5Util.getMD5String(this.mhn + u.bBR(this.mhn));
          localObject = ((PluginScanTranslation)com.tencent.mm.kernel.h.ag(PluginScanTranslation.class)).getTranslationResultStorage().aXn((String)localObject);
          if (localObject == null) {
            break label528;
          }
          Log.i("MicroMsg.ScanTranslationCaptureUI", "already has translation result");
          this.ISk = ((ge)localObject).field_resultFile;
          this.ISj = BitmapUtil.decodeFile(this.ISk, new BitmapFactory.Options());
          if (this.ISj == null) {
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
          if (this.kYg != 0)
          {
            l = System.currentTimeMillis();
            String str2 = ((g)com.tencent.mm.kernel.h.ag(g.class)).genScanTmpImgPath("jpg");
            BitmapUtil.saveBitmapToImage(this.ISi, 80, Bitmap.CompressFormat.JPEG, str2, false);
            Log.i("MicroMsg.ScanTranslationCaptureUI", "save img cost %d", new Object[] { Integer.valueOf((int)(System.currentTimeMillis() - l)) });
            Log.i("MicroMsg.ScanTranslationCaptureUI", "fileSize %d", new Object[] { Long.valueOf(u.bBQ(str2)) });
          }
        }
      }
    }
  }
  
  private void dlq()
  {
    AppMethodBeat.i(120916);
    this.wNi.setRepeatMode(1);
    this.wNi.setRepeatCount(0);
    this.wNi.end();
    AppMethodBeat.o(120916);
  }
  
  private void fDQ()
  {
    AppMethodBeat.i(120896);
    LocaleUtil.getApplicationLanguage().equalsIgnoreCase("zh_CN");
    this.ISp = LocaleUtil.getCurrentLanguage(this);
    Log.i("MicroMsg.ScanTranslationCaptureUI", "targetLang %s", new Object[] { this.ISp });
    AppMethodBeat.o(120896);
  }
  
  private void fDR()
  {
    AppMethodBeat.i(120908);
    com.tencent.mm.ui.base.h.a(this, getString(a.g.scan_open_camera_fail), getString(a.g.app_tip), false, new ScanTranslationCaptureUI.13(this));
    AppMethodBeat.o(120908);
  }
  
  private void fDS()
  {
    AppMethodBeat.i(120909);
    Log.i("MicroMsg.ScanTranslationCaptureUI", "curState %d", new Object[] { Integer.valueOf(this.lEK) });
    if (!this.IRX.isOpen()) {
      dAz();
    }
    if ((this.lEK == 0) && (this.IRX.isOpen())) {
      fDU();
    }
    AppMethodBeat.o(120909);
  }
  
  private void fDT()
  {
    AppMethodBeat.i(120912);
    getController().setNavigationbarColor(getResources().getColor(a.b.transparent));
    getWindow().getDecorView().setSystemUiVisibility(1796);
    AppMethodBeat.o(120912);
  }
  
  private void fDU()
  {
    AppMethodBeat.i(120914);
    Nq();
    ave();
    hideTitleView();
    this.ISt[0] = System.currentTimeMillis();
    if ((this.source == 0) && (!Util.isNullOrNil(this.mhn))) {
      u.deleteFile(this.mhn);
    }
    this.lEK = 0;
    this.source = 0;
    this.mhn = null;
    this.ISk = null;
    this.ISi = null;
    this.ISj = null;
    this.kYg = 0;
    this.ISf.setVisibility(8);
    this.ISg.setVisibility(8);
    this.ISb.setVisibility(0);
    this.ISc.setVisibility(8);
    this.ISm.setVisibility(8);
    this.IRW.setVisibility(0);
    this.ISh.setVisibility(0);
    this.wNf.setVisibility(8);
    dlq();
    com.tencent.mm.kernel.h.aGY().b(294, this);
    AppMethodBeat.o(120914);
  }
  
  private void fDV()
  {
    AppMethodBeat.i(120915);
    fDT();
    this.lEK = 3;
    this.ISc.setVisibility(0);
    if (this.ISp.equalsIgnoreCase("zh_CN")) {
      this.ISd.setImageResource(a.c.translate_chinese_view_source_btn);
    }
    for (;;)
    {
      this.wNf.setVisibility(8);
      dlq();
      if ((this.source != 1) || (!Util.isNullOrNil(this.ISk))) {
        break label234;
      }
      this.ISk = ((PluginScanTranslation)com.tencent.mm.kernel.h.ag(PluginScanTranslation.class)).genTranslationResultImgPath("jpg");
      try
      {
        BitmapUtil.saveBitmapToImage(this.ISj, 80, Bitmap.CompressFormat.JPEG, this.ISk, false);
        ah localah = new ah();
        localah.field_originMD5 = MD5Util.getMD5String(this.mhn + u.bBR(this.mhn));
        localah.field_resultFile = this.ISk;
        Log.i("MicroMsg.ScanTranslationCaptureUI", "insert translate result %s", new Object[] { this.ISk });
        ((PluginScanTranslation)com.tencent.mm.kernel.h.ag(PluginScanTranslation.class)).getTranslationResultStorage().a(localah);
        AppMethodBeat.o(120915);
        return;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", localIOException, "save translate result file error", new Object[0]);
      }
      this.ISd.setImageResource(a.c.translate_english_view_source_btn);
    }
    label234:
    AppMethodBeat.o(120915);
  }
  
  private void ftw()
  {
    AppMethodBeat.i(120903);
    if (!com.tencent.mm.compatible.e.b.avv())
    {
      com.tencent.mm.ui.base.h.a(this, getString(a.g.app_special_no_open_camera_permission), getString(a.g.app_need_camera_title), getString(a.g.app_need_show_settings_button), true, new ScanTranslationCaptureUI.9(this));
      AppMethodBeat.o(120903);
      return;
    }
    fDS();
    AppMethodBeat.o(120903);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(120902);
    ((PluginScanTranslation)com.tencent.mm.kernel.h.ag(PluginScanTranslation.class)).getTranslationRender().fEV();
    if (this.lEK == 0)
    {
      if (this.ISq)
      {
        Log.i("MicroMsg.ScanTranslationCaptureUI", "is playing animation");
        AppMethodBeat.o(120902);
        return;
      }
      this.ISn.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(120874);
          paramAnonymousAnimator = new ql();
          paramAnonymousAnimator.fPi.action = 3;
          EventCenter.instance.publish(paramAnonymousAnimator);
          ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, false);
          ScanTranslationCaptureUI.z(ScanTranslationCaptureUI.this);
          ScanTranslationCaptureUI.this.finish();
          AppMethodBeat.o(120874);
        }
      });
      this.ISn.reverse();
      this.ISq = true;
      AppMethodBeat.o(120902);
      return;
    }
    if ((this.lEK == 1) || (this.lEK == 2) || (this.lEK == 3))
    {
      if (this.lEK == 1) {
        this.ISs.gCN = ((int)(System.currentTimeMillis() - this.ISt[1]));
      }
      if (this.ISs.gBP != 0L) {
        this.ISs.bpa();
      }
      fDU();
    }
    AppMethodBeat.o(120902);
  }
  
  public final void d(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(120921);
    if ((paramBitmap != null) && (paramInt == this.ISo))
    {
      this.ISs.gCN = ((int)(System.currentTimeMillis() - this.ISt[1]));
      this.ISj = paramBitmap;
      fDV();
      ak(this.ISj);
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
    this.mNv = findViewById(a.d.root_container);
    this.mNv.setAlpha(0.0F);
    this.IRW = ((MMTextureView)findViewById(a.d.translate_capture_texture_view));
    this.IRW.setOpaque(false);
    this.IRW.setSurfaceTextureListener(this);
    this.ISm = ((MMGestureGallery)findViewById(a.d.translate_gallery_view));
    this.ISl = new ScanTranslationCaptureUI.a(this, (byte)0);
    this.ISm.setAdapter(this.ISl);
    this.ISb = findViewById(a.d.capture_btn_container);
    this.IRY = findViewById(a.d.scan_translate_close_btn);
    this.IRY.setOnClickListener(new ScanTranslationCaptureUI.18(this));
    this.IRZ = findViewById(a.d.scan_capture_btn);
    this.IRZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120885);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        ScanTranslationCaptureUI.h(ScanTranslationCaptureUI.this).c(ScanTranslationCaptureUI.this);
        ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).gJw = ((int)(System.currentTimeMillis() - ScanTranslationCaptureUI.i(ScanTranslationCaptureUI.this)[0]));
        ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).gBe = 1L;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120885);
      }
    });
    this.IRZ.setEnabled(false);
    this.ISh = ((TextView)findViewById(a.d.scan_capture_translate_tip));
    this.ISa = findViewById(a.d.scan_translate_gallery);
    this.ISa.setOnClickListener(new ScanTranslationCaptureUI.20(this));
    this.ISc = findViewById(a.d.save_translate_container);
    this.ISd = ((ImageView)this.ISc.findViewById(a.d.translate_view_source_btn));
    this.ISd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120887);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (ScanTranslationCaptureUI.e(ScanTranslationCaptureUI.this) == 3)
        {
          if (ScanTranslationCaptureUI.k(ScanTranslationCaptureUI.this) != null) {
            ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.k(ScanTranslationCaptureUI.this));
          }
          if (ScanTranslationCaptureUI.l(ScanTranslationCaptureUI.this).equalsIgnoreCase("zh_CN"))
          {
            ScanTranslationCaptureUI.m(ScanTranslationCaptureUI.this).setImageResource(a.f.translation_result_chinese_highlighted);
            ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, 2);
            ScanTranslationCaptureUI.j(ScanTranslationCaptureUI.this).gJz += 1L;
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
    this.ISf = findViewById(a.d.translate_top_bg);
    this.ISg = findViewById(a.d.translate_bottom_bg);
    hideTitleView();
    setMMTitle(a.g.scan_entry_ocr);
    setActionbarColor(getResources().getColor(a.b.transparent));
    this.wNf = ((ImageView)findViewById(a.d.scan_line));
    this.ISe = this.ISc.findViewById(a.d.translate_download_btn);
    this.ISe.setOnClickListener(new View.OnClickListener()
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
        //   15: invokevirtual 44	com/tencent/mm/hellhoundlib/b/b:bn	(Ljava/lang/Object;)V
        //   18: ldc 46
        //   20: ldc 47
        //   22: ldc 48
        //   24: ldc 49
        //   26: aload_0
        //   27: aload_3
        //   28: invokevirtual 53	com/tencent/mm/hellhoundlib/b/b:aFi	()[Ljava/lang/Object;
        //   31: invokestatic 59	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V
        //   34: aload_0
        //   35: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:ISv	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   38: invokestatic 63	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:e	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)I
        //   41: iconst_2
        //   42: if_icmpne +70 -> 112
        //   45: aload_0
        //   46: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:ISv	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   49: invokestatic 67	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:j	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)Lcom/tencent/mm/f/b/a/it;
        //   52: lconst_1
        //   53: putfield 73	com/tencent/mm/f/b/a/it:gJB	J
        //   56: aload_0
        //   57: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:ISv	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   60: aload_0
        //   61: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:ISv	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
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
        //   113: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:ISv	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   116: invokestatic 63	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:e	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)I
        //   119: iconst_3
        //   120: if_icmpne -42 -> 78
        //   123: aload_0
        //   124: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:ISv	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   127: invokestatic 67	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:j	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)Lcom/tencent/mm/f/b/a/it;
        //   130: lconst_1
        //   131: putfield 104	com/tencent/mm/f/b/a/it:gJA	J
        //   134: aload_0
        //   135: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:ISv	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   138: invokestatic 107	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:p	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)I
        //   141: istore_2
        //   142: iload_2
        //   143: ifne +48 -> 191
        //   146: aload_0
        //   147: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:ISv	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   150: ldc 109
        //   152: invokestatic 115	com/tencent/mm/kernel/h:ag	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
        //   155: checkcast 109	com/tencent/mm/plugin/scanner/PluginScanTranslation
        //   158: ldc 117
        //   160: invokevirtual 121	com/tencent/mm/plugin/scanner/PluginScanTranslation:genTranslationResultImgPath	(Ljava/lang/String;)Ljava/lang/String;
        //   163: invokestatic 124	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:a	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;Ljava/lang/String;)Ljava/lang/String;
        //   166: pop
        //   167: aload_0
        //   168: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:ISv	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   171: invokestatic 128	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:n	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)Landroid/graphics/Bitmap;
        //   174: bipush 80
        //   176: getstatic 134	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
        //   179: aload_0
        //   180: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:ISv	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   183: invokestatic 137	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI:q	(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;)Ljava/lang/String;
        //   186: iconst_0
        //   187: invokestatic 143	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
        //   190: pop
        //   191: aload_0
        //   192: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:ISv	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
        //   195: aload_0
        //   196: getfield 21	com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$22:ISv	Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI;
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
    setBackBtn(new ScanTranslationCaptureUI.23(this));
    this.pEk = getWindowManager().getDefaultDisplay().getHeight();
    this.wNi = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.wNi.addListener(new ScanTranslationCaptureUI.24(this));
    this.wNi.addUpdateListener(new ScanTranslationCaptureUI.2(this));
    Object localObject = (RelativeLayout.LayoutParams)this.ISc.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin += ar.aB(this);
    this.ISc.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.wNi.setDuration(5000L);
    com.tencent.mm.ui.base.b.a(this, null);
    this.mNv.setOnTouchListener(new View.OnTouchListener()
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
                ScanTranslationCaptureUI.h(ScanTranslationCaptureUI.this).avf();
                ScanTranslationCaptureUI.h(ScanTranslationCaptureUI.this).fCo();
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
    fDQ();
    this.ISn = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.ISn.addUpdateListener(new ScanTranslationCaptureUI.4(this));
    this.ISn.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(120868);
        ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, false);
        ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this).setVisibility(8);
        AppMethodBeat.o(120868);
      }
    });
    this.ISn.setDuration(300L);
    localObject = new ql();
    ((ql)localObject).fPi.action = 1;
    EventCenter.instance.publish((IEvent)localObject);
    AppMethodBeat.o(120895);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(120922);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 561) && (paramInt2 == -1))
    {
      paramIntent = com.tencent.mm.ui.tools.b.h(this, paramIntent, d.bbW());
      Log.i("MicroMsg.ScanTranslationCaptureUI", "select: [%s]", new Object[] { paramIntent });
      if (!Util.isNullOrNil(paramIntent))
      {
        this.mhn = paramIntent;
        this.source = 1;
        this.ISs.gBe = 2L;
        this.kYg = Exif.fromFile(paramIntent).getOrientationInDegree();
        Log.i("MicroMsg.ScanTranslationCaptureUI", "degree %s", new Object[] { Integer.valueOf(this.kYg) });
        paramIntent = BitmapUtil.decodeFileWithSample(paramIntent);
        if (paramIntent != null)
        {
          this.ISi = BitmapUtil.rotate(paramIntent, this.kYg);
          dln();
          ak(this.ISi);
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
    this.IRX = new com.tencent.mm.plugin.scanner.a.a();
    initView();
    EventCenter.instance.addListener(this.ISu);
    this.ISs.gBe = 3L;
    AppMethodBeat.o(120894);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(120901);
    super.onDestroy();
    this.ISn.removeAllUpdateListeners();
    this.wNi.removeAllUpdateListeners();
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
    f.d(false, true, true);
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
        this.ISi = null;
        long l = System.currentTimeMillis();
        paramCamera = this.IRX.ios();
        paramArrayOfByte = new YuvImage(paramArrayOfByte, 17, paramCamera.x, paramCamera.y, null);
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        paramArrayOfByte.compressToJpeg(new Rect(0, 0, paramCamera.x, paramCamera.y), 100, localByteArrayOutputStream);
        paramArrayOfByte = BitmapUtil.decodeByteArray(localByteArrayOutputStream.toByteArray());
        int i = (int)(System.currentTimeMillis() - l);
        if (paramArrayOfByte != null)
        {
          l = System.currentTimeMillis();
          this.ISi = BitmapUtil.rotate(paramArrayOfByte, this.IRX.getCameraRotation());
          Log.i("MicroMsg.ScanTranslationCaptureUI", "decode cost %d, rotate cost %d", new Object[] { Integer.valueOf(i), Integer.valueOf((int)(System.currentTimeMillis() - l)) });
          if (this.ISi != null)
          {
            this.mhn = ((g)com.tencent.mm.kernel.h.ag(g.class)).genScanCaptureImgPath("jpg");
            dln();
            ak(this.ISi);
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
        ftw();
        AppMethodBeat.o(120910);
        return;
      }
      this.mXU = false;
      com.tencent.mm.ui.base.h.a(this, getString(a.g.permission_camera_request_again_msg), getString(a.g.permission_tips_title), getString(a.g.jump_to_settings), getString(a.g.app_cancel), false, new ScanTranslationCaptureUI.14(this), new ScanTranslationCaptureUI.15(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(120897);
    super.onResume();
    f.d(true, true, true);
    Nq();
    com.tencent.mm.kernel.h.aGY().a(294, this);
    com.tencent.mm.kernel.h.aHF().a(this.wNk);
    if (this.mXU)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null);
      Log.i("MicroMsg.ScanTranslationCaptureUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(120897);
        return;
      }
      ftw();
      AppMethodBeat.o(120897);
      return;
    }
    fDS();
    AppMethodBeat.o(120897);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(120919);
    Log.i("MicroMsg.ScanTranslationCaptureUI", "errType %s, errCode %s, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.scanner.model.k)paramq).IKQ;
      if ((paramString != null) && (((com.tencent.mm.plugin.scanner.model.k)paramq).fwM == this.ISo))
      {
        this.ISs.gJy = ((int)(System.currentTimeMillis() - ((com.tencent.mm.plugin.scanner.model.k)paramq).IKR));
        Log.i("MicroMsg.ScanTranslationCaptureUI", "angle %f, translationInfos length %d", new Object[] { Float.valueOf(((com.tencent.mm.plugin.scanner.model.k)paramq).angle), Integer.valueOf(paramString.size()) });
        if (paramString.size() > 0)
        {
          this.ISs.gBP = 1L;
          ((PluginScanTranslation)com.tencent.mm.kernel.h.ag(PluginScanTranslation.class)).getTranslationRender().a(this.ISo, paramString, ((com.tencent.mm.plugin.scanner.model.k)paramq).angle, this.ISi, this);
          if (!Util.isNullOrNil(((com.tencent.mm.plugin.scanner.model.k)paramq).fCM()))
          {
            this.ISp = ((com.tencent.mm.plugin.scanner.model.k)paramq).fCM();
            AppMethodBeat.o(120919);
          }
        }
        else
        {
          this.ISs.gCN = ((int)(System.currentTimeMillis() - this.ISt[1]));
          com.tencent.mm.ui.base.h.a(this, getString(a.g.scan_translating_no_result), "", false, new ScanTranslationCaptureUI.16(this));
        }
      }
      AppMethodBeat.o(120919);
      return;
    }
    this.ISs.gBP = 5L;
    this.ISs.gCN = ((int)(System.currentTimeMillis() - this.ISt[1]));
    paramq = getString(a.g.scan_translating_no_result);
    if (!Util.isNullOrNil(paramString)) {}
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(this, paramString, "", false, new ScanTranslationCaptureUI.17(this));
      AppMethodBeat.o(120919);
      return;
      paramString = paramq;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(120900);
    super.onStop();
    aYA();
    com.tencent.mm.kernel.h.aGY().b(294, this);
    EventCenter.instance.removeListener(this.ISu);
    com.tencent.mm.kernel.h.aHF().b(this.wNk);
    AppMethodBeat.o(120900);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(120917);
    Log.i("MicroMsg.ScanTranslationCaptureUI", "surface texture available");
    this.IRW.hKg();
    this.surfaceTexture = paramSurfaceTexture;
    if (this.mXU)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null);
      Log.i("MicroMsg.ScanTranslationCaptureUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(120917);
        return;
      }
      ftw();
      AppMethodBeat.o(120917);
      return;
    }
    if (!this.IRX.isOpen())
    {
      dAz();
      AppMethodBeat.o(120917);
      return;
    }
    fDU();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI
 * JD-Core Version:    0.7.0.1
 */