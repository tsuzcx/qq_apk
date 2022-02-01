package com.tencent.mm.plugin.soter.d;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.a.c.b;
import com.tencent.soter.a.g.e;

public final class f
  extends com.tencent.soter.a.g.j
{
  public f(Context paramContext, e parame)
  {
    super(paramContext, parame);
  }
  
  public final void e(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(130887);
    Log.v("MicroMsg.SoterTaskInitForWX", "alvinluo generateAuthKeyNames");
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      paramString = com.tencent.mm.plugin.soter.model.j.amT(k);
      Log.i("MicroMsg.SoterTaskInitForWX", "alvinluo scene: %d, authKeyName: %s", new Object[] { Integer.valueOf(k), paramString });
      b.jYt().jYv().put(k, paramString);
      i += 1;
    }
    AppMethodBeat.o(130887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.d.f
 * JD-Core Version:    0.7.0.1
 */