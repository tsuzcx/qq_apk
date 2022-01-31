import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class aexx
  implements View.OnClickListener
{
  aexx(aexw paramaexw) {}
  
  public void onClick(View paramView)
  {
    axqw.b(aexw.a(this.a), "CliOper", "", "", "Free_call", "Clk_free_call_tips", 0, 0, "", "", "", "");
    aexw.c(aexw.a(this.a), aexw.a(this.a).jdField_a_of_type_JavaLangString);
    aexw.a(this.a).a();
    paramView = null;
    String str = null;
    if (aexw.a(this.a).jdField_a_of_type_Int == 1006) {
      str = aexw.a(this.a).jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      ChatActivityUtils.a(aexw.a(this.a), aexw.a(this.a), aexw.a(this.a).jdField_a_of_type_Int, paramView, aexw.a(this.a).d, str, true, aexw.a(this.a).b, true, true, null, "from_internal");
      axqw.b(aexw.a(this.a), "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "8", "", "", "");
      return;
      paramView = aexw.a(this.a).jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aexx
 * JD-Core Version:    0.7.0.1
 */