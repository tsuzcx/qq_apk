import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.activity.qwallet.preload.QWalletIPCModule.2;
import com.tencent.mobileqq.activity.qwallet.preload.ResourceInfo;
import com.tencent.qphone.base.util.QLog;

public class ahcl
  implements ahbp
{
  public ahcl(QWalletIPCModule.2 param2, ResultReceiver paramResultReceiver) {}
  
  public void onDownloadResFinished(String paramString1, int paramInt, String paramString2, ResourceInfo paramResourceInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletIPCModule", 2, "QWalletIPC downloadModule" + paramString2 + "|" + paramResourceInfo + "|" + System.currentTimeMillis());
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString1);
    localBundle.putInt("result", paramInt);
    localBundle.putString("path", paramString2);
    localBundle.putSerializable("res_info", paramResourceInfo);
    this.jdField_a_of_type_AndroidOsResultReceiver.send(0, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahcl
 * JD-Core Version:    0.7.0.1
 */