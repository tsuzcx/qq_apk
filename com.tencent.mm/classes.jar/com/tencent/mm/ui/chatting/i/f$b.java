package com.tencent.mm.ui.chatting.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.a.c.a;

final class f$b
  extends c.a
{
  TextView gpM;
  ImageView ivs;
  TextView mCZ;
  ImageView mDg;
  
  public f$b(f paramf, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(32617);
    this.ivs = ((ImageView)paramView.findViewById(2131821517));
    this.gpM = ((TextView)paramView.findViewById(2131820602));
    this.gpM.setVisibility(8);
    this.mCZ = ((TextView)paramView.findViewById(2131820615));
    this.mDg = ((ImageView)paramView.findViewById(2131821518));
    this.mDg.setImageResource(2130839753);
    this.mDg.setVisibility(0);
    AppMethodBeat.o(32617);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.f.b
 * JD-Core Version:    0.7.0.1
 */