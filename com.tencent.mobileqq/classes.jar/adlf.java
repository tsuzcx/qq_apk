import com.tencent.common.app.BaseApplicationImpl;

public class adlf
{
  public static boolean a;
  
  public static int a()
  {
    int i = 0;
    if (BaseApplicationImpl.sProcessId == 2) {
      i = 14;
    }
    while (BaseApplicationImpl.sProcessId != 7) {
      return i;
    }
    return 19;
  }
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 19	adlf:a	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: getstatic 13	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   18: iconst_1
    //   19: if_icmpne +9 -> 28
    //   22: getstatic 24	adkq:a	[Ljava/lang/Class;
    //   25: invokestatic 30	com/tencent/qapmsdk/QAPM:setAbTypes	([Ljava/lang/Class;)V
    //   28: iconst_1
    //   29: putstatic 19	adlf:a	Z
    //   32: getstatic 33	com/tencent/qapmsdk/QAPM:LevelInfo	I
    //   35: istore_0
    //   36: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +192 -> 231
    //   42: getstatic 42	com/tencent/qapmsdk/QAPM:LevelDebug	I
    //   45: istore_0
    //   46: iconst_2
    //   47: getstatic 13	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   50: if_icmpeq +184 -> 234
    //   53: bipush 8
    //   55: getstatic 13	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   58: if_icmpne +167 -> 225
    //   61: goto +173 -> 234
    //   64: invokestatic 47	com/tencent/mfsdk/MagnifierSDK:a	()Ljava/lang/String;
    //   67: astore 4
    //   69: invokestatic 51	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   72: invokevirtual 55	com/tencent/common/app/BaseApplicationImpl:getPackageManager	()Landroid/content/pm/PackageManager;
    //   75: invokestatic 51	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   78: invokevirtual 58	com/tencent/common/app/BaseApplicationImpl:getPackageName	()Ljava/lang/String;
    //   81: sipush 128
    //   84: invokevirtual 64	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   87: getfield 70	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   90: ldc 72
    //   92: invokevirtual 78	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   95: invokevirtual 81	java/lang/Object:toString	()Ljava/lang/String;
    //   98: astore_3
    //   99: sipush 201
    //   102: getstatic 85	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   105: invokestatic 89	com/tencent/qapmsdk/QAPM:setProperty	(ILjava/lang/Object;)Lcom/tencent/qapmsdk/QAPM;
    //   108: pop
    //   109: bipush 101
    //   111: aload_2
    //   112: invokestatic 92	com/tencent/qapmsdk/QAPM:setProperty	(ILjava/lang/String;)Lcom/tencent/qapmsdk/QAPM;
    //   115: pop
    //   116: bipush 103
    //   118: aload 4
    //   120: invokestatic 92	com/tencent/qapmsdk/QAPM:setProperty	(ILjava/lang/String;)Lcom/tencent/qapmsdk/QAPM;
    //   123: pop
    //   124: bipush 104
    //   126: aload_3
    //   127: invokestatic 92	com/tencent/qapmsdk/QAPM:setProperty	(ILjava/lang/String;)Lcom/tencent/qapmsdk/QAPM;
    //   130: pop
    //   131: bipush 105
    //   133: iload_0
    //   134: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   137: invokestatic 89	com/tencent/qapmsdk/QAPM:setProperty	(ILjava/lang/Object;)Lcom/tencent/qapmsdk/QAPM;
    //   140: pop
    //   141: bipush 106
    //   143: ldc 100
    //   145: invokestatic 92	com/tencent/qapmsdk/QAPM:setProperty	(ILjava/lang/String;)Lcom/tencent/qapmsdk/QAPM;
    //   148: pop
    //   149: bipush 111
    //   151: ldc 102
    //   153: invokestatic 92	com/tencent/qapmsdk/QAPM:setProperty	(ILjava/lang/String;)Lcom/tencent/qapmsdk/QAPM;
    //   156: pop
    //   157: iconst_0
    //   158: putstatic 107	com/tencent/qapmsdk/base/reporter/authorization/Authorization:isAuthorize	Z
    //   161: getstatic 113	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   164: new 115	adlg
    //   167: dup
    //   168: iload_0
    //   169: invokespecial 119	adlg:<init>	(I)V
    //   172: invokevirtual 123	com/tencent/qapmsdk/common/logger/Logger:setLogProxy	(Lcom/tencent/qapmsdk/common/logger/ILogProxy;)V
    //   175: ldc 125
    //   177: iconst_1
    //   178: new 127	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   185: ldc 131
    //   187: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: iload_0
    //   191: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 143	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   200: goto -189 -> 11
    //   203: astore_2
    //   204: ldc 2
    //   206: monitorexit
    //   207: aload_2
    //   208: athrow
    //   209: astore_3
    //   210: ldc 125
    //   212: iconst_1
    //   213: ldc 145
    //   215: aload_3
    //   216: invokestatic 149	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   219: ldc 151
    //   221: astore_3
    //   222: goto -123 -> 99
    //   225: ldc 153
    //   227: astore_2
    //   228: goto -164 -> 64
    //   231: goto -185 -> 46
    //   234: ldc 155
    //   236: astore_2
    //   237: goto -173 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   35	156	0	i	int
    //   6	2	1	bool	boolean
    //   111	1	2	str1	java.lang.String
    //   203	5	2	localObject	Object
    //   227	10	2	str2	java.lang.String
    //   98	29	3	str3	java.lang.String
    //   209	7	3	localThrowable	java.lang.Throwable
    //   221	1	3	str4	java.lang.String
    //   67	52	4	str5	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   3	7	203	finally
    //   15	28	203	finally
    //   28	46	203	finally
    //   46	61	203	finally
    //   64	69	203	finally
    //   69	99	203	finally
    //   99	200	203	finally
    //   210	219	203	finally
    //   69	99	209	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adlf
 * JD-Core Version:    0.7.0.1
 */