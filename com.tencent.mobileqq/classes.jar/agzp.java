import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class agzp
  implements View.OnClickListener
{
  private agzn jdField_a_of_type_Agzn;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  agzp(agzn paramagzn, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_Agzn = paramagzn;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, this.jdField_a_of_type_Agzn.jdField_a_of_type_JavaLangString + " on enter");
    }
    this.jdField_a_of_type_Agzn.jdField_a_of_type_Agzl.onEnter();
    awqx.a(null, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agzp
 * JD-Core Version:    0.7.0.1
 */