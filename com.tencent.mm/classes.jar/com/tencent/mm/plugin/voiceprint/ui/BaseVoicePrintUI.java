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
import com.tencent.mm.plugin.voiceprint.model.p;
import com.tencent.mm.plugin.voiceprint.model.p.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ao.a;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bc.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.e;

public abstract class BaseVoicePrintUI
  extends MMActivity
{
  Button AwC;
  View AwD;
  VoicePrintVolumeMeter AwE;
  VoiceTipInfoView AwF;
  p AwG = null;
  String AwH = null;
  private boolean AwI = false;
  private View AwJ;
  private boolean AwK = false;
  private final p.a AwL = new p.a()
  {
    public final void egB()
    {
      AppMethodBeat.i(29811);
      p localp = BaseVoicePrintUI.a(BaseVoicePrintUI.this);
      if (localp.cLR != null)
      {
        localp.cLR.NX();
        ac.e("MicroMsg.VoicePrintRecoder", "Reset recorder.stopReocrd");
      }
      localp.fileName = "";
      localp.Awt = null;
      localp.zQy = 0;
      localp.oPG = 0L;
      localp.Aww.so(true);
      ac.e("MicroMsg.BaseVoicePrintUI", "record stop on error");
      BaseVoicePrintUI.a(BaseVoicePrintUI.this, null);
      BaseVoicePrintUI.b(BaseVoicePrintUI.this);
      AppMethodBeat.o(29811);
    }
  };
  au AwM = new au(new au.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(29814);
      Object localObject2 = BaseVoicePrintUI.c(BaseVoicePrintUI.this);
      if (((VoiceTipInfoView)localObject2).vLT.getAnimation() == null)
      {
        TextView localTextView = ((VoiceTipInfoView)localObject2).vLT;
        Object localObject1 = ((VoiceTipInfoView)localObject2).getContext();
        localObject2 = new VoiceTipInfoView.1((VoiceTipInfoView)localObject2);
        float f = localTextView.getWidth();
        ac.d("MicroMsg.VoiceViewAnimationHelper", "target ".concat(String.valueOf(f)));
        int[] arrayOfInt = new int[2];
        localTextView.getLocationInWindow(arrayOfInt);
        int i = (int)(f + arrayOfInt[0]);
        ac.d("MicroMsg.VoiceViewAnimationHelper", "location %d %d preX=%d", new Object[] { Integer.valueOf(arrayOfInt[0]), Integer.valueOf(arrayOfInt[1]), Integer.valueOf(i) });
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
  private ao AwN = new ao(Looper.getMainLooper(), new ao.a()
  {
    public final boolean handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(29816);
      if (paramAnonymousMessage.what == 1)
      {
        ac.d("MicroMsg.BaseVoicePrintUI", "start record");
        bc.a(ai.getContext(), 2131764377, new bc.a()
        {
          public final void onCompletion()
          {
            AppMethodBeat.i(29815);
            ac.i("MicroMsg.BaseVoicePrintUI", "play press sound end");
            AppMethodBeat.o(29815);
          }
        });
        BaseVoicePrintUI.a(BaseVoicePrintUI.this, "voice_pt_voice_print_record.rec");
        paramAnonymousMessage = BaseVoicePrintUI.a(BaseVoicePrintUI.this);
        Object localObject = BaseVoicePrintUI.d(BaseVoicePrintUI.this);
        BaseVoicePrintUI localBaseVoicePrintUI = BaseVoicePrintUI.this;
        paramAnonymousMessage.fileName = ((String)localObject);
        ac.d("MicroMsg.VoicePrintRecoder", "start filename %s", new Object[] { paramAnonymousMessage.fileName });
        paramAnonymousMessage.Aww.gw(localBaseVoicePrintUI);
        BaseVoicePrintUI.e(BaseVoicePrintUI.this).au(100L, 100L);
        paramAnonymousMessage = BaseVoicePrintUI.this;
        paramAnonymousMessage.AwF.egT();
        localObject = paramAnonymousMessage.AwF;
        ac.d("MicroMsg.VoiceTipInfoView", "hideTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", new Object[] { Integer.valueOf(((VoiceTipInfoView)localObject).lfN.getVisibility()), Boolean.valueOf(((VoiceTipInfoView)localObject).AxE) });
        if ((((VoiceTipInfoView)localObject).lfN.getVisibility() == 0) && (!((VoiceTipInfoView)localObject).AxE))
        {
          ((VoiceTipInfoView)localObject).lfN.clearAnimation();
          ((VoiceTipInfoView)localObject).AxE = true;
          a.a(((VoiceTipInfoView)localObject).lfN, ((VoiceTipInfoView)localObject).getContext(), new VoiceTipInfoView.3((VoiceTipInfoView)localObject));
        }
        for (;;)
        {
          paramAnonymousMessage.AwF.setTipText(paramAnonymousMessage.Awk);
          paramAnonymousMessage.AwM.stopTimer();
          paramAnonymousMessage.AwM.au(500L, 500L);
          paramAnonymousMessage.AwD.setVisibility(0);
          paramAnonymousMessage = paramAnonymousMessage.AwE;
          paramAnonymousMessage.reset();
          paramAnonymousMessage.mIsPlaying = true;
          localObject = paramAnonymousMessage.Axn;
          long l = VoicePrintVolumeMeter.ubU;
          ((au)localObject).au(l, l);
          paramAnonymousMessage.egN();
          AppMethodBeat.o(29816);
          return true;
          ac.d("MicroMsg.VoiceTipInfoView", "hideTitle, directly set to INVISIBLE");
          ((VoiceTipInfoView)localObject).lfN.clearAnimation();
          ((VoiceTipInfoView)localObject).lfN.setVisibility(4);
          ((VoiceTipInfoView)localObject).lfN.invalidate();
        }
      }
      AppMethodBeat.o(29816);
      return false;
    }
  });
  String Awk = null;
  private boolean uaU = false;
  private final au ubd = new au(new au.a()
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
      if (localp.cLR != null)
      {
        i = localp.cLR.getMaxAmplitude();
        if (i > p.cXn) {
          p.cXn = i;
        }
        ac.d("MicroMsg.VoicePrintRecoder", " map: " + i + " max:" + p.cXn + " per:" + i * 100 / p.cXn);
      }
      for (int i = i * 100 / p.cXn;; i = 0)
      {
        BaseVoicePrintUI.a(BaseVoicePrintUI.this, i);
        AppMethodBeat.o(29813);
        return true;
      }
    }
  }, true);
  
  protected final void RT(int paramInt)
  {
    this.AwF.der();
    this.AwF.setErr(paramInt);
    this.AwF.egS();
  }
  
  protected abstract void cXK();
  
  protected final void egC()
  {
    ap.n(new Runnable()
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
  
  protected final void egD()
  {
    if ((this.AwJ.getVisibility() == 4) || (this.AwJ.getVisibility() == 8)) {
      return;
    }
    if (this.AwK)
    {
      this.AwJ.setVisibility(4);
      return;
    }
    this.AwK = true;
    a.a(this.AwJ, this, new a.a()
    {
      public final void egG() {}
      
      public final void egH()
      {
        AppMethodBeat.i(29820);
        BaseVoicePrintUI.j(BaseVoicePrintUI.this).setVisibility(4);
        BaseVoicePrintUI.k(BaseVoicePrintUI.this);
        AppMethodBeat.o(29820);
      }
    });
  }
  
  protected final void egE()
  {
    RT(2131764737);
  }
  
  protected abstract void egF();
  
  public int getLayoutId()
  {
    return 2131495864;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    hideTitleView();
    this.AwF = ((VoiceTipInfoView)findViewById(2131305873));
    this.AwC = ((Button)findViewById(2131303847));
    this.AwD = findViewById(2131306632);
    this.AwE = ((VoicePrintVolumeMeter)findViewById(2131306633));
    this.AwJ = findViewById(2131297664);
    this.AwF.egT();
    this.AwE.setArchView(this.AwC);
    this.AwG = new p();
    this.AwG.Awx = this.AwL;
    this.AwC.setOnTouchListener(new View.OnTouchListener()
    {
      private boolean AwQ = false;
      private long ubB = 0L;
      
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
          if (!bs.isNullOrNil(BaseVoicePrintUI.this.Awk))
          {
            this.ubB = System.currentTimeMillis();
            BaseVoicePrintUI.f(BaseVoicePrintUI.this).setPressed(true);
            BaseVoicePrintUI.l(BaseVoicePrintUI.this);
            BaseVoicePrintUI.this.egD();
            BaseVoicePrintUI.m(BaseVoicePrintUI.this).sendEmptyMessageDelayed(1, 300L);
            ac.i("MicroMsg.BaseVoicePrintUI", "mic press down");
            continue;
            BaseVoicePrintUI.f(BaseVoicePrintUI.this).setPressed(false);
            BaseVoicePrintUI.m(BaseVoicePrintUI.this).removeMessages(1);
            if (System.currentTimeMillis() - this.ubB < 300L)
            {
              ac.d("MicroMsg.BaseVoicePrintUI", "just little touch the button, set touchDown to false");
              BaseVoicePrintUI.a(BaseVoicePrintUI.this, false);
            }
            for (;;)
            {
              ac.i("MicroMsg.BaseVoicePrintUI", "mic press up %d, hasTouchDown:%b", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getAction()), Boolean.valueOf(BaseVoicePrintUI.n(BaseVoicePrintUI.this)) });
              BaseVoicePrintUI.g(BaseVoicePrintUI.this).stop();
              BaseVoicePrintUI.e(BaseVoicePrintUI.this).stopTimer();
              BaseVoicePrintUI.a(BaseVoicePrintUI.this).Fb();
              if (BaseVoicePrintUI.n(BaseVoicePrintUI.this)) {
                break label293;
              }
              BaseVoicePrintUI.c(BaseVoicePrintUI.this).setErr(2131764736);
              BaseVoicePrintUI.c(BaseVoicePrintUI.this).egS();
              break;
              BaseVoicePrintUI.a(BaseVoicePrintUI.this, true);
            }
            label293:
            paramAnonymousView = BaseVoicePrintUI.this;
            ac.d("MicroMsg.BaseVoicePrintUI", "releaseMic");
            if (!paramAnonymousView.AwG.Awv)
            {
              paramAnonymousView.AwM.stopTimer();
              paramAnonymousView.AwF.setErr(2131764736);
              paramAnonymousView.AwF.egS();
              paramAnonymousView.AwH = null;
            }
            paramAnonymousView.AwD.setVisibility(8);
            paramAnonymousView.AwF.egQ();
            paramAnonymousView.AwF.setTipText(paramAnonymousView.Awk);
            ac.d("MicroMsg.BaseVoicePrintUI", "localMsgFileName %s", new Object[] { BaseVoicePrintUI.d(BaseVoicePrintUI.this) });
            if (!bs.isNullOrNil(BaseVoicePrintUI.d(BaseVoicePrintUI.this))) {
              BaseVoicePrintUI.this.egF();
            }
            this.ubB = 0L;
            this.AwQ = false;
            BaseVoicePrintUI.a(BaseVoicePrintUI.this, false);
          }
        }
      }
    });
    findViewById(2131301383).setOnClickListener(new BaseVoicePrintUI.2(this));
    cXK();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.AwE.Axn.stopTimer();
    ac.d("MicroMsg.VoicePrintVolumeMeter", "destroy, quit factor thread");
    ac.d("MicroMsg.VoicePrintLogic", "delete voiceprint voice file");
    e locale = new e(com.tencent.mm.plugin.voiceprint.model.m.bW("voice_pt_voice_print_record.rec", false));
    if (locale.exists()) {
      locale.delete();
    }
    locale = new e(com.tencent.mm.plugin.voiceprint.model.m.bW("voice_pt_voice_print_noise_detect.rec", false));
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