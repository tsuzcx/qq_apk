import com.tencent.ark.ark;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;

public final class aana
  implements Runnable
{
  public void run()
  {
    for (;;)
    {
      try
      {
        if ("open".equals(ArkAiAppCenter.b()))
        {
          bool = true;
          ark.SetArkHttpsSwitch(bool);
          if (bool)
          {
            ArkAppCenter.b("SetArkHttpsSwitch", "ArkHttpsSwitch is Opened ");
            return;
          }
          ArkAppCenter.b("SetArkHttpsSwitch", "ArkHttpsSwitch is Closed ");
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.w("ArkApp", 1, "SetArkHttpsSwitch is failed and message=" + localException.getMessage());
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aana
 * JD-Core Version:    0.7.0.1
 */