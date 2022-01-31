import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;

public class abcn
  implements abcw
{
  public abcn(ArkLocalAppMgr paramArkLocalAppMgr) {}
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      ArkAppCenter.b("ArkApp.ArkLocalAppMgr", "updateInstalledApps, network not available.");
      return;
    }
    this.a.c();
    ArkLocalAppMgr.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abcn
 * JD-Core Version:    0.7.0.1
 */