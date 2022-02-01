package com.tencent.shadow.a.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.shadow.a.a.a.b;
import com.tencent.shadow.core.b.a.e;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.dynamic.a.c;
import com.tencent.shadow.dynamic.host.EnterCallback;
import com.tencent.shadow.dynamic.loader.PluginLoader;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class a
  extends c
{
  private static final Logger e = LoggerFactory.getLogger(a.class);
  private ExecutorService f = Executors.newSingleThreadExecutor();
  private ExecutorService g = Executors.newFixedThreadPool(4);
  private Context h;
  
  public a(Context paramContext)
  {
    super(paramContext);
    this.h = paramContext;
  }
  
  private void a(final Context paramContext, final Bundle paramBundle, final EnterCallback paramEnterCallback)
  {
    Object localObject2 = paramBundle.getString("KEY_ACTIVITY_CLASSNAME");
    final String str2 = paramBundle.getString("pluginZipMD5", null);
    final String str1 = paramBundle.getString("pluginZipPath", "/data/local/tmp/plugin-debug.zip");
    boolean bool = paramBundle.getBoolean("isDebugVersion", true);
    int i = paramBundle.getInt("page_type");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "com.tencent.ilivesdk.demo.LauncherActivity";
    }
    paramBundle = paramBundle.getBundle("KEY_EXTRAS");
    if (paramEnterCallback != null) {
      paramEnterCallback.onShowLoadingView(null);
    }
    if (e != null)
    {
      localObject2 = e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("IliveLaunch startEnter pluginZipPath = ");
      localStringBuilder.append(str1);
      localStringBuilder.append(" pageType = ");
      localStringBuilder.append(i);
      localStringBuilder.append(" isDebugVersion = ");
      localStringBuilder.append(bool);
      localStringBuilder.append(" fileMd5 = ");
      localStringBuilder.append(str2);
      ((Logger)localObject2).info(localStringBuilder.toString());
    }
    if (new File(str1).exists())
    {
      this.f.execute(new Runnable()
      {
        public void run()
        {
          try
          {
            com.tencent.shadow.a.a.b.a.a("IliveLaunch installPlugin");
            b.a().a(4);
            e locale = a.this.a(str1, str2, true);
            com.tencent.shadow.a.a.b.a.b("IliveLaunch installPlugin");
            b.a().b(4).a("插件解压耗时");
            if (a.f() != null)
            {
              localObject = a.f();
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("final installedPlugin uuid = ");
              localStringBuilder.append(str1);
              ((Logger)localObject).error(localStringBuilder.toString());
            }
            com.tencent.shadow.a.a.b.a.a("IliveLaunch startPluginActivity");
            localObject = new Intent();
            ((Intent)localObject).setClassName(paramContext.getPackageName(), this.d);
            if (paramBundle != null) {
              ((Intent)localObject).replaceExtras(paramBundle);
            }
            b.a().a(6);
            a.this.a(paramContext, locale, "ilive-plugin", (Intent)localObject);
            b.a().b(4).a("插件启动跳转");
            com.tencent.shadow.a.a.b.a.b("IliveLaunch startPluginActivity");
            if (paramEnterCallback != null)
            {
              new Handler(Looper.getMainLooper()).post(new Runnable()
              {
                public void run()
                {
                  a.1.this.f.onCloseLoadingView();
                  a.1.this.f.onEnterComplete();
                }
              });
              return;
            }
          }
          catch (Throwable localThrowable)
          {
            Object localObject;
            StringBuilder localStringBuilder;
            if (a.f() != null)
            {
              localObject = a.f();
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("startEnter Throwable className = ");
              localStringBuilder.append(this.d);
              localStringBuilder.append(" msg = ");
              localStringBuilder.append(localThrowable.getMessage());
              ((Logger)localObject).error(localStringBuilder.toString());
            }
            if (("preload".equals(this.d)) && (paramEnterCallback != null)) {
              new Handler(Looper.getMainLooper()).post(new Runnable()
              {
                public void run()
                {
                  a.1.this.f.onCloseLoadingView();
                  a.1.this.f.onEnterComplete();
                }
              });
            }
            localThrowable.printStackTrace();
          }
        }
      });
      if (!bool) {
        return;
      }
      paramBundle = new Handler(Looper.getMainLooper());
      paramEnterCallback = new Runnable()
      {
        public void run()
        {
          Context localContext;
          if (str1.contains("/data/local/tmp/")) {
            localContext = paramContext;
          }
          for (String str = "当前使用本地bundle";; str = "当前使用网络下载bundle")
          {
            Toast.makeText(localContext, str, 0).show();
            return;
            localContext = paramContext;
          }
        }
      };
      paramContext = paramBundle;
      paramBundle = paramEnterCallback;
    }
    else
    {
      if (!bool) {
        return;
      }
      paramEnterCallback = new Handler(Looper.getMainLooper());
      paramBundle = new Runnable()
      {
        public void run()
        {
          Toast.makeText(paramContext, "插件apk文件不存在", 0).show();
        }
      };
      paramContext = paramEnterCallback;
    }
    paramContext.post(paramBundle);
  }
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    Object localObject1 = paramBundle.getString("pluginZipPath", "/data/local/tmp/plugin-debug.zip");
    boolean bool = paramBundle.getBoolean("isDebugVersion", true);
    paramBundle = paramBundle.getString("pluginZipMD5", null);
    Object localObject2;
    if (e != null)
    {
      localObject2 = e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("IliveLaunch preloadOdexPlugin pluginZipPath = ");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(" isDebugVersion = ");
      localStringBuilder.append(bool);
      localStringBuilder.append(" pluginZipMd5 = ");
      localStringBuilder.append(paramBundle);
      ((Logger)localObject2).info(localStringBuilder.toString());
    }
    try
    {
      com.tencent.shadow.a.a.b.a.a("IliveLaunch preload installPlugin");
      paramBundle = a((String)localObject1, paramBundle, true);
      com.tencent.shadow.a.a.b.a.b("IliveLaunch preload installPlugin");
      if ((paramBundle != null) && (e != null))
      {
        localObject1 = e;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("IliveLaunch preloadOdex success = ");
        ((StringBuilder)localObject2).append(paramBundle.a);
        ((Logger)localObject1).info(((StringBuilder)localObject2).toString());
        return;
      }
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  private void f(String paramString)
  {
    if (this.c == null)
    {
      com.tencent.shadow.a.a.b.a.a("IliveLaunch bindPluginProcessService");
      a(e());
      a(10, TimeUnit.SECONDS);
      com.tencent.shadow.a.a.b.a.b("IliveLaunch bindPluginProcessService");
    }
    com.tencent.shadow.a.a.b.a.a("IliveLaunch loadRunTime");
    d(paramString);
    com.tencent.shadow.a.a.b.a.b("IliveLaunch loadRunTime");
    com.tencent.shadow.a.a.b.a.a("IliveLaunch loadPluginLoader");
    e(paramString);
    com.tencent.shadow.a.a.b.a.b("IliveLaunch loadPluginLoader");
  }
  
  public Intent a(e parame, String paramString, Intent paramIntent)
  {
    com.tencent.shadow.a.a.b.a.a("IliveLaunch loadPlugin");
    e(parame.a, "ilive-plugin");
    com.tencent.shadow.a.a.b.a.b("IliveLaunch loadPlugin");
    return this.d.convertActivityIntent(paramIntent);
  }
  
  public e a(String paramString1, final String paramString2, boolean paramBoolean)
  {
    com.tencent.shadow.a.a.b.a.a("IliveLaunch installPluginFromZip");
    paramString2 = a(new File(paramString1), paramString2);
    Object localObject2;
    if (e != null)
    {
      localObject1 = e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("installedPlugin uuid = ");
      ((StringBuilder)localObject2).append(paramString2.a);
      ((StringBuilder)localObject2).append(" zip = ");
      ((StringBuilder)localObject2).append(paramString1);
      ((Logger)localObject1).info(((StringBuilder)localObject2).toString());
    }
    com.tencent.shadow.a.a.b.a.b("IliveLaunch installPluginFromZip");
    paramString1 = new LinkedList();
    if ((paramString2.d != null) && (paramString2.c != null))
    {
      paramString1.add(this.g.submit(new Callable()
      {
        public Object call()
        {
          com.tencent.shadow.a.a.b.a.a("IliveLaunch oDexPluginLoaderOrRunTime");
          a.this.b(paramString2.a, 4);
          com.tencent.shadow.a.a.b.a.b("IliveLaunch oDexPluginLoaderOrRunTime");
          return null;
        }
      }));
      paramString1.add(this.g.submit(new Callable()
      {
        public Object call()
        {
          com.tencent.shadow.a.a.b.a.a("IliveLaunch oDexPluginLoaderOrRunTime loader");
          a.this.b(paramString2.a, 3);
          com.tencent.shadow.a.a.b.a.b("IliveLaunch oDexPluginLoaderOrRunTime loader");
          return null;
        }
      }));
    }
    Object localObject1 = paramString2.e.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Map.Entry)((Iterator)localObject1).next()).getKey();
      paramString1.add(this.g.submit(new Callable()
      {
        public Object call()
        {
          com.tencent.shadow.a.a.b.a.a("IliveLaunch extractSo");
          a.this.c(paramString2.a, this.b);
          com.tencent.shadow.a.a.b.a.b("IliveLaunch extractSo");
          return null;
        }
      }));
      if (paramBoolean) {
        paramString1.add(this.g.submit(new Callable()
        {
          public Object call()
          {
            com.tencent.shadow.a.a.b.a.a("IliveLaunch oDexPlugin");
            a.this.b(paramString2.a, this.b);
            com.tencent.shadow.a.a.b.a.b("IliveLaunch oDexPlugin");
            return null;
          }
        }));
      }
    }
    paramString1 = paramString1.iterator();
    while (paramString1.hasNext()) {
      ((Future)paramString1.next()).get();
    }
    return paramString2;
  }
  
  protected String a()
  {
    return "ilive-manager";
  }
  
  public void a(Context paramContext, e parame, String paramString, Intent paramIntent)
  {
    parame = a(parame, paramString, paramIntent);
    if (!(paramContext instanceof Activity)) {
      parame.setFlags(268435456);
    }
    paramContext.startActivity(parame);
  }
  
  public String b()
  {
    return "armeabi";
  }
  
  public String d()
  {
    return "com.tencent.shadow.dynamic.runtime.container.ilive";
  }
  
  protected String e()
  {
    return "com.tencent.proxyinner.plugin.loader.PluginToolProcessService";
  }
  
  protected void e(String paramString1, String paramString2)
  {
    com.tencent.shadow.a.a.b.a.a("IliveLaunch loadPluginLoaderAndRuntime");
    f(paramString1);
    com.tencent.shadow.a.a.b.a.b("IliveLaunch loadPluginLoaderAndRuntime");
    paramString1 = this.d.getLoadedPlugin();
    if (!paramString1.containsKey(paramString2)) {
      this.d.loadPlugin(paramString2);
    }
    paramString1 = (Boolean)paramString1.get(paramString2);
    if ((paramString1 == null) || (!paramString1.booleanValue())) {
      this.d.callApplicationOnCreate(paramString2);
    }
  }
  
  public void enter(Context paramContext, long paramLong, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    if (paramLong == 1003L)
    {
      a(paramContext, paramBundle, paramEnterCallback);
      return;
    }
    if (paramLong == 1001L) {
      return;
    }
    if (paramLong == 1002L)
    {
      a(paramBundle);
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("不认识的fromId==");
    paramContext.append(paramLong);
    throw new IllegalArgumentException(paramContext.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\live_shopping_manager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.a.a.a
 * JD-Core Version:    0.7.0.1
 */