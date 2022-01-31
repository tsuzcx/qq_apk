import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import eipc.EIPCResult;
import java.util.HashMap;

class ahch
  implements ahbs
{
  ahch(ahcg paramahcg, int paramInt) {}
  
  public void a(int paramInt, HashMap<String, PreloadManager.PathResult> paramHashMap)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("result_code", paramInt);
    localBundle.putSerializable("path_result", paramHashMap);
    this.jdField_a_of_type_Ahcg.callbackResult(this.jdField_a_of_type_Int, EIPCResult.createSuccessResult(localBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahch
 * JD-Core Version:    0.7.0.1
 */