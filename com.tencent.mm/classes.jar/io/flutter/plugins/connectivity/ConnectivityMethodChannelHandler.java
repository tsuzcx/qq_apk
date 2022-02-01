package io.flutter.plugins.connectivity;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

class ConnectivityMethodChannelHandler
  implements MethodChannel.MethodCallHandler
{
  private Connectivity connectivity;
  
  static
  {
    AppMethodBeat.i(189590);
    if (!ConnectivityMethodChannelHandler.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(189590);
      return;
    }
  }
  
  ConnectivityMethodChannelHandler(Connectivity paramConnectivity)
  {
    AppMethodBeat.i(189582);
    if ((!$assertionsDisabled) && (paramConnectivity == null))
    {
      paramConnectivity = new AssertionError();
      AppMethodBeat.o(189582);
      throw paramConnectivity;
    }
    this.connectivity = paramConnectivity;
    AppMethodBeat.o(189582);
  }
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    AppMethodBeat.i(189598);
    paramMethodCall = paramMethodCall.method;
    int i = -1;
    switch (paramMethodCall.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramResult.notImplemented();
        AppMethodBeat.o(189598);
        return;
        if (paramMethodCall.equals("check")) {
          i = 0;
        }
        break;
      }
    }
    paramResult.success(this.connectivity.getNetworkType());
    AppMethodBeat.o(189598);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.plugins.connectivity.ConnectivityMethodChannelHandler
 * JD-Core Version:    0.7.0.1
 */