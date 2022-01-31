import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class aglm
  extends bfvh
{
  aglm(agld paramagld) {}
  
  protected void d(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_Aelz.notifyDataSetChanged();
      QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.a().getString(2131698539), 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.a().getString(2131698538), 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  protected void e(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if ((paramBoolean) && (paramHashMap != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (paramHashMap.containsKey("external")) && (paramHashMap.get("external") != null))
    {
      paramHashMap = (QidianExternalInfo)paramHashMap.get("external");
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (paramHashMap != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramHashMap.uin)))
      {
        paramHashMap = this.a.b.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (paramHashMap != null)
        {
          agld.a(this.a, true);
          this.a.f.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          agld.a(this.a).setOnClickListener(null);
          agld.b(this.a).setOnClickListener(null);
          this.a.h = paramHashMap;
          this.a.a(paramHashMap);
          if (acew.S) {
            this.a.f.setContentDescription(paramHashMap);
          }
          agld.a(this.a, true);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
        agld.b(this.a, false);
        return;
      } while (!QLog.isColorLevel());
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onGetQidianUserDetailInfo not current curFriendUin");
      return;
    }
    QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onGetQidianUserDetailInfo fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aglm
 * JD-Core Version:    0.7.0.1
 */