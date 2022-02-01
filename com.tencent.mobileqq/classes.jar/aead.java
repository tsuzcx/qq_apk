import android.os.Bundle;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.6.1;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.qphone.base.util.QLog;

public class aead
  extends anvi
{
  public aead(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_Azrb.a.jdField_a_of_type_JavaLangString != null))
    {
      paramString1 = (anvk)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((ProfileActivity.AllInOne.b(this.a.jdField_a_of_type_Azrb.a)) && (paramString1 != null))
      {
        paramString2 = paramString1.a(this.a.jdField_a_of_type_Azrb.a.jdField_a_of_type_JavaLangString);
        if (paramString2 != null)
        {
          paramString1 = "";
          if (paramString2.remark != null) {
            paramString1 = paramString2.remark;
          }
          this.a.a(paramString1);
        }
      }
    }
  }
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((!paramBoolean1) || (!paramBoolean2) || (!paramBoolean3)) {}
    do
    {
      return;
      paramBundle = paramBundle.getString("result_uin");
      if ((ProfileActivity.AllInOne.i(this.a.jdField_a_of_type_Azrb.a)) && (FriendProfileCardActivity.a(this.a.jdField_a_of_type_Azrb.a).equals(paramString)))
      {
        this.a.a(true, false, paramBundle);
        return;
      }
    } while ((paramBundle == null) || (this.a.jdField_a_of_type_Azrb.a == null) || (!paramBundle.equalsIgnoreCase(this.a.jdField_a_of_type_Azrb.a.jdField_a_of_type_JavaLangString)));
    this.a.a(false, false, null);
  }
  
  protected void onUpdateAnswerAddedFriend(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((!paramBoolean) || (paramString == null) || (paramString.length() == 0)) {}
    do
    {
      for (;;)
      {
        return;
        if (!ProfileActivity.AllInOne.i(this.a.jdField_a_of_type_Azrb.a)) {
          break;
        }
        Object localObject = (awyz)this.a.app.getManager(QQManagerFactory.CONTACT_MANAGER);
        if (localObject == null) {}
        for (localObject = null; (localObject != null) && (((PhoneContact)localObject).mobileNo != null) && (this.a.jdField_a_of_type_Azrb.a != null) && (((PhoneContact)localObject).mobileNo.equals(this.a.jdField_a_of_type_Azrb.a.jdField_a_of_type_JavaLangString)); localObject = ((awyz)localObject).a(paramString))
        {
          this.a.a(true, false, paramString);
          return;
        }
      }
    } while ((paramString == null) || (this.a.jdField_a_of_type_Azrb.a == null) || (!paramString.equals(this.a.jdField_a_of_type_Azrb.a.jdField_a_of_type_JavaLangString)));
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateAddFriend, uin: " + paramString);
    }
    this.a.a(false, false, null);
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString.equals(this.a.jdField_a_of_type_Azrb.a.jdField_a_of_type_JavaLangString)) && (this.a.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.a(this.a.jdField_a_of_type_Azrb.a);
    }
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_Azrb.a.jdField_a_of_type_JavaLangString.equals(String.valueOf(paramObject))))
    {
      this.a.a(2131691434, 2);
      this.a.finish();
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "onUpdateFriendList " + paramBoolean1 + ", " + paramBoolean2);
    }
    Object localObject2;
    if ((paramBoolean1) && (paramBoolean2) && (this.a.jdField_a_of_type_Azrb.a.jdField_a_of_type_JavaLangString != null))
    {
      localObject2 = (anvk)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (!ProfileActivity.AllInOne.b(this.a.jdField_a_of_type_Azrb.a)) {
        break label156;
      }
      if (localObject2 != null)
      {
        localObject2 = ((anvk)localObject2).a(this.a.jdField_a_of_type_Azrb.a.jdField_a_of_type_JavaLangString);
        if (localObject2 != null)
        {
          localObject1 = "";
          if (((Friends)localObject2).remark != null) {
            localObject1 = ((Friends)localObject2).remark;
          }
          this.a.a((String)localObject1);
        }
      }
    }
    label156:
    do
    {
      for (;;)
      {
        return;
        if (!ProfileActivity.AllInOne.i(this.a.jdField_a_of_type_Azrb.a)) {
          break;
        }
        if (this.a.jdField_a_of_type_Azrb.a.jdField_a_of_type_Int == 53)
        {
          this.a.a(0L, null, null, false);
          return;
        }
        awyz localawyz = (awyz)this.a.app.getManager(QQManagerFactory.CONTACT_MANAGER);
        if (localawyz == null) {}
        while ((localObject2 != null) && (localObject1 != null) && (((anvk)localObject2).b(((PhoneContact)localObject1).uin)))
        {
          this.a.a(true, false, ((PhoneContact)localObject1).uin);
          return;
          localObject1 = localawyz.c(FriendProfileCardActivity.a(this.a.jdField_a_of_type_Azrb.a));
        }
      }
    } while ((localObject2 == null) || (!((anvk)localObject2).b(this.a.jdField_a_of_type_Azrb.a.jdField_a_of_type_JavaLangString)) || (this.a.jdField_a_of_type_Azrb.a.jdField_a_of_type_JavaLangString.equals(this.a.app.getCurrentAccountUin())));
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateFriendList, cardInfo.allinone.uin: " + this.a.jdField_a_of_type_Azrb.a.jdField_a_of_type_JavaLangString);
    }
    ThreadManager.excute(new FriendProfileCardActivity.6.1(this), 16, null, false);
  }
  
  protected void onUpdateMobileQQHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "onUpdateMobileQQHead() mobileNumber = " + paramString);
    }
    if ((!paramBoolean) || (this.a.jdField_a_of_type_Azrb.a == null)) {}
    String str;
    do
    {
      return;
      str = FriendProfileCardActivity.a(this.a.jdField_a_of_type_Azrb.a);
    } while ((str == null) || (!str.equals(paramString)) || (this.a.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView == null));
    this.a.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.a(this.a.jdField_a_of_type_Azrb.a, 1, str, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aead
 * JD-Core Version:    0.7.0.1
 */