package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.widget.BaseAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class a
  extends BaseAdapter
  implements d
{
  private int xUx = 0;
  HashMap<Object, Integer> xUy = new HashMap();
  
  protected final void dF(Object paramObject)
  {
    HashMap localHashMap = this.xUy;
    int i = this.xUx;
    this.xUx = (i + 1);
    localHashMap.put(paramObject, Integer.valueOf(i));
  }
  
  protected final void fL(List<?> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      dF(paramList.next());
    }
  }
  
  public final long getItemId(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.xUy.size())) {
      return -1L;
    }
    Object localObject = getItem(paramInt);
    return ((Integer)this.xUy.get(localObject)).intValue();
  }
  
  public final boolean hasStableIds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.a
 * JD-Core Version:    0.7.0.1
 */