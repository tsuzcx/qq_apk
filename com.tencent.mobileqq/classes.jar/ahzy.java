import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.theme.NightModeLogic;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ahzy
  extends Handler
{
  public ahzy(NightModeLogic paramNightModeLogic, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            boolean bool;
            do
            {
              return;
              this.a.a();
              return;
              bool = this.a.c();
            } while (!QLog.isColorLevel());
            QLog.i("NightModeLogic", 2, "startNightMode result=" + bool);
            return;
          } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof Bundle)));
          this.a.a(paramMessage.arg1, (Bundle)paramMessage.obj);
          return;
        } while (this.a.a == null);
        QQToast.a(this.a.a.getApplication(), "主题文件异常，切换回默认主题", 4000).a();
        return;
      } while (this.a.a == null);
      QQToast.a(this.a.a.getApplication(), "夜间主题配置加载失败" + paramMessage.arg1 + "_" + paramMessage.arg2, 4000).a();
      return;
    } while (this.a.a == null);
    QQToast.a(this.a.a.getApplication(), "网络环境异常，夜间主题下载失败" + paramMessage.arg1 + "_" + paramMessage.arg2, 4000).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahzy
 * JD-Core Version:    0.7.0.1
 */