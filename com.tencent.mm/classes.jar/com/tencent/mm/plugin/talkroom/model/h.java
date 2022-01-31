package com.tencent.mm.plugin.talkroom.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

public final class h
{
  private static final int tbK = a.tbK;
  
  public static String aT(Context paramContext, String paramString)
  {
    AppMethodBeat.i(25846);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(25846);
      return null;
    }
    aw.aaz();
    ad localad = c.YA().arw(paramString);
    if (localad == null)
    {
      AppMethodBeat.o(25846);
      return null;
    }
    if (t.lA(paramString))
    {
      if (bo.isNullOrNil(localad.field_nickname))
      {
        paramContext = paramContext.getString(2131304250);
        AppMethodBeat.o(25846);
        return paramContext;
      }
      paramContext = localad.Oe();
      AppMethodBeat.o(25846);
      return paramContext;
    }
    paramContext = s.nE(paramString);
    AppMethodBeat.o(25846);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.h
 * JD-Core Version:    0.7.0.1
 */