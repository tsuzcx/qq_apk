package com.tencent.mm.plugin.sight.draft.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.j;

final class b$b
  implements View.OnLongClickListener
{
  private b$b(b paramb) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(24999);
    if (!(paramView.getTag() instanceof b.e))
    {
      AppMethodBeat.o(24999);
      return true;
    }
    paramView = (b.e)paramView.getTag();
    if (paramView.qVg == null)
    {
      AppMethodBeat.o(24999);
      return true;
    }
    if (-1 == paramView.qVg.field_fileStatus)
    {
      AppMethodBeat.o(24999);
      return true;
    }
    this.qUZ.a(b.d.qVb, true);
    AppMethodBeat.o(24999);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.b.b
 * JD-Core Version:    0.7.0.1
 */