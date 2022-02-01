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
import com.tencent.mm.al.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;

@TargetApi(16)
public class VoiceInputLayoutImpl
  extends VoiceInputLayout
{
  private l EUy;
  private View.OnLongClickListener aYD;
  private View tDK;
  private boolean tDN;
  private long tDP;
  private View.OnTouchListener tDQ;
  
  public VoiceInputLayoutImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31296);
    this.tDN = false;
    this.aYD = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31288);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/pluginsdk/ui/VoiceInputLayoutImpl$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
        ad.d("MicroMsg.VoiceInputLayoutImp", "btn onLongClickListener currentState %s", new Object[] { Integer.valueOf(VoiceInputLayoutImpl.this.currentState) });
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, true);
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).fbZ();
        a.a(true, this, "com/tencent/mm/pluginsdk/ui/VoiceInputLayoutImpl$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(31288);
        return true;
      }
    };
    this.tDQ = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(31289);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/pluginsdk/ui/VoiceInputLayoutImpl$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          a.a(false, this, "com/tencent/mm/pluginsdk/ui/VoiceInputLayoutImpl$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(31289);
          return false;
          VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, false);
          VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, bt.HI());
          ad.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[] { Integer.valueOf(VoiceInputLayoutImpl.this.currentState), Long.valueOf(VoiceInputLayoutImpl.b(VoiceInputLayoutImpl.this)) });
          VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).fca();
          VoiceInputLayoutImpl.this.R(false, false);
          continue;
          ad.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_UP currentState %s longClickDown %s", new Object[] { Integer.valueOf(VoiceInputLayoutImpl.this.currentState), Boolean.valueOf(VoiceInputLayoutImpl.c(VoiceInputLayoutImpl.this)) });
          if (VoiceInputLayoutImpl.c(VoiceInputLayoutImpl.this))
          {
            VoiceInputLayoutImpl.this.R(true, false);
            VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, false);
            VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, 0L);
          }
          else
          {
            VoiceInputLayoutImpl.this.R(false, true);
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
    this.tDN = false;
    this.aYD = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31288);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/pluginsdk/ui/VoiceInputLayoutImpl$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
        ad.d("MicroMsg.VoiceInputLayoutImp", "btn onLongClickListener currentState %s", new Object[] { Integer.valueOf(VoiceInputLayoutImpl.this.currentState) });
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, true);
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).fbZ();
        a.a(true, this, "com/tencent/mm/pluginsdk/ui/VoiceInputLayoutImpl$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(31288);
        return true;
      }
    };
    this.tDQ = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(31289);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/pluginsdk/ui/VoiceInputLayoutImpl$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          a.a(false, this, "com/tencent/mm/pluginsdk/ui/VoiceInputLayoutImpl$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(31289);
          return false;
          VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, false);
          VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, bt.HI());
          ad.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[] { Integer.valueOf(VoiceInputLayoutImpl.this.currentState), Long.valueOf(VoiceInputLayoutImpl.b(VoiceInputLayoutImpl.this)) });
          VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).fca();
          VoiceInputLayoutImpl.this.R(false, false);
          continue;
          ad.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_UP currentState %s longClickDown %s", new Object[] { Integer.valueOf(VoiceInputLayoutImpl.this.currentState), Boolean.valueOf(VoiceInputLayoutImpl.c(VoiceInputLayoutImpl.this)) });
          if (VoiceInputLayoutImpl.c(VoiceInputLayoutImpl.this))
          {
            VoiceInputLayoutImpl.this.R(true, false);
            VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, false);
            VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this, 0L);
          }
          else
          {
            VoiceInputLayoutImpl.this.R(false, true);
          }
        }
      }
    };
    init(paramContext);
    AppMethodBeat.o(31295);
  }
  
  private void aV(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(31306);
    log_13905 locallog_13905 = new log_13905();
    VoiceInputBehavior localVoiceInputBehavior = new VoiceInputBehavior();
    if (paramBoolean) {
      if (this.tFg)
      {
        localVoiceInputBehavior.fullScreenVoiceLongClick = paramInt;
        if ((paramInt != 4) && (this.tDN) && (this.tDP != 0L)) {
          localVoiceInputBehavior.fullScreenVoiceLongClickTime = bt.aO(this.tDP);
        }
      }
    }
    for (;;)
    {
      locallog_13905.viOp_ = localVoiceInputBehavior;
      g.yhR.c(13905, locallog_13905);
      ad.i("MicroMsg.VoiceInputLayoutImp", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[] { Integer.valueOf(localVoiceInputBehavior.cancel), Integer.valueOf(localVoiceInputBehavior.send), Integer.valueOf(localVoiceInputBehavior.click), Integer.valueOf(localVoiceInputBehavior.longClick), Long.valueOf(localVoiceInputBehavior.longClickTime), Integer.valueOf(localVoiceInputBehavior.textClick), Integer.valueOf(localVoiceInputBehavior.textChangeCount), Long.valueOf(localVoiceInputBehavior.textChangeTime), Integer.valueOf(localVoiceInputBehavior.textChangeReturn), Long.valueOf(localVoiceInputBehavior.voiceInputTime), Integer.valueOf(localVoiceInputBehavior.fail), Integer.valueOf(localVoiceInputBehavior.clear), Integer.valueOf(localVoiceInputBehavior.smileIconClick), Integer.valueOf(localVoiceInputBehavior.voiceIconClick), Integer.valueOf(localVoiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(localVoiceInputBehavior.fullScreenVoiceLongClickTime) });
      AppMethodBeat.o(31306);
      return;
      localVoiceInputBehavior.longClick = paramInt;
      if ((paramInt != 4) && (this.tDN) && (this.tDP != 0L))
      {
        localVoiceInputBehavior.longClickTime = bt.aO(this.tDP);
        continue;
        localVoiceInputBehavior.click = paramInt;
      }
    }
  }
  
  private void cUi()
  {
    AppMethodBeat.i(31299);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31290);
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).fcc();
        AppMethodBeat.o(31290);
      }
    });
    cUv();
    AppMethodBeat.o(31299);
  }
  
  private static boolean cUk()
  {
    AppMethodBeat.i(31300);
    int i = ba.aiU().aEN();
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
    this.tDK = inflate(paramContext, 2131495858, this).findViewById(2131306533);
    this.tDK.setLayerType(1, null);
    this.EUy = new l(paramContext);
    this.tDK.setBackground(this.EUy);
    this.tDK.setEnabled(true);
    this.tDK.setOnTouchListener(this.tDQ);
    this.tDK.setOnLongClickListener(this.aYD);
    reset(true);
    if (isInEditMode())
    {
      AppMethodBeat.o(31297);
      return;
    }
    if (!cUk()) {
      cUi();
    }
    AppMethodBeat.o(31297);
  }
  
  private static void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(31305);
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      aq.f(paramRunnable);
      AppMethodBeat.o(31305);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(31305);
  }
  
  protected final void Hb(final int paramInt)
  {
    AppMethodBeat.i(31304);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31294);
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).YL(paramInt);
        AppMethodBeat.o(31294);
      }
    });
    AppMethodBeat.o(31304);
  }
  
  public final void R(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(31298);
    ad.d("MicroMsg.VoiceInputLayoutImp", "directStart currentState = %s longUp = %s clickUp = %s", new Object[] { Integer.valueOf(this.currentState), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (this.currentState == 1)
    {
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        if (!cUk())
        {
          cUi();
          AppMethodBeat.o(31298);
          return;
        }
        cUs();
        AppMethodBeat.o(31298);
        return;
      }
      if ((paramBoolean1) && (!paramBoolean2))
      {
        aV(4, this.tDN);
        aV(this.currentState, this.tDN);
        this.EUy.cTW();
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
            aV(4, this.tDN);
          }
          aV(this.currentState, this.tDN);
          cUt();
          AppMethodBeat.o(31298);
          return;
        }
        this.EUy.cTW();
        aNZ();
        if (this.EUw != null) {
          this.EUw.cUh();
        }
        aV(5, this.tDN);
        AppMethodBeat.o(31298);
        return;
      }
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        aV(this.currentState, this.tDN);
        aNZ();
        AppMethodBeat.o(31298);
        return;
      }
      if ((paramBoolean1) && (!paramBoolean2))
      {
        aV(4, this.tDN);
        aV(this.currentState, this.tDN);
        this.EUy.cTW();
      }
    }
    AppMethodBeat.o(31298);
  }
  
  protected final void cUl()
  {
    AppMethodBeat.i(31301);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31291);
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).vJ(this.tDS);
        AppMethodBeat.o(31291);
      }
    });
    AppMethodBeat.o(31301);
  }
  
  protected final void gw(boolean paramBoolean)
  {
    AppMethodBeat.i(31302);
    if (!paramBoolean) {
      aV(17, false);
    }
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31292);
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).fcb();
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
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).cTW();
        AppMethodBeat.o(31293);
      }
    });
    AppMethodBeat.o(31303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl
 * JD-Core Version:    0.7.0.1
 */