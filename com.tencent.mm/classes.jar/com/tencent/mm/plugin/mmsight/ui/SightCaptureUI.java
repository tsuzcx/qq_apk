package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.g.a.ob;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.f.a;
import com.tencent.mm.plugin.mmsight.model.f.b;
import com.tencent.mm.plugin.mmsight.model.f.c;
import com.tencent.mm.plugin.mmsight.model.l;
import com.tencent.mm.plugin.mmsight.model.p;
import com.tencent.mm.plugin.mmsight.ui.cameraglview.MMSightCameraGLSurfaceView;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class SightCaptureUI
  extends MMActivity
  implements com.tencent.mm.plugin.mmsight.model.a.d.a, com.tencent.mm.plugin.mmsight.model.d.a
{
  private com.tencent.e.i.d cVv;
  private String dyw;
  private com.tencent.mm.remoteservice.d fLo;
  private VideoTransPara gCB;
  private com.tencent.mm.compatible.util.b hDB;
  private ViewGroup hSI;
  private ObservableTextureView iBH;
  private com.tencent.mm.plugin.mmsight.model.a.d iBe;
  private int jMb;
  private boolean jMc;
  private long jMd;
  private MMSightCaptureTouchView oOu;
  private View sss;
  private int tAY;
  private SightParams tEC;
  private VideoPlayerTextureView tFN;
  private VideoSeekBarEditorView tFO;
  private h.a tFU;
  private ViewGroup tKA;
  private ImageView tKB;
  private ImageView tKC;
  private SurfaceTexture tKD;
  CameraFrontSightView tKE;
  private ViewGroup tKF;
  private ImageView tKG;
  private MMSightCameraGLSurfaceView tKH;
  private com.tencent.mm.plugin.mmsight.ui.cameraglview.a tKI;
  private TextView tKJ;
  private View tKK;
  private MMSightTopCountdownCoverView tKL;
  private b tKM;
  private boolean tKN;
  private boj tKO;
  private byte[] tKP;
  private int tKQ;
  private int tKR;
  private int tKS;
  private int tKT;
  private byte[] tKU;
  private int tKV;
  private com.tencent.mm.plugin.mmsight.model.d tKW;
  private boolean tKX;
  private boolean tKY;
  private boolean tKZ;
  private int tKt;
  private boolean tKu;
  private com.tencent.mm.plugin.mmsight.model.f tKv;
  private MMSightRecordButton tKw;
  private View tKx;
  private View tKy;
  private ViewGroup tKz;
  private int tLa;
  private int tLb;
  private long tLc;
  private boolean tLd;
  private boolean tLe;
  private Boolean tLf;
  private Point tLg;
  private com.tencent.mm.sdk.b.c tLh;
  private Runnable tLi;
  private String tLj;
  private String tLk;
  private boolean tLl;
  private Bundle tLm;
  private Runnable tLn;
  
  public SightCaptureUI()
  {
    AppMethodBeat.i(94679);
    this.tKt = 1;
    this.tAY = 2;
    this.tKu = true;
    this.jMb = -1;
    this.tKN = true;
    this.tKO = new boj();
    this.fLo = new com.tencent.mm.remoteservice.d(aj.getContext());
    this.tKX = false;
    this.tKY = false;
    this.tKZ = false;
    this.tLa = 0;
    this.jMc = false;
    this.tLb = 0;
    this.tLc = -1L;
    this.jMd = -1L;
    this.tLd = false;
    this.tLe = false;
    this.dyw = "";
    this.tLf = Boolean.FALSE;
    this.tLh = new SightCaptureUI.12(this);
    this.tLi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94662);
        if ((SightCaptureUI.g(SightCaptureUI.this) == 7) && (SightCaptureUI.k(SightCaptureUI.this) != null))
        {
          ad.i("MicroMsg.SightCaptureUI", "showRecoderProgressBar");
          SightCaptureUI.k(SightCaptureUI.this).showLoading();
        }
        AppMethodBeat.o(94662);
      }
    };
    this.tLn = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94663);
        if (SightCaptureUI.g(SightCaptureUI.this) != 4)
        {
          ad.e("MicroMsg.SightCaptureUI", "checkPreviewStatusRunnable, not previewing now!!!");
          SightCaptureUI.b(SightCaptureUI.this, 9);
        }
        AppMethodBeat.o(94663);
      }
    };
    this.tFU = new SightCaptureUI.20(this);
    AppMethodBeat.o(94679);
  }
  
  private static String Ha(int paramInt)
  {
    if (paramInt == -1) {
      return "CAPTURE_STATE_BINGDING";
    }
    if (paramInt == 0) {
      return "CAPTURE_STATE_INIT";
    }
    if (paramInt == 1) {
      return "CAPTURE_STATE_CAPTURING";
    }
    if (paramInt == 2) {
      return "CAPTURE_STATE_RECORDING";
    }
    if (paramInt == 3) {
      return "CAPTURE_STATE_PREVIEW_PICTURE";
    }
    if (paramInt == 4) {
      return "CAPTURE_STATE_PREVIEW_VIDEO";
    }
    if (paramInt == 6) {
      return "CAPTURE_STATE_SUPERMAN";
    }
    if (paramInt == 7) {
      return "CAPTURE_STATE_WAIT_TO_PREVIEW";
    }
    if (paramInt == 8) {
      return "CAPTURE_STATE_INIT_ERROR";
    }
    if (paramInt == 9) {
      return "CAPTURE_STATE_STOP_ERROR";
    }
    return "UNKNOW";
  }
  
  private String bj(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(94695);
    boolean bool1 = CaptureMMProxy.getInstance().getBoolean(ae.a.Fno, true);
    boolean bool2 = CaptureMMProxy.getInstance().getBoolean(ae.a.Fnp, true);
    if (paramBoolean) {}
    for (String str = com.tencent.mm.plugin.mmsight.d.ahd("jpg");; str = com.tencent.mm.plugin.mmsight.d.ahd("mp4"))
    {
      if (((bool1) && (paramBoolean)) || ((bool2) && (!paramBoolean)))
      {
        ad.i("MicroMsg.SightCaptureUI", "auto save src %s dest %s state %s %s", new Object[] { paramString, str, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        com.tencent.mm.vfs.i.lC(paramString, str);
        com.tencent.mm.sdk.f.b.k(str, this);
      }
      AppMethodBeat.o(94695);
      return str;
    }
  }
  
  private void cQT()
  {
    AppMethodBeat.i(94685);
    if ((this.tLc > 0L) && (bt.aS(this.tLc) <= 500L))
    {
      ad.i("MicroMsg.SightCaptureUI", "switchCameraClick, switch camera too frequently!!! ignore");
      AppMethodBeat.o(94685);
      return;
    }
    ad.v("MicroMsg.TestCaptureUiEvent", "switchCameraClick %s, currentState: %s", new Object[] { bt.eGN().toString(), Integer.valueOf(this.jMb) });
    cQZ();
    this.tKX = true;
    if (this.jMb == 2) {
      if ((this.iBe == null) || (!this.iBe.aou())) {
        ad.i("MicroMsg.SightCaptureUI", "switchCameraClick, not write camera data!");
      }
    }
    for (;;)
    {
      cRa();
      this.tLc = bt.GC();
      AppMethodBeat.o(94685);
      return;
      cRc();
      this.tKY = true;
      continue;
      if (this.jMb == 1)
      {
        wB(6);
        if (nm(true)) {
          wB(1);
        }
      }
    }
  }
  
  private void cQU()
  {
    AppMethodBeat.i(94687);
    try
    {
      ViewGroup.LayoutParams localLayoutParams = this.tFN.getLayoutParams();
      this.tKz.removeView(this.tFN);
      this.tKz.addView(this.tFN, 0, localLayoutParams);
      AppMethodBeat.o(94687);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.SightCaptureUI", "clearVideoPlayViewContent, error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94687);
    }
  }
  
  private void cQV()
  {
    AppMethodBeat.i(94688);
    wB(0);
    this.tLb = 0;
    this.jMc = false;
    this.tLe = false;
    if (this.tFN != null)
    {
      this.tFN.stop();
      this.tFN.setVideoCallback(null);
      cQU();
    }
    if (this.tKM != null)
    {
      this.tKM.release();
      this.tKM = null;
    }
    if (this.tKH != null) {
      this.tKH.setVisibility(0);
    }
    this.tKG.setImageBitmap(null);
    cRb();
    this.tKv = new com.tencent.mm.plugin.mmsight.model.f(this.gCB, this.tEC.scene);
    this.tKv.a(this.tKI.gCb);
    this.tKL.setVisibility(8);
    if (!this.tKv.x(this, this.tKN))
    {
      wB(8);
      AppMethodBeat.o(94688);
      return;
    }
    if (this.iBH.isAvailable())
    {
      this.tKD = this.iBH.getSurfaceTexture();
      ad.i("MicroMsg.SightCaptureUI", "surface already available, directly set local surface: %s", new Object[] { this.tKD });
      if (nm(false)) {
        wB(1);
      }
    }
    for (;;)
    {
      if ((this.tKJ != null) && (this.tKu))
      {
        this.tKJ.setAlpha(1.0F);
        this.tKJ.setVisibility(0);
      }
      this.tKW.reset();
      this.tKX = false;
      this.tKY = false;
      AppMethodBeat.o(94688);
      return;
      wB(8);
      continue;
      this.iBH.setTextureChangeCallback(new com.tencent.mm.plugin.video.b()
      {
        public final void f(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(94644);
          ad.i("MicroMsg.SightCaptureUI", "callback onSurfaceTextureAvailable set local surface: %s", new Object[] { paramAnonymousSurfaceTexture });
          SightCaptureUI.a(SightCaptureUI.this, paramAnonymousSurfaceTexture);
          if (SightCaptureUI.I(SightCaptureUI.this))
          {
            SightCaptureUI.b(SightCaptureUI.this, 1);
            AppMethodBeat.o(94644);
            return;
          }
          SightCaptureUI.b(SightCaptureUI.this, 8);
          AppMethodBeat.o(94644);
        }
      });
    }
  }
  
  private int cQW()
  {
    AppMethodBeat.i(94690);
    ad.i("MicroMsg.SightCaptureUI", "startRecordImpl");
    int i = this.iBe.b(this.tKv.getOrientation(), this.tKW.aov(), this.tKW.getOrientation());
    ad.i("MicroMsg.SightCaptureUI", "startRecordImpl ret: %d", new Object[] { Integer.valueOf(i) });
    if (i >= 0) {
      this.tKv.a(f.a.tCy);
    }
    AppMethodBeat.o(94690);
    return i;
  }
  
  private void cQX()
  {
    AppMethodBeat.i(94691);
    this.tLe = true;
    wB(8);
    if (this.iBe != null) {
      try
      {
        this.iBe.cancel();
        this.iBe = null;
        AppMethodBeat.o(94691);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.SightCaptureUI", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(94691);
  }
  
  private void cQY()
  {
    AppMethodBeat.i(94692);
    wB(7);
    this.tKw.setTouchEnable(false);
    if (this.tEC.tBi) {
      this.tKL.cQL();
    }
    final int i = this.tKv.getPreviewWidth();
    final int j = this.tKv.getPreviewHeight();
    this.iBe.C(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94647);
        ad.m("MicroMsg.SightCaptureUI", "call stop callback now, currentStatus: %s", new Object[] { SightCaptureUI.Hb(SightCaptureUI.g(SightCaptureUI.this)) });
        SightCaptureUI.j(SightCaptureUI.this).a(f.a.tCz);
        SightCaptureUI.B(SightCaptureUI.this);
        final long l = com.tencent.mm.plugin.mmsight.d.ahf("TIME_RECODER_2_PLAY");
        com.tencent.e.h.Iye.aP(new com.tencent.e.i.h()
        {
          public final String getKey()
          {
            return "BigSightFFMpegRecorder_markAfterCaptureFinish_idkeystat";
          }
          
          public final void run()
          {
            AppMethodBeat.i(94646);
            String str = SightCaptureUI.p(SightCaptureUI.this).getFilePath();
            localboj = SightCaptureUI.J(SightCaptureUI.this);
            int n = com.tencent.mm.plugin.mmsight.model.k.tCN.fEc;
            m = com.tencent.mm.plugin.mmsight.model.k.tCN.gwG;
            for (;;)
            {
              try
              {
                if (!bt.isNullOrNil(str))
                {
                  boolean bool = com.tencent.mm.vfs.i.eK(str);
                  if (bool) {
                    continue;
                  }
                }
              }
              catch (Exception localException)
              {
                Object localObject;
                int i1;
                int i2;
                com.tencent.mm.plugin.sight.base.a locala;
                ad.e("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish error: %s", new Object[] { localException.getMessage() });
                continue;
                int i = 0;
                continue;
                i = 0;
                continue;
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(440L, 88L, 1L, false);
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(440L, 48L, i1, false);
                i = 90;
                int k = 54;
                int j = 50;
                continue;
                if (com.tencent.mm.plugin.mmsight.model.k.tCN.cQa()) {
                  continue;
                }
                if (m != 1080) {
                  continue;
                }
                continue;
                if ((i1 <= 10) || (i1 > 15)) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(440L, k + 1, 1L, false);
                continue;
                if ((i1 <= 15) || (i1 > 20)) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(440L, k + 2, 1L, false);
                continue;
                if ((i1 <= 20) || (i1 > 30)) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(440L, k + 3, 1L, false);
                continue;
                if (localboj.DLL != 2) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(440L, 194L, i2, false);
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(440L, 195L, 1L, false);
                continue;
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(440L, 179L, i2, false);
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(440L, 180L, 1L, false);
                if (localboj == null) {
                  continue;
                }
                if (localboj.DLL != 1) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(440L, 189L, i2, false);
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(440L, 190L, 1L, false);
                continue;
                if (localboj.DLL != 2) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(440L, 199L, i2, false);
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(440L, 200L, 1L, false);
                continue;
                m = j;
                j = k;
                k = m;
                continue;
                if (m != 720) {
                  continue;
                }
                i += 1;
                k += 6;
                m = j + 6;
                j = k;
                k = m;
                continue;
                i += 2;
                k += 12;
                m = j + 12;
                j = k;
                k = m;
                continue;
              }
              l.g(false, l);
              AppMethodBeat.o(94646);
              return;
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(440L, 87L, 1L, false);
              localObject = new JSONObject(SightVideoJNI.getSimpleMp4InfoVFS(str));
              i1 = (int)((JSONObject)localObject).getDouble("videoFPS");
              i2 = ((JSONObject)localObject).optInt("videoBitrate");
              ad.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, videoFPS: %s, videoBitrate: %s, recorderType: %s, resolutionLimit: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(n), Integer.valueOf(m) });
              localObject = com.tencent.mm.plugin.mmsight.model.b.cPB();
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).tBL = com.tencent.mm.plugin.mmsight.model.k.tCN.fEc;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).videoBitrate = com.tencent.mm.plugin.mmsight.model.k.tCN.videoBitrate;
              if (!com.tencent.mm.plugin.mmsight.model.k.tCN.gDs) {
                continue;
              }
              i = 1;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).fEd = i;
              if (!com.tencent.mm.plugin.mmsight.model.k.tCN.tDa) {
                continue;
              }
              i = 1;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).tBM = i;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).gwG = com.tencent.mm.plugin.mmsight.model.k.tCN.gwG;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).tBN = i1;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).fileSize = com.tencent.mm.vfs.i.aMN(str);
              locala = e.ano(str);
              if (locala != null)
              {
                ((com.tencent.mm.plugin.mmsight.model.b)localObject).tBQ = locala.width;
                ((com.tencent.mm.plugin.mmsight.model.b)localObject).tBR = locala.height;
                ((com.tencent.mm.plugin.mmsight.model.b)localObject).tBS = locala.videoBitrate;
                ((com.tencent.mm.plugin.mmsight.model.b)localObject).tBO = locala.videoDuration;
              }
              if (n != 1) {
                continue;
              }
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(440L, 89L, 1L, false);
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(440L, 49L, i1, false);
              i = 93;
              k = 73;
              j = 69;
              continue;
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(440L, j, i1, false);
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(440L, i, 1L, false);
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(440L, 47L, i1, false);
              ad.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, filePath: %s base %d", new Object[] { str, Integer.valueOf(k) });
              if ((i1 < 0) || (i1 > 10)) {
                continue;
              }
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(440L, k, 1L, false);
              if (i2 > 0)
              {
                if (n != 2) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(440L, 175L, i2, false);
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(440L, 176L, 1L, false);
                if (localboj != null)
                {
                  if (localboj.DLL != 1) {
                    continue;
                  }
                  com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(440L, 184L, i2, false);
                  com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(440L, 185L, 1L, false);
                }
              }
            }
          }
        });
        ad.v("MicroMsg.TestCaptureUiEvent", "doStopRecorderAndStartPreviewDone %s", new Object[] { bt.eGN().toString() });
        ad.i("MicroMsg.SightCaptureUI", "stop finish, filepath: %s %s time_takevideo %s", new Object[] { SightCaptureUI.p(SightCaptureUI.this).getFilePath(), Long.valueOf(com.tencent.mm.vfs.i.aMN(SightCaptureUI.p(SightCaptureUI.this).getFilePath())), Long.valueOf(l) });
        SightCaptureUI.a(SightCaptureUI.this, SightCaptureUI.p(SightCaptureUI.this).JS());
        SightCaptureUI.A(SightCaptureUI.this);
        SightCaptureUI.K(SightCaptureUI.this);
        SightCaptureUI.L(SightCaptureUI.this);
        aq.n(SightCaptureUI.M(SightCaptureUI.this), 1000L);
        if ((SightCaptureUI.a(SightCaptureUI.this).scene == 1) || (SightCaptureUI.a(SightCaptureUI.this).scene == 2) || (SightCaptureUI.a(SightCaptureUI.this).scene == 7)) {
          com.tencent.mm.plugin.report.service.h.vKh.f(13819, new Object[] { Integer.valueOf(2), Integer.valueOf(SightCaptureUI.a(SightCaptureUI.this).scene), SightCaptureUI.a(SightCaptureUI.this).tBg, Long.valueOf(bt.aGK()) });
        }
        AppMethodBeat.o(94647);
      }
    });
    AppMethodBeat.o(94692);
  }
  
  private void cQZ()
  {
    AppMethodBeat.i(94693);
    com.tencent.mm.plugin.mmsight.model.a.k.cQk();
    if (!com.tencent.mm.plugin.mmsight.model.a.k.cQo())
    {
      AppMethodBeat.o(94693);
      return;
    }
    TextView localTextView = (TextView)findViewById(2131306323);
    localTextView.setVisibility(8);
    localTextView.setText("");
    AppMethodBeat.o(94693);
  }
  
  private void cRa()
  {
    AppMethodBeat.i(94694);
    com.tencent.mm.plugin.mmsight.model.a.k.cQk();
    if (!com.tencent.mm.plugin.mmsight.model.a.k.cQo())
    {
      AppMethodBeat.o(94694);
      return;
    }
    ad.i("MicroMsg.SightCaptureUI", "test for debug " + bt.eGN().toString());
    com.tencent.mm.plugin.mmsight.model.j.af(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94652);
        SightCaptureUI.N(SightCaptureUI.this);
        AppMethodBeat.o(94652);
      }
    });
    AppMethodBeat.o(94694);
  }
  
  private void cRb()
  {
    AppMethodBeat.i(94696);
    if (this.iBH != null) {
      this.iBH.setTextureChangeCallback(null);
    }
    if (this.tKv != null)
    {
      this.tKN = this.tKv.ani();
      this.tKv.cPL();
      this.tLc = -1L;
      this.jMd = -1L;
    }
    AppMethodBeat.o(94696);
  }
  
  private void cRc()
  {
    AppMethodBeat.i(94697);
    int i = this.jMb;
    if (this.iBe != null) {}
    for (Object localObject = this.iBe.aoq();; localObject = "")
    {
      ad.i("MicroMsg.SightCaptureUI", "switchCameraOnRecord, currentStatus: %s, mediaRecorder.status: %s", new Object[] { Integer.valueOf(i), localObject });
      if ((this.jMb != 2) || (this.iBe == null) || (this.iBe.aoq() != d.c.tDO)) {
        break label406;
      }
      this.iBe.pause();
      this.tKv.a(this, this.tKD, false);
      this.tKN = this.tKv.ani();
      if (this.tKI != null) {
        this.tKI.aj(this.tKv.getPreviewWidth(), this.tKv.getPreviewHeight(), this.tKv.getOrientation());
      }
      if (this.iBe.aoq() == d.c.tDW) {
        break;
      }
      ad.e("MicroMsg.SightCaptureUI", "switchCameraOnRecord, recorder status error: %s", new Object[] { this.iBe.aoq() });
      AppMethodBeat.o(94697);
      return;
    }
    i = this.tKv.getPreviewWidth();
    int j = this.tKv.getPreviewHeight();
    int k = this.tKv.getOrientation();
    localObject = this.iBe.aos();
    int m = this.iBe.aot();
    ad.i("MicroMsg.SightCaptureUI", "switchCameraOnRecord, newPreviewSize: [%s, %s], oldPreviewSize: [%s], newOrientation: %s, oldOrientation: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localObject, Integer.valueOf(k), Integer.valueOf(m) });
    if ((m != k) || (((Point)localObject).x != i) || (((Point)localObject).y != j)) {
      ad.e("MicroMsg.SightCaptureUI", "error oldOrientation! after switch, size or orientation not match");
    }
    this.iBe.s(this.tKv.getPreviewWidth(), this.tKv.getPreviewHeight(), this.tKv.getEncodeVideoBestSize().x, this.tKv.getEncodeVideoBestSize().y);
    this.iBe.J(k, this.tKv.getEncodeVideoBestSize().x, this.tKv.getEncodeVideoBestSize().y);
    label406:
    AppMethodBeat.o(94697);
  }
  
  private boolean cRd()
  {
    return (this.jMb == 4) || (this.jMb == 3) || (this.jMb == 1) || (this.jMb == 8) || (this.jMb == 9);
  }
  
  private boolean nm(boolean paramBoolean)
  {
    AppMethodBeat.i(94689);
    ad.l("MicroMsg.SightCaptureUI", "createRecorder, surface: %s", new Object[] { this.tKD });
    this.tLe = false;
    if (this.iBe != null)
    {
      if (this.tKv != null) {
        this.tKv.b(this.iBe.getFrameDataCallback());
      }
      this.iBe.cancel();
    }
    if (this.tKv == null)
    {
      AppMethodBeat.o(94689);
      return false;
    }
    this.tKO = new boj();
    this.tKO.DLK = true;
    this.tKO.DLJ = com.tencent.mm.plugin.mmsight.model.k.tCN.tDc;
    if (this.tEC != null) {
      this.tKO.DLL = this.tEC.scene;
    }
    if (!paramBoolean)
    {
      if (this.tKv.a(this.tKD, true) < 0)
      {
        AppMethodBeat.o(94689);
        return false;
      }
    }
    else
    {
      paramBoolean = this.tKv.a(this, this.tKD, true);
      this.tKN = this.tKv.ani();
      if (!paramBoolean)
      {
        AppMethodBeat.o(94689);
        return false;
      }
    }
    if (this.tKv.getEncodeVideoBestSize() == null)
    {
      AppMethodBeat.o(94689);
      return false;
    }
    com.tencent.mm.plugin.mmsight.model.a.k.cQk();
    this.iBe = com.tencent.mm.plugin.mmsight.model.a.k.q(this.gCB);
    if (this.iBe == null)
    {
      ad.e("MicroMsg.SightCaptureUI", "create mediaRecorder error");
      this.tLe = true;
      AppMethodBeat.o(94689);
      return false;
    }
    com.tencent.mm.plugin.mmsight.d.a(this.iBe, this.tEC);
    this.iBe.a(this);
    this.tKv.a(this.iBe.getFrameDataCallback());
    if (this.tKI != null) {
      this.tKI.aj(this.tKv.getPreviewWidth(), this.tKv.getPreviewHeight(), this.tKv.getOrientation());
    }
    if ((this.tEC != null) && (this.tEC.scene == 3) && (this.tEC.mode == 2) && (!bt.isNullOrNil(this.tEC.tBc)) && (!bt.isNullOrNil(this.tEC.tBb))) {
      this.iBe.rv(this.tEC.tBc + this.tEC.tBb);
    }
    this.iBe.s(this.tKv.getPreviewWidth(), this.tKv.getPreviewHeight(), this.tKv.getEncodeVideoBestSize().x, this.tKv.getEncodeVideoBestSize().y);
    paramBoolean = this.iBe.mQ(this.tKv.getOrientation());
    ad.i("MicroMsg.SightCaptureUI", "preInit result: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.tLe = true;
    }
    AppMethodBeat.o(94689);
    return paramBoolean;
  }
  
  private void nn(boolean paramBoolean)
  {
    AppMethodBeat.i(94701);
    ad.i("MicroMsg.SightCaptureUI", "[clearPhotoEditCache] isDelete:%s mLastEditPhotoPath:%s mRawEditPhotoPath:%s", new Object[] { Boolean.valueOf(paramBoolean), this.tLk, this.tLj });
    if ((!bt.isNullOrNil(this.tLk)) && (paramBoolean)) {
      com.tencent.mm.vfs.i.deleteFile(this.tLk);
    }
    if (!bt.isNullOrNil(this.tLj)) {
      com.tencent.mm.vfs.i.deleteFile(this.tLj);
    }
    this.tLk = null;
    this.tLj = null;
    ob localob = new ob();
    localob.dtk.dbV = 0;
    com.tencent.mm.sdk.b.a.ESL.l(localob);
    AppMethodBeat.o(94701);
  }
  
  private void stopRecord()
  {
    AppMethodBeat.i(94686);
    ad.m("MicroMsg.SightCaptureUI", "stopRecord, currentStatus: %s", new Object[] { Integer.valueOf(this.jMb) });
    if (this.jMb == 2) {
      cQY();
    }
    AppMethodBeat.o(94686);
  }
  
  private void wB(int paramInt)
  {
    AppMethodBeat.i(94700);
    ad.i("MicroMsg.SightCaptureUI", "pre state %s %s update state %s %s", new Object[] { Integer.valueOf(this.jMb), Ha(this.jMb), Integer.valueOf(paramInt), Ha(paramInt) });
    ad.i("MicroMsg.TestCaptureUiEvent", "pre state %s %s update state %s %s %s", new Object[] { Integer.valueOf(this.jMb), Ha(this.jMb), Integer.valueOf(paramInt), Ha(paramInt), bt.eGN().toString() });
    if (paramInt == this.jMb)
    {
      AppMethodBeat.o(94700);
      return;
    }
    if (this.tKz == null)
    {
      AppMethodBeat.o(94700);
      return;
    }
    com.tencent.mm.plugin.mmsight.d.ahe("TIME_RECODER_2_PLAY");
    this.jMb = paramInt;
    if (this.jMb != 7) {
      aq.az(this.tLi);
    }
    if (this.jMb == 0)
    {
      this.tKz.setVisibility(8);
      this.tKC.setVisibility(8);
      this.tKA.setVisibility(8);
      this.tKG.setVisibility(8);
      this.tKF.setVisibility(0);
      if (this.tLa > 1) {
        this.tKB.setVisibility(0);
      }
      if (this.tKv != null) {
        this.tKv.a(f.a.tCx);
      }
      com.tencent.mm.plugin.mmsight.model.b.reset();
      if (this.cVv == null) {
        break label1135;
      }
      try
      {
        this.cVv.cancel(true);
        this.cVv = null;
        AppMethodBeat.o(94700);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.SightCaptureUI", localException, "update to state init, interrupt failed: %s", new Object[] { localException.getMessage() });
        }
      }
    }
    if ((this.jMb == 1) || (this.jMb == 2))
    {
      this.tKz.setVisibility(0);
      this.tKC.setVisibility(8);
      this.tKA.setVisibility(0);
      this.tKA.setClipChildren(false);
      this.tKx.setVisibility(8);
      this.sss.setVisibility(8);
      this.tKy.setVisibility(0);
      this.tKw.setVisibility(0);
      this.tFN.setVisibility(8);
      if (this.jMb == 1) {
        this.tKw.reset();
      }
      for (;;)
      {
        this.tKK.setVisibility(8);
        this.tKG.setVisibility(8);
        this.oOu.setVisibility(0);
        if (this.tLa > 1) {
          this.tKB.setVisibility(0);
        }
        this.oOu.bringToFront();
        this.tKB.bringToFront();
        cQZ();
        cRa();
        AppMethodBeat.o(94700);
        return;
        this.tKw.setTouchEnable(true);
        this.tKw.cQI();
      }
    }
    if ((this.jMb == 4) || (this.jMb == 3))
    {
      this.tKz.setVisibility(0);
      this.tKA.setVisibility(8);
      this.tKA.setClipChildren(false);
      this.tKx.setVisibility(0);
      this.sss.setVisibility(0);
      this.tKy.setVisibility(8);
      this.tKw.setVisibility(8);
      if (this.jMb == 3)
      {
        if (this.tEC.tBh) {
          this.tKC.setVisibility(0);
        }
        this.tKG.setVisibility(0);
        this.tFN.setVisibility(8);
      }
      for (;;)
      {
        this.oOu.setVisibility(8);
        AppMethodBeat.o(94700);
        return;
        this.tKG.setVisibility(8);
        this.tFN.setVisibility(0);
        this.tFN.setForceScaleFullScreen(true);
        ViewGroup.LayoutParams localLayoutParams = this.tFN.getLayoutParams();
        localLayoutParams.width = -1;
        localLayoutParams.height = -1;
        this.tFN.setLayoutParams(localLayoutParams);
        if (this.iBe.aov()) {
          this.tKI.anT();
        }
        this.tKF.setVisibility(8);
      }
    }
    if (this.jMb == 6)
    {
      this.tKx.setVisibility(8);
      this.sss.setVisibility(8);
      this.tKC.setVisibility(8);
      this.tKy.setVisibility(8);
      this.tKw.setVisibility(8);
      AppMethodBeat.o(94700);
      return;
    }
    if (this.jMb == 7)
    {
      this.tKx.setVisibility(8);
      this.sss.setVisibility(8);
      this.tKy.setVisibility(8);
      this.tKB.setVisibility(8);
      this.tKC.setVisibility(8);
      this.tKw.setTouchEnable(false);
      aq.n(this.tLi, 1500L);
      this.tKw.hideProgress();
      AppMethodBeat.o(94700);
      return;
    }
    if (this.jMb == 8)
    {
      this.tKz.setVisibility(0);
      this.tKA.setVisibility(0);
      this.tKA.setClipChildren(false);
      this.tKx.setVisibility(8);
      this.sss.setVisibility(8);
      this.tKC.setVisibility(8);
      this.tKy.setVisibility(0);
      if (this.tLa > 1) {
        this.tKB.setVisibility(0);
      }
      this.tKw.setVisibility(0);
      this.oOu.setVisibility(0);
      this.tFN.setVisibility(8);
      this.tKK.setVisibility(8);
      this.tKG.setVisibility(8);
      if (this.tLe) {
        Toast.makeText(this, 2131761236, 1).show();
      }
      for (;;)
      {
        this.tKw.setTouchEnable(false);
        this.tKw.setEnabled(false);
        AppMethodBeat.o(94700);
        return;
        Toast.makeText(this, 2131761241, 1).show();
      }
    }
    if (this.jMb == 9)
    {
      this.tKx.setVisibility(8);
      this.sss.setVisibility(8);
      this.tKC.setVisibility(8);
      this.tKy.setVisibility(0);
      this.tKB.setVisibility(8);
      this.tKw.reset();
      this.tKw.setTouchEnable(false);
      this.tKw.setEnabled(false);
      Toast.makeText(this, 2131761237, 1).show();
    }
    label1135:
    AppMethodBeat.o(94700);
  }
  
  public final void aLq()
  {
    AppMethodBeat.i(94704);
    ad.i("MicroMsg.SightCaptureUI", "onError: %s", new Object[] { Integer.valueOf(1) });
    try
    {
      if (this.iBe != null) {
        this.iBe.reset();
      }
      wB(9);
      AppMethodBeat.o(94704);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.SightCaptureUI", "onError, reset mediaRecorder error: %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131493170;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(94699);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null)
    {
      bool = true;
      ad.i("MicroMsg.SightCaptureUI", "[onActivityResult] requestCode:%s  resultCode:%s data is null?:", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      switch (paramInt1)
      {
      }
    }
    do
    {
      AppMethodBeat.o(94699);
      return;
      bool = false;
      break;
      ad.i("MicroMsg.SightCaptureUI", "[handlePhotoEditResult] resultCode:%s", new Object[] { Integer.valueOf(paramInt2) });
    } while ((paramInt2 != -1) || (paramIntent == null) || (this.iBe == null));
    this.tLl = true;
    this.tLm = paramIntent.getBundleExtra("report_info");
    this.tLj = paramIntent.getStringExtra("raw_photo_path");
    this.tLk = paramIntent.getStringExtra("after_photo_edit");
    boolean bool = CaptureMMProxy.getInstance().getBoolean(ae.a.Fno, true);
    ad.i("MicroMsg.SightCaptureUI", "rawEditPhotoPath:%s lastEditPhotoPath:%s imageState:%s", new Object[] { this.tLj, this.tLk, Boolean.valueOf(bool) });
    if (!bool)
    {
      paramIntent = CaptureMMProxy.getInstance().getSubCoreImageFullPath("photoEdited_" + System.currentTimeMillis());
      ad.i("MicroMsg.SightCaptureUI", "saveFullPath:%s", new Object[] { paramIntent });
      com.tencent.mm.vfs.i.lC(this.tLk, paramIntent);
      com.tencent.mm.vfs.i.deleteFile(this.tLk);
      com.tencent.mm.sdk.f.b.k(this.tLk, this);
      this.iBe.rv(paramIntent);
      this.tLk = paramIntent;
    }
    for (;;)
    {
      paramIntent = new BitmapFactory.Options();
      paramIntent.inJustDecodeBounds = true;
      com.tencent.mm.sdk.platformtools.f.decodeFile(this.tLk, paramIntent);
      ad.i("MicroMsg.SightCaptureUI", "rawW:%s rawH:%s", new Object[] { Integer.valueOf(paramIntent.outWidth), Integer.valueOf(paramIntent.outHeight) });
      paramIntent = com.tencent.mm.sdk.platformtools.f.aD(this.tLk, paramIntent.outHeight, paramIntent.outWidth);
      this.tKG.setVisibility(0);
      this.tKG.setImageBitmap(paramIntent);
      this.tKH.setVisibility(8);
      break;
      this.iBe.rv(this.tLk);
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(94702);
    ad.i("MicroMsg.SightCaptureUI", "onBackPressed %d", new Object[] { Integer.valueOf(this.jMb) });
    if ((this.tKM != null) && (this.tKM.onBackPressed()))
    {
      AppMethodBeat.o(94702);
      return;
    }
    if (this.tKM != null)
    {
      this.tKM.release();
      this.tKM = null;
      setSelfNavigationBarVisible(8);
      this.tKx.setVisibility(0);
      this.sss.setVisibility(0);
      this.tKC.setVisibility(0);
      AppMethodBeat.o(94702);
      return;
    }
    if (cRd())
    {
      super.onBackPressed();
      overridePendingTransition(-1, 2130772138);
      nn(true);
    }
    AppMethodBeat.o(94702);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(94684);
    super.onConfigurationChanged(paramConfiguration);
    if ((this.tLf.booleanValue()) && (com.tencent.mm.compatible.util.d.lf(13)))
    {
      paramConfiguration = new Point(paramConfiguration.screenWidthDp, paramConfiguration.screenHeightDp);
      if ((this.tLg == null) || (!this.tLg.equals(paramConfiguration)))
      {
        this.tLg = paramConfiguration;
        cQV();
      }
    }
    AppMethodBeat.o(94684);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(94680);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    this.tEC = ((SightParams)getIntent().getParcelableExtra("KEY_SIGHT_PARAMS"));
    if (this.tEC == null)
    {
      ad.e("MicroMsg.SightCaptureUI", "error!!!! sightParams is null!!");
      AppMethodBeat.o(94680);
      return;
    }
    CaptureMMProxy.createProxy(new CaptureMMProxy(this.fLo));
    long l = bt.GC();
    this.fLo.connect(new SightCaptureUI.1(this, l));
    com.tencent.mm.sdk.b.a.ESL.c(this.tLh);
    AppMethodBeat.o(94680);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(94698);
    super.onDestroy();
    ad.i("MicroMsg.SightCaptureUI", "onDestroy");
    this.fLo.release();
    if (this.iBe != null)
    {
      this.iBe.a(null);
      this.iBe.C(null);
      this.iBe.clear();
    }
    if (this.jMb == -1) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        cRb();
        if (this.tFN != null)
        {
          this.tFN.stop();
          this.tFN.setVideoCallback(null);
        }
        if (this.hDB != null) {
          this.hDB.XF();
        }
        if (this.tKM != null)
        {
          this.tKM.release();
          this.tKM = null;
        }
      }
      if (this.tKW != null)
      {
        this.tKW.disable();
        this.tKW.tBZ = null;
        this.tKW = null;
      }
      com.tencent.mm.plugin.mmsight.model.a.j.tEA.aoS();
      com.tencent.mm.sdk.b.a.ESL.d(this.tLh);
      AppMethodBeat.o(94698);
      return;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(94681);
    if ((ae.fFw.fAZ == 1) && (paramInt == 700) && (this.tKN)) {
      cQT();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(94681);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(94682);
    super.onPause();
    ad.i("MicroMsg.SightCaptureUI", "onPause, currentState: %s", new Object[] { Ha(this.jMb) });
    if (this.jMb == 2)
    {
      stopRecord();
      AppMethodBeat.o(94682);
      return;
    }
    if (this.jMb == 1)
    {
      cRb();
      AppMethodBeat.o(94682);
      return;
    }
    if ((this.jMb == 4) && (this.tFN != null)) {
      this.tFN.pause();
    }
    AppMethodBeat.o(94682);
  }
  
  public void onResume()
  {
    boolean bool2 = false;
    AppMethodBeat.i(94683);
    super.onResume();
    setSelfNavigationBarVisible(8);
    String str = Ha(this.jMb);
    boolean bool1 = bool2;
    if (this.iBH != null)
    {
      bool1 = bool2;
      if (this.iBH.isAvailable()) {
        bool1 = true;
      }
    }
    ad.i("MicroMsg.SightCaptureUI", "onResume, currentState: %s, textureview available: %s", new Object[] { str, Boolean.valueOf(bool1) });
    if ((this.jMb == 2) || (this.jMb == 1))
    {
      cQV();
      AppMethodBeat.o(94683);
      return;
    }
    if (this.jMb == 4)
    {
      if (this.iBH != null)
      {
        if (!this.iBH.isAvailable()) {
          break label154;
        }
        this.tKI.anT();
      }
      while (this.tFN != null)
      {
        this.tFN.start();
        AppMethodBeat.o(94683);
        return;
        label154:
        this.iBH.setTextureChangeCallback(new com.tencent.mm.plugin.video.b()
        {
          public final void f(SurfaceTexture paramAnonymousSurfaceTexture)
          {
            AppMethodBeat.i(94669);
            SightCaptureUI.e(SightCaptureUI.this).anT();
            SightCaptureUI.f(SightCaptureUI.this).setTextureChangeCallback(null);
            AppMethodBeat.o(94669);
          }
        });
      }
    }
    if (this.jMb == 3)
    {
      if (this.iBH != null) {
        this.iBH.setTextureChangeCallback(null);
      }
      this.tKI.a(this.tKU, this.tKZ, this.tKV);
    }
    AppMethodBeat.o(94683);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void wy(int paramInt)
  {
    AppMethodBeat.i(94703);
    if (this.tLa <= 1)
    {
      AppMethodBeat.o(94703);
      return;
    }
    if (this.jMb == 2)
    {
      AppMethodBeat.o(94703);
      return;
    }
    ad.i("MicroMsg.SightCaptureUI", "onOrientationChange: %s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 0)
    {
      AppMethodBeat.o(94703);
      return;
    }
    float f;
    if ((paramInt == 90) || (paramInt == 270)) {
      if (paramInt == 270) {
        f = 90.0F;
      }
    }
    while (this.tKB.getRotation() == f)
    {
      AppMethodBeat.o(94703);
      return;
      f = -90.0F;
      continue;
      f = paramInt;
    }
    this.tKB.animate().rotation(f).setDuration(100L).start();
    AppMethodBeat.o(94703);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI
 * JD-Core Version:    0.7.0.1
 */