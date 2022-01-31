import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ajhz
  implements View.OnClickListener
{
  private ajhy jdField_a_of_type_Ajhy;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  ajhz(ajhy paramajhy, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_Ajhy = paramajhy;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, this.jdField_a_of_type_Ajhy.jdField_a_of_type_JavaLangString + " on close");
    }
    paramView = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(201);
    paramView.obj = this.jdField_a_of_type_Ajhy;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramView);
    this.jdField_a_of_type_Ajhy.jdField_a_of_type_Ajhw.onClose();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhz
 * JD-Core Version:    0.7.0.1
 */