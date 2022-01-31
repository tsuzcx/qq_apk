package com.tencent.mm.view.a;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class j$b
  extends RecyclerView.v
  implements View.OnClickListener
{
  ImageView ASz;
  ImageView cuM;
  
  public j$b(j paramj, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(63007);
    this.cuM = ((ImageView)paramView.findViewById(2131827808));
    this.ASz = ((ImageView)paramView.findViewById(2131827809));
    paramView.setOnClickListener(this);
    AppMethodBeat.o(63007);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(63008);
    if (j.a(this.ASA) != null) {
      j.a(this.ASA).f(jN(), paramView);
    }
    AppMethodBeat.o(63008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.a.j.b
 * JD-Core Version:    0.7.0.1
 */