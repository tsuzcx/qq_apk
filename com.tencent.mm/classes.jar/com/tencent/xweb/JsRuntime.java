package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkEnvironment;

public final class JsRuntime
{
  public static JsRuntimeType Mpu;
  private static String Mpv = "";
  
  public static JsRuntimeType a(JsRuntimeType paramJsRuntimeType, String paramString, Context paramContext)
  {
    AppMethodBeat.i(156762);
    y.lx(paramContext);
    if (y.gaM().Mqa != JsRuntimeType.Mpw)
    {
      paramJsRuntimeType = y.gaM().Mqa;
      XWalkEnvironment.addXWalkInitializeLog("XWeb", "use hardcode jscore type = ".concat(String.valueOf(paramJsRuntimeType)));
      if (WebView.getCurWebType() != WebView.c.Mqv) {
        break label128;
      }
      paramString = paramJsRuntimeType;
      if (JsRuntimeType.Mpx != paramJsRuntimeType)
      {
        paramString = paramJsRuntimeType;
        if (JsRuntimeType.MpB != paramJsRuntimeType) {
          paramString = JsRuntimeType.MpE;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(156762);
      return paramString;
      if (a.bax(paramString) == JsRuntimeType.Mpw) {
        break;
      }
      paramJsRuntimeType = a.bax(paramString);
      XWalkEnvironment.addXWalkInitializeLog("XWeb", "module " + paramString + "use cmd jscore type = " + paramJsRuntimeType);
      break;
      label128:
      if (WebView.getCurWebType() == WebView.c.Mqu)
      {
        paramString = paramJsRuntimeType;
        if (JsRuntimeType.MpD != paramJsRuntimeType)
        {
          paramString = paramJsRuntimeType;
          if (JsRuntimeType.MpC != paramJsRuntimeType)
          {
            paramString = paramJsRuntimeType;
            if (JsRuntimeType.Mpx != paramJsRuntimeType) {
              paramString = JsRuntimeType.MpE;
            }
          }
        }
      }
      else
      {
        paramString = paramJsRuntimeType;
        if (WebView.getCurWebType() == WebView.c.Mqw)
        {
          paramString = paramJsRuntimeType;
          if (JsRuntimeType.Mpx != paramJsRuntimeType) {
            paramString = JsRuntimeType.MpE;
          }
        }
      }
    }
  }
  
  public static JsRuntimeType gaB()
  {
    return Mpu;
  }
  
  public static String gaC()
  {
    return Mpv;
  }
  
  public static enum JsRuntimeType
  {
    static
    {
      AppMethodBeat.i(156761);
      Mpw = new JsRuntimeType("RT_TYPE_AUTO", 0);
      Mpx = new JsRuntimeType("RT_TYPE_SYS", 1);
      Mpy = new JsRuntimeType("RT_TYPE_XWALK", 2);
      Mpz = new JsRuntimeType("RT_TYPE_WEB_X5", 3);
      MpA = new JsRuntimeType("RT_TYPE_DUMMY", 4);
      MpB = new JsRuntimeType("RT_TYPE_X5", 5);
      MpC = new JsRuntimeType("RT_TYPE_J2V8", 6);
      MpD = new JsRuntimeType("RT_TYPE_NATIVE_SCRIPT", 7);
      MpE = new JsRuntimeType("RT_TYPE_MMV8", 8);
      MpF = new JsRuntimeType[] { Mpw, Mpx, Mpy, Mpz, MpA, MpB, MpC, MpD, MpE };
      AppMethodBeat.o(156761);
    }
    
    private JsRuntimeType() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.JsRuntime
 * JD-Core Version:    0.7.0.1
 */