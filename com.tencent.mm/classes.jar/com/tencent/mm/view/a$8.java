package com.tencent.mm.view;

import android.widget.Switch;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.footer.SelectColorBar.a;

final class a$8
  implements SelectColorBar.a
{
  a$8(a parama) {}
  
  public final void RE(int paramInt)
  {
    AppMethodBeat.i(116379);
    if (a.c(this.AQD).isChecked())
    {
      a.c(this.AQD).setTag(Integer.valueOf(paramInt));
      a.b(this.AQD).setTextBackground(paramInt);
      AppMethodBeat.o(116379);
      return;
    }
    a.b(this.AQD).setTextColor(paramInt);
    AppMethodBeat.o(116379);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.view.a.8
 * JD-Core Version:    0.7.0.1
 */