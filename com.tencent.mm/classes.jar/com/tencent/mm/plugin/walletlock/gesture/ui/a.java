package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;

final class a
{
  TextView Iwa;
  FrameLayout Iwb;
  PatternLockView Iwc;
  TextView Iwd;
  View mView;
  
  public a(Activity paramActivity)
  {
    AppMethodBeat.i(129853);
    this.mView = null;
    this.Iwa = null;
    this.Iwb = null;
    this.Iwc = null;
    this.Iwd = null;
    this.mView = View.inflate(paramActivity, 2131495074, null);
    this.Iwa = ((TextView)this.mView.findViewById(2131309495));
    this.Iwb = ((FrameLayout)this.mView.findViewById(2131305800));
    this.Iwc = ((PatternLockView)this.mView.findViewById(2131305799));
    this.Iwd = ((TextView)this.mView.findViewById(2131309484));
    AppMethodBeat.o(129853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.a
 * JD-Core Version:    0.7.0.1
 */