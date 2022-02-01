package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;

final class bd$c
  extends c.a
{
  TextView XjK;
  View vpA;
  TextView wRL;
  
  public final View getMainContainerView()
  {
    return this.vpA;
  }
  
  public final c.a ip(View paramView)
  {
    AppMethodBeat.i(37372);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(R.h.dzs));
    this.userTV = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
    this.XjK = ((TextView)paramView.findViewById(R.h.chatting_content_itv));
    this.wRL = ((TextView)paramView.findViewById(R.h.dzb));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
    this.maskView = paramView.findViewById(R.h.dyD);
    this.vpA = paramView.findViewById(R.h.dyo);
    AppMethodBeat.o(37372);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bd.c
 * JD-Core Version:    0.7.0.1
 */