package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$2
  implements Runnable
{
  e$2(e parame, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(32088);
    if ((this.zLj.zJI == null) || (this.zLj.zJI.zJK == null))
    {
      AppMethodBeat.o(32088);
      return;
    }
    this.zLj.zJI.zJK.Qg(this.gxr);
    AppMethodBeat.o(32088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.e.2
 * JD-Core Version:    0.7.0.1
 */