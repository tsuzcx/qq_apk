import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.qphone.base.util.QLog;

public class aaub
  extends ajuc
{
  public aaub(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  protected void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("onTroopRankTitleUpdate, troopUin: %s, memberUin: %s, titleId: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) }));
    }
    if ((this.a.jdField_a_of_type_Atwx == null) || (!this.a.jdField_a_of_type_Atwx.jdField_b_of_type_Boolean) || (this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard == null) || (this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      do
      {
        return;
      } while ((!paramString1.equals(this.a.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString)) || (!paramString2.equals(this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)));
      this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.titleId = paramInt;
    } while (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null);
    this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.f(this.a.jdField_a_of_type_Atwx);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "onGetGolbalTroopLevel isSuccess = " + paramBoolean + ", uin = " + paramLong + ", level = " + paramInt);
    }
    if (this.a.jdField_a_of_type_Atwx == null) {}
    do
    {
      do
      {
        return;
      } while ((TroopInfo.isQidianPrivateTroop(this.a.app, this.a.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString)) || (!paramBoolean) || (paramLong != Long.parseLong(this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)));
      this.a.jdField_a_of_type_Atwx.jdField_b_of_type_Int = paramInt;
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView == null) || (this.a.jdField_a_of_type_Atwx == null) || (this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null));
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.a.jdField_a_of_type_Atwx, true, new String[] { "map_key_troop_mem_charm_level" });
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    try
    {
      if (this.a.isFinishing())
      {
        QLog.d("FriendProfileCardActivity", 1, "onGetTroopMemberCard return because is finished!");
        return;
      }
      if ((this.a.jdField_a_of_type_Begr != null) && (this.a.jdField_a_of_type_Begr.isShowing())) {
        this.a.jdField_a_of_type_Begr.dismiss();
      }
      if (QLog.isColorLevel()) {
        QLog.i("FriendProfileCardActivity", 2, "onGetTroopMemberCard: isSuccess " + paramBoolean);
      }
      if (paramBoolean)
      {
        paramObject = (Object[])paramObject;
        l = ((Long)paramObject[0]).longValue();
        ((Integer)paramObject[1]).intValue();
        paramObject = (TroopMemberCard)paramObject[2];
        if (l != Long.parseLong(this.a.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString))
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("FriendProfileCardActivity", 2, "onGetTroopMemberCard: troopUin != mTroopUin, " + l + "!=" + this.a.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString);
        }
      }
    }
    catch (Exception paramObject)
    {
      long l;
      if (QLog.isColorLevel())
      {
        QLog.i("FriendProfileCardActivity", 2, "onGetTroopMemberCard:" + paramObject.toString());
        return;
        if (paramObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("FriendProfileCardActivity", 2, "onGetTroopMemberCard: cardInfo==null");
          }
        }
        else
        {
          l = paramObject.memberUin;
          if (l != Long.parseLong(this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.uin))
          {
            if (QLog.isColorLevel()) {
              QLog.i("FriendProfileCardActivity", 2, "onGetTroopMemberCard: memberUin != mMemberUin, " + l + "!=" + this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
            }
          }
          else if ((this.a.jdField_a_of_type_Atwx == null) || (this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null))
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendProfileCardActivity", 2, "onGetTroopMemberCard: cardInfo == null || cardInfo.card == null || cardInfo.allinone == null");
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.i("FriendProfileCardActivity", 2, "updateParams: uint32_result:" + paramObject.result + " memberRole:" + paramObject.memberRole);
            }
            this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard = paramObject;
            this.a.jdField_a_of_type_Atwx.c = true;
            if ((paramObject.result == 260) && (paramObject.memberRole == 0))
            {
              bbmy.a(this.a, 1, ajjy.a(2131639117), 0).a();
              this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard = paramObject;
              if (!TroopInfo.isQidianPrivateTroop(this.a.app, this.a.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString))
              {
                this.a.jdField_a_of_type_Atwx.jdField_b_of_type_Boolean = false;
                this.a.a(this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard, false);
                return;
              }
              this.a.jdField_a_of_type_Atwx.c = false;
              this.a.c.setVisibility(8);
              return;
            }
            this.a.g();
            if (paramObject.titleId == 0)
            {
              Object localObject = (TroopManager)this.a.app.getManager(52);
              if (localObject != null)
              {
                localObject = ((TroopManager)localObject).b(this.a.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
                if (localObject != null)
                {
                  paramObject.titleId = ((TroopMemberInfo)localObject).level;
                  if (QLog.isColorLevel()) {
                    QLog.d("FriendProfileCardActivity", 2, "onGetTroopMemberCard: server realLevel==0, useLocal=" + paramObject.titleId);
                  }
                }
              }
            }
            this.a.a(this.a.jdField_a_of_type_Atwx, true);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaub
 * JD-Core Version:    0.7.0.1
 */