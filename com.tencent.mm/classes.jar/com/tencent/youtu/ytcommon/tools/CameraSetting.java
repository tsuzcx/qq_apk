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
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(118083);
    Object localObject = paramParameters.getSupportedPreviewFpsRange().iterator();
    while (((Iterator)localObject).hasNext())
    {
      int[] arrayOfInt = (int[])((Iterator)localObject).next();
      YTLogger.d("CameraSetting", "entry: " + arrayOfInt[0] + " - " + arrayOfInt[1]);
      if ((arrayOfInt[0] == arrayOfInt[1]) && (arrayOfInt[0] == paramInt))
      {
        paramParameters.setPreviewFpsRange(arrayOfInt[0], arrayOfInt[1]);
        YTLogger.d("CameraSetting", "use preview fps range: " + arrayOfInt[0] + " " + arrayOfInt[1]);
        paramInt = arrayOfInt[0];
        AppMethodBeat.o(118083);
        return paramInt;
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
          break label323;
        }
        j = Integer.parseInt(localObject[i]) * 1000;
        if (paramInt < j)
        {
          paramParameters.setPreviewFrameRate(j / 1000);
          AppMethodBeat.o(118083);
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
      label323:
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
    AppMethodBeat.o(118083);
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
    AppMethodBeat.i(118082);
    if (paramList == null)
    {
      AppMethodBeat.o(118082);
      return null;
    }
    Object localObject1 = null;
    double d1 = 1.7976931348623157E+308D;
    int i = Math.max(paramInt1, paramInt2);
    paramInt1 = Math.min(paramInt1, paramInt2);
    double d2 = i / paramInt1;
    YTLogger.d("CameraSetting", "sizes size=" + paramList.size());
    Iterator localIterator = paramList.iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (Camera.Size)localIterator.next();
      if (Math.abs(((Camera.Size)localObject2).width / ((Camera.Size)localObject2).height - d2) <= 0.001D)
      {
        if (Math.abs(((Camera.Size)localObject2).height - paramInt1) >= d1) {
          break label254;
        }
        d1 = Math.abs(((Camera.Size)localObject2).height - paramInt1);
        localObject1 = localObject2;
      }
    }
    label254:
    for (;;)
    {
      break;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
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
      AppMethodBeat.o(118082);
      return localObject2;
    }
  }
  
  public static int getRotateTag(int paramInt)
  {
    AppMethodBeat.i(118078);
    int i = 1;
    if (paramInt == 90) {
      paramInt = 7;
    }
    for (;;)
    {
      AppMethodBeat.o(118078);
      return paramInt;
      if (paramInt == 270)
      {
        paramInt = 5;
      }
      else
      {
        YTLogger.w("CameraSetting", "获取摄像头转向结果的时候值不为90或者180");
        paramInt = i;
      }
    }
  }
  
  public static int getVideoRotate(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(118079);
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
      AppMethodBeat.o(118079);
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
    //   0: ldc 224
    //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokevirtual 228	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   9: astore 4
    //   11: aload 4
    //   13: invokevirtual 231	android/hardware/Camera$Parameters:getSupportedFocusModes	()Ljava/util/List;
    //   16: astore 5
    //   18: iconst_0
    //   19: istore_3
    //   20: iload_3
    //   21: aload 5
    //   23: invokeinterface 150 1 0
    //   28: if_icmpge +69 -> 97
    //   31: ldc 8
    //   33: new 56	java/lang/StringBuilder
    //   36: dup
    //   37: ldc 233
    //   39: invokespecial 61	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   42: iload_3
    //   43: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: ldc 235
    //   48: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload 5
    //   53: iload_3
    //   54: invokeinterface 238 2 0
    //   59: checkcast 110	java/lang/String
    //   62: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 241	com/tencent/youtu/ytcommon/tools/YTLogger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: iload_3
    //   72: iconst_1
    //   73: iadd
    //   74: istore_3
    //   75: goto -55 -> 20
    //   78: astore_0
    //   79: ldc 8
    //   81: ldc 243
    //   83: invokestatic 178	com/tencent/youtu/ytcommon/tools/YTLogger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: aload_0
    //   87: invokestatic 249	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   90: ldc 224
    //   92: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: iconst_1
    //   96: ireturn
    //   97: aload 5
    //   99: ifnull +295 -> 394
    //   102: aload 5
    //   104: ldc 251
    //   106: invokeinterface 255 2 0
    //   111: iflt +283 -> 394
    //   114: aload 4
    //   116: ldc 251
    //   118: invokevirtual 258	android/hardware/Camera$Parameters:setFocusMode	(Ljava/lang/String;)V
    //   121: ldc 8
    //   123: ldc_w 260
    //   126: invokestatic 80	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: aload_1
    //   130: aload 4
    //   132: invokevirtual 264	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   135: aload_1
    //   136: invokevirtual 228	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   139: astore 4
    //   141: aload_0
    //   142: iload_2
    //   143: invokestatic 266	com/tencent/youtu/ytcommon/tools/CameraSetting:getVideoRotate	(Landroid/content/Context;I)I
    //   146: istore_3
    //   147: aload_1
    //   148: iload_3
    //   149: invokevirtual 269	android/hardware/Camera:setDisplayOrientation	(I)V
    //   152: ldc 8
    //   154: ldc_w 271
    //   157: iload_3
    //   158: invokestatic 275	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   161: invokevirtual 278	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   164: invokestatic 80	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: iload_2
    //   168: iconst_4
    //   169: invokestatic 284	android/media/CamcorderProfile:hasProfile	(II)Z
    //   172: ifeq +325 -> 497
    //   175: iload_2
    //   176: iconst_4
    //   177: invokestatic 287	android/media/CamcorderProfile:get	(II)Landroid/media/CamcorderProfile;
    //   180: astore_0
    //   181: ldc 8
    //   183: new 56	java/lang/StringBuilder
    //   186: dup
    //   187: ldc_w 289
    //   190: invokespecial 61	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   193: aload_0
    //   194: getfield 292	android/media/CamcorderProfile:videoFrameWidth	I
    //   197: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   200: ldc_w 294
    //   203: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload_0
    //   207: getfield 297	android/media/CamcorderProfile:videoFrameHeight	I
    //   210: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   213: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 80	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload 4
    //   221: aload_0
    //   222: invokestatic 301	com/tencent/youtu/ytcommon/tools/CameraSetting:setVideoSize	(Landroid/hardware/Camera$Parameters;Landroid/media/CamcorderProfile;)V
    //   225: aload 4
    //   227: getstatic 15	com/tencent/youtu/ytcommon/tools/CameraSetting:mDesiredPreviewWidth	I
    //   230: getstatic 17	com/tencent/youtu/ytcommon/tools/CameraSetting:mDesiredPreviewHeight	I
    //   233: invokevirtual 304	android/hardware/Camera$Parameters:setPreviewSize	(II)V
    //   236: aload 4
    //   238: bipush 17
    //   240: invokevirtual 307	android/hardware/Camera$Parameters:setPreviewFormat	(I)V
    //   243: aload_1
    //   244: aload 4
    //   246: invokevirtual 264	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   249: aload_1
    //   250: invokevirtual 228	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   253: astore_0
    //   254: ldc 8
    //   256: ldc_w 309
    //   259: aload_0
    //   260: sipush 30000
    //   263: invokestatic 311	com/tencent/youtu/ytcommon/tools/CameraSetting:chooseFixedPreviewFps	(Landroid/hardware/Camera$Parameters;I)I
    //   266: invokestatic 275	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   269: invokevirtual 278	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   272: invokestatic 80	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   275: aload_1
    //   276: aload_0
    //   277: invokevirtual 264	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   280: aload_1
    //   281: invokevirtual 228	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   284: astore_0
    //   285: iconst_2
    //   286: newarray int
    //   288: astore_1
    //   289: aload_0
    //   290: aload_1
    //   291: invokevirtual 95	android/hardware/Camera$Parameters:getPreviewFpsRange	([I)V
    //   294: aload_0
    //   295: invokevirtual 314	android/hardware/Camera$Parameters:getPreviewFrameRate	()I
    //   298: istore_2
    //   299: ldc 8
    //   301: new 56	java/lang/StringBuilder
    //   304: dup
    //   305: ldc_w 316
    //   308: invokespecial 61	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   311: aload_1
    //   312: iconst_0
    //   313: iaload
    //   314: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   317: ldc_w 318
    //   320: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: aload_1
    //   324: iconst_1
    //   325: iaload
    //   326: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   329: ldc_w 320
    //   332: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: iload_2
    //   336: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   339: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 80	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: aload_0
    //   346: invokevirtual 324	android/hardware/Camera$Parameters:getPreviewSize	()Landroid/hardware/Camera$Size;
    //   349: astore_0
    //   350: ldc 8
    //   352: new 56	java/lang/StringBuilder
    //   355: dup
    //   356: ldc_w 326
    //   359: invokespecial 61	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   362: aload_0
    //   363: getfield 155	android/hardware/Camera$Size:width	I
    //   366: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   369: ldc 88
    //   371: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: aload_0
    //   375: getfield 158	android/hardware/Camera$Size:height	I
    //   378: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   381: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: invokestatic 80	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   387: ldc 224
    //   389: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   392: iconst_0
    //   393: ireturn
    //   394: aload 5
    //   396: ifnull +35 -> 431
    //   399: aload 5
    //   401: ldc_w 328
    //   404: invokeinterface 255 2 0
    //   409: iflt +22 -> 431
    //   412: aload 4
    //   414: ldc_w 328
    //   417: invokevirtual 258	android/hardware/Camera$Parameters:setFocusMode	(Ljava/lang/String;)V
    //   420: ldc 8
    //   422: ldc_w 330
    //   425: invokestatic 80	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   428: goto -299 -> 129
    //   431: ldc 8
    //   433: ldc_w 332
    //   436: invokestatic 80	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   439: goto -310 -> 129
    //   442: astore 4
    //   444: ldc 8
    //   446: new 56	java/lang/StringBuilder
    //   449: dup
    //   450: ldc_w 334
    //   453: invokespecial 61	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   456: aload 4
    //   458: invokevirtual 337	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   461: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokestatic 178	com/tencent/youtu/ytcommon/tools/YTLogger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   470: aload 4
    //   472: invokestatic 249	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   475: aload_1
    //   476: invokevirtual 228	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   479: astore 4
    //   481: goto -340 -> 141
    //   484: astore_0
    //   485: aload_1
    //   486: invokevirtual 228	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   489: pop
    //   490: ldc 224
    //   492: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   495: aload_0
    //   496: athrow
    //   497: iload_2
    //   498: iconst_5
    //   499: invokestatic 284	android/media/CamcorderProfile:hasProfile	(II)Z
    //   502: ifeq +50 -> 552
    //   505: iload_2
    //   506: iconst_5
    //   507: invokestatic 287	android/media/CamcorderProfile:get	(II)Landroid/media/CamcorderProfile;
    //   510: astore_0
    //   511: ldc 8
    //   513: new 56	java/lang/StringBuilder
    //   516: dup
    //   517: ldc_w 339
    //   520: invokespecial 61	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   523: aload_0
    //   524: getfield 292	android/media/CamcorderProfile:videoFrameWidth	I
    //   527: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   530: ldc_w 294
    //   533: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: aload_0
    //   537: getfield 297	android/media/CamcorderProfile:videoFrameHeight	I
    //   540: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   543: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   546: invokestatic 80	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   549: goto -330 -> 219
    //   552: iload_2
    //   553: iconst_1
    //   554: invokestatic 287	android/media/CamcorderProfile:get	(II)Landroid/media/CamcorderProfile;
    //   557: astore_0
    //   558: ldc 8
    //   560: new 56	java/lang/StringBuilder
    //   563: dup
    //   564: ldc_w 341
    //   567: invokespecial 61	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   570: aload_0
    //   571: getfield 292	android/media/CamcorderProfile:videoFrameWidth	I
    //   574: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   577: ldc_w 294
    //   580: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: aload_0
    //   584: getfield 297	android/media/CamcorderProfile:videoFrameHeight	I
    //   587: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   590: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   593: invokestatic 80	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   596: goto -377 -> 219
    //   599: astore_0
    //   600: ldc 8
    //   602: new 56	java/lang/StringBuilder
    //   605: dup
    //   606: ldc_w 334
    //   609: invokespecial 61	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   612: aload_0
    //   613: invokevirtual 337	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   616: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   622: invokestatic 178	com/tencent/youtu/ytcommon/tools/YTLogger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   625: aload_0
    //   626: invokestatic 249	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   629: goto -380 -> 249
    //   632: astore_0
    //   633: ldc 8
    //   635: new 56	java/lang/StringBuilder
    //   638: dup
    //   639: ldc_w 343
    //   642: invokespecial 61	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   645: aload_0
    //   646: invokevirtual 337	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   649: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   655: invokestatic 178	com/tencent/youtu/ytcommon/tools/YTLogger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   658: aload_0
    //   659: invokestatic 249	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   662: goto -382 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	665	0	paramContext	Context
    //   0	665	1	paramCamera	Camera
    //   0	665	2	paramInt	int
    //   19	139	3	i	int
    //   9	404	4	localParameters1	Camera.Parameters
    //   442	29	4	localException	java.lang.Exception
    //   479	1	4	localParameters2	Camera.Parameters
    //   16	384	5	localList	List
    // Exception table:
    //   from	to	target	type
    //   5	11	78	java/lang/Exception
    //   129	135	442	java/lang/Exception
    //   129	135	484	finally
    //   444	475	484	finally
    //   243	249	599	java/lang/Exception
    //   275	280	632	java/lang/Exception
  }
  
  public static void setVideoSize(Camera.Parameters paramParameters, CamcorderProfile paramCamcorderProfile)
  {
    AppMethodBeat.i(118081);
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
    AppMethodBeat.o(118081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.tools.CameraSetting
 * JD-Core Version:    0.7.0.1
 */