import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.9.5;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.multicard.RecommendPerson;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqprotect.qsec.QSecFramework;
import common.config.service.QzoneConfig;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class aeqc
  implements View.OnClickListener
{
  long a;
  
  public aeqc(FriendProfileCardActivity paramFriendProfileCardActivity)
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    Object localObject3;
    int i;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((paramView.getTag() instanceof azvr))
      {
        aokv.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.c(), false);
        localObject3 = (azvr)paramView.getTag();
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "onClickListener and DataTag type=" + ((azvr)localObject3).jdField_a_of_type_Int);
        }
        long l = System.currentTimeMillis();
        if ((((azvr)localObject3).jdField_a_of_type_Int == 10) || (Math.abs(l - this.jdField_a_of_type_Long) >= 1000L))
        {
          this.jdField_a_of_type_Long = l;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.c) || (!this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a(((azvr)localObject3).jdField_a_of_type_Int)))
          {
            Object localObject1;
            Object localObject4;
            Object localObject5;
            switch (((azvr)localObject3).jdField_a_of_type_Int)
            {
            default: 
              break;
            case 4: 
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo = ((ProfileActivity.CardContactInfo)((azvr)localObject3).jdField_a_of_type_JavaLangObject);
              if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt == null) {
                this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt = new int[5];
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[0] = 7;
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[1] = 8;
              if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
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
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt, ((azvr)localObject3).jdField_a_of_type_Int);
              bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8005AFD", "0X8005AFD", 0, 0, "", "", "", "");
              break;
            case 95: 
              localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
              localObject1 = new Date(System.currentTimeMillis());
              localObject4 = new SimpleDateFormat("yyyyMMdd").format((Date)localObject1);
              localObject5 = QzoneConfig.getInstance().getConfig("H5Url", "give_gift_button_in_profile_url", "https://h5.qzone.qq.com/giftv2/vuemall?_wv=131075&_fv=0&_wwv=128&from=card&friends={to_uin}");
              localObject1 = null;
              if (!TextUtils.isEmpty((CharSequence)localObject5)) {
                localObject1 = ((String)localObject5).replace("{to_uin}", (String)localObject3 + "_" + (String)localObject4);
              }
              localObject3 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, QQBrowserActivity.class);
              ((Intent)localObject3).putExtra("url", (String)localObject1);
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity((Intent)localObject3);
              baew.d(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr);
              break;
            case 7: 
              if (QSecFramework.a().a(1001).booleanValue()) {
                QSecFramework.a().a(5, 0, 2, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(6), "addfriend", null }, null);
              }
              FriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity);
              bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "P_prof", "Pp_add_frd", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), Integer.toString(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.k), "", "");
              if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h == 119) {
                bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc01160", "", "", "0X800A410", "0X800A410", 0, 0, "", "", "", "");
              }
              if (bhjx.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
                bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X8008274", "0X8008274", 0, 0, "", "", "", "");
              }
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 82) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 81) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 83) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 101) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 103) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 102) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 107) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 110))
              {
                localObject5 = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getIntent().getBundleExtra("profile_extres");
                if (localObject5 != null) {
                  i = 0;
                }
              }
              switch (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
              {
              default: 
                localObject1 = ((Bundle)localObject5).getString("recommend_entry_type", "");
                localObject3 = ((Bundle)localObject5).getString("recommend_reason", "");
                int j = ((Bundle)localObject5).getInt("key_display_type", 0);
                int k = ((Bundle)localObject5).getInt("recommend_pos", 0);
                localObject4 = ((Bundle)localObject5).getByteArray("recommend_algh_id");
                localObject5 = ((Bundle)localObject5).getString("recommend_label", "");
                ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, "frd_list_add", i, 2, (String)localObject3, k, (byte[])localObject4, (String)localObject5, j, (String)localObject1);
                if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null))
                {
                  if (87 == this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h) {
                    bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006F0D", "0X8006F0D", 0, 0, "", "", "", "");
                  }
                }
                else if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53)
                {
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.b != 1) {
                    break label1910;
                  }
                  bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8007162", "0X8007162", 0, 0, "", "", "", "");
                }
                break;
              }
              for (;;)
              {
                if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.b) {
                  new bdlq(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app).a("dc00899").b("Grp_mem_card").c("page").d("addfri_clk").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_JavaLangString }).a();
                }
                if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 122)
                {
                  localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;
                  if (localObject1 != null)
                  {
                    i = ((Bundle)localObject1).getInt("key_troop_recommend_position", 0);
                    localObject1 = (RecommendPerson)((Bundle)localObject1).getSerializable("key_troop_recommend_person");
                    axoo.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, i, 2, (RecommendPerson)localObject1);
                  }
                }
                baew.c(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr);
                break;
                i = 21;
                break label1116;
                i = 23;
                break label1116;
                i = 3;
                break label1116;
                i = 24;
                break label1116;
                i = 20;
                break label1116;
                i = 25;
                break label1116;
                i = 28;
                break label1116;
                i = ((Bundle)localObject5).getInt("tabID", 0);
                break label1116;
                if ((101 == this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h) || (102 == this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h) || (103 == this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h))
                {
                  if (((axfr)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getManager(11)).i()) {}
                  for (localObject1 = "0X80077D4";; localObject1 = "0X80077CE")
                  {
                    bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
                    if (101 != this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h) {
                      break label1752;
                    }
                    bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", (String)localObject1, (String)localObject1, 1, 0, "", "", "", "");
                    break;
                  }
                  if (102 == this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h)
                  {
                    bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", (String)localObject1, (String)localObject1, 2, 0, "", "", "", "");
                    break label1295;
                  }
                  if (103 != this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h) {
                    break label1295;
                  }
                  bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", (String)localObject1, (String)localObject1, 3, 0, "", "", "", "");
                  break label1295;
                }
                if (104 != this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h) {
                  break label1295;
                }
                bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X80077D1", "0X80077D1", 0, 0, "", "", "", "");
                break label1295;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.b == 2) {
                  bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8007163", "0X8007163", 0, 0, "", "", "", "");
                }
              }
            case 8: 
              if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h == 126) {
                bhlq.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, 230, "", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getString(2131691964), this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getString(2131692385), this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getString(2131691963), new aeqd(this), new aeqe(this)).show();
              }
              for (;;)
              {
                baew.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr);
                break;
                this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.f();
                bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "P_prof", "Pp_send_msg", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), Integer.toString(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.k), "", "");
                if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.b) {
                  new bdlq(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app).a("dc00899").b("Grp_mem_card").c("page").d("msg_clk").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_JavaLangString }).a();
                }
              }
            case 92: 
              bdll.b(null, "dc00898", "", "", "qq_vip", "0X8009E3B", 2, 0, "", "", "", "");
              if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.b) {
                VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin(), "group_card", "click_cardbt", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
              }
            case 23: 
              localObject1 = paramView.findViewById(2131380393);
              localObject4 = paramView.getParent();
              if ((localObject4 instanceof View)) {
                localObject1 = ((View)localObject4).findViewById(2131380393);
              }
              i = 1;
              if (localObject1 != null) {
                if (((View)localObject1).getVisibility() != 0) {
                  break label2639;
                }
              }
              for (i = 0;; i = 1)
              {
                ((View)localObject1).setVisibility(8);
                this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.d();
                localObject1 = "";
                if (((azvr)localObject3).jdField_a_of_type_Int == 92) {
                  localObject1 = "profileType=custom";
                }
                bhhz.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin(), "inside.myCardButton", i, 3, 1, (String)localObject1, true);
                bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "card_mall", "0X8006681", 0, 0, "", "", "", "");
                bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X8007EB5", "0X8007EB5", 0, 0, "", "", "", "");
                if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.b) {
                  VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin(), "group_card", "click_cardbt", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                }
                if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == azxy.j) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == azxy.i)) {
                  VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clkcard_owner", "0", 1, 0, 0, nnr.a(), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId));
                }
                baew.h(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr);
                break;
              }
            case 81: 
              if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.l();
                if (FriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity)) {
                  bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X80081C1", "0X80081C1", 0, 0, "", "", "", "");
                }
                new bdlq(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app).a("dc00899").b("Grp_mem_card").c("page").d("edit_clk").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_JavaLangString }).a();
              }
              break;
            case 20: 
              localObject1 = new int[5];
              localObject3 = mvg.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity);
              ((mvg)localObject3).a(2131689515);
              ((mvg)localObject3).b(2131718782);
              localObject1[0] = 1;
              localObject1[1] = 2;
              ((mvg)localObject3).b(2131718796);
              ((mvg)localObject3).c(2131690580);
              ((mvg)localObject3).a(new aeqf(this));
              ((mvg)localObject3).a(new aeqg(this, (int[])localObject1, (mvg)localObject3));
              ((mvg)localObject3).show();
              baew.g(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr);
              break;
            case 59: 
              localObject1 = new FriendProfileCardActivity.9.5(this);
              localObject3 = new aeqh(this);
              localObject3 = new DenyRunnable(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, (akot)localObject3);
              ajnj.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, (Runnable)localObject1, (Runnable)localObject3);
              if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.b == 2) {
                bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8007164", "0X8007164", 0, 0, "", "", "", "");
              } else if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.b == 3) {
                bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8007165", "0X8007165", 0, 0, "", "", "", "");
              }
              break;
            case 47: 
              label1116:
              label1910:
              bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "card_mall", "0X80066C6", 0, 0, "2", "", "", "");
              label1295:
              label1752:
              localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, ProfileLabelEditorActivity.class);
              label2639:
              ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
              try
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivityForResult((Intent)localObject1, 1004);
              }
              catch (Exception localException1)
              {
                localException1.printStackTrace();
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        Object localObject2 = bhlg.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.uin, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_JavaLangString, 1, 0);
        localObject3 = new HashMap();
        ((Map)localObject3).put("big_brother_ref_source_key", "biz_src_hdsp_liwu");
        bgth.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.uin, (String)localObject2, "profilecard", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, (Map)localObject3);
        baew.e(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr);
        localObject2 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_JavaLangString);
        if (localObject2 == null) {
          break;
        }
        if (!((TroopInfo)localObject2).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin())) {
          break label3504;
        }
        i = 0;
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "P_CliOper", "Grp_flower", "", "mber_data", "Clk_send", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_JavaLangString, i + "", "", "");
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_btn", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_JavaLangString, "4", azyo.a(azyo.a((TroopInfo)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.uin)), "");
        new bdlq(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app).a("dc00899").b("Grp_mem_card").c("page").d("flower_clk").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_Azxr.jdField_a_of_type_JavaLangString }).a();
      }
      catch (Exception localException2)
      {
        QLog.e("FriendProfileCardActivity", 1, "onClick DATA_TYPE_TROOP_MEM_SEND_GIFT fail.", localException2);
      }
      break;
      label3504:
      boolean bool = localException2.isAdmin();
      if (bool) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeqc
 * JD-Core Version:    0.7.0.1
 */