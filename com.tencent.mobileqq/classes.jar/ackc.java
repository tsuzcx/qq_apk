import android.content.res.Resources;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.PinnedDividerSwipListView;

public class ackc
  implements bfug
{
  public ackc(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void a(bfuf parambfuf)
  {
    if (parambfuf.a == this.a.jdField_m_of_type_Int) {
      return;
    }
    this.a.jdField_m_of_type_Int = parambfuf.a;
    TroopMemberListActivity.a(this.a, parambfuf.a);
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
      if (this.a.jdField_a_of_type_Acla != null) {
        this.a.jdField_a_of_type_Acla.a();
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
        ((akhq)this.a.app.a(20)).v(this.a.jdField_b_of_type_JavaLangString);
        new axra(this.a.app).a("dc00899").b("Grp_online").c("mber_list").d("exp_onlineList").a(0).a(new String[] { this.a.jdField_b_of_type_JavaLangString }).a();
        new axra(this.a.app).a("dc00899").b("Grp_online").c("mber_list").d("clk_onlinefirst").a(new String[] { this.a.jdField_b_of_type_JavaLangString }).a();
        break;
      }
      if (this.a.jdField_m_of_type_Int == 5)
      {
        ((akhq)this.a.app.a(20)).w(this.a.jdField_b_of_type_JavaLangString);
        break;
      }
      if (this.a.jdField_m_of_type_Int == 2) {}
      for (parambfuf = "Clk_lastactivetime";; parambfuf = "Clk_jointime")
      {
        this.a.a(parambfuf, "1", this.a.n);
        break;
      }
      label472:
      this.a.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setSelectionFromTop(0, -this.a.getResources().getDimensionPixelSize(2131298606));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ackc
 * JD-Core Version:    0.7.0.1
 */