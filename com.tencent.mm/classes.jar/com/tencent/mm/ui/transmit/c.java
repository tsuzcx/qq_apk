package com.tencent.mm.ui.transmit;

import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;

public final class c
{
  private static final SparseIntArray XWj;
  
  static
  {
    AppMethodBeat.i(272550);
    XWj = new SparseIntArray();
    AppMethodBeat.o(272550);
  }
  
  public static ad.b bAK(String paramString)
  {
    AppMethodBeat.i(272549);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(272549);
      return null;
    }
    int j = paramString.hashCode();
    synchronized (XWj)
    {
      int i = XWj.get(j, 0) - 1;
      if (i <= 0)
      {
        i = 1;
        XWj.delete(j);
        if (i != 0)
        {
          paramString = ad.beh().Ro(paramString);
          AppMethodBeat.o(272549);
          return paramString;
        }
      }
      else
      {
        XWj.put(j, i);
        i = 0;
      }
    }
    paramString = ad.beh().I(paramString, false);
    AppMethodBeat.o(272549);
    return paramString;
  }
  
  public static void hW(String arg0, int paramInt)
  {
    AppMethodBeat.i(272548);
    if (TextUtils.isEmpty(???))
    {
      AppMethodBeat.o(272548);
      return;
    }
    int i = ???.hashCode();
    synchronized (XWj)
    {
      XWj.put(i, Math.max(paramInt, 1));
      AppMethodBeat.o(272548);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.c
 * JD-Core Version:    0.7.0.1
 */