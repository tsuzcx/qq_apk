import android.content.Context;
import android.content.res.Resources;
import android.widget.LinearLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.lightReply.LightReplyMenuManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;

class aeki
  implements Runnable
{
  aeki(aekh paramaekh, int paramInt) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = null;
    if (((this.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_Aekh.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.jdField_a_of_type_JavaUtilList.size() == 0)) || ((this.jdField_a_of_type_Int <= 0) && (this.jdField_a_of_type_Aekh.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.b.size() == 0)))
    {
      QQToast.a(this.jdField_a_of_type_Aekh.jdField_a_of_type_AndroidContentContext, -1, "出错了，请稍后重试！", 0).b(this.jdField_a_of_type_Aekh.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
      this.jdField_a_of_type_Aekh.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.e();
      return;
    }
    Object localObject;
    boolean bool;
    if (this.jdField_a_of_type_Aekh.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      localObject = this.jdField_a_of_type_Aekh.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager;
      if (this.jdField_a_of_type_Int <= 0) {
        break label293;
      }
      bool = true;
      label126:
      LightReplyMenuManager.a((LightReplyMenuManager)localObject, bool);
      this.jdField_a_of_type_Aekh.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      LightReplyMenuManager.a(this.jdField_a_of_type_Aekh.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager, true);
      localObject = this.jdField_a_of_type_Aekh.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.a(this.jdField_a_of_type_Aekh.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.c);
      if (!this.jdField_a_of_type_Aekh.jdField_a_of_type_Boolean) {
        break label298;
      }
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        localQQAppInterface = (QQAppInterface)localAppRuntime;
      }
      ReportController.b(localQQAppInterface, "dc00899", "Grp_replyPic", "", "Emoji_box", "exp", 0, 0, this.jdField_a_of_type_Aekh.jdField_a_of_type_JavaLangString, (String)localObject, "0", "");
    }
    for (;;)
    {
      LightReplyMenuManager.a(this.jdField_a_of_type_Aekh.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager, this.jdField_a_of_type_Aekh.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.jdField_a_of_type_AndroidWidgetLinearLayout);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("LightReplyMenuManager", 2, "faceDetector finished and count is" + this.jdField_a_of_type_Int);
      return;
      label293:
      bool = false;
      break label126;
      label298:
      ReportController.b(null, "dc00899", "Grp_replyPic", "", "Emoji_box", "exp", 0, 0, this.jdField_a_of_type_Aekh.jdField_a_of_type_JavaLangString, (String)localObject, "1", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeki
 * JD-Core Version:    0.7.0.1
 */