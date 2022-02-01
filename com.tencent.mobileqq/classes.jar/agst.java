import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agst
  implements View.OnClickListener
{
  agst(agss paramagss) {}
  
  public void onClick(View paramView)
  {
    agss.a(this.a).dismissDialog(230);
    aber.a(agss.a(this.a), agss.a(this.a).jdField_a_of_type_Int, agss.a(this.a).jdField_a_of_type_JavaLangString, agss.a(this.a).getAccount());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agst
 * JD-Core Version:    0.7.0.1
 */