package com.tencent.mm.plugin.talkroom.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;

public final class h
{
  private static final int FPn = a.FPn;
  
  public static String bC(Context paramContext, String paramString)
  {
    AppMethodBeat.i(29528);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(29528);
      return null;
    }
    bg.aVF();
    as localas = c.aSN().Kn(paramString);
    if (localas == null)
    {
      AppMethodBeat.o(29528);
      return null;
    }
    if (ab.Eq(paramString))
    {
      if (Util.isNullOrNil(localas.field_nickname))
      {
        paramContext = paramContext.getString(2131766629);
        AppMethodBeat.o(29528);
        return paramContext;
      }
      paramContext = localas.arI();
      AppMethodBeat.o(29528);
      return paramContext;
    }
    paramContext = aa.getDisplayName(paramString);
    AppMethodBeat.o(29528);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.h
 * JD-Core Version:    0.7.0.1
 */