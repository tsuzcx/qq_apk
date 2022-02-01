package com.tencent.thumbplayer.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.b;
import com.tencent.thumbplayer.core.common.TPDecoderType;
import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;

public final class a
{
  public static boolean d(b paramb)
  {
    AppMethodBeat.i(191843);
    if (paramb == null)
    {
      AppMethodBeat.o(191843);
      return true;
    }
    if (paramb.LVY == 0)
    {
      AppMethodBeat.o(191843);
      return true;
    }
    if ((g(paramb)) || (f(paramb)))
    {
      AppMethodBeat.o(191843);
      return true;
    }
    AppMethodBeat.o(191843);
    return false;
  }
  
  public static boolean e(b paramb)
  {
    AppMethodBeat.i(191844);
    if (paramb.LVY == 0)
    {
      AppMethodBeat.o(191844);
      return true;
    }
    boolean bool = f(paramb);
    AppMethodBeat.o(191844);
    return bool;
  }
  
  private static boolean f(b paramb)
  {
    AppMethodBeat.i(191845);
    boolean bool = TPThumbplayerCapabilityHelper.isVCodecCapabilitySupport(TPDecoderType.TP_VIDEO_DECODER_MEDIACODEC, paramb.LVY, (int)paramb.bbs, (int)paramb.bbt, paramb.LVX, paramb.LWd);
    AppMethodBeat.o(191845);
    return bool;
  }
  
  private static boolean g(b paramb)
  {
    AppMethodBeat.i(191846);
    boolean bool = TPThumbplayerCapabilityHelper.isVCodecCapabilitySupport(TPDecoderType.TP_VIDEO_DECODER_FFMPEG, paramb.LVY, (int)paramb.bbs, (int)paramb.bbt, paramb.LVX, paramb.LWd);
    AppMethodBeat.o(191846);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.a.b.b.a
 * JD-Core Version:    0.7.0.1
 */