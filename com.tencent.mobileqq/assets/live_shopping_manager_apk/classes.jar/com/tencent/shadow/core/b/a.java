package com.tencent.shadow.core.b;

import android.content.ContentValues;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.shadow.core.b.a.b;
import com.tencent.shadow.core.b.a.c;
import com.tencent.shadow.core.b.a.d;
import com.tencent.shadow.core.b.a.e;
import com.tencent.shadow.core.b.a.e.a;
import com.tencent.shadow.core.b.a.f;
import com.tencent.shadow.core.b.a.i;
import com.tencent.shadow.core.b.a.l;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
import java.io.File;

public abstract class a
{
  private static final Logger c = LoggerFactory.getLogger(a.class);
  public Context a;
  protected Handler b = new Handler(Looper.getMainLooper());
  private l d;
  private d e;
  
  public a(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    this.d = new l(this.a.getFilesDir(), a());
    this.e = new d(new f(this.a, a()));
  }
  
  protected e.a a(String paramString, int paramInt)
  {
    Log.i("InstalledDao", "getLoaderOrRunTimePart ");
    if ((paramInt != 3) && (paramInt != 4))
    {
      paramString = new StringBuilder();
      paramString.append("不支持的type:");
      paramString.append(paramInt);
      throw new RuntimeException(paramString.toString());
    }
    paramString = this.e.a(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("installedPlugin hashCode = ");
    localStringBuilder.append(paramString.hashCode());
    Log.i("InstalledDao", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("runtimeFile = ");
    localStringBuilder.append(paramString.d.toString());
    Log.i("InstalledDao", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("pluginLoaderFile = ");
    localStringBuilder.append(paramString.c.toString());
    Log.i("InstalledDao", localStringBuilder.toString());
    if (paramInt == 4)
    {
      if (paramString.d != null) {
        return paramString.d;
      }
    }
    else if ((paramInt == 3) && (paramString.c != null)) {
      return paramString.c;
    }
    Log.i("InstalledDao", "throw 没有找到Part type");
    paramString = new StringBuilder();
    paramString.append("没有找到Part type :");
    paramString.append(paramInt);
    throw new RuntimeException(paramString.toString());
  }
  
  protected e.a a(String paramString1, String paramString2)
  {
    paramString1 = this.e.a(paramString1);
    if (paramString1 != null) {
      return paramString1.a(paramString2);
    }
    paramString1 = new StringBuilder();
    paramString1.append("没有找到Part partKey:");
    paramString1.append(paramString2);
    throw new RuntimeException(paramString1.toString());
  }
  
  public final e a(File paramFile, String paramString)
  {
    paramFile = this.d.b(paramString, paramFile);
    return this.e.a(paramFile);
  }
  
  protected abstract String a();
  
  public String b()
  {
    return null;
  }
  
  public final void b(String paramString, int paramInt)
  {
    e.a locala = a(paramString, paramInt);
    for (;;)
    {
      try
      {
        Object localObject2 = com.tencent.shadow.core.b.a.a.b(this.d.a(), paramString);
        if (paramInt == 3)
        {
          localObject1 = "loader";
          localObject1 = i.a(locala.b, (File)localObject2, com.tencent.shadow.core.b.a.a.c((File)localObject2, (String)localObject1));
          localObject2 = new ContentValues();
          ((ContentValues)localObject2).put("odexPath", ((File)localObject1).getAbsolutePath());
          this.e.a(paramString, paramInt, (ContentValues)localObject2);
          locala.c = ((File)localObject1);
          return;
        }
      }
      catch (c paramString)
      {
        if (c.isErrorEnabled()) {
          c.error("oDexPluginLoaderOrRunTime exception:", paramString);
        }
        throw paramString;
      }
      Object localObject1 = "runtime";
    }
  }
  
  public final void b(String paramString1, String paramString2)
  {
    e.a locala = a(paramString1, paramString2);
    try
    {
      File localFile = com.tencent.shadow.core.b.a.a.b(this.d.a(), paramString1);
      localFile = i.a(locala.b, localFile, com.tencent.shadow.core.b.a.a.c(localFile, paramString2));
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("odexPath", localFile.getAbsolutePath());
      this.e.a(paramString1, paramString2, localContentValues);
      locala.c = localFile;
      return;
    }
    catch (c paramString1)
    {
      if (c.isErrorEnabled()) {
        c.error("oDexPlugin exception:", paramString1);
      }
      throw paramString1;
    }
  }
  
  public final void c(String paramString1, String paramString2)
  {
    e.a locala = a(paramString1, paramString2);
    try
    {
      File localFile = this.d.a();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("lib/");
      ((StringBuilder)localObject).append(b());
      ((StringBuilder)localObject).append("/");
      localObject = ((StringBuilder)localObject).toString();
      localFile = com.tencent.shadow.core.b.a.a.d(localFile, paramString1);
      localFile = b.a(locala.b, localFile, com.tencent.shadow.core.b.a.a.e(localFile, paramString2), (String)localObject);
      localObject = new ContentValues();
      ((ContentValues)localObject).put("libPath", localFile.getAbsolutePath());
      this.e.a(paramString1, paramString2, (ContentValues)localObject);
      locala.d = localFile;
      return;
    }
    catch (c paramString1)
    {
      if (c.isErrorEnabled()) {
        c.error("extractSo exception:", paramString1);
      }
      throw paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\live_shopping_manager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.core.b.a
 * JD-Core Version:    0.7.0.1
 */