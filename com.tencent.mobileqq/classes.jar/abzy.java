import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.TMG.utils.QLog;

class abzy
  implements View.OnClickListener
{
  abzy(abzw paramabzw, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener == null)
    {
      QLog.e("SdkAuthDialog", 1, "negativeListener is null");
      return;
    }
    this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    azqs.b(null, "dc00898", "", "", "0X8009F79", "0X8009F79", 0, 0, "2", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abzy
 * JD-Core Version:    0.7.0.1
 */