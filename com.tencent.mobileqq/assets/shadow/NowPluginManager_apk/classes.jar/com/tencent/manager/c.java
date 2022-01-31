package com.tencent.manager;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.manager.c.b;
import com.tencent.shadow.core.manager.installplugin.InstalledPlugin;

public class c
{
  public static boolean a;
  public static boolean b;
  public static boolean c = false;
  public String d;
  public String e;
  public long f = 0L;
  public InstalledPlugin g;
  public String h;
  public Bundle i;
  public String j;
  public int k = 0;
  public int l = 0;
  public int m = 1;
  
  public Intent a(Context paramContext)
  {
    a();
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(paramContext.getPackageName(), "com.tencent.litelive.module.videoroom.RoomActivity"));
    localIntent.putExtras(this.i);
    localIntent.setData(Uri.parse(this.j));
    return localIntent;
  }
  
  public void a()
  {
    this.i.putInt("updateflag", 1);
    this.i.putInt("supportbiu", 1);
    this.i.putBoolean("isNeedShowDownloadNetworkDialog", true);
    this.i.putBoolean("isLaunchFromPluginManager", true);
    this.i.putLong("proxy_version", 14L);
    this.i.putInt("pluginstatus", this.k);
    StringBuilder localStringBuilder = new StringBuilder("roomnow://openpage/anchor?");
    localStringBuilder.append("roomid=").append(b.a(this.i)).append("&from=").append(b.g(this.i)).append("&bizfrom=").append(b.g(this.i)).append("&qqversion=").append(this.h).append("&qquin=").append(this.e).append("&topicname=").append(b.h(this.i)).append("&roomtype=").append(b.b(this.i));
    this.j = localStringBuilder.toString();
  }
  
  public void a(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void b(int paramInt)
  {
    this.l = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.manager.c
 * JD-Core Version:    0.7.0.1
 */