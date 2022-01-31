package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;

public final class j
{
  protected static final class b
    extends c.a
  {
    ImageView iSF;
    View ifA;
    TextView izy;
    View vCI;
    TextView vCJ;
    View vCK;
    TextView vCL;
    ImageView vCM;
    TextView vCN;
    TextView vCO;
    
    public final b dR(View paramView)
    {
      super.dN(paramView);
      this.ifA = paramView.findViewById(R.h.parent_layout);
      this.vCI = paramView.findViewById(R.h.content_layout);
      this.iSF = ((ImageView)paramView.findViewById(R.h.app_icon));
      this.izy = ((TextView)paramView.findViewById(R.h.app_name));
      this.vCJ = ((TextView)paramView.findViewById(R.h.app_size));
      this.vCK = paramView.findViewById(R.h.welcome_layout);
      this.vCL = ((TextView)paramView.findViewById(R.h.plugin_title));
      this.vCM = ((ImageView)paramView.findViewById(R.h.plugin_logo));
      this.vCN = ((TextView)paramView.findViewById(R.h.welcome_info));
      this.vCO = ((TextView)paramView.findViewById(R.h.bottom));
      this.khV = ((CheckBox)this.kKz.findViewById(R.h.chatting_checkbox));
      this.hoY = this.kKz.findViewById(R.h.chatting_maskview);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.j
 * JD-Core Version:    0.7.0.1
 */