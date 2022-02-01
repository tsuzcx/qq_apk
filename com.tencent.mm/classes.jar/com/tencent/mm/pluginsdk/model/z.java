package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;

public abstract class z
{
  public boolean aO(Context paramContext, Intent paramIntent)
  {
    return false;
  }
  
  public abstract String bTD();
  
  public abstract boolean bpt(String paramString);
  
  public String c(Context paramContext, ResolveInfo paramResolveInfo)
  {
    return paramResolveInfo.activityInfo.loadLabel(paramContext.getPackageManager()).toString();
  }
  
  public abstract String getPackageName();
  
  public abstract String iHM();
  
  public abstract String iHN();
  
  public abstract aa.a iHO();
  
  public abstract boolean ln(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.z
 * JD-Core Version:    0.7.0.1
 */