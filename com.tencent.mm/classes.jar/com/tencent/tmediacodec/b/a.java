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
    AppMethodBeat.i(210806);
    if (com.tencent.tmediacodec.e.a.a(this, parame))
    {
      parame = a.b.ahUq;
      AppMethodBeat.o(210806);
      return parame;
    }
    parame = a.b.ahUn;
    AppMethodBeat.o(210806);
    return parame;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(210811);
    String str = "AudioCodecWrapper[" + hashCode() + ']';
    AppMethodBeat.o(210811);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmediacodec.b.a
 * JD-Core Version:    0.7.0.1
 */