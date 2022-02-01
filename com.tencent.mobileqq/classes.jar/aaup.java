import android.view.View;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import mqq.app.MobileQQ;

class aaup
  implements bjoe
{
  aaup(aaun paramaaun, MessageForDevLittleVideo paramMessageForDevLittleVideo, agok paramagok, bjnw parambjnw) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      this.jdField_a_of_type_Bjnw.dismiss();
      return;
    }
    boolean bool = NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_Aaun.a.getApplication().getApplicationContext());
    paramView = this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo;
    if (bool) {}
    for (paramInt = 1002;; paramInt = 1005)
    {
      paramView.videoFileStatus = paramInt;
      this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.videoFileProgress = 0;
      this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.serial();
      this.jdField_a_of_type_Aaun.a.getMessageFacade().updateMsgContentByUniseq(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.frienduin, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.istroop, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.uniseq, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.msgData);
      if (!bool) {
        break;
      }
      this.jdField_a_of_type_Aaun.a(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo);
      this.jdField_a_of_type_Agok.a.setFailedIconVisable(false, this.jdField_a_of_type_Aaun);
      aaun.a(this.jdField_a_of_type_Aaun, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo, this.jdField_a_of_type_Agok, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.videoFileProgress, false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaup
 * JD-Core Version:    0.7.0.1
 */