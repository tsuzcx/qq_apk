package com.tencent.mm.ui.chatting.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.chatting.a.c.a;

final class f$b
  extends c.a
{
  TextView eXP;
  ImageView gSx;
  ImageView kiB;
  TextView kiv;
  
  public f$b(f paramf, View paramView)
  {
    super(paramView);
    this.gSx = ((ImageView)paramView.findViewById(R.h.fav_icon));
    this.eXP = ((TextView)paramView.findViewById(R.h.fav_desc));
    this.eXP.setVisibility(8);
    this.kiv = ((TextView)paramView.findViewById(R.h.fav_source));
    this.kiB = ((ImageView)paramView.findViewById(R.h.fav_icon_mask));
    this.kiB.setImageResource(R.g.music_playicon);
    this.kiB.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.f.b
 * JD-Core Version:    0.7.0.1
 */