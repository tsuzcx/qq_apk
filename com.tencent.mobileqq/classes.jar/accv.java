import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.EPRecommendTask;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import mqq.util.WeakReference;

public class accv
  extends VasQuickUpdateManager.CallBacker
{
  public accv(EPRecommendTask paramEPRecommendTask) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    paramString2 = (QQAppInterface)this.a.jdField_a_of_type_MqqUtilWeakReference.get();
    if (paramString2 == null) {}
    while (!"emoji_app_vip_emoji_aio_android_config.json".equals(paramString1)) {
      return;
    }
    ((VasQuickUpdateManager)paramString2.getManager(183)).b(this.a.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    paramString1 = VasQuickUpdateManager.a(paramString2, "emoji_app_vip_emoji_aio_android_config.json", false, null);
    this.a.a(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     accv
 * JD-Core Version:    0.7.0.1
 */