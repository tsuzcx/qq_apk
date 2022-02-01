import android.view.View;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import mqq.app.MobileQQ;

class aauq
  implements bjoe
{
  aauq(aaun paramaaun, MessageForDevLittleVideo paramMessageForDevLittleVideo, agok paramagok, bjnw parambjnw) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = 1;
    switch (paramInt)
    {
    }
    boolean bool;
    label64:
    do
    {
      this.jdField_a_of_type_Bjnw.dismiss();
      return;
      bool = NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_Aaun.a.getApplication().getApplicationContext());
      paramView = this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo;
      if (!bool) {
        break;
      }
      paramInt = 2002;
      paramView.videoFileStatus = paramInt;
      this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.videoFileProgress = 0;
      this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.serial();
      this.jdField_a_of_type_Aaun.a.getMessageFacade().updateMsgContentByUniseq(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.frienduin, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.istroop, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.uniseq, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.msgData);
    } while (!bool);
    if (!FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.mThumbFilePath)) {
      this.jdField_a_of_type_Aaun.c(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo);
    }
    for (paramInt = 1;; paramInt = 0)
    {
      if (!FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.videoFileName))
      {
        this.jdField_a_of_type_Aaun.b(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo);
        paramInt = i;
      }
      for (;;)
      {
        if (paramInt == 0) {
          break label235;
        }
        this.jdField_a_of_type_Agok.a.setFailedIconVisable(false, this.jdField_a_of_type_Aaun);
        aaun.b(this.jdField_a_of_type_Aaun, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo, this.jdField_a_of_type_Agok, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.videoFileProgress, false);
        break;
        paramInt = 2005;
        break label64;
      }
      label235:
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aauq
 * JD-Core Version:    0.7.0.1
 */