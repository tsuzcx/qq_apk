import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class afzv
  implements bkhw
{
  public afzv(PlusPanel paramPlusPanel, bkho parambkho) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Bkho != null) {
      this.jdField_a_of_type_Bkho.dismiss();
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      try
      {
        PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel, true);
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800ABFC", "0X800ABFC", 0, 0, "", "", "", "");
        return;
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          QLog.d("PlusPanel", 1, "showTroopCourseActionSheet handleTroopLiveOrTroopCourseClick Exception", paramView);
        }
      }
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
    paramView = "https://qun.qq.com/livework/index?gc=" + paramView + "&_wv=2";
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQBrowserActivity.class);
    localIntent.putExtra("url", paramView);
    if (QLog.isColorLevel()) {
      QLog.i("PlusPanel", 2, "showTroopCourseActionSheet replayUrl = " + paramView);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity(localIntent);
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800ABFD", "0X800ABFD", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afzv
 * JD-Core Version:    0.7.0.1
 */