package com.tencent.xweb.xwalk.plugin;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public abstract class b
{
  public int xmr = -1;
  
  public b()
  {
    if (XWalkEnvironment.getApplicationContext() == null)
    {
      Log.e("XWalkPlugin", "load ver of " + cTE() + " context is null");
      return;
    }
    SharedPreferences localSharedPreferences = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(cTE());
    if (localSharedPreferences == null)
    {
      XWalkEnvironment.addXWalkInitializeLog("XWalkPlugin", "load ver of " + cTE() + " sp is null");
      return;
    }
    this.xmr = localSharedPreferences.getInt("availableVersion", -1);
    XWalkEnvironment.addXWalkInitializeLog("XWalkPlugin", "load ver of " + cTE() + " ver " + this.xmr);
  }
  
  public final boolean KJ(int paramInt)
  {
    if (XWalkEnvironment.getApplicationContext() == null)
    {
      Log.e("XWalkPlugin", "set ver of " + cTE() + " context is null");
      return false;
    }
    Object localObject = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(cTE());
    if (localObject == null)
    {
      XWalkEnvironment.addXWalkInitializeLog("XWalkPlugin", "set ver of " + cTE() + " sp is null");
      return false;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("availableVersion", paramInt);
    boolean bool = ((SharedPreferences.Editor)localObject).commit();
    if (bool) {
      this.xmr = paramInt;
    }
    XWalkEnvironment.addXWalkInitializeLog("XWalkPlugin", "set ver of " + cTE() + " to " + paramInt + ", isNow = true, ret = " + bool);
    return bool;
  }
  
  public abstract int a(c.a parama);
  
  public abstract String az(int paramInt, boolean paramBoolean);
  
  public abstract String cTE();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.plugin.b
 * JD-Core Version:    0.7.0.1
 */