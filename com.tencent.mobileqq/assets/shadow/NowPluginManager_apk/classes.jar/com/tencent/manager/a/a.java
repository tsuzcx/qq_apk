package com.tencent.manager.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.manager.c;
import com.tencent.util.c.b;
import java.io.File;
import java.util.Map;

public class a
  extends f
{
  private g.a l;
  
  public a(Context paramContext, c paramc) {}
  
  private void a(g paramg, int paramInt, String paramString)
  {
    if (paramInt == 1) {
      this.l = paramg.a(paramString, 4);
    }
    while (paramInt != 2) {
      return;
    }
    this.l = paramg.a(paramString, 3);
  }
  
  private boolean a(c paramc, String paramString1, final String paramString2, int paramInt1, int paramInt2)
  {
    File localFile = new File(paramString2);
    if (localFile.exists()) {
      localFile.delete();
    }
    if (paramc != null) {}
    for (paramc = paramc.i;; paramc = null)
    {
      b.a(paramString1, paramString2, paramc, new com.tencent.util.c.a()
      {
        public void a() {}
        
        public void a(long paramAnonymousLong1, long paramAnonymousLong2)
        {
          int i = 10;
          int j = (int)(80 * paramAnonymousLong1 * 1.0D / paramAnonymousLong2 + 10);
          if (j < 10) {}
          for (;;)
          {
            a.this.a(paramAnonymousLong1, paramAnonymousLong2, i);
            return;
            if (j > 90) {
              i = 90;
            } else {
              i = j;
            }
          }
        }
        
        public void a(Bundle paramAnonymousBundle)
        {
          int i = paramAnonymousBundle.getInt("errCode", -1);
          com.tencent.util.e.a.a("PluginManager|Downloader", "onDownloadResult use Host----retCode = " + i);
          int j = paramAnonymousBundle.getInt("httpCode", 200);
          paramAnonymousBundle = paramAnonymousBundle.getString("errMsg");
          if (i == 0)
          {
            com.tencent.util.e.a.a("PluginManager|Downloader", "HostDownloader下载SDK成功");
            if (!a.this.b(paramString2, a.a(a.this).d))
            {
              com.tencent.util.e.a.a("PluginManager|Downloader", "md5校验失败！");
              new File(paramString2).delete();
              a.this.a(4, 0);
              return;
            }
            a.this.a(paramString2, a.a(a.this).d);
            return;
          }
          com.tencent.util.e.a.a("PluginManager|Downloader", "HostDownloader下载SDK失败,retCode = " + i + " httpCode = " + j + "errMsg = " + paramAnonymousBundle);
          a.this.a(2, i);
        }
      });
      return true;
    }
  }
  
  private void b(g paramg, int paramInt, String paramString, c paramc)
  {
    if (paramg == null)
    {
      a("updateParam == NULL!");
      a(1, 0);
    }
    do
    {
      return;
      paramg = this.g.a(paramString);
      if (paramg == null)
      {
        a("the download dir is null!");
        a(5, 0);
        return;
      }
      paramg = paramg + "/nowplugin_" + paramInt + ".zip";
      if (!a(paramc, this.l.c, paramg, 5, 95))
      {
        a(2, 0);
        return;
      }
    } while (this.a == 2);
    if (!b(paramg, this.l.d)) {}
    for (paramInt = 3;; paramInt = 0)
    {
      if (paramInt != 0)
      {
        a(paramInt, 0);
        return;
      }
      a(0L, 0L, 100);
      a(paramg, this.l.d);
      return;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    this.j.remove(this.l.c);
    super.a(paramInt1, paramInt2);
  }
  
  protected void a(final g paramg, final int paramInt, final String paramString, final c paramc)
  {
    a(paramg, paramInt, paramString);
    if ((this.l == null) || (this.l.c == null))
    {
      a("apkParam == NULL!");
      a(1, 0);
    }
    do
    {
      return;
      if ((!this.j.containsKey(this.l.c)) || (this.j.get(this.l.c) == null)) {
        break;
      }
      paramg = (f.a)this.j.get(this.l.c);
      if (paramg.a == d)
      {
        this.e.a(paramg.b, paramg.d);
        return;
      }
    } while (paramg.a != c);
    return;
    paramg = new Thread("xplugin_download_Thread")
    {
      public void run()
      {
        a.a(a.this, paramg, paramInt, paramString, paramc);
      }
    };
    paramString = new f.a();
    paramString.c = this.l.c;
    paramString.a = c;
    this.j.put(paramString.c, paramString);
    paramg.setPriority(2);
    paramg.start();
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (this.j.get(this.l.c) != null)
    {
      ((f.a)this.j.get(this.l.c)).a = d;
      ((f.a)this.j.get(this.l.c)).b = paramString1;
      ((f.a)this.j.get(this.l.c)).d = paramString2;
    }
    super.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.manager.a.a
 * JD-Core Version:    0.7.0.1
 */