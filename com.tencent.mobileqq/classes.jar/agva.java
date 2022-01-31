import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class agva
  implements View.OnClickListener
{
  agva(aguz paramaguz) {}
  
  public void onClick(View paramView)
  {
    azmj.b(aguz.a(this.a), "CliOper", "", "", "Free_call", "Clk_free_call_tips", 0, 0, "", "", "", "");
    aguz.c(aguz.a(this.a), aguz.a(this.a).jdField_a_of_type_JavaLangString);
    aguz.a(this.a).a();
    paramView = null;
    String str = null;
    if (aguz.a(this.a).jdField_a_of_type_Int == 1006) {
      str = aguz.a(this.a).jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      ChatActivityUtils.a(aguz.a(this.a), aguz.a(this.a), aguz.a(this.a).jdField_a_of_type_Int, paramView, aguz.a(this.a).d, str, true, aguz.a(this.a).b, true, true, null, "from_internal");
      azmj.b(aguz.a(this.a), "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "8", "", "", "");
      return;
      paramView = aguz.a(this.a).jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agva
 * JD-Core Version:    0.7.0.1
 */