package com.tencent.tinker.entry;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.support.annotation.Keep;

@Keep
public abstract class ApplicationLike
{
  @Keep
  public AssetManager getAssets(AssetManager paramAssetManager)
  {
    return paramAssetManager;
  }
  
  @Keep
  public Context getBaseContext(Context paramContext)
  {
    return paramContext;
  }
  
  @Keep
  public ClassLoader getClassLoader(ClassLoader paramClassLoader)
  {
    return paramClassLoader;
  }
  
  @Keep
  public Resources getResources(Resources paramResources)
  {
    return paramResources;
  }
  
  @Keep
  public Object getSystemService(String paramString, Object paramObject)
  {
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.entry.ApplicationLike
 * JD-Core Version:    0.7.0.1
 */