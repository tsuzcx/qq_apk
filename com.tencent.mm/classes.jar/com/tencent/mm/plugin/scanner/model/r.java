package com.tencent.mm.plugin.scanner.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.plugin.scanner.util.n.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class r
{
  public static String Wu(int paramInt)
  {
    if (paramInt == 4) {
      return "wxfbc915ff7c30e335";
    }
    if (paramInt == 3) {
      return "wx482a4001c37e2b74";
    }
    return "wxfbc915ff7c30e335";
  }
  
  public static String a(Context paramContext, n.a parama)
  {
    AppMethodBeat.i(51634);
    k.b localb = new k.b();
    localb.appId = Wu(parama.field_functionType);
    localb.title = parama.field_title;
    localb.description = parama.field_source;
    localb.type = 10;
    localb.url = parama.field_shareurl;
    localb.action = "";
    localb.appName = n.am(paramContext, parama.field_type);
    localb.thumburl = parama.field_thumburl;
    localb.ixg = parama.field_type;
    localb.ixh = n.c(parama);
    paramContext = k.b.a(localb, null, null);
    AppMethodBeat.o(51634);
    return paramContext;
  }
  
  public static n.a fn(String paramString, int paramInt)
  {
    AppMethodBeat.i(51635);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(51635);
      return null;
    }
    int i = n.aMS(paramString);
    if (i == 3)
    {
      paramString = n.fp(paramString, paramInt);
      AppMethodBeat.o(51635);
      return paramString;
    }
    if (i == 4)
    {
      paramString = n.aMT(paramString);
      AppMethodBeat.o(51635);
      return paramString;
    }
    AppMethodBeat.o(51635);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.r
 * JD-Core Version:    0.7.0.1
 */