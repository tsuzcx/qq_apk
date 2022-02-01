package com.tencent.mm.plugin.scanner.word;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.worddetect.WordDetectNative.WordDetectDetailResult;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  private WordDetectNative.WordDetectDetailResult yBr;
  public List<Float> yBs;
  
  public b(WordDetectNative.WordDetectDetailResult paramWordDetectDetailResult)
  {
    AppMethodBeat.i(218747);
    this.yBs = new ArrayList();
    this.yBr = paramWordDetectDetailResult;
    if ((paramWordDetectDetailResult != null) && (paramWordDetectDetailResult.rate_lang != null))
    {
      int i = 0;
      while (i < paramWordDetectDetailResult.rate_lang.length)
      {
        ad.i("MicroMsg.WordDetectDetailResultWrapper", "%d ratio %f", new Object[] { Integer.valueOf(i), Float.valueOf(paramWordDetectDetailResult.rate_lang[i]) });
        this.yBs.add(Float.valueOf(paramWordDetectDetailResult.rate_lang[i]));
        i += 1;
      }
    }
    AppMethodBeat.o(218747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.word.b
 * JD-Core Version:    0.7.0.1
 */