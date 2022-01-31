import android.os.ResultReceiver;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class ahbv
  implements EIPCResultCallback
{
  ahbv(ahbu paramahbu, ResultReceiver paramResultReceiver) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()))
    {
      this.jdField_a_of_type_AndroidOsResultReceiver.send(0, paramEIPCResult.data);
      return;
    }
    this.jdField_a_of_type_AndroidOsResultReceiver.send(0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahbv
 * JD-Core Version:    0.7.0.1
 */