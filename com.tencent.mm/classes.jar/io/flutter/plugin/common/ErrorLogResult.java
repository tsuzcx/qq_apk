package io.flutter.plugin.common;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;

public class ErrorLogResult
  implements MethodChannel.Result
{
  private int level;
  private String tag;
  
  public ErrorLogResult(String paramString)
  {
    this(paramString, Log.WARN);
  }
  
  public ErrorLogResult(String paramString, int paramInt)
  {
    this.tag = paramString;
    this.level = paramInt;
  }
  
  public void error(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(189855);
    if (paramObject != null) {}
    for (paramString1 = " details: ".concat(String.valueOf(paramObject));; paramString1 = "")
    {
      if (this.level >= Log.WARN) {
        Log.println(this.level, this.tag, paramString2 + paramString1);
      }
      AppMethodBeat.o(189855);
      return;
    }
  }
  
  public void notImplemented()
  {
    AppMethodBeat.i(189860);
    if (this.level >= Log.WARN) {
      Log.println(this.level, this.tag, "method not implemented");
    }
    AppMethodBeat.o(189860);
  }
  
  public void success(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.plugin.common.ErrorLogResult
 * JD-Core Version:    0.7.0.1
 */