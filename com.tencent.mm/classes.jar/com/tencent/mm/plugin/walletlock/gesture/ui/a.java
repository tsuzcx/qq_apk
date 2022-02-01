package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;

final class a
{
  TextView Dvg;
  FrameLayout Dvh;
  PatternLockView Dvi;
  TextView Dvj;
  View mView;
  
  public a(Activity paramActivity)
  {
    AppMethodBeat.i(129853);
    this.mView = null;
    this.Dvg = null;
    this.Dvh = null;
    this.Dvi = null;
    this.Dvj = null;
    this.mView = View.inflate(paramActivity, 2131494482, null);
    this.Dvg = ((TextView)this.mView.findViewById(2131306135));
    this.Dvh = ((FrameLayout)this.mView.findViewById(2131303148));
    this.Dvi = ((PatternLockView)this.mView.findViewById(2131303147));
    this.Dvj = ((TextView)this.mView.findViewById(2131306126));
    AppMethodBeat.o(129853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.a
 * JD-Core Version:    0.7.0.1
 */