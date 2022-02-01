package io.flutter.view;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;

@Keep
public final class FlutterCallbackInformation
{
  public final String callbackClassName;
  public final String callbackLibraryPath;
  public final String callbackName;
  
  private FlutterCallbackInformation(String paramString1, String paramString2, String paramString3)
  {
    this.callbackName = paramString1;
    this.callbackClassName = paramString2;
    this.callbackLibraryPath = paramString3;
  }
  
  public static FlutterCallbackInformation lookupCallbackInformation(long paramLong)
  {
    AppMethodBeat.i(9825);
    FlutterCallbackInformation localFlutterCallbackInformation = FlutterJNI.nativeLookupCallbackInformation(paramLong);
    AppMethodBeat.o(9825);
    return localFlutterCallbackInformation;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.view.FlutterCallbackInformation
 * JD-Core Version:    0.7.0.1
 */