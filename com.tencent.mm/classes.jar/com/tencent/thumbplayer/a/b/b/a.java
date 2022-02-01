package com.tencent.thumbplayer.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.b;
import com.tencent.thumbplayer.core.common.TPDecoderType;
import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;

public final class a
{
  public static boolean d(b paramb)
  {
    AppMethodBeat.i(187822);
    if (paramb == null)
    {
      AppMethodBeat.o(187822);
      return true;
    }
    if (paramb.Kcc == 0)
    {
      AppMethodBeat.o(187822);
      return true;
    }
    if ((g(paramb)) || (f(paramb)))
    {
      AppMethodBeat.o(187822);
      return true;
    }
    AppMethodBeat.o(187822);
    return false;
  }
  
  public static boolean e(b paramb)
  {
    AppMethodBeat.i(187823);
    if (paramb.Kcc == 0)
    {
      AppMethodBeat.o(187823);
      return true;
    }
    boolean bool = f(paramb);
    AppMethodBeat.o(187823);
    return bool;
  }
  
  private static boolean f(b paramb)
  {
    AppMethodBeat.i(187824);
    boolean bool = TPThumbplayerCapabilityHelper.isVCodecCapabilitySupport(TPDecoderType.TP_VIDEO_DECODER_MEDIACODEC, paramb.Kcc, (int)paramb.aQX, (int)paramb.aQY, paramb.Kcb, paramb.Kch);
    AppMethodBeat.o(187824);
    return bool;
  }
  
  private static boolean g(b paramb)
  {
    AppMethodBeat.i(187825);
    boolean bool = TPThumbplayerCapabilityHelper.isVCodecCapabilitySupport(TPDecoderType.TP_VIDEO_DECODER_FFMPEG, paramb.Kcc, (int)paramb.aQX, (int)paramb.aQY, paramb.Kcb, paramb.Kch);
    AppMethodBeat.o(187825);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.a.b.b.a
 * JD-Core Version:    0.7.0.1
 */