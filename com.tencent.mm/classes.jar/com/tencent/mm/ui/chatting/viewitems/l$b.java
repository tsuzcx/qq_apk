package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;

public final class l$b
  extends c.a
{
  View XfA;
  TextView XfB;
  View XfC;
  TextView XfD;
  ImageView XfE;
  TextView XfF;
  TextView XfG;
  TextView rgv;
  View sEi;
  ImageView umI;
  
  public final View getMainContainerView()
  {
    return this.XfA;
  }
  
  public final b ib(View paramView)
  {
    AppMethodBeat.i(36916);
    super.create(paramView);
    this.sEi = paramView.findViewById(R.h.dQU);
    this.XfA = paramView.findViewById(R.h.content_layout);
    this.umI = ((ImageView)paramView.findViewById(R.h.app_icon));
    this.rgv = ((TextView)paramView.findViewById(R.h.app_name));
    this.XfB = ((TextView)paramView.findViewById(R.h.drh));
    this.XfC = paramView.findViewById(R.h.eaU);
    this.XfD = ((TextView)paramView.findViewById(R.h.dRk));
    this.XfE = ((ImageView)paramView.findViewById(R.h.dRj));
    this.XfF = ((TextView)paramView.findViewById(R.h.eaT));
    this.XfG = ((TextView)paramView.findViewById(R.h.bottom));
    this.checkBox = ((CheckBox)this.convertView.findViewById(R.h.dwZ));
    this.maskView = this.convertView.findViewById(R.h.dyD);
    AppMethodBeat.o(36916);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.l.b
 * JD-Core Version:    0.7.0.1
 */