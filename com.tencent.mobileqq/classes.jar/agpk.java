import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.HashMap;

class agpk
  implements EIPCResultCallback
{
  agpk(agph paramagph, agpf paramagpf) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()) && (paramEIPCResult.data != null))
    {
      i = paramEIPCResult.data.getInt("result_code");
      paramEIPCResult = (HashMap)paramEIPCResult.data.getSerializable("path_result");
      if (this.jdField_a_of_type_Agpf != null) {
        this.jdField_a_of_type_Agpf.a(i, paramEIPCResult);
      }
    }
    while (this.jdField_a_of_type_Agpf == null)
    {
      int i;
      return;
    }
    this.jdField_a_of_type_Agpf.a(1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agpk
 * JD-Core Version:    0.7.0.1
 */