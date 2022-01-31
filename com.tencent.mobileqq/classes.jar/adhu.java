import android.os.Handler;
import com.tencent.mobileqq.hotpic.CircleProgressView;
import com.tencent.mobileqq.hotpic.HotVideoMongoliaRelativeLayout;
import com.tencent.mobileqq.hotpic.PresenceInterfaceImpl;
import com.tencent.mobileqq.hotpic.VideoBaseItem;

public class adhu
  implements Runnable
{
  public adhu(PresenceInterfaceImpl paramPresenceInterfaceImpl) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.a.setProgress(this.a.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.b());
    if (this.a.jdField_b_of_type_Boolean) {
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_b_of_type_JavaLangRunnable, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adhu
 * JD-Core Version:    0.7.0.1
 */