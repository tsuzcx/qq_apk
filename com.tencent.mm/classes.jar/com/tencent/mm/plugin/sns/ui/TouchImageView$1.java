package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class TouchImageView$1
  implements Runnable
{
  TouchImageView$1(TouchImageView paramTouchImageView) {}
  
  public final void run()
  {
    AppMethodBeat.i(39895);
    this.sdb.setPressed(false);
    this.sdb.invalidate();
    AppMethodBeat.o(39895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.TouchImageView.1
 * JD-Core Version:    0.7.0.1
 */