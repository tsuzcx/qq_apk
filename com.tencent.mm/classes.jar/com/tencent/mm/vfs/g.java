package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class g
{
  FileSystem.b YCk;
  final FileSystem YCm;
  
  g(FileSystem paramFileSystem)
  {
    this.YCm = paramFileSystem;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(236152);
    if (this.YCm == null)
    {
      AppMethodBeat.o(236152);
      return "[NULL]";
    }
    String str = this.YCm.toString();
    AppMethodBeat.o(236152);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.g
 * JD-Core Version:    0.7.0.1
 */