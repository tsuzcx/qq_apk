package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RTChattingEmojiViewTo
  extends RTChattingEmojiView
{
  public RTChattingEmojiViewTo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(62505);
    initView();
    AppMethodBeat.o(62505);
  }
  
  public RTChattingEmojiViewTo(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(62506);
    initView();
    AppMethodBeat.o(62506);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(62507);
    super.initView();
    dpb();
    AppMethodBeat.o(62507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiViewTo
 * JD-Core Version:    0.7.0.1
 */