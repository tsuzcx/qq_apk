package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$b
{
  public int value = 0;
  
  static
  {
    AppMethodBeat.i(30253);
    zvf = new b("Sight", 0, 1);
    zvg = new b("AdUrl", 1, 2);
    zvh = new b("Chat", 2, 3);
    zvi = new b("TalkChat", 3, 4);
    zvj = new b("Fav", 4, 5);
    zvk = new b[] { zvf, zvg, zvh, zvi, zvj };
    AppMethodBeat.o(30253);
  }
  
  private a$b(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.b
 * JD-Core Version:    0.7.0.1
 */