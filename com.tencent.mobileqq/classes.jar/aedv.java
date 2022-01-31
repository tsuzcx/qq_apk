import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class aedv
  extends ajjh
{
  aedv(aedo paramaedo) {}
  
  protected void onReqRecheckInHotReactive(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    this.a.jdField_a_of_type_Asci.a(paramBoolean, paramString1, paramString2, paramInt);
  }
  
  protected void onSetAsNormalContacts(boolean paramBoolean, List<String> paramList)
  {
    if ((paramBoolean) && (aedo.a(this.a) != null))
    {
      if ((aedo.a(this.a).a()) && (!aedo.a(this.a).b()))
      {
        aedo.a(this.a).b(1);
        aedo.a(this.a).a(2);
      }
      return;
    }
    bbmy.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131653486), 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  protected void onSetAsUncommonlyUsedContacts(boolean paramBoolean, List<String> paramList)
  {
    if ((paramBoolean) && (aedo.a(this.a) != null)) {
      aedo.a(this.a).b(2);
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    super.onUpdateFriendInfo(paramString, paramBoolean);
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (paramString.contains(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onUpdateHotFriendLevel");
      }
      this.a.E();
    }
  }
  
  protected void onUpdateHotFriendLevel(boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    super.onUpdateHotFriendLevel(paramBoolean, paramArrayList);
    if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.contains(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onUpdateHotFriendLevel");
      }
      this.a.E();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aedv
 * JD-Core Version:    0.7.0.1
 */