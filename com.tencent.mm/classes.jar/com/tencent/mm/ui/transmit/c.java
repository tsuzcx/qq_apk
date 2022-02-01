package com.tencent.mm.ui.transmit;

import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;

public final class c
{
  private static final SparseIntArray Qye;
  
  static
  {
    AppMethodBeat.i(234473);
    Qye = new SparseIntArray();
    AppMethodBeat.o(234473);
  }
  
  public static ad.b bnX(String paramString)
  {
    AppMethodBeat.i(234472);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(234472);
      return null;
    }
    int j = paramString.hashCode();
    synchronized (Qye)
    {
      int i = Qye.get(j, 0) - 1;
      if (i <= 0)
      {
        i = 1;
        Qye.delete(j);
        if (i != 0)
        {
          paramString = ad.aVe().JW(paramString);
          AppMethodBeat.o(234472);
          return paramString;
        }
      }
      else
      {
        Qye.put(j, i);
        i = 0;
      }
    }
    paramString = ad.aVe().G(paramString, false);
    AppMethodBeat.o(234472);
    return paramString;
  }
  
  public static void hn(String arg0, int paramInt)
  {
    AppMethodBeat.i(234471);
    if (TextUtils.isEmpty(???))
    {
      AppMethodBeat.o(234471);
      return;
    }
    int i = ???.hashCode();
    synchronized (Qye)
    {
      Qye.put(i, Math.max(paramInt, 1));
      AppMethodBeat.o(234471);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.c
 * JD-Core Version:    0.7.0.1
 */