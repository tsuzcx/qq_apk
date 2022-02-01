package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class q$a
  extends c.a
{
  public ImageView Kyb;
  TextView Kym;
  ImageView fTj;
  TextView gXb;
  TextView ovs;
  
  public final a K(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(187749);
    super.gs(paramView);
    this.fTj = ((ImageView)paramView.findViewById(2131308315));
    this.ovs = ((TextView)paramView.findViewById(2131308318));
    this.gXb = ((TextView)paramView.findViewById(2131308317));
    this.Kym = ((TextView)paramView.findViewById(2131308319));
    this.yUp = ((TextView)paramView.findViewById(2131298185));
    if (paramBoolean)
    {
      this.xvJ = ((ProgressBar)paramView.findViewById(2131306220));
      this.Kyb = ((ImageView)paramView.findViewById(2131298176));
    }
    AppMethodBeat.o(187749);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.q.a
 * JD-Core Version:    0.7.0.1
 */