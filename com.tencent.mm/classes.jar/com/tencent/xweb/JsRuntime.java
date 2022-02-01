package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkEnvironment;

public final class JsRuntime
{
  public static JsRuntimeType Szt;
  private static String Szu = "";
  
  public static JsRuntimeType a(JsRuntimeType paramJsRuntimeType, String paramString, Context paramContext)
  {
    AppMethodBeat.i(156762);
    y.lC(paramContext);
    if (y.hsF().SzZ != JsRuntimeType.Szv)
    {
      paramJsRuntimeType = y.hsF().SzZ;
      XWalkEnvironment.addXWalkInitializeLog("XWeb", "use hardcode jscore type = ".concat(String.valueOf(paramJsRuntimeType)));
      if (WebView.getCurWebType() != WebView.c.SAu) {
        break label128;
      }
      paramString = paramJsRuntimeType;
      if (JsRuntimeType.Szw != paramJsRuntimeType)
      {
        paramString = paramJsRuntimeType;
        if (JsRuntimeType.SzA != paramJsRuntimeType) {
          paramString = JsRuntimeType.SzD;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(156762);
      return paramString;
      if (a.brF(paramString) == JsRuntimeType.Szv) {
        break;
      }
      paramJsRuntimeType = a.brF(paramString);
      XWalkEnvironment.addXWalkInitializeLog("XWeb", "module " + paramString + "use cmd jscore type = " + paramJsRuntimeType);
      break;
      label128:
      if (WebView.getCurWebType() == WebView.c.SAt)
      {
        paramString = paramJsRuntimeType;
        if (JsRuntimeType.SzC != paramJsRuntimeType)
        {
          paramString = paramJsRuntimeType;
          if (JsRuntimeType.SzB != paramJsRuntimeType)
          {
            paramString = paramJsRuntimeType;
            if (JsRuntimeType.Szw != paramJsRuntimeType) {
              paramString = JsRuntimeType.SzD;
            }
          }
        }
      }
      else
      {
        paramString = paramJsRuntimeType;
        if (WebView.getCurWebType() == WebView.c.SAv)
        {
          paramString = paramJsRuntimeType;
          if (JsRuntimeType.Szw != paramJsRuntimeType) {
            paramString = JsRuntimeType.SzD;
          }
        }
      }
    }
  }
  
  public static JsRuntimeType hsu()
  {
    return Szt;
  }
  
  public static String hsv()
  {
    return Szu;
  }
  
  public static enum JsRuntimeType
  {
    static
    {
      AppMethodBeat.i(156761);
      Szv = new JsRuntimeType("RT_TYPE_AUTO", 0);
      Szw = new JsRuntimeType("RT_TYPE_SYS", 1);
      Szx = new JsRuntimeType("RT_TYPE_XWALK", 2);
      Szy = new JsRuntimeType("RT_TYPE_WEB_X5", 3);
      Szz = new JsRuntimeType("RT_TYPE_DUMMY", 4);
      SzA = new JsRuntimeType("RT_TYPE_X5", 5);
      SzB = new JsRuntimeType("RT_TYPE_J2V8", 6);
      SzC = new JsRuntimeType("RT_TYPE_NATIVE_SCRIPT", 7);
      SzD = new JsRuntimeType("RT_TYPE_MMV8", 8);
      SzE = new JsRuntimeType[] { Szv, Szw, Szx, Szy, Szz, SzA, SzB, SzC, SzD };
      AppMethodBeat.o(156761);
    }
    
    private JsRuntimeType() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.JsRuntime
 * JD-Core Version:    0.7.0.1
 */