package com.tencent.mm.pluginsdk.ui.websearch;

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
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a;
import com.tencent.mm.pluginsdk.ui.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;

@TargetApi(16)
public class WebSearchVoiceInputLayoutImpl
  extends VoiceInputLayout
{
  private l FmT;
  private View.OnLongClickListener aYD;
  private View tOB;
  private boolean tOE;
  private long tOG;
  private View.OnTouchListener tOH;
  
  public WebSearchVoiceInputLayoutImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(32033);
    this.tOE = false;
    this.aYD = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(32025);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputLayoutImpl$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
        ae.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onLongClickListener currentState %s", new Object[] { Integer.valueOf(WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this)) });
        WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, true);
        WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).ffN();
        a.a(true, this, "com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputLayoutImpl$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(32025);
        return true;
      }
    };
    this.tOH = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(32026);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputLayoutImpl$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          a.a(false, this, "com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputLayoutImpl$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(32026);
          return false;
          WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, false);
          WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, bu.HQ());
          ae.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[] { Integer.valueOf(WebSearchVoiceInputLayoutImpl.c(WebSearchVoiceInputLayoutImpl.this)), Long.valueOf(WebSearchVoiceInputLayoutImpl.d(WebSearchVoiceInputLayoutImpl.this)) });
          WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).ffO();
          WebSearchVoiceInputLayoutImpl.this.Q(false, false);
          continue;
          ae.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_UP currentState %s longClickDown %s", new Object[] { Integer.valueOf(WebSearchVoiceInputLayoutImpl.e(WebSearchVoiceInputLayoutImpl.this)), Boolean.valueOf(WebSearchVoiceInputLayoutImpl.f(WebSearchVoiceInputLayoutImpl.this)) });
          if (WebSearchVoiceInputLayoutImpl.f(WebSearchVoiceInputLayoutImpl.this))
          {
            WebSearchVoiceInputLayoutImpl.this.Q(true, false);
            WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, false);
            WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, 0L);
          }
          else
          {
            WebSearchVoiceInputLayoutImpl.this.Q(false, true);
          }
        }
      }
    };
    init(paramContext);
    AppMethodBeat.o(32033);
  }
  
  public WebSearchVoiceInputLayoutImpl(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(32032);
    this.tOE = false;
    this.aYD = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(32025);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputLayoutImpl$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
        ae.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onLongClickListener currentState %s", new Object[] { Integer.valueOf(WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this)) });
        WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, true);
        WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).ffN();
        a.a(true, this, "com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputLayoutImpl$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(32025);
        return true;
      }
    };
    this.tOH = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(32026);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputLayoutImpl$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          a.a(false, this, "com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputLayoutImpl$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(32026);
          return false;
          WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, false);
          WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, bu.HQ());
          ae.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[] { Integer.valueOf(WebSearchVoiceInputLayoutImpl.c(WebSearchVoiceInputLayoutImpl.this)), Long.valueOf(WebSearchVoiceInputLayoutImpl.d(WebSearchVoiceInputLayoutImpl.this)) });
          WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).ffO();
          WebSearchVoiceInputLayoutImpl.this.Q(false, false);
          continue;
          ae.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_UP currentState %s longClickDown %s", new Object[] { Integer.valueOf(WebSearchVoiceInputLayoutImpl.e(WebSearchVoiceInputLayoutImpl.this)), Boolean.valueOf(WebSearchVoiceInputLayoutImpl.f(WebSearchVoiceInputLayoutImpl.this)) });
          if (WebSearchVoiceInputLayoutImpl.f(WebSearchVoiceInputLayoutImpl.this))
          {
            WebSearchVoiceInputLayoutImpl.this.Q(true, false);
            WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, false);
            WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, 0L);
          }
          else
          {
            WebSearchVoiceInputLayoutImpl.this.Q(false, true);
          }
        }
      }
    };
    init(paramContext);
    AppMethodBeat.o(32032);
  }
  
  private void cWN()
  {
    AppMethodBeat.i(32036);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32027);
        WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).ffQ();
        AppMethodBeat.o(32027);
      }
    });
    cXa();
    AppMethodBeat.o(32036);
  }
  
  private static boolean cWP()
  {
    AppMethodBeat.i(32037);
    int i = bc.ajj().aFd();
    if ((i == 4) || (i == 6))
    {
      AppMethodBeat.o(32037);
      return true;
    }
    AppMethodBeat.o(32037);
    return false;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(32034);
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
      AppMethodBeat.o(32034);
      return;
    }
    if (!cWP()) {
      cWN();
    }
    AppMethodBeat.o(32034);
  }
  
  private static void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(32042);
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      ar.f(paramRunnable);
      AppMethodBeat.o(32042);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(32042);
  }
  
  public final void Hy(final int paramInt)
  {
    AppMethodBeat.i(32041);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32031);
        WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).Zr(paramInt);
        AppMethodBeat.o(32031);
      }
    });
    AppMethodBeat.o(32041);
  }
  
  public final void Q(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(32035);
    ae.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "directStart currentState = %s longUp = %s clickUp = %s", new Object[] { Integer.valueOf(this.currentState), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (this.currentState == 1)
    {
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        if (!cWP())
        {
          cWN();
          AppMethodBeat.o(32035);
          return;
        }
        cWX();
        AppMethodBeat.o(32035);
        return;
      }
      if ((paramBoolean1) && (!paramBoolean2))
      {
        this.FmT.cWB();
        AppMethodBeat.o(32035);
      }
    }
    else if (this.currentState == 2)
    {
      if (!paramBoolean2)
      {
        cWY();
        AppMethodBeat.o(32035);
        return;
      }
      this.FmT.cWB();
      aOx();
      if (this.FmR != null)
      {
        this.FmR.cWM();
        AppMethodBeat.o(32035);
      }
    }
    else
    {
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        aOx();
        AppMethodBeat.o(32035);
        return;
      }
      if ((paramBoolean1) && (!paramBoolean2)) {
        this.FmT.cWB();
      }
    }
    AppMethodBeat.o(32035);
  }
  
  public final void cWQ()
  {
    AppMethodBeat.i(32038);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32028);
        WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).vR(this.tOJ);
        AppMethodBeat.o(32028);
      }
    });
    AppMethodBeat.o(32038);
  }
  
  public final void gu(boolean paramBoolean)
  {
    AppMethodBeat.i(32039);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32029);
        WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).ffP();
        AppMethodBeat.o(32029);
      }
    });
    AppMethodBeat.o(32039);
  }
  
  public final void onReset()
  {
    AppMethodBeat.i(32040);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32030);
        WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).cWB();
        AppMethodBeat.o(32030);
      }
    });
    AppMethodBeat.o(32040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.websearch.WebSearchVoiceInputLayoutImpl
 * JD-Core Version:    0.7.0.1
 */