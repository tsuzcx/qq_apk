import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adyb
  implements View.OnClickListener
{
  public adyb(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_Aiwh.a();
    SharedPreferences.Editor localEditor = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
    localEditor.putInt("funcall_tip_" + this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 4);
    localEditor.commit();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adyb
 * JD-Core Version:    0.7.0.1
 */