package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.aj;

final class r$a
  extends c.a
{
  TextView gvw;
  ImageView gyr;
  public ImageView tickIV;
  ImageView vMF;
  TextView vMG;
  
  public final a M(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(163352);
    super.create(paramView);
    this.gyr = ((ImageView)paramView.findViewById(2131300774));
    this.gvw = ((TextView)paramView.findViewById(2131301382));
    this.vMF = ((ImageView)paramView.findViewById(2131300855));
    this.vMG = ((TextView)paramView.findViewById(2131300856));
    this.userTV = ((TextView)paramView.findViewById(2131298566));
    if (!((aj)g.ah(aj.class)).showFinderEntry()) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
        this.maskView = paramView.findViewById(2131298508);
      }
      if (paramBoolean)
      {
        this.uploadingPB = ((ProgressBar)paramView.findViewById(2131309619));
        this.tickIV = ((ImageView)paramView.findViewById(2131298556));
      }
      AppMethodBeat.o(163352);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.r.a
 * JD-Core Version:    0.7.0.1
 */