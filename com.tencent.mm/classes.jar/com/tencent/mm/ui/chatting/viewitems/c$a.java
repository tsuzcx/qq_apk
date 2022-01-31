package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.ui.chatting.view.AvatarImageView;

public class c$a
{
  public TextView ekh;
  public View jYu;
  public View jbK;
  public CheckBox mCC;
  public View ngZ;
  public ProgressBar pNd;
  public TextView qFY;
  public ViewStub zRA;
  public View zRB;
  public ImageView zRC;
  public String zRD;
  public c zRE;
  public AvatarImageView zRz;
  
  public static void ar(View paramView, int paramInt)
  {
    AppMethodBeat.i(32789);
    if (paramView != null)
    {
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      localLayoutParams.width = ((int)(paramInt / a.dqS()));
      paramView.setLayoutParams(localLayoutParams);
      paramView.requestLayout();
    }
    AppMethodBeat.o(32789);
  }
  
  public final void eV(View paramView)
  {
    AppMethodBeat.i(32787);
    this.ngZ = paramView;
    this.ekh = ((TextView)paramView.findViewById(2131820587));
    this.zRz = ((AvatarImageView)paramView.findViewById(2131821121));
    this.zRB = paramView.findViewById(2131820582);
    this.jYu = paramView.findViewById(2131822580);
    this.zRC = ((ImageView)paramView.findViewById(2131822695));
    this.zRA = ((ViewStub)paramView.findViewById(2131822516));
    AppMethodBeat.o(32787);
  }
  
  public final void rc(boolean paramBoolean)
  {
    AppMethodBeat.i(32788);
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      if ((this.mCC != null) && (this.mCC.getVisibility() != i)) {
        this.mCC.setVisibility(i);
      }
      if ((this.jbK != null) && (this.jbK.getVisibility() != i)) {
        this.jbK.setVisibility(i);
      }
      AppMethodBeat.o(32788);
      return;
    }
  }
  
  public final void setChattingBG(boolean paramBoolean)
  {
    AppMethodBeat.i(32786);
    if (this.zRz != null) {
      this.zRz.setChattingBG(paramBoolean);
    }
    AppMethodBeat.o(32786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.c.a
 * JD-Core Version:    0.7.0.1
 */