import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import eipc.EIPCResult;
import java.util.HashMap;

class aiwl
  implements aivx
{
  aiwl(aiwk paramaiwk, int paramInt) {}
  
  public void a(int paramInt, HashMap<String, PreloadManager.PathResult> paramHashMap)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("result_code", paramInt);
    localBundle.putSerializable("path_result", paramHashMap);
    this.jdField_a_of_type_Aiwk.callbackResult(this.jdField_a_of_type_Int, EIPCResult.createSuccessResult(localBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiwl
 * JD-Core Version:    0.7.0.1
 */