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
  int sku;
  
  protected b(Context paramContext)
  {
    this.mContext = paramContext;
    this.sku = 3;
  }
  
  public boolean Fk(int paramInt)
  {
    return true;
  }
  
  public boolean Fl(int paramInt)
  {
    return true;
  }
  
  public final void add(int paramInt, Object paramObject)
  {
    cj(paramObject);
    this.mItems.add(paramInt, paramObject);
    notifyDataSetChanged();
  }
  
  public final void add(Object paramObject)
  {
    cj(paramObject);
    this.mItems.add(paramObject);
    notifyDataSetChanged();
  }
  
  public void clear()
  {
    this.skt.clear();
    this.mItems.clear();
    notifyDataSetChanged();
  }
  
  public void du(List<?> paramList)
  {
    clear();
    dt(paramList);
    this.mItems.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void fO(int paramInt1, int paramInt2)
  {
    if (paramInt2 < getCount())
    {
      ArrayList localArrayList = this.mItems;
      localArrayList.add(paramInt2, localArrayList.remove(paramInt1));
      notifyDataSetChanged();
    }
  }
  
  public final int getColumnCount()
  {
    return this.sku;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.b
 * JD-Core Version:    0.7.0.1
 */