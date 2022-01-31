import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ahmc
  implements View.OnClickListener
{
  private ahma jdField_a_of_type_Ahma;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  ahmc(ahma paramahma, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_Ahma = paramahma;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, this.jdField_a_of_type_Ahma.jdField_a_of_type_JavaLangString + " on enter");
    }
    this.jdField_a_of_type_Ahma.jdField_a_of_type_Ahly.onEnter();
    axqy.a(null, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahmc
 * JD-Core Version:    0.7.0.1
 */