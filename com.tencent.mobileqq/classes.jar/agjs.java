import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agjs
  implements View.OnClickListener
{
  agjs(agjr paramagjr) {}
  
  public void onClick(View paramView)
  {
    agjr.a(this.a).dismissDialog(230);
    abao.a(agjr.a(this.a), agjr.a(this.a).jdField_a_of_type_Int, agjr.a(this.a).jdField_a_of_type_JavaLangString, agjr.a(this.a).getAccount());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agjs
 * JD-Core Version:    0.7.0.1
 */