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
    AppMethodBeat.i(224557);
    e locale = paramf.ZOm;
    if ((paramf instanceof g))
    {
      if ((TextUtils.equals(locale.aMQ, parame.aMQ)) && (locale.aMV == parame.aMV) && ((paramf.bcA) || ((locale.width == parame.width) && (locale.height == parame.height))))
      {
        AppMethodBeat.o(224557);
        return true;
      }
      AppMethodBeat.o(224557);
      return false;
    }
    if ((paramf instanceof com.tencent.tmediacodec.b.a))
    {
      if ((!TextUtils.equals("audio/mp4a-latm", locale.aMQ)) || (!TextUtils.equals(locale.aMQ, parame.aMQ)) || (locale.channelCount != parame.channelCount) || (locale.sampleRate != parame.sampleRate))
      {
        AppMethodBeat.o(224557);
        return false;
      }
      AppMethodBeat.o(224557);
      return false;
    }
    AppMethodBeat.o(224557);
    return true;
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(224546);
      ZPm = new b("KEEP_CODEC_RESULT_NO", 0);
      ZPn = new b("KEEP_CODEC_RESULT_YES_WITH_FLUSH", 1);
      ZPo = new b("KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION", 2);
      ZPp = new b("KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION", 3);
      ZPq = new b[] { ZPm, ZPn, ZPo, ZPp };
      AppMethodBeat.o(224546);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmediacodec.e.a
 * JD-Core Version:    0.7.0.1
 */