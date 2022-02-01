package com.tencent.mm.plugin.voiceprint.ui;

import android.app.Activity;
import android.content.Context;
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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.voiceprint.model.p;
import com.tencent.mm.plugin.voiceprint.model.p.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bd.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.e;

public abstract class BaseVoicePrintUI
  extends MMActivity
{
  String BVF = null;
  Button BVX;
  View BVY;
  VoicePrintVolumeMeter BVZ;
  VoiceTipInfoView BWa;
  p BWb = null;
  String BWc = null;
  private boolean BWd = false;
  private View BWe;
  private boolean BWf = false;
  private final p.a BWg = new p.a()
  {
    public final void eum()
    {
      AppMethodBeat.i(29811);
      p localp = BaseVoicePrintUI.a(BaseVoicePrintUI.this);
      if (localp.cXf != null)
      {
        localp.cXf.PG();
        ad.e("MicroMsg.VoicePrintRecoder", "Reset recorder.stopReocrd");
      }
      localp.fileName = "";
      localp.BVO = null;
      localp.BhZ = 0;
      localp.pto = 0L;
      localp.BVR.sX(true);
      ad.e("MicroMsg.BaseVoicePrintUI", "record stop on error");
      BaseVoicePrintUI.a(BaseVoicePrintUI.this, null);
      BaseVoicePrintUI.b(BaseVoicePrintUI.this);
      AppMethodBeat.o(29811);
    }
  };
  av BWh = new av(new av.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(29814);
      Object localObject2 = BaseVoicePrintUI.c(BaseVoicePrintUI.this);
      if (((VoiceTipInfoView)localObject2).wTc.getAnimation() == null)
      {
        TextView localTextView = ((VoiceTipInfoView)localObject2).wTc;
        Object localObject1 = ((VoiceTipInfoView)localObject2).getContext();
        localObject2 = new VoiceTipInfoView.1((VoiceTipInfoView)localObject2);
        float f = localTextView.getWidth();
        ad.d("MicroMsg.VoiceViewAnimationHelper", "target ".concat(String.valueOf(f)));
        int[] arrayOfInt = new int[2];
        localTextView.getLocationInWindow(arrayOfInt);
        int i = (int)(f + arrayOfInt[0]);
        ad.d("MicroMsg.VoiceViewAnimationHelper", "location %d %d preX=%d", new Object[] { Integer.valueOf(arrayOfInt[0]), Integer.valueOf(arrayOfInt[1]), Integer.valueOf(i) });
        localObject1 = AnimationUtils.loadAnimation((Context)localObject1, 2130772158);
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
  private ap BWi = new ap(Looper.getMainLooper(), new ap.a()
  {
    public final boolean handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(29816);
      if (paramAnonymousMessage.what == 1)
      {
        ad.d("MicroMsg.BaseVoicePrintUI", "start record");
        bd.a(aj.getContext(), 2131764377, new bd.a()
        {
          public final void onCompletion()
          {
            AppMethodBeat.i(29815);
            ad.i("MicroMsg.BaseVoicePrintUI", "play press sound end");
            AppMethodBeat.o(29815);
          }
        });
        BaseVoicePrintUI.a(BaseVoicePrintUI.this, "voice_pt_voice_print_record.rec");
        paramAnonymousMessage = BaseVoicePrintUI.a(BaseVoicePrintUI.this);
        Object localObject = BaseVoicePrintUI.d(BaseVoicePrintUI.this);
        BaseVoicePrintUI localBaseVoicePrintUI = BaseVoicePrintUI.this;
        paramAnonymousMessage.fileName = ((String)localObject);
        ad.d("MicroMsg.VoicePrintRecoder", "start filename %s", new Object[] { paramAnonymousMessage.fileName });
        paramAnonymousMessage.BVR.gz(localBaseVoicePrintUI);
        BaseVoicePrintUI.e(BaseVoicePrintUI.this).az(100L, 100L);
        paramAnonymousMessage = BaseVoicePrintUI.this;
        paramAnonymousMessage.BWa.euE();
        localObject = paramAnonymousMessage.BWa;
        ad.d("MicroMsg.VoiceTipInfoView", "hideTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", new Object[] { Integer.valueOf(((VoiceTipInfoView)localObject).lCL.getVisibility()), Boolean.valueOf(((VoiceTipInfoView)localObject).BWZ) });
        if ((((VoiceTipInfoView)localObject).lCL.getVisibility() == 0) && (!((VoiceTipInfoView)localObject).BWZ))
        {
          ((VoiceTipInfoView)localObject).lCL.clearAnimation();
          ((VoiceTipInfoView)localObject).BWZ = true;
          a.a(((VoiceTipInfoView)localObject).lCL, ((VoiceTipInfoView)localObject).getContext(), new VoiceTipInfoView.3((VoiceTipInfoView)localObject));
        }
        for (;;)
        {
          paramAnonymousMessage.BWa.setTipText(paramAnonymousMessage.BVF);
          paramAnonymousMessage.BWh.stopTimer();
          paramAnonymousMessage.BWh.az(500L, 500L);
          paramAnonymousMessage.BVY.setVisibility(0);
          paramAnonymousMessage = paramAnonymousMessage.BVZ;
          paramAnonymousMessage.reset();
          paramAnonymousMessage.mIsPlaying = true;
          localObject = paramAnonymousMessage.BWI;
          long l = VoicePrintVolumeMeter.veE;
          ((av)localObject).az(l, l);
          paramAnonymousMessage.euy();
          AppMethodBeat.o(29816);
          return true;
          ad.d("MicroMsg.VoiceTipInfoView", "hideTitle, directly set to INVISIBLE");
          ((VoiceTipInfoView)localObject).lCL.clearAnimation();
          ((VoiceTipInfoView)localObject).lCL.setVisibility(4);
          ((VoiceTipInfoView)localObject).lCL.invalidate();
        }
      }
      AppMethodBeat.o(29816);
      return false;
    }
  });
  private boolean vdD = false;
  private final av vdM = new av(new av.a()
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
      if (localp.cXf != null)
      {
        i = localp.cXf.getMaxAmplitude();
        if (i > p.diF) {
          p.diF = i;
        }
        ad.d("MicroMsg.VoicePrintRecoder", " map: " + i + " max:" + p.diF + " per:" + i * 100 / p.diF);
      }
      for (int i = i * 100 / p.diF;; i = 0)
      {
        BaseVoicePrintUI.a(BaseVoicePrintUI.this, i);
        AppMethodBeat.o(29813);
        return true;
      }
    }
  }, true);
  
  protected final void TL(int paramInt)
  {
    this.BWa.dnP();
    this.BWa.setErr(paramInt);
    this.BWa.euD();
  }
  
  protected abstract void dgW();
  
  protected final void eun()
  {
    aq.o(new Runnable()
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
  
  protected final void euo()
  {
    if ((this.BWe.getVisibility() == 4) || (this.BWe.getVisibility() == 8)) {
      return;
    }
    if (this.BWf)
    {
      this.BWe.setVisibility(4);
      return;
    }
    this.BWf = true;
    a.a(this.BWe, this, new a.a()
    {
      public final void eur() {}
      
      public final void eus()
      {
        AppMethodBeat.i(29820);
        BaseVoicePrintUI.j(BaseVoicePrintUI.this).setVisibility(4);
        BaseVoicePrintUI.k(BaseVoicePrintUI.this);
        AppMethodBeat.o(29820);
      }
    });
  }
  
  protected final void eup()
  {
    TL(2131764737);
  }
  
  protected abstract void euq();
  
  public int getLayoutId()
  {
    return 2131495864;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    hideTitleView();
    this.BWa = ((VoiceTipInfoView)findViewById(2131305873));
    this.BVX = ((Button)findViewById(2131303847));
    this.BVY = findViewById(2131306632);
    this.BVZ = ((VoicePrintVolumeMeter)findViewById(2131306633));
    this.BWe = findViewById(2131297664);
    this.BWa.euE();
    this.BVZ.setArchView(this.BVX);
    this.BWb = new p();
    this.BWb.BVS = this.BWg;
    this.BVX.setOnTouchListener(new View.OnTouchListener()
    {
      private boolean BWl = false;
      private long vek = 0L;
      
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(29821);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voiceprint/ui/BaseVoicePrintUI$9", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/voiceprint/ui/BaseVoicePrintUI$9", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(29821);
          return false;
          BaseVoicePrintUI.a(BaseVoicePrintUI.this, false);
          if (!bt.isNullOrNil(BaseVoicePrintUI.this.BVF))
          {
            this.vek = System.currentTimeMillis();
            BaseVoicePrintUI.f(BaseVoicePrintUI.this).setPressed(true);
            BaseVoicePrintUI.l(BaseVoicePrintUI.this);
            BaseVoicePrintUI.this.euo();
            BaseVoicePrintUI.m(BaseVoicePrintUI.this).sendEmptyMessageDelayed(1, 300L);
            ad.i("MicroMsg.BaseVoicePrintUI", "mic press down");
            continue;
            BaseVoicePrintUI.f(BaseVoicePrintUI.this).setPressed(false);
            BaseVoicePrintUI.m(BaseVoicePrintUI.this).removeMessages(1);
            if (System.currentTimeMillis() - this.vek < 300L)
            {
              ad.d("MicroMsg.BaseVoicePrintUI", "just little touch the button, set touchDown to false");
              BaseVoicePrintUI.a(BaseVoicePrintUI.this, false);
            }
            for (;;)
            {
              ad.i("MicroMsg.BaseVoicePrintUI", "mic press up %d, hasTouchDown:%b", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getAction()), Boolean.valueOf(BaseVoicePrintUI.n(BaseVoicePrintUI.this)) });
              BaseVoicePrintUI.g(BaseVoicePrintUI.this).stop();
              BaseVoicePrintUI.e(BaseVoicePrintUI.this).stopTimer();
              BaseVoicePrintUI.a(BaseVoicePrintUI.this).Gv();
              if (BaseVoicePrintUI.n(BaseVoicePrintUI.this)) {
                break label342;
              }
              BaseVoicePrintUI.c(BaseVoicePrintUI.this).setErr(2131764736);
              BaseVoicePrintUI.c(BaseVoicePrintUI.this).euD();
              break;
              BaseVoicePrintUI.a(BaseVoicePrintUI.this, true);
            }
            label342:
            paramAnonymousView = BaseVoicePrintUI.this;
            ad.d("MicroMsg.BaseVoicePrintUI", "releaseMic");
            if (!paramAnonymousView.BWb.BVQ)
            {
              paramAnonymousView.BWh.stopTimer();
              paramAnonymousView.BWa.setErr(2131764736);
              paramAnonymousView.BWa.euD();
              paramAnonymousView.BWc = null;
            }
            paramAnonymousView.BVY.setVisibility(8);
            paramAnonymousView.BWa.euB();
            paramAnonymousView.BWa.setTipText(paramAnonymousView.BVF);
            ad.d("MicroMsg.BaseVoicePrintUI", "localMsgFileName %s", new Object[] { BaseVoicePrintUI.d(BaseVoicePrintUI.this) });
            if (!bt.isNullOrNil(BaseVoicePrintUI.d(BaseVoicePrintUI.this))) {
              BaseVoicePrintUI.this.euq();
            }
            this.vek = 0L;
            this.BWl = false;
            BaseVoicePrintUI.a(BaseVoicePrintUI.this, false);
          }
        }
      }
    });
    findViewById(2131301383).setOnClickListener(new BaseVoicePrintUI.2(this));
    dgW();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.BVZ.BWI.stopTimer();
    ad.d("MicroMsg.VoicePrintVolumeMeter", "destroy, quit factor thread");
    ad.d("MicroMsg.VoicePrintLogic", "delete voiceprint voice file");
    e locale = new e(com.tencent.mm.plugin.voiceprint.model.m.cd("voice_pt_voice_print_record.rec", false));
    if (locale.exists()) {
      locale.delete();
    }
    locale = new e(com.tencent.mm.plugin.voiceprint.model.m.cd("voice_pt_voice_print_noise_detect.rec", false));
    if (locale.exists()) {
      locale.delete();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI
 * JD-Core Version:    0.7.0.1
 */