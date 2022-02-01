package com.tencent.mm.ui.widget.cedit.edit;

import android.view.ActionMode;
import android.view.textclassifier.TextClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;

public final class d
{
  private final b Ygi;
  private final CustomTextView Yhe;
  TextClassification Ykp;
  
  d(b paramb)
  {
    AppMethodBeat.i(194428);
    this.Ygi = ((b)Objects.requireNonNull(paramb));
    this.Yhe = this.Ygi.Yhe;
    AppMethodBeat.o(194428);
  }
  
  private static CharSequence c(CustomTextView paramCustomTextView)
  {
    AppMethodBeat.i(194432);
    paramCustomTextView = paramCustomTextView.getText();
    if (paramCustomTextView != null)
    {
      AppMethodBeat.o(194432);
      return paramCustomTextView;
    }
    AppMethodBeat.o(194432);
    return "";
  }
  
  final void ibT()
  {
    AppMethodBeat.i(194429);
    c(this.Yhe);
    this.Ykp = null;
    if (this.Ygi.ibp())
    {
      b.n localn = this.Ygi.ibv();
      if ((localn != null) && ((this.Yhe.ial()) || (this.Yhe.iaw()))) {
        localn.show();
      }
    }
    this.Ygi.YhI = false;
    AppMethodBeat.o(194429);
  }
  
  final void ibU()
  {
    AppMethodBeat.i(194431);
    this.Ykp = null;
    ActionMode localActionMode = this.Ygi.Yhk;
    if (localActionMode != null) {
      localActionMode.invalidate();
    }
    AppMethodBeat.o(194431);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.edit.d
 * JD-Core Version:    0.7.0.1
 */