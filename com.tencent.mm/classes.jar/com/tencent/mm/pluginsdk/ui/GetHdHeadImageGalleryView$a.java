package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class GetHdHeadImageGalleryView$a
  extends BaseAdapter
{
  private GetHdHeadImageGalleryView$a(GetHdHeadImageGalleryView paramGetHdHeadImageGalleryView) {}
  
  public final int getCount()
  {
    return 1;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(79681);
    AppMethodBeat.o(79681);
    return Integer.valueOf(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(79682);
    View localView;
    if (paramView == null)
    {
      paramView = new GetHdHeadImageGalleryView.a.a(this);
      localView = View.inflate(this.vQD.getContext(), 2130971080, null);
      paramView.rRL = ((ProgressBar)localView.findViewById(2131828740));
      paramView.cxy = ((ImageView)localView.findViewById(2131828738));
      paramView.vQE = localView.findViewById(2131828739);
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      localView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
      if (GetHdHeadImageGalleryView.d(this.vQD) == null) {
        break;
      }
      paramViewGroup.rRL.setVisibility(8);
      paramViewGroup.cxy.setVisibility(8);
      paramViewGroup.vQE.setVisibility(8);
      paramView = new MultiTouchImageView(this.vQD.getContext(), GetHdHeadImageGalleryView.d(this.vQD).getWidth(), GetHdHeadImageGalleryView.d(this.vQD).getHeight());
      paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
      paramView.setImageBitmap(GetHdHeadImageGalleryView.d(this.vQD));
      paramView.setMaxZoomLimit(2.0F);
      paramView.setMaxZoomDoubleTab(true);
      AppMethodBeat.o(79682);
      return paramView;
      paramViewGroup = (GetHdHeadImageGalleryView.a.a)paramView.getTag();
      localView = paramView;
    }
    paramViewGroup.rRL.setVisibility(0);
    paramViewGroup.vQE.setVisibility(0);
    if (GetHdHeadImageGalleryView.e(this.vQD) != null)
    {
      paramViewGroup.cxy.setVisibility(0);
      paramViewGroup.cxy.setImageBitmap(GetHdHeadImageGalleryView.e(this.vQD));
    }
    for (;;)
    {
      AppMethodBeat.o(79682);
      return localView;
      paramViewGroup.cxy.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView.a
 * JD-Core Version:    0.7.0.1
 */