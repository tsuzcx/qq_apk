import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;

class akkn
  implements bljm
{
  akkn(akkg paramakkg) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "onItemClick, position = " + paramInt);
    }
    if ((this.a.jdField_a_of_type_Akge.getCount() <= 0) || (paramInt <= 0)) {}
    do
    {
      return;
      paramAdapterView = (akjl)this.a.jdField_a_of_type_Akge.getItem(paramInt - 1);
    } while (paramAdapterView == null);
    this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramAdapterView.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "onItemClick, mRecordCount = " + this.a.jdField_a_of_type_Int + ",needSearchInCloud:" + this.a.b);
    }
    paramView = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
    ChatHistoryBubbleListForTroopFragment.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, paramView, paramAdapterView.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq, -1, 2);
    this.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akkn
 * JD-Core Version:    0.7.0.1
 */