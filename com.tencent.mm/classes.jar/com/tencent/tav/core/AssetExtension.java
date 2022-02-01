package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;

public class AssetExtension
{
  public static final String SCENE_EXPORT = "export";
  public static final String SCENE_PLAY = "play";
  public static final String SCENE_THUMBNAIL = "thumbnail";
  private volatile ConcurrentHashMap<String, Object> extensionMap;
  private final String scene;
  
  public AssetExtension(String paramString)
  {
    AppMethodBeat.i(214398);
    this.extensionMap = new ConcurrentHashMap();
    this.scene = paramString;
    AppMethodBeat.o(214398);
  }
  
  public void addExtension(String paramString, Object paramObject)
  {
    AppMethodBeat.i(214399);
    this.extensionMap.put(paramString, paramObject);
    AppMethodBeat.o(214399);
  }
  
  public boolean containsKey(String paramString)
  {
    AppMethodBeat.i(214400);
    boolean bool = this.extensionMap.containsKey(paramString);
    AppMethodBeat.o(214400);
    return bool;
  }
  
  public boolean containsValue(String paramString)
  {
    AppMethodBeat.i(214401);
    boolean bool = this.extensionMap.containsValue(paramString);
    AppMethodBeat.o(214401);
    return bool;
  }
  
  public String getScene()
  {
    return this.scene;
  }
  
  public Object remove(String paramString)
  {
    AppMethodBeat.i(214402);
    paramString = this.extensionMap.remove(paramString);
    AppMethodBeat.o(214402);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tav.core.AssetExtension
 * JD-Core Version:    0.7.0.1
 */