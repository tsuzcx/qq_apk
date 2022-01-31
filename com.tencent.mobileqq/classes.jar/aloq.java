import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class aloq
  extends aluc
{
  private String a;
  
  protected void a()
  {
    this.c += 1L;
    this.d += 1L;
    if ((this.d == 1L) && (SetSplash.a()) && (this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_JavaLangString == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("setsplash", 2, "needshowsplashtoday , kill myself");
      }
      azqs.a(null, "CliOper", "", "", "0X800483B", "0X800483B", 0, 0, "", "", "", "");
      System.exit(-1);
    }
    float f2 = MemoryManager.a().a();
    float f1;
    long l;
    if (alwk.a().d > 0.0F)
    {
      f1 = alwk.a().d;
      if (alwk.a().b <= 0L) {
        break label416;
      }
      l = alwk.a().b;
      label131:
      if ((alwk.a().c) && (f2 >= f1) && (this.c >= l)) {
        this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(5, this.jdField_a_of_type_JavaLangString);
      }
      int i = alua.a().a(MemoryManager.a(Process.myPid()));
      int j = alua.a().a(this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_Array2dOfLong, this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.b);
      l = alua.a().b[(i + j)] / 12000;
      if (this.c < l) {
        break label424;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(5, this.jdField_a_of_type_JavaLangString);
      label250:
      if ((this.d != 50L) && (this.d != 51L)) {
        break label510;
      }
      GuardManager.b(true);
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(false, new String[0]);
      Object localObject = aawf.a(BaseApplicationImpl.sApplication, "dex");
      if ((localObject != null) && (((aawe)localObject).a(BaseApplicationImpl.sApplication, false)))
      {
        localObject = ((aawe)localObject).b();
        if ((PatchSharedPreUtil.getPatchVerifyStatus(BaseApplicationImpl.sApplication, (String)localObject)) && (this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_JavaLangString == null) && ((aavv.jdField_a_of_type_Int == 0) || (!aavv.jdField_a_of_type_JavaLangString.equals(localObject))))
        {
          QLog.d("PatchLogTag", 1, "GuardManager exit to install patch, target patchName=" + (String)localObject + ", installed patchName=" + aavv.jdField_a_of_type_JavaLangString + ", installStatus=" + aavv.jdField_a_of_type_Int);
          System.exit(-1);
        }
      }
    }
    label416:
    label424:
    label510:
    do
    {
      return;
      f1 = 0.95F;
      break;
      l = 50L;
      break label131;
      if (this.d == 1L)
      {
        MemoryManager.a().a(1L);
        MemoryManager.a().a("BG_GUARD");
        break label250;
      }
      if ((this.d != 3L) && (this.d != 4L)) {
        break label250;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(false, new String[] { "com.tencent.mobileqq:qzone", "com.tencent.mobileqq:mini", "com.tencent.mobileqq:tool", this.jdField_a_of_type_JavaLangString });
      break label250;
      if ((this.d == GuardManager.e) || (this.d == GuardManager.e + 1))
      {
        if (!"com.tencent.mobileqq:qzone".equals(this.jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(false, "com.tencent.mobileqq:qzone");
        }
        GuardManager.b(false);
      }
    } while (((this.d != GuardManager.d) && (this.d != GuardManager.d + 1)) || ("com.tencent.mobileqq:tool".equals(this.jdField_a_of_type_JavaLangString)));
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(false, "com.tencent.mobileqq:tool");
  }
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(3, paramString);
    if ("com.tencent.mobileqq".equals(paramString)) {
      anov.a();
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
    this.jdField_a_of_type_JavaLangString = paramString;
    if ("fake_p_msg".equals(paramString)) {
      this.c = (alua.a().a(this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_Array2dOfLong, this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.b, MemoryManager.a(Process.myPid())) / 12000L - 2L);
    }
    CoreService.startCoreService(alua.a().a);
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.b();
    anvl.a();
    BaseApplicationImpl.sApplication.getRuntime().onGuardEvent(1, 0L, 0L);
    if ("com.tencent.mobileqq".equals(paramString)) {
      anov.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aloq
 * JD-Core Version:    0.7.0.1
 */