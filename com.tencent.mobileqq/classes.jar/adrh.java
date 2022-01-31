import android.view.View;
import com.tencent.mobileqq.hotpic.HotVideoMongoliaRelativeLayout;
import com.tencent.mobileqq.hotpic.HotVideoMongoliaRelativeLayout.InnerOnClickListener;
import com.tencent.mobileqq.hotpic.HotVideoMongoliaRelativeLayout.PresenceInterface;
import com.tencent.qphone.base.util.QLog;

public class adrh
  implements HotVideoMongoliaRelativeLayout.InnerOnClickListener
{
  public adrh(HotVideoMongoliaRelativeLayout paramHotVideoMongoliaRelativeLayout) {}
  
  public void a(View paramView)
  {
    com.tencent.mobileqq.hotpic.HotPicPageView.b = true;
    if ((this.a.jdField_a_of_type_Int == 2) && (this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface != null))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface.a(0, paramView);
      return;
    }
    if ((this.a.jdField_a_of_type_Int == 3) && (this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface.a(4, paramView);
    }
    for (;;)
    {
      QLog.d("HotVideoRelativeLayout", 2, "click base view");
      return;
      if ((this.a.jdField_a_of_type_Int == 4) && (this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface.a(1, paramView);
      } else if ((this.a.jdField_a_of_type_Int == 6) && (this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface.a(2, paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adrh
 * JD-Core Version:    0.7.0.1
 */