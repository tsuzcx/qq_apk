import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.qphone.base.util.QLog;

class ahgh
  implements bkzq
{
  ahgh(ahfz paramahfz, MessageForShortVideo paramMessageForShortVideo, ahgk paramahgk, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      for (;;)
      {
        this.jdField_a_of_type_Bkzi.dismiss();
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uiOperatorFlag != 2) {
          break;
        }
        this.jdField_a_of_type_Ahfz.a(this.jdField_a_of_type_Ahgk, 10, false);
        this.jdField_a_of_type_Ahfz.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, this.jdField_a_of_type_Ahgk);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uiOperatorFlag != 1);
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1004) {
      ShortVideoUtils.reportCancelSendVideo("0X800A375", this.jdField_a_of_type_Ahfz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    }
    ahfz.a(this.jdField_a_of_type_Ahfz, this.jdField_a_of_type_Ahgk, true, this.jdField_a_of_type_Ahfz);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.isPause = false;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5)) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1004) && (this.jdField_a_of_type_Ahfz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().resumeSendingShortVideo(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq)))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus = 1002;
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoItemBuilder", 2, "onErrorIconClick resumeSending!");
      }
    }
    for (;;)
    {
      ahfz.a(this.jdField_a_of_type_Ahfz);
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5 == null) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1005) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1004)))
      {
        this.jdField_a_of_type_Ahgk.a.setVisibility(8);
        this.jdField_a_of_type_Ahgk.d.setVisibility(8);
        this.jdField_a_of_type_Ahgk.c.setVisibility(8);
        paramView = new bcyt(this.jdField_a_of_type_Ahfz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ahfz.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, ahfz.a(this.jdField_a_of_type_Ahfz));
        bcys.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, paramView);
      }
      else
      {
        this.jdField_a_of_type_Ahfz.a(this.jdField_a_of_type_Ahgk, 10, false);
        this.jdField_a_of_type_Ahfz.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, this.jdField_a_of_type_Ahgk);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahgh
 * JD-Core Version:    0.7.0.1
 */