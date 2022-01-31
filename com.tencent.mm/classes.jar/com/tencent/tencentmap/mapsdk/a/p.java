package com.tencent.tencentmap.mapsdk.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.jk;
import com.tencent.tencentmap.mapsdk.maps.a.ka;
import java.io.File;

public class p
{
  private static p a = null;
  private Context b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  
  private p(Context paramContext)
  {
    AppMethodBeat.i(147053);
    if (paramContext == null)
    {
      paramContext = new Error("context can not be null");
      AppMethodBeat.o(147053);
      throw paramContext;
    }
    this.b = paramContext.getApplicationContext();
    String str1 = b(paramContext);
    String str2 = jk.a(this.b);
    if (StringUtil.isEmpty(str2)) {}
    for (this.c = (str1 + "/tencentmapsdk/");; this.c = (str1 + "/tencentmapsdk/" + str2))
    {
      this.d = (this.c + "/data/v3/render/");
      this.e = (this.c + "/sat/");
      this.j = paramContext.getFilesDir().getAbsolutePath();
      this.g = (this.j + "/tencentMapSdk/config/");
      this.k = (this.g + "temp/");
      this.h = (this.j + "/tencentMapSdk/assets/");
      this.i = (this.j + "/tencentMapSdk/dynamicAssets/");
      this.f = (this.d + "closeRoadDatas/");
      a(paramContext, u.a(paramContext).a("sdkVersion"));
      AppMethodBeat.o(147053);
      return;
    }
  }
  
  @SuppressLint({"NewApi"})
  public static long a(String paramString)
  {
    AppMethodBeat.i(147057);
    try
    {
      paramString = new StatFs(paramString);
      long l2;
      if (Build.VERSION.SDK_INT < 18) {
        l2 = paramString.getBlockSize();
      }
      for (long l1 = paramString.getAvailableBlocks();; l1 = paramString.getAvailableBlocksLong())
      {
        l1 = l1 * l2 / 1024L / 1024L;
        AppMethodBeat.o(147057);
        return l1;
        l2 = paramString.getBlockSizeLong();
      }
      return 0L;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(147057);
    }
  }
  
  public static p a(Context paramContext)
  {
    AppMethodBeat.i(147054);
    if (a == null) {
      a = new p(paramContext);
    }
    paramContext = a;
    AppMethodBeat.o(147054);
    return paramContext;
  }
  
  public static String b(Context paramContext)
  {
    int i2 = 0;
    AppMethodBeat.i(147056);
    boolean bool = Environment.getExternalStorageState().equals("mounted");
    int n;
    int m;
    if (Build.VERSION.SDK_INT >= 23)
    {
      n = paramContext.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", Process.myPid(), Process.myUid());
      m = paramContext.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid());
    }
    for (;;)
    {
      int i1 = i2;
      if (n == 0)
      {
        i1 = i2;
        if (m == 0) {
          i1 = 1;
        }
      }
      Object localObject;
      if ((!bool) || (i1 == 0)) {
        localObject = paramContext.getFilesDir().getPath();
      }
      for (;;)
      {
        AppMethodBeat.o(147056);
        return localObject;
        String str = Environment.getExternalStorageDirectory().getPath();
        localObject = str;
        if (a(str) < 5L)
        {
          paramContext = paramContext.getFilesDir().getPath();
          localObject = paramContext;
          if (a(paramContext) < 5L) {
            localObject = Environment.getExternalStorageDirectory().getPath();
          }
        }
      }
      m = 0;
      n = 0;
    }
  }
  
  public File a()
  {
    AppMethodBeat.i(147058);
    File localFile = new File(this.c + "/data/");
    AppMethodBeat.o(147058);
    return localFile;
  }
  
  public void a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(147055);
    if (StringUtil.isEmpty(u.a(paramContext).a("sdkVersion")))
    {
      AppMethodBeat.o(147055);
      return;
    }
    if (ka.b("4.1.0", paramString) > 0)
    {
      s.a(paramContext);
      jk.a(new File(this.g));
      jk.a(new File(this.h));
      jk.a(new File(this.j + "/tencentMapSdk/subKey/"));
    }
    AppMethodBeat.o(147055);
  }
  
  public String b()
  {
    return this.d;
  }
  
  public String b(String paramString)
  {
    AppMethodBeat.i(147059);
    if (StringUtil.isEmpty(paramString))
    {
      paramString = this.g;
      AppMethodBeat.o(147059);
      return paramString;
    }
    paramString = this.j + "/tencentMapSdk/subKey/" + paramString + "/config/";
    AppMethodBeat.o(147059);
    return paramString;
  }
  
  public String c()
  {
    return this.e;
  }
  
  public String c(String paramString)
  {
    AppMethodBeat.i(147060);
    if (StringUtil.isEmpty(paramString))
    {
      paramString = this.h;
      AppMethodBeat.o(147060);
      return paramString;
    }
    paramString = this.j + "/tencentMapSdk/subKey/" + paramString + "/assets/";
    AppMethodBeat.o(147060);
    return paramString;
  }
  
  public String d()
  {
    return this.f;
  }
  
  public String d(String paramString)
  {
    AppMethodBeat.i(147061);
    if (StringUtil.isEmpty(paramString))
    {
      paramString = this.k;
      AppMethodBeat.o(147061);
      return paramString;
    }
    paramString = b(paramString) + "temp/";
    AppMethodBeat.o(147061);
    return paramString;
  }
  
  public String e()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.p
 * JD-Core Version:    0.7.0.1
 */