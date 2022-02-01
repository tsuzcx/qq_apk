package com.tencent.mm.plugin.scanner.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.plugin.scanner.util.k;
import com.tencent.mm.plugin.scanner.util.k.a;
import com.tencent.mm.sdk.platformtools.bs;

public final class m
{
  public static String MO(int paramInt)
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
    localb.appId = MO(parama.field_functionType);
    localb.title = parama.field_title;
    localb.description = parama.field_source;
    localb.type = 10;
    localb.url = parama.field_shareurl;
    localb.action = "";
    localb.appName = k.ad(paramContext, parama.field_type);
    localb.thumburl = parama.field_thumburl;
    localb.hie = parama.field_type;
    localb.hif = k.c(parama);
    paramContext = k.b.a(localb, null, null);
    AppMethodBeat.o(51634);
    return paramContext;
  }
  
  public static k.a ev(String paramString, int paramInt)
  {
    AppMethodBeat.i(51635);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(51635);
      return null;
    }
    int i = k.arW(paramString);
    if (i == 3)
    {
      paramString = k.ew(paramString, paramInt);
      AppMethodBeat.o(51635);
      return paramString;
    }
    if (i == 4)
    {
      paramString = k.arX(paramString);
      AppMethodBeat.o(51635);
      return paramString;
    }
    AppMethodBeat.o(51635);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.m
 * JD-Core Version:    0.7.0.1
 */