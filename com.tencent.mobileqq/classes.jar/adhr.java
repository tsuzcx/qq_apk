import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import com.dataline.util.file.MediaStoreUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import java.io.File;

public final class adhr
  implements Runnable
{
  public adhr(String paramString, Activity paramActivity, File paramFile) {}
  
  public void run()
  {
    try
    {
      String str1 = FileManagerUtil.a(this.jdField_a_of_type_JavaLangString);
      Uri localUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
      String str2 = MimeTypesTools.a(this.jdField_a_of_type_AndroidAppActivity, str1);
      int i = MediaStoreUtil.a(this.jdField_a_of_type_JavaLangString);
      ContentValues localContentValues = new ContentValues(7);
      localContentValues.put("title", str1);
      localContentValues.put("_display_name", this.jdField_a_of_type_JavaIoFile.getName());
      localContentValues.put("date_modified", Long.valueOf(this.jdField_a_of_type_JavaIoFile.lastModified() / 1000L));
      localContentValues.put("mime_type", str2);
      localContentValues.put("_data", this.jdField_a_of_type_JavaLangString);
      localContentValues.put("_size", Long.valueOf(this.jdField_a_of_type_JavaIoFile.length()));
      int j = FileManagerUtil.a(str1);
      if (j == 0)
      {
        localContentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        localContentValues.put("orientation", Integer.valueOf(i));
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidAppActivity.getContentResolver().insert(localUri, localContentValues);
        FMToastUtil.b(2131428219);
        return;
        if (j == 2)
        {
          long l = ShortVideoUtils.a(this.jdField_a_of_type_JavaLangString);
          localContentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
          localContentValues.put("duration", Long.valueOf(l));
          localUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        }
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      FMToastUtil.a("手机内存不足，保存本地失败。");
      return;
    }
    catch (Exception localException)
    {
      FMToastUtil.a(2131428217);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adhr
 * JD-Core Version:    0.7.0.1
 */