package io.flutter.plugin.platform;

import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lio/flutter/plugin/platform/SkylineTextureLogic;", "", "()V", "TAG", "", "VIEW_TYPE", "sSkylineTextureHandler", "Lio/flutter/plugin/platform/ISkylineTextureHandler;", "sSkylineTextureInfoMap", "Ljava/util/HashMap;", "Lio/flutter/plugin/platform/SkylineTextureInfo;", "Lkotlin/collections/HashMap;", "skylineTextureIds", "addSkylineTexture", "", "id", "", "type", "getSkylineTextureInfo", "getSkylineTextureType", "initSkylineTextureHandler", "handler", "isSkylineTexture", "", "isSkylineTextureType", "viewType", "onTextureDestroy", "onTextureReady", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "height", "onTextureTouch", "motionEvent", "Landroid/view/MotionEvent;", "onTextureUpdate", "removeSkylineTexture", "skyline_android_lib_release"}, k=1, mv={1, 1, 16})
public final class SkylineTextureLogic
{
  public static final SkylineTextureLogic INSTANCE;
  private static final String TAG = "SkylineTextureLogic";
  private static final String VIEW_TYPE = "skyline_texture";
  private static ISkylineTextureHandler sSkylineTextureHandler;
  private static HashMap<String, SkylineTextureInfo> sSkylineTextureInfoMap;
  private static final HashMap<String, String> skylineTextureIds;
  
  static
  {
    AppMethodBeat.i(189908);
    INSTANCE = new SkylineTextureLogic();
    skylineTextureIds = new HashMap();
    sSkylineTextureInfoMap = new HashMap();
    AppMethodBeat.o(189908);
  }
  
  public final void addSkylineTexture(int paramInt, String paramString)
  {
    AppMethodBeat.i(189939);
    s.t(paramString, "type");
    ((Map)skylineTextureIds).put("skyline_texture-".concat(String.valueOf(paramInt)), paramString);
    AppMethodBeat.o(189939);
  }
  
  public final SkylineTextureInfo getSkylineTextureInfo(String paramString, int paramInt)
  {
    AppMethodBeat.i(189962);
    paramString = (SkylineTextureInfo)sSkylineTextureInfoMap.get(paramString + '#' + paramInt);
    AppMethodBeat.o(189962);
    return paramString;
  }
  
  public final String getSkylineTextureType(int paramInt)
  {
    AppMethodBeat.i(189945);
    String str = (String)skylineTextureIds.get("skyline_texture-".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(189945);
    return str;
  }
  
  public final void initSkylineTextureHandler(ISkylineTextureHandler paramISkylineTextureHandler)
  {
    AppMethodBeat.i(189921);
    s.t(paramISkylineTextureHandler, "handler");
    sSkylineTextureHandler = paramISkylineTextureHandler;
    AppMethodBeat.o(189921);
  }
  
  public final boolean isSkylineTexture(int paramInt)
  {
    AppMethodBeat.i(189930);
    boolean bool = ((Map)skylineTextureIds).containsKey("skyline_texture-".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(189930);
    return bool;
  }
  
  public final boolean isSkylineTextureType(String paramString)
  {
    AppMethodBeat.i(189914);
    s.t(paramString, "viewType");
    boolean bool = s.p(paramString, "skyline_texture");
    AppMethodBeat.o(189914);
    return bool;
  }
  
  public final void onTextureDestroy(String paramString, int paramInt)
  {
    AppMethodBeat.i(189983);
    new StringBuilder("onTextureDestroy type:").append(paramString).append(" id:").append(paramInt);
    sSkylineTextureInfoMap.remove(paramString + '#' + paramInt);
    ISkylineTextureHandler localISkylineTextureHandler = sSkylineTextureHandler;
    if (localISkylineTextureHandler != null)
    {
      localISkylineTextureHandler.onTextureDestroy(paramString, paramInt);
      AppMethodBeat.o(189983);
      return;
    }
    AppMethodBeat.o(189983);
  }
  
  public final void onTextureReady(String paramString, int paramInt1, SurfaceTexture paramSurfaceTexture, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(189969);
    new StringBuilder("onTextureReady type:").append(paramString).append(" id:").append(paramInt1).append(" surfaceTexture:").append(paramSurfaceTexture).append(" width:").append(paramInt2).append(" height:").append(paramInt3);
    ((Map)sSkylineTextureInfoMap).put(paramString + '#' + paramInt1, new SkylineTextureInfo(paramInt2, paramInt3));
    ISkylineTextureHandler localISkylineTextureHandler = sSkylineTextureHandler;
    if (localISkylineTextureHandler != null)
    {
      localISkylineTextureHandler.onTextureReady(paramString, paramInt1, paramSurfaceTexture, paramInt2, paramInt3);
      AppMethodBeat.o(189969);
      return;
    }
    AppMethodBeat.o(189969);
  }
  
  public final void onTextureTouch(String paramString, int paramInt, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(189990);
    s.t(paramMotionEvent, "motionEvent");
    new StringBuilder("onTextureTouch type:").append(paramString).append(" id:").append(paramInt).append(" motionEvent:").append(paramMotionEvent);
    ISkylineTextureHandler localISkylineTextureHandler = sSkylineTextureHandler;
    if (localISkylineTextureHandler != null)
    {
      localISkylineTextureHandler.onTextureTouch(paramString, paramInt, paramMotionEvent);
      AppMethodBeat.o(189990);
      return;
    }
    AppMethodBeat.o(189990);
  }
  
  public final void onTextureUpdate(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(189976);
    new StringBuilder("onTextureUpdate type:").append(paramString).append(" id:").append(paramInt1).append(" width:").append(paramInt2).append(" height:").append(paramInt3);
    ISkylineTextureHandler localISkylineTextureHandler = sSkylineTextureHandler;
    if (localISkylineTextureHandler != null)
    {
      localISkylineTextureHandler.onTextureUpdate(paramString, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(189976);
      return;
    }
    AppMethodBeat.o(189976);
  }
  
  public final void removeSkylineTexture(int paramInt)
  {
    AppMethodBeat.i(189956);
    skylineTextureIds.remove("skyline_texture-".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(189956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.plugin.platform.SkylineTextureLogic
 * JD-Core Version:    0.7.0.1
 */