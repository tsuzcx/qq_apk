import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.qphone.base.util.QLog;

public class aauo
  implements Runnable
{
  public aauo(ArkLocalAppMgr paramArkLocalAppMgr) {}
  
  public void run()
  {
    try
    {
      ArkAppCenter.a(true);
      ArkLocalAppMgr.a(this.a);
      return;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      QLog.e("ArkApp.ArkLocalAppMgr", 1, localNoClassDefFoundError.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aauo
 * JD-Core Version:    0.7.0.1
 */