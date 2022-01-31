package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;

final class r$d
  extends r.b
{
  ImageView ifG;
  ImageView ifH;
  TextView igh;
  ImageView igi;
  
  public final void cC(View paramView)
  {
    if (this.ifA != null) {}
    ViewStub localViewStub;
    do
    {
      return;
      localViewStub = (ViewStub)paramView.findViewById(R.h.viewstub_top_music_slot);
    } while (localViewStub == null);
    localViewStub.inflate();
    this.ifA = paramView.findViewById(R.h.chatting_item_biz_music);
    this.ifG = ((ImageView)this.ifA.findViewById(R.h.cover));
    this.fcy = ((TextView)this.ifA.findViewById(R.h.title));
    this.igh = ((TextView)this.ifA.findViewById(R.h.player_tv));
    this.ifH = ((ImageView)this.ifA.findViewById(R.h.play_icon));
    this.igi = ((ImageView)this.ifA.findViewById(R.h.watermark_iv));
    this.ifL = ((ImageView)this.ifA.findViewById(R.h.cover_mask_iv));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.r.d
 * JD-Core Version:    0.7.0.1
 */