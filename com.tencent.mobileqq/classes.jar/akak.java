import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;

public class akak
  implements View.OnClickListener
{
  public akak(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("show_invite_entry", false))
    {
      max.a(this.a.app, this.a, paramView, this.a.jdField_a_of_type_AndroidContentIntent);
      return;
    }
    Object localObject1;
    Object localObject2;
    if (this.a.d == 11)
    {
      if (this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 0) {
        azqs.b(this.a.app, "CliOper", "", "", "0X8005527", "0X8005527", 0, 0, "", "", "", "");
      }
    }
    else if (this.a.b == 3)
    {
      localObject1 = this.a.getIntent().getStringExtra("group_uin");
      localObject2 = mwu.a(this.a.app, this.a.app.getCurrentAccountUin(), (String)localObject1) + "";
      if (!"发起视频".equals(this.a.jdField_e_of_type_AndroidWidgetTextView.getText().toString())) {
        break label284;
      }
    }
    label284:
    for (paramView = "0";; paramView = "1")
    {
      azqs.b(null, "dc00899", "Grp_video", "", "invite", "Clk_call", 0, 0, (String)localObject1, (String)localObject2, paramView, "");
      if (this.a.d != 33) {
        break label290;
      }
      aiwp.a(this.a, this.a.jdField_e_of_type_JavaUtilArrayList);
      return;
      if (this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() != 1) {
        break;
      }
      azqs.b(this.a.app, "CliOper", "", "", "0X8005526", "0X8005526", 0, 0, "", "", "", "");
      break;
    }
    label290:
    if ((this.a.d == 32) && (this.a.jdField_e_of_type_JavaUtilArrayList.size() > this.a.g))
    {
      paramView = MessageFormat.format(this.a.getString(2131719724), new Object[] { Integer.valueOf(this.a.g) });
      QQToast.a(this.a, paramView, 0).b(this.a.jdField_c_of_type_AndroidViewView.getHeight());
      return;
    }
    if (!bdin.d(this.a))
    {
      QQToast.a(this.a, this.a.getString(2131692398), 0).b(this.a.jdField_c_of_type_AndroidViewView.getHeight());
      return;
    }
    if ((this.a.v) && (this.a.jdField_e_of_type_JavaUtilArrayList.size() == 1) && (this.a.jdField_e_of_type_JavaUtilArrayList.get(0) != null))
    {
      paramView = (ResultRecord)this.a.jdField_e_of_type_JavaUtilArrayList.get(0);
      localObject1 = this.a.app.c();
      if ((localObject1 != null) && (paramView.jdField_a_of_type_JavaLangString != null) && (((String)localObject1).equals(paramView.jdField_a_of_type_JavaLangString)))
      {
        QQToast.a(this.a, this.a.getString(2131719722), 0).b(this.a.jdField_c_of_type_AndroidViewView.getHeight());
        return;
      }
    }
    paramView = this.a.jdField_e_of_type_JavaUtilArrayList.iterator();
    do
    {
      if (!paramView.hasNext()) {
        break;
      }
    } while (((ResultRecord)paramView.next()).jdField_a_of_type_Int == 5);
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SelectMemberActivity", 2, "right btn click entrance[" + this.a.d + "], uinType[" + this.a.jdField_a_of_type_Int + "], nopstn[" + bool + "]");
      }
      if (((this.a.d == 36) || (this.a.d == 11)) && (bool))
      {
        bdgm.a(this.a, 230, this.a.getString(2131696158), this.a.getString(2131720948), 2131695894, 2131691089, new akal(this), new akam(this)).show();
        azqs.b(null, "CliOper", "", "", "0X8004CED", "0X8004CED", 0, 0, "", "", "", "");
        return;
      }
      int i;
      if ((this.a.d == 12) && (this.a.g == 1)) {
        if (this.a.jdField_e_of_type_JavaUtilArrayList.size() == 1)
        {
          localObject1 = (ResultRecord)this.a.jdField_e_of_type_JavaUtilArrayList.get(0);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("select_memeber_single_friend", true);
          ((Intent)localObject2).putExtra("select_memeber_single_friend_type", ((ResultRecord)localObject1).jdField_a_of_type_Int);
          if ((((ResultRecord)localObject1).jdField_a_of_type_Int == 0) && (((ResultRecord)localObject1).jdField_a_of_type_Int != 1)) {
            break label1666;
          }
          i = 1000;
        }
      }
      label1666:
      for (paramView = this.a.a(((ResultRecord)localObject1).jdField_c_of_type_JavaLangString);; paramView = null)
      {
        if (((ResultRecord)localObject1).jdField_a_of_type_Int == 2)
        {
          paramView = ((ResultRecord)localObject1).jdField_c_of_type_JavaLangString;
          i = 1004;
        }
        label1026:
        for (;;)
        {
          if (((ResultRecord)localObject1).jdField_a_of_type_Int == 3) {
            i = 1021;
          }
          label904:
          label1058:
          label1082:
          label1657:
          label1660:
          for (;;)
          {
            Object localObject3 = ((alto)this.a.app.getManager(51)).e(((ResultRecord)localObject1).jdField_a_of_type_JavaLangString);
            int j = i;
            if (localObject3 != null)
            {
              j = i;
              if (((Friends)localObject3).isFriend()) {
                j = 0;
              }
            }
            localObject3 = new Bundle();
            ((Bundle)localObject3).putString("uin", ((ResultRecord)localObject1).jdField_a_of_type_JavaLangString);
            ((Bundle)localObject3).putInt("uintype", j);
            ((Bundle)localObject3).putString("uinname", ((ResultRecord)localObject1).b);
            ((Bundle)localObject3).putString("troop_uin", paramView);
            ((Intent)localObject2).putExtras((Bundle)localObject3);
            this.a.setResult(-1, (Intent)localObject2);
            this.a.finish();
            azqs.b(this.a.app, "CliOper", "", "", "0X8006664", "0X8006664", 0, 0, "", "", "", "");
            if (this.a.b == 1)
            {
              paramView = this.a.jdField_e_of_type_JavaUtilArrayList.iterator();
              i = 0;
              if (!paramView.hasNext()) {
                break label1538;
              }
              localObject1 = (ResultRecord)paramView.next();
              if ((((ResultRecord)localObject1).jdField_a_of_type_Int != 1) && (((ResultRecord)localObject1).jdField_a_of_type_Int != 2)) {
                break label1657;
              }
              i += 1;
            }
            for (;;)
            {
              break label1082;
              if (((ResultRecord)localObject1).jdField_a_of_type_Int != 4) {
                break label1660;
              }
              i = 1006;
              break label904;
              this.a.a();
              break label1026;
              if (this.a.d == 23)
              {
                paramView = new Intent();
                localObject1 = new Bundle();
                localObject2 = new ArrayList();
                localObject3 = this.a.jdField_e_of_type_JavaUtilArrayList.iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject3).next();
                  if (localResultRecord.jdField_a_of_type_Int == 1) {
                    ((ArrayList)localObject2).add(localResultRecord.jdField_a_of_type_JavaLangString);
                  }
                }
                ((Bundle)localObject1).putStringArrayList("troopMemList", (ArrayList)localObject2);
                paramView.putExtras((Bundle)localObject1);
                this.a.setResult(-1, paramView);
                this.a.finish();
                break label1058;
              }
              if (this.a.d == 24)
              {
                paramView = new Intent();
                localObject1 = new Bundle();
                ((Bundle)localObject1).putParcelableArrayList("friendsSelected", this.a.jdField_e_of_type_JavaUtilArrayList);
                paramView.putExtras((Bundle)localObject1);
                this.a.setResult(-1, paramView);
                if (this.a.s) {
                  wxj.a("set_notsee", "clk_done", 0, 0, new String[] { "", "", "", "" });
                }
                for (;;)
                {
                  this.a.finish();
                  break;
                  wxj.a("set_notletsee", "clk_done", 0, 0, new String[] { "", "", "", "" });
                }
              }
              if (this.a.d == 37)
              {
                this.a.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("result_set", this.a.jdField_e_of_type_JavaUtilArrayList);
                this.a.setResult(-1, this.a.jdField_a_of_type_AndroidContentIntent);
                this.a.finish();
                break label1058;
              }
              if ((this.a.jdField_a_of_type_Int == 3000) && (this.a.b == 0))
              {
                this.a.m();
                break label1058;
              }
              this.a.a();
              break label1058;
              break;
              if (i <= 0) {
                break;
              }
              paramView = ((TroopManager)this.a.app.getManager(52)).c(this.a.jdField_c_of_type_JavaLangString);
              if (paramView == null) {
                break;
              }
              localObject1 = this.a.app.c();
              if (paramView.isTroopOwner((String)localObject1)) {
                j = 0;
              }
              for (;;)
              {
                azqs.b(this.a.app, "dc00899", "invite_friend", "", "friend_list", "invite_friend", 0, 0, this.a.jdField_c_of_type_JavaLangString, String.valueOf(j), String.valueOf(i), "");
                return;
                if (paramView.isTroopAdmin((String)localObject1)) {
                  j = 1;
                } else {
                  j = 2;
                }
              }
            }
          }
        }
        label1538:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akak
 * JD-Core Version:    0.7.0.1
 */