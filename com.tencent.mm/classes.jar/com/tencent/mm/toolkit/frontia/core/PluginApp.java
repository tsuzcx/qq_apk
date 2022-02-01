package com.tencent.mm.toolkit.frontia.core;

import android.app.Application;
import android.content.Context;

public abstract class PluginApp
  extends Application
{
  protected Context mContext;
  
  public abstract a getBehavior();
  
  public void setAppContext(Context paramContext)
  {
    this.mContext = paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.toolkit.frontia.core.PluginApp
 * JD-Core Version:    0.7.0.1
 */