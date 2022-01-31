import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class aexv
  implements View.OnClickListener
{
  aexv(aexu paramaexu) {}
  
  public void onClick(View paramView)
  {
    axqy.b(aexu.a(this.a), "CliOper", "", "", "Free_call", "Clk_free_call_tips", 0, 0, "", "", "", "");
    aexu.c(aexu.a(this.a), aexu.a(this.a).jdField_a_of_type_JavaLangString);
    aexu.a(this.a).a();
    paramView = null;
    String str = null;
    if (aexu.a(this.a).jdField_a_of_type_Int == 1006) {
      str = aexu.a(this.a).jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      ChatActivityUtils.a(aexu.a(this.a), aexu.a(this.a), aexu.a(this.a).jdField_a_of_type_Int, paramView, aexu.a(this.a).d, str, true, aexu.a(this.a).b, true, true, null, "from_internal");
      axqy.b(aexu.a(this.a), "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "8", "", "", "");
      return;
      paramView = aexu.a(this.a).jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aexv
 * JD-Core Version:    0.7.0.1
 */