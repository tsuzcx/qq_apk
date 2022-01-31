package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.util.AttributeSet;

public class RTChattingEmojiViewFrom
  extends RTChattingEmojiView
{
  public RTChattingEmojiViewFrom(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  public RTChattingEmojiViewFrom(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  public final void initView()
  {
    super.initView();
    this.shV.gravity = 3;
    addView(this.shS, this.shV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiViewFrom
 * JD-Core Version:    0.7.0.1
 */