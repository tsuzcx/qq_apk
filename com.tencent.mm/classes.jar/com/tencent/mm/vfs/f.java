package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  public final String UUr;
  public final long YCh;
  public final long YCi;
  public final boolean YCj;
  final FileSystem.b YCk;
  public final String name;
  public final long size;
  
  public f(FileSystem.b paramb, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    this.YCk = paramb;
    this.UUr = paramString1;
    this.name = paramString2;
    this.size = paramLong1;
    this.YCh = paramLong2;
    this.YCi = paramLong3;
    this.YCj = paramBoolean;
  }
  
  public final boolean HT(boolean paramBoolean)
  {
    AppMethodBeat.i(236106);
    if (this.YCj)
    {
      paramBoolean = this.YCk.dK(this.UUr, paramBoolean);
      AppMethodBeat.o(236106);
      return paramBoolean;
    }
    paramBoolean = this.YCk.ho(this.UUr);
    AppMethodBeat.o(236106);
    return paramBoolean;
  }
  
  public final Iterable<f> HU(boolean paramBoolean)
  {
    AppMethodBeat.i(236111);
    if (this.YCj)
    {
      Iterable localIterable = this.YCk.dJ(this.UUr, paramBoolean);
      AppMethodBeat.o(236111);
      return localIterable;
    }
    AppMethodBeat.o(236111);
    return null;
  }
  
  public final boolean cFq()
  {
    AppMethodBeat.i(292977);
    boolean bool = HT(true);
    AppMethodBeat.o(292977);
    return bool;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(236115);
    String str = this.UUr + " -> " + this.YCk.ieX().toString();
    if (this.YCj)
    {
      str = "[DIR] ".concat(String.valueOf(str));
      AppMethodBeat.o(236115);
      return str;
    }
    AppMethodBeat.o(236115);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.f
 * JD-Core Version:    0.7.0.1
 */