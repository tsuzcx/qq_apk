import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.armap.map.ARGridMapViewDialog;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class aazf
  implements View.OnClickListener
{
  public aazf(ARGridMapViewDialog paramARGridMapViewDialog, long paramLong) {}
  
  public void onClick(View paramView)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqArmapMapARGridMapViewDialog.jdField_a_of_type_AndroidAppActivity.isFinishing())
    {
      paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqArmapMapARGridMapViewDialog.jdField_a_of_type_AndroidContentContext, 230, null, "当前地址有误我要去反馈", "取消", "去反馈", new aazg(this), new aazh(this));
      if (!this.jdField_a_of_type_ComTencentMobileqqArmapMapARGridMapViewDialog.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
        paramView.show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aazf
 * JD-Core Version:    0.7.0.1
 */