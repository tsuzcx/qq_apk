import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class allx
  implements View.OnClickListener
{
  private allw jdField_a_of_type_Allw;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  allx(allw paramallw, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_Allw = paramallw;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, this.jdField_a_of_type_Allw.jdField_a_of_type_JavaLangString + " on close");
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(201);
    localMessage.obj = this.jdField_a_of_type_Allw;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    this.jdField_a_of_type_Allw.jdField_a_of_type_Allu.onClose();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     allx
 * JD-Core Version:    0.7.0.1
 */