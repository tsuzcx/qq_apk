import android.os.ResultReceiver;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class ajap
  implements EIPCResultCallback
{
  ajap(ajao paramajao, ResultReceiver paramResultReceiver) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajap
 * JD-Core Version:    0.7.0.1
 */