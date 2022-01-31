import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class aenc
  implements View.OnClickListener
{
  aenc(aenb paramaenb) {}
  
  public void onClick(View paramView)
  {
    awqx.b(aenb.a(this.a), "CliOper", "", "", "Free_call", "Clk_free_call_tips", 0, 0, "", "", "", "");
    aenb.c(aenb.a(this.a), aenb.a(this.a).jdField_a_of_type_JavaLangString);
    aenb.a(this.a).a();
    paramView = null;
    String str = null;
    if (aenb.a(this.a).jdField_a_of_type_Int == 1006) {
      str = aenb.a(this.a).jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      ChatActivityUtils.a(aenb.a(this.a), aenb.a(this.a), aenb.a(this.a).jdField_a_of_type_Int, paramView, aenb.a(this.a).d, str, true, aenb.a(this.a).b, true, true, null, "from_internal");
      awqx.b(aenb.a(this.a), "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "8", "", "", "");
      return;
      paramView = aenb.a(this.a).jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aenc
 * JD-Core Version:    0.7.0.1
 */