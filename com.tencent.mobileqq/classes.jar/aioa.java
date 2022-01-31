import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.theme.NightModeLogic;
import com.tencent.mobileqq.theme.ThemeDownloader;
import com.tencent.mobileqq.theme.ThemeDownloader.ThemeDownloadListener;
import com.tencent.qphone.base.util.QLog;

public class aioa
  implements ThemeDownloader.ThemeDownloadListener
{
  public aioa(NightModeLogic paramNightModeLogic) {}
  
  public void onDownloadCallback(Bundle paramBundle, int paramInt1, int paramInt2, int paramInt3, ThemeDownloader paramThemeDownloader)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NightModeLogic", 2, "mThemeDownloadListener onDownloadCallback stateCode:" + paramInt1);
    }
    if (paramInt1 == 4) {}
    for (;;)
    {
      return;
      this.a.jdField_a_of_type_Boolean = false;
      if (paramInt1 >= 0)
      {
        paramBundle = new Bundle();
        paramBundle.putInt("start_status", 4);
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.a.jdField_a_of_type_AndroidOsHandler, 4099, 1, 0, paramBundle));
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4098);
      }
      while (paramThemeDownloader != null)
      {
        paramThemeDownloader.a();
        return;
        paramBundle = new Bundle();
        paramBundle.putInt("start_status", 4);
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.a.jdField_a_of_type_AndroidOsHandler, 4099, -2, 0, paramBundle));
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.a.jdField_a_of_type_AndroidOsHandler, 4102, paramInt2, paramInt3));
        QLog.e("NightModeLogic", 1, "mThemeDownloadListener onDownloadCallback download fail");
      }
    }
  }
  
  public void onDownloadProgress(Bundle paramBundle, int paramInt, long paramLong1, long paramLong2)
  {
    paramInt = 100;
    if (paramLong2 <= 0L)
    {
      QLog.e("NightModeLogic", 1, "mThemeDownloadListener onDownloadProgress dwProgressMax <= 0");
      paramInt = 4;
    }
    if (paramLong1 <= paramLong2) {
      paramInt = (int)(Math.round(paramLong1 * 1.0D / paramLong2 * 100.0D) / 100.0D * 100.0D);
    }
    if (QLog.isColorLevel()) {
      QLog.d("NightModeLogic", 2, "mThemeDownloadListener onDownloadProgress readSize:" + paramLong1 + ", allSize:" + paramLong2 + ", percent:" + paramInt);
    }
    paramBundle = new Bundle();
    paramBundle.putInt("percent", paramInt);
    paramBundle.putInt("start_status", 3);
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.a.jdField_a_of_type_AndroidOsHandler, 4099, 1, 0, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aioa
 * JD-Core Version:    0.7.0.1
 */