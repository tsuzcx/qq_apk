package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.ui.au;

final class at$e
  extends c.a
{
  ImageView XdI;
  RTChattingEmojiView XfH;
  ImageView XfI;
  ViewStub XjH;
  View XjI;
  ImageView XjJ;
  
  public final c.a J(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(37294);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(R.h.dzs));
    this.XfH = ((RTChattingEmojiView)paramView.findViewById(R.h.dxe));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
    this.maskView = paramView.findViewById(R.h.dyD);
    this.XjI = paramView.findViewById(R.h.dxn);
    this.XjJ = ((ImageView)paramView.findViewById(R.h.dxo));
    this.XjJ.setImageDrawable(au.o(paramView.getContext(), R.k.emoticonstore_capture_icon, -1));
    if (paramBoolean) {
      this.userTV = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
    }
    for (;;)
    {
      if (this.XfI != null) {
        ((ViewGroup)this.XfI.getParent()).setBackgroundDrawable(null);
      }
      this.XjH = ((ViewStub)paramView.findViewById(R.h.dzc));
      AppMethodBeat.o(37294);
      return this;
      this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.dYz));
      this.userTV = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
      this.stateIV = ((ImageView)paramView.findViewById(R.h.dzp));
      this.XdI = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
    }
  }
  
  public final View getMainContainerView()
  {
    return this.XfH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.at.e
 * JD-Core Version:    0.7.0.1
 */