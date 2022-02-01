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
  private boolean sSI = false;
  private final av sSR = new av(new av.a()
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
      if (localp.cOw != null)
      {
        i = localp.cOw.getMaxAmplitude();
        if (i > p.cZR) {
          p.cZR = i;
        }
        ad.d("MicroMsg.VoicePrintRecoder", " map: " + i + " max:" + p.cZR + " per:" + i * 100 / p.cZR);
      }
      for (int i = i * 100 / p.cZR;; i = 0)
      {
        BaseVoicePrintUI.a(BaseVoicePrintUI.this, i);
        AppMethodBeat.o(29813);
        return true;
      }
    }
  }, true);
  String zdE = null;
  Button zdW;
  View zdX;
  VoicePrintVolumeMeter zdY;
  VoiceTipInfoView zdZ;
  p zea = null;
  String zeb = null;
  private boolean zec = false;
  private View zed;
  private boolean zee = false;
  private final p.a zef = new p.a()
  {
    public final void dRr()
    {
      AppMethodBeat.i(29811);
      p localp = BaseVoicePrintUI.a(BaseVoicePrintUI.this);
      if (localp.cOw != null)
      {
        localp.cOw.Ob();
        ad.e("MicroMsg.VoicePrintRecoder", "Reset recorder.stopReocrd");
      }
      localp.fileName = "";
      localp.zdN = null;
      localp.yDk = 0;
      localp.omg = 0L;
      localp.zdQ.rn(true);
      ad.e("MicroMsg.BaseVoicePrintUI", "record stop on error");
      BaseVoicePrintUI.a(BaseVoicePrintUI.this, null);
      BaseVoicePrintUI.b(BaseVoicePrintUI.this);
      AppMethodBeat.o(29811);
    }
  };
  av zeg = new av(new av.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(29814);
      Object localObject2 = BaseVoicePrintUI.c(BaseVoicePrintUI.this);
      if (((VoiceTipInfoView)localObject2).uDc.getAnimation() == null)
      {
        TextView localTextView = ((VoiceTipInfoView)localObject2).uDc;
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
  private ap zeh = new ap(Looper.getMainLooper(), new ap.a()
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
        paramAnonymousMessage.zdQ.gk(localBaseVoicePrintUI);
        BaseVoicePrintUI.e(BaseVoicePrintUI.this).av(100L, 100L);
        paramAnonymousMessage = BaseVoicePrintUI.this;
        paramAnonymousMessage.zdZ.dRI();
        localObject = paramAnonymousMessage.zdZ;
        ad.d("MicroMsg.VoiceTipInfoView", "hideTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", new Object[] { Integer.valueOf(((VoiceTipInfoView)localObject).kEu.getVisibility()), Boolean.valueOf(((VoiceTipInfoView)localObject).zeY) });
        if ((((VoiceTipInfoView)localObject).kEu.getVisibility() == 0) && (!((VoiceTipInfoView)localObject).zeY))
        {
          ((VoiceTipInfoView)localObject).kEu.clearAnimation();
          ((VoiceTipInfoView)localObject).zeY = true;
          a.a(((VoiceTipInfoView)localObject).kEu, ((VoiceTipInfoView)localObject).getContext(), new VoiceTipInfoView.3((VoiceTipInfoView)localObject));
        }
        for (;;)
        {
          paramAnonymousMessage.zdZ.setTipText(paramAnonymousMessage.zdE);
          paramAnonymousMessage.zeg.stopTimer();
          paramAnonymousMessage.zeg.av(500L, 500L);
          paramAnonymousMessage.zdX.setVisibility(0);
          paramAnonymousMessage = paramAnonymousMessage.zdY;
          paramAnonymousMessage.reset();
          paramAnonymousMessage.mIsPlaying = true;
          localObject = paramAnonymousMessage.zeH;
          long l = VoicePrintVolumeMeter.sTI;
          ((av)localObject).av(l, l);
          paramAnonymousMessage.dRD();
          AppMethodBeat.o(29816);
          return true;
          ad.d("MicroMsg.VoiceTipInfoView", "hideTitle, directly set to INVISIBLE");
          ((VoiceTipInfoView)localObject).kEu.clearAnimation();
          ((VoiceTipInfoView)localObject).kEu.setVisibility(4);
          ((VoiceTipInfoView)localObject).kEu.invalidate();
        }
      }
      AppMethodBeat.o(29816);
      return false;
    }
  });
  
  protected final void PK(int paramInt)
  {
    this.zdZ.cQI();
    this.zdZ.setErr(paramInt);
    this.zdZ.dRH();
  }
  
  protected abstract void cKf();
  
  protected final void dRs()
  {
    aq.n(new Runnable()
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
  
  protected final void dRt()
  {
    if ((this.zed.getVisibility() == 4) || (this.zed.getVisibility() == 8)) {
      return;
    }
    if (this.zee)
    {
      this.zed.setVisibility(4);
      return;
    }
    this.zee = true;
    a.a(this.zed, this, new a.a()
    {
      public final void dRw() {}
      
      public final void dRx()
      {
        AppMethodBeat.i(29820);
        BaseVoicePrintUI.j(BaseVoicePrintUI.this).setVisibility(4);
        BaseVoicePrintUI.k(BaseVoicePrintUI.this);
        AppMethodBeat.o(29820);
      }
    });
  }
  
  protected final void dRu()
  {
    PK(2131764737);
  }
  
  protected abstract void dRv();
  
  public int getLayoutId()
  {
    return 2131495864;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    hideTitleView();
    this.zdZ = ((VoiceTipInfoView)findViewById(2131305873));
    this.zdW = ((Button)findViewById(2131303847));
    this.zdX = findViewById(2131306632);
    this.zdY = ((VoicePrintVolumeMeter)findViewById(2131306633));
    this.zed = findViewById(2131297664);
    this.zdZ.dRI();
    this.zdY.setArchView(this.zdW);
    this.zea = new p();
    this.zea.zdR = this.zef;
    this.zdW.setOnTouchListener(new View.OnTouchListener()
    {
      private long sTp = 0L;
      private boolean zek = false;
      
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
          if (!bt.isNullOrNil(BaseVoicePrintUI.this.zdE))
          {
            this.sTp = System.currentTimeMillis();
            BaseVoicePrintUI.f(BaseVoicePrintUI.this).setPressed(true);
            BaseVoicePrintUI.l(BaseVoicePrintUI.this);
            BaseVoicePrintUI.this.dRt();
            BaseVoicePrintUI.m(BaseVoicePrintUI.this).sendEmptyMessageDelayed(1, 300L);
            ad.i("MicroMsg.BaseVoicePrintUI", "mic press down");
            continue;
            BaseVoicePrintUI.f(BaseVoicePrintUI.this).setPressed(false);
            BaseVoicePrintUI.m(BaseVoicePrintUI.this).removeMessages(1);
            if (System.currentTimeMillis() - this.sTp < 300L)
            {
              ad.d("MicroMsg.BaseVoicePrintUI", "just little touch the button, set touchDown to false");
              BaseVoicePrintUI.a(BaseVoicePrintUI.this, false);
            }
            for (;;)
            {
              ad.i("MicroMsg.BaseVoicePrintUI", "mic press up %d, hasTouchDown:%b", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getAction()), Boolean.valueOf(BaseVoicePrintUI.n(BaseVoicePrintUI.this)) });
              BaseVoicePrintUI.g(BaseVoicePrintUI.this).stop();
              BaseVoicePrintUI.e(BaseVoicePrintUI.this).stopTimer();
              BaseVoicePrintUI.a(BaseVoicePrintUI.this).Ft();
              if (BaseVoicePrintUI.n(BaseVoicePrintUI.this)) {
                break label293;
              }
              BaseVoicePrintUI.c(BaseVoicePrintUI.this).setErr(2131764736);
              BaseVoicePrintUI.c(BaseVoicePrintUI.this).dRH();
              break;
              BaseVoicePrintUI.a(BaseVoicePrintUI.this, true);
            }
            label293:
            paramAnonymousView = BaseVoicePrintUI.this;
            ad.d("MicroMsg.BaseVoicePrintUI", "releaseMic");
            if (!paramAnonymousView.zea.zdP)
            {
              paramAnonymousView.zeg.stopTimer();
              paramAnonymousView.zdZ.setErr(2131764736);
              paramAnonymousView.zdZ.dRH();
              paramAnonymousView.zeb = null;
            }
            paramAnonymousView.zdX.setVisibility(8);
            paramAnonymousView.zdZ.dRF();
            paramAnonymousView.zdZ.setTipText(paramAnonymousView.zdE);
            ad.d("MicroMsg.BaseVoicePrintUI", "localMsgFileName %s", new Object[] { BaseVoicePrintUI.d(BaseVoicePrintUI.this) });
            if (!bt.isNullOrNil(BaseVoicePrintUI.d(BaseVoicePrintUI.this))) {
              BaseVoicePrintUI.this.dRv();
            }
            this.sTp = 0L;
            this.zek = false;
            BaseVoicePrintUI.a(BaseVoicePrintUI.this, false);
          }
        }
      }
    });
    findViewById(2131301383).setOnClickListener(new BaseVoicePrintUI.2(this));
    cKf();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.zdY.zeH.stopTimer();
    ad.d("MicroMsg.VoicePrintVolumeMeter", "destroy, quit factor thread");
    ad.d("MicroMsg.VoicePrintLogic", "delete voiceprint voice file");
    e locale = new e(com.tencent.mm.plugin.voiceprint.model.m.bP("voice_pt_voice_print_record.rec", false));
    if (locale.exists()) {
      locale.delete();
    }
    locale = new e(com.tencent.mm.plugin.voiceprint.model.m.bP("voice_pt_voice_print_noise_detect.rec", false));
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