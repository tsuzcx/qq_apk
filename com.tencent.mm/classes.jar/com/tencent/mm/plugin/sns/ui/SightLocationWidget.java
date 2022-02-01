package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;

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
    return b.g.location_widget;
  }
  
  protected int getNormalStateImageResource()
  {
    return b.i.sight_icon_location_normal;
  }
  
  protected int getSelectedStateImageResource()
  {
    return b.i.sight_icon_location_selected;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SightLocationWidget
 * JD-Core Version:    0.7.0.1
 */