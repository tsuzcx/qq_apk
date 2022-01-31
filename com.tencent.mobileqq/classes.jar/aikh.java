import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.QFixApplicationImpl;
import com.tencent.hotpatch.PatchSecurityMode;
import com.tencent.hotpatch.config.PatchConfig;
import com.tencent.hotpatch.config.PatchConfigManager;
import com.tencent.hotpatch.utils.PatchSharedPreUtil;
import com.tencent.mobileqq.startup.step.Rdm;

public class aikh
  implements Runnable
{
  public aikh(Rdm paramRdm, String paramString) {}
  
  public void run()
  {
    if (BaseApplicationImpl.sProcessId == 1) {
      PatchSecurityMode.a(BaseApplicationImpl.sApplication, 0);
    }
    PatchConfig localPatchConfig = PatchConfigManager.a(BaseApplicationImpl.sApplication, "dex");
    if ((localPatchConfig != null) && (localPatchConfig.a(BaseApplicationImpl.sApplication, true))) {
      PatchSharedPreUtil.b(BaseApplicationImpl.sApplication, this.jdField_a_of_type_JavaLangString, localPatchConfig.b(), 0);
    }
    QFixApplicationImpl.a(BaseApplicationImpl.sApplication);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aikh
 * JD-Core Version:    0.7.0.1
 */