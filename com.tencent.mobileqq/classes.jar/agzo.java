import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class agzo
  implements View.OnClickListener
{
  private agzn jdField_a_of_type_Agzn;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  agzo(agzn paramagzn, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_Agzn = paramagzn;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, this.jdField_a_of_type_Agzn.jdField_a_of_type_JavaLangString + " on close");
    }
    paramView = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(201);
    paramView.obj = this.jdField_a_of_type_Agzn;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramView);
    this.jdField_a_of_type_Agzn.jdField_a_of_type_Agzl.onClose();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agzo
 * JD-Core Version:    0.7.0.1
 */