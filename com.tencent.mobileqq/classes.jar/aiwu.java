import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import eipc.EIPCResult;

class aiwu
  implements aivw
{
  aiwu(aiwk paramaiwk, int paramInt) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("result_code", paramInt);
    localBundle.putSerializable("path_result", paramPathResult);
    this.jdField_a_of_type_Aiwk.callbackResult(this.jdField_a_of_type_Int, EIPCResult.createSuccessResult(localBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiwu
 * JD-Core Version:    0.7.0.1
 */