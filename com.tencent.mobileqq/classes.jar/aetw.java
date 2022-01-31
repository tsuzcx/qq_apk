import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class aetw
  extends ajxj
{
  public aetw(TroopChatPie paramTroopChatPie) {}
  
  protected void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map<String, Integer> paramMap)
  {
    int i;
    if (QLog.isColorLevel())
    {
      String str = this.a.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("onSetGenralSettingsTroopFilter: isSuc = ").append(paramBoolean).append(", size = ");
      if (paramMap == null)
      {
        i = 0;
        QLog.d(str, 2, i);
      }
    }
    else
    {
      if ((paramMap != null) && (paramMap.size() != 0)) {
        break label83;
      }
    }
    label83:
    while (!this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume())
    {
      return;
      i = paramMap.size();
      break;
    }
    if (paramBoolean)
    {
      bcql.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131720550), 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      return;
    }
    bcql.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131720549), 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aetw
 * JD-Core Version:    0.7.0.1
 */