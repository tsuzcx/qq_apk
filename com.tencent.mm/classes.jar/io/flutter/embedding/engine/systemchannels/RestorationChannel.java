package io.flutter.embedding.engine.systemchannels;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.HashMap;
import java.util.Map;

public class RestorationChannel
{
  private static final String TAG = "RestorationChannel";
  private MethodChannel channel;
  private boolean engineHasProvidedData;
  private boolean frameworkHasRequestedData;
  private final MethodChannel.MethodCallHandler handler;
  private MethodChannel.Result pendingFrameworkRestorationChannelRequest;
  private byte[] restorationData;
  public final boolean waitForRestorationData;
  
  public RestorationChannel(DartExecutor paramDartExecutor, boolean paramBoolean)
  {
    this(new MethodChannel(paramDartExecutor, "flutter/restoration", StandardMethodCodec.INSTANCE), paramBoolean);
    AppMethodBeat.i(190235);
    AppMethodBeat.o(190235);
  }
  
  RestorationChannel(MethodChannel paramMethodChannel, boolean paramBoolean)
  {
    AppMethodBeat.i(190239);
    this.engineHasProvidedData = false;
    this.frameworkHasRequestedData = false;
    this.handler = new MethodChannel.MethodCallHandler()
    {
      public void onMethodCall(MethodCall paramAnonymousMethodCall, MethodChannel.Result paramAnonymousResult)
      {
        AppMethodBeat.i(190176);
        String str = paramAnonymousMethodCall.method;
        paramAnonymousMethodCall = paramAnonymousMethodCall.arguments;
        int i = -1;
        switch (str.hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            paramAnonymousResult.notImplemented();
            AppMethodBeat.o(190176);
            return;
            if (str.equals("put"))
            {
              i = 0;
              continue;
              if (str.equals("get")) {
                i = 1;
              }
            }
            break;
          }
        }
        RestorationChannel.access$002(RestorationChannel.this, (byte[])paramAnonymousMethodCall);
        paramAnonymousResult.success(null);
        AppMethodBeat.o(190176);
        return;
        RestorationChannel.access$102(RestorationChannel.this, true);
        if ((RestorationChannel.this.engineHasProvidedData) || (!RestorationChannel.this.waitForRestorationData))
        {
          paramAnonymousResult.success(RestorationChannel.access$300(RestorationChannel.this, RestorationChannel.this.restorationData));
          AppMethodBeat.o(190176);
          return;
        }
        RestorationChannel.access$402(RestorationChannel.this, paramAnonymousResult);
        AppMethodBeat.o(190176);
      }
    };
    this.channel = paramMethodChannel;
    this.waitForRestorationData = paramBoolean;
    paramMethodChannel.setMethodCallHandler(this.handler);
    AppMethodBeat.o(190239);
  }
  
  private Map<String, Object> packageData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(190245);
    HashMap localHashMap = new HashMap();
    localHashMap.put("enabled", Boolean.TRUE);
    localHashMap.put("data", paramArrayOfByte);
    AppMethodBeat.o(190245);
    return localHashMap;
  }
  
  public void clearData()
  {
    this.restorationData = null;
  }
  
  public byte[] getRestorationData()
  {
    return this.restorationData;
  }
  
  public void setRestorationData(final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(190297);
    this.engineHasProvidedData = true;
    if (this.pendingFrameworkRestorationChannelRequest != null)
    {
      this.pendingFrameworkRestorationChannelRequest.success(packageData(paramArrayOfByte));
      this.pendingFrameworkRestorationChannelRequest = null;
    }
    while (!this.frameworkHasRequestedData)
    {
      this.restorationData = paramArrayOfByte;
      AppMethodBeat.o(190297);
      return;
    }
    this.channel.invokeMethod("push", packageData(paramArrayOfByte), new MethodChannel.Result()
    {
      public void error(String paramAnonymousString1, String paramAnonymousString2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(190182);
        Log.e("RestorationChannel", "Error " + paramAnonymousString1 + " while sending restoration data to framework: " + paramAnonymousString2);
        AppMethodBeat.o(190182);
      }
      
      public void notImplemented() {}
      
      public void success(Object paramAnonymousObject)
      {
        AppMethodBeat.i(190173);
        RestorationChannel.access$002(RestorationChannel.this, paramArrayOfByte);
        AppMethodBeat.o(190173);
      }
    });
    AppMethodBeat.o(190297);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.RestorationChannel
 * JD-Core Version:    0.7.0.1
 */