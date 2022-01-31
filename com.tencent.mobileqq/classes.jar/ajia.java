import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ajia
  implements View.OnClickListener
{
  private ajhy jdField_a_of_type_Ajhy;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  ajia(ajhy paramajhy, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_Ajhy = paramajhy;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, this.jdField_a_of_type_Ajhy.jdField_a_of_type_JavaLangString + " on enter");
    }
    this.jdField_a_of_type_Ajhy.jdField_a_of_type_Ajhw.onEnter();
    azqs.a(null, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajia
 * JD-Core Version:    0.7.0.1
 */