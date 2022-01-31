package com.tencent.mm.plugin.music.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$a
{
  public String content;
  public boolean oZw;
  public long timestamp;
  
  public final String toString()
  {
    AppMethodBeat.i(104870);
    String str = String.format("[%d %s]", new Object[] { Long.valueOf(this.timestamp), this.content });
    AppMethodBeat.o(104870);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a
 * JD-Core Version:    0.7.0.1
 */