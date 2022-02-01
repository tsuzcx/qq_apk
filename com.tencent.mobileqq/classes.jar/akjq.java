import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class akjq
  implements View.OnClickListener
{
  private akjo jdField_a_of_type_Akjo;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  akjq(akjo paramakjo, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_Akjo = paramakjo;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, this.jdField_a_of_type_Akjo.jdField_a_of_type_JavaLangString + " on enter");
    }
    this.jdField_a_of_type_Akjo.jdField_a_of_type_Akjm.onEnter();
    bcef.a(null, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 1, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akjq
 * JD-Core Version:    0.7.0.1
 */