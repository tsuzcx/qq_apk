import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.QQPermissionCallback;

public class adfh
  implements QQPermissionCallback
{
  public adfh(JumpActivity paramJumpActivity, boolean paramBoolean) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("JumpAction", 1, "system share.doShare denied sd grant");
    bdgm.a(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity, new adfi(this));
    paramArrayOfString = new HashMap();
    azri.a(BaseApplication.getContext()).a("", "noSDPermissionShareDeny", true, 0L, 0L, paramArrayOfString, "");
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("JumpAction", 1, "system share.doShare user grant");
    JumpActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity, this.jdField_a_of_type_Boolean);
    paramArrayOfString = new HashMap();
    azri.a(BaseApplication.getContext()).a("", "noSDPermissionShareGrant", true, 0L, 0L, paramArrayOfString, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adfh
 * JD-Core Version:    0.7.0.1
 */