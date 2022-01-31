package com.tencent.mm.plugin.soter.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.SparseArray;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.soter.a.g.j;

public final class e
  extends j
{
  public e(Context paramContext, com.tencent.soter.a.g.e parame)
  {
    super(paramContext, parame);
  }
  
  @SuppressLint({"DefaultLocale"})
  protected final void b(String paramString, int[] paramArrayOfInt)
  {
    y.v("MicroMsg.SoterTaskInitForWX", "alvinluo generateAuthKeyNames");
    int j = paramArrayOfInt.length;
    int i = 0;
    if (i < j)
    {
      int k = paramArrayOfInt[i];
      if ((k == 1) && (com.tencent.mm.kernel.g.DN().Dc())) {}
      for (String str = m.bKU();; str = String.format("SoterAuthKey_salt%s_scene%d", new Object[] { com.tencent.soter.core.c.g.pm(paramString), Integer.valueOf(k) }))
      {
        y.i("MicroMsg.SoterTaskInitForWX", "alvinluo scene: %d, authKeyName: %s", new Object[] { Integer.valueOf(k), str });
        com.tencent.soter.a.c.a.cPy().cPA().put(k, str);
        i += 1;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.e.e
 * JD-Core Version:    0.7.0.1
 */