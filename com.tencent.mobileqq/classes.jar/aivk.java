import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aivk
  implements aiwf, View.OnClickListener
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  View jdField_a_of_type_AndroidViewView;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private String jdField_a_of_type_JavaLangString;
  
  public aivk(Activity paramActivity, SessionInfo paramSessionInfo, String paramString)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    return 58;
  }
  
  public View a(Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131560637, null);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public void a(@NonNull aiwh paramaiwh, boolean paramBoolean)
  {
    boolean bool = a(paramaiwh);
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopTipsBar", 2, new Object[] { "show() isShowing=", Boolean.valueOf(bool), ", show=", Boolean.valueOf(paramBoolean) });
    }
    if (paramBoolean) {
      if (!bool)
      {
        paramaiwh.a(this, new Object[0]);
        bhju.a("Grp_edu", "Grp_AIO", "mberinfotopGuidebar_Show", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString });
      }
    }
    while (!bool) {
      return;
    }
    paramaiwh.a();
  }
  
  public boolean a(@NonNull aiwh paramaiwh)
  {
    int i = paramaiwh.a();
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopTipsBar", 2, new Object[] { "show cur type=", Integer.valueOf(i) });
    }
    return i == b();
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 19;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopTipsBar", 2, "click tips, jump to web");
    }
    bgpk.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "aioTip");
    bhju.a("Grp_edu", "Grp_AIO", "mberinfotopGuidebar_Clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aivk
 * JD-Core Version:    0.7.0.1
 */