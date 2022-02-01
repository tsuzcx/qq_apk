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
  private Map<Integer, d> EWs;
  private FileDescriptor MwU;
  private String mUrl;
  
  public b(FileDescriptor paramFileDescriptor)
  {
    AppMethodBeat.i(194545);
    this.EWs = new HashMap();
    this.MwU = paramFileDescriptor;
    AppMethodBeat.o(194545);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(194544);
    this.EWs = new HashMap();
    this.mUrl = paramString;
    AppMethodBeat.o(194544);
  }
  
  public final void a(long paramLong, TPImageGeneratorParams paramTPImageGeneratorParams, d paramd)
  {
    AppMethodBeat.i(194546);
    int i = a.gbj().a(this.mUrl, this.MwU, paramLong, paramTPImageGeneratorParams.width, paramTPImageGeneratorParams.height, this);
    this.EWs.put(Integer.valueOf(i), paramd);
    AppMethodBeat.o(194546);
  }
  
  public final void ahS(int paramInt)
  {
    AppMethodBeat.i(194548);
    this.EWs.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(194548);
  }
  
  public final void ahT(int paramInt)
  {
    AppMethodBeat.i(194549);
    this.EWs.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(194549);
  }
  
  public final void release()
  {
    AppMethodBeat.i(194547);
    this.EWs.clear();
    AppMethodBeat.o(194547);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.c.b
 * JD-Core Version:    0.7.0.1
 */