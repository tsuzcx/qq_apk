package com.tencent.mm.ui.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/emoji/EmojiInfoSpan;", "", "start", "", "end", "processEmojiType", "(III)V", "currentText", "", "getCurrentText", "()Ljava/lang/CharSequence;", "setCurrentText", "(Ljava/lang/CharSequence;)V", "getEnd", "()I", "getProcessEmojiType", "getStart", "compareCharSequenceContent", "", "newText", "stashCurrentText", "", "text", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private final int afuR;
  public CharSequence afuS;
  private final int end;
  private final int start;
  
  public a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(249050);
    this.start = paramInt1;
    this.end = paramInt2;
    this.afuR = 1;
    this.afuS = ((CharSequence)"");
    AppMethodBeat.o(249050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.h.a
 * JD-Core Version:    0.7.0.1
 */