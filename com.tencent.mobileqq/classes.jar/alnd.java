import android.view.View;
import android.widget.Toast;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.ToastUtil;

public class alnd
  implements Runnable
{
  public alnd(ToastUtil paramToastUtil, View paramView, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentOpenBaseToastUtil.b == null)
    {
      this.jdField_a_of_type_ComTencentOpenBaseToastUtil.b = new Toast(CommonDataAdapter.a().a());
      this.jdField_a_of_type_ComTencentOpenBaseToastUtil.b.setView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentOpenBaseToastUtil.b.setDuration(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentOpenBaseToastUtil.b.show();
      return;
    }
    this.jdField_a_of_type_ComTencentOpenBaseToastUtil.b.setView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentOpenBaseToastUtil.b.setDuration(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentOpenBaseToastUtil.b.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alnd
 * JD-Core Version:    0.7.0.1
 */