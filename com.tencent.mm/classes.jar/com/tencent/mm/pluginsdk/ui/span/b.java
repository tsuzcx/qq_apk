package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b
{
  public static u a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(152261);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = MMApplicationContext.getContext();
    }
    paramContext = d.a.YnY.C(localContext, paramString);
    if (paramContext != null)
    {
      paramContext.start = paramInt1;
      paramContext.end = paramInt2;
      paramContext.linkColor = paramInt3;
      paramContext.backgroundColor = paramInt4;
    }
    AppMethodBeat.o(152261);
    return paramContext;
  }
  
  public static u c(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152260);
    paramContext = a(paramContext, paramString, paramInt1, paramInt2, 0, 0);
    AppMethodBeat.o(152260);
    return paramContext;
  }
  
  public static ArrayList<u> cK(Context paramContext, String paramString)
  {
    AppMethodBeat.i(152259);
    ArrayList localArrayList = new ArrayList();
    paramString = o.a.Yoo.matcher(paramString);
    while (paramString.find())
    {
      int i = paramString.start();
      int j = paramString.end();
      u localu = c(paramContext, paramString.group(), i, j);
      if (localu != null) {
        localArrayList.add(localu);
      }
    }
    AppMethodBeat.o(152259);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.b
 * JD-Core Version:    0.7.0.1
 */