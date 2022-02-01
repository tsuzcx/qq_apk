package com.tencent.mm.plugin.talkroom.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;

public final class h
{
  private static final int Mjo = a.Mjo;
  
  public static String bQ(Context paramContext, String paramString)
  {
    AppMethodBeat.i(29528);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(29528);
      return null;
    }
    bh.beI();
    as localas = c.bbL().RG(paramString);
    if (localas == null)
    {
      AppMethodBeat.o(29528);
      return null;
    }
    if (ab.Lj(paramString))
    {
      if (Util.isNullOrNil(localas.field_nickname))
      {
        paramContext = paramContext.getString(R.l.eUg);
        AppMethodBeat.o(29528);
        return paramContext;
      }
      paramContext = localas.ayr();
      AppMethodBeat.o(29528);
      return paramContext;
    }
    paramContext = aa.PJ(paramString);
    AppMethodBeat.o(29528);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.h
 * JD-Core Version:    0.7.0.1
 */