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
    AppMethodBeat.i(190171);
    e locale = paramf.SlB;
    if ((paramf instanceof g))
    {
      if ((TextUtils.equals(locale.bdq, parame.bdq)) && (locale.bdv == parame.bdv) && ((paramf.bsX) || ((locale.width == parame.width) && (locale.height == parame.height))))
      {
        AppMethodBeat.o(190171);
        return true;
      }
      AppMethodBeat.o(190171);
      return false;
    }
    if ((paramf instanceof com.tencent.tmediacodec.b.a))
    {
      if ((!TextUtils.equals("audio/mp4a-latm", locale.bdq)) || (!TextUtils.equals(locale.bdq, parame.bdq)) || (locale.channelCount != parame.channelCount) || (locale.sampleRate != parame.sampleRate))
      {
        AppMethodBeat.o(190171);
        return false;
      }
      AppMethodBeat.o(190171);
      return false;
    }
    AppMethodBeat.o(190171);
    return true;
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(190170);
      SmB = new b("KEEP_CODEC_RESULT_NO", 0);
      SmC = new b("KEEP_CODEC_RESULT_YES_WITH_FLUSH", 1);
      SmD = new b("KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION", 2);
      SmE = new b("KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION", 3);
      SmF = new b[] { SmB, SmC, SmD, SmE };
      AppMethodBeat.o(190170);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tmediacodec.e.a
 * JD-Core Version:    0.7.0.1
 */