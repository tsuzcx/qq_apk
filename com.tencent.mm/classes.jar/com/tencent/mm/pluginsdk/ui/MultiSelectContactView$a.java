package com.tencent.mm.pluginsdk.ui;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class MultiSelectContactView$a
  extends RecyclerView.a<MultiSelectContactView.b>
{
  MultiSelectContactView$a(MultiSelectContactView paramMultiSelectContactView) {}
  
  public final int getItemCount()
  {
    AppMethodBeat.i(146165);
    int i = MultiSelectContactView.b(this.vRm).size();
    AppMethodBeat.o(146165);
    return i + 1;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(146164);
    if (paramInt == getItemCount() - 1)
    {
      AppMethodBeat.o(146164);
      return 1;
    }
    AppMethodBeat.o(146164);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.MultiSelectContactView.a
 * JD-Core Version:    0.7.0.1
 */