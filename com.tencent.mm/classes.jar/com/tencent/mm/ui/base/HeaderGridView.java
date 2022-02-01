package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.GridView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class HeaderGridView
  extends GridView
{
  private ArrayList<Object> Whx;
  
  public HeaderGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141668);
    this.Whx = new ArrayList();
    super.setClipChildren(false);
    AppMethodBeat.o(141668);
  }
  
  public HeaderGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(141669);
    this.Whx = new ArrayList();
    super.setClipChildren(false);
    AppMethodBeat.o(141669);
  }
  
  public int getHeaderViewCount()
  {
    AppMethodBeat.i(141671);
    int i = this.Whx.size();
    AppMethodBeat.o(141671);
    return i;
  }
  
  @TargetApi(11)
  public int getNumColumns()
  {
    AppMethodBeat.i(141670);
    int i;
    if (Build.VERSION.SDK_INT >= 11)
    {
      i = super.getNumColumns();
      AppMethodBeat.o(141670);
      return i;
    }
    try
    {
      Field localField = getClass().getSuperclass().getDeclaredField("mNumColumns");
      localField.setAccessible(true);
      i = localField.getInt(this);
      AppMethodBeat.o(141670);
      return i;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(141670);
    }
    return 1;
  }
  
  public void setClipChildren(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.HeaderGridView
 * JD-Core Version:    0.7.0.1
 */