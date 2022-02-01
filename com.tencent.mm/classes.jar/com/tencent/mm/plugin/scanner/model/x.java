package com.tencent.mm.plugin.scanner.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.k.b;
import com.tencent.mm.plugin.scanner.util.q;
import com.tencent.mm.plugin.scanner.util.q.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class x
{
  public static String a(Context paramContext, q.a parama)
  {
    AppMethodBeat.i(51634);
    k.b localb = new k.b();
    localb.appId = ahM(parama.field_functionType);
    localb.title = parama.field_title;
    localb.description = parama.field_source;
    localb.type = 10;
    localb.url = parama.field_shareurl;
    localb.action = "";
    localb.appName = q.aR(paramContext, parama.field_type);
    localb.thumburl = parama.field_thumburl;
    localb.nRA = parama.field_type;
    localb.nRB = q.c(parama);
    paramContext = k.b.a(localb, null, null);
    AppMethodBeat.o(51634);
    return paramContext;
  }
  
  public static String ahM(int paramInt)
  {
    if (paramInt == 4) {
      return "wxfbc915ff7c30e335";
    }
    if (paramInt == 3) {
      return "wx482a4001c37e2b74";
    }
    return "wxfbc915ff7c30e335";
  }
  
  public static q.a gI(String paramString, int paramInt)
  {
    AppMethodBeat.i(51635);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(51635);
      return null;
    }
    int i = q.aVj(paramString);
    if (i == 3)
    {
      paramString = q.gJ(paramString, paramInt);
      AppMethodBeat.o(51635);
      return paramString;
    }
    if (i == 4)
    {
      paramString = q.aVk(paramString);
      AppMethodBeat.o(51635);
      return paramString;
    }
    AppMethodBeat.o(51635);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.x
 * JD-Core Version:    0.7.0.1
 */