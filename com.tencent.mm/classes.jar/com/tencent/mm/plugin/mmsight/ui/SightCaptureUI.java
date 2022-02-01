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
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.c;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.f.a.qk;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.f.a;
import com.tencent.mm.plugin.mmsight.model.f.b;
import com.tencent.mm.plugin.mmsight.model.f.c;
import com.tencent.mm.plugin.mmsight.model.o;
import com.tencent.mm.plugin.mmsight.ui.cameraglview.MMSightCameraGLSurfaceView;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.w.a.a;
import com.tencent.mm.plugin.w.a.d;
import com.tencent.mm.plugin.w.a.e;
import com.tencent.mm.plugin.w.a.f;
import com.tencent.mm.plugin.w.a.g;
import com.tencent.mm.plugin.w.a.h;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.k.a;
import com.tencent.mm.pluginsdk.ui.tools.k.e;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class SightCaptureUI
  extends MMActivity
  implements com.tencent.mm.plugin.mmsight.model.a.d.a, com.tencent.mm.plugin.mmsight.model.d.a
{
  private int EYi;
  private SightParams FbJ;
  private k.a FdF;
  private VideoPlayerTextureView Fdy;
  private VideoSeekBarEditorView Fdz;
  private int FhJ;
  private boolean FhK;
  private com.tencent.mm.plugin.mmsight.model.f FhL;
  private MMSightRecordButton FhM;
  private ImageView FhN;
  private ImageView FhO;
  private View FhP;
  private View FhQ;
  private View FhR;
  private ViewGroup FhS;
  private ImageView FhT;
  private SurfaceTexture FhU;
  CameraFrontSightView FhV;
  private ViewGroup FhW;
  private ImageView FhX;
  private MMSightCameraGLSurfaceView FhY;
  private com.tencent.mm.plugin.mmsight.ui.cameraglview.a FhZ;
  private String FiA;
  private boolean FiB;
  private Bundle FiC;
  private Runnable FiD;
  private TextView Fia;
  private View Fib;
  private MMSightTopCountdownCoverView Fic;
  private b Fid;
  private boolean Fie;
  private cuv Fif;
  private byte[] Fig;
  private int Fih;
  private int Fii;
  private int Fij;
  private int Fik;
  private byte[] Fil;
  private int Fim;
  private boolean Fin;
  private boolean Fio;
  private boolean Fip;
  private int Fiq;
  private int Fir;
  private long Fis;
  private boolean Fit;
  private boolean Fiu;
  private Boolean Fiv;
  private Point Fiw;
  private IListener Fix;
  private Runnable Fiy;
  private String Fiz;
  private String fVg;
  private com.tencent.mm.remoteservice.d jGJ;
  private ImageView kES;
  private VideoTransPara lgX;
  private ViewGroup mCC;
  private com.tencent.e.i.d mkC;
  private com.tencent.mm.compatible.util.b mlj;
  private com.tencent.mm.plugin.mmsight.model.a.d nqS;
  private ObservableTextureView nrv;
  private int oLS;
  private boolean oLT;
  private long oLU;
  private com.tencent.mm.plugin.mmsight.model.d orientationEventListener;
  private ViewGroup rpp;
  private MMSightCaptureTouchView uYB;
  
  public SightCaptureUI()
  {
    AppMethodBeat.i(94679);
    this.FhJ = 1;
    this.EYi = 2;
    this.FhK = true;
    this.oLS = -1;
    this.Fie = true;
    this.Fif = new cuv();
    this.jGJ = new com.tencent.mm.remoteservice.d(MMApplicationContext.getContext());
    this.Fin = false;
    this.Fio = false;
    this.Fip = false;
    this.Fiq = 0;
    this.oLT = false;
    this.Fir = 0;
    this.Fis = -1L;
    this.oLU = -1L;
    this.Fit = false;
    this.Fiu = false;
    this.fVg = "";
    this.Fiv = Boolean.FALSE;
    this.Fix = new SightCaptureUI.11(this);
    this.Fiy = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(249780);
        if ((SightCaptureUI.g(SightCaptureUI.this) == 7) && (SightCaptureUI.k(SightCaptureUI.this) != null))
        {
          Log.i("MicroMsg.SightCaptureUI", "showRecoderProgressBar");
          SightCaptureUI.k(SightCaptureUI.this).showLoading();
        }
        AppMethodBeat.o(249780);
      }
    };
    this.FiD = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(248829);
        if (SightCaptureUI.g(SightCaptureUI.this) != 4)
        {
          Log.e("MicroMsg.SightCaptureUI", "checkPreviewStatusRunnable, not previewing now!!!");
          SightCaptureUI.b(SightCaptureUI.this, 9);
        }
        AppMethodBeat.o(248829);
      }
    };
    this.FdF = new k.a()
    {
      public final void eM(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final int fE(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return 0;
      }
      
      public final void onCompletion()
      {
        AppMethodBeat.i(249659);
        SightCaptureUI.U(SightCaptureUI.this).b(0.0D, true);
        AppMethodBeat.o(249659);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(249657);
        Log.e("MicroMsg.SightCaptureUI", "%d on error what %d extra %d", new Object[] { Integer.valueOf(SightCaptureUI.this.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(249657);
      }
      
      public final void qX()
      {
        AppMethodBeat.i(249658);
        if (SightCaptureUI.U(SightCaptureUI.this) != null)
        {
          SightCaptureUI.U(SightCaptureUI.this).start();
          SightCaptureUI.U(SightCaptureUI.this).setLoop(true);
        }
        MMHandlerThread.removeRunnable(SightCaptureUI.P(SightCaptureUI.this));
        SightCaptureUI.U(SightCaptureUI.this).setOneTimeVideoTextureUpdateCallback(new k.e()
        {
          public final void bXh()
          {
            AppMethodBeat.i(249673);
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(249146);
                Log.i("MicroMsg.SightCaptureUI", "onTextureUpdate");
                if (SightCaptureUI.U(SightCaptureUI.this) == null)
                {
                  AppMethodBeat.o(249146);
                  return;
                }
                SightCaptureUI.U(SightCaptureUI.this).setAlpha(1.0F);
                SightCaptureUI.b(SightCaptureUI.this, 4);
                SightCaptureUI.G(SightCaptureUI.this);
                AppMethodBeat.o(249146);
              }
            }, 50L);
            if (SightCaptureUI.a(SightCaptureUI.this).EYq) {
              SightCaptureUI.T(SightCaptureUI.this).setVisibility(0);
            }
            AppMethodBeat.o(249673);
          }
        });
        AppMethodBeat.o(249658);
      }
    };
    AppMethodBeat.o(94679);
  }
  
  private void Fi(int paramInt)
  {
    AppMethodBeat.i(94700);
    Log.i("MicroMsg.SightCaptureUI", "pre state %s %s update state %s %s", new Object[] { Integer.valueOf(this.oLS), Xi(this.oLS), Integer.valueOf(paramInt), Xi(paramInt) });
    Log.i("MicroMsg.TestCaptureUiEvent", "pre state %s %s update state %s %s %s", new Object[] { Integer.valueOf(this.oLS), Xi(this.oLS), Integer.valueOf(paramInt), Xi(paramInt), Util.getStack().toString() });
    if (paramInt == this.oLS)
    {
      AppMethodBeat.o(94700);
      return;
    }
    if (this.rpp == null)
    {
      AppMethodBeat.o(94700);
      return;
    }
    com.tencent.mm.plugin.mmsight.d.aPx("TIME_RECODER_2_PLAY");
    this.oLS = paramInt;
    if (this.oLS != 7) {
      MMHandlerThread.removeRunnable(this.Fiy);
    }
    if (this.oLS == 0)
    {
      this.rpp.setVisibility(8);
      this.FhT.setVisibility(8);
      this.FhS.setVisibility(8);
      this.FhX.setVisibility(8);
      this.FhW.setVisibility(0);
      if (this.Fiq > 1) {
        this.kES.setVisibility(0);
      }
      if (this.FhL != null) {
        this.FhL.a(f.a.EZH);
      }
      com.tencent.mm.plugin.mmsight.model.b.reset();
      if (this.mkC == null) {
        break label1135;
      }
      try
      {
        this.mkC.cancel(true);
        this.mkC = null;
        AppMethodBeat.o(94700);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.SightCaptureUI", localException, "update to state init, interrupt failed: %s", new Object[] { localException.getMessage() });
        }
      }
    }
    if ((this.oLS == 1) || (this.oLS == 2))
    {
      this.rpp.setVisibility(0);
      this.FhT.setVisibility(8);
      this.FhS.setVisibility(0);
      this.FhS.setClipChildren(false);
      this.FhN.setVisibility(8);
      this.FhO.setVisibility(8);
      this.FhR.setVisibility(0);
      this.FhM.setVisibility(0);
      this.Fdy.setVisibility(8);
      if (this.oLS == 1) {
        this.FhM.reset();
      }
      for (;;)
      {
        this.Fib.setVisibility(8);
        this.FhX.setVisibility(8);
        this.uYB.setVisibility(0);
        if (this.Fiq > 1) {
          this.kES.setVisibility(0);
        }
        this.uYB.bringToFront();
        this.kES.bringToFront();
        eUI();
        eUJ();
        AppMethodBeat.o(94700);
        return;
        this.FhM.setTouchEnable(true);
        this.FhM.eUn();
      }
    }
    if ((this.oLS == 4) || (this.oLS == 3))
    {
      this.rpp.setVisibility(0);
      this.FhS.setVisibility(8);
      this.FhS.setClipChildren(false);
      this.FhN.setVisibility(0);
      this.FhO.setVisibility(0);
      this.FhR.setVisibility(8);
      this.FhM.setVisibility(8);
      if (this.oLS == 3)
      {
        if (this.FbJ.EYq) {
          this.FhT.setVisibility(0);
        }
        this.FhX.setVisibility(0);
        this.Fdy.setVisibility(8);
      }
      for (;;)
      {
        this.uYB.setVisibility(8);
        AppMethodBeat.o(94700);
        return;
        this.FhX.setVisibility(8);
        this.Fdy.setVisibility(0);
        this.Fdy.setForceScaleFullScreen(true);
        ViewGroup.LayoutParams localLayoutParams = this.Fdy.getLayoutParams();
        localLayoutParams.width = -1;
        localLayoutParams.height = -1;
        this.Fdy.setLayoutParams(localLayoutParams);
        if (this.nqS.isLandscape()) {
          this.FhZ.aMN();
        }
        this.FhW.setVisibility(8);
      }
    }
    if (this.oLS == 6)
    {
      this.FhN.setVisibility(8);
      this.FhO.setVisibility(8);
      this.FhT.setVisibility(8);
      this.FhR.setVisibility(8);
      this.FhM.setVisibility(8);
      AppMethodBeat.o(94700);
      return;
    }
    if (this.oLS == 7)
    {
      this.FhN.setVisibility(8);
      this.FhO.setVisibility(8);
      this.FhR.setVisibility(8);
      this.kES.setVisibility(8);
      this.FhT.setVisibility(8);
      this.FhM.setTouchEnable(false);
      MMHandlerThread.postToMainThreadDelayed(this.Fiy, 1500L);
      this.FhM.hideProgress();
      AppMethodBeat.o(94700);
      return;
    }
    if (this.oLS == 8)
    {
      this.rpp.setVisibility(0);
      this.FhS.setVisibility(0);
      this.FhS.setClipChildren(false);
      this.FhN.setVisibility(8);
      this.FhO.setVisibility(8);
      this.FhT.setVisibility(8);
      this.FhR.setVisibility(0);
      if (this.Fiq > 1) {
        this.kES.setVisibility(0);
      }
      this.FhM.setVisibility(0);
      this.uYB.setVisibility(0);
      this.Fdy.setVisibility(8);
      this.Fib.setVisibility(8);
      this.FhX.setVisibility(8);
      if (this.Fiu) {
        Toast.makeText(this, a.h.mmsight_capture_codec_init_error, 1).show();
      }
      for (;;)
      {
        this.FhM.setTouchEnable(false);
        this.FhM.setEnabled(false);
        AppMethodBeat.o(94700);
        return;
        Toast.makeText(this, a.h.mmsight_capture_init_error, 1).show();
      }
    }
    if (this.oLS == 9)
    {
      this.FhN.setVisibility(8);
      this.FhO.setVisibility(8);
      this.FhT.setVisibility(8);
      this.FhR.setVisibility(0);
      this.kES.setVisibility(8);
      this.FhM.reset();
      this.FhM.setTouchEnable(false);
      this.FhM.setEnabled(false);
      Toast.makeText(this, a.h.mmsight_capture_finish_error, 1).show();
    }
    label1135:
    AppMethodBeat.o(94700);
  }
  
  private static String Xi(int paramInt)
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
  
  private String bW(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(94695);
    boolean bool1 = CaptureMMProxy.getInstance().getBoolean(ar.a.VnW, true);
    boolean bool2 = CaptureMMProxy.getInstance().getBoolean(ar.a.VnX, true);
    if (paramBoolean) {}
    for (String str = com.tencent.mm.plugin.mmsight.d.getExportImagePath("jpg");; str = com.tencent.mm.plugin.mmsight.d.getExportImagePath("mp4"))
    {
      if (((bool1) && (paramBoolean)) || ((bool2) && (!paramBoolean)))
      {
        Log.i("MicroMsg.SightCaptureUI", "auto save src %s dest %s state %s %s", new Object[] { paramString, str, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        u.on(paramString, str);
        AndroidMediaUtil.refreshMediaScanner(str, this);
      }
      AppMethodBeat.o(94695);
      return str;
    }
  }
  
  private void eUC()
  {
    AppMethodBeat.i(94685);
    if ((this.Fis > 0L) && (Util.ticksToNow(this.Fis) <= 500L))
    {
      Log.i("MicroMsg.SightCaptureUI", "switchCameraClick, switch camera too frequently!!! ignore");
      AppMethodBeat.o(94685);
      return;
    }
    Log.v("MicroMsg.TestCaptureUiEvent", "switchCameraClick %s, currentState: %s", new Object[] { Util.getStack().toString(), Integer.valueOf(this.oLS) });
    eUI();
    this.Fin = true;
    if (this.oLS == 2) {
      if ((this.nqS == null) || (!this.nqS.aZJ())) {
        Log.i("MicroMsg.SightCaptureUI", "switchCameraClick, not write camera data!");
      }
    }
    for (;;)
    {
      eUJ();
      this.Fis = Util.currentTicks();
      AppMethodBeat.o(94685);
      return;
      eUL();
      this.Fio = true;
      continue;
      if (this.oLS == 1)
      {
        Fi(6);
        if (ur(true)) {
          Fi(1);
        }
      }
    }
  }
  
  private void eUD()
  {
    AppMethodBeat.i(94687);
    try
    {
      ViewGroup.LayoutParams localLayoutParams = this.Fdy.getLayoutParams();
      this.rpp.removeView(this.Fdy);
      this.rpp.addView(this.Fdy, 0, localLayoutParams);
      AppMethodBeat.o(94687);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.SightCaptureUI", "clearVideoPlayViewContent, error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94687);
    }
  }
  
  private void eUE()
  {
    AppMethodBeat.i(94688);
    Fi(0);
    this.Fir = 0;
    this.oLT = false;
    this.Fiu = false;
    if (this.Fdy != null)
    {
      this.Fdy.stop();
      this.Fdy.setVideoCallback(null);
      eUD();
    }
    if (this.Fid != null)
    {
      this.Fid.release();
      this.Fid = null;
    }
    if (this.FhY != null) {
      this.FhY.setVisibility(0);
    }
    this.FhX.setImageBitmap(null);
    eUK();
    this.FhL = new com.tencent.mm.plugin.mmsight.model.f(this.lgX, this.FbJ.scene);
    this.FhL.a(this.FhZ.lgb);
    this.Fic.setVisibility(8);
    if (!this.FhL.G(this, this.Fie))
    {
      Fi(8);
      AppMethodBeat.o(94688);
      return;
    }
    if (this.nrv.isAvailable())
    {
      this.FhU = this.nrv.getSurfaceTexture();
      Log.i("MicroMsg.SightCaptureUI", "surface already available, directly set local surface: %s", new Object[] { this.FhU });
      if (ur(false)) {
        Fi(1);
      }
    }
    for (;;)
    {
      if ((this.Fia != null) && (this.FhK))
      {
        this.Fia.setAlpha(1.0F);
        this.Fia.setVisibility(0);
      }
      this.orientationEventListener.reset();
      this.Fin = false;
      this.Fio = false;
      AppMethodBeat.o(94688);
      return;
      Fi(8);
      continue;
      this.nrv.setTextureChangeCallback(new com.tencent.mm.plugin.video.b()
      {
        public final void g(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(249282);
          Log.i("MicroMsg.SightCaptureUI", "callback onSurfaceTextureAvailable set local surface: %s", new Object[] { paramAnonymousSurfaceTexture });
          SightCaptureUI.a(SightCaptureUI.this, paramAnonymousSurfaceTexture);
          if (SightCaptureUI.L(SightCaptureUI.this))
          {
            SightCaptureUI.b(SightCaptureUI.this, 1);
            AppMethodBeat.o(249282);
            return;
          }
          SightCaptureUI.b(SightCaptureUI.this, 8);
          AppMethodBeat.o(249282);
        }
      });
    }
  }
  
  private int eUF()
  {
    AppMethodBeat.i(94690);
    Log.i("MicroMsg.SightCaptureUI", "startRecordImpl");
    int i = this.nqS.b(this.FhL.getOrientation(), this.orientationEventListener.isLandscape(), this.orientationEventListener.getOrientation());
    Log.i("MicroMsg.SightCaptureUI", "startRecordImpl ret: %d", new Object[] { Integer.valueOf(i) });
    if (i >= 0) {
      this.FhL.a(f.a.EZI);
    }
    AppMethodBeat.o(94690);
    return i;
  }
  
  private void eUG()
  {
    AppMethodBeat.i(94691);
    this.Fiu = true;
    Fi(8);
    if (this.nqS != null) {
      try
      {
        this.nqS.cancel();
        this.nqS = null;
        AppMethodBeat.o(94691);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.SightCaptureUI", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(94691);
  }
  
  private void eUH()
  {
    AppMethodBeat.i(94692);
    Fi(7);
    this.FhM.setTouchEnable(false);
    if (this.FbJ.EYr) {
      this.Fic.eUu();
    }
    final int i = this.FhL.getPreviewWidth();
    final int j = this.FhL.getPreviewHeight();
    this.nqS.E(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94651);
        Log.printInfoStack("MicroMsg.SightCaptureUI", "call stop callback now, currentStatus: %s", new Object[] { SightCaptureUI.Xj(SightCaptureUI.g(SightCaptureUI.this)) });
        SightCaptureUI.j(SightCaptureUI.this).a(f.a.EZJ);
        SightCaptureUI.B(SightCaptureUI.this);
        final long l = com.tencent.mm.plugin.mmsight.d.aPy("TIME_RECODER_2_PLAY");
        com.tencent.e.h.ZvG.be(new com.tencent.e.i.h()
        {
          public final String getKey()
          {
            return "BigSightFFMpegRecorder_markAfterCaptureFinish_idkeystat";
          }
          
          public final void run()
          {
            AppMethodBeat.i(249341);
            String str = SightCaptureUI.p(SightCaptureUI.this).getFilePath();
            localcuv = SightCaptureUI.M(SightCaptureUI.this);
            int n = com.tencent.mm.plugin.mmsight.model.j.EZX.jth;
            m = com.tencent.mm.plugin.mmsight.model.j.EZX.laT;
            for (;;)
            {
              try
              {
                if (!Util.isNullOrNil(str))
                {
                  boolean bool = u.agG(str);
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
                com.tencent.mm.plugin.sight.base.b localb;
                Log.e("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish error: %s", new Object[] { localException.getMessage() });
                continue;
                int i = 0;
                continue;
                i = 0;
                continue;
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(440L, 88L, 1L, false);
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(440L, 48L, i1, false);
                i = 90;
                int k = 54;
                int j = 50;
                continue;
                if (com.tencent.mm.plugin.mmsight.model.j.EZX.eTz()) {
                  continue;
                }
                if (m != 1080) {
                  continue;
                }
                continue;
                if ((i1 <= 10) || (i1 > 15)) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(440L, k + 1, 1L, false);
                continue;
                if ((i1 <= 15) || (i1 > 20)) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(440L, k + 2, 1L, false);
                continue;
                if ((i1 <= 20) || (i1 > 30)) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(440L, k + 3, 1L, false);
                continue;
                if (localcuv.TCB != 2) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(440L, 194L, i2, false);
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(440L, 195L, 1L, false);
                continue;
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(440L, 179L, i2, false);
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(440L, 180L, 1L, false);
                if (localcuv == null) {
                  continue;
                }
                if (localcuv.TCB != 1) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(440L, 189L, i2, false);
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(440L, 190L, 1L, false);
                continue;
                if (localcuv.TCB != 2) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(440L, 199L, i2, false);
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(440L, 200L, 1L, false);
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
              com.tencent.mm.plugin.mmsight.model.k.j(false, l);
              AppMethodBeat.o(249341);
              return;
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(440L, 87L, 1L, false);
              localObject = new JSONObject(SightVideoJNI.getSimpleMp4InfoVFS(str));
              i1 = (int)((JSONObject)localObject).getDouble("videoFPS");
              i2 = ((JSONObject)localObject).optInt("videoBitrate");
              Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, videoFPS: %s, videoBitrate: %s, recorderType: %s, resolutionLimit: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(n), Integer.valueOf(m) });
              localObject = com.tencent.mm.plugin.mmsight.model.b.eTa();
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).EYU = com.tencent.mm.plugin.mmsight.model.j.EZX.jth;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).videoBitrate = com.tencent.mm.plugin.mmsight.model.j.EZX.videoBitrate;
              if (!com.tencent.mm.plugin.mmsight.model.j.EZX.lhV) {
                continue;
              }
              i = 1;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).jti = i;
              if (!com.tencent.mm.plugin.mmsight.model.j.EZX.Fak) {
                continue;
              }
              i = 1;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).EYV = i;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).laT = com.tencent.mm.plugin.mmsight.model.j.EZX.laT;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).EYW = i1;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).fileSize = u.bBQ(str);
              localb = com.tencent.mm.plugin.sight.base.f.aYg(str);
              if (localb != null)
              {
                ((com.tencent.mm.plugin.mmsight.model.b)localObject).EYZ = localb.width;
                ((com.tencent.mm.plugin.mmsight.model.b)localObject).EZa = localb.height;
                ((com.tencent.mm.plugin.mmsight.model.b)localObject).EZb = localb.videoBitrate;
                ((com.tencent.mm.plugin.mmsight.model.b)localObject).EYX = localb.videoDuration;
              }
              if (n != 1) {
                continue;
              }
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(440L, 89L, 1L, false);
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(440L, 49L, i1, false);
              i = 93;
              k = 73;
              j = 69;
              continue;
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(440L, j, i1, false);
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(440L, i, 1L, false);
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(440L, 47L, i1, false);
              Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, filePath: %s base %d", new Object[] { str, Integer.valueOf(k) });
              if ((i1 < 0) || (i1 > 10)) {
                continue;
              }
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(440L, k, 1L, false);
              if (i2 > 0)
              {
                if (n != 2) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(440L, 175L, i2, false);
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(440L, 176L, 1L, false);
                if (localcuv != null)
                {
                  if (localcuv.TCB != 1) {
                    continue;
                  }
                  com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(440L, 184L, i2, false);
                  com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(440L, 185L, 1L, false);
                }
              }
            }
          }
        });
        Log.v("MicroMsg.TestCaptureUiEvent", "doStopRecorderAndStartPreviewDone %s", new Object[] { Util.getStack().toString() });
        Log.i("MicroMsg.SightCaptureUI", "stop finish, filepath: %s %s time_takevideo %s", new Object[] { SightCaptureUI.p(SightCaptureUI.this).getFilePath(), Long.valueOf(u.bBQ(SightCaptureUI.p(SightCaptureUI.this).getFilePath())), Long.valueOf(l) });
        SightCaptureUI.a(SightCaptureUI.this, SightCaptureUI.p(SightCaptureUI.this).getMd5());
        SightCaptureUI.A(SightCaptureUI.this);
        SightCaptureUI.N(SightCaptureUI.this);
        SightCaptureUI.O(SightCaptureUI.this);
        MMHandlerThread.postToMainThreadDelayed(SightCaptureUI.P(SightCaptureUI.this), 1000L);
        if ((SightCaptureUI.a(SightCaptureUI.this).scene == 1) || (SightCaptureUI.a(SightCaptureUI.this).scene == 2) || (SightCaptureUI.a(SightCaptureUI.this).scene == 7)) {
          com.tencent.mm.plugin.report.service.h.IzE.a(13819, new Object[] { Integer.valueOf(2), Integer.valueOf(SightCaptureUI.a(SightCaptureUI.this).scene), SightCaptureUI.a(SightCaptureUI.this).AvN, Long.valueOf(Util.nowSecond()) });
        }
        AppMethodBeat.o(94651);
      }
    });
    AppMethodBeat.o(94692);
  }
  
  private void eUI()
  {
    AppMethodBeat.i(94693);
    com.tencent.mm.plugin.mmsight.model.a.k.eTI();
    if (!com.tencent.mm.plugin.mmsight.model.a.k.No())
    {
      AppMethodBeat.o(94693);
      return;
    }
    TextView localTextView = (TextView)findViewById(a.e.video_debug_info);
    localTextView.setVisibility(8);
    localTextView.setText("");
    AppMethodBeat.o(94693);
  }
  
  private void eUJ()
  {
    AppMethodBeat.i(94694);
    com.tencent.mm.plugin.mmsight.model.a.k.eTI();
    if (!com.tencent.mm.plugin.mmsight.model.a.k.No())
    {
      AppMethodBeat.o(94694);
      return;
    }
    Log.i("MicroMsg.SightCaptureUI", "test for debug " + Util.getStack().toString());
    com.tencent.mm.plugin.mmsight.model.i.ap(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(248967);
        SightCaptureUI.Q(SightCaptureUI.this);
        AppMethodBeat.o(248967);
      }
    });
    AppMethodBeat.o(94694);
  }
  
  private void eUK()
  {
    AppMethodBeat.i(94696);
    if (this.nrv != null) {
      this.nrv.setTextureChangeCallback(null);
    }
    if (this.FhL != null)
    {
      this.Fie = this.FhL.aYp();
      this.FhL.eTk();
      this.Fis = -1L;
      this.oLU = -1L;
    }
    AppMethodBeat.o(94696);
  }
  
  private void eUL()
  {
    AppMethodBeat.i(94697);
    int i = this.oLS;
    if (this.nqS != null) {}
    for (Object localObject = this.nqS.aZF();; localObject = "")
    {
      Log.i("MicroMsg.SightCaptureUI", "switchCameraOnRecord, currentStatus: %s, mediaRecorder.status: %s", new Object[] { Integer.valueOf(i), localObject });
      if ((this.oLS != 2) || (this.nqS == null) || (this.nqS.aZF() != d.c.FaT)) {
        break label406;
      }
      this.nqS.pause();
      this.FhL.a(this, this.FhU, false);
      this.Fie = this.FhL.aYp();
      if (this.FhZ != null) {
        this.FhZ.av(this.FhL.getPreviewWidth(), this.FhL.getPreviewHeight(), this.FhL.getOrientation());
      }
      if (this.nqS.aZF() == d.c.Fbb) {
        break;
      }
      Log.e("MicroMsg.SightCaptureUI", "switchCameraOnRecord, recorder status error: %s", new Object[] { this.nqS.aZF() });
      AppMethodBeat.o(94697);
      return;
    }
    i = this.FhL.getPreviewWidth();
    int j = this.FhL.getPreviewHeight();
    int k = this.FhL.getOrientation();
    localObject = this.nqS.aZH();
    int m = this.nqS.aZI();
    Log.i("MicroMsg.SightCaptureUI", "switchCameraOnRecord, newPreviewSize: [%s, %s], oldPreviewSize: [%s], newOrientation: %s, oldOrientation: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localObject, Integer.valueOf(k), Integer.valueOf(m) });
    if ((m != k) || (((Point)localObject).x != i) || (((Point)localObject).y != j)) {
      Log.e("MicroMsg.SightCaptureUI", "error oldOrientation! after switch, size or orientation not match");
    }
    this.nqS.u(this.FhL.getPreviewWidth(), this.FhL.getPreviewHeight(), this.FhL.diO().x, this.FhL.diO().y);
    this.nqS.P(k, this.FhL.diO().x, this.FhL.diO().y);
    label406:
    AppMethodBeat.o(94697);
  }
  
  private boolean eUM()
  {
    return (this.oLS == 4) || (this.oLS == 3) || (this.oLS == 1) || (this.oLS == 8) || (this.oLS == 9);
  }
  
  private void stopRecord()
  {
    AppMethodBeat.i(94686);
    Log.printInfoStack("MicroMsg.SightCaptureUI", "stopRecord, currentStatus: %s", new Object[] { Integer.valueOf(this.oLS) });
    if (this.oLS == 2) {
      eUH();
    }
    AppMethodBeat.o(94686);
  }
  
  private boolean ur(boolean paramBoolean)
  {
    AppMethodBeat.i(94689);
    Log.printDebugStack("MicroMsg.SightCaptureUI", "createRecorder, surface: %s", new Object[] { this.FhU });
    this.Fiu = false;
    if (this.nqS != null)
    {
      if (this.FhL != null) {
        this.FhL.b(this.nqS.getFrameDataCallback());
      }
      this.nqS.cancel();
    }
    if (this.FhL == null)
    {
      AppMethodBeat.o(94689);
      return false;
    }
    this.Fif = new cuv();
    this.Fif.TCA = true;
    this.Fif.TCz = com.tencent.mm.plugin.mmsight.model.j.EZX.Fam;
    if (this.FbJ != null) {
      this.Fif.TCB = this.FbJ.scene;
    }
    if (!paramBoolean)
    {
      if (this.FhL.a(this.FhU, true) < 0)
      {
        AppMethodBeat.o(94689);
        return false;
      }
    }
    else
    {
      paramBoolean = this.FhL.a(this, this.FhU, true);
      this.Fie = this.FhL.aYp();
      if (!paramBoolean)
      {
        AppMethodBeat.o(94689);
        return false;
      }
    }
    if (this.FhL.diO() == null)
    {
      AppMethodBeat.o(94689);
      return false;
    }
    com.tencent.mm.plugin.mmsight.model.a.k.eTI();
    this.nqS = com.tencent.mm.plugin.mmsight.model.a.k.q(this.lgX);
    if (this.nqS == null)
    {
      Log.e("MicroMsg.SightCaptureUI", "create mediaRecorder error");
      this.Fiu = true;
      AppMethodBeat.o(94689);
      return false;
    }
    com.tencent.mm.plugin.mmsight.d.a(this.nqS, this.FbJ);
    this.nqS.a(this);
    this.FhL.a(this.nqS.getFrameDataCallback());
    if (this.FhZ != null) {
      this.FhZ.av(this.FhL.getPreviewWidth(), this.FhL.getPreviewHeight(), this.FhL.getOrientation());
    }
    if ((this.FbJ != null) && (this.FbJ.scene == 3) && ((this.FbJ.mode == 2) || (this.FbJ.mode == 0)) && (!Util.isNullOrNil(this.FbJ.EYm)) && (!Util.isNullOrNil(this.FbJ.EYl))) {
      this.nqS.OO(this.FbJ.EYm + this.FbJ.EYl);
    }
    this.nqS.u(this.FhL.getPreviewWidth(), this.FhL.getPreviewHeight(), this.FhL.diO().x, this.FhL.diO().y);
    paramBoolean = this.nqS.uw(this.FhL.getOrientation());
    Log.i("MicroMsg.SightCaptureUI", "preInit result: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.Fiu = true;
    }
    AppMethodBeat.o(94689);
    return paramBoolean;
  }
  
  private void us(boolean paramBoolean)
  {
    AppMethodBeat.i(94701);
    Log.i("MicroMsg.SightCaptureUI", "[clearPhotoEditCache] isDelete:%s mLastEditPhotoPath:%s mRawEditPhotoPath:%s", new Object[] { Boolean.valueOf(paramBoolean), this.FiA, this.Fiz });
    if ((!Util.isNullOrNil(this.FiA)) && (paramBoolean)) {
      u.deleteFile(this.FiA);
    }
    if (!Util.isNullOrNil(this.Fiz)) {
      u.deleteFile(this.Fiz);
    }
    this.FiA = null;
    this.Fiz = null;
    qk localqk = new qk();
    localqk.fPh.fvK = 0;
    EventCenter.instance.publish(localqk);
    AppMethodBeat.o(94701);
  }
  
  public final void bBE()
  {
    AppMethodBeat.i(94704);
    Log.i("MicroMsg.SightCaptureUI", "onError: %s", new Object[] { Integer.valueOf(1) });
    try
    {
      if (this.nqS != null) {
        this.nqS.reset();
      }
      Fi(9);
      AppMethodBeat.o(94704);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SightCaptureUI", "onError, reset mediaRecorder error: %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.f.big_sight_capture_ui;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(94699);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null)
    {
      bool = true;
      Log.i("MicroMsg.SightCaptureUI", "[onActivityResult] requestCode:%s  resultCode:%s data is null?:", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
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
      Log.i("MicroMsg.SightCaptureUI", "[handlePhotoEditResult] resultCode:%s", new Object[] { Integer.valueOf(paramInt2) });
    } while ((paramInt2 != -1) || (paramIntent == null) || (this.nqS == null));
    this.FiB = true;
    this.FiC = paramIntent.getBundleExtra("report_info");
    this.Fiz = paramIntent.getStringExtra("raw_photo_path");
    this.FiA = paramIntent.getStringExtra("after_photo_edit");
    boolean bool = CaptureMMProxy.getInstance().getBoolean(ar.a.VnW, true);
    Log.i("MicroMsg.SightCaptureUI", "rawEditPhotoPath:%s lastEditPhotoPath:%s imageState:%s", new Object[] { this.Fiz, this.FiA, Boolean.valueOf(bool) });
    if (!bool)
    {
      paramIntent = u.n("wcf://temp/photoEdited_" + System.currentTimeMillis(), true);
      Log.i("MicroMsg.SightCaptureUI", "saveFullPath:%s", new Object[] { paramIntent });
      u.on(this.FiA, paramIntent);
      u.deleteFile(this.FiA);
      AndroidMediaUtil.refreshMediaScanner(this.FiA, this);
      this.nqS.OO(paramIntent);
      this.FiA = paramIntent;
    }
    for (;;)
    {
      paramIntent = new BitmapFactory.Options();
      paramIntent.inJustDecodeBounds = true;
      BitmapUtil.decodeFile(this.FiA, paramIntent);
      Log.i("MicroMsg.SightCaptureUI", "rawW:%s rawH:%s", new Object[] { Integer.valueOf(paramIntent.outWidth), Integer.valueOf(paramIntent.outHeight) });
      paramIntent = BitmapUtil.createThumbBitmap(this.FiA, paramIntent.outHeight, paramIntent.outWidth, true, false);
      this.FhX.setVisibility(0);
      this.FhX.setImageBitmap(paramIntent);
      this.FhY.setVisibility(8);
      break;
      this.nqS.OO(this.FiA);
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(94702);
    Log.i("MicroMsg.SightCaptureUI", "onBackPressed %d", new Object[] { Integer.valueOf(this.oLS) });
    if ((this.Fid != null) && (this.Fid.onBackPressed()))
    {
      AppMethodBeat.o(94702);
      return;
    }
    if (this.Fid != null)
    {
      this.Fid.release();
      this.Fid = null;
      setSelfNavigationBarVisible(8);
      this.FhN.setVisibility(0);
      this.FhO.setVisibility(0);
      this.FhT.setVisibility(0);
      AppMethodBeat.o(94702);
      return;
    }
    if (eUM())
    {
      super.onBackPressed();
      overridePendingTransition(-1, a.a.sight_slide_bottom_out);
      us(true);
    }
    AppMethodBeat.o(94702);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(94684);
    super.onConfigurationChanged(paramConfiguration);
    if ((this.Fiv.booleanValue()) && (com.tencent.mm.compatible.util.d.qV(13)))
    {
      paramConfiguration = new Point(paramConfiguration.screenWidthDp, paramConfiguration.screenHeightDp);
      if ((this.Fiw == null) || (!this.Fiw.equals(paramConfiguration)))
      {
        this.Fiw = paramConfiguration;
        eUE();
      }
    }
    AppMethodBeat.o(94684);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(94680);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    this.FbJ = ((SightParams)getIntent().getParcelableExtra("KEY_SIGHT_PARAMS"));
    if (this.FbJ == null)
    {
      Log.e("MicroMsg.SightCaptureUI", "error!!!! sightParams is null!!");
      AppMethodBeat.o(94680);
      return;
    }
    CaptureMMProxy.createProxy(new CaptureMMProxy(this.jGJ));
    final long l = Util.currentTicks();
    this.jGJ.connect(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94632);
        Log.i("MicroMsg.SightCaptureUI", "connect cost %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
        com.tencent.mm.plugin.mmsight.model.j.d(SightCaptureUI.a(SightCaptureUI.this).lgX);
        SightCaptureUI.b(SightCaptureUI.this);
        AppMethodBeat.o(94632);
      }
    });
    EventCenter.instance.addListener(this.Fix);
    AppMethodBeat.o(94680);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(94698);
    super.onDestroy();
    Log.i("MicroMsg.SightCaptureUI", "onDestroy");
    this.jGJ.release();
    if (this.nqS != null)
    {
      this.nqS.a(null);
      this.nqS.E(null);
      this.nqS.clear();
    }
    if (this.oLS == -1) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        eUK();
        if (this.Fdy != null)
        {
          this.Fdy.stop();
          this.Fdy.setVideoCallback(null);
        }
        if (this.mlj != null) {
          this.mlj.avz();
        }
        if (this.Fid != null)
        {
          this.Fid.release();
          this.Fid = null;
        }
      }
      if (this.orientationEventListener != null)
      {
        this.orientationEventListener.disable();
        this.orientationEventListener.EZi = null;
        this.orientationEventListener = null;
      }
      com.tencent.mm.plugin.mmsight.model.a.j.FbH.baL();
      EventCenter.instance.removeListener(this.Fix);
      AppMethodBeat.o(94698);
      return;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(94681);
    if ((af.juH.jpM == 1) && (paramInt == 700) && (this.Fie)) {
      eUC();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(94681);
    return bool;
  }
  
  public void onOrientationChange(int paramInt)
  {
    AppMethodBeat.i(94703);
    if (this.Fiq <= 1)
    {
      AppMethodBeat.o(94703);
      return;
    }
    if (this.oLS == 2)
    {
      AppMethodBeat.o(94703);
      return;
    }
    Log.i("MicroMsg.SightCaptureUI", "onOrientationChange: %s", new Object[] { Integer.valueOf(paramInt) });
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
    while (this.kES.getRotation() == f)
    {
      AppMethodBeat.o(94703);
      return;
      f = -90.0F;
      continue;
      f = paramInt;
    }
    this.kES.animate().rotation(f).setDuration(100L).start();
    AppMethodBeat.o(94703);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(94682);
    super.onPause();
    Log.i("MicroMsg.SightCaptureUI", "onPause, currentState: %s", new Object[] { Xi(this.oLS) });
    if (this.oLS == 2)
    {
      stopRecord();
      AppMethodBeat.o(94682);
      return;
    }
    if (this.oLS == 1)
    {
      eUK();
      AppMethodBeat.o(94682);
      return;
    }
    if ((this.oLS == 4) && (this.Fdy != null)) {
      this.Fdy.pause();
    }
    AppMethodBeat.o(94682);
  }
  
  public void onResume()
  {
    boolean bool2 = false;
    AppMethodBeat.i(94683);
    super.onResume();
    setSelfNavigationBarVisible(8);
    String str = Xi(this.oLS);
    boolean bool1 = bool2;
    if (this.nrv != null)
    {
      bool1 = bool2;
      if (this.nrv.isAvailable()) {
        bool1 = true;
      }
    }
    Log.i("MicroMsg.SightCaptureUI", "onResume, currentState: %s, textureview available: %s", new Object[] { str, Boolean.valueOf(bool1) });
    if ((this.oLS == 2) || (this.oLS == 1))
    {
      eUE();
      AppMethodBeat.o(94683);
      return;
    }
    if (this.oLS == 4)
    {
      if (this.nrv != null)
      {
        if (!this.nrv.isAvailable()) {
          break label154;
        }
        this.FhZ.aMN();
      }
      while (this.Fdy != null)
      {
        this.Fdy.start();
        AppMethodBeat.o(94683);
        return;
        label154:
        this.nrv.setTextureChangeCallback(new com.tencent.mm.plugin.video.b()
        {
          public final void g(SurfaceTexture paramAnonymousSurfaceTexture)
          {
            AppMethodBeat.i(94669);
            SightCaptureUI.e(SightCaptureUI.this).aMN();
            SightCaptureUI.f(SightCaptureUI.this).setTextureChangeCallback(null);
            AppMethodBeat.o(94669);
          }
        });
      }
    }
    if (this.oLS == 3)
    {
      if (this.nrv != null) {
        this.nrv.setTextureChangeCallback(null);
      }
      this.FhZ.a(this.Fil, this.Fip, this.Fim);
    }
    AppMethodBeat.o(94683);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI
 * JD-Core Version:    0.7.0.1
 */