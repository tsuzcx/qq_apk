package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.widget.BaseAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class a
  extends BaseAdapter
  implements d
{
  private int zht = 0;
  HashMap<Object, Integer> zhu = new HashMap();
  
  protected final void dG(Object paramObject)
  {
    HashMap localHashMap = this.zhu;
    int i = this.zht;
    this.zht = (i + 1);
    localHashMap.put(paramObject, Integer.valueOf(i));
  }
  
  protected final void fT(List<?> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      dG(paramList.next());
    }
  }
  
  public final long getItemId(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.zhu.size())) {
      return -1L;
    }
    Object localObject = getItem(paramInt);
    return ((Integer)this.zhu.get(localObject)).intValue();
  }
  
  public final boolean hasStableIds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.a
 * JD-Core Version:    0.7.0.1
 */