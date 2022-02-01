package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.widget.MMTextView;

final class j$a
  extends c.a
{
  ImageView XdI;
  MMTextView Xfu;
  View fyN;
  
  public final c.a J(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(36886);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(R.h.dzs));
    this.userTV = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
    this.Xfu = ((MMTextView)paramView.findViewById(R.h.chatting_content_itv));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
    this.maskView = paramView.findViewById(R.h.dyD);
    this.fyN = paramView.findViewById(R.h.dxc);
    if (!paramBoolean)
    {
      this.XdI = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
      this.stateIV = ((ImageView)paramView.findViewById(R.h.dzp));
      this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.dYz));
    }
    AppMethodBeat.o(36886);
    return this;
  }
  
  public final View getMainContainerView()
  {
    return this.fyN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.j.a
 * JD-Core Version:    0.7.0.1
 */