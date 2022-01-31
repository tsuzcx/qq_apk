package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;

public abstract class q
{
  public boolean F(Context paramContext, Intent paramIntent)
  {
    return false;
  }
  
  public String a(Context paramContext, ResolveInfo paramResolveInfo)
  {
    return paramResolveInfo.activityInfo.loadLabel(paramContext.getPackageManager()).toString();
  }
  
  public abstract boolean alg(String paramString);
  
  public abstract String aoo();
  
  public abstract String dkX();
  
  public abstract r.a dkY();
  
  public abstract boolean fL(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.q
 * JD-Core Version:    0.7.0.1
 */