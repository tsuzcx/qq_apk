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
import com.tencent.mm.al.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a;
import com.tencent.mm.pluginsdk.ui.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;

@TargetApi(16)
public class WebSearchVoiceInputLayoutImpl
  extends VoiceInputLayout
{
  private l EUy;
  private View.OnLongClickListener aYD;
  private View tDK;
  private boolean tDN;
  private long tDP;
  private View.OnTouchListener tDQ;
  
  public WebSearchVoiceInputLayoutImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(32033);
    this.tDN = false;
    this.aYD = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(32025);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputLayoutImpl$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
        ad.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onLongClickListener currentState %s", new Object[] { Integer.valueOf(WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this)) });
        WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, true);
        WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).fbZ();
        a.a(true, this, "com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputLayoutImpl$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(32025);
        return true;
      }
    };
    this.tDQ = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(32026);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputLayoutImpl$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          a.a(false, this, "com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputLayoutImpl$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(32026);
          return false;
          WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, false);
          WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, bt.HI());
          ad.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[] { Integer.valueOf(WebSearchVoiceInputLayoutImpl.c(WebSearchVoiceInputLayoutImpl.this)), Long.valueOf(WebSearchVoiceInputLayoutImpl.d(WebSearchVoiceInputLayoutImpl.this)) });
          WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).fca();
          WebSearchVoiceInputLayoutImpl.this.R(false, false);
          continue;
          ad.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_UP currentState %s longClickDown %s", new Object[] { Integer.valueOf(WebSearchVoiceInputLayoutImpl.e(WebSearchVoiceInputLayoutImpl.this)), Boolean.valueOf(WebSearchVoiceInputLayoutImpl.f(WebSearchVoiceInputLayoutImpl.this)) });
          if (WebSearchVoiceInputLayoutImpl.f(WebSearchVoiceInputLayoutImpl.this))
          {
            WebSearchVoiceInputLayoutImpl.this.R(true, false);
            WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, false);
            WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, 0L);
          }
          else
          {
            WebSearchVoiceInputLayoutImpl.this.R(false, true);
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
    this.tDN = false;
    this.aYD = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(32025);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputLayoutImpl$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
        ad.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onLongClickListener currentState %s", new Object[] { Integer.valueOf(WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this)) });
        WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, true);
        WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).fbZ();
        a.a(true, this, "com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputLayoutImpl$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(32025);
        return true;
      }
    };
    this.tDQ = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(32026);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputLayoutImpl$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          a.a(false, this, "com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputLayoutImpl$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(32026);
          return false;
          WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, false);
          WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, bt.HI());
          ad.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[] { Integer.valueOf(WebSearchVoiceInputLayoutImpl.c(WebSearchVoiceInputLayoutImpl.this)), Long.valueOf(WebSearchVoiceInputLayoutImpl.d(WebSearchVoiceInputLayoutImpl.this)) });
          WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).fca();
          WebSearchVoiceInputLayoutImpl.this.R(false, false);
          continue;
          ad.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_UP currentState %s longClickDown %s", new Object[] { Integer.valueOf(WebSearchVoiceInputLayoutImpl.e(WebSearchVoiceInputLayoutImpl.this)), Boolean.valueOf(WebSearchVoiceInputLayoutImpl.f(WebSearchVoiceInputLayoutImpl.this)) });
          if (WebSearchVoiceInputLayoutImpl.f(WebSearchVoiceInputLayoutImpl.this))
          {
            WebSearchVoiceInputLayoutImpl.this.R(true, false);
            WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, false);
            WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, 0L);
          }
          else
          {
            WebSearchVoiceInputLayoutImpl.this.R(false, true);
          }
        }
      }
    };
    init(paramContext);
    AppMethodBeat.o(32032);
  }
  
  private void cUi()
  {
    AppMethodBeat.i(32036);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32027);
        WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).fcc();
        AppMethodBeat.o(32027);
      }
    });
    cUv();
    AppMethodBeat.o(32036);
  }
  
  private static boolean cUk()
  {
    AppMethodBeat.i(32037);
    int i = ba.aiU().aEN();
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
      AppMethodBeat.o(32034);
      return;
    }
    if (!cUk()) {
      cUi();
    }
    AppMethodBeat.o(32034);
  }
  
  private static void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(32042);
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      aq.f(paramRunnable);
      AppMethodBeat.o(32042);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(32042);
  }
  
  public final void Hb(final int paramInt)
  {
    AppMethodBeat.i(32041);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32031);
        WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).YL(paramInt);
        AppMethodBeat.o(32031);
      }
    });
    AppMethodBeat.o(32041);
  }
  
  public final void R(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(32035);
    ad.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "directStart currentState = %s longUp = %s clickUp = %s", new Object[] { Integer.valueOf(this.currentState), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (this.currentState == 1)
    {
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        if (!cUk())
        {
          cUi();
          AppMethodBeat.o(32035);
          return;
        }
        cUs();
        AppMethodBeat.o(32035);
        return;
      }
      if ((paramBoolean1) && (!paramBoolean2))
      {
        this.EUy.cTW();
        AppMethodBeat.o(32035);
      }
    }
    else if (this.currentState == 2)
    {
      if (!paramBoolean2)
      {
        cUt();
        AppMethodBeat.o(32035);
        return;
      }
      this.EUy.cTW();
      aNZ();
      if (this.EUw != null)
      {
        this.EUw.cUh();
        AppMethodBeat.o(32035);
      }
    }
    else
    {
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        aNZ();
        AppMethodBeat.o(32035);
        return;
      }
      if ((paramBoolean1) && (!paramBoolean2)) {
        this.EUy.cTW();
      }
    }
    AppMethodBeat.o(32035);
  }
  
  public final void cUl()
  {
    AppMethodBeat.i(32038);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32028);
        WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).vJ(this.tDS);
        AppMethodBeat.o(32028);
      }
    });
    AppMethodBeat.o(32038);
  }
  
  public final void gw(boolean paramBoolean)
  {
    AppMethodBeat.i(32039);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32029);
        WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).fcb();
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
        WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).cTW();
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