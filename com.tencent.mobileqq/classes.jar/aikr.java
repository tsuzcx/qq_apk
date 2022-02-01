import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aikr
  implements ailp, View.OnClickListener
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  View jdField_a_of_type_AndroidViewView;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  
  public aikr(Activity paramActivity, SessionInfo paramSessionInfo)
  {
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
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131560700, null);
      paramVarArgs = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368375);
      if (paramVarArgs != null) {
        paramVarArgs.setText(2131693136);
      }
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public void a(@NonNull ailr paramailr, boolean paramBoolean)
  {
    boolean bool = a(paramailr);
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopClassInfoTipsBar", 2, new Object[] { "show() isShowing=", Boolean.valueOf(bool), ", show=", Boolean.valueOf(paramBoolean) });
    }
    if (paramBoolean) {
      if (!bool)
      {
        paramailr.a(this, new Object[0]);
        bhbu.a("Grp_edu", "Grp_AIO", "classinfotopGuidebar_Show", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin });
      }
    }
    while (!bool) {
      return;
    }
    paramailr.a();
  }
  
  public boolean a(@NonNull ailr paramailr)
  {
    int i = paramailr.a();
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopClassInfoTipsBar", 2, new Object[] { "show cur type=", Integer.valueOf(i) });
    }
    return i == b();
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 27;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopClassInfoTipsBar", 2, "click tips, jump to web");
    }
    bghd.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, bghd.c);
    bdla.b(null, "dc00898", "", "", "0X800B280", "0X800B280", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aikr
 * JD-Core Version:    0.7.0.1
 */