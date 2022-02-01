package com.tencent.smtt.sdk.a;

import android.content.Context;
import android.os.Bundle;

public abstract interface c
{
  public abstract boolean canLoadVideo(Context paramContext);
  
  public abstract boolean canLoadX5(Context paramContext, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract boolean canLoadX5FirstTimeThirdApp(Context paramContext);
  
  public abstract boolean canUseVideoFeatrue(Context paramContext, int paramInt);
  
  public abstract String[] getDexLoaderFileList(Context paramContext1, Context paramContext2, String paramString);
  
  public abstract String getLibraryPath();
  
  public abstract String getTbsCoreVersionString();
  
  public abstract Bundle incrUpdate(Context paramContext, Bundle paramBundle);
  
  public abstract boolean init(Context paramContext);
  
  public abstract boolean isX5Disabled(Context paramContext, int paramInt1, int paramInt2);
  
  public abstract boolean isX5DisabledSync(Context paramContext);
  
  public abstract Object onMiscCallExtension(Context paramContext, String paramString, Bundle paramBundle);
  
  public abstract boolean useSoftWare();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.a.c
 * JD-Core Version:    0.7.0.1
 */