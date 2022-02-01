package com.tencent.mm.plugin.talkroom.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;

public final class h
{
  private static final int SMK = a.SMK;
  
  public static String bU(Context paramContext, String paramString)
  {
    AppMethodBeat.i(29528);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(29528);
      return null;
    }
    bh.bCz();
    au localau = c.bzA().JE(paramString);
    if (localau == null)
    {
      AppMethodBeat.o(29528);
      return null;
    }
    if (au.bwE(paramString))
    {
      if (Util.isNullOrNil(localau.field_nickname))
      {
        paramContext = paramContext.getString(R.l.gXa);
        AppMethodBeat.o(29528);
        return paramContext;
      }
      paramContext = localau.aSU();
      AppMethodBeat.o(29528);
      return paramContext;
    }
    paramContext = aa.getDisplayName(paramString);
    AppMethodBeat.o(29528);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.h
 * JD-Core Version:    0.7.0.1
 */