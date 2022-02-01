package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkEnvironment;

public final class JsRuntime
{
  public static JsRuntimeType aaak;
  private static String aaal = "";
  
  public static JsRuntimeType a(JsRuntimeType paramJsRuntimeType, String paramString, Context paramContext)
  {
    AppMethodBeat.i(156762);
    y.mA(paramContext);
    if (y.iwp().aaaQ != JsRuntimeType.aaam)
    {
      paramJsRuntimeType = y.iwp().aaaQ;
      XWalkEnvironment.addXWalkInitializeLog("XWeb", "use hardcode jscore type = ".concat(String.valueOf(paramJsRuntimeType)));
      if (WebView.getCurWebType() != WebView.c.aabn) {
        break label128;
      }
      paramString = paramJsRuntimeType;
      if (JsRuntimeType.aaan != paramJsRuntimeType)
      {
        paramString = paramJsRuntimeType;
        if (JsRuntimeType.aaar != paramJsRuntimeType) {
          paramString = JsRuntimeType.aaau;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(156762);
      return paramString;
      if (a.bED(paramString) == JsRuntimeType.aaam) {
        break;
      }
      paramJsRuntimeType = a.bED(paramString);
      XWalkEnvironment.addXWalkInitializeLog("XWeb", "module " + paramString + "use cmd jscore type = " + paramJsRuntimeType);
      break;
      label128:
      if (WebView.getCurWebType() == WebView.c.aabm)
      {
        paramString = paramJsRuntimeType;
        if (JsRuntimeType.aaat != paramJsRuntimeType)
        {
          paramString = paramJsRuntimeType;
          if (JsRuntimeType.aaas != paramJsRuntimeType)
          {
            paramString = paramJsRuntimeType;
            if (JsRuntimeType.aaan != paramJsRuntimeType) {
              paramString = JsRuntimeType.aaau;
            }
          }
        }
      }
      else
      {
        paramString = paramJsRuntimeType;
        if (WebView.getCurWebType() == WebView.c.aabo)
        {
          paramString = paramJsRuntimeType;
          if (JsRuntimeType.aaan != paramJsRuntimeType) {
            paramString = JsRuntimeType.aaau;
          }
        }
      }
    }
  }
  
  public static JsRuntimeType iwc()
  {
    return aaak;
  }
  
  public static String iwd()
  {
    return aaal;
  }
  
  public static enum JsRuntimeType
  {
    static
    {
      AppMethodBeat.i(156761);
      aaam = new JsRuntimeType("RT_TYPE_AUTO", 0);
      aaan = new JsRuntimeType("RT_TYPE_SYS", 1);
      aaao = new JsRuntimeType("RT_TYPE_XWALK", 2);
      aaap = new JsRuntimeType("RT_TYPE_WEB_X5", 3);
      aaaq = new JsRuntimeType("RT_TYPE_DUMMY", 4);
      aaar = new JsRuntimeType("RT_TYPE_X5", 5);
      aaas = new JsRuntimeType("RT_TYPE_J2V8", 6);
      aaat = new JsRuntimeType("RT_TYPE_NATIVE_SCRIPT", 7);
      aaau = new JsRuntimeType("RT_TYPE_MMV8", 8);
      aaav = new JsRuntimeType[] { aaam, aaan, aaao, aaap, aaaq, aaar, aaas, aaat, aaau };
      AppMethodBeat.o(156761);
    }
    
    private JsRuntimeType() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.JsRuntime
 * JD-Core Version:    0.7.0.1
 */