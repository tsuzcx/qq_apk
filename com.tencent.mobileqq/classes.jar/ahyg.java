import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.mobileqq.shortvideo.ShortVideoForwardInfo;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;

public class ahyg
  implements Runnable
{
  ShortVideoForwardInfo jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo;
  
  public ahyg(BaseShortVideoOprerator paramBaseShortVideoOprerator, ShortVideoForwardInfo paramShortVideoForwardInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo = paramShortVideoForwardInfo;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo == null) {}
    for (;;)
    {
      return;
      ShortVideoForwardInfo localShortVideoForwardInfo = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo;
      Object localObject;
      int i;
      if (localShortVideoForwardInfo.k == 3)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.a(localShortVideoForwardInfo);
        i = 1;
      }
      while (localObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
        long l = System.currentTimeMillis();
        TransferRequest localTransferRequest = new TransferRequest();
        localTransferRequest.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
        localTransferRequest.c = ((MessageRecord)localObject).frienduin;
        localTransferRequest.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
        localTransferRequest.jdField_b_of_type_Int = 20;
        localTransferRequest.jdField_a_of_type_JavaLangObject = localShortVideoForwardInfo;
        localTransferRequest.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
        localTransferRequest.jdField_a_of_type_Boolean = true;
        localTransferRequest.e = 0;
        localTransferRequest.f = localShortVideoForwardInfo.e;
        localTransferRequest.i = (localShortVideoForwardInfo.h + "QQ_&_MoblieQQ_&_QQ" + localShortVideoForwardInfo.i + "QQ_&_MoblieQQ_&_QQ" + localShortVideoForwardInfo.j + "QQ_&_MoblieQQ_&_QQ" + localShortVideoForwardInfo.g);
        localTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator;
        localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTransferRequest);
        if (i != 0) {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.a((MessageRecord)localObject);
        }
        Logger.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.g, this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.f, "doForwardShortVideo", "cost:" + (System.currentTimeMillis() - l));
        Logger.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.g, this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.f, "doForwardShortVideo.start", "TransferRequest: " + localTransferRequest.toString());
        return;
        if (localShortVideoForwardInfo.k == 4)
        {
          localObject = (MessageForShortVideo)localShortVideoForwardInfo.jdField_a_of_type_JavaLangObject;
          i = 0;
        }
        else
        {
          localObject = null;
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahyg
 * JD-Core Version:    0.7.0.1
 */