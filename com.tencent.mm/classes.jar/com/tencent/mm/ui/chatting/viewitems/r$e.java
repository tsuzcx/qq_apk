package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.mm.R.h;

final class r$e
  extends r.b
{
  ImageView hic;
  ImageView ifG;
  ImageView ifM;
  View igj;
  ImageView npf;
  
  public final void cC(View paramView)
  {
    if (this.ifA != null) {}
    ViewStub localViewStub;
    do
    {
      return;
      localViewStub = (ViewStub)paramView.findViewById(R.h.viewstub_top_pic_slot);
    } while (localViewStub == null);
    localViewStub.inflate();
    this.ifA = paramView.findViewById(R.h.chatting_item_biz_pic);
    this.ifG = ((ImageView)this.ifA.findViewById(R.h.cover));
    this.ifL = ((ImageView)this.ifA.findViewById(R.h.cover_mask_iv));
    this.ifM = ((ImageView)this.ifA.findViewById(R.h.press_mask_iv));
    this.npf = ((ImageView)this.ifA.findViewById(R.h.cover_shadow_mask_iv));
    this.hic = ((ImageView)this.ifA.findViewById(R.h.pic_icon));
    this.igj = this.ifA.findViewById(R.h.chatting_pic_cover_ll);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.r.e
 * JD-Core Version:    0.7.0.1
 */