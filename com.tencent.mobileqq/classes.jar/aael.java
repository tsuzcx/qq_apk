import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.TMG.utils.QLog;

class aael
  implements View.OnClickListener
{
  aael(aaek paramaaek, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (!bbfj.d(aaek.a(this.jdField_a_of_type_Aaek)))
    {
      bcql.a(aaek.a(this.jdField_a_of_type_Aaek), aaek.a(this.jdField_a_of_type_Aaek).getString(2131694608), 0).a();
      return;
    }
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener == null)
    {
      QLog.e("SdkAuthDialog", 1, "positiveListener is null");
      return;
    }
    this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    axqy.b(null, "dc00898", "", "", "0X8009F79", "0X8009F79", 0, 0, "0", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aael
 * JD-Core Version:    0.7.0.1
 */