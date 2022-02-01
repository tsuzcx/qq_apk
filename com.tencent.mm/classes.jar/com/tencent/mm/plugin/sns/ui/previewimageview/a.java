package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.widget.BaseAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class a
  extends BaseAdapter
  implements d
{
  private int Azv = 0;
  HashMap<Object, Integer> Azw = new HashMap();
  
  protected final void dJ(Object paramObject)
  {
    HashMap localHashMap = this.Azw;
    int i = this.Azv;
    this.Azv = (i + 1);
    localHashMap.put(paramObject, Integer.valueOf(i));
  }
  
  protected final void ge(List<?> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      dJ(paramList.next());
    }
  }
  
  public final long getItemId(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.Azw.size())) {
      return -1L;
    }
    Object localObject = getItem(paramInt);
    return ((Integer)this.Azw.get(localObject)).intValue();
  }
  
  public final boolean hasStableIds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.a
 * JD-Core Version:    0.7.0.1
 */