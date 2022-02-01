package com.tencent.tencentmap.io;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class QStorageManager
{
  public static final String DATA = "data/";
  private static QStorageManager mInstance = null;
  
  private QStorageManager(Context paramContext) {}
  
  public static QStorageManager getInstance(Context paramContext)
  {
    AppMethodBeat.i(180970);
    if (mInstance == null) {
      mInstance = new QStorageManager(paramContext);
    }
    paramContext = mInstance;
    AppMethodBeat.o(180970);
    return paramContext;
  }
  
  public void clearOldConfig(Context paramContext, String paramString) {}
  
  public String getAssetsDynamicPath()
  {
    return null;
  }
  
  public String getAssetsLoadPath(String paramString)
  {
    return null;
  }
  
  public File getCacheDir()
  {
    return null;
  }
  
  public String getConfigPath(String paramString)
  {
    return null;
  }
  
  public String getConfigTempPath(String paramString)
  {
    return null;
  }
  
  public File getDataDir()
  {
    return null;
  }
  
  public String getMapPath()
  {
    return null;
  }
  
  public String getRouteBlockPath()
  {
    return null;
  }
  
  public String getSatPath()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.io.QStorageManager
 * JD-Core Version:    0.7.0.1
 */