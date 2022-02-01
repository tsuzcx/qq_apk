package com.tencent.smtt.export.external.X5Graphics;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.LibraryLoader;
import com.tencent.smtt.export.external.libwebp;
import java.io.File;
import java.util.HashMap;

public class GraphicsLib
{
  public static final int LOAD_STATUS_FAIL = 1;
  public static final int LOAD_STATUS_GRAPHICS_LINK_ERR = 3;
  public static final int LOAD_STATUS_WEBP_LINK_ERR = 2;
  private static final String LOGTAG = "[X5Graphics]";
  private static String sGraphicsLibPath;
  private static boolean sHasSetGraphicsPath = false;
  private static String sSharpPLibPath;
  private static X5Graphics.SoThinker sThinker = null;
  private static boolean sWebpLibIsLoadSuccess = false;
  
  static
  {
    sGraphicsLibPath = null;
    sSharpPLibPath = null;
  }
  
  public static String getGraphicsLibPath()
  {
    return sGraphicsLibPath;
  }
  
  public static String getThinkerLibPath(String paramString)
  {
    AppMethodBeat.i(53168);
    String str = null;
    if (sThinker != null) {
      str = sThinker.path(paramString + File.separator + "libwebp_base.so");
    }
    AppMethodBeat.o(53168);
    return str;
  }
  
  public static boolean init(Context paramContext, String paramString)
  {
    AppMethodBeat.i(53165);
    boolean bool = init(paramContext, paramString, null, null);
    AppMethodBeat.o(53165);
    return bool;
  }
  
  public static boolean init(Context paramContext, String paramString, X5Graphics.SoThinker paramSoThinker, X5Graphics.IBeacon paramIBeacon)
  {
    AppMethodBeat.i(53164);
    new StringBuilder("init()  path=").append(paramString).append(" ;thinker=").append(paramSoThinker);
    if (!X5Graphics.isEnable())
    {
      paramContext = new Error("X5Graphics is diable");
      AppMethodBeat.o(53164);
      throw paramContext;
    }
    sThinker = paramSoThinker;
    boolean bool;
    if (paramString != null)
    {
      bool = loadWepLibraryIfNeed(paramContext, paramString);
      if (!bool) {
        break label161;
      }
    }
    for (;;)
    {
      try
      {
        setGraphicsLibPath(paramString);
        AppMethodBeat.o(53164);
        return bool;
      }
      catch (Throwable paramString)
      {
        paramSoThinker = new HashMap();
        paramSoThinker.put("status", Integer.toString(3));
      }
      paramString = LibraryLoader.getNativeLibraryDir(paramContext);
      bool = loadWepLibraryIfNeed(paramContext);
      break;
      try
      {
        libwebp.getInstance(paramContext).getInfo(null, null, null);
        if (paramIBeacon != null) {
          paramIBeacon.report("X5Graphics", paramSoThinker);
        }
        AppMethodBeat.o(53164);
        throw paramString;
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          paramSoThinker.put("status", Integer.toString(2));
        }
      }
      label161:
      paramContext = new HashMap();
      paramContext.put("status", Integer.toString(1));
      if (paramIBeacon != null) {
        paramIBeacon.report("X5Graphics", paramContext);
      }
    }
  }
  
  /* Error */
  public static boolean loadWepLibraryIfNeed(Context paramContext)
  {
    // Byte code:
    //   0: ldc 154
    //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 26	com/tencent/smtt/export/external/X5Graphics/GraphicsLib:sWebpLibIsLoadSuccess	Z
    //   8: ifeq +14 -> 22
    //   11: getstatic 26	com/tencent/smtt/export/external/X5Graphics/GraphicsLib:sWebpLibIsLoadSuccess	Z
    //   14: istore_1
    //   15: ldc 154
    //   17: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: iload_1
    //   21: ireturn
    //   22: ldc 2
    //   24: monitorenter
    //   25: getstatic 26	com/tencent/smtt/export/external/X5Graphics/GraphicsLib:sWebpLibIsLoadSuccess	Z
    //   28: ifeq +17 -> 45
    //   31: getstatic 26	com/tencent/smtt/export/external/X5Graphics/GraphicsLib:sWebpLibIsLoadSuccess	Z
    //   34: istore_1
    //   35: ldc 2
    //   37: monitorexit
    //   38: ldc 154
    //   40: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: iload_1
    //   44: ireturn
    //   45: aload_0
    //   46: ldc 156
    //   48: invokestatic 160	com/tencent/smtt/export/external/LibraryLoader:loadLibrary	(Landroid/content/Context;Ljava/lang/String;)V
    //   51: iconst_1
    //   52: putstatic 26	com/tencent/smtt/export/external/X5Graphics/GraphicsLib:sWebpLibIsLoadSuccess	Z
    //   55: invokestatic 162	com/tencent/smtt/export/external/X5Graphics/GraphicsLib:getGraphicsLibPath	()Ljava/lang/String;
    //   58: ifnonnull +10 -> 68
    //   61: aload_0
    //   62: invokestatic 116	com/tencent/smtt/export/external/LibraryLoader:getNativeLibraryDir	(Landroid/content/Context;)Ljava/lang/String;
    //   65: invokestatic 110	com/tencent/smtt/export/external/X5Graphics/GraphicsLib:setGraphicsLibPath	(Ljava/lang/String;)V
    //   68: ldc 2
    //   70: monitorexit
    //   71: getstatic 26	com/tencent/smtt/export/external/X5Graphics/GraphicsLib:sWebpLibIsLoadSuccess	Z
    //   74: istore_1
    //   75: ldc 154
    //   77: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: iload_1
    //   81: ireturn
    //   82: astore_0
    //   83: ldc 2
    //   85: monitorexit
    //   86: ldc 154
    //   88: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload_0
    //   92: athrow
    //   93: astore_0
    //   94: goto -26 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	paramContext	Context
    //   14	67	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   25	38	82	finally
    //   45	68	82	finally
    //   68	71	82	finally
    //   83	86	82	finally
    //   45	68	93	java/lang/UnsatisfiedLinkError
  }
  
  public static boolean loadWepLibraryIfNeed(Context paramContext, String paramString)
  {
    AppMethodBeat.i(53169);
    boolean bool;
    if (sWebpLibIsLoadSuccess)
    {
      bool = sWebpLibIsLoadSuccess;
      AppMethodBeat.o(53169);
      return bool;
    }
    for (;;)
    {
      try
      {
        if (sWebpLibIsLoadSuccess)
        {
          bool = sWebpLibIsLoadSuccess;
          return bool;
        }
        paramContext = null;
        try
        {
          if (sThinker != null) {
            paramContext = sThinker.path(paramString + File.separator + "libwebp_base.so");
          }
          if ((paramContext != null) && (!TextUtils.isEmpty(paramContext))) {
            continue;
          }
          System.load(paramString + File.separator + "libwebp_base.so");
          sWebpLibIsLoadSuccess = true;
          if (getGraphicsLibPath() == null) {
            setGraphicsLibPath(paramString);
          }
        }
        catch (UnsatisfiedLinkError paramContext)
        {
          new StringBuilder("Load WebP Library Error...: libwebp.java - loadWepLibraryIfNeed()").append(paramContext.getMessage());
          continue;
        }
        bool = sWebpLibIsLoadSuccess;
        AppMethodBeat.o(53169);
        return bool;
      }
      finally
      {
        AppMethodBeat.o(53169);
      }
      System.load(paramContext);
    }
  }
  
  private static native void nativeSetGraphicsLibPath(String paramString);
  
  private static native void nativeSetSharpPLibPath(String paramString);
  
  private static void setGraphicsLibPath(String paramString)
  {
    AppMethodBeat.i(53166);
    sGraphicsLibPath = paramString;
    if (X5Graphics.isEnable())
    {
      nativeSetGraphicsLibPath(sGraphicsLibPath);
      sHasSetGraphicsPath = true;
      if ((sSharpPLibPath != null) && (!sSharpPLibPath.isEmpty())) {
        nativeSetSharpPLibPath(sSharpPLibPath);
      }
    }
    AppMethodBeat.o(53166);
  }
  
  public static void setSharpPPath(String paramString)
  {
    AppMethodBeat.i(53167);
    sSharpPLibPath = paramString;
    if ((paramString != null) && (!sSharpPLibPath.isEmpty()) && (sHasSetGraphicsPath))
    {
      new StringBuilder("setSharpPPath()  will  nativeSet  sSharpPLibPath=").append(sSharpPLibPath);
      nativeSetSharpPLibPath(sSharpPLibPath);
    }
    AppMethodBeat.o(53167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.export.external.X5Graphics.GraphicsLib
 * JD-Core Version:    0.7.0.1
 */