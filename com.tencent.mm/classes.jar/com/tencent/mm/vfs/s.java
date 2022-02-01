package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class s
{
  static final s agzG;
  final FileSystem agzE;
  final a agzF;
  final String lWh;
  
  static
  {
    AppMethodBeat.i(238308);
    agzG = new s(null, null, null);
    AppMethodBeat.o(238308);
  }
  
  public s(FileSystem paramFileSystem, String paramString, a parama)
  {
    this.agzE = paramFileSystem;
    this.lWh = paramString;
    this.agzF = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, FileSystem paramFileSystem, int paramInt, Map<String, Object> paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.s
 * JD-Core Version:    0.7.0.1
 */