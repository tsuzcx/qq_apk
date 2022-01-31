import android.widget.Toast;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.ToastUtil;

public class alfj
  implements Runnable
{
  public alfj(ToastUtil paramToastUtil, String paramString, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentOpenBaseToastUtil.a == null)
    {
      this.jdField_a_of_type_ComTencentOpenBaseToastUtil.a = Toast.makeText(CommonDataAdapter.a().a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentOpenBaseToastUtil.a.show();
      return;
    }
    this.jdField_a_of_type_ComTencentOpenBaseToastUtil.a.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentOpenBaseToastUtil.a.setDuration(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentOpenBaseToastUtil.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alfj
 * JD-Core Version:    0.7.0.1
 */