package com.tencent.mm.plugin.sns.ad.timeline.b.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.f;

public final class d
  extends RecyclerView.v
{
  public TextView LtK;
  public ImageView QbA;
  public FrameLayout QbB;
  public ViewGroup QbC;
  public LinearLayout QbD;
  public FrameLayout QbE;
  public ImageView QbF;
  public TextView QbG;
  public ImageView lPb;
  public TextView mll;
  public TextView pmf;
  
  public d(View paramView, c.a parama)
  {
    super(paramView);
    AppMethodBeat.i(311267);
    if (paramView != null)
    {
      this.QbA = ((ImageView)paramView.findViewById(b.f.sns_ad_slide_full_card_item_img_container));
      this.QbB = ((FrameLayout)paramView.findViewById(b.f.sns_ad_slide_full_card_item_media_container));
      this.QbC = ((ViewGroup)paramView.findViewById(b.f.sns_ad_bottom_bar_layout));
      this.mll = ((TextView)paramView.findViewById(b.f.title));
      this.pmf = ((TextView)paramView.findViewById(b.f.desc));
      this.QbD = ((LinearLayout)paramView.findViewById(b.f.icon_layout));
      this.lPb = ((ImageView)paramView.findViewById(b.f.sns_ad_icon));
      this.LtK = ((TextView)paramView.findViewById(b.f.sns_ad_icon_desc));
      this.QbE = ((FrameLayout)paramView.findViewById(b.f.btn_layout));
      this.QbF = ((ImageView)paramView.findViewById(b.f.btn_iv));
      this.QbG = ((TextView)paramView.findViewById(b.f.btn_tv));
      this.QbE.setOnClickListener(parama);
    }
    AppMethodBeat.o(311267);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.b.a.d
 * JD-Core Version:    0.7.0.1
 */