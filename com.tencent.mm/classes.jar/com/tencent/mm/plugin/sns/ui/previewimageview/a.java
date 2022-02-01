package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.widget.BaseAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class a
  extends BaseAdapter
  implements d
{
  private int RSP = 0;
  private HashMap<Object, Integer> RSQ = new HashMap();
  
  public final long getItemId(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.RSQ.size())) {
      return -1L;
    }
    Object localObject = getItem(paramInt);
    return ((Integer)this.RSQ.get(localObject)).intValue();
  }
  
  protected final void gu(Object paramObject)
  {
    HashMap localHashMap = this.RSQ;
    int i = this.RSP;
    this.RSP = (i + 1);
    localHashMap.put(paramObject, Integer.valueOf(i));
  }
  
  protected final void gv(Object paramObject)
  {
    this.RSQ.remove(paramObject);
  }
  
  public final boolean hasStableIds()
  {
    return true;
  }
  
  protected final void hrN()
  {
    this.RSQ.clear();
  }
  
  protected final void kX(List<?> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      gu(paramList.next());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.a
 * JD-Core Version:    0.7.0.1
 */