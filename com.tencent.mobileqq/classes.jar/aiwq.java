import android.os.Bundle;
import com.tencent.mobileqq.soload.config.SoConfig.SoInfo;
import eipc.EIPCResult;

class aiwq
  implements aziw
{
  aiwq(aiwk paramaiwk, int paramInt) {}
  
  public void a(int paramInt, SoConfig.SoInfo paramSoInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("res", paramSoInfo);
    localBundle.putInt("code", paramInt);
    this.jdField_a_of_type_Aiwk.callbackResult(this.jdField_a_of_type_Int, EIPCResult.createSuccessResult(localBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiwq
 * JD-Core Version:    0.7.0.1
 */