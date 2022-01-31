package org.xwalk.core;

import android.app.Application;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.reflect.Method;

public class XWalkApplication
  extends Application
{
  private static final String TAG = "XWalkLib";
  private static XWalkApplication gApp = null;
  private Resources mRes = null;
  
  static XWalkApplication getApplication()
  {
    return gApp;
  }
  
  void addResource(Resources paramResources)
  {
    if (this.mRes != null) {
      return;
    }
    this.mRes = new XWalkMixedResources(super.getResources(), paramResources);
  }
  
  void addResource(String paramString)
  {
    if (this.mRes != null) {
      return;
    }
    try
    {
      AssetManager localAssetManager = (AssetManager)AssetManager.class.newInstance();
      localAssetManager.getClass().getMethod("addAssetPath", new Class[] { String.class }).invoke(localAssetManager, new Object[] { paramString });
      paramString = super.getResources();
      paramString = new Resources(localAssetManager, paramString.getDisplayMetrics(), paramString.getConfiguration());
      this.mRes = new XWalkMixedResources(super.getResources(), paramString);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("XWalkLib", paramString.getMessage());
    }
  }
  
  public Resources getResources()
  {
    if (this.mRes == null) {
      return super.getResources();
    }
    return this.mRes;
  }
  
  public void onCreate()
  {
    super.onCreate();
    gApp = this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.XWalkApplication
 * JD-Core Version:    0.7.0.1
 */