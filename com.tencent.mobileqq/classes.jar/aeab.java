import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aeab
  extends CardObserver
{
  public aeab(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    Object localObject2 = null;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onCardDownload() isSuccess = " + paramBoolean);
    }
    if ((this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if ((nwu.c(this.a.app, this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (bjxa.b(this.a.app, this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
    {
      nwu.a(this.a, null, this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false, -1, true, -1);
      this.a.finish();
    }
    boolean bool2 = ProfileActivity.AllInOne.g(this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    boolean bool1 = bool2;
    if (this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) {
      if (!TextUtils.isEmpty(this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
      {
        bool1 = bool2;
        if (!this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0")) {}
      }
      else
      {
        bool1 = false;
      }
    }
    Object localObject1;
    if (((paramObject instanceof Card)) && (bool1))
    {
      Card localCard = (Card)paramObject;
      bool2 = bhbx.a(this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, localCard.uin);
      bool1 = bool2;
      localObject1 = localObject2;
      paramObject = localCard;
      if ((localCard.lUserFlag & 1L) != 0L)
      {
        aslc.a(this.a.app).a(this.a.app, localCard.uin, false);
        paramObject = localCard;
        localObject1 = localObject2;
        bool1 = bool2;
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Bhie.a("initCardBySSOEnd", "initCardBySSOStart", false);
      if ((bool1) && (paramObject != null) && (paramBoolean))
      {
        localObject1 = (FriendListHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        if ((this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.e == null) && (localObject1 != null)) {
          if (ProfileActivity.AllInOne.g(this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
            ((FriendListHandler)localObject1).getCustomHead(this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          }
        }
        for (;;)
        {
          if (this.a.jdField_a_of_type_Bkys == null) {
            break label757;
          }
          localObject1 = this.a.jdField_a_of_type_Bkys.obtainMessage();
          ((Message)localObject1).what = 8;
          ((Message)localObject1).obj = paramObject;
          this.a.jdField_a_of_type_Bkys.sendMessage((Message)localObject1);
          return;
          if (((paramObject instanceof ContactCard)) && (!bool1))
          {
            localObject1 = (ContactCard)paramObject;
            bool1 = bhbx.a(((ContactCard)localObject1).mobileNo, this.a.a(FriendProfileCardActivity.a(this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)));
            this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = ((ContactCard)localObject1).mobileNo;
            paramObject = this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
            if ((paramObject != null) && (paramObject.jdField_a_of_type_JavaUtilArrayList != null) && (paramObject.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
              ((ProfileActivity.CardContactInfo)paramObject.jdField_a_of_type_JavaUtilArrayList.get(0)).c = ((ContactCard)localObject1).mobileNo;
            }
            paramObject = null;
            break;
          }
          if ((paramObject instanceof String))
          {
            paramObject = (String)paramObject;
            if (bool1) {}
            for (bool1 = bhbx.a(paramObject, this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);; bool1 = bhbx.a(paramObject, FriendProfileCardActivity.a(this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
            {
              paramObject = null;
              localObject1 = localObject2;
              break;
            }
          }
          if ((!(paramObject instanceof Card)) || (bool1)) {
            break label1213;
          }
          paramObject = (Card)paramObject;
          bool1 = bhbx.a(this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.o, paramObject.encId);
          this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = paramObject.uin;
          this.a.c = true;
          localObject1 = localObject2;
          break;
          if (localObject1 != null) {
            ((FriendListHandler)localObject1).getCustomHead(this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          }
        }
        label757:
        break;
      }
      if ((bool1) && (localObject1 != null) && (paramBoolean))
      {
        paramObject = (FriendListHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        if ((paramObject != null) && (!TextUtils.isEmpty(((ContactCard)localObject1).mobileNo))) {
          paramObject.getMobileQQHead(((ContactCard)localObject1).mobileNo);
        }
        this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b = ((ContactCard)localObject1).bindQQ;
        if (TextUtils.isEmpty(this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.k)) {
          this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.k = this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h;
        }
        if (!TextUtils.isEmpty(((ContactCard)localObject1).nickName)) {
          this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h = ((ContactCard)localObject1).nickName;
        }
        paramObject = (anvk)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (!TextUtils.isEmpty(((ContactCard)localObject1).uin))
        {
          paramObject = paramObject.a(((ContactCard)localObject1).uin);
          if (paramObject != null) {
            this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i = paramObject.remark;
          }
        }
        this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataContactCard = ((ContactCard)localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("ContactCard", 2, "contactCard .bindQQ = " + ((ContactCard)localObject1).bindQQ + " contactCard.uin  = " + ((ContactCard)localObject1).uin);
        }
        paramObject = Message.obtain();
        paramObject.what = 4;
        paramObject.obj = localObject1;
        paramObject.arg1 = 1;
        this.a.b.sendMessage(paramObject);
        return;
      }
      if ((paramBoolean) || (this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != -1L)) {
        break;
      }
      QLog.e("Q.profilecard.FrdProfileCard", 1, "onCardDownload isSuccess = " + paramBoolean + ",lCurrentStyleId=-1");
      this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId = azri.a;
      this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet = 0;
      if (this.a.jdField_a_of_type_Bkys == null) {
        break;
      }
      paramObject = this.a.jdField_a_of_type_Bkys.obtainMessage();
      paramObject.what = 8;
      paramObject.obj = this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard;
      this.a.jdField_a_of_type_Bkys.sendMessage(paramObject);
      return;
      label1213:
      bool1 = false;
      paramObject = null;
      localObject1 = localObject2;
    }
  }
  
  public void onGetDetailInfo(boolean paramBoolean, String paramString, Card paramCard)
  {
    simpleUpdate(paramBoolean, paramString, paramCard);
  }
  
  public void onGetLocationDescription(boolean paramBoolean, String paramString, Card paramCard)
  {
    if ((paramBoolean) && (paramCard != null) && (this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(paramCard.uin)) && (this.a.jdField_a_of_type_Bkys != null))
    {
      paramString = this.a.jdField_a_of_type_Bkys.obtainMessage();
      paramString.what = 8;
      paramString.obj = paramCard;
      this.a.jdField_a_of_type_Bkys.sendMessage(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeab
 * JD-Core Version:    0.7.0.1
 */