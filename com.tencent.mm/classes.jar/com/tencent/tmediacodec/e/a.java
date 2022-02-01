package com.tencent.tmediacodec.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmediacodec.b.e;
import com.tencent.tmediacodec.b.f;
import com.tencent.tmediacodec.b.g;

public final class a
{
  public static boolean a(f paramf, e parame)
  {
    AppMethodBeat.i(210761);
    e locale = paramf.ahTn;
    if ((paramf instanceof g))
    {
      if ((TextUtils.equals(locale.cGN, parame.cGN)) && (locale.Gj == parame.Gj) && ((paramf.cWv) || ((locale.width == parame.width) && (locale.height == parame.height))))
      {
        AppMethodBeat.o(210761);
        return true;
      }
      AppMethodBeat.o(210761);
      return false;
    }
    if ((paramf instanceof com.tencent.tmediacodec.b.a))
    {
      if ((!TextUtils.equals("audio/mp4a-latm", locale.cGN)) || (!TextUtils.equals(locale.cGN, parame.cGN)) || (locale.channelCount != parame.channelCount) || (locale.sampleRate != parame.sampleRate))
      {
        AppMethodBeat.o(210761);
        return false;
      }
      AppMethodBeat.o(210761);
      return false;
    }
    AppMethodBeat.o(210761);
    return true;
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(210773);
      ahUn = new b("KEEP_CODEC_RESULT_NO", 0);
      ahUo = new b("KEEP_CODEC_RESULT_YES_WITH_FLUSH", 1);
      ahUp = new b("KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION", 2);
      ahUq = new b("KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION", 3);
      ahUr = new b[] { ahUn, ahUo, ahUp, ahUq };
      AppMethodBeat.o(210773);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmediacodec.e.a
 * JD-Core Version:    0.7.0.1
 */