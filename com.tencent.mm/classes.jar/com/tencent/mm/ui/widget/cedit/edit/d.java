package com.tencent.mm.ui.widget.cedit.edit;

import android.view.ActionMode;
import android.view.textclassifier.TextClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;

public final class d
{
  private final b afYi;
  private final CustomTextView afZe;
  TextClassification agco;
  
  d(b paramb)
  {
    AppMethodBeat.i(252388);
    this.afYi = ((b)Objects.requireNonNull(paramb));
    this.afZe = this.afYi.afZe;
    AppMethodBeat.o(252388);
  }
  
  private static CharSequence c(CustomTextView paramCustomTextView)
  {
    AppMethodBeat.i(252399);
    paramCustomTextView = paramCustomTextView.getText();
    if (paramCustomTextView != null)
    {
      AppMethodBeat.o(252399);
      return paramCustomTextView;
    }
    AppMethodBeat.o(252399);
    return "";
  }
  
  final void jHd()
  {
    AppMethodBeat.i(252405);
    c(this.afZe);
    this.agco = null;
    if (this.afYi.jGz())
    {
      b.n localn = this.afYi.jGF();
      if ((localn != null) && ((this.afZe.jFu()) || (this.afZe.jFD()))) {
        localn.show();
      }
    }
    this.afYi.afZI = false;
    AppMethodBeat.o(252405);
  }
  
  final void jHe()
  {
    AppMethodBeat.i(252417);
    this.agco = null;
    ActionMode localActionMode = this.afYi.afZk;
    if (localActionMode != null) {
      localActionMode.invalidate();
    }
    AppMethodBeat.o(252417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.edit.d
 * JD-Core Version:    0.7.0.1
 */