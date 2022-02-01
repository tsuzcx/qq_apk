import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class alfi
  implements View.OnClickListener
{
  private alfg jdField_a_of_type_Alfg;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  alfi(alfg paramalfg, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_Alfg = paramalfg;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, this.jdField_a_of_type_Alfg.jdField_a_of_type_JavaLangString + " on enter");
    }
    this.jdField_a_of_type_Alfg.jdField_a_of_type_Alfe.onEnter();
    bdla.a(null, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 1, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alfi
 * JD-Core Version:    0.7.0.1
 */