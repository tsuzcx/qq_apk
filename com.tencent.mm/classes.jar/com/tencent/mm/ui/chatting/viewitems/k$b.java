package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k$b
  extends c.a
{
  View PKa;
  TextView PKb;
  View PKc;
  TextView PKd;
  ImageView PKe;
  TextView PKf;
  TextView PKg;
  TextView oeJ;
  View puO;
  ImageView qLw;
  
  public final b gP(View paramView)
  {
    AppMethodBeat.i(36916);
    super.create(paramView);
    this.puO = paramView.findViewById(2131305781);
    this.PKa = paramView.findViewById(2131299205);
    this.qLw = ((ImageView)paramView.findViewById(2131296944));
    this.oeJ = ((TextView)paramView.findViewById(2131296958));
    this.PKb = ((TextView)paramView.findViewById(2131296965));
    this.PKc = paramView.findViewById(2131310469);
    this.PKd = ((TextView)paramView.findViewById(2131305994));
    this.PKe = ((ImageView)paramView.findViewById(2131305983));
    this.PKf = ((TextView)paramView.findViewById(2131310466));
    this.PKg = ((TextView)paramView.findViewById(2131297653));
    this.checkBox = ((CheckBox)this.convertView.findViewById(2131298410));
    this.maskView = this.convertView.findViewById(2131298508);
    AppMethodBeat.o(36916);
    return this;
  }
  
  public final View getMainContainerView()
  {
    return this.PKa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.k.b
 * JD-Core Version:    0.7.0.1
 */