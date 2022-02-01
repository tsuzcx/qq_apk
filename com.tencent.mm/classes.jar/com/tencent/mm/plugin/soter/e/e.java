package com.tencent.mm.plugin.soter.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.soter.a.c.b;
import com.tencent.soter.a.g.j;

public final class e
  extends j
{
  public e(Context paramContext, com.tencent.soter.a.g.e parame)
  {
    super(paramContext, parame);
  }
  
  @SuppressLint({"DefaultLocale"})
  public final void e(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(130887);
    ad.v("MicroMsg.SoterTaskInitForWX", "alvinluo generateAuthKeyNames");
    int j = paramArrayOfInt.length;
    int i = 0;
    if (i < j)
    {
      int k = paramArrayOfInt[i];
      if ((k == 1) && (com.tencent.mm.kernel.g.afz().aeI())) {}
      for (String str = m.dEU();; str = String.format("SoterAuthKey_salt%s_scene%d", new Object[] { com.tencent.soter.core.c.g.nullAsNil(paramString), Integer.valueOf(k) }))
      {
        ad.i("MicroMsg.SoterTaskInitForWX", "alvinluo scene: %d, authKeyName: %s", new Object[] { Integer.valueOf(k), str });
        b.fno().fnq().put(k, str);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(130887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.e.e
 * JD-Core Version:    0.7.0.1
 */