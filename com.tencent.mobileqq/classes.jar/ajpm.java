import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public final class ajpm
  implements Runnable
{
  public ajpm(String paramString, ImageView paramImageView) {}
  
  public void run()
  {
    try
    {
      if (FileUtil.a(this.jdField_a_of_type_JavaLangString))
      {
        Object localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        BitmapFactory.decodeFile(this.jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject);
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
        localObject = BitmapFactory.decodeFile(this.jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject);
        ThreadManager.getUIHandler().post(new ajpn(this, (Bitmap)localObject));
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("setBitmapByPath", 2, localOutOfMemoryError.getStackTrace());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("setBitmapByPath", 2, localException.getStackTrace());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpm
 * JD-Core Version:    0.7.0.1
 */