import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class aetv
  extends bdvm
{
  aetv(aetq paramaetq) {}
  
  protected void d(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_Acup.notifyDataSetChanged();
      bcql.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.a().getString(2131698249), 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      return;
    }
    bcql.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.a().getString(2131698248), 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  protected void e(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if (((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1025) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024)) && (paramBoolean) && (paramHashMap != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (paramHashMap.containsKey("external")) && (paramHashMap.get("external") != null))
    {
      paramHashMap = (QidianExternalInfo)paramHashMap.get("external");
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (paramHashMap != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramHashMap.uin)))
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = 1025;
        }
        paramHashMap = this.a.jdField_a_of_type_Bduf.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (paramHashMap != null)
        {
          aetq.a(this.a, true);
          this.a.f.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          aetq.a(this.a).setOnClickListener(null);
          aetq.b(this.a).setOnClickListener(null);
          this.a.f.setText(paramHashMap);
          if (aany.S) {
            this.a.f.setContentDescription(paramHashMap);
          }
          aetq.a(this.a, true);
          this.a.m();
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        for (;;)
        {
          return;
          aetq.b(this.a, false);
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onGetQidianUserDetailInfo not current curFriendUin");
      return;
    }
    QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onGetQidianUserDetailInfo fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aetv
 * JD-Core Version:    0.7.0.1
 */