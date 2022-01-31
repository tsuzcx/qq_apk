package com.tencent.mm.view;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.footer.SelectColorBar;

final class a$7
  implements CompoundButton.OnCheckedChangeListener
{
  a$7(a parama, SelectColorBar paramSelectColorBar) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(116378);
    if (paramBoolean)
    {
      this.AQE.setSelectColor(((Integer)a.c(this.AQD).getTag()).intValue());
      a.b(this.AQD).setTextBackground(((Integer)a.c(this.AQD).getTag()).intValue());
      AppMethodBeat.o(116378);
      return;
    }
    a.c(this.AQD).setTag(Integer.valueOf(this.AQE.getCurColor()));
    a.b(this.AQD).setTextBackground(0);
    AppMethodBeat.o(116378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.a.7
 * JD-Core Version:    0.7.0.1
 */