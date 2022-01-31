import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView;
import mqq.os.MqqHandler;

public class afav
  implements Runnable
{
  public afav(ImageDisplayView paramImageDisplayView, String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject1 = null;
    try
    {
      localBitmap = BitmapFactory.decodeFile(this.jdField_a_of_type_JavaLangString);
      localObject1 = localBitmap;
      int i = new ExifInterface(this.jdField_a_of_type_JavaLangString).getAttributeInt("Orientation", 0);
      localObject1 = localBitmap;
      localObject2 = new Matrix();
      switch (i)
      {
      }
    }
    catch (Exception localException)
    {
      Bitmap localBitmap;
      Object localObject2;
      while (localObject1 != null)
      {
        ThreadManager.getUIHandler().post(new afay(this, localObject1));
        return;
        localObject1 = localException;
        ((Matrix)localObject2).postRotate(180.0F);
        continue;
        localObject1 = localException;
        ((Matrix)localObject2).postRotate(180.0F);
        localObject1 = localException;
        ((Matrix)localObject2).postScale(-1.0F, 1.0F);
        continue;
        localObject1 = localException;
        ((Matrix)localObject2).postRotate(90.0F);
        localObject1 = localException;
        ((Matrix)localObject2).postScale(-1.0F, 1.0F);
        continue;
        localObject1 = localException;
        ((Matrix)localObject2).postRotate(90.0F);
        continue;
        localObject1 = localException;
        ((Matrix)localObject2).postRotate(270.0F);
        localObject1 = localException;
        ((Matrix)localObject2).postScale(-1.0F, 1.0F);
        continue;
        localObject1 = localException;
        ((Matrix)localObject2).postRotate(270.0F);
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    localObject1 = localBitmap;
    ThreadManager.getUIHandler().post(new afaw(this, localBitmap));
    return;
    localObject1 = localBitmap;
    ((Matrix)localObject2).postScale(-1.0F, 1.0F);
    localObject1 = localBitmap;
    localObject2 = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), (Matrix)localObject2, true);
    localObject1 = localBitmap;
    ThreadManager.getUIHandler().post(new afax(this, (Bitmap)localObject2));
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afav
 * JD-Core Version:    0.7.0.1
 */