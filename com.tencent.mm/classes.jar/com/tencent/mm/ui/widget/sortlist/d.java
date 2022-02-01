package com.tencent.mm.ui.widget.sortlist;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ap;

public class d
  implements DragSortListView.i
{
  private Bitmap Lfu;
  int Lfv = -16777216;
  private ImageView cum;
  private ListView mListView;
  
  public d(ListView paramListView)
  {
    this.mListView = paramListView;
  }
  
  public final View afN(int paramInt)
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
    this.Lfu = Bitmap.createBitmap(((View)localObject).getDrawingCache());
    ((View)localObject).setDrawingCacheEnabled(false);
    if (this.cum == null) {
      this.cum = new ImageView(this.mListView.getContext());
    }
    this.cum.setBackgroundColor(this.Lfv);
    this.cum.setPadding(0, 0, 0, 0);
    this.cum.setImageBitmap(this.Lfu);
    this.cum.setLayoutParams(new ViewGroup.LayoutParams(((View)localObject).getWidth(), ((View)localObject).getHeight()));
    localObject = this.cum;
    AppMethodBeat.o(159840);
    return localObject;
  }
  
  public final void hg(View paramView)
  {
    AppMethodBeat.i(159841);
    if ((paramView instanceof ImageView)) {
      ((ImageView)paramView).setImageDrawable(null);
    }
    ap.i("MicroMsg.SimpleFloatViewManager", "bitmap recycle %s", new Object[] { this.Lfu.toString() });
    this.Lfu.recycle();
    this.Lfu = null;
    AppMethodBeat.o(159841);
  }
  
  public void j(Point paramPoint) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.d
 * JD-Core Version:    0.7.0.1
 */