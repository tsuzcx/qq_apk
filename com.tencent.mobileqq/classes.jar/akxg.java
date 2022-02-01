import android.os.Bundle;
import android.os.ResultReceiver;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class akxg
  implements EIPCResultCallback
{
  akxg(akxf paramakxf, ResultReceiver paramResultReceiver) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()))
    {
      this.jdField_a_of_type_AndroidOsResultReceiver.send(0, paramEIPCResult.data);
      return;
    }
    this.jdField_a_of_type_AndroidOsResultReceiver.send(0, new Bundle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxg
 * JD-Core Version:    0.7.0.1
 */