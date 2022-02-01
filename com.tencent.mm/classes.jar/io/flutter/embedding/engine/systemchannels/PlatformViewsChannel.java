package io.flutter.embedding.engine.systemchannels;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.StandardMethodCodec;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

public class PlatformViewsChannel
{
  private static final String TAG = "PlatformViewsChannel";
  private final MethodChannel channel;
  private PlatformViewsHandler handler;
  private final MethodChannel.MethodCallHandler parsingHandler;
  
  public PlatformViewsChannel(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10271);
    this.parsingHandler = new MethodChannel.MethodCallHandler()
    {
      private void clearFocus(MethodCall paramAnonymousMethodCall, MethodChannel.Result paramAnonymousResult)
      {
        AppMethodBeat.i(190273);
        int i = ((Integer)paramAnonymousMethodCall.arguments()).intValue();
        try
        {
          PlatformViewsChannel.this.handler.clearFocus(i);
          paramAnonymousResult.success(null);
          AppMethodBeat.o(190273);
          return;
        }
        catch (IllegalStateException paramAnonymousMethodCall)
        {
          paramAnonymousResult.error("error", PlatformViewsChannel.access$100(paramAnonymousMethodCall), null);
          AppMethodBeat.o(190273);
        }
      }
      
      private void create(MethodCall paramAnonymousMethodCall, MethodChannel.Result paramAnonymousResult)
      {
        double d2 = 0.0D;
        AppMethodBeat.i(190233);
        paramAnonymousMethodCall = (Map)paramAnonymousMethodCall.arguments();
        int i;
        double d1;
        label54:
        label59:
        int j;
        String str;
        int k;
        if ((paramAnonymousMethodCall.containsKey("hybrid")) && (((Boolean)paramAnonymousMethodCall.get("hybrid")).booleanValue()))
        {
          i = 1;
          if (i == 0) {
            break label188;
          }
          d1 = 0.0D;
          if (i == 0) {
            break label206;
          }
          j = ((Integer)paramAnonymousMethodCall.get("id")).intValue();
          str = (String)paramAnonymousMethodCall.get("viewType");
          k = ((Integer)paramAnonymousMethodCall.get("direction")).intValue();
          if (!paramAnonymousMethodCall.containsKey("params")) {
            break label225;
          }
        }
        label188:
        label206:
        label225:
        for (paramAnonymousMethodCall = ByteBuffer.wrap((byte[])paramAnonymousMethodCall.get("params"));; paramAnonymousMethodCall = null)
        {
          paramAnonymousMethodCall = new PlatformViewsChannel.PlatformViewCreationRequest(j, str, d1, d2, k, paramAnonymousMethodCall);
          if (i == 0) {
            break label230;
          }
          try
          {
            PlatformViewsChannel.this.handler.createAndroidViewForPlatformView(paramAnonymousMethodCall);
            paramAnonymousResult.success(null);
            AppMethodBeat.o(190233);
            return;
          }
          catch (IllegalStateException paramAnonymousMethodCall)
          {
            paramAnonymousResult.error("error", PlatformViewsChannel.access$100(paramAnonymousMethodCall), null);
            AppMethodBeat.o(190233);
          }
          i = 0;
          break;
          d1 = ((Double)paramAnonymousMethodCall.get("width")).doubleValue();
          break label54;
          d2 = ((Double)paramAnonymousMethodCall.get("height")).doubleValue();
          break label59;
        }
        label230:
        paramAnonymousResult.success(Long.valueOf(PlatformViewsChannel.this.handler.createVirtualDisplayForPlatformView(paramAnonymousMethodCall)));
        AppMethodBeat.o(190233);
        return;
      }
      
      private void dispose(MethodCall paramAnonymousMethodCall, MethodChannel.Result paramAnonymousResult)
      {
        AppMethodBeat.i(190240);
        paramAnonymousMethodCall = (Map)paramAnonymousMethodCall.arguments();
        int j = ((Integer)paramAnonymousMethodCall.get("id")).intValue();
        int i;
        if ((paramAnonymousMethodCall.containsKey("hybrid")) && (((Boolean)paramAnonymousMethodCall.get("hybrid")).booleanValue()))
        {
          i = 1;
          if (i == 0) {
            break label95;
          }
        }
        for (;;)
        {
          try
          {
            PlatformViewsChannel.this.handler.disposeAndroidViewForPlatformView(j);
            paramAnonymousResult.success(null);
            AppMethodBeat.o(190240);
            return;
          }
          catch (IllegalStateException paramAnonymousMethodCall)
          {
            label95:
            paramAnonymousResult.error("error", PlatformViewsChannel.access$100(paramAnonymousMethodCall), null);
            AppMethodBeat.o(190240);
          }
          i = 0;
          break;
          PlatformViewsChannel.this.handler.disposeVirtualDisplayForPlatformView(j);
        }
      }
      
      private void resize(MethodCall paramAnonymousMethodCall, final MethodChannel.Result paramAnonymousResult)
      {
        AppMethodBeat.i(190247);
        paramAnonymousMethodCall = (Map)paramAnonymousMethodCall.arguments();
        paramAnonymousMethodCall = new PlatformViewsChannel.PlatformViewResizeRequest(((Integer)paramAnonymousMethodCall.get("id")).intValue(), ((Double)paramAnonymousMethodCall.get("width")).doubleValue(), ((Double)paramAnonymousMethodCall.get("height")).doubleValue());
        try
        {
          PlatformViewsChannel.this.handler.resizePlatformView(paramAnonymousMethodCall, new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(10253);
              paramAnonymousResult.success(null);
              AppMethodBeat.o(10253);
            }
          });
          AppMethodBeat.o(190247);
          return;
        }
        catch (IllegalStateException paramAnonymousMethodCall)
        {
          paramAnonymousResult.error("error", PlatformViewsChannel.access$100(paramAnonymousMethodCall), null);
          AppMethodBeat.o(190247);
        }
      }
      
      private void setDirection(MethodCall paramAnonymousMethodCall, MethodChannel.Result paramAnonymousResult)
      {
        AppMethodBeat.i(190264);
        paramAnonymousMethodCall = (Map)paramAnonymousMethodCall.arguments();
        int i = ((Integer)paramAnonymousMethodCall.get("id")).intValue();
        int j = ((Integer)paramAnonymousMethodCall.get("direction")).intValue();
        try
        {
          PlatformViewsChannel.this.handler.setDirection(i, j);
          paramAnonymousResult.success(null);
          AppMethodBeat.o(190264);
          return;
        }
        catch (IllegalStateException paramAnonymousMethodCall)
        {
          paramAnonymousResult.error("error", PlatformViewsChannel.access$100(paramAnonymousMethodCall), null);
          AppMethodBeat.o(190264);
        }
      }
      
      private void touch(MethodCall paramAnonymousMethodCall, MethodChannel.Result paramAnonymousResult)
      {
        AppMethodBeat.i(190255);
        paramAnonymousMethodCall = (List)paramAnonymousMethodCall.arguments();
        paramAnonymousMethodCall = new PlatformViewsChannel.PlatformViewTouch(((Integer)paramAnonymousMethodCall.get(0)).intValue(), (Number)paramAnonymousMethodCall.get(1), (Number)paramAnonymousMethodCall.get(2), ((Integer)paramAnonymousMethodCall.get(3)).intValue(), ((Integer)paramAnonymousMethodCall.get(4)).intValue(), paramAnonymousMethodCall.get(5), paramAnonymousMethodCall.get(6), ((Integer)paramAnonymousMethodCall.get(7)).intValue(), ((Integer)paramAnonymousMethodCall.get(8)).intValue(), (float)((Double)paramAnonymousMethodCall.get(9)).doubleValue(), (float)((Double)paramAnonymousMethodCall.get(10)).doubleValue(), ((Integer)paramAnonymousMethodCall.get(11)).intValue(), ((Integer)paramAnonymousMethodCall.get(12)).intValue(), ((Integer)paramAnonymousMethodCall.get(13)).intValue(), ((Integer)paramAnonymousMethodCall.get(14)).intValue(), ((Number)paramAnonymousMethodCall.get(15)).longValue());
        try
        {
          PlatformViewsChannel.this.handler.onTouch(paramAnonymousMethodCall);
          paramAnonymousResult.success(null);
          AppMethodBeat.o(190255);
          return;
        }
        catch (IllegalStateException paramAnonymousMethodCall)
        {
          paramAnonymousResult.error("error", PlatformViewsChannel.access$100(paramAnonymousMethodCall), null);
          AppMethodBeat.o(190255);
        }
      }
      
      public void onMethodCall(MethodCall paramAnonymousMethodCall, MethodChannel.Result paramAnonymousResult)
      {
        AppMethodBeat.i(10241);
        if (PlatformViewsChannel.this.handler == null)
        {
          AppMethodBeat.o(10241);
          return;
        }
        Log.v("PlatformViewsChannel", "Received '" + paramAnonymousMethodCall.method + "' message.");
        String str = paramAnonymousMethodCall.method;
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
            AppMethodBeat.o(10241);
            return;
            if (str.equals("create"))
            {
              i = 0;
              continue;
              if (str.equals("dispose"))
              {
                i = 1;
                continue;
                if (str.equals("resize"))
                {
                  i = 2;
                  continue;
                  if (str.equals("touch"))
                  {
                    i = 3;
                    continue;
                    if (str.equals("setDirection"))
                    {
                      i = 4;
                      continue;
                      if (str.equals("clearFocus")) {
                        i = 5;
                      }
                    }
                  }
                }
              }
            }
            break;
          }
        }
        create(paramAnonymousMethodCall, paramAnonymousResult);
        AppMethodBeat.o(10241);
        return;
        dispose(paramAnonymousMethodCall, paramAnonymousResult);
        AppMethodBeat.o(10241);
        return;
        resize(paramAnonymousMethodCall, paramAnonymousResult);
        AppMethodBeat.o(10241);
        return;
        touch(paramAnonymousMethodCall, paramAnonymousResult);
        AppMethodBeat.o(10241);
        return;
        setDirection(paramAnonymousMethodCall, paramAnonymousResult);
        AppMethodBeat.o(10241);
        return;
        clearFocus(paramAnonymousMethodCall, paramAnonymousResult);
        AppMethodBeat.o(10241);
      }
    };
    this.channel = new MethodChannel(paramDartExecutor, "flutter/platform_views", StandardMethodCodec.INSTANCE);
    this.channel.setMethodCallHandler(this.parsingHandler);
    AppMethodBeat.o(10271);
  }
  
  private static String detailedExceptionString(Exception paramException)
  {
    AppMethodBeat.i(190243);
    StringWriter localStringWriter = new StringWriter();
    paramException.printStackTrace(new PrintWriter(localStringWriter));
    paramException = localStringWriter.toString();
    AppMethodBeat.o(190243);
    return paramException;
  }
  
  public void invokeViewFocused(int paramInt)
  {
    AppMethodBeat.i(190270);
    if (this.channel == null)
    {
      AppMethodBeat.o(190270);
      return;
    }
    this.channel.invokeMethod("viewFocused", Integer.valueOf(paramInt));
    AppMethodBeat.o(190270);
  }
  
  public void setPlatformViewsHandler(PlatformViewsHandler paramPlatformViewsHandler)
  {
    this.handler = paramPlatformViewsHandler;
  }
  
  public static class PlatformViewCreationRequest
  {
    public final int direction;
    public final double logicalHeight;
    public final double logicalWidth;
    public final ByteBuffer params;
    public final int viewId;
    public final String viewType;
    
    public PlatformViewCreationRequest(int paramInt1, String paramString, double paramDouble1, double paramDouble2, int paramInt2, ByteBuffer paramByteBuffer)
    {
      this.viewId = paramInt1;
      this.viewType = paramString;
      this.logicalWidth = paramDouble1;
      this.logicalHeight = paramDouble2;
      this.direction = paramInt2;
      this.params = paramByteBuffer;
    }
  }
  
  public static class PlatformViewResizeRequest
  {
    public final double newLogicalHeight;
    public final double newLogicalWidth;
    public final int viewId;
    
    public PlatformViewResizeRequest(int paramInt, double paramDouble1, double paramDouble2)
    {
      this.viewId = paramInt;
      this.newLogicalWidth = paramDouble1;
      this.newLogicalHeight = paramDouble2;
    }
  }
  
  public static class PlatformViewTouch
  {
    public final int action;
    public final int buttonState;
    public final int deviceId;
    public final Number downTime;
    public final int edgeFlags;
    public final Number eventTime;
    public final int flags;
    public final int metaState;
    public final long motionEventId;
    public final int pointerCount;
    public final Object rawPointerCoords;
    public final Object rawPointerPropertiesList;
    public final int source;
    public final int viewId;
    public final float xPrecision;
    public final float yPrecision;
    
    public PlatformViewTouch(int paramInt1, Number paramNumber1, Number paramNumber2, int paramInt2, int paramInt3, Object paramObject1, Object paramObject2, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2, int paramInt6, int paramInt7, int paramInt8, int paramInt9, long paramLong)
    {
      this.viewId = paramInt1;
      this.downTime = paramNumber1;
      this.eventTime = paramNumber2;
      this.action = paramInt2;
      this.pointerCount = paramInt3;
      this.rawPointerPropertiesList = paramObject1;
      this.rawPointerCoords = paramObject2;
      this.metaState = paramInt4;
      this.buttonState = paramInt5;
      this.xPrecision = paramFloat1;
      this.yPrecision = paramFloat2;
      this.deviceId = paramInt6;
      this.edgeFlags = paramInt7;
      this.source = paramInt8;
      this.flags = paramInt9;
      this.motionEventId = paramLong;
    }
  }
  
  public static abstract interface PlatformViewsHandler
  {
    public abstract void clearFocus(int paramInt);
    
    public abstract void createAndroidViewForPlatformView(PlatformViewsChannel.PlatformViewCreationRequest paramPlatformViewCreationRequest);
    
    public abstract long createVirtualDisplayForPlatformView(PlatformViewsChannel.PlatformViewCreationRequest paramPlatformViewCreationRequest);
    
    public abstract void disposeAndroidViewForPlatformView(int paramInt);
    
    public abstract void disposeVirtualDisplayForPlatformView(int paramInt);
    
    public abstract void onTouch(PlatformViewsChannel.PlatformViewTouch paramPlatformViewTouch);
    
    public abstract void resizePlatformView(PlatformViewsChannel.PlatformViewResizeRequest paramPlatformViewResizeRequest, Runnable paramRunnable);
    
    public abstract void setDirection(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.PlatformViewsChannel
 * JD-Core Version:    0.7.0.1
 */