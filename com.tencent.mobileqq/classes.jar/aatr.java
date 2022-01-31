import android.os.Build;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.startup.step.UpdateArkSo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public final class aatr
  implements Runnable
{
  public void run()
  {
    if ((!ArkAppCenter.b) && (ArkAppCenter.c))
    {
      long l1 = System.currentTimeMillis();
      UpdateArkSo.a(BaseApplicationImpl.getContext(), "png-armeabi-v7a");
      ArkAppCenter.b = UpdateArkSo.b(BaseApplicationImpl.getContext(), "ark-armeabi-v7a");
      long l2 = System.currentTimeMillis();
      QLog.d("ArkApp", 1, "load libark.so for ARMv7!, loaded=" + Boolean.toString(ArkAppCenter.b) + ", time=" + (l2 - l1));
    }
    if (ArkAppCenter.d()) {
      return;
    }
    ArkAppCenter.a(true);
    if (ArkAppCenter.b)
    {
      ReportController.b(null, "CliOper", "", "", "0X8006365", "ark.lib.load.success", 0, 0, "0", "0", Build.CPU_ABI, Build.CPU_ABI2);
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8006365", "ark.lib.load.fail", 1, 1, "1", "1", Build.CPU_ABI, Build.CPU_ABI2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aatr
 * JD-Core Version:    0.7.0.1
 */