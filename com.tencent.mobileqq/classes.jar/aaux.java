import android.content.Context;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.qphone.base.util.BaseApplication;

public class aaux
  implements Runnable
{
  public aaux(ArkLocalAppMgr paramArkLocalAppMgr, aavv paramaavv, aawc paramaawc) {}
  
  public void run()
  {
    this.jdField_a_of_type_Aavv.a = ArkLocalAppMgr.a();
    BaseApplication localBaseApplication = BaseApplication.getContext();
    localBaseApplication.getSharedPreferences("ArkAppUpdateRecord", 0);
    localBaseApplication.getSharedPreferences("ArkAppUpdatePeriod", 0);
    localBaseApplication.getSharedPreferences("ArkAppLastUsedTime", 0);
    this.jdField_a_of_type_Aawc.a(this.jdField_a_of_type_Aavv.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaux
 * JD-Core Version:    0.7.0.1
 */