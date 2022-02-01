import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class akxh
  implements EIPCResultCallback
{
  akxh(akxf paramakxf, akxc paramakxc, DownloadParam paramDownloadParam) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()) && (paramEIPCResult.data != null))
    {
      i = paramEIPCResult.data.getInt("result_code");
      paramEIPCResult = (PreloadManager.PathResult)paramEIPCResult.data.getSerializable("path_result");
      if (this.jdField_a_of_type_Akxc != null) {
        this.jdField_a_of_type_Akxc.onResult(i, paramEIPCResult);
      }
    }
    while (this.jdField_a_of_type_Akxc == null)
    {
      int i;
      return;
    }
    this.jdField_a_of_type_Akxc.onResult(1, PreloadManager.PathResult.getFailRes(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.url));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxh
 * JD-Core Version:    0.7.0.1
 */