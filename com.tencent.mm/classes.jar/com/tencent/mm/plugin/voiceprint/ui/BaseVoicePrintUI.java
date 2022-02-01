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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
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
import com.tencent.mm.vfs.q;

public abstract class BaseVoicePrintUI
  extends MMActivity
{
  private final MTimerHandler EnG = new MTimerHandler(new MTimerHandler.CallBack()
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
      if (localp.fhj != null)
      {
        i = localp.fhj.aeK();
        if (i > p.ftG) {
          p.ftG = i;
        }
        Log.d("MicroMsg.VoicePrintRecoder", " map: " + i + " max:" + p.ftG + " per:" + i * 100 / p.ftG);
      }
      for (int i = i * 100 / p.ftG;; i = 0)
      {
        BaseVoicePrintUI.a(BaseVoicePrintUI.this, i);
        AppMethodBeat.o(29813);
        return true;
      }
    }
  }, true);
  private boolean Enx = false;
  Button NHI;
  View NHJ;
  VoicePrintVolumeMeter NHK;
  VoiceTipInfoView NHL;
  p NHM = null;
  String NHN = null;
  private boolean NHO = false;
  private View NHP;
  private boolean NHQ = false;
  private final p.a NHR = new p.a()
  {
    public final void gwT()
    {
      AppMethodBeat.i(29811);
      p localp = BaseVoicePrintUI.a(BaseVoicePrintUI.this);
      if (localp.fhj != null)
      {
        localp.fhj.aeJ();
        Log.e("MicroMsg.VoicePrintRecoder", "Reset recorder.stopReocrd");
      }
      localp.fileName = "";
      localp.NHz = null;
      localp.Mef = 0;
      localp.urr = 0L;
      localp.NHC.AF(true);
      Log.e("MicroMsg.BaseVoicePrintUI", "record stop on error");
      BaseVoicePrintUI.a(BaseVoicePrintUI.this, null);
      BaseVoicePrintUI.b(BaseVoicePrintUI.this);
      AppMethodBeat.o(29811);
    }
  };
  MTimerHandler NHS = new MTimerHandler(new BaseVoicePrintUI.4(this), true);
  private MMHandler NHT = new MMHandler(Looper.getMainLooper(), new MMHandler.Callback()
  {
    public final boolean handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(29816);
      if (paramAnonymousMessage.what == 1)
      {
        Log.d("MicroMsg.BaseVoicePrintUI", "start record");
        PlaySound.play(MMApplicationContext.getContext(), R.l.talkroom_press, new PlaySound.OnPlayCompletionListener()
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
        paramAnonymousMessage.NHC.iD(localBaseVoicePrintUI);
        BaseVoicePrintUI.e(BaseVoicePrintUI.this).startTimer(100L);
        paramAnonymousMessage = BaseVoicePrintUI.this;
        paramAnonymousMessage.NHL.gxk();
        localObject = paramAnonymousMessage.NHL;
        Log.d("MicroMsg.VoiceTipInfoView", "hideTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", new Object[] { Integer.valueOf(((VoiceTipInfoView)localObject).pPT.getVisibility()), Boolean.valueOf(((VoiceTipInfoView)localObject).NII) });
        if ((((VoiceTipInfoView)localObject).pPT.getVisibility() == 0) && (!((VoiceTipInfoView)localObject).NII))
        {
          ((VoiceTipInfoView)localObject).pPT.clearAnimation();
          ((VoiceTipInfoView)localObject).NII = true;
          a.a(((VoiceTipInfoView)localObject).pPT, ((VoiceTipInfoView)localObject).getContext(), new VoiceTipInfoView.3((VoiceTipInfoView)localObject));
        }
        for (;;)
        {
          paramAnonymousMessage.NHL.setTipText(paramAnonymousMessage.NHq);
          paramAnonymousMessage.NHS.stopTimer();
          paramAnonymousMessage.NHS.startTimer(500L);
          paramAnonymousMessage.NHJ.setVisibility(0);
          paramAnonymousMessage = paramAnonymousMessage.NHK;
          paramAnonymousMessage.reset();
          paramAnonymousMessage.jxX = true;
          paramAnonymousMessage.NIr.startTimer(VoicePrintVolumeMeter.Eox);
          paramAnonymousMessage.gxf();
          AppMethodBeat.o(29816);
          return true;
          Log.d("MicroMsg.VoiceTipInfoView", "hideTitle, directly set to INVISIBLE");
          ((VoiceTipInfoView)localObject).pPT.clearAnimation();
          ((VoiceTipInfoView)localObject).pPT.setVisibility(4);
          ((VoiceTipInfoView)localObject).pPT.invalidate();
        }
      }
      AppMethodBeat.o(29816);
      return false;
    }
  });
  String NHq = null;
  
  protected final void akv(int paramInt)
  {
    this.NHL.eUn();
    this.NHL.setErr(paramInt);
    this.NHL.gxj();
  }
  
  protected final void bga(String paramString)
  {
    this.NHL.eUn();
    this.NHL.setErr(paramString);
    this.NHL.gxj();
  }
  
  protected abstract void eNb();
  
  public int getLayoutId()
  {
    return R.i.elR;
  }
  
  protected final void gwU()
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
  
  protected final void gwV()
  {
    if ((this.NHP.getVisibility() == 4) || (this.NHP.getVisibility() == 8)) {
      return;
    }
    if (this.NHQ)
    {
      this.NHP.setVisibility(4);
      return;
    }
    this.NHQ = true;
    a.a(this.NHP, this, new a.a()
    {
      public final void gwY() {}
      
      public final void gwZ()
      {
        AppMethodBeat.i(29820);
        BaseVoicePrintUI.j(BaseVoicePrintUI.this).setVisibility(4);
        BaseVoicePrintUI.k(BaseVoicePrintUI.this);
        AppMethodBeat.o(29820);
      }
    });
  }
  
  protected final void gwW()
  {
    akv(R.l.eUZ);
  }
  
  protected abstract void gwX();
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    hideTitleView();
    this.NHL = ((VoiceTipInfoView)findViewById(R.h.dXs));
    this.NHI = ((Button)findViewById(R.h.dSp));
    this.NHJ = findViewById(R.h.volume_layout);
    this.NHK = ((VoicePrintVolumeMeter)findViewById(R.h.volume_meter));
    this.NHP = findViewById(R.h.duP);
    this.NHL.gxk();
    this.NHK.setArchView(this.NHI);
    this.NHM = new p();
    this.NHM.NHD = this.NHR;
    this.NHI.setOnTouchListener(new View.OnTouchListener()
    {
      private long Eoe = 0L;
      private boolean NHW = false;
      
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
          if (!Util.isNullOrNil(BaseVoicePrintUI.this.NHq))
          {
            this.Eoe = System.currentTimeMillis();
            BaseVoicePrintUI.f(BaseVoicePrintUI.this).setPressed(true);
            BaseVoicePrintUI.l(BaseVoicePrintUI.this);
            BaseVoicePrintUI.this.gwV();
            BaseVoicePrintUI.m(BaseVoicePrintUI.this).sendEmptyMessageDelayed(1, 300L);
            Log.i("MicroMsg.BaseVoicePrintUI", "mic press down");
            continue;
            BaseVoicePrintUI.f(BaseVoicePrintUI.this).setPressed(false);
            BaseVoicePrintUI.m(BaseVoicePrintUI.this).removeMessages(1);
            if (System.currentTimeMillis() - this.Eoe < 300L)
            {
              Log.d("MicroMsg.BaseVoicePrintUI", "just little touch the button, set touchDown to false");
              BaseVoicePrintUI.a(BaseVoicePrintUI.this, false);
            }
            for (;;)
            {
              Log.i("MicroMsg.BaseVoicePrintUI", "mic press up %d, hasTouchDown:%b", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getAction()), Boolean.valueOf(BaseVoicePrintUI.n(BaseVoicePrintUI.this)) });
              BaseVoicePrintUI.g(BaseVoicePrintUI.this).stop();
              BaseVoicePrintUI.e(BaseVoicePrintUI.this).stopTimer();
              BaseVoicePrintUI.a(BaseVoicePrintUI.this).TV();
              if (BaseVoicePrintUI.n(BaseVoicePrintUI.this)) {
                break label294;
              }
              BaseVoicePrintUI.c(BaseVoicePrintUI.this).setErr(R.l.eUY);
              BaseVoicePrintUI.c(BaseVoicePrintUI.this).gxj();
              break;
              BaseVoicePrintUI.a(BaseVoicePrintUI.this, true);
            }
            label294:
            paramAnonymousView = BaseVoicePrintUI.this;
            Log.d("MicroMsg.BaseVoicePrintUI", "releaseMic");
            if (!paramAnonymousView.NHM.NHB)
            {
              paramAnonymousView.NHS.stopTimer();
              paramAnonymousView.NHL.setErr(R.l.eUY);
              paramAnonymousView.NHL.gxj();
              paramAnonymousView.NHN = null;
            }
            paramAnonymousView.NHJ.setVisibility(8);
            paramAnonymousView.NHL.gxh();
            paramAnonymousView.NHL.setTipText(paramAnonymousView.NHq);
            Log.d("MicroMsg.BaseVoicePrintUI", "localMsgFileName %s", new Object[] { BaseVoicePrintUI.d(BaseVoicePrintUI.this) });
            if (!Util.isNullOrNil(BaseVoicePrintUI.d(BaseVoicePrintUI.this))) {
              BaseVoicePrintUI.this.gwX();
            }
            this.Eoe = 0L;
            this.NHW = false;
            BaseVoicePrintUI.a(BaseVoicePrintUI.this, false);
          }
        }
      }
    });
    findViewById(R.h.left_btn).setOnClickListener(new BaseVoicePrintUI.2(this));
    eNb();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.NHK.NIr.stopTimer();
    Log.d("MicroMsg.VoicePrintVolumeMeter", "destroy, quit factor thread");
    Log.d("MicroMsg.VoicePrintLogic", "delete voiceprint voice file");
    q localq = new q(com.tencent.mm.plugin.voiceprint.model.m.cN("voice_pt_voice_print_record.rec", false));
    if (localq.ifE()) {
      localq.cFq();
    }
    localq = new q(com.tencent.mm.plugin.voiceprint.model.m.cN("voice_pt_voice_print_noise_detect.rec", false));
    if (localq.ifE()) {
      localq.cFq();
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