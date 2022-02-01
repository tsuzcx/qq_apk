package com.tencent.mm.ui.widget.sortlist;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.av;

public class d
  implements DragSortListView.i
{
  private Bitmap Ywr;
  int Yws = -16777216;
  private ImageView cJr;
  private ListView mListView;
  
  public d(ListView paramListView)
  {
    this.mListView = paramListView;
  }
  
  public final View ayX(int paramInt)
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
    this.Ywr = Bitmap.createBitmap(((View)localObject).getDrawingCache());
    ((View)localObject).setDrawingCacheEnabled(false);
    if (this.cJr == null) {
      this.cJr = new ImageView(this.mListView.getContext());
    }
    this.cJr.setBackgroundColor(this.Yws);
    this.cJr.setPadding(0, 0, 0, 0);
    this.cJr.setImageBitmap(this.Ywr);
    this.cJr.setLayoutParams(new ViewGroup.LayoutParams(((View)localObject).getWidth(), ((View)localObject).getHeight()));
    localObject = this.cJr;
    AppMethodBeat.o(159840);
    return localObject;
  }
  
  public final void iW(View paramView)
  {
    AppMethodBeat.i(159841);
    if ((paramView instanceof ImageView)) {
      ((ImageView)paramView).setImageDrawable(null);
    }
    av.i("MicroMsg.SimpleFloatViewManager", "bitmap recycle %s", new Object[] { this.Ywr.toString() });
    this.Ywr.recycle();
    this.Ywr = null;
    AppMethodBeat.o(159841);
  }
  
  public void m(Point paramPoint) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.d
 * JD-Core Version:    0.7.0.1
 */