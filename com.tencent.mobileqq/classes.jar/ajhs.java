import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class ajhs
  implements View.OnClickListener
{
  ajhs(ajgb paramajgb, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (BaseActivity.sTopActivity != null) {
      augo.a().a(BaseActivity.sTopActivity, this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      augo.m();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "sTopActivity is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhs
 * JD-Core Version:    0.7.0.1
 */