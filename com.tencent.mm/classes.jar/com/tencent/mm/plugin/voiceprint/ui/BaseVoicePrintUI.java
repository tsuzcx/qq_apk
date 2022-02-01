package com.tencent.mm.plugin.voiceprint.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voiceprint.model.p;
import com.tencent.mm.plugin.voiceprint.model.p.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.PlaySound.OnPlayCompletionListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.o;

public abstract class BaseVoicePrintUI
  extends MMActivity
{
  VoiceTipInfoView GRA;
  p GRB = null;
  String GRC = null;
  private boolean GRD = false;
  private View GRE;
  private boolean GRF = false;
  private final p.a GRG = new p.a()
  {
    public final void fEG()
    {
      AppMethodBeat.i(29811);
      p localp = BaseVoicePrintUI.a(BaseVoicePrintUI.this);
      if (localp.doF != null)
      {
        localp.doF.ZZ();
        Log.e("MicroMsg.VoicePrintRecoder", "Reset recorder.stopReocrd");
      }
      localp.fileName = "";
      localp.GRo = null;
      localp.FKi = 0;
      localp.qPl = 0L;
      localp.GRr.wN(true);
      Log.e("MicroMsg.BaseVoicePrintUI", "record stop on error");
      BaseVoicePrintUI.a(BaseVoicePrintUI.this, null);
      BaseVoicePrintUI.b(BaseVoicePrintUI.this);
      AppMethodBeat.o(29811);
    }
  };
  MTimerHandler GRH = new MTimerHandler(new BaseVoicePrintUI.4(this), true);
  private MMHandler GRI = new MMHandler(Looper.getMainLooper(), new MMHandler.Callback()
  {
    public final boolean handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(29816);
      if (paramAnonymousMessage.what == 1)
      {
        Log.d("MicroMsg.BaseVoicePrintUI", "start record");
        PlaySound.play(MMApplicationContext.getContext(), 2131766638, new PlaySound.OnPlayCompletionListener()
        {
          public final void onCompletion()
          {
            AppMethodBeat.i(29815);
            Log.i("MicroMsg.BaseVoicePrintUI", "play press sound end");
            AppMethodBeat.o(29815);
          }
        });
        BaseVoicePrintUI.a(BaseVoicePrintUI.this, "voice_pt_voice_print_record.rec");
        paramAnonymousMessage = BaseVoicePrintUI.a(BaseVoicePrintUI.this);
        Object localObject = BaseVoicePrintUI.d(BaseVoicePrintUI.this);
        BaseVoicePrintUI localBaseVoicePrintUI = BaseVoicePrintUI.this;
        paramAnonymousMessage.fileName = ((String)localObject);
        Log.d("MicroMsg.VoicePrintRecoder", "start filename %s", new Object[] { paramAnonymousMessage.fileName });
        paramAnonymousMessage.GRr.hx(localBaseVoicePrintUI);
        BaseVoicePrintUI.e(BaseVoicePrintUI.this).startTimer(100L);
        paramAnonymousMessage = BaseVoicePrintUI.this;
        paramAnonymousMessage.GRA.fEY();
        localObject = paramAnonymousMessage.GRA;
        Log.d("MicroMsg.VoiceTipInfoView", "hideTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", new Object[] { Integer.valueOf(((VoiceTipInfoView)localObject).mPa.getVisibility()), Boolean.valueOf(((VoiceTipInfoView)localObject).GSx) });
        if ((((VoiceTipInfoView)localObject).mPa.getVisibility() == 0) && (!((VoiceTipInfoView)localObject).GSx))
        {
          ((VoiceTipInfoView)localObject).mPa.clearAnimation();
          ((VoiceTipInfoView)localObject).GSx = true;
          a.a(((VoiceTipInfoView)localObject).mPa, ((VoiceTipInfoView)localObject).getContext(), new VoiceTipInfoView.3((VoiceTipInfoView)localObject));
        }
        for (;;)
        {
          paramAnonymousMessage.GRA.setTipText(paramAnonymousMessage.GRf);
          paramAnonymousMessage.GRH.stopTimer();
          paramAnonymousMessage.GRH.startTimer(500L);
          paramAnonymousMessage.GRy.setVisibility(0);
          paramAnonymousMessage = paramAnonymousMessage.GRz;
          paramAnonymousMessage.reset();
          paramAnonymousMessage.gNC = true;
          paramAnonymousMessage.GSg.startTimer(VoicePrintVolumeMeter.yKE);
          paramAnonymousMessage.fES();
          AppMethodBeat.o(29816);
          return true;
          Log.d("MicroMsg.VoiceTipInfoView", "hideTitle, directly set to INVISIBLE");
          ((VoiceTipInfoView)localObject).mPa.clearAnimation();
          ((VoiceTipInfoView)localObject).mPa.setVisibility(4);
          ((VoiceTipInfoView)localObject).mPa.invalidate();
        }
      }
      AppMethodBeat.o(29816);
      return false;
    }
  });
  String GRf = null;
  Button GRx;
  View GRy;
  VoicePrintVolumeMeter GRz;
  private boolean yJE = false;
  private final MTimerHandler yJN = new MTimerHandler(new MTimerHandler.CallBack()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(29813);
      if (BaseVoicePrintUI.a(BaseVoicePrintUI.this) == null)
      {
        AppMethodBeat.o(29813);
        return true;
      }
      p localp = BaseVoicePrintUI.a(BaseVoicePrintUI.this);
      if (localp.doF != null)
      {
        i = localp.doF.getMaxAmplitude();
        if (i > p.dAR) {
          p.dAR = i;
        }
        Log.d("MicroMsg.VoicePrintRecoder", " map: " + i + " max:" + p.dAR + " per:" + i * 100 / p.dAR);
      }
      for (int i = i * 100 / p.dAR;; i = 0)
      {
        BaseVoicePrintUI.a(BaseVoicePrintUI.this, i);
        AppMethodBeat.o(29813);
        return true;
      }
    }
  }, true);
  
  protected final void acL(int paramInt)
  {
    this.GRA.ekF();
    this.GRA.setErr(paramInt);
    this.GRA.fEX();
  }
  
  protected abstract void edG();
  
  protected final void fEH()
  {
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29818);
        if (!BaseVoicePrintUI.h(BaseVoicePrintUI.this)) {
          BaseVoicePrintUI.i(BaseVoicePrintUI.this);
        }
        AppMethodBeat.o(29818);
      }
    }, 1300L);
  }
  
  protected final void fEI()
  {
    if ((this.GRE.getVisibility() == 4) || (this.GRE.getVisibility() == 8)) {
      return;
    }
    if (this.GRF)
    {
      this.GRE.setVisibility(4);
      return;
    }
    this.GRF = true;
    a.a(this.GRE, this, new a.a()
    {
      public final void fEL() {}
      
      public final void fEM()
      {
        AppMethodBeat.i(29820);
        BaseVoicePrintUI.j(BaseVoicePrintUI.this).setVisibility(4);
        BaseVoicePrintUI.k(BaseVoicePrintUI.this);
        AppMethodBeat.o(29820);
      }
    });
  }
  
  protected final void fEJ()
  {
    acL(2131767174);
  }
  
  protected abstract void fEK();
  
  public int getLayoutId()
  {
    return 2131496844;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    hideTitleView();
    this.GRA = ((VoiceTipInfoView)findViewById(2131309155));
    this.GRx = ((Button)findViewById(2131306656));
    this.GRy = findViewById(2131310092);
    this.GRz = ((VoicePrintVolumeMeter)findViewById(2131310093));
    this.GRE = findViewById(2131297930);
    this.GRA.fEY();
    this.GRz.setArchView(this.GRx);
    this.GRB = new p();
    this.GRB.GRs = this.GRG;
    this.GRx.setOnTouchListener(new View.OnTouchListener()
    {
      private boolean GRL = false;
      private long yKl = 0L;
      
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(29821);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(29821);
          return false;
          BaseVoicePrintUI.a(BaseVoicePrintUI.this, false);
          if (!Util.isNullOrNil(BaseVoicePrintUI.this.GRf))
          {
            this.yKl = System.currentTimeMillis();
            BaseVoicePrintUI.f(BaseVoicePrintUI.this).setPressed(true);
            BaseVoicePrintUI.l(BaseVoicePrintUI.this);
            BaseVoicePrintUI.this.fEI();
            BaseVoicePrintUI.m(BaseVoicePrintUI.this).sendEmptyMessageDelayed(1, 300L);
            Log.i("MicroMsg.BaseVoicePrintUI", "mic press down");
            continue;
            BaseVoicePrintUI.f(BaseVoicePrintUI.this).setPressed(false);
            BaseVoicePrintUI.m(BaseVoicePrintUI.this).removeMessages(1);
            if (System.currentTimeMillis() - this.yKl < 300L)
            {
              Log.d("MicroMsg.BaseVoicePrintUI", "just little touch the button, set touchDown to false");
              BaseVoicePrintUI.a(BaseVoicePrintUI.this, false);
            }
            for (;;)
            {
              Log.i("MicroMsg.BaseVoicePrintUI", "mic press up %d, hasTouchDown:%b", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getAction()), Boolean.valueOf(BaseVoicePrintUI.n(BaseVoicePrintUI.this)) });
              BaseVoicePrintUI.g(BaseVoicePrintUI.this).stop();
              BaseVoicePrintUI.e(BaseVoicePrintUI.this).stopTimer();
              BaseVoicePrintUI.a(BaseVoicePrintUI.this).Qt();
              if (BaseVoicePrintUI.n(BaseVoicePrintUI.this)) {
                break label293;
              }
              BaseVoicePrintUI.c(BaseVoicePrintUI.this).setErr(2131767173);
              BaseVoicePrintUI.c(BaseVoicePrintUI.this).fEX();
              break;
              BaseVoicePrintUI.a(BaseVoicePrintUI.this, true);
            }
            label293:
            paramAnonymousView = BaseVoicePrintUI.this;
            Log.d("MicroMsg.BaseVoicePrintUI", "releaseMic");
            if (!paramAnonymousView.GRB.GRq)
            {
              paramAnonymousView.GRH.stopTimer();
              paramAnonymousView.GRA.setErr(2131767173);
              paramAnonymousView.GRA.fEX();
              paramAnonymousView.GRC = null;
            }
            paramAnonymousView.GRy.setVisibility(8);
            paramAnonymousView.GRA.fEV();
            paramAnonymousView.GRA.setTipText(paramAnonymousView.GRf);
            Log.d("MicroMsg.BaseVoicePrintUI", "localMsgFileName %s", new Object[] { BaseVoicePrintUI.d(BaseVoicePrintUI.this) });
            if (!Util.isNullOrNil(BaseVoicePrintUI.d(BaseVoicePrintUI.this))) {
              BaseVoicePrintUI.this.fEK();
            }
            this.yKl = 0L;
            this.GRL = false;
            BaseVoicePrintUI.a(BaseVoicePrintUI.this, false);
          }
        }
      }
    });
    findViewById(2131303137).setOnClickListener(new BaseVoicePrintUI.2(this));
    edG();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.GRz.GSg.stopTimer();
    Log.d("MicroMsg.VoicePrintVolumeMeter", "destroy, quit factor thread");
    Log.d("MicroMsg.VoicePrintLogic", "delete voiceprint voice file");
    o localo = new o(com.tencent.mm.plugin.voiceprint.model.m.cz("voice_pt_voice_print_record.rec", false));
    if (localo.exists()) {
      localo.delete();
    }
    localo = new o(com.tencent.mm.plugin.voiceprint.model.m.cz("voice_pt_voice_print_noise_detect.rec", false));
    if (localo.exists()) {
      localo.delete();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI
 * JD-Core Version:    0.7.0.1
 */