package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;

public abstract class s
{
  public String a(Context paramContext, ResolveInfo paramResolveInfo)
  {
    return paramResolveInfo.activityInfo.loadLabel(paramContext.getPackageManager()).toString();
  }
  
  public abstract boolean aLv(String paramString);
  
  public abstract String aQx();
  
  public boolean ah(Context paramContext, Intent paramIntent)
  {
    return false;
  }
  
  public abstract String eZs();
  
  public abstract t.a eZt();
  
  public abstract boolean hn(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.s
 * JD-Core Version:    0.7.0.1
 */