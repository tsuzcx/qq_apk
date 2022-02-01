package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class b
  extends a
{
  protected Context mContext;
  ArrayList<Object> mItems = new ArrayList();
  int xUz;
  
  protected b(Context paramContext)
  {
    this.mContext = paramContext;
    this.xUz = 3;
  }
  
  public boolean NP(int paramInt)
  {
    return true;
  }
  
  public boolean NQ(int paramInt)
  {
    return true;
  }
  
  public final void add(int paramInt, Object paramObject)
  {
    dF(paramObject);
    this.mItems.add(paramInt, paramObject);
    notifyDataSetChanged();
  }
  
  public final void add(Object paramObject)
  {
    dF(paramObject);
    this.mItems.add(paramObject);
    notifyDataSetChanged();
  }
  
  public void clear()
  {
    this.xUy.clear();
    this.mItems.clear();
    notifyDataSetChanged();
  }
  
  public void fM(List<?> paramList)
  {
    clear();
    fL(paramList);
    this.mItems.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public final int getColumnCount()
  {
    return this.xUz;
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
  
  public void hv(int paramInt1, int paramInt2)
  {
    if (paramInt2 < getCount())
    {
      ArrayList localArrayList = this.mItems;
      localArrayList.add(paramInt2, localArrayList.remove(paramInt1));
      notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.b
 * JD-Core Version:    0.7.0.1
 */