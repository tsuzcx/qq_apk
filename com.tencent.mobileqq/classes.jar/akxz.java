import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.qphone.base.util.QLog;

class akxz
  implements akxc
{
  akxz(akxq paramakxq, ResultReceiver paramResultReceiver) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletIPCModule", 2, "QWalletIPC downloadUrls" + paramPathResult);
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("result_code", paramInt);
    localBundle.putSerializable("path_result", paramPathResult);
    this.jdField_a_of_type_AndroidOsResultReceiver.send(0, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxz
 * JD-Core Version:    0.7.0.1
 */