import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

class adzo
  implements bfph
{
  adzo(adzf paramadzf, MessageForShortVideo paramMessageForShortVideo, adzp paramadzp, bfpc parambfpc) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      for (;;)
      {
        this.jdField_a_of_type_Bfpc.dismiss();
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uiOperatorFlag != 2) {
          break;
        }
        this.jdField_a_of_type_Adzf.a(this.jdField_a_of_type_Adzp, 10, false);
        this.jdField_a_of_type_Adzf.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, this.jdField_a_of_type_Adzp);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uiOperatorFlag != 1);
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1004) {
      ShortVideoUtils.c("0X800A375", this.jdField_a_of_type_Adzf.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
    adzf.a(this.jdField_a_of_type_Adzf, this.jdField_a_of_type_Adzp, true, this.jdField_a_of_type_Adzf);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.isPause = false;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5)) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1004) && (this.jdField_a_of_type_Adzf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq)))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus = 1002;
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoItemBuilder", 2, "onErrorIconClick resumeSending!");
      }
    }
    for (;;)
    {
      adzf.a(this.jdField_a_of_type_Adzf);
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5 == null) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1005) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1004)))
      {
        this.jdField_a_of_type_Adzp.a.setVisibility(8);
        this.jdField_a_of_type_Adzp.d.setVisibility(8);
        this.jdField_a_of_type_Adzp.c.setVisibility(8);
        paramView = new axfj(this.jdField_a_of_type_Adzf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Adzf.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, this.jdField_a_of_type_Adzf);
        axfi.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, paramView);
      }
      else
      {
        this.jdField_a_of_type_Adzf.a(this.jdField_a_of_type_Adzp, 10, false);
        this.jdField_a_of_type_Adzf.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, this.jdField_a_of_type_Adzp);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adzo
 * JD-Core Version:    0.7.0.1
 */