package io.flutter.plugin.platform;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewCreationRequest;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewResizeRequest;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewTouch;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.view.TextureRegistry;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lio/flutter/plugin/platform/SkylinePlatformViewsController;", "Lio/flutter/plugin/platform/CustomPlatformViewsController;", "()V", "skylineChannelHandler", "Lio/flutter/embedding/engine/systemchannels/PlatformViewsChannel$PlatformViewsHandler;", "attach", "", "context", "Landroid/content/Context;", "textureRegistry", "Lio/flutter/view/TextureRegistry;", "dartExecutor", "Lio/flutter/embedding/engine/dart/DartExecutor;", "skyline_android_lib_release"}, k=1, mv={1, 1, 16})
public final class SkylinePlatformViewsController
  extends CustomPlatformViewsController
{
  private final PlatformViewsChannel.PlatformViewsHandler skylineChannelHandler;
  
  public SkylinePlatformViewsController()
  {
    AppMethodBeat.i(189880);
    this.skylineChannelHandler = ((PlatformViewsChannel.PlatformViewsHandler)new PlatformViewsChannel.PlatformViewsHandler()
    {
      public final void clearFocus(int paramAnonymousInt)
      {
        AppMethodBeat.i(189922);
        if (!SkylineTextureLogic.INSTANCE.isSkylineTexture(paramAnonymousInt))
        {
          this.this$0.channelHandler.clearFocus(paramAnonymousInt);
          AppMethodBeat.o(189922);
          return;
        }
        AppMethodBeat.o(189922);
      }
      
      public final void createAndroidViewForPlatformView(PlatformViewsChannel.PlatformViewCreationRequest paramAnonymousPlatformViewCreationRequest)
      {
        AppMethodBeat.i(189876);
        s.t(paramAnonymousPlatformViewCreationRequest, "request");
        this.this$0.channelHandler.createAndroidViewForPlatformView(paramAnonymousPlatformViewCreationRequest);
        AppMethodBeat.o(189876);
      }
      
      public final long createVirtualDisplayForPlatformView(PlatformViewsChannel.PlatformViewCreationRequest paramAnonymousPlatformViewCreationRequest)
      {
        AppMethodBeat.i(189895);
        s.t(paramAnonymousPlatformViewCreationRequest, "request");
        Object localObject = paramAnonymousPlatformViewCreationRequest.viewType;
        s.r(localObject, "request.viewType");
        long l;
        if (!SkylineTextureLogic.INSTANCE.isSkylineTextureType((String)localObject))
        {
          l = this.this$0.channelHandler.createVirtualDisplayForPlatformView(paramAnonymousPlatformViewCreationRequest);
          AppMethodBeat.o(189895);
          return l;
        }
        int i = paramAnonymousPlatformViewCreationRequest.viewId;
        int j = this.this$0.toPhysicalPixels(paramAnonymousPlatformViewCreationRequest.logicalWidth);
        int k = this.this$0.toPhysicalPixels(paramAnonymousPlatformViewCreationRequest.logicalHeight);
        this.this$0.validateVirtualDisplayDimensions(j, k);
        localObject = this.this$0.textureRegistry.createSurfaceTexture();
        if (paramAnonymousPlatformViewCreationRequest.params != null) {}
        for (paramAnonymousPlatformViewCreationRequest = StandardMessageCodec.INSTANCE.decodeMessage(paramAnonymousPlatformViewCreationRequest.params);; paramAnonymousPlatformViewCreationRequest = null)
        {
          paramAnonymousPlatformViewCreationRequest = (Map)paramAnonymousPlatformViewCreationRequest;
          if (paramAnonymousPlatformViewCreationRequest != null)
          {
            paramAnonymousPlatformViewCreationRequest = paramAnonymousPlatformViewCreationRequest.get("type");
            paramAnonymousPlatformViewCreationRequest = (String)paramAnonymousPlatformViewCreationRequest;
            if (paramAnonymousPlatformViewCreationRequest != null) {
              break label208;
            }
            paramAnonymousPlatformViewCreationRequest = "empty";
          }
          label208:
          for (;;)
          {
            SkylineTextureLogic.INSTANCE.addSkylineTexture(i, paramAnonymousPlatformViewCreationRequest);
            SkylineTextureLogic.INSTANCE.onTextureReady(paramAnonymousPlatformViewCreationRequest, i, ((TextureRegistry.SurfaceTextureEntry)localObject).surfaceTexture(), j, k);
            l = ((TextureRegistry.SurfaceTextureEntry)localObject).id();
            AppMethodBeat.o(189895);
            return l;
            paramAnonymousPlatformViewCreationRequest = null;
            break;
          }
        }
      }
      
      public final void disposeAndroidViewForPlatformView(int paramAnonymousInt)
      {
        AppMethodBeat.i(189887);
        this.this$0.channelHandler.disposeAndroidViewForPlatformView(paramAnonymousInt);
        AppMethodBeat.o(189887);
      }
      
      public final void disposeVirtualDisplayForPlatformView(int paramAnonymousInt)
      {
        AppMethodBeat.i(189899);
        if (!SkylineTextureLogic.INSTANCE.isSkylineTexture(paramAnonymousInt))
        {
          this.this$0.channelHandler.disposeVirtualDisplayForPlatformView(paramAnonymousInt);
          AppMethodBeat.o(189899);
          return;
        }
        String str = SkylineTextureLogic.INSTANCE.getSkylineTextureType(paramAnonymousInt);
        SkylineTextureLogic.INSTANCE.removeSkylineTexture(paramAnonymousInt);
        SkylineTextureLogic.INSTANCE.onTextureDestroy(str, paramAnonymousInt);
        AppMethodBeat.o(189899);
      }
      
      public final void onTouch(PlatformViewsChannel.PlatformViewTouch paramAnonymousPlatformViewTouch)
      {
        AppMethodBeat.i(189903);
        s.t(paramAnonymousPlatformViewTouch, "touch");
        int i = paramAnonymousPlatformViewTouch.viewId;
        if (!SkylineTextureLogic.INSTANCE.isSkylineTexture(i))
        {
          this.this$0.channelHandler.onTouch(paramAnonymousPlatformViewTouch);
          AppMethodBeat.o(189903);
          return;
        }
        Object localObject = this.this$0.context;
        s.r(localObject, "context");
        localObject = ((Context)localObject).getResources();
        s.r(localObject, "context.resources");
        float f = ((Resources)localObject).getDisplayMetrics().density;
        paramAnonymousPlatformViewTouch = this.this$0.toMotionEvent(f, paramAnonymousPlatformViewTouch, true);
        localObject = SkylineTextureLogic.INSTANCE.getSkylineTextureType(i);
        SkylineTextureLogic localSkylineTextureLogic = SkylineTextureLogic.INSTANCE;
        s.r(paramAnonymousPlatformViewTouch, "event");
        localSkylineTextureLogic.onTextureTouch((String)localObject, i, paramAnonymousPlatformViewTouch);
        AppMethodBeat.o(189903);
      }
      
      public final void resizePlatformView(PlatformViewsChannel.PlatformViewResizeRequest paramAnonymousPlatformViewResizeRequest, Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(189909);
        s.t(paramAnonymousPlatformViewResizeRequest, "request");
        s.t(paramAnonymousRunnable, "onComplete");
        int i = paramAnonymousPlatformViewResizeRequest.viewId;
        if (!SkylineTextureLogic.INSTANCE.isSkylineTexture(i))
        {
          this.this$0.channelHandler.resizePlatformView(paramAnonymousPlatformViewResizeRequest, paramAnonymousRunnable);
          AppMethodBeat.o(189909);
          return;
        }
        String str = SkylineTextureLogic.INSTANCE.getSkylineTextureType(i);
        int j = this.this$0.toPhysicalPixels(paramAnonymousPlatformViewResizeRequest.newLogicalWidth);
        int k = this.this$0.toPhysicalPixels(paramAnonymousPlatformViewResizeRequest.newLogicalHeight);
        SkylineTextureLogic.INSTANCE.onTextureUpdate(str, i, j, k);
        paramAnonymousRunnable.run();
        AppMethodBeat.o(189909);
      }
      
      public final void setDirection(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(189915);
        if (!SkylineTextureLogic.INSTANCE.isSkylineTexture(paramAnonymousInt1))
        {
          this.this$0.channelHandler.setDirection(paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(189915);
          return;
        }
        AppMethodBeat.o(189915);
      }
    });
    AppMethodBeat.o(189880);
  }
  
  public final void attach(Context paramContext, TextureRegistry paramTextureRegistry, DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(189892);
    s.t(paramContext, "context");
    s.t(paramTextureRegistry, "textureRegistry");
    s.t(paramDartExecutor, "dartExecutor");
    super.attach(paramContext, paramTextureRegistry, paramDartExecutor);
    this.platformViewsChannel.setPlatformViewsHandler(this.skylineChannelHandler);
    AppMethodBeat.o(189892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.plugin.platform.SkylinePlatformViewsController
 * JD-Core Version:    0.7.0.1
 */