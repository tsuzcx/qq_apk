package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.plugin.comm.a.e;
import com.tencent.mm.plugin.comm.a.f;
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
    return Integer.valueOf(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      paramView = new GetHdHeadImageGalleryView.a.a(this);
      localView = View.inflate(this.rZC.getContext(), a.f.view_get_hd_avatar_dialogview, null);
      paramView.oZs = ((ProgressBar)localView.findViewById(a.e.hd_avatar_laoding_pb));
      paramView.bQf = ((ImageView)localView.findViewById(a.e.hd_avatar_iv));
      paramView.rZD = localView.findViewById(a.e.hd_avatar_mask_view);
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      localView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
      if (GetHdHeadImageGalleryView.d(this.rZC) == null) {
        break;
      }
      paramViewGroup.oZs.setVisibility(8);
      paramViewGroup.bQf.setVisibility(8);
      paramViewGroup.rZD.setVisibility(8);
      paramView = new MultiTouchImageView(this.rZC.getContext(), GetHdHeadImageGalleryView.d(this.rZC).getWidth(), GetHdHeadImageGalleryView.d(this.rZC).getHeight());
      paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
      paramView.setImageBitmap(GetHdHeadImageGalleryView.d(this.rZC));
      paramView.setMaxZoomLimit(2.0F);
      paramView.setMaxZoomDoubleTab(true);
      return paramView;
      paramViewGroup = (GetHdHeadImageGalleryView.a.a)paramView.getTag();
      localView = paramView;
    }
    paramViewGroup.oZs.setVisibility(0);
    paramViewGroup.rZD.setVisibility(0);
    if (GetHdHeadImageGalleryView.e(this.rZC) != null)
    {
      paramViewGroup.bQf.setVisibility(0);
      paramViewGroup.bQf.setImageBitmap(GetHdHeadImageGalleryView.e(this.rZC));
      return localView;
    }
    paramViewGroup.bQf.setVisibility(8);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView.a
 * JD-Core Version:    0.7.0.1
 */