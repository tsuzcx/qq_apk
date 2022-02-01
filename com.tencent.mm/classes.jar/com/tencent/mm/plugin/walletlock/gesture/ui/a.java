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
  TextView Pqf;
  FrameLayout Pqg;
  PatternLockView Pqh;
  TextView Pqi;
  View mView;
  
  public a(Activity paramActivity)
  {
    AppMethodBeat.i(129853);
    this.mView = null;
    this.Pqf = null;
    this.Pqg = null;
    this.Pqh = null;
    this.Pqi = null;
    this.mView = View.inflate(paramActivity, a.e.PnY, null);
    this.Pqf = ((TextView)this.mView.findViewById(a.d.elB));
    this.Pqg = ((FrameLayout)this.mView.findViewById(a.d.PnU));
    this.Pqh = ((PatternLockView)this.mView.findViewById(a.d.PnT));
    this.Pqi = ((TextView)this.mView.findViewById(a.d.PnW));
    AppMethodBeat.o(129853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.a
 * JD-Core Version:    0.7.0.1
 */