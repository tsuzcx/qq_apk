package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class f
{
  FileSystem.b RbK;
  final FileSystem RbM;
  
  f(FileSystem paramFileSystem)
  {
    this.RbM = paramFileSystem;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(187652);
    if (this.RbM == null)
    {
      AppMethodBeat.o(187652);
      return "[NULL]";
    }
    String str = this.RbM.toString();
    AppMethodBeat.o(187652);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.f
 * JD-Core Version:    0.7.0.1
 */