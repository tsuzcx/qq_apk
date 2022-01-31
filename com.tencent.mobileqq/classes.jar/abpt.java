import com.tencent.mobileqq.dating.HotChatFlashPicActivity;
import com.tencent.mobileqq.utils.DESUtil;
import java.util.concurrent.atomic.AtomicBoolean;

public class abpt
  implements Runnable
{
  public abpt(HotChatFlashPicActivity paramHotChatFlashPicActivity, String paramString) {}
  
  public void run()
  {
    DESUtil.b(this.jdField_a_of_type_JavaLangString, HotChatFlashPicActivity.c(this.jdField_a_of_type_ComTencentMobileqqDatingHotChatFlashPicActivity));
    HotChatFlashPicActivity.b(this.jdField_a_of_type_ComTencentMobileqqDatingHotChatFlashPicActivity, true);
    if (!HotChatFlashPicActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingHotChatFlashPicActivity).get()) {
      HotChatFlashPicActivity.b(this.jdField_a_of_type_ComTencentMobileqqDatingHotChatFlashPicActivity, this.jdField_a_of_type_JavaLangString);
    }
    HotChatFlashPicActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingHotChatFlashPicActivity, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abpt
 * JD-Core Version:    0.7.0.1
 */