package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkEnvironment;

public final class JsRuntime
{
  public static JsRuntimeType KyZ;
  private static String Kza = "";
  
  public static JsRuntimeType a(JsRuntimeType paramJsRuntimeType, String paramString, Context paramContext)
  {
    AppMethodBeat.i(156762);
    y.lk(paramContext);
    if (y.fJs().KzF != JsRuntimeType.Kzb)
    {
      paramJsRuntimeType = y.fJs().KzF;
      XWalkEnvironment.addXWalkInitializeLog("XWeb", "use hardcode jscore type = ".concat(String.valueOf(paramJsRuntimeType)));
      if (WebView.getCurWebType() != WebView.c.KAa) {
        break label128;
      }
      paramString = paramJsRuntimeType;
      if (JsRuntimeType.Kzc != paramJsRuntimeType)
      {
        paramString = paramJsRuntimeType;
        if (JsRuntimeType.Kzg != paramJsRuntimeType) {
          paramString = JsRuntimeType.Kzj;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(156762);
      return paramString;
      if (a.aUu(paramString) == JsRuntimeType.Kzb) {
        break;
      }
      paramJsRuntimeType = a.aUu(paramString);
      XWalkEnvironment.addXWalkInitializeLog("XWeb", "module " + paramString + "use cmd jscore type = " + paramJsRuntimeType);
      break;
      label128:
      if (WebView.getCurWebType() == WebView.c.KzZ)
      {
        paramString = paramJsRuntimeType;
        if (JsRuntimeType.Kzi != paramJsRuntimeType)
        {
          paramString = paramJsRuntimeType;
          if (JsRuntimeType.Kzh != paramJsRuntimeType)
          {
            paramString = paramJsRuntimeType;
            if (JsRuntimeType.Kzc != paramJsRuntimeType) {
              paramString = JsRuntimeType.Kzj;
            }
          }
        }
      }
      else
      {
        paramString = paramJsRuntimeType;
        if (WebView.getCurWebType() == WebView.c.KAb)
        {
          paramString = paramJsRuntimeType;
          if (JsRuntimeType.Kzc != paramJsRuntimeType) {
            paramString = JsRuntimeType.Kzj;
          }
        }
      }
    }
  }
  
  public static JsRuntimeType fJf()
  {
    return KyZ;
  }
  
  public static String fJg()
  {
    return Kza;
  }
  
  public static enum JsRuntimeType
  {
    static
    {
      AppMethodBeat.i(156761);
      Kzb = new JsRuntimeType("RT_TYPE_AUTO", 0);
      Kzc = new JsRuntimeType("RT_TYPE_SYS", 1);
      Kzd = new JsRuntimeType("RT_TYPE_XWALK", 2);
      Kze = new JsRuntimeType("RT_TYPE_WEB_X5", 3);
      Kzf = new JsRuntimeType("RT_TYPE_DUMMY", 4);
      Kzg = new JsRuntimeType("RT_TYPE_X5", 5);
      Kzh = new JsRuntimeType("RT_TYPE_J2V8", 6);
      Kzi = new JsRuntimeType("RT_TYPE_NATIVE_SCRIPT", 7);
      Kzj = new JsRuntimeType("RT_TYPE_MMV8", 8);
      Kzk = new JsRuntimeType[] { Kzb, Kzc, Kzd, Kze, Kzf, Kzg, Kzh, Kzi, Kzj };
      AppMethodBeat.o(156761);
    }
    
    private JsRuntimeType() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.JsRuntime
 * JD-Core Version:    0.7.0.1
 */