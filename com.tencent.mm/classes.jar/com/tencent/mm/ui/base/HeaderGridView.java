package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObservable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.GridView;
import android.widget.ListAdapter;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class HeaderGridView
  extends GridView
{
  public ArrayList<HeaderGridView.a> uSY = new ArrayList();
  
  public HeaderGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setClipChildren(false);
  }
  
  public HeaderGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    super.setClipChildren(false);
  }
  
  public int getHeaderViewCount()
  {
    return this.uSY.size();
  }
  
  @TargetApi(11)
  public int getNumColumns()
  {
    if (Build.VERSION.SDK_INT >= 11) {
      return super.getNumColumns();
    }
    try
    {
      Field localField = getClass().getSuperclass().getDeclaredField("mNumColumns");
      localField.setAccessible(true);
      int i = localField.getInt(this);
      return i;
    }
    catch (Exception localException) {}
    return 1;
  }
  
  public final void setAdapter$159aa965(ListAdapter paramListAdapter)
  {
    if (this.uSY.size() > 0)
    {
      paramListAdapter = new HeaderGridView.c(this.uSY, paramListAdapter);
      if (paramListAdapter.mNumColumns != 5)
      {
        paramListAdapter.mNumColumns = 5;
        paramListAdapter.mDataSetObservable.notifyChanged();
      }
      super.setAdapter(paramListAdapter);
      return;
    }
    super.setAdapter(paramListAdapter);
  }
  
  public void setClipChildren(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.HeaderGridView
 * JD-Core Version:    0.7.0.1
 */