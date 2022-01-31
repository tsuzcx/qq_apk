import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.Robot;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.qphone.base.util.QLog;

public class ajcd
  implements Runnable
{
  public ajcd(TroopRobotManager paramTroopRobotManager) {}
  
  public void run()
  {
    oidb_0x496.Robot localRobot = new oidb_0x496.Robot();
    byte[] arrayOfByte = this.a.a();
    if (arrayOfByte != null) {}
    try
    {
      localRobot.mergeFrom(arrayOfByte);
      this.a.a(localRobot);
      TroopRobotManager.a(this.a);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopRobotManager", 2, "file data error");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajcd
 * JD-Core Version:    0.7.0.1
 */