import android.content.Context;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.qphone.base.util.BaseApplication;

public class aanw
  implements Runnable
{
  public aanw(ArkLocalAppMgr paramArkLocalAppMgr, aaou paramaaou, aapb paramaapb) {}
  
  public void run()
  {
    this.jdField_a_of_type_Aaou.a = ArkLocalAppMgr.a();
    BaseApplication localBaseApplication = BaseApplication.getContext();
    localBaseApplication.getSharedPreferences("ArkAppUpdateRecord", 0);
    localBaseApplication.getSharedPreferences("ArkAppUpdatePeriod", 0);
    localBaseApplication.getSharedPreferences("ArkAppLastUsedTime", 0);
    this.jdField_a_of_type_Aapb.a(this.jdField_a_of_type_Aaou.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aanw
 * JD-Core Version:    0.7.0.1
 */