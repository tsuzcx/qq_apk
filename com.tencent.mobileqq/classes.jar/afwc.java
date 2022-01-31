import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

class afwc
  implements bhqd
{
  afwc(afvt paramafvt, MessageForShortVideo paramMessageForShortVideo, afwd paramafwd, bhpy parambhpy) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      for (;;)
      {
        this.jdField_a_of_type_Bhpy.dismiss();
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uiOperatorFlag != 2) {
          break;
        }
        this.jdField_a_of_type_Afvt.a(this.jdField_a_of_type_Afwd, 10, false);
        this.jdField_a_of_type_Afvt.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, this.jdField_a_of_type_Afwd);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uiOperatorFlag != 1);
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1004) {
      ShortVideoUtils.c("0X800A375", this.jdField_a_of_type_Afvt.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
    afvt.a(this.jdField_a_of_type_Afvt, this.jdField_a_of_type_Afwd, true, this.jdField_a_of_type_Afvt);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.isPause = false;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5)) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1004) && (this.jdField_a_of_type_Afvt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq)))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus = 1002;
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoItemBuilder", 2, "onErrorIconClick resumeSending!");
      }
    }
    for (;;)
    {
      afvt.a(this.jdField_a_of_type_Afvt);
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5 == null) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1005) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1004)))
      {
        this.jdField_a_of_type_Afwd.a.setVisibility(8);
        this.jdField_a_of_type_Afwd.d.setVisibility(8);
        this.jdField_a_of_type_Afwd.c.setVisibility(8);
        paramView = new azap(this.jdField_a_of_type_Afvt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Afvt.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, this.jdField_a_of_type_Afvt);
        azao.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, paramView);
      }
      else
      {
        this.jdField_a_of_type_Afvt.a(this.jdField_a_of_type_Afwd, 10, false);
        this.jdField_a_of_type_Afvt.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, this.jdField_a_of_type_Afwd);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afwc
 * JD-Core Version:    0.7.0.1
 */