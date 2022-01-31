package com.tencent.mm.ui.gridviewheaders;

import android.database.DataSetObserver;

final class d$1
  extends DataSetObserver
{
  d$1(d paramd) {}
  
  public final void onChanged()
  {
    this.vXc.notifyDataSetChanged();
  }
  
  public final void onInvalidated()
  {
    this.vXc.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.d.1
 * JD-Core Version:    0.7.0.1
 */