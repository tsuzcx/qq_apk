package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$c
{
  private int value = 0;
  
  static
  {
    AppMethodBeat.i(30256);
    zvl = new c("Fav", 0, 1);
    zvm = new c("Chat", 1, 2);
    zvn = new c("Chatroom", 2, 3);
    zvo = new c("Sns", 3, 4);
    zvp = new c[] { zvl, zvm, zvn, zvo };
    AppMethodBeat.o(30256);
  }
  
  private a$c(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.c
 * JD-Core Version:    0.7.0.1
 */