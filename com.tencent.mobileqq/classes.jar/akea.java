import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class akea
  implements AdapterView.OnItemClickListener
{
  akea(akdt paramakdt) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "onItemClick, position = " + paramInt);
    }
    if ((this.a.jdField_a_of_type_Ajwt.getCount() <= 0) || (paramInt <= 0)) {}
    do
    {
      return;
      paramAdapterView = (akcy)this.a.jdField_a_of_type_Ajwt.getItem(paramInt - 1);
    } while (paramAdapterView == null);
    this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramAdapterView.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "onItemClick, mRecordCount = " + this.a.jdField_a_of_type_Int + ",needSearchInCloud:" + this.a.b);
    }
    paramView = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
    ChatHistoryBubbleListForTroopFragment.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, paramView, paramAdapterView.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq, -1, 2);
    this.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akea
 * JD-Core Version:    0.7.0.1
 */