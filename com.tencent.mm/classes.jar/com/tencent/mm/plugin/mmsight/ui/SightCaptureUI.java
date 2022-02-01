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
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.c;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.g.a.pm;
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
import com.tencent.mm.pluginsdk.ui.tools.j.a;
import com.tencent.mm.pluginsdk.ui.tools.j.e;
import com.tencent.mm.protocal.protobuf.cly;
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
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class SightCaptureUI
  extends MMActivity
  implements com.tencent.mm.plugin.mmsight.model.a.d.a, com.tencent.mm.plugin.mmsight.model.d.a
{
  private com.tencent.f.i.d dwt;
  private String ebj;
  private com.tencent.mm.remoteservice.d gVN;
  private ImageView hQv;
  private VideoTransPara irT;
  private ViewGroup jLy;
  private com.tencent.mm.compatible.util.b jvG;
  private com.tencent.mm.plugin.mmsight.model.a.d kxS;
  private ObservableTextureView kyv;
  private long lPA;
  private int lPy;
  private boolean lPz;
  private ViewGroup oot;
  private com.tencent.mm.plugin.mmsight.model.d orientationEventListener;
  private MMSightCaptureTouchView rsW;
  private View ygS;
  private int zCN;
  private boolean zCO;
  private f zCP;
  private MMSightRecordButton zCQ;
  private View zCR;
  private View zCS;
  private ViewGroup zCT;
  private ImageView zCU;
  private SurfaceTexture zCV;
  CameraFrontSightView zCW;
  private ViewGroup zCX;
  private ImageView zCY;
  private MMSightCameraGLSurfaceView zCZ;
  private String zDA;
  private String zDB;
  private boolean zDC;
  private Bundle zDD;
  private Runnable zDE;
  private com.tencent.mm.plugin.mmsight.ui.cameraglview.a zDa;
  private TextView zDb;
  private View zDc;
  private MMSightTopCountdownCoverView zDd;
  private b zDe;
  private boolean zDf;
  private cly zDg;
  private byte[] zDh;
  private int zDi;
  private int zDj;
  private int zDk;
  private int zDl;
  private byte[] zDm;
  private int zDn;
  private boolean zDo;
  private boolean zDp;
  private boolean zDq;
  private int zDr;
  private int zDs;
  private long zDt;
  private boolean zDu;
  private boolean zDv;
  private Boolean zDw;
  private Point zDx;
  private IListener zDy;
  private Runnable zDz;
  private int zsH;
  private SightParams zwk;
  private VideoPlayerTextureView zyd;
  private VideoSeekBarEditorView zye;
  private j.a zyk;
  
  public SightCaptureUI()
  {
    AppMethodBeat.i(94679);
    this.zCN = 1;
    this.zsH = 2;
    this.zCO = true;
    this.lPy = -1;
    this.zDf = true;
    this.zDg = new cly();
    this.gVN = new com.tencent.mm.remoteservice.d(MMApplicationContext.getContext());
    this.zDo = false;
    this.zDp = false;
    this.zDq = false;
    this.zDr = 0;
    this.lPz = false;
    this.zDs = 0;
    this.zDt = -1L;
    this.lPA = -1L;
    this.zDu = false;
    this.zDv = false;
    this.ebj = "";
    this.zDw = Boolean.FALSE;
    this.zDy = new SightCaptureUI.12(this);
    this.zDz = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94662);
        if ((SightCaptureUI.g(SightCaptureUI.this) == 7) && (SightCaptureUI.k(SightCaptureUI.this) != null))
        {
          Log.i("MicroMsg.SightCaptureUI", "showRecoderProgressBar");
          SightCaptureUI.k(SightCaptureUI.this).showLoading();
        }
        AppMethodBeat.o(94662);
      }
    };
    this.zDE = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94663);
        if (SightCaptureUI.g(SightCaptureUI.this) != 4)
        {
          Log.e("MicroMsg.SightCaptureUI", "checkPreviewStatusRunnable, not previewing now!!!");
          SightCaptureUI.b(SightCaptureUI.this, 9);
        }
        AppMethodBeat.o(94663);
      }
    };
    this.zyk = new j.a()
    {
      public final void eo(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final int fh(int paramAnonymousInt1, int paramAnonymousInt2)
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
        Log.e("MicroMsg.SightCaptureUI", "%d on error what %d extra %d", new Object[] { Integer.valueOf(SightCaptureUI.this.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(94666);
      }
      
      public final void tf()
      {
        AppMethodBeat.i(94667);
        if (SightCaptureUI.S(SightCaptureUI.this) != null)
        {
          SightCaptureUI.S(SightCaptureUI.this).start();
          SightCaptureUI.S(SightCaptureUI.this).setLoop(true);
        }
        MMHandlerThread.removeRunnable(SightCaptureUI.M(SightCaptureUI.this));
        SightCaptureUI.S(SightCaptureUI.this).setOneTimeVideoTextureUpdateCallback(new j.e()
        {
          public final void bLh()
          {
            AppMethodBeat.i(94665);
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(94664);
                Log.i("MicroMsg.SightCaptureUI", "onTextureUpdate");
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
            if (SightCaptureUI.a(SightCaptureUI.this).zsP) {
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
  
  private void BH(int paramInt)
  {
    AppMethodBeat.i(94700);
    Log.i("MicroMsg.SightCaptureUI", "pre state %s %s update state %s %s", new Object[] { Integer.valueOf(this.lPy), QU(this.lPy), Integer.valueOf(paramInt), QU(paramInt) });
    Log.i("MicroMsg.TestCaptureUiEvent", "pre state %s %s update state %s %s %s", new Object[] { Integer.valueOf(this.lPy), QU(this.lPy), Integer.valueOf(paramInt), QU(paramInt), Util.getStack().toString() });
    if (paramInt == this.lPy)
    {
      AppMethodBeat.o(94700);
      return;
    }
    if (this.oot == null)
    {
      AppMethodBeat.o(94700);
      return;
    }
    com.tencent.mm.plugin.mmsight.d.aFn("TIME_RECODER_2_PLAY");
    this.lPy = paramInt;
    if (this.lPy != 7) {
      MMHandlerThread.removeRunnable(this.zDz);
    }
    if (this.lPy == 0)
    {
      this.oot.setVisibility(8);
      this.zCU.setVisibility(8);
      this.zCT.setVisibility(8);
      this.zCY.setVisibility(8);
      this.zCX.setVisibility(0);
      if (this.zDr > 1) {
        this.hQv.setVisibility(0);
      }
      if (this.zCP != null) {
        this.zCP.a(f.a.zug);
      }
      com.tencent.mm.plugin.mmsight.model.b.reset();
      if (this.dwt == null) {
        break label1135;
      }
      try
      {
        this.dwt.cancel(true);
        this.dwt = null;
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
    if ((this.lPy == 1) || (this.lPy == 2))
    {
      this.oot.setVisibility(0);
      this.zCU.setVisibility(8);
      this.zCT.setVisibility(0);
      this.zCT.setClipChildren(false);
      this.zCR.setVisibility(8);
      this.ygS.setVisibility(8);
      this.zCS.setVisibility(0);
      this.zCQ.setVisibility(0);
      this.zyd.setVisibility(8);
      if (this.lPy == 1) {
        this.zCQ.reset();
      }
      for (;;)
      {
        this.zDc.setVisibility(8);
        this.zCY.setVisibility(8);
        this.rsW.setVisibility(0);
        if (this.zDr > 1) {
          this.hQv.setVisibility(0);
        }
        this.rsW.bringToFront();
        this.hQv.bringToFront();
        ekZ();
        ela();
        AppMethodBeat.o(94700);
        return;
        this.zCQ.setTouchEnable(true);
        this.zCQ.ekF();
      }
    }
    if ((this.lPy == 4) || (this.lPy == 3))
    {
      this.oot.setVisibility(0);
      this.zCT.setVisibility(8);
      this.zCT.setClipChildren(false);
      this.zCR.setVisibility(0);
      this.ygS.setVisibility(0);
      this.zCS.setVisibility(8);
      this.zCQ.setVisibility(8);
      if (this.lPy == 3)
      {
        if (this.zwk.zsP) {
          this.zCU.setVisibility(0);
        }
        this.zCY.setVisibility(0);
        this.zyd.setVisibility(8);
      }
      for (;;)
      {
        this.rsW.setVisibility(8);
        AppMethodBeat.o(94700);
        return;
        this.zCY.setVisibility(8);
        this.zyd.setVisibility(0);
        this.zyd.setForceScaleFullScreen(true);
        ViewGroup.LayoutParams localLayoutParams = this.zyd.getLayoutParams();
        localLayoutParams.width = -1;
        localLayoutParams.height = -1;
        this.zyd.setLayoutParams(localLayoutParams);
        if (this.kxS.isLandscape()) {
          this.zDa.aEy();
        }
        this.zCX.setVisibility(8);
      }
    }
    if (this.lPy == 6)
    {
      this.zCR.setVisibility(8);
      this.ygS.setVisibility(8);
      this.zCU.setVisibility(8);
      this.zCS.setVisibility(8);
      this.zCQ.setVisibility(8);
      AppMethodBeat.o(94700);
      return;
    }
    if (this.lPy == 7)
    {
      this.zCR.setVisibility(8);
      this.ygS.setVisibility(8);
      this.zCS.setVisibility(8);
      this.hQv.setVisibility(8);
      this.zCU.setVisibility(8);
      this.zCQ.setTouchEnable(false);
      MMHandlerThread.postToMainThreadDelayed(this.zDz, 1500L);
      this.zCQ.hideProgress();
      AppMethodBeat.o(94700);
      return;
    }
    if (this.lPy == 8)
    {
      this.oot.setVisibility(0);
      this.zCT.setVisibility(0);
      this.zCT.setClipChildren(false);
      this.zCR.setVisibility(8);
      this.ygS.setVisibility(8);
      this.zCU.setVisibility(8);
      this.zCS.setVisibility(0);
      if (this.zDr > 1) {
        this.hQv.setVisibility(0);
      }
      this.zCQ.setVisibility(0);
      this.rsW.setVisibility(0);
      this.zyd.setVisibility(8);
      this.zDc.setVisibility(8);
      this.zCY.setVisibility(8);
      if (this.zDv) {
        Toast.makeText(this, 2131763062, 1).show();
      }
      for (;;)
      {
        this.zCQ.setTouchEnable(false);
        this.zCQ.setEnabled(false);
        AppMethodBeat.o(94700);
        return;
        Toast.makeText(this, 2131763067, 1).show();
      }
    }
    if (this.lPy == 9)
    {
      this.zCR.setVisibility(8);
      this.ygS.setVisibility(8);
      this.zCU.setVisibility(8);
      this.zCS.setVisibility(0);
      this.hQv.setVisibility(8);
      this.zCQ.reset();
      this.zCQ.setTouchEnable(false);
      this.zCQ.setEnabled(false);
      Toast.makeText(this, 2131763063, 1).show();
    }
    label1135:
    AppMethodBeat.o(94700);
  }
  
  private static String QU(int paramInt)
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
  
  private String bP(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(94695);
    boolean bool1 = CaptureMMProxy.getInstance().getBoolean(ar.a.NZV, true);
    boolean bool2 = CaptureMMProxy.getInstance().getBoolean(ar.a.NZW, true);
    if (paramBoolean) {}
    for (String str = com.tencent.mm.plugin.mmsight.d.getExportImagePath("jpg");; str = com.tencent.mm.plugin.mmsight.d.getExportImagePath("mp4"))
    {
      if (((bool1) && (paramBoolean)) || ((bool2) && (!paramBoolean)))
      {
        Log.i("MicroMsg.SightCaptureUI", "auto save src %s dest %s state %s %s", new Object[] { paramString, str, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        s.nw(paramString, str);
        AndroidMediaUtil.refreshMediaScanner(str, this);
      }
      AppMethodBeat.o(94695);
      return str;
    }
  }
  
  private void ekT()
  {
    AppMethodBeat.i(94685);
    if ((this.zDt > 0L) && (Util.ticksToNow(this.zDt) <= 500L))
    {
      Log.i("MicroMsg.SightCaptureUI", "switchCameraClick, switch camera too frequently!!! ignore");
      AppMethodBeat.o(94685);
      return;
    }
    Log.v("MicroMsg.TestCaptureUiEvent", "switchCameraClick %s, currentState: %s", new Object[] { Util.getStack().toString(), Integer.valueOf(this.lPy) });
    ekZ();
    this.zDo = true;
    if (this.lPy == 2) {
      if ((this.kxS == null) || (!this.kxS.aQR())) {
        Log.i("MicroMsg.SightCaptureUI", "switchCameraClick, not write camera data!");
      }
    }
    for (;;)
    {
      ela();
      this.zDt = Util.currentTicks();
      AppMethodBeat.o(94685);
      return;
      elc();
      this.zDp = true;
      continue;
      if (this.lPy == 1)
      {
        BH(6);
        if (rn(true)) {
          BH(1);
        }
      }
    }
  }
  
  private void ekU()
  {
    AppMethodBeat.i(94687);
    try
    {
      ViewGroup.LayoutParams localLayoutParams = this.zyd.getLayoutParams();
      this.oot.removeView(this.zyd);
      this.oot.addView(this.zyd, 0, localLayoutParams);
      AppMethodBeat.o(94687);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.SightCaptureUI", "clearVideoPlayViewContent, error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94687);
    }
  }
  
  private void ekV()
  {
    AppMethodBeat.i(94688);
    BH(0);
    this.zDs = 0;
    this.lPz = false;
    this.zDv = false;
    if (this.zyd != null)
    {
      this.zyd.stop();
      this.zyd.setVideoCallback(null);
      ekU();
    }
    if (this.zDe != null)
    {
      this.zDe.release();
      this.zDe = null;
    }
    if (this.zCZ != null) {
      this.zCZ.setVisibility(0);
    }
    this.zCY.setImageBitmap(null);
    elb();
    this.zCP = new f(this.irT, this.zwk.scene);
    this.zCP.a(this.zDa.iqW);
    this.zDd.setVisibility(8);
    if (!this.zCP.D(this, this.zDf))
    {
      BH(8);
      AppMethodBeat.o(94688);
      return;
    }
    if (this.kyv.isAvailable())
    {
      this.zCV = this.kyv.getSurfaceTexture();
      Log.i("MicroMsg.SightCaptureUI", "surface already available, directly set local surface: %s", new Object[] { this.zCV });
      if (rn(false)) {
        BH(1);
      }
    }
    for (;;)
    {
      if ((this.zDb != null) && (this.zCO))
      {
        this.zDb.setAlpha(1.0F);
        this.zDb.setVisibility(0);
      }
      this.orientationEventListener.reset();
      this.zDo = false;
      this.zDp = false;
      AppMethodBeat.o(94688);
      return;
      BH(8);
      continue;
      this.kyv.setTextureChangeCallback(new com.tencent.mm.plugin.video.b()
      {
        public final void f(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(94644);
          Log.i("MicroMsg.SightCaptureUI", "callback onSurfaceTextureAvailable set local surface: %s", new Object[] { paramAnonymousSurfaceTexture });
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
  
  private int ekW()
  {
    AppMethodBeat.i(94690);
    Log.i("MicroMsg.SightCaptureUI", "startRecordImpl");
    int i = this.kxS.b(this.zCP.getOrientation(), this.orientationEventListener.isLandscape(), this.orientationEventListener.getOrientation());
    Log.i("MicroMsg.SightCaptureUI", "startRecordImpl ret: %d", new Object[] { Integer.valueOf(i) });
    if (i >= 0) {
      this.zCP.a(f.a.zuh);
    }
    AppMethodBeat.o(94690);
    return i;
  }
  
  private void ekX()
  {
    AppMethodBeat.i(94691);
    this.zDv = true;
    BH(8);
    if (this.kxS != null) {
      try
      {
        this.kxS.cancel();
        this.kxS = null;
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
  
  private void ekY()
  {
    AppMethodBeat.i(94692);
    BH(7);
    this.zCQ.setTouchEnable(false);
    if (this.zwk.zsQ) {
      this.zDd.ekL();
    }
    final int i = this.zCP.getPreviewWidth();
    final int j = this.zCP.getPreviewHeight();
    this.kxS.E(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94647);
        Log.printInfoStack("MicroMsg.SightCaptureUI", "call stop callback now, currentStatus: %s", new Object[] { SightCaptureUI.QV(SightCaptureUI.g(SightCaptureUI.this)) });
        SightCaptureUI.j(SightCaptureUI.this).a(f.a.zui);
        SightCaptureUI.B(SightCaptureUI.this);
        final long l = com.tencent.mm.plugin.mmsight.d.aFo("TIME_RECODER_2_PLAY");
        com.tencent.f.h.RTc.aX(new com.tencent.f.i.h()
        {
          public final String getKey()
          {
            return "BigSightFFMpegRecorder_markAfterCaptureFinish_idkeystat";
          }
          
          public final void run()
          {
            AppMethodBeat.i(94646);
            String str = SightCaptureUI.p(SightCaptureUI.this).getFilePath();
            localcly = SightCaptureUI.J(SightCaptureUI.this);
            int n = com.tencent.mm.plugin.mmsight.model.k.zuy.gIP;
            m = com.tencent.mm.plugin.mmsight.model.k.zuy.ilT;
            for (;;)
            {
              try
              {
                if (!Util.isNullOrNil(str))
                {
                  boolean bool = s.YS(str);
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
                Log.e("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish error: %s", new Object[] { localException.getMessage() });
                continue;
                int i = 0;
                continue;
                i = 0;
                continue;
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(440L, 88L, 1L, false);
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(440L, 48L, i1, false);
                i = 90;
                int k = 54;
                int j = 50;
                continue;
                if (com.tencent.mm.plugin.mmsight.model.k.zuy.ejS()) {
                  continue;
                }
                if (m != 1080) {
                  continue;
                }
                continue;
                if ((i1 <= 10) || (i1 > 15)) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(440L, k + 1, 1L, false);
                continue;
                if ((i1 <= 15) || (i1 > 20)) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(440L, k + 2, 1L, false);
                continue;
                if ((i1 <= 20) || (i1 > 30)) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(440L, k + 3, 1L, false);
                continue;
                if (localcly.Mro != 2) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(440L, 194L, i2, false);
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(440L, 195L, 1L, false);
                continue;
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(440L, 179L, i2, false);
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(440L, 180L, 1L, false);
                if (localcly == null) {
                  continue;
                }
                if (localcly.Mro != 1) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(440L, 189L, i2, false);
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(440L, 190L, 1L, false);
                continue;
                if (localcly.Mro != 2) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(440L, 199L, i2, false);
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(440L, 200L, 1L, false);
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
              com.tencent.mm.plugin.mmsight.model.l.h(false, l);
              AppMethodBeat.o(94646);
              return;
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(440L, 87L, 1L, false);
              localObject = new JSONObject(SightVideoJNI.getSimpleMp4InfoVFS(str));
              i1 = (int)((JSONObject)localObject).getDouble("videoFPS");
              i2 = ((JSONObject)localObject).optInt("videoBitrate");
              Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, videoFPS: %s, videoBitrate: %s, recorderType: %s, resolutionLimit: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(n), Integer.valueOf(m) });
              localObject = com.tencent.mm.plugin.mmsight.model.b.ejt();
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).ztt = com.tencent.mm.plugin.mmsight.model.k.zuy.gIP;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).videoBitrate = com.tencent.mm.plugin.mmsight.model.k.zuy.videoBitrate;
              if (!com.tencent.mm.plugin.mmsight.model.k.zuy.isQ) {
                continue;
              }
              i = 1;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).gIQ = i;
              if (!com.tencent.mm.plugin.mmsight.model.k.zuy.zuL) {
                continue;
              }
              i = 1;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).ztu = i;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).ilT = com.tencent.mm.plugin.mmsight.model.k.zuy.ilT;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).ztv = i1;
              ((com.tencent.mm.plugin.mmsight.model.b)localObject).fileSize = s.boW(str);
              locala = e.aNx(str);
              if (locala != null)
              {
                ((com.tencent.mm.plugin.mmsight.model.b)localObject).zty = locala.width;
                ((com.tencent.mm.plugin.mmsight.model.b)localObject).ztz = locala.height;
                ((com.tencent.mm.plugin.mmsight.model.b)localObject).ztA = locala.videoBitrate;
                ((com.tencent.mm.plugin.mmsight.model.b)localObject).ztw = locala.videoDuration;
              }
              if (n != 1) {
                continue;
              }
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(440L, 89L, 1L, false);
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(440L, 49L, i1, false);
              i = 93;
              k = 73;
              j = 69;
              continue;
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(440L, j, i1, false);
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(440L, i, 1L, false);
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(440L, 47L, i1, false);
              Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, filePath: %s base %d", new Object[] { str, Integer.valueOf(k) });
              if ((i1 < 0) || (i1 > 10)) {
                continue;
              }
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(440L, k, 1L, false);
              if (i2 > 0)
              {
                if (n != 2) {
                  continue;
                }
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(440L, 175L, i2, false);
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(440L, 176L, 1L, false);
                if (localcly != null)
                {
                  if (localcly.Mro != 1) {
                    continue;
                  }
                  com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(440L, 184L, i2, false);
                  com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(440L, 185L, 1L, false);
                }
              }
            }
          }
        });
        Log.v("MicroMsg.TestCaptureUiEvent", "doStopRecorderAndStartPreviewDone %s", new Object[] { Util.getStack().toString() });
        Log.i("MicroMsg.SightCaptureUI", "stop finish, filepath: %s %s time_takevideo %s", new Object[] { SightCaptureUI.p(SightCaptureUI.this).getFilePath(), Long.valueOf(s.boW(SightCaptureUI.p(SightCaptureUI.this).getFilePath())), Long.valueOf(l) });
        SightCaptureUI.a(SightCaptureUI.this, SightCaptureUI.p(SightCaptureUI.this).getMd5());
        SightCaptureUI.A(SightCaptureUI.this);
        SightCaptureUI.K(SightCaptureUI.this);
        SightCaptureUI.L(SightCaptureUI.this);
        MMHandlerThread.postToMainThreadDelayed(SightCaptureUI.M(SightCaptureUI.this), 1000L);
        if ((SightCaptureUI.a(SightCaptureUI.this).scene == 1) || (SightCaptureUI.a(SightCaptureUI.this).scene == 2) || (SightCaptureUI.a(SightCaptureUI.this).scene == 7)) {
          com.tencent.mm.plugin.report.service.h.CyF.a(13819, new Object[] { Integer.valueOf(2), Integer.valueOf(SightCaptureUI.a(SightCaptureUI.this).scene), SightCaptureUI.a(SightCaptureUI.this).vPa, Long.valueOf(Util.nowSecond()) });
        }
        AppMethodBeat.o(94647);
      }
    });
    AppMethodBeat.o(94692);
  }
  
  private void ekZ()
  {
    AppMethodBeat.i(94693);
    com.tencent.mm.plugin.mmsight.model.a.l.ekc();
    if (!com.tencent.mm.plugin.mmsight.model.a.l.KB())
    {
      AppMethodBeat.o(94693);
      return;
    }
    TextView localTextView = (TextView)findViewById(2131309744);
    localTextView.setVisibility(8);
    localTextView.setText("");
    AppMethodBeat.o(94693);
  }
  
  private void ela()
  {
    AppMethodBeat.i(94694);
    com.tencent.mm.plugin.mmsight.model.a.l.ekc();
    if (!com.tencent.mm.plugin.mmsight.model.a.l.KB())
    {
      AppMethodBeat.o(94694);
      return;
    }
    Log.i("MicroMsg.SightCaptureUI", "test for debug " + Util.getStack().toString());
    j.ak(new Runnable()
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
  
  private void elb()
  {
    AppMethodBeat.i(94696);
    if (this.kyv != null) {
      this.kyv.setTextureChangeCallback(null);
    }
    if (this.zCP != null)
    {
      this.zDf = this.zCP.aPB();
      this.zCP.ejD();
      this.zDt = -1L;
      this.lPA = -1L;
    }
    AppMethodBeat.o(94696);
  }
  
  private void elc()
  {
    AppMethodBeat.i(94697);
    int i = this.lPy;
    if (this.kxS != null) {}
    for (Object localObject = this.kxS.aQN();; localObject = "")
    {
      Log.i("MicroMsg.SightCaptureUI", "switchCameraOnRecord, currentStatus: %s, mediaRecorder.status: %s", new Object[] { Integer.valueOf(i), localObject });
      if ((this.lPy != 2) || (this.kxS == null) || (this.kxS.aQN() != d.c.zvu)) {
        break label406;
      }
      this.kxS.pause();
      this.zCP.a(this, this.zCV, false);
      this.zDf = this.zCP.aPB();
      if (this.zDa != null) {
        this.zDa.aq(this.zCP.getPreviewWidth(), this.zCP.getPreviewHeight(), this.zCP.getOrientation());
      }
      if (this.kxS.aQN() == d.c.zvC) {
        break;
      }
      Log.e("MicroMsg.SightCaptureUI", "switchCameraOnRecord, recorder status error: %s", new Object[] { this.kxS.aQN() });
      AppMethodBeat.o(94697);
      return;
    }
    i = this.zCP.getPreviewWidth();
    int j = this.zCP.getPreviewHeight();
    int k = this.zCP.getOrientation();
    localObject = this.kxS.aQP();
    int m = this.kxS.aQQ();
    Log.i("MicroMsg.SightCaptureUI", "switchCameraOnRecord, newPreviewSize: [%s, %s], oldPreviewSize: [%s], newOrientation: %s, oldOrientation: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localObject, Integer.valueOf(k), Integer.valueOf(m) });
    if ((m != k) || (((Point)localObject).x != i) || (((Point)localObject).y != j)) {
      Log.e("MicroMsg.SightCaptureUI", "error oldOrientation! after switch, size or orientation not match");
    }
    this.kxS.s(this.zCP.getPreviewWidth(), this.zCP.getPreviewHeight(), this.zCP.getEncodeVideoBestSize().x, this.zCP.getEncodeVideoBestSize().y);
    this.kxS.M(k, this.zCP.getEncodeVideoBestSize().x, this.zCP.getEncodeVideoBestSize().y);
    label406:
    AppMethodBeat.o(94697);
  }
  
  private boolean eld()
  {
    return (this.lPy == 4) || (this.lPy == 3) || (this.lPy == 1) || (this.lPy == 8) || (this.lPy == 9);
  }
  
  private boolean rn(boolean paramBoolean)
  {
    AppMethodBeat.i(94689);
    Log.printDebugStack("MicroMsg.SightCaptureUI", "createRecorder, surface: %s", new Object[] { this.zCV });
    this.zDv = false;
    if (this.kxS != null)
    {
      if (this.zCP != null) {
        this.zCP.b(this.kxS.getFrameDataCallback());
      }
      this.kxS.cancel();
    }
    if (this.zCP == null)
    {
      AppMethodBeat.o(94689);
      return false;
    }
    this.zDg = new cly();
    this.zDg.Mrn = true;
    this.zDg.Mrm = com.tencent.mm.plugin.mmsight.model.k.zuy.zuN;
    if (this.zwk != null) {
      this.zDg.Mro = this.zwk.scene;
    }
    if (!paramBoolean)
    {
      if (this.zCP.a(this.zCV, true) < 0)
      {
        AppMethodBeat.o(94689);
        return false;
      }
    }
    else
    {
      paramBoolean = this.zCP.a(this, this.zCV, true);
      this.zDf = this.zCP.aPB();
      if (!paramBoolean)
      {
        AppMethodBeat.o(94689);
        return false;
      }
    }
    if (this.zCP.getEncodeVideoBestSize() == null)
    {
      AppMethodBeat.o(94689);
      return false;
    }
    com.tencent.mm.plugin.mmsight.model.a.l.ekc();
    this.kxS = com.tencent.mm.plugin.mmsight.model.a.l.q(this.irT);
    if (this.kxS == null)
    {
      Log.e("MicroMsg.SightCaptureUI", "create mediaRecorder error");
      this.zDv = true;
      AppMethodBeat.o(94689);
      return false;
    }
    com.tencent.mm.plugin.mmsight.d.a(this.kxS, this.zwk);
    this.kxS.a(this);
    this.zCP.a(this.kxS.getFrameDataCallback());
    if (this.zDa != null) {
      this.zDa.aq(this.zCP.getPreviewWidth(), this.zCP.getPreviewHeight(), this.zCP.getOrientation());
    }
    if ((this.zwk != null) && (this.zwk.scene == 3) && ((this.zwk.mode == 2) || (this.zwk.mode == 0)) && (!Util.isNullOrNil(this.zwk.zsL)) && (!Util.isNullOrNil(this.zwk.zsK))) {
      this.kxS.HB(this.zwk.zsL + this.zwk.zsK);
    }
    this.kxS.s(this.zCP.getPreviewWidth(), this.zCP.getPreviewHeight(), this.zCP.getEncodeVideoBestSize().x, this.zCP.getEncodeVideoBestSize().y);
    paramBoolean = this.kxS.rC(this.zCP.getOrientation());
    Log.i("MicroMsg.SightCaptureUI", "preInit result: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.zDv = true;
    }
    AppMethodBeat.o(94689);
    return paramBoolean;
  }
  
  private void ro(boolean paramBoolean)
  {
    AppMethodBeat.i(94701);
    Log.i("MicroMsg.SightCaptureUI", "[clearPhotoEditCache] isDelete:%s mLastEditPhotoPath:%s mRawEditPhotoPath:%s", new Object[] { Boolean.valueOf(paramBoolean), this.zDB, this.zDA });
    if ((!Util.isNullOrNil(this.zDB)) && (paramBoolean)) {
      s.deleteFile(this.zDB);
    }
    if (!Util.isNullOrNil(this.zDA)) {
      s.deleteFile(this.zDA);
    }
    this.zDB = null;
    this.zDA = null;
    pm localpm = new pm();
    localpm.dVE.dDe = 0;
    EventCenter.instance.publish(localpm);
    AppMethodBeat.o(94701);
  }
  
  private void stopRecord()
  {
    AppMethodBeat.i(94686);
    Log.printInfoStack("MicroMsg.SightCaptureUI", "stopRecord, currentStatus: %s", new Object[] { Integer.valueOf(this.lPy) });
    if (this.lPy == 2) {
      ekY();
    }
    AppMethodBeat.o(94686);
  }
  
  public final void bqP()
  {
    AppMethodBeat.i(94704);
    Log.i("MicroMsg.SightCaptureUI", "onError: %s", new Object[] { Integer.valueOf(1) });
    try
    {
      if (this.kxS != null) {
        this.kxS.reset();
      }
      BH(9);
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
    return 2131493216;
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
    } while ((paramInt2 != -1) || (paramIntent == null) || (this.kxS == null));
    this.zDC = true;
    this.zDD = paramIntent.getBundleExtra("report_info");
    this.zDA = paramIntent.getStringExtra("raw_photo_path");
    this.zDB = paramIntent.getStringExtra("after_photo_edit");
    boolean bool = CaptureMMProxy.getInstance().getBoolean(ar.a.NZV, true);
    Log.i("MicroMsg.SightCaptureUI", "rawEditPhotoPath:%s lastEditPhotoPath:%s imageState:%s", new Object[] { this.zDA, this.zDB, Boolean.valueOf(bool) });
    if (!bool)
    {
      paramIntent = s.k("wcf://temp/photoEdited_" + System.currentTimeMillis(), true);
      Log.i("MicroMsg.SightCaptureUI", "saveFullPath:%s", new Object[] { paramIntent });
      s.nw(this.zDB, paramIntent);
      s.deleteFile(this.zDB);
      AndroidMediaUtil.refreshMediaScanner(this.zDB, this);
      this.kxS.HB(paramIntent);
      this.zDB = paramIntent;
    }
    for (;;)
    {
      paramIntent = new BitmapFactory.Options();
      paramIntent.inJustDecodeBounds = true;
      BitmapUtil.decodeFile(this.zDB, paramIntent);
      Log.i("MicroMsg.SightCaptureUI", "rawW:%s rawH:%s", new Object[] { Integer.valueOf(paramIntent.outWidth), Integer.valueOf(paramIntent.outHeight) });
      paramIntent = BitmapUtil.createThumbBitmap(this.zDB, paramIntent.outHeight, paramIntent.outWidth, true, false);
      this.zCY.setVisibility(0);
      this.zCY.setImageBitmap(paramIntent);
      this.zCZ.setVisibility(8);
      break;
      this.kxS.HB(this.zDB);
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(94702);
    Log.i("MicroMsg.SightCaptureUI", "onBackPressed %d", new Object[] { Integer.valueOf(this.lPy) });
    if ((this.zDe != null) && (this.zDe.onBackPressed()))
    {
      AppMethodBeat.o(94702);
      return;
    }
    if (this.zDe != null)
    {
      this.zDe.release();
      this.zDe = null;
      setSelfNavigationBarVisible(8);
      this.zCR.setVisibility(0);
      this.ygS.setVisibility(0);
      this.zCU.setVisibility(0);
      AppMethodBeat.o(94702);
      return;
    }
    if (eld())
    {
      super.onBackPressed();
      overridePendingTransition(-1, 2130772162);
      ro(true);
    }
    AppMethodBeat.o(94702);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(94684);
    super.onConfigurationChanged(paramConfiguration);
    if ((this.zDw.booleanValue()) && (com.tencent.mm.compatible.util.d.oD(13)))
    {
      paramConfiguration = new Point(paramConfiguration.screenWidthDp, paramConfiguration.screenHeightDp);
      if ((this.zDx == null) || (!this.zDx.equals(paramConfiguration)))
      {
        this.zDx = paramConfiguration;
        ekV();
      }
    }
    AppMethodBeat.o(94684);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(94680);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    this.zwk = ((SightParams)getIntent().getParcelableExtra("KEY_SIGHT_PARAMS"));
    if (this.zwk == null)
    {
      Log.e("MicroMsg.SightCaptureUI", "error!!!! sightParams is null!!");
      AppMethodBeat.o(94680);
      return;
    }
    CaptureMMProxy.createProxy(new CaptureMMProxy(this.gVN));
    final long l = Util.currentTicks();
    this.gVN.connect(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94632);
        Log.i("MicroMsg.SightCaptureUI", "connect cost %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
        com.tencent.mm.plugin.mmsight.model.k.d(SightCaptureUI.a(SightCaptureUI.this).irT);
        SightCaptureUI.b(SightCaptureUI.this);
        AppMethodBeat.o(94632);
      }
    });
    EventCenter.instance.addListener(this.zDy);
    AppMethodBeat.o(94680);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(94698);
    super.onDestroy();
    Log.i("MicroMsg.SightCaptureUI", "onDestroy");
    this.gVN.release();
    if (this.kxS != null)
    {
      this.kxS.a(null);
      this.kxS.E(null);
      this.kxS.clear();
    }
    if (this.lPy == -1) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        elb();
        if (this.zyd != null)
        {
          this.zyd.stop();
          this.zyd.setVideoCallback(null);
        }
        if (this.jvG != null) {
          this.jvG.apm();
        }
        if (this.zDe != null)
        {
          this.zDe.release();
          this.zDe = null;
        }
      }
      if (this.orientationEventListener != null)
      {
        this.orientationEventListener.disable();
        this.orientationEventListener.ztH = null;
        this.orientationEventListener = null;
      }
      com.tencent.mm.plugin.mmsight.model.a.k.zwi.aRR();
      EventCenter.instance.removeListener(this.zDy);
      AppMethodBeat.o(94698);
      return;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(94681);
    if ((ae.gKt.gFC == 1) && (paramInt == 700) && (this.zDf)) {
      ekT();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(94681);
    return bool;
  }
  
  public void onOrientationChange(int paramInt)
  {
    AppMethodBeat.i(94703);
    if (this.zDr <= 1)
    {
      AppMethodBeat.o(94703);
      return;
    }
    if (this.lPy == 2)
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
    while (this.hQv.getRotation() == f)
    {
      AppMethodBeat.o(94703);
      return;
      f = -90.0F;
      continue;
      f = paramInt;
    }
    this.hQv.animate().rotation(f).setDuration(100L).start();
    AppMethodBeat.o(94703);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(94682);
    super.onPause();
    Log.i("MicroMsg.SightCaptureUI", "onPause, currentState: %s", new Object[] { QU(this.lPy) });
    if (this.lPy == 2)
    {
      stopRecord();
      AppMethodBeat.o(94682);
      return;
    }
    if (this.lPy == 1)
    {
      elb();
      AppMethodBeat.o(94682);
      return;
    }
    if ((this.lPy == 4) && (this.zyd != null)) {
      this.zyd.pause();
    }
    AppMethodBeat.o(94682);
  }
  
  public void onResume()
  {
    boolean bool2 = false;
    AppMethodBeat.i(94683);
    super.onResume();
    setSelfNavigationBarVisible(8);
    String str = QU(this.lPy);
    boolean bool1 = bool2;
    if (this.kyv != null)
    {
      bool1 = bool2;
      if (this.kyv.isAvailable()) {
        bool1 = true;
      }
    }
    Log.i("MicroMsg.SightCaptureUI", "onResume, currentState: %s, textureview available: %s", new Object[] { str, Boolean.valueOf(bool1) });
    if ((this.lPy == 2) || (this.lPy == 1))
    {
      ekV();
      AppMethodBeat.o(94683);
      return;
    }
    if (this.lPy == 4)
    {
      if (this.kyv != null)
      {
        if (!this.kyv.isAvailable()) {
          break label154;
        }
        this.zDa.aEy();
      }
      while (this.zyd != null)
      {
        this.zyd.start();
        AppMethodBeat.o(94683);
        return;
        label154:
        this.kyv.setTextureChangeCallback(new com.tencent.mm.plugin.video.b()
        {
          public final void f(SurfaceTexture paramAnonymousSurfaceTexture)
          {
            AppMethodBeat.i(94669);
            SightCaptureUI.e(SightCaptureUI.this).aEy();
            SightCaptureUI.f(SightCaptureUI.this).setTextureChangeCallback(null);
            AppMethodBeat.o(94669);
          }
        });
      }
    }
    if (this.lPy == 3)
    {
      if (this.kyv != null) {
        this.kyv.setTextureChangeCallback(null);
      }
      this.zDa.a(this.zDm, this.zDq, this.zDn);
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