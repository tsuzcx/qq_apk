package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5CoreEntry;
import com.tencent.smtt.export.external.interfaces.IX5CoreMessy;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings.LayoutAlgorithm;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings.PluginState;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings.RenderPriority;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings.TextSize;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings.ZoomDensity;
import com.tencent.smtt.utils.k;

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
  
  public static String getDefaultUserAgent(Context paramContext)
  {
    AppMethodBeat.i(54480);
    if (x.a().b())
    {
      paramContext = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy().getDefaultUserAgent(paramContext);
      AppMethodBeat.o(54480);
      return paramContext;
    }
    if (Build.VERSION.SDK_INT < 17)
    {
      AppMethodBeat.o(54480);
      return null;
    }
    paramContext = k.a(android.webkit.WebSettings.class, "getDefaultUserAgent", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext == null)
    {
      AppMethodBeat.o(54480);
      return null;
    }
    paramContext = (String)paramContext;
    AppMethodBeat.o(54480);
    return paramContext;
  }
  
  @Deprecated
  public boolean enableSmoothTransition()
  {
    AppMethodBeat.i(54405);
    boolean bool;
    if ((this.c) && (this.a != null))
    {
      bool = this.a.enableSmoothTransition();
      AppMethodBeat.o(54405);
      return bool;
    }
    if ((!this.c) && (this.b != null))
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        Object localObject = k.a(this.b, "enableSmoothTransition");
        if (localObject == null)
        {
          AppMethodBeat.o(54405);
          return false;
        }
        bool = ((Boolean)localObject).booleanValue();
        AppMethodBeat.o(54405);
        return bool;
      }
      AppMethodBeat.o(54405);
      return false;
    }
    AppMethodBeat.o(54405);
    return false;
  }
  
  public boolean getAllowContentAccess()
  {
    AppMethodBeat.i(54401);
    boolean bool;
    if ((this.c) && (this.a != null))
    {
      bool = this.a.getAllowContentAccess();
      AppMethodBeat.o(54401);
      return bool;
    }
    if ((!this.c) && (this.b != null))
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        Object localObject = k.a(this.b, "getAllowContentAccess");
        if (localObject == null)
        {
          AppMethodBeat.o(54401);
          return false;
        }
        bool = ((Boolean)localObject).booleanValue();
        AppMethodBeat.o(54401);
        return bool;
      }
      AppMethodBeat.o(54401);
      return false;
    }
    AppMethodBeat.o(54401);
    return false;
  }
  
  public boolean getAllowFileAccess()
  {
    AppMethodBeat.i(54398);
    boolean bool;
    if ((this.c) && (this.a != null))
    {
      bool = this.a.getAllowFileAccess();
      AppMethodBeat.o(54398);
      return bool;
    }
    if ((!this.c) && (this.b != null))
    {
      bool = this.b.getAllowFileAccess();
      AppMethodBeat.o(54398);
      return bool;
    }
    AppMethodBeat.o(54398);
    return false;
  }
  
  public boolean getBlockNetworkImage()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54452);
        if ((this.c) && (this.a != null))
        {
          bool = this.a.getBlockNetworkImage();
          AppMethodBeat.o(54452);
          return bool;
        }
        if ((!this.c) && (this.b != null))
        {
          bool = this.b.getBlockNetworkImage();
          AppMethodBeat.o(54452);
          continue;
        }
        boolean bool = false;
      }
      finally {}
      AppMethodBeat.o(54452);
    }
  }
  
  public boolean getBlockNetworkLoads()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54454);
        if ((this.c) && (this.a != null))
        {
          bool = this.a.getBlockNetworkLoads();
          AppMethodBeat.o(54454);
          return bool;
        }
        if ((this.c) || (this.b == null)) {
          break label93;
        }
        if (Build.VERSION.SDK_INT >= 8)
        {
          bool = this.b.getBlockNetworkLoads();
          AppMethodBeat.o(54454);
          continue;
        }
        AppMethodBeat.o(54454);
      }
      finally {}
      continue;
      label93:
      AppMethodBeat.o(54454);
    }
  }
  
  public boolean getBuiltInZoomControls()
  {
    AppMethodBeat.i(54394);
    boolean bool;
    if ((this.c) && (this.a != null))
    {
      bool = this.a.getBuiltInZoomControls();
      AppMethodBeat.o(54394);
      return bool;
    }
    if ((!this.c) && (this.b != null))
    {
      bool = this.b.getBuiltInZoomControls();
      AppMethodBeat.o(54394);
      return bool;
    }
    AppMethodBeat.o(54394);
    return false;
  }
  
  public int getCacheMode()
  {
    AppMethodBeat.i(54486);
    int i;
    if ((this.c) && (this.a != null))
    {
      i = this.a.getCacheMode();
      AppMethodBeat.o(54486);
      return i;
    }
    if ((!this.c) && (this.b != null))
    {
      i = this.b.getCacheMode();
      AppMethodBeat.o(54486);
      return i;
    }
    AppMethodBeat.o(54486);
    return 0;
  }
  
  public String getCursiveFontFamily()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54438);
        String str1;
        if ((this.c) && (this.a != null))
        {
          str1 = this.a.getCursiveFontFamily();
          AppMethodBeat.o(54438);
          return str1;
        }
        if ((!this.c) && (this.b != null))
        {
          str1 = this.b.getCursiveFontFamily();
          AppMethodBeat.o(54438);
          continue;
        }
        String str2 = "";
      }
      finally {}
      AppMethodBeat.o(54438);
    }
  }
  
  public boolean getDatabaseEnabled()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54470);
        if ((this.c) && (this.a != null))
        {
          bool = this.a.getDatabaseEnabled();
          AppMethodBeat.o(54470);
          return bool;
        }
        if ((!this.c) && (this.b != null))
        {
          bool = this.b.getDatabaseEnabled();
          AppMethodBeat.o(54470);
          continue;
        }
        boolean bool = false;
      }
      finally {}
      AppMethodBeat.o(54470);
    }
  }
  
  public String getDatabasePath()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54469);
        String str1;
        if ((this.c) && (this.a != null))
        {
          str1 = this.a.getDatabasePath();
          AppMethodBeat.o(54469);
          return str1;
        }
        if ((!this.c) && (this.b != null))
        {
          str1 = this.b.getDatabasePath();
          AppMethodBeat.o(54469);
          continue;
        }
        String str2 = "";
      }
      finally {}
      AppMethodBeat.o(54469);
    }
  }
  
  public int getDefaultFixedFontSize()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54448);
        if ((this.c) && (this.a != null))
        {
          i = this.a.getDefaultFixedFontSize();
          AppMethodBeat.o(54448);
          return i;
        }
        if ((!this.c) && (this.b != null))
        {
          i = this.b.getDefaultFixedFontSize();
          AppMethodBeat.o(54448);
          continue;
        }
        int i = 0;
      }
      finally {}
      AppMethodBeat.o(54448);
    }
  }
  
  public int getDefaultFontSize()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54446);
        if ((this.c) && (this.a != null))
        {
          i = this.a.getDefaultFontSize();
          AppMethodBeat.o(54446);
          return i;
        }
        if ((!this.c) && (this.b != null))
        {
          i = this.b.getDefaultFontSize();
          AppMethodBeat.o(54446);
          continue;
        }
        int i = 0;
      }
      finally {}
      AppMethodBeat.o(54446);
    }
  }
  
  public String getDefaultTextEncodingName()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54479);
        String str1;
        if ((this.c) && (this.a != null))
        {
          str1 = this.a.getDefaultTextEncodingName();
          AppMethodBeat.o(54479);
          return str1;
        }
        if ((!this.c) && (this.b != null))
        {
          str1 = this.b.getDefaultTextEncodingName();
          AppMethodBeat.o(54479);
          continue;
        }
        String str2 = "";
      }
      finally {}
      AppMethodBeat.o(54479);
    }
  }
  
  public WebSettings.ZoomDensity getDefaultZoom()
  {
    AppMethodBeat.i(54417);
    WebSettings.ZoomDensity localZoomDensity;
    if ((this.c) && (this.a != null))
    {
      localZoomDensity = WebSettings.ZoomDensity.valueOf(this.a.getDefaultZoom().name());
      AppMethodBeat.o(54417);
      return localZoomDensity;
    }
    if ((!this.c) && (this.b != null))
    {
      localZoomDensity = WebSettings.ZoomDensity.valueOf(this.b.getDefaultZoom().name());
      AppMethodBeat.o(54417);
      return localZoomDensity;
    }
    AppMethodBeat.o(54417);
    return null;
  }
  
  public boolean getDisplayZoomControls()
  {
    AppMethodBeat.i(54396);
    boolean bool;
    if ((this.c) && (this.a != null))
    {
      bool = this.a.getDisplayZoomControls();
      AppMethodBeat.o(54396);
      return bool;
    }
    if ((!this.c) && (this.b != null))
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        Object localObject = k.a(this.b, "getDisplayZoomControls");
        if (localObject == null)
        {
          AppMethodBeat.o(54396);
          return false;
        }
        bool = ((Boolean)localObject).booleanValue();
        AppMethodBeat.o(54396);
        return bool;
      }
      AppMethodBeat.o(54396);
      return false;
    }
    AppMethodBeat.o(54396);
    return false;
  }
  
  public boolean getDomStorageEnabled()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54468);
        if ((this.c) && (this.a != null))
        {
          bool = this.a.getDomStorageEnabled();
          AppMethodBeat.o(54468);
          return bool;
        }
        if ((!this.c) && (this.b != null))
        {
          bool = this.b.getDomStorageEnabled();
          AppMethodBeat.o(54468);
          continue;
        }
        boolean bool = false;
      }
      finally {}
      AppMethodBeat.o(54468);
    }
  }
  
  public String getFantasyFontFamily()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54440);
        String str1;
        if ((this.c) && (this.a != null))
        {
          str1 = this.a.getFantasyFontFamily();
          AppMethodBeat.o(54440);
          return str1;
        }
        if ((!this.c) && (this.b != null))
        {
          str1 = this.b.getFantasyFontFamily();
          AppMethodBeat.o(54440);
          continue;
        }
        String str2 = "";
      }
      finally {}
      AppMethodBeat.o(54440);
    }
  }
  
  public String getFixedFontFamily()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54432);
        String str1;
        if ((this.c) && (this.a != null))
        {
          str1 = this.a.getFixedFontFamily();
          AppMethodBeat.o(54432);
          return str1;
        }
        if ((!this.c) && (this.b != null))
        {
          str1 = this.b.getFixedFontFamily();
          AppMethodBeat.o(54432);
          continue;
        }
        String str2 = "";
      }
      finally {}
      AppMethodBeat.o(54432);
    }
  }
  
  public boolean getJavaScriptCanOpenWindowsAutomatically()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54477);
        if ((this.c) && (this.a != null))
        {
          bool = this.a.getJavaScriptCanOpenWindowsAutomatically();
          AppMethodBeat.o(54477);
          return bool;
        }
        if ((!this.c) && (this.b != null))
        {
          bool = this.b.getJavaScriptCanOpenWindowsAutomatically();
          AppMethodBeat.o(54477);
          continue;
        }
        boolean bool = false;
      }
      finally {}
      AppMethodBeat.o(54477);
    }
  }
  
  public boolean getJavaScriptEnabled()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54472);
        if ((this.c) && (this.a != null))
        {
          bool = this.a.getJavaScriptEnabled();
          AppMethodBeat.o(54472);
          return bool;
        }
        if ((!this.c) && (this.b != null))
        {
          bool = this.b.getJavaScriptEnabled();
          AppMethodBeat.o(54472);
          continue;
        }
        boolean bool = false;
      }
      finally {}
      AppMethodBeat.o(54472);
    }
  }
  
  public WebSettings.LayoutAlgorithm getLayoutAlgorithm()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54428);
        WebSettings.LayoutAlgorithm localLayoutAlgorithm;
        if ((this.c) && (this.a != null))
        {
          localLayoutAlgorithm = WebSettings.LayoutAlgorithm.valueOf(this.a.getLayoutAlgorithm().name());
          AppMethodBeat.o(54428);
          return localLayoutAlgorithm;
        }
        if ((!this.c) && (this.b != null))
        {
          localLayoutAlgorithm = WebSettings.LayoutAlgorithm.valueOf(this.b.getLayoutAlgorithm().name());
          AppMethodBeat.o(54428);
          continue;
        }
        Object localObject2 = null;
      }
      finally {}
      AppMethodBeat.o(54428);
    }
  }
  
  public boolean getLightTouchEnabled()
  {
    AppMethodBeat.i(54419);
    boolean bool;
    if ((this.c) && (this.a != null))
    {
      bool = this.a.getLightTouchEnabled();
      AppMethodBeat.o(54419);
      return bool;
    }
    if ((!this.c) && (this.b != null))
    {
      bool = this.b.getLightTouchEnabled();
      AppMethodBeat.o(54419);
      return bool;
    }
    AppMethodBeat.o(54419);
    return false;
  }
  
  public boolean getLoadWithOverviewMode()
  {
    AppMethodBeat.i(54403);
    boolean bool;
    if ((this.c) && (this.a != null))
    {
      bool = this.a.getLoadWithOverviewMode();
      AppMethodBeat.o(54403);
      return bool;
    }
    if ((!this.c) && (this.b != null))
    {
      bool = this.b.getLoadWithOverviewMode();
      AppMethodBeat.o(54403);
      return bool;
    }
    AppMethodBeat.o(54403);
    return false;
  }
  
  public boolean getLoadsImagesAutomatically()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54450);
        if ((this.c) && (this.a != null))
        {
          bool = this.a.getLoadsImagesAutomatically();
          AppMethodBeat.o(54450);
          return bool;
        }
        if ((!this.c) && (this.b != null))
        {
          bool = this.b.getLoadsImagesAutomatically();
          AppMethodBeat.o(54450);
          continue;
        }
        boolean bool = false;
      }
      finally {}
      AppMethodBeat.o(54450);
    }
  }
  
  public boolean getMediaPlaybackRequiresUserGesture()
  {
    AppMethodBeat.i(54481);
    boolean bool;
    if ((this.c) && (this.a != null))
    {
      bool = this.a.getMediaPlaybackRequiresUserGesture();
      AppMethodBeat.o(54481);
      return bool;
    }
    if ((!this.c) && (this.b != null))
    {
      if (Build.VERSION.SDK_INT < 17)
      {
        AppMethodBeat.o(54481);
        return false;
      }
      Object localObject = k.a(this.b, "getMediaPlaybackRequiresUserGesture");
      if (localObject == null)
      {
        AppMethodBeat.o(54481);
        return false;
      }
      bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(54481);
      return bool;
    }
    AppMethodBeat.o(54481);
    return false;
  }
  
  public int getMinimumFontSize()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54442);
        if ((this.c) && (this.a != null))
        {
          i = this.a.getMinimumFontSize();
          AppMethodBeat.o(54442);
          return i;
        }
        if ((!this.c) && (this.b != null))
        {
          i = this.b.getMinimumFontSize();
          AppMethodBeat.o(54442);
          continue;
        }
        int i = 0;
      }
      finally {}
      AppMethodBeat.o(54442);
    }
  }
  
  public int getMinimumLogicalFontSize()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54444);
        if ((this.c) && (this.a != null))
        {
          i = this.a.getMinimumLogicalFontSize();
          AppMethodBeat.o(54444);
          return i;
        }
        if ((!this.c) && (this.b != null))
        {
          i = this.b.getMinimumLogicalFontSize();
          AppMethodBeat.o(54444);
          continue;
        }
        int i = 0;
      }
      finally {}
      AppMethodBeat.o(54444);
    }
  }
  
  /* Error */
  public int getMixedContentMode()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 281
    //   5: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 42	com/tencent/smtt/sdk/WebSettings:c	Z
    //   12: ifeq +44 -> 56
    //   15: aload_0
    //   16: getfield 38	com/tencent/smtt/sdk/WebSettings:a	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   19: astore_2
    //   20: aload_2
    //   21: ifnull +35 -> 56
    //   24: aload_0
    //   25: getfield 38	com/tencent/smtt/sdk/WebSettings:a	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   28: invokeinterface 283 1 0
    //   33: istore_1
    //   34: ldc_w 281
    //   37: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: aload_0
    //   41: monitorexit
    //   42: iload_1
    //   43: ireturn
    //   44: astore_2
    //   45: ldc_w 281
    //   48: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: iconst_m1
    //   52: istore_1
    //   53: goto -13 -> 40
    //   56: getstatic 85	android/os/Build$VERSION:SDK_INT	I
    //   59: bipush 21
    //   61: if_icmpge +14 -> 75
    //   64: ldc_w 281
    //   67: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: iconst_m1
    //   71: istore_1
    //   72: goto -32 -> 40
    //   75: aload_0
    //   76: getfield 40	com/tencent/smtt/sdk/WebSettings:b	Landroid/webkit/WebSettings;
    //   79: ldc_w 284
    //   82: iconst_0
    //   83: anewarray 90	java/lang/Class
    //   86: iconst_0
    //   87: anewarray 4	java/lang/Object
    //   90: invokestatic 287	com/tencent/smtt/utils/k:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   93: astore_2
    //   94: aload_2
    //   95: ifnonnull +14 -> 109
    //   98: ldc_w 281
    //   101: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: iconst_m1
    //   105: istore_1
    //   106: goto -66 -> 40
    //   109: aload_2
    //   110: checkcast 289	java/lang/Integer
    //   113: invokevirtual 292	java/lang/Integer:intValue	()I
    //   116: istore_1
    //   117: ldc_w 281
    //   120: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   44	1	2	localObject1	Object
    //   93	17	2	localObject2	Object
    //   126	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   24	34	44	finally
    //   2	20	126	finally
    //   34	40	126	finally
    //   45	51	126	finally
    //   56	70	126	finally
    //   75	94	126	finally
    //   98	104	126	finally
    //   109	123	126	finally
  }
  
  public boolean getNavDump()
  {
    AppMethodBeat.i(54390);
    boolean bool;
    if ((this.c) && (this.a != null))
    {
      bool = this.a.getNavDump();
      AppMethodBeat.o(54390);
      return bool;
    }
    if ((!this.c) && (this.b != null))
    {
      Object localObject = k.a(this.b, "getNavDump");
      if (localObject == null)
      {
        AppMethodBeat.o(54390);
        return false;
      }
      bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(54390);
      return bool;
    }
    AppMethodBeat.o(54390);
    return false;
  }
  
  @Deprecated
  public WebSettings.PluginState getPluginState()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54474);
        Object localObject1;
        if ((this.c) && (this.a != null))
        {
          localObject1 = WebSettings.PluginState.valueOf(this.a.getPluginState().name());
          AppMethodBeat.o(54474);
          return localObject1;
        }
        if ((this.c) || (this.b == null)) {
          break label132;
        }
        if (Build.VERSION.SDK_INT >= 8)
        {
          localObject1 = k.a(this.b, "getPluginState");
          if (localObject1 == null)
          {
            AppMethodBeat.o(54474);
            localObject1 = null;
            continue;
          }
          localObject1 = WebSettings.PluginState.valueOf(((android.webkit.WebSettings.PluginState)localObject1).name());
          AppMethodBeat.o(54474);
          continue;
        }
        AppMethodBeat.o(54474);
      }
      finally {}
      Object localObject3 = null;
      continue;
      label132:
      AppMethodBeat.o(54474);
      localObject3 = null;
    }
  }
  
  @Deprecated
  public boolean getPluginsEnabled()
  {
    for (;;)
    {
      boolean bool;
      try
      {
        AppMethodBeat.i(54473);
        if ((this.c) && (this.a != null))
        {
          bool = this.a.getPluginsEnabled();
          AppMethodBeat.o(54473);
          return bool;
        }
        if ((this.c) || (this.b == null)) {
          break label168;
        }
        if (Build.VERSION.SDK_INT <= 17)
        {
          Object localObject1 = k.a(this.b, "getPluginsEnabled");
          if (localObject1 == null)
          {
            AppMethodBeat.o(54473);
            bool = false;
            continue;
          }
          bool = ((Boolean)localObject1).booleanValue();
          AppMethodBeat.o(54473);
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
        AppMethodBeat.o(54473);
      }
      else
      {
        AppMethodBeat.o(54473);
        bool = false;
        continue;
        label157:
        AppMethodBeat.o(54473);
        bool = false;
        continue;
        label168:
        AppMethodBeat.o(54473);
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
        AppMethodBeat.i(54475);
        if ((this.c) && (this.a != null))
        {
          localObject1 = this.a.getPluginsPath();
          AppMethodBeat.o(54475);
          return localObject1;
        }
        if ((this.c) || (this.b == null)) {
          break label121;
        }
        if (Build.VERSION.SDK_INT > 17) {
          break label109;
        }
        Object localObject1 = k.a(this.b, "getPluginsPath");
        if (localObject1 == null)
        {
          localObject1 = null;
          AppMethodBeat.o(54475);
          continue;
        }
        str = (String)localObject2;
      }
      finally {}
      AppMethodBeat.o(54475);
      continue;
      label109:
      String str = "";
      AppMethodBeat.o(54475);
      continue;
      label121:
      str = "";
      AppMethodBeat.o(54475);
    }
  }
  
  public String getSansSerifFontFamily()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54434);
        String str1;
        if ((this.c) && (this.a != null))
        {
          str1 = this.a.getSansSerifFontFamily();
          AppMethodBeat.o(54434);
          return str1;
        }
        if ((!this.c) && (this.b != null))
        {
          str1 = this.b.getSansSerifFontFamily();
          AppMethodBeat.o(54434);
          continue;
        }
        String str2 = "";
      }
      finally {}
      AppMethodBeat.o(54434);
    }
  }
  
  public boolean getSaveFormData()
  {
    AppMethodBeat.i(54409);
    boolean bool;
    if ((this.c) && (this.a != null))
    {
      bool = this.a.getSaveFormData();
      AppMethodBeat.o(54409);
      return bool;
    }
    if ((!this.c) && (this.b != null))
    {
      bool = this.b.getSaveFormData();
      AppMethodBeat.o(54409);
      return bool;
    }
    AppMethodBeat.o(54409);
    return false;
  }
  
  public boolean getSavePassword()
  {
    AppMethodBeat.i(54411);
    boolean bool;
    if ((this.c) && (this.a != null))
    {
      bool = this.a.getSavePassword();
      AppMethodBeat.o(54411);
      return bool;
    }
    if ((!this.c) && (this.b != null))
    {
      bool = this.b.getSavePassword();
      AppMethodBeat.o(54411);
      return bool;
    }
    AppMethodBeat.o(54411);
    return false;
  }
  
  public String getSerifFontFamily()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54436);
        String str1;
        if ((this.c) && (this.a != null))
        {
          str1 = this.a.getSerifFontFamily();
          AppMethodBeat.o(54436);
          return str1;
        }
        if ((!this.c) && (this.b != null))
        {
          str1 = this.b.getSerifFontFamily();
          AppMethodBeat.o(54436);
          continue;
        }
        String str2 = "";
      }
      finally {}
      AppMethodBeat.o(54436);
    }
  }
  
  public String getStandardFontFamily()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54430);
        String str1;
        if ((this.c) && (this.a != null))
        {
          str1 = this.a.getStandardFontFamily();
          AppMethodBeat.o(54430);
          return str1;
        }
        if ((!this.c) && (this.b != null))
        {
          str1 = this.b.getStandardFontFamily();
          AppMethodBeat.o(54430);
          continue;
        }
        String str2 = "";
      }
      finally {}
      AppMethodBeat.o(54430);
    }
  }
  
  public WebSettings.TextSize getTextSize()
  {
    AppMethodBeat.i(54415);
    WebSettings.TextSize localTextSize;
    if ((this.c) && (this.a != null))
    {
      localTextSize = WebSettings.TextSize.valueOf(this.a.getTextSize().name());
      AppMethodBeat.o(54415);
      return localTextSize;
    }
    if ((!this.c) && (this.b != null))
    {
      localTextSize = WebSettings.TextSize.valueOf(this.b.getTextSize().name());
      AppMethodBeat.o(54415);
      return localTextSize;
    }
    AppMethodBeat.o(54415);
    return null;
  }
  
  /* Error */
  public int getTextZoom()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 377
    //   5: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 42	com/tencent/smtt/sdk/WebSettings:c	Z
    //   12: ifeq +30 -> 42
    //   15: aload_0
    //   16: getfield 38	com/tencent/smtt/sdk/WebSettings:a	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   19: ifnull +23 -> 42
    //   22: aload_0
    //   23: getfield 38	com/tencent/smtt/sdk/WebSettings:a	Lcom/tencent/smtt/export/external/interfaces/IX5WebSettings;
    //   26: invokeinterface 379 1 0
    //   31: istore_1
    //   32: ldc_w 377
    //   35: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aload_0
    //   39: monitorexit
    //   40: iload_1
    //   41: ireturn
    //   42: aload_0
    //   43: getfield 42	com/tencent/smtt/sdk/WebSettings:c	Z
    //   46: ifne +95 -> 141
    //   49: aload_0
    //   50: getfield 40	com/tencent/smtt/sdk/WebSettings:b	Landroid/webkit/WebSettings;
    //   53: ifnull +88 -> 141
    //   56: getstatic 85	android/os/Build$VERSION:SDK_INT	I
    //   59: bipush 14
    //   61: if_icmpge +14 -> 75
    //   64: ldc_w 377
    //   67: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: iconst_0
    //   71: istore_1
    //   72: goto -34 -> 38
    //   75: aload_0
    //   76: getfield 40	com/tencent/smtt/sdk/WebSettings:b	Landroid/webkit/WebSettings;
    //   79: invokevirtual 380	android/webkit/WebSettings:getTextZoom	()I
    //   82: istore_1
    //   83: ldc_w 377
    //   86: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: goto -51 -> 38
    //   92: astore_2
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_2
    //   96: athrow
    //   97: astore_2
    //   98: aload_0
    //   99: getfield 40	com/tencent/smtt/sdk/WebSettings:b	Landroid/webkit/WebSettings;
    //   102: ldc_w 381
    //   105: invokestatic 110	com/tencent/smtt/utils/k:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   108: astore_2
    //   109: aload_2
    //   110: ifnonnull +14 -> 124
    //   113: ldc_w 377
    //   116: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: iconst_0
    //   120: istore_1
    //   121: goto -83 -> 38
    //   124: aload_2
    //   125: checkcast 289	java/lang/Integer
    //   128: invokevirtual 292	java/lang/Integer:intValue	()I
    //   131: istore_1
    //   132: ldc_w 377
    //   135: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: goto -100 -> 38
    //   141: ldc_w 377
    //   144: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(54407);
    boolean bool;
    if ((this.c) && (this.a != null))
    {
      bool = this.a.getUseWebViewBackgroundForOverscrollBackground();
      AppMethodBeat.o(54407);
      return bool;
    }
    if ((!this.c) && (this.b != null))
    {
      Object localObject = k.a(this.b, "getUseWebViewBackgroundForOverscrollBackground");
      if (localObject == null)
      {
        AppMethodBeat.o(54407);
        return false;
      }
      bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(54407);
      return bool;
    }
    AppMethodBeat.o(54407);
    return false;
  }
  
  public boolean getUseWideViewPort()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54424);
        if ((this.c) && (this.a != null))
        {
          bool = this.a.getUseWideViewPort();
          AppMethodBeat.o(54424);
          return bool;
        }
        if ((!this.c) && (this.b != null))
        {
          bool = this.b.getUseWideViewPort();
          AppMethodBeat.o(54424);
          continue;
        }
        boolean bool = false;
      }
      finally {}
      AppMethodBeat.o(54424);
    }
  }
  
  public String getUserAgentString()
  {
    AppMethodBeat.i(54421);
    String str;
    if ((this.c) && (this.a != null))
    {
      str = this.a.getUserAgentString();
      AppMethodBeat.o(54421);
      return str;
    }
    if ((!this.c) && (this.b != null))
    {
      str = this.b.getUserAgentString();
      AppMethodBeat.o(54421);
      return str;
    }
    AppMethodBeat.o(54421);
    return "";
  }
  
  public void setAllowContentAccess(boolean paramBoolean)
  {
    AppMethodBeat.i(54399);
    if ((this.c) && (this.a != null))
    {
      this.a.setAllowContentAccess(paramBoolean);
      AppMethodBeat.o(54399);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      if (Build.VERSION.SDK_INT < 11)
      {
        AppMethodBeat.o(54399);
        return;
      }
      k.a(this.b, "setAllowContentAccess", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(54399);
      return;
    }
    AppMethodBeat.o(54399);
  }
  
  public void setAllowFileAccess(boolean paramBoolean)
  {
    AppMethodBeat.i(54397);
    if ((this.c) && (this.a != null))
    {
      this.a.setAllowFileAccess(paramBoolean);
      AppMethodBeat.o(54397);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setAllowFileAccess(paramBoolean);
      AppMethodBeat.o(54397);
      return;
    }
    AppMethodBeat.o(54397);
  }
  
  public void setAllowFileAccessFromFileURLs(boolean paramBoolean)
  {
    AppMethodBeat.i(54457);
    if ((this.c) && (this.a != null))
    {
      this.a.setAllowFileAccessFromFileURLs(paramBoolean);
      AppMethodBeat.o(54457);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      k.a(this.b, "setAllowFileAccessFromFileURLs", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(54457);
      return;
    }
    AppMethodBeat.o(54457);
  }
  
  public void setAllowUniversalAccessFromFileURLs(boolean paramBoolean)
  {
    AppMethodBeat.i(54456);
    if ((this.c) && (this.a != null))
    {
      this.a.setAllowUniversalAccessFromFileURLs(paramBoolean);
      AppMethodBeat.o(54456);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      k.a(this.b, "setAllowUniversalAccessFromFileURLs", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(54456);
      return;
    }
    AppMethodBeat.o(54456);
  }
  
  public void setAppCacheEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(54463);
    if ((this.c) && (this.a != null))
    {
      this.a.setAppCacheEnabled(paramBoolean);
      AppMethodBeat.o(54463);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setAppCacheEnabled(paramBoolean);
      AppMethodBeat.o(54463);
      return;
    }
    AppMethodBeat.o(54463);
  }
  
  public void setAppCacheMaxSize(long paramLong)
  {
    AppMethodBeat.i(54465);
    if ((this.c) && (this.a != null))
    {
      this.a.setAppCacheMaxSize(paramLong);
      AppMethodBeat.o(54465);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setAppCacheMaxSize(paramLong);
      AppMethodBeat.o(54465);
      return;
    }
    AppMethodBeat.o(54465);
  }
  
  public void setAppCachePath(String paramString)
  {
    AppMethodBeat.i(54464);
    if ((this.c) && (this.a != null))
    {
      this.a.setAppCachePath(paramString);
      AppMethodBeat.o(54464);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setAppCachePath(paramString);
      AppMethodBeat.o(54464);
      return;
    }
    AppMethodBeat.o(54464);
  }
  
  public void setBlockNetworkImage(boolean paramBoolean)
  {
    AppMethodBeat.i(54451);
    if ((this.c) && (this.a != null))
    {
      this.a.setBlockNetworkImage(paramBoolean);
      AppMethodBeat.o(54451);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setBlockNetworkImage(paramBoolean);
      AppMethodBeat.o(54451);
      return;
    }
    AppMethodBeat.o(54451);
  }
  
  public void setBlockNetworkLoads(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54453);
        if ((this.c) && (this.a != null))
        {
          this.a.setBlockNetworkLoads(paramBoolean);
          AppMethodBeat.o(54453);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          if (Build.VERSION.SDK_INT < 8) {
            break label94;
          }
          this.b.setBlockNetworkLoads(paramBoolean);
          AppMethodBeat.o(54453);
          continue;
        }
        AppMethodBeat.o(54453);
      }
      finally {}
      continue;
      label94:
      AppMethodBeat.o(54453);
    }
  }
  
  public void setBuiltInZoomControls(boolean paramBoolean)
  {
    AppMethodBeat.i(54393);
    if ((this.c) && (this.a != null))
    {
      this.a.setBuiltInZoomControls(paramBoolean);
      AppMethodBeat.o(54393);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setBuiltInZoomControls(paramBoolean);
      AppMethodBeat.o(54393);
      return;
    }
    AppMethodBeat.o(54393);
  }
  
  public void setCacheMode(int paramInt)
  {
    AppMethodBeat.i(54485);
    if ((this.c) && (this.a != null))
    {
      this.a.setCacheMode(paramInt);
      AppMethodBeat.o(54485);
      return;
    }
    if ((!this.c) && (this.b != null)) {
      this.b.setCacheMode(paramInt);
    }
    AppMethodBeat.o(54485);
  }
  
  public void setCursiveFontFamily(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54437);
        if ((this.c) && (this.a != null))
        {
          this.a.setCursiveFontFamily(paramString);
          AppMethodBeat.o(54437);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          this.b.setCursiveFontFamily(paramString);
          AppMethodBeat.o(54437);
        }
        else
        {
          AppMethodBeat.o(54437);
        }
      }
      finally {}
    }
  }
  
  public void setDatabaseEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(54466);
    if ((this.c) && (this.a != null))
    {
      this.a.setDatabaseEnabled(paramBoolean);
      AppMethodBeat.o(54466);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setDatabaseEnabled(paramBoolean);
      AppMethodBeat.o(54466);
      return;
    }
    AppMethodBeat.o(54466);
  }
  
  @Deprecated
  public void setDatabasePath(String paramString)
  {
    AppMethodBeat.i(54461);
    if ((this.c) && (this.a != null))
    {
      this.a.setDatabasePath(paramString);
      AppMethodBeat.o(54461);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      k.a(this.b, "setDatabasePath", new Class[] { String.class }, new Object[] { paramString });
      AppMethodBeat.o(54461);
      return;
    }
    AppMethodBeat.o(54461);
  }
  
  public void setDefaultFixedFontSize(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54447);
        if ((this.c) && (this.a != null))
        {
          this.a.setDefaultFixedFontSize(paramInt);
          AppMethodBeat.o(54447);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          this.b.setDefaultFixedFontSize(paramInt);
          AppMethodBeat.o(54447);
        }
        else
        {
          AppMethodBeat.o(54447);
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
        AppMethodBeat.i(54445);
        if ((this.c) && (this.a != null))
        {
          this.a.setDefaultFontSize(paramInt);
          AppMethodBeat.o(54445);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          this.b.setDefaultFontSize(paramInt);
          AppMethodBeat.o(54445);
        }
        else
        {
          AppMethodBeat.o(54445);
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
        AppMethodBeat.i(54478);
        if ((this.c) && (this.a != null))
        {
          this.a.setDefaultTextEncodingName(paramString);
          AppMethodBeat.o(54478);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          this.b.setDefaultTextEncodingName(paramString);
          AppMethodBeat.o(54478);
        }
        else
        {
          AppMethodBeat.o(54478);
        }
      }
      finally {}
    }
  }
  
  public void setDefaultZoom(WebSettings.ZoomDensity paramZoomDensity)
  {
    AppMethodBeat.i(54416);
    if ((this.c) && (this.a != null))
    {
      this.a.setDefaultZoom(IX5WebSettings.ZoomDensity.valueOf(paramZoomDensity.name()));
      AppMethodBeat.o(54416);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setDefaultZoom(android.webkit.WebSettings.ZoomDensity.valueOf(paramZoomDensity.name()));
      AppMethodBeat.o(54416);
      return;
    }
    AppMethodBeat.o(54416);
  }
  
  public void setDisplayZoomControls(boolean paramBoolean)
  {
    AppMethodBeat.i(54395);
    if ((this.c) && (this.a != null))
    {
      this.a.setDisplayZoomControls(paramBoolean);
      AppMethodBeat.o(54395);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      if (Build.VERSION.SDK_INT < 11)
      {
        AppMethodBeat.o(54395);
        return;
      }
      k.a(this.b, "setDisplayZoomControls", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(54395);
      return;
    }
    AppMethodBeat.o(54395);
  }
  
  public void setDomStorageEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(54467);
    if ((this.c) && (this.a != null))
    {
      this.a.setDomStorageEnabled(paramBoolean);
      AppMethodBeat.o(54467);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setDomStorageEnabled(paramBoolean);
      AppMethodBeat.o(54467);
      return;
    }
    AppMethodBeat.o(54467);
  }
  
  @Deprecated
  public void setEnableSmoothTransition(boolean paramBoolean)
  {
    AppMethodBeat.i(54404);
    if ((this.c) && (this.a != null))
    {
      this.a.setEnableSmoothTransition(paramBoolean);
      AppMethodBeat.o(54404);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        k.a(this.b, "setEnableSmoothTransition", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(54404);
      }
    }
    else
    {
      AppMethodBeat.o(54404);
      return;
    }
    AppMethodBeat.o(54404);
  }
  
  public void setFantasyFontFamily(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54439);
        if ((this.c) && (this.a != null))
        {
          this.a.setFantasyFontFamily(paramString);
          AppMethodBeat.o(54439);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          this.b.setFantasyFontFamily(paramString);
          AppMethodBeat.o(54439);
        }
        else
        {
          AppMethodBeat.o(54439);
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
        AppMethodBeat.i(54431);
        if ((this.c) && (this.a != null))
        {
          this.a.setFixedFontFamily(paramString);
          AppMethodBeat.o(54431);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          this.b.setFixedFontFamily(paramString);
          AppMethodBeat.o(54431);
        }
        else
        {
          AppMethodBeat.o(54431);
        }
      }
      finally {}
    }
  }
  
  public void setGeolocationDatabasePath(String paramString)
  {
    AppMethodBeat.i(54462);
    if ((this.c) && (this.a != null))
    {
      this.a.setGeolocationDatabasePath(paramString);
      AppMethodBeat.o(54462);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setGeolocationDatabasePath(paramString);
      AppMethodBeat.o(54462);
      return;
    }
    AppMethodBeat.o(54462);
  }
  
  public void setGeolocationEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(54471);
    if ((this.c) && (this.a != null))
    {
      this.a.setGeolocationEnabled(paramBoolean);
      AppMethodBeat.o(54471);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setGeolocationEnabled(paramBoolean);
      AppMethodBeat.o(54471);
      return;
    }
    AppMethodBeat.o(54471);
  }
  
  public void setJavaScriptCanOpenWindowsAutomatically(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54476);
        if ((this.c) && (this.a != null))
        {
          this.a.setJavaScriptCanOpenWindowsAutomatically(paramBoolean);
          AppMethodBeat.o(54476);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          this.b.setJavaScriptCanOpenWindowsAutomatically(paramBoolean);
          AppMethodBeat.o(54476);
        }
        else
        {
          AppMethodBeat.o(54476);
        }
      }
      finally {}
    }
  }
  
  @Deprecated
  public void setJavaScriptEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(54455);
    try
    {
      if ((this.c) && (this.a != null))
      {
        this.a.setJavaScriptEnabled(paramBoolean);
        AppMethodBeat.o(54455);
        return;
      }
      if ((!this.c) && (this.b != null)) {
        this.b.setJavaScriptEnabled(paramBoolean);
      }
    }
    finally
    {
      AppMethodBeat.o(54455);
      return;
    }
    AppMethodBeat.o(54455);
  }
  
  public void setLayoutAlgorithm(WebSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    AppMethodBeat.i(54427);
    if ((this.c) && (this.a != null))
    {
      this.a.setLayoutAlgorithm(IX5WebSettings.LayoutAlgorithm.valueOf(paramLayoutAlgorithm.name()));
      AppMethodBeat.o(54427);
      return;
    }
    if ((!this.c) && (this.b != null)) {
      this.b.setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.valueOf(paramLayoutAlgorithm.name()));
    }
    AppMethodBeat.o(54427);
  }
  
  public void setLightTouchEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(54418);
    if ((this.c) && (this.a != null))
    {
      this.a.setLightTouchEnabled(paramBoolean);
      AppMethodBeat.o(54418);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setLightTouchEnabled(paramBoolean);
      AppMethodBeat.o(54418);
      return;
    }
    AppMethodBeat.o(54418);
  }
  
  public void setLoadWithOverviewMode(boolean paramBoolean)
  {
    AppMethodBeat.i(54402);
    if ((this.c) && (this.a != null))
    {
      this.a.setLoadWithOverviewMode(paramBoolean);
      AppMethodBeat.o(54402);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setLoadWithOverviewMode(paramBoolean);
      AppMethodBeat.o(54402);
      return;
    }
    AppMethodBeat.o(54402);
  }
  
  public void setLoadsImagesAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(54449);
    if ((this.c) && (this.a != null))
    {
      this.a.setLoadsImagesAutomatically(paramBoolean);
      AppMethodBeat.o(54449);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setLoadsImagesAutomatically(paramBoolean);
      AppMethodBeat.o(54449);
      return;
    }
    AppMethodBeat.o(54449);
  }
  
  public void setMediaPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(54482);
    if ((this.c) && (this.a != null))
    {
      this.a.setMediaPlaybackRequiresUserGesture(paramBoolean);
      AppMethodBeat.o(54482);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      if (Build.VERSION.SDK_INT < 17)
      {
        AppMethodBeat.o(54482);
        return;
      }
      k.a(this.b, "setMediaPlaybackRequiresUserGesture", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(54482);
      return;
    }
    AppMethodBeat.o(54482);
  }
  
  public void setMinimumFontSize(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54441);
        if ((this.c) && (this.a != null))
        {
          this.a.setMinimumFontSize(paramInt);
          AppMethodBeat.o(54441);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          this.b.setMinimumFontSize(paramInt);
          AppMethodBeat.o(54441);
        }
        else
        {
          AppMethodBeat.o(54441);
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
        AppMethodBeat.i(54443);
        if ((this.c) && (this.a != null))
        {
          this.a.setMinimumLogicalFontSize(paramInt);
          AppMethodBeat.o(54443);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          this.b.setMinimumLogicalFontSize(paramInt);
          AppMethodBeat.o(54443);
        }
        else
        {
          AppMethodBeat.o(54443);
        }
      }
      finally {}
    }
  }
  
  public void setMixedContentMode(int paramInt)
  {
    AppMethodBeat.i(54400);
    if ((this.c) && (this.a != null))
    {
      AppMethodBeat.o(54400);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      if (Build.VERSION.SDK_INT < 21)
      {
        AppMethodBeat.o(54400);
        return;
      }
      k.a(this.b, "setMixedContentMode", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(54400);
      return;
    }
    AppMethodBeat.o(54400);
  }
  
  public void setNavDump(boolean paramBoolean)
  {
    AppMethodBeat.i(54388);
    if ((this.c) && (this.a != null))
    {
      this.a.setNavDump(paramBoolean);
      AppMethodBeat.o(54388);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      k.a(this.b, "setNavDump", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(54388);
      return;
    }
    AppMethodBeat.o(54388);
  }
  
  public void setNeedInitialFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(54483);
    if ((this.c) && (this.a != null))
    {
      this.a.setNeedInitialFocus(paramBoolean);
      AppMethodBeat.o(54483);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setNeedInitialFocus(paramBoolean);
      AppMethodBeat.o(54483);
      return;
    }
    AppMethodBeat.o(54483);
  }
  
  @Deprecated
  public void setPluginState(WebSettings.PluginState paramPluginState)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54459);
        if ((this.c) && (this.a != null))
        {
          this.a.setPluginState(IX5WebSettings.PluginState.valueOf(paramPluginState.name()));
          AppMethodBeat.o(54459);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          if (Build.VERSION.SDK_INT < 8) {
            break label129;
          }
          paramPluginState = android.webkit.WebSettings.PluginState.valueOf(paramPluginState.name());
          k.a(this.b, "setPluginState", new Class[] { android.webkit.WebSettings.PluginState.class }, new Object[] { paramPluginState });
          AppMethodBeat.o(54459);
          continue;
        }
        AppMethodBeat.o(54459);
      }
      finally {}
      continue;
      label129:
      AppMethodBeat.o(54459);
    }
  }
  
  @Deprecated
  public void setPluginsEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(54458);
    if ((this.c) && (this.a != null))
    {
      this.a.setPluginsEnabled(paramBoolean);
      AppMethodBeat.o(54458);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      k.a(this.b, "setPluginsEnabled", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(54458);
      return;
    }
    AppMethodBeat.o(54458);
  }
  
  @Deprecated
  public void setPluginsPath(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54460);
        if ((this.c) && (this.a != null))
        {
          this.a.setPluginsPath(paramString);
          AppMethodBeat.o(54460);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          k.a(this.b, "setPluginsPath", new Class[] { String.class }, new Object[] { paramString });
          AppMethodBeat.o(54460);
        }
        else
        {
          AppMethodBeat.o(54460);
        }
      }
      finally {}
    }
  }
  
  public void setRenderPriority(WebSettings.RenderPriority paramRenderPriority)
  {
    AppMethodBeat.i(54484);
    if ((this.c) && (this.a != null))
    {
      this.a.setRenderPriority(IX5WebSettings.RenderPriority.valueOf(paramRenderPriority.name()));
      AppMethodBeat.o(54484);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setRenderPriority(android.webkit.WebSettings.RenderPriority.valueOf(paramRenderPriority.name()));
      AppMethodBeat.o(54484);
      return;
    }
    AppMethodBeat.o(54484);
  }
  
  public void setSansSerifFontFamily(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54433);
        if ((this.c) && (this.a != null))
        {
          this.a.setSansSerifFontFamily(paramString);
          AppMethodBeat.o(54433);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          this.b.setSansSerifFontFamily(paramString);
          AppMethodBeat.o(54433);
        }
        else
        {
          AppMethodBeat.o(54433);
        }
      }
      finally {}
    }
  }
  
  public void setSaveFormData(boolean paramBoolean)
  {
    AppMethodBeat.i(54408);
    if ((this.c) && (this.a != null))
    {
      this.a.setSaveFormData(paramBoolean);
      AppMethodBeat.o(54408);
      return;
    }
    if ((!this.c) && (this.b != null)) {
      this.b.setSaveFormData(paramBoolean);
    }
    AppMethodBeat.o(54408);
  }
  
  public void setSavePassword(boolean paramBoolean)
  {
    AppMethodBeat.i(54410);
    if ((this.c) && (this.a != null))
    {
      this.a.setSavePassword(paramBoolean);
      AppMethodBeat.o(54410);
      return;
    }
    if ((!this.c) && (this.b != null)) {
      this.b.setSavePassword(paramBoolean);
    }
    AppMethodBeat.o(54410);
  }
  
  public void setSerifFontFamily(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54435);
        if ((this.c) && (this.a != null))
        {
          this.a.setSerifFontFamily(paramString);
          AppMethodBeat.o(54435);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          this.b.setSerifFontFamily(paramString);
          AppMethodBeat.o(54435);
        }
        else
        {
          AppMethodBeat.o(54435);
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
        AppMethodBeat.i(54429);
        if ((this.c) && (this.a != null))
        {
          this.a.setStandardFontFamily(paramString);
          AppMethodBeat.o(54429);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          this.b.setStandardFontFamily(paramString);
          AppMethodBeat.o(54429);
        }
        else
        {
          AppMethodBeat.o(54429);
        }
      }
      finally {}
    }
  }
  
  public void setSupportMultipleWindows(boolean paramBoolean)
  {
    AppMethodBeat.i(54425);
    if ((this.c) && (this.a != null))
    {
      this.a.setSupportMultipleWindows(paramBoolean);
      AppMethodBeat.o(54425);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setSupportMultipleWindows(paramBoolean);
      AppMethodBeat.o(54425);
      return;
    }
    AppMethodBeat.o(54425);
  }
  
  public void setSupportZoom(boolean paramBoolean)
  {
    AppMethodBeat.i(54391);
    if ((this.c) && (this.a != null))
    {
      this.a.setSupportZoom(paramBoolean);
      AppMethodBeat.o(54391);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      this.b.setSupportZoom(paramBoolean);
      AppMethodBeat.o(54391);
      return;
    }
    AppMethodBeat.o(54391);
  }
  
  public void setTextSize(WebSettings.TextSize paramTextSize)
  {
    AppMethodBeat.i(54414);
    if ((this.c) && (this.a != null))
    {
      this.a.setTextSize(IX5WebSettings.TextSize.valueOf(paramTextSize.name()));
      AppMethodBeat.o(54414);
      return;
    }
    if ((!this.c) && (this.b != null)) {
      this.b.setTextSize(android.webkit.WebSettings.TextSize.valueOf(paramTextSize.name()));
    }
    AppMethodBeat.o(54414);
  }
  
  public void setTextZoom(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54412);
        if ((this.c) && (this.a != null))
        {
          this.a.setTextZoom(paramInt);
          AppMethodBeat.o(54412);
          return;
        }
        if ((!this.c) && (this.b != null))
        {
          if (Build.VERSION.SDK_INT < 14)
          {
            AppMethodBeat.o(54412);
            continue;
          }
          try
          {
            this.b.setTextZoom(paramInt);
            AppMethodBeat.o(54412);
          }
          catch (Exception localException)
          {
            k.a(this.b, "setTextZoom", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
          }
        }
      }
      finally {}
      AppMethodBeat.o(54412);
    }
  }
  
  @Deprecated
  public void setUseWebViewBackgroundForOverscrollBackground(boolean paramBoolean)
  {
    AppMethodBeat.i(54406);
    if ((this.c) && (this.a != null))
    {
      this.a.setUseWebViewBackgroundForOverscrollBackground(paramBoolean);
      AppMethodBeat.o(54406);
      return;
    }
    if ((!this.c) && (this.b != null))
    {
      k.a(this.b, "setUseWebViewBackgroundForOverscrollBackground", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(54406);
      return;
    }
    AppMethodBeat.o(54406);
  }
  
  public void setUseWideViewPort(boolean paramBoolean)
  {
    AppMethodBeat.i(54423);
    if ((this.c) && (this.a != null))
    {
      this.a.setUseWideViewPort(paramBoolean);
      AppMethodBeat.o(54423);
      return;
    }
    if ((!this.c) && (this.b != null)) {
      this.b.setUseWideViewPort(paramBoolean);
    }
    AppMethodBeat.o(54423);
  }
  
  public void setUserAgent(String paramString)
  {
    AppMethodBeat.i(54420);
    if ((this.c) && (this.a != null))
    {
      this.a.setUserAgent(paramString);
      AppMethodBeat.o(54420);
      return;
    }
    if ((!this.c) && (this.b != null)) {
      this.b.setUserAgentString(paramString);
    }
    AppMethodBeat.o(54420);
  }
  
  public void setUserAgentString(String paramString)
  {
    AppMethodBeat.i(54422);
    if ((this.c) && (this.a != null))
    {
      this.a.setUserAgentString(paramString);
      AppMethodBeat.o(54422);
      return;
    }
    if ((!this.c) && (this.b != null)) {
      this.b.setUserAgentString(paramString);
    }
    AppMethodBeat.o(54422);
  }
  
  public boolean supportMultipleWindows()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54426);
        if ((this.c) && (this.a != null))
        {
          bool = this.a.supportMultipleWindows();
          AppMethodBeat.o(54426);
          return bool;
        }
        if ((!this.c) && (this.b != null))
        {
          bool = this.b.supportMultipleWindows();
          AppMethodBeat.o(54426);
          continue;
        }
        boolean bool = false;
      }
      finally {}
      AppMethodBeat.o(54426);
    }
  }
  
  public boolean supportZoom()
  {
    AppMethodBeat.i(54392);
    boolean bool;
    if ((this.c) && (this.a != null))
    {
      bool = this.a.supportZoom();
      AppMethodBeat.o(54392);
      return bool;
    }
    if ((!this.c) && (this.b != null))
    {
      bool = this.b.supportZoom();
      AppMethodBeat.o(54392);
      return bool;
    }
    AppMethodBeat.o(54392);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebSettings
 * JD-Core Version:    0.7.0.1
 */