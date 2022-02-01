import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class ahrt
  implements bliz
{
  public ahrt(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder, MessageForShortVideo paramMessageForShortVideo, ahrx paramahrx, blir paramblir) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Blir.dismiss();
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uiOperatorFlag == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1004)) {
        ShortVideoUtils.c("0X800A7F0", this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uiOperatorFlag == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, this.jdField_a_of_type_Ahrx);
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uiOperatorFlag == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5 == null))
      {
        if (!ShortVideoRealItemBuilder.d())
        {
          ShortVideoRealItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, this.jdField_a_of_type_Ahrx, true, true);
        }
        else if (!ShortVideoRealItemBuilder.a().containsKey(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq)))
        {
          ShortVideoRealItemBuilder.a().put(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq), this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
          if (QLog.isColorLevel()) {
            QLog.i("ShortVideoRealItemBuilder", 2, "messageMap size:" + ShortVideoRealItemBuilder.a().size() + ", [" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq + "] added, mEncoding:" + ShortVideoRealItemBuilder.d());
          }
        }
      }
      else if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5)) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1004) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq)))
      {
        ShortVideoRealItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder);
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoRealItemBuilder", 2, "onErrorIconClick resumeSending!");
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, this.jdField_a_of_type_Ahrx);
        ShortVideoRealItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahrt
 * JD-Core Version:    0.7.0.1
 */