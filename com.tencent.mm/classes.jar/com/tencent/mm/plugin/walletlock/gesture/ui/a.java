package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;

final class a
{
  TextView BUM;
  FrameLayout BUN;
  PatternLockView BUO;
  TextView BUP;
  View mView;
  
  public a(Activity paramActivity)
  {
    AppMethodBeat.i(129853);
    this.mView = null;
    this.BUM = null;
    this.BUN = null;
    this.BUO = null;
    this.BUP = null;
    this.mView = View.inflate(paramActivity, 2131494482, null);
    this.BUM = ((TextView)this.mView.findViewById(2131306135));
    this.BUN = ((FrameLayout)this.mView.findViewById(2131303148));
    this.BUO = ((PatternLockView)this.mView.findViewById(2131303147));
    this.BUP = ((TextView)this.mView.findViewById(2131306126));
    AppMethodBeat.o(129853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.a
 * JD-Core Version:    0.7.0.1
 */