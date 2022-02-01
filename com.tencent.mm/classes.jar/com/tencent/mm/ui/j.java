package com.tencent.mm.ui;

import android.view.View.OnTouchListener;
import android.widget.AbsListView.OnScrollListener;
import java.util.List;

public abstract class j
  implements View.OnTouchListener, AbsListView.OnScrollListener
{
  protected List<a> FSp;
  
  public final void a(a parama)
  {
    if (!this.FSp.contains(parama)) {
      this.FSp.add(parama);
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.j
 * JD-Core Version:    0.7.0.1
 */