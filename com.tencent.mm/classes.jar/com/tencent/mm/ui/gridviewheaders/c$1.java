package com.tencent.mm.ui.gridviewheaders;

import android.database.DataSetObserver;
import java.util.List;

final class c$1
  extends DataSetObserver
{
  c$1(c paramc) {}
  
  public final void onChanged()
  {
    int i = 0;
    c localc = this.vWy;
    localc.mCount = 0;
    int j = localc.vWu.cIA();
    if (j == 0) {
      localc.mCount = localc.vWu.getCount();
    }
    for (;;)
    {
      this.vWy.notifyDataSetChanged();
      return;
      while (i < j)
      {
        localc.mCount += localc.vWu.HU(i) + localc.mNumColumns;
        i += 1;
      }
    }
  }
  
  public final void onInvalidated()
  {
    c.a(this.vWy).clear();
    this.vWy.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.c.1
 * JD-Core Version:    0.7.0.1
 */