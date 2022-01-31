import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.AsyncTask;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.businessCard.helpers.CameraHelper;
import com.tencent.mobileqq.businessCard.helpers.CameraHelper.CameraHelperCallback;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class abvo
  extends AsyncTask
{
  Rect jdField_a_of_type_AndroidGraphicsRect;
  CameraHelper.CameraHelperCallback jdField_a_of_type_ComTencentMobileqqBusinessCardHelpersCameraHelper$CameraHelperCallback;
  File jdField_a_of_type_JavaIoFile;
  byte[] jdField_a_of_type_ArrayOfByte;
  Rect b;
  
  public abvo(CameraHelper paramCameraHelper, byte[] paramArrayOfByte, File paramFile, Rect paramRect1, Rect paramRect2, CameraHelper.CameraHelperCallback paramCameraHelperCallback)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect1;
    this.b = paramRect2;
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardHelpersCameraHelper$CameraHelperCallback = paramCameraHelperCallback;
  }
  
  protected String a(Void... paramVarArgs)
  {
    File localFile = this.jdField_a_of_type_JavaIoFile;
    int i = 0;
    for (;;)
    {
      long l4;
      try
      {
        if (this.jdField_a_of_type_ArrayOfByte == null) {
          break label761;
        }
        long l1 = Runtime.getRuntime().totalMemory() / 1024L;
        long l2 = Runtime.getRuntime().maxMemory() / 1024L;
        long l3 = Runtime.getRuntime().freeMemory() / 1024L;
        l4 = l2 - (l1 - l3);
        if (QLog.isColorLevel()) {
          QLog.d(CameraHelper.jdField_a_of_type_JavaLangString, 2, "remain= " + l4 + ",totalMemory=" + l1 + ",maxMemory=" + l2 + ",freeMemory" + l3);
        }
        if (l4 >= 51200L) {
          break label769;
        }
        URLDrawable.clearMemoryCache();
        System.gc();
      }
      catch (Exception paramVarArgs)
      {
        int j;
        int m;
        int n;
        Object localObject;
        float f;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(CameraHelper.jdField_a_of_type_JavaLangString, 2, paramVarArgs.toString());
        continue;
      }
      catch (OutOfMemoryError paramVarArgs)
      {
        System.gc();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(CameraHelper.jdField_a_of_type_JavaLangString, 2, paramVarArgs.toString());
        continue;
      }
      paramVarArgs = BitmapManager.a(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte.length);
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardHelpersCameraHelper.jdField_a_of_type_AndroidHardwareCamera.stopPreview();
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardHelpersCameraHelper.jdField_a_of_type_Boolean = false;
      int k = i;
      if (paramVarArgs != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(CameraHelper.jdField_a_of_type_JavaLangString, 2, "bitmap with=" + paramVarArgs.getWidth() + " height=" + paramVarArgs.getHeight());
        }
        j = 1020;
        i = this.jdField_a_of_type_AndroidGraphicsRect.height() * 1020 / this.jdField_a_of_type_AndroidGraphicsRect.width();
        if ((1020 <= paramVarArgs.getHeight()) && (i <= paramVarArgs.getWidth())) {
          continue;
        }
        j = paramVarArgs.getHeight();
        i = paramVarArgs.getWidth();
        if (k != 0) {
          System.gc();
        }
        if ((QLog.isColorLevel()) && (paramVarArgs != null)) {
          QLog.d(CameraHelper.jdField_a_of_type_JavaLangString, 2, "scale with=" + paramVarArgs.getWidth() + " height=" + paramVarArgs.getHeight());
        }
        m = this.b.height() * i / this.jdField_a_of_type_AndroidGraphicsRect.height();
        n = this.b.width() * j / this.jdField_a_of_type_AndroidGraphicsRect.width();
        localObject = new Rect((i - m) / 2, (j - n) / 2, (i + m) / 2, (j + n) / 2);
        if (QLog.isColorLevel()) {
          QLog.d(CameraHelper.jdField_a_of_type_JavaLangString, 2, "resizeRect: " + ((Rect)localObject).toString() + " resizeRectW= " + m + " resizeRectH= " + n);
        }
        paramVarArgs = Bitmap.createBitmap(paramVarArgs, ((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).width(), ((Rect)localObject).height());
        if (k != 0) {
          System.gc();
        }
        paramVarArgs = Bitmap.createScaledBitmap(paramVarArgs, 600, 1000, true);
        if (k != 0) {
          System.gc();
        }
        localObject = new Matrix();
        f = 90.0F;
        if (CameraCompatibleList.d(CameraCompatibleList.g)) {
          f = 90.0F + 180.0F;
        }
        ((Matrix)localObject).postRotate(f);
        paramVarArgs = Bitmap.createBitmap(paramVarArgs, 0, 0, paramVarArgs.getWidth(), paramVarArgs.getHeight(), (Matrix)localObject, false);
        if (k != 0) {
          System.gc();
        }
        if (paramVarArgs != null) {
          a(paramVarArgs, localFile);
        }
        if (k != 0) {
          System.gc();
        }
      }
      if (localFile.exists())
      {
        return localFile.getAbsolutePath();
        try
        {
          localObject = Bitmap.createScaledBitmap(paramVarArgs, i, 1020, true);
          paramVarArgs = (Void[])localObject;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (QLog.isColorLevel()) {
            QLog.d(CameraHelper.jdField_a_of_type_JavaLangString, 2, "createScaledBitmap OutOfMemoryError resizeWidth=" + 1020 + " resizeHeight=" + i + " error:" + localOutOfMemoryError.getMessage());
          }
          i /= 2;
          j = 510;
          paramVarArgs = Bitmap.createScaledBitmap(paramVarArgs, i, 510, true);
        }
      }
      else
      {
        return null;
        label761:
        k = 0;
        paramVarArgs = null;
        continue;
        label769:
        if (l4 < 81920L) {
          i = 1;
        }
      }
    }
  }
  
  /* Error */
  public void a(Bitmap paramBitmap, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 219	java/io/FileOutputStream
    //   8: dup
    //   9: aload_2
    //   10: invokespecial 222	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   13: astore_2
    //   14: new 224	java/io/BufferedOutputStream
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 227	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore_3
    //   23: aload_1
    //   24: getstatic 233	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   27: bipush 100
    //   29: aload_3
    //   30: invokevirtual 237	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   33: pop
    //   34: aload_3
    //   35: invokevirtual 240	java/io/BufferedOutputStream:flush	()V
    //   38: aload_3
    //   39: ifnull +7 -> 46
    //   42: aload_3
    //   43: invokevirtual 243	java/io/BufferedOutputStream:close	()V
    //   46: aload_2
    //   47: ifnull +7 -> 54
    //   50: aload_2
    //   51: invokevirtual 244	java/io/FileOutputStream:close	()V
    //   54: return
    //   55: astore_1
    //   56: aconst_null
    //   57: astore 4
    //   59: aload_3
    //   60: astore_2
    //   61: aload 4
    //   63: astore_3
    //   64: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   67: ifeq +13 -> 80
    //   70: getstatic 63	com/tencent/mobileqq/businessCard/helpers/CameraHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   73: iconst_2
    //   74: ldc 246
    //   76: aload_1
    //   77: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   80: aload_3
    //   81: ifnull +7 -> 88
    //   84: aload_3
    //   85: invokevirtual 243	java/io/BufferedOutputStream:close	()V
    //   88: aload_2
    //   89: ifnull -35 -> 54
    //   92: aload_2
    //   93: invokevirtual 244	java/io/FileOutputStream:close	()V
    //   96: return
    //   97: astore_1
    //   98: return
    //   99: astore_1
    //   100: aconst_null
    //   101: astore_3
    //   102: aload 4
    //   104: astore_2
    //   105: aload_3
    //   106: ifnull +7 -> 113
    //   109: aload_3
    //   110: invokevirtual 243	java/io/BufferedOutputStream:close	()V
    //   113: aload_2
    //   114: ifnull +7 -> 121
    //   117: aload_2
    //   118: invokevirtual 244	java/io/FileOutputStream:close	()V
    //   121: aload_1
    //   122: athrow
    //   123: astore_1
    //   124: goto -78 -> 46
    //   127: astore_1
    //   128: return
    //   129: astore_1
    //   130: goto -42 -> 88
    //   133: astore_3
    //   134: goto -21 -> 113
    //   137: astore_2
    //   138: goto -17 -> 121
    //   141: astore_1
    //   142: aconst_null
    //   143: astore_3
    //   144: goto -39 -> 105
    //   147: astore_1
    //   148: goto -43 -> 105
    //   151: astore_1
    //   152: goto -47 -> 105
    //   155: astore_1
    //   156: aconst_null
    //   157: astore_3
    //   158: goto -94 -> 64
    //   161: astore_1
    //   162: goto -98 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	abvo
    //   0	165	1	paramBitmap	Bitmap
    //   0	165	2	paramFile	File
    //   4	106	3	localObject1	Object
    //   133	1	3	localException	Exception
    //   143	15	3	localObject2	Object
    //   1	102	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   5	14	55	java/io/IOException
    //   92	96	97	java/lang/Exception
    //   5	14	99	finally
    //   42	46	123	java/lang/Exception
    //   50	54	127	java/lang/Exception
    //   84	88	129	java/lang/Exception
    //   109	113	133	java/lang/Exception
    //   117	121	137	java/lang/Exception
    //   14	23	141	finally
    //   23	38	147	finally
    //   64	80	151	finally
    //   14	23	155	java/io/IOException
    //   23	38	161	java/io/IOException
  }
  
  protected void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardHelpersCameraHelper$CameraHelperCallback != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardHelpersCameraHelper$CameraHelperCallback.a(paramString);
      if ((paramString == null) && (QLog.isColorLevel())) {
        QLog.i(CameraHelper.jdField_a_of_type_JavaLangString, 2, "Picture bitmap data error or output file not exist");
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardHelpersCameraHelper.jdField_a_of_type_AndroidHardwareCamera.startPreview();
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardHelpersCameraHelper.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(CameraHelper.jdField_a_of_type_JavaLangString, 2, "startPreview[failed] Exception=" + paramString.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abvo
 * JD-Core Version:    0.7.0.1
 */