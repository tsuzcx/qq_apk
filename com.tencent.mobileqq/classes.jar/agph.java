import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;

public class agph
  implements View.OnClickListener
{
  public agph(StructingMsgItemBuilder paramStructingMsgItemBuilder, BaseChatPie paramBaseChatPie, AbsShareMsg paramAbsShareMsg) {}
  
  public void onClick(View paramView)
  {
    Map localMap = ((ahiu)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg);
    ((ahiu)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).a(localMap);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agph
 * JD-Core Version:    0.7.0.1
 */