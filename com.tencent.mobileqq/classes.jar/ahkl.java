import android.os.Bundle;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.qphone.base.util.QLog;

class ahkl
  extends bhyn
{
  ahkl(ahkj paramahkj, ahko paramahko, MessageForTribeShortVideo paramMessageForTribeShortVideo) {}
  
  public void onDone(bhyo parambhyo)
  {
    String str = parambhyo.a().getString("filePath");
    if (parambhyo.a == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TribeShortVideoItemBuilder", 2, "download video success! videoFile:" + str);
      }
      this.jdField_a_of_type_Ahko.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Ahko.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.b();
      this.jdField_a_of_type_Ahko.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(8);
      this.jdField_a_of_type_Ahkj.a(this.jdField_a_of_type_Ahko.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTribeShortVideo.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTribeShortVideo.videoWidth, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTribeShortVideo.videoHeight, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTribeShortVideo.coverImgUrl, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahkl
 * JD-Core Version:    0.7.0.1
 */