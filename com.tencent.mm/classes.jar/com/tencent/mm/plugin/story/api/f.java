package com.tencent.mm.plugin.story.api;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface f
{
  public abstract boolean a(a parama);
  
  public abstract boolean dUG();
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(118416);
      zpY = new a("TimeLine_Des", 0);
      zpZ = new a("TimeLine_Comment", 1);
      zqa = new a("TimeLine_Like", 2);
      zqb = new a[] { zpY, zpZ, zqa };
      AppMethodBeat.o(118416);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.api.f
 * JD-Core Version:    0.7.0.1
 */