import android.content.Intent;
import com.tencent.mobileqq.ocr.OCRHandler;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;

class afnp
  implements Runnable
{
  afnp(afno paramafno, NetResp paramNetResp) {}
  
  public void run()
  {
    int i = 0;
    OCRHandler localOCRHandler;
    Intent localIntent;
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp == null) || (this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_Int != 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.ocr.OCRHandler", 2, "BaseOCRReqBigListener.onResp(), resp is null");
        }
        FMTSrvAddrProvider.a().a(6, afno.a(this.jdField_a_of_type_Afno));
        i = -10;
      }
    }
    else
    {
      localOCRHandler = this.jdField_a_of_type_Afno.a;
      localIntent = afno.a(this.jdField_a_of_type_Afno);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp == null) {
        break label191;
      }
    }
    label191:
    for (byte[] arrayOfByte = this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_ArrayOfByte;; arrayOfByte = null)
    {
      OCRHandler.a(localOCRHandler, i, localIntent, arrayOfByte, afno.a(this.jdField_a_of_type_Afno));
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.ocr.OCRHandler", 2, "BaseOCRReqBigListener.onResp(), mResult=" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_Int + ",mErrCode=" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.b + ",mHttpCode=" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.c + ",mErrDesc=" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_JavaLangString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afnp
 * JD-Core Version:    0.7.0.1
 */