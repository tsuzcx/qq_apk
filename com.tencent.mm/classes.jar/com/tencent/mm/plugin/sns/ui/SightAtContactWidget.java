package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;

public class SightAtContactWidget
  extends AtContactWidget
{
  public SightAtContactWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SightAtContactWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected int getLayoutResource()
  {
    return b.g.sight_at_layout;
  }
  
  protected int getWithDrawableId()
  {
    return b.i.sight_icon_mention;
  }
  
  protected int getWithEmptyDrawableId()
  {
    return b.i.sight_icon_mention;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SightAtContactWidget
 * JD-Core Version:    0.7.0.1
 */