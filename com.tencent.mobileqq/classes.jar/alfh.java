import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class alfh
  implements View.OnClickListener
{
  private alfg jdField_a_of_type_Alfg;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  alfh(alfg paramalfg, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_Alfg = paramalfg;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, this.jdField_a_of_type_Alfg.jdField_a_of_type_JavaLangString + " on close");
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(201);
    localMessage.obj = this.jdField_a_of_type_Alfg;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    this.jdField_a_of_type_Alfg.jdField_a_of_type_Alfe.onClose();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alfh
 * JD-Core Version:    0.7.0.1
 */