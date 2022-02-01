package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class b
  extends a
{
  int FbA;
  protected Context mContext;
  ArrayList<Object> mItems = new ArrayList();
  
  protected b(Context paramContext)
  {
    this.mContext = paramContext;
    this.FbA = 3;
  }
  
  public boolean aaf(int paramInt)
  {
    return true;
  }
  
  public boolean aag(int paramInt)
  {
    return true;
  }
  
  public final void add(int paramInt, Object paramObject)
  {
    dT(paramObject);
    this.mItems.add(paramInt, paramObject);
    notifyDataSetChanged();
  }
  
  public final void add(Object paramObject)
  {
    dT(paramObject);
    this.mItems.add(paramObject);
    notifyDataSetChanged();
  }
  
  public void clear()
  {
    this.Fbz.clear();
    this.mItems.clear();
    notifyDataSetChanged();
  }
  
  public final int getColumnCount()
  {
    return this.FbA;
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
  
  public void hl(List<?> paramList)
  {
    clear();
    hk(paramList);
    this.mItems.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void iT(int paramInt1, int paramInt2)
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