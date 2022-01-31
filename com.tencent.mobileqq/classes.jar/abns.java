import android.view.View;
import com.tencent.mobileqq.activity.RecentLoginDevActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class abns
  implements begw
{
  public abns(RecentLoginDevActivity paramRecentLoginDevActivity, String paramString, ArrayList paramArrayList, int paramInt) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((RecentLoginDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity) != null) && (RecentLoginDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity).isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity.isFinishing()))
      {
        RecentLoginDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity).dismiss();
        RecentLoginDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity).cancel();
        RecentLoginDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity, null);
      }
      return;
      if (!badq.d(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity))
      {
        bbmy.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity, this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity.getString(2131626719), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity.getTitleBarHeight());
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.RecentLoginDevActivity", 2, "OnClick begin to delHistoryDev");
        }
        if (anoc.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity.app, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Int)) {
          RecentLoginDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity);
        } else if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.RecentLoginDevActivity", 2, "showDelDevActionSheet.OnClick delHistoryDev failed");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abns
 * JD-Core Version:    0.7.0.1
 */