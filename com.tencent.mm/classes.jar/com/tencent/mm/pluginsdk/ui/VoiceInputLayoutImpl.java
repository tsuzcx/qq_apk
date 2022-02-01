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
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

@TargetApi(16)
public class VoiceInputLayoutImpl
  extends VoiceInputLayout
{
  private l KdL;
  private View.OnLongClickListener aYy;
  private View.OnTouchListener aZa;
  private View xfA;
  private boolean xfD;
  private long xfF;
  
  public VoiceInputLayoutImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31296);
    this.xfD = false;
    this.aYy = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31288);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/pluginsdk/ui/VoiceInputLayoutImpl$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        Log.d("MicroMsg.VoiceInputLayoutImp", "btn onLongClickListener currentState %s", new Object[] { Integer.valueOf(VoiceInputLayoutImpl.this.currentState) });
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, true);
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).goW();
        a.a(true, this, "com/tencent/mm/pluginsdk/ui/VoiceInputLayoutImpl$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(31288);
        return true;
      }
    };
    this.aZa = new View.OnTouchListener()
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
          VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, Util.currentTicks());
          Log.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[] { Integer.valueOf(VoiceInputLayoutImpl.this.currentState), Long.valueOf(VoiceInputLayoutImpl.b(VoiceInputLayoutImpl.this)) });
          VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).goX();
          VoiceInputLayoutImpl.this.T(false, false);
          continue;
          Log.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_UP currentState %s longClickDown %s", new Object[] { Integer.valueOf(VoiceInputLayoutImpl.this.currentState), Boolean.valueOf(VoiceInputLayoutImpl.c(VoiceInputLayoutImpl.this)) });
          if (VoiceInputLayoutImpl.c(VoiceInputLayoutImpl.this))
          {
            VoiceInputLayoutImpl.this.T(true, false);
            VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, false);
            VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, 0L);
          }
          else
          {
            VoiceInputLayoutImpl.this.T(false, true);
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
    this.xfD = false;
    this.aYy = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31288);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/pluginsdk/ui/VoiceInputLayoutImpl$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        Log.d("MicroMsg.VoiceInputLayoutImp", "btn onLongClickListener currentState %s", new Object[] { Integer.valueOf(VoiceInputLayoutImpl.this.currentState) });
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, true);
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).goW();
        a.a(true, this, "com/tencent/mm/pluginsdk/ui/VoiceInputLayoutImpl$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(31288);
        return true;
      }
    };
    this.aZa = new View.OnTouchListener()
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
          VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, Util.currentTicks());
          Log.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[] { Integer.valueOf(VoiceInputLayoutImpl.this.currentState), Long.valueOf(VoiceInputLayoutImpl.b(VoiceInputLayoutImpl.this)) });
          VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).goX();
          VoiceInputLayoutImpl.this.T(false, false);
          continue;
          Log.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_UP currentState %s longClickDown %s", new Object[] { Integer.valueOf(VoiceInputLayoutImpl.this.currentState), Boolean.valueOf(VoiceInputLayoutImpl.c(VoiceInputLayoutImpl.this)) });
          if (VoiceInputLayoutImpl.c(VoiceInputLayoutImpl.this))
          {
            VoiceInputLayoutImpl.this.T(true, false);
            VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, false);
            VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, 0L);
          }
          else
          {
            VoiceInputLayoutImpl.this.T(false, true);
          }
        }
      }
    };
    init(paramContext);
    AppMethodBeat.o(31295);
  }
  
  private void bv(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(31306);
    log_13905 locallog_13905 = new log_13905();
    VoiceInputBehavior localVoiceInputBehavior = new VoiceInputBehavior();
    if (paramBoolean) {
      if (this.xhk)
      {
        localVoiceInputBehavior.fullScreenVoiceLongClick = paramInt;
        if ((paramInt != 4) && (this.xfD) && (this.xfF != 0L)) {
          localVoiceInputBehavior.fullScreenVoiceLongClickTime = Util.ticksToNow(this.xfF);
        }
      }
    }
    for (;;)
    {
      locallog_13905.viOp_ = localVoiceInputBehavior;
      h.CyF.c(13905, locallog_13905);
      Log.i("MicroMsg.VoiceInputLayoutImp", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[] { Integer.valueOf(localVoiceInputBehavior.cancel), Integer.valueOf(localVoiceInputBehavior.send), Integer.valueOf(localVoiceInputBehavior.click), Integer.valueOf(localVoiceInputBehavior.longClick), Long.valueOf(localVoiceInputBehavior.longClickTime), Integer.valueOf(localVoiceInputBehavior.textClick), Integer.valueOf(localVoiceInputBehavior.textChangeCount), Long.valueOf(localVoiceInputBehavior.textChangeTime), Integer.valueOf(localVoiceInputBehavior.textChangeReturn), Long.valueOf(localVoiceInputBehavior.voiceInputTime), Integer.valueOf(localVoiceInputBehavior.fail), Integer.valueOf(localVoiceInputBehavior.clear), Integer.valueOf(localVoiceInputBehavior.smileIconClick), Integer.valueOf(localVoiceInputBehavior.voiceIconClick), Integer.valueOf(localVoiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(localVoiceInputBehavior.fullScreenVoiceLongClickTime) });
      AppMethodBeat.o(31306);
      return;
      localVoiceInputBehavior.longClick = paramInt;
      if ((paramInt != 4) && (this.xfD) && (this.xfF != 0L))
      {
        localVoiceInputBehavior.longClickTime = Util.ticksToNow(this.xfF);
        continue;
        localVoiceInputBehavior.click = paramInt;
      }
    }
  }
  
  private void dPX()
  {
    AppMethodBeat.i(31299);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31290);
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).goZ();
        AppMethodBeat.o(31290);
      }
    });
    dQp();
    AppMethodBeat.o(31299);
  }
  
  private static boolean dzA()
  {
    AppMethodBeat.i(31300);
    int i = bg.azz().aYS();
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
    this.xfA = inflate(paramContext, 2131496838, this).findViewById(2131309993);
    this.xfA.setLayerType(1, null);
    this.KdL = new l(paramContext);
    this.xfA.setBackground(this.KdL);
    this.xfA.setEnabled(true);
    this.xfA.setOnTouchListener(this.aZa);
    this.xfA.setOnLongClickListener(this.aYy);
    reset(true);
    if (isInEditMode())
    {
      AppMethodBeat.o(31297);
      return;
    }
    if (!dzA()) {
      dPX();
    }
    AppMethodBeat.o(31297);
  }
  
  private static void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(31305);
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      MMHandlerThread.postToMainThread(paramRunnable);
      AppMethodBeat.o(31305);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(31305);
  }
  
  protected final void Ny(final int paramInt)
  {
    AppMethodBeat.i(31304);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31294);
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).aic(paramInt);
        AppMethodBeat.o(31294);
      }
    });
    AppMethodBeat.o(31304);
  }
  
  public final void T(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(31298);
    Log.d("MicroMsg.VoiceInputLayoutImp", "directStart currentState = %s longUp = %s clickUp = %s", new Object[] { Integer.valueOf(this.currentState), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (this.currentState == 1)
    {
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        if (!dzA())
        {
          dPX();
          AppMethodBeat.o(31298);
          return;
        }
        dQm();
        AppMethodBeat.o(31298);
        return;
      }
      if ((paramBoolean1) && (!paramBoolean2))
      {
        bv(4, this.xfD);
        bv(this.currentState, this.xfD);
        this.KdL.dPL();
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
            bv(4, this.xfD);
          }
          bv(this.currentState, this.xfD);
          dQn();
          AppMethodBeat.o(31298);
          return;
        }
        this.KdL.dPL();
        biE();
        if (this.KdJ != null) {
          this.KdJ.dPW();
        }
        bv(5, this.xfD);
        AppMethodBeat.o(31298);
        return;
      }
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        bv(this.currentState, this.xfD);
        biE();
        AppMethodBeat.o(31298);
        return;
      }
      if ((paramBoolean1) && (!paramBoolean2))
      {
        bv(4, this.xfD);
        bv(this.currentState, this.xfD);
        this.KdL.dPL();
      }
    }
    AppMethodBeat.o(31298);
  }
  
  protected final void dPZ()
  {
    AppMethodBeat.i(31301);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31291);
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).zP(this.xfH);
        AppMethodBeat.o(31291);
      }
    });
    AppMethodBeat.o(31301);
  }
  
  protected final void hs(boolean paramBoolean)
  {
    AppMethodBeat.i(31302);
    if (!paramBoolean) {
      bv(17, false);
    }
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31292);
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).goY();
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
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).dPL();
        AppMethodBeat.o(31293);
      }
    });
    AppMethodBeat.o(31303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl
 * JD-Core Version:    0.7.0.1
 */