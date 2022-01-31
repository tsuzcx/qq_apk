import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.11.1;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.11.2;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;
import com.tencent.mobileqq.profile.view.ProfileBaseView;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class abdh
  extends ajto
{
  public abdh(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    Object localObject2 = null;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onCardDownload() isSuccess = " + paramBoolean);
    }
    if ((this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      return;
    }
    Object localObject1 = bfnm.a;
    if ((localObject1 != null) && (((bfnm)localObject1).a())) {
      ((bfnm)localObject1).b(6);
    }
    if ((naz.c(this.a.app, this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (bduf.b(this.a.app, this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
    {
      naz.a(this.a, null, this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false, -1, true, -1);
      this.a.finish();
    }
    boolean bool2 = ProfileActivity.AllInOne.g(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    boolean bool1 = bool2;
    if (this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) {
      if (!TextUtils.isEmpty(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
      {
        bool1 = bool2;
        if (!this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0")) {}
      }
      else
      {
        bool1 = false;
      }
    }
    if (((paramObject instanceof Card)) && (bool1))
    {
      Card localCard = (Card)paramObject;
      bool2 = bbbr.a(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, localCard.uin);
      bool1 = bool2;
      localObject1 = localObject2;
      paramObject = localCard;
      if ((localCard.lUserFlag & 1L) != 0L)
      {
        aoej.a(this.a.app).a(this.a.app, localCard.uin, false);
        paramObject = localCard;
        localObject1 = localObject2;
        bool1 = bool2;
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Bbkq.a("initCardBySSOEnd", "initCardBySSOStart", false);
      if ((bool1) && (paramObject != null) && (paramBoolean))
      {
        localObject1 = (FriendListHandler)this.a.app.a(1);
        if ((this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString == null) && (localObject1 != null))
        {
          if (ProfileActivity.AllInOne.g(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
            ((FriendListHandler)localObject1).c(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          }
          label454:
          if (this.a.jdField_a_of_type_Bfob != null)
          {
            localObject1 = this.a.jdField_a_of_type_Bfob.obtainMessage();
            ((Message)localObject1).what = 8;
            ((Message)localObject1).obj = paramObject;
            this.a.jdField_a_of_type_Bfob.sendMessage((Message)localObject1);
          }
        }
      }
      for (;;)
      {
        this.a.b.removeMessages(100);
        this.a.b.sendEmptyMessageDelayed(100, 100L);
        return;
        if (((paramObject instanceof ContactCard)) && (!bool1))
        {
          localObject1 = (ContactCard)paramObject;
          bool1 = bbbr.a(((ContactCard)localObject1).mobileNo, this.a.a(FriendProfileCardActivity.a(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)));
          this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = ((ContactCard)localObject1).mobileNo;
          paramObject = this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
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
          for (bool1 = bbbr.a(paramObject, this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);; bool1 = bbbr.a(paramObject, FriendProfileCardActivity.a(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
          {
            paramObject = null;
            localObject1 = localObject2;
            break;
          }
        }
        if ((!(paramObject instanceof Card)) || (bool1)) {
          break label1265;
        }
        paramObject = (Card)paramObject;
        bool1 = bbbr.a(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.o, paramObject.encId);
        this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = paramObject.uin;
        this.a.jdField_e_of_type_Boolean = true;
        localObject1 = localObject2;
        break;
        if (localObject1 == null) {
          break label454;
        }
        ((FriendListHandler)localObject1).c(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        break label454;
        if ((bool1) && (localObject1 != null) && (paramBoolean))
        {
          paramObject = (FriendListHandler)this.a.app.a(1);
          if ((paramObject != null) && (!TextUtils.isEmpty(((ContactCard)localObject1).mobileNo))) {
            paramObject.e(((ContactCard)localObject1).mobileNo);
          }
          this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b = ((ContactCard)localObject1).bindQQ;
          if (TextUtils.isEmpty(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.k)) {
            this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.k = this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h;
          }
          if (!TextUtils.isEmpty(((ContactCard)localObject1).nickName)) {
            this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h = ((ContactCard)localObject1).nickName;
          }
          paramObject = (ajxl)this.a.app.getManager(51);
          if (!TextUtils.isEmpty(((ContactCard)localObject1).uin))
          {
            paramObject = paramObject.a(((ContactCard)localObject1).uin);
            if (paramObject != null) {
              this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i = paramObject.remark;
            }
          }
          this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqDataContactCard = ((ContactCard)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("ContactCard", 2, "contactCard .bindQQ = " + ((ContactCard)localObject1).bindQQ + " contactCard.uin  = " + ((ContactCard)localObject1).uin);
          }
          paramObject = Message.obtain();
          paramObject.what = 4;
          paramObject.obj = localObject1;
          paramObject.arg1 = 1;
          this.a.b.sendMessage(paramObject);
        }
        else if ((!paramBoolean) && (this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == -1L))
        {
          QLog.e("Q.profilecard.FrdProfileCard", 1, "onCardDownload isSuccess = " + paramBoolean + ",lCurrentStyleId=-1");
          this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId = auvf.a;
          this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet = 0;
          if (this.a.jdField_a_of_type_Bfob != null)
          {
            paramObject = this.a.jdField_a_of_type_Bfob.obtainMessage();
            paramObject.what = 8;
            paramObject.obj = this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqDataCard;
            this.a.jdField_a_of_type_Bfob.sendMessage(paramObject);
          }
        }
      }
      label1265:
      bool1 = false;
      paramObject = null;
      localObject1 = localObject2;
    }
  }
  
  protected void onDelQZonePhotoWall(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.a(ajya.a(2131704920), 2);
    }
    for (;;)
    {
      ((ajti)this.a.app.a(2)).a(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, "");
      return;
      this.a.a(ajya.a(2131704909), 1);
    }
  }
  
  protected void onGetDetailInfo(boolean paramBoolean, String paramString, Card paramCard)
  {
    simpleUpdate(paramBoolean, paramString, paramCard);
  }
  
  protected void onGetLocationDescription(boolean paramBoolean, String paramString, Card paramCard)
  {
    if ((paramBoolean) && (paramCard != null) && (this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(paramCard.uin)) && (this.a.jdField_a_of_type_Bfob != null))
    {
      paramString = this.a.jdField_a_of_type_Bfob.obtainMessage();
      paramString.what = 8;
      paramString.obj = paramCard;
      this.a.jdField_a_of_type_Bfob.sendMessage(paramString);
    }
  }
  
  protected void onGetQZonePhotoWall(boolean paramBoolean, String paramString1, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp, String paramString2)
  {
    this.a.d(false);
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "onGetQZonePhotoWall isSuc:" + paramBoolean + " uin:" + paramString2);
    }
    if (this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(paramString2))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(paramBoolean, paramString2, parammobile_sub_get_photo_wall_rsp);
      }
      if (this.a.jdField_a_of_type_Bcny != null) {
        this.a.jdField_a_of_type_Bcny.a(paramBoolean, paramString1, parammobile_sub_get_photo_wall_rsp);
      }
    }
  }
  
  protected void onGetShoppingInfo(boolean paramBoolean, String paramString, List<auvr> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "shopName=" + paramString + ",accountFlag=" + paramInt1 + "follow_type=" + paramInt2 + ",certifiedGrade:" + paramInt3);
    }
    if (paramBoolean)
    {
      this.a.f = paramInt1;
      this.a.g = paramInt2;
      this.a.d = paramString;
      if (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(paramString, paramInt3, paramList);
        if (paramList.size() != 0) {
          this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.setShoppingBgBlur(true);
        }
      }
    }
  }
  
  protected void onGotGroupInfo(boolean paramBoolean, String paramString, Card paramCard)
  {
    simpleUpdate(paramBoolean, paramString, paramCard);
  }
  
  protected void onLabelLikeSet(boolean paramBoolean, Card paramCard, long paramLong)
  {
    super.onLabelLikeSet(paramBoolean, paramCard, paramLong);
    if (QLog.isColorLevel()) {
      QLog.d("zivzhou", 2, "set the status of label = " + paramBoolean);
    }
  }
  
  protected void onMedalChange(boolean paramBoolean, Card paramCard)
  {
    Locale localLocale;
    Object localObject1;
    Object localObject2;
    if (QLog.isDevelopLevel())
    {
      localLocale = Locale.getDefault();
      if (paramCard != null) {
        break label146;
      }
      localObject1 = "null";
      if (paramCard != null) {
        break label157;
      }
      localObject2 = "null";
      label28:
      if (paramCard != null) {
        break label169;
      }
    }
    label146:
    label157:
    label169:
    for (Object localObject3 = "null";; localObject3 = Integer.valueOf(paramCard.iUpgradeCount))
    {
      QLog.i("MedalWallMng", 4, String.format(localLocale, "onMedalChange isSuc: %s, iMedalCount: %s, iNewCount: %s, iUpgradeCount:%s", new Object[] { Boolean.valueOf(paramBoolean), localObject1, localObject2, localObject3 }));
      if ((paramCard != null) && (this.a.jdField_a_of_type_Auuy != null) && (this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (bbbr.a(paramCard.uin, this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqDataCard.uin)))
      {
        this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqDataCard = paramCard;
        this.a.c();
      }
      return;
      localObject1 = Integer.valueOf(paramCard.iMedalCount);
      break;
      localObject2 = Integer.valueOf(paramCard.iNewCount);
      break label28;
    }
  }
  
  protected void onReqFavoriteResult(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)) || (bbbr.a(paramString2, paramString1))) {}
    do
    {
      do
      {
        return;
      } while ((!bbbr.a(paramString2, this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (!bbbr.a(paramString1, this.a.app.getCurrentAccountUin())));
      if (!paramBoolean) {
        break;
      }
      if ((paramInt2 == 1) && (this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqDataCard != null))
      {
        paramString1 = this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqDataCard;
        paramString1.lVoteCount += paramInt1;
        this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqDataCard.bVoted = 1;
        paramString1 = this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqDataCard;
        paramString1.bAvailVoteCnt = ((short)(paramString1.bAvailVoteCnt - paramInt1));
        if (this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt < 0) {
          this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt = 0;
        }
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null);
    this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.a.jdField_a_of_type_Auuy, -1L, false);
    return;
    bbkv.a(new FriendProfileCardActivity.11.1(this));
  }
  
  protected void onUpdateAvatar(boolean paramBoolean, String paramString)
  {
    if (!this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(paramString)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateAvatar " + paramBoolean);
      }
      if (!paramBoolean) {
        this.a.a(2131718725, 1);
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null);
    this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
  }
  
  protected void onUploadQZonePhotoWall(boolean paramBoolean, Object paramObject)
  {
    if (this.a.jdField_a_of_type_Abgw != null) {
      this.a.jdField_a_of_type_Abgw.c();
    }
    if (paramBoolean) {
      this.a.a(ajya.a(2131704903), 0);
    }
    ajti localajti;
    for (;;)
    {
      localajti = (ajti)this.a.app.a(2);
      if (paramBoolean) {
        break;
      }
      paramObject = (String)((Object[])(Object[])paramObject)[0];
      this.a.runOnUiThread(new FriendProfileCardActivity.11.2(this, localajti, paramObject));
      return;
      this.a.a(ajya.a(2131704929), 1);
    }
    localajti.a(this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, "");
  }
  
  protected void reqShoppingInfo(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    if (this.a.jdField_a_of_type_Auuy == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, "shoppingNo=" + paramString1 + "seq=" + paramInt);
          }
        } while ((!paramBoolean) || (!this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(paramString2)));
        if (!"0".equals(paramString1)) {
          break;
        }
        paramString1 = this.a.getSharedPreferences("is_binding_shop", 0).edit();
        paramString1.putBoolean(this.a.jdField_e_of_type_JavaLangString, false);
        paramString1.commit();
      } while ((this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != auvf.h));
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_Auvf = null;
      this.a.jdField_a_of_type_Auuy.jdField_a_of_type_Auvf = null;
      this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileBaseView(this.a, this.a.jdField_a_of_type_Auuy, this.a.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView, this.a.jdField_a_of_type_AndroidWidgetTextView, FriendProfileCardActivity.a(this.a));
      this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView, 0L, 0L);
    } while (this.a.isFinishing());
    this.a.u();
    this.a.b(true);
    return;
    paramString2 = ProfileShoppingPhotoInfo.getPhotoInfo(this.a.app, this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    if (paramString2 != null)
    {
      this.a.g = paramString2.followType;
      this.a.c = paramString2.bindShoppingNo;
    }
    paramString2 = (ajti)this.a.app.a(2);
    if (paramString2 != null)
    {
      this.a.c = paramString1;
      paramString2.a(paramInt, paramString1, this.a.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    }
    paramString1 = this.a.getSharedPreferences("is_binding_shop", 0).edit();
    paramString1.putBoolean(this.a.jdField_e_of_type_JavaLangString, true);
    paramString1.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abdh
 * JD-Core Version:    0.7.0.1
 */