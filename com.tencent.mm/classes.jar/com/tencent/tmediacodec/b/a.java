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
    AppMethodBeat.i(224223);
    if (com.tencent.tmediacodec.e.a.a(this, parame))
    {
      parame = a.b.ZPp;
      AppMethodBeat.o(224223);
      return parame;
    }
    parame = a.b.ZPm;
    AppMethodBeat.o(224223);
    return parame;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(224226);
    String str = "AudioCodecWrapper[" + hashCode() + ']';
    AppMethodBeat.o(224226);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmediacodec.b.a
 * JD-Core Version:    0.7.0.1
 */