import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.mobileqq.shortvideo.ShortVideoForwardInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoResult;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.msg.im_msg_body.RichText;

class aicz
  implements UpCallBack
{
  final int jdField_a_of_type_Int;
  ShortVideoResult jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResult;
  
  aicz(aicy paramaicy, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResult = ((ShortVideoResult)paramaicy.b.get(this.jdField_a_of_type_Int));
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return (MessageForShortVideo)((ShortVideoForwardInfo)this.jdField_a_of_type_Aicy.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a;
  }
  
  public void a(UpCallBack.SendResult paramSendResult)
  {
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)((ShortVideoForwardInfo)this.jdField_a_of_type_Aicy.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a;
    localMessageForShortVideo.videoFileStatus = 1003;
    localMessageForShortVideo.md5 = paramSendResult.d;
    localMessageForShortVideo.uuid = paramSendResult.jdField_c_of_type_JavaLangString;
    localMessageForShortVideo.thumbFileSize = ((int)paramSendResult.jdField_c_of_type_Long);
    localMessageForShortVideo.videoAttr = paramSendResult.jdField_c_of_type_Int;
    localMessageForShortVideo.serial();
    paramSendResult = this.jdField_a_of_type_Aicy.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.a.a();
    if (paramSendResult != null) {
      paramSendResult.a(localMessageForShortVideo, null);
    }
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_Aicy.b)
      {
        if (paramSendResult.jdField_a_of_type_Int == 0)
        {
          a(paramSendResult);
          this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResult.jdField_a_of_type_Int = 0;
          if (QLog.isColorLevel()) {
            QLog.d("BaseShortVideoOprerator", 2, "onsend success!");
          }
          i = aicy.a(this.jdField_a_of_type_Aicy);
          if (i == 0) {
            this.jdField_a_of_type_Aicy.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.a(3, 0, this.jdField_a_of_type_Aicy.b);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResult.jdField_a_of_type_Int = -1;
          this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = new PicInfoInterface.ErrInfo();
          this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b = paramSendResult.jdField_a_of_type_JavaLangString;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("BaseShortVideoOprerator", 2, "onsend fail! err:" + paramSendResult.jdField_a_of_type_JavaLangString);
        }
      }
      if (this.jdField_a_of_type_Aicy.jdField_a_of_type_Int == this.jdField_a_of_type_Aicy.jdField_a_of_type_JavaUtilArrayList.size() - i) {
        this.jdField_a_of_type_Aicy.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aicz
 * JD-Core Version:    0.7.0.1
 */