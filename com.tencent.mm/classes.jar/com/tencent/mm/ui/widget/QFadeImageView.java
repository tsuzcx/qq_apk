package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.memory.ui.QPictureView;

public class QFadeImageView
  extends QPictureView
{
  String key;
  long nhl;
  
  public QFadeImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QFadeImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void E(long paramLong, String paramString)
  {
    this.nhl = paramLong;
    this.key = paramString;
  }
  
  public String getImageKey()
  {
    return this.key;
  }
  
  public long getStartTimeMillis()
  {
    return this.nhl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.QFadeImageView
 * JD-Core Version:    0.7.0.1
 */