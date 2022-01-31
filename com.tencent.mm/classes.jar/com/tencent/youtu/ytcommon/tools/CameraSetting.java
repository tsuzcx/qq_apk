package com.tencent.youtu.ytcommon.tools;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.media.CamcorderProfile;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import java.util.Iterator;
import java.util.List;

public class CameraSetting
{
  private static final String TAG = "CameraSetting";
  static int mDesiredPreviewHeight = 720;
  static int mDesiredPreviewWidth = 1280;
  
  private static int chooseFixedPreviewFps(Camera.Parameters paramParameters, int paramInt)
  {
    int j = 0;
    Object localObject = paramParameters.getSupportedPreviewFpsRange().iterator();
    while (((Iterator)localObject).hasNext())
    {
      int[] arrayOfInt = (int[])((Iterator)localObject).next();
      YTLogger.d("CameraSetting", "entry: " + arrayOfInt[0] + " - " + arrayOfInt[1]);
      if ((arrayOfInt[0] == arrayOfInt[1]) && (arrayOfInt[0] == paramInt))
      {
        paramParameters.setPreviewFpsRange(arrayOfInt[0], arrayOfInt[1]);
        YTLogger.d("CameraSetting", "use preview fps range: " + arrayOfInt[0] + " " + arrayOfInt[1]);
        return arrayOfInt[0];
      }
    }
    localObject = new int[2];
    paramParameters.getPreviewFpsRange((int[])localObject);
    int i;
    int k;
    if (localObject[0] == localObject[1])
    {
      paramInt = localObject[0];
      localObject = paramParameters.get("preview-frame-rate-values");
      i = paramInt;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        i = paramInt;
        if (!((String)localObject).contains(paramInt / 1000))
        {
          localObject = ((String)localObject).split(",");
          k = localObject.length;
          i = j;
        }
      }
    }
    else
    {
      for (;;)
      {
        if (i >= k) {
          break label306;
        }
        j = Integer.parseInt(localObject[i]) * 1000;
        if (paramInt < j)
        {
          paramParameters.setPreviewFrameRate(j / 1000);
          return j;
          i = paramInt;
          if (paramInt > localObject[1]) {
            i = localObject[1];
          }
          paramInt = i;
          if (i >= localObject[0]) {
            break;
          }
          paramInt = localObject[0];
          break;
        }
        i += 1;
      }
      label306:
      i = paramInt;
      if (localObject.length > 0)
      {
        j = Integer.parseInt(localObject[(localObject.length - 1)]) * 1000;
        i = paramInt;
        if (paramInt > j) {
          i = j;
        }
      }
    }
    paramParameters.setPreviewFrameRate(i / 1000);
    return i;
  }
  
  public static int getDesiredPreviewHeight()
  {
    return mDesiredPreviewHeight;
  }
  
  public static int getDesiredPreviewWidth()
  {
    return mDesiredPreviewWidth;
  }
  
  private static Camera.Size getOptimalPreviewSize(List<Camera.Size> paramList, int paramInt1, int paramInt2)
  {
    Object localObject2;
    if (paramList == null)
    {
      localObject2 = null;
      return localObject2;
    }
    Object localObject1 = null;
    double d1 = 1.7976931348623157E+308D;
    int i = Math.max(paramInt1, paramInt2);
    paramInt1 = Math.min(paramInt1, paramInt2);
    double d2 = i / paramInt1;
    YTLogger.d("CameraSetting", "sizes size=" + paramList.size());
    Iterator localIterator = paramList.iterator();
    label72:
    while (localIterator.hasNext())
    {
      localObject2 = (Camera.Size)localIterator.next();
      if (Math.abs(((Camera.Size)localObject2).width / ((Camera.Size)localObject2).height - d2) <= 0.001D)
      {
        if (Math.abs(((Camera.Size)localObject2).height - paramInt1) >= d1) {
          break label240;
        }
        d1 = Math.abs(((Camera.Size)localObject2).height - paramInt1);
        localObject1 = localObject2;
      }
    }
    label240:
    for (;;)
    {
      break label72;
      localObject2 = localObject1;
      if (localObject1 != null) {
        break;
      }
      YTLogger.d("CameraSetting", "No preview size match the aspect ratio");
      d1 = 1.7976931348623157E+308D;
      localIterator = paramList.iterator();
      for (;;)
      {
        localObject2 = localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        paramList = (Camera.Size)localIterator.next();
        if (Math.abs(paramList.height - paramInt1) < d1)
        {
          d1 = Math.abs(paramList.height - paramInt1);
          localObject1 = paramList;
        }
      }
    }
  }
  
  public static int getRotateTag(int paramInt)
  {
    if (paramInt == 90) {
      return 7;
    }
    if (paramInt == 270) {
      return 5;
    }
    YTLogger.w("CameraSetting", "获取摄像头转向结果的时候值不为90或者180");
    return 1;
  }
  
  public static int getVideoRotate(Context paramContext, int paramInt)
  {
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    Camera.getCameraInfo(paramInt, localCameraInfo);
    switch (((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getRotation())
    {
    default: 
      paramInt = 0;
      if (localCameraInfo.facing != 1) {
        break;
      }
    }
    for (int i = (360 - (localCameraInfo.orientation + paramInt) % 360) % 360;; i = (localCameraInfo.orientation - paramInt + 360) % 360)
    {
      YTLogger.d("CameraSetting", "debug camera orientation is " + localCameraInfo.orientation + " ui degrees is " + paramInt);
      return i;
      paramInt = 0;
      break;
      paramInt = 90;
      break;
      paramInt = 180;
      break;
      paramInt = 270;
      break;
    }
  }
  
  /* Error */
  public static int initCamera(Context paramContext, Camera paramCamera, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 215	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   4: astore 4
    //   6: aload 4
    //   8: invokevirtual 218	android/hardware/Camera$Parameters:getSupportedFocusModes	()Ljava/util/List;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: aload 5
    //   18: invokeinterface 140 1 0
    //   23: if_icmpge +64 -> 87
    //   26: ldc 8
    //   28: new 49	java/lang/StringBuilder
    //   31: dup
    //   32: ldc 220
    //   34: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   37: iload_3
    //   38: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   41: ldc 222
    //   43: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload 5
    //   48: iload_3
    //   49: invokeinterface 225 2 0
    //   54: checkcast 100	java/lang/String
    //   57: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 228	com/tencent/youtu/ytcommon/tools/YTLogger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: iload_3
    //   67: iconst_1
    //   68: iadd
    //   69: istore_3
    //   70: goto -55 -> 15
    //   73: astore_0
    //   74: ldc 8
    //   76: ldc 230
    //   78: invokestatic 167	com/tencent/youtu/ytcommon/tools/YTLogger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: aload_0
    //   82: invokestatic 236	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   85: iconst_1
    //   86: ireturn
    //   87: aload 5
    //   89: ifnull +305 -> 394
    //   92: aload 5
    //   94: ldc 238
    //   96: invokeinterface 242 2 0
    //   101: iflt +293 -> 394
    //   104: aload 4
    //   106: ldc 238
    //   108: invokevirtual 245	android/hardware/Camera$Parameters:setFocusMode	(Ljava/lang/String;)V
    //   111: ldc 8
    //   113: ldc 247
    //   115: invokestatic 73	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload_1
    //   119: aload 4
    //   121: invokevirtual 251	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   124: aload_1
    //   125: invokevirtual 215	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   128: astore 4
    //   130: aload_0
    //   131: iload_2
    //   132: invokestatic 253	com/tencent/youtu/ytcommon/tools/CameraSetting:getVideoRotate	(Landroid/content/Context;I)I
    //   135: istore_3
    //   136: aload_1
    //   137: iload_3
    //   138: invokevirtual 256	android/hardware/Camera:setDisplayOrientation	(I)V
    //   141: ldc 8
    //   143: new 49	java/lang/StringBuilder
    //   146: dup
    //   147: ldc_w 258
    //   150: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   153: iload_3
    //   154: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   157: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 73	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: iload_2
    //   164: iconst_4
    //   165: invokestatic 264	android/media/CamcorderProfile:hasProfile	(II)Z
    //   168: ifeq +324 -> 492
    //   171: iload_2
    //   172: iconst_4
    //   173: invokestatic 267	android/media/CamcorderProfile:get	(II)Landroid/media/CamcorderProfile;
    //   176: astore_0
    //   177: ldc 8
    //   179: new 49	java/lang/StringBuilder
    //   182: dup
    //   183: ldc_w 269
    //   186: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   189: aload_0
    //   190: getfield 272	android/media/CamcorderProfile:videoFrameWidth	I
    //   193: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   196: ldc_w 274
    //   199: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload_0
    //   203: getfield 277	android/media/CamcorderProfile:videoFrameHeight	I
    //   206: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   209: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 73	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: aload 4
    //   217: aload_0
    //   218: invokestatic 281	com/tencent/youtu/ytcommon/tools/CameraSetting:setVideoSize	(Landroid/hardware/Camera$Parameters;Landroid/media/CamcorderProfile;)V
    //   221: aload 4
    //   223: getstatic 15	com/tencent/youtu/ytcommon/tools/CameraSetting:mDesiredPreviewWidth	I
    //   226: getstatic 17	com/tencent/youtu/ytcommon/tools/CameraSetting:mDesiredPreviewHeight	I
    //   229: invokevirtual 284	android/hardware/Camera$Parameters:setPreviewSize	(II)V
    //   232: aload 4
    //   234: bipush 17
    //   236: invokevirtual 287	android/hardware/Camera$Parameters:setPreviewFormat	(I)V
    //   239: aload_1
    //   240: aload 4
    //   242: invokevirtual 251	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   245: aload_1
    //   246: invokevirtual 215	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   249: astore_0
    //   250: aload_0
    //   251: sipush 30000
    //   254: invokestatic 289	com/tencent/youtu/ytcommon/tools/CameraSetting:chooseFixedPreviewFps	(Landroid/hardware/Camera$Parameters;I)I
    //   257: istore_2
    //   258: ldc 8
    //   260: new 49	java/lang/StringBuilder
    //   263: dup
    //   264: ldc_w 291
    //   267: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   270: iload_2
    //   271: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   274: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 73	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: aload_1
    //   281: aload_0
    //   282: invokevirtual 251	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   285: aload_1
    //   286: invokevirtual 215	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   289: astore_0
    //   290: iconst_2
    //   291: newarray int
    //   293: astore_1
    //   294: aload_0
    //   295: aload_1
    //   296: invokevirtual 85	android/hardware/Camera$Parameters:getPreviewFpsRange	([I)V
    //   299: aload_0
    //   300: invokevirtual 294	android/hardware/Camera$Parameters:getPreviewFrameRate	()I
    //   303: istore_2
    //   304: ldc 8
    //   306: new 49	java/lang/StringBuilder
    //   309: dup
    //   310: ldc_w 296
    //   313: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   316: aload_1
    //   317: iconst_0
    //   318: iaload
    //   319: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   322: ldc_w 298
    //   325: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: aload_1
    //   329: iconst_1
    //   330: iaload
    //   331: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   334: ldc_w 300
    //   337: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: iload_2
    //   341: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   344: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: invokestatic 73	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   350: aload_0
    //   351: invokevirtual 304	android/hardware/Camera$Parameters:getPreviewSize	()Landroid/hardware/Camera$Size;
    //   354: astore_0
    //   355: ldc 8
    //   357: new 49	java/lang/StringBuilder
    //   360: dup
    //   361: ldc_w 306
    //   364: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   367: aload_0
    //   368: getfield 145	android/hardware/Camera$Size:width	I
    //   371: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   374: ldc 81
    //   376: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: aload_0
    //   380: getfield 148	android/hardware/Camera$Size:height	I
    //   383: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   386: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 73	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   392: iconst_0
    //   393: ireturn
    //   394: aload 5
    //   396: ifnull +35 -> 431
    //   399: aload 5
    //   401: ldc_w 308
    //   404: invokeinterface 242 2 0
    //   409: iflt +22 -> 431
    //   412: aload 4
    //   414: ldc_w 308
    //   417: invokevirtual 245	android/hardware/Camera$Parameters:setFocusMode	(Ljava/lang/String;)V
    //   420: ldc 8
    //   422: ldc_w 310
    //   425: invokestatic 73	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   428: goto -310 -> 118
    //   431: ldc 8
    //   433: ldc_w 312
    //   436: invokestatic 73	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   439: goto -321 -> 118
    //   442: astore 4
    //   444: ldc 8
    //   446: new 49	java/lang/StringBuilder
    //   449: dup
    //   450: ldc_w 314
    //   453: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   456: aload 4
    //   458: invokevirtual 317	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   461: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokestatic 167	com/tencent/youtu/ytcommon/tools/YTLogger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   470: aload 4
    //   472: invokestatic 236	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   475: aload_1
    //   476: invokevirtual 215	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   479: astore 4
    //   481: goto -351 -> 130
    //   484: astore_0
    //   485: aload_1
    //   486: invokevirtual 215	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   489: pop
    //   490: aload_0
    //   491: athrow
    //   492: iload_2
    //   493: iconst_5
    //   494: invokestatic 264	android/media/CamcorderProfile:hasProfile	(II)Z
    //   497: ifeq +50 -> 547
    //   500: iload_2
    //   501: iconst_5
    //   502: invokestatic 267	android/media/CamcorderProfile:get	(II)Landroid/media/CamcorderProfile;
    //   505: astore_0
    //   506: ldc 8
    //   508: new 49	java/lang/StringBuilder
    //   511: dup
    //   512: ldc_w 319
    //   515: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   518: aload_0
    //   519: getfield 272	android/media/CamcorderProfile:videoFrameWidth	I
    //   522: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   525: ldc_w 274
    //   528: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: aload_0
    //   532: getfield 277	android/media/CamcorderProfile:videoFrameHeight	I
    //   535: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   538: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   541: invokestatic 73	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   544: goto -329 -> 215
    //   547: iload_2
    //   548: iconst_1
    //   549: invokestatic 267	android/media/CamcorderProfile:get	(II)Landroid/media/CamcorderProfile;
    //   552: astore_0
    //   553: ldc 8
    //   555: new 49	java/lang/StringBuilder
    //   558: dup
    //   559: ldc_w 321
    //   562: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   565: aload_0
    //   566: getfield 272	android/media/CamcorderProfile:videoFrameWidth	I
    //   569: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   572: ldc_w 274
    //   575: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: aload_0
    //   579: getfield 277	android/media/CamcorderProfile:videoFrameHeight	I
    //   582: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   585: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   588: invokestatic 73	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   591: goto -376 -> 215
    //   594: astore_0
    //   595: ldc 8
    //   597: new 49	java/lang/StringBuilder
    //   600: dup
    //   601: ldc_w 314
    //   604: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   607: aload_0
    //   608: invokevirtual 317	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   611: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   617: invokestatic 167	com/tencent/youtu/ytcommon/tools/YTLogger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   620: aload_0
    //   621: invokestatic 236	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   624: goto -379 -> 245
    //   627: astore_0
    //   628: ldc 8
    //   630: new 49	java/lang/StringBuilder
    //   633: dup
    //   634: ldc_w 323
    //   637: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   640: aload_0
    //   641: invokevirtual 317	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   644: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   650: invokestatic 167	com/tencent/youtu/ytcommon/tools/YTLogger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   653: aload_0
    //   654: invokestatic 236	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   657: goto -372 -> 285
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	660	0	paramContext	Context
    //   0	660	1	paramCamera	Camera
    //   0	660	2	paramInt	int
    //   14	140	3	i	int
    //   4	409	4	localParameters1	Camera.Parameters
    //   442	29	4	localException	java.lang.Exception
    //   479	1	4	localParameters2	Camera.Parameters
    //   11	389	5	localList	List
    // Exception table:
    //   from	to	target	type
    //   0	6	73	java/lang/Exception
    //   118	124	442	java/lang/Exception
    //   118	124	484	finally
    //   444	475	484	finally
    //   239	245	594	java/lang/Exception
    //   280	285	627	java/lang/Exception
  }
  
  public static void setVideoSize(Camera.Parameters paramParameters, CamcorderProfile paramCamcorderProfile)
  {
    Object localObject = paramParameters.getSupportedPreviewSizes();
    if (paramParameters.getSupportedVideoSizes() == null)
    {
      YTLogger.d("CameraSetting", "video size from profile is : " + paramCamcorderProfile.videoFrameWidth + " " + paramCamcorderProfile.videoFrameHeight);
      if (getOptimalPreviewSize((List)localObject, paramCamcorderProfile.videoFrameWidth, paramCamcorderProfile.videoFrameHeight) == null)
      {
        YTLogger.d("CameraSetting", "do not find proper preview size, use default");
        paramCamcorderProfile.videoFrameWidth = 640;
        paramCamcorderProfile.videoFrameHeight = 480;
      }
    }
    paramParameters = paramParameters.getSupportedVideoSizes();
    if (paramParameters != null)
    {
      int i = 0;
      int k;
      for (int j = 0; i < paramParameters.size(); j = k)
      {
        localObject = (Camera.Size)paramParameters.get(i);
        k = j;
        if (((Camera.Size)localObject).width == paramCamcorderProfile.videoFrameWidth)
        {
          k = j;
          if (((Camera.Size)localObject).height == paramCamcorderProfile.videoFrameHeight) {
            k = 1;
          }
        }
        i += 1;
      }
      if (j == 0)
      {
        paramCamcorderProfile.videoFrameWidth = 640;
        paramCamcorderProfile.videoFrameHeight = 480;
      }
    }
    YTLogger.d("CameraSetting", "select video size camcorderProfile:" + paramCamcorderProfile.videoFrameWidth + "x" + paramCamcorderProfile.videoFrameHeight);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.tools.CameraSetting
 * JD-Core Version:    0.7.0.1
 */