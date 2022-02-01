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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;

@TargetApi(16)
public class VoiceInputLayoutImpl
  extends VoiceInputLayout
{
  private l FmT;
  private View.OnLongClickListener aYD;
  private View tOB;
  private boolean tOE;
  private long tOG;
  private View.OnTouchListener tOH;
  
  public VoiceInputLayoutImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31296);
    this.tOE = false;
    this.aYD = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31288);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/pluginsdk/ui/VoiceInputLayoutImpl$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
        ae.d("MicroMsg.VoiceInputLayoutImp", "btn onLongClickListener currentState %s", new Object[] { Integer.valueOf(VoiceInputLayoutImpl.this.currentState) });
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, true);
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).ffN();
        a.a(true, this, "com/tencent/mm/pluginsdk/ui/VoiceInputLayoutImpl$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(31288);
        return true;
      }
    };
    this.tOH = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(31289);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/pluginsdk/ui/VoiceInputLayoutImpl$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          a.a(false, this, "com/tencent/mm/pluginsdk/ui/VoiceInputLayoutImpl$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(31289);
          return false;
          VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, false);
          VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, bu.HQ());
          ae.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[] { Integer.valueOf(VoiceInputLayoutImpl.this.currentState), Long.valueOf(VoiceInputLayoutImpl.b(VoiceInputLayoutImpl.this)) });
          VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).ffO();
          VoiceInputLayoutImpl.this.Q(false, false);
          continue;
          ae.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_UP currentState %s longClickDown %s", new Object[] { Integer.valueOf(VoiceInputLayoutImpl.this.currentState), Boolean.valueOf(VoiceInputLayoutImpl.c(VoiceInputLayoutImpl.this)) });
          if (VoiceInputLayoutImpl.c(VoiceInputLayoutImpl.this))
          {
            VoiceInputLayoutImpl.this.Q(true, false);
            VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, false);
            VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, 0L);
          }
          else
          {
            VoiceInputLayoutImpl.this.Q(false, true);
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
    this.tOE = false;
    this.aYD = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31288);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/pluginsdk/ui/VoiceInputLayoutImpl$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
        ae.d("MicroMsg.VoiceInputLayoutImp", "btn onLongClickListener currentState %s", new Object[] { Integer.valueOf(VoiceInputLayoutImpl.this.currentState) });
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, true);
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).ffN();
        a.a(true, this, "com/tencent/mm/pluginsdk/ui/VoiceInputLayoutImpl$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(31288);
        return true;
      }
    };
    this.tOH = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(31289);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/pluginsdk/ui/VoiceInputLayoutImpl$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          a.a(false, this, "com/tencent/mm/pluginsdk/ui/VoiceInputLayoutImpl$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(31289);
          return false;
          VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, false);
          VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, bu.HQ());
          ae.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[] { Integer.valueOf(VoiceInputLayoutImpl.this.currentState), Long.valueOf(VoiceInputLayoutImpl.b(VoiceInputLayoutImpl.this)) });
          VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).ffO();
          VoiceInputLayoutImpl.this.Q(false, false);
          continue;
          ae.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_UP currentState %s longClickDown %s", new Object[] { Integer.valueOf(VoiceInputLayoutImpl.this.currentState), Boolean.valueOf(VoiceInputLayoutImpl.c(VoiceInputLayoutImpl.this)) });
          if (VoiceInputLayoutImpl.c(VoiceInputLayoutImpl.this))
          {
            VoiceInputLayoutImpl.this.Q(true, false);
            VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, false);
            VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, 0L);
          }
          else
          {
            VoiceInputLayoutImpl.this.Q(false, true);
          }
        }
      }
    };
    init(paramContext);
    AppMethodBeat.o(31295);
  }
  
  private void bb(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(31306);
    log_13905 locallog_13905 = new log_13905();
    VoiceInputBehavior localVoiceInputBehavior = new VoiceInputBehavior();
    if (paramBoolean) {
      if (this.tPX)
      {
        localVoiceInputBehavior.fullScreenVoiceLongClick = paramInt;
        if ((paramInt != 4) && (this.tOE) && (this.tOG != 0L)) {
          localVoiceInputBehavior.fullScreenVoiceLongClickTime = bu.aO(this.tOG);
        }
      }
    }
    for (;;)
    {
      locallog_13905.viOp_ = localVoiceInputBehavior;
      g.yxI.c(13905, locallog_13905);
      ae.i("MicroMsg.VoiceInputLayoutImp", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[] { Integer.valueOf(localVoiceInputBehavior.cancel), Integer.valueOf(localVoiceInputBehavior.send), Integer.valueOf(localVoiceInputBehavior.click), Integer.valueOf(localVoiceInputBehavior.longClick), Long.valueOf(localVoiceInputBehavior.longClickTime), Integer.valueOf(localVoiceInputBehavior.textClick), Integer.valueOf(localVoiceInputBehavior.textChangeCount), Long.valueOf(localVoiceInputBehavior.textChangeTime), Integer.valueOf(localVoiceInputBehavior.textChangeReturn), Long.valueOf(localVoiceInputBehavior.voiceInputTime), Integer.valueOf(localVoiceInputBehavior.fail), Integer.valueOf(localVoiceInputBehavior.clear), Integer.valueOf(localVoiceInputBehavior.smileIconClick), Integer.valueOf(localVoiceInputBehavior.voiceIconClick), Integer.valueOf(localVoiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(localVoiceInputBehavior.fullScreenVoiceLongClickTime) });
      AppMethodBeat.o(31306);
      return;
      localVoiceInputBehavior.longClick = paramInt;
      if ((paramInt != 4) && (this.tOE) && (this.tOG != 0L))
      {
        localVoiceInputBehavior.longClickTime = bu.aO(this.tOG);
        continue;
        localVoiceInputBehavior.click = paramInt;
      }
    }
  }
  
  private void cWN()
  {
    AppMethodBeat.i(31299);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31290);
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).ffQ();
        AppMethodBeat.o(31290);
      }
    });
    cXa();
    AppMethodBeat.o(31299);
  }
  
  private static boolean cWP()
  {
    AppMethodBeat.i(31300);
    int i = bc.ajj().aFd();
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
    this.tOB = inflate(paramContext, 2131495858, this).findViewById(2131306533);
    this.tOB.setLayerType(1, null);
    this.FmT = new l(paramContext);
    this.tOB.setBackground(this.FmT);
    this.tOB.setEnabled(true);
    this.tOB.setOnTouchListener(this.tOH);
    this.tOB.setOnLongClickListener(this.aYD);
    reset(true);
    if (isInEditMode())
    {
      AppMethodBeat.o(31297);
      return;
    }
    if (!cWP()) {
      cWN();
    }
    AppMethodBeat.o(31297);
  }
  
  private static void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(31305);
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      ar.f(paramRunnable);
      AppMethodBeat.o(31305);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(31305);
  }
  
  protected final void Hy(final int paramInt)
  {
    AppMethodBeat.i(31304);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31294);
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).Zr(paramInt);
        AppMethodBeat.o(31294);
      }
    });
    AppMethodBeat.o(31304);
  }
  
  public final void Q(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(31298);
    ae.d("MicroMsg.VoiceInputLayoutImp", "directStart currentState = %s longUp = %s clickUp = %s", new Object[] { Integer.valueOf(this.currentState), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (this.currentState == 1)
    {
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        if (!cWP())
        {
          cWN();
          AppMethodBeat.o(31298);
          return;
        }
        cWX();
        AppMethodBeat.o(31298);
        return;
      }
      if ((paramBoolean1) && (!paramBoolean2))
      {
        bb(4, this.tOE);
        bb(this.currentState, this.tOE);
        this.FmT.cWB();
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
            bb(4, this.tOE);
          }
          bb(this.currentState, this.tOE);
          cWY();
          AppMethodBeat.o(31298);
          return;
        }
        this.FmT.cWB();
        aOx();
        if (this.FmR != null) {
          this.FmR.cWM();
        }
        bb(5, this.tOE);
        AppMethodBeat.o(31298);
        return;
      }
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        bb(this.currentState, this.tOE);
        aOx();
        AppMethodBeat.o(31298);
        return;
      }
      if ((paramBoolean1) && (!paramBoolean2))
      {
        bb(4, this.tOE);
        bb(this.currentState, this.tOE);
        this.FmT.cWB();
      }
    }
    AppMethodBeat.o(31298);
  }
  
  protected final void cWQ()
  {
    AppMethodBeat.i(31301);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31291);
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).vR(this.tOJ);
        AppMethodBeat.o(31291);
      }
    });
    AppMethodBeat.o(31301);
  }
  
  protected final void gu(boolean paramBoolean)
  {
    AppMethodBeat.i(31302);
    if (!paramBoolean) {
      bb(17, false);
    }
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31292);
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).ffP();
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
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).cWB();
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