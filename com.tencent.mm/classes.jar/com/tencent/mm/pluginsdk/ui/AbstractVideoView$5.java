package com.tencent.mm.pluginsdk.ui;

import com.tencent.mm.sdk.platformtools.am.a;

final class AbstractVideoView$5
  implements am.a
{
  AbstractVideoView$5(AbstractVideoView paramAbstractVideoView) {}
  
  public final boolean tC()
  {
    if (AbstractVideoView.a(this.rYV) > 0)
    {
      if (this.rYV.isPlaying()) {
        AbstractVideoView.b(this.rYV);
      }
    }
    else {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.AbstractVideoView.5
 * JD-Core Version:    0.7.0.1
 */