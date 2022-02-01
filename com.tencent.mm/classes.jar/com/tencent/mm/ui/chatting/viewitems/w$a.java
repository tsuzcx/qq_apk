package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;

final class w$a
  extends c.a
{
  TextView aeQo;
  TextView descTv;
  ImageView lKK;
  TextView nicknameTv;
  public ImageView tickIV;
  
  public final a Z(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(255612);
    super.create(paramView);
    this.lKK = ((ImageView)paramView.findViewById(R.h.fJc));
    this.nicknameTv = ((TextView)paramView.findViewById(R.h.fJe));
    this.descTv = ((TextView)paramView.findViewById(R.h.fJd));
    this.aeQo = ((TextView)paramView.findViewById(R.h.fJf));
    this.userTV = ((TextView)paramView.findViewById(R.h.fAr));
    if (paramBoolean)
    {
      this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.gbo));
      this.tickIV = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
    }
    AppMethodBeat.o(255612);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.w.a
 * JD-Core Version:    0.7.0.1
 */