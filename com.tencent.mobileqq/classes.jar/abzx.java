import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.widget.QQToast;

class abzx
  implements View.OnClickListener
{
  abzx(abzw paramabzw, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (!bdin.d(abzw.a(this.jdField_a_of_type_Abzw)))
    {
      QQToast.a(abzw.a(this.jdField_a_of_type_Abzw), abzw.a(this.jdField_a_of_type_Abzw).getString(2131694766), 0).a();
      return;
    }
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener == null)
    {
      QLog.e("SdkAuthDialog", 1, "positiveListener is null");
      return;
    }
    this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    azqs.b(null, "dc00898", "", "", "0X8009F79", "0X8009F79", 0, 0, "0", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abzx
 * JD-Core Version:    0.7.0.1
 */