import android.os.Bundle;
import com.tencent.image.ApngImage;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import java.io.File;

public class alep
  extends beqz
{
  /* Error */
  public File a(java.io.OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_2
    //   7: getfield 19	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   10: invokevirtual 25	java/net/URL:getHost	()Ljava/lang/String;
    //   13: astore 6
    //   15: new 27	java/io/File
    //   18: dup
    //   19: aload 6
    //   21: invokespecial 30	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore 5
    //   26: aload_2
    //   27: getfield 34	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   30: instanceof 36
    //   33: ifeq +42 -> 75
    //   36: aload_2
    //   37: getfield 34	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   40: checkcast 36	android/os/Bundle
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +35 -> 80
    //   48: aload_1
    //   49: ldc 38
    //   51: ldc 40
    //   53: invokevirtual 44	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   56: astore_1
    //   57: aload 5
    //   59: invokevirtual 48	java/io/File:exists	()Z
    //   62: ifeq +24 -> 86
    //   65: aload_1
    //   66: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   69: ifeq +17 -> 86
    //   72: aload 5
    //   74: areturn
    //   75: aconst_null
    //   76: astore_1
    //   77: goto -33 -> 44
    //   80: ldc 40
    //   82: astore_1
    //   83: goto -26 -> 57
    //   86: aload_2
    //   87: getfield 19	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   90: invokevirtual 57	java/net/URL:getFile	()Ljava/lang/String;
    //   93: astore_3
    //   94: aload_3
    //   95: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   98: ifeq +40 -> 138
    //   101: ldc 59
    //   103: iconst_2
    //   104: new 61	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   111: ldc 64
    //   113: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_3
    //   117: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc 70
    //   122: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload 6
    //   127: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 79	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   136: aconst_null
    //   137: areturn
    //   138: aload_3
    //   139: astore_2
    //   140: aload_3
    //   141: getstatic 83	java/io/File:separator	Ljava/lang/String;
    //   144: invokevirtual 89	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   147: ifeq +9 -> 156
    //   150: aload_3
    //   151: iconst_1
    //   152: invokevirtual 93	java/lang/String:substring	(I)Ljava/lang/String;
    //   155: astore_2
    //   156: aload_2
    //   157: ldc 95
    //   159: invokevirtual 89	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   162: ifne +46 -> 208
    //   165: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   168: ifeq +38 -> 206
    //   171: ldc 59
    //   173: iconst_2
    //   174: new 61	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   181: ldc 100
    //   183: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload_2
    //   187: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc 70
    //   192: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload 6
    //   197: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 79	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: aconst_null
    //   207: areturn
    //   208: new 102	com/tencent/mobileqq/activity/qwallet/preload/DownloadParam
    //   211: dup
    //   212: invokespecial 103	com/tencent/mobileqq/activity/qwallet/preload/DownloadParam:<init>	()V
    //   215: astore_3
    //   216: aload_3
    //   217: aload_2
    //   218: putfield 105	com/tencent/mobileqq/activity/qwallet/preload/DownloadParam:url	Ljava/lang/String;
    //   221: aload_3
    //   222: aload_1
    //   223: putfield 108	com/tencent/mobileqq/activity/qwallet/preload/DownloadParam:md5	Ljava/lang/String;
    //   226: aload_3
    //   227: iconst_1
    //   228: putfield 112	com/tencent/mobileqq/activity/qwallet/preload/DownloadParam:useQWalletConfig	Z
    //   231: new 114	java/util/concurrent/atomic/AtomicBoolean
    //   234: dup
    //   235: iconst_0
    //   236: invokespecial 117	java/util/concurrent/atomic/AtomicBoolean:<init>	(Z)V
    //   239: astore_1
    //   240: invokestatic 122	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:a	()Lalds;
    //   243: aload_3
    //   244: new 124	aleq
    //   247: dup
    //   248: aload_0
    //   249: aload 5
    //   251: aload_1
    //   252: invokespecial 127	aleq:<init>	(Lalep;Ljava/io/File;Ljava/util/concurrent/atomic/AtomicBoolean;)V
    //   255: invokevirtual 132	alds:a	(Lcom/tencent/mobileqq/activity/qwallet/preload/DownloadParam;Laldq;)V
    //   258: aload_1
    //   259: invokevirtual 135	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   262: ifne -190 -> 72
    //   265: aload 5
    //   267: monitorenter
    //   268: aload_1
    //   269: invokevirtual 135	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   272: istore 4
    //   274: iload 4
    //   276: ifne +11 -> 287
    //   279: aload 5
    //   281: ldc2_w 136
    //   284: invokevirtual 143	java/lang/Object:wait	(J)V
    //   287: aload 5
    //   289: monitorexit
    //   290: goto -218 -> 72
    //   293: astore_1
    //   294: aload 5
    //   296: monitorexit
    //   297: aload_1
    //   298: athrow
    //   299: astore_1
    //   300: goto -13 -> 287
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	this	alep
    //   0	303	1	paramOutputStream	java.io.OutputStream
    //   0	303	2	paramDownloadParams	DownloadParams
    //   0	303	3	paramURLDrawableHandler	URLDrawableHandler
    //   272	3	4	bool	boolean
    //   24	271	5	localFile	File
    //   13	183	6	str	String
    // Exception table:
    //   from	to	target	type
    //   268	274	293	finally
    //   279	287	293	finally
    //   287	290	293	finally
    //   294	297	293	finally
    //   279	287	299	java/lang/InterruptedException
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (paramDownloadParams != null)
    {
      if ((paramFile != null) && (paramFile.exists()) && (paramDownloadParams.useApngImage) && ("png".equals(bhmi.b(paramFile.getPath()))))
      {
        if ((paramDownloadParams.mExtraInfo instanceof Bundle)) {}
        for (paramDownloadParams = (Bundle)paramDownloadParams.mExtraInfo;; paramDownloadParams = null)
        {
          paramDownloadParams = new ApngImage(paramFile, true, paramDownloadParams);
          if (paramDownloadParams.firstFrame == null) {
            ChatBackgroundManager.a(paramFile.getAbsolutePath());
          }
          return paramDownloadParams;
        }
      }
      paramDownloadParams.useApngImage = false;
    }
    return super.decodeFile(paramFile, paramDownloadParams, paramURLDrawableHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alep
 * JD-Core Version:    0.7.0.1
 */