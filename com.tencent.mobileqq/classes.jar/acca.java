import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.VerifyPwdView;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import mqq.app.MobileQQ;

public class acca
  implements RadioGroup.OnCheckedChangeListener
{
  public acca(FMActivity paramFMActivity) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    int i = -1;
    if (this.a.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.a.g();
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setVisibility(0);
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView != null)
    {
      this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.setVisibility(8);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.a();
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView = null;
      this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView);
    }
    if (paramInt == 2131368713)
    {
      this.a.a().f();
      ((RadioButton)this.a.findViewById(2131368714)).setChecked(false);
      ((RadioButton)this.a.findViewById(2131368715)).setChecked(false);
      FMActivity.d(this.a);
      i = 0;
    }
    for (;;)
    {
      paramRadioGroup = this.a.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
      paramRadioGroup.putInt("last_select_tab_type", i);
      paramRadioGroup.commit();
      return;
      if (paramInt == 2131368714)
      {
        this.a.a().e();
        FMActivity.e(this.a);
        ((RadioButton)this.a.findViewById(2131368713)).setChecked(false);
        ((RadioButton)this.a.findViewById(2131368715)).setChecked(false);
        paramInt = 1;
        i = paramInt;
        if (this.a.g == 0)
        {
          i = paramInt;
          if (this.a.j)
          {
            this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
            i = paramInt;
          }
        }
      }
      else if (paramInt == 2131368715)
      {
        this.a.a().d();
        ((RadioButton)this.a.findViewById(2131368714)).setChecked(false);
        ((RadioButton)this.a.findViewById(2131368713)).setChecked(false);
        FMActivity.a(this.a, 2);
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acca
 * JD-Core Version:    0.7.0.1
 */