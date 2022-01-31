package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.widget.BaseAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class a
  extends BaseAdapter
  implements d
{
  private int ppA = 0;
  HashMap<Object, Integer> ppB = new HashMap();
  
  protected final void bF(Object paramObject)
  {
    HashMap localHashMap = this.ppB;
    int i = this.ppA;
    this.ppA = (i + 1);
    localHashMap.put(paramObject, Integer.valueOf(i));
  }
  
  protected final void cI(List<?> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      bF(paramList.next());
    }
  }
  
  public final long getItemId(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.ppB.size())) {
      return -1L;
    }
    Object localObject = getItem(paramInt);
    return ((Integer)this.ppB.get(localObject)).intValue();
  }
  
  public final boolean hasStableIds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.a
 * JD-Core Version:    0.7.0.1
 */