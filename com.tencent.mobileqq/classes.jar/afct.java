import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class afct
  implements View.OnClickListener
{
  public afct(TroopMemberHistoryFragment paramTroopMemberHistoryFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView == null) || (!(paramView instanceof Integer))) {}
    int i;
    do
    {
      do
      {
        return;
        i = ((Integer)paramView).intValue();
      } while ((i < 0) || (this.a.jdField_a_of_type_Afcw == null));
      paramView = this.a.getActivity();
    } while (paramView == null);
    axqw.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "chatRecor_mber", "res_clk", 0, 0, this.a.b, "", "", "");
    MessageRecord localMessageRecord = ((afcv)this.a.jdField_a_of_type_Afcw.getItem(i)).a;
    ChatHistoryBubbleListForTroopFragment.a(paramView, this.a.b, localMessageRecord, 100, 1);
    if (QLog.isColorLevel()) {
      QLog.i(TroopMemberHistoryFragment.jdField_a_of_type_JavaLangString, 2, "onItemClick, message = " + localMessageRecord);
    }
    axqw.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800A597", "0X800A597", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afct
 * JD-Core Version:    0.7.0.1
 */