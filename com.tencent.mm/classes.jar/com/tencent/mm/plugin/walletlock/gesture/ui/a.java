package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;

final class a
{
  View mView;
  TextView uFl;
  FrameLayout uFm;
  PatternLockView uFn;
  TextView uFo;
  
  public a(Activity paramActivity)
  {
    AppMethodBeat.i(51648);
    this.mView = null;
    this.uFl = null;
    this.uFm = null;
    this.uFn = null;
    this.uFo = null;
    this.mView = View.inflate(paramActivity, 2130969904, null);
    this.uFl = ((TextView)this.mView.findViewById(2131825143));
    this.uFm = ((FrameLayout)this.mView.findViewById(2131825145));
    this.uFn = ((PatternLockView)this.mView.findViewById(2131825146));
    this.uFo = ((TextView)this.mView.findViewById(2131825144));
    AppMethodBeat.o(51648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.a
 * JD-Core Version:    0.7.0.1
 */