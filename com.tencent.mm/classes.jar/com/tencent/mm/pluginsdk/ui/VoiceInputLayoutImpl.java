package com.tencent.mm.pluginsdk.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;

@TargetApi(16)
public class VoiceInputLayoutImpl
  extends VoiceInputLayout
{
  private k Dpu;
  private View.OnLongClickListener aOj;
  private View sGR;
  private boolean sGU;
  private long sGW;
  private View.OnTouchListener sGX;
  
  public VoiceInputLayoutImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31296);
    this.sGU = false;
    this.aOj = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31288);
        ac.d("MicroMsg.VoiceInputLayoutImp", "btn onLongClickListener currentState %s", new Object[] { Integer.valueOf(VoiceInputLayoutImpl.this.currentState) });
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, true);
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).eNa();
        AppMethodBeat.o(31288);
        return true;
      }
    };
    this.sGX = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(31289);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(31289);
          return false;
          VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, false);
          VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, bs.Gn());
          ac.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[] { Integer.valueOf(VoiceInputLayoutImpl.this.currentState), Long.valueOf(VoiceInputLayoutImpl.b(VoiceInputLayoutImpl.this)) });
          VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).eNb();
          VoiceInputLayoutImpl.this.P(false, false);
          continue;
          ac.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_UP currentState %s longClickDown %s", new Object[] { Integer.valueOf(VoiceInputLayoutImpl.this.currentState), Boolean.valueOf(VoiceInputLayoutImpl.c(VoiceInputLayoutImpl.this)) });
          if (VoiceInputLayoutImpl.c(VoiceInputLayoutImpl.this))
          {
            VoiceInputLayoutImpl.this.P(true, false);
            VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, false);
            VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, 0L);
          }
          else
          {
            VoiceInputLayoutImpl.this.P(false, true);
          }
        }
      }
    };
    init(paramContext);
    AppMethodBeat.o(31296);
  }
  
  public VoiceInputLayoutImpl(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31295);
    this.sGU = false;
    this.aOj = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31288);
        ac.d("MicroMsg.VoiceInputLayoutImp", "btn onLongClickListener currentState %s", new Object[] { Integer.valueOf(VoiceInputLayoutImpl.this.currentState) });
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, true);
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).eNa();
        AppMethodBeat.o(31288);
        return true;
      }
    };
    this.sGX = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(31289);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(31289);
          return false;
          VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, false);
          VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, bs.Gn());
          ac.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[] { Integer.valueOf(VoiceInputLayoutImpl.this.currentState), Long.valueOf(VoiceInputLayoutImpl.b(VoiceInputLayoutImpl.this)) });
          VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).eNb();
          VoiceInputLayoutImpl.this.P(false, false);
          continue;
          ac.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_UP currentState %s longClickDown %s", new Object[] { Integer.valueOf(VoiceInputLayoutImpl.this.currentState), Boolean.valueOf(VoiceInputLayoutImpl.c(VoiceInputLayoutImpl.this)) });
          if (VoiceInputLayoutImpl.c(VoiceInputLayoutImpl.this))
          {
            VoiceInputLayoutImpl.this.P(true, false);
            VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, false);
            VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, 0L);
          }
          else
          {
            VoiceInputLayoutImpl.this.P(false, true);
          }
        }
      }
    };
    init(paramContext);
    AppMethodBeat.o(31295);
  }
  
  private void aO(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(31306);
    log_13905 locallog_13905 = new log_13905();
    VoiceInputBehavior localVoiceInputBehavior = new VoiceInputBehavior();
    if (paramBoolean) {
      if (this.sIv)
      {
        localVoiceInputBehavior.fullScreenVoiceLongClick = paramInt;
        if ((paramInt != 4) && (this.sGU) && (this.sGW != 0L)) {
          localVoiceInputBehavior.fullScreenVoiceLongClickTime = bs.aO(this.sGW);
        }
      }
    }
    for (;;)
    {
      locallog_13905.viOp_ = localVoiceInputBehavior;
      h.wUl.c(13905, locallog_13905);
      ac.i("MicroMsg.VoiceInputLayoutImp", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[] { Integer.valueOf(localVoiceInputBehavior.cancel), Integer.valueOf(localVoiceInputBehavior.send), Integer.valueOf(localVoiceInputBehavior.click), Integer.valueOf(localVoiceInputBehavior.longClick), Long.valueOf(localVoiceInputBehavior.longClickTime), Integer.valueOf(localVoiceInputBehavior.textClick), Integer.valueOf(localVoiceInputBehavior.textChangeCount), Long.valueOf(localVoiceInputBehavior.textChangeTime), Integer.valueOf(localVoiceInputBehavior.textChangeReturn), Long.valueOf(localVoiceInputBehavior.voiceInputTime), Integer.valueOf(localVoiceInputBehavior.fail), Integer.valueOf(localVoiceInputBehavior.clear), Integer.valueOf(localVoiceInputBehavior.smileIconClick), Integer.valueOf(localVoiceInputBehavior.voiceIconClick), Integer.valueOf(localVoiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(localVoiceInputBehavior.fullScreenVoiceLongClickTime) });
      AppMethodBeat.o(31306);
      return;
      localVoiceInputBehavior.longClick = paramInt;
      if ((paramInt != 4) && (this.sGU) && (this.sGW != 0L))
      {
        localVoiceInputBehavior.longClickTime = bs.aO(this.sGW);
        continue;
        localVoiceInputBehavior.click = paramInt;
      }
    }
  }
  
  private void cLP()
  {
    AppMethodBeat.i(31299);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31290);
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).eNd();
        AppMethodBeat.o(31290);
      }
    });
    cMc();
    AppMethodBeat.o(31299);
  }
  
  private static boolean cLR()
  {
    AppMethodBeat.i(31300);
    int i = az.agi().aBK();
    if ((i == 4) || (i == 6))
    {
      AppMethodBeat.o(31300);
      return true;
    }
    AppMethodBeat.o(31300);
    return false;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(31297);
    this.sGR = inflate(paramContext, 2131495858, this).findViewById(2131306533);
    this.sGR.setLayerType(1, null);
    this.Dpu = new k(paramContext);
    this.sGR.setBackground(this.Dpu);
    this.sGR.setEnabled(true);
    this.sGR.setOnTouchListener(this.sGX);
    this.sGR.setOnLongClickListener(this.aOj);
    reset(true);
    if (isInEditMode())
    {
      AppMethodBeat.o(31297);
      return;
    }
    if (!cLR()) {
      cLP();
    }
    AppMethodBeat.o(31297);
  }
  
  private static void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(31305);
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      ap.f(paramRunnable);
      AppMethodBeat.o(31305);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(31305);
  }
  
  protected final void FM(final int paramInt)
  {
    AppMethodBeat.i(31304);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31294);
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).WP(paramInt);
        AppMethodBeat.o(31294);
      }
    });
    AppMethodBeat.o(31304);
  }
  
  public final void P(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(31298);
    ac.d("MicroMsg.VoiceInputLayoutImp", "directStart currentState = %s longUp = %s clickUp = %s", new Object[] { Integer.valueOf(this.currentState), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (this.currentState == 1)
    {
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        if (!cLR())
        {
          cLP();
          AppMethodBeat.o(31298);
          return;
        }
        cLZ();
        AppMethodBeat.o(31298);
        return;
      }
      if ((paramBoolean1) && (!paramBoolean2))
      {
        aO(4, this.sGU);
        aO(this.currentState, this.sGU);
        this.Dpu.cLD();
        AppMethodBeat.o(31298);
      }
    }
    else
    {
      if (this.currentState == 2)
      {
        if (!paramBoolean2)
        {
          if (paramBoolean1) {
            aO(4, this.sGU);
          }
          aO(this.currentState, this.sGU);
          cMa();
          AppMethodBeat.o(31298);
          return;
        }
        this.Dpu.cLD();
        aKQ();
        if (this.Dps != null) {
          this.Dps.cLO();
        }
        aO(5, this.sGU);
        AppMethodBeat.o(31298);
        return;
      }
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        aO(this.currentState, this.sGU);
        aKQ();
        AppMethodBeat.o(31298);
        return;
      }
      if ((paramBoolean1) && (!paramBoolean2))
      {
        aO(4, this.sGU);
        aO(this.currentState, this.sGU);
        this.Dpu.cLD();
      }
    }
    AppMethodBeat.o(31298);
  }
  
  protected final void cLS()
  {
    AppMethodBeat.i(31301);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31291);
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).uY(this.sGZ);
        AppMethodBeat.o(31291);
      }
    });
    AppMethodBeat.o(31301);
  }
  
  protected final void gq(boolean paramBoolean)
  {
    AppMethodBeat.i(31302);
    if (!paramBoolean) {
      aO(17, false);
    }
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31292);
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).eNc();
        AppMethodBeat.o(31292);
      }
    });
    AppMethodBeat.o(31302);
  }
  
  protected final void onReset()
  {
    AppMethodBeat.i(31303);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31293);
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).cLD();
        AppMethodBeat.o(31293);
      }
    });
    AppMethodBeat.o(31303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl
 * JD-Core Version:    0.7.0.1
 */