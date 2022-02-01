import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import com.tencent.mobileqq.activity.TroopInviteStatusFragment;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class afdr
  extends aofu
{
  public afdr(TroopInviteStatusFragment paramTroopInviteStatusFragment) {}
  
  protected void onGetGroupInviteStatus(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, ArrayList<String> paramArrayList, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopInviteStatusFragment", 2, "onGetGroupInviteStatus success:" + paramBoolean + " group_members_num:" + paramInt2 + " group_friends_num:" + paramInt3 + " friends_uins:" + paramArrayList + " status:" + paramInt4);
    }
    if (this.a.jdField_a_of_type_AndroidOsHandler != null) {
      this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    }
    if (this.a.jdField_a_of_type_Bisl != null) {
      this.a.jdField_a_of_type_Bisl.dismiss();
    }
    if (paramBoolean) {}
    for (;;)
    {
      synchronized (this.a)
      {
        this.a.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
        this.a.jdField_b_of_type_Int = paramInt3;
        this.a.jdField_a_of_type_Int = paramInt2;
        this.a.jdField_c_of_type_Int = paramInt4;
        paramInt1 = paramInt4;
        if (paramInt4 == 5)
        {
          paramInt1 = paramInt4;
          if (this.a.jdField_b_of_type_Boolean)
          {
            paramInt1 = paramInt4;
            if (this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)
            {
              paramInt1 = paramInt4;
              if (!this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())
              {
                this.a.jdField_b_of_type_Boolean = false;
                this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_c_of_type_JavaLangRunnable, 1000L);
                paramInt1 = paramInt4;
              }
            }
          }
        }
        if (paramInt1 != 6) {
          if (this.a.jdField_a_of_type_Boolean)
          {
            paramArrayList = "1";
            bhbu.a("Grp_AIO", "invite", "in_exp", 0, 0, new String[] { paramArrayList, String.valueOf(paramInt1) });
            TroopInviteStatusFragment.a(this.a);
            return;
          }
        }
      }
      switch (paramInt1)
      {
      default: 
        QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, anvx.a(2131714833), 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight()).show();
        paramInt1 = paramInt4;
        break;
      case 1282: 
      case 1283: 
      case 1284: 
      case 1285: 
        synchronized (this.a)
        {
          this.a.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
          this.a.jdField_b_of_type_Int = paramInt3;
          this.a.jdField_a_of_type_Int = paramInt2;
          this.a.jdField_c_of_type_Int = 6;
          paramInt1 = 6;
        }
        paramArrayList = "2";
        continue;
        bhbu.a("Grp_AIO", "invite", "in_past", 0, 0, new String[0]);
      }
    }
  }
  
  public void onQueryJoinTroopWhetherHighRisk(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((this.a.jdField_a_of_type_Bisl != null) && (this.a.jdField_a_of_type_Bisl.isShowing())) {
      this.a.jdField_a_of_type_Bisl.dismiss();
    }
    if (!this.a.jdField_a_of_type_JavaLangString.equals(paramString)) {}
    do
    {
      return;
      if (!paramBoolean)
      {
        TroopRequestActivity.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_JavaLangString, null, this.a.jdField_a_of_type_Ajfr);
        return;
      }
      if (paramInt > 0)
      {
        ajgr.a(this.a.getActivity(), TroopInviteStatusFragment.a(this.a), new Object[0]);
        return;
      }
      TroopRequestActivity.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_JavaLangString, null, this.a.jdField_a_of_type_Ajfr);
    } while (this.a.jdField_a_of_type_Bisl == null);
    this.a.jdField_a_of_type_Bisl.c(2131718527);
    this.a.jdField_a_of_type_Bisl.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afdr
 * JD-Core Version:    0.7.0.1
 */