package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static b JIb;
  
  static
  {
    AppMethodBeat.i(197170);
    JIb = new a((byte)0);
    AppMethodBeat.o(197170);
  }
  
  public static void x(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(197169);
    JIb.x(paramString, paramVarArgs);
    AppMethodBeat.o(197169);
  }
  
  static final class a
    implements b.b
  {
    public final void x(String paramString, Object... paramVarArgs)
    {
      AppMethodBeat.i(197168);
      String.format(paramString, paramVarArgs);
      AppMethodBeat.o(197168);
    }
  }
  
  public static abstract interface b
  {
    public abstract void x(String paramString, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.xeffect.b
 * JD-Core Version:    0.7.0.1
 */