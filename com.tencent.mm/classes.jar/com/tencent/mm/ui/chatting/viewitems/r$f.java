package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.widget.MMNeatTextView;

final class r$f
  extends r.b
{
  View fnF;
  ImageView ifG;
  ImageView ifM;
  View igj;
  MMNeatTextView npe;
  ImageView npf;
  TextView npq;
  
  public final void cC(View paramView)
  {
    if (this.ifA != null) {}
    ViewStub localViewStub;
    do
    {
      return;
      localViewStub = (ViewStub)paramView.findViewById(R.h.viewstub_top_slot);
    } while (localViewStub == null);
    localViewStub.inflate();
    this.ifA = paramView.findViewById(R.h.topSlot);
    this.fcy = ((TextView)this.ifA.findViewById(R.h.title));
    this.ifG = ((ImageView)this.ifA.findViewById(R.h.cover));
    this.igj = this.ifA.findViewById(R.h.cover_container);
    this.fnF = this.ifA.findViewById(R.h.bottom_container);
    this.npe = ((MMNeatTextView)this.ifA.findViewById(R.h.title_textview_in_image));
    this.npq = ((TextView)this.ifA.findViewById(R.h.digest));
    this.ifM = ((ImageView)this.ifA.findViewById(R.h.press_mask_iv));
    this.npf = ((ImageView)this.ifA.findViewById(R.h.cover_shadow_mask_iv));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.r.f
 * JD-Core Version:    0.7.0.1
 */