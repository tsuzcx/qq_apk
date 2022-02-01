package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public abstract class b
  extends a
{
  int RSR;
  protected Context mContext;
  private ArrayList<Object> mItems = new ArrayList();
  
  protected b(Context paramContext)
  {
    this.mContext = paramContext;
    this.RSR = 3;
  }
  
  public final void add(int paramInt, Object paramObject)
  {
    gu(paramObject);
    this.mItems.add(paramInt, paramObject);
    notifyDataSetChanged();
  }
  
  public final void add(Object paramObject)
  {
    gu(paramObject);
    this.mItems.add(paramObject);
    notifyDataSetChanged();
  }
  
  public boolean amC(int paramInt)
  {
    return true;
  }
  
  public boolean amD(int paramInt)
  {
    return true;
  }
  
  public void clear()
  {
    hrN();
    this.mItems.clear();
    notifyDataSetChanged();
  }
  
  public final int getColumnCount()
  {
    return this.RSR;
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
  
  public void kY(List<?> paramList)
  {
    clear();
    kX(paramList);
    this.mItems.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void lP(int paramInt1, int paramInt2)
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
    gv(paramObject);
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.b
 * JD-Core Version:    0.7.0.1
 */