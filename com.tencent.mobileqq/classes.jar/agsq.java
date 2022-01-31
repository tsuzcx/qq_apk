import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.richmedia.VideoSendTaskManager;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class agsq
  implements Runnable
{
  agsq(agsp paramagsp, UpCallBack.SendResult paramSendResult) {}
  
  public void run()
  {
    if ((TransferRequest)VideoSendTaskManager.a(this.jdField_a_of_type_Agsp.a).get(agsp.a(this.jdField_a_of_type_Agsp)) != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPicUpCallBack$SendResult.a != 0) {
        break label85;
      }
      if (QLog.isColorLevel()) {
        QLog.i("PreUploadVideo", 2, "[onSend]ResultOk id=" + agsp.a(this.jdField_a_of_type_Agsp));
      }
      this.jdField_a_of_type_Agsp.a(this.jdField_a_of_type_ComTencentMobileqqPicUpCallBack$SendResult);
    }
    label85:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("PreUploadVideo", 2, "[onSend]ResultFail id=" + agsp.a(this.jdField_a_of_type_Agsp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agsq
 * JD-Core Version:    0.7.0.1
 */