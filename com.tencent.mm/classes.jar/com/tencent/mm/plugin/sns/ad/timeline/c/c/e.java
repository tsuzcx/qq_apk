package com.tencent.mm.plugin.sns.ad.timeline.c.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.f;

public final class e
  extends RecyclerView.v
{
  public FrameLayout JJX;
  public ViewGroup JJY;
  public ImageView JKY;
  public ImageView JKZ;
  public TextView JLa;
  public TextView JLb;
  public TextView JLc;
  public TextView JLd;
  
  public e(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(246974);
    if (paramView != null)
    {
      this.JKY = ((ImageView)paramView.findViewById(i.f.sns_ad_finder_topic_item_thumb_image));
      this.JJX = ((FrameLayout)paramView.findViewById(i.f.sns_ad_finder_topic_item_media_container));
      this.JKZ = ((ImageView)paramView.findViewById(i.f.sns_ad_finder_topic_sub_item_user_image));
      this.JLa = ((TextView)paramView.findViewById(i.f.sns_ad_finder_topic_sub_item_user_introduce));
      this.JLb = ((TextView)paramView.findViewById(i.f.sns_ad_finder_topic_sub_item_duration));
      this.JJY = ((ViewGroup)paramView.findViewById(i.f.sns_ad_finder_topic_sub_item_bottom_bar_layout));
      this.JLc = ((TextView)paramView.findViewById(i.f.sns_ad_finder_topic_sub_item_bar_label));
      this.JLd = ((TextView)paramView.findViewById(i.f.sns_ad_finder_topic_sub_item_bar_desc_label));
    }
    AppMethodBeat.o(246974);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.c.c.e
 * JD-Core Version:    0.7.0.1
 */