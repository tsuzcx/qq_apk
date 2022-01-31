package com.tencent.xweb;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.c.l;
import com.tencent.xweb.c.l.a;
import com.tencent.xweb.xwalk.b;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class ab
{
  static b BEK;
  
  public static void a(b paramb)
  {
    try
    {
      BEK = paramb;
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  public static void clearAllWebViewCache(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(3957);
    Context localContext = paramContext;
    if (paramContext == null) {}
    try
    {
      localContext = XWalkEnvironment.getApplicationContext();
      if (localContext == null)
      {
        AppMethodBeat.o(3957);
        return;
      }
      l.e(WebView.getCurWebType()).clearAllWebViewCache(localContext, paramBoolean);
      AppMethodBeat.o(3957);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("XWebSdk", "clearAllWebViewCache failed: " + paramContext.getMessage());
      AppMethodBeat.o(3957);
    }
  }
  
  public static b dYE()
  {
    try
    {
      b localb = BEK;
      return localb;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void setSharedPreferenceProvider(h paramh)
  {
    try
    {
      AppMethodBeat.i(3958);
      XWalkEnvironment.setSharedPreferenceProvider(paramh);
      AppMethodBeat.o(3958);
      return;
    }
    finally
    {
      paramh = finally;
      throw paramh;
    }
  }
  
  public static ab.a v(String paramString, Object paramObject)
  {
    int i = 0;
    AppMethodBeat.i(151440);
    ab.a locala = new ab.a();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!(paramObject instanceof Bundle))
    {
      localObject1 = localObject2;
      if ((paramObject instanceof HashMap)) {
        localObject1 = (HashMap)paramObject;
      }
    }
    switch (paramString.hashCode())
    {
    default: 
      i = -1;
      switch (i)
      {
      default: 
        label78:
        locala.errorCode = -1;
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(151440);
      return locala;
      if (!paramString.equals("SET_INIT_ARG")) {
        break;
      }
      break label78;
      if (!paramString.equals("BASE_CONTEXT_CHANGED")) {
        break;
      }
      i = 1;
      break label78;
      XWalkEnvironment.setXWebInitArgs((HashMap)localObject1);
      continue;
      try
      {
        paramString = l.e(WebView.d.BEq);
        if (paramString != null)
        {
          paramString.excute("BASE_CONTEXT_CHANGED", new Object[] { paramObject });
          locala.errorCode = 0;
        }
      }
      catch (Exception paramString)
      {
        Log.e("XWebSdk", "excute context changed failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.ab
 * JD-Core Version:    0.7.0.1
 */