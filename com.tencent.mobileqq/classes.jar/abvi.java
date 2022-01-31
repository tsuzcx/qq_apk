import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.widget.QQToast;

class abvi
  implements View.OnClickListener
{
  abvi(abvh paramabvh, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (!bdee.d(abvh.a(this.jdField_a_of_type_Abvh)))
    {
      QQToast.a(abvh.a(this.jdField_a_of_type_Abvh), abvh.a(this.jdField_a_of_type_Abvh).getString(2131694764), 0).a();
      return;
    }
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener == null)
    {
      QLog.e("SdkAuthDialog", 1, "positiveListener is null");
      return;
    }
    this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    azmj.b(null, "dc00898", "", "", "0X8009F79", "0X8009F79", 0, 0, "0", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abvi
 * JD-Core Version:    0.7.0.1
 */