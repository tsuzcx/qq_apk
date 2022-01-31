package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;

public abstract class r
{
  public abstract String UP();
  
  public abstract boolean VJ(String paramString);
  
  public String a(Context paramContext, ResolveInfo paramResolveInfo)
  {
    return paramResolveInfo.activityInfo.loadLabel(paramContext.getPackageManager()).toString();
  }
  
  public abstract String cks();
  
  public abstract s.a ckt();
  
  public abstract boolean eL(Context paramContext);
  
  public boolean y(Context paramContext, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.r
 * JD-Core Version:    0.7.0.1
 */