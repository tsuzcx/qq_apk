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
import com.tencent.mm.model.az;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a;
import com.tencent.mm.pluginsdk.ui.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;

@TargetApi(16)
public class WebSearchVoiceInputLayoutImpl
  extends VoiceInputLayout
{
  private k BXd;
  private View.OnLongClickListener aNt;
  private View rxZ;
  private boolean ryc;
  private long rye;
  private View.OnTouchListener ryf;
  
  public WebSearchVoiceInputLayoutImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(32033);
    this.ryc = false;
    this.aNt = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(32025);
        ad.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onLongClickListener currentState %s", new Object[] { Integer.valueOf(WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this)) });
        WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, true);
        WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).exG();
        AppMethodBeat.o(32025);
        return true;
      }
    };
    this.ryf = new View.OnTouchListener()
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
          WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, bt.GC());
          ad.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[] { Integer.valueOf(WebSearchVoiceInputLayoutImpl.c(WebSearchVoiceInputLayoutImpl.this)), Long.valueOf(WebSearchVoiceInputLayoutImpl.d(WebSearchVoiceInputLayoutImpl.this)) });
          WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).exH();
          WebSearchVoiceInputLayoutImpl.this.M(false, false);
          continue;
          ad.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_UP currentState %s longClickDown %s", new Object[] { Integer.valueOf(WebSearchVoiceInputLayoutImpl.e(WebSearchVoiceInputLayoutImpl.this)), Boolean.valueOf(WebSearchVoiceInputLayoutImpl.f(WebSearchVoiceInputLayoutImpl.this)) });
          if (WebSearchVoiceInputLayoutImpl.f(WebSearchVoiceInputLayoutImpl.this))
          {
            WebSearchVoiceInputLayoutImpl.this.M(true, false);
            WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, false);
            WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, 0L);
          }
          else
          {
            WebSearchVoiceInputLayoutImpl.this.M(false, true);
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
    this.ryc = false;
    this.aNt = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(32025);
        ad.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onLongClickListener currentState %s", new Object[] { Integer.valueOf(WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this)) });
        WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, true);
        WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).exG();
        AppMethodBeat.o(32025);
        return true;
      }
    };
    this.ryf = new View.OnTouchListener()
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
          WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, bt.GC());
          ad.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[] { Integer.valueOf(WebSearchVoiceInputLayoutImpl.c(WebSearchVoiceInputLayoutImpl.this)), Long.valueOf(WebSearchVoiceInputLayoutImpl.d(WebSearchVoiceInputLayoutImpl.this)) });
          WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).exH();
          WebSearchVoiceInputLayoutImpl.this.M(false, false);
          continue;
          ad.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_UP currentState %s longClickDown %s", new Object[] { Integer.valueOf(WebSearchVoiceInputLayoutImpl.e(WebSearchVoiceInputLayoutImpl.this)), Boolean.valueOf(WebSearchVoiceInputLayoutImpl.f(WebSearchVoiceInputLayoutImpl.this)) });
          if (WebSearchVoiceInputLayoutImpl.f(WebSearchVoiceInputLayoutImpl.this))
          {
            WebSearchVoiceInputLayoutImpl.this.M(true, false);
            WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, false);
            WebSearchVoiceInputLayoutImpl.a(WebSearchVoiceInputLayoutImpl.this, 0L);
          }
          else
          {
            WebSearchVoiceInputLayoutImpl.this.M(false, true);
          }
        }
      }
    };
    init(paramContext);
    AppMethodBeat.o(32032);
  }
  
  private void cyD()
  {
    AppMethodBeat.i(32036);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32027);
        WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).exJ();
        AppMethodBeat.o(32027);
      }
    });
    cyQ();
    AppMethodBeat.o(32036);
  }
  
  private static boolean cyF()
  {
    AppMethodBeat.i(32037);
    int i = az.aeS().auR();
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
    this.rxZ = inflate(paramContext, 2131495858, this).findViewById(2131306533);
    this.rxZ.setLayerType(1, null);
    this.BXd = new k(paramContext);
    this.rxZ.setBackground(this.BXd);
    this.rxZ.setEnabled(true);
    this.rxZ.setOnTouchListener(this.ryf);
    this.rxZ.setOnLongClickListener(this.aNt);
    reset(true);
    if (isInEditMode())
    {
      AppMethodBeat.o(32034);
      return;
    }
    if (!cyF()) {
      cyD();
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
  
  public final void DQ(final int paramInt)
  {
    AppMethodBeat.i(32041);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32031);
        WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).UF(paramInt);
        AppMethodBeat.o(32031);
      }
    });
    AppMethodBeat.o(32041);
  }
  
  public final void M(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(32035);
    ad.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "directStart currentState = %s longUp = %s clickUp = %s", new Object[] { Integer.valueOf(this.currentState), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (this.currentState == 1)
    {
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        if (!cyF())
        {
          cyD();
          AppMethodBeat.o(32035);
          return;
        }
        cyN();
        AppMethodBeat.o(32035);
        return;
      }
      if ((paramBoolean1) && (!paramBoolean2))
      {
        this.BXd.cyr();
        AppMethodBeat.o(32035);
      }
    }
    else if (this.currentState == 2)
    {
      if (!paramBoolean2)
      {
        cyO();
        AppMethodBeat.o(32035);
        return;
      }
      this.BXd.cyr();
      aDZ();
      if (this.BXb != null)
      {
        this.BXb.cyC();
        AppMethodBeat.o(32035);
      }
    }
    else
    {
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        aDZ();
        AppMethodBeat.o(32035);
        return;
      }
      if ((paramBoolean1) && (!paramBoolean2)) {
        this.BXd.cyr();
      }
    }
    AppMethodBeat.o(32035);
  }
  
  public final void cyG()
  {
    AppMethodBeat.i(32038);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32028);
        WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).tX(this.ryh);
        AppMethodBeat.o(32028);
      }
    });
    AppMethodBeat.o(32038);
  }
  
  public final void fU(boolean paramBoolean)
  {
    AppMethodBeat.i(32039);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32029);
        WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).exI();
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
        WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).cyr();
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