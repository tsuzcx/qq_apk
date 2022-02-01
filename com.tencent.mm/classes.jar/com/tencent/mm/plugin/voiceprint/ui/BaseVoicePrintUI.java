package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.voiceprint.model.p;
import com.tencent.mm.plugin.voiceprint.model.p.a;
import com.tencent.mm.pluginsdk.permission.b;
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
import com.tencent.mm.vfs.u;

public abstract class BaseVoicePrintUI
  extends MMActivity
{
  private boolean Kgf = false;
  private final MTimerHandler Kgo = new MTimerHandler(new MTimerHandler.CallBack()
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
      if (localp.hlu != null)
      {
        i = localp.hlu.aGI();
        if (i > p.hxV) {
          p.hxV = i;
        }
        Log.d("MicroMsg.VoicePrintRecoder", " map: " + i + " max:" + p.hxV + " per:" + i * 100 / p.hxV);
      }
      for (int i = i * 100 / p.hxV;; i = 0)
      {
        BaseVoicePrintUI.a(BaseVoicePrintUI.this, i);
        AppMethodBeat.o(29813);
        return true;
      }
    }
  }, true);
  Button UtI;
  View UtJ;
  VoicePrintVolumeMeter UtK;
  VoiceTipInfoView UtL;
  p UtM = null;
  String UtN = null;
  private boolean UtO = false;
  private View UtP;
  private boolean UtQ = false;
  private final p.a UtR = new p.a()
  {
    public final void hUQ()
    {
      AppMethodBeat.i(29811);
      p localp = BaseVoicePrintUI.a(BaseVoicePrintUI.this);
      if (localp.hlu != null)
      {
        localp.hlu.aGH();
        Log.e("MicroMsg.VoicePrintRecoder", "Reset recorder.stopReocrd");
      }
      localp.fileName = "";
      localp.Utz = null;
      localp.SFv = 0;
      localp.xxM = 0L;
      localp.UtC.Ge(true);
      Log.e("MicroMsg.BaseVoicePrintUI", "record stop on error");
      BaseVoicePrintUI.a(BaseVoicePrintUI.this, null);
      BaseVoicePrintUI.b(BaseVoicePrintUI.this);
      AppMethodBeat.o(29811);
    }
  };
  MTimerHandler UtS = new MTimerHandler(new MTimerHandler.CallBack()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(29814);
      Object localObject2 = BaseVoicePrintUI.c(BaseVoicePrintUI.this);
      if (((VoiceTipInfoView)localObject2).MYG.getAnimation() == null)
      {
        TextView localTextView = ((VoiceTipInfoView)localObject2).MYG;
        Object localObject1 = ((VoiceTipInfoView)localObject2).getContext();
        localObject2 = new VoiceTipInfoView.1((VoiceTipInfoView)localObject2);
        float f = localTextView.getWidth();
        Log.d("MicroMsg.VoiceViewAnimationHelper", "target ".concat(String.valueOf(f)));
        int[] arrayOfInt = new int[2];
        localTextView.getLocationInWindow(arrayOfInt);
        int i = (int)(f + arrayOfInt[0]);
        Log.d("MicroMsg.VoiceViewAnimationHelper", "location %d %d preX=%d", new Object[] { Integer.valueOf(arrayOfInt[0]), Integer.valueOf(arrayOfInt[1]), Integer.valueOf(i) });
        localObject1 = AnimationUtils.loadAnimation((Context)localObject1, R.a.fjE);
        ((Animation)localObject1).setDuration(200L);
        ((Animation)localObject1).setStartOffset(0L);
        ((Animation)localObject1).setRepeatCount(0);
        ((Animation)localObject1).setFillAfter(true);
        ((Animation)localObject1).setAnimationListener(new a.1((a.a)localObject2));
        localTextView.startAnimation((Animation)localObject1);
      }
      AppMethodBeat.o(29814);
      return false;
    }
  }, true);
  private MMHandler UtT = new MMHandler(Looper.getMainLooper(), new MMHandler.Callback()
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
        paramAnonymousMessage.UtC.kv(localBaseVoicePrintUI);
        BaseVoicePrintUI.e(BaseVoicePrintUI.this).startTimer(100L);
        paramAnonymousMessage = BaseVoicePrintUI.this;
        paramAnonymousMessage.UtL.hFl();
        localObject = paramAnonymousMessage.UtL;
        Log.d("MicroMsg.VoiceTipInfoView", "hideTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", new Object[] { Integer.valueOf(((VoiceTipInfoView)localObject).sUt.getVisibility()), Boolean.valueOf(((VoiceTipInfoView)localObject).UuK) });
        if ((((VoiceTipInfoView)localObject).sUt.getVisibility() == 0) && (!((VoiceTipInfoView)localObject).UuK))
        {
          ((VoiceTipInfoView)localObject).sUt.clearAnimation();
          ((VoiceTipInfoView)localObject).UuK = true;
          a.a(((VoiceTipInfoView)localObject).sUt, ((VoiceTipInfoView)localObject).getContext(), new VoiceTipInfoView.3((VoiceTipInfoView)localObject));
        }
        for (;;)
        {
          paramAnonymousMessage.UtL.setTipText(paramAnonymousMessage.Utq);
          paramAnonymousMessage.UtS.stopTimer();
          paramAnonymousMessage.UtS.startTimer(500L);
          paramAnonymousMessage.UtJ.setVisibility(0);
          paramAnonymousMessage = paramAnonymousMessage.UtK;
          paramAnonymousMessage.reset();
          paramAnonymousMessage.qRV = true;
          paramAnonymousMessage.Uut.startTimer(VoicePrintVolumeMeter.Khd);
          paramAnonymousMessage.hVc();
          AppMethodBeat.o(29816);
          return true;
          Log.d("MicroMsg.VoiceTipInfoView", "hideTitle, directly set to INVISIBLE");
          ((VoiceTipInfoView)localObject).sUt.clearAnimation();
          ((VoiceTipInfoView)localObject).sUt.setVisibility(4);
          ((VoiceTipInfoView)localObject).sUt.invalidate();
        }
      }
      AppMethodBeat.o(29816);
      return false;
    }
  });
  String Utq = null;
  
  protected final void apQ(int paramInt)
  {
    this.UtL.gdb();
    this.UtL.setErr(paramInt);
    this.UtL.hVg();
  }
  
  protected final void bfG(String paramString)
  {
    this.UtL.gdb();
    this.UtL.setErr(paramString);
    this.UtL.hVg();
  }
  
  protected abstract void fVu();
  
  public int getLayoutId()
  {
    return R.i.goV;
  }
  
  protected final void hUR()
  {
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29818);
        if (!BaseVoicePrintUI.g(BaseVoicePrintUI.this)) {
          BaseVoicePrintUI.h(BaseVoicePrintUI.this);
        }
        AppMethodBeat.o(29818);
      }
    }, 1300L);
  }
  
  protected final void hUS()
  {
    if ((this.UtP.getVisibility() == 4) || (this.UtP.getVisibility() == 8)) {
      return;
    }
    if (this.UtQ)
    {
      this.UtP.setVisibility(4);
      return;
    }
    this.UtQ = true;
    a.a(this.UtP, this, new a.a()
    {
      public final void hUV() {}
      
      public final void hUW()
      {
        AppMethodBeat.i(29820);
        BaseVoicePrintUI.i(BaseVoicePrintUI.this).setVisibility(4);
        BaseVoicePrintUI.j(BaseVoicePrintUI.this);
        AppMethodBeat.o(29820);
      }
    });
  }
  
  protected final void hUT()
  {
    apQ(R.l.gYd);
  }
  
  protected abstract void hUU();
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    hideActionbarLine();
    setActionbarColor(getResources().getColor(R.e.white));
    hideTitleView();
    this.UtL = ((VoiceTipInfoView)findViewById(R.h.fZX));
    this.UtI = ((Button)findViewById(R.h.fUp));
    this.UtJ = findViewById(R.h.volume_layout);
    this.UtK = ((VoicePrintVolumeMeter)findViewById(R.h.volume_meter));
    this.UtP = findViewById(R.h.fvh);
    this.UtL.hFl();
    this.UtK.setArchView(this.UtI);
    this.UtM = new p();
    this.UtM.UtD = this.UtR;
    this.UtI.setOnTouchListener(new View.OnTouchListener()
    {
      private long KgK = 0L;
      private boolean UtW = false;
      boolean UtX = false;
      
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
          this.UtX = b.a(BaseVoicePrintUI.this.getContext(), "android.permission.RECORD_AUDIO", 80, BaseVoicePrintUI.this.getString(R.l.gUZ));
          if (!this.UtX)
          {
            AppMethodBeat.o(29821);
            return true;
          }
          BaseVoicePrintUI.a(BaseVoicePrintUI.this, false);
          if (!Util.isNullOrNil(BaseVoicePrintUI.this.Utq))
          {
            this.KgK = System.currentTimeMillis();
            BaseVoicePrintUI.k(BaseVoicePrintUI.this).setPressed(true);
            BaseVoicePrintUI.l(BaseVoicePrintUI.this);
            BaseVoicePrintUI.this.hUS();
            BaseVoicePrintUI.m(BaseVoicePrintUI.this).sendEmptyMessageDelayed(1, 300L);
            Log.i("MicroMsg.BaseVoicePrintUI", "mic press down");
            continue;
            if (!this.UtX)
            {
              AppMethodBeat.o(29821);
              return true;
            }
            BaseVoicePrintUI.k(BaseVoicePrintUI.this).setPressed(false);
            BaseVoicePrintUI.m(BaseVoicePrintUI.this).removeMessages(1);
            if (System.currentTimeMillis() - this.KgK < 300L)
            {
              Log.d("MicroMsg.BaseVoicePrintUI", "just little touch the button, set touchDown to false");
              BaseVoicePrintUI.a(BaseVoicePrintUI.this, false);
            }
            for (;;)
            {
              Log.i("MicroMsg.BaseVoicePrintUI", "mic press up %d, hasTouchDown:%b", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getAction()), Boolean.valueOf(BaseVoicePrintUI.n(BaseVoicePrintUI.this)) });
              BaseVoicePrintUI.f(BaseVoicePrintUI.this).stop();
              BaseVoicePrintUI.e(BaseVoicePrintUI.this).stopTimer();
              BaseVoicePrintUI.a(BaseVoicePrintUI.this).stop();
              if (BaseVoicePrintUI.n(BaseVoicePrintUI.this)) {
                break label352;
              }
              BaseVoicePrintUI.c(BaseVoicePrintUI.this).setErr(R.l.gYc);
              BaseVoicePrintUI.c(BaseVoicePrintUI.this).hVg();
              break;
              BaseVoicePrintUI.a(BaseVoicePrintUI.this, true);
            }
            label352:
            paramAnonymousView = BaseVoicePrintUI.this;
            Log.d("MicroMsg.BaseVoicePrintUI", "releaseMic");
            if (!paramAnonymousView.UtM.UtB)
            {
              paramAnonymousView.UtS.stopTimer();
              paramAnonymousView.UtL.setErr(R.l.gYc);
              paramAnonymousView.UtL.hVg();
              paramAnonymousView.UtN = null;
            }
            paramAnonymousView.UtJ.setVisibility(8);
            paramAnonymousView.UtL.hVe();
            paramAnonymousView.UtL.setTipText(paramAnonymousView.Utq);
            Log.d("MicroMsg.BaseVoicePrintUI", "localMsgFileName %s", new Object[] { BaseVoicePrintUI.d(BaseVoicePrintUI.this) });
            if (!Util.isNullOrNil(BaseVoicePrintUI.d(BaseVoicePrintUI.this))) {
              BaseVoicePrintUI.this.hUU();
            }
            this.KgK = 0L;
            this.UtW = false;
            BaseVoicePrintUI.a(BaseVoicePrintUI.this, false);
          }
        }
      }
    });
    findViewById(R.h.left_btn).setOnClickListener(new BaseVoicePrintUI.2(this));
    fVu();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.UtK.Uut.stopTimer();
    Log.d("MicroMsg.VoicePrintVolumeMeter", "destroy, quit factor thread");
    Log.d("MicroMsg.VoicePrintLogic", "delete voiceprint voice file");
    u localu = new u(com.tencent.mm.plugin.voiceprint.model.m.dt("voice_pt_voice_print_record.rec", false));
    if (localu.jKS()) {
      localu.diJ();
    }
    localu = new u(com.tencent.mm.plugin.voiceprint.model.m.dt("voice_pt_voice_print_noise_detect.rec", false));
    if (localu.jKS()) {
      localu.diJ();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
      Log.i("MicroMsg.BaseVoicePrintUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
    }
    do
    {
      return;
      switch (paramInt)
      {
      default: 
        return;
      }
    } while (paramArrayOfInt[0] == 0);
    this.UtR.hUQ();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI
 * JD-Core Version:    0.7.0.1
 */