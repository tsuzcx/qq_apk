package com.tencent.manager.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.shadow.core.manager.installplugin.InstalledPlugin;

public class e
{
  c a;
  f b;
  Context c;
  com.tencent.manager.c d;
  public int e;
  
  public e(Context paramContext, com.tencent.manager.c paramc, long paramLong)
  {
    this.d = paramc;
    Object localObject = paramc.g;
    if (localObject == null) {}
    for (localObject = "0";; localObject = ((InstalledPlugin)localObject).UUID_NickName)
    {
      this.a = new c(this.d.d, (String)localObject);
      this.a.a(paramLong);
      this.b = f.a(paramContext, paramc);
      this.c = paramContext;
      return;
    }
  }
  
  public void a(c.a parama)
  {
    this.a.a(this.d.e, this.c, this.d.d, parama);
  }
  
  public boolean a()
  {
    return this.a.a();
  }
  
  public boolean a(f.b paramb, int paramInt)
  {
    if (this.a.d() == null) {
      return false;
    }
    return a(paramb, paramInt, 2, String.valueOf(this.a.d().a()));
  }
  
  public boolean a(f.b paramb, int paramInt1, int paramInt2)
  {
    if (this.a.d() == null) {
      return false;
    }
    this.e = paramInt2;
    if (this.d.g == null) {}
    for (String str = String.valueOf(this.a.d().a());; str = this.d.g.UUID_NickName)
    {
      com.tencent.util.e.a.a("NowPluginManager | PluginUpdateDelegator", "downloadPlugin pluginType = " + paramInt1 + "version = " + str);
      return a(paramb, paramInt1, paramInt2, str);
    }
  }
  
  public boolean a(f.b paramb, int paramInt1, int paramInt2, String paramString)
  {
    g localg = this.a.d();
    this.e = paramInt2;
    Bundle localBundle = new Bundle();
    localBundle.putString("op_name", "download_start");
    localBundle.putInt("op_in", 1);
    localBundle.putString("d1", String.valueOf(paramInt2));
    localBundle.putString("d2", String.valueOf(paramInt1));
    com.tencent.util.g.a.a(localBundle);
    return this.b.a(paramb, 2, localg, paramInt1, paramInt2, paramString, this.d);
  }
  
  public long b()
  {
    return this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.manager.a.e
 * JD-Core Version:    0.7.0.1
 */