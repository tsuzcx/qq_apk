package com.tencent.mm.ui;

import android.view.View.OnTouchListener;
import android.widget.AbsListView.OnScrollListener;
import java.util.List;

public abstract class i
  implements View.OnTouchListener, AbsListView.OnScrollListener
{
  protected List<a> mCf;
  
  public final void a(a parama)
  {
    if (!this.mCf.contains(parama)) {
      this.mCf.add(parama);
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.i
 * JD-Core Version:    0.7.0.1
 */