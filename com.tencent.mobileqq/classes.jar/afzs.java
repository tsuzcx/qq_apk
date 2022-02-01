import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class afzs
  implements View.OnClickListener
{
  afzs(afzr paramafzr) {}
  
  public void onClick(View paramView)
  {
    ahmu.a(this.a.app, this.a.getActivity(), this.a.sessionInfo, 1, false, this.a.app.getCurrentUin(), "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afzs
 * JD-Core Version:    0.7.0.1
 */