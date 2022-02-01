package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;

public abstract class x
{
  public boolean aF(Context paramContext, Intent paramIntent)
  {
    return false;
  }
  
  public abstract boolean bpD(String paramString);
  
  public abstract String bvr();
  
  public String c(Context paramContext, ResolveInfo paramResolveInfo)
  {
    return paramResolveInfo.activityInfo.loadLabel(paramContext.getPackageManager()).toString();
  }
  
  public abstract String getPackageName();
  
  public abstract String hgO();
  
  public abstract y.a hgP();
  
  public abstract boolean jq(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.x
 * JD-Core Version:    0.7.0.1
 */