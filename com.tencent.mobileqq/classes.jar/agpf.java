import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.BasePicOprerator;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.statistics.GeneralConfigUtils;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PicUpExtraInfo;

public class agpf
  implements Runnable
{
  public agpf(BasePicOprerator paramBasePicOprerator, PicReq paramPicReq) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo;
    Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "doForward", "start");
    if (this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)
    {
      ((PicFowardInfo)localObject1).a("doForward", "rec==null");
      this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.a(4, ((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
      return;
    }
    MessageForPic localMessageForPic = (MessageForPic)this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    localMessageForPic.path = ((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g;
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData != null) {
      localMessageForPic.picExtraData = this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
    }
    Object localObject2 = new CompressInfo(localMessageForPic.path, 0);
    CompressOperator.b((CompressInfo)localObject2);
    TransferRequest.PicUpExtraInfo localPicUpExtraInfo;
    if (((CompressInfo)localObject2).jdField_e_of_type_JavaLangString != null)
    {
      if (GeneralConfigUtils.a())
      {
        localMessageForPic.bigThumbMsgUrl = ((CompressInfo)localObject2).jdField_e_of_type_JavaLangString;
        localMessageForPic.thumbWidth = ((CompressInfo)localObject2).d;
        localMessageForPic.thumbHeight = ((CompressInfo)localObject2).jdField_e_of_type_Int;
      }
    }
    else
    {
      localMessageForPic.serial();
      this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq, localMessageForPic.msgData);
      localObject2 = new TransferRequest();
      ((TransferRequest)localObject2).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      ((TransferRequest)localObject2).c = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
      ((TransferRequest)localObject2).d = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
      ((TransferRequest)localObject2).jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
      ((TransferRequest)localObject2).jdField_b_of_type_Int = 1;
      ((TransferRequest)localObject2).jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
      ((TransferRequest)localObject2).jdField_a_of_type_Boolean = true;
      ((TransferRequest)localObject2).jdField_e_of_type_Int = ((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_Int;
      ((TransferRequest)localObject2).i = ((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g;
      localPicUpExtraInfo = new TransferRequest.PicUpExtraInfo();
      if (((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.l != 1) {
        break label464;
      }
    }
    label464:
    for (boolean bool = true;; bool = false)
    {
      localPicUpExtraInfo.jdField_a_of_type_Boolean = bool;
      ((TransferRequest)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = localMessageForPic;
      ((TransferRequest)localObject2).jdField_a_of_type_JavaLangObject = localPicUpExtraInfo;
      ((TransferRequest)localObject2).jdField_a_of_type_ComTencentMobileqqPicUpCallBack = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      ((TransFileController)localObject1).a(((TransferRequest)localObject2).c + ((TransferRequest)localObject2).jdField_a_of_type_Long);
      ((TransFileController)localObject1).a((TransferRequest)localObject2);
      BasePicOprerator.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "doForward", "end");
      return;
      localMessageForPic.thumbMsgUrl = ((CompressInfo)localObject2).jdField_e_of_type_JavaLangString;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agpf
 * JD-Core Version:    0.7.0.1
 */