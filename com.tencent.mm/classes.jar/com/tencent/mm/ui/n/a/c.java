package com.tencent.mm.ui.n.a;

import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.e.a;
import java.lang.ref.WeakReference;

public final class c
{
  public String XJA;
  public WeakReference<a> XJw;
  public WeakReference<FrameLayout> XJx;
  public long XJy;
  public String XJz;
  public long msgId;
  
  public c(a parama, FrameLayout paramFrameLayout, long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(289609);
    this.XJw = new WeakReference(parama);
    this.XJx = new WeakReference(paramFrameLayout);
    this.msgId = paramLong1;
    this.XJy = paramLong2;
    this.XJz = paramString1;
    this.XJA = paramString2;
    AppMethodBeat.o(289609);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(289610);
    String str = "MagicEmojiMsgDataModel{chattingContext=" + this.XJw + ", holder=" + this.XJx + ", msgId=" + this.msgId + ", msgReceiveTimestamp=" + this.XJy + ", emojiID='" + this.XJz + '\'' + ", emojiKey='" + this.XJA + '\'' + '}';
    AppMethodBeat.o(289610);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.n.a.c
 * JD-Core Version:    0.7.0.1
 */