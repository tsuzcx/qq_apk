package com.tencent.mm.plugin.sns.ad.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.tools.a.a;
import java.util.Collections;
import java.util.List;

public final class j
{
  public static boolean a(String paramString1, String paramString2, float paramFloat)
  {
    AppMethodBeat.i(201939);
    try
    {
      paramString2 = r.aOy(paramString2);
      paramString1 = r.aOy(paramString1);
      if ((paramString2.size() > 0) && (paramString1.size() > 0))
      {
        paramString1 = a.jX(paramString1);
        double d1 = a.E(paramString2, paramString1);
        Collections.reverse(paramString2);
        double d2 = a.E(paramString2, paramString1);
        float f = (float)Math.min(d1, d2);
        Log.i("GestureHelper", "similarity: %f,%f, distance:%f", new Object[] { Double.valueOf(d1), Double.valueOf(d2), Float.valueOf(f) });
        if (f <= paramFloat)
        {
          AppMethodBeat.o(201939);
          return true;
        }
      }
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("GestureHelper", paramString1, "recog gesture error!", new Object[0]);
      AppMethodBeat.o(201939);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.j
 * JD-Core Version:    0.7.0.1
 */