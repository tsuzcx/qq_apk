import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class aksj
  implements EIPCResultCallback
{
  aksj(aksh paramaksh, akse paramakse, DownloadParam paramDownloadParam) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()) && (paramEIPCResult.data != null))
    {
      i = paramEIPCResult.data.getInt("result_code");
      paramEIPCResult = (PreloadManager.PathResult)paramEIPCResult.data.getSerializable("path_result");
      if (this.jdField_a_of_type_Akse != null) {
        this.jdField_a_of_type_Akse.onResult(i, paramEIPCResult);
      }
    }
    while (this.jdField_a_of_type_Akse == null)
    {
      int i;
      return;
    }
    this.jdField_a_of_type_Akse.onResult(1, PreloadManager.PathResult.getFailRes(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.url));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aksj
 * JD-Core Version:    0.7.0.1
 */