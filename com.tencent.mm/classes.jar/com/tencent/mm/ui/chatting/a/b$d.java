package com.tencent.mm.ui.chatting.a;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b$d
  extends RecyclerView.v
{
  TextView kFj;
  ImageView mCA;
  View mCB;
  CheckBox mCC;
  View mCD;
  ImageView mCy;
  View mCz;
  
  public b$d(b paramb, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(31137);
    this.mCy = ((ImageView)paramView.findViewById(2131824016));
    this.mCz = paramView.findViewById(2131824020);
    this.mCB = paramView.findViewById(2131824022);
    this.kFj = ((TextView)paramView.findViewById(2131822813));
    this.mCA = ((ImageView)paramView.findViewById(2131824024));
    this.mCC = ((CheckBox)paramView.findViewById(2131824025));
    this.mCD = paramView.findViewById(2131824026);
    this.mCD.setVisibility(8);
    this.mCC.setVisibility(8);
    this.mCz.setVisibility(8);
    this.kFj.setVisibility(8);
    this.mCB.setVisibility(8);
    this.mCy.setOnClickListener(new b.d.1(this, paramb));
    this.mCD.setOnClickListener(new b.d.2(this, paramb));
    AppMethodBeat.o(31137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.b.d
 * JD-Core Version:    0.7.0.1
 */