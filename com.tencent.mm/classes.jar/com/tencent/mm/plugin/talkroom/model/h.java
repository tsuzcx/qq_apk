package com.tencent.mm.plugin.talkroom.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;

public final class h
{
  private static final int BEw = a.BEw;
  
  public static String bl(Context paramContext, String paramString)
  {
    AppMethodBeat.i(29528);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(29528);
      return null;
    }
    bc.aCg();
    an localan = c.azF().BH(paramString);
    if (localan == null)
    {
      AppMethodBeat.o(29528);
      return null;
    }
    if (x.wb(paramString))
    {
      if (bu.isNullOrNil(localan.field_nickname))
      {
        paramContext = paramContext.getString(2131764368);
        AppMethodBeat.o(29528);
        return paramContext;
      }
      paramContext = localan.adF();
      AppMethodBeat.o(29528);
      return paramContext;
    }
    paramContext = w.zP(paramString);
    AppMethodBeat.o(29528);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.h
 * JD-Core Version:    0.7.0.1
 */