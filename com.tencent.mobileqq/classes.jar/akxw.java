import android.os.Bundle;
import com.tencent.mobileqq.soload.SoLoadInfo;
import eipc.EIPCResult;

class akxw
  implements bdgb
{
  akxw(akxq paramakxq, int paramInt) {}
  
  public void a(SoLoadInfo paramSoLoadInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("res", paramSoLoadInfo);
    this.jdField_a_of_type_Akxq.callbackResult(this.jdField_a_of_type_Int, EIPCResult.createSuccessResult(localBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxw
 * JD-Core Version:    0.7.0.1
 */