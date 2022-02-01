package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.walletlock.a.d;
import com.tencent.mm.plugin.walletlock.a.e;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;

final class a
{
  TextView WgS;
  FrameLayout WgT;
  PatternLockView WgU;
  TextView WgV;
  View mView;
  
  public a(Activity paramActivity)
  {
    AppMethodBeat.i(129853);
    this.mView = null;
    this.WgS = null;
    this.WgT = null;
    this.WgU = null;
    this.WgV = null;
    this.mView = View.inflate(paramActivity, a.e.Wez, null);
    this.WgS = ((TextView)this.mView.findViewById(a.d.goF));
    this.WgT = ((FrameLayout)this.mView.findViewById(a.d.Wev));
    this.WgU = ((PatternLockView)this.mView.findViewById(a.d.Weu));
    this.WgV = ((TextView)this.mView.findViewById(a.d.Wex));
    AppMethodBeat.o(129853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.a
 * JD-Core Version:    0.7.0.1
 */