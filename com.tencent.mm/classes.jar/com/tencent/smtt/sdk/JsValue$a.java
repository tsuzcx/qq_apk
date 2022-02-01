package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue.JsValueFactory;

class JsValue$a
  implements IX5JsValue.JsValueFactory
{
  public String getJsValueClassName()
  {
    AppMethodBeat.i(54153);
    String str = JsValue.class.getName();
    AppMethodBeat.o(54153);
    return str;
  }
  
  public IX5JsValue unwrap(Object paramObject)
  {
    AppMethodBeat.i(54154);
    if ((paramObject != null) && ((paramObject instanceof JsValue)))
    {
      paramObject = JsValue.a((JsValue)paramObject);
      AppMethodBeat.o(54154);
      return paramObject;
    }
    AppMethodBeat.o(54154);
    return null;
  }
  
  public Object wrap(IX5JsValue paramIX5JsValue)
  {
    AppMethodBeat.i(54155);
    if (paramIX5JsValue != null)
    {
      JsContext localJsContext = JsContext.current();
      if (localJsContext != null)
      {
        paramIX5JsValue = new JsValue(localJsContext, paramIX5JsValue);
        AppMethodBeat.o(54155);
        return paramIX5JsValue;
      }
    }
    AppMethodBeat.o(54155);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.JsValue.a
 * JD-Core Version:    0.7.0.1
 */