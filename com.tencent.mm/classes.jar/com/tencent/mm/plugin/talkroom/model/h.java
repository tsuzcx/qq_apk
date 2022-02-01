package com.tencent.mm.plugin.talkroom.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;

public final class h
{
  private static final int yIf = a.yIf;
  
  public static String bf(Context paramContext, String paramString)
  {
    AppMethodBeat.i(29528);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(29528);
      return null;
    }
    az.arV();
    af localaf = c.apM().aHY(paramString);
    if (localaf == null)
    {
      AppMethodBeat.o(29528);
      return null;
    }
    if (w.pF(paramString))
    {
      if (bt.isNullOrNil(localaf.field_nickname))
      {
        paramContext = paramContext.getString(2131764368);
        AppMethodBeat.o(29528);
        return paramContext;
      }
      paramContext = localaf.ZW();
      AppMethodBeat.o(29528);
      return paramContext;
    }
    paramContext = v.sh(paramString);
    AppMethodBeat.o(29528);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.h
 * JD-Core Version:    0.7.0.1
 */