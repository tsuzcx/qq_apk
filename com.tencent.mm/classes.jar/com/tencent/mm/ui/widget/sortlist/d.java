package com.tencent.mm.ui.widget.sortlist;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.mm.ui.ao;

public class d
  implements DragSortListView.i
{
  private ListView Nn;
  private ImageView jjn;
  private Bitmap wsh;
  int wsi = -16777216;
  
  public d(ListView paramListView)
  {
    this.Nn = paramListView;
  }
  
  public final View II(int paramInt)
  {
    View localView = this.Nn.getChildAt(this.Nn.getHeaderViewsCount() + paramInt - this.Nn.getFirstVisiblePosition());
    if (localView == null) {
      return null;
    }
    localView.setPressed(false);
    localView.setDrawingCacheEnabled(true);
    this.wsh = Bitmap.createBitmap(localView.getDrawingCache());
    localView.setDrawingCacheEnabled(false);
    if (this.jjn == null) {
      this.jjn = new ImageView(this.Nn.getContext());
    }
    this.jjn.setBackgroundColor(this.wsi);
    this.jjn.setPadding(0, 0, 0, 0);
    this.jjn.setImageBitmap(this.wsh);
    this.jjn.setLayoutParams(new ViewGroup.LayoutParams(localView.getWidth(), localView.getHeight()));
    return this.jjn;
  }
  
  public final void en(View paramView)
  {
    if ((paramView instanceof ImageView)) {
      ((ImageView)paramView).setImageDrawable(null);
    }
    ao.t("bitmap recycle %s", new Object[] { this.wsh.toString() });
    this.wsh.recycle();
    this.wsh = null;
  }
  
  public void i(Point paramPoint) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.d
 * JD-Core Version:    0.7.0.1
 */