package com.tencent.mm.plugin.soter.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.soter.a.c.b;
import com.tencent.soter.a.g.e;
import com.tencent.soter.a.g.j;

public final class f
  extends j
{
  public f(Context paramContext, e parame)
  {
    super(paramContext, parame);
  }
  
  @SuppressLint({"DefaultLocale"})
  public final void e(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(130887);
    ac.v("MicroMsg.SoterTaskInitForWX", "alvinluo generateAuthKeyNames");
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      paramString = m.Qm(k);
      ac.i("MicroMsg.SoterTaskInitForWX", "alvinluo scene: %d, authKeyName: %s", new Object[] { Integer.valueOf(k), paramString });
      b.fDE().fDG().put(k, paramString);
      i += 1;
    }
    AppMethodBeat.o(130887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.e.f
 * JD-Core Version:    0.7.0.1
 */