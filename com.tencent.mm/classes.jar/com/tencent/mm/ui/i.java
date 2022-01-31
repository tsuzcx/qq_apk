package com.tencent.mm.ui;

import android.view.View.OnTouchListener;
import android.widget.AbsListView.OnScrollListener;
import java.util.List;

public abstract class i
  implements View.OnTouchListener, AbsListView.OnScrollListener
{
  protected List<i.a> jks;
  
  public final void a(i.a parama)
  {
    if (!this.jks.contains(parama)) {
      this.jks.add(parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.i
 * JD-Core Version:    0.7.0.1
 */