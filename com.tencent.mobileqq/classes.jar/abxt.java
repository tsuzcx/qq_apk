import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import com.tencent.mobileqq.activity.TroopInviteStatusFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class abxt
  extends ajuc
{
  public abxt(TroopInviteStatusFragment paramTroopInviteStatusFragment) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, ArrayList<String> paramArrayList, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopInviteStatusFragment", 2, "onGetGroupInviteStatus success:" + paramBoolean + " group_members_num:" + paramInt2 + " group_friends_num:" + paramInt3 + " friends_uins:" + paramArrayList + " status:" + paramInt4);
    }
    if (this.a.jdField_a_of_type_AndroidOsHandler != null) {
      this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    }
    if (this.a.jdField_a_of_type_Bbms != null) {
      this.a.jdField_a_of_type_Bbms.dismiss();
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
            azzx.a("Grp_AIO", "invite", "in_exp", 0, 0, new String[] { paramArrayList, String.valueOf(paramInt1) });
            TroopInviteStatusFragment.a(this.a);
            return;
          }
        }
      }
      switch (paramInt1)
      {
      default: 
        bbmy.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, ajjy.a(2131649679), 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight()).show();
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
        azzx.a("Grp_AIO", "invite", "in_past", 0, 0, new String[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abxt
 * JD-Core Version:    0.7.0.1
 */