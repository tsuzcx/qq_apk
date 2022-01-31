package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
{
  public static m a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(79807);
    paramContext = a(paramContext, paramString, paramInt1, paramInt2, 0, 0);
    AppMethodBeat.o(79807);
    return paramContext;
  }
  
  public static m a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(79808);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ah.getContext();
    }
    paramContext = b.a.wbT.y(localContext, paramString);
    if (paramContext != null)
    {
      paramContext.start = paramInt1;
      paramContext.end = paramInt2;
      paramContext.linkColor = paramInt3;
      paramContext.backgroundColor = paramInt4;
    }
    AppMethodBeat.o(79808);
    return paramContext;
  }
  
  public static ArrayList<m> bz(Context paramContext, String paramString)
  {
    AppMethodBeat.i(79806);
    ArrayList localArrayList = new ArrayList();
    paramString = i.a.wce.matcher(paramString);
    while (paramString.find())
    {
      int i = paramString.start();
      int j = paramString.end();
      m localm = a(paramContext, paramString.group(), i, j);
      if (localm != null) {
        localArrayList.add(localm);
      }
    }
    AppMethodBeat.o(79806);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.a
 * JD-Core Version:    0.7.0.1
 */