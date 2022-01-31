package com.tencent.mm.ui.chatting.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.a.c.a;

final class d$b
  extends c.a
{
  TextView gpM;
  ImageView ivs;
  
  public d$b(d paramd, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(32544);
    this.ivs = ((ImageView)paramView.findViewById(2131821517));
    this.gpL.setSingleLine(false);
    this.gpL.setMaxLines(2);
    this.gpM = ((TextView)paramView.findViewById(2131820603));
    AppMethodBeat.o(32544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.d.b
 * JD-Core Version:    0.7.0.1
 */