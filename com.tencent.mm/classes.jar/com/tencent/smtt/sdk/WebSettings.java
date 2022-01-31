package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings.LayoutAlgorithm;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings.PluginState;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings.RenderPriority;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings.TextSize;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings.ZoomDensity;
import com.tencent.smtt.utils.r;

public class WebSettings
{
  public static final int LOAD_CACHE_ELSE_NETWORK = 1;
  public static final int LOAD_CACHE_ONLY = 3;
  public static final int LOAD_DEFAULT = -1;
  public static final int LOAD_NORMAL = 0;
  public static final int LOAD_NO_CACHE = 2;
  private IX5WebSettings a = null;
  private android.webkit.WebSettings b = null;
  private boolean c = false;
  
  WebSettings(android.webkit.WebSettings paramWebSettings)
  {
    this.a = null;
    this.b = paramWebSettings;
    this.c = false;
  }
  
  WebSettings(IX5WebSettings paramIX5WebSettings)
  {
    this.a = paramIX5WebSettings;
    this.b = null;
    this.c = true;
  }
  
  @TargetApi(17)
  public static String getDefaultUserAgent(Context paramContext)
  {
    AppMethodBeat.i(64816);
    if (bz.a().b())
    {
      paramContext = bz.a().c().i(paramContext);
      AppMethodBeat.o(64816);
      return paramContext;
    }
    if (Build.VERSION.SDK_INT < 17)
    {
      AppMethodBeat.o(64816);
      return null;
    }
    paramContext = r.a(android.webkit.WebSettings.class, "getDefaultUserAgent", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext == null)
    {
      AppMethodBeat.o(64816);
      return null;
    }
    paramContext = (String)paramContext;
    AppMethodBeat.o(64816);
    return paramContext;
  }
  
  @Deprecated
  public boolean enableSmoothTransition()
  {
    AppMethodBeat.i(64741);
    boolean bool;
    if ((this.c) && (this.a != null))
    {
      bool = this.a.enableSmoothTransition();
      AppMethodBeat.o(64741);
      return bool;
    }
    if ((!this.c) && (this.b != null))
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        Object localObject = r.a(this.b, "enableSmoothTransition");
        if (localObject == null)
        {
          AppMethodBeat.o(64741);
          return false;
        }
        bool = ((Boolean)localObject).booleanValue();
        AppMethodBeat.o(64741);
        return bool;
      }
      AppMethodBeat.o(64741);
      return false;
    }
    AppMethodBeat.o(64741);
    return false;
  }
  
  @TargetApi(11)
  public boolean getAllowContentAccess()
  {
    AppMethodBeat.i(64737);
    boolean bool;
    if ((this.c) && (this.a != null))
    {
      bool = this.a.getAllowContentAccess();
      AppMethodBeat.o(64737);
      return bool;
    }
    if ((!this.c) && (this.b != null))
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        Object localObject = r.a(this.b, "getAllowContentAccess");
        if (localObject == null)
        {
          AppMethodBeat.o(64737);
          return false;
        }
        bool = ((Boolean)localObject).booleanValue();
        AppMethodBeat.o(64737);
        return bool;
      }
      AppMethodBeat.o(64737);
      return false;
    }
    AppMethodBeat.o(64737);
    return false;
  }
  
  @TargetApi(3)
  public boolean getAllowFileAccess()
  {
    AppMethodBeat.i(64734);
    boolean bool;
    if ((this.c) && (this.a != null))
    {
      bool = this.a.getAllowFileAccess();
      AppMethodBeat.o(64734);
      return bool;
    }
    if ((!this.c) && (this.b != null))
    {
      bool = this.b.getAllowFileAccess();
      AppMethodBeat.o(64734);
      return bool;
    }
    AppMethodBeat.o(64734);
    return false;
  }
  
  public boolean getBlockNetworkImage()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64788);
        if ((this.c) && (this.a != null))
        {
          bool = this.a.getBlockNetworkImage();
          AppMethodBeat.o(64788);
          return bool;
        }
        if ((!this.c) && (this.b != null))
        {
          bool = this.b.getBlockNetworkImage();
          AppMethodBeat.o(64788);
          continue;
        }
        boolean bool = false;
      }
      finally {}
      AppMethodBeat.o(64788);
    }
  }
  
  @TargetApi(8)
  public boolean getBlockNetworkLoads()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64790);
        if ((this.c) && (this.a != null))
        {
          bool = this.a.getBlockNetworkLoads();
          AppMethodBeat.o(64790);
          return bool;
        }
        if ((this.c) || (this.b == null)) {
          break label93;
        }
        if (Build.VERSION.SDK_INT >= 8)
        {
          bool = this.b.getBlockNetworkLoads();
          AppMethodBeat.o(64790);
          continue;
        }
        AppMethodBeat.o(64790);
      }
      finally {}
      continue;
      label93:
      AppMethodBeat.o(64790);
    }
  }
  
  @TargetApi(3)
  public boolean getBuiltInZoomControls()
  {
    AppMethodBeat.i(64730);
    boolean bool;
    if ((this.c) && (this.a != null))
    {
      bool = this.a.getBuiltInZoomControls();
      AppMethodBeat.o(64730);
      return bool;
    }
    if ((!this.c) && (this.b != null))
    {
      bool = this.b.getBuiltInZoomControls();
      AppMethodBeat.o(64730);
      return bool;
    }
    AppMethodBeat.o(64730);
    return false;
  }
  
  public int getCacheMode()
  {
    AppMethodBeat.i(64822);
    int i;
    if ((this.c) && (this.a != null))
    {
      i = this.a.getCacheMode();
      AppMethodBeat.o(64822);
      return i;
    }
    if ((!this.c) && (this.b != null))
    {
      i = this.b.getCacheMode();
      AppMethodBeat.o(64822);
      return i;
    }
    AppMethodBeat.o(64822);
    return 0;
  }
  
  public String getCursiveFontFamily()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64774);
        String str1;
        if ((this.c) && (this.a != null))
        {
          str1 = this.a.getCursiveFontFamily();
          AppMethodBeat.o(64774);
          return str1;
        }
        if ((!this.c) && (this.b != null))
        {
          str1 = this.b.getCursiveFontFamily();
          AppMethodBeat.o(64774);
          continue;
        }
        String str2 = "";
      }
      finally {}
      AppMethodBeat.o(64774);
    }
  }
  
  @TargetApi(5)
  public boolean getDatabaseEnabled()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64806);
        if ((this.c) && (this.a != null))
        {
          bool = this.a.getDatabaseEnabled();
          AppMethodBeat.o(64806);
          return bool;
        }
        if ((!this.c) && (this.b != null))
        {
          bool = this.b.getDatabaseEnabled();
          AppMethodBeat.o(64806);
          continue;
        }
        boolean bool = false;
      }
      finally {}
      AppMethodBeat.o(64806);
    }
  }
  
  @TargetApi(5)
  public String getDatabasePath()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64805);
        String str1;
        if ((this.c) && (this.a != null))
        {
          str1 = this.a.getDatabasePath();
          AppMethodBeat.o(64805);
          return str1;
        }
        if ((!this.c) && (this.b != null))
        {
          str1 = this.b.getDatabasePath();
          AppMethodBeat.o(64805);
          continue;
        }
        String str2 = "";
      }
      finally {}
      AppMethodBeat.o(64805);
    }
  }
  
  public int getDefaultFixedFontSize()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64784);
        if ((this.c) && (this.a != null))
        {
          i = this.a.getDefaultFixedFontSize();
          AppMethodBeat.o(64784);
          return i;
        }
        if ((!this.c) && (this.b != null))
        {
          i = this.b.getDefaultFixedFontSize();
          AppMethodBeat.o(64784);
          continue;
        }
        int i = 0;
      }
      finally {}
      AppMethodBeat.o(64784);
    }
  }
  
  public int getDefaultFontSize()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64782);
        if ((this.c) && (this.a != null))
        {
          i = this.a.getDefaultFontSize();
          AppMethodBeat.o(64782);
          return i;
        }
        if ((!this.c) && (this.b != null))
        {
          i = this.b.getDefaultFontSize();
          AppMethodBeat.o(64782);
          continue;
        }
        int i = 0;
      }
      finally {}
      AppMethodBeat.o(64782);
    }
  }
  
  public String getDefaultTextEncodingName()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64815);
        String str1;
        if ((this.c) && (this.a != null))
        {
          str1 = this.a.getDefaultTextEncodingName();
          AppMethodBeat.o(64815);
          return str1;
        }
        if ((!this.c) && (this.b != null))
        {
          str1 = this.b.getDefaultTextEncodingName();
          AppMethodBeat.o(64815);
          continue;
        }
        String str2 = "";
      }
      finally {}
      AppMethodBeat.o(64815);
    }
  }
  
  @TargetApi(7)
  public WebSettings.ZoomDensity getDefaultZoom()
  {
    AppMethodBeat.i(64753);
    WebSettings.ZoomDensity localZoomDensity;
    if ((this.c) && (this.a != null))
    {
      localZoomDensity = WebSettings.ZoomDensity.valueOf(this.a.getDefaultZoom().name());
      AppMethodBeat.o(64753);
      return localZoomDensity;
    }
    if ((!this.c) && (this.b != null))
    {
      localZoomDensity = WebSettings.ZoomDensity.valueOf(this.b.getDefaultZoom().name());
      AppMethodBeat.o(64753);
      return localZoomDensity;
    }
    AppMethodBeat.o(64753);
    return null;
  }
  
  public int getDisabledActionModeMenuItems()
  {
    AppMethodBeat.i(139418);
    try
    {
      int i;
      if ((this.c) && (this.a != null))
      {
        i = this.a.getDisabledActionModeMenuItems();
        AppMethodBeat.o(139418);
        return i;
      }
      if ((!this.c) && (this.b != null) && (Build.VERSION.SDK_INT >= 24))
      {
        Object localObject = r.a(this.b, "getDisabledActionModeMenuItems");
        if (localObject == null)
        {
          AppMethodBeat.o(139418);
          return 0;
        }
        i = ((Integer)localObject).intValue();
        AppMethodBeat.o(139418);
        return i;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(139418);
    }
    return 0;
  }
  
  @TargetApi(11)
  public boolean getDisplayZoomControls()
  {
    AppMethodBeat.i(64732);
    boolean bool;
    if ((this.c) && (this.a != null))
    {
      bool = this.a.getDisplayZoomControls();
      AppMethodBeat.o(64732);
      return bool;
    }
    if ((!this.c) && (this.b != null))
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        Object localObject = r.a(this.b, "getDisplayZoomControls");
        if (localObject == null)
        {
          AppMethodBeat.o(64732);
          return false;
        }
        bool = ((Boolean)localObject).booleanValue();
        AppMethodBeat.o(64732);
        return bool;
      }
      AppMethodBeat.o(64732);
      return false;
    }
    AppMethodBeat.o(64732);
    return false;
  }
  
  @TargetApi(7)
  public boolean getDomStorageEnabled()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64804);
        if ((this.c) && (this.a != null))
        {
          bool = this.a.getDomStorageEnabled();
          AppMethodBeat.o(64804);
          return bool;
        }
        if ((!this.c) && (this.b != null))
        {
          bool = this.b.getDomStorageEnabled();
          AppMethodBeat.o(64804);
          continue;
        }
        boolean bool = false;
      }
      finally {}
      AppMethodBeat.o(64804);
    }
  }
  
  public String getFantasyFontFamily()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64776);
        String str1;
        if ((this.c) && (this.a != null))
        {
          str1 = this.a.getFantasyFontFamily();
          AppMethodBeat.o(64776);
          return str1;
        }
        if ((!this.c) && (this.b != null))
        {
          str1 = this.b.getFantasyFontFamily();
          AppMethodBeat.o(64776);
          continue;
        }
        String str2 = "";
      }
      finally {}
      AppMethodBeat.o(64776);
    }
  }
  
  public String getFixedFontFamily()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64768);
        String str1;
        if ((this.c) && (this.a != null))
        {
          str1 = this.a.getFixedFontFamily();
          AppMethodBeat.o(64768);
          return str1;
        }
        if ((!this.c) && (this.b != null))
        {
          str1 = this.b.getFixedFontFamily();
          AppMethodBeat.o(64768);
          continue;
        }
        String str2 = "";
      }
      finally {}
      AppMethodBeat.o(64768);
    }
  }
  
  public boolean getJavaScriptCanOpenWindowsAutomatically()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64813);
        if ((this.c) && (this.a != null))
        {
          bool = this.a.getJavaScriptCanOpenWindowsAutomatically();
          AppMethodBeat.o(64813);
          return bool;
        }
        if ((!this.c) && (this.b != null))
        {
          bool = this.b.getJavaScriptCanOpenWindowsAutomatically();
          AppMethodBeat.o(64813);
          continue;
        }
        boolean bool = false;
      }
      finally {}
      AppMethodBeat.o(64813);
    }
  }
  
  public boolean getJavaScriptEnabled()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64808);
        if ((this.c) && (this.a != null))
        {
          bool = this.a.getJavaScriptEnabled();
          AppMethodBeat.o(64808);
          return bool;
        }
        if ((!this.c) && (this.b != null))
        {
          bool = this.b.getJavaScriptEnabled();
          AppMethodBeat.o(64808);
          continue;
        }
        boolean bool = false;
      }
      finally {}
      AppMethodBeat.o(64808);
    }
  }
  
  public WebSettings.LayoutAlgorithm getLayoutAlgorithm()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64764);
        WebSettings.LayoutAlgorithm localLayoutAlgorithm;
        if ((this.c) && (this.a != null))
        {
          localLayoutAlgorithm = WebSettings.LayoutAlgorithm.valueOf(this.a.getLayoutAlgorithm().name());
          AppMethodBeat.o(64764);
          return localLayoutAlgorithm;
        }
        if ((!this.c) && (this.b != null))
        {
          localLayoutAlgorithm = WebSettings.LayoutAlgorithm.valueOf(this.b.getLayoutAlgorithm().name());
          AppMethodBeat.o(64764);
          continue;
        }
        Object localObject2 = null;
      }
      finally {}
      AppMethodBeat.o(64764);
    }
  }
  
  public boolean getLightTouchEnabled()
  {
    AppMethodBeat.i(64755);
    boolean bool;
    if ((this.c) && (this.a != null))
    {
      bool = this.a.getLightTouchEnabled();
      AppMethodBeat.o(64755);
      return bool;
    }
    if ((!this.c) && (this.b != null))
    {
      bool = this.b.getLightTouchEnabled();
      AppMethodBeat.o(64755);
      return bool;
    }
    AppMethodBeat.o(64755);
    return false;
  }
  
  @TargetApi(7)
  public boolean getLoadWithOverviewMode()
  {
    AppMethodBeat.i(64739);
    boolean bool;
    if ((this.c) && (this.a != null))
    {
      bool = this.a.getLoadWithOverviewMode();
      AppMethodBeat.o(64739);
      return bool;
    }
    if ((!this.c) && (this.b != null))
    {
      bool = this.b.getLoadWithOverviewMode();
      AppMethodBeat.o(64739);
      return bool;
    }
    AppMethodBeat.o(64739);
    return false;
  }
  
  public boolean getLoadsImagesAutomatically()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64786);
        if ((this.c) && (this.a != null))
        {
          bool = this.a.getLoadsImagesAutomatically();
          AppMethodBeat.o(64786);
          return bool;
        }
        if ((!this.c) && (this.b != null))
        {
          bool = this.b.getLoadsImagesAutomatically();
          AppMethodBeat.o(64786);
          continue;
        }
        boolean bool = false;
      }
      finally {}
      AppMethodBeat.o(64786);
    }
  }
  
  @TargetApi(17)
  public boolean getMediaPlaybackRequiresUserGesture()
  {
    AppMethodBeat.i(64817);
    boolean bool;
    if ((this.c) && (this.a != null))
    {
      bool = this.a.getMediaPlaybackRequiresUserGesture();
      AppMethodBeat.o(64817);
      return bool;
    }
    if ((!this.c) && (this.b != null))
    {
      if (Build.VERSION.SDK_INT < 17)
      {
        AppMethodBeat.o(64817);
        return false;
      }
      Object localObject = r.a(this.b, "getMediaPlaybackRequiresUserGesture");
      if (localObject == null)
      {
        AppMethodBeat.o(64817);
        return false;
      }
      bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(64817);
      return bool;
    }
    AppMethodBeat.o(64817);
    return false;
  }
  
  public int getMinimumFontSize()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64778);
        if ((this.c) && (this.a != null))
        {
          i = this.a.getMinimumFontSize();
          AppMethodBeat.o(64778);
          return i;
        }
        if ((!this.c) && (this.b != null))
        {
          i = this.b.getMinimumFontSize();
          AppMethodBeat.o(64778);
          continue;
        }
        int i = 0;
      }
      finally {}
      AppMethodBeat.o(64778);
    }
  }
  
  public int getMinimumLogicalFontSize()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64780);
        if ((this.c) && (this.a != null))
        {
          i = this.a.getMinimumLogicalFontSize();
          AppMethodBeat.o(64780);
          return i;
        }
        if ((!this.c) && (this.b != null))
        {
          i = this.b.getMinimumLogicalFontSize();
          AppMethodBeat.o(64780);
          continue;
        }
        int i = 0;
      }
      finally {}
      AppMethodBeat.o(64780);
    }
  }
  
  /* Error */
  public int getMixedContentMode()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 294
    //   5: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 44	com/tencent/smtt/sdk/WebSettings:c	Z
    //   12: ifeq +44 -> 56
    //   15: aload_0
    //   16: getfield 40	com/tencent/smtt/sdk/WebSettings:a	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   19: astore_2
    //   20: aload_2
    //   21: ifnull +35 -> 56
    //   24: aload_0
    //   25: getfield 40	com/tencent/smtt/sdk/WebSettings:a	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   28: invokeinterface 296 1 0
    //   33: istore_1
    //   34: ldc_w 294
    //   37: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: aload_0
    //   41: monitorexit
    //   42: iload_1
    //   43: ireturn
    //   44: astore_2
    //   45: ldc_w 294
    //   48: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: iconst_m1
    //   52: istore_1
    //   53: goto -13 -> 40
    //   56: getstatic 81	android/os/Build$VERSION:SDK_INT	I
    //   59: bipush 21
    //   61: if_icmpge +14 -> 75
    //   64: ldc_w 294
    //   67: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: iconst_m1
    //   71: istore_1
    //   72: goto -32 -> 40
    //   75: aload_0
    //   76: getfield 42	com/tencent/smtt/sdk/WebSettings:b	Landroid/webkit/WebSettings;
    //   79: ldc_w 297
    //   82: iconst_0
    //   83: anewarray 86	java/lang/Class
    //   86: iconst_0
    //   87: anewarray 4	java/lang/Object
    //   90: invokestatic 300	com/tencent/smtt/utils/r:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   93: astore_2
    //   94: aload_2
    //   95: ifnonnull +14 -> 109
    //   98: ldc_w 294
    //   101: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: iconst_m1
    //   105: istore_1
    //   106: goto -66 -> 40
    //   109: aload_2
    //   110: checkcast 211	java/lang/Integer
    //   113: invokevirtual 214	java/lang/Integer:intValue	()I
    //   116: istore_1
    //   117: ldc_w 294
    //   120: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: goto -83 -> 40
    //   126: astore_2
    //   127: aload_0
    //   128: monitorexit
    //   129: aload_2
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	WebSettings
    //   33	84	1	i	int
    //   19	2	2	localIX5WebSettings	IX5WebSettings
    //   44	1	2	localThrowable	Throwable
    //   93	17	2	localObject1	Object
    //   126	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   24	34	44	java/lang/Throwable
    //   2	20	126	finally
    //   24	34	126	finally
    //   34	40	126	finally
    //   45	51	126	finally
    //   56	70	126	finally
    //   75	94	126	finally
    //   98	104	126	finally
    //   109	123	126	finally
  }
  
  public boolean getNavDump()
  {
    AppMethodBeat.i(64726);
    boolean bool;
    if ((this.c) && (this.a != null))
    {
      bool = this.a.getNavDump();
      AppMethodBeat.o(64726);
      return bool;
    }
    if ((!this.c) && (this.b != null))
    {
      Object localObject = r.a(this.b, "getNavDump");
      if (localObject == null)
      {
        AppMethodBeat.o(64726);
        return false;
      }
      bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(64726);
      return bool;
    }
    AppMethodBeat.o(64726);
    return false;
  }
  
  public boolean getOffscreenPreRaster()
  {
    AppMethodBeat.i(139419);
    try
    {
      boolean bool;
      if ((this.c) && (this.a != null))
      {
        bool = this.a.getOffscreenPreRaster();
        AppMethodBeat.o(139419);
        return bool;
      }
      if ((!this.c) && (this.b != null) && (Build.VERSION.SDK_INT >= 24))
      {
        Object localObject = r.a(this.b, "getOffscreenPreRaster");
        if (localObject == null)
        {
          AppMethodBeat.o(139419);
          return false;
        }
        bool = ((Boolean)localObject).booleanValue();
        AppMethodBeat.o(139419);
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(139419);
    }
    return false;
  }
  
  @Deprecated
  @TargetApi(8)
  public WebSettings.PluginState getPluginState()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64810);
        Object localObject1;
        if ((this.c) && (this.a != null))
        {
          localObject1 = WebSettings.PluginState.valueOf(this.a.getPluginState().name());
          AppMethodBeat.o(64810);
          return localObject1;
        }
        if ((this.c) || (this.b == null)) {
          break label132;
        }
        if (Build.VERSION.SDK_INT >= 8)
        {
          localObject1 = r.a(this.b, "getPluginState");
          if (localObject1 == null)
          {
            AppMethodBeat.o(64810);
            localObject1 = null;
            continue;
          }
          localObject1 = WebSettings.PluginState.valueOf(((android.webkit.WebSettings.PluginState)localObject1).name());
          AppMethodBeat.o(64810);
          continue;
        }
        AppMethodBeat.o(64810);
      }
      finally {}
      Object localObject3 = null;
      continue;
      label132:
      AppMethodBeat.o(64810);
      localObject3 = null;
    }
  }
  
  @Deprecated
  @TargetApi(8)
  public boolean getPluginsEnabled()
  {
    for (;;)
    {
      boolean bool;
      try
      {
        AppMethodBeat.i(64809);
        if ((this.c) && (this.a != null))
        {
          bool = this.a.getPluginsEnabled();
          AppMethodBeat.o(64809);
          return bool;
        }
        if ((this.c) || (this.b == null)) {
          break label168;
        }
        if (Build.VERSION.SDK_INT <= 17)
        {
          Object localObject1 = r.a(this.b, "getPluginsEnabled");
          if (localObject1 == null)
          {
            AppMethodBeat.o(64809);
            bool = false;
            continue;
          }
          bool = ((Boolean)localObject1).booleanValue();
          AppMethodBeat.o(64809);
          continue;
        }
        if (Build.VERSION.SDK_INT != 18) {
          break label157;
        }
      }
      finally {}
      android.webkit.WebSettings.PluginState localPluginState = this.b.getPluginState();
      if (android.webkit.WebSettings.PluginState.ON == localPluginState)
      {
        bool = true;
        AppMethodBeat.o(64809);
      }
      else
      {
        AppMethodBeat.o(64809);
        bool = false;
        continue;
        label157:
        AppMethodBeat.o(64809);
        bool = false;
        continue;
        label168:
        AppMethodBeat.o(64809);
        bool = false;
      }
    }
  }
  
  @Deprecated
  public String getPluginsPath()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64811);
        if ((this.c) && (this.a != null))
        {
          localObject1 = this.a.getPluginsPath();
          AppMethodBeat.o(64811);
          return localObject1;
        }
        if ((this.c) || (this.b == null)) {
          break label121;
        }
        if (Build.VERSION.SDK_INT > 17) {
          break label109;
        }
        Object localObject1 = r.a(this.b, "getPluginsPath");
        if (localObject1 == null)
        {
          localObject1 = null;
          AppMethodBeat.o(64811);
          continue;
        }
        str = (String)localObject2;
      }
      finally {}
      AppMethodBeat.o(64811);
      continue;
      label109:
      String str = "";
      AppMethodBeat.o(64811);
      continue;
      label121:
      str = "";
      AppMethodBeat.o(64811);
    }
  }
  
  public boolean getSafeBrowsingEnabled()
  {
    AppMethodBeat.i(139420);
    try
    {
      boolean bool;
      if ((this.c) && (this.a != null))
      {
        bool = this.a.getSafeBrowsingEnabled();
        AppMethodBeat.o(139420);
        return bool;
      }
      if ((!this.c) && (this.b != null) && (Build.VERSION.SDK_INT >= 26))
      {
        Object localObject = r.a(this.b, "getSafeBrowsingEnabled");
        if (localObject == null)
        {
          AppMethodBeat.o(139420);
          return false;
        }
        bool = ((Boolean)localObject).booleanValue();
        AppMethodBeat.o(139420);
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(139420);
    }
    return false;
  }
  
  public String getSansSerifFontFamily()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64770);
        String str1;
        if ((this.c) && (this.a != null))
        {
          str1 = this.a.getSansSerifFontFamily();
          AppMethodBeat.o(64770);
          return str1;
        }
        if ((!this.c) && (this.b != null))
        {
          str1 = this.b.getSansSerifFontFamily();
          AppMethodBeat.o(64770);
          continue;
        }
        String str2 = "";
      }
      finally {}
      AppMethodBeat.o(64770);
    }
  }
  
  public boolean getSaveFormData()
  {
    AppMethodBeat.i(64745);
    boolean bool;
    if ((this.c) && (this.a != null))
    {
      bool = this.a.getSaveFormData();
      AppMethodBeat.o(64745);
      return bool;
    }
    if ((!this.c) && (this.b != null))
    {
      bool = this.b.getSaveFormData();
      AppMethodBeat.o(64745);
      return bool;
    }
    AppMethodBeat.o(64745);
    return false;
  }
  
  public boolean getSavePassword()
  {
    AppMethodBeat.i(64747);
    boolean bool;
    if ((this.c) && (this.a != null))
    {
      bool = this.a.getSavePassword();
      AppMethodBeat.o(64747);
      return bool;
    }
    if ((!this.c) && (this.b != null))
    {
      bool = this.b.getSavePassword();
      AppMethodBeat.o(64747);
      return bool;
    }
    AppMethodBeat.o(64747);
    return false;
  }
  
  public String getSerifFontFamily()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64772);
        String str1;
        if ((this.c) && (this.a != null))
        {
          str1 = this.a.getSerifFontFamily();
          AppMethodBeat.o(64772);
          return str1;
        }
        if ((!this.c) && (this.b != null))
        {
          str1 = this.b.getSerifFontFamily();
          AppMethodBeat.o(64772);
          continue;
        }
        String str2 = "";
      }
      finally {}
      AppMethodBeat.o(64772);
    }
  }
  
  public String getStandardFontFamily()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64766);
        String str1;
        if ((this.c) && (this.a != null))
        {
          str1 = this.a.getStandardFontFamily();
          AppMethodBeat.o(64766);
          return str1;
        }
        if ((!this.c) && (this.b != null))
        {
          str1 = this.b.getStandardFontFamily();
          AppMethodBeat.o(64766);
          continue;
        }
        String str2 = "";
      }
      finally {}
      AppMethodBeat.o(64766);
    }
  }
  
  public TextSize getTextSize()
  {
    AppMethodBeat.i(64751);
    TextSize localTextSize;
    if ((this.c) && (this.a != null))
    {
      localTextSize = TextSize.valueOf(this.a.getTextSize().name());
      AppMethodBeat.o(64751);
      return localTextSize;
    }
    if ((!this.c) && (this.b != null))
    {
      localTextSize = TextSize.valueOf(this.b.getTextSize().name());
      AppMethodBeat.o(64751);
      return localTextSize;
    }
    AppMethodBeat.o(64751);
    return null;
  }
  
  /* Error */
  @TargetApi(14)
  public int getTextZoom()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 396
    //   5: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 44	com/tencent/smtt/sdk/WebSettings:c	Z
    //   12: ifeq +30 -> 42
    //   15: aload_0
    //   16: getfield 40	com/tencent/smtt/sdk/WebSettings:a	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   19: ifnull +23 -> 42
    //   22: aload_0
    //   23: getfield 40	com/tencent/smtt/sdk/WebSettings:a	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   26: invokeinterface 398 1 0
    //   31: istore_1
    //   32: ldc_w 396
    //   35: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aload_0
    //   39: monitorexit
    //   40: iload_1
    //   41: ireturn
    //   42: aload_0
    //   43: getfield 44	com/tencent/smtt/sdk/WebSettings:c	Z
    //   46: ifne +95 -> 141
    //   49: aload_0
    //   50: getfield 42	com/tencent/smtt/sdk/WebSettings:b	Landroid/webkit/WebSettings;
    //   53: ifnull +88 -> 141
    //   56: getstatic 81	android/os/Build$VERSION:SDK_INT	I
    //   59: bipush 14
    //   61: if_icmpge +14 -> 75
    //   64: ldc_w 396
    //   67: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: iconst_0
    //   71: istore_1
    //   72: goto -34 -> 38
    //   75: aload_0
    //   76: getfield 42	com/tencent/smtt/sdk/WebSettings:b	Landroid/webkit/WebSettings;
    //   79: invokevirtual 399	android/webkit/WebSettings:getTextZoom	()I
    //   82: istore_1
    //   83: ldc_w 396
    //   86: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: goto -51 -> 38
    //   92: astore_2
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_2
    //   96: athrow
    //   97: astore_2
    //   98: aload_0
    //   99: getfield 42	com/tencent/smtt/sdk/WebSettings:b	Landroid/webkit/WebSettings;
    //   102: ldc_w 400
    //   105: invokestatic 107	com/tencent/smtt/utils/r:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   108: astore_2
    //   109: aload_2
    //   110: ifnonnull +14 -> 124
    //   113: ldc_w 396
    //   116: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: iconst_0
    //   120: istore_1
    //   121: goto -83 -> 38
    //   124: aload_2
    //   125: checkcast 211	java/lang/Integer
    //   128: invokevirtual 214	java/lang/Integer:intValue	()I
    //   131: istore_1
    //   132: ldc_w 396
    //   135: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: goto -100 -> 38
    //   141: ldc_w 396
    //   144: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: iconst_0
    //   148: istore_1
    //   149: goto -111 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	WebSettings
    //   31	118	1	i	int
    //   92	4	2	localObject1	Object
    //   97	1	2	localException	Exception
    //   108	17	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	38	92	finally
    //   42	70	92	finally
    //   75	83	92	finally
    //   83	89	92	finally
    //   98	109	92	finally
    //   113	119	92	finally
    //   124	138	92	finally
    //   141	147	92	finally
    //   75	83	97	java/lang/Exception
  }
  
  @Deprecated
  public boolean getUseWebViewBackgroundForOverscrollBackground()
  {
    AppMethodBeat.i(64743);
    boolean bool;
    if ((this.c) && (this.a != null))
    {
      bool = this.a.getUseWebViewBackgroundForOverscrollBackground();
      AppMethodBeat.o(64743);
      return bool;
    }
    if ((!this.c) && (this.b != null))
    {
      Object localObject = r.a(this.b, "getUseWebViewBackgroundForOverscrollBackground");
      if (localObject == null)
      {
        AppMethodBeat.o(64743);
        return false;
      }
      bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(64743);
      return bool;
    }
    AppMethodBeat.o(64743);
    return false;
  }
  
  public boolean getUseWideViewPort()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64760);
        if ((this.c) && (this.a != null))
        {
          bool = this.a.getUseWideViewPort();
          AppMethodBeat.o(64760);
          return bool;
        }
        if ((!this.c) && (this.b != null))
        {
          bool = this.b.getUseWideViewPort();
          AppMethodBeat.o(64760);
          continue;
        }
        boolean bool = false;
      }
      finally {}
      AppMethodBeat.o(64760);
    }
  }
  
  @TargetApi(3)
  public String getUserAgentString()
  {
    AppMethodBeat.i(64757);
    String str;
    if ((this.c) && (this.a != null))
    {
      str = this.a.getUserAgentString();
      AppMethodBeat.o(64757);
      return str;
    }
    if ((!this.c) && (this.b != null))
    {
      str = this.b.getUserAgentString();
      AppMethodBeat.o(64757);
      return str;
    }
    AppMethodBeat.o(64757);
    return "";
  }
  
  @TargetApi(11)
  public void setAllowContentAccess(boolean paramBoolean)
  {
    AppMethodBeat.i(64735);
    if ((this.c) && (this.a != null))
    {
      this.a.setAllowContentAccess(paramBoolean);
      AppMethodBeat.o(64735);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      if (Build.VERSION.SDK_INT < 11)
      {
        AppMethodBeat.o(64735);
        return;
      }
      r.a(this.b, "setAllowContentAccess", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(64735);
      return;
    }
    AppMethodBeat.o(64735);
  }
  
  @TargetApi(3)
  public void setAllowFileAccess(boolean paramBoolean)
  {
    AppMethodBeat.i(64733);
    if ((this.c) && (this.a != null))
    {
      this.a.setAllowFileAccess(paramBoolean);
      AppMethodBeat.o(64733);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setAllowFileAccess(paramBoolean);
      AppMethodBeat.o(64733);
      return;
    }
    AppMethodBeat.o(64733);
  }
  
  @TargetApi(16)
  public void setAllowFileAccessFromFileURLs(boolean paramBoolean)
  {
    AppMethodBeat.i(64793);
    if ((this.c) && (this.a != null))
    {
      this.a.setAllowFileAccessFromFileURLs(paramBoolean);
      AppMethodBeat.o(64793);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      r.a(this.b, "setAllowFileAccessFromFileURLs", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(64793);
      return;
    }
    AppMethodBeat.o(64793);
  }
  
  @TargetApi(16)
  public void setAllowUniversalAccessFromFileURLs(boolean paramBoolean)
  {
    AppMethodBeat.i(64792);
    if ((this.c) && (this.a != null))
    {
      this.a.setAllowUniversalAccessFromFileURLs(paramBoolean);
      AppMethodBeat.o(64792);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      r.a(this.b, "setAllowUniversalAccessFromFileURLs", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(64792);
      return;
    }
    AppMethodBeat.o(64792);
  }
  
  @TargetApi(7)
  public void setAppCacheEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(64799);
    if ((this.c) && (this.a != null))
    {
      this.a.setAppCacheEnabled(paramBoolean);
      AppMethodBeat.o(64799);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setAppCacheEnabled(paramBoolean);
      AppMethodBeat.o(64799);
      return;
    }
    AppMethodBeat.o(64799);
  }
  
  @TargetApi(7)
  public void setAppCacheMaxSize(long paramLong)
  {
    AppMethodBeat.i(64801);
    if ((this.c) && (this.a != null))
    {
      this.a.setAppCacheMaxSize(paramLong);
      AppMethodBeat.o(64801);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setAppCacheMaxSize(paramLong);
      AppMethodBeat.o(64801);
      return;
    }
    AppMethodBeat.o(64801);
  }
  
  @TargetApi(7)
  public void setAppCachePath(String paramString)
  {
    AppMethodBeat.i(64800);
    if ((this.c) && (this.a != null))
    {
      this.a.setAppCachePath(paramString);
      AppMethodBeat.o(64800);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setAppCachePath(paramString);
      AppMethodBeat.o(64800);
      return;
    }
    AppMethodBeat.o(64800);
  }
  
  public void setBlockNetworkImage(boolean paramBoolean)
  {
    AppMethodBeat.i(64787);
    if ((this.c) && (this.a != null))
    {
      this.a.setBlockNetworkImage(paramBoolean);
      AppMethodBeat.o(64787);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setBlockNetworkImage(paramBoolean);
      AppMethodBeat.o(64787);
      return;
    }
    AppMethodBeat.o(64787);
  }
  
  @TargetApi(8)
  public void setBlockNetworkLoads(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64789);
        if ((this.c) && (this.a != null))
        {
          this.a.setBlockNetworkLoads(paramBoolean);
          AppMethodBeat.o(64789);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          if (Build.VERSION.SDK_INT < 8) {
            break label94;
          }
          this.b.setBlockNetworkLoads(paramBoolean);
          AppMethodBeat.o(64789);
          continue;
        }
        AppMethodBeat.o(64789);
      }
      finally {}
      continue;
      label94:
      AppMethodBeat.o(64789);
    }
  }
  
  @TargetApi(3)
  public void setBuiltInZoomControls(boolean paramBoolean)
  {
    AppMethodBeat.i(64729);
    if ((this.c) && (this.a != null))
    {
      this.a.setBuiltInZoomControls(paramBoolean);
      AppMethodBeat.o(64729);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setBuiltInZoomControls(paramBoolean);
      AppMethodBeat.o(64729);
      return;
    }
    AppMethodBeat.o(64729);
  }
  
  public void setCacheMode(int paramInt)
  {
    AppMethodBeat.i(64821);
    if ((this.c) && (this.a != null))
    {
      this.a.setCacheMode(paramInt);
      AppMethodBeat.o(64821);
      return;
    }
    if ((!this.c) && (this.b != null)) {
      this.b.setCacheMode(paramInt);
    }
    AppMethodBeat.o(64821);
  }
  
  public void setCursiveFontFamily(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64773);
        if ((this.c) && (this.a != null))
        {
          this.a.setCursiveFontFamily(paramString);
          AppMethodBeat.o(64773);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          this.b.setCursiveFontFamily(paramString);
          AppMethodBeat.o(64773);
        }
        else
        {
          AppMethodBeat.o(64773);
        }
      }
      finally {}
    }
  }
  
  @TargetApi(5)
  public void setDatabaseEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(64802);
    if ((this.c) && (this.a != null))
    {
      this.a.setDatabaseEnabled(paramBoolean);
      AppMethodBeat.o(64802);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setDatabaseEnabled(paramBoolean);
      AppMethodBeat.o(64802);
      return;
    }
    AppMethodBeat.o(64802);
  }
  
  @Deprecated
  @TargetApi(5)
  public void setDatabasePath(String paramString)
  {
    AppMethodBeat.i(64797);
    if ((this.c) && (this.a != null))
    {
      this.a.setDatabasePath(paramString);
      AppMethodBeat.o(64797);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      r.a(this.b, "setDatabasePath", new Class[] { String.class }, new Object[] { paramString });
      AppMethodBeat.o(64797);
      return;
    }
    AppMethodBeat.o(64797);
  }
  
  public void setDefaultFixedFontSize(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64783);
        if ((this.c) && (this.a != null))
        {
          this.a.setDefaultFixedFontSize(paramInt);
          AppMethodBeat.o(64783);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          this.b.setDefaultFixedFontSize(paramInt);
          AppMethodBeat.o(64783);
        }
        else
        {
          AppMethodBeat.o(64783);
        }
      }
      finally {}
    }
  }
  
  public void setDefaultFontSize(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64781);
        if ((this.c) && (this.a != null))
        {
          this.a.setDefaultFontSize(paramInt);
          AppMethodBeat.o(64781);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          this.b.setDefaultFontSize(paramInt);
          AppMethodBeat.o(64781);
        }
        else
        {
          AppMethodBeat.o(64781);
        }
      }
      finally {}
    }
  }
  
  public void setDefaultTextEncodingName(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64814);
        if ((this.c) && (this.a != null))
        {
          this.a.setDefaultTextEncodingName(paramString);
          AppMethodBeat.o(64814);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          this.b.setDefaultTextEncodingName(paramString);
          AppMethodBeat.o(64814);
        }
        else
        {
          AppMethodBeat.o(64814);
        }
      }
      finally {}
    }
  }
  
  @TargetApi(7)
  public void setDefaultZoom(WebSettings.ZoomDensity paramZoomDensity)
  {
    AppMethodBeat.i(64752);
    if ((this.c) && (this.a != null))
    {
      this.a.setDefaultZoom(IX5WebSettings.ZoomDensity.valueOf(paramZoomDensity.name()));
      AppMethodBeat.o(64752);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setDefaultZoom(android.webkit.WebSettings.ZoomDensity.valueOf(paramZoomDensity.name()));
      AppMethodBeat.o(64752);
      return;
    }
    AppMethodBeat.o(64752);
  }
  
  public void setDisabledActionModeMenuItems(int paramInt)
  {
    AppMethodBeat.i(139421);
    try
    {
      if ((this.c) && (this.a != null))
      {
        this.a.setDisabledActionModeMenuItems(paramInt);
        AppMethodBeat.o(139421);
        return;
      }
      if ((!this.c) && (this.b != null) && (Build.VERSION.SDK_INT >= 24)) {
        r.a(this.b, "setDisabledActionModeMenuItems", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
      }
      AppMethodBeat.o(139421);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(139421);
    }
  }
  
  @TargetApi(11)
  public void setDisplayZoomControls(boolean paramBoolean)
  {
    AppMethodBeat.i(64731);
    if ((this.c) && (this.a != null))
    {
      this.a.setDisplayZoomControls(paramBoolean);
      AppMethodBeat.o(64731);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      if (Build.VERSION.SDK_INT < 11)
      {
        AppMethodBeat.o(64731);
        return;
      }
      r.a(this.b, "setDisplayZoomControls", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(64731);
      return;
    }
    AppMethodBeat.o(64731);
  }
  
  @TargetApi(7)
  public void setDomStorageEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(64803);
    if ((this.c) && (this.a != null))
    {
      this.a.setDomStorageEnabled(paramBoolean);
      AppMethodBeat.o(64803);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setDomStorageEnabled(paramBoolean);
      AppMethodBeat.o(64803);
      return;
    }
    AppMethodBeat.o(64803);
  }
  
  @Deprecated
  @TargetApi(11)
  public void setEnableSmoothTransition(boolean paramBoolean)
  {
    AppMethodBeat.i(64740);
    if ((this.c) && (this.a != null))
    {
      this.a.setEnableSmoothTransition(paramBoolean);
      AppMethodBeat.o(64740);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        r.a(this.b, "setEnableSmoothTransition", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(64740);
      }
    }
    else
    {
      AppMethodBeat.o(64740);
      return;
    }
    AppMethodBeat.o(64740);
  }
  
  public void setFantasyFontFamily(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64775);
        if ((this.c) && (this.a != null))
        {
          this.a.setFantasyFontFamily(paramString);
          AppMethodBeat.o(64775);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          this.b.setFantasyFontFamily(paramString);
          AppMethodBeat.o(64775);
        }
        else
        {
          AppMethodBeat.o(64775);
        }
      }
      finally {}
    }
  }
  
  public void setFixedFontFamily(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64767);
        if ((this.c) && (this.a != null))
        {
          this.a.setFixedFontFamily(paramString);
          AppMethodBeat.o(64767);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          this.b.setFixedFontFamily(paramString);
          AppMethodBeat.o(64767);
        }
        else
        {
          AppMethodBeat.o(64767);
        }
      }
      finally {}
    }
  }
  
  @TargetApi(5)
  public void setGeolocationDatabasePath(String paramString)
  {
    AppMethodBeat.i(64798);
    if ((this.c) && (this.a != null))
    {
      this.a.setGeolocationDatabasePath(paramString);
      AppMethodBeat.o(64798);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setGeolocationDatabasePath(paramString);
      AppMethodBeat.o(64798);
      return;
    }
    AppMethodBeat.o(64798);
  }
  
  @TargetApi(5)
  public void setGeolocationEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(64807);
    if ((this.c) && (this.a != null))
    {
      this.a.setGeolocationEnabled(paramBoolean);
      AppMethodBeat.o(64807);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setGeolocationEnabled(paramBoolean);
      AppMethodBeat.o(64807);
      return;
    }
    AppMethodBeat.o(64807);
  }
  
  public void setJavaScriptCanOpenWindowsAutomatically(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64812);
        if ((this.c) && (this.a != null))
        {
          this.a.setJavaScriptCanOpenWindowsAutomatically(paramBoolean);
          AppMethodBeat.o(64812);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          this.b.setJavaScriptCanOpenWindowsAutomatically(paramBoolean);
          AppMethodBeat.o(64812);
        }
        else
        {
          AppMethodBeat.o(64812);
        }
      }
      finally {}
    }
  }
  
  @Deprecated
  public void setJavaScriptEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(64791);
    try
    {
      if ((this.c) && (this.a != null))
      {
        this.a.setJavaScriptEnabled(paramBoolean);
        AppMethodBeat.o(64791);
        return;
      }
      if ((!this.c) && (this.b != null))
      {
        this.b.setJavaScriptEnabled(paramBoolean);
        AppMethodBeat.o(64791);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(64791);
      return;
    }
    AppMethodBeat.o(64791);
  }
  
  public void setLayoutAlgorithm(WebSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    AppMethodBeat.i(64763);
    if ((this.c) && (this.a != null))
    {
      this.a.setLayoutAlgorithm(IX5WebSettings.LayoutAlgorithm.valueOf(paramLayoutAlgorithm.name()));
      AppMethodBeat.o(64763);
      return;
    }
    if ((!this.c) && (this.b != null)) {
      this.b.setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.valueOf(paramLayoutAlgorithm.name()));
    }
    AppMethodBeat.o(64763);
  }
  
  public void setLightTouchEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(64754);
    if ((this.c) && (this.a != null))
    {
      this.a.setLightTouchEnabled(paramBoolean);
      AppMethodBeat.o(64754);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setLightTouchEnabled(paramBoolean);
      AppMethodBeat.o(64754);
      return;
    }
    AppMethodBeat.o(64754);
  }
  
  @TargetApi(7)
  public void setLoadWithOverviewMode(boolean paramBoolean)
  {
    AppMethodBeat.i(64738);
    if ((this.c) && (this.a != null))
    {
      this.a.setLoadWithOverviewMode(paramBoolean);
      AppMethodBeat.o(64738);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setLoadWithOverviewMode(paramBoolean);
      AppMethodBeat.o(64738);
      return;
    }
    AppMethodBeat.o(64738);
  }
  
  public void setLoadsImagesAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(64785);
    if ((this.c) && (this.a != null))
    {
      this.a.setLoadsImagesAutomatically(paramBoolean);
      AppMethodBeat.o(64785);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setLoadsImagesAutomatically(paramBoolean);
      AppMethodBeat.o(64785);
      return;
    }
    AppMethodBeat.o(64785);
  }
  
  @TargetApi(17)
  public void setMediaPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(64818);
    if ((this.c) && (this.a != null))
    {
      this.a.setMediaPlaybackRequiresUserGesture(paramBoolean);
      AppMethodBeat.o(64818);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      if (Build.VERSION.SDK_INT < 17)
      {
        AppMethodBeat.o(64818);
        return;
      }
      r.a(this.b, "setMediaPlaybackRequiresUserGesture", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(64818);
      return;
    }
    AppMethodBeat.o(64818);
  }
  
  public void setMinimumFontSize(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64777);
        if ((this.c) && (this.a != null))
        {
          this.a.setMinimumFontSize(paramInt);
          AppMethodBeat.o(64777);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          this.b.setMinimumFontSize(paramInt);
          AppMethodBeat.o(64777);
        }
        else
        {
          AppMethodBeat.o(64777);
        }
      }
      finally {}
    }
  }
  
  public void setMinimumLogicalFontSize(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64779);
        if ((this.c) && (this.a != null))
        {
          this.a.setMinimumLogicalFontSize(paramInt);
          AppMethodBeat.o(64779);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          this.b.setMinimumLogicalFontSize(paramInt);
          AppMethodBeat.o(64779);
        }
        else
        {
          AppMethodBeat.o(64779);
        }
      }
      finally {}
    }
  }
  
  @TargetApi(21)
  public void setMixedContentMode(int paramInt)
  {
    AppMethodBeat.i(64736);
    if ((this.c) && (this.a != null))
    {
      AppMethodBeat.o(64736);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      if (Build.VERSION.SDK_INT < 21)
      {
        AppMethodBeat.o(64736);
        return;
      }
      r.a(this.b, "setMixedContentMode", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(64736);
      return;
    }
    AppMethodBeat.o(64736);
  }
  
  public void setNavDump(boolean paramBoolean)
  {
    AppMethodBeat.i(64724);
    if ((this.c) && (this.a != null))
    {
      this.a.setNavDump(paramBoolean);
      AppMethodBeat.o(64724);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      r.a(this.b, "setNavDump", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(64724);
      return;
    }
    AppMethodBeat.o(64724);
  }
  
  public void setNeedInitialFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(64819);
    if ((this.c) && (this.a != null))
    {
      this.a.setNeedInitialFocus(paramBoolean);
      AppMethodBeat.o(64819);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setNeedInitialFocus(paramBoolean);
      AppMethodBeat.o(64819);
      return;
    }
    AppMethodBeat.o(64819);
  }
  
  public void setOffscreenPreRaster(boolean paramBoolean)
  {
    AppMethodBeat.i(139422);
    try
    {
      if ((this.c) && (this.a != null))
      {
        this.a.setOffscreenPreRaster(paramBoolean);
        AppMethodBeat.o(139422);
        return;
      }
      if ((!this.c) && (this.b != null) && (Build.VERSION.SDK_INT >= 23)) {
        r.a(this.b, "setOffscreenPreRaster", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      }
      AppMethodBeat.o(139422);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(139422);
    }
  }
  
  @Deprecated
  @TargetApi(8)
  public void setPluginState(WebSettings.PluginState paramPluginState)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64795);
        if ((this.c) && (this.a != null))
        {
          this.a.setPluginState(IX5WebSettings.PluginState.valueOf(paramPluginState.name()));
          AppMethodBeat.o(64795);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          if (Build.VERSION.SDK_INT < 8) {
            break label129;
          }
          paramPluginState = android.webkit.WebSettings.PluginState.valueOf(paramPluginState.name());
          r.a(this.b, "setPluginState", new Class[] { android.webkit.WebSettings.PluginState.class }, new Object[] { paramPluginState });
          AppMethodBeat.o(64795);
          continue;
        }
        AppMethodBeat.o(64795);
      }
      finally {}
      continue;
      label129:
      AppMethodBeat.o(64795);
    }
  }
  
  @Deprecated
  public void setPluginsEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(64794);
    if ((this.c) && (this.a != null))
    {
      this.a.setPluginsEnabled(paramBoolean);
      AppMethodBeat.o(64794);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      r.a(this.b, "setPluginsEnabled", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(64794);
      return;
    }
    AppMethodBeat.o(64794);
  }
  
  @Deprecated
  public void setPluginsPath(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64796);
        if ((this.c) && (this.a != null))
        {
          this.a.setPluginsPath(paramString);
          AppMethodBeat.o(64796);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          r.a(this.b, "setPluginsPath", new Class[] { String.class }, new Object[] { paramString });
          AppMethodBeat.o(64796);
        }
        else
        {
          AppMethodBeat.o(64796);
        }
      }
      finally {}
    }
  }
  
  public void setRenderPriority(RenderPriority paramRenderPriority)
  {
    AppMethodBeat.i(64820);
    if ((this.c) && (this.a != null))
    {
      this.a.setRenderPriority(IX5WebSettings.RenderPriority.valueOf(paramRenderPriority.name()));
      AppMethodBeat.o(64820);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setRenderPriority(android.webkit.WebSettings.RenderPriority.valueOf(paramRenderPriority.name()));
      AppMethodBeat.o(64820);
      return;
    }
    AppMethodBeat.o(64820);
  }
  
  public void setSafeBrowsingEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(139423);
    try
    {
      if ((this.c) && (this.a != null))
      {
        this.a.setSafeBrowsingEnabled(paramBoolean);
        AppMethodBeat.o(139423);
        return;
      }
      if ((!this.c) && (this.b != null) && (Build.VERSION.SDK_INT >= 26)) {
        r.a(this.b, "setSafeBrowsingEnabled", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      }
      AppMethodBeat.o(139423);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(139423);
    }
  }
  
  public void setSansSerifFontFamily(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64769);
        if ((this.c) && (this.a != null))
        {
          this.a.setSansSerifFontFamily(paramString);
          AppMethodBeat.o(64769);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          this.b.setSansSerifFontFamily(paramString);
          AppMethodBeat.o(64769);
        }
        else
        {
          AppMethodBeat.o(64769);
        }
      }
      finally {}
    }
  }
  
  public void setSaveFormData(boolean paramBoolean)
  {
    AppMethodBeat.i(64744);
    if ((this.c) && (this.a != null))
    {
      this.a.setSaveFormData(paramBoolean);
      AppMethodBeat.o(64744);
      return;
    }
    if ((!this.c) && (this.b != null)) {
      this.b.setSaveFormData(paramBoolean);
    }
    AppMethodBeat.o(64744);
  }
  
  public void setSavePassword(boolean paramBoolean)
  {
    AppMethodBeat.i(64746);
    if ((this.c) && (this.a != null))
    {
      this.a.setSavePassword(paramBoolean);
      AppMethodBeat.o(64746);
      return;
    }
    if ((!this.c) && (this.b != null)) {
      this.b.setSavePassword(paramBoolean);
    }
    AppMethodBeat.o(64746);
  }
  
  public void setSerifFontFamily(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64771);
        if ((this.c) && (this.a != null))
        {
          this.a.setSerifFontFamily(paramString);
          AppMethodBeat.o(64771);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          this.b.setSerifFontFamily(paramString);
          AppMethodBeat.o(64771);
        }
        else
        {
          AppMethodBeat.o(64771);
        }
      }
      finally {}
    }
  }
  
  public void setStandardFontFamily(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64765);
        if ((this.c) && (this.a != null))
        {
          this.a.setStandardFontFamily(paramString);
          AppMethodBeat.o(64765);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          this.b.setStandardFontFamily(paramString);
          AppMethodBeat.o(64765);
        }
        else
        {
          AppMethodBeat.o(64765);
        }
      }
      finally {}
    }
  }
  
  public void setSupportMultipleWindows(boolean paramBoolean)
  {
    AppMethodBeat.i(64761);
    if ((this.c) && (this.a != null))
    {
      this.a.setSupportMultipleWindows(paramBoolean);
      AppMethodBeat.o(64761);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setSupportMultipleWindows(paramBoolean);
      AppMethodBeat.o(64761);
      return;
    }
    AppMethodBeat.o(64761);
  }
  
  public void setSupportZoom(boolean paramBoolean)
  {
    AppMethodBeat.i(64727);
    if ((this.c) && (this.a != null))
    {
      this.a.setSupportZoom(paramBoolean);
      AppMethodBeat.o(64727);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setSupportZoom(paramBoolean);
      AppMethodBeat.o(64727);
      return;
    }
    AppMethodBeat.o(64727);
  }
  
  public void setTextSize(TextSize paramTextSize)
  {
    AppMethodBeat.i(64750);
    if ((this.c) && (this.a != null))
    {
      this.a.setTextSize(IX5WebSettings.TextSize.valueOf(paramTextSize.name()));
      AppMethodBeat.o(64750);
      return;
    }
    if ((!this.c) && (this.b != null)) {
      this.b.setTextSize(android.webkit.WebSettings.TextSize.valueOf(paramTextSize.name()));
    }
    AppMethodBeat.o(64750);
  }
  
  @TargetApi(14)
  public void setTextZoom(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64748);
        if ((this.c) && (this.a != null))
        {
          this.a.setTextZoom(paramInt);
          AppMethodBeat.o(64748);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          if (Build.VERSION.SDK_INT < 14)
          {
            AppMethodBeat.o(64748);
            continue;
          }
          try
          {
            this.b.setTextZoom(paramInt);
            AppMethodBeat.o(64748);
          }
          catch (Exception localException)
          {
            r.a(this.b, "setTextZoom", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
          }
        }
      }
      finally {}
      AppMethodBeat.o(64748);
    }
  }
  
  @Deprecated
  public void setUseWebViewBackgroundForOverscrollBackground(boolean paramBoolean)
  {
    AppMethodBeat.i(64742);
    if ((this.c) && (this.a != null))
    {
      this.a.setUseWebViewBackgroundForOverscrollBackground(paramBoolean);
      AppMethodBeat.o(64742);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      r.a(this.b, "setUseWebViewBackgroundForOverscrollBackground", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(64742);
      return;
    }
    AppMethodBeat.o(64742);
  }
  
  public void setUseWideViewPort(boolean paramBoolean)
  {
    AppMethodBeat.i(64759);
    if ((this.c) && (this.a != null))
    {
      this.a.setUseWideViewPort(paramBoolean);
      AppMethodBeat.o(64759);
      return;
    }
    if ((!this.c) && (this.b != null)) {
      this.b.setUseWideViewPort(paramBoolean);
    }
    AppMethodBeat.o(64759);
  }
  
  public void setUserAgent(String paramString)
  {
    AppMethodBeat.i(64756);
    if ((this.c) && (this.a != null))
    {
      this.a.setUserAgent(paramString);
      AppMethodBeat.o(64756);
      return;
    }
    if ((!this.c) && (this.b != null)) {
      this.b.setUserAgentString(paramString);
    }
    AppMethodBeat.o(64756);
  }
  
  @TargetApi(3)
  public void setUserAgentString(String paramString)
  {
    AppMethodBeat.i(64758);
    if ((this.c) && (this.a != null))
    {
      this.a.setUserAgentString(paramString);
      AppMethodBeat.o(64758);
      return;
    }
    if ((!this.c) && (this.b != null)) {
      this.b.setUserAgentString(paramString);
    }
    AppMethodBeat.o(64758);
  }
  
  public boolean supportMultipleWindows()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64762);
        if ((this.c) && (this.a != null))
        {
          bool = this.a.supportMultipleWindows();
          AppMethodBeat.o(64762);
          return bool;
        }
        if ((!this.c) && (this.b != null))
        {
          bool = this.b.supportMultipleWindows();
          AppMethodBeat.o(64762);
          continue;
        }
        boolean bool = false;
      }
      finally {}
      AppMethodBeat.o(64762);
    }
  }
  
  public boolean supportZoom()
  {
    AppMethodBeat.i(64728);
    boolean bool;
    if ((this.c) && (this.a != null))
    {
      bool = this.a.supportZoom();
      AppMethodBeat.o(64728);
      return bool;
    }
    if ((!this.c) && (this.b != null))
    {
      bool = this.b.supportZoom();
      AppMethodBeat.o(64728);
      return bool;
    }
    AppMethodBeat.o(64728);
    return false;
  }
  
  public static enum RenderPriority
  {
    static
    {
      AppMethodBeat.i(64717);
      NORMAL = new RenderPriority("NORMAL", 0);
      HIGH = new RenderPriority("HIGH", 1);
      LOW = new RenderPriority("LOW", 2);
      $VALUES = new RenderPriority[] { NORMAL, HIGH, LOW };
      AppMethodBeat.o(64717);
    }
    
    private RenderPriority() {}
  }
  
  public static enum TextSize
  {
    int value;
    
    static
    {
      AppMethodBeat.i(64720);
      SMALLEST = new TextSize("SMALLEST", 0, 50);
      SMALLER = new TextSize("SMALLER", 1, 75);
      NORMAL = new TextSize("NORMAL", 2, 100);
      LARGER = new TextSize("LARGER", 3, 125);
      LARGEST = new TextSize("LARGEST", 4, 150);
      $VALUES = new TextSize[] { SMALLEST, SMALLER, NORMAL, LARGER, LARGEST };
      AppMethodBeat.o(64720);
    }
    
    private TextSize(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebSettings
 * JD-Core Version:    0.7.0.1
 */