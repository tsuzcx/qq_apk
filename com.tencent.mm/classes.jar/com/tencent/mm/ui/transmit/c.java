package com.tencent.mm.ui.transmit;

import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;

public final class c
{
  private static final SparseIntArray afMA;
  
  static
  {
    AppMethodBeat.i(250934);
    afMA = new SparseIntArray();
    AppMethodBeat.o(250934);
  }
  
  public static ad.b bCJ(String paramString)
  {
    AppMethodBeat.i(250932);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(250932);
      return null;
    }
    int j = paramString.hashCode();
    synchronized (afMA)
    {
      int i = afMA.get(j, 0) - 1;
      if (i <= 0)
      {
        i = 1;
        afMA.delete(j);
        if (i != 0)
        {
          paramString = ad.bCb().Jn(paramString);
          AppMethodBeat.o(250932);
          return paramString;
        }
      }
      else
      {
        afMA.put(j, i);
        i = 0;
      }
    }
    paramString = ad.bCb().M(paramString, false);
    AppMethodBeat.o(250932);
    return paramString;
  }
  
  public static void jg(String arg0, int paramInt)
  {
    AppMethodBeat.i(250928);
    if (TextUtils.isEmpty(???))
    {
      AppMethodBeat.o(250928);
      return;
    }
    int i = ???.hashCode();
    synchronized (afMA)
    {
      afMA.put(i, Math.max(paramInt, 1));
      AppMethodBeat.o(250928);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.c
 * JD-Core Version:    0.7.0.1
 */