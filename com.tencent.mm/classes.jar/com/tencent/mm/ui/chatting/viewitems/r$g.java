package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.widget.MMNeatTextView;

final class r$g
  extends r.b
{
  MMNeatTextView ifS;
  View igl;
  
  public final void cC(View paramView)
  {
    if (this.ifA != null) {}
    ViewStub localViewStub;
    do
    {
      return;
      localViewStub = (ViewStub)paramView.findViewById(R.h.viewstub_top_text_slot);
    } while (localViewStub == null);
    localViewStub.inflate();
    this.ifA = paramView.findViewById(R.h.chatting_item_biz_text);
    this.igl = paramView.findViewById(R.h.bottom);
    this.ifS = ((MMNeatTextView)this.ifA.findViewById(R.h.title));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.r.g
 * JD-Core Version:    0.7.0.1
 */