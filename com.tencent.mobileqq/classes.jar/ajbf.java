import android.os.Bundle;
import com.tencent.mobileqq.soload.config.SoConfig.SoInfo;
import eipc.EIPCResult;

class ajbf
  implements aznf
{
  ajbf(ajaz paramajaz, int paramInt) {}
  
  public void a(int paramInt, SoConfig.SoInfo paramSoInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("res", paramSoInfo);
    localBundle.putInt("code", paramInt);
    this.jdField_a_of_type_Ajaz.callbackResult(this.jdField_a_of_type_Int, EIPCResult.createSuccessResult(localBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajbf
 * JD-Core Version:    0.7.0.1
 */