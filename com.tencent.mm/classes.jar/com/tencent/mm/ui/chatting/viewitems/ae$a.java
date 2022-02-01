package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;

public final class ae$a
  extends c.a
{
  public LinearLayout ITf;
  public TextView aeRz;
  
  public final View getMainContainerView()
  {
    return null;
  }
  
  public final a lG(View paramView)
  {
    AppMethodBeat.i(255695);
    super.create(paramView);
    this.ITf = ((LinearLayout)paramView.findViewById(R.h.fTc));
    this.aeRz = ((TextView)paramView.findViewById(R.h.fIL));
    this.maskView = paramView.findViewById(R.h.fzn);
    AppMethodBeat.o(255695);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae.a
 * JD-Core Version:    0.7.0.1
 */