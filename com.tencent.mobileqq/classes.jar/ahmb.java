import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ahmb
  implements View.OnClickListener
{
  private ahma jdField_a_of_type_Ahma;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  ahmb(ahma paramahma, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_Ahma = paramahma;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, this.jdField_a_of_type_Ahma.jdField_a_of_type_JavaLangString + " on close");
    }
    paramView = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(201);
    paramView.obj = this.jdField_a_of_type_Ahma;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramView);
    this.jdField_a_of_type_Ahma.jdField_a_of_type_Ahly.onClose();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahmb
 * JD-Core Version:    0.7.0.1
 */