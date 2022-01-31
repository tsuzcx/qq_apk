import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.14.1;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.14.2;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetOnlineInfoResp;

public class abdm
  extends ajxj
{
  public abdm(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (this.a.jdField_a_of_type_Auuy != null) && (TextUtils.equals(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramString))) {
      this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.c(this.a.jdField_a_of_type_Auuy);
    }
  }
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString != null))
    {
      paramString1 = (ajxl)this.a.app.getManager(51);
      if ((ProfileActivity.AllInOne.b(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (paramString1 != null))
      {
        paramString2 = paramString1.a(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        if (paramString2 != null)
        {
          paramString1 = "";
          if (paramString2.remark != null) {
            paramString1 = paramString2.remark;
          }
          this.a.b(paramString1);
        }
      }
    }
  }
  
  protected void onSetSelfSignatureResult(boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.a.app.getCurrentAccountUin()))
    {
      ExtensionInfo localExtensionInfo = ((ajxl)this.a.app.getManager(51)).a(this.a.app.getCurrentAccountUin());
      if (localExtensionInfo != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setNewSignature(localExtensionInfo.richBuffer, localExtensionInfo.richTime);
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
      if ((ProfileActivity.AllInOne.i(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (FriendProfileCardActivity.a(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne).equals(paramString)))
      {
        this.a.a(true, false, paramBundle);
        return;
      }
    } while ((paramBundle == null) || (this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (!paramBundle.equalsIgnoreCase(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)));
    ThreadManager.excute(new FriendProfileCardActivity.14.2(this), 16, null, true);
  }
  
  protected void onUpdateAnswerAddedFriend(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((!paramBoolean) || (paramString == null) || (paramString.length() == 0)) {}
    do
    {
      for (;;)
      {
        return;
        if (!ProfileActivity.AllInOne.i(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
          break;
        }
        Object localObject = (askn)this.a.app.getManager(11);
        if (localObject == null) {}
        for (localObject = null; (localObject != null) && (((PhoneContact)localObject).mobileNo != null) && (this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (((PhoneContact)localObject).mobileNo.equals(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)); localObject = ((askn)localObject).a(paramString))
        {
          this.a.a(true, false, paramString);
          return;
        }
      }
    } while ((paramString == null) || (this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (!paramString.equals(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)));
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateAddFriend, uin: " + paramString);
    }
    this.a.a(false, false, null);
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString.equals(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    }
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(String.valueOf(paramObject))))
    {
      this.a.a(2131691489, 2);
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
    if ((paramBoolean1) && (paramBoolean2) && (this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString != null))
    {
      localObject2 = (ajxl)this.a.app.getManager(51);
      if (!ProfileActivity.AllInOne.b(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        break label155;
      }
      if (localObject2 != null)
      {
        localObject2 = ((ajxl)localObject2).a(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        if (localObject2 != null)
        {
          localObject1 = "";
          if (((Friends)localObject2).remark != null) {
            localObject1 = ((Friends)localObject2).remark;
          }
          this.a.b((String)localObject1);
        }
      }
    }
    label155:
    do
    {
      for (;;)
      {
        return;
        if (!ProfileActivity.AllInOne.i(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
          break;
        }
        if (this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53)
        {
          this.a.a(0L, null, null, false);
          return;
        }
        askn localaskn = (askn)this.a.app.getManager(11);
        if (localaskn == null) {}
        while ((localObject2 != null) && (localObject1 != null) && (((ajxl)localObject2).b(((PhoneContact)localObject1).uin)))
        {
          this.a.a(true, false, ((PhoneContact)localObject1).uin);
          return;
          localObject1 = localaskn.c(FriendProfileCardActivity.a(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
        }
      }
    } while ((localObject2 == null) || (!((ajxl)localObject2).b(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.a.app.getCurrentAccountUin())));
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateFriendList, cardInfo.allinone.uin: " + this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    }
    ThreadManager.excute(new FriendProfileCardActivity.14.1(this), 16, null, false);
  }
  
  protected void onUpdateMobileQQHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "onUpdateMobileQQHead() mobileNumber = " + paramString);
    }
    if ((!paramBoolean) || (this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null)) {}
    String str;
    do
    {
      return;
      str = FriendProfileCardActivity.a(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    } while ((str == null) || (!str.equals(paramString)) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null));
    this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, 1, str, false);
  }
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.c(this.a.jdField_a_of_type_Auuy);
    }
  }
  
  protected void onUpdateSignature(boolean paramBoolean, String[] paramArrayOfString)
  {
    int j;
    int i;
    if ((paramBoolean) && (paramArrayOfString != null))
    {
      j = paramArrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        if ((paramArrayOfString[i] == null) || (!paramArrayOfString[i].equals(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
          break label126;
        }
        paramArrayOfString = ((ajxl)this.a.app.getManager(51)).a(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        if (paramArrayOfString != null)
        {
          this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramArrayOfString.getRichStatus();
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.a.jdField_a_of_type_Auuy, true, new String[] { "map_key_sig" });
        }
      }
      return;
      label126:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abdm
 * JD-Core Version:    0.7.0.1
 */