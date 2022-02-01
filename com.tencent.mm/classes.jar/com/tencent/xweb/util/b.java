package com.tencent.xweb.util;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;

public final class b
{
  private static String aimv;
  private static String aimw;
  
  public static boolean khu()
  {
    AppMethodBeat.i(212595);
    String str = khx();
    if ((str.equals("x86")) || (str.equals("x86_64")))
    {
      AppMethodBeat.o(212595);
      return true;
    }
    AppMethodBeat.o(212595);
    return false;
  }
  
  private static boolean khv()
  {
    AppMethodBeat.i(212598);
    String str = khx();
    if ((str.equals("arm64-v8a")) || (str.equals("x86_64")))
    {
      AppMethodBeat.o(212598);
      return true;
    }
    AppMethodBeat.o(212598);
    return false;
  }
  
  public static String khw()
  {
    AppMethodBeat.i(212612);
    if (aimw == null) {}
    try
    {
      String str = Build.CPU_ABI.toLowerCase();
      switch (str.hashCode())
      {
      case -738963905: 
      case 145444210: 
      case 1431565292: 
      case 117110: 
      case -806050265: 
        for (aimw = str;; aimw = "armeabi-v7a")
        {
          if (TextUtils.isEmpty(aimw)) {}
          try
          {
            str = System.getProperty("os.arch").toLowerCase();
            switch (str.hashCode())
            {
            case 117110: 
              aimw = "arch:".concat(String.valueOf(str));
            }
          }
          finally
          {
            for (;;)
            {
              Log.e("AbiUtil", "get abi from os.arch failed, error:".concat(String.valueOf(localObject2)));
              continue;
              if (khv())
              {
                aimw = "x86_64";
              }
              else
              {
                aimw = "x86";
                continue;
                aimw = "armeabi-v7a";
                continue;
                if (khv())
                {
                  aimw = "arm64-v8a";
                }
                else
                {
                  aimw = "armeabi-v7a";
                  continue;
                  if ((aimw.equals("arm64-v8a")) && (khu())) {
                    aimw = "x86_64";
                  }
                }
              }
            }
            i = -1;
            switch (i)
            {
            }
          }
          if (!aimw.equals("armeabi-v7a")) {
            break label644;
          }
          if (khu()) {
            aimw = "x86";
          }
          Log.i("AbiUtil", "Runtime ABI: " + aimw);
          str = aimw;
          AppMethodBeat.o(212612);
          return str;
          if (!str.equals("armeabi")) {
            break label669;
          }
          i = 0;
          break label671;
          if (!str.equals("armeabi-v7a")) {
            break label669;
          }
          i = 1;
          break label671;
          if (!str.equals("arm64-v8a")) {
            break label669;
          }
          i = 2;
          break label671;
          if (!str.equals("x86")) {
            break label669;
          }
          i = 3;
          break label671;
          if (!str.equals("x86_64")) {
            break label669;
          }
          i = 4;
          break label671;
        }
      }
    }
    finally
    {
      for (;;)
      {
        Log.e("AbiUtil", "get abi from cpu_abi failed, error:".concat(String.valueOf(localObject1)));
        continue;
        aimw = "arm64-v8a";
        continue;
        aimw = "x86";
        continue;
        aimw = "x86_64";
        continue;
        if (localObject1.equals("x86"))
        {
          i = 0;
          break label713;
          if (localObject1.equals("i686"))
          {
            i = 1;
            break label713;
            if (localObject1.equals("i386"))
            {
              i = 2;
              break label713;
              if (localObject1.equals("ia32"))
              {
                i = 3;
                break label713;
                if (localObject1.equals("x64"))
                {
                  i = 4;
                  break label713;
                  if (localObject1.equals("x86_64"))
                  {
                    i = 5;
                    break label713;
                    if (localObject1.equals("armv7l"))
                    {
                      i = 6;
                      break label713;
                      if (localObject1.equals("armeabi"))
                      {
                        i = 7;
                        break label713;
                        if (localObject1.equals("armeabi-v7a"))
                        {
                          i = 8;
                          break label713;
                          if (localObject1.equals("aarch64"))
                          {
                            i = 9;
                            break label713;
                            if (localObject1.equals("armv8"))
                            {
                              i = 10;
                              break label713;
                              if (localObject1.equals("arm64"))
                              {
                                i = 11;
                                break label713;
                                aimw = "x86";
                                continue;
                                label644:
                                label669:
                                label671:
                                continue;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        int i = -1;
        label713:
        switch (i)
        {
        }
      }
    }
  }
  
  /* Error */
  public static String khx()
  {
    // Byte code:
    //   0: ldc 133
    //   2: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 135	com/tencent/xweb/util/b:aimv	Ljava/lang/String;
    //   8: ifnonnull +97 -> 105
    //   11: getstatic 141	android/os/Build$VERSION:SDK_INT	I
    //   14: bipush 21
    //   16: if_icmplt +14 -> 30
    //   19: getstatic 145	android/os/Build:SUPPORTED_ABIS	[Ljava/lang/String;
    //   22: iconst_0
    //   23: aaload
    //   24: invokevirtual 50	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   27: putstatic 135	com/tencent/xweb/util/b:aimv	Ljava/lang/String;
    //   30: getstatic 135	com/tencent/xweb/util/b:aimv	Ljava/lang/String;
    //   33: ifnonnull +49 -> 82
    //   36: new 147	java/io/InputStreamReader
    //   39: dup
    //   40: invokestatic 153	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   43: ldc 155
    //   45: invokevirtual 159	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   48: invokevirtual 165	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   51: invokespecial 168	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   54: astore_2
    //   55: new 170	java/io/BufferedReader
    //   58: dup
    //   59: aload_2
    //   60: invokespecial 173	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   63: astore_1
    //   64: aload_1
    //   65: invokevirtual 176	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   68: invokevirtual 50	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   71: putstatic 135	com/tencent/xweb/util/b:aimv	Ljava/lang/String;
    //   74: aload_2
    //   75: invokestatic 182	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   78: aload_1
    //   79: invokestatic 182	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   82: ldc 83
    //   84: new 85	java/lang/StringBuilder
    //   87: dup
    //   88: ldc 184
    //   90: invokespecial 91	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   93: getstatic 135	com/tencent/xweb/util/b:aimv	Ljava/lang/String;
    //   96: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 103	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: getstatic 135	com/tencent/xweb/util/b:aimv	Ljava/lang/String;
    //   108: ifnonnull +93 -> 201
    //   111: ldc 133
    //   113: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: ldc 186
    //   118: areturn
    //   119: astore_0
    //   120: ldc 83
    //   122: ldc 188
    //   124: aload_0
    //   125: invokestatic 74	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   128: invokevirtual 77	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   131: invokestatic 110	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: goto -104 -> 30
    //   137: astore_0
    //   138: ldc 83
    //   140: ldc 190
    //   142: aload_0
    //   143: invokestatic 74	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   146: invokevirtual 77	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   149: invokestatic 110	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: goto -122 -> 30
    //   155: astore_0
    //   156: aconst_null
    //   157: astore_1
    //   158: aconst_null
    //   159: astore_2
    //   160: ldc 83
    //   162: ldc 192
    //   164: aload_0
    //   165: invokestatic 74	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   168: invokevirtual 77	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   171: invokestatic 110	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: aload_2
    //   175: invokestatic 182	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   178: aload_1
    //   179: invokestatic 182	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   182: goto -100 -> 82
    //   185: astore_0
    //   186: aload_2
    //   187: invokestatic 182	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   190: aload_1
    //   191: invokestatic 182	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   194: ldc 133
    //   196: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: aload_0
    //   200: athrow
    //   201: getstatic 135	com/tencent/xweb/util/b:aimv	Ljava/lang/String;
    //   204: astore_0
    //   205: ldc 133
    //   207: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   210: aload_0
    //   211: areturn
    //   212: astore_0
    //   213: aconst_null
    //   214: astore_1
    //   215: goto -55 -> 160
    //   218: astore_0
    //   219: goto -59 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   119	6	0	localNoSuchFieldError	java.lang.NoSuchFieldError
    //   137	6	0	localObject1	Object
    //   155	10	0	localObject2	Object
    //   185	15	0	localObject3	Object
    //   204	7	0	str	String
    //   212	1	0	localObject4	Object
    //   218	1	0	localObject5	Object
    //   63	152	1	localBufferedReader	java.io.BufferedReader
    //   54	133	2	localInputStreamReader	java.io.InputStreamReader
    // Exception table:
    //   from	to	target	type
    //   11	30	119	java/lang/NoSuchFieldError
    //   11	30	137	finally
    //   36	55	155	finally
    //   160	174	185	finally
    //   55	64	212	finally
    //   64	74	218	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.util.b
 * JD-Core Version:    0.7.0.1
 */