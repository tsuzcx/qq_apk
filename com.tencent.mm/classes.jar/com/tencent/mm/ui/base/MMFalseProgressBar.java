package com.tencent.mm.ui.base;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;

public class MMFalseProgressBar
  extends ProgressBar
{
  private float Tb;
  private float jaD;
  private float jaE;
  private float jaF;
  private float jaG;
  public boolean jaH;
  private ak mHandler;
  private boolean mIsStart;
  
  public MMFalseProgressBar(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(106534);
    dDQ();
    AppMethodBeat.o(106534);
  }
  
  public MMFalseProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MMFalseProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(106535);
    this.mIsStart = false;
    this.Tb = 0.0F;
    this.jaH = true;
    this.mHandler = new ak(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(106533);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(106533);
          return;
          MMFalseProgressBar.a(MMFalseProgressBar.this);
          AppMethodBeat.o(106533);
          return;
          MMFalseProgressBar.b(MMFalseProgressBar.this);
          AppMethodBeat.o(106533);
          return;
          MMFalseProgressBar.c(MMFalseProgressBar.this);
          AppMethodBeat.o(106533);
          return;
          MMFalseProgressBar.d(MMFalseProgressBar.this);
        }
      }
    };
    setMax(1000);
    dDQ();
    AppMethodBeat.o(106535);
  }
  
  private void dDQ()
  {
    AppMethodBeat.i(106538);
    if (at.ha(ah.getContext()))
    {
      this.jaD = 4.0F;
      this.jaE = 1.0F;
      this.jaF = 0.3F;
      this.jaG = 50.0F;
      AppMethodBeat.o(106538);
      return;
    }
    this.jaD = 2.0F;
    this.jaE = 0.5F;
    this.jaF = 0.15F;
    this.jaG = 50.0F;
    AppMethodBeat.o(106538);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(106537);
    ab.d("MicroMsg.MMFalseProgressBar", "[cpan] finish");
    if (this.mHandler != null) {
      this.mHandler.sendEmptyMessage(1002);
    }
    AppMethodBeat.o(106537);
  }
  
  public final void start()
  {
    AppMethodBeat.i(106536);
    ab.d("MicroMsg.MMFalseProgressBar", "[cpan] start");
    if (!this.jaH)
    {
      AppMethodBeat.o(106536);
      return;
    }
    if (this.mIsStart)
    {
      AppMethodBeat.o(106536);
      return;
    }
    this.mIsStart = true;
    dDQ();
    if (this.mHandler != null)
    {
      this.mHandler.sendEmptyMessage(1000);
      this.mHandler.sendEmptyMessage(1001);
    }
    AppMethodBeat.o(106536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFalseProgressBar
 * JD-Core Version:    0.7.0.1
 */