import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.history.tendoc.TenDocMessageResultAdapter;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;

class akkc
  implements bljm
{
  akkc(akka paramakka) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TenDocMessageSearchDialog", 2, "onItemClick, position = " + paramInt);
    }
    if ((akka.a(this.a).getCount() <= 0) || (paramInt <= 0)) {
      return;
    }
    paramAdapterView = (akjl)akka.a(this.a).getItem(paramInt - 1);
    if ((paramAdapterView != null) && (paramAdapterView.a != null))
    {
      paramAdapterView = paramAdapterView.a;
      QLog.d("TenDocMessageSearchDialog", 4, "jump to mr: " + paramAdapterView.msgseq + " " + paramAdapterView.shmsgseq);
      if (adak.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
        ChatHistoryBubbleListForTroopFragment.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramAdapterView.shmsgseq, 0, 2);
      }
      for (;;)
      {
        bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A175", "0X800A175", akka.a(this.a), 0, "", "", "s_qq_history_tab", "");
        this.a.a(true);
        return;
        ChatHistoryActivity.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.h, paramAdapterView.time, paramAdapterView.shmsgseq, 0);
      }
    }
    QLog.e("TenDocMessageSearchDialog", 2, "null item: " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akkc
 * JD-Core Version:    0.7.0.1
 */