import android.os.Bundle;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.qphone.base.util.QLog;

public class aecu
  extends bbwt
{
  public aecu(TribeShortVideoItemBuilder paramTribeShortVideoItemBuilder, aecx paramaecx, MessageForTribeShortVideo paramMessageForTribeShortVideo) {}
  
  public void onDone(bbwu parambbwu)
  {
    String str = parambbwu.a().getString("filePath");
    if (parambbwu.a == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TribeShortVideoItemBuilder", 2, "download video success! videoFile:" + str);
      }
      this.jdField_a_of_type_Aecx.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Aecx.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.b();
      this.jdField_a_of_type_Aecx.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder.a(this.jdField_a_of_type_Aecx.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTribeShortVideo.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTribeShortVideo.videoWidth, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTribeShortVideo.videoHeight, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTribeShortVideo.coverImgUrl, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aecu
 * JD-Core Version:    0.7.0.1
 */