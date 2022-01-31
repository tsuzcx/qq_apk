package com.tencent.mm.ui.widget.sortlist;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ak;

public class d
  implements DragSortListView.i
{
  private Bitmap AML;
  int AMM = -16777216;
  private ImageView ioq;
  private ListView mListView;
  
  public d(ListView paramListView)
  {
    this.mListView = paramListView;
  }
  
  public final View RC(int paramInt)
  {
    AppMethodBeat.i(113109);
    Object localObject = this.mListView;
    localObject = ((ListView)localObject).getChildAt(((ListView)localObject).getHeaderViewsCount() + paramInt - this.mListView.getFirstVisiblePosition());
    if (localObject == null)
    {
      AppMethodBeat.o(113109);
      return null;
    }
    ((View)localObject).setPressed(false);
    ((View)localObject).setDrawingCacheEnabled(true);
    this.AML = Bitmap.createBitmap(((View)localObject).getDrawingCache());
    ((View)localObject).setDrawingCacheEnabled(false);
    if (this.ioq == null) {
      this.ioq = new ImageView(this.mListView.getContext());
    }
    this.ioq.setBackgroundColor(this.AMM);
    this.ioq.setPadding(0, 0, 0, 0);
    this.ioq.setImageBitmap(this.AML);
    this.ioq.setLayoutParams(new ViewGroup.LayoutParams(((View)localObject).getWidth(), ((View)localObject).getHeight()));
    localObject = this.ioq;
    AppMethodBeat.o(113109);
    return localObject;
  }
  
  public final void fy(View paramView)
  {
    AppMethodBeat.i(113110);
    if ((paramView instanceof ImageView)) {
      ((ImageView)paramView).setImageDrawable(null);
    }
    ak.i("MicroMsg.SimpleFloatViewManager", "bitmap recycle %s", new Object[] { this.AML.toString() });
    this.AML.recycle();
    this.AML = null;
    AppMethodBeat.o(113110);
  }
  
  public void i(Point paramPoint) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.d
 * JD-Core Version:    0.7.0.1
 */