package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;

final class ab$a
  extends c.a
{
  protected TextView XgS;
  protected ImageView XgT;
  
  public final a ih(View paramView)
  {
    AppMethodBeat.i(36991);
    super.create(paramView);
    this.XgS = ((TextView)paramView.findViewById(R.h.dLz));
    this.userTV = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
    this.XgT = ((ImageView)paramView.findViewById(R.h.dLA));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
    this.maskView = paramView.findViewById(R.h.dyD);
    AppMethodBeat.o(36991);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ab.a
 * JD-Core Version:    0.7.0.1
 */