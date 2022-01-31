package com.tencent.tmassistantsdk.protocol.jce;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class ResponseHeadErrorCode
  implements Serializable
{
  public static final ResponseHeadErrorCode EC_BUSINESS_ERROR;
  public static final ResponseHeadErrorCode EC_SERVER_INTERNAL_ERROR;
  public static final int _EC_BUSINESS_ERROR = -11;
  public static final int _EC_SERVER_INTERNAL_ERROR = -10;
  private static ResponseHeadErrorCode[] __values;
  private String __T;
  private int __value;
  
  static
  {
    AppMethodBeat.i(76117);
    if (!ResponseHeadErrorCode.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      __values = new ResponseHeadErrorCode[2];
      EC_SERVER_INTERNAL_ERROR = new ResponseHeadErrorCode(0, -10, "EC_SERVER_INTERNAL_ERROR");
      EC_BUSINESS_ERROR = new ResponseHeadErrorCode(1, -11, "EC_BUSINESS_ERROR");
      AppMethodBeat.o(76117);
      return;
    }
  }
  
  private ResponseHeadErrorCode(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(76116);
    this.__T = new String();
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
    AppMethodBeat.o(76116);
  }
  
  public static ResponseHeadErrorCode convert(int paramInt)
  {
    AppMethodBeat.i(76114);
    int i = 0;
    Object localObject;
    while (i < __values.length)
    {
      if (__values[i].value() == paramInt)
      {
        localObject = __values[i];
        AppMethodBeat.o(76114);
        return localObject;
      }
      i += 1;
    }
    if (!$assertionsDisabled)
    {
      localObject = new AssertionError();
      AppMethodBeat.o(76114);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(76114);
    return null;
  }
  
  public static ResponseHeadErrorCode convert(String paramString)
  {
    AppMethodBeat.i(76115);
    int i = 0;
    while (i < __values.length)
    {
      if (__values[i].toString().equals(paramString))
      {
        paramString = __values[i];
        AppMethodBeat.o(76115);
        return paramString;
      }
      i += 1;
    }
    if (!$assertionsDisabled)
    {
      paramString = new AssertionError();
      AppMethodBeat.o(76115);
      throw paramString;
    }
    AppMethodBeat.o(76115);
    return null;
  }
  
  public final String toString()
  {
    return this.__T;
  }
  
  public final int value()
  {
    return this.__value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.jce.ResponseHeadErrorCode
 * JD-Core Version:    0.7.0.1
 */