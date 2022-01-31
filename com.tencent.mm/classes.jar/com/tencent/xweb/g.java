package com.tencent.xweb;

import android.content.Context;
import com.tencent.xweb.c.d;
import com.tencent.xweb.c.j;
import com.tencent.xweb.c.j.a;
import com.tencent.xweb.xwalk.b;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class g
{
  public static g.a xgt;
  private static String xgv = "";
  public volatile boolean gIx = false;
  public com.tencent.xweb.c.g xgu;
  
  private g(g.a parama, String paramString, Context paramContext)
  {
    paramString = b(parama, paramString, paramContext);
    switch (1.gXB[paramString.ordinal()])
    {
    default: 
      if (this.xgu == null) {
        if ((g.a.xgx == paramString) || (g.a.xgB == paramString))
        {
          parama = g.a.xgA;
          this.xgu = new d();
        }
      }
      break;
    }
    for (;;)
    {
      xgt = parama;
      Log.d("JsRuntime", "xxx IJsRuntime  request=" + parama.toString() + ", create=" + xgv);
      return;
      this.xgu = j.c(WebView.d.xhp).getJsCore(paramString, paramContext);
      if (this.xgu == null) {
        break;
      }
      xgv = "x5";
      break;
      this.xgu = j.c(WebView.d.xho).getJsCore(paramString, paramContext);
      if (this.xgu == null) {
        break;
      }
      if (paramString == g.a.xgC) {}
      for (parama = "j2v8";; parama = "nativeScript")
      {
        xgv = parama;
        break;
      }
      this.xgu = new b();
      this.xgu.init(0);
      xgv = "mmv8";
      break;
      parama = g.a.xgE;
      this.xgu = new b();
      this.xgu.init(0);
      xgv = "mmv8";
      continue;
      parama = paramString;
    }
  }
  
  public static g a(g.a parama, String paramString, Context paramContext)
  {
    return new g(parama, paramString, paramContext);
  }
  
  public static g.a b(g.a parama, String paramString, Context paramContext)
  {
    k.im(paramContext);
    paramContext = paramString;
    if (paramString == null) {
      paramContext = "";
    }
    if (k.cSk().xgS != g.a.xgw)
    {
      parama = k.cSk().xgS;
      XWalkEnvironment.addXWalkInitializeLog("XWeb", "use hardcode jscore type = " + parama);
      if (WebView.getCurWebType() != WebView.d.xhp) {
        break label134;
      }
      paramString = parama;
      if (g.a.xgx != parama)
      {
        paramString = parama;
        if (g.a.xgE != parama) {
          paramString = g.a.xgB;
        }
      }
    }
    label134:
    label174:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return paramString;
              if (a.agM(paramContext) == g.a.xgw) {
                break;
              }
              parama = a.agM(paramContext);
              XWalkEnvironment.addXWalkInitializeLog("XWeb", "module " + paramContext + "use cmd jscore type = " + parama);
              break;
              if (WebView.getCurWebType() != WebView.d.xho) {
                break label174;
              }
              paramString = parama;
            } while (g.a.xgD == parama);
            paramString = parama;
          } while (g.a.xgC == parama);
          paramString = parama;
        } while (g.a.xgx == parama);
        return g.a.xgE;
        paramString = parama;
      } while (WebView.getCurWebType() != WebView.d.xhq);
      paramString = parama;
    } while (g.a.xgx == parama);
    return g.a.xgE;
  }
  
  public static g.a cSh()
  {
    return xgt;
  }
  
  public static String cSi()
  {
    return xgv;
  }
  
  public final void addJavascriptInterface(Object paramObject, String paramString)
  {
    this.xgu.addJavascriptInterface(paramObject, paramString);
  }
  
  public final boolean cSj()
  {
    return this.xgu.cSj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.g
 * JD-Core Version:    0.7.0.1
 */