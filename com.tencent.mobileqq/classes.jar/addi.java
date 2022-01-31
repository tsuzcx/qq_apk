import android.view.View;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.fragment.MineFragment;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class addi
  implements ActionSheet.OnButtonClickListener
{
  public addi(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
        this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      this.a.o();
      return;
      NearbyHybridFragment.a(this.a);
      continue;
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a() == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b();
      }
      if ((NetworkUtil.d(BaseApplication.getContext())) && (!this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.isFinishing()))
      {
        MineFragment.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
        this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.finish();
      }
      else
      {
        QQToast.a(BaseApplication.getContext(), 1, this.a.getString(2131433196), 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     addi
 * JD-Core Version:    0.7.0.1
 */