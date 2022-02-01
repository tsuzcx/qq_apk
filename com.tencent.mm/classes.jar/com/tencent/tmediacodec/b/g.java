package com.tencent.tmediacodec.b;

import android.media.MediaCodec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmediacodec.e.a;
import com.tencent.tmediacodec.e.a.b;
import com.tencent.tmediacodec.g.d;
import java.util.ArrayList;

public final class g
  extends f
{
  public g(MediaCodec paramMediaCodec, e parame)
  {
    super(paramMediaCodec, parame);
  }
  
  public final a.b a(e parame)
  {
    int k = 0;
    AppMethodBeat.i(190130);
    if ((a.a(this, parame)) && (parame.width <= this.SlC.width) && (parame.height <= this.SlC.height) && (d.b(this, parame) <= this.SlC.bIC))
    {
      e locale = this.SlB;
      int i;
      if (parame.Slz.size() != locale.Slz.size()) {
        i = k;
      }
      while (i != 0)
      {
        parame = a.b.SmE;
        AppMethodBeat.o(190130);
        return parame;
        int j = 0;
        for (;;)
        {
          if (j >= parame.Slz.size()) {
            break label150;
          }
          i = k;
          if (!((byte[])parame.Slz.get(j)).equals(locale.Slz.get(j))) {
            break;
          }
          j += 1;
        }
        label150:
        i = 1;
      }
      parame = a.b.SmD;
      AppMethodBeat.o(190130);
      return parame;
    }
    parame = a.b.SmB;
    AppMethodBeat.o(190130);
    return parame;
  }
  
  public final boolean hpw()
  {
    AppMethodBeat.i(190131);
    if ((super.hpw()) && (this.mSurface != null) && (this.SlB.bdv == 0))
    {
      AppMethodBeat.o(190131);
      return true;
    }
    AppMethodBeat.o(190131);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(190132);
    String str = "VideoCodecWrapper[" + hashCode() + ']';
    AppMethodBeat.o(190132);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tmediacodec.b.g
 * JD-Core Version:    0.7.0.1
 */