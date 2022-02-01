package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class o
{
  static final o YEk;
  final FileSystem YEi;
  final a YEj;
  final String jsP;
  
  static
  {
    AppMethodBeat.i(236797);
    YEk = new o(null, null, null);
    AppMethodBeat.o(236797);
  }
  
  public o(FileSystem paramFileSystem, String paramString, a parama)
  {
    this.YEi = paramFileSystem;
    this.jsP = paramString;
    this.YEj = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, FileSystem paramFileSystem, int paramInt, Map<String, Object> paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.o
 * JD-Core Version:    0.7.0.1
 */