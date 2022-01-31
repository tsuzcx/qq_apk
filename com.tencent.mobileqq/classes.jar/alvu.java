import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;

public class alvu
  extends aluc
{
  protected void a()
  {
    super.a();
    if (this.c >= alua.a().a(this.a.jdField_a_of_type_Array2dOfLong, this.a.jdField_a_of_type_Int, this.a.b, MemoryManager.a(Process.myPid())) / 12000L) {
      this.a.a(7, null);
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.d != 1L);
        MemoryManager.a().a("LITE_GUARD");
        localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      } while (localObject == null);
      localObject = (bbae)((QQAppInterface)localObject).getManager(233);
    } while (localObject == null);
    ((bbae)localObject).a(true);
  }
  
  protected void a(String paramString)
  {
    GuardManager localGuardManager = this.a;
    if ("com.tencent.mobileqq".equals(paramString)) {}
    for (int i = 2;; i = 3)
    {
      localGuardManager.a(i, paramString);
      return;
    }
  }
  
  protected void b()
  {
    if (this.c > 2L) {
      this.c -= 2L;
    }
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
    CoreService.startCoreService(alua.a().a);
    this.a.b();
    BaseApplicationImpl.sApplication.getRuntime().onGuardEvent(3, 0L, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alvu
 * JD-Core Version:    0.7.0.1
 */