import com.tencent.ark.ark;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.qphone.base.util.QLog;

public class ader
  implements Runnable
{
  public ader(GamePartyManager paramGamePartyManager, String paramString) {}
  
  public void run()
  {
    try
    {
      ark.arkNotify("com.tencent.qqopen.teamup", "update_team_info", this.jdField_a_of_type_JavaLangString, "json");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("GamePartyManager", 2, "arkNotify failed, .so not loaded");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ader
 * JD-Core Version:    0.7.0.1
 */