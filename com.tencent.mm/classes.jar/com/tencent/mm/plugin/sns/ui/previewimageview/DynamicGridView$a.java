package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Stack;

final class DynamicGridView$a
{
  List<Pair<Integer, Integer>> ASf;
  
  DynamicGridView$a()
  {
    AppMethodBeat.i(100319);
    this.ASf = new Stack();
    AppMethodBeat.o(100319);
  }
  
  public final void ia(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100320);
    this.ASf.add(new Pair(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)));
    AppMethodBeat.o(100320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.a
 * JD-Core Version:    0.7.0.1
 */