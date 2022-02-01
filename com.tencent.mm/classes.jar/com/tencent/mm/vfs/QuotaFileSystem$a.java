package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class QuotaFileSystem$a
{
  final f YDx;
  int beC;
  
  QuotaFileSystem$a(f paramf)
  {
    this.YDx = paramf;
    this.beC = 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(13187);
    String str = "children: " + this.beC + " [" + this.YDx + "]";
    AppMethodBeat.o(13187);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vfs.QuotaFileSystem.a
 * JD-Core Version:    0.7.0.1
 */