package com.tencent.thumbplayer.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.b.d;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;
import java.io.FileDescriptor;
import java.util.HashMap;
import java.util.Map;

public final class b
  implements com.tencent.thumbplayer.a.a.a, a.a
{
  private Map<Integer, d> EDW;
  private FileDescriptor LZZ;
  private String mUrl;
  
  public b(FileDescriptor paramFileDescriptor)
  {
    AppMethodBeat.i(191867);
    this.EDW = new HashMap();
    this.LZZ = paramFileDescriptor;
    AppMethodBeat.o(191867);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(191866);
    this.EDW = new HashMap();
    this.mUrl = paramString;
    AppMethodBeat.o(191866);
  }
  
  public final void a(long paramLong, TPImageGeneratorParams paramTPImageGeneratorParams, d paramd)
  {
    AppMethodBeat.i(191868);
    int i = a.fWK().a(this.mUrl, this.LZZ, paramLong, paramTPImageGeneratorParams.width, paramTPImageGeneratorParams.height, this);
    this.EDW.put(Integer.valueOf(i), paramd);
    AppMethodBeat.o(191868);
  }
  
  public final void ahj(int paramInt)
  {
    AppMethodBeat.i(191870);
    this.EDW.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(191870);
  }
  
  public final void ahk(int paramInt)
  {
    AppMethodBeat.i(191871);
    this.EDW.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(191871);
  }
  
  public final void release()
  {
    AppMethodBeat.i(191869);
    this.EDW.clear();
    AppMethodBeat.o(191869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.c.b
 * JD-Core Version:    0.7.0.1
 */