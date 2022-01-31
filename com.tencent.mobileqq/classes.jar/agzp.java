import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class agzp
  implements View.OnClickListener
{
  agzp(agzo paramagzo) {}
  
  public void onClick(View paramView)
  {
    azqs.b(agzo.a(this.a), "CliOper", "", "", "Free_call", "Clk_free_call_tips", 0, 0, "", "", "", "");
    agzo.c(agzo.a(this.a), agzo.a(this.a).jdField_a_of_type_JavaLangString);
    agzo.a(this.a).a();
    paramView = null;
    String str = null;
    if (agzo.a(this.a).jdField_a_of_type_Int == 1006) {
      str = agzo.a(this.a).jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      ChatActivityUtils.a(agzo.a(this.a), agzo.a(this.a), agzo.a(this.a).jdField_a_of_type_Int, paramView, agzo.a(this.a).d, str, true, agzo.a(this.a).b, true, true, null, "from_internal");
      azqs.b(agzo.a(this.a), "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "8", "", "", "");
      return;
      paramView = agzo.a(this.a).jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agzp
 * JD-Core Version:    0.7.0.1
 */