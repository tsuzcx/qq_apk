package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class n
{
  static final n Rdw;
  final FileSystem Rdu;
  final a Rdv;
  final String gIx;
  
  static
  {
    AppMethodBeat.i(187740);
    Rdw = new n(null, null, null);
    AppMethodBeat.o(187740);
  }
  
  public n(FileSystem paramFileSystem, String paramString, a parama)
  {
    this.Rdu = paramFileSystem;
    this.gIx = paramString;
    this.Rdv = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, FileSystem paramFileSystem, int paramInt, Map<String, Object> paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.n
 * JD-Core Version:    0.7.0.1
 */