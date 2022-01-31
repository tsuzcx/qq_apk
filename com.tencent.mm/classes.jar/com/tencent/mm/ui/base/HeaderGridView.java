package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObservable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class HeaderGridView
  extends GridView
{
  public ArrayList<HeaderGridView.a> zhy;
  
  public HeaderGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106303);
    this.zhy = new ArrayList();
    super.setClipChildren(false);
    AppMethodBeat.o(106303);
  }
  
  public HeaderGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(106304);
    this.zhy = new ArrayList();
    super.setClipChildren(false);
    AppMethodBeat.o(106304);
  }
  
  public int getHeaderViewCount()
  {
    AppMethodBeat.i(106307);
    int i = this.zhy.size();
    AppMethodBeat.o(106307);
    return i;
  }
  
  @TargetApi(11)
  public int getNumColumns()
  {
    AppMethodBeat.i(106305);
    int i;
    if (Build.VERSION.SDK_INT >= 11)
    {
      i = super.getNumColumns();
      AppMethodBeat.o(106305);
      return i;
    }
    try
    {
      Field localField = getClass().getSuperclass().getDeclaredField("mNumColumns");
      localField.setAccessible(true);
      i = localField.getInt(this);
      AppMethodBeat.o(106305);
      return i;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(106305);
    }
    return 1;
  }
  
  public final void setAdapter$159aa965(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(106308);
    if (this.zhy.size() > 0)
    {
      paramListAdapter = new HeaderGridView.c(this.zhy, paramListAdapter);
      if (paramListAdapter.mNumColumns != 5)
      {
        paramListAdapter.mNumColumns = 5;
        paramListAdapter.mDataSetObservable.notifyChanged();
      }
      super.setAdapter(paramListAdapter);
      AppMethodBeat.o(106308);
      return;
    }
    super.setAdapter(paramListAdapter);
    AppMethodBeat.o(106308);
  }
  
  public void setClipChildren(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.HeaderGridView
 * JD-Core Version:    0.7.0.1
 */