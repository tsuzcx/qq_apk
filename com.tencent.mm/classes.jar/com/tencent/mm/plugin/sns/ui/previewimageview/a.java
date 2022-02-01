package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.widget.BaseAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class a
  extends BaseAdapter
  implements d
{
  private int AQR = 0;
  HashMap<Object, Integer> AQS = new HashMap();
  
  protected final void dK(Object paramObject)
  {
    HashMap localHashMap = this.AQS;
    int i = this.AQR;
    this.AQR = (i + 1);
    localHashMap.put(paramObject, Integer.valueOf(i));
  }
  
  public final long getItemId(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.AQS.size())) {
      return -1L;
    }
    Object localObject = getItem(paramInt);
    return ((Integer)this.AQS.get(localObject)).intValue();
  }
  
  protected final void gn(List<?> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      dK(paramList.next());
    }
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