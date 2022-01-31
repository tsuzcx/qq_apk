package com.tencent.mm.plugin.scanner.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.plugin.scanner.util.q;
import com.tencent.mm.plugin.scanner.util.q.a;
import com.tencent.mm.sdk.platformtools.bo;

public final class k
{
  public static String CD(int paramInt)
  {
    if (paramInt == 4) {
      return "wxfbc915ff7c30e335";
    }
    if (paramInt == 3) {
      return "wx482a4001c37e2b74";
    }
    return "wxfbc915ff7c30e335";
  }
  
  public static String a(Context paramContext, q.a parama)
  {
    AppMethodBeat.i(80853);
    j.b localb = new j.b();
    localb.appId = CD(parama.field_functionType);
    localb.title = parama.field_title;
    localb.description = parama.field_source;
    localb.type = 10;
    localb.url = parama.field_shareurl;
    localb.action = "";
    localb.appName = q.V(paramContext, parama.field_type);
    localb.thumburl = parama.field_thumburl;
    localb.fgX = parama.field_type;
    localb.fgY = q.c(parama);
    paramContext = j.b.a(localb, null, null);
    AppMethodBeat.o(80853);
    return paramContext;
  }
  
  public static q.a dg(String paramString, int paramInt)
  {
    AppMethodBeat.i(80854);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80854);
      return null;
    }
    int i = q.YK(paramString);
    if (i == 3)
    {
      paramString = q.dh(paramString, paramInt);
      AppMethodBeat.o(80854);
      return paramString;
    }
    if (i == 4)
    {
      paramString = q.YN(paramString);
      AppMethodBeat.o(80854);
      return paramString;
    }
    AppMethodBeat.o(80854);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.k
 * JD-Core Version:    0.7.0.1
 */