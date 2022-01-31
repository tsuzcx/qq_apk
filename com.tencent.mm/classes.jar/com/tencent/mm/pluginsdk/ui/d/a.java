package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
{
  public static m a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    return a(paramContext, paramString, paramInt1, paramInt2, 0, 0);
  }
  
  public static m a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ae.getContext();
    }
    paramContext = b.a.sjn.r(localContext, paramString);
    if (paramContext != null)
    {
      paramContext.start = paramInt1;
      paramContext.end = paramInt2;
      paramContext.linkColor = paramInt3;
      paramContext.backgroundColor = paramInt4;
    }
    return paramContext;
  }
  
  public static ArrayList<m> bn(Context paramContext, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = i.a.sjy.matcher(paramString);
    while (paramString.find())
    {
      int i = paramString.start();
      int j = paramString.end();
      m localm = a(paramContext, paramString.group(), i, j);
      if (localm != null) {
        localArrayList.add(localm);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.a
 * JD-Core Version:    0.7.0.1
 */