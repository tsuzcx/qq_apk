import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class ally
  implements View.OnClickListener
{
  private allw jdField_a_of_type_Allw;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  ally(allw paramallw, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_Allw = paramallw;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, this.jdField_a_of_type_Allw.jdField_a_of_type_JavaLangString + " on enter");
    }
    this.jdField_a_of_type_Allw.jdField_a_of_type_Allu.onEnter();
    bdll.a(null, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 1, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ally
 * JD-Core Version:    0.7.0.1
 */