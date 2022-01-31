package com.tencent.mm.pluginsdk.ui;

import com.tencent.mm.sdk.platformtools.am.a;

final class AbstractVideoView$1
  implements am.a
{
  AbstractVideoView$1(AbstractVideoView paramAbstractVideoView) {}
  
  public final boolean tC()
  {
    if (!this.rYV.isPlaying()) {
      return false;
    }
    if (this.rYV.rYH)
    {
      if (this.rYV.oIn != null) {
        this.rYV.oIn.bK(this.rYV.getSessionId(), this.rYV.getMediaId());
      }
      this.rYV.rYH = false;
    }
    this.rYV.nD(this.rYV.getCurrPosSec());
    AbstractVideoView.a(this.rYV, this.rYV.isPlaying());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.AbstractVideoView.1
 * JD-Core Version:    0.7.0.1
 */