package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.widget.MMNeatTextView;

public final class r
{
  static final class h
    extends r.b
  {
    ImageView hic;
    ImageView ifG;
    ImageView ifM;
    MMNeatTextView ifS;
    View igj;
    TextView igx;
    
    public final void cC(View paramView)
    {
      if (this.ifA != null) {}
      ViewStub localViewStub;
      do
      {
        return;
        localViewStub = (ViewStub)paramView.findViewById(R.h.viewstub_top_video_slot);
      } while (localViewStub == null);
      localViewStub.inflate();
      this.ifA = paramView.findViewById(R.h.chatting_item_biz_video);
      this.ifG = ((ImageView)this.ifA.findViewById(R.h.cover));
      this.ifL = ((ImageView)this.ifA.findViewById(R.h.cover_mask_iv));
      this.ifM = ((ImageView)this.ifA.findViewById(R.h.press_mask_iv));
      this.hic = ((ImageView)this.ifA.findViewById(R.h.video_icon));
      this.ifS = ((MMNeatTextView)this.ifA.findViewById(R.h.title_tv));
      this.igx = ((TextView)this.ifA.findViewById(R.h.time_tv));
      this.igj = this.ifA.findViewById(R.h.chatting_video_cover_ll);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.r
 * JD-Core Version:    0.7.0.1
 */