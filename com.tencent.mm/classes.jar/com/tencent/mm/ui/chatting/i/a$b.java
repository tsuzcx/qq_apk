package com.tencent.mm.ui.chatting.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.a.c.a;

final class a$b
  extends c.a
{
  TextView gpM;
  ImageView ivs;
  TextView mCZ;
  
  public a$b(a parama, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(32515);
    this.ivs = ((ImageView)paramView.findViewById(2131821517));
    this.gpM = ((TextView)paramView.findViewById(2131820602));
    this.mCZ = ((TextView)paramView.findViewById(2131820615));
    this.mCZ.setVisibility(8);
    AppMethodBeat.o(32515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.a.b
 * JD-Core Version:    0.7.0.1
 */