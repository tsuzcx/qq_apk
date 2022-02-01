package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class j
{
  static final j LHI;
  public final FileSystem LHG;
  public final a LHH;
  public final String gcZ;
  
  static
  {
    AppMethodBeat.i(193444);
    LHI = new j(null, null, null);
    AppMethodBeat.o(193444);
  }
  
  public j(FileSystem paramFileSystem, String paramString, a parama)
  {
    this.LHG = paramFileSystem;
    this.gcZ = paramString;
    this.LHH = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, FileSystem paramFileSystem, int paramInt, Map<String, Object> paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.j
 * JD-Core Version:    0.7.0.1
 */