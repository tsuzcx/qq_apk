import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PicUpExtraInfo;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity.UploadPicCallback;

public class ajxb
  implements Runnable
{
  public ajxb(TroopPicEffectsEditActivity paramTroopPicEffectsEditActivity, PicUploadInfo paramPicUploadInfo) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity.app.getHwEngine().preConnect();
    Object localObject = new CompressInfo(this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g, 0);
    ((CompressInfo)localObject).f = 0;
    CompressOperator.a((CompressInfo)localObject);
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity.app.getAccount();
    localTransferRequest.c = this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity.jdField_b_of_type_JavaLangString;
    localTransferRequest.d = this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity.app.getCurrentAccountUin();
    localTransferRequest.jdField_a_of_type_Int = 1;
    localTransferRequest.jdField_b_of_type_Int = 1;
    localTransferRequest.jdField_a_of_type_Boolean = true;
    localTransferRequest.e = this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_Int;
    localTransferRequest.jdField_i_of_type_JavaLangString = ((CompressInfo)localObject).e;
    localTransferRequest.f = this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.f;
    localObject = new TransferRequest.PicUpExtraInfo();
    localTransferRequest.jdField_a_of_type_JavaLangObject = localObject;
    ((TransferRequest.PicUpExtraInfo)localObject).jdField_a_of_type_Boolean = false;
    localTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack = new TroopPicEffectsEditActivity.UploadPicCallback(this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity);
    localTransferRequest.jdField_i_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c;
    localTransferRequest.j = this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.e;
    localTransferRequest.jdField_b_of_type_Int = 55;
    localTransferRequest.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity.app.a().a(localTransferRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxb
 * JD-Core Version:    0.7.0.1
 */