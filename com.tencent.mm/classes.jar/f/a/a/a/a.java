package f.a.a.a;

import android.app.Activity;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import java.io.PrintStream;

public final class a
  implements FlutterPlugin, ActivityAware, MethodChannel.MethodCallHandler
{
  private MethodChannel aiuf;
  private Activity mActivity;
  
  private float kkE()
  {
    AppMethodBeat.i(160027);
    if (this.mActivity == null)
    {
      AppMethodBeat.o(160027);
      return 0.0F;
    }
    float f2 = this.mActivity.getWindow().getAttributes().screenBrightness;
    f1 = f2;
    if (f2 < 0.0F) {}
    try
    {
      int i = Settings.System.getInt(this.mActivity.getContentResolver(), "screen_brightness");
      f1 = i / 255.0F;
    }
    catch (Settings.SettingNotFoundException localSettingNotFoundException)
    {
      for (;;)
      {
        f1 = 1.0F;
      }
    }
    AppMethodBeat.o(160027);
    return f1;
  }
  
  public final void onAttachedToActivity(ActivityPluginBinding paramActivityPluginBinding)
  {
    AppMethodBeat.i(186249);
    this.mActivity = paramActivityPluginBinding.getActivity();
    AppMethodBeat.o(186249);
  }
  
  public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(186243);
    this.aiuf = new MethodChannel(paramFlutterPluginBinding.getBinaryMessenger(), "github.com/clovisnicolas/flutter_screen");
    this.aiuf.setMethodCallHandler(this);
    AppMethodBeat.o(186243);
  }
  
  public final void onDetachedFromActivity() {}
  
  public final void onDetachedFromActivityForConfigChanges()
  {
    this.mActivity = null;
  }
  
  public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(186246);
    if (this.aiuf != null) {
      this.aiuf.setMethodCallHandler(null);
    }
    AppMethodBeat.o(186246);
  }
  
  public final void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    boolean bool = true;
    AppMethodBeat.i(160026);
    if (this.mActivity == null)
    {
      AppMethodBeat.o(160026);
      return;
    }
    String str = paramMethodCall.method;
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramResult.notImplemented();
        AppMethodBeat.o(160026);
        return;
        if (str.equals("brightness"))
        {
          i = 0;
          continue;
          if (str.equals("setBrightness"))
          {
            i = 1;
            continue;
            if (str.equals("isKeptOn"))
            {
              i = 2;
              continue;
              if (str.equals("keepOn")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    paramResult.success(Float.valueOf(kkE()));
    AppMethodBeat.o(160026);
    return;
    double d = ((Double)paramMethodCall.argument("brightness")).doubleValue();
    paramMethodCall = this.mActivity.getWindow().getAttributes();
    paramMethodCall.screenBrightness = ((float)d);
    this.mActivity.getWindow().setAttributes(paramMethodCall);
    paramResult.success(null);
    AppMethodBeat.o(160026);
    return;
    if ((this.mActivity.getWindow().getAttributes().flags & 0x80) != 0) {}
    for (;;)
    {
      paramResult.success(Boolean.valueOf(bool));
      AppMethodBeat.o(160026);
      return;
      bool = false;
    }
    if (((Boolean)paramMethodCall.argument("on")).booleanValue())
    {
      System.out.println("Keeping screen on ");
      this.mActivity.getWindow().addFlags(128);
    }
    for (;;)
    {
      paramResult.success(null);
      AppMethodBeat.o(160026);
      return;
      System.out.println("Not keeping screen on");
      this.mActivity.getWindow().clearFlags(128);
    }
  }
  
  public final void onReattachedToActivityForConfigChanges(ActivityPluginBinding paramActivityPluginBinding) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     f.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */