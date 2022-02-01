package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.ak;

final class u$a
  extends c.a
{
  ImageView Atw;
  TextView Atx;
  TextView iZH;
  ImageView jiu;
  public ImageView tickIV;
  
  public final a Q(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(163352);
    super.create(paramView);
    this.jiu = ((ImageView)paramView.findViewById(R.h.finder_avatar_iv));
    this.iZH = ((TextView)paramView.findViewById(R.h.dGZ));
    this.Atw = ((ImageView)paramView.findViewById(R.h.dGS));
    this.Atx = ((TextView)paramView.findViewById(R.h.dGT));
    this.userTV = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
    if (!((ak)h.ag(ak.class)).showFinderEntry()) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
        this.maskView = paramView.findViewById(R.h.dyD);
      }
      if (paramBoolean)
      {
        this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.dYz));
        this.tickIV = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
      }
      AppMethodBeat.o(163352);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.a
 * JD-Core Version:    0.7.0.1
 */