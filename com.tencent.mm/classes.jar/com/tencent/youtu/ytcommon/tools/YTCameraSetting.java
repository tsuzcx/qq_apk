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

public class YTCameraSetting
{
  private static final String TAG = "YTCameraSetting";
  public static int mCameraFacing = 1;
  static int mDesiredPreviewHeight = 480;
  static int mDesiredPreviewWidth;
  public static int mRotate = 0;
  
  static
  {
    mDesiredPreviewWidth = 640;
  }
  
  private static int chooseFixedPreviewFps(Camera.Parameters paramParameters, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(73372);
    Object localObject = paramParameters.getSupportedPreviewFpsRange().iterator();
    while (((Iterator)localObject).hasNext())
    {
      int[] arrayOfInt = (int[])((Iterator)localObject).next();
      YTLogger.d("YTCameraSetting", "entry: " + arrayOfInt[0] + " - " + arrayOfInt[1]);
      if ((arrayOfInt[0] == arrayOfInt[1]) && (arrayOfInt[0] == paramInt))
      {
        paramParameters.setPreviewFpsRange(arrayOfInt[0], arrayOfInt[1]);
        YTLogger.d("YTCameraSetting", "use preview fps range: " + arrayOfInt[0] + " " + arrayOfInt[1]);
        paramInt = arrayOfInt[0];
        AppMethodBeat.o(73372);
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
          AppMethodBeat.o(73372);
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
    AppMethodBeat.o(73372);
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
    AppMethodBeat.i(73371);
    if (paramList == null)
    {
      AppMethodBeat.o(73371);
      return null;
    }
    Object localObject1 = null;
    double d1 = 1.7976931348623157E+308D;
    int i = Math.max(paramInt1, paramInt2);
    paramInt1 = Math.min(paramInt1, paramInt2);
    double d2 = i / paramInt1;
    YTLogger.d("YTCameraSetting", "sizes size=" + paramList.size());
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
        YTLogger.d("YTCameraSetting", "No preview size match the aspect ratio");
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
      AppMethodBeat.o(73371);
      return localObject2;
    }
  }
  
  public static int getRotate(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(73365);
    paramInt1 = getRotateTag(getVideoRotate(paramContext, paramInt1), paramInt2);
    AppMethodBeat.o(73365);
    return paramInt1;
  }
  
  public static int getRotateTag(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(73367);
    if (paramInt1 == 90) {
      paramInt1 = 7;
    }
    while (paramInt2 == 1)
    {
      AppMethodBeat.o(73367);
      return paramInt1;
      if (paramInt1 == 180)
      {
        paramInt1 = 3;
      }
      else if (paramInt1 == 270)
      {
        paramInt1 = 5;
      }
      else
      {
        YTLogger.i("YTCameraSetting", "camera rotate not 90degree or 180degree, input: ".concat(String.valueOf(paramInt1)));
        paramInt1 = 1;
      }
    }
    paramInt1 = transBackFacingCameraRatateTag(paramInt1);
    AppMethodBeat.o(73367);
    return paramInt1;
  }
  
  public static int getVideoRotate(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(73368);
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
      YTLogger.i("YTCameraSetting", "debug camera orientation is " + localCameraInfo.orientation + " ui degrees is " + paramInt);
      AppMethodBeat.o(73368);
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
    //   0: ldc 246
    //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokevirtual 250	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   9: astore 4
    //   11: aload 4
    //   13: invokevirtual 253	android/hardware/Camera$Parameters:getSupportedFocusModes	()Ljava/util/List;
    //   16: astore 5
    //   18: iconst_0
    //   19: istore_3
    //   20: iload_3
    //   21: aload 5
    //   23: invokeinterface 156 1 0
    //   28: if_icmpge +71 -> 99
    //   31: ldc 8
    //   33: new 62	java/lang/StringBuilder
    //   36: dup
    //   37: ldc 255
    //   39: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   42: iload_3
    //   43: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: ldc_w 257
    //   49: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload 5
    //   54: iload_3
    //   55: invokeinterface 260 2 0
    //   60: checkcast 116	java/lang/String
    //   63: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 263	com/tencent/youtu/ytcommon/tools/YTLogger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: iload_3
    //   73: iconst_1
    //   74: iadd
    //   75: istore_3
    //   76: goto -56 -> 20
    //   79: astore_0
    //   80: ldc 8
    //   82: ldc_w 265
    //   85: invokestatic 268	com/tencent/youtu/ytcommon/tools/YTLogger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_0
    //   89: invokestatic 274	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   92: ldc 246
    //   94: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: iconst_1
    //   98: ireturn
    //   99: aload 5
    //   101: ifnull +297 -> 398
    //   104: aload 5
    //   106: ldc_w 276
    //   109: invokeinterface 280 2 0
    //   114: iflt +284 -> 398
    //   117: aload 4
    //   119: ldc_w 276
    //   122: invokevirtual 283	android/hardware/Camera$Parameters:setFocusMode	(Ljava/lang/String;)V
    //   125: ldc 8
    //   127: ldc_w 285
    //   130: invokestatic 86	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: aload_1
    //   134: aload 4
    //   136: invokevirtual 289	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   139: aload_1
    //   140: invokevirtual 250	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   143: astore 4
    //   145: aload_0
    //   146: iload_2
    //   147: invokestatic 184	com/tencent/youtu/ytcommon/tools/YTCameraSetting:getVideoRotate	(Landroid/content/Context;I)I
    //   150: istore_3
    //   151: aload_1
    //   152: iload_3
    //   153: invokevirtual 292	android/hardware/Camera:setDisplayOrientation	(I)V
    //   156: ldc 8
    //   158: ldc_w 294
    //   161: iload_3
    //   162: invokestatic 194	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   165: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   168: invokestatic 86	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: iload_2
    //   172: iconst_4
    //   173: invokestatic 300	android/media/CamcorderProfile:hasProfile	(II)Z
    //   176: ifeq +325 -> 501
    //   179: iload_2
    //   180: iconst_4
    //   181: invokestatic 303	android/media/CamcorderProfile:get	(II)Landroid/media/CamcorderProfile;
    //   184: astore_0
    //   185: ldc 8
    //   187: new 62	java/lang/StringBuilder
    //   190: dup
    //   191: ldc_w 305
    //   194: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   197: aload_0
    //   198: getfield 308	android/media/CamcorderProfile:videoFrameWidth	I
    //   201: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   204: ldc_w 310
    //   207: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_0
    //   211: getfield 313	android/media/CamcorderProfile:videoFrameHeight	I
    //   214: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   217: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 86	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: aload 4
    //   225: aload_0
    //   226: invokestatic 317	com/tencent/youtu/ytcommon/tools/YTCameraSetting:setVideoSize	(Landroid/hardware/Camera$Parameters;Landroid/media/CamcorderProfile;)V
    //   229: aload 4
    //   231: getstatic 21	com/tencent/youtu/ytcommon/tools/YTCameraSetting:mDesiredPreviewWidth	I
    //   234: getstatic 23	com/tencent/youtu/ytcommon/tools/YTCameraSetting:mDesiredPreviewHeight	I
    //   237: invokevirtual 320	android/hardware/Camera$Parameters:setPreviewSize	(II)V
    //   240: aload 4
    //   242: bipush 17
    //   244: invokevirtual 323	android/hardware/Camera$Parameters:setPreviewFormat	(I)V
    //   247: aload_1
    //   248: aload 4
    //   250: invokevirtual 289	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   253: aload_1
    //   254: invokevirtual 250	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   257: astore_0
    //   258: ldc 8
    //   260: ldc_w 325
    //   263: aload_0
    //   264: sipush 30000
    //   267: invokestatic 327	com/tencent/youtu/ytcommon/tools/YTCameraSetting:chooseFixedPreviewFps	(Landroid/hardware/Camera$Parameters;I)I
    //   270: invokestatic 194	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   273: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   276: invokestatic 86	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: aload_1
    //   280: aload_0
    //   281: invokevirtual 289	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   284: aload_1
    //   285: invokevirtual 250	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   288: astore_0
    //   289: iconst_2
    //   290: newarray int
    //   292: astore_1
    //   293: aload_0
    //   294: aload_1
    //   295: invokevirtual 101	android/hardware/Camera$Parameters:getPreviewFpsRange	([I)V
    //   298: aload_0
    //   299: invokevirtual 330	android/hardware/Camera$Parameters:getPreviewFrameRate	()I
    //   302: istore_2
    //   303: ldc 8
    //   305: new 62	java/lang/StringBuilder
    //   308: dup
    //   309: ldc_w 332
    //   312: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   315: aload_1
    //   316: iconst_0
    //   317: iaload
    //   318: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   321: ldc_w 334
    //   324: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload_1
    //   328: iconst_1
    //   329: iaload
    //   330: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   333: ldc_w 336
    //   336: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: iload_2
    //   340: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   343: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokestatic 86	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   349: aload_0
    //   350: invokevirtual 340	android/hardware/Camera$Parameters:getPreviewSize	()Landroid/hardware/Camera$Size;
    //   353: astore_0
    //   354: ldc 8
    //   356: new 62	java/lang/StringBuilder
    //   359: dup
    //   360: ldc_w 342
    //   363: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   366: aload_0
    //   367: getfield 161	android/hardware/Camera$Size:width	I
    //   370: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   373: ldc 94
    //   375: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: aload_0
    //   379: getfield 164	android/hardware/Camera$Size:height	I
    //   382: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   385: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 86	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   391: ldc 246
    //   393: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   396: iconst_0
    //   397: ireturn
    //   398: aload 5
    //   400: ifnull +35 -> 435
    //   403: aload 5
    //   405: ldc_w 344
    //   408: invokeinterface 280 2 0
    //   413: iflt +22 -> 435
    //   416: aload 4
    //   418: ldc_w 344
    //   421: invokevirtual 283	android/hardware/Camera$Parameters:setFocusMode	(Ljava/lang/String;)V
    //   424: ldc 8
    //   426: ldc_w 346
    //   429: invokestatic 86	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   432: goto -299 -> 133
    //   435: ldc 8
    //   437: ldc_w 348
    //   440: invokestatic 86	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   443: goto -310 -> 133
    //   446: astore 4
    //   448: ldc 8
    //   450: new 62	java/lang/StringBuilder
    //   453: dup
    //   454: ldc_w 350
    //   457: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   460: aload 4
    //   462: invokevirtual 353	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   465: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   471: invokestatic 268	com/tencent/youtu/ytcommon/tools/YTLogger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   474: aload 4
    //   476: invokestatic 274	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   479: aload_1
    //   480: invokevirtual 250	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   483: astore 4
    //   485: goto -340 -> 145
    //   488: astore_0
    //   489: aload_1
    //   490: invokevirtual 250	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   493: pop
    //   494: ldc 246
    //   496: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   499: aload_0
    //   500: athrow
    //   501: iload_2
    //   502: iconst_5
    //   503: invokestatic 300	android/media/CamcorderProfile:hasProfile	(II)Z
    //   506: ifeq +50 -> 556
    //   509: iload_2
    //   510: iconst_5
    //   511: invokestatic 303	android/media/CamcorderProfile:get	(II)Landroid/media/CamcorderProfile;
    //   514: astore_0
    //   515: ldc 8
    //   517: new 62	java/lang/StringBuilder
    //   520: dup
    //   521: ldc_w 355
    //   524: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   527: aload_0
    //   528: getfield 308	android/media/CamcorderProfile:videoFrameWidth	I
    //   531: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   534: ldc_w 310
    //   537: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: aload_0
    //   541: getfield 313	android/media/CamcorderProfile:videoFrameHeight	I
    //   544: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   547: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: invokestatic 86	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   553: goto -330 -> 223
    //   556: iload_2
    //   557: iconst_1
    //   558: invokestatic 303	android/media/CamcorderProfile:get	(II)Landroid/media/CamcorderProfile;
    //   561: astore_0
    //   562: ldc 8
    //   564: new 62	java/lang/StringBuilder
    //   567: dup
    //   568: ldc_w 357
    //   571: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   574: aload_0
    //   575: getfield 308	android/media/CamcorderProfile:videoFrameWidth	I
    //   578: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   581: ldc_w 310
    //   584: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: aload_0
    //   588: getfield 313	android/media/CamcorderProfile:videoFrameHeight	I
    //   591: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   594: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   597: invokestatic 86	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   600: goto -377 -> 223
    //   603: astore_0
    //   604: ldc 8
    //   606: new 62	java/lang/StringBuilder
    //   609: dup
    //   610: ldc_w 350
    //   613: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   616: aload_0
    //   617: invokevirtual 353	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   620: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   626: invokestatic 268	com/tencent/youtu/ytcommon/tools/YTLogger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   629: aload_0
    //   630: invokestatic 274	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   633: goto -380 -> 253
    //   636: astore_0
    //   637: ldc 8
    //   639: new 62	java/lang/StringBuilder
    //   642: dup
    //   643: ldc_w 359
    //   646: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   649: aload_0
    //   650: invokevirtual 353	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   653: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   659: invokestatic 268	com/tencent/youtu/ytcommon/tools/YTLogger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   662: aload_0
    //   663: invokestatic 274	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   666: goto -382 -> 284
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	669	0	paramContext	Context
    //   0	669	1	paramCamera	Camera
    //   0	669	2	paramInt	int
    //   19	143	3	i	int
    //   9	408	4	localParameters1	Camera.Parameters
    //   446	29	4	localException	java.lang.Exception
    //   483	1	4	localParameters2	Camera.Parameters
    //   16	388	5	localList	List
    // Exception table:
    //   from	to	target	type
    //   5	11	79	java/lang/Exception
    //   133	139	446	java/lang/Exception
    //   133	139	488	finally
    //   448	479	488	finally
    //   247	253	603	java/lang/Exception
    //   279	284	636	java/lang/Exception
  }
  
  public static void setCameraFacing(int paramInt)
  {
    mCameraFacing = paramInt;
  }
  
  public static void setCameraRotate(int paramInt)
  {
    mRotate = paramInt;
  }
  
  public static void setVideoSize(Camera.Parameters paramParameters, CamcorderProfile paramCamcorderProfile)
  {
    AppMethodBeat.i(73370);
    Object localObject = paramParameters.getSupportedPreviewSizes();
    if (paramParameters.getSupportedVideoSizes() == null)
    {
      YTLogger.d("YTCameraSetting", "video size from profile is : " + paramCamcorderProfile.videoFrameWidth + " " + paramCamcorderProfile.videoFrameHeight);
      if (getOptimalPreviewSize((List)localObject, paramCamcorderProfile.videoFrameWidth, paramCamcorderProfile.videoFrameHeight) == null)
      {
        YTLogger.d("YTCameraSetting", "do not find proper preview size, use default");
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
    YTLogger.d("YTCameraSetting", "select video size camcorderProfile:" + paramCamcorderProfile.videoFrameWidth + "x" + paramCamcorderProfile.videoFrameHeight);
    AppMethodBeat.o(73370);
  }
  
  public static int transBackFacingCameraRatateTag(int paramInt)
  {
    AppMethodBeat.i(73366);
    if (paramInt == 1)
    {
      AppMethodBeat.o(73366);
      return 2;
    }
    if (paramInt == 2)
    {
      AppMethodBeat.o(73366);
      return 1;
    }
    if (paramInt == 3)
    {
      AppMethodBeat.o(73366);
      return 4;
    }
    if (paramInt == 4)
    {
      AppMethodBeat.o(73366);
      return 3;
    }
    if (paramInt == 5)
    {
      AppMethodBeat.o(73366);
      return 8;
    }
    if (paramInt == 6)
    {
      AppMethodBeat.o(73366);
      return 7;
    }
    if (paramInt == 7)
    {
      AppMethodBeat.o(73366);
      return 6;
    }
    if (paramInt == 8)
    {
      AppMethodBeat.o(73366);
      return 5;
    }
    YTLogger.w("YTCameraSetting", "[YTCameraSetting.transBackFacingCameraRatateTag] unsurported rotateTag: ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(73366);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.tools.YTCameraSetting
 * JD-Core Version:    0.7.0.1
 */