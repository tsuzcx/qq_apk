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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.g.a.jz;
import com.tencent.mm.g.a.ou;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.plugin.mmsight.model.f.a;
import com.tencent.mm.plugin.mmsight.model.f.b;
import com.tencent.mm.plugin.mmsight.model.f.c;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.mmsight.model.p;
import com.tencent.mm.plugin.mmsight.ui.cameraglview.MMSightCameraGLSurfaceView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.h.e;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class SightCaptureUI
  extends MMActivity
  implements com.tencent.mm.plugin.mmsight.model.a.d.a, com.tencent.mm.plugin.mmsight.model.d.a
{
  private String dJw;
  private com.tencent.e.i.d dfj;
  private ImageView gXy;
  private com.tencent.mm.remoteservice.d gkS;
  private com.tencent.mm.plugin.mmsight.model.d haJ;
  private VideoTransPara hxV;
  private com.tencent.mm.compatible.util.b iAr;
  private ViewGroup iOJ;
  private ObservableTextureView jxM;
  private com.tencent.mm.plugin.mmsight.model.a.d jxj;
  private int kKR;
  private boolean kKS;
  private long kKT;
  private MMSightCaptureTouchView qbZ;
  private View uOw;
  private int vYF;
  private SightParams wci;
  private h.a wdC;
  private VideoPlayerTextureView wdv;
  private VideoSeekBarEditorView wdw;
  private MMSightCameraGLSurfaceView wiA;
  private com.tencent.mm.plugin.mmsight.ui.cameraglview.a wiB;
  private TextView wiC;
  private View wiD;
  private MMSightTopCountdownCoverView wiE;
  private b wiF;
  private boolean wiG;
  private byg wiH;
  private byte[] wiI;
  private int wiJ;
  private int wiK;
  private int wiL;
  private int wiM;
  private byte[] wiN;
  private int wiO;
  private boolean wiP;
  private boolean wiQ;
  private boolean wiR;
  private int wiS;
  private int wiT;
  private long wiU;
  private boolean wiV;
  private boolean wiW;
  private Boolean wiX;
  private Point wiY;
  private com.tencent.mm.sdk.b.c wiZ;
  private int win;
  private boolean wio;
  private f wip;
  private MMSightRecordButton wiq;
  private View wir;
  private View wis;
  private ViewGroup wit;
  private ViewGroup wiu;
  private ImageView wiv;
  private SurfaceTexture wiw;
  CameraFrontSightView wix;
  private ViewGroup wiy;
  private ImageView wiz;
  private Runnable wja;
  private String wjb;
  private String wjc;
  private boolean wjd;
  private Bundle wje;
  private Runnable wjf;
  
  public SightCaptureUI()
  {
    AppMethodBeat.i(94679);
    this.win = 1;
    this.vYF = 2;
    this.wio = true;
    this.kKR = -1;
    this.wiG = true;
    this.wiH = new byg();
    this.gkS = new com.tencent.mm.remoteservice.d(ak.getContext());
    this.wiP = false;
    this.wiQ = false;
    this.wiR = false;
    this.wiS = 0;
    this.kKS = false;
    this.wiT = 0;
    this.wiU = -1L;
    this.kKT = -1L;
    this.wiV = false;
    this.wiW = false;
    this.dJw = "";
    this.wiX = Boolean.FALSE;
    this.wiZ = new com.tencent.mm.sdk.b.c() {};
    this.wja = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94662);
        if ((SightCaptureUI.g(SightCaptureUI.this) == 7) && (SightCaptureUI.k(SightCaptureUI.this) != null))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCaptureUI", "showRecoderProgressBar");
          SightCaptureUI.k(SightCaptureUI.this).showLoading();
        }
        AppMethodBeat.o(94662);
      }
    };
    this.wjf = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94663);
        if (SightCaptureUI.g(SightCaptureUI.this) != 4)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SightCaptureUI", "checkPreviewStatusRunnable, not previewing now!!!");
          SightCaptureUI.b(SightCaptureUI.this, 9);
        }
        AppMethodBeat.o(94663);
      }
    };
    this.wdC = new h.a()
    {
      public final int eU(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return 0;
      }
      
      public final void eb(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void onCompletion()
      {
        AppMethodBeat.i(94668);
        SightCaptureUI.S(SightCaptureUI.this).d(0.0D, true);
        AppMethodBeat.o(94668);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(94666);
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SightCaptureUI", "%d on error what %d extra %d", new Object[] { Integer.valueOf(SightCaptureUI.this.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(94666);
      }
      
      public final void ta()
      {
        AppMethodBeat.i(94667);
        if (SightCaptureUI.S(SightCaptureUI.this) != null)
        {
          SightCaptureUI.S(SightCaptureUI.this).start();
          SightCaptureUI.S(SightCaptureUI.this).setLoop(true);
        }
        ar.ay(SightCaptureUI.M(SightCaptureUI.this));
        SightCaptureUI.S(SightCaptureUI.this).setOneTimeVideoTextureUpdateCallback(new h.e()
        {
          public final void bpD()
          {
            AppMethodBeat.i(94665);
            ar.o(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(94664);
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCaptureUI", "onTextureUpdate");
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
            if (SightCaptureUI.a(SightCaptureUI.this).vYN) {
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
  
  private static String KU(int paramInt)
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
  
  private String bA(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(94695);
    boolean bool1 = CaptureMMProxy.getInstance().getBoolean(am.a.IRT, true);
    boolean bool2 = CaptureMMProxy.getInstance().getBoolean(am.a.IRU, true);
    if (paramBoolean) {}
    for (String str = com.tencent.mm.plugin.mmsight.d.arS("jpg");; str = com.tencent.mm.plugin.mmsight.d.arS("mp4"))
    {
      if (((bool1) && (paramBoolean)) || ((bool2) && (!paramBoolean)))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCaptureUI", "auto save src %s dest %s state %s %s", new Object[] { paramString, str, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        o.mF(paramString, str);
        com.tencent.mm.sdk.f.b.k(str, this);
      }
      AppMethodBeat.o(94695);
      return str;
    }
  }
  
  private void dqZ()
  {
    AppMethodBeat.i(94685);
    if ((this.wiU > 0L) && (bu.aO(this.wiU) <= 500L))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCaptureUI", "switchCameraClick, switch camera too frequently!!! ignore");
      AppMethodBeat.o(94685);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.TestCaptureUiEvent", "switchCameraClick %s, currentState: %s", new Object[] { bu.fpN().toString(), Integer.valueOf(this.kKR) });
    drf();
    this.wiP = true;
    if (this.kKR == 2) {
      if ((this.jxj == null) || (!this.jxj.ayn())) {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCaptureUI", "switchCameraClick, not write camera data!");
      }
    }
    for (;;)
    {
      drg();
      this.wiU = bu.HQ();
      AppMethodBeat.o(94685);
      return;
      dri();
      this.wiQ = true;
      continue;
      if (this.kKR == 1)
      {
        yc(6);
        if (oF(true)) {
          yc(1);
        }
      }
    }
  }
  
  private void dra()
  {
    AppMethodBeat.i(94687);
    try
    {
      ViewGroup.LayoutParams localLayoutParams = this.wdv.getLayoutParams();
      this.wit.removeView(this.wdv);
      this.wit.addView(this.wdv, 0, localLayoutParams);
      AppMethodBeat.o(94687);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SightCaptureUI", "clearVideoPlayViewContent, error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94687);
    }
  }
  
  private void drb()
  {
    AppMethodBeat.i(94688);
    yc(0);
    this.wiT = 0;
    this.kKS = false;
    this.wiW = false;
    if (this.wdv != null)
    {
      this.wdv.stop();
      this.wdv.setVideoCallback(null);
      dra();
    }
    if (this.wiF != null)
    {
      this.wiF.release();
      this.wiF = null;
    }
    if (this.wiA != null) {
      this.wiA.setVisibility(0);
    }
    this.wiz.setImageBitmap(null);
    drh();
    this.wip = new f(this.hxV, this.wci.scene);
    this.wip.a(this.wiB.hxv);
    this.wiE.setVisibility(8);
    if (!this.wip.A(this, this.wiG))
    {
      yc(8);
      AppMethodBeat.o(94688);
      return;
    }
    if (this.jxM.isAvailable())
    {
      this.wiw = this.jxM.getSurfaceTexture();
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCaptureUI", "surface already available, directly set local surface: %s", new Object[] { this.wiw });
      if (oF(false)) {
        yc(1);
      }
    }
    for (;;)
    {
      if ((this.wiC != null) && (this.wio))
      {
        this.wiC.setAlpha(1.0F);
        this.wiC.setVisibility(0);
      }
      this.haJ.reset();
      this.wiP = false;
      this.wiQ = false;
      AppMethodBeat.o(94688);
      return;
      yc(8);
      continue;
      this.jxM.setTextureChangeCallback(new com.tencent.mm.plugin.video.b()
      {
        public final void f(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(94644);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCaptureUI", "callback onSurfaceTextureAvailable set local surface: %s", new Object[] { paramAnonymousSurfaceTexture });
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
  
  private int drc()
  {
    AppMethodBeat.i(94690);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCaptureUI", "startRecordImpl");
    int i = this.jxj.b(this.wip.getOrientation(), this.haJ.aoA(), this.haJ.getOrientation());
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCaptureUI", "startRecordImpl ret: %d", new Object[] { Integer.valueOf(i) });
    if (i >= 0) {
      this.wip.a(f.a.wae);
    }
    AppMethodBeat.o(94690);
    return i;
  }
  
  private void drd()
  {
    AppMethodBeat.i(94691);
    this.wiW = true;
    yc(8);
    if (this.jxj != null) {
      try
      {
        this.jxj.cancel();
        this.jxj = null;
        AppMethodBeat.o(94691);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.SightCaptureUI", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(94691);
  }
  
  private void dre()
  {
    AppMethodBeat.i(94692);
    yc(7);
    this.wiq.setTouchEnable(false);
    if (this.wci.vYO) {
      this.wiE.dqR();
    }
    final int i = this.wip.getPreviewWidth();
    final int j = this.wip.getPreviewHeight();
    this.jxj.B(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94647);
        com.tencent.mm.sdk.platformtools.ae.m("MicroMsg.SightCaptureUI", "call stop callback now, currentStatus: %s", new Object[] { SightCaptureUI.KV(SightCaptureUI.g(SightCaptureUI.this)) });
        SightCaptureUI.j(SightCaptureUI.this).a(f.a.waf);
        SightCaptureUI.B(SightCaptureUI.this);
        final long l = com.tencent.mm.plugin.mmsight.d.arU("TIME_RECODER_2_PLAY");
        com.tencent.e.h.MqF.aO(new com.tencent.e.i.h()
        {
          public final String getKey()
          {
            return "BigSightFFMpegRecorder_markAfterCaptureFinish_idkeystat";
          }
          
          public final void run()
          {
            AppMethodBeat.i(94646);
            String str = SightCaptureUI.p(SightCaptureUI.this).getFilePath();
            localbyg = SightCaptureUI.J(SightCaptureUI.this);
            int n = com.tencent.mm.plugin.mmsight.model.k.wat.gdr;
            m = com.tencent.mm.plugin.mmsight.model.k.wat.hrX;
            for (;;)
            {
              try
              {
                if (!bu.isNullOrNil(str))
                {
                  boolean bool = o.fB(str);
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
                com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish error: %s", new Object[] { localException.getMessage() });
                continue;
                int i = 0;
                continue;
                i = 0;
                continue;
                g.yxI.idkeyStat(440L, 88L, 1L, false);
                g.yxI.idkeyStat(440L, 48L, i1, false);
                i = 90;
                int k = 54;
                int j = 50;
                continue;
                if (com.tencent.mm.plugin.mmsight.model.k.wat.dqc()) {
                  continue;
                }
                if (m != 1080) {
                  continue;
                }
                continue;
                if ((i1 <= 10) || (i1 > 15)) {
                  continue;
                }
                g.yxI.idkeyStat(440L, k + 1, 1L, false);
                continue;
                if ((i1 <= 15) || (i1 > 20)) {
                  continue;
                }
                g.yxI.idkeyStat(440L, k + 2, 1L, false);
                continue;
                if ((i1 <= 20) || (i1 > 30)) {
                  continue;
                }
                g.yxI.idkeyStat(440L, k + 3, 1L, false);
                continue;
                if (localbyg.Hlc != 2) {
                  continue;
                }
                g.yxI.idkeyStat(440L, 194L, i2, false);
                g.yxI.idkeyStat(440L, 195L, 1L, false);
                continue;
                g.yxI.idkeyStat(440L, 179L, i2, false);
                g.yxI.idkeyStat(440L, 180L, 1L, false);
                if (localbyg == null) {
                  continue;
                }
                if (localbyg.Hlc != 1) {
                  continue;
                }
                g.yxI.idkeyStat(440L, 189L, i2, false);
                g.yxI.idkeyStat(440L, 190L, 1L, false);
                continue;
                if (localbyg.Hlc != 2) {
                  continue;
                }
                g.yxI.idkeyStat(440L, 199L, i2, false);
                g.yxI.idkeyStat(440L, 200L, 1L, false);
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
              com.tencent.mm.plugin.mmsight.model.l.g(false, l);
              AppMethodBeat.o(94646);
              return;
              g.yxI.idkeyStat(440L, 87L, 1L, false);
              localObject = new JSONObject(SightVideoJNI.getSimpleMp4InfoVFS(str));
              i1 = (int)((JSONObject)localObject).getDouble("videoFPS");
              i2 = ((JSONObject)localObject).optInt("videoBitrate");
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, videoFPS: %s, videoBitrate: %s, recorderType: %s, resolutionLimit: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(n), Integer.valueOf(m) });
              localObject = com.tencent.mm.plugin.mmsight.model.b.dpE();
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).vZr = com.tencent.mm.plugin.mmsight.model.k.wat.gdr;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).videoBitrate = com.tencent.mm.plugin.mmsight.model.k.wat.videoBitrate;
              if (!com.tencent.mm.plugin.mmsight.model.k.wat.hyP) {
                continue;
              }
              i = 1;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).gds = i;
              if (!com.tencent.mm.plugin.mmsight.model.k.wat.waG) {
                continue;
              }
              i = 1;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).vZs = i;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).hrX = com.tencent.mm.plugin.mmsight.model.k.wat.hrX;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).vZt = i1;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).fileSize = o.aZR(str);
              locala = e.ayN(str);
              if (locala != null)
              {
                ((com.tencent.mm.plugin.mmsight.model.b)localObject).vZw = locala.width;
                ((com.tencent.mm.plugin.mmsight.model.b)localObject).vZx = locala.height;
                ((com.tencent.mm.plugin.mmsight.model.b)localObject).vZy = locala.videoBitrate;
                ((com.tencent.mm.plugin.mmsight.model.b)localObject).vZu = locala.videoDuration;
              }
              if (n != 1) {
                continue;
              }
              g.yxI.idkeyStat(440L, 89L, 1L, false);
              g.yxI.idkeyStat(440L, 49L, i1, false);
              i = 93;
              k = 73;
              j = 69;
              continue;
              g.yxI.idkeyStat(440L, j, i1, false);
              g.yxI.idkeyStat(440L, i, 1L, false);
              g.yxI.idkeyStat(440L, 47L, i1, false);
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, filePath: %s base %d", new Object[] { str, Integer.valueOf(k) });
              if ((i1 < 0) || (i1 > 10)) {
                continue;
              }
              g.yxI.idkeyStat(440L, k, 1L, false);
              if (i2 > 0)
              {
                if (n != 2) {
                  continue;
                }
                g.yxI.idkeyStat(440L, 175L, i2, false);
                g.yxI.idkeyStat(440L, 176L, 1L, false);
                if (localbyg != null)
                {
                  if (localbyg.Hlc != 1) {
                    continue;
                  }
                  g.yxI.idkeyStat(440L, 184L, i2, false);
                  g.yxI.idkeyStat(440L, 185L, 1L, false);
                }
              }
            }
          }
        });
        com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.TestCaptureUiEvent", "doStopRecorderAndStartPreviewDone %s", new Object[] { bu.fpN().toString() });
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCaptureUI", "stop finish, filepath: %s %s time_takevideo %s", new Object[] { SightCaptureUI.p(SightCaptureUI.this).getFilePath(), Long.valueOf(o.aZR(SightCaptureUI.p(SightCaptureUI.this).getFilePath())), Long.valueOf(l) });
        SightCaptureUI.a(SightCaptureUI.this, SightCaptureUI.p(SightCaptureUI.this).Lj());
        SightCaptureUI.A(SightCaptureUI.this);
        SightCaptureUI.K(SightCaptureUI.this);
        SightCaptureUI.L(SightCaptureUI.this);
        ar.o(SightCaptureUI.M(SightCaptureUI.this), 1000L);
        if ((SightCaptureUI.a(SightCaptureUI.this).scene == 1) || (SightCaptureUI.a(SightCaptureUI.this).scene == 2) || (SightCaptureUI.a(SightCaptureUI.this).scene == 7)) {
          g.yxI.f(13819, new Object[] { Integer.valueOf(2), Integer.valueOf(SightCaptureUI.a(SightCaptureUI.this).scene), SightCaptureUI.a(SightCaptureUI.this).sSE, Long.valueOf(bu.aRi()) });
        }
        AppMethodBeat.o(94647);
      }
    });
    AppMethodBeat.o(94692);
  }
  
  private void drf()
  {
    AppMethodBeat.i(94693);
    com.tencent.mm.plugin.mmsight.model.a.l.dqm();
    if (!com.tencent.mm.plugin.mmsight.model.a.l.cLB())
    {
      AppMethodBeat.o(94693);
      return;
    }
    TextView localTextView = (TextView)findViewById(2131306323);
    localTextView.setVisibility(8);
    localTextView.setText("");
    AppMethodBeat.o(94693);
  }
  
  private void drg()
  {
    AppMethodBeat.i(94694);
    com.tencent.mm.plugin.mmsight.model.a.l.dqm();
    if (!com.tencent.mm.plugin.mmsight.model.a.l.cLB())
    {
      AppMethodBeat.o(94694);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCaptureUI", "test for debug " + bu.fpN().toString());
    j.ae(new Runnable()
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
  
  private void drh()
  {
    AppMethodBeat.i(94696);
    if (this.jxM != null) {
      this.jxM.setTextureChangeCallback(null);
    }
    if (this.wip != null)
    {
      this.wiG = this.wip.axd();
      this.wip.dpO();
      this.wiU = -1L;
      this.kKT = -1L;
    }
    AppMethodBeat.o(94696);
  }
  
  private void dri()
  {
    AppMethodBeat.i(94697);
    int i = this.kKR;
    if (this.jxj != null) {}
    for (Object localObject = this.jxj.ayj();; localObject = "")
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCaptureUI", "switchCameraOnRecord, currentStatus: %s, mediaRecorder.status: %s", new Object[] { Integer.valueOf(i), localObject });
      if ((this.kKR != 2) || (this.jxj == null) || (this.jxj.ayj() != d.c.wbs)) {
        break label406;
      }
      this.jxj.pause();
      this.wip.a(this, this.wiw, false);
      this.wiG = this.wip.axd();
      if (this.wiB != null) {
        this.wiB.al(this.wip.getPreviewWidth(), this.wip.getPreviewHeight(), this.wip.getOrientation());
      }
      if (this.jxj.ayj() == d.c.wbA) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SightCaptureUI", "switchCameraOnRecord, recorder status error: %s", new Object[] { this.jxj.ayj() });
      AppMethodBeat.o(94697);
      return;
    }
    i = this.wip.getPreviewWidth();
    int j = this.wip.getPreviewHeight();
    int k = this.wip.getOrientation();
    localObject = this.jxj.ayl();
    int m = this.jxj.aym();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCaptureUI", "switchCameraOnRecord, newPreviewSize: [%s, %s], oldPreviewSize: [%s], newOrientation: %s, oldOrientation: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localObject, Integer.valueOf(k), Integer.valueOf(m) });
    if ((m != k) || (((Point)localObject).x != i) || (((Point)localObject).y != j)) {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SightCaptureUI", "error oldOrientation! after switch, size or orientation not match");
    }
    this.jxj.s(this.wip.getPreviewWidth(), this.wip.getPreviewHeight(), this.wip.getEncodeVideoBestSize().x, this.wip.getEncodeVideoBestSize().y);
    this.jxj.L(k, this.wip.getEncodeVideoBestSize().x, this.wip.getEncodeVideoBestSize().y);
    label406:
    AppMethodBeat.o(94697);
  }
  
  private boolean drj()
  {
    return (this.kKR == 4) || (this.kKR == 3) || (this.kKR == 1) || (this.kKR == 8) || (this.kKR == 9);
  }
  
  private boolean oF(boolean paramBoolean)
  {
    AppMethodBeat.i(94689);
    com.tencent.mm.sdk.platformtools.ae.l("MicroMsg.SightCaptureUI", "createRecorder, surface: %s", new Object[] { this.wiw });
    this.wiW = false;
    if (this.jxj != null)
    {
      if (this.wip != null) {
        this.wip.b(this.jxj.getFrameDataCallback());
      }
      this.jxj.cancel();
    }
    if (this.wip == null)
    {
      AppMethodBeat.o(94689);
      return false;
    }
    this.wiH = new byg();
    this.wiH.Hlb = true;
    this.wiH.Hla = com.tencent.mm.plugin.mmsight.model.k.wat.waI;
    if (this.wci != null) {
      this.wiH.Hlc = this.wci.scene;
    }
    if (!paramBoolean)
    {
      if (this.wip.a(this.wiw, true) < 0)
      {
        AppMethodBeat.o(94689);
        return false;
      }
    }
    else
    {
      paramBoolean = this.wip.a(this, this.wiw, true);
      this.wiG = this.wip.axd();
      if (!paramBoolean)
      {
        AppMethodBeat.o(94689);
        return false;
      }
    }
    if (this.wip.getEncodeVideoBestSize() == null)
    {
      AppMethodBeat.o(94689);
      return false;
    }
    com.tencent.mm.plugin.mmsight.model.a.l.dqm();
    this.jxj = com.tencent.mm.plugin.mmsight.model.a.l.q(this.hxV);
    if (this.jxj == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SightCaptureUI", "create mediaRecorder error");
      this.wiW = true;
      AppMethodBeat.o(94689);
      return false;
    }
    com.tencent.mm.plugin.mmsight.d.a(this.jxj, this.wci);
    this.jxj.a(this);
    this.wip.a(this.jxj.getFrameDataCallback());
    if (this.wiB != null) {
      this.wiB.al(this.wip.getPreviewWidth(), this.wip.getPreviewHeight(), this.wip.getOrientation());
    }
    if ((this.wci != null) && (this.wci.scene == 3) && ((this.wci.mode == 2) || (this.wci.mode == 0)) && (!bu.isNullOrNil(this.wci.vYJ)) && (!bu.isNullOrNil(this.wci.vYI))) {
      this.jxj.yZ(this.wci.vYJ + this.wci.vYI);
    }
    this.jxj.s(this.wip.getPreviewWidth(), this.wip.getPreviewHeight(), this.wip.getEncodeVideoBestSize().x, this.wip.getEncodeVideoBestSize().y);
    paramBoolean = this.jxj.og(this.wip.getOrientation());
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCaptureUI", "preInit result: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.wiW = true;
    }
    AppMethodBeat.o(94689);
    return paramBoolean;
  }
  
  private void oG(boolean paramBoolean)
  {
    AppMethodBeat.i(94701);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCaptureUI", "[clearPhotoEditCache] isDelete:%s mLastEditPhotoPath:%s mRawEditPhotoPath:%s", new Object[] { Boolean.valueOf(paramBoolean), this.wjc, this.wjb });
    if ((!bu.isNullOrNil(this.wjc)) && (paramBoolean)) {
      o.deleteFile(this.wjc);
    }
    if (!bu.isNullOrNil(this.wjb)) {
      o.deleteFile(this.wjb);
    }
    this.wjc = null;
    this.wjb = null;
    ou localou = new ou();
    localou.dDQ.dlO = 0;
    com.tencent.mm.sdk.b.a.IvT.l(localou);
    AppMethodBeat.o(94701);
  }
  
  private void stopRecord()
  {
    AppMethodBeat.i(94686);
    com.tencent.mm.sdk.platformtools.ae.m("MicroMsg.SightCaptureUI", "stopRecord, currentStatus: %s", new Object[] { Integer.valueOf(this.kKR) });
    if (this.kKR == 2) {
      dre();
    }
    AppMethodBeat.o(94686);
  }
  
  private void yc(int paramInt)
  {
    AppMethodBeat.i(94700);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCaptureUI", "pre state %s %s update state %s %s", new Object[] { Integer.valueOf(this.kKR), KU(this.kKR), Integer.valueOf(paramInt), KU(paramInt) });
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.TestCaptureUiEvent", "pre state %s %s update state %s %s %s", new Object[] { Integer.valueOf(this.kKR), KU(this.kKR), Integer.valueOf(paramInt), KU(paramInt), bu.fpN().toString() });
    if (paramInt == this.kKR)
    {
      AppMethodBeat.o(94700);
      return;
    }
    if (this.wit == null)
    {
      AppMethodBeat.o(94700);
      return;
    }
    com.tencent.mm.plugin.mmsight.d.arT("TIME_RECODER_2_PLAY");
    this.kKR = paramInt;
    if (this.kKR != 7) {
      ar.ay(this.wja);
    }
    if (this.kKR == 0)
    {
      this.wit.setVisibility(8);
      this.wiv.setVisibility(8);
      this.wiu.setVisibility(8);
      this.wiz.setVisibility(8);
      this.wiy.setVisibility(0);
      if (this.wiS > 1) {
        this.gXy.setVisibility(0);
      }
      if (this.wip != null) {
        this.wip.a(f.a.wad);
      }
      com.tencent.mm.plugin.mmsight.model.b.reset();
      if (this.dfj == null) {
        break label1135;
      }
      try
      {
        this.dfj.cancel(true);
        this.dfj = null;
        AppMethodBeat.o(94700);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.SightCaptureUI", localException, "update to state init, interrupt failed: %s", new Object[] { localException.getMessage() });
        }
      }
    }
    if ((this.kKR == 1) || (this.kKR == 2))
    {
      this.wit.setVisibility(0);
      this.wiv.setVisibility(8);
      this.wiu.setVisibility(0);
      this.wiu.setClipChildren(false);
      this.wir.setVisibility(8);
      this.uOw.setVisibility(8);
      this.wis.setVisibility(0);
      this.wiq.setVisibility(0);
      this.wdv.setVisibility(8);
      if (this.kKR == 1) {
        this.wiq.reset();
      }
      for (;;)
      {
        this.wiD.setVisibility(8);
        this.wiz.setVisibility(8);
        this.qbZ.setVisibility(0);
        if (this.wiS > 1) {
          this.gXy.setVisibility(0);
        }
        this.qbZ.bringToFront();
        this.gXy.bringToFront();
        drf();
        drg();
        AppMethodBeat.o(94700);
        return;
        this.wiq.setTouchEnable(true);
        this.wiq.dqN();
      }
    }
    if ((this.kKR == 4) || (this.kKR == 3))
    {
      this.wit.setVisibility(0);
      this.wiu.setVisibility(8);
      this.wiu.setClipChildren(false);
      this.wir.setVisibility(0);
      this.uOw.setVisibility(0);
      this.wis.setVisibility(8);
      this.wiq.setVisibility(8);
      if (this.kKR == 3)
      {
        if (this.wci.vYN) {
          this.wiv.setVisibility(0);
        }
        this.wiz.setVisibility(0);
        this.wdv.setVisibility(8);
      }
      for (;;)
      {
        this.qbZ.setVisibility(8);
        AppMethodBeat.o(94700);
        return;
        this.wiz.setVisibility(8);
        this.wdv.setVisibility(0);
        this.wdv.setForceScaleFullScreen(true);
        ViewGroup.LayoutParams localLayoutParams = this.wdv.getLayoutParams();
        localLayoutParams.width = -1;
        localLayoutParams.height = -1;
        this.wdv.setLayoutParams(localLayoutParams);
        if (this.jxj.aoA()) {
          this.wiB.amC();
        }
        this.wiy.setVisibility(8);
      }
    }
    if (this.kKR == 6)
    {
      this.wir.setVisibility(8);
      this.uOw.setVisibility(8);
      this.wiv.setVisibility(8);
      this.wis.setVisibility(8);
      this.wiq.setVisibility(8);
      AppMethodBeat.o(94700);
      return;
    }
    if (this.kKR == 7)
    {
      this.wir.setVisibility(8);
      this.uOw.setVisibility(8);
      this.wis.setVisibility(8);
      this.gXy.setVisibility(8);
      this.wiv.setVisibility(8);
      this.wiq.setTouchEnable(false);
      ar.o(this.wja, 1500L);
      this.wiq.hideProgress();
      AppMethodBeat.o(94700);
      return;
    }
    if (this.kKR == 8)
    {
      this.wit.setVisibility(0);
      this.wiu.setVisibility(0);
      this.wiu.setClipChildren(false);
      this.wir.setVisibility(8);
      this.uOw.setVisibility(8);
      this.wiv.setVisibility(8);
      this.wis.setVisibility(0);
      if (this.wiS > 1) {
        this.gXy.setVisibility(0);
      }
      this.wiq.setVisibility(0);
      this.qbZ.setVisibility(0);
      this.wdv.setVisibility(8);
      this.wiD.setVisibility(8);
      this.wiz.setVisibility(8);
      if (this.wiW) {
        Toast.makeText(this, 2131761236, 1).show();
      }
      for (;;)
      {
        this.wiq.setTouchEnable(false);
        this.wiq.setEnabled(false);
        AppMethodBeat.o(94700);
        return;
        Toast.makeText(this, 2131761241, 1).show();
      }
    }
    if (this.kKR == 9)
    {
      this.wir.setVisibility(8);
      this.uOw.setVisibility(8);
      this.wiv.setVisibility(8);
      this.wis.setVisibility(0);
      this.gXy.setVisibility(8);
      this.wiq.reset();
      this.wiq.setTouchEnable(false);
      this.wiq.setEnabled(false);
      Toast.makeText(this, 2131761237, 1).show();
    }
    label1135:
    AppMethodBeat.o(94700);
  }
  
  public final void aVS()
  {
    AppMethodBeat.i(94704);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCaptureUI", "onError: %s", new Object[] { Integer.valueOf(1) });
    try
    {
      if (this.jxj != null) {
        this.jxj.reset();
      }
      yc(9);
      AppMethodBeat.o(94704);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SightCaptureUI", "onError, reset mediaRecorder error: %s", new Object[] { localException.getMessage() });
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
  
  public final void nO(int paramInt)
  {
    AppMethodBeat.i(94703);
    if (this.wiS <= 1)
    {
      AppMethodBeat.o(94703);
      return;
    }
    if (this.kKR == 2)
    {
      AppMethodBeat.o(94703);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCaptureUI", "onOrientationChange: %s", new Object[] { Integer.valueOf(paramInt) });
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
    while (this.gXy.getRotation() == f)
    {
      AppMethodBeat.o(94703);
      return;
      f = -90.0F;
      continue;
      f = paramInt;
    }
    this.gXy.animate().rotation(f).setDuration(100L).start();
    AppMethodBeat.o(94703);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(94699);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null)
    {
      bool = true;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCaptureUI", "[onActivityResult] requestCode:%s  resultCode:%s data is null?:", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
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
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCaptureUI", "[handlePhotoEditResult] resultCode:%s", new Object[] { Integer.valueOf(paramInt2) });
    } while ((paramInt2 != -1) || (paramIntent == null) || (this.jxj == null));
    this.wjd = true;
    this.wje = paramIntent.getBundleExtra("report_info");
    this.wjb = paramIntent.getStringExtra("raw_photo_path");
    this.wjc = paramIntent.getStringExtra("after_photo_edit");
    boolean bool = CaptureMMProxy.getInstance().getBoolean(am.a.IRT, true);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCaptureUI", "rawEditPhotoPath:%s lastEditPhotoPath:%s imageState:%s", new Object[] { this.wjb, this.wjc, Boolean.valueOf(bool) });
    if (!bool)
    {
      paramIntent = CaptureMMProxy.getInstance().getSubCoreImageFullPath("photoEdited_" + System.currentTimeMillis());
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCaptureUI", "saveFullPath:%s", new Object[] { paramIntent });
      o.mF(this.wjc, paramIntent);
      o.deleteFile(this.wjc);
      com.tencent.mm.sdk.f.b.k(this.wjc, this);
      this.jxj.yZ(paramIntent);
      this.wjc = paramIntent;
    }
    for (;;)
    {
      paramIntent = new BitmapFactory.Options();
      paramIntent.inJustDecodeBounds = true;
      com.tencent.mm.sdk.platformtools.h.decodeFile(this.wjc, paramIntent);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCaptureUI", "rawW:%s rawH:%s", new Object[] { Integer.valueOf(paramIntent.outWidth), Integer.valueOf(paramIntent.outHeight) });
      paramIntent = com.tencent.mm.sdk.platformtools.h.aM(this.wjc, paramIntent.outHeight, paramIntent.outWidth);
      this.wiz.setVisibility(0);
      this.wiz.setImageBitmap(paramIntent);
      this.wiA.setVisibility(8);
      break;
      this.jxj.yZ(this.wjc);
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(94702);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCaptureUI", "onBackPressed %d", new Object[] { Integer.valueOf(this.kKR) });
    if ((this.wiF != null) && (this.wiF.onBackPressed()))
    {
      AppMethodBeat.o(94702);
      return;
    }
    if (this.wiF != null)
    {
      this.wiF.release();
      this.wiF = null;
      setSelfNavigationBarVisible(8);
      this.wir.setVisibility(0);
      this.uOw.setVisibility(0);
      this.wiv.setVisibility(0);
      AppMethodBeat.o(94702);
      return;
    }
    if (drj())
    {
      super.onBackPressed();
      overridePendingTransition(-1, 2130772138);
      oG(true);
    }
    AppMethodBeat.o(94702);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(94684);
    super.onConfigurationChanged(paramConfiguration);
    if ((this.wiX.booleanValue()) && (com.tencent.mm.compatible.util.d.lA(13)))
    {
      paramConfiguration = new Point(paramConfiguration.screenWidthDp, paramConfiguration.screenHeightDp);
      if ((this.wiY == null) || (!this.wiY.equals(paramConfiguration)))
      {
        this.wiY = paramConfiguration;
        drb();
      }
    }
    AppMethodBeat.o(94684);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(94680);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    this.wci = ((SightParams)getIntent().getParcelableExtra("KEY_SIGHT_PARAMS"));
    if (this.wci == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SightCaptureUI", "error!!!! sightParams is null!!");
      AppMethodBeat.o(94680);
      return;
    }
    CaptureMMProxy.createProxy(new CaptureMMProxy(this.gkS));
    final long l = bu.HQ();
    this.gkS.connect(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94632);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCaptureUI", "connect cost %sms", new Object[] { Long.valueOf(bu.aO(l)) });
        com.tencent.mm.plugin.mmsight.model.k.d(SightCaptureUI.a(SightCaptureUI.this).hxV);
        SightCaptureUI.b(SightCaptureUI.this);
        AppMethodBeat.o(94632);
      }
    });
    com.tencent.mm.sdk.b.a.IvT.c(this.wiZ);
    AppMethodBeat.o(94680);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(94698);
    super.onDestroy();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCaptureUI", "onDestroy");
    this.gkS.release();
    if (this.jxj != null)
    {
      this.jxj.a(null);
      this.jxj.B(null);
      this.jxj.clear();
    }
    if (this.kKR == -1) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        drh();
        if (this.wdv != null)
        {
          this.wdv.stop();
          this.wdv.setVideoCallback(null);
        }
        if (this.iAr != null) {
          this.iAr.abn();
        }
        if (this.wiF != null)
        {
          this.wiF.release();
          this.wiF = null;
        }
      }
      if (this.haJ != null)
      {
        this.haJ.disable();
        this.haJ.vZF = null;
        this.haJ = null;
      }
      com.tencent.mm.plugin.mmsight.model.a.k.wcg.ayL();
      com.tencent.mm.sdk.b.a.IvT.d(this.wiZ);
      AppMethodBeat.o(94698);
      return;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(94681);
    if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gal == 1) && (paramInt == 700) && (this.wiG)) {
      dqZ();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(94681);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(94682);
    super.onPause();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCaptureUI", "onPause, currentState: %s", new Object[] { KU(this.kKR) });
    if (this.kKR == 2)
    {
      stopRecord();
      AppMethodBeat.o(94682);
      return;
    }
    if (this.kKR == 1)
    {
      drh();
      AppMethodBeat.o(94682);
      return;
    }
    if ((this.kKR == 4) && (this.wdv != null)) {
      this.wdv.pause();
    }
    AppMethodBeat.o(94682);
  }
  
  public void onResume()
  {
    boolean bool2 = false;
    AppMethodBeat.i(94683);
    super.onResume();
    setSelfNavigationBarVisible(8);
    String str = KU(this.kKR);
    boolean bool1 = bool2;
    if (this.jxM != null)
    {
      bool1 = bool2;
      if (this.jxM.isAvailable()) {
        bool1 = true;
      }
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCaptureUI", "onResume, currentState: %s, textureview available: %s", new Object[] { str, Boolean.valueOf(bool1) });
    if ((this.kKR == 2) || (this.kKR == 1))
    {
      drb();
      AppMethodBeat.o(94683);
      return;
    }
    if (this.kKR == 4)
    {
      if (this.jxM != null)
      {
        if (!this.jxM.isAvailable()) {
          break label154;
        }
        this.wiB.amC();
      }
      while (this.wdv != null)
      {
        this.wdv.start();
        AppMethodBeat.o(94683);
        return;
        label154:
        this.jxM.setTextureChangeCallback(new com.tencent.mm.plugin.video.b()
        {
          public final void f(SurfaceTexture paramAnonymousSurfaceTexture)
          {
            AppMethodBeat.i(94669);
            SightCaptureUI.e(SightCaptureUI.this).amC();
            SightCaptureUI.f(SightCaptureUI.this).setTextureChangeCallback(null);
            AppMethodBeat.o(94669);
          }
        });
      }
    }
    if (this.kKR == 3)
    {
      if (this.jxM != null) {
        this.jxM.setTextureChangeCallback(null);
      }
      this.wiB.a(this.wiN, this.wiR, this.wiO);
    }
    AppMethodBeat.o(94683);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI
 * JD-Core Version:    0.7.0.1
 */