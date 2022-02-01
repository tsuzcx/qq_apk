package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.memory.ui.QPictureView;

public class QFadeImageView
  extends QPictureView
{
  String key;
  long zkO;
  
  public QFadeImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QFadeImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void O(long paramLong, String paramString)
  {
    this.zkO = paramLong;
    this.key = paramString;
  }
  
  public String getImageKey()
  {
    return this.key;
  }
  
  public long getStartTimeMillis()
  {
    return this.zkO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.QFadeImageView
 * JD-Core Version:    0.7.0.1
 */