package com.tencent.mm.ui.widget.sortlist;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.bc;

public class d
  implements DragSortListView.i
{
  private Bitmap agoJ;
  int agoK = -16777216;
  private ImageView ewg;
  private ListView mListView;
  
  public d(ListView paramListView)
  {
    this.mListView = paramListView;
  }
  
  public final View aFC(int paramInt)
  {
    AppMethodBeat.i(159840);
    Object localObject = this.mListView;
    localObject = ((ListView)localObject).getChildAt(((ListView)localObject).getHeaderViewsCount() + paramInt - this.mListView.getFirstVisiblePosition());
    if (localObject == null)
    {
      AppMethodBeat.o(159840);
      return null;
    }
    ((View)localObject).setPressed(false);
    ((View)localObject).setDrawingCacheEnabled(true);
    this.agoJ = Bitmap.createBitmap(((View)localObject).getDrawingCache());
    ((View)localObject).setDrawingCacheEnabled(false);
    if (this.ewg == null) {
      this.ewg = new ImageView(this.mListView.getContext());
    }
    this.ewg.setBackgroundColor(this.agoK);
    this.ewg.setPadding(0, 0, 0, 0);
    this.ewg.setImageBitmap(this.agoJ);
    this.ewg.setLayoutParams(new ViewGroup.LayoutParams(((View)localObject).getWidth(), ((View)localObject).getHeight()));
    localObject = this.ewg;
    AppMethodBeat.o(159840);
    return localObject;
  }
  
  public final void mt(View paramView)
  {
    AppMethodBeat.i(159841);
    if ((paramView instanceof ImageView)) {
      ((ImageView)paramView).setImageDrawable(null);
    }
    bc.i("MicroMsg.SimpleFloatViewManager", "bitmap recycle %s", new Object[] { this.agoJ.toString() });
    this.agoJ.recycle();
    this.agoJ = null;
    AppMethodBeat.o(159841);
  }
  
  public void o(Point paramPoint) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.d
 * JD-Core Version:    0.7.0.1
 */