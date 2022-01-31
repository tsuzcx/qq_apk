package com.tencent.mm.plugin.product.ui;

import android.widget.Filter;
import android.widget.Filter.FilterResults;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class h$1
  extends Filter
{
  h$1(h paramh) {}
  
  protected final Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    Filter.FilterResults localFilterResults = new Filter.FilterResults();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = h.a(this.mUa).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((str != null) && (paramCharSequence != null) && (str.contains(paramCharSequence))) {
        localArrayList.add(str);
      }
    }
    localFilterResults.values = localArrayList;
    localFilterResults.count = localArrayList.size();
    return localFilterResults;
  }
  
  protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    try
    {
      h.a(this.mUa, (List)paramFilterResults.values);
      this.mUa.notifyDataSetChanged();
      return;
    }
    finally
    {
      paramCharSequence = finally;
      throw paramCharSequence;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.h.1
 * JD-Core Version:    0.7.0.1
 */