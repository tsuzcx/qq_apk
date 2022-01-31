package com.tencent.mm.plugin.sns.ui;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mm.ui.tools.e;

final class SnsOnlineVideoActivity$3
  implements ViewTreeObserver.OnPreDrawListener
{
  SnsOnlineVideoActivity$3(SnsOnlineVideoActivity paramSnsOnlineVideoActivity) {}
  
  public final boolean onPreDraw()
  {
    SnsOnlineVideoActivity.d(this.pbr).getViewTreeObserver().removeOnPreDrawListener(this);
    SnsOnlineVideoActivity.p(this.pbr).a(SnsOnlineVideoActivity.d(this.pbr), SnsOnlineVideoActivity.j(this.pbr), new SnsOnlineVideoActivity.3.1(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.3
 * JD-Core Version:    0.7.0.1
 */