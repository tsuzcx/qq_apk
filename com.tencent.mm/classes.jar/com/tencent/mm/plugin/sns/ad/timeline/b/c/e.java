package com.tencent.mm.plugin.sns.ad.timeline.b.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.f;

public final class e
  extends RecyclerView.v
{
  public FrameLayout QbB;
  public ViewGroup QbC;
  public ImageView QcH;
  public ImageView QcI;
  public TextView QcJ;
  public TextView QcK;
  public TextView QcL;
  public TextView QcM;
  
  public e(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(311195);
    if (paramView != null)
    {
      this.QcH = ((ImageView)paramView.findViewById(b.f.sns_ad_finder_topic_item_thumb_image));
      this.QbB = ((FrameLayout)paramView.findViewById(b.f.sns_ad_finder_topic_item_media_container));
      this.QcI = ((ImageView)paramView.findViewById(b.f.sns_ad_finder_topic_sub_item_user_image));
      this.QcJ = ((TextView)paramView.findViewById(b.f.sns_ad_finder_topic_sub_item_user_introduce));
      this.QcK = ((TextView)paramView.findViewById(b.f.sns_ad_finder_topic_sub_item_duration));
      this.QbC = ((ViewGroup)paramView.findViewById(b.f.sns_ad_finder_topic_sub_item_bottom_bar_layout));
      this.QcL = ((TextView)paramView.findViewById(b.f.sns_ad_finder_topic_sub_item_bar_label));
      this.QcM = ((TextView)paramView.findViewById(b.f.sns_ad_finder_topic_sub_item_bar_desc_label));
    }
    AppMethodBeat.o(311195);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.b.c.e
 * JD-Core Version:    0.7.0.1
 */