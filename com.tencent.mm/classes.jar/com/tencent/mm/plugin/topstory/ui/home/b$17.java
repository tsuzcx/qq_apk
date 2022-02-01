package com.tencent.mm.plugin.topstory.ui.home;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView.e;
import java.util.List;

final class b$17
  implements MMWebView.e
{
  b$17(b paramb) {}
  
  public final void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(125953);
    b.a locala = (b.a)this.BsG.Ady.get(this.BsG.sEa);
    locala.BsZ -= 1;
    AppMethodBeat.o(125953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b.17
 * JD-Core Version:    0.7.0.1
 */