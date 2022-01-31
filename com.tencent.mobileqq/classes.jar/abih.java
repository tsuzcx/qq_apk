import android.os.Handler;
import com.tencent.mobileqq.armap.config.ARMapConfigManager;
import com.tencent.mobileqq.armap.config.ConfigCheckHander;
import com.tencent.mobileqq.armap.config.ConfigCheckHander.Listener;
import com.tencent.mobileqq.armap.wealthgod.ARMapLoadingActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class abih
  implements ConfigCheckHander.Listener
{
  public abih(ARMapLoadingActivity paramARMapLoadingActivity) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, String.format("handleCheckAndDownloadResMsg onUpdate progress=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  public void a(int paramInt, List paramList)
  {
    ARMapLoadingActivity.a(this.a).h = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, String.format("handleCheckAndDownloadResMsg onResult errCode=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    if ((paramInt == 0) && (paramList != null)) {
      ARMapLoadingActivity.a(this.a).sendEmptyMessage(110);
    }
    for (;;)
    {
      if (ARMapLoadingActivity.a(this.a) != null)
      {
        paramList = ARMapLoadingActivity.a(this.a).a();
        if (paramList != null) {
          paramList.a(null);
        }
      }
      return;
      paramList = ARMapLoadingActivity.a(this.a).obtainMessage(104);
      paramList.arg1 = 3;
      paramList.arg2 = paramInt;
      ARMapLoadingActivity.a(this.a).sendMessage(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abih
 * JD-Core Version:    0.7.0.1
 */