import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ahme
  implements View.OnClickListener
{
  private ahmc jdField_a_of_type_Ahmc;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  ahme(ahmc paramahmc, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_Ahmc = paramahmc;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, this.jdField_a_of_type_Ahmc.jdField_a_of_type_JavaLangString + " on enter");
    }
    this.jdField_a_of_type_Ahmc.jdField_a_of_type_Ahma.onEnter();
    axqw.a(null, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahme
 * JD-Core Version:    0.7.0.1
 */