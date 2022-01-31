package com.tencent.mm.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMRadioGroupView$a
  implements MMRadioImageButton.a
{
  MMRadioGroupView$a(MMRadioGroupView paramMMRadioGroupView) {}
  
  public final void a(MMRadioImageButton paramMMRadioImageButton)
  {
    AppMethodBeat.i(106747);
    if (MMRadioGroupView.a(this.zlW) != -1) {
      MMRadioGroupView.a(this.zlW, MMRadioGroupView.a(this.zlW));
    }
    int i = paramMMRadioImageButton.getId();
    MMRadioGroupView.a(this.zlW, paramMMRadioImageButton);
    MMRadioGroupView.b(this.zlW, i);
    AppMethodBeat.o(106747);
  }
  
  public final void b(MMRadioImageButton paramMMRadioImageButton)
  {
    AppMethodBeat.i(106748);
    MMRadioGroupView.c(this.zlW, paramMMRadioImageButton.getId());
    AppMethodBeat.o(106748);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMRadioGroupView.a
 * JD-Core Version:    0.7.0.1
 */