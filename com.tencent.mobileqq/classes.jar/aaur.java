import QQService.PrivilegeInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.32.1;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.32.2;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.32.5;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.activity.contacts.utils.ContactReportUtils;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.TroopMemberCard.MemberGameInfo;
import com.tencent.mobileqq.extendfriend.ExtendFriendPublicFragmentActivity;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment.ExtendFriendInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.multicard.RecommendPerson;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelBoard;
import com.tencent.mobileqq.profile.view.ProfileBaseView;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.profile.view.ProfileShoppingView;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.PhotoWallView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.util.Pair;
import common.config.service.QzoneConfig;
import cooperation.troop.TroopBaseProxyActivity;
import cooperation.troop.TroopMemberCardProxyActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class aaur
  implements View.OnClickListener
{
  long a;
  
  public aaur(FriendProfileCardActivity paramFriendProfileCardActivity)
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      break label4;
    }
    label4:
    int j;
    Object localObject2;
    long l;
    label721:
    do
    {
      do
      {
        return;
      } while (!(paramView.getTag() instanceof atuw));
      j = ajve.b(ajve.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.c()));
      localObject2 = (atuw)paramView.getTag();
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "onClickListener and DataTag type=" + ((atuw)localObject2).jdField_a_of_type_Int);
      }
      l = System.currentTimeMillis();
      if ((((atuw)localObject2).jdField_a_of_type_Int != 10) && (Math.abs(l - this.jdField_a_of_type_Long) < 1000L)) {
        break;
      }
      this.jdField_a_of_type_Long = l;
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.e) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a(((atuw)localObject2).jdField_a_of_type_Int))) {
        break;
      }
      switch (((atuw)localObject2).jdField_a_of_type_Int)
      {
      case 2: 
      case 9: 
      case 11: 
      case 12: 
      case 14: 
      case 15: 
      case 18: 
      case 19: 
      case 21: 
      case 22: 
      case 25: 
      case 27: 
      case 28: 
      case 30: 
      case 31: 
      case 33: 
      case 35: 
      case 36: 
      case 37: 
      case 38: 
      case 39: 
      case 40: 
      case 42: 
      case 43: 
      case 46: 
      case 48: 
      case 49: 
      case 50: 
      case 51: 
      case 52: 
      case 53: 
      case 54: 
      case 55: 
      case 56: 
      case 58: 
      case 60: 
      case 63: 
      case 64: 
      case 66: 
      case 67: 
      case 70: 
      case 71: 
      case 72: 
      case 74: 
      case 75: 
      case 76: 
      case 82: 
      case 84: 
      case 89: 
      case 91: 
      default: 
        return;
      case 1: 
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          break label1235;
        }
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, AvatarPendantActivity.class);
        paramView.putExtra("AllInOne", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity(paramView);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
        {
          paramView = (View)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_avatar_pendant");
          l = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_Long;
          if ((ProfileActivity.AllInOne.g(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (paramView != null) && (paramView.getVisibility() == 0) && (l != 0L)) {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "AvatarClick", "ZhurenInfoHeadClick", 0, 0, "", "", "", "");
          }
        }
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8004173", "0X8004173", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          break label2044;
        }
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A77", "0X8006A77", 0, 0, "", "", "", "");
        return;
      }
    } while ((!ProfileActivity.AllInOne.g(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 80) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.e();
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X8007EC1", "0X8007EC1", 0, 0, "", "", "", "");
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.e == 0) {}
      for (paramView = "0";; paramView = "1")
      {
        VasWebviewUtil.reportCommercialDrainage((String)localObject1, "defaultcard", "click_mydefaultcard", "", 1, 0, 0, "", paramView, "");
        label971:
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          break;
        }
        i = 1;
        label997:
        awqx.b(paramView, "dc00898", "", "", "0X800A889", "0X800A889", i, 0, "", "", "", "");
        return;
      }
    }
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, CardPicGalleryActivity.class);
    Object localObject1 = new ArrayList();
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.b)) {
      paramView.putExtra("extra_default", 2130844815);
    }
    ((ArrayList)localObject1).add(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.b);
    paramView.putExtra("extra_mode", 2);
    paramView.putStringArrayListExtra("business_card_pics", (ArrayList)localObject1);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.e == 0) {}
    for (int i = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.defaultCardId;; i = 0)
    {
      paramView.putExtra("default_card_id", i);
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity(paramView);
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.overridePendingTransition(2130772286, 0);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A97", "0X8006A97", 0, 0, "", "", "", "");
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin(), "defaultcard", "click_othersdefaultcard", "", 1, 0, 0, "", Integer.toString(i), "");
      break label971;
      i = 2;
      break label997;
      label1235:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 80)) {
        break;
      }
      if (!ProfileActivity.AllInOne.g(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        paramView = FriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        if (((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53) && (!this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_Boolean)) || (paramView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null)) {
          break label721;
        }
        localObject1 = (View)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_face");
        if (localObject1 == null) {
          break label721;
        }
        azyk.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, (View)localObject1, paramView);
        break label721;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) {
        break label721;
      }
      paramView = (View)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_face");
      if (paramView == null)
      {
        paramView = null;
        label1424:
        localObject1 = (View)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_avatar_pendant");
        l = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_Long;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (!ProfileActivity.AllInOne.g(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (localObject1 == null) || (paramView == null) || (((View)localObject1).getVisibility() != 0) || (l == 0L)) {
          break label1836;
        }
        i = 0;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 1) {
          break label1647;
        }
        i = 1;
      }
      for (;;)
      {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "AvatarClick", "KerenInfoHeadClick", i, 0, "", "", "", "");
        if (!(paramView instanceof DynamicAvatarView)) {
          break;
        }
        localObject1 = (DynamicAvatarView)paramView;
        if (((DynamicAvatarView)localObject1).a == null) {
          break;
        }
        localObject1 = ((DynamicAvatarView)localObject1).a;
        if ((!((azvw)localObject1).jdField_a_of_type_Boolean) || (((azvw)localObject1).jdField_a_of_type_ComTencentImageURLDrawable == null) || (TextUtils.isEmpty(((azvw)localObject1).c))) {
          break label1787;
        }
        azyk.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, paramView, ((azvw)localObject1).c);
        break;
        paramView = ((AvatarLayout)paramView).a(0);
        break label1424;
        label1647:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 20) {
          i = 2;
        } else if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21) {
          i = 3;
        } else if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 45) {
          i = 4;
        } else if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46) {
          i = 5;
        } else if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) {
          i = 6;
        } else if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 42) {
          i = 7;
        }
      }
      label1787:
      localObject1 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getAccount(), 1);
      azyk.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, l, i, (ProfileActivity.AllInOne)localObject1);
      break label721;
      label1836:
      if ((paramView == null) || (!(paramView instanceof DynamicAvatarView))) {
        break label721;
      }
      localObject1 = (DynamicAvatarView)paramView;
      if (((DynamicAvatarView)localObject1).a == null) {
        break label721;
      }
      localObject1 = ((DynamicAvatarView)localObject1).a;
      if ((((azvw)localObject1).jdField_a_of_type_Boolean) && (((azvw)localObject1).jdField_a_of_type_ComTencentImageURLDrawable != null) && (!TextUtils.isEmpty(((azvw)localObject1).c)))
      {
        azyk.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, paramView, ((azvw)localObject1).c);
        break label721;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0")))
      {
        azyk.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.p, false, false, null);
        break label721;
      }
      localObject1 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getAccount(), 1);
      azyk.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false, false, (ProfileActivity.AllInOne)localObject1);
      break label721;
      label2044:
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A8B", "0X8006A8B", 0, 0, "", "", "", "");
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo = ((ProfileActivity.CardContactInfo)((atuw)localObject2).jdField_a_of_type_JavaLangObject);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt = new int[5];
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[0] = 7;
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[1] = 8;
      if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[2] = 9;
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[3] = 16;
      }
      for (;;)
      {
        i = 4;
        while (i < 5)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[i] = -1;
          i += 1;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[2] = 16;
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[3] = -1;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt, ((atuw)localObject2).jdField_a_of_type_Int);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8005AFD", "0X8005AFD", 0, 0, "", "", "", "");
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.q();
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "P_prof", "Prof_new_photo", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.r();
      ThreadManager.post(new FriendProfileCardActivity.32.1(this), 8, null, true);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "P_prof", "Pp_clk_qzone", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A7C", "0X8006A7C", 0, 0, "", "", "", "");
      }
      while (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_b_of_type_Boolean)
      {
        new awrb(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app).a("dc00899").b("Grp_mem_card").c("page").d("zone_clk").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString }).a();
        return;
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A90", "0X8006A90", 0, 0, "", "", "", "");
      }
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.presentCustourl);
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity(paramView);
      ThreadManager.getFileThreadHandler().post(new FriendProfileCardActivity.32.2(this));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
      {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "", "", "", "0X800A1C7", "0X800A1C7", 0, 0, "", "", "", "");
        return;
      }
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "", "", "", "0X800A1C9", "0X800A1C9", 0, 0, "", "", "", "");
      return;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      paramView = new Date(System.currentTimeMillis());
      localObject2 = new SimpleDateFormat("yyyyMMdd").format(paramView);
      Object localObject3 = QzoneConfig.getInstance().getConfig("H5Url", "give_gift_button_in_profile_url", "https://h5.qzone.qq.com/giftv2/vuemall?_wv=131075&_fv=0&_wwv=128&from=card&friends={to_uin}");
      paramView = null;
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        paramView = ((String)localObject3).replace("{to_uin}", (String)localObject1 + "_" + (String)localObject2);
      }
      localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", paramView);
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity((Intent)localObject1);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "", "", "", "0X800A1C5", "0X800A1C5", 0, 0, "", "", "", "");
      return;
      if (QSecFramework.a().a(1001).booleanValue()) {
        QSecFramework.a().a(5, 0, 2, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(6), "addfriend", null }, null);
      }
      FriendProfileCardActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "P_prof", "Pp_add_frd", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), Integer.toString(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.k), "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 119) {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc01160", "", "", "0X800A410", "0X800A410", 0, 0, "", "", "", "");
      }
      if (azzz.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X8008274", "0X8008274", 0, 0, "", "", "", "");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 82) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 81) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 83) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 101) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 103) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 102) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 107) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 110))
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getIntent().getBundleExtra("profile_extres");
        if (localObject3 != null) {
          i = 0;
        }
      }
      switch (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
      {
      default: 
        label3396:
        paramView = ((Bundle)localObject3).getString("recommend_entry_type", "");
        localObject1 = ((Bundle)localObject3).getString("recommend_reason", "");
        j = ((Bundle)localObject3).getInt("key_display_type", 0);
        int k = ((Bundle)localObject3).getInt("recommend_pos", 0);
        localObject2 = ((Bundle)localObject3).getByteArray("recommend_algh_id");
        localObject3 = ((Bundle)localObject3).getString("recommend_label", "");
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, "frd_list_add", i, 2, (String)localObject1, k, (byte[])localObject2, (String)localObject3, j, paramView);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null))
        {
          if (87 == this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int) {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006F0D", "0X8006F0D", 0, 0, "", "", "", "");
          }
        }
        else {
          label3573:
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.j != 1) {
              break label4148;
            }
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8007162", "0X8007162", 0, 0, "", "", "", "");
          }
        }
        break;
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_b_of_type_Boolean) {
          new awrb(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app).a("dc00899").b("Grp_mem_card").c("page").d("addfri_clk").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString }).a();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 122) {
          break;
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_AndroidOsBundle;
        if (paramView == null) {
          break;
        }
        i = paramView.getInt("key_troop_recommend_position", 0);
        paramView = (RecommendPerson)paramView.getSerializable("key_troop_recommend_person");
        arxf.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, i, 2, paramView);
        return;
        i = 21;
        break label3396;
        i = 23;
        break label3396;
        i = 3;
        break label3396;
        i = 24;
        break label3396;
        i = 20;
        break label3396;
        i = 25;
        break label3396;
        i = 28;
        break label3396;
        i = ((Bundle)localObject3).getInt("tabID", 0);
        break label3396;
        if ((101 == this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int) || (102 == this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int) || (103 == this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int))
        {
          if (((aroh)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getManager(11)).h()) {}
          for (paramView = "0X80077D4";; paramView = "0X80077CE")
          {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", paramView, paramView, 0, 0, "", "", "", "");
            if (101 != this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int) {
              break label3997;
            }
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", paramView, paramView, 1, 0, "", "", "", "");
            break;
          }
          label3997:
          if (102 == this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int)
          {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", paramView, paramView, 2, 0, "", "", "", "");
            break label3573;
          }
          if (103 != this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int) {
            break label3573;
          }
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", paramView, paramView, 3, 0, "", "", "", "");
          break label3573;
        }
        if (104 != this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int) {
          break label3573;
        }
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X80077D1", "0X80077D1", 0, 0, "", "", "", "");
        break label3573;
        label4148:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.j == 2) {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8007163", "0X8007163", 0, 0, "", "", "", "");
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.p();
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "P_prof", "Pp_send_msg", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), Integer.toString(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.k), "", "");
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_b_of_type_Boolean) {
        break;
      }
      new awrb(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app).a("dc00899").b("Grp_mem_card").c("page").d("msg_clk").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString }).a();
      return;
      awqx.b(null, "dc00898", "", "", "qq_vip", "0X8009E3B", 2, 0, "", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_b_of_type_Boolean) {
        VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin(), "group_card", "click_cardbt", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      }
      localObject1 = paramView.findViewById(2131312776);
      localObject3 = paramView.getParent();
      paramView = (View)localObject1;
      if ((localObject3 instanceof View)) {
        paramView = ((View)localObject3).findViewById(2131312776);
      }
      i = 1;
      if (paramView != null) {
        if (paramView.getVisibility() != 0) {
          break label4758;
        }
      }
      label4758:
      for (i = 0;; i = 1)
      {
        paramView.setVisibility(8);
        FriendProfileCardActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity);
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.j();
        paramView = "";
        if (((atuw)localObject2).jdField_a_of_type_Int == 92) {
          paramView = "profileType=custom";
        }
        azyk.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin(), "inside.myCardButton", i, 3, 1, paramView, true);
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "card_mall", "0X8006681", 0, 0, "", "", "", "");
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X8007EB5", "0X8007EB5", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_b_of_type_Boolean) {
          VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin(), "group_card", "click_cardbt", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != atxe.j) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != atxe.i)) {
          break;
        }
        VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clkcard_owner", "0", 1, 0, 0, mpl.a(), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId));
        return;
      }
      j = ((Integer)((atuw)localObject2).jdField_a_of_type_JavaLangObject).intValue();
      if ((j == 101107) || (j == 101108))
      {
        if (j != 101108) {
          break label4936;
        }
        i = 5;
        if (j != 101108) {
          break label4941;
        }
        bajr.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, 3, azyk.a(i));
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_b_of_type_Boolean) {
          VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin(), "group_card", "guide_click", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        }
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "P_CliOper", "Vip_SummaryCard", "", "SummaryCard", "CLICK_TOPBARVIPINVALID", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        label4936:
        i = 2;
        break;
        label4941:
        bajr.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, 3, azyk.a(i));
      }
      if ((((atuw)localObject2).jdField_a_of_type_JavaLangObject instanceof Card))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a((Card)((atuw)localObject2).jdField_a_of_type_JavaLangObject);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a(null);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.o();
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "P_prof", "Pp_clk_myQR", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.e(false);
      if (FriendProfileCardActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity)) {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X80081C1", "0X80081C1", 0, 0, "", "", "", "");
      }
      new awrb(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app).a("dc00899").b("Grp_mem_card").c("page").d("edit_clk").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString }).a();
      return;
      Groups localGroups;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_b_of_type_Boolean)
      {
        new awrb(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app).a("dc00899").b("Grp_mem_card").c("page").d("more_clk").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString }).a();
        localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getManager(52);
        localObject3 = ((TroopManager)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString);
        if (localObject3 == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a((TroopInfo)localObject3);
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("troopUin", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("memberUin", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
        ((Intent)localObject1).putExtra("fromFlag", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_Int);
        ((Intent)localObject1).putExtra("troopMemberCard", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard);
        ((Intent)localObject1).putExtra("troopCode", ((TroopInfo)localObject3).troopcode);
        ((Intent)localObject1).putExtra("troopName", ((TroopInfo)localObject3).getTroopName());
        ((Intent)localObject1).putExtra("hwCard", ((TroopManager)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.uin));
        ((Intent)localObject1).putExtra("qidian_private_troop", TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) {
          break;
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString = babh.h(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        }
        ((Intent)localObject1).putExtra("AllInOne", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        ((Intent)localObject1).putExtra("detailProfileUrl", azyk.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity));
        ((Intent)localObject1).putExtra("qidianshowUin", bcpn.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        localObject2 = (ajjj)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getManager(51);
        boolean bool2 = ((ajjj)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("isFriend", bool2);
        ((Intent)localObject1).putExtra("isQidianMaster", ((bcpn)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getManager(165)).f(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        localObject3 = ((ajjj)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        if (localObject3 != null)
        {
          ((Intent)localObject1).putExtra("specialFlag", ((Friends)localObject3).cSpecialFlag);
          if (((Friends)localObject3).isFriend())
          {
            ((Intent)localObject1).putExtra("key_remark", ((Friends)localObject3).remark);
            ((Intent)localObject1).putExtra("key_group_id", ((Friends)localObject3).groupid);
            ((Intent)localObject1).putExtra("key_current_nick", babh.j(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin()));
            localGroups = ((ajjj)localObject2).a(String.valueOf(((Friends)localObject3).groupid));
            if (localGroups != null) {
              break label6522;
            }
            ((Intent)localObject1).putExtra("key_group_name", "");
            label5865:
            ((Intent)localObject1).putExtra("key_not_disturb", FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app));
            ((Intent)localObject1).putExtra("key_is_shield", ((ajjj)localObject2).e(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
            ((Intent)localObject1).putExtra("key_type_gather", ((Friends)localObject3).gathtertype);
            ((Intent)localObject1).putExtra("key_is_has_interaction", asax.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, true));
            localObject2 = ((ajjj)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            if ((localObject2 == null) || (((SpecialCareInfo)localObject2).globalSwitch == 0)) {
              break label6539;
            }
            bool1 = true;
            label6007:
            ((Intent)localObject1).putExtra("key_is_specialcare", bool1);
          }
        }
        ((Intent)localObject1).putExtra("businessCard", alqg.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx));
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_Azuc != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_Azuc.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_Azuc.jdField_a_of_type_JavaUtilList.size() > 0)) {
          ((Intent)localObject1).putExtra("SHARE_NICK_NAME", ((azub)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_Azuc.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.addSrcName))) {
          ((Intent)localObject1).putExtra("cur_add_source", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.addSrcName);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
          ((Intent)localObject1).putExtra("key_nick_name", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.strNick);
        }
        if ((paramView instanceof TextView))
        {
          paramView = ((TextView)paramView).getText().toString();
          if (!TextUtils.isEmpty(paramView)) {
            ((Intent)localObject1).putExtra("title", paramView);
          }
        }
        if (bool2)
        {
          ((Intent)localObject1).putExtra("friend_intimate_open", asca.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.c()));
          ((Intent)localObject1).putExtra("friend_intimate_bind_url", asca.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
          i = 0;
          paramView = "";
          localObject2 = asax.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, true);
          if (localObject2 == null) {
            break label12980;
          }
          if (((asbx)localObject2).jdField_a_of_type_Long != 1L) {
            break label6545;
          }
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getString(2131627967);
          label6393:
          i = ((asbx)localObject2).c;
        }
      }
      for (boolean bool1 = ((asbx)localObject2).c();; bool1 = false)
      {
        ((Intent)localObject1).putExtra("friend_intimate_bind_name", paramView);
        ((Intent)localObject1).putExtra("friend_intimate_isExtinguish", bool1);
        ((Intent)localObject1).putExtra("friend_intimate_bind_res_icon", i);
        ((Intent)localObject1).putExtra("isMsgShielded", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.e());
        ((Intent)localObject1).putExtra("isGather", FriendProfileCardActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity));
        paramView = TroopBaseProxyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity);
        TroopMemberCardProxyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "troop_member_card_plugin.apk", ajjy.a(2131639101), TroopMemberCardProxyActivity.class, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, (Intent)localObject1, paramView, "com.tencent.mobileqq.memcard.plugin.TroopMemberCardMoreInfoActivity", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin(), 8);
        return;
        label6522:
        ((Intent)localObject1).putExtra("key_group_name", localGroups.group_name);
        break label5865;
        label6539:
        bool1 = false;
        break label6007;
        label6545:
        if (((asbx)localObject2).jdField_a_of_type_Long == 2L)
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getString(2131627965);
          break label6393;
        }
        if (((asbx)localObject2).jdField_a_of_type_Long != 3L) {
          break label6393;
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getString(2131627966);
        break label6393;
        FriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt = new int[5];
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[0] = 31;
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[1] = 32;
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[2] = 16;
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[3] = -1;
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[4] = -1;
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt, ((atuw)localObject2).jdField_a_of_type_Int);
        j = 2;
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.b != null)
        {
          i = j;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.b.a()) {
            i = 1;
          }
        }
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X800A97C", "0X800A97C", i, 0, "0", "0", "", "");
        return;
        azyk.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
          bajo.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, 0, "signature_ziliaoka");
        }
        while (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
        {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A79", "0X8006A79", 0, 0, "", "", "", "");
          return;
          paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, PublicFragmentActivity.class);
          paramView.putExtra("key_uin", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          paramView.putExtra("key_uin_name", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_Azuc.jdField_a_of_type_Azub.jdField_a_of_type_JavaLangString);
          paramView.putExtra("key_open_via", "history-kerentaiziliaoka");
          abju.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, paramView, PublicFragmentActivity.class, SignatureHistoryFragment.class);
        }
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A8D", "0X8006A8D", 0, 0, "", "", "", "");
        return;
        localObject1 = (Pair)((atuw)localObject2).jdField_a_of_type_JavaLangObject;
        avgf.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, avgf.a(((Integer)((Pair)localObject1).first).intValue(), (String)((Pair)localObject1).second), -1);
        paramView.setVisibility(8);
        atxr.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app);
        awqx.b(null, "dc00898", "", "", "0X800A4D5", "0X800A4D5", 0, 0, "1", "0", "", "");
        return;
        paramView = new int[5];
        localObject1 = mjj.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity);
        ((mjj)localObject1).a(2131624041);
        ((mjj)localObject1).b(2131654456);
        paramView[0] = 1;
        paramView[1] = 2;
        ((mjj)localObject1).b(2131654477);
        ((mjj)localObject1).c(2131625035);
        ((mjj)localObject1).a(new aaus(this));
        ((mjj)localObject1).a(new aaut(this, paramView, (mjj)localObject1));
        ((mjj)localObject1).show();
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8008404", "0X8008404", 0, 0, "", "", "", "");
        return;
        paramView = new FriendProfileCardActivity.32.5(this);
        localObject1 = new aauu(this);
        localObject1 = new DenyRunnable(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, (afxz)localObject1);
        amnv.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, paramView, (Runnable)localObject1);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.j == 2)
        {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8007164", "0X8007164", 0, 0, "", "", "", "");
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.j != 3) {
          break;
        }
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8007165", "0X8007165", 0, 0, "", "", "", "");
        return;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.privilegeJumpUrl;
        paramView = (View)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
            break label7563;
          }
        }
        label7563:
        for (paramView = "https://mc.vip.qq.com/privilegelist/index";; paramView = "https://mc.vip.qq.com/privilegelist/other?friend=" + this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)
        {
          localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", paramView);
          ((Intent)localObject1).putExtra("hide_operation_bar", true);
          ((Intent)localObject1).putExtra("hide_more_button", true);
          ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity((Intent)localObject1);
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "P_CliOper", "Pb_account_lifeservice", "", "ziliaoka_qqtequan", "tab-click", 0, 1, 0, "", "", "", "");
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
            break;
          }
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A7B", "0X8006A7B", 0, 0, "", "", "", "");
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "qvip", "0X800A12F", 0, 0, "", "", "", "");
          return;
        }
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A8F", "0X8006A8F", 0, 0, "", "", "", "");
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "qvip", "0X800A137", 0, 0, String.valueOf(j), "", "", "");
        return;
        if (!(((atuw)localObject2).jdField_a_of_type_JavaLangObject instanceof atxm)) {
          break;
        }
        paramView = (atxm)((atuw)localObject2).jdField_a_of_type_JavaLangObject;
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, QQBrowserActivity.class);
        if (paramView.jdField_a_of_type_Int == 2) {
          ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_qqmusic");
        }
        for (;;)
        {
          ((Intent)localObject1).putExtra("url", paramView.b);
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity((Intent)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("remilelei", 2, "hobby go to :" + paramView.b);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.f(paramView.jdField_a_of_type_Int);
          return;
          if (paramView.jdField_a_of_type_Int == 4) {
            ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_feeds_buluo");
          }
        }
        if (!(((atuw)localObject2).jdField_a_of_type_JavaLangObject instanceof atxn)) {
          break;
        }
        paramView = (atxn)((atuw)localObject2).jdField_a_of_type_JavaLangObject;
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, QQBrowserActivity.class);
        switch (paramView.jdField_a_of_type_Int)
        {
        }
        for (;;)
        {
          ((Intent)localObject1).putExtra("url", paramView.c);
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity((Intent)localObject1);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("remilelei", 2, "hobby go to :" + paramView.c);
          return;
          if (paramView.b == 0)
          {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X80070B2", "0X80070B2", 0, 0, "", "", "", "");
          }
          else
          {
            ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_feeds_buluo");
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X80070AE", "0X80070AE", 0, 0, "", "", "", "");
            continue;
            ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_qqmusic");
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X80070AA", "0X80070AA", 0, 0, "", "", "", "");
          }
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView))) {
          break;
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(paramView))
        {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "card_mall", "0X8004435", 0, 0, Long.toString(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId), "", "", bajr.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin()));
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == atxe.j) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == atxe.i)) {
            VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clkbkgd_owner", "0", 1, 0, 0, mpl.a(), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId));
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_b_of_type_Boolean)
          {
            paramView = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin();
            localObject1 = new StringBuilder().append("");
            if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
              break label8407;
            }
          }
          label8407:
          for (i = 1;; i = 2)
          {
            VasWebviewUtil.reportCommercialDrainage(paramView, "group_card", "click_cover", "", 0, 0, 0, "", "", i, "", "", "", "", 0, 0, 0, 0);
            azyk.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin(), "inside.myCardBackground", 1, 0, 1, "", true);
            return;
          }
        }
        if ((((atuw)localObject2).jdField_a_of_type_JavaLangObject instanceof String)) {}
        for (paramView = (String)((atuw)localObject2).jdField_a_of_type_JavaLangObject;; paramView = "CLICK_HEADER_BG")
        {
          if ("CLICK_HEADER_BG".equals(paramView))
          {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "card_mall", "0X80047F1", 0, 0, "1", "", "", bajr.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin()));
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == atxe.j) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == atxe.i)) {
              VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clkbkgd_visitor", "0", 1, 0, 0, mpl.a(), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId));
            }
          }
          for (;;)
          {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "card_mall", "0X80047F0", 0, 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), Long.toString(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId), "", bajr.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin()));
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Begr != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Begr.isShowing())) {
              break;
            }
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getString(2131651484);
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "", "0X800A4C0", 0, 0, "", "", "", "");
            localObject1 = begr.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity);
            ((begr)localObject1).a(2131651679, 1);
            ((begr)localObject1).a((CharSequence)localObject2, 1);
            ((begr)localObject1).a(2131625035, 1);
            ((begr)localObject1).a(new aauv(this, paramView, (begr)localObject1));
            try
            {
              ((begr)localObject1).show();
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Begr = ((begr)localObject1);
              return;
              if ("CLICK_BANNER".equals(paramView)) {
                awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "card_mall", "0X80047F1", 0, 0, "2", "", "", bajr.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin()));
              }
            }
            catch (Exception paramView)
            {
              for (;;)
              {
                paramView.printStackTrace();
              }
            }
          }
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "card_mall", "0X80066C6", 0, 0, "2", "", "", "");
          paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, ProfileLabelEditorActivity.class);
          paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivityForResult(paramView, 1004);
            return;
          }
          catch (Exception paramView)
          {
            paramView.printStackTrace();
            return;
          }
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "card_mall", "0X80066C6", 0, 0, "1", "", "", "");
          paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, ProfileLabelEditorActivity.class);
          paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivityForResult(paramView, 1004);
            return;
          }
          catch (Exception paramView)
          {
            paramView.printStackTrace();
            return;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard == null)) {
            break;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "card_mall", "0X8007A48", 0, 0, "0", "", "", "");
          }
          for (;;)
          {
            azyk.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.strActiveUrl);
            return;
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "card_mall", "0X8007A48", 0, 0, "1", "", "", "");
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.c == null) {
            break;
          }
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "P_CliOper", "Shop_lifeservice", "", "Shop_Ftemplateinto", "0X8005B97", 0, 0, "", "", "", "");
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.i == 1)
          {
            paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, ChatActivity.class);
            if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.c))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.w("FriendProfileCardActivity", 2, "onItemClick - uin = null");
              return;
            }
            paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.c);
            paramView.putExtra("uintype", 1008);
            paramView.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.d);
            paramView.putExtra("selfSet_leftViewText", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getString(2131629842));
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity(paramView);
            return;
          }
          paramView = null;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
          {
            paramView = new Intent();
            paramView.putExtra("report_src_param_type", "gouwu_follow");
            if (!(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileShoppingView)) {
              break label9431;
            }
            paramView.putExtra("report_src_param_name", "0X8005D5A");
          }
          for (;;)
          {
            rtr.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.c, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_h_of_type_Int);
            return;
            label9431:
            paramView.putExtra("report_src_param_name", "0X8005D59");
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 32) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 31) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 50) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 51) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 34) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 53)) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.f();
          return;
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo = ((ProfileActivity.CardContactInfo)((atuw)localObject2).jdField_a_of_type_JavaLangObject);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt == null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt = new int[5];
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[0] = 7;
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[1] = 8;
          if ((ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo.jdField_a_of_type_JavaLangString)))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[2] = 9;
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[3] = 16;
          }
          for (;;)
          {
            i = 4;
            while (i < 5)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[i] = -1;
              i += 1;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[2] = 16;
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[3] = -1;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt, ((atuw)localObject2).jdField_a_of_type_Int);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
          {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A7E", "0X8006A7E", 0, 0, "", "", "", "");
            return;
          }
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A92", "0X8006A92", 0, 0, "", "", "", "");
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin(), 0).edit().putBoolean("svip_profile_show_newer_guide_flag", true).commit();
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo = ((ProfileActivity.CardContactInfo)((atuw)localObject2).jdField_a_of_type_JavaLangObject);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt == null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt = new int[5];
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[0] = 20;
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[1] = 21;
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[2] = 16;
          i = 3;
          while (i < 5)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[i] = -1;
            i += 1;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt, ((atuw)localObject2).jdField_a_of_type_Int);
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A84", "0X8006A84", 0, 0, "", "", "", "");
          return;
          paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, QRDisplayActivity.class);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getResources().getString(2131651449);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin();
          localObject3 = babh.h(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, (String)localObject2);
          paramView.putExtra("title", (String)localObject1);
          paramView.putExtra("uin", (String)localObject2);
          paramView.putExtra("nick", (String)localObject3);
          paramView.putExtra("type", 1);
          paramView.putExtra("reportFlag", 1);
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity(paramView);
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X8007EBB", "0X8007EBB", 0, 0, "", "", "", "");
          return;
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo = ((ProfileActivity.CardContactInfo)((atuw)localObject2).jdField_a_of_type_JavaLangObject);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt == null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt = new int[5];
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[0] = 7;
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[1] = 8;
          if ((ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo.jdField_a_of_type_JavaLangString)))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[2] = 9;
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[3] = 16;
          }
          for (;;)
          {
            i = 4;
            while (i < 5)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[i] = -1;
              i += 1;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[2] = 16;
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[3] = -1;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt, ((atuw)localObject2).jdField_a_of_type_Int);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
          {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A7E", "0X8006A7E", 0, 0, "", "", "", "");
            return;
          }
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A92", "0X8006A92", 0, 0, "", "", "", "");
          return;
          paramView = (baov)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getManager(235);
          if (paramView.b())
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_AndroidViewView.findViewById(2131305078).setVisibility(8);
            paramView.a(false);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.g(0);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.mQQLevelType == 0) {
              i = 99999;
            }
          }
          for (;;)
          {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X800A8C1", "0X800A8C1", j, 0, String.valueOf(j), "", "", "");
            if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
              break;
            }
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A7A", "0X8006A7A", 0, 0, "", "", "", "");
            awqx.b(null, "dc00898", "", "", "qq_vip", "0X800A775", i, 0, "", "", "", "");
            return;
            i = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.mQQLevelType;
            continue;
            i = 99999;
          }
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A8E", "0X8006A8E", 0, 0, "", "", "", "");
          awqx.b(null, "dc00898", "", "", "qq_vip", "0X800A774", i, 0, "", "", "", "");
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X800A8C2", "0X800A8C2", j, 0, String.valueOf(j), "", "", "");
          return;
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.n();
          if ((((atuw)localObject2).jdField_a_of_type_JavaLangObject instanceof View)) {
            ((View)((atuw)localObject2).jdField_a_of_type_JavaLangObject).setVisibility(8);
          }
          VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X8008119", "", 1, 0, 0, mpl.a(), "", "");
          return;
          ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
          paramView = new Intent();
          paramView.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString);
          paramView.putExtra("member_uin", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
          PublicFragmentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, paramView, TroopMemberHistoryFragment.class);
          new awrb(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app).a("dc00899").b("Grp_mem_card").c("page").d("recent_clk").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString }).a();
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X800A596", "0X800A596", 2, 0, "", "", "", "");
          return;
          paramView = wnc.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, 1);
          if (paramView == null)
          {
            paramView = null;
            if (paramView == null) {
              break label11180;
            }
          }
          label11180:
          for (paramView = paramView.b;; paramView = "https://imgcache.qq.com/club/client/flower/release/html/points.html?source=0")
          {
            localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("url", paramView);
            ((Intent)localObject1).putExtra("url", paramView);
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity((Intent)localObject1);
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00899", "Grp_flower", "", "gift_exch", "entry_clk", 0, 0, "", "", "", "");
            new awrb(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app).a("dc00899").b("Grp_mem_card").c("page").d("point_clk").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString }).a();
            return;
            paramView = paramView.a;
            break;
          }
          paramView = azkf.a();
          localObject1 = paramView.a("troop_rank");
          if (TextUtils.isEmpty((CharSequence)localObject1)) {}
          for (paramView = azkh.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.uin, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString);; paramView = paramView.a((String)localObject1, (azkg)localObject2))
          {
            localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("url", paramView);
            ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.c());
            ((Intent)localObject1).putExtra("portraitOnly", true);
            ((Intent)localObject1).putExtra("hide_more_button", true);
            ((Intent)localObject1).putExtra("hide_operation_bar", true);
            ((Intent)localObject1).putExtra("isShowAd", false);
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity((Intent)localObject1);
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00899", "Grp_grade", "", "mber_card", "clk_grade", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString, "", "", "");
            new awrb(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app).a("dc00899").b("Grp_mem_card").c("page").d("grade_clk").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString }).a();
            return;
            localObject2 = new azkg();
            ((azkg)localObject2).c = "31";
            ((azkg)localObject2).b = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
            ((azkg)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString;
          }
          paramView = babh.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.uin, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString, 1, 0);
          localObject1 = new HashMap();
          ((Map)localObject1).put("big_brother_ref_source_key", "biz_src_hdsp_liwu");
          azkd.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.uin, paramView, "profilecard", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, (Map)localObject1);
          paramView = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString);
          if (paramView == null) {
            break;
          }
          if (paramView.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin())) {
            i = 0;
          }
          for (;;)
          {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "P_CliOper", "Grp_flower", "", "mber_data", "Clk_send", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString, i + "", "", "");
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_btn", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString, "4", atxx.a(atxx.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.uin)), "");
            new awrb(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app).a("dc00899").b("Grp_mem_card").c("page").d("flower_clk").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString }).a();
            return;
            if (paramView.isAdmin()) {
              i = 1;
            } else {
              i = 2;
            }
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard == null)) {
            break;
          }
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mMemberGameInfo;
          if (paramView == null) {
            break;
          }
          localObject1 = paramView.gameUrl;
          localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity((Intent)localObject2);
          azzx.a("Grp_game", "Mber_data", "game_clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString, paramView.gameName });
          return;
          if ((((atuw)localObject2).jdField_a_of_type_JavaLangObject == null) || (!(((atuw)localObject2).jdField_a_of_type_JavaLangObject instanceof PhotoWallView))) {
            break;
          }
          ((PhotoWallView)((atuw)localObject2).jdField_a_of_type_JavaLangObject).b();
          return;
          if ((((atuw)localObject2).jdField_a_of_type_JavaLangObject == null) || (!(((atuw)localObject2).jdField_a_of_type_JavaLangObject instanceof PersonalityLabelBoard))) {
            break;
          }
          ((PersonalityLabelBoard)((atuw)localObject2).jdField_a_of_type_JavaLangObject).a(false);
          return;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard == null)) {
            break;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.c().equals(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.uin))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.b())
            {
              if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.k) {}
              for (i = 2;; i = 1)
              {
                awqx.b(null, "dc00898", "", "", "kuolie", "0X80097DB", i, 0, "", "", "", "");
                return;
              }
            }
            paramView = new Intent();
            paramView.putExtra("key_extend_friend_info", new ExtendFriendProfileEditFragment.ExtendFriendInfo(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard));
            PublicFragmentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, paramView, ExtendFriendEditFragment.class, 4097);
            return;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.l) {
            break;
          }
          ExtendFriendPublicFragmentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity);
          return;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (azzz.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
            break;
          }
          FriendProfileCardActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity);
          return;
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx)) {
            break;
          }
          localObject1 = new Intent(paramView.getContext(), QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("hide_more_button", true);
          ((Intent)localObject1).putExtra("hide_operation_bar", true);
          ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_hdsp_dtzbj");
          ((Intent)localObject1).putExtra("url", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.mNowShowJumpUrl);
          paramView.getContext().startActivity((Intent)localObject1);
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00899", "NOW", "", "qq_zlk", "logo_click", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.uin, "", "", "");
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
              i = 1;
            }
          }
          for (;;)
          {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X800999B", "0X800999B", i, 0, "", "", "", "");
            return;
            i = 2;
            continue;
            i = 2;
          }
          if (!(((atuw)localObject2).jdField_a_of_type_JavaLangObject instanceof PrivilegeInfo))
          {
            QLog.e("DIYProfileTemplate.FriendProfileCardActivity", 1, "DATA_TYPE_BIG_DIAMOND url is not string:" + ((atuw)localObject2).jdField_a_of_type_JavaLangObject);
            return;
          }
          localObject2 = (PrivilegeInfo)((atuw)localObject2).jdField_a_of_type_JavaLangObject;
          paramView = ((PrivilegeInfo)localObject2).strJumpUrl;
          localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", paramView);
          ((Intent)localObject1).putExtra("hide_operation_bar", true);
          ((Intent)localObject1).putExtra("hide_more_button", true);
          ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity((Intent)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("DIYProfileTemplate.FriendProfileCardActivity", 1, "DATA_TYPE_BIG_DIAMOND click");
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
          {
            i = 1;
            switch (((PrivilegeInfo)localObject2).iType)
            {
            default: 
              if (i != 0)
              {
                paramView = "0X800A137";
                label12684:
                if (TextUtils.isEmpty(paramView)) {
                  break;
                }
                if (((PrivilegeInfo)localObject2).iIsBig != 1) {
                  break label12846;
                }
                if (!((PrivilegeInfo)localObject2).isOpen) {
                  break label12841;
                }
                i = 1;
              }
              break;
            }
          }
          for (;;)
          {
            localObject1 = "";
            if (((PrivilegeInfo)localObject2).iType == 1) {
              localObject1 = String.valueOf(ajve.b(ajve.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.c())));
            }
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "qvip", paramView, i, 0, (String)localObject1, "", "", "");
            return;
            i = 0;
            break;
            if (i != 0) {}
            for (paramView = "0X800A133";; paramView = "0X800A12B") {
              break;
            }
            if (i != 0) {}
            for (paramView = "0X800A135";; paramView = "0X800A12D") {
              break;
            }
            if (i != 0) {}
            for (paramView = "0X800A131";; paramView = "0X800A129") {
              break;
            }
            paramView = "0X800A12F";
            break label12684;
            label12841:
            i = 2;
            continue;
            label12846:
            if (((PrivilegeInfo)localObject2).isOpen) {
              i = 3;
            } else {
              i = 4;
            }
          }
          localObject1 = new LaunchParam();
          ((LaunchParam)localObject1).scene = 2062;
          bool1 = ((Boolean)((atuw)localObject2).jdField_a_of_type_JavaLangObject).booleanValue();
          MiniAppUtils.reportProfileCardClick(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard, bool1);
          localObject2 = paramView.getContext();
          if (bool1) {}
          for (paramView = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.tabJumpUrl;; paramView = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.guestJumpUrl)
          {
            MiniAppController.startAppByLink((Context)localObject2, paramView, 2, (LaunchParam)localObject1, null);
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.L();
          return;
        }
        label12980:
        paramView = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaur
 * JD-Core Version:    0.7.0.1
 */