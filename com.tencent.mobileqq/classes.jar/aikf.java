import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aikf
  implements ailp, View.OnClickListener
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  View jdField_a_of_type_AndroidViewView;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public aikf(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  public int a()
  {
    return 59;
  }
  
  public View a(Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131560665, null);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public boolean a(@NonNull ailr paramailr)
  {
    int i = paramailr.a();
    if (QLog.isColorLevel()) {
      QLog.d("FansTroopTipsBar", 2, new Object[] { "show cur type=", Integer.valueOf(i) });
    }
    return i == b();
  }
  
  public boolean a(ailr paramailr, boolean paramBoolean)
  {
    if (paramailr == null) {}
    boolean bool;
    do
    {
      do
      {
        return false;
        bool = a(paramailr);
        if (QLog.isColorLevel()) {
          QLog.d("FansTroopTipsBar", 2, new Object[] { "show() isShowing=", Boolean.valueOf(bool), ", show=", Boolean.valueOf(paramBoolean) });
        }
        if (!paramBoolean) {
          break;
        }
      } while ((bool) || (!paramailr.a(this, new Object[0])));
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B57A", "0X800B57A", 0, 0, "", "", "", "");
      return true;
    } while (!bool);
    paramailr.a();
    return false;
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 31;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FansTroopTipsBar", 2, "click tips, jump to web");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
      bghc.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().a();
    }
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B57B", "0X800B57B", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aikf
 * JD-Core Version:    0.7.0.1
 */