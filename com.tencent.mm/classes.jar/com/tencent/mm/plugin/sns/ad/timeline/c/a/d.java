package com.tencent.mm.plugin.sns.ad.timeline.c.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.f;

public final class d
  extends RecyclerView.v
{
  public TextView FxA;
  public ImageView JJW;
  public FrameLayout JJX;
  public ViewGroup JJY;
  public LinearLayout JJZ;
  public FrameLayout JKa;
  public ImageView JKb;
  public TextView JKc;
  public TextView jMg;
  public ImageView jmf;
  public TextView msF;
  
  public d(View paramView, c.a parama)
  {
    super(paramView);
    AppMethodBeat.i(195164);
    if (paramView != null)
    {
      this.JJW = ((ImageView)paramView.findViewById(i.f.sns_ad_slide_full_card_item_img_container));
      this.JJX = ((FrameLayout)paramView.findViewById(i.f.sns_ad_slide_full_card_item_media_container));
      this.JJY = ((ViewGroup)paramView.findViewById(i.f.sns_ad_bottom_bar_layout));
      this.jMg = ((TextView)paramView.findViewById(i.f.title));
      this.msF = ((TextView)paramView.findViewById(i.f.desc));
      this.JJZ = ((LinearLayout)paramView.findViewById(i.f.icon_layout));
      this.jmf = ((ImageView)paramView.findViewById(i.f.sns_ad_icon));
      this.FxA = ((TextView)paramView.findViewById(i.f.sns_ad_icon_desc));
      this.JKa = ((FrameLayout)paramView.findViewById(i.f.btn_layout));
      this.JKb = ((ImageView)paramView.findViewById(i.f.btn_iv));
      this.JKc = ((TextView)paramView.findViewById(i.f.btn_tv));
      this.JKa.setOnClickListener(parama);
    }
    AppMethodBeat.o(195164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.c.a.d
 * JD-Core Version:    0.7.0.1
 */