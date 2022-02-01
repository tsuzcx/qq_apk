package com.tencent.mm.plugin.scanner.word;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.worddetect.WordDetectNative.WordDetectDetailResult;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  private WordDetectNative.WordDetectDetailResult Plh;
  public List<Float> Pli;
  
  public b(WordDetectNative.WordDetectDetailResult paramWordDetectDetailResult)
  {
    AppMethodBeat.i(313421);
    this.Pli = new ArrayList();
    this.Plh = paramWordDetectDetailResult;
    if ((paramWordDetectDetailResult != null) && (paramWordDetectDetailResult.rate_lang != null))
    {
      int i = 0;
      while (i < paramWordDetectDetailResult.rate_lang.length)
      {
        Log.i("MicroMsg.WordDetectDetailResultWrapper", "%d ratio %f", new Object[] { Integer.valueOf(i), Float.valueOf(paramWordDetectDetailResult.rate_lang[i]) });
        this.Pli.add(Float.valueOf(paramWordDetectDetailResult.rate_lang[i]));
        i += 1;
      }
    }
    AppMethodBeat.o(313421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.word.b
 * JD-Core Version:    0.7.0.1
 */