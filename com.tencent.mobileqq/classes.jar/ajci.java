import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.Robot;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileOutputStream;
import java.io.IOException;

public class ajci
  implements Runnable
{
  public ajci(TroopRobotManager paramTroopRobotManager, oidb_0x496.Robot paramRobot) {}
  
  public void run()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        localFileOutputStream = BaseApplication.getContext().openFileOutput("troop_robot_config", 0);
        localObject1 = localFileOutputStream;
        localObject3 = localFileOutputStream;
        localFileOutputStream.write(this.jdField_a_of_type_ComTencentMobileqqTroopOrgPbOidb_0x496$Robot.toByteArray());
        localObject1 = localFileOutputStream;
        localObject3 = localFileOutputStream;
        localFileOutputStream.flush();
        localObject1 = localFileOutputStream;
        localObject3 = localFileOutputStream;
        localFileOutputStream.close();
      }
      catch (IOException localIOException4)
      {
        FileOutputStream localFileOutputStream;
        localObject3 = localIOException1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject3 = localIOException1;
        QLog.e("TroopRobotManager", 2, QLog.getStackTraceString(localIOException4));
        if (localIOException1 == null) {
          continue;
        }
        try
        {
          localIOException1.close();
        }
        catch (IOException localIOException2) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("TroopRobotManager", 2, QLog.getStackTraceString(localIOException2));
        continue;
      }
      finally
      {
        if (localObject3 == null) {
          break label172;
        }
      }
      try
      {
        localFileOutputStream.close();
        BaseApplication.getContext().getSharedPreferences("troop_robot_config", 0).edit().putInt("troop_robot_config_version", this.jdField_a_of_type_ComTencentMobileqqTroopOrgPbOidb_0x496$Robot.version.get()).commit();
        return;
      }
      catch (IOException localIOException1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopRobotManager", 2, QLog.getStackTraceString(localIOException1));
        }
      }
    }
    try
    {
      localObject3.close();
      label172:
      throw localObject2;
    }
    catch (IOException localIOException3)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopRobotManager", 2, QLog.getStackTraceString(localIOException3));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajci
 * JD-Core Version:    0.7.0.1
 */