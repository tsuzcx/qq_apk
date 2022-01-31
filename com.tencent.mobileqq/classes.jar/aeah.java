import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.hotpic.HotVideoMongoliaRelativeLayout;
import com.tencent.mobileqq.hotpic.HotVideoMongoliaRelativeLayout.VideoInfo;
import com.tencent.mobileqq.hotpic.PresenceInterfaceImpl;
import com.tencent.mobileqq.hotpic.VideoBaseItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class aeah
  implements Runnable
{
  public aeah(PresenceInterfaceImpl paramPresenceInterfaceImpl) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.a.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a(this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_AndroidViewView);
    if ((this.a.jdField_a_of_type_JavaLangRefWeakReference != null) && ((HotPicPageView)this.a.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {}
    for (boolean bool = HotPicPageView.a;; bool = false)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a(this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$VideoInfo.c, this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$VideoInfo.d, 0L, this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$VideoInfo.a, bool);
      if (this.a.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a()) {}
      for (String str = "0X8007ED5";; str = "0X8007ED6")
      {
        ReportController.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "dc00898", "", "", str, str, 0, 0, "", "", "", "");
        QLog.d("PresenceInterfaceImpl", 2, "have run mVideoPlayControl.startPlay");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeah
 * JD-Core Version:    0.7.0.1
 */