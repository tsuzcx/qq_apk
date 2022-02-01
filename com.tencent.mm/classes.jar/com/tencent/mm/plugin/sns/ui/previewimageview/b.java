package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public abstract class b
  extends a
{
  int LpY;
  protected Context mContext;
  private ArrayList<Object> mItems = new ArrayList();
  
  protected b(Context paramContext)
  {
    this.mContext = paramContext;
    this.LpY = 3;
  }
  
  public final void add(int paramInt, Object paramObject)
  {
    dW(paramObject);
    this.mItems.add(paramInt, paramObject);
    notifyDataSetChanged();
  }
  
  public final void add(Object paramObject)
  {
    dW(paramObject);
    this.mItems.add(paramObject);
    notifyDataSetChanged();
  }
  
  public boolean ahA(int paramInt)
  {
    return true;
  }
  
  public boolean ahB(int paramInt)
  {
    return true;
  }
  
  public void clear()
  {
    fYE();
    this.mItems.clear();
    notifyDataSetChanged();
  }
  
  public final int getColumnCount()
  {
    return this.LpY;
  }
  
  protected final Context getContext()
  {
    return this.mContext;
  }
  
  public int getCount()
  {
    return this.mItems.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.mItems.get(paramInt);
  }
  
  public void hU(List<?> paramList)
  {
    clear();
    hT(paramList);
    this.mItems.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void kc(int paramInt1, int paramInt2)
  {
    if (paramInt2 < getCount())
    {
      ArrayList localArrayList = this.mItems;
      localArrayList.add(paramInt2, localArrayList.remove(paramInt1));
      notifyDataSetChanged();
    }
  }
  
  public final void remove(Object paramObject)
  {
    this.mItems.remove(paramObject);
    dX(paramObject);
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.b
 * JD-Core Version:    0.7.0.1
 */