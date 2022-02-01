package com.tencent.mm.ui.l.a;

import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.e.a;
import java.lang.ref.WeakReference;

public final class c
{
  public WeakReference<a> QlK;
  public WeakReference<FrameLayout> QlL;
  public long QlM;
  public long msgId;
  
  public c(a parama, FrameLayout paramFrameLayout, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(234364);
    this.QlK = new WeakReference(parama);
    this.QlL = new WeakReference(paramFrameLayout);
    this.msgId = paramLong1;
    this.QlM = paramLong2;
    AppMethodBeat.o(234364);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(234365);
    String str = "MagicEmojiMsgDataModel{chattingContext=" + this.QlK + ", holder=" + this.QlL + ", msgId=" + this.msgId + ", msgReceiveTimestamp=" + this.QlM + '}';
    AppMethodBeat.o(234365);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.l.a.c
 * JD-Core Version:    0.7.0.1
 */