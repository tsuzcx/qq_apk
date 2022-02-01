package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class QuotaFileSystem$a
{
  final j agyT;
  int cYv;
  
  QuotaFileSystem$a(j paramj)
  {
    this.agyT = paramj;
    this.cYv = 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(13187);
    String str = "children: " + this.cYv + " [" + this.agyT + "]";
    AppMethodBeat.o(13187);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.QuotaFileSystem.a
 * JD-Core Version:    0.7.0.1
 */