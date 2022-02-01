import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class afin
  implements View.OnClickListener
{
  afin(afim paramafim) {}
  
  public void onClick(View paramView)
  {
    agtw.a(this.a.app, this.a.getActivity(), this.a.sessionInfo, 1, false, this.a.app.getCurrentUin(), "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afin
 * JD-Core Version:    0.7.0.1
 */