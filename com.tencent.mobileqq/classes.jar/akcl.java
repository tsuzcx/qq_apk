import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class akcl
  implements AdapterView.OnItemClickListener
{
  akcl(akce paramakce) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("C2CMessageSearchDialog", 2, "onItemClick, position = " + paramInt);
    }
    if ((this.a.jdField_a_of_type_Akcc.getCount() <= 0) || (paramInt <= 0)) {}
    do
    {
      return;
      paramAdapterView = (akcy)this.a.jdField_a_of_type_Akcc.getItem(paramInt - 1);
    } while (paramAdapterView == null);
    this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramAdapterView.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (QLog.isColorLevel()) {
      QLog.i("C2CMessageSearchDialog", 2, "onItemClick, mRecordCount = " + this.a.jdField_a_of_type_Int + ",needSearchInCloud:" + this.a.b);
    }
    ChatHistoryActivity.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.uinName, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akcl
 * JD-Core Version:    0.7.0.1
 */