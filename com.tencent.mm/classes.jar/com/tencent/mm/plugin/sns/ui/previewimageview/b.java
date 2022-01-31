package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class b
  extends a
{
  ArrayList<Object> dU = new ArrayList();
  protected Context mContext;
  int ppC;
  
  protected b(Context paramContext)
  {
    this.mContext = paramContext;
    this.ppC = 3;
  }
  
  public final void add(int paramInt, Object paramObject)
  {
    bF(paramObject);
    this.dU.add(paramInt, paramObject);
    notifyDataSetChanged();
  }
  
  public final void add(Object paramObject)
  {
    bF(paramObject);
    this.dU.add(paramObject);
    notifyDataSetChanged();
  }
  
  public void cJ(List<?> paramList)
  {
    clear();
    cI(paramList);
    this.dU.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void clear()
  {
    this.ppB.clear();
    this.dU.clear();
    notifyDataSetChanged();
  }
  
  public void eb(int paramInt1, int paramInt2)
  {
    if (paramInt2 < getCount())
    {
      ArrayList localArrayList = this.dU;
      localArrayList.add(paramInt2, localArrayList.remove(paramInt1));
      notifyDataSetChanged();
    }
  }
  
  public final int getColumnCount()
  {
    return this.ppC;
  }
  
  protected final Context getContext()
  {
    return this.mContext;
  }
  
  public int getCount()
  {
    return this.dU.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.dU.get(paramInt);
  }
  
  public boolean yZ(int paramInt)
  {
    return true;
  }
  
  public boolean za(int paramInt)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.b
 * JD-Core Version:    0.7.0.1
 */