package com.tencent.tmassistantsdk.protocol.jce;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class JceCmd
  implements Serializable
{
  public static final JceCmd Empty;
  public static final JceCmd GetAppSimpleDetail;
  public static final JceCmd GetAppUpdate;
  public static final JceCmd GetSettings;
  public static final JceCmd ReportApkFileInfo;
  public static final JceCmd ReportLog;
  public static final int _Empty = 0;
  public static final int _GetAppSimpleDetail = 5;
  public static final int _GetAppUpdate = 3;
  public static final int _GetSettings = 2;
  public static final int _ReportApkFileInfo = 4;
  public static final int _ReportLog = 1;
  private static JceCmd[] __values;
  private String __T;
  private int __value;
  
  static
  {
    AppMethodBeat.i(102311);
    if (!JceCmd.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      __values = new JceCmd[6];
      Empty = new JceCmd(0, 0, "Empty");
      ReportLog = new JceCmd(1, 1, "ReportLog");
      GetSettings = new JceCmd(2, 2, "GetSettings");
      GetAppUpdate = new JceCmd(3, 3, "GetAppUpdate");
      ReportApkFileInfo = new JceCmd(4, 4, "ReportApkFileInfo");
      GetAppSimpleDetail = new JceCmd(5, 5, "GetAppSimpleDetail");
      AppMethodBeat.o(102311);
      return;
    }
  }
  
  private JceCmd(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(102310);
    this.__T = new String();
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
    AppMethodBeat.o(102310);
  }
  
  public static JceCmd convert(int paramInt)
  {
    AppMethodBeat.i(102308);
    int i = 0;
    Object localObject;
    while (i < __values.length)
    {
      if (__values[i].value() == paramInt)
      {
        localObject = __values[i];
        AppMethodBeat.o(102308);
        return localObject;
      }
      i += 1;
    }
    if (!$assertionsDisabled)
    {
      localObject = new AssertionError();
      AppMethodBeat.o(102308);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(102308);
    return null;
  }
  
  public static JceCmd convert(String paramString)
  {
    AppMethodBeat.i(102309);
    int i = 0;
    while (i < __values.length)
    {
      if (__values[i].toString().equals(paramString))
      {
        paramString = __values[i];
        AppMethodBeat.o(102309);
        return paramString;
      }
      i += 1;
    }
    if (!$assertionsDisabled)
    {
      paramString = new AssertionError();
      AppMethodBeat.o(102309);
      throw paramString;
    }
    AppMethodBeat.o(102309);
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
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.jce.JceCmd
 * JD-Core Version:    0.7.0.1
 */