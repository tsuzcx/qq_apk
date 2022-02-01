import android.content.res.Resources;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.PinnedDividerSwipListView;

public class akeq
  implements blop
{
  public akeq(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void a(bloo parambloo)
  {
    if (parambloo.a == this.a.m) {
      return;
    }
    this.a.m = parambloo.a;
    ChatHistoryTroopMemberFragment.a(this.a, parambloo.a);
    if ((this.a.m >= 0) && (this.a.m < ChatHistoryTroopMemberFragment.a(this.a).length)) {
      this.a.jdField_c_of_type_AndroidWidgetTextView.setText(ChatHistoryTroopMemberFragment.a(this.a)[this.a.m]);
    }
    if (this.a.m == 0)
    {
      this.a.a("Clk_def", this.a.o, "");
      this.a.w();
      if (!this.a.p) {
        this.a.p = true;
      }
      if (this.a.jdField_a_of_type_Akfe != null) {
        this.a.jdField_a_of_type_Akfe.a();
      }
      if (this.a.m != 0) {
        break label433;
      }
      this.a.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setSelectionFromTop(0, 0);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setContentDescription(this.a.jdField_b_of_type_AndroidWidgetTextView.getText().toString() + this.a.jdField_c_of_type_AndroidWidgetTextView.getText().toString());
      return;
      if (this.a.m == 1)
      {
        ((aoip)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).v(this.a.jdField_c_of_type_JavaLangString);
        new bdlq(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("mber_list").d("exp_onlineList").a(0).a(new String[] { this.a.jdField_c_of_type_JavaLangString }).a();
        new bdlq(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("mber_list").d("clk_onlinefirst").a(new String[] { this.a.jdField_c_of_type_JavaLangString }).a();
        break;
      }
      if (this.a.m == 2) {}
      for (parambloo = "Clk_lastactivetime";; parambloo = "Clk_jointime")
      {
        this.a.a(parambloo, "1", this.a.o);
        break;
      }
      label433:
      this.a.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setSelectionFromTop(0, -this.a.getResources().getDimensionPixelSize(2131298729));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akeq
 * JD-Core Version:    0.7.0.1
 */