import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aedk
  implements View.OnClickListener
{
  aedk(aede paramaede, MessageRecord paramMessageRecord) {}
  
  public void onClick(View paramView)
  {
    AIOEmotionFragment.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Aede.a.a, abke.a(paramView));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aedk
 * JD-Core Version:    0.7.0.1
 */