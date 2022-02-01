package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class IPCCmd
  implements Serializable
{
  public static final IPCCmd BatchDownloadAction;
  public static final IPCCmd Empty;
  public static final IPCCmd GetDownloadProgress;
  public static final IPCCmd GetDownloadState;
  public static final IPCCmd OperateDownloadTask;
  public static final IPCCmd QueryDownloadTask;
  public static final IPCCmd QueryLoginInfo;
  public static final IPCCmd QueryLoginState;
  public static final IPCCmd ServiceFreeAction;
  public static final IPCCmd URIAction;
  public static final int _BatchDownloadAction = 9;
  public static final int _Empty = 0;
  public static final int _GetDownloadProgress = 3;
  public static final int _GetDownloadState = 2;
  public static final int _OperateDownloadTask = 1;
  public static final int _QueryDownloadTask = 4;
  public static final int _QueryLoginInfo = 6;
  public static final int _QueryLoginState = 7;
  public static final int _ServiceFreeAction = 8;
  public static final int _URIAction = 5;
  private static IPCCmd[] __values;
  private String __T;
  private int __value;
  
  static
  {
    AppMethodBeat.i(102237);
    if (!IPCCmd.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      __values = new IPCCmd[10];
      Empty = new IPCCmd(0, 0, "Empty");
      OperateDownloadTask = new IPCCmd(1, 1, "OperateDownloadTask");
      GetDownloadState = new IPCCmd(2, 2, "GetDownloadState");
      GetDownloadProgress = new IPCCmd(3, 3, "GetDownloadProgress");
      QueryDownloadTask = new IPCCmd(4, 4, "QueryDownloadTask");
      URIAction = new IPCCmd(5, 5, "URIAction");
      QueryLoginInfo = new IPCCmd(6, 6, "QueryLoginInfo");
      QueryLoginState = new IPCCmd(7, 7, "QueryLoginState");
      ServiceFreeAction = new IPCCmd(8, 8, "ServiceFreeAction");
      BatchDownloadAction = new IPCCmd(9, 9, "BatchDownloadAction");
      AppMethodBeat.o(102237);
      return;
    }
  }
  
  private IPCCmd(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(102236);
    this.__T = new String();
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
    AppMethodBeat.o(102236);
  }
  
  public static IPCCmd convert(int paramInt)
  {
    AppMethodBeat.i(102234);
    int i = 0;
    Object localObject;
    while (i < __values.length)
    {
      if (__values[i].value() == paramInt)
      {
        localObject = __values[i];
        AppMethodBeat.o(102234);
        return localObject;
      }
      i += 1;
    }
    if (!$assertionsDisabled)
    {
      localObject = new AssertionError();
      AppMethodBeat.o(102234);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(102234);
    return null;
  }
  
  public static IPCCmd convert(String paramString)
  {
    AppMethodBeat.i(102235);
    int i = 0;
    while (i < __values.length)
    {
      if (__values[i].toString().equals(paramString))
      {
        paramString = __values[i];
        AppMethodBeat.o(102235);
        return paramString;
      }
      i += 1;
    }
    if (!$assertionsDisabled)
    {
      paramString = new AssertionError();
      AppMethodBeat.o(102235);
      throw paramString;
    }
    AppMethodBeat.o(102235);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.param.jce.IPCCmd
 * JD-Core Version:    0.7.0.1
 */