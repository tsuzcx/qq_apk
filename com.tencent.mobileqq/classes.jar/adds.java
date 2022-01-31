import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class adds
  implements DialogInterface.OnClickListener
{
  adds(addr paramaddr) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = BaseApplicationImpl.getContext().getSharedPreferences("now_down_apk", 4);
    if (paramDialogInterface.getInt("state", 0) == 1) {
      try
      {
        UniformDownloadUtil.a(paramDialogInterface.getString("filePath", ""));
        return;
      }
      catch (Exception paramDialogInterface)
      {
        QLog.e("NearbyHybridFragment", 1, paramDialogInterface, new Object[0]);
        this.a.a.f();
        return;
      }
    }
    this.a.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adds
 * JD-Core Version:    0.7.0.1
 */