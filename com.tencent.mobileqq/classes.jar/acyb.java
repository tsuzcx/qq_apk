import android.graphics.Bitmap;
import com.dataline.util.file.MediaStoreUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class acyb
  implements Runnable
{
  public acyb(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (FileUtil.b(this.jdField_a_of_type_JavaLangString)) {}
    Bitmap localBitmap;
    do
    {
      return;
      localBitmap = MediaStoreUtil.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    } while (localBitmap == null);
    try
    {
      FileUtil.a(localBitmap, this.jdField_a_of_type_JavaLangString);
      localBitmap.recycle();
      int i = MediaStoreUtil.a(this.jdField_b_of_type_JavaLangString);
      MediaStoreUtil.a(this.jdField_a_of_type_JavaLangString, i);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
      QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail FileNotFoundException:" + localFileNotFoundException.getMessage());
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail IOException:" + localIOException.getMessage());
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail OutOfMemoryError:" + localOutOfMemoryError.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acyb
 * JD-Core Version:    0.7.0.1
 */