import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class agrf
  extends alkl
{
  public agrf(TroopChatPie paramTroopChatPie) {}
  
  protected void a(bcjo parambcjo)
  {
    if ((parambcjo.jdField_a_of_type_Int == 2) && (parambcjo.jdField_a_of_type_Bcjr != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("troop_gag", 2, "onTroopGagStatusChange:" + parambcjo.jdField_a_of_type_JavaLangString);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(parambcjo.jdField_a_of_type_JavaLangString)) {
        this.a.a(parambcjo.jdField_a_of_type_Bcjr, true);
      }
    }
  }
  
  protected void a(Object paramObject)
  {
    if (this.a.jdField_a_of_type_Aelz != null) {
      this.a.jdField_a_of_type_Aelz.notifyDataSetChanged();
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {
      break label7;
    }
    for (;;)
    {
      label7:
      return;
      if (paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        TroopManager localTroopManager = (TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        TroopInfo localTroopInfo = localTroopManager.c(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (localTroopInfo == null) {
          break;
        }
        if (!paramBoolean) {
          if (!TextUtils.isEmpty(paramString3)) {
            QQToast.a(BaseApplicationImpl.getContext(), 1, paramString3, 0).a();
          }
        }
        while ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString1)) && (localTroopInfo != null))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = localTroopInfo.getTroopName();
          paramString1 = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
          paramString1.putExtra("uinname", localTroopInfo.getTroopName());
          this.a.b(paramString1);
          return;
          localTroopInfo.troopname = paramString2;
          localTroopInfo.hasSetNewTroopName = true;
          if ((this.a.v()) && (localTroopInfo.isNewTroop) && (localTroopInfo.hasSetNewTroopName) && (localTroopInfo.hasSetNewTroopHead))
          {
            localTroopInfo.isNewTroop = false;
            bclo.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTroopInfo, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, new agrg(this));
          }
          localTroopManager.b(localTroopInfo);
          this.a.bH();
        }
      }
    }
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()) {
      return;
    }
    if (paramBoolean1)
    {
      if (paramBoolean2) {}
      for (String str = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131696674);; str = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131696583))
      {
        QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), 2, str, 1).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
        return;
      }
    }
    QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), 1, 2131696673, 1).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agrf
 * JD-Core Version:    0.7.0.1
 */