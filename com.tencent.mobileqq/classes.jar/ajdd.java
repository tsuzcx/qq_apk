import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class ajdd
  implements View.OnClickListener
{
  ajdd(ajbm paramajbm, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (BaseActivity.sTopActivity != null) {
      aucf.a().a(BaseActivity.sTopActivity, this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      aucf.m();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "sTopActivity is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdd
 * JD-Core Version:    0.7.0.1
 */