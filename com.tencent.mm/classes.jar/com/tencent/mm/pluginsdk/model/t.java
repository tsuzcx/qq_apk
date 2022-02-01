package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;

public abstract class t
{
  public boolean aw(Context paramContext, Intent paramIntent)
  {
    return false;
  }
  
  public abstract boolean bdn(String paramString);
  
  public abstract String blB();
  
  public String c(Context paramContext, ResolveInfo paramResolveInfo)
  {
    return paramResolveInfo.activityInfo.loadLabel(paramContext.getPackageManager()).toString();
  }
  
  public abstract String gmq();
  
  public abstract u.a gmr();
  
  public abstract boolean in(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.t
 * JD-Core Version:    0.7.0.1
 */