package com.tencent.xweb;

import android.content.Context;
import android.os.Bundle;
import com.tencent.xweb.c.j;
import com.tencent.xweb.c.j.a;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class s
{
  public static void clearAllWebViewCache(Context paramContext, boolean paramBoolean)
  {
    Context localContext = paramContext;
    if (paramContext == null) {}
    while (localContext != null)
    {
      try
      {
        localContext = XWalkEnvironment.getApplicationContext();
      }
      catch (Exception paramContext)
      {
        Log.e("XWebSdk", "clearAllWebViewCache failed: " + paramContext.getMessage());
        return;
      }
      j.c(WebView.getCurWebType()).clearAllWebViewCache(localContext, paramBoolean);
      return;
    }
  }
  
  public static s.a q(String paramString, Object paramObject)
  {
    int i = 0;
    s.a locala = new s.a();
    if ((!(paramObject instanceof Bundle)) && ((paramObject instanceof HashMap))) {}
    for (HashMap localHashMap = (HashMap)paramObject;; localHashMap = null)
    {
      switch (paramString.hashCode())
      {
      default: 
        i = -1;
        switch (i)
        {
        default: 
          label62:
          locala.errorCode = -1;
        }
        break;
      }
      label200:
      for (;;)
      {
        return locala;
        if (!paramString.equals("SET_INIT_ARG")) {
          break;
        }
        break label62;
        if (!paramString.equals("BASE_CONTEXT_CHANGED")) {
          break;
        }
        i = 1;
        break label62;
        XWalkEnvironment.setXWebInitArgs(localHashMap);
        return locala;
        locala.errorCode = -2;
        if ((paramObject instanceof Context)) {}
        for (paramString = (Context)paramObject;; paramString = null) {
          for (;;)
          {
            if (paramString == null) {
              break label200;
            }
            try
            {
              paramObject = j.c(WebView.d.xho);
              if (paramObject == null) {
                break;
              }
              paramObject.excute("BASE_CONTEXT_CHANGED", new Object[] { paramString });
              locala.errorCode = 0;
              return locala;
            }
            catch (Exception paramString)
            {
              Log.e("XWebSdk", "excute context changed failed");
              return locala;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.s
 * JD-Core Version:    0.7.0.1
 */