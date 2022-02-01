import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ailj
  implements View.OnClickListener
{
  ailj(aili paramaili) {}
  
  public void onClick(View paramView)
  {
    bcst.b(aili.a(this.a), "CliOper", "", "", "Free_call", "Clk_free_call_tips", 0, 0, "", "", "", "");
    aili.c(aili.a(this.a), aili.a(this.a).jdField_a_of_type_JavaLangString);
    aili.a(this.a).a();
    String str1 = null;
    String str2 = null;
    if (aili.a(this.a).jdField_a_of_type_Int == 1006) {
      str2 = aili.a(this.a).jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      ChatActivityUtils.a(aili.a(this.a), aili.a(this.a), aili.a(this.a).jdField_a_of_type_Int, str1, aili.a(this.a).d, str2, true, aili.a(this.a).b, true, true, null, "from_internal");
      bcst.b(aili.a(this.a), "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "8", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      str1 = aili.a(this.a).jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ailj
 * JD-Core Version:    0.7.0.1
 */