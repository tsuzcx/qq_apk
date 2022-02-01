package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ar$b
  extends c.a
{
  TextView PKu;
  TextView PNK;
  View PNL;
  ImageView PNM;
  ImageView PNN;
  TextView PNO;
  TextView PNP;
  TextView kqG;
  
  public final c.a hd(View paramView)
  {
    AppMethodBeat.i(37298);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(2131298558));
    this.PKu = ((TextView)paramView.findViewById(2131298562));
    this.kqG = ((TextView)paramView.findViewById(2131298567));
    this.PNK = ((TextView)paramView.findViewById(2131298416));
    this.clickArea = paramView.findViewById(2131298411);
    this.PNP = ((TextView)paramView.findViewById(2131298511));
    this.PNL = paramView.findViewById(2131298449);
    this.PNM = ((ImageView)paramView.findViewById(2131298294));
    this.PNN = ((ImageView)paramView.findViewById(2131298450));
    this.PNO = ((TextView)paramView.findViewById(2131298295));
    this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
    this.maskView = paramView.findViewById(2131298508);
    AppMethodBeat.o(37298);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ar.b
 * JD-Core Version:    0.7.0.1
 */