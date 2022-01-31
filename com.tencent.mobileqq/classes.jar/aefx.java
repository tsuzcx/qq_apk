import android.content.res.Resources;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.PinnedDividerSwipListView;

public class aefx
  implements biab
{
  public aefx(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void a(biaa parambiaa)
  {
    if (parambiaa.a == this.a.jdField_m_of_type_Int) {
      return;
    }
    this.a.jdField_m_of_type_Int = parambiaa.a;
    TroopMemberListActivity.a(this.a, parambiaa.a);
    if ((this.a.jdField_m_of_type_Int >= 0) && (this.a.jdField_m_of_type_Int < TroopMemberListActivity.a(this.a).length)) {
      this.a.c.setText(TroopMemberListActivity.a(this.a)[this.a.jdField_m_of_type_Int]);
    }
    if (this.a.jdField_m_of_type_Int == 0)
    {
      this.a.a("Clk_def", this.a.n, "");
      this.a.h();
      if (!this.a.jdField_m_of_type_Boolean) {
        this.a.jdField_m_of_type_Boolean = true;
      }
      if (this.a.jdField_a_of_type_Aegv != null) {
        this.a.jdField_a_of_type_Aegv.a();
      }
      if (this.a.jdField_m_of_type_Int != 0) {
        break label472;
      }
      this.a.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setSelectionFromTop(0, 0);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setContentDescription(this.a.jdField_b_of_type_AndroidWidgetTextView.getText().toString() + this.a.c.getText().toString());
      return;
      if (this.a.jdField_m_of_type_Int == 1)
      {
        ((amdu)this.a.app.a(20)).v(this.a.jdField_b_of_type_JavaLangString);
        new azqx(this.a.app).a("dc00899").b("Grp_online").c("mber_list").d("exp_onlineList").a(0).a(new String[] { this.a.jdField_b_of_type_JavaLangString }).a();
        new azqx(this.a.app).a("dc00899").b("Grp_online").c("mber_list").d("clk_onlinefirst").a(new String[] { this.a.jdField_b_of_type_JavaLangString }).a();
        break;
      }
      if (this.a.jdField_m_of_type_Int == 5)
      {
        ((amdu)this.a.app.a(20)).w(this.a.jdField_b_of_type_JavaLangString);
        break;
      }
      if (this.a.jdField_m_of_type_Int == 2) {}
      for (parambiaa = "Clk_lastactivetime";; parambiaa = "Clk_jointime")
      {
        this.a.a(parambiaa, "1", this.a.n);
        break;
      }
      label472:
      this.a.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setSelectionFromTop(0, -this.a.getResources().getDimensionPixelSize(2131298634));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aefx
 * JD-Core Version:    0.7.0.1
 */