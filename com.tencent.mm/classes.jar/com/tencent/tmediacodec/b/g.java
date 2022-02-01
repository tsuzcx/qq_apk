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
    AppMethodBeat.i(210831);
    if ((a.a(this, parame)) && (parame.width <= this.ahTo.width) && (parame.height <= this.ahTo.height) && (d.b(this, parame) <= this.ahTo.dlO))
    {
      e locale = this.ahTn;
      int i;
      if (parame.ahTl.size() != locale.ahTl.size()) {
        i = k;
      }
      while (i != 0)
      {
        parame = a.b.ahUq;
        AppMethodBeat.o(210831);
        return parame;
        int j = 0;
        for (;;)
        {
          if (j >= parame.ahTl.size()) {
            break label150;
          }
          i = k;
          if (!((byte[])parame.ahTl.get(j)).equals(locale.ahTl.get(j))) {
            break;
          }
          j += 1;
        }
        label150:
        i = 1;
      }
      parame = a.b.ahUp;
      AppMethodBeat.o(210831);
      return parame;
    }
    parame = a.b.ahUn;
    AppMethodBeat.o(210831);
    return parame;
  }
  
  public final boolean kcw()
  {
    AppMethodBeat.i(210841);
    if ((super.kcw()) && (this.mSurface != null) && (this.ahTn.Gj == 0))
    {
      AppMethodBeat.o(210841);
      return true;
    }
    AppMethodBeat.o(210841);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(210852);
    String str = "VideoCodecWrapper[" + hashCode() + ']';
    AppMethodBeat.o(210852);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmediacodec.b.g
 * JD-Core Version:    0.7.0.1
 */