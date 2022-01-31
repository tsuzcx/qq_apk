package com.tinkerboots.sdk.b;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static boolean jZ(Context paramContext)
  {
    AppMethodBeat.i(65554);
    if (Build.VERSION.SDK_INT < 23)
    {
      AppMethodBeat.o(65554);
      return true;
    }
    int i;
    if (paramContext.checkSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0)
    {
      i = 1;
      if (paramContext.checkSelfPermission("android.permission.INTERNET") != 0) {
        break label62;
      }
    }
    label62:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j == 0)) {
        break label67;
      }
      AppMethodBeat.o(65554);
      return true;
      i = 0;
      break;
    }
    label67:
    AppMethodBeat.o(65554);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tinkerboots.sdk.b.b
 * JD-Core Version:    0.7.0.1
 */