package com.tencent.mm.search.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/search/ui/SimilarEmojiDialog$galleryScale$1$onGalleryExitFromTop$1$1"})
final class b$b$a
  implements Runnable
{
  b$b$a(b.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(202409);
    new ap().post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(202408);
        if (this.LAs.LAr.EZw.isShowing()) {
          this.LAs.LAr.EZw.cancel();
        }
        AppMethodBeat.o(202408);
      }
    });
    AppMethodBeat.o(202409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.search.c.b.b.a
 * JD-Core Version:    0.7.0.1
 */