package com.tencent.tav.player;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class PlayerMessage
{
  public Object bizMsg1;
  public Callback callback;
  public String form;
  public long msgId;
  
  public PlayerMessage(Object paramObject, long paramLong)
  {
    this.bizMsg1 = paramObject;
    this.msgId = paramLong;
  }
  
  public PlayerMessage(Object paramObject, String paramString, long paramLong)
  {
    this.bizMsg1 = paramObject;
    this.form = paramString;
    this.msgId = paramLong;
  }
  
  public PlayerMessage(Object paramObject, String paramString, long paramLong, Callback paramCallback)
  {
    this.bizMsg1 = paramObject;
    this.form = paramString;
    this.msgId = paramLong;
    this.callback = paramCallback;
  }
  
  public String toString()
  {
    AppMethodBeat.i(215964);
    String str = "PlayerMessage{bizMsg1=" + this.bizMsg1 + ", form='" + this.form + '\'' + ", msgId=" + this.msgId + '}';
    AppMethodBeat.o(215964);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.player.PlayerMessage
 * JD-Core Version:    0.7.0.1
 */