package com.tencent.mm.plugin.story.ui.view.editor.item;

import a.f.b.j;
import a.l;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class MusicLrcView$b
  implements Runnable
{
  MusicLrcView$b(MusicLrcView paramMusicLrcView, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(110678);
    Scroller localScroller = MusicLrcView.a(this.sRk);
    if (localScroller == null) {
      j.ebi();
    }
    localScroller.startScroll(MusicLrcView.b(this.sRk), 0, this.sRl, 0, this.sRm);
    this.sRk.invalidate();
    AppMethodBeat.o(110678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.item.MusicLrcView.b
 * JD-Core Version:    0.7.0.1
 */