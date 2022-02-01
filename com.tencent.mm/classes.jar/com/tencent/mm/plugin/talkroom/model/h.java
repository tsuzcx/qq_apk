package com.tencent.mm.plugin.talkroom.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;

public final class h
{
  private static final int zVt = a.zVt;
  
  public static String bg(Context paramContext, String paramString)
  {
    AppMethodBeat.i(29528);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(29528);
      return null;
    }
    az.ayM();
    ai localai = c.awB().aNt(paramString);
    if (localai == null)
    {
      AppMethodBeat.o(29528);
      return null;
    }
    if (w.sQ(paramString))
    {
      if (bs.isNullOrNil(localai.field_nickname))
      {
        paramContext = paramContext.getString(2131764368);
        AppMethodBeat.o(29528);
        return paramContext;
      }
      paramContext = localai.aaR();
      AppMethodBeat.o(29528);
      return paramContext;
    }
    paramContext = v.wk(paramString);
    AppMethodBeat.o(29528);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.h
 * JD-Core Version:    0.7.0.1
 */