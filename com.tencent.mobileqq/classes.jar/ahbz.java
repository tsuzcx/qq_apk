import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.HashMap;

class ahbz
  implements EIPCResultCallback
{
  ahbz(ahbw paramahbw, ahbu paramahbu) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()) && (paramEIPCResult.data != null))
    {
      i = paramEIPCResult.data.getInt("result_code");
      paramEIPCResult = (HashMap)paramEIPCResult.data.getSerializable("path_result");
      if (this.jdField_a_of_type_Ahbu != null) {
        this.jdField_a_of_type_Ahbu.a(i, paramEIPCResult);
      }
    }
    while (this.jdField_a_of_type_Ahbu == null)
    {
      int i;
      return;
    }
    this.jdField_a_of_type_Ahbu.a(1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahbz
 * JD-Core Version:    0.7.0.1
 */