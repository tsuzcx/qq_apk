import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ajdk
  implements View.OnClickListener
{
  private ajdj jdField_a_of_type_Ajdj;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  ajdk(ajdj paramajdj, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_Ajdj = paramajdj;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, this.jdField_a_of_type_Ajdj.jdField_a_of_type_JavaLangString + " on close");
    }
    paramView = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(201);
    paramView.obj = this.jdField_a_of_type_Ajdj;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramView);
    this.jdField_a_of_type_Ajdj.jdField_a_of_type_Ajdh.onClose();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdk
 * JD-Core Version:    0.7.0.1
 */