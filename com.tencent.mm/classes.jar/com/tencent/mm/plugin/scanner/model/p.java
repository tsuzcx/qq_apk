package com.tencent.mm.plugin.scanner.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.plugin.scanner.util.k;
import com.tencent.mm.plugin.scanner.util.k.a;
import com.tencent.mm.sdk.platformtools.bu;

public final class p
{
  public static String OW(int paramInt)
  {
    if (paramInt == 4) {
      return "wxfbc915ff7c30e335";
    }
    if (paramInt == 3) {
      return "wx482a4001c37e2b74";
    }
    return "wxfbc915ff7c30e335";
  }
  
  public static String a(Context paramContext, k.a parama)
  {
    AppMethodBeat.i(51634);
    k.b localb = new k.b();
    localb.appId = OW(parama.field_functionType);
    localb.title = parama.field_title;
    localb.description = parama.field_source;
    localb.type = 10;
    localb.url = parama.field_shareurl;
    localb.action = "";
    localb.appName = k.ag(paramContext, parama.field_type);
    localb.thumburl = parama.field_thumburl;
    localb.hDb = parama.field_type;
    localb.hDc = k.c(parama);
    paramContext = k.b.a(localb, null, null);
    AppMethodBeat.o(51634);
    return paramContext;
  }
  
  public static k.a eV(String paramString, int paramInt)
  {
    AppMethodBeat.i(51635);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(51635);
      return null;
    }
    int i = k.aym(paramString);
    if (i == 3)
    {
      paramString = k.eW(paramString, paramInt);
      AppMethodBeat.o(51635);
      return paramString;
    }
    if (i == 4)
    {
      paramString = k.ayn(paramString);
      AppMethodBeat.o(51635);
      return paramString;
    }
    AppMethodBeat.o(51635);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.p
 * JD-Core Version:    0.7.0.1
 */