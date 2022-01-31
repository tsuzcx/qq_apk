import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.29.1;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.29.2;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.qphone.base.util.QLog;

public class aici
  implements bhuk
{
  public aici(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((!ChatHistoryTroopMemberFragment.c(this.a)) && (paramInt >= 5)) {}
    for (int i = paramInt + 1;; i = paramInt)
    {
      if (this.a.h) {
        if (paramInt == 0) {
          this.a.jdField_b_of_type_AndroidOsHandler.postDelayed(new ChatHistoryTroopMemberFragment.29.1(this), 320L);
        }
      }
      for (;;)
      {
        if ((this.a.jdField_a_of_type_Bhuf != null) && (this.a.jdField_a_of_type_Bhuf.isShowing())) {
          this.a.jdField_a_of_type_Bhuf.dismiss();
        }
        return;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.history.BaseFragment", 2, "mOnActionSheetClickListener.OnClick, error : which = " + paramInt + ", troopUin = " + this.a.c);
          continue;
          if (this.a.jdField_d_of_type_Int == 9) {
            switch (i)
            {
            default: 
              break;
            case 0: 
              this.a.f = true;
              this.a.u = "";
              this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
              this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
              this.a.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
              if (this.a.jdField_a_of_type_Aidh != null) {
                this.a.jdField_a_of_type_Aidh.a();
              }
              azqs.b(this.a.getActivity().app, "P_CliOper", "Grp_pay", "", "un_pay_list", "Clk_del", 0, 0, this.a.c, this.a.o, "", "");
              break;
            }
          } else {
            switch (i)
            {
            default: 
              break;
            case 0: 
              this.a.z();
              break;
            case 1: 
              if (!TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString))
              {
                paramView = new Intent(this.a.getActivity(), SelectMemberActivity.class);
                paramView.putExtra("param_from", 30);
                paramView.putExtra("group_uin", this.a.c);
                paramView.putExtra("param_groupcode", this.a.jdField_b_of_type_JavaLangString);
                paramView.putExtra("param_from", 30);
                paramView.putExtra("param_subtype", 4);
                paramView.putExtra("param_entrance", 30);
                paramView.putExtra("param_max", 30);
                paramView.putExtra("param_exit_animation", 3);
                this.a.startActivity(paramView);
                this.a.getActivity().overridePendingTransition(2130771997, 0);
                azqs.b(this.a.getActivity().app, "dc00899", "Grp_mber", "", "mber_list", "clk_Add", 0, 0, this.a.c, "", "", "");
              }
              break;
            case 2: 
              this.a.jdField_b_of_type_AndroidOsHandler.postDelayed(new ChatHistoryTroopMemberFragment.29.2(this), 320L);
              break;
            case 3: 
              this.a.g = true;
              this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
              ChatHistoryTroopMemberFragment.a(this.a);
              this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
              this.a.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
              this.a.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
              this.a.jdField_d_of_type_AndroidWidgetTextView = ((TextView)ChatHistoryTroopMemberFragment.a(this.a, 2131368626));
              this.a.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
              this.a.jdField_d_of_type_AndroidWidgetTextView.setText(alud.a(2131701999));
              this.a.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new aicj(this));
              if (this.a.jdField_a_of_type_Aidh != null) {
                this.a.jdField_a_of_type_Aidh.a();
              }
              paramView = this.a.o;
              this.a.a("Clk_del", paramView, "");
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aici
 * JD-Core Version:    0.7.0.1
 */