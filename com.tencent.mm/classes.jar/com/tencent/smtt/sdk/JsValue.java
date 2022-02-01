package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue.JsValueFactory;
import java.nio.ByteBuffer;

public class JsValue
{
  private final JsContext a;
  private final IX5JsValue b;
  
  protected JsValue(JsContext paramJsContext, IX5JsValue paramIX5JsValue)
  {
    this.a = paramJsContext;
    this.b = paramIX5JsValue;
  }
  
  private JsValue a(IX5JsValue paramIX5JsValue)
  {
    AppMethodBeat.i(55317);
    if (paramIX5JsValue == null)
    {
      AppMethodBeat.o(55317);
      return null;
    }
    paramIX5JsValue = new JsValue(this.a, paramIX5JsValue);
    AppMethodBeat.o(55317);
    return paramIX5JsValue;
  }
  
  public static IX5JsValue.JsValueFactory factory()
  {
    AppMethodBeat.i(55293);
    a locala = new a(null);
    AppMethodBeat.o(55293);
    return locala;
  }
  
  public JsValue call(Object... paramVarArgs)
  {
    AppMethodBeat.i(55312);
    paramVarArgs = a(this.b.call(paramVarArgs));
    AppMethodBeat.o(55312);
    return paramVarArgs;
  }
  
  public JsValue construct(Object... paramVarArgs)
  {
    AppMethodBeat.i(55313);
    paramVarArgs = a(this.b.construct(paramVarArgs));
    AppMethodBeat.o(55313);
    return paramVarArgs;
  }
  
  public JsContext context()
  {
    return this.a;
  }
  
  public boolean isArray()
  {
    AppMethodBeat.i(55296);
    boolean bool = this.b.isArray();
    AppMethodBeat.o(55296);
    return bool;
  }
  
  public boolean isArrayBufferOrArrayBufferView()
  {
    AppMethodBeat.i(55309);
    boolean bool = this.b.isArrayBufferOrArrayBufferView();
    AppMethodBeat.o(55309);
    return bool;
  }
  
  public boolean isBoolean()
  {
    AppMethodBeat.i(55297);
    boolean bool = this.b.isBoolean();
    AppMethodBeat.o(55297);
    return bool;
  }
  
  public boolean isFunction()
  {
    AppMethodBeat.i(55311);
    boolean bool = this.b.isFunction();
    AppMethodBeat.o(55311);
    return bool;
  }
  
  public boolean isInteger()
  {
    AppMethodBeat.i(55299);
    boolean bool = this.b.isInteger();
    AppMethodBeat.o(55299);
    return bool;
  }
  
  public boolean isJavascriptInterface()
  {
    AppMethodBeat.i(55307);
    boolean bool = this.b.isJavascriptInterface();
    AppMethodBeat.o(55307);
    return bool;
  }
  
  public boolean isNull()
  {
    AppMethodBeat.i(55295);
    boolean bool = this.b.isNull();
    AppMethodBeat.o(55295);
    return bool;
  }
  
  public boolean isNumber()
  {
    AppMethodBeat.i(55301);
    boolean bool = this.b.isNumber();
    AppMethodBeat.o(55301);
    return bool;
  }
  
  public boolean isObject()
  {
    AppMethodBeat.i(55305);
    boolean bool = this.b.isObject();
    AppMethodBeat.o(55305);
    return bool;
  }
  
  public boolean isPromise()
  {
    AppMethodBeat.i(55314);
    boolean bool = this.b.isPromise();
    AppMethodBeat.o(55314);
    return bool;
  }
  
  public boolean isString()
  {
    AppMethodBeat.i(55303);
    boolean bool = this.b.isString();
    AppMethodBeat.o(55303);
    return bool;
  }
  
  public boolean isUndefined()
  {
    AppMethodBeat.i(55294);
    boolean bool = this.b.isUndefined();
    AppMethodBeat.o(55294);
    return bool;
  }
  
  public void reject(Object paramObject)
  {
    AppMethodBeat.i(55316);
    this.b.resolveOrReject(paramObject, false);
    AppMethodBeat.o(55316);
  }
  
  public void resolve(Object paramObject)
  {
    AppMethodBeat.i(55315);
    this.b.resolveOrReject(paramObject, true);
    AppMethodBeat.o(55315);
  }
  
  public boolean toBoolean()
  {
    AppMethodBeat.i(55298);
    boolean bool = this.b.toBoolean();
    AppMethodBeat.o(55298);
    return bool;
  }
  
  public ByteBuffer toByteBuffer()
  {
    AppMethodBeat.i(55310);
    ByteBuffer localByteBuffer = this.b.toByteBuffer();
    AppMethodBeat.o(55310);
    return localByteBuffer;
  }
  
  public int toInteger()
  {
    AppMethodBeat.i(55300);
    int i = this.b.toInteger();
    AppMethodBeat.o(55300);
    return i;
  }
  
  public Object toJavascriptInterface()
  {
    AppMethodBeat.i(55308);
    Object localObject = this.b.toJavascriptInterface();
    AppMethodBeat.o(55308);
    return localObject;
  }
  
  public Number toNumber()
  {
    AppMethodBeat.i(55302);
    Number localNumber = this.b.toNumber();
    AppMethodBeat.o(55302);
    return localNumber;
  }
  
  public <T> T toObject(Class<T> paramClass)
  {
    AppMethodBeat.i(55306);
    paramClass = this.b.toObject(paramClass);
    AppMethodBeat.o(55306);
    return paramClass;
  }
  
  public String toString()
  {
    AppMethodBeat.i(55304);
    String str = this.b.toString();
    AppMethodBeat.o(55304);
    return str;
  }
  
  static class a
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.smtt.sdk.JsValue
 * JD-Core Version:    0.7.0.1
 */