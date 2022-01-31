import android.content.Context;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.qphone.base.util.BaseApplication;

public class abbs
  implements Runnable
{
  public abbs(ArkLocalAppMgr paramArkLocalAppMgr, abcq paramabcq, abcx paramabcx) {}
  
  public void run()
  {
    this.jdField_a_of_type_Abcq.a = ArkLocalAppMgr.a();
    BaseApplication localBaseApplication = BaseApplication.getContext();
    localBaseApplication.getSharedPreferences("ArkAppUpdateRecord", 0);
    localBaseApplication.getSharedPreferences("ArkAppUpdatePeriod", 0);
    localBaseApplication.getSharedPreferences("ArkAppLastUsedTime", 0);
    this.jdField_a_of_type_Abcx.a(this.jdField_a_of_type_Abcq.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abbs
 * JD-Core Version:    0.7.0.1
 */