package com.tencent.mm.plugin.story.api;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface f
{
  public abstract boolean a(a parama);
  
  public abstract boolean dGf();
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(118416);
      ycY = new a("TimeLine_Des", 0);
      ycZ = new a("TimeLine_Comment", 1);
      yda = new a("TimeLine_Like", 2);
      ydb = new a[] { ycY, ycZ, yda };
      AppMethodBeat.o(118416);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.api.f
 * JD-Core Version:    0.7.0.1
 */