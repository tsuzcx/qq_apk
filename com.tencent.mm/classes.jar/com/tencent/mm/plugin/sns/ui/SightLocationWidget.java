package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;

public class SightLocationWidget
  extends LocationWidget
{
  public SightLocationWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SightLocationWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected int getLayoutResource()
  {
    return i.g.location_widget;
  }
  
  protected int getNormalStateImageResource()
  {
    return i.i.sight_icon_location_normal;
  }
  
  protected int getSelectedStateImageResource()
  {
    return i.i.sight_icon_location_selected;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SightLocationWidget
 * JD-Core Version:    0.7.0.1
 */