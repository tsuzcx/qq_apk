package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public final String NGP;
  public final long RbH;
  public final long RbI;
  public final boolean RbJ;
  final FileSystem.b RbK;
  public final String name;
  public final long size;
  
  public e(FileSystem.b paramb, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    this.RbK = paramb;
    this.NGP = paramString1;
    this.name = paramString2;
    this.size = paramLong1;
    this.RbH = paramLong2;
    this.RbI = paramLong3;
    this.RbJ = paramBoolean;
  }
  
  public final boolean delete()
  {
    AppMethodBeat.i(258503);
    boolean bool = hdW();
    AppMethodBeat.o(258503);
    return bool;
  }
  
  public final boolean hdW()
  {
    AppMethodBeat.i(187648);
    if (this.RbJ)
    {
      bool = this.RbK.dy(this.NGP, true);
      AppMethodBeat.o(187648);
      return bool;
    }
    boolean bool = this.RbK.gC(this.NGP);
    AppMethodBeat.o(187648);
    return bool;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(187650);
    String str = this.NGP + " -> " + this.RbK.hdQ().toString();
    if (this.RbJ)
    {
      str = "[DIR] ".concat(String.valueOf(str));
      AppMethodBeat.o(187650);
      return str;
    }
    AppMethodBeat.o(187650);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.e
 * JD-Core Version:    0.7.0.1
 */