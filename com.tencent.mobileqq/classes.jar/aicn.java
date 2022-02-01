import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aicn
  implements View.OnClickListener
{
  aicn(aicl paramaicl) {}
  
  public void onClick(View paramView)
  {
    if (!aicl.c(this.a)) {
      if (aicl.a(this.a) == null)
      {
        aicl.d(this.a);
        QLog.e(this.a.jdField_a_of_type_JavaLangString, 2, "onClick mExtendFriendUserInfo IS null");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((!aicl.a(this.a).enableQQCall) && (aicl.a(this.a).tagID != 10000))
      {
        aicl.d(this.a);
        QLog.e(this.a.jdField_a_of_type_JavaLangString, 2, "onClick mExtendFriendUserInfo enableQQCall false" + aicl.a(this.a).tagID);
      }
      else
      {
        afur.n = true;
        agaa.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, null, null);
        if (aicl.a(this.a) != null) {
          if (aicl.a(this.a).tagID == 1) {
            bcst.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD92", "0X800AD92", 1, 0, "", "", "", "");
          } else {
            bcst.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD92", "0X800AD92", 2, 0, "", "", aicl.a(this.a).tagName, "");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aicn
 * JD-Core Version:    0.7.0.1
 */