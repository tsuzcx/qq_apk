package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;

final class r$i
  extends r.b
{
  ImageView ifH;
  TextView kZl;
  
  public final void cC(View paramView)
  {
    if (this.ifA != null) {}
    ViewStub localViewStub;
    do
    {
      return;
      localViewStub = (ViewStub)paramView.findViewById(R.h.viewstub_top_voice_slot);
    } while (localViewStub == null);
    localViewStub.inflate();
    this.ifA = paramView.findViewById(R.h.chatting_item_biz_voice);
    this.fcy = ((TextView)this.ifA.findViewById(R.h.title));
    this.kZl = ((TextView)this.ifA.findViewById(R.h.time_tv));
    this.ifH = ((ImageView)this.ifA.findViewById(R.h.play_icon));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.r.i
 * JD-Core Version:    0.7.0.1
 */