import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.mobileqq.vip.TMSManager.Callback;
import com.tmsdk.dual.TMSDualSDKContext;
import dualsim.common.OrderCheckResult;
import dualsim.common.PhoneGetResult;
import mqq.os.MqqHandler;

public final class aksq
  implements Runnable
{
  public aksq(TMSManager.Callback paramCallback, boolean paramBoolean) {}
  
  public void run()
  {
    OrderCheckResult localOrderCheckResult = TMSDualSDKContext.checkKingcardSyn("00047", "ck_shoujiqq_dfhdsuif5f6d_f4d89e");
    PhoneGetResult localPhoneGetResult = TMSDualSDKContext.getPhoneNumber();
    TMSManager.a(localOrderCheckResult, localPhoneGetResult);
    if (this.jdField_a_of_type_ComTencentMobileqqVipTMSManager$Callback != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        ThreadManager.getUIHandler().post(new aksr(this, localOrderCheckResult, localPhoneGetResult));
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqVipTMSManager$Callback.a(localOrderCheckResult, localPhoneGetResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aksq
 * JD-Core Version:    0.7.0.1
 */