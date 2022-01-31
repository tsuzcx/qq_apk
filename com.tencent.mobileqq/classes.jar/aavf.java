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
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.CoverCacheData;

public class aavf
  implements Handler.Callback
{
  public aavf(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject3 = (ajjj)this.a.app.getManager(51);
    Object localObject4;
    Object localObject1;
    switch (paramMessage.what)
    {
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    default: 
    case 1: 
    case 2: 
      for (;;)
      {
        return true;
        localObject4 = befb.a;
        if ((localObject4 != null) && (((befb)localObject4).a()))
        {
          ((befb)localObject4).b(4);
          ((befb)localObject4).a(5);
          ((befb)localObject4).a(8);
        }
        paramMessage = (String)paramMessage.obj;
        this.a.jdField_a_of_type_Baiv.a("initCardByDbStart", true);
        localObject1 = azyk.a(this.a.app, paramMessage);
        this.a.jdField_a_of_type_Baiv.a("initCardByDbEnd", "initCardByDbStart", false);
        if ((localObject1 != null) && (localObject3 != null))
        {
          if ((((ajjj)localObject3).b(((Card)localObject1).uin)) && (!this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.a.app.getCurrentAccountUin())) && (!ProfileActivity.AllInOne.b(this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
            this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 1;
          }
          this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard = ((Card)localObject1);
          if ((localObject4 != null) && (((befb)localObject4).a()))
          {
            ((befb)localObject4).b(5);
            ((befb)localObject4).a(6);
            ((befb)localObject4).a(9);
          }
          this.a.a((Card)localObject1, false, 1);
          this.a.jdField_a_of_type_Baiv.a("initCardBySSOStart", true);
          localObject3 = ((Card)localObject1).vSeed;
          paramMessage = null;
          if ((this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 56) || (this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 57))
          {
            paramMessage = this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_ArrayOfByte;
            this.a.a(((Card)localObject1).feedPreviewTime, (byte[])localObject3, paramMessage, false);
            FriendProfileCardActivity.e(this.a);
            if (!this.a.jdField_a_of_type_Atwx.jdField_b_of_type_Boolean) {
              continue;
            }
            paramMessage = this.a.app.getCurrentAccountUin();
            localObject3 = new StringBuilder().append("");
            if (this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
              break label618;
            }
            i = 1;
            localObject3 = i;
            localObject4 = new StringBuilder().append("");
            if (((Card)localObject1).lCurrentStyleId <= 0L) {
              break label623;
            }
          }
          for (int i = 2;; i = 1)
          {
            VasWebviewUtil.reportCommercialDrainage(paramMessage, "group_card", "show", "", 0, 0, 0, "", "", (String)localObject3, i, "", "", "", 0, 0, 0, 0);
            break;
            if ((this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 35) && (this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 37) && (this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 36)) {
              break label392;
            }
            paramMessage = this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_ArrayOfByte;
            break label392;
            i = 2;
            break label470;
          }
          localObject1 = this.a.a(FriendProfileCardActivity.a(this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
          if ((localObject3 != null) && (localObject1 != null) && (((String)localObject1).length() > 0))
          {
            paramMessage = befb.a;
            if ((paramMessage != null) && (paramMessage.a()))
            {
              paramMessage.b(4);
              paramMessage.a(8);
              paramMessage.a(5);
            }
            localObject1 = ((ajjj)localObject3).b((String)localObject1);
            localObject4 = FriendProfileCardActivity.a(this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
            if (localObject4 != null)
            {
              ((ContactCard)localObject1).nationCode = ((ProfileActivity.CardContactInfo)localObject4).b;
              ((ContactCard)localObject1).mobileCode = ((ProfileActivity.CardContactInfo)localObject4).c;
              ((ContactCard)localObject1).strContactName = ((ProfileActivity.CardContactInfo)localObject4).jdField_a_of_type_JavaLangString;
            }
            if ((((ContactCard)localObject1).nickName == null) || (((ContactCard)localObject1).nickName.length() == 0)) {
              ((ContactCard)localObject1).nickName = this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h;
            }
            ((ajjj)localObject3).a((ContactCard)localObject1);
            this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_Boolean = ((ContactCard)localObject1).bindQQ;
            if (!TextUtils.isEmpty(((ContactCard)localObject1).uin))
            {
              localObject3 = ((ajjj)localObject3).e(((ContactCard)localObject1).uin);
              if (localObject3 != null) {
                this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i = ((Friends)localObject3).remark;
              }
            }
            this.a.a((ContactCard)localObject1, false);
            FriendProfileCardActivity.b(this.a.jdField_a_of_type_Atwx);
            localObject3 = Message.obtain();
            ((Message)localObject3).what = 4;
            ((Message)localObject3).obj = localObject1;
            ((Message)localObject3).arg1 = 0;
            this.a.b.sendMessage((Message)localObject3);
            if ((paramMessage != null) && (paramMessage.a()))
            {
              paramMessage.b(5);
              paramMessage.a(6);
              paramMessage.a(9);
              paramMessage.a(7);
              paramMessage.b(7);
            }
            this.a.a(0L, null, null, false);
          }
        }
      }
    case 9: 
      label392:
      label470:
      label618:
      label623:
      localObject1 = (aufb)this.a.app.getManager(140);
      if (localObject1 != null)
      {
        paramMessage = ((aufb)localObject1).a(this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        if (paramMessage != null) {
          this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqQcallQCallCardInfo = paramMessage;
        }
        ((aufb)localObject1).a(paramMessage);
      }
      break;
    }
    for (;;)
    {
      for (;;)
      {
        localObject1 = Message.obtain();
        ((Message)localObject1).what = 6;
        ((Message)localObject1).obj = paramMessage;
        ((Message)localObject1).arg1 = 0;
        this.a.b.sendMessage((Message)localObject1);
        break;
        try
        {
          if ((paramMessage.arg1 == 0) && (this.a.jdField_a_of_type_Atwx != null) && (this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (!atxe.a(this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId))) {
            this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId = atxe.a;
          }
          if (paramMessage.arg2 == 1) {
            this.a.a(this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard, true, 13);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.e("FriendProfileCardActivity", 1, "handle SUBTHREAD_MSG_DOWNLOAD_RES fail.", localException);
          }
          this.a.a(this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard, false, 7);
        }
      }
      break;
      if ((paramMessage.obj instanceof Card))
      {
        this.a.a((Card)paramMessage.obj, true, 8);
        break;
      }
      this.a.a(this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard, true, 8);
      break;
      localObject3 = (CoverCacheData)paramMessage.obj;
      localObject4 = this.a.app.getEntityManagerFactory().createEntityManager();
      if (localObject4 == null)
      {
        paramMessage = null;
        label1274:
        localObject2 = paramMessage;
        if (paramMessage == null)
        {
          localObject2 = new QZoneCover();
          ((QZoneCover)localObject2).uin = Long.toString(((CoverCacheData)localObject3).a);
        }
        ((QZoneCover)localObject2).updateQzoneCover((CoverCacheData)localObject3);
        if (((QZoneCover)localObject2).getStatus() != 1000) {
          break label1353;
        }
        ((atmp)localObject4).a((atmo)localObject2);
      }
      for (;;)
      {
        ((atmp)localObject4).a();
        break;
        paramMessage = (QZoneCover)((atmp)localObject4).a(QZoneCover.class, Long.toString(((CoverCacheData)localObject3).a));
        break label1274;
        label1353:
        ((atmp)localObject4).a((atmo)localObject2);
      }
      if ((this.a.app == null) || (localObject3 == null)) {
        break;
      }
      paramMessage = ((ajjj)localObject3).b(this.a.app.getCurrentAccountUin());
      if (paramMessage == null) {
        break;
      }
      this.a.a(paramMessage.feedPreviewTime, paramMessage.vSeed, null, false);
      break;
      Object localObject2 = this.a.app.getEntityManagerFactory().createEntityManager();
      ((atmp)localObject2).a((Card)paramMessage.obj);
      ((atmp)localObject2).a();
      break;
      localObject2 = this.a.app.getEntityManagerFactory().createEntityManager();
      ((atmp)localObject2).a((Card)paramMessage.obj);
      ((atmp)localObject2).a();
      break;
      this.a.F();
      break;
      ((atwd)this.a.app.a(112)).a(this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 0);
      break;
      paramMessage = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aavf
 * JD-Core Version:    0.7.0.1
 */