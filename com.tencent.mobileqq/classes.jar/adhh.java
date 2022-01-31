import android.graphics.Bitmap;
import com.dataline.util.file.MediaStoreUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.IGetVideoCallback;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class adhh
  implements FileManagerUtil.IGetVideoCallback
{
  public adhh(String paramString1, String paramString2) {}
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    try
    {
      FileUtil.a(paramBitmap, this.a);
      paramBitmap.recycle();
      int i = MediaStoreUtil.a(this.b);
      MediaStoreUtil.a(this.a, i);
      return;
    }
    catch (FileNotFoundException paramBitmap)
    {
      paramBitmap.printStackTrace();
      QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail FileNotFoundException:" + paramBitmap.getMessage());
      return;
    }
    catch (IOException paramBitmap)
    {
      paramBitmap.printStackTrace();
      QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail IOException:" + paramBitmap.getMessage());
      return;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      paramBitmap.printStackTrace();
      QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail OutOfMemoryError:" + paramBitmap.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adhh
 * JD-Core Version:    0.7.0.1
 */