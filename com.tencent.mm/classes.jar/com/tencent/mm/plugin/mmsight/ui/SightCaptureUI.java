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
import com.tencent.mm.g.a.ot;
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
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.h.e;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class SightCaptureUI
  extends MMActivity
  implements com.tencent.mm.plugin.mmsight.model.a.d.a, com.tencent.mm.plugin.mmsight.model.d.a
{
  private String dIs;
  private com.tencent.e.i.d deh;
  private ImageView gUP;
  private com.tencent.mm.plugin.mmsight.model.d gXX;
  private com.tencent.mm.remoteservice.d giA;
  private VideoTransPara hvh;
  private ViewGroup iLQ;
  private com.tencent.mm.compatible.util.b ixy;
  private ObservableTextureView juR;
  private com.tencent.mm.plugin.mmsight.model.a.d juo;
  private int kHC;
  private boolean kHD;
  private long kHE;
  private MMSightCaptureTouchView pVu;
  private View uCR;
  private int vMB;
  private SightParams vQe;
  private VideoPlayerTextureView vRr;
  private VideoSeekBarEditorView vRs;
  private h.a vRy;
  private MMSightTopCountdownCoverView vWA;
  private b vWB;
  private boolean vWC;
  private bxm vWD;
  private byte[] vWE;
  private int vWF;
  private int vWG;
  private int vWH;
  private int vWI;
  private byte[] vWJ;
  private int vWK;
  private boolean vWL;
  private boolean vWM;
  private boolean vWN;
  private int vWO;
  private int vWP;
  private long vWQ;
  private boolean vWR;
  private boolean vWS;
  private Boolean vWT;
  private Point vWU;
  private com.tencent.mm.sdk.b.c vWV;
  private Runnable vWW;
  private String vWX;
  private String vWY;
  private boolean vWZ;
  private int vWj;
  private boolean vWk;
  private f vWl;
  private MMSightRecordButton vWm;
  private View vWn;
  private View vWo;
  private ViewGroup vWp;
  private ViewGroup vWq;
  private ImageView vWr;
  private SurfaceTexture vWs;
  CameraFrontSightView vWt;
  private ViewGroup vWu;
  private ImageView vWv;
  private MMSightCameraGLSurfaceView vWw;
  private com.tencent.mm.plugin.mmsight.ui.cameraglview.a vWx;
  private TextView vWy;
  private View vWz;
  private Bundle vXa;
  private Runnable vXb;
  
  public SightCaptureUI()
  {
    AppMethodBeat.i(94679);
    this.vWj = 1;
    this.vMB = 2;
    this.vWk = true;
    this.kHC = -1;
    this.vWC = true;
    this.vWD = new bxm();
    this.giA = new com.tencent.mm.remoteservice.d(aj.getContext());
    this.vWL = false;
    this.vWM = false;
    this.vWN = false;
    this.vWO = 0;
    this.kHD = false;
    this.vWP = 0;
    this.vWQ = -1L;
    this.kHE = -1L;
    this.vWR = false;
    this.vWS = false;
    this.dIs = "";
    this.vWT = Boolean.FALSE;
    this.vWV = new SightCaptureUI.12(this);
    this.vWW = new Runnable()
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
    this.vXb = new Runnable()
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
    this.vRy = new h.a()
    {
      public final int eT(int paramAnonymousInt1, int paramAnonymousInt2)
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
        ad.e("MicroMsg.SightCaptureUI", "%d on error what %d extra %d", new Object[] { Integer.valueOf(SightCaptureUI.this.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
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
        aq.aA(SightCaptureUI.M(SightCaptureUI.this));
        SightCaptureUI.S(SightCaptureUI.this).setOneTimeVideoTextureUpdateCallback(new h.e()
        {
          public final void boT()
          {
            AppMethodBeat.i(94665);
            aq.o(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(94664);
                ad.i("MicroMsg.SightCaptureUI", "onTextureUpdate");
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
            if (SightCaptureUI.a(SightCaptureUI.this).vMK) {
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
  
  private static String Ku(int paramInt)
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
  
  private String bw(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(94695);
    boolean bool1 = CaptureMMProxy.getInstance().getBoolean(al.a.Ixv, true);
    boolean bool2 = CaptureMMProxy.getInstance().getBoolean(al.a.Ixw, true);
    if (paramBoolean) {}
    for (String str = com.tencent.mm.plugin.mmsight.d.aqN("jpg");; str = com.tencent.mm.plugin.mmsight.d.aqN("mp4"))
    {
      if (((bool1) && (paramBoolean)) || ((bool2) && (!paramBoolean)))
      {
        ad.i("MicroMsg.SightCaptureUI", "auto save src %s dest %s state %s %s", new Object[] { paramString, str, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        com.tencent.mm.vfs.i.mz(paramString, str);
        com.tencent.mm.sdk.f.b.k(str, this);
      }
      AppMethodBeat.o(94695);
      return str;
    }
  }
  
  private void dob()
  {
    AppMethodBeat.i(94685);
    if ((this.vWQ > 0L) && (bt.aO(this.vWQ) <= 500L))
    {
      ad.i("MicroMsg.SightCaptureUI", "switchCameraClick, switch camera too frequently!!! ignore");
      AppMethodBeat.o(94685);
      return;
    }
    ad.v("MicroMsg.TestCaptureUiEvent", "switchCameraClick %s, currentState: %s", new Object[] { bt.flS().toString(), Integer.valueOf(this.kHC) });
    doh();
    this.vWL = true;
    if (this.kHC == 2) {
      if ((this.juo == null) || (!this.juo.axY())) {
        ad.i("MicroMsg.SightCaptureUI", "switchCameraClick, not write camera data!");
      }
    }
    for (;;)
    {
      doi();
      this.vWQ = bt.HI();
      AppMethodBeat.o(94685);
      return;
      dok();
      this.vWM = true;
      continue;
      if (this.kHC == 1)
      {
        xY(6);
        if (oA(true)) {
          xY(1);
        }
      }
    }
  }
  
  private void doc()
  {
    AppMethodBeat.i(94687);
    try
    {
      ViewGroup.LayoutParams localLayoutParams = this.vRr.getLayoutParams();
      this.vWp.removeView(this.vRr);
      this.vWp.addView(this.vRr, 0, localLayoutParams);
      AppMethodBeat.o(94687);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.SightCaptureUI", "clearVideoPlayViewContent, error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94687);
    }
  }
  
  private void dod()
  {
    AppMethodBeat.i(94688);
    xY(0);
    this.vWP = 0;
    this.kHD = false;
    this.vWS = false;
    if (this.vRr != null)
    {
      this.vRr.stop();
      this.vRr.setVideoCallback(null);
      doc();
    }
    if (this.vWB != null)
    {
      this.vWB.release();
      this.vWB = null;
    }
    if (this.vWw != null) {
      this.vWw.setVisibility(0);
    }
    this.vWv.setImageBitmap(null);
    doj();
    this.vWl = new f(this.hvh, this.vQe.scene);
    this.vWl.a(this.vWx.huH);
    this.vWA.setVisibility(8);
    if (!this.vWl.A(this, this.vWC))
    {
      xY(8);
      AppMethodBeat.o(94688);
      return;
    }
    if (this.juR.isAvailable())
    {
      this.vWs = this.juR.getSurfaceTexture();
      ad.i("MicroMsg.SightCaptureUI", "surface already available, directly set local surface: %s", new Object[] { this.vWs });
      if (oA(false)) {
        xY(1);
      }
    }
    for (;;)
    {
      if ((this.vWy != null) && (this.vWk))
      {
        this.vWy.setAlpha(1.0F);
        this.vWy.setVisibility(0);
      }
      this.gXX.reset();
      this.vWL = false;
      this.vWM = false;
      AppMethodBeat.o(94688);
      return;
      xY(8);
      continue;
      this.juR.setTextureChangeCallback(new com.tencent.mm.plugin.video.b()
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
  
  private int doe()
  {
    AppMethodBeat.i(94690);
    ad.i("MicroMsg.SightCaptureUI", "startRecordImpl");
    int i = this.juo.b(this.vWl.getOrientation(), this.gXX.aol(), this.gXX.getOrientation());
    ad.i("MicroMsg.SightCaptureUI", "startRecordImpl ret: %d", new Object[] { Integer.valueOf(i) });
    if (i >= 0) {
      this.vWl.a(f.a.vOb);
    }
    AppMethodBeat.o(94690);
    return i;
  }
  
  private void dof()
  {
    AppMethodBeat.i(94691);
    this.vWS = true;
    xY(8);
    if (this.juo != null) {
      try
      {
        this.juo.cancel();
        this.juo = null;
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
  
  private void dog()
  {
    AppMethodBeat.i(94692);
    xY(7);
    this.vWm.setTouchEnable(false);
    if (this.vQe.vML) {
      this.vWA.dnT();
    }
    final int i = this.vWl.getPreviewWidth();
    final int j = this.vWl.getPreviewHeight();
    this.juo.D(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94647);
        ad.m("MicroMsg.SightCaptureUI", "call stop callback now, currentStatus: %s", new Object[] { SightCaptureUI.Kv(SightCaptureUI.g(SightCaptureUI.this)) });
        SightCaptureUI.j(SightCaptureUI.this).a(f.a.vOc);
        SightCaptureUI.B(SightCaptureUI.this);
        final long l = com.tencent.mm.plugin.mmsight.d.aqP("TIME_RECODER_2_PLAY");
        com.tencent.e.h.LTJ.aR(new com.tencent.e.i.h()
        {
          public final String getKey()
          {
            return "BigSightFFMpegRecorder_markAfterCaptureFinish_idkeystat";
          }
          
          public final void run()
          {
            AppMethodBeat.i(94646);
            String str = SightCaptureUI.p(SightCaptureUI.this).getFilePath();
            localbxm = SightCaptureUI.J(SightCaptureUI.this);
            int n = com.tencent.mm.plugin.mmsight.model.k.vOq.gbj;
            m = com.tencent.mm.plugin.mmsight.model.k.vOq.hpj;
            for (;;)
            {
              try
              {
                if (!bt.isNullOrNil(str))
                {
                  boolean bool = com.tencent.mm.vfs.i.fv(str);
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
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 88L, 1L, false);
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 48L, i1, false);
                i = 90;
                int k = 54;
                int j = 50;
                continue;
                if (com.tencent.mm.plugin.mmsight.model.k.vOq.dne()) {
                  continue;
                }
                if (m != 1080) {
                  continue;
                }
                continue;
                if ((i1 <= 10) || (i1 > 15)) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, k + 1, 1L, false);
                continue;
                if ((i1 <= 15) || (i1 > 20)) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, k + 2, 1L, false);
                continue;
                if ((i1 <= 20) || (i1 > 30)) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, k + 3, 1L, false);
                continue;
                if (localbxm.GRB != 2) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 194L, i2, false);
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 195L, 1L, false);
                continue;
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 179L, i2, false);
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 180L, 1L, false);
                if (localbxm == null) {
                  continue;
                }
                if (localbxm.GRB != 1) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 189L, i2, false);
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 190L, 1L, false);
                continue;
                if (localbxm.GRB != 2) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 199L, i2, false);
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 200L, 1L, false);
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
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 87L, 1L, false);
              localObject = new JSONObject(SightVideoJNI.getSimpleMp4InfoVFS(str));
              i1 = (int)((JSONObject)localObject).getDouble("videoFPS");
              i2 = ((JSONObject)localObject).optInt("videoBitrate");
              ad.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, videoFPS: %s, videoBitrate: %s, recorderType: %s, resolutionLimit: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(n), Integer.valueOf(m) });
              localObject = com.tencent.mm.plugin.mmsight.model.b.dmG();
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).vNo = com.tencent.mm.plugin.mmsight.model.k.vOq.gbj;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).videoBitrate = com.tencent.mm.plugin.mmsight.model.k.vOq.videoBitrate;
              if (!com.tencent.mm.plugin.mmsight.model.k.vOq.hwb) {
                continue;
              }
              i = 1;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).gbk = i;
              if (!com.tencent.mm.plugin.mmsight.model.k.vOq.vOD) {
                continue;
              }
              i = 1;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).vNp = i;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).hpj = com.tencent.mm.plugin.mmsight.model.k.vOq.hpj;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).vNq = i1;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).fileSize = com.tencent.mm.vfs.i.aYo(str);
              locala = e.axx(str);
              if (locala != null)
              {
                ((com.tencent.mm.plugin.mmsight.model.b)localObject).vNt = locala.width;
                ((com.tencent.mm.plugin.mmsight.model.b)localObject).vNu = locala.height;
                ((com.tencent.mm.plugin.mmsight.model.b)localObject).vNv = locala.videoBitrate;
                ((com.tencent.mm.plugin.mmsight.model.b)localObject).vNr = locala.videoDuration;
              }
              if (n != 1) {
                continue;
              }
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 89L, 1L, false);
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 49L, i1, false);
              i = 93;
              k = 73;
              j = 69;
              continue;
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, j, i1, false);
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, i, 1L, false);
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 47L, i1, false);
              ad.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, filePath: %s base %d", new Object[] { str, Integer.valueOf(k) });
              if ((i1 < 0) || (i1 > 10)) {
                continue;
              }
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, k, 1L, false);
              if (i2 > 0)
              {
                if (n != 2) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 175L, i2, false);
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 176L, 1L, false);
                if (localbxm != null)
                {
                  if (localbxm.GRB != 1) {
                    continue;
                  }
                  com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 184L, i2, false);
                  com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 185L, 1L, false);
                }
              }
            }
          }
        });
        ad.v("MicroMsg.TestCaptureUiEvent", "doStopRecorderAndStartPreviewDone %s", new Object[] { bt.flS().toString() });
        ad.i("MicroMsg.SightCaptureUI", "stop finish, filepath: %s %s time_takevideo %s", new Object[] { SightCaptureUI.p(SightCaptureUI.this).getFilePath(), Long.valueOf(com.tencent.mm.vfs.i.aYo(SightCaptureUI.p(SightCaptureUI.this).getFilePath())), Long.valueOf(l) });
        SightCaptureUI.a(SightCaptureUI.this, SightCaptureUI.p(SightCaptureUI.this).Lb());
        SightCaptureUI.A(SightCaptureUI.this);
        SightCaptureUI.K(SightCaptureUI.this);
        SightCaptureUI.L(SightCaptureUI.this);
        aq.o(SightCaptureUI.M(SightCaptureUI.this), 1000L);
        if ((SightCaptureUI.a(SightCaptureUI.this).scene == 1) || (SightCaptureUI.a(SightCaptureUI.this).scene == 2) || (SightCaptureUI.a(SightCaptureUI.this).scene == 7)) {
          com.tencent.mm.plugin.report.service.g.yhR.f(13819, new Object[] { Integer.valueOf(2), Integer.valueOf(SightCaptureUI.a(SightCaptureUI.this).scene), SightCaptureUI.a(SightCaptureUI.this).vMJ, Long.valueOf(bt.aQJ()) });
        }
        AppMethodBeat.o(94647);
      }
    });
    AppMethodBeat.o(94692);
  }
  
  private void doh()
  {
    AppMethodBeat.i(94693);
    com.tencent.mm.plugin.mmsight.model.a.l.dno();
    if (!com.tencent.mm.plugin.mmsight.model.a.l.cIZ())
    {
      AppMethodBeat.o(94693);
      return;
    }
    TextView localTextView = (TextView)findViewById(2131306323);
    localTextView.setVisibility(8);
    localTextView.setText("");
    AppMethodBeat.o(94693);
  }
  
  private void doi()
  {
    AppMethodBeat.i(94694);
    com.tencent.mm.plugin.mmsight.model.a.l.dno();
    if (!com.tencent.mm.plugin.mmsight.model.a.l.cIZ())
    {
      AppMethodBeat.o(94694);
      return;
    }
    ad.i("MicroMsg.SightCaptureUI", "test for debug " + bt.flS().toString());
    j.ag(new Runnable()
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
  
  private void doj()
  {
    AppMethodBeat.i(94696);
    if (this.juR != null) {
      this.juR.setTextureChangeCallback(null);
    }
    if (this.vWl != null)
    {
      this.vWC = this.vWl.awO();
      this.vWl.dmQ();
      this.vWQ = -1L;
      this.kHE = -1L;
    }
    AppMethodBeat.o(94696);
  }
  
  private void dok()
  {
    AppMethodBeat.i(94697);
    int i = this.kHC;
    if (this.juo != null) {}
    for (Object localObject = this.juo.axU();; localObject = "")
    {
      ad.i("MicroMsg.SightCaptureUI", "switchCameraOnRecord, currentStatus: %s, mediaRecorder.status: %s", new Object[] { Integer.valueOf(i), localObject });
      if ((this.kHC != 2) || (this.juo == null) || (this.juo.axU() != d.c.vPp)) {
        break label406;
      }
      this.juo.pause();
      this.vWl.a(this, this.vWs, false);
      this.vWC = this.vWl.awO();
      if (this.vWx != null) {
        this.vWx.al(this.vWl.getPreviewWidth(), this.vWl.getPreviewHeight(), this.vWl.getOrientation());
      }
      if (this.juo.axU() == d.c.vPx) {
        break;
      }
      ad.e("MicroMsg.SightCaptureUI", "switchCameraOnRecord, recorder status error: %s", new Object[] { this.juo.axU() });
      AppMethodBeat.o(94697);
      return;
    }
    i = this.vWl.getPreviewWidth();
    int j = this.vWl.getPreviewHeight();
    int k = this.vWl.getOrientation();
    localObject = this.juo.axW();
    int m = this.juo.axX();
    ad.i("MicroMsg.SightCaptureUI", "switchCameraOnRecord, newPreviewSize: [%s, %s], oldPreviewSize: [%s], newOrientation: %s, oldOrientation: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localObject, Integer.valueOf(k), Integer.valueOf(m) });
    if ((m != k) || (((Point)localObject).x != i) || (((Point)localObject).y != j)) {
      ad.e("MicroMsg.SightCaptureUI", "error oldOrientation! after switch, size or orientation not match");
    }
    this.juo.s(this.vWl.getPreviewWidth(), this.vWl.getPreviewHeight(), this.vWl.getEncodeVideoBestSize().x, this.vWl.getEncodeVideoBestSize().y);
    this.juo.L(k, this.vWl.getEncodeVideoBestSize().x, this.vWl.getEncodeVideoBestSize().y);
    label406:
    AppMethodBeat.o(94697);
  }
  
  private boolean dol()
  {
    return (this.kHC == 4) || (this.kHC == 3) || (this.kHC == 1) || (this.kHC == 8) || (this.kHC == 9);
  }
  
  private boolean oA(boolean paramBoolean)
  {
    AppMethodBeat.i(94689);
    ad.l("MicroMsg.SightCaptureUI", "createRecorder, surface: %s", new Object[] { this.vWs });
    this.vWS = false;
    if (this.juo != null)
    {
      if (this.vWl != null) {
        this.vWl.b(this.juo.getFrameDataCallback());
      }
      this.juo.cancel();
    }
    if (this.vWl == null)
    {
      AppMethodBeat.o(94689);
      return false;
    }
    this.vWD = new bxm();
    this.vWD.GRA = true;
    this.vWD.GRz = com.tencent.mm.plugin.mmsight.model.k.vOq.vOF;
    if (this.vQe != null) {
      this.vWD.GRB = this.vQe.scene;
    }
    if (!paramBoolean)
    {
      if (this.vWl.a(this.vWs, true) < 0)
      {
        AppMethodBeat.o(94689);
        return false;
      }
    }
    else
    {
      paramBoolean = this.vWl.a(this, this.vWs, true);
      this.vWC = this.vWl.awO();
      if (!paramBoolean)
      {
        AppMethodBeat.o(94689);
        return false;
      }
    }
    if (this.vWl.getEncodeVideoBestSize() == null)
    {
      AppMethodBeat.o(94689);
      return false;
    }
    com.tencent.mm.plugin.mmsight.model.a.l.dno();
    this.juo = com.tencent.mm.plugin.mmsight.model.a.l.q(this.hvh);
    if (this.juo == null)
    {
      ad.e("MicroMsg.SightCaptureUI", "create mediaRecorder error");
      this.vWS = true;
      AppMethodBeat.o(94689);
      return false;
    }
    com.tencent.mm.plugin.mmsight.d.a(this.juo, this.vQe);
    this.juo.a(this);
    this.vWl.a(this.juo.getFrameDataCallback());
    if (this.vWx != null) {
      this.vWx.al(this.vWl.getPreviewWidth(), this.vWl.getPreviewHeight(), this.vWl.getOrientation());
    }
    if ((this.vQe != null) && (this.vQe.scene == 3) && ((this.vQe.mode == 2) || (this.vQe.mode == 0)) && (!bt.isNullOrNil(this.vQe.vMF)) && (!bt.isNullOrNil(this.vQe.vME))) {
      this.juo.yp(this.vQe.vMF + this.vQe.vME);
    }
    this.juo.s(this.vWl.getPreviewWidth(), this.vWl.getPreviewHeight(), this.vWl.getEncodeVideoBestSize().x, this.vWl.getEncodeVideoBestSize().y);
    paramBoolean = this.juo.od(this.vWl.getOrientation());
    ad.i("MicroMsg.SightCaptureUI", "preInit result: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.vWS = true;
    }
    AppMethodBeat.o(94689);
    return paramBoolean;
  }
  
  private void oB(boolean paramBoolean)
  {
    AppMethodBeat.i(94701);
    ad.i("MicroMsg.SightCaptureUI", "[clearPhotoEditCache] isDelete:%s mLastEditPhotoPath:%s mRawEditPhotoPath:%s", new Object[] { Boolean.valueOf(paramBoolean), this.vWY, this.vWX });
    if ((!bt.isNullOrNil(this.vWY)) && (paramBoolean)) {
      com.tencent.mm.vfs.i.deleteFile(this.vWY);
    }
    if (!bt.isNullOrNil(this.vWX)) {
      com.tencent.mm.vfs.i.deleteFile(this.vWX);
    }
    this.vWY = null;
    this.vWX = null;
    ot localot = new ot();
    localot.dCL.dkM = 0;
    com.tencent.mm.sdk.b.a.IbL.l(localot);
    AppMethodBeat.o(94701);
  }
  
  private void stopRecord()
  {
    AppMethodBeat.i(94686);
    ad.m("MicroMsg.SightCaptureUI", "stopRecord, currentStatus: %s", new Object[] { Integer.valueOf(this.kHC) });
    if (this.kHC == 2) {
      dog();
    }
    AppMethodBeat.o(94686);
  }
  
  private void xY(int paramInt)
  {
    AppMethodBeat.i(94700);
    ad.i("MicroMsg.SightCaptureUI", "pre state %s %s update state %s %s", new Object[] { Integer.valueOf(this.kHC), Ku(this.kHC), Integer.valueOf(paramInt), Ku(paramInt) });
    ad.i("MicroMsg.TestCaptureUiEvent", "pre state %s %s update state %s %s %s", new Object[] { Integer.valueOf(this.kHC), Ku(this.kHC), Integer.valueOf(paramInt), Ku(paramInt), bt.flS().toString() });
    if (paramInt == this.kHC)
    {
      AppMethodBeat.o(94700);
      return;
    }
    if (this.vWp == null)
    {
      AppMethodBeat.o(94700);
      return;
    }
    com.tencent.mm.plugin.mmsight.d.aqO("TIME_RECODER_2_PLAY");
    this.kHC = paramInt;
    if (this.kHC != 7) {
      aq.aA(this.vWW);
    }
    if (this.kHC == 0)
    {
      this.vWp.setVisibility(8);
      this.vWr.setVisibility(8);
      this.vWq.setVisibility(8);
      this.vWv.setVisibility(8);
      this.vWu.setVisibility(0);
      if (this.vWO > 1) {
        this.gUP.setVisibility(0);
      }
      if (this.vWl != null) {
        this.vWl.a(f.a.vOa);
      }
      com.tencent.mm.plugin.mmsight.model.b.reset();
      if (this.deh == null) {
        break label1135;
      }
      try
      {
        this.deh.cancel(true);
        this.deh = null;
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
    if ((this.kHC == 1) || (this.kHC == 2))
    {
      this.vWp.setVisibility(0);
      this.vWr.setVisibility(8);
      this.vWq.setVisibility(0);
      this.vWq.setClipChildren(false);
      this.vWn.setVisibility(8);
      this.uCR.setVisibility(8);
      this.vWo.setVisibility(0);
      this.vWm.setVisibility(0);
      this.vRr.setVisibility(8);
      if (this.kHC == 1) {
        this.vWm.reset();
      }
      for (;;)
      {
        this.vWz.setVisibility(8);
        this.vWv.setVisibility(8);
        this.pVu.setVisibility(0);
        if (this.vWO > 1) {
          this.gUP.setVisibility(0);
        }
        this.pVu.bringToFront();
        this.gUP.bringToFront();
        doh();
        doi();
        AppMethodBeat.o(94700);
        return;
        this.vWm.setTouchEnable(true);
        this.vWm.dnP();
      }
    }
    if ((this.kHC == 4) || (this.kHC == 3))
    {
      this.vWp.setVisibility(0);
      this.vWq.setVisibility(8);
      this.vWq.setClipChildren(false);
      this.vWn.setVisibility(0);
      this.uCR.setVisibility(0);
      this.vWo.setVisibility(8);
      this.vWm.setVisibility(8);
      if (this.kHC == 3)
      {
        if (this.vQe.vMK) {
          this.vWr.setVisibility(0);
        }
        this.vWv.setVisibility(0);
        this.vRr.setVisibility(8);
      }
      for (;;)
      {
        this.pVu.setVisibility(8);
        AppMethodBeat.o(94700);
        return;
        this.vWv.setVisibility(8);
        this.vRr.setVisibility(0);
        this.vRr.setForceScaleFullScreen(true);
        ViewGroup.LayoutParams localLayoutParams = this.vRr.getLayoutParams();
        localLayoutParams.width = -1;
        localLayoutParams.height = -1;
        this.vRr.setLayoutParams(localLayoutParams);
        if (this.juo.aol()) {
          this.vWx.amn();
        }
        this.vWu.setVisibility(8);
      }
    }
    if (this.kHC == 6)
    {
      this.vWn.setVisibility(8);
      this.uCR.setVisibility(8);
      this.vWr.setVisibility(8);
      this.vWo.setVisibility(8);
      this.vWm.setVisibility(8);
      AppMethodBeat.o(94700);
      return;
    }
    if (this.kHC == 7)
    {
      this.vWn.setVisibility(8);
      this.uCR.setVisibility(8);
      this.vWo.setVisibility(8);
      this.gUP.setVisibility(8);
      this.vWr.setVisibility(8);
      this.vWm.setTouchEnable(false);
      aq.o(this.vWW, 1500L);
      this.vWm.hideProgress();
      AppMethodBeat.o(94700);
      return;
    }
    if (this.kHC == 8)
    {
      this.vWp.setVisibility(0);
      this.vWq.setVisibility(0);
      this.vWq.setClipChildren(false);
      this.vWn.setVisibility(8);
      this.uCR.setVisibility(8);
      this.vWr.setVisibility(8);
      this.vWo.setVisibility(0);
      if (this.vWO > 1) {
        this.gUP.setVisibility(0);
      }
      this.vWm.setVisibility(0);
      this.pVu.setVisibility(0);
      this.vRr.setVisibility(8);
      this.vWz.setVisibility(8);
      this.vWv.setVisibility(8);
      if (this.vWS) {
        Toast.makeText(this, 2131761236, 1).show();
      }
      for (;;)
      {
        this.vWm.setTouchEnable(false);
        this.vWm.setEnabled(false);
        AppMethodBeat.o(94700);
        return;
        Toast.makeText(this, 2131761241, 1).show();
      }
    }
    if (this.kHC == 9)
    {
      this.vWn.setVisibility(8);
      this.uCR.setVisibility(8);
      this.vWr.setVisibility(8);
      this.vWo.setVisibility(0);
      this.gUP.setVisibility(8);
      this.vWm.reset();
      this.vWm.setTouchEnable(false);
      this.vWm.setEnabled(false);
      Toast.makeText(this, 2131761237, 1).show();
    }
    label1135:
    AppMethodBeat.o(94700);
  }
  
  public final void aVt()
  {
    AppMethodBeat.i(94704);
    ad.i("MicroMsg.SightCaptureUI", "onError: %s", new Object[] { Integer.valueOf(1) });
    try
    {
      if (this.juo != null) {
        this.juo.reset();
      }
      xY(9);
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
  
  public final void nL(int paramInt)
  {
    AppMethodBeat.i(94703);
    if (this.vWO <= 1)
    {
      AppMethodBeat.o(94703);
      return;
    }
    if (this.kHC == 2)
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
    while (this.gUP.getRotation() == f)
    {
      AppMethodBeat.o(94703);
      return;
      f = -90.0F;
      continue;
      f = paramInt;
    }
    this.gUP.animate().rotation(f).setDuration(100L).start();
    AppMethodBeat.o(94703);
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
    } while ((paramInt2 != -1) || (paramIntent == null) || (this.juo == null));
    this.vWZ = true;
    this.vXa = paramIntent.getBundleExtra("report_info");
    this.vWX = paramIntent.getStringExtra("raw_photo_path");
    this.vWY = paramIntent.getStringExtra("after_photo_edit");
    boolean bool = CaptureMMProxy.getInstance().getBoolean(al.a.Ixv, true);
    ad.i("MicroMsg.SightCaptureUI", "rawEditPhotoPath:%s lastEditPhotoPath:%s imageState:%s", new Object[] { this.vWX, this.vWY, Boolean.valueOf(bool) });
    if (!bool)
    {
      paramIntent = CaptureMMProxy.getInstance().getSubCoreImageFullPath("photoEdited_" + System.currentTimeMillis());
      ad.i("MicroMsg.SightCaptureUI", "saveFullPath:%s", new Object[] { paramIntent });
      com.tencent.mm.vfs.i.mz(this.vWY, paramIntent);
      com.tencent.mm.vfs.i.deleteFile(this.vWY);
      com.tencent.mm.sdk.f.b.k(this.vWY, this);
      this.juo.yp(paramIntent);
      this.vWY = paramIntent;
    }
    for (;;)
    {
      paramIntent = new BitmapFactory.Options();
      paramIntent.inJustDecodeBounds = true;
      com.tencent.mm.sdk.platformtools.g.decodeFile(this.vWY, paramIntent);
      ad.i("MicroMsg.SightCaptureUI", "rawW:%s rawH:%s", new Object[] { Integer.valueOf(paramIntent.outWidth), Integer.valueOf(paramIntent.outHeight) });
      paramIntent = com.tencent.mm.sdk.platformtools.g.aK(this.vWY, paramIntent.outHeight, paramIntent.outWidth);
      this.vWv.setVisibility(0);
      this.vWv.setImageBitmap(paramIntent);
      this.vWw.setVisibility(8);
      break;
      this.juo.yp(this.vWY);
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(94702);
    ad.i("MicroMsg.SightCaptureUI", "onBackPressed %d", new Object[] { Integer.valueOf(this.kHC) });
    if ((this.vWB != null) && (this.vWB.onBackPressed()))
    {
      AppMethodBeat.o(94702);
      return;
    }
    if (this.vWB != null)
    {
      this.vWB.release();
      this.vWB = null;
      setSelfNavigationBarVisible(8);
      this.vWn.setVisibility(0);
      this.uCR.setVisibility(0);
      this.vWr.setVisibility(0);
      AppMethodBeat.o(94702);
      return;
    }
    if (dol())
    {
      super.onBackPressed();
      overridePendingTransition(-1, 2130772138);
      oB(true);
    }
    AppMethodBeat.o(94702);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(94684);
    super.onConfigurationChanged(paramConfiguration);
    if ((this.vWT.booleanValue()) && (com.tencent.mm.compatible.util.d.ly(13)))
    {
      paramConfiguration = new Point(paramConfiguration.screenWidthDp, paramConfiguration.screenHeightDp);
      if ((this.vWU == null) || (!this.vWU.equals(paramConfiguration)))
      {
        this.vWU = paramConfiguration;
        dod();
      }
    }
    AppMethodBeat.o(94684);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(94680);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    this.vQe = ((SightParams)getIntent().getParcelableExtra("KEY_SIGHT_PARAMS"));
    if (this.vQe == null)
    {
      ad.e("MicroMsg.SightCaptureUI", "error!!!! sightParams is null!!");
      AppMethodBeat.o(94680);
      return;
    }
    CaptureMMProxy.createProxy(new CaptureMMProxy(this.giA));
    final long l = bt.HI();
    this.giA.connect(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94632);
        ad.i("MicroMsg.SightCaptureUI", "connect cost %sms", new Object[] { Long.valueOf(bt.aO(l)) });
        com.tencent.mm.plugin.mmsight.model.k.d(SightCaptureUI.a(SightCaptureUI.this).hvh);
        SightCaptureUI.b(SightCaptureUI.this);
        AppMethodBeat.o(94632);
      }
    });
    com.tencent.mm.sdk.b.a.IbL.c(this.vWV);
    AppMethodBeat.o(94680);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(94698);
    super.onDestroy();
    ad.i("MicroMsg.SightCaptureUI", "onDestroy");
    this.giA.release();
    if (this.juo != null)
    {
      this.juo.a(null);
      this.juo.D(null);
      this.juo.clear();
    }
    if (this.kHC == -1) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        doj();
        if (this.vRr != null)
        {
          this.vRr.stop();
          this.vRr.setVideoCallback(null);
        }
        if (this.ixy != null) {
          this.ixy.abe();
        }
        if (this.vWB != null)
        {
          this.vWB.release();
          this.vWB = null;
        }
      }
      if (this.gXX != null)
      {
        this.gXX.disable();
        this.gXX.vNC = null;
        this.gXX = null;
      }
      com.tencent.mm.plugin.mmsight.model.a.k.vQc.ayw();
      com.tencent.mm.sdk.b.a.IbL.d(this.vWV);
      AppMethodBeat.o(94698);
      return;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(94681);
    if ((ae.gcE.fYf == 1) && (paramInt == 700) && (this.vWC)) {
      dob();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(94681);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(94682);
    super.onPause();
    ad.i("MicroMsg.SightCaptureUI", "onPause, currentState: %s", new Object[] { Ku(this.kHC) });
    if (this.kHC == 2)
    {
      stopRecord();
      AppMethodBeat.o(94682);
      return;
    }
    if (this.kHC == 1)
    {
      doj();
      AppMethodBeat.o(94682);
      return;
    }
    if ((this.kHC == 4) && (this.vRr != null)) {
      this.vRr.pause();
    }
    AppMethodBeat.o(94682);
  }
  
  public void onResume()
  {
    boolean bool2 = false;
    AppMethodBeat.i(94683);
    super.onResume();
    setSelfNavigationBarVisible(8);
    String str = Ku(this.kHC);
    boolean bool1 = bool2;
    if (this.juR != null)
    {
      bool1 = bool2;
      if (this.juR.isAvailable()) {
        bool1 = true;
      }
    }
    ad.i("MicroMsg.SightCaptureUI", "onResume, currentState: %s, textureview available: %s", new Object[] { str, Boolean.valueOf(bool1) });
    if ((this.kHC == 2) || (this.kHC == 1))
    {
      dod();
      AppMethodBeat.o(94683);
      return;
    }
    if (this.kHC == 4)
    {
      if (this.juR != null)
      {
        if (!this.juR.isAvailable()) {
          break label154;
        }
        this.vWx.amn();
      }
      while (this.vRr != null)
      {
        this.vRr.start();
        AppMethodBeat.o(94683);
        return;
        label154:
        this.juR.setTextureChangeCallback(new com.tencent.mm.plugin.video.b()
        {
          public final void f(SurfaceTexture paramAnonymousSurfaceTexture)
          {
            AppMethodBeat.i(94669);
            SightCaptureUI.e(SightCaptureUI.this).amn();
            SightCaptureUI.f(SightCaptureUI.this).setTextureChangeCallback(null);
            AppMethodBeat.o(94669);
          }
        });
      }
    }
    if (this.kHC == 3)
    {
      if (this.juR != null) {
        this.juR.setTextureChangeCallback(null);
      }
      this.vWx.a(this.vWJ, this.vWN, this.vWK);
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