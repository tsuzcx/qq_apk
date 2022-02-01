package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.EmojiStatusView;

public class PreViewEmojiView
  extends EmojiStatusView
{
  private int mSize = 0;
  
  public PreViewEmojiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PreViewEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104723);
    super.onMeasure(paramInt1, paramInt2);
    if (this.mSize > 0) {
      setMeasuredDimension(this.mSize, this.mSize);
    }
    AppMethodBeat.o(104723);
  }
  
  public void setSize(int paramInt)
  {
    this.mSize = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.PreViewEmojiView
 * JD-Core Version:    0.7.0.1
 */