import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aimf
  implements View.OnClickListener
{
  aimf(aimd paramaimd) {}
  
  public void onClick(View paramView)
  {
    if (!aimd.c(this.a)) {
      if (aimd.a(this.a) == null)
      {
        aimd.d(this.a);
        QLog.e(this.a.jdField_a_of_type_JavaLangString, 2, "onClick mExtendFriendUserInfo IS null");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((!aimd.a(this.a).enableQQCall) && (aimd.a(this.a).tagID != 10000))
      {
        aimd.d(this.a);
        QLog.e(this.a.jdField_a_of_type_JavaLangString, 2, "onClick mExtendFriendUserInfo enableQQCall false" + aimd.a(this.a).tagID);
      }
      else
      {
        agej.n = true;
        agju.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, null, null);
        if (aimd.a(this.a) != null) {
          if (aimd.a(this.a).tagID == 1) {
            bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD92", "0X800AD92", 1, 0, "", "", "", "");
          } else {
            bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD92", "0X800AD92", 2, 0, "", "", aimd.a(this.a).tagName, "");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimf
 * JD-Core Version:    0.7.0.1
 */