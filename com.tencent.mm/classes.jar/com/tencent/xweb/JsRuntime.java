package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkEnvironment;

public final class JsRuntime
{
  public static JsRuntimeType MMy;
  private static String MMz = "";
  
  public static JsRuntimeType a(JsRuntimeType paramJsRuntimeType, String paramString, Context paramContext)
  {
    AppMethodBeat.i(156762);
    y.lD(paramContext);
    if (y.gfo().MNe != JsRuntimeType.MMA)
    {
      paramJsRuntimeType = y.gfo().MNe;
      XWalkEnvironment.addXWalkInitializeLog("XWeb", "use hardcode jscore type = ".concat(String.valueOf(paramJsRuntimeType)));
      if (WebView.getCurWebType() != WebView.c.MNz) {
        break label128;
      }
      paramString = paramJsRuntimeType;
      if (JsRuntimeType.MMB != paramJsRuntimeType)
      {
        paramString = paramJsRuntimeType;
        if (JsRuntimeType.MMF != paramJsRuntimeType) {
          paramString = JsRuntimeType.MMI;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(156762);
      return paramString;
      if (a.bca(paramString) == JsRuntimeType.MMA) {
        break;
      }
      paramJsRuntimeType = a.bca(paramString);
      XWalkEnvironment.addXWalkInitializeLog("XWeb", "module " + paramString + "use cmd jscore type = " + paramJsRuntimeType);
      break;
      label128:
      if (WebView.getCurWebType() == WebView.c.MNy)
      {
        paramString = paramJsRuntimeType;
        if (JsRuntimeType.MMH != paramJsRuntimeType)
        {
          paramString = paramJsRuntimeType;
          if (JsRuntimeType.MMG != paramJsRuntimeType)
          {
            paramString = paramJsRuntimeType;
            if (JsRuntimeType.MMB != paramJsRuntimeType) {
              paramString = JsRuntimeType.MMI;
            }
          }
        }
      }
      else
      {
        paramString = paramJsRuntimeType;
        if (WebView.getCurWebType() == WebView.c.MNA)
        {
          paramString = paramJsRuntimeType;
          if (JsRuntimeType.MMB != paramJsRuntimeType) {
            paramString = JsRuntimeType.MMI;
          }
        }
      }
    }
  }
  
  public static JsRuntimeType gfd()
  {
    return MMy;
  }
  
  public static String gfe()
  {
    return MMz;
  }
  
  public static enum JsRuntimeType
  {
    static
    {
      AppMethodBeat.i(156761);
      MMA = new JsRuntimeType("RT_TYPE_AUTO", 0);
      MMB = new JsRuntimeType("RT_TYPE_SYS", 1);
      MMC = new JsRuntimeType("RT_TYPE_XWALK", 2);
      MMD = new JsRuntimeType("RT_TYPE_WEB_X5", 3);
      MME = new JsRuntimeType("RT_TYPE_DUMMY", 4);
      MMF = new JsRuntimeType("RT_TYPE_X5", 5);
      MMG = new JsRuntimeType("RT_TYPE_J2V8", 6);
      MMH = new JsRuntimeType("RT_TYPE_NATIVE_SCRIPT", 7);
      MMI = new JsRuntimeType("RT_TYPE_MMV8", 8);
      MMJ = new JsRuntimeType[] { MMA, MMB, MMC, MMD, MME, MMF, MMG, MMH, MMI };
      AppMethodBeat.o(156761);
    }
    
    private JsRuntimeType() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.JsRuntime
 * JD-Core Version:    0.7.0.1
 */