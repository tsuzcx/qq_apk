package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  public final String acpB;
  public final long agxf;
  public final long agxg;
  public final boolean agxh;
  public final FileSystem.b agxi;
  public final String name;
  public final long size;
  
  public j(FileSystem.b paramb, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    this.agxi = paramb;
    this.acpB = paramString1;
    this.name = paramString2;
    this.size = paramLong1;
    this.agxf = paramLong2;
    this.agxg = paramLong3;
    this.agxh = paramBoolean;
  }
  
  public final boolean NP(boolean paramBoolean)
  {
    AppMethodBeat.i(238298);
    if (this.agxh)
    {
      paramBoolean = this.agxi.ew(this.acpB, paramBoolean);
      AppMethodBeat.o(238298);
      return paramBoolean;
    }
    paramBoolean = this.agxi.iP(this.acpB);
    AppMethodBeat.o(238298);
    return paramBoolean;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(238306);
    String str = this.acpB + " -> " + this.agxi.jKa().toString();
    if (this.agxh)
    {
      str = "[DIR] ".concat(String.valueOf(str));
      AppMethodBeat.o(238306);
      return str;
    }
    AppMethodBeat.o(238306);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.j
 * JD-Core Version:    0.7.0.1
 */