package com.tencent.mm.ui;

import android.view.View.OnTouchListener;
import android.widget.AbsListView.OnScrollListener;
import java.util.List;

public abstract class i
  implements View.OnTouchListener, AbsListView.OnScrollListener
{
  protected List<a> maf;
  
  public final void a(a parama)
  {
    if (!this.maf.contains(parama)) {
      this.maf.add(parama);
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.i
 * JD-Core Version:    0.7.0.1
 */