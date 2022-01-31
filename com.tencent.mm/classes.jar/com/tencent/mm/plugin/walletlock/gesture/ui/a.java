package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.walletlock.a.d;
import com.tencent.mm.plugin.walletlock.a.e;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;

final class a
{
  View mView = null;
  TextView qQd = null;
  FrameLayout qQe = null;
  PatternLockView qQf = null;
  TextView qQg = null;
  
  public a(Activity paramActivity)
  {
    this.mView = View.inflate(paramActivity, a.e.input_pattern_view, null);
    this.qQd = ((TextView)this.mView.findViewById(a.d.tv_info));
    this.qQe = ((FrameLayout)this.mView.findViewById(a.d.pattern_view_wrapper));
    this.qQf = ((PatternLockView)this.mView.findViewById(a.d.pattern_view));
    this.qQg = ((TextView)this.mView.findViewById(a.d.tv_forgotpwd));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.a
 * JD-Core Version:    0.7.0.1
 */