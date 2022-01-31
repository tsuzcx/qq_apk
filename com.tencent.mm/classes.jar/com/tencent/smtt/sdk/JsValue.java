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
  
  protected static IX5JsValue.JsValueFactory a()
  {
    AppMethodBeat.i(63932);
    a locala = new a(null);
    AppMethodBeat.o(63932);
    return locala;
  }
  
  private JsValue a(IX5JsValue paramIX5JsValue)
  {
    AppMethodBeat.i(63956);
    if (paramIX5JsValue == null)
    {
      AppMethodBeat.o(63956);
      return null;
    }
    paramIX5JsValue = new JsValue(this.a, paramIX5JsValue);
    AppMethodBeat.o(63956);
    return paramIX5JsValue;
  }
  
  public JsValue call(Object... paramVarArgs)
  {
    AppMethodBeat.i(63951);
    paramVarArgs = a(this.b.call(paramVarArgs));
    AppMethodBeat.o(63951);
    return paramVarArgs;
  }
  
  public JsValue construct(Object... paramVarArgs)
  {
    AppMethodBeat.i(63952);
    paramVarArgs = a(this.b.construct(paramVarArgs));
    AppMethodBeat.o(63952);
    return paramVarArgs;
  }
  
  public JsContext context()
  {
    return this.a;
  }
  
  public boolean isArray()
  {
    AppMethodBeat.i(63935);
    boolean bool = this.b.isArray();
    AppMethodBeat.o(63935);
    return bool;
  }
  
  public boolean isArrayBufferOrArrayBufferView()
  {
    AppMethodBeat.i(63948);
    boolean bool = this.b.isArrayBufferOrArrayBufferView();
    AppMethodBeat.o(63948);
    return bool;
  }
  
  public boolean isBoolean()
  {
    AppMethodBeat.i(63936);
    boolean bool = this.b.isBoolean();
    AppMethodBeat.o(63936);
    return bool;
  }
  
  public boolean isFunction()
  {
    AppMethodBeat.i(63950);
    boolean bool = this.b.isFunction();
    AppMethodBeat.o(63950);
    return bool;
  }
  
  public boolean isInteger()
  {
    AppMethodBeat.i(63938);
    boolean bool = this.b.isInteger();
    AppMethodBeat.o(63938);
    return bool;
  }
  
  public boolean isJavascriptInterface()
  {
    AppMethodBeat.i(63946);
    boolean bool = this.b.isJavascriptInterface();
    AppMethodBeat.o(63946);
    return bool;
  }
  
  public boolean isNull()
  {
    AppMethodBeat.i(63934);
    boolean bool = this.b.isNull();
    AppMethodBeat.o(63934);
    return bool;
  }
  
  public boolean isNumber()
  {
    AppMethodBeat.i(63940);
    boolean bool = this.b.isNumber();
    AppMethodBeat.o(63940);
    return bool;
  }
  
  public boolean isObject()
  {
    AppMethodBeat.i(63944);
    boolean bool = this.b.isObject();
    AppMethodBeat.o(63944);
    return bool;
  }
  
  public boolean isPromise()
  {
    AppMethodBeat.i(63953);
    boolean bool = this.b.isPromise();
    AppMethodBeat.o(63953);
    return bool;
  }
  
  public boolean isString()
  {
    AppMethodBeat.i(63942);
    boolean bool = this.b.isString();
    AppMethodBeat.o(63942);
    return bool;
  }
  
  public boolean isUndefined()
  {
    AppMethodBeat.i(63933);
    boolean bool = this.b.isUndefined();
    AppMethodBeat.o(63933);
    return bool;
  }
  
  public void reject(Object paramObject)
  {
    AppMethodBeat.i(63955);
    this.b.resolveOrReject(paramObject, false);
    AppMethodBeat.o(63955);
  }
  
  public void resolve(Object paramObject)
  {
    AppMethodBeat.i(63954);
    this.b.resolveOrReject(paramObject, true);
    AppMethodBeat.o(63954);
  }
  
  public boolean toBoolean()
  {
    AppMethodBeat.i(63937);
    boolean bool = this.b.toBoolean();
    AppMethodBeat.o(63937);
    return bool;
  }
  
  public ByteBuffer toByteBuffer()
  {
    AppMethodBeat.i(63949);
    ByteBuffer localByteBuffer = this.b.toByteBuffer();
    AppMethodBeat.o(63949);
    return localByteBuffer;
  }
  
  public int toInteger()
  {
    AppMethodBeat.i(63939);
    int i = this.b.toInteger();
    AppMethodBeat.o(63939);
    return i;
  }
  
  public Object toJavascriptInterface()
  {
    AppMethodBeat.i(63947);
    Object localObject = this.b.toJavascriptInterface();
    AppMethodBeat.o(63947);
    return localObject;
  }
  
  public Number toNumber()
  {
    AppMethodBeat.i(63941);
    Number localNumber = this.b.toNumber();
    AppMethodBeat.o(63941);
    return localNumber;
  }
  
  public <T> T toObject(Class<T> paramClass)
  {
    AppMethodBeat.i(63945);
    paramClass = this.b.toObject(paramClass);
    AppMethodBeat.o(63945);
    return paramClass;
  }
  
  public String toString()
  {
    AppMethodBeat.i(63943);
    String str = this.b.toString();
    AppMethodBeat.o(63943);
    return str;
  }
  
  static class a
    implements IX5JsValue.JsValueFactory
  {
    public String getJsValueClassName()
    {
      AppMethodBeat.i(63929);
      String str = JsValue.class.getName();
      AppMethodBeat.o(63929);
      return str;
    }
    
    public IX5JsValue unwrap(Object paramObject)
    {
      AppMethodBeat.i(63930);
      if ((paramObject != null) && ((paramObject instanceof JsValue)))
      {
        paramObject = JsValue.a((JsValue)paramObject);
        AppMethodBeat.o(63930);
        return paramObject;
      }
      AppMethodBeat.o(63930);
      return null;
    }
    
    public Object wrap(IX5JsValue paramIX5JsValue)
    {
      AppMethodBeat.i(63931);
      if (paramIX5JsValue != null)
      {
        JsContext localJsContext = JsContext.current();
        if (localJsContext != null)
        {
          paramIX5JsValue = new JsValue(localJsContext, paramIX5JsValue);
          AppMethodBeat.o(63931);
          return paramIX5JsValue;
        }
      }
      AppMethodBeat.o(63931);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.JsValue
 * JD-Core Version:    0.7.0.1
 */