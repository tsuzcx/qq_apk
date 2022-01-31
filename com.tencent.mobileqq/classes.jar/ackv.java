import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.EPRecommendTask;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import org.json.JSONObject;

public class ackv
  implements Runnable
{
  public ackv(EPRecommendTask paramEPRecommendTask) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("EPRecommendTask", 2, "url:" + this.a.jdField_a_of_type_JavaLangString + ",type:" + this.a.b);
    }
    try
    {
      Object localObject = (QQAppInterface)this.a.jdField_a_of_type_MqqUtilWeakReference.get();
      if (localObject == null) {
        return;
      }
      localObject = VasQuickUpdateManager.a((AppRuntime)localObject, "emoji_app_vip_emoji_aio_android_config.json", true, this.a.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
      this.a.a((JSONObject)localObject);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l2;
        if (QLog.isColorLevel()) {
          QLog.d("Q.emoji.EmoDown", 2, localException.getMessage());
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label103:
      break label103;
    }
    l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      QLog.d("EPRecommendTask", 2, "costTime:" + (l2 - l1) + ",type:" + this.a.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ackv
 * JD-Core Version:    0.7.0.1
 */