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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.be.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.k;

public abstract class BaseVoicePrintUI
  extends MMActivity
{
  VoicePrintVolumeMeter CnA;
  VoiceTipInfoView CnB;
  p CnC = null;
  String CnD = null;
  private boolean CnE = false;
  private View CnF;
  private boolean CnG = false;
  private final p.a CnH = new p.a()
  {
    public final void exS()
    {
      AppMethodBeat.i(29811);
      p localp = BaseVoicePrintUI.a(BaseVoicePrintUI.this);
      if (localp.cYc != null)
      {
        localp.cYc.PF();
        ae.e("MicroMsg.VoicePrintRecoder", "Reset recorder.stopReocrd");
      }
      localp.fileName = "";
      localp.Cnp = null;
      localp.Bzx = 0;
      localp.pzU = 0L;
      localp.Cns.te(true);
      ae.e("MicroMsg.BaseVoicePrintUI", "record stop on error");
      BaseVoicePrintUI.a(BaseVoicePrintUI.this, null);
      BaseVoicePrintUI.b(BaseVoicePrintUI.this);
      AppMethodBeat.o(29811);
    }
  };
  aw CnI = new aw(new aw.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(29814);
      Object localObject2 = BaseVoicePrintUI.c(BaseVoicePrintUI.this);
      if (((VoiceTipInfoView)localObject2).xiT.getAnimation() == null)
      {
        TextView localTextView = ((VoiceTipInfoView)localObject2).xiT;
        Object localObject1 = ((VoiceTipInfoView)localObject2).getContext();
        localObject2 = new VoiceTipInfoView.1((VoiceTipInfoView)localObject2);
        float f = localTextView.getWidth();
        ae.d("MicroMsg.VoiceViewAnimationHelper", "target ".concat(String.valueOf(f)));
        int[] arrayOfInt = new int[2];
        localTextView.getLocationInWindow(arrayOfInt);
        int i = (int)(f + arrayOfInt[0]);
        ae.d("MicroMsg.VoiceViewAnimationHelper", "location %d %d preX=%d", new Object[] { Integer.valueOf(arrayOfInt[0]), Integer.valueOf(arrayOfInt[1]), Integer.valueOf(i) });
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
  private aq CnJ = new aq(Looper.getMainLooper(), new aq.a()
  {
    public final boolean handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(29816);
      if (paramAnonymousMessage.what == 1)
      {
        ae.d("MicroMsg.BaseVoicePrintUI", "start record");
        be.a(ak.getContext(), 2131764377, new be.a()
        {
          public final void onCompletion()
          {
            AppMethodBeat.i(29815);
            ae.i("MicroMsg.BaseVoicePrintUI", "play press sound end");
            AppMethodBeat.o(29815);
          }
        });
        BaseVoicePrintUI.a(BaseVoicePrintUI.this, "voice_pt_voice_print_record.rec");
        paramAnonymousMessage = BaseVoicePrintUI.a(BaseVoicePrintUI.this);
        Object localObject = BaseVoicePrintUI.d(BaseVoicePrintUI.this);
        BaseVoicePrintUI localBaseVoicePrintUI = BaseVoicePrintUI.this;
        paramAnonymousMessage.fileName = ((String)localObject);
        ae.d("MicroMsg.VoicePrintRecoder", "start filename %s", new Object[] { paramAnonymousMessage.fileName });
        paramAnonymousMessage.Cns.gE(localBaseVoicePrintUI);
        BaseVoicePrintUI.e(BaseVoicePrintUI.this).ay(100L, 100L);
        paramAnonymousMessage = BaseVoicePrintUI.this;
        paramAnonymousMessage.CnB.eyk();
        localObject = paramAnonymousMessage.CnB;
        ae.d("MicroMsg.VoiceTipInfoView", "hideTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", new Object[] { Integer.valueOf(((VoiceTipInfoView)localObject).lHk.getVisibility()), Boolean.valueOf(((VoiceTipInfoView)localObject).CoA) });
        if ((((VoiceTipInfoView)localObject).lHk.getVisibility() == 0) && (!((VoiceTipInfoView)localObject).CoA))
        {
          ((VoiceTipInfoView)localObject).lHk.clearAnimation();
          ((VoiceTipInfoView)localObject).CoA = true;
          a.a(((VoiceTipInfoView)localObject).lHk, ((VoiceTipInfoView)localObject).getContext(), new VoiceTipInfoView.3((VoiceTipInfoView)localObject));
        }
        for (;;)
        {
          paramAnonymousMessage.CnB.setTipText(paramAnonymousMessage.Cng);
          paramAnonymousMessage.CnI.stopTimer();
          paramAnonymousMessage.CnI.ay(500L, 500L);
          paramAnonymousMessage.Cnz.setVisibility(0);
          paramAnonymousMessage = paramAnonymousMessage.CnA;
          paramAnonymousMessage.reset();
          paramAnonymousMessage.mIsPlaying = true;
          localObject = paramAnonymousMessage.Coj;
          long l = VoicePrintVolumeMeter.vqO;
          ((aw)localObject).ay(l, l);
          paramAnonymousMessage.eye();
          AppMethodBeat.o(29816);
          return true;
          ae.d("MicroMsg.VoiceTipInfoView", "hideTitle, directly set to INVISIBLE");
          ((VoiceTipInfoView)localObject).lHk.clearAnimation();
          ((VoiceTipInfoView)localObject).lHk.setVisibility(4);
          ((VoiceTipInfoView)localObject).lHk.invalidate();
        }
      }
      AppMethodBeat.o(29816);
      return false;
    }
  });
  String Cng = null;
  Button Cny;
  View Cnz;
  private boolean vpO = false;
  private final aw vpX = new aw(new aw.a()
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
      if (localp.cYc != null)
      {
        i = localp.cYc.getMaxAmplitude();
        if (i > p.djH) {
          p.djH = i;
        }
        ae.d("MicroMsg.VoicePrintRecoder", " map: " + i + " max:" + p.djH + " per:" + i * 100 / p.djH);
      }
      for (int i = i * 100 / p.djH;; i = 0)
      {
        BaseVoicePrintUI.a(BaseVoicePrintUI.this, i);
        AppMethodBeat.o(29813);
        return true;
      }
    }
  }, true);
  
  protected final void Us(int paramInt)
  {
    this.CnB.dqN();
    this.CnB.setErr(paramInt);
    this.CnB.eyj();
  }
  
  protected abstract void djV();
  
  protected final void exT()
  {
    ar.o(new Runnable()
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
  
  protected final void exU()
  {
    if ((this.CnF.getVisibility() == 4) || (this.CnF.getVisibility() == 8)) {
      return;
    }
    if (this.CnG)
    {
      this.CnF.setVisibility(4);
      return;
    }
    this.CnG = true;
    a.a(this.CnF, this, new a.a()
    {
      public final void exX() {}
      
      public final void exY()
      {
        AppMethodBeat.i(29820);
        BaseVoicePrintUI.j(BaseVoicePrintUI.this).setVisibility(4);
        BaseVoicePrintUI.k(BaseVoicePrintUI.this);
        AppMethodBeat.o(29820);
      }
    });
  }
  
  protected final void exV()
  {
    Us(2131764737);
  }
  
  protected abstract void exW();
  
  public int getLayoutId()
  {
    return 2131495864;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    hideTitleView();
    this.CnB = ((VoiceTipInfoView)findViewById(2131305873));
    this.Cny = ((Button)findViewById(2131303847));
    this.Cnz = findViewById(2131306632);
    this.CnA = ((VoicePrintVolumeMeter)findViewById(2131306633));
    this.CnF = findViewById(2131297664);
    this.CnB.eyk();
    this.CnA.setArchView(this.Cny);
    this.CnC = new p();
    this.CnC.Cnt = this.CnH;
    this.Cny.setOnTouchListener(new View.OnTouchListener()
    {
      private boolean CnM = false;
      private long vqv = 0L;
      
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(29821);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voiceprint/ui/BaseVoicePrintUI$9", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/voiceprint/ui/BaseVoicePrintUI$9", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(29821);
          return false;
          BaseVoicePrintUI.a(BaseVoicePrintUI.this, false);
          if (!bu.isNullOrNil(BaseVoicePrintUI.this.Cng))
          {
            this.vqv = System.currentTimeMillis();
            BaseVoicePrintUI.f(BaseVoicePrintUI.this).setPressed(true);
            BaseVoicePrintUI.l(BaseVoicePrintUI.this);
            BaseVoicePrintUI.this.exU();
            BaseVoicePrintUI.m(BaseVoicePrintUI.this).sendEmptyMessageDelayed(1, 300L);
            ae.i("MicroMsg.BaseVoicePrintUI", "mic press down");
            continue;
            BaseVoicePrintUI.f(BaseVoicePrintUI.this).setPressed(false);
            BaseVoicePrintUI.m(BaseVoicePrintUI.this).removeMessages(1);
            if (System.currentTimeMillis() - this.vqv < 300L)
            {
              ae.d("MicroMsg.BaseVoicePrintUI", "just little touch the button, set touchDown to false");
              BaseVoicePrintUI.a(BaseVoicePrintUI.this, false);
            }
            for (;;)
            {
              ae.i("MicroMsg.BaseVoicePrintUI", "mic press up %d, hasTouchDown:%b", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getAction()), Boolean.valueOf(BaseVoicePrintUI.n(BaseVoicePrintUI.this)) });
              BaseVoicePrintUI.g(BaseVoicePrintUI.this).stop();
              BaseVoicePrintUI.e(BaseVoicePrintUI.this).stopTimer();
              BaseVoicePrintUI.a(BaseVoicePrintUI.this).GB();
              if (BaseVoicePrintUI.n(BaseVoicePrintUI.this)) {
                break label342;
              }
              BaseVoicePrintUI.c(BaseVoicePrintUI.this).setErr(2131764736);
              BaseVoicePrintUI.c(BaseVoicePrintUI.this).eyj();
              break;
              BaseVoicePrintUI.a(BaseVoicePrintUI.this, true);
            }
            label342:
            paramAnonymousView = BaseVoicePrintUI.this;
            ae.d("MicroMsg.BaseVoicePrintUI", "releaseMic");
            if (!paramAnonymousView.CnC.Cnr)
            {
              paramAnonymousView.CnI.stopTimer();
              paramAnonymousView.CnB.setErr(2131764736);
              paramAnonymousView.CnB.eyj();
              paramAnonymousView.CnD = null;
            }
            paramAnonymousView.Cnz.setVisibility(8);
            paramAnonymousView.CnB.eyh();
            paramAnonymousView.CnB.setTipText(paramAnonymousView.Cng);
            ae.d("MicroMsg.BaseVoicePrintUI", "localMsgFileName %s", new Object[] { BaseVoicePrintUI.d(BaseVoicePrintUI.this) });
            if (!bu.isNullOrNil(BaseVoicePrintUI.d(BaseVoicePrintUI.this))) {
              BaseVoicePrintUI.this.exW();
            }
            this.vqv = 0L;
            this.CnM = false;
            BaseVoicePrintUI.a(BaseVoicePrintUI.this, false);
          }
        }
      }
    });
    findViewById(2131301383).setOnClickListener(new BaseVoicePrintUI.2(this));
    djV();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.CnA.Coj.stopTimer();
    ae.d("MicroMsg.VoicePrintVolumeMeter", "destroy, quit factor thread");
    ae.d("MicroMsg.VoicePrintLogic", "delete voiceprint voice file");
    k localk = new k(com.tencent.mm.plugin.voiceprint.model.m.ch("voice_pt_voice_print_record.rec", false));
    if (localk.exists()) {
      localk.delete();
    }
    localk = new k(com.tencent.mm.plugin.voiceprint.model.m.ch("voice_pt_voice_print_noise_detect.rec", false));
    if (localk.exists()) {
      localk.delete();
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