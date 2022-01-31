package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.ui.tools.e.b;

final class SnsOnlineVideoActivity$3$1
  implements e.b
{
  SnsOnlineVideoActivity$3$1(SnsOnlineVideoActivity.3 param3) {}
  
  public final void onAnimationEnd()
  {
    if (SnsOnlineVideoActivity.d(this.pbs.pbr) != null) {
      SnsOnlineVideoActivity.d(this.pbs.pbr).onResume();
    }
  }
  
  public final void onAnimationStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.3.1
 * JD-Core Version:    0.7.0.1
 */