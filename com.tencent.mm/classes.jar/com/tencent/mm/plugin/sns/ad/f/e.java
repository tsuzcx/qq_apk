package com.tencent.mm.plugin.sns.ad.f;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.z;

public final class e
  extends z
{
  public static double g(Bundle paramBundle, String paramString)
  {
    double d1 = 0.0D;
    AppMethodBeat.i(219176);
    if (paramBundle == null)
    {
      AppMethodBeat.o(219176);
      return 0.0D;
    }
    try
    {
      double d2 = paramBundle.getDouble(paramString, 0.0D);
      d1 = d2;
    }
    catch (Throwable paramBundle)
    {
      label29:
      break label29;
    }
    AppMethodBeat.o(219176);
    return d1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.f.e
 * JD-Core Version:    0.7.0.1
 */