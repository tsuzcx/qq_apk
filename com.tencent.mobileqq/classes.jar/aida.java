import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;

public class aida
  implements Runnable
{
  ShortVideoUploadInfo jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo;
  
  public aida(BaseShortVideoOprerator paramBaseShortVideoOprerator, ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo = paramShortVideoUploadInfo;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo == null) {}
    for (;;)
    {
      return;
      ShortVideoUploadInfo localShortVideoUploadInfo = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo;
      Object localObject;
      int i;
      if (!localShortVideoUploadInfo.jdField_a_of_type_Boolean)
      {
        localObject = (MessageForShortVideo)localShortVideoUploadInfo.jdField_a_of_type_JavaLangObject;
        i = 0;
      }
      while (localObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
        long l = System.currentTimeMillis();
        TransferRequest localTransferRequest = new TransferRequest();
        localTransferRequest.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
        localTransferRequest.c = ((MessageRecord)localObject).frienduin;
        localTransferRequest.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
        if ((((MessageRecord)localObject).istroop == 0) || (((MessageRecord)localObject).istroop == 1008))
        {
          localTransferRequest.jdField_b_of_type_Int = 6;
          label117:
          localTransferRequest.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
          localTransferRequest.jdField_a_of_type_Boolean = true;
          localTransferRequest.e = localShortVideoUploadInfo.jdField_a_of_type_Int;
          localTransferRequest.f = localShortVideoUploadInfo.e;
          localTransferRequest.i = (localShortVideoUploadInfo.h + "QQ_&_MoblieQQ_&_QQ" + localShortVideoUploadInfo.j + "QQ_&_MoblieQQ_&_QQ" + localShortVideoUploadInfo.jdField_f_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + localShortVideoUploadInfo.jdField_g_of_type_JavaLangString);
          localTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator;
          localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
          localTransferRequest.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo;
          this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTransferRequest);
          if ((!localShortVideoUploadInfo.d) && (!localShortVideoUploadInfo.jdField_f_of_type_Boolean))
          {
            if (localShortVideoUploadInfo.jdField_a_of_type_Boolean) {
              break label468;
            }
            this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localObject);
          }
        }
        for (;;)
        {
          Logger.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.f, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
          Logger.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.f, "doSendShortVideo.start", "TransferRequest: " + localTransferRequest.toString());
          return;
          if (localShortVideoUploadInfo.jdField_g_of_type_Int == 0)
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.a(localShortVideoUploadInfo);
            i = 1;
            break;
          }
          if (localShortVideoUploadInfo.jdField_g_of_type_Int != 1) {
            break label484;
          }
          localObject = (MessageForShortVideo)localShortVideoUploadInfo.jdField_a_of_type_JavaLangObject;
          i = 0;
          break;
          if (((MessageRecord)localObject).istroop == 3000)
          {
            localTransferRequest.jdField_b_of_type_Int = 17;
            break label117;
          }
          if (((MessageRecord)localObject).istroop != 1) {
            break label117;
          }
          localTransferRequest.jdField_b_of_type_Int = 9;
          break label117;
          label468:
          if (i != 0) {
            this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.a((MessageRecord)localObject);
          }
        }
        label484:
        localObject = null;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aida
 * JD-Core Version:    0.7.0.1
 */