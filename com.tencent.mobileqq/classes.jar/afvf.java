import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.28.1;
import com.tencent.mobileqq.activity.TroopMemberListActivity.28.2;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.qphone.base.util.QLog;

public class afvf
  implements bliz
{
  public afvf(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((!TroopMemberListActivity.c(this.a)) && (paramInt >= 5)) {}
    for (int i = paramInt + 1;; i = paramInt)
    {
      if (this.a.e) {
        if (paramInt == 0) {
          this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopMemberListActivity.28.1(this), 320L);
        }
      }
      for (;;)
      {
        if ((this.a.jdField_a_of_type_Blir != null) && (this.a.jdField_a_of_type_Blir.isShowing())) {
          this.a.jdField_a_of_type_Blir.dismiss();
        }
        return;
        if (QLog.isColorLevel())
        {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "mOnActionSheetClickListener.OnClick, error : which = " + paramInt + ", troopUin = " + this.a.jdField_b_of_type_JavaLangString);
          continue;
          if (this.a.jdField_d_of_type_Int == 9) {
            switch (i)
            {
            default: 
              break;
            case 0: 
              this.a.c = true;
              this.a.t = "";
              this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
              this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
              this.a.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
              if (this.a.jdField_a_of_type_Afwg != null) {
                this.a.jdField_a_of_type_Afwg.a();
              }
              bdll.b(this.a.app, "P_CliOper", "Grp_pay", "", "un_pay_list", "Clk_del", 0, 0, this.a.jdField_b_of_type_JavaLangString, this.a.n, "", "");
              break;
            }
          } else {
            switch (i)
            {
            default: 
              break;
            case 0: 
              this.a.l();
              break;
            case 1: 
              if (!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString))
              {
                paramView = new Intent(this.a, SelectMemberActivity.class);
                paramView.putExtra("param_from", 30);
                paramView.putExtra("group_uin", this.a.jdField_b_of_type_JavaLangString);
                paramView.putExtra("param_groupcode", this.a.jdField_a_of_type_JavaLangString);
                paramView.putExtra("param_from", 30);
                paramView.putExtra("param_subtype", 4);
                paramView.putExtra("param_entrance", 30);
                paramView.putExtra("param_max", 30);
                paramView.putExtra("param_exit_animation", 3);
                this.a.startActivity(paramView);
                this.a.overridePendingTransition(2130771997, 0);
                bdll.b(this.a.app, "dc00899", "Grp_mber", "", "mber_list", "clk_Add", 0, 0, this.a.jdField_b_of_type_JavaLangString, "", "", "");
              }
              break;
            case 2: 
              this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopMemberListActivity.28.2(this), 320L);
              break;
            case 3: 
              this.a.jdField_d_of_type_Boolean = true;
              this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
              TroopMemberListActivity.a(this.a);
              this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
              this.a.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
              this.a.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
              this.a.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.a.findViewById(2131369044));
              this.a.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
              this.a.jdField_d_of_type_AndroidWidgetTextView.setText(anzj.a(2131714398));
              this.a.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new afvg(this));
              if (this.a.jdField_a_of_type_Afwg != null) {
                this.a.jdField_a_of_type_Afwg.a();
              }
              paramView = this.a.n;
              this.a.a("Clk_del", paramView, "");
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afvf
 * JD-Core Version:    0.7.0.1
 */