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
    AppMethodBeat.i(224422);
    if ((a.a(this, parame)) && (parame.width <= this.ZOn.width) && (parame.height <= this.ZOn.height) && (d.b(this, parame) <= this.ZOn.bsm))
    {
      e locale = this.ZOm;
      int i;
      if (parame.ZOk.size() != locale.ZOk.size()) {
        i = k;
      }
      while (i != 0)
      {
        parame = a.b.ZPp;
        AppMethodBeat.o(224422);
        return parame;
        int j = 0;
        for (;;)
        {
          if (j >= parame.ZOk.size()) {
            break label150;
          }
          i = k;
          if (!((byte[])parame.ZOk.get(j)).equals(locale.ZOk.get(j))) {
            break;
          }
          j += 1;
        }
        label150:
        i = 1;
      }
      parame = a.b.ZPo;
      AppMethodBeat.o(224422);
      return parame;
    }
    parame = a.b.ZPm;
    AppMethodBeat.o(224422);
    return parame;
  }
  
  public final boolean itc()
  {
    AppMethodBeat.i(224424);
    if ((super.itc()) && (this.mSurface != null) && (this.ZOm.aMV == 0))
    {
      AppMethodBeat.o(224424);
      return true;
    }
    AppMethodBeat.o(224424);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(224426);
    String str = "VideoCodecWrapper[" + hashCode() + ']';
    AppMethodBeat.o(224426);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmediacodec.b.g
 * JD-Core Version:    0.7.0.1
 */