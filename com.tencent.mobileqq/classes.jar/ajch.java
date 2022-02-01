import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajch
  implements View.OnClickListener
{
  public ajch(TroopMemberHistoryFragment paramTroopMemberHistoryFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject == null) || (!(localObject instanceof Integer))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = ((Integer)localObject).intValue();
      if ((i >= 0) && (this.a.jdField_a_of_type_Ajck != null))
      {
        localObject = this.a.getActivity();
        if (localObject != null)
        {
          bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "chatRecor_mber", "res_clk", 0, 0, this.a.b, "", "", "");
          MessageRecord localMessageRecord = ((ajcj)this.a.jdField_a_of_type_Ajck.getItem(i)).a;
          ChatHistoryBubbleListForTroopFragment.a((Activity)localObject, this.a.b, localMessageRecord, 100, 1);
          if (QLog.isColorLevel()) {
            QLog.i(TroopMemberHistoryFragment.jdField_a_of_type_JavaLangString, 2, "onItemClick, message = " + localMessageRecord);
          }
          bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800A597", "0X800A597", 0, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajch
 * JD-Core Version:    0.7.0.1
 */