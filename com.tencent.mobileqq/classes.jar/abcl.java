import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;

public class abcl
  implements Runnable
{
  public abcl(ArkLocalAppMgr paramArkLocalAppMgr, abcp paramabcp, abcw paramabcw) {}
  
  public void run()
  {
    this.jdField_a_of_type_Abcp.a = NetworkUtil.g(BaseApplication.getContext());
    ArkLocalAppMgr localArkLocalAppMgr = (ArkLocalAppMgr)ArkLocalAppMgr.a(this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr).get();
    if (localArkLocalAppMgr != null) {
      ArkLocalAppMgr.a(localArkLocalAppMgr).post(new abcm(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abcl
 * JD-Core Version:    0.7.0.1
 */