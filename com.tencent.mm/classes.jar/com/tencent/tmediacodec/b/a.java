package com.tencent.tmediacodec.b;

import android.media.MediaCodec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmediacodec.e.a.b;

public final class a
  extends f
{
  public a(MediaCodec paramMediaCodec, e parame)
  {
    super(paramMediaCodec, parame);
  }
  
  public final a.b a(e parame)
  {
    AppMethodBeat.i(190099);
    if (com.tencent.tmediacodec.e.a.a(this, parame))
    {
      parame = a.b.SmE;
      AppMethodBeat.o(190099);
      return parame;
    }
    parame = a.b.SmB;
    AppMethodBeat.o(190099);
    return parame;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(190100);
    String str = "AudioCodecWrapper[" + hashCode() + ']';
    AppMethodBeat.o(190100);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tmediacodec.b.a
 * JD-Core Version:    0.7.0.1
 */