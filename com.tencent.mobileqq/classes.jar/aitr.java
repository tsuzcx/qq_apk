import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.BaseTransProcessor.StepInfo;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aitr
  implements ITransactionCallback
{
  public aitr(BDHCommonUploadProcessor paramBDHCommonUploadProcessor, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.a(paramHashMap);
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long) + "ms");
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.b);
    this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.d();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.a(paramHashMap);
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long) + "ms ,fileSize:" + this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.a.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.b.b();
    this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.b.a = 1;
    this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.s = this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.q;
    this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.e();
    this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.a.b();
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> onTransStart()");
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.b.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    BDHCommonUploadProcessor localBDHCommonUploadProcessor = this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor;
    FileMsg localFileMsg = this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.a;
    long l = paramInt;
    localFileMsg.e = l;
    localBDHCommonUploadProcessor.s = l;
    if ((paramInt < this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.q) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.o) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.k)) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aitr
 * JD-Core Version:    0.7.0.1
 */