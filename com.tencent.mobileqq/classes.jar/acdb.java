import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class acdb
  implements View.OnClickListener
{
  public acdb(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_Agwa.a();
    paramView = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
    paramView.putInt("funcall_tip_" + this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 4);
    paramView.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acdb
 * JD-Core Version:    0.7.0.1
 */