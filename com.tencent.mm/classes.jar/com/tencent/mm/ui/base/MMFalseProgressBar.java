package com.tencent.mm.ui.base;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ax;

public class MMFalseProgressBar
  extends ProgressBar
{
  private float aaZ;
  private ao mHandler;
  private boolean mIsStart;
  private float msA;
  private float msB;
  private float msC;
  private float msD;
  public boolean msE;
  
  public MMFalseProgressBar(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(141887);
    fip();
    AppMethodBeat.o(141887);
  }
  
  public MMFalseProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MMFalseProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(141888);
    this.mIsStart = false;
    this.aaZ = 0.0F;
    this.msE = true;
    this.mHandler = new ao(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(141886);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(141886);
          return;
          MMFalseProgressBar.a(MMFalseProgressBar.this);
          AppMethodBeat.o(141886);
          return;
          MMFalseProgressBar.b(MMFalseProgressBar.this);
          AppMethodBeat.o(141886);
          return;
          MMFalseProgressBar.c(MMFalseProgressBar.this);
          AppMethodBeat.o(141886);
          return;
          MMFalseProgressBar.d(MMFalseProgressBar.this);
        }
      }
    };
    setMax(1000);
    fip();
    AppMethodBeat.o(141888);
  }
  
  private void fip()
  {
    AppMethodBeat.i(141891);
    if (ax.iO(ai.getContext()))
    {
      this.msA = 4.0F;
      this.msB = 1.0F;
      this.msC = 0.3F;
      this.msD = 50.0F;
      AppMethodBeat.o(141891);
      return;
    }
    this.msA = 2.0F;
    this.msB = 0.5F;
    this.msC = 0.15F;
    this.msD = 50.0F;
    AppMethodBeat.o(141891);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(141890);
    ac.d("MicroMsg.MMFalseProgressBar", "[cpan] finish");
    if (this.mHandler != null) {
      this.mHandler.sendEmptyMessage(1002);
    }
    AppMethodBeat.o(141890);
  }
  
  public final void start()
  {
    AppMethodBeat.i(141889);
    ac.d("MicroMsg.MMFalseProgressBar", "[cpan] start");
    if (!this.msE)
    {
      AppMethodBeat.o(141889);
      return;
    }
    if (this.mIsStart)
    {
      AppMethodBeat.o(141889);
      return;
    }
    this.mIsStart = true;
    fip();
    if (this.mHandler != null)
    {
      this.mHandler.sendEmptyMessage(1000);
      this.mHandler.sendEmptyMessage(1001);
    }
    AppMethodBeat.o(141889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFalseProgressBar
 * JD-Core Version:    0.7.0.1
 */