import android.view.View;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aekj
  implements bjoe
{
  public aekj(TroopAssistantActivity paramTroopAssistantActivity, int paramInt, String paramString, bjnw parambjnw) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity.a == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity.a = new bhhw(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity.a.b(2, 2131694064, 1500);
    }
    try
    {
      if (this.jdField_a_of_type_Bjnw != null) {
        this.jdField_a_of_type_Bjnw.dismiss();
      }
      return;
      int i = -1;
      switch (paramInt)
      {
      default: 
        paramInt = i;
      }
      while (paramInt != this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity.app.setTroopMsgFilterToServer(this.jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt));
        break;
        paramInt = 1;
        continue;
        paramInt = 4;
        continue;
        paramInt = 2;
        continue;
        paramInt = 3;
      }
    }
    catch (Exception paramView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("TroopAssistantActivity", 2, paramView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aekj
 * JD-Core Version:    0.7.0.1
 */