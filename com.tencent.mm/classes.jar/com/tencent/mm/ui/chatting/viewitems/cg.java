package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;

final class cg
  extends c.a
{
  TextView mrM;
  
  public final View getMainContainerView()
  {
    return null;
  }
  
  public final c.a iw(View paramView)
  {
    AppMethodBeat.i(37565);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(R.h.dzs));
    this.userTV = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
    this.mrM = ((TextView)paramView.findViewById(R.h.chatting_content_itv));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
    this.maskView = paramView.findViewById(R.h.dyD);
    AppMethodBeat.o(37565);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.cg
 * JD-Core Version:    0.7.0.1
 */