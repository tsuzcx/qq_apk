package com.tencent.smtt.export.external.X5Graphics;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

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
  
  /* Error */
  public static boolean init(Context paramContext, String paramString, X5Graphics.SoThinker paramSoThinker, X5Graphics.IBeacon paramIBeacon)
  {
    // Byte code:
    //   0: ldc 81
    //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 51	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 83
    //   11: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 88
    //   20: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_2
    //   24: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: invokestatic 97	com/tencent/smtt/export/external/X5Graphics/X5Graphics:isEnable	()Z
    //   31: ifne +20 -> 51
    //   34: new 99	java/lang/Error
    //   37: dup
    //   38: ldc 101
    //   40: invokespecial 102	java/lang/Error:<init>	(Ljava/lang/String;)V
    //   43: astore_0
    //   44: ldc 81
    //   46: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: aload_0
    //   50: athrow
    //   51: aload_2
    //   52: putstatic 34	com/tencent/smtt/export/external/X5Graphics/GraphicsLib:sThinker	Lcom/tencent/smtt/export/external/X5Graphics/X5Graphics$SoThinker;
    //   55: aload_1
    //   56: ifnull +27 -> 83
    //   59: aload_0
    //   60: aload_1
    //   61: invokestatic 105	com/tencent/smtt/export/external/X5Graphics/GraphicsLib:loadWepLibraryIfNeed	(Landroid/content/Context;Ljava/lang/String;)Z
    //   64: istore 4
    //   66: iload 4
    //   68: ifeq +93 -> 161
    //   71: aload_1
    //   72: invokestatic 108	com/tencent/smtt/export/external/X5Graphics/GraphicsLib:setGraphicsLibPath	(Ljava/lang/String;)V
    //   75: ldc 81
    //   77: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: iload 4
    //   82: ireturn
    //   83: aload_0
    //   84: invokestatic 114	com/tencent/smtt/export/external/LibraryLoader:getNativeLibraryDir	(Landroid/content/Context;)Ljava/lang/String;
    //   87: astore_1
    //   88: aload_0
    //   89: invokestatic 117	com/tencent/smtt/export/external/X5Graphics/GraphicsLib:loadWepLibraryIfNeed	(Landroid/content/Context;)Z
    //   92: istore 4
    //   94: goto -28 -> 66
    //   97: astore_1
    //   98: new 119	java/util/HashMap
    //   101: dup
    //   102: invokespecial 120	java/util/HashMap:<init>	()V
    //   105: astore_2
    //   106: aload_2
    //   107: ldc 122
    //   109: iconst_3
    //   110: invokestatic 127	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   113: invokevirtual 131	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   116: pop
    //   117: aload_0
    //   118: invokestatic 137	com/tencent/smtt/export/external/libwebp:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/export/external/libwebp;
    //   121: aconst_null
    //   122: aconst_null
    //   123: aconst_null
    //   124: invokevirtual 141	com/tencent/smtt/export/external/libwebp:getInfo	([B[I[I)I
    //   127: pop
    //   128: aload_3
    //   129: ifnull +10 -> 139
    //   132: aload_3
    //   133: ldc 143
    //   135: aload_2
    //   136: invokevirtual 149	com/tencent/smtt/export/external/X5Graphics/X5Graphics$IBeacon:report	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   139: ldc 81
    //   141: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: aload_1
    //   145: athrow
    //   146: astore_0
    //   147: aload_2
    //   148: ldc 122
    //   150: iconst_2
    //   151: invokestatic 127	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   154: invokevirtual 131	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   157: pop
    //   158: goto -30 -> 128
    //   161: new 119	java/util/HashMap
    //   164: dup
    //   165: invokespecial 120	java/util/HashMap:<init>	()V
    //   168: astore_0
    //   169: aload_0
    //   170: ldc 122
    //   172: iconst_1
    //   173: invokestatic 127	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   176: invokevirtual 131	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   179: pop
    //   180: aload_3
    //   181: ifnull -106 -> 75
    //   184: aload_3
    //   185: ldc 143
    //   187: aload_0
    //   188: invokevirtual 149	com/tencent/smtt/export/external/X5Graphics/X5Graphics$IBeacon:report	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   191: goto -116 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	paramContext	Context
    //   0	194	1	paramString	String
    //   0	194	2	paramSoThinker	X5Graphics.SoThinker
    //   0	194	3	paramIBeacon	X5Graphics.IBeacon
    //   64	29	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   71	75	97	finally
    //   117	128	146	finally
  }
  
  /* Error */
  public static boolean loadWepLibraryIfNeed(Context paramContext)
  {
    // Byte code:
    //   0: ldc 152
    //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 26	com/tencent/smtt/export/external/X5Graphics/GraphicsLib:sWebpLibIsLoadSuccess	Z
    //   8: ifeq +14 -> 22
    //   11: getstatic 26	com/tencent/smtt/export/external/X5Graphics/GraphicsLib:sWebpLibIsLoadSuccess	Z
    //   14: istore_1
    //   15: ldc 152
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
    //   38: ldc 152
    //   40: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: iload_1
    //   44: ireturn
    //   45: aload_0
    //   46: ldc 154
    //   48: invokestatic 158	com/tencent/smtt/export/external/LibraryLoader:loadLibrary	(Landroid/content/Context;Ljava/lang/String;)V
    //   51: iconst_1
    //   52: putstatic 26	com/tencent/smtt/export/external/X5Graphics/GraphicsLib:sWebpLibIsLoadSuccess	Z
    //   55: invokestatic 160	com/tencent/smtt/export/external/X5Graphics/GraphicsLib:getGraphicsLibPath	()Ljava/lang/String;
    //   58: ifnonnull +10 -> 68
    //   61: aload_0
    //   62: invokestatic 114	com/tencent/smtt/export/external/LibraryLoader:getNativeLibraryDir	(Landroid/content/Context;)Ljava/lang/String;
    //   65: invokestatic 108	com/tencent/smtt/export/external/X5Graphics/GraphicsLib:setGraphicsLibPath	(Ljava/lang/String;)V
    //   68: ldc 2
    //   70: monitorexit
    //   71: getstatic 26	com/tencent/smtt/export/external/X5Graphics/GraphicsLib:sWebpLibIsLoadSuccess	Z
    //   74: istore_1
    //   75: ldc 152
    //   77: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: iload_1
    //   81: ireturn
    //   82: astore_0
    //   83: ldc 2
    //   85: monitorexit
    //   86: ldc 152
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.export.external.X5Graphics.GraphicsLib
 * JD-Core Version:    0.7.0.1
 */