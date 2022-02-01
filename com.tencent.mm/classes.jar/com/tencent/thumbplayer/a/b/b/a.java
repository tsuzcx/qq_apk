package com.tencent.thumbplayer.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.b;
import com.tencent.thumbplayer.core.common.TPDecoderType;
import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;

public final class a
{
  public static boolean d(b paramb)
  {
    AppMethodBeat.i(194521);
    if (paramb == null)
    {
      AppMethodBeat.o(194521);
      return true;
    }
    if (paramb.MsT == 0)
    {
      AppMethodBeat.o(194521);
      return true;
    }
    if ((g(paramb)) || (f(paramb)))
    {
      AppMethodBeat.o(194521);
      return true;
    }
    AppMethodBeat.o(194521);
    return false;
  }
  
  public static boolean e(b paramb)
  {
    AppMethodBeat.i(194522);
    if (paramb.MsT == 0)
    {
      AppMethodBeat.o(194522);
      return true;
    }
    boolean bool = f(paramb);
    AppMethodBeat.o(194522);
    return bool;
  }
  
  private static boolean f(b paramb)
  {
    AppMethodBeat.i(194523);
    boolean bool = TPThumbplayerCapabilityHelper.isVCodecCapabilitySupport(TPDecoderType.TP_VIDEO_DECODER_MEDIACODEC, paramb.MsT, (int)paramb.bbs, (int)paramb.bbt, paramb.MsS, paramb.MsY);
    AppMethodBeat.o(194523);
    return bool;
  }
  
  private static boolean g(b paramb)
  {
    AppMethodBeat.i(194524);
    boolean bool = TPThumbplayerCapabilityHelper.isVCodecCapabilitySupport(TPDecoderType.TP_VIDEO_DECODER_FFMPEG, paramb.MsT, (int)paramb.bbs, (int)paramb.bbt, paramb.MsS, paramb.MsY);
    AppMethodBeat.o(194524);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.a.b.b.a
 * JD-Core Version:    0.7.0.1
 */