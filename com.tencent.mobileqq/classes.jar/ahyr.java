import android.os.Handler;
import android.view.View;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.VipUtils;
import java.util.ArrayList;
import java.util.List;

public class ahyr
  implements bhuk
{
  public ahyr(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment, MessageRecord paramMessageRecord, bhuf parambhuf) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhuf.dismiss();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CAllFragment.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CAllFragment.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPtt))
      {
        paramView = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CAllFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
        if ((paramView == this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord) || (((paramView instanceof MessageForPtt)) && (paramView.uniseq == this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq))) {
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CAllFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c(false);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CAllFragment.e = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CAllFragment.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CAllFragment.b.obtainMessage(1);
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CAllFragment.b.sendMessageDelayed(paramView, 800L);
      Utils.executeAsyncTaskOnThreadPool(new ahys(this), new MessageRecord[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord });
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CAllFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatHistory", "Clk_deleteOne", 1, 0, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahyr
 * JD-Core Version:    0.7.0.1
 */