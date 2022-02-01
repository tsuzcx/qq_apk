import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;

public class ahjk
  implements View.OnClickListener
{
  public ahjk(StructingMsgItemBuilder paramStructingMsgItemBuilder, BaseChatPie paramBaseChatPie, AbsShareMsg paramAbsShareMsg) {}
  
  public void onClick(View paramView)
  {
    Map localMap = ((aidp)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg);
    ((aidp)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).a(localMap);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahjk
 * JD-Core Version:    0.7.0.1
 */