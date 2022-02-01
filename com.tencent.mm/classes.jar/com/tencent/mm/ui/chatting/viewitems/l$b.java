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
  View XoW;
  TextView aePD;
  View aePE;
  TextView aePF;
  ImageView aePG;
  TextView aePH;
  TextView aePI;
  TextView uov;
  View vJU;
  ImageView xsU;
  
  public final View getMainContainerView()
  {
    return this.XoW;
  }
  
  public final b lx(View paramView)
  {
    AppMethodBeat.i(36916);
    super.create(paramView);
    this.vJU = paramView.findViewById(R.h.fTa);
    this.XoW = paramView.findViewById(R.h.content_layout);
    this.xsU = ((ImageView)paramView.findViewById(R.h.app_icon));
    this.uov = ((TextView)paramView.findViewById(R.h.app_name));
    this.aePD = ((TextView)paramView.findViewById(R.h.fru));
    this.aePE = paramView.findViewById(R.h.gdy);
    this.aePF = ((TextView)paramView.findViewById(R.h.fTn));
    this.aePG = ((ImageView)paramView.findViewById(R.h.fTm));
    this.aePH = ((TextView)paramView.findViewById(R.h.gdx));
    this.aePI = ((TextView)paramView.findViewById(R.h.bottom));
    this.checkBox = ((CheckBox)this.convertView.findViewById(R.h.fxt));
    this.maskView = this.convertView.findViewById(R.h.fzn);
    AppMethodBeat.o(36916);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.l.b
 * JD-Core Version:    0.7.0.1
 */