package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

public class ChattingEmojiView
  extends MMEmojiView
{
  public ChattingEmojiView(Context paramContext)
  {
    super(paramContext);
    setIsMaxSizeLimit(true);
  }
  
  public ChattingEmojiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setIsMaxSizeLimit(true);
  }
  
  public ChattingEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setIsMaxSizeLimit(true);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.ChattingEmojiView
 * JD-Core Version:    0.7.0.1
 */