import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class akbo
  implements EIPCResultCallback
{
  akbo(akbm paramakbm, akbj paramakbj, DownloadParam paramDownloadParam) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()) && (paramEIPCResult.data != null))
    {
      i = paramEIPCResult.data.getInt("result_code");
      paramEIPCResult = (PreloadManager.PathResult)paramEIPCResult.data.getSerializable("path_result");
      if (this.jdField_a_of_type_Akbj != null) {
        this.jdField_a_of_type_Akbj.onResult(i, paramEIPCResult);
      }
    }
    while (this.jdField_a_of_type_Akbj == null)
    {
      int i;
      return;
    }
    this.jdField_a_of_type_Akbj.onResult(1, PreloadManager.PathResult.getFailRes(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.url));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akbo
 * JD-Core Version:    0.7.0.1
 */