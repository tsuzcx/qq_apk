import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mobileqq.activity.TroopInviteStatusFragment;
import com.tencent.qphone.base.util.QLog;

public class acia
  extends akat
{
  public acia(TroopInviteStatusFragment paramTroopInviteStatusFragment) {}
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopInviteStatusFragment", 2, "onSendSystemMsgActionError logStr:" + paramString);
    }
    if ((this.a.jdField_a_of_type_Bcqf != null) && (this.a.jdField_a_of_type_Bcqf.isShowing()))
    {
      this.a.jdField_a_of_type_Bcqf.dismiss();
      paramString = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131720004);
      bcql.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, paramString, 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight()).show();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    if ((this.a.jdField_a_of_type_Bcqf != null) && (this.a.jdField_a_of_type_Bcqf.isShowing())) {
      this.a.jdField_a_of_type_Bcqf.dismiss();
    }
    if (!paramBoolean)
    {
      paramString1 = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131719262);
      if (TextUtils.isEmpty(paramString3)) {
        break label175;
      }
    }
    for (;;)
    {
      bcql.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, paramString3, 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      return;
      paramString1 = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131692782);
      bcql.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, paramString1, 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      this.a.c = -1;
      TroopInviteStatusFragment.a(this.a);
      this.a.jdField_b_of_type_Boolean = true;
      this.a.jdField_a_of_type_AndroidOsHandler.post(this.a.jdField_b_of_type_JavaLangRunnable);
      return;
      label175:
      paramString3 = paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acia
 * JD-Core Version:    0.7.0.1
 */