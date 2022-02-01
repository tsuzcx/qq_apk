package com.tencent.recovery.c;

import android.content.Context;
import java.io.File;

public final class a
{
  private static File C(Context paramContext)
  {
    paramContext = new File(paramContext.getFilesDir(), "recovery");
    if (!paramContext.exists()) {
      paramContext.mkdir();
    }
    return paramContext;
  }
  
  /* Error */
  public static boolean a(Context paramContext, java.lang.String paramString, com.tencent.recovery.model.RecoveryPersistentItem paramRecoveryPersistentItem)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 36	com/tencent/recovery/c/a:C	(Landroid/content/Context;)Ljava/io/File;
    //   4: astore_0
    //   5: aload_2
    //   6: invokevirtual 42	com/tencent/recovery/model/RecoveryPersistentItem:oC	()Ljava/lang/String;
    //   9: astore_2
    //   10: ldc 44
    //   12: ldc 46
    //   14: iconst_1
    //   15: anewarray 4	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: aload_2
    //   21: aastore
    //   22: invokestatic 52	com/tencent/recovery/a/d:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: new 8	java/io/File
    //   28: dup
    //   29: aload_0
    //   30: aload_1
    //   31: invokespecial 20	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   34: astore_0
    //   35: aload_0
    //   36: invokevirtual 56	java/io/File:length	()J
    //   39: ldc2_w 57
    //   42: lcmp
    //   43: ifle +19 -> 62
    //   46: ldc 44
    //   48: ldc 60
    //   50: iconst_0
    //   51: anewarray 4	java/lang/Object
    //   54: invokestatic 52	com/tencent/recovery/a/d:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   57: aload_0
    //   58: invokevirtual 63	java/io/File:delete	()Z
    //   61: pop
    //   62: aload_0
    //   63: invokevirtual 24	java/io/File:exists	()Z
    //   66: ifne +8 -> 74
    //   69: aload_0
    //   70: invokevirtual 66	java/io/File:createNewFile	()Z
    //   73: pop
    //   74: new 68	java/io/FileOutputStream
    //   77: dup
    //   78: aload_0
    //   79: iconst_1
    //   80: invokespecial 71	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   83: astore_1
    //   84: aload_1
    //   85: astore_0
    //   86: aload_1
    //   87: new 73	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   94: aload_2
    //   95: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: ldc 82
    //   100: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokevirtual 91	java/lang/String:getBytes	()[B
    //   109: invokevirtual 95	java/io/FileOutputStream:write	([B)V
    //   112: aload_1
    //   113: astore_0
    //   114: aload_1
    //   115: invokevirtual 98	java/io/FileOutputStream:flush	()V
    //   118: aload_1
    //   119: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   122: iconst_1
    //   123: ireturn
    //   124: astore_2
    //   125: aconst_null
    //   126: astore_1
    //   127: aload_1
    //   128: astore_0
    //   129: ldc 44
    //   131: aload_2
    //   132: ldc 103
    //   134: iconst_0
    //   135: anewarray 4	java/lang/Object
    //   138: invokestatic 106	com/tencent/recovery/a/d:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   141: aload_1
    //   142: ifnull -20 -> 122
    //   145: aload_1
    //   146: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   149: iconst_1
    //   150: ireturn
    //   151: astore_0
    //   152: iconst_1
    //   153: ireturn
    //   154: astore_1
    //   155: aconst_null
    //   156: astore_0
    //   157: aload_0
    //   158: ifnull +7 -> 165
    //   161: aload_0
    //   162: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   165: aload_1
    //   166: athrow
    //   167: astore_1
    //   168: goto -94 -> 74
    //   171: astore_0
    //   172: iconst_1
    //   173: ireturn
    //   174: astore_0
    //   175: goto -10 -> 165
    //   178: astore_1
    //   179: goto -22 -> 157
    //   182: astore_2
    //   183: goto -56 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	paramContext	Context
    //   0	186	1	paramString	java.lang.String
    //   0	186	2	paramRecoveryPersistentItem	com.tencent.recovery.model.RecoveryPersistentItem
    // Exception table:
    //   from	to	target	type
    //   74	84	124	java/lang/Exception
    //   145	149	151	java/io/IOException
    //   74	84	154	finally
    //   69	74	167	java/io/IOException
    //   118	122	171	java/io/IOException
    //   161	165	174	java/io/IOException
    //   86	112	178	finally
    //   114	118	178	finally
    //   129	141	178	finally
    //   86	112	182	java/lang/Exception
    //   114	118	182	java/lang/Exception
  }
  
  /* Error */
  public static boolean a(Context paramContext, java.lang.String paramString, java.util.List<? extends com.tencent.recovery.model.RecoveryPersistentItem> paramList)
  {
    // Byte code:
    //   0: ldc 44
    //   2: ldc 109
    //   4: iconst_2
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: aload_1
    //   11: aastore
    //   12: dup
    //   13: iconst_1
    //   14: aload_2
    //   15: invokeinterface 115 1 0
    //   20: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   23: aastore
    //   24: invokestatic 52	com/tencent/recovery/a/d:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   27: new 8	java/io/File
    //   30: dup
    //   31: aload_0
    //   32: invokestatic 36	com/tencent/recovery/c/a:C	(Landroid/content/Context;)Ljava/io/File;
    //   35: aload_1
    //   36: invokespecial 20	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   39: astore_0
    //   40: aload_0
    //   41: invokevirtual 56	java/io/File:length	()J
    //   44: ldc2_w 57
    //   47: lcmp
    //   48: ifle +19 -> 67
    //   51: ldc 44
    //   53: ldc 60
    //   55: iconst_0
    //   56: anewarray 4	java/lang/Object
    //   59: invokestatic 52	com/tencent/recovery/a/d:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   62: aload_0
    //   63: invokevirtual 63	java/io/File:delete	()Z
    //   66: pop
    //   67: aload_0
    //   68: invokevirtual 24	java/io/File:exists	()Z
    //   71: ifne +8 -> 79
    //   74: aload_0
    //   75: invokevirtual 66	java/io/File:createNewFile	()Z
    //   78: pop
    //   79: new 68	java/io/FileOutputStream
    //   82: dup
    //   83: aload_0
    //   84: iconst_1
    //   85: invokespecial 71	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   88: astore_3
    //   89: aload_3
    //   90: astore_0
    //   91: aload_2
    //   92: invokeinterface 125 1 0
    //   97: astore_2
    //   98: aload_3
    //   99: astore_0
    //   100: aload_2
    //   101: invokeinterface 130 1 0
    //   106: ifeq +84 -> 190
    //   109: aload_3
    //   110: astore_0
    //   111: aload_2
    //   112: invokeinterface 134 1 0
    //   117: checkcast 38	com/tencent/recovery/model/RecoveryPersistentItem
    //   120: invokevirtual 42	com/tencent/recovery/model/RecoveryPersistentItem:oC	()Ljava/lang/String;
    //   123: astore 4
    //   125: aload_3
    //   126: astore_0
    //   127: aload_3
    //   128: new 73	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   135: aload 4
    //   137: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc 82
    //   142: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokevirtual 91	java/lang/String:getBytes	()[B
    //   151: invokevirtual 95	java/io/FileOutputStream:write	([B)V
    //   154: goto -56 -> 98
    //   157: astore_0
    //   158: aload_3
    //   159: astore_2
    //   160: aload_0
    //   161: astore_3
    //   162: aload_2
    //   163: astore_0
    //   164: ldc 44
    //   166: aload_3
    //   167: ldc 46
    //   169: iconst_1
    //   170: anewarray 4	java/lang/Object
    //   173: dup
    //   174: iconst_0
    //   175: aload_1
    //   176: aastore
    //   177: invokestatic 106	com/tencent/recovery/a/d:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   180: aload_2
    //   181: ifnull +7 -> 188
    //   184: aload_2
    //   185: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   188: iconst_1
    //   189: ireturn
    //   190: aload_3
    //   191: astore_0
    //   192: aload_3
    //   193: invokevirtual 98	java/io/FileOutputStream:flush	()V
    //   196: aload_3
    //   197: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   200: iconst_1
    //   201: ireturn
    //   202: astore_0
    //   203: iconst_1
    //   204: ireturn
    //   205: astore_1
    //   206: aconst_null
    //   207: astore_0
    //   208: aload_0
    //   209: ifnull +7 -> 216
    //   212: aload_0
    //   213: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   216: aload_1
    //   217: athrow
    //   218: astore_3
    //   219: goto -140 -> 79
    //   222: astore_0
    //   223: iconst_1
    //   224: ireturn
    //   225: astore_0
    //   226: goto -10 -> 216
    //   229: astore_1
    //   230: goto -22 -> 208
    //   233: astore_3
    //   234: aconst_null
    //   235: astore_2
    //   236: goto -74 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	paramContext	Context
    //   0	239	1	paramString	java.lang.String
    //   0	239	2	paramList	java.util.List<? extends com.tencent.recovery.model.RecoveryPersistentItem>
    //   88	109	3	localObject	Object
    //   218	1	3	localIOException	java.io.IOException
    //   233	1	3	localException	java.lang.Exception
    //   123	13	4	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   91	98	157	java/lang/Exception
    //   100	109	157	java/lang/Exception
    //   111	125	157	java/lang/Exception
    //   127	154	157	java/lang/Exception
    //   192	196	157	java/lang/Exception
    //   196	200	202	java/io/IOException
    //   79	89	205	finally
    //   74	79	218	java/io/IOException
    //   184	188	222	java/io/IOException
    //   212	216	225	java/io/IOException
    //   91	98	229	finally
    //   100	109	229	finally
    //   111	125	229	finally
    //   127	154	229	finally
    //   164	180	229	finally
    //   192	196	229	finally
    //   79	89	233	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.recovery.c.a
 * JD-Core Version:    0.7.0.1
 */