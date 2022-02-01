package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.memory.ui.QPictureView;

public class QFadeImageView
  extends QPictureView
{
  long DMd;
  String key;
  
  public QFadeImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QFadeImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void T(long paramLong, String paramString)
  {
    this.DMd = paramLong;
    this.key = paramString;
  }
  
  public String getImageKey()
  {
    return this.key;
  }
  
  public long getStartTimeMillis()
  {
    return this.DMd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.QFadeImageView
 * JD-Core Version:    0.7.0.1
 */