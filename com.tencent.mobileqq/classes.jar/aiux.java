import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aiux
  implements View.OnClickListener
{
  aiux(aiuw paramaiuw) {}
  
  public void onClick(View paramView)
  {
    aiuw.a(this.a).a();
    ChatActivityUtils.a(aiuw.a(this.a), aiuw.a(this.a), aiuw.a(this.a).jdField_a_of_type_Int, aiuw.a(this.a).jdField_a_of_type_JavaLangString, true, true, null, null);
    bdll.b(aiuw.a(this.a), "CliOper", "", "", "0X8003F00", "0X8003F00", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiux
 * JD-Core Version:    0.7.0.1
 */