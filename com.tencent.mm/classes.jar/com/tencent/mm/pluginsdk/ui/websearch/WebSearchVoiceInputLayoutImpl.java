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
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a;
import com.tencent.mm.pluginsdk.ui.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

@TargetApi(16)
public class WebSearchVoiceInputLayoutImpl
  extends VoiceInputLayout
{
  private l KdL;
  private View.OnLongClickListener aYy;
  private View.OnTouchListener aZa;
  private View xfA;
  private boolean xfD;
  private long xfF;
  
  public WebSearchVoiceInputLayoutImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(32033);
    this.xfD = false;
    this.aYy = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(32025);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputLayoutImpl$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        Log.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onLongClickListener currentState %s", new Object[] { Integer.valueOf(WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this)) });
        WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, true);
        WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).goW();
        a.a(true, this, "com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputLayoutImpl$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(32025);
        return true;
      }
    };
    this.aZa = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(32026);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(32026);
          return false;
          WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, false);
          WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, Util.currentTicks());
          Log.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[] { Integer.valueOf(WebSearchVoiceInputLayoutImpl.c(WebSearchVoiceInputLayoutImpl.this)), Long.valueOf(WebSearchVoiceInputLayoutImpl.d(WebSearchVoiceInputLayoutImpl.this)) });
          WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).goX();
          WebSearchVoiceInputLayoutImpl.this.T(false, false);
          continue;
          Log.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_UP currentState %s longClickDown %s", new Object[] { Integer.valueOf(WebSearchVoiceInputLayoutImpl.e(WebSearchVoiceInputLayoutImpl.this)), Boolean.valueOf(WebSearchVoiceInputLayoutImpl.f(WebSearchVoiceInputLayoutImpl.this)) });
          if (WebSearchVoiceInputLayoutImpl.f(WebSearchVoiceInputLayoutImpl.this))
          {
            WebSearchVoiceInputLayoutImpl.this.T(true, false);
            WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, false);
            WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, 0L);
          }
          else
          {
            WebSearchVoiceInputLayoutImpl.this.T(false, true);
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
    this.xfD = false;
    this.aYy = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(32025);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputLayoutImpl$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        Log.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onLongClickListener currentState %s", new Object[] { Integer.valueOf(WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this)) });
        WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, true);
        WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).goW();
        a.a(true, this, "com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputLayoutImpl$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(32025);
        return true;
      }
    };
    this.aZa = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(32026);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(32026);
          return false;
          WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, false);
          WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, Util.currentTicks());
          Log.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[] { Integer.valueOf(WebSearchVoiceInputLayoutImpl.c(WebSearchVoiceInputLayoutImpl.this)), Long.valueOf(WebSearchVoiceInputLayoutImpl.d(WebSearchVoiceInputLayoutImpl.this)) });
          WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).goX();
          WebSearchVoiceInputLayoutImpl.this.T(false, false);
          continue;
          Log.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_UP currentState %s longClickDown %s", new Object[] { Integer.valueOf(WebSearchVoiceInputLayoutImpl.e(WebSearchVoiceInputLayoutImpl.this)), Boolean.valueOf(WebSearchVoiceInputLayoutImpl.f(WebSearchVoiceInputLayoutImpl.this)) });
          if (WebSearchVoiceInputLayoutImpl.f(WebSearchVoiceInputLayoutImpl.this))
          {
            WebSearchVoiceInputLayoutImpl.this.T(true, false);
            WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, false);
            WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, 0L);
          }
          else
          {
            WebSearchVoiceInputLayoutImpl.this.T(false, true);
          }
        }
      }
    };
    init(paramContext);
    AppMethodBeat.o(32032);
  }
  
  private void dPX()
  {
    AppMethodBeat.i(32036);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32027);
        WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).goZ();
        AppMethodBeat.o(32027);
      }
    });
    dQp();
    AppMethodBeat.o(32036);
  }
  
  private static boolean dzA()
  {
    AppMethodBeat.i(32037);
    int i = bg.azz().aYS();
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
      AppMethodBeat.o(32034);
      return;
    }
    if (!dzA()) {
      dPX();
    }
    AppMethodBeat.o(32034);
  }
  
  private static void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(32042);
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      MMHandlerThread.postToMainThread(paramRunnable);
      AppMethodBeat.o(32042);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(32042);
  }
  
  public final void Ny(final int paramInt)
  {
    AppMethodBeat.i(32041);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32031);
        WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).aic(paramInt);
        AppMethodBeat.o(32031);
      }
    });
    AppMethodBeat.o(32041);
  }
  
  public final void T(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(32035);
    Log.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "directStart currentState = %s longUp = %s clickUp = %s", new Object[] { Integer.valueOf(this.currentState), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (this.currentState == 1)
    {
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        if (!dzA())
        {
          dPX();
          AppMethodBeat.o(32035);
          return;
        }
        dQm();
        AppMethodBeat.o(32035);
        return;
      }
      if ((paramBoolean1) && (!paramBoolean2))
      {
        this.KdL.dPL();
        AppMethodBeat.o(32035);
      }
    }
    else if (this.currentState == 2)
    {
      if (!paramBoolean2)
      {
        dQn();
        AppMethodBeat.o(32035);
        return;
      }
      this.KdL.dPL();
      biE();
      if (this.KdJ != null)
      {
        this.KdJ.dPW();
        AppMethodBeat.o(32035);
      }
    }
    else
    {
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        biE();
        AppMethodBeat.o(32035);
        return;
      }
      if ((paramBoolean1) && (!paramBoolean2)) {
        this.KdL.dPL();
      }
    }
    AppMethodBeat.o(32035);
  }
  
  public final void dPZ()
  {
    AppMethodBeat.i(32038);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32028);
        WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).zP(this.xfH);
        AppMethodBeat.o(32028);
      }
    });
    AppMethodBeat.o(32038);
  }
  
  public final void hs(boolean paramBoolean)
  {
    AppMethodBeat.i(32039);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32029);
        WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).goY();
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
        WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).dPL();
        AppMethodBeat.o(32030);
      }
    });
    AppMethodBeat.o(32040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.websearch.WebSearchVoiceInputLayoutImpl
 * JD-Core Version:    0.7.0.1
 */