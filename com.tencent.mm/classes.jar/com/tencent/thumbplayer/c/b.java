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
  private Map<Integer, d> CZX;
  private FileDescriptor KgJ;
  private String mUrl;
  
  public b(FileDescriptor paramFileDescriptor)
  {
    AppMethodBeat.i(187846);
    this.CZX = new HashMap();
    this.KgJ = paramFileDescriptor;
    AppMethodBeat.o(187846);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(187845);
    this.CZX = new HashMap();
    this.mUrl = paramString;
    AppMethodBeat.o(187845);
  }
  
  public final void a(long paramLong, TPImageGeneratorParams paramTPImageGeneratorParams, d paramd)
  {
    AppMethodBeat.i(187847);
    int i = a.fFv().a(this.mUrl, this.KgJ, paramLong, paramTPImageGeneratorParams.width, paramTPImageGeneratorParams.height, this);
    this.CZX.put(Integer.valueOf(i), paramd);
    AppMethodBeat.o(187847);
  }
  
  public final void aeJ(int paramInt)
  {
    AppMethodBeat.i(187849);
    this.CZX.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(187849);
  }
  
  public final void aeK(int paramInt)
  {
    AppMethodBeat.i(187850);
    this.CZX.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(187850);
  }
  
  public final void release()
  {
    AppMethodBeat.i(187848);
    this.CZX.clear();
    AppMethodBeat.o(187848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.c.b
 * JD-Core Version:    0.7.0.1
 */