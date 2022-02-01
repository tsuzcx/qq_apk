package com.tencent.mm.ui.base;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public class MMFalseProgressBar
  extends ProgressBar
{
  private MMHandler mHandler;
  private boolean mIsStart;
  private float mProgress;
  private float olt;
  private float olu;
  private float olv;
  private float olw;
  public boolean olx;
  
  public MMFalseProgressBar(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(141887);
    gKF();
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
    this.mProgress = 0.0F;
    this.olx = true;
    this.mHandler = new MMHandler(Looper.getMainLooper())
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
    gKF();
    AppMethodBeat.o(141888);
  }
  
  private void gKF()
  {
    AppMethodBeat.i(141891);
    if (NetStatusUtil.isWifiOr4G(MMApplicationContext.getContext()))
    {
      this.olt = 4.0F;
      this.olu = 1.0F;
      this.olv = 0.3F;
      this.olw = 50.0F;
      AppMethodBeat.o(141891);
      return;
    }
    this.olt = 2.0F;
    this.olu = 0.5F;
    this.olv = 0.15F;
    this.olw = 50.0F;
    AppMethodBeat.o(141891);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(141890);
    Log.d("MicroMsg.MMFalseProgressBar", "[cpan] finish");
    if (this.mHandler != null) {
      this.mHandler.sendEmptyMessage(1002);
    }
    AppMethodBeat.o(141890);
  }
  
  public final void start()
  {
    AppMethodBeat.i(141889);
    Log.d("MicroMsg.MMFalseProgressBar", "[cpan] start");
    if (!this.olx)
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
    gKF();
    if (this.mHandler != null)
    {
      this.mHandler.sendEmptyMessage(1000);
      this.mHandler.sendEmptyMessage(1001);
    }
    AppMethodBeat.o(141889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFalseProgressBar
 * JD-Core Version:    0.7.0.1
 */