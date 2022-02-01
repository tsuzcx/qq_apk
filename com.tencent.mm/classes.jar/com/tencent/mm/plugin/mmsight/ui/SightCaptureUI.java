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
import com.tencent.mm.g.a.ok;
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
import com.tencent.mm.pluginsdk.ui.tools.h.e;
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class SightCaptureUI
  extends MMActivity
  implements com.tencent.mm.plugin.mmsight.model.a.d.a, com.tencent.mm.plugin.mmsight.model.d.a
{
  private com.tencent.e.i.d cSR;
  private String dwi;
  private com.tencent.mm.remoteservice.d fPa;
  private ImageView gBf;
  private com.tencent.mm.plugin.mmsight.model.d gEn;
  private VideoTransPara hcZ;
  private com.tencent.mm.compatible.util.b ied;
  private ViewGroup isN;
  private ObservableTextureView jbI;
  private com.tencent.mm.plugin.mmsight.model.a.d jbf;
  private int kmC;
  private boolean kmD;
  private long kmE;
  private MMSightCaptureTouchView prO;
  private View tAi;
  private int uJv;
  private SightParams uMX;
  private VideoPlayerTextureView uOi;
  private VideoSeekBarEditorView uOj;
  private h.a uOp;
  private int uSZ;
  private int uTA;
  private boolean uTB;
  private boolean uTC;
  private boolean uTD;
  private int uTE;
  private int uTF;
  private long uTG;
  private boolean uTH;
  private boolean uTI;
  private Boolean uTJ;
  private Point uTK;
  private com.tencent.mm.sdk.b.c uTL;
  private Runnable uTM;
  private String uTN;
  private String uTO;
  private boolean uTP;
  private Bundle uTQ;
  private Runnable uTR;
  private boolean uTa;
  private com.tencent.mm.plugin.mmsight.model.f uTb;
  private MMSightRecordButton uTc;
  private View uTd;
  private View uTe;
  private ViewGroup uTf;
  private ViewGroup uTg;
  private ImageView uTh;
  private SurfaceTexture uTi;
  CameraFrontSightView uTj;
  private ViewGroup uTk;
  private ImageView uTl;
  private MMSightCameraGLSurfaceView uTm;
  private com.tencent.mm.plugin.mmsight.ui.cameraglview.a uTn;
  private TextView uTo;
  private View uTp;
  private MMSightTopCountdownCoverView uTq;
  private b uTr;
  private boolean uTs;
  private bsz uTt;
  private byte[] uTu;
  private int uTv;
  private int uTw;
  private int uTx;
  private int uTy;
  private byte[] uTz;
  
  public SightCaptureUI()
  {
    AppMethodBeat.i(94679);
    this.uSZ = 1;
    this.uJv = 2;
    this.uTa = true;
    this.kmC = -1;
    this.uTs = true;
    this.uTt = new bsz();
    this.fPa = new com.tencent.mm.remoteservice.d(ai.getContext());
    this.uTB = false;
    this.uTC = false;
    this.uTD = false;
    this.uTE = 0;
    this.kmD = false;
    this.uTF = 0;
    this.uTG = -1L;
    this.kmE = -1L;
    this.uTH = false;
    this.uTI = false;
    this.dwi = "";
    this.uTJ = Boolean.FALSE;
    this.uTL = new SightCaptureUI.12(this);
    this.uTM = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94662);
        if ((SightCaptureUI.g(SightCaptureUI.this) == 7) && (SightCaptureUI.k(SightCaptureUI.this) != null))
        {
          ac.i("MicroMsg.SightCaptureUI", "showRecoderProgressBar");
          SightCaptureUI.k(SightCaptureUI.this).showLoading();
        }
        AppMethodBeat.o(94662);
      }
    };
    this.uTR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94663);
        if (SightCaptureUI.g(SightCaptureUI.this) != 4)
        {
          ac.e("MicroMsg.SightCaptureUI", "checkPreviewStatusRunnable, not previewing now!!!");
          SightCaptureUI.b(SightCaptureUI.this, 9);
        }
        AppMethodBeat.o(94663);
      }
    };
    this.uOp = new h.a()
    {
      public final void dZ(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final int eP(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return 0;
      }
      
      public final void onCompletion()
      {
        AppMethodBeat.i(94668);
        SightCaptureUI.S(SightCaptureUI.this).d(0.0D, true);
        AppMethodBeat.o(94668);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(94666);
        ac.e("MicroMsg.SightCaptureUI", "%d on error what %d extra %d", new Object[] { Integer.valueOf(SightCaptureUI.this.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(94666);
      }
      
      public final void rB()
      {
        AppMethodBeat.i(94667);
        if (SightCaptureUI.S(SightCaptureUI.this) != null)
        {
          SightCaptureUI.S(SightCaptureUI.this).start();
          SightCaptureUI.S(SightCaptureUI.this).setLoop(true);
        }
        ap.aB(SightCaptureUI.M(SightCaptureUI.this));
        SightCaptureUI.S(SightCaptureUI.this).setOneTimeVideoTextureUpdateCallback(new h.e()
        {
          public final void bli()
          {
            AppMethodBeat.i(94665);
            ap.n(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(94664);
                ac.i("MicroMsg.SightCaptureUI", "onTextureUpdate");
                if (SightCaptureUI.S(SightCaptureUI.this) == null)
                {
                  AppMethodBeat.o(94664);
                  return;
                }
                SightCaptureUI.S(SightCaptureUI.this).setAlpha(1.0F);
                SightCaptureUI.b(SightCaptureUI.this, 4);
                SightCaptureUI.F(SightCaptureUI.this);
                AppMethodBeat.o(94664);
              }
            }, 50L);
            if (SightCaptureUI.a(SightCaptureUI.this).uJE) {
              SightCaptureUI.R(SightCaptureUI.this).setVisibility(0);
            }
            AppMethodBeat.o(94665);
          }
        });
        AppMethodBeat.o(94667);
      }
    };
    AppMethodBeat.o(94679);
  }
  
  private static String IX(int paramInt)
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
  
  private String bq(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(94695);
    boolean bool1 = CaptureMMProxy.getInstance().getBoolean(ah.a.GLd, true);
    boolean bool2 = CaptureMMProxy.getInstance().getBoolean(ah.a.GLe, true);
    if (paramBoolean) {}
    for (String str = com.tencent.mm.plugin.mmsight.d.alY("jpg");; str = com.tencent.mm.plugin.mmsight.d.alY("mp4"))
    {
      if (((bool1) && (paramBoolean)) || ((bool2) && (!paramBoolean)))
      {
        ac.i("MicroMsg.SightCaptureUI", "auto save src %s dest %s state %s %s", new Object[] { paramString, str, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        com.tencent.mm.vfs.i.lZ(paramString, str);
        com.tencent.mm.sdk.f.b.k(str, this);
      }
      AppMethodBeat.o(94695);
      return str;
    }
  }
  
  private void deD()
  {
    AppMethodBeat.i(94685);
    if ((this.uTG > 0L) && (bs.aO(this.uTG) <= 500L))
    {
      ac.i("MicroMsg.SightCaptureUI", "switchCameraClick, switch camera too frequently!!! ignore");
      AppMethodBeat.o(94685);
      return;
    }
    ac.v("MicroMsg.TestCaptureUiEvent", "switchCameraClick %s, currentState: %s", new Object[] { bs.eWi().toString(), Integer.valueOf(this.kmC) });
    deJ();
    this.uTB = true;
    if (this.kmC == 2) {
      if ((this.jbf == null) || (!this.jbf.avl())) {
        ac.i("MicroMsg.SightCaptureUI", "switchCameraClick, not write camera data!");
      }
    }
    for (;;)
    {
      deK();
      this.uTG = bs.Gn();
      AppMethodBeat.o(94685);
      return;
      deM();
      this.uTC = true;
      continue;
      if (this.kmC == 1)
      {
        xs(6);
        if (og(true)) {
          xs(1);
        }
      }
    }
  }
  
  private void deE()
  {
    AppMethodBeat.i(94687);
    try
    {
      ViewGroup.LayoutParams localLayoutParams = this.uOi.getLayoutParams();
      this.uTf.removeView(this.uOi);
      this.uTf.addView(this.uOi, 0, localLayoutParams);
      AppMethodBeat.o(94687);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.SightCaptureUI", "clearVideoPlayViewContent, error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94687);
    }
  }
  
  private void deF()
  {
    AppMethodBeat.i(94688);
    xs(0);
    this.uTF = 0;
    this.kmD = false;
    this.uTI = false;
    if (this.uOi != null)
    {
      this.uOi.stop();
      this.uOi.setVideoCallback(null);
      deE();
    }
    if (this.uTr != null)
    {
      this.uTr.release();
      this.uTr = null;
    }
    if (this.uTm != null) {
      this.uTm.setVisibility(0);
    }
    this.uTl.setImageBitmap(null);
    deL();
    this.uTb = new com.tencent.mm.plugin.mmsight.model.f(this.hcZ, this.uMX.scene);
    this.uTb.a(this.uTn.hcz);
    this.uTq.setVisibility(8);
    if (!this.uTb.y(this, this.uTs))
    {
      xs(8);
      AppMethodBeat.o(94688);
      return;
    }
    if (this.jbI.isAvailable())
    {
      this.uTi = this.jbI.getSurfaceTexture();
      ac.i("MicroMsg.SightCaptureUI", "surface already available, directly set local surface: %s", new Object[] { this.uTi });
      if (og(false)) {
        xs(1);
      }
    }
    for (;;)
    {
      if ((this.uTo != null) && (this.uTa))
      {
        this.uTo.setAlpha(1.0F);
        this.uTo.setVisibility(0);
      }
      this.gEn.reset();
      this.uTB = false;
      this.uTC = false;
      AppMethodBeat.o(94688);
      return;
      xs(8);
      continue;
      this.jbI.setTextureChangeCallback(new com.tencent.mm.plugin.video.b()
      {
        public final void f(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(94644);
          ac.i("MicroMsg.SightCaptureUI", "callback onSurfaceTextureAvailable set local surface: %s", new Object[] { paramAnonymousSurfaceTexture });
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
  
  private int deG()
  {
    AppMethodBeat.i(94690);
    ac.i("MicroMsg.SightCaptureUI", "startRecordImpl");
    int i = this.jbf.b(this.uTb.getOrientation(), this.gEn.aly(), this.gEn.getOrientation());
    ac.i("MicroMsg.SightCaptureUI", "startRecordImpl ret: %d", new Object[] { Integer.valueOf(i) });
    if (i >= 0) {
      this.uTb.a(f.a.uKV);
    }
    AppMethodBeat.o(94690);
    return i;
  }
  
  private void deH()
  {
    AppMethodBeat.i(94691);
    this.uTI = true;
    xs(8);
    if (this.jbf != null) {
      try
      {
        this.jbf.cancel();
        this.jbf = null;
        AppMethodBeat.o(94691);
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.SightCaptureUI", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(94691);
  }
  
  private void deI()
  {
    AppMethodBeat.i(94692);
    xs(7);
    this.uTc.setTouchEnable(false);
    if (this.uMX.uJF) {
      this.uTq.dev();
    }
    final int i = this.uTb.getPreviewWidth();
    final int j = this.uTb.getPreviewHeight();
    this.jbf.E(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94647);
        ac.m("MicroMsg.SightCaptureUI", "call stop callback now, currentStatus: %s", new Object[] { SightCaptureUI.IY(SightCaptureUI.g(SightCaptureUI.this)) });
        SightCaptureUI.j(SightCaptureUI.this).a(f.a.uKW);
        SightCaptureUI.B(SightCaptureUI.this);
        final long l = com.tencent.mm.plugin.mmsight.d.ama("TIME_RECODER_2_PLAY");
        com.tencent.e.h.JZN.aS(new com.tencent.e.i.h()
        {
          public final String getKey()
          {
            return "BigSightFFMpegRecorder_markAfterCaptureFinish_idkeystat";
          }
          
          public final void run()
          {
            AppMethodBeat.i(94646);
            String str = SightCaptureUI.p(SightCaptureUI.this).getFilePath();
            localbsz = SightCaptureUI.J(SightCaptureUI.this);
            int n = com.tencent.mm.plugin.mmsight.model.k.uLk.fHJ;
            m = com.tencent.mm.plugin.mmsight.model.k.uLk.gXd;
            for (;;)
            {
              try
              {
                if (!bs.isNullOrNil(str))
                {
                  boolean bool = com.tencent.mm.vfs.i.eA(str);
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
                ac.e("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish error: %s", new Object[] { localException.getMessage() });
                continue;
                int i = 0;
                continue;
                i = 0;
                continue;
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(440L, 88L, 1L, false);
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(440L, 48L, i1, false);
                i = 90;
                int k = 54;
                int j = 50;
                continue;
                if (com.tencent.mm.plugin.mmsight.model.k.uLk.ddI()) {
                  continue;
                }
                if (m != 1080) {
                  continue;
                }
                continue;
                if ((i1 <= 10) || (i1 > 15)) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(440L, k + 1, 1L, false);
                continue;
                if ((i1 <= 15) || (i1 > 20)) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(440L, k + 2, 1L, false);
                continue;
                if ((i1 <= 20) || (i1 > 30)) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(440L, k + 3, 1L, false);
                continue;
                if (localbsz.Fia != 2) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(440L, 194L, i2, false);
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(440L, 195L, 1L, false);
                continue;
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(440L, 179L, i2, false);
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(440L, 180L, 1L, false);
                if (localbsz == null) {
                  continue;
                }
                if (localbsz.Fia != 1) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(440L, 189L, i2, false);
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(440L, 190L, 1L, false);
                continue;
                if (localbsz.Fia != 2) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(440L, 199L, i2, false);
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(440L, 200L, 1L, false);
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
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(440L, 87L, 1L, false);
              localObject = new JSONObject(SightVideoJNI.getSimpleMp4InfoVFS(str));
              i1 = (int)((JSONObject)localObject).getDouble("videoFPS");
              i2 = ((JSONObject)localObject).optInt("videoBitrate");
              ac.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, videoFPS: %s, videoBitrate: %s, recorderType: %s, resolutionLimit: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(n), Integer.valueOf(m) });
              localObject = com.tencent.mm.plugin.mmsight.model.b.ddk();
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).uKi = com.tencent.mm.plugin.mmsight.model.k.uLk.fHJ;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).videoBitrate = com.tencent.mm.plugin.mmsight.model.k.uLk.videoBitrate;
              if (!com.tencent.mm.plugin.mmsight.model.k.uLk.hdT) {
                continue;
              }
              i = 1;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).fHK = i;
              if (!com.tencent.mm.plugin.mmsight.model.k.uLk.uLx) {
                continue;
              }
              i = 1;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).uKj = i;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).gXd = com.tencent.mm.plugin.mmsight.model.k.uLk.gXd;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).uKk = i1;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).fileSize = com.tencent.mm.vfs.i.aSp(str);
              locala = e.asx(str);
              if (locala != null)
              {
                ((com.tencent.mm.plugin.mmsight.model.b)localObject).uKn = locala.width;
                ((com.tencent.mm.plugin.mmsight.model.b)localObject).uKo = locala.height;
                ((com.tencent.mm.plugin.mmsight.model.b)localObject).uKp = locala.videoBitrate;
                ((com.tencent.mm.plugin.mmsight.model.b)localObject).uKl = locala.videoDuration;
              }
              if (n != 1) {
                continue;
              }
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(440L, 89L, 1L, false);
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(440L, 49L, i1, false);
              i = 93;
              k = 73;
              j = 69;
              continue;
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(440L, j, i1, false);
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(440L, i, 1L, false);
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(440L, 47L, i1, false);
              ac.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, filePath: %s base %d", new Object[] { str, Integer.valueOf(k) });
              if ((i1 < 0) || (i1 > 10)) {
                continue;
              }
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(440L, k, 1L, false);
              if (i2 > 0)
              {
                if (n != 2) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(440L, 175L, i2, false);
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(440L, 176L, 1L, false);
                if (localbsz != null)
                {
                  if (localbsz.Fia != 1) {
                    continue;
                  }
                  com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(440L, 184L, i2, false);
                  com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(440L, 185L, 1L, false);
                }
              }
            }
          }
        });
        ac.v("MicroMsg.TestCaptureUiEvent", "doStopRecorderAndStartPreviewDone %s", new Object[] { bs.eWi().toString() });
        ac.i("MicroMsg.SightCaptureUI", "stop finish, filepath: %s %s time_takevideo %s", new Object[] { SightCaptureUI.p(SightCaptureUI.this).getFilePath(), Long.valueOf(com.tencent.mm.vfs.i.aSp(SightCaptureUI.p(SightCaptureUI.this).getFilePath())), Long.valueOf(l) });
        SightCaptureUI.a(SightCaptureUI.this, SightCaptureUI.p(SightCaptureUI.this).JC());
        SightCaptureUI.A(SightCaptureUI.this);
        SightCaptureUI.K(SightCaptureUI.this);
        SightCaptureUI.L(SightCaptureUI.this);
        ap.n(SightCaptureUI.M(SightCaptureUI.this), 1000L);
        if ((SightCaptureUI.a(SightCaptureUI.this).scene == 1) || (SightCaptureUI.a(SightCaptureUI.this).scene == 2) || (SightCaptureUI.a(SightCaptureUI.this).scene == 7)) {
          com.tencent.mm.plugin.report.service.h.wUl.f(13819, new Object[] { Integer.valueOf(2), Integer.valueOf(SightCaptureUI.a(SightCaptureUI.this).scene), SightCaptureUI.a(SightCaptureUI.this).uJD, Long.valueOf(bs.aNx()) });
        }
        AppMethodBeat.o(94647);
      }
    });
    AppMethodBeat.o(94692);
  }
  
  private void deJ()
  {
    AppMethodBeat.i(94693);
    com.tencent.mm.plugin.mmsight.model.a.k.ddS();
    if (!com.tencent.mm.plugin.mmsight.model.a.k.ddW())
    {
      AppMethodBeat.o(94693);
      return;
    }
    TextView localTextView = (TextView)findViewById(2131306323);
    localTextView.setVisibility(8);
    localTextView.setText("");
    AppMethodBeat.o(94693);
  }
  
  private void deK()
  {
    AppMethodBeat.i(94694);
    com.tencent.mm.plugin.mmsight.model.a.k.ddS();
    if (!com.tencent.mm.plugin.mmsight.model.a.k.ddW())
    {
      AppMethodBeat.o(94694);
      return;
    }
    ac.i("MicroMsg.SightCaptureUI", "test for debug " + bs.eWi().toString());
    com.tencent.mm.plugin.mmsight.model.j.ah(new Runnable()
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
  
  private void deL()
  {
    AppMethodBeat.i(94696);
    if (this.jbI != null) {
      this.jbI.setTextureChangeCallback(null);
    }
    if (this.uTb != null)
    {
      this.uTs = this.uTb.aub();
      this.uTb.ddu();
      this.uTG = -1L;
      this.kmE = -1L;
    }
    AppMethodBeat.o(94696);
  }
  
  private void deM()
  {
    AppMethodBeat.i(94697);
    int i = this.kmC;
    if (this.jbf != null) {}
    for (Object localObject = this.jbf.avh();; localObject = "")
    {
      ac.i("MicroMsg.SightCaptureUI", "switchCameraOnRecord, currentStatus: %s, mediaRecorder.status: %s", new Object[] { Integer.valueOf(i), localObject });
      if ((this.kmC != 2) || (this.jbf == null) || (this.jbf.avh() != d.c.uMj)) {
        break label406;
      }
      this.jbf.pause();
      this.uTb.a(this, this.uTi, false);
      this.uTs = this.uTb.aub();
      if (this.uTn != null) {
        this.uTn.al(this.uTb.getPreviewWidth(), this.uTb.getPreviewHeight(), this.uTb.getOrientation());
      }
      if (this.jbf.avh() == d.c.uMr) {
        break;
      }
      ac.e("MicroMsg.SightCaptureUI", "switchCameraOnRecord, recorder status error: %s", new Object[] { this.jbf.avh() });
      AppMethodBeat.o(94697);
      return;
    }
    i = this.uTb.getPreviewWidth();
    int j = this.uTb.getPreviewHeight();
    int k = this.uTb.getOrientation();
    localObject = this.jbf.avj();
    int m = this.jbf.avk();
    ac.i("MicroMsg.SightCaptureUI", "switchCameraOnRecord, newPreviewSize: [%s, %s], oldPreviewSize: [%s], newOrientation: %s, oldOrientation: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localObject, Integer.valueOf(k), Integer.valueOf(m) });
    if ((m != k) || (((Point)localObject).x != i) || (((Point)localObject).y != j)) {
      ac.e("MicroMsg.SightCaptureUI", "error oldOrientation! after switch, size or orientation not match");
    }
    this.jbf.s(this.uTb.getPreviewWidth(), this.uTb.getPreviewHeight(), this.uTb.getEncodeVideoBestSize().x, this.uTb.getEncodeVideoBestSize().y);
    this.jbf.K(k, this.uTb.getEncodeVideoBestSize().x, this.uTb.getEncodeVideoBestSize().y);
    label406:
    AppMethodBeat.o(94697);
  }
  
  private boolean deN()
  {
    return (this.kmC == 4) || (this.kmC == 3) || (this.kmC == 1) || (this.kmC == 8) || (this.kmC == 9);
  }
  
  private boolean og(boolean paramBoolean)
  {
    AppMethodBeat.i(94689);
    ac.l("MicroMsg.SightCaptureUI", "createRecorder, surface: %s", new Object[] { this.uTi });
    this.uTI = false;
    if (this.jbf != null)
    {
      if (this.uTb != null) {
        this.uTb.b(this.jbf.getFrameDataCallback());
      }
      this.jbf.cancel();
    }
    if (this.uTb == null)
    {
      AppMethodBeat.o(94689);
      return false;
    }
    this.uTt = new bsz();
    this.uTt.FhZ = true;
    this.uTt.FhY = com.tencent.mm.plugin.mmsight.model.k.uLk.uLz;
    if (this.uMX != null) {
      this.uTt.Fia = this.uMX.scene;
    }
    if (!paramBoolean)
    {
      if (this.uTb.a(this.uTi, true) < 0)
      {
        AppMethodBeat.o(94689);
        return false;
      }
    }
    else
    {
      paramBoolean = this.uTb.a(this, this.uTi, true);
      this.uTs = this.uTb.aub();
      if (!paramBoolean)
      {
        AppMethodBeat.o(94689);
        return false;
      }
    }
    if (this.uTb.getEncodeVideoBestSize() == null)
    {
      AppMethodBeat.o(94689);
      return false;
    }
    com.tencent.mm.plugin.mmsight.model.a.k.ddS();
    this.jbf = com.tencent.mm.plugin.mmsight.model.a.k.q(this.hcZ);
    if (this.jbf == null)
    {
      ac.e("MicroMsg.SightCaptureUI", "create mediaRecorder error");
      this.uTI = true;
      AppMethodBeat.o(94689);
      return false;
    }
    com.tencent.mm.plugin.mmsight.d.a(this.jbf, this.uMX);
    this.jbf.a(this);
    this.uTb.a(this.jbf.getFrameDataCallback());
    if (this.uTn != null) {
      this.uTn.al(this.uTb.getPreviewWidth(), this.uTb.getPreviewHeight(), this.uTb.getOrientation());
    }
    if ((this.uMX != null) && (this.uMX.scene == 3) && ((this.uMX.mode == 2) || (this.uMX.mode == 0)) && (!bs.isNullOrNil(this.uMX.uJz)) && (!bs.isNullOrNil(this.uMX.uJy))) {
      this.jbf.vy(this.uMX.uJz + this.uMX.uJy);
    }
    this.jbf.s(this.uTb.getPreviewWidth(), this.uTb.getPreviewHeight(), this.uTb.getEncodeVideoBestSize().x, this.uTb.getEncodeVideoBestSize().y);
    paramBoolean = this.jbf.nE(this.uTb.getOrientation());
    ac.i("MicroMsg.SightCaptureUI", "preInit result: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.uTI = true;
    }
    AppMethodBeat.o(94689);
    return paramBoolean;
  }
  
  private void oh(boolean paramBoolean)
  {
    AppMethodBeat.i(94701);
    ac.i("MicroMsg.SightCaptureUI", "[clearPhotoEditCache] isDelete:%s mLastEditPhotoPath:%s mRawEditPhotoPath:%s", new Object[] { Boolean.valueOf(paramBoolean), this.uTO, this.uTN });
    if ((!bs.isNullOrNil(this.uTO)) && (paramBoolean)) {
      com.tencent.mm.vfs.i.deleteFile(this.uTO);
    }
    if (!bs.isNullOrNil(this.uTN)) {
      com.tencent.mm.vfs.i.deleteFile(this.uTN);
    }
    this.uTO = null;
    this.uTN = null;
    ok localok = new ok();
    localok.dqU.cZu = 0;
    com.tencent.mm.sdk.b.a.GpY.l(localok);
    AppMethodBeat.o(94701);
  }
  
  private void stopRecord()
  {
    AppMethodBeat.i(94686);
    ac.m("MicroMsg.SightCaptureUI", "stopRecord, currentStatus: %s", new Object[] { Integer.valueOf(this.kmC) });
    if (this.kmC == 2) {
      deI();
    }
    AppMethodBeat.o(94686);
  }
  
  private void xs(int paramInt)
  {
    AppMethodBeat.i(94700);
    ac.i("MicroMsg.SightCaptureUI", "pre state %s %s update state %s %s", new Object[] { Integer.valueOf(this.kmC), IX(this.kmC), Integer.valueOf(paramInt), IX(paramInt) });
    ac.i("MicroMsg.TestCaptureUiEvent", "pre state %s %s update state %s %s %s", new Object[] { Integer.valueOf(this.kmC), IX(this.kmC), Integer.valueOf(paramInt), IX(paramInt), bs.eWi().toString() });
    if (paramInt == this.kmC)
    {
      AppMethodBeat.o(94700);
      return;
    }
    if (this.uTf == null)
    {
      AppMethodBeat.o(94700);
      return;
    }
    com.tencent.mm.plugin.mmsight.d.alZ("TIME_RECODER_2_PLAY");
    this.kmC = paramInt;
    if (this.kmC != 7) {
      ap.aB(this.uTM);
    }
    if (this.kmC == 0)
    {
      this.uTf.setVisibility(8);
      this.uTh.setVisibility(8);
      this.uTg.setVisibility(8);
      this.uTl.setVisibility(8);
      this.uTk.setVisibility(0);
      if (this.uTE > 1) {
        this.gBf.setVisibility(0);
      }
      if (this.uTb != null) {
        this.uTb.a(f.a.uKU);
      }
      com.tencent.mm.plugin.mmsight.model.b.reset();
      if (this.cSR == null) {
        break label1135;
      }
      try
      {
        this.cSR.cancel(true);
        this.cSR = null;
        AppMethodBeat.o(94700);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.SightCaptureUI", localException, "update to state init, interrupt failed: %s", new Object[] { localException.getMessage() });
        }
      }
    }
    if ((this.kmC == 1) || (this.kmC == 2))
    {
      this.uTf.setVisibility(0);
      this.uTh.setVisibility(8);
      this.uTg.setVisibility(0);
      this.uTg.setClipChildren(false);
      this.uTd.setVisibility(8);
      this.tAi.setVisibility(8);
      this.uTe.setVisibility(0);
      this.uTc.setVisibility(0);
      this.uOi.setVisibility(8);
      if (this.kmC == 1) {
        this.uTc.reset();
      }
      for (;;)
      {
        this.uTp.setVisibility(8);
        this.uTl.setVisibility(8);
        this.prO.setVisibility(0);
        if (this.uTE > 1) {
          this.gBf.setVisibility(0);
        }
        this.prO.bringToFront();
        this.gBf.bringToFront();
        deJ();
        deK();
        AppMethodBeat.o(94700);
        return;
        this.uTc.setTouchEnable(true);
        this.uTc.der();
      }
    }
    if ((this.kmC == 4) || (this.kmC == 3))
    {
      this.uTf.setVisibility(0);
      this.uTg.setVisibility(8);
      this.uTg.setClipChildren(false);
      this.uTd.setVisibility(0);
      this.tAi.setVisibility(0);
      this.uTe.setVisibility(8);
      this.uTc.setVisibility(8);
      if (this.kmC == 3)
      {
        if (this.uMX.uJE) {
          this.uTh.setVisibility(0);
        }
        this.uTl.setVisibility(0);
        this.uOi.setVisibility(8);
      }
      for (;;)
      {
        this.prO.setVisibility(8);
        AppMethodBeat.o(94700);
        return;
        this.uTl.setVisibility(8);
        this.uOi.setVisibility(0);
        this.uOi.setForceScaleFullScreen(true);
        ViewGroup.LayoutParams localLayoutParams = this.uOi.getLayoutParams();
        localLayoutParams.width = -1;
        localLayoutParams.height = -1;
        this.uOi.setLayoutParams(localLayoutParams);
        if (this.jbf.aly()) {
          this.uTn.ajB();
        }
        this.uTk.setVisibility(8);
      }
    }
    if (this.kmC == 6)
    {
      this.uTd.setVisibility(8);
      this.tAi.setVisibility(8);
      this.uTh.setVisibility(8);
      this.uTe.setVisibility(8);
      this.uTc.setVisibility(8);
      AppMethodBeat.o(94700);
      return;
    }
    if (this.kmC == 7)
    {
      this.uTd.setVisibility(8);
      this.tAi.setVisibility(8);
      this.uTe.setVisibility(8);
      this.gBf.setVisibility(8);
      this.uTh.setVisibility(8);
      this.uTc.setTouchEnable(false);
      ap.n(this.uTM, 1500L);
      this.uTc.hideProgress();
      AppMethodBeat.o(94700);
      return;
    }
    if (this.kmC == 8)
    {
      this.uTf.setVisibility(0);
      this.uTg.setVisibility(0);
      this.uTg.setClipChildren(false);
      this.uTd.setVisibility(8);
      this.tAi.setVisibility(8);
      this.uTh.setVisibility(8);
      this.uTe.setVisibility(0);
      if (this.uTE > 1) {
        this.gBf.setVisibility(0);
      }
      this.uTc.setVisibility(0);
      this.prO.setVisibility(0);
      this.uOi.setVisibility(8);
      this.uTp.setVisibility(8);
      this.uTl.setVisibility(8);
      if (this.uTI) {
        Toast.makeText(this, 2131761236, 1).show();
      }
      for (;;)
      {
        this.uTc.setTouchEnable(false);
        this.uTc.setEnabled(false);
        AppMethodBeat.o(94700);
        return;
        Toast.makeText(this, 2131761241, 1).show();
      }
    }
    if (this.kmC == 9)
    {
      this.uTd.setVisibility(8);
      this.tAi.setVisibility(8);
      this.uTh.setVisibility(8);
      this.uTe.setVisibility(0);
      this.gBf.setVisibility(8);
      this.uTc.reset();
      this.uTc.setTouchEnable(false);
      this.uTc.setEnabled(false);
      Toast.makeText(this, 2131761237, 1).show();
    }
    label1135:
    AppMethodBeat.o(94700);
  }
  
  public final void aSh()
  {
    AppMethodBeat.i(94704);
    ac.i("MicroMsg.SightCaptureUI", "onError: %s", new Object[] { Integer.valueOf(1) });
    try
    {
      if (this.jbf != null) {
        this.jbf.reset();
      }
      xs(9);
      AppMethodBeat.o(94704);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.SightCaptureUI", "onError, reset mediaRecorder error: %s", new Object[] { localException.getMessage() });
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
  
  public final void nm(int paramInt)
  {
    AppMethodBeat.i(94703);
    if (this.uTE <= 1)
    {
      AppMethodBeat.o(94703);
      return;
    }
    if (this.kmC == 2)
    {
      AppMethodBeat.o(94703);
      return;
    }
    ac.i("MicroMsg.SightCaptureUI", "onOrientationChange: %s", new Object[] { Integer.valueOf(paramInt) });
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
    while (this.gBf.getRotation() == f)
    {
      AppMethodBeat.o(94703);
      return;
      f = -90.0F;
      continue;
      f = paramInt;
    }
    this.gBf.animate().rotation(f).setDuration(100L).start();
    AppMethodBeat.o(94703);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(94699);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null)
    {
      bool = true;
      ac.i("MicroMsg.SightCaptureUI", "[onActivityResult] requestCode:%s  resultCode:%s data is null?:", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
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
      ac.i("MicroMsg.SightCaptureUI", "[handlePhotoEditResult] resultCode:%s", new Object[] { Integer.valueOf(paramInt2) });
    } while ((paramInt2 != -1) || (paramIntent == null) || (this.jbf == null));
    this.uTP = true;
    this.uTQ = paramIntent.getBundleExtra("report_info");
    this.uTN = paramIntent.getStringExtra("raw_photo_path");
    this.uTO = paramIntent.getStringExtra("after_photo_edit");
    boolean bool = CaptureMMProxy.getInstance().getBoolean(ah.a.GLd, true);
    ac.i("MicroMsg.SightCaptureUI", "rawEditPhotoPath:%s lastEditPhotoPath:%s imageState:%s", new Object[] { this.uTN, this.uTO, Boolean.valueOf(bool) });
    if (!bool)
    {
      paramIntent = CaptureMMProxy.getInstance().getSubCoreImageFullPath("photoEdited_" + System.currentTimeMillis());
      ac.i("MicroMsg.SightCaptureUI", "saveFullPath:%s", new Object[] { paramIntent });
      com.tencent.mm.vfs.i.lZ(this.uTO, paramIntent);
      com.tencent.mm.vfs.i.deleteFile(this.uTO);
      com.tencent.mm.sdk.f.b.k(this.uTO, this);
      this.jbf.vy(paramIntent);
      this.uTO = paramIntent;
    }
    for (;;)
    {
      paramIntent = new BitmapFactory.Options();
      paramIntent.inJustDecodeBounds = true;
      com.tencent.mm.sdk.platformtools.f.decodeFile(this.uTO, paramIntent);
      ac.i("MicroMsg.SightCaptureUI", "rawW:%s rawH:%s", new Object[] { Integer.valueOf(paramIntent.outWidth), Integer.valueOf(paramIntent.outHeight) });
      paramIntent = com.tencent.mm.sdk.platformtools.f.aG(this.uTO, paramIntent.outHeight, paramIntent.outWidth);
      this.uTl.setVisibility(0);
      this.uTl.setImageBitmap(paramIntent);
      this.uTm.setVisibility(8);
      break;
      this.jbf.vy(this.uTO);
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(94702);
    ac.i("MicroMsg.SightCaptureUI", "onBackPressed %d", new Object[] { Integer.valueOf(this.kmC) });
    if ((this.uTr != null) && (this.uTr.onBackPressed()))
    {
      AppMethodBeat.o(94702);
      return;
    }
    if (this.uTr != null)
    {
      this.uTr.release();
      this.uTr = null;
      setSelfNavigationBarVisible(8);
      this.uTd.setVisibility(0);
      this.tAi.setVisibility(0);
      this.uTh.setVisibility(0);
      AppMethodBeat.o(94702);
      return;
    }
    if (deN())
    {
      super.onBackPressed();
      overridePendingTransition(-1, 2130772138);
      oh(true);
    }
    AppMethodBeat.o(94702);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(94684);
    super.onConfigurationChanged(paramConfiguration);
    if ((this.uTJ.booleanValue()) && (com.tencent.mm.compatible.util.d.kZ(13)))
    {
      paramConfiguration = new Point(paramConfiguration.screenWidthDp, paramConfiguration.screenHeightDp);
      if ((this.uTK == null) || (!this.uTK.equals(paramConfiguration)))
      {
        this.uTK = paramConfiguration;
        deF();
      }
    }
    AppMethodBeat.o(94684);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(94680);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    this.uMX = ((SightParams)getIntent().getParcelableExtra("KEY_SIGHT_PARAMS"));
    if (this.uMX == null)
    {
      ac.e("MicroMsg.SightCaptureUI", "error!!!! sightParams is null!!");
      AppMethodBeat.o(94680);
      return;
    }
    CaptureMMProxy.createProxy(new CaptureMMProxy(this.fPa));
    final long l = bs.Gn();
    this.fPa.connect(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94632);
        ac.i("MicroMsg.SightCaptureUI", "connect cost %sms", new Object[] { Long.valueOf(bs.aO(l)) });
        com.tencent.mm.plugin.mmsight.model.k.d(SightCaptureUI.a(SightCaptureUI.this).hcZ);
        SightCaptureUI.b(SightCaptureUI.this);
        AppMethodBeat.o(94632);
      }
    });
    com.tencent.mm.sdk.b.a.GpY.c(this.uTL);
    AppMethodBeat.o(94680);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(94698);
    super.onDestroy();
    ac.i("MicroMsg.SightCaptureUI", "onDestroy");
    this.fPa.release();
    if (this.jbf != null)
    {
      this.jbf.a(null);
      this.jbf.E(null);
      this.jbf.clear();
    }
    if (this.kmC == -1) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        deL();
        if (this.uOi != null)
        {
          this.uOi.stop();
          this.uOi.setVideoCallback(null);
        }
        if (this.ied != null) {
          this.ied.YC();
        }
        if (this.uTr != null)
        {
          this.uTr.release();
          this.uTr = null;
        }
      }
      if (this.gEn != null)
      {
        this.gEn.disable();
        this.gEn.uKw = null;
        this.gEn = null;
      }
      com.tencent.mm.plugin.mmsight.model.a.j.uMV.avJ();
      com.tencent.mm.sdk.b.a.GpY.d(this.uTL);
      AppMethodBeat.o(94698);
      return;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(94681);
    if ((ae.fJd.fEG == 1) && (paramInt == 700) && (this.uTs)) {
      deD();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(94681);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(94682);
    super.onPause();
    ac.i("MicroMsg.SightCaptureUI", "onPause, currentState: %s", new Object[] { IX(this.kmC) });
    if (this.kmC == 2)
    {
      stopRecord();
      AppMethodBeat.o(94682);
      return;
    }
    if (this.kmC == 1)
    {
      deL();
      AppMethodBeat.o(94682);
      return;
    }
    if ((this.kmC == 4) && (this.uOi != null)) {
      this.uOi.pause();
    }
    AppMethodBeat.o(94682);
  }
  
  public void onResume()
  {
    boolean bool2 = false;
    AppMethodBeat.i(94683);
    super.onResume();
    setSelfNavigationBarVisible(8);
    String str = IX(this.kmC);
    boolean bool1 = bool2;
    if (this.jbI != null)
    {
      bool1 = bool2;
      if (this.jbI.isAvailable()) {
        bool1 = true;
      }
    }
    ac.i("MicroMsg.SightCaptureUI", "onResume, currentState: %s, textureview available: %s", new Object[] { str, Boolean.valueOf(bool1) });
    if ((this.kmC == 2) || (this.kmC == 1))
    {
      deF();
      AppMethodBeat.o(94683);
      return;
    }
    if (this.kmC == 4)
    {
      if (this.jbI != null)
      {
        if (!this.jbI.isAvailable()) {
          break label154;
        }
        this.uTn.ajB();
      }
      while (this.uOi != null)
      {
        this.uOi.start();
        AppMethodBeat.o(94683);
        return;
        label154:
        this.jbI.setTextureChangeCallback(new com.tencent.mm.plugin.video.b()
        {
          public final void f(SurfaceTexture paramAnonymousSurfaceTexture)
          {
            AppMethodBeat.i(94669);
            SightCaptureUI.e(SightCaptureUI.this).ajB();
            SightCaptureUI.f(SightCaptureUI.this).setTextureChangeCallback(null);
            AppMethodBeat.o(94669);
          }
        });
      }
    }
    if (this.kmC == 3)
    {
      if (this.jbI != null) {
        this.jbI.setTextureChangeCallback(null);
      }
      this.uTn.a(this.uTz, this.uTD, this.uTA);
    }
    AppMethodBeat.o(94683);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI
 * JD-Core Version:    0.7.0.1
 */