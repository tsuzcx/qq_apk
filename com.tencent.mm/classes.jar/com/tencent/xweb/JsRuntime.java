package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkEnvironment;

public final class JsRuntime
{
  public static JsRuntimeType IMB;
  private static String IMC = "";
  
  public static JsRuntimeType a(JsRuntimeType paramJsRuntimeType, String paramString, Context paramContext)
  {
    AppMethodBeat.i(156762);
    x.kW(paramContext);
    if (x.fqR().INh != JsRuntimeType.IMD)
    {
      paramJsRuntimeType = x.fqR().INh;
      XWalkEnvironment.addXWalkInitializeLog("XWeb", "use hardcode jscore type = ".concat(String.valueOf(paramJsRuntimeType)));
      if (WebView.getCurWebType() != WebView.c.IND) {
        break label128;
      }
      paramString = paramJsRuntimeType;
      if (JsRuntimeType.IME != paramJsRuntimeType)
      {
        paramString = paramJsRuntimeType;
        if (JsRuntimeType.IMI != paramJsRuntimeType) {
          paramString = JsRuntimeType.IML;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(156762);
      return paramString;
      if (a.aOI(paramString) == JsRuntimeType.IMD) {
        break;
      }
      paramJsRuntimeType = a.aOI(paramString);
      XWalkEnvironment.addXWalkInitializeLog("XWeb", "module " + paramString + "use cmd jscore type = " + paramJsRuntimeType);
      break;
      label128:
      if (WebView.getCurWebType() == WebView.c.INC)
      {
        paramString = paramJsRuntimeType;
        if (JsRuntimeType.IMK != paramJsRuntimeType)
        {
          paramString = paramJsRuntimeType;
          if (JsRuntimeType.IMJ != paramJsRuntimeType)
          {
            paramString = paramJsRuntimeType;
            if (JsRuntimeType.IME != paramJsRuntimeType) {
              paramString = JsRuntimeType.IML;
            }
          }
        }
      }
      else
      {
        paramString = paramJsRuntimeType;
        if (WebView.getCurWebType() == WebView.c.INE)
        {
          paramString = paramJsRuntimeType;
          if (JsRuntimeType.IME != paramJsRuntimeType) {
            paramString = JsRuntimeType.IML;
          }
        }
      }
    }
  }
  
  public static JsRuntimeType fqF()
  {
    return IMB;
  }
  
  public static String fqG()
  {
    return IMC;
  }
  
  public static enum JsRuntimeType
  {
    static
    {
      AppMethodBeat.i(156761);
      IMD = new JsRuntimeType("RT_TYPE_AUTO", 0);
      IME = new JsRuntimeType("RT_TYPE_SYS", 1);
      IMF = new JsRuntimeType("RT_TYPE_XWALK", 2);
      IMG = new JsRuntimeType("RT_TYPE_WEB_X5", 3);
      IMH = new JsRuntimeType("RT_TYPE_DUMMY", 4);
      IMI = new JsRuntimeType("RT_TYPE_X5", 5);
      IMJ = new JsRuntimeType("RT_TYPE_J2V8", 6);
      IMK = new JsRuntimeType("RT_TYPE_NATIVE_SCRIPT", 7);
      IML = new JsRuntimeType("RT_TYPE_MMV8", 8);
      IMM = new JsRuntimeType[] { IMD, IME, IMF, IMG, IMH, IMI, IMJ, IMK, IML };
      AppMethodBeat.o(156761);
    }
    
    private JsRuntimeType() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.JsRuntime
 * JD-Core Version:    0.7.0.1
 */