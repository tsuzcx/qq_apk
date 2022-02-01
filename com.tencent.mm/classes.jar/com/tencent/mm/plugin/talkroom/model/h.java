package com.tencent.mm.plugin.talkroom.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;

public final class h
{
  private static final int BmX = a.BmX;
  
  public static String bj(Context paramContext, String paramString)
  {
    AppMethodBeat.i(29528);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(29528);
      return null;
    }
    ba.aBQ();
    am localam = c.azp().Bf(paramString);
    if (localam == null)
    {
      AppMethodBeat.o(29528);
      return null;
    }
    if (w.vF(paramString))
    {
      if (bt.isNullOrNil(localam.field_nickname))
      {
        paramContext = paramContext.getString(2131764368);
        AppMethodBeat.o(29528);
        return paramContext;
      }
      paramContext = localam.adu();
      AppMethodBeat.o(29528);
      return paramContext;
    }
    paramContext = v.zf(paramString);
    AppMethodBeat.o(29528);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.h
 * JD-Core Version:    0.7.0.1
 */