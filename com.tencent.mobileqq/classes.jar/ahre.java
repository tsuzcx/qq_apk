import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

class ahre
  implements bliz
{
  ahre(ahqw paramahqw, MessageForShortVideo paramMessageForShortVideo, ahrh paramahrh, blir paramblir) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      for (;;)
      {
        this.jdField_a_of_type_Blir.dismiss();
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uiOperatorFlag != 2) {
          break;
        }
        this.jdField_a_of_type_Ahqw.a(this.jdField_a_of_type_Ahrh, 10, false);
        this.jdField_a_of_type_Ahqw.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, this.jdField_a_of_type_Ahrh);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uiOperatorFlag != 1);
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1004) {
      ShortVideoUtils.c("0X800A375", this.jdField_a_of_type_Ahqw.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
    ahqw.a(this.jdField_a_of_type_Ahqw, this.jdField_a_of_type_Ahrh, true, this.jdField_a_of_type_Ahqw);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.isPause = false;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5)) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1004) && (this.jdField_a_of_type_Ahqw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq)))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus = 1002;
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoItemBuilder", 2, "onErrorIconClick resumeSending!");
      }
    }
    for (;;)
    {
      ahqw.a(this.jdField_a_of_type_Ahqw);
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5 == null) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1005) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1004)))
      {
        this.jdField_a_of_type_Ahrh.a.setVisibility(8);
        this.jdField_a_of_type_Ahrh.d.setVisibility(8);
        this.jdField_a_of_type_Ahrh.c.setVisibility(8);
        paramView = new bcyq(this.jdField_a_of_type_Ahqw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ahqw.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, ahqw.a(this.jdField_a_of_type_Ahqw));
        bcyp.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, paramView);
      }
      else
      {
        this.jdField_a_of_type_Ahqw.a(this.jdField_a_of_type_Ahrh, 10, false);
        this.jdField_a_of_type_Ahqw.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, this.jdField_a_of_type_Ahrh);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahre
 * JD-Core Version:    0.7.0.1
 */