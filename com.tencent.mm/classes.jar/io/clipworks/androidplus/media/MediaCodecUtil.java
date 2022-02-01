package io.clipworks.androidplus.media;

import android.media.MediaCodecInfo;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

class MediaCodecUtil
{
  private static final int SDK_INT;
  private static final String TAG = "MediaCodecUtil";
  
  static
  {
    AppMethodBeat.i(189565);
    int i;
    if ("S".equals(Build.VERSION.CODENAME)) {
      i = 31;
    }
    for (;;)
    {
      SDK_INT = i;
      AppMethodBeat.o(189565);
      return;
      if ("R".equals(Build.VERSION.CODENAME)) {
        i = 30;
      } else {
        i = Build.VERSION.SDK_INT;
      }
    }
  }
  
  public static MediaCodecInfo getDecoderInfo(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(189488);
    paramString = getDecoderInfos(paramString, paramBoolean1, paramBoolean2);
    if (paramString.isEmpty())
    {
      AppMethodBeat.o(189488);
      return null;
    }
    paramString = (MediaCodecInfo)paramString.get(0);
    AppMethodBeat.o(189488);
    return paramString;
  }
  
  /* Error */
  public static List<MediaCodecInfo> getDecoderInfos(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 66
    //   5: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 68	android/media/MediaCodecList
    //   11: dup
    //   12: iconst_1
    //   13: invokespecial 70	android/media/MediaCodecList:<init>	(I)V
    //   16: astore 7
    //   18: new 72	java/util/ArrayList
    //   21: dup
    //   22: invokespecial 73	java/util/ArrayList:<init>	()V
    //   25: astore 6
    //   27: aload 7
    //   29: invokevirtual 77	android/media/MediaCodecList:getCodecInfos	()[Landroid/media/MediaCodecInfo;
    //   32: astore 7
    //   34: aload 7
    //   36: arraylength
    //   37: istore 4
    //   39: iconst_0
    //   40: istore_3
    //   41: iload_3
    //   42: iload 4
    //   44: if_icmpge +79 -> 123
    //   47: aload 7
    //   49: iload_3
    //   50: aaload
    //   51: astore 8
    //   53: aload 8
    //   55: invokevirtual 80	android/media/MediaCodecInfo:isEncoder	()Z
    //   58: istore 5
    //   60: iload 5
    //   62: ifne +54 -> 116
    //   65: aload 8
    //   67: aload_0
    //   68: invokevirtual 84	android/media/MediaCodecInfo:getCapabilitiesForType	(Ljava/lang/String;)Landroid/media/MediaCodecInfo$CodecCapabilities;
    //   71: pop
    //   72: aload 8
    //   74: invokestatic 88	io/clipworks/androidplus/media/MediaCodecUtil:isHardwareAccelerated	(Landroid/media/MediaCodecInfo;)Z
    //   77: iload_1
    //   78: if_icmpne +38 -> 116
    //   81: aload 8
    //   83: invokestatic 91	io/clipworks/androidplus/media/MediaCodecUtil:isSecureCodec	(Landroid/media/MediaCodecInfo;)Z
    //   86: iload_2
    //   87: if_icmpne +29 -> 116
    //   90: aload 6
    //   92: aload 8
    //   94: invokevirtual 94	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   97: pop
    //   98: new 96	java/lang/StringBuilder
    //   101: dup
    //   102: ldc 98
    //   104: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   107: aload 8
    //   109: invokevirtual 105	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   112: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: iload_3
    //   117: iconst_1
    //   118: iadd
    //   119: istore_3
    //   120: goto -79 -> 41
    //   123: ldc 66
    //   125: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: ldc 2
    //   130: monitorexit
    //   131: aload 6
    //   133: areturn
    //   134: astore_0
    //   135: ldc 2
    //   137: monitorexit
    //   138: aload_0
    //   139: athrow
    //   140: astore 8
    //   142: goto -26 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramString	String
    //   0	145	1	paramBoolean1	boolean
    //   0	145	2	paramBoolean2	boolean
    //   40	80	3	i	int
    //   37	8	4	j	int
    //   58	3	5	bool	boolean
    //   25	107	6	localArrayList	java.util.ArrayList
    //   16	32	7	localObject	Object
    //   51	57	8	localMediaCodecInfo	MediaCodecInfo
    //   140	1	8	localIllegalArgumentException	java.lang.IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   3	39	134	finally
    //   53	60	134	finally
    //   65	116	134	finally
    //   123	128	134	finally
    //   65	116	140	java/lang/IllegalArgumentException
  }
  
  private static boolean isHardwareAccelerated(MediaCodecInfo paramMediaCodecInfo)
  {
    AppMethodBeat.i(189514);
    if (SDK_INT >= 29)
    {
      boolean bool = isHardwareAcceleratedV29(paramMediaCodecInfo);
      AppMethodBeat.o(189514);
      return bool;
    }
    if (!isSoftwareOnly(paramMediaCodecInfo))
    {
      AppMethodBeat.o(189514);
      return true;
    }
    AppMethodBeat.o(189514);
    return false;
  }
  
  private static boolean isHardwareAcceleratedV29(MediaCodecInfo paramMediaCodecInfo)
  {
    AppMethodBeat.i(189524);
    boolean bool = paramMediaCodecInfo.isHardwareAccelerated();
    AppMethodBeat.o(189524);
    return bool;
  }
  
  private static boolean isSecureCodec(MediaCodecInfo paramMediaCodecInfo)
  {
    AppMethodBeat.i(189508);
    boolean bool = paramMediaCodecInfo.getName().endsWith(".secure");
    AppMethodBeat.o(189508);
    return bool;
  }
  
  private static boolean isSoftwareOnly(MediaCodecInfo paramMediaCodecInfo)
  {
    AppMethodBeat.i(189532);
    if (SDK_INT >= 29)
    {
      boolean bool = isSoftwareOnlyV29(paramMediaCodecInfo);
      AppMethodBeat.o(189532);
      return bool;
    }
    paramMediaCodecInfo = paramMediaCodecInfo.getName().toLowerCase();
    if (paramMediaCodecInfo.startsWith("arc."))
    {
      AppMethodBeat.o(189532);
      return false;
    }
    if ((paramMediaCodecInfo.startsWith("omx.google.")) || (paramMediaCodecInfo.startsWith("omx.ffmpeg.")) || ((paramMediaCodecInfo.startsWith("omx.sec.")) && (paramMediaCodecInfo.contains(".sw."))) || (paramMediaCodecInfo.equals("omx.qcom.video.decoder.hevcswvdec")) || (paramMediaCodecInfo.startsWith("c2.android.")) || (paramMediaCodecInfo.startsWith("c2.google.")) || ((!paramMediaCodecInfo.startsWith("omx.")) && (!paramMediaCodecInfo.startsWith("c2."))))
    {
      AppMethodBeat.o(189532);
      return true;
    }
    AppMethodBeat.o(189532);
    return false;
  }
  
  private static boolean isSoftwareOnlyV29(MediaCodecInfo paramMediaCodecInfo)
  {
    AppMethodBeat.i(189541);
    boolean bool = paramMediaCodecInfo.isSoftwareOnly();
    AppMethodBeat.o(189541);
    return bool;
  }
  
  private static boolean isVendor(MediaCodecInfo paramMediaCodecInfo)
  {
    AppMethodBeat.i(189550);
    if (SDK_INT >= 29)
    {
      boolean bool = isVendorV29(paramMediaCodecInfo);
      AppMethodBeat.o(189550);
      return bool;
    }
    paramMediaCodecInfo = paramMediaCodecInfo.getName().toLowerCase();
    if ((!paramMediaCodecInfo.startsWith("omx.google.")) && (!paramMediaCodecInfo.startsWith("c2.android.")) && (!paramMediaCodecInfo.startsWith("c2.google.")))
    {
      AppMethodBeat.o(189550);
      return true;
    }
    AppMethodBeat.o(189550);
    return false;
  }
  
  private static boolean isVendorV29(MediaCodecInfo paramMediaCodecInfo)
  {
    AppMethodBeat.i(189559);
    boolean bool = paramMediaCodecInfo.isVendor();
    AppMethodBeat.o(189559);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.clipworks.androidplus.media.MediaCodecUtil
 * JD-Core Version:    0.7.0.1
 */