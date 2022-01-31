package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.util.AttributeSet;

public class RTChattingEmojiViewTo
  extends RTChattingEmojiView
{
  public RTChattingEmojiViewTo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  public RTChattingEmojiViewTo(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  public final void initView()
  {
    super.initView();
    this.shV.gravity = 5;
    addView(this.shS, this.shV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiViewTo
 * JD-Core Version:    0.7.0.1
 */