package com.tencent.mm.ui.widget.cedit.edit;

import android.view.ActionMode;
import android.view.textclassifier.TextClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;

public final class d
{
  private final b QHs;
  private final CustomTextView QIo;
  private TextClassification QLx;
  
  d(b paramb)
  {
    AppMethodBeat.i(206034);
    this.QHs = ((b)Objects.requireNonNull(paramb));
    this.QIo = this.QHs.QIo;
    AppMethodBeat.o(206034);
  }
  
  private static CharSequence c(CustomTextView paramCustomTextView)
  {
    AppMethodBeat.i(206037);
    paramCustomTextView = paramCustomTextView.getText();
    if (paramCustomTextView != null)
    {
      AppMethodBeat.o(206037);
      return paramCustomTextView;
    }
    AppMethodBeat.o(206037);
    return "";
  }
  
  final void haU()
  {
    AppMethodBeat.i(206035);
    c(this.QIo);
    this.QLx = null;
    if (this.QHs.har())
    {
      b.n localn = this.QHs.hax();
      if ((localn != null) && ((this.QIo.isTextSelectable()) || (this.QIo.gZB()))) {
        localn.show();
      }
    }
    this.QHs.QIS = false;
    AppMethodBeat.o(206035);
  }
  
  final void haV()
  {
    AppMethodBeat.i(206036);
    this.QLx = null;
    ActionMode localActionMode = this.QHs.QIu;
    if (localActionMode != null) {
      localActionMode.invalidate();
    }
    AppMethodBeat.o(206036);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.edit.d
 * JD-Core Version:    0.7.0.1
 */