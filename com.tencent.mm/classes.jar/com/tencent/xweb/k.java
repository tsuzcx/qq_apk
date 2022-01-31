package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkEnvironment;

public final class k
{
  public static a BDm;
  private static String BDn = "";
  
  public static a a(a parama, String paramString, Context paramContext)
  {
    AppMethodBeat.i(3811);
    q.jS(paramContext);
    if (q.dYn().BDQ != a.BDo)
    {
      parama = q.dYn().BDQ;
      XWalkEnvironment.addXWalkInitializeLog("XWeb", "use hardcode jscore type = ".concat(String.valueOf(parama)));
      if (WebView.getCurWebType() != WebView.d.BEr) {
        break label130;
      }
      paramString = parama;
      if (a.BDp != parama)
      {
        paramString = parama;
        if (a.BDt != parama) {
          paramString = a.BDw;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(3811);
      return paramString;
      if (a.axI(paramString) == a.BDo) {
        break;
      }
      parama = a.axI(paramString);
      XWalkEnvironment.addXWalkInitializeLog("XWeb", "module " + paramString + "use cmd jscore type = " + parama);
      break;
      label130:
      if (WebView.getCurWebType() == WebView.d.BEq)
      {
        paramString = parama;
        if (a.BDv != parama)
        {
          paramString = parama;
          if (a.BDu != parama)
          {
            paramString = parama;
            if (a.BDp != parama) {
              paramString = a.BDw;
            }
          }
        }
      }
      else
      {
        paramString = parama;
        if (WebView.getCurWebType() == WebView.d.BEs)
        {
          paramString = parama;
          if (a.BDp != parama) {
            paramString = a.BDw;
          }
        }
      }
    }
  }
  
  public static a dYj()
  {
    return BDm;
  }
  
  public static String dYk()
  {
    return BDn;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(3810);
      BDo = new a("RT_TYPE_AUTO", 0);
      BDp = new a("RT_TYPE_SYS", 1);
      BDq = new a("RT_TYPE_XWALK", 2);
      BDr = new a("RT_TYPE_WEB_X5", 3);
      BDs = new a("RT_TYPE_DUMMY", 4);
      BDt = new a("RT_TYPE_X5", 5);
      BDu = new a("RT_TYPE_J2V8", 6);
      BDv = new a("RT_TYPE_NATIVE_SCRIPT", 7);
      BDw = new a("RT_TYPE_MMV8", 8);
      BDx = new a[] { BDo, BDp, BDq, BDr, BDs, BDt, BDu, BDv, BDw };
      AppMethodBeat.o(3810);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.k
 * JD-Core Version:    0.7.0.1
 */