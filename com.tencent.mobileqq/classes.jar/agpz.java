import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.MessageForAutoReply;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agpz
  implements View.OnClickListener
{
  agpz(agpy paramagpy, MessageForAutoReply paramMessageForAutoReply) {}
  
  public void onClick(View paramView)
  {
    agpy.a(this.jdField_a_of_type_Agpy, this.jdField_a_of_type_ComTencentMobileqqDataMessageForAutoReply);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agpz
 * JD-Core Version:    0.7.0.1
 */