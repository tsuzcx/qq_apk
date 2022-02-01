package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
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
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ml;
import com.tencent.mm.autogen.a.rx;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.m;
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
import com.tencent.mm.pluginsdk.ui.tools.i.a;
import com.tencent.mm.pluginsdk.ui.tools.i.e;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.y;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class SightCaptureUI
  extends MMActivity
  implements com.tencent.mm.plugin.mmsight.model.a.d.a, com.tencent.mm.plugin.mmsight.model.d.a
{
  private IListener Hnz;
  private int KTU;
  private SightParams KXs;
  private VideoPlayerTextureView KZh;
  private VideoSeekBarEditorView KZi;
  private i.a KZo;
  private View LdA;
  private MMSightTopCountdownCoverView LdB;
  private b LdC;
  private boolean LdD;
  private dmb LdE;
  private byte[] LdF;
  private int LdG;
  private int LdH;
  private int LdI;
  private int LdJ;
  private byte[] LdK;
  private int LdL;
  private boolean LdM;
  private boolean LdN;
  private boolean LdO;
  private int LdP;
  private int LdQ;
  private long LdR;
  private boolean LdS;
  private boolean LdT;
  private Boolean LdU;
  private Point LdV;
  private Runnable LdW;
  private String LdX;
  private String LdY;
  private boolean LdZ;
  private int Ldi;
  private boolean Ldj;
  private com.tencent.mm.plugin.mmsight.model.f Ldk;
  private MMSightRecordButton Ldl;
  private ImageView Ldm;
  private ImageView Ldn;
  private View Ldo;
  private View Ldp;
  private View Ldq;
  private ViewGroup Ldr;
  private ImageView Lds;
  private SurfaceTexture Ldt;
  CameraFrontSightView Ldu;
  private ViewGroup Ldv;
  private ImageView Ldw;
  private MMSightCameraGLSurfaceView Ldx;
  private com.tencent.mm.plugin.mmsight.ui.cameraglview.a Ldy;
  private TextView Ldz;
  private Bundle Lea;
  private Runnable Leb;
  private String ibd;
  private VideoTransPara nLH;
  private ImageView nhZ;
  private com.tencent.mm.plugin.mmsight.model.d orientationEventListener;
  private com.tencent.mm.compatible.util.b peV;
  private com.tencent.threadpool.i.d pen;
  private com.tencent.mm.remoteservice.d pfZ;
  private ViewGroup pzj;
  private com.tencent.mm.plugin.mmsight.model.a.d qpz;
  private ObservableTextureView qqc;
  private int rPN;
  private boolean rPO;
  private long rPP;
  private ViewGroup uzB;
  private MMSightCaptureTouchView ykM;
  
  public SightCaptureUI()
  {
    AppMethodBeat.i(94679);
    this.Ldi = 1;
    this.KTU = 2;
    this.Ldj = true;
    this.rPN = -1;
    this.LdD = true;
    this.LdE = new dmb();
    this.pfZ = new com.tencent.mm.remoteservice.d(MMApplicationContext.getContext());
    this.LdM = false;
    this.LdN = false;
    this.LdO = false;
    this.LdP = 0;
    this.rPO = false;
    this.LdQ = 0;
    this.LdR = -1L;
    this.rPP = -1L;
    this.LdS = false;
    this.LdT = false;
    this.ibd = "";
    this.LdU = Boolean.FALSE;
    this.Hnz = new IListener(com.tencent.mm.app.f.hfK) {};
    this.LdW = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(303634);
        if ((SightCaptureUI.g(SightCaptureUI.this) == 7) && (SightCaptureUI.k(SightCaptureUI.this) != null))
        {
          Log.i("MicroMsg.SightCaptureUI", "showRecoderProgressBar");
          SightCaptureUI.k(SightCaptureUI.this).showLoading();
        }
        AppMethodBeat.o(303634);
      }
    };
    this.Leb = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(303647);
        if (SightCaptureUI.g(SightCaptureUI.this) != 4)
        {
          Log.e("MicroMsg.SightCaptureUI", "checkPreviewStatusRunnable, not previewing now!!!");
          SightCaptureUI.b(SightCaptureUI.this, 9);
        }
        AppMethodBeat.o(303647);
      }
    };
    this.KZo = new i.a()
    {
      public final void Qz()
      {
        AppMethodBeat.i(303639);
        if (SightCaptureUI.U(SightCaptureUI.this) != null)
        {
          SightCaptureUI.U(SightCaptureUI.this).start();
          SightCaptureUI.U(SightCaptureUI.this).setLoop(true);
        }
        MMHandlerThread.removeRunnable(SightCaptureUI.P(SightCaptureUI.this));
        SightCaptureUI.U(SightCaptureUI.this).setOneTimeVideoTextureUpdateCallback(new i.e()
        {
          public final void onTextureUpdate()
          {
            AppMethodBeat.i(303605);
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(303607);
                Log.i("MicroMsg.SightCaptureUI", "onTextureUpdate");
                if (SightCaptureUI.U(SightCaptureUI.this) == null)
                {
                  AppMethodBeat.o(303607);
                  return;
                }
                SightCaptureUI.U(SightCaptureUI.this).setAlpha(1.0F);
                SightCaptureUI.b(SightCaptureUI.this, 4);
                SightCaptureUI.G(SightCaptureUI.this);
                AppMethodBeat.o(303607);
              }
            }, 50L);
            if (SightCaptureUI.a(SightCaptureUI.this).KUc) {
              SightCaptureUI.T(SightCaptureUI.this).setVisibility(0);
            }
            AppMethodBeat.o(303605);
          }
        });
        AppMethodBeat.o(303639);
      }
      
      public final void fG(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final int gw(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return 0;
      }
      
      public final void onCompletion()
      {
        AppMethodBeat.i(303640);
        SightCaptureUI.U(SightCaptureUI.this).c(0.0D, true);
        AppMethodBeat.o(303640);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(303637);
        Log.e("MicroMsg.SightCaptureUI", "%d on error what %d extra %d", new Object[] { Integer.valueOf(SightCaptureUI.this.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(303637);
      }
    };
    AppMethodBeat.o(94679);
  }
  
  private void FJ(int paramInt)
  {
    AppMethodBeat.i(94700);
    Log.i("MicroMsg.SightCaptureUI", "pre state %s %s update state %s %s", new Object[] { Integer.valueOf(this.rPN), abk(this.rPN), Integer.valueOf(paramInt), abk(paramInt) });
    Log.i("MicroMsg.TestCaptureUiEvent", "pre state %s %s update state %s %s %s", new Object[] { Integer.valueOf(this.rPN), abk(this.rPN), Integer.valueOf(paramInt), abk(paramInt), Util.getStack().toString() });
    if (paramInt == this.rPN)
    {
      AppMethodBeat.o(94700);
      return;
    }
    if (this.uzB == null)
    {
      AppMethodBeat.o(94700);
      return;
    }
    com.tencent.mm.plugin.mmsight.d.aMv("TIME_RECODER_2_PLAY");
    this.rPN = paramInt;
    if (this.rPN != 7) {
      MMHandlerThread.removeRunnable(this.LdW);
    }
    if (this.rPN == 0)
    {
      this.uzB.setVisibility(8);
      this.Lds.setVisibility(8);
      this.Ldr.setVisibility(8);
      this.Ldw.setVisibility(8);
      this.Ldv.setVisibility(0);
      if (this.LdP > 1) {
        this.nhZ.setVisibility(0);
      }
      if (this.Ldk != null) {
        this.Ldk.a(f.a.KVt);
      }
      com.tencent.mm.plugin.mmsight.model.b.reset();
      if (this.pen == null) {
        break label1135;
      }
      try
      {
        this.pen.cancel(true);
        this.pen = null;
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
    if ((this.rPN == 1) || (this.rPN == 2))
    {
      this.uzB.setVisibility(0);
      this.Lds.setVisibility(8);
      this.Ldr.setVisibility(0);
      this.Ldr.setClipChildren(false);
      this.Ldm.setVisibility(8);
      this.Ldn.setVisibility(8);
      this.Ldq.setVisibility(0);
      this.Ldl.setVisibility(0);
      this.KZh.setVisibility(8);
      if (this.rPN == 1) {
        this.Ldl.reset();
      }
      for (;;)
      {
        this.LdA.setVisibility(8);
        this.Ldw.setVisibility(8);
        this.ykM.setVisibility(0);
        if (this.LdP > 1) {
          this.nhZ.setVisibility(0);
        }
        this.ykM.bringToFront();
        this.nhZ.bringToFront();
        gdu();
        gdv();
        AppMethodBeat.o(94700);
        return;
        this.Ldl.setTouchEnable(true);
        this.Ldl.gdb();
      }
    }
    if ((this.rPN == 4) || (this.rPN == 3))
    {
      this.uzB.setVisibility(0);
      this.Ldr.setVisibility(8);
      this.Ldr.setClipChildren(false);
      this.Ldm.setVisibility(0);
      this.Ldn.setVisibility(0);
      this.Ldq.setVisibility(8);
      this.Ldl.setVisibility(8);
      if (this.rPN == 3)
      {
        if (this.KXs.KUc) {
          this.Lds.setVisibility(0);
        }
        this.Ldw.setVisibility(0);
        this.KZh.setVisibility(8);
      }
      for (;;)
      {
        this.ykM.setVisibility(8);
        AppMethodBeat.o(94700);
        return;
        this.Ldw.setVisibility(8);
        this.KZh.setVisibility(0);
        this.KZh.setForceScaleFullScreen(true);
        ViewGroup.LayoutParams localLayoutParams = this.KZh.getLayoutParams();
        localLayoutParams.width = -1;
        localLayoutParams.height = -1;
        this.KZh.setLayoutParams(localLayoutParams);
        if (this.qpz.isLandscape()) {
          this.Ldy.bgx();
        }
        this.Ldv.setVisibility(8);
      }
    }
    if (this.rPN == 6)
    {
      this.Ldm.setVisibility(8);
      this.Ldn.setVisibility(8);
      this.Lds.setVisibility(8);
      this.Ldq.setVisibility(8);
      this.Ldl.setVisibility(8);
      AppMethodBeat.o(94700);
      return;
    }
    if (this.rPN == 7)
    {
      this.Ldm.setVisibility(8);
      this.Ldn.setVisibility(8);
      this.Ldq.setVisibility(8);
      this.nhZ.setVisibility(8);
      this.Lds.setVisibility(8);
      this.Ldl.setTouchEnable(false);
      MMHandlerThread.postToMainThreadDelayed(this.LdW, 1500L);
      this.Ldl.hideProgress();
      AppMethodBeat.o(94700);
      return;
    }
    if (this.rPN == 8)
    {
      this.uzB.setVisibility(0);
      this.Ldr.setVisibility(0);
      this.Ldr.setClipChildren(false);
      this.Ldm.setVisibility(8);
      this.Ldn.setVisibility(8);
      this.Lds.setVisibility(8);
      this.Ldq.setVisibility(0);
      if (this.LdP > 1) {
        this.nhZ.setVisibility(0);
      }
      this.Ldl.setVisibility(0);
      this.ykM.setVisibility(0);
      this.KZh.setVisibility(8);
      this.LdA.setVisibility(8);
      this.Ldw.setVisibility(8);
      if (this.LdT) {
        Toast.makeText(this, a.h.mmsight_capture_codec_init_error, 1).show();
      }
      for (;;)
      {
        this.Ldl.setTouchEnable(false);
        this.Ldl.setEnabled(false);
        AppMethodBeat.o(94700);
        return;
        Toast.makeText(this, a.h.mmsight_capture_init_error, 1).show();
      }
    }
    if (this.rPN == 9)
    {
      this.Ldm.setVisibility(8);
      this.Ldn.setVisibility(8);
      this.Lds.setVisibility(8);
      this.Ldq.setVisibility(0);
      this.nhZ.setVisibility(8);
      this.Ldl.reset();
      this.Ldl.setTouchEnable(false);
      this.Ldl.setEnabled(false);
      Toast.makeText(this, a.h.mmsight_capture_finish_error, 1).show();
    }
    label1135:
    AppMethodBeat.o(94700);
  }
  
  private static String abk(int paramInt)
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
  
  private String cs(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(94695);
    boolean bool1 = CaptureMMProxy.getInstance().getBoolean(at.a.acPr, true);
    boolean bool2 = CaptureMMProxy.getInstance().getBoolean(at.a.acPs, true);
    if (paramBoolean) {}
    for (String str = com.tencent.mm.plugin.mmsight.d.getExportImagePath("jpg");; str = com.tencent.mm.plugin.mmsight.d.getExportImagePath("mp4"))
    {
      if (((bool1) && (paramBoolean)) || ((bool2) && (!paramBoolean)))
      {
        Log.i("MicroMsg.SightCaptureUI", "auto save src %s dest %s state %s %s", new Object[] { paramString, str, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        y.O(paramString, str, false);
        AndroidMediaUtil.refreshMediaScanner(str, this);
      }
      AppMethodBeat.o(94695);
      return str;
    }
  }
  
  private void gdo()
  {
    AppMethodBeat.i(94685);
    if ((this.LdR > 0L) && (Util.ticksToNow(this.LdR) <= 500L))
    {
      Log.i("MicroMsg.SightCaptureUI", "switchCameraClick, switch camera too frequently!!! ignore");
      AppMethodBeat.o(94685);
      return;
    }
    Log.v("MicroMsg.TestCaptureUiEvent", "switchCameraClick %s, currentState: %s", new Object[] { Util.getStack().toString(), Integer.valueOf(this.rPN) });
    gdu();
    this.LdM = true;
    if (this.rPN == 2) {
      if ((this.qpz == null) || (!this.qpz.buH())) {
        Log.i("MicroMsg.SightCaptureUI", "switchCameraClick, not write camera data!");
      }
    }
    for (;;)
    {
      gdv();
      this.LdR = Util.currentTicks();
      AppMethodBeat.o(94685);
      return;
      gdx();
      this.LdN = true;
      continue;
      if (this.rPN == 1)
      {
        FJ(6);
        if (yE(true)) {
          FJ(1);
        }
      }
    }
  }
  
  private void gdp()
  {
    AppMethodBeat.i(94687);
    try
    {
      ViewGroup.LayoutParams localLayoutParams = this.KZh.getLayoutParams();
      this.uzB.removeView(this.KZh);
      this.uzB.addView(this.KZh, 0, localLayoutParams);
      AppMethodBeat.o(94687);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.SightCaptureUI", "clearVideoPlayViewContent, error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94687);
    }
  }
  
  private void gdq()
  {
    AppMethodBeat.i(94688);
    FJ(0);
    this.LdQ = 0;
    this.rPO = false;
    this.LdT = false;
    if (this.KZh != null)
    {
      this.KZh.stop();
      this.KZh.setVideoCallback(null);
      gdp();
    }
    if (this.LdC != null)
    {
      this.LdC.release();
      this.LdC = null;
    }
    if (this.Ldx != null) {
      this.Ldx.setVisibility(0);
    }
    this.Ldw.setImageBitmap(null);
    gdw();
    this.Ldk = new com.tencent.mm.plugin.mmsight.model.f(this.nLH, this.KXs.scene);
    this.Ldk.a(this.Ldy.nKM);
    this.LdB.setVisibility(8);
    if (!this.Ldk.N(this, this.LdD))
    {
      FJ(8);
      AppMethodBeat.o(94688);
      return;
    }
    if (this.qqc.isAvailable())
    {
      this.Ldt = this.qqc.getSurfaceTexture();
      Log.i("MicroMsg.SightCaptureUI", "surface already available, directly set local surface: %s", new Object[] { this.Ldt });
      if (yE(false)) {
        FJ(1);
      }
    }
    for (;;)
    {
      if ((this.Ldz != null) && (this.Ldj))
      {
        this.Ldz.setAlpha(1.0F);
        this.Ldz.setVisibility(0);
      }
      this.orientationEventListener.reset();
      this.LdM = false;
      this.LdN = false;
      AppMethodBeat.o(94688);
      return;
      FJ(8);
      continue;
      this.qqc.setTextureChangeCallback(new com.tencent.mm.plugin.video.b()
      {
        public final void h(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(303600);
          Log.i("MicroMsg.SightCaptureUI", "callback onSurfaceTextureAvailable set local surface: %s", new Object[] { paramAnonymousSurfaceTexture });
          SightCaptureUI.a(SightCaptureUI.this, paramAnonymousSurfaceTexture);
          if (SightCaptureUI.L(SightCaptureUI.this))
          {
            SightCaptureUI.b(SightCaptureUI.this, 1);
            AppMethodBeat.o(303600);
            return;
          }
          SightCaptureUI.b(SightCaptureUI.this, 8);
          AppMethodBeat.o(303600);
        }
      });
    }
  }
  
  private int gdr()
  {
    AppMethodBeat.i(94690);
    Log.i("MicroMsg.SightCaptureUI", "startRecordImpl");
    int i = this.qpz.b(this.Ldk.getOrientation(), this.orientationEventListener.isLandscape(), this.orientationEventListener.getOrientation());
    Log.i("MicroMsg.SightCaptureUI", "startRecordImpl ret: %d", new Object[] { Integer.valueOf(i) });
    if (i >= 0) {
      this.Ldk.a(f.a.KVu);
    }
    AppMethodBeat.o(94690);
    return i;
  }
  
  private void gds()
  {
    AppMethodBeat.i(94691);
    this.LdT = true;
    FJ(8);
    if (this.qpz != null) {
      try
      {
        this.qpz.cancel();
        this.qpz = null;
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
  
  private void gdt()
  {
    AppMethodBeat.i(94692);
    FJ(7);
    this.Ldl.setTouchEnable(false);
    if (this.KXs.KUd) {
      this.LdB.gdg();
    }
    final int i = this.Ldk.getPreviewWidth();
    final int j = this.Ldk.getPreviewHeight();
    this.qpz.J(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94651);
        Log.printInfoStack("MicroMsg.SightCaptureUI", "call stop callback now, currentStatus: %s", new Object[] { SightCaptureUI.abl(SightCaptureUI.g(SightCaptureUI.this)) });
        SightCaptureUI.j(SightCaptureUI.this).a(f.a.KVv);
        SightCaptureUI.B(SightCaptureUI.this);
        final long l = com.tencent.mm.plugin.mmsight.d.aMw("TIME_RECODER_2_PLAY");
        com.tencent.threadpool.h.ahAA.bm(new com.tencent.threadpool.i.h()
        {
          public final String getKey()
          {
            return "BigSightFFMpegRecorder_markAfterCaptureFinish_idkeystat";
          }
          
          public final void run()
          {
            AppMethodBeat.i(303627);
            String str = SightCaptureUI.p(SightCaptureUI.this).getFilePath();
            localdmb = SightCaptureUI.M(SightCaptureUI.this);
            int n = com.tencent.mm.plugin.mmsight.model.j.KVJ.lWy;
            m = com.tencent.mm.plugin.mmsight.model.j.KVJ.nFY;
            for (;;)
            {
              try
              {
                if (!Util.isNullOrNil(str))
                {
                  boolean bool = y.ZC(str);
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
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(440L, 88L, 1L, false);
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(440L, 48L, i1, false);
                i = 90;
                int k = 54;
                int j = 50;
                continue;
                if (com.tencent.mm.plugin.mmsight.model.j.KVJ.gcs()) {
                  continue;
                }
                if (m != 1080) {
                  continue;
                }
                continue;
                if ((i1 <= 10) || (i1 > 15)) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(440L, k + 1, 1L, false);
                continue;
                if ((i1 <= 15) || (i1 > 20)) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(440L, k + 2, 1L, false);
                continue;
                if ((i1 <= 20) || (i1 > 30)) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(440L, k + 3, 1L, false);
                continue;
                if (localdmb.aaSh != 2) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(440L, 194L, i2, false);
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(440L, 195L, 1L, false);
                continue;
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(440L, 179L, i2, false);
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(440L, 180L, 1L, false);
                if (localdmb == null) {
                  continue;
                }
                if (localdmb.aaSh != 1) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(440L, 189L, i2, false);
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(440L, 190L, 1L, false);
                continue;
                if (localdmb.aaSh != 2) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(440L, 199L, i2, false);
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(440L, 200L, 1L, false);
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
              com.tencent.mm.plugin.mmsight.model.k.m(false, l);
              AppMethodBeat.o(303627);
              return;
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(440L, 87L, 1L, false);
              localObject = new JSONObject(SightVideoJNI.getSimpleMp4InfoVFS(str));
              i1 = (int)((JSONObject)localObject).getDouble("videoFPS");
              i2 = ((JSONObject)localObject).optInt("videoBitrate");
              Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, videoFPS: %s, videoBitrate: %s, recorderType: %s, resolutionLimit: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(n), Integer.valueOf(m) });
              localObject = com.tencent.mm.plugin.mmsight.model.b.gbT();
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).KUG = com.tencent.mm.plugin.mmsight.model.j.KVJ.lWy;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).videoBitrate = com.tencent.mm.plugin.mmsight.model.j.KVJ.videoBitrate;
              if (!com.tencent.mm.plugin.mmsight.model.j.KVJ.nME) {
                continue;
              }
              i = 1;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).lWz = i;
              if (!com.tencent.mm.plugin.mmsight.model.j.KVJ.KVU) {
                continue;
              }
              i = 1;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).KUH = i;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).nFY = com.tencent.mm.plugin.mmsight.model.j.KVJ.nFY;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).KUI = i1;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).fileSize = y.bEl(str);
              localb = com.tencent.mm.plugin.sight.base.f.aVX(str);
              if (localb != null)
              {
                ((com.tencent.mm.plugin.mmsight.model.b)localObject).KUL = localb.width;
                ((com.tencent.mm.plugin.mmsight.model.b)localObject).KUM = localb.height;
                ((com.tencent.mm.plugin.mmsight.model.b)localObject).KUN = localb.videoBitrate;
                ((com.tencent.mm.plugin.mmsight.model.b)localObject).KUJ = localb.videoDuration;
              }
              if (n != 1) {
                continue;
              }
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(440L, 89L, 1L, false);
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(440L, 49L, i1, false);
              i = 93;
              k = 73;
              j = 69;
              continue;
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(440L, j, i1, false);
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(440L, i, 1L, false);
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(440L, 47L, i1, false);
              Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, filePath: %s base %d", new Object[] { str, Integer.valueOf(k) });
              if ((i1 < 0) || (i1 > 10)) {
                continue;
              }
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(440L, k, 1L, false);
              if (i2 > 0)
              {
                if (n != 2) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(440L, 175L, i2, false);
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(440L, 176L, 1L, false);
                if (localdmb != null)
                {
                  if (localdmb.aaSh != 1) {
                    continue;
                  }
                  com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(440L, 184L, i2, false);
                  com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(440L, 185L, 1L, false);
                }
              }
            }
          }
        });
        Log.v("MicroMsg.TestCaptureUiEvent", "doStopRecorderAndStartPreviewDone %s", new Object[] { Util.getStack().toString() });
        Log.i("MicroMsg.SightCaptureUI", "stop finish, filepath: %s %s time_takevideo %s", new Object[] { SightCaptureUI.p(SightCaptureUI.this).getFilePath(), Long.valueOf(y.bEl(SightCaptureUI.p(SightCaptureUI.this).getFilePath())), Long.valueOf(l) });
        SightCaptureUI.a(SightCaptureUI.this, SightCaptureUI.p(SightCaptureUI.this).getMd5());
        SightCaptureUI.A(SightCaptureUI.this);
        SightCaptureUI.N(SightCaptureUI.this);
        SightCaptureUI.O(SightCaptureUI.this);
        MMHandlerThread.postToMainThreadDelayed(SightCaptureUI.P(SightCaptureUI.this), 1000L);
        if ((SightCaptureUI.a(SightCaptureUI.this).scene == 1) || (SightCaptureUI.a(SightCaptureUI.this).scene == 2) || (SightCaptureUI.a(SightCaptureUI.this).scene == 7)) {
          com.tencent.mm.plugin.report.service.h.OAn.b(13819, new Object[] { Integer.valueOf(2), Integer.valueOf(SightCaptureUI.a(SightCaptureUI.this).scene), SightCaptureUI.a(SightCaptureUI.this).FUP, Long.valueOf(Util.nowSecond()) });
        }
        AppMethodBeat.o(94651);
      }
    });
    AppMethodBeat.o(94692);
  }
  
  private void gdu()
  {
    AppMethodBeat.i(94693);
    com.tencent.mm.plugin.mmsight.model.a.k.gcB();
    if (!com.tencent.mm.plugin.mmsight.model.a.k.anH())
    {
      AppMethodBeat.o(94693);
      return;
    }
    TextView localTextView = (TextView)findViewById(a.e.video_debug_info);
    localTextView.setVisibility(8);
    localTextView.setText("");
    AppMethodBeat.o(94693);
  }
  
  private void gdv()
  {
    AppMethodBeat.i(94694);
    com.tencent.mm.plugin.mmsight.model.a.k.gcB();
    if (!com.tencent.mm.plugin.mmsight.model.a.k.anH())
    {
      AppMethodBeat.o(94694);
      return;
    }
    Log.i("MicroMsg.SightCaptureUI", "test for debug " + Util.getStack().toString());
    com.tencent.mm.plugin.mmsight.model.i.ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(303604);
        SightCaptureUI.Q(SightCaptureUI.this);
        AppMethodBeat.o(303604);
      }
    });
    AppMethodBeat.o(94694);
  }
  
  private void gdw()
  {
    AppMethodBeat.i(94696);
    if (this.qqc != null) {
      this.qqc.setTextureChangeCallback(null);
    }
    if (this.Ldk != null)
    {
      this.LdD = this.Ldk.btn();
      this.Ldk.gcd();
      this.LdR = -1L;
      this.rPP = -1L;
    }
    AppMethodBeat.o(94696);
  }
  
  private void gdx()
  {
    AppMethodBeat.i(94697);
    int i = this.rPN;
    if (this.qpz != null) {}
    for (Object localObject = this.qpz.buD();; localObject = "")
    {
      Log.i("MicroMsg.SightCaptureUI", "switchCameraOnRecord, currentStatus: %s, mediaRecorder.status: %s", new Object[] { Integer.valueOf(i), localObject });
      if ((this.rPN != 2) || (this.qpz == null) || (this.qpz.buD() != d.c.KWC)) {
        break label406;
      }
      this.qpz.pause();
      this.Ldk.a(this, this.Ldt, false);
      this.LdD = this.Ldk.btn();
      if (this.Ldy != null) {
        this.Ldy.aT(this.Ldk.getPreviewWidth(), this.Ldk.getPreviewHeight(), this.Ldk.getOrientation());
      }
      if (this.qpz.buD() == d.c.KWK) {
        break;
      }
      Log.e("MicroMsg.SightCaptureUI", "switchCameraOnRecord, recorder status error: %s", new Object[] { this.qpz.buD() });
      AppMethodBeat.o(94697);
      return;
    }
    i = this.Ldk.getPreviewWidth();
    int j = this.Ldk.getPreviewHeight();
    int k = this.Ldk.getOrientation();
    localObject = this.qpz.buF();
    int m = this.qpz.buG();
    Log.i("MicroMsg.SightCaptureUI", "switchCameraOnRecord, newPreviewSize: [%s, %s], oldPreviewSize: [%s], newOrientation: %s, oldOrientation: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localObject, Integer.valueOf(k), Integer.valueOf(m) });
    if ((m != k) || (((Point)localObject).x != i) || (((Point)localObject).y != j)) {
      Log.e("MicroMsg.SightCaptureUI", "error oldOrientation! after switch, size or orientation not match");
    }
    this.qpz.A(this.Ldk.getPreviewWidth(), this.Ldk.getPreviewHeight(), this.Ldk.dPz().x, this.Ldk.dPz().y);
    this.qpz.ae(k, this.Ldk.dPz().x, this.Ldk.dPz().y);
    label406:
    AppMethodBeat.o(94697);
  }
  
  private boolean gdy()
  {
    return (this.rPN == 4) || (this.rPN == 3) || (this.rPN == 1) || (this.rPN == 8) || (this.rPN == 9);
  }
  
  private void stopRecord()
  {
    AppMethodBeat.i(94686);
    Log.printInfoStack("MicroMsg.SightCaptureUI", "stopRecord, currentStatus: %s", new Object[] { Integer.valueOf(this.rPN) });
    if (this.rPN == 2) {
      gdt();
    }
    AppMethodBeat.o(94686);
  }
  
  private boolean yE(boolean paramBoolean)
  {
    AppMethodBeat.i(94689);
    Log.printDebugStack("MicroMsg.SightCaptureUI", "createRecorder, surface: %s", new Object[] { this.Ldt });
    this.LdT = false;
    if (this.qpz != null)
    {
      if (this.Ldk != null) {
        this.Ldk.b(this.qpz.getFrameDataCallback());
      }
      this.qpz.cancel();
    }
    if (this.Ldk == null)
    {
      AppMethodBeat.o(94689);
      return false;
    }
    this.LdE = new dmb();
    this.LdE.aaSg = true;
    this.LdE.aaSf = com.tencent.mm.plugin.mmsight.model.j.KVJ.KVW;
    if (this.KXs != null) {
      this.LdE.aaSh = this.KXs.scene;
    }
    if (!paramBoolean)
    {
      if (this.Ldk.a(this.Ldt, true) < 0)
      {
        AppMethodBeat.o(94689);
        return false;
      }
    }
    else
    {
      paramBoolean = this.Ldk.a(this, this.Ldt, true);
      this.LdD = this.Ldk.btn();
      if (!paramBoolean)
      {
        AppMethodBeat.o(94689);
        return false;
      }
    }
    if (this.Ldk.dPz() == null)
    {
      AppMethodBeat.o(94689);
      return false;
    }
    com.tencent.mm.plugin.mmsight.model.a.k.gcB();
    this.qpz = com.tencent.mm.plugin.mmsight.model.a.k.q(this.nLH);
    if (this.qpz == null)
    {
      Log.e("MicroMsg.SightCaptureUI", "create mediaRecorder error");
      this.LdT = true;
      AppMethodBeat.o(94689);
      return false;
    }
    com.tencent.mm.plugin.mmsight.d.a(this.qpz, this.KXs);
    this.qpz.a(this);
    this.Ldk.a(this.qpz.getFrameDataCallback());
    if (this.Ldy != null) {
      this.Ldy.aT(this.Ldk.getPreviewWidth(), this.Ldk.getPreviewHeight(), this.Ldk.getOrientation());
    }
    String str1;
    String str2;
    if ((this.KXs != null) && (this.KXs.scene == 3) && ((this.KXs.mode == 2) || (this.KXs.mode == 0)) && (!Util.isNullOrNil(this.KXs.KTY)) && (!Util.isNullOrNil(this.KXs.KTX)))
    {
      str1 = this.KXs.KTY;
      str2 = this.KXs.KTX;
      if ((!new File(str1).isDirectory()) && (!str1.equals(org.apache.commons.b.c.getFullPath(str1)))) {
        break label596;
      }
      if (!Util.isNullOrNil(org.apache.commons.b.c.bKZ(str2))) {
        break label566;
      }
      Log.e("MicroMsg.SightCaptureUI", "picture path is a directory, but can't find extension from file name: %s", new Object[] { str2 });
    }
    for (;;)
    {
      this.qpz.A(this.Ldk.getPreviewWidth(), this.Ldk.getPreviewHeight(), this.Ldk.dPz().x, this.Ldk.dPz().y);
      paramBoolean = this.qpz.uw(this.Ldk.getOrientation());
      Log.i("MicroMsg.SightCaptureUI", "preInit result: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      if (!paramBoolean) {
        this.LdT = true;
      }
      AppMethodBeat.o(94689);
      return paramBoolean;
      label566:
      this.qpz.He(str1 + str2);
      continue;
      label596:
      Log.i("MicroMsg.SightCaptureUI", "picture path with whole file path");
    }
  }
  
  private void yF(boolean paramBoolean)
  {
    AppMethodBeat.i(94701);
    Log.i("MicroMsg.SightCaptureUI", "[clearPhotoEditCache] isDelete:%s mLastEditPhotoPath:%s mRawEditPhotoPath:%s", new Object[] { Boolean.valueOf(paramBoolean), this.LdY, this.LdX });
    if ((!Util.isNullOrNil(this.LdY)) && (paramBoolean)) {
      y.deleteFile(this.LdY);
    }
    if (!Util.isNullOrNil(this.LdX)) {
      y.deleteFile(this.LdX);
    }
    this.LdY = null;
    this.LdX = null;
    rx localrx = new rx();
    localrx.hVa.hAf = 0;
    localrx.publish();
    AppMethodBeat.o(94701);
  }
  
  public final void cba()
  {
    AppMethodBeat.i(94704);
    Log.i("MicroMsg.SightCaptureUI", "onError: %s", new Object[] { Integer.valueOf(1) });
    try
    {
      if (this.qpz != null) {
        this.qpz.reset();
      }
      FJ(9);
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
    } while ((paramInt2 != -1) || (paramIntent == null) || (this.qpz == null));
    this.LdZ = true;
    this.Lea = paramIntent.getBundleExtra("report_info");
    this.LdX = paramIntent.getStringExtra("raw_photo_path");
    this.LdY = paramIntent.getStringExtra("after_photo_edit");
    boolean bool = CaptureMMProxy.getInstance().getBoolean(at.a.acPr, true);
    Log.i("MicroMsg.SightCaptureUI", "rawEditPhotoPath:%s lastEditPhotoPath:%s imageState:%s", new Object[] { this.LdX, this.LdY, Boolean.valueOf(bool) });
    if (!bool)
    {
      paramIntent = y.n("wcf://temp/photoEdited_" + System.currentTimeMillis(), true);
      Log.i("MicroMsg.SightCaptureUI", "saveFullPath:%s", new Object[] { paramIntent });
      y.O(this.LdY, paramIntent, false);
      y.deleteFile(this.LdY);
      AndroidMediaUtil.refreshMediaScanner(this.LdY, this);
      this.qpz.He(paramIntent);
      this.LdY = paramIntent;
    }
    for (;;)
    {
      paramIntent = new BitmapFactory.Options();
      paramIntent.inJustDecodeBounds = true;
      BitmapUtil.decodeFile(this.LdY, paramIntent);
      Log.i("MicroMsg.SightCaptureUI", "rawW:%s rawH:%s", new Object[] { Integer.valueOf(paramIntent.outWidth), Integer.valueOf(paramIntent.outHeight) });
      paramIntent = BitmapUtil.createThumbBitmap(this.LdY, paramIntent.outHeight, paramIntent.outWidth, true, false);
      this.Ldw.setVisibility(0);
      this.Ldw.setImageBitmap(paramIntent);
      this.Ldx.setVisibility(8);
      break;
      this.qpz.He(this.LdY);
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(94702);
    Log.i("MicroMsg.SightCaptureUI", "onBackPressed %d", new Object[] { Integer.valueOf(this.rPN) });
    if ((this.LdC != null) && (this.LdC.onBackPressed()))
    {
      AppMethodBeat.o(94702);
      return;
    }
    if (this.LdC != null)
    {
      this.LdC.release();
      this.LdC = null;
      setSelfNavigationBarVisible(8);
      this.Ldm.setVisibility(0);
      this.Ldn.setVisibility(0);
      this.Lds.setVisibility(0);
      AppMethodBeat.o(94702);
      return;
    }
    if (gdy())
    {
      super.onBackPressed();
      overridePendingTransition(-1, a.a.sight_slide_bottom_out);
      yF(true);
    }
    AppMethodBeat.o(94702);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(94684);
    super.onConfigurationChanged(paramConfiguration);
    if ((this.LdU.booleanValue()) && (com.tencent.mm.compatible.util.d.rb(13)))
    {
      paramConfiguration = new Point(paramConfiguration.screenWidthDp, paramConfiguration.screenHeightDp);
      if ((this.LdV == null) || (!this.LdV.equals(paramConfiguration)))
      {
        this.LdV = paramConfiguration;
        gdq();
      }
    }
    AppMethodBeat.o(94684);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(94680);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    this.KXs = ((SightParams)getIntent().getParcelableExtra("KEY_SIGHT_PARAMS"));
    if (this.KXs == null)
    {
      Log.e("MicroMsg.SightCaptureUI", "error!!!! sightParams is null!!");
      AppMethodBeat.o(94680);
      return;
    }
    CaptureMMProxy.createProxy(new CaptureMMProxy(this.pfZ));
    final long l = Util.currentTicks();
    this.pfZ.connect(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94632);
        Log.i("MicroMsg.SightCaptureUI", "connect cost %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
        com.tencent.mm.plugin.mmsight.model.j.d(SightCaptureUI.a(SightCaptureUI.this).nLH);
        SightCaptureUI.b(SightCaptureUI.this);
        AppMethodBeat.o(94632);
      }
    });
    this.Hnz.alive();
    AppMethodBeat.o(94680);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(94698);
    super.onDestroy();
    Log.i("MicroMsg.SightCaptureUI", "onDestroy");
    this.pfZ.release();
    if (this.qpz != null)
    {
      this.qpz.a(null);
      this.qpz.J(null);
      this.qpz.clear();
    }
    if (this.rPN == -1) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        gdw();
        if (this.KZh != null)
        {
          this.KZh.stop();
          this.KZh.setVideoCallback(null);
        }
        if (this.peV != null) {
          this.peV.aPS();
        }
        if (this.LdC != null)
        {
          this.LdC.release();
          this.LdC = null;
        }
      }
      if (this.orientationEventListener != null)
      {
        this.orientationEventListener.disable();
        this.orientationEventListener.KUU = null;
        this.orientationEventListener = null;
      }
      com.tencent.mm.plugin.mmsight.model.a.j.KXq.bvG();
      this.Hnz.dead();
      AppMethodBeat.o(94698);
      return;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(94681);
    if ((af.lXY.lSU == 1) && (paramInt == 700) && (this.LdD)) {
      gdo();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(94681);
    return bool;
  }
  
  public void onOrientationChange(int paramInt)
  {
    AppMethodBeat.i(94703);
    if (this.LdP <= 1)
    {
      AppMethodBeat.o(94703);
      return;
    }
    if (this.rPN == 2)
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
    while (this.nhZ.getRotation() == f)
    {
      AppMethodBeat.o(94703);
      return;
      f = -90.0F;
      continue;
      f = paramInt;
    }
    this.nhZ.animate().rotation(f).setDuration(100L).start();
    AppMethodBeat.o(94703);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(94682);
    super.onPause();
    Log.i("MicroMsg.SightCaptureUI", "onPause, currentState: %s", new Object[] { abk(this.rPN) });
    if (this.rPN == 2)
    {
      stopRecord();
      AppMethodBeat.o(94682);
      return;
    }
    if (this.rPN == 1)
    {
      gdw();
      AppMethodBeat.o(94682);
      return;
    }
    if ((this.rPN == 4) && (this.KZh != null)) {
      this.KZh.pause();
    }
    AppMethodBeat.o(94682);
  }
  
  public void onResume()
  {
    boolean bool2 = false;
    AppMethodBeat.i(94683);
    super.onResume();
    setSelfNavigationBarVisible(8);
    String str = abk(this.rPN);
    boolean bool1 = bool2;
    if (this.qqc != null)
    {
      bool1 = bool2;
      if (this.qqc.isAvailable()) {
        bool1 = true;
      }
    }
    Log.i("MicroMsg.SightCaptureUI", "onResume, currentState: %s, textureview available: %s", new Object[] { str, Boolean.valueOf(bool1) });
    if ((this.rPN == 2) || (this.rPN == 1))
    {
      gdq();
      AppMethodBeat.o(94683);
      return;
    }
    if (this.rPN == 4)
    {
      if (this.qqc != null)
      {
        if (!this.qqc.isAvailable()) {
          break label154;
        }
        this.Ldy.bgx();
      }
      while (this.KZh != null)
      {
        this.KZh.start();
        AppMethodBeat.o(94683);
        return;
        label154:
        this.qqc.setTextureChangeCallback(new com.tencent.mm.plugin.video.b()
        {
          public final void h(SurfaceTexture paramAnonymousSurfaceTexture)
          {
            AppMethodBeat.i(94669);
            SightCaptureUI.e(SightCaptureUI.this).bgx();
            SightCaptureUI.f(SightCaptureUI.this).setTextureChangeCallback(null);
            AppMethodBeat.o(94669);
          }
        });
      }
    }
    if (this.rPN == 3)
    {
      if (this.qqc != null) {
        this.qqc.setTextureChangeCallback(null);
      }
      this.Ldy.a(this.LdK, this.LdO, this.LdL);
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