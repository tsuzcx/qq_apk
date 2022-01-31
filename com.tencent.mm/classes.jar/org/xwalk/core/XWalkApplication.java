package org.xwalk.core;

import android.app.Application;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(85537);
    if (this.mRes != null)
    {
      AppMethodBeat.o(85537);
      return;
    }
    this.mRes = new XWalkMixedResources(super.getResources(), paramResources);
    AppMethodBeat.o(85537);
  }
  
  void addResource(String paramString)
  {
    AppMethodBeat.i(85538);
    if (this.mRes != null)
    {
      AppMethodBeat.o(85538);
      return;
    }
    try
    {
      AssetManager localAssetManager = (AssetManager)AssetManager.class.newInstance();
      localAssetManager.getClass().getMethod("addAssetPath", new Class[] { String.class }).invoke(localAssetManager, new Object[] { paramString });
      paramString = super.getResources();
      paramString = new Resources(localAssetManager, paramString.getDisplayMetrics(), paramString.getConfiguration());
      this.mRes = new XWalkMixedResources(super.getResources(), paramString);
      AppMethodBeat.o(85538);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("XWalkLib", paramString.getMessage());
      AppMethodBeat.o(85538);
    }
  }
  
  public Resources getResources()
  {
    AppMethodBeat.i(85536);
    if (this.mRes == null)
    {
      localResources = super.getResources();
      AppMethodBeat.o(85536);
      return localResources;
    }
    Resources localResources = this.mRes;
    AppMethodBeat.o(85536);
    return localResources;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(85535);
    super.onCreate();
    gApp = this;
    AppMethodBeat.o(85535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.XWalkApplication
 * JD-Core Version:    0.7.0.1
 */