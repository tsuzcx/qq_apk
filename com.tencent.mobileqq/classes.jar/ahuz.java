import android.os.Bundle;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.qphone.base.util.QLog;

class ahuz
  extends biht
{
  ahuz(ahux paramahux, ahvc paramahvc, MessageForTribeShortVideo paramMessageForTribeShortVideo) {}
  
  public void onDone(bihu parambihu)
  {
    String str = parambihu.a().getString("filePath");
    if (parambihu.a == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TribeShortVideoItemBuilder", 2, "download video success! videoFile:" + str);
      }
      this.jdField_a_of_type_Ahvc.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Ahvc.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.b();
      this.jdField_a_of_type_Ahvc.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(8);
      this.jdField_a_of_type_Ahux.a(this.jdField_a_of_type_Ahvc.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTribeShortVideo.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTribeShortVideo.videoWidth, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTribeShortVideo.videoHeight, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTribeShortVideo.coverImgUrl, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahuz
 * JD-Core Version:    0.7.0.1
 */