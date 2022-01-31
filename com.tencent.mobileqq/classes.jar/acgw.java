import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.MediaStore.Images.Media;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileFileAssistantActivity;
import cooperation.weiyun.utils.PreferenceUtils;
import cooperation.weiyun.utils.SoHelper;
import mqq.app.AppRuntime;

public class acgw
  implements Runnable
{
  public acgw(QfileFileAssistantActivity paramQfileFileAssistantActivity) {}
  
  public void run()
  {
    if (!SoHelper.a(this.a.getApplicationContext()))
    {
      Cursor localCursor = this.a.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_data" }, null, null, "bucket_display_name");
      if (localCursor != null)
      {
        int i = localCursor.getCount();
        PreferenceUtils.a(this.a.getApplicationContext(), this.a.getAppRuntime().getAccount(), "sp_un_backup_photo_num", Integer.toString(i));
        localCursor.close();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acgw
 * JD-Core Version:    0.7.0.1
 */