package io.flutter.embedding.engine.systemchannels;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DeferredComponentChannel
{
  private static final String TAG = "DeferredComponentChannel";
  private final MethodChannel channel;
  private DeferredComponentManager deferredComponentManager;
  private Map<String, List<MethodChannel.Result>> moduleNameToResults;
  final MethodChannel.MethodCallHandler parsingMethodHandler;
  
  public DeferredComponentChannel(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(190225);
    this.parsingMethodHandler = new MethodChannel.MethodCallHandler()
    {
      public void onMethodCall(MethodCall paramAnonymousMethodCall, MethodChannel.Result paramAnonymousResult)
      {
        AppMethodBeat.i(190160);
        if (DeferredComponentChannel.this.deferredComponentManager == null)
        {
          AppMethodBeat.o(190160);
          return;
        }
        String str = paramAnonymousMethodCall.method;
        paramAnonymousMethodCall = (Map)paramAnonymousMethodCall.arguments();
        Log.v("DeferredComponentChannel", "Received '" + str + "' message.");
        int j = ((Integer)paramAnonymousMethodCall.get("loadingUnitId")).intValue();
        paramAnonymousMethodCall = (String)paramAnonymousMethodCall.get("moduleName");
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
            AppMethodBeat.o(190160);
            return;
            if (str.equals("installDeferredComponent"))
            {
              i = 0;
              continue;
              if (str.equals("getDeferredComponentInstallState"))
              {
                i = 1;
                continue;
                if (str.equals("uninstallDeferredComponent")) {
                  i = 2;
                }
              }
            }
            break;
          }
        }
        DeferredComponentChannel.this.deferredComponentManager.installDeferredComponent(j, paramAnonymousMethodCall);
        if (!DeferredComponentChannel.this.moduleNameToResults.containsKey(paramAnonymousMethodCall)) {
          DeferredComponentChannel.this.moduleNameToResults.put(paramAnonymousMethodCall, new ArrayList());
        }
        ((List)DeferredComponentChannel.this.moduleNameToResults.get(paramAnonymousMethodCall)).add(paramAnonymousResult);
        AppMethodBeat.o(190160);
        return;
        paramAnonymousResult.success(DeferredComponentChannel.this.deferredComponentManager.getDeferredComponentInstallState(j, paramAnonymousMethodCall));
        AppMethodBeat.o(190160);
        return;
        DeferredComponentChannel.this.deferredComponentManager.uninstallDeferredComponent(j, paramAnonymousMethodCall);
        paramAnonymousResult.success(null);
        AppMethodBeat.o(190160);
      }
    };
    this.channel = new MethodChannel(paramDartExecutor, "flutter/deferredcomponent", StandardMethodCodec.INSTANCE);
    this.channel.setMethodCallHandler(this.parsingMethodHandler);
    this.deferredComponentManager = FlutterInjector.instance().deferredComponentManager();
    this.moduleNameToResults = new HashMap();
    AppMethodBeat.o(190225);
  }
  
  public void completeInstallError(String paramString1, String paramString2)
  {
    AppMethodBeat.i(190257);
    if (this.moduleNameToResults.containsKey(paramString1))
    {
      Iterator localIterator = ((List)this.moduleNameToResults.get(paramString1)).iterator();
      while (localIterator.hasNext()) {
        ((MethodChannel.Result)localIterator.next()).error("DeferredComponent Install failure", paramString2, null);
      }
      ((List)this.moduleNameToResults.get(paramString1)).clear();
    }
    AppMethodBeat.o(190257);
  }
  
  public void completeInstallSuccess(String paramString)
  {
    AppMethodBeat.i(190250);
    if (this.moduleNameToResults.containsKey(paramString))
    {
      Iterator localIterator = ((List)this.moduleNameToResults.get(paramString)).iterator();
      while (localIterator.hasNext()) {
        ((MethodChannel.Result)localIterator.next()).success(null);
      }
      ((List)this.moduleNameToResults.get(paramString)).clear();
    }
    AppMethodBeat.o(190250);
  }
  
  public void setDeferredComponentManager(DeferredComponentManager paramDeferredComponentManager)
  {
    this.deferredComponentManager = paramDeferredComponentManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.DeferredComponentChannel
 * JD-Core Version:    0.7.0.1
 */