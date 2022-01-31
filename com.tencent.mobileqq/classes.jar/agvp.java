import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public abstract class agvp
{
  String a;
  String b;
  String c;
  
  public agvp(String paramString)
  {
    this.c = paramString;
  }
  
  public static agvp a(String paramString)
  {
    if (agvq.a(paramString)) {
      return new agvq(paramString);
    }
    if (agvo.a(paramString)) {
      return new agvo(paramString);
    }
    return null;
  }
  
  public static boolean c(String paramString)
  {
    return a(paramString) != null;
  }
  
  public String a()
  {
    Object localObject = null;
    String str = auoy.a(this.c, 2);
    if (!new File(str).exists())
    {
      boolean bool = b(str);
      axrl.a(BaseApplication.getContext()).a(null, this.b, bool, 0L, auoy.a(str), null, "");
      if (bool)
      {
        if (QLog.isColorLevel()) {
          aune.a("PIC_TAG_ERROR", "check file type,generateCompatibleFile suc", "outputPath" + str + " originFile" + this.c + " fileType:" + this.a);
        }
        localObject = str;
      }
      while (!QLog.isColorLevel()) {
        return localObject;
      }
      aune.a("PIC_TAG_ERROR", "check file type,generateCompatibleFile fail", " originFile" + this.c + " fileType:" + this.a);
      return null;
    }
    if (QLog.isColorLevel()) {
      aune.a("PIC_TAG_ERROR", "check file type,compatibleFile exists", "outputPath" + str + " originFile" + this.c + " fileType:" + this.a);
    }
    return str;
  }
  
  boolean b(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    int j = bbdr.b(this.c);
    String str = "generate " + this.a;
    int i = 1;
    if (i <= 4) {}
    for (;;)
    {
      try
      {
        localOptions.inSampleSize = i;
        if (QLog.isColorLevel()) {
          QLog.d(this.a, 2, str + ",localPath:" + this.c + " sample:" + i + " path:" + paramString + " degree:" + j);
        }
        Bitmap localBitmap = SafeBitmapFactory.safeDecode(this.c, localOptions);
        Object localObject = localBitmap;
        if (j != 0)
        {
          localObject = new Matrix();
          int k = localBitmap.getWidth();
          int m = localBitmap.getHeight();
          ((Matrix)localObject).postRotate(j, k >> 1, m >> 1);
          localObject = Bitmap.createBitmap(localBitmap, 0, 0, k, m, (Matrix)localObject, true);
        }
        bool = auoy.a(paramString, (Bitmap)localObject, 80, "incompatible to jpg", null);
        if (bool)
        {
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.d(this.a, 2, str + ",result:" + bool + " sample:" + i + " path:" + paramString + " degree:" + j);
          }
          return bool;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.a, 2, str + ",compressQuality fail");
        }
        i *= 2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.a, 2, str + ",oom localPath:" + this.c + " sample:" + i + " degree:" + j);
        }
        localOutOfMemoryError.printStackTrace();
        System.gc();
        i *= 2;
      }
      break;
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agvp
 * JD-Core Version:    0.7.0.1
 */