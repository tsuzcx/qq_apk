package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.widget.BaseAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class a
  extends BaseAdapter
  implements d
{
  private int Fby = 0;
  HashMap<Object, Integer> Fbz = new HashMap();
  
  protected final void dT(Object paramObject)
  {
    HashMap localHashMap = this.Fbz;
    int i = this.Fby;
    this.Fby = (i + 1);
    localHashMap.put(paramObject, Integer.valueOf(i));
  }
  
  public final long getItemId(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.Fbz.size())) {
      return -1L;
    }
    Object localObject = getItem(paramInt);
    return ((Integer)this.Fbz.get(localObject)).intValue();
  }
  
  public final boolean hasStableIds()
  {
    return true;
  }
  
  protected final void hk(List<?> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      dT(paramList.next());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.a
 * JD-Core Version:    0.7.0.1
 */