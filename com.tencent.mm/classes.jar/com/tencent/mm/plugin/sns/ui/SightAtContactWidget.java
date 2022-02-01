package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;

public class SightAtContactWidget
  extends AtContactWidget
{
  public SightAtContactWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  public SightAtContactWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected int getLayoutResource()
  {
    return 2131495445;
  }
  
  protected int getWithDrawableId()
  {
    return 2131691178;
  }
  
  protected int getWithEmptyDrawableId()
  {
    return 2131691178;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SightAtContactWidget
 * JD-Core Version:    0.7.0.1
 */