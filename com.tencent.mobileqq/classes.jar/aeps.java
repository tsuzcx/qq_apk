import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

public class aeps
  implements Handler.Callback
{
  public aeps(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject2 = (anyw)this.a.app.getManager(51);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, "SUBTHREAD_MSG_INIT_CARD");
      }
      paramMessage = (String)paramMessage.obj;
      this.a.jdField_a_of_type_Bhsx.a("initCardByDbStart", true);
      Object localObject1 = bhhz.a(this.a.app, paramMessage);
      this.a.jdField_a_of_type_Bhsx.a("initCardByDbEnd", "initCardByDbStart", false);
      if ((localObject1 != null) && (localObject2 != null))
      {
        if ((((anyw)localObject2).b(((Card)localObject1).uin)) && (!this.a.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.a.app.getCurrentAccountUin())) && (!ProfileActivity.AllInOne.b(this.a.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
          this.a.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 1;
        }
        this.a.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard = ((Card)localObject1);
        this.a.a((Card)localObject1, false, 1);
        this.a.jdField_a_of_type_Bhsx.a("initCardBySSOStart", true);
        localObject2 = ((Card)localObject1).vSeed;
        paramMessage = null;
        label304:
        label375:
        StringBuilder localStringBuilder;
        if ((this.a.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 56) || (this.a.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 57))
        {
          paramMessage = this.a.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_ArrayOfByte;
          this.a.a(((Card)localObject1).feedPreviewTime, (byte[])localObject2, paramMessage, false);
          if (!this.a.jdField_a_of_type_Azxr.jdField_b_of_type_Boolean) {
            continue;
          }
          paramMessage = this.a.app.getCurrentAccountUin();
          localObject2 = new StringBuilder().append("");
          if (this.a.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
            break label523;
          }
          i = 1;
          localObject2 = i;
          localStringBuilder = new StringBuilder().append("");
          if (((Card)localObject1).lCurrentStyleId <= 0L) {
            break label528;
          }
        }
        label523:
        label528:
        for (int i = 2;; i = 1)
        {
          VasWebviewUtil.reportCommercialDrainage(paramMessage, "group_card", "show", "", 0, 0, 0, "", "", (String)localObject2, i, "", "", "", 0, 0, 0, 0);
          break;
          if ((this.a.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 35) && (this.a.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 37) && (this.a.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 36)) {
            break label304;
          }
          paramMessage = this.a.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_ArrayOfByte;
          break label304;
          i = 2;
          break label375;
        }
        paramMessage = this.a.a(FriendProfileCardActivity.a(this.a.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
        if ((localObject2 != null) && (paramMessage != null) && (paramMessage.length() > 0))
        {
          paramMessage = ((anyw)localObject2).b(paramMessage);
          localObject1 = FriendProfileCardActivity.a(this.a.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          if (localObject1 != null)
          {
            paramMessage.nationCode = ((ProfileActivity.CardContactInfo)localObject1).b;
            paramMessage.mobileCode = ((ProfileActivity.CardContactInfo)localObject1).c;
            paramMessage.strContactName = ((ProfileActivity.CardContactInfo)localObject1).jdField_a_of_type_JavaLangString;
          }
          if ((paramMessage.nickName == null) || (paramMessage.nickName.length() == 0)) {
            paramMessage.nickName = this.a.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h;
          }
          ((anyw)localObject2).a(paramMessage);
          this.a.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_Boolean = paramMessage.bindQQ;
          if (!TextUtils.isEmpty(paramMessage.uin))
          {
            localObject1 = ((anyw)localObject2).e(paramMessage.uin);
            if (localObject1 != null) {
              this.a.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i = ((Friends)localObject1).remark;
            }
          }
          this.a.a(paramMessage, false);
          FriendProfileCardActivity.a(this.a.jdField_a_of_type_Azxr);
          localObject1 = Message.obtain();
          ((Message)localObject1).what = 4;
          ((Message)localObject1).obj = paramMessage;
          ((Message)localObject1).arg1 = 0;
          this.a.b.sendMessage((Message)localObject1);
          this.a.a(0L, null, null, false);
          continue;
          try
          {
            if ((paramMessage.arg1 == 0) && (this.a.jdField_a_of_type_Azxr != null) && (this.a.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (!azxy.a(this.a.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId))) {
              this.a.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId = azxy.a;
            }
            if (paramMessage.arg2 == 1) {
              this.a.a(this.a.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard, true, 13);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.e("FriendProfileCardActivity", 1, "handle SUBTHREAD_MSG_DOWNLOAD_RES fail.", localException);
            }
            this.a.a(this.a.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard, false, 7);
          }
          continue;
          if ((paramMessage.obj instanceof Card))
          {
            this.a.a((Card)paramMessage.obj, true, 8);
          }
          else
          {
            this.a.a(this.a.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard, true, 8);
            continue;
            if ((this.a.app != null) && (localObject2 != null))
            {
              paramMessage = ((anyw)localObject2).b(this.a.app.getCurrentAccountUin());
              if (paramMessage != null) {
                this.a.a(paramMessage.feedPreviewTime, paramMessage.vSeed, null, false);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeps
 * JD-Core Version:    0.7.0.1
 */