package com.tencent.mm.view.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$a
{
  View ART;
  View ARU;
  View ARV;
  TextView ARY;
  TextView gpM;
  ImageView ivs;
  
  public e$a(e parame, View paramView)
  {
    AppMethodBeat.i(62981);
    this.ivs = ((ImageView)paramView.findViewById(2131821541));
    this.gpM = ((TextView)paramView.findViewById(2131827802));
    this.ARY = ((TextView)paramView.findViewById(2131827803));
    this.ARY.setTextSize(1, 12.0F);
    this.ART = paramView.findViewById(2131823612);
    this.ARU = paramView.findViewById(2131823613);
    this.ARV = paramView.findViewById(2131823614);
    AppMethodBeat.o(62981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.view.a.e.a
 * JD-Core Version:    0.7.0.1
 */