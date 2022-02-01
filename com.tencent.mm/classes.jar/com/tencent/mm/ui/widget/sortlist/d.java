package com.tencent.mm.ui.widget.sortlist;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.as;

public class d
  implements DragSortListView.i
{
  private Bitmap QXJ;
  int QXK = -16777216;
  private ImageView cIN;
  private ListView mListView;
  
  public d(ListView paramListView)
  {
    this.mListView = paramListView;
  }
  
  public final View apz(int paramInt)
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
    this.QXJ = Bitmap.createBitmap(((View)localObject).getDrawingCache());
    ((View)localObject).setDrawingCacheEnabled(false);
    if (this.cIN == null) {
      this.cIN = new ImageView(this.mListView.getContext());
    }
    this.cIN.setBackgroundColor(this.QXK);
    this.cIN.setPadding(0, 0, 0, 0);
    this.cIN.setImageBitmap(this.QXJ);
    this.cIN.setLayoutParams(new ViewGroup.LayoutParams(((View)localObject).getWidth(), ((View)localObject).getHeight()));
    localObject = this.cIN;
    AppMethodBeat.o(159840);
    return localObject;
  }
  
  public final void hA(View paramView)
  {
    AppMethodBeat.i(159841);
    if ((paramView instanceof ImageView)) {
      ((ImageView)paramView).setImageDrawable(null);
    }
    as.i("MicroMsg.SimpleFloatViewManager", "bitmap recycle %s", new Object[] { this.QXJ.toString() });
    this.QXJ.recycle();
    this.QXJ = null;
    AppMethodBeat.o(159841);
  }
  
  public void n(Point paramPoint) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.d
 * JD-Core Version:    0.7.0.1
 */