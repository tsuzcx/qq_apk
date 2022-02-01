package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;

final class au$b
  extends c.a
{
  TextView Xgl;
  TextView XjK;
  View XjL;
  ImageView XjM;
  ImageView XjN;
  TextView XjO;
  TextView XjP;
  TextView nit;
  
  public final c.a ip(View paramView)
  {
    AppMethodBeat.i(37298);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(R.h.dzs));
    this.Xgl = ((TextView)paramView.findViewById(R.h.dzv));
    this.nit = ((TextView)paramView.findViewById(R.h.dzx));
    this.XjK = ((TextView)paramView.findViewById(R.h.chatting_content_itv));
    this.clickArea = paramView.findViewById(R.h.chatting_click_area);
    this.XjP = ((TextView)paramView.findViewById(R.h.dyE));
    this.XjL = paramView.findViewById(R.h.dxH);
    this.XjM = ((ImageView)paramView.findViewById(R.h.dvo));
    this.XjN = ((ImageView)paramView.findViewById(R.h.dxI));
    this.XjO = ((TextView)paramView.findViewById(R.h.dvp));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
    this.maskView = paramView.findViewById(R.h.dyD);
    AppMethodBeat.o(37298);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.au.b
 * JD-Core Version:    0.7.0.1
 */