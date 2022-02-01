package com.tencent.mm.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.d;
import java.util.List;

final class MultiTabView$1
  extends d
{
  MultiTabView$1(MultiTabView paramMultiTabView, Context paramContext)
  {
    super(paramContext);
  }
  
  public final void Mh(int paramInt) {}
  
  public final View a(View paramView, ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(164223);
    paramView = (View)MultiTabView.a(this.Lpa).get(paramInt);
    AppMethodBeat.o(164223);
    return paramView;
  }
  
  public final int dwY()
  {
    AppMethodBeat.i(164224);
    int i = MultiTabView.a(this.Lpa).size();
    AppMethodBeat.o(164224);
    return i;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(164225);
    int i = MultiTabView.a(this.Lpa).size();
    AppMethodBeat.o(164225);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MultiTabView.1
 * JD-Core Version:    0.7.0.1
 */