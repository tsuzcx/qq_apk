import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader;
import com.tencent.mobileqq.nearby.now.utils.CommentsUtil;
import com.tencent.mobileqq.nearby.now.utils.IOUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class aeiy
  implements Runnable
{
  public aeiy(VideoFeedsUploader paramVideoFeedsUploader, String paramString) {}
  
  public void run()
  {
    str3 = "";
    try
    {
      byte[] arrayOfByte = IOUtils.a(new File(this.jdField_a_of_type_JavaLangString));
      str1 = str3;
      if (arrayOfByte != null)
      {
        str1 = str3;
        if (arrayOfByte.length > 0) {
          str1 = CommentsUtil.a(arrayOfByte);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        QLog.e("VideoFeedsUploader", 1, localException, new Object[0]);
        String str2 = str3;
      }
    }
    ThreadManager.getUIHandler().post(new aeiz(this, str1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeiy
 * JD-Core Version:    0.7.0.1
 */